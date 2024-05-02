 
	// global variables
	var sheetObjects = new Array();
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var isAproUsr = false;
	var opener;
	
	//Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	
//다음의 화면들에서 호출됨
//ESM_PRI_0001
	
	/**
     * Event handler processing by button name  <br>
     */
    function processButtonClick(){

    	var sheetObject1 = sheetObjects[0];
    	var formObject = document.form;

     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		
             switch(srcName) {
 				case "btn_ok":
 					doActionIBSheet(sheetObject1, formObject, IBSAVE);
 					break;

 				case "btn_close":
 					ComClosePopup();
 					break;

 				case "btns_calendar": 
	                var cal = new ComCalendarFromTo();
	                cal.select(formObject.trgt_eff_dt, formObject.trgt_exp_dt, 'yyyy-MM-dd');
	                break;     

             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
     }
	
    /**
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
    }
	
	/**
     * registering IBMultiCombo Object as array  <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
     * Initializing and setting Sheet basics <br>
     * Setting body tag's onLoad event handler <br>
     * Adding pre-handling function after loading screen on the browser  <br>
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
   	 	if (!opener) opener = window.opener;
   	 	if (!opener) opener = parent;
   	 	
    	for(i=0;i<sheetObjects.length;i++) {
	        ComConfigSheet (sheetObjects[i] );
	
	        initSheet(sheetObjects[i],i+1);

        	ComEndConfigSheet(sheetObjects[i]);
    	}

	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
	    
    	initControl();
    	
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	comboObjects[0].SetSelectCode(document.form.svc_scp_cd.value, true);
    	document.form.trgt_svc_scp_nm.value = comboObjects[0].GetText(document.form.svc_scp_cd.value, 1);
    }
    
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {
		switch (sheetNo) {
			case 1:
	            with (sheetObj) {
	                var HeadTitle = "|stat";
	                
	                SetConfig({ SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 });
	                
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"}];
	                InitHeaders(headers, info);
	                
	                var cols = [ {Type:"Status", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" }];
	                InitColumns(cols);
	                SetVisible(0);
	               // SetSheetHeight(100);
	            }
	            break;
       }
	}
	
	/**
     * Handling sheet process <br>
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		
			case IBSEARCH_ASYNC01:
				comboObjects[0].RemoveAll();

				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				ComPriXml2ComboItem(sXml, trgt_svc_scp_cd, "cd", "cd|nm");
				break;
				
			case IBSEARCH_ASYNC11:
				var sParam = "f_cmd="+COMMAND15+"&pagerows=&prc_ctrt_tp_cd=S&svc_scp_cd=" + comboObjects[0].Code + "&usr_id=" + formObj.usr_id.value;

				var sXml = sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrAuth = ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
				
				if (arrAuth != null && arrAuth.length > 0) {
					isAproUsr = true;
				} else {
					isAproUsr = false;
				}
				toggleButtons();
				break;
				
			case IBSEARCH:
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchData("ESM_PRI_0006GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "grp_loc_cnt|grp_cmdt_cnt|org_arb_cnt|dest_arb_cnt|rate_cnt|goh_cnt");
				setTermsCheck(arrDesc);
				ComOpenWait(false);
				break;
				
			case IBSAVE:
				ComOpenWait(true);
				if(!validateForm(sheetObj,formObj,sAction)) {
					ComOpenWait(false);
					return false;
				}
				
				formObj.f_cmd.value = MULTI01;
				var sXml = sheetObj.GetSaveData("ESM_PRI_0006GS.do", FormQueryString(formObj));
				var arrDesc = ComPriXml2Array(sXml, "trgt_gline_seq");
				if(arrDesc != null && arrDesc != "") {
					formObj.trgt_gline_seq.value = arrDesc[0][0];
				}
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				break;
		}
	}
	
	/**
     * calling function when occurring OnSaveEnd event  <br>
     * showing the save completion message in case of successful saving <br>
     */
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
 		var formObj = document.form;
		var trgtSvcScpCd = comboObjects[0].GetSelectCode();
		var trgtGlineSeq = formObj.trgt_gline_seq.value;
		opener.reloadPostCopy(trgtSvcScpCd, trgtGlineSeq);
		ComClosePopup();
	}
 	
 	/**
     * calling function when occurring IBMultiCombo OnChange Event <br>
     * showing description of selected item when trgt_svc_scp_cd combo out of focus<br>
     */
	function trgt_svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.trgt_svc_scp_nm.value = arrText[1];
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
		}
		
	}
	
	/**
     * calling function when occurring IBMultiCombo OnClear Event <br>
     */
	function trgt_svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.trgt_svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	}
	
	/**
     * calling function when occurring IBMultiCombo OnBlur Event <br>
     * showing description of selected item when trgt_svc_scp_cd combo out of focus<br>
     */
	function trgt_svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.trgt_svc_scp_nm.value) {
				formObj.trgt_svc_scp_nm.value = comboObj.GetText(code, 1);
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
			}
		}
	}
	
	/**
	 * handling HTML Control evnet <br>
	 **/
	function initControl() {

//		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
//		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerForm('click', 'obj_click', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	}
	
	/** 
	 * handling OnKeyPress events <br>
	 * handling process for input validation by object's dataformat   <br>
	 */
	function obj_keypress(){
		 switch (event.srcElement.dataformat) {
			case "int":
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
				
			case "eng":
		        //english only
	            ComKeyOnlyAlphabet('upper');
	            break;
	       
			case "ymd":
		        //date only
		       // ComKeyOnlyNumber(event.srcElement, "-");
	            break;
		}
	}

//  Date 관련 validation 체크는 공통에서 관리, 모듈별 체크로직 필요없음
//	/** 
//	 * Object's OnFocus event handler<br>
//	 * showing date type YYYYMMDD <br>
//	 */ 
//	function obj_activate() {
//		switch(event.srcElement.name) {
//		 	case "trgt_eff_dt":
//		 		ComClearSeparator(event.srcElement);
//		 		break;
//		 		
//		 	case "trgt_exp_dt":
//		 		ComClearSeparator(event.srcElement);
//		 		break;
//	}
//	}
//	 
//	/** 
//	 * Object's Onbeforedeactivate event handler <br>
//	 *handling process for input validation by object's dataformat   <br>
//	 */ 
//	function obj_deactivate() {
//		 switch(event.srcElement.name) {
//		 	case "trgt_eff_dt":
//		 		ComChkObjValid(event.srcElement);
//		 		break;
//		 		
//		 	case "trgt_exp_dt":
//		 		ComChkObjValid(event.srcElement);
//		 		break;
//		}
//	 }
	 
	/** 
	 * Object's OnClick event handler <br>
	 */ 
	function obj_click() {
		var formObj = document.form;
		
		switch(event.srcElement.name) {
		
			case "rate":
		 		if(event.srcElement.checked) {
		 			if(formObj.loc_grp.disabled == false) {
		 				formObj.loc_grp.checked = true;
		 			}
		 			if(formObj.cmdt_grp.disabled == false) {
		 				formObj.cmdt_grp.checked = true;
		 			}
		 		}
		 		break;
		}
	}
	
    /**
     * initializing combo, header <br>
     * adding case in case of multiple combo <br>
     */ 
    function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "trgt_svc_scp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            }
	            break;
	    }
	}
	
    /**
     * checking check box function <br>
     */ 
	function setTermsCheck(arrDesc) {
		var formObj = document.form;
		 
		if(arrDesc[0][0] > 0 ) {
			formObj.loc_grp.checked = true;
		} else {
			formObj.loc_grp.checked = false;
			formObj.loc_grp.disabled = true;
		}
		 
		if(arrDesc[0][1] > 0 ) {
			formObj.cmdt_grp.checked = true;
		} else {
			formObj.cmdt_grp.checked = false;
			formObj.cmdt_grp.disabled = true;
		}
		 
		if(arrDesc[0][2] > 0 ) {
			formObj.org_arb.checked = true;
		} else {
			formObj.org_arb.checked = false;
			formObj.org_arb.disabled = true;
		}
		 
		if(arrDesc[0][3] > 0 ) {
			formObj.dest_arb.checked = true;
		} else {
			formObj.dest_arb.checked = false;
			formObj.dest_arb.disabled = true;
		}
		 
		if(arrDesc[0][4] > 0 ) {
			formObj.rate.checked = true;
		} else {
			formObj.rate.checked = false;
			formObj.rate.disabled = true;
		}
		 
		if(arrDesc[0][5] > 0 ) {
			formObj.goh.checked = true;
		} else {
			formObj.goh.checked = false;
			formObj.goh.disabled = true;
		}
	}
	 
	/**
     * button authority control function <br>
     */ 
	function toggleButtons() {
		if (!isAproUsr) {
			ComBtnDisable("btn_ok");
		} else {
			ComBtnEnable("btn_ok");
		}
	}
	 
	/**
     * checking validation process of inputed form data <br>
     */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSAVE:
				if(!ComChkRequired(formObj)) return false;
				
				if(ComChkPeriod(formObj.trgt_eff_dt.value, formObj.trgt_exp_dt) == 0) { 
					ComShowCodeMessage('PRI00306');
					return false;
				}
				if(!ComShowCodeConfirm('PRI08006')) {
					return false;
				}
				break;
		  }
		return true;
	}

	