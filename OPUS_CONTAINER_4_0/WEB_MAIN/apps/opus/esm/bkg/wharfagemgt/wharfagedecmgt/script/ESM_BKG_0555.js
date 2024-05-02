/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0555.js
*@FileTitle : Customer Code Entry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
		 var sheetObject=sheetObjects[0];
		 var sheetObject1=sheetObjects[1];
		 /*******************************************************/
		 var formObject=document.form;
		 var StringBuffer=function() {
			 this.buffer=new Array();
		 }
		 StringBuffer.prototype.append=function(str) {
			 this.buffer.push(str);
			 return this;
		 }
		 StringBuffer.prototype.toString=function(){
			 return this.buffer.join("");
		 }
		try {
			var srcName=ComGetEvent("name");
				switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,document.form,IBSEARCH);
								break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
								break;
						case "btn_Print":
							if (sheetObject.RowCount()== 0) {
								ComShowCodeMessage("BKG00095");
								return;
							}
							var subTitle=new StringBuffer();
							var subTitle2=new StringBuffer();
							subTitle.append('WHF / ')
									.append(formObject.vvd.value)
									.append(" / ")
									.append( (formObject.bkg_cust_tp_cd[0].checked ? formObject.pol_cd.value
									: formObject.pod_cd.value) + "     ETA : " )
									.append( sheetObjects[4].GetCellValue(1, 2) + "     ETD : " )
									.append( sheetObjects[4].GetCellValue(1, 1));
							subTitle2.append("     Run Date : " )
									 .append( ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms") );
							var temp=subTitle.toString();
							var temp2=subTitle2.toString();
							ComOpenWindowCenter("/opuscntr/ESM_BKG_0793.do"
									+ "?rt_teu="     + formObject.rt_teu.value
									+ "&rt_feu="     + formObject.rt_feu.value
									+ "&rt_hcb="     + formObject.rt_hcb.value
									+ "&ttl_amt="    + formObject.ttl_amt.value
									+ "&bl_cnt="     + formObject.bl_cnt.value
									+ "&bkg_teu="    + formObject.bkg_teu.value
									+ "&bkg_feu="    + formObject.bkg_feu.value
									+ "&bkg_hcb="     + formObject.bkg_hcb.value
									+ "&sub_title="  + temp
									+ "&sub_title2=" + temp2,
									"0793", 1024, 720, false);
							break;
						case "btn_SumPrint":
							var s=new StringBuffer();
								s.append("/rdata [")
								.append( sheetObjects[2].GetCellValue(2,2) )
								.append("^").append( sheetObjects[2].GetCellValue(2,3) )
								.append("^").append( sheetObjects[2].GetCellValue(2,4) )
								.append("^").append( sheetObjects[2].GetCellValue(2,5) )
								.append("^").append( sheetObjects[2].GetCellValue(2,6) )
								.append("^").append( sheetObjects[2].GetCellValue(2,7) )
								.append("^").append( sheetObjects[2].GetCellValue(2,8) )
								.append("^").append( sheetObjects[2].GetCellValue(2,9) )
								.append("^").append( sheetObjects[2].GetCellValue(2,10))
								.append("^").append( sheetObjects[2].GetCellValue(2,11))
								.append("^").append( sheetObjects[2].GetCellValue(2,12))
								.append("^").append( sheetObjects[2].GetCellValue(2,13))
								.append("^").append( sheetObjects[2].GetCellValue(2,14))
								.append("^").append( sheetObjects[2].GetCellValue(2,15))
								.append("^").append( sheetObjects[2].GetCellValue(2,16))
								.append("^").append( sheetObjects[2].GetCellValue(2,17))
								.append("^").append( sheetObjects[2].GetCellValue(3,2) )
								.append("^").append( sheetObjects[2].GetCellValue(3,3) )
								.append("^").append( sheetObjects[2].GetCellValue(3,4) )
								.append("^").append( sheetObjects[2].GetCellValue(3,5) )
								.append("^").append( sheetObjects[2].GetCellValue(3,6) )
								.append("^").append( sheetObjects[2].GetCellValue(3,7) )
								.append("^").append( sheetObjects[2].GetCellValue(3,8) )
								.append("^").append( sheetObjects[2].GetCellValue(3,9) )
								.append("^").append( sheetObjects[2].GetCellValue(3,10))
								.append("^").append( sheetObjects[2].GetCellValue(3,11))
								.append("^").append( sheetObjects[2].GetCellValue(3,12))
								.append("^").append( sheetObjects[2].GetCellValue(3,13))
								.append("^").append( sheetObjects[2].GetCellValue(3,14))
								.append("^").append( sheetObjects[2].GetCellValue(3,15))
								.append("^").append( sheetObjects[2].GetCellValue(4,2) )
								.append("^").append( sheetObjects[2].GetCellValue(4,3) )
								.append("^").append( sheetObjects[2].GetCellValue(4,4) )
								.append("^").append( sheetObjects[2].GetCellValue(4,5) )
								.append("^").append( sheetObjects[2].GetCellValue(4,6) )
								.append("^").append( sheetObjects[2].GetCellValue(4,7) )
								.append("^").append( sheetObjects[2].GetCellValue(4,8) )
								.append("^").append( sheetObjects[2].GetCellValue(4,9) )
								.append("^").append( sheetObjects[2].GetCellValue(4,10))
								.append("^").append( sheetObjects[2].GetCellValue(4,11))
								.append("^").append( sheetObjects[2].GetCellValue(4,12))
								.append("^").append( sheetObjects[2].GetCellValue(4,13))
								.append("^").append( sheetObjects[2].GetCellValue(4,14))
								.append("^").append( sheetObjects[2].GetCellValue(4,15))
								.append("^").append( formObject.ofc_cd.value )
								.append("^").append( formObject.vvd.value           )
								.append("^").append( formObject.cfm_usr_id.value    )
								.append("^").append( sheetObjects[4].GetCellValue(1, 1))
								.append("^")
								.append("] /rnl [~]");
							var temp="/opuscntr/ESM_BKG_0893.do" + "?rdData=" + s.toString();
							ComOpenWindowCenter(temp, "0893", 1024, 720, false );
							break;
						case "btn_Confirm":
							doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
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
	 * showing data of cell at memo pad
	 *
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return
	 */
	function sheet1_OnClick(sheetObj, row, col){
		 var sSaveName=sheetObj.ColSaveName(col);
		 if (sSaveName == "sheet1_cust_nm" || sSaveName == "sheet1_xpt_ref_no") {
			 if (ComTrim(sheetObj.GetCellValue(row, col)) != "")
				 ComShowMemoPad(sheetObj, null, null, true, sheetObj.GetColWidth(col) , 100);
		 }
	}
	 function sheet1_OnDblClick(sheetObj, row, col) {
		 var sValue="";
		 sValue=ComTrim(sheetObj.GetCellValue(row, "sheet1_bkg_no"));
		if (sValue != "") {
			//ComOpenWindow("opusMain.screen?parentPgmNo=ESM_BKG_M001&pgmUrl=^opuscntr^ESM_BKG_0079.do&pgmNo=ESM_BKG_0079&bkg_no=" + sValue, "", "width=1024,height=768, resizable=yes, scrollbars=yes, status=no");
			comBkgCallPopBkgDetail(sValue);
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
		initControl();
	}
	/**
	 * loading HTML Control event <br>
	 * @param sheetObj
	 * @param sheetNo
	 */
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	}
	/**
	 * process when input retrieve keyword
	 */
	function obj_KeyUp() {
		 var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		 var formObject=document.form;
		var srcName=ComGetEvent("name");
		//var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcMaxLength = ComGetEvent("maxlength");
		//var srcValue=window.event.srcElement.getAttribute("value");
		var srcValue = ComGetEvent("value");
		if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
				var sheetId=sheetObj.id;
		switch(sheetId) {
			case "sheet1":
				with(sheetObj){

			  SetAutoRowHeight(0);
			  var HeadTitle1="|Seq.|B/L No.|Shipper Name|Export Ref.|EQ|Qty|Amount|Container QTY|Container QTY|Container QTY|M/C|Exemption Reason|Exemption Reason";
			  var HeadTitle2="|Seq.|B/L No.|Shipper Name|Export Ref.|EQ|Qty|Amount|20’|40’|45’|M/C|F|Free";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  var prefix='sheet1_';

			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"},
						  { Text:HeadTitle2, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"xpt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rat_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rat_as_qty_sum",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"amount",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"teu_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"feu_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"hcb_qty",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_cvrd_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_rt_whf_expt_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_shpr_rgst_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"f_teu_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"f_feu_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"f_hcb_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

			  InitColumns(cols);

			  SetEditable(1);
			  SetEllipsis(1);
			  SetCountPosition(0);
			  SetWaitImageVisible(0);
			  SetSheetHeight(200);
					}
			break;
			case "sheet2":
				with(sheetObj){

			  var HeadTitle1="|RT_TEU|RT_FEU|RT_HCB|BKG_TEU|BKG_FEU|BKG_HCB|TTL_AMT|BL_CNT";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  var prefix2='sheet2_';

			  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"rt_teu",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"rt_feu",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"rt_hcb",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"bkg_teu", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"bkg_feu", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"bkg_hcb", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"ttl_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix2+"bl_cnt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];

			  InitColumns(cols);

			  SetEditable(1);
			  SetCountPosition(0);
			  SetWaitImageVisible(0);
			  //SetSheetHeight(0);
			  SetVisible(0);
					}
				break;
			case "sheet3":
				with(sheetObj){

			  var HeadTitle1="|구분|부과대상|면제화주|면제화주|면제화주|면제화주|면제화주|T/S|IPO|Military|조달청|MTY|Bulk|Including\nOFT|Exempt\nTotal|Rating\nAmount|신고\n예정 금액";
			  var HeadTitle2="|구분|부과대상|효성|대우|동부제강|현대|동국|T/S|IPO|Military|조달청|MTY|Bulk|Including\nOFT|Exempt\nTotal|Rating\nAmount|신고\n예정 금액";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  var prefix3='sheet3_';

			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"},
						  { Text:HeadTitle2, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"gubun",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"buguadaesang",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"hyosung",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"daewoomot",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"dongbujekang",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"hyundaehi",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"donggukjekang",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"ts",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"ipi",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"military",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"jodalcheong",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"mty",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"bulk",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"incloft",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"exempttotal",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"ratingamount",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix3+"singoyejeonggumaek", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

			  InitColumns(cols);

			  SetWaitImageVisible(0);
			  SetEditable(1);
			  SetCountPosition(0);
			  SetWaitImageVisible(0);
			  SetMergeCell(0, 1, 2, 1);
			  SetMergeCell(0, 2, 2, 1);
			  SetMergeCell(0, 8, 2, 1);
			  SetMergeCell(0, 9, 2, 1);
			  SetMergeCell(0, 10, 2, 1);
			  SetMergeCell(0, 11, 2, 1);
			  SetMergeCell(0, 12, 2, 1);
			  SetMergeCell(0, 13, 2, 1);
			  SetMergeCell(0, 14, 2, 1);
			  SetMergeCell(0, 15, 2, 1);
//              SetSheetHeight(122);
			  resizeSheet();
			  }
			break;
			case "sheet4":
				with(sheetObj){

			  var HeadTitle1="|cfm_usr_id|upd_dt|ofc_cd|";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  var prefix4='sheet4_';

			  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix4+"cfm_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix4+"upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix4+"ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];

			  InitColumns(cols);

			  SetEditable(1);
			  SetCountPosition(0);
			  SetWaitImageVisible(0);
			  //SetSheetHeight(0);
			  SetVisible(0);
					}
			break;
			case "sheet5":
				with(sheetObj){

			  var HeadTitle1="|vps_etd_dt|vps_eta_dt";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  var prefix5='sheet5_';

			  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);

			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix5+"ibflag" },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix5+"vps_etd_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix5+"vps_eta_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:0,   InsertEdit:0 } ];

			  InitColumns(cols);

			  SetEditable(1);
			  SetCountPosition(0);
			  SetWaitImageVisible(0);
			  //SetSheetHeight(0);
			  SetVisible(0);
					}
			break;
		}
	}
  // handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_"); // prefix array of strings
			var sXml=sheetObj.GetSearchData("ESM_BKG_0555GS.do", FormQueryString(formObj) + "&"	+ ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");

			if (arrXml.length > 0){
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[0].SetColFontColor("sheet1_bl_no","#0000FF");
				sheetObjects[0].SetColFontUnderline("sheet1_bl_no",1);
			}
			if (arrXml.length > 1) {
				sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
				formObj.rt_teu.value=ComAddComma(sheetObjects[1].GetCellValue(1, 1));
				formObj.rt_feu.value=ComAddComma(sheetObjects[1].GetCellValue(1, 2));
				formObj.rt_hcb.value=ComAddComma(sheetObjects[1].GetCellValue(1, 3));
				formObj.bkg_teu.value=ComAddComma(sheetObjects[1].GetCellValue(1, 4));
				formObj.bkg_feu.value=ComAddComma(sheetObjects[1].GetCellValue(1, 5));
				formObj.bkg_hcb.value=ComAddComma(sheetObjects[1].GetCellValue(1, 6));
				formObj.ttl_amt.value=ComAddComma(sheetObjects[1].GetCellValue(1, 7));
				formObj.bl_cnt.value=ComAddComma(sheetObjects[1].GetCellValue(1, 8));
			}
			if (arrXml.length > 2) {
				sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			}
			if (arrXml.length > 3) {
				sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
				if (sheetObjects[3].GetCellValue(1, 1) == "-1") {
					formObj.cfm_usr_id.value = "";
				} else {
					formObj.cfm_usr_id.value=sheetObjects[3].GetCellValue(1, 1);
				}

				if (sheetObjects[3].GetCellValue(1, 2) == "-1") {
					formObj.upd_dt.value="";
				} else {
					formObj.upd_dt.value=sheetObjects[3].GetCellValue(1, 2);
				}
			}
			if (arrXml.length > 4) {
				sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
				formObj.retrieve_info.value="WHF / "
						+ formObj.vvd.value
						+ " / "
						+ (formObj.bkg_cust_tp_cd[0].checked ? formObj.pol_cd.value	: formObj.pod_cd.value)
						+ "     ETA : "
						+ ("-1" ? "" : sheetObjects[4].GetCellValue(1, 2))
						+ "     ETD : "
						+ ("-1" ? "" : sheetObjects[4].GetCellValue(1, 1))
						+ "     Run Date : "
						+ ComGetNowInfo("ymd") + " " + ComGetNowInfo("hms");
			}
			ComOpenWait(false);
			if (formObj.cfm_usr_id.value != "") {
				ComBtnDisable("btn_Confirm");
			} else {
				ComBtnEnable("btn_Confirm");
			}
		}
		break;
	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet4_"); // prefix array of strings
			var sParam=FormQueryString(formObj);
			var saveXml=sheetObjects[3].GetSaveData("ESM_BKG_0555GS.do", sParam + "&" + ComGetPrefixParam(aryPrefix));
			sheetObjects[3].RemoveAll();
			sheetObjects[3].LoadSearchData(saveXml,{Sync:1} );
			if (sheetObjects[3].RowCount()> 0) {
				formObj.cfm_usr_id.value=sheetObjects[3].GetCellValue(1, 1);
				formObj.upd_dt.value=sheetObjects[3].GetCellValue(1, 2);
				if (formObj.cfm_usr_id.value != "") {
					ComBtnDisable("btn_Confirm");
				} else {
					ComBtnEnable("btn_Confirm");
				}
			}
		}
		break;
	case IBDOWNEXCEL:
		if (sheetObj.id == "sheet1") {
			if(sheetObjects[0].RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else{
				sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObjects[0]), SheetDesign:1,Merge:1 });
			}
		}
		else if (sheetObj.id == "sheet3") {
//no support[check again]CLT 			sheetObjects[2].ExcelPrint="PreView";
			if(sheetObjects[2].RowCount() < 1){
				ComShowCodeMessage("COM132501");
			}else{
				sheetObjects[2].Down2Excel({ HiddenColumn:-1,Merge:true,URL:"apps/opus/esm/bkg/wharfagemgt/wharfagedecmgt/script/ESM_BKG_0555.xml"});
			}
		}
		break;
	}
}
	/**
	 * handling process for input validation <br>
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return boolean
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.vvd.value == "" )
			{
				ComShowCodeMessage('BKG00887', 'VVD');
				formObj.vvd.focus();
				return false;
			}
			if( formObj.bkg_cust_tp_cd[0].checked ){
				if (formObj.pol_cd.value == "" ){
					ComShowCodeMessage('BKG00887', 'POL');
					return false;
				}
			} else {
				if (formObj.pod_cd.value == "" ){
					ComShowCodeMessage('BKG00887', 'POD');
					return false;
				}
			}
			return true;
		break;
		case IBSAVE:
			for(var i=2; i<=sheetObj.RowCount()+ 1 ; i++){
				if( sheetObj.GetCellValue(i,0) == 'I' ){
					if( formObj.port_cd.value == '' || sheetObj.GetCellValue(i,3) == '' ){
						ComShowCodeMessage('BKG00104');
						return false;
					}
				}
			}
			return true;
		break;
		case IBDELETE:
			if (formObj.port_cd.value == "" )
			{
				ComShowCodeMessage('BKG00266');
				formObj.port_cd.focus();
				return false;
			}
			return true;
		break;
		}
	}
	/**
	 * Thousands of additional comma in Decimal point to be embedded <br>
	 * @param num
	 * @param pointCnt
	 * @return Thousands of additional comma
	 */
	function CommaInputWithPoint2( num, pointCnt )
	{
		var pointNum='';
		num=num.replace(",","");
		var pointLoc=num.indexOf(".")
		if( pointLoc != -1 ){
			pointNum=num.substring(pointLoc, pointLoc + ( pointCnt + 1));
			num=num.substring(0, pointLoc);
		}
		rl=num.length;
		l=num.length-3;
		while(l > 0) {
			if(num.substring(rl-1,1) == "."){
				return num;
			}else {
				num=num.substr(0,l)+","+num.substr(l);
				l-=3;
			}
		}
		return num + pointNum ;
	}

	function resizeSheet(){
		ComResizeSheet(sheetObjects[2]);
	}
