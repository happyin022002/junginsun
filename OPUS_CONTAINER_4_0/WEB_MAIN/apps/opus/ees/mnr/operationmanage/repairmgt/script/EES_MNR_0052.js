/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0052.js
*@FileTitle  : Simple Expense W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
							MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
							OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0052 : business script for ees_mnr_0052.
	 */
	function EES_MNR_0052() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer job	*/
	//common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var nowLoad=0;
	// file upload
	var uploadObjects=new Array();
	var uploadCnt=0;
	//calling Calculate 
	var calReq=0;
	//deleting calculate
	var calDel="";
	var OrgVndrSeq="";
	var OrgCostCd="";
	//synchronization variable sheet Combo when retrieving
	var arrDataSearchDbXml;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	var sXml_1 = "";
	var sXml_2 = "";
	var unitCost = "";
	var cal_flag = "N";
	
	var oldWoNo = "";
	//Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do", 720, 380, 'setPopUpParam_EES_MNR_0211', '0,0', true);
				break;
			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
				break;
			case "btn_delete":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
					calReq=0;
				}
				break;
			case "btn_downExcel":
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
				}
				
				break;
			case "btn_loadExcel":
				if(combo_vndr_seq.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");
					ComSetFocus(combo_vndr_seq);
					return false;
				}
				if(combo_cost_cd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00205");
					ComSetFocus(combo_cost_cd);
					return false;
				}
				ComOpenPopup("/opuscntr/EES_MNR_0219.do", 698, 535, 'setPopUpParam_EES_MNR_0219', '1,0', true);
				break;
			case "btn_retrive":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_new":
				var sRow=sheetObject.FindStatusRow("I|U|D");  // checking sheet status
				if(sRow != "") // in case of existing edits
				{
					if(!ComShowCodeConfirm("MNR00232"))
					{
						return false;
					}
				}
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_W/O_Creation":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_W/O_Send":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCHAPPEND);
				break;
			case "btn_calc":
				cal_flag = "Y";
				calculateAgmtRateSubSum(sheetObjects[0], formObject,"Y");
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
	* registering IBSheet Object as list
	* adding process for list in case of needing batch processing with other items
	* defining list on the top of source
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* getEES_MNR_139 receiving function values ​​from Pop-up
	* @param Array[][]     aryPopupData		[0]EQNO   [1]YARD  [2]FLAGDATE
	* @param Array[]       arrRetVal 	        [0]EQ_TYPE    [1]FLAG or UNFLAG
	*/
	function setPopUpParam_EES_MNR_0219(rArray,ret_val){
		var formObj=document.form;
		var firstSelect=0;
		comboValue=ret_val[0];
	if(sheetObjects[0].GetCellValue(2, "Seq")=="0" )
		{
			sheetObjects[0].RemoveAll();
		}
		for(var i=0;i <  rArray.length;i++){
			var Row=sheetObjects[0].DataInsert(-1);
			if(i == 0)
				firstSelect=Row;
				sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd",comboValue,0);
				sheetObjects[0].SetCellValue(Row,"sheet1_eq_no",rArray[i][0],0);
				sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd2",rArray[i][1],0);
				sheetObjects[0].SetCellValue(Row,"sheet1_rpr_rslt_dt2",rArray[i][2],0);
				sheetObjects[0].SetCellValue(Row,"sheet1_eq_tpsz_cd",rArray[i][3],0);
				sheetObjects[0].SetCellValue(Row,"sheet1_cost_cd",combo_cost_cd.GetSelectCode(),0);
			if(	formObj.rpr_offh_flg.checked==true)
				sheetObjects[0].SetCellValue(Row, "sheet1_rpr_offh_flg","Y");
			else
				sheetObjects[0].SetCellValue(Row, "sheet1_rpr_offh_flg","N");
		}
		// retrieving after loading excel
		if(firstSelect != 0) {
			// retrieving detail
			calculateAgmtRateSubSum(sheetObjects[0], formObj,"Y");
		}
	}
	function setPopUpParam_EES_MNR_0211(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(',');
		formObj.mnr_ord_seq.value=arr[4];
		if(formObj.mnr_ord_seq.value.length > 3){
			doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
		}
	}
	/**
	* initializing sheet
	* implementing onLoad event handler in body tag
	* adding first-served functions after loading screen.
	*/
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
		initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Send");
	}
	function initControl() {
		//Axon handling event1. event catch
		var formObject=document.form;
		//axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
		//axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             
		//axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
		axon_event.addListenerForm('focusout',	 'obj_change',	formObject); 
		axon_event.addListener('change',	 'obj_change1',	'ord_hdr_rmk'); 
		axon_event.addListener('change',	 'obj_change2',	'rpr_offh_flg'); 
	}
	//Axon handling event2. handling event
	function obj_deactivate(){
		ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
		ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
			case "mnr_ord_seq":
				if(formObj.mnr_ord_seq.value != oldWoNo){
					var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
					var strMnrOrdSeqTail=strMnrOrdSeqAll.substring(3);
					if(!ComIsNumber(strMnrOrdSeqTail))
					{
						formObj.mnr_ord_seq.value=strMnrOrdSeqAll.substring(0,3);
					}
					doActionIBSheet(sheetObj, formObj , IBSEARCH);
				}
				break;
			}
		}
	}
	
	function obj_change1(){
		var formObj=document.form;
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
	var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				formObj.ord_hdr_rmk.value=formObj.ord_hdr_rmk_org.value;
				return false;
			}
		}
		ComBtnDisable("btn_W/O_Send");
		ComBtnEnable("btn_W/O_Creation");
	}
	function obj_change2(){
		var formObj=document.form;
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
	var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
	if(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "sheet1_rpr_offh_flg")=="Y")
					formObj.rpr_offh_flg.checked=true;
				else
					formObj.rpr_offh_flg.checked=false;
				return false;
			}
		}
		if(sheetObjects[0].RowCount()>0){
			if(	formObj.rpr_offh_flg.checked==true)
				sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "sheet1_rpr_offh_flg","Y");
			else
				sheetObjects[0].SetCellValue(sheetObjects[0].HeaderRows(), "sheet1_rpr_offh_flg","N");
			ComBtnDisable("btn_W/O_Send");
			ComBtnEnable("btn_W/O_Creation");
			sheetObjects[0].SetRowStatus(sheetObjects[0].HeaderRows(),"R");
		}
	}
	//function obj_keypress(){
	//	obj=event.srcElement;
	//	keys=event.keyCode;
	//	if(obj.dataformat == null) return;
	//	window.defaultStatus=obj.dataformat;
	//	var formObj=document.form;
	//	if ( ComTrim(obj.value) != "" ) {
	//		switch(ComGetEvent("name")) {
	//		case "mnr_ord_seq":
	//			var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
	//			var strMnrOrdSeqTail="";
	//			if(strMnrOrdSeqAll=="NEW")
	//			{
	//				formObj.mnr_ord_seq.value="";
	//				ComBtnDisable("btn_W/O_Send");
	//				ComBtnEnable("btn_W/O_Creation");
	//			}
	//			if(strMnrOrdSeqAll.length > 3)
	//			{
	//				if(keys==13)
	//				{
	//					ComBtnDisable("btn_W/O_Send");
	//					ComBtnEnable("btn_W/O_Creation");
	//					ComSetFocus(formObj.combo_vndr_seq);
	//				}
	//			}
	//			break;
	//		}
	//	}
	//	switch(obj.dataformat) {
	//	case "ymd":
	//	case "int":
	//		ComKeyOnlyNumber(obj);
	//		break;
	//	case "float":
	//		ComKeyOnlyNumber(obj, "-.");
	//		break;
	//	case "eng":
	//		ComKeyOnlyAlphabet();
	//		break;
	//	case "engup":
	//		ComKeyOnlyAlphabet('uppernum');
	//		break;
	//	}
	//}
	/**
	* setting sheet initial values and header
	* param : sheetObj, sheetNo
	* adding case as numbers of counting sheets
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		    with(sheetObj){
					      var HeadTitle="|Sel|Seq.|Service Sub Type|EQ No.|TP/SZ|Yard|Work Date|Recent Record Information|Recent Record Information|Recent Record Information|Booking No|Trade Code";
					      var HeadTitle1="|Sel|Seq.|Service Sub Type|EQ No.|TP/SZ|Yard|Work Date|Recent Date|Recent Yard|Recent S/P|Booking No|Trade Code";
					      var headCount=ComCountHeadTitle(HeadTitle) + 9;
					      (headCount, 0, 0, true);
					      var prefix="sheet1_";
					      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					      var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
					      InitHeaders(headers, info);
					      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_dtl_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
					             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd2",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
					             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt2",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"sp_name",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_rt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_vrfy_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rpr_offh_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_inv_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_inp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
					       
					      InitColumns(cols);
					      SetEditable(1);
					      SetSheetHeight(160);
					      SetShowButtonImage(2);
					      SetColProperty(0 ,prefix+"yd_cd2" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			}
		    break;
		case 2:      //t1sheet1 init
		    with(sheetObj){
				      var HeadTitle="|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information|Summary Information";
				      var HeadTitle1="|Seq.|S/Type|TP/SZ|Yard Code|Q'ty|Unit Cost|Total|System Veify Result";
				      var prefix="sheet2_";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [   {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
						             {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_dtl_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:prefix+"rpr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Float",     Hidden:0,  Width:114,  Align:"Right",   ColMerge:0,   SaveName:prefix+"agmt_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 },
						             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"total",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:16 },
						             {Type:"Text",      Hidden:0,  Width:117,  Align:"Left",    ColMerge:0,   SaveName:prefix+"result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"ord_index",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_vrfy_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Float",     Hidden:1,  Width:114,  Align:"Right",   ColMerge:0,   SaveName:prefix+"old_agmt_rt_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:16 }];
				       
				      InitColumns(cols);
				      SetEditable(1);
				      SetSheetHeight(167);
	            }
			break;
		case 3:      // sheet1 init
		    with(sheetObj){
				      var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
				      + "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
				      + "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
				      + "|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      (headCount, 0, 0, true);
				      var prefix="sheet3_";
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [   {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trsm_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ver_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_agmt_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wrk_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_snd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_brth_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_hdr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_inp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetEditable(0);
				      SetVisible(false);
				      SetSelectionMode(smSelectionRow);
	      }
			break;
		case 4:
			with (sheetObj) {
			}
			break;
		}
	}
	/**
	* initializing multi Combo
	* @return
	*/
	function initCombo() {
		var formObject=document.form
		with (combo_vndr_seq) {
			SetMultiSeparator("|");
			SetTitle("S/P Name|S/P Code|AGMT No|Office Code|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColAlign(2, "center");
			SetColAlign(3, "center");
			SetColAlign(4, "left");
			SetColAlign(5, "center");
			SetColAlign(6, "left");
			SetColAlign(7, "left");
			SetColAlign(8, "left");
			SetColWidth(0, "180");
			SetColWidth(1, "70");
			SetColWidth(2, "75");
			SetColWidth(3, "85");
			SetColWidth(4, "70");
			SetColWidth(5, "148");
			SetColWidth(6, "110");
			SetColWidth(7, "135");
			SetColWidth(8, "0");
			SetDropHeight(160);
			SetTitleVisible(true);
		}
		with (combo_cost_cd) {
			SetMultiSeparator("|");
			SetTitle("Code|Name");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
			SetColAlign(1, "left");
			SetColWidth(1, "170");
			SetTitleVisible(true);
			SetDropHeight(160);
		}
		with (combo_eq_knd_cd) {
			SetMultiSeparator("|");
			SetTitle("Code|Name");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColWidth(0, "90");
			SetColWidth(1, "180");
			SetDropHeight(160);
			SetEnable(0);
		}
	}
	function combo_vndr_seq_Initialize(){
		var formObj=document.form;
		var sXml=MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult=MnrXmlToArray(sXml);
		if(arrResult != null){
			for(var i=0; i < arrResult.length;i ++){
				var tempComboText=arrResult[i][8]       //8 vndr_nm|
				                 + "|" + arrResult[i][1]  //1 vndr_seq|
				                 + "|" + arrResult[i][9]  //9 agmt_no|
				     			 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   //3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
				                 + "|" + arrResult[i][2] //2 agmt_ref_no|
				                 + "|" + arrResult[i][25]   //25 trf_no|
				                 + "|" + arrResult[i][14] //14 curr_cd|
				                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
	                             + "^" + arrResult[i][28]   //28eq_knd_cd|
				                  ;
				combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]);
			}
		} else {
			ComShowCodeMessage("MNR00056");
		}
	}
	function combo_vndr_seq_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		var formObj=document.form;
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
			var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				combo_vndr_seq.SetSelectCode(OrgVndrSeq,false);
				return false;
			}
		}
		var strEtc=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  8 );
		var spltEtc=strEtc.split("^");
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
		formObj.curr_cd.value=spltEtc[0];
		var strAgmtNo=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  2 );
		if(strAgmtNo.length > 3)
		{
			formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3);
			formObj.agmt_seq.value=strAgmtNo.substring(3);
		}
		var strAgmtVerNo=spltEtc[1];
		if ( ComIsNumber(strAgmtVerNo))
		{
			formObj.agmt_ver_no.value=strAgmtVerNo;
		}
		var arr=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  5 ).split("~");
		var tmpEffFrom="";
		var tmpEffTo="";
		if(arr==""){
			tmpEffFrom="";
			tmpEffTo="";
		}else{
			tmpEffFrom=arr[0];
			tmpEffTo=arr[1];
		}
		formObj.eff_dt.value=tmpEffFrom.trim();
		formObj.exp_dt.value=tmpEffTo.trim();
		combo_eq_knd_cd.SetSelectCode(spltEtc[2],false);
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheet1_cost_dtl_cd_Initialize(Text);
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			} else {
				combo_cost_cd.SetSelectCode(OrgCostType,false);
			}
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	function combo_eq_knd_cd_Initialize(){
		var formObj=document.form;
		combo_eq_knd_cd.SetSelectCode("-1",false);
		combo_eq_knd_cd.RemoveAll();
		//retrieving Combo
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00002", "COMMON") //EQ Type
		);
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j=0; j < comboList[i].length;j++)
				{
					var tempText=comboList[i][j].split("|");
					if(i==0)
					{
						combo_eq_knd_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
					}
				}
				if(i ==0)
				{
					combo_eq_knd_cd.SetSelectCode(" ");
				}
			}
		}
	}
	function combo_cost_cd_Initialize(eqtype){
		var formObj=document.form;
		combo_cost_cd.SetSelectCode(-1,false);
		combo_cost_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd",eqtype, "CUSTOM7") //Cost Type
		);
		var f_query = 'f_cmd' + '=' + SEARCH + '&';
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + "MnrGenCd" + '&';
		f_query += 'searchkey' + '=' + eqtype + '&';
		f_query += 'searchcon' + '=' + "CUSTOM7" + '&';
		// 마지막에 &를 없애기 위함
		f_query=MnrDelLastDelim(f_query);
	    var sXml=sheetObj.GetSearchData("MNR_COMGS.do", f_query);
	    var comboList=MnrXmlToArray(sXml);
	    
//		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
//				for(var j=0; j < comboList[i].length;j++)
//				{
//					var tempText=comboList[i][j].split("|");
//					if(i==0)
//					{
//						var tempTxt = tempText[2]+"-"+tempText[0];
//						combo_cost_cd.InsertItem(j, tempText[2]+"|"+tempText[0]+"|"+ tempTxt + "|" + tempText[4],tempText[2]);
//					}
//				}
				var tempTxt = comboList[i][2]+"-"+comboList[i][0];
				combo_cost_cd.InsertItem(i, comboList[i][2]+"|"+comboList[i][0]+"|"+ tempTxt + "|" + comboList[i][4],comboList[i][2]);
			}
		}
		if(sheetObjects[0].RowCount()> 1)
			combo_cost_cd.SetSelectCode(OrgCostType,false);
	}
	
	function combo_cost_cd_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		var value = combo_cost_cd
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
			var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				combo_cost_cd.SetSelectCode(OrgCostCd,false);
				return false;
			}
		}
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			for(var i=0; i < sheetObjects[0].DataRows; i ++ ){
			var tmpEx=sheetObjects[0].GetCellValue(i, "sheet1_cost_dtl_cd");
				if(tmpEx != NewCode){
					if(ComShowCodeConfirm("MNR00080")){
						sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
					}else{
						combo_cost_cd.SetSelectCode(OrgCostType,false);
						break;
					}
				}
			}
			
		}else{
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
		}
		
//		if(combo_cost_cd.GetSelectCode() == "MRDRPT"){
//			sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
//			sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
//		}
		if(combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
			sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
			sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
		}
		else{
			sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
			sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
		}
		OrgCostType=combo_cost_cd.GetSelectCode();
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) != "sheet1_rpr_rslt_dt2") return;
		var intPayInvSeq=sheetObj.GetCellValue(Row,"sheet1_pay_inv_seq");
		if(intPayInvSeq =="") intPayInvSeq=0;
		if(parseInt(intPayInvSeq) > 0 )
		{
			ComShowCodeMessage("MNR00229");
			return false;
		} else {
			var cal=new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		}
	}
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad == 0){
			var intPayInvSeq=sheetObj.GetCellValue(Row,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 && sheetObj.CellSearchValue(Row, Col) != Value  )
			{
				ComShowCodeMessage("MNR00229");
				sheetObj.SetCellValue(Row,Col, sheetObj.CellSearchValue(Row, Col), 0);
				return false;
			}
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");
			if(sheetObj.ColSaveName(Col) == "sheet1_cost_dtl_cd"){
				sheetObj.SetCellValue(Row,"sheet1_mnr_rt_tp_cd",Value,0);
				sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value);
			}else if(sheetObj.ColSaveName(Col) == "sheet1_eq_no"){
				var formObj=document.form;
				var checkEqn=sheetObjects[0].GetCellValue(Row,"sheet1_eq_no");
				sheetObjects[0].SetCellValue(Row,"sheet1_eq_no",checkEqn.toUpperCase(),0);
				checkEqn=checkEqn.toUpperCase();
				var retArray=MnrGeneralCodeCheck(sheetObj,"ESTEQN",checkEqn+","+combo_eq_knd_cd.GetSelectCode());
				if(retArray == null){
					ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
					sheetObjects[0].SetCellValue(Row,"sheet1_eq_no","",0);
					sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
					return;
				} else {
					// showing EQ_NUMBER Equipment Information
					setEqInfo(sheetObjects[3],Row,combo_eq_knd_cd.GetSelectCode(),checkEqn,ComGetNowInfo("ymd"));
					if(sheetObj.GetCellValue(Row,"sheet1_eq_no") != "" && sheetObj.GetCellValue(Row,"sheet1_rpr_rslt_dt2") != "" &&combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
						var code = MnrGetBkgTrdCd(sheetObj, checkEqn, sheetObj.GetCellValue(Row, "sheet1_rpr_rslt_dt2"), combo_cost_cd.GetSelectCode(), combo_eq_knd_cd.GetSelectCode(), sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd"));
						if(code != ""){
							var arrCode = code.split("|");
							sheetObj.SetCellValue(Row, "sheet1_bkg_no", arrCode[0], 0);
							sheetObj.SetCellValue(Row, "sheet1_trd_cd", arrCode[1], 0);
						}else{
							sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
							sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
						}
					}else{
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
					}
					return;
				}
			}else if(sheetObj.ColSaveName(Col) == "sheet1_yd_cd2"){
				var strYard=sheetObjects[0].GetCellValue(Row,"sheet1_yd_cd2");
				sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd2",strYard.toUpperCase(),0);
				strYard=strYard.toUpperCase();
				var retArray=MnrGeneralCodeCheck(sheetObj,"YARD",strYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",strYard,"Yard");
					sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd2","",0);
					sheetObjects[0].SelectCell(Row,"sheet1_yd_cd2");
					return;
				}
			}
			else if(sheetObj.ColSaveName(Col) == "sheet1_rpr_rslt_dt2"){
				if(sheetObj.GetCellValue(Row,"sheet1_eq_no") != "" && sheetObj.GetCellValue(Row,"sheet1_rpr_rslt_dt2") != ""&&combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
					var code = MnrGetBkgTrdCd(sheetObj, sheetObj.GetCellValue(Row,"sheet1_eq_no"), sheetObj.GetCellValue(Row, "sheet1_rpr_rslt_dt2"), combo_cost_cd.GetSelectCode(), combo_eq_knd_cd.GetSelectCode(), sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd"));
					if(code != ""){
						var arrCode = code.split("|");
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", arrCode[0], 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", arrCode[1], 0);
					}else{
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
					}
					return;
				}else{
					sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
					sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
				}
			}
		}
	}
	//Extra Expense Type Sheet Combo
	function sheet1_cost_dtl_cd_Initialize(costtype){
		if(nowLoad==0)
		{
			sheetObjects[0].RemoveAll();
		}
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		costDtlCode="";
		costDtlDesc="";
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
				for(var j=0; j < comboList[i].length;j++)
				{
					var tempText=comboList[i][j].split("|");
					if(i==0)
					{
						costDtlCode=costDtlCode + tempText[0] + "|";
						costDtlDesc=costDtlDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					costDtlCode=costDtlCode.substring(0, costDtlCode.length - 1);
					costDtlDesc=costDtlDesc.substring(0, costDtlDesc.length - 1);
					sheetObjects[0].SetColProperty(0,"sheet1_cost_dtl_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
					sheetObjects[1].SetColProperty(0,"sheet2_cost_dtl_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
				}
			}
		}
	}
	function sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value){
		sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty",1,0);
		sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt","",0);
		sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt","",0);
		sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt","",0);
		calReq=0;
		return false;
		var formObj=document.form;
		nowLoad=1;
		formObj.f_cmd.value=SEARCH01;
		var sParam="";
		var aryPrefix=new Array("sheet1_");
		sParam += ComGetPrefixParam(aryPrefix)
		+ "&f_cmd=101"
		+ "&ibflag=X"
		+ "&del_chk=0"
	+ "&cost_dtl_cd="+ sheetObj.GetCellValue(Row, Col)
		+ "&agmt_ofc_cty_cd="+ (combo_vndr_seq.GetText(combo_vndr_seq.GetSelectIndex(), 2 )).substring(0, 3)
		+ "&cost_cd="+ combo_cost_cd.GetSelectCode()
	+ "&mnr_rt_tp_cd="+ sheetObj.GetCellValue(Row, Col)
		+ "&agmt_seq=" + combo_vndr_seq.GetText(combo_vndr_seq.GetSelectIndex(), 2 ).substring(3)
		+ "&agmt_ver_no=" + combo_vndr_seq.GetText(combo_vndr_seq.GetSelectIndex(), 9 )
		;
		var sXml=sheetObj.GetSearchData("EES_MNR_0058GS.do", sParam);
		var comboLst=getDataString(sXml, "sheet1_rpr_qty", "sheet1_agmt_rt_amt");
		if (typeof(comboLst)== "undefined" )
		{
			sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt","");
			sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty","1");
			sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt","");
			sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt","");
			nowLoad=0;
			return;
		}
		if (comboLst != null)
		{
			var rprqty=comboLst.substring(0, comboLst.indexOf('|'));
			var amt=comboLst.substring(comboLst.indexOf('|') + 1);
			if((rprqty <= 0)||(amt <= 0)){
				nowLoad=0;
				return;
			}else{
				var bzcAmt=parseInt(amt)/parseInt(rprqty);
				sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt",bzcAmt);
				sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty","1");
				sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt",bzcAmt);
				sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",bzcAmt*1);
			}
		}
		nowLoad=0;
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		if(nowLoad==1)return;
		var formObj=document.form;
		if(sheetObj.ColSaveName(OldCol) == "sheet1_eq_no" )
		{
			var checkEqn=sheetObjects[0].GetCellValue(OldRow,"sheet1_eq_no");
			if(checkEqn == "")
			{
				return;
			}
		}
		if(sheetObj.ColSaveName(OldCol) == "sheet1_yd_cd2" )
		{
			if (NewRow <sheetObjects[0].HeaderRows())
				return;
//			var strYard=sheetObjects[0].GetCellValue(OldRow,"sheet1_yd_cd2");
//			if(strYard == "")
//			{
//				ComShowCodeMessage("MNR00161","Yard");
//				sheetObjects[0].SetCellValue(OldRow,"sheet1_yd_cd2","",0);
//				sheetObjects[0].SelectCell(OldRow,"sheet1_yd_cd2");
//				return;
//			}
		}
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		var f_gubuns=formObj.f_gubuns.value;
		
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "" || errMsg == undefined) {
				if(strMnrOrdSeq=="" || strMnrOrdSeq=="NEW" )
				{
					ComShowCodeMessage("MNR00073");
				}else{
					ComShowCodeMessage("MNR00222");
				}
			} else {
				ComShowCodeMessage("MNR00074",errMsg);
			}
			
			if(MnrComGetErrMsg(sXml_1) == null && f_gubuns == ""){
				var mnrOrdSeq=ComGetEtcData(sXml_1, "mnr_ord_seq");
				formObj.mnr_ord_seq.value=mnrOrdSeq;
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			} else {
				formObj.f_gubuns.value="";
			}
		}else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "" || errMsg == undefined) {
				ComShowCodeMessage("MNR00082");
			} else {
				ComShowCodeMessage("MNR00027");
			}
			if(MnrComGetErrMsg(sXml_2) == null){
				var mnrOrdSeq=ComGetEtcData(sXml_2, "mnr_ord_seq");
				doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			}
		}

		nowLoad=0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
		
	}
	function sheet2_OnChange(sheetObj,Row, Col, Value)
	{
		if(nowLoad == 0)
		{
			if(sheetObj.ColSaveName(Col) == "sheet2_agmt_rt_amt")
			{
				var intPayInvSeq=sheetObjects[0].GetCellValue(Row,"sheet1_pay_inv_seq");
				if(intPayInvSeq =="") intPayInvSeq=0;
				if(parseInt(intPayInvSeq) > 0 && sheetObj.GetCellValue(Row, "sheet2_old_agmt_rt_amt") != Value  )
				{
					ComShowCodeMessage("MNR00229");
					sheetObj.SetCellValue(Row, Col, sheetObj.GetCellValue(Row, "sheet2_old_agmt_rt_amt"), 0);
					return false;
				}
				sheet2_agmt_rt_amt_OnChange(sheetObj,Row, Col, Value);
			}
		}
	}
	function sheet2_agmt_rt_amt_OnChange(sheetObj,Row, Col, Value)
	{
	var iRprQty=sheetObj.GetCellValue(Row,"sheet2_rpr_qty");
	var iAgmtRtAmt=sheetObj.GetCellValue(Row,"sheet2_agmt_rt_amt");
		sheetObj.SetCellValue(Row,"sheet2_total",parseFloat(iRprQty) * parseFloat(iAgmtRtAmt));
	var strOrdIndex=sheetObj.GetCellValue(Row, "sheet2_ord_index");
		var splOrdIndex=strOrdIndex.split("|");
		for(var j=0;j<splOrdIndex.length - 1;j++)
		{
			var dtlRow=sheetObjects[0].FindText("Seq",splOrdIndex[j]);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_rpr_qty",1,0);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iAgmtRtAmt,0);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_bzc_amt",sheetObj.GetCellValue(Row,"sheet2_bzc_amt"),0);
			sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iAgmtRtAmt,0);
			if(sheetObjects[0].GetRowStatus(dtlRow)!="D")
			{
				sheetObjects[0].SetRowStatus(dtlRow,"R");
			} else {
				ComShowCodeMessage("MNR00227");
			}
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	function sheet3_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet3_";
		if(sheetObj.RowCount()<=0)
		{
			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComShowCodeMessage("MNR00005", "W/O No.");
			ComSetFocus(formObj.mnr_ord_seq);
			nowLoad=0;
			return false;
		}
	//no support[check again]CLT 	formObj.combo_vndr_seq.UseCode=false;
		var agree_no=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd")
		+ ComLpad(sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
		combo_vndr_seq.SetSelectIndex(combo_vndr_seq.FindItem(agree_no,2, true));
	//no support[check again]CLT 	formObj.combo_vndr_seq.UseCode=true;
		OrgVndrSeq=combo_vndr_seq.GetSelectCode();
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
		combo_eq_knd_cd.SetSelectCode(sheetObjects[2].GetCellValue(1, prefix+ "eq_knd_cd"),false);
		formObj.curr_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ver_no");
		formObj.showDate.value=sheetObjects[2].GetCellValue(1, prefix+ "cre_dt");
		formObj.ord_hdr_rmk.value=sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
		formObj.ord_hdr_rmk_org.value=sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
		var costcd=sheetObjects[2].GetCellValue(1, prefix+ "cost_cd");
		OrgCostCd=costcd;
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
		combo_cost_cd.SetSelectCode(costcd);
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			if(i>0)break;
			sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
			sheetObjects[i].RenderSheet(1);
		}
		var prefix="sheet1_";
		var ArrCostDtlDesc=costDtlDesc.split("|");
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
			if(i==sheetObjects[0].HeaderRows())
			{
				if(sheetObjects[0].GetCellValue(i, "sheet1_rpr_offh_flg")=="Y")
					formObj.rpr_offh_flg.checked=true;
				else
					formObj.rpr_offh_flg.checked=false;
			}
			var idx=sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
			sheetObjects[0].SetCellText(i, prefix+ "cost_dtl_cd" ,ArrCostDtlDesc[idx]);
			sheetObjects[0].SetCellValue(i, "sheet1_sp_name",formObj.pic_eng_nm.value,0);
			var strYard=ComTrimAll(sheetObjects[0].GetCellValue(i, "sheet1_yd_cd")," ");
			var strRprRsltDt=ComTrimAll(sheetObjects[0].GetCellValue(i, "sheet1_rpr_rslt_dt")," ");
			if(strYard!="") sheetObjects[0].SetCellValue(i,"sheet1_yd_cd2",strYard,0);
			if(strRprRsltDt!="")sheetObjects[0].SetCellValue(i,"sheet1_rpr_rslt_dt2",strRprRsltDt,0);
			sheetObjects[0].SetRowStatus(i,"R");
		}
		if(sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(),3)!= "")
		{
			calculateAgmtRateSubSum(sheetObjects[0], formObj,"N");
		} else{
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Creation");
		}
		
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++){
			var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				sheetObjects[0].SetEditable(0);
				sheetObjects[1].SetEditable(0);
				MnrFormSetReadOnly(formObj,true,"ord_hdr_rmk");
				ComBtnDisable("btn_calc");
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_delete");
				ComBtnDisable("btn_RowDel");
				ComBtnDisable("btn_loadExcel");
				ComBtnDisable("btn_save");
				break;
			}else{
				sheetObjects[0].SetEditable(1);
				sheetObjects[1].SetEditable(1);
				MnrFormSetReadOnly(formObj,false,"ord_hdr_rmk");
				ComBtnEnable("btn_calc");
				ComBtnEnable("btn_add");
				ComBtnEnable("btn_delete");
				ComBtnEnable("btn_RowDel");
				ComBtnEnable("btn_loadExcel");
				ComBtnEnable("btn_save");
			}
		}
		oldWoNo = formObj.mnr_ord_seq.value;
		nowLoad=0;
	}
	//handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:
			MnrWaitControl(true);
			formObj.f_gubuns.value="";
			formObj.mnr_ord_seq.value="NEW";
			MnrFormSetReadOnly(formObj,false,"mnr_ord_seq");
			formObj.showDate.value=ComGetNowInfo();
			formObj.cost_ofc_cd.value=currOfcCd;
			formObj.pic_eng_nm.value="";
			formObj.eff_dt.value="";
			formObj.exp_dt.value="";
			formObj.curr_cd.value="";
			formObj.cost_cd.value="";
			combo_vndr_seq.SetSelectCode("-1",false);
			combo_vndr_seq.RemoveAll();
			combo_cost_cd.SetSelectCode("-1",false);
			combo_cost_cd.RemoveAll();
			formObj.ord_hdr_rmk.value="";
			combo_vndr_seq_Initialize ();
			combo_eq_knd_cd_Initialize();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			sheetObjects[0].SetEditable(1);
			sheetObjects[1].SetEditable(1);
			MnrFormSetReadOnly(formObj,false,"ord_hdr_rmk");
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Send");
			sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
			sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
			break;
		case IBINSERT:
			if(!validateForm(sheetObj,formObj,sAction))return;
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "sheet1_cost_dtl_cd","",0);
			sheetObj.SetCellValue(row, "sheet1_yd_cd","",0);
			sheetObj.SetCellValue(row, "sheet1_yd_cd2","",0);
			sheetObj.SetCellValue(row, "sheet1_cost_cd",combo_cost_cd.GetSelectCode(),0);
			sheetObj.SelectCell(row, "sheet1_cost_dtl_cd");
			calReq=0;
			break;
		case IBSEARCH:      //retrieving
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="";
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			var sParam="";
			var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0052GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			payInvSeq = ComGetEtcData(arrDataSearchDbXml[0],"pay_inv_seq");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				if(i==0 || i==1)continue;
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
			}
//			MnrFormSetReadOnly(formObj,true,"mnr_ord_seq");
		break;
		case IBSAVE:        //saving
			if(nowLoad != 0) return;
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			var flgRprOffhFlg="N";
			if(formObj.rpr_offh_flg.checked==true)
			{
				flgRprOffhFlg="Y";
			}
			formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
			formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
			formObj.cost_cd.value=combo_cost_cd.GetSelectCode();
			for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
			{
				var strYard=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_yd_cd2")," ");
				var strRprRsltDt=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_rpr_rslt_dt2")," ");
				if(strYard!="")
				{
					sheetObjects[0].SetCellValue(i,"sheet1_rpr_offh_flg",flgRprOffhFlg,0);
					sheetObjects[0].SetCellValue(i,"sheet1_yd_cd",strYard,0);
					sheetObjects[0].SetCellValue(i,"sheet1_rpr_rslt_dt",strRprRsltDt,0);
				}
			}
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet1_", "sheet2_");
			var sParam=ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
			var sXml=sheetObj.GetSaveData("EES_MNR_0052GS.do", sParam);
			sXml_1 = sXml;
			sheetObjects[0].LoadSaveData(sXml);
			
			break;
		case IBSEARCHAPPEND:        //deleting
		   if(!validateForm(sheetObj,formObj,sAction))return false;
		   if(!ComShowCodeConfirm("MNR00026"))
		   {
			   return false;
		   }
			MnrWaitControl(true);
			formObj.f_cmd.value=REMOVE;
			formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
			formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
			formObj.cost_cd.value=combo_cost_cd.GetSelectCode();
			var aryPrefix=new Array("sheet1_", "sheet2_");
			var sParam=ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
				return false;
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
			var sXml=sheetObj.GetSaveData("EES_MNR_0052GS.do", sParam);
			sXml_2 = sXml;
			sheetObjects[0].LoadSaveData(sXml);
			
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
		case COMMAND01:     //W/O Doc Send
			// ComOpenPopup("EES_MNR_0036.do", 720, 380, 'setDocSendParam', '0,0', true);
			/*    
			          [input]
			          Preview Type, Service Provider Code, Work Order Number[Array]
			 */
			var strMnrOrdSeq=formObj.mnr_ord_seq.value;
			if(strMnrOrdSeq!="" && strMnrOrdSeq!="NEW" )
			{
				ComOpenPopup("EES_MNR_0036.do?wo_no="+strMnrOrdSeq, 900, 600, 'setDocSendParam', '0,1', true);
			}
			break;
		}
	}
	function calculateAgmtRateSubSum(sheetObj, formObj,Gubun)
	{
		MnrWaitControl(true);
		var sAgmtOfcCtyCd=formObj.agmt_ofc_cty_cd.value;
		var sAgmtSeq=formObj.agmt_seq.value;
		var sAgmtVerNo=formObj.agmt_ver_no.value;
		var sCostCd=combo_cost_cd.GetSelectCode();
		var sCostDtlCd="";
		var sEqNo="";
		var chkOk=false;
		sheetObjects[1].RemoveAll();
		sheetObj.ColumnSort("sheet1_cost_dtl_cd|sheet1_eq_no", "ASC");
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
		{
			if(sheetObj.GetRowStatus(i)=="D") continue;
			var checkEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
			if(checkEqNo=="") continue;
			sheetObj.SetCellFont("FontBold", i, "sheet1_eq_no",0);
			if(chkOk==false)
			{
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
				chkOk=true;
				continue;
			}else{
			if(sCostDtlCd ==sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")
			&& sEqNo ==sheetObj.GetCellValue(i, "sheet1_eq_no")
				)
				{
				var sSeq=sheetObj.GetCellValue(i, "Seq");
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq) - 1, "sheet1_eq_no",1);
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_eq_no",1);
					sheetObj.ColumnSort("Seq", "ASC"); // initializing sort
					ComShowCodeMessage("MNR00228");
					sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "sheet1_eq_no",true);
					MnrWaitControl(false);
					if(Gubun=="Y")
						ComBtnDisable("btn_W/O_Send");
					else
						ComBtnDisable("btn_W/O_Creation");
					return false;
				}else
				{
					sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
					sEqNo=sheetObj.GetCellValue(i, "sheet1_eq_no");
				}
			}
		}
		sheetObj.ColumnSort("sheet1_cost_dtl_cd|sheet1_eq_tpsz_cd", "ASC");
		var sCostDtlCd="";
		var sMnrRtTpCd="";
		var sYdCd = "";
		var row=0;
		var chkOk=false;
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
		{
			if(sheetObj.GetRowStatus(i)=="D") continue;
			var checkMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
			if(checkMnrRtTpCd=="") continue;
			if(chkOk==false)
			{
				sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
				sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
				row=sheetObjects[1].DataInsert(-1);
				sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sCostDtlCd,0);
				sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sMnrRtTpCd,0);
				sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sYdCd,0);
				sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
				var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
				sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
				chkOk=true;
				continue;
			}else{
				if(sCostDtlCd !=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"))
				{
					row=sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
					var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
					sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
					sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
					sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
					sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
					continue;
				}
				if(sMnrRtTpCd !=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"))
				{
					row=sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
					var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
					sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
					sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
					sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
					sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
					continue;
				}
				if(sYdCd !=sheetObj.GetCellValue(i, "sheet1_yd_cd2"))
				{
					row=sheetObjects[1].DataInsert(-1);
					sheetObjects[1].SetCellValue(row, "sheet2_cost_dtl_cd",sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_eq_tpsz_cd",sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_yd_cd",sheetObj.GetCellValue(i, "sheet1_yd_cd2"),0);
					sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",1,0);
					var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
					sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
					sCostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
					sMnrRtTpCd=sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd");
					sYdCd = sheetObj.GetCellValue(i, "sheet1_yd_cd2");
					continue;
				}
				if(sCostDtlCd ==sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")
				&& sMnrRtTpCd ==sheetObj.GetCellValue(i, "sheet1_eq_tpsz_cd")
				&& sYdCd ==sheetObj.GetCellValue(i, "sheet1_yd_cd2")
				)
				{
					sheetObjects[1].SetCellValue(row, "sheet2_rpr_qty",parseInt(sheetObjects[1].GetCellValue(row, "sheet2_rpr_qty")) +1,0);
					var strOrdIndex=sheetObjects[1].GetCellValue(row, "sheet2_ord_index") + sheetObj.GetCellValue(i, "Seq")+"|";
					sheetObjects[1].SetCellValue(row, "sheet2_ord_index",strOrdIndex,0);
					continue;
				}
			}
		}
		for(var i=sheetObjects[1].HeaderRows();i<sheetObjects[1].LastRow();i++)
		{
			var sCostDtlCd=sheetObjects[1].GetCellValue(i, "sheet2_cost_dtl_cd");
			var sMnrRtTpCd=sheetObjects[1].GetCellValue(i, "sheet2_eq_tpsz_cd");
			var strOrdIndex=sheetObjects[1].GetCellValue(i, "sheet2_ord_index");
			var sYdCd=sheetObjects[1].GetCellValue(i, "sheet2_yd_cd");
			var splOrdIndex=strOrdIndex.split("|");
			var iAgmtRtAmt=0;
			var iRprQty=1;
			var iUnitCost=0;
			var strMnrVrfyTpCd="";
			var strResult="";
			var sXml=MnrAgmtRateInfoSearch(sheetObj,sAgmtOfcCtyCd,sAgmtSeq,sAgmtVerNo,sCostCd,sCostDtlCd,sMnrRtTpCd,sYdCd);
			var retArr=MnrXmlToArray(sXml);
			//0 agmt_ofc_cty_cd|1 agmt_rt_amt|2 agmt_seq|3 pagerows|4 cost_dtl_cd|5 agmt_ver_no|6 ibflag|7 rpr_qty|8 cre_dt|9 upd_usr_id|10 upd_dt|11 mnr_rt_tp_cd|12 cre_usr_id|13 cost_cd|' COLSEPARATOR='☜☞' TOTAL='1'>
			if(retArr != null){
				iAgmtRtAmt=retArr[0][1]; //agmt_rt_amt
				iRprQty=((retArr[0][7]==0)?1:retArr[0][7]); //rpr_qty
				if(iAgmtRtAmt != 0)
					iUnitCost=iAgmtRtAmt/iRprQty;
				strMnrVrfyTpCd="SS";
				strResult="Success";
			}else{
				strMnrVrfyTpCd="UT";
				strResult="Not found Rate due to TP/SZ Error";
			}
			sheetObjects[1].SetCellValue(i, "sheet2_mnr_vrfy_tp_cd",strMnrVrfyTpCd,0);
			sheetObjects[1].SetCellValue(i, "sheet2_result",strResult,0);
			sheetObjects[1].SetCellValue(i, "sheet2_agmt_rt_amt",iUnitCost,0);
			sheetObjects[1].SetCellValue(i, "sheet2_bzc_amt",iUnitCost,0);
			sheetObjects[1].SetCellValue(i, "sheet2_old_agmt_rt_amt",iUnitCost,0);
			sheetObjects[1].SetCellValue(i, "sheet2_total",parseInt(sheetObjects[1].GetCellValue(i, "sheet2_rpr_qty")) *iUnitCost,0);
			for(var j=0;j<splOrdIndex.length - 1;j++)
			{
				var dtlRow=sheetObjects[0].FindText("Seq",splOrdIndex[j]);
				sheetObjects[0].SetCellValue(dtlRow, "sheet1_mnr_vrfy_tp_cd",strMnrVrfyTpCd,0);
				sheetObjects[0].SetCellValue(dtlRow, "sheet1_rpr_qty",1,0);
				sheetObjects[0].SetCellValue(dtlRow, "sheet1_bzc_amt",iUnitCost,0);
//				sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iUnitCost,0);
//				sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iUnitCost,0);
//				var iSprPrtUcAmt=sheetObjects[0].GetCellValue(dtlRow, "sheet1_spr_prt_uc_amt");
//				if(iSprPrtUcAmt == 0 ||  iSprPrtUcAmt=="")
//				{
//					sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iUnitCost,0);
//					sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iUnitCost,0);
//				}else{
//					sheetObjects[1].SetCellValue(i, "sheet2_agmt_rt_amt",iSprPrtUcAmt,0);
//					sheetObjects[1].SetCellValue(i, "sheet2_old_agmt_rt_amt",iSprPrtUcAmt,0);
//					sheetObjects[1].SetCellValue(i, "sheet2_total",parseInt(sheetObjects[1].GetCellValue(i, "sheet2_rpr_qty")) * iSprPrtUcAmt,0);
//				}
				
				var iSprPrtUcAmt=sheetObjects[0].GetCellValue(dtlRow, "sheet1_spr_prt_uc_amt");
				if(iSprPrtUcAmt == 0 ||  iSprPrtUcAmt=="")
				{
					sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iUnitCost,0);
					sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iUnitCost,0);
				}else{
					if(cal_flag == "Y"){
						sheetObjects[0].SetCellValue(dtlRow, "sheet1_spr_prt_uc_amt",iUnitCost,0);
						sheetObjects[0].SetCellValue(dtlRow, "sheet1_cost_amt",iUnitCost,0);
					}else{
						sheetObjects[1].SetCellValue(i, "sheet2_agmt_rt_amt",iSprPrtUcAmt,0);
						sheetObjects[1].SetCellValue(i, "sheet2_old_agmt_rt_amt",iSprPrtUcAmt,0);
						sheetObjects[1].SetCellValue(i, "sheet2_total",parseInt(sheetObjects[1].GetCellValue(i, "sheet2_rpr_qty")) * iSprPrtUcAmt,0);
					}
				}
				sheetObjects[0].SetRowStatus(dtlRow,"R");
			}
		}
		sheetObj.ColumnSort("Seq", "ASC") // initializing sort
		calReq=1;
		sheetObjects[1].SetSumValue("sheet2_cost_dtl_cd", "TOTAL");
		MnrWaitControl(false);
		if(Gubun=="Y")
			ComBtnDisable("btn_W/O_Send");
		else
			ComBtnDisable("btn_W/O_Creation");
		cal_flag = "N";
	}
	function setEqInfo(sheetObj,Row,sEqType,sEqNo,sTotalLossDate){
		var formObj=document.form;
		var sCostType="";
		if(combo_eq_knd_cd.GetSelectCode()== "U"){
			sCostType="MRDRRC";
		} else if(combo_eq_knd_cd.GetSelectCode()== "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sTotalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr != null){
			//TpSz
			sheetObjects[0].SetCellValue(Row,"sheet1_eq_tpsz_cd",retArr[0][31],0);
			//Yard
			sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd2",retArr[0][18],0);
			//rpr_dt
			sheetObjects[0].SetCellValue(Row,"sheet1_rpr_rslt_dt",retArr[0][32],0);
			//rpr_yd
			sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd",retArr[0][4],0);
			//rpr_yd
			sheetObjects[0].SetCellValue(Row,"sheet1_sp_name",retArr[0][5],0);
		} else {
			//TpSz
			sheetObjects[0].SetCellValue(Row,"sheet1_eq_tpsz_cd","",0);
			//Yard
			sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd2","",0);
			//rpr_dt
			sheetObjects[0].SetCellValue(Row,"sheet1_rpr_rslt_dt","",0);
			//rpr_yd
			sheetObjects[0].SetCellValue(Row,"sheet1_yd_cd","",0);
			//rpr_yd
			sheetObjects[0].SetCellValue(Row,"sheet1_sp_name","",0);
		}
		calReq=0;
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
	* initializing Tab
	* setting Tab items.
	*/
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
			}
			break;
		}
	}
	/**
	* Event when clicking Tab
	* activating selected tab items.
	*/
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	* handling process for input validation
	*/
	function validateForm(sheetObj,formObj,sAction){
		var comboCostCd = combo_cost_cd;
			// in case of adding
			if(sAction==IBINSERT)
			{
				if(comboCostCd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00205");
					return false;
				}else
				{
					if(sheetObj.GetCellValue(2, "Seq")=="0" )
					{
						sheetObj.RemoveAll();
					}else
					{
						for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
						{
							//2. in case of Cost Detail Type == ''
							var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")," ");
							if(strCostDtlCD=="")
							{
								ComShowCodeMessage("MNR00172","Service Sub Type");
								sheetObj.SelectCell(i, "sheet1_cost_dtl_cd",true);
								return false;
							}
							//3. checking EQ No mandatory
							var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_eq_no")," ");
							if(strEqNo=="")
							{
								ComShowCodeMessage("MNR00172","EQ No.");
								sheetObj.SelectCell(i, "sheet1_eq_no",true);
								return false;
							}
							//4. checking Yard mandatory
							var strYard=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_yd_cd2")," ");
							if(strYard=="")
							{
								ComShowCodeMessage("MNR00172","Yard");
								sheetObj.SelectCell(i, "sheet1_yd_cd2",true);
								return false;
							}
						}
					}
				}
			}
			//retrieving
			else if(sAction==IBSEARCH)
			{
				var sRow=sheetObj.FindStatusRow("I|U|D");  // checking sheet status
				if(sRow != "") // in case of existing edits
				{
					if(!ComShowCodeConfirm("MNR00007"))
					{
						return false;
					}
				}
				if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
				{
					ComShowCodeMessage("MNR00172",'W/O No');
					ComSetFocus(formObj.mnr_ord_seq);
					return false;
				}
				var strMnrOrdSeq=formObj.mnr_ord_seq.value;
				if(strMnrOrdSeq.length > 3)
				{
					strMnrOrdSeq=strMnrOrdSeq.substring(3);
					if(!ComIsNumber(strMnrOrdSeq))
					{
						ComShowCodeMessage("MNR00003");
						ComSetObjValue(formObj.mnr_ord_seq, "");
						ComSetFocus(formObj.mnr_ord_seq);
						return false;
					}
				}else{
					ComShowCodeMessage("MNR00003");
					ComSetObjValue(formObj.mnr_ord_seq, "");
					ComSetFocus(formObj.mnr_ord_seq);
					return false;
				}
			}
			// saving in case of confirmed
			else if(sAction==IBSAVE) {
				if(combo_vndr_seq.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");
					ComSetFocus(combo_vndr_seq);
					return false;
				}
				if(comboCostCd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00205");
					ComSetFocus(comboCostCd);
					return false;
				}
				//1. checking row in Grid Main whether one or more
				var rCnt=sheetObj.RowCount();
				if(rCnt<=0)
				{
					//a[not selected][MNR00072] - showing message 'choose data to creating Work Order'
					ComShowCodeMessage("MNR00072");
					return false;
				}
				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
				{
					//2. in case of Cost Detail Type == ''
					var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")," ");
					if(strCostDtlCD=="")
					{
						ComShowCodeMessage("MNR00036","Service Sub Type");
						sheetObj.SelectCell(i, "sheet1_cost_dtl_cd",true);
						return false;
					}
					//3. checking EQ No mandatory
					var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_eq_no")," ");
					if(strEqNo=="")
					{
						ComShowCodeMessage("MNR00172","EQ No.");
						sheetObj.SelectCell(i, "sheet1_eq_no",true);
						return false;
					}
					//4. checking Yard mandatory
					var strYard=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_yd_cd2")," ");
					if(strYard=="")
					{
						ComShowCodeMessage("MNR00172","Yard");
						sheetObj.SelectCell(i, "sheet1_yd_cd2",true);
						return false;
					}
					if(combo_cost_cd.GetSelectCode() == "MRDRPT"){
						var rprRsltDt = ComTrimAll(sheetObj.GetCellValue(i, "sheet1_rpr_rslt_dt2")," ");
						if(rprRsltDt=="")
						{
							ComShowCodeMessage("MNR00172","Work Date");
							sheetObj.SelectCell(i, "sheet1_rpr_rslt_dt2",true);
							return false;
						}
					}
				}
				var sRow=sheetObj.FindStatusRow("I|U");  // checking sheet status
				if(sRow != "") // in case of existing edits
				{
					ComShowCodeMessage("MNR00227");
					return false;
				}
				if(calReq==0)
				{
					ComShowCodeMessage("MNR00227");
					return false;
				}
			}
			//deleting
			else if (sAction==IBSEARCHAPPEND) {
				//1. checking row in Grid Main whether one or more
				var rCnt=sheetObjects[0].RowCount();
				if(rCnt<=0)
				{
					//a[not selected][MNR00072] - showing message 'choose data to creating Work Order'
					ComShowCodeMessage("MNR00081");
					return false;
				}
				var strMnrOrdSeq=formObj.mnr_ord_seq.value;
				if(strMnrOrdSeq.length > 3)
				{
					strMnrOrdSeq=strMnrOrdSeq.substring(3);
					if(!ComIsNumber(strMnrOrdSeq))
					{
						ComShowCodeMessage("MNR00081");
						return false;
					}
				}else{
					ComShowCodeMessage("MNR00081");
					return false;
				}
				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
				{
					var intPayInvSeq=sheetObj.GetCellValue(i,"sheet1_pay_inv_seq");
					if(intPayInvSeq =="") intPayInvSeq=0;
					if(parseInt(intPayInvSeq) > 0 )
					{
						ComShowCodeMessage("MNR00229");
						return false;
					}
				}
			}
			//copy
			else if (sAction=="COPY") {
				//grid whether or not
				if(!checkIsDetailRow()) {return false;}
			}
			//in case of deleting row
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
			}
			//in case of copying row
			else if (sAction==IBCOPYROW) {
				//grid whether or not
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//checking status of Tariff
				if(!checkTariffStatus()) {return false;}
			}
		return true;
	}
	function nvl(str){
		if(str == null) return '0';
		else return str;
	}
	function getDataString(xmlStr, codeCol, textCol) {
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
		try {
			var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);
			var xmlRoot=xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}
			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			var col=dataNode.getAttribute("COLORDER");
			var colArr=col.split("|");
			var sep=dataNode.getAttribute("COLSEPARATOR");
			var total=dataNode.getAttribute("TOTAL");
			var dataChildNodes=dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			var colListIdx=Array();
			for ( var i=0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0]=i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1]=i;
				}
			}
			var retStr="";
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				retStr=nvl(arrData[colListIdx[0]]) + '|'  + nvl(arrData[colListIdx[1]]);
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return retStr;
	}
