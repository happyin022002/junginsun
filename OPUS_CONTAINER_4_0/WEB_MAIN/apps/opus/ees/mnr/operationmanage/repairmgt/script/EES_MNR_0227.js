/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0227.js
*@FileTitle  : M&R Extra W/O Inquiry Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
	/****************************************************************************************
			  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
								MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
								COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0227 : ees_mnr_0227 - Defining a script used by screen
	 */
	function EES_MNR_0227() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var mnrHngrBarTpCode="";
	var mnrHngrBarTpDesc="";
	var nowLoad=0;

	var arrDataSearchDbXml;
	var frontMnrOrdSeq="";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
				break;
			case "btn_close":
				ComClosePopup(); 
				break;
			} // end switch
		}catch(e) {
			if (e == "[object Error]") {
				ComFuncErrMsg(e);
			} else {
				ComFuncErrMsg(e);
			}
		}
	}
	/**
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	function setParam(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(',');
		formObj.mnr_ord_seq.value=arr[4];
		if(formObj.mnr_ord_seq.value.length > 3){
			doIBSEARCH(sheetObjects[2], formObj, IBSEARCH);
		}
	}

	function initControl() {
		//Axon event handling 1. Catching event
		var formObject=document.form;
//		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
//		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
//		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		//axon_event.addListenerFormat('change',	 'obj_change',	formObject);
	}
	//Axon event handling 2. Event handling function
//	function obj_deactivate(){
//		ComChkObjValid(event.srcElement);
//	}
//	function obj_activate(){
//		ComClearSeparator(event.srcElement);
//	}
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
		if(obj.dataformat == null )
		{
			if(obj.name!="ord_hdr_rmk")
			{
				return;
			}
		}
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
		case "engnum":
			ComKeyOnlyAlphabet("num","32|64");
			break;
		}
	}
	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
			if(sheetObjects[i].id.substring(0,2) == "sheet2" ){
				DLCSheets[DLCSheetCnt++]=sheetObjects[i];
			}
		}
		initCombo();
		//ComConfigUpload(uploadObjects[0], "/opuscntr/MNR_INTGS.do");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		MnrWaitControl(false);
	}
	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files="";
	}
	/**
	 * Initializing multi combo
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
		with (combo_cost_cd) {
			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "180");
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
		combo_eq_knd_cd_Initialize();
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		with (sheetObj) {
			// Setting height
			
			var HeadTitle1="|Sel|Seq|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Yard Code|Unit Price| Q'ty|Amount|Booking No|Trade Code|Remark(s)";
			var headCount=ComCountHeadTitle(HeadTitle1) + 5;
			(headCount, 0, 0, true);
			var prefix="sheet1_";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_dtl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_expn_dtl_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_hngr_bar_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",   ColMerge:1,  SaveName:prefix+"yd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
			             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:195,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ord_dtl_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"file_seq",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_rt_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"eq_no_check_yn",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);
			SetSheetHeight(140);
			SetEditable(0);
			SetCountPosition(0);
			SetSelectionMode(smSelectionRow);


		}
		break;
		case 2:      // sheet2 init
//		with(sheetObj) {
//			// Setting height
//		    var prefix="";
//		    
//		    var HeadTitle1="|Evidence Attached|Evidence Attached|Evidence Attached";
//		    var HeadTitle2="|Seq|File|Download";
//		    var headCount=ComCountHeadTitle(HeadTitle1);
////		    (8, 0, 0, true);
//
//		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
//
//		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
//		    var headers = [ { Text:HeadTitle1, Align:"Center"},
//		                  { Text:HeadTitle2, Align:"Center"} ];
//		    InitHeaders(headers, info);
//
//		    var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
//		              {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
//		              {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
//		              {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
//		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//		              {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
//		     
//		    InitColumns(cols);
//		    SetSheetHeight(120);
//		    SetEditable(0);
//		    SetCountPosition(0);
//		    SetImageList(0,"img/ico_attach.gif");
//		    SetShowButtonImage(1);
//
//		}
			with(sheetObj){
			   var prefix="";
			   var HeadTitle1="|Evidence Attachment|Evidence Attachment|Evidence Attachment";
			   var HeadTitle2="|Seq.|File|Download";
			   var headCount=ComCountHeadTitle(HeadTitle1);
			   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"},
			                   { Text:HeadTitle2, Align:"Center"} ];
			   InitHeaders(headers, info);
			   var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
			             {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
			             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			   InitColumns(cols);
			   SetEditable(0);
			   SetCountPosition(0);
			   SetImageList(0,"img/ico_attach.gif");
			   SetShowButtonImage(1);
			   SetSheetHeight(122);
	   		}
		break;
		case 3:      // sheet1 init
		with (sheetObj) {
			// Setting height
//			SetSheetHeight(0);
			var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
			+ "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
			+ "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
			+ "|FILE_SEQ|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
			var headCount=ComCountHeadTitle(HeadTitle1);
			(headCount, 0, 0, true);
			var prefix="sheet3_";

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
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"file_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_inp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);
			SetVisible(0);
			SetEditable(0);
//			SetGetCountPosition(0);
			SetSelectionMode(smSelectionRow);

		}
		break;
		}
	}
	function checkSheetStatus(sheetObj){
		var flag=true;
		var sRow=sheetObj.FindStatusRow("I|U|D");
		if(sRow != "")
		{
			flag=false;
		}
		return flag
	}
	function checkWorkOrderNo(sheetObj, formObj, sAction){
		var flag=true;
		if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
		{
			ComShowCodeMessage("MNR00172",'W/O No');
			ComSetFocus(formObj.mnr_ord_seq);
			flag=false;
		}
		return flag
	}
	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:
				doIBCLEAR(sheetObj, formObj, sAction);
				break;
			case IBSEARCH:      //Retrieving
				if(checkSheetStatus(sheetObj))
				{
					if(checkWorkOrderNo(sheetObj, formObj, sAction))
					{
						doIBSEARCH(sheetObj, formObj, sAction);
					}
				}
				else
				{
					if(ComShowCodeConfirm("MNR00007"))
					{
						if(checkWorkOrderNo(sheetObj, formObj, sAction))
						{
							doIBSEARCH(sheetObj, formObj, sAction);
						}
					}
				}
				break;
			case IBDOWNEXCEL:
 				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				break;
		}
	}
	function doIBSEARCH(sheetObj, formObj, sAction){
		nowLoad=1;
		formObj.f_gubuns.value="popup";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
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
		MnrWaitControl(true);
		formObj.f_cmd.value=SEARCH;
		var sParam="";
		var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
 		var sXml=sheetObj.GetSearchData("EES_MNR_0227GS.do", sParam);
		arrDataSearchDbXml=sXml.split("|$$|");
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			if(i==0)continue;
//			sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
//			sheetObjects[i].RenderSheet(1);
		}
	}
	function doIBCLEAR(sheetObj, formObj, sAction){
		MnrWaitControl(true);
		formObj.f_gubuns.value="popup";
		formObj.showDate.value=ComGetNowInfo();
		formObj.pic_eng_nm.value="";
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.curr_cd.value="";
		formObj.cost_cd.value="";
		combo_vndr_seq.SetSelectCode("-1");
		combo_vndr_seq.RemoveAll();
		combo_vndr_seq.SetSelectCode("-1");
		combo_cost_cd.RemoveAll();
		formObj.ord_hdr_rmk.value="";
		combo_eq_knd_cd_Initialize();
		combo_vndr_seq_Initialize();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		MnrWaitControl(false);
	}
	/**
	 * combo value retrieving(Agreement No) and initializing
	 * @return
	 */
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
		combo_vndr_seq.SetSelectCode("");
	}
	function combo_cost_cd_Initialize(eqtype){
		var formObj=document.form;
		combo_cost_cd.SetSelectCode("-1",false);
		combo_cost_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd",eqtype, "CUSTOM6") //Cost Type
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
						var tempTxt = tempText[0]+"-"+tempText[1];
						if(tempText[0]=="MRRFPM"){  //PM
							if(currOfcCd=="PUSBO" || currOfcCd =="KANBO" || currOfcCd =="INCBO"|| currOfcCd =="SELBB"){
								combo_cost_cd.InsertItem(j, tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
							}
						}else{
							combo_cost_cd.InsertItem(j, tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
						}
					}
				}
			}
		}
		combo_cost_cd.SetSelectCode(OrgCostType);
	}
	function combo_eq_knd_cd_Initialize(){
		var formObj=document.form;
		combo_eq_knd_cd.SetSelectCode("-1",false);
		combo_eq_knd_cd.RemoveAll();
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
					combo_eq_knd_cd.SetSelectCode("");
				}
			}
		}
	}
	function combo_eq_knd_cd_OnChange(indexCode, Text){
		if(combo_eq_knd_cd.GetSelectCode() == null) return;
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
	}
	/**
	 * Event handling of Onchange of combo
	 * Setting display of column of sheet when Cost Type changed
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	function combo_cost_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		setSheetColumnDisplay(combo_cost_cd.GetSelectCode());  //Setting column display by Cost Type combo
		var formObj=document.form;
		var cnt=10;
		if(comboObj.GetSelectCode() == 'MRDRHA' || comboObj.GetSelectCode() == 'MRDRHD'){
			if(comboObj.GetSelectCode() == 'MRDRHA'){
				sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",0);
			}else{
				sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
			}
			var info = { EditLen:3 };
			sheetObjects[0].InitCellProperty(0, "sheet1_rpr_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_act_invt_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_hngr_dmg_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_lost_hngr_qty",	info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_disp_hngr_qty", info);
		} else {
			var info = { EditLen:6 };
			sheetObjects[0].InitCellProperty(0, "sheet1_rpr_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_act_invt_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_hngr_dmg_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_lost_hngr_qty",	info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_disp_hngr_qty", info);
			sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
			sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
			sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
		}
		var formObj=document.form;
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheet1_cost_dtl_cd_Initialize(NewCode);
				sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}
		} else {
			sheet1_cost_dtl_cd_Initialize(NewCode);
			sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
		}
//		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
// 			for(var i=0; i < sheetObjects[0].LastRow()+1; i ++ ){
//			var tmpEx=sheetObjects[0].GetCellValue(i, "cost_dtl_cd");
//				if(tmpEx != combo_cost_cd.GetSelectCode()){
//					if(ComShowCodeConfirm("MNR00080")){
//						sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
//						sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
//						sheetObjects[1].RemoveAll();
//						sheetObjects[2].RemoveAll();
//					}else{
//						combo_cost_cd.SetSelectCode(OrgCostType,false);
//						setSheetColumnDisplay(OrgCostType);  //Undo setting display
//						break;
//					}
//				}
//			}
//		}else{
//			sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
//			sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
//		}
		OrgCostType=combo_cost_cd.GetSelectCode();
	}
	function combo_vndr_seq_OnChange(indexCode, Text){
		var formObj=document.form;
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
				sheet1_cost_dtl_cd_Initialize(combo_cost_cd.GetSelectCode());
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}else{
				combo_cost_cd.SetSelectCode(OrgCostType,false);
			}
		}
	}
	//Extra Expense Type Sheet Combo
	function sheet1_cost_dtl_cd_Initialize(costtype){
		if(nowLoad==0)sheetObjects[0].RemoveAll();
		var formObj=document.form;
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
				}
			}
		}
	}
	//MNR_HNGR_BAR_TP_CD Sheet Combo
	function sheet1_mnr_hngr_bar_tp_cd_Initialize(costtype){
		if(nowLoad==0)sheetObjects[0].RemoveAll();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd",costtype, "COMMON") //Service Sub Type
		);
		mnrHngrBarTpCode="";
		mnrHngrBarTpDesc="";
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
						mnrHngrBarTpCode=mnrHngrBarTpCode + tempText[0] + "|";
						mnrHngrBarTpDesc=mnrHngrBarTpDesc + tempText[1] + "|";
					}
				}
				if(i==0)
				{
					mnrHngrBarTpCode=mnrHngrBarTpCode.substring(0, mnrHngrBarTpCode.length - 1);
					mnrHngrBarTpDesc=mnrHngrBarTpDesc.substring(0, mnrHngrBarTpDesc.length - 1);
					sheetObjects[0].SetColProperty(0,"sheet1_mnr_hngr_bar_tp_cd", {ComboText:mnrHngrBarTpDesc, ComboCode:mnrHngrBarTpCode} );
				}
			}
		}
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") {
				if(strMnrOrdSeq=="" || strMnrOrdSeq=="NEW" )
				{
					ComShowCodeMessage("MNR00073");
				}else{
					ComShowCodeMessage("MNR00222");
				}
			} else {
				ComShowCodeMessage("MNR00074",ErrMsg);
			}
		}else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "") {
				ComShowCodeMessage("MNR00082",ErrMsg);
			} else {
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}
		nowLoad=0;
		MnrWaitControl(false);
	}
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj=document.form;
		if(combo_cost_cd.GetSelectCode()!= "MRDRHG")
		{
			if(sheetObj.ColSaveName(NewCol) == "sheet1_eq_no")
			{
				sheetObj.SelectCell(NewRow, "sheet1_mnr_expn_dtl_nm",true);
			}
			if(sheetObj.ColSaveName(NewCol) == "sheet1_mnr_hngr_bar_tp_cd")
			{
				sheetObj.SelectCell(NewRow, "sheet1_spr_prt_uc_amt",true);
			}
			if(sheetObj.ColSaveName(NewCol) == "sheet1_cost_amt")
			{
				sheetObj.SetCellEditable(NewRow, NewCol,0);
			}
		}else{
			if(sheetObj.ColSaveName(NewCol) == "sheet1_cost_amt")
			{
				sheetObj.SetCellEditable(NewRow, NewCol,1);
			}
		}
		if(sheetObj.ColSaveName(OldCol) == "sheet1_eq_no" && combo_cost_cd.GetSelectCode()== "MRDRHG"){
			sheet1_eq_no_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol);
			return false;
		}
		if(OldRow !=NewRow)
		{
			if (nowLoad != 0) return;
			if(combo_cost_cd.GetSelectCode()== "MRDRHG"){
				sheetObj.SetCellBackColor(NewRow,"sheet1_eq_no","#FFFFFF");
				sheetObj.SetCellEditable(NewRow,"sheet1_eq_no",1);
				sheetObj.SetCellBackColor(NewRow,"sheet1_mnr_hngr_bar_tp_cd","#FFFFFF");
				sheetObj.SetCellEditable(NewRow,"sheet1_mnr_hngr_bar_tp_cd",1);
			}else
			{
				sheetObj.SetCellBackColor(NewRow,"sheet1_eq_no","#EFEBEF");
				sheetObj.SetCellEditable(NewRow,"sheet1_eq_no",0);
				sheetObj.SetCellBackColor(NewRow,"sheet1_mnr_hngr_bar_tp_cd","#EFEBEF");
				sheetObj.SetCellEditable(NewRow,"sheet1_mnr_hngr_bar_tp_cd",0);
			}
			return;
		}
	}
	/**
	 * Event handling of click of sheet1 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	Selected row
	 * @param {ibsheet} Col     	Selected column
	 * @param {String} 	Value     	File name
	 **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	function sheet3_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet3_";
		if(sheetObj.RowCount()<=0)
		{
			nowLoad=0;
			doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComShowCodeMessage("MNR00005", "W/O No.");
			ComSetFocus(formObj.mnr_ord_seq);
			MnrWaitControl(false);
			return false;
		}
//no support[check again]CLT 		combo_vndr_seq.UseCode=false;
		var agree_no=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd")
		+ ComLpad(sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
		
		if(agree_no!="000000"){
			combo_vndr_seq.SetSelectIndex(combo_vndr_seq.FindItem(agree_no,2, true));
			//no support[check again]CLT 		combo_vndr_seq.UseCode=true;
			formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
			formObj.vndr_seq.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 ) ;
		}else{
			formObj.pic_eng_nm.value="";
			formObj.vndr_seq.value="";
		}
 		
		combo_eq_knd_cd.SetSelectCode(sheetObjects[2].GetCellValue(1, prefix+ "eq_knd_cd"),false);
		formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectText();
		formObj.curr_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ver_no");
		formObj.file_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "file_seq");
		formObj.showDate.value=sheetObjects[2].GetCellValue(1, prefix+ "cre_dt");
		var costcd=sheetObjects[2].GetCellValue(1, prefix+ "cost_cd");
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
		combo_cost_cd.SetSelectCode(costcd);
		formObj.cost_cd.value=combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 2);
		formObj.ord_hdr_rmk.value=sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
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
		var ArrMnrHngrBarTpCdDesc=mnrHngrBarTpDesc.split("|");
		for(var i=1;i<=sheetObjects[0].RowCount();i++)
		{
			var idx=sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
			var idx2=sheetObjects[0].GetComboInfo(i, prefix+ "mnr_hngr_bar_tp_cd", "SelectedIndex");
			sheetObjects[0].SetCellText(i, prefix+ "cost_dtl_cd" ,ArrCostDtlDesc[idx]);
			sheetObjects[0].SetCellText(i, prefix+ "mnr_hngr_bar_tp_cd" ,ArrMnrHngrBarTpCdDesc[idx2]);
		}
		var fileSeq=formObj.file_seq.value;
		if(fileSeq != "" || fileSeq != undefined){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			sheetObjects[1].LoadSearchData(fileXml,{Sync:1} );
		}
		nowLoad=0;
		MnrWaitControl(false);
	}
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		with (formObj) {
			if (!ComChkObjValid(formObj))
				return false;
		}
		return true;
	}
	/**
	 * Adding row of IBSheet<br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {nothing}
	 **/
	function file_Insert(sheetObj){
		MnrWaitControl(true);
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined){
			uploadFileSeq="";
		}
		var row=sheetObj.DataInsert(-1);
		sheet2_OnPopupClick(sheetObj,row,2);
	}
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			if(sheetObj.RowCount()==1 )
			{
				document.form.file_seq.value="0";
				MnrWaitControl(false);
			}
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	function nvl(str){
		if(str == null) return '0';
		else return str;
	}
	/**
	 * Setting column display by Cost Type combo
	 * @param costType
	 * @return
	 */
	function setSheetColumnDisplay(costType) {
		//Container - Hanger
		if (costType=="MRDRHA" || costType=="MRDRHD") {
			sheetObjects[0].SetColHidden("sheet1_eq_no",0);//EQ No
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_bar_tp_cd",0);//Hanger Bar Type
			sheetObjects[0].SetColHidden("sheet1_rpr_qty",0);//Hanger Bar Qty
			sheetObjects[0].SetColHidden("sheet1_mnr_expn_dtl_nm",1);//Description
			sheetObjects[0].SetColHidden("sheet1_spr_prt_uc_amt",1);//Unit Price
			sheetObjects[0].SetColHidden("sheet1_bar_if_chk",0);//bar_if_chk
			sheetObjects[0].SetCellValue(0,"sheet1_rpr_qty","Hanger Bar QTY");
			sheetObjects[0].SetColWidth("sheet1_rpr_qty",100);
		} else {
			//Chassis - Pre-Maintenance
			if(costType=="MRZSPR") {
				sheetObjects[0].SetColHidden("sheet1_eq_no",0);//EQ No
			} else {
				sheetObjects[0].SetColHidden("sheet1_eq_no",1);//EQ No
			}
			if(costType=="MRDROT" || costType=="MRZSOT" || costType=="MRGSOT" || costType=="MRZSTP" || costType=="MRZSTR") {
				sheetObjects[0].SetColHidden("sheet1_rpr_qty",0);
			}else{
				sheetObjects[0].SetColHidden("sheet1_rpr_qty",1);
			}
			sheetObjects[0].SetColHidden("sheet1_bar_if_chk",1);//bar_if_chk
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_bar_tp_cd",1);//Hanger Bar Type
			sheetObjects[0].SetColHidden("sheet1_mnr_expn_dtl_nm",0);//Description
			sheetObjects[0].SetColHidden("sheet1_spr_prt_uc_amt",0);//Unit Price
			sheetObjects[0].SetCellValue(0,"sheet1_rpr_qty","Q'ty");
			sheetObjects[0].SetColWidth("sheet1_rpr_qty",60);
		}
		//Chassis - The Pachase
		if(costType=="MRZSTP"){
			sheetObjects[0].SetCellValue(0,"sheet1_mnr_expn_dtl_nm","Brand");
		}else{
			sheetObjects[0].SetCellValue(0,"sheet1_mnr_expn_dtl_nm","Description");
		}
	}
	/* End of developer's task */
