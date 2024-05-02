/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0024.js
*@FileTitle  : Proposal Origin/Destination Arbitrary - Excel Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
    // common global variables 
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var errFlg=false;	
    var checkFlg = true;
    document.onclick=processButtonClick;
    /**
     * event handler to handling process by button names <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 
     * @author 
     * @version 
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];         
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
				case "btn_template":
					downform.submit();
					break;
	    		case "btn_openfile":
	    			sheetObject1.LoadExcel({ Mode:"HeaderMatch"});
					break;
	    		case "btn_check":
	    			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * Registering IBSheet Object by array<br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding first handling function after loading screen on the browser <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return N/A
     * @author 
     * @version 
     */
    function loadPage() {
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
    	 for(i=0;i<sheetObjects.length;i++){
        	ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 pageOnLoadFinish();
    }
    /**
     * Defining header, sheet initializing  <br>
     * @return N/A
     * @author 
     * @version 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
     	var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //t1sheet1 init
                with(sheetObj){
	             var HeadTitle="state|Seq.|Point|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Proposal|seq|Note||||||||||||";
	             var headCount=ComCountHeadTitle(HeadTitle);
	             (headCount, 0, 0, true);
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
    	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
    	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"via_port_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pre_note_dp_seq" },
    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetWaitImageVisible(0);
	             SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdText, ComboCode:prcTrspModCdValue} );
	             SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
	             SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
	             SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
	             SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	             SetColProperty("prc_prog_sts_cd", {ComboText:PrcProgStsCdText, ComboCode:PrcProgStsCdValue} );
	             
	             SetColProperty(0 ,"rout_pnt_loc_def_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	    	     SetColProperty(0 ,"bse_port_def_cd" 		, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	    	     SetColProperty(0 ,"via_port_def_cd" 		, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	    	     SetColProperty(0 ,"note_dp_seq" , {AcceptKeys:"[1234567890]"});
	             
	             SetSheetHeight(370);
             }
            	break;
            case "sheet2":
                with(sheetObj){
                	 var HeadTitle="status";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" } ];               
		              InitColumns(cols);
		              SetEditable(1);
		              SetVisible(0);
                    }
            	break;	
            case "sheet3":      //for checking duplicate data with existing
                with(sheetObj){
	                var HeadTitle="state|Point|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Note";
		             var headCount=ComCountHeadTitle(HeadTitle);
		             (headCount, 0, 0, true);
		             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                 {Type:"Text",		Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0 },
		                 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"min_cgo_wgt" },
		     			 {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"max_cgo_wgt" },
		                 {Type:"Text", 		Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0 },
		                 {Type:"Text", 		Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0 },
		                 {Type:"CheckBox",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0 },
		                 {Type:"Text", 		Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",      KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0 },
		                 {Type:"Text",     	Hidden:0, Width:300,  Align:"Center",  ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0} ];
		              
		             InitColumns(cols);
		             SetEditable(0);
		             SetWaitImageVisible(0);
//		             SetSheetHeight(260);
		             SetVisible(0);
               }
                break;        
            case "sheet4":      // sheet for code check
                with(sheetObj){		                
		              var HeadTitle="state|Point|Base Port|VIA|Commodity";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" } ];
		               
		              InitColumns(cols);
		              SetEditable(0);
		              SetWaitImageVisible(0);
		              SetSheetHeight(200);
		              
		              SetVisible(0);
              }
                break;         
            case "sheet5":      // sheet for note sequence validation
                with(sheetObj){
	             var HeadTitle="state|Type|Seq.|Point|Trans Mode|Term|Weight\n(Ton<=)|Weight\n(<Ton)|Base Port|VIA|D/Call|Per|Cargo Type|Commodity|Currency|Proposal|seq|Note|Note Text|||||||||||";
	             var headCount=ComCountHeadTitle(HeadTitle);
	             (headCount, 0, 0, true);
	             SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Type",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"type" },
	                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                 {Type:"Text", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_trsp_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rcv_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:"min_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
    	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:"max_cgo_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
	                 {Type:"Text", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Text", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"via_port_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	                 {Type:"Text",  Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
	                 {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rat_ut_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_cgo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                 {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"prop_frt_rt_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
    	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"note_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"add_chg_note_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt_text",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bse_port_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"via_port_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
	                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"add_chg_seq" },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pre_note_dp_seq" },
    	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"per_type" } ];
	              
	             InitColumns(cols);
	             SetEditable(0);
	             SetWaitImageVisible(0);
	             SetSheetHeight(200);
	             SetVisible(0);
             }
                break;	        	
        }
    }
    /**
     * calling Event when keyboard press data cell <br> 
     * @author 
     * @version 
     */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
            while (true) {
            	if (Col > sheetObj.LastCol()) {
            		Row++;
                    Col=1;
                }
                if (Row > sheetObj.LastRow()) {
                    Row=sheetObj.HeaderRows();
                }
				var sVal = sheetObj.GetCellBackColor(Row, Col).toUpperCase();
				if (sVal == "#FF0000") {
                   sheetObj.SelectCell(Row, Col, false);
                   break;
                }
                Col++;
            }
        }
    }
    
    function SheetObject(sheet, row, col){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 	}
 	var _tmp_sheetObject;
 	
    /**
 	 * sheet1 OnPopupClick event function <br>
 	 * @author 
 	 * @version 
 	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
        var colName=sheetObj.ColSaveName(Col);
     	var formObj=document.form;
		var propNO=sheetObj.GetCellValue(Row, "prop_no");
		var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
		var svcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
  		if (colName == "rout_pnt_loc_def_cd") { //Point
  			var sUrl="ESM_PRI_4026.do?group_cmd="+ PRI_SP_SCP +"&location_cmd=L&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			ComOpenPopup(sUrl, 700, 325, "rout_pnt_loc_def_cd_returnVal", "1,0,1,1,1,1,1", true);
  			
  		} else if (colName == "bse_port_def_cd") { //Base Point
  			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			ComOpenPopup(sUrl, 700, 325, "bse_port_def_cd_returnVal", "1,0,1,1,1,1,1", true);
  			
  		} else if (colName == "via_port_def_cd") { //VIA
  			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SP_SCP + "&location_cmd=LG&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			ComOpenPopup(sUrl, 700, 325, "via_port_def_cd_returnVal", "1,0,1,1,1,1,1", true);
  			
  		}  else if (colName == "prc_cmdt_def_cd") { 
  			var sUrl="ESM_PRI_4027.do?commodity_cmd=CG&grp_cd="+PRI_SP_SCP+"&prop_no="+propNO+"&amdt_seq="+amdtSeq+"&svc_scp_cd="+svcScpCd;
  			ComOpenPopup(sUrl, 700, 325, "prc_cmdt_def_cd_returnVal", "1,0,1,1,1,1,1", true);
  			
  		}
    }
    
    function rout_pnt_loc_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	if(rtnVal != null){
    		if(!checkRoutePointLocation(_tmp_sheetObject.sheet, _tmp_sheetObject.row, rtnVal.cd)){
    			return;
    		}
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, false);
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col + 1, rtnVal.nm, false);
			if (rtnVal.cd.length == 5){ 
				tpCd="L";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row,"rout_pnt_loc_tp_cd", tpCd , false);
    	}
    }
    
    function bse_port_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	if(rtnVal!=null){
    		if(!checkBasePort(_tmp_sheetObject.sheet, _tmp_sheetObject.row, rtnVal.cd)){
    			return;
    		}
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, false);
			if(rtnVal.cd.length == 5) { 
				tpCd="L";
			} else if(rtnVal.cd.length == 4) { 
				tpCd="G";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row,"bse_port_tp_cd",tpCd ,false);
    	}
    }
    
    function via_port_def_cd_returnVal(rtnVal) {
    	var tpCd="";
    	if (rtnVal != null){
    		_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, false);
			if (rtnVal.cd.length == 5){ 
				tpCd="L";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "via_port_tp_cd", tpCd, false);
			_tmp_sheetObject.sheet.SetCellEditable(_tmp_sheetObject.row, "dir_call_flg", false);
		}
    }

	function prc_cmdt_def_cd_returnVal(rtnVal) {
		var tpCd="";
		if (rtnVal != null){
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, false);
			if(rtnVal.cd.length == 5) {
				tpCd="G";
			} else if(rtnVal.cd.length == 6) {
				tpCd="C";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row,"prc_cmdt_tp_cd", tpCd, false);
		}
	}
	
    /**
     * It calls when OnClick event triggered on sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @returns void
     * @author 
     * @version 2009.05.18
     */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		//Showing Memopad in case of Clicking desc cell
		var formObj=document.form;
		var colname=sheetObj.ColSaveName(Col);
		switch (colname) {
		case "add_chg_note_ctnt":
			if(checkFlg){
				ComShowMemoPad(sheetObj, Row, Col, false, null, null, null,1); // Editable
			}else{
				if(Value=="" || Value==null){
					return false;
				}
				ComShowMemoPad(sheetObj, Row, Col, true, null, null, null,1); // Disabled
			}
			break;
	}
	}
	
    /**
     * Handling sheet process<br>
     * @author
     * @version 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        try{
	        switch(sAction) {
	        	case IBSEARCH_ASYNC01: // check
	        		ComOpenWait(true);
	        		if(!validateForm(sheetObj,formObj,sAction)) {
	        			ComOpenWait(false);
	        			return false;
	        		}
	        		ComOpenWait(false);
	                break;
	        	case IBSEARCH_ASYNC03: // Retrieving Term Code 
					formObj.f_cmd.value=SEARCH19;
					if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
						formObj.cd.value="CD02138";
					} else {
						formObj.cd.value="CD02139";
					}
					sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
					setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
					break;			
	        	case IBSAVE:        
	        		ComOpenWait(true);
	        		if(!validateForm(sheetObj,formObj,sAction)) {
	        			ComOpenWait(false);
	        			return false;
	            	}
	        	
		        	formObj.f_cmd.value = SEARCH01;
					var sXml = sheetObj.GetSearchData("ESM_PRI_0024GS.do", FormQueryString(formObj)+"&"+sheetObj.GetSaveString());
					
					var sFlag = ComGetEtcData(sXml, "FLAG");
					var sDupIdx = ComGetEtcData(sXml, "DUP_INDEX");
					
					if(sFlag == "N") {
						ComShowCodeMessage("PRI02019", sDupIdx);
						ComBtnEnable("btn_check");
						ComBtnDisable("btn_save");
						makeSheetEditable(sheetObj);
						checkFlg = true;
					} else {
						formObj.f_cmd.value = MULTI01;
						sheetObj.DoSave("ESM_PRI_0024GS.do", FormQueryString(formObj), -1, false);
					}
					ComOpenWait(false);
	                break;
	        }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBSEARCH_ASYNC03) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }
   
    /**
	 * calling function of OnChange Event <br> 
	 * when selecting multi comboBox, showing description and retrieveing validation <br>
     * @author 
     * @version 
	 */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	
    	var formObj=document.form;
 		var sName=sheetObj.ColSaveName(Col);
 		var amdt_seq=formObj.amdt_seq.value;
 		var validColor="#FF0000";
 		switch(sName) {
 			case "rout_pnt_loc_def_cd": //point
	 			if(!checkRoutePointLocation(sheetObj, Row, Value)) {
					return;
				}
 				if(checkLocation(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false)) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 				}
 				break;	
 			case "prc_trsp_mod_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.GetCellValue(Row, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 	     		}
 				break;
 			case "rcv_de_term_cd":
 				if(checkCommonCode(sheetObj, Row, sheetObj.GetCellValue(Row, "rcv_de_term_cd"), "rcv_de_term_cd")) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 	     		}
 				break;
 			case "bse_port_def_cd": //base port
 				if(!checkBasePort(sheetObj, Row, Value)) { 
 					 return false;
 				}
 				if(checkLocation(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true)) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 				}
  	    		break;
 			case "via_port_def_cd":
 				checkLocation(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false);
 				setDirectCall(sheetObj, Row, Value);
  				break;	
 			case "dir_call_flg":
 				checkVia(sheetObj, Row, Value);
 				break;
 			case "rat_ut_cd":
 				checkPerType(sheetObj, Row, Value);
 				break;
 			case "prc_cgo_tp_cd":
 				checkCargoType(sheetObj, Row, Value);
 				break;
 			case "prc_cmdt_def_cd":
 				if(checkCommodity(sheetObj, Row, Value)) sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 	 			break;
 			case "prop_frt_rt_amt":
 				if(checkProposalFreightRateAmount(sheetObj, Row, Value.toString())) {
 					sheetObj.SetCellBackColor(Row, sName,"#FFFFFF");
 				}
 				break;
 		}
    }
    /**
     * calling function when occurring LoadExcel event <br> 
     * @author 
     * @version 
     */
  	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
  		if(isExceedMaxRow(msg))return;
  		setAllDirectCall(sheetObj);
  		toggleButtons("INIT");
  		makeSheetEditable(sheetObj);
  		checkFlg = true;
  	}
    /**
     * calling function when occurring OnSaveEnd event <br>
     * @author 
     * @version 
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
 			opener.reloadExcelCopy();
 			ComClosePopup(); 
 		}
	}
    /**
     * calling function when Page Loading <br>
     * @author 
     * @version 
     */ 
     function pageOnLoadFinish() {
    	 toggleButtons("CLEAR");
    	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
    	 toggleButtons("INIT");
    }
  	/**
     * checking location code function <br>
     * @author 
     * @version 
     */ 
	function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		if(ComIsNull(locCd)) {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return true;
		}
		// Location
		if (locCd.length == 5 && isLoc) {		
			if (cellDefCdNm == "rout_pnt_loc_def_cd" || cellDefCdNm == "via_port_def_cd") {		
				formObj.f_cmd.value=SEARCH05;
				var locCd = sheetObj.GetCellValue(Row, cellDefCdNm);
				formObj.cd.value=locCd;
				var sParam=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
					return true;
				} else {
					locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
					return false;
				}
			
			} else if (cellDefCdNm == "bse_port_def_cd") {	
				formObj.f_cmd.value=COMMAND31;
				formObj.cd.value=locCd;
				var sOriDesGbCd=ComGetObjValue(formObj.org_dest_tp_cd);
				var sParam=FormQueryString(formObj)+"&etc1="+sOriDesGbCd;
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObj.SetCellValue(Row, cellTpCdNm,"L" ,0);
					return true;
				} else {
					locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
					return false;
				}
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=locCd;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm,"G", false);
				return true;
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				return false;
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return false;
 		}
		return true;
	}

	/**
     * location code Resetting function<br>
     * @author 
     * @version 
     */ 
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}
	/**
     * sheet's dir_call_flg editing management function<br>
     * @author 
     * @version 
     */ 
	function setDirectCall(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			sheetObj.SetCellEditable(Row,"dir_call_flg",1);//Direct Call use
		} else {
			sheetObj.SetCellValue(Row,"dir_call_flg","",0);
			sheetObj.SetCellEditable(Row,"dir_call_flg",0);//Direct Call not use
		}
	}
	/**
     * sheet's all dir_call_flg editing management function<br>
     * @author 
     * @version 
     */ 
	function setAllDirectCall(sheetObj) {
		var rCnt=sheetObj.RowCount();
		for (var i=1; i<=rCnt; i++) {
			if (sheetObj.GetCellValue(i, "via_port_def_cd") != "") {
				sheetObj.SetCellEditable(i, "dir_call_flg",0);
			} else if (sheetObj.GetCellValue(i, "dir_call_flg") == "1") {
				sheetObj.SetCellEditable(i, "via_port_def_cd",0);
			}
		}
	}
	/**
     * checking function of rout_pnt_loc_tp_cd's validation <br>
     * @author 
     * @version 
     */
	function checkRoutePointLocation(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if(sheetObj.GetCellValue(Row, "rcv_de_term_cd")!="D" && sheetObj.GetCellValue(Row, "bse_port_def_cd") == Value){
			ComShowCodeMessage('PRI01078');
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","");
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			return false;
		}
		return true;
	}
	/**
     * checking function of bse_port_def_cd's validation <br>
     * @author 
     * @version 
     */
	function checkBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if (sheetObj.GetCellValue(Row, "rcv_de_term_cd")!="D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			ComShowCodeMessage('PRI01020');
			sheetObj.SetCellValue(Row, "bse_port_def_cd","");
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	/**
     * checking function of via_port_def_cd's validation <br>
     * @author 
     * @version 
     */
	function checkVia(sheetObj, Row, Value) {
		if (Value == "1") {
			sheetObj.SetCellValue(Row,"via_port_def_cd","",0);
			sheetObj.SetCellEditable(Row,"via_port_def_cd",0);
		} else {
			sheetObj.SetCellEditable(Row,"via_port_def_cd",1);
			if(sheetObj.GetCellValue(Row,"via_port_def_cd") != "") {
				sheetObj.SetCellEditable(Row, "dir_call_flg",0);
			}
		}
	}
    /**
     * checking function of rat_ut_cd's validation <br>
     * @author 
     * @version 
     */
	function checkPerType(sheetObj, Row, Value) {
		 var validPerClass="A,F,O,Q,S,P";
		 if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
			 ComShowCodeMessage("PRI08003");
			 sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
		 }
	}
	/**
     * checking function of prc_cgo_tp_cd's validation <br>
     * @author 
     * @version 
     */
     function checkCargoType(sheetObj, Row, Value) {
 		var validPerClass="A,F,O,Q,S,P";
 		var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
         if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
              ComShowCodeMessage("PRI08003");
              sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
         }
  	}
	/**
     * cmdt_cd's validation check function <br>
     * @author 
     * @version 
     */
	function checkCommodity(sheetObj, Row, Value) {
		var formObj=document.form; 
		if(ComIsNull(Value)) {
			sheetObj.SetCellBackColor(i, 'prc_cmdt_def_cd',"#FF0000"); //red
			sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","");
			return false;
		}
		
		if (Value.length == 5) { //Group Commodity
			var propNo=sheetObj.GetCellValue(Row, "prop_no");
			var amdtSeq=sheetObj.GetCellValue(Row, "amdt_seq");
			var svcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
			formObj.f_cmd.value=SEARCH10;
			formObj.cd.value=Value;
 			sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+propNo+"&etc2="+amdtSeq+"&etc3="+svcScpCd+"&nm=proposal");
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] == "") {
				sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", false);
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "", false);
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
				return false;
			} else {
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "G", false);
				return true;
			}
		} else if (Value.length == 6) {
			formObj.f_cmd.value=SEARCH01;
 			var sXml=sheetObj.GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj)+"&cmdt_cd="+Value);
			var arrDesc=ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			if (arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", false);
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "", false);
				sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
				return false;
			} else {
				sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd", "C", false);
				return true;
			}
		} else {
			sheetObj.SetCellValue(Row,"prc_cmdt_def_cd", "", false);
			sheetObj.SelectCell(Row,"prc_cmdt_def_cd");
			return false;
		}
	}
	/**
     * checking validation function <br>
     * return error when mandatory item is null<br>
     * @author 
     * @version 
     */
	function checkCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	/**
     * prop_frt_rt_amt's validation check function <br>
     * @author 
     * @version 
     */
	function checkProposalFreightRateAmount(sheetObj, Row, Value) {
		if(ComIsNull(ComZeroToNull(Value))) {
			return false;
		}
		if(!ComIsMoneyNumber(Value)) {
			return false;
		}
		if(Value >= 10000000) {
			return false;
		}
		return true;
	}

	/**
     * bse_port_def_cd's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckBasePort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") == Value) {
			return false;
		}
		var formObj=document.form;
		if(Value.length == 4){
 			formObj.f_cmd.value=SEARCH17;
 			formObj.cd.value=Value;
 			var param="&etc1="+ formObj.prop_no.value +"&etc2="+ formObj.amdt_seq.value +"&etc3="+ formObj.svc_scp_cd.value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj)+param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				return true;
			} else {
				return false;
			}
		}else if(Value.length == 5){
			formObj.f_cmd.value=COMMAND31;
			formObj.cd.value=Value;
			var sOriDesGbCd=ComGetObjValue(formObj.org_dest_tp_cd);
			var sParam=FormQueryString(formObj)+"&etc1="+sOriDesGbCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
     * dir_call_flg's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckDirectCall(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if(sheetObj.GetCellValue(Row, "dir_call_flg") == 1) {
			sheetObj.SetCellEditable(Row, "dir_call_flg",1);
			return false;
		}
		return true;
	}
	/**
     * rat_ut_cd's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckPerType(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!validCheckCommonCode(sheetObj, Row, Value, "rat_ut_cd")) {
			return false;
		}
    	return true;
	}
	/**
     * prc_cgo_tp_cd's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckCargoType(sheetObj, Row, Value) {
		if(!validCheckCommonCode(sheetObj, Row, Value, "prc_cgo_tp_cd")) {
			return false;
		}
		var validPerClass="A,F,O,Q,S,P";
		var perClass=sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0);
        if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) > -1 && Value != "AK") {
       		return false;
        } else if(!ComIsNull(perClass) && validPerClass.indexOf(perClass) < 0 && Value == "AK") {
       		return false;
        }
        return true;
	}

	/**
     * curr_cd's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckCurrency(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!validCheckCommonCode(sheetObj, Row, Value, "curr_cd")) {
			return false;
		}
    	return true;
	}
	/**
     * checking validation function <br>
     * return error when mandatory item is null<br>
     * @author 
     * @version 
     */
	function validCheckCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}
	/**
     * prop_frt_rt_amt 's validation check function <br>
     * @author 
     * @version 
     */
	function validCheckProposalFreightRateAmount(sheetObj, Row, Value) {
		if(Value >= 10000000) {
			return false;
		}
		if(Value == "" && Value != "0"){
			return false;
		}
		return true;
	}
    /**
     * setting sheet's attribute function <br>
     * @author 
     * @version 
     */
    function setFirstValidCell(sheetObj) {
        var topRow=sheetObj.GetTopRow();
 		var lastRow=sheetObj.LastRow();
 		var lastCol=sheetObj.LastCol();
     	for(var i=topRow; i<=lastRow; i++) {
 			for(var j=0; j<=lastCol; j++) {
   				if(sheetObj.GetCellBackColor(i, j) == "#FF0000") {
                     sheetObj.SelectCell(i, j, false);
                     return;
                 }
 			}
     	}
    }
	/**
     * setting button's attribute function <br>
     * @author 
     * @version 
     */
	function toggleButtons(mode) {
		switch (mode) {
			case "CLEAR":
				ComBtnDisable("btn_template");
				ComBtnDisable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_close");
				break;
			case "INIT":
				ComBtnEnable("btn_template");
				ComBtnEnable("btn_openfile");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_close");
				break;
			case "READONLY":
				ComBtnEnable("btn_template");
				ComBtnEnable("btn_openfile");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_close");
				break;
		}
	}
	/**
     * checking validation process of inputted form data <br>
     * @author 
     * @version 
     */
    function validateForm(sheetObj,formObj,sAction){
    	  switch (sAction) {
	  		case IBSEARCH_ASYNC01: 
				var orgDestTpCd=formObj.org_dest_tp_cd.value;
		  		if (!sheetObj.IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
		  		var check=0;
		  		var color="#FF0000";
	  			formObj.f_cmd.value=SEARCH03;
	  	 		var sParam=FormQueryString(formObj);
	  	 		var sParamSheet1=sheetObjects[0].GetSaveString();
	  			sParam += "&" + sParamSheet1; 
 	  			var sXml=sheetObjects[3].GetSearchData("ESM_PRI_0024GS.do", sParam);
 	  			var tempXml = sXml.split("|$$|");
 	  			// DB Code & Digit validation check
 	  			if(tempXml.length > 0){
 	  				sheetObjects[3].LoadSearchData(tempXml[0], {Sync:1} );
 	  				check += checkDBCodeExist(sheetObjects[3], color);
 	  			}
 	  			// Note Sequence and Content validation check
 	  			var arbNoteCheckArr = new Array();
 	  			if(tempXml.length > 1){
 	  				arbNoteCheckArr = ComPriXml2Array(tempXml[1], "note_dp_seq|add_chg_note_ctnt");
 	  			}
	  	  		sheetObjects[4].RemoveAll();
		  	  	var sXml=ComPriSheet2Xml(sheetObjects[0]);
		  		ComPriXml2Sheet(sheetObjects[4], sXml);
		  	  	if(!validateArbNoteSeq(sheetObjects[4], arbNoteCheckArr)){
		  	  		check++;
				}
		  	   // Sheet Data Validation to check validity of each column
		  	  	if(check == 0){
		  	  	check += validateSheetData(sheetObj, formObj);
		  	  	}
		  		if(check > 0) {
		  			errFlg=true;
		  			ComBtnEnable("btn_check");
		  			ComBtnDisable("btn_save");
		  			setFirstValidCell(sheetObj);
		  			checkFlg = true;
		  			return false;
		  		} else {
		  			errFlg=true;
		  			checkFlg = false;
		  			sheetObj.SetEditable(0);
		  			for(var i=1; i<=sheetObj.LastRow(); i++){
		  				for(var j=1; j<=sheetObj.LastCol(); j++){
		  					sheetObj.SetCellBackColor(i, j,"#EFF0F3");
		  				}
		  			}
		  			ComBtnEnable("btn_save");
		  			ComBtnDisable("btn_check");
		  		}
		  		return true;
		  		break;
	  		case IBSAVE:
	  			if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			var rowDupCnt1=sheetObjects[0].ColValueDup("amdt_seq|rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|curr_cd|add_chg_note_ctnt", false);
	  			if (rowDupCnt1 >= 0) {
	  				ComShowCodeMessage("PRI00303", "Sheet", rowDupCnt1);
	  				ComBtnEnable("btn_check");
	  				ComBtnDisable("btn_save");
	  				makeSheetEditable(sheetObj);
	  				checkFlg = true;
				    return false;
	  			}
	  			//checking of duplicate with existing data
  				sheetObjects[2].RemoveAll();
  				var sXml=ComPriSheet2Xml(sheetObjects[0]);
  				ComPriXml2Sheet(sheetObjects[2],sXml);
	        	formObj.f_cmd.value=SEARCH02;
 				var sXml=sheetObjects[2].GetSearchData("ESM_PRI_0024GS.do", FormQueryString(formObj));
				sheetObjects[2].LoadSearchData(sXml,{Append:1 , Sync:1} );
				var rowM = sheetObjects[2].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|"
						+"bse_port_def_cd|via_port_def_cd|dir_call_flg|rat_ut_cd|prc_cgo_tp_cd|prc_cmdt_def_cd|"
						+"curr_cd|add_chg_note_ctnt", false,true);
				if (rowM != "") {
					 var rowDup=rowM.split("|");
	  				ComShowCodeMessage("PRI02017", rowDup[0]);
	  				ComBtnEnable("btn_check");
		  			ComBtnDisable("btn_save");
	  				makeSheetEditable(sheetObj);
	  				checkFlg = true;
	  				return false;
				}
	  			break;
    	  }
    	  return true;
    }
    
    
    /**
     * Make sheet as Editable mode <br>
     *
     * @param {object} sheetObj Mandatory, IBSheet Object.
     * @return void
     * @author 
     * @version 2016.01.06
     */
    function makeSheetEditable(sheetObj){	
    	sheetObj.SetEditable(1);
    	sheetObj.SetRangeBackColor(1,0,sheetObj.LastRow(),sheetObj.LastCol(),"#FFFFFF"); 
    	for(var i=1; i<=sheetObj.LastCol(); i++){
    		var colName = sheetObj.ColSaveName(i);
    		if(colName == "Seq"){  // Seq and seq(Note) disabled
    			sheetObj.SetColEditable(i, 0);	
    			sheetObj.SetRangeBackColor(1,i,sheetObj.LastRow(),i,"EFF0F3");  // make Note disabled for using MemoPad
    		}else if(colName == "add_chg_note_ctnt"){
    			sheetObj.SetColEditable(i, 0);	
    		}							
    	}
    }
    
 	/**
      * checking validation process of sheet's column data <br>
     * @author 
     * @version 
     */
 	function validateSheetData(sheetObj, formObj) {
 		var validCnt=0;
 		var rCnt=sheetObj.RowCount();
 		var baseColor="#FFFFFF";
 		var validColor="#FF0000";
		
 		for(var i=1; i<=rCnt; i++) {
 			if(sheetObj.GetCellValue(i, "type") == "P"){
 				continue;
 			}
      		sheetObj.SetCellValue(i, "prop_no",formObj.prop_no.value);
      		sheetObj.SetCellValue(i, "amdt_seq",formObj.amdt_seq.value);
      		sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value);
      		sheetObj.SetCellValue(i, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
      		sheetObj.SetCellValue(i, "add_chg_tp_cd",formObj.add_chg_tp_cd.value);
      		sheetObj.SetCellValue(i, "org_dest_tp_cd",formObj.org_dest_tp_cd.value);
      		sheetObj.SetCellValue(i, "src_info_cd","NW");
 			sheetObj.SetCellValue(i, "prc_prog_sts_cd","I");
      		// Trans Mode
 			if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "prc_trsp_mod_cd"), "prc_trsp_mod_cd")) {
      			sheetObj.SetCellBackColor(i, 'prc_trsp_mod_cd', validColor);
      			validCnt++;
      		}
      		// Term
 			if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "rcv_de_term_cd"), "rcv_de_term_cd")) {
      			sheetObj.SetCellBackColor(i, 'rcv_de_term_cd', validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, 'rcv_de_term_cd', baseColor);
      		}
 			if (sheetObj.GetCellValue(i, "min_cgo_wgt") != "" && sheetObj.GetCellValue(i, "min_cgo_wgt") > 999.999) {
 				sheetObj.SetCellBackColor(i, "min_cgo_wgt", validColor);
 				validCnt++;
 			}else {
 				sheetObj.SetCellBackColor(i, "min_cgo_wgt", baseColor);
 			}
 			if (sheetObj.GetCellValue(i, "max_cgo_wgt") != "" && sheetObj.GetCellValue(i, "max_cgo_wgt") > 999.999) {
 				sheetObj.SetCellBackColor(i, "max_cgo_wgt", validColor);
 				validCnt++;
 			}else {
 				sheetObj.SetCellBackColor(i, "max_cgo_wgt", baseColor);
 			}
 			// Base port
 			if(!validCheckBasePort(sheetObj, i, sheetObj.GetCellValue(i, "bse_port_def_cd"))) {
				sheetObj.SetCellBackColor(i, 'bse_port_def_cd', validColor);
				validCnt++;
			} else {
				sheetObj.SetCellBackColor(i, 'bse_port_def_cd', baseColor);
			}      		
      		// D/Call
 			if(!validCheckDirectCall(sheetObj, i, sheetObj.GetCellValue(i, "via_port_def_cd"))) {
      			sheetObj.SetCellBackColor(i, 'dir_call_flg', validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, 'dir_call_flg', baseColor);
      		}
      		// Per
 			if(!validCheckPerType(sheetObj, i, sheetObj.GetCellValue(i, "rat_ut_cd"))) {
      			sheetObj.SetCellBackColor(i, 'rat_ut_cd',validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, 'rat_ut_cd', baseColor);
      		}
      		// Cargo Type
 			if(!validCheckCargoType(sheetObj, i, sheetObj.GetCellValue(i, "prc_cgo_tp_cd"))) {
      			sheetObj.SetCellBackColor(i, 'prc_cgo_tp_cd',validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, 'prc_cgo_tp_cd', baseColor);
      		}
      		// Currency
 			if(!validCheckCurrency(sheetObj, i, sheetObj.GetCellValue(i, "curr_cd"))) {
      			sheetObj.SetCellBackColor(i, "curr_cd",validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, "curr_cd", baseColor);
      		}
      		// Proposal
 			if(!validCheckProposalFreightRateAmount(sheetObj, i, sheetObj.GetCellValue(i, "prop_frt_rt_amt").toString())) {
      			sheetObj.SetCellBackColor(i, "prop_frt_rt_amt",validColor);
      			validCnt++;
      		} else {
      			sheetObj.SetCellBackColor(i, "prop_frt_rt_amt", baseColor);
      		}
 		}
         document.body.scroll="no";
         
 		return validCnt;
 	}     
  /**
   * validation function of excel file loading <br>
   * existing error data, changed color <br>
   * @author 
   * @version 
   */
   function checkDBCodeExist(sheetObj, color) {
 	  	var check=0;
 	  	var arbSeq=0;
		for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if(sheetObjects[0].GetCellValue(i, "via_port_def_cd") != "") {
				if(sheetObj.GetCellValue(i, "via_port_def_cd") == "0"){
					sheetObjects[0].SetCellBackColor(i, "via_port_def_cd",color);
					check ++;
				} else {
					if(sheetObjects[0].GetCellValue(i, "via_port_def_cd").length == 4) {
						sheetObjects[0].SetCellValue(i, "via_port_tp_cd","G",0);
						sheetObjects[0].SetCellBackColor(i, "via_port_def_cd","#FFFFFF");
					} else if(sheetObjects[0].GetCellValue(i, "via_port_def_cd").length == 5) {
						sheetObjects[0].SetCellValue(i, "via_port_tp_cd","L",0);
						sheetObjects[0].SetCellBackColor(i, "via_port_def_cd","#FFFFFF");
					}
				}
			}
			if(sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == "0"){
				sheetObjects[0].SetCellBackColor(i, "rout_pnt_loc_def_cd",color);
				check ++;
			} else {
				sheetObjects[0].SetCellValue(i, "rout_pnt_loc_tp_cd","L", 0);
				sheetObjects[0].SetCellBackColor(i, "rout_pnt_loc_def_cd","#FFFFFF");
			}
			if(sheetObj.GetCellValue(i, "bse_port_def_cd") == "0"){
				sheetObjects[0].SetCellBackColor(i, "bse_port_def_cd",color);
				check ++;
			} else {
				if(sheetObjects[0].GetCellValue(i, "bse_port_def_cd").length == 4) {
					sheetObjects[0].SetCellValue(i, "bse_port_tp_cd","G",0);
					sheetObjects[0].SetCellBackColor(i, "bse_port_def_cd","#FFFFFF");
				} else if(sheetObjects[0].GetCellValue(i, "bse_port_def_cd").length == 5) {
					sheetObjects[0].SetCellValue(i, "bse_port_tp_cd","L",0);
					sheetObjects[0].SetCellBackColor(i, "bse_port_def_cd","#FFFFFF");
				}
			}
			
			if(sheetObjects[0].GetCellValue(i, "prc_cmdt_def_cd") != "") {
				if(sheetObj.GetCellValue(i, "prc_cmdt_def_cd") == "0"){
					sheetObjects[0].SetCellBackColor(i, "prc_cmdt_def_cd", color );
					check ++;
				} else {
					if(sheetObjects[0].GetCellValue(i, "prc_cmdt_def_cd").length == 5) {
						sheetObjects[0].SetCellValue(i, "prc_cmdt_tp_cd", "G", 0 );
						sheetObjects[0].SetCellBackColor(i, "prc_cmdt_def_cd","#FFFFFF");
					} else if(sheetObjects[0].GetCellValue(i, "prc_cmdt_def_cd").length == 6) {
						sheetObjects[0].SetCellValue(i, "prc_cmdt_tp_cd",  "C", 0 );
						sheetObjects[0].SetCellBackColor(i, "prc_cmdt_def_cd","#FFFFFF");
					}
				}
			}
		}
		return check;
   }
   
   /**
    * validate on saving arbitrary note sequence and content
    * 1. Check case with same note sequence but different note content : Hardstop <br>
    * 2. Check case with different note sequence but same note content : Give warning & option to synchronize sequence <br>
    *
    * @author NYK
    * @version 2016.07.28
    */
	  function validateArbNoteSeq(sheetObj, existingDupArr){
		  var loadLastRow = sheetObjects[0].LastRow();
		  var baseColor="#FFFFFF";
		  var validColor="#FF0000";
		  // UI data are set to "P" Type
		  if(existingDupArr != undefined){
			  for(var i=1; i<=existingDupArr.length; i++){
				  sheetObj.DataInsert(-1);
				  sheetObj.SetCellValue(loadLastRow+i, "type", "P");
				  sheetObj.SetCellValue(loadLastRow+i, "note_dp_seq", existingDupArr[i-1][0]);
				  sheetObj.SetCellValue(loadLastRow+i, "add_chg_note_ctnt", existingDupArr[i-1][1]);
			  }
		  }
		  // Load Excel data are set to "C" Type
		  for(var i=1; i<=loadLastRow; i++){
			  sheetObj.SetCellValue(i, "type", "C");
		  }
		  var validRowCnt = 0;
		  var rCnt = sheetObj.RowCount();
		  for(var i=1; i<=sheetObjects[0].RowCount(); i++){
			  sheetObjects[0].SetCellBackColor(i, "note_dp_seq", baseColor);
		  }
		  // validate on case of (1) empty note seq (2) zero note seq (3) note seq starting with 0
			for(var i=1; i<=rCnt; i++) {
				if(sheetObj.GetCellValue(i, "type") == "C") {
					if(sheetObj.GetCellValue(i, "add_chg_note_ctnt") == "") {
						if(sheetObj.GetCellValue(i, "note_dp_seq") != ""){
							sheetObjects[0].SetCellValue(i, "note_dp_seq","");
							sheetObj.SetCellValue(i, "note_dp_seq","");
							continue;						
						}
					}else{
						if(sheetObj.GetCellValue(i, "ibflag") != "D") {
							if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq") == "0"){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "note sequence more than 0");
								return false;
							}
							if(sheetObj.GetCellValue(i, "note_dp_seq").length > 1 && sheetObj.GetCellValue(i, "note_dp_seq").substring(0, 1) == "0"){
								sheetObjects[0].SetCellBackColor(i, "note_dp_seq", validColor);
								sheetObjects[0].SelectCell(i, "note_dp_seq");
								ComShowCodeMessage('PRI01042', "valid number on note sequence");
								return false;
							}
						}
					}
					sheetObjects[0].SetCellBackColor(i, "note_dp_seq", baseColor);
					if(sheetObj.GetCellValue(i, "note_dp_seq") == ""){
						validRowCnt++;
					}
				}
			}
	  	if(rCnt == 0){
	  		return true;
	  	}
	  	// exception logic in the case where any of note data aren't entered
	  	if(validRowCnt == sheetObjects[0].RowCount()){
	  		return true;
	  	}
	  	// validate on a case of same Sequence but different Content
	  	var seqDupChk = findArbNoteDupRow(sheetObj, "note_dp_seq");
	  	if(seqDupChk != undefined){
	  		var rtnVal = getNoteSeqDuplicated(sheetObj, seqDupChk);
	      	if(typeof rtnVal == "string"){
	      		sheetObjects[0].SetCellBackColor(rtnVal, "note_dp_seq", validColor);
	      		sheetObjects[0].SelectCell(rtnVal, "note_dp_seq");
	      		ComShowCodeMessage('PRI02023', rtnVal);
	      		return false;
	      	}
	  	}
	  	// validate on a case of same Content but different Sequence
	  	for(var i=1; i<=sheetObj.RowCount(); i++){
	  		sheetObj.SetCellValue(i, "note_ctnt_text", sheetObj.GetCellValue(i, "add_chg_note_ctnt").replace(/\s/gi, ''));
	  	}
	  	var ctntDupChk = findArbNoteDupRow(sheetObj, "note_ctnt_text");
	  	if(ctntDupChk != undefined){
	  		if(!setNoteSeqSynchronized(sheetObj, ctntDupChk)){
	      		return false;
	      	}
	  	}
	  	return true;
	   }
  
	  /**
	   * Check note seq / content's duplication and Return duplicated rows as array <br>
	   *
	   * @author NYK
	   * @version 2016.07.28
	   */
	  function findArbNoteDupRow(sheetObj, checkStr){
		 var dupArr = sheetObj.ColValueDupRows(checkStr, false, true).split("|");
		 if(dupArr[0] == undefined || dupArr[0] == ""){
			 return;
		 }
		 var dupArrFirst = dupArr[0].split(",");
		 var dupArrRest = dupArr[1].split(",");
		 var dupArrFinal = new Array();
		 var rtnArrFinal = new Array();
		 var finalArrCnt = 0;
		 // logic to find duplicated row number including first base(reference) row in terms of checkStr parameter
		 for(var k=0; k<dupArrFirst.length; k++){
			 dupArrFinal[finalArrCnt] = dupArrFirst[k];
			 for(var l=0; l<dupArrRest.length; l++){
				 if(sheetObj.GetCellValue(parseInt(dupArrFirst[k]), checkStr) == sheetObj.GetCellValue(parseInt(dupArrRest[l]), checkStr)){
					dupArrFinal[finalArrCnt] += "|" + dupArrRest[l];
				 }
			 }
			 finalArrCnt++;
		 }
		 // exclude empty string case in row duplication check
		 for(var i=0; i<dupArrFinal.length; i++){
			 if(sheetObj.GetCellValue(dupArrFinal[i][0], checkStr) == ""){
				 dupArrFinal.splice(i, 1);
				 break;
			 }
		 }
		 // return duplication row array
		 for(var j=0; j<dupArrFinal.length; j++){
			 rtnArrFinal[j] = dupArrFinal[j].split("|");
		 }
		 return rtnArrFinal;
	}
	  
	  /**
	   * After finding duplicated note content with same note sequence, return the first row index of those are duplicated. <br>
	    *
	    * @author NYK
	    * @version 2016.07.28
	   */
	  function getNoteSeqDuplicated(sheetObj, seqDupChk) {
	  	var seqDupArr = new Array();
	  	var seqInitialDupArr = new Array();
	  	var seqRestDupArr = new Array();
	  	var wrongCnt = 0;
	  	var rtnDupRow = "";
	  	var rtnDupCtnt = "";
	  	for(var i=0; i<seqDupChk.length; i++){
	  		if(seqDupChk[i].length <= 1){
	  			continue;
	  		}else{
	  			// consider note sequences made in UI tab as target of exisiting note sequences for comparison
	  			seqDupArr.length = 0;
	  			seqInitialDupArr.length = 0;
	  			seqRestDupArr.length = 0;
	  			for(var j=0; j<seqDupChk[i].length; j++){
	  				if(sheetObj.GetCellValue(seqDupChk[i][j], "type") == "C"){
						seqInitialDupArr.push(seqDupChk[i][j]);
					}else{
						seqRestDupArr.push(seqDupChk[i][j]);
					}
	  				seqDupArr.push(sheetObj.GetCellValue(seqDupChk[i][j], "add_chg_note_ctnt"));
	  			}
	  		}
	  		// return note sequence that is different to other note sequence with same content
    		// duplicated content check is based on only text, not considering empty space on it
	  		for(var k=0; k<seqDupArr.length; k++){
    			for(var h=k+1; h<seqDupArr.length; h++){
    				if(seqDupArr[k].replace(/\s/gi, '') != seqDupArr[h].replace(/\s/gi, '')){
    					wrongCnt++;
    					if(seqRestDupArr.length == 0){
    						rtnDupCtnt = sheetObj.GetCellValue(seqInitialDupArr[0], "add_chg_note_ctnt");
    					}else{
    						rtnDupCtnt = sheetObj.GetCellValue(seqRestDupArr[0], "add_chg_note_ctnt");
    					}
    					for(var l=0; l<seqInitialDupArr.length; l++){
    						if(sheetObj.GetCellValue(seqInitialDupArr[l], "add_chg_note_ctnt").replace(/\s/gi, '') != rtnDupCtnt.replace(/\s/gi, '')){
    							rtnDupRow = seqInitialDupArr[l];
    							break;
    						}
    					}
    					break;
    				}
    			}
    			break;
    		}
	  		if(wrongCnt > 0){
	  			return rtnDupRow;
	  		}
	  	}
	  	return true;
	  }
	  
	  /**
	   * Synchronize note sequence equally based on same content <br>
	    *
	    * @author NYK
	    * @version 2016.07.28
	   */
	  function setNoteSeqSynchronized(sheetObj, ctntDupArr) {
	  	var syncArr = new Array();
	  	var allSyncCnt = 0;
	  	var rCnt = sheetObj.RowCount();
	  	// Find minimum note sequence value based on same note contents
	  	for(var i=0; i<ctntDupArr.length; i++){
	  		var eachSyncCnt = 0;
	  		var minValArr = new Array();
	  		minValArr[0] = ctntDupArr[i];
	  		minValArr[1] = new Array();
	  		var tmpMinArr = new Array();
	  		for(j=0; j<ctntDupArr[i].length; j++){
	  			minValArr[1].push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	  			if(sheetObj.GetCellValue(ctntDupArr[i][j], "type") == "C"){
	  				continue;
	  			}
	  			tmpMinArr.push(sheetObj.GetCellValue(ctntDupArr[i][j], "note_dp_seq"));
	  		}
	  		if(tmpMinArr[0] == undefined){
	  			minValArr[2] = Math.min.apply(Math, minValArr[1]);
	  		}else{
	  			minValArr[2] = Math.min.apply(Math, tmpMinArr);
	  		}
	  		// Check whether same content is inputted with different sequence
	  		if(tmpMinArr[0] != undefined){
	  			for(var k=0; k<minValArr[1].length; k++){
	  				if(sheetObj.GetCellValue(minValArr[0][k], "type") == "C"){
	  					if(sheetObj.GetCellValue(minValArr[0][k], "note_dp_seq") != minValArr[2]){
		  					eachSyncCnt++;
		  				}
	  				}
	  			}
	  		}else{
	  			for(var k=0; k<minValArr[1].length; k++){
		  			for(var h=k+1; h<minValArr[1].length; h++){
		  				if(minValArr[1][k] != minValArr[1][h]){
		  					eachSyncCnt++;
		  				}
		  			}
		  		}
	  		}
	  		if(eachSyncCnt > 0){
	  			syncArr.push(minValArr);
	  			allSyncCnt++;
			}
	  	}
	  	// Show soft warning(option) to synchronize note sequence based on content
	  	if(allSyncCnt>0){
	     		if(ComShowCodeConfirm('PRI02024')){
	     			for(var i=0; i<syncArr.length; i++){
	     				for(var j=0; j<syncArr[i][0].length; j++){
	     					if(sheetObj.GetCellValue(syncArr[i][0][j], "type") == "P"){
	     						continue;
	     					}
	     					sheetObjects[0].SetCellValue(syncArr[i][0][j], "note_dp_seq", syncArr[i][2]);
	     				}
	         		}
	     		}
	  		}
	  	 return true;
	  }
	  
	  