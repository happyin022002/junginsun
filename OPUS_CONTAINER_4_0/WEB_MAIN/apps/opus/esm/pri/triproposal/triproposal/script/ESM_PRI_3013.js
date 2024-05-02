/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_PRI_3013.js
*@FileTitle : TRI Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    
    // common global variables
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
	var comboCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0], document.form, IBRESET);
					break;
				case "btn_conversion":
					var sParam="trf_cd="+comboObjects[0].GetSelectCode();
					var winObj=window.open("/opuscntr/ESM_PRI_3006.do?main_page=true&parentPgmNo=ESM_PRI_M001&MENU=Y&pgmNo=ESM_PRI_3013&" + sParam); 
					break;
				case "srch_btn_srch_cmdt":
		            var sUrl="ESM_PRI_4027.do?" + FormQueryString(document.form);
		            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";
		            ComOpenPopup(sUrl, 700, 345, "setReturnValue", "1,0,1,1,1,1,1", true);
				
					break;
				case "btns_calendar": //Calendar Button
					var cal=new ComCalendar();
					cal.select(formObject.srch_acs_dt,'yyyy-MM-dd');
					break;
				case "btn_downexcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
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
    
    
    function setReturnValue(rtnVal) {
    	var formObj=document.form;
    	if (rtnVal != null) {
    		formObj.srch_cmdt_cd.value=rtnVal.cd;
    		formObj.srch_cmdt_nm.value=rtnVal.nm;
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
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBMultiCombo Object as list <br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.06.04
     */
 	function setComboObject(combo_obj) {
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
     * @return void
     * @author 
     * @version 2009.12.02
     */
    function loadPage() {
    	
        for(i=0;i<sheetObjects.length;i++){
        	//Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // IBMultiCombo Initialize
		for ( var k=0; k < comboObjects.length; k++) {
			initCombo(comboObjects[k], k + 1);
		}
		form.srch_acs_dt.value=ComGetNowInfo('ymd', '-');
		initControl();
		ComBtnDisable("btn_conversion");
		initIBComboItem();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.12.02
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with(sheetObj){
            	SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
            	                    	      
            	      var HeadTitle="Tariff Rate Item\n(TRI)|Commodity\nCode|Commodity Description|Effective\nDate|Expiration\nDate|Origin\n(POR)|Origin\nVia|Dest.\nVia|Dest.\n(DEL)|Per|Cur.|Rate|Note|Internal Remark|TAA No.";
            	      var headCount=ComCountHeadTitle(HeadTitle);

            	      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"tri_no",                 KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_nm",    KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_nm",   KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
            	             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:0,   SaveName:"tri_rmk",              KeyField:0,   CalcLogic:"",   Format:"" },
            	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"taa_no",                 KeyField:0,   CalcLogic:"",   Format:"" } ];
            	       
            	      InitColumns(cols);

            	      SetEditable(0);
            	      SetCountPosition(0);
            	      SetWaitImageVisible(0);
            	      SetColHidden("taa_no",1);
            	      SetShowButtonImage(2);
            	      SetAutoRowHeight(1);
            	      resizeSheet(); //SetSheetHeight(360);
            	      }


                break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }

    
    /**
 	 * Loading HTML control's event on page dynamically<br>
 	 * <br><b>Example :</b>
 	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
 	 * @return void
     * @author 
     * @version 2009.12.04
 	 **/
 	function initControl() {
 		//** Date delimiter **/
 		DATE_SEPARATOR="-";
 		axon_event.addListenerForm('click', 'obj_click', document.form);
 		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
 		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerForm('keydown', 'obj_KeyEnter', document.form);
 	}
 	/**
     * Setting retrieved items to IBMultiCombo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initIBComboItem ();
     * </pre>
     * @return void
     * @author 
     * @version 2009.08.12
     */
    function initIBComboItem() {

         ComPriTextCode2ComboItem(srchTrfComboValue, srchTrfComboText, getComboObject(comboObjects, 'srch_trf_cd'),"|","\t");         
         ComPriTextCode2ComboItem(srchRatUtComboValue, srchRatUtComboText, getComboObject(comboObjects, 'srch_rat_ut_cd'),"|","\t");
    }
 	/**
     * This function can be called at onKeyDown event of HTML Tag (Object). When Enter key pressed, process autumatic function. <br>
     * The case of sFlag are as follows. <br>
     * sFlag = Nothing           : the same process as sFlag="Search" case.<br>
     * sFlag = "Search"          : when Enter key pressed, process as Retrieve button clicked. it should be called at OnKeyDown event <br>
     * sFlag = "NextFocus"       : when Enter key pressed, move focus to Next object in order. it should be called at OnKeyDown event <br>
     * sFlag = "LengthNextFocus" : when the contents filled as maxlength of field, move focus to Next Object automatically, when Enter key pressed, move focus to Next object without check the length of text. it should be called at OnKeyUp event<br>
     * sFlag = Function Name     : when Enter key pressed, call the function specified in sFlag.  it should be called at OnKeyDown event <br>
     * sFlag = "LengthNextFocus" case should be called at OnKeyUp event, otherwise at OnKeyDown event.<br>
     * <br><b>Example :</b>
     * <pre>
     *     <form name="form" onKeyDown="ComKeyEnter()">                    //Use it Search Condition form
     *     <form name="form" onKeyDown="ComKeyEnter('NextFocus')">     //Use it Save Form
     *     <form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')"> // Use it Save Form
     * </pre>
     * @param {string} sFlag Optional, Key Process Seperate, default="Search"
     * @see #ComSetNextFocus
     */
    function obj_KeyEnter()
    {
     	var formObj=document.form;
      	try {
      		var srcName=ComGetEvent("name");
  			var keyValue=null;
          	if(event == undefined || event == null) {
          		keyValue=13;
          	} else {
         		keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
         	}
          	if (keyValue != 13) return;
          	if(srcName="srch_cmdt_cd") {
          		ComOpenWait(true);
      			if (formObj.srch_cmdt_cd.value.length == 6) {
     				formObj.f_cmd.value=SEARCH08;
     				var param="&cd=" + formObj.srch_cmdt_cd.value;
      				var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
     				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
     				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
     					formObj.srch_cmdt_nm.value=arrData[1];
     				} else {
     		    		formObj.srch_cmdt_cd.value="";
     		    		formObj.srch_cmdt_nm.value="";
     		    		return false;
     				}
     	    	} else {
     	    		formObj.srch_cmdt_cd.value="";
     	    		formObj.srch_cmdt_nm.value="";
     	    	}
      			ComOpenWait(false);
      		}else {
      			var rtnFireEvent;
          		var obj=document.getElementById("btn_Retrieve");
          		if (obj == null){ 
          			obj=document.getElementById("btn_Retrieve");
          		}else{
          			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
          		}
      		}
      		
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    /**
     * setting intial combo value <br>
     * adding case as numbers of counting combo<br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {object} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.12.04
     */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.options.id) {
			case "srch_trf_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetMaxLength(8);
	            	ValidChar(2,3);
	            }
	            break;
			case "srch_rat_ut_cd":
				with (comboObj) {
					SetDropHeight(200);
					SetMultiSelect(0);
					SetMaxSelect(1);
					SetUseAutoComplete(1);
//no support[check again]CLT 					IMEMode=0;
				}
				break;	
		}
	}
	/**
     * Handling sheet's processes <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	        case IBRESET: // New
	        	sheetObjects[0].RemoveAll();
	        	comboObjects[0].SetSelectCode('-1',false);
	        	comboObjects[1].SetSelectCode('-1',false);
	        	formObj.srch_trf_nm.value="";
	        	formObj.srch_acs_dt.value="";
	        	formObj.srch_cmdt_cd.value="";
        		formObj.srch_cmdt_nm.value="";
        		formObj.srch_org_rout_pnt_loc_nm.value="";
       			formObj.srch_org_rout_via_port_nm.value="";
   				formObj.srch_dest_rout_via_port_nm.value="";
				formObj.srch_dest_rout_pnt_loc_nm.value="";
				formObj.srch_tri_no.value="";
				formObj.srch_taa_no.value="";
				formObj.srch_chk_taa_no.checked=false;
				sheetObjects[0].SetColHidden("taa_no",1);
	            break;
           case IBSEARCH:
        	   ComOpenWait(true);
        	   if(!validateForm(sheetObj, document.form, sAction)) {
        		   ComOpenWait(false);
        		   return false;
               }
        	   formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESM_PRI_3013GS.do", FormQueryString(formObj) );
               ComOpenWait(false);
               break;
			case IBDOWNEXCEL: //Download excel
				var xmlFile="apps/opus/esm/pri/triproposal/triproposal/script/ESM_PRI_3013.xml";
				 if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");

				}else{
					sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj),	HiddenColumn:-1,Merge:true,ReportXML:"xmlFile"});
				} 				
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
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.12.04
	 */
	function srch_trf_cd_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, text, code) {
		var formObj=document.form;
		
		formObj.srch_trf_pfx_cd.value=code.substring(0, 4);
		formObj.srch_trf_no.value=code.substring(5, 8);
		formObj.trf_pfx_cd.value=code.substring(0, 4);
		formObj.trf_no.value=code.substring(5, 8);

//		if (text != null && text != "") {
//			formObj.srch_trf_nm.value = text.split("|")[1];
//		} else {
//			formObj.srch_trf_nm.value = "";
//		}
        var arrText=text.split("|");
    	//if (arrText != null && arrText.length > 1) {
        if (arrText != null && arrText.length > 0) {
    		formObj.srch_trf_nm.value=comboObj.GetText(code, 1);
    	}else{

    		formObj.srch_trf_nm.value;
    	}
		if(ComIsNull(code)) {
			ComBtnDisable("btn_conversion");
		} else {
			ComBtnEnable("btn_conversion");
		}
	}
  /**
   * event in case of losting IBMulti Combo's focus<br>
   * Setting Combo's text value to Html object<br>
   * <br><b>Example :</b>
   * <pre>
   *    srch_trf_cd_OnBlur(comboObj);
   * </pre>
   * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
   * @return void
   * @author 
   * @version 2009.04.17
   */  
  function srch_trf_cd_OnBlur(comboObj) {
		var formObj=document.form;		
 		//var code=comboObj.FindItem(comboObj.GetSelectCode(), 0);
		var code=comboObj.FindItem(comboObj.GetSelectCode(), 0, false);

		var srchTrfNm="";
		if (code != null && code != "") {
			var text=comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.srch_trf_nm.value) {
				srchTrfNm=comboObj.GetText(code, 1);
				formObj.srch_trf_nm.value=srchTrfNm;
			}
			
			formObj.srch_trf_pfx_cd.value=code.substring(0, 4);
			formObj.srch_trf_no.value=code.substring(5, 8);
			formObj.trf_pfx_cd.value=code.substring(0, 4);
			formObj.trf_no.value=code.substring(5, 8);
		}
		if (code == -1 ){
			formObj.srch_trf_nm.value="";
		}
	} 	 
	/**
     * Calling function in case of Onclick event <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return void
     * @author 
     * @version 2009.12.04
     */
	function obj_click() {
		if(event.srcElement.name == "srch_chk_taa_no") {
			if(event.srcElement.checked) {
			 	sheetObjects[0].SetColHidden("taa_no",0);
			 	sheetObjects[0].SetColWidth("tri_rmk", 180);
			} else {
				sheetObjects[0].SetColHidden("taa_no",1);
			}
			for(i=1; i<=sheetObjects[0].LastRow(); i++) {
				sheetObjects[0].SetRowHeight(i,0);
			}
		}
	}
    /**
 	 * Handling OnKeyPress<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_keypress();
 	 * </pre>
 	 * @param  void
 	 * @return void
 	 * @author 
 	 * @version 2009.12.04
 	 */
 	function obj_keypress() {
 		switch (event.srcElement.dataformat) {
	 		case "int":
	 			ComKeyOnlyNumber(event.srcElement);
	 			break;
	 		case "float":
	 			ComKeyOnlyNumber(event.srcElement, ".");
	 			break;
	 		case "engup":
	 			if (event.srcElement.name == "srch_taa_no") {
	 				ComKeyOnlyAlphabet('uppernum');
	 			} else {
	 				ComKeyOnlyAlphabet('upper');
	            }
	            break;
	 		default:
	 			break;
 		}
 	}
 	/**
 	 * Handling OnBeforeActivate event <br>
 	 * <br>
 	 * <b>Example :</b>
 	 * 
 	 * <pre>
 	 * obj_activate()
 	 * </pre>
 	 * 
 	 * @param  void
 	 * @return void
 	 * @author 
 	 * @version 2009.12.04
 	 */
 	function obj_activate() {
 		var formObj=document.form;
 	    var srcName=ComGetEvent("name");
 	    if (srcName == "srch_tri_no") {
 	    	formObj.srch_tri_no.value=formObj.srch_tri_no.value.replace(RegExp(/-/ig), "");
 	    } else if (srcName == "srch_acs_dt") {
 	    	formObj.srch_acs_dt.value=formObj.srch_acs_dt.value.replace(RegExp(/-/ig), "");
 	    }
 	}
 	/**
 	 * Handling Onbeforedeactivate event<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *     obj_deactivate()
 	 * </pre>
 	 * @param  void
 	 * @return void
 	 * @author 
 	 * @version 2009.12.04
 	 */
 	function obj_deactivate() {
 		var formObj=document.form;
 	    var srcName=ComGetEvent("name");
 	    if (srcName == "srch_tri_no") {
// 	    	var sTriNo = formObj.srch_tri_no.value;
 	    	var sTriNo=formObj.srch_tri_no.value.replace(/-/g, '');
 	    	if (sTriNo.length >= 13) {
 	    		formObj.srch_tri_no.value=sTriNo.substring(0, 6) + "-" + sTriNo.substring(6, 10) + "-" + sTriNo.substring(10, 13);
 	    	}
 	    } else if (srcName == "srch_cmdt_cd") {
 	    	if (formObj.srch_cmdt_cd.value.length == 6) {
 				formObj.f_cmd.value=SEARCH08;
 				var param="&cd=" + formObj.srch_cmdt_cd.value;
  				var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
 				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
 					formObj.srch_cmdt_nm.value=arrData[1];
 				} else {
 		    		formObj.srch_cmdt_cd.value="";
 		    		formObj.srch_cmdt_nm.value="";
 		    		return false;
 				}
 	    	} else {
 	    		formObj.srch_cmdt_cd.value="";
 	    		formObj.srch_cmdt_nm.value="";
 	    	}
 	    } else if (srcName == "srch_acs_dt") {
 	    	ComChkObjValid(formObj.srch_acs_dt);
 	    }
 	}
 	
 	/**
     * calling function when occurring OnClick Event <br>
     * showing memopad when clicking desc cell (MemoPad editable)<br>
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value) {
        var formObj=document.form;
        var colname=sheetObj.ColSaveName(Col);
        var memoColWidth =	sheetObj.GetColWidth("note_ctnt") + sheetObj.GetColWidth("fnl_frt_rt_amt") + sheetObj.GetColWidth("curr_cd");
        switch (colname) {
            case "note_ctnt":
                ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 4000, "X");
                break;
            case "tri_rmk":
            	ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.GetColWidth(Col), parseInt(sheetObj.GetDataRowHeight()) * 5, 4000, "X");
                break;
        }
    }
 	
 	/**
     * Calling Function in case of OnSearchEnd event <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg)  {
    	if (errMsg == "") {
    		var formObj=document.form;
    		if(!ComIsNull(formObj.srch_taa_no.value)) {
    			formObj.srch_chk_taa_no.checked=true;
    			sheetObjects[0].SetColHidden("taa_no",0);
    		}
    	}
   	}   
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param (object) formObj Mandatory Form Object
     * @param (string) sAction Mandatory  
     * @return void
     * @author 
     * @version 2009.12.04
     */
    function validateForm(sheetObj,formObj,sAction){
    	var scopeObj=srch_trf_cd;
    	switch (sAction) {
    		case IBSEARCH: // retrieving
		     	//if(ComIsNull(comboObjects[0].text)) {
    			if(null == scopeObj.GetSelectCode()|| "" == scopeObj.GetSelectCode()){
		     		ComShowCodeMessage('PRI00337','Tariff Code');
		            return false;
		        }
    			if(!ComChkRequired(formObj)) return false;
		     	return true;
		        break;
    	}
        return true;
    }
