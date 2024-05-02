/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_pri_0001.js
*@FileTitle  : Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08   
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	// global variables
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	var tabLoad = new Array();
	tabLoad[0] = 0;
	tabLoad[1] = 0;
	var subDataCnt = 0;
	var isAproUsr = false;
	var selectedGlineSeq = null;
	var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
	var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif";
	//Event handler processing by button click event */
	document.onclick = processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				if (tabObjects[0].GetSelectedIndex()== 0) {
					tab1_OnChange(tabObjects[0], 0);
				} else {
					tabObjects[0].SetSelectedIndex(0);
				}
				break;
			case "btn_new":
				doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
				break;
			case "btn_confirm":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
				break;
			case "btn_confirmcancel":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
				break;
			case "btn_copy":
				if (validateForm(sheetObjects[0],document.form,IBCOPYROW)) {
					var sUrl="/opuscntr/ESM_PRI_0006.do?" + FormQueryString(document.form);
					ComOpenPopup(sUrl, 850, 250, "", "1,0", true);
				}
				break;
            case "btns_calendar": 
    			if (comboObjects[0].GetSelectCode()== "") {
    				ComShowCodeMessage('PRI08002');
    				return false;
    			}
                var cal=new ComCalendarFromTo();
                cal.endFunction="cal_end_func";
                cal.select(formObject.eff_dt_hidden, formObject.exp_dt, 'yyyy-MM-dd');
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
	
	function cal_end_func(){
		document.form.gline_seq_text.value = document.form.eff_dt.value;
	}
	
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBTab Object as array <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * registering IBCombo Object as list <br>
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * Initializing and setting Sheet basics <br>
	 * Setting body tag's onLoad event handler <br>
	 * Adding pre-handling function after loading screen on the browser  <br>
	 */
	function loadPage() {
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		for (var i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		axon_event.addListenerForm('focus', 'obj_activate', document.form);
		axon_event.addListenerForm('keyup', 'obj_keyup', document.form );
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		toggleButtons("CLEAR");
	}
	/**
	 * handling OnBeforeActivate events <br>
	 */
	function obj_activate() {
		var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    if (srcName == "exp_dt" && formObject.exp_dt.value != "" && formObject.eff_dt_hidden.value != "") {
	    	var effDt=formObject.eff_dt_hidden.value;
	    	var expDt=formObject.exp_dt.value;
	    	formObject.eff_dt.value=formObject.eff_dt_hidden.value;
    		comboObjects[1].SetText(selectedGlineSeq, 0, effDt); 
			comboObjects[1].SetText(selectedGlineSeq, 1, expDt);
			comboObjects[1].SetText(selectedGlineSeq, 2, effDt);	 
			formObject.eff_dt_hidden.value="";
	    }
	}
	
	 function obj_keyup() {
    	 var obj=ComGetEvent();	  	  
	  	 var formObj=document.form;
 		 switch(ComGetEvent("name")) {
// 		 	case 'svc_scp_cd_text':
// 		 		obj.value=obj.value.toUpperCase();
// 		 		break;   
	  	 	case 'svc_scp_cd':
	  	 		var svcScpCdTxt=comboObjects[0].GetSelectText();
	  			if (svcScpCdTxt.length > 3) {
	  				document.form.svc_scp_nm.focus();
	  			}
	        	break;   
	  	}             
    }
	 
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//        	var comEvt = ComGetEvent();
            if (window.event == null || ComGetEvent() == null ){ // ||  comEvt.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
           
			switch (sAction) {
			case IBSEARCH_ASYNC20: // when screen loading Tab Count retrieve
				
				formObj.f_cmd.value=SEARCH10;
				subDataCnt=0;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0001GS.do", FormQueryString(formObj));
				var arrTabCnt=ComPriXml2Array(sXml, "sls_ref_cnt|grp_loc_cnt|grp_cmdt_cnt|arb_cnt|rate_cnt|goh_cnt|ctrt_cluz_cnt");
				if (arrTabCnt != null && arrTabCnt.length > 0) {
					for (var i=0; i < arrTabCnt[0].length; i++) {
						subDataCnt += parseInt(arrTabCnt[0][i]);
						if (parseInt(arrTabCnt[0][i]) > 0) {
							tabObjects[0].SetTabIcon(i,ICON_URL_EXIST);
						} else {
							tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
						}
					}
				}				
				break;
			case IBSEARCH_ASYNC10: // when screen loading Service Scope retrieve
				
				comboObjects[0].RemoveAll();
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");				
				break;
				
			case IBSEARCH_ASYNC11: // when selecting Service Scope , Duration retrieve
				
				formObj.f_cmd.value=COMMAND15;
				var sParam= FormQueryString(formObj) + "&prc_ctrt_tp_cd=S&svc_scp_cd=" + comboObjects[0].GetSelectCode()+ "&usr_id=" + formObj.usr_id.value;
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr=true;
				} else {
					isAproUsr=false;
				}				
				comboObjects[1].RemoveAll();
				comboObjects[1].InsertItem(0, "||", "X");
				comboObjects[1].SetSelectIndex(0);
				formObj.f_cmd.value=SEARCH02;
				
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0001GS.do", FormQueryString(formObj));				 				
 				ComPriXml2ComboItem(sXml, gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt", false);
				toggleButtons("NEW");
			
				break;
				
			case IBSEARCH: // retrieve				
					
				if ( ! validateForm(sheetObjects[0], document.form, sAction)) {
					ComShowCodeMessage('PRI08001');
					return false;
				}				
								
				if (comboObjects[1].GetSelectCode()== "X") {
					return false;
				}
				
				formObj.cfm_flg.value="";
				formObj.cre_dt.value="";
				formObj.cre_usr_nm.value="";
				formObj.cre_ofc_cd.value="";
				formObj.f_cmd.value=SEARCH01;
				
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0001GS.do", FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "cfm_flg|cre_dt|cre_usr_nm|cre_ofc_cd|sales_cnt|loc_cnt|cmdt_cnt|arb_cnt|rate_cnt|goh_cnt|ctrt_cnt");
								
				if (arrData != null && arrData.length > 0) {
					
					formObj.cfm_flg.value=arrData[0][0];
					formObj.cre_dt.value=arrData[0][1];
					formObj.cre_usr_nm.value=arrData[0][2];
					formObj.cre_ofc_cd.value=arrData[0][3];
					enableAllTabPages();
					subDataCnt=0;
					for (var i=4; i < arrData[0].length; i++) {
						subDataCnt += parseInt(arrData[0][i]);
					}
					if (formObj.cfm_flg.value != ""
						&& formObj.cfm_flg.value.toUpperCase() == "YES") {
						toggleButtons("CONF_YES");
					} else {
						toggleButtons("CONF_NO");
					}
					
				}				
				
				break;
				
			case IBCREATE: // New
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				comboObjects[0].SetSelectIndex(-1);
				formObj.svc_scp_nm.value="";
				comboObjects[1].RemoveAll();
				clearAllTabPages();
				toggleButtons("CLEAR");
				break;
				
			case IBSAVE: // Save
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				if (!ComPriConfirmSave()) {
					return false;
				}
				var prevEffDt=comboObjects[1].GetSelectText();

				formObj.f_cmd.value=MULTI01;
	
 				var sXml=sheetObj.GetSaveData("ESM_PRI_0001GS.do", FormQueryString(formObj));
 				sheetObjects[0].LoadSaveData(sXml);
				if (sXml.indexOf("ERROR") >= 0) {
					return false;
				}
				
				break;
				
			case IBSEARCH_ASYNC01: // Confirm
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				if (!ComPriConfirmConfirm()) {
					return false;
				}
				formObj.f_cmd.value=MULTI02;
 				var sXml=sheetObj.GetSaveData("ESM_PRI_0001GS.do", FormQueryString(formObj));
 				sheetObjects[0].LoadSaveData(sXml);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case IBSEARCH_ASYNC02: // Cancel Confirm
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				if (!ComPriConfirmCancelConfirm()) {
					return false;
				}
				formObj.f_cmd.value=MULTI03;
 				var sXml=sheetObj.GetSaveData("ESM_PRI_0001GS.do", FormQueryString(formObj));
 				sheetObjects[0].LoadSaveData(sXml);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
			case IBDELETE: // Delete
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				if (!ComPriConfirmDeleteAll()) {
					return false;
				}
				formObj.f_cmd.value=MULTI04;
 				var sXml=sheetObj.GetSaveData("ESM_PRI_0001GS.do", FormQueryString(formObj));
 				sheetObjects[0].LoadSaveData(sXml);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC11);
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        } finally {        	
        	 ComOpenWait(false);
        }
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
            with(sheetObj){
                var HeadTitle="status";
                SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
                InitColumns(cols);
                SetVisible(0);
            }
			break;
		}
	}
	/**
	 * initializing Tab setting Tab items  <br>
	 * adding case in case of multiple Tab <br>
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
                InsertItem( "Sales", "");
                InsertItem( "Location Group ", "");
                InsertItem( "Commodity Group ", "");
                InsertItem( "Arbitrary", "");
                InsertItem( "Rate", "");
                InsertItem( "G.O.H", "");
                InsertItem( "Contract Clause", "");
				SetTabIcon(0,ICON_URL_NOT_EXIST);
				SetTabIcon(1,ICON_URL_NOT_EXIST);
				SetTabIcon(2,ICON_URL_NOT_EXIST);
				SetTabIcon(3,ICON_URL_NOT_EXIST);
				SetTabIcon(4,ICON_URL_NOT_EXIST);
				SetTabIcon(5,ICON_URL_NOT_EXIST);
				SetTabIcon(6,ICON_URL_NOT_EXIST);
				tabObj.SetSelectedIndex(0);
			}
			break;
		}
	}
	/**
	 * initializing combo <br>
	 * adding case in case of multiple combo <br>
	 */
	function initCombo(comboObj, comboNo) {
		with(comboObj) {
			comboObj.SetMultiSelect(0);
			comboObj.SetUseEdit(0);
			switch(comboObj.options.id) {
		        case "svc_scp_cd":
		        	comboObj.SetDropHeight(260);
		        	comboObj.SetMaxSelect(1);
		        	comboObj.SetUseAutoComplete(1);
		        	//[NYK 2014.12.22] Upper
		        	ValidChar(2);
		            break;
		        case "gline_seq":
		        	comboObj.SetDropHeight(260);
		        	comboObj.SetUseAutoComplete(1);
		        	comboObj.SetUseEdit(1);
		            SetMaxLength(10);
		            // add 2014.07.28
		            setComnoBySlineSeq(comboObj);  
		            break;
			}
	    }
	}
	
	
	function setComnoBySlineSeq(comboObj) {
		 with(comboObj) { 
                 SetColWidth(0, "80");
                 SetColWidth(1, "100");
                 SetColWidth(2, "0");
	       }
	}
	
	
	/**
	 * checking validation process of inputed form data <br>
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			return true;
			break;
		case IBCREATE: // New
			return true;
			break;
		case IBSAVE: // Save
			if (!ComChkValid(formObj)) {
				return false;
			}
			if (comboObjects[0].GetSelectCode()== "") {
				return false;
			}
			if (formObj.eff_dt.value == "") {
				return false;
			}
			if (formObj.exp_dt.value == "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			if (formObj.eff_dt.value > formObj.exp_dt.value) {
				ComShowCodeMessage('PRI00305', '[Duration]');
				return false;
			}
			return true;
			break;
		case IBSEARCH_ASYNC01: // Confirm
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			if (subDataCnt <= 0) {
				ComShowCodeMessage("PRI08005");
				return false;
			}
			return true;
			break;
		case IBSEARCH_ASYNC02: // Cancel Confirm
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() != "YES") {
				return false;
			}
			return true;
			break;
		case IBDELETE: // Delete
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			if (formObj.cfm_flg.value.toUpperCase() == "YES") {
				return false;
			}
			return true;
			break;
		case IBCOPYROW: // Copy
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "") {
				return false;
			}
			return true;
			break;
		}
	}
	/**
	 * calling function when occurring OnSaveEnd event  <br>
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {		
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI01) {				
				var formObj = document.form;
				var selEffDt=comboObjects[1].GetSelectText();
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);				
				ComPriSaveCompleted();				
				var code = comboObjects[1].FindItem(selEffDt, 0, false);
				//comboObj.SetSelectIndex(nIdx, true);
				comboObjects[1].SetSelectCode(code, true);
			} else if (document.form.f_cmd.value == MULTI02) {
				ComPriConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI03) {
				ComPriCancelConfirmCompleted();
			} else if (document.form.f_cmd.value == MULTI04) {
				ComPriDeleteCompleted();
			}
		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function tab1_OnChange(tabObj, tabIndex) {
				
		if (beforetab != tabIndex) {
		    var objs=document.all.item("tabLayer");
		    objs[tabIndex].style.display="inline";
		    objs[beforetab].style.display="none";
		    // objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		}	
	    beforetab=tabIndex;	    
	    loadTabPage(tabIndex);
	}
	
	function loadTabPage(tabIndex) {
			
		var formObj=document.form;
		var sSvcScpCd=comboObjects[0].GetSelectCode();
		var sGlineSeq=comboObjects[1].GetSelectCode();
		if (tabIndex == null || tabIndex == "") {
			tabIndex=tabObjects[0].GetSelectedIndex();
		}
	
		var objTabWindow=ComGetObject("t" + (tabIndex + 1) + "frame").contentWindow;
				
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			var sUrl="";
			switch (tabIndex) {
			case 0:
				sUrl="ESM_PRI_0001_01.do"; 
				break;
			case 1:
				sUrl="ESM_PRI_0001_02.do"; 
				break;
			case 2:
				sUrl="ESM_PRI_0001_03.do"; 
				break;
			case 3:
				sUrl="ESM_PRI_0001_04.do"; 
				break;
			case 4:
				sUrl="ESM_PRI_0001_06.do"; 
				break;
			case 5:
				sUrl="ESM_PRI_0001_05.do"; 
				break;
			case 6:
				sUrl="ESM_PRI_0001_07.do"; 
				break;
			}
			objTabWindow.location.href=sUrl;
			return true;
		}
				
		if (sSvcScpCd != null && sSvcScpCd != "" && sGlineSeq != null && sGlineSeq != "" && parseInt(sGlineSeq) > 0) {			
			document.form.exp_dt.focus();				
			objTabWindow.tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES");			
		}
		
	}
	function clearAllTabPages() {
		for (var i=0; i < tabObjects[0].GetCount(); i++) {
			tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
			if (ComGetObject("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
				ComGetObject("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
			}
		}
	}
	function enableAllTabPages(flag) {
		if (flag == null || flag == "") {
			if (isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES") {
				flag=true;
			} else {
				flag=false;
			}
		}
		for (var i=0; i < tabObjects[0].GetCount(); i++) {
			if (ComGetObject("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
				ComGetObject("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
			}
		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function svc_scp_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code){
		var formObj=document.form;
		var arrText=code;		
		if (arrText != null && arrText.length > 1) {		
			formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
			selectedGlineSeq=null;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		}
		
//		comboObjects[1].SetSelectCode(13);
//		alert(comboObjects[1].GetItemCount());
	}
	
//	function svc_scp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
//		var svcScpCdTxt=comboObj.GetSelectText();
//		if (svcScpCdTxt.length > 3) {
//			document.form.svc_scp_nm.focus();
//		}
//	}
	 
	function svc_scp_cd_OnClear(comboObj) {
		var formObject=document.form;
		formObject.svc_scp_nm.value="";
		//comboObj.SetSelectIndex(-1);
	}
	/**
	 * calling event when focus out<br>
	 */
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj=document.form;
 		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				formObj.svc_scp_nm.value=comboObj.GetText(code, 1);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
			}
		}
	}
	/**
	 * calling function when occurring OnChange Event <br>
	 */
	function gline_seq_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		
		gline_seq_OnClear(comboObj);
		
		var selEffDt=NewText; //comboObj.GetSelectText();
		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}
		
		if (ComIsDate(selEffDt)) {
			var formObj=document.form;
			if(NewCode != "") { //select
				formObj.eff_dt.value=comboObj.GetText(NewCode, 0);
				formObj.exp_dt.value=comboObj.GetText(NewCode, 1);
				
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);		
				if (tabObjects[0].GetSelectedIndex()== 0) {
					 tab1_OnChange(tabObjects[0], 0);
				} else {
					tabObjects[0].SetSelectedIndex(0);
				}
				setTabStyle();
				
			} else { //manual input
				selEffDt=selEffDt.replace(/-/gi, "");
				selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
				document.form.eff_dt.value=selEffDt;
				
				var nIdx = comboObj.FindItem(selEffDt, 0, true);
				if( nIdx == -1) {
					comboObj.InsertItem(comboObj.GetItemCount(), document.form.eff_dt.value, "X");
					comboObj.SetSelectIndex(comboObj.GetItemCount() - 1, false);
				} else {
					comboObj.SetSelectIndex(nIdx, true);
				}
				
			}
		} else {
			ComShowCodeMessage("COM12134", "Effective Date");
			return false;
		}
		
		setComnoBySlineSeq(comboObj);
		
	}
	
	function gline_seq_OnClear(comboObj) {
				
		var formObj=document.form;
		//comboObj.SetSelectIndex(-1);
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.cfm_flg.value="";
		formObj.cre_dt.value="";
		formObj.cre_usr_nm.value="";
		formObj.cre_ofc_cd.value="";
		clearAllTabPages();
	}
	
	
//	function gline_seq_OnKeyUp(comboObj, KeyCode, Shift) {
//				
//		var selEffDt=comboObj.GetSelectText();
//		if (selEffDt.search(/[^0-9]/gi) >= 0) {
//			selEffDt=selEffDt.replace(/[^0-9]/gi, "");
//			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//		}
//		if (selEffDt.length == 8) {
//			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//			document.form.exp_dt.focus();
//		}
//		
//		setComnoBySlineSeq(comboObj);
//		
//	}
	
	
//	function gline_seq_OnFocus(comboObj) {
//				
//		var selEffDt=comboObj.GetSelectText();
//		if (selEffDt != null && selEffDt != "") {
//			selEffDt=selEffDt.replace(/-/gi, "");
//			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//		}
//		
//		setComnoBySlineSeq(comboObj);
//	}
//	
	
	/**
	 * calling event when focus out<br>
	 */
//	function gline_seq_OnBlur(comboObj) {
//				
//		var selEffDt=comboObj.GetSelectText();
//		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
//			return false;
//		}
//		if (ComIsDate(selEffDt)) {
//			selEffDt=selEffDt.replace(/-/gi, "");
//			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
//			document.form.eff_dt.value=selEffDt;
//			//alert(selectedGlineSeq):
//		//	comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//		} else {
//			ComShowCodeMessage("COM12134", "Effective Date");
//			return false;
//		}
//		
//		setComnoBySlineSeq(comboObj);
//		
//	}
	/**
	 * handling all buttons Enalbe/Disable <br> <br>
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			enableButton("btn_new");
			disableButton("btn_save");
			disableButton("btn_confirm");
			disableButton("btn_confirmcancel");
			disableButton("btn_delete");
			disableButton("btn_copy");
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			enableButton("btn_confirm");
			enableButton("btn_confirmcancel");
			enableButton("btn_delete");
			enableButton("btn_copy");
			break;
		case "NEW":
			disableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			disableButton("btn_confirm");
			disableButton("btn_confirmcancel");
			disableButton("btn_delete");
			disableButton("btn_copy");
			break;
		case "CONF_YES":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			disableButton("btn_save");
			disableButton("btn_confirm");
			enableButton("btn_confirmcancel");
			disableButton("btn_delete");
			enableButton("btn_copy");
			break;
		case "CONF_NO":
			enableButton("btn_retrieve");
			enableButton("btn_new");
			enableButton("btn_save");
			enableButton("btn_confirm");
			disableButton("btn_confirmcancel");
			enableButton("btn_delete");
			enableButton("btn_copy");
			break;
		}
		if (!isAproUsr) {
			//enableButton("btn_retrieve");
			disableButton("btn_new");
			disableButton("btn_save");
			disableButton("btn_confirm");
			disableButton("btn_confirmcancel");
			disableButton("btn_delete");
			disableButton("btn_copy");
		}
	}
	function getSvcScpCd() {
		return comboObjects[0].GetSelectCode();
	}
	function getGlineSeq() {
		return comboObjects[1].GetSelectCode();
	}
	function getEffDt() {
		return document.form.eff_dt.value;
	}
	function getExpDt() {
		return document.form.exp_dt.value;
	}
	function getCfmFlg() {
		var formObj=document.form;
		if (formObj.cfm_flg.value != "" && formObj.cfm_flg.value.toUpperCase() == "YES") {
			return "Y";
		} else {
			return "N"
		}
	}
	function setTabStyle() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC20);
	}
	function reloadPostCopy(svcScpCd, glineSeq) {
		var formObj=document.form;
		if (svcScpCd == null || svcScpCd == "" || glineSeq == null || glineSeq == "") {
			return false;
		}
		comboObjects[0].SetSelectCode(svcScpCd,false);
		svc_scp_cd_OnChange(comboObjects[0], null, null, null, glineSeq, comboObjects[0].GetText(svcScpCd, 0), svcScpCd);
		svc_scp_cd_OnBlur(comboObjects[0]);
		comboObjects[1].SetSelectCode(glineSeq);
	}
