﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0054.js
*@FileTitle  : Vessel Reefer Spare Part Purchase W/O Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
	/****************************************************************************************
	  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
						COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0054 : ees_mnr_0054 - Defining a script used by screen
	 */
	/* Developer's task	*/
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var nowLoad=0;
	//Variable for update
	var uploadObjects=new Array();
	var uploadCnt=0;
	//Requesting calculate
	var calReq=0;
	//Deleting calculate
	var calDel="";
	var OrgVndrSeq="";
	var OrgCostCd="";
	var sprPrtSplDt="";
	
	var sXml_1 = "";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	//Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
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
			case "btn_Detail":
				ComOpenPopup("EES_MNR_0194.do", 950, 420, 'setPopUpParam_EES_MNR_0194', '0,0', true);
				break;
			case "btn_calendar":
				sprPrtSplDt=formObject.spr_prt_spl_dt.value;
				var cal=new ComCalendar();
				cal.setEndFunction("spr_prt_spl_dt_CalendarSetFunction");
				cal.select(formObject.spr_prt_spl_dt, 'yyyy-MM-dd');
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
				if(formObject.combo_cost_cd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00205");
					ComSetFocus(formObject.combo_cost_cd);
					return false;
				}
				ComOpenPopup("/opuscntr/EES_MNR_0219.do", 698, 535, 'setPopUpParam_EES_MNR_0219', '1,0', true);
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_New":
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
	* Assigning array of IBSheet object
	* Array defined at the top of the source
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	//part NO
	function setPopUpParam_EES_MNR_0214(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split('|');
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_spr_prt_nm",arr[3],0);
		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_spr_prt_no",arr[4],0);
		sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(),"sheet1_rpr_qty",true);
	}
	function setPopUpParam_EES_MNR_0211(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(',');
		formObj.mnr_ord_seq.value=arr[4];
		if(formObj.mnr_ord_seq.value.length > 3){
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		}
	}
	function setPopUpParam_EES_MNR_0194(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(',');
		formObj.mnr_ord_seq.value=arr[5];
		if(formObj.mnr_ord_seq.value.length > 3){
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		}
	}
	function spr_prt_spl_dt_CalendarSetFunction()
	{
		var formObj=document.form;
		if(formObj.spr_prt_spl_dt.value.length>=8 && sprPrtSplDt !=""){
			if(formObj.eff_dt.value.length <10)
			{
				formObj.spr_prt_spl_dt.value=formObj.spr_prt_spl_dt.value.substring(0,4)
				+"-"+formObj.spr_prt_spl_dt.value.substring(4,6)
				+"-"+formObj.spr_prt_spl_dt.value.substring(6,8);
			}
			if(sprPrtSplDt != formObj.spr_prt_spl_dt.value)
			{
				ComBtnDisable("btn_W/O_Send");
				ComBtnEnable("btn_W/O_Creation");
			}
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
		}
		initCombo();
		combo_spr_prt_spl_tp_cd_Initialize();
		sheet1_spr_prt_ut_tp_nm_Initialize();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	}
	function initControl() {
		//Axon event handling 1. Catching event
		var formObject=document.form;
//		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
//		axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
		axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
		axon_event.addListener('change',	 'obj_change1',	'ord_hdr_rmk');
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
		var obj = ComGetEvent();
		ComChkObjValid(obj);
		if(obj.name == "spr_prt_spl_dt"){
			ComAddSeparator(obj, "ymd");
		}
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
			case "mnr_ord_seq":
				var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail=strMnrOrdSeqAll.substring(3);
				if(!ComIsNumber(strMnrOrdSeqTail))
				{
					formObj.mnr_ord_seq.value=strMnrOrdSeqAll.substring(0,3);
				}
				doActionIBSheet(sheetObj, formObj , IBSEARCH);
				break;
  			case "vsl_vvd":
  				if(formObj.vsl_vvd.value!="")
  				{
  					ComBtnDisable("btn_W/O_Send");
  					ComBtnEnable("btn_W/O_Creation");
  					checkVesselInfo(sheetObj,formObj.vsl_vvd.value);
  				}
  				break;
  			case "spr_prt_spl_dt":
				ComBtnDisable("btn_W/O_Send");
				ComBtnEnable("btn_W/O_Creation");
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
	function obj_keypress(){
		obj=ComGetEvent();
		keys=event.keyCode;
		if(obj.dataformat == null) return;
		window.defaultStatus=obj.dataformat;
		var formObj=document.form;
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
			case "mnr_ord_seq":
				var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail="";
				if(strMnrOrdSeqAll=="NEW")
				{
					formObj.mnr_ord_seq.value="";
				}
				if(strMnrOrdSeqAll.length > 3)
				{
					if(keys==13)
					{
						ComSetFocus(formObj.combo_vndr_seq);
					}
				}
				break;
			case "vsl_vvd":
  				var strVslCdAll=formObj.vsl_vvd.value;
  				if(strVslCdAll.length >= 9)
  				{
  					if(keys==13)
  					{
  						checkVesselInfo(sheetObj,strVslCdAll);
  					}
  				}
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
	* Initializing variable for IBSheet and defining header
	* param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	*/
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
			  with(sheetObj){
				   var HeadTitle1="|Sel|Seq.|Unit Type|Part No.|Part Name|Description|Q'ty|Unit Cost|Total|Remark(s)|cost_cd";
				   var headCount=ComCountHeadTitle(HeadTitle1);
				   (headCount, 0, 0, true);
				   var prefix="sheet1_";
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				   InitHeaders(headers, info);
				   var cols = [ 	{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					             {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_ut_tp_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"PopupEdit", Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"spr_prt_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_expn_dtl_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
					             {Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
					             {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
					             {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ord_dtl_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					             {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				    
				   InitColumns(cols);
				   SetEditable(1);
				   SetSheetHeight(220);
				   SetShowButtonImage(1);
		   }
		    break;
		case 2:      // sheet1 init
		    with(sheetObj){	       
			      var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
			      + "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
			      + "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
			      + "|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 0, 0, true);
			      var prefix="sheet2_";
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
			      SetVisible(0);
			      SetSelectionMode(smSelectionRow);
	      }
	      break;

		}
	}
	/**
	* Initializing multi combo
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
		with (combo_eq_knd_cd) {
			SetMultiSeparator("|");
			SetTitle("Code|Name");
			//MultiSelect = false;
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColWidth(0, "90");
			SetColWidth(1, "180");
			SetDropHeight(160);
			SetEnable(0);
			SetTitleVisible(true);
		}
		with (combo_spr_prt_spl_tp_cd) {
 			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
 			SetDropHeight(160);
 			SetEnable(1);
		}
		//combo_eq_knd_cd_Initialize();
		//combo_spr_prt_spl_tp_cd_Initialize();
	}
	function checkVesselInfo(sheetObj,vsl_cd){
		var formObj=document.form;
		var sXml=MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr=MnrXmlToArray(sXml);
		//0vsl_eng_nm|1 ibflag|2 skd_dir_cd| 3 skd_voy_no|4 pagerows|5 vsl_slan_cd|6 vsl_cd|
		MnrWaitControl(false);
		if(retArr != null){
			var strVslVvd=formObj.vsl_vvd.value;
			formObj.vsl_cd2.value=strVslVvd.substring(0,4);
			ComSetFocus(formObj.spr_prt_spl_dt);
		} else {
			ComShowCodeMessage("MNR00101");
			formObj.vsl_vvd.value="";
			ComSetFocus(formObj.vsl_vvd);
		}
		calReq=0;
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
	function combo_vndr_seq_OnChange(indexCode, Text){
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
		var combo_idx = parseInt(combo_vndr_seq.GetSelectIndex());
		var strEtc=combo_vndr_seq.GetText(combo_idx, 8 );
		var spltEtc=strEtc.split("^");
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(combo_idx, 0 );
		formObj.curr_cd.value=spltEtc[0];
		var strAgmtNo=combo_vndr_seq.GetText(combo_idx,  2 );
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
		var arr=combo_vndr_seq.GetText(combo_idx,  5 ).split("~");
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
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			}
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
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
	//Supply To ComboBox
	function combo_spr_prt_spl_tp_cd_Initialize(){
		var formObj=document.form;
		combo_spr_prt_spl_tp_cd.SetSelectCode("-1",false);
		combo_spr_prt_spl_tp_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00037", "COMMON") //Supply To
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
				if(i ==0)
				{
					combo_spr_prt_spl_tp_cd.SetSelectCode("");
				}
			}
		}
		form.combo_spr_prt_spl_tp_cd_text.value = combo_spr_prt_spl_tp_cd.GetText(0, 0);
	}
	//Supply To ComboBox
	function combo_spr_prt_spl_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		var formObj=document.form;
		
		form.combo_spr_prt_spl_tp_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
		formObj.spr_prt_spl_tp_cd.value = comboObj.GetSelectCode();
		
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
			}else{
				comboObj.SetSelectIndex(parseInt(oldIndex), false);
				form.combo_spr_prt_spl_tp_cd_text.value = comboObj.GetText(parseInt(oldIndex), 0);
				return;
			}
		}
		if(newCode=="V")
		{
			ComEnableObject(formObj.vsl_vvd,true);
		}else if(newCode=="Y")
		{
			formObj.vsl_vvd.value="";
			ComEnableObject(formObj.vsl_vvd,false);
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:
			MnrWaitControl(true);
			formObj.f_gubuns.value="";
			formObj.mnr_ord_seq.value="NEW";
			formObj.showDate.value=ComGetNowInfo();
			formObj.cost_ofc_cd.value=currOfcCd;
			formObj.pic_eng_nm.value="";
			formObj.eff_dt.value="";
			formObj.exp_dt.value="";
			formObj.spr_prt_spl_dt.value=ComGetNowInfo()
			formObj.curr_cd.value="";
			formObj.vsl_vvd.value="";
			ComEnableObject(formObj.vsl_vvd,true);
			formObj.vsl_cd.value="";
			formObj.vsl_cd2.value="";
			formObj.spr_prt_spl_yd_cd2.value="";
			formObj.spr_prt_spl_dt2.value="";
			formObj.pic_eng_nm2.value="";
			combo_vndr_seq.SetSelectCode("-1",false);
			combo_vndr_seq.RemoveAll();
			//formObj.combo_spr_prt_spl_tp_cd.Code2="-1";
			combo_spr_prt_spl_tp_cd.SetSelectCode("V",false);
			form.combo_spr_prt_spl_tp_cd_text.value = combo_spr_prt_spl_tp_cd.GetText(0, 0);
			formObj.ord_hdr_rmk.value="";
			combo_vndr_seq_Initialize ();
			combo_eq_knd_cd_Initialize();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Send");
			break;
		case IBINSERT:
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "sheet1_spr_prt_ut_tp_nm","",0);
			sheetObj.SetCellValue(row, "sheet1_cost_cd","MRRUSP",0);
			sheetObj.SelectCell(row, "sheet1_spr_prt_ut_tp_nm",true);
			sheetObj.SetSumText(0,"sheet1_spr_prt_ut_tp_nm","TOTAL");
			calReq=0;
			MnrWaitControl(false);
			break;
		case IBSEARCH:      //Retrieving
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="";
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			var sParam="";
			var aryPrefix=new Array("sheet1_", "sheet2_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0054GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
//				if(i==0 )continue;
				
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i]);
			}
			break;
		case IBSAVE:        //Saving
			if(nowLoad != 0) return;
			MnrWaitControl(true);
			if(!validateForm(sheetObj,formObj,sAction))
			{
				nowLoad=0;
				MnrWaitControl(false);
				return;
			}
			nowLoad=1;
			formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
			formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
			formObj.spr_prt_spl_tp_cd.value=combo_spr_prt_spl_tp_cd.GetSelectCode();
			var strVslVvd=formObj.vsl_vvd.value;  //vsl_vvd
			formObj.vsl_cd.value=strVslVvd.substring(0,4);
			formObj.skd_voy_no.value=strVslVvd.substring(4,8);
			formObj.skd_dir_cd.value=strVslVvd.substring(8);
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet1_");
			var sParam=ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
			var sXml=sheetObj.GetSaveData("EES_MNR_0054GS.do", sParam);
			sXml_1 = sXml;
			sheetObjects[0].LoadSaveData(sXml);
			
			break;
		case IBSEARCHAPPEND:        //Deleting
		if(!validateForm(sheetObj,formObj,sAction))return false;
		if(!ComShowCodeConfirm("MNR00026"))
		{
			return false;
		}
		MnrWaitControl(true);
		formObj.f_cmd.value=REMOVE;
		formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
		formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
		var aryPrefix=new Array("sheet1_");
		var sParam=ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
			return false;
		sParam += "&" + FormQueryString(formObj) + "&"
		+ ComGetPrefixParam(aryPrefix);
		var sXml=sheetObj.GetSaveData("EES_MNR_0054GS.do", sParam);
		sheetObjects[0].LoadSaveData(sXml);
		
		break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			break;
		case COMMAND01:     //W/O Doc Send
			var strMnrOrdSeq=formObj.mnr_ord_seq.value;
			if(strMnrOrdSeq!="" && strMnrOrdSeq!="NEW" )
			{
				ComOpenPopup("EES_MNR_0036.do?wo_no="+strMnrOrdSeq, 900, 600, 'setDocSendParam', '0,1', true);
			}
			break;
		}
	}
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if(nowLoad != 0) return;
		if (sheetObj.ColSaveName(Col) != "sheet1_spr_prt_no") return;
		var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(Row, "sheet1_spr_prt_ut_tp_nm")," ");
		if(strCostDtlCD=="")
		{
			ComShowCodeMessage("MNR00036","Unit Type");
			sheetObj.SelectCell(Row, "sheet1_spr_prt_ut_tp_nm",	true);
			return;
		}
		ComOpenPopup("EES_MNR_0214.do", 700, 400, 'setPopUpParam_EES_MNR_0214', '0,0', true);
	}
	function sheet1_OnChange(sheetObj,Row, Col, Value)
	{
		if(nowLoad == 0)
		{
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");
			if(sheetObj.ColSaveName(Col) == "sheet1_rpr_qty")
			{
				sheet1_rpr_qty_OnChange(sheetObj,Row, Col, Value);
			}else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_uc_amt")
			{
				sheet1_spr_prt_uc_amt_OnChange(sheetObj,Row, Col, Value);
			}else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_no")
			{
				sheet1_spr_prt_no_OnChange(sheetObj,Row, Col, Value);
			}
		}
		if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_ut_tp_nm")
		{
			if(Value=="HC"){
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_no",0);
				sheetObj.SetCellEditable(Row,"sheet1_mnr_expn_dtl_nm",1);
				sheetObj.SelectCell(Row, "sheet1_mnr_expn_dtl_nm",true);
				sheetObj.SetCellValue(Row,"sheet1_spr_prt_no","",0);
				sheetObj.SetCellValue(Row,"sheet1_spr_prt_nm","",0);
			}else{
				sheetObj.SetCellEditable(Row,"sheet1_spr_prt_no",1);
				sheetObj.SetCellEditable(Row,"sheet1_mnr_expn_dtl_nm",0);
				sheetObj.SetCellValue(Row,"sheet1_mnr_expn_dtl_nm","",0);
			}
		}
	}
	function sheet1_rpr_qty_OnChange(sheetObj,Row, Col, Value){
		var bzcAmt=nvl(sheetObjects[0].GetCellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty=nvl(sheetObjects[0].GetCellValue(Row, "sheet1_rpr_qty"));
		sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",parseFloat(bzcAmt) * parseFloat(qty));
	}
	function sheet1_spr_prt_uc_amt_OnChange(sheetObj,Row, Col, Value){
		var bzcAmt=nvl(sheetObjects[0].GetCellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty=nvl(sheetObjects[0].GetCellValue(Row, "sheet1_rpr_qty"));
		sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",parseFloat(bzcAmt) * parseFloat(qty));
	}
	function sheet1_spr_prt_no_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad !=0)return;
		nowLoad=1;
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH;
		formObj.spr_prt_no.value=sheetObj.GetCellValue(Row,"sheet1_spr_prt_no");
		if(formObj.spr_prt_no.value=="")return;
		var sParam="";
		var aryPrefix=new Array("sheet4_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		var sXml=sheetObjects[1].GetSearchData("EES_MNR_0137GS.do", sParam);
		arrDataSearchDbXml=sXml.split("|$$|");
		var retArr=MnrXmlToArray(sXml);
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			var Slength=arrDataSearchDbXml[i].indexOf("TOTAL='");
			var intSize=arrDataSearchDbXml[i].substring(Slength + 7,Slength + 8);
		}
		formObj.f_cmd.value="";
		if(intSize<=0)
		{
			ComShowCodeMessage("MNR00165",formObj.spr_prt_no.value,"Part No.");
			sheetObj.SetCellValue(Row,"sheet1_spr_prt_no","");
			nowLoad=0;
			sheetObj.SelectCell(Row,"sheet1_spr_prt_no",true);
		}else{
			sheetObj.SetCellFont("FontBold", Row, "sheet1_spr_prt_ut_tp_nm",0);
			sheetObj.SetCellFont("FontBold", Row, "sheet1_spr_prt_no",0);
			sheetObj.SetCellFont("FontBold", Row - 1, "sheet1_spr_prt_ut_tp_nm",0);
			sheetObj.SetCellFont("FontBold", Row - 1, "sheet1_spr_prt_no",0);
			sheetObj.SetCellFont("FontBold", Row + 1, "sheet1_spr_prt_ut_tp_nm",0);
			sheetObj.SetCellFont("FontBold", Row + 1, "sheet1_spr_prt_no",0);
			sheetObj.SetCellValue(Row,"sheet1_spr_prt_nm",retArr[0][4]);
			nowLoad=0;
			sheetObj.SelectCell(Row,"sheet1_rpr_qty",true);
		}
	}
	function sheet1_spr_prt_ut_tp_nm_Initialize(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd","CD00009", "COMMON") //SHEET UNIT Type
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
	function sheet1_spr_prt_ut_tp_nm_AND_spr_prt_no_UniqueCheck()
	{
		var sSprPrtUtTpNm="";
		var sSprPrtNo="";
		var chkOk=false;
		sheetObj=sheetObjects[0];
		sheetObj.ColumnSort("sheet1_spr_prt_ut_tp_nm|sheet1_spr_prt_no", "ASC");
		for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
		{
			if(sheetObj.GetRowStatus(i)=="D") continue;
			var checkEqNo=sheetObj.GetCellValue(i, "sheet1_spr_prt_no");
			if(checkEqNo=="") continue;
			sheetObj.SetCellFont("FontBold", i, "sheet1_spr_prt_no",0);
			if(chkOk==false)
			{
				sSprPrtUtTpNm=sheetObj.GetCellValue(i, "sheet1_spr_prt_ut_tp_nm");
				sSprPrtNo=sheetObj.GetCellValue(i, "sheet1_spr_prt_no");
				chkOk=true;
				continue;
			}else{
				if(sSprPrtUtTpNm ==sheetObj.GetCellValue(i, "sheet1_spr_prt_ut_tp_nm")
						&& sSprPrtNo ==sheetObj.GetCellValue(i, "sheet1_spr_prt_no")
				)
				{
					var sSeq=sheetObj.GetCellValue(i, "Seq");
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq)- 1, "sheet1_spr_prt_ut_tp_nm",1);
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq)- 1, "sheet1_spr_prt_no",1);
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_ut_tp_nm",1);
					sheetObj.SetCellFont("FontBold", sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_no",1);
					ComShowCodeMessage("MNR00006","Unit Type and Part No");
					sheetObj.SelectCell(sheetObj.FindText("Seq",sSeq), "sheet1_spr_prt_no",true);
					return false;
				}else
				{
					sSprPrtUtTpNm=sheetObj.GetCellValue(i, "sheet1_spr_prt_ut_tp_nm");
					sSprPrtNo=sheetObj.GetCellValue(i, "sheet1_spr_prt_no");
				}
			}
		}
		sheetObj.ColumnSort("Seq", "ASC"); //Initializing sort
		return true;
	}
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "" || errMsg == undefined) {
				if(strMnrOrdSeq=="" || strMnrOrdSeq=="NEW" )
				{
					ComShowCodeMessage("MNR00073");
				}else{
					ComShowCodeMessage("MNR00222");
				}
				
				var f_gubuns=formObj.f_gubuns.value;
				if(MnrComGetErrMsg(sXml_1) == null && f_gubuns==""){
					var mnrOrdSeq=ComGetEtcData(sXml_1, "mnr_ord_seq");
					formObj.mnr_ord_seq.value=mnrOrdSeq;
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}else{
					formObj.f_gubuns.value="";
				}
				
			} else {
				ComShowCodeMessage("MNR00074",ErrMsg);
			}
		}else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "" || errMsg == undefined) {
				ComShowCodeMessage("MNR00082");
				doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
			} else {
				ComShowCodeMessage("MNR00027",ErrMsg);
			}
		}
		
		nowLoad=0;
		MnrWaitControl(false);
	}
	function sheet1_OnSearchEnd(sheetObj, errMsg)
	{
		if(sheetObj.RowCount()>0){
	    	for(i=sheetObj.LastRow()- 1; i > 0 ; i--){
	    		if(sheetObj.GetCellValue(i,"sheet1_spr_prt_ut_tp_nm") == "HC"){
					sheetObj.SetCellEditable(i,"sheet1_spr_prt_no",0);
					sheetObj.SetCellEditable(i,"sheet1_mnr_expn_dtl_nm",1);
					sheetObj.SetCellValue(i,"sheet1_spr_prt_no","",0);
					sheetObj.SetCellValue(i,"sheet1_spr_prt_nm","",0);
				}else{
					sheetObj.SetCellEditable(i,"sheet1_spr_prt_no",1);
					sheetObj.SetCellEditable(i,"sheet1_mnr_expn_dtl_nm",0);
					sheetObj.SetCellValue(i,"sheet1_mnr_expn_dtl_nm","",0);
				}
			}
	    	
	    	sheetObj.SetSumText(0,"sheet1_spr_prt_ut_tp_nm","TOTAL");
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

		var agree_no=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ofc_cty_cd")
		+ ComLpad(sheetObjects[1].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
		
		combo_vndr_seq.SetSelectText(agree_no);
//		combo_vndr_seq.SetSelectIndex(1);
		combo_spr_prt_spl_tp_cd.SetSelectCode(sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_tp_cd"));
				OrgVndrSeq=combo_vndr_seq.GetSelectCode();
//				formObj.pic_eng_nm.value=combo_vndr_seq.GetText(combo_vndr_seq.GetSelectIndex(), 0 );
		combo_eq_knd_cd.SetSelectCode(sheetObjects[1].GetCellValue(1, prefix+ "eq_knd_cd"),false);
		formObj.curr_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[1].GetCellValue(1, prefix+ "agmt_ver_no");
		formObj.showDate.value=sheetObjects[1].GetCellValue(1, prefix+ "cre_dt");
		formObj.ord_hdr_rmk.value=sheetObjects[1].GetCellValue(1, prefix+ "ord_hdr_rmk");
		formObj.vsl_cd.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd");
		formObj.vsl_cd2.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd");
		formObj.spr_prt_spl_yd_cd2.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_yd_cd");
		formObj.spr_prt_spl_dt.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_dt");
		formObj.spr_prt_spl_dt2.value=sheetObjects[1].GetCellValue(1, prefix+ "spr_prt_spl_dt");
		formObj.vsl_vvd.value=sheetObjects[1].GetCellValue(1, prefix+ "vsl_cd")
		+sheetObjects[1].GetCellValue(1, prefix+ "skd_voy_no")
		+sheetObjects[1].GetCellValue(1, prefix+ "skd_dir_cd");
		formObj.pic_eng_nm2.value=formObj.pic_eng_nm.value;
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
		
		nowLoad=0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
	}
	/**
	* Assigning array of IBTab object
	* Array defined at the top of the source
	*/
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	* Tab Setting default
	* Setting tab's item
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
	* Event handling of changing tab
	* Activating tab for selected
	*/
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- Important logic --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	/**
	* Validating process for input form data
	*/
	function validateForm(sheetObj,formObj,sAction){
		
		var combovndrseq = combo_vndr_seq;
		var combosprprtspltp_cd = combo_spr_prt_spl_tp_cd;
		
		with(formObj){
			if(sAction==IBINSERT)
			{
				if(combovndrseq.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");
					ComSetFocus(combovndrseq);
					return false;
				}
				if(combosprprtspltp_cd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Supply To");
					ComSetFocus(combosprprtspltp_cd);
					return false;
				}
				var strVslVvd=formObj.vsl_vvd.value;  //vsl_vvd
				if(combosprprtspltp_cd.GetSelectCode()== "V" && (strVslVvd.length <9)){
					ComShowCodeMessage("MNR00172","VVD Code");
					ComSetFocus(formObj.vsl_vvd);
					return false;
				}
				var strSprPrtSplDt=formObj.spr_prt_spl_dt.value
				if(strSprPrtSplDt < 8 ){
					ComShowCodeMessage("MNR00036","Supply Date");
					ComSetFocus(formObj.spr_prt_spl_dt);
					return false;
				}
				else
				{
					if(sheetObj.GetCellValue(1, "Seq")=="0" )
					{
						sheetObj.RemoveAll();
					}else
					{
						if(sheetObj.LastRow()==1) return true;
						var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(sheetObj.LastRow()- 1, "sheet1_spr_prt_ut_tp_nm")," ");
						if(strCostDtlCD=="")
						{
							ComShowCodeMessage("MNR00036","Unit Type");
							sheetObj.SelectCell(sheetObj.LastRow()- 1, "sheet1_spr_prt_ut_tp_nm",true);
							return false;
						}
						var strUnitType=sheetObj.GetCellValue(sheetObj.LastRow()- 1, "sheet1_spr_prt_ut_tp_nm")
						var strEqNo=ComTrimAll(sheetObj.GetCellValue(sheetObj.LastRow()- 1, "sheet1_spr_prt_no")," ");
						if(strEqNo=="" && strUnitType!="HC")
						{
							ComShowCodeMessage("MNR00172","Part No");
							sheetObj.SelectCell(sheetObj.LastRow()- 1, "sheet1_spr_prt_no",true);
							return false;
						}
					}
				}
			}
			//At retrieving
			else if(sAction==IBSEARCH)
			{
				var sRow=sheetObj.FindStatusRow("I|U|D");
				if(sRow != "")
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
			else if(sAction==IBSAVE) {
				if(combovndrseq.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Agreement No");
					ComSetFocus(combovndrseq);
					return false;
				}
				if(combosprprtspltp_cd.GetSelectIndex()== "-1"){
					ComShowCodeMessage("MNR00036","Supply To");
					ComSetFocus(combosprprtspltp_cd);
					return false;
				}
				var strSprPrtSplDt=formObj.spr_prt_spl_dt.value
				if(strSprPrtSplDt < 8 ){
					ComShowCodeMessage("MNR00036","Supply Date");
					ComSetFocus(formObj.spr_prt_spl_dt);
					return false;
				}
				var rCnt=sheetObj.RowCount();
				if(rCnt<=0)
				{
					ComShowCodeMessage("MNR00072");
					return false;
				}
				var strVslVvd=formObj.vsl_vvd.value;  //vsl_vvd
				if(combosprprtspltp_cd.GetSelectCode()== "V" && (strVslVvd.length <9 )){
					ComShowCodeMessage("MNR00172","VVD Code");
					ComSetFocus(formObj.vsl_vvd);
					return false;
				}
				for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow()- 1;i++)
				{
					var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_prt_ut_tp_nm")," ");
					if(strCostDtlCD=="")
					{
						ComShowCodeMessage("MNR00036","Unit Type");
						sheetObj.SelectCell(i, "sheet1_spr_prt_ut_tp_nm",true);
						return false;
					}
					var strUnitType=sheetObj.GetCellValue(i, "sheet1_spr_prt_ut_tp_nm")
					var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_prt_no")," ");
					if(strEqNo=="" && strUnitType!="HC")
					{
						ComShowCodeMessage("MNR00172","Part No");
						sheetObj.SelectCell(i, "sheet1_spr_prt_no",true);
						return false;
					}
					var strCostAmt=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_cost_amt")," ");
					if(strCostAmt=="0")
					{
						ComShowCodeMessage("MNR00175","Amount");
						sheetObj.SelectCell(i, "sheet1_spr_prt_uc_amt",true);
						return false;
					}
				}
				if(!sheet1_spr_prt_ut_tp_nm_AND_spr_prt_no_UniqueCheck())
				{
					return false;
				}
			}
			//Deleting
			else if (sAction==IBSEARCHAPPEND) {
				var rCnt=sheetObjects[0].RowCount();
				if(rCnt<=0)
				{
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
			//In case of Copying
			else if (sAction=="COPY") {
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
			}
			else if (sAction==IBDELETE) {
				if(sheetObj.FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
			}
			else if (sAction==IBCOPYROW) {
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
			}
			//Load Excel
			else if (sAction==IBLOADEXCEL) {
				//Checking tariff status value
				if(!checkTariffStatus()) {return false;}
			}
		}
		return true;
	}
	function nvl(str){
		if(str == null) return '0';
		else return str;
	}
