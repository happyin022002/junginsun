/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_0015.js
*@FileTitle  : Dangerous CGO Application Details for Own BKG
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
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
     * @class VOP_SCG_0015 : business script for VOP_SCG_0015
     */
    // common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	
	var rjtCode = "Y"; //RJT Code 최초 빈값 셋팅여부확인 
   	var openerObj=window.dialogArguments;
   	var spclAuthCd;
   	// ::DG RailBilling 2015-12-02 ::
   	var provi_length=9;
   	var oldRow = "";
   	
   	if(!openerObj) var openerObj= parent;
	// Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	/***** In case of more than 2 sheets in a tab, additional sheet variables can be specified *****/
    	var sheetObject1=sheetObjects[0];
    	var sheetObject2=sheetObjects[1];
    	var sheetObject3=sheetObjects[2];
    	var sheetObject4=sheetObjects[3];
    	var sheetObject5=sheetObjects[4];
    	var formObject=document.form;
    	/*******************************************************/
    	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
     		switch(srcName) {
	 			case "btn_RouteDetail":
	 				onPopupClick(srcName);
	 				break;
	 			case "btn_UnInformation":
	 				onPopupClick(srcName);
	 				break;
	 			case "btn_Restrictions":
	 				onPopupClick(srcName);
	 				break;
	 			case "btn_Pre-CheckingReport":
	 				onPopupClick(srcName);
	 				break;
	 			case "btn_PackageQtyType":
	 				onPopupClick(srcName);
	 				break;
	 			case "btn_UnNo":
	 				onPopupClick(srcName);
	 				break;
	 			// ::DG RailBilling 2015-12-02 ::	
	 			case "btn_OtherEmergencyInformation":
	 				onPopupClick(srcName);
	 				break;
	 			// ::DG RailBilling 2015-12-02 ::
	 			case "btn_dot_info":
	 				onPopupClick(srcName);
	 				break;
	 			// ::DG RailBilling 2015-12-02 ::	
				case "btn_declarant":
					if (document.getElementById("bkg_no").value != "" || document.getElementById("bl_no").value != "") {
						var bkg_no=document.getElementById("bkg_no").value;
						var dcgo_seq=document.getElementById("dcgo_seq").value;
						var dg_cntr_seq = document.getElementById("dg_cntr_seq").value;
						//var param = "?pop_type=R&bkg_no="+bkg_no+"&dcgo_seq="+dcgo_seq;
						var param = "?pop_type=R&bkg_no="+bkg_no+"&dg_cntr_seq="+dg_cntr_seq;
						ComOpenPopup("ESM_BKG_1300.do"+param,1000,600,"","0,0",true,false,0,0,0,"ESM_BKG_1300");

					}
					break;
                case "btn_AttachedFile":
 					onPopupClick(srcName);
                	break;
	            case "btn_ApprovalDetails":
	            	onPopupClick(srcName);
	            	break;
				case "btn_attach":
					if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
						ComOpenPopup("ESM_BKG_0207.do?bkg_no=" + document.getElementById("bkg_no").value + "&ridr_tp_cd=D&disableYn=Y", 580, 520, "", "1,0", true);
					}
					break;	            	
	            case "btn_Mail":
					if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
						sendReqMail(sheetObject2, formObject);
					}	            	
	            	break;
	            case "btn_Prev":
	            	onPopupClick(srcName);
	            	break;
	            case "btn_Next":
	            	onPopupClick(srcName); 
	            	break;
	            case "btn_Close":
					if (document.form.scg_flg.value=="DG1" || document.form.scg_flg.value=="DG2"){
						if(setParentValue())  ComClosePopup(); 
					}else{
						ComClosePopup(); 
					}
	            	break;
	            	
				// ::DG RailBilling 2015-12-02 ::		
				case "btn_imdg_spcl_provi_no1": 
				case "btn_imdg_spcl_provi_no2": 
				case "btn_imdg_spcl_provi_no3": 
				case "btn_imdg_spcl_provi_no4": 
				case "btn_imdg_spcl_provi_no5": 
				case "btn_imdg_spcl_provi_no6": 
				case "btn_imdg_spcl_provi_no7": 
				case "btn_imdg_spcl_provi_no8":
					if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
						onPopupClickSpclProviCtnt(srcName);
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
    		ComConfigSheet (sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
             tabObjects[k].SetSelectedIndex(0);
    	}
    	// Initializing IBMultiCombo
    	for(var k=0; k<comboObjects.length; k++){
    		initCombo(comboObjects[k], k + 1);
   			comboObjects[k].SetEnable(0);
    	}
    	
    	sheet1_OnLoadFinish(sheetObj);
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	loadPage2();
    }
    
    function loadPage2() {
    	var formObj=document.form;
 		formObj.spcl_cgo_auth_cd.options.length="5";
        if (formObj.type.value == "P") { //P : VOP_SCG_0023, O : VOP_SCG_0015 
    		document.getElementById("spcl_cgo_auth_cd").disabled=true;
    		//document.getElementById("spcl_cgo_auth_rmk").disabled = true;
    		document.getElementById("apro_ref_no").disabled=true;
 			document.getElementById("spcl_cgo_auth_cd").className="input2";
 			document.getElementById("spcl_cgo_auth_rmk").className="input";
 			document.getElementById("apro_ref_no").className="input2";
        }
    	//Initializing html control event
    	initControl();
   		
    	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC01);
    	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC02);
    	doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC04);
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
    	       
    	      var HeadTitle1="TP/SZ|BKG Q'ty|DG Q'ty";

    	      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"op_cntr_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"dcgo_qty",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
    	       
    	      InitColumns(cols);

    	      SetEditable(0);
    	      SetSheetHeight(150);
    	            }


                break;
    		case "sheet2":      //sheet2 init
    		    with(sheetObj){ 
    	      var HeadTitle1="|Seq||Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" +
    	      "|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc" +
    	      "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" +
    	      "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd" +
    	      "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|spcl_rqst_flg|spcl_rqst_desc|rc_seq|awk_cgo_seq|dg_cntr_seq";
    	      var HeadTitle1="|Seq||Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no|dg_cgo_seq" +
    	      "|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm|hzd_desc" +
    	      "|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|hcdg_flag|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3|imdg_subs_rsk_lbl_cd4" +
    	      "|dcgo_sts_cd|mrn_polut_flg|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt|rada_ut_cd" +
    	      "|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk||meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_dpnd_qty_flg|dg_cntr_seq";

    	      SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

    	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    	      InitHeaders(headers, info);

    	      var cols = [ {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"DelChk" },
    	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
    	             {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cargo_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cargo_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_trsp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clod_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lcl_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"approved",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_text",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_gdt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
    	             
    	             ];
    	       
    	      InitColumns(cols);

    	      SetEditable(0);
    	      SetSheetHeight(250);
    	      SetHighlightAfterSort(0);
    	    }


                break;
    		case "sheet3":      //sheet3 init
    		    with(sheetObj){
    	        
    	      var HeadTitle1="bkg_no|bl_no|tvvd|pol_cd|pol_nod_cd|pod_cd|pod_nod_cd|bkg_sts_cd|corr_n1st_dt|bdr_flg";

    	      SetConfig( { SearchMode:0, MergeSheet:0, Page:20, DataRowMerge:0 } );

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
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bkg_sts_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"corr_n1st_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bdr_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
    	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"img_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
    	       
    	      InitColumns(cols);

    	      SetEditable(0);
    	      SetSheetHeight(100);
    	            }


                break;
    		case "sheet4":      //sheet3 init
    		      with(sheetObj){
             var HeadTitle1="|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" +
             "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm" +
             "|hzd_desc|flsh_pnt_cdo_temp|imdg_segr_grp_no|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" +
             "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt" +
             "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" +
             "|out_imdg_pck_cd2|in_imdg_pck_desc1|in_imdg_pck_desc2|out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty" +
             "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|imdg_lmt_qty_desc|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt" +
             "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|||||||CFR flg|RSD flg|imdg_amdt_no";

             SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"CntrChk" },
                 {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
                 {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 //:2016-01-27:by TOP://
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_segr_grp_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_trsp_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clod_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lcl_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_intmd_bc_rstr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_pck_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ltd_qty",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"modifyaproflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_crr_rstr_expt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",		           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 // ::RSD FLG 2016-09-21 ::	                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rsd_flg",		           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 
                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",		       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 // ::DG RailBilling 2015-12-02 ::	
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_no",	  		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_cntc_no",	  		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"erap_apro_ref_no",	  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_exp_no",	  		  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_spcl_apro_no",	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dot_auth_no",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_spcl_provi_ctnt",	  	      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rjct_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"apro_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_text",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ref_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_gdt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
                  ];
              
             InitColumns(cols);

             SetEditable(1);
             SetSheetHeight(150);
                      }


                break;
			case "sheet5":      //sheet3 init
			    with(sheetObj){
		        
		      var HeadTitle1="|value|name";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
		             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetSheetHeight(100);
		            }


			    
			break;
			
			case "sheet6":      //sheet6 init
  		      with(sheetObj){
           var HeadTitle1="|||Seq|Container No.|Container No.|Vol.|Appr.|Related SPC CGO Appl.|Related SPC CGO Appl.|bkg_no" +
           "|dg_cgo_seq|cntr_cgo_seq|imdg_clss_cd|imdg_comp_grp_cd|imdg_un_no|imdg_un_no_seq|grs_wgt|wgt_ut_cd|net_wgt|prp_shp_nm" +
           "|hzd_desc|flsh_pnt_cdo_temp|imdg_pck_grp_cd|psa_no|imdg_lmt_qty_flg|imdg_expt_qty_flg|imdg_subs_rsk_lbl_cd1|imdg_subs_rsk_lbl_cd2|imdg_subs_rsk_lbl_cd3" +
           "|imdg_subs_rsk_lbl_cd4|dcgo_sts_cd|mrn_polut_flg|imdg_mrn_polut_cd|emer_cntc_phn_no_ctnt|emer_cntc_pson_nm|certi_no|cnee_dtl_desc|net_explo_wgt|rada_skd_no|rada_amt" +
           "|rada_ut_cd|rada_trsp_no|clod_flg|cgo_lcl_flg|diff_rmk|bkg_cntr_seq|in_imdg_pck_cd1|in_imdg_pck_cd2|out_imdg_pck_cd1" +
           "|out_imdg_pck_cd2|in_imdg_pck_desc1|in_imdg_pck_desc2|out_imdg_pck_desc1|out_imdg_pck_desc2|in_imdg_pck_qty1|in_imdg_pck_qty2|out_imdg_pck_qty1|out_imdg_pck_qty2|max_in_pck_qty" +
           "|max_in_pck_tp_cd|hcdg_intmd_bc_rstr_desc|hcdg_pck_rstr_desc|hcdg_tnk_rstr_desc|ltd_qty|imdg_lmg_qty_desc|ems_no|emer_rspn_gid_no|emer_rspn_gid_chr_no|ctrl_temp_ctnt|emer_temp_ctnt" +
           "|dcgo_seq|modifyaproflg|dg_cntr_seq|meas_qty|rc_flg|awk_cgo_flg|bb_cgo_flg|hcdg_flg|hcdg_qty|hcdg_dpnd_qty_flg|||||||CFR flg|RSD flg|imdg_amdt_no";

           SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

           var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
           var headers = [ { Text:HeadTitle1, Align:"Center"} ];
           InitHeaders(headers, info);

           var cols = [ {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"CntrChk" },
               {Type:"DummyCheck", Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"DelChk" },
               {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
               {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
               {Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_vol_qty",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_apro_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cgo_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_comp_grp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"grs_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_wgt",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prp_shp_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hzd_desc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_pck_grp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"psa_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_sts_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"mrn_polut_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_mrn_polut_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_cntc_pson_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"certi_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cnee_dtl_desc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"net_explo_wgt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_skd_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_amt",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_ut_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rada_trsp_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clod_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_lcl_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"diff_rmk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_cntr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_cd2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_desc2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_desc2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_desc2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"in_imdg_pck_qty2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"intmd_imdg_pck_qty2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"out_imdg_pck_qty2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"max_in_pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_intmd_bc_rstr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_pck_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_tnk_rstr_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ltd_qty",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_lmt_qty_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ems_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_rspn_gid_chr_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ctrl_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"emer_temp_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"modifyaproflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_cntr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"awk_cgo_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bb_cgo_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hcdg_dpnd_qty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_spcl_provi_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_crr_rstr_expt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_rqst_desc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_expt_qty_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cfr_flg",		             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               // ::RSD FLG 2016-09-21 ::	                 
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rsd_flg",		           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
               
               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"imdg_amdt_no",		     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
                ];
            
           InitColumns(cols);

           SetEditable(1);
           SetSheetHeight(150);
                    }


              break;
            case "sheet7":     
    		    with(sheetObj){
    				var HeadTitle1="bkg_no|dcgo_seq|spcl_cgo_auth_rjct_cd|spcl_cgo_auth_rmk|spcl_cgo_apro_cd|auth_usr_id|auth_gdt";
    				SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

    				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    				InitHeaders(headers, info);

    				var cols = [ {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"dcgo_seq",                KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"spcl_cgo_auth_rjct_cd",   KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"spcl_cgo_auth_rmk",       KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"spcl_cgo_auth_cd",        KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
    	                         {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"auth_gdt",                KeyField:0,   CalcLogic:"",   Format:"",       PointCount:0,   UpdateEdit:0,   InsertEdit:1 }
    	                         ];
    	       
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
	     	case IBSEARCH_ASYNC01: //RJT CD retrieve
	     		formObj.f_cmd.value=SEARCH;
	 			var formParams="";
	     		formParams += "f_cmd="+ComGetObjValue(formObj.f_cmd);
 	     		var sXml=sheetObj.GetSearchData("VOP_SCG_0031GS.do", formParams+"&spcl_cgo_cate_cd=DG");
//				ComXml2ComboItem(sXml, formObj.spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
 	     		ComXml2ComboItem(sXml, spcl_cgo_auth_rjct_cd, "spcl_cgo_lod_rjct_rsn_cd", "spcl_cgo_lod_rjct_rsn_cd|rjct_rsn_cd_desc");
				break;
     		case IBSEARCH_ASYNC02: //Rqst retrieve
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
     		case IBSEARCH_ASYNC03: //Attached File retrieve
     			ComBtnDisable("btn_AttachedFile"); 
				break;
     		case IBSEARCH_ASYNC04: //Segregation Group Code retrieve
 				var sXml=sheetObj.GetSearchData("VOP_SCG_0001GS.do", "f_cmd="+SEARCH01);
				var arrXml=sXml.split("|$$|");
 	     		ComXml2ComboItem(arrXml[1], comboObjects[0], "imdg_segr_grp_no", "imdg_segr_grp_nm");
				break;
     		case IBSEARCH:      //retrieve
     			spclAuthCd = "";
				if (formObj.scg_flg.value=="DG1") {  //SCG_DG : VOP_SCG_0023 , DG2 : VOP_SCG_0014
					oSheetObj=openerObj.sheetObjects[0];
				}else if (formObj.scg_flg.value=="SCG_DG"){
					oSheetObj=openerObj.sheetObjects[0];
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.className="input2";
				}else if (formObj.scg_flg.value=="DG2"){
					oSheetObj=openerObj.sheetObjects[0];
				}
				
				//@@
				//document.getElementById("pol_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
				//document.getElementById("pod_cd").innerText=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				//document.getElementById("pol_cd").innerHTML=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
				//document.getElementById("pod_cd").innerHTML=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				document.getElementById("pol_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_cd");
				document.getElementById("pod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_cd");
				document.getElementById("pol_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_yd_cd").substring(5,7);
				document.getElementById("pod_nod_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_yd_cd").substring(5,7);
				document.getElementById("bkg_pol_yd_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pol_yd_cd");
				document.getElementById("bkg_pod_yd_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "pod_yd_cd");
			   	
				document.getElementById("dcgo_ref_no").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "dcgo_ref_no");
				document.getElementById("itm_sts_cd").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "itm_sts_cd");
				document.getElementById("spcl_cgo_apro_rqst_seq").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "spcl_cgo_apro_rqst_seq")
				comboObjects[0].SetSelectCode(oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "imdg_segr_grp_no"),false);
		    	if(oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "rsd_flg")=="")
		    		document.getElementById("rsd_flg").value="N";
		    	else
		    		document.getElementById("rsd_flg").value=oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "rsd_flg");
				
		    	var formParams="";
         		formParams += "auth_flg=";
         		formParams += "&f_cmd="          +SEARCH;
         		formParams += "&rgn_shp_opr_cd=" +openerObj.comboObjects[0].GetSelectCode();
         		formParams += "&val_opr_tp_cd=";
         		formParams += "&booking_no="     +ComGetObjValue(formObj.bkg_no);
         		formParams += "&scg_flg=SCG_DG";
      			var sXml=sheetObjects[6].GetSearchData("VOP_SCG_0014GS.do", formParams);
      			sheetObjects[6].LoadSearchData(sXml,{Sync:1});
      			
				if(validateForm(sheetObj,formObj,sAction))
     				formObj.f_cmd.value=SEARCH;
 					var resultXml=sheetObj.GetSearchData("ESM_BKG_0200GS.do", FormQueryString(formObj));
					var arrXml=resultXml.split("|$$|");
					if (arrXml.length == 6) {
						var etcXml=arrXml[0];
						sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1} );
						//sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
						sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						sheetObjects[2].LoadSearchData(arrXml[3],{Sync:1} );
						sheetObjects[3].LoadSearchData(arrXml[1],{Sync:1} );
						sheetObjects[4].LoadSearchData(arrXml[4],{Sync:1} );
						sheetObjects[1].SetColHidden("tempSeq",1);
						if(document.getElementById("bkg_no").value == ""){
							document.getElementById("bkg_no").value=sheetObjects[2].GetCellValue(1, "bkg_no");
						}
						document.getElementById("bl_no").value=sheetObjects[2].GetCellValue(1, "bl_no");
						cntrChk();

						formObj.f_cmd.value=SEARCH02;
						var resultXml=sheetObj.GetSearchData("VOP_SCG_0015GS.do", FormQueryString(formObj));
						sheetObjects[5].LoadSearchData(resultXml,{Sync:1} );
						
						//htmlSheetSync();
						if(sheetObjects[1].RowCount() > 0) htmlSheetSync(sheetObjects[1].GetSelectRow());
						//Attached File retrieve
				        doActionIBSheet(sheetObjects[3],document.form,IBSEARCH_ASYNC03);
					}
					break;
    	}
     }
     /**
      * register IBTab Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }
     /**
      * initializing Tab
      * setting Tab items
      */
     function initTab(tabObj , tabNo) {
          switch(tabNo) {
              case 1:
                 with (tabObj) {
                     var cnt=0 ;
                     InsertItem( "Class 1 Only" , "");
                     InsertItem( "Class 7 Only" , "");
                     //no support[check again]CLT BaseColor="243,242,248";
                 }
              break;
          }
     }
     /**
      * Related event when clicking Tab
      * selected tab element activates.
      */
     function tab1_OnChange(tabObj , nItem)
     {
         var objs=document.all.item("tabLayer");
         objs[nItem].style.display="Inline";
         objs[beforetab].style.display="none";
         //--------------- important point --------------------------//
         objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
         //------------------------------------------------------//
         beforetab=nItem;
     }
     //business javascript OnKeyPress event Catch
     function initControl() {
//      	axon_event.addListener('click', 	'auth_OnClick', 'spcl_cgo_auth_cd');
//     	axon_event.addListener('change', 	'auth_OnChange', 'spcl_cgo_auth_cd');
    	 axon_event.addListener('change', 	'spcl_cgo_auth_cd_OnChange', 'spcl_cgo_auth_cd');
     	axon_event.addListener('change', 	'spcl_cgo_auth_rmk_OnChange', 	'spcl_cgo_auth_rmk');
    	axon_event.addListener('change', 	'apro_ref_no_OnChange', 		'apro_ref_no');
     }
     /**
      * initializing Combo
      * Setting Combo items
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
 	        case "imdg_segr_grp_no":
 	            with(comboObj) {
					SetColAlign(0, "left");
					SetColWidth(0, "400");
    	  			SetTitle("Description");
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
//    		 if (formObj.type.value == "P") {
//    			 document.getElementById("spcl_cgo_auth_cd").disabled=true;
//    		 	 document.getElementById("spcl_cgo_auth_cd").className="input2";
//    		 }else{
//    			 document.getElementById("spcl_cgo_auth_cd").disabled=false;
//    		 	 document.getElementById("spcl_cgo_auth_cd").className="input1";
//    		 }
    		 switch(auth)
    		 {
    		 	case "R":
    		 		formObj.spcl_cgo_auth_cd.options.length="5";
			    	formObj.spcl_cgo_auth_cd.options[4].text=GetCellValue(GetSelectRow(), "spcl_cgo_apro_text");
			    	formObj.spcl_cgo_auth_cd.options[4].value=GetCellValue(GetSelectRow(), "spcl_cgo_apro_cd");
			    	spclAuthCd = GetCellText(GetSelectRow(), "spcl_cgo_apro_cd");
			 		formObj.spcl_cgo_auth_cd.options[4].style.color="orange";
			    	formObj.spcl_cgo_auth_cd.options[4].selected=true;
			    	comboObjects[1].SetEnable(0);
			    	comboObjects[1].SetSelectCode("",false);
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.value="";
			    	formObj.apro_ref_no.value="";
					break;
				case "Y":
			 		formObj.spcl_cgo_auth_cd.options.length="4";
			    	formObj.spcl_cgo_auth_cd.options[0].selected=true;
			    	comboObjects[1].SetEnable(0);
			    	comboObjects[1].SetSelectCode("",false);
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
			    	if (formObj.scg_flg.value=="DG2") {
			    		if(formObj.row.value != "-1"){
			    			comboObjects[1].SetEnable(1);
			    		}
				    	if (GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className="input1";			    		
				    	}
			    	}
			    	//comboObjects[1].SetEnable(1);
			    	comboObjects[1].SetSelectCode(GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd"),false);
			    	formObj.spcl_cgo_auth_rmk.value=GetCellText(GetSelectRow(), "spcl_cgo_auth_rmk");
			    	formObj.apro_ref_no.value="";
			    	
					break;
				case "P":
			 		formObj.spcl_cgo_auth_cd.options.length="4";
			    	formObj.spcl_cgo_auth_cd.options[3].selected=true;
			    	if (formObj.scg_flg.value=="DG2") {
				    	comboObjects[1].SetEnable(0);
				    	//comboObjects[1].SetBackColor("#FFFFFF");
				    	if (GetCellText(GetSelectRow(), "spcl_cgo_auth_rjct_cd") == 'AAA') {
					    	formObj.spcl_cgo_auth_rmk.className="input1";			    		
				    	}
			    	}
			    	comboObjects[1].SetEnable(0);
			    	comboObjects[1].SetSelectCode(GetCellValue(GetSelectRow(), "spcl_cgo_auth_rjct_cd"));
			    	formObj.spcl_cgo_auth_rmk.disabled=false;
			    	formObj.spcl_cgo_auth_rmk.value=GetCellText(GetSelectRow(), "spcl_cgo_auth_rmk");
			    	formObj.apro_ref_no.value="";
			    	
					break;
    		 	case "C":
    		 		formObj.spcl_cgo_auth_cd.options.length="5";
			    	formObj.spcl_cgo_auth_cd.options[4].text="C";
			    	formObj.spcl_cgo_auth_cd.options[4].value="C";
			    	spclAuthCd = GetCellText(GetSelectRow(), "spcl_cgo_apro_cd");
			 		formObj.spcl_cgo_auth_cd.options[4].style.color="orange";
			    	formObj.spcl_cgo_auth_cd.options[4].selected=true;
			    	comboObjects[1].SetEnable(0);
			    	comboObjects[1].SetSelectCode("",false);
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.value="";
			    	formObj.apro_ref_no.value="";
			    	
				    document.getElementById("spcl_cgo_auth_cd").disabled=true;
				 	document.getElementById("spcl_cgo_auth_cd").className="input2";
				 	
					break;
    		 	case "":
    		 		formObj.spcl_cgo_auth_cd.options.length="5";
			    	formObj.spcl_cgo_auth_cd.options[4].text="";
			    	formObj.spcl_cgo_auth_cd.options[4].value="";
			    	spclAuthCd = GetCellText(GetSelectRow(), "spcl_cgo_apro_cd");
			 		formObj.spcl_cgo_auth_cd.options[4].style.color="orange";
			    	formObj.spcl_cgo_auth_cd.options[4].selected=true;
			    	comboObjects[1].SetEnable(0);
			    	comboObjects[1].SetSelectCode("",false);
			    	formObj.spcl_cgo_auth_rmk.disabled=true;
			    	formObj.spcl_cgo_auth_rmk.value="";
			    	formObj.apro_ref_no.value="";
			    	
				    document.getElementById("spcl_cgo_auth_cd").disabled=true;
				 	document.getElementById("spcl_cgo_auth_cd").className="input2";
				 	
					break;					

			}
    		 
    		 if(formObj.scg_flg.value=="SCG_DG"){
    			 if(GetCellText(GetSelectRow(), "auth_gdt") != -1){
    				 if(auth!="R"){
        				 formObj.auth_usr_id.value =  GetCellText(GetSelectRow(), "auth_usr_id");
            			 formObj.auth_dt.value =  GetCellText(GetSelectRow(), "auth_gdt").substring(0,10);	
    				 }
 
    			 }
    			 
    		 }
    		 
    			 
    	 }
     }
     
//     function auth_OnChange() {
     
     function spcl_cgo_auth_cd_OnChange(){
 		var obj=event.srcElement;
 		var formObj=document.form;
 		if(spclAuthCd!=""){
 			formObj.spcl_cgo_auth_cd.options.length=5;
 		}else{
 			formObj.spcl_cgo_auth_cd.options.length=4;
 		}
 		if (obj.value == "N") {
 			
 			if(rjtCode == "N"){	//최초 빈값을 셋팅한다 
 				comboObjects[1].DeleteItem(0);
 				rjtCode = "Y";
 			}
 			comboObjects[1].SetSelectIndex(-1, true);
   			comboObjects[1].SetEnable(1);
	    	comboObjects[1].SetBackColor("#CCFFFD");
   			//formObj.spcl_cgo_auth_rmk.disabled = false;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
	    	formObj.spcl_cgo_auth_rmk.disabled=false;
   			formObj.spcl_cgo_auth_rmk.value="";
   			formObj.apro_ref_no.value="";
    		document.getElementById("apro_ref_no").disabled=true;
 			document.getElementById("apro_ref_no").className="input2";
 		}else if (obj.value == "P") {
 			
 			if(rjtCode == "N"){	//최초 빈값을 셋팅한다 
 				comboObjects[1].DeleteItem(0);
 				rjtCode = "Y";
 			}
 			
   			comboObjects[1].SetSelectIndex(-1, true);
 			comboObjects[1].SetEnable(0);
 			comboObjects[1].SetBackColor("#FFFFFF");
 			//formObj.spcl_cgo_auth_rmk.disabled = false;
 			//formObj.spcl_cgo_auth_rmk.className = "input";
 			formObj.spcl_cgo_auth_rmk.disabled=false;
   			formObj.spcl_cgo_auth_rmk.value="";
 			formObj.apro_ref_no.value="";
 			document.getElementById("apro_ref_no").disabled=true;
 			document.getElementById("apro_ref_no").className="input2";
 		}else{
 			if(rjtCode == "Y"){	//최초 빈값을 셋팅한다 
 				comboObjects[1].InsertItem(0, "", "");
 				rjtCode = "N";
 			}
 			
   			comboObjects[1].SetSelectIndex(-1, true);
   			comboObjects[1].SetEnable(0);
   			//formObj.spcl_cgo_auth_rmk.disabled = true;
   			//formObj.spcl_cgo_auth_rmk.className = "input";
   			if (obj.value == "Y" || obj.value == "A") {
   				formObj.spcl_cgo_auth_rmk.disabled=false;
   				formObj.spcl_cgo_auth_rmk.className = "input";
   			}else{
   				formObj.spcl_cgo_auth_rmk.disabled=true;	
   			}
   				
   	     	formObj.spcl_cgo_auth_rmk.value="";	
	    	if (formObj.scg_flg.value=="DG1" && openerObj.sheetObjects[0].GetCellText(openerObj.sheetObjects[0].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode() && (obj.value == "A" || obj.value == "Y" || obj.value == "")) {
	    		document.getElementById("apro_ref_no").disabled=true;
	    		document.getElementById("apro_ref_no").className="input2";
	    	}else if (formObj.scg_flg.value=="DG2" && openerObj.sheetObjects[0].GetCellText(openerObj.sheetObjects[0].GetSelectRow(), "crr_code") != ConstantMgr.getCompanyCode() && (obj.value == "A" || obj.value == "Y" || obj.value == "")) {
	    		document.getElementById("apro_ref_no").disabled=true;
	 			document.getElementById("apro_ref_no").className="input2";
	    	}
 		}
 		
 		//sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd", obj.value , 0); 
 		//sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_auth_rjct_cd") , 0);
 		//sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rmk", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_auth_rmk") , 0);
		 
 		if(obj.value == "A"){
            for (var iRow=1;iRow<=sheetObjects[1].LastRow();iRow++){
            	if(sheetObjects[1].GetCellValue(iRow, "spcl_cgo_apro_cd") != "Y" ){
         	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_apro_cd"	  , "Y", 0);
         	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_apro_text"	  , "Y", 0);
         	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", "", 0);
         	 		sheetObjects[1].SetCellValue(iRow, "spcl_cgo_auth_rmk"	  , "", 0);
         	 		sheetObjects[1].SetCellValue(iRow, "apro_ref_no"	      , sheetObjects[1].GetCellValue(iRow, "apro_ref_no"), 0);
         	 		
         	 		setAuthFontColor(sheetObjects[1], iRow);
            	}
            }
            
//     		var cntR = 0;
//     		for(var i=sheetObjects[3].HeaderRows(); i<=sheetObjects[3].LastRow(); i++){
//	 			 if(sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") == "R"){
//	 				 cntR++;
//	 			 }
//     		}
            //2016-09-26 
            for(var i=sheetObjects[3].HeaderRows(); i<=sheetObjects[3].LastRow(); i++){
	 			sheetObjects[3].SetCellValue(i, "spcl_cgo_apro_cd", "Y", 0);
	 			sheetObjects[3].SetCellValue(i, "spcl_cgo_apro_text"	  , "Y", 0);
      	 		sheetObjects[3].SetCellValue(i, "spcl_cgo_auth_rjct_cd", "", 0);
      	 		sheetObjects[3].SetCellValue(i, "spcl_cgo_auth_rmk"	  , "", 0);
            }
            
 		}else{
 		 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd"		, $("#spcl_cgo_auth_cd").val(), 0);
 	 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_text"	, obj.options[obj.selectedIndex].text, 0);
 	 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
 	 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
 	 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "apro_ref_no"	        , $("#apro_ref_no").val(), 0);

 	 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_apro_cd"		, $("#spcl_cgo_auth_cd").val(), 0);
 	 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_apro_text"	, obj.options[obj.selectedIndex].text, 0);
 	 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
 	 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
 	 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "apro_ref_no"	        , $("#apro_ref_no").val(), 0);

 	 	 	
 	 	 	setAuthFontColor(sheetObjects[1], sheetObjects[1].GetSelectRow()); 			
 		}
 	 		
     }
     
     /**
      * Sheet관련 컬럼 sheet2_OnClick 엑션 이벤트 처리 
      * @param sheetObj, Row, Col, Value
      */
     function sheet2_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		 //2016-02-16
		 if (!setParentValue()) {
			 sheetObj.SelectCell(oldRow,"cntr_no", 0, "", 0);
			 return false;
		 }
		 
    	 var formObj=document.form;
		 sheetObj.SelectCell( parseInt(Row) , sheetObj.GetSelectCol());
//		 formObj.bkg_no.value=sheetObj.GetCellValue( parseInt(row) , "bkg_no");
//		 formObj.vvd_cd.value=sheetObj.GetCellText(parseInt(row), "vsl_cd")+sheetObj.GetCellText(parseInt(row), "skd_voy_no")+sheetObj.GetCellText(parseInt(row), "skd_dir_cd");
//		 if (formObj.scg_flg.value=="SCG_DG"){
//			 alert("##"+sheetObj.GetCellValue( parseInt(row) , "spcl_cntr_seq"))
//			 alert("##"+sheetObj.GetCellValue( parseInt(row) , "dg_cntr_seq"))
//			formObj.dg_cntr_seq.value=sheetObj.GetCellValue( parseInt(row) , "spcl_cntr_seq");
//			formObj.cntr_cgo_seq.value=sheetObj.GetCellValue( parseInt(row) , "spcl_cgo_seq");
//			formObj.cntr_cgo_seq1.value=sheetObj.GetCellValue( parseInt(row) , "spcl_cgo_seq");
//		 }else {
			
		    formObj.dcgo_seq.value=sheetObj.GetCellValue( parseInt(Row), "dcgo_seq");
			formObj.dg_cntr_seq.value=sheetObj.GetCellValue( parseInt(Row) , "dg_cntr_seq");
			formObj.cntr_cgo_seq.value=sheetObj.GetCellValue( parseInt(Row) , "cntr_cgo_seq");
			formObj.cntr_cgo_seq1.value=sheetObj.GetCellValue( parseInt(Row) , "cntr_cgo_seq");
			
//		 }
		 formObj.spcl_cgo_apro_rqst_seq.value=sheetObj.GetCellValue( parseInt(Row) , "spcl_cgo_apro_rqst_seq");
		 //formObj.row.value=parseInt(row);

		 oSheetObj=openerObj.sheetObjects[0];
		 var chkFind = false;
		 //2016-08-17 CNTR 선택시 0014 와의 연동 수정
		 //for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.RowCount(); i++){
		 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){ 
			 var findStr = sheetObj.GetCellValue(parseInt(Row), "bkg_no") + 
			 			   formObj.vvd_cd.value +
			               sheetObj.GetCellValue(parseInt(Row), "dcgo_seq");
			 var oFindStr = oSheetObj.GetCellValue(i, "bkg_no") +
			                oSheetObj.GetCellValue(i, "vsl_cd") +
			                oSheetObj.GetCellValue(i, "skd_voy_no") +
			                oSheetObj.GetCellValue(i, "skd_dir_cd") +
			                oSheetObj.GetCellValue(i, "dcgo_seq");
			 if(findStr == oFindStr){
				 oSheetObj.SelectCell(i , oSheetObj.GetSelectCol());
				 formObj.row.value=parseInt(i);
				 chkFind = true;
				 break;
			 }
		 }
		 if(chkFind == false){
			 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
				 var findStr = sheetObj.GetCellValue(parseInt(Row), "bkg_no") +
				               formObj.vvd_cd.value +
	                           sheetObj.GetCellValue(parseInt(Row), "dcgo_seq");
				 var oFindStr = oSheetObj.GetCellValue(i, "bkg_no") + 
	                            oSheetObj.GetCellValue(i, "vsl_cd") +
	                            oSheetObj.GetCellValue(i, "skd_voy_no") +
	                            oSheetObj.GetCellValue(i, "skd_dir_cd") +
				                oSheetObj.GetCellValue(i, "dcgo_seq");
				 if(findStr == oFindStr){
					 oSheetObj.SelectCell(i , oSheetObj.GetSelectCol());
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
			 	comboObjects[1].SetEnable(0);
			 	document.getElementById("spcl_cgo_auth_rmk").disabled=true;
			 	document.getElementById("spcl_cgo_auth_rmk").className="input2";
		 }else{
			 if (formObj.scg_flg.value=="DG2") {
			    	document.getElementById("spcl_cgo_auth_cd").disabled=false;
			    	document.getElementById("spcl_cgo_auth_cd").className="input1";
			    	comboObjects[1].SetEnable(1);
			    	document.getElementById("spcl_cgo_auth_rmk").disabled=false;
			    	document.getElementById("spcl_cgo_auth_rmk").className="input";
			 }
		 }
		 //loadPage2();
		 
		 
		 for(var i=sheetObjects[3].HeaderRows(); i<=sheetObjects[3].LastRow(); i++){
			 
			 if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dcgo_seq") == sheetObjects[3].GetCellValue(i, "dcgo_seq")){
				 sheetObjects[3].SelectCell(i,"cntr_no");
				 break;
			 }
		 }
		 
		 cntrChk()
		 setAuthStat(sheetObj, Row);
    	 htmlSheetSync(Row);
    	 
     }
     
     
     function spcl_cgo_auth_rjct_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {	
  		var formObj=document.form;
		if (newCode == "AAA") {
 			document.getElementById("spcl_cgo_auth_rmk").className="input1";
//			formObj.spcl_cgo_auth_rmk_text.value='';
 			formObj.spcl_cgo_auth_rmk.value='';
		}else{
 			document.getElementById("spcl_cgo_auth_rmk").className="input";
//			formObj.spcl_cgo_auth_rmk_text.value=comboObj.GetText(newCode, 1);
 			formObj.spcl_cgo_auth_rmk.value=comboObj.GetText(newCode, 1);
		}
		
 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
 	 	sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);

 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rjct_cd", $("#spcl_cgo_auth_rjct_cd").val(), 0);
 	 	sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
 	 	
 	 	setAuthFontColor(sheetObjects[1], sheetObjects[1].GetSelectRow()); 

     }

     function spcl_cgo_auth_rmk_OnChange(){
    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
    	 sheetObjects[3].SetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rmk"	, $("#spcl_cgo_auth_rmk").val(), 0);
     }
     
     function sheet2_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 var formObj = document.form;
    	 var cntSeq=0;
//    	 sheetObjects[1].ColumnSort("dg_cntr_seq|cargo_seq","ASC");
    	 sheetObjects[1].ColumnSort("seq","ASC");
    	 
    	 var dgCnteSeq = "";
    	 var strHiddenRow= "";
    	 
    	 for(var i=sheetObjects[1].LastRow(); i>=1; i--){
    		 if(dgCnteSeq == sheetObjects[1].GetCellValue(i, "dg_cntr_seq") || sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == 'C'){
    			 strHiddenRow = strHiddenRow + i + "|";
    			 //sheetObjects[1].RowDelete(i,0);
    		 }else{
    			 dgCnteSeq = sheetObjects[1].GetCellValue(i, "dg_cntr_seq");
    		 }
    	 }
    	 sheetObjects[1].RowDelete(strHiddenRow,0);
    	 
    	 for(var i=1; i<=sheetObjects[0].LastRow(); i++){
    		 if(Number(sheetObjects[0].GetCellValue(i, "dcgo_qty")) < 1){
    			 for(var j=1; j<=sheetObjects[1].RowCount(); j++){
    				 if(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") == sheetObjects[1].GetCellValue(j, "cntr_tpsz_cd")){
    					 sheetObjects[1].SetCellValue(j, "cntr_vol_qty",Number(sheetObjects[0].GetCellValue(i, "dcgo_qty")),0);
    				 }
    			 }
    		 }
    	 }
    	 
    	 for(var i=1; i<=sheetObjects[1].LastRow(); i++){
    		 
    		 if(sheetObjects[1].GetCellValue(i, "spcl_cgo_apro_cd") == 'N' && formObj.type.value == 'O' ){
    			 //sheetObjects[1].RowDelete(i,0);
    		 }
//    		 if (sheetObjects[1].GetCellValue(i, "dg_cntr_seq") == document.getElementById("dg_cntr_seq").value) {
//    			 sheetObjects[1].SelectCell(i, "cntr_no", 0, "", 0);
//    		 }
    		 if(sheetObjects[1].GetCellValue(i, "rc_seq") != ""){
    			 sheetObjects[1].SetCellValue(i, "cargo_nm","RF",0);
    			 sheetObjects[1].SetCellValue(i, "cargo_seq",sheetObjects[1].GetCellValue(i, "rc_seq"),0);
    		 }else if(sheetObjects[1].GetCellValue(i, "awk_cgo_seq") != ""){
				sheetObjects[1].SetCellValue(i, "cargo_nm","AWK",0);
				sheetObjects[1].SetCellValue(i, "cargo_seq",sheetObjects[1].GetCellValue(i, "awk_cgo_seq"),0);
    		 }else{
    			 cntSeq++;
    		 }
    		 if(cntSeq == sheetObjects[1].RowCount()){
    			 sheetObjects[1].SetColHidden("cargo_nm",1);
    			 sheetObjects[1].SetColHidden("cargo_seq",1);
    		 }
//    		 var cntr_no=sheetObjects[1].GetCellValue(j, "cntr_no");
//    		 if(cntr_no != ""){
//    			 var find_row=sheetObjects[4].FindText("name", cntr_no, 0, 2);
//    			 sheetObjects[4].SetCellValue(find_row, "DelChk","1",0);
//    		 }
    		 
    	 }
    	 sheetObjects[1].ReNumberSeq();

//    	 for(var i=1; i<=sheetObj.RowCount(); i++){
//    		 if (sheetObj.GetCellValue(i, "dcgo_seq") == document.getElementById("dcgo_seq").value) {
//    			 sheetObj.SelectCell(i, "cntr_no", 0, "", 0);
//    			 break;
//    		 }
//    	 }
    	 
     }

     function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol,isDelete){
    	 oldRow = OldRow;
     }
     
  	//조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
 		with (sheetObj) {
 			
 			/* Image Storage 에 AK 항목에 해당 image 가 한건이라도 첨부 되어 있으면 버튼 색상 변경 추가 */
 			if(sheetObjects[2].RowCount() > 0){
 				if(sheetObjects[2].GetCellValue(1,"img_flg") =='Y'){
// 					document.getElementById('btn_attach').style.color = 'blue';
 					ComGetObject("btn_attach").style.setProperty("color", BTN_BLUE, "important");
 				}else{
// 					document.getElementById('btn_attach').style.color = '';
 					ComGetObject("btn_attach").style.setProperty("color", "", "");
 				}
 			}
 		}
 	}	

     function sheet4_OnSearchEnd(sheetObj, Row, Col, Value) {
    	 var formObject=document.form;
    	 
		 var opener = window.dialogArguments;
		 if (!opener) opener=window.opener;
		 if (!opener) opener = parent;

		 if (document.form.scg_flg.value=="DG2"){
			 oSheetObj=opener.t2sheet1;
		 } else{
			 oSheetObj=opener.t1sheet1;
		 }

		 var bkg_no     = "";
    	 var vsl_cd     = "";
    	 var skd_voy_no = "";
    	 var skd_dir_cd = "";
    	 var dcgo_seq = "";
    	 var preFix     = "";
    	 var chkFind    = false;
    	 
    	 var tmpSeq = "";
    	 var strHiddenRow= "";
    	 
    	 for(var iRow=sheetObj.LastRow(); iRow >= sheetObj.HeaderRows(); iRow--){
    		 if(sheetObj.GetCellValue(iRow, "spcl_cgo_apro_cd") == 'C' || sheetObj.GetCellValue(iRow, "rqst_dt") == ""){
    			 strHiddenRow = strHiddenRow + iRow + "|";
    			 //sheetObj.RowDelete(iRow,0);
    		 }
    	 }
    	 sheetObj.RowDelete(strHiddenRow,0);
    	 
    	 for(var iRow=sheetObj.HeaderRows(); iRow<=sheetObj.LastRow(); iRow++){
    		 
    		 bkg_no      = sheetObj.GetCellValue(iRow, "bkg_no");
		 	 vsl_cd      = document.getElementById("vvd_cd").value.substring(0,4);
		 	 skd_voy_no  = document.getElementById("vvd_cd").value.substring(4,8);
		 	 skd_dir_cd  = document.getElementById("vvd_cd").value.substring(8,9);
		 	 dcgo_seq = sheetObj.GetCellValue(iRow, "dcgo_seq");
			 chkFind = false;
			 
			 for(var i=sheetObjects[6].HeaderRows(); i<=sheetObjects[6].LastRow(); i++){
				 if(sheetObj.GetCellValue(iRow, preFix+"dcgo_seq") == sheetObjects[6].GetCellValue(i, preFix+"dcgo_seq")){
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",      sheetObjects[6].GetCellValue(i, preFix+"spcl_cgo_auth_cd"), 0);
		    		 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[6].GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     sheetObjects[6].GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
					 sheetObj.SetCellValue(iRow, "auth_usr_id",     	  sheetObjects[6].GetCellValue(i, preFix+"auth_usr_id"), 0);
					 sheetObj.SetCellValue(iRow, "auth_gdt",              sheetObjects[6].GetCellValue(i, preFix+"auth_gdt"), 0);
					 sheetObj.SetCellValue(iRow, "dcgo_seq",              sheetObjects[6].GetCellValue(i, preFix+"dcgo_seq"), 0);
					 
					 
					 break;
				 }
			 }
			 
			 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.LastRow(); i++){
				 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + dcgo_seq;
				 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
				            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
				            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
				            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") +
				            oSheetObj.GetCellValue(i, preFix+"dcgo_seq");
				 if(findStr == oFindStr){
					 var authCd = oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd");
					 if(authCd != "") {
		        		if(authCd.substring(0, 1) == 'S') {
		        			authCd = authCd.substring(1, 2); //SR
		        		} else {
		        			authCd = authCd.substring(0, 1);
		        		}
		        	 }
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      authCd, 0);
       				 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd"), 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
					 sheetObj.SetCellValue(iRow, "apro_ref_no",           oSheetObj.GetCellValue(i, preFix+"apro_ref_no"), 0);
		    		 if (sheetObj.GetCellText(iRow, "dcgo_seq") == document.getElementById("dcgo_seq").value) {
		    			 //sheetObj.SelectCell(iRow,"cntr_no");
		    			 //tmpSeq = sheetObj.GetCellValue(iRow, "dg_cntr_seq");
		    		 }
		    		 //setAuthStat(sheetObj, iRow);
		    		 chkFind = true;
					 break;
				 }
			 }
			 if(chkFind == false){
				 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
					 findStr = bkg_no + vsl_cd + skd_voy_no + skd_dir_cd + dcgo_seq;
					 oFindStr = oSheetObj.GetCellValue(i, preFix+"bkg_no") + 
					            oSheetObj.GetCellValue(i, preFix+"vsl_cd") + 
					            oSheetObj.GetCellValue(i, preFix+"skd_voy_no") +
					            oSheetObj.GetCellValue(i, preFix+"skd_dir_cd") + 
					 			oSheetObj.GetCellValue(i, preFix+"dcgo_seq"); 
					 if(findStr == oFindStr){
			    		 var authCd = oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd");
			        	 if(authCd != "") {
			        		if(authCd.substring(0, 1) == 'S') {
			        			authCd = authCd.substring(1, 2); //SR
			        		} else {
			        			authCd = authCd.substring(0, 1);
			        		}
			        	 }
						 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      authCd, 0);
	       				 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_cd"), 0);
						 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd"), 0);
						 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     oSheetObj.GetCellValue(i, preFix+"spcl_cgo_auth_rmk"), 0);
						 sheetObj.SetCellValue(iRow, "apro_ref_no",           oSheetObj.GetCellValue(i, preFix+"apro_ref_no"), 0);
			    		 if (sheetObj.GetCellText(iRow, "dcgo_seq") == document.getElementById("dcgo_seq").value) {
			    			 //sheetObj.SelectCell(iRow,"cntr_no");
			    			 //tmpSeq = sheetObj.GetCellValue(iRow, "dg_cntr_seq");
			    		 }
			    		// setAuthStat(sheetObj, iRow);
			    		 chkFind = true;
						 break;
					 }
				 }
			 }
			 
			 if (sheetObj.GetCellText(iRow, "dcgo_seq") == oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), preFix+"dcgo_seq")) {
				 sheetObj.SelectCell(iRow,"cntr_no");
				 setAuthStat(sheetObj, iRow);
				 tmpSeq = sheetObj.GetCellValue(iRow, "dg_cntr_seq");
			 }
			 

				 
    	 }

    	 var sheetObj = sheetObjects[1];
    	 
    	 for(var iRow=1; iRow<=sheetObj.LastRow(); iRow++){
    		 
    		 bkg_no      = sheetObj.GetCellValue(iRow, "bkg_no");
		 	 vsl_cd      = document.getElementById("vvd_cd").value.substring(0,4);
		 	 skd_voy_no  = document.getElementById("vvd_cd").value.substring(4,8);
		 	 skd_dir_cd  = document.getElementById("vvd_cd").value.substring(8,9);
		 	 dcgo_seq = sheetObj.GetCellValue(iRow, "dcgo_seq");
			 chkFind = false;
			 
			 for(var i=sheetObjects[3].HeaderRows(); i<=sheetObjects[3].LastRow(); i++){
				 if(sheetObj.GetCellValue(iRow, preFix+"dcgo_seq") == sheetObjects[3].GetCellValue(i, preFix+"dcgo_seq")){
					 sheetObj.SetCellValue(iRow, "apro_ref_no",           sheetObjects[3].GetCellValue(i, preFix+"apro_ref_no"), 0);
					 sheetObj.SetCellValue(iRow, "auth_gdt",              sheetObjects[3].GetCellValue(i, preFix+"auth_gdt"), 0);
					 sheetObj.SetCellValue(iRow, "auth_usr_id",           sheetObjects[3].GetCellValue(i, preFix+"auth_usr_id"), 0);
					 sheetObj.SetCellValue(iRow, "cntr_cgo_seq",          sheetObjects[3].GetCellValue(i, preFix+"cntr_cgo_seq") , 0); 
					 sheetObj.SetCellValue(iRow, "dcgo_seq",              sheetObjects[3].GetCellValue(i, preFix+"dcgo_seq") , 0); 
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      sheetObjects[3].GetCellValue(i, preFix+"spcl_cgo_apro_cd") , 0); 
					 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    sheetObjects[3].GetCellValue(i, preFix+"spcl_cgo_apro_text") , 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[3].GetCellValue(i, preFix+"spcl_cgo_auth_rjct_cd") , 0);
					 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     sheetObjects[3].GetCellValue(i, preFix+"spcl_cgo_auth_rmk") , 0);
					 //break;
				 }
			 }
			 if(tmpSeq == sheetObj.GetCellValue(iRow, "dg_cntr_seq")){
				 sheetObj.SetCellValue(iRow, "apro_ref_no",           sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"apro_ref_no"), 0);
				 sheetObj.SetCellValue(iRow, "auth_gdt",              sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"auth_gdt"), 0);
				 sheetObj.SetCellValue(iRow, "auth_usr_id",           sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"auth_usr_id"), 0);
				 sheetObj.SetCellValue(iRow, "cntr_cgo_seq",          sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"cntr_cgo_seq") , 0); 
				 sheetObj.SetCellValue(iRow, "dcgo_seq",              sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"dcgo_seq") , 0); 
				 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_cd",      sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_apro_cd") , 0); 
				 sheetObj.SetCellValue(iRow, "spcl_cgo_apro_text",    sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_apro_text") , 0);
				 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rjct_cd", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_auth_rjct_cd") , 0);
				 sheetObj.SetCellValue(iRow, "spcl_cgo_auth_rmk",     sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), preFix+"spcl_cgo_auth_rmk") , 0);
				 sheetObj.SelectCell(iRow,"cntr_no");
			 }
				 
			 setAuthFontColor(sheetObj, iRow);
			 
    	 }
    	 
    	 sheetObjects[1].ReNumberSeq();
   
     }
     
     function cntrChk(){
    	 Row=sheetObjects[1].GetSelectRow();
    	 var cnt=0;
     	 $("#cntr_cgo_seq").empty();
    	 for(var i=1; i<=sheetObjects[3].RowCount(); i++){
    		 if(sheetObjects[1].GetCellValue(Row, "cntr_no") != ""){
    			 if(sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no") && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") && sheetObjects[3].GetCellValue(i, "ibflag") != "D"){
    				 sheetObjects[3].SetCellValue(i, "CntrChk","1",0);
    			 }else if(sheetObjects[3].GetCellValue(i, "cntr_no") == "" && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") && sheetObjects[3].GetCellValue(i, "ibflag") != "D"){
        			 sheetObjects[3].SetCellValue(i, "CntrChk","1",0);
    			 }else{
    				 sheetObjects[3].SetCellValue(i, "CntrChk","0",0);
    			 }
    		 }else{
    			 if(sheetObjects[1].GetCellValue(Row, "cntr_no") == "" && sheetObjects[1].GetCellValue(Row, "cntr_no") == sheetObjects[3].GetCellValue(i, "cntr_no") && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == sheetObjects[1].GetCellValue(Row, "dg_cntr_seq") && sheetObjects[3].GetCellValue(i, "ibflag") != "D"){
    				 sheetObjects[3].SetCellValue(i, "CntrChk","1",0);
    			 }else{
    				 sheetObjects[3].SetCellValue(i, "CntrChk","0",0);
    			 }
    		 }
    		 if(sheetObjects[3].GetCellValue(i, "CntrChk") == "1"){
    			 var cntr_cgo_seq=sheetObjects[3].GetCellValue(i, "cntr_cgo_seq");
    			 cnt++;
    			 $("#cntr_cgo_seq").append("<option value='"+ cntr_cgo_seq +"'>"+ cnt +"</option>"); 
    		 }
    		 sheetObjects[3].SetCellValue(i, "bkg_cntr_seq",sheetObjects[3].GetCellValue(i, "dg_cntr_seq")+sheetObjects[3].GetCellValue(i, "cntr_cgo_seq"),0);
    	 }
    	 //$("#cntr_cgo_seq").val(document.getElementById("cntr_cgo_seq1").value);
    	 $("#cntr_cgo_seq").val(sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "cntr_cgo_seq"));
    	 document.getElementById("cntr_cgo_seq_sum").value=cnt;	
//    	 alert(cnt);

     }
     
     function htmlSheetSync(Row){
    	 //Row=sheetObjects[1].GetSelectRow();

    	 document.getElementById("dg_cntr_seq").value = sheetObjects[1].GetCellValue(Row, "dg_cntr_seq");
    	 
    	 var bkg_cntr_seq = document.getElementById("dg_cntr_seq").value + document.getElementById("cntr_cgo_seq").value;
    	 var find_row = sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 0);
//    	 alert("find_row="+find_row)
    	 
//    	 var bkg_dcgo_seq = document.getElementById("dcgo_seq").value
//    	 var find_row = sheetObjects[3].FindText("dcgo_seq", bkg_dcgo_seq, 0, 0);
    	 
// 		if(find_row > 0){	//@@2014-09-02.HDS. sheetObjects[3] 데이타 없으면 find_row가 -1이되고 값도 -1이 셋팅되기에 셋팅로직이 안도는것이 맞다고 판단되서 수정함
 			//sheetObjects[1].SelectCell(parseInt(find_row), 1);
				 
	    	 if (sheetObjects[3].GetCellValue(find_row, "imdg_clss_cd") == "7") {
	    		 tabObjects[0].selectedIndex=1;
	    	 }
	    	 document.getElementById("dcgo_ref_no").value=sheetObjects[3].GetCellValue(find_row, "dcgo_ref_no"); //oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), "dcgo_ref_no");
			 document.getElementById("cntr_no").value=sheetObjects[3].GetCellValue(find_row, "cntr_no");
			 document.getElementById("cntr_tpsz_cd").value=sheetObjects[1].GetCellValue(Row, "cntr_tpsz_cd");
			 document.getElementById("cntr_cgo_seq").value=sheetObjects[3].GetCellValue(find_row, "cntr_cgo_seq");
			 document.getElementById("imdg_clss_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_clss_cd");
			 document.getElementById("imdg_comp_grp_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_comp_grp_cd");
			 document.getElementById("imdg_un_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no");
	    	 document.getElementById("grs_wgt").value=sheetObjects[3].GetCellText(find_row, "grs_wgt");
	    	 document.getElementById("net_wgt").value=sheetObjects[3].GetCellText(find_row, "net_wgt");
	    	 document.getElementById("temp_grs_wgt").value=sheetObjects[3].GetCellText(Row, "grs_wgt");
	    	 document.getElementById("temp_net_wgt").value=sheetObjects[3].GetCellText(Row, "net_wgt");
			 document.getElementById("prp_shp_nm").value=sheetObjects[3].GetCellValue(find_row, "prp_shp_nm");
			 document.getElementById("hzd_desc").value=sheetObjects[3].GetCellValue(find_row, "hzd_desc");
			 document.getElementById("flsh_pnt_cdo_temp").value=sheetObjects[3].GetCellValue(find_row, "flsh_pnt_cdo_temp");
			 
			 //:2016-01-27:by TOP://
			 imdg_segr_grp_no.SetSelectCode(sheetObjects[3].GetCellValue(find_row, "imdg_segr_grp_no"));
			 
			 if (sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd") == "1") {
	    		 document.getElementById("imdg_pck_grp_cd").value="I";
			 }else if (sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd") == "2") {
	    		 document.getElementById("imdg_pck_grp_cd").value="II";
			 }else if (sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd") == "3") {
	    		 document.getElementById("imdg_pck_grp_cd").value="III";    		 
	    	 }else{
	    		 document.getElementById("imdg_pck_grp_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_pck_grp_cd");
	    	 }
			 document.getElementById("psa_no").value=sheetObjects[3].GetCellValue(find_row, "psa_no");
			 document.getElementById("imdg_lmt_qty_flg").value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_flg");
			 document.getElementById("imdg_expt_qty_flg").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_flg");
			 if(sheetObjects[3].GetCellValue(find_row, "hcdg_flg") == "Y"){
	    		 document.getElementById("hcdg_flag").value="HCDG";
	    	 }else{
	    		 document.getElementById("hcdg_flag").value="";
	    	 }
			document.getElementById("imdg_subs_rsk_lbl_cd1").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd1");
			document.getElementById("imdg_subs_rsk_lbl_cd2").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd2");
			document.getElementById("imdg_subs_rsk_lbl_cd3").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd3");
			document.getElementById("imdg_subs_rsk_lbl_cd4").value=sheetObjects[3].GetCellValue(find_row, "imdg_subs_rsk_lbl_cd4");
			document.getElementById("dcgo_sts_cd").value=sheetObjects[3].GetCellValue(find_row, "dcgo_sts_cd");
			document.getElementById("mrn_polut_flg").value=sheetObjects[3].GetCellValue(find_row, "mrn_polut_flg");
			document.getElementById("emer_cntc_phn_no_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_phn_no_ctnt");
			document.getElementById("emer_cntc_pson_nm").value=sheetObjects[3].GetCellValue(find_row, "emer_cntc_pson_nm");
			document.getElementById("certi_no").value=sheetObjects[3].GetCellValue(find_row, "certi_no");
			document.getElementById("cnee_dtl_desc").value=sheetObjects[3].GetCellValue(find_row, "cnee_dtl_desc");
			document.getElementById("net_explo_wgt").value=sheetObjects[3].GetCellValue(find_row, "net_explo_wgt");
			document.getElementById("rada_skd_no").value=sheetObjects[3].GetCellValue(find_row, "rada_skd_no");
			document.getElementById("rada_amt").value=sheetObjects[3].GetCellValue(find_row, "rada_amt");
			document.getElementById("rada_ut_cd").value=sheetObjects[3].GetCellValue(find_row, "rada_ut_cd");
			document.getElementById("rada_trsp_no").value=sheetObjects[3].GetCellValue(find_row, "rada_trsp_no");
			document.getElementById("temp_cntr_no").value=sheetObjects[3].GetCellValue(find_row, "cntr_no");
			document.getElementById("diff_rmk").value=sheetObjects[3].GetCellValue(find_row, "diff_rmk");
			document.getElementById("in_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd1");
			document.getElementById("in_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd2");
			document.getElementById("in_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty1");
			document.getElementById("in_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty2");
			document.getElementById("in_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc1");
			document.getElementById("in_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_desc2");
			document.getElementById("out_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd1");
			document.getElementById("out_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd2");
			document.getElementById("out_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty1");
			document.getElementById("out_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty2");
			document.getElementById("out_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc1");
			document.getElementById("out_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_desc2");
			document.getElementById("intmd_imdg_pck_cd1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd1");
			document.getElementById("intmd_imdg_pck_cd2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_cd2");
			document.getElementById("intmd_imdg_pck_qty1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty1");
			document.getElementById("intmd_imdg_pck_qty2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_qty2");
			document.getElementById("intmd_imdg_pck_desc1").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc1");
			document.getElementById("intmd_imdg_pck_desc2").value=sheetObjects[3].GetCellValue(find_row, "intmd_imdg_pck_desc2");
			document.getElementById("max_in_pck_qty").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_qty");
			document.getElementById("max_in_pck_tp_cd").value=sheetObjects[3].GetCellValue(find_row, "max_in_pck_tp_cd");
			document.getElementById("hcdg_intmd_bc_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_intmd_bc_rstr_desc");
			document.getElementById("hcdg_pck_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_pck_rstr_desc");
			document.getElementById("hcdg_tnk_rstr_desc").value=sheetObjects[3].GetCellValue(find_row, "hcdg_tnk_rstr_desc");
			
			document.getElementById("imdg_expt_qty_cd").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_cd");
			document.getElementById("imdg_expt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_expt_qty_desc");
			document.getElementById("ltd_qty").value=sheetObjects[3].GetCellValue(find_row, "ltd_qty");
			document.getElementById("imdg_lmt_qty_desc").value=sheetObjects[3].GetCellValue(find_row, "imdg_lmt_qty_desc");
						
			document.getElementById("ems_no").value=sheetObjects[3].GetCellValue(find_row, "ems_no");
			document.getElementById("emer_rspn_gid_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_no");
			document.getElementById("emer_rspn_gid_chr_no").value=sheetObjects[3].GetCellValue(find_row, "emer_rspn_gid_chr_no");
			document.getElementById("ctrl_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "ctrl_temp_ctnt");
			document.getElementById("emer_temp_ctnt").value=sheetObjects[3].GetCellValue(find_row, "emer_temp_ctnt");
			document.getElementById("clod_flg").value=sheetObjects[3].GetCellValue(find_row, "clod_flg");
			document.getElementById("rc_flg").value=sheetObjects[3].GetCellValue(find_row, "rc_flg");
			document.getElementById("awk_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "awk_cgo_flg");
			document.getElementById("bb_cgo_flg").value=sheetObjects[3].GetCellValue(find_row, "bb_cgo_flg");
			document.getElementById("meas_qty").value=sheetObjects[3].GetCellValue(find_row, "meas_qty");
			document.getElementById("hcdg_dpnd_qty_flg").value=sheetObjects[3].GetCellValue(find_row, "hcdg_dpnd_qty_flg");
			document.getElementById("spcl_rqst_flg").value=sheetObjects[3].GetCellValue(find_row, "spcl_rqst_flg");
			document.getElementById("imdg_un_no_seq").value=sheetObjects[3].GetCellValue(find_row, "imdg_un_no_seq");
			document.getElementById("imdg_amdt_no").value=sheetObjects[3].GetCellValue(find_row, "imdg_amdt_no");
			document.getElementById("vsl_cd").innerHTML=sheetObjects[2].GetCellValue(1, "vsl_cd");
			
			// ::DG RailBilling 2015-12-02 ::	
			
			document.getElementById("erap_no").value=sheetObjects[3].GetCellValue(find_row, "erap_no");
			document.getElementById("erap_cntc_no").value=sheetObjects[3].GetCellValue(find_row, "erap_cntc_no");
			document.getElementById("erap_apro_ref_no").value=sheetObjects[3].GetCellValue(find_row, "erap_apro_ref_no");
			document.getElementById("dot_exp_no").value=sheetObjects[3].GetCellValue(find_row, "dot_exp_no");
			document.getElementById("dot_spcl_apro_no").value=sheetObjects[3].GetCellValue(find_row, "dot_spcl_apro_no");
			document.getElementById("dot_auth_no").value=sheetObjects[3].GetCellValue(find_row, "dot_auth_no");
			// ::DG RailBilling 2015-12-02 ::
			setProviNo(sheetObjects[3].GetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt"));
		
			document.getElementById("cfr_flg").value=sheetObjects[3].GetCellValue(find_row, "cfr_flg");
			//::RSD FLG 2016-09-21 ::
			document.getElementById("rsd_flg").value=sheetObjects[3].GetCellValue(find_row, "rsd_flg");
			
	   		var cfr_flg = sheetObjects[3].GetCellValue(find_row, "cfr_flg");
	   		if(cfr_flg == "Y"){
				document.getElementById("cfr_flg").checked=true;
			}else{ // F
				document.getElementById("cfr_flg").checked=false;
			}
	   		
	   		var formObj=document.form;
	   		formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0015GS.do", FormQueryString(formObj));
			var segrGrpDtlList=ComGetEtcData(sXml, "segrGrpDtlList").split("|");
			for(var i=1 ; i < segrGrpDtlList.length+1 ; i++ ) {
				document.getElementById("frm_hcdg_tnk_rstr_desc"+i).value = segrGrpDtlList[i-1]
			}

			
			//Update Item color
			if(formObj.scg_flg.value=="DG2"){
				var chkNew = "N";
		 		var tmpRow= "";
		 		var tmpRow2= "";
				var chkData = ["imdg_clss_cd"
				               ,"imdg_un_no"
				               ,"imdg_un_no_seq"
				               ,"prp_shp_nm"
				               ,"hzd_desc"
				               ,"grs_wgt"
				               ,"net_wgt"
				               ,"imdg_pck_grp_cd"
				               ,"psa_no"
				               ,"flsh_pnt_cdo_temp"
				               ,"ems_no"
				               ,"mrn_polut_flg"
				               ,"emer_cntc_phn_no_ctnt"
				               ,"emer_cntc_pson_nm"
				               ,"certi_no"
				               ,"net_explo_wgt"
					           ,"out_imdg_pck_qty1"
	 				           ,"out_imdg_pck_cd1"
	 				           ,"out_imdg_pck_qty2"
	 				           ,"out_imdg_pck_cd2"
	 				           ,"in_imdg_pck_qty1"
	 				           ,"in_imdg_pck_cd1"
	 				           ,"in_imdg_pck_qty2"
	 				           ,"in_imdg_pck_cd2"
				               ];
				var chkData2 = ["out_imdg_pck_qty1"
	 				           ,"out_imdg_pck_cd1"
	 				           ,"out_imdg_pck_qty2"
	 				           ,"out_imdg_pck_cd2"
	 				           ,"in_imdg_pck_qty1"
	 				           ,"in_imdg_pck_cd1"
	 				           ,"in_imdg_pck_qty2"
	 				           ,"in_imdg_pck_cd2"
				               ];			
				var tmpSeq = "";
			   	for(var i=1; i<=sheetObjects[3].RowCount(); i++){
			   		if (sheetObjects[3].GetCellValue(i, "cntr_cgo_seq") == formObj.cntr_cgo_seq.value && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == formObj.dg_cntr_seq.value ) {
			   			tmpSeq = sheetObjects[3].GetCellValue(i, "dcgo_seq");
			   			tmpRow = i;
			   			break;
					}
				}
			   	for(var i=1; i<=sheetObjects[5].RowCount(); i++){
			   		if (sheetObjects[5].GetCellValue(i, "dcgo_seq") == tmpSeq){
			   			chkNew = "U";
			   			tmpRow2 = i;
			   			break;
					}
				}
			   	if(sheetObjects[5].RowCount() == 0){
			   		chkNew = "";
			   	}
			   	if(chkNew == "N"){
					for(var i = 0; i < chkData.length; i++){
						$("#"+chkData[i]).css("color", "blue");	
					}
					$("#btn_PackageQtyType").attr("style", "color:blue!important");
					$("#btn_OtherEmergencyInformation").attr("style", "color:blue!important");
					$("#cntr_cgo_seq").css("color", "blue");
			   	}else if(chkNew == "U"){
			   		var updChk="";
			   		for(var i = 0; i < chkData.length; i++){
			   			if(sheetObjects[3].GetCellValue(tmpRow, chkData[i]) == sheetObjects[5].GetCellValue(tmpRow2, chkData[i])){
							$("#"+chkData[i]).css("color", "black");	
							$("#"+chkData[i]+ " option").css("color", "black");
			   			}else{
			   				updChk = "Y";
							$("#"+chkData[i]).css("color", "red");	
							$("#"+chkData[i]+ " option").css("color", "red");
			   			}
			   		}
			   		for(var i = 0; i < chkData2.length; i++){
			   			if(sheetObjects[3].GetCellValue(tmpRow, chkData[i]) == sheetObjects[5].GetCellValue(tmpRow2, chkData[i])){
							$("#btn_PackageQtyType").attr("style", "color:black!important");
			   			}else{
			   				updChk = "Y";
							$("#btn_PackageQtyType").attr("style", "color:red!important");
			   			}
			   		}
					if(sheetObjects[3].GetCellValue(tmpRow, "ems_no") == sheetObjects[5].GetCellValue(tmpRow2, "ems_no")){
						$("#btn_OtherEmergencyInformation").attr("style", "color:black!important");
					}else{
						updChk = "Y";
						$("#btn_OtherEmergencyInformation").attr("style", "color:red!important");
					}
					if(updChk == "Y"){
						$("#cntr_cgo_seq").css("color", "red");
					}else{
						$("#cntr_cgo_seq").css("color", "black");
					}
			   	}else{
					for(var i = 0; i < chkData.length; i++){
						$("#"+chkData[i]).css("color", "black");	
					}
					$("#btn_PackageQtyType").attr("style", "color:black!important");
					$("#btn_OtherEmergencyInformation").attr("style", "color:black!important");
					$("#cntr_cgo_seq").css("color", "black");
			   	}
			}

		   	
//			//update & new Item Check 
//			if($("#itm_sts_cd").val() == "N" ||  $("#itm_sts_cd").val() == "U"){
//				/** updated item color **/
//				var chkData = ["imdg_clss_cd"
//				               ,"imdg_un_no"
//				               ,"imdg_un_no_seq"
//				               ,"prp_shp_nm"
//				               ,"hzd_desc"
//				               ,"grs_wgt"
//				               ,"net_wgt"
//				               ,"imdg_pck_grp_cd"
//				               ,"psa_no"
//				               ,"flsh_pnt_cdo_temp"
//				               ,"ems_no"
//				               ,"mrn_polut_flg"
//				               ,"emer_cntc_phn_no_ctnt"
//				               ,"emer_cntc_pson_nm"
//				               ,"certi_no"
//				               ,"net_explo_wgt"];
//				
//				
//				var chkDcgoSeq = sheetObjects[1].GetCellValue(Row, "dcgo_seq");
//				for(var i = 0; i < chkData.length; i++){
//					
//					if($("#itm_sts_cd").val() == "N"){
//						$("#"+chkData[i]).css("color", "blue");
//						$("#"+chkData[i]+ " option").css("color", "blue");
//						
//					}else{
//						if(sheetObjects[3].GetCellValue(find_row, chkData[i]) == sheetObjects[5].GetCellValue(find_row, chkData[i])){
//							$("#"+chkData[i]).css("color", "black");	
//							$("#"+chkData[i]+ " option").css("color", "black");
//						}else{
//							$("#"+chkData[i]).css("color", "red");
//							$("#"+chkData[i]+ " option").css("color", "red");
//						}					
//						
//					}
//				}
//				
//				var imdgPck1 = sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty1") +
//					sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd1") +
//					sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_qty2") +
//					sheetObjects[3].GetCellValue(find_row, "out_imdg_pck_cd2") +
//					sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty1") +
//					sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd1") +
//					sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_qty2") +
//					sheetObjects[3].GetCellValue(find_row, "in_imdg_pck_cd2");
//				
//				var imdgPck2 = sheetObjects[5].GetCellValue(find_row, "out_imdg_pck_qty1") +
//					sheetObjects[5].GetCellValue(find_row, "out_imdg_pck_cd1") +
//					sheetObjects[5].GetCellValue(find_row, "out_imdg_pck_qty2") +
//					sheetObjects[5].GetCellValue(find_row, "out_imdg_pck_cd2") +
//					sheetObjects[5].GetCellValue(find_row, "in_imdg_pck_qty1") +
//					sheetObjects[5].GetCellValue(find_row, "in_imdg_pck_cd1") +
//					sheetObjects[5].GetCellValue(find_row, "in_imdg_pck_qty2") +
//					sheetObjects[5].GetCellValue(find_row, "in_imdg_pck_cd2");
//				
//				if(imdgPck1 == imdgPck2 ){
//					document.getElementById("btn_PackageQtyType").setAttribute("style", "color:black!important");
//				}else{
//					//document.getElementById("btn_PackageQtyType").setAttribute("style", "color:red!important");
//					$("#btn_PackageQtyType").attr("style", "color:red!important");
//				}
//		
//				if(sheetObjects[3].GetCellValue(find_row, "ems_no") == sheetObjects[5].GetCellValue(find_row, "ems_no")){
//					document.getElementById("btn_OtherEmergencyInformation").setAttribute("style", "color:black!important");
//				}else{
//					document.getElementById("btn_OtherEmergencyInformation").setAttribute("style", "color:red!important");
//				}
//				
//				var cargoSeq = 0;
//				for (var j=1; j<=sheetObjects[3].RowCount(); j++){
//		    		 if(sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow() , "dg_cntr_seq") == sheetObjects[3].GetCellValue(j, "dg_cntr_seq")){
//		    			 cargoSeq++;
//		    			 if(sheetObjects[3].GetCellValue(j, "cntr_cgo_seq") == sheetObjects[5].GetCellValue(j, "cntr_cgo_seq")){
//		        			 
//		     				var chkData = ["imdg_clss_cd"
//		     				               ,"imdg_un_no"
//		     				               ,"imdg_un_no_seq"
//		     				               ,"prp_shp_nm"
//		     				               ,"hzd_desc"
//		     				               ,"grs_wgt"
//		     				               ,"net_wgt"
//		     				               ,"imdg_pck_grp_cd"
//		     				               ,"psa_no"
//		     				               ,"flsh_pnt_cdo_temp"
//		     				               ,"ems_no"
//		     				               ,"mrn_polut_flg"
//		     				               ,"emer_cntc_phn_no_ctnt"
//		     				               ,"emer_cntc_pson_nm"
//		     				               ,"certi_no"
//		     				               ,"net_explo_wgt"
//		     				               , "out_imdg_pck_qty1"
//		     				               , "out_imdg_pck_cd1"
//		     				               , "out_imdg_pck_qty2"
//		     				               , "out_imdg_pck_cd2"
//		     				               , "in_imdg_pck_qty1"
//		     				               , "in_imdg_pck_cd1"
//		     				               , "in_imdg_pck_qty2"
//		     				               , "in_imdg_pck_cd2"
//		     				               ];
//		     				var updateYn = "";
//		     				for(var i = 0; i < chkData.length; i++){
//		     					if(sheetObjects[3].GetCellValue(j, chkData[i]) != sheetObjects[5].GetCellValue(j, chkData[i])){
//		     						updateYn = "Y";
//		     						break;
//		     					}
//		     				}
//		     				if(updateYn == "Y"){
//		     					$("#cntr_cgo_seq option:eq("+ parseInt(cargoSeq-1) +")").css("color", "red");
//		     				}
//		     				else{
//		     					$("#cntr_cgo_seq option:eq("+ parseInt(cargoSeq-1) +")").css("color", "black");
//		     				}
//		     				
//			     		 }else{
//			     			$("#cntr_cgo_seq option:eq("+ parseInt(cargoSeq-1) +")").css("color", "red");
//			     		 }
//		    		 }
//		    	 }    
//				document.getElementById("cntr_cgo_seq").style.color=document.getElementById("cntr_cgo_seq").options[document.getElementById("cntr_cgo_seq").selectedIndex].style.color;
//				
//				document.getElementById("mrn_polut_flg").style.color=document.getElementById("mrn_polut_flg").options[document.getElementById("mrn_polut_flg").selectedIndex].style.color;
//				
//				
//				/** updated item color **/
//			}else{
//				// color reset
//				var chkData = ["imdg_clss_cd"
//				               ,"imdg_un_no"
//				               ,"imdg_un_no_seq"
//				               ,"prp_shp_nm"
//				               ,"hzd_desc"
//				               ,"grs_wgt"
//				               ,"net_wgt"
//				               ,"imdg_pck_grp_cd"
//				               ,"psa_no"
//				               ,"flsh_pnt_cdo_temp"
//				               ,"ems_no"
//				               ,"mrn_polut_flg"
//				               ,"emer_cntc_phn_no_ctnt"
//				               ,"emer_cntc_pson_nm"
//				               ,"certi_no"
//				               ,"net_explo_wgt"];
//				
//				for(var i = 0; i < chkData.length; i++){
//					$("#"+chkData[i]).css("color", "black");	
//				}
//				document.getElementById("btn_PackageQtyType").setAttribute("style", "color:black!important");
//				document.getElementById("btn_OtherEmergencyInformation").setAttribute("style", "color:black!important");
//				$("#cntr_cgo_seq").css("color", "black");
//			}
     }
     /**
      * Clicking popup in IBSheet Object
      */
     function onPopupClick(srcName){
    	 var formObj=document.form;
    	 var row=formObj.row.value;
		 var sParam=""; 
		 var oSheetObj="";
		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }
		 
		 //var row=oSheetObj.GetSelectRow();
		 
		 if (srcName == "btn_RouteDetail") {
			 sParam = "&bkg_no="+ComGetObjValue(formObj.bkg_no);
    		 //ComOpenPopup("ESM_BKG_1069.do?"+sParam, 706, 440, "ESM_BKG_1069", "0,0,1,1,1,1,1", true);   
    		 ComOpenPopup("ESM_BKG_1069.do?" + sParam, 800, 400, "", "1,0,1,1,1", true);
    	 }else if (srcName == "btn_UnInformation") {
    		 sParam="pop_mode=Y";
    		 sParam += "&cfr_flg="+ComGetObjValue(formObj.cfr_flg);
    		 sParam += "&imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
    		 sParam += "&imdg_un_no_seq="+ComGetObjValue(formObj.imdg_un_no_seq);
    		 ComOpenPopup("VOP_SCG_0001Pop.do?pgmNo=VOP_SCG_0001&"+sParam, 1060, 650, "VOP_SCG_0001", "0,0,1,1,1,1,1", true);   		 
    	 }else if (srcName == "btn_Restrictions") {
    		 sParam="imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
    		 sParam += "&imdg_un_no_seq="+ComGetObjValue(formObj.imdg_un_no_seq);
    		 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
    		 sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
    		 sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
    		 sParam += "&slan_cd=";
    		 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
    		 sParam += "&vsl_cd="+ComGetObjValue(formObj.vvd_cd).substring(0,4);
    		 sParam += "&skd_voy_no="+ComGetObjValue(formObj.vvd_cd).substring(4,8);
    		 sParam += "&skd_dir_cd="+ComGetObjValue(formObj.vvd_cd).substring(8,9);
//    		 ComOpenPopup("VOP_SCG_0021.do?"+sParam, 1150, 660, "VOP_SCG_0021", "0,0,1,1,1,1,1", false);
    		 ComOpenWindowCenter("VOP_SCG_0021.do?"+sParam, "VOP_SCG_0021", 1150, 660, true);
    	 }else if (srcName == "btn_Pre-CheckingReport") {
    		   
			 var url="VOP_SCG_0069.do?func=VOP_SCG_0069&pop_type=SR";
			 ComOpenWindowCenter(url, "VOP_SCG_0069", 940, 668, true);	
//    		 ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 990, "VOP_SCG_0069", "0,0,1,1,1,1,1", false);
    	 }else if (srcName == "btn_PackageQtyType") {
				var in_imdg_pck_cd1=document.getElementById("in_imdg_pck_cd1").value;
				var in_imdg_pck_cd2=document.getElementById("in_imdg_pck_cd2").value;
				var intmd_imdg_pck_cd1=document.getElementById("intmd_imdg_pck_cd1").value;
				var intmd_imdg_pck_cd2=document.getElementById("intmd_imdg_pck_cd2").value;
				var out_imdg_pck_cd1=document.getElementById("out_imdg_pck_cd1").value;
				var out_imdg_pck_cd2=document.getElementById("out_imdg_pck_cd2").value;
				var in_imdg_pck_desc1=document.getElementById("in_imdg_pck_desc1").value;
				var in_imdg_pck_desc2=document.getElementById("in_imdg_pck_desc2").value;
				var intmd_imdg_pck_desc1=document.getElementById("intmd_imdg_pck_desc1").value;
				var intmd_imdg_pck_desc2=document.getElementById("intmd_imdg_pck_desc2").value;
				var out_imdg_pck_desc1=document.getElementById("out_imdg_pck_desc1").value;
				var out_imdg_pck_desc2=document.getElementById("out_imdg_pck_desc2").value;
				var in_imdg_pck_qty1=document.getElementById("in_imdg_pck_qty1").value;
				var in_imdg_pck_qty2=document.getElementById("in_imdg_pck_qty2").value;
				var intmd_imdg_pck_qty1=document.getElementById("intmd_imdg_pck_qty1").value;
				var intmd_imdg_pck_qty2=document.getElementById("intmd_imdg_pck_qty2").value;
				var out_imdg_pck_qty1=document.getElementById("out_imdg_pck_qty1").value;
				var out_imdg_pck_qty2=document.getElementById("out_imdg_pck_qty2").value;
				var hcdg_intmd_bc_rstr_desc=document.getElementById("hcdg_intmd_bc_rstr_desc").value;
				var hcdg_pck_rstr_desc=document.getElementById("hcdg_pck_rstr_desc").value;
				var hcdg_tnk_rstr_desc=document.getElementById("hcdg_tnk_rstr_desc").value;
				
				var ltd_qty=document.getElementById("ltd_qty").value;
				var imdg_lmt_qty_desc=document.getElementById("imdg_lmt_qty_desc").value;
				var imdg_expt_qty_cd=document.getElementById("imdg_expt_qty_cd").value;
				var imdg_expt_qty_desc=document.getElementById("imdg_expt_qty_desc").value;
				ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1=" + in_imdg_pck_cd1 + "&in_imdg_pck_cd2=" + in_imdg_pck_cd2 + "&intmd_imdg_pck_cd1=" + intmd_imdg_pck_cd1 + "&intmd_imdg_pck_cd2=" + intmd_imdg_pck_cd2 + "&out_imdg_pck_cd1=" + out_imdg_pck_cd1 + "&out_imdg_pck_cd2=" + out_imdg_pck_cd2 + "&in_imdg_pck_desc1=" + in_imdg_pck_desc1 + "&in_imdg_pck_desc2=" + in_imdg_pck_desc2
						+ "&intmd_imdg_pck_desc1=" + intmd_imdg_pck_desc1 + "&intmd_imdg_pck_desc2=" + intmd_imdg_pck_desc2 + "&out_imdg_pck_desc1=" + out_imdg_pck_desc1 + "&out_imdg_pck_desc2=" + out_imdg_pck_desc2 + "&in_imdg_pck_qty1=" + in_imdg_pck_qty1 + "&in_imdg_pck_qty2=" + in_imdg_pck_qty2 + "&intmd_imdg_pck_qty1=" + intmd_imdg_pck_qty1 + "&intmd_imdg_pck_qty2=" + intmd_imdg_pck_qty2
						+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 + "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 + "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc + "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc + "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc + "&ltd_qty=" + ltd_qty  + "&imdg_lmt_qty_desc=" + imdg_lmt_qty_desc + "&imdg_expt_qty_cd=" + imdg_expt_qty_cd + "&imdg_expt_qty_desc=" + imdg_expt_qty_desc, 710, 600, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
						"ESM_BKG_0206");
				
				
//    		 var in_imdg_pck_cd1=document.getElementById("in_imdg_pck_cd1").value; 
//    		 var in_imdg_pck_cd2=document.getElementById("in_imdg_pck_cd2").value; 
//    		 var intmd_imdg_pck_cd1=document.getElementById("intmd_imdg_pck_cd1").value; 
//    		 var intmd_imdg_pck_cd2=document.getElementById("intmd_imdg_pck_cd2").value; 
//    		 var out_imdg_pck_cd1=document.getElementById("out_imdg_pck_cd1").value; 
//    		 var out_imdg_pck_cd2=document.getElementById("out_imdg_pck_cd2").value; 
//    		 var in_imdg_pck_desc1=document.getElementById("in_imdg_pck_desc1").value; 
//    		 var in_imdg_pck_desc2=document.getElementById("in_imdg_pck_desc2").value; 
//    		 var intmd_imdg_pck_desc1=document.getElementById("intmd_imdg_pck_desc1").value; 
//    		 var intmd_imdg_pck_desc2=document.getElementById("intmd_imdg_pck_desc2").value; 
//    		 var out_imdg_pck_desc1=document.getElementById("out_imdg_pck_desc1").value; 
//    		 var out_imdg_pck_desc2=document.getElementById("out_imdg_pck_desc2").value; 
//    		 var in_imdg_pck_qty1=document.getElementById("in_imdg_pck_qty1").value; 
//    		 var in_imdg_pck_qty2=document.getElementById("in_imdg_pck_qty2").value;	
//    		 var intmd_imdg_pck_qty1=document.getElementById("intmd_imdg_pck_qty1").value; 
//    		 var intmd_imdg_pck_qty2=document.getElementById("intmd_imdg_pck_qty2").value;
//    		 var out_imdg_pck_qty1=document.getElementById("out_imdg_pck_qty1").value; 
//    		 var out_imdg_pck_qty2=document.getElementById("out_imdg_pck_qty2").value;  								
//    		 var hcdg_intmd_bc_rstr_desc=document.getElementById("hcdg_intmd_bc_rstr_desc").value;  
//    		 var hcdg_pck_rstr_desc=document.getElementById("hcdg_pck_rstr_desc").value;  
//    		 var hcdg_tnk_rstr_desc=document.getElementById("hcdg_tnk_rstr_desc").value;  
//    		 var ltd_qty=document.getElementById("ltd_qty").value; 
//    		 var imdg_expt_qty_cd=document.getElementById("imdg_expt_qty_cd").value; 	 								
////    		 ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1="+in_imdg_pck_cd1+"&in_imdg_pck_cd2="+in_imdg_pck_cd2+"&intmd_imdg_pck_cd1="+intmd_imdg_pck_cd1+"&intmd_imdg_pck_cd2="+intmd_imdg_pck_cd2+"&out_imdg_pck_cd1="+out_imdg_pck_cd1+"&out_imdg_pck_cd2="+out_imdg_pck_cd2+"&in_imdg_pck_desc1="+in_imdg_pck_desc1+"&in_imdg_pck_desc2="+in_imdg_pck_desc2+"&intmd_imdg_pck_desc1="+intmd_imdg_pck_desc1+"&intmd_imdg_pck_desc2="+intmd_imdg_pck_desc2+"&out_imdg_pck_desc1="+out_imdg_pck_desc1+"&out_imdg_pck_desc2="+out_imdg_pck_desc2+"&in_imdg_pck_qty1="+in_imdg_pck_qty1+"&in_imdg_pck_qty2="+in_imdg_pck_qty2+"&intmd_imdg_pck_qty1="+intmd_imdg_pck_qty1+"&intmd_imdg_pck_qty2="+intmd_imdg_pck_qty2+"&out_imdg_pck_qty1="+out_imdg_pck_qty1+"&out_imdg_pck_qty2="+out_imdg_pck_qty2+"&hcdg_intmd_bc_rstr_desc="+hcdg_intmd_bc_rstr_desc+"&hcdg_pck_rstr_desc="+hcdg_pck_rstr_desc+"&hcdg_tnk_rstr_desc="+hcdg_tnk_rstr_desc+"&ltd_qty="+ltd_qty+"&imdg_expt_qty_cd="+imdg_expt_qty_cd, 710, 600, "ESM_BKG_0206", '0,0,1,1,1,1,1', true);
//    		 
//			 ComOpenPopup("ESM_BKG_0206.do?in_imdg_pck_cd1=" + in_imdg_pck_cd1 + "&in_imdg_pck_cd2=" + in_imdg_pck_cd2 + "&intmd_imdg_pck_cd1=" + intmd_imdg_pck_cd1 + "&intmd_imdg_pck_cd2=" + intmd_imdg_pck_cd2 + "&out_imdg_pck_cd1=" + out_imdg_pck_cd1 + "&out_imdg_pck_cd2=" + out_imdg_pck_cd2 + "&in_imdg_pck_desc1=" + in_imdg_pck_desc1 + "&in_imdg_pck_desc2=" + in_imdg_pck_desc2
//					+ "&intmd_imdg_pck_desc1=" + intmd_imdg_pck_desc1 + "&intmd_imdg_pck_desc2=" + intmd_imdg_pck_desc2 + "&out_imdg_pck_desc1=" + out_imdg_pck_desc1 + "&out_imdg_pck_desc2=" + out_imdg_pck_desc2 + "&in_imdg_pck_qty1=" + in_imdg_pck_qty1 + "&in_imdg_pck_qty2=" + in_imdg_pck_qty2 + "&intmd_imdg_pck_qty1=" + intmd_imdg_pck_qty1 + "&intmd_imdg_pck_qty2=" + intmd_imdg_pck_qty2
//					+ "&out_imdg_pck_qty1=" + out_imdg_pck_qty1 + "&out_imdg_pck_qty2=" + out_imdg_pck_qty2 + "&hcdg_intmd_bc_rstr_desc=" + hcdg_intmd_bc_rstr_desc + "&hcdg_pck_rstr_desc=" + hcdg_pck_rstr_desc + "&hcdg_tnk_rstr_desc=" + hcdg_tnk_rstr_desc + "&ltd_qty=" + ltd_qty + "&imdg_expt_qty_cd=" + imdg_expt_qty_cd, 710, 600, "getCOM_PKG_QTY_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0,
//					"ESM_BKG_0206");
//    		 
//    		 sParam="in_imdg_pck_cd1="+ComGetObjValue(formObj.in_imdg_pck_cd1);
//    		 sParam += "&in_imdg_pck_cd2="+ComGetObjValue(formObj.in_imdg_pck_cd2);
//    		 sParam += "&out_imdg_pck_cd1="+ComGetObjValue(formObj.out_imdg_pck_cd1);
//    		 sParam += "&out_imdg_pck_cd2="+ComGetObjValue(formObj.out_imdg_pck_cd2);    		 
//    		 sParam += "&in_imdg_pck_qty1="+ComGetObjValue(formObj.in_imdg_pck_qty1);
//    		 sParam += "&in_imdg_pck_qty2="+ComGetObjValue(formObj.in_imdg_pck_qty2);
//    		 sParam += "&out_imdg_pck_qty1="+ComGetObjValue(formObj.out_imdg_pck_qty1);
//    		 sParam += "&out_imdg_pck_desc2="+ComGetObjValue(formObj.out_imdg_pck_desc2);
//    		 sParam += "intmd_imdg_pck_cd1="+ComGetObjValue(formObj.intmd_imdg_pck_cd1);
//    		 sParam += "intmd_imdg_pck_cd2="+ComGetObjValue(formObj.intmd_imdg_pck_cd2);
//    		 sParam += "&intmd_imdg_pck_qty1="+ComGetObjValue(formObj.intmd_imdg_pck_qty1);
//    		 sParam += "&intmd_imdg_pck_qty2="+ComGetObjValue(formObj.intmd_imdg_pck_qty2);
//    		 sParam += "&intmd_imdg_pck_desc1="+ComGetObjValue(formObj.intmd_imdg_pck_desc1);
//    		 sParam += "&intmd_imdg_pck_desc2="+ComGetObjValue(formObj.intmd_imdg_pck_desc2);  
//    		 sParam += "&max_in_pck_qty="+ComGetObjValue(formObj.max_in_pck_qty);
//    		 sParam += "&max_in_pck_tp_cd="+ComGetObjValue(formObj.max_in_pck_tp_cd);      		 
//    		 sParam += "&hcdg_intmd_bc_rstr_desc="+ComGetObjValue(formObj.hcdg_intmd_bc_rstr_desc);
//    		 sParam += "&hcdg_pck_rstr_desc="+ComGetObjValue(formObj.hcdg_pck_rstr_desc);
//    		 sParam += "&hcdg_tnk_rstr_desc="+ComGetObjValue(formObj.hcdg_tnk_rstr_desc);
//    		 sParam += "&imdg_expt_qty_cd="+ComGetObjValue(formObj.imdg_expt_qty_cd);
//    		 sParam += "&ltd_qty="+ComGetObjValue(formObj.ltd_qty);
//    		 ComOpenPopup("ESM_BKG_0206.do?"+sParam, 710, 525, "ESM_BKG_0206",  "0,0,1,1,1,1,1", true);
		 }else if (srcName == "btn_UnNo" ) {
//			 sParam="imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
//			 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
//			 sParam += "&prp_shp_nm="+ComGetObjValue(formObj.prp_shp_nm);
//			 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
//			 ComOpenPopup("ESM_BKG_0204.do?"+sParam, 913, 440, "ESM_BKG_0204", "0,0,1,1,1,1,1", true);
			 var sParam="imdg_un_no="+ComGetObjValue(formObj.imdg_un_no);
			 sParam += "&imdg_un_no_seq="+ComGetObjValue(formObj.imdg_un_no_seq);
			 sParam += "&imdg_amdt_no="+ComGetObjValue(formObj.imdg_amdt_no);
			 sParam += "&imdg_clss_cd="+ComGetObjValue(formObj.imdg_clss_cd);
			 sParam += "&prp_shp_nm="+ComGetObjValue(formObj.prp_shp_nm);
			 sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
			 sParam += "&pop_type=OA" ;
			 ComOpenPopup("ESM_BKG_0204.do?"+sParam, 913, 440, "setCallBackUnNo2", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");	//getCOM_UNNO_POPUP / setCallBackUnNo			 
    	 }else if (srcName == "btn_OtherEmergencyInformation") {
			 sParam="imdg_emer_no="+ComGetObjValue(formObj.ems_no);
			 sParam += "&emer_rspn_gid_no="+ComGetObjValue(formObj.emer_rspn_gid_no);
			 sParam += "&emer_rspn_gid_chr_no="+ComGetObjValue(formObj.emer_rspn_gid_chr_no);
			 sParam += "&ctrl_temp_ctnt="+ComGetObjValue(formObj.ctrl_temp_ctnt);
			 sParam += "&emer_temp_ctnt="+ComGetObjValue(formObj.emer_temp_ctnt);
			
			// ::DG RailBilling 2015-12-02 ::	 
			 sParam += "&erap_no="+ComGetObjValue(formObj.erap_no);
			 sParam += "&erap_cntc_no="+ComGetObjValue(formObj.erap_cntc_no);
			 sParam += "&erap_apro_ref_no="+ComGetObjValue(formObj.erap_apro_ref_no);
			 sParam += "&pop_type=OA" ;
			 
//			 ComOpenPopup("ESM_BKG_0770.do?"+sParam, 505, 215, "ESM_BKG_0770", "0,0,1,1,1,1,1", true);
			 
			 if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
				ComOpenPopup("ESM_BKG_0770.do?"+sParam, 500, 270, "getCOM_EMER_NO_POPUP", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0770");
			 }			 
			
		 // ::DG RailBilling 2015-12-02 ::	 
    	 }else if(srcName == "btn_dot_info"){
    		 
    		  sParam = "dot_exp_no="+ComGetObjValue(formObj.dot_exp_no);
    		  sParam +="&dot_spcl_apro_no=" + ComGetObjValue(formObj.dot_spcl_apro_no);
    		  sParam +="&dot_auth_no=" + ComGetObjValue(formObj.dot_auth_no);
    		  sParam +="&pop_type=R" ;
    		  
    		  if (document.getElementById("bkg_no").value != "" && document.getElementById("bl_no").value != "") {
    			  ComOpenPopup("ESM_BKG_1301.do?"+ sParam, 700, 280, "getCOM_DOT_INFO_POPUP", '0,0', true, false, 0, 0, 0, "ESM_BKG_1301");
    			 
				}
				
    	 //}else if (srcName == "btn_AttachedFile") {
    	 //	 ComOpenPopup("ESM_BKG_0207.do?bkg_no="+formObj.bkg_no.value+"&ridr_tp_cd=D&disableYn=Y", 523, 525, "ESM_BKG_0207", "0,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_ApprovalDetails") {
    		 ComOpenPopup("VOP_SCG_1015.do?scg_flg="+formObj.scg_flg.value+"&bkg_no="+formObj.bkg_no.value, 1005, 520, "VOP_SCG_1015", "1,0,1,1,1,1,1", true);
    	 }else if (srcName == "btn_Prev") {
    		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
    			 if (!setParentValue()) {
    				 sheetObjects[1].SelectCell(oldRow,"cntr_no", 0, "", 0);
    				 return false;
    			 }
    		 }
    		 if(row == "-1"){
    			 row = oSheetObj.GetSelectRow();
    		 }
    		 if (row == 2) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 
    			 var bkg_company=oSheetObj.GetCellValue(parseInt(row)-1, "cgo_opr_cd");
    			 if(bkg_company != ConstantMgr.getCompanyCode() && formObj.scg_flg.value=="SCG_DG") {
    				 ComShowCodeMessage('SCG50031');
    				 return;
    			 }
    			 
    			 oSheetObj.SelectCell( parseInt(row)-1 , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)-1 , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)-1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)-1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)-1, "skd_dir_cd");
    			 formObj.dcgo_seq.value=oSheetObj.GetCellValue( parseInt(row)-1, "dcgo_seq");
    			 if (formObj.scg_flg.value=="SCG_DG"){
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cgo_seq");
    			 }else {
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "dg_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "cntr_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( parseInt(row)-1 , "cntr_cgo_seq");
    			 }
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)-1;
    			 loadPage2();
    		 }
    	 }else if (srcName == "btn_Next") {
    		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="DG2") {
    			 if (!setParentValue()) {
    				 sheetObjects[1].SelectCell(oldRow,"cntr_no", 0, "", 0);
    				 return false;
    			 }
    		 }
    		 if(row == "-1"){
    			 row = oSheetObj.GetSelectRow();
    		 }
    		 if (row == oSheetObj.LastRow()) {
    			 ComShowCodeMessage('SCG50031');
    		 }else{
    			 
    			 var bkg_company=oSheetObj.GetCellValue(parseInt(row)+1, "cgo_opr_cd");
    			 if(bkg_company != ConstantMgr.getCompanyCode() && formObj.scg_flg.value=="SCG_DG") {
    				 ComShowCodeMessage('SCG50031');
    				 return;
    			 }
    			 
    			 oSheetObj.SelectCell( parseInt(row)+1 , oSheetObj.GetSelectCol());
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)+1 , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)+1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)+1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)+1, "skd_dir_cd");
    			 formObj.dcgo_seq.value=oSheetObj.GetCellValue( parseInt(row)+1, "dcgo_seq");
    			 if (formObj.scg_flg.value=="SCG_DG"){
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cgo_seq");
    			 }else {
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "dg_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "cntr_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( parseInt(row)+1 , "cntr_cgo_seq");
    			 }
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "spcl_cgo_apro_rqst_seq");
    			 formObj.row.value=parseInt(row)+1;
    			 loadPage2();
    		 }
    	 }
    		 
//    	 }else if (srcName == "btn_Prev") {
//    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
//    			 if (!setParentValue()) return false;
//    		 }
//    		 if (row == 2) {
//    			 ComShowCodeMessage('SCG50031');
//    		 }else{
//    			 oSheetObj.SelectCell( parseInt(row)-1 , oSheetObj.GetSelectCol());
//    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)-1 , "bkg_no");
//    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)-1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)-1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)-1, "skd_dir_cd");
//    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)-1 , "awk_cgo_seq");
//    			 formObj.row.value=parseInt(row)-1;
//    			 loadPage2();
//    		 }
//    	 }else if (srcName == "btn_Next") {
//    		 if (formObj.scg_flg.value=="AWK" || formObj.scg_flg.value=="45") {
//    			 if (!setParentValue()) return false;
//    		 }
//    		 if (row == oSheetObj.LastRow()) {
//    			 ComShowCodeMessage('SCG50031');
//    		 }else{
//    			 oSheetObj.SelectCell( parseInt(row)+1 , oSheetObj.GetSelectCol());
//    			 formObj.bkg_no.value=oSheetObj.GetCellValue( parseInt(row)+1 , "bkg_no");
//    			 formObj.vvd_cd.value=oSheetObj.GetCellText(parseInt(row)+1, "vsl_cd")+oSheetObj.GetCellText(parseInt(row)+1, "skd_voy_no")+oSheetObj.GetCellText(parseInt(row)+1, "skd_dir_cd");
//    			 formObj.awk_cgo_seq.value=oSheetObj.GetCellValue( parseInt(row)+1 , "awk_cgo_seq");
//    			 formObj.row.value=parseInt(row)+1;
//    			 loadPage2();
//    		 }
//    	 }    		 
    		 
     }
     
 	/**
   	 * Dropping UN Number popup selected item - BKG
   	 */
   	function setCallBackUnNo2(aryPopupData) {
   		var formObj=document.form;
   		ComSetObjValue(formObj.imdg_un_no, 			aryPopupData[0][2]);
   		ComSetObjValue(formObj.imdg_un_no_seq, 		aryPopupData[0][3]);
   		ComSetObjValue(formObj.imdg_clss_cd, 		aryPopupData[0][4]);
   		ComSetObjValue(formObj.imdg_comp_grp_cd, 	aryPopupData[0][5]);
   		ComSetObjValue(formObj.prp_shp_nm, 			aryPopupData[0][7]);
   		ComSetObjValue(formObj.hzd_desc, 			aryPopupData[0][9]);
   		var imdg_pck_grp_cd=aryPopupData[0][6];
   		if(imdg_pck_grp_cd == '1') imdg_pck_grp_cd="I";
   		else if(imdg_pck_grp_cd == '2') imdg_pck_grp_cd="II";
   		else if(imdg_pck_grp_cd == '3') imdg_pck_grp_cd="III";
   		ComSetObjValue(formObj.imdg_pck_grp_cd, 	imdg_pck_grp_cd);
   		ComSetObjValue(formObj.psa_no, 				aryPopupData[0][15]);
   		ComSetObjValue(formObj.hcdg_pck_rstr_desc, 		aryPopupData[0][29]);
   		ComSetObjValue(formObj.hcdg_intmd_bc_rstr_desc, aryPopupData[0][30]);
   		ComSetObjValue(formObj.hcdg_tnk_rstr_desc, 		aryPopupData[0][31]);
	    
   		ComSetObjValue(formObj.imdg_lmt_qty, 		    aryPopupData[0][20]);
  	    ComSetObjValue(formObj.imdg_lmt_qty_desc, 	    aryPopupData[0][21]);
  	  	ComSetObjValue(formObj.imdg_expt_qty_cd, 		aryPopupData[0][22]);
  	  	ComSetObjValue(formObj.imdg_expt_qty_desc, 		aryPopupData[0][23]); 
   		
   		ComSetObjValue(formObj.ems_no, 		            aryPopupData[0][17]);
   		ComSetObjValue(formObj.ctrl_temp_ctnt, 		    aryPopupData[0][32]);
   		ComSetObjValue(formObj.emer_rspn_gid_no, 		aryPopupData[0][18]);
   		ComSetObjValue(formObj.emer_rspn_gid_chr_no,    aryPopupData[0][19]);
   		ComSetObjValue(formObj.emer_temp_ctnt, 		    aryPopupData[0][33]);
   		ComSetObjValue(formObj.imdg_lmt_qty_meas_ut_cd, aryPopupData[0][34]);
   		ComSetObjValue(formObj.hcdg_flg,                aryPopupData[0][24]);
  		//ComSetObjValue(formObj.imdg_subs_rsk_lbl_rmk,   aryPopupData[0][8]);
   		var imdg_subs_rsk_lbl_cd=aryPopupData[0][10]+"|"+aryPopupData[0][11]+"|"+aryPopupData[0][12]+"|"+aryPopupData[0][13];
   		if(imdg_subs_rsk_lbl_cd != null) {
   			imdg_subs_rsk_lbl_cd=imdg_subs_rsk_lbl_cd.split("|");
//   			var formItems=new Array();
//   			formItems[0]="n1st";
//   			formItems[1]="n2nd";
//   			formItems[2]="n3rd";
//   			formItems[3]="n4th";
   			var subsRsk="";
   			var k = 0;
  	 		for(var i=0; i<4; i++) {
  	 			k = i + 1;
  	 			if(i < imdg_subs_rsk_lbl_cd.length) subsRsk=imdg_subs_rsk_lbl_cd[i];
  	 			else subsRsk="";
//  	 			ComSetObjValue(eval("document.form."+formItems[i]+"_imdg_subs_rsk_lbl_cd"), subsRsk);
  	 			ComSetObjValue(eval("document.form."+"imdg_subs_rsk_lbl_cd"+k), subsRsk);
  	 		}
   		}
   		
//   		var imdg_un_no_seq = document.getElementById("imdg_un_no_seq").value;
//		if(imdg_un_no_seq >= 490){
   		var cfr_flg = document.getElementById("cfr_flg").value;
   		if(cfr_flg == "T"){
			document.getElementById("cfr_flg").checked=true;
		}else{ // F
			document.getElementById("cfr_flg").checked=false;
		}
		
   		//Setting Marin Pollutant value
   		/*var imdg_mrn_polut_cd=aryPopupData[0][16]=='P'?'Y':'N';
  		mrn_polut_flg.SetSelectCode(imdg_mrn_polut_cd,false);
  		var hcdg_flg=ComGetObjValue(formObj.hcdg_flg);
  		var imdg_subs_rsk_lbl_rmk=ComGetObjValue(formObj.imdg_subs_rsk_lbl_rmk);
  		//HCDG/Remark(s) Button color change
  		chgBtnHcdgRemarks(hcdg_flg, imdg_subs_rsk_lbl_rmk);
   		//In case of UN No. applying SP274, set Technical Name as compulsory item.
   		var imdg_spcl_provi_no=aryPopupData[0][24]; 		
   		var proviNos; 		
   		var itemObj=document.getElementById("hzd_desc"); 		
   		var imdgSpclProviNo=""; 	
   		if(imdg_spcl_provi_no.length > 0) {
   			proviNos=imdg_spcl_provi_no.split("|");
   			if(proviNos.length > 0) {
  		 		for(var pIdx=0; pIdx<proviNos.length; pIdx++) {
  		 			if(proviNos[pIdx] == '274') imdgSpclProviNo=proviNos[pIdx];
  		 		}
   			}
   		}
   		//chgTecNmBox(imdgSpclProviNo, itemObj);
   		ComSetObjValue(formObj.imdg_spcl_provi_no, imdgSpclProviNo);
   		//Initializing Flash Point value
  		ComSetObjValue(formObj.flsh_pnt_cdo_temp, "");	
   		//Flash Point status change decision
   		fixFlshPointForm(formObj); 
   		//Initializing Pre-Checking Report result
  		setPreChkRslt("N");*/
   	}
   	
 	function getCOM_PKG_QTY_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
		var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		if (document.getElementById("out_imdg_pck_cd1").value != colArray[8]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		if (document.getElementById("out_imdg_pck_qty1").value != colArray[7]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		document.getElementById("in_imdg_pck_cd1").value=colArray[20];
		document.getElementById("in_imdg_pck_cd2").value=colArray[23];
		document.getElementById("out_imdg_pck_cd1").value=colArray[8];
		document.getElementById("out_imdg_pck_cd2").value=colArray[11];
		document.getElementById("in_imdg_pck_desc1").value=colArray[21];
		document.getElementById("in_imdg_pck_desc2").value=colArray[24];
		document.getElementById("out_imdg_pck_desc1").value=colArray[9];
		document.getElementById("out_imdg_pck_desc2").value=colArray[12];
		document.getElementById("in_imdg_pck_qty1").value=colArray[19];
		document.getElementById("in_imdg_pck_qty2").value=colArray[22];
		document.getElementById("out_imdg_pck_qty1").value=colArray[7];
		document.getElementById("out_imdg_pck_qty2").value=colArray[10];
		document.getElementById("intmd_imdg_pck_cd1").value=colArray[14];
		document.getElementById("intmd_imdg_pck_cd2").value=colArray[17];
		document.getElementById("intmd_imdg_pck_qty1").value=colArray[13];
		document.getElementById("intmd_imdg_pck_qty2").value=colArray[16];
		document.getElementById("intmd_imdg_pck_desc1").value=colArray[15];
		document.getElementById("intmd_imdg_pck_desc2").value=colArray[18];
		document.getElementById("hcdg_intmd_bc_rstr_desc").value=colArray[26];
		document.getElementById("hcdg_pck_rstr_desc").value=colArray[25];
		document.getElementById("hcdg_tnk_rstr_desc").value=colArray[27];
		
		document.getElementById("ltd_qty").value=colArray[28];
		document.getElementById("imdg_lmt_qty_desc").value=colArray[29];
		document.getElementById("imdg_expt_qty_cd").value=colArray[30];
		document.getElementById("imdg_expt_qty_desc").value=colArray[31];

		sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd1",colArray[20],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_cd2",colArray[23],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd1",colArray[8],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_cd2",colArray[11],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc1",colArray[21],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_desc2",colArray[24],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc1",colArray[9],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_desc2",colArray[12],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty1",colArray[19],0);
		sheetObjects[3].SetCellValue(row, "in_imdg_pck_qty2",colArray[22],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty1",colArray[7],0);
		sheetObjects[3].SetCellValue(row, "out_imdg_pck_qty2",colArray[10],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd1",colArray[14],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_cd2",colArray[17],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty1",colArray[13],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_qty2",colArray[16],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc1",colArray[15],0);
		sheetObjects[3].SetCellValue(row, "intmd_imdg_pck_desc2",colArray[18],0);
		sheetObjects[3].SetCellValue(row, "hcdg_intmd_bc_rstr_desc",colArray[26],0);
		sheetObjects[3].SetCellValue(row, "hcdg_pck_rstr_desc",colArray[25],0);
		sheetObjects[3].SetCellValue(row, "hcdg_tnk_rstr_desc",colArray[27],0);
		sheetObjects[3].SetCellValue(row, "ltd_qty",colArray[28],0);
		sheetObjects[3].SetCellValue(row, "imdg_expt_qty_cd",colArray[29],0);
		
		sheetObjects[3].SetCellValue(row, "ltd_qty",colArray[28],0);
		sheetObjects[3].SetCellValue(row, "imdg_lmt_qty_desc",colArray[29],0);
		sheetObjects[3].SetCellValue(row, "imdg_expt_qty_cd",colArray[30],0);
		sheetObjects[3].SetCellValue(row, "imdg_expt_qty_desc",colArray[31],0);
		
	}
    
 	// ::DG RailBilling 2015-12-02 ::	 
 	function getCOM_EMER_NO_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
		var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		if (document.getElementById("ems_no").value != colArray[4]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}
		document.getElementById("ems_no").value=colArray[4];
		document.getElementById("emer_rspn_gid_no").value=colArray[6];
		document.getElementById("emer_rspn_gid_chr_no").value=colArray[7];
		document.getElementById("ctrl_temp_ctnt").value=colArray[5];
		document.getElementById("emer_temp_ctnt").value=colArray[8];
		// ::DG RailBilling 2015-12-02 ::	
		document.getElementById("erap_no").value=colArray[9];
		document.getElementById("erap_cntc_no").value=colArray[10];
		document.getElementById("erap_apro_ref_no").value=colArray[11];
		sheetObjects[3].SetCellValue(row, "ems_no",colArray[4]);
		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_no",colArray[6]);
		sheetObjects[3].SetCellValue(row, "emer_rspn_gid_chr_no",colArray[7]);
		sheetObjects[3].SetCellValue(row, "ctrl_temp_ctnt",colArray[5]);
		sheetObjects[3].SetCellValue(row, "emer_temp_ctnt",colArray[8]);
		// ::DG RailBilling 2015-12-02 ::	
		sheetObjects[3].SetCellValue(row, "erap_no",colArray[9]);
		sheetObjects[3].SetCellValue(row, "erap_cntc_no",colArray[10]);
		sheetObjects[3].SetCellValue(row, "erap_apro_ref_no",colArray[11]);
		
		
	}     
 	
 	
 
 	// ::DG RailBilling 2015-12-02 ::	 
 	function getCOM_DOT_INFO_POPUP(rowArray) {
		var formObject=document.form;
		var colArray=rowArray[0];
		//var row=getEditRowNo("");
		//var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		var bkg_cntr_seq=document.getElementById("dg_cntr_seq").value + document.form.cntr_cgo_seq.value;
		var row=sheetObjects[3].FindText("bkg_cntr_seq", bkg_cntr_seq, 0, 2);
		
		if (document.getElementById("dot_exp_no").value != colArray[0]
			|| document.getElementById("dot_spcl_apro_no").value != colArray[1]
			|| document.getElementById("dot_auth_no").value != colArray[2]) {
			sheetObjects[3].SetCellValue(row, "modifyaproflg","Y",0);
		}

		document.getElementById("dot_exp_no").value = colArray[0];
		document.getElementById("dot_spcl_apro_no").value = colArray[1];
		document.getElementById("dot_auth_no").value = colArray[2];
		sheetObjects[3].SetCellValue(row, "dot_exp_no",colArray[0]);
		sheetObjects[3].SetCellValue(row, "dot_spcl_apro_no",colArray[1]);
		sheetObjects[3].SetCellValue(row, "dot_auth_no",colArray[2]);
		
	}
     
     /**
      * Clicking popup in IBSheet Object
      */
     function setParentValue(){
    	 var formObj=document.form;    
		 var row=formObj.row.value;
		 var oSheetObj="";
		 /* OPENER의 TAB1의 SHEET1통합 */
		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }
		 
		 if(openerObj.document.form.dg_cancel != undefined){
			 if(ComGetObjValue(openerObj.document.form.dg_cancel) == "Y"){
				 return true;
			 }	 
		 }
		 
		 //var row=oSheetObj.GetSelectRow();
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
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd",comboObjects[1].GetSelectCode());
			 if (comboObjects[1].GetSelectCode()== 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
    			 ComShowCodeMessage('SCG50007', 'Reject Remark(s)');
    			 formObj.spcl_cgo_auth_rmk.focus();
    			 return false;
			 }else{
				 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rmk",formObj.spcl_cgo_auth_rmk.value);
			 }
		 }else if (formObj.spcl_cgo_auth_cd.value != "" && (formObj.spcl_cgo_auth_cd.value.substr(0,1) == 'N' || formObj.spcl_cgo_auth_cd.value.substr(0,1) == 'P')){
			 if (comboObjects[1].GetSelectCode()== '') {
    			 ComShowCodeMessage('SCG50011', 'RJT Code');
    			 formObj.spcl_cgo_auth_rjct_cd.focus();
    			 return false;
			 }
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_cd",formObj.spcl_cgo_auth_cd.value);
			 oSheetObj.SetCellValue( parseInt(row) , "spcl_cgo_auth_rjct_cd",comboObjects[1].GetSelectCode());
			 if (comboObjects[1].GetSelectCode()== 'AAA' && formObj.spcl_cgo_auth_rmk.value == '') {
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
      * Making parameter of Pre-Checking
      */
     function makePreChkParam() {
     	var sheetObj2=sheetObjects[3];
 		var formObj=document.form;
 		var sParam="";
 		var oSheetObj="";
 		if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="SCG_DG"){
 			oSheetObj=openerObj.sheetObjects[0];
 		}else if (formObj.scg_flg.value=="DG2"){
 			oSheetObj=openerObj.sheetObjects[0];
 		}
 		for(var i=sheetObj2.HeaderRows(); i<=sheetObj2.LastRow(); i++) {
			if(sheetObj2.GetRowStatus(i) != 'D') {
				for(var j=0; j<=sheetObj2.LastCol(); j++) {
					var colValue = sheetObj2.GetCellValue(i, j);
					// spcl_cntr_seq, spcl_cgo_seq 값 설정
					if(sheetObj2.ColSaveName(j) == "spcl_cntr_seq") {
						colValue = sheetObj2.GetCellValue(i, "dg_cntr_seq");
					} else if(sheetObj2.ColSaveName(j) == "spcl_cgo_seq") {
						colValue = sheetObj2.GetCellValue(i, "cntr_cgo_seq");
					} 
					sParam += sheetObj2.ColSaveName(j)+"="+colValue+"&";
				}
			}
 		}
// 		sParam += "rgn_shp_opr_cd="+openerObj.document.all.rgn_shp_opr_cd.GetSelectCode();
 		sParam += "rgn_shp_opr_cd="+openerObj.document.all.rgn_shp_opr_cd.value;
 		sParam += "&cgo_opr_cd="+ConstantMgr.getCompanyCode();
 		sParam += "&bkg_no="+ComGetObjValue(formObj.bkg_no);
 		sParam += "&vsl_cd="+formObj.vvd_cd.value.substring(0,4);
 		sParam += "&skd_voy_no="+formObj.vvd_cd.value.substring(4,8);
 		sParam += "&skd_dir_cd="+formObj.vvd_cd.value.substring(8,9);
 		sParam += "&crr_cd="+oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "crr_cd");
 		sParam += "&slan_cd="+oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "slan_cd");
 		sParam += "&pol_cd="+ComGetObjValue(formObj.pol_cd);
 		sParam += "&pod_cd="+ComGetObjValue(formObj.pod_cd);
		sParam += "&imdg_segr_grp_no=" + imdg_segr_grp_no.GetSelectCode();
		sParam += "&imdg_un_no=" + ComGetObjValue(formObj.imdg_un_no);
 		return sParam;
     }
 	/**
 	 * Pre-Checking result Setter - Y:pass after checking , N:before checking , P:prohibition after checking
 	 */
 	function setPreChkRslt(rslt) {
 	}
 	/**
 	 * Special Request Cargo info return
 	 */
 	function getCgoSheet() {
 		return sheetObjects[3];
 	}     
     
     /**
      * Sending request mail
      */
     function sendReqMail(sheetObj, formObj) {
		 var oSheetObj="";
		 if (formObj.scg_flg.value=="DG1" || formObj.scg_flg.value=="SCG_DG"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }else if (formObj.scg_flg.value=="DG2"){
			 oSheetObj=openerObj.sheetObjects[0];
		 }
		 var crr_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "crr_cd");
		 var bkg_ref_no="";
		 var spcl_cgo_rqst_seq="";
    	 var bkg_no=formObj.bkg_no.value;
    	 var spcl_cgo_apro_rqst_seq=formObj.spcl_cgo_apro_rqst_seq.value;
		 var vsl_pre_pst_cd=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_pre_pst_cd");
		 var vsl_seq=oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "vsl_seq");
//    	 var rgn_shp_opr_cd=openerObj.document.all.rgn_shp_opr_cd.GetSelectCode();
		 var rgn_shp_opr_cd=openerObj.document.all.rgn_shp_opr_cd.value;
    	 var scg_flg="DG";
    	 var send_type="0";
    	 //var user_id=ComGetObjValue(formObj.auth_usr_id);
    	 
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
    	 mailObj.user_id=preConds.user_id;
    	 ComScgSendMail(sheetObj, formObj, mailObj, true, "VOP_SCG_0014GS.do", "authPending()");
    	 
     }
     
     function authPending() {
    	 var formObj=document.form;
    	 //if (formObj.spcl_cgo_auth_cd.options.length == "5") {
        	 formObj.spcl_cgo_auth_cd.options[3].selected=true;
        	 comboObjects[1].SetEnable(1);
        	 comboObjects[1].SetBackColor("#FFFFFF");
        	 //formObj.spcl_cgo_auth_rmk.disabled = false;
        	 //formObj.spcl_cgo_auth_rmk.className = "input";
        	 formObj.mailYn.value="Y";
    	 //}
     }
     
 	function sendMail() {
		var iCnt=sheetObjects[3].FindText("ibflag", "I", 0, 2);
		var uCnt=sheetObjects[3].FindText("ibflag", "U", 0, 2);
		var dCnt=sheetObjects[3].FindText("ibflag", "D", 0, 2);
		if (iCnt > 0 || uCnt > 0 || dCnt > 0) {
			ComShowMessage(ComGetMsg("BKG00178"));
			return;
		}
		var date=new Date();
		var content="";
		content="SHIPPING<br><br>[ Dangerous Cargo ]<br>"
				+ date.toString()
				+ "<br>Booking Number : " 
				+ document.getElementById("bkg_no").value 
				+ "<br>B/L Number : " 
				+ document.getElementById("bl_no").value 
				+ "<br>POL : " 
				+ document.getElementById("pol_cd").value 
				+ "<br>POD : " 
				+ document.getElementById("pod_cd").value 
				+ "<br>VVD/VESSEL NAME : " 
				+ document.getElementById("vsl_cd").value + " / "
				+ document.getElementById("vessel_nm").value 
				+ "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
		for ( var i=1; i <= sheetObjects[3].RowCount(); i++) {
			if (sheetObjects[3].GetCellValue(i, "spcl_apro_cd") != "C") {
				content += "1.  Container SEQ           : " + sheetObjects[3].GetCellValue(i, "spcl_cntr_seq") + "<br>";
				content += "2.  Container No.           : " + sheetObjects[3].GetCellValue(i, "cntr_no") + "<br>";
				content += "3.  EQ Type/Size            : " + sheetObjects[3].GetCellValue(i, "eq_tpsz") + "<br>";
				content += "4.  Cargo SEQ               : " + sheetObjects[3].GetCellValue(i, "spcl_cgo_seq") + "<br>";
				content += "5.  UN No.                  : " + sheetObjects[3].GetCellValue(i, "imdg_un_no") + "<br>";
				content += "6.  IMO Class               : " + sheetObjects[3].GetCellValue(i, "imdg_clss_cd") + "<br>";
				content += "7.  Net WGT/KG              : " + sheetObjects[3].GetCellText(i, "net_wgt") + "<br>";
				content += "8.  Grs WGT/KG              : " + sheetObjects[3].GetCellText(i, "grs_wgt") + "<br>";
				content += "9.  Proper Ship Name        : " + sheetObjects[3].GetCellValue(i, "prp_shp_nm") + "<br>";
				//content += "LTD QTY : " + sheetObjects[3].CellValue(i, "imdg_lmt_qty_flg") + "<br>";
				content += "10. Technical Name          : " + sheetObjects[3].GetCellValue(i, "hzd_desc") + "<br>";
				content += "11. Flash Point/Cel         : " + sheetObjects[3].GetCellValue(i, "flsh_pnt_cdo_temp") + "<br>";
				content += "12. Packing GRP             : " + sheetObjects[3].GetCellValue(i, "imdg_pck_grp_cd") + "<br>";
				if (sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd1") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd2") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd3") == "" && sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd4") == "") {
					content += "13. Sub Label                : <br>"
				} else {
					content += "13. Sub Label                : " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd1") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd2") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd3") + " / " + sheetObjects[3].GetCellValue(i, "imdg_subs_rsk_lbl_cd4") + "<br>";
				}
				content += "14. Control Temp./Cel       : " + sheetObjects[3].GetCellValue(i, "ctrl_temp_ctnt") + "<br>";
				content += "15. Emergency Temp./Cel     : " + sheetObjects[3].GetCellValue(i, "emer_temp_ctnt") + "<br>";
				content += "16. PSA GRP                 : " + sheetObjects[3].GetCellValue(i, "psa_no") + "<br>";
				content += "17. Limited Quantity        : " + sheetObjects[3].GetCellValue(i, "imdg_lmt_qty_flg") + "<br>";
				content += "18. Excepted Quantity       : " + sheetObjects[3].GetCellValue(i, "imdg_expt_qty_flg") + "<br>";
				content += "19. Marine Pollutant        : " + sheetObjects[3].GetCellValue(i, "mrn_polut_flg") + "<br>";
				content += "20. Cargo Status            : " + sheetObjects[3].GetCellValue(i, "dcgo_sts_cd") + "<br>";
				content += "21. EMS No                  : " + sheetObjects[3].GetCellValue(i, "ems_no") + "<br>";
				content += "22. ERG                     : " + sheetObjects[3].GetCellValue(i, "emer_rspn_gid_no") + sheetObjects[3].GetCellValue(i, "emer_rspn_gid_chr_no") +  "<br>";
				content += "23. Emergency Contact       : " + sheetObjects[3].GetCellValue(i, "emer_cntc_phn_no_ctnt") + "<br>";
				content += "24. Outer Pack              : " ;
				if(sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") != 0){
					content += sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty1") + " X "+  sheetObjects[3].GetCellValue(i, "out_imdg_pck_desc1");
				}
				if(sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty2") != 0){
					content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].GetCellValue(i, "out_imdg_pck_qty2") + " X "+  sheetObjects[3].GetCellValue(i, "out_imdg_pck_desc2") ;
				}
				content += "<br>";
				//content += "Intermediate Pack 1 : " + sheetObjects[3].CellValue(i, "intmd_imdg_pck_qty1") + "<br>";
				//content += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + sheetObjects[3].CellValue(i, "intmd_imdg_pck_desc1") + "<br>";
				content += "25. Inner Pack              : ";
				if(sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty1") != 0){
					content += sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty1") + " X "+  sheetObjects[3].GetCellValue(i, "in_imdg_pck_desc1");
				}
				if (sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty2") != 0){
					content += "<br>"+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp&nbsp;" + sheetObjects[3].GetCellValue(i, "in_imdg_pck_qty2") + " X "+  sheetObjects[3].GetCellValue(i, "in_imdg_pck_desc2") ;
				}
				content += "<br>";
				content += "26. Net Explosive Weight/kg : " + sheetObjects[3].GetCellText(i, "net_explo_wgt") + "<br>";
				content += "27. Remarks                 : " + sheetObjects[3].GetCellText(i, "diff_rmk") + "<br>";
				content += "<br>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------<br>";
			}
		}
		document.form.com_content.value=content;
		ComSendMailModal();
	}
 	

 	function cntr_cgo_seq_OnChange(){
 		var formObj = document.form;
 		formObj.cntr_cgo_seq1.value=formObj.cntr_cgo_seq.value;
 		var tmpSeq= "";
 		//2016-02-16 
 		if (!setParentValue()) {
 			sheetObjects[1].SelectCell(oldRow,"cntr_no", 0, "", 0);
 			return false;
 		}
	   	for(var i=1; i<=sheetObjects[3].RowCount(); i++){
	   		if (sheetObjects[3].GetCellValue(i, "cntr_cgo_seq") == formObj.cntr_cgo_seq.value && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == formObj.dg_cntr_seq.value ) {
	   			tmpSeq = sheetObjects[3].GetCellValue(i, "dcgo_seq");
	   			sheetObjects[3].SelectCell(i,"cntr_no");
	   			break;
			}
		}
		 oSheetObj=openerObj.sheetObjects[0];
		 var chkFind = false;
		 for(var i=oSheetObj.GetSelectRow(); i<=oSheetObj.RowCount(); i++){
			 var findStr = formObj.bkg_no.value + tmpSeq + formObj.vvd_cd.value;
			 var oFindStr = oSheetObj.GetCellValue(i, "bkg_no") + 
			                oSheetObj.GetCellValue(i, "dcgo_seq") + 
			                oSheetObj.GetCellValue(i, "vsl_cd") +
			                oSheetObj.GetCellValue(i, "skd_voy_no") +
			                oSheetObj.GetCellValue(i, "skd_dir_cd"); 
			 if(findStr == oFindStr){
				 oSheetObj.SelectCell(i , oSheetObj.GetSelectCol());
				 formObj.row.value=parseInt(i);
    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
    			 formObj.dcgo_seq.value=oSheetObj.GetCellValue( i, "dcgo_seq");
    			 if (formObj.scg_flg.value=="SCG_DG"){
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( i , "spcl_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( i , "spcl_cgo_seq");
    			 }else {
					formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( i , "dg_cntr_seq");
					formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( i , "cntr_cgo_seq");
					formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( i , "cntr_cgo_seq");
    			 }
    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_apro_rqst_seq");
    			 
				 chkFind = true;
				 break;
			 }
		 }
		 if(chkFind == false){
			 for(var i=oSheetObj.GetSelectRow(); i > 0; i--){
				 var findStr = formObj.bkg_no.value + tmpSeq + formObj.vvd_cd.value;
				 var oFindStr = oSheetObj.GetCellValue(i, "bkg_no") + 
	                            oSheetObj.GetCellValue(i, "dcgo_seq") + 
	                            oSheetObj.GetCellValue(i, "vsl_cd") +
	                            oSheetObj.GetCellValue(i, "skd_voy_no") +
	                            oSheetObj.GetCellValue(i, "skd_dir_cd"); 
				 if(findStr == oFindStr){
					 oSheetObj.SelectCell(i , oSheetObj.GetSelectCol());
					 formObj.row.value=parseInt(i);
	    			 formObj.bkg_no.value=oSheetObj.GetCellValue( i , "bkg_no");
	    			 formObj.vvd_cd.value=oSheetObj.GetCellText(i, "vsl_cd")+oSheetObj.GetCellText(i, "skd_voy_no")+oSheetObj.GetCellText(i, "skd_dir_cd");
	    			 formObj.dcgo_seq.value=oSheetObj.GetCellValue( i, "dcgo_seq");
	    			 if (formObj.scg_flg.value=="SCG_DG"){
						formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( i , "spcl_cntr_seq");
						formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_seq");
						formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( i , "spcl_cgo_seq");
	    			 }else {
						formObj.dg_cntr_seq.value=oSheetObj.GetCellValue( i , "dg_cntr_seq");
						formObj.cntr_cgo_seq.value=oSheetObj.GetCellValue( i , "cntr_cgo_seq");
						formObj.cntr_cgo_seq1.value=oSheetObj.GetCellValue( i , "cntr_cgo_seq");
	    			 }
	    			 formObj.spcl_cgo_apro_rqst_seq.value=oSheetObj.GetCellValue( i , "spcl_cgo_apro_rqst_seq");
	    			 chkFind = true;
					 break;
				 }
			 }
		 }
		 if(chkFind == false){
			 formObj.row.value="-1";
		    document.getElementById("spcl_cgo_auth_cd").disabled=true;
		 	document.getElementById("spcl_cgo_auth_cd").className="input2";
		 	comboObjects[1].SetEnable(0);
		 	document.getElementById("spcl_cgo_auth_rmk").disabled=true;
		 	document.getElementById("spcl_cgo_auth_rmk").className="input2";
		   	for(var i=1; i<=sheetObjects[3].RowCount(); i++){
		   		if (sheetObjects[3].GetCellValue(i, "cntr_cgo_seq") == formObj.cntr_cgo_seq.value && sheetObjects[3].GetCellValue(i, "dg_cntr_seq") == formObj.dg_cntr_seq.value ) {
		   			
		   			sheetObjects[3].SelectCell(i,"cntr_no");
	    			formObj.bkg_no.value=sheetObjects[3].GetCellValue( i , "bkg_no");
	    			formObj.vvd_cd.value=document.getElementById("vvd_cd").value.substring(0,4) + document.getElementById("vvd_cd").value.substring(4,8) + document.getElementById("vvd_cd").value.substring(8,9) ;
	    			formObj.dcgo_seq.value=sheetObjects[3].GetCellValue( i, "dcgo_seq"); 
	    			formObj.dg_cntr_seq.value=sheetObjects[3].GetCellValue( i , "dg_cntr_seq");
					formObj.cntr_cgo_seq.value=sheetObjects[3].GetCellValue( i , "cntr_cgo_seq");
					formObj.cntr_cgo_seq1.value=sheetObjects[3].GetCellValue( i , "cntr_cgo_seq");
	    			formObj.spcl_cgo_apro_rqst_seq.value=sheetObjects[3].GetCellValue( i , "spcl_cgo_apro_rqst_seq");
	    			
	    			 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd", sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_cd") , 0); 
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_text", sheetObjects[3].GetCellValue(i, "spcl_cgo_apro_text") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq", sheetObjects[3].GetCellValue(i, "dg_cntr_seq") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "dcgo_seq", sheetObjects[3].GetCellValue(i, "dcgo_seq") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", sheetObjects[3].GetCellValue(i, "spcl_cgo_auth_rjct_cd") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk", sheetObjects[3].GetCellValue(i, "spcl_cgo_auth_rmk") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "auth_usr_id", sheetObjects[3].GetCellValue(i, "auth_usr_id") , 0);
	    	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "auth_gdt", sheetObjects[3].GetCellValue(i, "auth_gdt") , 0);
	    	    	 
	    			 cntrChk()
	    			 setAuthStat(sheetObjects[1], i);
	    			 setAuthFontColor(sheetObjects[1], i); 	
	    	    	 htmlSheetSync(sheetObjects[1].GetSelectRow());
		   			break;
				}
			}
		 }else{
			 if (formObj.scg_flg.value=="DG2") {
			    	document.getElementById("spcl_cgo_auth_cd").disabled=false;
			    	document.getElementById("spcl_cgo_auth_cd").className="input1";
			    	comboObjects[1].SetEnable(1);
			    	document.getElementById("spcl_cgo_auth_rmk").disabled=false;
			    	document.getElementById("spcl_cgo_auth_rmk").className="input";
			 }
			 //loadPage2();
			 
			 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_cd", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_apro_cd") , 0); 
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_apro_text", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_apro_text") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "dg_cntr_seq", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "dg_cntr_seq") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "dcgo_seq", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "dcgo_seq") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rjct_cd", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rjct_cd") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "spcl_cgo_auth_rmk", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "spcl_cgo_auth_rmk") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "auth_usr_id", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "auth_usr_id") , 0);
	    	 sheetObjects[1].SetCellValue(sheetObjects[1].GetSelectRow(), "auth_gdt", sheetObjects[3].GetCellValue(sheetObjects[3].GetSelectRow(), "auth_gdt") , 0);
	    	 
			 cntrChk()
			 setAuthStat(sheetObjects[1], sheetObjects[1].GetSelectRow());
			 setAuthFontColor(sheetObjects[1], sheetObjects[1].GetSelectRow()); 		
	    	 htmlSheetSync(sheetObjects[1].GetSelectRow());
		 }
		 //htmlSheetSync(sheetObjects[1].GetSelectRow());
 		//loadPage2();
 		

 	}
 	
 	// ::DG RailBilling 2015-12-02 ::
	//Setting Special Provisions
	function setProviNo(value){
		for(var i=1 ; i < provi_length ; i++ ) {
			sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(),"imdg_spcl_provi_no"+i,"");
			document.getElementById("frm_imdg_spcl_provi_no"+i).value="";
		}
		if(value=="")	return;

		var spclProviList=value.split("|");
		var spclProviDpSeq=null;
		for(var i=1 ; i < provi_length ; i++ ) {
			for(var j=1 ; j < spclProviList.length+1 ; j++){
				spclProviDpSeq=spclProviList[j-1].split("^");
				if (i==spclProviDpSeq[1]){
					sheetObjects[3].SetCellValue(sheetObjects[3].LastRow(),"imdg_spcl_provi_no"+i,spclProviDpSeq[0]);
					document.getElementById("frm_imdg_spcl_provi_no"+i).value=spclProviDpSeq[0];
				}
			}
		}
	}
	// ::DG RailBilling 2015-12-02 ::
	function onPopupClickSpclProviCtnt(srcName){
		var formObj=document.form;
		var objName=ComGetEvent("name").replace('btn_','frm_');
		if(eval("formObj."+objName+".value")=="")
		return;
		
		ComOpenPopupWithTarget('/opuscntr/VOP_SCG_0059Pop.do?pop_type=R&imdg_spcl_provi_no='+eval("formObj."+objName+".value")+'&objName='+objName, 800, 600, objName, "1,0", true);
		
	}	

	// ::DG RailBilling 2015-12-02 Setting Special Provisions - form data -> cell data popup change ::
	
//	function set_imdg_un_no_spcl_provi_ctnt(){
//		var formObj=document.form;
//		var find_row=getEditRowNo("");
//		
//		var imdg_un_no_spcl_provi_ctnt = "";
//		var val_chg_chk = false; 
//		for(i=1; i<9; i++){
//			if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != sheetObjects[3].GetCellValue(find_row, "imdg_spcl_provi_no"+i)){
//				val_chg_chk = true;
//				break;
//			}
//		}
//		if(val_chg_chk){
//			for(i=1; i<9; i++){
//				sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i, eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//				
//				if(eval("formObj.frm_imdg_spcl_provi_no"+i+".value") != ""){
//					imdg_un_no_spcl_provi_ctnt += eval("formObj.frm_imdg_spcl_provi_no"+i+".value")+"^"+i+"|";
//					sheetObjects[3].SetCellValue(find_row, "imdg_spcl_provi_no"+i,eval("formObj.frm_imdg_spcl_provi_no"+i+".value"),0);
//				}
//			}
//			var str_length= imdg_un_no_spcl_provi_ctnt.length - 1;
//			
//			imdg_un_no_spcl_provi_ctnt = imdg_un_no_spcl_provi_ctnt.substring(0,str_length);
//			sheetObjects[3].SetCellValue(find_row, "imdg_un_no_spcl_provi_ctnt",imdg_un_no_spcl_provi_ctnt,0);
//		}
//	}
