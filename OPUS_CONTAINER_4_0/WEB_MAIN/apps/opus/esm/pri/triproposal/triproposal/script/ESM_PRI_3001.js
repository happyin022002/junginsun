/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_3001.js
 *@FileTitle  : TRI Creation & Amendment
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ESM_PRI_3001 : Business Script for ESM_PRI_3001
	 */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Creator. Privilege that allow to create new Proposal.
	var bIsCreUsr=false;
	// Modifier. Privilege that allows Modifying Proposal or progress Request
    var bIsReqUsr=false;
    // Authorizer. Privilege that allow to Approve, Publish. Etc
    var bIsAproUsr=false;
    // Variables that shows whether current user has authority on Tariff ( means Scope )
    var bHasAuthTariff=false;
    var arrTermOrg=new Array();
    var arrTermDest=new Array();
    var arrTransMode=new Array();
    var BACKEND_JOB_ID="";
    var TIMER_ID="";
    var ARRAY_BACKENDJOB_TYPE=new Array();
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
	 * @version 2009.05.01
	 */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve_s":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					break;
				case "btn_new_s":
					doActionIBSheet(sheetObjects[0], document.form, IBRESET);
					break;
				case "btn_grical_s":
					ComOpenPopup("ESM_PRI_3010.do?" + FormQueryString(formObject), 950, 650, "", "1,0", false);
					break;
				case "btn_request_s":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC11);
					break;
				case "btn_rcancel_s":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC15);
					break;
				case "btn_approve_s":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC12);
					break;
				case "btn_acancel_s":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC16);
					break;
				case "btn_publish_s":
		            if (!validateForm(sheetObjects[0], document.form, IBSEARCH_ASYNC13)) {
		                return false;
		            }
		            var sUrl="/opuscntr/ESM_PRI_3018.do?" + FormQueryString(document.form);
					ComOpenPopup(sUrl, 450, 180, "", "1,0", true);
					break;
				case "btn_downexcel_s":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel({
						       SheetDesign : 1,
						       Merge : 1,
						       ExcelFontSize : 10,
						       DownCols: "2|3|8|9|10|11|12|13|14|15|16|17|18|19|20|22|23|24|26|27|28|29|31|32",
						       ExcelRowHeight : "18",
						       AutoSizeColumn : 1
						      });
					}
					break;
				case "srch_btn_srch_cmdt":
		            var sUrl="/opuscntr/ESM_PRI_4027.do?" + FormQueryString(document.form);
		            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";
		            ComOpenPopup(sUrl, 700, 345, "callback4027", "1,0", true);
					break;
				case "srch_is_gri_appl":
					break;
				case "srch_btn_acc_dt":
				    var cal=new ComCalendar();
				    cal.select(formObject.srch_acc_dt, 'yyyy-MM-dd');
					break;
				case "srch_btn_grieffdt":
	                var cal=new ComCalendar();
	                cal.select(formObject.srch_gri_eff_dt, 'yyyy-MM-dd');
					break;
				case "btn_conversion":
					  var pgmNo="ESM_PRI_3006";
	                  var pgmUrl="/opuscntr/ESM_PRI_3006.do"
	                  var parentPgmNo=pgmNo.substring(0, 8)+'M001';  
	                  var param="&trf_cd="+comboObjects[0].GetSelectCode();
	                  var src="&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + param;
	                  var sUrl="ESM_PRI_3006.do?parentPgmNo=" + parentPgmNo + src;
	                  var iWidth=1024;
	                  var iHeight=700;
	                  var leftpos=(screen.width - iWidth) / 2;
	                  if (leftpos < 0)
	                      leftpos=0;
	                  var toppos=(screen.height - iHeight) / 2;
	                  if (toppos < 0)
	                      toppos=0;
	                  var sFeatures="status=no, resizable=yes, scrollbars=yes, width="+iWidth+", left="+leftpos+", top="+toppos;
	                  window.open(sUrl, "");
					break;
				case "btn_srch_cmdt":
		            var sUrl="ESM_PRI_4027.do?" + FormQueryString(document.form);
		            sUrl += "&grp_cd=" + PRI_SP_SCP + "&commodity_cmd=C";
		            ComOpenPopupScroll(sUrl, 700, 325, "callback4027_2", "1,0", true, 50);
					break;
				case "btn_taalist":
					var sUrl="/opuscntr/ESM_PRI_3004.do?" + FormQueryString(document.form);
					ComOpenPopup(sUrl, 1000, 340, "", "1,0", true);
					break;
				case "btn_srch_org_pnt":
					onClickRoutePoint(srcName);
					break;
				case "btn_srch_org_via":
					onClickRoutePoint(srcName);
					break;
				case "btn_srch_dest_via":
					onClickRoutePoint(srcName);
					break;
				case "btn_srch_dest_pnt":
					onClickRoutePoint(srcName);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObjects[1], document.form, IBCREATE);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[1], document.form, IBSAVE);
					break;
				case "btn_request":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
					break;
				case "btn_amend":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);
					break;
				case "btn_coffer":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
					break;
				case "btn_approve":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC04);
					break;
				case "btn_publish":
		            var sUrl="/opuscntr/ESM_PRI_3015.do?" + FormQueryString(document.form);
		            sUrl += "&eff_dt=" + ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "eff_dt"), "ymd");
		            sUrl += "&exp_dt=" + ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "exp_dt"), "ymd");
		            sUrl += "&last_pub_dt=";		            
		            if (sheetObjects[1].RowCount()>= 2) {
		            	sUrl += ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows()+ 1, "pub_dt"), "ymd");
		            }		            
					ComOpenPopupScroll(sUrl, 500, 330, "", "1,0", true, 50);
					
					break;
				case "btn_assign":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC06);
					break;
				case "btn_cancel":
					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC07);
					break;
				case "btn_copy":
					doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
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
	
	function callback4027(rtnVal){
		if (rtnVal != null){
			document.form.srch_cmdt_cd.value=rtnVal.cd;
			//formObject.srch_cmdt_nm.value = rtnVal.nm;
		}
	}
	function callback4027_2(rtnVal){
		if (rtnVal != null){
			var formObject = document.form;
			formObject.srch_cmdt_cd.value=rtnVal.cd;
			//formObject.srch_cmdt_nm.value = rtnVal.nm;
			formObject.cmdt_cd.value=rtnVal.cd;
			formObject.cmdt_nm.value=rtnVal.nm;
			formObject.cmdt_cd.readOnly=true;
			btnImgEnable("btn_srch_cmdt", false);
		}
	}
	
	/**
	 * calling function in case of OnClick Event on Route Select <br>
	 *
	 * @param {string} colName Mandatory Source name that Onclick event triggered
	 * @return void
	 * @author 
	 * @version 2009.11.21
	 */
    function onClickRoutePoint(colName) {
        var formObj=document.form;
        var sUrl="/opuscntr/ESM_PRI_3016.do?" + FormQueryString(document.form);
        if (colName == "btn_srch_org_pnt") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopupScroll(sUrl, 700, 350, "", "1,0", true, 50);
        }
        if (colName == "btn_srch_org_via") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopupScroll(sUrl, 700, 350, "", "1,0", true, 50);
        }
        if (colName == "btn_srch_dest_via") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopupScroll(sUrl, 700, 350, "", "1,0", true, 50);
        }
        if (colName == "btn_srch_dest_pnt") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopupScroll(sUrl, 700, 350, "", "1,0", true, 50);
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
	 * @version 2009.05.01
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * registering IBCombo Object as list</b>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setComboObject(combo_obj);
	 * </pre>
	 * @param {ibcombo} combo_obj Mandatory IBCombo Object
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}

	/**
	 * Initializing Page.
	 */
	function loadPage() {
        for (var i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
        doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
		axon_event.addListenerForm("focus", "obj_focus", document.form);
		axon_event.addListenerForm("blur", "obj_blur", document.form);
		axon_event.addListenerFormat("keydown", "obj_keydown", document.form);
		document.form.is_req_usr.value=bIsReqUsr;
		document.form.is_apro_usr.value=bIsAproUsr;
        toggleButtons("CLEAR");
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
    /**
     * Handling OnKeyDown event <br> when Enter key press at search condition, process retrieve.
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */       
   function obj_keydown(){
       var eleName=ComGetEvent("name");//event.srcElement.name;
       if (eleName.indexOf("srch_") == 0) {
	       var keyValue=null;
	       if (event == undefined || event == null) {
	    	   keyValue=13;
	       } else {
	    	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	       }
	       if (keyValue == 13) {
	    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	       }
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
	 * @version 2009.04.17
	 */
	function obj_focus() {
		var formObj=document.form;
	    var srcName=ComGetEvent("name");
	    if (srcName == "srch_tri_no") {
	    	formObj.srch_tri_no.value=formObj.srch_tri_no.value.replace(RegExp(/-/ig), "");
	    }
	}
	/**
	 * Handling Onbeforedeactivate event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_blur()
	 * </pre>
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.04.17
	 */
	function obj_blur() {
		var formObj=document.form;
	    var srcName=ComGetEvent("name");
		if (srcName == "srch_gri_eff_dt") {
			ComChkObjValid(ComGetEvent());
		} else if (srcName == "srch_acc_dt") {
			ComChkObjValid(ComGetEvent());
			// Insert '-' from tri_no or search condition
		} else if (srcName == "srch_tri_no") {
			var sTriNo = formObj.srch_tri_no.value.replace(/-/g, '');
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
					//formObj.srch_cmdt_nm.value = arrData[1];
				} else {
		    		formObj.srch_cmdt_cd.value="";
		    		//formObj.srch_cmdt_nm.value = "";
		    		return false;
				}
	    	} else {
	    		formObj.srch_cmdt_cd.value="";
	    		//formObj.srch_cmdt_nm.value = "";
	    	}
	    } else if (srcName == "cmdt_cd") {
	    	if (formObj.cmdt_cd.readOnly) {
	    		return;
	    	}
	    	if (formObj.cmdt_cd.value.length == 6) {
				formObj.f_cmd.value=SEARCH08;
				var param="&cd=" + formObj.cmdt_cd.value;
				var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null && arrData.length > 0 && arrData[1] != "") {
					formObj.cmdt_nm.value=arrData[1];
//					formObj.cmdt_cd.readOnly = true;
//					btnImgEnable("btn_srch_cmdt", false);
				} else {
		    		formObj.cmdt_cd.value="";
		    		formObj.cmdt_nm.value="";
		    		return false;
				}
	    	} else {
	    		formObj.cmdt_cd.value="";
	    		formObj.cmdt_nm.value="";
	    	}
	    	sheetObjects[1].SetCellValue(sheetObjects[1].LastRow(), "cmdt_cd",formObj.cmdt_cd.value,0);
	    	if (sheetObjects[1].IsDataModified()&& formObj.ibflag.value != "I") {
	    		formObj.ibflag.value="U";
	    	}
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
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
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
	        case "srch_tri_apro_ofc_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            	SetMaxLength(5);
	            }
	            break;
	        case "srch_prop_sts_cd":
	            with(comboObj) {
	            	SetDropHeight(260);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
	            }
	            break;
	    }
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
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle="|Sel.|Seq.|Tariff Rate Item\n(TRI)|trf_cd|trf_pfx_cd|trf_no|amdt_seq|Commodity|Commodity|Route|Route|Route|Route|Per|CGO\nType|Cur.|Rate|C.offer|Final|Note|note_conv_mapg_id|Publication\nDate|Effective\nDate|Expiration\nDate|prop_sts_cd|Status|Request\nOffice|Approval\nOffice|Proposal No.|Internal\nRemark|GRI|GRI|Send Date|tri_rqst_usr_id|tri_apro_usr_id|last_pub_dt|org_rout_pnt_loc_nm_snd|org_rout_via_port_nm_snd|dest_rout_via_port_nm_snd|dest_rout_pnt_loc_nm_snd|cur_status|prs_rt_cmpb_calc_flg";
				var HeadTitle1="|Sel.|Seq.|Tariff Rate Item\n(TRI)|trf_cd|trf_pfx_cd|trf_no|amdt_seq|Code|Description|Origin|Origin Via|Dest Via|Dest|Per|CGO\nType|Cur.|Rate|C.offer|Final|Note|note_conv_mapg_id|Publication\nDate|Effective\nDate|Expiration\nDate|prop_sts_cd|Status|Request\nOffice|Approval\nOffice|Proposal No.|Internal\nRemark|||Send Date|tri_rqst_usr_id|tri_apro_usr_id|last_pub_dt|org_rout_pnt_loc_nm_snd|org_rout_via_port_nm_snd|dest_rout_via_port_nm_snd|dest_rout_pnt_loc_nm_snd|cur_status|prs_rt_cmpb_calc_flg";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk"},
				 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"tri_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trf_cd",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trf_pfx_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trf_no",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:115,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_nm",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"org_rout_pnt_loc_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"org_rout_via_port_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"dest_rout_via_port_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Left",    ColMerge:1,   SaveName:"dest_rout_pnt_loc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"coffr_frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"fnl_frt_rt_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"note_ctnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"note_conv_mapg_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pub_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prop_sts_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prop_sts_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tri_rqst_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tri_apro_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"tri_rmk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"gri_appl_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"gri_appl_amt",               KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tri_rqst_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tri_apro_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"last_pub_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_rout_pnt_loc_nm_snd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"org_rout_via_port_nm_snd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_rout_via_port_nm_snd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_rout_pnt_loc_nm_snd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cur_status",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prs_rt_cmpb_calc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(260);
				SetEditable(1);
				SetEllipsis(1);
				SetAutoRowHeight(0);
				SetShowButtonImage(2);
				//SetRangeBackColor(1,7,1,13,"#555555");
			}
			break;
		case "sheet2":
			with(sheetObj){
				var HeadTitle="|tri_prop_no|Seq.|prop_sts_cd|Status|Approval\nOffice|Publication\nDate|Effective\nDate|Expiration\nDate|Per|CGO\nType|Cur|Rate|C.offer|Final|Note|Note|note_conv_mapg_id|Approval\nStaff|Approval\nStaff|Request\nOffice|Request\nStaff|Request\nStaff|Internal\nRemark|GRI|GRI|Send Date|tri_no|cmdt_cd|prs_rt_cmpb_calc_flg";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"tri_prop_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prop_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prop_sts_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tri_apro_ofc_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pub_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"prop_frt_rt_amt",       KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_pop",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_apro_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tri_apro_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tri_rqst_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_rqst_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"tri_rqst_usr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"tri_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"gri_appl_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prs_rt_cmpb_calc_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(150);
				SetEditable(1);
				SetEllipsis(1);
				//SetAutoRowHeight(0);
				SetShowButtonImage(2);
			}
			break;
        case "sheet3":  // Grid 2's Origin Point
			with(sheetObj){			
				var HeadTitle="3-1|3-2|3-3|3-4|3-5|3-6|3-7|3-8";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );			
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet4":  // Grid 2's Origin Via.
			with(sheetObj){				
				var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet5":  // Grid 2's Destination Via.
			with(sheetObj){				
				var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet6":  // Grid 2's Destination Point
			with(sheetObj){
				var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"tri_prop_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
	        }
            break;
    	case "sheet7": // Note Conversion
			with(sheetObj){
				var HeadTitle="|Sel.|Code|Application\nEffective|Application\nExpires|Application|Per|Cargo\nType|IMDG\nClass|Cal.|Cur.|Amount" + "|Pay Term|Weight\n(Ton <=)|Weight\n( > Ton)|SOC|T/S\nPort|Direct\nCall|Bar Type|S/I" + "|1|2|3|4|5|6|7|8|9|10|11|12";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"tri_prop_no" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
    		break;
		}
	}
	/**
	 * calling function in case of OnSelectCell event <br>
	 * Retrieve data from Sub-level Table (Rate, Route etc )
	 * When selection checkboxes are being clicked, Because the delay happens while retrieving sub-level data, it is difficult to process rapidly
	 * so, when the row selection checkbox of sheet clicked, do not retrieve sub-level data directly. 2 seconds after checkbox clicked. Retrieve it.
	 * when clicked except chk column, Execute Descendant table retrieving directly
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	var fireEvent=true;
	var prevTimeoutID="";
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	ComOpenWait(true);
    	var colName=sheetObj.ColSaveName(NewCol);
    	var formObj=document.form;
    	// When checkbox is clicked, Make 2 secounds delay. Not Retrieve directly.
    	if (colName == "chk") {
    		if (prevTimeoutID) {
    			self.clearTimeout(prevTimeoutID);
    		}
    		prevTimeoutID=self.setTimeout("checkMDSync()", 2000);
    		ComOpenWait(false);
    		return false;
    	}
    	if (OldRow != NewRow && fireEvent && sheetObj.RowCount() > 0) {
    		formObj.ibflag.value="R";
    		formObj.tri_prop_no.value=sheetObj.GetCellValue(NewRow, "tri_prop_no");
    		formObj.tri_no.value=sheetObj.GetCellValue(NewRow, "tri_no");
    		formObj.prop_sts_cd.value=sheetObj.GetCellValue(NewRow, "prop_sts_cd");
    		formObj.amdt_seq.value=sheetObj.GetCellValue(NewRow, "amdt_seq");
    		formObj.cmdt_cd.value=sheetObj.GetCellValue(NewRow, "cmdt_cd");
    		formObj.cmdt_nm.value=sheetObj.GetCellValue(NewRow, "cmdt_nm");
			formObj.trf_pfx_cd.value=sheetObj.GetCellValue(NewRow, "trf_pfx_cd");
			formObj.trf_no.value=sheetObj.GetCellValue(NewRow, "trf_no");
    		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	} else if (sheetObj.RowCount() == 0) {
    		formObj.ibflag.value="";
    		formObj.tri_prop_no.value="";
    		formObj.tri_no.value="";
    		formObj.prop_sts_cd.value="";
    		formObj.amdt_seq.value="";
    		formObj.cmdt_cd.value="";
    		formObj.cmdt_nm.value="";
//			formObj.trf_pfx_cd.value="";
//			formObj.trf_no.value="";
    	}
    	ComOpenWait(false);
    }
	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "note_ctnt") {
			ComShowMemoPad(sheetObj, Row, Col, true, 550, parseInt(sheetObj.GetDataRowHeight()) * 7);
		}
		else if (colName == "tri_rmk") {
			ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.GetColWidth(Col), parseInt(sheetObj.GetDataRowHeight()) * 5, 4000, "X");
		}
	}
	
    function checkMDSync() {
    	if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tri_prop_no") != sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "tri_prop_no")) {
    		sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].GetSelectRow(), 0);
    	}
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	
        if (sheetObj.RowCount() == 0) {
        	sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].HeaderRows(), -1);
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
	 * @version 2009.05.20
	 */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "" && sheetObj.RowCount() > 0) {
        	document.form.tri_no.value=sheetObj.GetCellValue(sheetObj.HeaderRows(), "tri_no");
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
	 * @version 2009.05.20
	 */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	origin_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermOrg[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "<br>";
                origin_desc.innerHTML += sStr;
            }
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
	 * @version 2009.05.20
	 */
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	ovia_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_nm");
                sStr += "<br>";
                ovia_desc.innerHTML += sStr;
            }
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
	 * @version 2009.05.20
	 */
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dvia_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_nm");
                sStr += "<br>";
                dvia_desc.innerHTML += sStr;
            }
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
	 * @version 2009.05.20
	 */
    function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dest_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermDest[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "<br>";
                dest_desc.innerHTML += sStr;
            }
        }
    }
    
    function SheetObject(sheet, row, col, rtnVal){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 		this.rtnVal = rtnVal;
 	}
 	var _tmp_sheetObject;
 	
 	function callback3002(rtnVal){
 		if (rtnVal != null){
 			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "note_ctnt",rtnVal.note_ctnt);
 			_tmp_sheetObject.sheet.SetToolTipText(_tmp_sheetObject.row, "note_ctnt",rtnVal.note_ctnt);
		}
 	}
    
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        _tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
        if (colName == "note_ctnt_pop") {
        	if (sheetObj.GetCellValue(Row, "eff_dt") == "" || sheetObj.GetCellValue(Row, "exp_dt") == "") {
        		ComShowCodeMessage("PRI01024");
        		return;
        	}
        	var sParam="";
			sParam += "trf_pfx_cd=" 		+ formObj.trf_pfx_cd.value;
			sParam += "&trf_no=" 			+ formObj.trf_no.value;
			sParam += "&tri_prop_no=" 		+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tri_prop_no");
			sParam += "&amdt_seq=" 			+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "amdt_seq");
			sParam += "&note_conv_mapg_id=" + sheetObj.GetCellValue(Row, "note_conv_mapg_id");
			sParam += "&eff_dt=" 			+ sheetObj.GetCellValue(Row, "eff_dt");
			sParam += "&exp_dt=" 			+ sheetObj.GetCellValue(Row, "exp_dt");
			sParam += "&note_ctnt=" 		+ encodeURIComponent(sheetObj.GetCellValue(Row, "note_ctnt"));
			var isEditable="N";
			if (bIsReqUsr && sheetObj.GetCellValue(Row, "prop_sts_cd") == "I") {
				isEditable="Y";
			} else if (bIsAproUsr && sheetObj.GetCellValue(Row, "prop_sts_cd") == "Q") {
				isEditable="M";
			}
			sParam += "&is_editable="		+ isEditable;
			if(sheetObj.GetCellValue(Row, "prop_sts_cd") != "I" && sheetObj.GetCellValue(Row, "prop_sts_cd") != "Q") {
				var sUrl="/opuscntr/ESM_PRI_3003.do?" + sParam;
	            ComOpenPopupScroll(sUrl, 800, 500, "", "1,0", true, 50);
			} else {
				var sUrl="/opuscntr/ESM_PRI_3002.do?" + sParam;
	            ComOpenPopupScroll(sUrl, 800, 500, "callback3002", "1,0", true, 50);
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
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
            	var validPerClass="D,A,F,O,Q,S,P";
            	var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","");
                }
            }
        }
        if (colName == "rat_ut_cd") {
        	var validPerClass="A,F,O,Q,S,P";
        	var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","DR");
            } else if (perClass == "R") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","RF");
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","AK");
            } else {
            	if (sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","");
            	}
            }
        }
        if (colName == "eff_dt") {
        	// When eff_dt > exp_dt, Clear it
        	if (sheetObj.GetCellValue(Row, "eff_dt") != "" && sheetObj.GetCellValue(Row, "exp_dt") != "") {
        		if (sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")) {
	                ComShowCodeMessage("PRI00346");
	            	sheetObj.SetCellValue(Row, Col,"",0);
	            	sheetObj.SelectCell(Row, Col);
	                return false;
	            }
        	}
        	// Previous eff_dt <= eff_dt <= Previous end_dt
            if (sheetObj.RowCount()> 1) {
            	// When eff_dt > Previous exp_dt, Clear it. Previous eff_dt <= eff_dt <= Previous end_dt
//            	if (sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row + 1, "exp_dt")) {
//            		ComShowCodeMessage("PRI00353", ComGetMaskedValue(sheetObj.GetCellValue(Row + 1, "exp_dt"), "ymd"));
//                	sheetObj.SetCellValue(Row, Col,"",0);
//                	sheetObj.SelectCell(Row, Col);
//                    return false;
//                }
                // When eff_dt < Previous eff_dt
            	if (sheetObj.GetCellValue(Row, "eff_dt") <= sheetObj.GetCellValue(Row + 1, "eff_dt")) {
            		ComShowCodeMessage("PRI00354", ComGetMaskedValue(sheetObj.GetCellValue(Row + 1, "eff_dt"), "ymd"));
                	sheetObj.SetCellValue(Row, Col,"",0);
                	sheetObj.SelectCell(Row, Col);
                    return false;
                }
            }
            adjustNoteConvDate();
        }
        if (colName == "exp_dt") {
        	if (sheetObj.GetCellValue(Row, "eff_dt") != "" && sheetObj.GetCellValue(Row, "exp_dt") != "") {
        		// Check begin Data > End date
        		if (sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")) {
	            	ComShowCodeMessage("PRI00345");
	            	sheetObj.SetCellValue(Row, Col,"",0);
	            	sheetObj.SelectCell(Row, Col);
	                return false;
	            }
	            adjustNoteConvDate();
        	}
        }
    }
	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @version 2009.05.01
	 */
	function sheet2_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "note_ctnt") {
			if (sheetObj.GetCellEditable(Row, "prop_frt_rt_amt")) {
				ComShowMemoPad(sheetObj, Row, Col, false, 550, parseInt(sheetObj.GetDataRowHeight()) * 7);
			} else {
				ComShowMemoPad(sheetObj, Row, Col, true, 550, parseInt(sheetObj.GetDataRowHeight()) * 7);
			}
		}
		else if (colName == "tri_rmk") {
			if (sheetObj.GetCellEditable(Row, "prop_frt_rt_amt")) {
				ComShowMemoPad(sheetObj, Row, Col, false, sheetObj.GetColWidth(Col), parseInt(sheetObj.GetDataRowHeight()) * 5);
			} else {
				ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.GetColWidth(Col), parseInt(sheetObj.GetDataRowHeight()) * 5);
			}
		} 
	}
	
    function adjustNoteConvDate() {
    	var idx=sheetObjects[1].HeaderRows();
    	var effDt=sheetObjects[1].GetCellValue(idx, "eff_dt");
    	var expDt=sheetObjects[1].GetCellValue(idx, "exp_dt");
    	for (var i=sheetObjects[6].LastRow(); sheetObjects[6].RowCount()> 0 && i >= sheetObjects[6].HeaderRows(); i--) {
    		if (sheetObjects[6].GetRowStatus(i) == "D") {
    			continue;
    		}
    		// When rule code is APP, Do not Conversion.
    		if (sheetObjects[6].GetCellValue(i, "note_conv_rule_cd") == "APP") {
    			continue;
    		}
    		if (sheetObjects[6].GetCellValue(i, "note_conv_mapg_id") == sheetObjects[1].GetCellValue(idx, "note_conv_mapg_id")) {
    			// When Conversion data exceed Rate duration, located in front of that. Delete it.
    			if (sheetObjects[6].GetCellValue(i, "exp_dt") < effDt) {
    				sheetObjects[6].SetRowHidden(i,1);
    				sheetObjects[6].SetRowStatus(i,"D");
    			}
    			// When Conversion data exceed Rate duration, located in back of that. Delete it.
    			if (sheetObjects[6].GetCellValue(i, "eff_dt") > expDt) {
    				sheetObjects[6].SetRowHidden(i,1);
    				sheetObjects[6].SetRowStatus(i,"D");
    			}
    		}
    	}
    	for (var i=sheetObjects[6].LastRow(); sheetObjects[6].RowCount()> 0 && i >= sheetObjects[6].HeaderRows(); i--) {
    		if (sheetObjects[6].GetRowStatus(i) == "D") {
    			continue;
    		}
    		// Don't allow Conversion data exceed the duration of Rate
    		if (sheetObjects[6].GetCellValue(i, "note_conv_mapg_id") == sheetObjects[1].GetCellValue(idx, "note_conv_mapg_id")) {
    			if (sheetObjects[6].GetCellValue(i, "eff_dt") < effDt) {
    				sheetObjects[6].SetCellValue(i, "eff_dt",effDt,0);
    			}
    			if (sheetObjects[6].GetCellValue(i, "exp_dt") > expDt) {
    				sheetObjects[6].SetCellValue(i, "exp_dt",expDt,0);
    			}
    		}
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		ComOpenWait(true);
        try {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBCLEAR: 
	            var sXml="";  
	            // per combo
	            formObj.f_cmd.value=SEARCH03;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D4");
	            //common cargo
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", false, 0, "DR");
	            //currency combo
	            formObj.f_cmd.value=SEARCH06;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "curr_cd", false, 0, "USD");
				//common Term Origin
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02070");
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				for (var i=0; i < arrTemp.length; i++) {
					arrTermOrg[arrTemp[i][0]]=arrTemp[i][1];
				}
				//common Term Destination
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02071");
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				for (var i=0; i < arrTemp.length; i++) {
					arrTermDest[arrTemp[i][0]]=arrTemp[i][1];
				}
				//common  Trans. Mode
				formObj.f_cmd.value=SEARCH19;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01720");
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				for (var i=0; i < arrTemp.length; i++) {
					arrTransMode[arrTemp[i][0]]=arrTemp[i][1];
				}
				// Tariff Code
	            formObj.f_cmd.value=SEARCHLIST12;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            ComPriXml2ComboItem(sXml, srch_trf_cd, "cd", "cd|nm");
				// Approval Office Code
	            formObj.f_cmd.value=COMMAND14;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=APP_CODE");
	            ComPriXml2ComboItem(sXml, srch_tri_apro_ofc_cd, "cd", "cd|nm");
	            setIBCombo(sheetObjects[1], sXml, "tri_apro_ofc_cd", true, 0, "", "", true);
	            comboObjects[1].InsertItem(0, "", "");
	            // TRI PROPOSAL STATUS CODE
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02395");
	            ComPriXml2ComboItem(sXml, srch_prop_sts_cd, "cd", "nm");
	            comboObjects[2].InsertItem(0, "", "");
	            break;
			case IBRESET: // New
	            for (var i=0; i < sheetObjects.length; i++) {
	                sheetObjects[i].RemoveAll();
	            }
	            for (var i=0; i < comboObjects.length; i++) {
	            	comboObjects[i].SetSelectIndex(-1 , false);
	            }
	            
	            formObj.srch_trf_nm.value="";
	            formObj.srch_trf_pfx_cd.value="";
	            formObj.srch_trf_no.value="";
	            formObj.ibflag.value="";
	            formObj.trf_pfx_cd.value="";
	            formObj.trf_no.value="";
	            formObj.prop_sts_cd.value="";
	            formObj.amdt_seq.value="";
	            formObj.srch_cmdt_cd.value="";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value="";
	            formObj.srch_org_rout_pnt_loc_nm.value="";
	            formObj.srch_org_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_pnt_loc_nm.value="";
	            formObj.srch_tri_rqst_ofc_cd.value="";
	            formObj.srch_tri_no.value="";
	            formObj.srch_tri_prop_no.value="";
	            formObj.srch_is_gri_appl.checked=false;
	            formObj.srch_gri_eff_dt.value="";
	            formObj.ibflag.value="";
	            formObj.tri_no.value="";
	            formObj.tri_prop_no.value="";
	            formObj.cmdt_cd.value="";
	            formObj.cmdt_nm.value="";
	            formObj.prop_sts_cd.value="";
	            origin_desc.innerHTML="";
	            ovia_desc.innerHTML="";
	            dvia_desc.innerHTML="";
	            dest_desc.innerHTML="";
	            toggleButtons("CLEAR");
	            break;
			case IBSEARCH: // retrieving
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                // When retrieve main grid (sheet1), Approve Auth. Check
	    			formObj.f_cmd.value=SEARCHLIST16;
	    			var sParam=FormQueryString(formObj) + "&etc1=S&etc2=" + formObj.usr_id.value + "&etc3=" + formObj.trf_pfx_cd.value + "&etc4=" + formObj.trf_no.value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	    			var arrAuth=ComPriXml2Array(sXml, "prc_ctrt_tp_cd|svc_scp_cd|usr_id");
	    			if (arrAuth != null && arrAuth.length > 0) {
	    				bHasAuthTariff=true;
	    			} else {
	    				bHasAuthTariff=false;
	    			}
	    			// Grid1 Search
	                formObj.f_cmd.value=SEARCH01;
	                sheetObj.DoSearch("ESM_PRI_3001GS.do", FormQueryString(formObj), {Sync:2} );
	                
	                if(sheetObj.RowCount()==0) {
		                setAuthority();
		                toggleButtons("INIT");
//	                	sheet1_OnSelectCell(sheetObj, 0, 0, 1, 0);
	                }
	            } else if (sheetObj.id == "sheet2") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH02;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_3001GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[5].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[6].LoadSearchData(arrXml[5],{Sync:1} );
	                formObj.prop_sts_cd.value=sheetObj.GetCellValue(sheetObj.HeaderRows(), "prop_sts_cd");
	                formObj.amdt_seq.value=sheetObj.GetCellValue(sheetObj.HeaderRows(), "amdt_seq");
	                setAuthority();
	                toggleButtons("INIT");
	            }
	            break;
			case IBSAVE: // Saving
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=MULTI01;
	            var sParam=FormQueryString(formObj);
	            var sParamSheet2=sheetObjects[1].GetSaveString();
	            if (sParamSheet2 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	            }
	            var sParamSheet3=sheetObjects[2].GetSaveString();
	            if (sParamSheet3 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	            }
	            var sParamSheet4=sheetObjects[3].GetSaveString();
	            if (sParamSheet4 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
	            }
	            var sParamSheet5=sheetObjects[4].GetSaveString();
	            if (sParamSheet5 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
	            }
	            var sParamSheet6=sheetObjects[5].GetSaveString();
	            if (sParamSheet6 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
	            }
	            var sParamSheet7=sheetObjects[6].GetSaveString();
	            if (sParamSheet7 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
	            }
	            if (!ComPriConfirmSave()) {
	                return false;
	            }
	            // Check Rate duplication
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            sheetObjects[6].LoadSaveData(sXml);
	            sheetObjects[5].LoadSaveData(sXml);
	            sheetObjects[4].LoadSaveData(sXml);
	            sheetObjects[3].LoadSaveData(sXml);
	            sheetObjects[2].LoadSaveData(sXml);
	            sheetObjects[1].LoadSaveData(sXml);
	            if (sheetObjects[1].IsDataModified()
	            		|| sheetObjects[2].IsDataModified()
	            		|| sheetObjects[3].IsDataModified()
	            		|| sheetObjects[4].IsDataModified()
	            		|| sheetObjects[5].IsDataModified()
	            		|| sheetObjects[6].IsDataModified()) {
	                return false;
	            } else {
	            	comboObjects[2].SetSelectIndex(-1);
	            	// When new inserted row exists, Retrieve whole data again using new created Proposal no, and move to the new inserted row.
	            	if (formObj.ibflag.value == "I") {
	            		var newPropNo=ComGetEtcData(sXml, "NEW_PROP_NO");
	            		reloadRate(newPropNo);
	            	// 
	            	} else if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "prop_sts_cd") == "Q") {
	            		reloadRateReverse();
	            	// Retrieve again generally
	            	} else {
	            		reloadRate();
	            	}
	            	formObj.ibflag.value="R";
	            	ComPriSaveCompleted();
	                return true;
	            }
				break;
			case IBCREATE: // Input
				formObj.prop_sts_cd.value="I";
				if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            formObj.srch_cmdt_cd.value="";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value="";
	            formObj.srch_org_rout_pnt_loc_nm.value="";
	            formObj.srch_org_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_pnt_loc_nm.value="";
	            formObj.srch_tri_rqst_ofc_cd.value="";
	            formObj.srch_tri_no.value="";
	            formObj.srch_tri_prop_no.value="";
	            formObj.srch_is_gri_appl.checked=false;
	            formObj.srch_gri_eff_dt.value="";
	            formObj.ibflag.value="I";
	            formObj.tri_no.value="";
	            formObj.tri_prop_no.value="";
	            formObj.amdt_seq.value="0";
	            formObj.cmdt_cd.value="";
	            formObj.cmdt_nm.value="";
	            
	            origin_desc.innerHTML="";
	            ovia_desc.innerHTML="";
	            dvia_desc.innerHTML="";
	            dest_desc.innerHTML="";
	            for (var i=1; i < comboObjects.length; i++) {
	            	comboObjects[i].SetSelectIndex(-1);
	            }
	            for (var i=1; i < sheetObjects.length; i++) {
	                sheetObjects[i].RemoveAll();
	            }
	            var idx=sheetObjects[1].DataInsert();
	            sheetObjects[1].SetCellValue(idx, "tri_rqst_usr_id",formObj.usr_id.value);
	            sheetObjects[1].SetCellValue(idx, "curr_cd","USD");
	            sheetObjects[1].SetCellValue(idx, "prop_frt_rt_amt", "0.00");
	            sheetObjects[1].SetCellValue(idx, "curr_cd","USD");
	            sheetObjects[1].SetCellValue(idx, "prop_sts_cd","I");
	            sheetObjects[1].SetCellValue(idx, "prop_sts_nm","Initial");
	            sheetObjects[1].SetCellValue(idx, "rat_ut_cd","D4");
	            
	            // New create note_conv_mapg_id
	            formObj.f_cmd.value=COMMAND38;
	            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	            sheetObjects[1].SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            setAuthority();
	            toggleButtons("INIT");
	            ComBtnDisable("btn_request");
	            ComBtnDisable("btn_cancel");
				break;
			case IBSEARCH_ASYNC11: // Request All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Request]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY11;
	            var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            reloadRate();
	            ComShowCodeMessage("PRI01045", "Request");
				break;
			case IBSEARCH_ASYNC12: // Approve All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Approve]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY12;
	            var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	            // While in loop, set the value of Approved item. Do not retrieve again
	        	for (var i=0; i < arrCheckedRows.length; i++) {
		            sheetObjects[0].SetCellValue(arrCheckedRows[i], "prop_sts_cd","A");
		            sheetObjects[0].SetCellValue(arrCheckedRows[i], "prop_sts_nm","Approved");
		            //sheetObjects[0].CellValue(arrCheckedRows[i], "tri_apro_ofc_cd") = formObj.ofc_cd.value;
		            sheetObjects[0].SetCellValue(arrCheckedRows[i], "tri_apro_usr_id",formObj.usr_id.value);
		            sheetObjects[0].SetCellValue(arrCheckedRows[i], "fnl_frt_rt_amt",sheetObjects[0].GetCellValue(arrCheckedRows[i], "prop_frt_rt_amt"));
		            sheetObjects[0].SetRowStatus(arrCheckedRows[i],"R");
	        	}
	        	sheetObjects[0].CheckAll("chk",0,1);
	            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	            ComShowCodeMessage("PRI01045", "Approve");
				break;
			case IBSEARCH_ASYNC15: // Request Cancel All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Request Cancel]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY15;
	            var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
				break;
			case IBSEARCH_ASYNC16: // Approve Cancel All
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Approve Cancel]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY16;
	            var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString(false, true, "chk");
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
				break;
			case IBSEARCH_ASYNC01: // Request
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Request]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY01;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            reloadRate();
	            ComShowCodeMessage("PRI01045", "Request");
				break;
			case IBSEARCH_ASYNC02: // Amend
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Amend]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY02;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            formObj.srch_cmdt_cd.value="";
	            //formObj.srch_cmdt_nm.value = "";
	            formObj.srch_acc_dt.value="";
	            formObj.srch_org_rout_pnt_loc_nm.value="";
	            formObj.srch_org_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_via_port_nm.value="";
	            formObj.srch_dest_rout_pnt_loc_nm.value="";
	            formObj.srch_tri_rqst_ofc_cd.value="";
	            formObj.srch_tri_no.value="";
	            formObj.srch_tri_prop_no.value="";
	            formObj.srch_is_gri_appl.checked=false;
	            formObj.srch_gri_eff_dt.value="";
	            for (var i=1; i < comboObjects.length; i++) {
	            	comboObjects[i].SetSelectIndex(-1);
	            }
	            reloadRate();
	            ComShowCodeMessage("PRI01047");
				break;
			case IBSEARCH_ASYNC03: // C/Offer
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[C/Offer]")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY03;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            // C/Offer, Approve, TRI No. Assign, Publish.  Don't retrieve again.
	            reloadRateReverse();
	            ComShowCodeMessage("PRI01045", "C/Offer");
				break;
			case IBSEARCH_ASYNC04: // Approve
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[Approve]")) {
	                return false;
	            }
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            formObj.f_cmd.value=MODIFY04;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            reloadRateReverse();
	            ComShowCodeMessage("PRI01045", "Approve");
				break;
			case IBSEARCH_ASYNC06: // TRI No. Assign
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01032", "[TRI No. Assign]")) {
	                return false;
	            }
	            if (!validateRateDuplicate(sAction)) {
	            	return false;
	            }
	            formObj.f_cmd.value=MODIFY06;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            reloadRateReverse();
	            ComShowCodeMessage("PRI05004");
				break;
			case IBSEARCH_ASYNC07: // Cancel
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI05005")) {
	                return false;
	            }
	            formObj.f_cmd.value=MODIFY07;
	            var sParam=FormQueryString(formObj);
	            var sXml=sheetObj.GetSaveData("ESM_PRI_3001GS.do", sParam);
	            comboObjects[2].SetSelectIndex(-1);
	            // When whole Proposal data has deleted, Make the status of screen to "New"
	            if (formObj.prop_sts_cd.value == "I" && formObj.amdt_seq.value == "0") {
	            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	            	doActionIBSheet(sheetObjects[1], document.form, IBCREATE);
	            } else {
	            	reloadRate();
	            }
	            ComShowCodeMessage("PRI01047");
				break;
			case IBCOPYROW:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00012")) {
	                return false;
	            }
	            formObj.ibflag.value="I";
	            formObj.tri_no.value="";
	            formObj.tri_prop_no.value="";
	            formObj.amdt_seq.value="0";
	            formObj.prop_sts_cd.value="I";
	            var idx=sheetObjects[1].HeaderRows();
	            for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= idx + 1; i--) {
	            	sheetObjects[1].RowDelete(i, false);
	            }
				sheetObjects[1].SetCellValue(idx, "tri_prop_no","");
				sheetObjects[1].SetCellValue(idx, "amdt_seq","0");
	            sheetObjects[1].SetCellValue(idx, "prop_sts_cd","I");
	            sheetObjects[1].SetCellValue(idx, "prop_sts_nm","Initial");
	            sheetObjects[1].SetCellValue(idx, "pub_dt","");
	            sheetObjects[1].SetCellValue(idx, "rat_ut_cd","");
	            sheetObjects[1].SetCellValue(idx, "prc_cgo_tp_cd","");
	            sheetObjects[1].SetCellValue(idx, "curr_cd","");
	            sheetObjects[1].SetCellValue(idx, "prop_frt_rt_amt",0.00);
				sheetObjects[1].SetCellValue(idx, "coffr_frt_rt_amt","");
				sheetObjects[1].SetCellValue(idx, "fnl_frt_rt_amt","");
				sheetObjects[1].SetCellValue(idx, "tri_apro_usr_id","");
				sheetObjects[1].SetCellValue(idx, "tri_rqst_ofc_cd","");
				sheetObjects[1].SetCellValue(idx, "tri_rqst_usr_id",formObj.usr_id.value);
				sheetObjects[1].SetCellValue(idx, "tri_rqst_usr_nm","");
				sheetObjects[1].SetCellValue(idx, "gri_appl_tp_cd","");
				sheetObjects[1].SetCellValue(idx, "gri_appl_amt","");
				sheetObjects[1].SetCellValue(idx, "tri_no","");
	            formObj.f_cmd.value=COMMAND38;
	            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
            	var prevMapgId=sheetObjects[1].GetCellValue(idx, "note_conv_mapg_id");
	            sheetObjects[1].SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            // Prcoess Route Sheet
	            for (var a=2; a <= 5; a++) {
		            for (var i=sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount()> 0 && i <= sheetObjects[a].LastRow(); i++) {
		            	sheetObjects[a].SetRowStatus(i,"I");
		            }
	            }
	            // Process Note Coversion Sheet
	            for (var i=sheetObjects[6].LastRow(); sheetObjects[6].RowCount()> 0 && i >= sheetObjects[6].HeaderRows(); i--) {
	            	if (sheetObjects[6].GetCellValue(i, "note_conv_mapg_id") == prevMapgId) {
	            		sheetObjects[6].SetCellValue(i, "note_conv_mapg_id",sysGuid);
	            		sheetObjects[6].SetCellValue(i, "tri_prop_no","");
	            		sheetObjects[6].SetCellValue(i, "amdt_seq","");
	            		sheetObjects[6].SetRowStatus(i,"I");
	            	} else {
	            		sheetObjects[6].RowDelete(i, false);
	            	}
	            }
	            sheetObjects[1].SetRowStatus(idx,"I");
	            setAuthority();
	            toggleButtons("INIT");
	            ComBtnDisable("btn_request");
	            ComBtnDisable("btn_cancel");
				break;
			}
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
//        	if(sAction == IBSEARCH_ASYNC08 ){
//        		ComOpenWait(false);
//        	}
        } finally {
        	ComOpenWait(false);
//        	if(sAction != IBSEARCH_ASYNC08 ){
//        		ComOpenWait(false);
//        	}
        }
	}
	/**
	 * handling process for input validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *        handling logic
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {form} formObj mandatory html form object
	 * @param {int} sAction mandatory,Constant Variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : inValid
	 * @author 
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
	        case IBSEARCH: // retrieving
	        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
	                return false;
	            }
	        	return true;
	            break;
	        case IBSAVE: // Saving
	        	if (formObj.prop_sts_cd.value != "I"
		        		&& formObj.prop_sts_cd.value != "Q"
		        		&& formObj.prop_sts_cd.value != "R") {
	        		return false;
	        	}
	        	// Check whether modified data on Sheet and HTML form.
	            if (formObj.ibflag.value == "R"
	            		&& !sheetObjects[1].IsDataModified()
	                    && !sheetObjects[2].IsDataModified()
	                    && !sheetObjects[3].IsDataModified()
	                    && !sheetObjects[4].IsDataModified()
	                    && !sheetObjects[5].IsDataModified()
	                    && !sheetObjects[6].IsDataModified()) {
	                ComShowCodeMessage("PRI00301");
	                return false;
	            }
	            if (formObj.cmdt_cd.value == "") {
	                ComShowCodeMessage("PRI00316", "Commodity");
	                return false;
	            }
				if (sheetObjects[1].RowCount()<= 0
						|| sheetObjects[2].RowCount()<= 0
						|| sheetObjects[5].RowCount()<= 0) {
					ComShowCodeMessage("PRI00007");
					return false;
				}
	            if (sheetObjects[1].IsDataModified()
	                    && sheetObjects[1].GetSaveString() == "") {
	                return false;
	            }
	            if (sheetObjects[2].IsDataModified()
	                    && sheetObjects[2].GetSaveString() == "") {
	                return false;
	            }
	            if (sheetObjects[3].IsDataModified()
	                    && sheetObjects[3].GetSaveString() == "") {
	                return false;
	            }
	            if (sheetObjects[4].IsDataModified()
	                    && sheetObjects[4].GetSaveString() == "") {
	                return false;
	            }
	            if (sheetObjects[5].IsDataModified()
	                    && sheetObjects[5].GetSaveString() == "") {
	                return false;
	            }
	            if (sheetObjects[6].IsDataModified()
	                    && sheetObjects[6].GetSaveString() == "") {
	                return false;
	            }
	            // Check Eff dt > Exp date among the Rate rows
	            if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "eff_dt") > sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "exp_dt")) {
	                ComShowCodeMessage("PRI00345");
	                return false;
	            }
	            // Check Previous eff_dt <= eff_dt <= Previous end_dt
	            if (sheetObjects[1].RowCount()> 1) {
//	            	if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "eff_dt") > sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows()+ 1, "exp_dt")) {
//	            		ComShowCodeMessage("PRI00353", ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows()+ 1, "exp_dt"), "ymd"));
//	                    return false;
//	                }
	            	if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "eff_dt") <= sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows()+ 1, "eff_dt")) {
	            		ComShowCodeMessage("PRI00354", ComGetMaskedValue(sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows()+ 1, "eff_dt"), "ymd"));
	                    return false;
	                }
	            }
	            // Check the duration is more 30 days // 20140827
//	            if (document.form.amdt_seq.value == "0") {
//		            	sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows(), "exp_dt", false);
//		            	ComShowCodeMessage("PRI05012");
//	                    return false;
//	            }
	            return true;
	            break;
	        case IBCREATE: // Row Add
	        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
	                return false;
	            }
	            return true;
	            break;
	        case IBSEARCH_ASYNC11: // Request All
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasRqstAuth(arrCheckedRows[i])) {
	        			ComShowCodeMessage("PRI01033", sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no"));
						return false;
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "I"
	        			&& sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "R") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (Approval Office) 
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "tri_apro_ofc_cd") == "") {
						ComShowCodeMessage("PRI00316", "Approval Office");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (Rate Amount) 
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_frt_rt_amt") == "") {
						ComShowCodeMessage("PRI00316", "Rate");
						return false;
	        		}
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC12: // Approve All
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasAproAuth(arrCheckedRows[i])) {
	        			ComShowCodeMessage("PRI01033", sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no"));
						return false;
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "Q") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC13: // Publish All
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasAproAuth(arrCheckedRows[i])) {
	        			ComShowCodeMessage("PRI01033", sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no"));
						return false;
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (TRI No.)
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "tri_no") == "") {
						ComShowCodeMessage("PRI00316", "TRI No.");
						return false;
	        		}
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC15: // Request Cancel All
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasAproAuth(arrCheckedRows[i])) {
	        			ComShowCodeMessage("PRI01033", sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no"));
						return false;
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "Q") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (Approval Office) 
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "tri_apro_ofc_cd") == "") {
						ComShowCodeMessage("PRI00316", "Approval Office");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (Rate Amount) 
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_frt_rt_amt") == "") {
						ComShowCodeMessage("PRI00316", "Rate");
						return false;
	        		}
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC16: // Approve Cancel All
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasAproAuth(arrCheckedRows[i])) {
	        			ComShowCodeMessage("PRI01033", sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no"));
						return false;
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC01: // Request
	        	if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "tri_apro_ofc_cd") == "") {
		            ComShowCodeMessage("PRI08010", sheetObjects[1].HeaderRows(), "Approval Office");
		            return false;
	            }
	        	if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "prop_frt_rt_amt") == "") {
	            	ComShowCodeMessage("PRI08010", sheetObjects[1].HeaderRows(), "Rate");
		            return false;
	            }
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            return true;
	            break;
	        case IBSEARCH_ASYNC02: // Amend
	            return true;
	            break;
	        case IBSEARCH_ASYNC03: // C/Offer
		        if (formObj.ibflag.value != "R" 
			    		|| sheetObjects[1].IsDataModified()
			    		|| sheetObjects[2].IsDataModified()
			    		|| sheetObjects[3].IsDataModified()
			    		|| sheetObjects[4].IsDataModified()
			    		|| sheetObjects[5].IsDataModified()
			    		|| sheetObjects[6].IsDataModified()) {
			        ComShowCodeMessage("PRI00309");
			        return false;
			    }
		        if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "coffr_frt_rt_amt") == "" || sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "coffr_frt_rt_amt") <= 0.00) {
					sheetObjects[1].SelectCell(sheetObjects[1].HeaderRows(), "coffr_frt_rt_amt", false);
					ComShowCodeMessage("PRI00321", "C.offer", "0.00");
					return false;
				}
	            return true;
	            break;
	        case IBSEARCH_ASYNC04: // Approve
		        if (formObj.ibflag.value != "R" 
			    		|| sheetObjects[1].IsDataModified()
			    		|| sheetObjects[2].IsDataModified()
			    		|| sheetObjects[3].IsDataModified()
			    		|| sheetObjects[4].IsDataModified()
			    		|| sheetObjects[5].IsDataModified()
			    		|| sheetObjects[6].IsDataModified()) {
			        ComShowCodeMessage("PRI00309");
			        return false;
			    }
	            return true;
	            break;
	        case IBSEARCH_ASYNC06: // TRI No. Assign
	            return true;
	            break;
	        case IBSEARCH_ASYNC07: // Cancel
	            return true;
	            break;
	        case IBCOPYROW: // Copy
	        	if (formObj.srch_trf_pfx_cd.value == "" || formObj.srch_trf_no.value == "") {
	                return false;
	            }
		        if (formObj.ibflag.value != "R" 
			    		|| sheetObjects[1].IsDataModified()
			    		|| sheetObjects[2].IsDataModified()
			    		|| sheetObjects[3].IsDataModified()
			    		|| sheetObjects[4].IsDataModified()
			    		|| sheetObjects[5].IsDataModified()
			    		|| sheetObjects[6].IsDataModified()) {
			        ComShowCodeMessage("PRI00309");
			        return false;
			    }
	            return true;
	            break;
	        case IBSEARCH_ASYNC17: // Send
	            if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		            ComShowCodeMessage("PRI00309");
		            return false;
	            }
	            if (sheetObj.CheckedRows("chk") <= 0) {
		            ComShowCodeMessage("PRI01043");
		            return false;
	            }
	            var sValAuth="";
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	            	// Check privilege of each Row
	        		if (!hasAproAuth(arrCheckedRows[i])) {
	        			sValAuth += " " + sheetObj.GetCellValue(arrCheckedRows[i], "tri_prop_no");
	        		}
	            	// Check Status of each Row
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prop_sts_cd") != "A") {
						ComShowCodeMessage("PRI01034");
						return false;
	        		}
	            	// Check Mandatory items on each Rows (TRI No.)
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "tri_no") == "") {
						ComShowCodeMessage("PRI00316", "TRI No.");
						return false;
	        		}
	        	}
	        	// Check privilege of each Row
	    		if (sValAuth != "") {
					ComShowCodeMessage("PRI01033", sValAuth);
					return false;
	    		}
	            return true;
		            break;
	        case IBSEARCH_ASYNC08: // calculate
		        if (formObj.ibflag.value != "R" 
		        		|| sheetObjects[1].IsDataModified()
		        		|| sheetObjects[2].IsDataModified()
		        		|| sheetObjects[3].IsDataModified()
		        		|| sheetObjects[4].IsDataModified()
		        		|| sheetObjects[5].IsDataModified()
		        		|| sheetObjects[6].IsDataModified()) {
		        	ComShowCodeMessage("PRI03026", "Rate");
		            return false;
		        }
	        	return true
	        	break;
        }
	}
	/**
	 * Rate Duplication Check <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sAction mandatory,Constant Variable
	 * @returns bool <br>
	 *          true  : Valid <br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.12.01
	 */
	function validateRateDuplicate(sAction) {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH03;
		var sOrgPntKey="";
		var sOrgViaKey="";
		var sDestViaKey="";
		var sDestPntKey="";
		// Bind Route Point code to string, Send it to server, Compare this with result of Query.
		for (var i=sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount()> 0 && i <= sheetObjects[2].LastRow(); i++) {
			if (sheetObjects[2].GetRowStatus(i) == "D") {
				continue;
			}
			sOrgPntKey += "|" + sheetObjects[2].GetCellValue(i, "rout_pnt_loc_cd");
			sOrgPntKey += sheetObjects[2].GetCellValue(i, "rcv_de_term_cd");
			sOrgPntKey += sheetObjects[2].GetCellValue(i, "prc_trsp_mod_cd");
		}
		for (var i=sheetObjects[3].HeaderRows(); sheetObjects[3].RowCount()> 0 && i <= sheetObjects[3].LastRow(); i++) {
			if (sheetObjects[3].GetRowStatus(i) == "D") {
				continue;
			}
			sOrgViaKey += "|" + sheetObjects[3].GetCellValue(i, "rout_via_port_cd");
		}
		for (var i=sheetObjects[4].HeaderRows(); sheetObjects[4].RowCount()> 0 && i <= sheetObjects[4].LastRow(); i++) {
			if (sheetObjects[4].GetRowStatus(i) == "D") {
				continue;
			}
			sDestViaKey += "|" + sheetObjects[4].GetCellValue(i, "rout_via_port_cd");
		}
		for (var i=sheetObjects[5].HeaderRows(); sheetObjects[5].RowCount()> 0 && i <= sheetObjects[5].LastRow(); i++) {
			if (sheetObjects[5].GetRowStatus(i) == "D") {
				continue;
			}
			sDestPntKey += "|" + sheetObjects[5].GetCellValue(i, "rout_pnt_loc_cd");
			sDestPntKey += sheetObjects[5].GetCellValue(i, "rcv_de_term_cd");
			sDestPntKey += sheetObjects[5].GetCellValue(i, "prc_trsp_mod_cd");
		}
		var sParam="f_cmd=" + SEARCH03;
		sParam += "&srch_trf_pfx_cd=" + formObj.trf_pfx_cd.value;
		sParam += "&srch_trf_no=" + formObj.trf_no.value;
		sParam += "&srch_tri_prop_no=" + formObj.tri_prop_no.value;
		sParam += "&srch_cmdt_cd=" + formObj.cmdt_cd.value;
		sParam += "&srch_org_rout_pnt_loc_nm=" + sOrgPntKey;
		sParam += "&srch_org_rout_via_port_nm=" + sOrgViaKey;
		sParam += "&srch_dest_rout_via_port_nm=" + sDestViaKey;
		sParam += "&srch_dest_rout_pnt_loc_nm=" + sDestPntKey;
		sParam += "&srch_rat_ut_cd=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "rat_ut_cd");
		sParam += "&srch_prc_cgo_tp_cd=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "prc_cgo_tp_cd");
		sParam += "&srch_curr_cd=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "curr_cd");
		sParam += "&srch_note_ctnt=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "note_ctnt");
		sParam += "&srch_eff_dt=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "eff_dt");
		sParam += "&srch_exp_dt=" + sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "exp_dt");
		sParam += "&srch_action=" + sAction;
		var sXml=sheetObjects[1].GetSearchData("ESM_PRI_3001GS.do" , sParam);
        var dupPropNo=ComGetEtcData(sXml, "DUP_PROP_NO");
        // If there is duplication..
        if (dupPropNo != null && dupPropNo != "") {
        	// Save
    		if (sAction == IBSAVE) {
    			// Check whether save operation progress when Cargo Type is AK or BB. 
    			if (sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "prc_cgo_tp_cd") == "AK" || sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "prc_cgo_tp_cd") == "BB") {
	    			if (!ComShowCodeConfirm("PRI00343", dupPropNo)) {
	    				return false;
	    			}
	    		// In case of Other Cargo Type, Block it
    			} else {
            		ComShowCodeMessage("PRI00342", dupPropNo);
            		return false;
    			}
    		// Approve
    		} else if (sAction == IBSEARCH_ASYNC04) {
    			if (!ComShowCodeConfirm("PRI00344", dupPropNo)) {
    				return false;
    			}
    		// When TRI No. Assigned
    		} else if (sAction == IBSEARCH_ASYNC06) {
        		ComShowCodeMessage("PRI05009", dupPropNo);
        		return false;
    		}
        }
        return true;
	}
    /**
	 * Handling OnKeyDown even <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.12.17
	 */
	function srch_trf_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * Handling OnKeyDown even <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.12.17
	 */
	function srch_tri_apro_ofc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * Handling OnKeyDown even <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param  void
	 * @return void
	 * @author 
	 * @version 2009.12.17
	 */
	function srch_prop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * </pre>
	 * 
	 * @param {ibcombo}
	 *            comboObj Mandatory,  IBSheet Combo Object
	 * @param {int}
	 *            code Mandatory Onclick, Cell's value ( Code )
	 * @param {int}
	 *            text Mandatory, Characters shows on screen
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function srch_trf_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
		var formObj=document.form;
		formObj.srch_trf_pfx_cd.value=NewTxt.substring(0, 4);
		formObj.srch_trf_no.value=NewTxt.substring(5, 8);
		formObj.trf_pfx_cd.value=NewTxt.substring(0, 4);
		formObj.trf_no.value=NewTxt.substring(5, 8);
		formObj.srch_trf_nm.value=comboObj.GetText(NewTxt, 1);
		// Prevent retrieve again directly
		//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	/**
	 * Getting Sheet Data as XML format<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
        var formObj=document.form;
        var sXml="";
        var sCol="";
        var sValue="";
        if (sheetNo == 0) {
            sCol="chk";
            sValue="1";
        } else if (sheetNo == 6) {
            sCol="note_conv_mapg_id";
            sValue=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_mapg_id");
        }
        sXml=ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        return sXml;
    }
	/**
	 * Getting Sheet Data as XML format<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheetXml(sXml, sheetNo) {
        var formObj=document.form;
        var sCol="";
        var sValue="";
        var bAppendMode=0;
        if (sheetNo == 6) {
            bAppendMode=1;
            sCol="note_conv_mapg_id";
            sValue=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "note_conv_mapg_id");
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
	/**
	 * After GRI Apply, Retrieve Again.
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadRate4GRIApply(trfCd, griEffDt) {
    	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	document.form.srch_gri_eff_dt.disabled=false;
		btnImgEnable("srch_btn_grieffdt", true);
    	document.form.srch_is_gri_appl.checked=true;
    	document.form.srch_gri_eff_dt.value=griEffDt;
    	comboObjects[2].SetSelectCode("I");
    	comboObjects[0].SetSelectCode(trfCd);
    }
	/**
	 * After GRI Cancel, Retrieve Again.
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadRate4GRICancel(trfCd, trfNm) {
    	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
    	comboObjects[0].SetSelectCode(trfCd);
    }
	/**
	 * General Retreive. First Sheet1 retrieve again, and using that event, sheet2 retrievs again too.
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadRate(propNo) {
		if (propNo == null || propNo == ""){
			propNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tri_prop_no");
		}
		fireEvent=false;
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		fireEvent=true;
		var newIdx=sheetObjects[0].FindText("tri_prop_no", propNo);
		if (newIdx >= 0) {
			sheetObjects[0].SetSelectRow(newIdx);
			sheet1_OnSelectCell(sheetObjects[0], -1, -1, newIdx, -1);
		} else {
			sheetObjects[0].SetSelectRow(sheetObjects[0].HeaderRows());
			sheet1_OnSelectCell(sheetObjects[0], -1, -1, sheetObjects[0].HeaderRows(), -1);
		}
    }
	/**
	 * The function calls when you should not retrrieve again. First, Retrieve Rate(sheet2) data,
	 * Based on that data, Setting sheet1.
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadRateReverse() {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	var curHdrRow=sheetObjects[0].GetSelectRow();
    	var curDtlRow=sheetObjects[1].HeaderRows();
    	comboObjects[2].SetSelectIndex(-1);
		sheetObjects[0].SetCellValue(curHdrRow, "prop_sts_cd",sheetObjects[1].GetCellValue(curDtlRow, "prop_sts_cd"));
		sheetObjects[0].SetCellValue(curHdrRow, "prop_sts_nm",sheetObjects[1].GetCellValue(curDtlRow, "prop_sts_nm"));
		sheetObjects[0].SetCellValue(curHdrRow, "tri_apro_ofc_cd",sheetObjects[1].GetCellValue(curDtlRow, "tri_apro_ofc_cd"));
		sheetObjects[0].SetCellValue(curHdrRow, "tri_apro_usr_id",sheetObjects[1].GetCellValue(curDtlRow, "tri_apro_usr_id"));
		sheetObjects[0].SetCellValue(curHdrRow, "fnl_frt_rt_amt",sheetObjects[1].GetCellValue(curDtlRow, "fnl_frt_rt_amt"));
		sheetObjects[0].SetCellValue(curHdrRow, "tri_no",sheetObjects[1].GetCellValue(curDtlRow, "tri_no"));
		sheetObjects[0].SetCellValue(curHdrRow, "eff_dt",sheetObjects[1].GetCellValue(curDtlRow, "eff_dt"));
		sheetObjects[0].SetCellValue(curHdrRow, "exp_dt",sheetObjects[1].GetCellValue(curDtlRow, "exp_dt"));
		sheetObjects[0].SetCellValue(curHdrRow, "pub_dt",sheetObjects[1].GetCellValue(curDtlRow, "pub_dt"));
		sheetObjects[0].SetCellValue(curHdrRow, "note_ctnt",sheetObjects[1].GetCellValue(curDtlRow, "note_ctnt"));
        sheetObjects[0].SetRowStatus(curHdrRow,"R");
    }
	/**
	 * After Publish All, Refresh the values of sheet1.
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadRate4PublishAll(pubDate) {
    	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
    	comboObjects[2].SetSelectIndex(-1);
    	var sCheckedRows=sheetObjects[0].FindCheckedRow("chk");
        var arrCheckedRows=sCheckedRows.split("|");
    	for (var i=0; i < arrCheckedRows.length; i++) {
            sheetObjects[0].SetCellValue(arrCheckedRows[i], "prop_sts_cd","F");
            sheetObjects[0].SetCellValue(arrCheckedRows[i], "prop_sts_nm","Published");
            sheetObjects[0].SetCellValue(arrCheckedRows[i], "pub_dt",pubDate);
            sheetObjects[0].SetRowStatus(arrCheckedRows[i],"R");
    	}
    	sheetObjects[0].CheckAll("chk",0,1);
    }
	/**
	 * Privilege Setting 
	 * 
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
	function setAuthority() {
		var formObj=document.form;
		bIsCreUsr=false;
	    bIsReqUsr=false;
	    bIsAproUsr=false;
	    // Creator. Someone has Sales Rep. Code or has privilege on Service Scope
		if (formObj.srep_cd.value != "" || bHasAuthTariff) {
			bIsCreUsr=true;
		} else {
			bIsCreUsr=false;
		}
		// Modifier. Someone has Creation privilege and created this proposal.
		if ((formObj.srep_cd.value != "" || bHasAuthTariff) && formObj.usr_id.value == sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "tri_rqst_usr_id")) {
			bIsReqUsr=true;
		} else {
			bIsReqUsr=false;
		}
		// Authroizer. Someone has privilege in Tariff and registered in Approval Office of Proposal.
		// or HQ of soneone's Office is one of among SHAAS HAMUR NYCNA SINWA  and Approval Office of proposal is the same HQ.
		// Authroizer also have Modification privilege.
		// Discarding RHQ related business logic
		if (bHasAuthTariff && (formObj.ofc_cd.value == sheetObjects[1].GetCellValue(sheetObjects[1].HeaderRows(), "tri_apro_ofc_cd") )) {
			bIsAproUsr=true;
			bIsReqUsr=true;
		} else {
			bIsAproUsr=false;
		}
		formObj.is_req_usr.value=bIsReqUsr;
		formObj.is_apro_usr.value=bIsAproUsr;
	}
	/**
	 * Check user has approval authority of given row's proposal.
	 * 
	 * @param {int} row row number
	 * @author 
	 * @version 2009.05.01
	 */
	function hasAproAuth(row) {
		var formObj=document.form;
		// Discarding RHQ related business logic
		if (bHasAuthTariff && (formObj.ofc_cd.value == sheetObjects[0].GetCellValue(row, "tri_apro_ofc_cd") )) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Check user has request authority of given row's proposal. Approval authority also include it.
	 * 
	 * @param {int} row row number
	 * @author 
	 * @version 2009.05.01
	 */
	function hasRqstAuth(row) {
		var formObj=document.form;
		if ((formObj.srep_cd.value != "" || bHasAuthTariff) && formObj.usr_id.value == sheetObjects[0].GetCellValue(row, "tri_rqst_usr_id")) {
			return true;
		} else if (hasAproAuth(row)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Controlling all buttons as enable/Disable<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode Mandatory,user mode or authority
	 * @author 
	 * @version 2009.05.01
	 */
    function toggleButtons(mode) {
    	var formObj=document.form;
        switch (mode) {
        case "CLEAR":
        	ComBtnEnable("btn_retrieve_s");
            ComBtnEnable("btn_new_s");
            ComBtnDisable("btn_grical_s");
            ComBtnDisable("btn_request_s");
            ComBtnDisable("btn_rcancel_s");
            ComBtnDisable("btn_approve_s");
            ComBtnDisable("btn_acancel_s");
            ComBtnDisable("btn_publish_s");
/*          ComBtnDisable("btn_send_s"); */
            ComBtnDisable("btn_taalist");
            formObj.cmdt_cd.readOnly=true;
            btnImgEnable("btn_srch_cmdt", false);
            btnImgEnable("btn_srch_org_pnt", false);
            btnImgEnable("btn_srch_org_via", false);
            btnImgEnable("btn_srch_dest_via", false);
            btnImgEnable("btn_srch_dest_pnt", false);
        	ComBtnDisable("btn_retrieve");
        	ComBtnDisable("btn_new");
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_publish");
        	ComBtnDisable("btn_assign");
            ComBtnDisable("btn_cancel");
            ComBtnDisable("btn_copy");
    		for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
    		}
            break;
        case "INIT":
        	ComBtnEnable("btn_retrieve_s");
        	ComBtnEnable("btn_new_s");
        	if (bHasAuthTariff) {
	        	ComBtnEnable("btn_grical_s");
	        	ComBtnEnable("btn_request_s");
	        	ComBtnEnable("btn_rcancel_s");
	        	ComBtnEnable("btn_approve_s");
	        	ComBtnEnable("btn_acancel_s");
	        	ComBtnEnable("btn_publish_s");
/*		       	ComBtnEnable("btn_send_s"); */
        	} else {
                ComBtnDisable("btn_grical_s");
                ComBtnDisable("btn_request_s");
                ComBtnDisable("btn_rcancel_s");
                ComBtnDisable("btn_approve_s");
                ComBtnDisable("btn_acancel_s");
                ComBtnDisable("btn_publish_s");
/*              ComBtnDisable("btn_send_s"); */
        	}
        	if (formObj.tri_no.value == "") {
        		ComBtnDisable("btn_taalist");
        	} else {
        		ComBtnEnable("btn_taalist");
        	}
        	// CMDT is editable. When tri_no is not Assigned and AMDT_SEQ is zero, Initial status 
        	// Route also the same as above, however, Route could open popup, the privilege applied in popup
            if (bIsReqUsr && sheetObjects[1].RowCount()> 0
            		&& formObj.amdt_seq.value == "0"
            		&& formObj.prop_sts_cd.value == "I"
            		&& formObj.tri_no.value == "") {
            	formObj.cmdt_cd.readOnly=false;
            	btnImgEnable("btn_srch_cmdt", true);
            } else {
            	formObj.cmdt_cd.readOnly=true;
            	btnImgEnable("btn_srch_cmdt", false);
            }
            btnImgEnable("btn_srch_org_pnt", true);
            btnImgEnable("btn_srch_org_via", true);
            btnImgEnable("btn_srch_dest_via", true);
            btnImgEnable("btn_srch_dest_pnt", true);
        	ComBtnEnable("btn_retrieve");
        	if (bIsCreUsr) {
        		ComBtnEnable("btn_new");
        		ComBtnEnable("btn_copy");
        	} else {
        		ComBtnDisable("btn_new");
        		ComBtnDisable("btn_copy");
        	}
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_assign");
        	ComBtnDisable("btn_publish");
            ComBtnDisable("btn_cancel");
        	if (formObj.prop_sts_cd.value == "I") {
        		if (bIsReqUsr) {
        			ComBtnEnable("btn_save");
        			ComBtnEnable("btn_request");
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "Q") {
        		if (bIsReqUsr) {
                    ComBtnEnable("btn_cancel");
        		}
        		if (bIsAproUsr) {
        			ComBtnEnable("btn_save");
                	ComBtnEnable("btn_coffer");
                	ComBtnEnable("btn_approve");
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "R") {
        		if (bIsReqUsr) {
        			ComBtnEnable("btn_save");
        			ComBtnEnable("btn_request");
        		}
        		if (bIsAproUsr) {
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "A") {
        		if (bIsAproUsr) {
                    if (formObj.tri_no.value == "") {
                		ComBtnEnable("btn_assign");
                	} else {
                		ComBtnEnable("btn_publish");
                	}
                	ComBtnEnable("btn_cancel");
        		}
        	} else if (formObj.prop_sts_cd.value == "F") {
        		if (bIsCreUsr) {
        			ComBtnEnable("btn_amend");
        		}
        	}
        	if (bIsReqUsr || bIsAproUsr) {
        		sheetObjects[1].SetEditable(1);
	        	for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
	        		var stsCd=sheetObjects[1].GetCellValue(i, "prop_sts_cd");
//	        		if (stsCd == "A" || stsCd == "F") {
	        		sheetObjects[1].SetRowEditable(i,1);
	        		if (i == sheetObjects[1].HeaderRows()) {
	        			if (bIsReqUsr && stsCd == "I") {
	        				if (formObj.amdt_seq.value == "0") {
		        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",1);
		        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",1);
		        				sheetObjects[1].SetCellEditable(i, "curr_cd",1);
	        				} else {
		        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
		        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
		        				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
	        				}
	        				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",1);
	        				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
	        				sheetObjects[1].SetCellEditable(i, "eff_dt",1);
	        				sheetObjects[1].SetCellEditable(i, "exp_dt",1);
	        				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",1);
	        			} else if (stsCd == "Q") {
	        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
	        				if (bIsAproUsr) {
	        					sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",1);
	        				} else {
	        					sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
	        				}
	        				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
	        			} else if (stsCd == "R") {
	        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
	        				if (bIsReqUsr) {
	        					sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",1);
	        				} else {
	        					sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
	        				}
	        				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
	        				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
	        			//} else if (stsCd == "A" || stsCd == "F") {
	        			} else {
	        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
	        				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
	        				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
	        				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
	        				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
	        			}
	        		} else {
        				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
        				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
        				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
        				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
        				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
        				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
        				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
        				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
	        		}
	        	}
        	} else {
        		for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
    				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
    				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
    				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
    				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
    				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
    				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
    				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
    				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
        		}
        	}
            break;
        case "READONLY":
        	ComBtnEnable("btn_retrieve_s");
        	ComBtnEnable("btn_new_s");
            ComBtnDisable("btn_grical_s");
            ComBtnDisable("btn_request_s");
            ComBtnDisable("btn_rcancel_s");
            ComBtnDisable("btn_approve_s");
            ComBtnDisable("btn_acancel_s");
            ComBtnDisable("btn_publish_s");
/*          ComBtnDisable("btn_send_s"); */
        	if (formObj.tri_no.value == "") {
        		ComBtnDisable("btn_taalist");
        	} else {
        		ComBtnEnable("btn_taalist");
        	}
        	formObj.cmdt_cd.readOnly=true;
            btnImgEnable("btn_srch_cmdt", false);
        	btnImgEnable("btn_srch_org_pnt", true);
        	btnImgEnable("btn_srch_org_via", true);
        	btnImgEnable("btn_srch_dest_via", true);
        	btnImgEnable("btn_srch_dest_pnt", true);
        	ComBtnEnable("btn_retrieve");
        	ComBtnDisable("btn_new");
        	ComBtnDisable("btn_copy");
        	ComBtnDisable("btn_save");
        	ComBtnDisable("btn_request");
        	ComBtnDisable("btn_amend");
        	ComBtnDisable("btn_coffer");
        	ComBtnDisable("btn_approve");
        	ComBtnDisable("btn_publish");
        	ComBtnDisable("btn_assign");
            ComBtnDisable("btn_cancel");
    		for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
				sheetObjects[1].SetCellEditable(i, "rat_ut_cd",0);
				sheetObjects[1].SetCellEditable(i, "prc_cgo_tp_cd",0);
				sheetObjects[1].SetCellEditable(i, "curr_cd",0);
				sheetObjects[1].SetCellEditable(i, "prop_frt_rt_amt",0);
				sheetObjects[1].SetCellEditable(i, "coffr_frt_rt_amt",0);
				sheetObjects[1].SetCellEditable(i, "eff_dt",0);
				sheetObjects[1].SetCellEditable(i, "exp_dt",0);
				sheetObjects[1].SetCellEditable(i, "tri_apro_ofc_cd",0);
    		}
            break;
        }
    }
    /**
     * Activating and deactivating image buttons<br>
     * <br><b>Example :</b>
     * <pre>
     *    btnImgEnable(obj, gb);
     * </pre>
     * @param  {form} obj Mandatory Html Object
     * @param  {bool} gb  Mandatory true : Activating, false : Deactivation
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
    function btnImgEnable(obj, gb) {
//		if (obj.constructor == String) {
//			obj=document.getElementsByName(obj)[0];
//		}
		var btnStyle=obj.style;
		if (gb) {
			//obj.SetEnable(1);
			ComBtnEnable(obj);
			//btnStyle.cursor="pointer";
			//btnStyle.filter="";
			ComBtnEnable(obj.name);
		} else {
			//obj.SetEnable(0);
			ComBtnDisable(obj);
			//btnStyle.cursor="auto";
			//btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
			ComBtnDisable(obj.name);
		}
    }
     var oPopup=null;
     var calcStatusStr="Nothing";
     var timeID="";
     var PRE_STATUS="";
 	/**
 	 * creatiing text div in case of mouse over on calculate button<br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {object} x Mandatory, x
 	 * @param {object} y Mandatory, y
 	 * @param {object} width Mandatory, 
 	 * @param {object} height Mandatory, 
 	 * @param {object} parentObj Mandatory, parent Object
 	 * @return object, div object
 	 * @author 
 	 * @version 2009.10.01
 	 */    
     /*function openDynamicPopup(x,y,width,height,parentObj){
         if( oPopup == null){
             oPopup=window.createPopup(); 
             var oPopBody=oPopup.document.body;
             oPopBody.style.backgroundColor="lightyellow";
             oPopBody.style.border="solid black 1px";
             oPopBody.style.padding="2px"
        	 oPopBody.style.fontFamily="Tahoma,verdana,arial,dotum,gulim";
             oPopBody.style.fontSize="12px"
         }
         oPopup.document.body.innerHTML=calcStatusStr;
         oPopup.show(x,y,width,height,parentObj);
         return oPopup;
     } 
*/