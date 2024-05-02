/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0016.js
*@FileTitle  : Awkward CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
    // common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var oSheetObj="";
	
	var rjtCode = "Y"; //RJT Code 최초 빈값 셋팅여부확인 
   	var spclAuthCd;
   	var oldRow = "";
   	
   	// Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject =sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var sheetObject2=sheetObjects[2];
    	var sheetObject3=sheetObjects[3];
    	var sheetObject4=sheetObjects[4];
    	/*******************************************************/
    	var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
     			case "btn_PolCd":
     				onPopupClick(srcName);
     				break;
     			case "btn_PodCd":
     				onPopupClick(srcName);
     				break;
     			case "btn_RouteDetail":
     				onPopupClick(srcName);
     				break;
     			case "btns_Package":
     				onPopupClick(srcName);
     				break;
     			case "btns_Commodity":
     				onPopupClick(srcName);
     				break;
     			case "btns_DgCntrSeq":
 					onPopupClick(srcName);
     				break;
                case "btn_Criteria":
 					onPopupClick(srcName);
                    break;
                case "btn_Details":
 					onPopupClick(srcName);
                    break;
                case "btn_AttachedFile":
 					onPopupClick(srcName);
                	break;
                case "btn_ApprovalDetails":
                	onPopupClick(srcName);
                	break;
    			case "btn_attach":
    				if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
    					ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=A&disableYn=Y", 580, 520, "", "1,0", true);
    				}
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
					if (document.form.scg_flg.value=="AWK" || document.form.scg_flg.value=="45"){
						if(setParentValue())  ComClosePopup(); 
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
 		var formObj=document.form;
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet (sheetObjects[i] );
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
        // Initializing IBMultiCombo
        for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k], k + 1);
  			comboObjects[k].SetEnable(0);
        }
    //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {
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
        var sheetID=sheetObj.id ; 
        switch(sheetID) {
        	case "sheet1":
    			with (sheetObj) {
                var HeadTitle1="TP/SZ|BKG Q'ty|AK Q'ty";
                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"awk_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
                InitColumns(cols);
	            SetEditable(0);
	            SetCountPosition(0);
	            SetSheetHeight(120);                
    			}
    			break;
        	case "sheet2":
    			with (sheetObj) {
                var HeadTitle="|Seq| |Container No.|Container No.|Vol.|Appr.|awk_cgo_seq|bkg_no|rcv_term_cd|de_term_cd|";
                HeadTitle += "pck_qty|pck_tp_cd|grs_wgt|wgt_ut_cd|net_wgt|cmdt_cd|cmdt_nm|awk_dcgo_seq|ttl_dim_len|ttl_dim_wdt|";
                HeadTitle += "ttl_dim_hgt|ovr_fwrd_len|ovr_bkwd_len|ovr_lf_len|ovr_rt_len|ovr_hgt|in_ga_flg|ovr_void_slt_qty|crn_pst_sts_cd|xtd_ovr_qty|";
                HeadTitle += "pst_lck_pin_flg|grav_ctr_desc|stwg_rqst_desc|diff_rmk|modifyAproFlg|cntr_cgo_seq";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                       {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                       {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_cgo_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grs_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"net_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"awk_dcgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_len",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_wdt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_dim_hgt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_fwrd_len",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_bkwd_len",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_lf_len",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_rt_len",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"in_ga_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ovr_void_slt_qty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"crn_pst_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"xtd_ovr_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pst_lck_pin_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grav_ctr_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"stwg_rqst_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"diff_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"modifyaproflg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"temp_ovr_void_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_cgo_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd", KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",     KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",           KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_text",    KeyField:0,   CalcLogic:"",   Format:"",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
                       ];
                 
                InitColumns(cols);
                SetEditable(0);
                SetCountPosition(0);
				SetSheetHeight(130);

    			}
                break;
        	case "sheet3":
    			with (sheetObj) {
                var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|rcv_term_cd|de_term_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg|pck_qty|pck_tp_cd|grs_wgt|grs_ut_cd";
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
                       {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"grs_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"img_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetVisible(false);

    			}
    			break;
        	case "sheet4":
            	with (sheetObj) {
                var HeadTitle1="|||Length(CM)|Width(CM)|Height(CM)|awk_cgo_seq|bkg_no|dim_seq";
                var headCount=ComCountHeadTitle(HeadTitle1);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                       {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"dim_len",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dim_wdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dim_hgt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dim_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetEditable(1);
                SetVisible(false);
				}	
				break; 
        	case "sheet5":
            	with (sheetObj) {
                var HeadTitle1="|value|name|TpszCd|Vol.|rcvTerm|deTerm";
                var headCount=ComCountHeadTitle(HeadTitle1);
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_term_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);
	    		SetEditable(1);
	    		SetVisible(false);
				}	
				break; 
            case "sheet6":     
    		    with(sheetObj){
    				var HeadTitle1="bkg_no|awk_cgo_seq|spcl_cgo_auth_rjct_cd|spcl_cgo_auth_rmk";
    				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"awk_cgo_seq",                  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
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
	     		formParams += "f_cmd="       +ComGetObjValue(formObj.f_cmd);
	     		var sXml=sheetObj.GetSearchData("VOP_SCG_0031GS.do", formParams+"&spcl_cgo_cate_cd=AK");
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
     			ComBtnDisable("btn_AttachedFile"); 
				break;
     		case IBSEARCH:      //retrieve
     			spclAuthCd = "";
     			var opener = window.dialogArguments;
     			if (!opener) opener=window.opener;
     			if (!opener) opener = parent;
     			
				if (formObj.scg_flg.value=="SCG_AWK") {
					oSheetObj=opener.t2sheet1;
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.className="input2";
				}else if (formObj.scg_flg.value=="AWK"){
					oSheetObj=opener.t3sheet1;
				}else if (formObj.scg_flg.value=="SCG_45") {
					oSheetObj=opener.t4sheet1;
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.className="input2";
				}else if (formObj.scg_flg.value=="45"){
					oSheetObj=opener.t5sheet1;
				}
				
//				$("#pol_cd").text(oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd"));
//				$("#pod_cd").text(oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd"));
//					document.getElementById("pol_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
//					document.getElementById("pod_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				document.getElementById("pol_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
				document.getElementById("pod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				document.getElementById("pol_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_yd_cd").substring(5,7);
				document.getElementById("pod_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_yd_cd").substring(5,7);
				
				var formParams="";
         		formParams += "auth_flg=";
         		formParams += "&f_cmd="          +SEARCH;
         		formParams += "&rgn_shp_opr_cd=" +opener.comboObjects[0].GetSelectCode();
         		formParams += "&val_opr_tp_cd=";
         		formParams += "&booking_no="     +ComGetObjValue(formObj.bkg_no);
         		formParams += "&scg_flg=SCG_AWK";
      			var sXml=sheetObjects[5].GetSaveData("VOP_SCG_0014GS.do", formParams);
      			sheetObjects[5].LoadSaveData(sXml,{Sync:1});
      			
    			if(validateForm(sheetObj,formObj,sAction))
					formObj.f_cmd.value=SEARCH;
    			var resultXml=sheetObj.GetSearchData("ESM_BKG_0055GS.do", FormQueryString(formObj));
    				var arrXml=resultXml.split("|$$|");
    				if (arrXml.length == 5) {
    					var etcXml=arrXml[0];
    					sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
    					sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
    					sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
    					sheetObjects[3].LoadSearchData(arrXml[4],{Sync:1} );
    					sheetObjects[4].LoadSearchData(arrXml[3],{Sync:1} );
    					if(document.getElementById("bkg_no").value == ""){
    						document.getElementById("bkg_no").value=sheetObjects[1].GetCellValue(1, "bkg_no");
    					}

    					
    					document.getElementById("bl_no").value=sheetObjects[2].GetCellValue(1, "bl_no");
    					document.getElementById("package_sum").value = sheetObjects[2].GetCellValue(1, "pck_qty");
    					document.getElementById("pck_tp_cd").value = sheetObjects[2].GetCellValue(1, "pck_tp_cd");
    					document.getElementById("weight_sum").value = sheetObjects[2].GetCellText(1, "grs_wgt");
    					document.getElementById("wgt_ut_cd").value = sheetObjects[2].GetCellValue(1, "wgt_ut_cd");
//    					document.getElementById("package_sum").innerText=sheetObjects[2].GetCellValue(1, "pck_qty");
//    					document.getElementById("pck_tp_cd").innerText=sheetObjects[2].GetCellValue(1, "pck_tp_cd");
//    					document.getElementById("weight_sum").innerText=sheetObjects[2].GetCellText(1, "grs_wgt");
//    					document.getElementById("wgt_ut_cd").innerText=sheetObjects[2].GetCellValue(1, "wgt_ut_cd");
						//htmlSheetSync();
						if(sheetObjects[1].RowCount() > 0) htmlSheetSync(sheetObjects[1].GetSelectRow());
						//retrieve Attached File 
				        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
    				}
    				break;
         }
     }
    //business javascript OnKeyPress event Catch
    function initControl() {
    	axon_event.addListener('change', 	'auth_OnChange',				'spcl_cgo_auth_cd');
    	axon_event.addListener('change', 	'spcl_cgo_auth_rmk_OnChange', 	'spcl_cgo_auth_rmk');
    	axon_event.addListener('change', 	'apro_ref_no_OnChange', 		'apro_ref_no');
    }
    /**
     * Initializing Combo
     * setting Combo items
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
 //no support[check again]CLT 	            	IMEMode=0;	
 //no support[check again]CLT 	            	ValidChar(2,0);	
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
			    	if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
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
			    	if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
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
    	 
    	 if (formObj.scg_flg.value=="SCG_AWK") {
		    	formObj.spcl_cgo_auth_rmk.disabled=true;
		    	formObj.spcl_cgo_auth_rmk.className="input2";
		 }
    	 
     }

     /**
      * activate conter_no value selected from parent window.
      */
     function sheet2_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 //sheetObjects[1].ColumnSort("awk_cgo_seq","ASC");
    	 var formObj=document.form;
    	 
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 
		 if (document.form.scg_flg.value=="AWK"){
			 oSheetObj=opener.t3sheet1;
		 } else{
			 oSheetObj=opener.t2sheet1;
		 }

		 var bkg_no     = "";
    	 var vsl_cd     = "";
    	 var skd_voy_no = "";
    	 var skd_dir_cd = "";
    	 var awk_cgo_seq = "";
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
		 	 awk_cgo_seq = sheetObj.GetCellValue(iRow, "awk_cgo_seq");
			 chkFind = false;
			 
			 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
				 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + awk_cgo_seq;
				 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
				            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
				            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
				            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") +
				            oSheetObj.GetCellValue(i, preFix+"awk_cgo_seq");
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
					 
		    		 if (sheetObj.GetCellText(iRow, "awk_cgo_seq") == document.getElementById("awk_cgo_seq").value) {
		    			 sheetObj.SelectCell(iRow,"cntr_no");
		    			 setAuthStat(sheetObj, iRow);
		    		 }

		    		 chkFind = true;
					 break;
				 }
			 }
			 if(chkFind == false){
				 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
					 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + awk_cgo_seq;
					 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
					            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
					            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
					            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") + 
					 			oSheetObj.GetCellValue(i, preFix+"awk_cgo_seq"); 
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
						 
			    		 if (sheetObj.GetCellText(iRow, "awk_cgo_seq") == document.getElementById("awk_cgo_seq").value) {
			    			 sheetObj.SelectCell(iRow,"cntr_no");
			    			 setAuthStat(sheetObj, iRow);
			    		 }
			    		 chkFind = true;
						 break;
					 }
				 }
			 }
			
			 if(chkFind == false){
				 for(var i=sheetObjects[5].HeaderRows(); i<=sheetObjects[5].LastRow(); i++){
    				 if(sheetObj.GetCellValue(iRow, preFix+"awk_cgo_seq") == sheetObjects[5].GetCellValue(i, preFix+"awk_cgo_seq")){
    		    		 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[5].GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
    					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     sheetObjects[5].GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
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
     
     function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
    	 var formObj=document.form;
    	 
		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
			 if (!setParentValue()) {
				 sheetObj.SelectCell(oldRow,"cntr_no", 0, "", 0);
				 return false;
			 }
		 }
		 
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 
		 if (document.form.scg_flg.value=="AWK"){
			 oSheetObj=opener.t3sheet1;
		 } else{
			 oSheetObj=opener.t2sheet1;
		 }
		 
		 var bkg_no     = "";
    	 var vsl_cd     = "";
    	 var skd_voy_no = "";
    	 var skd_dir_cd = "";
    	 var awk_cgo_seq = "";
    	 var preFix     = "";
    	 var chkFind    = false;
		 
    	 bkg_no      = sheetObj.GetCellValue(Row, "bkg_no");
	 	 vsl_cd      = document.getElementById("vvd_cd").value.substring(0,4);
	 	 skd_voy_no  = document.getElementById("vvd_cd").value.substring(4,8);
	 	 skd_dir_cd  = document.getElementById("vvd_cd").value.substring(8,9);
	 	 awk_cgo_seq = sheetObj.GetCellValue(Row, "awk_cgo_seq");
		 chkFind = false;
		 
		 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
			 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + awk_cgo_seq;
			 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
			            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
			            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
			            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") +
			            oSheetObj.GetCellValue(i, preFix+"awk_cgo_seq");
			 if(findStr == oFindStr){
				 oSheetObj.SelectCell( i , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( i , "awk_cgo_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(i);
				 chkFind = true;
				 break;
			 }
		 }
		 if(chkFind == false){
			 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
				 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + awk_cgo_seq;
				 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
				            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
				            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
				            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") + 
				 			oSheetObj.GetCellValue(i, preFix+"awk_cgo_seq"); 
				 if(findStr == oFindStr){
					 oSheetObj.SelectCell( i , oSheetObj.GetSelectCol());
	    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
	    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
	    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( i , "awk_cgo_seq");
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
				if (formObj.scg_flg.value=="AWK") {
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
     
  	//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
  	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
  		with (sheetObj) {
  			
  			/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
  			if(sheetObjects[2].RowCount() > 0){
  				if(sheetObjects[2].GetCellValue(1,"img_flg") =='Y'){
//  					document.getElementById('btn_attach').style.color = 'blue';
  					ComGetObject("btn_attach").style.setProperty("color", BTN_BLUE, "important");
  				}else{
//  					document.getElementById('btn_attach').style.color = '';
  					ComGetObject("btn_attach").style.setProperty("color", "", "");
  				}
  			}
  		}
  	} 
     
     function htmlSheetSync(Row){
    	 //Row=sheetObjects[1].GetSelectRow();
    	 IBS_CopyRowToForm(sheetObjects[1], form, Row);	   
    		$("#frm_pck_qty").text(sheetObjects[1].GetCellText(Row, "pck_qty"));
    		$("#frm_grs_wgt").text(sheetObjects[1].GetCellText(Row, "grs_wgt"));
    		$("#frm_net_wgt").text(sheetObjects[1].GetCellText(Row, "net_wgt"));
//    	 document.getElementById("frm_pck_qty").innerText=sheetObjects[1].GetCellText(Row, "pck_qty");
//    	 document.getElementById("frm_grs_wgt").innerText=sheetObjects[1].GetCellText(Row, "grs_wgt");
//    	 document.getElementById("frm_net_wgt").innerText=sheetObjects[1].GetCellText(Row, "net_wgt");
    	 document.getElementById("temp_grs_wgt").value=sheetObjects[1].GetCellText(Row, "grs_wgt");
    	 document.getElementById("temp_net_wgt").value=sheetObjects[1].GetCellText(Row, "net_wgt");
		 document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
		 document.getElementById("rcv_term_cd").value=sheetObjects[1].GetCellValue(Row, "rcv_term_cd");
		 document.getElementById("de_term_cd").value=sheetObjects[1].GetCellValue(Row, "de_term_cd");
	     document.getElementById("frm_cntr_cgo_seq").value=sheetObjects[1].GetCellValue(Row, "cntr_cgo_seq");
		if (sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd") == "D7"){
 			document.getElementById("ttl_dim_len").value="1,317.6";
			document.getElementById("ttl_dim_wdt").value="243.8";
			document.getElementById("ttl_dim_hgt").value="289.6";
			document.getElementById("ovr_fwrd_len").value="0";
			document.getElementById("ovr_bkwd_len").value="0";
			document.getElementById("ovr_lf_len").value="0";
			document.getElementById("ovr_rt_len").value="0";
			document.getElementById("ovr_hgt").value="0";
			document.getElementById("ovr_void_slt_qty").value="0";
			sheetObjects[1].SetCellValue(Row, "ttl_dim_len",document.getElementById("ttl_dim_len").value,0);
			sheetObjects[1].SetCellValue(Row, "ttl_dim_wdt",document.getElementById("ttl_dim_wdt").value,0);
			sheetObjects[1].SetCellValue(Row, "ttl_dim_hgt",document.getElementById("ttl_dim_hgt").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_fwrd_len",document.getElementById("ovr_fwrd_len").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_bkwd_len",document.getElementById("ovr_bkwd_len").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_lf_len",document.getElementById("ovr_lf_len").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_rt_len",document.getElementById("ovr_rt_len").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_hgt",document.getElementById("ovr_hgt").value,0);
			sheetObjects[1].SetCellValue(Row, "ovr_void_slt_qty",document.getElementById("ovr_void_slt_qty").value,0);
			sheetObjects[1].SetCellValue(Row, "temp_ovr_void_qty",document.getElementById("ovr_void_slt_qty").value,0);
    	 }else{
    		 document.getElementById("ttl_dim_len").value=sheetObjects[1].GetCellText(Row, "ttl_dim_len");
    		 document.getElementById("ttl_dim_wdt").value=sheetObjects[1].GetCellText(Row, "ttl_dim_wdt");
    		 document.getElementById("ttl_dim_hgt").value=sheetObjects[1].GetCellText(Row, "ttl_dim_hgt");
    		 document.getElementById("ovr_fwrd_len").value=sheetObjects[1].GetCellText(Row, "ovr_fwrd_len");
    		 document.getElementById("ovr_bkwd_len").value=sheetObjects[1].GetCellText(Row, "ovr_bkwd_len");
    		 document.getElementById("ovr_lf_len").value=sheetObjects[1].GetCellText(Row, "ovr_lf_len");
    		 document.getElementById("ovr_rt_len").value=sheetObjects[1].GetCellText(Row, "ovr_rt_len");
    		 document.getElementById("ovr_hgt").value=sheetObjects[1].GetCellText(Row, "ovr_hgt");
    		 document.getElementById("ovr_void_slt_qty").value=sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty");
    		 sheetObjects[1].SetCellValue(Row, "temp_ovr_void_qty",sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty"),0);
    	 }
			document.getElementById("wgt_ut_cd1").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
			document.getElementById("wgt_ut_cd2").value=sheetObjects[1].GetCellValue(Row, "wgt_ut_cd");
			document.getElementById("crn_pst_sts_cd").value=sheetObjects[1].GetCellValue(Row, "crn_pst_sts_cd");
			document.getElementById("pst_lck_pin_flg").value=sheetObjects[1].GetCellValue(Row, "pst_lck_pin_flg");
			document.getElementById("temp_cntr_no").value=sheetObjects[1].GetCellValue(Row, "cntr_no");
			document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd");
			if(sheetObjects[1].GetCellValue(Row, "ovr_void_slt_qty") == "0"){
    		 document.getElementById("inGauge").checked=true;
    	 }else{
    		 document.getElementById("inGauge").checked=false;
    	 }
			var awk_cgo_seq=sheetObjects[1].GetCellValue(Row, "awk_cgo_seq")
    	 var findDetail=sheetObjects[3].FindText("awk_cgo_seq", awk_cgo_seq, 0, 2);
    	 if(sheetObjects[1].RowCount()> 0 && findDetail > 0){
    		 document.getElementById("details_button").style.color="red";
    	 }else{
    		 document.getElementById("details_button").style.color="";
    	 }
    	 document.getElementById("diff_rmk").value=sheetObjects[1].GetCellValue(Row, "diff_rmk");
    	 //document.getElementById("spcl_cgo_auth_cd").value=sheetObjects[1].GetCellValue(Row, "spcl_cgo_apro_cd");
    	 //document.getElementById("spcl_cgo_auth_rjct_cd").value=sheetObjects[1].GetCellValue(Row, "spcl_cgo_auth_rjct_cd");
    	 //document.getElementById("spcl_cgo_auth_rmk").value=sheetObjects[1].GetCellValue(Row, "spcl_cgo_auth_rmk");
     }     
     
     
     function apro_ref_no_OnChange() {
 		 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_ref_no"	, $("#apro_ref_no").val(), 0);
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
            if (formObj.scg_flg.value=="AWK" && opener.t3sheet1.GetCellText(opener.sheetObjects[2].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode()) {
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
            if (formObj.scg_flg.value=="AWK" && opener.t3sheet1.GetCellText(opener.sheetObjects[2].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode()) {
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
     function spcl_cgo_auth_rjct_cd_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
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
      * Clicking popup in IBSheet Object
      */
     function onPopupClick(srcName){
    	 var formObj=document.form;    
		 var row=formObj.row.value;
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj=opener.t2sheet1;					
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj=opener.t3sheet1;
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj=opener.t4sheet1;
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj=opener.t5sheet1;
		 }
		 
    	 if (srcName == "btn_PolCd") {
    		 ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd="+formObj.pol_cd.value, 1005, 680, "", '0,0', true);    		 
    	 }else if (srcName == "btn_PodCd" ) {
    		 ComOpenPopup("VOP_VSK_0509Pop.do?loc_cd="+formObj.pod_cd.value, 1005, 680, "", '0,0', true);
    	 }else if (srcName == "btns_Package") {
    	      ComOpenPopup("ESM_BKG_0696POP.do?searcheKeyOpener="+formObj.frm_pck_tp_cd.value, 550, 470, "","0,0,1,1,1", true);
    	 }else if (srcName == "btns_Commodity") {
    		 ComOpenPopup("ESM_BKG_0653.do?cmdt_cd="+formObj.frm_cmdt_cd.value, 823, 550, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btns_DgCntrSeq") {
    		 ComOpenWindowCenter("ESM_BKG_0754.do?bkgNo="+formObj.bkg_no.value+"&cntrNo="+formObj.temp_cntr_no.value+"&cntrTpszCd="+formObj.cntr_tpsz_cd.value, "ESM_BKG_0754", 805, 450, true);
    	 }else if (srcName == "btn_Criteria") {
    		 ComOpenPopup("ESM_BKG_0057.do", 505, 450, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btn_Details") {
    		 ComOpenWindowCenter("ESM_BKG_0756.do?bkgNo="+formObj.bkg_no.value+"&awkCgoSeq="+formObj.awk_cgo_seq.value, "ESM_BKG_0756",500, 310, true);
    	 //}else if (srcName == "btn_AttachedFile") {
    	 //	 ComOpenPopup("ESM_BKG_0207.do?bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=A&disableYn=Y", 523, 525, "", '0,0,1,1,1,1,1', true);
    	 }else if (srcName == "btn_ApprovalDetails") {
    		 ComOpenPopup("VOP_SCG_1016.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value, 1005, 520, "", '0,0', true);
    	 }else if (srcName == "btn_Prev") {
    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
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
    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "awk_cgo_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)-1;
    			 loadPage2();
    		 }
    	 }else if (srcName == "btn_Next") {
    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
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
    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "awk_cgo_seq");
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)+1;
    			 loadPage2();
    		 }
    	 } 
     }
     /**
      * Clicking popup in IBSheet Object
      */
     function setParentValue(){
    	 var formObj=document.form;
		 var row=formObj.row.value;
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj=opener.t2sheet1;					
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj=opener.t3sheet1;					
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj=opener.t4sheet1;					
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj=opener.t5sheet1;
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
	    			 if (bkgNo == oSheetObj.GetCellText(i, "bkg_no") && befVVD == oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd")) {
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
    	 var opener = window.dialogArguments;
    	 if (!opener) opener=window.opener;
    	 if (!opener) opener = parent;
		 var oSheetObj;
    	 var scg_flg="";
		 if (formObj.scg_flg.value=="SCG_AWK") {
			 oSheetObj=opener.t2sheet1;					
	    	 scg_flg="AK";
		 }else if (formObj.scg_flg.value=="AWK"){
			 oSheetObj=opener.t3sheet1;					
	    	 scg_flg="AK";
		 }else if (formObj.scg_flg.value=="SCG_45") {
			 oSheetObj=opener.t4sheet1;					
	    	 scg_flg="45";
		 }else if (formObj.scg_flg.value=="45"){
			 oSheetObj=opener.t5sheet1;
	    	 scg_flg="45";
		 }
		 var crr_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "crr_cd");
		 var bkg_ref_no="";
		 var spcl_cgo_rqst_seq="";
    	 var bkg_no=formObj.bkg_no.value; 
    	 var spcl_cgo_apro_rqst_seq=formObj.spcl_cgo_apro_rqst_seq.value;
		 var vsl_pre_pst_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_pre_pst_cd");
		 var vsl_seq=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_seq");
    	 var rgn_shp_opr_cd=opener.rgn_shp_opr_cd.GetSelectCode();
    	 var send_type="0";
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

     