/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0039.js
*@FileTitle  : Proposal Amendment Draft Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
	// Event Handler : Branching the process using Button Name.	
	function processButtonClick() {
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve1":
				formObj.cd_tp.value="1";
				formObj.cd1.value=formObj.sc_no.value;
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_retrieve2":
				formObj.cd_tp.value="2";
				formObj.cd1.value=formObj.prop_no.value;
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_retrieve3":
				formObj.cd_tp.value="3";
				formObj.cd1.value=formObj.apro_ofc_cd.value;
				formObj.cd2.value=formObj.apro_usr_nm.value;
				formObj.eff_dt.value=ComGetUnMaskedValue(formObj.auth_dur_eff_dt.value,"ymd");
				formObj.exp_dt.value=ComGetUnMaskedValue(formObj.auth_dur_exp_dt.value,"ymd");
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_retrieve4":
				formObj.cd_tp.value="4";
				formObj.cd1.value=formObj.prop_ofc_cd.value;
				formObj.cd2.value=comboObjects[0].GetSelectCode();
				formObj.eff_dt.value=ComGetUnMaskedValue(formObj.srep_dur_eff_dt.value,"ymd");
				formObj.exp_dt.value=ComGetUnMaskedValue(formObj.srep_dur_exp_dt.value,"ymd");
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_open":
				var sheetObj=sheetObjects[0];
                var sPropNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"prop_no");
                var sScNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(),"sc_no");
                var sAmdtSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq");
                var sParam="";    
                var isPrintFull="";
                if(sAmdtSeq != "0") {
                    //In case of amend seq != 0, user can select full print or amend draft
    	            	$("#confirmDialog").dialog(
    	                		{
    	                		title : "S/C Print",
    	                		resizable: false,
    	                		beforeClose: function( event, ui ) {
    	                			$(this).parent().parent().find(".layer_popup_bg").remove();
    	        					$(parent.document.body).find(".layer_popup_bgTop,.layer_popup_bgBtm").remove();
    	                		},
    	                		buttons: [
    	                			{
    	                				text: "Full S/C ",
    	                				click: function() {
    	                					isPrintFull="Y";
    	                					sParam="prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
    	                                	ComOpenPopup("ESM_PRI_0061.do?"+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
    	                					$(this).dialog("close");
    	
    	                				}
    	                			},
    	                			{
    	                				text: "Amend Draft",
    	                				click: function() {
    	                					isPrintFull="N";
    	                					sParam=sPropNo + ":" + sScNo + ":" + sAmdtSeq + ";"
    	                                	ComOpenPopup("ESM_PRI_0079.do?sParam="+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
    	                					$(this).dialog("close");
    	                				}
    	                			},
    	                			{
    	                				text: "Cancel",
    	                				click: function() {
    	                					isPrintFull="C";
    	                					$(this).dialog("close");
    	                				}
    	                			}
    	                		]
    	                	}
    	                );                	
                    } else {
                    	sParam="prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                    	ComOpenPopup("ESM_PRI_0061.do?"+sParam, 1024, 650,"", "1,0,1,1,1,1,1", true);
                    }
				break;
			case "ret_tp_rdo":
				for(idx=0; idx < formObj.ret_tp_rdo.length; idx++) {
					if(formObj.ret_tp_rdo[idx].checked == true) {
						var kind=formObj.ret_tp_rdo[idx].value;
						changeKind(kind-1);
						break;
					}
				}
			break;
            case "btns_calendar1": //calendar button
	            var cal=new ComCalendarFromTo();
	            cal.select(document.form.auth_dur_eff_dt, document.form.auth_dur_exp_dt, 'yyyy-MM-dd');
	        break;
            case "btns_calendar2":
	            var cal=new ComCalendarFromTo();
	            cal.select(document.form.srep_dur_eff_dt, document.form.srep_dur_exp_dt, 'yyyy-MM-dd');
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
	
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
	/**
	 * Initialize Sheet and default setting. Implement onload event handler of body tag. After loading page on browser, add the functions that should be pre-processed
	 *  
	 */
	function loadPage() {
		for (var i=0; i < sheetObjects.length; i++) {	
			// Modify Enviroment Setting Function's name
			ComConfigSheet(sheetObjects[i]);	
			initSheet(sheetObjects[i], i + 1);			
			// Add Environment Setting Function 
			ComEndConfigSheet(sheetObjects[i]);
		}
	    //Initializing IBMultiCombo
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
        axon_event.addListenerForm('blur', 'obj_blur', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);        
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	}
	
	// Execute process related to Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: // retrieving
			var sheetObj=sheetObjects[0];
			formObj.f_cmd.value=SEARCH01;
			var cd_tp=formObj.cd_tp.value;
			var cd1=formObj.cd1.value;
			var cd2=formObj.cd2.value;
			var eff_dt=formObj.eff_dt.value;
			var exp_dt=formObj.exp_dt.value;
			var sParam=FormQueryString(formObj)+"&cd_tp="+cd_tp+"&cd1="+cd1+"&cd2="+cd2+"&eff_dt="+eff_dt+"&exp_dt="+exp_dt;
 			sheetObj.DoSearch("ESM_PRI_0039GS.do", sParam );
			break;		
		case IBSEARCH_ASYNC01: //
			supressflg=true;
			var sheetObj=sheetObjects[0];
			formObj.f_cmd.value=SEARCH02;
 			var sXml=sheetObj.GetSearchData("ESM_PRI_0039GS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "prop_no|amdt_seq|eff_dt|exp_dt");
			if(arrDesc==null){
				if(formObj.ret_tp_rdo[0].checked == true){
					formObj.sc_no.value="";
					formObj.sc_no.focus();
				}else if(formObj.ret_tp_rdo[1].checked == true){
					formObj.prop_no.value="";
					formObj.prop_no.focus();
				}
			}else{
				if(formObj.ret_tp_rdo[0].checked == true){
					formObj.amdt_seq.value=arrDesc[0][1];
					formObj.sc_dur_eff_dt.value=arrDesc[0][2];
					formObj.sc_dur_exp_dt.value=arrDesc[0][3];
					formObj.cd_tp.value="1";
					formObj.cd1.value=formObj.sc_no.value;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}else if(formObj.ret_tp_rdo[1].checked == true){
					formObj.prop_dur_eff_dt.value=arrDesc[0][2];
					formObj.prop_dur_exp_dt.value=arrDesc[0][3];
					formObj.cd_tp.value="2";
					formObj.cd1.value=formObj.prop_no.value;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				}
			}
			supressflg=false;
			break;
		case IBSEARCH_ASYNC02: // Setting Sale Rep
			var etc1=formObj.prop_ofc_cd.value;
			formObj.f_cmd.value=SEARCH15;
			var sParam=FormQueryString(formObj)+"&etc1="+etc1;
 			sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			ComPriXml2ComboItem(sXml, prop_srep_cd, "cd", "cd|nm");
			break;	
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
					var HeadTitle="|Sel.|Seq.|S/C No.|AMD No.|Proposal No.|Customer Name|Request Office|MQC|EFF Date|EXP Date|Filed Date";
	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					//2014.10.28(OPUS_NYK_CR_665) Seq : change Hidden cause change multi-checks to single select
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"status" },
					             {Type:"CheckBox",  Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:550,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"prop_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fnl_mqc_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"file_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
					InitColumns(cols);
	
					SetEditable(1);
					resizeSheet();
//					SetSheetHeight(490);
				}
			    break;
        }
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
	
	/**
	* Initializing combobox list.
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     initCombo(comboObj, comboNo);
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "prop_srep_cd":
	            var i=0;
	            with(comboObj) {
	            	//BackColor = "cyan";
	            	SetDropHeight(200);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	ValidChar(2, 1);
	            	SetMaxLength(5);
	            }
	            break;
	    }
	}
	
	/**
	 * Check the validation rules on value of objects in windows
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var sc_no=formObj.sc_no.value;
		var prop_no=formObj.prop_no.value;
		var amdt_seq=formObj.amdt_seq.value;
		switch (sAction) {
		case IBSEARCH: // retrieving
			if (sc_no == null && prop_no == null) {
				return false;
			}
			return true;
			break;
		}
	}
	
	/**
	* Process Event when Radio button changed
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     changeKind(nItem);
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/		 
    function changeKind(nItem)
    {
        var objs=document.all.item("SearchLayer");
		for (var i=0; i < objs.length; i ++){
			if (i != nItem) 
				objs[i].style.display="none";
			else
				objs[nItem].style.display="Inline";
		}
    }
    
	/**
	* Calling function when Srep Code is changed.
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     changeKind(nItem);
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/	    
	function prop_srep_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		//var arrText=NewText.split("|");
		if (NewCode != null && NewCode.length > 0) {
    		formObj.prop_srep_nm.value=comboObj.GetText(NewCode, 1);
    	} else {
    		formObj.prop_srep_nm.value="";
    	}
	}
	
    var supressFlg=false;
	/**
	* Execute when event of object in window finished 
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_deactivate();
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/	    
    function obj_blur() {
    	if(supressFlg) return;
        var formObj=document.form;
        var sheetObj=sheetObjects[0]; 
        var eleName=event.srcElement.name;
        switch(eleName){
            case "sc_no":
            	if(formObj.sc_no.value=="") return;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            case "prop_no":
            	if(formObj.prop_no.value=="") return;
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                break;
            case "auth_dur_eff_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "auth_dur_exp_dt":
                ComChkObjValid(event.srcElement);   
                break;
            case "prop_dur_eff_dt":
            	break;
            case "prop_dur_exp_dt":
            	break;
            case "sc_dur_eff_dt":
            	break;
            case "sc_dur_exp_dt":
            	break;            	
            default:
                ComChkObjValid(event.srcElement);       
        }
    }
    
	/**
	* Execute when a key pressed on UI
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     obj_keypress();
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/	    
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "sc_no" ||event.srcElement.name == "prop_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }    
                break;
            default:
        }
    }
    
    /**
     * Handling OnKeyDown even <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2010.01.08
     */        
    function obj_keydown(){
    	var eleName=event.srcElement.name;
    	var formObj=document.form;       
    	var keyValue=null;
    	if(event == undefined || event == null) {
    		keyValue=13;
    	}else{
    		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	}
    	if (keyValue == 13){
    		switch (eleName) {
		    	case "sc_no":
		    		if(formObj.sc_no.value=="") return;
		    	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		    	    	break;
		    	case "prop_no":
		    		if(formObj.prop_no.value=="") return;
		    	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		    	    	break;       
    		}
    	}
    }