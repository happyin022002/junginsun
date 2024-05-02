/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_03.js
*@FileTitle  :  S/C Commodity Group Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0003_03 : business script for ESM_PRI_0003_03
     */
 // global variables 
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var askOnce=true;
    var isGrpDel=false;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);						
					break;
				case "btn_acceptall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY01);
					break;
				case "btn_cancelall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY02);
					break;
				case "btn_glinecopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);															
					break;
				case "btn_delete1":
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02) &&
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04)){						
						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);						
					}
					break;
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					applyMasterStyle(sheetObjects[1]);					
					break;
				case "btn_amend":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
					applyMasterStyle(sheetObjects[1]);					
					break;
				case "btn_amendcancel":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
					applyMasterStyle(sheetObjects[1]);										
					break;
				case "btn_accept":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
					applyMasterStyle(sheetObjects[1]);										
					break;	
				case "btn_acceptcancel":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
					applyMasterStyle(sheetObjects[1]);										
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
     * Registering IBSheet Object by array<br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 
     */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding pre-handling function after loading screen on the browser <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 
     */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
        buttonControl();		
        parent.loadTabPage();
	 }
	     
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
			    with(sheetObj){				        
				      if (location.hostname != "")
				      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|Group Code|Description|prc_grp_cmdt_desc_ori|src_info_cd|prc_prog_sts_cd|n1st_cmnc_amdt_seq";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",     KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:420,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",   KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1000 , ExceptKeys:"[/]" },
				             {Type:"Text",      Hidden:1,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc_ori", UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      var CMDT_VALID_CHAR="01234567890 !@#$%^&*()-=\\_+|[]{},.<>?;':`~\"\r\n\t";
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(280);
				      }
				break;
			case "sheet2":
			    with(sheetObj){
				        
				      if (location.hostname != "")
				      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|grp_cmdt_dtl_seq|Code|Description|prc_cmdt_tp_cd|EFF Date|EFF Seq|EXP Date|Source|Status";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_dtl_seq" },
				             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				             {Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_def_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(280);
		      }
				break;
		}
	}
	
	function resizeSheet() {
  	   	ComResizeSheet(sheetObjects[0]);
  		ComResizeSheet(sheetObjects[1]);
  	}
	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		var val=sheetObj.GetCellValue(Row, Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);		
		}
	}
    /**
    * handling event in case of specific cell on the sheet selected <br>
    */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
    /**
     * calling function when occurring OnSelectCell Event <br>
     * showing different color Amend Row's Highlight <br>
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
        }
    }     
    /**
    * calling function when occurring OnChange Event <br> 
    */	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		var sts=sheetObj.GetCellValue(Row, "src_info_cd");
		if (sName == "prc_cmdt_def_cd") {
    		if (Value.length=0){
    			sheetObj.SetCellValue(Row,"cmdt_def_nm","",0);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col,true);
				return;    			
    		}else{	 
    			formObj.f_cmd.value=SEARCH08;
    			//putting '0' in front of COMMODITY CODE
    			var sParam=FormQueryString(formObj) + "&" + "cd=" + ComLpad(Value, 6, "0");
    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
    			var arrDesc=ComPriXml2Array(sXml, "cd|nm");
    			if(arrDesc[0][1]==null||arrDesc[0][1]==""){
					sheetObj.SetCellValue(Row,"cmdt_def_nm","",0);
  					sheetObj.SetCellValue(Row,Col,"",0);
    				sheetObj.SelectCell(Row,Col,true);
    				return;				
    			}    			
    		}		
			sheetObj.SetCellValue(Row, "prc_cmdt_def_cd",ComLpad(arrDesc[0][0], 6, "0"),0);
			sheetObj.SetCellValue(Row, "cmdt_def_nm",arrDesc[0][1],0);
			if(sts=="PC"){
				sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
			}else if(sts=="GC"){
				sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
			}
		}
	}
	var isFiredNested=false;
	var supressConfirm=false;
    /**
	    * calling function out of Focus on specific cell on the sheet <br> 
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
			if (sheetD.IsDataModified() || sheetM.IsDataModified()) {
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
				formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
		}
	}
	  /**
	   * Handling sheet process<br>
	   */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try{
			if (window.event == null || ComGetEvent() == null /*|| ComGetEvent("suppressWait") != "Y"*/) {
				ComOpenWait(true);
			}			
			sheetObj.ShowDebugMsg(false);
			sheetObj.SetWaitImageVisible(0);
			switch (sAction) {
				case IBSEARCH: 
	//				if ((sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified)&&ComShowCodeConfirm("PRI00006")) {
	//					supressConfirm = true;
	//					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	//					supressConfirm = false;
	//				}
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_0003_03GS.do", FormQueryString(formObj), {Sync:2} );
					break;
					
				case IBSEARCHAPPEND: 
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0003_03GS.do", FormQueryString(formObj), {Sync:2} );
					}
					break;
					
				case IBSEARCH_ASYNC01: 
					if (validateForm(sheetObj,document.form,sAction)) {
	  					sheetObj.SetWaitImageVisible(0);
				    	// common Source
						formObj.f_cmd.value=SEARCH19;
						var sParam=FormQueryString(formObj)+"&cd=CD02064";
						sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"src_info_cd", false, 0, "NW");
						// common Status
						formObj.f_cmd.value=SEARCH19;
						sParam=FormQueryString(formObj)+"&cd=CD01719";	
						sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"prc_prog_sts_cd", false, 0, "I");
	  					sheetObj.SetWaitImageVisible(1);
					}
				break;				
				case IBSEARCH_ASYNC02: //  checking use rate when deleting Group
					if (validateForm(sheetObj,document.form,sAction)) {
				    	// common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						var sParam="f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml=sheetObj.GetSearchData("ESM_PRI_0003_03GS.do", sParam);
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						if(rsltCnt>0){
							ComShowCodeMessage("PRI08017");	
							return false;
						}
					}
					return true;
					break;		
				case IBSEARCH_ASYNC03: // validation in case of deleting all Groups (using Group can not delete) 
				if (validateForm(sheetObj,document.form,sAction)) {
		   			var amdt_seq=formObj.amdt_seq.value;
		   			var eff_dt=formObj.eff_dt.value;
					var rowCnt=sheetObjects[1].RowCount()- ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
					var newCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
					var ndlCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
					var delCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	   		
					if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
		   				var sParam="f_cmd="+SEARCH03+"&ibflag=R"
		   				+"&prop_no="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"prop_no")
		   				+"&amdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")
		   				+"&svc_scp_cd="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")
		   				+"&grp_cmdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_cmdt_seq");
		   				var sXml=sheetObj.GetSearchData("ESM_PRI_0003_03GS.do", sParam);
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						if(rsltCnt>=0){
							ComShowCodeMessage("PRI08017");	
							return true;
						}
					}	
				}
				return false;
				break;					
				case IBSEARCH_ASYNC04: // checking Accepted or not when deleting Group
				if (validateForm(sheetObj,document.form,sAction)) {
			    	// common Source
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}						
					var sParam="f_cmd="+SEARCH04+"&" + sheetObj.GetSaveString(false, false, "chk");
					var sXml=sheetObj.GetSearchData("ESM_PRI_0003_03GS.do", sParam);
					var arrDesc=ComPriXml2Array(sXml, "prc_grp_cmdt_desc|prc_grp_cmdt_cd");
					var rsltCnt=ComPriGetRowCountFromXML(sXml);
					var txt="";
					var desc="";
					if(rsltCnt > 0){
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
				}
				return true;
				break;		
//				case IBSEARCH_ASYNC05: //   checking detail Accepted or not when deleting Group
//				if (validateForm(sheetObj,document.form,sAction)) {
//		   			var amdt_seq = formObj.amdt_seq.value;
//		   			var eff_dt = formObj.eff_dt.value;
//					var rowCnt = sheetObjects[1].RowCount - ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
//					var newCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
//								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
//								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
//					var ndlCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
//								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
//								 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
//					var delCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	   		
//	
//					if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
//		   				var sParam = "f_cmd="+SEARCH04+"&ibflag=R"
//													+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
//													+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
//													+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
//													+"&grp_cmdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_cmdt_seq");
//												
//						var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_03GS.do", sParam);
//						var arrDesc = ComPriXml2Array(sXml, "prc_grp_cmdt_desc|prc_grp_cmdt_cd");
//						var rsltCnt = ComPriGetRowCountFromXML(sXml);
//						
//						var txt = "";
//						var desc = "";
//						
//						if(rsltCnt > 0){
//							for(i=0;i<arrDesc.length;i++){
//								if(desc!=arrDesc[i][0]){
//									txt += "\n["+arrDesc[i][0]+"] : \n   ";
//								}
//								txt += "-" + arrDesc[i][1]+" ";
//								desc = arrDesc[i][0];
//							}
//							ComShowCodeMessage("PRI01132", txt);	
//							return true;
//						}
//					}	
//				}
//				return false;
//				break;					
				case IBSAVE: 
					isFiredNested=false;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}
					findDescChanged();
					formObj.f_cmd.value=MULTI01;
					var sParam=FormQueryString(formObj);
					var sParamSheet1=sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
					var sParamSheet2=sheetObjects[1].GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_03GS.do", sParam);
					isFiredNested=true;
					sheetObjects[1].LoadSaveData(sXml);
					sheetObjects[0].LoadSaveData(sXml);
					isFiredNested=false;
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						ComPriSaveCompleted();
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					return true;				
					break;
					
				case IBINSERT: // Row Add
					var prop_no=formObj.prop_no.value;
					var amdt_seq=formObj.amdt_seq.value; 
					var svc_scp_cd=formObj.svc_scp_cd.value;
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
						if (sheetObj.id == "sheet1") {
							var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
							if (idx < 0) {
								return false;
							}
							sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
							sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq"),10) + 1,0);
	  						maxCode=( groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd") + 1 ) + "";
	  						var grpSeq=maxCode;
	  						/*
							if (maxCode.length < 4){
								for(i=0;i<6-maxCode.length;i++){
									maxCode="0" + maxCode;								
								}
							}
							*/
							maxCode=ComLpad(maxCode,   4, "0");
							sheetObj.SetCellValue(idx,"prc_grp_cmdt_cd","G"+ maxCode,0);
							sheetObj.SetCellValue(idx,"prc_grp_cmdt_desc","Group "+ grpSeq,0);
							sheetObj.SetCellValue(idx,"src_info_cd","NW",0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
							sheetObj.SelectCell(idx,"prc_grp_cmdt_desc");
							sheetObjects[1].RemoveAll();
						}else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount()==0||sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"ibflag")=="D"){
								ComShowCodeMessage("PRI01004");
								return;							
							}
							var amdt_seq=formObj.amdt_seq.value;
							if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
								ComShowCodeMessage("PRI01002");		
							 	return;
							}							
							var idx=sheetObj.DataInsert();
							sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
							sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
							sheetObj.SetCellValue(idx, "prc_cmdt_tp_cd","C",0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), amdt_seq);
							var grp_cmdt_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",grp_cmdt_seq,0);
							sheetObj.SetCellValue(idx, "grp_cmdt_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq")) + 1,0);
							sheetObj.SelectCell(idx, "prc_cmdt_def_cd");	
							sheetObj.SetCellEditable(idx, "prc_cmdt_def_cd", 1);
						}
						if(amdt_seq != 0){
							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
						}
						if (sheetObj.id == "sheet2") {
							applyMasterStyle(sheetObj);
						}
					}
					break;
				case IBDELETE: // Delete
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(amdt_seq=="0"){
						if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
							if (sheetObj.id == "sheet1") {
								isGrpDel=true;				
								if(sheetObj.RowCount()==sheetObj.CheckedRows("chk")){
									isFiredNested=true;
									sheetObj.SetSelectRow(1)
									isFiredNested=false;
								}					
								var checkRow=sheetObj.FindCheckedRow("chk");	
								if(sheetObj.RowCount()==sheetObj.CheckedRows("chk") || (("|" + checkRow).indexOf("|" + sheetObj.GetSelectRow()) >= 0)){
									sheetObjects[1].RemoveAll();
								}
							}else{
								for(i=0;i < chkArr.length;i++){
									if(sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"){
										ComShowCodeMessage("PRI01002");
										return;
									}
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
					}else{
						var eff_dt=formObj.eff_dt.value;
						var amdt_seq=formObj.amdt_seq.value;
						if (sheetObj.id == "sheet1") {
							isGrpDel=true;
							for(j=0;j < chkArr.length;j++){
								sheetObj.SetCellFont("FontStrike", chkArr[j], 1, chkArr[j], sheetObj.LastCol(), true);
								sheetObj.SetCellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol(),"#FF0000");
								if(sheetObj.GetCellValue(chkArr[j],"src_info_cd") != "NW" && sheetObj.GetCellValue(chkArr[j],"ibflag") != "I"){
									sheetObj.SetRowStatus(chkArr[j],"D");
									sheetObj.SetCellValue(chkArr[j],"chk","0");
									sheetObj.SetCellValue(chkArr[j],"n1st_cmnc_amdt_seq",amdt_seq);
								}
							}
							deleteRowCheck(sheetObj, "chk");
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), amdt_seq);
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"ibflag") == "D"){
								var row=0;
								sheetObjects[1].CheckAll("chk","1",1);
								var chkArrDtl=ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
							    for(i=0;i<chkArrDtl.length;i++){
							    	if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq && sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag")!="I"){
		   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "prc_cmdt_def_cd");
							    	}else if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq") == amdt_seq && sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag") == "I"){
										sheetObjects[1].SetRowStatus(chkArr[i],"D");
										sheetObjects[1].SetRowEditable(chkArr[i],false);
										sheetObjects[1].SetRowHidden(chkArr[i], true);
		  							}
							    }
							    sheetObjects[1].CheckAll("chk","1",1);
								if(sheetObjects[1].RowCount()>0){
								    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);							
								}								
							}
							
						}else{
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq&&
										(sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
									ComShowCodeMessage("PRI01002");
									return ;									
								}
							}
							var sRow=0;
							for(j=0;j < chkArr.length;j++){
								if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","prc_cmdt_def_cd");		
									sRow++;								
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
					}					
					if(!isGrpDel && getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00021')){
						if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow())!="I"){
							sheetObjects[0].SetRowHidden(sheetObjects[0].GetSelectRow());
						}
						sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"D");
						isGrpDel=true;
					}
					isFiredNested=false;
					break;
				case IBCOPYROW: // Guideline Copy
					if (!supressConfirm && !ComShowCodeConfirm("PRI01006")) {
						return false;
					}else{
						formObj.f_cmd.value=MULTI06;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("ESM_PRI_0003_03GS.do", sParam+"&prc_cust_tp_cd="+parent.comboObjects[2].GetSelectCode());
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			    		if (sheetObjects[0].RowCount()<= 0) {
			    			ComShowCodeMessage("PRI01016");
			    		} else {
			    			ComShowCodeMessage("PRI01017");
			    		}
			    		parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					}
					break;	
				case MODIFY01: // Accept All
					if (!supressConfirm && !ComShowCodeConfirm('PRI01015')) {
						return false;
					}	
					formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_03GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00329");
						return;
					}
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00108");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case MODIFY02: // Cancel All
					if (!supressConfirm && !ComShowCodeConfirm('PRI01010')) {
						return false;
					}			
					formObj.f_cmd.value=MULTI03;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_03GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00330");
						return;
					}
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00109");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;			
				case MODIFY03: // Accept
					if (!supressConfirm && !ComShowCodeConfirm('PRI00008')) {
						return false;
					}			
					formObj.f_cmd.value=MULTI04;
					var rtn=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0003_03GS.do");
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);
					if(rtn){
						ComShowCodeMessage("PRI00108");
					}
					break;	
				case MODIFY04: // Accept Cancel
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value=MULTI05;
					var rtn=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_03GS.do");
					parent.comUpdateProposalStatusSummary("14",formObj.svc_scp_cd.value);				
					if(rtn){
						ComShowCodeMessage("PRI00109");
					}				
					break;			
				case COMMAND01: // Amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","prc_cmdt_def_cd");						
						}
					}else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","prc_cmdt_def_cd");
					}
					break;		
				case COMMAND02: // Amend Cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "prc_cmdt_def_cd");
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "prc_cmdt_def_cd");
					}
					break;
				}
	    } catch (e) {
	        if (e == "[object Error]") {
	            ComShowMessage(OBJECT_ERROR);
	        } else {
	            ComShowMessage(e.message);
	        }
	    } finally {
	    	ComOpenWait(false);
	    	sheetObj.SetWaitImageVisible(1);
	    }
	}
	
    /**
	* sheet2 OnPopupClick event function <br>
    */
	var popupRow = 0;
 	function sheet2_OnPopupClick(sheetObj, Row, Col) {
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		popupRow=Row;
 		var sts=formObj.prop_sts_cd.value;
       	switch(colName) {
   	    	case "prc_cmdt_def_cd":
   	    		var commodityCmd="C";
   	    		var sts=sheetObj.GetCellValue(Row, "src_info_cd");
 	  	  		var sUrl="ESM_PRI_4027.do?commodity_cmd=" + commodityCmd;
 	  	  		ComOpenPopup(sUrl, 700, 350, "sheet2_returnVal", "1,0", true);
 	  	  		
   	    		break;
       	}
 	}  
 	
 	function sheet2_returnVal(rtnVal) {
 		var prc_cmdt_def_cd=sheet2.GetCellValue(popupRow, "prc_cmdt_def_cd");
 		var sts=sheet2.GetCellValue(popupRow, "src_info_cd");
 		if (rtnVal != null && prc_cmdt_def_cd != rtnVal.cd){
 			sheet2.SetCellValue(popupRow, "prc_cmdt_def_cd", rtnVal.cd, 0);
 			sheet2.SetCellValue(popupRow, "cmdt_def_nm", rtnVal.nm, 0);
			if(sts=="PC"){
				sheetObj.SetCellValue(popupRow, "src_info_cd","PM", 1);
			}else if(sts=="GC"){
				sheetObj.SetCellValue(popupRow, "src_info_cd","GM", 1);
			}
		}
 		
 	}
 	
 	/**
 	* checking validation process of inputted form data <br>
 	*/
	function validateForm(sheetObj, formObj, sAction) {
		var amdt_seq=formObj.amdt_seq.value;
		switch (sAction) {
		case IBSEARCH: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCHAPPEND: 
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCH_ASYNC01: 
			return true;
			break;
		case IBSEARCH_ASYNC02:
			return true;
			break;		
		case IBSEARCH_ASYNC03: 
			return true;
			break;
		case IBSEARCH_ASYNC04: 
			return true;
			break;		
//		case IBSEARCH_ASYNC05: 
//			return true;
//			break;			
		case IBSAVE:
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D" && getValidRowCount(sheetObjects[1]) <= 0) {
   				ComShowCodeMessage("PRI00319", "Commodity Group");
				return false;
			}	
   			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03)){
				return false;				
			}
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			var rowM=ComPriAmendDupCheck(sheetObjects[0], "prc_grp_cmdt_cd", amdt_seq);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			var rowD=ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_cmdt_seq|prc_cmdt_def_cd", amdt_seq)
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			return true;
			break;
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBCOPYROW: // Guideline Copy
			if(sheetObjects[0].RowCount()> 0) {
				return false;
			}
			break;
		}
	}
    	/**
	    * calling function when click the tab of parent screen <br> 
	    * initializing when the first loading page, getting variables from parent screen  <br> 
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
			formObject.dur_dup_flg.value=sDurDupFlg ;
			formObject.lgcy_if_flg.value=sLgcyIfFlg ;
	        askOnce=true;
			buttonControl();
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}	
    /**
    * initializing sheet and variables in the page
    */		
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
        askOnce=true;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	var enableFlag=true;
    /**
	    * changing sheet's attribute in the page
	    */		
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
    /**
     * calling function when occurring OnSearchEnd Event after finishing retrieve<br>
     */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq=document.form.amdt_seq.value;
		var eff_dt=document.form.eff_dt.value;
		var sts=document.form.prop_sts_cd.value;
		if(sts=="I"){
			if(amdt_seq==0){
				sheetObj.SetColEditable("prc_cmdt_def_cd", 1);
			}else{
				sheetObj.SetColEditable("prc_cmdt_def_cd", 0);
				for(var i=1; i<=sheetObj.RowCount(); i++){
					if(amdt_seq == sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq")){
						sheetObj.SetCellEditable(i, "prc_cmdt_def_cd", 1);
					}
				}
			}
		}else{
			sheetObj.SetColEditable("prc_cmdt_def_cd", 0);
		}
		var amdt_seq=document.form.amdt_seq.value;
		var pre_exp_dt=document.form.pre_exp_dt.value;
		var lgcy_if_flg=document.form.lgcy_if_flg.value;
		if(amdt_seq!=0 && lgcy_if_flg != "Y") {
			for(i=1 ; i < sheetObj.RowCount()+1 ; i++) {
				if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
					sheetObj.SetRowEditable(i,0);
				} else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
					sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
					if(sts == "I"&&sheetObj.GetCellValue(i,"src_info_cd")!="AD"){
						sheetObj.SetCellEditable(i,"prc_cmdt_def_cd",1);
					}else{
						sheetObj.SetCellEditable(i,"prc_cmdt_def_cd",0);
					}
				}
			}	
		}
		
		//2015.05.14 ibsearch -> change here (ibsheet patch : seteditable func must be in the OnSearchEnd)
		buttonControl();
	}
    /**
     * calling function when occurring OnSearchEnd Event after finishing retrieve<br>
     */ 
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var rCnt=sheetObj.RowCount();
		var formObj=document.form;		
		var amdt_seq=formObj.amdt_seq.value;
		var lgcy_if_flg=formObj.lgcy_if_flg.value;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;		
		var sts=document.form.prop_sts_cd.value;
		if(sts == "I" && rCnt < 1 && (req_usr_flg=="true"||apro_usr_flg=="true")) {
			if(askOnce&&ComShowCodeConfirm("PRI01006")) {
		        askOnce=false;
				supressConfirm=true;
				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
				supressConfirm=false;
			}
	        askOnce=false;
		}
		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0 && lgcy_if_flg != "Y"){
				if(sheetObj.GetCellValue(i,"src_info_cd")=="AD"){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
				}
				if(sheetObj.GetCellValue(i,"src_info_cd")=="AM"||sheetObj.GetCellValue(i,"src_info_cd")=="AD"||sheetObj.GetCellValue(i,"src_info_cd")=="NW"){
					sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
				}
				if(sheetObj.GetCellValue(i,"src_info_cd")=="NW"){
					sheetObj.SetCellEditable(i,"prc_grp_cmdt_desc",0);
				}				
			}
		}
		isGrpDel=false;
		isFiredNested=false;
	}	
		/**
		* setting Master's Style based on Master Detail  
		*/			
	function applyMasterStyle(sheetObj){
		var formObj=document.form;
		var amdt_seq=formObj.amdt_seq.value;
		var eff_dt=formObj.eff_dt.value;
		var amdCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
					 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length;
		var rowCnt=sheetObj.RowCount()- ComPriSheetFilterRows(sheetObj, "n1st_cmnc_amdt_seq", amdt_seq).length;
		var newCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
					 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
					 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
		var ndlCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
					 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
					 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
		var delCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;
		var grp_sts=amdCnt > 0 ? true : false;
		var grp_flg=rowCnt + newCnt - ndlCnt - delCnt == 0 ? true : false;
		if(delCnt==0) grp_flg=false;
			sheetObjects[0].SetCellFont("FontColor", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), "#000000");
		if(amdt_seq!=0){			
			sheetObjects[0].SetCellFont("FontColor", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), grp_sts ? "#FF00000000":"");
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "n1st_cmnc_amdt_seq",grp_sts ? document.form.amdt_seq.value : document.form.pre_amdt_seq.value,0);
			//no support[implemented common]CLT changeSelectBackColor(sheetObjects[0], sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "src_info_cd")!="NW"){
				sheetObjects[0].SetCellFont("FontStrike", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), grp_flg);	
			}
//			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "ibflag",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ibflag")== "I" ? "I" : "R",0);
		}
	}
	/**
     * button authority control function by button status<br>
     */
	function buttonControl(){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var row_cnt=sheetObjects[0].RowCount();
		try{
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			enableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_acceptall");
			disableButton("btn_cancelall");
			disableButton("btn_glinecopy");
			disableButton("btn_rowadd1");
			disableButton("btn_delete1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete2");
			disableButton("btn_amend");
			disableButton("btn_amendcancel");
			disableButton("btn_accept");
			disableButton("btn_acceptcancel");
			showButton("btn_amendcancel");
			showButton("btn_amend");
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}
			sheetObjects[0].InitCellProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_cmdt_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
			sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, false, false, 100);
			sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false,"prc_cmdt_def_cd", 	true, "", dfNone, 	0, false, false, 6);
			switch(sts) {
				case 'I':   // Initial
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						sheetObjects[0].SetEditable(1);
						sheetObjects[1].SetEditable(1);
						if(amdt_seq==0){
							sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, false, false, 100);
							sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false,"prc_cmdt_def_cd", 	true, "", dfNone, 	0, true, true, 6);							
						}else{
							sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, false, false, 100);
							sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false,"prc_cmdt_def_cd", 	true, "", dfNone, 	0, false, true, 6);														
						}
						enableButton("btn_save");					
						enableButton("btn_rowadd1");
						enableButton("btn_delete1");
						enableButton("btn_rowadd2");
						enableButton("btn_delete2");
						enableButton("btn_amend");
						enableButton("btn_amendcancel");	
						if(row_cnt==0){
							enableButton("btn_glinecopy");
						}else{
							disableButton("btn_glinecopy");
						}						
					}
					break;
				case 'Q':   // Requested
					if(apro_usr_flg=="true"){
						enableButton("btn_acceptall");
						enableButton("btn_cancelall");
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}
					break;
				case 'R':   // Returned
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}				
					break;
				case 'P':   // Approved
				case 'F':   // Filed
				case 'C':   // Cancled
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
	* calling function when occurring OnChange Event <br> 
	*/
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	switch(colname)
    	{
	    	case "prc_grp_cmdt_cd":	    		
	    		if (Value.length==5){
	    			sheetObj.SelectCell(Row, Col+1);
	    		}else{	   
	    			ComShowCodeMessage("PRI00315");
	    			sheetObj.SetCellValue(Row,"prc_grp_cmdt_cd","",0);
  					sheetObj.SetCellValue(Row, "prc_grp_cmdt_desc","",0);
  					sheetObj.SelectCell(Row, "prc_grp_cmdt_cd")
	    		}
	    		break;
    	}
	}
	/**
	* getting column's MAX seq 
	* returning decimal number 
	*/		
   function groupCodeGetMax(sheetObj, sCol) {
       var max=0;
       for (var i=0; i <= sheetObj.LastRow(); i++) {
    	   if (parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4), 10) > max) {
    		   max=parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4),10);
           }
       }
       return max;
   }	

	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2015.06.24 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var memoColWidth =	sheetObj.GetColWidth("prc_grp_cmdt_desc");
		if(sheetObj.GetSelectRow() != Row){
			return;
		}
		if (colName == "prc_grp_cmdt_desc") {
			if(req_usr_flg=="true"||apro_usr_flg=="true"){
				if (sts=="I" && sheetObj.GetCellValue(Row, "src_info_cd" )!="AD") {
					ComShowMemoPad(sheetObj, Row, Col, false, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
				} else {
					ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
				}
			
				// 2015.06.24 : To catch Blur event after MemoPad is created. Keyup event can't check Copy & Paste so Blur event is used
				$("#"+MEMO_TEXT_NAME).blur(function(event){
					$(this).val($(this).val().replace(/\//gi, ""));
					$("#"+MEMO_TEXT_NAME).unbind();
				});
			}else{
				ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
			}
		}
	}
	
	function findDescChanged(){
		var formObj = document.form;
		var selectRow = sheetObjects[0].GetSelectRow();
		var amdCnt = 0;
		var newDesc = sheetObjects[0].GetCellValue(selectRow, "prc_grp_cmdt_desc").replace(/\s/gi, '');
		var oldDesc = sheetObjects[0].GetCellValue(selectRow, "prc_grp_cmdt_desc_ori").replace(/\s/gi, '');
		if(newDesc != oldDesc){
			for(var i=1; i<=sheetObjects[1].RowCount(); i++){
				if(sheetObjects[1].GetRowHidden(i) == 1){
					continue;
				}
				if(sheetObjects[1].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					amdCnt ++;
				}
			}
			if(amdCnt == 0){
				if(sheetObjects[1].GetRowHidden(1) == 1){
					comSheetAmendRow(sheetObjects[1],formObj,2,"M","prc_cmdt_def_cd");
				}else{
					comSheetAmendRow(sheetObjects[1],formObj,1,"M","prc_cmdt_def_cd");
				}
				applyMasterStyle(sheetObjects[1]);
			}
		}
	}
	
	