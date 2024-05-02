/*=========================================================
* 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_08.js
*@FileTitle  : S/C Proposal & Amendment Creation - Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common Global Variable
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0; 
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
    // flag to ignore onclick event 
    var LoadingComplete=false;
    // Is request user?
    var bIsReqUsr=false;
    // IS approval User?
    var bIsAproUsr=false;
    // variable for Approval count
    var acptCnt=new Array();
    // Variable for not approved rate count
    var notAcptCnt=new Array();
    // whether Origin Via. is Mandatory or not
    var isOViaMandatory=false;
    // whether Dest. Via.is Mandatory or not
    var isDViaMandatory=false;
    // Whether Scope use Direct Call
    var isDirCallVisible = false;
    //variable saving whether G/L copy question ocurr or not in case of no data at first loading 
    var askOnce=true;
    //  s1:Sheet1, s2:Sheet2, s3:Sheet3
    var s1PrevRow=-1;
    var s2PrevRow=-1;
    var s3PrevRow=-1;
    var s1PrevKey=null;
    var s2PrevKey=null;
    var s3PrevKey=null;
    // Code to save Main's Summary table
    var TERMS_TYPE_CODE_GEN=71;
    var TERMS_TYPE_CODE_SPCL=72;
    // Unused Rating Unit
    //var unusedRatUtCd="|20|40|CT|DF|DW|HC|UN";
    var unusedRatUtCd = "";
    var reloadSw=false;
    var cmdtDeltChkFlg = false;
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
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
                break;
            case "btn_acceptall":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
            		var sParam=FormQueryString(formObject) + "&n_acpt_cnt=" + notAcptCnt[getGenSpclRtTpChecked()];
            		ComOpenPopup("ESM_PRI_0093.do?"+sParam, 1000, 645, "", "1,0", false);
                }
                break;
            case "btn_cancel":
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
                break;
            case "btn_glcopy":
                if (!ComShowCodeConfirm("PRI01009")) {
                	return false;
                }
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
                break;
            case "btn_gricalc":
				if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
					ComOpenPopup("ESM_PRI_0066.do?"+FormQueryString(formObject), 1000, 520, "", "1,0", false);
				}
                break;
            case "btn_viewall":
            	var prop_no=formObject.prop_no.value;
            	var amdt_seq=formObject.amdt_seq.value;
            	var svc_scp_cd=formObject.svc_scp_cd.value;
            	var gen_spcl_rt_tp_cd=getGenSpclRtTpCd();
            	if (prop_no != "" && amdt_seq != "" && svc_scp_cd != "") {
            		var sParam=FormQueryString(formObject) + "&prop_no=" + prop_no + "&amdt_seq=" + amdt_seq + "&svc_scp_cd=" + svc_scp_cd + "&gen_spcl_rt_tp_cd=" + gen_spcl_rt_tp_cd;
            		ComOpenPopup("ESM_PRI_0069.do?" + sParam,  1000, 570, "", "1,0", false);
                }
                break;
            case "btn_downexcel":
            	
            	if (formObject.prop_no.value == "" || formObject.amdt_seq.value == "" || formObject.svc_scp_cd.value == "") {
            		return;
            	}
            	
            	$(this.body).append("<div class='layer_popup_bg'></div>");
                var tabOffsetTop = $(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").offset().top;
    			var tabHeight = $(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").outerHeight() + parseInt($(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").css("margin-bottom"));
    			var tabOffsetBtm = tabOffsetTop + tabHeight + $(parent.document.getElementById(name)).outerHeight();
    			
    			$(parent.document.body)
    			.prepend("<div class='layer_popup_bgTop' style='height:"+(tabOffsetTop + tabHeight)+"px'><img src='/opuscntr/style/images/theme_default/pop_bg_logo.png' alt='' /></div>")
    			.append("<div class='layer_popup_bgBtm' style='top:"+ (tabOffsetBtm-1) +"px'></div>");
            	
            	$("#confirmDialog").dialog(
                		{
                		title : "Download Excel",
                		resizable: false,
                		beforeClose: function( event, ui ) {
                			$(this).parent().parent().find(".layer_popup_bg").remove();
        					$(parent.document.body).find(".layer_popup_bgTop,.layer_popup_bgBtm").remove();
                		},
                		buttons: [
                			{
                				text: "Vertical",
                				click: function() {
                					doActionIBSheet(sheetObjects[12], document.form, IBDOWNEXCEL);
                					$(this).dialog("close");

                				}
                			},
                			{
                				text: "Horizontal",
                				click: function() {
                					doActionIBSheet(sheetObjects[13], document.form, IBDOWNEXCEL);
                					$(this).dialog("close");
                				}
                			},
                			{
                				text: "Cancel",
                				click: function() {
                					$(this).dialog("close");
                				}
                			}
                		]
                	}
                );
            	
                break;
            case "btn_loadexcel":
            	
            	if (formObject.prop_no.value == "" || formObject.amdt_seq.value == "" || formObject.svc_scp_cd.value == "") {
            		return;
            	}
            	
            	$(this.body).append("<div class='layer_popup_bg'></div>");
                var tabOffsetTop = $(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").offset().top;
    			var tabHeight = $(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").outerHeight() + parseInt($(parent.document.getElementById(name)).parent().prevAll(".opus_design_tab:eq(0)").css("margin-bottom"));
    			var tabOffsetBtm = tabOffsetTop + tabHeight + $(parent.document.getElementById(name)).outerHeight();
    			
    			$(parent.document.body)
    			.prepend("<div class='layer_popup_bgTop' style='height:"+(tabOffsetTop + tabHeight)+"px'><img src='/opuscntr/style/images/theme_default/pop_bg_logo.png' alt='' /></div>")
    			.append("<div class='layer_popup_bgBtm' style='top:"+ (tabOffsetBtm-1) +"px'></div>");
    			
    			
    			formObject.f_cmd.value = "";
            	$("#confirmDialog").dialog(
                		{
                		title : "Load Excel",
                		resizable: false,
                		beforeClose: function( event, ui ) {
                			$(this).parent().parent().find(".layer_popup_bg").remove();
        					$(parent.document.body).find(".layer_popup_bgTop,.layer_popup_bgBtm").remove();
                		},
                		buttons: [
                			{
                				text: "Vertical",
                				click: function() {
                					$(this).dialog("close");
                					ComOpenPopup("ESM_PRI_0029.do?" + FormQueryString(formObject), 950, 563, "", "1,0", false);
                				}
                			},
                			{
                				text: "Horizontal",
                				click: function() {
                					$(this).dialog("close");
                					ComOpenPopup("ESM_PRI_0099.do?" + FormQueryString(formObject), 950, 563, "", "1,0", false);
                				}
                			},
                			{
                				text: "Cancel",
                				click: function() {
                					$(this).dialog("close");
                				}
                			}
                		]
                	}
                );
            	
                break;
            case "btn_rowadd1":
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                break;
            case "btn_rowadd2":
                doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                break;
            case "btn_rowadd3":
                doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
                break;
            case "btn_rowcopy1":
                doActionIBSheet(sheetObjects[0], document.form, IBCOPYROW);
                break;
            case "btn_rowcopy2":
                doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
                break;
            case "btn_delete1":
                doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
                break;
            case "btn_delete2":
                doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
                break;
            case "btn_delete3":
                doActionIBSheet(sheetObjects[2], document.form, IBDELETE);
                break;
            case "btn_save1":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
            case "btn_save2":
                doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                break;
            case "btn_save3":
                doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                break;
            case "btn_amend3":
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC11);
                break;
            case "btn_amendcancel3":
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC12);
                break;
            case "btn_accept3":
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC13);
                break;
            case "btn_acceptcancel3":
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC14);
                break;
            case "gen_spcl_rt_tp_cd":
                if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
                	if (getGenSpclRtTpCd() == "G") {
                		sheetObjects[0].SetColHidden("cust_lgl_eng_nm",1);
                		sheetObjects[0].SetColWidth("prc_cmdt_def_nm",655);
                	} else {
                		sheetObjects[0].SetColHidden("cust_lgl_eng_nm",0);
                		sheetObjects[0].SetColWidth("prc_cmdt_def_nm",355);
                	}
                	checkChangeSheetForRadioCheck();
                    
                }
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
    
    /**
	 * ESM_PRI_0091.js에서 호출<br>
	 * after modify the COMMODITY NOTE, call save and search 
	 * 
	 * @param N/A
	 * @author 
	 * @version 2015.06.22
	 */
    function doSaveCommdityNote() {
    	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
    	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    /**
	 * ESM_PRI_0097.js에서 호출<br>
	 * after modify the ROUTE NOTE, call save and search 
	 * 
	 * @param N/A
	 * @author 
	 * @version 2015.06.22
	 */
    function doSaveRouteNote() {  	
    	var cmdtRowIdx = sheetObjects[0].GetSelectRow();
    	doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
    	sheetObjects[0].SetSelectRow(cmdtRowIdx);
    }
    
    
	/**
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
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
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        resizeSheet();
        
        toggleButtons("CLEAR");
        parent.loadTabPage();
        initControl();
    }
	/**
	 * Catching events for Axon event.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initControl()
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
    function initControl() {         
    	
    } 
    
    /**
     * check Sheet Changes when radio is checked <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @return void
     * @author 
     * @version 2015.02.13
     */
	function checkChangeSheetForRadioCheck(){
		var formObj=document.form;

		// Check Modified data exists
		if(	sheetObjects[0].IsDataModified() || sheetObjects[1].IsDataModified()  || sheetObjects[2].IsDataModified()  ||
			sheetObjects[3].IsDataModified() || sheetObjects[4].IsDataModified()  || sheetObjects[5].IsDataModified()  ||
			sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified()  || sheetObjects[8].IsDataModified()  ||
			sheetObjects[9].IsDataModified() || sheetObjects[10].IsDataModified() || sheetObjects[11].IsDataModified() ||
			sheetObjects[12].IsDataModified()) {
			// Will you save modified data?
			if(ComShowCodeConfirm('PRI00006')) {
				// When Error occurred while modifying, Set Radiobutton as first.
				
				if(sheetObjects[0].IsDataModified() || sheetObjects[3].IsDataModified() || sheetObjects[4].IsDataModified() ||sheetObjects[5].IsDataModified()) {
					if(!doActionIBSheet(sheetObjects[0], document.form, IBSAVE, true)) {
						returnRadioButton();
						return;
					} else {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				} else {
					if(!doActionIBSheet(sheetObjects[2], document.form, IBSAVE, true)) {
						returnRadioButton();
						return;
					}
					
					//location
					if(	sheetObjects[1].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified()  ||
						sheetObjects[8].IsDataModified() || sheetObjects[9].IsDataModified() || sheetObjects[10].IsDataModified() ||	
						sheetObjects[11].IsDataModified()) {
						doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
					} else {
						//rate
						doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
					}
				}
				
				
			} else {
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
		} else {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
    
	/**
     * Changking org_dest_tp_cd's checked status<br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.22
     */
    function returnRadioButton() {
     	var formObj=document.form;
     	if(formObj.gen_spcl_rt_tp_cd[0].checked) {
 			formObj.gen_spcl_rt_tp_cd[1].checked=true;
 		} else if(formObj.gen_spcl_rt_tp_cd[1].checked) {
 			formObj.gen_spcl_rt_tp_cd[0].checked=true;
 		}
    }
    
	/**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
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
        case "sheet1":  // CMDT Group
            with(sheetObj){
		            
		          var HeadTitle="|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_clss_nm_tooltip|nd_cnt|na_cnt|up_ac_cnt|up_cnt|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"blet_dp_seq",             KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm_tooltip",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"up_ac_cnt",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"up_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"org_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetEllipsis(1);
		          SetShowButtonImage(2);
		          SetSheetHeight(142);
          }
            break;
        case "sheet2":  // Route Group
            with(sheetObj){
		           
		         var HeadTitle="|Sel.||Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Commodity Header Seq.|Seq.|Origin|O.Via|D.Via|Dest.|Direct Call|Direct Call|Note|Note Tooltip|nd_cnt|na_cnt|up_ac_cnt|up_cnt|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq";
		
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rn",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Seq",       Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1,   HeaderCheck:0, TrueValue:"Y", FalseValue:"N"  },
		             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm_tooltip",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"up_ac_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"up_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"org_n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          
		         InitColumns(cols);		
		         SetEditable(1);
		         SetEllipsis(1);         
		         SetShowButtonImage(2);
		         SetSheetHeight(142);
         }


            break;
        case "sheet3":  // Rate
            with(sheetObj){
		            
		          var HeadTitle="|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
		
		          SetConfig( { SearchMode:2, FrozenCol:16, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",          KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		                 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"next_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		          SetEditable(1);
		          SetEllipsis(1);
		          SetColProperty("rat_ut_cd", {ComboText:ratUtCdText+unusedRatUtCd ,ComboCode: ratUtCdValue+unusedRatUtCd} );
		          SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCddValue} );
		          SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		          InitComboNoMatchText(1, "", 1);
		          SetShowButtonImage(2);
		          FrozenCols=16;
		          resizeSheet(); //SetSheetHeight(142);
          }


            break;
        case "sheet4":  // Grid 1's Commodity(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19|4-20";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }


            break;
        case "sheet5":  // Grid 1 Actual Customer(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17|5-18";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];		           
		          InitColumns(cols);		          
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet6":  // Grid 1 Commodity Note(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19|6-20|6-21|6-22|6-23";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet7":  // Grid 2 Origin Point(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25|7-26";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet8":  // Grid 2 Origin Via.(Hidden)
            with(sheetObj){		            
		          var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21|8-22";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet9":  // Grid 2 Destination Via.(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21|9-22";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet10":  // Grid 2 Destination Point(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25|10-26";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_grd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet11":  // Grid 2 Direct Call(Hidden)
            with(sheetObj){
		            
		          var HeadTitle="11-1|11-2|11-3|11-4|11-5|11-6|11-7|11-8|11-9|11-10|11-11|11-12|11-13|11-14|11-15|11-16";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet12":  // Grid 2 Rnote(Hidden)
            with(sheetObj){		            
		          var HeadTitle="12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19|12-20|12-21|12-22|12-23|12-24";
		
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
        case "sheet13": // Excel Download Sheet(Vertical)
            with(sheetObj){
		            
		          var HeadTitle1="CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|CMDT Note\nCopy|Route Note\nCopy";
		          var HeadTitle2="CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code| Code|Code|Description|Term|Transmode|Y/N|PER|Cargo Type|Rate|CMDT Note\nCopy|Route Note\nCopy";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rout_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		           
		          InitColumns(cols);
		
		          SetEditable(1);
		          SetSheetHeight(300);
                }
            break;
        case "sheet14": // Excel Download Sheet(Horizontal)
            with(sheetObj){
		            
		          var HeadTitle1="Type|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Commodity Note\nCopy|Route Note\nCopy";
		          var HeadTitle2="Type|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code| Code|Code|Description|Term|Transmode|Y/N|Prefix|CGO TYPE|20|40|40HC|45|Commodity Note\nCopy|Route Note\nCopy";
		
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );		
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ 
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"type",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prefix_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_20",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40hc",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_45",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_copy",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_copy",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },];
		           
		          InitColumns(cols);		
		          SetEditable(1);
		          SetSheetHeight(300);
                }
            break;
        }
    }
    
    function resizeSheet() {
  	   	ComResizeSheet(sheetObjects[2]);
  	}
    
	/**
	 * Calling Function in case of OnBeforeEdit event <br>
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
        if (!checkCmdtEditable()) {
            ComShowCodeMessage("PRI00309", "Route Detail");
            return false;
        }
    }
	/**
	 * Calling Function in case of OnAfterEdit  event <br>
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnAfterEdit(sheetObj, Row, Col) {
        if (!checkCmdtEditable()) {
        	sheetObj.ReturnCellData(Row, Col);
            return false;
        }
    }
	/**
	 * Calling Function in case of OnBeforeEdit event <br>
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnBeforeEdit(sheetObj, Row, Col) {
        if (!checkRouteEditable()) {
            ComShowCodeMessage("PRI00309", "Commodity Group");
            return false;
        }
    }
	/**
	 * Calling Function in case of OnAfterEdit  event <br>
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnAfterEdit(sheetObj, Row, Col) {
        if (!checkRouteEditable()) {
        	sheetObj.ReturnCellData(Row, Col);
            return false;
        }
    }
	/**
	 * Calling Function in case of OnBeforeEdit event <br>
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnBeforeEdit(sheetObj, Row, Col) {
        if (!checkRouteEditable()) {
            ComShowCodeMessage("PRI00309", "Commodity Group");
            return false;
        }
    }
	/**
	 * Calling Function in case of OnAfterEdit  event <br>
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnAfterEdit(sheetObj, Row, Col) {
        if (!checkRouteEditable()) {
        	sheetObj.ReturnCellData(Row, Col);
            return false;
        }
    }
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
	 * In case of checking, checking all sub-grid. in case of unchecking, unchecking main grid's check
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
        }
    }
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
	 * In case of checking, checking all sub-grid. in case of unchecking, unchecking main grid's check
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
        }
    }
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
	 *  In case of checking, checking all sub-grid. in case of unchecking, unchecking main grid's check
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 2, Row, Col);
        }
    }
	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "dir_call_flg") {
            if (document.form.amdt_seq.value == "0") {
            	createNewDirectCall();
            	sheetObjects[10].SetCellValue(sheetObjects[10].GetSelectRow(), "dir_call_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dir_call_flg") == "1" ? "Y" : "N");
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
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
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
        // Setting cargo type
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
    }
	/**
	 * Calling Function in case of OnSelectCell event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
        doRowChange1(OldRow, NewRow, OldCol, NewCol);
    }
	/**
	 * Calling Function in case of OnSelectCell event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Ro22w Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
        doRowChange2(OldRow, NewRow, OldCol, NewCol);
    }
	/**
	 * Calling Function in case of OnSelectCell event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Sheet1.
	 *Asking to copy G/L in case of general rate
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
        if (ErrMsg == "") {
        	toggleButtons("INIT");
            if ((bIsReqUsr || bIsAproUsr)
            	&& getGenSpclRtTpCd() == "G"
            	&& sheetObjects[0].RowCount()<= 0
            	&& validateForm(sheetObj, document.form, IBSEARCH_ASYNC03)) {
            	if (askOnce && ComShowCodeConfirm("PRI01006")) {
            		askOnce=false;
            		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
            	}
            }
            askOnce=false;            
            origin_desc.innerHTML="";
            ovia_desc.innerHTML="";
            dvia_desc.innerHTML="";
            dest_desc.innerHTML="";
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * showing detail location information on Route Group grid
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	origin_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            			&& sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermOrg[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
            	if ((sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != "")
            			|| (sheetObj.GetCellValue(i, "loc_grd_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cd") != "")) {
            		sStr += "(" + sheetObj.GetCellValue(i, "loc_grd_cnt_cd") + sheetObj.GetCellValue(i, "loc_grd_cd") + ")";
                }
            	if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
                		sStr="<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr="<font color='red'>" + sStr + "</font>";
                	}
            	}
                sStr += "<br>";
                origin_desc.innerHTML += sStr;
            }
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 *  showing detail location information on Route Group grid
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	ovia_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            			&& sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
            	if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
                		sStr="<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr="<font color='red'>" + sStr + "</font>";
                	}
            	}
                sStr += "<br>";
                ovia_desc.innerHTML += sStr;
            }
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 *  showing detail location information on Route Group grid
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dvia_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            			&& sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
            	if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
                		sStr="<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr="<font color='red'>" + sStr + "</font>";
                	}
            	}
                sStr += "<br>";
                dvia_desc.innerHTML += sStr;
            }
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 *  showing detail location information on Route Group grid
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	dest_desc.innerHTML="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            			&& sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermDest[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
            	if ((sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != "")
            			|| (sheetObj.GetCellValue(i, "loc_grd_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cd") != "")) {
            		sStr += "(" + sheetObj.GetCellValue(i, "loc_grd_cnt_cd") + sheetObj.GetCellValue(i, "loc_grd_cd") + ")";
                }
            	if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value
            				|| sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
                		sStr="<s>" + sStr + "</s>";
            		} 
            		if (sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
            			sStr += "(Deleted)";
            		}
            		if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
                		sStr="<font color='red'>" + sStr + "</font>";
                	}
            	}
                sStr += "<br>";
                dest_desc.innerHTML += sStr;
            }
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Downloading file with excel format
	 * Using speed option in case of exceeding 300 rows
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet13_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	/*
        	if (sheetObj.RowCount()> 300) {
        		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        	} else {
        	*/
        		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        	//}
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Downloading file with excel format
	 * Using speed option in case of exceeding 200 rows
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet14_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	/*
        	if (sheetObj.RowCount()> 200) {
        		sheetObj.Down2Excel();
        	} else {
        	*/
        		sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        	//}
        }
    }
	/**
	 * Calling Function in case of OnPopupClick event <br>
	 * re-update modified data on popup screen to sheet1
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    var popupRow = 0;
    var popupColName="";
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        popupRow=Row;
        popupColName=colName;
        // Return if any modification on Route
        if (!checkCmdtEditable()) {
            ComShowCodeMessage("PRI00309", "Route Detail");
            return false;
        }
        if (colName == "prc_cmdt_def_nm") {
            var sUrl="ESM_PRI_0026.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 300, "sheet1_returnVal", "1,0", true);
        }
        if (colName == "cust_lgl_eng_nm") {
        	var sUrl="ESM_PRI_0070.do?" + FormQueryString(document.form);
			 ComOpenPopup(sUrl, 800, 300, "sheet1_returnVal", "1,0", true);
        }
        if (colName == "note_clss_nm") {
        	var sUrl="ESM_PRI_0091.do?" + FormQueryString(document.form);
			 ComOpenPopup(sUrl, 894, 350, "sheet1_returnVal", "1,0", true);
        }
    }
    
    function sheet1_returnVal(rtnVal) {
    	if (rtnVal == "O") {
    		if (popupColName == "prc_cmdt_def_nm") {
    			setSheet1RowData(sheet1, 3, popupRow, "prc_cmdt_def_nm");
    		}
    		if (popupColName == "cust_lgl_eng_nm") {
    			setSheet1RowData(sheet1, 4, popupRow, "cust_lgl_eng_nm");
    		}
    		if (popupColName == "note_clss_nm") {
            	var prevStatus=sheet1.GetRowStatus(popupRow);
                var sNm="";
                for (var i=sheetObjects[5].HeaderRows(); i <= sheetObjects[5].LastRow(); i++) {
                	if (sheetObjects[5].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
                		continue;
                	}
                	if (sheetObjects[5].GetCellValue(i, "prop_no") == document.form.prop_no.value
                			&& sheetObjects[5].GetCellValue(i, "amdt_seq") == document.form.amdt_seq.value
                			&& sheetObjects[5].GetCellValue(i, "svc_scp_cd") == document.form.svc_scp_cd.value
                			&& sheetObjects[5].GetCellValue(i, "gen_spcl_rt_tp_cd") == getGenSpclRtTpCd()
                			&& sheetObjects[5].GetCellValue(i, "cmdt_hdr_seq") == document.form.cmdt_hdr_seq.value) {
                		if (sheetObjects[5].GetRowStatus(i) == "D") {
        	                continue;
        	            }
        	            /*
if (sheetObjects[5].GetCellValue(i, "src_info_cd") == "AD") {
        	                continue;
        	            }
        	            */
                		var clssNm=arrNoteClass[sheetObjects[5].GetCellValue(i, "note_clss_cd")];
        	            if (sNm.indexOf(clssNm) < 0) {
            	            sNm += clssNm;
            	            sNm += ", ";
        	            }
                    }
                }
                if (sNm != "") {
                	var lastIdx=sNm.lastIndexOf(",");
                	sNm=sNm.substring(0, lastIdx);
                }
                sheetObjects[0].SetCellValue(popupRow, "note_clss_nm", sNm, 0);
                // Appying modified note's contents to Tooltip
                makeNoteTooltip(sheetObjects[0], 5, popupRow);
                sheetObjects[0].SetRowStatus(popupRow,prevStatus);
                
    		}
    	}
    }
	/**
	 * Calling Function in case of OnPopupClick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    var popupRow2 = 0;
    var popupCol=-1;
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        /*if (!LoadingComplete) {
            return;
        }*/
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        popupRow2=Row;
        popupCol=Col;
        if (!checkRouteEditable()) {
            ComShowCodeMessage("PRI00309", "Commodity Group");
            return false;
        }
        var sUrl="/opuscntr/ESM_PRI_0027.do?" + FormQueryString(document.form);
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 380, "sheet2_returnVal", "1,0", true);            
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 380, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 380, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 380, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "dir_call_flg_pop") {
        	createNewDirectCall();
            sUrl="/opuscntr/ESM_PRI_0094.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 400, 270, "dir_call_flg_pop_returnVal", "1,0", true);
        }
        if (colName == "note_clss_nm") {
            sUrl="/opuscntr/ESM_PRI_0097.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 300, "note_clss_nm_returnVal", "1,0", true);
        }
    }
    
    function sheet2_returnVal(rtnVal) {
    	if (rtnVal == "O") {
            setSheet2RowData(sheet2, popupRow2, popupCol);
        }
    }
    
    /**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Sheet2.
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2015.03.03
	 */
    function sheet2_OnSearchEnd(sheetObj, code, ErrMsg) {
    	var formObj = document.form;
        if (ErrMsg == "") {
        	var amdtSeq = formObj.amdt_seq.value;
        	if(amdtSeq != undefined && amdtSeq != "" && amdtSeq != "0") {
        		var info = {Edit:false};
        		sheetObj.SetColProperty(0,"dir_call_flg",info);
        		
        	} else {
        		var info = {Edit:true};
        		sheetObj.SetColProperty(0,"dir_call_flg",info);
        	}
        }
    }
    
    function dir_call_flg_pop_returnVal(rtnVal) {
    	if (rtnVal == "O") {
        	var prevStatus=sheet2.GetRowStatus(popupRow2);
            for (var i=sheetObjects[10].HeaderRows(); i <= sheetObjects[10].LastRow(); i++) {
            	if (sheetObjects[10].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
            		continue;
            	}
            	sheet2.SetCellValue(popupRow2, "dir_call_flg",sheetObjects[10].GetCellValue(i, "dir_call_flg") == "Y" ? "1" : "0",0);
            }
            sheet2.SetRowStatus(popupRow2,prevStatus);
        } else if (rtnVal == "X") {
        	//2015.03.11
        	//when dir_call_flg_pop is opened, sheet10 is 1 row inserted.
        	//if the window of dir_call_flg_pop is closed with the close button, the row status that is inserted must be changed with the R Status 
        	var idx = sheetObjects[10].GetSelectRow();
        	sheetObjects[10].SetRowStatus(idx,"R");
        }
    }
    
    function note_clss_nm_returnVal(rtnVal) {
    	   if (rtnVal == "O") {
           	var prevStatus=sheet2.GetRowStatus(popupRow2);
               var sNm="";
               for (var i=sheetObjects[11].HeaderRows(); i <= sheetObjects[11].LastRow(); i++) {
               	if (sheetObjects[11].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
               		continue;
               	}
               	if (sheetObjects[11].GetRowStatus(i) == "D") {
                       continue;
                   }
               	var clssNm=arrNoteClass[sheetObjects[11].GetCellValue(i, "note_clss_cd")];
   	            if (sNm.indexOf(clssNm) < 0) {
       	            sNm += clssNm;
       	            sNm += ", ";
   	            }
               }
               if (sNm != "") {
               	var lastIdx=sNm.lastIndexOf(",");
               	sNm=sNm.substring(0, lastIdx);
               }
               sheetObjects[1].SetCellValue(popupRow2, "note_clss_nm",sNm,0);
               makeNoteTooltip(sheet2, 11, popupRow2);
               sheetObjects[1].SetRowStatus(popupRow2,prevStatus);
           }
    }
	/**
	 * Applying modified data on popup screen to sheet1<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetIdx Mandatory Sheet no
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheet1RowData(sheetObj, sheetIdx, Row, Col) {
    	var formObj=document.form;
    	var prevStatus=sheetObj.GetRowStatus(Row);
        var sNm="";
        for (var i=sheetObjects[sheetIdx].HeaderRows(); i <= sheetObjects[sheetIdx].LastRow(); i++) {
        	if (sheetObjects[sheetIdx].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
        	if (sheetObjects[sheetIdx].GetCellValue(i, "prop_no") == formObj.prop_no.value
        			&& sheetObjects[sheetIdx].GetCellValue(i, "amdt_seq") == formObj.amdt_seq.value
        			&& sheetObjects[sheetIdx].GetCellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value
        			&& sheetObjects[sheetIdx].GetCellValue(i, "gen_spcl_rt_tp_cd") == getGenSpclRtTpCd()
        			&& sheetObjects[sheetIdx].GetCellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
        		if (sheetObjects[sheetIdx].GetRowStatus(i) == "D") {
	                continue;
	            }
	            /*
if (sheetObjects[sheetIdx].GetCellValue(i, "src_info_cd") == "AD") {
	                continue;
	            }
	            */
        		sNm += sheetObjects[sheetIdx].GetCellValue(i, Col);
	            sNm += " / ";
            }
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf("/");
        	sNm=sNm.substring(0, lastIdx - 1);
        }
        sheetObj.SetCellValue(Row, Col,sNm,0);
        sheetObj.SetRowStatus(Row,prevStatus);
    }
	/**
	 * Applying modified data on popup screen to sheet2<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj=document.form;
        var prevStatus=sheetObj.GetRowStatus(Row);
        var sCd="";
        for (var i=sheetObjects[6].HeaderRows(); i <= sheetObjects[6].LastRow(); i++) {
        	if (sheetObjects[6].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
        	if (sheetObjects[6].GetRowStatus(i) == "D") {
                continue;
            }
            /*
if (sheetObjects[6].GetCellValue(i, "src_info_cd") == "AD") {
                continue;
            }
            */
        	sCd += sheetObjects[6].GetCellValue(i, "rout_pnt_loc_def_cd");
            sCd += ", ";
        }
        if (sCd != "") {
        	var lastIdx=sCd.lastIndexOf(",");
        	sCd=sCd.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd",sCd,0);
        sCd="";
        for (var i=sheetObjects[7].HeaderRows(); i <= sheetObjects[7].LastRow(); i++) {
        	if (sheetObjects[7].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
        	if (sheetObjects[7].GetRowStatus(i) == "D") {
                continue;
            }
            /* 
if (sheetObjects[7].GetCellValue(i, "src_info_cd") == "AD") {
                continue;
            }
            */
        	sCd += sheetObjects[7].GetCellValue(i, "rout_via_port_def_cd");
            sCd += ", ";
        }
        if (sCd != "") {
        	var lastIdx=sCd.lastIndexOf(",");
        	sCd=sCd.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "org_rout_via_port_def_cd",sCd,0);
        sCd="";
        for (var i=sheetObjects[8].HeaderRows(); i <= sheetObjects[8].LastRow(); i++) {
        	if (sheetObjects[8].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
        	if (sheetObjects[8].GetRowStatus(i) == "D") {
                continue;
            }
            /* 
	if (sheetObjects[8].GetCellValue(i, "src_info_cd") == "AD") {
                continue;
            }
            */
        	sCd += sheetObjects[8].GetCellValue(i, "rout_via_port_def_cd");
            sCd += ", ";
        }
        if (sCd != "") {
        	var lastIdx=sCd.lastIndexOf(",");
        	sCd=sCd.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "dest_rout_via_port_def_cd",sCd,0);
        sCd="";
        for (var i=sheetObjects[9].HeaderRows(); i <= sheetObjects[9].LastRow(); i++) {
        	if (sheetObjects[9].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
        	if (sheetObjects[9].GetRowStatus(i) == "D") {
                continue;
            }
            /* 
if (sheetObjects[9].GetCellValue(i, "src_info_cd") == "AD") {
                continue;
            }
            */
        	sCd += sheetObjects[9].GetCellValue(i, "rout_pnt_loc_def_cd");
            sCd += ", ";
        }
        if (sCd != "") {
        	var lastIdx=sCd.lastIndexOf(",");
        	sCd=sCd.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd",sCd,0);
        sheetObj.SetRowStatus(Row,prevStatus);
    }
	/**
	 * Making tooltip by using note<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetIdx Mandatory Sheet no
	 * @param {int} Row Mandatory Cell's Row Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function makeNoteTooltip(sheetObj, sheetIdx, Row) {
    	var formObj=document.form;
        var sTooltip="";
        for (var i=sheetObjects[sheetIdx].HeaderRows(); i <= sheetObjects[sheetIdx].LastRow(); i++) {
        	if (sheetObjects[sheetIdx].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
        		continue;
        	}
            if ((sheetObj.id != "sheet1")
            		|| (sheetObjects[sheetIdx].GetCellValue(i, "prop_no") == formObj.prop_no.value
            				&& sheetObjects[sheetIdx].GetCellValue(i, "amdt_seq") == formObj.amdt_seq.value
            				&& sheetObjects[sheetIdx].GetCellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value
            				&& sheetObjects[sheetIdx].GetCellValue(i, "gen_spcl_rt_tp_cd") == getGenSpclRtTpCd()
            				&& sheetObjects[sheetIdx].GetCellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value)) {
            	if (sheetObjects[sheetIdx].GetRowStatus(i) == "D") {
	                continue;
	            }
	            /* 
if (sheetObjects[sheetIdx].GetCellValue(i, "src_info_cd") == "AD") {
	                continue;
	            }
	            */
            	sTooltip += "<" + arrNoteClass[sheetObjects[sheetIdx].GetCellValue(i, "note_clss_cd")] + ">\n";
            	sTooltip += "" + sheetObjects[sheetIdx].GetCellValue(i, "note_ctnt") + "\n\n";
            }
        }
        sheetObj.SetCellValue(Row, "note_clss_nm_tooltip",sTooltip,0);
        setNoteTooltip(sheetObj, Row);
    }
	// setting event to be off
    var isFiredNested=false;
    // setting event to be off
    var isFiredNestedExt=false;
    var supressConfirm=false;
	/**
	 * Handling event in case of modifying row on Sheet<br>
	 * Rollbacking selected row to old row in case of Row move event<br>
	 * After validation, moveing selected row to new row manually<br>
	 * 
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        // Not processing selected row with duplicated event or row
        if (!isFiredNested && (OldRow != NewRow)) {
        	// Validating in any case of modification on CMDT Group green
            if (sheetObjects[0].IsDataModified()
            		|| sheetObjects[3].IsDataModified()
            		|| sheetObjects[4].IsDataModified()
            		|| sheetObjects[5].IsDataModified()) {
            	// Set off event.Rollbacking selected row to old row
            	isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	// If no error on saving, moving to new row except row add, row copy action
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                	isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                	// Not moving from old row in case of Validation Error
                	isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            // in any modified case of Route Group OldRow
            if (sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()
                    || sheetObjects[9].IsDataModified()
                    || sheetObjects[10].IsDataModified()
                    || sheetObjects[11].IsDataModified()) {
            	// Set off event, rollbacking selected row to old row
                isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    var rslt=doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                	// Moving new row in case of succesful saving
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                	// in case of un-succesful saving, moving to old row again
                    isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                	return -1;
                }
            }
            // RowAdd 
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[0].DataInsert();
                isFiredNested=false;
                return idx;
            // RowCopy
            } else if (sAction == IBCOPYROW) {
                isFiredNested=true;
                var idx=sheetObjects[0].DataCopy();
                isFiredNested=false;
                return idx;
            } else {
            	formObj.cmdt_hdr_seq.value=sheetObjects[0].GetCellValue(NewRow, "cmdt_hdr_seq");
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
            }
        }
    }
	/**
	 * in case of modifying row on Sheet <br>
	 * refer to doRowChange1
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && !isFiredNestedExt && (OldRow != NewRow)) {
        	if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
            	&& (sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()
                    || sheetObjects[9].IsDataModified()
                    || sheetObjects[10].IsDataModified()
                    || sheetObjects[11].IsDataModified())) {
                isFiredNested=true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows());
                    rslt=doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested=true;
	                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                    isFiredNested=true;
                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                	return -1;
                }
            }
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataInsert();
                isFiredNested=false;
                return idx;
            } else if (sAction == IBCOPYROW) {
                isFiredNested=true;
                var idx=sheetObjects[1].DataCopy();
                isFiredNested=false;
                return idx;
            } else {
                LoadingComplete=false;
                formObj.rout_seq.value=sheetObjects[1].GetCellValue(adjNewRow, "rout_seq");
                doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
                LoadingComplete=true;
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
    function doActionIBSheet(sheetObj, formObj, sAction, isRadio) {
		try {
//			if (window.event == null || ComGetEvent() == null || ComGetEvent("suppressWait") != "Y") {
//				ComOpenWait(true);
//			}
	        switch (sAction) {
	        case IBSEARCH_ASYNC02: // Cancel All
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI01010")) {
	            	return false;
	            }
	            formObj.f_cmd.value=MODIFY11;
	            var sParam=FormQueryString(formObj);
	            // Saving selected row for retrieving 
	            saveCurRowPos();
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
	        	reloadPagePostTr();
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSEARCH_ASYNC03: // Guideline Copy
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=SEARCH12;
	            var sParam=FormQueryString(formObj);
	            sParam += "&prc_cust_tp_cd=" + parent.comboObjects[2].GetSelectCode();
	            // checking whether Group Location, Group Commodity in guideline is already copied to proposal
	            var cXml=sheetObj.GetSearchData("ESM_PRI_0003_08GS.do", sParam);
	            var arrCnt=ComPriXml2Array(cXml, "etc1|etc2");
	            if (arrCnt != null && arrCnt.length > 0) {
	            	var locCnt=arrCnt[0][0];
	            	var cmdtCnt=arrCnt[0][1];
	            	if (locCnt > 0) {
	            		ComShowCodeMessage("PRI01027");
	            		return false;
	            	}
	            	if (cmdtCnt > 0) {
	            		ComShowCodeMessage("PRI01028");
	            		return false;
	            	}
	            } else {
	            	ComShowMessage(OBJECT_ERROR);
	            	return false;
	            }
	           // Saving selected row for retrieving 
	            saveCurRowPos();
	            formObj.f_cmd.value=MODIFY12;
	            var sParam=FormQueryString(formObj);
	            sParam += "&prc_cust_tp_cd=" + parent.comboObjects[2].GetSelectCode();
	            // Guideline Copy
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
	            reloadPagePostTr();
	    		if (sheetObjects[0].RowCount()<= 0) {
	    			ComShowCodeMessage("PRI01016");
	    		} else {
	    			ComShowCodeMessage("PRI01017");
	    		}
	            break;
	        case IBSEARCH_ASYNC11: // Amend
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	        	var idx=doRowAmend(sheetObj, "AM");
				    setSheet3Style(sheetObj, idx - 1);
				    setSheet3Style(sheetObj, idx);
		        	sheetObj.SetCellValue(idx, "prop_frt_rt_amt",0.00);
		        	sheetObj.SetCellValue(idx, "coffr_frt_rt_amt","");
		        	sheetObj.SetCellValue(idx, "fnl_frt_rt_amt","");
		        	sheetObj.SetCellValue(idx, "gri_appl_tp_cd","");
		        	sheetObj.SetCellValue(idx, "gri_appl_amt","");
		        	sheetObj.SetCellValue(idx, "acpt_usr_id","");
	            break;
	        case IBSEARCH_ASYNC12: // Amend Cancel
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	        	var prevIdx=doRowAmendCancel(sheetObj);
	        	setSheet3Style(sheetObj, prevIdx);
	            break;
	        case IBSEARCH_ASYNC13: // Accept
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00008")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		// Setting C/Offer amount to Final amount in case of Returned
	        		if (formObj.prc_prop_sts_cd.value == "R") {
	        			sheetObj.SetCellValue(arrCheckedRows[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(arrCheckedRows[i], "coffr_frt_rt_amt"));
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","A");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Accepted");
	            	//  Setting Proposal amount to Final amount in case of Requested
	        		} else if (formObj.prc_prop_sts_cd.value == "Q") {
	        			sheetObj.SetCellValue(arrCheckedRows[i], "fnl_frt_rt_amt",sheetObj.GetCellValue(arrCheckedRows[i], "prop_frt_rt_amt"));
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","A");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Accepted");
	        		}
	        	}
	            formObj.f_cmd.value=MODIFY01;
	            var sParam=FormQueryString(formObj);
	            //Creating query string for only checked item
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + sSheetParam;
	            saveCurRowPos();
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            // handing style after saving
	            restylingPagePostTr();
	            setSheet3Style(sheetObj, -1);
	            sheetObj.CheckAll("chk",0,1);
	            ComShowCodeMessage("PRI00108");
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00009")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		// in case of existing C/Offer amount, rollbacking to Returned
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != null
	        				&& sheetObj.GetCellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != "") {
	            		sheetObj.SetCellValue(arrCheckedRows[i], "fnl_frt_rt_amt","");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","R");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Returned");
	            	// if not, rollbacking to Initial 
	        		} else {
	            		sheetObj.SetCellValue(arrCheckedRows[i], "fnl_frt_rt_amt","");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","I");
	            		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Initial");
	        		}
	        	}
	            formObj.f_cmd.value=MODIFY02;
	            var sParam=FormQueryString(formObj);
	            //Creating query string for only checked item
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + sSheetParam;
	            saveCurRowPos();
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            // handing style after saving
	            restylingPagePostTr();
	            setSheet3Style(sheetObj, -1);
	            sheetObj.CheckAll("chk",0,1);
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSEARCH_ASYNC20: 
	            var sXml="";  
	            isOViaMandatory=false;
	            isDViaMandatory=false;
	            isDirCallVisible=true; 
// CHLOE : 아래의 부분은 나중에 사용할 지도 모르는 주석입니다. (2015-03-10)	            
//				formObj.f_cmd.value=COMMAND17;
//				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
//				arrTemp=ComPriXml2Array(sXml, "cd|nm");
//				if (arrTemp != null && arrTemp.length > 0) {
//					for (var i=0; i < arrTemp.length; i++) {
//						var pptCd=arrTemp[i][1];
//						if (pptCd == "SOVA") {
//							isOViaMandatory=true;
//						} else if (pptCd == "SDVA") {
//							isDViaMandatory=true;
//						} else if (pptCd == "SDRC") {
//							isDirCallVisible=true;
//						}
//					}
//				}
	            break;
	        case IBSEARCH: 
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI01007');
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH01;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0003_08GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[4].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[5].LoadSearchData(arrXml[3],{Sync:1} );
	            } else if (sheetObj.id == "sheet2") {
	            	if(cmdtDeltChkFlg){
	            		var ndCnt = 0;
		            	formObj.f_cmd.value=SEARCH02;
	                	var sXml=sheetObj.GetSearchData("ESM_PRI_0003_08GS.do" , FormQueryString(formObj));
		                var arrXml=sXml.split("|$$|");
		                if (arrXml.length > 0){
	                		var arrData = ComPriXml2Array(arrXml[0], "nd_cnt");
		                    if (arrData !=null && arrData.length > 0){
		                    	for(var i=0; i<arrData.length; i++){
		                    		ndCnt += parseInt(arrData[i]);
		                    	}
		                    	cmdtDeltChkFlg = false;
		                    	return ndCnt;
		                    }
	                	}
	            	}else{
		                for (var i=1; i < sheetObjects.length; i++) {
		                    if (i == 3 || i == 4 || i == 5) {
		                        continue;
		                    }
		                    sheetObjects[i].RemoveAll();
		                }
		                origin_desc.innerHTML="";
		                ovia_desc.innerHTML="";
		                dvia_desc.innerHTML="";
		                dest_desc.innerHTML="";
		                formObj.f_cmd.value=SEARCH02;
	 	                sheetObj.DoSearch("ESM_PRI_0003_08GS.do", FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, "blet_dp_seq") );
		            }
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                	if (i == 3 || i == 4 || i == 5) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;
 	                var sXml=sheetObj.GetSearchData("ESM_PRI_0003_08GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[6].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[7].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[8].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[9].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[10].LoadSearchData(arrXml[5],{Sync:1} );
	                if (arrXml.length > 6) sheetObjects[11].LoadSearchData(arrXml[6],{Sync:1} );
	                setSheet3Style(sheetObj, -1);
	            }
	            break;
	        case IBSAVE: 
	        	// Deleting DMDT_HER with all deleted CMDT
	        	if (sheetObj.id == "sheet1") {
	        		var arrTgt=new Array();
	        		for (var i=sheetObjects[0].LastRow(); sheetObjects[0].RowCount()> 0 && i >= sheetObjects[0].HeaderRows(); i--) {
	        			if (isCMDTGroupDeleted(i)) { 
	        				continue;
	        			}
	        			var iCnt=getAmendValidRowCountCond(sheetObjects[3], "cmdt_hdr_seq", sheetObjects[0].GetCellValue(i, "cmdt_hdr_seq"), formObj.amdt_seq.value);
	        			if (iCnt <= 0) {
	        				arrTgt.push(i);
	        			}
	        		}
	        		if (arrTgt.length > 0) {
	        			for (var i=0; i < arrTgt.length; i++) {
	        				sheetObjects[0].SetSelectRow(arrTgt[i]);
	        				doActionIBSheet(sheetObjects[0], document.form, IBDELETE);
        				}
	        		}
	        	//Deleting route with all deleted Route Point
	        	} else if (sheetObj.id == "sheet3") {
	    			if (!isRouteGroupDeleted()) {
	    				var iCntOri = getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value);
	    				var iCntOVia = getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value);
	    				var iCntDVia = getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value);
	    				var iCntDest = getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value);
	    				if (iCntOri <= 0 && iCntOVia <= 0 && iCntDVia <= 0 && iCntDest <= 0) {
	    					if (ComShowCodeConfirm("PRI00350")) {
	    						return false;
	    					}
	    					doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
	    				} else {
	    					if (sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") == "-1") {
	    						sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "org_n1st_cmnc_amdt_seq"));
	    					}
	    				}
	    			}
	        	}
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	            	// Validating Bullet No
//	            	if (!validateBulletNo(sheetObj,document.form,sAction)) {
//	            		return false;
//	            	}
	            	// changing to GM,PM in case that Source with GC,PC is modified
	            	for (var a=3; a <= 5; a++) {
	            		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
	                		// if src_info_cd= GC(Guideline Copy), GM(Guideline Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U"
	            				&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	            				&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Guideline (M)");
	                		}
	                		// if src_info_cd= PC(Previous Contract),, PM(Previous Contract Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U"
	            				&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	            				&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Prev. S/C (M)");
	                		}
	            		}
	            	}
	                formObj.f_cmd.value=MULTI01;
	                var sParam=FormQueryString(formObj);
	                var sParamSheet1=sheetObjects[0].GetSaveString();
	                if (sParamSheet1 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
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
	                
	                if(isRadio == undefined || isRadio == null) {
		                if (!supressConfirm && !ComPriConfirmSave()) {
		                    return false;
		                }
	                }
	                isFiredNested=true;
 	                var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
 	                sheetObjects[5].LoadSaveData(sXml);
 	                sheetObjects[4].LoadSaveData(sXml);
 	                sheetObjects[3].LoadSaveData(sXml);
 	                sheetObjects[0].LoadSaveData(sXml);
 	                
 	                //ibsheet.js 1.9버젼 까지만 됨
//	                isFiredNested=false;
//	                if (sheetObjects[0].IsDataModified()
//	                		|| sheetObjects[3].IsDataModified()
//	                		|| sheetObjects[4].IsDataModified()
//	                		|| sheetObjects[5].IsDataModified()) {
//	                    return false;
//	                } else {
//	                	if (reloadSw) {
//	                		saveCurRowPos();
//	                		reloadPagePostTr();
//	                		reloadSw=false;
//	                	} else {
//	                		restylingPagePostTr(true);
//	                	}
//	                    ComPriSaveCompleted();
//	                    return true;
//	                }
	                
 	                //2015.03.02 수정
                    isFiredNested=false; 
	                var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
	                if (result == undefined || result == "" || result != "S") {
	                    return false;
	                } else {
	                	if (reloadSw) {
	                		saveCurRowPos();
	                		reloadPagePostTr();
	                		reloadSw=false;
	                	} else {
	                		restylingPagePostTr(true);
	                	}
	                    ComPriSaveCompleted();
	                    doActionIBSheet( sheetObj , document.form, IBSEARCH ); 
	                    return true;
	                }
	                
	                
	                
	                
	            } else if (sheetObj.id == "sheet3") {
	            	for (var a=2; a <= 11; a++) {
	                    if (a == 3 || a == 4 || a == 5) {
	                        continue;
	                    }
	                    //in case of modifying  Source as GC,PC, modifying to GM, PM
	            		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
	                		// if Proposal &src_info_cd= GC(Guideline Copy),  GM(Guideline Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U"
	            				&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	            				&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Guideline (M)");
	                		}
	                		// if Proposal &  src_info_cd = PC(Previous Contract),  PM(Previous Contract Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U"
	            				&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	            				&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Prev. S/C (M)");
	                		}
	            		}
	            	}
	            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            		// if C/Offer amount is inputed, Changing prc_prog_sts_cd to Returned
	            		if (sheetObj.GetRowStatus(i) == "U"
	            				&& bIsAproUsr
	            				&& formObj.prc_prop_sts_cd.value == "Q"
	            					&& sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "I"
	            						&& sheetObj.GetCellValue(i, "coffr_frt_rt_amt") != null
	            						&& sheetObj.GetCellValue(i, "coffr_frt_rt_amt") != "") {
	            			sheetObj.SetCellValue(i, "prc_prog_sts_cd","R");
	            			sheetObj.SetCellValue(i, "prc_prog_sts_nm","Returned");
	            		}
	            		// if C/Offer amount is cleared, Changing prc_prog_sts_cd to Initial
	            		if (sheetObj.GetRowStatus(i) == "U"
	        				&& bIsAproUsr
	        				&& formObj.prc_prop_sts_cd.value == "Q"
	        					&& sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "R"
	        						&& (sheetObj.GetCellValue(i, "coffr_frt_rt_amt") == null || sheetObj.GetCellValue(i, "coffr_frt_rt_amt") == "")) {
		        			sheetObj.SetCellValue(i, "prc_prog_sts_cd","I");
		        			sheetObj.SetCellValue(i, "prc_prog_sts_nm","Initial");
		        		}
	            		// In case of modifying rated with GRI Calc.,Changing A to M
	            		if (sheetObj.GetRowStatus(i) == "U"
	            			&& sheetObj.GetCellValue(i, "gri_appl_tp_cd") == "A") {
	            			sheetObj.SetCellValue(i, "gri_appl_tp_cd","M");
	            		}
	            	}
	                formObj.f_cmd.value=MULTI02;
	                var sParam=FormQueryString(formObj);
	                var sParamSheet2=sheetObjects[1].GetSaveString();
	                if (sParamSheet2 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
	                    if (formObj.amdt_seq.value == "0" && sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D") {
	                    	createNewDirectCall();
	                    	if (sheetObjects[10].RowCount()> 0 && sheetObjects[10].GetSelectRow()> 0) {
	                    		sheetObjects[10].SetCellValue(sheetObjects[10].GetSelectRow(), "dir_call_flg",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "dir_call_flg") == "1" ? "Y" : "N");
	                    	}
	                    }
	                }
	                var sParamSheet3=sheetObjects[2].GetSaveString();
	                if (sParamSheet3 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
	                }
	                var sParamSheet7=sheetObjects[6].GetSaveString();
	                if (sParamSheet7 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
	                }
	                var sParamSheet8=sheetObjects[7].GetSaveString();
	                if (sParamSheet8 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
	                }
	                var sParamSheet9=sheetObjects[8].GetSaveString();
	                if (sParamSheet9 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
	                }
	                var sParamSheet10=sheetObjects[9].GetSaveString();
	                if (sParamSheet10 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet10, "sheet10_");
	                }
	                var sParamSheet11=sheetObjects[10].GetSaveString();
	                if (sParamSheet11 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet11, "sheet11_");
	                }
	                var sParamSheet12=sheetObjects[11].GetSaveString();
	                if (sParamSheet12 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet12, "sheet12_");
	                }
	                if(isRadio == undefined || isRadio == null) {
		                if (!supressConfirm && !ComPriConfirmSave()) {
		                    return false;
		                }
	                }
	                saveCurRowPos();
 	                var sXml=sheetObj.GetSaveData("ESM_PRI_0003_08GS.do", sParam);
 	                sheetObjects[11].LoadSaveData(sXml);
 	                sheetObjects[10].LoadSaveData(sXml);
 	                sheetObjects[9].LoadSaveData(sXml);
 	                sheetObjects[8].LoadSaveData(sXml);
 	                sheetObjects[7].LoadSaveData(sXml);
 	                sheetObjects[6].LoadSaveData(sXml);
 	                sheetObjects[2].LoadSaveData(sXml);
 	                sheetObjects[1].LoadSaveData(sXml);
	                if (sheetObjects[1].IsDataModified()
	                        || sheetObjects[2].IsDataModified()
	                        || sheetObjects[6].IsDataModified()
	                        || sheetObjects[7].IsDataModified()
	                        || sheetObjects[8].IsDataModified()
	                        || sheetObjects[9].IsDataModified()
	                        || sheetObjects[10].IsDataModified()
	                        || sheetObjects[11].IsDataModified()) {
	                    return false;
	                } else {
	                	if (reloadSw) {
	                		saveCurRowPos();
	                		reloadPagePostTr(1);
	                		reloadSw=false;
	                	} else {
	                		restylingPagePostTr();
	                	}
	                    ComPriSaveCompleted();
	                    doActionIBSheet( sheetObj , document.form, IBSEARCH ); 
	                    return true;
	                }
	            }
	            doActionIBSheet( sheetObj , document.form, IBSEARCH ); 
	            return true;
	            break;
	        case IBDOWNEXCEL:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI01007');
	                return false;
	            }
	            if (sheetObj.id == "sheet13") {
	                formObj.f_cmd.value=SEARCH10;
 	                sheetObj.DoSearch("ESM_PRI_0003_08GS.do", FormQueryString(formObj) );
	            } else if (sheetObj.id == "sheet14") {
	                formObj.f_cmd.value=SEARCH11;
 	                sheetObj.DoSearch("ESM_PRI_0003_08GS.do", FormQueryString(formObj) );
	            }
	            break;
	        case IBINSERT: // Row Add
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	            	var idx=doRowChange1(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",getGenSpclRtTpCd());
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1);
	                sheetObj.SetCellValue(idx, "blet_dp_seq",sheetObj.GetCellValue(idx, "cmdt_hdr_seq"));
	                for (var i=1; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                sheet1_OnPopupClick(sheetObj, idx, 9);
	            }
	            if (sheetObj.id == "sheet2") {
	                var idx=doRowChange2(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                // Route Seq.= LastRow + 1
	                var rn="";
	                if (sheetObj.RowCount()== 1) {
	                	rn=sheetObjects[0].GetSelectRow()+ ".1";
	                } else {
	                	var lastRow=idx == sheetObj.LastRow()? sheetObj.LastRow()- 1 : sheetObj.LastRow();
	                	var arrRn=sheetObj.GetCellValue(lastRow, "rn").split(".");
	                	arrRn[1]=parseInt(arrRn[1], 10) + 1;
	                	rn=arrRn.join(".");
	                }
	                sheetObj.SetCellValue(idx, "rn",rn);
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",getGenSpclRtTpCd());
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq"));
	                sheetObj.SetCellValue(idx, "rout_seq",parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1);
	                for (var i=2; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                // when creating Route,creating DirectCall
	                createNewDirectCall();
	                sheet2_OnPopupClick(sheetObj, idx, 10);
	            }
	            if (sheetObj.id == "sheet3") {
	                var idx=sheetObj.DataInsert();
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",getGenSpclRtTpCd());
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	                sheetObj.SetCellValue(idx, "rout_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "rout_seq"));
	                sheetObj.SetCellValue(idx, "rt_seq",parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1);
	                sheetObj.SetCellValue(idx, "prop_frt_rt_amt",0.00);
	                sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	                sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	                sheetObj.SetCellValue(idx, "src_info_cd","NW");
	                sheetObj.SetCellValue(idx, "src_info_nm","New");
	                sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	                sheetObj.SetCellValue(idx, "rat_ut_cd", "D4");
	                sheetObj.SetCellValue(idx, "prc_cgo_tp_cd", "DR");
	                sheetObj.SetCellValue(idx, "curr_cd", "USD");
	                setSheet3Style(sheetObj, idx);
	                sheetObj.SelectCell(idx, "rat_ut_cd", false);
	            }
	            break;
	        case IBCOPYROW: // Row Copy
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	            	var prevCmdtHdrSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
	                var idx=doRowChange1(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                var newCmdtHdrSeq=parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                sheetObj.SetCellValue(idx, "blet_dp_seq",newCmdtHdrSeq);
	                sheetObj.SetCellEditable(idx, "blet_dp_seq",1);
	                // Copying Sheet4(CMDT)
	                for (var i=sheetObjects[3].LastRow(); i >= sheetObjects[3].HeaderRows(); i--) {
	                	if (sheetObjects[3].GetCellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	                		if (sheetObjects[3].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                    		continue;
	                    	}
	                		if (sheetObjects[3].GetCellValue(i, "src_info_cd") == "AD") {
	                    		continue;
	                    	}
	                        sheetObjects[3].SelectCell(i, 0);
	                        var insIdx=sheetObjects[3].DataCopy();
	                        sheetObjects[3].SetCellValue(insIdx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                        sheetObjects[3].SetCellValue(insIdx, "prc_prog_sts_cd","I");
	                        sheetObjects[3].SetCellValue(insIdx, "prc_prog_sts_nm","Initial");
	                        sheetObjects[3].SetCellValue(insIdx, "src_info_cd","NW");
	                        sheetObjects[3].SetCellValue(insIdx, "src_info_nm","New");
	                        sheetObjects[3].SetCellValue(insIdx, "eff_dt",formObj.eff_dt.value);
	                        sheetObjects[3].SetCellValue(insIdx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                        sheetObjects[3].SetCellValue(insIdx, "exp_dt",formObj.exp_dt.value);
	                    }
	                }
	                // Copying Sheet5(Actual Customer)
	                for (var i=sheetObjects[4].LastRow(); i >= sheetObjects[4].HeaderRows(); i--) {
	                	if (sheetObjects[4].GetCellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	                		if (sheetObjects[4].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                    		continue;
	                    	}
	                		if (sheetObjects[4].GetCellValue(i, "src_info_cd") == "AD") {
	                    		continue;
	                    	}
	                        sheetObjects[4].SelectCell(i, 0);
	                        var insIdx=sheetObjects[4].DataCopy();
	                        sheetObjects[4].SetCellValue(insIdx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                        sheetObjects[4].SetCellValue(insIdx, "prc_prog_sts_cd","I");
	                        sheetObjects[4].SetCellValue(insIdx, "prc_prog_sts_nm","Initial");
	                        sheetObjects[4].SetCellValue(insIdx, "src_info_cd","NW");
	                        sheetObjects[4].SetCellValue(insIdx, "src_info_nm","New");
	                        sheetObjects[4].SetCellValue(insIdx, "eff_dt",formObj.eff_dt.value);
	                        sheetObjects[4].SetCellValue(insIdx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                        sheetObjects[4].SetCellValue(insIdx, "exp_dt",formObj.exp_dt.value);
	                    }
	                }
	                // Copying Sheet6(Commodity Note)
	                for (var i=sheetObjects[5].LastRow(); i >= sheetObjects[5].HeaderRows(); i--) {
	                	if (sheetObjects[5].GetCellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	                		if (sheetObjects[5].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                    		continue;
	                    	}
	                		if (sheetObjects[5].GetCellValue(i, "src_info_cd") == "AD") {
	                    		continue;
	                    	}
	                        sheetObjects[5].SelectCell(i, 0);
	                        var insIdx=sheetObjects[5].DataCopy();
	                        sheetObjects[5].SetCellValue(insIdx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                        var prevNoteConvMapgId=sheetObjects[5].GetCellValue(i, "note_conv_mapg_id");
	                        formObj.f_cmd.value=COMMAND38;
 	                        var sXml=sheetObjects[5].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	                        var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	                        sheetObjects[5].SetCellValue(insIdx, "note_conv_mapg_id",sysGuid);
	                        sheetObjects[5].SetCellValue(insIdx, "prc_prog_sts_cd","I");
	                        sheetObjects[5].SetCellValue(insIdx, "prc_prog_sts_nm","Initial");
	                        sheetObjects[5].SetCellValue(insIdx, "src_info_cd","NW");
	                        sheetObjects[5].SetCellValue(insIdx, "src_info_nm","New");
	                        sheetObjects[5].SetCellValue(insIdx, "eff_dt",formObj.eff_dt.value);
	                        sheetObjects[5].SetCellValue(insIdx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                        sheetObjects[5].SetCellValue(insIdx, "exp_dt",formObj.exp_dt.value);
	                    }
	                }
	                for (var i=1; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                setNoteTooltip(sheetObj, idx);
	            }
	            // Route Group Copy. 
	            if (sheetObj.id == "sheet2") {
	            	var prevRoutSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_seq");
	                var idx=doRowChange2(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                var rn="";
	                if (sheetObj.RowCount()== 1) {
	                	rn=sheetObjects[0].GetSelectRow()+ ".1";
	                } else {
	                	var lastRow=idx == sheetObj.LastRow()? sheetObj.LastRow()- 1 : sheetObj.LastRow();
	                	var arrRn=sheetObj.GetCellValue(lastRow, "rn").split(".");
	                	arrRn[1]=parseInt(arrRn[1], 10) + 1;
	                	rn=arrRn.join(".");
	                }
	                sheetObj.SetCellValue(idx, "rn",rn);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                var newRoutSeq=parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                sheetObj.SetCellValue(idx, "rout_seq",newRoutSeq);
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                //sheetObjects[6,7,8,9,10,11] copy
	                for (var a=6; a <= 11; a++) {
	                	if (sheetObjects[a].RowCount()<= 0) {
	                		continue;
	                	}
	                    for (var i=sheetObjects[a].LastRow(); i >= sheetObjects[a].HeaderRows()&& sheetObjects[a].RowCount()> 0; i--) {
	                    	if (sheetObjects[a].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                    		sheetObjects[a].RowDelete(i, false);
	                    		continue;
	                    	}
	                    	if (sheetObjects[a].GetCellValue(i, "src_info_cd") == "AD") {
	                    		sheetObjects[a].RowDelete(i, false);
	                    		continue;
	                    	}
	                        var colName="";
	                        if (a == 6 || a == 9) {
	                            colName="rout_pnt_seq";
	                        } else if (a == 7 || a == 8) {
	                            colName="rout_via_seq";
	                        } else if (a == 11) {
	                            colName="rout_note_seq";
	                            var prevNoteConvMapgId=sheetObjects[a].GetCellValue(i, "note_conv_mapg_id");
	                            formObj.f_cmd.value=COMMAND38;
 	                            var sXml=sheetObjects[a].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	                            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	                            sheetObjects[a].SetCellValue(i, "note_conv_mapg_id",sysGuid);
	                        }
	                        sheetObjects[a].SetCellValue(i, "rout_seq",newRoutSeq);
	                        if (colName != "") {
	                        	sheetObjects[a].SetCellValue(i, colName,i);
	                        }
	                        sheetObjects[a].SetCellValue(i, "prc_prog_sts_cd","I");
	                        sheetObjects[a].SetCellValue(i, "prc_prog_sts_nm","Initial");
	                        sheetObjects[a].SetCellValue(i, "src_info_cd","NW");
	                        sheetObjects[a].SetCellValue(i, "src_info_nm","New");
	                        sheetObjects[a].SetCellValue(i, "eff_dt",formObj.eff_dt.value);
	                        sheetObjects[a].SetCellValue(i, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                        sheetObjects[a].SetCellValue(i, "exp_dt",formObj.exp_dt.value);
	                        sheetObjects[a].SetRowStatus(i,"I");
	                    }
	                }
	                for (var i=sheetObjects[2].LastRow(); i >= sheetObjects[2].HeaderRows()&& sheetObjects[2].RowCount()> 0; i--) {
	                	if (sheetObjects[2].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                	if (sheetObjects[2].GetCellValue(i, "src_info_cd") == "AD") {
	                		sheetObjects[2].RowDelete(i, false);
	                		continue;
	                	}
	                    sheetObjects[2].SetCellValue(i, "rout_seq",newRoutSeq);
	                    sheetObjects[2].SetCellValue(i, "rt_seq",i);
	                    sheetObjects[2].SetCellValue(i, "prc_prog_sts_cd","I");
	                    sheetObjects[2].SetCellValue(i, "prc_prog_sts_nm","Initial");
	                    sheetObjects[2].SetCellValue(i, "src_info_cd","NW");
	                    sheetObjects[2].SetCellValue(i, "src_info_nm","New");
	                    sheetObjects[2].SetCellValue(i, "eff_dt",formObj.eff_dt.value);
	                    sheetObjects[2].SetCellValue(i, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                    sheetObjects[2].SetCellValue(i, "exp_dt",formObj.exp_dt.value);
	                    sheetObjects[2].SetCellValue(i, "coffr_frt_rt_amt","");
	                    sheetObjects[2].SetCellValue(i, "fnl_frt_rt_amt","");
	                    sheetObjects[2].SetCellValue(i, "gri_appl_tp_cd","");
	                    sheetObjects[2].SetCellValue(i, "gri_appl_amt","");
	                    sheetObjects[2].SetCellValue(i, "acpt_usr_id","");
	                    sheetObjects[2].SetRowStatus(i,"I");
	                }
	                setSheet3Style(sheetObjects[2], -1);
	                setNoteTooltip(sheetObj, idx);
	            }
	            break;
	        case IBDELETE: // Delete
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	    		var sCheckedRows=sheetObj.FindCheckedRow("chk");
	    		var arrCheckedRows=sCheckedRows.split("|");
	        	if (sheetObj.id == "sheet1") {
	        		// Handling Sheet3 ~ Sheet12
	        		for (var a=2; a <= 11; a++) {
	        			// in case of deleting Row != selected row, not handing except sheet4~6
	        			// (because other cmdt group's data is loaded already,Should handle sheet4~6=)
	        			if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "0" && a != 3 && a != 4 && a != 5) {
	        				continue;
	        			}
	        			// Canceling all amendment
	        			if (formObj.amdt_seq.value != "0") {
		                	for (var i=sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount()> 0 && i <= sheetObjects[a].LastRow(); i++) {
		                		// Canceling amendment with same cmdt_hdr_seq with cmdt group's checked item on sheet4~6
		                		if (a == 3 || a == 4 || a == 5) {
		                			var bExist=false;
		                			var curCmdtHdrSeq=sheetObjects[a].GetCellValue(i, "cmdt_hdr_seq");
		                			for (var k=0; k < arrCheckedRows.length; k++) {
		                				if (sheetObj.GetCellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
		                					bExist=true;
		                				}
		                			}
		                			if (!bExist) {
		                				continue;
		                			}
		                		}
		                		if (sheetObjects[a].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
		                			sheetObjects[a].SetSelectRow(i + 1);
		                			// Amend Cancel
		                        	var prevIdx=doRowAmendCancel(sheetObjects[a]);
		                        	if (a == 2) {
		                        		setSheet3Style(sheetObjects[a], prevIdx);
		                        	}
		                		}
		                	}
	        			}
	                	for (var i=sheetObjects[a].LastRow(); sheetObjects[a].RowCount()> 0 && i >= sheetObjects[a].HeaderRows(); i--) {
	                		if (a == 3 || a == 4 || a == 5) {
	                			var bExist=false;
	                			var curCmdtHdrSeq=sheetObjects[a].GetCellValue(i, "cmdt_hdr_seq");
	                			for (var k=0; k < arrCheckedRows.length; k++) {
	                				if (sheetObj.GetCellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
	                					bExist=true;
	                				}
	                			}
	                			if (!bExist) {
	                				continue;
	                			}
	                		}
						// Amend Delete
	                		if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	                    		sheetObjects[a].SetSelectRow(i);
	                    		sheetObjects[a].SetCellValue(sheetObjects[a].GetSelectRow(), "chk","0",0);
	                    		if(sheetObjects[a].GetSelectRow() >= 0) {
		                       		var idx=doRowAmend(sheetObjects[a], "AD");
		                       		if (a == 2) {
		                    			setSheet3Style(sheetObjects[a], idx - 1);
		                    			setSheet3Style(sheetObjects[a], idx);
		                       		}
		                       		// changing Route Group data's RowStatus to R
		                       		if (a != 3 && a != 4 && a != 5) {
			                			sheetObjects[a].SetRowStatus(idx - 1,"R");
			                			sheetObjects[a].SetRowStatus(idx,"R");
		                       		}
	                    		}
	                       	// Row Delete
	                		} else if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
	                				&& (sheetObjects[a].GetCellValue(i, "src_info_cd") == "NW"
	                					|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC"
	                						|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "GM"
	                							|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC"
	                								|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "PM")) {
	                    		sheetObjects[a].RowDelete(i, false);
	                    	} 
	                	}
	        		}
	        		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
		            	for (var i=sheetObjects[1].LastRow(); sheetObjects[1].RowCount()> 0 && i >= sheetObjects[1].HeaderRows(); i--) {
		            		if (sheetObjects[1].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
		            			sheetObjects[1].RowDelete(i, false);
		            		} else {
			            		setHdrLineDeleted(sheetObjects[1], i);
			            		sheetObjects[1].SetRowStatus(i,"R");
		            		}
		            	}
	        		}
	            	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	            		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            			sheetObj.SetCellValue(arrCheckedRows[i], "chk",0,0);
	            			setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
	            		}
	            	}
	            	deleteRowCheck(sheetObj, "chk");
	        	} else if (sheetObj.id == "sheet2") {
	        		// Handling Sheet3, Sheet7 ~ Sheet12
	        		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
		        		for (var a=2; a <= 11; a++) {
							if (a == 3 || a == 4 || a == 5) {
								continue;
							}
		        			// Canceling all amendment
		        			if (formObj.amdt_seq.value != "0") {
			                	for (var i=sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount()> 0 && i <= sheetObjects[a].LastRow(); i++) {
			                		if (sheetObjects[a].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
			                			sheetObjects[a].SetSelectRow(i + 1);
			                        	var prevIdx=doRowAmendCancel(sheetObjects[a]);
			                        	if (a == 2) {
			                        		setSheet3Style(sheetObjects[a], prevIdx);
			                        	}
			                		}
			                	}
		        			}
		                	for (var i=sheetObjects[a].LastRow(); sheetObjects[a].RowCount()> 0 && i >= sheetObjects[a].HeaderRows(); i--) {
		                		if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
		                    		sheetObjects[a].SetSelectRow(i);
		                    		sheetObjects[a].SetCellValue(sheetObjects[a].GetSelectRow(), "chk","0",0);
		                       		var idx=doRowAmend(sheetObjects[a], "AD");
		                       		if (a == 2) {
		                    			setSheet3Style(sheetObjects[a], idx - 1);
		                    			setSheet3Style(sheetObjects[a], idx);
		                       		}
		                			//sheetObjects[a].RowStatus(idx - 1) = "R";
		                			//sheetObjects[a].RowStatus(idx) = "R";
		                		} else if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
		                				&& (sheetObjects[a].GetCellValue(i, "src_info_cd") == "NW"
		                					|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC"
		                						|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "GM"
		                							|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC"
		                								|| sheetObjects[a].GetCellValue(i, "src_info_cd") == "PM")) {
		                    		sheetObjects[a].RowDelete(i, false);
		                    	} 
		                	}
		        		}
	        		}
	        		// Deleting Sheet2
	            	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	            		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            			sheetObj.SetCellValue(arrCheckedRows[i], "chk",0,0);
	            			setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
	            		}
	            	}
	            	deleteRowCheck(sheetObj, "chk");
	        	} else if (sheetObj.id == "sheet3") {
	            	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	            		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
		            		sheetObj.SetSelectRow(arrCheckedRows[i]);
		               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
		               		var idx=doRowAmend(sheetObj, "AD");
		        			setSheet3Style(sheetObj, idx - 1);
		        			setSheet3Style(sheetObj, idx);
		            	}
		        	}
		        	deleteRowCheck(sheetObj, "chk");
	        	}
	            if (sheetObjects[1].GetSelectRow()== -1 || sheetObjects[1].GetRowHidden(sheetObjects[1].GetSelectRow())) {
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	            }
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
    // Retrieving svc_scp_cd
    function getParentSvcScpCd(){
    	return parent.sheetObjects[1].GetCellValue(parent.sheetObjects[1].GetSelectRow(),"svc_scp_cd");
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
        case IBSEARCH_ASYNC02: // Cancel all
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObjects[0].RowCount()<= 0) {
        		return false;
        	}
        	// in case of no approver,not requested
        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	// in case of no accepted item
        	if (acptCnt[getGenSpclRtTpChecked()] <= 0) {
        		ComShowCodeMessage("PRI00330");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC03: // Guideline Copy
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObjects[0].RowCount()> 0) {
        		ComShowCodeMessage("PRI01005");
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC11: // Amend
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (isRouteGroupDeleted4Rate()) {
        		return false;
        	}
            if (!checkRouteEditable()) {
                ComShowCodeMessage("PRI00309", "Commodity Group");
                return false;
            }
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC12: // Amend Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (isRouteGroupDeleted4Rate()) {
        		return false;
        	}
            if (!checkRouteEditable()) {
                ComShowCodeMessage("PRI00309", "Commodity Group");
                return false;
            }
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "src_info_cd") != "AM" && sheetObj.GetCellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "prc_prog_sts_cd") != "I") {
        		ComShowCodeMessage("PRI01037");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC13: // Accept
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if ((!bIsAproUsr && !bIsReqUsr) || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
        		}
        		// in case of accepting not returned status by requester without authority
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value
        				|| (bIsReqUsr && !bIsAproUsr && sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "R")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH_ASYNC14: // Accept Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (!bIsAproUsr || (formObj.prc_prop_sts_cd.value != "Q" && formObj.prc_prop_sts_cd.value != "R")) {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		// not accepted
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
        		}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH: 
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBSAVE:
            if (sheetObj.id == "sheet1") {
            	if (formObj.prc_prop_sts_cd.value != "I") {
            		return false;
            	}
                if (!sheetObjects[0].IsDataModified()
                		&& !sheetObjects[3].IsDataModified()
                		&& !sheetObjects[4].IsDataModified()
                		&& !sheetObjects[5].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                // in cae of modification on Route Group
                if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
                		&& !checkCmdtEditable()) {
                    ComShowCodeMessage("PRI00309", "Route Detail");
                    return false;
                }
                if (sheetObjects[0].IsDataModified()
                        && sheetObjects[0].GetSaveString() == "") {
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
            } else if (sheetObj.id == "sheet3") {
            	// possible to save if S/C= Initial & Requested
            	if (formObj.prc_prop_sts_cd.value != "I" && formObj.prc_prop_sts_cd.value != "Q") {
            		return false;
            	}
            	// Probihiting from deleting in case of deleted CMDT Group
            	if (isCMDTGroupDeleted()) {
            		return false;
            	}
                if (!sheetObjects[1].IsDataModified()
                        && !sheetObjects[2].IsDataModified()
                        && !sheetObjects[6].IsDataModified()
                        && !sheetObjects[7].IsDataModified()
                        && !sheetObjects[8].IsDataModified()
                        && !sheetObjects[9].IsDataModified()
                        && !sheetObjects[10].IsDataModified()
                        && !sheetObjects[11].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
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
                if (sheetObjects[6].IsDataModified()
                        && sheetObjects[6].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[7].IsDataModified()
                        && sheetObjects[7].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[8].IsDataModified()
                        && sheetObjects[8].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[9].IsDataModified()
                        && sheetObjects[9].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[10].IsDataModified()
                        && sheetObjects[10].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[11].IsDataModified()
                        && sheetObjects[11].GetSaveString() == "") {
                    return false;
                }
                // Checking Origin, O.Via, D.Via, Dest. Mandatory inputting.
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
                	&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "Origin");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
                	&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& isOViaMandatory
                	&& getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "O.Via");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
                	&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& isDViaMandatory
                	&& getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "D.Via");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
                	&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "Dest.");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
                	&& sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
    				&& getAmendValidRowCount(sheetObjects[2], formObj.amdt_seq.value) <= 0) {
    				ComShowCodeMessage("PRI01125");
    				return false;
    			}
    			// checking whether duplicating by Rating Unit, Cargo Type
            	var dupRow=ComPriAmendDupCheck(sheetObj, "rat_ut_cd|prc_cgo_tp_cd", formObj.amdt_seq.value);
            	if (dupRow >= 0) {
            		sheetObj.SetSelectRow(dupRow);
    				ComShowCodeMessage("PRI00302");
    				return false;
            	}
            }
            return true;
            break;
        case IBDOWNEXCEL: // 
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (sheetObj.id == "sheet1") {
        		if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
                	&& !checkCmdtEditable()) {
                    ComShowCodeMessage("PRI00309", "Route Detail");
                    return false;
                }
        	} else if (sheetObj.id == "sheet2") {
                if (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetSelectRow()<= 0) {
                    return false;
                }
            	if (isCMDTGroupDeleted()) {
            		return false;
            	}
                if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
            } else if (sheetObj.id == "sheet3") {
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    return false;
                }
            	if (isRouteGroupDeleted4Rate(true)) {
            		return false;
            	}
                if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
                if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
            }
            return true;
            break;
        case IBCOPYROW: // Row Copy
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
            if (sheetObj.RowCount()<= 0 || sheetObj.GetSelectRow()<= 0) {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (sheetObj.id == "sheet1") {
            	if (isCMDTGroupDeleted()) {
            		return false;
            	}
            	if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D" && !checkCmdtEditable()) {
                    ComShowCodeMessage("PRI00309", "Route Detail");
                    return false;
                }
        	} else if (sheetObj.id == "sheet2") {
            	if (isRouteGroupDeleted()) {
            		return false;
            	}
                if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
        	}
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
            if (sheetObj.id == "sheet1") {
            	if (isCMDTGroupDeleted()) {
            		return false;
            	}
            	if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
                	&& !checkCmdtEditable()) {
                    ComShowCodeMessage("PRI00309", "Route Detail");
                    return false;
                }
            	var sCheckedRows=sheetObj.FindCheckedRow("chk");
            	var arrCheckedRows=new Array();
            	if (sCheckedRows== "") {
            		arrCheckedRows.push(sheetObj.GetSelectRow());
            	} else { 
            		arrCheckedRows=sCheckedRows.split("|");
            	}
            	// Deletable        false : accepted case
            	for (var i=0; i < arrCheckedRows.length; i++) {
            		if (parseInt(sheetObj.GetCellValue(arrCheckedRows[i], "up_ac_cnt")) > 0) {
    	        		ComShowCodeMessage("PRI01132");
    	        		return false;
    	        	}
            	}
            } else if (sheetObj.id == "sheet2") {
            	if (isRouteGroupDeleted()) {
            		return false;
            	}
            	if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
            	var sCheckedRows=sheetObj.FindCheckedRow("chk");
            	var arrCheckedRows=new Array();
            	if (sCheckedRows== "") {
            		arrCheckedRows.push(sheetObj.GetSelectRow());
            	} else { 
            		arrCheckedRows=sCheckedRows.split("|");
            	}
            	// Deletable        false : accepted case
            	for (var i=0; i < arrCheckedRows.length; i++) {
            		if (parseInt(sheetObj.GetCellValue(arrCheckedRows[i], "up_ac_cnt")) > 0) {
    	        		ComShowCodeMessage("PRI01132");
    	        		return false;
    	        	}
            	}
            } else if (sheetObj.id == "sheet3") {
            	if (isRouteGroupDeleted4Rate()) {
            		return false;
            	}
            	if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
            	var sCheckedRows=sheetObj.FindCheckedRow("chk");
            	var arrCheckedRows=new Array();
            	if (sCheckedRows== "") {
            		arrCheckedRows.push(sheetObj.GetSelectRow());
            	} else { 
            		arrCheckedRows=sCheckedRows.split("|");
            	}
            	for (var i=0; i < arrCheckedRows.length; i++) {
            		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
                		ComShowCodeMessage("PRI00313");
                		return false;
                	}
            		if (sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "NW"
            			&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GC"
            				&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GM"
            					&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PC"
            						&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PM"
            							&& sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
    					ComShowCodeMessage("PRI00313");
    					return false;
    				}
            		if (formObj.amdt_seq.value == sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") && sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "I") {
    	        		ComShowCodeMessage("PRI01037");
    	        		return false;
    	        	}
            	}
            }
        	return true;
            break;
        }
    }
	/**
	 * Checking validation CMDT Group's Bullet No.<br>
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,Process Flag constant variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function validateBulletNo(sheetObj, formObj, sAction) {
        // checking duplicated Bullet No
    	var rowDup=sheetObj.ColValueDup("blet_dp_seq", false);
        if (rowDup >= 0) {
			ComShowCodeMessage("PRI00332", "Bullet No.");
			return false;
        }
        // Preparing to check Bullet No. usable starting number and continuity
        var arrChk=new Array();
        for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
        	if (sheetObj.GetRowStatus(i) == "D") {
        		continue;
        	}
        	if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		continue;
        	}
        	if (parseInt(sheetObj.GetCellValue(i, "blet_dp_seq")) == 0) {
    			ComShowCodeMessage("PRI01048", "Bullet No.", parseInt(sheetObj.GetEtcData("max_blet_dp_seq")) + 1);
    			return false;
        	}
        	var dpSeq=parseInt(sheetObj.GetCellValue(i, "blet_dp_seq")) - parseInt(sheetObj.GetEtcData("max_blet_dp_seq")) - 1;
        	arrChk[dpSeq]=dpSeq;
        }
        if (arrChk.length > 0 && arrChk[0] != 0) {
			ComShowCodeMessage("PRI01048", "Bullet No.", parseInt(sheetObj.GetEtcData("max_blet_dp_seq")) + 1);
			return false;
        }
        for (var i=0; i < arrChk.length; i++) {
        	if (arrChk[i] == null || arrChk[i] == undefined || arrChk[i] != i) {
				ComShowCodeMessage("PRI01049", "Bullet No.");
				return false;
        	}
        }
        return true;
    }
	/**
	 * Returning modified 
	 * 
	 * @returns bool <br>
	 *          true  : editable true. <br>
	 *          false : editable false
	 * @author 
	 * @version 2009.05.01
	 */
    function checkCmdtEditable() {
        if (sheetObjects[1].IsDataModified()
        		|| sheetObjects[2].IsDataModified()
        		|| sheetObjects[6].IsDataModified()
        		|| sheetObjects[7].IsDataModified()
        		|| sheetObjects[8].IsDataModified()
        		|| sheetObjects[9].IsDataModified()
        		|| sheetObjects[10].IsDataModified()
        		|| sheetObjects[11].IsDataModified()) {
            return false;
        }
        return true;
    }
	/**
	 * checking editable for route
	 * 
	 * @returns bool <br>
	 *          true  : editable true<br>
	 *          false : editable false
	 * @author 
	 * @version 2009.05.01
	 */
    function checkRouteEditable() {
        if (sheetObjects[0].IsDataModified()
        		|| sheetObjects[3].IsDataModified()
        		|| sheetObjects[4].IsDataModified()
        		|| sheetObjects[5].IsDataModified()) {
            return false;
        }
        return true;
    }
	/**
	 * in case of svc scope with Direct Call,resetting values in case of no direct call data 
	 * 
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function createNewDirectCall() {
    	var formObj=document.form;
    	if (isDirCallVisible) {
	    	if (sheetObjects[10].RowCount()<= 0) {
		        var idxDir=sheetObjects[10].DataInsert();
		        sheetObjects[10].SetCellValue(idxDir, "prop_no",formObj.prop_no.value);
		        sheetObjects[10].SetCellValue(idxDir, "amdt_seq",formObj.amdt_seq.value);
		        sheetObjects[10].SetCellValue(idxDir, "svc_scp_cd",formObj.svc_scp_cd.value);
		        sheetObjects[10].SetCellValue(idxDir, "gen_spcl_rt_tp_cd",getGenSpclRtTpCd());
		        sheetObjects[10].SetCellValue(idxDir, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
		        sheetObjects[10].SetCellValue(idxDir, "rout_seq",formObj.rout_seq.value);
		        sheetObjects[10].SetCellValue(idxDir, "dir_call_flg","N");
		        sheetObjects[10].SetCellValue(idxDir, "prc_prog_sts_cd","I");
		        sheetObjects[10].SetCellValue(idxDir, "prc_prog_sts_nm","Initial");
		        sheetObjects[10].SetCellValue(idxDir, "src_info_cd","NW");
		        sheetObjects[10].SetCellValue(idxDir, "src_info_nm","New");
		        sheetObjects[10].SetCellValue(idxDir, "eff_dt",formObj.eff_dt.value);
		        sheetObjects[10].SetCellValue(idxDir, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
		        sheetObjects[10].SetCellValue(idxDir, "exp_dt",formObj.exp_dt.value);
	    	}
    	}
    }
	/**
	 * to find selected row, saving current row position to global vairable.
	 * 
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function saveCurRowPos() {
        s1PrevRow=sheetObjects[0].GetSelectRow();
        s2PrevRow=sheetObjects[1].GetSelectRow();
        s3PrevRow=sheetObjects[2].GetSelectRow();
        s1PrevKey=sheetObjects[0].GetCellValue(s1PrevRow, "cmdt_hdr_seq");
        s2PrevKey=sheetObjects[1].GetCellValue(s2PrevRow, "rout_seq");
        s3PrevKey=sheetObjects[2].GetCellValue(s3PrevRow, "rt_seq");
    }
	/**
	 * Reloading. 
	 * 
	 * @param {int} sheetNo selection 0:from CMDT 1:from Route. Default : 0.
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function reloadPagePostTr(sheetNo) {
    	if (sheetNo == null || sheetNo == "" || sheetNo < 0) {
    		sheetNo=0;
    	}
    	// Notify to Main
    	updateSummary();
    	drawGenSpclRtTpCd();
    	// Setting event flag to off in order to prohibit from retrieving by event
    	isFiredNested=true;
    	isFiredNestedExt=true;
    	if (sheetNo == 0) {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	    	if (sheetObjects[0].RowCount()> 0) {
	    		if (s1PrevRow > sheetObjects[0].LastRow()) {
	        		s1PrevRow=sheetObjects[0].LastRow();
	        	} else if (s1PrevRow <= 0) {
	        		s1PrevRow=1;
	        	}
	    		// Moving to saved row compulsory 
	            sheetObjects[0].SetSelectRow(s1PrevRow);
	            sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), false);
	    	} else {
	    		isFiredNested=false;
	    		isFiredNestedExt=false;
	    		return;
	    	}
    	}
    	// Setting Sheet1 event On
    	isFiredNested=false;
    	doRowChange1(-1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), IBSEARCH);
    	if (sheetObjects[1].RowCount()> 0) {
        	// controlling that selected row already saved sheet do not get out of between FirstRow and LastRow
    		if (s2PrevRow > sheetObjects[1].LastRow()) {
        		s2PrevRow=sheetObjects[1].LastRow();
        	} else if (s2PrevRow <= 0) {
        		s2PrevRow=1;
        	}
    		// Moving to saved row compulsory 
        	sheetObjects[1].SetSelectRow(s2PrevRow);
        	sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), false);
    	} else {
    		isFiredNestedExt=false;
    		return;
    	}
    	// Setting Sheet2 event On
    	isFiredNestedExt=false;
    	doRowChange2(-1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), IBSEARCH);
    	if (sheetObjects[2].RowCount()> 0) {
        	// controlling that selected row already saved sheet do not get out of between FirstRow and LastRow
    		if (s3PrevRow > sheetObjects[2].LastRow()) {
        		s3PrevRow=sheetObjects[2].LastRow();
        	} else if (s3PrevRow <= 0) {
        		s3PrevRow=1;
        	}
    		// Moving to saved row compulsory 
        	sheetObjects[2].SetSelectRow(s3PrevRow);
        	sheetObjects[2].SelectCell(sheetObjects[2].GetSelectRow(), sheetObjects[2].GetSelectCol(), false);
    	} else {
    		return;
    	}
    }
    function reloadAll(){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
	/**
	 * SEtting , CMDT & Route Group's font color or strike and etc after CUD
	 * 
	 * @param {boolean} reloadAll selection,default : false
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function restylingPagePostTr(reloadAll) {
    	var formObj=document.form;
    	updateSummary();
    	drawGenSpclRtTpCd();
    	if (formObj.amdt_seq.value == "0") {
    		return true;
    	}
    	var cmdtCurRow=sheetObjects[0].GetSelectRow();
    	var routCurRow=sheetObjects[1].GetSelectRow();
    	sheetObjects[sheetObjects.length - 1].SetWaitImageVisible(0);
        formObj.f_cmd.value=SEARCH15;
        var param=FormQueryString(formObj);
        if (reloadAll) {	// for all CMDT
        	param += "&reload_all=Y";
        } else {			// for selected row
        	param += "&reload_all=N";
        }
         var sXml=sheetObjects[sheetObjects.length - 1].GetSearchData("ESM_PRI_0003_08GS.do" , param);
        // arrXml 0: CMDT Group XML, 1 : Route Group XML
        var arrXml=sXml.split("|$$|");
        // applying style to CMDT Group
        if (arrXml.length > 0) {
       		// nd_cnt : count of not deleted item
        	// na_cnt : count of not accepted item
        	// cmdt_hdr_seq
        	// up_cnt : count of amended item
        	var arrTemp=ComPriXml2Array(arrXml[0], "nd_cnt|na_cnt|cmdt_hdr_seq|up_cnt");
       		if (arrTemp != null && arrTemp.length > 0) {
	       		for (var i=0; i < arrTemp.length; i++) {
	    			var ndCnt=parseInt(arrTemp[i][0]);
	    			var naCnt=parseInt(arrTemp[i][1]);
	    			var upCnt=parseInt(arrTemp[i][3]);
	    			cmdtCurRow=sheetObjects[0].FindText("cmdt_hdr_seq", arrTemp[i][2]);
	    			if (cmdtCurRow < 0) {
	    				continue;
	    			}
	    			// Setting strike in case of deleting all item
	    			if (ndCnt == 0) {
 	    				sheetObjects[0].SetCellFont("FontStrike", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol(), true);
	    			} else {
 	    				sheetObjects[0].SetCellFont("FontStrike", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol(), false);
	    			}
	    			//font-color = red if un-accepted item exists
	    			if (naCnt == 0) {
	    				// font-color : blue if modified item exists and the item is accepted all
	    				if (upCnt == 0) {
	    					sheetObjects[0].SetRowFontColor(cmdtCurRow,"#000000");
	    				} else {
	    					sheetObjects[0].SetRowFontColor(cmdtCurRow,"#0000FF");
	    				}
	    			} else {
	    				sheetObjects[0].SetRowFontColor(cmdtCurRow,"#FF0000");
	    			}
	       		}
       		}
        }
        // Retrieving sheet in case of old selected row is different from current selected row
        if (s1PrevKey != sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq")) {
        	doRowChange1(-1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), IBSEARCH);
        } else {
        	// applying style to Route Group grid
        	if (arrXml.length > 1) {
		   		var arrTemp=ComPriXml2Array(arrXml[1], "nd_cnt|na_cnt|up_cnt");
		   		if (arrTemp != null && arrTemp.length > 0) {
					var ndCnt=parseInt(arrTemp[0][0]);
					var naCnt=parseInt(arrTemp[0][1]);
					var upCnt=parseInt(arrTemp[0][2]);
					// Setting strike in case of deleting all item
					if (ndCnt == 0) {
 						sheetObjects[1].SetCellFont("FontStrike", routCurRow, 1, routCurRow, sheetObjects[1].LastCol(), true);
					} else {
 						sheetObjects[1].SetCellFont("FontStrike", routCurRow, 1, routCurRow, sheetObjects[1].LastCol(), false);
					}
					// font-color = red if un-accepted item exists
					if (naCnt == 0) {
						//  font-color : blue if modified item exists and the item is accepted all
						if (upCnt == 0) {
							sheetObjects[1].SetRowFontColor(routCurRow,"#000000");
						} else {
							sheetObjects[1].SetRowFontColor(routCurRow,"#0000FF");
						}
					} else {
						sheetObjects[1].SetRowFontColor(routCurRow,"#FF0000");
					}
		   		}
		    }
        	// Retrieving sheet3 in case of old selected row is different from current selected row
        	if (s2PrevKey != sheetObjects[1].GetCellValue(routCurRow, "rout_seq")) {
		    	doRowChange2(-1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), IBSEARCH);
	        }
        }
        sheetObjects[sheetObjects.length - 1].SetWaitImageVisible(1);
        //no support[implemented common]CLT changeSelectBackColor4Rate(sheetObjects[0]);
        //no support[implemented common]CLT changeSelectBackColor4Rate(sheetObjects[1]);
    }
	/**
	 * Move to row related seq.Moving by double clicking on Accept All screen
	 * 
	 * @param {int} cmdtHdrSeq selection CMDT_HDR_SEQ. Default: 1.
	 * @param {int} routeSeq selection ROUT_HDR_SEQ. Default: 1.
	 * @param {int} rtSeq selection RT_SEQ. Default: 1.
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function moveRowPosTo(cmdtHdrSeq, routeSeq, rtSeq) {
    	if (cmdtHdrSeq != null && cmdtHdrSeq != "" && cmdtHdrSeq != undefined) {
    		s1PrevRow=sheetObjects[0].FindText("cmdt_hdr_seq", cmdtHdrSeq);
            s2PrevRow=1;
    	} else {
            s1PrevRow=1;
            s2PrevRow=1;
    	}
        sheetObjects[0].SetSelectRow(s1PrevRow);
        sheetObjects[0].SelectCell(sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), false);
        doRowChange1(-1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), IBSEARCH);
    	if (routeSeq != null && routeSeq != "" && routeSeq != undefined) {
    		s2PrevRow=sheetObjects[1].FindText("rout_seq", routeSeq);
    	} else {
            s2PrevRow=1;
    	}
    	sheetObjects[1].SetSelectRow(s2PrevRow);
    	sheetObjects[1].SelectCell(sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), false);
    	doRowChange2(-1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), IBSEARCH);
    	if (rtSeq != null && rtSeq != "" && rtSeq != undefined) {
    		s3PrevRow=sheetObjects[2].FindText("rt_seq", rtSeq);
    	} else {
            s3PrevRow=1;
    	}
    	sheetObjects[2].SetSelectRow(s3PrevRow);
    	sheetObjects[2].SelectCell(sheetObjects[2].GetSelectRow(), sheetObjects[2].GetSelectCol(), false);
    }
	/**
	 * Showing and retrieving General/Special Type Code radio box
	 * 
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function drawGenSpclRtTpCd() {
    	var formObj=document.form;
        formObj.f_cmd.value=SEARCH20;
         var sXml=sheetObjects[sheetObjects.length - 1].GetSearchData("ESM_PRI_0003_08GS.do" , FormQueryString(formObj) + "&n1st_cmnc_amdt_seq=" + formObj.amdt_seq.value);
        var arrData=ComPriXml2Array(sXml, "cd|nm|rate_cnt|amdt_flg|acpt_flg|acpt_cnt|not_acpt_cnt|amdt_cnt");
        var sHTML="";
        var prevChecked=getGenSpclRtTpChecked();
        var firstMatch=-1;
        for (var i=0; i < arrData.length; i++) {
        	var bAmdtFlg=arrData[i][3];
        	var bAcptFlg=arrData[i][4];
        	acptCnt[i]=arrData[i][5];
        	notAcptCnt[i]=arrData[i][6];
        	if (document.form.lgcy_if_flg.value != "Y") {
	        	if (bAmdtFlg == "Y" && bAcptFlg == "Y") {
	        		arrData[i][1]="<font color='blue'>" + arrData[i][1] + "</font>";
	        	} else if (bAmdtFlg == "Y" && bAcptFlg != "Y" && formObj.amdt_seq.value != "0") {
	        		arrData[i][1]="<font color='red'>" + arrData[i][1] + "</font>";
	        	}
        	}
            if (parseInt(arrData[i][2]) > 0) {
                if (firstMatch < 0) {
                    firstMatch=i;
                }
                arrData[i][1]="<b>" + arrData[i][1] + "</b>";
            }
            sHTML += "<input name='gen_spcl_rt_tp_cd' value='" + arrData[i][0] + "' type='radio' class='trans'>  ";
            sHTML += arrData[i][1] + "&nbsp;&nbsp;&nbsp;&nbsp;";
        }
        rdoRateTp.innerHTML=sHTML;
        if (prevChecked != null && prevChecked != undefined && prevChecked >= 0 && parseInt(arrData[prevChecked][2]) > 0) {
        	formObj.gen_spcl_rt_tp_cd[prevChecked].checked=true;
        } else if (firstMatch >= 0) {
        	formObj.gen_spcl_rt_tp_cd[firstMatch].checked=true;
        } else {
        	formObj.gen_spcl_rt_tp_cd[0].checked=true;
        }
        if (formObj.gen_spcl_rt_tp_cd[0].checked) {
        	sheetObjects[0].SetColHidden("cust_lgl_eng_nm",1);
        	sheetObjects[0].SetColWidth("prc_cmdt_def_nm",650);
        }
    }
	/**
	 * Returning selected General/Special Type Code
	 * 
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function getGenSpclRtTpCd() {
        for (var i=0; i < document.form.gen_spcl_rt_tp_cd.length; i++) {
            if (document.form.gen_spcl_rt_tp_cd[i].checked) {
                return document.form.gen_spcl_rt_tp_cd[i].value;
            }
        }
    }
	/**
	 * Returning selected General/Special Type sequence
	 * 
	 * @returns N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function getGenSpclRtTpChecked() {
        for (var i=0; i < document.form.gen_spcl_rt_tp_cd.length; i++) {
            if (document.form.gen_spcl_rt_tp_cd[i].checked) {
                return i;
            }
        }
    }
	/**
	 * Returning selected PRSCostLevel  code
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    /*function getRdoPRSCostLevel() {
        for (var i=0; i < document.form.rdoPRSCostLevel.length; i++) {
            if (document.form.rdoPRSCostLevel[i].checked) {
                return document.form.rdoPRSCostLevel[i].value;
            }
        }
    }
    */
	/**
	 *  Returning Max + 1 Bullet No.
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function getNextBletDpSeq() {
    	return Math.max(parseInt(ComPriGetMax(sheetObjects[0], "blet_dp_seq")), parseInt(sheetObjects[0].GetEtcData("max_blet_dp_seq"))) + 1;
    }
	/**
	 * Amend or Amend Delete about selected row
	 * using in popup
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowAmend(sheetObj, sAction) {
		var idx=sheetObj.DataCopy();
		var prevIdx=idx - 1;
		sheetObj.SetCellValue(idx, "eff_dt",document.form.eff_dt.value,0);
		sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",document.form.amdt_seq.value,0);
		sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
		sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial",0);
		sheetObj.SetCellValue(idx, "src_info_cd",sAction,0);
		if (sAction == "AM") {
			sheetObj.SetCellValue(idx, "src_info_nm","Amend",0);
		} else if (sAction == "AD") {
			sheetObj.SetCellValue(idx, "src_info_nm","Delete",0);
		}
		if (document.form.dur_dup_flg.value == "Y") {
			sheetObj.SetCellValue(prevIdx, "exp_dt",document.form.pre_exp_dt.value,0);
		}
		sheetObj.SetCellValue(prevIdx, "amdt_seq",document.form.pre_amdt_seq.value,0);
		sheetObj.SetRowStatus(prevIdx,"R");
		sheetObj.SetRowStatus(idx,"U");
		return idx;
    }
	/**
	 *  Amend Cancel about selected row
	 * using in popup
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowAmendCancel(sheetObj) {
    	var idx=sheetObj.GetSelectRow();
		var prevIdx=idx - 1;
		if (sheetObj.GetCellValue(idx, "ibflag") != "I") {
			if (document.form.dur_dup_flg.value == "Y") {
				sheetObj.SetCellValue(prevIdx, "exp_dt",document.form.exp_dt.value,0);
			}
			sheetObj.SetCellValue(prevIdx, "amdt_seq",document.form.amdt_seq.value,0);
			// code for diable to save in case of repeating Amend and Amend Cancel
			if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
				sheetObj.SetRowStatus(prevIdx,"U");
			}
		}
		sheetObj.RowDelete(idx, false);
		return prevIdx;
    }
	/**
	 * Setting line's style(font color,strike , etc) by calling setLineStyle, setLineEnable function<br>
	 * setLineStyle is common function
	 * setLineEnable is seperated by each screen and popup screen
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheet3Style(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
	/**
	 * Showing symbol of deletion in case of deleting CMDT & Route Group data(if Amend Seq. >1)
	 * Making server recognize Group level's deletion by setting  n1st_cmnc_amdt_seq to -1
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setHdrLineDeleted(sheetObj, idx) {
		sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq","-1",0);
     	sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(), true);
    	sheetObj.SetRowFontColor(idx,"#FF0000");
    }
	/**
	 * Setting style(font,strike etc) to selected row
	 *  
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineStyle(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetRowStatus(idx) == "D") {
    		sheetObj.SetRowHidden(idx,1);
    	}
    	// 
    	/*if (sheetObj.id == "sheet3") {
if (sheetObj.GetCellValue(idx, "diff") < 0) {
         		sheetObj.SetCellFontColor(idx, "diff","#FF0000");
        	}
    	}*/
    	// Don't apply color in case of Proposal status
    	if (document.form.amdt_seq.value == "0" || document.form.lgcy_if_flg.value == "Y") {
    		return true;
    	}
    	// setting strike and making row diable about previous seq data.
    	// But.in case of RFA, making all rows Uneditable by using RowEditable Method.
    	// In case of S/C,Making each row Unditable by looping because should open conversion screen at Note
    	if (sheetObj.GetCellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
 			sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(), true);
			for (var i=0; i <= sheetObj.LastCol(); i++) {
				sheetObj.SetCellEditable(idx, i,0);
			}
			return true;
		} else {
 			sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(), false);
			sheetObj.SetRowEditable(idx,1);
    	}
    	// Font-color : red in case of this sequence's data
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
 			sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
    	} else {
     		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#000000");
    	}
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * Setting each column by row or all row's one to enable/disable after retrieving
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} idx
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "prc_prog_sts_cd") == "I"
    				&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.SetCellEditable(idx, "rat_ut_cd",1);
	        	sheetObj.SetCellEditable(idx, "prc_cgo_tp_cd",1);
	        	sheetObj.SetCellEditable(idx, "curr_cd",1);
	        	sheetObj.SetCellEditable(idx, "prop_frt_rt_amt",1);
		} else {
        	sheetObj.SetCellEditable(idx, "rat_ut_cd",0);
        	sheetObj.SetCellEditable(idx, "prc_cgo_tp_cd",0);
        	sheetObj.SetCellEditable(idx, "curr_cd",0);
        	sheetObj.SetCellEditable(idx, "prop_frt_rt_amt",0);
		}
        if (bIsAproUsr
        	&& document.form.prc_prop_sts_cd.value == "Q"
        		&& sheetObj.GetCellValue(idx, "prc_prog_sts_cd") != "A") {
        	sheetObj.SetCellEditable(idx, "coffr_frt_rt_amt",1);
        } else {
        	sheetObj.SetCellEditable(idx, "coffr_frt_rt_amt",0);
        }
    }
	/**
	 * SEtting Note Tooltip<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} idx Mandatory
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function setNoteTooltip(sheetObj, idx) {
    	sheetObj.SetToolTipText(idx, "note_clss_nm",sheetObj.GetCellValue(idx, "note_clss_nm_tooltip"));
    }
    function getSurchargeList(sheetNo) {
        var formObj=document.form;
        var arrSurcharge=new Array();
        if (sheetNo == 5 || sheetNo == 11) {
        	for (var i=sheetObjects[sheetNo].HeaderRows(); sheetObjects[sheetNo].RowCount()> 0 && i <= sheetObjects[sheetNo].LastRow(); i++) {
        		if (sheetObjects[sheetNo].GetCellValue(i, "note_clss_cd") == "S") {
        			var chgCd=sheetObjects[sheetNo].GetCellValue(i, "chg_cd");
	        		if (chgCd != null && chgCd != "") {
	        			arrSurcharge.push(chgCd);
	        		}
        		}
        	}
        }
        return arrSurcharge;
    }
	/**
	 * Getting XML from Sheet Data<br>
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
        if (sheetNo == 3 || sheetNo == 4 || sheetNo == 5) {
            sCol="prop_no|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + getGenSpclRtTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        sXml=ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        return sXml;
    }
	/**
	 * Loading data with xml format to sheet<br>
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
        if (sheetNo == 3 || sheetNo == 4 || sheetNo == 5) {
            bAppendMode=1;
            sCol="prop_no|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + getGenSpclRtTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }

    function updateSummary() {
    	var termTpCd="";
    	if (getGenSpclRtTpCd() == "G") {
    		termTpCd=TERMS_TYPE_CODE_GEN;
    	} else if (getGenSpclRtTpCd() == "S") {
    		termTpCd=TERMS_TYPE_CODE_SPCL;
    	}
    	var rtn=null;
    	try {
    		rtn=parent.comUpdateProposalStatusSummary(termTpCd, document.form.svc_scp_cd.value);
        } catch(e) {
        }
    	return rtn;
    }
	/**
	 * control all buttons of screen<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode Mandatory 
	 * @author 
	 * @version 2009.05.01
	 */
    function toggleButtons(mode) {
        switch (mode) {
        case "CLEAR":
            ComBtnDisable("btn_retrieve");
            ComBtnDisable("btn_acceptall");
            ComBtnDisable("btn_cancel");
            ComBtnDisable("btn_glcopy");
            ComBtnDisable("btn_gricalc");
            ComBtnDisable("btn_viewall");
            ComBtnDisable("btn_downexcel");
            ComBtnDisable("btn_loadexcel");
        	ComBtnDisable("btn_rowadd1");
        	ComBtnDisable("btn_rowadd2");
        	ComBtnDisable("btn_rowadd3");
        	ComBtnDisable("btn_rowcopy1");
        	ComBtnDisable("btn_rowcopy2");
        	ComBtnDisable("btn_delete1");
        	ComBtnDisable("btn_delete2");
        	ComBtnDisable("btn_delete3");
        	ComBtnDisable("btn_save1");
        	ComBtnDisable("btn_save2");
        	ComBtnDisable("btn_save3");
        	ComBtnDisable("btn_amend3");
        	ComBtnDisable("btn_amendcancel3");
            ComBtnDisable("btn_accept3");
            ComBtnDisable("btn_acceptcancel3");
//    		sheetObjects[12].ColHidden("buc_usd_amt") = true;
//    		sheetObjects[12].ColHidden("ifc_usd_amt") = true;
//    		sheetObjects[12].ColHidden("psc_usd_amt") = true;
//    		sheetObjects[13].ColHidden("buc_dry20") = true;
//    		sheetObjects[13].ColHidden("buc_dry40") = true;
//    		sheetObjects[13].ColHidden("buc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("buc_dry45") = true;
//    		sheetObjects[13].ColHidden("buc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("buc_rd40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_dry20") = true;
//    		sheetObjects[13].ColHidden("ifc_dry40") = true;
//    		sheetObjects[13].ColHidden("ifc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_dry45") = true;
//    		sheetObjects[13].ColHidden("ifc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_rd40hc") = true;
//    		sheetObjects[13].ColHidden("psc_dry20") = true;
//    		sheetObjects[13].ColHidden("psc_dry40") = true;
//    		sheetObjects[13].ColHidden("psc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("psc_dry45") = true;
//    		sheetObjects[13].ColHidden("psc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("psc_rd40hc") = true;
            break;
        case "INIT":
        	ComBtnEnable("btn_retrieve");
        	ComBtnEnable("btn_viewall");
        	ComBtnEnable("btn_downexcel");
        	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        		if (getGenSpclRtTpCd() == "G" && sheetObjects[0].RowCount()<= 0) {
        			ComBtnEnable("btn_glcopy");
        		} else {
        			ComBtnDisable("btn_glcopy");
        		}
        		if (parseInt(sheetObjects[0].ComputeSum("|15|")) > 0) {
        			ComBtnDisable("btn_gricalc");
        		} else {
        			ComBtnEnable("btn_gricalc");
        		}
        		ComBtnEnable("btn_loadexcel");
        	} else {
        		ComBtnDisable("btn_glcopy");
        		ComBtnDisable("btn_gricalc");
        		ComBtnDisable("btn_loadexcel");
        	}
        	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
            	ComBtnEnable("btn_acceptall");
	        	ComBtnEnable("btn_cancel");
        	} else {
        		ComBtnDisable("btn_acceptall");
        		ComBtnDisable("btn_cancel");
        	}
        	if (bIsReqUsr || bIsAproUsr) {
//        		sheetObjects[12].ColHidden("buc_usd_amt") = false;
//        		sheetObjects[12].ColHidden("ifc_usd_amt") = false;
//        		sheetObjects[12].ColHidden("psc_usd_amt") = false;
//        		sheetObjects[13].ColHidden("buc_dry20") = false;
//        		sheetObjects[13].ColHidden("buc_dry40") = false;
//        		sheetObjects[13].ColHidden("buc_dry40hc") = false;
//        		sheetObjects[13].ColHidden("buc_dry45") = false;
//        		sheetObjects[13].ColHidden("buc_rf40hc") = false;
//        		sheetObjects[13].ColHidden("buc_rd40hc") = false;
//        		sheetObjects[13].ColHidden("ifc_dry20") = false;
//        		sheetObjects[13].ColHidden("ifc_dry40") = false;
//        		sheetObjects[13].ColHidden("ifc_dry40hc") = false;
//        		sheetObjects[13].ColHidden("ifc_dry45") = false;
//        		sheetObjects[13].ColHidden("ifc_rf40hc") = false;
//        		sheetObjects[13].ColHidden("ifc_rd40hc") = false;
//        		sheetObjects[13].ColHidden("psc_dry20") = false;
//        		sheetObjects[13].ColHidden("psc_dry40") = false;
//        		sheetObjects[13].ColHidden("psc_dry40hc") = false;
//        		sheetObjects[13].ColHidden("psc_dry45") = false;
//        		sheetObjects[13].ColHidden("psc_rf40hc") = false;
//        		sheetObjects[13].ColHidden("psc_rd40hc") = false;
        	} else {
//        		sheetObjects[12].ColHidden("buc_usd_amt") = true;
//        		sheetObjects[12].ColHidden("ifc_usd_amt") = true;
//        		sheetObjects[12].ColHidden("psc_usd_amt") = true;
//        		sheetObjects[13].ColHidden("buc_dry20") = true;
//        		sheetObjects[13].ColHidden("buc_dry40") = true;
//        		sheetObjects[13].ColHidden("buc_dry40hc") = true;
//        		sheetObjects[13].ColHidden("buc_dry45") = true;
//        		sheetObjects[13].ColHidden("buc_rf40hc") = true;
//        		sheetObjects[13].ColHidden("buc_rd40hc") = true;
//        		sheetObjects[13].ColHidden("ifc_dry20") = true;
//        		sheetObjects[13].ColHidden("ifc_dry40") = true;
//        		sheetObjects[13].ColHidden("ifc_dry40hc") = true;
//        		sheetObjects[13].ColHidden("ifc_dry45") = true;
//        		sheetObjects[13].ColHidden("ifc_rf40hc") = true;
//        		sheetObjects[13].ColHidden("ifc_rd40hc") = true;
//        		sheetObjects[13].ColHidden("psc_dry20") = true;
//        		sheetObjects[13].ColHidden("psc_dry40") = true;
//        		sheetObjects[13].ColHidden("psc_dry40hc") = true;
//        		sheetObjects[13].ColHidden("psc_dry45") = true;
//        		sheetObjects[13].ColHidden("psc_rf40hc") = true;
//        		sheetObjects[13].ColHidden("psc_rd40hc") = true;
        	}
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_rowadd3");
			ComBtnDisable("btn_rowcopy1");
			ComBtnDisable("btn_rowcopy2");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_delete2");
			ComBtnDisable("btn_delete3");
			ComBtnDisable("btn_save1");
			ComBtnDisable("btn_save2");
			ComBtnDisable("btn_save3");
			ComBtnDisable("btn_amend3");
			ComBtnDisable("btn_amendcancel3");
            ComBtnDisable("btn_accept3");
            ComBtnDisable("btn_acceptcancel3");
        	// Grid Button Setting
        	if (document.form.prc_prop_sts_cd.value == "I") {
        		if (bIsReqUsr || bIsAproUsr) {
                	ComBtnEnable("btn_rowadd1");
                	ComBtnEnable("btn_rowadd2");
                	ComBtnEnable("btn_rowadd3");
                	ComBtnEnable("btn_rowcopy1");
                	ComBtnEnable("btn_rowcopy2");
                	ComBtnEnable("btn_delete1");
                	ComBtnEnable("btn_delete2");
                	ComBtnEnable("btn_delete3");
                	ComBtnEnable("btn_save1");
                	ComBtnEnable("btn_save2");
                	ComBtnEnable("btn_save3");
                	ComBtnEnable("btn_amend3");
            		ComBtnEnable("btn_amendcancel3");
        		}
        	} else if (document.form.prc_prop_sts_cd.value == "Q") {
        		if (bIsAproUsr) {
        			ComBtnEnable("btn_save2");
                	ComBtnEnable("btn_save3");
    	        	ComBtnEnable("btn_accept3");
    	        	ComBtnEnable("btn_acceptcancel3");
        		}
        	} else if (document.form.prc_prop_sts_cd.value == "R") {
        		if (bIsAproUsr) {
		        	ComBtnEnable("btn_accept3");
		        	ComBtnEnable("btn_acceptcancel3");
        		}
        		if (bIsReqUsr) {
		        	ComBtnEnable("btn_accept3");
        		}
        	}
            break;
        case "READONLY":
        	ComBtnEnable("btn_retrieve");
        	ComBtnEnable("btn_acceptall");
        	ComBtnDisable("btn_cancel");
        	ComBtnDisable("btn_glcopy");
        	ComBtnDisable("btn_gricalc");
        	ComBtnEnable("btn_viewall");
        	ComBtnEnable("btn_downexcel");
        	ComBtnDisable("btn_loadexcel");
        	ComBtnDisable("btn_rowadd1");
        	ComBtnDisable("btn_rowadd2");
        	ComBtnDisable("btn_rowadd3");
        	ComBtnDisable("btn_rowcopy1");
        	ComBtnDisable("btn_rowcopy2");
        	ComBtnDisable("btn_delete1");
        	ComBtnDisable("btn_delete2");
        	ComBtnDisable("btn_delete3");
        	ComBtnDisable("btn_save1");
        	ComBtnDisable("btn_save2");
        	ComBtnDisable("btn_save3");
        	ComBtnDisable("btn_amend3");
        	ComBtnDisable("btn_amendcancel3");
            ComBtnDisable("btn_accept3");
            ComBtnDisable("btn_acceptcancel3");
//    		sheetObjects[12].ColHidden("buc_usd_amt") = true;
//    		sheetObjects[12].ColHidden("ifc_usd_amt") = true;
//    		sheetObjects[12].ColHidden("psc_usd_amt") = true;
//    		sheetObjects[13].ColHidden("buc_dry20") = true;
//    		sheetObjects[13].ColHidden("buc_dry40") = true;
//    		sheetObjects[13].ColHidden("buc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("buc_dry45") = true;
//    		sheetObjects[13].ColHidden("buc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("buc_rd40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_dry20") = true;
//    		sheetObjects[13].ColHidden("ifc_dry40") = true;
//    		sheetObjects[13].ColHidden("ifc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_dry45") = true;
//    		sheetObjects[13].ColHidden("ifc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("ifc_rd40hc") = true;
//    		sheetObjects[13].ColHidden("psc_dry20") = true;
//    		sheetObjects[13].ColHidden("psc_dry40") = true;
//    		sheetObjects[13].ColHidden("psc_dry40hc") = true;
//    		sheetObjects[13].ColHidden("psc_dry45") = true;
//    		sheetObjects[13].ColHidden("psc_rf40hc") = true;
//    		sheetObjects[13].ColHidden("psc_rd40hc") = true;
            break;
        }
//        onCickRdoPRSCostLevel();
    }
	/**
	 * Calling function from main when loading screen in tab.Setting default value and retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
        var formObject=document.form;
		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
			formObject.prc_prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
        	formObject.prop_no.value=sPropNo;
        	formObject.amdt_seq.value=sAmdtSeq;
            formObject.svc_scp_cd.value=sSvcScpCd;
            formObject.pre_amdt_seq.value=sPreAmdtSeq;
            formObject.prc_prop_sts_cd.value=sPropStsCd;
            formObject.eff_dt.value=sEffDt;
            formObject.exp_dt.value=sExpDt;
            formObject.pre_exp_dt.value=sPreExpDt;
            formObject.is_req_usr.value=sIsReqUsr;
            formObject.is_apro_usr.value=sIsAproUsr;
            formObject.dur_dup_flg.value=sDurDupFlg;
            formObject.lgcy_if_flg.value=sLgcyIfFlg;
            bIsReqUsr=sIsReqUsr;
            bIsAproUsr=sIsAproUsr;
            askOnce=true;
            if (formObject.amdt_seq.value == "0") {
            	hiddenButton("btn_amend3");
            	hiddenButton("btn_amendcancel3");
            } else {
            	showButton("btn_amend3");
            	showButton("btn_amendcancel3");
            }
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);
            // Actual customer : if Customer Type is N or A, Actual Customer Type Enable
            var sCustType=parent.comboObjects[2].GetSelectCode();
            if (sCustType == "N"||sCustType == "A") {
            	sheetObjects[0].SetColEditable("cust_lgl_eng_nm", true);
            } else {
            	sheetObjects[0].SetColEditable("cust_lgl_eng_nm", false);
            }
            // O.Via Mandatory
            if (isOViaMandatory) {
            	sheetObjects[1].SetColProperty(0, "org_rout_via_port_def_cd", {KeyField:1});
            } else {
            	sheetObjects[1].SetColProperty(0, "org_rout_via_port_def_cd", {KeyField:0});
            }
            // D.Via Mandatory
            if (isDViaMandatory) {
            	sheetObjects[1].SetColProperty(0, "dest_rout_via_port_def_cd", {KeyField:1});
            } else {
            	sheetObjects[1].SetColProperty(0, "dest_rout_via_port_def_cd", {KeyField:0});
            }
            // Direct Call Enable
            //if  Amend Sequence= 0, input checkbox , if amend sequence> 0 ,Amend by popup
            if (isDirCallVisible) {
            	sheetObjects[1].SetColHidden("dir_call_flg",0);
            	if (formObject.amdt_seq.value == "0") {
            		if (formObject.prc_prop_sts_cd.value == "I") {
            			sheetObjects[0].SetColEditable("dir_call_flg", true);
            		} else {
            			sheetObjects[0].SetColEditable("dir_call_flg", false);
            		}
                	sheetObjects[1].SetColHidden("dir_call_flg_pop",1);
            	} else {
            		sheetObjects[0].SetColEditable("dir_call_flg", false);
                	sheetObjects[1].SetColHidden("dir_call_flg_pop",0);
            	}
            } else {
            	sheetObjects[1].SetColHidden("dir_call_flg",1);
            	sheetObjects[1].SetColHidden("dir_call_flg_pop",1);
            }
            drawGenSpclRtTpCd();
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            if (enableFlag) {
                toggleButtons("INIT");
            } else {
                toggleButtons("READONLY");
            }
        }
    }
	/**
	 * Initializing all information of sheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function tabClearSheet() {
        var formObject=document.form;
    	formObject.prop_no.value="";
    	formObject.amdt_seq.value="";
        formObject.svc_scp_cd.value="";
        formObject.pre_amdt_seq.value="";
        formObject.prc_prop_sts_cd.value="";
        formObject.eff_dt.value="";
        formObject.exp_dt.value="";
        formObject.pre_exp_dt.value="";
        formObject.dur_dup_flg.value="";
        formObject.cmdt_hdr_seq.value="";
        formObject.rout_seq.value="";
        bIsReqUsr=false;
        bIsAproUsr=false;
        for (var i=0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
        origin_desc.innerHTML="";
        ovia_desc.innerHTML="";
        dvia_desc.innerHTML="";
        dest_desc.innerHTML="";
        askOnce=true;
        toggleButtons("CLEAR");
    }
    var enableFlag=true;
	/**
	 * controling Sheet object and other control<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function tabEnableSheet(flag) {
        var formObject=document.form;
        enableFlag=flag;
        sheetObjects[0].SetEditable(flag);
        sheetObjects[1].SetEditable(flag);
        sheetObjects[2].SetEditable(flag);
        if (enableFlag) {
            toggleButtons("INIT");
        } else {
            toggleButtons("READONLY");
        }
    }
	/**
	 * Checking whether CMDT Group's row is deleted by Row Status("D") Or CellFontStrike
	 * 
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function isCMDTGroupDeleted(row) {
    	if (row == null  || row == "" || row == undefined) {
    		row=sheetObjects[0].GetSelectRow();
    	}
    	return (sheetObjects[0].GetRowStatus(row) == "D" || sheetObjects[0].GetCellFontStrike(row, "prc_cmdt_def_nm") == 1);
    }
    
	/**
	 * Checking whether CMDT Group's row is deleted by Row Validity in Amended contract
	 * 
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function isCmdtGroupDeleted4Route(showMsg, routCmdtHdr) {
    	if (showMsg == null  || showMsg == "" || showMsg == undefined) {
    		showMsg=false;
    	}
    	if(getAmendValidRowCountCond(sheetObjects[3], "cmdt_hdr_seq", routCmdtHdr, document.form.amdt_seq.value) <= 0){
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "Commodity Group");
    		}
    		return true;
    	}
    	return false;
    }
	/**
	 *  Checking whether Route Group's row is deleted.
	 * 
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function isRouteGroupDeleted(row) {
    	if (row == null  || row == "" || row == undefined) {
    		row=sheetObjects[1].GetSelectRow();
    	}
    	return (sheetObjects[1].GetRowStatus(row) == "D" || sheetObjects[1].GetCellFontStrike(row, "org_rout_pnt_loc_def_cd") || sheetObjects[1].GetCellFontStrike(row, "dest_rout_pnt_loc_def_cd"));
    }
	/**
	 * Checking whether Route Group's row is deleted.
	 * 
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function isRouteGroupDeleted4Rate(showMsg) {
    	if (showMsg == null  || showMsg == "" || showMsg == undefined) {
    		showMsg=false;
    	}
    	if (getAmendValidRowCount(sheetObjects[6], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "Origin");
    		}
    		return true;
    	}
    	if (isOViaMandatory && getAmendValidRowCount(sheetObjects[7], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "O.Via");
    		}
    		return true;
    	}
    	if (isDViaMandatory && getAmendValidRowCount(sheetObjects[8], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "D.Via");
    		}
    		return true;
    	}
    	if (getAmendValidRowCount(sheetObjects[9], document.form.amdt_seq.value) <= 0) {
    		if (showMsg) {
    			ComShowCodeMessage("PRI00316", "Dest.");
    		}
    		return true;
    	}
    	return false;
    }
    var oPopup=null;
    var calcStatusStr="Nothing";
    var timeID="";
    var PRE_STATUS="";
	/**
	 * creatiing text div in case of mouse over on calculate button <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {object} x Mandatory
	 * @param {object} y Mandatory
	 * @param {object} width Mandatory
	 * @param {object} height Mandatory,
	 * @param {object} parentObj Mandatory, parent Object
	 * @return object, div object
	 * @author 
	 * @version 2009.10.01
	 */    
    function openDynamicPopup(x,y,width,height,parentObj){
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
    
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.ReNumberSeq();
    }
    function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.ReNumberSeq();
    }
    function sheet3_OnSaveEnd(sheetObj, ErrMsg)  {
    	sheetObj.ReNumberSeq();
    }
    
    /*
     * return true/false about the existence of saved Row
     * @return boolean
     */
    function existsDataForUploadExcel(){
    	var result = false;
    	
    	//Commodity Group
    	var cmdtCnt = getCountSavedRows(sheetObjects[0]);
    	//Rout Group
    	var routCnt = getCountSavedRows(sheetObjects[1]);
    	//RT Group
    	var rtCnt   = getCountSavedRows(sheetObjects[2]);
    	var iCnt = cmdtCnt + routCnt + rtCnt;
    	if(iCnt > 0){
    		result = true;
    	}
    	
    	
    	return result;
    }
    /* return the number of saved Row Count
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @return int
     */
    function getCountSavedRows(sheetObj){
    	var result = 0;
    	
    	var savedRowCnt = getValidRowCount(sheetObj);
    	var addRowCnt = getValidRowCountCond(sheetObj, "ibflag", "I");
    	if(savedRowCnt > 0){
    		result = savedRowCnt - addRowCnt;
    	}
    	
    	return result;
    }
