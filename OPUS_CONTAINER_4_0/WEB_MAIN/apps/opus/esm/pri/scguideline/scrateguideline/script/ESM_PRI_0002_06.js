/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_06.js
 *@FileTitle  : Rate Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06  
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class Guideline Creation :business script for Guideline Creation
     */
    // Common Global variable
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
    var isOViaMandatory=false;
    var isDViaMandatory=false;
    var isDirCallVisible = false;
    var isDirCallSetVisible = false;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
	/**
	 * Event handler processing by button name <br>
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
            case "btn_downexcel":
            	/*if(sheetObjects[9].RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{*/
            		doActionIBSheet(sheetObjects[9], document.form, IBDOWNEXCEL);
            	/*}*/               
                break;
            case "prc_cust_tp_cd":
                if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
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
	 * adding process for list in case of needing batch processing with other items  <br>
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
    	 
//    	 var opener=window.dialogArguments;
//    	 if (!opener)  opener=window.opener;  //이 코드 추가할것
//    	 if (!opener) opener=parent; //이 코드 추가할것 
    	 parent.loadTabPage();
    }
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
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
	          var HeadTitle="|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Commodity Code|Description|EFF Date|EXP Date";
	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck",  Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",         Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
		                 {Type:"Text",        Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",        Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",        Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",        Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Popup",       Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",        Hidden:0, Width:500,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",        Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",        Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          InitColumns(cols);
	          SetEditable(1);
	          SetEllipsis(1);
	          SetImageList(0,"img/btns_calendar.gif");
	          SetShowButtonImage(2);
	          SetSheetHeight(122);
          }
        break;
        

        case "sheet2":  // Grid 2

            with(sheetObj){
				var HeadTitle="|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Route Seq.|Origin|O.Via|D.Via|Dest.|Direct Call|Route Note|Note Tooltip";
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"CheckBox",  Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   HeaderCheck:0,    EditLen:-1 },
							{Type:"Popup",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"note_clss_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"note_tooltip",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
				SetEllipsis(1);
                SetShowButtonImage(2);
                SetSheetHeight(142);
        	}	
        break;
        

        case "sheet3":  // Grid 3

            with(sheetObj){
		          var HeadTitle="|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Route Seq.|Rate Seq.|Min|Max|Per|Cargo Type|Cur.|Rate|";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",       Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Combo",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",      Hidden:0, Width:150,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 } ];
		          
		          InitColumns(cols);
		          SetEditable(1);
		          SetEllipsis(1);
		          
		          //SetColProperty("rat_ut_cd", 		{ComboText:"|"+ratUtCdText, 	ComboCode:"|"+ratUtCdValue} );		             
		          //SetColProperty("prc_cgo_tp_cd", 	{ComboText:"|"+prcCgoTpCdText, 	ComboCode:"|"+prcCgoTpCdValue} );
		          //SetColProperty("curr_cd", 		{ComboText:"|"+currCdText, 		ComboCode:"|"+currCdValue} );
		          SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		          SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		          SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue, DefaultValue:"USD"} );
		          
		          SetColProperty(0 ,"mqc_rng_fm_qty" , {AcceptKeys:"N"});
		          SetColProperty(0 ,"mqc_rng_to_qty" , {AcceptKeys:"N"});
		          
		          SetShowButtonImage(2);
		          resizeSheet(); //SetSheetHeight(125);
        		}

		
            break;

        case "sheet4":  // Grid 1: Commodity  
            with(sheetObj){
		         var HeadTitle="4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9";
		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(100);
                  }


            break;
        case "sheet5":  // Grid 2: Origin Point

            with(sheetObj){
		          var HeadTitle="5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
		       }

            break;
        case "sheet6":  // Grid 2: Origin Via.

            with(sheetObj){
		          var HeadTitle="6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }

            break;
        case "sheet7":  // Grid 2: Destination Via.

            with(sheetObj){
		          var HeadTitle="7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }

            break;
        case "sheet8":  // Grid 2: Destination Point

            with(sheetObj){
		         var HeadTitle="8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11|8-12|8-13";
		         SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		         var headers = [ { Text:HeadTitle, Align:"Center"} ];
		         InitHeaders(headers, info);
		         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         InitColumns(cols);
		         SetEditable(1);
		         SetSheetHeight(100);
                  }


            break;

        case "sheet9":  // Grid 2's Rnote
            with(sheetObj){
		          var HeadTitle="9-1|9-2|9-3|9-4|9-5|9-6|9-7|9-8|9-9|9-10";
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }

            break;

        case "sheet10": // Sheet for Excel Download
            with(sheetObj){
		          var HeadTitle1="CMDT\nSeq|Commodity Group|Commodity Group|Route\nSeq|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|MQC|MQC|Rate(USD)|Rate(USD)|Rate(USD)";
		          var HeadTitle2="CMDT\nSeq|Code|Description|Route\nSeq|Code|Description|Term|Transmode|Code| Code |Code|Description|Term|Transmode|D.Call|Min|Max|PER|Cargo Type|Rate";
//		          var headCount=ComCountHeadTitle(HeadTitle2);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rout_dp_seq",                KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rcv_de_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_prc_trsp_mod_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_rcv_de_term_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dest_prc_trsp_mod_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }

            break;
        }
    }
    
    function resizeSheet() {
 	   	ComResizeSheet(sheetObjects[2]);
    }
    
    
    function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
    
    function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
    
    function sheet3_OnSort(sheetObj, Col, SortArrow  ) {
        sheetObj.ReNumberSeq();    
   }
	/**
	 * Calling function in case of OnSelectCell event <br>
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
        doRowChange1(OldRow, NewRow, OldCol, NewCol);
    }
	/**
	 * Calling function in case of OnSelectCell event <br>
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
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
   
    function sheet5_OnSearchEnd(sheetObj, Code,ErrMsg) {
        if (ErrMsg == "") {
            var sStr="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermOrg[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "\n";
            }
            document.form.origin_desc.value=sStr;
        }
    }
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet6_OnSearchEnd(sheetObj, Code,ErrMsg) {
        if (ErrMsg == "") {
            var sStr="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
            }
            document.form.ovia_desc.value=sStr;
        }
    }
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet7_OnSearchEnd(sheetObj, Code, ErrMsg) {
        if (ErrMsg == "") {
            var sStr="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_via_port_def_nm");
                sStr += "\n";
            }
            document.form.dvia_desc.value=sStr;
        }
    }
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet8_OnSearchEnd(sheetObj, Code,ErrMsg) {
        if (ErrMsg == "") {
            var sStr="";
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetRowStatus(i) == "D") {
                    continue;
                }
            	sStr += sheetObj.GetCellValue(i, "rout_pnt_loc_def_nm");
            	if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != null && sheetObj.GetCellValue(i, "rcv_de_term_cd") != "") {
            		sStr += "(" + arrTermDest[sheetObj.GetCellValue(i, "rcv_de_term_cd")] + ")";
                }
            	if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != null && sheetObj.GetCellValue(i, "prc_trsp_mod_cd") != "") {
            		sStr += "(" + arrTransMode[sheetObj.GetCellValue(i, "prc_trsp_mod_cd")] + ")";
                }
                sStr += "\n";
            }
            document.form.dest_desc.value=sStr;
        }
    }
	/**
	 * calling function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */
    function sheet10_OnSearchEnd(sheetObj, Code, ErrMsg) {
        if (ErrMsg == "") {
        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
        }
    }
	/**
	 * Calling function in case of OnPopupClick event <br>
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
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        if (colName == "prc_cmdt_def_cd") {
            var sUrl="ESM_PRI_0107.do?svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value;
            ComOpenPopup(sUrl,  700, 245, "", "none", true);
        }
    }
	/**
	 * Calling function in case of OnPopupClick event <br>
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
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        if (!LoadingComplete) {
            return;
        }
        var colName=sheetObj.ColSaveName(Col);
        var formObj=document.form;
        var sUrl="/opuscntr/ESM_PRI_0072.do?";
        var keyParam="svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&rout_seq=" + formObj.rout_seq.value;
        sUrl += keyParam;
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 700, 325, "", "none", true);
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 700, 325, "", "none", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 700, 325, "", "none", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 700, 325, "", "none", true);
        }
        if (colName == "note_clss_nm") {
            sUrl="/opuscntr/ESM_PRI_0105.do?";
            sUrl += keyParam;
            ComOpenPopup(sUrl, 600, 265, "", "none", true);
        }
    }
	/**
	 *Making information to show for tooltip by using note<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} sheetIdx Mandatory Sheet No
	 * @param {int} Row Mandatory ,Cell's Row Index
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function makeNoteTooltip(sheetObj, Row) {
    	var formObj=document.form;
        var sTooltip="";
        for (var i=sheetObjects[8].HeaderRows(); i <= sheetObjects[8].LastRow(); i++) {
    		if (sheetObjects[8].GetRowStatus(i) == "D") {
                continue;
            }
    		sTooltip += "<" + arrNoteClass[sheetObjects[8].GetCellValue(i, "note_clss_cd")] + ">\n";
    		sTooltip += "<" + sheetObjects[8].GetCellValue(i, "note_ctnt") + ">\n\n";
        }
        sheetObj.SetCellValue(Row, "note_tooltip",sTooltip,0);
        setRNoteTooltip(Row);
    }
    var isFiredNested=false;
    var supressConfirm=false;
	/**
	 * Function to handle event in case of changing row on sheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,process constant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange1(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[0].IsDataModified()|| sheetObjects[3].IsDataModified()) {
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
                    || sheetObjects[4].IsDataModified()
                    || sheetObjects[5].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()) {
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
	 * Function to handle event in case of changing row on sheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,process constant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function doRowChange2(OldRow, NewRow, OldCol, NewCol, sAction) {
        var formObj=document.form;
        var adjNewRow=NewRow;
        if (!isFiredNested && (OldRow != NewRow)) {
            if (sheetObjects[1].IsDataModified()
                    || sheetObjects[2].IsDataModified()
                    || sheetObjects[4].IsDataModified()
                    || sheetObjects[5].IsDataModified()
                    || sheetObjects[6].IsDataModified()
                    || sheetObjects[7].IsDataModified()
                    || sheetObjects[8].IsDataModified()) {
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
	 * Handling Sheet's process <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,process constant variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
	        sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH_ASYNC01: // Retrieving customer type when retrieving screen
	        	var prevChecked=getPrcCustTpChecked();
	            formObj.f_cmd.value=SEARCH20;
	            var sXml=sheetObj.GetSearchData("ESM_PRI_0002_06GS.do" , FormQueryString(formObj));
	            var arrData=ComPriXml2Array(sXml, "cd|nm|rate_cnt");
	            var sHTML="";
	            var firstMatch=-1;
	            for (var i=0; i < arrData.length; i++) {
	                sHTML += "<input name='prc_cust_tp_cd' value='" + arrData[i][0] + "' type='radio' class='trans'";
	                if (parseInt(arrData[i][2]) > 0) {
	                    if (firstMatch < 0) {
	                        firstMatch=i;
	                    }
	                    sHTML += "><b>" + arrData[i][1] + "</b>&nbsp;&nbsp;&nbsp;&nbsp;";
	                } else {
	                    sHTML += ">" + arrData[i][1] + "&nbsp;&nbsp;&nbsp;&nbsp;";
	                }
	            }
	            rdoCustTp.innerHTML=sHTML;
	            if (prevChecked != null && prevChecked != undefined && prevChecked >= 0 && parseInt(arrData[prevChecked][2]) > 0) {
	            	formObj.prc_cust_tp_cd[prevChecked].checked=true;
	            } else if (firstMatch >= 0) {
	            	formObj.prc_cust_tp_cd[firstMatch].checked=true;
	            } else {
	            	formObj.prc_cust_tp_cd[0].checked=true;
	            }
	            break;
	        case IBSEARCH_ASYNC20: // Retrieving PRI_SVC_SCP_PPT_MAPG
	            var sXml=""; 
	            
	            isOViaMandatory=false;
	            isDViaMandatory=false;
	           // isDirCallSetVisible(0);
				formObj.f_cmd.value=COMMAND17;				
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);				
				arrTemp=ComPriXml2Array(sXml, "cd|nm");				
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i=0; i < arrTemp.length; i++) {
						var pptCd=arrTemp[i][1];
						if (pptCd == "SOVA") {
							isOViaMandatory=true;
						} else if (pptCd == "SDVA") {
							isDViaMandatory=true;
						} else if (pptCd == "SDRC") {
							//isDirCallSetVisible(1);
						}
					}
				}				
	            break;
	        case IBSEARCH: 
	        		        	 
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH01;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0002_06GS.do" , FormQueryString(formObj));	                
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSaveData(arrXml[0],{Sync:0} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSaveData(arrXml[1],{Sync:0} );
	            } else if (sheetObj.id == "sheet2") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH02;
	                var sXml = sheetObj.DoSearch("ESM_PRI_0002_06GS.do", FormQueryString(formObj) );	                
	                setRNoteTooltip(-1);
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;	                
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0002_06GS.do" , FormQueryString(formObj));	               
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) /*{*/
	                	sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
	                	/*var Code = "";
	                	var ErrMsg = "";
	                	sheet5_OnSearchEnd01(sheetObjects[4], Code,ErrMsg) 
	                }*/
	                if (arrXml.length > 2) sheetObjects[5].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[6].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[7].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[8].LoadSearchData(arrXml[5],{Sync:1} );
	            }
	            break;
	        case IBDOWNEXCEL:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            formObj.f_cmd.value=SEARCH10;
	            var sXml=sheetObj.GetSearchData("ESM_PRI_0002_06GS.do", FormQueryString(formObj));
	            if (sXml.length > 0) sheetObjects[9].LoadSearchData(sXml,{Sync:1} );
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
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {form} formObj Mandatory html form object
	 * @param {int} sAction Mandatory ,process constant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : Invalid
	 * @author 
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH:
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBDOWNEXCEL: 
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
    function getPrcCustTpCd() {
        for (var i=0; i < document.form.prc_cust_tp_cd.length; i++) {
            if (document.form.prc_cust_tp_cd[i].checked) {
                return document.form.prc_cust_tp_cd[i].value;
            }
        }
    }
    function getPrcCustTpChecked() {
        for (var i=0; i < document.form.prc_cust_tp_cd.length; i++) {
            if (document.form.prc_cust_tp_cd[i].checked) {
                return i;
            }
        }
    }
    function setRNoteTooltip(idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObjects[1].HeaderRows(); i <= sheetObjects[1].LastRow(); i++) {
            	sheetObjects[1].SetToolTipText(i, "note_clss_nm",sheetObjects[1].GetCellValue(i, "note_tooltip"));
            }
        } else {
        	sheetObjects[1].SetToolTipText(idx, "note_clss_nm",sheetObjects[1].GetCellValue(idx, "note_tooltip"));
        }
    }
	/**
	 * Getting sheet data as XML format. <br>
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
        if (sheetNo == 3) {
            sCol="svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue=formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        sXml=ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        return sXml;
    }
	/**
	 * setting sheet data from XML format. <br>
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
        if (sheetNo == 3) {
            bAppendMode=1;
            sCol="svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue=formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
	/**
	 * Calling function from parent when loading a screen in tab.Setting default and retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
    function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
    	
        var formObject=document.form;
        if (formObject.svc_scp_cd.value != sSvcScpCd
                || formObject.gline_seq.value != sGlineSeq) {
            formObject.svc_scp_cd.value=sSvcScpCd;
            formObject.gline_seq.value=sGlineSeq;           
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);       
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);           
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }        
    }
	/**
	 * Clearing sheet's information<br>
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
        formObject.svc_scp_cd.value="";
        formObject.gline_seq.value="";
        formObject.cmdt_hdr_seq.value="";
        formObject.rout_seq.value="";
        for (var i=0; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
        formObject.origin_desc.value="";
        formObject.ovia_desc.value="";
        formObject.dvia_desc.value="";
        formObject.dest_desc.value="";
    }
    var enableFlag=true;
    function tabEnableSheet(flag) {
        var formObject=document.form;
        enableFlag=flag;
        sheetObjects[0].SetEditable(flag);
        sheetObjects[1].SetEditable(flag);
        sheetObjects[2].SetEditable(flag);
    }