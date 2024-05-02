/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0057_06.js
*@FileTitle  : Amendment History Inquiry - General/Special Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
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
    /**
     * @extends
     * @class Guideline Creation :business script for Guideline Creation 
     *
     */
    function ESM_PRI_0057_06() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // common global variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
    var LoadingComplete=false;
//    var arrTermOrg = new Array();
//    var arrTermDest = new Array();
//    var arrNoteClass = new Array();
//    var arrTransMode = new Array();
    var acptCnt=new Array();
    var notAcptCnt=new Array();
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
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
            case "btn_retrieve":
            	getConversionChecked();
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
            case "btn_gricalc":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
            		ComOpenPopup("/opuscntr/ESM_PRI_0112.do?" + FormQueryString(formObject), 1000, 570, "", "0,1", true);
                }
                break;
            case "gen_spcl_rt_tp_cd":
                if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
                	if (getGenSpclRtTpCd() == "G") {
                		sheetObjects[0].SetColHidden("cust_lgl_eng_nm",1);
                		sheetObjects[0].SetColWidth("prc_cmdt_def_nm",650);
                	} else {
                		sheetObjects[0].SetColHidden("cust_lgl_eng_nm",0);
                		sheetObjects[0].SetColWidth("prc_cmdt_def_nm",350);
                	}
                    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
	 * initializing sheet <br>
	 * implementing onLoad event handler in body tag <br>
	 * adding first-served functions after loading screen. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @return void
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
        loadSts=true;
        parent.loadTabPage();
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
        case "sheet1":  // Grid 1
			with(sheetObj){
        		var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Commodity Header Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_clss_nm_tooltip|Not Deleted Rows|Not Accepted Rows|n1st_cmnc_amdt_seq";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Int",       Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"blet_dp_seq",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Popup",     Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm_tooltip",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(142);
				SetEditable(1);
				SetEllipsis(1);
				SetShowButtonImage(2);
			}
            break;
        case "sheet2":  // Grid 2
			with(sheetObj){
        		var HeadTitle = "|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Commodity Header Seq.|Route Seq.|Origin|O.Via|D.Via|Dest.|Direct Call|Direct Call|Note|Note Tooltip|Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rn",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , HeaderCheck:0},
				 {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
				 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm_tooltip",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(142);
				SetEditable(1);
				SetEllipsis(1);
				SetShowButtonImage(2);
				SetWaitTimeOut(600);
			}
            break;
        case "sheet3":  // Grid 3
			with(sheetObj){
				var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"next_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				resizeSheet(); //SetSheetHeight(142);
				SetEditable(0);
				SetEllipsis(1);
				SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
				SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCddValue} );
				SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
				//SetShowButtonImage(2);
			}
            break;
        case "sheet4":  // Grid 1: Commodity  
			with(sheetObj){
				var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19|4-20|4-21|4-22";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet5":  // Grid 1's Actual Customer
			with(sheetObj){
				var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17|5-18|5-19|5-20";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet6":  // Grid 1's Commodity Note
			with(sheetObj){
				var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19|6-20|6-21|6-22|6-23|6-24";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet7":  // Grid 2's Origin Point
			with(sheetObj){
				var HeadTitle="7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25|7-26|7-27|7-28";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet8":  // Grid 2's Origin Via.
			with(sheetObj){
				var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21|8-22|8-23|8-24";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet9":  // Grid 2's Destination Via.
			with(sheetObj){
				var HeadTitle="9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21|9-22|9-23|9-24";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet10":  // Grid 2's Destination Point
			with(sheetObj){
				var HeadTitle="10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25|10-26|10-27|10-28";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet11":  // Grid 2's Direct Call
			with(sheetObj){
				var HeadTitle="11-1|11-2|11-3|11-4|11-5|11-6|11-7|11-8|11-9|11-10|11-11|11-12|11-13|11-14|11-15|11-16|11-17|11-18";
				var headCount=ComCountHeadTitle(HeadTitle);
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet12":  // Grid 2's Rnote
			with(sheetObj){
				var HeadTitle="12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19|12-20|12-21|12-22|12-23|12-24|12-25";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        }
    }
    
    function resizeSheet() {
    	ComResizeSheet(sheetObjects[2]);
    }
	/**
	 * calling function in case of OnSelectCell event <br>
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
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange1(OldRow, NewRow, OldCol, NewCol);
    }
	/**
	 * calling function in case of OnSelectCell event <br>
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
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        doRowChange2(OldRow, NewRow, OldCol, NewCol);
    }
	/**
	 * calling function in case of OnSelectCell event <br>
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
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {

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
    function sheet7_OnSearchEnd(sheetObj, code, ErrMsg) {
        if (code == 0) {
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
            	//if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            	if (document.form.amdt_seq.value != "0") {
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
    function sheet8_OnSearchEnd(sheetObj, code, ErrMsg) {
    	 if (code == 0) {
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
            	//if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            	if (document.form.amdt_seq.value != "0") {
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
    function sheet9_OnSearchEnd(sheetObj, code, ErrMsg) {
    	if (code == 0) {
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
            	//if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            	if (document.form.amdt_seq.value != "0") {
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
    function sheet10_OnSearchEnd(sheetObj, code, ErrMsg) {
    	if (code == 0) {
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
            	//if (document.form.amdt_seq.value != "0" && document.form.lgcy_if_flg.value == "N") {
            	if (document.form.amdt_seq.value != "0") {
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
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        if (colName == "prc_cmdt_def_nm") {
            var sUrl="/opuscntr/ESM_PRI_0114.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 250, "", "0,1", true);
        }
        if (colName == "cust_lgl_eng_nm") {
        	var sUrl="/opuscntr/ESM_PRI_0119.do?" + FormQueryString(document.form);
        	ComOpenPopup(sUrl, 820, 250, "", "0,1", true);
        }
        if (colName == "note_clss_nm") {
        	var sUrl="/opuscntr/ESM_PRI_0090.do?" + FormQueryString(document.form);
        	ComOpenPopup(sUrl, 1050, 350, "", "0,1", true);
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
        if (!LoadingComplete) {
            return;
        }
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        var sUrl="/opuscntr/ESM_PRI_0115.do?" + FormQueryString(document.form);
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 295, "", "0,1", true);
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 295, "", "0,1", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 295, "", "0,1", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 295, "", "0,1", true);
        }
        if (colName == "dir_call_flg_pop") {
            sUrl="/opuscntr/ESM_PRI_0117.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 600, 240, "", "0,1", true);
        }
        if (colName == "note_clss_nm") {
            sUrl="/opuscntr/ESM_PRI_0118.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 1030, 350, "", "0,1", true);
        }
    }
    var isFiredNested=false;
    var isFiredNestedExt=false;
    var supressConfirm=false;
	/**
	 * in case of modifying row on Sheet <br>
	 * <br><b>Example :</b>
	 * <pre>
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
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[0].IsDataModified()
            		|| sheetObjects[3].IsDataModified()
            		|| sheetObjects[4].IsDataModified()
            		|| sheetObjects[5].IsDataModified()) {
            	isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                if (validateForm(sheetObjects[0], document.form, IBSAVE)) {
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                	isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                	isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                    return -1;
                }
            }
            if (sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()
                    || sheetObjects[9].IsDataModified()
                    || sheetObjects[10].IsDataModified()
                    || sheetObjects[11].IsDataModified()) {
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
                	if (sAction != IBINSERT && sAction != IBCOPYROW) {
	                    isFiredNested=true;
	                    sheetObjects[0].SelectCell(NewRow, NewCol, false);
	                    isFiredNested=false;
                	}
                } else {
                    isFiredNested=true;
                    sheetObjects[0].SelectCell(OldRow, OldCol, false);
                    isFiredNested=false;
                	return -1;
                }
            }
            if (sAction == IBINSERT) {
                isFiredNested=true;
                var idx=sheetObjects[0].DataInsert();
                isFiredNested=false;
                return idx;
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
	 * <br><b>Example :</b>
	 * <pre>
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
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && !isFiredNestedExt && (OldRow != NewRow)) {
            if (sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()
                    || sheetObjects[9].IsDataModified()
                    || sheetObjects[10].IsDataModified()
                    || sheetObjects[11].IsDataModified()) {
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
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {form} formObj mandatory html form object
	 * @param {int} sAction mandatory,Constant Variable
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            /*if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }*/
        	if (window.event == null || ComGetEvent() == null /*|| ComGetEvent("suppressWait") != "Y"*/) {
                ComOpenWait(true);
            }
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH: // retrieving
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (getConversionChecked() == "N" && formObj.amdt_seq.value == "0") {
	            	tabClearSheet();
	            	return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH01;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0057_06GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchData(arrXml[1],{Sync:0} );
	                if (arrXml.length > 2) sheetObjects[4].LoadSearchData(arrXml[2],{Sync:0} );
	                if (arrXml.length > 3) sheetObjects[5].LoadSearchData(arrXml[3],{Sync:0} );
	                var griCnt=ComGetEtcData(arrXml[0], "gri_cnt");
	                if (parseInt(griCnt) > 0) {
	                	enableButton("btn_gricalc");
	                } else {
	                	disableButton("btn_gricalc");
	                }
	            } else if (sheetObj.id == "sheet2") {
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
	                sheetObj.DoSearch("ESM_PRI_0057_06GS.do", FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "blet_dp_seq"), {Sync:2} );
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                	if (i == 3 || i == 4 || i == 5) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0057_06GS.do" , FormQueryString(formObj));
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
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
    function setSheet3Style(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	setLineStyle(sheetObj, i);
            }
        } else {
        	setLineStyle(sheetObj, idx);
        }
    }
    function setLineStyle(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetRowStatus(idx) == "D") {
    		sheetObj.SetRowHidden(idx,1);
    	}
    	if (document.form.amdt_seq.value == "0" || document.form.lgcy_if_flg.value == "Y") {
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
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
    		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
    	} else {
    		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#000000");
    	}
    }
    function drawGenSpclRtTpCd() {
    	var formObj=document.form;
        formObj.f_cmd.value=SEARCH20;
        var sXml=sheetObjects[sheetObjects.length - 1].GetSearchData("ESM_PRI_0057_06GS.do" , FormQueryString(formObj) + "&n1st_cmnc_amdt_seq=" + formObj.amdt_seq.value);
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
            if (parseInt(arrData[i][7]) > 0) {
                if (firstMatch < 0) {
                    firstMatch=i;
                }
                arrData[i][1]="<b>" + arrData[i][1] + "</b>";
            }
            sHTML += "<input name='gen_spcl_rt_tp_cd' value='" + arrData[i][0] + "' type='radio' class='trans'>";
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
    function getGenSpclRtTpCd() {
        for (var i=0; i < document.form.gen_spcl_rt_tp_cd.length; i++) {
            if (document.form.gen_spcl_rt_tp_cd[i].checked) {
                return document.form.gen_spcl_rt_tp_cd[i].value;
            }
        }
    }
    function getGenSpclRtTpChecked() {
        for (var i=0; i < document.form.gen_spcl_rt_tp_cd.length; i++) {
            if (document.form.gen_spcl_rt_tp_cd[i].checked) {
                return i;
            }
        }
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
    function getConversionChecked() {
    	if (parent.document.form.con_flg.checked) {
    		document.form.conv_chk.value="Y";
    	} else {
    		document.form.conv_chk.value="N";
    	}
    	return document.form.conv_chk.value;
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
        if (sheetNo == 3 || sheetNo == 4 || sheetNo == 5) {
            sCol="prop_no|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + getGenSpclRtTpCd() + "|" + formObj.cmdt_hdr_seq.value;
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
        if (sheetNo == 3 || sheetNo == 4 || sheetNo == 5) {
            bAppendMode=1;
            sCol="prop_no|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + getGenSpclRtTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
	/**
	 * Setting default and retrieving. Calling function from parent when loading a screen on tab<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {
        var formObject=document.form;
        if (sSvcScpCd == null || sSvcScpCd == "") {
        	return;
        }
        if (formObject.prop_no.value != sPropNo
                || formObject.amdt_seq.value != sAmdtSeq
                || formObject.svc_scp_cd.value != sSvcScpCd) {
        	formObject.prop_no.value=sPropNo;
        	formObject.amdt_seq.value=sAmdtSeq;
            formObject.svc_scp_cd.value=sSvcScpCd;
            formObject.lgcy_if_flg.value=sLgcyIfFlg;
            if (getConversionChecked() == "N" && formObject.amdt_seq.value == "0") {
            	tabClearSheet();
            	return false;
            }
            drawGenSpclRtTpCd();
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
	/**
	 * Initializing all data of a screen, calling from parent frame<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function tabClearSheet() {
        var formObject=document.form;
    	formObject.prop_no.value="";
    	formObject.amdt_seq.value="";
        formObject.svc_scp_cd.value="";
        formObject.conv_chk.value="";
        for (var i=0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
        origin_desc.innerHTML="";
        ovia_desc.innerHTML="";
        dvia_desc.innerHTML="";
        dest_desc.innerHTML="";
    }
    var enableFlag=true;
    function tabEnableSheet(flag) {
        var formObject=document.form;
        enableFlag=flag;
        sheetObjects[0].SetEditable(flag);
        sheetObjects[1].SetEditable(flag);
        sheetObjects[2].SetEditable(flag);
    }
    var loadSts=false;
    // This function calls at main.
    function loadFinishCheck(){
        return loadSts;
    }  
	/**
	 * Call Expire date of duration. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  void
	 * @return {string} 
	 * @author 
	 * @version 2009.05.01
	 */
   function getCtrtExpDate() {
	   var ctrtExpDt=parent.getCtrtExpDate();
       return ctrtExpDt;
   }