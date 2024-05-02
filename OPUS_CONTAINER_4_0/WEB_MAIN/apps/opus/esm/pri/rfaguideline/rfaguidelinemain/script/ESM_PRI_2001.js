/*=========================================================
 ** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2001.js
*@FileTitle  :  RFA Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
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
	// global variables
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
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
	function loadPage() {
		for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		for (var i=0; i < sheetObjects.length; i++) {
			initSheet(sheetObjects[i], i + 1);
		}
		for (var k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			tabObjects[k].SetSelectedIndex(0);
		}
	    
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		axon_event.addListenerForm('blur', 'obj_focusout', document.form);
		toggleButtons("CLEAR");
		
//		$("#gline_seq_text").on("keyup", function(){
//			var comboObj = comboObjects[1];
//			var selEffDt=comboObj.GetSelectText();
//			if (selEffDt.search(/[^0-9]/gi) >= 0) {
//				selEffDt=selEffDt.replace(/[^0-9]/gi, "");
//				comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//				comboObj.SetText(selectedGlineSeq, 0, selEffDt);
//			}
//			if (selEffDt.length == 8) {
//				comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//				comboObj.SetText(selectedGlineSeq, 0, selEffDt);
//			}
//			comboObj.SetViewText(selEffDt);
//		});
	}
	
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
					var sUrl = "/opuscntr/ESM_PRI_2002.do?svc_scp_cd=" + svc_scp_cd.GetSelectCode() + "&gline_seq=" + gline_seq.GetSelectCode();
					ComOpenPopup(sUrl, 800, 340, "", "1,0", true);
				}
				break;
            case "btns_calendar": 
    			if (comboObjects[0].GetSelectCode()== "") {
    				ComShowCodeMessage('PRI08002');
    				return false;
    			}
                var cal = new ComCalendarFromTo();
                cal.endFunction="cal_end_func";
                cal.select(formObject.eff_dt, formObject.exp_dt, 'yyyy-MM-dd');
                
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
		document.form.eff_dt_hidden.value = document.form.eff_dt.value;
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
				isScopeYear = sYear;
	    	}
	    }
	}
	/**
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
        	if (window.event == null || ComGetEvent() == null /*|| ComGetEvent("suppressWait") != "Y"*/) {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
			case IBSEARCH_ASYNC20: // retrieving Tab Count when screen loading
				formObj.f_cmd.value=SEARCH10;
				subDataCnt=0;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2001GS.do", FormQueryString(formObj));
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
			case IBSEARCH_ASYNC10: // retrieving Service Scope when screen loading
				comboObjects[0].RemoveAll();
				formObj.f_cmd.value=SEARCH01;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, svc_scp_cd, "cd", "cd|nm");
				break;
			case IBSEARCH_ASYNC11: // retrieving Duration when selecting Service Scope 
				formObj.f_cmd.value=COMMAND15;
				var sParam = FormQueryString(formObj) + "&prc_ctrt_tp_cd=R&svc_scp_cd=" + comboObjects[0].SetSelectCode+ "&usr_id=" + formObj.usr_id.value;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr=true;
				} else {
					isAproUsr=false;
				}
				gline_seq.RemoveAll();
				gline_seq.InsertItem(0, "||", "X");
				gline_seq.SetSelectCode("X");
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2001GS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt", false);
				toggleButtons("NEW");
				break;
			case IBSEARCH: // retrieve
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
				var sXml=sheetObj.GetSearchData("ESM_PRI_2001GS.do", FormQueryString(formObj));
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
				formObj.scope_year.value="";
				comboObjects[1].RemoveAll();
				//comboObjects[1].InsertItem(0, "||", "X");
				//comboObjects[1].Index = 0;
				//comboObjects[1].Code = "X";
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
				$("#gline_seq").val($("#gline_seq").val().replace(",", ""));
				var sXml=sheetObj.GetSaveData("ESM_PRI_2001GS.do", FormQueryString(formObj));
				sheetObjects[0].LoadSaveData(sXml, true);
//				if (sXml.indexOf("ERROR") >= 0) {
//					return false;
//				}
//				formObj.f_cmd.value=SEARCH02;
//				sXml=sheetObj.GetSearchData("ESM_PRI_2001GS.do", FormQueryString(formObj));
//				ComPriXml2ComboItem(sXml, gline_seq, "gline_seq", "eff_dt|exp_dt|eff_dt");
//				comboObjects[1].InsertItem(0, "||", "X");
//				var code=comboObjects[1].FindItem(prevEffDt, 0);
//				if (code == null || code == "" || code == "X") {
//					comboObjects[1].SetSelectIndex(0);
//				} else {
//					comboObjects[1].SetSelectCode(code);
//					gline_seq_OnChange(comboObjects[1], code, comboObjects[1].GetText(code, 1));
//				}
				break;
			case IBSEARCH_ASYNC01: // Confirm
				if (!validateForm(sheetObjects[0],document.form,sAction)) {
					return false;
				}
				if (!ComPriConfirmConfirm()) {
					return false;
				}
				formObj.f_cmd.value=MULTI02;
				var sXml=sheetObj.GetSaveData("ESM_PRI_2001GS.do", FormQueryString(formObj));
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
				var sXml=sheetObj.GetSaveData("ESM_PRI_2001GS.do", FormQueryString(formObj));
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
				var sXml=sheetObj.GetSaveData("ESM_PRI_2001GS.do", FormQueryString(formObj));
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
			if (location.hostname != "")
			(1, 0, 0, true);
			var HeadTitle="status";
			var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers=[ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
			InitColumns(cols);			
			SetConfig( { SearchMode:2, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
			var headers = [ ];
			InitHeaders(headers, info);

			var cols = [  ];
			 
			InitColumns(cols);

			SetVisible(false);
			break;
			}
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
	 * initializing combo <br>
	 * adding case in case of multiple combo <br>
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
	            }
	            break;
	        case "gline_seq":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(0);
	            	setComnoBySlineSeq(comboObj);
	            }
	            break;
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
			if (comboObjects[0].GetSelectCode()== "" || comboObjects[1].GetSelectCode()== "" ||comboObjects[1].GetSelectCode()== "X") {
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
	
//	function tab1_OnChange(tabObj , nItem)
//    {
//        var objs=document.all.item("tabLayer");
//	     objs[nItem].style.display="Inline";
//	     objs[beforetab].style.display="none";
//	     var idx = 0;
//	     for(idx; idx < objs.length; idx++){
//	         if(idx != nItem){
//	          objs[idx].style.display="none";
//	          objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
//	         }
//	        }
//	     beforetab=nItem;
//    }
	
	function tab1_OnChange(tabObj, tabIndex) {
		if (beforetab != tabIndex) {
		    var objs=document.all.item("tabLayer");
		    objs[tabIndex].style.display="inline";
		    objs[beforetab].style.display="none";
		    for (var i = 0; i < objs.length; i ++) {
		     if (i != tabIndex) {
		    	objs[i].style.display = "none";
		        objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex -1 ;
		    	}
		    }
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
				sUrl="ESM_PRI_2001_01.do"; 
				break;
			case 1:
				sUrl="ESM_PRI_2001_02.do"; 
				break;
			case 2:
				sUrl="ESM_PRI_2001_03.do"; 
				break;
			case 3:
				sUrl="ESM_PRI_2001_04.do"; 
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
	 * calling function when occurring OnChange Event <br>
	 */
	function svc_scp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {		
		var formObj=document.form;
		var arrText=newCode;
		if (arrText != null && arrText.length > 1) {
			formObj.svc_scp_nm.value=comboObj.GetText(newCode,1);
			selectedGlineSeq=null;
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		} else {
			formObj.svc_scp_nm.value = "";
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
	function gline_seq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

		var formObj=document.form;
		var selEffDt=comboObj.GetSelectText();
		
		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}
		
		if (ComIsDate(selEffDt)) {
			selEffDt=selEffDt.replace(/-/gi, "");
			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
			
			if(newCode != "" ) { //select
				var effDt = comboObj.GetText(newCode, 0);
				var expDt = comboObj.GetText(newCode, 1);
				
				if(effDt != formObj.eff_dt.value) {
					formObj.eff_dt.value=effDt;
					formObj.exp_dt.value=expDt;
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					if (tabObjects[0].GetSelectedIndex()== 0) {
						tab1_OnChange(tabObjects[0], 0);
					} else {
						tabObjects[0].SetSelectedIndex(0);
					}
					setTabStyle();
				}
			} else { //manual input
				
				var nIdx = comboObj.FindItem(selEffDt, 0, true);
				if( nIdx != -1) {
					comboObj.SetSelectIndex(nIdx, true);
					document.form.exp_dt.value=comboObj.GetText(nIdx, 1);
				} else {
					document.form.eff_dt.value=selEffDt;
					document.form.gline_seq_text.value=selEffDt;
				}
			}
			
		} else {
			return false;
		}
		setComnoBySlineSeq(comboObj);
		
//		var effText=comboObj.GetText(newCode, 0);
//		var expText=comboObj.GetText(newCode, 1);
//		formObj.eff_dt.value=effText;
//		formObj.exp_dt.value=expText;
//		if (newCode == null || newCode == "" || newCode == "X") {
//			return true;
//		}
//		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//		if (tabObjects[0].GetSelectedIndex()== 0) {
//			tab1_OnChange(tabObjects[0], 0);
//		} else {
//			tabObjects[0].SetSelectedIndex(0);
//		}
//		setTabStyle();
//		setComnoBySlineSeq(comboObj);
	}
	
	function gline_seq_OnClear(comboObj) {
		var formObj=document.form;
		gline_seq.SetSelectCode(-1);
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.cfm_flg.value="";
		formObj.cre_dt.value="";
		formObj.cre_usr_nm.value="";
		formObj.cre_ofc_cd.value="";
		clearAllTabPages();
	}
	
//	function gline_seq_OnKeyUp(comboObj, KeyCode, Shift) {
//		var selEffDt=comboObj.GetSelectText();
//		if (selEffDt.search(/[^0-9]/gi) >= 0) {
//			selEffDt=selEffDt.replace(/[^0-9]/gi, "");
//			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//		}
//		if (selEffDt.length == 8) {
//			comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//			document.form.exp_dt.focus();
//		}
//	}

	/**
	 * calling event when focus out<br>
	 */
//	function gline_seq_OnBlur(comboObj) {
//		var selEffDt=comboObj.GetSelectText();
//		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
//			return false;
//		}
//		if (ComIsDate(selEffDt)) {
//			selEffDt=selEffDt.replace(/-/gi, "");
//			selEffDt=selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
//			document.form.eff_dt.value=selEffDt;
//			if(selectedGlineSeq == null){
//				selectedGlineSeq = 0;
//			}
//			if( selEffDt != undefined){
//				comboObj.SetText(selectedGlineSeq, 2, selEffDt);
//				comboObj.SetText(selectedGlineSeq, 0, selEffDt);
//			}
//			
//			var nIdx = comboObj.FindItem(selEffDt, 0, true);
//			if( nIdx == -1) {
//				comboObj.InsertItem(comboObj.GetItemCount(), document.form.eff_dt.value, "");
//				comboObj.SetSelectIndex(comboObj.GetItemCount() - 1, false);
//				comboObj.SetViewText(selEffDt);
//			} else {
//				comboObj.SetSelectIndex(nIdx, false);
//			}			
////			document.form.eff_dt_hidden.value = selEffDt;
////			comboObj.SetViewText(selEffDt);
//		} else {
//			ComShowCodeMessage("COM12134", "Effective Date");
//			gline_seq.Focus();
//			return false;
//		}
//		setComnoBySlineSeq(comboObj);
//	}
	/**
	 * handling all buttons Enalbe/Disable <br> <br>
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			ComBtnDisable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnDisable("btn_confirmcancel");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_copy");
			break;
		case "INIT":
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_confirm");
			ComBtnEnable("btn_confirmcancel");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_copy");
			break;
		case "NEW":
			ComBtnDisable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnEnable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnDisable("btn_confirmcancel");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_copy");
			break;
		case "CONF_YES":
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnEnable("btn_confirmcancel");
			ComBtnDisable("btn_delete");
			ComBtnEnable("btn_copy");
			break;
		case "CONF_NO":
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_new");
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_confirm");
			ComBtnDisable("btn_confirmcancel");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_copy");
			break;
		}
		if (!isAproUsr) {
			//ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_new");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_confirm");
			ComBtnDisable("btn_confirmcancel");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_copy");
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
