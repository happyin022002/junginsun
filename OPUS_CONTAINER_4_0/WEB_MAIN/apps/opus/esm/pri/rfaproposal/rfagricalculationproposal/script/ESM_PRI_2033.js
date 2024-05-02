/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2033.js
*@FileTitle  : RFA Proposal Creation - Rate [GRI Calculation]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
    function ESM_PRI_2033() {
        this.processButtonClick=tprocessButtonClick;
        this.setSheetObject=setSheetObject;
        this.loadPage=loadPage;
        this.initSheet=initSheet;
        this.initControl=initControl;
        this.doActionIBSheet=doActionIBSheet;
        this.setTabObject=setTabObject;
        this.validateForm=validateForm;
    }
    // global variables
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var tabLoad=new Array();
    tabLoad[0]=0;
    tabLoad[1]=0;
    var LoadingComplete=false;
    var arrTermOrg=new Array();
    var arrTermDest=new Array();
    //Event handler processing by button click event */
    document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name  <br>
	 */
    function processButtonClick() {      
        var sheetObject1=sheetObjects[0];
        /** **************************************************** */
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch (srcName) {
            case "btn_rowadd1":
                doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
                break;
            case "btn_rowadd2":
                doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
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
            case "btn_save2":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
            case "btn_ok":
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
                break;
            case "btn_cancel":
            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
                break;
			case "btn_close":
				ComClosePopup(); 
				break;
			case "flt_pct_tp_cd":
				setFltPctEnable();
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
	 * adding process for list in case of needing batch processing with other items  <br>
	 * defining list on the top of source <br>
	 */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
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
    	
        for (var i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
            ComEndConfigSheet(sheetObjects[i]);
        }
        toggleButtons("CLEAR");
        document.form.flt_pct_tp_cd[0].checked=true;
        doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 * param : sheetObj, sheetNo
	 */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch (sheetID) {
        case "sheet1":  // Grid 1
        with(sheetObj){

			   var HeadTitle="|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|GRI Group Seq.|Flat Percent Type Code|Application|GRI Application Flag|prc_cmdt_def_cd|Commodity Group|cust_seq|Actual Customer|origin|Origin|ovia|O.Via|dvia|D.Via|dest|Dest.";
			   var headCount=ComCountHeadTitle(HeadTitle);
			
			   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			   var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle, Align:"Center"} ];
			   InitHeaders(headers, info);
			
			   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"flt_pct_tp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_div_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_appl_flg",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 {Type:"Text",      Hidden:1, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"PopupEdit",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			    
			   InitColumns(cols);
			
			   SetEditable(1);
			   SetEllipsis(1);
			   SetCountPosition(2);
			   SetShowButtonImage(2);
			   SetCountFormat("[ ]");
			   SetSheetHeight(120);
			   }
			   break;
        case "sheet2":  // Grid 2
			   with(sheetObj){

			var HeadTitle="|Sel.|Seq.|Proposal No.|Amendent Seq.|Service Scope|GRI Group Seq.|GRI Rate Seq.|Per|Cargo Type|Currency|GRI Amount|Percentage(%)";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_rt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Float",     Hidden:0,  Width:210,  Align:"Right",   ColMerge:0,   SaveName:"gri_rt_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
			{Type:"Int",       Hidden:0,  Width:210,  Align:"Right",   ColMerge:0,   SaveName:"gri_rt_rto",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetEllipsis(1);
			SetCountPosition(0);
			SetShowButtonImage(2);
			resizeSheet(); //SetSheetHeight(102);
			}
			break;

        case "sheet3":  // Grid 1's Commodity Group
			with(sheetObj){
			
			var HeadTitle="3-1|3-2|3-3|3-4|3-5|3-6|3-7|3-8|3-9";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;

        case "sheet4":  // Grid 1's Actual Customer
			with(sheetObj){
			
			
			var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;

        case "sheet5":  // Grid 1's Origin Point
			with(sheetObj){
			
			var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;
			
        case "sheet6":  // Grid 2's Origin Via.
			with(sheetObj){
			
			var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;

        case "sheet7":  // Grid 1's Destination Via.
			with(sheetObj){
			
			var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;

        case "sheet8":  // Grid 1's Destination Point
			with(sheetObj){
			
			
			var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
			SetSheetHeight(100);
        	}
			break;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[1]);
    }
    
	/**
	 * calling function when occurring OnBeforeCheck Event <br>
	 */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
        }
    }
	/**
	 * calling function when occurring OnBeforeCheck Event <br>
	 */
    function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
        }
    }
	/**
	 * calling function when occurring OnChange Event <br>
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "gri_appl_div_cd") {
        	if (sheetObjects[0].GetCellEditable(Row, "gri_appl_div_cd")) {
        		toggleButtons("INIT");
        	}
        }
    }
	/**
	 * calling function when occurring OnChange Event <br>
	 */
    function sheet2_OnChange(sheetObj, Row, Col, Value) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
            	var validPerClass="A,F,O,Q,S,P";
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
	 * calling function when occurring OnSelectCell Event <br>
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(OldRow, NewRow, OldCol, NewCol, IBSEARCH);
		toggleButtons("INIT");
	}
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.cmdt_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "prc_cmdt_def_nm");
                sStr += "\n";
                document.form.cmdt_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.actcust_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "cust_lgl_eng_nm");
                sStr += "\n";
                document.form.actcust_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.origin_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermOrg[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
                sStr += "\n";
                document.form.origin_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.ovia_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
                document.form.ovia_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.dvia_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
                document.form.dvia_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnSearchEnd Event <br>
	 */
    function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
        	document.form.dest_desc.value="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	var sStr="";
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermDest[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
                sStr += "\n";
                document.form.dest_desc.value += sStr;
            }
        }
    }
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        var sUrl1="/opuscntr/ESM_PRI_2081.do?" + FormQueryString(document.form);
        var sUrl2="/opuscntr/ESM_PRI_2086.do?" + FormQueryString(document.form);
        if (colName == "prc_cmdt_def_nm") {
        	sUrl1 += "&cmdt_actcust_tp_cd=C";
            ComOpenPopup(sUrl1, 700, 340, "findCommodity", "1,0,1,1,1,1,1", true);
        }
        if (colName == "cust_lgl_eng_nm") {
        	sUrl1 += "&cmdt_actcust_tp_cd=A";
        	 ComOpenPopup(sUrl1, 700, 340, "findCommodity", "1,0,1,1,1,1,1", true);
        }
        if (colName == "org_rout_pnt_loc_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
        	ComOpenPopup(sUrl2, 700, 340, "findLocation", "1,0,1,1,1,1,1", true);
        }
        if (colName == "org_rout_via_port_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
        	ComOpenPopup(sUrl2, 700, 340, "findLocation", "1,0,1,1,1,1,1", true);
        }
        if (colName == "dest_rout_via_port_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
        	ComOpenPopup(sUrl2, 700, 340, "findLocation", "1,0,1,1,1,1,1", true);
        }
        if (colName == "dest_rout_pnt_loc_def_nm") {
        	sUrl2 += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
        	ComOpenPopup(sUrl2, 700, 340, "findLocation", "1,0,1,1,1,1,1", true);
        }
    }
    function findCommodity(rtnVal) {
    	var sheetObj = sheetObjects[0];
    	setSheet1RowData(sheetObj, sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
   }
    function findLocation(rtnVal) {
    	var sheetObj = sheetObjects[0];
    	setSheet2RowData(sheetObj, sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
   }
	/**
	 * setting Sheet1 to modified data from pop-up <br>
	 */
    function setSheet1RowData(sheetObj, Row, Col) {
    	var formObj=document.form;
    	var prevStatus=sheetObj.GetRowStatus(Row);
        var sNm;
        var sCd;
        sCd="";
        sNm="";
        for (var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow(); i++) {
        	if (sheetObjects[2].GetRowStatus(i) == "D") {
                continue;
            }
        	sCd += "|" + sheetObjects[2].GetCellValue(i, "prc_cmdt_def_cd");
        	sNm += sheetObjects[2].GetCellValue(i, "prc_cmdt_def_nm") + " / ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf("/");
        	sNm=sNm.substring(0, lastIdx - 1);
        }
        sheetObj.SetCellValue(Row, "prc_cmdt_def_cd",sCd,0);
        sheetObj.SetCellValue(Row, "prc_cmdt_def_nm",sNm,0);
        sCd="";
        sNm="";
        for (var i=sheetObjects[3].HeaderRows(); i <= sheetObjects[3].LastRow(); i++) {
        	if (sheetObjects[3].GetRowStatus(i) == "D") {
                continue;
            }
        	sCd += "|" + sheetObjects[3].GetCellValue(i, "cust_cnt_cd") + sheetObjects[3].GetCellValue(i, "cust_seq");
        	sNm += sheetObjects[3].GetCellValue(i, "cust_lgl_eng_nm") + " / ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf("/");
        	sNm=sNm.substring(0, lastIdx - 1);
        }
        sheetObj.SetCellValue(Row, "cust_seq",sCd,0);
        sheetObj.SetCellValue(Row, "cust_lgl_eng_nm",sNm,0);
        sheetObj.SetRowStatus(Row,prevStatus);
    }
	/**
	 * setting Sheet2 to modified data from pop-up <br>
	 */
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj=document.form;
        var prevStatus=sheetObj.GetRowStatus(Row);
        var sCd;
        var sNm;
        sCd="";
        sNm="";
        for (var i=sheetObjects[4].HeaderRows(); i <= sheetObjects[4].LastRow(); i++) {
        	if (sheetObjects[4].GetRowStatus(i) == "D") {
                continue;
            }
        	var sStr="";
        	sStr += sheetObjects[4].GetCellValue(i, "rout_pnt_loc_def_cd");
        	if (sheetObjects[4].GetCellValue(i, "rcv_de_term_cd") != null && sheetObjects[4].GetCellValue(i, "rcv_de_term_cd") != "") {
        		sStr += "(" + arrTermOrg[sheetObjects[4].GetCellValue(i, "rcv_de_term_cd")] + ")";
            }
            sCd += "|" + sStr;
            sNm += sStr + ", ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf(",");
        	sNm=sNm.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd",sCd,0);
        sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_nm",sNm,0);
        sCd="";
        sNm="";
        for (var i=sheetObjects[5].HeaderRows(); i <= sheetObjects[5].LastRow(); i++) {
        	if (sheetObjects[5].GetRowStatus(i) == "D") {
                continue;
            }
        	sCd += "|" + sheetObjects[5].GetCellValue(i, "rout_via_port_def_cd");
        	sNm += sheetObjects[5].GetCellValue(i, "rout_via_port_def_cd") + ", ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf(",");
        	sNm=sNm.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "org_rout_via_port_def_cd",sCd,0);
        sheetObj.SetCellValue(Row, "org_rout_via_port_def_nm",sNm,0);
        sCd="";
        sNm="";
        for (var i=sheetObjects[6].HeaderRows(); i <= sheetObjects[6].LastRow(); i++) {
        	if (sheetObjects[6].GetRowStatus(i) == "D") {
                continue;
            }
        	sCd += "|" + sheetObjects[6].GetCellValue(i, "rout_via_port_def_cd");
        	sNm += sheetObjects[6].GetCellValue(i, "rout_via_port_def_cd") + ", ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf(",");
        	sNm=sNm.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "dest_rout_via_port_def_cd",sCd,0);
        sheetObj.SetCellValue(Row, "dest_rout_via_port_def_nm",sNm,0);
        sCd="";
        sNm="";
        for (var i=sheetObjects[7].HeaderRows(); i <= sheetObjects[7].LastRow(); i++) {
        	if (sheetObjects[7].GetRowStatus(i) == "D") {
                continue;
            }
        	var sStr="";
        	sStr += sheetObjects[7].GetCellValue(i, "rout_pnt_loc_def_cd");
        	if (sheetObjects[7].GetCellValue(i, "rcv_de_term_cd") != null && sheetObjects[7].GetCellValue(i, "rcv_de_term_cd") != "") {
        		sStr += "(" + arrTermDest[sheetObjects[7].GetCellValue(i, "rcv_de_term_cd")] + ")";
            }
            sCd += "|" + sStr;
            sNm += sStr + ", ";
        }
        if (sNm != "") {
        	var lastIdx=sNm.lastIndexOf(",");
        	sNm=sNm.substring(0, lastIdx);
        }
        sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd",sCd,0);
        sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_nm",sNm,0);
        sheetObj.SetRowStatus(Row,prevStatus);
    }
	var isFiredNested=false;
	var supressConfirm=false;
	/**
	 * calling function when changing row in sheet <br>
	 */
	function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
            	&& (sheetObjects[0].IsDataModified()
                    || sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[3].IsDataModified()
                    || sheetObjects[4].IsDataModified()
                    || sheetObjects[5].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified())) {
                isFiredNested=true;
                sheetObjects[0].SelectCell(OldRow, OldCol, false);
                isFiredNested=false;
                var rslt=false;
                if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm=true;
                    adjNewRow = Math.max(NewRow - sheetObjects[0].RowCount("D"), sheetObjects[0].HeaderRows());
                    rslt=doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                    supressConfirm=false;
                }
                if (rslt) {
                    isFiredNested=true;
                    sheetObjects[0].SelectCell(adjNewRow, NewCol, false);
                    isFiredNested=false;
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
            	LoadingComplete=false;
            	formObj.gri_grp_seq.value=sheetObjects[0].GetCellValue(NewRow, "gri_grp_seq");
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
				setFltPctTpCd(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "flt_pct_tp_cd"));
				LoadingComplete=true;
            }
		}
	}
	/**
	 * Handling sheet process <br>
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH_ASYNC02: // OK. GRI Apply
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00014")) {
	            	return false;
	            }
	            for (var i = sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount() > 0 && i <= sheetObjects[0].LastRow(); i++) {
	            	sheetObjects[0].SetCellValue(i, "gri_appl_flg","Y",0);
	            }
	            formObj.f_cmd.value=MODIFY01;
	            var sParam=FormQueryString(formObj);
	            var sParamSheet1=sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_2033GS.do", sParam);
 	            sheetObj.LoadSaveData(sXml);
	            if (sheetObjects[0].IsDataModified()) {
	                for (var i = sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount() > 0 && i <= sheetObjects[0].LastRow(); i++) {
	                	sheetObjects[0].SetCellValue(i, "gri_appl_flg","N",0);
	                }
	            	return false;
	            } else {
	                if (sheetObjects[0].RowCount() > 0) {
	                	formObj.gri_appl_flg.value=sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "gri_appl_flg");
	                }
	                toggleButtons("INIT");
	                ComShowCodeMessage("PRI00114");
	                ComClosePopup(); 
	                opener.saveCurRowPos();
	            	opener.reloadPagePostTr();
	            }
	            break;
	        case IBSEARCH_ASYNC03: // CANCEL
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00015")) {
	            	return false;
	            }
	            // deleting all existing GRI when canceling. 2009-07-29.
	            for (var i = sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount() > 0 && i <= sheetObjects[0].LastRow(); i++) {
	            	sheetObjects[0].SetCellValue(i, "chk","1",0);
	            }
	            for (var i = sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount() > 0 && i <= sheetObjects[1].LastRow(); i++) {
	            	sheetObjects[1].SetCellValue(i, "chk","1",0);
	            }
	        	deleteRowCheck(sheetObjects[0], "chk");
	        	deleteRowCheck(sheetObjects[1], "chk");
	            document.form.cmdt_desc.value="";
	            document.form.actcust_desc.value="";
	            document.form.origin_desc.value="";
	            document.form.ovia_desc.value="";
	            document.form.dvia_desc.value="";
	            document.form.dest_desc.value="";
	            formObj.f_cmd.value=MODIFY02;
	            var sParam=FormQueryString(formObj);
	            var sParamSheet1=sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_2033GS.do", sParam);
	            sheetObj.LoadSaveData(sXml);
	            if (sheetObjects[0].IsDataModified()) {
	            	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	            	return false;
	            } else {
	                if (sheetObjects[0].RowCount() > 0) {
	                	formObj.gri_appl_flg.value=sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "gri_appl_flg");
	                }
	                toggleButtons("INIT");
	            	ComShowCodeMessage("PRI00115");
	            	ComClosePopup(); 
	                opener.saveCurRowPos();
	            	opener.reloadPagePostTr();
	            }
	            break;
	        case IBCLEAR: 
	            var sXml="";
	            //common GRI Application Division
	            formObj.f_cmd.value=SEARCH19;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01706");
	            setIBCombo(sheetObjects[0], sXml, "gri_appl_div_cd", true, 0);
	            // per combo
	            formObj.f_cmd.value=SEARCH03;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", false, 0, "D2");
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
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02138");
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				for (var i=0; i < arrTemp.length; i++) {
					arrTermOrg[arrTemp[i][0]]=arrTemp[i][1];
				}
				//common Term Destination
				formObj.f_cmd.value=SEARCH19;
 				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD02139");
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				for (var i=0; i < arrTemp.length; i++) {
					arrTermDest[arrTemp[i][0]]=arrTemp[i][1];
				}
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
	                document.form.cmdt_desc.value="";
	                document.form.actcust_desc.value="";
	                document.form.origin_desc.value="";
	                document.form.ovia_desc.value="";
	                document.form.dvia_desc.value="";
	                document.form.dest_desc.value="";
	                formObj.f_cmd.value=SEARCH01;
 	                var sXml = sheetObj.DoSearch("ESM_PRI_2033GS.do", FormQueryString(formObj),{Sync:2});
	                if (sheetObj.RowCount() > 0) {
	                	formObj.gri_appl_flg.value=sheetObj.GetCellValue(sheetObj.HeaderRows(), "gri_appl_flg");
	                }
	                toggleButtons("INIT");
	            } else if (sheetObj.id == "sheet2") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH02;
 	                var sXml=sheetObj.GetSearchData("ESM_PRI_2033GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[3].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[5].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[6].LoadSearchData(arrXml[5],{Sync:1} );
	                if (arrXml.length > 6) sheetObjects[7].LoadSearchData(arrXml[6],{Sync:1} );
	            }
	            break;
	        case IBSAVE: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=MULTI01;
	            var sParam=FormQueryString(formObj);
	            var sParamSheet1=sheetObjects[0].GetSaveString();
	            if (sParamSheet1 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }
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
	            var sParamSheet8=sheetObjects[7].GetSaveString();
	            if (sParamSheet8 != "") {
	                sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
	            }
	            if (!supressConfirm && !ComPriConfirmSave()) {
	                return false;
	            }
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_2033GS.do", sParam);
 	            sheetObjects[7].LoadSaveData(sXml);
 	            sheetObjects[6].LoadSaveData(sXml);
 	            sheetObjects[5].LoadSaveData(sXml);
 	            sheetObjects[4].LoadSaveData(sXml);
 	            sheetObjects[3].LoadSaveData(sXml);
 	            sheetObjects[2].LoadSaveData(sXml);
 	            sheetObjects[1].LoadSaveData(sXml);
 	            sheetObjects[0].LoadSaveData(sXml);
	            if (sheetObjects[0].IsDataModified()
	            		|| sheetObjects[1].IsDataModified()
	            		|| sheetObjects[2].IsDataModified()
	            		|| sheetObjects[3].IsDataModified()
	            		|| sheetObjects[4].IsDataModified()
	            		|| sheetObjects[5].IsDataModified()
	            		|| sheetObjects[6].IsDataModified()
	            		|| sheetObjects[7].IsDataModified()) {
	                return false;
	            } else {
	            	toggleButtons("INIT");
	                ComPriSaveCompleted();
	                return true;
	            }
	            break;
	        case IBINSERT: // Row Add
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                var idx=doRowChange(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gri_grp_seq",parseInt(ComPriGetMax(sheetObj, "gri_grp_seq")) + 1);
	                sheetObj.SetCellValue(idx, "gri_appl_flg","N");
	                sheetObj.SetCellValue(idx, "flt_pct_tp_cd",getFltPctTpCd());
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.gri_grp_seq.value=sheetObj.GetCellValue(idx, "gri_grp_seq");
	                formObj.gri_appl_flg.value=sheetObj.GetCellValue(idx, "gri_appl_flg");
	                document.form.cmdt_desc.value="";
	                document.form.actcust_desc.value="";
	                document.form.origin_desc.value="";
	                document.form.ovia_desc.value="";
	                document.form.dvia_desc.value="";
	                document.form.dest_desc.value="";
	                sheetObj.SelectCell(idx, "gri_appl_div_cd", false);
	            }
	            if (sheetObj.id == "sheet2") {
	            	if (!sheetObjects[0].GetCellEditable(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd")) {
	            		return false;
	            	}
	                var idx=sheetObj.DataInsert();
	                sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	                sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gri_grp_seq",formObj.gri_grp_seq.value);
	                sheetObj.SetCellValue(idx, "gri_rt_seq",parseInt(ComPriGetMax(sheetObj, "gri_rt_seq")) + 1);
	                sheetObj.SetCellValue(idx, "curr_cd","USD");
	                sheetObj.SetCellValue(idx, "rat_ut_cd","D4");
	                setFltPctEnable();
	                sheetObj.SelectCell(idx, "rat_ut_cd", false);
	            }
	            break;
	        case IBCOPYROW: // Row Copy
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                var idx=doRowChange(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                var newGriGrpSeq=parseInt(ComPriGetMax(sheetObj, "gri_grp_seq")) + 1;
	                sheetObj.SetCellValue(idx, "gri_grp_seq",newGriGrpSeq);
	                for (var a=1; a < sheetObjects.length; a++) {
	                	if (sheetObjects[a].RowCount() <= 0) {
	                		continue;
	                	}
	                    for (var i=sheetObjects[a].LastRow(); i >= sheetObjects[a].HeaderRows(); i--) {
	                    	if (sheetObjects[a].GetRowStatus(i) == "D") {
	                    		continue;
	                    	}
	                        sheetObjects[a].SetCellValue(i, "gri_grp_seq",newGriGrpSeq);
	                        sheetObjects[a].SetRowStatus(i,"I");
	                    }
	                }
	            }
	            break;
	        case IBDELETE: // Delete
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	        	if (sheetObj.id == "sheet2" && !sheetObj.GetEditable()) {
	        		return false;
	        	}
	        	var prevCmdtHdrSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	        	if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
				}
	            var delCnt=deleteRowCheck(sheetObj, "chk");
	            if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                document.form.cmdt_desc.value="";
	                document.form.actcust_desc.value="";
	                document.form.origin_desc.value="";
	                document.form.ovia_desc.value="";
	                document.form.dvia_desc.value="";
	                document.form.dest_desc.value="";
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
	 * checking validation process of inputed form data <br>
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC02: // OK
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (getValidRowCount(sheetObjects[0]) <= 0) {
        		return false;
        	}
        	// in case of already Applied GRI Calc.
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	// in case of "Include" is null
    		var incIdx=sheetObjects[0].FindText("gri_appl_div_cd", "Include");
    		if (incIdx < 0) {
        		ComShowCodeMessage("PRI00348");
        		return false;
    		}
        	// in case of existing not saved sheet after changing
        	for (var i=0; i < sheetObjects.length; i++) {
        		if (sheetObjects[i].IsDataModified()) {
                    ComShowCodeMessage("PRI08015");
                    return false;
        		}
        	}
            return true;
            break;
        case IBSEARCH_ASYNC03: // CANCEL
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (getValidRowCount(sheetObjects[0]) <= 0) {
        		return false;
        	}
        	//  in case of already not Applied GRI Calc.
        	if (formObj.gri_appl_flg.value == "N") {
        		return false;
        	}
        	// in case of existing not saved sheet after changing
        	for (var i=0; i < sheetObjects.length; i++) {
        		if (sheetObjects[i].IsDataModified()) {
                    ComShowCodeMessage("PRI08015");
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
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
            if (!sheetObjects[0].IsDataModified()
                    && !sheetObjects[1].IsDataModified()
                    && !sheetObjects[2].IsDataModified()
                    && !sheetObjects[3].IsDataModified()
                    && !sheetObjects[4].IsDataModified()
                    && !sheetObjects[5].IsDataModified()
                    && !sheetObjects[6].IsDataModified()
                    && !sheetObjects[7].IsDataModified()) {
                ComShowCodeMessage("PRI00301");
                return false;
            }
            // not existing Rate, in case of Group didn't delete
            if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
            	&& sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd") == "I"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				ComShowCodeMessage("PRI00007");
				return false;
			}
            if (sheetObjects[0].IsDataModified()
                    && sheetObjects[0].GetSaveString() == "") {
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
            if (sheetObjects[7].IsDataModified()
                    && sheetObjects[7].GetSaveString() == "") {
                return false;
            }
			var rowM=sheetObjects[0].ColValueDup("gri_appl_div_cd|prc_cmdt_def_nm|cust_lgl_eng_nm|org_rout_pnt_loc_def_cd|org_rout_via_port_def_cd|dest_rout_via_port_def_cd|dest_rout_pnt_loc_def_cd", false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00302");
				return false;
			}
			var rowS=sheetObjects[1].ColValueDup("rat_ut_cd|prc_cgo_tp_cd|curr_cd", false);
			if (rowS >= 0) {
				ComShowCodeMessage("PRI00302");
				return false;
			}
			// checking mandatory GRI Amount or Ratio
            for (var i = sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount() > 0 && i <= sheetObjects[1].LastRow(); i++) {
                if (getFltPctTpCd() == "F" 
                	&& (sheetObjects[1].GetCellValue(i, "gri_rt_amt") == 0.00
                			|| sheetObjects[1].GetCellValue(i, "gri_rt_amt") == "")) {
                	sheetObjects[1].SelectCell(i, "gri_rt_amt", false);
                    ComShowCodeMessage("PRI00316", "GRI Amount");
                    return false;
                }
                if (getFltPctTpCd() == "P" 
                	&& (sheetObjects[1].GetCellValue(i, "gri_rt_rto") == 0
                			|| sheetObjects[1].GetCellValue(i, "gri_rt_rto") == "")) {
                	sheetObjects[1].SelectCell(i, "gri_rt_rto", false);
                    ComShowCodeMessage("PRI00316", "Percentage");
                    return false;
                }
            }
            return true;
            break;
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	if (sheetObj.id == "sheet1") {
            } else if (sheetObj.id == "sheet2") {
                if (sheetObjects[0].RowCount() <= 0 || sheetObjects[0].GetSelectRow() <= 0) {
                    return false;
                }
                // can not adding Rate in case of Group = "Exclude"
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd") == "E") {
                	return false;
                }
            }
            return true;
            break;
        case IBCOPYROW: // Row Copy
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
            if (sheetObj.RowCount() <= 0 || sheetObj.SelectRow() <= 0) {
                return false;
            }
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.gri_appl_flg.value == "Y") {
        		return false;
        	}
        	if (sheetObj.RowCount() <= 0) {
        		return false;
        	}
        	return true;
            break;
        }
    }
    function getFltPctTpCd() {
        for (var i=0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].checked) {
                return document.form.flt_pct_tp_cd[i].value;
            }
        }
    }
    function getFltPctTpChecked() {
        for (var i=0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].checked) {
                return i;
            }
        }
    }
    function setFltPctTpCd(code) {
        for (var i=0; i < document.form.flt_pct_tp_cd.length; i++) {
            if (document.form.flt_pct_tp_cd[i].value == code) {
            	document.form.flt_pct_tp_cd[i].checked=true;
            	setFltPctEnable();
            	break;
            }
        }
    }
	/**
	 * setting Amount and Ratio Enable or not, based on Radio Button [flt_pct_tp_cd] value
	 */
    function setFltPctEnable() {
    	var fltPctTpCd=getFltPctTpCd();
    	if (sheetObjects[0].RowCount() > 0) {
    		sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "flt_pct_tp_cd",fltPctTpCd,0);
    	}
    	if (sheetObjects[1].RowCount() > 0) {
	    	for (var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
	        	if (fltPctTpCd == "F") {
	        		sheetObjects[1].SetCellValue(i, "gri_rt_rto","",0);
	        		sheetObjects[1].SetCellEditable(i, "gri_rt_rto",0);
	        		sheetObjects[1].SetCellEditable(i, "gri_rt_amt",1);
	        	} else if (fltPctTpCd == "P") {
	        		sheetObjects[1].SetCellValue(i, "gri_rt_amt","",0);
	        		sheetObjects[1].SetCellEditable(i, "gri_rt_amt",0);
	        		sheetObjects[1].SetCellEditable(i, "gri_rt_rto",1);
	        	}
	    	}
    	}
    }
	/**
	 * getting Sheet Data in XML type <br>
	 */
    function getSheetXml(sheetNo) {
        var sXml=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
	/**
	 * getting Sheet Data in XML type <br>
	 */
    function setSheetXml(sXml, sheetNo) {
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml);
    }
	/**
	 * handling all buttons Enalbe/Disable <br>
	 */
    function toggleButtons(mode) {
        switch (mode) {
        case "CLEAR":
            disableButton("btn_ok");
            disableButton("btn_cancel");
            sheetObjects[0].SetCountFormat("[Apply : No]");
        	//sheetObjects[0].Editable = false;
            setSheetEditable(sheetObjects[0], false);
        	sheetObjects[1].SetEditable(0);
        	document.form.flt_pct_tp_cd[0].disabled=true;
        	document.form.flt_pct_tp_cd[1].disabled=true;
            break;
        case "INIT":
        	if (sheetObjects[0].RowCount() > 0 && document.form.gri_appl_flg.value == "Y") {
        		disableButton("btn_ok");
            	enableButton("btn_cancel");
            	sheetObjects[0].SetCountFormat("[Apply : Yes]");
            	//sheetObjects[0].Editable = false;
            	setSheetEditable(sheetObjects[0], false);
            	sheetObjects[1].SetEditable(0);
            	document.form.flt_pct_tp_cd[0].disabled=true;
            	document.form.flt_pct_tp_cd[1].disabled=true;
        	} else if (sheetObjects[0].RowCount() > 0 && document.form.gri_appl_flg.value == "N") {
            	enableButton("btn_ok");
            	disableButton("btn_cancel");
            	sheetObjects[0].SetCountFormat("[Apply : No]");
            	setSheetEditable(sheetObjects[0], true);
            	if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd") == "E") {
        			for (var i = sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount() > 0 && i <= sheetObjects[1].LastRow(); i++) {
        				sheetObjects[1].SetRowHidden(i,1);
        				sheetObjects[1].SetRowStatus(i,"D");
        			}
                	sheetObjects[1].SetEditable(0);
                	document.form.flt_pct_tp_cd[0].disabled=true;
                	document.form.flt_pct_tp_cd[1].disabled=true;
        		} else {
                	sheetObjects[1].SetEditable(1);
                	document.form.flt_pct_tp_cd[0].disabled=false;
                	document.form.flt_pct_tp_cd[1].disabled=false;
        		}
        	} else {
        		disableButton("btn_ok");
        		disableButton("btn_cancel");
        		sheetObjects[0].SetCountFormat("[Apply : No]");
        		setSheetEditable(sheetObjects[0], true);
        		if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd") == "E") {
        			for (var i = sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount() > 0 && i <= sheetObjects[1].LastRow(); i++) {
        				sheetObjects[1].SetRowHidden(i,1);
        				sheetObjects[1].SetRowStatus(i,"D");
        			}
                	sheetObjects[1].SetEditable(0);
                	document.form.flt_pct_tp_cd[0].disabled=true;
                	document.form.flt_pct_tp_cd[1].disabled=true;
        		} else {
                	sheetObjects[1].SetEditable(1);
                	document.form.flt_pct_tp_cd[0].disabled=false;
                	document.form.flt_pct_tp_cd[1].disabled=false;
        		}
        	}
            break;
        case "READONLY":
    		disableButton("btn_ok");
    		disableButton("btn_cancel");
    		sheetObjects[0].SetCountFormat("[Apply : No]");
    		setSheetEditable(sheetObjects[0], false);
    		if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "gri_appl_div_cd") == "E") {
    			for (var i = sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount() > 0 && i <= sheetObjects[1].LastRow(); i++) {
    				sheetObjects[1].SetRowHidden(i,1);
    				sheetObjects[1].SetRowStatus(i,"D");
    			}
            	sheetObjects[1].SetEditable(0);
            	document.form.flt_pct_tp_cd[0].disabled=true;
            	document.form.flt_pct_tp_cd[1].disabled=true;
    		} else {
            	sheetObjects[1].SetEditable(1);
            	document.form.flt_pct_tp_cd[0].disabled=false;
            	document.form.flt_pct_tp_cd[1].disabled=false;
    		}
            break;
        }
    }
	/**
	 * opening pop-up in sheet's ReadOnly mode , not changing dtPopup column to Disable mode
	 */
    function setSheetEditable(sheetObj, flag) {
    	for (var i = sheetObj.HeaderRows(); sheetObj.RowCount() > 0 && i <= sheetObj.LastRow(); i++) {
			for (var j=0; j <= sheetObj.LastCol(); j++) {
		if (sheetObj.GetCellProperty(i, j, dpDataType)== dtPopup) {
					continue;
				}
				sheetObj.SetCellEditable(i, j,flag);
			}
    	}
    }