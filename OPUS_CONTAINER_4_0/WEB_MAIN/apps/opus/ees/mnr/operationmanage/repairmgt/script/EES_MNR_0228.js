/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0228.js
*@FileTitle  : M&R Reefer Spare Parts W/O Inquiry Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
	/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0228 : business script for ees_mnr_0228.
	 */
	/* developer job */
	// common global variables
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
	// calling Calculate
	var calReq=0;
	// deleting calculate
	var calDel="";
	var OrgVndrSeq="";
	var OrgCostCd="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick; 
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_downExcel":
				if(sheetObjects[0].RowCount() < 1){// no data
					ComShowCodeMessage("COM132501");
   	       		}else{
 					sheetObjects[0].Down2Excel();
   	       		}
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
	        case "btn_close":    
	        	ComClosePopup(); 
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
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen.
	 */
	function loadPage() {
		MnrWaitControl(true);
	//	initControl();
		for(i=0;i<sheetObjects.length;i++){
			//
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			//
			ComEndConfigSheet(sheetObjects[i]);
		}
		initCombo();
		sheet1_spr_prt_ut_tp_nm_Initialize();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

		MnrWaitControl(false);
	}
	function initControl() {       
		// Axon handling event1. event catch
		var formObject=document.form;       
// axon_event.addListenerForm ('blur', 'obj_deactivate', formObject);
// axon_event.addListenerFormat('focus', 'obj_activate', formObject);
// axon_event.addListenerFormat('keypress', 'obj_keypress', formObject);
// axon_event.addListenerFormat('change', 'obj_change', formObject);
	}             
	// Axon handling event2. handling event
	function obj_deactivate(){      
		ComChkObjValid(ComGetEvent()); 
	} 
	function obj_activate(){   
		ComClearSeparator(ComGetEvent());
	}   
	function obj_change()
	{	     
		var obj=ComGetEvent(); 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) 
		{
			switch(ComGetEvent("name"))
			{      
				case "none":  
	  				break; 
			}       
		} 
	}    
	function obj_keypress(){   
		obj=ComGetEvent();    
		keys=event.keyCode;
		if(obj.dataformat == null) return; 
		window.defaultStatus=obj.dataformat;
		var formObj=document.form; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
			case "none":   
  				break;   			
			}       
		}				 			              
		switch(obj.dataformat) {   
        case "ymd":
        case "ym":
        case "hms":
        case "hm": 
		case "int":       
			ComKeyOnlyNumber(obj); 
			break;     
		case "float":    
			ComKeyOnlyNumber(obj, "-.");
			break; 
		case "eng":   
			ComKeyOnlyAlphabet();
			break;   
		case "engup":  
			ComKeyOnlyAlphabet('uppernum');           
			break; 
		}         
	}     
	/**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		with (sheetObj) 
		{
	        var HeadTitle1="|Sel|Seq.|Unit Type|Part No.|Part Name|Q'ty|Unit Cost|Total|Remark(s)|COST_CD";
	        var headCount=ComCountHeadTitle(HeadTitle1);
// (headCount, 0, 0, true);
	        var prefix="sheet1_";

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	               {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_ut_tp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ord_dtl_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	         
	        InitColumns(cols);
	        SetEditable(0);
	        SetSheetHeight(140);
	        SetShowButtonImage(2);
		}
		break;
		case 2:      // sheet1 init
		with (sheetObj) {
	       
	        var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
	        + "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
	        + "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
	        + "|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
	        var headCount=ComCountHeadTitle(HeadTitle1);
// (headCount, 0, 0, true);
	        var prefix="sheet2_";

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
	               {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_agmt_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wrk_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
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
	       SetCountPosition(0);
	       SetSelectionMode(smSelectionRow);
// SetSheetHeight(0);
	       SetVisible(0);

		}
		break;
		case 3: 
			with (sheetObj) {
				// setting Host information[HostIp, Port, PagePath]
// no support[check again]CLT if (location.hostname != "")
// InitHostInfo(location.hostname, location.port, page_path);
			}	 
			break;
		}
	}
	/**
	 * initializing multi Combo
	 * 
	 * @return
	 */
	function initCombo() {
		var formObject=document.form
		with (combo_vndr_seq) {
			SetMultiSeparator("|");
			SetTitle("S/P Name|S/P Code|AGMT No|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code"); 
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColAlign(2, "center");
			SetColAlign(3, "left");
			SetColAlign(4, "center");
			SetColAlign(5, "left");
			SetColAlign(6, "left");
			SetColAlign(7, "left");
			SetColWidth(0, "180");
			SetColWidth(1, "80");
			SetColWidth(2, "90");
			SetColWidth(3, "80");
			SetColWidth(4, "170");
			SetColWidth(5, "180");
			SetColWidth(6, "180");
			SetColWidth(7, "0");
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
		with (combo_spr_prt_spl_tp_cd) {
 			SetMultiSeparator("|");
 			SetColAlign(0, "left");
 			SetColWidth(0, "80");
 			SetDropHeight(160);
 			SetEnable(1);
		} 
		combo_eq_knd_cd_Initialize();
		combo_spr_prt_spl_tp_cd_Initialize();
	}
	function combo_vndr_seq_Initialize(){
		var formObj=document.form;
		var sXml=MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult=MnrXmlToArray(sXml);	
		if(arrResult != null){	 	     
			for(var i=0; i < arrResult.length;i ++){
				var tempComboText=arrResult[i][8]       // 8 vndr_nm|
				                 + "|" + arrResult[i][1]  // 1 vndr_seq|
				                 + "|" + arrResult[i][9]  // 9 agmt_no|
				     			 + "|" + arrResult[i][30]  // 29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   // 3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  // 13
																					// eff_dt
																					// - 15
																					// exp_dt|
				                 + "|" + arrResult[i][2] // 2 agmt_ref_no|
				                 + "|" + arrResult[i][25]   // 25 trf_no|
				                 + "|" + arrResult[i][14] // 14 curr_cd|
				                 + "^" + arrResult[i][12]   // 12 agmt_ver_no|
	                             + "^" + arrResult[i][28]   // 28eq_knd_cd|
				                  ;				
				combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]); 
			}				 						
		} else {		
			ComShowCodeMessage("MNR00056");         
		} 	  
	}           
	function combo_vndr_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){//indexCode,Text
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
		combo_eq_knd_cd.SetSelectCode(spltEtc[2]);
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){ 
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			}
		}
	}     
	function combo_eq_knd_cd_Initialize(){
		var formObj=document.form;
		combo_eq_knd_cd.SetSelectCode("-1",false);
		combo_eq_knd_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00002", "COMMON") // EQ Type
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
					combo_eq_knd_cd.SetSelectCode("");
				}
			}
		}
	}  
	// Supply To ComboBox
	function combo_spr_prt_spl_tp_cd_Initialize(){
		var formObj=document.form;
		combo_spr_prt_spl_tp_cd.SetSelectCode("-1",false);
		combo_spr_prt_spl_tp_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00037", "COMMON") // Supply To
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
						combo_spr_prt_spl_tp_cd.InsertItem(j, tempText[1] ,tempText[0]);
					}
				}
				if(i == 0)
				{	
				//	combo_spr_prt_spl_tp_cd.SetSelectCode("");
				}
			}
		}
	}      
	function combo_eq_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		if(newText == null) return;
		// combo_cost_cd_Initialize(Text);
	}   
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:
			MnrWaitControl(true);
			formObj.f_gubuns.value="popup";
			formObj.showDate.value=ComGetNowInfo();
			formObj.pic_eng_nm.value="";
			formObj.eff_dt.value="";
			formObj.exp_dt.value="";
			formObj.spr_prt_spl_dt.value=ComGetNowInfo();
			formObj.curr_cd.value="";
			formObj.vsl_vvd.value="";	
			formObj.vsl_cd.value="";	
			formObj.vsl_cd2.value="";	
			formObj.spr_prt_spl_yd_cd.value="";
			formObj.spr_prt_spl_yd_cd2.value="";	
			formObj.spr_prt_spl_dt2.value="";
			formObj.pic_eng_nm2.value="";
			combo_vndr_seq.SetSelectCode("-1",false);
			combo_vndr_seq.RemoveAll();
		//	combo_spr_prt_spl_tp_cd.SetSelectCode("V",false);
			formObj.ord_hdr_rmk.value="";
			combo_vndr_seq_Initialize ();
			combo_eq_knd_cd_Initialize();
			sheetObjects[0].RemoveAll();
//			sheetObjects[1].RemoveAll();
			MnrWaitControl(false);
			break;
		case IBSEARCH:      // retrieving
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="popup";
			sheetObjects[0].RemoveAll();
//			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value=SEARCH; 
			var sParam="";
			var aryPrefix=new Array("sheet1_", "sheet2_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
 			var sXml=sheetObj.GetSearchData("EES_MNR_0228GS.do", sParam);
 			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				if(i == 0 ){
					sheetObjects[0].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
					continue;
				}
			//	sheetObjects[i].RenderSheet(0);
				// temp 
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				
				sheetObjects[1].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
		//		sheetObjects[i].RenderSheet(1);
			}   	
			
			break;
		case IBDOWNEXCEL:
			if(sheetObj.RowCount() < 1){// no data
       		 		ComShowCodeMessage("COM132501");
	       		}else{
	       			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
	       		}
			break;
		}
	}
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if(nowLoad != 0) return;
		if (sheetObj.ColSaveName(Col) != "sheet1_spr_prt_no") return;
		// 2. in case of Unit Type == ''
		var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(Row, "sheet1_spr_prt_ut_tp_nm")," ");
		if(strCostDtlCD=="")
		{
			ComShowCodeMessage("MNR00036","Unit Type");
			sheetObj.SelectCell(Row, "sheet1_spr_prt_ut_tp_nm",	true);
			return; 
		}
		ComOpenPopup("EES_MNR_0214.do", 700, 450, 'setPopUpParam_EES_MNR_0214', '0,0', true);
	}   
	function sheet1_spr_prt_ut_tp_nm_Initialize(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00009", "COMMON") // SHEET UNIT Type
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
					sheetObjects[0].SetColProperty(0,"sheet1_spr_prt_ut_tp_nm", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
				}
			}
		}
	}          
	function sheet2_OnSearchEnd(sheetObj, errMsg)
	{
		var formObj=document.form;
		var prefix="sheet2_";
		if(sheetObj.RowCount()<=0)
		{
			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");  
			ComShowCodeMessage("MNR00005", "W/O No.");  
			ComSetFocus(formObj.mnr_ord_seq); 
			nowLoad=0;
			return false;
		}
// no support[check again]CLT formObj.combo_vndr_seq.UseCode=false;
		var agree_no=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ofc_cty_cd")
		+ ComLpad(sheetObjects[1].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
		
		if(agree_no != "000000"){
			combo_vndr_seq.SetSelectIndex(combo_vndr_seq.FindItem(agree_no,2, true));
			// no support[check again]CLT formObj.combo_vndr_seq.UseCode=true;
			//	combo_spr_prt_spl_tp_cd.SetSelectCode(sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_tp_cd"));
			//	formObj.spr_prt_spl_tp_cd.value=combo_spr_prt_spl_tp_cd.GetSelectText();
			OrgVndrSeq=combo_vndr_seq.GetSelectCode();
			formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
			formObj.vndr_seq.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 ) ;
		}else{
			formObj.pic_eng_nm.value="";
			formObj.vndr_seq.value="" ;
		}
 	      
		combo_eq_knd_cd.SetSelectCode(sheetObjects[1].GetCellValue(1, prefix+ "eq_knd_cd"),false);
		formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectText();
		formObj.curr_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ver_no");
		formObj.showDate.value=sheetObjects[1].GetCellValue(1, prefix+ "cre_dt");
		formObj.ord_hdr_rmk.value=sheetObjects[1].GetCellValue(1, prefix+ "ord_hdr_rmk");
		formObj.vsl_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd");
		formObj.vsl_cd2.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd");
		formObj.spr_prt_spl_yd_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_yd_cd");
		formObj.spr_prt_spl_yd_cd2.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_yd_cd");
		formObj.spr_prt_spl_dt.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_dt");
		formObj.spr_prt_spl_dt2.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_dt");
		formObj.vsl_vvd.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd")
		+sheetObjects[1].GetCellValue(1, prefix+ "skd_voy_no")
		+sheetObjects[1].GetCellValue(1, prefix+ "skd_dir_cd");
		for ( var i=0; i < arrDataSearchDbXml.length; i++)
		{
			if(i>0)break;
			sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
			sheetObjects[i].RenderSheet(1);
		}    
		formObj.pic_eng_nm2.value=formObj.pic_eng_nm.value;
		nowLoad=0;
		MnrWaitControl(false);
	}
	/**
	 * registering IBTab Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * initializing Tab setting Tab items.
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
	 * Event when clicking Tab activating selected tab items.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		// --------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		// ------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			// retrieving
			if(sAction==IBSEARCH)
			{
				var sRow=sheetObj.FindStatusRow("I|U|D");  // checking sheet
															// status
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
					return false;
				}
				var strMnrOrdSeq=formObj.mnr_ord_seq.value;
				if(strMnrOrdSeq.length > 3)
				{
					strMnrOrdSeq=strMnrOrdSeq.substring(3);
					if(!ComIsNumber(strMnrOrdSeq))
					{
						ComShowCodeMessage("MNR00003");
						return false;
					}
				}else{
					ComShowCodeMessage("MNR00003");
					return false;
				}		
			}
			// Load Excel
			else if (sAction==IBLOADEXCEL) {
				// checking status of Tariff
				if(!checkTariffStatus()) {return false;}
			}
		}
		return true;
	}
	function nvl(str){
		if(str == null) return '0';
		else return str;
	}
