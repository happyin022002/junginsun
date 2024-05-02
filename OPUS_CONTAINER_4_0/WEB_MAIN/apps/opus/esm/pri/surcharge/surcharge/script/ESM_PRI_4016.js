/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4016.js
*@FileTitle  : Upload Excel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
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
 * @class ESM_PRI_4016 : Business Script for ESM_PRI_4016
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var errFlg=false; 
	var appType = "";
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
     * @version 2009.07.28
     */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        var sheetObject4=sheetObjects[3];
        var sheetObject5=sheetObjects[4];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;

    		switch(srcName) {
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
     * @version 2009.07.28
     */
    function setSheetObject(sheet_obj){
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
     * @version 2009.07.28
     */
    function loadPage() {
    	
    	if (!opener) opener = window.dialogArguments;
    	if (!opener) opener = window.opener;
    	if (!opener) opener = parent;
    	
        for(i=0;i<sheetObjects.length;i++){
        	//Modify Environment Setting Function's name
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            //Add Environment Setting Function
            ComEndConfigSheet(sheetObjects[i]);
        }
        pageOnLoadFinish();
        
        var formObj = document.form;
        appType = formObj.flt_pct_tp_cd.value;
        if(appType == "P") {
			var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:4, EditLen:12 };
         	sheetObjects[0].SetColProperty(0, "scg_amt" ,info);
		} else {
			var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:2, EditLen:12 };
         	sheetObjects[0].SetColProperty(0, "scg_amt" ,info);
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
     * @version 2009.07.28
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
     	var sheetID=sheetObj.id;
        switch(sheetID) {
        	case "sheet1":      // screen show
        	    with(sheetObj){
		              var HeadTitle1="|Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Remark(s)|||||||";
		              var HeadTitle2="|Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Amount|Pay Term|Effective\nDate|Expiration\nDate|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|S/I|Remark(s)|||||||";
		              var headCount=ComCountHeadTitle(HeadTitle2);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:180 } );
		              var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"scg_amt",             KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Float",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_trsp_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"io_ga_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                     {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"soc_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:1,   SaveName:"scg_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd" },
		                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"scg_seq" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"por_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_tp_cd" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_tp_cd" } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetWaitImageVisible(0);
		              SetColProperty("org_trsp_mod_cd", {ComboText:orgTrspModCdText, ComboCode:orgTrspModCdValue} );
		              SetColProperty("dest_trsp_mod_cd", {ComboText:destTrspModCdText, ComboCode:destTrspModCdValue} );
		              SetColProperty("usa_svc_mod_cd", {ComboText:usaSvcModCdText, ComboCode:usaSvcModCdValue} );
		              SetColProperty("prc_rcv_term_cd", {ComboText:prcRcvTermCdText, ComboCode:prcRcvTermCdValue} );
		              SetColProperty("prc_de_term_cd", {ComboText:prcDeTermCdText, ComboCode:prcDeTermCdValue} );
		              SetColProperty("prc_hngr_bar_tp_cd", {ComboText:prcHngrBarTpCdText, ComboCode:prcHngrBarTpCdValue} );
		              SetColProperty("pay_term_cd", {ComboText:payTermCdText, ComboCode:payTermCdValue} );
		              SetColProperty("rat_ut_cd", {ComboText:ratUtCdText, ComboCode:ratUtCdValue} );
		              SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdText, ComboCode:prcCgoTpCdValue} );
		              SetColProperty("scg_imdg_clss_cd", {ComboText:scgImdgClssCdText, ComboCode:scgImdgClssCdValue} );
		              SetColProperty("curr_cd", {ComboText:currCdText, ComboCode:currCdValue} );
		              SetColProperty("dir_call_flg", {ComboText:dirCallFlgText, ComboCode:dirCallFlgValue} );
		              SetColProperty("soc_flg", {ComboText:socFlgText, ComboCode:socFlgValue} );
		              SetColProperty("io_ga_cd", {ComboText:ioGaCdText, ComboCode:ioGaCdValue} );
		              SetColProperty("sub_trd_cd", {ComboText:subTrdCdText, ComboCode:subTrdCdValue} );
		              SetColProperty("cnl_tz_cd", {ComboText:cnlTzCdText, ComboCode:cnlTzCdValue} );
		              SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
		              //SetAutoRowHeight(0);
		              SetSheetHeight(390);
              		}
		    	break; 
	        case "sheet2":
	            with(sheetObj){
			          var HeadTitle="|flt_ptc_tp_cd|pct_bse_cd|por|pol|pod|del|rcv_de_term|imdg|canal|cgo_wgt|trns_mod|hngr_bar|sub|slan|dir_call|tml|cmdt|gauge|ts_port|soc|gri_cmdt|usa_svc|esvc";
			          var headCount=ComCountHeadTitle(HeadTitle);
			          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			          var headers = [ { Text:HeadTitle, Align:"Center"} ];
			          InitHeaders(headers, info);
			          var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"flt_pct_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pct_bse_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_use_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cgo_wgt_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trns_mod_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hngr_bar_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"slan_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"io_ga_use_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_use_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"soc_use_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"gri_cmdt_use_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_use_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"esvc_use_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
			          InitColumns(cols);
			          SetEditable(0);
			          SetWaitImageVisible(0);
			          SetAutoRowHeight(0);
			          SetSheetHeight(50);
	          		}
				break;
            case "sheet3": //Temp sheet to check duplication
                with(sheetObj){
		              var HeadTitle1="Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|S/I";
		              var HeadTitle2="Seq|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|Commodity\nGroup|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|S/I";
		              var headCount=ComCountHeadTitle(HeadTitle2);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"org_trsp_mod_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"io_ga_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd" },
		                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"soc_flg" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd" },
		                     {Type:"Date",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Date",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd" }];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(50);
                    }
	        	break;
            case "sheet4" :  // hidden
                with(sheetObj){
	            	var HeadTitle="status";
	            	var headCount=ComCountHeadTitle(HeadTitle);
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
	        
            case "sheet5": //Temp sheet to check duplication for db check
                with(sheetObj){
		              var HeadTitle1="Seq|POR_V|POL_V|POD_V|DEL_V|TS_PORT_V|TML_CD_V|CMDT_CD_V|POR_TP_V|POL_TP_V|POD_TP_V|DEL_TP_V|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|Weight|Weight|Trans. Mode|Trans. Mode|R/D Term|R/D Term|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|GRI\nCommodity|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|S/I";
		              var HeadTitle2="Seq|POR_V|POL_V|POD_V|DEL_V|TS_PORT_V|TML_CD_V|CMDT_CD_V|POR_TP_V|POL_TP_V|POD_TP_V|DEL_TP_V|POR|POL|POD|DEL|PER|Cargo\nType|IMDG\nClass|Cur.|Pay Term|Canal|MIN <= TON|MAX > TON|Origin|Dest|Origin|Dest|Bar Type|Sub-trade|Lane|Direct Call|Terminal|Commodity|In/Out Gauge|T/S Port|Shipper's Own\nContainer(S.O.C)|GRI\nCommodity|US Service\nMode|Del\nMark|Effective\nDate|Expiration\nDate|S/I";
		              var headCount=ComCountHeadTitle(HeadTitle2);
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},
		                              { Text:HeadTitle2, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                           
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd_vld" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_tp_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_tp_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_tp_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_tp_cd_vld" }, 
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dup_idx" },
		                           
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_def_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"scg_imdg_clss_cd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnl_tz_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"org_trsp_mod_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dest_trsp_mod_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_rcv_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_de_term_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"prc_hngr_bar_tp_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir_call_flg" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_cd" },
		                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"io_ga_cd" },
		                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ts_port_cd" },
		                     {Type:"Text",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"soc_flg" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"scg_grp_cmdt_cd" },
		                     {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"usa_svc_mod_cd" },
		                     {Type:"Date",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Date",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd" }];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(150);
                    }
	        	break;
	        
	        
	        
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
     * @version 2009.07.28
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg(false);
    	try{
    		switch (sAction) {
			case IBCLEAR: 
				formObj.f_cmd.value=COMMAND06;
				formObj.cd.value=formObj.svc_scp_cd.value;
				sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObj, sXml, "vsl_slan_cd", true, 0, '', '', true);
				formObj.f_cmd.value=COMMAND10;
				sXml=sheetObjects[1].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
				setIBCombo(sheetObj, sXml, "scg_grp_cmdt_cd", true, 0);
				break;
			case IBSEARCH: 
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=SEARCH02;
				sheetObj.DoSearch("ESM_PRI_4016GS.do", FormQueryString(formObj) );
				ComOpenWait(false);
				break;
				
			case IBSEARCH_ASYNC01: //Check

				validateForm(sheetObj,formObj,sAction);
				
				break;
				
			case IBSAVE: // Creation
				setTimeout(function(){ ComOpenWait(true); }, 10);
				
				setTimeout(function(){
				
					if (!validateForm(sheetObj, formObj, sAction)) {
						ComOpenWait(false);
						return;
					}
					formObj.f_cmd.value=MULTI01;
					var sParam="";
					var sParamSheet2=sheetObjects[0].GetSaveString(true);
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					formObj.f_cmd.value=MULTI01;
					sXml=sheetObjects[0].GetSaveData("ESM_PRI_4016GS.do", FormQueryString(formObj) + sParam);
					sheetObjects[0].LoadSaveData(sXml, {Sync:1});
					
				
				}, 1000);
				
				
				
				break;
			}   			  		
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }finally{
        	if (sAction == IBCLEAR  ) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
	}
	/**
	 * It calls when OnSearchEnd event triggered on sheet2 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {string} ErrMsg mandatory from server
	 * @return void
	 * @author 
	 * @version 2009.07.20
	 */
	function sheet2_OnSearchEnd(sheetObj, errMsg) {
		 if (errMsg == "") {
			setSheetHeader(sheetObj);
		}
	}
	/**
	 * Calling funciton in case of OnChange event on sheet1<br>
	 * when selecting multi comboBox, showing description and retrieveing validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @param {string} Value Mandatory Value
	 * @return void
	 * @author 
	 * @version 2009.07.20
	 */
	 function sheet1_OnChange(sheetObj, Row, Col, Value) {
	 	var formObj=document.form;
	 	var sName=sheetObj.ColSaveName(Col);
	 	var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
	 	var sChgCd=sheetObj.GetCellValue(Row, "chg_cd");
	 	switch (sName) {
	 	case "por_def_cd":
	 		checkLocation(sheetObj, Row, "por_tp_cd", "por_def_cd", true, true, true, true);
	 		break;
	 	case "pol_def_cd":
	 		checkLocation(sheetObj, Row, "pol_tp_cd", "pol_def_cd", true, true, true, true);
	 		break;
	 	case "pod_def_cd":
	 		checkLocation(sheetObj, Row, "pod_tp_cd", "pod_def_cd", true, true, true, true);
	 		break;
	 	case "del_def_cd":
	 		checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd", true, true, true, true);
	 		break;
	 	case "ts_port_cd":
	 		checkTSPort(sheetObj, Row, Value);
	 		break;
	 	case "tml_cd":
			checkTerminalCode(sheetObj, Row, Value);
			break;
	 	case "cmdt_cd":
	 		checkCommodity(sheetObj, Row, Value);
	 		break;
	 	case "rat_ut_cd":
	 		checkPerType(sheetObj, Row, Value);
	 		break;
	 	case "prc_cgo_tp_cd":
	 		checkCargoType(sheetObj, Row, Value);
	 		break;
	 	case "scg_amt":
	 		if (Value == 0) {
	 			sheetObj.InitCellProperty(Row, Col,{ Type:"Int",Align:"Right",Format:"Integer", EditLen:12} );
	 		} else {

	 	        if(appType == "P") {
	 				var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:4, EditLen:12 };
	 				sheetObj.InitCellProperty(Row, Col,info);
	 			} else {
	 				var info = {Type:"Float", Align:"Right", Format:"Float", PointCount:2, EditLen:12 };
	 				sheetObj.InitCellProperty(Row, Col,info);
	 			}
	 		}
	 		break;

	 	}
	}
	 /**
		 * Calling funciton in case of OnAfterEdit event on sheet1<br>
		 * when selecting multi comboBox, showing description and retrieveing validation <br>
		 * <br><b>Example :</b>
		 * <pre>
		 *
		 * </pre>
		 * @param {ibsheet} sheetObj mandatory IBSheet Object
		 * @param {int} Row mandatory Onclick ,Cell's Row Index
		 * @param {int} Col mandatory Onclick ,Cell's Column Index
		 * @return void
		 * @author 
		 * @version 2014.11.25
		 */
	 function sheet1_OnAfterEdit(sheetObj, Row, Col) {
		 	var formObj=document.form;
		 	var sName=sheetObj.ColSaveName(Col);

		 	switch (sName) {
		 	case "eff_dt":
				checkDatePeriod(sheetObj, Row, "eff_dt");
				break;
			case "exp_dt":
				checkDatePeriod(sheetObj, Row, "exp_dt");
				break;
		 	}
	 }
	/**
   	 * calling Event when keyboard press data cell <br> 
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 
   	 * </pre>
   	 * @param {ibsheet} sheetObj mandatory IBSheet Object
   	 * @param {Long} Row mandatory , Row Index of cell that event triggered
   	 * @param {Long} Col mandatory , Column Index of cell that event triggered
   	 * @param   {Integer} KeyCode Mandatory ASCII code value
   	 * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
   	 * @return void
   	 * @author 
   	 * @version 2009.07.20
   	 */ 
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
        if (errFlg && KeyCode == 9) {
        	while (true) {
				Col++;
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
	 * It calls when OnPopupClick event triggered on sheet1 <br>
	 * calling popup window <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.07.20
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
	    var colName=sheetObj.ColSaveName(Col);
	  	var formObj=document.form;
	  	var sSvcScpCd=sheetObj.GetCellValue(Row, "svc_scp_cd");
	  	var sChgCd=sheetObj.GetCellValue(Row, "chg_cd");
	  	_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
	  	
	  	var tpCd="";
	  	if (colName == "por_def_cd") { //POR
	  		var sUrl="ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		ComOpenPopup(sUrl, 700, 325, "por_def_cd_returnVal", "1,0", false);
	  		
	  	} else if (colName == "pol_def_cd") { //POL
	  		var sUrl="ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		ComOpenPopup(sUrl, 700, 325, "pol_def_cd_returnVal", "1,0", false);
	  		
	  	} else if(colName == "pod_def_cd") { //POD
	  		var sUrl="ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		ComOpenPopup(sUrl, 700, 325, "pod_def_cd_returnVal", "1,0", false);
	  		
	  	} else if(colName == "del_def_cd") { //DEL
	  		var sUrl="ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=LGRC&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		ComOpenPopup(sUrl, 700, 325, "del_def_cd_returnVal", "1,0", false);
	  		
	  	} else if(colName == "ts_port_cd") { //ts port
	  		var sUrl="ESM_PRI_4026.do?group_cmd="+PRI_SCG+"&location_cmd=L";
	  		ComOpenPopup(sUrl, 700, 325, "ts_port_cd_returnVal", "1,0", false);
	  		
	  	} else if(colName == "tml_cd") { //Terminal Code
	  		var tmlCd=sheetObj.GetCellValue(Row, Col);
			var param='?mode=yard&node_cd='+tmlCd;
			ComOpenPopup('COM_ENS_061.do' + param, 780, 530, 'callBackTerminalCode', "1,0,1,1,1", false);
	  	} else if (colName == "cmdt_cd") { //commodity
	  		var sUrl="ESM_PRI_4027.do?grp_cd="+PRI_SCG+"&commodity_cmd=C&svc_scp_cd="+sSvcScpCd+"&chg_cd="+sChgCd;
	  		ComOpenPopup(sUrl,  700, 330, "cmdt_cd_returnVal", "1,0", false);
	  		
	  	}
	}
	
	function por_def_cd_returnVal(rtnVal) {
		var tpCd="";
		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, 0);
  			if (rtnVal.cd.length == 5) { // Modifying Location Type
  				tpCd="L";
  			} else if (rtnVal.cd.length == 4) { // Modifying Location Type
  				tpCd="G";
  			}
  			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "por_tp_cd", tpCd, 0);
  		}
	}
	
	function pol_def_cd_returnVal(rtnVal) {
		var tpCd="";
		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd,0);
  			if (rtnVal.cd.length == 5) { // Modifying Location Type
  				tpCd="L";
  			} else if (rtnVal.cd.length == 4) { // Modifying Location Type
  				tpCd="G";
  			}
  			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "pol_tp_cd", tpCd,0);
  		}
	}
	
	function pod_def_cd_returnVal(rtnVal) {
		var tpCd="";
		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd,0);
			if (rtnVal.cd.length == 5) { // Modifying Location Type
				tpCd="L";
			} else if (rtnVal.cd.length == 4) { // Modifying Location Type
				tpCd="G";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "pod_tp_cd", tpCd, 0);
		}
	}
	
	function del_def_cd_returnVal(rtnVal) {
		var tpCd="";
		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd,0);
			if (rtnVal.cd.length == 5) { // Modifying Location Type
				tpCd="L";
			} else if (rtnVal.cd.length == 4) { // Modifying Location Type
				tpCd="G";
			}
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "del_tp_cd", tpCd, 0);
		}
	}
	
	function ts_port_cd_returnVal(rtnVal) {
		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, 0);
  		}
	}
	
	function cmdt_cd_returnVal(rtnVal) {
		var tpCd="";

		if (rtnVal != null) {
			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, _tmp_sheetObject.col, rtnVal.cd, 0);
  			if (rtnVal.cd.length == 6) {
  				tpCd="C";
  			}
  			_tmp_sheetObject.sheet.SetCellValue(_tmp_sheetObject.row, "prc_cmdt_tp_cd", tpCd, 0);
  		}
	}
	
	
	
	/**
	 * Calling function when Terminal Code popup is closed. <br>
	 * Display the code from popup. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {String} locTp Mandatory location classification (Not Use)
	 * @param {array} rArray Code Value array
	 * @return void
	 * @author 
	 * @version 2009.06.04
	 */
	function callBackTerminalCode(rowArray){
		 var colArray=rowArray[0];
	     if(rowArray != null) {
	    	 sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "tml_cd",colArray[3],0);
	     } else {
	    	 sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "tml_cd","",0);
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
     * @version 2009.07.20
     */  
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
	 	var colname=sheetObj.ColSaveName(Col);
	 	switch (colname) {
		 	case "scg_rmk":
		 		ComShowMemoPad(sheetObj,Row, Col,false, 200, 200,1000,1);
		 		break;
	 	}
	}
	 /**
     * It calls when LoadExcel event triggered on sheet1 <br>
     * @author 
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
 	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
 		if(isExceedMaxRow(msg))return;
    	setSheetDisplay(sheetObj);
    	ComBtnDisable("btn_save");
    	sheetObjects[4].RemoveAll();
	
 	}
    /**
     * It calls when OnSaveEnd event triggered on sheet1 <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.07.20
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg)  {
  		ComOpenWait(false);
  		
  		if(Code >= 0) {
    		
  			var reval = "S";
    		ComPopUpReturnValue(reval);
 			
 		}
    	 

	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	 toggleButtons("CLEAR");
         doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
         doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
         toggleButtons("INIT");
    }
    /**
     * Setting Header of sheet <br>
     * when cell has data, you can see it. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSheetHeader(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return void
     * @author 
     * @version 2009.07.20
     */ 	
	function setSheetHeader(sheetObj) {
		setFltPctTpCd(sheetObj.GetCellValue(1, "flt_pct_tp_cd"));
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "por_use_flg"), "por_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "pol_use_flg"), "pol_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "pod_use_flg"), "pod_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "del_use_flg"), "del_def_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "rcv_de_term_use_flg"), "prc_rcv_term_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "rcv_de_term_use_flg"), "prc_de_term_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "imdg_clss_use_flg"), "scg_imdg_clss_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "cnl_tz_flg"), "cnl_tz_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "cgo_wgt_use_flg"), "min_cgo_wgt");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "cgo_wgt_use_flg"), "max_cgo_wgt");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "trns_mod_use_flg"), "org_trsp_mod_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "trns_mod_use_flg"), "dest_trsp_mod_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "hngr_bar_use_flg"), "prc_hngr_bar_tp_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "sub_trd_use_flg"), "sub_trd_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "slan_use_flg"), "vsl_slan_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "dir_call_use_flg"), "dir_call_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "tml_use_flg"), "tml_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "cmdt_use_flg"), "cmdt_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "io_ga_use_flg"), "io_ga_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "ts_port_use_flg"), "ts_port_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "soc_use_flg"), "soc_flg");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "gri_cmdt_use_flg"), "scg_grp_cmdt_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "usa_svc_mod_use_flg"), "usa_svc_mod_cd");
		setSheetColumnHidden(sheetObjects[0], sheetObj.GetCellValue(1, "esvc_use_flg"), "bkg_esvc_tp_cd");
	}
	/**
     * Setting "hidden" option on column of sheet <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setSheetColumnHidden(sheetObjects[0], sheetObj.CellValue(1, "io_ga_use_flg"), "io_ga_cd")
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param (string) value Mandatory
     * @param (string) colName Mandatory
     * @return void
     * @author 
     * @version 2009.07.20
     */ 	
	function setSheetColumnHidden(sheetObj, value, colName) {
		if(value == "Y") {
			sheetObj.SetColHidden(colName,0);
		} else {
			sheetObj.SetColHidden(colName,1);
		}
	}
	/**
     * Depend on flc_pct_tp_cd, Change Title name & Column property <br>
     * <br><b>Example :</b>
     * <pre>
     * 		setFltPctTpCd(sheetObj.CellValue(1, "flt_pct_tp_cd"))
     * </pre>
     * @param (string) code Mandatory
     * @return void
     * @author 
     * @version 2009.07.20
     */ 	
	function setFltPctTpCd(code) {
    	 if (code == 'F') {
			sheetObjects[0].SetColProperty(0, sheetObjects[0].SaveNameCol('curr_cd'), {
    			 Type:"Combo", Hidden:0, Width:60, Align:"Center", ColMerge:1,   SaveName:"curr_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 
    		});

			sheetObjects[0].SetCellValue(0, "scg_amt","Amount");
			sheetObjects[0].SetCellValue(1, "scg_amt","Amount");
			sheetObjects[0].SetColHidden("curr_cd",0);
		} else {

			sheetObjects[0].SetColProperty(0, sheetObjects[0].SaveNameCol('curr_cd'), {
				Type:"Combo", Hidden:0, Width:60, Align:"Center", ColMerge:1,   SaveName:"curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0
			});
			sheetObjects[0].SetCellValue(0, "scg_amt","Percentage %");
			sheetObjects[0].SetCellValue(1, "scg_amt","Percentage %");
			sheetObjects[0].SetColHidden("curr_cd",1);
		}
	}
	/**
     * Validating location code  <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkLocation(sheetObj, Row, "del_tp_cd", "del_def_cd");
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function checkLocation(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		var formObj=document.form;
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		if(ComIsNull(locCd)) {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return;
		}
		if (locCd.length == 5) {
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=locCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.SetCellValue(Row, cellTpCdNm,"L",0);
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		else if (locCd.length == 4) {
			formObj.f_cmd.value=COMMAND11;
			formObj.cd.value=locCd;
			var param="&etc1=" + sheetObj.GetCellValue(Row, "svc_scp_cd") + "&etc2=" + sheetObj.GetCellValue(Row, "chg_cd");
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "G");
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		else if (locCd.length == 2) {
			formObj.f_cmd.value=SEARCH07;
			formObj.cd.value=locCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "C");
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		}
		else if (locCd.length == 3) {
			formObj.f_cmd.value=COMMAND08;
			formObj.cd.value=locCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData[1] != "") {
				sheetObj.SetCellValue(Row, cellTpCdNm, "R");
			} else {
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			return false;
 		}
		return true;
	}
	/**
     * ts_port_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTSPort(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function checkTSPort(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		if (Value.length == 5) {
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=Value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row, "ts_port_cd","",0);
			}
		} else {
			sheetObj.SetCellValue(Row, "ts_port_cd","",0);
		}
	}
	/**
     * cmdt_cd's validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCommodity(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function checkCommodity(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		if(Value.length == 6) {
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_PRI_4027GS.do", FormQueryString(formObj) + "&cmdt_cd=" + Value);
			var arrDesc=ComPriXml2Array(sXml, "cmdt_cd|cmdt_nm");
			if (arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row, "cmdt_cd", "");
				sheetObj.SelectCell(Row, "cmdt_cd");
			} else {
				sheetObj.SetCellValue(Row, "cmdt_cd", Value);
			}
		} else {
			sheetObj.SetCellValue(Row, "cmdt_cd", "");
			sheetObj.SelectCell(Row, "cmdt_cd");
		}
	}
	/**
     * rat_ut_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkPerType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.20
     */
     function checkPerType(sheetObj, Row, Value) {
  		var validPerClass="A,F,O,Q,S,P";
  		if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") == "AK" &&
 				(ComIsNull(Value) || (validPerClass.indexOf(Value.charAt(0)) < 0 && Value != "20" && Value != "40" && Value != "HC" && Value != "BX"))) {
  			ComShowCodeMessage("PRI02011");
     		sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
         }
  	}
	/**
     * prc_cgo_tp_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkCargoType(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function checkCargoType(sheetObj, Row, Value) {
		if(Value == "AK") {
            var validPerClass="A,F,O,Q,S,P";
            var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
            if((validPerClass.indexOf(ratUtCd.charAt(0)) < 0 && ratUtCd != "20" && ratUtCd != "40" && ratUtCd != "HC" && ratUtCd != "BX") || ComIsNull(ratUtCd)) {
            	ComShowCodeMessage("PRI02011");
                sheetObj.SetCellValue(Row, "prc_cgo_tp_cd","",0);
            }
        } else if (Value == "DG") {
 			sheetObj.SetCellEditable(Row, "scg_imdg_clss_cd",1);
 		} else {
 			sheetObj.SetCellValue(Row, "scg_imdg_clss_cd","",0);
 			sheetObj.SetCellEditable(Row, "scg_imdg_clss_cd",0);
 		}
	}
	/**
	 * eff_dt & exp_dt Validation check function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {String} colName Mandatory Onclick Cell's Column Name
	 * @return void
	 * @author 
	 * @version 2009.07.20
	 */
	function checkDatePeriod(sheetObj, Row, colName) {
		var effDt=sheetObj.GetCellValue(Row, "eff_dt");
		var expDt=sheetObj.GetCellValue(Row, "exp_dt");
		if(ComIsNull(effDt) || ComIsNull(expDt)) {
			return;
		}
		if(getDateObj(effDt) == null || getDateObj(expDt) == null) {
			return;
		}
		var vPeriod = ComChkPeriod(sheetObj.GetCellValue(Row, "eff_dt"), sheetObj.GetCellValue(Row, "exp_dt"));
		if(parseInt(vPeriod) < 1) {
			ComShowCodeMessage('PRI00306');
			sheetObj.SetCellValue(Row, colName, "", 0);
			sheetObj.SelectCell(Row, colName, 0, "", 0);
		}
	}
	/**
     * tml_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    checkTerminalCode(sheetObj, Row, Value);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function checkTerminalCode(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return;
		}
		var formObj=document.form;
		if (Value.length == 7) {
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObjects[0].GetSearchData("COM_ENS_061GS.do" , FormQueryString(formObj)+"&node_cd="+Value);
			var arrDesc=ComPriXml2Array(sXml, "yd_cd");
			if(arrDesc == null || arrDesc.length < 1) {
				sheetObj.SetCellValue(Row, "tml_cd","",0);
			}
		} else {
			sheetObj.SetCellValue(Row, "tml_cd","",0);
		}
	}
	/**
     * Re-setting location code <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param (string) cellTpCdNm selected cell's tp code
     * @param (string) cellDefCdNm selected cell's def code
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.SetCellValue(Row, cellTpCdNm,"",0);
		sheetObj.SetCellValue(Row, cellDefCdNm,"",0);
	}

	/**
     * Validating location code  <br>
     * return error when mandatory item is null<br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCommonCode(sheetObj, i, sheetObj.CellValue(i, "pay_term_cd"), "pay_term_cd")
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @param (string) CellName mandatory , Name of cell that event triggered
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckCommonCode(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, CellName)) != "") {
			return false;
		}
		return true;
	}

	/**
     * min_cgo_wgt validation check function <br>
     * Check min_cgo_wgt validation ( Min & Max value Boundary Rule , Numeric Only Rule ) <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckMinCargoWeight(sheetObj, i, sheetObj.CellValue(i, "min_cgo_wgt"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckMinCargoWeight(sheetObj, Row, Value) {
		var sValue = Value.toString();
		if(ComIsNull(Value)) {
			return true;
		}
		if(!ComIsMoneyNumber(sValue)) {
			return false;
		}
		if(parseInt(Value) < 0) {
			return false;
		}
		if(parseInt(Value) >= 10000) {
			return false;
		}
		return true;
	}
	/**
     * max_cgo_wgt validation check function <br>
     * Check max_cgo_wgt validation ( Min & Max value Boundary Rule , Numeric Only Rule ) <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckMinCargoWeight(sheetObj, i, sheetObj.CellValue(i, "min_cgo_wgt"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckMaxCargoWeight(sheetObj, Row, Value) {
		var sValue = Value.toString();
		if(ComIsNull(Value)) {
			return true;
		}
		if(!ComIsMoneyNumber(sValue)) {
			return false;
		}
		if(parseInt(Value) < 0) {
			return false;
		}
		if(parseInt(Value) >= 10000) {
			return false;
		}
		return true;
	}

	/**
     * rat_ut_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckCargoType(sheetObj, Row, Value) {
		var validPerClass="A,F,O,Q,S,P";
		var ratUtCd=sheetObj.GetCellValue(Row, "rat_ut_cd");
		if(Value == "AK" && (validPerClass.indexOf(sheetObj.GetCellValue(Row, "rat_ut_cd").charAt(0)) < 0 && ratUtCd != "20" && ratUtCd != "40" && ratUtCd != "HC" && ratUtCd != "BX")) {
       		return false;
        }
        return true;
	}
	/**
     * scg_imdg_clss_cd validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckImdgClss(sheetObj, i, sheetObj.CellValue(i, "scg_imdg_clss_cd"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckImdgClss(sheetObj, Row, Value) {
		if(ComIsNull(Value) && ComTrim(sheetObj.GetCellText(Row, "scg_imdg_clss_cd")) != "") {
			return false;
		} 
		if(ComIsNull(Value)) {
			return true;
		}
		if(sheetObj.GetCellValue(Row, "prc_cgo_tp_cd") != "DG") {
			return false;
		}
		return true;
	}
	/**
     * mandatory validation check function <br>
     * UI 4.0 크롬버전으로 변경되면서 콤보에 존재하지 않는 값은 load 되지 않고 있습니다. 
     * mandatory 콤보항목일 경우 아래의 함수를 사용하면 됩니다.
     * @version 2014-12-11
     */ 
	function validCheckMandatory(sheetObj, Row, Value, CellName) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!validCheckCommonCode(sheetObj, Row, Value, CellName)) {
			return false;
		}
    	return true;
	}
	/**
     * scg_amt validation check function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckSurchargeAmount(sheetObj, i, sheetObj.CellValue(i, "scg_amt"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckSurchargeAmount(sheetObj, Row, Value) {
		var sValue = Value.toString();  //20140923
		if(ComIsNull(Value) && Value != 0) {
			return true;
		}		
		if(!ComIsMoneyNumber(sValue)) {		
			return false;
		}
		if(ComIsContainsChars(sValue, ".")) {
			var temp=sValue.split(".");
			if(temp[0].length > 9) {
				return false;
			}
			
 	        if(appType == "P") {
				if(temp[1].length > 4) {
					return false;
				}
 	        } else {
 	        	if(temp[1].length > 2) {
					return false;
				}
 	        }
		} else {
			if(sValue.length > 9) {
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
     * eff_dt validation check function <br>
     * check whether the data is date. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckEffectiveDate(sheetObj, i, sheetObj.CellValue(i, "eff_dt"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckEffectiveDate(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return false;
		}
		if(!ComIsDate(Value, "ymd")) {
			return false;
		}
		return true;
	}
	/**
     * exp_dt validation check function <br>
     * check whether the data is date. <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckEffectiveDate(sheetObj, i, sheetObj.CellValue(i, "exp_dt"))
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {string} Value Mandatory Value
     * @return boolean
     *          true  : Valid
     *          false : invalid
     * @author 
     * @version 2009.07.20
     */ 
	function validCheckExpireDate(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if(!ComIsDate(Value, "ymd")) {
			return false;
		}
		var vPeriod = ComChkPeriod(sheetObj.GetCellValue(Row, "eff_dt"), Value);
		if (!ComIsNull(sheetObj.GetCellValue(Row, "eff_dt")) && parseInt(vPeriod) < 1) {
			return false;
		}
		return true;
    }

    /**
     * Move the focus to first among violated rows on sheet <br>
     * <br><b>Example :</b>
     * <pre>
     *    setFirstValidCell(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.07.20
     */
    function setFirstValidCell(sheetObj) {
    	var topRow=sheetObj.HeaderRows();
		var lastRow=sheetObj.LastRow();
		var lastCol=sheetObj.LastCol();
    	for(var i=topRow; i<=lastRow; i++) {
			for(var j=0; j<=lastCol; j++) {
  				if(sheetObj.GetCellBackColor(i, j) == "#ff0000") {
                    sheetObj.SelectCell(i, j, false);
                    return;
                }
			}
		}
    }
    /**
     * setting sheet's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.07.20
     */  
	function setSheetDisplay(sheetObj) {
    	var topRow=sheetObj.GetTopRow()
		var lastRow=sheetObj.LastRow();
		for(var i=topRow; i<=lastRow; i++) {
			if(sheetObjects[1].GetCellValue(1, "por_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "por_def_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "pol_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "pol_def_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "pod_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "pod_def_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "del_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "del_def_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "imdg_clss_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "scg_imdg_clss_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "sub_trd_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "sub_trd_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "slan_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "vsl_slan_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "ts_port_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "ts_port_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "dir_call_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "dir_call_flg","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "tml_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "tml_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "trns_mod_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "org_trsp_mod_cd","",0);
    			sheetObjects[0].SetCellValue(i, "dest_trsp_mod_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "usa_svc_mod_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "usa_svc_mod_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "rcv_de_term_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "prc_rcv_term_cd","",0);
    			sheetObjects[0].SetCellValue(i, "prc_de_term_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "hngr_bar_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "prc_hngr_bar_tp_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "cgo_wgt_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "min_cgo_wgt","",0);
    			sheetObjects[0].SetCellValue(i, "max_cgo_wgt","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "cmdt_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "cmdt_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "gri_cmdt_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "scg_grp_cmdt_cd","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "soc_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "soc_flg","",0);
    		}
			if(sheetObjects[1].GetCellValue(1, "io_ga_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "io_ga_cd","",0);
    		}
			if(sheetObj.GetCellValue(i, "prc_cgo_tp_cd") == "DG") {
				sheetObj.SetCellEditable(i, "scg_imdg_clss_cd",1);
			} else {
				sheetObj.SetCellValue(i, "scg_imdg_clss_cd","");
				sheetObj.SetCellEditable(i, "scg_imdg_clss_cd",0);
			}
			if(sheetObj.GetCellValue(i, "scg_amt") != 0) {

	 	        if(appType == "P") {
	 				var info = {Type:"Float", Align:"Right", Format:"NullFloat", PointCount:4, EditLen:12 };
	 				sheetObj.InitCellProperty(i, "scg_amt",info);
	 			} else {
	 				var info = {Type:"Float", Align:"Right", Format:"NullFloat", PointCount:2, EditLen:12 };
	 				sheetObj.InitCellProperty(i, "scg_amt",info);
	 			}
				
			} else {
				var info = {Type:"Int", Align:"Right", Format:"NullInteger", EditLen:12 };
 				sheetObj.InitCellProperty(i, "scg_amt",info);
			}
			if(sheetObjects[1].GetCellValue(1, "esvc_use_flg") == "N") {
    			sheetObjects[0].SetCellValue(i, "bkg_esvc_tp_cd","",0);
    		}
		}
		sheetObj.SetColBackColor("scg_rmk","#FFFFFF");
	}
  	/**
      * Array sort function <br>
      * <br><b>Example :</b>
      * <pre>
      *    sortNumber()
      * </pre>
      * @param {int} a Comparing Value - First
      * @param {int} b Comparing Value - Second
      * @return int
      * @author 
      * @version 2009.06.04
      */      
     function sortNumber(a,b){
    	 return a - b;
     }     
	/**
     * Checking duplicate rows on sheet  <br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetDisplay(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.06.04
     */ 
     function checkSheetRowDup(sheetObj) {
    	var tempSheet=sheetObjects[2];
		var srcCols="";
		var destCols="";
		srcCols += "seq|por_def_cd|pol_def_cd|pod_def_cd|del_def_cd|rat_ut_cd|prc_cgo_tp_cd|scg_imdg_clss_cd|curr_cd|pay_term_cd|cnl_tz_cd|";
		srcCols += "min_cgo_wgt|max_cgo_wgt|org_trsp_mod_cd|dest_trsp_mod_cd|prc_rcv_term_cd|prc_de_term_cd|prc_hngr_bar_tp_cd|sub_trd_cd|vsl_slan_cd|dir_call_flg|tml_cd|";
		srcCols += "cmdt_cd|io_ga_cd|ts_port_cd|soc_flg|scg_grp_cmdt_cd|usa_svc_mod_cd|eff_dt|exp_dt|bkg_esvc_tp_cd";
		destCols += tempSheet.SaveNameCol("seq")+"|"+tempSheet.SaveNameCol("por_def_cd")+"|"+tempSheet.SaveNameCol("pol_def_cd")+"|"+tempSheet.SaveNameCol("pod_def_cd")+"|"+tempSheet.SaveNameCol("del_def_cd")+"|";
		destCols += tempSheet.SaveNameCol("rat_ut_cd")+"|"+tempSheet.SaveNameCol("prc_cgo_tp_cd")+"|"+tempSheet.SaveNameCol("scg_imdg_clss_cd")+"|"+tempSheet.SaveNameCol("curr_cd")+"|"+tempSheet.SaveNameCol("pay_term_cd")+"|";
		destCols += tempSheet.SaveNameCol("cnl_tz_cd")+"|"+tempSheet.SaveNameCol("min_cgo_wgt")+"|"+tempSheet.SaveNameCol("max_cgo_wgt")+"|"+tempSheet.SaveNameCol("org_trsp_mod_cd")+"|"+tempSheet.SaveNameCol("dest_trsp_mod_cd")+"|";
		destCols += tempSheet.SaveNameCol("prc_rcv_term_cd")+"|"+tempSheet.SaveNameCol("prc_de_term_cd")+"|"+tempSheet.SaveNameCol("prc_hngr_bar_tp_cd")+"|"+tempSheet.SaveNameCol("sub_trd_cd")+"|"+tempSheet.SaveNameCol("vsl_slan_cd")+"|";
		destCols += tempSheet.SaveNameCol("dir_call_flg")+"|"+tempSheet.SaveNameCol("tml_cd")+"|"+tempSheet.SaveNameCol("cmdt_cd")+"|"+tempSheet.SaveNameCol("io_ga_cd")+"|"+tempSheet.SaveNameCol("ts_port_cd")+"|";
		destCols += tempSheet.SaveNameCol("soc_flg")+"|"+tempSheet.SaveNameCol("scg_grp_cmdt_cd")+"|"+tempSheet.SaveNameCol("usa_svc_mod_cd")+"|"+tempSheet.SaveNameCol("eff_dt")+"|"+tempSheet.SaveNameCol("exp_dt")+"|"+tempSheet.SaveNameCol("bkg_esvc_tp_cd");
		tempSheet.RemoveAll();
		sheetObj.Copy2SheetCol(tempSheet, srcCols, destCols, -1, -1, -1, 1);
		var comPareStr=tempSheet.GetRangeText(2,1,tempSheet.LastRow(),tempSheet.LastCol()- 2,"|","^");
		var arrBase=comPareStr.split("^");
		var arrDest=arrBase;
		var srcEffDt="";
		var srcExpDt="";
    	var trgtEffDt="";
    	var trgtExpDt="";
		for (var i=0; i < arrBase.length  ; i++){			
			srcEffDt=tempSheet.GetCellValue(i + 2, "eff_dt");
			srcExpDt=tempSheet.GetCellValue(i + 2, "exp_dt");
			for (var j=0; j < arrDest.length ; j++){				
				if (tempSheet.GetCellValue(i + 2, "seq")!= tempSheet.GetCellValue(j + 2, "seq")
						&& arrBase[i] == arrDest[j]){		        	
					trgtEffDt=tempSheet.GetCellValue(j + 2, "eff_dt");
					trgtExpDt=tempSheet.GetCellValue(j + 2, "exp_dt");
		        	if(ComIsNull(srcExpDt) && ComIsNull(trgtExpDt)) {
						if(srcEffDt == trgtEffDt) {
							ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
							sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
						}
		        		if (srcEffDt  <= trgtEffDt){
		        			ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
		        			sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
		        		}
		        	} else if(ComIsNull(srcExpDt)) {
		        		if(trgtEffDt <= srcEffDt && srcEffDt <= trgtExpDt) {
		        			ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
		        			sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
		        		}
		        	} else if(ComIsNull(trgtExpDt)) {
		        		if(srcEffDt <= trgtEffDt && trgtEffDt <= srcExpDt) {
		        			ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
		        			sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
		        		}
		        		if (trgtEffDt <= srcEffDt){
		        			ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
		        			sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
		        		}
		        	} else {
		        		if((srcEffDt >= trgtEffDt && srcEffDt <= trgtExpDt) ||(srcExpDt >= trgtEffDt && srcExpDt <= trgtExpDt) || (srcEffDt <= trgtEffDt && srcExpDt >= trgtExpDt)) {
		        			ComShowCodeMessage("PRI02016", sheetObj.GetCellValue(i + 2, "seq"), sheetObj.GetCellValue(j + 2, "seq"));
		        			sheetObjects[0].SetSelectRow(i + 2, 0);
							return false;
						}
		        	}
				}						
			}
		}
    	 return true;
     }     

    /**
     * setting button's attribute function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) mandatory button setting mode
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
	function toggleButtons(mode) {
		switch (mode) {
			case "CLEAR":
				ComBtnDisable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnDisable("btn_close");
				break;
			case "INIT":
				ComBtnEnable("btn_openfile");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				ComBtnEnable("btn_close");
				break;
			case "READONLY":
				ComBtnEnable("btn_openfile");
				ComBtnDisable("btn_check");
				ComBtnEnable("btn_save");
				ComBtnEnable("btn_close");
				break;
		}
	}
	/**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @return void
     * @author 
     * @version 2009.07.20
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	  		case IBSEARCH_ASYNC01: 
		  		if(!sheetObj.IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			var topRow=sheetObj.GetTopRow();
	  			var lastRow=sheetObj.LastRow();
	  			var lastCol=sheetObj.LastCol();
		  		//initializing cell background color
		  		for(var i=topRow; i<=lastRow; i++) {
		  			//sheetObj.SetRowBackColor(i,"#FFFFFF");
		  			for(var j=1; j<=lastCol; j++) {
		  				sheetObj.SetCellBackColor(i, j,"#FFFFFF");
		  			}
		  		}

		  		ComOpenWait(true);

		  	    //Validation Check(for checking data with script only)
	  			var validCnt=validateCheckSheetData(sheetObjects[0], formObj);
		  		if(validCnt > 0) {
		  			errFlg=true;
		  			ComBtnDisable("btn_save");
		  			sheetObjects[0].SetEditable(1);
		  			setFirstValidCell(sheetObjects[0]);
		  			ComOpenWait(false);
		  			return false;
		  		} else {
		  			
		  		    //Duplicate Check
		  			if(!checkSheetRowDup(sheetObjects[0])) {
		  				sheetObjects[0].SetEditable(1);
		  				ComBtnDisable("btn_save");
		  				ComBtnEnable("btn_check");
		  				ComOpenWait(false);
		  				return false;
		  			}
		  			
		  			
		  			errFlg=false;
		  			//Process All Cell make Read-Only
		  			sheetObjects[0].SetEditable(0);
		  			
		  			setTimeout(function() {ComOpenWait(true);},10);
		  			
		  			setTimeout(function() {
				  	    //Validation Check(for checking data with db data only) and deal with error logic in the sheet5_OnSearchEnd 
				  		doCheckLosicToServer(sheetObjects[0], formObj);
			  		},1000);
		  		}
		  		
		  		
		  		

			  		
			  		
		  		break;
	  		case IBSAVE:
	  			// Check save when zero Amount exists
				var isConfirm=false;
	  			var topRowSheet1=sheetObjects[0].GetTopRow();
	  			var lastRowSheet1=sheetObjects[0].LastRow();
				for(var i=topRowSheet1; i<=lastRowSheet1; i++) {
					if(sheetObjects[0].GetCellValue(i, "scg_amt") == 0) {
						if(ComShowCodeConfirm('PRI02003', sheetObjects[0].GetCellText(0, "scg_amt"))) {
							isConfirm=true;
							break;
						} else {
							sheetObjects[0].SelectCell(i, "scg_amt");
							return false;
						}
					}
				}
				
	  			if(!sheetObjects[0].IsDataModified()) {
					ComShowCodeMessage("PRI00312");
					return false;
				}
	  			if(sheetObjects[0].GetSaveString() == "") {
	  				return false;
	  			}
	  			
	  			if(!isConfirm) { //When it has already confirmed, proceed to next
					if (!ComPriConfirmSave()) { // If there wasn't confirm popup before, ask confirm to save 
						return false;
					}
				}
	  			
	  			return true;
	  			break;
    	}		
        return true;
    }
    
  //###################################################
    function validateCheckSheetData(sheetObj, formObj) {
		var validCnt=0;
		var topRow=sheetObj.GetTopRow();
		var lastRow=sheetObj.LastRow();
		var baseColor="#FFFFFF";
		var validColor="#FF0000";
		for(var i=topRow; i<=lastRow; i++) {
     		sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value);
     		sheetObj.SetCellValue(i, "chg_cd",formObj.chg_cd.value);

     		if(!validCheckLocationData(sheetObj, i, "por_tp_cd", "por_def_cd")) {
     			sheetObj.SetCellBackColor(i, "por_def_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "por_def_cd",baseColor);
     		}
     		if(!validCheckLocationData(sheetObj, i, "pol_tp_cd", "pol_def_cd")) {
     			sheetObj.SetCellBackColor(i, "pol_def_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "pol_def_cd",baseColor);
     		}
     		if(!validCheckLocationData(sheetObj, i, "pod_tp_cd", "pod_def_cd")) {
     			sheetObj.SetCellBackColor(i, "pod_def_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "pod_def_cd",baseColor);
     		}
     		if(!validCheckLocationData(sheetObj, i, "del_tp_cd", "del_def_cd")) {
     			sheetObj.SetCellBackColor(i, "del_def_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "del_def_cd",baseColor);
     		}
     		// Sub-trade
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "sub_trd_cd"), "sub_trd_cd")) {
     			sheetObj.SetCellBackColor(i, "sub_trd_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "sub_trd_cd",baseColor);
     		}
     		// Lane
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "vsl_slan_cd"), "vsl_slan_cd")) {
     			sheetObj.SetCellBackColor(i, "vsl_slan_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "vsl_slan_cd",baseColor);
     		}
     		// T/S Port
     		if(!validCheckTSPortData(sheetObj, i, sheetObj.GetCellValue(i, "ts_port_cd"))) {
     			sheetObj.SetCellBackColor(i, "ts_port_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "ts_port_cd",baseColor);
     		}
     		// Direct Call
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "dir_call_flg"), "dir_call_flg")) {
     			sheetObj.SetCellBackColor(i, "dir_call_flg",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "dir_call_flg",baseColor);
     		}
     		// Terminal
     		if(!validCheckTerminalCodeData(sheetObj, i, sheetObj.GetCellValue(i, "tml_cd"), "tml_cd")) {
     			sheetObj.SetCellBackColor(i, "tml_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "tml_cd",baseColor);
     		}
     		// Trans Mode Origin
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "org_trsp_mod_cd"), "org_trsp_mod_cd")) {
     			sheetObj.SetCellBackColor(i, "org_trsp_mod_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "org_trsp_mod_cd",baseColor);
     		}
     		// Trans Mode Dest
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "dest_trsp_mod_cd"), "dest_trsp_mod_cd")) {
     			sheetObj.SetCellBackColor(i, "dest_trsp_mod_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "dest_trsp_mod_cd",baseColor);
     		}
     		// US Service Mode
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "usa_svc_mod_cd"), "usa_svc_mod_cd")) {
     			sheetObj.SetCellBackColor(i, "usa_svc_mod_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "usa_svc_mod_cd",baseColor);
     		}
     		// R/D Term Origin
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "prc_rcv_term_cd"), "prc_rcv_term_cd")) {
     			sheetObj.SetCellBackColor(i, "prc_rcv_term_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "prc_rcv_term_cd",baseColor);
     		}
     		// R/D Term Dest
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "prc_de_term_cd"), "prc_de_term_cd")) {
     			sheetObj.SetCellBackColor(i, "prc_de_term_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "prc_de_term_cd",baseColor);
     		}
     		// Bar Type
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "prc_hngr_bar_tp_cd"), "prc_hngr_bar_tp_cd")) {
     			sheetObj.SetCellBackColor(i, "prc_hngr_bar_tp_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "prc_hngr_bar_tp_cd",baseColor);
     		}
     		// Min Weight
     		if(!validCheckMinCargoWeight(sheetObj, i, sheetObj.GetCellValue(i, "min_cgo_wgt"))) {
     			sheetObj.SetCellBackColor(i, "min_cgo_wgt",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "min_cgo_wgt",baseColor);
     		}
     		// Max Weight
     		if(!validCheckMaxCargoWeight(sheetObj, i, sheetObj.GetCellValue(i, "max_cgo_wgt"))) {
     			sheetObj.SetCellBackColor(i, "max_cgo_wgt",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "max_cgo_wgt",baseColor);
     		}
     		// Commodity
     		if(!validCheckCommodityData(sheetObj, i, sheetObj.GetCellValue(i, "cmdt_cd"))) {
     			sheetObj.SetCellBackColor(i, "cmdt_cd",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "cmdt_cd",baseColor);
     		}   			
     		// Shipper's Own Container(S.O.C)
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "soc_flg"), "soc_flg")) {
     			sheetObj.SetCellBackColor(i, "soc_flg",validColor);
     			validCnt++;
     		} else {
     			sheetObj.SetCellBackColor(i, "soc_flg",baseColor);
     		}
     		// In/Out Gauge
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "io_ga_cd"), "io_ga_cd")) {
     			sheetObj.SetCellBackColor(i, "io_ga_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "io_ga_cd",baseColor);
     		}
     		// Per(Rating Unit)
     		if(!validCheckMandatory(sheetObj, i, sheetObj.GetCellValue(i, "rat_ut_cd"),"rat_ut_cd")) {
     			sheetObj.SetCellBackColor(i, "rat_ut_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "rat_ut_cd",baseColor);
     		}
     		
     		// Cargo Type
     		if(!validCheckCargoType(sheetObj, i, sheetObj.GetCellValue(i, "prc_cgo_tp_cd"), "prc_cgo_tp_cd")) {
     			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd",baseColor);
     		}
     		// IMDG Class
     		if(!validCheckImdgClss(sheetObj, i, sheetObj.GetCellValue(i, "scg_imdg_clss_cd"))) {
     			sheetObj.SetCellBackColor(i, "scg_imdg_clss_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "scg_imdg_clss_cd",baseColor);
     		}
     		// Cur
     		if(formObj.flt_pct_tp_cd.value == "F" && !validCheckMandatory(sheetObj, i, sheetObj.GetCellValue(i, "curr_cd"),"curr_cd")) {
     			sheetObj.SetCellBackColor(i, "curr_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "curr_cd",baseColor);
     		}
     		// Amount
     		if(!validCheckSurchargeAmount(sheetObj, i, sheetObj.GetCellValue(i, "scg_amt"))) {
     			sheetObj.SetCellBackColor(i, "scg_amt",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "scg_amt",baseColor);
     		}

     		// Pay Term
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "pay_term_cd"), "pay_term_cd")) {
     			sheetObj.SetCellBackColor(i, "pay_term_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "pay_term_cd",baseColor);
     		}
     		// Effective Date
     		if(!validCheckEffectiveDate(sheetObj, i, sheetObj.GetCellValue(i, "eff_dt"))) {
     			sheetObj.SetCellBackColor(i, "eff_dt",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "eff_dt",baseColor);
     		}
     		// Expire Date
     		if(!validCheckExpireDate(sheetObj, i, sheetObj.GetCellValue(i, "exp_dt"))) {
     			sheetObj.SetCellBackColor(i, "exp_dt",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "exp_dt",baseColor);
     		}
     		// Remark(s)
     		if(!validCheckScgRmkLength(sheetObj.GetCellValue(i, "scg_rmk"))) {
     			sheetObj.SetCellBackColor(i, "scg_rmk",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "scg_rmk",baseColor);
     		}
     	    // S/I
     		if(!validCheckCommonCode(sheetObj, i, sheetObj.GetCellValue(i, "bkg_esvc_tp_cd"), "bkg_esvc_tp_cd")) {
     			sheetObj.SetCellBackColor(i, "bkg_esvc_tp_cd",validColor);
     			validCnt++;
     		}else {
     			sheetObj.SetCellBackColor(i, "bkg_esvc_tp_cd",baseColor);
     		}
		}

		return validCnt;
	}
    
    function validCheckScgRmkLength(Value) {
    	var rVal = ComChkLenByByte(Value, 1000);
		if(rVal == -1 || rVal == 0) {
			return false;
		}
		return true;
    }
    
    function validCheckLocationData(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		var locCd=sheetObj.GetCellValue(Row, cellDefCdNm);
		if(ComIsNull(locCd)) {
			return true;
		}
		if(locCd.length <= 1) {
			return false;
		} 
		return true;
	}
    
    function validCheckTSPortData(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if(Value.length > 0 && Value.length != 5) {
			return false;
		}
		return true;
	}
    
    function validCheckTerminalCodeData(sheetObj, Row, Value) {
 		if(ComIsNull(Value)) {
 			return true;
 		}
 		if(Value.length > 0 && Value.length != 7) {
			return false;
		}
 		return true;
 	}
    
	function validCheckCommodityData(sheetObj, Row, Value) {
		if(ComIsNull(Value)) {
			return true;
		}
		if(Value.length > 0 && Value.length != 6) {
			return false;
		}
		return true;
	}
    
	
	function doCheckLosicToServer(sheetObj, formObj) {
		formObj.f_cmd.value=COMMAND01;
		var sParam=FormQueryString(formObj);

        var sParamSheet1=sheetObjects[0].GetSaveString();
        if (sParamSheet1 != "") {
            sParam += "&"+ ComPriSetPrifix(sParamSheet1, "sheet1_");
        }
		
        sheetObjects[4].DoSearch("ESM_PRI_4016GS.do", sParam);
		
	}
	
	function sheet5_OnSearchEnd(sheetObj, errMsg) {
		//sheetObj : sheetObjects[4]
		var formObj = document.form;
		var orgSheet = sheetObjects[0];
		var baseColor="#FFFFFF";
		var validColor="#FF0000";
		
		var rowendcnt = sheetObj.LastRow();
		var rowstartcnt = sheetObj.HeaderRows();
		if(rowendcnt > 0){
			sheetObjects[0].SetEditable(1);
			var validCnt = 0;
			var vDupRowIdx = 0;
			var firstDupRowIdx = 0;
			for(var i = rowstartcnt; i <= rowendcnt; i++ ) {
				//sheet1 setting
				sheetObjects[0].SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value,0);
				sheetObjects[0].SetCellValue(i, "chg_cd",formObj.chg_cd.value,0);
				
                //sheet5 check and setting
				//Duplication
				var tmpDupRowIdx = sheetObj.GetCellValue(i, "dup_idx");
				if(tmpDupRowIdx != "0" && tmpDupRowIdx != undefined && tmpDupRowIdx != "") {
					if(vDupRowIdx == 0 ) {
						vDupRowIdx = i-1;
						firstDupRowIdx = i; 
					}else{
						vDupRowIdx = vDupRowIdx + "," + (i-1);
					}
				}
				
				//Location
				var v_por_def_cd_vld = sheetObj.GetCellValue(i, "por_def_cd_vld");
				var v_por_tp_cd_vld = sheetObj.GetCellValue(i, "por_tp_cd_vld");
				if(v_por_def_cd_vld != "F") {
					orgSheet.SetCellValue(i, "por_tp_cd",v_por_tp_cd_vld,0);
					orgSheet.SetCellBackColor(i, "por_def_cd", baseColor);
				} else {
					orgSheet.SetCellValue(i, "por_tp_cd","",0);
					orgSheet.SetCellBackColor(i, "por_def_cd", validColor);
					validCnt++;
				}
				
				var v_pol_def_cd_vld = sheetObj.GetCellValue(i, "pol_def_cd_vld");
				var v_pol_tp_cd_vld = sheetObj.GetCellValue(i, "pol_tp_cd_vld");
				if(v_pol_def_cd_vld != "F") {
					orgSheet.SetCellValue(i, "pol_tp_cd",v_pol_tp_cd_vld,0);
					orgSheet.SetCellBackColor(i, "pol_def_cd", baseColor);
				} else {
					orgSheet.SetCellValue(i, "pol_tp_cd","",0);
					orgSheet.SetCellBackColor(i, "pol_def_cd", validColor);
					validCnt++;
				}
				
				var v_pod_def_cd_vld = sheetObj.GetCellValue(i, "pod_def_cd_vld");
				var v_pod_tp_cd_vld = sheetObj.GetCellValue(i, "pod_tp_cd_vld");
				if(v_pod_def_cd_vld != "F") {
					orgSheet.SetCellValue(i, "pod_tp_cd",v_pod_tp_cd_vld,0);
					orgSheet.SetCellBackColor(i, "pod_def_cd", baseColor);
				} else {
					orgSheet.SetCellValue(i, "pod_tp_cd","",0);
					orgSheet.SetCellBackColor(i, "pod_def_cd", validColor);
					validCnt++;
				}
				
				var v_del_def_cd_vld = sheetObj.GetCellValue(i, "del_def_cd_vld");
				var v_del_tp_cd_vld = sheetObj.GetCellValue(i, "del_tp_cd_vld");
				if(v_del_def_cd_vld != "F") {
					orgSheet.SetCellValue(i, "del_tp_cd",v_del_tp_cd_vld,0);
					orgSheet.SetCellBackColor(i, "del_def_cd", baseColor);
				} else {
					orgSheet.SetCellValue(i, "del_tp_cd","",0);
					orgSheet.SetCellBackColor(i, "del_def_cd", validColor);
					validCnt++;
				}
				
				// T/S Port
				var v_ts_port_cd_vld = sheetObj.GetCellValue(i, "ts_port_cd_vld");
	     		if(v_ts_port_cd_vld != "F") {
	     			orgSheet.SetCellBackColor(i, "ts_port_cd", baseColor);
	     		}else {
	     			orgSheet.SetCellBackColor(i, "ts_port_cd", validColor);
	     			validCnt++;
	     		}
	     		
	     	    // Terminal
	     		var v_tml_cd_vld = sheetObj.GetCellValue(i, "tml_cd_vld");
	     		if(v_tml_cd_vld != "F") {
	     			orgSheet.SetCellBackColor(i, "tml_cd", baseColor);
	     		}else {
	     			orgSheet.SetCellBackColor(i, "tml_cd", validColor);
	     		}
	     		
	     	    // Commodity
	     		var v_cmdt_cd_vld = sheetObj.GetCellValue(i, "cmdt_cd_vld");
	     		if(v_cmdt_cd_vld != "F") {
	     			orgSheet.SetCellBackColor(i, "cmdt_cd", baseColor);
	     		}else {
	     			orgSheet.SetCellBackColor(i, "cmdt_cd", validColor);
	     			validCnt++;
	     		}				
			}						
			
			if(validCnt > 0) {				
	  			errFlg=true;
	  			ComBtnDisable("btn_save");
	  			sheetObjects[0].SetEditable(1);
	  			setFirstValidCell(sheetObjects[0]);
	  		
			} else {  			
	  			if(vDupRowIdx != "0") {
	  				ComShowCodeMessage("PRI02017", vDupRowIdx);				
					errFlg=true;
		  			ComBtnDisable("btn_save");
		  			sheetObjects[0].SetEditable(1);
		  			sheetObjects[0].SetSelectRow(firstDupRowIdx, 0);
	  			} else {
	  				errFlg=false;
		  			//Process All Cell make Read-Only
		  			sheetObjects[0].SetEditable(0);
		  			ComBtnEnable("btn_save");
	  			}
	  		}			
		}
		
		ComOpenWait(false);
	}
	//###################################################
    
    
    