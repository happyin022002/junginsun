/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2018.js
*@FileTitle  :  RFA Guideline Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class Guideline Creation : business script for Guideline Creation
	 */
	// Common Global Variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	var subDataCnt=0;
	var isAproUsr=false;
	var selectedGlineSeq=null;
	var ICON_URL_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon2.gif";
	var ICON_URL_NOT_EXIST="http://" + location.hostname + ":" + location.port + "/opuscntr/img/tab_icon1.gif";
	var isScopeYear="";
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheet_obj Mandatory IBSheet Object
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBTab Object as list <br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setTabObject(tab_obj);
	 * </pre>
	 * @param {ibtab} tab_obj Mandatory IBTab Object
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * registering IBCombo Object as list <br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setComboObject(combo_obj);
	 * </pre>
	 * @param {ibcombo} combo_obj Mandatory IBCombo Object
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet <br>
	 * implementing onLoad event handler in body tag <br>
	 * adding first-served functions after loading screen. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function loadPage() {
		for (var i=0; i < sheetObjects.length; i++) {
			initSheet(sheetObjects[i], i + 1);
		}
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerForm('focusout', 'obj_focusout', document.form);
//		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
	}
	/**
	 * Handling OnKeyPress<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_keypress();
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
//	function obj_keypress() {
//		switch (event.srcElement.dataformat) {
//		case "float":
//				ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//		default:
//			ComKeyOnlyNumber(event.srcElement);
//			break;
//		}
//	}
	/**
	 * Handling OnBeforeActivate event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_activate()
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
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
	    	ComClearSeparator (ComGetEvent());
	    } else if (srcName == "scope_year") {
	    	ComClearSeparator (ComGetEvent());
	    	isScopeYear=( ComIsNull(formObject.scope_year.value) ? "" : formObject.scope_year.value );
	    }
	}
	/**
	 * Handling Onbeforedeactivate event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
	function obj_deactivate() {
		var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    var svcScpCd=svc_scp_cd.GetSelectCode();
	    ComChkObjValid(ComGetEvent());
	}
	/**
	 * Handling OnfocusOut event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_focusout()
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
	function obj_focusout() {
		var formObject=document.form;
	    var srcName=ComGetEvent("name");
	    var svcScpCd=svc_scp_cd.GetSelectCode();
	    ComChkObjValid(ComGetEvent());
	    if (srcName == "scope_year") {
	    	var sYear=( ComIsNull ( formObject.scope_year.value ) ? "" : formObject.scope_year.value );
	    	if (isScopeYear != sYear ) {
				selectedGlineSeq=null;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
	    	}
	    }
	}
	/**
	 * Handling sheet's processes <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
        	var objEvt = ComGetEvent();
        	 if (window.event == null || window.event.srcElement == null || $(objEvt).attr('suppressWait')!= "Y") {
        		ComOpenWait(true);
        	   }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
			case IBSEARCH_ASYNC20: 
				formObj.f_cmd.value=SEARCH10;
				subDataCnt=0;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2018GS.do", FormQueryString(formObj));
				var arrTabCnt=ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|arb_cnt|rate_cnt");
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
			case IBSEARCH_ASYNC10: // Retrieving service scope when loading screen
				comboObjects[0].RemoveAll();
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
				break;
			case IBSEARCH_ASYNC11: // Service Scope selection시, Duration조회
				formObj.f_cmd.value=COMMAND15;
				var sParam = FormQueryString(formObj) + "&prc_ctrt_tp_cd=R&svc_scp_cd=" + comboObjects[0].SetSelectCode+ "&usr_id=" + formObj.usr_id.value;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr=true;
				} else {
					isAproUsr=false;
				}
				
				try {
					gline_seq.RemoveAll();
				} catch (e) {
				}
				
				gline_seq.InsertItem(0, "||", "X");
				gline_seq.SetSelectCode("X");
				
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2018GS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt", false);
				
				break;
			case IBSEARCH: // Retrieving
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
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
				var sXml=sheetObj.GetSearchData("ESM_PRI_2018GS.do", FormQueryString(formObj));
				var arrData=ComPriXml2Array(sXml, "cfm_flg|cre_dt|cre_usr_nm|cre_ofc_cd|sales_cnt|loc_cnt|cmdt_cnt|arb_cnt|rate_cnt|goh_cnt|ctrt_cnt");
				if (arrData != null && arrData.length > 0) {
					formObj.cfm_flg.value=arrData[0][0];
					formObj.cre_dt.value=arrData[0][1];
					formObj.cre_usr_nm.value=arrData[0][2];
					formObj.cre_ofc_cd.value=arrData[0][3];
					enableAllTabPages(true);
					subDataCnt=0;
					for (var i=4; i < arrData[0].length; i++) {
						subDataCnt += parseInt(arrData[0][i]);
					}
				}
				break;
			case IBCREATE: // New
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				comboObjects[0].SetSelectIndex(-1);
				formObj.svc_scp_nm.value="";
				formObj.scope_year.value="";
				comboObjects[1].RemoveAll();
				clearAllTabPages();
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
		        	if (location.hostname != "")
//			      (1, 0, 0, true);
			      var HeadTitle="status";
		
			      SetConfig( { SearchMode:2, Page:20, DataRowMerge:1 } );
		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			       
			      InitColumns(cols);		
			      SetVisible(false);
	            }
			break;
		}
	}
	/**
	 * setting tab initial values .  <br>
	 * adding case as numbers of counting tabs <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initTab(tabObj,1);
	 * </pre>
	 * @param {tabObj} tabObj Mandatory IBTab Object
	 * @param {int} tabNo Mandatory IBTab Object ,Serial no for Tag's ID
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
				InsertItem( "Location Group ", "");
				InsertItem( "Commodity Group ", "");
				InsertItem( "Arbitrary", "");
				InsertItem( "Rate", "");
//no support[implemented common]CLT 				ShowIcon=true;
//no support[check again]CLT 				UseLargeIcon=false;
				SetTabIcon(0,ICON_URL_NOT_EXIST);
				SetTabIcon(1,ICON_URL_NOT_EXIST);
				SetTabIcon(2,ICON_URL_NOT_EXIST);
				SetTabIcon(3,ICON_URL_NOT_EXIST);
			}
			break;
		}
	}
	/**
	 * setting combo initial values <br>
	 * adding case as numbers of counting combo<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initCombo(comboObj, comboNo);
	 * </pre>
	 * @param {ibcombo} sheetObj Mandatory IBSheet Object
	 * @param {int} ComboNo Mandatory IBCombo Object ,Serial no for Tag's ID
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "svc_scp_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	ValidChar(2);
	            	SetMaxLength(3);
	            }
	            break;
	        case "gline_seq":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(0);
	            	SetColWidth(0, "80");
	            	SetColWidth(1, "100");
	            	SetColWidth(2, "0");
	            }
	            break;
	    }
	}
	/**
	 * handling process for input validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *         handling logic;
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : invalid
	 * @author 
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // Retrieving
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "X") {
				return false;
			}
			return true;
			break;
		case IBCREATE: // New
			return true;
			break;
		}
	}
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory
	 * @param {int} text Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function tab1_OnChange(tabObj, tabIndex) {
		if (beforetab != tabIndex) {
		    var objs=document.all.item("tabLayer");
		    objs[tabIndex].style.display="inline";
		    objs[beforetab].style.display="none";
		    //objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
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
		var objTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			var sUrl="";
			switch (tabIndex) {
			case 0:
				sUrl="ESM_PRI_2018_01.do"; 
				break;
			case 1:
				sUrl="ESM_PRI_2018_02.do"; 
				break;
			case 2:
				sUrl="ESM_PRI_2018_03.do"; 
				break;
			case 3:
				sUrl="ESM_PRI_2018_04.do"; 
				break;
			}
			objTabWindow.location.href=sUrl;
			return true;
		}
		if (sSvcScpCd != null && sSvcScpCd != "" && sGlineSeq != null && sGlineSeq != "" && parseInt(sGlineSeq) > 0) {
			document.form.exp_dt.focus();
			if (objTabWindow.tabLoadSheet) {
				objTabWindow.tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr && document.form.cfm_flg.value.toUpperCase() != "YES");
			}
		}
	}
	function clearAllTabPages() {
		for (var i=0; i < tabObjects[0].GetCount(); i++) {
			tabObjects[0].SetTabIcon(i,ICON_URL_NOT_EXIST);
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
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
			if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
				document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
			}
		}
	}
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory
	 * @param {int} text Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var formObj=document.form;
		var arrText=newCode;
		if (arrText != null && arrText.length > 1) {
			formObj.exp_dt.value = '';
			formObj.svc_scp_nm.value=comboObj.GetText(newCode, 1);
			selectedGlineSeq=null;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		}
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
		comboObj.SetSelectIndex(-1);
	}
	/**
	 * calling event in case of onBlur Event for svc_scp_cd<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    ssvc_scp_cd_OnBlur(comboObj);
	 * </pre>
	 * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory 
	 * @param {int} text Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function gline_seq_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, text, code) {
		var formObj=document.form;
		selectedGlineSeq=code;
		if (code == "" || text == "") {
			return;
		}
		var effText=comboObj.GetText(code, 0);
		var expText=comboObj.GetText(code, 1);
		formObj.eff_dt.value=effText;
		formObj.exp_dt.value=expText;
		if (code == null || code == "" || code == "X") {
			return true;
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		if (tabObjects[0].GetSelectedIndex()== 0) {
			tab1_OnChange(tabObjects[0], 0);
		} else {
			tabObjects[0].SetSelectedIndex(0);
		}
		setTabStyle();
	}
	function gline_seq_OnClear(comboObj) {
		var formObj=document.form;
		comboObj.SetSelectCode("X");
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.cfm_flg.value="";
		formObj.cre_dt.value="";
		formObj.cre_usr_nm.value="";
		formObj.cre_ofc_cd.value="";
		clearAllTabPages();
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
		svc_scp_cd_OnChange(comboObjects[0], svcScpCd, comboObjects[0].GetText(svcScpCd, 0) + "|" + comboObjects[0].GetText(svcScpCd, 1));
		svc_scp_cd_OnBlur(comboObjects[0]);
		comboObjects[1].SetSelectCode(glineSeq);
	}
