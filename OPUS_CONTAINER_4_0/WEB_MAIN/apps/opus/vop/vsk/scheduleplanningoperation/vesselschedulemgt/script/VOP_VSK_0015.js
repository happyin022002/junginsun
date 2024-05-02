/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : VOP_VSK_0015.js
*@FileTitle : Coastal SKD Simulation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class VOP_VSK_0015 : business script for VOP_VSK_0015
	 */

	var focusObj=null;
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var SKD_SHEET_SIZE=464;
	var PLN_SHEET_SIZE=318;
	var glbSheetFlg="sheet1";
	var glbSheetHeight=PLN_SHEET_SIZE;
	var glbSkdPortFlgs=new Array();
	var glbPlanPortFlgs=new Array();
	var glbTmlFlg="N";
	var gblSheet1CngStsCd="";
	var gblSheet2CngStsCd="";
	// Form Data
	var glbSheet1FormData=null;
	var glbSheet2FormData=null;
	// Color public variable
	var glbActualColor=null;
	var glbHQColor=null;
	var glbNoonColor=null;
	var glbDepartureColor=null;
	var glbInitialColor	= null;
	
	var glbEditColor	= null;
	
	var glbDelayFontColor=null;
	var glbAdvanceFontColor=null;
	var glbNormalFontColor=null;
	var glbTestColor=null;
	
	var gVtAddCallFontColor	= "#FF5E00";
	var gVtAddCallTargetFlg	= "";
	
	var glbMainVslCd="";
	var glbMainSkdVoyNo="";
	var glbMainSkdDirCd="";
	var glbMainVslSlanCd="";
	var glbMainVslEngNm="";
	var glbMainVslKrnNm="";
	// Bunker Additional Cost : calcBunkerAdditionalCost()
	var glbFocHr=0.0;
	var glbSpdP=0.0;
	var glbSlip=0.0;
	
	var gSkdBuffTimeCode=7.5; // CD20071
	//::2015-04-18:://var gSkdBuffTimeCode	= 0; // CD20071
	
	//::FOR.NYK.START::by dongsoo:2014-09-18:://
	//::2007816::2014-04-23::ApplyUpdatedTimebyDistance:://
	//::2007816::2014-04-23 소스 업데이트 함
	var gIsDistOrSpdChange	= false;
	//::FOR.NYK.FINISH::by dongso:2014-09-18:://

	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name
	 * 
	 * @return
	 */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];   // t1sheet1
		var sheetObject2=sheetObjects[1];   // t1sheet2
		/** **************************************************** */
		var formObject=document.form;
    	var sUrl="";
		var sheetObj=null;
		if(glbSheetFlg == "sheet2"){
			sheetObj=sheetObject2;
		} else {
			sheetObj=sheetObject1;
		}
		try {
	    	var prefix=sheetObj.id + "_";
			var srcName=ComGetEvent("name");
	        if (!ComIsBtnEnable(srcName)) return;  
			if(ComGetBtnDisable(srcName)) return false;
			// Blocking disabled button Event
			if(window.event.srcElement.className.indexOf('_1') > 0){
				return;
			}
			
			switch(srcName) {
				case "div_priv_call_1":
					privateCallControl(sheetObj, "PRIVATE_CALL");
					break;
				case "div_priv_call_cancel_1":
					privateCallControl(sheetObj, "PRIVATE_CALL_CANCEL");
					break;
				
				case "btn_vsl_rename_1":
				case "btn_vsl_rename_2":
					doActionIBSheet(sheetObj,formObject,COMMAND24);
					break;			
				case "btn_vsl_slide_1":
				case "btn_vsl_slide_2":
					doActionIBSheet(sheetObj,formObject,COMMAND25);
					break;	
				case "btn_p_in_1":
				case "btn_p_in_2":
					doActionIBSheet(sheetObj,formObject,COMMAND26);
					break;
				case "btn_p_in_cancel_1":
				case "btn_p_in_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND27);
					break;								
				case "btn_row_hide_1":
				case "btn_row_hide_2":
					doActionIBSheet(sheetObj,formObject,COMMAND02);
					break;
				case "btn_skip_call_1":
				case "btn_skip_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND03);
					break;
				case "btn_add_call_1":
				case "btn_add_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND04);
					break;
				case "btn_reverse_call_1":
				case "btn_reverse_call_2":
					doActionIBSheet(sheetObj,formObject,COMMAND05);
					break;
				case "btn_row_hide_cancel_1":
				case "btn_row_hide_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND06);
					break;
				case "btn_skip_call_cancel_1":
				case "btn_skip_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND07);
					break;
				case "btn_add_call_cancel_1":
				case "btn_add_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND08);
					break;
				case "btn_reverse_call_cancel_1":
				case "btn_reverse_call_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND09);
					break;
				case "btn_p_out_1":
				case "btn_p_out_2":
					doActionIBSheet(sheetObj,formObject,COMMAND20);
					break;
				case "btn_p_out_cancel_1":
				case "btn_p_out_cancel_2":
					doActionIBSheet(sheetObj,formObject,COMMAND21);
					break;
				case "btn_col_show":
				case "btn_plan_col_show":
					
					doActionIBSheet(sheetObj,formObject,COMMAND10);
					break;
				case "btn_col_hide":
				case "btn_plan_col_hide":
					doActionIBSheet(sheetObj,formObject,COMMAND11);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObj,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObj,formObject,IBCLEAR);
					break;
				case "btn_save":
					doActionIBSheet(sheetObj,formObject,IBSAVE);
					break;
//				case "btn_gw_mail":
//					doActionIBSheet(sheetObj,formObject,COMMAND18);
//					break;
				case "btn_e_mail":
					doActionIBSheet(sheetObj,formObject,COMMAND22);
					break;
//				case "btn_bulletin_board":
//					doActionIBSheet(sheetObj,formObject,COMMAND19);
//					break;
				case "btn_settlement":
					doActionIBSheet(sheetObj,formObject,COMMAND01);
					break;
				case "btn_loadableweight":
					doActionIBSheet(sheetObj,formObject,COMMAND15);
					break;
				case "rdo_tran":
					doActionIBSheet(sheetObj,formObject,COMMAND12);
					break;
				case "btn_vvd_search":
					doActionIBSheet(sheetObj,formObject,COMMAND13);
					break;
				/*case "btn_sim_no":
					doActionIBSheet(sheetObj,formObject,COMMAND14);
					break;*/
				case "btn_height_big":
					doActionIBSheet(sheetObj,formObject,COMMAND16);
					break;
				case "btn_height_sml":
					doActionIBSheet(sheetObj,formObject,COMMAND17);
					break;
					
				case "btn_apply":	
					adjustCssmVoyNobyVVD(sheetObj);
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
	
	
	function obj_click() {
		var eleObj 	= event.srcElement;
		var formObj = document.form;
		
		switch (eleObj.name) {
		    case "chk_voyage":
		    	formObj.voyage.value = ""; 
				if (formObj.chk_voyage.checked == true) {
					formObj.voyage.disabled = false;
		    		ComBtnEnable	("btn_apply");
		    	} else {
		    		ComBtnDisable	("btn_apply");
		    		formObj.voyage.disabled = true;
		    	}
			break;
		}
    }
	
	
    function adjustCssmVoyNobyVVD(sheetObj) {
    	
    	var sheetID 		= sheetObj.id;
		var prefix  		= sheetID + "_";
		var selRow  		= sheetObj.GetSelectRow();
		var voyage  		= document.form.voyage.value;
		var blank 			= "";
		var voyAllSetFlg 	= "Y";
		
		if (selRow < 0) return;
		
		var strVvd 			= sheetObj.GetCellValue(selRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(selRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(selRow,  prefix+ "skd_dir_cd");
		
		if (!ComShowCodeConfirm("VSK55005", strVvd)) return;
		
    	for (var nRow = sheetObj.HeaderRows(); nRow < (sheetObj.HeaderRows() + sheetObj.RowCount()); nRow++) {

			if (strVvd == sheetObj.GetCellValue(nRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(nRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(nRow,  prefix+ "skd_dir_cd"))
			{	
				
				if(		(		sheetObj.GetCellValue(nRow, prefix+ "real_clpt_seq") 	!= "1" 
						&& 	(	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "Y" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "N"))
					||	
						((		sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "D" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "V" 
							|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "F")
						&&		sheetObj.GetCellValue(nRow, prefix+ "vir_port_clpt_seq")== "1")
				){
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no"	, voyage);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg"	, voyAllSetFlg, 0);
				}
				
				if(		(strVvd == sheetObj.GetCellValue(selRow,  prefix+ "vsl_cd") + sheetObj.GetCellValue(selRow,  prefix+ "skd_voy_no") + sheetObj.GetCellValue(selRow,  prefix+ "skd_dir_cd"))
					&&	(sheetObj.GetCellValue(nRow, prefix + "turn_port_ind_cd")=="N" && sheetObj.GetCellValue(nRow, prefix + "turn_port_flg")=="N"
					&& 	sheetObj.GetCellValue(nRow, prefix + "turn_skd_voy_no")=="" && sheetObj.GetCellValue(nRow, prefix + "real_clpt_seq")=="1")
					&& 	sheetObj.GetCellValue(nRow, prefix + "ib_cssm_voy_no")=="" )
				{
					sheetObj.SetCellValue(nRow,prefix + "ib_cssm_voy_no", blank );
				}
			
				
				if (sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "D" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "V" && sheetObj.GetCellValue(nRow,  prefix+ "turn_port_ind_cd") != "F")
				{
					/////////////top.top.top
					sheetObj.SetCellValue(nRow,prefix + "ob_cssm_voy_no", voyage);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg", voyAllSetFlg, 0);
				}
				
				if(		sheetObj.GetCellValue(nRow, prefix+"clpt_seq")			== "1" 
					&&	sheetObj.GetCellValue(nRow, prefix+"turn_skd_voy_no") 	== ""
				){
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no"	, blank);
					sheetObj.SetCellValue(nRow, prefix + "voy_all_set_flg"	, voyAllSetFlg, 0);
				}
			
			}else if(strVvd == sheetObj.GetCellValue(nRow, prefix + "vsl_cd") + sheetObj.GetCellValue(nRow,  prefix+ "turn_skd_voy_no") + sheetObj.GetCellValue(nRow, prefix + "turn_skd_dir_cd")){
				
				if(	((		sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "D" 
						|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "V" 
						|| 	sheetObj.GetCellValue(nRow, prefix+ "turn_port_ind_cd") == "F")
					&&		sheetObj.GetCellValue(nRow, prefix+ "vir_port_clpt_seq")!= "1"
					)
					||
					sheetObj.GetCellValue(nRow, prefix + "real_clpt_seq") == "1")
				{
					sheetObj.SetCellValue(nRow, prefix + "ib_cssm_voy_no", voyage);  
				}

			}
			
			//Virtual ADD Call Port 조건 추가
			if(sheetObj.GetCellValue(nRow, prefix + "vt_add_call_flg")=="Y"){
				sheetObj.SetCellValue(nRow, prefix + "ob_cssm_voy_no", blank);
			}
    	}
    }
	
	
	function rtnAddCall( rtnVal ){
		var sheetObj	= sheetObjects[0];
		
		if( rtnVal != null ){
			addCallControl(sheetObj, rtnVal);
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
	 * 
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
		for(i=0;i<sheetObjects.length;i++){			
			ComConfigSheet (sheetObjects[i] );			
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
			// Hidden Column Setting...
			sheetObjects[i].RenderSheet(0);
			showFieldControl(sheetObjects[i], document.form, false);
			sheetObjects[i].RenderSheet(1);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		initControl();
		// Color Setting...
		
		glbActualColor="#0AAD0A";
		glbHQColor="#F85C21";
		glbNoonColor="#4D55F9";
		glbDepartureColor="#80E7F9";
		glbInitialColor="#D0D0D0";
		
		glbEditColor	= "#80FFFF";
		
		glbDelayFontColor="#FF0000";
		glbAdvanceFontColor="#0000FF";
		glbNormalFontColor="#000000";
		glbTestColor="#89E168";
		initLoadDirection();
		
		document.form.rtv_flg.value="N";
		btn2ControlHtml("div_col_show", "btn_col_show", "Expand ", "btn_normal", "120");	// un_disabled
		btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden ", "btn_normal", "120");	// disabled
		
//		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand ", "btn_normal", "120");	// un_disabled
//		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden ", "btn_normal", "120");	// disabled

		initButton(sheetObjects[0]);
		ComBtnDisable("btn_col_hide");
		// Form Data Initializing.
		glbSheet1FormData=new Usr_Coni_FormData();
		glbSheet2FormData=new Usr_Coni_FormData();
		document.form.vsl_cd.focus();
		
		/* Initial disabled 'APPLY' button for applying consortium voyage number */
		ComBtnDisable("btn_apply");
		document.form.voyage.disabled = true;
		/* --------------------------------------------------------------------- */
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
		switch(sheetID) {
			case "sheet1":      // sheet1 init
				with (sheetObj) {
		       
			        var HeadTitle1="|Seq.|VVD|Consortium Voyage|Consortium Voyage|Consortium Voyage|Consortium Voyage|CHK|Port\nCode|TMNL\nCode|T/Port\nIND|eCom|Turnning Port|Turnning Port|ETA|ETB|ETD|Delay|Delay|Delay|Private\nStatus|Change\nStatus|VT|Update\nStatus|Dist|SPD|Sea\nTime|Port\nTime|Buffer Time|Buffer Time";
			        var HeadTitle2="|Seq.|VVD|Arr Ext Voy Ref|Dep Ext Voy Ref|T-Arr Ext Voy Ref|Init|CHK|Port\nCode|TMNL\nCode|T/Port\nIND|eCom|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea|RSN|Private\nStatus|Change\nStatus|VT|Update\nStatus|Dist|SPD|Sea\nTime|Port\nTime|Port|Sea";
			        var HeadHidTitle="|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VLS_SLAN_CD|SKD_STS_CD|SKD_VOY_TP_CD|SKD_USD_IND_CD|PF_SKD_TP_CD|ST_PORT_CD" +
			        "|N1ST_PORT_BRTH_DT|PSDO_VVD_CD|CO_CD|SKD_RMK|CRE_ID|CRE_DT|UPD_ID|UPD_DT|CLPT_IND_SEQ|SLAN_CD|PORT_SKD_STS_CD|YD_CD" +
			        "|CALL_YD_IND_SEQ" +
			        "|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT" +
			        "|INIT_ETA_DT|INIT_ETB_DT|INIT_ETD_DT|VSL_DLAY_RSN_DESC|VSL_DLAY_RSN_LOC_CD" +
			        "|SHP_CALL_NO|SHP_CALL_NO_UPD_USR_ID|SHP_CALL_NO_UPD_DT|TML_VSL_CD|TML_VOY_NO|FT_DT|PLISM_YD_CD|PLISM_VSL_CD|PLISM_VOY_NO" +
			        "|TURN_PORT_IND_CD" +
			        "|TURN_CLPT_IND_SEQ|IB_CGO_QTY|OB_CGO_QTY" +
			        "|VPS_RMK|PHS_IO_RSN_CD|PHS_IO_RMK|SKD_BRTH_NO|INIT_SKD_INP_FLG|OFC_INP_FLG|NOON_RPT_INP_FLG|DEP_RPT_INP_FLG|ACT_INP_FLG" +
			        "|PRT_CHK_FLG|EDI_SND_KNT|PORT_SKP_TP_CD|PORT_SKP_RSN_CD|PORT_SKP_RSN_OFFR_RMK|TTL_DLAY_HRS|TS PORT|USD_FLG";
			        HeadHidTitle=HeadHidTitle + "|PF_SVC_TP_CD|PORT_ROTN_SEQ|ETB_DY_CD|ETD_DY_CD|MNVR_IN_HRS|MNVR_OUT_HRS"
			        HeadHidTitle=HeadHidTitle + "|USR_HDN_FLG|ETA_DELAY_FLG|ETB_DELAY_FLG|ETD_DELAY_FLG|DELAY_DATE|TIME_DIFF|DIFF_RMK|BOUND|TMP_CNG_STS_CD|TMP_PHASE_FLAG" +
			        "|CNG_LANE_CD|CNG_VSL_CD|CNG_SKD_VOY_NO|CNG_SKD_DIR_CD|TMP_BKG_VALID|NEW_CLPT_IND_SEQ|BFR_ACT_FLG" +
			        "|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ|remainPortBuffer|remainSeaBuffer|TMP_TZTM_HRS|TMP_ACT_WRK_HRS|TMP_LNK_SPD|PF_LNK_DIST|PF_LNK_SPD|PF_SEA_BUF_HRS|PF_PORT_BUF_HRS|PF_TZTM_HRS|PF_ACT_WRK_HRS|PF_MNVR_OUT_HRS|PF_MNVR_IN_HRS";
			        HeadTitle1=HeadTitle1 + HeadHidTitle;
			        HeadTitle2=HeadTitle2 + HeadHidTitle;
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"} ];
			        InitHeaders(headers, info);
	
			        var cols = [   {Type:"Status",    Hidden:1, Width:45,    Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			                       
					               {Type:"Text",      Hidden:0, Width:36,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               
					               //:2016-03-03:by TOP://
					               {Type:"Text",      Hidden:0, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
					               {Type:"Text",      Hidden:0, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
					               {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cssm_voy_init_cre_flg" },
					               //:2016-03-03:by TOP://
					               
					               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"auto_skd_cng_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
					               {Type:"Combo",     Hidden:0, Width:52,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               
					               {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"add_call_xter_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
					               {Type:"Combo",     Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
					               
					               {Type:"Text",      Hidden:0, Width:104,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",       KeyField:1,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0, Width:104,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",       KeyField:1,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0, Width:104,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",       KeyField:1,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dlay_date_text",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               
					               {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sea_date_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               
					               //:2016-03-03:by TOP://
					               {Type:"Combo",     Hidden:1, Width:70,  Align:"Center",  ColMerge:1,   SaveName:prefix+"priv_call_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               //:2016-03-03:by TOP://
					               
					               {Type:"Combo",     Hidden:0, Width:99,  Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               
					               {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vt_add_call_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					               
					               {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Int",       Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					               {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					               {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
					               {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					               
					               {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					               {Type:"Float",     Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_dir_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_sts_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_voy_tp_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_usd_ind_cd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_skd_tp_cd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"st_port_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_port_brth_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"psdo_vvd_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"co_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_rmk" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cre_usr_id" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cre_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_usr_id" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_ind_seq"},
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slan_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skd_sts_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"yd_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"call_yd_ind_seq" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_eta_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etb_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etd_dt" },
					               
					               {Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_eta_dt" },
					               {Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_etb_dt" },
					               {Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_etd_dt" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_dlay_rsn_desc" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_dlay_rsn_loc_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no_upd_usr_id" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no_upd_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_vsl_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ft_dt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_yd_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_vsl_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_port_ind_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_clpt_ind_seq" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ib_cgo_qty" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ob_cgo_qty" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vps_rmk" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"phs_io_rsn_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"phs_io_rmk" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_brth_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_skd_inp_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ofc_inp_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"noon_rpt_inp_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"dep_rpt_inp_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_inp_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"prt_chk_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"edi_snd_knt" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_tp_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_offr_rmk" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dlay_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_port_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"usd_flg" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_rotn_seq" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_dy_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_dy_cd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mnvr_in_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mnvr_out_hrs" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"usr_hdn_flg" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"eta_delay_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_delay_flg" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_delay_flg" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"delay_date" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"time_diff" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bound" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_cng_sts_cd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_phase_flag" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_lane_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_vsl_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_skd_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_skd_dir_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_bkg_valid" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"new_clpt_ind_seq" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bfr_act_flg" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_dir_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_clpt_ind_seq" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_voy_no" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_dir_cd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_clpt_ind_seq" },
					               
					               {Type:"Text",      Hidden:1, Width:115,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rmn_port_buf" },
					               {Type:"Text",      Hidden:1, Width:115,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rmn_sea_buf" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_tztm_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_act_wrk_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_lnk_spd" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_lnk_dist" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_lnk_spd" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_sea_buf_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_port_buf_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_tztm_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_act_wrk_hrs" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_mnvr_out_hrs" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_mnvr_in_hrs" },
					               
					               //{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ib_cssm_voy_no" },
					               //{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ob_cssm_voy_no" },
					               
					               //-- Adding Column for recovery schedule infomation ---------------------------//
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"time_diff_for_recovery" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"lnk_dist_for_recovery" 		},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"lnk_spd_for_recovery" 		},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"sea_buf_hrs_for_recovery" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_buf_hrs_for_recovery" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tztm_hrs_for_recovery" 		},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_wrk_hrs_for_recovery" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mnvr_out_hrs_for_recovery" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mnvr_in_hrs_for_recovery" 	},
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skipcall_ind_for_recovery" 	},	//:SKIP <- Temporary, null<- initial://
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skp_call_flg" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"add_call_flg" 	},
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_renm_old_vsl_cd" 	 },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_renm_old_vsl_eng_nm" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_renm_new_vsl_cd" 	 },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_renm_new_vsl_eng_nm" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsld_wks" },
					               
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"real_clpt_seq" },
					               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vir_port_clpt_seq" }
					               ];
			         
			        InitColumns(cols);
					SetEditable(1);					
					//SetSheetHeight(ComGetSheetHeight(sheetObj, 4));
			        SetColProperty(prefix+"turn_port_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );

			        SetColProperty(prefix+"priv_call_flg", {ComboText:"|Private Call|", ComboCode:"|Y|N"} );
			        
			        //::FOR.NYK.START::by dongsoo:2014-09-18:://
			        //::cols에 format을 YmdHm으로 변경함 
			        //SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
			        //SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
			        //SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
			        //::FOR.NYK.FINISH::by dongso:2014-09-18:://
			        SetColHidden(prefix+"turn_skd_voy_no",1);
			        SetColHidden(prefix+"turn_skd_dir_cd",1);
			        SetSelectionMode(3);
			        FrozenCols=SaveNameCol(prefix+"turn_skd_voy_no");
			        SetRangeBackColor(1, 2, 1, 36,"#777777");
			        resizeSheet();
				}
				break;
				
			case "sheet2":
				with (sheetObj) {
		       
			        var HeadTitle1="|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Turnning Port|Turnning Port|ETA|ETB|ETD|Delay|Delay|Delay|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|Maneuvering|Maneuvering|Port\nTime|Buffer|Buffer|ECV|ECV|TMNL\nProd.|TMNL\nProd.|Bunker Add. Cost|Bunker Add. Cost|TMNL Handling Cost|TMNL Handling Cost|TMNL Handling Cost|TMNL Handling Cost|Port Charge|Total Cost(USD)";
			        var HeadTitle2="|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea|RSN|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|In|Out|Port\nTime|Port|Sea|In|Out|EA|Vol.|Q'ty|Cost|20'(Vol.)|40'(Vol.)|20'(AMT)|40'(AMT)|Port Charge|Total Cost(USD)";
			        var HeadTitle3="|Seq|VVD|Port\nCode|TMNL\nCode|T/Port\nIND|Voyage|Dir.|ETA|ETB|ETD|TTL|Sea|RSN|Change\nStatus|Dist.|Sp'd|Sea\nTime|ZD|In|Out|Port\nTime|Port|Sea|In|Out|EA|Vol.|Q'ty|Cost|20'(Vol.)|40'(Vol.)|20'(AMT)|40'(AMT)|Port Charge|Total Cost(USD)";
			        var HeadHidTitle="|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VLS_SLAN_CD|SKD_STS_CD|SKD_VOY_TP_CD|SKD_USD_IND_CD|PF_SKD_TP_CD|ST_PORT_CD" +
			        "|N1ST_PORT_BRTH_DT|PSDO_VVD_CD|CO_CD|SKD_RMK|CRE_ID|CRE_DT|UPD_ID|UPD_DT|CLPT_IND_SEQ|SLAN_CD|PORT_SKD_STS_CD|YD_CD" +
			        "|CALL_YD_IND_SEQ|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT|INIT_ETA_DT|INIT_ETB_DT|INIT_ETD_DT|VSL_DLAY_RSN_DESC|VSL_DLAY_RSN_LOC_CD" +
			        "|SHP_CALL_NO|SHP_CALL_NO_UPD_USR_ID|SHP_CALL_NO_UPD_DT|TML_VSL_CD|TML_VOY_NO|FT_DT|PLISM_YD_CD|PLISM_VSL_CD" +
			        "|PLISM_VOY_NO|TURN_PORT_IND_CD|TURN_CLPT_IND_SEQ|VPS_RMK|PHS_IO_RSN_CD|PHS_IO_RMK" +
			        "|SKD_BRTH_NO|INIT_SKD_INP_FLG|OFC_INP_FLG|NOON_RPT_INP_FLG|DEP_RPT_INP_FLG|ACT_INP_FLG|PRT_CHK_FLG|EDI_SND_KNT" +
			        "|PORT_SKP_TP_CD|PORT_SKP_RSN_CD|PORT_SKP_RSN_OFFR_RMK|TTL_DLAY_HRS|TS PORT|USD_FLG|AUTO_SKD_CNG_FLG";
			        HeadHidTitle=HeadHidTitle + "|PF_SVC_TP_CD|PORT_ROTN_SEQ|ETB_DY_CD|ETD_DY_CD|BNK_UNIT_QTY|BNK_UNIT_AMT|BNK_TOT_QTY|BNK_TOT_AMT"
			        HeadHidTitle=HeadHidTitle + "|USR_HDN_FLG|ETA_DELAY_FLG|ETB_DELAY_FLG|ETD_DELAY_FLG|DELAY_DATE|DIFF_RMK|BOUND|TMP_CNG_STS_CD|TMP_PHASE_FLAG" +
			        "|CNG_LANE_CD|CNG_VSL_CD|CNG_SKD_VOY_NO|CNG_SKD_DIR_CD|TMP_BKG_VALID|NEW_CLPT_IND_SEQ|BFR_ACT_FLG" +
			        "|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ|TML_HNDL_20FT_UNIT_AMT|TML_HNDL_40FT_UNIT_AMT" +
			        "|REMAINS_SEA_BUF|REMAINS_PORT_BUF|TMP_TZTM_HRS|TMP_ACT_WRK_HRS|TMP_LNK_SPD|PF_LNK_DIST|PF_LNK_SPD|PF_SEA_BUF_HRS|PF_PORT_BUF_HRS|PF_TZTM_HRS|PF_ACT_WRK_HRS|PF_MNVR_OUT_HRS|PF_MNVR_IN_HRS";
			        HeadTitle1=HeadTitle1 + HeadHidTitle;
			        HeadTitle2=HeadTitle2 + HeadHidTitle;
			        HeadTitle3=HeadTitle3 + HeadHidTitle;
			        var headCount=ComCountHeadTitle(HeadTitle1);
			        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			        var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			        var headers = [ { Text:HeadTitle1, Align:"Center"},
			                    { Text:HeadTitle2, Align:"Center"},
			                    { Text:HeadTitle3, Align:"Center"}];
			        InitHeaders(headers, info);
	
			        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			               {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			               {Type:"Combo",     Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dlay_date_text",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sea_date_text",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_dlay_rsn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_cng_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"time_diff",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			               {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			               {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_cgo_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_cgo_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_bnk_csm_qty",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"add_bnk_cost_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_hndl_20ft_ttl_qty", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_hndl_40ft_ttl_qty", KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_hndl_20ft_ttl_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_hndl_40ft_ttl_amt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pe_usd_ttl_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"total_cost",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_dir_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_sts_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_voy_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_usd_ind_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_skd_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"st_port_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_port_brth_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"psdo_vvd_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"co_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_rmk" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cre_usr_id" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cre_dt"  },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_usr_id" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slan_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skd_sts_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"yd_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"call_yd_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_eta_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etb_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etd_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_eta_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_etb_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_etd_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_dlay_rsn_desc" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_dlay_rsn_loc_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no_upd_usr_id" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"shp_call_no_upd_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_vsl_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ft_dt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_yd_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_vsl_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"plism_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_port_ind_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_clpt_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vps_rmk" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"phs_io_rsn_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"phs_io_rmk" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_brth_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"init_skd_inp_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ofc_inp_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"noon_rpt_inp_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"dep_rpt_inp_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_inp_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"prt_chk_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"edi_snd_knt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_offr_rmk" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dlay_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_port_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"usd_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"auto_skd_cng_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_rotn_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_dy_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_dy_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bnk_unit_qty" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bnk_unit_amt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bnk_tot_qty" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bnk_tot_amt"},
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"usr_hdn_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"eta_delay_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etb_delay_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"etd_delay_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"delay_date" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"diff_rmk" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bound" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_cng_sts_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_phase_flag" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_lane_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_vsl_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_skd_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cng_skd_dir_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_bkg_valid" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"new_clpt_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bfr_act_flg" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_dir_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_clpt_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_voy_no" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_dir_cd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_clpt_ind_seq" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_hndl_20ft_unit_amt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tml_hndl_40ft_unit_amt" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rmn_sea_buf" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rmn_port_buf" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_tztm_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_act_wrk_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_lnk_spd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_lnk_dist" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_lnk_spd" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_sea_buf_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_port_buf_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_tztm_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_act_wrk_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_mnvr_out_hrs" },
			               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_mnvr_in_hrs" } ];
			         
			        InitColumns(cols);
					SetEditable(1);
			        SetColProperty(prefix+"turn_port_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
			        SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
			        SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
			        SetColHidden(prefix+"turn_skd_voy_no",1);
			        SetColHidden(prefix+"turn_skd_dir_cd",1);
			        SetSelectionMode(3);
			        FrozenCols=SaveNameCol(prefix+"turn_skd_voy_no");
			        SetSheetHeight(glbSheetHeight);
			        SetVisible(false);
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
   	    switch(comboObj.id) {
	    	case "remark":
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
   					SetColAlign(0, "left");
   					SetColWidth(0, "104");
  					SetDropHeight(80);
// 					Enable = false;
   		    	}
   	    		break;
   	     }
   	}
	/**
	 * Hidden Col Setting...
	 * 
	 * @param sheetObj
	 * @param Col
	 * @param colName
	 * @return
	 */
	function setHiddenInitDataProperty(sheetObj, Col, colName){
		var prefix=sheetObj.id+"_";
		with (sheetObj) {
			//data property    [	ROW, 	COL,  	DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//			InitDataProperty(0, 	Col, 	dtHidden,				0,		daCenter,	true,		prefix+colName,		false,		"",			dfNone,			0,			false,		false);
			var cols = [ {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+colName,   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];       
            InitColumns(cols);
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		
		var sheetID		= sheetObj.id;
		var prefix		= sheetID + "_";
		
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				doActionSearch(sheetObj, formObj, IBSEARCH);
				break;
			case SEARCH01:		//Terminal(Yard) List
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH02:		// Distance
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH02;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH03:		// Port Change
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH03;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH04:      //Skip - Bunker Additional Cost
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH04;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH05:		//Terminal change, MNVR_IO Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH05;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH06:		// Add Call
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH06;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH07:		//Setting Direction Code List of Turnning Port
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH07;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH08:		//Phase Out Cancel(sheet1)
				formObj.f_cmd.value=SEARCH08;
				var sParam=ComGetSaveString(sheetObjects, false);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
				
 				var sXml=sheetObj.GetSaveData("VOP_VSK_0015GS.do", sParam);
				return sXml;
				break;
			case SEARCH09:		//Phase Out Cancel(sheet2)
				formObj.f_cmd.value=SEARCH09;
				var sParam=ComGetSaveString(sheetObjects, false);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 				var sXml=sheetObj.GetSaveData("VOP_VSK_0015GS.do", sParam);
				return sXml;
				break;
			case SEARCH10:		//Vsl_Cd Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH11:		// Skip(Distance)
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH11;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH12:		// Port Change (of Add Call : sheet2)
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH12;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
					return sXml;
				}
				break;
			case IBSAVE:        //save
				doActionSave(sheetObj, formObj, sAction);
				break;
			case IBCLEAR:        //New
				clearAllData(sheetObj, formObj);
				break;
			case COMMAND01:        //
				doActionSave(sheetObj, formObj, sAction);
				break;
			case COMMAND02:        	// Row Hidden
				rowHideControl(sheetObj);
				break;
			case COMMAND03:        	// Skip Call
				
				/*
				 * 2015.03.04 dongsoo
				 * skip call시 Hours시간 계산
				 * VPS_ETD_DT - PF_ETD_DT의 hour
				 */
				var curRow       = sheetObj.GetSelectRow();
				var etdDelayTime = getDelayTime(sheetObj, curRow, "ETD");	
				
				sheetObj.SetCellValue(curRow, prefix + "delay_date", Math.round(etdDelayTime/60*10)/10, 0);
				
				sUrl="/opuscntr/VOP_VSK_0245.do";
        		ComOpenPopup(sUrl, 700, 298, "returnSkipCallHelp", "none", true);
				break;
			case COMMAND04:        	// Add Call
				var posFlg	= isAddPositionFlag(sheetObj);		// position flag(before/after)
				sUrl="/opuscntr/VOP_VSK_0215.do?virtual_add_call_port_view_flg=Y&pos_flg=" + posFlg+"&virtual_add_call_tgt_flg="+gVtAddCallTargetFlg;
				ComOpenPopup(sUrl, 510, 340, "rtnAddCall", "0,0", true);
				//returnAddCallHelp(sheetObj, rtnObj);
				break;
				
			case COMMAND05:        	// Reverse Call
				reverseCallControl(sheetObj);
				break;
			
			case COMMAND06:        	// Row Hidden Cancel
				rowHideCancel(sheetObj);
				break;
			case COMMAND07:        	// Skip Call Cancel
				skipCallCancel(sheetObj);
				break;
			case COMMAND08:        	// Add Call Cancel
				addCallCancel(sheetObj);
				break;
			case COMMAND09:        	// Reverse Call Change
				reverseCallChange(sheetObj);
				break;
			case COMMAND10:        	// Col Show
				//showFieldControl(sheetObj, formObj, true);
				showFieldControl(sheetObj, formObj, true);
				break;
			case COMMAND11:        	// Col Hidden
				showFieldControl(sheetObj, formObj, false);
				break;
			case COMMAND12:        	// Sheet Change(Coastal SKD/Recovery Plan)
				break;
				if(formObj.rdo_tran[0].checked){
					if(glbSheetFlg != "sheet1"){
						glbSheetFlg="sheet1";
						showSheetForm("sheet1");
						ComBtnDisable("btn_settlement");
					//	ComEnableObject(formObj.btn_sim_no, false);
						document.getElementById("div_remark").style.display="block";
						btnControlByLoadableWeight(sheetObjects[0], sheetObjects[0].GetSelectRow());
					}
				} else {
					if(glbSheetFlg != "sheet2"){
						glbSheetFlg="sheet2";
						showSheetForm("sheet2");
						ComBtnEnable("btn_settlement");
					//	ComEnableObject(formObj.btn_sim_no, true);
						document.getElementById("div_remark").style.display="none";
						btnControlByLoadableWeight(sheetObjects[1], sheetObjects[1].GetSelectRow());
					}
				}
				ComBtnDisable("btn_loadableweight");
				break;
			case COMMAND13:        	// VVD Search
				var vslCd=formObj.vsl_cd.value;
            	if(vslCd == ""){
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 400, 400, "returnVvdHelp", "0,0", true);
            	}
				break;
			case COMMAND14:        	// Simulation No Search
				if(glbSheetFlg == "sheet2"){
            		var sUrl="/opuscntr/VOP_VSK_0201.do?uiFlg=B&vsl_slan_cd="+formObj.vsl_slan_cd.value;
            		ComOpenPopup(sUrl, 800, 490, "returnSimNoHelp", "0,0", true);
				}
				break;
			case COMMAND15:        	// Loadable Weight
				sUrl="/opuscntr/VOP_VSK_0247.do";
        		ComOpenPopup(sUrl, 1130, 526, "returnLoadableHelp", "0,0", true);
				break;
			case COMMAND16:        	// btn_height_big
				glbSheetHeight=SKD_SHEET_SIZE;
				sheetObj.SetSheetHeight(glbSheetHeight);
				break;
			case COMMAND17:        	// btn_height_sml
				glbSheetHeight=PLN_SHEET_SIZE;
				sheetObj.SetSheetHeight(glbSheetHeight);
				break;
//			case COMMAND18:        	// btn_gw_mail_send
//				sendGroupwareMail(sheetObj, formObj);
//				break;
//
//			case COMMAND19:        	// btn_bulletin_board
//				sendGroupwareBoard(sheetObj, formObj);
//				break;
			case COMMAND20:        	// Phase Out
				if(validateForm(sheetObj, formObj, sAction)){
					var sRow=sheetObj.GetSelectRow();
					var param="";
	        		param += "&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
	        		param += "&vsl_cd=" + sheetObj.GetCellValue(sRow, prefix+"vsl_cd");
	        		param += "&voy_no=" + sheetObj.GetCellValue(sRow, prefix+"skd_voy_no");
	        		param += "&dir_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_dir_cd");
	        		param += "&port_cd=" + sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
	        		param += "&phase_type=O";
	        		////::top::////param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, sheetObj.GetSelectCol());
	        		////::top::2015-01-27////param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, "sheet1_clpt_ind_seq");
	        		param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, "sheet1_new_clpt_ind_seq");
	        		param += "&phase_date=" + ComGetNowInfo();
	        		param += "&parentUI=0015";
	        		
					sUrl="/opuscntr/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + param;
	// 				ComOpenPopup(sUrl, 650, 400, "returnPhaseOutHelp", "0,0", true);
	        		ComOpenPopup(sUrl, 650, 217, "getPhaseOutHelp", "0,0", true);
	        		
				}
				break;
				
			case COMMAND21:        	// Phase Out Cancel
				phaseOutCancelControl(sheetObj, formObj);
				break;
			
			case COMMAND22:        	// btn_e_mail_send
				sendMail(sheetObj, formObj);
				break;
			case COMMAND23:        	// PORT TIME CHECK
				formObj.f_cmd.value = COMMAND23;				
				var sParam = FormQueryString(formObj);
				var sXml   = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				
				return sXml;
			case COMMAND24:        	// Vessel Rename
				var param="";
				var sRow=sheetObj.GetSelectRow();
				
        		param += "vsl_cd="  + sheetObj.GetCellValue(sRow, prefix+"vsl_cd");
        		param += "&skd_voy_no=" + sheetObj.GetCellValue(sRow, prefix+"skd_voy_no");
        		param += "&skd_dir_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_dir_cd");
        		param += "&vps_port_cd=" + sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
        		param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, prefix+"clpt_ind_seq");
        		
        		param += "&vsl_renm_old_vsl_cd=" + sheetObj.GetCellValue(sRow, prefix+"vsl_renm_old_vsl_cd");
        		param += "&vsl_renm_old_vsl_eng_nm=" + encodeURIComponent(sheetObj.GetCellValue(sRow, prefix+"vsl_renm_old_vsl_eng_nm"));
        		param += "&vsl_renm_new_vsl_cd=" + sheetObj.GetCellValue(sRow, prefix+"vsl_renm_new_vsl_cd");
        		param += "&vsl_renm_new_vsl_eng_nm=" + encodeURIComponent(sheetObj.GetCellValue(sRow, prefix+"vsl_renm_new_vsl_eng_nm"));
        		param += "&skd_cng_sts_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd");

        		sUrl="/opuscntr/VOP_VSK_9016.do?" + param;
        		
        		ComOpenPopup(sUrl, 620, 446, "returnRenameHelp", "0,0", true);
        		break;
			case COMMAND25:        	// Vessel Slide
				var param="";
				var sRow=sheetObj.GetSelectRow();
				
        		param += "vsl_cd="  + sheetObj.GetCellValue(sRow, prefix+"vsl_cd");
        		param += "&skd_voy_no=" + sheetObj.GetCellValue(sRow, prefix+"skd_voy_no");
        		param += "&skd_dir_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_dir_cd");
        		param += "&vps_port_cd=" + sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
        		param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, prefix+"clpt_ind_seq");
        		param += "&vsld_wks=" + sheetObj.GetCellValue(sRow, prefix+"vsld_wks");
        		param += "&skd_cng_sts_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd");
        		
				sUrl="/opuscntr/VOP_VSK_9017.do?" + param;
        		ComOpenPopup(sUrl, 620, 226, "returnSlideHelp", "0,0", true);
        		
        		break;
			case COMMAND26:        	// phase In
				var param="";
				var sRow=sheetObj.GetSelectRow();
				
        		param += "&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
        		param += "&vsl_cd=" + sheetObj.GetCellValue(sRow, prefix+"vsl_cd");
        		param += "&voy_no=" + sheetObj.GetCellValue(sRow, prefix+"skd_voy_no");
        		param += "&dir_cd=" + sheetObj.GetCellValue(sRow, prefix+"skd_dir_cd");
        		param += "&port_cd=" + sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
        		param += "&phase_type=I";
        		param += "&clpt_ind_seq=" + sheetObj.GetCellValue(sRow, "sheet1_new_clpt_ind_seq");
        		param += "&phase_date=" + ComGetNowInfo();
        		param += "&parentUI=0015";
        		
				sUrl="/opuscntr/VOP_VSK_0205.do?f_cmd=" + COMMAND19 + param;
        		ComOpenPopup(sUrl, 650, 217, "getPhaseInHelp", "0,0", true);
        		
        		break;		
			case COMMAND27:        		// phase In cancel
				phaseInCancelControl	(sheetObj, formObj);
        		break;
        		
			case IBINSERT:      // input
				break;
		}
	}

	/**
	 * Return Call Back function 
	 */
	function getPhaseInHelp( rtnPhaseIn ){
		var formObj=document.form;
		var sheetObj = sheetObjects[0];
		var sRow=sheetObj.GetSelectRow();
		
		if( rtnPhaseIn ){
			
			var prefix=sheetObj.id + "_";

			sheetObj.SetCellValue(sRow, prefix+"phs_io_rsn_cd", rtnPhaseIn.phs_io_rsn_cd, 0);
			sheetObj.SetCellValue(sRow, prefix+"phs_io_rmk", rtnPhaseIn.phs_io_rmk, 0);
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd", "I", 0);
			
			setRowControlBtnSts(sheetObj, sRow);
		}
	}
	
	/**
	 * Return Call Back function 
	 */
	function getPhaseOutHelp( rtnPhaseOut ){
		var formObj=document.form;
		var sheetObj = null;
		if(formObj.rdo_tran[0].checked){
			sheetObj = sheetObjects[0];
		}else{
			sheetObj = sheetObjects[1];
		}
		var sRow=sheetObj.GetSelectRow();
		if( rtnPhaseOut ){
			returnPhaseOutHelp(sheetObj, sRow, rtnPhaseOut);
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
	function validateForm(sheetObj, formObj, sAction){
		
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(sheetObj.id == "sheet1"){
					if(ComIsNull(formObj.vsl_cd.value)){
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.focus();
						return false;
					} else if (formObj.vsl_cd.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.value="";
						formObj.vsl_cd.focus();
						return false;
					} else if(ComIsNull(formObj.skd_voy_no.value)){
						ComShowCodeMessage('VSK00027', "Voyage No.");
					 	formObj.skd_voy_no.focus();
						return false;
					} else if (formObj.skd_voy_no.value.length < 4) {
						ComShowCodeMessage('VSK00027', "Voyage No.");
						formObj.skd_voy_no.value="";
						formObj.skd_voy_no.focus();
						return false;
					} else if(ComIsNull(formObj.skd_dir_cd.value)){
						ComShowCodeMessage('VSK00027', "Direction Code");
						formObj.skd_dir_cd.focus();
						return false;
					}
				}/*else{
					if(formObj.sim_dt.value == ""){
						if(ComIsNull(formObj.vsl_cd.value)){
							ComShowCodeMessage('VSK00027', "Vessel Code");
							formObj.vsl_cd.focus();
							return false;
						} else if (formObj.vsl_cd.value.length < 4) {
							ComShowCodeMessage('VSK00027', "Vessel Code");
							formObj.vsl_cd.value="";
							formObj.vsl_cd.focus();
							return false;
						} else if(ComIsNull(formObj.skd_voy_no.value)){
							ComShowCodeMessage('VSK00027', "Voyage No.");
						 	formObj.skd_voy_no.focus();
							return false;
						} else if (formObj.skd_voy_no.value.length < 4) {
							ComShowCodeMessage('VSK00027', "Voyage No.");
							formObj.skd_voy_no.value="";
							formObj.skd_voy_no.focus();
							return false;
						} else if(ComIsNull(formObj.skd_dir_cd.value)){
							ComShowCodeMessage('VSK00027', "Direction Code");
							formObj.skd_dir_cd.focus();
							return false;
						}
					}
				}*/
				break;
				
			case IBSAVE:      	//save
				var headCnt		= sheetObj.HeaderRows();
				var rowCnt		= sheetObj.RowCount();
				var totCnt		= getTotalRowCnt(sheetObj);
				var prefix		= sheetObj.id + "_";
				
				//Remark Check...
				if(formObj.skd_rmk.value.length > 4000){
					ComShowCodeMessage('VSK01019', "Remark");
					formObj.skd_rmk.focus();
					return false;
				}
				
				if(rowCnt > 0){
					var turnVoyNo	= "";
					var turnDirCd	= "";
					var vvd			= "";
					var chkTurnVoyNo= "";
					var chkTurnDirCd= "";
					var chkVvd		= "";
					
					for(var i=headCnt; i<=totCnt; i++){
						
						//Don't Checking Total Row, and deleted port(phase out)
						if(sheetObj.GetCellValue(i, prefix+"vvd") != "" && sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") != "H"){
							if(sheetObj.GetCellValue(i, prefix+"vsl_cd").length < 4){
								ComShowCodeMessage('VSK00027', "Vessel Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_voy_no").length < 4){
								ComShowCodeMessage('VSK00027', "Voyage No.");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_dir_cd").length < 1){
								ComShowCodeMessage('VSK00027', "Direction Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							//Port Code Check...
							if(sheetObj.GetCellValue(i, prefix+"vps_port_cd").length < 5){
								ComShowCodeMessage('VSK00027', "Port Code");
								sheetObj.SelectCell(i, prefix+"vps_port_cd");
								return false;
							}
//By Hwang 							
							//Distance Check...
							if(sheetObj.GetCellValue(i, prefix+"lnk_dist").length > 6){
								ComShowCodeMessage('VSK01019', "Distance");
								sheetObj.SelectCell(i, prefix+"lnk_dist");
								return false;
							}
							//Speed Check...
							if(String(parseInt(sheetObj.GetCellValue(i, prefix+"lnk_spd"))).length > 4){
								ComShowCodeMessage('VSK01019', "Speed");
								sheetObj.SelectCell(i, prefix+"lnk_spd");
								return false;
							}
							//Port Time Check...
							if(String(parseInt(sheetObj.GetCellValue(i, prefix+"act_wrk_hrs"))).length > 4){
								ComShowCodeMessage('VSK01019', "Port Time");
								sheetObj.SelectCell(i, prefix+"act_wrk_hrs");
								return false;
							}
							//Port Buffer Time Check...
							if(String(parseInt(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))).length > 4){
								ComShowCodeMessage('VSK01019', "Port Buffer Time");
								sheetObj.SelectCell(i, prefix+"port_buf_hrs");
								return false;
							}
							//Sea buffer Time Check...
							//alert((sheetObj.CellValue(i, prefix+"sea_buf_hrs")).length);
							if(String(parseInt(sheetObj.GetCellValue(i, prefix+"sea_buf_hrs"))).length > 4){
								ComShowCodeMessage('VSK01019', "Sea Buffer Time");
								sheetObj.SelectCell(i, prefix+"sea_buf_hrs");
								return false;
							}
							//Terminal Code Check...
							var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
							if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
								if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
									if(sheetObj.GetCellValue(i, prefix+"tml_cd") == ""){
										ComShowCodeMessage("VSK00027", "Terminal Code");
										sheetObj.SelectCell(i, prefix+"tml_cd");
										return false;
									}else{
										if(sheetObj.GetCellValue(i, prefix+"tml_cd").length < 2){
											ComShowCodeMessage("VSK00027", "Terminal Code");
											sheetObj.SelectCell(i, prefix+"tml_cd");
											return false;
										}
									}
								}
							}
							//in case Turn Indicator is Y, mandatory input
							if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
//								if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no"))){
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								} else if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))) {
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								}
								if(ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd"))){
									ComShowCodeMessage("VSK00033", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
									// in case turn_port_flg is 'Y', turn_skd_voy_no and turn_skd_dir_cd are Null, Then change state to Editable
									turnEditChange(sheetObj);
									sheetObj.SetColHidden(prefix+"turn_skd_voy_no",0);
									sheetObj.SetColHidden(prefix+"turn_skd_dir_cd",0);
									sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
									return false;
								}
								//in case Turn Indicator is Y, Checking Turn VVD is same
								turnVoyNo	= sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no");
								turnDirCd	= sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd");
								vvd			= sheetObj.GetCellValue(i, prefix+"vvd");
								if(chkTurnVoyNo == ""){
									chkTurnVoyNo= turnVoyNo;
									chkTurnDirCd= turnDirCd;
									chkVvd		= vvd;
								}else{
									if(turnVoyNo != chkTurnVoyNo && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}else if(turnDirCd != chkTurnDirCd && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}
								}
							}
							//Checking ETA date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//Checking ETB date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//Checking ETD date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							//ETA < ETB < ETD < Next ETA
							//if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S" && sheetObj.GetRowStatus(i) != "D"){
								if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") < sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
									if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") < sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
										if(i<totCnt){

											var nxtRow	= getNotSkipRow(sheetObj, i, "N");
											
											//::FOR.NYK.START::by dongsoo:2014-09-17:://
											//P/O 이후 Add 하면 hidden 처리된 데이터와 Validation Check함  h된 데이터는 체크 하지 않음 
											//Apia to Pago Pago 간의 local time 역전현상에 대해 하드코딩으로 수정											
											var curTimeDiff = sheetObj.GetCellValue(i, prefix+"time_diff");
											var nxtTimeDiff = sheetObj.GetCellValue(nxtRow, prefix+"time_diff");
											
											if (sheetObj.GetCellValue(nxtRow, prefix+"tmp_phase_flag") != "H") {
												
												if (sheetObj.GetCellValue(i, prefix+"vps_port_cd") != "WSAPW" || sheetObj.GetCellValue(nxtRow, prefix+"vps_port_cd") != "ASPPG") {
													
													//::2015-10-29:by TOP:://if(sheetObj.GetCellValue(i, prefix+"vps_etd_dt") >= sheetObj.GetCellValue(nxtRow, prefix+"vps_eta_dt")){
													if	(		sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "O"
															&&	(sheetObj.GetCellValue(i, prefix+"vps_etd_dt") >= sheetObj.GetCellValue(nxtRow, prefix+"vps_eta_dt")
														    &&  nxtRow>0 )//2015.11.02 nxtRow = -1 인경우는 다음 비교 대상이 없을때
														)
													{
														ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
														sheetObj.SelectCell(i, prefix+"vps_etd_dt");
														return false;
													}
													
												} else {
													
													var vpsEtdObj = new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etd_dt"));
													var vpsEtaObj = new Usr_CalcTimeSet(sheetObj.GetCellValue(nxtRow, prefix+"vps_eta_dt"));
													
													var etaDate = vpsEtaObj.getAddDate();
													var etdDate = vpsEtdObj.getAddDate();
													
													formObj.vps_port_cd.value = sheetObj.GetCellValue(nxtRow, prefix+"vps_port_cd");
													formObj.act_arr_dt.value  = etaDate;
													formObj.pre_port_cd.value = sheetObj.GetCellValue(i, prefix+"vps_port_cd");
													formObj.pre_etd_dt.value  = etdDate;
													
													if(!isPortTimeCheck(sheetObj, formObj)) {
														ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
														sheetObj.SelectCell(i, prefix+"vps_etd_dt");
														return false;
													}
													
												}
											}
											//::FOR.NYK.FINISH::by dongsoo:2014-09-17:://
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
							
							//Delay Date Check
							/*
							 * Expand >> Delay Check X 
							 * Hidden >> Delay Check
							 * Row Hidden >> Delay Check X 
							 * Editable false >> Delay Check X 
							 * Actual >> Delay Check X
							 * 
							 */
							if(sheetObj.id == "sheet1"){
								//Hidden - Delay Check
//	 							if(!sheetObj.ColHidden(prefix+"lnk_dist")){
									// Row Hidden >> Delay Check X
									if(!sheetObj.GetRowHidden(i)){
										//Skip >> Delay Check X
										if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
										//Editable false >> Delay Check X
//	 									if(sheetObj.CellEditable(i, prefix+"vsl_dlay_rsn_cd")){
											// except Virtual Port
//	 										var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
//	 										if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
											// Actual >> Delay Check X
												if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") != "X" && sheetObj.GetCellValue(i, prefix+"act_inp_flg") != "Y"){
//												if(sheetObj.CellValue(i, prefix+"dlay_date_text") != ""){
												//OLD : if(sheetObj.CellValue(i, prefix+"sea_date_text") != ""){
												// Returning color
													sheetObj.SetCellBackColor(i, prefix+"vsl_dlay_rsn_cd",sheetObj.GetCellBackColor(i, prefix+"sea_date_text"));
												
													//::2015-04-19:by TOP:://if(getSeaDlayTime(sheetObj, i) >= gSkdBuffTimeCode ){
													if(getSeaDlayTime(sheetObj, i) >= gSkdBuffTimeCode && sheetObj.GetCellValue(i, prefix+"sea_date_text") != ""){
														if(sheetObj.GetCellValue(i, prefix+"vsl_dlay_rsn_cd") == ""){
															ComShowCodeMessage			("VSK00027", "Delay Date");
															sheetObj.SetCellBackColor	(i, prefix+"vsl_dlay_rsn_cd", glbEditColor);
															sheetObj.SelectCell			(i, prefix+"vsl_dlay_rsn_cd");
															return false;
														}
													}
												}
										}
									}
//								}
							}
						}
							
					}
					
					
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
						if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"  && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
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
						var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
	 					var etdChk=ComGetEtcData(sXml, "etd_chk");
	 					
	 					if(etdChk == "N"){
	 						ComShowCodeMessage("VSK00055", formatDate(new Date(getDateFromFormat(vpsEtaDt, "yyyyMMddHHmm")), "yyyy-MM-dd HH:mm"));
	 						return false;
	 					}
	 					
					}
				}else{
					ComShowCodeMessage("VSK00020");
					return false;
				}
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "[Lane Code]");
// 					formObj.vsl_slan_cd.value = "";
// 					formObj.vsl_slan_cd.focus();
					return false;
				}
				formObj.skd_rmk.value = VopAsciiRemove(formObj.skd_rmk.value);
				break;
				
			case COMMAND01:      //settlement 
				var headCnt=sheetObj.HeaderRows();
				var rowCnt=sheetObj.RowCount();
				var totCnt=getTotalRowCnt(sheetObj);
				var prefix=sheetObj.id + "_";
				if(rowCnt > 0){
					var turnVoyNo="";
					var turnDirCd="";
					var vvd="";
					var chkTurnVoyNo="";
					var chkTurnDirCd="";
					var chkVvd="";
					for(var i=headCnt; i<=totCnt; i++){
						//Don't Checking Total Row, and deleted port(phase out)
						if(sheetObj.GetCellValue(i, prefix+"vvd") != "" && sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") != "H"){
							if(sheetObj.GetCellValue(i, prefix+"vsl_cd").length < 4){
								ComShowCodeMessage('VSK00027', "Vessel Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_voy_no").length < 4){
								ComShowCodeMessage('VSK00027', "Voyage No.");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							if(sheetObj.GetCellValue(i, prefix+"skd_dir_cd").length < 1){
								ComShowCodeMessage('VSK00027', "Direction Code");
								sheetObj.SelectCell(i, prefix+"vvd");
								return false;
							}
							//Port Code Check...
							if(sheetObj.GetCellValue(i, prefix+"vps_port_cd").length < 5){
								ComShowCodeMessage('VSK00027', "Port Code");
								sheetObj.SelectCell(i, prefix+"vps_port_cd");
								return false;
							}
							//Terminal Code Check...
							var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
							if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
								if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
									if(sheetObj.GetCellValue(i, prefix+"tml_cd") == ""){
										ComShowCodeMessage("VSK00027", "Terminal Code");
										sheetObj.SelectCell(i, prefix+"tml_cd");
										return false;
									}else{
										if(sheetObj.GetCellValue(i, prefix+"tml_cd").length < 2){
											ComShowCodeMessage("VSK00027", "Terminal Code");
											sheetObj.SelectCell(i, prefix+"tml_cd");
											return false;
										}
									}
								}
							}
							//in case Turn Indicator is Y, mandatory input
							if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
//								if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no"))){
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								} else if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))) {
//									ComShowCodeMessage("VSK00033", sheetObj.CellValue(i, prefix+"vps_port_cd"));
//									sheetObj.SelectCell(i, prefix+"turn_port_flg");
//									return false;
//								}
								if(ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd"))){
									ComShowCodeMessage("VSK00033", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
									// in case turn_port_flg is 'Y', turn_skd_voy_no and turn_skd_dir_cd are Null, Then change state to Editable
									turnEditChange(sheetObj);
									sheetObj.SetColHidden(prefix+"turn_skd_voy_no",0);
									sheetObj.SetColHidden(prefix+"turn_skd_dir_cd",0);
									sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
									return false;
								}
								//in case Turn Indicator is Y, Checking Turn VVD is same
								turnVoyNo=sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no");
								turnDirCd=sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd");
								vvd=sheetObj.GetCellValue(i, prefix+"vvd");
								if(chkTurnVoyNo == ""){
									chkTurnVoyNo=turnVoyNo;
									chkTurnDirCd=turnDirCd;
									chkVvd=vvd;
								}else{
									if(turnVoyNo != chkTurnVoyNo && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}else if(turnDirCd != chkTurnDirCd && vvd == chkVvd){
										ComShowCodeMessage("VSK00034", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
										sheetObj.SelectCell(i, prefix+"turn_port_flg");
										return false;
									}
								}
							}
							//Checking ETA date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_eta_dt")) == false){
								return false;
							}
							//Checking ETB date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etb_dt")) == false){
								return false;
							}
							//Checking ETD date format
							if(VskIsDateValid(sheetObj, i, sheetObj.SaveNameCol(prefix+"vps_etd_dt")) == false){
								return false;
							}
							//ETA < ETB < ETD < Next ETA
							//if(!sheetObj.RowHidden(i) && sheetObj.CellValue(i, prefix+"skd_cng_sts_cd") != "S"){
							if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
								if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") < sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
									if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") < sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
										if(i<totCnt){
											var nxtRow=getNotSkipRow(sheetObj, i, "N", true);
											if(nxtRow > 0){
												if(sheetObj.GetCellValue(i, prefix+"vps_etd_dt") < sheetObj.GetCellValue(nxtRow, prefix+"vps_eta_dt")){
													//pass
												}else{
													ComShowCodeMessage("VSK00032", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
													sheetObj.SelectCell(i, prefix+"vps_etd_dt");
													return false;
												}
											}
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
							//Delay Date Check
							/*
							 * Expand >> Delay Check X 
							 * Hidden >> Delay Check
							 * Row Hidden >> Delay Check X 
							 * Editable false >> Delay Check X 
							 * Actual >> Delay Check X
							 * 
							 */
							if(sheetObj.id == "sheet1"){
								//Hidden - Delay Check
//	 							if(!sheetObj.ColHidden(prefix+"lnk_dist")){
									// Row Hidden >> Delay Check X
									if(!sheetObj.GetRowHidden(i)){
										//Skip >> Delay Check X
										if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
										//Editable false >> Delay Check X
//	 									if(sheetObj.CellEditable(i, prefix+"vsl_dlay_rsn_cd")){
											// except Virtual Port
//	 										var turnPortIndCd = sheetObj.CellValue(i, prefix+"turn_port_ind_cd");
//	 										if(turnPortIndCd != "D" && turnPortIndCd != "V" && turnPortIndCd != "F"){
											// Actual >> Delay Check X
											if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") != "X" && sheetObj.GetCellValue(i, prefix+"act_inp_flg") != "Y"){
//												if(sheetObj.CellValue(i, prefix+"dlay_date_text") != ""){
												//
												//OLD : if(sheetObj.CellValue(i, prefix+"sea_date_text") != ""){
												// Returning color
												sheetObj.SetCellBackColor(i, prefix+"vsl_dlay_rsn_cd",sheetObj.GetCellBackColor(i, prefix+"sea_date_text"));
												if(getSeaDlayTime(sheetObj, i) >= gSkdBuffTimeCode){
													if(sheetObj.GetCellValue(i, prefix+"vsl_dlay_rsn_cd") == ""){
														ComShowCodeMessage("VSK00027", "Delay Date");
														sheetObj.SetCellBackColor(i, prefix+"vsl_dlay_rsn_cd",glbEditColor);
														sheetObj.SelectCell(i, prefix+"vsl_dlay_rsn_cd");
														return false;
													}
												}
											}
										}
									}
//								}
							}
						}
					}
					
				}else{
					ComShowCodeMessage("VSK00020");
					return false;
				}
				
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "[Lane Code]");
// 					formObj.vsl_slan_cd.value = "";
// 					formObj.vsl_slan_cd.focus();
					return false;
				}
				break;	
				
			case COMMAND20:      // Phase Out
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
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		if(validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value=SEARCH;
			if (sheetID == "sheet1"){
				formObj.rtv_flg.value="N";
			}/*else{
				//Dividing Simulation data to Retrieve or not
				if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
					formObj.rtv_flg.value="N";
				}else{
					formObj.rtv_flg.value="Y";
				}
			}*/
			var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			setTimeout(function(){
				var sXml=sheetObj.GetSearchData("VOP_VSK_0015GS.do", sParam);
				ComOpenWait(false);
				showSheetData(sheetObj, formObj, sXml);
				// clpt_ind_seq reset
				resetClptIndSeq(sheetObj);
	        },300);
 			
		}
	}
	
	
	/**
	 * Save
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionSave(sheetObj, formObj, sAction){
		
		var sheetID		= sheetObj.id;
		var prefix		= sheetID + "_";
		
		if(validateForm(sheetObj, formObj, sAction)){
			
			var headCnt	= sheetObj.HeaderRows();
			var totCnt	= getTotalRowCnt(sheetObj);
			
			// to delete phase out data
			for(var i=headCnt; i<=totCnt; i++){
				
				//alert('headCnt ['+headCnt+'] totCnt ['+totCnt+'] i ['+i+'] tmp_phase_flag ['+sheetObj.GetCellValue(i, prefix+"tmp_phase_flag")+']');
				//::2015-10-27:by TOP:://
				
				if(sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") == "H"){
//					sheetObj.CellValue2(i, prefix+"ibflag") = "D";
					sheetObj.SetRowStatus(i,"D");
				}
			}
			
			
			if (sheetID == "sheet1" && sAction == IBSAVE){
				
				// Sheet1 Save
				formObj.f_cmd.value	= MULTI;
//				pickPfData(sheetObj);
				var sParam			= ComGetSaveString(sheetObjects, true);
				if (sParam == "") 	return;
				
				sParam 				+= "&" + FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				
				ComOpenWait(true);
				setTimeout(function(){
	 				var sXml	= sheetObj.GetSaveData("VOP_VSK_0015GS.do", sParam);
					ComOpenWait(false);
					
					var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
					if (nodeText == "S") {
						sheetObj.LoadSaveData	(sXml);
						doActionSearch			(sheetObj, formObj, IBSEARCH);
					} else if (nodeText == "F") {
						var msgNode  = ComGetSelectSingleNode(sXml, "MESSAGE");
						var firIndex = msgNode.lastIndexOf("ACT:");
						var lasIndex = msgNode.lastIndexOf(":ACT");
						if (firIndex > 0) {
							msgNode = msgNode.substring(firIndex+4, lasIndex).replace(/:/gi, "\n");						
							ComShowCodeMessage("VSK55006", msgNode);
						} else {
							sheetObj.LoadSaveData(sXml);
						}
					}
					
		        },300);				


 				//var nodeText=VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
				//if(nodeText == "OK"){
				
			}/*else if(sheetID == "sheet2"){
				if(sAction == IBSAVE){
					// Sheet2 Save
					formObj.f_cmd.value=MULTI01;
				}else if(sAction == COMMAND01){
					// Settlement
					formObj.f_cmd.value=MULTI02;
				}else{
					return false;
				}
				if(formObj.sim_dt.value == ""){
					//Changing ibflag to 'I' for putting Simulation Table
					for(var i=headCnt; i<=totCnt; i++){
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//							sheetObj.CellValue2(i, prefix+"ibflag") = "I";
//						}
						if(sheetObj.GetRowStatus(i) != "D"){
							sheetObj.SetRowStatus(i,"I");
						}
					}
				}else{
					for(var i=headCnt; i<=totCnt; i++){
//						if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//							sheetObj.CellValue2(i, prefix+"ibflag") = "U";
//						}
						if(sheetObj.GetRowStatus(i) != "D"){
							sheetObj.SetRowStatus(i,"U");
						}
					}
					formObj.vsl_cd.value=glbMainVslCd;
					formObj.skd_voy_no.value=glbMainSkdVoyNo;
			    	formObj.skd_dir_cd.value=glbMainSkdDirCd;
				}
				var sParam=ComGetSaveString(sheetObjects, true);
				if (sParam == "") return;
				sParam += "&" + FormQueryString(formObj);
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
 				var sXml=sheetObj.GetSaveData("VOP_VSK_0015GS.do", sParam);
				ComOpenWait(false);
 				sheetObj.LoadSaveData(sXml);
				var rootNode=VskGetXmlRootNode(sXml);
				var errDataNode=rootNode.selectSingleNode("//ERROR");
				if(!errDataNode){
					//simulation no. reset
					if(formObj.sim_dt.value == ""){
						setDisplaySimNo(sheetObj, formObj, sXml);
					}
				}
				var nodeText=VskGetXmlSelectSingleNodeText(sXml, "TR-ALL");
				if(nodeText == "OK"){
					doActionSearch(sheetObj, formObj, IBSEARCH);
				}
			}*/
		}
	}
	
	
    /**
     * process after retrieve.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
		
    	var prefix		= sheetObj.id + "_";
    	var currVvd		= formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
    	var currVvdRow	= null;
    	var currVvdFlg	= true;
    	var rowHdnFlg	= false;
    	
    	// Saving Retrieved VVD
    	glbMainVslCd	= formObj.vsl_cd.value;
    	glbMainSkdVoyNo	= formObj.skd_voy_no.value;
    	glbMainSkdDirCd	= formObj.skd_dir_cd.value;
    	glbTmlFlg		= "N";
    	
    	if(sheetObj.GetColHidden(prefix+"turn_skd_voy_no") == 0) {
    		sheetObj.SetColHidden(prefix+"turn_skd_voy_no", 1);
    		sheetObj.SetColHidden(prefix+"turn_skd_dir_cd", 1);
    	}
    	
		if(sXml != null){
			var rootNode=VskGetXmlRootNode(sXml);
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(dataNode){
				if(dataNode > 0  ){
					var bgRgbColors = new Array("#FFFF3C", "#FFFFA5", null, "#BBC4F7", "#677BED");
					
					glbMainVslEngNm=ComGetEtcData(sXml, "vsl_eng_nm");
					
					var dlayRsnCd=ComGetEtcData(sXml, "dlay_rsn_cd");	// Delay Reason Code
					var dlayRsnNm=ComGetEtcData(sXml, "dlay_rsn_nm");	// Delay Reason Name
					sheetObj.SetColProperty(prefix+"vsl_dlay_rsn_cd", {ComboText:"|"+dlayRsnNm, ComboCode:"|"+dlayRsnCd} );
					
					var chgStsCds=ComGetEtcData(sXml, "chg_sts_cd");	// Change Status Code
// 					var chgStsNms = ComReplaceStr(ComGetEtcData(sXml, "chg_sts_nm"), " calling", ""); //Change Status CodeName
					var chgStsNms=ComGetEtcData(sXml, "chg_sts_nm"); 	// Change Status CodeName.
					
					sheetObj.SetColProperty(prefix+"skd_cng_sts_cd", {ComboText:"|"+chgStsNms, ComboCode:"|"+chgStsCds} );
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					
					initPortDataFlg(sheetObj);
					if(glbSheetFlg == "sheet1"){
						//Remark Setting.
						setRemarkCombo(sheetObj, formObj);
						// pf_tztm_hrs > tmp_tztm_hrs, pf_act_wrk_hrs > tmp_act_wrk_hrs
						setTmpHrs(sheetObj);
					}
					var headCnt=sheetObj.HeaderRows();
					var rowCnt=sheetObj.RowCount();
					var totCnt=getTotalRowCnt(sheetObj);
					var ydCds=ComGetEtcData(sXml, "tml_cd").split("|");
					var vvdIdx=getVvdCnt(sheetObj);
					var boundIdx=2;
					if(vvdIdx == 3){
						boundIdx=1;
					}else if(vvdIdx == 4){
						boundIdx=0;
					}else if(vvdIdx == 5){
						boundIdx=0;
					}
					//sheet2
					/*if(formObj.sim_dt.value != ""){
						setSimulationForm(sheetObj, formObj);	//Simulation Retrieve Setting.
						currVvd=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
						// Saving Retrieved VVD
				    	glbMainVslCd=formObj.vsl_cd.value;
				    	glbMainSkdVoyNo=formObj.skd_voy_no.value;
				    	glbMainSkdDirCd=formObj.skd_dir_cd.value;
					}*/
					

					/**=====================================================================
					 * Actual SKD 생성 Port 이전의 Ports에 대해 수정불가처리
					 * 2015-04-20 by TOP
					 * =====================================================================
					 */
					
					//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
					//2015-09-30
					
					var headCnt				= sheetObj.HeaderRows();
					var totCnt				= getTotalRowCnt(sheetObj);
					var	tmpUpdStatus		= null;
					var tmpLastRowActSkd	= 0;
					
					for(var i=totCnt; i>=headCnt; i--){
						
						tmpUpdStatus	= sheetObj.GetCellValue		(i, prefix+"upd_sts");
						if(tmpUpdStatus == "Actual"){
							tmpLastRowActSkd	= i;
							//alert('min act seq ['+tmpLastRowActSkd+']');
							break;
						}
					}					

					/**=====================================================================
					 * =====================================================================
					 */
					
					var sVvd=sheetObj.GetCellValue(headCnt, prefix+"vvd");
					// ydCds.length = sheetObj.RowCount
					for(var i=headCnt; i<=totCnt; i++) {

						/**=====================================================================
						 * Actual SKD 생성 Port 이전의 Ports에 대해 수정불가처리
						 * =====================================================================
						 */						
						
						if(i<tmpLastRowActSkd){
							sheetObj.SetRowEditable(i, 0);	//:: Row Diabled :://
							
						/** Add logic for e-Commerce Indicator **/
						}else{
							
							if(		sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd")	!= "D"
								&&	sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd")	!= "V"
								&&	sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd")	!= "F"	
								&&	(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") 	== "A" || sheetObj.GetCellValue(i, prefix+"add_call_flg") == "Y")
								&&	sheetObj.GetCellValue(i, prefix+"vt_add_call_flg") 	!= "Y" )
							{
								sheetObj.SetCellEditable(i, prefix+"add_call_xter_flg",1);
							}else{
								sheetObj.SetCellEditable(i, prefix+"add_call_xter_flg",0);
							}
						}
						
						//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
						//2015-09-30

//						var tmpUpdStatus	= sheetObj.GetCellValue		(i, prefix+"upd_sts");
//						if(tmpUpdStatus == "Actual"){
//							sheetObj.SetRowEditable(i, 0);	//:: Row Diabled :://
//						}
						
						/**=====================================================================
						 * =====================================================================
						 */
						
						//Terminal Code Setting.
						sheetObj.CellComboItem(i,prefix+"tml_cd", {ComboText:ydCds[i-headCnt], ComboCode:ydCds[i-headCnt]} );
						sheetObj.SetCellValue(i, prefix+"tml_cd",ydCds[i-headCnt],0);
						var turnPortIndCd=sheetObj.GetCellValue(i, prefix+"turn_port_ind_cd");
			    		if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//					    	in case TURN_PORT_IND_CD is in (D, V, F), ETA, ETB, ETD are editable
			    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg"	,0);
			    			sheetObj.SetCellEditable(i, prefix+"skd_cng_sts_cd"	,0);
			    			
			    			sheetObj.SetCellEditable(i, prefix+"ib_cssm_voy_no"	,0);
			    			sheetObj.SetCellEditable(i, prefix+"ob_cssm_voy_no"	,0);
			    		}
						//Row Color Setting...
			    		if(sVvd != sheetObj.GetCellValue(i, prefix+"vvd")){
			    			boundIdx++;
			    			sVvd=sheetObj.GetCellValue(i, prefix+"vvd");
			    		}
			    		//Changing Row Back Color per bound
			    		if(bgRgbColors[boundIdx] != null){
			    			sheetObj.SetRowBackColor(i,bgRgbColors[boundIdx]);
			    		}
			    		//Finding Retrieved VVD
			    		if(sheetObj.GetCellValue(i, prefix+"vvd") == currVvd && currVvdFlg){
			    			currVvdRow=i;
			    			currVvdFlg=false;
			    			sheetObj.SetCellValue(i, prefix+"tmp_bkg_valid","");
			    		}
						if(glbSheetFlg == "sheet1"){
				    		//FontColor Setting...
							if(sheetObj.GetCellValue(i, prefix+"eta_delay_flg") == "A"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbAdvanceFontColor);
							}else if(sheetObj.GetCellValue(i, prefix+"eta_delay_flg") == "D"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbDelayFontColor);
				    		}
							if(sheetObj.GetCellValue(i, prefix+"etb_delay_flg") == "A"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbAdvanceFontColor);
							}else if(sheetObj.GetCellValue(i, prefix+"etb_delay_flg") == "D"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
				    		}
							if(sheetObj.GetCellValue(i, prefix+"etd_delay_flg") == "A"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbAdvanceFontColor);
							}else if(sheetObj.GetCellValue(i, prefix+"etd_delay_flg") == "D"){
 				    			sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
				    		}
				    		//[Updated Status] Color Setting...
							if(sheetObj.GetCellValue(i, prefix+"upd_sts") == "Actual"){
				    			sheetObj.SetCellBackColor(i, prefix+"upd_sts",glbActualColor);
				    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
							} else if (sheetObj.GetCellValue(i, prefix+"upd_sts") == "HQ/RSO") {
				    			sheetObj.SetCellBackColor(i, prefix+"upd_sts",glbHQColor);
							} else if (sheetObj.GetCellValue(i, prefix+"upd_sts") == "Noon") {
					    		sheetObj.SetCellBackColor(i, prefix+"upd_sts",glbNoonColor);
							} else if (sheetObj.GetCellValue(i, prefix+"upd_sts") == "Departure") {
					    		sheetObj.SetCellBackColor(i, prefix+"upd_sts",glbDepartureColor);
							} else if (sheetObj.GetCellValue(i, prefix+"upd_sts") == "Initial") {
					    		sheetObj.SetCellBackColor(i, prefix+"upd_sts",glbInitialColor);
				    		}
							if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "A"){
				    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"skd_cng_sts_cd",0);
							} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "B") {
				    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"skd_cng_sts_cd",0);
							} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D") {
//					    		sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etd_dt") = false;
//					    			
//					    		sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"tml_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
				    			sheetObj.SetRowEditable(i,0);
				    		}
							
							/** adding virtual add calling flag **/
							if(sheetObj.GetCellValue(i, prefix+"vt_add_call_flg") == "Y"){
								sheetObj.SetCellFontColor(i, prefix+"skd_cng_sts_cd", gVtAddCallFontColor);
							}
							/*****************************************************************************/
							
								
						} else if (glbSheetFlg == "sheet2") {
							if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "A"){
				    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vvd",0);
				    			sheetObj.SetCellEditable(i, prefix+"skd_cng_sts_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
								} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "B") {
				    			sheetObj.SetCellEditable(i, prefix+"vps_eta_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_etb_dt",0);
				    			sheetObj.SetCellEditable(i, prefix+"vvd",0);
				    			sheetObj.SetCellEditable(i, prefix+"skd_cng_sts_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"turn_port_flg",0);
				    			sheetObj.SetCellEditable(i, prefix+"vps_port_cd",0);
				    			sheetObj.SetCellEditable(i, prefix+"tml_cd",0);
								} else if(sheetObj.GetCellValue(i, prefix+"port_skd_sts_cd") == "D") {
//					    		sheetObj.CellEditable(i, prefix+"vps_eta_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etb_dt") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_etd_dt") = false;
//					    			
//					    		sheetObj.CellEditable(i, prefix+"vvd") = false;
//					    		sheetObj.CellEditable(i, prefix+"skd_cng_sts_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"turn_port_flg") = false;
//					    		sheetObj.CellEditable(i, prefix+"vps_port_cd") = false;
//					    		sheetObj.CellEditable(i, prefix+"tml_cd") = false;
				    			sheetObj.SetRowEditable(i,0);
				    		}
				    		//When Simulation Retrieve, if data is 'Y', Hidden that row
								if(sheetObj.GetCellValue(i, prefix+"usr_hdn_flg") == "Y"){
				    			sheetObj.SetRowHidden(i,1);
				    			rowHdnFlg=true;
				    		}
						}// end sheet2
			    		if(getSeaDlayTime(sheetObj, i) >= gSkdBuffTimeCode){
				    		sheetObj.SetCellValue(i, prefix+"sea_date_text", calcSeaDlayTime(sheetObj, i),0);
			    		}else{
			    			sheetObj.SetCellValue(i, prefix+"sea_date_text","",0);
			    			sheetObj.SetCellValue(i, prefix+"vsl_dlay_rsn_cd","",0);
			    			sheetObj.SetCellValue(i, prefix+"vsl_dlay_rsn_desc","",0);
			    		}
			    		sheetObj.SetCellValue(i, prefix+"ofc_inp_flg","Y");
			    		
			    		// before last Actual Port, not editable
			    		//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
			    		//2015-09-30
//			    		if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") == "X" && sheetObj.GetCellValue(i, prefix+"upd_sts") == "Actual"){
//			    			sheetObj.SetRowEditable(i,0);
//			    		}
			    		if(sheetObj.GetCellValue(i, prefix+"bfr_act_flg") == "X"){
			    			sheetObj.SetRowEditable(i,0);
			    		}
			    		
						/* ================================================================================================
						 * Setup Editable Status for Sea/Port Buffer Hours
						 * 2015.04.02 by TOP
						 * ================================================================================================ 
						 */
			    		fnControlSeaPortBufferCell(sheetObj, i);						
						////////////////////////////////////////////////////////////////////////////////////////////////////			    		
			    		
					}// end for
					
					initButton(sheetObj);
					if(glbSheetFlg == "sheet1"){
						ComBtnEnable("btn_row_hide_1");
						ComSetDisplay("btn_row_hide_1", true);
						ComSetDisplay("btn_row_hide_cancel_1", false);
					}else{
 						sheetObj.SetSumText(0, prefix+"clpt_seq"," ");
 						sheetObj.SetSumText(0, prefix+"add_bnk_csm_qty","Total Cost");
// 						sheetObj.SumText(0, prefix+"ib_cgo_qty") = "Total Cost";//sheetObj.ShowSum();
// 						sheetObj.SumText(0, prefix+"ob_cgo_qty") = "Total Cost";
						ComBtnEnable("btn_row_hide_2");
						ComSetDisplay("btn_row_hide_2", true);
		    			if(rowHdnFlg){
		    				ComBtnEnable("btn_row_hide_cancel_2");
		    			}
		    			calcTotalCost(sheetObj);
					}
					sheetObj.SetCellEditable(headCnt, prefix+"vsl_dlay_rsn_cd",0);
// 					sheetObj.CellBackColor(headCnt, prefix+"sea_date_text") = glbInitialColor;
// 					sheetObj.CellBackColor(headCnt, prefix+"vsl_dlay_rsn_cd") = glbInitialColor;
					// clpt_seq reset
					resetClptSeq(sheetObj);
					
					// Handling Button Activate or not
					setRowControlBtnSts(sheetObj, sheetObj.GetSelectRow());
					sheetObj.RenderSheet(1);
					for(var i=headCnt; i<=totCnt; i++) {
						//Skip Port : not editable
						if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
			    			sheetObj.SelectCell(i, 1);
			    			sheetObj.SetRowEditable(i,0);
			    			fontColorChangeBySkip(sheetObj, i);
			    		}
					}
					if(currVvdRow != null && currVvdRow != undefined && currVvdRow != ""){
						sheetObj.SelectCell(currVvdRow, 1);
						setFormData(sheetObj, currVvdRow, 1);
						glbMainVslSlanCd=formObj.vsl_slan_cd.value;
					}
				}else{
					//sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					//sheetObj.RenderSheet(1);
				}
			}
		}
		glbTmlFlg="Y";
    }
    
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */    
    function fnControlSeaPortBufferCell(sheetObj, row){
    	
    	var prefix				= sheetObj.id + "_";
    	var isDisabledBufferCol	= false;
    	
    	var	bgColor		= sheetObj.GetCellFontColor	(row, prefix+"vps_etd_dt"	);
    	var	updStatus	= sheetObj.GetCellValue		(row, prefix+"upd_sts"		);
    	
    	if(bgColor == "#ff0000" || updStatus == "Actual"){
    		isDisabledBufferCol	= true;	//<<glbDelayFontColor : "#ff0000", glbAdvanceFontColor : "#0000ff">>//
    	}
    	
    	//alert('bg color <<'+bgColor+'>>  update status <<'+updStatus+'>> disabled coloum is ['+isDisabledBufferCol+'] ['+row+']'); //sheetObj.GetCellFontColor(Row, i)
    	
		/* ================================================================================================
		 * Setup Editable Status for Sea/Port Buffer Hours
		 * 2015.04.02 by TOP
		 * ================================================================================================ 
		 */
		if(sheetObj.GetCellValue(row, prefix+"auto_skd_cng_flg") == "0"){
			
			////if(sheetObj.GetCellValue(row, prefix+"etd_delay_flg") == "D"){
			if(isDisabledBufferCol){
				sheetObj.SetCellEditable(row, prefix+"port_buf_hrs"	, 0);		//Disabled
			}else{
				sheetObj.SetCellEditable(row, prefix+"port_buf_hrs"	, 1);		//Editabled
			}
			
		}else{
			sheetObj.SetCellEditable(row, prefix+"port_buf_hrs"	, 0);			//Disabled
		}
		
		if(sheetObj.GetCellValue(row+1, prefix+"auto_skd_cng_flg") == "0"){
			
			////if(sheetObj.GetCellValue(row, prefix+"etd_delay_flg") == "D"){
			if(isDisabledBufferCol){
				sheetObj.SetCellEditable(row,	prefix+"sea_buf_hrs"	, 0);	//Disabled
			}else{
				sheetObj.SetCellEditable(row,	prefix+"sea_buf_hrs"	, 1);	//Editabled
			}
			
		}else{
			sheetObj.SetCellEditable(row, prefix+"sea_buf_hrs"	, 0);			//Disabled
		}						
		////////////////////////////////////////////////////////////////////////////////////////////////////
    	
    }
    
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	function sheet1_OnClick(sheetObj, Row, Col) {
		
		var prefix	= sheetObj.id + "_";
		var colName	= sheetObj.ColSaveName(Col);
		
		//::2015-04-02:by TOP:://
//	if(colName == prefix+"auto_skd_cng_flg"){	
//		if(sheetObj.GetCellValue(Row, prefix+"auto_skd_cng_flg") == "0"){
//			sheetObj.SetCellEditable(Row, prefix+"port_buf_hrs"	, 1);
//		}else{
//			sheetObj.SetCellEditable(Row, prefix+"port_buf_hrs"	, 0);
//		}
//		
//		if(sheetObj.GetCellValue(Row, prefix+"auto_skd_cng_flg") == "0"){
//			sheetObj.SetCellEditable(Row-1, prefix+"sea_buf_hrs" 	, 1);
//		}else{
//			sheetObj.SetCellEditable(Row-1, prefix+"sea_buf_hrs" 	, 0);
//		}			
//	}
		
		//::2015-04-12:by TOP:://
		fnControlSeaPortBufferCell(sheetObj, Row);
	}
	
	function sheet2_OnClick(sheetObj, Row, Col) {
	}
	
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		
		var prefix	= sheetObj.id + "_";
		var headCnt	= sheetObj.HeaderRows();
		var formObj	= document.form;
		var sXml	= null;
		
		if(Row >= headCnt && Col > 0){
			
			var colName=sheetObj.ColSaveName(Col);
			
			if(colName == prefix+"vps_port_cd"){							//Port change
				
			}else
			if(colName == prefix+"vps_port_cd"){							//Port change
				glbSkdPortFlgs[Row-headCnt]="N";
				// Termanal Code Retrieve
				formObj.loc_cd.value=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
				// Dist Retrieve
				if(Row > headCnt){
					var startRow=getNotSkipRow(sheetObj, Row, "P");
					var endRow=getNotSkipRow(sheetObj, Row, "N");
	    			if(startRow > 0 && endRow > 0){
	    				var fmLocCd=sheetObj.GetCellValue(startRow, prefix+"vps_port_cd");
	    				fmLocCd=fmLocCd + "|" + sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
	    				var toLocCd=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
	    				toLocCd=toLocCd + "|" + sheetObj.GetCellValue(endRow, prefix+"vps_port_cd");
						formObj.fm_loc_cd.value=fmLocCd;
						formObj.to_loc_cd.value=toLocCd;
	    			}
				}
				sXml=doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPort(sheetObj, Row, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						var rootNode=VskGetXmlRootNode(sXml);
						var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue=dataNode.value;
							if(totValue > 0){
								setBaseInfo(sheetObj, sXml, Row, "PORT_CHANGE");
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.SetCellValue(Row, prefix+"tml_cd","",0);
							}
						}
					}
					glbSkdPortFlgs[Row-headCnt]="Y";
				}else{
					glbSkdPortFlgs[Row-headCnt]="N";
				}
				//Modifying all ST_PORT_CD of VVD in case first ETB of VVD Change
				if(colName == prefix+"vps_port_cd" && sheetObj.GetCellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd=sheetObj.GetCellValue(Row, prefix+"vvd");
					var stPortCd=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.SetCellValue(i+headCnt, prefix+"st_port_cd",stPortCd);
						}
					}
				}
				
			}else if(colName == prefix+"vps_eta_dt"							// ETA, ETB, ETD change
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				
				//Checking ETA, ETB, ETD date format
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}
				//>>
				//>>if(!sheetObj.ColHidden(prefix+"lnk_dist")){
				//>>	calcSchedule(sheetObj, Row, Col);
				//>>}
				calcSchedule(sheetObj, Row, Col);//<<
				//>>//Delay Date calculation
				//>>if(colName == prefix+"vps_etd_dt"){
				//>>	setDelayTime(sheetObj, Row, Col, prefix+"pf_etd_dt");
				//>>	if(Row < sheetObj.LastRow){
				//>>		
				//>>		if(getSeaDlayTime(sheetObj, Row+1) >= gSkdBuffTimeCode){
				//>>			sheetObj.CellValue2(Row+1, prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, Row+1);
				//>>		}else{
				//>>			sheetObj.CellValue2(Row+1, prefix+"sea_date_text") = "";
				//>>		}
				//>>		
				//>>		
				//>>		if(sheetObj.CellValue(Row+1, prefix+"sea_date_text") == ""){
				//>>			sheetObj.CellValue2(Row+1, prefix+"vsl_dlay_rsn_cd") = "";
				//>>			sheetObj.CellValue2(Row+1, prefix+"vsl_dlay_rsn_desc") = "";
				//>>			sheetObj.CellBackColor(Row+1, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(Row+1, prefix+"sea_date_text");
				//>>		}
				//>>	}
				//>>}else if(colName == prefix+"vps_eta_dt"){
				//>>	if(Row > headCnt){
				//>>		
				//>>		if(getSeaDlayTime(sheetObj, Row) >= gSkdBuffTimeCode){
				//>>			sheetObj.CellValue2(Row, prefix+"sea_date_text") = calcSeaDlayTime(sheetObj, Row);
				//>>		}else{
				//>>			sheetObj.CellValue2(Row, prefix+"sea_date_text") = "";
				//>>		}
				//>>		
				//>>		
				//>>		if(sheetObj.CellValue(Row, prefix+"sea_date_text") == ""){
				//>>			sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_cd") = "";
				//>>			sheetObj.CellValue2(Row, prefix+"vsl_dlay_rsn_desc") = "";
				//>>			sheetObj.CellBackColor(Row, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(Row, prefix+"sea_date_text");
				//>>		}
				//>>	}
				//>>}
				//Modifying all N1ST_PORT_BRTH_DT of VVD in case first ETB of VVD Change
				if(colName == prefix+"vps_etb_dt" && sheetObj.GetCellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd=sheetObj.GetCellValue(Row, prefix+"vvd");
					var n1stPortBrthDt=sheetObj.GetCellValue(Row, prefix+"vps_etb_dt");
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.SetCellValue(i+headCnt, prefix+"n1st_port_brth_dt",n1stPortBrthDt);
						}
					}
				}
				
				///////////// kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk by top //////////////
				if(!sheetObj.GetColHidden(prefix+"lnk_dist")){
					calcPfData(sheetObj, Row, Col);
				}
				
			}else if(colName == prefix+"lnk_dist" || colName == prefix+"lnk_spd"){							//SPD change
				/*
				 * lnk_dist
				 * lnk_spd 
				 * tztm_hrs(sea_time)
				 * act_wrk_hrs(port_time) 
				 * port_buf_hrs 
				 * sea_buf_hrs 
				 * mnvr_in_hrs
				 * mnvr_out_hrs 
				 * sea_time = lnk_dist / lnk_spd
				 */
//By Hwang 
				//Distance Check...
				if(sheet1.GetCellValue(Row, prefix+"lnk_dist").length > 6){
					ComShowCodeMessage('VSK01019', "Distance");
					sheet1.SelectCell(Row, prefix+"lnk_dist");
					return false;
				}
//By Hwang 
				//Speed Check...
				if(String(parseInt(sheet1.GetCellValue(Row, prefix+"lnk_spd"))).length > 4){
					ComShowCodeMessage('VSK01019', "Speed");
					sheet1.SelectCell(Row, prefix+"lnk_spd");
					return false;
				}
				
				var dist	= Number(sheet1.GetCellValue(Row, prefix+"lnk_dist"));
				var spd		= Number(sheet1.GetCellValue(Row, prefix+"lnk_spd"));
				
				var	tztmHrs	= 0;
				if(spd == 0 || spd == null || spd == "" || spd == undefined)  	tztmHrs	= 0;
				else															tztmHrs	= dist/spd;
				
				//::2015-04-18:://sheet1.SetCellValue(Row, prefix+"tztm_hrs"	, Math.round(dist/spd), 0);
				//::2015-04-18:://sheet1.SetCellValue(Row, prefix+"pf_tztm_hrs"	, Math.round(dist/spd), 0);
				
				//alert('lnk_dist or lnk_spd event  Math.round(tztmHrs) ['+Math.round(tztmHrs)+']');
				
				sheet1.SetCellValue(Row, prefix+"tztm_hrs"		, Math.round(tztmHrs), 0);
				sheet1.SetCellValue(Row, prefix+"pf_tztm_hrs"	, Math.round(tztmHrs), 0);
				
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= true;
				
				calcSchedule(sheet1, Row, sheet1.SaveNameCol(prefix+"vps_etd_dt"));
				
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= false;
				
			}else if(colName == prefix+"act_wrk_hrs"){	//Port Time change 시
//By Hwang 
				//Port Time Check...
				if(String(parseInt(sheetObj.GetCellValue(Row, prefix+"act_wrk_hrs"))).length > 4){
					ComShowCodeMessage('VSK01019', "Port Time");
					sheetObj.SelectCell(Row, prefix+"act_wrk_hrs");
					return false;
				}
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= true;
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"));
				
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= false;
			}else if(colName == prefix+"port_buf_hrs"){	//Buffer Time(Port) change 시
//By Hwang 
				//Port Buffer Time Check...
				if(String(parseInt(sheetObj.GetCellValue(Row, prefix+"port_buf_hrs"))).length > 4){
					ComShowCodeMessage('VSK01019', "Port Buffer Time");
					sheetObj.SelectCell(Row, prefix+"port_buf_hrs");
					return false;
				}
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= true;
				
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"));
				
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= false;
			}else if(colName == prefix+"sea_buf_hrs"){	//Buffer Time(Sea) change 시
//By Hwang 
				//Sea Buffer Time Check...
				if(String(parseInt(sheetObj.GetCellValue(Row, prefix+"sea_buf_hrs"))).length > 4){
					ComShowCodeMessage('VSK01019', "Sea Buffer Time");
					sheetObj.SelectCell(Row, prefix+"sea_buf_hrs");
					return false;
				}
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				
				//::2007816::2014-04-23::ApplyUpdadatedTimeByDistance+Speed:://
				gIsDistOrSpdChange	= false;
			}else if(colName == prefix+"tml_cd") {
				if(glbTmlFlg == "Y"){
					if(sheetObj.GetCellValue(Row, prefix+"tml_cd") == ""){
						formObj.yd_cd.value="";
						sheetObj.SetCellValue(Row, prefix+"mnvr_in_hrs","",0);
						sheetObj.SetCellValue(Row, prefix+"mnvr_out_hrs","",0);
					}else{
						//formObj.yd_cd.value = formObj.loc_cd.value + sheetObj.CellValue(Row, prefix+"tml_cd");
						formObj.yd_cd.value=sheetObj.GetCellValue(Row, prefix+"vps_port_cd") + sheetObj.GetCellValue(Row, prefix+"tml_cd");
						sXml=doActionIBSheet(sheetObj, formObj ,SEARCH05);
						sheetObj.SetCellValue(Row, prefix+"mnvr_in_hrs",ComGetEtcData(sXml, "mnvr_in_hrs"),0);
						sheetObj.SetCellValue(Row, prefix+"mnvr_out_hrs",ComGetEtcData(sXml, "mnvr_out_hrs"),0);
						if(Row > headCnt){
							calcSchedule(sheetObj, Row-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
						}
					}
				}
			}else if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				//::FOR.NYK.START::by DONGSOO:2014-09-17:://
				//::2014.08.25 change status가 변경되는 상태는 phase In만 해당됨 
				//if(cngStsCd != "" && cngStsCd != "I" && cngStsCd != "O"){				
				//::FOR.NYK.FINISH::by DONGSO:2014-09-17:://
				if(cngStsCd != "" && cngStsCd != "I"){
					ComShowCodeMessage("VSK00078");
					sheetObj.SetCellValue(Row, prefix+"skd_cng_sts_cd",gblSheet1CngStsCd,0);
				}else{
					gblSheet1CngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				}
//By Hwang 				
			}else if(colName == prefix+"turn_skd_voy_no" || colName == prefix+"turn_skd_dir_cd"  ){
				var turnPortFlg=sheetObj.GetCellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){ 
					if(sheetObj.GetCellValue(Row, prefix+"skd_voy_no") == sheetObj.GetCellValue(Row, prefix+"turn_skd_voy_no")  &&
							sheetObj.GetCellValue(Row, prefix+"skd_dir_cd") == sheetObj.GetCellValue(Row, prefix+"turn_skd_dir_cd")
	                     ) {
	   						ComShowCodeMessage("VSK57100");
							sheetObj.SetCellValue(Row, prefix+"turn_skd_voy_no","",0);
							sheetObj.SetCellValue(Row, prefix+"turn_skd_dir_cd","",0);
	                   } 
				}
				
			}else if(colName == prefix+"turn_port_flg"){
				
				/** Adding validation for virtual add calling port ::26JUN15 **/
				var turnPortFlg=sheetObj.GetCellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){
					var vvd=sheetObj.GetCellValue(Row, prefix+"vvd");
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == vvd && (i+headCnt) != Row){
							if(sheetObj.GetCellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
								sheetObj.SetCellValue(Row, prefix+"turn_skd_voy_no",sheetObj.GetCellValue(i+headCnt, prefix+"turn_skd_voy_no"),0);
								sheetObj.SetCellValue(Row, prefix+"turn_skd_dir_cd",sheetObj.GetCellValue(i+headCnt, prefix+"turn_skd_dir_cd"),0);
								break;
							}
						}
					}
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_voy_no",1);
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_dir_cd",1);
					if(sheetObj.GetCellValue(Row, prefix+"port_rotn_seq") == "1"){
						sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
					}else{
						sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","Y",0);
					}
					
					if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg") == "Y"){
						ComShowCodeMessage('VSK55011', sheetObj.GetCellValue(Row, prefix+"vps_port_cd"));
						sheetObj.SetCellValue(Row, prefix+"turn_port_flg","N");
					}
					
				}else{
					sheetObj.SetCellValue(Row, prefix+"turn_skd_voy_no","",0);
					sheetObj.SetCellValue(Row, prefix+"turn_skd_dir_cd","",0);
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_voy_no",0);
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_dir_cd",0);
					sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
				}
				
			}else if(colName == prefix+"vsl_dlay_rsn_cd"){
				// in case Delay Reason change, Changing desc
				var sText=sheetObj.GetComboInfo(Row, prefix+"vsl_dlay_rsn_cd", "Text");
				var arrText=sText.split("|");
				var idx=sheetObj.GetComboInfo(Row, prefix+"vsl_dlay_rsn_cd", "SelectedIndex");
				var sSelText=arrText[idx];
				var arrSelText=sSelText.split("\t");
				sheetObj.SetCellValue(Row, prefix+"vsl_dlay_rsn_desc",arrSelText[1],0);
			}
		}
	}
	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var formObj=document.form;
		var sXml=null;
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"vps_port_cd"){
				glbPlanPortFlgs[Row-headCnt]="N";
				// Termanal Code Retrieve
				formObj.loc_cd.value=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
				// Dist Retrieve
				if(Row > headCnt){
					var fmLocCd=sheetObj.GetCellValue(Row-1, prefix+"vps_port_cd");
					fmLocCd=fmLocCd + "|" + sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
					var toLocCd=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
					toLocCd=toLocCd + "|" + sheetObj.GetCellValue(Row+1, prefix+"vps_port_cd");
					formObj.fm_loc_cd.value=fmLocCd;
					formObj.to_loc_cd.value=toLocCd;
				}
				sXml=doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPort(sheetObj, Row, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						var rootNode=VskGetXmlRootNode(sXml);
						var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
						if(dataNode){
							var totValue=dataNode.value;
							if(totValue > 0){
								setBaseInfo(sheetObj, sXml, Row, "PORT_CHANGE");
								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.SetCellValue(Row, prefix+"tml_cd","",0);
							}
						}
					}
					glbPlanPortFlgs[Row-headCnt]="Y";
				}else{
					glbPlanPortFlgs[Row-headCnt]="N";
				}
				//Modifying all ST_PORT_CD of VVD in case first ETB of VVD Change
				if(colName == prefix+"vps_port_cd" && sheetObj.GetCellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd=sheetObj.GetCellValue(Row, prefix+"vvd");
					var stPortCd=sheetObj.GetCellValue(Row, prefix+"vps_port_cd");
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.SetCellValue(i+headCnt, prefix+"st_port_cd",stPortCd);
						}
					}
				}
			}else if(colName == prefix+"vps_eta_dt"
					|| colName == prefix+"vps_etb_dt"
					|| colName == prefix+"vps_etd_dt"){
				//Checking ETA, ETB, ETD date format
				if(VskIsDateValid(sheetObj, Row, Col) == false){
					return false;
				}
				calcSchedule(sheetObj, Row, Col);
				// Modifying all N1ST_PORT_BRTH_DT of VVD in case first ETB of VVD Change
				if(colName == prefix+"vps_etb_dt" && sheetObj.GetCellValue(Row, prefix+"clpt_seq") == "1"){
					var vvd=sheetObj.GetCellValue(Row, prefix+"vvd");
					var n1stPortBrthDt=sheetObj.GetCellValue(Row, prefix+"vps_etb_dt");
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == vvd){
							sheetObj.SetCellValue(i+headCnt, prefix+"n1st_port_brth_dt",n1stPortBrthDt);
						}
					}
				}
			}else if(colName == prefix+"lnk_dist" || colName == prefix+"lnk_spd"){							//SPD change
				/*
				 * lnk_dist
				 * lnk_spd 
				 * tztm_hrs(sea_time)
				 * act_wrk_hrs(port_time) 
				 * port_buf_hrs 
				 * sea_buf_hrs 
				 * mnvr_in_hrs
				 * mnvr_out_hrs 
				 * sea_time = lnk_dist / lnk_spd
				 */
				var dist	= Number(sheetObj.GetCellValue(Row, prefix+"lnk_dist"));
				var spd		= Number(sheetObj.GetCellValue(Row, prefix+"lnk_spd"));
				
				//alert('link_dist or lnk_spd dist ['+dist+']  spd ['+spd+']');
				
				if(spd != null && spd != undefined && spd != "" && spd != 0){
					sheetObj.SetCellValue(Row, prefix+"tztm_hrs",Math.round(dist/spd),0);
				}
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				// Bunker Additional Cost
				calcBunkerAdditionalCostBySpeed(sheetObj, Row, formObj);
				// Total Cost
				calcTotalCost(sheetObj);
			}else if(colName == prefix+"act_wrk_hrs"){	//Port Time change
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"));
			}else if(colName == prefix+"port_buf_hrs"){	//Buffer Time(Port) change
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etb_dt"));
			}else if(colName == prefix+"sea_buf_hrs"){	//Buffer Time(Sea) change
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
			}else if(colName == prefix+"mnvr_in_hrs"){	//Maneuvering In change
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
			}else if(colName == prefix+"mnvr_out_hrs"){	//Maneuvering Out change
				calcSchedule(sheetObj, Row, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
			}else if (colName == prefix+"tml_cd") {
				if(glbTmlFlg == "Y"){
					if(sheetObj.GetCellValue(Row, prefix+"tml_cd") == ""){
						formObj.yd_cd.value="";
						sheetObj.SetCellValue(Row, prefix+"mnvr_in_hrs","",0);
						sheetObj.SetCellValue(Row, prefix+"mnvr_out_hrs","",0);
					}else{
						formObj.yd_cd.value=formObj.loc_cd.value + sheetObj.GetCellValue(Row, prefix+"tml_cd");
						sXml=doActionIBSheet(sheetObj, formObj ,SEARCH12);
						sheetObj.SetCellValue(Row, prefix+"mnvr_in_hrs",ComGetEtcData(sXml, "mnvr_in_hrs"),0);
						sheetObj.SetCellValue(Row, prefix+"mnvr_out_hrs",ComGetEtcData(sXml, "mnvr_out_hrs"),0);
						if(Row > headCnt){
							calcSchedule(sheetObj, Row-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
						}
					}
					var ttlChgAmt=ComGetEtcData(sXml, "ttl_chg_amt");
					if(ttlChgAmt != null && ttlChgAmt != undefined && ttlChgAmt != ""){
						sheetObj.SetCellValue(Row, prefix+"pe_usd_ttl_amt",Number(ttlChgAmt) * (-1),0);
						calcTotalCost(sheetObj);
					}
				}
			}else if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				if(cngStsCd != "" && cngStsCd != "I" && cngStsCd != "O"){
					ComShowCodeMessage("VSK00077");
					sheetObj.SetCellValue(Row, prefix+"skd_cng_sts_cd",gblSheet2CngStsCd,0);
				}else{
					gblSheet2CngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				}
			}else if(colName == prefix+"turn_port_flg"){
				var turnPortFlg=sheetObj.GetCellValue(Row, prefix+"turn_port_flg");
				if(turnPortFlg == "Y"){
//					var vvd = sheetObj.CellValue(Row, prefix+"vvd");
//					for(var i=0; i<sheetObj.RowCount; i++){
//						if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd && (i+headCnt) != Row){
//							if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
//								sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_voy_no");
//								sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = sheetObj.CellValue(i+headCnt, prefix+"turn_skd_dir_cd");
//								break;
//							}
//						}
//					}
//					
//					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = true;
//					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = true;
					if(sheetObj.GetCellValue(Row, prefix+"port_rotn_seq") == "1"){
						sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
					}else{
						sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","Y",0);
					}
				}else{
//					sheetObj.CellValue2(Row, prefix+"turn_skd_voy_no") = "";
// 					sheetObj.CellValue2(Row, prefix+"turn_skd_dir_cd") = "";
//					
// 					sheetObj.CellEditable(Row, prefix+"turn_skd_voy_no") = false;
// 					sheetObj.CellEditable(Row, prefix+"turn_skd_dir_cd") = false;
					sheetObj.SetCellValue(Row, prefix+"turn_port_ind_cd","N",0);
				}
			}
//			if(sheetObj.CellValue(Row, prefix+"turn_port_flg") == "Y"){
//				var vvd = sheetObj.CellValue(Row, prefix+"vvd");
//				
//				for(var i=0; i<sheetObj.RowCount; i++){
//					if(sheetObj.CellValue(i+headCnt, prefix+"vvd") == vvd){
//						if(sheetObj.CellValue(i+headCnt, prefix+"turn_port_flg") == "Y"){
//							if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "I" 
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "U"
//								&& sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//								sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = "U";
//							}
//						}
//					}
//				}
//			}
		}
	}
	/**
	 * Handling select cell of sheet1 Event
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		
		if(NewRow >= sheetObj.HeaderRows()&& NewCol > 0){
			var formObj=document.form;
			var headCnt=sheetObj.HeaderRows();
			var sXml=null;
			var prefix=sheetObj.id + "_";
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
				if(!sheetObj.GetCellEditable(NewRow, NewCol)){
					setRowControlBtnSts(sheetObj, NewRow);
					btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button Activate Control.
					setFormData(sheetObj, NewRow, NewCol);
					return;
				}
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
//				if(glbSkdPortFlgs[NewRow-headCnt] == "N"){
					formObj.loc_cd.value=sheetObj.GetCellValue(NewRow, prefix+"vps_port_cd");
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					//glbSkdPortFlgs[NewRow-headCnt]="Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblSheet1CngStsCd=sheetObj.GetCellValue(NewRow, NewCol);
			}
			setRowControlBtnSts(sheetObj, NewRow);
			btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button Activate Control.
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	/**
	 * Handling select cell of sheet2 Event
	 * @param sheetObj
	 * @param OldRow
	 * @param OldCol
	 * @param NewRow
	 * @param NewCol
	 * @return
	 */
	function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		if(NewRow >= sheetObj.HeaderRows()&& NewCol > 0){
			var formObj=document.form;
			var headCnt=sheetObj.HeaderRows();
			var sXml=null;
			var prefix=sheetObj.id + "_";
			if(sheetObj.ColSaveName(NewCol) == prefix+"tml_cd"){
				if(!sheetObj.GetCellEditable(NewRow, NewCol)){
					setRowControlBtnSts(sheetObj, NewRow);
					btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button Activate Control.
					setFormData(sheetObj, NewRow, NewCol);
					return;
				}
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
//				if(glbPlanPortFlgs[NewRow-headCnt] == "N"){
					formObj.loc_cd.value=sheetObj.GetCellValue(NewRow, prefix+"vps_port_cd");
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					//glbPlanPortFlgs[NewRow-headCnt]="Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblSheet2CngStsCd=sheetObj.GetCellValue(NewRow, NewCol);
			}
			setRowControlBtnSts(sheetObj, NewRow);
			btnControlByLoadableWeight(sheetObj, NewRow);	//Loadable Weight Button Activate Control.
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	/**
	 * Handling key up event of sheet1
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		btnReverseCallControl(sheetObj);
	}
	/**
	 * Handling key up event of sheet2
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param KeyCode
	 * @param Shift
	 * @return
	 */
	function sheet2_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift){
		btnReverseCallControl(sheetObj);
	}
	/**
	 * Handling mouse up event of sheet1
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseUp(sheetObj, Button, Shift, X, Y){
		btnReverseCallControl(sheetObj);
	}
	/**
	 * Handling mouse up event of sheet2
	 * @param sheetObj
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet2_OnMouseUp(sheetObj, Button, Shift, X, Y){
		btnReverseCallControl(sheetObj);
	}
	/**
	 * Handling event when after retrieving sheet1
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		btnControlByLoadableWeight(sheetObj, sheetObj.GetSelectRow());	//Loadable Weight Button Activate Control.
	}
	/**
	 * Handling event when after retrieving sheet2
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
// 		sheetObj.SumText(0,1)="";
// 		sheetObj.SumText(0,26)="Total Cost";
		btnControlByLoadableWeight(sheetObj, sheetObj.GetSelectRow());	//Loadable Weight Button Activate Control.
	}
	/*
	 * =====================================================================
	 * Combo Event
	 * =====================================================================
	 */
	function remark_OnChange(comboObj, Code, Text) {
//		isRmkModFlg = "Y";
// 		clearDescData(sheetObjects[0], document.form, "");
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"vvd") == Code){
				sheetObj.SelectCell(i, 1);
				break;
			}
		}
	}
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
    function initControl() {
    	axon_event.addListenerForm('change'		, 'obj_change'	, form);
    	axon_event.addListenerForm('keypress'	, 'obj_keypress', form);
    	
    	axon_event.addListenerForm('click'  	, 'obj_click'   , form); 
    	
//    	axon_event.addListenerForm('keyup', 'obj_keyup', form);
//    	axon_event.addListenerForm('keydown', 'obj_keydown', form); 	
//    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
//    	axon_event.addListenerForm('focus', 'obj_focus', form);
	}
	function obj_change(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		try {
			if(glbSheetFlg == "sheet2"){
				sheetObj=sheetObjects[1];
			}
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
	            		Usr_setVslCd(formObj.vsl_cd.value);
		            	/*if(formObj.sim_dt.value == "" && sheetObj.RowCount()> 0){
		            		resetAllData(sheetObj, formObj);
		            	}*/
	            		formNextFocus(formObj, srcName);
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	            case "skd_voy_no":
	            	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	            	/*if(formObj.sim_dt.value == "" && sheetObj.RowCount()> 0){
	            		resetAllData(sheetObj, formObj);
	            		formNextFocus(formObj, srcName);
	            	}*/
	            	break;
	            case "skd_dir_cd":
	            	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	            	/*if(formObj.sim_dt.value == "" && sheetObj.RowCount()> 0){
	            		resetAllData(sheetObj, formObj);
	            		formNextFocus(formObj, srcName);
	            	}*/
	            	break;
	            /*case "sim_dt":
	            	if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
	            		formObj.rtv_flg.value="N";
	            	}else{
	            		formObj.rtv_flg.value="Y";
	            	}
	            	Usr_setSimDt(formObj.sim_dt.value);
	            	break;
	            case "sim_no":
	            	if(formObj.sim_dt.value == "" && formObj.sim_no.value == ""){
	            		formObj.rtv_flg.value="N";
	            	}else{
	            		formObj.rtv_flg.value="Y";
	            	}
	            	Usr_setSimNo(formObj.sim_no.value);
	            	break;*/
	            case "cre_dt":
	            	Usr_setCreDt(formObj.cre_dt.value);
	            	break;
	            case "cre_usr_id":
	            	Usr_setCreUsrId(formObj.cre_usr_id.value);
	            	break;
	            case "vsl_slan_cd":
	            	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
	            	break;
	            case "bound":
	            	Usr_setBound(formObj.bound.value);
	            	break;
	            case "upd_dt":
	            	Usr_setUpdDt(formObj.upd_dt.value);
	            	break;
	            case "upd_usr_id":
	            	Usr_setUpdUsrId(formObj.upd_usr_id.value);
	            	break;
	            case "skd_rmk":
	            	setRemarkDataByVvd(sheetObj, formObj.skd_rmk.value);
	            	Usr_setSkdRmk(formObj.skd_rmk.value);
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
	function obj_keypress(){
		var eleObj=event.srcElement;
		switch (event.keyCode) {
		    case 13:
		    	if(eleObj.name != 'skd_rmk'){
			    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    	}	
				break;
		}
	}
	function obj_keyup(){
		var eleObj=event.srcElement;
		var formObj=document.form;
		switch (eleObj.name) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break; 
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.bound.focus();
// 					document.getElementById("btn_retrieve").focus();
		    	}
				break;
		}
	}
	function obj_keydown(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(focusObj=="vsl_cd"){
			var ctrl=event.ctrlKey;
			var code=event.keyCode;
			if(ctrl && code == 86){ 
				var clipData=window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData=clipData.toUpperCase();
					formObj.vsl_cd.value=clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value=clipData.substring(4, 8);
						formObj.skd_dir_cd.value=clipData.substring(8, 9);
					}
				}
				event.returnValue=false;
			}
		}
	}
	function obj_focus(){
		var eleObj=event.srcElement;
		if(eleObj.name){
			focusObj=eleObj.name;
		}else{
			focusObj="";
		}
	}
	/*
	 * =====================================================================
	 * Button Event
	 * =====================================================================
	 */
    /**
	 * [Coastal SKD] / [Recovery Plan] Radio Button Control
	 * @param sheetName
	 * @return
	 */
    function showSheetForm(sheetName){
    	var formObj=document.form;
    	if(sheetName == "sheet1"){
    		var sheetObj=sheetObjects[0];
    		formObj.vsl_cd.className="input1";
    		formObj.skd_voy_no.className="input1";
    		formObj.skd_dir_cd.className="input1";
    		document.getElementById("div_col_show").style.display="block";
    		document.getElementById("div_col_hide").style.display="block";
    		document.getElementById("div_plan_col_show").style.display="none";
    		document.getElementById("div_plan_col_hide").style.display="none";
    		sheetObjects[0].SetVisible(1);
    		sheetObjects[1].SetVisible(0);
    		showFieldControl(sheetObjects[0], formObj, false);
//    		sheetObjects[0].SetSheetHeight(glbSheetHeight);
    		//sheetObjects[1].SetSheetHeight(0);
// 			formObj.skd_rmk.className = "textarea2";
// 			formObj.skd_rmk.readOnly = true;
// 			ComEnableObject(formObj.skd_rmk, sheetObj.RowEditable(sheetObj.SelectRow));
    		glbSheet1FormData.setAllFormData();	// Sheet1의 Form Data Setting...
    	}else{
    		formObj.vsl_cd.className="input";
    		formObj.skd_voy_no.className="input";
    		formObj.skd_dir_cd.className="input";
    		document.getElementById("div_col_show").style.display="none";
    		document.getElementById("div_col_hide").style.display="none";
    		document.getElementById("div_plan_col_show").style.display="block";
    		document.getElementById("div_plan_col_hide").style.display="block";
    		sheetObjects[0].SetVisible(0);
    		sheetObjects[1].SetVisible(1);
    		showFieldControl(sheetObjects[1], formObj, false);
//    		sheetObjects[1].SetSheetHeight(glbSheetHeight);
    		//sheetObjects[0].SetSheetHeight(0);
    		formObj.skd_rmk.className="textarea";
    		formObj.skd_rmk.readOnly=false;
    		glbSheet2FormData.setAllFormData();	// Sheet2의 Form Data Setting...
    	}
    	replaceButtonSet(formObj);
		formObj.vsl_cd.focus();
    }
	/**
	 * [Row Hide] Button Event : Hidden selected Row
	 * @param sheetObj
	 * @return
	 */
	function rowHideControl(sheetObj){
		var prefix=sheetObj.id + "_";
		var selRowStr=sheetObj.GetSelectionRows("|");
		var selRows=selRowStr.split("|");
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		if(selRows){
			if(selRows.length > 0){
//no support[check again]CLT 				var rowsView=new Array();		// Shown Rows
				var rowsView=new Array();
				var	i=0, k=0;
				for (i=headCnt; i<headCnt + rowCnt; i++) {
					if (sheetObj.GetCellValue(i, prefix+"usr_hdn_flg") == "N") {
						// Shown Rows
						rowsView[k++]=i;
					}
				}
//				var fmSetSelectRow(ComParseInt(selRows[0]));
//				var toSetSelectRow(ComParseInt(selRows[selRows.length - 1]));
//				var fmViewRow=rowsView[0];
//				var toViewRow=rowsView[rowsView.length - 1];
				
				//kjh modify.. UI개선..
				var fmSelectRow = ComParseInt(selRows[0]);
				var toSelectRow = ComParseInt(selRows[selRows.length - 1]);

				var fmViewRow = rowsView[0];
				var toViewRow = rowsView[rowsView.length - 1];
				if (!(fmSelectRow== fmViewRow || toSelectRow== toViewRow)) {
					// one of first and last port of shown ports has to selected
					ComShowCodeMessage("VSK00035");
					return;
				}
				if ((toSelectRow- fmSelectRow + 1) != selRows.length){
					ComShowCodeMessage("VSK00037");
					return;
				}
				for (i=0; i<selRows.length; i++) { // Hidden
					sheetObj.SetCellValue(selRows[i], prefix+"usr_hdn_flg","Y",0);
					sheetObj.SetRowHidden(selRows[i],1);
				}
				if(sheetObj.id == "sheet1"){
					ComBtnEnable("btn_row_hide_cancel_1");
					
					ComSetDisplay("btn_row_hide_1", false);
					ComSetDisplay("btn_row_hide_cancel_1", true);
					
				}else{
					ComBtnEnable("btn_row_hide_cancel_2");
				}
			}else{
				ComShowCodeMessage("VSK00020");
			}
		}
	}
	/**
	 * [Row Hide Cancel] Button Event : Unfolding hidden Rows
	 * @param sheetObj
	 * @return
	 */
	function rowHideCancel(sheetObj){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var totCnt=getTotalRowCnt(sheetObj);
		for (i=headCnt; i<=totCnt; i++) {
//			if(sheetObj.CellValue(i, prefix+"ibflag") != "D"
//				&& sheetObj.CellValue(i, prefix+"tmp_phase_flag") != "H"){
			if(sheetObj.GetRowStatus(i) != "D"
				&& sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") != "H"){
				if(sheetObj.GetRowHidden(i)==1){
					sheetObj.SetCellValue(i, prefix+"usr_hdn_flg","N",0);
					sheetObj.SetRowHidden(i,0);
				}
			}
		}
		if(sheetObj.id == "sheet1"){
			ComBtnDisable("btn_row_hide_cancel_1");
			
			ComSetDisplay("btn_row_hide_1", true);
			ComSetDisplay("btn_row_hide_cancel_1", false);
			
		}else{
			ComBtnDisable("btn_row_hide_cancel_2");
		}
	}
	/**
	 * [Skip Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallControl(sheetObj){
		var prefix					= sheetObj.id + "_";
		var headRow					= sheetObj.HeaderRows();
		var sRow					= sheetObj.GetSelectRow();
		var formObj					= document.form;
		formObj.vps_port_cd.value	= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
		formObj.clpt_ind_seq.value	= sheetObj.GetCellValue(sRow, prefix+"clpt_ind_seq");
		
		var isGetColHidden			= true;
		
		sheetObj.SetCellValue		(sRow, prefix+"skipcall_ind_for_recovery", "SKIP", 0);
		
		if(sheet1.id == "sheet1"){
			isGetColHidden=sheet1.GetColHidden(prefix+"lnk_dist");
		}else{
			isGetColHidden=sheet2.GetColHidden(prefix+"ib_cgo_qty");
		}		

    	/**************************************************************************/
		preRow	= getNotSkipRow(sheetObj, sRow, "P");
    	nxtRow	= getNotSkipRow(sheetObj, sRow, "N");

		//alert('first preRow ['+preRow+']   nxtRow ['+nxtRow+']  port pair ['+sheet1.GetCellValue(preRow, prefix+"vps_port_cd")+' >> '+sheet1.GetCellValue(nxtRow, prefix+"vps_port_cd")+']');
    	
    	if(preRow>0 && nxtRow>0){
			var sXml	= doUnitCallBaseInfo(sheetObj, preRow, nxtRow);
			
			//alert('sXml >>>> ['+sXml+' >>>');
			
			// Setting Dist, Sea Time
			if(sXml != null && sXml != undefined && sXml != ""){
				
				if(isGetColHidden == false){
					setUnitSkipPortBaseInfo	(sheetObj, sXml, preRow, sRow, nxtRow);
					//setUnitAddPortBaseInfo(sheetObj, sXml, sRow, eRow, actWrkHrs){
				}
			}
			
    	}else{
    		
    		null;
    		
    	}
    	/**************************************************************************/		
		
		//////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////
		
		// 		VSK_PORT_DIST
		////by top.2015-04-27//var sXml					= doCallBaseInfo(sheetObj, sRow, "SKIP");
    	
    	
		sheetObj.RenderSheet(0);
		
		try{
			//Setting Dist, Sea Time
			////by top.2015-04-27//setBaseInfo				(sheetObj, sXml, sRow, "SKIP");
			
			var isGetColHidden		= isHiddenState(sheetObj);
			if(isGetColHidden){
				showFieldControl(sheetObj, formObj, true);
			}
			
			sheetObj.SetCellValue(sRow, prefix+"tmp_cng_sts_cd",sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd"),0);
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd","S",0);
			sheetObj.SetCellValue(sRow, prefix+"skp_call_flg","Y",0);
			sheetObj.SetRowEditable(sRow,0);
			sheetObj.SetCellBackColor(sRow, prefix+"vsl_dlay_rsn_cd",sheetObj.GetCellBackColor(sRow, prefix+"sea_date_text"));
			fontColorChangeBySkip(sheetObj, sRow);
			
			// in case of Expend, Updating SKD in sheet1
			if(sheetObj.id != "sheet1" || isGetColHidden== false){
				if(sRow == headRow){
					calcSchedule(sheetObj, sRow+1, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
				}else{
					calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				}
			}
			
			if(isGetColHidden){
				showFieldControl(sheetObj, formObj, false);
			}
			sheetObj.RenderSheet(1);
			
		}catch(e) {
			
			sheetObj.RenderSheet(1);
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
			
		}
		
		setRowControlBtnSts(sheetObj, sRow);
	}
	/**
	 * [Skip Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallCancel(sheetObj){
		var prefix				= sheetObj.id + "_";
		var sRow				= sheetObj.GetSelectRow();
		var formObj				= document.form;
		
		var tmpSkipStatus		= sheetObj.GetCellValue(sRow, prefix+"skipcall_ind_for_recovery");
		
		if(sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd") == "S"){
			
			//alert('tmpSkipStatus ['+tmpSkipStatus+']');
			if(tmpSkipStatus == "SKIP"){
				
		    	/**************************************************************************/
				preRow	= getNotSkipRow(sheetObj, sRow, "P");
				//alert('pre port ['+sheetObj.GetCellValue(preRow, prefix+"vps_port_cd")+']');
				
				//alert('sRow-1  lnk_dist_for_recovery ['+sheetObj.GetCellValue(sRow-1, prefix+"lnk_dist_for_recovery")+']');
				
				sheetObj.SetCellValue	(preRow, prefix+"lnk_dist"			,sheetObj.GetCellValue(preRow, prefix+"lnk_dist_for_recovery")		,0);
				sheetObj.SetCellValue	(preRow, prefix+"tztm_hrs"			,sheetObj.GetCellValue(preRow, prefix+"tztm_hrs_for_recovery")		,0);
				sheetObj.SetCellValue	(preRow, prefix+"lnk_spd"			,sheetObj.GetCellValue(preRow, prefix+"lnk_spd_for_recovery")		,0);
				sheetObj.SetCellValue	(preRow, prefix+"act_wrk_hrs"		,sheetObj.GetCellValue(preRow, prefix+"act_wrk_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(preRow, prefix+"time_diff"			,sheetObj.GetCellValue(preRow, prefix+"time_diff_for_recovery")		,0);
				sheetObj.SetCellValue	(preRow, prefix+"mnvr_in_hrs"		,sheetObj.GetCellValue(preRow, prefix+"mnvr_in_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(preRow, prefix+"mnvr_out_hrs"		,sheetObj.GetCellValue(preRow, prefix+"mnvr_out_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(preRow, prefix+"sea_buf_hrs"		,sheetObj.GetCellValue(preRow, prefix+"sea_buf_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(preRow, prefix+"port_buf_hrs"		,sheetObj.GetCellValue(preRow, prefix+"port_buf_hrs_for_recovery")	,0);
								
				//alert('after port cd ['+sheetObj.GetCellValue(sRow, prefix+"vps_port_cd")+']');
				
				
// 				===================================================================================
				sheetObj.SetCellBackColor	(preRow, prefix+"lnk_dist"		,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(preRow, prefix+"tztm_hrs"		,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(preRow, prefix+"lnk_spd"		,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(preRow, prefix+"time_diff"		,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_in_hrs"	,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_out_hrs"	,sheetObj.GetCellBackColor(preRow, prefix+"skd_cng_sts_cd"));
				//---------------------------------------------------------------------------------
				
				
				sheetObj.SetCellValue(preRow, prefix+"skipcall_ind_for_recovery", "", 0);
				////////////////////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////////////////////
				
			}else{

				////by top-2015-04-27//var sXml			= doCallBaseInfo(sheetObj, sRow, "SKIP_CANCEL");
				
				sheetObj.RenderSheet(0);
				////by top-2015-04-27//setBaseInfo(sheetObj, sXml, sRow, "SKIP_CANCEL");
				
				preRow	= getNotSkipRow(sheetObj, sRow, "P");
				nxtRow	= sRow;
				
				var isGetColHidden	= isHiddenState(sheetObj);
		    	if(preRow>0 && nxtRow>0){
					var sXml	= doUnitCallBaseInfo(sheetObj, preRow, nxtRow);
					
					//alert('sXml >>>> ['+sXml+' >>>');
					
					// Setting Dist, Sea Time
					if(sXml != null && sXml != undefined && sXml != ""){
						
						if(isGetColHidden == false){
							setUnitSkipPortBaseInfo	(sheetObj, sXml, preRow, sRow, nxtRow);
							//setUnitAddPortBaseInfo(sheetObj, sXml, sRow, eRow, actWrkHrs){
						}
					}
					
		    	}else{
		    		
		    		null;
		    		
		    	}
			

			}
			
			// Skip Cancel 한 Port Edit 가능하게.
			sheetObj.SetRowEditable(sRow,1);
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd",sheetObj.GetCellValue(sRow, prefix+"tmp_cng_sts_cd"),0);
			sheetObj.SetCellValue(sRow, prefix+"skp_call_flg","",0);
			
			/* VOP_VSK_0015.js , VOP_VSK_0058.js
			 * UPDATE QUERY가 공통으로 같이 사용하여 UPADTE가 정상적으로 되지 않음 
			 * port_skp_tp_cd가 XXX일 경우 NULL로 입력됨. 
			 */
			sheetObj.SetCellValue(sRow, prefix+"port_skp_tp_cd"       ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"port_skp_rsn_cd"      ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"port_skp_rsn_offr_rmk","" ,0);
			sheetObj.SetCellValue(sRow, prefix+"ts_port_cd"           ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"usd_flg"              ,"N",0);
			//sheetObj.SetCellValue(sRow, prefix+"vps_rmk"              ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"ttl_dlay_hrs"         ,"0",0);
			
			// sheet1, sheet2 common
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_eta_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etb_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etd_dt");
//			setSheetFontToOriginColor(sheetObj, sRow, prefix+"delay_date");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"dlay_date_text");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"sea_date_text");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_dist");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"lnk_spd");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"tztm_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"act_wrk_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"port_buf_hrs");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"sea_buf_hrs");
			
			// sheet2 
			if(glbSheetFlg == "sheet2"){
				var prePortRow=getNotSkipRow(sheetObj, sRow, "P");
				sheetObj.SetCellValue(prePortRow, prefix+"add_bnk_csm_qty","",0);
				sheetObj.SetCellValue(prePortRow, prefix+"add_bnk_cost_amt","",0);
				var tsRow=getTsPortRow(sheetObj, sRow);
				sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_20ft_ttl_qty","",0);
				sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_40ft_ttl_qty","",0);
				sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_20ft_ttl_amt","",0);
				sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_40ft_ttl_amt","",0);
				sheetObj.SetCellValue(sRow, prefix+"ts_port_cd","",0);
				sheetObj.SetCellValue(sRow, prefix+"ts_skd_voy_no","",0);
				sheetObj.SetCellValue(sRow, prefix+"ts_skd_dir_cd","",0);
				sheetObj.SetCellValue(sRow, prefix+"ts_clpt_ind_seq","",0);
				sheetObj.SetCellValue(sRow, prefix+"port_skp_rsn_offr_rmk","",0);
				sheetObj.SetCellValue(sRow, prefix+"rsn_skd_voy_no","",0);
				sheetObj.SetCellValue(sRow, prefix+"rsn_skd_dir_cd","",0);
				sheetObj.SetCellValue(sRow, prefix+"rsn_clpt_ind_seq","",0);
				sheetObj.SetCellValue(sRow, prefix+"pe_usd_ttl_amt","",0);
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"time_diff");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_in_hrs");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"mnvr_out_hrs");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"crn_knt");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_prod_qty");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ib_cgo_qty");
				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ob_cgo_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_csm_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"add_bnk_cost_amt");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_qty");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_qty");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_20ft_ttl_amt");
// 				setSheetFontToOriginColor(sheetObj, sRow, prefix+"ts_40ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_qty");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_amt");
//				setSheetFontToOriginColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_amt");
			}
			
			// Total Cost
			calcTotalCost(sheetObj);
			
			//Creating SKD again from skipped row
			if(sheetObj.id != "sheet1" || isGetColHidden== false){
				if(sRow == sheetObj.HeaderRows()){
					calcSchedule(sheetObj, sRow, sheetObj.SaveNameCol(prefix+"vps_eta_dt"));
				}else{
					calcSchedule(sheetObj, sRow-1, sheetObj.SaveNameCol(prefix+"vps_etd_dt"));
				}
			}
			if(isGetColHidden){
				showFieldControl(sheetObj, document.form, false);
			}
			
			sheetObj.RenderSheet(1);
			
			setRowControlBtnSts(sheetObj, sRow);

		}
		
	}
	/**
	 * [Add Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallControl(sheetObj, rowData){
		
		var formObj			= document.form;
		var curRow			= sheet1.GetSelectRow();
		var prefix			= "sheet1_";
		var pos				= rowData.position;
		
		var vtAddCallFlg	= rowData.vt_add_call_flg;
		var addCallXterFlg	= rowData.add_call_xter_flg;
		
		//alert('vtAddCallFlg [ '+vtAddCallFlg+' ]   addCallXterFlg [ '+addCallXterFlg+' ]');
		
		sheet1.RenderSheet(0);
		
		var isGetColHidden	= true;
		
		if(sheet1.id == "sheet1"){
			isGetColHidden=sheet1.GetColHidden(prefix+"lnk_dist");
		}else{
			isGetColHidden=sheet2.GetColHidden(prefix+"ib_cgo_qty");
		}
		
		
		if(pos == "before"){
			
			if(sheet1.GetCellValue(curRow, prefix+"bfr_act_flg") == "X" || sheet1.GetCellValue(curRow, prefix+"act_inp_flg") == "Y"){
				ComShowCodeMessage("VSK00081");
				sheet1.RenderSheet(1);
				return false;
			}
			//Adding before selected row
			sheet1.DataInsert(curRow);
			// Color Setting.
			sheet1.SetRowBackColor(curRow,sheet1.GetRowBackColor(curRow+1));
			sheet1.SetCellValue(curRow, prefix+"vvd",sheet1.GetCellValue(curRow+1, prefix+"vvd"),0);
			sheet1.SetCellValue(curRow, prefix+"vsl_cd",sheet1.GetCellValue(curRow+1, prefix+"vsl_cd"),0);
			sheet1.SetCellValue(curRow, prefix+"skd_voy_no",sheet1.GetCellValue(curRow+1, prefix+"skd_voy_no"),0);
			sheet1.SetCellValue(curRow, prefix+"skd_dir_cd",sheet1.GetCellValue(curRow+1, prefix+"skd_dir_cd"),0);
			sheet1.SetCellValue(curRow, prefix+"vsl_slan_cd",sheet1.GetCellValue(curRow+1, prefix+"vsl_slan_cd"),0);
			sheet1.SetCellValue(curRow, prefix+"slan_cd",sheet1.GetCellValue(curRow+1, prefix+"vsl_slan_cd"),0);
			sheet1.SetCellValue(curRow, prefix+"vps_port_cd",rowData.port_cd,0);
// 			sheetObj.CellValue2(curRow, prefix+"tml_cd") = rowData.yard_cd;
			sheet1.SetCellValue(curRow, prefix+"vps_eta_dt",rowData.eta,0);
			sheet1.SetCellValue(curRow, prefix+"vps_etb_dt",rowData.etb,0);
			sheet1.SetCellValue(curRow, prefix+"vps_etd_dt",rowData.etd,0);
			sheet1.SetCellValue(curRow, prefix+"init_eta_dt",rowData.eta,0);
			sheet1.SetCellValue(curRow, prefix+"init_etb_dt",rowData.etb,0);
			sheet1.SetCellValue(curRow, prefix+"init_etd_dt",rowData.etd,0);
			
			sheet1.SetCellValue(curRow, prefix+"auto_skd_cng_flg","1",0);
			
			/** adding column 'vt_add_call_flg' **/
			if(vtAddCallFlg == "Y"){
				sheet1.SetCellValue		(curRow, prefix+"vt_add_call_flg"	, vtAddCallFlg        	,0);
				sheet1.SetCellFontColor	(curRow, prefix+"skd_cng_sts_cd" 	, gVtAddCallFontColor  );
				
				sheet1.SetCellEditable	(curRow, prefix+"add_call_xter_flg",0);  
			}else{
				sheet1.SetCellEditable	(curRow, prefix+"add_call_xter_flg",1);  
			}
			
			if(addCallXterFlg == "Y"){
				sheet1.SetCellValue		(curRow, prefix+"add_call_xter_flg"	, "1"	, 0);
			}else{
				sheet1.SetCellValue		(curRow, prefix+"add_call_xter_flg"	, "0"	, 0);
			}
			
			sheet1.SetCellValue(curRow, prefix+"pf_skd_tp_cd",sheet1.GetCellValue(curRow+1, prefix+"pf_skd_tp_cd"),0);
			sheet1.SetCellValue(curRow, prefix+"pf_skd_tp_cd",sheet1.GetCellValue(curRow+1, prefix+"pf_svc_tp_cd"),0);
			/**************************************************************************/
			
			
			// port_time
			var dateObj		= new Usr_CalcTimeSet(rowData.etb);
			var timeDiff	= parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			
			sheet1.SetCellValue(curRow, prefix+"act_wrk_hrs"	, timeDiff, 0);
			sheet1.SetCellValue(curRow, prefix+"turn_port_flg", "N");
						
			
			if (rowData.turn_ind == "0") {
				sheet1.SetCellValue(curRow, prefix+"turn_port_flg","Y");
				
				if (sheet1.GetCellValue(curRow+1, prefix+"port_rotn_seq") 		== "1" ||
					sheet1.GetCellValue(curRow+1, prefix+"turn_port_ind_cd") 	== "N") {
					sheet1.SetCellValue(curRow  , prefix+"turn_port_ind_cd"		, "" , 0);
					sheet1.SetCellValue(curRow  , prefix+"port_rotn_seq"		, "1", 0);
					sheet1.SetCellValue(curRow+1, prefix+"turn_port_ind_cd"		, "Y", 0);
					sheet1.SetCellValue(curRow+1, prefix+"port_rotn_seq"		, "2", 0);
				}
			}
			
			formObj.loc_cd.value	= rowData.port_cd;
			formObj.yd_cd.value		= rowData.yard_cd;
			

	    	/**************************************************************************/			
			/** RE-MAKING Calculation Logic for Change Schedule [by TOP][2015-04-26] **/
			var actWrkHrs	= parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			
	    	var headCnt		= sheet1.HeaderRows();
	    	var totCnt		= getTotalRowCnt(sheet1);

	    	var preRow		= 0;
	    	var nxtRow		= 0;
	    	
//	    	for(var i=curRow-1; i>=headCnt-1; i--){
//    		if(sheet1.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
//    			preRow	= i;
//    			break;
//    		}
//    	}
//    	
//    	for(var i=curRow+1; i<totCnt; i++){
//    		if(sheet1.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
//    			nxtRow	= i;
//    			break;
//    		}
//    	}

	    	preRow	= getNotSkipRow(sheet1, curRow, "P");
	    	nxtRow	= getNotSkipRow(sheet1, curRow, "N");

	    	//alert(' curRow ['+curRow+']  preRow ['+preRow+'] --- nxtRow ['+nxtRow+']');
	    	
			sheet1.SetCellValue	(curRow, prefix+"skd_cng_sts_cd", "A", 0);
			
			if(vtAddCallFlg != "Y"){
				sheet1.SetCellValue	(curRow, prefix+"add_call_flg", "Y", 0);	
			}
			sheet1.SelectCell	(curRow, sheet1.GetSelectCol()		);
			
			//alert('first preRow ['+preRow+']   curRow ['+curRow+']  port pair ['+sheet1.GetCellValue(preRow, prefix+"vps_port_cd")+' >> '+sheet1.GetCellValue(curRow, prefix+"vps_port_cd")+']');
	    	if(preRow>0){
				var sXml	= doUnitCallBaseInfo(sheet1, preRow, curRow);

				// Setting Dist, Sea Time
				if(sXml != null && sXml != undefined && sXml != ""){
					if(isGetColHidden == false){
						setUnitAddPortBaseInfo(sheet1, sXml, preRow, curRow, actWrkHrs);
					}
				}
	    	}
	    	
	    	//alert('second curRow ['+curRow+']   nxtRow ['+nxtRow+']  port pair ['+sheet1.GetCellValue(curRow, prefix+"vps_port_cd")+' >> '+sheet1.GetCellValue(nxtRow, prefix+"vps_port_cd")+']');
	    	if(nxtRow>0){
				var sXml	= doUnitCallBaseInfo(sheet1, curRow, nxtRow);
				
				// Setting Dist, Sea Time
				if(sXml != null && sXml != undefined && sXml != ""){
					if(isGetColHidden == false){
						setUnitAddPortBaseInfo(sheet1, sXml, curRow, nxtRow, actWrkHrs);
					}
				}
	    	}
	    	/**************************************************************************/
//			
			
// 			***********************************************************
////by top//			var sXml				= doCallBaseInfo(sheet1, sRow, "ADD");
// 			***********************************************************
			
	    ////by top//			sheet1.SetCellValue	(sRow, prefix+"skd_cng_sts_cd", "A", 0);
	    ////by top//			sheet1.SelectCell	(sRow, sheet1.GetSelectCol()		);
			// Setting Dist, Sea Time
	    ////by top//			if(sXml != null && sXml != undefined && sXml != ""){
	    ////by top//				if(isGetColHidden == false){
	    ////by top//					setBaseInfo(sheet1, sXml, sRow, "ADD");
	    ////by top//				}
	    ////by top//			}
			
	    	
	    /** pos == "after"  **/
		}else{
			
			//Adding before selected row
			sheet1.DataInsert(curRow+1);
			// Color Setting.
			sheet1.SetRowBackColor(curRow+1,sheet1.GetRowBackColor(curRow));
			sheet1.SetCellValue(curRow+1, prefix+"vvd",sheet1.GetCellValue(curRow, prefix+"vvd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"vsl_cd",sheet1.GetCellValue(curRow, prefix+"vsl_cd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"skd_voy_no",sheet1.GetCellValue(curRow, prefix+"skd_voy_no"),0);
			sheet1.SetCellValue(curRow+1, prefix+"skd_dir_cd",sheet1.GetCellValue(curRow, prefix+"skd_dir_cd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"vsl_slan_cd",sheet1.GetCellValue(curRow, prefix+"vsl_slan_cd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"slan_cd",sheet1.GetCellValue(curRow, prefix+"vsl_slan_cd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"vps_port_cd",rowData.port_cd,0);
// 			sheetObj.CellValue2(curRow, prefix+"tml_cd") = rowData.yard_cd;
			sheet1.SetCellValue(curRow+1, prefix+"vps_eta_dt",rowData.eta,0);
			sheet1.SetCellValue(curRow+1, prefix+"vps_etb_dt",rowData.etb,0);
			sheet1.SetCellValue(curRow+1, prefix+"vps_etd_dt",rowData.etd,0);
			sheet1.SetCellValue(curRow+1, prefix+"init_eta_dt",rowData.eta,0);
			sheet1.SetCellValue(curRow+1, prefix+"init_etb_dt",rowData.etb,0);
			sheet1.SetCellValue(curRow+1, prefix+"init_etd_dt",rowData.etd,0);
			sheet1.SetCellValue(curRow+1, prefix+"auto_skd_cng_flg","1",0);
			// port_time(ETD - ETB)
			var dateObj=new Usr_CalcTimeSet(rowData.etb);
			var timeDiff=parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			sheet1.SetCellValue(curRow+1, prefix+"act_wrk_hrs",timeDiff,0);
			sheet1.SetCellValue(curRow+1, prefix+"turn_port_flg","N");
			
			/** adding column 'vt_add_call_flg' **/
			if(vtAddCallFlg == "Y"){
				sheet1.SetCellValue		(curRow+1, prefix+"vt_add_call_flg"	, vtAddCallFlg			,0);
				sheet1.SetCellFontColor (curRow+1, prefix+"skd_cng_sts_cd"	, gVtAddCallFontColor);
				
				sheet1.SetCellEditable	(curRow+1, prefix+"add_call_xter_flg",0);  
			}else{
				sheet1.SetCellEditable	(curRow+1, prefix+"add_call_xter_flg",1);  
			}
			
			if(addCallXterFlg == "Y"){
				sheet1.SetCellValue		(curRow+1, prefix+"add_call_xter_flg", "1", 0);
			}else{
				sheet1.SetCellValue		(curRow+1, prefix+"add_call_xter_flg", "0", 0);
			}
			
			sheet1.SetCellValue(curRow+1, prefix+"pf_skd_tp_cd",sheet1.GetCellValue(curRow, prefix+"pf_skd_tp_cd"),0);
			sheet1.SetCellValue(curRow+1, prefix+"pf_skd_tp_cd",sheet1.GetCellValue(curRow, prefix+"pf_svc_tp_cd"),0);
			/**************************************************************************/
			
			
			if (rowData.turn_ind == "0") {
				sheet1.SetCellValue(curRow+1, prefix+"turn_port_flg","Y");
			}
			formObj.loc_cd.value	= rowData.port_cd;
			formObj.yd_cd.value		= rowData.yard_cd;
			
			

	    	/**************************************************************************/			
			/** RE-MAKING Calculation Logic for Change Schedule [by TOP][2015-04-26] **/
			curRow			= curRow+1;
			
			var actWrkHrs	= parseInt(dateObj.getTimeDiff(rowData.etd), 10);
			
	    	var headCnt		= sheet1.HeaderRows();
	    	var totCnt		= getTotalRowCnt(sheet1);

	    	var preRow		= 0;
	    	var nxtRow		= 0;
	    	
//	    	for(var i=curRow-1; i>=headCnt-1; i--){
//	    		if(sheet1.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
//	    			preRow	= i;
//	    			break;
//	    		}
//	    	}
//	    	
//	    	for(var i=curRow+1; i<totCnt; i++){
//	    		if(sheet1.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
//	    			nxtRow	= i;
//	    			break;
//	    		}
//	    	}

	    	preRow	= getNotSkipRow(sheet1, curRow, "P");
	    	nxtRow	= getNotSkipRow(sheet1, curRow, "N");
	    	
	    	//alert(' curRow ['+curRow+']  preRow ['+preRow+'] --- nxtRow ['+nxtRow+']');
	    	
	    	sheet1.SetCellValue	(curRow, prefix+"skd_cng_sts_cd", "A", 0);
	    	if(vtAddCallFlg != "Y"){
	    		sheet1.SetCellValue	(curRow, prefix+"add_call_flg", "Y", 0);	
	    	}
	    	
	    	
			sheet1.SelectCell	(curRow, sheet1.GetSelectCol()		);
			
			//alert('first preRow ['+preRow+']   curRow ['+curRow+']  port pair ['+sheet1.GetCellValue(preRow, prefix+"vps_port_cd")+' >> '+sheet1.GetCellValue(curRow, prefix+"vps_port_cd")+']');
	    	if(preRow>0){
				var sXml	= doUnitCallBaseInfo(sheet1, preRow, curRow);

				// Setting Dist, Sea Time
				if(sXml != null && sXml != undefined && sXml != ""){
					if(isGetColHidden == false){
						setUnitAddPortBaseInfo(sheet1, sXml, preRow, curRow, actWrkHrs);
					}
				}
	    	}
	    	
	    	//alert('second curRow ['+curRow+']   nxtRow ['+nxtRow+']  port pair ['+sheet1.GetCellValue(curRow, prefix+"vps_port_cd")+' >> '+sheet1.GetCellValue(nxtRow, prefix+"vps_port_cd")+']');
	    	if(nxtRow>0){
				var sXml	= doUnitCallBaseInfo(sheet1, curRow, nxtRow);
				
				// Setting Dist, Sea Time
				if(sXml != null && sXml != undefined && sXml != ""){
					if(isGetColHidden == false){
						setUnitAddPortBaseInfo(sheet1, sXml, curRow, nxtRow, actWrkHrs);
					}
				}
	    	}
	    	/**************************************************************************/			
			
			
// 			***********************************************************
		////by top//			var sXml	= doCallBaseInfo(sheet1, curRow+1, "ADD");
// 			***********************************************************
		////by top//			sheet1.SetCellValue(curRow+1, prefix+"skd_cng_sts_cd","A",0);
		////by top//sheet1.SelectCell(curRow+1, sheet1.GetSelectCol());
			// Setting Dist, Sea Time
		////by top//			if(sXml != null && sXml != undefined && sXml != ""){
		////by top//				if(isGetColHidden== false){
		////by top//					setBaseInfo(sheet1, sXml, curRow+1, "ADD");
		////by top//				}
		////by top//			}
			
			
			
		}
		
		sheet1.RenderSheet(1);
		resetClptSeq	(sheet1);	// clpt_seq reset
		resetClptIndSeq	(sheet1);	// clpt_ind_seq reset
		initPortDataFlg	(sheet1);	// Terminal reRetrieve Flag Initializing.
		
		setRowControlBtnSts(sheetObj, curRow);
	}
	
	/**
	 * [Add Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallCancel(sheetObj){
		
		var curRow	= sheetObj.GetSelectRow();
		var prefix	= sheetObj.id + "_";
		var formObj	= document.form;
		
		if(sheetObj.GetCellValue(curRow, prefix+"skd_cng_sts_cd") == "A"){
//		if(sheetObj.CellValue(curRow, prefix+"ibflag") == "I"){
			var isGetColHidden=true;
			if(sheetObj.id == "sheet1"){
				isGetColHidden=sheetObj.GetColHidden(prefix+"lnk_dist");
			}else{
				isGetColHidden=sheetObj.GetColHidden(prefix+"ib_cgo_qty");
			}
			var sXml	= doCallBaseInfo(sheetObj, curRow, "ADD_CANCEL");
			
			sheetObj.RenderSheet(0);
			if(isGetColHidden == false){
				//Setting Dist, Sea Time
				setBaseInfo(sheetObj, sXml, curRow, "ADD_CANCEL");
			}
			
//			if(sheetObj.CellValue(curRow, prefix+"ibflag") == "I"){
			if(sheetObj.GetRowStatus(curRow) == "I"){
				
				//alert('deleted row ['+curRow+'] port cd ['+sheetObj.GetCellValue(curRow, prefix+"vps_port_cd")+']');
				sheetObj.RowDelete(curRow, false);
				
				////////////////////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////////////////////
				
				//alert('curRow-1  lnk_dist_for_recovery ['+sheetObj.GetCellValue(curRow-1, prefix+"lnk_dist_for_recovery")+']');
				
				sheetObj.SetCellValue	(curRow-1, prefix+"lnk_dist"		,sheetObj.GetCellValue(curRow-1, prefix+"lnk_dist_for_recovery")		,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"tztm_hrs"		,sheetObj.GetCellValue(curRow-1, prefix+"tztm_hrs_for_recovery")		,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"lnk_spd"		,sheetObj.GetCellValue(curRow-1, prefix+"lnk_spd_for_recovery")		,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"act_wrk_hrs"	,sheetObj.GetCellValue(curRow-1, prefix+"act_wrk_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"time_diff"		,sheetObj.GetCellValue(curRow-1, prefix+"time_diff_for_recovery")		,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"mnvr_in_hrs"	,sheetObj.GetCellValue(curRow-1, prefix+"mnvr_in_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"mnvr_out_hrs"	,sheetObj.GetCellValue(curRow-1, prefix+"mnvr_out_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"sea_buf_hrs"	,sheetObj.GetCellValue(curRow-1, prefix+"sea_buf_hrs_for_recovery")	,0);
				sheetObj.SetCellValue	(curRow-1, prefix+"port_buf_hrs"	,sheetObj.GetCellValue(curRow-1, prefix+"port_buf_hrs_for_recovery")	,0);
								
				//alert('after port cd ['+sheetObj.GetCellValue(curRow-1, prefix+"vps_port_cd")+']');
				
				
// 				===================================================================================
				sheetObj.SetCellBackColor	(curRow-1, prefix+"lnk_dist"			,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(curRow-1, prefix+"tztm_hrs"			,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(curRow-1, prefix+"lnk_spd"			,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(curRow-1, prefix+"time_diff"			,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(curRow-1, prefix+"mnvr_in_hrs"		,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				sheetObj.SetCellBackColor	(curRow-1, prefix+"mnvr_out_hrs"		,sheetObj.GetCellBackColor(curRow-1, prefix+"skd_cng_sts_cd"));
				//---------------------------------------------------------------------------------
				
				
				////////////////////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////////////////////
				
			}else{
				
//				sheetObj.CellValue2(curRow, prefix+"ibflag") = "D";
				sheetObj.SetRowStatus(curRow, "D");
				sheetObj.SetRowHidden(curRow, 1  );

				
		    	/**************************************************************************/			
				/** RE-MAKING Calculation Logic for Change Schedule [by TOP][2015-04-26] **/
		    	var preRow		= getNotSkipRow(sheetObj, curRow, "P");
		    	var nxtRow		= getNotSkipRow(sheetObj, curRow, "N");
		    	
		    	var actWrkHrs	= sheetObj.GetCellValue(preRow, prefix+"act_wrk_hrs");
		    	
				//alert('first preRow ['+preRow+']   nxtRow ['+nxtRow+']  port pair ['+sheetObj.GetCellValue(preRow, prefix+"vps_port_cd")+' >> '+sheetObj.GetCellValue(nxtRow, prefix+"vps_port_cd")+']');
		    	if(preRow>0 && nxtRow>0){

		    		//Dist Retrieve
		    		var portCd				= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		    		
		    		/** Setting Distance+Speed+Sea Time on between previous and current port **/
		    		formObj.fm_loc_cd.value	= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		    		formObj.to_loc_cd.value	= sheetObj.GetCellValue(nxtRow, prefix+"vps_port_cd");
		    		
		    		formObj.loc_cd.value	= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		    		formObj.yd_cd.value		= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd") + sheetObj.GetCellValue(preRow, prefix+"tml_cd");
		    		
		    		sXml					= doActionIBSheet(sheetObj, formObj, SEARCH06);
		    		
					// Setting Dist, Sea Time
					if(sXml != null && sXml != undefined && sXml != ""){
						////by top//if(isGetColHidden == false){
						setUnitAddPortBaseInfo(sheetObj, sXml, preRow, actWrkHrs);
						////by top//}
					}
					
		    	}else{
		    		
		    		null;
		    		
		    	}
		    	
		    	/**************************************************************************/				
				
			}
			
			if (sheet1.GetCellValue(curRow, prefix+"port_rotn_seq") == "1" ||
					  sheet1.GetCellValue(curRow, prefix+"turn_port_ind_cd") == "N") {
				sheet1.SetCellValue(curRow+1 , prefix+"turn_port_ind_cd","" ,0);
				sheet1.SetCellValue(curRow+1 , prefix+"port_rotn_seq","1"   ,0);
			}
			// clpt_seq reset
			resetClptSeq(sheetObj);
			// clpt_ind_seq reset
			resetClptIndSeq(sheetObj);
			// Terminal reRetrieve Flag Initializing.
			initPortDataFlg(sheetObj);
			sheetObj.RenderSheet(1);
		}
		
//		if(sheetObj.id == "sheet1"){
//			ComBtnDisable("btn_add_call_cancel_1");
//		}else{
//			ComBtnDisable("btn_add_call_cancel_2");
//		}
	}
	/**
	 * [Reverse Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function reverseCallControl(sheetObj){
		
		if(!rowDataChange(sheetObj)){
			return false;
		}
		
		if(sheetObj.id == "sheet1"){
			ComBtnDisable("btn_reverse_call_1");
		}else{
			ComBtnDisable("btn_reverse_call_2");
		}
	}
	/**
	 * [Reverse Call Change] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function reverseCallChange(sheetObj){
		if(!rowDataChange(sheetObj)){
			return false;
		}
//		if(sheetObj.id == "sheet1"){
//			ComBtnDisable("btn_reverse_call_cancel_1");
// 		}else{
// 			ComBtnDisable("btn_reverse_call_cancel_2");
// 		}
	}
	/**
	 * [Phase Out] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function phaseOutControl(sheetObj){
		
		var prefix	= sheetObj.id + "_";
		var curRow	= sheetObj.GetSelectRow	();
		var headRow	= sheetObj.HeaderRows	();
		var totCnt	= getTotalRowCnt		(sheetObj);
		
		for(var i=curRow+1; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") != "H"){
				sheetObj.SetCellValue(i, prefix+"tmp_phase_flag","H",0);
				
				/** Adding Logic for prohibitting inserted rows to be disappered when P/OUT : by TOP - 2015-10-27 **/
				sheetObj.SetRowStatus(i,"U");
				
// 				sheetObj.CellValue2(i, prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(i,
// 				prefix+"skd_cng_sts_cd");
// 				sheetObj.CellValue2(i, prefix+"skd_cng_sts_cd") = "O";
				// data from Pop-up
				sheetObj.SetCellValue(i, prefix+"cng_lane_cd"	,"",0);
				sheetObj.SetCellValue(i, prefix+"cng_vsl_cd"	,"",0);
				sheetObj.SetCellValue(i, prefix+"cng_skd_voy_no","",0);
				sheetObj.SetCellValue(i, prefix+"cng_skd_dir_cd","",0);
				
				sheetObj.SetRowHidden(i,1);
			}
		}
		sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","O",0);
		
		setRowControlBtnSts(sheetObj, curRow);
	}

	/**
	 * [Phase In Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function phaseInCancelControl(sheetObj, formObj){
		var prefix		= sheetObj.id + "_";
		var curRow		= sheetObj.GetSelectRow();
		var headRow		= sheetObj.HeaderRows();
		var totCnt		= getTotalRowCnt(sheetObj);
		var isSvrFlg	= true;
		
		var skpCallFlg			= sheetObj.GetCellValue(curRow, prefix+"skp_call_flg");
		var addCallFlg			= sheetObj.GetCellValue(curRow, prefix+"add_call_flg");
		
		if(skpCallFlg == "Y"){
			sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
		}else if(addCallFlg == "Y"){
			sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
		}else{
			sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);	
		}
		sheetObj.SetCellValue(curRow, prefix+"phs_io_rsn_cd"	, "", 0);
		sheetObj.SetCellValue(curRow, prefix+"phs_io_rmk"		, "", 0);
		
		setRowControlBtnSts(sheetObj, curRow);
	}
	
	/**
	 * Private Call or Cancellation 
	 * @param sheetObj
	 * @return
	 */
	function privateCallControl(sheetObj, sFlag){
		var prefix		= sheetObj.id + "_";
		var curRow		= sheetObj.GetSelectRow();
		var headRow		= sheetObj.HeaderRows();
		var totCnt		= getTotalRowCnt(sheetObj);
		var isSvrFlg	= true;
		
		if(sFlag == "PRIVATE_CALL"){
			sheetObj.SetCellValue(curRow, prefix+"priv_call_flg","Y",0);
		}else if(sFlag == "PRIVATE_CALL_CANCEL"){
			sheetObj.SetCellValue(curRow, prefix+"priv_call_flg","N",0);
		}
		
		setRowControlBtnSts(sheetObj, curRow);
	}	
	
	/**
	 * [Phase Out Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function phaseOutCancelControl(sheetObj, formObj){
		
		var prefix		= sheetObj.id + "_";
		var curRow		= sheetObj.GetSelectRow();
		var headRow		= sheetObj.HeaderRows();
		var totCnt		= getTotalRowCnt(sheetObj);
		var isSvrFlg	= true;
		
		sheetObj.SetCellValue(curRow, prefix+"phs_io_rsn_cd"	, "", 0);
		sheetObj.SetCellValue(curRow, prefix+"phs_io_rmk"		, "", 0);
		
		var skpCallFlg			= sheetObj.GetCellValue(curRow, prefix+"skp_call_flg");
		var addCallFlg			= sheetObj.GetCellValue(curRow, prefix+"add_call_flg");

		var curRowVT	= sheetObj.GetCellValue(curRow, prefix+"vt_add_call_flg");
		if(curRowVT != undefined && curRowVT == "Y"){
			var isCurRowVT	= true;
		}else{
			var isCurRowVT	= false;
		}
		
		sheetObj.RenderSheet(0);
		for(var i=curRow+1; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"tmp_phase_flag") == "H" && sheetObj.GetRowHidden(i)){
				isSvrFlg	= false;
				if(sheetObj.GetCellValue(i-1, prefix+"skd_cng_sts_cd") == "O"){
					if(skpCallFlg == "Y"){
						sheetObj.SetCellValue(i-1, prefix+"skd_cng_sts_cd","S",0);
					}else if(addCallFlg == "Y"){
						sheetObj.SetCellValue(i-1, prefix+"skd_cng_sts_cd","A",0);
					}else{
						sheetObj.SetCellValue(i-1, prefix+"skd_cng_sts_cd","",0);	
					}
					
				}
				sheetObj.SetCellValue(i, prefix+"tmp_phase_flag", "");
// 				sheetObj.CellValue2(i, prefix+"skd_cng_sts_cd") = sheetObj.CellValue(i, prefix+"tmp_cng_sts_cd");
				// data from Pop-up
				sheetObj.SetCellValue(i, prefix+"cng_lane_cd"	, "", 0);
				sheetObj.SetCellValue(i, prefix+"cng_vsl_cd"	, "", 0);
				sheetObj.SetCellValue(i, prefix+"cng_skd_voy_no", "", 0);
				sheetObj.SetCellValue(i, prefix+"cng_skd_dir_cd", "", 0);
				sheetObj.SetRowHidden(i,0);
				
			}
			
		}
		
//		if(curRow == totCnt){
//			isSvrFlg	= false;
//			if(sheetObj.GetCellValue(curRow, prefix+"skd_cng_sts_cd") == "O"){
//				if(skpCallFlg == "Y"){
//					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
//				}else if(addCallFlg == "Y"){
//					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
//				}else{
//					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);	
//				}
//			}
//		}
		
		if(curRow == totCnt){
			isSvrFlg	= true;
		}else{
			isSvrFlg	= false;
		}		
		
		//in case saved Phase Out Cancel
		if(isSvrFlg){
			var sAction	= SEARCH08;
			if(sheetObj.id == "sheet2") sAction	= SEARCH09;
			var sXml	= doActionIBSheet(sheetObj, formObj, sAction);
			
			if(sXml != null){
				var rootNode = VskGetXmlRootNode(sXml);
				var dataNode = ComGetSelectSingleNode(sXml, "TOTAL");
				
				if(dataNode){
					var totValue	= dataNode;
				
					if(totValue > 0){
						
						sheetObj.RenderSheet(0);
						if(sheetObj.id == "sheet1"){
							sheetObj.LoadSearchData(sXml, {Append:1 , Sync:1});
						}else{
							sheetObj.LoadSearchData(sXml, {Append:1 , Sync:1});
						}
						sheetObj.RenderSheet(1);
						
						initPortDataFlg	(sheetObj);
						// clpt_seq reset
						
						resetClptSeq	(sheetObj);
						// clpt_ind_seq reset
						
						resetClptIndSeq	(sheetObj);
						
			    		var ydCds	= ComGetEtcData(sXml, "tml_cd").split("|");
			    		var ydIdx	= 0;
				    	for(var i=curRow+1; i <= sheetObj.LastRow(); i++) {
//				    		if(sheetObj.CellValue(i, prefix+"clpt_seq") != "TOTAL"){
					    		sheetObj.CellComboItem(i,prefix+"tml_cd", {ComboText:ydCds[ydIdx], ComboCode:ydCds[ydIdx]} );
//					    		sheetObj.CellValue2(i, prefix+"ibflag") = "I";
					    		sheetObj.SetRowStatus(i,"I");
					    		ydIdx++;
// 							}
				    	}
						//sheetObj.RenderSheet(1);
						//sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);
					}else{
						// do not!
					}
					//sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);
					
					if(sheetObj.GetCellValue(curRow, prefix+"skd_cng_sts_cd") == "O"){
						if(skpCallFlg == "Y"){
							sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
						}else if(addCallFlg == "Y"){
							sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
						}else{
							sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);	
						}
					}
				}
			}
		}

		if(curRow == totCnt){
			if(sheetObj.GetCellValue(curRow, prefix+"skd_cng_sts_cd") == "O"){
				if(skpCallFlg == "Y"){
					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
				}else if(addCallFlg == "Y"){
					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
				}else{
					sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","",0);	
				}
			}
		}
		sheetObj.RenderSheet(1);
		
		for(var i=headRow; i<=totCnt; i++){
			
			/******************************************************************************/
			/** 2015-11-04 : by TOP : Return to Virtual Add Call due to P/O cancellation **/
			var virtualAddCallFlg	= sheetObj.GetCellValue(i, prefix+"vt_add_call_flg");
			
			if(virtualAddCallFlg != undefined && virtualAddCallFlg == "Y"){
				//alert('i ['+i+'] / ['+totCnt+'] :: virtualAddCallFlg ['+virtualAddCallFlg+']');
				
				sheetObj.SetCellValue(i, prefix+"skd_cng_sts_cd", "A", 0);	
			}
			/******************************************************************************/
			
		}
		
		setRowControlBtnSts(sheetObj, curRow);
	}
    /**
     * [Expand]/[Hidden] Button Event
     * @param sheetObj
     * @param showFlg	true: show, false: hidden
     * @return
     */
    function showFieldControl(sheetObj, formObj, showFlg){
    	//alert( "showFieldControl "  + showFlg );
    	sheetObj.RenderSheet(0);

    	var prefix=sheetObj.id + "_";
		if(sheetObj.id == "sheet1"){
	    	if(showFlg){
	    		ComBtnEnable("btn_col_hide");
	    		ComBtnDisable("btn_col_show");
	    		//btn2ControlHtml("div_col_show", "btn_col_show", "Expand ", "btn_normal", "120");	// disabled
	    		//btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden ", "btn_normal", "120");	// un_disabled
	    		if(sheetObj.GetColHidden(prefix+"lnk_dist")){
	    			colHiddenControl(sheetObj, false);
	    		}
	    	} else {
	    		ComBtnEnable("btn_col_show");
	    		ComBtnDisable("btn_col_hide");
	    		//btn2ControlHtml("div_col_show", "btn_col_show", "Expand ", "btn_normal", "120");	// un_disabled
	    		//btn2ControlHtml("div_col_hide", "btn_col_hide", "Hidden ", "btn_normal", "120");	// disabled
	    		if(!sheetObj.GetColHidden(prefix+"lnk_dist")){
	    			colHiddenControl(sheetObj, true);
	    		}
	    	}
		} else {
	    	if(showFlg){
	    		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand ", "btn_normal", "120");	// disabled
	    		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden ", "btn_normal", "120");	// un_disabled
	    		if(sheetObj.GetColHidden(prefix+"ib_cgo_qty")){
	    			colHiddenControl(sheetObj, false);
	    		}
	    	} else {
	    		btn2ControlHtml("div_plan_col_show", "btn_plan_col_show", "Expand ", "btn_normal", "120");	// un_disabled
	    		btn2ControlHtml("div_plan_col_hide", "btn_plan_col_hide", "Hidden ", "btn_normal", "120");	// disabled
	    		if(!sheetObj.GetColHidden(prefix+"ib_cgo_qty")){
	    			colHiddenControl(sheetObj, true);
	    		}
	    	}
		}
		sheetObj.RenderSheet(1);
    }
    /**
     * [Expand]/[Hidden] Button Control
     * @param sheetObj
     * @param bFlg		Hidden- true : Hidden, false : Block
     * @return
     */
    function colHiddenControl(sheetObj, bFlg){
    	var prefix=sheetObj.id + "_";
    	if(sheetObj.id == "sheet1"){
	    	with(sheetObj){
				SetColHidden(prefix+"lnk_dist",bFlg);
				SetColHidden(prefix+"lnk_spd",bFlg);
				SetColHidden(prefix+"tztm_hrs",bFlg);
				SetColHidden(prefix+"act_wrk_hrs",bFlg);
				SetColHidden(prefix+"port_buf_hrs",bFlg);
				SetColHidden(prefix+"sea_buf_hrs",bFlg);
				if( bFlg == false){
					sheetObj.SetColWidth(prefix+ "upd_sts", 60 );
				}
	    	}
    	}else{
	    	with(sheetObj){
//    			ColHidden(prefix+"act_wrk_hrs") = bFlg;
    			SetColHidden(prefix+"ib_cgo_qty",bFlg);
    			SetColHidden(prefix+"ob_cgo_qty",bFlg);
    			SetColHidden(prefix+"crn_knt",bFlg);
    			SetColHidden(prefix+"tml_prod_qty",bFlg);
//    			ColHidden(prefix+"add_bnk_csm_qty") = bFlg;
//    			ColHidden(prefix+"add_bnk_cost_amt") = bFlg;
// 				ColHidden(prefix+"ts_20ft_ttl_qty") = bFlg;
// 				ColHidden(prefix+"ts_40ft_ttl_qty") = bFlg;
// 				ColHidden(prefix+"ts_20ft_ttl_amt") = bFlg;
// 				ColHidden(prefix+"ts_40ft_ttl_amt") = bFlg;
       			SetColHidden(prefix+"tml_hndl_20ft_ttl_qty",bFlg);
    			SetColHidden(prefix+"tml_hndl_40ft_ttl_qty",bFlg);
    			SetColHidden(prefix+"tml_hndl_20ft_ttl_amt",bFlg);
    			SetColHidden(prefix+"tml_hndl_40ft_ttl_amt",bFlg);
    			SetColHidden(prefix+"pe_usd_ttl_amt",bFlg);
    			SetColHidden(prefix+"total_cost",bFlg);
	    	}
    	}
    }
	/**
	 * Handling data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value=rtnDatas[1];
					Usr_setVslCd(formObj.vsl_cd.value);
					var sheetObj=sheetObjects[0];
					if(glbSheetFlg == "sheet2"){
						sheetObj=sheetObjects[1];
					}
					/*if(formObj.sim_dt.value == "" && sheetObj.RowCount()> 0){
	            		resetAllData(sheetObj, formObj);
	            	}*/
				}
			}
    	}
    }
    /**
     * Handling data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value=rtnDatas[2];
					formObj.skd_dir_cd.value=rtnDatas[3];
					Usr_setSkdVoyNo(formObj.skd_voy_no.value);
					Usr_setSkdDirCd(formObj.skd_dir_cd.value);
					var sheetObj=sheetObjects[0];
					if(glbSheetFlg == "sheet2"){
						sheetObj=sheetObjects[1];
					}
					/*if(formObj.sim_dt.value == "" && sheetObj.RowCount()> 0){
	            		resetAllData(sheetObj, formObj);
	            	}*/
				}
			}
    	}
    }
	
	/**
	 * Vessle Rename (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnRenameHelp(rtnObjs){

		var sheetObj = sheetObjects[0];
		var prefix = sheetObj.id + "_";
		var curRow=sheetObj.GetSelectRow();
		
		var skpCallFlg			= sheetObj.GetCellValue(curRow, prefix+"skp_call_flg");
		var addCallFlg			= sheetObj.GetCellValue(curRow, prefix+"add_call_flg");

		if(rtnObjs.skd_cng_sts_cd == ""){ //Reename Cancel
			if(skpCallFlg == "Y"){
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
			}else if(addCallFlg == "Y"){
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
			}else{
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd",          rtnObjs.skd_cng_sts_cd, 0);	
			}
		}else{
			sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd",          rtnObjs.skd_cng_sts_cd, 0);
		}
		sheetObj.SetCellValue(curRow, prefix+"vsl_renm_old_vsl_cd",     rtnObjs.vsl_renm_old_vsl_cd, 0);
		sheetObj.SetCellValue(curRow, prefix+"vsl_renm_old_vsl_eng_nm", rtnObjs.vsl_renm_old_vsl_eng_nm, 0);
		sheetObj.SetCellValue(curRow, prefix+"vsl_renm_new_vsl_cd",     rtnObjs.vsl_renm_new_vsl_cd, 0);
		sheetObj.SetCellValue(curRow, prefix+"vsl_renm_new_vsl_eng_nm", rtnObjs.vsl_renm_new_vsl_eng_nm, 0);

		
		setRowControlBtnSts(sheetObj, curRow);
	}
	/**
	 * Handling data from Simulation No. Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnSimNoHelp(rtnObjs){
		var formObj=document.form;
		
		if(rtnObjs){
			//alert( rtnObjs.sim_dt);
			//alert( rtnObjs.sim_no);
			
			/*var simNo=rtnObjs.sim_dt+rtnObjs.sim_no;
			if(simNo != null && simNo != undefined && simNo != ""){
				clearAllData(sheetObjects[1], formObj);
				formObj.sim_dt.value=rtnObjs.sim_dt;
				formObj.sim_no.value=rtnObjs.sim_no;
				Usr_setSimDt(formObj.sim_dt.value);
				Usr_setSimNo(formObj.sim_no.value);
					
			}*/
		}
	}
	/**
	 * Handling data from Port Skip Recorder for Statistics (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnSkipCallHelp(rtnObjs){
		
		if(rtnObjs.length > 0){
			var formObj		= document.form;
			var sheetObj	= null;
			if(glbSheetFlg == "sheet1"){
				sheetObj	= sheetObjects[0];
			}else{
				sheetObj	= sheetObjects[1];
			}
			var prefix		= sheetObj.id+"_";
			var headCnt		= sheetObj.HeaderRows();
			var totCnt		= getTotalRowCnt(sheetObj);
			var currRow		= 0;
			var idx			= 0;
			
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S" || i == sheetObj.GetSelectRow()){
					var rtnDatas	= rtnObjs[idx];
					if(rtnDatas != null && rtnDatas != undefined && rtnDatas.length > 0){
						sheetObj.SetCellValue(i, prefix+"ts_port_cd"			,rtnDatas[13]	,0);		// ts_port_cd
						sheetObj.SetCellValue(i, prefix+"usd_flg"				,rtnDatas[3]	,0);		// Report(DB:USD_FLG)
						sheetObj.SetCellValue(i, prefix+"port_skp_tp_cd"		,rtnDatas[4]	,0);		// Force Majeure(DB:PORT_SKP_TP_CD)
						
						//::2015-04-23:HA YO NA:://sheetObj.SetCellValue(i, prefix+"port_skp_rsn_offr_rmk"	,rtnDatas[17],0);// rsn_port_cd
						sheetObj.SetCellValue(i, prefix+"port_skp_rsn_offr_rmk"	,rtnDatas[9]	,0);		// rsn_port_cd
						
						sheetObj.SetCellValue(i, prefix+"port_skp_rsn_cd"		,rtnDatas[6]	,0);		//
						sheetObj.SetCellValue(i, prefix+"ttl_dlay_hrs"			,rtnDatas[7]	,0);		// Hours(DB:TTL_DLAY_HRS)
						
						//::2015-04-23:HA YO NA:://sheetObj.SetCellValue(i, prefix+"vps_rmk"				,rtnDatas[9],0);// vps_rmk
						
						sheetObj.SetCellValue(i, prefix+"ts_skd_voy_no"			,rtnDatas[14]	,0);		// ts_skd_voy_no
						sheetObj.SetCellValue(i, prefix+"ts_skd_dir_cd"			,rtnDatas[15]	,0);		// ts_skd_dir_cd
						sheetObj.SetCellValue(i, prefix+"ts_clpt_ind_seq"		,rtnDatas[16]	,0);		// ts_clpt_ind_seq
						sheetObj.SetCellValue(i, prefix+"rsn_skd_voy_no"		,rtnDatas[18]	,0);		// rsn_skd_voy_no
						sheetObj.SetCellValue(i, prefix+"rsn_skd_dir_cd"		,rtnDatas[19]	,0);		// rsn_skd_dir_cd
						sheetObj.SetCellValue(i, prefix+"rsn_clpt_ind_seq"		,rtnDatas[20]	,0);		// rsn_clpt_ind_seq
					}
					idx++;
				}
			} //end for
			skipCallControl(sheetObj);
		}
	}
	/**
	 * after [Vessle Slide] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnSlideHelp(rtnObjs){
		var sheetObj = sheetObjects[0];
		var prefix = sheetObj.id + "_";
		var curRow=sheetObj.GetSelectRow();
		
		var skpCallFlg			= sheetObj.GetCellValue(curRow, prefix+"skp_call_flg");
		var addCallFlg			= sheetObj.GetCellValue(curRow, prefix+"add_call_flg");

		if(rtnObjs.skd_cng_sts_cd == ""){ //Slide Cancel
			if(skpCallFlg == "Y"){
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","S",0);
			}else if(addCallFlg == "Y"){
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd","A",0);
			}else{
				sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd",          rtnObjs.skd_cng_sts_cd, 0);	
			}
		}else{
			sheetObj.SetCellValue(curRow, prefix+"skd_cng_sts_cd",          rtnObjs.skd_cng_sts_cd, 0);
		}
	
		sheetObj.SetCellValue(curRow, prefix+"vsld_wks",        rtnObjs.vsld_wks, 0);
		
		setRowControlBtnSts(sheetObj, curRow);
	}
	
	/**
	 * after [Add Call] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnAddCallHelp(sheetObj, rtnObj){
		if(rtnObj){
			addCallControl(sheetObj, rtnObj);
		}
	}
	/**
	 * after [Phase Out Call] Button Click, calling from Pop-up
	 * @param rtnObj
	 * @return
	 */
	function returnPhaseOutHelp(sheetObj, Row, rtnObj){
		var formObj=document.form;
		var prefix=sheetObj.id + "_";
		if(rtnObj){
			sheetObj.SetCellValue(Row, prefix+"phs_io_rsn_cd",rtnObj.phs_io_rsn_cd,0);
			sheetObj.SetCellValue(Row, prefix+"phs_io_rmk",rtnObj.phs_io_rmk,0);
//			if(glbSheetFlg == "sheet1"){
//				sheetObj = sheetObjects[0];
//			}else{
//				sheetObj = sheetObjects[1];
//			}
			phaseOutControl(sheetObj);
		}
	}
    /**
     * [New] Button Event : Initializing Screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	if(glbSheetFlg == "sheet1"){
			glbSheet1FormData=new Usr_Coni_FormData();
			glbSheet1FormData.setAllFormData();
			getComboObject("remark").RemoveAll();
		} else {
    		glbSheet2FormData=new Usr_Coni_FormData();
    		glbSheet2FormData.setAllFormData();
		}
    	sheetObj.RemoveAll();
    	showFieldControl(sheetObj, formObj, false);
    	initButton(sheetObj);
    	formObj.vsl_cd.focus();
    }
	/**
	 * After [Loadable Weight] Button Click, Calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnLoadableHelp(rtnObjs){
		// do not
	}
    /**
     * [Reverse Call] Button Disabled Control...
     * @param sheetObj
     * @return
     */
    function btnReverseCallControl(sheetObj){

		var strSelRow	= sheetObj.GetSelectionRows("|");
		var btnName		= "";
		var btnChgName	= "";
		if(sheetObj.id == "sheet1"){
			btnName="btn_reverse_call_1";
// 			btnChgName = "btn_reverse_call_cancel_1";
    	}else{
			btnName="btn_reverse_call_2";
// 			btnChgName = "btn_reverse_call_cancel_2";s
    	}
		
		if(strSelRow != null && strSelRow != undefined && strSelRow != ""){
			var selRows=strSelRow.split("|");
			
			if(selRows.length == 2){
				var formObj	= document.form;
				var prefix	= sheetObj.id + "_";
				
				//alert(sheetObj.GetCellValue(selRows[0], prefix+"vvd"));
				// if port_skd_sts_cd in A, B, D, then cannot Reverse
				
				if(isReverseBtnSts(sheetObj, selRows[0]) && isReverseBtnSts(sheetObj, selRows[1])){
					var vvd1=sheetObj.GetCellValue(selRows[0], prefix+"vvd");
					var vvd2=sheetObj.GetCellValue(selRows[1], prefix+"vvd");
					
					// if vvds are different, cannot Reverse
					if(vvd1 == vvd2){
						ComBtnEnable(btnName);
//						var cellVal1 = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
//						var cellVal2 = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");
//						
//						if(cellVal1 != "R" && cellVal2 != "R"){
//							ComBtnEnable(btnName);
//						}else if(cellVal1 == "R" && cellVal2 == "R"){
//							ComBtnDisable(btnName);
//							ComBtnEnable(btnChgName);
//						}else{
//							ComBtnDisable(btnName);
//							ComBtnDisable(btnChgName);
//						}
					}else{
						ComBtnDisable(btnName);
// 						ComBtnDisable(btnChgName);
					}
				}else{
					ComBtnDisable(btnName);
// 					ComBtnDisable(btnChgName);
				}
			}else{
				ComBtnDisable(btnName);
// 				ComBtnDisable(btnChgName);
			}
		}else{
			ComBtnDisable(btnName);
// 			ComBtnDisable(btnChgName);
		}
    }
	/*
	 * =====================================================================
	 * Data Control
	 * =====================================================================
	 */
    /**
	 * Setting Direction Code of Turnning Port
	 * @param sheetObj
	 * @return
	 */
    function initLoadDirection(){
    	var sheetCnt=sheetObjects.length;
    	if(sheetCnt > 0){
    		for(var i=0; i<sheetCnt; i++){
    			var sheetObj=sheetObjects[i];
		    	var prefix=sheetObj.id + "_";
		    	var sXml=doActionIBSheet(sheetObj, document.form, SEARCH07);
		    	var sDirCds=ComGetEtcData(sXml, "direction_cd");
		    	sheetObj.SetColProperty(prefix+"turn_skd_dir_cd", {ComboText:sDirCds, ComboCode:sDirCds} );
    		}
    	}
    }
    /**
     * Hadnling initial Data
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    //no support[check again]CLT 	var rows=sheetObj.Rows;
    	var headCnt=sheetObj.HeaderRows();
    	for(var i=headCnt; i<sheetObj.RowCount(); i++){
    		if(glbSheetFlg == "sheet1"){
    			glbSkdPortFlgs[i-headCnt]="N";
    		}else{
    			glbPlanPortFlgs[i-headCnt]="N";
    		}
    	}
    }
    
    function isReverseBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port Add Call
    	
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		//alert('isSkipBtnSts >> portSts ['+portSts+']');
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		// Blocking Virtual Add Call
		if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg")	== "Y"){
			return false;
		}
		
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking Skip Port
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		if(skdCngStsCd == "S"  || skdCngStsCd == "I" || skdCngStsCd == "O"){
			return false;
		}
		return true;
    }
    
    /**
     * Judging PRIVATE CALL BUTTON
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPrivateCallBtnEnableSts(sheetObj, Row){
    	
    	var prefix			= sheetObj.id + "_";
    	
    	var turnPortSts		= sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
    	var portSts			= sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
    	var privCallFlg		= sheetObj.GetCellValue(Row, prefix+"priv_call_flg");
    	
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return -1;
		}else if(portSts == "A" || portSts == "B" || portSts == "D"){
			return -1;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return -1;
		}else if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return -1;
		}else if(privCallFlg == "Y"){
			return false;
		}

		return true;
    }
    
    /**
     * Judging SKIP CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipBtnSts(sheetObj, Row){
    	
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port Add Call
    	
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		//alert('isSkipBtnSts >> portSts ['+portSts+']');
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		/** ::2015-06-09:Adding Validation not to be access button 'Skip Call' in case of add calling:: **/
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		//alert('isSkipBtnSts >> skdCngStsCd ['+skdCngStsCd+']');
		if(skdCngStsCd == "A"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking Skip Port
		if(skdCngStsCd == "S"  || skdCngStsCd == "R" || skdCngStsCd == "L" || skdCngStsCd == "I" || skdCngStsCd == "O"){
			return false;
		}
		return true;
    }
    /**
     * Judging SKIP CALL CANCEL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipCancelBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port Add Call
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking Skip Port
		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
			return true;
		}
		return false;
    }
    /**
     * Judging Vessle Rename input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isVslRenameBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
		
    	var turnPortSts	= sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}

		if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg")	== "Y"){
			return false;
		}
    	
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		if(	skdCngStsCd == "O" || skdCngStsCd == "I" || skdCngStsCd == "L") {
			return false;
		}
		return true;
    }    
    /**
     * Judging Vessle Slide input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isVslSlideBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";

    	var turnPortSts	= sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}

		if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg")	== "Y"){
			return false;
		}
    	
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		if(	skdCngStsCd == "O" || skdCngStsCd == "I" || skdCngStsCd == "R") {
			return false;
		}
		return true;
    }        
    /**
     * Judging ADD CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddBtnSts(sheetObj, Row){
    	
		var prefix	= sheetObj.id + "_";
		
		// Blocking Virtual Port Add Call.
		var turnPortSts	= sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			if(Row != sheetObj.LastRow()){
				return false;
			}
		}
		
		var portSts		= sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		var actInpFlg	= sheetObj.GetCellValue(Row, prefix+"act_inp_flg");
		
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}else if(portSts == "A" || portSts == "B" || portSts == "D" || actInpFlg == "Y"){
			var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				return false;
			}
		}
		
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		//:2016-03-14://if(skdCngStsCd == "R" || skdCngStsCd == "L" || skdCngStsCd == "I" || skdCngStsCd == "O"){
		if(skdCngStsCd == "R" || skdCngStsCd == "L"){
			return false;
		}
		
		
		//alert('last row ['+sheetObj.GetCellValue(Row+1, prefix+"turn_port_ind_cd")+']');
		
		/** Exchanging button label both normal add call and virtual add call ::2015-07-11 by TOP **/
		//::2015-08-31:by TOP:://if(Row == sheetObj.LastRow() || sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg") == "Y"){
		if(		sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg") 	== "Y"
			||	sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd")	== "D"
			||	sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd")	== "V"
			||	sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd")	== "F"	){
				
			$("#btn_add_call_1").text("Virtual Add Call");
			$("#btn_add_call_cancel_1").text("Virtual Add Call Cancel");
			gVtAddCallTargetFlg	= "Y";
			
		}else{
			$("#btn_add_call_1").text("Add Call");
			$("#btn_add_call_cancel_1").text("Add Call Cancel");
			gVtAddCallTargetFlg	= "N";
		}
		//var preTurnPortIndCd	= sheetObj.GetCellValue(Row-1, prefix+"turn_port_ind_cd");
		/*******************************************************************************************/
		
		return true;
		
    }
    /**
     * Judging ADD CALL CANCEL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddCancelBtnSts(sheetObj, Row){
		var prefix=sheetObj.id + "_";
		// Blocking Virtual Port
		var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			if(Row != sheetObj.LastRow()){
				return false;
			}
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "A"){
			return true;
		}
		return false;
    }
    
    /**
     * Judging PhaseIn CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseInBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
    	if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg") == "Y"){
    		return false;
    	}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		if(skdCngStsCd == "I" || skdCngStsCd == "O" || skdCngStsCd == "R" || skdCngStsCd == "L" || skdCngStsCd == "S"){
			return false;
		}
		//Blocking Phase Out Last Row
//		if(sheetObj.LastRow == Row){
//			return false;
//		}
		return true;
    }
    
    /**
     * Judging PhaseOut CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseOutBtnSts(sheetObj, Row){
    	
    	var prefix	= sheetObj.id + "_";
    	// Blocking Virtual Port
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
    	if(sheetObj.GetCellValue(Row, prefix+"vt_add_call_flg") == "Y"){
    		return false;
    	}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking PhaseOut Port
		var skdCngStsCd	= sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
		if(skdCngStsCd == "O" || skdCngStsCd == "I" || skdCngStsCd == "R" || skdCngStsCd == "L"){
			return false;
		}
		//Blocking Phase Out Last Row
//		if(sheetObj.LastRow == Row){
//			return false;
//		}
		return true;
    }
    /**
     * Judging PhaseIn Cancel CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseInCancelBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking PhaseOut Port
		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "I"){
			return true;
		}
		return false;
    }    
    /**
     * Judging PhaseOut Cancel CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isPhaseOutCancelBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	// Blocking Virtual Port
    	var turnPortSts=sheetObj.GetCellValue(Row, prefix+"turn_port_ind_cd");
		if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
			return false;
		}
		//Blocking Actual Port
		var portSts=sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}else if(sheetObj.GetCellValue(Row, prefix+"act_inp_flg") == "Y"){
			return false;
		}
		//Blocking before Actual Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking PhaseOut Port
		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "O"){
			return true;
		}
		return false;
    }
    /**
     * position(befor or after) flag Setting when Add Call
     * @param sheetObj
     * @return
     */
    function isAddPositionFlag(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var curRow=sheetObj.GetSelectRow();
    	if(sheetObj.LastRow()== curRow){
    		//Blocking Virtual Port Add Call
    		var turnPortSts=sheetObj.GetCellValue(curRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts=sheetObj.GetCellValue(curRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
			}
    	}else{
    		//Blocking Virtual Port Add Call
    		var turnPortSts=sheetObj.GetCellValue(curRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts=sheetObj.GetCellValue(curRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
				var afTurnPortSts=sheetObj.GetCellValue(curRow+1, prefix+"turn_port_ind_cd");
				if(afTurnPortSts == "F" || afTurnPortSts == "V" || afTurnPortSts == "D"){
					return "A";
				}
			}
    	}
		//Blocking Actual Port
    	var portSts=sheetObj.GetCellValue(curRow, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return "B";
		}else if(sheetObj.GetCellValue(curRow, prefix+"act_inp_flg") == "Y"){
			return false;
		}
//		// Blocking before Actual Port
//		if(sheetObj.CellValue(curRow, prefix+"bfr_act_flg") == "X"){
//			return "B";
//		}
		return "";
    }
    
    
    
    /**
     * Retrieving basic data for creating skd
     * @param sheetObj
     * @param preRow
     * @param nxtRow
     * @return
     */
    function doUnitCallBaseInfo(sheetObj, preRow, nxtRow){
    	
    	var formObj		= document.form;
    	var prefix		= sheetObj.id + "_";
    	var headCnt		= sheetObj.HeaderRows();
    	var totCnt		= getTotalRowCnt(sheetObj);
    	var sXml		= null;
    	
		//Dist Retrieve
		var portCd		= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		
		/** Setting Distance+Speed+Sea Time on between previous and current port **/
		formObj.fm_loc_cd.value	= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		formObj.to_loc_cd.value	= sheetObj.GetCellValue(nxtRow, prefix+"vps_port_cd");
		
		formObj.loc_cd.value	= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd");
		formObj.yd_cd.value		= sheetObj.GetCellValue(preRow, prefix+"vps_port_cd") + sheetObj.GetCellValue(preRow, prefix+"tml_cd");
		
		sXml			= doActionIBSheet(sheetObj, formObj, SEARCH06);
					
		return sXml;

    }    
    
    
    /**
     * Retrieving basic data for creating skd
     * @param sheetObj
     * @param sRow
     * @param evtFlg
     * @param eRow
     * @return
     */
    function doCallBaseInfo(sheetObj, sRow, evtFlg, eRow){
    	
    	var formObj		= document.form;
    	var prefix		= sheetObj.id + "_";
    	var headCnt		= sheetObj.HeaderRows();
    	var totCnt		= getTotalRowCnt(sheetObj);
    	var sXml		= null;
    	
    	if(evtFlg == "SKIP"){
    		
    		if(sRow > headCnt){
    			var startRow	= getNotSkipRow(sheetObj, sRow, "P");
    			var endRow		= getNotSkipRow(sheetObj, sRow, "N");
    			if(startRow > 0 && endRow > 0){
    				formObj.yd_cd.value			= sheetObj.GetCellValue(sRow, 		prefix+"vps_port_cd") + sheetObj.GetCellValue(sRow, prefix+"tml_cd");
    				formObj.vps_eta_dt.value	= sheetObj.GetCellValue(sRow, 		prefix+"vps_eta_dt");
    				formObj.fm_loc_cd.value		= sheetObj.GetCellValue(startRow, 	prefix+"vps_port_cd");
    				formObj.to_loc_cd.value		= sheetObj.GetCellValue(endRow, 	prefix+"vps_port_cd");
    				sXml	= doActionIBSheet	(sheetObj, formObj, SEARCH11);
    			}
    		}
    		
    	}else if(evtFlg == "SKIP_CANCEL"){
    		
    		if(sRow > headCnt){
    			var startRow=getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
    				formObj.fm_loc_cd.value=sheetObj.GetCellValue(startRow, prefix+"vps_port_cd");
    				formObj.to_loc_cd.value=sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
        			sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
    			}
    		}
    		
    	}else if(evtFlg == "ADD"){
    		
    		//Dist Retrieve
    		var portCd	= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
    		
    		//alert('add calling portCd ['+portCd+']   sRow ['+sRow+']   head count ['+headCnt+'] tot count  ['+totCnt+']');
    		
    		if(portCd != null && portCd != undefined && portCd != ""){
				if(sRow > headCnt && sRow < totCnt-1){
					var startRow	= getNotSkipRow(sheetObj, sRow, "P");	//Previous Port Not Skip?//
					var endRow		= getNotSkipRow(sheetObj, sRow, "N");	//Next     Port Not Skip?//
					
					//alert('add calling startRow ['+startRow+'] endRow ['+endRow+']');
					
	    			if(startRow > 0 && endRow > 0){
	    				
	    				/** Setting Distance+Speed+Sea Time on between previous and current port **/
						formObj.fm_loc_cd.value	= sheetObj.GetCellValue(startRow, prefix+"vps_port_cd");
						formObj.to_loc_cd.value	= sheetObj.GetCellValue(sRow	, prefix+"vps_port_cd");
						
						formObj.loc_cd.value	= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
						formObj.yd_cd.value		= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd") + sheetObj.GetCellValue(sRow, prefix+"tml_cd");
						
						//alert('fm loc ['+formObj.fm_loc_cd.value+']');
						//alert('to loc ['+formObj.to_loc_cd.value+']');
						//alert('loc ['+formObj.loc_cd.value+']');
						//alert('yd ['+formObj.yd_cd.value+']');
						
						//alert('vsl ['+formObj.vsl_cd.value+']');
						
						sXml		= doActionIBSheet(sheetObj, formObj, SEARCH06);
						
						//alert('sXml ['+sXml+']');
						
						
	    			}
	    			
				} else if(sRow < totCnt-1) {
					
					formObj.fm_loc_cd.value		= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
					formObj.to_loc_cd.value		= sheetObj.GetCellValue(sRow+1, prefix+"vps_port_cd");
					formObj.loc_cd.value		= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
					formObj.yd_cd.value			= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd") + sheetObj.GetCellValue(sRow, prefix+"tml_cd");
					
					sXml	= doActionIBSheet(sheetObj, formObj, SEARCH06);
					
				} else {
					
					formObj.fm_loc_cd.value		= sheetObj.GetCellValue(sRow-1, prefix+"vps_port_cd");
					formObj.to_loc_cd.value		= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
					formObj.loc_cd.value		= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
					formObj.yd_cd.value			= sheetObj.GetCellValue(sRow, prefix+"vps_port_cd") + sheetObj.GetCellValue(sRow, prefix+"tml_cd");
					
					sXml	= doActionIBSheet(sheetObj, formObj, SEARCH06);
					
				}
    		}
    		
    	}else if(evtFlg == "ADD_CANCEL"){
    		
    		if(sRow > headCnt){
    			var startRow=getNotSkipRow(sheetObj, sRow, "P");
    			var endRow=getNotSkipRow(sheetObj, sRow, "N");
    			
    			if(startRow > 0 && endRow > 0){
    				formObj.fm_loc_cd.value=sheetObj.GetCellValue(startRow, prefix+"vps_port_cd");
    				formObj.to_loc_cd.value=sheetObj.GetCellValue(endRow, prefix+"vps_port_cd");
    				sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
    			}
    		}
    		
    	}else if(evtFlg == "REVERSE"){
    		
    		var portCd=sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
    		if(portCd != null && portCd != undefined && portCd != ""){
				if(sRow > headCnt && eRow < totCnt){
					var sStartRow=getNotSkipRow(sheetObj, sRow, "P");
					var sEndRow=getNotSkipRow(sheetObj, sRow, "N");
					var eStartRow=getNotSkipRow(sheetObj, eRow, "P");
					var eEndRow=getNotSkipRow(sheetObj, eRow, "N");
	    			if(sStartRow > 0 && eEndRow > 0){
	    				var fmLocCd=sheetObj.GetCellValue(sStartRow, prefix+"vps_port_cd");
	    				fmLocCd=fmLocCd + "|" + sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
	    				fmLocCd=fmLocCd + "|" + sheetObj.GetCellValue(eStartRow, prefix+"vps_port_cd");
	    				fmLocCd=fmLocCd + "|" + sheetObj.GetCellValue(eRow, prefix+"vps_port_cd");
	    				var toLocCd=sheetObj.GetCellValue(sRow, prefix+"vps_port_cd");
	    				toLocCd=toLocCd + "|" + sheetObj.GetCellValue(sEndRow, prefix+"vps_port_cd");
	    				toLocCd=toLocCd + "|" + sheetObj.GetCellValue(eRow, prefix+"vps_port_cd");
	    				toLocCd=toLocCd + "|" + sheetObj.GetCellValue(eEndRow, prefix+"vps_port_cd");
						formObj.fm_loc_cd.value=fmLocCd;
						formObj.to_loc_cd.value=toLocCd;
						sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
	    			}
				}
    		}
    	}
    	
		return sXml;
    }
    /**
     * Finding no skip port with flag, and Returning
     * 
     * @param sheetObj
     * @param sRow
     * @param flag P:pre port, N:next port
     * @param rowHide
     * @return
     */
    function getNotSkipRow(sheetObj, sRow, flag, rowHide){
    	var prefix	= sheetObj.id + "_";
    	var headCnt	= sheetObj.HeaderRows();
    	var totCnt	= getTotalRowCnt(sheetObj);
    	
    	if(flag == "P"){
    		if(sRow > headCnt){
	    		for(var i=Number(sRow)-1; i>=headCnt; i--){
	    			if(rowHide){
	    				if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
	    			}else{
	    				if(!sheetObj.GetRowHidden(i) && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
	    			}
	    		}
    		}
    		
    	//getNotSkipRow(sheetObj, i, "N", true);
    	}else if(flag == "N"){
    		if(sRow < totCnt){
    			for(var i=Number(sRow)+1; i<=totCnt; i++){
    				if(rowHide){
    					if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
		    				return i;
		    			}
    				}else{
    					if(!sheetObj.GetRowHidden(i) && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    	    				return i;
    	    			}
    				}
    			}
    		}
    	}
    	return -1;
    }
    /**
     * Setting changed Remark
     * @param sheetObj
     * @param rmkVal
     * @return
     */
    function setRemarkDataByVvd(sheetObj, rmkVal){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var sRow=sheetObj.GetSelectRow();
    	var selectVvd=sheetObj.GetCellValue(sRow, prefix+"vvd");
    	for(var i=headCnt; i<=totCnt; i++){
    		if(sheetObj.GetCellValue(i, prefix+"vvd") == selectVvd){
				sheetObj.SetCellValue(i, prefix+"skd_rmk",rmkVal);
			}
		}
    }
    /**
     * Handling Screen as Port Code
     * 
     * @param sheetObj
     * @param sRow
     * @param sXml
     * @return
     */
    function isCheckPort(sheetObj, sRow, sXml){
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", sheetObj.GetCellValue(sRow, prefix+"vps_port_cd"));
			sheetObj.SetCellValue(sRow, prefix+"vps_port_cd","",0);
			sheetObj.SelectCell(sRow, prefix+"vps_port_cd");
		}
		return false;
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
    	var totCnt=getTotalRowCnt(sheetObj);
    	var idx=0;
    	var vIbFlag="";
    	var preVvd="";
    	var curVvd="";
    	for(var i=headCnt; i<=totCnt; i++){
    		curVvd=sheetObj.GetCellValue(i, prefix+"vvd");
    		if(preVvd != curVvd){
    			idx=0;
    			preVvd=curVvd;
    		}
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			idx++;
//    			if(sheetObj.id == "sheet2" && i == sheetObj.LastRow){
////    				sheetObj.CellValue2(i, prefix+"clpt_seq") = " ";
//    				sheetObj.SumText(0, prefix+"clpt_seq") = " ";
//    			}else{
//    				sheetObj.CellValue2(i, prefix+"clpt_seq") = idx;
//    			}
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
//    		}
    		if(sheetObj.GetRowStatus(i) != "D"){
    			vIbFlag=sheetObj.GetRowStatus(i);
    			idx++;
    			if(sheetObj.id == "sheet2" && i == sheetObj.LastRow()+1){
//    				sheetObj.CellValue2(i, prefix+"clpt_seq") = " ";
     				sheetObj.SetSumText(0, prefix+"clpt_seq"," ");
    			}else{
    				sheetObj.SetCellValue(i, prefix+"clpt_seq",idx,0);
    			}
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
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var idx=0;
    	var vIbFlag="";
    	var preVvd="";
    	var curVvd="";
    	for(var i=headCnt; i<=totCnt; i++){
    		idx=0;
//    		if(sheetObj.CellValue(i, prefix+"ibflag") != "D"){
    		if(sheetObj.GetRowStatus(i) != "D"){
	    		for(var j=headCnt; j<=i; j++){
//	    			if(sheetObj.CellValue(j, prefix+"ibflag") != "D"){
	    			if(sheetObj.GetRowStatus(j) != "D"){
	    				if(sheetObj.GetCellValue(i, prefix+"vvd") == sheetObj.GetCellValue(j, prefix+"vvd")){
	    					if(sheetObj.GetCellValue(i, prefix+"vps_port_cd") == sheetObj.GetCellValue(j, prefix+"vps_port_cd")){
	    						idx++;
	    					}
	    				}
	    			}
	    		}//end for
//	    		vIbFlag = sheetObj.CellValue(i, prefix+"ibflag");
//    			sheetObj.CellValue2(i, prefix+"new_clpt_ind_seq") = idx;
//    			sheetObj.CellValue2(i, prefix+"ibflag") = vIbFlag;
	    		vIbFlag=sheetObj.GetRowStatus(i);
    			sheetObj.SetCellValue(i, prefix+"new_clpt_ind_seq",idx,0);
    			sheetObj.SetRowStatus(i,vIbFlag);
    		}
    	}
    }
    /**
     * after Saving simulation, Showing simulation number
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function setDisplaySimNo(sheetObj, formObj, sXml){
    	/*if(sXml != null){
    		var rootNode=VskGetXmlRootNode(sXml);
			var dataNode=rootNode.selectSingleNode("//MESSAGE");
			if(dataNode){
				var msgValue=dataNode.text;
				var flgIdx=msgValue.indexOf(":");
				if(flgIdx > 0){
					var simDt=ComGetMaskedValue(msgValue.substring(flgIdx-8, flgIdx), "ymd");
					var simNo=msgValue.substring(flgIdx+1);
					formObj.sim_dt.value=simDt;
			    	formObj.sim_no.value=ComLpad(simNo,   3, "0");
			    	glbSheet2FormData.setSimDt(formObj.sim_dt.value);
			    	glbSheet2FormData.setSimNo(formObj.sim_no.value);
				}
			}
    	}*/
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
     * Returning count of VVD
     * 
     * @param sheetObj
     * @return
     */
    function getVvdCnt(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		var sVvd="";
		var vvdCnt=0;
    	for(var i=headCnt; i<=totCnt; i++){
    		if(sheetObj.GetCellValue(i, prefix+"clpt_seq") != "TOTAL"){
    			if(sVvd != sheetObj.GetCellValue(i, prefix+"vvd")){
	    			vvdCnt++;
	    			sVvd=sheetObj.GetCellValue(i, prefix+"vvd");
	        	}
    		}
    	}
    	return vvdCnt;
	}
    /**
	 * Calculating Delay Time
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setDelayTime(sheetObj, Row, Col, pfCol){
    	
    	var prefix		= sheetObj.id + "_";
    	var vpsDt		= sheetObj.GetCellValue(Row, Col);
    	var pfDt		= sheetObj.GetCellValue(Row, pfCol);
    	var depTimeDiff	= "";
    	
    	if(vpsDt != null && vpsDt != ""){
    		if(pfDt != null && pfDt != ""){
    			depTimeDiff	= setParsingDelayTime(pfDt, vpsDt);	// Delay Date=vpsEtdDt - pfEtdDt
    		}
    	}
    	
    	//alert('setDelayTime    depTimeDiff ['+depTimeDiff+']   pfDt <'+pfDt+'>   vpsDt <'+vpsDt+'>');
    	
    	sheetObj.SetCellValue(Row, prefix+"dlay_date_text", depTimeDiff, 0);
// 		formObj.dlay_dep_tm.value = depTimeDiff;
    }
    
    /**
     * Converting Delay Time as Format
     * 
     * @param fmDate
     * @param toDate
     * @return
     */
    function setParsingDelayTime(fmDate, toDate){
    	
    	/** Correcting return value in cases "XXX" and empty value
    	 * 	by TOP:2015-05-12
    	 */
    	if(fmDate == "XXX" || fmDate == null || fmDate == "" || fmDate == undefined)	return	"";
    	
    	var timeDiff	= "";
    	var sign		= "";
    	var day			= ComGetDaysBetween(ComGetMaskedValue(fmDate.substring(0,8), "ymd"), ComGetMaskedValue(toDate.substring(0,8), "ymd"));
		var time		= getTimeDiff(fmDate.substring(8), toDate.substring(8));
		
		if(day >= 0){
			if(time >= 0){
				if(day == 0 && time == 0){
					return "";
				}
			}else{
				if(day > 0){
					day=Number(day) - 1;
					time=24 + Number(time);
				}
				else{
//					time = time * (-1);
// 					sign = "-";
					return "";
				}
			}
		}
		else{
//			if(time >= 0){
//				if(time > 0){
//					day = Number(day) + 1;
//					time = 24 - Number(time);
//					sign = "-";
//				}else{
//					sign = "";
//				}
//			}else{
//				day = day * (-1);
//				time = time * (-1);
//				sign = "-";
//			}
			return "";
		}
		
		timeDiff	= sign + ComLpad(day, 2, "0") + "D-" + ComLpad(time, 2, "0") + "H";
		return timeDiff;
    }
    /**
     * Calculating Total Delay Text per hours
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function getTotalDelayHour(sheetObj, Row){
    	if(sheetObj.LastRow()<Row){
    		return false;
    	}
    	var days=0;
    	var hours=0;
    	var prefix=sheetObj.id + "_";
    	var dlayDateText=sheetObj.GetCellValue(Row, prefix + "dlay_date_text");
    	var dlayDateHours=0;
    	if(ComTrim(dlayDateText).length>0){
    		days=Number(dlayDateText.substring(0, dlayDateText.indexOf("D")));
			hours=Number(dlayDateText.substring(dlayDateText.indexOf("-")+1, delayHours.indexOf("H")));
			dlayDateHours=days * 24 + hours;
    	}
    	return dlayDateHours;
    }
    /**
     * Calculating Time Difference
     * @param fmTime
     * @param toTime
     * @return
     */
    function getTimeDiff(fmTime, toTime){
		var rtnTime="";
// 		var convertTime = 10 * 24;
    	var convertTime=10 * 10;
    	rtnTime=Math.round((toTime - fmTime) / convertTime);
    	return rtnTime;
	}
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
    /**
	 * Handling form Data
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
    function setFormData(sheetObj, Row, Col){
    	var formObj=document.form;
    	var prefix=sheetObj.id + "_";
    	formObj.cre_dt.value       = VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"cre_dt"));
    	formObj.cre_usr_id.value   = sheetObj.GetCellValue(Row, prefix+"cre_usr_id");
    	formObj.upd_dt.value       = VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"upd_dt"));
    	formObj.upd_usr_id.value   = sheetObj.GetCellValue(Row, prefix+"upd_usr_id");
    	formObj.vsl_slan_cd.value  = sheetObj.GetCellValue(Row, prefix+"vsl_slan_cd");
    	
 		formObj.pf_svc_tp_cd.value = sheetObj.GetCellValue(Row, prefix+"pf_svc_tp_cd");

 		Usr_setCreDt(formObj.cre_dt.value);
    	Usr_setCreUsrId(formObj.cre_usr_id.value);
    	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
    	Usr_setUpdDt(formObj.upd_dt.value);
    	Usr_setUpdUsrId(formObj.upd_usr_id.value);
    	
    	if(sheetObj.id == "sheet1"){
    		getComboObject("remark").SetSelectCode(sheetObj.GetCellValue(Row, prefix+"vvd"),false);
// 			ComEnableObject(formObj.skd_rmk, sheetObj.RowEditable(Row));
    		formObj.skd_rmk.value=sheetObj.GetCellValue(Row, prefix+"skd_rmk");
    	}else{
    		formObj.skd_rmk.value=sheetObj.GetCellValue(Row, prefix+"diff_rmk");
    	}
		Usr_setSkdRmk(formObj.skd_rmk.value);
    	// when SHEET click, Setting VVD Conditions with selected row
		formObj.vsl_cd.value=sheetObj.GetCellValue(Row, prefix+"vsl_cd");
		formObj.skd_voy_no.value=sheetObj.GetCellValue(Row, prefix+"skd_voy_no");
		formObj.skd_dir_cd.value=sheetObj.GetCellValue(Row, prefix+"skd_dir_cd");
    	Usr_setVslCd(formObj.vsl_cd.value);
    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
    }
	/**
	 * Handling button style and activated state and etc.
	 * @param eleName
	 * @param btnName
	 * @param btnDply
	 * @param btnClass
	 * @param btnSize
	 * @return
	 */
	function btn2ControlHtml(eleName, btnName, btnDply, btnClass, btnSize){
		if(btnClass == null || btnClass == undefined || btnClass == ""){
			btnClass="btn_normal";
		}
		if(btnSize == null || btnSize == undefined || btnSize == ""){
			btnSize="120";
		}
		var ctlr=document.getElementById(eleName);
//		var strHtml='<div width="'+btnSize+'" class="opus_design_btn">\n';
//		strHtml=strHtml + '<tr><td class="btn2_left"></td>\n';
		var strHtml='<button type ="button" class="'+btnClass+'" name="'+btnName+'" id="'+btnName+'">'+btnDply+'</button>\n';
//		strHtml=strHtml + '<td class="btn2_right"></td>\n';
//		strHtml=strHtml + '</tr>\n';
//		strHtml=strHtml + '</div>';
		ctlr.innerHTML=strHtml;
	}
	/**
	 * Calling Button with [Coastal SKD] / [Recovery Plan] state
	 * @param formObj
	 * @return
	 */
	function replaceButtonSet(formObj){
		if(formObj.rdo_tran[0].checked){
			document.getElementById("div_row_hide_1").style.display="block";
			document.getElementById("div_row_hide_cancel_1").style.display="block";
			document.getElementById("div_skip_call_1").style.display="block";
			document.getElementById("div_skip_call_cancel_1").style.display="block";
			document.getElementById("div_add_call_1").style.display="block";
			document.getElementById("div_add_call_cancel_1").style.display="block";
			document.getElementById("div_reverse_call_1").style.display="block";
// 			document.getElementById("div_reverse_call_cancel_1").style.display = "block";
 			document.getElementById("div_p_in_1").style.display = "block";
 			document.getElementById("div_p_in_cancel_1").style.display = "block";
			document.getElementById("div_p_out_1").style.display="block";
			document.getElementById("div_p_out_cancel_1").style.display="block";
			document.getElementById("div_row_hide_2").style.display="none";
			document.getElementById("div_row_hide_cancel_2").style.display="none";
			document.getElementById("div_skip_call_2").style.display="none";
			document.getElementById("div_skip_call_cancel_2").style.display="none";
			document.getElementById("div_add_call_2").style.display="none";
			document.getElementById("div_add_call_cancel_2").style.display="none";
			document.getElementById("div_reverse_call_2").style.display="none";
// 			document.getElementById("div_reverse_call_cancel_2").style.display = "none";
 			document.getElementById("div_p_in_2").style.display = "none";
 			document.getElementById("div_p_in_cancel_2").style.display = "none";
			document.getElementById("div_p_out_2").style.display="none";
			document.getElementById("div_p_out_cancel_2").style.display="none";
    	}else{
			document.getElementById("div_row_hide_1").style.display="none";
			document.getElementById("div_row_hide_cancel_1").style.display="none";
			document.getElementById("div_skip_call_1").style.display="none";
			document.getElementById("div_skip_call_cancel_1").style.display="none";
			document.getElementById("div_add_call_1").style.display="none";
			document.getElementById("div_add_call_cancel_1").style.display="none";
			document.getElementById("div_reverse_call_1").style.display="none";
// 			document.getElementById("div_reverse_call_cancel_1").style.display = "none";
 			document.getElementById("div_p_in_1").style.display = "none";
 			document.getElementById("div_p_in_cancel_1").style.display = "none";
			document.getElementById("div_p_out_1").style.display="none";
			document.getElementById("div_p_out_cancel_1").style.display="none";
			document.getElementById("div_row_hide_2").style.display="block";
			document.getElementById("div_row_hide_cancel_2").style.display="block";
			document.getElementById("div_skip_call_2").style.display="block";
			document.getElementById("div_skip_call_cancel_2").style.display="block";
			document.getElementById("div_add_call_2").style.display="block";
			document.getElementById("div_add_call_cancel_2").style.display="block";
			document.getElementById("div_reverse_call_2").style.display="block";
// 			document.getElementById("div_reverse_call_cancel_2").style.display = "block";
 			document.getElementById("div_p_in_2").style.display = "block";
 			document.getElementById("div_p_in_cancel_2").style.display = "block";
			document.getElementById("div_p_out_2").style.display="block";
			document.getElementById("div_p_out_cancel_2").style.display="block";
    	}
	}
	/**
	 * Initializing Buttons
	 * @return
	 */
    function initButton(sheetObj){
    	var formObj=document.form;
    	if(sheetObj.id == "sheet1"){
			ComSetDisplay("btn_row_hide_1", false);
			ComSetDisplay("btn_row_hide_cancel_1", false);
			
			ComSetDisplay("btn_p_in_1", false);
			ComSetDisplay("btn_p_in_cancel_1", false);
			
			ComSetDisplay("btn_p_out_1", false);
			ComSetDisplay("btn_p_out_cancel_1", false);
			
			ComSetDisplay("btn_skip_call_cancel_1", false);
			ComSetDisplay("btn_skip_call_1", false);
			
			ComBtnDisable("btn_vsl_rename_1");
			ComBtnDisable("btn_vsl_slide_1");
	    	ComBtnDisable("btn_row_hide_1");
	    	ComBtnDisable("btn_skip_call_1");
	    	ComBtnDisable("btn_add_call_1");
	    	ComBtnDisable("btn_reverse_call_1");
	    	ComBtnDisable("btn_p_in_1");
	    	ComBtnDisable("btn_p_out_1");
	    	ComBtnDisable("btn_row_hide_cancel_1");
	    	ComBtnDisable("btn_skip_call_cancel_1");
	    	ComBtnDisable("btn_add_call_cancel_1");
	    	ComBtnDisable("btn_p_in_cancel_1");
	    	ComBtnDisable("btn_p_out_cancel_1");
	    	ComBtnDisable("btn_settlement");
	    	ComBtnDisable("btn_loadableweight");
	    //	ComBtnDisable("btn_col_hide");
	    //	ComEnableObject(formObj.btn_sim_no, false);
    	}else{
	    	ComBtnDisable("btn_row_hide_2");
	    	ComBtnDisable("btn_skip_call_2");
	    	ComBtnDisable("btn_add_call_2");
	    	ComBtnDisable("btn_reverse_call_2");
	    	ComBtnDisable("btn_p_out_2");
	    	ComBtnDisable("btn_row_hide_cancel_2");
	    	ComBtnDisable("btn_skip_call_cancel_2");
	    	ComBtnDisable("btn_add_call_cancel_2");
 			ComBtnDisable("btn_p_out_cancel_2");
	    	ComBtnEnable("btn_settlement");
	    	ComBtnEnable("btn_loadableweight");
	    	ComBtnEnable("btn_col_hide");
	    //	ComEnableObject(formObj.btn_sim_no, true);
    	}
    }
    /**
     * Handling Button Activation
     * 
     * @param sheetObj
     * @return
     */
    function setRowControlBtnSts(sheetObj, Row){
    	
    	var prefix	= sheetObj.id + "_";
    	
    	if(sheetObj.id == "sheet1"){
    		
    		//alert(isPrivateCallBtnEnableSts(sheetObj, Row));
    		
			//Private Call Button
    		//:2016-03-14:TEMP://
//	    	if(isPrivateCallBtnEnableSts(sheetObj, Row) == true){
//	    		ComBtnEnable("div_priv_call_1");
//	    		
//				ComSetDisplay("div_priv_call_cancel_1"	, false);
//				ComSetDisplay("div_priv_call_1"			, true);
//				
//	    	}else if(isPrivateCallBtnEnableSts(sheetObj, Row) == false){
//	    		ComBtnDisable("div_priv_call_1");
//	    		
//				ComSetDisplay("div_priv_call_cancel_1"	, true);
//				ComSetDisplay("div_priv_call_1"			, false);
//	    	}else{
//	    		ComBtnDisable("div_priv_call_1");
//	    		ComBtnDisable("div_priv_call_cancel_1");
//	    		
//	    		ComSetDisplay("div_priv_call_1"			, false);
//				ComSetDisplay("div_priv_call_cancel_1"	, false);
//	    	}
    		
			//Skip Button
	    	if(isSkipBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_1");
	    		
				ComSetDisplay("btn_skip_call_cancel_1", false);
				ComSetDisplay("btn_skip_call_1", true);
				
	    	}else{
	    		ComBtnDisable("btn_skip_call_1");
	    		
				ComSetDisplay("btn_skip_call_cancel_1", true);
				ComSetDisplay("btn_skip_call_1", false);
	    	}
	    	
	    	//Skip Cancel Button
	    	if(isSkipCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_cancel_1");
	    		
				ComSetDisplay("btn_skip_call_cancel_1", true);
				ComSetDisplay("btn_skip_call_1", false);
				
	    	}else{
	    		ComBtnDisable("btn_skip_call_cancel_1");
	    		
				ComSetDisplay("btn_skip_call_cancel_1", false);
				ComSetDisplay("btn_skip_call_1", true);

	    	}

	    	//Add Button
	    	if(isAddBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_1");
	    	}else{
				ComBtnDisable("btn_add_call_1");
			}
	    	
	    	//Add Cancel Button
	    	if(isAddCancelBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_cancel_1");
	    	}else{
				ComBtnDisable("btn_add_call_cancel_1");
			}
	    	
			//Phase In Button
	    	if(isPhaseInBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_in_1");
	    		
				ComSetDisplay("btn_p_in_1", true);
				ComSetDisplay("btn_p_in_cancel_1", false);

	    	}else{
	    		ComBtnDisable("btn_p_in_1");
	    		
				ComSetDisplay("btn_p_in_1", false);
				ComSetDisplay("btn_p_in_cancel_1", true);
	    	}	   
	
			//Phase Out Button
	    	if(isPhaseOutBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_1");
	    		
				ComSetDisplay("btn_p_out_1", true);
				ComSetDisplay("btn_p_out_cancel_1", false);

	    	}else{
	    		ComBtnDisable("btn_p_out_1");
	    		
				ComSetDisplay("btn_p_out_1", false);
				ComSetDisplay("btn_p_out_cancel_1", true);

	    	}
	    	
	    	//Phase In Cancel Button
	    	if(isPhaseInCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_in_cancel_1");
	    		
				ComSetDisplay("btn_p_in_1", false);
				ComSetDisplay("btn_p_in_cancel_1", true);
				
	    	}else{
	    		ComBtnDisable("btn_p_in_cancel_1");
	    		
				ComSetDisplay("btn_p_in_1", true);
				ComSetDisplay("btn_p_in_cancel_1", false);

	    	}	   
	    	
	    	//Phase Out Cancel Button
	    	if(isPhaseOutCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_cancel_1");
	    		
				ComSetDisplay("btn_p_out_1", false);
				ComSetDisplay("btn_p_out_cancel_1", true);
				
	    	}else{
	    		ComBtnDisable("btn_p_out_cancel_1");
	    		
				ComSetDisplay("btn_p_out_1", true);
				ComSetDisplay("btn_p_out_cancel_1", false);
	    	}
	    	
			//Vessel Rename
	    	if(isVslRenameBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_vsl_rename_1");
	    	}else{
	    		ComBtnDisable("btn_vsl_rename_1");
	    	}
	    	
	    	//Slide Button
	    	if(isVslSlideBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_vsl_slide_1");
	    	}else{
	    		ComBtnDisable("btn_vsl_slide_1");
	    	}
	    	
    	}else{
    		
    		//Skip Button
	    	if(isSkipBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_2");
	    	}else{
	    		ComBtnDisable("btn_skip_call_2");
	    	}
	    	
	    	//Skip Cancel Button
	    	if(isSkipCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_skip_call_cancel_2");
	    	}else{
	    		ComBtnDisable("btn_skip_call_cancel_2");
	    	}
	    	
	    	//Add Button
	    	if(isAddBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_2");
	    	}else{
				ComBtnDisable("btn_add_call_2");
			}
	    	
	    	//Add Cancel Button
	    	if(isAddCancelBtnSts(sheetObj, Row)){
		    	ComBtnEnable("btn_add_call_cancel_2");
	    	}else{
				ComBtnDisable("btn_add_call_cancel_2");
			}
	    	
			//Phase Out Button
	    	if(isPhaseOutBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_2");
	    	}else{
	    		ComBtnDisable("btn_p_out_2");
	    	}
	    	
	    	//Phase Out Cancel Button
	    	if(isPhaseOutCancelBtnSts(sheetObj, Row)){
	    		ComBtnEnable("btn_p_out_cancel_2");
	    	}else{
	    		ComBtnDisable("btn_p_out_cancel_2");
	    	}
    	}
    }
    /**
     * Loadable Weight Button Activation Control.
     *  
     * @param sheetObj
     * @param Row
     * @return
     */
    function btnControlByLoadableWeight(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	if(sheetObj.GetCellValue(Row, prefix+"vps_port_cd") == "CNSHA"){
    		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") != "S"){
				ComBtnEnable("btn_loadableweight");
			}else{
				ComBtnDisable("btn_loadableweight");
			}
		}else{
			ComBtnDisable("btn_loadableweight");
		}
    }
    /**
     * Finding data which turn_port_flg is 'Y' and turn_skd_voy_no, turn_skd_dir_cd is Null , and Changing that editable
     * 
     * @param sheetObj
     * @return
     */
    function turnEditChange(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
		var totCnt=getTotalRowCnt(sheetObj);
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
//				if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
					sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",1);
					sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",1);
// 				}
			}
		}
    }
    /**
     * in case conditions change, Sheet Initializing.
     * @param sheetObj
     * @param formObj
     * @return
     */
    function resetAllData(sheetObj, formObj){
    	formObj.cre_dt.value="";
    	formObj.cre_usr_id.value="";
    	formObj.vsl_slan_cd.value="";
    	formObj.upd_dt.value="";
    	formObj.upd_usr_id.value="";
    	formObj.skd_rmk.value="";
    	Usr_setCreDt(formObj.cre_dt.value);
    	Usr_setCreUsrId(formObj.cre_usr_id.value);
    	Usr_setVslSlanCd(formObj.vsl_slan_cd.value);
    	Usr_setUpdDt(formObj.upd_dt.value);
    	Usr_setUpdUsrId(formObj.upd_usr_id.value);
    	Usr_setSkdRmk(formObj.skd_rmk.value);
    	if(glbSheetFlg == "sheet1"){
    		getComboObject("remark").RemoveAll();
    	}
    	sheetObj.RemoveAll();
    	showFieldControl(sheetObj, formObj, false);
    	initButton(sheetObj);
    }
    /**
     * Returning combo object with combo id
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
	 * Setting Remark Combo
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function setRemarkCombo(sheetObj, formObj){
		var stndVvd=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		var vvdArr=new Array();
		var vvdIdx=0;
		var currVvd=sheetObj.GetCellValue(headCnt, prefix+"vvd");
		vvdArr[vvdIdx]=currVvd;
		for(var i=headCnt; i<=totCnt; i++){
			if(currVvd != sheetObj.GetCellValue(i, prefix+"vvd")){
				currVvd=sheetObj.GetCellValue(i, prefix+"vvd");
				vvdArr[vvdIdx++]=currVvd;
			}
		}
		appendMultiComboItem(getComboObject("remark"), vvdArr, vvdArr, stndVvd);
	}
	/**
	 * Backup TZTM_HRS, ACT_WRK_HRS
	 * 
	 * @param sheetObj
	 * @return
	 */
	function setTmpHrs(sheetObj){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		for(var Row=headCnt; Row<=totCnt; Row++){
			sheetObj.SetCellValue(Row, prefix+"tmp_tztm_hrs",sheetObj.GetCellValue(Row, prefix+"tztm_hrs"),0);
			sheetObj.SetCellValue(Row, prefix+"tmp_act_wrk_hrs",sheetObj.GetCellValue(Row, prefix+"act_wrk_hrs"),0);
			sheetObj.SetCellValue(Row, prefix+"tmp_lnk_spd",sheetObj.GetCellValue(Row, prefix+"lnk_spd"),0);
		}
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
		//alert( selCode );
	}
    /**
     * Setting conditions for simulation
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function setSimulationForm(sheetObj, formObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var bound=sheetObj.GetCellValue(headCnt, prefix+"bound");
    	var mIdx=0;
    	var curVvd="";
    	var newVvd="";
    	if(bound == 2 || bound == 4){
    		formObj.vsl_cd.value=sheetObj.GetCellValue(headCnt, prefix+"vsl_cd");
    		formObj.skd_voy_no.value=sheetObj.GetCellValue(headCnt, prefix+"skd_voy_no");
    		formObj.skd_dir_cd.value=sheetObj.GetCellValue(headCnt, prefix+"skd_dir_cd");
			Usr_setVslCd(formObj.vsl_cd.value);
	    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	    	bound=Number(bound) + 1;
    	}else{
	    	for(var i=headCnt; i<=totCnt; i++){
	    		curVvd=sheetObj.GetCellValue(i, prefix+"vvd");
				if(curVvd != newVvd){
					newVvd=curVvd;
					mIdx++;
				}
				if(mIdx == parseInt(Number(bound)/2 + 1, 10)){
					formObj.vsl_cd.value=sheetObj.GetCellValue(i, prefix+"vsl_cd");
					formObj.skd_voy_no.value=sheetObj.GetCellValue(i, prefix+"skd_voy_no");
					formObj.skd_dir_cd.value=sheetObj.GetCellValue(i, prefix+"skd_dir_cd");
	    	    	Usr_setVslCd(formObj.vsl_cd.value);
	    	    	Usr_setSkdVoyNo(formObj.skd_voy_no.value);
	    	    	Usr_setSkdDirCd(formObj.skd_dir_cd.value);
	    			break;
				}
	    	}
    	}
    	formObj.bound.value=bound;
    	Usr_setBound(formObj.bound.value);
    }
    /**
     * 
     * @param formObj
     * @param srcName
     * @return
     */
    function formNextFocus(formObj, srcName){
    	var objCnt=formObj.length;
    	for(var i=0; i<objCnt-1; i++){
    		if(formObj.elements[i].name == srcName){
    			if(formObj.elements[i+1].focus()){
    				formObj.elements[i+1].focus();
    				return false;
    			}
    		}
    	}
    }
    /**
     * Trnasmitting mail
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function sendMail(sheetObj, formObj){
    	formObj.com_subject.value=getGWSubject(sheetObj, formObj);
    	formObj.com_content.value=getGWMailHtmlContents(sheetObj, formObj);
//    	mail format을 위해 공통함수를 copy해서 사용한다.
//    	ComSendMailModal();
    	sendMailModal();
    }
    /**
     * Mail의 Popup 을 띄운다.(from CoMail.js)
     * @fileoverview mail 관련 함수가 정의되어 있다.
     * @author 
     * @return 없음
     */
    function sendMailModal() {
//    	var vFeatures="status=no, width=" + 770 + ", height=" + 680 + ", left=" + (screen.width -770) / 2;
    	var vFeatures="status=no, resizable=yes, width=" + 980 + ", height=" + 680 + ", left=" + (screen.width -980) / 2;
  	    ComPostOpenWindow("/opuscntr/syscommon/common/mail/jsp/COM_MAIL_COMMON_POPUP_MODALESS.jsp", "mail", vFeatures);
    }
    /**
     * Returning Title for Groupware(Mail, Board)
     * 
     * @param sheetObj
     * @return
     */
    function getGWSubject(sheetObj, formObj){
    	var subject="[" + formObj.vsl_slan_cd.value + "]";
    	subject=subject + " Coastal Schedule of VVD";
    	subject=subject + "(" + getVVDListInfo(sheetObj, "mail_title", "/") + ")";
    	return subject;
    }
    /**
     * Returning VVD List
     * 
     * @param sheetObj
     * @param sFlag
     * @param sDelim
     * @return
     */
    function getVVDListInfo(sheetObj, sFlag, sDelim){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var argVDs="";
    	var curVD="";
    	var nxtVD="";
    	if(rowCnt > 0){
    		if(sFlag == "mail_title"){
    			curVD=sheetObj.GetCellValue(headCnt, prefix+"vsl_cd") + sheetObj.GetCellValue(headCnt, prefix+"skd_voy_no") + sheetObj.GetCellValue(headCnt, prefix+"skd_dir_cd");
    		}else if(sFlag == "mail_body"){
    			curVD=sheetObj.GetCellValue(headCnt, prefix+"skd_voy_no") + sheetObj.GetCellValue(headCnt, prefix+"skd_dir_cd");
    		}
    		argVDs=curVD;
    		for(var i=headCnt; i<=totCnt; i++){
    			if(sFlag == "mail_title"){
    				nxtVD=sheetObj.GetCellValue(headCnt, prefix+"vsl_cd") + sheetObj.GetCellValue(i, prefix+"skd_voy_no") + sheetObj.GetCellValue(i, prefix+"skd_dir_cd");
    			}else if(sFlag == "mail_body"){
    				nxtVD=sheetObj.GetCellValue(i, prefix+"skd_voy_no") + sheetObj.GetCellValue(i, prefix+"skd_dir_cd");
        		}
    			if(curVD != nxtVD){
    				argVDs=argVDs + sDelim + nxtVD;
    				curVD=nxtVD;
    			}
    		}
    	}else{
    		return "";
    	}
    	return argVDs;
    }
    /*
     * 	25th MAR 2010
		TO : ALL CONCERNED PARTIES
		RE : [SJX] M/V VESSEL NAME 00016W/0017E F/E C/SKED
		Dear, all concerned parties,
		Please refer to HJPI 0016W/0017E F/E C/sked for Asia region.
		Port           ETA       ETB       ETD     Remark
		------------------------------------------------------
		0016W
		JPTYO  APR   02/0500   02/0800   02/1400
		JPOSA        03/0900   03/1200   03/1800
		CNHKG        06/1300   06/1500   06/2100
		0017E
		MYPKG  APR   10/0700   10/0800   10/1500
		SGSIN        11/0300   11/0500   11/2100
		VNVUN        13/0500   13/0800   14/0001
		CNHKG        15/2200   16/0001   16/0500
		CNYIT        16/0900   16/1000   16/2000
		JPOSA        19/1400   19/1700   19/2100
		JPTYO        20/1800   20/2100   21/0200
		USLGB        30/0500
     */
    /**
     * Returning Text for Groupware(Mail)
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailTextContents(sheetObj, formObj){
    	var year=ComGetNowInfo("yy");
    	var month=ComGetNowInfo("mm");
    	var day=ComGetNowInfo("dd");
    	var monthArr=new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT" ,"NOV", "DEC");
    	var voyDirInfo=getVVDListInfo(sheetObj, "mail_body", "/");
    	var contents=day + "th " + monthArr[month-1] + " " + year + "\n";
    	contents=contents + "TO : ALL CONCERNED PARTIES" + "\n";
    	contents=contents + "RE : [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + voyDirInfo + " F/E C/SKED" + "\n";
    	contents=contents + "\n";
    	contents=contents + "Dear, all concerned parties," + "\n";
    	contents=contents + "\n";
    	contents=contents + "Please refer to "+glbMainVslCd+" " + voyDirInfo + " F/E C/sked for Asia region." + "\n";
    	contents=contents + "\n";
    	contents=contents + "\n";
    	contents=contents + getGWMailTextDetailContents(sheetObj);
    	return contents;
    }
    /**
     * Returning Specific Text for Groupware(Mail)
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailTextDetailContents(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var rowCnt=sheetObj.RowCount();
    	var colCnt=sheetObj.LastCol();
    	var contents="";
    	if(rowCnt > 0){
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    		contents=contents + ComRpad("SEQ", 4, " ");
    		contents=contents + ComRpad("VOY NO", 8, " ");
    		contents=contents + ComRpad("Port", 8, " ");
    		contents=contents + ComRpad("ETA", 20, " ");
    		contents=contents + ComRpad("ETB", 20, " ");
    		contents=contents + ComRpad("ETD", 20, " ");
    		contents=contents + ComRpad("Status", 20, " ");
    		contents=contents + "Remark\n";
    		contents=contents + ComRpad("-", 120, "-") + "\n";
    		for(var i=headCnt; i<=totCnt; i++){
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"clpt_seq"), 4, " ");
    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"skd_voy_no") + sheetObj.GetCellValue(i, prefix+"skd_dir_cd"), 8, " ");
    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"vps_port_cd"), 8, " ");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_eta_dt"), 20, " ");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etb_dt"), 20, " ");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etd_dt"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, " ");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, " ");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"skd_cng_sts_cd"), 20, " ");
    			contents=contents + sheetObj.GetCellValue(i, prefix+"vps_rmk") + "\n";
    		}// end for
    		contents=contents + ComRpad("-", 120, "-") + "\n";
    	}
    	return contents;
    }
    /**
     * Returning HTML for Groupware(Mail)
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function getGWMailHtmlContents(sheetObj, formObj){
    	var year=ComGetNowInfo("yy");
    	var month=ComGetNowInfo("mm");
    	var day=ComGetNowInfo("dd");
    	var monthArr=new Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT" ,"NOV", "DEC");
    	var voyDirInfo=getVVDListInfo(sheetObj, "mail_body", "/");
    	var contents="<BODY><div style='font-size: 14px;font-family: Consolas'>\n";
    	contents=contents + day + "th " + monthArr[month-1] + " " + year + "<BR>\n";
    	contents=contents + "TO : ALL CONCERNED PARTIES" + "<BR>\n";
    	contents=contents + "RE : [" + glbMainVslSlanCd + "] M/V " + glbMainVslEngNm + " " + voyDirInfo + " F/E C/SKED" + "<BR>\n";
    	contents=contents + "<BR>\n";
    	contents=contents + "Dear, all concerned parties," + "<BR>\n";
    	contents=contents + "<BR>\n";
    	contents=contents + "Please refer to "+glbMainVslCd+" " + voyDirInfo + " F/E C/sked for Asia region." + "<BR>\n";
    	contents=contents + "<BR>\n";
    	contents=contents + "<BR>\n";
    	contents=contents + getGWMailHtmlDetailContents(sheetObj)+"\n";
    	contents=contents + "</div></BODY>";
    	return contents;
    }
    /**
     * Returning HTML for Groupware(Mail)
     * 
     * @param sheetObj
     * @return
     */
    function getGWMailHtmlDetailContents(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	var totCnt=getTotalRowCnt(sheetObj);
    	var rowCnt=sheetObj.RowCount();
    	var colCnt=sheetObj.LastCol();
    	var contents="";
    	if(rowCnt > 0){
//			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    		contents=contents + ComRpad("SEQ",    4, "&nbsp;");
    		contents=contents + ComRpad("VoyNo.", 7, "&nbsp;");
    		contents=contents + ComRpad("Port"  , 13, "&nbsp;");
    		contents=contents + ComRpad("ETA"   , 18, "&nbsp;");
    		contents=contents + ComRpad("ETB"   , 18, "&nbsp;");
    		contents=contents + ComRpad("ETD"   , 15, "&nbsp;");
    		contents=contents + ComRpad("Status", 11, "&nbsp;");
    		contents=contents + "Remark"+"<BR>\n";
    		contents=contents + ComRpad("-", 110, "-");
    		contents=contents + "<BR>\n";
    		var curVoyDir="";
    		var preVoyDir="";
    		for(var i=headCnt; i<=totCnt; i++){
    			curVoyDir=sheetObj.GetCellValue(i, prefix+"skd_voy_no") + sheetObj.GetCellValue(i, prefix+"skd_dir_cd");
//    			SEQ	VOY NO	Port	ETA		ETB		ETD		Status		Remark
    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"clpt_seq"), 4, "&nbsp;");
    			if(preVoyDir != curVoyDir){
    				contents=contents + ComRpad(curVoyDir, 7, "&nbsp;");
    				preVoyDir=curVoyDir;
    			}else{
    				contents=contents + ComRpad("", 7, "&nbsp;");
    			}
    			contents=contents + ComRpad(sheetObj.GetCellValue(i, prefix+"vps_port_cd"), 7, "&nbsp;");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_eta_dt"), 18, "&nbsp;");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etb_dt"), 18, "&nbsp;");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"vps_etd_dt"), 18, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_eta_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etb_dt"), "ymdhm"), 20, "&nbsp;");
// 				contents = contents + ComRpad(ComGetMaskedValue(sheetObj.CellValue(i, prefix+"vps_etd_dt"), "ymdhm"), 20, "&nbsp;");
    			contents=contents + ComRpad(sheetObj.GetCellText(i, prefix+"skd_cng_sts_cd"), 14, "&nbsp;");
    			contents=contents + sheetObj.GetCellValue(i, prefix+"vps_rmk") + "<BR>\n";
    		}// end for
    		contents=contents + ComRpad("-", 110, "-");
    		contents=contents + "<BR>\n";
    	}
    	return contents;
    }
	/*
	 * =====================================================================
	 * Sheet Control
	 * =====================================================================
	 */
	/**
	 * Setting Terminal Combo Data
	 * @param xmlStr
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var prefix=sheetObj.id + "_";
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
			sheetObj.CellComboItem(Row,prefix+"tml_cd", {ComboText:ydTxt, ComboCode:ydKindCode} );
// 			sheetObj.CellValue2(Row, prefix+"tml_cd") = ydNmArr[0];
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
	 * Change Font Color to Back Color
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function cellFontToBackColor(sheetObj, Row, Col){
		sheetObj.SelectCell(Row, Col);
		var rowBackColor = sheetObj.GetRowBackColor(Row);
		if(rowBackColor == ""){
			rowBackColor = "#FFFFFF";
		}
 		sheetObj.SetCellFontColor(Row, Col,rowBackColor);
	}
	/**
	 * Change Font Color to Original Font Color
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToOriginColor(sheetObj, Row, Col){
		sheetObj.SelectCell(Row, Col);
 		sheetObj.SetCellFontColor(Row, Col,"#000000");
	}
	/**
	 * Returning Expand / Hidden state
	 * @param sheetObj
	 * @return
	 */
	function isHiddenState(sheetObj){
		var prefix=sheetObj.id + "_";
		var isGetColHidden=true;
		if(sheetObj.id == "sheet1"){
			isGetColHidden=sheetObj.GetColHidden(prefix+"lnk_dist");
		}else{
			isGetColHidden=sheetObj.GetColHidden(prefix+"ib_cgo_qty");
		}
		return isGetColHidden;
	}
	/**
	 * Changing Selected 2 rows
	 * @param sheetObj
	 * @return
	 */
	function rowDataChange(sheetObj){
		
		var prefix		= sheetObj.id + "_";
		var sRow		= sheetObj.GetSelectRow();
		var headCnt		= sheetObj.HeaderRows();
		var selRows   	= sheetObj.GetSelectionRows("|").split("|");
		
		var isGetColHidden=true;
		if(sheetObj.id == "sheet1"){
			isGetColHidden=sheetObj.GetColHidden(prefix+"lnk_dist");
		}else{
			isGetColHidden=sheetObj.GetColHidden(prefix+"ib_cgo_qty");
		}
		
		
		if(selRows.length != 2){
			return false;
		}
		
		//Column Count
		var colCnt		= sheetObj.LastCol();
		var vvd1		= sheetObj.GetCellValue(selRows[0], prefix+"vvd");
		var vvd2		= sheetObj.GetCellValue(selRows[1], prefix+"vvd");
		// if VVDs are different, Blocking Reverse
		if(vvd1 != vvd2){
			return false;
		}
		var chgStsCd1	= sheetObj.GetCellValue(selRows[0], prefix+"skd_cng_sts_cd");
		var chgStsCd2	= sheetObj.GetCellValue(selRows[1], prefix+"skd_cng_sts_cd");
		
//		if(chgStsCd1 == "R" && chgStsCd2 == "R"){
//			sheetObj.CellValue2(selRows[0], prefix+"skd_cng_sts_cd") = sheetObj.CellValue(selRows[0], prefix+"tmp_cng_sts_cd");
//			sheetObj.CellValue2(selRows[1], prefix+"skd_cng_sts_cd") = sheetObj.CellValue(selRows[1], prefix+"tmp_cng_sts_cd");
//		}else if(chgStsCd1 != "R" && chgStsCd2 != "R"){
//			sheetObj.CellValue2(selRows[0], prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(selRows[0], prefix+"skd_cng_sts_cd");
//			sheetObj.CellValue2(selRows[1], prefix+"tmp_cng_sts_cd") = sheetObj.CellValue(selRows[1], prefix+"skd_cng_sts_cd");
//			sheetObj.CellValue2(selRows[0], prefix+"skd_cng_sts_cd") = "R";
//			sheetObj.CellValue2(selRows[1], prefix+"skd_cng_sts_cd") = "R";
//		}else{
//			return false;
//		}
		
		var tempData	= "";
		
		// Changing Selected 2 rows
		for (var i=0; i <= colCnt; i++) {
			if(sheetObj.ColSaveName(i) == prefix+"tml_cd"){
				var sText1=sheetObj.GetComboInfo(selRows[0], i, "Text");
				var sText2=sheetObj.GetComboInfo(selRows[1], i, "Text");
				var sCode1=sheetObj.GetComboInfo(selRows[0], i, "Code");
				var sCode2=sheetObj.GetComboInfo(selRows[1], i, "Code");
				var sVal1=sheetObj.GetCellValue(selRows[0], i);
				var sVal2=sheetObj.GetCellValue(selRows[1], i);
				sheetObj.CellComboItem(selRows[0],i, {ComboText:sText2, ComboCode:sCode2} );
				sheetObj.CellComboItem(selRows[1],i, {ComboText:sText1, ComboCode:sCode1} );
				sheetObj.SetCellValue(selRows[0], i,sVal2,0);
				sheetObj.SetCellValue(selRows[1], i,sVal1,0);
			}else{
				tempData=sheetObj.GetCellValue(selRows[0], i);
				sheetObj.SetCellValue(selRows[0], i,sheetObj.GetCellValue(selRows[1], i),0);
				sheetObj.SetCellValue(selRows[1], i,tempData,0);
			}
		}
		//sheet1, Updated Status Color change
		if(sheetObj.id == "sheet1"){
			with(sheetObj){
				for(var i=0; i<selRows.length; i++){
					if(GetCellValue(selRows[i], prefix+"upd_sts") == "Actual"){
		    			SetCellBackColor(selRows[i], prefix+"upd_sts",glbActualColor);
					} else if (GetCellValue(selRows[i], prefix+"upd_sts") == "HQ/RSO") {
		    			SetCellBackColor(selRows[i], prefix+"upd_sts",glbHQColor);
					} else if (GetCellValue(selRows[i], prefix+"upd_sts") == "Noon") {
		    			SetCellBackColor(selRows[i], prefix+"upd_sts",glbNoonColor);
					} else if (GetCellValue(selRows[i], prefix+"upd_sts") == "Departure") {
		    			SetCellBackColor(selRows[i], prefix+"upd_sts",glbDepartureColor);
					} else if (GetCellValue(selRows[i], prefix+"upd_sts") == "Initial") {
		    			SetCellBackColor(selRows[i], prefix+"upd_sts",glbInitialColor);
		    		}
				}
			}
			//Yard change state Change
			var tpVal1=glbSkdPortFlgs[selRows[0] - headCnt];
			var tpVal2=glbSkdPortFlgs[selRows[1] - headCnt];
			glbSkdPortFlgs[selRows[0] - headCnt]=tpVal2;
			glbSkdPortFlgs[selRows[1] - headCnt]=tpVal1;
		}else{
			//Yard change 여부 Change
			var tpVal1=glbPlanPortFlgs[selRows[0] - headCnt];
			var tpVal2=glbPlanPortFlgs[selRows[1] - headCnt];
			glbPlanPortFlgs[selRows[0] - headCnt]=tpVal2;
			glbPlanPortFlgs[selRows[1] - headCnt]=tpVal1;
		}
		// Deleting P/F Date
		if (sheetObj.GetCellValue(selRows[0], prefix+"skd_cng_sts_cd") == "A") {
			sheetObj.SetCellValue(selRows[0], prefix+"pf_eta_dt","",0);
			sheetObj.SetCellValue(selRows[0], prefix+"pf_etb_dt","",0);
			sheetObj.SetCellValue(selRows[0], prefix+"pf_etd_dt","",0);
		}
		
		if (sheetObj.GetCellValue(selRows[1], prefix+"skd_cng_sts_cd") == "A") {
			sheetObj.SetCellValue(selRows[1], prefix+"pf_eta_dt","",0);
			sheetObj.SetCellValue(selRows[1], prefix+"pf_etb_dt","",0);
			sheetObj.SetCellValue(selRows[1], prefix+"pf_etd_dt","",0);
		}
				
		if (sheetObj.GetCellValue(selRows[0], prefix+"ib_cssm_voy_no").length == 0) {
			sheetObj.SetCellValue(selRows[0], prefix+"ib_cssm_voy_no","",0);
		}
		
		if (sheetObj.GetCellValue(selRows[0], prefix+"ob_cssm_voy_no").length == 0) {
			sheetObj.SetCellValue(selRows[0], prefix+"ob_cssm_voy_no","",0);
		}
		
		if (sheetObj.GetCellValue(selRows[1], prefix+"ib_cssm_voy_no").length == 0) {
			sheetObj.SetCellValue(selRows[1], prefix+"ib_cssm_voy_no","",0);
		}
		
		if (sheetObj.GetCellValue(selRows[1], prefix+"ob_cssm_voy_no").length == 0) {
			sheetObj.SetCellValue(selRows[1], prefix+"ob_cssm_voy_no","",0);
		}
		//sheetObj.SetCellValue(selRows[0], prefix+"pf_eta_dt","",0);
		//sheetObj.SetCellValue(selRows[0], prefix+"pf_etb_dt","",0);
		//sheetObj.SetCellValue(selRows[0], prefix+"pf_etd_dt","",0);
		//sheetObj.SetCellValue(selRows[1], prefix+"pf_eta_dt","",0);
		//sheetObj.SetCellValue(selRows[1], prefix+"pf_etb_dt","",0);
		//sheetObj.SetCellValue(selRows[1], prefix+"pf_etd_dt","",0);
		
		sheetObj.SelectCell(selRows[1], sheetObj.GetSelectCol());
		
		/******************* Calculation Distance/Sea Speed/Sea Transit Time/... ************************/
		
		////by top:2015-04-27//var sXml=doCallBaseInfo(sheetObj, selRows[0], "REVERSE", selRows[1]);
// 		sheetObj.Redraw = true;
		// Setting Dist, Sea Time
		
		////by top:2015-04-27//setBaseInfo(sheetObj, sXml, selRows[0], "REVERSE", selRows[1]);
		// clpt_seq reset
		
		
		var	sRow1		= selRows[0];
		var	sRow2		= selRows[1];
		
		//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk//
		//alert('selRows <<< '+selRows+' >>>  sRow1 ['+sRow1+'] sRow2 ['+sRow2+']');
		
		
		var preRow1	= getNotSkipRow(sheetObj, sRow1, "P");
    	var nxtRow1	= getNotSkipRow(sheetObj, sRow1, "N");

		//alert('sRow1 << '+sRow1+' >>> first preRow1 ['+preRow1+']   sRow1 ['+sRow1+']  port pair ['+sheetObj.GetCellValue(preRow1, prefix+"vps_port_cd")+' >> '+sheetObj.GetCellValue(sRow1, prefix+"vps_port_cd")+']');
		//alert('sRow1 << '+sRow1+' >>> first sRow1 ['+sRow1+']   nxtRow1 ['+nxtRow1+']  port pair ['+sheetObj.GetCellValue(sRow1, prefix+"vps_port_cd")+' >> '+sheetObj.GetCellValue(nxtRow1, prefix+"vps_port_cd")+']');
    	
    	if(sRow1 != null && sRow1 != undefined && sRow1>0){
    		
    		if(preRow1>0){
    			var sXml	= doUnitCallBaseInfo(sheetObj, preRow1, sRow1);
    			
    			// Setting Dist, Sea Time
    			if(preRow1>0 && sXml != null && sXml != undefined && sXml != ""){
    				
    				if(isGetColHidden == false){
    					setUnitPortBaseInfo	(sheetObj, sXml, preRow1, sRow1);
    				}
    			}    			
    		}

			var sXml	= doUnitCallBaseInfo(sheetObj, sRow1, nxtRow1);
			
			// Setting Dist, Sea Time
			if(nxtRow1>0 && sXml != null && sXml != undefined && sXml != ""){
				
				if(isGetColHidden == false){
					setUnitPortBaseInfo	(sheetObj, sXml, sRow1, nxtRow1);
				}
			}    					
    	}	
    	
    	
		var preRow2	= getNotSkipRow(sheetObj, sRow2, "P");
    	var nxtRow2	= getNotSkipRow(sheetObj, sRow2, "N");

		//alert('sRow2 << '+sRow2+' >>> first preRow2 ['+preRow2+']   sRow2 ['+sRow2+']  port pair ['+sheetObj.GetCellValue(preRow2, prefix+"vps_port_cd")+' >> '+sheetObj.GetCellValue(sRow2, prefix+"vps_port_cd")+']');
		//alert('sRow2 << '+sRow2+' >>> first sRow2 ['+sRow2+']   nxtRow2 ['+nxtRow2+']  port pair ['+sheetObj.GetCellValue(sRow2, prefix+"vps_port_cd")+' >> '+sheetObj.GetCellValue(nxtRow2, prefix+"vps_port_cd")+']');
    	
    	if(sRow2 != null && sRow2 != undefined && sRow2>0){
    		
    		if(preRow2>0){
    			var sXml	= doUnitCallBaseInfo(sheetObj, preRow2, sRow2);
    			
    			// Setting Dist, Sea Time
    			if(preRow2>0 && sXml != null && sXml != undefined && sXml != ""){
    				
    				if(isGetColHidden == false){
    					setUnitPortBaseInfo	(sheetObj, sXml, preRow2, sRow2);
    				}
    			}    			
    		}

			var sXml	= doUnitCallBaseInfo(sheetObj, sRow2, nxtRow2);
			
			// Setting Dist, Sea Time
			if(nxtRow2>0 && sXml != null && sXml != undefined && sXml != ""){
				
				if(isGetColHidden == false){
					setUnitPortBaseInfo	(sheetObj, sXml, sRow2, nxtRow2);
				}
			}    					
    	}	
		/************************************************************************************************/		
		
		resetClptSeq	(sheetObj);
		resetClptIndSeq	(sheetObj);
// 		sheetObj.Redraw = true;
		return true;
	}

	
	/**
	 * Recalculating Basic Data
	 * 
	 * @param sheetObj
	 * @param sXml
	 * @param sRow
	 * @param evtFlg
	 * @param eRow
	 * @return
	 */
	function setUnitAddPortBaseInfo(sheetObj, sXml, sRow, eRow, actWrkHrs){
		
		var stndDist		= ComGetEtcData(sXml, "stnd_dist");	// Dist
		var prefix			= sheetObj.id + "_";
		var headCnt			= sheetObj.HeaderRows();
		
		var xmlDist			= ComGetEtcData(sXml, "lnk_dist");
		var xmlSpd			= ComGetEtcData(sXml, "lnk_spd");
		
		var xmlMnvrInHrs	= ComGetEtcData(sXml, "mnvr_in_hrs");
		var xmlMnvrOutHrs	= ComGetEtcData(sXml, "mnvr_out_hrs");
		
		/********************************************************************
		 * Adjustment for time diff between two ports 
		 * 2015-05-07 by TOP
		 **/ 
		var xmlTztmHrs			= ComGetEtcData(sXml, "tztm_hrs");
		var prePortTimeDiff		= "";
		var nxtPortTimeDiff		= "";
		var mnvrOutHrs			= "";
		
		if(sheetObj.GetRowStatus(sRow) == "I"){
			prePortTimeDiff		= ComGetEtcData(sXml, "time_diff");
			mnvrOutHrs			= ComGetEtcData(sXml, "mnvr_out_hrs");
			nxtPortTimeDiff		= sheetObj.GetCellValue(eRow, prefix+"time_diff");
		}else if(sheetObj.GetRowStatus(eRow) == "I"){
			prePortTimeDiff		= sheetObj.GetCellValue(sRow, prefix+"time_diff");
			mnvrOutHrs			= sheetObj.GetCellValue(sRow, prefix+"mnvr_out_hrs");
			nxtPortTimeDiff		= ComGetEtcData(sXml, "time_diff");
		}
		
		prePortTimeDiff			= prePortTimeDiff == null || prePortTimeDiff == "" || prePortTimeDiff == undefined?0:Math.round(prePortTimeDiff);
		nxtPortTimeDiff 		= nxtPortTimeDiff == null || nxtPortTimeDiff == "" || nxtPortTimeDiff == undefined?0:Math.round(nxtPortTimeDiff);
		mnvrOutHrs				= mnvrOutHrs == null || mnvrOutHrs == "" || mnvrOutHrs == undefined?0:Math.round(mnvrOutHrs);		
			
		var xmlTimeDiff			= parseInt(nxtPortTimeDiff - prePortTimeDiff);
			
		//alert('row id sRow['+sRow+'] - eRow ['+eRow+'] \n Port Pair ['+sheetObj.GetCellValue(sRow, prefix+"vps_port_cd")+'] - ['+sheetObj.GetCellValue(eRow, prefix+"vps_port_cd")+'] \n prePortTimeDiff ['+prePortTimeDiff+']   nxtPortTimeDiff ['+nxtPortTimeDiff+']  xmlTztmHrs [['+xmlTztmHrs+']] mnvrOutHrs ['+mnvrOutHrs+']');
		
		xmlTztmHrs				= parseInt(xmlTztmHrs) + parseInt(nxtPortTimeDiff - prePortTimeDiff) + parseInt(mnvrOutHrs);
		/********************************************************************/
		
		//var xmlCrnKnt		= ComGetEtcData(sXml, "crn_knt");
		//var xmlTmlProdQty	= ComGetEtcData(sXml, "tml_prod_qty");
		//var xmlPortBufHrs	= ComGetEtcData(sXml, "port_buf_hrs");
		
		
		//alert('xmlDist			['+xmlDist		+']');    
		//alert('xmlSpd			['+xmlSpd		+']');    
		//alert('xmlSeaTime		['+xmlSeaTime	+']');    
		//alert('xmlTimeDiff		['+xmlTimeDiff	+']');    
		//alert('xmlMnvrInHrs		['+xmlMnvrInHrs	+']');
		//alert('xmlMnvrOutHrs	['+xmlMnvrOutHrs+']');   
		//alert('xmlCrnKnt		['+xmlCrnKnt	+']');    
		//alert('xmlTmlProdQty	['+xmlTmlProdQty+']');   
		//alert('xmlPortBufHrs	['+xmlPortBufHrs+']');   
		
		//alert('row no ['+sRow+']   dist ['+xmlDist+']');
		
		//=================================================================================
		
		////if(sheetObj.GetCellValue	(sRow, prefix+"skd_cng_sts_cd") == "A"){
		//alert(sheetObj.GetCellValue	(sRow, prefix+"ibflag")+'  port time ['+actWrkHrs+']');

		if(sheetObj.GetRowStatus(sRow) == "I"){
			sheetObj.SetCellValue	(sRow, prefix+"tztm_hrs"				,xmlTztmHrs		,0);
			sheetObj.SetCellValue	(sRow, prefix+"lnk_spd"					,xmlSpd			,0);
			sheetObj.SetCellValue	(sRow, prefix+"act_wrk_hrs"				,actWrkHrs		,0);
			sheetObj.SetCellValue	(sRow, prefix+"time_diff"				,xmlTimeDiff	,0);
			sheetObj.SetCellValue	(sRow, prefix+"mnvr_in_hrs"				,xmlMnvrInHrs	,0);
			sheetObj.SetCellValue	(sRow, prefix+"mnvr_out_hrs"			,xmlMnvrOutHrs	,0);
			sheetObj.SetCellValue	(sRow, prefix+"pf_mnvr_in_hrs"			,xmlMnvrInHrs	,0);
			sheetObj.SetCellValue	(sRow, prefix+"pf_mnvr_out_hrs"			,xmlMnvrOutHrs	,0);
			sheetObj.SetCellValue	(sRow, prefix+"sea_buf_hrs"				,"0"			,0);
			sheetObj.SetCellValue	(sRow, prefix+"port_buf_hrs"			,"0"			,0);
			
		}else{
			
			/////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////
			
			//alert(' add call ..else.. sRow ['+sRow+']  port ['+sheetObj.GetCellValue(sRow, prefix+"vps_port_cd")+']  lnk_dist for recoverying ['+sheetObj.GetCellValue(sRow, prefix+"lnk_dist")+']');
			
			sheetObj.SetCellValue	(sRow, prefix+"lnk_dist_for_recovery"	 ,sheetObj.GetCellValue(sRow, prefix+"lnk_dist")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"lnk_spd_for_recovery"	 ,sheetObj.GetCellValue(sRow, prefix+"lnk_spd")		,0);
			sheetObj.SetCellValue	(sRow, prefix+"tztm_hrs_for_recovery"	 ,sheetObj.GetCellValue(sRow, prefix+"tztm_hrs")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"act_wrk_hrs_for_recovery" ,sheetObj.GetCellValue(sRow, prefix+"act_wrk_hrs")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"time_diff_for_recovery"	 ,sheetObj.GetCellValue(sRow, prefix+"time_diff")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"mnvr_in_hrs_for_recovery" ,sheetObj.GetCellValue(sRow, prefix+"mnvr_in_hrs")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"mnvr_out_hrs_for_recovery",sheetObj.GetCellValue(sRow, prefix+"mnvr_out_hrs"),0);
			sheetObj.SetCellValue	(sRow, prefix+"sea_buf_hrs_for_recovery" ,sheetObj.GetCellValue(sRow, prefix+"sea_buf_hrs")	,0);
			sheetObj.SetCellValue	(sRow, prefix+"port_buf_hrs_for_recovery",sheetObj.GetCellValue(sRow, prefix+"port_buf_hrs"),0);
			
			/*
			 * lnk_dist
			 * lnk_spd 
			 * tztm_hrs(sea_time)
			 * act_wrk_hrs(port_time) 
			 * port_buf_hrs 
			 * sea_buf_hrs 
			 * mnvr_in_hrs
			 * mnvr_out_hrs 
			 * sea_time = lnk_dist / lnk_spd
			 */
			
			var	tztmHrs	= 0;
			if(xmlSpd == 0 || xmlSpd == null || xmlSpd == "" || xmlSpd == undefined)  	tztmHrs	= 0;
			else																		tztmHrs	= xmlDist/xmlSpd;
			
			sheetObj.SetCellValue	(sRow, prefix+"tztm_hrs"			,Math.round(tztmHrs)	,0);
			sheetObj.SetCellValue	(sRow, prefix+"pf_tztm_hrs"			,Math.round(tztmHrs)	,0);
			
			/////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////
			
		}
			
		sheetObj.SetCellValue		(sRow, prefix+"lnk_dist"			,xmlDist		,0);
		
		//----------------------------------------------------------------------------------
		sheetObj.SetCellValue		(sRow, prefix+"crn_knt"				,"0"			,0);
		sheetObj.SetCellValue		(sRow, prefix+"tml_prod_qty"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"sea_buf_hrs"			,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"port_buf_hrs"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"act_wrk_hrs"			,"0"			,0);
		//---------------------------------------------------------------------------------
		
// 				===================================================================================
		sheetObj.SetCellBackColor	(sRow, prefix+"lnk_dist"			,glbTestColor);
		sheetObj.SetCellBackColor	(sRow, prefix+"tztm_hrs"			,glbTestColor);
		sheetObj.SetCellBackColor	(sRow, prefix+"lnk_spd"				,glbTestColor);
		sheetObj.SetCellBackColor	(sRow, prefix+"time_diff"			,glbTestColor);
		sheetObj.SetCellBackColor	(sRow, prefix+"mnvr_in_hrs"			,glbTestColor);
		sheetObj.SetCellBackColor	(sRow, prefix+"mnvr_out_hrs"		,glbTestColor);
		//---------------------------------------------------------------------------------
		//sheetObj.SetCellBackColor	(sRow, prefix+"crn_knt"				,glbTestColor);
		//sheetObj.SetCellBackColor	(sRow, prefix+"tml_prod_qty"		,glbTestColor);
// 				sheetObj.CellBackColor(sRow, prefix+"act_wrk_hrs") = glbTestColor;
		//sheetObj.SetCellBackColor	(sRow, prefix+"port_buf_hrs"		,glbTestColor);
// 				===================================================================================
			

			
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////

//			stndDist	= xmlDist;
//			
//			var stndDists=stndDist.split("|");
//			if(stndDists.length > 0){
//				//passing skiped row
//				var skipCnt=0;
//				for(var i=0; i<stndDists.length+skipCnt; i++){
//					if(sheetObj.GetCellValue(sRow+i-1, prefix+"skd_cng_sts_cd") == "S"){
//						skipCnt++;
//					}else{
//						
//						if(sRow > headCnt){
//							sheetObj.SetCellValue(sRow+i-1, prefix+"lnk_dist",stndDists[i-skipCnt],0);
//							sheetObj.SetCellBackColor(sRow+i-1, prefix+"lnk_dist",glbTestColor);
//							
//							if(spd != null && spd != undefined && spd != "" && spd != 0){
//								if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
//									sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs","0",0);
//								}else{
//									sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs",Math.round(stndDists[i-skipCnt] / spd),0);
//								}
//								sheetObj.SetCellBackColor(sRow+i-1, prefix+"tztm_hrs",glbTestColor);
//							}else{
//								sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs","0",0);
//								sheetObj.SetCellBackColor(sRow+i-1, prefix+"tztm_hrs",glbTestColor);
//							}
//							
//						}else{
//							sheetObj.SetCellValue(sRow+i, prefix+"lnk_dist",stndDists[i-skipCnt],0);
//							sheetObj.SetCellBackColor(sRow+i, prefix+"lnk_dist",glbTestColor);
//							var spd=sheetObj.GetCellValue(sRow+i, prefix+"lnk_spd");
//							if(spd != null && spd != undefined && spd != "" && spd != 0){
//								if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
//									sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs","0",0);
//								}else{
//									sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs",Math.round(stndDists[i-skipCnt] / spd),0);
//								}
//								sheetObj.SetCellBackColor(sRow+i, prefix+"tztm_hrs",glbTestColor);
//							}else{
//								sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs","0",0);
//								sheetObj.SetCellBackColor(sRow+i, prefix+"tztm_hrs",glbTestColor);
//							}
//						}
//					}
//				}
//			}
//			
//			if(sheetObj.id == "sheet2"){
//    			calcTotalCost(sheetObj);
//			}
		
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
						
			
		
	}	
	
	
	/**
	 * Recalculating Basic Data
	 * 
	 * @param sheetObj
	 * @param sXml
	 * @param sRow
	 * @param evtFlg
	 * @param eRow
	 * @return
	 */
	function setUnitSkipPortBaseInfo(sheetObj, sXml, preRow, sRow, nxtRow){
		
		var stndDist		= ComGetEtcData(sXml, "stnd_dist");	// Dist
		var prefix			= sheetObj.id + "_";
		var headCnt			= sheetObj.HeaderRows();
		
		var xmlDist			= ComGetEtcData(sXml, "lnk_dist");
		var xmlTztmHrs		= ComGetEtcData(sXml, "tztm_hrs");
		
		var xmlSpd			= ComGetEtcData(sXml, "lnk_spd");
		var xmlTimeDiff		= ComGetEtcData(sXml, "time_diff");
			
		var xmlMnvrInHrs	= ComGetEtcData(sXml, "mnvr_in_hrs");
		var xmlMnvrOutHrs	= ComGetEtcData(sXml, "mnvr_out_hrs");
		
		//var xmlCrnKnt		= ComGetEtcData(sXml, "crn_knt");
		//var xmlTmlProdQty	= ComGetEtcData(sXml, "tml_prod_qty");
		//var xmlPortBufHrs	= ComGetEtcData(sXml, "port_buf_hrs");
		
		
		//alert('xmlDist			['+xmlDist		+']');    
		//alert('xmlSpd			['+xmlSpd		+']');    
		//alert('xmlSeaTime		['+xmlSeaTime	+']');    
		//alert('xmlTimeDiff		['+xmlTimeDiff	+']');    
		//alert('xmlMnvrInHrs		['+xmlMnvrInHrs	+']');
		//alert('xmlMnvrOutHrs	['+xmlMnvrOutHrs+']');   
		//alert('xmlCrnKnt		['+xmlCrnKnt	+']');    
		//alert('xmlTmlProdQty	['+xmlTmlProdQty+']');   
		//alert('xmlPortBufHrs	['+xmlPortBufHrs+']');   
		
		//alert('row no ['+sRow+']   dist ['+xmlDist+']');
		
		//=================================================================================
		
		////if(sheetObj.GetCellValue	(sRow, prefix+"skd_cng_sts_cd") == "A"){
		//alert(sheetObj.GetCellValue	(sRow, prefix+"ibflag")+'  port time ['+actWrkHrs+']');

			
		/////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
		
		//alert(' skip call ..else.. preRow ['+preRow+']  port ['+sheetObj.GetCellValue(preRow, prefix+"vps_port_cd")+']  lnk_dist for recoverying ['+sheetObj.GetCellValue(preRow, prefix+"lnk_dist")+']');
		
		sheetObj.SetCellValue	(preRow, prefix+"lnk_dist_for_recovery"	 	,sheetObj.GetCellValue(preRow, prefix+"lnk_dist")		,0);
		sheetObj.SetCellValue	(preRow, prefix+"lnk_spd_for_recovery"	 	,sheetObj.GetCellValue(preRow, prefix+"lnk_spd")		,0);
		sheetObj.SetCellValue	(preRow, prefix+"tztm_hrs_for_recovery"	 	,sheetObj.GetCellValue(preRow, prefix+"tztm_hrs")		,0);
		sheetObj.SetCellValue	(preRow, prefix+"act_wrk_hrs_for_recovery" 	,sheetObj.GetCellValue(preRow, prefix+"act_wrk_hrs")	,0);
		sheetObj.SetCellValue	(preRow, prefix+"time_diff_for_recovery"	,sheetObj.GetCellValue(preRow, prefix+"time_diff")		,0);
		sheetObj.SetCellValue	(preRow, prefix+"mnvr_in_hrs_for_recovery" 	,sheetObj.GetCellValue(preRow, prefix+"mnvr_in_hrs")	,0);
		sheetObj.SetCellValue	(preRow, prefix+"mnvr_out_hrs_for_recovery"	,sheetObj.GetCellValue(preRow, prefix+"mnvr_out_hrs")	,0);
		sheetObj.SetCellValue	(preRow, prefix+"sea_buf_hrs_for_recovery" 	,sheetObj.GetCellValue(preRow, prefix+"sea_buf_hrs")	,0);
		sheetObj.SetCellValue	(preRow, prefix+"port_buf_hrs_for_recovery"	,sheetObj.GetCellValue(preRow, prefix+"port_buf_hrs")	,0);
		
		/*
		 * lnk_dist
		 * lnk_spd 
		 * tztm_hrs(sea_time)
		 * act_wrk_hrs(port_time) 
		 * port_buf_hrs 
		 * sea_buf_hrs 
		 * mnvr_in_hrs
		 * mnvr_out_hrs 
		 * sea_time = lnk_dist / lnk_spd
		 */
	
		var	tztmHrs	= 0;
		var spd	= sheetObj.GetCellValue(preRow, prefix+"lnk_spd");
		if(spd == "0" || spd == null || xmlSpd == "" || xmlSpd == undefined){
			tztmHrs	= 0;
		}else{
			tztmHrs	= xmlDist/spd;
			
			/********************************************************************
			 * Adjustment for time diff between two ports 
			 * 2015-05-07 by TOP
			 **/ 
			var tmpPrePortTimeDiff	= sheetObj.GetCellValue(preRow, prefix+"time_diff");
			var	prePortTimeDiff 	= tmpPrePortTimeDiff == null || tmpPrePortTimeDiff == "" || tmpPrePortTimeDiff == undefined?0:Math.round(tmpPrePortTimeDiff);
			var tmpCurPortTimeDiff	= ComGetEtcData(sXml, "time_diff");
			var curPortTimeDiff		= tmpCurPortTimeDiff == null || tmpCurPortTimeDiff == "" || tmpCurPortTimeDiff == undefined?0:Math.round(tmpCurPortTimeDiff);
			var tmpMnvrOutHrs		= ComGetEtcData(sXml, "mnvr_out_hrs");
			var mnvrOutHrs			= tmpMnvrOutHrs == null || tmpMnvrOutHrs == "" || tmpMnvrOutHrs == undefined?0:Math.round(tmpMnvrOutHrs);		
			
			tztmHrs					= parseInt(tztmHrs) + parseInt(curPortTimeDiff - prePortTimeDiff) + parseInt(mnvrOutHrs);
			/********************************************************************/	
			
		}
		
		sheetObj.SetCellValue	(preRow, prefix+"tztm_hrs"				,Math.round(tztmHrs)	,0);
		sheetObj.SetCellValue	(preRow, prefix+"pf_tztm_hrs"			,Math.round(tztmHrs)	,0);
		
		/////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
			
			
		sheetObj.SetCellValue		(preRow, prefix+"lnk_dist"			,xmlDist		,0);
		
		//----------------------------------------------------------------------------------
		sheetObj.SetCellValue		(preRow, prefix+"crn_knt"			,"0"			,0);
		sheetObj.SetCellValue		(preRow, prefix+"tml_prod_qty"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"sea_buf_hrs"			,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"port_buf_hrs"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"act_wrk_hrs"			,"0"			,0);
		//---------------------------------------------------------------------------------
		
// 				===================================================================================
		sheetObj.SetCellBackColor	(preRow, prefix+"lnk_dist"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"tztm_hrs"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"lnk_spd"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"time_diff"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_in_hrs"		,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_out_hrs"		,glbTestColor);
		//---------------------------------------------------------------------------------
		//sheetObj.SetCellBackColor	(sRow, prefix+"crn_knt"				,glbTestColor);
		//sheetObj.SetCellBackColor	(sRow, prefix+"tml_prod_qty"		,glbTestColor);
// 				sheetObj.CellBackColor(sRow, prefix+"act_wrk_hrs") = glbTestColor;
		//sheetObj.SetCellBackColor	(sRow, prefix+"port_buf_hrs"		,glbTestColor);
// 				===================================================================================
			

	}		
	
	
	
	/**
	 * Recalculating Basic Data
	 * 
	 * @param sheetObj
	 * @param sXml
	 * @param sRow
	 * @param evtFlg
	 * @param eRow
	 * @return
	 */
	function setUnitPortBaseInfo(sheetObj, sXml, preRow, nxtRow){
		
		var stndDist		= ComGetEtcData(sXml, "stnd_dist");	// Dist
		var prefix			= sheetObj.id + "_";
		var headCnt			= sheetObj.HeaderRows();
		
		var xmlDist			= ComGetEtcData(sXml, "lnk_dist");
		var xmlTztmHrs		= ComGetEtcData(sXml, "tztm_hrs");
		var xmlSpd			= ComGetEtcData(sXml, "lnk_spd");
		var xmlTimeDiff		= ComGetEtcData(sXml, "time_diff");
		var xmlMnvrInHrs	= ComGetEtcData(sXml, "mnvr_in_hrs");
		var xmlMnvrOutHrs	= ComGetEtcData(sXml, "mnvr_out_hrs");
		
		//var xmlCrnKnt		= ComGetEtcData(sXml, "crn_knt");
		//var xmlTmlProdQty	= ComGetEtcData(sXml, "tml_prod_qty");
		//var xmlPortBufHrs	= ComGetEtcData(sXml, "port_buf_hrs");
		
		
		//alert('xmlDist			['+xmlDist		+']');    
		//alert('xmlSpd			['+xmlSpd		+']');    
		//alert('xmlSeaTime		['+xmlSeaTime	+']');    
		//alert('xmlTimeDiff		['+xmlTimeDiff	+']');    
		//alert('xmlMnvrInHrs		['+xmlMnvrInHrs	+']');
		//alert('xmlMnvrOutHrs	['+xmlMnvrOutHrs+']');   
		//alert('xmlCrnKnt		['+xmlCrnKnt	+']');    
		//alert('xmlTmlProdQty	['+xmlTmlProdQty+']');   
		//alert('xmlPortBufHrs	['+xmlPortBufHrs+']');   
		
		//alert('row no ['+sRow+']   dist ['+xmlDist+']');
		
		//=================================================================================
		
		////if(sheetObj.GetCellValue	(sRow, prefix+"skd_cng_sts_cd") == "A"){
		//alert(sheetObj.GetCellValue	(sRow, prefix+"ibflag")+'  port time ['+actWrkHrs+']');

			
		/////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * lnk_dist
		 * lnk_spd 
		 * tztm_hrs(sea_time)
		 * act_wrk_hrs(port_time) 
		 * port_buf_hrs 
		 * sea_buf_hrs 
		 * mnvr_in_hrs
		 * mnvr_out_hrs 
		 * sea_time = lnk_dist / lnk_spd
		 */
	
		var	tztmHrs	= 0;
		var spd	= sheetObj.GetCellValue(preRow, prefix+"lnk_spd");
		if(spd == "0" || spd == null || xmlSpd == "" || xmlSpd == undefined){
			tztmHrs	= 0;
		}else{
			tztmHrs	= xmlDist/spd;
			
			/********************************************************************
			 * Adjustment for time diff between two ports 
			 * 2015-05-07 by TOP
			 **/ 
			var tmpPrePortTimeDiff	= sheetObj.GetCellValue(preRow, prefix+"time_diff");
			var	prePortTimeDiff 	= tmpPrePortTimeDiff == null || tmpPrePortTimeDiff == "" || tmpPrePortTimeDiff == undefined?0:Math.round(tmpPrePortTimeDiff);
			var tmpCurPortTimeDiff	= ComGetEtcData(sXml, "time_diff");
			var curPortTimeDiff		= tmpCurPortTimeDiff == null || tmpCurPortTimeDiff == "" || tmpCurPortTimeDiff == undefined?0:Math.round(tmpCurPortTimeDiff);
			var tmpMnvrOutHrs		= ComGetEtcData(sXml, "mnvr_out_hrs");
			var mnvrOutHrs			= tmpMnvrOutHrs == null || tmpMnvrOutHrs == "" || tmpMnvrOutHrs == undefined?0:Math.round(tmpMnvrOutHrs);		
			
			tztmHrs					= parseInt(tztmHrs) + parseInt(curPortTimeDiff - prePortTimeDiff) + parseInt(mnvrOutHrs);
			/********************************************************************/	
		}
		
		sheetObj.SetCellValue	(preRow, prefix+"tztm_hrs"				,Math.round(tztmHrs)	,0);
		sheetObj.SetCellValue	(preRow, prefix+"pf_tztm_hrs"			,Math.round(tztmHrs)	,0);
		
		/////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////
			
			
		sheetObj.SetCellValue		(preRow, prefix+"lnk_dist"			,xmlDist		,0);
		
		//----------------------------------------------------------------------------------
		sheetObj.SetCellValue		(preRow, prefix+"crn_knt"			,"0"			,0);
		sheetObj.SetCellValue		(preRow, prefix+"tml_prod_qty"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"sea_buf_hrs"			,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"port_buf_hrs"		,"0"			,0);
		//sheetObj.SetCellValue		(sRow, prefix+"act_wrk_hrs"			,"0"			,0);
		//---------------------------------------------------------------------------------
		
// 				===================================================================================
		sheetObj.SetCellBackColor	(preRow, prefix+"lnk_dist"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"tztm_hrs"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"lnk_spd"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"time_diff"			,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_in_hrs"		,glbTestColor);
		sheetObj.SetCellBackColor	(preRow, prefix+"mnvr_out_hrs"		,glbTestColor);
		//---------------------------------------------------------------------------------
		//sheetObj.SetCellBackColor	(sRow, prefix+"crn_knt"				,glbTestColor);
		//sheetObj.SetCellBackColor	(sRow, prefix+"tml_prod_qty"		,glbTestColor);
// 				sheetObj.CellBackColor(sRow, prefix+"act_wrk_hrs") = glbTestColor;
		//sheetObj.SetCellBackColor	(sRow, prefix+"port_buf_hrs"		,glbTestColor);
// 				===================================================================================
			

	}		
		
	

	/**
	 * Recalculating Basic Data
	 * 
	 * @param sheetObj
	 * @param sXml
	 * @param sRow
	 * @param evtFlg
	 * @param eRow
	 * @return
	 */
	function setBaseInfo(sheetObj, sXml, sRow, evtFlg, eRow){
		
		var stndDist	= ComGetEtcData(sXml, "stnd_dist");	// Dist
		var prefix		= sheetObj.id + "_";
		var headCnt		= sheetObj.HeaderRows();
		
		if(evtFlg == "SKIP"){
			
			if(sRow > headCnt){
				if(sheetObj.id == "sheet2"){
					var tsRow=getTsPortRow(sheetObj, sRow);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_20ft_unit_amt",ComGetEtcData(sXml, "tml_hndl_20ft_unit_amt"),0);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_40ft_unit_amt",ComGetEtcData(sXml, "tml_hndl_40ft_unit_amt"),0);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_20ft_ttl_qty",ComGetEtcData(sXml, "tml_hndl_20ft_ttl_qty"),0);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_40ft_ttl_qty",ComGetEtcData(sXml, "tml_hndl_40ft_ttl_qty"),0);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_20ft_ttl_amt",Number(sheetObj.GetCellValue(tsRow, prefix+"tml_hndl_20ft_unit_amt")) * Number(sheetObj.GetCellValue(tsRow, prefix+"tml_hndl_20ft_ttl_qty")),0);
					sheetObj.SetCellValue(tsRow, prefix+"tml_hndl_40ft_ttl_amt",Number(sheetObj.GetCellValue(tsRow, prefix+"tml_hndl_40ft_unit_amt")) * Number(sheetObj.GetCellValue(tsRow, prefix+"tml_hndl_40ft_ttl_qty")),0);
					sheetObj.SetCellValue(sRow, prefix+"pe_usd_ttl_amt",ComGetEtcData(sXml, "ttl_chg_amt"),0);
				}
				var startRow=getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
					sheetObj.SetCellValue(startRow, prefix+"lnk_dist",stndDist,0);
					sheetObj.SetCellBackColor(startRow, prefix+"lnk_dist",glbTestColor);
					
					var spd	= sheetObj.GetCellValue(startRow, prefix+"lnk_spd");
					
					var	tztmHrs	= 0;
					if(spd == 0 || spd == null || spd == "" || spd == undefined)  	tztmHrs	= 0;
					else															tztmHrs	= stndDist/spd;
					
					//::2015-04-18:://sheetObj.SetCellValue(startRow, prefix+"tztm_hrs",Math.round(Number(stndDist) / Number(spd)),0);
					
					sheetObj.SetCellValue		(startRow, prefix+"tztm_hrs", Math.round(tztmHrs), 0);
					sheetObj.SetCellBackColor	(startRow, prefix+"tztm_hrs", glbTestColor);
					
    			}
    			
    			if(sheetObj.id == "sheet2"){
	    			// Bunker Additional Cost
	    			calcBunkerAdditionalCostBySkip(sheetObj, sRow);
	    			calcTotalCost(sheetObj);
    			}
			}
			
		}else if(evtFlg == "SKIP_CANCEL" || evtFlg == "ADD_CANCEL"){
			
			if(sRow > headCnt){
				var startRow=getNotSkipRow(sheetObj, sRow, "P");
    			if(startRow > 0){
					sheetObj.SetCellValue(startRow, prefix+"lnk_dist",stndDist,0);
					sheetObj.SetCellBackColor(startRow, prefix+"lnk_dist",glbTestColor);
					var spd=sheetObj.GetCellValue(startRow, prefix+"lnk_spd");
					
					var	tztmHrs	= 0;
					if(spd == 0 || spd == null || spd == "" || spd == undefined)  	tztmHrs	= 0;
					else															tztmHrs	= stndDist/spd;
					
					
					//::2015-04-18:://sheetObj.SetCellValue(startRow, prefix+"tztm_hrs",Math.round(Number(stndDist) / Number(spd)),0);
					
					sheetObj.SetCellValue		(startRow, prefix+"tztm_hrs", Math.round(tztmHrs), 0);
					sheetObj.SetCellBackColor	(startRow, prefix+"tztm_hrs", glbTestColor);
    			}
			}
			
		}else if(evtFlg == "ADD" || evtFlg == "PORT_CHANGE"){
			
			var xmlDist			= ComGetEtcData(sXml, "lnk_dist");
			var xmlTztmHrs		= ComGetEtcData(sXml, "tztm_hrs");
			var xmlSpd			= ComGetEtcData(sXml, "lnk_spd");
			var xmlTimeDiff		= ComGetEtcData(sXml, "time_diff");
			var xmlMnvrInHrs	= ComGetEtcData(sXml, "mnvr_in_hrs");
			var xmlMnvrOutHrs	= ComGetEtcData(sXml, "mnvr_out_hrs");
			
			//var xmlCrnKnt		= ComGetEtcData(sXml, "crn_knt");
			//var xmlTmlProdQty	= ComGetEtcData(sXml, "tml_prod_qty");
			//var xmlPortBufHrs	= ComGetEtcData(sXml, "port_buf_hrs");
			
			
			//alert('xmlDist			['+xmlDist		+']');    
			//alert('xmlSpd			['+xmlSpd		+']');    
			//alert('xmlSeaTime		['+xmlSeaTime	+']');    
			//alert('xmlTimeDiff		['+xmlTimeDiff	+']');    
			//alert('xmlMnvrInHrs		['+xmlMnvrInHrs	+']');
			//alert('xmlMnvrOutHrs	['+xmlMnvrOutHrs+']');   
			//alert('xmlCrnKnt		['+xmlCrnKnt	+']');    
			//alert('xmlTmlProdQty	['+xmlTmlProdQty+']');   
			//alert('xmlPortBufHrs	['+xmlPortBufHrs+']');   
			
			
			
			//eventResponse.setETCData("tml_prod_qty"	, returnVO.getTmlProdQty());	//TMNL Prod
			
			//eventResponse.setETCData("ttl_chg_amt"	, returnVO.getTtlChgAmt	());				
			
			//alert('row no ['+sRow+']   dist ['+xmlDist+']');
			
			//=================================================================================
			sheetObj.SetCellValue		(sRow, prefix+"lnk_dist"			,xmlDist		,0);
			//sheetObj.SetCellValue		(sRow, prefix+"tztm_hrs"			,xmlTztmHrs		,0);
			//sheetObj.SetCellValue		(sRow, prefix+"lnk_spd"				,xmlSpd			,0);
			//sheetObj.SetCellValue		(sRow, prefix+"time_diff"			,xmlTimeDiff	,0);
			//sheetObj.SetCellValue		(sRow, prefix+"mnvr_in_hrs"			,xmlMnvrInHrs	,0);
			//sheetObj.SetCellValue		(sRow, prefix+"mnvr_out_hrs"		,xmlMnvrOutHrs	,0);
			//----------------------------------------------------------------------------------
			sheetObj.SetCellValue		(sRow, prefix+"crn_knt"				,"0"			,0);
			sheetObj.SetCellValue		(sRow, prefix+"tml_prod_qty"		,"0"			,0);
			sheetObj.SetCellValue		(sRow, prefix+"sea_buf_hrs"			,"0"			,0);
			sheetObj.SetCellValue		(sRow, prefix+"port_buf_hrs"		,"0"			,0);
			sheetObj.SetCellValue		(sRow, prefix+"act_wrk_hrs"			,"0"			,0);
			//---------------------------------------------------------------------------------
			
// 				===================================================================================
			sheetObj.SetCellBackColor	(sRow, prefix+"lnk_dist"			,glbTestColor);
			sheetObj.SetCellBackColor	(sRow, prefix+"tztm_hrs"			,glbTestColor);
			sheetObj.SetCellBackColor	(sRow, prefix+"lnk_spd"				,glbTestColor);
			sheetObj.SetCellBackColor	(sRow, prefix+"time_diff"			,glbTestColor);
			sheetObj.SetCellBackColor	(sRow, prefix+"mnvr_in_hrs"			,glbTestColor);
			sheetObj.SetCellBackColor	(sRow, prefix+"mnvr_out_hrs"		,glbTestColor);
			//---------------------------------------------------------------------------------
			//sheetObj.SetCellBackColor	(sRow, prefix+"crn_knt"				,glbTestColor);
			//sheetObj.SetCellBackColor	(sRow, prefix+"tml_prod_qty"		,glbTestColor);
// 				sheetObj.CellBackColor(sRow, prefix+"act_wrk_hrs") = glbTestColor;
			//sheetObj.SetCellBackColor	(sRow, prefix+"port_buf_hrs"		,glbTestColor);
// 				===================================================================================
			

			
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////

//			stndDist	= xmlDist;
//			
//			var stndDists=stndDist.split("|");
//			if(stndDists.length > 0){
//				//passing skiped row
//				var skipCnt=0;
//				for(var i=0; i<stndDists.length+skipCnt; i++){
//					if(sheetObj.GetCellValue(sRow+i-1, prefix+"skd_cng_sts_cd") == "S"){
//						skipCnt++;
//					}else{
//						
//						if(sRow > headCnt){
//							sheetObj.SetCellValue(sRow+i-1, prefix+"lnk_dist",stndDists[i-skipCnt],0);
//							sheetObj.SetCellBackColor(sRow+i-1, prefix+"lnk_dist",glbTestColor);
//							
//							if(spd != null && spd != undefined && spd != "" && spd != 0){
//								if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
//									sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs","0",0);
//								}else{
//									sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs",Math.round(stndDists[i-skipCnt] / spd),0);
//								}
//								sheetObj.SetCellBackColor(sRow+i-1, prefix+"tztm_hrs",glbTestColor);
//							}else{
//								sheetObj.SetCellValue(sRow+i-1, prefix+"tztm_hrs","0",0);
//								sheetObj.SetCellBackColor(sRow+i-1, prefix+"tztm_hrs",glbTestColor);
//							}
//							
//						}else{
//							sheetObj.SetCellValue(sRow+i, prefix+"lnk_dist",stndDists[i-skipCnt],0);
//							sheetObj.SetCellBackColor(sRow+i, prefix+"lnk_dist",glbTestColor);
//							var spd=sheetObj.GetCellValue(sRow+i, prefix+"lnk_spd");
//							if(spd != null && spd != undefined && spd != "" && spd != 0){
//								if(stndDists[i-skipCnt] == null || stndDists[i-skipCnt] == undefined || stndDists[i-skipCnt] == ""){
//									sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs","0",0);
//								}else{
//									sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs",Math.round(stndDists[i-skipCnt] / spd),0);
//								}
//								sheetObj.SetCellBackColor(sRow+i, prefix+"tztm_hrs",glbTestColor);
//							}else{
//								sheetObj.SetCellValue(sRow+i, prefix+"tztm_hrs","0",0);
//								sheetObj.SetCellBackColor(sRow+i, prefix+"tztm_hrs",glbTestColor);
//							}
//						}
//					}
//				}
//			}
//			
//			if(sheetObj.id == "sheet2"){
//    			calcTotalCost(sheetObj);
//			}
		
			///////////////////////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////////////////////
						
			
		}else if(evtFlg == "REVERSE"){
			
			if(sRow > sheetObj.HeaderRows()){
				var sStartRow=getNotSkipRow(sheetObj, sRow, "P");
				var sEndRow=getNotSkipRow(sheetObj, sRow, "N");
				var eStartRow=getNotSkipRow(sheetObj, eRow, "P");
				var eEndRow=getNotSkipRow(sheetObj, eRow, "N");
    			if(sStartRow > 0 && eEndRow > 0){
    				var stndDists=stndDist.split("|");
    				var spd="";
    				if(stndDists.length > 0){
    					sheetObj.SetCellValue(sStartRow, prefix+"lnk_dist",stndDists[0],0);
    					sheetObj.SetCellBackColor(sStartRow, prefix+"lnk_dist",glbTestColor);
    					
    					spd	= sheetObj.GetCellValue(sStartRow, prefix+"lnk_spd");
    					if(spd != null && spd != undefined && spd != "" && spd != 0){
	    					sheetObj.SetCellValue(sStartRow, prefix+"tztm_hrs",Number(stndDists[0]) / Number(spd),0);
	    					sheetObj.SetCellBackColor(sStartRow, prefix+"tztm_hrs",glbTestColor);
	    					sheetObj.SetCellValue(sRow, prefix+"lnk_dist",stndDists[1],0);
	    					sheetObj.SetCellBackColor(sRow, prefix+"lnk_dist",glbTestColor);
    					}
    					
    					spd=sheetObj.GetCellValue(sRow, prefix+"lnk_spd");
    					if(spd != null && spd != undefined && spd != "" && spd != 0){
	    					sheetObj.SetCellValue(sRow, prefix+"tztm_hrs",Number(stndDists[1]) / Number(spd),0);
	    					sheetObj.SetCellBackColor(sRow, prefix+"tztm_hrs",glbTestColor);
	    					sheetObj.SetCellValue(eStartRow, prefix+"lnk_dist",stndDists[2],0);
	    					sheetObj.SetCellBackColor(eStartRow, prefix+"lnk_dist",glbTestColor);
    					}
    					
    					spd=sheetObj.GetCellValue(eStartRow, prefix+"lnk_spd");
    					if(spd != null && spd != undefined && spd != "" && spd != 0){
	    					sheetObj.SetCellValue(eStartRow, prefix+"tztm_hrs",Number(stndDists[2]) / Number(spd),0);
	    					sheetObj.SetCellBackColor(eStartRow, prefix+"tztm_hrs",glbTestColor);
	    					sheetObj.SetCellValue(eRow, prefix+"lnk_dist",stndDists[3],0);
	    					sheetObj.SetCellBackColor(eRow, prefix+"lnk_dist",glbTestColor);
    					}
    					
    					spd=sheetObj.GetCellValue(eRow, prefix+"lnk_spd");
    					if(spd != null && spd != undefined && spd != "" && spd != 0){   					
	    					sheetObj.SetCellValue(eRow, prefix+"tztm_hrs",Number(stndDists[3]) / Number(spd),0);
	    					sheetObj.SetCellBackColor(eRow, prefix+"tztm_hrs",glbTestColor);
    					}
    					
    				}
    			}
			}
		}
	}
	
	/**
	 * Returning Skiped Row Information
	 * @param sheetObj
	 * @return
	 */
	function getSkipPortRows(sheetObj){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		var skipRows=new Array();
		var idx=0;
		for(var i=headCnt; i<totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
				skipRows[idx]=i;
				idx++;
			}
		}
		return skipRows;
	}
	
	/**
	 * Finding TS Port of inputed Row, and Returning
	 * 
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function getTsPortRow(sheetObj, sRow){
//		sheetObj.CellValue2(i, prefix+"ts_port_cd") = rtnDatas[13];				// ts_port_cd
//		sheetObj.CellValue2(i, prefix+"ts_skd_voy_no") = rtnDatas[14];			// ts_skd_voy_no
//		sheetObj.CellValue2(i, prefix+"ts_skd_dir_cd") = rtnDatas[15];			// ts_skd_dir_cd
//		sheetObj.CellValue2(i, prefix+"ts_clpt_ind_seq") = rtnDatas[16];		// ts_clpt_ind_seq
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		var tsSkdVoyNo=sheetObj.GetCellValue(sRow, prefix+"ts_skd_voy_no");
		var tsSkdDirCd=sheetObj.GetCellValue(sRow, prefix+"ts_skd_dir_cd");
		var tsPortCd=sheetObj.GetCellValue(sRow, prefix+"ts_port_cd");
		var tsClptIndSeq=sheetObj.GetCellValue(sRow, prefix+"ts_clpt_ind_seq");
		for(var i=headCnt; i<totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"skd_voy_no") == tsSkdVoyNo
					&& sheetObj.GetCellValue(i, prefix+"skd_dir_cd") == tsSkdDirCd
					&& sheetObj.GetCellValue(i, prefix+"vps_port_cd") == tsPortCd
					&& sheetObj.GetCellValue(i, prefix+"clpt_ind_seq") == tsClptIndSeq){
				return i;
			}
		}
		return sRow+1;
	}
	
	/**
	 * Setting Font Color of Skiped Row
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
		var formObj=document.form;
		var isGetColHidden=isHiddenState(sheetObj);
		if(isGetColHidden){
			showFieldControl(sheetObj, formObj, true);
		}
		// sheet1, sheet2
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
// 		cellFontToBackColor(sheetObj, sRow, prefix+"delay_date");
		cellFontToBackColor(sheetObj, sRow, prefix+"dlay_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"sea_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"vsl_dlay_rsn_cd");
		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_dist");
		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_spd");
		cellFontToBackColor(sheetObj, sRow, prefix+"tztm_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"act_wrk_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"port_buf_hrs");
		cellFontToBackColor(sheetObj, sRow, prefix+"sea_buf_hrs");
		// sheet2 
		if(glbSheetFlg == "sheet2"){
			cellFontToBackColor(sheetObj, sRow, prefix+"time_diff");
			cellFontToBackColor(sheetObj, sRow, prefix+"mnvr_in_hrs");
			cellFontToBackColor(sheetObj, sRow, prefix+"mnvr_out_hrs");
			cellFontToBackColor(sheetObj, sRow, prefix+"crn_knt");
			cellFontToBackColor(sheetObj, sRow, prefix+"tml_prod_qty");
			cellFontToBackColor(sheetObj, sRow, prefix+"ib_cgo_qty");
			cellFontToBackColor(sheetObj, sRow, prefix+"ob_cgo_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"add_bnk_csm_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"add_bnk_cost_amt");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_20ft_ttl_qty");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_40ft_ttl_qty");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_20ft_ttl_amt");
// 			cellFontToBackColor(sheetObj, sRow, prefix+"ts_40ft_ttl_amt");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_qty");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_20ft_ttl_amt");
//			cellFontToBackColor(sheetObj, sRow, prefix+"tml_hndl_40ft_ttl_amt");
		}
		if(isGetColHidden){
			showFieldControl(sheetObj, formObj, false);
		}
	}
	
	/**
	 * Returning Index of Last Row except Total Row
	 * @param sheetObj
	 * @return
	 */
	function getTotalRowCnt(sheetObj){
		var totCnt=sheetObj.LastRow();
		if(sheetObj.id == "sheet2"){
			totCnt=sheetObj.LastRow()- 1;
		}
		return totCnt;
	}
	
	/**
	 * Judging P/F Date with dateFlg(ETA/ETB/ETD), Returning Column Name
	 * if P/F is Null, Returning InitDate
	 * 
	 * @param sheetObj
	 * @param dateFlg
	 * @return
	 */
	function getPfDateColName(sheetObj, Row, dateFlg){
		var prefix=sheetObj.id + "_";
		var pfDate="";
		var pfDtColNm="";
		if(dateFlg == "ETA"){
			pfDate=sheetObj.GetCellValue(Row, prefix+"pf_eta_dt");
			pfDtColNm=prefix+"pf_eta_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm=prefix+"init_eta_dt";
			}
		}else if(dateFlg == "ETB"){
			pfDate=sheetObj.GetCellValue(Row, prefix+"pf_etb_dt");
			pfDtColNm=prefix+"pf_etb_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm=prefix+"init_etb_dt";
			}
		}else if(dateFlg == "ETD"){
			pfDate=sheetObj.GetCellValue(Row, prefix+"pf_etd_dt");
			pfDtColNm=prefix+"pf_etd_dt";
			if(pfDate == null || pfDate == undefined || pfDate == ""){
				pfDtColNm=prefix+"init_etd_dt";
			}
		}
		return pfDtColNm;
	}
	
	/*
	 * =====================================================================
	 * Etc Function...
	 * =====================================================================
	 */
	/**
	 * in case Speed change, Calculating Bunker Q'ty and Amount
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param formObj
	 * @return
	 */
	function calcBunkerAdditionalCostBySpeed(sheetObj, Row, formObj){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		if(Row < sheetObj.LastRow()){
			var nextRow=getNotSkipRow(sheetObj, Row, "N");
			if(nextRow > 0){
				var preEtdDt=sheetObj.GetCellValue(Row, prefix+"vps_etd_dt");
				var nxtEtaDt=sheetObj.GetCellValue(nextRow, prefix+"vps_eta_dt");
				var dateObj=new Usr_CalcTimeSet(preEtdDt);
				var timeDiff=parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);
				var bnkUnitQty=sheetObj.GetCellValue(Row, prefix+"bnk_unit_qty");
				var bnkUnitAmt=sheetObj.GetCellValue(Row, prefix+"bnk_unit_amt");
				var bnkTotQty=Number(bnkUnitQty) * Number(timeDiff);
				var bnkTotAmt=Number(bnkTotQty) * Number(bnkUnitAmt);
				// after spd change, Calculating Unit Bunker
				formObj.spd.value=sheetObj.GetCellValue(Row, prefix+"lnk_spd");
				var bnkXml=doActionIBSheet(sheetObj, formObj ,SEARCH04);
				var addBnkUnitQty=ComGetEtcData(bnkXml, "bnk_unit_qty");
				var addBnkCsmQty=Number(addBnkUnitQty) * Number(timeDiff);
				var addBnkCostAmt=Number(addBnkCsmQty) * Number(bnkUnitAmt);
				sheetObj.SetCellValue(Row, prefix+"add_bnk_csm_qty",addBnkCsmQty - bnkTotQty,0);
				sheetObj.SetCellValue(Row, prefix+"add_bnk_cost_amt",addBnkCostAmt - bnkTotAmt,0);
				// Setting Bunker Info
				sheetObj.SetCellValue(Row, prefix+"bnk_unit_qty",addBnkUnitQty,0);
				sheetObj.SetCellValue(Row, prefix+"bnk_tot_qty",addBnkCsmQty,0);
				sheetObj.SetCellValue(Row, prefix+"bnk_tot_amt",addBnkCostAmt,0);
			}
		}
	}
	
	/**
	 * in case of Skip, Calculating Bunker Data of Port
	 * 
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function calcBunkerAdditionalCostBySkip(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
		var headCnt=sheetObj.HeaderRows();
		var prePortRow=getNotSkipRow(sheetObj, sRow, "P");
		var nxtPortRow=getNotSkipRow(sheetObj, sRow, "N");
		var preEtdDt=sheetObj.GetCellValue(prePortRow, prefix+"vps_etd_dt");
		var nxtEtaDt=sheetObj.GetCellValue(sRow, prefix+"vps_eta_dt");
		var dateObj=new Usr_CalcTimeSet(preEtdDt);
		var timeDiff=parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);
		var bnkUnitQty=sheetObj.GetCellValue(prePortRow, prefix+"bnk_unit_qty");
		var bnkUnitAmt=sheetObj.GetCellValue(prePortRow, prefix+"bnk_unit_amt");
		var bnkTotQty=Number(bnkUnitQty) * Number(timeDiff);
		var bnkTotAmt=Number(bnkTotQty) * Number(bnkUnitAmt);
		// current Bunker q'ty
		sheetObj.SetCellValue(prePortRow, prefix+"bnk_tot_qty",bnkTotQty,0);
		// current Bunker Cost
		sheetObj.SetCellValue(prePortRow, prefix+"bnk_tot_amt",bnkTotAmt,0);
		if(sRow < sheetObj.LastRow()){
			//Finding ETA, Calculating time difference
			nxtEtaDt=sheetObj.GetCellValue(nxtPortRow, prefix+"vps_eta_dt");
			timeDiff=parseInt(dateObj.getTimeDiff(nxtEtaDt), 10);
			var addBnkCsmQty=Number(bnkUnitQty) * Number(timeDiff);
			var addBnkCostAmt=Number(addBnkCsmQty) * Number(bnkUnitAmt);
			sheetObj.SetCellValue(prePortRow, prefix+"add_bnk_csm_qty",bnkTotQty - addBnkCsmQty,0);
			sheetObj.SetCellValue(prePortRow, prefix+"add_bnk_cost_amt",bnkTotAmt - addBnkCostAmt,0);
		}
	}
	
	/**
	 * Calculating Total Cost
	 * 
	 * @param sheetObj
	 * @return
	 */
	function calcTotalCost(sheetObj){
		if(sheetObj.id == "sheet2"){
			var prefix=sheetObj.id + "_";
			var headCnt=sheetObj.HeaderRows();
			var totCnt=getTotalRowCnt(sheetObj);
			for(var i=headCnt; i<=totCnt; i++){
				sheetObj.SetCellValue(i, prefix+"total_cost",Number(sheetObj.GetCellValue(i, prefix+"add_bnk_cost_amt"))+ Number(sheetObj.GetCellValue(i, prefix+"tml_hndl_20ft_ttl_amt"))
						+ Number(sheetObj.GetCellValue(i, prefix+"tml_hndl_40ft_ttl_amt"))
						+ Number(sheetObj.GetCellValue(i, prefix+"pe_usd_ttl_amt")));
			}
		}
	}
	
	/**
	 * ETA, ETB, ETD change, SKD Handling 
	 * lnk_dist
	 * lnk_spd
	 * tztm_hrs(sea_time)
	 * act_wrk_hrs(port_time)
	 * port_buf_hrs
	 * sea_buf_hrs
	 * mnvr_in_hrs
	 * mnvr_out_hrs
	 * --------------------------------------------------------------------------
	 * ETB = ETA + mnvr_in_hrs 
	 * ETD = ETB + act_wrk_hrs(port_time) + port_buf_hrs
	 * ETA = ETD(Pre) + mnvr_out_hrs + tztm_hrs(sea_time) + sea_buf_hrs + (GMT = B_GMT - A_GMT)
	 */
	function calcSchedule(sheetObj, Row, Col){
		
		var colName			= sheetObj.ColSaveName(Col);
		var prefix			= sheetObj.id + "_";
		var headerCount		= sheetObj.HeaderRows();
		var bodyCnt			= sheetObj.RowCount();
		var totCnt			= getTotalRowCnt(sheetObj);
		var skipCnt			= 0;
		var etaAddDate		= null;
		var etbAddDate		= null;
		var etdAddDate		= null;
		var etaDate			= null;
		var etbDate			= null;
		var etdDate			= null;
		var etaDelayTime	= 0;
		var etbDelayTime	= 0;
		var etdDelayTime	= 0;
		
		var seaTimeInclMnvrOutHrs	= 0.0;
		var	seaTimeExclMnvrOutHrs	= 0.0;
		
		var portTimeHrs				= 0.0;
		var isAdvanced				= false;
		
		//2007816-2007816//
		var consumeSeaBufferHrs		= 0;
		var consumePortBufferHrs	= 0;
		
		
		// C/SKD Update 시트인 경우 Expand 버튼에 의해 확장된 상태에서만 auto update가 된다.
		if(sheetObj.id == "sheet1" && sheetObj.GetColHidden(prefix+"lnk_dist")){
			return;
		}
		
		/**********************************************************************************
		 * ======================= ETA CHANGE EVENT =======================================
		 **********************************************************************************/
		if(colName == prefix+"vps_eta_dt"){
			
			// Coloring as current port ETA Delay/Advance	
			if(sheetObj.GetCellValue(Row, prefix+"vps_eta_dt") == sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETA"))){
 				sheetObj.SetCellFontColor(Row, prefix+"vps_eta_dt",glbNormalFontColor);
				isAdvanced			= true;			
			}else if(sheetObj.GetCellValue(Row, prefix+"vps_eta_dt") < sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETA"))){
 				sheetObj.SetCellFontColor(Row, prefix+"vps_eta_dt",glbAdvanceFontColor);
				isAdvanced			= true;
			}else{
 				sheetObj.SetCellFontColor(Row, prefix+"vps_eta_dt",glbDelayFontColor);
			}
			
			
			for(var i=Row; i<=totCnt; i++){
				//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
				//2015-09-30				
//				if(sheetObj.GetCellValue(i, prefix+"upd_sts") == "Actual"){
//					break;
//				}
				
				if(!sheetObj.GetRowHidden(i)){
					if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						
						if(i > Row){
							if(sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")=="0"){
								// Calculating ETA with pre ETD
								// ETA = ETD + MNVR_OUT_HRS + SEA TIME(PF_TZTM_HRS) + Time Diff(current port GMT - pre port GMT) + [TTL SEA_BUF_HRS]
								etdDate		= new Usr_CalcTimeSet(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
								seaTimeInclMnvrOutHrs	= Number(	controlMnvrHrs(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
																////+	Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
																+	Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"))
																+ 	(Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) 
																		-	
															        Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff"))
																);
								
								seaTimeExclMnvrOutTimeDiffHrs 	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"));
								
								///////////// Fkkkk by top temporary ////////////////////////////////////
								//seaTimeHrs	= seaTimeHrs - sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs");
								
								etdDelayTime	= getDelayTime(sheetObj, i-1-skipCnt, "ETD");
								
								//alert('sea calc ==> port pair <<'+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --- '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'>>> etdDelayTime ['+etdDelayTime+'],  sea_buf_hrs ['+Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60+']   seaTimeInclMnvrOutHrs <<< '+seaTimeInclMnvrOutHrs+' >>>');
								//alert('port pair *** '+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' - '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+' *** seaTimeInclMnvrOutHrs ==== [[[ '+seaTimeInclMnvrOutHrs+' ]]]  mnvr_out_hrs <<< '+Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs"))+' >>> pf_tztm_hrs <<< '+Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))+' >>> time_diff current ['+Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff"))+'] next ['+Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff"))+']');
								
								
								//::2015-04-01:by TOP:://
								//if(etdDelayTime == 0)	return;
								
								
								// [TTL SEA_BUF_HRS]
								//if(false){
								//	
								//}else 
								
								if(Number(etdDelayTime) <= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){
									
									var remainSeaBuffer	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - Number(etdDelayTime);
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf", remainSeaBuffer, 0);
									
									//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
									//::ETA CHANGE EVENT:SEA HOURS:://
									//if(etdDelayTime > 0){

									consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs")) - remainSeaBuffer/60;											
										
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs", remainSeaBuffer/60, 0);
										//seaTimeHrs				= seaTimeHrs - consumeSeaBufferHrs;
									
									//}
									///////////////////////////////////////////////////////////////////////
										
									////::2007816::seaTime				= seaTime*60 + remainSeaBuffer;
									//::2014-04-19:://sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
									
								}else{

									//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
									//::ETA CHANGE EVENT:SEA HOURS:://	
									consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"));		
									var remainSeaBuffer	= 0;
									
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf","0", 0);
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs","0", 0);
									///////////////////////////////////////////////////////////////////////
									
									//seaTime	= seaTime*60;
									//::2014-04-19:://sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
									
									//alert('port pair ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --> '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'] tztm_hrs ['+sheetObj.GetCellValue(i, prefix+"tztm_hrs")+'] consumeSeaBufferHrs ['+consumeSeaBufferHrs+']');
									
									
									//alert('finished set tztm_hrs');
								}
								
								
								/************************************************************************************
								 * Updating recalculating sea time to be applied consume sea buffer
								 * ----------------------------------------------------------------------------------
								 * 2015-08-28 by TOP 
								 */
								
								//alert('port pair ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --> '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'] tztm_hrs ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs")+'] consumeSeaBufferHrs ['+consumeSeaBufferHrs+']');
								
								//2015-08-28-temporary//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
								sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs")) - Number(consumeSeaBufferHrs), 0);
								/************************************************************************************/									

								
								//etaDate = etdDate.getAddDate(seaTimeInclMnvrOutHrs);
								//::2014-04-19:://etaDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true);
								etaDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true);
								
								//alert('port pair ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --> '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'] seaTime  ['+seaTimeInclMnvrOutHrs*60+'] org eta ['+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_eta_dt")+'] vs new eta ['+etaDate+'] consumeSeaBufferHrs ['+consumeSeaBufferHrs+'] isAdvanced ['+isAdvanced+'] pf eta ['+sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))+']');
								////alert('port pair ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --> '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'] seaTime  ['+seaTime+'] org eta ['+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_eta_dt")+'] vs new eta ['+etaDate+'] consumeSeaBufferHrs ['+consumeSeaBufferHrs+'] isAdvanced ['+isAdvanced+'] pf eta ['+sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))+']');
								
								//alert('port pair ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --> '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'] isAdvanced ['+isAdvanced+']');
								
								// Advanced or ETS<PF, then EST = PF
								if(isAdvanced || etaDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
									sheetObj.SetCellValue(i, prefix+"vps_eta_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")),0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbNormalFontColor);
									isAdvanced=true;
									var advancedTime	= getTimeBetweenByMins(sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")), etaDate);
									//sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs");
//									sheetObj.CellValue2(i-1-skipCnt, prefix+"tztm_hrs") = getAddedHoursByMin(sheetObj.CellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"), advancedTime, true);
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_eta_dt", etaDate, 0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbDelayFontColor);
 									
									// Auto Update, tztm_hrs = P/F value
 									////alert('tztm_hrs <<< '+sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs")+' >>>');
 									
 									//2015-08-28-temporary//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"),0);
 									
 									////alert('tztm_hrs <<< '+sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs")+' >>>');
								}
							}
						}
						
						
						if(sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")=="0"){
							
							// ETB = ETA + MNVR_IN_HRS
							etaDate	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"));
							//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
							etbDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.GetCellValue(i, prefix+"mnvr_in_hrs"))*60, true);
							
							if(i>Row){
								if(isAdvanced || etbDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.SetCellValue(i, prefix+"vps_etb_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB")),0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbNormalFontColor);
									isAdvanced=true;
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
								}
							}else{
								sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
								if(etbDate == sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbNormalFontColor);
									isAdvanced=true;
								}else if(etbDate < sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbAdvanceFontColor);
									isAdvanced=true;
								}else{
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
								}
							}
							
							// ETD = ETB + ACT_WRK_HRS + [Delayed PORT_BUF_HRS]
							etbDate			= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"));
//							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
							portTimeHrs		= Number(sheetObj.GetCellValue(i, prefix+"act_wrk_hrs"));
							
							etbDelayTime	= getDelayTime(sheetObj, i, "ETB");
							
							//alert('port calc ==> etbDelayTime ['+etbDelayTime+'],  port_buf_hrs ['+Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"))*60+']');
							
							// [Delayed PORT_BUF_HRS]
							if(etbDelayTime <= Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60){
								////portTime	= portTime*60 + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
								
								//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
								//::ETA CHANGE EVENT:PORT HOURS:://			
								var remainPortBuffer	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"))*60 - Number(etbDelayTime);
								sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf", remainPortBuffer, 0);

								//if(etbDelayTime > 0){

								consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs")) - remainPortBuffer/60;									
									
								sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs", remainPortBuffer/60, 0);
								
								//}
								
								//portTimeHrs	= portTimeHrs + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs")) - etbDelayTime/60;
								portTimeHrs	= portTimeHrs - etbDelayTime/60;
								///////////////////////////////////////////////////////////////////////
								
							}else{
								
								//portTime	= portTime*60;
								
								//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
								//::ETA CHANGE EVENT:PORT HOURS:://	
								consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"));
								var remainPortBuffer	= 0;
								
								sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf","0", remainPortBuffer);
								
								sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs","0",0);
								///////////////////////////////////////////////////////////////////////						
							}
							
							
							/************************************************************************************
							 * Updating recalculating port time to be applied consume port buffer
							 * ----------------------------------------------------------------------------------
							 * 2015-08-29 by TOP 
							 */
							sheetObj.SetCellValue(i-skipCnt, prefix+"act_wrk_hrs", Number(sheetObj.GetCellValue(i-skipCnt, prefix+"act_wrk_hrs")) - Number(consumePortBufferHrs), 0);
							/************************************************************************************/
							
							
//							etdDate = etbDate.getAddDate(portTime);
							////etdDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"), portTime, true);
							etdDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"), portTimeHrs*60+remainPortBuffer, true);
							
							//alert('eta event >>> etdDate ['+etdDate+']  portTime ['+portTime+'] consumePortBufferHrs ['+consumePortBufferHrs+']');
							
							if(i>Row){
								
								//:2015-08-31:by TOP:://if(isAdvanced || etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
								if(etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
											
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt", sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD")),0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbNormalFontColor);
									isAdvanced=true;
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
								}
							}else{
								sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
								if(etdDate == sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbNormalFontColor);
									isAdvanced=true;
								}else if(etdDate < sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									//:2015-08-31:by TOP:://sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbAdvanceFontColor);
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbNormalFontColor);
									isAdvanced=true;
								}else{
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbDelayFontColor);
								}
							}
						}
						// TOTAL Delay는 VPS_ETD와 PF_ETD간의 Delay
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						skipCnt=0;
					}
				}
			}
			

		/**********************************************************************************
		 * ======================= ETB CHANGE EVENT =======================================
		 **********************************************************************************/
		}else if(colName == prefix+"vps_etb_dt"){
			
			// Refer to vps_eta_dt
			if(gIsDistOrSpdChange){
				null;
			}else{
				if(sheetObj.GetCellValue(Row, prefix+"vps_etb_dt") == sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETB"))){
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etb_dt",glbNormalFontColor);
					isAdvanced=true;
				}else if(sheetObj.GetCellValue(Row, prefix+"vps_etb_dt") < sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETB"))){
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etb_dt",glbAdvanceFontColor);
					isAdvanced=true;
				}else{
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etb_dt",glbDelayFontColor);
				}
			}
			
			for(var i=Row; i<=totCnt; i++){
				//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
				//2015-09-30
//				if(sheetObj.GetCellValue(i, prefix+"upd_sts") == "Actual"){
//					break;
//				}
				
				if(!sheetObj.GetRowHidden(i) && sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")=="0"){
					if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						if(i > Row){
							if(sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")=="0"){
								// ETA
								etdDate	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
								seaTimeInclMnvrOutHrs	= Number(controlMnvrHrs(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
														////+	Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
														+	Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"))
														+ (Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) 
														   - Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff")));
								
								seaTimeExclMnvrOutTimeDiffHrs 	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"));
								
								etdDelayTime	= getDelayTime(sheetObj, i-1-skipCnt, "ETD");
								
								//::2015-04-01:by TOP:://
								//if(etdDelayTime == 0)	return;
								
								if(etdDelayTime <= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){

									////::2007816:://seaTime=seaTime*60 + Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - etdDelayTime;
									
									//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
									//::ETB CHANGE EVENT:SEA HOURS:://									
									var remainSeaBuffer	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - Number(etdDelayTime);
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf",remainSeaBuffer,0);
									
									//if(etdDelayTime > 0){
										
									consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs")) - remainSeaBuffer/60;
										
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs", remainSeaBuffer/60, 0);
										//seaTimeHrs				= seaTimeHrs - consumeSeaBufferHrs;
									//}
									///////////////////////////////////////////////////////////////////////
										
								}else{
									
									
									//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
									//::ETB CHANGE EVENT:SEA HOURS:://	
									consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"));		
									var remainSeaBuffer	= 0;
									
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf","0", remainSeaBuffer);
									
									sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs","0", 0);
									///////////////////////////////////////////////////////////////////////
									
									//seaTime	= seaTime*60;
									//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeHrs, 0);										
									
								}
								
								
								/************************************************************************************
								 * Updating recalculating sea time to be applied consume sea buffer
								 * ----------------------------------------------------------------------------------
								 * 2015-08-28 by TOP 
								 */
								//2015-08-28-temporary//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
								sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs")) - Number(consumeSeaBufferHrs), 0);
								/************************************************************************************/								
								
								
								//etaDate = etdDate.getAddDate(seaTime);
								etaDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true);
								
								if(isAdvanced || etaDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
									sheetObj.SetCellValue(i, prefix+"vps_eta_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")),0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbNormalFontColor);
									isAdvanced=true;
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_eta_dt",etaDate,0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_eta_dt",glbDelayFontColor);
								}

								// ETB
								etaDate=new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"));
								//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
								etbDate=VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.GetCellValue(i, prefix+"mnvr_in_hrs"))*60, true);
								
								if(isAdvanced || etbDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
									sheetObj.SetCellValue(i, prefix+"vps_etb_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB")),0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbNormalFontColor);
									isAdvanced=true;
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
								}
							}
						}
						
						
						if(sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")=="0"){
							
							etbDate		= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"));
//							portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
							portTimeHrs	= Number(sheetObj.GetCellValue(i, prefix+"act_wrk_hrs"));
							
							etbDelayTime	= getDelayTime(sheetObj, i, "ETB"); 
							
							if(etbDelayTime <= Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60){
								
								////portTime=portTime*60 + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
								
								//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
								//::ETB CHANGE EVENT:PORT HOURS:://								
								var remainPortBuffer	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"))*60 - Number(etbDelayTime);
								sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf", remainPortBuffer, 0);

								//if(etbDelayTime > 0){
									
									consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs")) - remainPortBuffer/60;
									
									sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs", remainPortBuffer/60, 0);
								//}
								///////////////////////////////////////////////////////////////////////
								
								//portTimeHrs	= portTimeHrs + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs")) - etbDelayTime/60;
								portTimeHrs	= portTimeHrs - etbDelayTime/60;
								
							}else{
								//portTime=portTime*60;
								
								//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
								//::ETB CHANGE EVENT:PORT HOURS:://			
								consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"));
								var remainPortBuffer	= 0;
								
								sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf","0", remainPortBuffer);
								sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs","0", 0);
								///////////////////////////////////////////////////////////////////////	
								
							}
							
							
							/************************************************************************************
							 * Updating recalculating port time to be applied consume port buffer
							 * ----------------------------------------------------------------------------------
							 * 2015-08-29 by TOP 
							 */
							sheetObj.SetCellValue(i-skipCnt, prefix+"act_wrk_hrs", Number(sheetObj.GetCellValue(i-skipCnt, prefix+"act_wrk_hrs")) - Number(consumePortBufferHrs), 0);
							/************************************************************************************/								
							
							
//							etdDate = etbDate.getAddDate(portTime);
							
							//alert('sea calc ==> port pair <<'+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+' --- '+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+'>>> etbDelayTime ['+etbDelayTime+'],  portTimeHrs ['+portTimeHrs+'] remainPortBuffer ['+remainPortBuffer+']');
							
							etdDate = VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"), portTimeHrs*60+remainPortBuffer, true);
							
							if(i>Row){
								if(isAdvanced || etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD")),0);
									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbNormalFontColor);
									isAdvanced=true;
								}else{
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
								}
							}else{
								sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
								if(etdDate == sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbNormalFontColor);
									isAdvanced=true;
								}else if(etdDate < sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
									//:2015-08-31:by TOP:://sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbAdvanceFontColor);
									sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbNormalFontColor);
									isAdvanced=true;
								}else{
 									sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
								}
							}
						}
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						skipCnt=0;
					}
				}
			}
			
		/**********************************************************************************
		 * ======================= ETD CHANGE EVENT =======================================
		 **********************************************************************************/			
		}else{
			
			// Refer to vps_eta_dt
			if(!gIsDistOrSpdChange){
				if(sheetObj.GetCellValue(Row, prefix+"vps_etd_dt") == sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETD"))){
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etd_dt",glbNormalFontColor);
					isAdvanced=true;
				}else if(sheetObj.GetCellValue(Row, prefix+"vps_etd_dt") < sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, "ETD"))){
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etd_dt",glbAdvanceFontColor);
					isAdvanced=true;
				}else{
	 				sheetObj.SetCellFontColor(Row, prefix+"vps_etd_dt",glbDelayFontColor);
				}
			}
			
			setDelayTime(sheetObj, Row, prefix+"vps_etd_dt", getPfDateColName(sheetObj, Row, "ETD"));
			
			////2007816for(var i=Row+1; i<=totCnt; i++){
			for(var i=Row+1; i<=totCnt; i++){
				//Actual SKD 생성 Port 이전의 Ports에 대해 수정허용  RollBack
				//2015-09-30				
//				if(sheetObj.GetCellValue(i, prefix+"upd_sts") == "Actual"){
//					break;
//				}
					
				/************** ::2015-04-27:by TOP:: ***********
				 * When it is advance, stop to calculate 
				 * **/
				//if(isAdvanced == true || etdDelayTime <= 0)	return false;	
				//alert(' isAdvanced  ['+isAdvanced == true+']');
				
				//alert('i >>> ['+i+'] port ['+sheetObj.GetCellValue(i, prefix+"vps_port_cd")+'] Not GetRowHidden ['+!sheetObj.GetRowHidden(i)+']   auto_skd_cng_flg ['+sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg")+']');
				
				if(!sheetObj.GetRowHidden(i) && sheetObj.GetCellValue(i, prefix+"auto_skd_cng_flg") == "0"){
			
					if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S"){
						skipCnt++;
					}else{
						// ETA
						etdDate	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"));
						
						//::FOR.NYK.START::by dongsoo:2014-09-18:://

						//org_seaTime = Number(controlMnvrHrs(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
		        		//			+ Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
		        		//			+ (Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff")));

						pfSeaTimeInclMnvrOutHrs 	= Number(controlMnvrHrs(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
        											+ Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"pf_tztm_hrs"))
        											+ (Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff")));	

						cstSeaTimeInclMnvrOutHrs 	= Number(controlMnvrHrs(sheetObj.GetCellValue(i-1-skipCnt, prefix+"mnvr_out_hrs")))
													+ Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"))
													+ (Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff")));	
						
						if(isAdvanced){
							seaTimeInclMnvrOutHrs	= pfSeaTimeInclMnvrOutHrs; 
						}else{
							seaTimeInclMnvrOutHrs	= cstSeaTimeInclMnvrOutHrs;
						}
						
						seaTimeExclMnvrOutTimeDiffHrs 	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs"));
												//+ (Number(sheetObj.GetCellValue(i-skipCnt, prefix+"time_diff")) - Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"time_diff")));							
					    //::FOR.NYK.FINISH::by dongso:2014-09-18:://
						
						etdDelayTime	= getDelayTime(sheetObj, i-1-skipCnt, "ETD");
						
						//::2015-04-01:by TOP::When entering 'sea buffer', block for escaping this event.//
						//alert('etdDelayTime ['+etdDelayTime+']');
						//if(etdDelayTime <= 30 && i != Row+1)	return;
						
						//alert('isAdvanced <<< '+isAdvanced+' >>> :: etd event >>> port ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+'] etdDelayTime ['+etdDelayTime+']  sea_buf_hrs ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs")+']');
						
						
						if(etdDelayTime <= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60){
							////::2007816:://seaTime=seaTime*60 + Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - etdDelayTime;
							
							//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
							//::ETD CHANGE EVENT:SEA HOURS:://									
							var remainSeaBuffer	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"))*60 - Number(etdDelayTime);
							sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf", remainSeaBuffer,0);							
							
							//if(etdDelayTime > 0){
								
								consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs")) - remainSeaBuffer/60;
								
								sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs", remainSeaBuffer/60, 0);
								//seaTimeHrs				= seaTime - consumeSeaBufferHrs + Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"));
								
							//}
							///////////////////////////////////////////////////////////////////////
								
						}else{
							
							//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
							//::ETD CHANGE EVENT:SEA HOURS:://
							
							
							consumeSeaBufferHrs	= Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs"));									
							var remainSeaBuffer	= 0;
							
							sheetObj.SetCellValue(i-1-skipCnt, prefix+"rmn_sea_buf", "0", remainSeaBuffer);
							
							sheetObj.SetCellValue(i-1-skipCnt, prefix+"sea_buf_hrs", "0", 0);
							///////////////////////////////////////////////////////////////////////
							
							//seaTime	= seaTime*60;
							//::2015-04-19:://sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);			
							//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
							
						}
						
						
						/************************************************************************************
						 * Updating recalculating sea time to be applied consume sea buffer
						 * ----------------------------------------------------------------------------------
						 * 2015-08-28 by TOP 
						 */
						//2015-08-28-temporary//sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", seaTimeInclMnvrOutHrs, 0);
						sheetObj.SetCellValue(i-1-skipCnt, prefix+"tztm_hrs", Number(sheetObj.GetCellValue(i-1-skipCnt, prefix+"tztm_hrs")) - Number(consumeSeaBufferHrs), 0);
						/************************************************************************************/							
						
						
//						etaDate = etdDate.getAddDate(seaTime);
						//alert( seaTime );
						//alert( "GetCellValue==" +sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt") );
						
						//alert('advance exe result <<< '+VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true) > sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))+' >>>');
						//alert('port ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_port_cd")+'] vps_etd_dt ['+sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt")+'] seaTimeInclMnvrOutHrs ['+seaTimeInclMnvrOutHrs+'] remainSeaBuffer ['+remainSeaBuffer+'] consumeSeaBufferHrs ['+consumeSeaBufferHrs+']  remainSeaBuffer ['+remainSeaBuffer+']');
						
						//kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
						//etaDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true);
						etaDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i-1-skipCnt, prefix+"vps_etd_dt"), seaTimeInclMnvrOutHrs*60+remainSeaBuffer, true);
						
						//alert('isAdvanced <<< '+isAdvanced+' >>> port ['+sheetObj.GetCellValue(i-skipCnt, prefix+"vps_port_cd")+']    after eta [['+etaDate+']] etdDelayTime ['+etdDelayTime+'] vs pf eta ['+sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))+']');
						
						/**************************************************************************************
						 * Adjusting modified ETA calculation logic for wroing inputted ETA/B/D on connecting
						 * ====================================================================================
						 * by TOP :: 2015-05-11
						 * ------------------------------------------------------------------------------------
						 * 1. When it's advanced status, there are only normal ETA/B/D even if there exists mis connecting data.
						 * 2. Same logic with original
						 */
						if(isAdvanced){
							sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")), 0);
 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbNormalFontColor);
						}else{
							
							if(etaDate > sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
								sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", etaDate, 0);
	 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbDelayFontColor);							
							}else if(isAdvanced || etaDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
								sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")), 0);
	 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbNormalFontColor);
								isAdvanced=true;
							}else{
								sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", etaDate, 0);
	 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbDelayFontColor);
							}	
							
						}
						/**************************************************************************************/
						
//::2007816::=======================================================================================================================================						
//						if(isAdvanced || etaDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA"))){
//							sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETA")), 0);
// 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbNormalFontColor);
//							isAdvanced=true;
//						}else{
//							sheetObj.SetCellValue		(i, prefix+"vps_eta_dt", etaDate, 0);
// 							sheetObj.SetCellFontColor	(i, prefix+"vps_eta_dt", glbDelayFontColor);
//						}
//::2007816::=======================================================================================================================================
						
						// ETB
						etaDate = new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"));
						//etbDate = etaDate.getAddDate(controlMnvrHrs(sheetObj.CellValue(i, prefix+"mnvr_in_hrs")));
						etbDate = VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_eta_dt"), controlMnvrHrs(sheetObj.GetCellValue(i, prefix+"mnvr_in_hrs"))*60, true);
						
						if(etbDate > sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
							sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
 							sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);							
						}else if(isAdvanced || etbDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
							sheetObj.SetCellValue(i, prefix+"vps_etb_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB")),0);
 							sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbNormalFontColor);
							isAdvanced=true;
						}else{
							sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
 							sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
						}
						
//::2007816::=======================================================================================================================================							
//						if(isAdvanced || etbDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB"))){
//							sheetObj.SetCellValue(i, prefix+"vps_etb_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETB")),0);
// 							sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbNormalFontColor);
//							isAdvanced=true;
//						}else{
//							sheetObj.SetCellValue(i, prefix+"vps_etb_dt",etbDate,0);
// 							sheetObj.SetCellFontColor(i, prefix+"vps_etb_dt",glbDelayFontColor);
//						}
//::2007816::=======================================================================================================================================	
						
						// ETD
						etbDate	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"));
//						portTime = Number(sheetObj.CellValue(i, prefix+"act_wrk_hrs")) + Number(sheetObj.CellValue(i, prefix+"port_buf_hrs"));
						
						portTimeHrs	= Number(sheetObj.GetCellValue(i, prefix+"act_wrk_hrs"));
						etbDelayTime=getDelayTime(sheetObj, i, "ETB"); 
						
						if(etbDelayTime <= Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60){
						
							////portTime=portTime*60 + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs"))*60 - etbDelayTime;
							
							//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
							//::ETD CHANGE EVENT:PORT HOURS:://								
							var remainPortBuffer	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"))*60 - Number(etbDelayTime);
							sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf",remainPortBuffer,0);

							//if(etbDelayTime > 0){
								
								consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs")) - remainPortBuffer/60;
								
								sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs", remainPortBuffer/60, 0);
							//}
							///////////////////////////////////////////////////////////////////////	
							
							//portTimeHrs	= portTimeHrs + Number(sheetObj.GetCellValue(i, prefix+"port_buf_hrs")) - etbDelayTime/60;
							
						}else{
							//portTime=portTime*60;
							
							//::2015-03-29:by TOP:AddingCalculationLogicForDeductingBufferHours:://
							//::ETD CHANGE EVENT:PORT HOURS:://								
							consumePortBufferHrs	= Number(sheetObj.GetCellValue(i-skipCnt, prefix+"port_buf_hrs"));
							var remainPortBuffer	= 0;
							
							sheetObj.SetCellValue(i-skipCnt, prefix+"rmn_port_buf", "0", remainPortBuffer);
							sheetObj.SetCellValue(i-skipCnt, prefix+"port_buf_hrs", "0", 0);
							///////////////////////////////////////////////////////////////////////
							
						}
						
						
						/************************************************************************************
						 * Updating recalculating port time to be applied consume port buffer
						 * ----------------------------------------------------------------------------------
						 * 2015-08-29 by TOP 
						 */
						sheetObj.SetCellValue(i-skipCnt, prefix+"act_wrk_hrs", Number(sheetObj.GetCellValue(i-skipCnt, prefix+"act_wrk_hrs")) - Number(consumePortBufferHrs), 0);
						/************************************************************************************/							
						
						
//						etdDate = etbDate.getAddDate(portTime);
						etdDate	= VskGetAddedTimeByMin(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"), portTimeHrs*60+remainPortBuffer, true);
						
						//alert('etdDate  ['+etdDate+']    portTime ['+portTime+']');
						
						if(etdDate > sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
							sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
 							sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);							
 						
 						//:2015-08-31:by TOP:://}else if(isAdvanced || etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
						}else if(etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
							//:2015-08-31:by TOP:://sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbAdvanceFontColor);
							sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
							sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt", glbNormalFontColor);
							isAdvanced=true;
						}else{
							sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
 							sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
						}
						
//::2007816::=======================================================================================================================================						
//						if(isAdvanced || etdDate <= sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD"))){
//							sheetObj.SetCellValue(i, prefix+"vps_etd_dt",sheetObj.GetCellValue(i, getPfDateColName(sheetObj, i, "ETD")),0);
// 							sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbNormalFontColor);
//							isAdvanced=true;
//						}else{
//							sheetObj.SetCellValue(i, prefix+"vps_etd_dt",etdDate,0);
// 							sheetObj.SetCellFontColor(i, prefix+"vps_etd_dt",glbDelayFontColor);
//						}						
//::2007816::=======================================================================================================================================
						
						
						setDelayTime(sheetObj, i, prefix+"vps_etd_dt", getPfDateColName(sheetObj, i, "ETD"));
						skipCnt=0;
					}
				}
			}
		}
		
		var targetRows=new Array();
		for(var Row=sheetObj.HeaderRows(); Row<=sheetObj.LastRow(); Row++){
			if(!sheetObj.GetRowHidden(Row) &&
				sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") != "S"){
				targetRows.push(Row);
			}
		}
		for(var i=0; i<targetRows.length; i++){
			if(i==0) continue;
			if(getSeaDlayTime(sheetObj, targetRows[i]) >= gSkdBuffTimeCode){
				sheetObj.SetCellValue(targetRows[i], prefix+"sea_date_text",calcSeaDlayTime(sheetObj, targetRows[i]),0);
			}else{
				sheetObj.SetCellValue(targetRows[i], prefix+"sea_date_text","",0);
			}
			if(sheetObj.GetCellValue(targetRows[i], prefix+"sea_date_text") == ""){
				sheetObj.SetCellValue(targetRows[i], prefix+"vsl_dlay_rsn_cd","",0);
				sheetObj.SetCellValue(targetRows[i], prefix+"vsl_dlay_rsn_desc","",0);
				sheetObj.SetCellBackColor(targetRows[i], prefix+"vsl_dlay_rsn_cd",sheetObj.GetCellBackColor(targetRows[i], prefix+"sea_date_text"));
			}
		}
	}

	
	function pickPfData(sheetObj){
		var prefix=sheetObj.id + "_";
		var headerCnt=sheetObj.HeaderRows();
		var bodyCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		for(var Row=headerCnt; Row<=totCnt; Row++){
			if(sheetObj.GetCellValue(Row, prefix+"tztm_hrs")!=sheetObj.GetCellValue(Row, prefix+"tmp_tztm_hrs")){
				sheetObj.SetCellValue(Row, prefix+"tztm_hrs",sheetObj.GetCellValue(Row, prefix+"tmp_tztm_hrs"),0);
			}
			if(sheetObj.GetCellValue(Row, prefix+"lnk_spd")!=sheetObj.GetCellValue(Row, prefix+"tmp_lnk_spd")){
				sheetObj.SetCellValue(Row, prefix+"lnk_spd",sheetObj.GetCellValue(Row, prefix+"tmp_lnk_spd"),0);
			}
			if(sheetObj.GetCellValue(Row, prefix+"act_wrk_hrs")!=sheetObj.GetCellValue(Row, prefix+"tmp_act_wrk_hrs")){
				sheetObj.SetCellValue(Row, prefix+"act_wrk_hrs",sheetObj.GetCellValue(Row, prefix+"tmp_act_wrk_hrs"),0);
			}
		}
	}
	/**
	 * Calculating PF SKD Data 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function calcPfData(sheetObj, Row, Col){
		var colName		= sheetObj.ColSaveName(Col);
		var prefix		= sheetObj.id + "_";
		var haederCnt	= sheetObj.HeaderRows();
		var bodyCnt		= sheetObj.RowCount();
		var totCnt		= getTotalRowCnt(sheetObj);
		var skipCnt		= 0;
		
		////var seaSpd		= 0.0;
		////var portTime	= 0.0;
		
		var seaSpd		= 0;
		var portTime	= 0;
		
		var etbObj;
		var etdObj;
		
		for(var i=Row; i<totCnt; i++){
			if(!sheetObj.GetRowHidden(i)){
				etbObj	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etb_dt"));
				etdObj	= new Usr_CalcTimeSet(sheetObj.GetCellValue(i, prefix+"vps_etd_dt"));
				
				if(i<totCnt){
					if(sheetObj.GetCellValue(i, prefix+"tztm_hrs") != 0 && sheetObj.GetCellValue(i, prefix+"tztm_hrs") != "" && sheetObj.GetCellValue(i, prefix+"tztm_hrs") != null && sheetObj.GetCellValue(i, prefix+"tztm_hrs") != undefined){
						seaSpd	= Number(sheetObj.GetCellValue(i, prefix+"lnk_dist")) / sheetObj.GetCellValue(i, prefix+"tztm_hrs");
					}else{
						seaSpd	= 0;
					}	
					
					////seaSpd=Math.floor(seaSpd*10)/10;
					////sheetObj.SetCellValue(i, prefix+"lnk_spd",seaSpd,0);
					
					////////////////// by top seaSpd	= Math.floor(seaSpd*10)/10;
					//seaSpd	= Math.floor(seaSpd);
					seaSpd	= Math.round(seaSpd);
					
					//alert('before number [ '+ Number(seaSpd)+' ] math.floor [ '+Math.floor(seaSpd)+' ]');
					
					sheetObj.SetCellValue(i, prefix+"lnk_spd", seaSpd, 0);
				}
				// PORT TIME = current ETD - ETB
				portTime	= Number(etbObj.getTimeDiff(sheetObj.GetCellValue(i, prefix+"vps_etd_dt")))
				portTime	= Math.floor(portTime*10)/10;
				sheetObj.SetCellValue(i, prefix+"tmp_act_wrk_hrs",portTime,0);
			}
		}
	}
	/**
	 * Calculating Sea Dlay Time, and Returning
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function calcSeaDlayTime(sheetObj, sRow){
		var prefix		= sheetObj.id + "_";
		var hourDiff	= getSeaDlayTime(sheetObj, sRow);
		
		if(hourDiff == ""){
			return "";
		}
		var timeDiff	= "";
		
		//alert('hourDiff ['+hourDiff+']  vs gSkdBuffTimeCode ['+gSkdBuffTimeCode+']');
		
		if(hourDiff >= gSkdBuffTimeCode){
			timeDiff	= ComLpad(parseInt(hourDiff / 24, 10), 2, "0") + "D-" + ComLpad(Math.round(hourDiff % 24), 2, "0") + "H";
			
    		// Delay Reason starts from 2nd Row
    		if(sRow > sheetObj.HeaderRows()){
    			if(sheetObj.GetCellValue(sRow, prefix+"bfr_act_flg") != "X" && sheetObj.GetCellValue(sRow, prefix+"port_skd_sts_cd") != "D"){
    				sheetObj.SetCellBackColor(sRow, prefix+"vsl_dlay_rsn_cd", glbEditColor);
    			}
    		}
		}else{
			sheetObj.SetCellValue(sRow, prefix+"vsl_dlay_rsn_cd"  ,"",0);
			sheetObj.SetCellValue(sRow, prefix+"vsl_dlay_rsn_desc","",0);
//    		sheetObj.CellBackColor(sRow, prefix+"vsl_dlay_rsn_cd") = sheetObj.CellBackColor(sRow, "#FFFFFF";
		}
		return timeDiff;
	}
	/**
	 * Calculating Sea Delay Time between pre port ETD and current port ETA
	 * 
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function getSeaDlayTime(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
		var haedCnt=sheetObj.HeaderRows();
		var rowCnt=sheetObj.RowCount();
		var totCnt=getTotalRowCnt(sheetObj);
		var pRow="0";
		if(sRow > haedCnt){
			for(var i=sRow-1; i>=haedCnt; i--){
				if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
					pRow=i;
					break;
				}
			}
		}else{
			return "";
		}
		var vpsEtd=sheetObj.GetCellValue(pRow, prefix+"vps_etd_dt");
		var vpsEta=sheetObj.GetCellValue(sRow, prefix+"vps_eta_dt");
		var vpsEtdObj=new Usr_CalcTimeSet(vpsEtd);
		var pfEtd=sheetObj.GetCellValue(pRow, getPfDateColName(sheetObj, pRow, "ETD"));
		var pfEta=sheetObj.GetCellValue(sRow, getPfDateColName(sheetObj, sRow, "ETA"));
		if(pfEta == "" || pfEtd == ""){
			return "";
		}
		// VPS_ETA > PF_ETA
		var vpsEtaObj=new Usr_CalcTimeSet(vpsEta);
		if(vpsEtaObj.getTimeDiff(pfEta)>=0){
			return "";
		}
		var pfEtdObj=new Usr_CalcTimeSet(pfEtd);
		var vpsDiff=vpsEtdObj.getTimeDiff(vpsEta);
		var pfDiff=pfEtdObj.getTimeDiff(pfEta);
		var hourDiff=Number(vpsDiff) - Math.abs(Number(pfDiff));
		return hourDiff;
	}
	/**
	 * DataSet for Calculating
	 * @param sDate
	 * @return
	 */
	function Usr_CalcTimeSet(sDate){
		this.date=getDateObj(sDate);
		this.year=this.date.getFullYear();
		this.month=this.date.getMonth() + 1;
		this.day=this.date.getDate();
		this.hour=this.date.getHours();
		this.min=this.date.getMinutes();
	}
	/**
	 * Returning inputed date + sTime
	 * 
	 * @param sTime
	 */
	Usr_CalcTimeSet.prototype.getAddDate=function(sTime){
		if(sTime == null || sTime == undefined || sTime == "") sTime=0;
// 		if(sTime < 0) sTime = sTime * (-1);
		var rtnDate=null;
		var totMin=this.min + Math.round((Number(sTime)%1) * 60);
		var tMin=totMin%60;				// shown
		if(tMin < 30){
			tMin=0;
		} else if(tMin > 30) {
			tMin=0;
			totMin=totMin + 30;
		}
//		var hMin = Usr_Trunc(totMin/60);
		var hMin=parseInt(totMin/60, 10);
// 		var totHour = this.hour + hMin + Usr_Trunc(sTime);
		var totHour=this.hour + hMin + parseInt(sTime, 10);
		var tHour=totHour%24;
// 		var dHour = Usr_Trunc(totHour/24);
		var dHour=parseInt(totHour/24, 10);
		var tDate=this.year +""+ ComLpad(this.month,2,"0") +""+ ComLpad(this.day,2,"0");
// 		rtnDate = tDate;
		if(dHour < 1){
			rtnDate=tDate + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0"); 
		}else{
			rtnDate=ComGetDateAdd(tDate, "D", dHour, "") + "" + ComLpad(tHour,2,"0") + "" + ComLpad(tMin,2,"0");
		}
		return rtnDate;
	}
	/**
	 * Calculating Time difference between inputed date and sDate, Returning
	 * @param sDate
	 */
	Usr_CalcTimeSet.prototype.getTimeDiff=function(sDate){
		var toDate=getDateObj(sDate);
		var hour=1000 * 3600; // 1Hour
// 		return parseInt((toDate - this.date) / hour, 10);
		return (toDate - this.date) / hour;
	}
	function Usr_Coni_FormData(){
		this.vslCd="";
		this.skdVoyNo="";
		this.skdDirCd="";
		this.simDt="";
		this.simNo="";
		this.creDt="";
		this.creUsrId="";
		this.vslSlanCd="";
		this.bound="3";
		this.updDt="";
		this.updUsrId="";
		this.skdRmk="";
	}
	//Usr_Coni_FormData.Getter()
	Usr_Coni_FormData.prototype.getVslCd=function(){
		return this.vslCd;
	}
	Usr_Coni_FormData.prototype.getSkdVoyNo=function(){
		return this.skdVoyNo;
	}
	Usr_Coni_FormData.prototype.getSkdDirCd=function(){
		return this.skdDirCd;
	}
	Usr_Coni_FormData.prototype.getSimDt=function(){
		return this.simDt;
	}
	Usr_Coni_FormData.prototype.getSimNo=function(){
		return this.simNo;
	}
	Usr_Coni_FormData.prototype.getCreDt=function(){
		return this.creDt;
	}
	Usr_Coni_FormData.prototype.getCreUsrId=function(){
		return this.creUsrId;
	}
	Usr_Coni_FormData.prototype.getVslSlanCd=function(){
		return this.vslSlanCd;
	}
	Usr_Coni_FormData.prototype.getBound=function(){
		return this.bound;
	}
	Usr_Coni_FormData.prototype.getUpdDt=function(){
		return this.updDt;
	}
	Usr_Coni_FormData.prototype.getUpdUsrId=function(){
		return this.updUsrId;
	}
	Usr_Coni_FormData.prototype.getSkdRmk=function(){
		return this.skdRmk;
	}
	//Usr_Coni_FormData.Setter()
	Usr_Coni_FormData.prototype.setVslCd=function(sVslCd){
		this.vslCd=sVslCd;
	}
	Usr_Coni_FormData.prototype.setSkdVoyNo=function(sSkdVoyNo){
		this.skdVoyNo=sSkdVoyNo;
	}
	Usr_Coni_FormData.prototype.setSkdDirCd=function(sSkdDirCd){
		this.skdDirCd=sSkdDirCd;
	}
	Usr_Coni_FormData.prototype.setSimDt=function(sSimDt){
		this.simDt=sSimDt;
	}
	Usr_Coni_FormData.prototype.setSimNo=function(sSimNo){
		this.simNo=sSimNo;
	}
	Usr_Coni_FormData.prototype.setCreDt=function(sCreDt){
		this.creDt=sCreDt;
	}
	Usr_Coni_FormData.prototype.setCreUsrId=function(sCreUsrId){
		this.creUsrId=sCreUsrId;
	}
	Usr_Coni_FormData.prototype.setVslSlanCd=function(sVslSlanCd){
		this.vslSlanCd=sVslSlanCd;
	}
	Usr_Coni_FormData.prototype.setBound=function(sBound){
		this.bound=sBound;
	}
	Usr_Coni_FormData.prototype.setUpdDt=function(sUpdDt){
		this.updDt=sUpdDt;
	}
	Usr_Coni_FormData.prototype.setUpdUsrId=function(sUpdUsrId){
		this.updUsrId=sUpdUsrId;
	}
	Usr_Coni_FormData.prototype.setSkdRmk=function(sSkdRmk){
		this.skdRmk=sSkdRmk;
	}
	Usr_Coni_FormData.prototype.setAllFormData=function(){
		var formObj=document.form;
		formObj.vsl_cd.value=this.getVslCd();
		formObj.skd_voy_no.value=this.getSkdVoyNo();
		formObj.skd_dir_cd.value=this.getSkdDirCd();
		//formObj.sim_dt.value=this.getSimDt();
		//formObj.sim_no.value=this.getSimNo();
		formObj.cre_dt.value=this.getCreDt();
		formObj.cre_usr_id.value=this.getCreUsrId();
		formObj.vsl_slan_cd.value=this.getVslSlanCd();
		formObj.bound.value=this.getBound();
		formObj.upd_dt.value=this.getUpdDt();
		formObj.upd_usr_id.value=this.getUpdUsrId();
		formObj.skd_rmk.value=this.getSkdRmk();
	}
	function Usr_setVslCd(sVslCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setVslCd(sVslCd);
    	}else{
    		glbSheet2FormData.setVslCd(sVslCd);
    	}
	}
	function Usr_setSkdVoyNo(sSkdVoyNo){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdVoyNo(sSkdVoyNo);
    	}else{
    		glbSheet2FormData.setSkdVoyNo(sSkdVoyNo);
    	}
	}
	function Usr_setSkdDirCd(sSkdDirCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdDirCd(sSkdDirCd);
    	}else{
    		glbSheet2FormData.setSkdDirCd(sSkdDirCd);
    	}
	}
	function Usr_setSimDt(sSimDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSimDt(sSimDt);
    	}else{
    		glbSheet2FormData.setSimDt(sSimDt);
    	}
	}
	function Usr_setSimNo(sSimNo){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSimNo(sSimNo);
    	}else{
    		glbSheet2FormData.setSimNo(sSimNo);
    	}
	}
	function Usr_setCreDt(sCreDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setCreDt(sCreDt);
    	}else{
    		glbSheet2FormData.setCreDt(sCreDt);
    	}
	}
	function Usr_setCreUsrId(sCreUsrId){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setCreUsrId(sCreUsrId);
    	}else{
    		glbSheet2FormData.setCreUsrId(sCreUsrId);
    	}
	}
	function Usr_setVslSlanCd(sVslSlanCd){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setVslSlanCd(sVslSlanCd);
    	}else{
    		glbSheet2FormData.setVslSlanCd(sVslSlanCd);
    	}
	}
	function Usr_setBound(sBound){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setBound(sBound);
    	}else{
    		glbSheet2FormData.setBound(sBound);
    	}
	}
	function Usr_setUpdDt(sUpdDt){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setUpdDt(sUpdDt);
    	}else{
    		glbSheet2FormData.setUpdDt(sUpdDt);
    	}
	}
	function Usr_setUpdUsrId(sUpdUsrId){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setUpdUsrId(sUpdUsrId);
    	}else{
    		glbSheet2FormData.setUpdUsrId(sUpdUsrId);
    	}
	}
	function Usr_setSkdRmk(sSkdRmk){
    	if(glbSheetFlg == "sheet1"){
    		glbSheet1FormData.setSkdRmk(sSkdRmk);
    	}else{
    		glbSheet2FormData.setSkdRmk(sSkdRmk);
    	}
	}
	/**
	 * Trunkate
	 *
	 * @param num 숫자
	 * @param place 자리수
	 * @return 절삭된 숫자
	 */
	function Usr_Trunc(num, place) {
		if(place == null || place == undefined || place == "") place=0;
		return Math.floor( num * Math.pow(10, parseInt(place, 10)) ) / Math.pow(10, parseInt(place, 10)); 
	}
	/**
	 * if manevering in or out Time is 0, Converting specific value
	 * 
	 * @param mnvrHrs
	 * @return
	 */
	function controlMnvrHrs(mnvrHrs){
		if(mnvrHrs=="0"){
			return "1";
		}else{
			return mnvrHrs;
		}
	}
	/**
	 * Calculating Time Difference between 2 parameter based on sBaseTime
	 * 
	 * times[0] : day
	 * times[1] : hour
	 * times[2] : min
	 * times[3] : sec
	 * isDelay : delay true
	 * isAdvance : advance true
	 *  
	 * @param sBaseDate
	 * @param sSrcDate
	 * @return
	 */
	function getTimeBetween(sBaseTime, sSrcTime){
		var timeBetween		= new Object();
		var oBaseTime		= getDateObj(sBaseTime);
		var oSrcTime		= getDateObj(sSrcTime);
		var milliSecs		= oBaseTime - oSrcTime;
		var iDay			= 1000 * 60 * 60 * 24;
		var iHour			= 1000 * 60 * 60;
		var iMin			= 1000 * 60;
		var iSec			= 1000;
		var iTmp			= 0;
		var times			= new Array();
		
		if(milliSecs>0){
			timeBetween.isAdvance	= true;
			timeBetween.isDelay		= false;
		} else if(milliSecs<0){
			timeBetween.isDelay		= true;
			timeBetween.isAdvance	= false;
			milliSecs=milliSecs * -1;
		} else {
			timeBetween.isAdvance	= false;
			timeBetween.isDelay		= false;
		}
		
		times[0]=iDay;
		times[1]=iHour;
		times[2]=iMin;
		times[3]=iSec;
		
		for(var i=0; i<times.length; i++){
			if(milliSecs==0){
				times[i]=-1;
				//break;
			}
			if(times[i]<=milliSecs){
				iTmp=Math.floor(milliSecs/times[i]);
				milliSecs=milliSecs%times[i];
				times[i]=iTmp;
			}else{
				times[i]=0;
			}
		}
		
		timeBetween.times	= times;
		return timeBetween;
	}
	/**
	 * Calculating hour, min Difference between 2 parameter based on sBaseTime
	 * 
	 * @param sBaseDate
	 * @param sSrcDate
	 * @return 00H-00M
	 */
	function getDelayTimeWithFormat(sBaseTime, sSrcTime){
		var timeBetween=getTimeBetween(sBaseTime, sSrcTime);
		if(timeBetween.isDelay()){
			var h1=Number(times[0]==-1?0:times[0]*24);
			var h2=Number(times[1]==-1?0:times[1]*1);
			var h3=Number(times[2]==-1?0:times[2]*1);
			return (h1+h2) + "H-" + h3 + "M";
		}else{
			return "";
		}
	}
	/**
	 * Calculating Minutes Difference between 2 parameter based on sBaseTime
	 * 
	 * @param sBaseDate
	 * @param sSrcDate
	 * @return min
	 */
	function getTimeBetweenByMins(sBaseTime, sSrcTime){
		var timeBetween		= getTimeBetween(sBaseTime, sSrcTime);
		var times			= timeBetween.times;
		var h1=Number(times[0]==-1?0:times[0]*24*60);
		var h2=Number(times[1]==-1?0:times[1]*60);
		var h3=Number(times[2]==-1?0:times[2]*1);
		
		return timeBetween.isDelay?(h1+h2+h3)*(-1):(h1+h2+h3);
	}
	/**
	 * Calculating Estimate Delay Time based on PF for minutes 
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param dateFlg ETA/ETB/ETD
	 * @return min
	 */
	function getDelayTime(sheetObj, Row, dateFlg){
		
		var prefix	= sheetObj.id + "_";
		var pfTime	= sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, dateFlg));
		var estTime;
		
		if("ETA"==dateFlg){
			estTime	= sheetObj.GetCellValue(Row, prefix+"vps_eta_dt");
		} else if("ETB"==dateFlg){
			estTime	= sheetObj.GetCellValue(Row, prefix+"vps_etb_dt");
		} else if("ETD"==dateFlg){
			estTime	= sheetObj.GetCellValue(Row, prefix+"vps_etd_dt");
		}
		
		if (pfTime < 0) return 0;
		
		var delayTime	= getTimeBetweenByMins(pfTime, estTime);

		//2007816-2007816//
		//alert('inner getDelayTime [['+dateFlg+']]  pfTime ['+pfTime+'] estTime ['+estTime+']  >> delayTime ['+delayTime+']');
		
		if(delayTime<0){
			return delayTime*(-1);
		}else{
			return 0;
		}
	}
	/**
	 * Calculating Estimate Advance Time based on PF for minutes 
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param dateFlg ETA/ETB/ETD
	 * @return min
	 */
	function getAdvanceTime(sheetObj, Row, dateFlg){
		var prefix=sheetObj.id + "_";
		var pfTime=sheetObj.GetCellValue(Row, getPfDateColName(sheetObj, Row, dateFlg));
		var estTime;
		if("ETA"==dateFlg){
			estTime=sheetObj.GetCellValue(Row, prefix+"vps_eta_dt");
		} else if("ETB"==dateFlg){
			estTime=sheetObj.GetCellValue(Row, prefix+"vps_etb_dt");
		} else if("ETD"==dateFlg){
			estTime=sheetObj.GetCellValue(Row, prefix+"vps_etd_dt");
		}
		var delayTime=getTimeBetweenByMins(pfTime, estTime);
		if(delayTime>0){
			return delayTime;
		}else{
			return 0;
		}
	}
	
	/**
	 ** Calculating base time + some minutes
	 * 
	 * @param sBaseHours
	 * @param mins
	 * @param isRound
	 * @return 
	 */
	function getAddedHoursByMin(sBaseHours, mins, isRound){
		var baseMins=Number(sBaseHours) * 60;
		var targetMins=baseMins + mins;
		var xHours=0;
		if(isRound){
			xHours=mins2hrs(targetMins);
		}else{
			xHours=Math.round(targetMins/60*10)/10;
		}
		return xHours;
	}
	/**
	 * Converting minutes to Hours
	 * 
	 * @param mins
	 * @return
	 */
	function mins2hrs(mins){
		var xHours=Math.floor(Number(mins)/30); // mins: 91 -> xHours=3
		var xMins=Number(mins) - xHours*30; // mins: 91 -> xMins=1
		if(xMins>30){
			xHours++;
		}
		return xHours * 0.5; // 30 min -> xHours=1.5
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
    	ComResizeSheet(sheetObjects[0], 100);        
    }