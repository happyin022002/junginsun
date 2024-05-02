/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_05.js
*@FileTitle  : e-Booking & SI Process Detail(C/M)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
           MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
           Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// public variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var iterator="|$$|";
	var isCopy="false";
	var selRow=0;
	var selCol=0;
	var arrXml;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/** *** If sheets are more than 2 in one tab, use additional sheet variables **** */
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_cancelcopydata":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
				isCopy="false";
				top.isCopyAllRequested=false;
				//ComBtnColor("btn_cancelcopydata", "blue");
				//ComBtnColor("btn_datacopytoopus", "#737373");
				//ComBtnColor("btn_copyfromcntr", "#737373");
				
				
				document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
				document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
				document.getElementById("btn_copyfromcntr").style.cssText = "color:#737373 !important;font-weight:normal;";
				
				multiShipmentBthClassCheck(false);
				break;
			case "btn_datacopytoopus":
				if (isCopy == "false") {
					dataCopy('0229_05');
				}
				break;
			case "btn_upload":
				if (!parent.frames["t3frame"].document.form) break;
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_copyfromcntr":
				cntrDataCopy('0229_05');
				break;
			case "btn_t9multishp":
//				if(formObject.bkg_no.value == '' ){
//					ComShowMessage(ComGetMsg("BKG00463"));
//					formObject.bkg_no.focus();
//				}else{
					var url="ESM_BKG_0391.do?func=callbackMultiShp&bkg_no=" + formObject.bkg_no.value + "&ui_no=ESM_BKG_0229";
					ComOpenWindowCenter(url, "ESM_BKG_0391", 1200, 590, true);
//				}
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
	function initControl() {
		applyShortcut();
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag 
	 */
	function loadPage() {
		//ComOpenWait(true);
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		initControl();
		//ComOpenWait(false);
		//vixen sheetObjects[0].SetVisible(true);
		//vixen sheetObjects[1].SetVisible(true);
		//sheet1_OnLoadFinish(sheetObjects[0]);
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * setting sheet initial values and header param : sheetObj , sheetNo 
	 adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="| |Container No.||Package|Package||Weight|Weight||Measure|Measure";
			      var HeadTitle2="| |1||HTS Code|HTS Code||HS Code|HS Code||NCM Code|NCM Code";
			      var HeadTitle3="| |Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|P/O No.|P/O No.";
			      var HeadTitle4="| |Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|DG Seq|DG Seq";
			      var HeadTitle5="| |Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Manifest File No|Manifest File No";
			      var prefix="sheet1_";
			      SetConfig( { SearchMode:2, Page:20, MergeSheet: 1, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"},
				                  { Text:HeadTitle3, Align:"Center"},
				                  { Text:HeadTitle4, Align:"Center"},
				                  { Text:HeadTitle5, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0}, 
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			                    {Type:"Text",      Hidden:0,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_no_old",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Int",       Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep3",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, InputCaseSensitive:1 }
			                   ],
			                   [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"tmp" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep1",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"PopupEdit", Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"PopupEdit", Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep3",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"PopupEdit", Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no1",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                   ],
			                   [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"tmp" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"po_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"po_no1",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               ],
				               [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"tmp" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Combo",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Combo",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_seq1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				               ],
				               [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"tmp" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
			                   ]];
			      InitColumns(cols, 5);
			      SetEditable(1);
			      sheetObjects[0].SetDataAutoTrim(0);
			      //cnt=0;
			      SetShowButtonImage(2);
			      SetSheetHeight(502);
			      //vixen SetVisible(false);
				}
			break;
			
		case "sheet2":
		    with(sheetObj){
			      var HeadTitle1="| |Container No.||Package|Package||Weight|Weight||Measure|Measure";
			      var HeadTitle2="| |1||HTS Code|HTS Code||HS Code|HS Code||NCM Code|NCM Code";
			      var HeadTitle3="| |Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|Description(Total Container : 0)|P/O No.|P/O No.";
			      var HeadTitle4="| |Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|Description Detail(s)|DG Seq|DG Seq";
			      var HeadTitle5="| |Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Mark & NOS|Manifest File No|Manifest File No";
			      var prefix="sheet2_";
			      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"},
			                  { Text:HeadTitle3, Align:"Center"},
			                  { Text:HeadTitle4, Align:"Center"},
			                  { Text:HeadTitle5, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ [{Type:"Status",    Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Int",       Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Float",     Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:0 },
			                   ], 
			                   [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"sep3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               ], 
			                   [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"po_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"po_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               ], 
			                   [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_dtl_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"dcgo_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				               ], 
			                   [{Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
			                    {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:1,  Width:1,    Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                    {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"cntr_mf_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } 
			                   ]];
			      InitColumns(cols, 5);
			      SetEditable(1);
			      sheetObjects[1].SetDataAutoTrim(0);
			      cnt=0;
			      SetShowButtonImage(2);
			      SetSheetHeight(502);
			      //vixen SetVisible(false);
			}
			break;
			
		case "sheet3":
		    with(sheetObj){
			      var HeadTitle="cntr_no|dcgo_seq|diff_rmk";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetAutoRowHeight(0);
			      SetVisible(false);
				}
			break;
			
			case "sheet4":
				with(sheetObj){
				var HeadTitle="|CntrSeq|MfSeq.|Package|Package|TP/SZ|Weight|WgtUnit|Measure|MeasUnit|Marks|Description|Vol|prn_flg|CNTR_SEAL_NO1|CNTR_SEAL_NO2|CMDT_HS_CD|HAMO_TRF_CD|NCM_NO|PO_NO";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",		Hidden:0,	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",			Hidden:0,	Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      	Hidden:0,	Width:40,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",       	Hidden:0,	Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				             {Type:"Text",      	Hidden:0,	Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",			Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",     		Hidden:0,	Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      	Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",     		Hidden:0,	Width:80,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				             {Type:"Text",      	Hidden:0,	Width:60,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mk_desc",			 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
				             {Type:"Text",      	Hidden:0,	Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_desc",		 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
				             {Type:"Text",      	Hidden:0,	Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_vol_qty",		 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:60,   Align:"Center",   ColMerge:0,   SaveName:"prn_flg",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cntr_seal_no1",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cntr_seal_no2",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"cmdt_hs_cd",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"hamo_trf_cd",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"ncm_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      	Hidden:0,	Width:80,   Align:"Center",   ColMerge:0,   SaveName:"po_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
				             ];
			       
					InitColumns(cols);
					SetSheetHeight(202);
					SetEditable(1);
					SetVisible(false);
				}
			break;
		
			case "sheet5":
				with(sheetObj){
				var HeadTitle="cntr_seq|xter_rqst_no|xter_rqst_seq|cntr_no|cntr_mf_seq|pck_qty|pck_tp_cd|cntr_mf_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|mk_desc|cmdt_desc|cntr_mf_dtl_desc|hamo_trf_cd|ncm_no|cmdt_hs_cd|dcgo_seq|po_no|cntr_seal_no1|cntr_seal_no2";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ 
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seq",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_no",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:1,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xter_rqst_seq",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_seq",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_wgt",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"meas_qty",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:110,   Align:"Center",  ColMerge:0,   SaveName:"mk_desc",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_desc",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:110,   Align:"Center",  ColMerge:0,   SaveName:"cntr_mf_dtl_desc",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:100,   Align:"Center",  ColMerge:0,   SaveName:"hamo_trf_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ncm_no",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hs_cd",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_seq",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:80,   Align:"Center",  ColMerge:0,   SaveName:"po_no",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no1",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",	Hidden:0,	Width:130,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no2",	KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
				             ];
					InitColumns(cols);
					SetSheetHeight(202);
					SetEditable(1);
					SetVisible(false);
				}
			break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSAVE:
			if (!validateForUpload()) return false;
			var params=getSaveStringForUpload();
			return false;
			var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0229_05GS.do", params, false);
			var rMsg=ComResultMessage(sXml);
			if (rMsg == '') {
			} else {
			}
			break;
		case IBSEARCH_ASYNC01: // retrieve
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case IBSEARCH: // retrieve
			//ComOpenWait(true);
			var sXml=formObj.sXml.value;
			arrXml=sXml.split("|$$|");
			var headTitle3="";
			var rowKnt=0;
			var colKnt=0;
			for ( var i=0; i < 2; i++) {
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				rowKnt=0;
				colKnt=0;
				rowKnt=(sheetObjects[i].RowCount()- sheetObjects[i].HeaderRows()) / sheetObjects[i].DataRows + 1;
				colKnt=sheetObjects[i].LastCol()+ 1;
				headTitle3="| ";
				for (var j=0; j < colKnt-2; j++) {
					if (j > 1) {
						headTitle3=headTitle3 + "|Description(Total Container : " + rowKnt + ")";
					}				
				}
				//sheetObjects[i].RenderSheet(1);
			}
			// DG Seq can select
			var cntr_no=sheetObjects[0].GetCellValue(5, 'cntr_no');
			var cntrSheet=sheetObjects[2];
			var dcgoList='';
			var dcgovalue='';
			dcgoList=dcgoList + " |";
			dcgovalue=dcgovalue + " |";
			for(var i=cntrSheet.HeaderRows();i<=cntrSheet.LastRow();i++){
				if( cntr_no == cntrSheet.GetCellValue(i, "cntr_no") ){
					dcgoList=dcgoList + cntrSheet.GetCellValue(i, "diff_rmk")+"|";
					dcgovalue=dcgovalue + cntrSheet.GetCellValue(i, "dcgo_seq") + "|";
				}
			}
			sheetObj.SetColProperty("dcgo_seq", {ComboText:dcgoList, ComboCode:dcgovalue} );
			sheetObj.SetColProperty("dcgo_seq1", {ComboText:dcgoList, ComboCode:dcgovalue} );
			
			for ( var i=0; i < 2; i++) {
				//v sheetObjects[i].RenderSheet(0);
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				//sheetObjects[i].LoadSearchData(arrXml[i]);
				rowKnt=0;
				colKnt=0;
				rowKnt= (sheetObjects[i].RowCount()- sheetObjects[i].HeaderRows()) / sheetObjects[i].DataRows + 1;
				colKnt=sheetObjects[i].LastCol()+ 1;
				headTitle3="| ";
				for (var j=0; j < colKnt-2; j++) {
					if (j > 1) {
						headTitle3=headTitle3 + "|Description(Total Container : " + rowKnt + ")";
					}				
//					sheetObjects[i].InitHeadRow(2, headTitle3, true); //TODO: Checking
//					changeHeaderRow(sheetObjects[i], 2, headTitle3); // sheetObjects[i].DataRows return wrong data. So this function works incorrect
				}
				//sheetObjects[i].RenderSheet(1);
			}
			if (sheetObjects[0].GetTotalRows()> 0) {
				formObj.cm_opus.value="Y";
			} else {
				formObj.cm_opus.value="N";
			}		
			if (sheetObjects[1].GetTotalRows()> 0) {
				formObj.cm_esvc.value="Y";
				for ( var k=9; k < sheetObjects[1].LastRow(); k=k+5) {
					for ( var l=2; l < 10; l++) {
						sheetObjects[1].SetCellValue(k, l,sheetObjects[1].GetCellValue(k, 2),0);
					}
				}
			} else {
				formObj.cm_esvc.value="N";
			}
			if(top.document.form.tabload5.value == "COPY"){
				dataCopy('0229_05');
			}
			top.document.form.tabload5.value="LOAD";
			//ComOpenWait(false);
			setCellMerge();		
			
			formObj.f_cmd.value=SEARCH;
			var rXml=sheetObjects[3].GetSearchData("ESM_BKG_0391GS.do", FormQueryString(formObj));
			ComEtcDataXmlToForm(rXml, formObj);
			sheetObjects[3].LoadSearchData(rXml,{Sync:1} );
			
			multiShipmentBthClassCheck(false);
			
			if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_05');
			break;
		case IBSEARCH_ASYNC02: // Data Copy
			var cntrNo="";
			var cntr_mf_seq=0;
			var foundRow=0;
			var foundFlg="N";
			var fromRow=0;
			var toRow=0;
			var l=0;
			var rightSelectRow = sheetObjects[0].GetSelectRow();
			var leftSelectRow = sheetObjects[1].GetSelectRow();
			for ( var i=5; i < getMultiLineSheetRowIndex(sheetObjects[1]) + 5; i++) {
				if (i % 5 == 0) {
					cntrNo=sheetObjects[1].GetCellValue(i, "cntr_no");
					fromRow=i;
				} else if (i % 5 == 1) {
					if (sheetObjects[1].GetCellValue(i-1, "cntr_no") == sheetObjects[1].GetCellValue(i - 6, "cntr_no")) {
						cntr_mf_seq=cntr_mf_seq + 1;
					} else {
						cntr_mf_seq=1;
					}
				} else if (i % 5 == 4) {
					
					if(cntrNo == 'No Data' && !dataCopyAllFlg) continue;
					
					foundFlg="N";
					foundRow=sheetObjects[0].FindText("cntr_no", cntrNo);
					if (foundRow != 0) {
						while (foundRow != -1) {
							if (BkgParseFloat(sheetObjects[0].GetCellValue(foundRow + 1, "cntr_mf_seq")) == cntr_mf_seq) {
								toRow=foundRow;
								foundFlg="Y";
								break;
							} else {
								toRow=foundRow + 4;
							}
							foundRow=sheetObjects[0].FindText("cntr_no", cntrNo, foundRow + 1);
						}
					} else {
						toRow=sheetObjects[0].RowCount()+ 4;
					}
					if (foundFlg == "Y") {
						for ( var k=0; k < 5; k++) {
							if ( k == 3 ) {
								for ( l=1; l < 10; l++) {
									sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
								}
								for ( l=1; l < 10; l++) { 										
									sheetObjects[0].SetCellValue(k + toRow -1, l,sheetObjects[1].GetCellValue(k + fromRow -1, l),0);
								}
								for ( l=10; l < 12; l++) {
									if (ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)) != null && ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)).length > 0 ) {
										sheetObjects[0].SetCellValue(k + toRow, l,ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)),0);
									}
								}
							} else {
								if ( k == 4 ) {
									for ( l=1; l < 12; l++) {
										if ( l < 10 ) {
											sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
										} else {
											if ( sheetObjects[1].GetCellValue(k + fromRow, l) != null && ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)).length > 0 )
												sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
										}
									}
								} else {
									if ( k == 2 ){
										if (ComTrim(sheetObjects[0].GetCellValue(k + toRow, 2)) == null && ComTrim(sheetObjects[0].GetCellValue(k + toRow, 2)).length == 0 ) {
											for ( l=1; l < 10; l++) {
												sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
											}
										}
										if (ComTrim(sheetObjects[1].GetCellValue(k + fromRow, 10)) != null && ComTrim(sheetObjects[1].GetCellValue(k + fromRow, 10)).length > 0 ) {
											for ( l=10; l < 12; l++) {
												sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
											}
										}
									} else {
										for ( l=1; l < 12; l++) {
											sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
										}
									}
								}
							}
						}
					} else {
						toRow=sheetObjects[0].DataInsert(-1); //toRow);
						for( var k=0; k < 5; k++) {
							if ( k == 3 ) {
								if (ComTrim(sheetObjects[0].GetCellValue(k + toRow -1, 2)) != null && ComTrim(sheetObjects[0].GetCellValue(k + toRow -1, 2)).length > 0 ) {
									for ( l=1; l < 10; l++) { 
										sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
									}
								} else {
									for ( l=1; l < 10; l++) { 
										sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
										sheetObjects[0].SetCellValue(k + toRow -1, l,sheetObjects[1].GetCellValue(k + fromRow -1, l),0);
									}
								}
								for ( l=10; l < 12; l++) {
									if (ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)) != null && ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)).length > 0 ) {
										sheetObjects[0].SetCellValue(k + toRow, l,ComTrim(sheetObjects[1].GetCellValue(k + fromRow, l)),0);
									}
								}
							} else {
								for ( l=1; l < 12; l++) {
									sheetObjects[0].SetCellValue(k + toRow, l,sheetObjects[1].GetCellValue(k + fromRow, l),0);
								}
							}
						}
					}
				}
			}
			for ( var i=5; i < sheetObjects[0].RowCount()+ 5; i=i + 5) {
				if (sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[0].GetCellValue(i - 5, "cntr_no")) {
					sheetObjects[0].SetCellValue(i+1, "cntr_mf_seq",BkgParseFloat(sheetObjects[0].GetCellValue(i+1 - 5, "cntr_mf_seq")) + 1);
				} else {
					sheetObjects[0].SetCellValue(i+1, "cntr_mf_seq",1);
				}
			}
			setCellMerge(); 
			sheetObjects[0].SelectCell(rightSelectRow,1);
			sheetObjects[1].SelectCell(leftSelectRow, 1);
			isCopy="true";
			break;
			
		case IBSEARCH_ASYNC03: // CNTR Data Copy
			var cntrNo="";
			var cntr_mf_seq=0;
			var foundRow=0;
			var foundFlg="N";
			var fromRow=0;
			var toRow=0;
			var ibflag="";
			parent.frames["t3frame"].doCntrSaveCopy();
			var cstmsDesc="";
			if (parent.frames["t4frame"].document.form){
				cstmsDesc=parent.frames["t4frame"].document.form.cstms_desc.value;
			}
			var rightSelectRow = sheetObjects[0].GetSelectRow();
			var leftSelectRow = parent.frames["t3frame"].sheetObjects[0].GetSelectRow();
			for ( var i=1; i < parent.frames["t3frame"].sheetObjects[0].RowCount()+ 1; i++) {
				cntrNo=parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "cntr_no");
				ibflag=parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "ibflag");
				if ( cntrNo == "" ) {
					break;
				}
				if ( ibflag != 'D' ){
					fromRow=i;
					cntr_mf_seq=1;
					foundFlg="N";
					foundRow=sheetObjects[0].FindText("cntr_no", cntrNo);
					if (foundRow != 0) {
						while (foundRow != -1) {
							if (BkgParseFloat(sheetObjects[0].GetCellValue(foundRow + 1, "cntr_mf_seq")) == cntr_mf_seq) {
								toRow=foundRow;
								foundFlg="Y";
								break;
							} else {
								toRow=foundRow + 4;
							}
							foundRow=sheetObjects[0].FindText("cntr_no", cntrNo, foundRow + 1);
						}
					} else {
						toRow=sheetObjects[0].RowCount();
					}			
					if (foundFlg == "Y") {
						for ( var k=0; k < 5; k++) {
							if ( k == 0 ) {
								sheetObjects[0].SetCellValue(k + toRow, 4,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "pck_qty"),0);
								sheetObjects[0].SetCellValue(k + toRow, 5,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "pck_tp_cd"),0);
								sheetObjects[0].SetCellValue(k + toRow, 7,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "cntr_wgt"),0);
								sheetObjects[0].SetCellValue(k + toRow, 8,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "wgt_ut_cd"),0);
								sheetObjects[0].SetCellValue(k + toRow, 10,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "meas_qty"),0);
								sheetObjects[0].SetCellValue(k + toRow, 11,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "meas_ut_cd"),0);
							} else if (k==2){
								for(var colIdx=1;colIdx<10;colIdx++){
									sheetObjects[0].SetCellValue(k + toRow, colIdx,cstmsDesc,0);
								}
							}
						}
					} else {	
						toRow=sheetObjects[0].DataInsert(-1);
						var cntrSeq=getMultiLineSheetRowIndex(sheetObjects[0])/5;
						for( var k=0; k < 5; k++) {
							if ( k == 0 ) {
								sheetObjects[0].SetCellValue(k + toRow, 1,cntrSeq,0);
								sheetObjects[0].SetCellValue(k + toRow, 2,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "cntr_no"),0);
								sheetObjects[0].SetCellValue(k + toRow, 4,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "pck_qty"),0);
								sheetObjects[0].SetCellValue(k + toRow, 5,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "pck_tp_cd"),0);
								sheetObjects[0].SetCellValue(k + toRow, 7,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "cntr_wgt"),0);
								sheetObjects[0].SetCellValue(k + toRow, 8,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "wgt_ut_cd"),0);
								sheetObjects[0].SetCellValue(k + toRow, 10,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "meas_qty"),0);
								sheetObjects[0].SetCellValue(k + toRow, 11,parent.frames["t3frame"].sheetObjects[0].GetCellValue(i, "meas_ut_cd"),0);
							} else if (k==2){
								sheetObjects[0].SetCellValue(k + toRow, 1,cntrSeq,0);
								for(var colIdx=1;colIdx<10;colIdx++){
									sheetObjects[0].SetCellValue(k + toRow, colIdx,cstmsDesc,0);
								}						
							} else {
								for ( var l=1; l < 12; l++) {
									if ( l == 1 ) {
										sheetObjects[0].SetCellValue(k + toRow, l,cntrSeq,0);
									} else if ( k == 1 ) {
									} else {
										sheetObjects[0].SetCellValue(k + toRow, l," ",0);
									}
								}
							}
							//v sheetObjects[0].SetRowMerge(k + toRow + 5,1);
						}
					}
				}
			}
			//for ( var i=5; i < sheetObjects[0].RowCount()+ 5; i=i + 5) { getMultiLineSheetRowIndex(sheetObjects[0])
			for ( var i=5; i < getMultiLineSheetRowIndex(sheetObjects[0]) + 5; i=i + 5) { 
				if (sheetObjects[0].GetCellValue(i, "cntr_no") == sheetObjects[0].GetCellValue(i - 5, "cntr_no")) {
					sheetObjects[0].SetCellValue(i+1, "cntr_mf_seq",BkgParseFloat(sheetObjects[0].GetCellValue(i+1 - 5, "cntr_mf_seq")) + 1);
				} else {
					sheetObjects[0].SetCellValue(i+1, "cntr_mf_seq",1);
				}
			}
			setCellMerge(); 
			sheetObjects[0].SelectCell(rightSelectRow,1);
			sheetObjects[1].SelectCell(leftSelectRow, 1);
			isCopy="true";
			break;
		}
	}
	
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var porCd=parent.frames["t1frame"].document.form.bkg_por_cd.value;
		var polCd=parent.frames["t1frame"].document.form.bkg_pol_cd.value;
		var podCd=parent.frames["t1frame"].document.form.bkg_pod_cd.value;
		var delCd=parent.frames["t1frame"].document.form.bkg_del_cd.value;
		for(var ix=5;ix<sheetObj.RowCount()+5;ix++){
			if(ix % 5 ==0){ //1 row
				if(sheetObj.GetCellValue(ix, 4) == ''||sheetObj.GetCellValue(ix, 4) == null||sheetObj.GetCellValue(ix, 4) == 0) { //pck_qty
					ComShowMessage(ComGetMsg("BKG00504"));
					return false;
				}
				if(sheetObj.GetCellValue(ix, 5) == ''||sheetObj.GetCellValue(ix, 5) == null) { //pck_tp_cd
					ComShowMessage(ComGetMsg("BKG00505"));
					return false;
				}			
			} else if(ix%5==1){ 
				if((ComTrim(sheetObj.GetCellValue(ix, 4)) != '' && ComTrim(sheetObj.GetCellValue(ix, 4)) != null) && ComTrim(sheetObj.GetCellValue(ix, 4)).length < 6) {//hamo_trf_cd
					ComShowMessage(ComGetMsg("BKG00334", 'HTS'));
					return false;
				}
				if((ComTrim(sheetObj.GetCellValue(ix, 7)) != '' && ComTrim(sheetObj.GetCellValue(ix, 7)) != null) && ComTrim(sheetObj.GetCellValue(ix, 7)).length < 6) {//cmdt_hs_cd
					ComShowMessage(ComGetMsg("BKG00334", 'HS'));
					return false;
				}
				if(ComTrim(sheetObj.GetCellValue(ix, 10)) == ''||ComTrim(sheetObj.GetCellValue(ix, 10))==null) {//ncm_no
					var por_cnty=(porCd == '') ? '' : porCd.substring(0, 2);
					var pol_cnty=(polCd == '') ? '' : polCd.substring(0, 2);
					var pod_cnty=(podCd == '') ? '' : podCd.substring(0, 2);
					var del_cnty=(delCd == '') ? '' : delCd.substring(0, 2);
					if(por_cnty == 'BR' || pol_cnty == 'BR' || pod_cnty == 'BR' || del_cnty == 'BR'){
						ComShowMessage(ComGetMsg("BKG00334", 'NCM'));
						return false;
					}
				}else{
					if((ComTrim(sheetObj.GetCellValue(ix, 10)) != '' && ComTrim(sheetObj.GetCellValue(ix, 10)) != null) && ComTrim(sheetObj.GetCellValue(ix, 10)).length < 4) {//ncm_no
						ComShowMessage(ComGetMsg("BKG00334", 'NCM'));
						return false;
					}					
				}			
			} else if(ix % 5 == 2){ //3 row
				if(sheetObj.GetCellValue(ix, 3).trim() == '') {
					ComShowMessage(ComGetMsg("BKG01042"));
					return false;
				}
			}
		} // end of FOR
		
		var foundRow = 0;
		for(var x = sheetObj.HeaderRows(); x < sheetObj.LastRow(); x++){
			if(x % 5 ==0) { //1 row
				if(parent.frames["t3frame"].document.form){
					foundRow=parent.frames["t3frame"].sheetObjects[0].FindText("cntr_no", sheetObj.GetCellValue(x, "cntr_no"));
					if (foundRow < 0) {
						ComShowMessage(ComGetMsg("BKG43062"));
						sheetObj.SetFocus();
						return false;
					}
				}else{
					ComShowMessage(ComGetMsg("BKG08324"));
					return false;
				}
			}
		}		
		
		return true;
	}
	
	function validateForUpload() {
	 	return validateForm(sheetObjects[0], document.form, IBSAVE);
	}
	
	function getSaveStringForUpload() {
	  	var formObj = document.form;
	  	formObj.f_cmd.value = MULTI;
	  	var params = "";
	  	if (sheetObjects[0].RowCount()>0) {
	  		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
	  	}
	  	
	  	if(sheetObjects[3].RowCount()>0){
	  		params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true), "sheet3_");
	  	}
	  	
	  	if(params != "") params = params + "&" + "f_cmd=" + MULTI;
	  	
	  	return (params);
	}
	
	function dataCopy(cell) {
			
		if(!opener) {
			opener=parent;
		}
		var formObj = opener.document.form;
		var param = "bkg_no=" + formObj.bkg_no.value;
		param = param + "&rqst_no=" + formObj.rqst_no.value;
		param = param + "&rqst_seq=" + formObj.rqst_seq.value;
		param = param + "&sender_id=" + formObj.sender_id.value;
		param = param + "&f_cmd=101";
		
		var rtnData = sheetObjects[4].GetSaveData("ESM_BKG_0229_0501GS.do", param);
		sheetObjects[4].LoadSaveData(rtnData);
		if(formObj.doc_tp_cd.value == 'B' && cell == undefined) return;
		
		var rowCount = sheetObjects[4].RowCount();
		var headerRows = sheetObjects[4].HeaderRows();
		if(rowCount > 0){
			var confirm = false;
			for (var i = headerRows; i < rowCount + headerRows; i++) {
				var cntrNo = sheetObjects[4].GetCellText(i, 'cntr_no');
				if (cntrNo == 'No Data') {
					confirm = true;
				} 
			}
			
			if(confirm){
				if(ComShowConfirm('There is no container No, in CM TAB.\nDo you want to copy the CM information to Multi-Shipment?\n(Please delete it if there is no Container No. in CNTR Tab)')){
					shipmentSearchEnd(sheetObjects[4]);
					xterDataCopy(false);
				}else{
					xterDataCopy(true);
				}
			}else{
				xterDataCopy(true);
			}
		}else{
			xterDataCopy(true);
		}
		
		multiShipmentBthClassCheck(true);
	}
	
	var dataCopyAllFlg = false;
	
	function xterDataCopy(all) {
		dataCopyAllFlg = all;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
		///document.getElementById("btn_cancelcopydata").style.cssText = "color:737373 !important;font-weight:normal;";
		//document.getElementById("btn_datacopytoopus").style.cssText = "color:#blue !important;font-weight:normal;";
		//document.getElementById("btn_copyfromcntr").style.cssText = "color:#blue !important;font-weight:bold;";		
	}
	
	function cntrDataCopy() {
		if(parent.frames["t3frame"].document.form){
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
			document.getElementById("btn_cancelcopydata").style.cssText = "color:737373 !important;font-weight:normal;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			document.getElementById("btn_copyfromcntr").style.cssText = "color:#blue !important;font-weight:bold;";
		}		
	}
	
	function compareItem() {
		var formObj=document.form;
	}
	/**
	 * Additional data thing
	 */
	function insertSheet(cntrNo, pos) {
		var lastRow=5;
		//sheetObjects[0].RenderSheet(0);
		var sXml1=IBS_GetDataSearchXml(sheetObjects[1]);
		sheetObjects[0].SetDataAutoTrim(0);
		sXml1=ComReplaceStr(sXml1, "<TR", "<TR MERGE='TRUE'");
		sheetObjects[0].LoadSearchData(sXml1,{Append:1 , Sync:1} );
		//sheetObjects[0].RenderSheet(1);
	}
	/**
	 * modifying one data 
	 */
	function updateSheet(cntrNo, lastRow, pos) {
		sheetObjects[0].SetCellValue(lastRow, "cntr_no",sheetObjects[1].GetCellValue(pos, "cntr_no"));
		sheetObjects[0].SetCellValue(lastRow, "pck_qty",sheetObjects[1].GetCellValue(pos, "pck_qty"));
		sheetObjects[0].SetCellValue(lastRow, "pck_tp_cd",sheetObjects[1].GetCellValue(pos, "pck_tp_cd"));
		sheetObjects[0].SetCellValue(lastRow, "cntr_mf_wgt",sheetObjects[1].GetCellValue(pos, "cntr_mf_wgt"));
		sheetObjects[0].SetCellValue(lastRow, "wgt_ut_cd",sheetObjects[1].GetCellValue(pos, "wgt_ut_cd"));
		sheetObjects[0].SetCellValue(lastRow, "meas_qty",sheetObjects[1].GetCellValue(pos, "meas_qty"));
		sheetObjects[0].SetCellValue(lastRow, "meas_ut_cd",sheetObjects[1].GetCellValue(pos, "meas_ut_cd"));
		sheetObjects[0].SetCellValue(lastRow, "sep1","|");
		sheetObjects[0].SetCellValue(lastRow, "sep2","|");
		sheetObjects[0].SetCellValue(lastRow, "sep3","|");
		sheetObjects[0].SetCellValue(lastRow + 1, "cntr_mf_seq",sheetObjects[1].GetCellValue(pos + 1, "cntr_mf_seq"));
		sheetObjects[0].SetCellValue(lastRow + 1, "hamo_trf_cd",sheetObjects[1].GetCellValue(pos + 1, "hamo_trf_cd"));
		sheetObjects[0].SetCellValue(lastRow + 1, "ncm_no",sheetObjects[1].GetCellValue(pos + 1, "ncm_no"));
		sheetObjects[0].SetCellValue(lastRow + 1, "po_no",sheetObjects[1].GetCellValue(pos + 1, "po_no"));
		sheetObjects[0].SetCellValue(lastRow, "sep1","|");
		sheetObjects[0].SetCellValue(lastRow, "sep2","|");
		sheetObjects[0].SetCellValue(lastRow, "sep3","|");
		sheetObjects[0].SetCellValue(lastRow + 2, "cntr_mf_gds_desc",sheetObjects[1].GetCellValue(pos + 2, "cntr_mf_gds_desc"));
		sheetObjects[0].SetCellValue(lastRow + 3, "cntr_mf_dtl_desc",sheetObjects[1].GetCellValue(pos + 3, "cntr_mf_dtl_desc"));
		sheetObjects[0].SetCellValue(lastRow + 4, "cntr_mf_mk_desc",sheetObjects[1].GetCellValue(pos + 4, "cntr_mf_mk_desc"));
		//sheetObjects[0].RenderSheet(1);
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var srcName=sheetObj.ColSaveName(Col);
		if( Row % 5==2 ){
			if ( Col != 10 && Col != 11 ) {
				sheetObj.SetCellValue(Row, 2,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 3,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 4,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 5,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 6,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 7,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 8,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 9,Value.toUpperCase(),0);
			} else {
				sheetObj.SetCellValue(Row,10,Value.toUpperCase(),0);//po
				sheetObj.SetCellValue(Row,11,Value.toUpperCase(),0);//po
			}
		} else if(Row % 5==3){
			if ( Col != 10 && Col != 11 ) {
				sheetObj.SetCellValue(Row, 2,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 3,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 4,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 5,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 6,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 7,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 8,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 9,Value.toUpperCase(),0);
			} else {
				sheetObj.SetCellValue(Row,10,Value.toUpperCase(),0);//DG Seq
				sheetObj.SetCellValue(Row,11,Value.toUpperCase(),0);//DG Seq
			}
		} else if(Row % 5==1){
			if(Col==4) sheetObj.SetCellValue(Row, 5,Value.toUpperCase(),0);//hts
			if(Col==5) sheetObj.SetCellValue(Row, 4,Value.toUpperCase(),0);//hts
			if(Col==7) sheetObj.SetCellValue(Row, 8,Value.toUpperCase(),0);//hs
			if(Col==8) sheetObj.SetCellValue(Row, 7,Value.toUpperCase(),0);//hs
			if(Col==10)sheetObj.SetCellValue(Row,11,Value.toUpperCase(),0);//ncm
			if(Col==11)sheetObj.SetCellValue(Row,10,Value.toUpperCase(),0);//ncm
		} else if(Row % 5==4) {
			if(Col==10 || Col == 11 ) {
			//	 Manifest File No  upper Eng - 2010.05.10 - Manifest File No 
				sheetObj.SetCellValue(Row, 10,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 11,Value.toUpperCase(),0);
			} else {
			//   cntr_mf_mk_desc, upper Eng
				sheetObj.SetCellValue(Row, 2,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 3,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 4,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 5,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 6,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 7,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 8,Value.toUpperCase(),0);
				sheetObj.SetCellValue(Row, 9,Value.toUpperCase(),0);
			}
		} else if(Row % 5==0) {
			if ( sheetObj.ColSaveName(Col) == "cntr_no" ) {
				if ( sheetObj.GetCellValue(Row, "cntr_no_old") != Value ){
					sheetObj.SetCellValue(Row+3,10,'',0);//dcgo_seq
					sheetObj.SetCellValue(Row+3,11,'',0);//dcgo_seq
					sheetObj.SetCellValue(Row, "cntr_no_old",Value,0);
				}
			}
		}
		isCopy="false";
	}
	/**
	 * popup click on IBSheet Object
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var formObject=document.form;
		var param="";
		if (sheetObj.ColSaveName(Col) == "pck_tp_cd"||sheetObj.ColSaveName(Col) == "pck_qty") {
			comBkgCallPop0607("setCallBack0607", "T", sheetObjects[0].GetCellValue(Row,"hamo_trf_cd"));
			selRow=Row;
			selCol=Col;
		} else if (sheetObj.ColSaveName(Col) == "meas_ut_cd"||sheetObj.ColSaveName(Col) == "meas_qty") {
			var sUrl="/opuscntr/ESM_BKG_0745_P.do?ncm_no="+sheetObjects[0].GetCellValue(Row, "ncm_no");
			ComOpenWindowCenter(sUrl, "ESM_BKG_0745", 1024, 550, true);
			selRow=Row;
			selCol=Col;
		} else if (sheetObj.ColSaveName(Col) == "wgt_ut_cd"||sheetObj.ColSaveName(Col) == "cntr_mf_wgt") {
			comBkgCallPop0607("setCallBack0607", "H", sheetObjects[0].GetCellValue(Row,"cmdt_hs_cd"));
			selRow=Row;
			selCol=Col;
		}
	}
	/**
	  * Call from ESM_BKG_0745 NCM Code double click
	  */ 
	function sheet1_SetValues(rtnVal) {
		if (rtnVal != null) {
		 	sheetObjects[0].SetCellValue(selRow, selCol - 1,rtnVal.cd,0);
		 	sheetObjects[0].SetCellValue(selRow, selCol,rtnVal.cd,0);
		}
	}

	function sheet1_OnSort(Col, SortArrow) { 
		setCellMerge();
	}
	 /**
	  * showing  CM on the botton grid
	  */ 
	 function sheet1_OnClick(sheetObj, Row, Col){
		var srcName=sheetObj.ColSaveName(Col);
		var dcgoList='';
		var dcgovalue='';
		dcgoList=dcgoList + " |";
		dcgovalue=dcgovalue + " |";
		if(Row%5==3 && ( Col == 10 || Col == 11 )){
			var cntr_no=sheetObj.GetCellValue(eval(parseInt(Row/5)*5), 'cntr_no');
			if (parent.frames["t8frame"].document.form) {
				var cntrSheet=parent.frames["t8frame"].sheetObjects[0];
				for (var i=cntrSheet.HeaderRows();i<=cntrSheet.LastRow();i++){
					if( cntr_no == cntrSheet.GetCellValue(i, "cntr_no") ){
						dcgoList=dcgoList + "Seq : "+cntrSheet.GetCellValue(i, "dcgo_seq")+ ", Un No : "+cntrSheet.GetCellValue(i, "imdg_un_no")+ ", Class : "+cntrSheet.GetCellValue(i, "imdg_clss_cd")+"|"; dcgovalue=dcgovalue + cntrSheet.GetCellValue(i, "dcgo_seq") + "|";
					}
				}
			}
			sheetObj.SetColProperty("dcgo_seq", {ComboText:dcgoList, ComboCode:dcgovalue} );
			sheetObj.SetColProperty("dcgo_seq1", {ComboText:dcgoList, ComboCode:dcgovalue} );
		}
	}

	/**
	 * 
	 * @param sheetObj
	 */
	function shipmentSearchEnd(sheetObj) {
		var rowCount = sheetObj.RowCount();
		var headerRows = sheetObj.HeaderRows();
//		sheetObjects[3].RemoveAll();
		for (var i = headerRows; i < rowCount + headerRows; i++) {
			var cntrJson = sheetObj.GetRowJson(i);
			if(cntrJson.cntr_no != 'No Data') continue;
			
			var rowCount1 = sheetObjects[3].RowCount();
			var headerRows1 = sheetObjects[3].HeaderRows();
			var copyFlg = true;
			for (var j = headerRows1; j < rowCount1 + headerRows1; j++) {
				var shipmentJson = sheetObjects[3].GetRowJson(j);
				if(cntrJson.cntr_seq == shipmentJson.cntr_seq && cntrJson.cntr_mf_seq == shipmentJson.cntr_mf_seq){
					setMultiShipmentSheetData(j, cntrJson);
					copyFlg = false;
					break;
				}
			}
			/* 데이타 복사 */
			if(copyFlg){
				var newRow = sheetObjects[3].DataInsert();
				setMultiShipmentSheetData(newRow, cntrJson);
			}
		}
	}

	 
	function setCallBack0607(aryPopupData) {
		var sheetObject=sheetObjects[0];
		sheetObject.SetCellValue(selRow, selCol,aryPopupData[0][3]);
	}
	
	function setCellMerge() {
		var i = 5;
		while (sheetObjects[0].GetCellValue(i,1) != -1) {
			if(i % 5 == 0){ //1 row
				// Seq
				sheetObjects[0].SetMergeCell(i,1,5,1);
			} else if(i % 5== 1){ //2 row
				// HTS Code
				sheetObjects[0].SetMergeCell(i,4,1,2);
				// HS Code
				sheetObjects[0].SetMergeCell(i,7,1,2);
				// NCM Code
				sheetObjects[0].SetMergeCell(i,10,1,2);
			} else {
				// Description Total, Description Detail, Mark & Nos
				sheetObjects[0].SetMergeCell(i,2,1,7);
				// PO No, DG Seq, Manifest File No
				sheetObjects[0].SetMergeCell(i,10,1,2);
			} 
		    i++;
		}
	}

	function getMultiLineSheetRowIndex(sheetObj) { 
		var i = 5;
		while (sheetObj.GetCellValue(i,1) != -1) {
		    i++;
		}
		return i-5;
	}
	
	function callbackMultiShp(sheetObj){
		sheetObjects[3].RemoveAll();
		
		var rowCount = sheetObj.RowCount();
		var headerRows = sheetObj.HeaderRows();
		
		for (var i = headerRows; i < rowCount + headerRows; i++) {
			var jsonData = sheetObj.GetRowJson(i);
			var newRow = sheetObjects[3].DataInsert();
			setMultiShipmentSheetData(newRow, jsonData);
		}
	}
	
	/**
	 * 
	 * @param newRow
	 * @param jsonData
	 */
	function setMultiShipmentSheetData(newRow, jsonData){
		sheetObjects[3].SetCellValue(newRow, 'cmdt_desc', jsonData.cmdt_desc);
		sheetObjects[3].SetCellValue(newRow, 'cntr_seq', jsonData.cntr_seq);
		sheetObjects[3].SetCellValue(newRow, 'cntr_mf_seq', jsonData.cntr_mf_seq);
		sheetObjects[3].SetCellValue(newRow, 'cntr_mf_wgt', jsonData.cntr_mf_wgt);
		sheetObjects[3].SetCellValue(newRow, 'cntr_tpsz_cd', jsonData.cntr_tpsz_cd);
		sheetObjects[3].SetCellValue(newRow, 'cntr_vol_qty', jsonData.cntr_vol_qty);
		sheetObjects[3].SetCellValue(newRow, 'meas_qty', jsonData.meas_qty);
		sheetObjects[3].SetCellValue(newRow, 'meas_ut_cd', jsonData.meas_ut_cd);
		sheetObjects[3].SetCellValue(newRow, 'mk_desc', jsonData.mk_desc);
		sheetObjects[3].SetCellValue(newRow, 'pck_qty', jsonData.pck_qty);
		sheetObjects[3].SetCellValue(newRow, 'pck_tp_cd', jsonData.pck_tp_cd);
		var prn_flg = 'Y';
		if(jsonData.prn_flg != undefined && jsonData.prn_flg == 0) prn_flg = 'N';
		sheetObjects[3].SetCellValue(newRow, 'prn_flg', prn_flg);
		sheetObjects[3].SetCellValue(newRow, 'wgt_ut_cd', jsonData.wgt_ut_cd);
		
		sheetObjects[3].SetCellValue(newRow, 'cntr_seal_no1', jsonData.cntr_seal_no1);
		sheetObjects[3].SetCellValue(newRow, 'cntr_seal_no2', jsonData.cntr_seal_no2);
		sheetObjects[3].SetCellValue(newRow, 'cmdt_hs_cd', jsonData.cmdt_hs_cd);
		sheetObjects[3].SetCellValue(newRow, 'hamo_trf_cd', jsonData.hamo_trf_cd);
		sheetObjects[3].SetCellValue(newRow, 'ncm_no', jsonData.ncm_no);
		sheetObjects[3].SetCellValue(newRow, 'po_no', jsonData.po_no);
	}
	

	function multiShipmentBthClassCheck(copyCheck){
		if(copyCheck){
			$("#btn_t9multishp").removeClass("btn_etc");
			$("#btn_t9multishp").addClass("btn_normal");
		}else{
			$("#btn_t9multishp").removeClass("btn_normal");
			$("#btn_t9multishp").addClass("btn_etc");
		}
	}