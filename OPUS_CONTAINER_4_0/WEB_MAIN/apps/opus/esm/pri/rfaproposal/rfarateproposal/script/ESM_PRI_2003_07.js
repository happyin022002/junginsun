/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_07.js
*@FileTitle  : RFA Proposal Creation - Rate 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================
*/
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
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
    // Flag to ignore OnClick event in case of not finishing loading Sheet2(Route Group Grid)
    var LoadingComplete=false;
    // Flag for requester 
    var bIsReqUsr=false;
    // Flag for approver
    var bIsAproUsr=false;
    // Variable to save a count of approved current rate
    var acptCnt=null;
    //  Variable to save a count of not approved current rate 
    var notAcptCnt=null;
    //Whether Origin Via.is Mandatory
    var isOViaMandatory=false;
    //Whether Dest. Via.媛�Mandatory
    var isDViaMandatory=false;
    // Variable to save current row and key value of sheet 1,2,3 when re-loading screen ==> s1:Sheet1, s2:Sheet2, s3:Sheet3
    var s1PrevRow=-1;
    var s2PrevRow=-1;
    var s3PrevRow=-1;
    var s1PrevKey=null;
    var s2PrevKey=null;
    var s3PrevKey=null;
    // Code value to save to Main's Summary table
    var TERMS_TYPE_CODE_GEN=71;
    var unusedRatUtCd="|20|40|CT|DF|DW|HC|UN";
    // Saving action to activate groupGroup on popup in case of deleted row
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
	            		var sParam=FormQueryString(formObject) + "&n_acpt_cnt=" + notAcptCnt;
//	            		ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2036.do?" + sParam, "ESM_PRI_2036", 1000, 645, false);
	            		ComOpenPopup("ESM_PRI_2036.do?" + sParam, 1100, 645, "", "none", false);    
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
						ComOpenPopup("ESM_PRI_2033.do?" + FormQueryString(formObject), 1100, 600, "", "1,0", false);    
					}
	                break;
	            case "btn_checkduplicate":
	            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
	            		var sParam=FormQueryString(formObject);
	            		ComOpenPopup("ESM_PRI_2034.do?" + sParam, 1000, 443, "", "none", false);    
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
	                					ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2065.do?" + FormQueryString(formObject), "ESM_PRI_2065", 950, 563, false);
	                				}
	                			},
	                			{
	                				text: "Horizontal",
	                				click: function() {
	                					$(this).dialog("close");
	                					var sCustType=parent.getCustTpCd();
	                		    		var sParam=FormQueryString(formObject) + "&s_prc_ctrt_cust_tp_cd=" + sCustType;
	                					ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2060.do?" + sParam, "ESM_PRI_2060", 950, 563, false);
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
	            case "btn_specification":
	            	if (!checkCmdtEditable() || sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "prc_cgo_tp_cd") != "AK") {
	            		return false;
	            	}
	            	ComOpenPopup("ESM_PRI_2047.do?" + FormQueryString(formObject) + "&rt_seq=" + sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "rt_seq"), 700, 400, "", "none", true);    
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
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        resizeSheet();
        initControl();
        toggleButtons("CLEAR");
        parent.loadTabPage();
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
        case "sheet1":  // CMDT Group(screen)
            with(sheetObj){
        	var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_ctnt_tooltip|Not Deleted Rows|Not Accepted Rows|Accepted Rows|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:75,  Align:"Center",  ColMerge:0,   SaveName:"blet_dp_seq",             KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_tooltip",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ac_cnt",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"org_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetEllipsis(1);
		          SetShowButtonImage(2);
		          SetSelectionMode(1); //0:CELL, 1:ROW
		          SetAutoRowHeight(0);
		          SetSheetHeight(142);
		          }
            break;
            
        case "sheet2":  // Route Group(screen)
            with(sheetObj){
        	     var HeadTitle = "|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Seq.|Origin|Origin Via|Destination Via|Destination|Route Note|Note Tooltip|Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq|org_n1st_cmnc_amdt_seq";
		         var headCount=ComCountHeadTitle(HeadTitle);
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:100, DataRowMerge:1 } );
		         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rn",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Popup",     Hidden:0, Width:205,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:205,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:205,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:205,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Popup",     Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_tooltip",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"org_n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetEllipsis(1);
		         SetShowButtonImage(2);
		         SetAutoRowHeight(0);
		         SetSheetHeight(142);
		       }
            break;
            
        case "sheet3":  // Rate
            with(sheetObj){
		          var HeadTitle="|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|GRI|GRI|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, FrozenCol:15, MergeSheet:5, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",          KeyField:1,   CalcLogic:"",   Format:"Float",   	  PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                 {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                 {Type:"Float",     Hidden:0,  Width:120,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
		                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"next_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetEllipsis(1);
		          //2014.09.11 update
		          SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue, DefaultValue:"D2"} );
		          SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCddValue, DefaultValue:"DR"} );
		          
		          SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		          SetShowButtonImage(2);
		          FrozenCols=15;
		          resizeSheet(); //SetSheetHeight(142);
          		}
            break;
            
        case "sheet4":  // Grid 1: Commodity(Hidden)
            with(sheetObj){
		          var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet5":  // Grid 1: Actual Customer(Hidden)
            with(sheetObj){
		          var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet6":  // Grid 1: Commodity Note(Hidden)
            with(sheetObj){
		          var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
            
        case "sheet7":  // Grid 2: Origin Point(Hidden)
            with(sheetObj){
		          var HeadTitle="7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet8":  // Grid 2: Origin Via.(Hidden)
            with(sheetObj){
		          var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet9":  // Grid 2: Destination Via.(Hidden)
            with(sheetObj){
		          var HeadTitle="9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet10":  // Grid 2: Destination Point(Hidden)
            with(sheetObj){
		          var HeadTitle="10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
            
        case "sheet11":  // Grid 2: Direct Call(Hidden)
            with(sheetObj){
		          var HeadTitle="status";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetVisible(0);
		          SetSheetHeight(100);
                }
            break;
            
        case "sheet12":  // Grid 2: Rnote(Hidden)
            with(sheetObj){
		          var HeadTitle="12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:100, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
            
        case "sheet13": // Excel Download Sheet(Vertical)
            with(sheetObj){
		          var HeadTitle1="CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)";
		          var HeadTitle2="CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Rate";
		          var headCount=ComCountHeadTitle(HeadTitle2);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:100, DataRowMerge:0 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_dp_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rout_dp_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",            KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(300);
                }
            break;
            
        case "sheet14": // Excel Download Sheet(Horizontal)
        	with(sheetObj){
            
	          var HeadTitle1="Type|CMDT\nSeq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Route\nSeq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)";
	          var HeadTitle2="Type|CMDT\nSeq.|Code|Description|Code|Description|Route\nSeq.|Code|Description|Term|Transmode|Code| Code|Code|Description|Term|Transmode|Prefix|CGO TYPE|20|40|40HC|45";
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:100, DataRowMerge:0 } );
	
	          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle1, Align:"Center"},
	                      { Text:HeadTitle2, Align:"Center"} ];
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
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prefix_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_20",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_40hc",                  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_45",                    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 }];
	           
	          InitColumns(cols);		
	          SetEditable(1);
	          SetSheetHeight(300);
          	}
            break;
            
        case "sheet15": // Commodity Note Conversion(Hidden)
            with(sheetObj){
		         var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
		         "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
		         "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
		         var headCount=ComCountHeadTitle(HeadTitle);
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:100, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(130);
                  }
            break;
            
        case "sheet16": // Route Note Conversion(Hidden)
            with(sheetObj){
		         var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +
		         "|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +
		         "|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25";
		         var headCount=ComCountHeadTitle(HeadTitle);
		         SetConfig( { SearchMode:2, MergeSheet:5, Page:100, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cnl_tz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bkg_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_por_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pol_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_pod_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_del_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_cnt_cd" } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(130);
                  }
            break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[2]);
    }
    
	/**
	 * Calling Function in case of OnBeforeEdit event <br>
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * Sheet is the Rate Info
	 * set Sheet's Cell Property
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2014.09.12
	 */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == ""){
        	setSheet3Style(sheetObj, -1);
        }
    }
    
	/**
	 * Calling Function in case of OnBeforeEdit event <br>
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Blocking to modify CMDT group, in case of modifying Route Group
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
	 * Checking : all checking sub-grid  Uncheck:release main'grid.
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
	 * Checking : all checking sub-grid  Uncheck:release main'grid.
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
	 * Checking : all checking sub-grid  Uncheck:release main'grid.
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
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        // Checking rating unit's status when changing Cargo type
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
        // Settting cargo type as default when changing Rating Unit
        if (colName == "rat_ut_cd") {
        	var validPerClass="A,F,O,Q,S,P";
        	var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","DR")
            } else if (perClass == "R") {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","RF")
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","AK")
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
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
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
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Summarizing accepted data count and un-accepted data count
	 * In case of S/C,Retrieving count when getting General/Special Type information
	 * In case of RFA, using this way
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	if (sheetObj.RowCount()> 0) {
	        	notAcptCnt=sheetObj.ComputeSum("|13|");
	        	acptCnt=sheetObj.ComputeSum("|14|");
        	}
        	toggleButtons("INIT");
        	
        	//2014.09.16 1416 �댁쟾�먮뒗 議고쉶��SelectCell�대깽�멸� �몄텧�섏뿀�쇰굹 �댁젣 �덈릺��議고쉶 ��媛뺤젣�몄텧��
        	doRowChange2(0, 1, sheetObj.LastCol()+1 , sheetObj.LastCol()+1);
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * Combining string to be displayed at location detail information box on Route Group Grid.
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
            	if ((sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != "") || (sheetObj.GetCellValue(i, "loc_grd_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cd") != "")) {
            		sStr += "(" + sheetObj.GetCellValue(i, "loc_grd_cnt_cd") + sheetObj.GetCellValue(i, "loc_grd_cd") + ")";
                }
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
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
	 * Combining string to be displayed at location detail information box on Route Group Grid.. Origin Via.
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
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
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
	 * Combining string to be displayed at location detail information box on Route Group Grid.. Dest. Via.
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
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
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
	 * Combining string to be displayed at location detail information box on Route Group Grid. Dest. Point
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
            	if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value && sheetObj.GetCellValue(i + 1, "src_info_cd") == "AD") {
                	continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermDest[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
            	if ((sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cnt_cd") != "") || (sheetObj.GetCellValue(i, "loc_grd_cd") != null && sheetObj.GetCellValue(i, "loc_grd_cd") != "")) {
            		sStr += "(" + sheetObj.GetCellValue(i, "loc_grd_cnt_cd") + sheetObj.GetCellValue(i, "loc_grd_cd") + ")";
                }
            	if (document.form.amdt_seq.value != "0") {
            		if (sheetObj.GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value || sheetObj.GetCellValue(i, "src_info_cd") == "AD") {
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
	 * downloading excel file in case of loading data to Sheet13(Excel Download)
	 * In case of over 300 retrieved row, using speed option due to performance issue
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {code} result code, if it is smaller than 0, it will be error
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet13_OnSearchEnd(sheetObj, code, ErrMsg) {
        if (code == 0) {
        	sheetObj.Down2Excel({KeyFieldMark:0, SheetDesign:1, Merge:1});
        	sheetObj.RemoveAll();
        }
    }
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * downloading excel file in case of loading data to Sheet14(Excel Download)
	 * In case of over 200 retrieved row, using speed option due to performance issue
	 *
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {code} result code, if it is smaller than 0, it will be error
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet14_OnSearchEnd(sheetObj, code, ErrMsg) {
    	if (code == 0) {
    		sheetObj.Down2Excel({KeyFieldMark:0, SheetDesign:1, Merge:1});
        	sheetObj.RemoveAll();
        }
    }
	/**
	 * Calling Function in case of OnPopupClick event <br>
	 * Update the result of modification on popup screen to sheet1<br>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    var popupRow = 0;
    var colValue="";
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        popupRow = Row;
        colValue = colName;
        
        var formObj=document.form;
        formObj.f_cmd.value="";
        
        if (!checkCmdtEditable()) {
            return false;
        }
        if (colName == "prc_cmdt_def_nm") {
            var sUrl="ESM_PRI_2023.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 794, 300, "setReturnValue", "1,0,1,1,1,1,1", true);
        }
        if (colName == "cust_lgl_eng_nm") {
        	var sCustType=parent.getCustTpCd();
        	if (sCustType != "N") {
        		return false;
        	}
        	var sUrl="ESM_PRI_2082.do?" + FormQueryString(document.form);
        	 ComOpenPopup(sUrl, 700, 269, "setReturnValue", "1,0,1,1,1,1,1", true);
        }
        if (colName == "note_ctnt") {
        	var sUrl="ESM_PRI_2022.do?" + FormQueryString(document.form) + "&select_row=" + sheetObjects[0].GetSelectRow();
        	ComOpenPopup(sUrl, 900, 680, "setReturnValue", "0,1,1,1,1,1,1", false);
        	
        }
    }
    
    function setReturnValue(rtnVal) {
    	var formObj=document.form;
    	var sheetObj = sheetObjects[0];
    	
   	    if (rtnVal != null && rtnVal == "O") {
    		if(colValue == "prc_cmdt_def_nm") {
    			setSheet1RowData(sheet1, 3, popupRow, "prc_cmdt_def_nm");
    		}
    		if(colValue == "cust_lgl_eng_nm") {
    	        setSheet1RowData(sheet1, 4, popupRow, "cust_lgl_eng_nm");
    		}
    		if (colValue == "note_ctnt") {
            	for (var i=sheet1.HeaderRows(); i <= sheet1.LastRow(); i++) {
            		var sNoteCtnt="";
                	for (var j=sheetObjects[5].HeaderRows(); j <= sheetObjects[5].LastRow(); j++) {
                		if (sheetObjects[5].GetCellValue(j, "amdt_seq") != formObj.amdt_seq.value) {
                    		continue;
                    	}
                		if (sheetObjects[5].GetRowStatus(j) == "D") {
        	                continue;
        	            }
                		if (sheetObjects[5].GetCellValue(j, "cmdt_hdr_seq") == sheet1.GetCellValue(i, "cmdt_hdr_seq")) {
                			sNoteCtnt += sheetObjects[5].GetCellValue(j, "note_ctnt");
                			sheet1.SetCellValue(j, "note_ctnt",sNoteCtnt,0);
                        	sheet1.SetCellValue(j, "note_ctnt_tooltip",sNoteCtnt,0);
        	            }
                	}
                	var prevStatus=sheet1.GetRowStatus(popupRow);
                    setNoteTooltip(sheet1, popupRow);
                    sheet1.SetRowStatus(popupRow,prevStatus);
            	}
    			  
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
    var popupRow = 0;
    var popupCol = 0;
    var popupColName="";
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        if (!LoadingComplete) {
            return;
        }
        var colName=sheetObj.ColSaveName(Col);
        popupRow = Row;
        popupCol=Col;
        popupColName=colName;
        
        var formObj=document.form;
        // return if CMDT is changed
        if (!checkRouteEditable()) {
            return false;
        }
        var sUrl="ESM_PRI_2025.do?" + FormQueryString(document.form);
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 980, 324, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 980, 324, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 980, 324, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 980, 324, "sheet2_returnVal", "1,0", true);
        }
        if (colName == "note_ctnt") {
            sUrl="ESM_PRI_2024.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 580,  "sheet2_returnVal", "0,1,1,1,1,1,1", false);
        }
    }
    

    function sheet2_returnVal(rtnVal) {
    	 
    	 var sheetObj = sheetObjects[1];
    	 	
    	 if (rtnVal != null && rtnVal =="O") {
    		 if(popupColName == "org_rout_pnt_loc_def_cd" 
    			 || popupColName == "org_rout_via_port_def_cd"
    				 || popupColName == "dest_rout_via_port_def_cd"
    					 || popupColName == "dest_rout_pnt_loc_def_cd") {
    			 setSheet2RowData(sheet2, popupRow, popupCol);
    		 }
    		 if(popupColName == "note_ctnt") {
            	var prevStatus=sheetObj.GetRowStatus(popupRow);
                var sNoteCtnt="";
                for (var i=sheetObjects[11].HeaderRows(); i <= sheetObjects[11].LastRow(); i++) {
                	if (sheetObjects[11].GetCellValue(i, "amdt_seq") != document.form.amdt_seq.value) {
                		continue;
                	}
                	if (sheetObjects[11].GetRowStatus(i) == "D") {
                        continue;
                    }
                	sNoteCtnt += sheetObjects[11].GetCellValue(i, "note_ctnt");
                }
                sheet2.SetCellValue(popupRow, "note_ctnt", sNoteCtnt,0);
                sheet2.SetCellValue(popupRow, "note_ctnt_tooltip", sNoteCtnt,0);
                setNoteTooltip(sheet2, popupRow);
                sheet2.SetRowStatus(popupRow,prevStatus);
    		 } 
    		 
    	 }
    	 
    	 
    }
	/**
	 * Setting modified information on popup screen to Sheet1<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetIdx Mandatory Sheet No
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
        	if (sheetObjects[sheetIdx].GetCellValue(i, "prop_no") == formObj.prop_no.value && sheetObjects[sheetIdx].GetCellValue(i, "amdt_seq") == formObj.amdt_seq.value && sheetObjects[sheetIdx].GetCellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value && sheetObjects[sheetIdx].GetCellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
        		if (sheetObjects[sheetIdx].GetRowStatus(i) == "D") {
	                continue;
	            }
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
	 * Setting modified information on popup screen to Sheet2<br>
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
            if (sheetObjects[0].IsDataModified() || sheetObjects[3].IsDataModified() || sheetObjects[4].IsDataModified() || sheetObjects[5].IsDataModified()) {
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
            if (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified() || sheetObjects[9].IsDataModified()  || sheetObjects[10].IsDataModified() || sheetObjects[11].IsDataModified() || sheetObjects[15].IsDataModified()) {
            	// Set off event, rollbacking selected row to old row
                isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                	// Saving. Don't show Saving confirm message
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
	 * Handling events in case of changing row on sheet. <br>
	 * Refer to doRowChange1 function
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
        	if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified() || sheetObjects[9].IsDataModified() || sheetObjects[10].IsDataModified() || sheetObjects[11].IsDataModified() || sheetObjects[15].IsDataModified())) {
                isFiredNested=true;
                sheetObjects[1].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                
              //2014.09.15 13.42 delete below logic
              //  CoObject.js ComRowHideDelete function's setRowHidden fire OnSelectCell Event.
//                var rslt=false;
//                if (ComShowCodeConfirm("PRI00006")) {
//                    supressConfirm=true;
//                    adjNewRow = Math.max(NewRow - sheetObjects[1].RowCount("D"), sheetObjects[1].HeaderRows());
//                    rslt=doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
//                    supressConfirm=false;
//                }
//                if (rslt) {
//                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
//	                    isFiredNested=true;
//	                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
//	                    isFiredNested=false;
//                	}
//                } else {
//                    isFiredNested=true;
//                    sheetObjects[1].SelectCell(OldRow, OldCol, false);
//                    isFiredNested=false;
//                	return -1;
//                }
                
                
                //2014.09.15 13.42 ADD
                if (sAction != IBINSERT && sAction != IBCOPYROW) {
                    isFiredNested=true;
                    sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
                    isFiredNested=false;
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
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
            if(window.event == null || ComGetEvent() == null ) {
                ComOpenWait(true);
            }
	        sheetObj.ShowDebugMsg(false);
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
	        	reloadPagePostTr();
	            ComShowCodeMessage("PRI00109");
	            break;
	            
	        case IBSEARCH_ASYNC03: // Guideline Copy
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=SEARCH12;
	            var sParam=FormQueryString(formObj);
	            var cXml=sheetObj.GetSearchData("ESM_PRI_2003_07GS.do", sParam);
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
	            //  Saving selected row for retrieving 
	            saveCurRowPos();
	            formObj.f_cmd.value=MODIFY12;
	            var sParam=FormQueryString(formObj);
	            // Guideline Copy 
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
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
	        	// Setting color/Strike option to row after Amending
	        	var idx=doRowAmend(sheetObj, "AM");
				setSheet3Style(sheetObj, idx - 1);
				setSheet3Style(sheetObj, idx);
	        	// Items to be cleared when Amending
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
	        	// Setting color/Strike option to row after Amend Cancel 
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
	            // handing style after saving
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, {Sync:1});
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
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != null && sheetObj.GetCellValue(arrCheckedRows[i], "coffr_frt_rt_amt") != "") {
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
	            var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, {Sync:1});
	             // handing style after saving
	            restylingPagePostTr();
	            setSheet3Style(sheetObj, -1);
	            sheetObj.CheckAll("chk",0,1);
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 
	            var sXml="";  
	            isOViaMandatory=false;
	            isDViaMandatory=false;
				formObj.f_cmd.value=COMMAND17;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i=0; i < arrTemp.length; i++) {
						var pptCd=arrTemp[i][1];
						if (pptCd == "ROVA") {
							isOViaMandatory=true;
						} else if (pptCd == "RDVA") {
							isDViaMandatory=true;
						}
					}
				}
	            break;
	            
	        case IBSEARCH: // Retrieving
	            if (!validateForm(sheetObj, document.form, sAction)) {	            	
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH01;
	                
	                var sXml=sheetObj.GetSearchData("ESM_PRI_2003_07GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[4].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[5].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[14].LoadSearchData(arrXml[4],{Sync:1} );
	            } else if (sheetObj.id == "sheet2") {
	            	if(cmdtDeltChkFlg){
	            		var ndCnt = 0;
		            	formObj.f_cmd.value=SEARCH02;
	                	var sXml=sheetObj.GetSearchData("ESM_PRI_2003_07GS.do" , FormQueryString(formObj));
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
		                    if (i == 3 || i == 4 || i == 5 || i == 14) {
		                        continue;
		                    }
		                    sheetObjects[i].RemoveAll();
		                }
		                origin_desc.innerHTML="";
		                ovia_desc.innerHTML="";
		                dvia_desc.innerHTML="";
		                dest_desc.innerHTML="";
		                formObj.f_cmd.value=SEARCH02;
		                
		                sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "blet_dp_seq") );
	            	}
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                	if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_2003_07GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[6].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[7].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[8].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[9].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[11].LoadSearchData(arrXml[5],{Sync:1} );
	                if (arrXml.length > 6) sheetObjects[15].LoadSearchData(arrXml[6],{Sync:1} );
	                
	                //2014.09.11 move below function in sheet3_OnSearchEnd
	                //setSheet3Style(sheetObj, -1);
	            }
	            break;
	            
	        case IBSAVE: // Saving
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
	        		if (sheetObjects[1].RowCount()> 0 && !isRouteGroupDeleted()) {
	    				var iCntOri = getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value);
	    				var iCntOVia = getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value);
	    				var iCntDVia = getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value);
	    				var iCntDest = getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value);
	    				if (iCntOri <= 0 && iCntOVia <= 0 && iCntDVia <= 0 && iCntDest <= 0) {
	    					if (ComShowCodeConfirm("PRI00350")) {
	    						return;
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
	            	if (!validateBulletNo(sheetObj,document.form,sAction)) {
	            		return false;
	            	}
	            	// changing to GM,PM in case that Source with GC,PC is modified
	            	for (var a=3; a <= 5; a++) {
	            		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
	                		// if src_info_cd= GC(Guideline Copy), GM(Guideline Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Guideline (M)");
	                		}
	                		// if src_info_cd= PC(Previous Contract),, PM(Previous Contract Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Prev. RFA (M)");
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
	                var sParamSheet15=sheetObjects[14].GetSaveString();
	                if (sParamSheet15 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet15, "sheet15_");
	                }
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	                saveCurRowPos();
	                isFiredNested=true;
	                var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
	                sheetObjects[14].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[5].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[4].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[3].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[0].LoadSaveData(sXml, {Sync:1});
	                isFiredNested=false;
	                if (sheetObjects[0].IsDataModified()|| sheetObjects[3].IsDataModified()|| sheetObjects[4].IsDataModified() || sheetObjects[5].IsDataModified() || sheetObjects[14].IsDataModified()) {
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
	            			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Guideline (M)");
	                		}
	                		// if Proposal &  src_info_cd = PC(Previous Contract),  PM(Previous Contract Modification)
	            			if (sheetObjects[a].GetRowStatus(i) == "U" && sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
	                			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
	                			sheetObjects[a].SetCellValue(i, "src_info_nm","Prev. RFA (M)");
	                		}
	            		}
	            	}
	            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            		// if C/Offer amount is inputed, Changing prc_prog_sts_cd to Returned
	            		if (sheetObj.GetRowStatus(i) == "U" && bIsAproUsr && formObj.prc_prop_sts_cd.value == "Q" && sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "I" && sheetObj.GetCellValue(i, "coffr_frt_rt_amt") != null && sheetObj.GetCellValue(i, "coffr_frt_rt_amt") != "") {
	            			sheetObj.SetCellValue(i, "prc_prog_sts_cd","R");
	            			sheetObj.SetCellValue(i, "prc_prog_sts_nm","Returned");
	            		}
	            		// if C/Offer amount is cleared, Changing prc_prog_sts_cd to Initial
	            		if (sheetObj.GetRowStatus(i) == "U" && bIsAproUsr && formObj.prc_prop_sts_cd.value == "Q" && sheetObj.GetCellValue(i, "prc_prog_sts_cd") == "R"	&& (sheetObj.GetCellValue(i, "coffr_frt_rt_amt") == null || sheetObj.GetCellValue(i, "coffr_frt_rt_amt") == "")) {
		        			sheetObj.SetCellValue(i, "prc_prog_sts_cd","I");
		        			sheetObj.SetCellValue(i, "prc_prog_sts_nm","Initial");
		        		}
	            		// In case of modifying rated with GRI Calc.,Changing A to M
	            		if (sheetObj.GetRowStatus(i) == "U" && sheetObj.GetCellValue(i, "gri_appl_tp_cd") == "A") {
	            			sheetObj.SetCellValue(i, "gri_appl_tp_cd","M");
	            		}
	            	}
	                formObj.f_cmd.value=MULTI02;
	                var sParam=FormQueryString(formObj);
	                var sParamSheet2=sheetObjects[1].GetSaveString();
	                if (sParamSheet2 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
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
	                var sParamSheet12=sheetObjects[11].GetSaveString();
	                if (sParamSheet12 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet12, "sheet12_");
	                }
	                var sParamSheet16=sheetObjects[15].GetSaveString();
	                if (sParamSheet16 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet16, "sheet16_");
	                }
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	                saveCurRowPos();
	                var sXml=sheetObj.GetSaveData("ESM_PRI_2003_07GS.do", sParam);
	                sheetObjects[15].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[11].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[9].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[8].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[7].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[6].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[2].LoadSaveData(sXml, {Sync:1});
	                sheetObjects[1].LoadSaveData(sXml, {Sync:1});
	                if (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified() || sheetObjects[9].IsDataModified() || sheetObjects[11].IsDataModified() || sheetObjects[15].IsDataModified()) {
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
	                    return true;
	                }
	            }
	            return true;
	            break;
	        case IBDOWNEXCEL:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI01007');
	                return false;
	            }
	            if (sheetObj.id == "sheet13") {
	                formObj.f_cmd.value=SEARCH10;
	                sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj) );
	            } else if (sheetObj.id == "sheet14") {
	                formObj.f_cmd.value=SEARCH11;
	                sheetObj.DoSearch("ESM_PRI_2003_07GS.do", FormQueryString(formObj) );
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
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1);
	                sheetObj.SetCellValue(idx, "blet_dp_seq",getNextBletDpSeq());
	                sheetObj.SetCellValue(idx, "nd_cnt",1);
	                sheetObj.SetCellValue(idx, "na_cnt",1);
	                for (var i=1; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                sheet1_OnPopupClick(sheetObj, idx, 8);
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
	                	arrRn[1]=parseInt(arrRn[1]) + 1;
	                	rn=arrRn.join(".");
	                }
	                sheetObj.SetCellValue(idx, "rn",rn);
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq"));
	                sheetObj.SetCellValue(idx, "rout_seq",parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1);
	                sheetObj.SetCellValue(idx, "nd_cnt",1);
	                sheetObj.SetCellValue(idx, "na_cnt",1);
	                for (var i=2; i < sheetObjects.length; i++) {
	                    if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                origin_desc.innerHTML="";
	                ovia_desc.innerHTML="";
	                dvia_desc.innerHTML="";
	                dest_desc.innerHTML="";
	                sheet2_OnPopupClick(sheetObj, idx, 8);
	            }
	            if (sheetObj.id == "sheet3") {
	                var idx=sheetObj.DataInsert();
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
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
	                setSheet3Style(sheetObj, idx);
	                //[NYK REQ : 2014.12.11 Default Value] start
	                sheetObj.SetCellValue(idx, "rat_ut_cd","D4");
	                sheetObj.SetCellValue(idx, "prc_cgo_tp_cd","DR");
	                sheetObj.SetCellValue(idx, "curr_cd","USD");
	                //[NYK REQ : 2014.12.11 Default Value] end
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
	                sheetObj.SetCellValue(idx, "blet_dp_seq",getNextBletDpSeq());
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
	                        // Numbering new note_conv_mapg_id
	                        formObj.f_cmd.value=COMMAND38;
	                        var sXml=sheetObjects[5].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	                        var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	                        sheetObjects[5].SetCellValue(insIdx, "note_conv_mapg_id",sysGuid);
	                        // Copying Conversion together
	                        for (var j=sheetObjects[14].LastRow(); j >= sheetObjects[14].HeaderRows(); j--) {
	                        	if (sheetObjects[14].GetCellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
	                                sheetObjects[14].SelectCell(j, 0);
	                                var convIdx=sheetObjects[14].DataCopy();
	                                sheetObjects[14].SetCellValue(convIdx, "note_conv_mapg_id",sysGuid);
	                                sheetObjects[14].SetCellValue(convIdx, "eff_dt",formObj.eff_dt.value);
	                                sheetObjects[14].SetCellValue(convIdx, "exp_dt",formObj.exp_dt.value);
	                        	}
	                        }
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
	                    if (i == 3 || i == 4 || i == 5 || i == 14) {
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
	                	arrRn[1]=parseInt(arrRn[1]) + 1;
	                	rn=arrRn.join(".");
	                }
	                sheetObj.SetCellValue(idx, "rn",rn);
	                sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	                var newRoutSeq=parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                sheetObj.SetCellValue(idx, "rout_seq",newRoutSeq);
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                formObj.f_cmd.value=COMMAND38;
	                var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	                var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	                var prevNoteConvMapgId="";
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
	                            prevNoteConvMapgId=sheetObjects[a].GetCellValue(i, "note_conv_mapg_id");
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
	                // Route Note Conversion
	                for (var i=sheetObjects[15].LastRow(); i >= sheetObjects[15].HeaderRows()&& sheetObjects[15].RowCount()> 0; i--) {
	                	if (sheetObjects[15].GetCellValue(i, "note_conv_mapg_id") == prevNoteConvMapgId) {
	                    	sheetObjects[15].SetCellValue(i, "note_conv_mapg_id",sysGuid);
	                        sheetObjects[15].SetCellValue(i, "eff_dt",formObj.eff_dt.value);
	                        sheetObjects[15].SetCellValue(i, "exp_dt",formObj.exp_dt.value);
	                    	sheetObjects[15].SetRowStatus(i,"I");
	                	} else {
	                		sheetObjects[15].RowDelete(i, false);
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
        	        	var convIdx;
                		if (a == 5) {
                			convIdx=14;
                		} else if (a == 11) {
                			convIdx=15;
                		} else {
                			convIdx=-1;
                		}
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
		                			var newNoteConvMapgId="";
		                			var prevNoteConvMapgId="";
		                        	if (a == 5 || a == 11) {
		                        		newNoteConvMapgId=sheetObjects[a].GetCellValue(sheetObjects[a].GetSelectRow(), "note_conv_mapg_id");
		                        		prevNoteConvMapgId=sheetObjects[a].GetCellValue(sheetObjects[a].GetSelectRow()- 1, "note_conv_mapg_id");
		                        	}
		                        	// Amend Cancel
		                        	var prevIdx=doRowAmendCancel(sheetObjects[a]);
		                        	if (a == 2) {
		                        		setSheet3Style(sheetObjects[a], prevIdx);
		                        	}
		                        	if (a == 5 || a == 11) {
		                        		sheetObjects[a].SetCellValue(prevIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
		                	        	for (var j=sheetObjects[convIdx].LastRow(); sheetObjects[convIdx].RowCount()> 0 && j >= sheetObjects[convIdx].HeaderRows(); j--) {
		                	        		if (sheetObjects[convIdx].GetRowStatus(j) == "D") {
		                	        			continue;
		                	        		}
		                	        		if (sheetObjects[convIdx].GetCellValue(j, "note_conv_mapg_id") == newNoteConvMapgId) {
		                	        			sheetObjects[convIdx].RowDelete(j, false);
		                	        		}
		                	        	}
		                	        	for (var j=sheetObjects[convIdx].LastRow(); sheetObjects[convIdx].RowCount()> 0 && j >= sheetObjects[convIdx].HeaderRows(); j--) {
		                	        		if (sheetObjects[convIdx].GetRowStatus(j) == "D") {
		                	        			continue;
		                	        		}
		                	        		if (sheetObjects[convIdx].GetCellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
		                	        			//sheetObjects[convIdx].SelectCell(j, 0);
		                	        			//var copiedIdx=sheetObjects[convIdx].DataCopy();
		                	        			var rowJson = sheetObjects[convIdx].GetRowJson(j);
		                	        			var copiedIdx = sheetObjects[convIdx].DataInsert(-1);
		                	        			sheetObjects[convIdx].SetRowJson(copiedIdx, rowJson);
		                	        			
		                	        			sheetObjects[convIdx].SetCellValue(copiedIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
		                	        			sheetObjects[convIdx].SetCellValue(copiedIdx, "amdt_seq",formObj.amdt_seq.value,0);
		                	        			if (sheetObjects[convIdx].GetCellValue(copiedIdx, "exp_dt") == formObj.pre_exp_dt.value) {
		                	        				sheetObjects[convIdx].SetCellValue(copiedIdx, "exp_dt",formObj.exp_dt.value,0);
		                	        			}
		                	        		}
		                	        	}
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
	                       		var idx=doRowAmend(sheetObjects[a], "AD");
	                       		if (a == 2) {
	                    			setSheet3Style(sheetObjects[a], idx - 1);
	                    			setSheet3Style(sheetObjects[a], idx);
	                       		}
	                       		// deleting conversion in case of CMDT & Route Note
	                       		if (a == 5 || a == 11) {
	                       			sheetObjects[a].SetCellValue(idx - 1, "note_conv_mapg_id",sheetObjects[a].GetCellValue(idx, "prev_note_conv_mapg_id"),0);
	                       			sheetObjects[a].SetRowStatus(idx - 1,"R");
	                       			for (var j=sheetObjects[convIdx].LastRow(); sheetObjects[convIdx].RowCount()> 0 && j >= sheetObjects[convIdx].HeaderRows(); j--) {
	                       				if (sheetObjects[convIdx].GetRowStatus(j) == "D") {
	            	            			continue;
	            	            		}
	                       				if (sheetObjects[convIdx].GetCellValue(j, "note_conv_mapg_id") == sheetObjects[a].GetCellValue(idx, "note_conv_mapg_id")) {
			    	            			sheetObjects[convIdx].RowDelete(j, false);
			    	            		}
			    	            	}
	                       		}
	                       		// Changing Route Group'data to R as rowstatus
	                       		// Doing not happen modification of CMDT Group and Route Group simultaneously 
	                       		if (a != 3 && a != 4 && a != 5) {
		                			sheetObjects[a].SetRowStatus(idx - 1,"R");
		                			sheetObjects[a].SetRowStatus(idx,"R");
	                       		}
	                       	// Row Delete
	                		} else if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && (sheetObjects[a].GetCellValue(i, "src_info_cd") == "NW" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "GM" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "PM")) {
	                    		// In case of CMDT & Route Note
	                    		if (a == 5) {
			    	            	for (var j=sheetObjects[14].LastRow(); sheetObjects[14].RowCount()> 0 && j >= sheetObjects[14].HeaderRows(); j--) {
			    	            		if (sheetObjects[14].GetCellValue(j, "note_conv_mapg_id") == sheetObjects[5].GetCellValue(i, "note_conv_mapg_id")) {
			    	            			sheetObjects[14].RowDelete(j, false);
			    	            		}
			    	            	}
	                    		}
	                       		if (a == 11) {
			    	            	for (var j=sheetObjects[15].LastRow(); sheetObjects[15].RowCount()> 0 && j >= sheetObjects[15].HeaderRows(); j--) {
			    	            		if (sheetObjects[15].GetCellValue(j, "note_conv_mapg_id") == sheetObjects[a].GetCellValue(i, "note_conv_mapg_id")) {
			    	            			sheetObjects[15].RowDelete(j, false);
			    	            		}
			    	            	}
	                       		}
	    	                    sheetObjects[a].RowDelete(i, false);
	                    	}
	                	}
	        		}
	        		// Deleting Sheet2
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
	        		// Deleting Sheet1
	            	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	            		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            			sheetObj.SetCellValue(arrCheckedRows[i], "chk",0,0);
	            			setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
	            		}
	            	}
	            	deleteRowCheck(sheetObj, "chk", false, true);
	        	} else if (sheetObj.id == "sheet2") {
	        		// processing Sheet3, Sheet7 ~ Sheet12
	        		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
		        		for (var a=2; a <= 11; a++) {
							if (a == 3 || a == 4 || a == 5) {
								continue;
							}
		        			// Cancelling existing amendment
		        			if (formObj.amdt_seq.value != "0") {
			                	for (var i=sheetObjects[a].HeaderRows(); sheetObjects[a].RowCount()> 0 && i <= sheetObjects[a].LastRow(); i++) {
			                		if (sheetObjects[a].GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
			                			sheetObjects[a].SetSelectRow(i + 1);
			                			var newNoteConvMapgId="";
			                			var prevNoteConvMapgId="";
			                        	if (a == 11) {
			                        		newNoteConvMapgId=sheetObjects[a].GetCellValue(sheetObjects[a].GetSelectRow(), "note_conv_mapg_id");
			                        		prevNoteConvMapgId=sheetObjects[a].GetCellValue(sheetObjects[a].GetSelectRow()- 1, "note_conv_mapg_id");
			                        	}
			                        	var prevIdx=doRowAmendCancel(sheetObjects[a]);
			                        	if (a == 2) {
			                        		setSheet3Style(sheetObjects[a], prevIdx);
			                        	}
			                        	// Handing conversion in case of Route Note
			                        	if (a == 11) {
			                	        	sheetObjects[a].SetCellValue(prevIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
			                	        	for (var j=sheetObjects[15].LastRow(); sheetObjects[15].RowCount()> 0 && j >= sheetObjects[15].HeaderRows(); j--) {
			                	        		if (sheetObjects[15].GetRowStatus(j) == "D") {
			                	        			continue;
			                	        		}
			                	        		if (sheetObjects[15].GetCellValue(j, "note_conv_mapg_id") == newNoteConvMapgId) {
			                	        			sheetObjects[15].RowDelete(j, false);
			                	        		}
			                	        	}
			                	        	for (var j=sheetObjects[15].LastRow(); sheetObjects[15].RowCount()> 0 && j >= sheetObjects[15].HeaderRows(); j--) {
			                	        		if (sheetObjects[15].GetRowStatus(j) == "D") {
			                	        			continue;
			                	        		}
			                	        		if (sheetObjects[15].GetCellValue(j, "note_conv_mapg_id") == prevNoteConvMapgId) {
			                	        			sheetObjects[15].SelectCell(j, 0);
			                	        			var copiedIdx=sheetObjects[15].DataCopy();
			                	        			sheetObjects[15].SetCellValue(copiedIdx, "note_conv_mapg_id",newNoteConvMapgId,0);
			                	        			sheetObjects[15].SetCellValue(copiedIdx, "amdt_seq",formObj.amdt_seq.value,0);
			                	        			if (sheetObjects[15].GetCellValue(copiedIdx, "exp_dt") == formObj.pre_exp_dt.value) {
			                	        				sheetObjects[15].SetCellValue(copiedIdx, "exp_dt",formObj.exp_dt.value,0);
			                	        			}
			                	        		}
			                	        	}
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
		                       		// Handing conversion in case of Route Note
		                       		if (a == 11) {
		                       			sheetObjects[a].SetCellValue(idx - 1, "note_conv_mapg_id",sheetObjects[a].GetCellValue(idx, "prev_note_conv_mapg_id"),0);
		                       			sheetObjects[a].SetRowStatus(idx - 1,"R");
		                       			for (var j=sheetObjects[15].LastRow(); sheetObjects[15].RowCount()> 0 && j >= sheetObjects[15].HeaderRows(); j--) {
		                       				if (sheetObjects[15].GetRowStatus(j) == "D") {
		            	            			continue;
		            	            		}
		                       				if (sheetObjects[15].GetCellValue(j, "note_conv_mapg_id") == sheetObjects[a].GetCellValue(idx, "note_conv_mapg_id")) {
				    	            			sheetObjects[15].RowDelete(j, false);
				    	            		}
				    	            	}
		                       		}
		                		} else if (sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value && (sheetObjects[a].GetCellValue(i, "src_info_cd") == "NW" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "GM" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC" || sheetObjects[a].GetCellValue(i, "src_info_cd") == "PM")) {
		                       		if (a == 11) {
				    	            	for (var j=sheetObjects[15].LastRow(); sheetObjects[15].RowCount()> 0 && j >= sheetObjects[15].HeaderRows(); j--) {
				    	            		if (sheetObjects[15].GetCellValue(j, "note_conv_mapg_id") == sheetObjects[a].GetCellValue(i, "note_conv_mapg_id")) {
				    	            			sheetObjects[15].RowDelete(j, false);
				    	            		}
				    	            	}
		                       		}
				                    sheetObjects[a].RowDelete(i, false);
		                    	} 
		                	}
		        		}
	        		}
	            	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	            		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            			sheetObj.SetCellValue(arrCheckedRows[i], "chk",0,0);
	            			setHdrLineDeleted(sheetObj, arrCheckedRows[i]);
	            		}
	            	}
	            	deleteRowCheck(sheetObj, "chk",false, true);
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
		        	deleteRowCheck(sheetObj, "chk",false, true);
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
        	if (parseInt(acptCnt) <= 0) {
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
            return true;
            break;
            
        case IBSEARCH_ASYNC13: // Accept
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	// in case of accepting not returned status by requester without authority
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
        		//Accepted
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
        		}
        		// in case of accepting not returned status by requester without authority
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value || (bIsReqUsr && !bIsAproUsr && sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "R")) {
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
            
        case IBSEARCH: // Retrieving
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {        		
        		ComShowCodeMessage("PRI01007");
                return false;
            } 
        	return true;
            break;
            
        case IBSAVE: // Saving
            if (sheetObj.id == "sheet1") {
            	if (formObj.prc_prop_sts_cd.value != "I") {
            		return false;
            	}
                if (!sheetObjects[0].IsDataModified()
                		&& !sheetObjects[3].IsDataModified()
                		&& !sheetObjects[4].IsDataModified()
                		&& !sheetObjects[5].IsDataModified()
                		&& !sheetObjects[14].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
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
                if (sheetObjects[14].IsDataModified()
                        && sheetObjects[14].GetSaveString() == "") {
                    return false;
                }
            } else if (sheetObj.id == "sheet3") {
            	if (formObj.prc_prop_sts_cd.value != "I"
            		&& formObj.prc_prop_sts_cd.value != "Q"
            		&& formObj.prc_prop_sts_cd.value != "R") {
            		return false;
            	}
            	if (isCMDTGroupDeleted()) {
            		return false;
            	}
                if (!sheetObjects[1].IsDataModified()
                        && !sheetObjects[2].IsDataModified()
                        && !sheetObjects[6].IsDataModified()
                        && !sheetObjects[7].IsDataModified()
                        && !sheetObjects[8].IsDataModified()
                        && !sheetObjects[9].IsDataModified()
                        && !sheetObjects[11].IsDataModified()
                        && !sheetObjects[15].IsDataModified()) {
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
                if (sheetObjects[11].IsDataModified()
                        && sheetObjects[11].GetSaveString() == "") {
                    return false;
                }
                if (sheetObjects[15].IsDataModified()
                        && sheetObjects[15].GetSaveString() == "") {
                    return false;
                }
                // Origin, O.Via, D.Via, Dest. Mandatory. Don't check in case of deleted Route group
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& getAmendValidRowCount(sheetObjects[6], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "Origin");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& isOViaMandatory
                	&& getAmendValidRowCount(sheetObjects[7], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "O.Via");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& isDViaMandatory
                	&& getAmendValidRowCount(sheetObjects[8], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "D.Via");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
                	&& getAmendValidRowCount(sheetObjects[9], formObj.amdt_seq.value) <= 0) {
                	ComShowCodeMessage("PRI00316", "Dest.");
                    return false;
                }
                // Checking whether Rate exists or not in case of not deleted Route Group
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "n1st_cmnc_amdt_seq") != "-1"
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
            
        case IBDOWNEXCEL: 
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
        	var checkedRows=sheetObj.FindCheckedRow( "chk" );
//			if ( checkedRows.length > 1 ) {
//				checkedRows=checkedRows.substr(0, checkedRows.length - 1);
//			}
			var checkedRowArr=checkedRows.split("|"); 
			if ( checkedRows == "" || checkedRowArr.length != 1 ) {
				ComShowCodeMessage('PRI00310');	
				return false;
			} else {
				sheetObj.selectRow=checkedRowArr[0];
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
            	if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
                	&& !checkCmdtEditable()) {
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
            } else if (sheetObj.id == "sheet2") {
            	if (isRouteGroupDeleted()) {
            		return false;
            	}
            	if (!checkRouteEditable()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
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
            		if (sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "NW" && sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GC" && sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GM" && sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PC" && sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PM" && sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
    					ComShowCodeMessage("PRI00313");
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
		// // checking duplicated Bullet No
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
	 * checking editable for CMDT group sheet
	 * 
	 * @returns bool <br>
	 *          true  : editable true<br>
	 *          false : editable false
	 * @author 
	 * @version 2009.05.01
	 */
    function checkCmdtEditable() {
        if (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified() || sheetObjects[9].IsDataModified()|| sheetObjects[11].IsDataModified() || sheetObjects[15].IsDataModified()) {
            return false;
        }
        return true;
    }
	/**
	 * checking editable for route group
	 * 
	 * @returns bool <br>
	 *          true  : editable true<br>
	 *          false : editable false
	 * @author 
	 * @version 2009.05.01
	 */
    function checkRouteEditable() {
        if (sheetObjects[0].IsDataModified() || sheetObjects[3].IsDataModified() || sheetObjects[4].IsDataModified() || sheetObjects[5].IsDataModified() || sheetObjects[14].IsDataModified()) {
            return false;
        }
        return true;
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
	 * 	 * Reloading. 
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
    	updateSummary();
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
     
    /**
	 * ESM_PRI_2022.js�먯꽌 �몄텧<br>
	 * after modify the COMMODITY NOTE, call save and search 
	 * 
	 * @param N/A
	 * @author 
	 * @version 2015.06.19
	 */
    function doSaveCommdityNote() {
    	doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
    
    /**
	 * ESM_PRI_2024.js�먯꽌 �몄텧<br>
	 * after modify the ROUTE NOTE, call save and search 
	 * 
	 * @param N/A
	 * @author 
	 * @version 2015.06.19
	 */
    function doSaveRouteNote() {  	
    	var cmdtRowIdx = sheetObjects[0].GetSelectRow();
    	doActionIBSheet(sheetObjects[2], document.form, IBSAVE);
    	sheetObjects[0].SetSelectRow(cmdtRowIdx);
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
        var sXml=sheetObjects[sheetObjects.length - 1].GetSearchData("ESM_PRI_2003_07GS.do" , param);
        var arrXml=sXml.split("|$$|");
        if (arrXml.length > 0) {
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
	    			if (ndCnt == 0) {
	    				sheetObjects[0].SetCellFont("FontStrike", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol(),1);
	    			} else {
	    				sheetObjects[0].SetCellFont("FontStrike", cmdtCurRow, 1, cmdtCurRow, sheetObjects[0].LastCol(),0);
	    			}
	    			if (naCnt == 0) {
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
					if (ndCnt == 0) {
						sheetObjects[1].SetCellFont("FontStrike", routCurRow, 1, routCurRow, sheetObjects[1].LastCol(),1);
					} else {
						sheetObjects[1].SetCellFont("FontStrike", routCurRow, 1, routCurRow, sheetObjects[1].LastCol(),0);
					}
					if (naCnt == 0) {
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
	 * Returning Max + 1 Bullet No.
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
		sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(),1);
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
    	// Don't apply color in case of Proposal status
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
    	if (sheetObj.GetCellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
    		sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(),1);
			sheetObj.SetRowEditable(idx,0);
			return true;
		} else {
			sheetObj.SetCellFont("FontStrike", idx, 1, idx, sheetObj.LastCol(),0);
			sheetObj.SetRowEditable(idx,1);
    	}
    	// // Font-color : red in case of this sequence's data
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
    	} else {
    		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#000000");
    	}
    }
	/**
	 * Setting each column by row or all row's one to enable/disable after retrieving
	 * 
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} idx selection 
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value && document.form.prc_prop_sts_cd.value == "I" && sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.SetCellEditable(idx, "rat_ut_cd",1);
	        	sheetObj.SetCellEditable(idx, "prc_cgo_tp_cd",1);
	        	sheetObj.SetCellEditable(idx, "curr_cd",1);
	        	sheetObj.SetCellEditable(idx, "prop_frt_rt_amt",1);
		} else {
        	sheetObj.SetCellEditable(idx, "rat_ut_cd",0);
        	sheetObj.SetCellEditable(idx, "prc_cgo_tp_cd",0);
        	sheetObj.SetCellEditable(idx, "curr_cd",0);
            if ((bIsReqUsr) && document.form.prc_prop_sts_cd.value == "R" && sheetObj.GetCellValue(idx, "prc_prog_sts_cd") == "R") {
            	sheetObj.SetCellEditable(idx, "prop_frt_rt_amt",1);
            } else {
            	sheetObj.SetCellEditable(idx, "prop_frt_rt_amt",0);
            }
		}
        if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q"
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
    	sheetObj.SetToolTipText(idx, "note_ctnt",sheetObj.GetCellValue(idx, "note_ctnt_tooltip"));
    }
	/**
	 * Getting XML from Sheet Data<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet No
	 * @author 
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
        var formObj=document.form;
        var sXml="";
        var sCol="";
        var sValue="";
        if (sheetNo == 3 || sheetNo == 4) {
            sCol="prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
        }
        sXml=ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        return sXml;
    }
	/**
	 * Loading data with xml format to sheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet No
	 * @author 
	 * @version 2009.05.01
	 */
    function setSheetXml(sXml, sheetNo) {
        var formObj=document.form;
        var sCol="";
        var sValue="";
        var bAppendMode=0;
        if (sheetNo == 3 || sheetNo == 4) {
            bAppendMode=1;
            sCol="prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
    
    function updateSummary() {
    	var termTpCd=TERMS_TYPE_CODE_GEN;
    	var rtn=null;
    	rtn=parent.comUpdateProposalStatusSummary(termTpCd, document.form.svc_scp_cd.value);
        
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
            ComBtnDisable("btn_checkduplicate");
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
            ComBtnDisable("btn_specification");
    		sheetObjects[12].SetColHidden("buc_usd_amt",1);
    		sheetObjects[12].SetColHidden("ifc_usd_amt",1);
    		sheetObjects[12].SetColHidden("psc_usd_amt",1);
    		sheetObjects[13].SetColHidden("buc_dry20",1);
    		sheetObjects[13].SetColHidden("buc_dry40",1);
    		sheetObjects[13].SetColHidden("buc_dry40hc",1);
    		sheetObjects[13].SetColHidden("buc_dry45",1);
    		sheetObjects[13].SetColHidden("buc_rf40hc",1);
    		sheetObjects[13].SetColHidden("buc_rd40hc",1);
    		sheetObjects[13].SetColHidden("ifc_dry20",1);
    		sheetObjects[13].SetColHidden("ifc_dry40",1);
    		sheetObjects[13].SetColHidden("ifc_dry40hc",1);
    		sheetObjects[13].SetColHidden("ifc_dry45",1);
    		sheetObjects[13].SetColHidden("ifc_rf40hc",1);
    		sheetObjects[13].SetColHidden("ifc_rd40hc",1);
    		sheetObjects[13].SetColHidden("psc_dry20",1);
    		sheetObjects[13].SetColHidden("psc_dry40",1);
    		sheetObjects[13].SetColHidden("psc_dry40hc",1);
    		sheetObjects[13].SetColHidden("psc_dry45",1);
    		sheetObjects[13].SetColHidden("psc_rf40hc",1);
    		sheetObjects[13].SetColHidden("psc_rd40hc",1);
            break;
        case "INIT":
        	ComBtnEnable("btn_retrieve");
        	ComBtnEnable("btn_downexcel");
        	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        		if (sheetObjects[0].RowCount()<= 0) {
        			ComBtnEnable("btn_glcopy");
        		} else {
        			ComBtnDisable("btn_glcopy");
        		}
        		ComBtnEnable("btn_checkduplicate");
        		ComBtnEnable("btn_gricalc");
        		ComBtnEnable("btn_loadexcel");
        	} else {
        		ComBtnDisable("btn_checkduplicate");
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
        		sheetObjects[12].SetColHidden("buc_usd_amt",0);
        		sheetObjects[12].SetColHidden("ifc_usd_amt",0);
        		sheetObjects[12].SetColHidden("psc_usd_amt",0);
        		sheetObjects[13].SetColHidden("buc_dry20",0);
        		sheetObjects[13].SetColHidden("buc_dry40",0);
        		sheetObjects[13].SetColHidden("buc_dry40hc",0);
        		sheetObjects[13].SetColHidden("buc_dry45",0);
        		sheetObjects[13].SetColHidden("buc_rf40hc",0);
        		sheetObjects[13].SetColHidden("buc_rd40hc",0);
        		sheetObjects[13].SetColHidden("ifc_dry20",0);
        		sheetObjects[13].SetColHidden("ifc_dry40",0);
        		sheetObjects[13].SetColHidden("ifc_dry40hc",0);
        		sheetObjects[13].SetColHidden("ifc_dry45",0);
        		sheetObjects[13].SetColHidden("ifc_rf40hc",0);
        		sheetObjects[13].SetColHidden("ifc_rd40hc",0);
        		sheetObjects[13].SetColHidden("psc_dry20",0);
        		sheetObjects[13].SetColHidden("psc_dry40",0);
        		sheetObjects[13].SetColHidden("psc_dry40hc",0);
        		sheetObjects[13].SetColHidden("psc_dry45",0);
        		sheetObjects[13].SetColHidden("psc_rf40hc",0);
        		sheetObjects[13].SetColHidden("psc_rd40hc",0);
        	} else {
        		sheetObjects[12].SetColHidden("buc_usd_amt",1);
        		sheetObjects[12].SetColHidden("ifc_usd_amt",1);
        		sheetObjects[12].SetColHidden("psc_usd_amt",1);
        		sheetObjects[13].SetColHidden("buc_dry20",1);
        		sheetObjects[13].SetColHidden("buc_dry40",1);
        		sheetObjects[13].SetColHidden("buc_dry40hc",1);
        		sheetObjects[13].SetColHidden("buc_dry45",1);
        		sheetObjects[13].SetColHidden("buc_rf40hc",1);
        		sheetObjects[13].SetColHidden("buc_rd40hc",1);
        		sheetObjects[13].SetColHidden("ifc_dry20",1);
        		sheetObjects[13].SetColHidden("ifc_dry40",1);
        		sheetObjects[13].SetColHidden("ifc_dry40hc",1);
        		sheetObjects[13].SetColHidden("ifc_dry45",1);
        		sheetObjects[13].SetColHidden("ifc_rf40hc",1);
        		sheetObjects[13].SetColHidden("ifc_rd40hc",1);
        		sheetObjects[13].SetColHidden("psc_dry20",1);
        		sheetObjects[13].SetColHidden("psc_dry40",1);
        		sheetObjects[13].SetColHidden("psc_dry40hc",1);
        		sheetObjects[13].SetColHidden("psc_dry45",1);
        		sheetObjects[13].SetColHidden("psc_rf40hc",1);
        		sheetObjects[13].SetColHidden("psc_rd40hc",1);
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
            ComBtnEnable("btn_specification");
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
        			// Nothing
        		}
        		if (bIsReqUsr) {
        			ComBtnEnable("btn_save2");
        			ComBtnEnable("btn_save3");
        		}
        	} 
            break;
        case "READONLY":
        	ComBtnEnable("btn_retrieve");
        	ComBtnEnable("btn_acceptall");
        	ComBtnDisable("btn_cancel");
        	ComBtnDisable("btn_glcopy");
        	ComBtnDisable("btn_gricalc");
        	ComBtnEnable("btn_checkduplicate");
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
            ComBtnEnable("btn_specification");
    		sheetObjects[12].SetColHidden("buc_usd_amt",1);
    		sheetObjects[12].SetColHidden("ifc_usd_amt",1);
    		sheetObjects[12].SetColHidden("psc_usd_amt",1);
    		sheetObjects[13].SetColHidden("buc_dry20",1);
    		sheetObjects[13].SetColHidden("buc_dry40",1);
    		sheetObjects[13].SetColHidden("buc_dry40hc",1);
    		sheetObjects[13].SetColHidden("buc_dry45",1);
    		sheetObjects[13].SetColHidden("buc_rf40hc",1);
    		sheetObjects[13].SetColHidden("buc_rd40hc",1);
    		sheetObjects[13].SetColHidden("ifc_dry20",1);
    		sheetObjects[13].SetColHidden("ifc_dry40",1);
    		sheetObjects[13].SetColHidden("ifc_dry40hc",1);
    		sheetObjects[13].SetColHidden("ifc_dry45",1);
    		sheetObjects[13].SetColHidden("ifc_rf40hc",1);
    		sheetObjects[13].SetColHidden("ifc_rd40hc",1);
    		sheetObjects[13].SetColHidden("psc_dry20",1);
    		sheetObjects[13].SetColHidden("psc_dry40",1);
    		sheetObjects[13].SetColHidden("psc_dry40hc",1);
    		sheetObjects[13].SetColHidden("psc_dry45",1);
    		sheetObjects[13].SetColHidden("psc_rf40hc",1);
    		sheetObjects[13].SetColHidden("psc_rd40hc",1);
            break;
        }
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
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
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
            bIsReqUsr=sIsReqUsr;
            bIsAproUsr=sIsAproUsr;
            if (formObject.amdt_seq.value == "0") {
            	hiddenButton("btn_amend3");
            	hiddenButton("btn_amendcancel3");
            } else {
            	showButton("btn_amend3");
            	showButton("btn_amendcancel3");
            }
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);
            var sCustType=parent.getCustTpCd();
            // if Customer Type= N, Actual Customer Type Enable
            if (sCustType == "N") {
//                sheetObjects[0].InitDataProperty(0, 9, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, true, true);
            	sheetObjects[0].SetColEditable("cust_lgl_eng_nm", 1);
            } else {
//            	sheetObjects[0].InitDataProperty(0, 9, dtPopup, 300, daLeft, false, "cust_lgl_eng_nm", false, "", dfNone, 0, false, false);
            	sheetObjects[0].SetColEditable("cust_lgl_eng_nm", 0);
            }
            // O.Via Mandatory
            if (isOViaMandatory) {
//                sheetObjects[1].InitDataProperty(0, 9, dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            	
            	var sheetObj = sheetObjects[1];
            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            	var info = {KeyField: true };
	            	sheetObj.SetColProperty(i, "org_rout_via_port_def_cd", info);
            	}

            	
            } else {
//                sheetObjects[1].InitDataProperty(0, 9, dtPopup, 165, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            	
            	var sheetObj = sheetObjects[1];
            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            	var info = {KeyField: false };
	            	sheetObj.SetColProperty(i, "org_rout_via_port_def_cd", info);
            	}
            	
            }
            // D.Via Mandatory
            if (isDViaMandatory) {
//                sheetObjects[1].InitDataProperty(0, 10, dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            	
            	var sheetObj = sheetObjects[1];
            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            	var info = {KeyField: true };
	            	sheetObj.SetColProperty(i, "dest_rout_via_port_def_cd", info);
            	}
            	
            } else {
//                sheetObjects[1].InitDataProperty(0, 10, dtPopup, 165, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            	
            	var sheetObj = sheetObjects[1];
            	for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
	            	var info = {KeyField: false };
	            	sheetObj.SetColProperty(i, "dest_rout_via_port_def_cd", info);
            	}
            	
            }
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
        toggleButtons("CLEAR");
    }
    var enableFlag=true;
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
    	return (sheetObjects[0].GetRowStatus(row) == "D" || sheetObjects[0].GetCellFontStrike(row, "prc_cmdt_def_nm"));
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
    	return (sheetObjects[1].GetRowStatus(row) == "D" || sheetObjects[1].GetCellFontStrike(row, "org_rout_pnt_loc_def_cd") || sheetObjects[1].GetCellFontStrike(row, "dest_rout_pnt_loc_def_cd"))
    }
	/**
	 * Checking whether Route Group's row is deleted.<br>
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
    
    
    
    
    
    //�꾩떆
//    function showConfirmJQMsg(tits, msgs, sGubun) {
//    	$('<div></div>').appendTo('body').html('<div><h6>'+msgs+'</h6></div>').dialog({
//            modal: true,
//            title: tits,
//            zIndex: 10000,
//            autoOpen: true,
//            width: 'auto',
//            resizable: false,
//            buttons: {
//                Yes: function () {
//                	execConfirmAfter(sGubun, 1);
//                	$(this).dialog("close");
//                },
//                No: function () {
//                	execConfirmAfter(sGubun, 2);
//                  $(this).dialog("close");
//                }
//                ,
//                Cancel: function () {
//                	execConfirmAfter(sGubun, 3);
//                  $(this).dialog("close");
//                }
//            },
//            close: function (event, ui) {
//                $(this).remove();
//            }
//        });
//    }
    
    
    //�꾩떆
    /**
	 * excell download or load excel popup according to result value from confirm<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {String} button id 
	 * @param {Int} confirm result value (yes 1, no 2)
	 * @version 2014.09.11
	 */    
    function execConfirmAfter(sGubun, sType) {
    
    	var formObject = document.form;
    	if(sGubun == "btn_downexcel") {
    	
	    	ComOpenWait(true);	            	
	      	if (sType == 1) {	            
	      		doActionIBSheet(sheetObjects[12], document.form, IBDOWNEXCEL);
	    	} else if (sType == 2) {
	    		doActionIBSheet(sheetObjects[13], document.form, IBDOWNEXCEL);
	    	}	            	
	 		ComOpenWait(false);
 		
    	} else if(sGubun == "btn_loadexcel") {
    	
    		formObject.f_cmd.value = "";           	
	      	if (sType == 1) {	            
	      		ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2065.do?" + FormQueryString(formObject), "ESM_PRI_2065", 950, 563, false);
	    	} else if (sType == 2) {
	    		ComPriOpenWindowCenter("/opuscntr/ESM_PRI_2060.do?" + FormQueryString(formObject), "ESM_PRI_2060", 950, 563, false);
	    	}	            	
	 		
 		
    	}
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
