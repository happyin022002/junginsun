/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0018.js
*@FileTitle  : Reefer CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
*=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class VOP_SCG_0018 : business javascript for VOP_SCG_0018 
     */
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	
	var rjtCode = "Y"; //RJT Code 최초 빈값 셋팅여부확인 
   	var spclAuthCd;
   	var oldRow = "";
	
   	//var openerObj=window.dialogArguments;
	// Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
	 			case "btn_RouteDetail":
	 				onPopupClick(srcName);
	 				break;
     			case "btns_Commodity":
     				onPopupClick(srcName);
     				break;
     			case "btns_Package":
     				onPopupClick(srcName);
     				break;
     			case "btns_DgCntrSeq":
 					onPopupClick(srcName);
     				break;
     			case "btn_ApprovalDetails":
	            	onPopupClick(srcName);
	            	break;
	            case "btn_Mail":
	            	sendReqMail(sheetObject1, formObject);
	            	break;
	            case "btn_Prev":
	            	onPopupClick(srcName);
	            	break;
	            case "btn_Next":
	            	onPopupClick(srcName);
	            	break;
	            case "btn_Close":
					if (document.form.scg_flg.value=="RF"){
						if(setParentValue())  
							ComClosePopup(); 
					}else{
						ComClosePopup(); 
					}
	            	break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
     	}
     }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * register IBCombo Object created in page as comboObjects list
     * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
         }
        // Initializing IBMultiCombo
        for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
  			comboObjects[k].SetEnable(0);
        }
        sheet1_OnLoadFinish(sheet1);
     }
	function sheet1_OnLoadFinish(sheetObj) {
    	loadPage2();
    }
    function loadPage2() {
    	var formObj=document.form;
 		formObj.spcl_cgo_auth_cd.options.length="5";
        if (formObj.type.value == "P") {
    		document.getElementById("spcl_cgo_auth_cd").disabled=true;
    		//document.getElementById("spcl_cgo_auth_rmk").disabled = true;
    		document.getElementById("apro_ref_no").disabled=true;
 			document.getElementById("spcl_cgo_auth_cd").className="input2";
 			document.getElementById("spcl_cgo_auth_rmk").className="input";
 			document.getElementById("apro_ref_no").className="input2";
        }
        //Initializing html control event
        initControl();
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC01);	//create RJT CD Combo
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC02);
        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var shtID=sheetObj.id;
    	switch(shtID) {
    		case "sheet1":     
    		    with(sheetObj){
    				var HeadTitle1="TP/SZ|BKG Q'ty|RF Q'ty";
    				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rf_cgo_qty",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
    	       
    				InitColumns(cols);
    				SetSheetHeight(102);
    				SetEditable(0);
    				SetCountPosition(0);
	            }
    			break;
    		case "sheet2":      //t2sheet1 init
    		    with(sheetObj){
    				var HeadTitle="|ibflag|Seq.|Container No.|Container No.|Vol.|Genset|Volt|Appr.|bkg_no|rc_seq|cmdt_cd|cmdt_nm|cdo_temp|" +
					"fdo_temp|clng_tp_cd|cntr_vent_tp_cd|vent_rto|cbm_per_hr_qty|humid_no|pck_qty|grs_wgt|pck_tp_cd|net_wgt|wgt_ut_cd|" +
    				"rf_dcgo_seq|ctrl_atms_flg|modi_atms_flg|humid_ctrl_flg|cntr_drn_cd|diff_rmk|sns_cgo_knd_cd|oxgn_rto|crbn_dxd_rto|modifyaproflg";

    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
    	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
    	             {Type:"Text",      Hidden:0,  Width:82,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:23,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pwr_spl_cbl_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vltg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rc_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"fdo_temp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"clng_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vent_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"vent_rto",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cbm_per_hr_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"humid_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"rf_dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ctrl_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"modi_atms_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"humid_ctrl_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_drn_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"sns_cgo_knd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"oxgn_rto",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"crbn_dxd_rto",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },    	             
    	             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"modifyaproflg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd", KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",     KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_text",    KeyField:0,   CalcLogic:"",   Format:"",        PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
    	             ];
    	       
    				InitColumns(cols);
    				SetSheetHeight(140);
    				SetEditable(0);
    				SetCountPosition(0);
	            }
    			break;
            case "sheet3":      //sheet3 init
                with(sheetObj){
            		var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|corr_no";
            		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pol_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pod_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
               
            		InitColumns(cols);
            		SetVisible(0);
            		SetEditable(1);
            		SetCountPosition(0);
                }
                break;
            case "sheet4":      //sheet4 init
                with(sheetObj){
            		var HeadTitle1="|value|name|TpszCd";
            		var headCount=ComCountHeadTitle(HeadTitle1);
            		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            		InitHeaders(headers, info);

            		var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
               
            		InitColumns(cols);
            		SetVisible(0);
            		SetEditable(1);
            		SetCountPosition(0);
                }
            	break;     	
            case "sheet5":     
    		    with(sheetObj){
    				var HeadTitle1="bkg_no|rc_seq|spcl_cgo_auth_rjct_cd|spcl_cgo_auth_rmk";
    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"rc_seq",                  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
    	       
    				InitColumns(cols);
    				SetVisible(0);
    				SetSheetHeight(102);
    				SetEditable(0);
    				SetCountPosition(0);
	            }
    			break;            	
    	}
    }
    // Sheet related process handling
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
	     	case IBSEARCH_ASYNC01: //retrieve RJT CD 
	     		formObj.f_cmd.value=SEARCH;
	 			var formParams="";
	     		formParams += "f_cmd="+ComGetObjValue(formObj.f_cmd);
	     		var sXml=sheetObj.GetSearchData("VOP_SCG_0031GS.do", formParams+"&spcl_cgo_cate_cd=RF");
//				ComXml2ComboItem(sXml, formObj.spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
	     		ComXml2ComboItem(sXml, spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
				break;
	 		case IBSEARCH_ASYNC02: //retrieve RqstInfo 
				formObj.f_cmd.value=SEARCH;
				var sXml=sheetObj.GetSearchData("VOP_SCG_0015GS.do", FormQueryString(formObj));
				var arrData=ComScgXml2Array(sXml, "rqst_usr_nm|rqst_usr_id|rqst_ofc_cd|rqst_gdt|rqst_usr_phn_no|rqst_usr_eml");
	     		if (arrData != null && arrData.length > 0) {
					document.getElementById("rqst_usr_nm").value = arrData[0][0];
					document.getElementById("rqst_usr_id").value = arrData[0][1];
					document.getElementById("rqst_ofc_cd").value = arrData[0][2];
					document.getElementById("rqst_gdt").value	 = arrData[0][3];
					document.getElementById("rqst_usr_phn_no").value = arrData[0][4];
					document.getElementById("rqst_usr_eml").value= arrData[0][5];
	     		}
				break;
	 		case IBSEARCH_ASYNC03: //retrieve Attached File
				break;
    		case IBSEARCH:      //retrieve
     			spclAuthCd = "";
    			var openerObj = window.dialogArguments;
//    			if (!openerObj) openerObj=window.opener;
    			if (!openerObj) openerObj = parent;
    			var oSheetObj;
     			if (document.getElementById("scg_flg").value == "SCG_RF" || document.getElementById("scg_flg").value == "RF") {
    				oSheetObj=openerObj.sheetObjects[4];
    				//maintain original status to separate own reefer when sending mail
    				//formObj.org_spcl_cgo_auth_cd.value= oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "org_spcl_cgo_auth_cd");
    			}else{
    				oSheetObj=openerObj.sheetObjects[3];    				
			    	//formObj.spcl_cgo_auth_rmk.disabled=true;
			    	//formObj.spcl_cgo_auth_rmk.className="input2";
    			}
//				$("#pol_cd").text(oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd"));
//				$("#pod_cd").text(oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd"));
//				document.getElementById("pol_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
//				document.getElementById("pod_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				
				document.getElementById("pol_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
				document.getElementById("pod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");				
				document.getElementById("pol_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_yd_cd").substring(5,7);
				document.getElementById("pod_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_yd_cd").substring(5,7);
				
				var formParams="";
         		formParams += "auth_flg=";
         		formParams += "&f_cmd="          +SEARCH;
         		formParams += "&rgn_shp_opr_cd=" +openerObj.comboObjects[0].GetSelectCode();
         		formParams += "&val_opr_tp_cd=";
         		formParams += "&booking_no="     +ComGetObjValue(formObj.bkg_no);
         		formParams += "&vsl_cd="         +ComGetObjValue(formObj.vsl_cd);
         		formParams += "&scg_flg=SCG_RF";
      			var sXml=sheetObjects[4].GetSaveData("VOP_SCG_0014GS.do", formParams);
      			sheetObjects[4].LoadSaveData(sXml,{Sync:1});
      			
    			if(validateForm(sheetObj,formObj,sAction))
    				formObj.f_cmd.value=SEARCH;
    				var resultXml=sheetObj.GetSearchData("ESM_BKG_0498GS.do", FormQueryString(formObj));
    				var arrXml=resultXml.split("|$$|");
    				if (arrXml.length == 4) {
						sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
						sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
						sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
						sheetObjects[3].LoadSearchData(arrXml[3],{Sync:1} );
    				}
    				document.getElementById("bl_no").value=sheetObjects[2].GetCellValue(1, "bl_no");
					document.getElementById("package_sum").value=sheetObjects[2].GetCellText(1, "pck_qty");
					document.getElementById("pck_type_cd").value=sheetObjects[2].GetCellValue(1, "pck_tp_cd");
					document.getElementById("weight_sum").value=sheetObjects[2].GetCellText(1, "grs_wgt");
					document.getElementById("wgt_ut").value=sheetObjects[2].GetCellValue(1, "wgt_ut_cd");
					
					if(sheetObjects[1].RowCount() > 0) htmlSheetSync(sheetObjects[1].GetSelectRow());
					break;
    	}
    }
    //business javascript OnKeyPress event Catch
    function initControl() {
    	axon_event.addListener('change', 	'auth_OnChange', 'spcl_cgo_auth_cd');
    	axon_event.addListener('change', 	'spcl_cgo_auth_rmk_OnChange', 	'spcl_cgo_auth_rmk');
    	axon_event.addListener('change', 	'apro_ref_no_OnChange', 		'apro_ref_no');
    }
    /**
     * Initializing Combo
     * Setting Combo items.
     */
    function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "spcl_cgo_auth_rjct_cd":
	            with(comboObj) {
					SetColAlign(0, "center");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "500");
    	  			SetTitle("Code|Description");
	            	SetDropHeight(190);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            	SetUseAutoComplete(1);
 	            	SetMaxLength(3);
	            }
	            break;	        
	    }
	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
     function setAuthFontColor(sheetObj, row)
     {
    	 var formObj=document.form;
    	 with(sheetObj)
    	 {
    		 var auth=GetCellText(row, "spcl_cgo_apro_cd");
    		 SetCellFont("FontBold", row, "spcl_cgo_apro_cd",1);
    		 switch(auth)
    		 {
    		 	case "R":
    		 		SetCellFontColor(row, "spcl_cgo_apro_cd","#FF862B");
					break;
				case "Y":
					SetCellFontColor(row, "spcl_cgo_apro_cd","#4D964B");
					break;
				case "N":
					SetCellFontColor(row, "spcl_cgo_apro_cd","#FF0000");
					break;
				case "P":
					SetCellFontColor(row, "spcl_cgo_apro_cd","#2663E0");
					break;
			}
    		 
    	 }
     }    

     function setAuthStat(sheetObj, row)
     {
    	 var formObj=document.form;
    	 with(sheetObj)
    	 {
    		 var auth=GetCellText(row, "spcl_cgo_apro_cd");
    		 SetCellFont("FontBold", row, "spcl_cgo_apro_cd",1);
    		 switch(auth)
    		 {
    		 	case "R":
    		 		formObj.spcl_cgo_auth_cd.options.length="5";
			    	formObj.spcl_cgo_auth_cd.options[4].text=GetCellValue(GetSelectRow(), "spcl_cgo_apro_text");
			    	formObj.spcl_cgo_auth_cd.options[4].value=GetCellValue(GetSelectRow(), "spcl_cgo_apro_cd");
			    	spclAuthCd = GetCellText(GetSelectRow(), "spcl_cgo_apro_cd");
			 		formObj.spcl_cgo_auth_cd.options[4].style.color="orange";
			    	formObj.spcl_cgo_auth_cd.options[4].selected=true;
			    	comboObjects[0].SetEnable(0);
			    	comboObjects[0].SetSelectCode("",false);
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.value="";
			    	formObj.apro_ref_no.value="";
					break;
				case "Y":
			 		formObj.spcl_cgo_auth_cd.options.length="4";
			    	formObj.spcl_cgo_auth_cd.options[0].selected=true;
			    	comboObjects[0].SetEnable(0);
			    	comboObjects[0].SetSelectCode("",false);
			    	if (GetCellText(GetSelectRow(), "apro_ref_no") != "") {
				    	//formObj.apro_ref_no.disabled=false;
				    	//formObj.apro_ref_no.className="input";
				    	formObj.apro_ref_no.value=GetCellText(GetSelectRow(), "apro_ref_no");
			    	}
			    	formObj.spcl_cgo_auth_rmk.disabled=false;
			    	formObj.spcl_cgo_auth_rmk.value=GetCellText(GetSelectRow(), "spcl_cgo_auth_rmk");
			    	
			    	
					break;
				case "N":
			 		formObj.spcl_cgo_auth_cd.options.length="4";
			    	formObj.spcl_cgo_auth_cd.options[2].selected=true;
			    	if (formObj.scg_flg.value=="RF") {
			    		if(formObj.row.value != "-1"){
			    			comboObjects[0].SetEnable(1);	
			    		}
				    	if (GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className="input1";			    		
				    	}
			    	}
			    	//comboObjects[0].SetEnable(1);
			    	comboObjects[0].SetSelectCode(GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd"),false);
			    	formObj.spcl_cgo_auth_rmk.value=GetCellText(GetSelectRow(), "spcl_cgo_auth_rmk");
			    	formObj.apro_ref_no.value="";
			    	
					break;
				case "P":
			 		formObj.spcl_cgo_auth_cd.options.length="4";
			    	formObj.spcl_cgo_auth_cd.options[3].selected=true;
			    	if (formObj.scg_flg.value=="RF") {
				    	comboObjects[0].SetEnable(0);
				    	//comboObjects[0].SetBackColor("#FFFFFF");
				    	if (GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className="input1";			    		
				    	}
			    	}
			    	comboObjects[0].SetSelectCode(GetCellValue(GetSelectRow(), "spcl_cgo_auth_rjct_cd"));
			    	formObj.spcl_cgo_auth_rmk.disabled=false;
			    	formObj.spcl_cgo_auth_rmk.value=GetCellText(GetSelectRow(), "spcl_cgo_auth_rmk");
			    	formObj.apro_ref_no.value="";
			    	
					break;
			}
    		 
    	 }
    	 if (formObj.scg_flg.value=="SCG_RF") {
		    	formObj.spcl_cgo_auth_rmk.disabled=true;
		    	formObj.spcl_cgo_auth_rmk.className="input2";
		 }
     }     
     function htmlSheetSync(Row){
    	 //Row=sheetObjects[1].GetSelectRow();
    	 document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
    	 document.getElementById("seq").value=sheetObjects[1].GetCellValue(Row,"Seq");
    	 document.getElementById("cmdt_cd").value=sheetObjects[1].GetCellValue(Row,"cmdt_cd");
    	 document.getElementById("cmdt_nm").value=sheetObjects[1].GetCellValue(Row,"cmdt_desc");
    	 document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row,"cntr_tpsz_cd");
    	 document.getElementById("cdo_temp").value=sheetObjects[1].GetCellValue(Row,"cdo_temp");
    	 document.getElementById("fdo_temp").value=sheetObjects[1].GetCellValue(Row,"fdo_temp");
    	 document.getElementById("clng_tp_cd").value=sheetObjects[1].GetCellValue(Row,"clng_tp_cd");
    	 document.getElementById("cntr_vent_tp_cd").value=sheetObjects[1].GetCellValue(Row,"cntr_vent_tp_cd");
    	 //2016-02-16 spcl_cgo_apro_cd
    	 //document.getElementById("spcl_cgo_auth_cd").value=sheetObjects[1].GetCellValue(Row,"spcl_cgo_apro_cd");
    
    	 
    	 if(sheetObjects[1].GetCellValue(Row,"cntr_vent_tp_cd") == "P"){
    		 document.getElementById("vent_rto").value=sheetObjects[1].GetCellValue(Row,"vent_rto");
    	 }else{		   
    		 document.getElementById("vent_rto").value=sheetObjects[1].GetCellValue(Row,"cbm_per_hr_qty");
    	 }
//    	 if(sheetObjects[1].CellValue(Row,"cntr_vent_tp_cd") == "P"){
//    		 document.getElementById("vent_rto").value = sheetObjects[1].CellValue(Row,"vent_rto");
//    	 }else{
//    		 document.getElementById("vent_rto").value = sheetObjects[1].CellValue(Row,"cntr_vent_rto");
//    	 }
    	 if(sheetObjects[1].GetCellValue(Row,"ctrl_atms_flg") == "Y"){
    		 document.getElementById("ctrl_atms_flg").checked=true;
    	 }else{
    		 document.getElementById("ctrl_atms_flg").checked=false;
    	 }
    	 if(sheetObjects[1].GetCellValue(Row,"modi_atms_flg") == "Y"){
    		 document.getElementById("modi_atms_flg").checked=true;
    	 }else{
    		 document.getElementById("modi_atms_flg").checked=false;
    	 }
    	 if(sheetObjects[1].GetCellValue(Row,"humid_ctrl_flg") == "Y"){
    		 document.getElementById("humid_ctrl_flg").checked=true;
    	 }else{
    		 document.getElementById("humid_ctrl_flg").checked=false;
    	 }
    	 document.getElementById("humid_no").value=sheetObjects[1].GetCellValue(Row,"humid_no");
    	 document.getElementById("pck_qty").value=sheetObjects[1].GetCellValue(Row,"pck_qty");
    	 document.getElementById("pck_tp_cd").value=sheetObjects[1].GetCellValue(Row,"pck_tp_cd");
    	 document.getElementById("grs_wgt").value=sheetObjects[1].GetCellText(Row,"grs_wgt");
    	 document.getElementById("wgt_ut_cd1").value=sheetObjects[1].GetCellValue(Row,"wgt_ut_cd");
    	 document.getElementById("wgt_ut_cd2").value=sheetObjects[1].GetCellValue(Row,"wgt_ut_cd");
    	 document.getElementById("net_wgt").value=sheetObjects[1].GetCellText(Row,"net_wgt");
    	 document.getElementById("rf_dcgo_seq").value=sheetObjects[1].GetCellValue(Row,"rf_dcgo_seq");
    	 document.getElementById("cntr_drn_cd").value=sheetObjects[1].GetCellValue(Row,"cntr_drn_cd");
    	 document.getElementById("diff_rmk").value=sheetObjects[1].GetCellValue(Row,"diff_rmk");
    	 document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
    	 document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
    	 document.getElementById("sns_cgo_knd_cd").value=sheetObjects[1].GetCellValue(Row,"sns_cgo_knd_cd");
    	 document.getElementById("oxgn_rto").value=sheetObjects[1].GetCellValue(Row,"oxgn_rto");
    	 document.getElementById("crbn_dxd_rto").value=sheetObjects[1].GetCellValue(Row,"crbn_dxd_rto");
     }  
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
    	 var formObj=document.form;
    	 
		 if (formObj.scg_flg.value=="RF") {
			 if (!setParentValue()) {
				 sheetObj.SelectCell(oldRow,"rc_seq", 0, "", 0);
				 return false;
			 }
		 }
		 
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 
		 if (document.form.scg_flg.value=="RF"){
			 oSheetObj=opener.t6sheet1;
		 } else{
			 oSheetObj=opener.t5sheet1;
		 }
		 
		 var bkg_no     = "";
    	 var vsl_cd     = "";
    	 var skd_voy_no = "";
    	 var skd_dir_cd = "";
    	 var rc_seq = "";
    	 var preFix     = "";
    	 var chkFind    = false;
		 
    	 bkg_no      = sheetObj.GetCellValue(Row, "bkg_no");
	 	 vsl_cd      = document.getElementById("vvd_cd").value.substring(0,4);
	 	 skd_voy_no  = document.getElementById("vvd_cd").value.substring(4,8);
	 	 skd_dir_cd  = document.getElementById("vvd_cd").value.substring(8,9);
	 	 rc_seq = sheetObj.GetCellValue(Row, "rc_seq");
		 chkFind = false;
		 
		 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
			 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + rc_seq;
			 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
			            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
			            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
			            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") +
			            oSheetObj.GetCellValue(i, preFix+"rc_seq");
			 if(findStr == oFindStr){
				 oSheetObj.SelectCell( i , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
    			 formObj.rc_seq.value=oSheetObj.GetCellValue( i , "rc_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(i);
				 chkFind = true;
				 break;
			 }
		 }
		 if(chkFind == false){
			 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
				 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + rc_seq;
				 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
				            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
				            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
				            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") + 
				 			oSheetObj.GetCellValue(i, preFix+"rc_seq"); 
				 if(findStr == oFindStr){
					 oSheetObj.SelectCell( i , oSheetObj.GetSelectCol());
	    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
	    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
	    			 formObj.rc_seq.value=oSheetObj.GetCellValue( i , "rc_seq");
	    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_apro_rqst_seq");
	    			 formObj.row.value=parseInt(i);
	    			 chkFind = true;
					 break;
				 }
			 }
		 }

		 if(chkFind == false){
				formObj.row.value="-1";
			    document.getElementById("spcl_cgo_auth_cd").disabled=true;
			 	document.getElementById("spcl_cgo_auth_cd").className="input2";
			 	comboObjects[0].SetEnable(0);
			 	document.getElementById("spcl_cgo_auth_rmk").disabled=true;
			 	document.getElementById("spcl_cgo_auth_rmk").className="input2";
		 }else{
			 if (formObj.scg_flg.value=="RF") {
			    	document.getElementById("spcl_cgo_auth_cd").disabled=false;
			    	document.getElementById("spcl_cgo_auth_cd").className="input1";
			    	comboObjects[0].SetEnable(1);
			    	document.getElementById("spcl_cgo_auth_rmk").disabled=false;
			    	document.getElementById("spcl_cgo_auth_rmk").className="input";				 
			 }
		 }
		 setAuthStat(sheetObj, Row); 
    	 
    	 htmlSheetSync(Row);
     }     
     /**
      * Acticate conter_no value selected from parent window.
      */
     function sheet2_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 //sheetObjects[1].ColumnSort("rc_seq","ASC");
    	 
    	 var formObj=document.form;
    	 
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 
		 if (document.form.scg_flg.value=="RF"){
			 oSheetObj=opener.t6sheet1;
		 } else{
			 oSheetObj=opener.t5sheet1;
		 }
		 
		 var bkg_no     = "";
    	 var vsl_cd     = "";
    	 var skd_voy_no = "";
    	 var skd_dir_cd = "";
    	 var rc_seq = "";
    	 var preFix     = "";
    	 var chkFind    = false;
    	 var hideRow = "";
    	 
    	 for (var iRow=sheetObj.HeaderRows();iRow<=sheetObj.LastRow();iRow++){
    		 
    		 if(sheetObj.GetCellValue(iRow, "spcl_cgo_apro_cd") == 'C'){
    			 hideRow = hideRow + "|" + iRow;
    		 }
    		 
		 	 bkg_no      = sheetObj.GetCellValue(iRow, "bkg_no");
		 	 vsl_cd      = document.getElementById("vvd_cd").value.substring(0,4);
		 	 skd_voy_no  = document.getElementById("vvd_cd").value.substring(4,8);
		 	 skd_dir_cd  = document.getElementById("vvd_cd").value.substring(8,9);
		 	 rc_seq      = sheetObj.GetCellValue(iRow, "rc_seq");
			 chkFind = false;
			 
			 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
				 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + rc_seq;
				 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
				            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
				            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
				            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") +
				            oSheetObj.GetCellValue(i, preFix+"rc_seq");
				 if(findStr == oFindStr){
					 var authCd = oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd");
		        	 if(authCd != "") {
		        		if(authCd.substring(0, 1) == 'S') {
		        			authCd = authCd.substring(0, 2); //SR
		        		} else {
		        			authCd = authCd.substring(0, 1);
		        		}
		        	 }
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      authCd, 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd"), 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
					 sheetObj.SetCellValue(iRow, "apro_ref_no",           oSheetObj.GetCellValue(i, preFix+"apro_ref_no"), 0);
		    		 if (sheetObj.GetCellText(iRow, "rc_seq") == document.getElementById("rc_seq").value) {
		    			 sheetObj.SelectCell(iRow, "rc_seq");
		    			 setAuthStat(sheetObj, iRow);
		    		 }
		    		 
					 chkFind = true;
					 break;
				 }
			 }
			 if(chkFind == false){
				 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
					 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + rc_seq;
					 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
					            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
					            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
					            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") + 
					 			oSheetObj.GetCellValue(i, preFix+"rc_seq"); 
					 if(findStr == oFindStr){
						 var authCd = oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd");
			        	 if(authCd != "") {
			        		if(authCd.substring(0, 1) == 'S') {
			        			authCd = authCd.substring(0, 2); //SR
			        		} else {
			        			authCd = authCd.substring(0, 1);
			        		}
			        	 }
						 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      authCd, 0);
						 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd"), 0);
						 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
						 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
						 sheetObj.SetCellValue(iRow, "apro_ref_no",           oSheetObj.GetCellValue(i, preFix+"apro_ref_no"), 0);
						 
			    		 if (sheetObj.GetCellText(iRow, "rc_seq") == document.getElementById("rc_seq").value) {
			    			 sheetObj.SelectCell(iRow, "rc_seq");
			    			 setAuthStat(sheetObj, iRow);
			    		 }
			    		 
			    		 chkFind = true;
						 break;
					 }
				 }
			 }
			 
			 if(chkFind == false){
				 for(var i=sheetObjects[4].HeaderRows(); i<=sheetObjects[4].LastRow(); i++){
    				 if(sheetObj.GetCellValue(iRow, preFix+"rc_seq") == sheetObjects[4].GetCellValue(i, preFix+"rc_seq")){
    		    		 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[4].GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
    					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     sheetObjects[4].GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
    					 break;
    				 }
    			 }	
			 }
			 
    		 setAuthFontColor(sheetObj, iRow);
    	 }
    	 
    	 if(hideRow != ""){
    		 //sheetObj.SetRowHidden(hideRow, 1);
    		 sheetObj.RowDelete(hideRow, 0);
    		 
    		 sheetObj.ReNumberSeq();
    	 }
     }
     
     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol,isDelete){
    	 oldRow = OldRow;
     }
     
     function auth_OnChange() {
    	var opener = window.dialogArguments;
  		if (!opener) opener=window.opener;
  		if (!opener) opener = parent;
   		var obj=ComGetEvent();
   		var formObj=document.form;

   		if(spclAuthCd!=""){
   			formObj.spcl_cgo_auth_cd.options.length=5;
   		}else{
   			formObj.spcl_cgo_auth_cd.options.length=4;
   		}
   		
   		if (obj.value == "N") {
   			
   			if(rjtCode == "N"){	//최초 빈값을 셋팅한다 
   				comboObjects[0].DeleteItem(0);
   				rjtCode = "Y";
   			}
   			
     		comboObjects[0].SetSelectIndex(-1, true);
     		comboObjects[0].SetEnable(1);
  	    	comboObjects[0].SetBackColor("#CCFFFD");
  	    	formObj.spcl_cgo_auth_rmk.disabled=false;
     		formObj.spcl_cgo_auth_rmk.value="";
     		formObj.apro_ref_no.value="";
      		document.getElementById("apro_ref_no").disabled=true;
   			document.getElementById("apro_ref_no").className="input2";
   		}else if (obj.value == "P") {
   			
   			if(rjtCode == "N"){	//최초 빈값을 셋팅한다 
   				comboObjects[0].DeleteItem(0);
   				rjtCode = "Y";
   			}
   			
     		comboObjects[0].SetSelectIndex(-1, true);
   			comboObjects[0].SetEnable(0);
   			comboObjects[0].SetBackColor("#FFFFFF");
   			formObj.spcl_cgo_auth_rmk.disabled=false;
   			formObj.spcl_cgo_auth_rmk.value="";
   			formObj.apro_ref_no.value="";
   			document.getElementById("apro_ref_no").disabled=true;
   			document.getElementById("apro_ref_no").className="input2";
   		}else if (obj.value == "A") {
   			
   			if(rjtCode == "Y"){	//최초 빈값을 셋팅한다 
   				comboObjects[0].InsertItem(0, "", "");
   				rjtCode = "N";
   			}
   			
     		comboObjects[0].SetSelectIndex(-1, true);
     		comboObjects[0].SetEnable(0);
     		formObj.spcl_cgo_auth_rmk.disabled=false;
     		formObj.spcl_cgo_auth_rmk.value="";
     		if (formObj.scg_flg.value=="RF" && opener.t6sheet1.GetCellText(opener.sheetObjects[2].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode()) {
  	    		document.getElementById("apro_ref_no").disabled=true;
  	    		document.getElementById("apro_ref_no").className="input2";
            }else if (formObj.scg_flg.value=="45") {
  	    		document.getElementById("apro_ref_no").disabled=true;
  	    		document.getElementById("apro_ref_no").className="input2";
            }
   		}else{
   			
   			if(rjtCode == "Y"){	//최초 빈값을 셋팅한다 
   				comboObjects[0].InsertItem(0, "", "");
   				rjtCode = "N";
   			}
   			
     		comboObjects[0].SetSelectIndex(-1, true);
     		comboObjects[0].SetEnable(0);
     		if (obj.value == "Y" || obj.value == "A") {
   				formObj.spcl_cgo_auth_rmk.disabled=false;
   				formObj.spcl_cgo_auth_rmk.className = "input";
   			}else{
   				formObj.spcl_cgo_auth_rmk.disabled=true;	
   			}
     		formObj.spcl_cgo_auth_rmk.value="";
     		if (formObj.scg_flg.value=="RF" && opener.t6sheet1.GetCellText(opener.sheetObjects[2].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode()) {
  	    		document.getElementById("apro_ref_no").disabled=true;
  	    		document.getElementById("apro_ref_no").className="input2";
            }else if (formObj.scg_flg.value=="45") {
  	    		document.getElementById("apro_ref_no").disabled=true;
  	    		document.getElementById("apro_ref_no").className="input2";
            }
   		}
   		
   		if(obj.value == "A"){
              for (var iRow=1;iRow<=sheetObjects[1].LastRow();iRow++){
            	  if(sheetObjects[1].GetCellValue(iRow, "spcl_cgo_apro_cd") != "Y" ){
            		  	sheetObjects[1].SetCellValue(iRow, "spcl_cgo_apro_cd"	  , "Y", 0);
             	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", "", 0);
             	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rmk"	  , "", 0);
             	 		sheetObjects[1].SetCellValue(iRow, "apro_ref_no"	      , sheetObjects[1].GetCellValue(iRow, "apro_ref_no"), 0);
             	 		
             	 		setAuthFontColor(sheetObjects[1], iRow);	  
            	  }
              }
   		}else{
   	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd"		, $("#spcl_cgo_auth_cd").val(), 0);
   	 	    sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_text"	, obj.options[obj.selectedIndex].text, 0);
   	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
   	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
   	 		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_ref_no"	        , $("#apro_ref_no").val(), 0);

   	 		setAuthFontColor(sheetObjects[1], sheetObjects[1].GetSelectRow());
   		}
      }
    function spcl_cgo_auth_rjct_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
   		var formObj=document.form;
  		if (spcl_cgo_auth_rjct_cd.GetSelectCode() == "AAA") {
   			document.getElementById("spcl_cgo_auth_rmk").className="input1";
  			formObj.spcl_cgo_auth_rmk.value='';
  		}else{
   			document.getElementById("spcl_cgo_auth_rmk").className="input";
  			formObj.spcl_cgo_auth_rmk.value=comboObj.GetText(spcl_cgo_auth_rjct_cd.GetSelectCode(), 1);
  		}
  		
  		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd"		, $("#spcl_cgo_auth_cd").val(), 0);
  		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
  		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
    }

    function spcl_cgo_auth_rmk_OnChange() {
		sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
     }
     /**
      * Clicking Popup in IBSheet Object
      */
     function onPopupClick(srcName){
    	 var formObj=document.form;
		 var row=formObj.row.value;
		 var openerObj = window.dialogArguments;
//		 if (!openerObj) openerObj=window.opener;
		 if (!openerObj) openerObj = parent;
		 if (document.getElementById("scg_flg").value == "RF" || document.getElementById("scg_flg").value == "SCG_RF" ) {
			 oSheetObj=openerObj.sheetObjects[4];
		 }else{
			 oSheetObj=openerObj.sheetObjects[3];
		 }
    	 if (srcName == "btns_Commodity") {
    		 ComOpenPopup("ESM_BKG_0653.do?cmdt_cd="+formObj.cmdt_cd.value, 823, 540, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btns_Package") {
    		 ComOpenPopup("ESM_BKG_0696POP.do?searcheKeyOpener="+formObj.pck_tp_cd.value, 700, 470, "","0,0,1,1,1", true);
    	 }else if (srcName == "btns_DgCntrSeq") {
    		 ComOpenWindowCenter("ESM_BKG_0754.do?bkgNo="+formObj.bkg_no.value+"&cntrNo="+formObj.temp_cntr_no.value+"&cntrTpszCd="+formObj.cntr_tpsz_cd.value, "ESM_BKG_0754", 805, 500, true);
    	 }else if (srcName == "btn_ApprovalDetails") {
    		 ComOpenPopup("VOP_SCG_1018.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value, 1005, 520, "", '0,0', true);
    	 }else if (srcName == "btn_Prev") {
    		 if (formObj.scg_flg.value=="RF") {
    			 if (!setParentValue()) return false;
    		 }
    		 if(row == "-1"){
    			 row = oSheetObj.GetSelectRow();
    		 }
    		 if (row == 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 oSheetObj.SelectCell( parseInt(row)-1 , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)-1 , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)-1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)-1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)-1, "skd_dir_cd");
    			 formObj.rc_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "rc_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)-1;
    			 loadPage2();
    		 }
    	 }else if (srcName == "btn_Next") {
    		 if (formObj.scg_flg.value=="RF") {
    			 if (!setParentValue()) return false;
    		 }
    		 if(row == "-1"){
    			 row = oSheetObj.GetSelectRow();
    		 }
    		 if (row == oSheetObj.LastRow()) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 oSheetObj.SelectCell( parseInt(row)+1 , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)+1 , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)+1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)+1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)+1, "skd_dir_cd");
    			 formObj.rc_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "rc_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)+1;
    			 loadPage2();
    		 }
    	 }
     }
     /**
      * Clicking Popup in IBSheet Object
      */
     function setParentValue(){
    	 var formObj=document.form;
		 var row=formObj.row.value;
		 var openerObj = window.dialogArguments;
//		 if (!openerObj) openerObj=window.opener;
		 if (!openerObj) openerObj = parent;
		 var oSheetObj;
		 if (document.getElementById("scg_flg").value == "RF" || document.getElementById("scg_flg").value == "SCG_RF") {
			 oSheetObj=openerObj.sheetObjects[4];
		 }else{
			 oSheetObj=openerObj.sheetObjects[3];    				
		 }
		 if (formObj.spcl_cgo_auth_cd.value == "A") {
			 var bkgNo=formObj.bkg_no.value;
			 var befVVD=formObj.vvd_cd.value;
    		 for (var i=2; i <= oSheetObj.LastRow(); i ++)
    		 {
    			 if (bkgNo == oSheetObj.GetCellText(i, "bkg_no") && befVVD == oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd")) {
    				 oSheetObj.SetCellValue( i , "spcl_cgo_auth_cd","Y");
    				 oSheetObj.SetCellValue( i , "apro_ref_no",formObj.apro_ref_no.value);
    			 }
    		 }
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rmk",formObj.spcl_cgo_auth_rmk.value);
		 }else if (formObj.spcl_cgo_auth_cd.value == "Y") {
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_cd",formObj.spcl_cgo_auth_cd.value);
			 oSheetObj.SetCellValue( parseInt(row) , "apro_ref_no",formObj.apro_ref_no.value);
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rmk",formObj.spcl_cgo_auth_rmk.value);
		 }else if (formObj.spcl_cgo_auth_cd.value == "P") {
			 var bkgNo=formObj.bkg_no.value;
			 var befVVD=formObj.vvd_cd.value;
			 if (formObj.mailYn.value == "Y") {
	    		 for (var i=2; i <= oSheetObj.LastRow(); i ++)
	    		 {
	    			 if (befVVD == oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd")) {
	    				 oSheetObj.SetCellValue( i , "spcl_cgo_auth_cd","P");
	    				 oSheetObj.SetCellValue( i , "apro_ref_no",formObj.apro_ref_no.value);
	    			 }
	    		 }				 
			 }else{
				 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_cd",formObj.spcl_cgo_auth_cd.value);
				 oSheetObj.SetCellValue( parseInt(row) , "apro_ref_no",formObj.apro_ref_no.value);
			 }
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd",comboObjects[0].GetSelectCode());
			 if (comboObjects[0].GetSelectCode()== 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
    			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    			 formObj.spcl_cgo_auth_rmk.focus();
    			 return false;
			 }else{
				 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rmk",formObj.spcl_cgo_auth_rmk.value);
			 }
		 }else if (formObj.spcl_cgo_auth_cd.value != "" && (formObj.spcl_cgo_auth_cd.value.substr(0,1) == 'N' || formObj.spcl_cgo_auth_cd.value.substr(0,1) == 'P')){
			 if (comboObjects[0].GetSelectCode()== '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_cd",formObj.spcl_cgo_auth_cd.value);
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd",comboObjects[0].GetSelectCode());
			 if (comboObjects[0].GetSelectCode()== 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
    			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    			 formObj.spcl_cgo_auth_rmk.focus();
    			 return false;
			 }else{
				 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rmk",formObj.spcl_cgo_auth_rmk.value);
			 }
		 }
		 return true;
     }
     /**
      * Sending request mail
      */
     function sendReqMail(sheetObj, formObj) {
		 var oSheetObj;
		 var openerObj = window.dialogArguments;
		 if (!openerObj) openerObj = parent;
		 if (!openerObj) openerObj = parent;
		 if (document.getElementById("scg_flg").value == "RF" || document.getElementById("scg_flg").value == "SCG_RF") {
			 oSheetObj=openerObj.sheetObjects[4];
		 }else{
			 oSheetObj=openerObj.sheetObjects[3];    				
		 }
		 var crr_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "crr_cd");
		 var bkg_ref_no="";
		 var spcl_cgo_rqst_seq="";
    	 var bkg_no=formObj.bkg_no.value; ;
    	 var spcl_cgo_apro_rqst_seq=formObj.spcl_cgo_apro_rqst_seq.value;
		 var vsl_pre_pst_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_pre_pst_cd");
		 var vsl_seq=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_seq");
    	 var rgn_shp_opr_cd=openerObj.rgn_shp_opr_cd.GetSelectCode();
    	 var scg_flg="RF";
    	 var strType=ComGetObjValue(formObj.type);
    	 var orgSpclCgoAuthCd=ComGetObjValue(formObj.org_spcl_cgo_auth_cd);
    	 var send_type="O0";
    	 if(strType == 'P' || orgSpclCgoAuthCd == 'P') send_type="O1";
    	 var user_id=ComGetObjValue(formObj.auth_usr_id);
    	 mailObj.crr_cd=crr_cd;
    	 mailObj.bkg_ref_no=bkg_ref_no;
    	 mailObj.spcl_cgo_rqst_seq=spcl_cgo_rqst_seq;
    	 mailObj.bkg_no=bkg_no;
    	 mailObj.spcl_cgo_apro_rqst_seq=spcl_cgo_apro_rqst_seq;
    	 mailObj.vsl_pre_pst_cd=vsl_pre_pst_cd;
    	 mailObj.vsl_seq=vsl_seq;
    	 mailObj.rgn_shp_opr_cd=rgn_shp_opr_cd;
    	 mailObj.scg_flg=scg_flg;
    	 mailObj.send_type=send_type;
    	 mailObj.user_id=user_id;
    	 ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0014GS.do", "authPending()");
     }
     function authPending() {
    	 var formObj=document.form;
    	 //if (formObj.spcl_cgo_auth_cd.options.length == "5") {
        	 formObj.spcl_cgo_auth_cd.options[3].selected=true;
        	 comboObjects[0].SetEnable(1);
        	 comboObjects[0].SetBackColor("#FFFFFF");
        	 //formObj.spcl_cgo_auth_rmk.disabled = false;
        	 //formObj.spcl_cgo_auth_rmk.className = "input";
        	 formObj.mailYn.value="Y";
    	 //}
     }
     
     function getValue(obj) {
    	 if (typeof(obj) == "string")
    		 return obj;
    	 if (Object.prototype.toString.call(obj) === '[object Array]') {
    		 return obj.join("").trimAll().replace(/,/gi, "");
    	 } else 
    		 return "";
     }
     
     function callbackNotFound(rArray)
     {
    	 var formObj = document.form;
    	 var pck_qty_var = rArray.cd;
    	 var pck_tp_cd_var = rArray.nm;
    	 formObj.pck_qty.value = pck_qty_var;
    	 formObj.pck_tp_cd.value = pck_tp_cd_var;
    	 
     }