	/*=========================================================
	*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
	*@FileName   : ESM_CSQ_0201.js
	*@FileTitle  : Basic CMCB_COA UC PFMC Retrieve
	*@author     : CLT
	*@version    : 1.0
	*@since      : 2015/02/05
	=========================================================*/	
	/****************************************************************************************
	  ì�´ë²¤íŠ¸ êµ¬ë¶„ ì½”ë“œ: [ì´ˆê¸°í™”]INIT=0; [ìž…ë ¥]ADD=1; [ì¡°íšŒ]SEARCH=2; [ë¦¬ìŠ¤íŠ¸ì¡°íšŒ]SEARCHLIST=3;
						[ìˆ˜ì •]MODIFY=4; [ì‚­ì œ]REMOVE=5; [ë¦¬ìŠ¤íŠ¸ì‚­ì œ]REMOVELIST=6 [ë‹¤ì¤‘ì²˜ë¦¬]MULTI=7
						ê¸°íƒ€ ì—¬ë¶„ì�˜ ë¬¸ìž�ìƒ�ìˆ˜  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/*------------------ë‹¤ì�Œ ì½”ë“œëŠ” JSDocì�„ ìž˜ ë§Œë“¤ê¸° ìœ„í•´ì„œ ì¶”ê°€ë�œ ì½”ë“œìž„ ------------------*/
	/**
	 * @extends 
	 * @class ESM_CSQ_0201 : ESM_CSQ_0201 ìƒ�ì„±ì�„ ìœ„í•œ í™”ë©´ì—�ì„œ ì‚¬ìš©í•˜ëŠ” ì—…ë¬´ ìŠ¤í�¬ë¦½íŠ¸ë¥¼ ì •ì�˜í•œë‹¤.
	 */
	/* ê°œë°œìž� ìž‘ì—…	*/
	//ê³µí†µì „ì—­ë³€ìˆ˜
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var max=0;
	var params="";
	var qtaWeekArr0201=new Array();
	qtaWeekArr0201["1Q"]=new Array("00","13");
	qtaWeekArr0201["2Q"]=new Array("14","26");
	qtaWeekArr0201["3Q"]=new Array("27","39");
	qtaWeekArr0201["4Q"]=new Array("40","53");
	/* ë²„íŠ¼í�´ë¦­ì�´ë²¤íŠ¸ë¥¼ ë°›ì•„ ì²˜ë¦¬í•˜ëŠ” ì�´ë²¤íŠ¸í•¸ë“¤ëŸ¬ ì •ì�˜ */
	document.onclick=processButtonClick;
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "f_bse_tp_cd":
					f_bse_tp_cd_OnChange();
					break;	
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;
				case "btn_Creation":
					doActionIBSheet(sheetObject, formObj, MULTI01);
					break;
				case "btn_AddCreation":
					doActionIBSheet(sheetObject, formObj, MULTI02);
					break;
				case "btn_Downexcel":
					if(sheetObject.RowCount() < 1) {
						 ComShowCodeMessage("COM132501");
					} else{
						doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
					}
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	* IBSheet Object ë¥¼ ë°°ì—´ë¡œ ë“±ë¡�
	* í–¥í›„ ë‹¤ë¥¸ í•­ëª©ë“¤ì�„ ì�¼ê´„ì²˜ë¦¬í•  í•„ìš”ê°€ ìžˆì�„ ë•Œ ë°°ì—´ë¡œ ë‹´ëŠ” í”„ë¡œì„¸ìŠ¤ë¥¼ ì¶”ê°€í•  ìˆ˜ ìžˆë‹¤
	* ë°°ì—´ì�€ ì†ŒìŠ¤ ìƒ�ë‹¨ì—� ì •ì�˜
	*/
	function setSheetObject(sheet_obj){
	 sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	* IBSheet Object ë¥¼ ë°°ì—´ë¡œ ë“±ë¡�
	* í–¥í›„ ë‹¤ë¥¸ í•­ëª©ë“¤ì�„ ì�¼ê´„ì²˜ë¦¬í•  í•„ìš”ê°€ ìžˆì�„ ë•Œ ë°°ì—´ë¡œ ë‹´ëŠ” í”„ë¡œì„¸ìŠ¤ë¥¼ ì¶”ê°€í•  ìˆ˜ ìžˆë‹¤
	* ë°°ì—´ì�€ ì†ŒìŠ¤ ìƒ�ë‹¨ì—� ì •ì�˜
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	function loadPage(){
		var formObj=document.form;
		loadingMode=true;
		for(i=0;i<sheetObjects.length;i++){
			//khlee-ì‹œìž‘ í™˜ê²½ ì„¤ì • í•¨ìˆ˜ ì�´ë¦„ ë³€ê²½
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-ë§ˆì§€ë§‰ í™˜ê²½ ì„¤ì • í•¨ìˆ˜ ì¶”ê°€
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		toggleButtons("INIT");
		loadingMode=false;
		resizeSheet();
	}
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:		//sheet1 init
			    with(sheetObj){
		        var HeadTitle1="STS|Trade|Sub Trade|R.Lane|P/F SKD Group|P/F SKD Ver.|Route";
		        SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		        var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        InitHeaders(headers, info);
		        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pf_grp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pf_svc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:600,  Align:"Left",    ColMerge:0,   SaveName:"pf_rout_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(350);
		        }
				break;
		}
	}
	/**
	* ë©€í‹°ì½¤ë³´ í•­ëª©ì�„ ì„¤ì •í•œë‹¤.
	*/
	function initCombo(comboObj, comboId) {
		switch(comboObj.options.id) {
			case "f_bse_yr":
			case "f_bse_qtr_cd":
				with (comboObj) {
					SetDropHeight(300);
				}
				break;
			default:
				with (comboObj) {
					SetDropHeight(300);
					SetSelectIndex(0);
					ValidChar(2);
				}
				break;
		}
	}
	/**
	* Sheet ê´€ë ¨ í”„ë¡œì„¸ìŠ¤ ì²˜ë¦¬
	*/
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          // í™”ë©´ ì ‘ì†� ì‹œ
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_CSQ_0201GS.do", FormQueryString(formObj));
				//var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);        
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
				if (arrXml.length > 2)
					ComSetYearQta(arrXml[2]);
				ComOpenWait(false);
				break;
			case IBSEARCH:          // í™”ë©´ ì¡°íšŒ ì‹œ
				formObj.f_cmd.value=SEARCH;
				var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
				var qta = ComGetObjValue(f_bse_qtr_cd);
				if(bse_tp_cd == "Y"){
					formObj.f_fm_wk.value="00";
					formObj.f_to_wk.value="";
				}else{
					formObj.f_fm_wk.value= qtaWeekArr0201[qta][0];
					formObj.f_to_wk.value= qtaWeekArr0201[qta][1];
				}
				searchParams=FormQueryString(formObj);
				ComOpenWait(true);
				setTimeout(function(){
					var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0201GS.do",searchParams);
					sheetObj.LoadSearchData(rtnXml,{Sync:1} );
					var etcData=getEtcData(rtnXml);
					if (etcData["dataCnt"] == 0) {
						toggleButtons("SEARCH01");
					} else {
						toggleButtons("SEARCH02");
					}
					ComOpenWait(false);
				}, 100);
				
				ComOpenWait(false);
				break;
			case IBDOWNEXCEL:		// ì—‘ì…€ ë‹¤ìš´ë¡œë“œ
				ComOpenWait(true);
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObj), SheetDesign:1,Merge:1 });
				ComOpenWait(false);
				break;
			case MULTI01:		// Creation
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI01);
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0201GS.do", searchParams);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != null && backendJobKey.length > 0) {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(3600);//ì´ˆ - 1ì‹œê°„
					backEndJobTimer=setInterval(getBackEndJobStatus, 5000);	//ë°€ë¦¬ì´ˆ  - 10ì´ˆ
				}
				break;
			case MULTI02:		// Add-Creation
				if (!validateForm(sheetObj, formObj, sAction)) return;
				if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				ComSetSearchParams("f_cmd", MULTI02);
				ComSetSearchParams("f_rlane_cd", f_rlane_cd.GetSelectCode());
				var sXml=sheetObj.GetSaveData("ESM_CSQ_0201GS.do", searchParams);
				var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				ComOpenWait(false);
				if (State == "S") {
					ComShowCodeMessage("CSQ00010", "Data");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				} else if (State != "S") {
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}
				break;
	  }
	}
	/**
	* onChange event
	* f_sub_trd_cd ë°”ë€Œì—ˆì�„ë•Œ  f_lane_cd ì½¤ë³´ì¡°íšŒ
	*/	
	function f_sub_trd_cd_OnChange(obj, value, text) {
	 	var formObj=document.form;
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	if(f_sub_trd_cd.GetSelectText()== "All"){
	 		f_rlane_cd.RemoveAll();
	 	}else{
		 	var param="f_cmd=" + SEARCH01
		     + "&code_name=rLaneSector"
		     + "&code_param="+trd_cd+"|"
		     				+f_bse_tp_cd+"|"
		     				+f_bse_yr+"|"
		     				+f_bse_qtr_cd+"|"
		     			    +f_sub_trd_cd.GetSelectCode()
		     + "&all_flag=";
		 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");		
		 	f_rlane_cd.SetMultiSelect(1);
	 	}	
	 }
	/**
	* f_bse_yrê°€ ë°”ë€Œì—ˆì�„ë•Œ period ì�˜ year ë³€ê²½
	*/
	function f_bse_yr_OnChange(obj, value, text) {
		var formObj=document.form;
		period_change();
		setSubTradeCombo();
	}
	/**
	* f_bse_qtr_cd ë°”ë€Œì—ˆì�„ë•Œ period ì�˜ week ê¸°ê°„ë³€ê²½
	*/
	function f_bse_qtr_cd_OnChange(obj, value, text) {
		var formObj=document.form;
		period_change();
		setSubTradeCombo();
	}
	/**
	 * f_bse_tp_cd ë°”ë€Œì—ˆì�„ë•Œ qtr_cd, week ë³€ê²½
	 */
	function f_bse_tp_cd_OnChange() {
		var formObj=document.form;
		var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var div_qtr=document.getElementById("div_qtr");
		var div_period=document.getElementById("div_period");
		if (bse_tp_cd == "Y") {
			div_qtr.style.display="none";
			div_period.style.display="none";
			//f_bse_qtr_cd.style.display="none";
			f_bse_qtr_cd.SetVisible(0);
		} else {
			div_qtr.style.display="inline";
			div_period.style.display="inline";
			// f_bse_qtr_cd.style.display="inline";
			f_bse_qtr_cd.SetVisible(1);
		}
		period_change();
		setSubTradeCombo();
	}
	/**
	 *  f_bse_tp_cd, f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
	 */
	function setSubTradeCombo(){
	 	var formObj=document.form;
		var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
		var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
		var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
		
	 	if ( trd_cd != ""  && trd_cd != "All" ) {
		 	var param="f_cmd=" + SEARCH01
		     + "&code_name=subTradeSector"
		     + "&code_param="+trd_cd+"|"
		     				+f_bse_tp_cd+"|"
		     				+f_bse_yr+"|"
		     				+f_bse_qtr_cd
		     + "&all_flag=All";
	        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
		 	f_sub_trd_cd.SetSelectIndex(0);
	 	} else {
	 		f_sub_trd_cd.RemoveAll();
	 		f_sub_trd_cd.InsertItem(0, "All", "All");
	 		f_sub_trd_cd.SetSelectIndex(0);
	 	}
	}
	 /**
	  * í™”ë©´ í�¼ìž…ë ¥ê°’ì—� ëŒ€í•œ ìœ íš¨ì„±ê²€ì¦� í”„ë¡œì„¸ìŠ¤ ì²˜ë¦¬
	  */
	 function validateForm(sheetObj, formObj, sAction){
	 	switch(sAction) {
	 		case MULTI02:  // Add-Creation
	 			var rlaneCd=f_rlane_cd.GetSelectCode();
	 			rlaneCd=rlaneCd.replace(/,/gi,"");
	 			//í•œê°œì�˜ laneë§Œ ì„ íƒ�í–ˆëŠ”ì§€ ì²´í�¬
	 			if(rlaneCd.length != 5){
	 				ComShowCodeMessage('CSQ00045');
	 				return false;
	 			}
	     	break;	
	 	}
	 	return true;
	 }
	/**
	 * í™”ë©´ì�˜ ëª¨ë“  ë²„íŠ¼ë“¤ì�˜ Enable/Disableì�„ ì²˜ë¦¬
	 */
	function toggleButtons(step) {
	   switch (step) {
		   case "INIT":
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_Downexcel");
		       break;
		   case "SEARCH01": //ì¡°íšŒ í›„ Cntê°€ 0 ì�¼ë•Œ 
		       ComBtnEnable("btn_Retrieve");
		       ComBtnEnable("btn_Creation");
		       ComBtnDisable("btn_AddCreation");
		       ComBtnDisable("btn_Downexcel");
		       break;
		   case "SEARCH02": //ì¡°íšŒ í›„ Cntê°€ 0ì�´ ì•„ë‹�ë•Œ 
		       ComBtnEnable("btn_Retrieve");
		       ComBtnDisable("btn_Creation");
		       ComBtnEnable("btn_AddCreation");
		       ComBtnEnable("btn_Downexcel");
		       break;
	   }
	}
	/**
	* BackEndJob ê´€ë ¨ Status='3' ì�´ ë� ë•Œê¹Œì§€ í™•ì�¸í•œë‹¤.<br>
	*/     
	function getBackEndJobStatus() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("ESM_CSQ_0201GS.do", "f_cmd=" + SEARCH01 + "&backendjob_key=" + formObj.backendjob_key.value);
		var jobState=ComGetEtcData(sXml, "jb_sts_flg");
		var errMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
		if (jobState == "3") {
			ComShowCodeMessage("CSQ00010", "Data");
			clearInterval(backEndJobTimer);
			ComOpenWait(false);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else if (jobState == "4") {
			ComShowCodeMessage("CSQ00038", errMsg);
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
		} else if (jobState == "5") {
			ComShowCodeMessage("CSQ00039");
			ComOpenWait(false);
			clearInterval(backEndJobTimer);
		}
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i], 60);
	    }
	}
	/* ê°œë°œìž� ìž‘ì—…  ë�� */
