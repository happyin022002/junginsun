/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0112.js
*@FileTitle  : GRI Calculation Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class Guideline Creation :business script for Guideline Creation 
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
    var LoadingComplete=false;
    var arrTermOrg=new Array();
    var arrTermDest=new Array();
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    

//다음의 화면들에서 호출됨
//ESM_PRI_0004_09
//ESM_PRI_0057_06
    
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
			case "btn_close":
				ComClosePopup(); 
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
        document.form.flt_pct_tp_cd[0].checked=true;
        doActionIBSheet(sheetObjects[1], document.form, IBCLEAR);
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
        case "sheet1":  // Grid 1
            with(sheetObj){
		          var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|GRI Group Seq.|Flat Percent Type Code|Application|GRI Application Flag|prc_cmdt_def_cd|Commodity Group|cust_seq|Actual Customer|origin|Origin|ovia|O.Via|dvia|D.Via|dest|Dest.";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"flt_pct_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"gri_appl_div_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_appl_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:290,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Popup",     Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		          if (document.form.gen_spcl_rt_tp_cd.value == "G") {
		            	SetColHidden("cust_lgl_eng_nm",1);
		            	SetColWidth("prc_cmdt_def_nm",400);
		          }
		          InitColumns(cols);
		          SetEditable(0);
		          SetEllipsis(1);
		          SetShowButtonImage(0);
//		          SetCountFormat("[ ]");
		          SetCountPosition(0);
		          SetSheetHeight(150);
        		}
            break;
            
        case "sheet2":  // Grid 2
            with(sheetObj){
		          var HeadTitle="|Seq.|Proposal No.|Amendent Seq.|Service Scope|Rate Type|GRI Group Seq.|GRI Rate Seq.|Per|Cargo Type|Currency|GRI Amount|Percentage(%)";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_grp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gri_rt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:210,  Align:"Right",   ColMerge:0,   SaveName:"gri_rt_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
		                 {Type:"Int",       Hidden:0,  Width:210,  Align:"Right",   ColMerge:0,   SaveName:"gri_rt_rto",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
		          InitColumns(cols);
		          SetEditable(0);
		          SetEllipsis(1);
		          SetShowButtonImage(0);
		          SetCountPosition(0);
		          SetSheetHeight(150);
          		}
            break;
            
        case "sheet3":  // Grid 1: Commodity Group
            with(sheetObj){
		          var HeadTitle="3-1|3-2|3-3|3-4|3-5|3-6|3-7|3-8|3-9|3-10";
		          var headCount=ComCountHeadTitle(HeadTitle);
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100, 1);
                }
            break;
            
        case "sheet4":  // Grid 1: Actual Customer
            with(sheetObj){
		         var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10";
		         var headCount=ComCountHeadTitle(HeadTitle);
		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cust_lgl_eng_nm",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(100, 1);
                  }
            break;
            
        case "sheet5":  // Grid 1: Origin Point
            with(sheetObj){
		         var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12";
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
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(100, 1);
              }
            break;
            
        case "sheet6":  // Grid 2: Origin Via.
            with(sheetObj){
		        var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
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
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetSheetHeight(100, 1);
			}
            break;
            
        case "sheet7":  // Grid 1: Destination Via.
            with(sheetObj){
		          var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_via_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100, 1);
                }
            break;
            
        case "sheet8":  // Grid 1: Destination Point
            with(sheetObj){
		          var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12";
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_grp_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gri_rout_pnt_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100, 1);
                }
            break;
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(OldRow, NewRow, OldCol, NewRow, IBSEARCH);
	}
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
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
	var isFiredNested=false;
	var supressConfirm=false;
	/**
	 * Handling events in case of changing row on sheet. <br>
	 * <br><b>Example :</b>
	 * <pre>
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
	function doRowChange(OldRow, NewRow, OldCol, NewRow, sAction) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetObjects[0].IsDataModified()
                    || sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[3].IsDataModified()
                    || sheetObjects[4].IsDataModified()
                    || sheetObjects[5].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()) {
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
            	formObj.gri_grp_seq.value=sheetObjects[0].GetCellValue(NewRow, "gri_grp_seq");
				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
				setFltPctTpCd(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "flt_pct_tp_cd"));
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
        	 var objEvt = ComGetEvent();
        	 if (ComGetEvent() == null || $(objEvt).attr('suppressWait') != "Y") {
                ComOpenWait(true);
            }
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBCLEAR: // when loading
	            var sXml="";
	            //common GRI Application Division
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01706");
	            setIBCombo(sheetObjects[0], sXml, "gri_appl_div_cd", true, 0);
	            // per combo
	            formObj.f_cmd.value=SEARCH03;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            setIBCombo(sheetObj, sXml, "rat_ut_cd", true, 0);
	            //common cargo
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01701");
	            setIBCombo(sheetObj, sXml, "prc_cgo_tp_cd", true, 0);
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
	                var sXml = sheetObj.DoSearch("ESM_PRI_0112GS.do", FormQueryString(formObj), {Sync:2} );
	                if (sheetObj.RowCount() > 0) {
	                	formObj.gri_appl_flg.value=sheetObj.GetCellValue(sheetObj.HeaderRows(), "gri_appl_flg");
	                	if (document.form.gri_appl_flg.value == "Y") {
	                    	sheetObjects[0].SetCountFormat("[Apply : Yes]");
	                	} else if (document.form.gri_appl_flg.value == "N") {
	                    	sheetObjects[0].SetCountFormat("[Apply : No]");
	                	}
	                }
	            } else if (sheetObj.id == "sheet2") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH02;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0112GS.do" , FormQueryString(formObj));
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
        case IBSEARCH: 
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
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
            	break;
            }
        }
    }