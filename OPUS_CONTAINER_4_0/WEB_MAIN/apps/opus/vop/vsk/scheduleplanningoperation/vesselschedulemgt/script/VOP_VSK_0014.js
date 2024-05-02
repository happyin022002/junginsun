/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0014.js
*@FileTitle  : Coastal SKD Creation by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class vop_vsk_0014 : business script for VOP_VSK_0014
	 */
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var portDataFlgs=new Array();		//Port change status in sheet
	var glbEditColor=null;
	var glbDisableColor=null;
	var glbFixColor=null;
	var glbBookingChk="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
	         if (!ComIsBtnEnable(srcName)) return;  
			if(ComGetEvent().className.indexOf('_1') > 0){
				return;
			}
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_pfsked":
					doActionIBSheet(sheetObject,formObject,COMMAND01);
					break;
				case "btn_add":
					doActionIBSheet(sheetObject,formObject,COMMAND02);
					break;
				case "btn_insert":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_del":
					doActionIBSheet(sheetObject,formObject,IBDELETE);
					break;
				case "btn_vvd_search":
					doActionIBSheet(sheetObject,formObject,COMMAND03);
					break;
				case "btn_vsl_slan_cd":
					doActionIBSheet(sheetObject,formObject,COMMAND04);
					break;
//				case "btn_main_title":
//					doActionIBSheet(sheetObject,formObject,COMMAND33);
//					break;
//	                case "btn_CheckAll":
//	                	sheetObject.CheckAll2("del_chk") = 1;
//	                    break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
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
	 * registering IBCombo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj=document.form;
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initLoadDirection(sheetObjects[0]);
		initControl();
		initButton(document.form);
		glbEditColor="#80FFFF";
		glbDisableColor="#EFEFEF";
		glbFixColor="#FFFFFF";
		sheetObjects[0].DataInsert(0);
		resetClptSeq(sheetObjects[0]);
		formObj.vsl_cd.focus();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){
//				      (84, 0, 0, true);
				      var HeadTitle1="|Sel|Seq.|Port Code|TMNL Code|ETA|ETB|ETD|T/Port IND|Consortium Voyage|Consortium Voyage|Consortium Voyage|Consortium Voyage|Change Status|Turning Port Information|Turning Port Information|Turning Port Information|";
				      var HeadTitle2="|Sel|Seq.|Port Code|TMNL Code|ETA|ETB|ETD|T/Port IND|Arr Ext Voy Ref|Dep Ext Voy Ref|T-Arr Ext Voy Ref|Init|Change Status|Voyage No.|Direction|Call Indicator|";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                  { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
				             {Type:"Text",      Hidden:0,  Width:150,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
				             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
				             
				               //:2016-04-13:by TOP://
				               {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				               {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				               {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cssm_voy_init_cre_flg" },				               
				               //:2016-04-13:by TOP://
				             
				             {Type:"Text",     Hidden:0, Width:120,   Align:"Center",   ColMerge:1,   SaveName:prefix+"skd_cng_sts_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Combo",     Hidden:0, Width:110,   Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"turn_clpt_ind_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_usd_ind_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_skd_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"st_port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"n1st_port_brth_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"psdo_vvd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"co_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skd_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"call_yd_ind_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etb_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_etd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"init_eta_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"init_etb_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"init_etd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no_upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"shp_call_no_upd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_voy_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ft_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"plism_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cgo_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cgo_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"phs_io_rsn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"phs_io_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_brth_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"init_skd_inp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ofc_inp_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"noon_rpt_inp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rpt_inp_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"act_inp_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"prt_chk_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"edi_snd_knt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_rsn_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_skp_rsn_offr_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ttl_dlay_hrs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"usd_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_rotn_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"dir_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"new_clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"lnk_spd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"sea_buf_hrs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_buf_hrs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"tztm_hrs",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"act_wrk_hrs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"lnk_dist",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"time_diff",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             
				             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"auto_skd_cng_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"skp_call_flg" 	},
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"add_call_flg" 	},
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_renm_old_vsl_cd" 	 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_renm_old_vsl_eng_nm" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_renm_new_vsl_cd" 	 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_renm_new_vsl_eng_nm" },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsld_wks" },
				             
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vt_add_call_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
				             ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetColProperty(0,prefix+"turn_port_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
				      SetColProperty(0,prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"pf_eta_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"pf_etb_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"pf_etd_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"init_eta_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"init_etb_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"init_etd_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(0,prefix+"turn_skd_voy_no", {AcceptKeys:"N"});
				      SetColProperty(0,prefix+"vps_port_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
				      SetSelectionMode(smSelectionFree);
				      resizeSheet();
		      }
			   break;
		}
	}
	/**
   	 * setting combo initial values and header 
   	 * param : comboObj, comboNo
   	 * adding case as numbers of counting combos 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {
	    	case "pf_svc_tp_cd":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "40");
  					SetDropHeight(160);
   		    	}
   	    		break;
   	     }
   	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var prefix=sheetObj.id + "_";
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;
			case SEARCH01:		//Terminal(Yard) List
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH02:		//pf_svc_tp_cd
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH03:		//Create SKD
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH03;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH04:		//initLoadDirection
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH04;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH05:		//Lane Code/Direction Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH05;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH10:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
					return sXml;
				}
				break;
			case IBSAVE:        //Save
				if(validateForm(sheetObj,formObj,sAction)){
					var sParam=ComGetSaveString(sheetObjects, false);
					if (sParam == ""){
						return;
					} else {
						formObj.f_cmd.value=MULTI;
						sParam=sParam + "&" + FormQueryString(formObj);
					}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
 					var sXml=sheetObj.GetSaveData("VOP_VSK_0014GS.do", sParam);
					ComOpenWait(false);
 					sheetObj.LoadSaveData(sXml);
					var nodeText=ComGetSelectSingleNode(sXml, "TR-ALL");
					if(nodeText == "OK"){
						doActionSearch(sheetObj, formObj, SEARCH);
					}
				}
				break;
			case IBCLEAR:      			// New
				clearAllData(sheetObj, formObj);
				break;
			case COMMAND01:		// P/F SKED Use
				if(validateForm(sheetObj, formObj, COMMAND01)){
					var urlTail="vsl_slan_cd="+formObj.vsl_slan_cd.value;
					urlTail=urlTail + "&skd_dir_cd="+formObj.skd_dir_cd.value;
					urlTail=urlTail + "&pf_svc_tp_cd="+getComboObject("pf_svc_tp_cd").GetSelectCode();
					var sUrl="/opuscntr/VOP_VSK_0220.do?" + urlTail;
                	ComOpenPopup(sUrl, 600, 470, "getPfSkdData", "0,0", true);
				}
				break;
			case COMMAND02:		// Row Add
				var rowIdx=sheetObj.LastRow();
				var curRow = sheetObj.DataInsert(-1);
				resetClptSeq(sheetObj);
				setBaseRowData(sheetObj, formObj, curRow);
				initPortDataFlg(sheetObj);	// Terminal reRetrieve Flag Initializing.
				sheetObj.SelectCell(curRow, prefix+"vps_port_cd", false);
				break;
			case IBINSERT:      		// Row Insert
				var rowIdx=sheetObj.GetSelectRow()+ sheetObj.HeaderRows()- 1;
				if(rowIdx){
					if(rowIdx > sheetObj.HeaderRows()){
						var curRow = sheetObj.DataInsert();
						resetClptSeq(sheetObj);
						setBaseRowData(sheetObj, formObj, curRow);
						initPortDataFlg(sheetObj);	// Terminal reRetrieve Flag Initializing.
						sheetObj.SelectCell(curRow, prefix+"vps_port_cd", false);
					}
				}
				break;
			case IBDELETE:      		// Row Delete
				var rowIdx=sheetObj.GetSelectRow()+ sheetObj.HeaderRows()- 1;
				if(rowIdx){
					if(rowIdx > sheetObj.HeaderRows()){
						ComRowHideDelete(sheetObj, prefix+"del_chk");
						resetClptSeq(sheetObj);
						resetClptIndSeq(sheetObj);	//clpt_ind_seq reset
						initPortDataFlg(sheetObj);	// Terminal reRetrieve Flag Initializing.
					}
				}
				break;
			case COMMAND03:      			// VVD Pop-up
				var vslCd=document.form.vsl_cd.value;
            	var sUrl="";
            	if(vslCd == ""){
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "getVslCdData", "0,0", true);
            	}else{
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 440, 420, "getVvdData", "0,0", true);
            	}
				break;
			case COMMAND04:      			// Slan Code Pop-up
				var sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
            	ComOpenPopup(sUrl, 500, 470, "getLaneCodeData", "0,0", true);
				/*if(validateForm(sheetObj, formObj, COMMAND04)){
	            	var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
	            	if(sXml != null){
	            		var rootNode=VskGetXmlRootNode(sXml);
	        			var dataNode="";
	        			if(dataNode){
	        				var nodeText=dataNode;
	        				if(nodeText != ""){
	        					sheetObj.LoadSearchData(sXml,{Sync:1} );
	        					getComboObject("pf_svc_tp_cd").RemoveAll();
	        				}
	        			}else{
	        				setPfSvcTpCdCombo(sXml);
	        			}
	            	}
            	}*/
				break;
			case COMMAND23:        	// PORT TIME CHECK
				formObj.f_cmd.value = COMMAND23;				
				var sParam = FormQueryString(formObj);
				var sXml   = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				
				return sXml;
				break;
//			case COMMAND33:      			// Test
//				if(validateForm(sheetObj,formObj,sAction)){
//					formObj.f_cmd.value = SEARCH33;
//					var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
//					var sXml = sheetObj.GetSearchXml("VOP_VSK_0014GS.do", sParam);
//					
//					alert(sXml);
//				}
//
//				break;
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=sheetObj.LastRow();
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(ComIsNull(formObj.vsl_cd.value)){
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if(ComIsNull(formObj.skd_voy_no.value)){
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				} else if(ComIsNull(formObj.skd_dir_cd.value)){
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				} else if (formObj.vsl_cd.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (formObj.skd_voy_no.value.length < 4) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				}
				break;
			case COMMAND01:      	//Popup(p/f create)
				if(ComIsNull(formObj.vsl_slan_cd.value)){
					ComShowCodeMessage('VSK00027', "Lane Code");
					formObj.vsl_slan_cd.focus();
					return false;
				} else if (ComIsNull(formObj.vsl_cd.value)) {
					ComShowCodeMessage('VSK00027', "Vessel Code");
					formObj.vsl_cd.focus();
					return false;
				} else if (ComIsNull(formObj.skd_voy_no.value)) {
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.focus();
					return false;
				}else if(formObj.skd_voy_no.value == "0000"){
					ComShowCodeMessage('VSK00027', "Voyage No.");
					formObj.skd_voy_no.value="";
					formObj.skd_voy_no.focus();
					return false;
				} else if (ComIsNull(formObj.skd_dir_cd.value)) {
					ComShowCodeMessage('VSK00027', "Direction Code");
					formObj.skd_dir_cd.focus();
					return false;
				}
				break;
			case COMMAND04:
			case COMMAND05:      	//vsl_slan_cd onChange Event
				if(!ComIsNull(formObj.vsl_slan_cd.value)){
					if(formObj.vsl_slan_cd.value.length < 3){
						ComShowCodeMessage("VSK01018", "[Lane Code]");
						getComboObject("pf_svc_tp_cd").RemoveAll();
						formObj.vsl_slan_cd.value="";
						return false;
					}
				} else {
					getComboObject("pf_svc_tp_cd").RemoveAll();
					return false;
				}
				break;
			case COMMAND02:      //Row Add
				var turnPortIndCd=sheetObj.GetCellValue(totCnt-1, prefix+"turn_port_ind_cd");
				if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
					return false;
				}
				break;
			case IBSAVE:      //save
				if(formObj.vsl_cd.value.length < 4){
					ComShowCodeMessage("VSK01018", "[Vessel Code]");
					formObj.vsl_cd.value="";
					formObj.vsl_cd.focus();
					return false;
				}
				if(formObj.skd_voy_no.value.length < 4){
					ComShowCodeMessage("VSK01018", "[Voyage Number]");
					formObj.skd_voy_no.value="";
					formObj.skd_voy_no.focus();
					return false;
				}else if(formObj.skd_voy_no.value == "0000"){
					ComShowCodeMessage("VSK00101");
					formObj.skd_voy_no.value="";
					formObj.skd_voy_no.focus();
					return false;
				}
				if(formObj.skd_dir_cd.value.length < 1){
					ComShowCodeMessage("VSK01018", "[Direction Code]");
					formObj.skd_dir_cd.value="";
					formObj.vsl_slan_dir_cd.value="";
					formObj.skd_dir_cd.focus();
					return false;
				}
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "[Lane Code]");
					formObj.vsl_slan_cd.value="";
					formObj.vsl_slan_cd.focus();
					return false;
				}
                //By Hwang Remark Check...
                if (formObj.skd_rmk.value.length > 4000){
 		    		 ComShowCodeMessage("VSK01019", "[Remark(s)]");
                      formObj.skd_rmk.focus();
                      return false ;
               }
				if(formObj.vsl_svc_tp_cd.value != "O"){
					var comboObj=getComboObject("pf_svc_tp_cd");
					if(ComIsNull(comboObj.GetSelectCode())){
						//VSK02005
						ComShowCodeMessage("VSK01018", "[Proforma Type Code]");
						comboObj.focus();
						return false;
					}
				}
				if(glbBookingChk == "X"){
					ComShowCodeMessage("VSK00093");
					return false;
				}
				if(glbBookingChk == "A"){
					ComShowCodeMessage("VSK00006");
					return false;
				}
//				if(1 < rowCnt){
//					//VSK02006
//					ComShowCodeMessage('VSK00027', "Direction Code");
//					return false;
//				}
				if(totCnt > headCnt){
					var turnVoyNo="";
					var turnDirCd="";
//					var turnSeq = "";
					var chkTurnVoyNo="";
					var chkTurnDirCd="";
					
					for(var i=headCnt; i<=totCnt; i++){
						//except deleted Row
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
						if(sheetObj.GetRowStatus(i) != "D" && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
							if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
								if(sheetObj.GetCellValue(i, prefix+"tml_cd") == ""){
									ComShowCodeMessage("VSK00027", "Terminal Code");
									sheetObj.SelectCell(i, prefix+"tml_cd");
									return false;
								}
							}
							//in case Turn Indicator is Y, mandatory input
							if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
								if(ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no"))){
									ComShowCodeMessage("VSK00033", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
									return false;
								} else if(ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd"))) {
									ComShowCodeMessage("VSK00033", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"turn_skd_dir_cd");
									return false;
								}
								//in case Turn Indicator is Y, Checking Turn VVD is same
								turnVoyNo=sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no");
								turnDirCd=sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd");
	//							turnSeq = sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq");
								if(chkTurnVoyNo == ""){
									chkTurnVoyNo=turnVoyNo;
									chkTurnDirCd=turnDirCd;
								}else{
									if(turnVoyNo != chkTurnVoyNo){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
										return false;
									}else if(turnDirCd != chkTurnDirCd){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_skd_dir_cd");
										return false;
									}
								}
							}
//							else{
//								if(ComTrim(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd")) == ""){
//									sheetObj.CellValue2(i, prefix+"turn_skd_dir_cd") = ComTrim(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"));
//								}
//								if(ComTrim(sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq")) == ""){
//									sheetObj.CellValue2(i, prefix+"turn_clpt_ind_seq") = ComTrim(sheetObj.CellValue(i, prefix+"turn_clpt_ind_seq"));
//								}
//							}
							//Checking ETA date format
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//Checking ETB date format
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//Checking ETD date format
							if(isDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							//ETA < ETB < ETD < Next ETA
							if(sheetObj.GetRowStatus(i) != "D" && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
								if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") < sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
									if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") < sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
										if(i<totCnt){
											for(var k=i+1; k<=totCnt; k++){
	//											if(sheetObj.CellValue(k, prefix+"ibflag") != "D" && sheetObj.CellValue(k, prefix+"skd_cng_sts_cd") != "S"){
												//::FOR.NYK.START::by dongsoo:2014-09-29:://
												var curTimeDiff = sheetObj.GetCellValue(i, prefix+"time_diff");
												var nxtTimeDiff = sheetObj.GetCellValue(k, prefix+"time_diff");
												
												if(sheetObj.GetRowStatus(k) != "D" && sheetObj.GetCellValue(k, prefix+"skd_cng_sts_cd") != "S"){
													if (sheetObj.GetCellValue(i, prefix+"vps_port_cd") != "WSAPW" ||
														sheetObj.GetCellValue(k, prefix+"vps_port_cd") != "ASPPG") {
														if(sheetObj.GetCellValue(i, prefix+"vps_etd_dt") < sheetObj.GetCellValue(k, prefix+"vps_eta_dt")){
															//pass
														}else{
															ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
															sheetObj.SelectCell(i, prefix+"vps_etd_dt");
															return false;
														}
													} else {
														var vpsEtdObj = new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etd_dt"));
														var vpsEtaObj = new Usr_CalcTimeSet(sheetObj.GetCellValue(k, prefix+"vps_eta_dt"));
														
														var etaDate = vpsEtaObj.getAddDate();
														var etdDate = vpsEtdObj.getAddDate();
														
														formObj.vps_port_cd.value = sheetObj.GetCellValue(k, prefix+"vps_port_cd");
														formObj.act_arr_dt.value  = etaDate;
														formObj.pre_port_cd.value = sheetObj.GetCellValue(i, prefix+"vps_port_cd");
														formObj.pre_etd_dt.value  = etdDate;
														if(!isPortTimeCheck(sheetObj, formObj)) {
															ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
															sheetObj.SelectCell(i, prefix+"vps_etd_dt");
															return false;
														}
													}
													//::FOR.NYK.FINISH::by dongso:2014-09-29:://
													break;
												}
											}//end for
										}
									} else {
										ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"vps_etb_dt");
										return false;
									}
								} else {
									ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
									sheetObj.SelectCell(i, prefix+"vps_eta_dt");
									return false;
								}
							}
							//Port Code Check...
							if(sheetObj.GetCellValue(i, prefix+"vps_port_cd").length < 5){
								ComShowCodeMessage("VSK01018", "[Port Code]");
								sheetObj.SelectCell(i, prefix+"vps_port_cd");
								return false;
							}
							//Terminal Code Check...
							if(!ComIsNull(sheetObj.GetCellValue(i, prefix+"tml_cd"))){
								if(sheetObj.GetCellValue(i, prefix+"tml_cd").length < 2){
									ComShowCodeMessage("VSK01018", "[Yard Code]");
									sheetObj.SelectCell(i, prefix+"tml_cd");
									return false;
								}
							}
							//Checking Turn Port is not own VVD
							if(sheetObj.GetCellValue(i, prefix+"vsl_cd") == ""){
								sheetObj.SetCellValue(i, prefix+"vsl_cd",formObj.vsl_cd.value);
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_voy_no") == ""){
								sheetObj.SetCellValue(i, prefix+"skd_voy_no",formObj.skd_voy_no.value);
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_dir_cd") == ""){
								sheetObj.SetCellValue(i, prefix+"skd_dir_cd",formObj.skd_dir_cd.value);
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_voy_no") == sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no")
									&& sheetObj.GetCellValue(i, prefix+"skd_dir_cd") == sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd")){
								ComShowCodeMessage("VSK00052");
								sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
								return false;
							}
						}
						
					}//End for
					
					////////////////////////////////////////////////////////////////////////////////////////////////
					//:2016-08-18:For Checking the ETD of Last Port except Virtual Add Calling is reversed or not://
					var idx,idx2	= 0;
					
					for(var inx=totCnt; inx>=headCnt; inx--){
						//alert('inx = ['+inx+'] sheetObj.GetRowHidden(inx) ['+sheetObj.GetRowHidden(inx)+'] row status ['+sheetObj.GetRowStatus(inx)+']');
						if(sheetObj.GetCellValue(inx, prefix+"vt_add_call_flg") != "Y" && !sheetObj.GetRowHidden(inx) && sheetObj.GetRowStatus(inx) != "I"){
							idx	= inx;
							break;
						}
					}
					
					for(var inx=totCnt; inx>=headCnt; inx--){
						//alert('inx = ['+inx+'] sheetObj.GetRowHidden(inx) ['+sheetObj.GetRowHidden(inx)+']');
						if(sheetObj.GetCellValue(inx, prefix+"vt_add_call_flg") != "Y" && !sheetObj.GetRowHidden(inx)){
							idx2	= inx;
							break;
						}
					}
					
					//alert('idx = ['+idx+'] idx2 = ['+idx2+'] totCnt ['+totCnt+'] headCnt ['+headCnt+'] port is ['+sheetObj.GetCellValue(idx, prefix+"vps_port_cd")+']');
					
					var vslCd 		= sheetObj.GetCellValue(idx, prefix+"vsl_cd");
					var skdVoyNo 	= sheetObj.GetCellValue(idx, prefix+"skd_voy_no");
					var skdDirCd 	= sheetObj.GetCellValue(idx, prefix+"skd_dir_cd");
					var vpsPortCd	= sheetObj.GetCellValue(idx, prefix+"vps_port_cd");
					var clptIndSeq	= sheetObj.GetCellValue(idx, prefix+"clpt_ind_seq");
					
					var vpsEtdDt 	= sheetObj.GetCellValue(idx2, prefix+"vps_etd_dt");
					
					var sParam		= "f_cmd=" + SEARCH14 + "&vsl_cd=" + vslCd + "&skd_voy_no=" + skdVoyNo + "&skd_dir_cd=" + skdDirCd + "&vps_port_cd=" + vpsPortCd+ "&clpt_ind_seq=" + clptIndSeq + "&vps_etd_dt="+ vpsEtdDt; 
					var sXml		= sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					var isReverse	= ComGetEtcData(sXml, "IS_REVERSE_VPS");
					
					//alert('isReverse <<<'+isReverse+'>>>');
					
					if(isReverse == "Y"){
						ComShowCodeMessage("VSK55010", formatDate(new Date(getDateFromFormat(vpsEtdDt, "yyyyMMddHHmm")), "yyyy-MM-dd HH:mm"));
						return false;
					}
					////////////////////////////////////////////////////////////////////////////////////////////////
					
					var tPortRow = ""; 
					for(var i=headCnt; i<=totCnt; i++){
						if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
							tPortRow = i;
							break;
						}	
					}
					if(tPortRow != ""){
						var vslCd = formObj.vsl_cd.value;
						var skdVoyNo = formObj.skd_voy_no.value;
						var skdDirCd = formObj.skd_dir_cd.value;
						var turnSkdVoyNo = sheetObj.GetCellValue(tPortRow, prefix+"turn_skd_voy_no");
						var turnSkdDirCd = sheetObj.GetCellValue(tPortRow, prefix+"turn_skd_dir_cd");
						var vpsEtaDt = sheetObj.GetCellValue(tPortRow, prefix+"vps_eta_dt");
						
						var sParam= "f_cmd=" + SEARCH13 + "&vsl_cd=" + vslCd + "&skd_voy_no=" + skdVoyNo + "&skd_dir_cd=" + skdDirCd + "&turn_skd_voy_no=" + turnSkdVoyNo+ "&turn_skd_dir_cd=" + turnSkdDirCd + "&vps_eta_dt=" + vpsEtaDt; 
						var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
	 					var etdChk=ComGetEtcData(sXml, "etd_chk");
	 					
	 					if(etdChk == "N"){
	 						ComShowCodeMessage("VSK00055", formatDate(new Date(getDateFromFormat(vpsEtaDt, "yyyyMMddHHmm")), "yyyy-MM-dd HH:mm"));
	 						return false;
	 					}
	 					
					}
				}
				formObj.skd_rmk.value = VopAsciiRemove(formObj.skd_rmk.value);
				break;
		}
        return true;
    }
    /**
     * Retrieve
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionSearch(sheetObj, formObj, sAction){
//    	formObj.f_cmd.value = sAction;
    	formObj.f_cmd.value=SEARCH;
    	var prefix=sheetObj.id + "_";
		var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
 		var sXml=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam);
		ComOpenWait(false);
		showSheetData(sheetObj, formObj, sXml, false);
		initButton(formObj);
		//All Check Initializing
		sheetObj.CheckAll(prefix+"del_chk",0);
    }
    /**
     * process after retrieve.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @param isCreateFlg
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml, isCreateFlg){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	glbBookingChk="";
		if(sXml != null){
			var rootNode=VskGetXmlRootNode(sXml);
			//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(dataNode){
				var totValue=dataNode;
				if(totValue > 0){
					//Booking status.
					glbBookingChk=ComGetEtcData(sXml, "booking_chk");
					var vslSvcTpCd=ComGetEtcData(sXml, "vsl_svc_tp_cd");
					formObj.vsl_svc_tp_cd.value=vslSvcTpCd;
					
					try{
						if(isCreateFlg){
							rowAllHiddenByCreate(sheetObj);							
							sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
						}else{
							sheetObj.RemoveAll();
							sheetObj.LoadSearchData(sXml,{Sync:1} );
						}
						
						initPortDataFlg(sheetObj);
						var ydCds=ComGetEtcData(sXml, "tml_cd").split("|");
						var ydIdx=0;
						if(ydCds != null && ydCds != undefined && ydCds != ""){
							// ydCds.length = sheetObj.RowCount
					    	for(var i=headCnt; i<=sheetObj.LastRow(); i++) {
//					    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
					    		if(sheetObj.GetRowStatus(i) != "D"){
						    		sheetObj.CellComboItem(i,prefix+"tml_cd", {ComboText:ydCds[ydIdx], ComboCode:ydCds[ydIdx]} );
						    		sheetObj.SetCellValue(i, prefix+"tml_cd",ydCds[ydIdx],0);
						    		var turnPortFlg=sheetObj.GetCellValue(i, prefix+"turn_port_flg");
						    		if(turnPortFlg == "N"){
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",0);
//						    			sheetObj.CellEditable(i, prefix+"turn_clpt_ind_seq") = false;
						    		}else{
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",1);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",1);
						    		}
						    		var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
						    		if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//						    			in case TURN_PORT_IND_CD is (D, V, F), ETA, ETB, ETD editable
//						    			sheetObj.CellEditable(i, prefix+"del_chk") = false;
						    			sheetObj.SetCellEditable(i, prefix+"clpt_seq",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
//						    			sheetObj.CellEditable(i, prefix+"tml_cd") = false;
						    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",0);
//						    			sheetObj.CellEditable(i, prefix+"") = false;
						    		}
//						    		in case Turn Indicator is Y, mandatory input
						    		if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
						    			sheetObj.SetCellBackColor(i, prefix+"turn_skd_voy_no",glbEditColor);
						    			sheetObj.SetCellBackColor(i, prefix+"turn_skd_dir_cd",glbEditColor);
//						    			sheetObj.CellBackColor(i, prefix+"turn_clpt_ind_seq") = glbEditColor;
						    		}
//						    		if Arrival / Departure Report exist, can not delete
						    		var portSkdStsCd=sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd");
						    		if(portSkdStsCd == "A"){
						    			sheetObj.SetCellEditable(i, prefix+"del_chk",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",0);
						    		} else if(portSkdStsCd == "B") {
						    			sheetObj.SetCellEditable(i, prefix+"del_chk",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",0);
						    		} else if(portSkdStsCd == "D") {
						    			sheetObj.SetCellEditable(i, prefix+"del_chk",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"vps_etd_dt",0);
						    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",0);
						    			sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",0);
						    		}
						    		if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
						    			sheetObj.SetCellEditable(i, prefix+"del_chk",0);
						    		}
						    		//Skip Port not editable
						    		if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						    			rowEditableBySkip(sheetObj, i, false);
						    			fontColorChangeBySkip(sheetObj, i);
						    		}
						    		ydIdx++;
//						    		sheetObj.CellValue2(i, prefix+"ibflag") = "U";
						    		sheetObj.SetRowStatus(i,"U");
					    		}
							} // end for
						}
						
					}catch(e){
						ComShowMessage(e.message);						
					}
					var vslSlanCd=ComGetEtcData(sXml, "vsl_slan_cd");
					if(vslSlanCd != null && vslSlanCd != undefined){
						formObj.vsl_slan_cd.value=vslSlanCd;
					}
					var skdRmk=ComGetEtcData(sXml, "skd_rmk");
					if(skdRmk != null && skdRmk != undefined){
						formObj.skd_rmk.value=skdRmk;
					}
					
					setPfSvcTpCdCombo(sXml);
					setFormData(sheetObj, headCnt, 1);
					resetClptSeq(sheetObj);

				}else{
					ComShowCodeMessage("VSK00043");
			    	formObj.vsl_slan_cd.value="";
			    	formObj.cre_dt.value="";
			    	formObj.cre_usr_id.value="";
			    	formObj.upd_dt.value="";
			    	formObj.upd_usr_id.value="";
			    	formObj.skd_rmk.value="";
			    	getComboObject("pf_svc_tp_cd").RemoveAll();
			    	sheetObj.RemoveAll();
					sheetObj.DataInsert(-1);
					resetClptSeq(sheetObj);
					setBaseRowData(sheetObj, formObj, sheetObj.HeaderRows());
				}
			}else{
				sheetObj.LoadSearchData(sXml,{Sync:1} );
			}
		}
    }
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnClick(sheetObj, Row, Col) {
//		alert(sheetObj.CellValue(Row, Col));
//		alert(sheetObj.CellValue(Row, sheetObj.id+"_pf_eta_dt"));
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		var sXml=null;
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"vps_port_cd"){
//				Retrieve terminal code except no changing cell
				if(!sheetObj.GetCellEditable(Row, Col)){
					return;
				}
				portDataFlgs[Row-headCnt]="N";
					formObj.loc_cd.value=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
				sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
				var chkPort=ComGetEtcData(sXml, "check_port");
				if(chkPort == "X"){
					if(sXml != null && sXml != undefined && sXml != ""){
						//var rootNode=VskGetXmlRootNode(sXml);
						//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
						//DATA/@TOTAL

						var rootNode=VskGetXmlRootNode(sXml);
						//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
						var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
						if(dataNode){
							var totValue=dataNode;
							if(totValue > 0){
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.SetCellValue(Row, sheetObj.id+"_tml_cd","",0);
							}
						}
					}
					portDataFlgs[Row-headCnt]="Y";
				}else{
					ComShowCodeMessage("VSK00029", sheetObj.GetCellValue(Row, prefix+"vps_port_cd"));
					sheetObj.SetCellValue(Row, prefix+"vps_port_cd","",0);
					sheetObj.SelectCell(Row, prefix+"vps_port_cd");
					portDataFlgs[Row-headCnt]="N";
				}
				resetClptIndSeq(sheetObj);	//clpt_ind_seq reset
			}
			else if(colName == prefix+"vps_eta_dt" || colName == prefix+"vps_etb_dt" || colName == prefix+"vps_etd_dt"){
				//Checking ETA, ETB, ETD date format
				if(isDateValid(sheetObj, Row, Col) == false){
					return false;
				}
			}
			else if(colName == prefix+"turn_port_flg"){
//	    		in case Turn Indicator is Y, mandatory input
				if(sheetObj.GetCellValue(Row, prefix+"turn_port_flg") == "Y"){
	    			sheetObj.SetCellEditable(Row, prefix+"turn_skd_voy_no",1);
	    			sheetObj.SetCellEditable(Row, prefix+"turn_skd_dir_cd",1);
	    			sheetObj.SetCellBackColor(Row, prefix+"turn_skd_voy_no",glbEditColor);
	    			sheetObj.SetCellBackColor(Row, prefix+"turn_skd_dir_cd",glbEditColor);
	    			if(headCnt == Row){
	    				if(sheetObj.GetCellValue(Row, prefix+"dir_seq") == "1"){
		    				sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
		    			}else{
		    				sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","Y",0);
		    			}
	    			}else{
	    				sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","Y",0);
	    			}
	    		}else{
	    			sheetObj.SetCellEditable(Row, prefix+"turn_skd_voy_no",0);
	    			sheetObj.SetCellEditable(Row, prefix+"turn_skd_dir_cd",0);
	    			sheetObj.SetCellBackColor(Row, prefix+"turn_skd_voy_no",glbDisableColor);
	    			sheetObj.SetCellBackColor(Row, prefix+"turn_skd_dir_cd",glbDisableColor);
	    			sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
	    			sheetObj.SetCellValue(Row, prefix+"turn_skd_voy_no","",0);
	    			sheetObj.SetCellValue(Row, prefix+"turn_skd_dir_cd","",0);
	    		}
			}
		}
	}
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		if(NewRow >= headCnt && NewCol > 0){
			var sXml=null;
			var prefix=sheetObj.id + "_";
			//[Row Add, Row Insert, Delete] Button : in case turn_port_ind_cd is (D, V, F), blocking
			var turnPortIndCd=sheetObj.GetCellValue(NewRow, prefix+"turn_port_ind_cd");
			if(glbBookingChk != "X" && glbBookingChk != "A"){
				if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
	//				ComBtnDisable("btn_add");
					ComBtnDisable("btn_insert");
	//				ComBtnDisable("btn_del");
				}else{
	//				ComBtnEnable("btn_add");
					ComBtnEnable("btn_insert");
	//				ComBtnEnable("btn_del");
				}
			}
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
//				Retrieve terminal code except no changing cell
				if(!sheetObj.GetCellEditable(NewRow, NewCol)){
					return;
				}
//				if(portDataFlgs[NewRow-headCnt] == "N"){
				if(portDataFlgs[NewRow-headCnt] != "Y"){
					var locCd=sheetObj.GetCellValue(NewRow, prefix+"vps_port_cd");
					if(locCd != null && locCd != undefined && locCd != ""){
						formObj.loc_cd.value=locCd;
						sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
						if(sXml != null && sXml != undefined && sXml != ""){
							setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
						}
						//portDataFlgs[NewRow-headCnt]="Y";
					}
				}
			}
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
//	function pf_svc_tp_cd_OnChange(comboObj, Index_Code, Text) {
//		isRmkModFlg = "Y";
//	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change', 'obj_change', form); 	
//    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
//    	axon_event.addListenerForm('activate', "obj_activate", form);
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName=ComGetEvent("name");
			var srcValue=ComGetEvent("value");;
	        switch(srcName) {
	            case "vsl_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		if(srcValue.length == 4){
	            			formObj.skd_voy_no.focus();
				    	}
	            		processRetrieve();
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	            case "skd_voy_no":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 4){
	            		formObj.skd_dir_cd.focus();
			    	}
	            	processRetrieve();
	            	break;
	            case "skd_dir_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 1){
			    		formObj.vsl_slan_cd.focus();
			    	}
	            	formObj.vsl_slan_dir_cd.value=formObj.skd_dir_cd.value;
	            	if(!isPfValid(sheetObj, formObj)){
	            		if(formObj.vsl_slan_cd.value != ""){
		            		formObj.vsl_slan_dir_cd.value="";
		            		formObj.skd_dir_cd.value="";
	            		}
	            	}
	            	processRetrieve();
	            	break;
	            case "vsl_slan_cd":
	            	if(!isPfValid(sheetObj, formObj)){
	            		if(formObj.vsl_slan_dir_cd.value != "" || formObj.skd_dir_cd.value != ""){
	            			formObj.vsl_slan_cd.value="";
	            		}
	            	}
	            	if(validateForm(sheetObj, formObj, COMMAND05)){
		            	var sXml=doActionIBSheet(sheetObj,formObj,SEARCH02);
		            	if(sXml != null){
		            		var rootNode=VskGetXmlRootNode(sXml);
		            		var dataNode= ComGetSelectSingleNode(sXml, "MESSAGE");
		        			//var dataNode=rootNode.selectSingleNode("//ERROR/MESSAGE");
		            		//alert(dataNode );
		        			if(dataNode){
		        				var nodeText=dataNode;
		        				if(nodeText != ""){
		        					sheetObj.LoadSearchData(sXml,{Sync:1} );
		        					formObj.vsl_slan_cd.value="";
		        					getComboObject("pf_svc_tp_cd").RemoveAll();
		        				}
		        			}else{
		        				
		        				var svcTpCd=ComGetEtcData(sXml, "svc_tp_cd");
		    					formObj.vsl_svc_tp_cd.value=svcTpCd;
		        				setPfSvcTpCdCombo(sXml);
		        			}
		            	}
	            	}
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 3){
			    		//getComboObject("pf_svc_tp_cd").focus();
			    	}
	            	if(ComGetEvent("value") == ""){
	            		formObj.skd_dir_cd.value = "";
	            	}
	            	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
//	function obj_keypress(){
//		var formObj=document.form;
//		switch (event.srcElement.name) {
//		    case "vsl_cd":
//		    	ComKeyOnlyAlphabet('uppernum');
//				break;
//		    case "skd_voy_no":
//		    	ComKeyOnlyNumber(document.form.skd_voy_no);
//				break;
//		    case "skd_dir_cd":
//		    	ComKeyOnlyAlphabet('upper');
//				break;
//		    case "vsl_slan_cd":
//		    	ComKeyOnlyAlphabet('uppernum');
//				break;
//		    case "skd_rmk":
//		    	if(formObj.skd_rmk.value.length > 4000){
//		    		ComShowCodeMessage("VSK01019", "[Remark(s)]");
//		    		return false;
//		    	}
//				break;
//		}
//	}
//	function obj_keyup(){
//		var eleObj=event.srcElement;
//		var formObj=document.form;
//		switch (eleObj.name) {
//		    case "vsl_cd":
//		    	if(eleObj.value.length == 4){
//		    		formObj.skd_voy_no.focus();
//		    	}
//				break; 
//		    case "skd_voy_no":
//		    	if(eleObj.value.length == 4){
//		    		formObj.skd_dir_cd.focus();
//		    	}
//				break;
//		    case "skd_dir_cd":
//		    	if(eleObj.value.length == 1){
//		    		formObj.vsl_slan_cd.focus();
//		    	}
//		    case "vsl_slan_cd":
//		    	if(eleObj.value.length == 3){
//		    		getComboObject("pf_svc_tp_cd").focus();
//		    	}
//				break;
//		}
//	}
//	function obj_activate(){
//		var srcName = event.srcElement.name;
//	
//		switch(srcName){
//			case "vsl_cd":
//			case "skd_voy_no":
//			case "skd_dir_cd":
//				event.srcElement.select();
//				break;
//		}
//	}
    /**
     * Handling Slan Code Pop-up
     * @param rtnObjs
     * @return
     */
	function getLaneCodeData(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];

    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_slan_cd.value=rtnDatas[1];
				}
			}
    	}
		if(validateForm(sheetObj, formObj, COMMAND04)){
        	var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
        	if(sXml != null){
        		var rootNode=VskGetXmlRootNode(sXml);
        		var dataNode ="";
    			//var dataNode=rootNode.selectSingleNode("//ERROR/MESSAGE");
    			if(dataNode){
    				var nodeText=dataNode;
    				if(nodeText != ""){
    					sheetObj.LoadSearchData(sXml,{Sync:1} );
    					getComboObject("pf_svc_tp_cd").RemoveAll();
    				}
    			}else{
    				setPfSvcTpCdCombo(sXml);
    			}
        	}
    	}
	}
	/**
	 * Setting data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function getVslCdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value=rtnDatas[1];
				}
			}
    	}
    }
    /**
     * Setting data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function getVvdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
					document.form.vsl_slan_dir_cd.value=rtnDatas[3];
					processRetrieve();
				}
			}
    	}
    }
	/**
	 * Handling data from Information Input for SKD Creation (P/F SKD Use) (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function getPfSkdData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					var formObj=document.form;
					var sheetObj=sheetObjects[0];
					formObj.vsl_slan_cd.value=rtnDatas[1];		//vsl_slan_cd
					getComboObject("pf_svc_tp_cd").SetSelectCode(rtnDatas[3],false);
					formObj.vps_port_cd.value=rtnDatas[4];		//port_cd
					formObj.skd_dir_cd.value=rtnDatas[5];			//skd_dir_cd
					formObj.vsl_slan_dir_cd.value=rtnDatas[5];	//skd_dir_cd
					formObj.vps_etb_dt.value=ComReplaceStr(rtnDatas[7],"-","");			//vps_etb_dt
					formObj.clpt_seq.value=rtnDatas[8];	//clpt_seq
					//create skd
					creatSkd(sheetObj, formObj);
					getComboObject("pf_svc_tp_cd").SetSelectCode(rtnDatas[3],false);
				}
			}
    	}
	}
	/*
	 * =====================================================================
	 * Etc Function
	 * =====================================================================
	 */
	/**
	 * Setting selected row data to form
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var form=document.form;
    	var prefix=sheetObj.id + "_";
    	form.cre_usr_id.value=sheetObj.GetCellValue(Row, prefix+"cre_usr_id");
    	form.cre_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"cre_dt"));
		form.upd_usr_id.value=sheetObj.GetCellValue(Row, prefix+"upd_usr_id");
		form.upd_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"upd_dt"));
    }
	/**
	 * Setting Terminal Combo Data
	 * @param xmlStr
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var ydKindCode=" |" + ComGetEtcData(xmlStr, "yd_kind");
		var ydNm=" |" + ComGetEtcData(xmlStr, "yd_nm");
		var ydTxt="";
		if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
			var ydKindCodeArr=ydKindCode.split("|");
			var ydNmArr=ydNm.split("|");
			var ydCnt=ydKindCodeArr.length;
			ydTxt=ydKindCodeArr[0] + "\t" + ydNmArr[0];
			for(var i=1; i<ydCnt; i++){
				ydTxt=ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
			}
			sheetObj.CellComboItem(Row,sheetObj.id+"_tml_cd", {ComboText:ydTxt, ComboCode:ydKindCode} );
		}
	}
	/**
	 * Clearing Terminal Combo Data
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetClearCombo(sheetObj, Row, Col){
		sheetObj.CellComboItem(Row,sheetObj.id+"_tml_cd", {ComboText:"", ComboCode:""} );
	}
	/**
	 * Creating SKD
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function creatSkd(sheetObj, formObj){
		var sXml=doActionIBSheet(sheetObj,formObj,SEARCH03);
		sheetObj.RemoveAll();
		showSheetData(sheetObj, formObj, sXml, true);
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		if(sheetObj.RowCount()> 0){
			var stPortCd="";			//first Port
			var n1stPortBrthDt="";	//first ETB
			for(var i=headCnt; i<=sheetObj.LastRow(); i++){
				if(sheetObj.GetRowHidden(i) == false){
//					sheetObj.CellValue2(i, prefix+"ibflag") = "I";
					sheetObj.SetRowStatus(i,"I");
					sheetObj.SetCellValue(i, prefix+"vsl_cd",formObj.vsl_cd.value,0);
					sheetObj.SetCellValue(i, prefix+"skd_voy_no",formObj.skd_voy_no.value,0);
					sheetObj.SetCellValue(i, prefix+"skd_dir_cd",formObj.skd_dir_cd.value,0);
					sheetObj.SetCellValue(i, prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value,0);
					sheetObj.SetCellValue(i, prefix+"slan_cd",formObj.vsl_slan_cd.value,0);
					if(sheetObj.GetCellValue(i, prefix+"clpt_seq") == "1"){
						stPortCd=sheetObj.GetCellValue(i, prefix+"vps_port_cd");
						n1stPortBrthDt=sheetObj.GetCellValue(i, prefix+"vps_etb_dt");
					}
					sheetObj.SetCellValue(i, prefix+"st_port_cd",stPortCd,0);
					sheetObj.SetCellValue(i, prefix+"n1st_port_brth_dt",n1stPortBrthDt,0);
					
					//::Default Setting AUTO SKD CHANGE FLAG Checked:2015-04-15:://
			    	sheetObj.SetCellValue(i, prefix+"auto_skd_cng_flg" , "1", 0);
				}
			}
		}
		formObj.skd_rmk.value="";
		resetClptIndSeq(sheetObj);
	}
	/**
	 * Setting pf_svc_tp_cd combo with xml
	 * @param sXml
	 * @return
	 */
	function setPfSvcTpCdCombo(sXml){
		var pfLaneTypeArr=("|" + ComGetEtcData(sXml, "pf_svc_type_list")).split("|");
		var slanStndFlgArr=("|" + ComGetEtcData(sXml, "slan_stnd_flag_list")).split("|");
		var pfSkdTpCd=ComGetEtcData(sXml, "pf_skd_tp_cd");
		if(pfLaneTypeArr != null && pfLaneTypeArr != undefined && pfLaneTypeArr != ""){
			if(pfSkdTpCd == null || pfSkdTpCd == undefined || pfSkdTpCd == ""){
				//in case pfSkdTpCd is null, Finding PF_SVC_TP_CD and Setting
				if(slanStndFlgArr != null && slanStndFlgArr != undefined && slanStndFlgArr != ""){
					for(var i=0; i<slanStndFlgArr.length; i++) {
						if(slanStndFlgArr[i] == "Y"){
							pfSkdTpCd=pfLaneTypeArr[i]; 
						}
					}
				}
			}
		}
		appendMultiComboItem(getComboObject("pf_svc_tp_cd"), pfLaneTypeArr, slanStndFlgArr, pfSkdTpCd);
	}
	/**
	 * Adding item to Mutil Combo
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
		comboObj.RemoveAll();
    	for(var i=0; i<optionCds.length; i++) {
			comboObj.InsertItem(i, optionCds[i]+"|"+optionTxts[i], optionCds[i]);
		}
		comboObj.SetSelectCode(selCode,false);
	}
    /**
     * Handling initial data for Blocking Terminal reRetrieve
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    	var rows=sheetObj.Rows;
    	var headCnt=sheetObj.HeaderRows();
    	for(var i=headCnt; i<rows; i++){
    		portDataFlgs[i-headCnt]="N";
    	}
    }
    /**
     * Initializing screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	glbBookingChk="";
    	formObj.vsl_cd.value="";
    	formObj.skd_voy_no.value="";
    	formObj.skd_dir_cd.value="";
    	formObj.vsl_slan_dir_cd.value="";
    	formObj.vsl_slan_cd.value="";
    	formObj.cre_dt.value="";
    	formObj.cre_usr_id.value="";
    	formObj.upd_dt.value="";
    	formObj.upd_usr_id.value="";
    	formObj.skd_rmk.value="";
    	getComboObject("pf_svc_tp_cd").RemoveAll();
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    	resetClptSeq(sheetObj);
    	//All Check Initializing
    	sheetObj.CheckAll(sheetObj.id+"_del_chk",0);
    	formObj.vsl_cd.focus();
    	initButton(formObj);
    }
    /**
     * Initializing except condition.
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearDescData(sheetObj, formObj, sData){
    	formObj.cre_dt.value="";
    	formObj.cre_usr_id.value="";
    	formObj.upd_dt.value="";
    	formObj.upd_usr_id.value="";
    	if(sData != "skd_rmk"){
    		formObj.skd_rmk.value="";
    	}
    	sheetObj.RemoveAll();
    	sheetObj.DataInsert(-1);
    	resetClptSeq(sheetObj);
    	setBaseRowData(sheetObj, formObj, sheetObj.HeaderRows());
    	//All Check Initializing
    	sheetObj.CheckAll(sheetObj.id+"_del_chk",0);
    }
    /**
     * Setting original Row Add, Row Insert, Delete Button Status
     * 
     * @return
     */
    function initButton(formObj){
    	//alert("glbBookingChk  :: " + glbBookingChk );
		if(glbBookingChk == "X"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_pfsked");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_insert");
			ComBtnDisable("btn_del");
			ComEnableObject(formObj.skd_rmk, false);
			//booking Msg
			ComShowCodeMessage("VSK00007");
		}else if(glbBookingChk == "A"){
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_pfsked");
			ComBtnDisable("btn_add");
			ComBtnDisable("btn_insert");
			ComBtnDisable("btn_del");
			ComEnableObject(formObj.skd_rmk, false);
			//Actual Msg
			ComShowCodeMessage("VSK00006");
		}else{
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_pfsked");
			ComBtnEnable("btn_add");
			ComBtnEnable("btn_insert");
			ComBtnEnable("btn_del");
			ComEnableObject(formObj.skd_rmk, true);
			
			var sheetObj=sheetObjects[0];
	    	var headCnt=sheetObj.HeaderRows();
	    	var totCnt=sheetObj.LastRow();
	    	var prefix=sheetObj.id + "_";
	    	for(var i=headCnt; i<=totCnt; i++){
	    		var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
				if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
	    			ComBtnDisable("btn_add");
					ComBtnDisable("btn_insert");
	    			break;
				}
	    	}
	    	
		}
    }
    /**
     * Creating CLPT_SEQ in order
     * @param sheetObj
     * @return
     */
    function resetClptSeq(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var totCnt=sheetObj.LastRow();
    	var idx=0;
    	var vIbFlag="";
    	for(var i=headCnt; i<=totCnt; i++){
//    		alert(idx + ":" + sheetObj.CellValue(i, prefix+"ibflag"));
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			idx++;
//    			sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
//    		}
    		if(sheetObj.GetRowStatus(i) != "D"){
    			vIbFlag=sheetObj.GetRowStatus(i);
    			idx++;
    			sheetObj.SetCellValue(i, prefix+"clpt_seq",idx,0);
    			sheetObj.SetRowStatus(i,vIbFlag);
    		}    		
    	}
    }
    /**
     * Creating CLPT_IND_SEQ in order
     * @param sheetObj
     * @return
     */
    function resetClptIndSeq(sheetObj){
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var prefix=sheetObj.id + "_";
    	var idx=0;
    	var vIbFlag="";
    	var preVvd="";
    	var curVvd="";
    	for(var i=0; i<rowCnt; i++){
    		idx=0;
//    		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
    		if(sheetObj.GetRowStatus(i+headCnt) != "D"){
	    		for(var j=0; j<=i; j++){
//	    			if(sheetObj.CellValue(j+headCnt, prefix+"ibflag") != "D"){
	    			if(sheetObj.GetRowStatus(j+headCnt) != "D"){
	    				if(sheetObj.GetCellValue(i+headCnt, prefix+"vps_port_cd") == sheetObj.GetCellValue(j+headCnt, prefix+"vps_port_cd")){
    						idx++;
    					}
	    			}
	    		}//end for
//	    		vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//    			sheetObj.CellValue2(i+headCnt, prefix+"new_clpt_ind_seq") = idx;
//    			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
	    		vIbFlag=sheetObj.GetRowStatus(i+headCnt);
    			sheetObj.SetCellValue(i+headCnt, prefix+"new_clpt_ind_seq",idx,0);
    			sheetObj.SetRowStatus(i+headCnt,vIbFlag);
    		}
    	}
    }
    /**
     * Setting Editable status of Skip Row.
     * 
     * @param sheetObj
     * @param sRow
     * @param flg
     * @return
     */
    function rowEditableBySkip(sheetObj, sRow, flg){
    	var prefix=sheetObj.id + "_";
    	sheetObj.SetCellEditable(sRow, prefix+"vps_port_cd",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"tml_cd",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"vps_eta_dt",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"vps_etb_dt",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"vps_etd_dt",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"turn_port_flg",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"turn_skd_voy_no",flg);
    	sheetObj.SetCellEditable(sRow, prefix+"turn_skd_dir_cd",flg);
    }
    /**
	 * Setting Font Color of Skip Row .
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
//		cellFontToBackColor(sheetObj, sRow, prefix+"vps_port_cd");
//		cellFontToBackColor(sheetObj, sRow, prefix+"tml_cd");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_port_flg");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_skd_voy_no");
		cellFontToBackColor(sheetObj, sRow, prefix+"turn_skd_dir_cd");
	}
    /**
     * Returning comboObject with combo id
     * @param comboId
     * @return
     */
    function getComboObject(comboId){
    	var cnt=comboObjects.length;
    	if(cnt > 0){
    		for(var i=0; i<cnt; i++){
    			if(comboObjects[i].options.id== comboId){
    				return comboObjects[i];
    			}
    		}
    	}
    	return null;
    }
    /**
     * Setting base data when Row create
     * @param sheetObj
     * @param rowIdx
     * @return
     */
    function setBaseRowData(sheetObj, formObj, rowIdx){
    	var prefix=sheetObj.id + "_";
    	sheetObj.SetCellValue(rowIdx, prefix+"vsl_cd"           ,formObj.vsl_cd.value,0);
    	sheetObj.SetCellValue(rowIdx, prefix+"skd_voy_no"       ,formObj.skd_voy_no.value,0);
    	sheetObj.SetCellValue(rowIdx, prefix+"skd_dir_cd"       ,formObj.skd_dir_cd.value,0);
    	sheetObj.SetCellValue(rowIdx, prefix+"vsl_slan_cd"      ,formObj.vsl_slan_cd.value,0);
    	sheetObj.SetCellValue(rowIdx, prefix+"slan_cd"          ,formObj.vsl_slan_cd.value,0);
    	sheetObj.SetCellValue(rowIdx, prefix+"auto_skd_cng_flg" ,"1",0);
//    	sheetObj.CellValue2(rowIdx, prefix+"init_etd_dt") = sheetObj.CellValue(rowIdx-1, prefix+"init_etd_dt");
    }
	/**
	 * Change Font Color to Back Color
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function cellFontToBackColor(sheetObj, Row, Col){
		var backColor = sheetObj.GetCellBackColor(Row, Col);
		// Cell색상이 없는 경우, #FFFFFF으로 설정
		if(backColor=="") {
			backColor = "#FFFFFF";
		}
 		sheetObj.SetCellFontColor(Row, Col, backColor);
	}
    /**
     * Setting Direction Code List of Turnning Port
     * @param sheetObj
     * @return
     */
    function initLoadDirection(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var sXml=doActionIBSheet(sheetObj, document.form, SEARCH04);
    	var sDirCds=ComGetEtcData(sXml, "direction_cd");
    	var sDirCds= "|" + sDirCds;
    	sheetObj.SetColProperty(prefix+"turn_skd_dir_cd", {ComboText:sDirCds, ComboCode:sDirCds} );
    }
    /**
     * Finding last row of Add Row
     * @param sheetObj
     * @return
     */
    function getLastRowAfterVirtual(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var rowIdx=headCnt-1;
    	for(var i=0; i<rowCnt; i++){
    		var turnPortInd=sheetObj.GetCellValue(i+headCnt, prefix+"turn_port_ind_cd")
    		if(turnPortInd == "F" || turnPortInd == "V" || turnPortInd == "D"){
    			break;
    		}
    		rowIdx++;
    	}
    	return rowIdx;
    }
    /**
     * Checking inputed direction is exist in inputed Lane Code
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isPfValid(sheetObj, formObj){
    	if(formObj.vsl_slan_dir_cd.value == "" || formObj.vsl_slan_cd.value == ""){
    		return;
    	}
    	var sXml=doActionIBSheet(sheetObj, formObj, SEARCH05);
    	var laneYN=ComGetEtcData(sXml, "lane_chk");
    	if(laneYN == "Y"){
    		return true;
    	}
    	ComShowCodeMessage("VSK00072", formObj.vsl_slan_cd.value, formObj.vsl_slan_dir_cd.value);
    	return false;
    }
    /**
     * Checking Vessel Code is exist in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH10);
		var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
		if(chkVslCd == "Y"){
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:1} );
    		formObj.vsl_cd.value="";
    		return false;
    	}
	}
    /**
     * Checking ETA, ETB, ETD date format
     * 
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function isDateValid(sheetObj, Row, Col){
    	var prefix=sheetObj.id + "_";
//    	var colIdx = sheetObj.SaveNameCol(Col);
    	var colName=sheetObj.ColSaveName(Col);
    	var errMsg="";
    	if(colName == prefix+"vps_eta_dt"){
    		errMsg="(ETA-"+sheetObj.GetCellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etb_dt"){
    		errMsg="(ETB-"+sheetObj.GetCellValue(Row, Col)+")";
    	}else if(colName == prefix+"vps_etd_dt"){
    		errMsg="(ETD-"+sheetObj.GetCellValue(Row, Col)+")";
    	}
		//Checking ETA, ETB, ETD date format
    	if(sheetObj.GetCellValue(Row, Col).length < 12){
			ComShowCodeMessage("VSK01018", errMsg);
			sheetObj.SelectCell(Row, Col);
			return false;
		}else{
			if(!ComIsDate(sheetObj.GetCellValue(Row, Col).substring(0,8))){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
			if(!ComIsTime(sheetObj.GetCellValue(Row, Col).substring(8,12), "hm")){
				ComShowCodeMessage("VSK01018", errMsg);
				sheetObj.SelectCell(Row, Col);
				return false
			}
		}
    	return true;
    }
    function rowAllHiddenByCreate(sheetObj){
    	var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=sheetObj.LastRow();
		if(rowCnt > 0){
			for(var i=headCnt; i<=totCnt; i++){
//				if(sheetObj.CellValue(i, prefix+"vps_port_cd") == ""){
//					sheetObj.RowDelete(i);
//				}else 
//				alert(i+":"+sheetObj.CellValue(i, prefix+"ibflag"));
//				if(sheetObj.CellValue(i, prefix+"ibflag") == "I"){
				if(sheetObj.GetRowStatus(i) == "I"){
					sheetObj.RowDelete(i, false);
				}else{
//					sheetObj.CellValue2(i, prefix+"ibflag") = "D";
//					sheetObj.RowHidden(i)= true;
					sheetObj.SetCellValue(i, prefix+"del_chk",1,0);
					ComRowHideDelete(sheetObj, prefix+"del_chk");
				}
			}
		}
    }
    
    /**
	 * DataSet for Calculating
	 * @param sDate
	 * @return
	 */
	function Usr_CalcTimeSet(sDate){
		
		this.date = getDateObj(sDate);
		
		this.year = this.date.getFullYear();
		this.month= this.date.getMonth() + 1;
		this.day  = this.date.getDate();
		this.hour = this.date.getHours();
		this.min  = this.date.getMinutes();
	}
	
	/**
	 * Returning inputed date + sTime
	 * 
	 * @param sTime
	 */
	Usr_CalcTimeSet.prototype.getAddDate = function(sTime){
		if(sTime == null || sTime == undefined || sTime == "") sTime = 0;
		
// 		if(sTime < 0) sTime = sTime * (-1);

		var rtnDate = null;
		
		var totMin = this.min + Math.round((Number(sTime)%1) * 60);
		var tMin = totMin%60;				// shown
		
		if(tMin < 30){
			tMin = 0;
		} else if(tMin > 30) {
			tMin = 0;
			totMin = totMin + 30;
		}
		
//		var hMin = Usr_Trunc(totMin/60);
		var hMin = parseInt(totMin/60, 10);
		
// 		var totHour = this.hour + hMin + Usr_Trunc(sTime);
		var totHour = this.hour + hMin + parseInt(sTime, 10);
		
		var tHour = totHour%24;
// 		var dHour = Usr_Trunc(totHour/24);
		var dHour = parseInt(totHour/24, 10);
		
		var tDate = this.year +""+ ComLpad(this.month,2,"0") +""+ ComLpad(this.day,2,"0");
		
// 		rtnDate = tDate;
		if(dHour < 1){
			rtnDate = tDate + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0"); 
		}else{
			rtnDate = ComGetDateAdd(tDate, "D", dHour, "") + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0");
		}
		return rtnDate;
	}
	
	/**
	 * PORT TIME CHECK
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function isPortTimeCheck(sheetObj, formObj) {
			
		var sXml = doActionIBSheet(sheetObj, formObj, COMMAND23);
		
		var actStatus = ComGetEtcData(sXml, "actStatus");
		
		if(actStatus == "NORMAL"){  		
			return true;
		}else{    		
			return false;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
	function processRetrieve(){

		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		    
		if(formObject.vsl_cd.value != "" && formObject.skd_voy_no.value != "" && formObject.skd_dir_cd.value != ""){
			doActionIBSheet(sheetObject,formObject,IBSEARCH);	
		}
	}
