/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_10.js
*@FileTitle  :  S/C Proposal Special Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0003_10 : business script for ESM_PRI_0003_10
     */
	// Common Global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array(); 
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var sChgCdVisiable="";	//Charge code list for SHEET
	var amendSaveFlag=false; //To call save message when open conversion after AMEND
	// Event handler processing by button click event 
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					if(validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					break;
				case "btn_save":
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_acceptall":
					if(validateForm(sheetObject2,formObject,MODIFY01)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY01);
					}
					break;
				case "btn_cancelall":
					if(validateForm(sheetObject2,formObject,MODIFY02)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY02);
					}
					break;
				case "btn_glinecopy":
					if(validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					}
					break;
				case "btn_rowadd1":
					if(validateForm(sheetObject1,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject1,formObject,IBINSERT);
					}
					break;
				case "btn_rowadd2":
					if(validateForm(sheetObject2,formObject,IBINSERT)) {
						doActionIBSheet(sheetObject2,formObject,IBINSERT);
					}
					break;
				case "btn_delete1":
					if(validateForm(sheetObject1,formObject,IBDELETE) && doActionIBSheet(sheetObject1,document.form,IBSEARCH_ASYNC05)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "btn_delete2":
					if(validateForm(sheetObject2,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject2,formObject,IBDELETE);
					}
					break;
				case "btn_amend":
					if(validateForm(sheetObject2,formObject,COMMAND01)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND01);
					}
					break;
				case "btn_amendcancel":
					if(validateForm(sheetObject2,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject2,formObject,COMMAND02);
					}
					break;
				case "btn_accept":
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY03);
					}
					break;	
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObject2,formObject,MODIFY04);
					}
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
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
    * @return N/A
    * @author 
    * @version 2009.10.28
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
     * @return N/A
     * @author 
     * @version 2009.05.17
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
        buttonControl();
        parent.loadTabPage();
	}
   /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
				       
				      var HeadTitle="|Sel.|Seq.|dp_seq|Item|Title|note_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq||||";
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
				             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:700,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:500 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dp_fix_flg" } ];
				       
				      InitColumns(cols);
				      SetWaitImageVisible(0);
				      SetColProperty("note_clss_cd", {ComboText:noteClssCdComboText, ComboCode:noteClssCdComboValue} );
				      //SetAutoRowHeight(0);
				      SetSheetHeight(140);
		      }


				break;
             case "sheet2":
            	    with(sheetObj){
		                 
		               var HeadTitle="|Sel.|dp_seq|Seq.|Surcharge|Content|Content|Conversion|Conversion|EFF Date|EXP Date|Source|Status" +
		               "|note_seq|note_ctnt_seq|note_tp_cd|svc_scp_cd|prop_no|amdt_seq|Mapping ID|prev_note_conv_mapg_id" +
		               "|note_chg_tp_cd|n1st_cmnc_amdt_seq|action_mode|bef_eff_dt|bef_exp_dt";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
		                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
		                      {Type:"Combo", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                      {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Popup",     Hidden:0, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"note_ctnt_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"DummyCheck", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
		                      {Type:"Popup",     Hidden:0, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"note_conv_mapg_id_pop",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"action_mode" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bef_eff_dt" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bef_exp_dt" } ];
		                
		               InitColumns(cols);
		               SetWaitImageVisible(0);
		               SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
		               SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
		               SetColHidden("chg_cd",1);
		               //SetAutoRowHeight(0);
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(170);
               }


           break;
         }
     }
	
	 function resizeSheet() {
 	 	ComResizeSheet(sheetObjects[1]);
 	 }
	 
	var isFiredNested=false;
	var supressConfirm=false;
   /**
    * Calling function in case of clicking sheet's row<br>
    * Retrieving child-sheet by selected row. <br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM Mandatory HTML TAG(Object) Object
    * @param {ibsheet} sheetD Mandatory HTML TAG(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @param {string} appendRow Mandatory ,Appendable
    * @return N/A
    * @author 
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested=true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				formObj.note_seq.value=sheetM.GetCellValue(adjNewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
	
	var isFireChkCol = true;
	
    /**
    * Handling Sheet's process <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,process constant variable
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
  	function doActionIBSheet(sheetObj, formObj, sAction) {
  		try {
	  		sheetObj.ShowDebugMsg(false);
	  		switch (sAction) {
	  			case IBSEARCH: 
	  				ComOpenWait(true);
	  				if(sheetObjects[0].RowCount()> 0) {
		  				for (var i=0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}
	  				}
	  				sheetObj.ClearHeaderCheck();
					formObj.f_cmd.value=SEARCH01;
					formObj.note_tp_cd.value="P";
					sheetObj.DoSearch("ESM_PRI_0003_10GS.do", FormQueryString(formObj), {Sync:2} );
	  				break;
	  			case IBSEARCHAPPEND: 
					ComOpenWait(true);
		  			//Setting InitDataCombo by combining code not existing in charge code list
					var sCd=sheetObj.GetComboInfo(0,"chg_cd","Code");
					var sNm=sheetObj.GetComboInfo(0,"chg_cd","Text");
					////////////////////////////////////////////////////////////////////////////////
	  				formObj.f_cmd.value=SEARCH02;
	  				formObj.note_tp_cd.value="P";
	  				var sXml=sheetObj.GetSearchData("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
	  				var arrData=ComPriXml2Array(sXml, "chg_cd");			
					if (arrData != null && arrData.length > 0) {
						for(var i=0; i<arrData.length; i++){
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}					
						sheetObj.SetColProperty(4, {ComboText:sNm , ComboCode:sCd} );
					}
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					manageMasterChange(sheetObjects[0], sheetObjects[0].GetSelectRow(), null);
	  				break;
	  			case IBSAVE: 
	  				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	  				/* Can't save if no data in conversion in case of DEM/DET*/
					var dmtYN=false;
					for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
						if(sheetObj.GetCellValue(i, "note_clss_cd") == "D" && sheetObj.GetRowStatus(i) != "D") {
							//Can't save if there is no 'AD' in content's source in case of Title= DEM/DET
							for(var j=sheetObjects[1].HeaderRows(); j <= sheetObjects[1].LastRow(); j++) {
								if(sheetObjects[1].GetCellValue(j, "amdt_seq") == formObj.amdt_seq.value && sheetObjects[1].GetCellValue(j, "src_info_cd") != "AD") {
									dmtYN=true;
									break;
								}
							}
							break;
						}
					}			
					if(dmtYN) {
						var count=getDmtScExptGrpCount();
						if(count < 1) {
							ComShowCodeMessage("PRI01090");
							return false;
						}
					}
	  			    if (!supressConfirm && !ComPriConfirmSave()) {
	  					return false;
	  				}
	  				ComOpenWait(true);
	  			    ////////////////////////////////////////////////////////////////////////////////////
	  				// Setting DP_SEQ
	  			    // Don't changing DEP_SEQ in case of data having AMEND 
	  			    var tRow=sheetObjects[0].FindStatusRow("I|D");
	  			    var tStatus=tRow.split(";");
	  			    if(tStatus.length > 0) {
				    	//SEQ-1의 DP_SEQ MAX값 
		  			    formObj.f_cmd.value=SEARCH03;
		  			    var sXml="";
		  			    //Due to prepare a case which can't get DP_SEQ, using Loop
		  				for (var i=0, n=10 ; i < n ; i++) {
		  					sXml=sheetObj.GetSearchData("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				//Getting previous SEQ's MAX value
						var maxDpSeq=parseInt(ComGetEtcData(sXml,"TITLE_MAX_DP_SEQ"),10);
						for(var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
							if(sheetObjects[0].GetCellValue(i, "dp_fix_flg") != "Y" && sheetObjects[0].GetRowStatus(i) != "D") {
								maxDpSeq ++;
								sheetObjects[0].SetCellValue(i, "dp_seq",maxDpSeq,0);
							}
			  			}
	  			    }
	  			    var cRow=sheetObjects[1].FindStatusRow("I|D");
				    var cStatus=cRow.split(";");
				    if(cStatus.length > 0) {
				    	//SEQ-1's DP_SEQ MAX value
		  			    formObj.f_cmd.value=SEARCH04;
		  			    formObj.note_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
		  			    var sXml="";		  				
		  				for (var i=0, n=10 ; i < n ; i++) {
		  					sXml=sheetObj.GetSearchData("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
		  					if(sXml != "") {
		  						break;
		  					}
		  				}
		  				//Getting previous SEQ's MAX value
						var maxDtlDpSeq=parseInt(ComGetEtcData(sXml,"CONTENT_MAX_DP_SEQ"),10);
						for(var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
							if(sheetObjects[1].GetCellValue(i, "prev_note_conv_mapg_id") == "" && sheetObjects[1].GetRowStatus(i) != "D") {
								maxDtlDpSeq ++;
								sheetObjects[1].SetCellValue(i, "dp_seq",maxDtlDpSeq,0);
							}
			  			}
				    }
				    /////////////////////////////////////////////////////////////////////////////////////
	  				formObj.f_cmd.value=MULTI01;
	  				formObj.note_tp_cd.value="P";
	  				var sParam=FormQueryString(formObj);
	  				var sParamSheet1=sheetObjects[0].GetSaveString();
	  				if (sParamSheet1 != "") {
	  					sParam=sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	  				}
	  				var sParamSheet2=sheetObjects[1].GetSaveString();
	  				if (sParamSheet2 != "") {
	  					sParam=sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	  				}
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_10GS.do", sParam);
 	  				sheetObjects[1].LoadSaveData(sXml);
	  				sXml=ComDeleteMsg(sXml);
 	  				sheetObjects[0].LoadSaveData(sXml);
	  				formObj.master_del_chk.value="N";
	  				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
	  					return false;
	  				} else {
	  					if (getValidRowCount(sheetObjects[1]) <= 0) {
	  						doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), false);
						}
	  					doActionIBSheet( sheetObj , formObj , IBSEARCH );
	  					return true;
	  				}
	  				break;
	  			case IBINSERT: // Row Add
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					var amdt_seq=formObj.amdt_seq.value;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					formObj.master_del_chk.value="N";				
					if (sheetObj.id == "sheet1") {
						var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
						sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
						sheetObj.SetCellValue(idx, "note_seq",parseInt(ComPriGetMax(sheetObj, "note_seq")) + 1,0);
						sheetObj.SetCellValue(idx, "note_tp_cd","P",0);//special
						sheetObj.SelectCell(idx, "note_clss_cd");
						sheetObjects[1].RemoveAll();
					}
					if (sheetObj.id == "sheet2") {
						if(sheetObjects[0].RowCount()==0){
							ComShowCodeMessage("PRI01004");
							return;							
						}
						//Creating MAPPING ID
						var sNoteConvMapgId=getSYSGUID();		
						if(sNoteConvMapgId == "" || sNoteConvMapgId == null || sNoteConvMapgId == undefined) {
							return;
						}
						if(amdt_seq == 0){
							var idx=sheetObj.DataInsert();
							sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
							sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							var note_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
							sheetObj.SetCellValue(idx, "note_seq",note_seq,0);
							sheetObj.SetCellValue(idx, "note_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "note_tp_cd","P",0);//special
							sheetObj.SetCellValue(idx, "note_conv_mapg_id",sNoteConvMapgId,0);
							if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "S") {
								sheetObj.SelectCell(idx, "chg_cd");
							} else {
								sheetObj.SelectCell(idx, "note_ctnt");
							}
							sheetObj.SetCellBackColor(idx,"note_ctnt","#FFFFFF");
							sheetObj.SetCellEditable(idx,"note_conv_flg",0);
						}else{
							if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
								ComShowCodeMessage("PRI01002");
							 	return;
							}							
							var idx=sheetObj.DataInsert();	   // new row
							sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
							sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							var note_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_seq");
							sheetObj.SetCellValue(idx, "note_seq",note_seq,0);
							sheetObj.SetCellValue(idx, "note_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "note_ctnt_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "note_tp_cd","P",0);//special
							sheetObj.SetCellValue(idx, "note_conv_mapg_id",sNoteConvMapgId,0);
							if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "S") {
								sheetObj.SelectCell(idx, "chg_cd");
							} else {
								sheetObj.SelectCell(idx, "note_ctnt");
							}
 							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
							sheetObj.SetCellBackColor(idx,"note_ctnt","#FFFFFF");
							sheetObj.SetCellEditable(idx,"note_conv_flg",0);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
						}
						sheetObj.SetCellEditable(idx,"note_conv_mapg_id_pop",1);
						//changing MASTER color
						manageMasterColor(sheetObjects[0], sheetObjects[1]);
					}
	  				break;
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}				
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
					////////////////////////////////////////////////////
					if (sheetObj.id == "sheet1") {
						if(amdt_seq=="0"){
							if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
				        	var delCnt=deleteRowCheck(sheetObj, "chk");
				        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
							}
						} else {
							for(var i=0;i < chkArr.length;i++){
								//Amend data exists either src_info_cd is NW
								if(sheetObj.GetCellValue(chkArr[i], "src_info_cd") != "NW") {
									//Saving columns to be modified to master temporarly when amending in detail . and then applying detail in server
									sheetObj.SetCellValue(chkArr[i], "src_info_cd","AD",0);
									sheetObj.SetCellValue(chkArr[i], "prc_prog_sts_cd","I",0);
									////////////////////////////////////////////////////////
									sheetObj.SetCellValue(chkArr[i], "chk","0",0);
									sheetObj.SetRowStatus(chkArr[i],"U");
									////////////////////////////////////////////////////////
 									sheetObj.SetCellFont("FontStrike", chkArr[i], 1, chkArr[i], sheetObj.LastCol(), true);
 									sheetObj.SetCellFont("FontColor", chkArr[i], 1, chkArr[i], sheetObj.LastCol(),"#FF0000");
								}
							}
							////////////////////////////////////////////////////////////////
							isFireChkCol = false;
							sheetObjects[1].CheckAll("chk","1",1);
							isFireChkCol = true;
							var chkArrDtl=ComPriSheetCheckedRows(sheetObjects[1], "chk");
							for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
								if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i]),"n1st_cmnc_amdt_seq") == amdt_seq
										&& (sheetObjects[1].GetCellValue(Number(chkArrDtl[i]),"src_info_cd") == "AM" )){
			  						//1. Saving MAPPING ID to TEMP temporarily in order to roll back CONVERSION's data
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])-1, "note_conv_mapg_id",sheetObjects[1].GetCellValue(Number(chkArrDtl[i]), "note_conv_mapg_id"),0);
			  						//2. AMEND CANCEL
						    		comSheetAmendCancelRow(sheetObjects[1],formObj,Number(chkArrDtl[i]),"M", "note_ctnt");
						    		sheetObjects[1].SetCellEditable(Number(chkArrDtl[i])-1, "chk",1);
								}
						    }
							//AMEND DELETE NOT AMENDED DATA
							isFireChkCol = false;
							sheetObjects[1].CheckAll("chk","1",1);
							isFireChkCol = true;
							var chkArrDtl=ComPriSheetCheckedRows(sheetObjects[1], "chk");
							var sRow=0;
						    for(var i=0; chkArrDtl != null && i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
						    		//AMEND DELETE
									comSheetAmendRow(sheetObjects[1],formObj,Number(chkArrDtl[i])+sRow,"D","note_ctnt");
						    		sRow++;	
						    		sheetObjects[1].SetCellValue(Number(chkArrDtl[i])+sRow, "note_conv_flg","0",0);
						    	} else if(sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"n1st_cmnc_amdt_seq")==amdt_seq
						    			&& (sheetObjects[1].GetCellValue(Number(chkArrDtl[i])+sRow,"src_info_cd") == "AD" )) {
									sheetObjects[1].SetCellValue(Number(chkArrDtl[i])+Number(sRow), "chk","0",0);
								}
						    }
						    //
						    ///////////////////////////////////////////////////////////////////
							deleteRowCheck(sheetObjects[1], "chk");	
							if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
				        	var delCnt=deleteRowCheck(sheetObj, "chk");
				        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
							}
						}
						//Flag to check deleting in MASTER
						//Using at server
						formObj.master_del_chk.value="Y";
					} else if (sheetObj.id == "sheet2") {
						if(amdt_seq=="0"){
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "I"){
									//comChangeValue(sheetObj, "chk", "0", "chk", "1");
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
							deleteRowCheck(sheetObj, "chk", true);		
						} else {
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq
										||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq &&
												(sheetObj.GetCellValue(chkArr[i],"src_info_cd") =="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "I"))){
									//comChangeValue(sheetObj, "chk", "0", "chk", "1");
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
							var sRow=0;
							for(var i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(Number(chkArr[i])+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									//AMEND DELETE
									comSheetAmendRow(sheetObj,formObj,Number(chkArr[i])+sRow,"D","note_ctnt|note_ctnt_pop");
						    		sRow++;	
						    		sheetObj.SetCellValue(Number(chkArr[i])+sRow,"note_conv_flg","0",0);
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
						formObj.master_del_chk.value="N";
					}
					//Check in case all row's detail is deleted
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00020')){
			  				ComOpenWait(true);
							sheetObjects[0].CheckAll("chk",0,1);
							sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "chk","1",0);
							if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
							var delCnt=deleteRowCheck(sheetObjects[0], "chk");
							if (delCnt > 0 && sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
							}
						}
					}
					//Conversion Delete 
					manageConvButton (sAction);
					//Changing MASTER color
					manageMasterColor(sheetObjects[0], sheetObjects[1]);
					break;
	  			case MODIFY01: // Accept All
		  			if(ComShowCodeConfirm("PRI01015")) {
		  				var amdtSeq=formObj.amdt_seq.value;
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "A", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "I|"+amdtSeq);
		  				ComOpenWait(true);
		  				formObj.f_cmd.value=MULTI02;
		  				var sParam=FormQueryString(formObj);
 		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_10GS.do", sParam);
 		  				sheetObj.LoadSaveData(sXml);
					}
	  				break;
	  			case MODIFY02: // Cancel All
		  			if(ComShowCodeConfirm("PRI01010")) {
		  				var amdtSeq=formObj.amdt_seq.value;
		  				comChangeValue(sheetObj, "prc_prog_sts_cd", "I", "prc_prog_sts_cd|n1st_cmnc_amdt_seq", "A|"+amdtSeq);
		  				ComOpenWait(true);
		  				formObj.f_cmd.value=MULTI03;
		  				var sParam=FormQueryString(formObj);
 		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_10GS.do", sParam);
 		  				sheetObj.LoadSaveData(sXml);
					}
	  				break;			
	  			case MODIFY03: // Accept
		  			if(ComShowCodeConfirm("PRI00008")) {
		  				formObj.f_cmd.value=MULTI04;
		  				comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0003_10GS.do");
		  			}
	   				break;	
	  			case MODIFY04: // Accept Cancel
	  				if(ComShowCodeConfirm("PRI00009")) {	
	  					formObj.f_cmd.value=MULTI05;
		  				comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_10GS.do");
	  				}
	  				break;			
	  			case COMMAND01: // Amend
	  				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{
	  						var trueYN=comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","note_ctnt");
	  						if(trueYN) {
	  							//Changing MASTER color
	  							manageMasterColor(sheetObjects[0], sheetObjects[1]);
	  							//Delete Conversion
	  							manageConvButton (sAction);
	  	  					}
	  					}
	  				}else{ 
	  					var trueYN=comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","note_ctnt");
	  					if(trueYN) {
							//Changing MASTER color
							manageMasterColor(sheetObjects[0], sheetObjects[1]);
							//Conversion Delete
							manageConvButton (sAction);
	  					}
	  				}
	  				sheetObj.SelectCell(sheetObj.GetSelectRow(), "note_ctnt", false);
	  				break;			
	  			case COMMAND02: // Amend Cancel
	  				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
	  				if(chkArr.length > 0){
	  					if(chkArr.length > 1){					
	  						ComShowCodeMessage("PRI00310");
	  					}else{	  						
	  						if(sheetObj.GetCellValue(chkArr[0],"prc_prog_sts_cd")!="I"){
								ComShowCodeMessage("PRI01002");
								return;
							}
	  						//1. Saving Mapping ID to temp to roll back conversion's data
	  						sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id"),0);
	  						//2. AMEND CANCEL
	  						var trueYN=comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "note_ctnt");
	  						if(trueYN) {
		  						//Changing MASTER color
		  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
		  						// Conversion Delete & update
		  						manageConvButton (sAction);
	  						}
	  					}
	  				}else{ 
	  					if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"prc_prog_sts_cd")!="I"){
							ComShowCodeMessage("PRI01002");
							return;
						}
	  					var selectedRow = sheetObj.GetSelectRow();
	  					var preAmendRow = selectedRow-1;
						//1. Saving Mapping ID to temp to roll back conversion's data
	  					sheetObj.SetCellValue(preAmendRow, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "note_conv_mapg_id"),0);
						//2. AMEND CANCEL
						var trueYN=comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "note_ctnt");
						manageGetCellEditableOnRow(sheetObj, preAmendRow, selectedRow,  sheetObj.LastCol());
						if(trueYN) {
							  // Changing MASTER color
	  						manageMasterColor(sheetObjects[0], sheetObjects[1]);
	  						//3. Conversion Delete & update
	  						manageConvButton (sAction);
						}
	  				}
	  				break;				
				case IBSEARCH_ASYNC05: 
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//Common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						/* Note Seq - Start  ***********************************************/
						var tNoteSeq="";
						for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
							if(sheetObj.GetCellValue(i, "chk") == "1") {
								tNoteSeq += sheetObj.GetCellValue(i, "note_seq") + ",";
							}
						}						
						tNoteSeq=tNoteSeq.slice(0, -1);
						/* Note Seq - end    ***********************************************/
						formObj.f_cmd.value=SEARCH05;
		  				formObj.note_seq.value=tNoteSeq;
 		  				var sXml=sheetObj.GetSearchData("ESM_PRI_0003_10GS.do", FormQueryString(formObj));
						var arrDesc=ComPriXml2Array(sXml, "note_seq|note_ctnt");
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						var txt="";
						var desc="";
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc=arrDesc[i][0];
						}
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					}
					return true;
					break;	
				/*	
				case IBSEARCH_ASYNC05:
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//Common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						var sParam="f_cmd="+SEARCH05+"&" + sheetObj.GetSaveString(false, false, "chk");
 						var sXml=sheetObj.GetSearchData("ESM_PRI_0003_10GS.do", sParam);
						var arrDesc=ComPriXml2Array(sXml, "note_seq|note_ctnt");
						var rsltCnt=ComPriGetRowCount()FromXML(sXml);
						var txt="";
						var desc="";
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc=arrDesc[i][0];
						}
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					}
					return true;
					break;
				*/		  	
	  		}
  		}catch(e){
  			if (e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e.message);
  			}
  		}finally {
  			 ComOpenWait(false);
  		}
  	}
    /**
    * Calling function in case of OnBeforeCheck event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
    /**
    * Calling function in case of OnBeforeCheck event  <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */	
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk" && isFireChkCol) {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
    /**
    * Calling function in case of OnClick event <br>
    * Highlighting selected row of sheet <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML TAG(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.05.19
    */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
// 			changeSelectBackColor4Master(sheetObj, document.form);
		}
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
    /**
     * Calling function in case of OnSelectCell event <br>
     * SEtting amended row's highlight color<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, previous selected Cell's Row Index
     * @param {int} OldCol Mandatory, previous selected Cell's Column Index
     * @param {int} NewRow Mandatory, current selected Cell's Row Index
     * @param {int} NewCol Mandatory, current selected Cell's Column Index
     * @return N/A
     * @author 
     * @version 2009.04.17
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    } 
    /**
     * Calling function in case of OnClick event <br>
     * Displaying memo pad when saving address<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} Row Mandatory OnClick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value Mandatory
     * @return N/A
     * @author 
     * @version 2009.06.18
     */
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
 	    //MemoPad editable : true
 	    var formObj=document.form;
 	    var colname=sheetObj.ColSaveName(Col);
 	    var amdtSeq=formObj.amdt_seq.value;
 	    var propStsCd=formObj.prop_sts_cd.value;
      	switch(colname)
      	{
      		case "note_ctnt":
	    		sheetObj.SetCellEditable(Row,"note_ctnt",0);
	    		if(propStsCd == "I" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") == "I"){
		    		if (amdtSeq == 0){
		    			sheetObj.SetCellBackColor(Row,"note_ctnt","#FFFFFF");
		    			readOnly=false; 	    			
		    		}
		    		else if(sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
		    			if (sheetObj.GetCellValue(Row , "src_info_cd") != "AD"){
							if (propStsCd =="I"){
								readOnly=false;
								sheetObj.SetCellBackColor(Row,"note_ctnt","#FFFFFF");
							}else{
								readOnly=true;
								sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
							}						
						}else{// Prohibiting from modifying in case of src_info_cd=AD
							readOnly=true;
							sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
						}
					}else{
						readOnly=true;
						sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
					}
	    		} else {
	    			readOnly=true;
	    			sheetObj.SetCellBackColor(Row,"note_ctnt",-1);
	    		}
	    		var memoColWidth = 	sheetObj.GetColWidth("note_ctnt") +
						    		sheetObj.GetColWidth("note_ctnt_pop") +
						    		sheetObj.GetColWidth("note_conv_flg") +
						    		sheetObj.GetColWidth("note_conv_mapg_id_pop") +
						    		sheetObj.GetColWidth("eff_dt") +
						    		sheetObj.GetColWidth("exp_dt") +
						    		sheetObj.GetColWidth("eff_dt") +
						    		sheetObj.GetColWidth("exp_dt") +
						    		sheetObj.GetColWidth("src_info_cd");
	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 12);
	    		break;      	
      	}
	}    
     
    function tmp_object(sheet, row){
 		this.row = row;
 		this.sheet = sheet;
 	}
 	var G_TMP_OBJECT;
 	
    /**
    * Calling function in case of OnPopupClick event <br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.07
    */ 
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
  		var effDt=formObj.eff_dt.value;
  		var expDt=formObj.exp_dt.value;
  		var propStsCd=formObj.prop_sts_cd.value;
  		var convCfmFlg="";
  		G_TMP_OBJECT = new tmp_object(sheetObj, Row);
  		
		if (colName == "note_ctnt_pop") {
			var sParam=FormQueryString(formObj);
			var sUrl="ESM_PRI_0089.do?" + sParam;
			sUrl += "&note_clss_cd=" + sheetObjects[0].GetCellValue( sheetObjects[0].GetSelectRow(), "note_clss_cd");
			sUrl += "&chg_cd=" + sheetObj.GetCellValue(Row, "chg_cd");
			ComOpenPopup(sUrl, 600, 430, "note_ctnt_pop_returnVal", "1,0", true);
			
		}
		if (colName == "note_conv_mapg_id_pop") {	
			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "D") {
				ComPriOpenPopup('EES_DMT_2001.do?prop_no=' + formObj.prop_no.value + '&caller=000310', 1280, 700, 'note_conv_mapg_id_pop_returnVal', "0,1", false);
			} else {
				if((amendSaveFlag && sheetObj.IsDataModified())) {
					var rslt=false;
					if (ComShowCodeConfirm("PRI00006")) {
						supressConfirm=true;
						rslt=doActionIBSheet(sheetObj,document.form,IBSAVE);
						supressConfirm=false;
					}
					if (rslt) {
						amendSaveFlag=false;
					} else {
						return false;
					}
				}
				if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id"))) {
					var sParam="";
					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
					sParam += "&prop_no=" + formObj.prop_no.value;
					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + encodeURIComponent(sheetObj.GetCellValue(Row, "note_conv_mapg_id"));
					sParam += "&note_seq=" + sheetObj.GetCellValue( Row, "note_seq");
					sParam += "&note_ctnt_seq=" + sheetObj.GetCellValue( Row, "note_ctnt_seq");
					sParam += "&note_tp_cd=" + sheetObj.GetCellValue( Row, "note_tp_cd");
					sParam += "&eff_dt=" + sheetObj.GetCellValue( Row, "eff_dt");
					sParam += "&exp_dt=" + sheetObj.GetCellValue( Row, "exp_dt");;
					sParam += "&master_seq=" + sheetObjects[0].GetSelectRow();
					sParam += "&detail_seq=" + sheetObjects[1].GetSelectRow();
					sParam += "&prop_sts_cd=" + formObj.prop_sts_cd.value;
					var sUrl="/opuscntr/ESM_PRI_0032.do?"+sParam;			
					ComOpenPopup(sUrl, 1040, 630, "note_conv_mapg_id_pop_returnVal", "0,1", false);
				} else {
					ComShowCodeMessage("PRI08015");
				}
			}
		}
    }
	
	function note_ctnt_pop_returnVal(rtnVal) {
		var sheetObj = G_TMP_OBJECT.sheet;
		if (rtnVal != null) {
        	if (rtnVal.ctnt != null && rtnVal.ctnt != "" && rtnVal.ctnt != undefined) {
        		sheetObj.SetCellValue(G_TMP_OBJECT.row, "note_ctnt", rtnVal.ctnt,0);
        	}
        	if (rtnVal.chgcd != null && rtnVal.chgcd != "" && rtnVal.chgcd != undefined) {
        		if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "S") {
        			sheetObj.SetCellValue(G_TMP_OBJECT.row, "chg_cd", rtnVal.chgcd,0);
        		}
        	}
        }
	}
	
	function note_conv_mapg_id_pop_returnVal(rtnVal) {
		var sheetObj = G_TMP_OBJECT.sheet;
		if(rtnVal != null && rtnVal.length > 0) {						
			for(var i=0; i < rtnVal.length; i++) {
				for(var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
					if(sheetObj.GetCellValue(j, "note_seq") == rtnVal[i].master_seq
							&& sheetObj.GetCellValue(j, "note_ctnt_seq") == rtnVal[i].detail_seq
							&& sheetObj.GetCellValue(j, "amdt_seq") == rtnVal[i].amdt_seq ) {
						//2015.06.22 note값을 받으면 수정되야 한다. 
						//GetRowStatus는 기데이터가 R일때 cnote만 팝업에 의해 수정될시 수정상태가 되지않고 계속 R이된다(잘못된코드)
						//var prevStatus=sheetObj.GetRowStatus(j);
						sheetObj.SetCellValue(j, "note_conv_flg", rtnVal[i].note_conv_flg, 1);
						sheetObj.SetCellValue(j, "note_chg_tp_cd", rtnVal[i].note_chg_tp_cd, 1);
						sheetObj.SetCellValue(j, "note_ctnt", rtnVal[i].cnote, 1);
						//sheetObj.SetRowStatus(j, prevStatus);
					}
				}
			}
		}
		
	}
	
	/**
	 * ESM_PRI_0032.js에서 호출<br>
	 * after modify the SPECIAL NOTE, call save and search 
	 * 
	 * @param N/A
	 * @author 
	 * @version 2015.06.22
	 */
	function doSaveNote() {
		var sheetObj = G_TMP_OBJECT.sheet;
		if(sheetObj.IsDataModified()) {
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
		}
	}
	
	   /**
	    * Calling function in case of Onchange Event <br>
	    * Showing description when selecting Multi ComboBox <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
	    * @param {int} Row Mandatory Onclick ,Cell's Row Index
	    * @param {int} Col Mandatory Onclick ,Cell's Column Index
	    * @param {string} Value Mandatory ,Cell's Value
	    * @return N/A
	    * @author 
	    * @version 2009.04.17
	    */  
		function sheet1_OnChange(sheetObj, Row, Col, Value) {
			var colName=sheetObj.ColSaveName(Col);
			var formObj=document.form;
			var reqUsrFlg=formObj.req_usr_flg.value;
			var aproUsrFlg=formObj.apro_usr_flg.value;
			var propStsCd=formObj.prop_sts_cd.value;
			if (colName == "note_clss_cd") {
				for(var i=1; i<= sheetObjects[1].RowCount(); i++) {
					var rowStatus=sheetObjects[1].GetRowStatus(i);
					sheetObjects[1].SetCellValue(i,"chg_cd","",0);
					sheetObjects[1].SetRowStatus(i,rowStatus);
				}
				if (Value == "S") {
	 				sheetObjects[1].SetColHidden("chg_cd",0);
	 				sheetObjects[1].SetColProperty(0, "chg_cd", {KeyField:1});
				} else {
					sheetObjects[1].SetColHidden("chg_cd",1);
					sheetObjects[1].SetColProperty(0, "chg_cd", {KeyField:0});
				}
				if(Value == "O") {
					sheetObj.SetCellValue(Row,"note_tit_nm","",0);
				} else {
					sheetObj.SetCellValue(Row,"note_tit_nm",sheetObj.GetCellText(Row, "note_clss_cd"),0);
				}
				if(propStsCd != "I") {
				  	sheetObj.SetCellEditable(Row,"note_clss_cd",0);
					sheetObj.SetCellEditable(Row,"note_tit_nm",0);
				}
				if (Value == "D") {
					for(var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()>0 && i<= sheetObjects[1].LastRow(); i++) {
						if(sheetObjects[1].GetCellValue(i,"note_conv_flg") == "1") {
							ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_clss_cd","",0);
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_tit_nm","",0);
							sheetObj.SelectCell(sheetObj.GetSelectRow(), "note_clss_cd");
							return false;
						}
					}
				}
				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
					var iValue=sheetObj.GetCellValue(i, "note_clss_cd");
					if(sheetObj.GetRowStatus(i) == "D") {
						continue;
					}
					for(var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
						if(sheetObj.GetRowStatus(j) == "D") {
							continue;
						}
						var jValue=sheetObj.GetCellValue(j, "note_clss_cd");
						if(i != j) {
							if(iValue == jValue && iValue != "O") {
								ComShowCodeMessage("PRI00303", "Sheet1", sheetObj.GetSelectRow());
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_clss_cd","",0);
								sheetObj.SetCellValue(sheetObj.GetSelectRow(), "note_tit_nm","",0);
								sheetObj.SelectCell(sheetObj.GetSelectRow(), "note_clss_cd");
								return false;
							}
						}
					}
				}
			}
		}
	   /**
	    * Calling function in case of Onchange Event <br>
	    * Retrieving code value from server in case of no code in COMMBO list<br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
	    * @param {int} Row Mandatory Onclick ,Cell's Row Index
	    * @param {int} Col Mandatory Onclick ,Cell's Column Index
	    * @param {string} Value Mandatory ,Cell's Value
	    * @return N/A
	    * @author 
	    * @version 2009.04.17
	    */  
	    function sheet2_OnChange(sheetObj, Row, Col, Value) {
			var colName=sheetObj.ColSaveName(Col);
			var formObj=document.form;
			switch(colName)
	    	{
				case "chg_cd":					
					if (Value != null && Value != "" && Value.length == 3) {
						var sCode=sheetObj.GetComboInfo(0, "chg_cd", "Code");
						var sText=sheetObj.GetComboInfo(0, "chg_cd", "Text");
						if (sChgCdVisiable.indexOf("|"+Value) < 0) {
							formObj.f_cmd.value=COMMAND09;
 							sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
							var arrData=ComPriXml2Array(sXml, "cd|nm");
							if (arrData != null && arrData.length > 0) {
								sCode += "|" + Value;
								sText += "|" + Value;
								sheetObj.SetColProperty("chg_cd", {ComboText:sText , ComboCode:sCode} );
								ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
							} else {
								sheetObj.SetCellValue(Row, "chg_cd","",0);
							}
						}
					} else {
						sheetObj.SetCellValue(Row, "chg_cd","",0);
					}
					break;
	    	}
		}
  	    /**
 	     * Calling function in case of OnSaveEnd Event <br>
 	     * Displaying Save confirmation message in case of sucessful saving <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     * 
 	     * </pre>
 	     * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	     * @param {string} ErrMsg Mandatory from server
 	     * @return N/A
 	     * @author 
 	     * @version 2009.06.22
 	     */ 		
 	   	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
 	    	var formObj=document.form;
 	    	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 	    		var rowStatus=sheetObj.GetRowStatus(i);
 	    		sheetObj.SetCellValue(i, "action_mode","",0);
 	    		sheetObj.SetRowStatus(i,rowStatus);
 	    	}
			parent.comUpdateProposalStatusSummary("32", formObj.svc_scp_cd.value);	
 		}
		/**
	     * Handling detail's screen when selecting master's row<br>
	     * <br><b>Example :</b>
	     * <pre>
	     * manageMasterChange(sheetObj, Row, Col);
	     * </pre>
	     * @param {ibsheet} sheetObj Mandatory IBSheet Object
	     * @param {int} Row Mandatory Onclick ,Cell's Row Index
	     * @param {int} Col Mandatory Onclick ,Cell's Column Index
	     * @return N/A
	     * @author 
	     * @version 2009.05.20
	     */ 
	    function manageMasterChange(sheetObj, Row, Col) {
	    	var noteClssCd=sheetObj.GetCellValue(Row, "note_clss_cd");
			var formObj=document.form;
			var propStsCd=formObj.prop_sts_cd.value;
			var reqUsrFlg=formObj.req_usr_flg.value;
			var aproUsrFlg=formObj.apro_usr_flg.value;
			//Showing surcharge item on detail screen in case of selecting surcharge in master's item category
			if(noteClssCd == "S") {
				sheetObjects[1].SetColHidden("chg_cd",0);
				sheetObjects[1].SetColProperty(0, "chg_cd", {KeyField:1});
			} else {
				sheetObjects[1].SetColHidden("chg_cd",1);
				sheetObjects[1].SetColProperty(0, "chg_cd", {KeyField:0});
			}
			if(propStsCd != "I") {
			  	sheetObj.SetCellEditable(Row,"note_clss_cd",0);
				sheetObj.SetCellEditable(Row,"note_tit_nm",0);
			}
		}
     /**
      * handling process for input validation <br>
      * <br><b>Example :</b>
      * <pre>
      *     if (validateForm(sheetObj,document.form,IBSAVE)) {
      *     }
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {form} formObj Mandatory html form object
      * @param {int} sAction Mandatory ,process constant variable
      * @returns bool <br>
      *          true  : Valid<br>
      *          false : Invalid
      * @author 
      * @version 2009.04.17
      */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSEARCHAPPEND:
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSAVE: 
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
					ComShowCodeMessage("PRI00319", "Special Note");
				return false;
			}
//			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06)){
//				return false;				
//			}			
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}			
			break;
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}
			break;
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			break;
		case IBCOPYROW: //g/l copy
			if(sheetObjects[0].RowCount()> 0) {
				return false;
			}
			break;
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
		case MODIFY03: // Accept
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
		case MODIFY04: // Accept cancel
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
  		case COMMAND01: // Amend	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
  		case COMMAND02: // Amend Cancel	
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSEARCH_ASYNC05:
			return true;
			break;	
//		case IBSEARCH_ASYNC06: 
//			return true;
//			break;			
		}
		return true;
	}
 	/**
     * Calling function in case of clicking tab on parent screen <br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sPreAmdtSeq Mandatory pre_amdt_seq 
     * @param {string} sPropStsCd Mandatory pro_sts_cd 
     * @param {string} sEffDt Mandatory eff_dt 
     * @param {string} sExpDt Mandatory exp_dt 
     * @param {string} sPreExpDt Mandatory pre_exp_dt 
     * @return N/A
     * @author 
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
		var formObject=document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
			formObject.prop_no.value=sPropNo;
			formObject.amdt_seq.value=sAmdtSeq;
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.pre_amdt_seq.value=sPreAmdtSeq; 
			formObject.prop_sts_cd.value=sPropStsCd; 
			formObject.eff_dt.value=sEffDt;
			formObject.exp_dt.value=sExpDt;
			formObject.pre_exp_dt.value=sPreExpDt ;
			formObject.req_usr_flg.value=sIsReqUsr ;
			formObject.apro_usr_flg.value=sIsAproUsr ;
 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
 			formObject.dur_dup_flg.value="Y" ;
			//SURCHARGE
			initComboChargeCode(sheetObjects[1], formObject);
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			buttonControl();
		}
	}
	/**
     * Clearing controls of tab screen on parent screen <br>
     * <br><b>Example :</b>
     * <pre>
     * tabClearSheet()
     * </pre>
     * @param N/A
     * @return N/A
     * @author 
     * @version 2009.05.20
     */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		formObject.pre_amdt_seq.value="";
		formObject.prop_sts_cd.value="";
		formObject.eff_dt.value="";
		formObject.exp_dt.value="";
		formObject.pre_exp_dt.value="";
		formObject.req_usr_flg.value="";
		formObject.apro_usr_flg.value="";
		formObject.lgcy_if_flg .value="";
		formObject.dur_dup_flg.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		buttonControl("CLEAR");
	}
	var enableFlag=true;
	/**
     * Calling from main<br>
     * if Confirmation=YES,Disable to add,modify,delete. <br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from main
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
    /**
    * Setting color by DETAIL's SOURCE CODE<br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return N/A
    * @author 
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
		var row_count = getValidRowCount(sheetD);
    	var formObj=document.form;
    	var amdt_seq=formObj.amdt_seq.value;
		var amend_check=false;
		//ALL AMEND DELETE
		var amend_delete_check=false;
		try {
  			if(row_count > 0){
  				amend_delete_check=true;
	  			for(var i=1 ; i <= row_count; i++){
	  				if(sheetD.GetCellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
	  					if(sheetD.GetCellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check=false;
	  	  				}
	  					if(sheetD.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check=true;
	  	  				}
  					}
	  			}
	  			if(amdt_seq == "0"){
	  				amend_delete_check=false;
	  			}
	  			if(amend_delete_check) {
 	  				sheetM.SetCellFont("FontStrike", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(), true);
 	  				sheetM.SetCellFont("FontColor", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(),"#FF0000");
	  			} else if(amend_check){
 	  				sheetM.SetCellFont("FontStrike", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(), false);
 	  				sheetM.SetCellFont("FontColor", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(),"#FF0000");
	  			} else {
 	  				sheetM.SetCellFont("FontStrike", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(), false);
 	  				sheetM.SetCellFont("FontColor", sheetM.GetSelectRow(), "chk", sheetM.GetSelectRow(), sheetM.LastCol(),"#000000");
	  			}
// 	  			changeSelectBackColor4Master(sheetObjects[0], formObj);
  			}
		}catch(e) {}
	} 
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		 manageGetCellEditable(sheetObj);
		 amendSaveFlag=false;
	 }
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet1_OnSearchEnd(sheetObj, code){
		var formObj=document.form;
		var propStsCd=formObj.prop_sts_cd.value;
   	 	var sLgcyIfFlg=formObj.lgcy_if_flg.value;
		formObj.master_del_chk.value="N";
		if (code == 0 && sheetObj.RowCount()>0) {
			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if(sheetObj.GetCellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
					if(sheetObj.GetCellValue(i,"src_info_cd") == 'AD') {
 						sheetObj.SetCellFont("FontStrike", i, "chk", i, sheetObj.LastCol(), false);
 						sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
					} else if(sheetObj.GetCellValue(i,"src_info_cd") == 'AM' || sheetObj.GetCellValue(i,"src_info_cd") == 'NW') {
 						sheetObj.SetCellFont("FontColor", i, "chk", i, sheetObj.LastCol(),"#FF0000");
					}
					//Item is editable in case of added data with current seq
					if(sheetObj.GetCellValue(i,"src_info_cd") != 'NW') {
						sheetObj.SetCellEditable(i,"note_clss_cd",0);
						sheetObj.SetCellEditable(i,"note_tit_nm",0);
					}
				}
				if(propStsCd != "I") {
				  	sheetObj.SetCellEditable(i,"note_clss_cd",0);
					sheetObj.SetCellEditable(i,"note_tit_nm",0);
				}				
			}
// 			changeSelectBackColor4Master(sheetObj, formObj);
		}
	}
	/**
     * Function to control authority of sheet's CELL<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
     function manageGetCellEditable(sheetObj) {
    	 var formObj=document.form;
    	 var amdtSeq=formObj.amdt_seq.value;
    	 var reqUsrFlg=formObj.req_usr_flg.value;
    	 var aproUsrFlg=formObj.apro_usr_flg.value;
    	 var propStsCd=formObj.prop_sts_cd.value;
    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
    	 var selectedRow = sheetObjects[0].GetSelectRow();
    	 var sRowIdx = sheetObj.HeaderRows();
    	 var eRowIdx = sheetObj.LastRow();
    	 var rowCnt = sheetObj.RowCount();
    	 var eColIdx = sheetObj.LastCol();
    	 var noteClssCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd");
    	 for (var i=sRowIdx; rowCnt> 0 && i <= eRowIdx; i++) {
    		 manageGetCellEditableOnRow(sheetObj, i, selectedRow,  eColIdx);
    	 }
     }
     
     function manageGetCellEditableOnRow(sheetObj, Row, selectedRow, lastColIdx) {
    	 var i = Row;
    	 var formObj=document.form;
    	 var amdtSeq=formObj.amdt_seq.value;
    	 var reqUsrFlg=formObj.req_usr_flg.value;
    	 var aproUsrFlg=formObj.apro_usr_flg.value;
    	 var propStsCd=formObj.prop_sts_cd.value;
    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
    	 var noteClssCd=sheetObjects[0].GetCellValue(selectedRow, "note_clss_cd");
    	 
    	 if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq){
			  sheetObj.SetCellFont("FontStrike", i, "chk", i, lastColIdx, true);
			  sheetObj.SetCellEditable(i,"chk",0);
			  sheetObj.SetCellEditable(i,"note_ctnt",0);
			  sheetObj.SetCellEditable(i,"note_ctnt_pop",0);
			  sheetObj.SetCellEditable(i,"note_conv_flg",0);
			  sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
		  }
		  if(amdtSeq == 0) {
			  sheetObj.SetCellBackColor(i,"note_ctnt","#FFFFFF");
			  sheetObj.SetCellEditable(i,"chg_cd",1);
			  sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
		  } else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
			  	sheetObj.SetCellFont("FontColor", i, "chk", i, lastColIdx,"#FF0000");
			  	if(sheetObj.GetCellValue(i,"src_info_cd") == "NW"){
			  		sheetObj.SetCellEditable(i,"chg_cd",1);
			  	} else {
			  		sheetObj.SetCellEditable(i,"chg_cd",0);
			  	}
				sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
				sheetObj.SetCellBackColor(i,"note_ctnt","#FFFFFF");
		  } else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && amdtSeq > 0){
			  	sheetObj.SetCellEditable(i,"chg_cd",0);
				sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
				sheetObj.SetCellBackColor(i,"note_ctnt","");
		  } 
		  
		  if(sheetObj.GetCellValue(i,"src_info_cd") == "AD" || sheetObj.GetCellValue(i,"prc_prog_sts_cd") != "I") {
			  sheetObj.SetCellEditable(i,"chg_cd",0);
			  sheetObj.SetCellBackColor(i,"note_ctnt","");
			  sheetObj.SetCellEditable(i,"note_ctnt_pop",0);
		  }
		  if(propStsCd != "I") {
			  	sheetObj.SetCellEditable(i,"chg_cd",0);
				sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
				sheetObj.SetCellEditable(i,"note_ctnt_pop",0);
				sheetObj.SetCellBackColor(i,"note_ctnt","");
		  }
 		  //activating in case of DEM/DET
 		  if(noteClssCd == "D"){
 			if(aproUsrFlg=="true" || reqUsrFlg=="true" ){
 				sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",1);
 			} else {
 				sheetObj.SetCellEditable(i,"note_conv_mapg_id_pop",0);
 			}
 		  }
		  sheetObj.SetCellEditable(i,"note_conv_flg",0);
     }
     
  	/**
      * Seperating data by charge rule type when selecting CODE COMBO<br>
      * <br><b>Example :</b>
      * <pre>
      *	insertChargeRuleType(sheetObj);
      * </pre>
      * @param {ibsheet} sheetObj Mandatory IBSheet Object
      * @param {int} Row Mandatory OnClick ,Cell's Row Index
      * @return N/A
      * @author 
      * @version 2009.07.02
      */	
 	function insertChargeRuleType(sheetObj, Row) {
 		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
 		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
 			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
 			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
 			//CHARGE
 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
 			sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
 		} else {
 			//RULE
 			sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
 			sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
 		}
 	}
  	/**
    * Setting default SURCHARGE code <br>
    * Getting surcharge code by SCOPE CODE<br>
    * <br><b>Example :</b>
    * <pre>
    *	initComboChargeCode(sheetObj, formObj);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj	Mandatory form Object
    * @return N/A
    * @author 
    * @version 2009.07.02
    */
	function initComboChargeCode(sheetObj, formObj) {
		var sCd="";
		var sNm="";
		formObj.f_cmd.value=COMMAND12;
 		var tXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
		var arrData=ComPriXml2ComboString(tXml, "cd", "nm");
		if (arrData != null){
		    var arrCode=arrData[0].split("|");
		    var arrName=arrData[1].split("|");
		    var conData="";
		    for(i=0; i < arrName.length;i++){
		        if(i==0){
		            arrName[i]=arrCode[i]+"\t"+arrName[i];
		        }else{
		            arrName[i]="|"+arrCode[i]+"\t"+arrName[i];
		        }
		        conData=conData.concat(arrName[i]);
		    }
		    arrData[1]=conData;
		}
		if (arrData != null){
			sCd=" |" + arrData[0];
			sNm=" |" + arrData[1];			        
		} else {
			sCd=" |";
			sNm=" |";
		}
		sChgCdVisiable=sNm;
		sheetObj.SetColProperty(4, {ComboText:sNm , ComboCode:sCd} );
	}
  	/**
    * Loading SHEET's data to XML
    * <br><b>Example :</b>
    * <pre>
    *	getSheetXml(sheetObj);
    * </pre>
    * @param {int} sheetNo Mandatory IBSheet Object index
    * @return {string} sXml Mandatory xml format
    * @author 
    * @version 2009.07.02
    */	   
    function getSheetXml(sheetNo) {
    	var sXml=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
    
    
    /**
     * Checking whether Proposal Number of DMT S/C EXCEPTION GROUP exists or not<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param N/A
     * @return sValue EtcData
     * @author 
     * @version 2009.08.13
     */       
     function getDmtScExptGrpCount() {
     	var formObj=document.form;
     	formObj.f_cmd.value=COMMAND39;
  		var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
 		var sValue=ComGetEtcData(sXml,"PROP_NO_COUNT");
 		return sValue;
     }
     /**
      * 1. Managing MAPPING ID when AMEND, AMEND CANCEL, DELETE  <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param {int} sAction Mandatory Button Action
      * @return N/A
      * @author 
      * @version 2009.06.22
      */ 
   	 function manageConvButton (sAction) {
   		var sheetObj=sheetObjects[1];
   		var formObj=document.form;
 		var amdtSeq=formObj.amdt_seq.value;
 		var effDt=formObj.eff_dt.value;
 		var expDt=formObj.exp_dt.value;
 		var ibFlag=sheetObj.GetRowStatus(sheetObj.GetSelectRow());
 		if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") == amdtSeq) {
 			if(sAction == COMMAND01 && amdtSeq == sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
 				//AMEND
 				var cStatus=sheetObj.GetRowStatus(sheetObj.GetSelectRow()-1);
 				sheetObj.SetCellValue(sheetObj.GetSelectRow()-1, "note_conv_mapg_id",sheetObj.GetCellValue(sheetObj.GetSelectRow()-1, "prev_note_conv_mapg_id"),0);
 				sheetObj.SetRowStatus(sheetObj.GetSelectRow()-1,cStatus);
 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "action_mode",COMMAND01,0);
 				//CONVERSION POPUP click
 				sheetObj.SetRowEditable(sheetObj.SetSelectRow()-1, 1);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "chk",0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "chg_cd",0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "note_ctnt",0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "note_ctnt_pop",0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "note_conv_flg",0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow()-1, "note_conv_mapg_id_pop",1);
 				amendSaveFlag=true;
 			} else if(sAction == COMMAND02 && amdtSeq != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
 				//AMEND CANCEL
 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "action_mode",COMMAND02,0);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow(), "note_conv_mapg_id_pop",1);
 				sheetObj.SetCellEditable(sheetObj.GetSelectRow(), "chk",1);
 				amendSaveFlag=true;
 			} else if(sAction == IBDELETE) {
 				//AMEND DELETE
 				for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
 					if(sheetObj.GetCellValue(i, "src_info_cd") == "AD" && sheetObj.GetRowStatus(i) == "U" && amdtSeq == sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq")) {
 						var cStatus=sheetObj.GetRowStatus(i-1);
 						sheetObj.SetCellValue(i-1, "note_conv_mapg_id",sheetObj.GetCellValue(i-1, "prev_note_conv_mapg_id"),0);
 						sheetObj.SetRowStatus(i-1,cStatus);
 		 				sheetObj.SetCellValue(i, "action_mode",IBDELETE,0);
 		 				sheetObj.SetCellEditable(i, "note_conv_mapg_id_pop",1);
 		 				sheetObj.SetRowEditable(i-1,1);
 		 				sheetObj.SetCellEditable(i-1, "chk",0);
 		 				sheetObj.SetCellEditable(i-1, "chg_cd",0);
 		 				sheetObj.SetCellEditable(i-1, "note_ctnt",0);
 		 				sheetObj.SetCellEditable(i-1, "note_ctnt_pop",0);
 		 				sheetObj.SetCellEditable(i-1, "note_conv_flg",0);
 		 				sheetObj.SetCellEditable(i-1, "note_conv_mapg_id_pop",1);
 		 				amendSaveFlag=true;
 					}
 				}				
 			}
 		}
   	 }
      /**
        * Returning value to main in order to call saving message when moving tab without saving in case of adding DEM/DET to ITEM<br>
        * <br><b>Example :</b>
        * <pre>
        * getDemDetSaveCheck()
        * </pre>
        * @param N/A
        * @return returnValue 
        * @author 
        * @version 2010.01.13
        */
      function getDemDetSaveCheck() {
    	  var returnValue="Y";
    	  for (var i=sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount()> 0 && i <= sheetObjects[0].LastRow(); i++) {
    		  if((sheetObjects[0].GetRowStatus(i) == "I" || sheetObjects[0].GetRowStatus(i) == "U")
    				  && sheetObjects[0].GetCellValue(i, "note_clss_cd") == "D") {
    			  returnValue="N";
    		  }
    	  }
    	  if (returnValue == "N") {
    		  if (ComShowCodeConfirm("PRI00006")) {
    			  supressConfirm=true;
    			  if (validateForm(sheetObjects[0],document.form,IBSAVE)) {
    				  var rslt=doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
    				  if(rslt) {
            			  returnValue="Y";
            		  }
    			  }
    			  supressConfirm=false;
    		  } else {
    			  returnValue="Y";
    		  }
    	  }
    	  return returnValue;
      }
     /**
      * Returning SYS_GUID() <br>
      * <br><b>Example :</b>
      * <pre>
      * 
      * </pre>
      * @param N/A
      * @return sValue EtcData
      * @author 
      * @version 2009.08.13
      */       
      function getSYSGUID() {
      	var formObj=document.form;
      	formObj.f_cmd.value=COMMAND38;
       	var sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
      	var sValue=ComGetEtcData(sXml,"SYS_GUID");
      	return sValue;
      }
	/**
     * Controlling authority of button<br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl(mode)
     * </pre>
     * @param  {string} mode Mandatory user mode
     * @return N/A
     * @author 
     * @version 2009.04.17
     */
  	function buttonControl(mode){
 		var formObj=document.form;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value;
 		var amdt_seq=formObj.amdt_seq.value;
 		var sts=formObj.prop_sts_cd.value;
 		var row_cnt=sheetObjects[0].RowCount();
 		try{		
 				ComBtnDisable("btn_retrieve");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_acceptall");
				ComBtnDisable("btn_cancelall");
				ComBtnDisable("btn_rowadd1");
				ComBtnDisable("btn_delete1");
				ComBtnDisable("btn_rowadd2");
				ComBtnDisable("btn_delete2");
				ComBtnDisable("btn_accept");
				ComBtnDisable("btn_acceptcancel");
				if(amdt_seq > 0){
					showButton("btn_amend");
					showButton("btn_amendcancel");
					ComBtnDisable("btn_amendcancel");
					ComBtnDisable("btn_amend");
				} else {
					hiddenButton("btn_amend");
					hiddenButton("btn_amendcancel");
				}
				if(mode == "CLEAR") {
					return;
				}
 			switch(sts) {
 				case 'I':   // Initial
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" || req_usr_flg=="true" ){
 						ComBtnEnable("btn_save");
 						ComBtnEnable("btn_rowadd1");
 						ComBtnEnable("btn_delete1");
 						ComBtnEnable("btn_rowadd2");
 						ComBtnEnable("btn_delete2");
 						ComBtnEnable("btn_amend");
 						ComBtnEnable("btn_amendcancel");
 						if(amdt_seq > 0){
 							showButton("btn_amend");
 							showButton("btn_amendcancel");
 						}
 					}				
 					break;
 				case 'Q':   // Requested
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" ){
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}
 					break;
 				case 'R':   // Returned
 	 				ComBtnEnable("btn_retrieve");
 					if(apro_usr_flg=="true" || req_usr_flg=="true" ){
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}				
 					break;
 				case 'A':   // Approved
 	 				ComBtnEnable("btn_retrieve");
 				case 'F':   // Filed
 	 				ComBtnEnable("btn_retrieve");
 				case 'C':   // Cancled
 	 				ComBtnEnable("btn_retrieve");
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
