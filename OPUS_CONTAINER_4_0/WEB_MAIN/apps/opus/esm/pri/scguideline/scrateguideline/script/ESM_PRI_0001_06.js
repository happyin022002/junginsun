/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_06.js
*@FileTitle  : Rate Guideline Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================
*/
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
    var isOViaMandatory=false;
    var isDViaMandatory=false;
    var isDirCallSetVisible = false;
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
            case "btn_downexcel":
	        		doActionIBSheet(sheetObjects[9], document.form, IBDOWNEXCEL);
                break;
            case "btn_loadexcel":
                if ( formObject.gline_seq.value == "" || formObject.svc_scp_cd.value == "") {
                    return;
                }
                var param=new StringBuffer();
                param.append("svc_scp_cd=").append(formObject.svc_scp_cd.value);
                param.append("&gline_seq=").append(formObject.gline_seq.value);
                param.append("&prc_cust_tp_cd=").append(getPrcCustTpCd());
                param.append("&eff_dt=").append(parent.getEffDt());
                param.append("&exp_dt=").append(parent.getExpDt());
                ComOpenPopup("/opuscntr/ESM_PRI_0120.do?" + param, 1200, 550, "", "1,0,1,1,1,1,1", false);
                break;
                
            case "btn_mqc":
                if (formObject.svc_scp_cd.value != "" && formObject.gline_seq.value != "") {
                    var sUrl='/opuscntr/ESM_PRI_0030.do?svc_scp_cd='+formObject.svc_scp_cd.value+'&gline_seq='+formObject.gline_seq.value+'&prc_cust_tp_cd='+getPrcCustTpCd()+'&enable_flg='+enableFlag;
                    ComOpenPopup(sUrl, 450, 370, "", "1,0,1,1,1,1,1", true);
                }
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
	          var HeadTitle="|Sel.|Seq.|Service Scope Code|Gline Seq.|Customer Type|Header Seq.|Commodity Code|Description|EFF Date|EXP Date";
	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	          var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", 	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       	Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Popup",     	Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      	Hidden:0, Width:500,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"PopupEdit", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"PopupEdit", 	Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
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
							{Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",                   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_pnt_loc_def_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"org_rout_via_port_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_via_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"dest_rout_pnt_loc_def_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"CheckBox",  Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
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
		          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1, ComboMaxHeight:300} );
		          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cmdt_hdr_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rout_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rt_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                 {Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetEllipsis(1);
		          SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		          SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		          SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		          SetShowButtonImage(2);
		          resizeSheet(); //SetSheetHeight(135);
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
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_via_port_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
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
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gline_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cust_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"chg_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_ctnt",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(100);
                }
            break;
            
        case "sheet10": // Sheet for Excel Download
            with(sheetObj){
		          var HeadTitle1="CMDT\nSeq|Commodity Group|Commodity Group|Route\nSeq|Origin|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Destination|D.Call|MQC|MQC|Rate(USD)|Rate(USD)|Rate(USD)";
		          var HeadTitle2="CMDT\nSeq|Code|Description|Route\nSeq|Code|Description|Term|Transmode|Code|Code|Code|Description|Term|Transmode|D.Call|Min|Max|PER|Cargo Type|Rate";
		          var headCount=ComCountHeadTitle(HeadTitle2);
		          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		          var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		          var headers = [ { Text:HeadTitle1, Align:"Center"},
		                          { Text:HeadTitle2, Align:"Center"} ];
		          InitHeaders(headers, info);
		          var cols = [ {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_dp_seq",                KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Int",       Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rout_dp_seq",                KeyField:1,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_fm_qty",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mqc_rng_to_qty",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"frt_rt_amt",                 KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
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
	 * Calling Function in case of OnBeforeCheck event <br>
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
    function sheet1_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 0, Row, Col);
        }
    }
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
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
    function sheet2_OnBeforeCheck(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        if (colName == "chk") {
            ComPriCheckWithPnS(sheetObjects.slice(0, 3), 1, Row, Col);
        }
    }
	/**
	 * Calling Function in case of OnBeforeCheck event <br>
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
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet3_OnChange(sheetObj, Row, Col, Value) {
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
        if (colName == "mqc_rng_fm_qty") {
            if (Value != ""){
            	var validPrevRow=getPrevValidRowCond(sheetObj, Row, "rat_ut_cd", sheetObj.GetCellValue(Row, "rat_ut_cd"));
                if (validPrevRow > 0) {
                	sheetObj.SetCellValue(validPrevRow, "mqc_rng_to_qty",parseInt(sheetObj.GetCellValue(Row, "mqc_rng_fm_qty")) - 1,0);
                }
            }
        }
        if (colName == "mqc_rng_to_qty") {
            if (Value != ""){
            	var validNextRow=getNextValidRowCond(sheetObj, Row, "rat_ut_cd", sheetObj.GetCellValue(Row, "rat_ut_cd"));
                if (validNextRow > 0) {
                	sheetObj.SetCellValue(validNextRow, "mqc_rng_fm_qty",parseInt(sheetObj.GetCellValue(Row, "mqc_rng_to_qty")) + 1,0);
                }
            }
        }
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
        	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1, KeyFieldMark:0 });
        	sheetObj.RemoveAll();
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
    var popupRow = 0;
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
        popupRow = Row;
        var formObj=document.form;
        if (colName == "prc_cmdt_def_cd") {
            var sUrl="ESM_PRI_0106.do?svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&isEditable=" + enableFlag;
            ComOpenPopup(sUrl, 700, 400, "setCommodity", "1,0", true);
        }
        if (colName == "eff_dt") {
            var cal=new ComCalendarGrid();
            cal.select(sheetObj, sheetObj.GetSelectRow(), "eff_dt", 'yyyyMMdd');
        }
        if (colName == "exp_dt") {
            var cal=new ComCalendarGrid();
            cal.select(sheetObj, sheetObj.GetSelectRow(), "exp_dt", 'yyyyMMdd');
        }
    }
    
    function setCommodity(rtnVal) {
    	var formObj=document.form;
    	if (rtnVal == "O") {
	    	var prevStatus=sheet1.GetRowStatus(popupRow);
	        var sCd="";
	        var sNm="";
	        for (var i=sheetObjects[3].HeaderRows(); i <= sheetObjects[3].LastRow(); i++) {
	        	if (sheetObjects[3].GetCellValue(i, "svc_scp_cd") == formObj.svc_scp_cd.value && sheetObjects[3].GetCellValue(i, "gline_seq") == formObj.gline_seq.value && sheetObjects[3].GetCellValue(i, "prc_cust_tp_cd") == getPrcCustTpCd() && sheetObjects[3].GetCellValue(i, "cmdt_hdr_seq") == formObj.cmdt_hdr_seq.value) {
	        		if (sheetObjects[3].GetRowStatus(i) == "D") {
	                    continue;
	                }
	        		sCd += sheetObjects[3].GetCellValue(i, "prc_cmdt_def_cd");
	        		sNm += sheetObjects[3].GetCellValue(i, "prc_cmdt_def_nm");
	                sCd += " / ";
	                sNm += " / ";
	            }
	        }
	        if (sCd != "") {
	        	var lastIdx=sCd.lastIndexOf("/");
	        	sCd=sCd.substring(0, lastIdx - 1);
	        }
	        if (sNm != "") {
	        	var lastIdx=sNm.lastIndexOf("/");
	        	sNm=sNm.substring(0, lastIdx - 1);
	        }
	        sheet1.SetCellValue(popupRow, "prc_cmdt_def_cd",sCd,0);
	        sheet1.SetCellValue(popupRow, "prc_cmdt_def_nm",sNm,0);
	        sheet1.SetRowStatus(popupRow,prevStatus);
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
    var popupRow=0;
    var popupCol=-1;
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
        if (!LoadingComplete) {
            return;
        }
        var colName=sheetObj.ColSaveName(Col);
        popupRow=Row;
        popupCol=Col;
        var formObj=document.form;
        var sUrl="ESM_PRI_0021.do?";
        
        var keyParam="svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value + "&prc_cust_tp_cd=" + getPrcCustTpCd() + "&cmdt_hdr_seq=" + formObj.cmdt_hdr_seq.value + "&rout_seq=" + formObj.rout_seq.value + "&isEditable=" + enableFlag;
        sUrl += keyParam;
        
        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 700, 330, "callBackESM_PRI_0021", "1,0,1,1,1,1,1", true);
            
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 700, 330, "callBackESM_PRI_0021", "1,0,1,1,1,1,1", true);
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            ComOpenPopup(sUrl, 700, 330, "callBackESM_PRI_0021", "1,0,1,1,1,1,1", true);
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            ComOpenPopup(sUrl, 700, 330, "callBackESM_PRI_0021", "1,0,1,1,1,1,1", true);
        }
        if (colName == "note_clss_nm") {
            sUrl="/opuscntr/ESM_PRI_0104.do?";
            sUrl += keyParam;
            ComOpenPopup(sUrl, 700, 350, "callBack0104", "none", true);
        }
    }
    
    function callBackESM_PRI_0021(rtnVal) {
    	 if (rtnVal == "O") {
             setSheet2RowData(sheet2, popupRow, popupCol);
         }
    }
    
    function callBack0104(rtnVal) {
    	var sheetObj = sheet2;
    	var Row = sheetObj.GetSelectRow();
    	if (rtnVal == "O") {
        	var prevStatus=sheetObj.GetRowStatus(Row);
            var sNm="";
            for (var i=sheetObjects[8].HeaderRows(); i <= sheetObjects[8].LastRow(); i++) {
            	if (sheetObjects[8].GetRowStatus(i) == "D") {
                    continue;
                }
            	var clssNm=arrNoteClass[sheetObjects[8].GetCellValue(i, "note_clss_cd")];
	            if (sNm.indexOf(clssNm) < 0) {
    	            sNm += clssNm;
    	            sNm += ", ";
	            }
            }
            if (sNm != "") {
            	var lastIdx=sNm.lastIndexOf(",");
            	sNm=sNm.substring(0, lastIdx);
            }
            sheetObj.SetCellValue(Row, "note_clss_nm",sNm,0);
            makeNoteTooltip(sheetObj, Row);
            sheetObj.SetRowStatus(Row,prevStatus);
        }
    }
	/**
	 * Setting modified information on popup screen to Sheet2<br>
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
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj=document.form;
        var prevStatus=sheetObj.GetRowStatus(Row);
        if (sheetObjects[4].IsDataModified()) {
            var sCd="";
            for (var i=sheetObjects[4].HeaderRows(); i <= sheetObjects[4].LastRow(); i++) {
            	if (sheetObjects[4].GetRowStatus(i) == "D") {
                    continue;
                }
            	sCd += sheetObjects[4].GetCellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx=sCd.lastIndexOf(",");
            	sCd=sCd.substring(0, lastIdx);
            }
            sheetObj.SetCellValue(Row, "org_rout_pnt_loc_def_cd",sCd,0);
        }
        if (sheetObjects[5].IsDataModified()) {
            var sCd="";
            for (var i=sheetObjects[5].HeaderRows(); i <= sheetObjects[5].LastRow(); i++) {
            	if (sheetObjects[5].GetRowStatus(i) == "D") {
                    continue;
                }
            	sCd += sheetObjects[5].GetCellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx=sCd.lastIndexOf(",");
            	sCd=sCd.substring(0, lastIdx);
            }
            sheetObj.SetCellValue(Row, "org_rout_via_port_def_cd",sCd,0);
        }
        if (sheetObjects[6].IsDataModified()) {
            var sCd="";
            for (var i=sheetObjects[6].HeaderRows(); i <= sheetObjects[6].LastRow(); i++) {
            	if (sheetObjects[6].GetRowStatus(i) == "D") {
                    continue;
                }
            	sCd += sheetObjects[6].GetCellValue(i, "rout_via_port_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx=sCd.lastIndexOf(",");
            	sCd=sCd.substring(0, lastIdx);
            }
            sheetObj.SetCellValue(Row, "dest_rout_via_port_def_cd",sCd,0);
        }
        if (sheetObjects[7].IsDataModified()) {
            var sCd="";
            for (var i=sheetObjects[7].HeaderRows(); i <= sheetObjects[7].LastRow(); i++) {
            	if (sheetObjects[7].GetRowStatus(i) == "D") {
                    continue;
                }
            	sCd += sheetObjects[7].GetCellValue(i, "rout_pnt_loc_def_cd");
                sCd += ", ";
            }
            if (sCd != "") {
            	var lastIdx=sCd.lastIndexOf(",");
            	sCd=sCd.substring(0, lastIdx);
            }
            sheetObj.SetCellValue(Row, "dest_rout_pnt_loc_def_cd",sCd,0);
        }
        sheetObj.SetRowStatus(Row,prevStatus);
    }
	/**
	 * Making tooltip by using note<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} sheetIdx Mandatory Sheet no
	 * @param {int} Row Mandatory Cell's Row Index
	 * @return void
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
            if (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[4].IsDataModified() || sheetObjects[5].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified()) {
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
        if (!isFiredNested && (OldRow != NewRow)) {
        	if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D" && (sheetObjects[1].IsDataModified()  || sheetObjects[2].IsDataModified()  || sheetObjects[4].IsDataModified()  || sheetObjects[5].IsDataModified()  || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified())) {
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
                if(adjNewRow > 0) formObj.rout_seq.value=sheetObjects[1].GetCellValue(adjNewRow, "rout_seq");
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
        	if (window.event == null || ComGetEvent() == undefined || ComGetEvent() == null) {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
	        switch (sAction) {
	        case IBSEARCH_ASYNC01: // When screen is loading, Customer type retrieves again
	        	var prevChecked=getPrcCustTpChecked();
	            formObj.f_cmd.value=SEARCH20;
	            var sXml=sheetObj.GetSearchData("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	            var arrData=ComPriXml2Array(sXml, "cd|nm|rate_cnt");
	            var sHTML="";
	            var firstMatch=-1;
	            for (var i=0; i < arrData.length; i++) {
	                sHTML += "<input name='prc_cust_tp_cd' value='" + arrData[i][0] + "' type='radio' class='trans'";
	                if (parseInt(arrData[i][2]) > 0) {
	                	if (firstMatch < 0) {
	                        firstMatch=i;
	                    }
	                    sHTML += "><b>&nbsp;" + arrData[i][1] + "</b>&nbsp;&nbsp;&nbsp;&nbsp;";
	                } else {
	                    sHTML += ">&nbsp;" + arrData[i][1] + "&nbsp;&nbsp;&nbsp;&nbsp;";
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
	            
	        case IBSEARCH_ASYNC20: // PRI_SVC_SCP_PPT_MAPG 
	            var sXml=""; 
	            isOViaMandatory=false;
	            isDViaMandatory=false;
	            isDirCallSetVisible=false;
				formObj.f_cmd.value=COMMAND17;
				sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=" + formObj.svc_scp_cd.value);
				arrTemp=ComPriXml2Array(sXml, "cd|nm");
				if (arrTemp != null && arrTemp.length > 0) {
					for (var i=0; i < arrTemp.length; i++) {
						var pptCd=arrTemp[i][1];
						// S/C O.Via mandatory
						if (pptCd == "SOVA") {
							isOViaMandatory=true;
						// S/C D.Via mandatory
						} else if (pptCd == "SDVA") {
							isDViaMandatory=true;
						// Use S/C D.Call ?
						} else if (pptCd == "SDRC") {
							isDirCallSetVisible=true;
						}
					}
				}
	            break;
	            
	        case IBSEARCH: // retrieving
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	                for (var i=0; i < sheetObjects.length; i++) {
	                    sheetObjects[i].RemoveAll();
	                }
	                //데이터가 없는경우 sheet1,sheet2 에 LoadSearchData를 수행 한 후 rowChange가 일어 나지 않기 때문에
	                //이후 다른 Sheet의 조회가 이루어 지지 않은다.
	                //따라서 별도로 form 에 있는 textarea 데이터를 삭제해줌.
	                formObj.origin_desc.value="";
	                formObj.ovia_desc.value="";
	                formObj.dvia_desc.value="";
	                formObj.dest_desc.value="";
	                
	                formObj.f_cmd.value=SEARCH01;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
	            } else if (sheetObj.id == "sheet2") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH02;
	                var sXml = sheetObj.DoSearch("ESM_PRI_0001_06GS.do", FormQueryString(formObj), {Sync:2} );
	                doRowChange2(-2, 0, 0, 0);
	                setRNoteTooltip(-1);
	            } else if (sheetObj.id == "sheet3") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                    if (i == 3) {
	                        continue;
	                    }
	                    sheetObjects[i].RemoveAll();
	                }
	                formObj.f_cmd.value=SEARCH03;
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0001_06GS.do" , FormQueryString(formObj));
	                var arrXml=sXml.split("|$$|");
	                if (arrXml.length > 0) sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );
	                if (arrXml.length > 1) sheetObjects[4].LoadSearchData(arrXml[1],{Sync:1} );
	                if (arrXml.length > 2) sheetObjects[5].LoadSearchData(arrXml[2],{Sync:1} );
	                if (arrXml.length > 3) sheetObjects[6].LoadSearchData(arrXml[3],{Sync:1} );
	                if (arrXml.length > 4) sheetObjects[7].LoadSearchData(arrXml[4],{Sync:1} );
	                if (arrXml.length > 5) sheetObjects[8].LoadSearchData(arrXml[5],{Sync:1} );
	            }
	            break;
	            
	        case IBSAVE: // Saving
	            if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
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
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	                var sXml=sheetObj.GetSaveData("ESM_PRI_0001_06GS.do", sParam);
	                sheetObjects[3].LoadSaveData(sXml);
	                sheetObjects[0].LoadSaveData(sXml);
	                if (sheetObjects[0].IsDataModified()|| sheetObjects[3].IsDataModified()) {
	                    return false;
	                } else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange1(-1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), IBSEARCH);
						}
						parent.setTabStyle();
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	                    ComPriSaveCompleted();
	                    return true;
	                }
	            } else if (sheetObj.id == "sheet3") {
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
	                var sParamSheet9=sheetObjects[8].GetSaveString();
	                if (sParamSheet9 != "") {
	                    sParam += "&" + ComPriSetPrifix(sParamSheet9, "sheet9_");
	                }
	                if (!supressConfirm && !ComPriConfirmSave()) {
	                    return false;
	                }
	                var sXml=sheetObj.GetSaveData("ESM_PRI_0001_06GS.do", sParam);
	                sheetObjects[8].LoadSaveData(sXml);
	                sheetObjects[7].LoadSaveData(sXml);
	                sheetObjects[6].LoadSaveData(sXml);
	                sheetObjects[5].LoadSaveData(sXml);
	                sheetObjects[4].LoadSaveData(sXml);
	                sheetObjects[2].LoadSaveData(sXml);
	                sheetObjects[1].LoadSaveData(sXml);
	                if (sheetObjects[1].IsDataModified() || sheetObjects[2].IsDataModified() || sheetObjects[4].IsDataModified() || sheetObjects[5].IsDataModified() || sheetObjects[6].IsDataModified() || sheetObjects[7].IsDataModified() || sheetObjects[8].IsDataModified()) {
	                    return false;
	                } else {
						if (getValidRowCount(sheetObjects[2]) <= 0) {
							doRowChange2(-1, sheetObjects[1].GetSelectRow(), sheetObjects[1].GetSelectCol(), sheetObjects[1].GetSelectCol(), IBSEARCH);
						}
						parent.setTabStyle();
	                    ComPriSaveCompleted();
	                    return true;
	                }
	            }
	            return true;
	            break;
	        case IBDOWNEXCEL:
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                ComShowCodeMessage('PRI08001');
	                return false;
	            }
	            formObj.f_cmd.value=SEARCH10;
	            sheetObj.DoSearch("ESM_PRI_0001_06GS.do", FormQueryString(formObj) );
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
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
	                sheetObj.SetCellValue(idx, "prc_cust_tp_cd",getPrcCustTpCd());
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1);
	                sheetObj.SetCellValue(idx, "eff_dt",parent.getEffDt());
	                sheetObj.SetCellValue(idx, "exp_dt",parent.getExpDt());
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                sheetObjects[4].RemoveAll();
	                sheetObjects[5].RemoveAll();
	                sheetObjects[6].RemoveAll();
	                sheetObjects[7].RemoveAll();
	                sheetObjects[8].RemoveAll();
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                formObj.origin_desc.value="";
	                formObj.ovia_desc.value="";
	                formObj.dvia_desc.value="";
	                formObj.dest_desc.value="";
	                sheet1_OnPopupClick(sheetObj, idx, 7);
	            }
	            if (sheetObj.id == "sheet2") {
	                var idx=doRowChange2(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBINSERT);
	                if (idx < 0) {
	                    return false;
	                }
	                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	                sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
	                sheetObj.SetCellValue(idx, "prc_cust_tp_cd",getPrcCustTpCd());
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cmdt_hdr_seq"));
	                sheetObj.SetCellValue(idx, "rout_seq",parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1);
	                setRNoteTooltip(idx);
	                sheetObjects[2].RemoveAll();
	                sheetObjects[4].RemoveAll();
	                sheetObjects[5].RemoveAll();
	                sheetObjects[6].RemoveAll();
	                sheetObjects[7].RemoveAll();
	                sheetObjects[8].RemoveAll();
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                formObj.origin_desc.value="";
	                formObj.ovia_desc.value="";
	                formObj.dvia_desc.value="";
	                formObj.dest_desc.value="";
	                // When row add on Route, Setting default using the value that retrieves from MQC
	                formObj.f_cmd.value=SEARCH;
	                sheetObjects[2].DoSearch("ESM_PRI_0030GS.do", FormQueryString(formObj), {Sync:2} );
	                for (var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow()&& sheetObjects[2].RowCount()> 0; i++) {
	                    sheetObjects[2].SetCellValue(i, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	                    sheetObjects[2].SetCellValue(i, "rout_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "rout_seq"));
	                    sheetObjects[2].SetCellValue(i, "rt_seq",i);
	                    sheetObjects[2].SetCellValue(i, "frt_rt_amt",0.00);
	                    sheetObjects[2].SetCellValue(i, "prc_cgo_tp_cd","");
	                    sheetObjects[2].SetCellValue(i, "curr_cd","USD");
	                    sheetObjects[2].SetRowStatus(i,"I");
	                }
	                sheet2_OnPopupClick(sheetObj, idx, 8);
	            }
	            if (sheetObj.id == "sheet3") {
	            	var bAddRow=false;
	            	var rowCnt = getValidRowCount(sheetObj);
	            	if (rowCnt == 0) {
	                    formObj.f_cmd.value=SEARCH;
	                    var sXml=sheetObj.GetSearchData("ESM_PRI_0030GS.do", FormQueryString(formObj));
	                    ComPriXml2Sheet(sheetObj, sXml, 2);
	                    sheetObj.SelectCell(1, "mqc_rng_fm_qty", false);
	                    if (getValidRowCount(sheetObj) > 0) {
		                    for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow()&& sheetObj.RowCount()> 0; i++) {
		                    	if (sheetObj.GetRowStatus(i) == "D") {
		                    		continue;
		                    	}
		                    	sheetObj.SetCellValue(i, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
		                    	sheetObj.SetCellValue(i, "rout_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "rout_seq"));
		                    	sheetObj.SetCellValue(i, "rt_seq",i);
		                    	sheetObj.SetCellValue(i, "frt_rt_amt",0.00);
		                    	sheetObj.SetCellValue(i, "prc_cgo_tp_cd","");
		                    	sheetObj.SetCellValue(i, "curr_cd","USD");
		                    	sheetObj.SetRowStatus(i,"I");
		                    }
	                    } else {
	                    	bAddRow=true;
	                    }
	            	}
	            	if (bAddRow || rowCnt > 0) {
		                var idx=sheetObj.DataInsert();
		                sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
		                sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
		                sheetObj.SetCellValue(idx, "prc_cust_tp_cd",getPrcCustTpCd());
		                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
		                sheetObj.SetCellValue(idx, "rout_seq",sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "rout_seq"));
		                sheetObj.SetCellValue(idx, "rt_seq",parseInt(ComPriGetMax(sheetObj, "rt_seq")) + 1);
		                var cnt = getValidRowCount(sheetObj);
		                if (cnt == 1) {
		                    sheetObj.SetCellValue(idx, "mqc_rng_fm_qty",1);
	                        sheetObj.SetCellValue(idx, "rat_ut_cd","");
	                        sheetObj.SetCellValue(idx, "prc_cgo_tp_cd","");
		                } else {
		                    var prevIdx=getPrevValidRow(sheetObj, idx);
		                    if (prevIdx > 0) {
		                    	if (sheetObj.GetCellValue(prevIdx, "mqc_rng_to_qty") != "") {
		                    		sheetObj.SetCellValue(idx, "mqc_rng_fm_qty",parseInt(sheetObj.GetCellValue(prevIdx, "mqc_rng_to_qty")) + 1);
		                        }
		                    	sheetObj.SetCellValue(idx, "rat_ut_cd",sheetObj.GetCellValue(prevIdx, "rat_ut_cd"));
		                        sheetObj.SetCellValue(idx, "prc_cgo_tp_cd","");
		                    } else {
		                        sheetObj.SetCellValue(idx, "rat_ut_cd","");
		                        sheetObj.SetCellValue(idx, "prc_cgo_tp_cd","");
		                    }
		                }
		                sheetObj.SetCellValue(idx, "frt_rt_amt",0.00);
		                sheetObj.SelectCell(idx, "mqc_rng_fm_qty", false);
	            	}
	            }
	            break;
	            
	        case IBCOPYROW: // Row Add
	            if (!enableFlag || !validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            if (sheetObj.id == "sheet1") {
	            	var prevCmdtHdrSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cmdt_hdr_seq");
	                var idx=doRowChange1(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                var newCmdtHdrSeq=parseInt(ComPriGetMax(sheetObj, "cmdt_hdr_seq")) + 1;
	                sheetObj.SetCellValue(idx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                formObj.cmdt_hdr_seq.value=sheetObj.GetCellValue(idx, "cmdt_hdr_seq");
	                //sheetObjects[3] copy
	                for (var i=sheetObjects[3].LastRow(); i >= sheetObjects[3].HeaderRows(); i--) {
	                	if (sheetObjects[3].GetCellValue(i, "cmdt_hdr_seq") == prevCmdtHdrSeq) {
	                        sheetObjects[3].SelectCell(i, 0);
	                        var insIdx=sheetObjects[3].DataCopy();
	                        sheetObjects[3].SetCellValue(insIdx, "cmdt_hdr_seq",newCmdtHdrSeq);
	                    }
	                }
	                formObj.origin_desc.value="";
	                formObj.ovia_desc.value="";
	                formObj.dvia_desc.value="";
	                formObj.dest_desc.value="";
	                for (var i=1; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                	sheetObjects[i].RemoveAll();
	                }
	            }
	            if (sheetObj.id == "sheet2") {
	            	var prevRoutSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rout_seq");
	                var idx=doRowChange2(-2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), IBCOPYROW);
	                if (idx < 0) {
	                    return false;
	                }
	                var newRoutSeq=parseInt(ComPriGetMax(sheetObj, "rout_seq")) + 1;
	                sheetObj.SetCellValue(idx, "rout_seq",newRoutSeq);
	                formObj.rout_seq.value=sheetObj.GetCellValue(idx, "rout_seq");
	                //sheetObjects[4,5,6,7,8] copy
	                for (var a=4; a <= 8; a++) {
	                	if (sheetObjects[a].RowCount()<= 0) {
	                		continue;
	                	}
	                    for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
	                        var colName="";
	                        if (a == 4 || a == 7) {
	                            colName="rout_pnt_seq";
	                        } else if (a == 5 || a == 6) {
	                            colName="rout_via_seq";
	                        } else if (a == 8) {
	                            colName="rout_note_seq";
	                        }
	                        sheetObjects[a].SetCellValue(i, "rout_seq",newRoutSeq);
	                        sheetObjects[a].SetCellValue(i, colName,i);
	                        sheetObjects[a].SetRowStatus(i,"I");
	                    }
	                }
	                for (var i=sheetObjects[2].HeaderRows(); i <= sheetObjects[2].LastRow()&& sheetObjects[2].RowCount()> 0; i++) {
	                    sheetObjects[2].SetCellValue(i, "rout_seq",newRoutSeq);
	                    sheetObjects[2].SetCellValue(i, "rt_seq",i);
	                    sheetObjects[2].SetRowStatus(i,"I");
	                }
	                setRNoteTooltip(idx);
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
	    		if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
	                for (var i=1; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                    sheetObjects[i].RemoveAll();
	                }
				}
	    		if (sheetObj.id == "sheet2" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
	                for (var i=2; i < sheetObjects.length; i++) {
	                	if (i == 3) {
	                		continue;
	                	}
	                    sheetObjects[i].RemoveAll();
	                }
				}
	            var delCnt=deleteRowCheck(sheetObj, "chk");
	            if (delCnt > 0 && sheetObj.id == "sheet1") {
	            	for (var i=sheetObjects[3].LastRow(); sheetObjects[3].RowCount()> 0 && i >= sheetObjects[3].HeaderRows(); i--) {
	            		var curCmdtHdrSeq=sheetObjects[3].GetCellValue(i, "cmdt_hdr_seq");
	        			for (var k=0; k < arrCheckedRows.length; k++) {
	        				if (sheetObj.GetCellValue(arrCheckedRows[k], "cmdt_hdr_seq") == curCmdtHdrSeq) {
	        					sheetObjects[3].RowDelete(i, false);
	        					continue;
	        				}
	        			}
	            	}
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
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
            
        case IBSAVE: // Saving
            if (sheetObj.id == "sheet1") {
                if (!sheetObjects[0].IsDataModified()&& !sheetObjects[3].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
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
                for (var i=sheetObjects[0].HeaderRows(); sheetObjects[0].RowCount()> 0 && i <= sheetObjects[0].LastRow(); i++) {
                	if (sheetObjects[0].GetRowStatus(i) == "D") {
                		continue;
                	}
                	if (sheetObjects[0].GetCellValue(i, "prc_cmdt_def_cd") == "") {
                		sheetObjects[0].SelectCell(i, "prc_cmdt_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Commodity Code");
                        return false;
                	}
                }
                var effDt=parent.getEffDt();
                var expDt=parent.getExpDt();
                for (var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
                	var lEffDt=setDateFormat(sheetObjects[0].GetCellValue(i, "eff_dt"), "ymd");
                	var lExpDt=setDateFormat(sheetObjects[0].GetCellValue(i, "exp_dt"), "ymd");
                    if (lEffDt > lExpDt) {
                        ComShowCodeMessage("PRI00306");
                        return false;
                    }
                    if (lEffDt < effDt) {
                        ComShowCodeMessage("PRI08016");
                        return false;
                    }
                    if (lExpDt > expDt) {
                        ComShowCodeMessage("PRI08016");
                        return false;
                    }
                }
            } else if (sheetObj.id == "sheet3") {
                if (!sheetObjects[1].IsDataModified() && !sheetObjects[2].IsDataModified() && !sheetObjects[4].IsDataModified() && !sheetObjects[5].IsDataModified() && !sheetObjects[6].IsDataModified() && !sheetObjects[7].IsDataModified() && !sheetObjects[8].IsDataModified()) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }
                if (sheetObjects[0].IsDataModified()|| sheetObjects[3].IsDataModified()) {
                    ComShowCodeMessage("PRI00309", "Commodity Group");
                    return false;
                }
                if (sheetObjects[1].GetRowStatus(sheetObjects[1].GetSelectRow()) != "D"
    				&& getValidRowCount(sheetObjects[2]) <= 0) {
    				ComShowCodeMessage("PRI01125");
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
                if (sheetObjects[8].IsDataModified()
                        && sheetObjects[8].GetSaveString() == "") {
                    return false;
                }
                // Route Point Mandatory check.
                for (var i=sheetObjects[1].HeaderRows(); sheetObjects[1].RowCount()> 0 && i <= sheetObjects[1].LastRow(); i++) {
                	if (sheetObjects[1].GetRowStatus(i) == "D") {
                		continue;
                	}
                	if (sheetObjects[1].GetCellValue(i, "org_rout_pnt_loc_def_cd") == "") {
                    	sheetObj.SelectCell(i, "org_rout_pnt_loc_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Origin");
                        return false;
                	}
                	if (sheetObjects[1].GetCellValue(i, "org_rout_via_port_def_cd") == "" && isOViaMandatory) {
                    	sheetObj.SelectCell(i, "org_rout_via_port_def_cd", false);
                        ComShowCodeMessage("PRI00316", "O.Via");
                        return false;
                	}
                	if (sheetObjects[1].GetCellValue(i, "dest_rout_via_port_def_cd") == ""&& isDViaMandatory) {
                    	sheetObj.SelectCell(i, "dest_rout_via_port_def_cd", false);
                        ComShowCodeMessage("PRI00316", "D.Via");
                        return false;
                	}
                	if (sheetObjects[1].GetCellValue(i, "dest_rout_pnt_loc_def_cd") == "") {
                    	sheetObj.SelectCell(i, "dest_rout_pnt_loc_def_cd", false);
                        ComShowCodeMessage("PRI00316", "Dest.");
                        return false;
                	}
                }
                // Check the amount of Sheet3 and MQC Min-Max.
                for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
                	if (parseInt(sheetObj.GetCellValue(i, "mqc_rng_fm_qty")) > parseInt(sheetObj.GetCellValue(i, "mqc_rng_to_qty"))) {
                    	sheetObj.SelectCell(i, "mqc_rng_fm_qty", false);
                        ComShowCodeMessage("PRI08008");
                        return false;
                    }
                	var validNextRow=getNextValidRowCond(sheetObj, i, "rat_ut_cd", sheetObj.GetCellValue(i, "rat_ut_cd"));
                	if (validNextRow > 0 && parseInt(sheetObj.GetCellValue(i, "mqc_rng_to_qty")) != parseInt(sheetObj.GetCellValue(validNextRow, "mqc_rng_fm_qty")) - 1) {
                    	sheetObj.SelectCell(i, "mqc_rng_to_qty", false);
                        ComShowCodeMessage("PRI08009");
                        return false;
                    }
                }
            }
            return true;
            break;
            
        case IBDOWNEXCEL: // 
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
            
        case IBINSERT: // Row Add
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            }
            if (sheetObj.id == "sheet2") {
                if (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetSelectRow()<= 0) {
                    return false;
                }
            } else if (sheetObj.id == "sheet3") {
                if (sheetObjects[1].RowCount()<= 0 || sheetObjects[1].GetSelectRow()<= 0) {
                    return false;
                }
            }
            return true;
            break;
            
        case IBCOPYROW: // Row Add
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            }
            if (sheetObj.RowCount()<= 0 || sheetObj.GetSelectRow()<= 0) {
                return false;
            }
            return true;
            break;
            
        case IBDELETE: // Delete
            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
    
    function setDateFormat(inDate, format )
    {
    	var rtnVal="";
    	var year=inDate.substring(0, 4);
    	var month=inDate.substring(4, 6);
    	var date=inDate.substring(6, 8);
    	switch(format){
    	case "y" : 
    	case "ym" : 
    	case "ymd" :
    		theDay = year + '-' + month + '-' + date;
    		break;
    	default :
    		theDay = year + '-' + month + '-' + date;
    	break;
    	}
    	rtnVal=theDay;
    	return;  
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
        if (sheetNo == 3) {
            sCol="svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue=formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
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
        if (sheetNo == 3) {
            bAppendMode=1;
            sCol="svc_scp_cd|gline_seq|prc_cust_tp_cd|cmdt_hdr_seq";
            sValue=formObj.svc_scp_cd.value + "|" + formObj.gline_seq.value + "|" + getPrcCustTpCd() + "|" + formObj.cmdt_hdr_seq.value;
        }
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
    }
    
    function reloadPagePostTr() {
    	parent.setTabStyle();
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
        switch (mode) {
        case "CLEAR":
            disableButton("btn_retrieve");
            disableButton("btn_downexcel");
            disableButton("btn_loadexcel");
            disableButton("btn_mqc");
            disableButton("btn_rowadd1");
            disableButton("btn_rowadd2");
            disableButton("btn_rowadd3");
            disableButton("btn_rowcopy1");
            disableButton("btn_rowcopy2");
            disableButton("btn_delete1");
            disableButton("btn_delete2");
            disableButton("btn_delete3");
            disableButton("btn_save1");
            disableButton("btn_save2");
            disableButton("btn_save3");
//            sheetObjects[0].InitDataProperty2(0, 9, dtPopupEdit, "insert-edit=false; update-edit=false");
//            sheetObjects[0].InitDataProperty2(0, 10, dtPopupEdit, "insert-edit=false; update-edit=false");
//            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
            sheetObjects[2].SetEditable(0);
            break;
        case "INIT":
            enableButton("btn_retrieve");
            enableButton("btn_downexcel");
            enableButton("btn_loadexcel");
            enableButton("btn_mqc");
            enableButton("btn_rowadd1");
            enableButton("btn_rowadd2");
            enableButton("btn_rowadd3");
            enableButton("btn_rowcopy1");
            enableButton("btn_rowcopy2");
            enableButton("btn_delete1");
            enableButton("btn_delete2");
            enableButton("btn_delete3");
            enableButton("btn_save1");
            enableButton("btn_save2");
            enableButton("btn_save3");
//        	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
//        	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
//            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, true, true, -1, false, true, "", false);
            sheetObjects[2].SetEditable(1);
            break;
        case "READONLY":
            enableButton("btn_retrieve");
            enableButton("btn_downexcel");
            disableButton("btn_loadexcel");
            enableButton("btn_mqc");
            disableButton("btn_rowadd1");
            disableButton("btn_rowadd2");
            disableButton("btn_rowadd3");
            disableButton("btn_rowcopy1");
            disableButton("btn_rowcopy2");
            disableButton("btn_delete1");
            disableButton("btn_delete2");
            disableButton("btn_delete3");
            disableButton("btn_save1");
            disableButton("btn_save2");
            disableButton("btn_save3");
//            sheetObjects[0].InitDataProperty2(0, 9, dtPopupEdit, "insert-edit=false; update-edit=false");
//            sheetObjects[0].InitDataProperty2(0, 10, dtPopupEdit, "insert-edit=false; update-edit=false");
//            sheetObjects[1].InitDataProperty(0, 12, dtCheckBox, 95, daCenter, false, "dir_call_flg", false, "", dfNone, 0, false, false, -1, false, true, "", false);
            sheetObjects[2].SetEditable(0);
            break;
        }
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
    function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
        var formObject=document.form;
        if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
            formObject.svc_scp_cd.value=sSvcScpCd;
            formObject.gline_seq.value=sGlineSeq;
            doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC20);
            // O.Via Mandatory
            if (isOViaMandatory) {
            	sheetObjects[1].SetColProperty("org_rout_via_port_def_cd", {KeyField:true} );
//            	sheetObjects[1].InitDataProperty(0, 9, dtPopup, 160, daLeft, false, "org_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
            	sheetObjects[1].SetColProperty("org_rout_via_port_def_cd", {KeyField:false} );
//            	sheetObjects[1].InitDataProperty(0, 9, dtPopup, 160, daLeft, false, "org_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
            // D.Via Mandatory
            if (isDViaMandatory) {
            	sheetObjects[1].SetColProperty("dest_rout_via_port_def_cd", {KeyField:true} );
//            	sheetObjects[1].InitDataProperty(0, 10, dtPopup, 160, daLeft, false, "dest_rout_via_port_def_cd", true, "", dfNone, 0, true, true);
            } else {
            	sheetObjects[1].SetColProperty("dest_rout_via_port_def_cd", {KeyField:false} );
//            	sheetObjects[1].InitDataProperty(0, 10, dtPopup, 160, daLeft, false, "dest_rout_via_port_def_cd", false, "", dfNone, 0, true, true);
            }
            // Direct Call Enable
            if (isDirCallSetVisible) {
            	sheetObjects[1].SetColHidden("dir_call_flg",0);
            } else {
            	sheetObjects[1].SetColHidden("dir_call_flg",1);
            }
            if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
            sheetObjects[0].SetColProperty("eff_dt", {KeyField:true} );
            sheetObjects[0].SetColProperty("exp_dt", {KeyField:true} );
//        	sheetObjects[0].InitDataProperty(0, 9, dtPopupEdit, 100, daCenter, false, "eff_dt", true, "", dfDateYmd, 0, false, false);
//        	sheetObjects[0].InitDataProperty(0, 10, dtPopupEdit, 100, daCenter, false, "exp_dt", true, "", dfDateYmd, 0, false, false);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            tabEnableSheet(enableFlag);
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
        toggleButtons("CLEAR");
    }
    var enableFlag=true;
    function tabEnableSheet(flag) {
        var formObject=document.form;
        enableFlag=flag;
        if (enableFlag) {
            toggleButtons("INIT");
        } else {
            toggleButtons("READONLY");
        }
    }
