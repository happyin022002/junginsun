/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_VSK_0058.js
*@FileTitle  : VSL SKD Update (CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================**/

/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
  	
	
	var focusObj=null;
	
	// public variable
	
	var sheetObjects=new Array();
	var sheetCnt=0;
	var glbSkdPortFlgs=new Array();		//Port change flag
	var gblCngStsCd="";					//Saving temporary selected value
	var glbColCnt=0;
	
	//Color public variable
	var glbDelayFontColor=null;
	var glbAdvanceFontColor=null;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			//if (!ComIsBtnEnable(srcName)) return;  
			 if(ComGetBtnDisable(srcName)) return false; 
				switch(srcName) {
					case "btn_add_call":
						doActionIBSheet(sheetObject,formObject,COMMAND04);
						break;
					case "btn_add_call_cancel":
						doActionIBSheet(sheetObject,formObject,COMMAND05);
						break;										
					case "btn_skip_call":
						doActionIBSheet(sheetObject,formObject,COMMAND06);
						break;
					case "btn_skip_call_cancel":
						doActionIBSheet(sheetObject,formObject,COMMAND07);
						break;
					case "btn_reverse_call":
						doActionIBSheet(sheetObject,formObject,COMMAND08);
						break;
					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
					case "btn_vvd":
						doActionIBSheet(sheetObject,formObject,COMMAND02);
						break;
					case "btn_save":
						doActionIBSheet(sheetObject,formObject,IBSAVE);
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
		
		glbDelayFontColor="#FF0000";
		glbAdvanceFontColor="#0000FF";
		initControl();
		initButton(sheetObjects[0]);
		initLoadDirection(sheetObjects[0]);
		document.form.vsl_cd.focus();
		
//		document.form.cre_dt.readonly = true;
//		document.form.upd_dt.readonly = true;
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
				      //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				      var HeadTitle1="|Seq.|VVD|Port|TMNL Code|Turn|Arr Ext Voy Ref|Dep Ext Voy Ref|T-Arr Ext Voy Ref||T/P Voy|T/P Dir|ETA|ETB|ETD|Delay|||Change Status|Remark(s)";
				      var HeadHiddenTitle="|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|CLPT_IND_SEQ|VSL_SLAN_CD|PORT_SKD_STS_CD|TURN_PORT_IND_CD|PF_SKD_TP_CD" +
				      "|TURN_CLPT_IND_SEQ|SKD_RMK" +
				      "|CRE_DT|CRE_USR_ID|UPD_DT|UPD_USR_ID|SLAN_CD|PF_ETA_DT|PF_ETB_DT|PF_ETD_DT|TS PORT|USD_FLG|PORT_SKP_TP_CD" +
				      "|PORT_SKP_RSN_OFFR_RMK|PORT_SKP_RSN_CD|TTL_DLAY_HRS|DELAY_FLG|ACT_INP_FLG";
				      
				      HeadHiddenTitle=HeadHiddenTitle + "|TMP_CNG_STS_CD|NEW_CLPT_IND_SEQ|VPS_RMK|BFR_ACT_FLG" +
				      "|TS_SKD_VOY_NO|TS_SKD_DIR_CD|TS_CLPT_IND_SEQ|RSN_SKD_VOY_NO|RSN_SKD_DIR_CD|RSN_CLPT_IND_SEQ|";
				      
				      HeadTitle1=HeadTitle1 + HeadHiddenTitle;
				      
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      
				      glbColCnt=headCount;
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ 
				             {Type:"Status",    Hidden:1,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq",        		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_port_cd",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",   		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             
				             
				             //:2016-03-03:by TOP://
				             {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				             {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ob_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				             {Type:"Text",      Hidden:1, Width:99,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_ib_cssm_voy_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:10 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cssm_voy_init_cre_flg" },
				             //:2016-03-03:by TOP://
				             
				             
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_voy_no", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
				             {Type:"Combo",     Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_skd_dir_cd", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_eta_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etb_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_etd_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dlay_date_text",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             
				             //:2016-03-17:by TOP://
				             {Type:"Combo",     Hidden:1, Width:70,  Align:"Center",  ColMerge:1,   SaveName:prefix+"priv_call_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"add_call_xter_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             //:2016-03-17:by TOP://
				               
				             
				             {Type:"Combo",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"skd_cng_sts_cd",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"win_rmk",         		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_cd",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_voy_no",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_dir_cd",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_ind_seq",    		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vsl_slan_cd",     		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skd_sts_cd", 		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_port_ind_cd",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"turn_clpt_ind_seq",		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"skd_rmk",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"cre_dt",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1},
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"slan_cd",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_eta_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etb_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_etd_dt",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_port_cd",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"usd_flg",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_tp_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_offr_rmk",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"port_skp_rsn_cd",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dlay_hrs",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"delay_flg",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"act_inp_flg",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_skd_tp_cd" },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"tmp_cng_sts_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"new_clpt_ind_seq",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"vps_rmk",      			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bfr_act_flg",      		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_voy_no",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_skd_dir_cd",      	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_clpt_ind_seq",    	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_voy_no",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				      		 {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_skd_dir_cd",     	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				      		 {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rsn_clpt_ind_seq",   	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				      		 {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_flg",   	            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				      		 {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"delay_date" },
				      		 {Type:"Text",      Hidden:1,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"time_diff",   	        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				      		 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"auto_skd_cng_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				      		 
				      		 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vt_add_call_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
				      		 ];
				              
				      InitColumns(cols);
				      SetEditable(1);
				      SetColProperty(prefix+"turn_port_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				      
				      SetColProperty(prefix+"priv_call_flg", {ComboText:"|Private Call|", ComboCode:"|Y|N"} );
				      
				      SetColProperty(prefix+"vps_eta_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(prefix+"vps_etb_dt", {Format:"####-##-## ##:##"} );
				      SetColProperty(prefix+"vps_etd_dt", {Format:"####-##-## ##:##"} );
				      SetCountPosition("0");
				      SetColProperty(prefix+"turn_skd_voy_no", {AcceptKey:"N"});
				      
				      SetColHidden(prefix+"turn_skd_voy_no",1);
				      SetColHidden(prefix+"turn_skd_dir_cd",1);
				      
				      SetSelectionMode(3);
				      resizeSheet();
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
			InitDataProperty(0, Col, dtHidden, 0, daCenter,	true, prefix+colName, false, "", dfNone, 0, false, false);
		}
	}
	
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID = sheetObj.id;
		var prefix  = sheetID + "_";
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,IBSEARCH)){
					formObj.f_cmd.value=SEARCH;
					formObj.rtv_flg.value="N";
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					var sXml=sheetObj.GetSearchData("VOP_VSK_0058GS.do", sParam);
					ComOpenWait(false);
					showSheetData(sheetObj,formObj,sXml);
				}
				break;
			case SEARCH01:
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");				
					var sXml=sheetObj.GetSearchData("VOP_VSK_0058GS.do", sParam);
					return sXml;
				}
				break;
//			case SEARCH03:
			case SEARCH07:
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH07;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_"); 					
					var sXml=sheetObj.GetSearchData("VOP_VSK_0058GS.do", sParam);
					return sXml;
				}
				break;
			case SEARCH10:		//Vsl_Cd Check
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value=SEARCH10;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
					var sXml=sheetObj.GetSearchData("VOP_VSK_0058GS.do", sParam);
					return sXml;
				}
				break;
			case COMMAND02:        	// VVD Search
				var vslCd=formObj.vsl_cd.value;
            	if(vslCd == ""){
            		//sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 480, 470, "returnVslCdHelp", "0,0", true);
            	}else{
            		//sUrl = "/opuscntr/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 480, 470, "returnVvdHelp", "0,0", true);
            	}
				break;
			case COMMAND04:        	// Add Call
				var posFlg=isAddPositionFlag(sheetObj);		// position flag(before/after)
				sUrl="/opuscntr/VOP_VSK_0215.do?pos_flg=" + posFlg;
				ComOpenPopup(sUrl, 510, 320, "returnAddCallHelp", "0,0", true);
				break;
			case COMMAND05:        	// Add Call Cancel
				addCallCancel(sheetObj);
				break;
			case COMMAND06:        	// Skip Call
				
				/*
				 * 2015.03.04 dongsoo
				 * skip call시 Hours시간 계산
				 * VPS_ETD_DT - PF_ETD_DT의 hour
				 */
				var curRow       = sheetObj.GetSelectRow();
				var etdDelayTime = getDelayTime(sheetObj, curRow, "ETD");				
				sheetObj.SetCellValue(curRow, prefix + "delay_date", Math.round(etdDelayTime/60*10)/10, 0);
				
				sUrl="/opuscntr/VOP_VSK_0245.do";
        		ComOpenPopup(sUrl, 700, 398, "returnSkipCallHelp", "none", true);
				break;
			case COMMAND07:        	// Skip Call Cancel
				skipCallCancel(sheetObj);
				break;
			case COMMAND08:        	// Reverse Call
				reverseCallControl(sheetObj);
				break;
			case COMMAND23:        	// PORT TIME CHECK
				formObj.f_cmd.value = COMMAND23;				
				var sParam = FormQueryString(formObj);
				var sXml   = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
				
				return sXml;
			case IBSAVE:        //save
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					
					var sParam=ComGetSaveString(sheetObjects, true, true, -1);
					if (sParam == "") return;
					sParam += "&" + FormQueryString(formObj);
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true); 			
					var sXml=sheetObj.GetSaveData("VOP_VSK_0058GS.do", sParam);
					ComOpenWait(false); 					
					sheetObj.LoadSaveData(sXml);
					
					var nodeText = ComGetSelectSingleNode(sXml, "TR-ALL");
					
					if(nodeText == "OK"){
						doActionIBSheet(sheetObj, formObj, IBSEARCH);
					}
				}
				break;
//			case IBINSERT:      // input
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
				}
				break;
			case COMMAND01:      	//vsl_slan_cd onChange Event
				if(!ComIsNull(formObj.vsl_slan_cd.value)){
					if(formObj.vsl_slan_cd.value.length < 3){
						ComShowCodeMessage("VSK01018", "[Lane Code]");
//						ComClearCombo(formObj.pf_svc_tp_cd);
						formObj.vsl_slan_cd.value="";
						return false;
					}
				} else {
//					ComClearCombo(formObj.pf_svc_tp_cd);
					return false;
				}
				break;
			
			case IBSAVE:      //save
				for(var i=headCnt; i<=totCnt; i++){
					//Port Code Check...
					if(sheetObj.GetCellValue(i, prefix+"vps_port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "[Port Code]");
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
					
					if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
						if(ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.GetCellValue(i, prefix+"turn_skd_dir_cd"))){
							ComShowCodeMessage("VSK00033", sheetObj.GetCellValue(i, prefix+"vps_port_cd"));
							//Finding data which turn_port_flg is 'Y' and turn_skd_voy_no, turn_skd_dir_cd are null. Then the data format change Editable
							turnEditChange(sheetObj);
							sheetObj.SetColHidden(prefix+"turn_skd_voy_no",0);
							sheetObj.SetColHidden(prefix+"turn_skd_dir_cd",0);
							sheetObj.SelectCell(i, prefix+"turn_skd_voy_no");
							return false;
						}
					}
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
					if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
						if(sheetObj.GetCellValue(i, prefix+"vps_eta_dt") < sheetObj.GetCellValue(i, prefix+"vps_etb_dt")){
							if(sheetObj.GetCellValue(i, prefix+"vps_etb_dt") < sheetObj.GetCellValue(i, prefix+"vps_etd_dt")){
								if(i<totCnt){
									for(var k=i+1; k<=totCnt; k++){
										
										//::FOR.NYK.START::by dongsoo:2014-09-30:://
										//Apia to Pago Pago 간의 local time 역전현상에 대해 하드코딩으로 수정											
										var curTimeDiff = sheetObj.GetCellValue(i, prefix+"time_diff");
										var nxtTimeDiff = sheetObj.GetCellValue(k, prefix+"time_diff");
										if(sheetObj.GetCellValue(k, prefix+"skd_cng_sts_cd") != "S"){
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
											//::FOR.NYK.FINISH::by dongso:2014-09-30:://
										}
									} // end for
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
					
				} // end for
				
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
					if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y" && sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
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
					var sXml=sheetObj.GetSearchData("VOP_VSK_0058GS.do", sParam);
 					var etdChk=ComGetEtcData(sXml, "etd_chk");
 					
 					if(etdChk == "N"){
 						ComShowCodeMessage("VSK00055", formatDate(new Date(getDateFromFormat(vpsEtaDt, "yyyyMMddHHmm")), "yyyy-MM-dd HH:mm"));
 						return false;
 					}
 					
				}
				formObj.skd_rmk.value = VopAsciiRemove(formObj.skd_rmk.value);
				break;
    	}
		return true;
	}
    /**
     * process after retrieve.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function showSheetData(sheetObj, formObj, sXml){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
    	
    	if(sheetObj.SetColHidden(prefix+"turn_skd_voy_no") == 0) sheetObj.GetColHidden(prefix+"turn_skd_voy_no",1);
		if(sheetObj.SetColHidden(prefix+"turn_skd_dir_cd") == 0) sheetObj.GetColHidden(prefix+"turn_skd_dir_cd",1);
		
		if(sXml != null){
			//var rootNode=VskGetXmlRootNode(sXml);
			//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
			
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			
			if(dataNode){
				//var totValue=dataNode.value;
				var totValue=dataNode;
				
				if(totValue > 0){
					try{
						var chgStsCds=ComGetEtcData(sXml, "chg_sts_cd");		//Change Status Code
						var chgStsNms=ComReplaceStr(ComGetEtcData(sXml, "chg_sts_nm"), " calling", ""); //Change Status CodeName
						
						sheetObj.SetColProperty(prefix+"skd_cng_sts_cd", {ComboText:"|"+chgStsNms, ComboCode:"|"+chgStsCds} );
						sheetObj.SetColHidden(prefix+"turn_skd_voy_no",1);
						sheetObj.SetColHidden(prefix+"turn_skd_dir_cd",1);
					      
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						
						formObj.vsl_slan_cd.value=sheetObj.GetCellValue(headCnt, prefix+"vsl_slan_cd");
//						formObj.cre_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(headCnt, prefix+"cre_dt"));
//						formObj.upd_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(headCnt, prefix+"upd_dt"));
						
					
						
						initPortDataFlg(sheetObj);
						//TMNL Setting.
						var ydCds=ComGetEtcData(sXml, "tml_cd").split("|");
						if(ydCds != null && ydCds != undefined && ydCds != ""){
							for(var i=0 ; i < ydCds.length ; i++ ) {
								sheetObj.CellComboItem(i+headCnt,prefix+"tml_cd", {ComboText:ydCds[i], ComboCode:ydCds[i]} );
								sheetObj.SetCellValue(i+headCnt, prefix+"tml_cd",ydCds[i],0);
								var turnPortIndCd=sheetObj.GetCellValue(i+headCnt, prefix+"turn_port_ind_cd");
								if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
//									sheetObj.CellEditable(i+headCnt, prefix+"tml_cd") = false;
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"turn_port_flg",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"skd_cng_sts_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_rmk",0);
					    		}
					    		//FontColor Setting...
								if(sheetObj.GetCellValue(i+headCnt, prefix+"delay_flg") == "B"){
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_eta_dt",glbAdvanceFontColor);
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_etb_dt",glbAdvanceFontColor);
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_etd_dt",glbAdvanceFontColor);
								}else if(sheetObj.GetCellValue(i+headCnt, prefix+"delay_flg") == "R"){
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_eta_dt",glbDelayFontColor);
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_etb_dt",glbDelayFontColor);
									sheetObj.SetCellFontColor(i+headCnt, prefix+"vps_etd_dt",glbDelayFontColor);
					    		}
					    		//Cannot change Actual inputed SKD
								if(sheetObj.GetCellValue(i+headCnt, prefix+"port_skd_sts_cd") == "A"){
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_eta_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"tml_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"turn_port_flg",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"skd_cng_sts_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_rmk",0);
								} else if(sheetObj.GetCellValue(i+headCnt, prefix+"port_skd_sts_cd") == "B") {
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_eta_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_etb_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"tml_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"turn_port_flg",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"skd_cng_sts_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_rmk",0);
								} else if(sheetObj.GetCellValue(i+headCnt, prefix+"port_skd_sts_cd") == "D") {
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_eta_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_etb_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_etd_dt",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"tml_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"turn_port_flg",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"skd_cng_sts_cd",0);
					    			sheetObj.SetCellEditable(i+headCnt, prefix+"vps_rmk",0);
					    		}
					    		//Skip Port noneditable
								if(sheetObj.GetCellValue(i+headCnt, prefix+"skd_cng_sts_cd") == "S"){
					    			sheetObj.SetRowEditable(i+headCnt,0);
					    			fontColorChangeBySkip(sheetObj, i+headCnt);
					    		}
							}
						}
						// reset clpt_seq 
						resetClptSeq(sheetObj);
						formObj.skd_rmk.value=sheetObj.GetCellValue(headCnt, prefix+"skd_rmk");
						sheetObj.SelectCell(headCnt, 1);
						//PF_SKD_TP_CD 
						formObj.pf_skd_tp_cd.value = sheetObj.GetCellValue(headCnt, prefix+"pf_skd_tp_cd");
//						ComBtnEnable("btn_add_call");
//						ComBtnEnable("btn_skip_call");
					}catch(e){
						ComShowMessage(e.message);
					}
				}else{
					sheetObj.LoadSearchData(sXml,{Sync:1} );
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
		if(Row > 0 && Col > 0){
//			setElementData(sheetObj, Row, Col);
			var prefix=sheetObj.id + "_";
			var formObj=document.form;
			var headCnt=sheetObj.HeaderRows();
			var colName=sheetObj.ColSaveName(Col);
			if(colName == prefix+"win_rmk"){
				var sUrl="/opuscntr/VOP_VSK_0218.do?remarks=" + escape(sheetObj.GetCellValue(Row, prefix+"vps_rmk"));
//				if(sheetObj.RowEditable(Row) == false){
				if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"
					|| sheetObj.GetCellValue(Row, prefix+"port_skd_sts_cd") == "D"
						|| sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
					sUrl=sUrl + "&readonly=true";
				}
				
				ComOpenPopup(sUrl, 342, 350, "returnRemarkHelp", "0,0", true);
			}
		}
	}
	
	/**
	 * Handling data from Remark Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnRemarkHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var prefix=sheetObj.id + "_";
		var rtnDatas=rtnObjs;
		
		if (rtnDatas.length > 0) {
			if (rtnDatas || rtnDatas == "") {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"vps_rmk", rtnDatas,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"win_rmk", rtnDatas.replace(/\n/g, "").replace(/\r/g, ""),0);
			}
		} else {
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"vps_rmk", "",0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"win_rmk", "",0);
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var headCnt=sheetObj.HeaderRows();
		var sXml=null;
		var prefix=sheetObj.id + "_";
		if(Row >= headCnt && Col > 0){
			var colName=sheetObj.ColSaveName(Col);
//			if(colName == prefix+"vps_port_cd"){							//Port change 시
//				glbSkdPortFlgs[Row-headCnt] = "N";
//				
//				//Termanal Code Retrieve
//				formObj.loc_cd.value = sheetObj.CellValue(Row, prefix+"vps_port_cd");
//				
//				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
//				
//				if(isCheckPort(sheetObj, Row, sXml)){
//					if(sXml != null && sXml != undefined && sXml != ""){
//						var rootNode = VskGetXmlRootNode(sXml);
//						var dataNode = rootNode.selectSingleNode("//DATA/@TOTAL");
//						if(dataNode){
//							var totValue = dataNode.value;
//	
//							if(totValue > 0){
//								setSheetTmnlCombo(sXml, sheetObj, Row, Col);
//							}else{
//								sheetObj.CellComboItem(Row, prefix+"tml_cd", "", "");
////								sheetObj.CellValue2(Row, prefix+"tml_cd") = "";
//							}
//						}
//					}
//					glbSkdPortFlgs[Row-headCnt] = "Y";
//				}else{
//					glbSkdPortFlgs[Row-headCnt] = "N";
//				}
//			}else 
			if(colName == prefix+"skd_cng_sts_cd"){
				var cngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				if(cngStsCd != "" && cngStsCd != "I" && cngStsCd != "O"){
					ComShowCodeMessage("VSK00078");
					sheetObj.SetCellValue(Row, prefix+"skd_cng_sts_cd",gblCngStsCd,0);
				}else{
					gblCngStsCd=sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd");
				}
			}else if(colName == prefix+"turn_port_flg"){
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
				}else{
					sheetObj.SetCellValue(Row, prefix+"turn_skd_voy_no","",0);
					sheetObj.SetCellValue(Row, prefix+"turn_skd_dir_cd","",0);
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_voy_no",0);
					sheetObj.SetCellEditable(Row, prefix+"turn_skd_dir_cd",0);
				}
			}
		}
	}
	/**
	 * Handling select cell event
	 * 
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
					return;
				}
				if(glbSkdPortFlgs[NewRow-headCnt] != "Y"){
					formObj.loc_cd.value=sheetObj.GetCellValue(NewRow, prefix+"vps_port_cd");
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
					if(sXml != null && sXml != undefined && sXml != ""){
						setSheetTmnlCombo(sXml, sheetObj, NewRow, NewCol);
					}
					glbSkdPortFlgs[NewRow-headCnt]="Y";
				}
			}else if(sheetObj.ColSaveName(NewCol) == prefix+"skd_cng_sts_cd"){
				gblCngStsCd=sheetObj.GetCellValue(NewRow, NewCol);
			}
			var turnPortIndCd=sheetObj.GetCellValue(NewRow, prefix+"turn_port_ind_cd");
			if(turnPortIndCd == "D" || turnPortIndCd == "V" || turnPortIndCd == "F"){
				ComBtnDisable("btn_skip_call");
				ComBtnDisable("btn_add_call");
				ComBtnDisable("btn_skip_call_cancel");
				ComBtnDisable("btn_add_call_cancel");
			}else{
				//Skip Call
				if(sheetObj.GetCellValue(NewRow, prefix+"skd_cng_sts_cd") == "S"){
					ComBtnEnable("btn_skip_call_cancel");
				} else {
					ComBtnDisable("btn_skip_call_cancel");
				}
				//Add Call
//				if(sheetObj.CellValue(NewRow, prefix+"ibflag") == "I"){
				if(sheetObj.GetCellValue(NewRow, prefix+"skd_cng_sts_cd") == "A"){
					ComBtnEnable("btn_add_call_cancel");
				} else {
					ComBtnDisable("btn_add_call_cancel");
				}
				//Phase Out
//				if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "O"){
//					ComBtnEnable("btn_p_out_cancel");
//				} else {
//					ComBtnDisable("btn_p_out_cancel");
//				}
				//port_skd_sts_cd로 input여부 판단.
				if(isSkipPortSts(sheetObj, NewRow)){
					if(sheetObj.GetCellValue(NewRow, prefix+"skd_cng_sts_cd") == "S"){
						ComBtnDisable("btn_skip_call");
					}else{
						ComBtnEnable("btn_skip_call");
					}
//					if(sheetObj.CellValue(NewRow, prefix+"skd_cng_sts_cd") == "O"){
//						ComBtnDisable("btn_p_out");
//					}else{
//						ComBtnEnable("btn_p_out");
//					}
				}else{
					ComBtnDisable("btn_skip_call");
//					ComBtnDisable("btn_p_out");
				}
//				if(isAddPortSts(sheetObj, NewRow)){
					ComBtnEnable("btn_add_call");
//				}else{
//					ComBtnDisable("btn_add_call");
//				}
			}
			setFormData(sheetObj, NewRow, NewCol);
		}
	}
	/**
	 * Handling key up event
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
	 * Handling mouse up event
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
	/*
	 * =====================================================================
	 * Object Event	
	 * =====================================================================
	 */
    function initControl() {
//    	axon_event.addListenerForm('change', 'obj_change', form); 	
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 	
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form, 'skd_rmk');
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	axon_event.addListenerForm('keydown', 'obj_keydown', form);
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName=ComGetEvent("name");
			var srcValue=ComGetEvent("value");
	        switch(srcName) {
	            case "vsl_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(isCheckVslCd(sheetObj, formObj)){
		            	if(srcValue.length == 4){
				    		formObj.skd_voy_no.focus();
				    	}
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	            case "skd_voy_no":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 4){
			    		formObj.skd_dir_cd.focus();
			    	}
	            	break;
	            case "skd_dir_cd":
	            	clearDescData(sheetObj, formObj, "");
	            	if(srcValue.length == 1){
			    		formObj.vsl_slan_cd.focus();
			    	}
	            	break;
	            case "vsl_slan_cd":
//	            	if(validateForm(sheetObject, formObject, COMMAND01)){
//		            	var sXml = doActionIBSheet(sheetObject, formObject, COMMAND01);
//		            	setHtmlComboSinc(sXml, formObject.pf_svc_tp_cd);
//	            	}
//	            	isRmkModFlg = "Y";
	            	break;
	            case "skd_rmk":
//	            	isRmkModFlg = "Y";
	            	break;
	        } // end switch isRmkModFlg
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function obj_keypress(){
		var formObj=document.form;
		switch (ComGetEvent("name")) {
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
		    case "skd_rmk":
		    	if(formObj.skd_rmk.value.length > 4000){
		    		ComShowCodeMessage("VSK01019", "[Remark]");
		    		return false;
		    	}
				break;
		}
	}
	function obj_keyup(){
		var eleObj=ComGetEvent();
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
		    		formObj.vsl_slan_cd.focus();
		    	}
		    	break;
//		    case "vsl_slan_cd":
//		    	if(eleObj.value.length == 3){
//		    		formObj.skd_rmk.focus();
//		    	}
				break;
		}
	}
	function obj_focus(){
		var eleObj=ComGetEvent();
		if(eleObj.name){
			focusObj=eleObj.name;
		}else{
			focusObj="";
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
	/**
	 * Handling data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
		var rtnDatas=rtnObjs;
		
		if(rtnObjs[0][1].length > 0){
			formObj.vsl_cd.value=rtnObjs[0][1]; //vessel code
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
				}
			}
    	}
    }
	/**
	 * Call after [Add Call] Button Click
	 * @param rtnObj
	 * @return
	 */
	function returnAddCallHelp(rtnObj){
		var sheetObj=sheetObjects[0];
		if(rtnObj){
			addCallControl(sheetObj, rtnObj);
		}
	}
	/**
	 * Handling data from Port Skip Recorder for Statistics (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function returnSkipCallHelp(rtnObjs){
		if(rtnObjs.length > 0){
			var formObj=document.form;
			var sheetObj=sheetObjects[0];
			var prefix=sheetObj.id+"_";
			var headCnt=sheetObj.HeaderRows();
			var totCnt=sheetObj.LastRow();
			var currRow=0;
			var idx=0;
			for(var i=headCnt; i<=totCnt; i++){
				if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") == "S" || i == sheetObj.GetSelectRow()){
					var rtnDatas=rtnObjs[idx];
					if(rtnDatas != null && rtnDatas != undefined && rtnDatas.length > 0){
						sheetObj.SetCellValue(i, prefix+"ts_port_cd",rtnDatas[13],0);// ts_port_cd
						sheetObj.SetCellValue(i, prefix+"usd_flg",rtnDatas[3],0);// Report(DB:USD_FLG)
						sheetObj.SetCellValue(i, prefix+"port_skp_tp_cd",rtnDatas[4],0);// Force Majeure(DB:PORT_SKP_TP_CD)
						sheetObj.SetCellValue(i, prefix+"port_skp_rsn_offr_rmk",rtnDatas[9],0);// rsn_port_cd
						sheetObj.SetCellValue(i, prefix+"port_skp_rsn_cd",rtnDatas[6],0);//
						sheetObj.SetCellValue(i, prefix+"ttl_dlay_hrs",rtnDatas[7],0);// Hours(DB:TTL_DLAY_HRS)
						//sheetObj.SetCellValue(i, prefix+"vps_rmk",rtnDatas[9],0);// vps_rmk
						sheetObj.SetCellValue(i, prefix+"ts_skd_voy_no",rtnDatas[14],0);// ts_skd_voy_no
						sheetObj.SetCellValue(i, prefix+"ts_skd_dir_cd",rtnDatas[15],0);// ts_skd_dir_cd
						sheetObj.SetCellValue(i, prefix+"ts_clpt_ind_seq",rtnDatas[16],0);// ts_clpt_ind_seq
						sheetObj.SetCellValue(i, prefix+"rsn_skd_voy_no",rtnDatas[18],0);// rsn_skd_voy_no
						sheetObj.SetCellValue(i, prefix+"rsn_skd_dir_cd",rtnDatas[19],0);// rsn_skd_dir_cd
						sheetObj.SetCellValue(i, prefix+"rsn_clpt_ind_seq",rtnDatas[20],0);// rsn_clpt_ind_seq
					}
					idx++;
				}
			}
			skipCallControl(sheetObj);
		}
	}
	/*
	 * =====================================================================
	 * Button Event
	 * =====================================================================
	 */
	/**
	 * [Add Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallControl(sheetObj, rowData){
		var formObj=document.form;
		var sRow=sheetObj.GetSelectRow();
		var prefix=sheetObj.id + "_";
		var pos=rowData.position;
		//sheetObj.RenderSheet(0);
		if(pos == "before"){
			// Validation Add Call before Actual Port
			if(!isAddCallActualPort(sheetObj, sRow-1, rowData.port_cd)){
				//sheetObj.RenderSheet(1);
				return;
			}
			//Adding before selected Row
			sheetObj.DataInsert(sRow);
			//Color Setting.
//			sheetObj.RowBackColor(sRow) = sheetObj.RowBackColor(sRow+1);
			sheetObj.SetCellValue(sRow, prefix+"vvd",sheetObj.GetCellValue(sRow+1, prefix+"vvd"),0);
			sheetObj.SetCellValue(sRow, prefix+"vsl_cd",sheetObj.GetCellValue(sRow+1, prefix+"vsl_cd"),0);
			sheetObj.SetCellValue(sRow, prefix+"skd_voy_no",sheetObj.GetCellValue(sRow+1, prefix+"skd_voy_no"),0);
			sheetObj.SetCellValue(sRow, prefix+"skd_dir_cd",sheetObj.GetCellValue(sRow+1, prefix+"skd_dir_cd"),0);
			sheetObj.SetCellValue(sRow, prefix+"vsl_slan_cd",sheetObj.GetCellValue(sRow+1, prefix+"vsl_slan_cd"),0);
			sheetObj.SetCellValue(sRow, prefix+"vps_port_cd",rowData.port_cd,0);
//			sheetObj.CellValue2(sRow, prefix+"tml_cd") = rowData.yd_cd;
			sheetObj.SetCellValue(sRow, prefix+"vps_eta_dt",rowData.eta,0);
			sheetObj.SetCellValue(sRow, prefix+"vps_etb_dt",rowData.etb,0);
			sheetObj.SetCellValue(sRow, prefix+"vps_etd_dt",rowData.etd,0);
			sheetObj.SetCellValue(sRow, prefix+"auto_skd_cng_flg","1",0);
			
			if(rowData.turn_ind == "0"){
				sheetObj.SetCellValue(sRow, prefix+"turn_port_flg","Y");
			}
			
			formObj.loc_cd.value=rowData.port_cd;
			
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd"		,"A"	,0);
			sheetObj.SetCellValue(sRow, prefix+"add_call_xter_flg"	,"1"	,0);
			
			sheetObj.SelectCell(sRow, sheetObj.GetSelectCol());
			
			
			
		}else{
			
			// Validation Add Call before Actual Port
			if(!isAddCallActualPort(sheetObj, sRow, rowData.port_cd)){
				//sheetObj.RenderSheet(1);
				return;
			}
			//ADD after selected row
			sheetObj.DataInsert(sRow + 1);
			//Color Setting.
//			sheetObj.RowBackColor(sRow+1) = sheetObj.RowBackColor(sRow);
			sheetObj.SetCellValue(sRow+1, prefix+"vvd",sheetObj.GetCellValue(sRow, prefix+"vvd"),0);
			sheetObj.SetCellValue(sRow+1, prefix+"vsl_cd",sheetObj.GetCellValue(sRow, prefix+"vsl_cd"),0);
			sheetObj.SetCellValue(sRow+1, prefix+"skd_voy_no",sheetObj.GetCellValue(sRow, prefix+"skd_voy_no"),0);
			sheetObj.SetCellValue(sRow+1, prefix+"skd_dir_cd",sheetObj.GetCellValue(sRow, prefix+"skd_dir_cd"),0);
			sheetObj.SetCellValue(sRow+1, prefix+"vsl_slan_cd",sheetObj.GetCellValue(sRow, prefix+"vsl_slan_cd"),0);
			sheetObj.SetCellValue(sRow+1, prefix+"vps_port_cd",rowData.port_cd,0);
//			sheetObj.CellValue2(sRow+1, prefix+"tml_cd") = rowData.yd_cd;
			sheetObj.SetCellValue(sRow+1, prefix+"vps_eta_dt",rowData.eta,0);
			sheetObj.SetCellValue(sRow+1, prefix+"vps_etb_dt",rowData.etb,0);
			sheetObj.SetCellValue(sRow+1, prefix+"vps_etd_dt",rowData.etd,0);
			sheetObj.SetCellValue(sRow+1, prefix+"auto_skd_cng_flg",1,0);
			
			if(rowData.turn_ind == "0"){
				sheetObj.SetCellValue(sRow+1, prefix+"turn_port_flg","Y");
			} else {
				sheetObj.SetCellValue(sRow+1, prefix+"turn_port_flg","N");
			}
			
			formObj.loc_cd.value=rowData.port_cd;
			
			sheetObj.SetCellValue(sRow+1, prefix+"skd_cng_sts_cd"	,"A"	,0);
			sheetObj.SetCellValue(sRow+1, prefix+"add_call_xter_flg","1"	,0);
			
			sheetObj.SelectCell(sRow+1, sheetObj.GetSelectCol());
		}
		resetClptSeq(sheetObj);
		resetClptIndSeq(sheetObj);
		initPortDataFlg(sheetObj);
		//sheetObj.RenderSheet(1);
		ComBtnEnable("btn_add_call_cancel");
	}
	/**
	 * [Add Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function addCallCancel(sheetObj){
		var sRow=sheetObj.GetSelectRow();
		var prefix=sheetObj.id + "_";
		sheetObj.RenderSheet(0);
//		if(sheetObj.CellValue(sRow, prefix+"ibflag") == "I"){
		if(sheetObj.GetRowStatus(sRow) == "I"){
			sheetObj.RowDelete(sRow, false);
		}else if(sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd") == "A"){
//			sheetObj.CellValue2(sRow, prefix+"ibflag") = "D";
			sheetObj.SetRowStatus(sRow,"D");
			sheetObj.SetRowHidden(sRow,1);
		}
		resetClptSeq(sheetObj);
		resetClptIndSeq(sheetObj);
		initPortDataFlg(sheetObj);
		sheetObj.RenderSheet(1);
		ComBtnDisable("btn_add_call_cancel");
	}
	/**
	 * [Skip Call] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallControl(sheetObj){
		var prefix=sheetObj.id + "_";
		var sRow=sheetObj.GetSelectRow();
		var headRow=sheetObj.HeaderRows();
		var formObj=document.form;
		try{
			//Setting current status to temp item
			sheetObj.SetCellValue(sRow, prefix+"tmp_cng_sts_cd",sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd"),0);
			//change current status to 'SKIP'
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd","S",0);
			//Skip Port nonEditable
			sheetObj.SetRowEditable(sRow,0);
			fontColorChangeBySkip(sheetObj, sRow);
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
		ComBtnEnable("btn_skip_call_cancel");
	}
	/**
	 * [Skip Call Cancel] Button Event : 
	 * @param sheetObj
	 * @return
	 */
	function skipCallCancel(sheetObj){
		var sRow=sheetObj.GetSelectRow();
		var prefix=sheetObj.id + "_";
		if(sheetObj.GetCellValue(sRow, prefix+"skd_cng_sts_cd") == "S"){
			//Return to original data
			sheetObj.SetCellValue(sRow, prefix+"skd_cng_sts_cd",sheetObj.GetCellValue(sRow, prefix+"tmp_cng_sts_cd"),0);
			/* VOP_VSK_0015.js , VOP_VSK_0058.js
			 * UPDATE QUERY가 공통으로 같이 사용하여 NVL로 인해서 UPADTE가 정상적으로 되지 않음 
			 * port_skp_tp_cd가 XXX일 경우 NULL로 입력됨. 
			 */
			sheetObj.SetCellValue(sRow, prefix+"port_skp_tp_cd"       ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"port_skp_rsn_cd"      ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"port_skp_rsn_offr_rmk","" ,0);
			sheetObj.SetCellValue(sRow, prefix+"ts_port_cd"           ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"usd_flg"              ,"N",0);
			//sheetObj.SetCellValue(sRow, prefix+"vps_rmk"              ,"" ,0);
			sheetObj.SetCellValue(sRow, prefix+"ttl_dlay_hrs"         ,"0",0);
			//Skip Cancel Port Editable
			sheetObj.SetRowEditable(sRow,1);
			// sheet1, sheet2 common
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_eta_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etb_dt");
			setSheetFontToOriginColor(sheetObj, sRow, prefix+"vps_etd_dt");
			ComBtnDisable("btn_skip_call_cancel");
		}
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
//		ComBtnDisable("btn_reverse_call");
	}
    /**
     * [Reverse Call] Button Disabled Control...
     * @param sheetObj
     * @return
     */
    function btnReverseCallControl(sheetObj){
		var strSelRow=sheetObj.GetSelectionRows("|");
		var btnName="btn_reverse_call";
		if(strSelRow != null && strSelRow != undefined && strSelRow != ""){
			var selRows=strSelRow.split("|");
			if(selRows.length == 2){
				var formObj=document.form;
				var prefix=sheetObj.id + "_";
//				if(isSkipBtnSts(sheetObj, selRows[0]) && isSkipBtnSts(sheetObj, selRows[1])){
				var vvd1=sheetObj.GetCellValue(selRows[0], prefix+"vvd");
				var vvd2=sheetObj.GetCellValue(selRows[1], prefix+"vvd");
				
				var turnPortChk = "N";  
				
		    	var turnPortSts1=sheetObj.GetCellValue(selRows[0], prefix+"turn_port_ind_cd");
				if(turnPortSts1 == "F" || turnPortSts1 == "V" || turnPortSts1 == "D"){
					turnPortChk = "Y";
				}
				
		    	var turnPortSts2=sheetObj.GetCellValue(selRows[1], prefix+"turn_port_ind_cd");
				if(turnPortSts2 == "F" || turnPortSts2 == "V" || turnPortSts2 == "D"){
					turnPortChk = "Y";
				}
				
					//Blocking Reverse if vvds are different
					if(vvd1 == vvd2 && turnPortChk == "N"){
						ComBtnEnable(btnName);
					}else{
						ComBtnDisable(btnName);
					}
//				}else{
//					ComBtnDisable(btnName);
//				}
			}else{
				ComBtnDisable(btnName);
			}
		}else{
			ComBtnDisable(btnName);
		}
    }
	/*
	 * =====================================================================
	 * 
	 * =====================================================================
	 */
    /**
     * Handling form data of inputed param
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function setFormData(sheetObj, Row, Col){
    	var formObj=document.form;
    	var prefix=sheetObj.id + "_";
    	//formObj.cre_dt.value=VskReplaceUserDate((Row, prefix+"cre_dt"));
    	formObj.cre_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"cre_dt"));
    	formObj.cre_usr_id.value=sheetObj.GetCellValue(Row, prefix+"cre_usr_id");
    	formObj.upd_dt.value=VskReplaceUserDate(sheetObj.GetCellValue(Row, prefix+"upd_dt"));
    	formObj.upd_usr_id.value=sheetObj.GetCellValue(Row, prefix+"upd_usr_id");	
    }
    /**
     * Setting Direction Code List of Turnning Port
     * @param sheetObj
     * @return
     */
    function initLoadDirection(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var sXml=doActionIBSheet(sheetObj, document.form, SEARCH07);
    	var sDirCds = "|" + ComGetEtcData(sXml, "direction_cd");
    	sheetObj.SetColProperty(prefix+"turn_skd_dir_cd", {ComboText:sDirCds, ComboCode:sDirCds} );
    }
	/**
	 * Button Initializing.
	 * @return
	 */
    function initButton(sheetObj){
    	var formObj=document.form;
    	ComBtnDisable("btn_add_call");
    	ComBtnDisable("btn_add_call_cancel");
    	ComBtnDisable("btn_skip_call");
    	ComBtnDisable("btn_skip_call_cancel");
    	ComBtnDisable("btn_reverse_call");
//    	ComBtnDisable("btn_row_hide_1");
//    	ComBtnDisable("btn_skip_call_1");
//    	ComBtnDisable("btn_add_call_1");
//    	ComBtnDisable("btn_reverse_call_1");
//    	ComBtnDisable("btn_row_hide_cancel_1");
//    	ComBtnDisable("btn_skip_call_cancel_1");
//    	ComBtnDisable("btn_add_call_cancel_1");
//    	ComBtnDisable("btn_reverse_call_change_1");
//    	
//    	ComBtnDisable("btn_settlement");
//    	ComEnableObject(formObj.btn_sim_no, false);
    }
    /**
     * Handling initial data for Terminal Retrieve
     * @param sheetObj
     * @return
     */
    function initPortDataFlg(sheetObj){ 
    	var totCnt=sheetObj.RowCount();
    	for(var i=0; i<totCnt; i++){
    		glbSkdPortFlgs[i]="N";
    	}
    }
    /**
     * Handling with Port Code
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
     * Blocking Add Call in case Same Actual Port exist in VVD
     * 
     * @param sheetObj
     * @param sRow
     * @return
     */
    function isAddCallActualPort(sheetObj, Row, portCd){
    	var prefix=sheetObj.id + "_";
    	var headRow=sheetObj.HeaderRows();
    	var totCnt=sheetObj.LastRow();
    	for(var i=Row+1; i<=totCnt; i++){
    		// except skip
    		if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    			if(sheetObj.GetCellValue(i, prefix+"vps_port_cd") == portCd){
    				var actInpFlg=sheetObj.GetCellValue(i, prefix+"act_inp_flg");
    				if(actInpFlg == "Y"){
    					ComShowCodeMessage("VSK00001");
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
    /**
     * Blocking Reverse Call in case Same Actual Port exist in VVD
     * 
     * @param sheetObj
     * @param Rows
     * @return
     */
    //no support[check again]CLT 
    function isReverseCallActualPort(sheetObj, Rows){
    	var prefix=sheetObj.id + "_";
    	var headRow=sheetObj.HeaderRows();
    	var totCnt=sheetObj.LastRow();
    	var fPortCd=sheetObj.GetCellValue(Rows[0], prefix+"vps_port_cd");
    	var sPortCd=sheetObj.GetCellValue(Rows[1], prefix+"vps_port_cd");
    	var fActInpFlg=sheetObj.GetCellValue(Rows[0], prefix+"act_inp_flg");
    	var sActInpFlg=sheetObj.GetCellValue(Rows[1], prefix+"act_inp_flg");
    	var fIbFlg=sheetObj.GetRowStatus(Rows[0]);
    	var sIbFlg=sheetObj.GetRowStatus(Rows[1]);
    	if(Number(Rows[1]) - Number(Rows[0]) == 1){
    		// adjacent Row Reverse
    		if(fActInpFlg == "Y" || sActInpFlg == "Y"){
				if(fPortCd == sPortCd){
					ComShowCodeMessage("VSK00023");
					return false;
				}
    		}
    		// selected 2 Port are Retrieved Port
    		if(fIbFlg == "U" && sIbFlg == "U"){
				if(fPortCd == sPortCd){
					ComShowCodeMessage("VSK00024");
					return false;
				}
    		}
    	}else{
    		// adjacent Row Reverse or first port check
    		for(var i=ComParseInt(Rows[0])+1; i<=Rows[1]; i++){
    			if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    				if(sheetObj.GetCellValue(i, prefix+"vps_port_cd") == fPortCd){
    					var actInpFlg=sheetObj.GetCellValue(i, prefix+"act_inp_flg");
	    				if(fActInpFlg == "Y" || actInpFlg == "Y"){
	    					ComShowCodeMessage("VSK00023");
	    					return false;
	    				}
	    				if(sheetObj.GetCellValue(i, prefix+"ibflag") == "U"){
    						ComShowCodeMessage("VSK00024");
    						return false;
	    	    		}
	    			}
    			}
    		}
    		// 2nd Port Check.
    		for(var i=Rows[0]; i<Rows[1]; i++){
    			if(sheetObj.GetCellValue(i, prefix+"skd_cng_sts_cd") != "S"){
    				if(sheetObj.GetCellValue(i, prefix+"vps_port_cd") == sPortCd){
    					var actInpFlg=sheetObj.GetCellValue(i, prefix+"act_inp_flg");
	        			//
	    				if(sActInpFlg == "Y" || actInpFlg == "Y"){
	    					ComShowCodeMessage("VSK00023");
	    					return false;
	    				}
	    				if(sheetObj.GetCellValue(i, prefix+"ibflag") == "U"){
    						ComShowCodeMessage("VSK00024");
    						return false;
	    	    		}
	    			}
    			}
    		}
    	}
    	return true;
    }
    /**
	 * Setting Terminal Combo Data
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param sXml
	 * @return
	 */
	function setYardCombo(sheetObj, Row, Col, sXml){
		var xmlEtcData=ComGetEtcData(sXml, "yd_kind");
		if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
			sheetObj.CellComboItem(Row,sheetObj.id+"_tml_cd", {ComboText:xmlEtcData, ComboCode:xmlEtcData} );
		}
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
     * Creating CLPT_SEQ again
     * @param sheetObj
     * @return
     */
    function resetClptSeq(sheetObj){
    	var headCnt=sheetObj.HeaderRows();
    	var rowCnt=sheetObj.RowCount();
    	var prefix=sheetObj.id + "_";
    	var idx=0;
    	var vIbFlag="";
    	for(var i=0; i<rowCnt; i++){
//    		if(sheetObj.GetCellValue(i+headCnt, prefix+"ibflag") != "D"){
//    			vIbFlag = sheetObj.GetCellValue(i+headCnt, prefix+"ibflag");
//    			idx++;
//    			sheetObj.SetCellValue(i+headCnt, prefix+"clpt_seq", idx, 0);
//    			sheetObj.SetCellValue(i+headCnt, prefix+"ibflag"  , vIbFlag, 0);
//    		}
    		if(sheetObj.GetRowStatus(i+headCnt) != "D"){
    			vIbFlag=sheetObj.GetRowStatus(i+headCnt);
    			if (vIbFlag == "R") vIbFlag = "U";
    			idx++;
    			sheetObj.SetCellValue(i+headCnt, prefix+"clpt_seq",idx,0);
    			sheetObj.SetRowStatus(i+headCnt,vIbFlag);
    		}
    	}
    }
    /**
     * Creating CLPT_IND_SEQ again
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
	    				if(sheetObj.GetCellValue(i+headCnt, prefix+"vvd") == sheetObj.GetCellValue(j+headCnt, prefix+"vvd")){
	    					if(sheetObj.GetCellValue(i+headCnt, prefix+"vps_port_cd") == sheetObj.GetCellValue(j+headCnt, prefix+"vps_port_cd")){
	    						idx++;
	    					}
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
     * Judging SKIP CALL input
     * 
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipBtnSts(sheetObj, Row){
    	var prefix=sheetObj.id + "_";
    	//Blocking Virtual Port Add Call
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
		//Blocking Actual pre Port
		if(sheetObj.GetCellValue(Row, prefix+"bfr_act_flg") == "X"){
			return false;
		}
		//Blocking Skip Port
		if(sheetObj.GetCellValue(Row, prefix+"skd_cng_sts_cd") == "S"){
			return false;
		}
		return true;
    }
    /**
     * Judging SKIP CALL input with port_skd_sts_cd
     * @param sheetObj
     * @param Row
     * @return
     */
    function isSkipPortSts(sheetObj, Row){
    	var portSts=sheetObj.GetCellValue(Row, sheetObj.id+"_port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return false;
		}
		return true;
    }
    /**
     * Judging ADD CALL input with port_skd_sts_cd
     * @param sheetObj
     * @param Row
     * @return
     */
    function isAddPortSts(sheetObj, Row){
    	if(Row != sheetObj.LastRow()){
    		var portSts=sheetObj.GetCellValue(Row+1, sheetObj.id+"_port_skd_sts_cd");
    		if(portSts == "A" || portSts == "B" || portSts == "D"){
    			return false;
    		}
    	}
		return true;
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
    		//exist in MDM_VSL_CNTR
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:1} );
    		formObj.vsl_cd.value="";
    		return false;
    	}

	}
    /**
     * Setting position(befor or after) flag when add call.
     * @param sheetObj
     * @return
     */
    function isAddPositionFlag(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var sRow=sheetObj.GetSelectRow();
    	if(sheetObj.LastRow()== sRow){
    		//Blocking Virtual Port Add Call
    		var turnPortSts=sheetObj.GetCellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts=sheetObj.GetCellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
			}
    	}else{
    		//Blocking Virtual Port Add Call
    		var turnPortSts=sheetObj.GetCellValue(sRow, prefix+"turn_port_ind_cd");
			if(turnPortSts == "F" || turnPortSts == "V" || turnPortSts == "D"){
				var bfTurnPortSts=sheetObj.GetCellValue(sRow-1, prefix+"turn_port_ind_cd");
				if(bfTurnPortSts == "F" || bfTurnPortSts == "V" || bfTurnPortSts == "D"){
					return "B";
				}
				var afTurnPortSts=sheetObj.GetCellValue(sRow+1, prefix+"turn_port_ind_cd");
				if(afTurnPortSts == "F" || afTurnPortSts == "V" || afTurnPortSts == "D"){
					return "A";
				}
			}
    	}
		//Blocking Actual Port
    	var portSts=sheetObj.GetCellValue(sRow, prefix+"port_skd_sts_cd");
		if(portSts == "A" || portSts == "B" || portSts == "D"){
			return "B";
		}else if(sheetObj.GetCellValue(sRow, prefix+"act_inp_flg") == "Y"){
			return "B";
		}
		return "";
    }
	/**
	 * Setting Font Color of Skip row
	 * @param sheetObj
	 * @param sRow
	 * @return
	 */
	function fontColorChangeBySkip(sheetObj, sRow){
		var prefix=sheetObj.id + "_";
		// sheet1
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_eta_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etb_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_etd_dt");
		cellFontToBackColor(sheetObj, sRow, prefix+"dlay_date_text");
		cellFontToBackColor(sheetObj, sRow, prefix+"vps_rmk");
//		cellFontToBackColor(sheetObj, sRow, prefix+"delay_date");
//		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_dist");
//		cellFontToBackColor(sheetObj, sRow, prefix+"lnk_spd");
//		cellFontToBackColor(sheetObj, sRow, prefix+"tztm_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"act_wrk_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"port_buf_hrs");
//		cellFontToBackColor(sheetObj, sRow, prefix+"sea_buf_hrs");
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
	 * Change Font Color to Original Font Color
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setSheetFontToOriginColor(sheetObj, Row, Col){
		sheetObj.SetCellFontColor(Row, Col,"#000000");
	}
	/**
	 * Change Data with selected 2 rows
	 * @param sheetObj
	 * @return
	 */
	function rowDataChange(sheetObj){
		var prefix=sheetObj.id + "_";
		var sRow=sheetObj.GetSelectRow();
		var headCnt=sheetObj.HeaderRows();
		var selRows=sheetObj.GetSelectionRows("|").split("|");
		if(selRows.length != 2){
			return false;
		}
		// Validation when Actual Data Reverse Call Click
		if(!isReverseCallActualPort(sheetObj, selRows)){
			return false;
		}
		var chgStsCd1=sheetObj.GetCellValue(selRows[0], prefix+"skd_cng_sts_cd");
		var chgStsCd2=sheetObj.GetCellValue(selRows[1], prefix+"skd_cng_sts_cd");
		//Column Count
		var colCnt=sheetObj.LastCol();
		var tempData="";
		// Change Data with selected 2 rows
		for(var i=0; i<colCnt; i++){
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
		// P/F Date delete.
		sheetObj.SetCellValue(selRows[0], prefix+"pf_eta_dt","",0);
		sheetObj.SetCellValue(selRows[0], prefix+"pf_etb_dt","",0);
		sheetObj.SetCellValue(selRows[0], prefix+"pf_etd_dt","",0);
		sheetObj.SetCellValue(selRows[1], prefix+"pf_eta_dt","",0);
		sheetObj.SetCellValue(selRows[1], prefix+"pf_etb_dt","",0);
		sheetObj.SetCellValue(selRows[1], prefix+"pf_etd_dt","",0);
		sheetObj.SelectCell(selRows[1], sheetObj.GetSelectCol());
		//Setting clpt_seq
		resetClptSeq(sheetObj);
		resetClptIndSeq(sheetObj);
//		sheetObj.Redraw = true;
		ComBtnDisable("btn_reverse_call");
		return true;
	}
    /**
     * Initializing except conditions
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearDescData(sheetObj, formObj, sData){
    	formObj.cre_dt.value="";
    	formObj.cre_usr_id.value = "";
    	formObj.upd_dt.value="";
    	formObj.upd_usr_id.value = "";
    	formObj.vsl_slan_cd.value="";
    	if(sData != "skd_rmk"){
    		formObj.skd_rmk.value="";
    	}
    	sheetObj.RemoveAll();
//    	sheetObj=sheetObj.Reset();
//    	sheetObj.DataInsert(-1);
    	//All Check Initializing
//    	sheetObj.CheckAll(sheetObj.id+"_del_chk") = 0;
    	initButton(sheetObj);
    }
    /**
     * Finding data which turn_port_flg is 'Y' and turn_skd_voy_no, turn_skd_dir_cd are null. Then the data format change Editable
     * 
     * @param sheetObj
     * @return
     */
    function turnEditChange(sheetObj){
    	var prefix=sheetObj.id + "_";
    	var headCnt=sheetObj.HeaderRows();
		var totCnt=sheetObj.LastRow();
		//Finding data which turn_port_flg is 'Y' and turn_skd_voy_no, turn_skd_dir_cd are null. Then the data format change Editable
		for(var i=headCnt; i<=totCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"turn_port_flg") == "Y"){
//				if(ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_voy_no")) || ComIsNull(sheetObj.CellValue(i, prefix+"turn_skd_dir_cd"))){
					sheetObj.SetCellEditable(i, prefix+"turn_skd_voy_no",1);
					sheetObj.SetCellEditable(i, prefix+"turn_skd_dir_cd",1);
//				}
			}
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

    function skdRemark_onChange(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    var prefix=sheetObj.id + "_";
	    var totCnt=sheetObj.LastRow();

	    try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "skd_rmk":
	            	if (totCnt > 1) {
	            		sheetObj.SetCellValue(1, prefix+"upd_flg","Y");
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
	 * Calculating Minutes Difference between 2 parameter based on sBaseTime
	 * 
	 * @param sBaseDate
	 * @param sSrcDate
	 * @return min
	 */
	function getTimeBetweenByMins(sBaseTime, sSrcTime){
		var timeBetween=getTimeBetween(sBaseTime, sSrcTime);
		var times=timeBetween.times;
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
		if (pfTime < 0) return 0;
		
		var delayTime=getTimeBetweenByMins(pfTime, estTime);
		if(delayTime<0){
			return delayTime*(-1);
		}else{
			return 0;
		}
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
		var timeBetween=new Object();
		var oBaseTime=getDateObj(sBaseTime);
		var oSrcTime=getDateObj(sSrcTime);
		var milliSecs=oBaseTime - oSrcTime;
		var iDay=1000 * 60 * 60 * 24;
		var iHour=1000 * 60 * 60;
		var iMin=1000 * 60;
		var iSec=1000;
		var iTmp=0;
		var times=new Array();
		if(milliSecs>0){
			timeBetween.isAdvance=true;
			timeBetween.isDelay=false;
		} else if(milliSecs<0){
			timeBetween.isDelay=true;
			timeBetween.isAdvance=false;
			milliSecs=milliSecs * -1;
		} else {
			timeBetween.isAdvance=false;
			timeBetween.isDelay=false;
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
		timeBetween.times=times;
		return timeBetween;
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
	    ComResizeSheet(sheetObjects[0]);
	}