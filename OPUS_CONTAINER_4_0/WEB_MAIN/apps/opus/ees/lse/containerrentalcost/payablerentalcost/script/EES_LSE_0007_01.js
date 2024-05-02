/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0007_01.jsp
*@FileTitle  : Container Rental Charge Creation Audit & Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/12
=========================================================*/
   	/* developer job */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var orgCntrTpSzCd="";
	var orgInvNo="";
	var orgAgmtNo="";
	var arrInvNo="";
	var arrChgSeq="";
	var arrAgmtCtyNo="";
	var arrAgmtSeq="";
	var vChgTypes="";
	var vChgCdNmTypes = "";
	var vChgType1="";
	var vCntrTpSz1="BX";
	var vCntrTpSz2="XX";
	var vCrdSeq=0; 
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick() {
		/**********/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Reject":
					if ( ComShowCodeConfirm("COM130101", "Reject Audit") ) {
						doActionIBSheet(sheetObject2, formObj, IBSAVE);
					}
					break;
				case "btn_Confirm":
					if ( ComShowCodeConfirm("COM130101", "Confirm Audit") ) {
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
					}
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
				case "btn_t1RowAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;
				case "btn_t1RowDelete":
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
					break;
				case "btn_t1DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}					
					break;
				case "btn_t2Move":
					doActionIBSheet(sheetObject2, formObj, IBCOPYROW);
					break;
				case "btn_t3Move":
					doActionIBSheet(sheetObject3, formObj, IBCOPYROW);
					break;
				case "btn_t4Move":
					doActionIBSheet(sheetObject4, formObj, IBCOPYROW);
					break;
				case "btn_t2DownExcel":
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
					}					
					break;
				case "btn_t3DownExcel":
					if(sheetObject3.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject3.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject3), SheetDesign:1,Merge:1 });
					}					
					break;					
				case "btn_t4DownExcel":					
					if(sheetObject4.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject4.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject4), SheetDesign:1,Merge:1 });
					}	
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
		var formObj=document.form;
		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for ( var k=0 ; k < tabObjects.length ; k++ ) {
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		ComAddSeparator(form.chg_cost_yrmon, "ym");
		doActionIBSheet(sheetObjects[0], formObj, SEARCH12);
		doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
		//doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
	}
	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetid=sheetObj.id;
		var formObj=document.form;
		switch (sheetid) {
			case "t1sheet1":
			    with(sheetObj){
		      
				      var HeadTitle1="|sel|Seq.|CNTR No.|TP/SZ|Invoice\nNo.|AGMT No.|Contract No.|Audit\nStatus|Original\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|Credit\nAmount|Credit No.||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"chkbox" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
				             {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_aud_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bil_dys",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pd_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dscr_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dscr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dtl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetWaitImageVisible(0);
				      SetSheetHeight(320);
				      
					  SetColProperty(0 ,"onh_loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
					  SetColProperty(0 ,"offh_loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				      SetColProperty(0 ,"dscr_onh_loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				      SetColProperty(0 ,"dscr_offh_loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				      
				      SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetColProperty(0 ,"bzet_nm", {AcceptKeys:"E|N|[-_]"});
		            }
				break;
			case "t2sheet1":
			    with(sheetObj){			  
				      var HeadTitle1="||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice|Invoice||||||||Diff. AMT";
				      var HeadTitle2="||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|Credit\nAmount|Credit No.||||||||Diff. AMT";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"chkbox" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_aud_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_dys",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bil_dys",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pd_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dscr_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dscr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dtl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"diff_cost_amt",      KeyField:0,   CalcLogic:"|dscr_cost_amt|-|ttl_cost_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetSheetHeight(320);
		            }
				break;
			case "t3sheet1":
			    with(sheetObj){
		      
				      var HeadTitle1="||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit\nAmount|Credit No.|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"chkbox" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_aud_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_dys",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bil_dys",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pd_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dscr_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dscr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dtl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetSheetHeight(320);
		            }
				break;
			case "t4sheet1":
			    with(sheetObj){
		      
				      var HeadTitle1="||Seq.|CNTR No.|TP/SZ|Invoice No.|AGMT No.|Contract No.|Audit\nStatus|Charge\nType|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Total\nDays|Free\nDays|Billing\nDays|Rate|Amount|Credit No.|On-hire\nDate|On-hire\nLoc|Off-hire\nDate|Off-hire\nLoc|Rate|Amount|Credit\nAmount||||||";
				      var headCount=ComCountHeadTitle(HeadTitle1);
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"chkbox" },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_aud_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"onh_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"onh_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"offh_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"offh_loc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cost_dys",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bil_dys",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pd_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"ttl_cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_onh_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dscr_offh_loc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dscr_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"dscr_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cr_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_cty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dtl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_cost_yrmon",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pay_chg_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lse_pay_chg_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetSheetHeight(320);
		            }

				break;
			}
	 	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBCREATE:	//Container Type/Size Grid Combo Item Setting
				arrInvNo=ComGetObjValue(formObj.inv_no).split("|");
				arrChgSeq=ComGetObjValue(formObj.chg_seq).split("|");
				arrAgmtCtyNo=ComGetObjValue(formObj.agmt_cty_cd).split("|");
				arrAgmtSeq=ComGetObjValue(formObj.agmt_seq).split("|");
				//sheetObj.WaitImageVisible = false;
				/* Container Type/Size */
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					orgCntrTpSzCd=ComGetEtcData(sXml, "cntr_tpsz_cd");
					if ( orgCntrTpSzCd != "" ) {
	        			sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:"|"+orgCntrTpSzCd+"|"+vCntrTpSz1+"|"+vCntrTpSz2, ComboCode:"|"+orgCntrTpSzCd+"|"+vCntrTpSz1+"|"+vCntrTpSz2} );
	        		}
				}
				/* Invoice No. */
				var invNo="";
				for ( var i=0 ; i < arrInvNo.length ; i++ ) {
					if ( i == 0 ) {
						invNo=arrInvNo[i];
					} 
					else {
						var appdFlag=true;
						for ( var j=0 ; j < i ; j++ ) {
							if ( arrInvNo[i] == arrInvNo[j] ) {
								appdFlag=false;
							}
						}
						if ( appdFlag ) {
							invNo=invNo + "|" + arrInvNo[i];
						}
					}
				}
				sheetObj.SetColProperty("inv_no", {ComboText:"|"+invNo, ComboCode:"|"+invNo} );
				/* Pay Charge Type */
				sheetObj.SetColProperty("lse_pay_chg_tp_cd", {ComboText:vChgCdNmTypes, ComboCode:vChgTypes} );
				/* Agreement No. */
				for (var i=0 ; i < arrAgmtCtyNo.length ; i++ ) {
					if ( i == 0 ) {
						orgAgmtNo=arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
					} else {
						orgAgmtNo=orgAgmtNo + "|" + arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
					}
				}
				sheetObj.SetColProperty("agmt_no", {ComboText:"|"+orgAgmtNo, ComboCode:"|"+orgAgmtNo} );
				//sheetObj.WaitImageVisible = true;
				break;
			case IBSEARCH:      //retrieve
				if ( validateForm(sheetObj, formObj, sAction) ) {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSearchData("EES_LSE_0007_01GS.do" , FormQueryString(formObj));
					//sheetObj.WaitImageVisible = true;
					var arrXml=sXml.split("|$$|");
					if ( arrXml.length > 0 ) {
						if ( ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S" ) {
							if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
							if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
							if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
							if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
						}
					}
					if ( sheetObjects[0].RowCount()> 0 ) {
						for ( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++ ) {
							if ( sheetObjects[0].GetCellValue(i, "pay_chg_sts_cd") == "C" ) {
								sheetObjects[0].SetCellEditable(i, "chkbox",0);
							}
						}
					}
					// Wrong part of Discrepancy Data marking
					if ( sheetObjects[1].RowCount()> 0 ) {
						var rgbCd="#FF0000";
						for ( var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++ ) {
							if ( sheetObjects[1].GetCellValue(i, "onh_dt") != sheetObjects[1].GetCellValue(i, "dscr_onh_dt") ) {
								sheetObjects[1].SetCellFont("FontColor", i, "onh_dt",rgbCd);
								sheetObjects[1].SetCellFont("FontColor", i, "dscr_onh_dt",rgbCd);
								sheetObjects[1].SetCellFont("FontBold", i, "onh_dt",1);
								sheetObjects[1].SetCellFont("FontBold", i, "dscr_onh_dt",1);
							}
							if ( sheetObjects[1].GetCellValue(i, "offh_dt") != sheetObjects[1].GetCellValue(i, "dscr_offh_dt") ) {
								sheetObjects[1].SetCellFont("FontColor", i, "offh_dt",rgbCd);
								sheetObjects[1].SetCellFont("FontColor", i, "dscr_offh_dt",rgbCd);
								sheetObjects[1].SetCellFont("FontBold", i, "offh_dt",1);
								sheetObjects[1].SetCellFont("FontBold", i, "dscr_offh_dt",1);
							}
							if ( sheetObjects[1].GetCellValue(i, "pd_rt_amt") != sheetObjects[1].GetCellValue(i, "dscr_rt_amt") ) {
								sheetObjects[1].SetCellFont("FontColor", i, "pd_rt_amt",rgbCd);
								sheetObjects[1].SetCellFont("FontColor", i, "dscr_rt_amt",rgbCd);
								sheetObjects[1].SetCellFont("FontBold", i, "pd_rt_amt",1);
								sheetObjects[1].SetCellFont("FontBold", i, "dscr_rt_amt",1);
							}
							if ( sheetObjects[1].GetCellValue(i, "ttl_cost_amt") != sheetObjects[1].GetCellValue(i, "dscr_cost_amt") ) {
								sheetObjects[1].SetCellFont("FontColor", i, "ttl_cost_amt",rgbCd);
								sheetObjects[1].SetCellFont("FontColor", i, "dscr_cost_amt",rgbCd);
								sheetObjects[1].SetCellFont("FontBold", i, "ttl_cost_amt",1);
								sheetObjects[1].SetCellFont("FontBold", i, "dscr_cost_amt",1);
							}
						}
					}
					ComOpenWait(false);
					//sheetObj.WaitImageVisible = true;
				}
				break;
			case IBBATCH:      //retrieve-BackEndJob
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "t1sheet1") {
						formObj.f_cmd.value=COMMAND01;
						sheetObjects[0].SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
						if (backendJobKey.length > 0) {
							ComSetObjValue(formObj.backendjob_key, backendJobKey);
							sheetObj.SetWaitTimeOut(10000);
							timer1=setInterval(getBackEndJobStatus, 3000);
							//getBackEndJobStatus();
						}
					}
				}
				break;
			case IBSAVE:       
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "t1sheet1" ) {
						var sParam="f_cmd=" + MULTI;
						sParam=sParam + "&chg_cost_yrmon=" + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", "");
						sParam=sParam + "&chg_seq=" + ComGetObjValue(formObj.chg_seq)
						sParam=sParam + "&agmt_cty_cd=" + ComGetObjValue(formObj.agmt_cty_cd)
						sParam=sParam + "&agmt_seq=" + ComGetObjValue(formObj.agmt_seq)
						sParam=sParam + "&" + LseGetAllSaveText4LSE0007(sheetObj, true, "ibflag", "t1sheet1_");
						var sXml=sheetObj.GetSaveData("EES_LSE_0007_01GS.do", sParam);
						sheetObj.LoadSaveData(sXml);
					} else if ( sheetObj.id == "t2sheet1" ) {
						ComSetObjValue(formObj.f_cmd, MULTI01);
						//sheetObj.DoSave("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						var sXml=sheetObj.GetSaveData("EES_LSE_0007_01GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
					}
				}
				break;
			case IBINSERT:      
				var rowIdx=sheetObj.DataInsert(-1);
				sheetObj.CellComboItem(rowIdx,"agmt_no", {ComboText:"", ComboCode:""} );
				sheetObj.SetCellValue(rowIdx, "cntr_no",getCrdCntrNo(sheetObj, rowIdx));
				sheetObj.SetCellValue(rowIdx, "chg_cost_yrmon",ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", ""));
				sheetObj.SetCellValue(rowIdx, "cntr_aud_sts_cd","L");
				//sheetObj.SetCellValue(rowIdx, "lse_pay_chg_tp_cd",vChgType1);
				sheetObj.SetCellValue(rowIdx, "pay_chg_sts_cd","A");
				break;
			case IBDELETE:      
				ComRowHideDelete(sheetObj, "chkbox");
				computeSum(sheetObj);
				break;
			case SEARCH12:      //Unit Type retrieve
 				sheetObj.SetWaitImageVisible(0);
 				ComOpenWait(true);			
 				var param="f_cmd="+SEARCH20+"&intg_cd_id=CD30024"; 	
				var xml="";
				xml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
				var strCode= "";
				var strCodeNm = "";
				strCode = ""+ComGetEtcData(xml, "tp_cd").split("|");
				strCodeNm=""+ComGetEtcData(xml, "tp_cd_nm").split("|");
				
				var arrStrCode = strCode.split(",");
				var arrStrCodeNm = strCodeNm.split(",");
				vChgTypes = "";
				if(arrStrCode.length > 1) {
					for(var i=0;i<arrStrCode.length;i++) {
						if(i == 0) {
							vChgTypes = "|" + arrStrCode[i];
							vChgCdNmTypes = "|" + arrStrCode[i]+"	"+arrStrCodeNm[i]; 
						}else{
							vChgTypes = vChgTypes + "|" + arrStrCode[i]; 
							vChgCdNmTypes = vChgCdNmTypes + "|" + arrStrCode[i]+"	"+arrStrCodeNm[i]; 
						}
					}
				}
				
				sheetObjects[0].CellComboItem(i,"lse_pay_chg_tp_cd", {ComboText:vChgCdNmTypes, ComboCode:vChgTypes} );
				sheetObjects[0].SetCellEditable(i, "lse_pay_chg_tp_cd",1);
				ComOpenWait(false);
				break;
			case IBCOPYROW:
				sheetObj.SetWaitImageVisible(1);
				ComOpenWait(true);
				setTimeout( function () {
					var sXml=makeSearchXml(sheetObj, "chkbox", "cntr_no|cntr_tpsz_cd|inv_no|agmt_no|lse_ctrt_no|cntr_aud_sts_cd|lse_pay_chg_tp_cd|onh_dt|onh_loc_cd|offh_dt|offh_loc_cd|cost_dys|chg_free_dys|bil_dys|pd_rt_amt|ttl_cost_amt|cr_amt|cr_no|dscr_onh_dt|dscr_onh_loc_cd|dscr_offh_dt|dscr_offh_loc_cd|dscr_rt_amt|dscr_cost_amt|chg_seq|agmt_cty_cd|agmt_seq|dtl_seq|chg_cost_yrmon|pay_chg_sts_cd|lse_pay_chg_tp_nm", true, 100000);
					
					if(sXml == undefined) {
						ComOpenWait(false);
						return;
					}
					for ( var i=0 ; i < sXml.length ; i++ ) {
						var beforeRowCount = sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount();
						sheetObjects[0].LoadSearchData(sXml[i],{Append:1} );
						var afterRowCount = sheetObjects[0].HeaderRows()+ sheetObjects[0].RowCount();
						// 1. Discrepancy / COM Only / Lessor Only => Coincidence move Data no Edit.
						// 2. no CNTR TP/SZ Data from Lessor Only -> 'XX' Setting.
						// 3. no Charge Type Data Lessor Only -> Cell Edit.
						if ( sheetObj.id == "t4sheet1" ) {
							for ( var i=beforeRowCount; i < afterRowCount; i++ ) {
								if ( sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == "" ) {
									sheetObjects[0].SetCellValue(i, "cntr_tpsz_cd",vCntrTpSz2);
								}
								if ( sheetObjects[0].GetCellValue(i, "lse_pay_chg_tp_cd") == "" ) {
									sheetObjects[0].CellComboItem(i,"lse_pay_chg_tp_cd", {ComboText:vChgCdNmTypes, ComboCode:vChgTypes} );
									sheetObjects[0].SetCellEditable(i, "lse_pay_chg_tp_cd",1);
								}
								if ( sheetObjects[0].GetCellValue(i, "dscr_cost_amt") < 0 ) {
									sheetObjects[0].SetCellValue(i, "cr_amt",sheetObjects[0].GetCellValue(i, "dscr_cost_amt"));
									sheetObjects[0].SetCellValue(i, "cr_no",sheetObjects[0].GetCellValue(i, "inv_no"));
									sheetObjects[0].SetCellValue(i, "dscr_cost_amt",0.0);
								}
							}
						}
					}
					// Coincidence Tab sum calc
					computeSum(sheetObj);
					computeSum(sheetObjects[0]);
					// move to Coincidence Tab 
					tabObjects[0].SetSelectedIndex(0);
					sheetObjects[0].SelectCell(sheetObjects[0].LastRow(), "seq");
					ComOpenWait(false);
     			} , 100);
				break;
		}
	}
	/**
    * make data to retrieveXML type. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sXml = makeSearchXml(sheetObj, "chkBox","trd_cd|rlane_cd|dir_cd");
    * </pre>
    * @param {ibsheet} 		sheet_obj   mandatory,IBSheet Object ID
    * @param {int,string}	col     	mandatory,index or SaveName[check box type]
    * @param {string}  		saveColName mandatory, SaveName : "|" string
    * @param {bool}    		bRowDel     option,rowdelete, default=false
    * @param {int}    		pageRowCnt  Row/page
    * @return string, Sheet data retrieveXML string
    */
    function makeSearchXml(sheetObj, col, saveColName, bRowDel, pageRowCnt) {
        try {
            //param check
            if ( typeof sheetObj != "object") {
                ComShowMessage("sheetObj param of ComMakeSearchXml method is not IBSheet.");
                return "";
            }
            var sColOrder="";
            if ( saveColName != undefined && saveColName != null && saveColName != "" ) {
                sColOrder=" COLORDER='" + saveColName + "' ";
            }
            var arrCol=saveColName.split("|");
    		var aryTD=new Array(arrCol.length);
    		var sColSep="^|^";
    		var findRows=sheetObj.FindCheckedRow(col);
    		if ( findRows != "" ) {
        		//findRows=findRows.substring(0, findRows.length-1); //last "|" remove
        		var arrRow=findRows.split("|");
        		var totPageCnt=Math.ceil(arrRow.length / pageRowCnt);
                var arrXml=new Array(totPageCnt);
        		for ( var i=0 ; i < totPageCnt ; i++ ) {
        			var allXml="";
        			var trCnt=0;
        			if ( i < totPageCnt-1 ) {
        				trCnt=pageRowCnt;
        			} else {
        				trCnt=arrRow.length - i*pageRowCnt;
        			}
        			var aryTR=new Array(trCnt);
        			allXml="<?xml version='1.0'  ?>\n"
                           + "<SHEET>\n"
                           + "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
            		for ( var ir=(i*pageRowCnt) ; ir < (i*pageRowCnt + trCnt) ; ir++ ) {
            			if ( sheetObj.id == "t2sheet1" ) {
            				if ( sheetObj.GetCellValue(arrRow[ir], "dscr_cost_amt") < 0 ) {
            					sheetObj.SetCellValue(arrRow[ir], "cr_amt",sheetObj.GetCellValue(arrRow[ir], "dscr_cost_amt"),0);
            					sheetObj.SetCellValue(arrRow[ir], "cr_no",sheetObj.GetCellValue(arrRow[ir], "inv_no"),0);
								sheetObj.SetCellValue(arrRow[ir], "dscr_cost_amt",0.0,0);
							}
            			} else if ( sheetObj.id == "t3sheet1" ) {
            				sheetObj.SetCellValue(arrRow[ir], "dscr_onh_dt",sheetObj.GetCellValue(arrRow[ir], "onh_dt"),0);
            				sheetObj.SetCellValue(arrRow[ir], "dscr_offh_dt",sheetObj.GetCellValue(arrRow[ir], "offh_dt"),0);
            				sheetObj.SetCellValue(arrRow[ir], "dscr_onh_loc_cd",sheetObj.GetCellValue(arrRow[ir], "onh_loc_cd"),0);
            				sheetObj.SetCellValue(arrRow[ir], "dscr_offh_loc_cd",sheetObj.GetCellValue(arrRow[ir], "offh_loc_cd"),0);
            				sheetObj.SetCellValue(arrRow[ir], "dscr_rt_amt",sheetObj.GetCellValue(arrRow[ir], "pd_rt_amt"),0);
            				sheetObj.SetCellValue(arrRow[ir], "dscr_cost_amt",sheetObj.GetCellValue(arrRow[ir], "ttl_cost_amt"),0);
            			} else if ( sheetObj.id == "t4sheet1" ) {
            				sheetObj.SetCellValue(arrRow[ir], "lse_pay_chg_tp_nm",sheetObj.GetCellValue(arrRow[ir], "lse_pay_chg_tp_cd"),0);
            				var agmtNo=sheetObj.GetCellValue(arrRow[ir], "agmt_no");
    						var agmtCtyCd=agmtNo.substr(0, 3);
    						var agmtSeq=ComParseInt(agmtNo.substr(3))+"";
    						var chgSeq="";
    						for ( var j=0 ; j < arrAgmtSeq.length ; j++ ) {
    							if ( agmtSeq == arrAgmtSeq[j] ) {
    								sheetObj.SetCellValue(arrRow[ir], "chg_seq",arrChgSeq[j],0);
    							}
    						}
            			}
            			for ( var ic=0 ; ic < arrCol.length ; ic++ ) {
            				aryTD[ic]=String(sheetObj.GetCellValue(arrRow[ir], arrCol[ic]));
            			}
            			aryTR[ir]="    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
            		}
            		allXml += aryTR.join("\n");
                    allXml += "  </DATA>\n"
                 	       +  "</SHEET>";
                    arrXml[i]=allXml;
        		}
        		if (bRowDel) {
        			sheetObj.RenderSheet(0);
        			//sheetObj = sheetObj.Reset();
        			//sheetObj.SetRenderSheetSum(0);
                    for ( var ir=arrRow.length-1 ; ir >= 0 ; ir-- ) {
                    	sheetObj.RowDelete(arrRow[ir],false);
                    }
                    //sheetObj.SetRenderSheetSum(1);
                    sheetObj.RenderSheet(1);
        		}
        	}
            return arrXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
	 * registering IBTab Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * Tab setting
	 */
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
			case 1:
				with (tabObj) {
					var cnt=0 ;
					InsertItem( "Coincidence" , "");
					InsertItem( "Discrepancy" , "");
					InsertItem( "COM Only" , "");
					InsertItem( "Lessor Only" , "");
				}
				break;
		}
	}
	function tab1_OnChange(tabObj , nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//-----------------------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	
	function tab1_OnClick(tabObj , nItem) {
		computeSum(sheetObjects[nItem]);	
	}
	
	function t1sheet1_OnSearchEnd(sheetObj) {
		var formObj=document.form;
		computeSum(sheetObj);
		/* IBMulti Combo Item Setting */
		//doActionIBSheet(sheetObj, formObj, IBCREATE);
	}	
	function t1sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		/* IBMulti Combo Item Setting */
		//doActionIBSheet(sheetObj, formObj, IBCREATE);
	}
	function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if ( sheetObj.GetEtcData("TRANS_RESULT_KEY") == "S" ) {			
			//var opener=window.dialogArguments;
			var func="parent."+ComGetObjValue(formObj.func)+"();";
			eval(func);
			ComClosePopup(); 
		}
	}
	function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		switch (colName) {
			case "cntr_no" :
				// 1. Container No. inserted -> TP/SZ retrieve and Setting.
				// 2. no insert TP/SZ reset.
				// 3. Charge Type is "CRD" -> Container No. OnChange Event no action.
				if ( ComTrim(Value) != "" ) {
					setCntrTpSzAsyncData(sheetObj, Row, Col, Value);
				} else {
					sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
				}
				break;
/*
			case "bil_dys" :
			case "pd_rt_amt" :
if ( sheetObj.GetCellValue(Row, "lse_pay_chg_tp_cd") == "PDM" ) {
sheetObj.SetCellValue(Row, "ttl_cost_amt",sheetObj.GetCellValue(Row, "bil_dys") * sheetObj.GetCellValue(Row, "pd_rt_amt"));
				}
				break;
*/
			case "inv_no":
				// 1. Invoice No. Value change -> only Agreement about Invoice  Combo  Setting.
				var agmtNo="";
				for ( var i=0 ; i < arrInvNo.length ; i++ ) {
					if ( Value == arrInvNo[i] ) {
						if ( agmtNo == "" ) {
							agmtNo=arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
						} else {
							agmtNo=agmtNo + "|" + arrAgmtCtyNo[i] + ComLpad(arrAgmtSeq[i], 6, "0");
						}
					}
				}
				sheetObj.CellComboItem(Row,"agmt_no", {ComboText:"|"+agmtNo, ComboCode:"|"+agmtNo} );
				break;
			case "agmt_no":
				// 1. Agreement selected, Hidden Field Setting.
				var agmtCtyCd=Value.substr(0, 3);
				var agmtSeq=ComLtrim(Value.substr(3), "0");
				for ( var i=0 ; i < arrAgmtSeq.length ; i++ ) {
					if ( agmtSeq == arrAgmtSeq[i] ) {
						sheetObj.SetCellValue(Row, "agmt_cty_cd",agmtCtyCd,0);
						sheetObj.SetCellValue(Row, "agmt_seq",agmtSeq,0);
						sheetObj.SetCellValue(Row, "chg_seq",arrChgSeq[i],0);
					}
				}
				break;
			case "lse_pay_chg_tp_cd":
				if ( Value == "CRD" ) {
					// 1. Charge Type "CRD" -> CNTR_TPSZ  "BX" Setting , no Edit .
					// 2. Container No.  auto Setting , no Edit .
					sheetObj.SetCellValue(Row, "cntr_no",getCrdCntrNo(sheetObj, Row),0);
					sheetObj.SetCellValue(Row, "cntr_tpsz_cd",vCntrTpSz1);
					sheetObj.SetCellValue(Row, "cost_dys",0);
					sheetObj.SetCellValue(Row, "chg_free_dys",0);
					sheetObj.SetCellValue(Row, "bil_dys",0);
					sheetObj.SetCellValue(Row, "pd_rt_amt",0.0);
					sheetObj.SetCellValue(Row, "ttl_cost_amt",0.0);
					sheetObj.SetCellValue(Row, "cr_amt",0.0);
					sheetObj.SetCellValue(Row, "dscr_onh_dt","");
					sheetObj.SetCellValue(Row, "dscr_onh_loc_cd","");
					sheetObj.SetCellValue(Row, "dscr_offh_dt","");
					sheetObj.SetCellValue(Row, "dscr_offh_loc_cd","");
					sheetObj.SetCellValue(Row, "dscr_rt_amt",0.0);
					sheetObj.SetCellValue(Row, "dscr_cost_amt",0.0);
					sheetObj.SetCellEditable(Row, "cntr_no",0);
					sheetObj.SetCellEditable(Row, "cntr_tpsz_cd",0);
					sheetObj.SetCellEditable(Row, "cost_dys",0);
					sheetObj.SetCellEditable(Row, "chg_free_dys",0);
					sheetObj.SetCellEditable(Row, "bil_dys",0);
					sheetObj.SetCellEditable(Row, "pd_rt_amt",0);
					sheetObj.SetCellEditable(Row, "ttl_cost_amt",0);
					sheetObj.SetCellEditable(Row, "dscr_rt_amt",0);
					sheetObj.SetCellEditable(Row, "dscr_cost_amt",0);
				} else if ( ComTrim(Value) != "" ) {
					sheetObj.SetCellValue(Row, "cost_dys",0);
					sheetObj.SetCellValue(Row, "chg_free_dys",0);
					sheetObj.SetCellValue(Row, "bil_dys",0);
					sheetObj.SetCellValue(Row, "pd_rt_amt",0.0);
					sheetObj.SetCellValue(Row, "ttl_cost_amt",0.0);
					sheetObj.SetCellValue(Row, "cr_amt",0.0);
					sheetObj.SetCellValue(Row, "dscr_onh_dt","");
					sheetObj.SetCellValue(Row, "dscr_onh_loc_cd","");
					sheetObj.SetCellValue(Row, "dscr_offh_dt","");
					sheetObj.SetCellValue(Row, "dscr_offh_loc_cd","");
					sheetObj.SetCellValue(Row, "dscr_rt_amt",0.0);
					if ( sheetObj.GetCellValue(Row, "pay_chg_sts_cd") == "A" ) {
						if ( sheetObj.GetCellValue(Row, "cntr_no") != "" && sheetObj.GetCellValue(Row, "cntr_no").substr(0, 3) == "CRD" ) {
							sheetObj.SetCellValue(Row, "cntr_no","");
							sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
						}
						sheetObj.SetCellEditable(Row, "cntr_no",1);
						//sheetObj.CellEditable(Row, "cntr_tpsz_cd")	= true;
						sheetObj.SetCellEditable(Row, "cost_dys",1);
						sheetObj.SetCellEditable(Row, "chg_free_dys",1);
						sheetObj.SetCellEditable(Row, "bil_dys",1);
						sheetObj.SetCellEditable(Row, "pd_rt_amt",1);
						sheetObj.SetCellEditable(Row, "ttl_cost_amt",1);
						sheetObj.SetCellEditable(Row, "dscr_rt_amt",1);
						sheetObj.SetCellEditable(Row, "dscr_cost_amt",1);
					}
					sheetObj.SetCellEditable(Row, "cr_amt",0);
				}
				break;
			case "onh_loc_cd":
			case "offh_loc_cd":
			case "dscr_onh_loc_cd":
			case "dscr_offh_loc_cd":
				if ( Value != "" ) {
					setLocationAsyncData(sheetObj, Row, Col, Value);
				}
				break;
			case "ttl_cost_amt":
			case "dscr_cost_amt":
				if ( Value < 0 ) {
					sheetObj.SetCellValue(Row, Col,Value * -1,0);
				}
				computeSum(sheetObj);
				break;
			case "cr_amt":
				if ( Value > 0 ) {
					sheetObj.SetCellValue(Row, Col,Value * -1,0);
				}
				computeSum(sheetObj);
				break;
		}
	}
	function t2sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		if ( sheetObj.GetEtcData("TRANS_RESULT_KEY") == "S" ) {			
			var func="parent."+ComGetObjValue(formObj.func)+"();";
			eval(func);
			ComClosePopup(); 
		}
	}
	/**
	 * Sheet Sum compute.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function computeSum(sheetObj) {
		var formObj=document.form;
		var amt=0;
		var cAmt=0;
		var pAmt=0;
		if ( sheetObj.id == "t1sheet1") {
			sheetObj.ReNumberSeq();
			// t1sheet1 Sheet total
			if(sheetObj.RowCount() == 0) {
				amt = 0;
				cAmt = 0;
			}else{
				amt=parseFloat(sheetObj.ComputeSum("|dscr_cost_amt|")*100);
				cAmt=parseFloat(sheetObj.ComputeSum("|cr_amt|")*100);
			}
			// Deleted 
			var delRows=sheetObj.FindStatusRow("D");
			var arrDelRow=delRows.split(";");
			var delCostAmt=0;
			var delCrAmt=0;
			for ( var i=0 ; i < arrDelRow.length-1 ; i++ ) {
				delCostAmt=delCostAmt + (sheetObj.GetCellValue(arrDelRow[i], "dscr_cost_amt")<0?0:sheetObj.GetCellValue(arrDelRow[i], "dscr_cost_amt"))*100;
				delCrAmt=delCrAmt   + (sheetObj.GetCellValue(arrDelRow[i], "cr_amt")<0?0:sheetObj.GetCellValue(arrDelRow[i], "cr_amt"))*100;
			}
			// Total - Delete  Setting : TTL_COST_AMT는 (+), CR_AMT (-)
			ComSetObjValue(formObj.t1pAmt, (amt/100+cAmt/100-delCostAmt/100-delCrAmt/100).toFixed(2));
			ComSetObjValue(formObj.t1cAmt, (cAmt/100-delCrAmt/100).toFixed(2));
			ComSetObjValue(formObj.t1Amt,  (amt/100-delCostAmt/100).toFixed(2));
			//  Format.
			
			
			ComAddSeparator(form.t1pAmt, "float");
			ComAddSeparator(form.t1cAmt, "float");
			ComAddSeparator(form.t1Amt,  "float");
		} else if ( sheetObj.id == "t2sheet1") {
			if ( sheetObj.RowCount()> 0 ) {
				// t2sheet1 Sheet Total
				amt=parseFloat(sheetObjects[1].ComputeSum("|dscr_cost_amt|"));
				cAmt=parseFloat(sheetObjects[1].ComputeSum("|cr_amt|"));
				//  Setting : TTL_COST_AMT (+), CR_AMT (-)
				ComSetObjValue(formObj.t2pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t2cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t2Amt,  amt.toFixed(2));
				//  Format.
				ComAddSeparator(form.t2pAmt, "float");
				ComAddSeparator(form.t2cAmt, "float");
				ComAddSeparator(form.t2Amt,  "float");
			} else {
				ComSetObjValue(formObj.t2pAmt, "");
				ComSetObjValue(formObj.t2cAmt, "");
				ComSetObjValue(formObj.t2Amt,  "");
			}
		} else if ( sheetObj.id == "t3sheet1") {
			if ( sheetObj.RowCount()> 0 ) {
				// t3sheet1 Sheet total
				amt=parseFloat(sheetObjects[2].ComputeSum("|ttl_cost_amt|"));
				cAmt=parseFloat(sheetObjects[2].ComputeSum("|cr_amt|"));
				//  Setting : TTL_COST_AMT (+), CR_AMT (-)
				ComSetObjValue(formObj.t3pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t3cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t3Amt,  amt.toFixed(2));
				//  Format.
				ComAddSeparator(form.t3pAmt, "float");
				ComAddSeparator(form.t3cAmt, "float");
				ComAddSeparator(form.t3Amt,  "float");
			} else {
				ComSetObjValue(formObj.t3pAmt, "");
				ComSetObjValue(formObj.t3cAmt, "");
				ComSetObjValue(formObj.t3Amt,  "");
			}
		} else if ( sheetObj.id == "t4sheet1") {
			if ( sheetObj.RowCount()> 0 ) {
				// t3sheet1 Sheet total
				amt=parseFloat(sheetObjects[3].ComputeSum("|dscr_cost_amt|"));
				cAmt=parseFloat(sheetObjects[3].ComputeSum("|cr_amt|"));
				//  Setting : TTL_COST_AMT (+), CR_AMT (-)
				ComSetObjValue(formObj.t4pAmt, (amt+cAmt).toFixed(2));
				ComSetObjValue(formObj.t4cAmt, cAmt.toFixed(2));
				ComSetObjValue(formObj.t4Amt,  amt.toFixed(2));
				//  Format.
				ComAddSeparator(form.t4pAmt, "float");
				ComAddSeparator(form.t4cAmt, "float");
				ComAddSeparator(form.t4Amt,  "float");
			} else {
				ComSetObjValue(formObj.t4pAmt, "");
				ComSetObjValue(formObj.t4cAmt, "");
				ComSetObjValue(formObj.t4Amt,  "");
			}
		}
	}
	/**
	 * handling process for input validation
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSAVE:
				if ( sheetObj.id == "t1sheet1" ) {
					for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
						if ( ComTrim(sheetObj.GetCellValue(i, "cntr_no")) == "" ) {
							ComShowCodeMessage("LSE01064");
							sheetObj.SelectCell(i, "cntr_no");
							return false;
						}
						if ( ComTrim(sheetObj.GetCellValue(i, "cntr_tpsz_cd")) == "" ) {
							ComShowCodeMessage("LSE01015");
							sheetObj.SelectCell(i, "cntr_tpsz_cd");
							return false;
						}
						if ( ComTrim(sheetObj.GetCellValue(i, "inv_no")) == "" ) {
							ComShowCodeMessage("LSE01104");
							sheetObj.SelectCell(i, "inv_no");
							return false;
						}
						if ( ComTrim(sheetObj.GetCellValue(i, "agmt_no")) == "" ) {
							ComShowCodeMessage("LSE01006");
							sheetObj.SelectCell(i, "agmt_no");
							return false;
						}
						if ( ComTrim(sheetObj.GetCellValue(i, "lse_pay_chg_tp_cd")) == "" ) {
							ComShowCodeMessage("LSE01132");
							sheetObj.SelectCell(i, "lse_pay_chg_tp_cd");
							return false;
						}
					}
				}
				break;
		}
		return true;
	}
	/**
	 * Validation handlign in case of Sheet Object Location Code change <br>
	 * 
	 * @param sheetObj
	 * @param Row  Row index
	 * @param Col  Col index
	 * @param Value
	 */
	function setLocationAsyncData(sheetObj, Row, Col, Value) {
		with(sheetObj) {
if ( GetCellValue(Row,Col) != "" ) {
				var param="f_cmd="  + SEARCH05
						 + "&loc_cd=" + Value
						 + "&loc_tp=" + "SCC";
				//WaitImageVisible = false;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
				//WaitImageVisible = true;
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					if ( ComGetEtcData(sXml, "scc_cd") != undefined ) {
						if ( ComGetEtcData(sXml, "scc_cd") != "" ) {
							var vSccCd=ComGetEtcData(sXml, "scc_cd");
						} else {
							ComShowCodeMessage("LSE01037");
							SetCellValue(Row,Col,"",0);
						}
					} else {
						ComShowCodeMessage("LSE01037");
						SetCellValue(Row,Col,"",0);
						SelectCell(Row,Col);
					}
				}
			}
		}
	}
	/**
	 *Validation handlign in case of Sheet Object Location Code change<br>
	 * 
	 * @param sheetObj
	 * @param Row  Row index
	 * @param Col  Col index
	 * @param Value
	 */
	function setCntrTpSzAsyncData(sheetObj, Row, Col, Value) {
		with(sheetObj) {
if ( GetCellValue(Row,Col) != "" ) {
				var param="f_cmd="  + SEARCH17
						 + "&cntr_no=" + Value;
				//WaitImageVisible = false;
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
				//WaitImageVisible = true;
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					if ( ComGetEtcData(sXml, "cntr_tpsz_cd") != undefined ) {
						if ( ComGetEtcData(sXml, "cntr_tpsz_cd") != "" ) {
							sheetObj.SetCellValue(Row, "cntr_tpsz_cd",ComGetEtcData(sXml,"cntr_tpsz_cd"));
						} else {
							sheetObj.SetCellValue(Row, "cntr_tpsz_cd","XX");
						}
					} else {
						sheetObj.SetCellValue(Row, "cntr_tpsz_cd","XX");
					}
				} else {
					sheetObj.SetCellValue(Row, "cntr_tpsz_cd","XX");
				}
			}
		}
	}
	/**
	 * Credit Charge Type  CNTR No. 
	 * @param sheetObj
	 * @param Row
	 * @return vCrdCntrNo
	 */
	function getCrdCntrNo(sheetObj, Row) {
		var formObj=document.form;
		var vCrdMaxSeq=0;
		var vCrdCntrNo="CRD" + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon), "-", "").substr(2);
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++ ) {
			if ( sheetObj.GetCellValue(i, "lse_pay_chg_tp_cd") == "CRD" && i != Row ) {
				var vCrdSeq=ComParseInt(ComLtrim(sheetObj.GetCellValue(i, "cntr_no").substr(7), "0"));
				if ( vCrdMaxSeq < vCrdSeq ) {
					vCrdMaxSeq=vCrdSeq;
				}
			}
		}
		vCrdCntrNo=vCrdCntrNo + ComLpad((vCrdMaxSeq+1)+"", 4, "0");
		return vCrdCntrNo;
	}
	/**
	 * BackEndJob  Status='3' check
	 */
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND02;
		var sXml=sheetObj.GetSearchData("EES_LSE_0007_01GS.do", FormQueryString(formObj));
		//sheetObj.WaitImageVisible = true;
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("LSE01124");
			ComOpenWait(false);
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("LSE01125");
			clearInterval(timer1);
		}
	}
	function getBackEndJobLoadFile() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.f_cmd.value=COMMAND03;
		var sXml=sheetObj.GetSearchData("EES_LSE_0007_01GS.do", FormQueryString(form));
		var arrXml=sXml.split("|$$|");
		if ( arrXml.length > 0 ) {
			if ( ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S" ) {
//				if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
//				if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
//				if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
//				if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
				if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
				if (arrXml.length > 1) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:0} );
				if (arrXml.length > 2) sheetObjects[2].LoadSearchData(arrXml[2],{Sync:0} );
				if (arrXml.length > 3) sheetObjects[3].LoadSearchData(arrXml[3],{Sync:0} );
				computeSum(sheetObjects[0]);
				computeSum(sheetObjects[1]);
				computeSum(sheetObjects[2]);
				computeSum(sheetObjects[3]);
			}
		}
		if ( sheetObjects[0].RowCount()> 0 ) {
			for ( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++ ) {
				if ( sheetObjects[0].GetCellValue(i, "pay_chg_sts_cd") == "C" ) {
					sheetObjects[0].SetCellEditable(i, "chkbox",0);
				}
			}
		}
		// Wrong Discrepancy Data marking
		if ( sheetObjects[1].RowCount()> 0 ) {
			var rgbCd="#FF0000";
			for ( var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++ ) {
				if ( sheetObjects[1].GetCellValue(i, "onh_dt") != sheetObjects[1].GetCellValue(i, "dscr_onh_dt") ) {
					sheetObjects[1].SetCellFont("FontColor", i, "onh_dt",rgbCd);
					sheetObjects[1].SetCellFont("FontColor", i, "dscr_onh_dt",rgbCd);
					sheetObjects[1].SetCellFont("FontBold", i, "onh_dt",1);
					sheetObjects[1].SetCellFont("FontBold", i, "dscr_onh_dt",1);
				}
				if ( sheetObjects[1].GetCellValue(i, "offh_dt") != sheetObjects[1].GetCellValue(i, "dscr_offh_dt") ) {
					sheetObjects[1].SetCellFont("FontColor", i, "offh_dt",rgbCd);
					sheetObjects[1].SetCellFont("FontColor", i, "dscr_offh_dt",rgbCd);
					sheetObjects[1].SetCellFont("FontBold", i, "offh_dt",1);
					sheetObjects[1].SetCellFont("FontBold", i, "dscr_offh_dt",1);
				}
				if ( sheetObjects[1].GetCellValue(i, "pd_rt_amt") != sheetObjects[1].GetCellValue(i, "dscr_rt_amt") ) {
					sheetObjects[1].SetCellFont("FontColor", i, "pd_rt_amt",rgbCd);
					sheetObjects[1].SetCellFont("FontColor", i, "dscr_rt_amt",rgbCd);
					sheetObjects[1].SetCellFont("FontBold", i, "pd_rt_amt",1);
					sheetObjects[1].SetCellFont("FontBold", i, "dscr_rt_amt",1);
				}
				if ( sheetObjects[1].GetCellValue(i, "ttl_cost_amt") != sheetObjects[1].GetCellValue(i, "dscr_cost_amt") ) {
					sheetObjects[1].SetCellFont("FontColor", i, "ttl_cost_amt",rgbCd);
					sheetObjects[1].SetCellFont("FontColor", i, "dscr_cost_amt",rgbCd);
					sheetObjects[1].SetCellFont("FontBold", i, "ttl_cost_amt",1);
					sheetObjects[1].SetCellFont("FontBold", i, "dscr_cost_amt",1);
				}
			}
		}
		ComOpenWait(false);
	}
	
	function LseGetAllSaveText4LSE0007(sheetObj,TrimComma,Status, prefix) {
		if (TrimComma==undefined || TrimComma==null) TrimComma=false;
		if (Status==undefined || Status==null) Status="ibflag";
		if (prefix==undefined || prefix==null) prefix="";
		var arrSave=new Array();
		for(var i=0 ; i <= sheetObj.LastCol();i++){
			arrSave[i]=sheetObj.ColSaveName(i);
		}
		var str=sheetObj.GetRangeText(sheetObj.HeaderRows(),0,sheetObj.LastRow(),sheetObj.LastCol(),"|","^");
		if(TrimComma)
			str=str.replace(/\,/gi, "");
		var arrStr=str.split("^");
		
		for(var i=0; i<arrStr.length; i++) {
			var arrCol=arrStr[i].split("|");
			for(var j=0; j<arrCol.length; j++){
				if(arrSave[j] == Status){
					switch(arrCol[j]) {
					case "Insert": arrCol[j]="I"; break;
					case "Update": arrCol[j]="U"; break;
					case "Delete": arrCol[j]="D"; break;
					default:    arrCol[j]="R"; break;
					}
				}
				arrCol[j]=prefix + arrSave[j]+"="+arrCol[j];
			}
			arrStr[i]=arrCol.join("&");
		}
		
		return  arrStr.join("&");
	}
	/* end of developer job */
