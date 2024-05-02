/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_2041_05.js
 *@FileTitle  : RFA Search - Amendment History - Rate
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06
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
    function ESM_PRI_2041_05() {
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
//    var arrTransMode = new Array();
    var acptCnt=null;
    var notAcptCnt=null;
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
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
            case "btn_gricalc":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
            		ComOpenPopup("/opuscntr/ESM_PRI_2087.do?" + FormQueryString(formObject), 1000, 480, "", "1,0", false);
                }
                break;
            case "btn_specification":
            	if (formObject.prop_no.value != "" && formObject.amdt_seq.value != "" && formObject.svc_scp_cd.value != "") {
            		if (sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "prc_cgo_tp_cd") != "AK") {
	            		return false;
	            	}
            	}
            	ComOpenPopup("/opuscntr/ESM_PRI_2075.do?"+ FormQueryString(formObject) + "&rt_seq=" + sheetObjects[2].GetCellValue(sheetObjects[2].GetSelectRow(), "rt_seq"), 700, 420, "", "1,0", false);
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
        	var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Bullet No.|Commodity Group|Actual Customer|Commodity Note|note_ctnt_tooltip|Not Deleted Rows|Not Accepted Rows|Accepted Rows|n1st_cmnc_amdt_seq";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Int",       Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"blet_dp_seq",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Popup",     Hidden:0, Width:350,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_tooltip",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ac_cnt",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(142);
				SetEditable(1);
				SetEllipsis(1);
				SetShowButtonImage(2);
				SetAutoRowHeight(0);
			}
            break;
        case "sheet2":  // Grid 2
			with(sheetObj){
				var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Origin|Origin Via|Destination Via|Destination|Route Note|Note Tooltip|Not Deleted Rows|Not Accepted Rows|note_dp_seq|n1st_cmnc_amdt_seq";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rn",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:165,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Popup",     Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_tooltip",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"nd_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"na_cnt",                     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(142);
				SetEditable(1);
				SetEllipsis(1);
				SetShowButtonImage(2);
				SetAutoRowHeight(0);
			}
            break;
        case "sheet3":  // Grid 3
			with(sheetObj){
				var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Commodity Header Seq.|Route Seq.|Rate Seq.|Per|CGO Type|CUR|Proposal|C/Offer|Final|EFF Date|next_n1st_cmnc_amdt_seq|EXP Date|Source Code|Source|Status Code|Status|GRI|GRI|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq|Accept User ID|1st ord|2nd ord";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"coffr_frt_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fnl_frt_rt_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"next_n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_amt",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n2nd_ord_ref",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(142);
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
				var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10|4-11|4-12|4-13|4-14|4-15|4-16|4-17|4-18|4-19|4-20|4-21";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13|5-14|5-15|5-16|5-17|5-18|5-19";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet6":  // Grid 1's Commodity Note
			with(sheetObj){
				var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11|6-12|6-13|6-14|6-15|6-16|6-17|6-18|6-19|6-20";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet7":  // Grid 2's Origin Point
			with(sheetObj){
				var HeadTitle="7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13|7-14|7-15|7-16|7-17|7-18|7-19|7-20|7-21|7-22|7-23|7-24|7-25|7-26|7-27";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13|8-14|8-15|8-16|8-17|8-18|8-19|8-20|8-21|8-22|8-23";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				var HeadTitle="9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10|9-11|9-12|9-13|9-14|9-15|9-16|9-17|9-18|9-19|9-20|9-21|9-22|9-23";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				var HeadTitle="10-1|10-2|10-3|10-4|10-5|10-6|10-7|10-8|10-9|10-10|10-11|10-12|10-13|10-14|10-15|10-16|10-17|10-18|10-19|10-20|10-21|10-22|10-23|10-24|10-25|10-26|10-27";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
				var HeadTitle="status";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];
				   				        
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
				SetVisible(0);
			}
            break;
        case "sheet12":  // Grid 2's Rnote
			with(sheetObj){
				var HeadTitle="12-1|12-2|12-3|12-4|12-5|12-6|12-7|12-8|12-9|12-10|12-11|12-12|12-13|12-14|12-15|12-16|12-17|12-18|12-19|12-20";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(100);
				SetEditable(1);
			}
            break;
        case "sheet13": // Excel Download Sheet(Vertical)
			with(sheetObj){
				var HeadTitle1="Seq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Surcharge(USD)|Surcharge(USD)|Surcharge(USD)";
				var HeadTitle2="Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|PER|Cargo Type|Rate|BUC|IFC|PSC";
				var headCount=ComCountHeadTitle(HeadTitle2);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
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
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",            KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_usd_amt",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_usd_amt",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_usd_amt",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(300);
				SetEditable(1);
			}
            break;
        case "sheet14": // Excel Download Sheet(Horizontal)
			with(sheetObj){
				var HeadTitle1="Seq.|Commodity Group|Commodity Group|Actual Customer|Actual Customer|Seq.|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|Rate(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|BUC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|IFC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)|PSC(USD)";
				var HeadTitle2="Seq.|Code|Description|Code|Description|Seq.|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC|Dry 20'|Dry 40'|Dry 40HC|Dry 45'|RF 40HC|RD 40HC";
				var headCount=ComCountHeadTitle(HeadTitle2);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				
				var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
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
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry20",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry40",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry40hc",               KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_dry45",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_rf40hc",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rate_rd40hc",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_dry20",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_dry40",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_dry40hc",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_dry45",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_rf40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"buc_rd40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_dry20",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_dry40",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_dry40hc",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_dry45",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_rf40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"ifc_rd40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_dry20",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_dry40",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_dry40hc",                KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_dry45",                  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_rf40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"psc_rd40hc",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
				   
				InitColumns(cols);
				SetSheetHeight(300);
				SetEditable(1);
			}
            break;
        case "sheet15": // Commodity Note Conversion
			with(sheetObj){
				var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +"|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" } ];
				   
				InitColumns(cols);
				SetSheetHeight(130);
				SetEditable(1);
			}
            break;
        case "sheet16": // Route Note Conversion
			with(sheetObj){
				var HeadTitle="|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Pay Term|Per|CGO\nType|IMDG\nClass" +"|Lane|T/S\nPort|Canal|VVD|SOC|POR|POL|POD|DEL|Node|CMDT|Weight\n(Ton <=)|Weight\n( > Ton)|Direct\nCall|Bar Type|S/I" +"|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
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
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_cmdt_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_por_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pol_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_pod_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_del_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_vsl_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_voy_no" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_skd_dir_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
				 {Type:"Text",      Hidden:1,  Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no" } ];
				   
				InitColumns(cols);
				SetSheetHeight(130);
				SetEditable(1);
			}
            break;
        }
    }
    
    function resizeSheet(){
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
            var sUrl="/opuscntr/ESM_PRI_2089.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 250, "", "1,0", true);
        }
        if (colName == "cust_lgl_eng_nm") {
        	var sUrl="/opuscntr/ESM_PRI_2090.do?" + FormQueryString(document.form);
        	ComOpenPopup(sUrl, 900, 250, "", "1,0", true);
        }
        if (colName == "note_ctnt") {
        	var sUrl="/opuscntr/ESM_PRI_2084.do?" + FormQueryString(document.form) + "&select_row=" + sheetObjects[0].GetSelectRow();
            ComOpenPopup(sUrl, 950, 680, "", "1,0", true);
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
        var sUrl="/opuscntr/ESM_PRI_2088.do?" + FormQueryString(document.form);
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 320, "", "1,0", true);
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 320, "", "1,0", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 1000, 320, "", "1,0", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 1000, 320, "", "1,0", true);
        }
        if (colName == "note_ctnt") {
            sUrl="/opuscntr/ESM_PRI_2085.do?" + FormQueryString(document.form);
            ComOpenPopup(sUrl, 900, 520, "", "1,0", true);
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
        	//var objEvt = ComGetEvent();
        	/*if (window.event == null || window.event.srcElement == null || $(objEvt).attr('suppressWait')!= "Y") {
        		ComOpenWait(true);
        	}*/
        	 //if (window.event == null || ComGetEvent() == null) {
                 ComOpenWait(true);
             //}
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH: // retrieving
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage("PRI01007");
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH01;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_2041_05GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[4].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[5].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[14].LoadSearchData(arrXml[4],{Sync:1} );
	                var griCnt=ComGetEtcData(arrXml[0], "gri_cnt");
	                if (parseInt(griCnt) > 0) {
	                	enableButton("btn_gricalc");
	                } else {
	                	disableButton("btn_gricalc");
	                }
	            } else if (sheetObj.id == "sheet2") {
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
	                var opt = { Sync : 2 };
	                sheetObj.DoSearch("ESM_PRI_2041_05GS.do", FormQueryString(formObj) + "&cmdt_row_seq=" + sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, "blet_dp_seq"), opt );
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                	if (i == 3 || i == 4 || i == 5 || i == 14) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_2041_05GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[6].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[7].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[8].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[9].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[11].LoadSearchData(arrXml[5],{Sync:1} );
	                if (arrXml.length > 6) sheetObjects[15].LoadSearchData(arrXml[6],{Sync:1} );
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
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
    		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
    	} else {
    		sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#000000");
    	}
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
        if (sheetNo == 3 || sheetNo == 4) {
            sCol="prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
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
        if (sheetNo == 3 || sheetNo == 4) {
            bAppendMode=1;
            sCol="prop_no|svc_scp_cd|cmdt_hdr_seq";
            sValue=formObj.prop_no.value + "|" +  formObj.svc_scp_cd.value + "|" + formObj.cmdt_hdr_seq.value;
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
    function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
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