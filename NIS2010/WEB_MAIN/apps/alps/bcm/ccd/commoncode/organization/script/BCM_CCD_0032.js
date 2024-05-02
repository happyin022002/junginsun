/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0032.js
*@FileTitle  : organization
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/31
*@history
*	2014-12-03 Chang Young Kim Release Test 수정
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
			   MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
			   THER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /** Common global variable */
	function BCM_CCD_0032(){
		this.loadPage                               = loadPage;
		this.initSheet                              = initSheet;
		this.processButtonClick                     = processButtonClick;
		this.doActionIBSheet                        = doActionIBSheet;
		this.setSheetObject                         = setSheetObject;
		this.setComboObject                         = setComboObject;
		this.doActionIBCombo                        = doActionIBCombo;
		this.sheet1_OnSearchEnd                     = sheet1_OnSearchEnd;
		this.validateForm                           = validateForm;
		this.initControl                            = initControl;
		this.obj_change                             = obj_change;
		this.obj_deactivate                         = obj_deactivate;
		this.com_change_sheet                       = com_change_sheet;
		this.isEmailAddr                            = isEmailAddr;
		this.getCOM_ENS_071_ofc_cd                  = getCOM_ENS_071_ofc_cd;                      
		this.getCOM_ENS_071_prnt_ofc_cd             = getCOM_ENS_071_prnt_ofc_cd;
		this.getCOM_ENS_071_ar_ofc_cd               = getCOM_ENS_071_ar_ofc_cd;
		this.getCOM_ENS_071_ar_ctrl_ofc_cd          = getCOM_ENS_071_ar_ctrl_ofc_cd;
		this.getCOM_ENS_071_ar_hd_qtr_ofc_cd        = getCOM_ENS_071_ar_hd_qtr_ofc_cd;
		this.getCOM_ENS_071_ap_ofc_cd               = getCOM_ENS_071_ap_ofc_cd;
		this.getCOM_ENS_071_ap_ctrl_ofc_cd          = getCOM_ENS_071_ap_ctrl_ofc_cd;
		this.getCOM_ENS_051_loc_cd                  = getCOM_ENS_051_loc_cd;
		this.getCOM_ENS_N13_ar_curr_cd              = getCOM_ENS_N13_ar_curr_cd;
		this.getCOM_ENS_N13_bil_curr_cd             = getCOM_ENS_N13_bil_curr_cd;
		this.getCOM_ENS_041_rep_cust_cd             = getCOM_ENS_041_rep_cust_cd;
		this.getCOM_ENS_0C1_vndr_cd                 = getCOM_ENS_0C1_vndr_cd;                        
		this.ofc_tp_cd_OnChange                     = ofc_tp_cd_OnChange;
		this.ofc_knd_cd_OnChange                    = ofc_knd_cd_OnChange;
		this.agn_knd_cd_OnChange                    = agn_knd_cd_OnChange;
		this.ofc_sls_delt_flg_OnChange              = ofc_sls_delt_flg_OnChange;
		this.subs_co_flg_OnChange                   = subs_co_flg_OnChange;
		this.sls_ofc_div_cd_OnChange                = sls_ofc_div_cd_OnChange;
		this.mnl_bkg_no_opt_cd_OnChange             = mnl_bkg_no_opt_cd_OnChange;
		this.so_if_cd_OnChange                      = so_if_cd_OnChange;
		this.delt_flg_OnChange                      = delt_flg_OnChange;
		this.ar_hd_qtr_ofc_cd_OnChange              = ar_hd_qtr_ofc_cd_OnChange;
		this.altn_curr_div_cd_OnChange              = altn_curr_div_cd_OnChange;
		this.ppd_pty_tp_cd_OnChangev                = ppd_pty_tp_cd_OnChangev;
		this.obj_keypress                           = obj_keypress;
		this.email                                  = email;
		this.setARCenter                            = setARCenter;
		this.setAPCenter	                        = setAPCenter;
	}

	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var create_ofc_cd='';
	/** Event handler processing by button click event */
	document.onclick=processButtonClick;   
   /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
    */
function loadPage() {
    //페이지 로드시 선처리 기능을 호출한다.
    var formObj=document.form;   
	for (i=0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);	
	}
	doActionIBCombo(sheetObjects[0], formObj, SEARCH);	
	ComSetFocus(formObj.ofc_cd);	
    initControl();
    formObj.delt_flg.Code ='N';
    //ppd_pty_tp_cd.SetSelectIndex(0, 0);
    formObj.ibflag.value="I";
    formObj.edi_if_flg.value = "N";
	// auth_tp_cd retrieve
/*	doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
	if(G_MDAA_CHK == 'Y') {
		//ComEnableObject(delt_flg, true);
		delt_flg.enable=true;
		ComSetDisplay('btn_save', true);
	} else {
		//ComEnableObject(delt_flg, false);
		delt_flg.enable=false;
		ComSetDisplay('btn_save', false);
	}*/
}		   
	/**
	  * setting sheet initial values and header
	  * param : sheetObj, sheetNo
	  * adding case as numbers of counting sheets
	  */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
     	switch(sheetObj.id) {
     	case "sheet1":
     	    with(sheetObj){
             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
             style.height = 0;
	         InitRowInfo( 1, 1, 5, 100);
	         
	         InitColumnInfo(70, 0, 0, true);
	
             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, true, true, false, false, false);

     		
	          var HeadTitle="ibflag|ofc_cd|ofc_eng_nm|intl_phn_no|ofc_phn_no|intl_fax_no|ofc_fax_no|ofc_url|ofc_rep_eml|ofc_zip_cd|ofc_addr|ofc_locl_lang_addr|ofc_tp_cd|ofc_cmmc_cd|ofc_knd_cd|agn_knd_cd|prnt_ofc_cd|"; 
	          HeadTitle=HeadTitle+"ofc_sls_delt_flg|loc_cd|fax_ip|opn_dt|clz_dt|finc_psdo_ofc_flg|doc_rcvr_hide_flg|finc_hide_flg|subs_co_flg|sls_ofc_div_cd|ofc_rfa_sc_use_flg|ofc_rmk|ar_ofc_cd|";
	          HeadTitle=HeadTitle+"ar_ctrl_ofc_cd|ar_hd_qtr_ofc_cd|ar_ctr_cd|altn_curr_div_cd|finc_rgn_cd|ob_cr_term_dys|ib_cr_term_dys|ar_curr_cd|rep_cust_cnt_cd|";
	          HeadTitle=HeadTitle+"rep_cust_seq|inv_pfx_cd|fx_curr_rt|ofc_tax_id|asa_cr_term_dys|sub_agn_flg|ar_agn_stl_cd|ap_ofc_cd|ap_ctrl_ofc_cd|ap_ctr_cd|gl_ctr_cd|comm_if_ind_cd|bil_curr_cd|";
	          HeadTitle=HeadTitle+"vndr_seq|vndr_cnt_cd|so_if_cd|delt_flg|hidden_ofc_cd|vndr_cd|rep_cust_cd|modi_ofc_cd|";
	          HeadTitle=HeadTitle+"ofc_pson_knt|usa_brk_brnc_rqst_ctrl_ofc_cd|ap_ho_acct_cd|ap_euro_curr_use_flg";

	          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	          InitHeadRow(0, HeadTitle, true);
	          
	 			     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
					 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_eng_nm" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 //InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_locl_nm" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "intl_phn_no" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_phn_no" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "intl_fax_no" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_fax_no" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_url" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_rep_eml" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_zip_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_addr" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_locl_lang_addr" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_tp_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_cmmc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_knd_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "agn_knd_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "prnt_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_sls_delt_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "loc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "fax_ip" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "opn_dt",	false,          "",      	dfDateYmd, 0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "clz_dt",	false,          "",      	dfDateYmd, 0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "finc_psdo_ofc_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "doc_rcvr_hide_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "finc_hide_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "subs_co_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "sls_ofc_div_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "mnl_bkg_no_opt_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_rfa_sc_use_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_rmk" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_ctrl_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_hd_qtr_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_ctr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "altn_curr_div_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "finc_rgn_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ob_cr_term_dys" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ib_cr_term_dys" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_curr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "rep_cust_cnt_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "rep_cust_seq" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "inv_pfx_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "fx_curr_rt" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_tax_id" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "asa_cr_term_dys" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "sub_agn_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ar_agn_stl_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ap_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ap_ctrl_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ap_ctr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "gl_ctr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "comm_if_ind_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "bil_curr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "vndr_seq" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "vndr_cnt_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "so_if_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "delt_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "hidden_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "vndr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	                 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "rep_cust_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ppd_pty_tp_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "modi_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 //InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "modi_cost_ctr_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 //InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "modi_agn_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "cre_usr_id" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "cre_dt" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "upd_usr_id" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "upd_dt" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ofc_pson_knt" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "usa_brk_brnc_rqst_ctrl_ofc_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ap_ho_acct_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "ap_euro_curr_use_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
	          		 //InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "sprt_eml_inv_flg" ,     		false,          "",      	dfNone,   0,     true,       true);

         	}
          break;
     	}
	}
	/**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @return 없음
     * @author 서미진
     * @version 2011.02.19
     */
	function processButtonClick(){
        /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
        var sheetObject1=sheetObjects[0];      
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {	
				case "btn_History":
					var tblNo = 'MDM_ORGANIZATION';
					var ofcCd = formObject.ofc_cd.value;
					var mstKey = nullToBlank(ofcCd);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Office Code");
					return false;
					}
					comMdmCallPop(tblNo, mstKey); 
	        	break;	
				case "btn_retrieve": //조회
					doActionIBSheet(sheetObject1,	formObject,	SEARCH01);
					break;
				case "btn_new": 	//New
					doActionIBSheet(sheetObject1,	formObject,	IBCLEAR);
					break;	
				case "btn_save": //저장
					doActionIBSheet(sheetObject1,	formObject,	IBSAVE);
					break;
				case "btn_Create": //Sequence generation
					doActionIBSheet(sheetObject1,	formObject, IBCREATE);
					break;	
		/*****************grid button ************************/	
				case "btn_com_ens_071_ofc_cd": 	
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ofc_cd.value +"&main_page=false"+"&mdm_yn="+ formObj.mdm_yn.value;
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_prnt_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.prnt_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_prnt_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_ar_ofc_cd":   
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ar_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ar_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_ar_ctrl_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ar_ctrl_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ar_ctrl_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_ar_hd_qtr_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ar_hd_qtr_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ar_hd_qtr_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_ap_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ap_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ap_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_071_ap_ctrl_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.ap_ctrl_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_ap_ctrl_ofc_cd", "0,0", true);
					break;
				case "btn_com_ens_051_loc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_051.do?loc_cd=" + formObj.loc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_051_loc_cd", "0,0", true);
					break;
				case "btn_com_ens_n13_ar_curr_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_N13.do?curr_cd=" + formObj.ar_curr_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 460, "getCOM_ENS_N13_ar_curr_cd", "0,0", true);
					break;	
				case "btn_com_ens_n13_bil_curr_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_N13.do?curr_cd=" + formObj.bil_curr_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 770, 460, "getCOM_ENS_N13_bil_curr_cd", "0,0", true);
					break;	
				case "btn_com_ens_041_rep_cust_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_041.do?cust_cd=" + formObj.rep_cust_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_041_rep_cust_cd", "0,0,1,1,1,1", true);
					break;	
				case "btn_com_ens_0c1_vndr_cd": 
		  			var formObj=document.form;
		         	//var sUrl="COM_ENS_0C1.do?vndr_cd=" + formObj.rep_cust_cd.value +"&main_page=false";
		  			var sUrl="COM_ENS_0C1.do?vndr_cd=" + formObj.vndr_cd.value +"&main_page=false";		         	
		         	var rVal=ComOpenPopup(sUrl, 770, 460, "getCOM_ENS_0C1_vndr_cd", "0,0,1,1,1,1", true);
					break;	
				case "btn_opn_dt_cal": //달력
		                var cal=new ComCalendar();                
		                cal.select(document.form.opn_dt, 'yyyy-MM-dd');
	                break; 
				case "btn_clz_dt_cal": //달력
		                var cal=new ComCalendar();                
		                cal.select(document.form.clz_dt, 'yyyy-MM-dd');
	                break;
				case "btn_ar_ctr_cd":
		  			var sUrl="/hanjin/COM_COM_0440.do?f_center=" + document.form.ar_ctr_cd.value+"&main_page=false";		         	
		         	var rVal=ComOpenPopup(sUrl, 500, 400, "setARCenter", "0,0", true);
		         	
	        		//var param="?f_center=" + document.form.ar_ctr_cd.value+"&main_page=false";
	        		//ComOpenPopup("COM_COM_0440.do" + param, 500, 400, "setARCenter", "0,0", true);
					break;
				case "btn_ap_ctr_cd":
	        		var param="?f_center=" + document.form.ap_ctr_cd.value;
	        		ComOpenPopup("COM_COM_0440.do" + param, 500, 400, "setAPCenter", "0,0", true);
					break;
				case "btn_gl_ctr_cd":
					var param="?f_center=" + document.form.ap_ctr_cd.value;
					ComOpenPopup("COM_COM_0440.do" + param, 500, 400, "setGLCenter", "0,0", true);
					break;
					
				case "btn_com_ens_071_usa_ofc_cd": 
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_071.do?ofc_cd=" + formObj.usa_brk_brnc_rqst_ctrl_ofc_cd.value +"&main_page=false";
		         	var rVal=ComOpenPopup(sUrl, 780, 460, "getCOM_ENS_071_usa_ofc_cd", "0,0", true);
					break;	
					
				case "btn_vndr_cd_pop":
					if(ComGetEvent().style.cursor == "default") return;
		  			var formObj=document.form;
		         	var sUrl="COM_ENS_0C1.do?mdm_yn=" + formObj.mdm_yn.value;
		         	var rVal=ComOpenPopup(sUrl, 770, 410, "getBtn_vndr_cd_pop", "0,0", true);
		        	if (formObj.vndr_seq.value !="" ){
		         	    doActionIBSheet(sheetObject1, formObj, SEARCH01);
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
	 * /handling sheet process <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>			 
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 서미진
	 * @version 2010.10.13
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
	 		//sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {	
		 	    case IBCREATE: // New retrieve
		 	    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
		 	    	ComBtnDisable('btn_Create');
		 	    	break;
	 			case IBSEARCH: // 조회
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				break;
		 		case SEARCH01: //	Office Code 정보를 조회	
		 			
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			formObj.f_cmd.value=SEARCH01;	
		 			ComOpenWait(true);
 		 			var sXml=sheetObj.GetSearchXml("BCM_CCD_0032GS.do", FormQueryString(formObj));
 		 			var arrXml = sXml.split("|$$|");
 		 			var ofcCd=ComGetEtcData(sXml, "OFC_CD");
 		 			ComOpenWait(false);
 		 			if (ofcCd != undefined) {
 						sheetObjects[0].LoadSearchXml(arrXml[0]);
 						//formObj.intl_phn_no.Code = ComGetEtcData(arrXml,"intl_phn_no"); 
 						//formObj.intl_fax_no.Code = ComGetEtcData(arrXml,"intl_fax_no"); 
	 		 			formObj.input_flg.value=ComGetEtcData(arrXml,"input_flg");
	 		 			ComSetObjValue(formObj.ofc_tp_cd, ComGetEtcData(arrXml,"ofc_tp_cd"));
	 		 			ComSetObjValue(formObj.ofc_knd_cd, ComGetEtcData(arrXml,"ofc_knd_cd"));
	 		 			ComSetObjValue(formObj.agn_knd_cd, ComGetEtcData(arrXml,"agn_knd_cd"));	 		 		
	 		 			ComSetObjValue(formObj.ofc_sls_delt_flg, ComGetEtcData(arrXml,"ofc_sls_delt_flg"));	 		 			
//	 		 			ComSetObjValue(doc_rcvr_hide_flg, ComGetEtcData(sXml,"doc_rcvr_hide_flg"));
//	 		 			ComSetObjValue(finc_hide_flg, ComGetEtcData(sXml,"finc_hide_flg"));
	 		 			ComSetObjValue(formObj.subs_co_flg, ComGetEtcData(arrXml,"subs_co_flg"));
	 		 			ComSetObjValue(formObj.sls_ofc_div_cd, ComGetEtcData(arrXml,"sls_ofc_div_cd"));
	 		 			//ComSetObjValue(formObj.mnl_bkg_no_opt_cd, ComGetEtcData(arrXml,"mnl_bkg_no_opt_cd"));
//	 		 			ComSetObjValue(ofc_rfa_sc_use_flg, ComGetEtcData(arrXml,"ofc_rfa_sc_use_flg"));	 		 			
	 		 			ComSetObjValue(formObj.sub_agn_flg, ComGetEtcData(arrXml,"sub_agn_flg"));	 		 				
	 		 			//ComSetObjValue(ap_euro_curr_use_flg, ComGetEtcData(arrXml,"ap_euro_curr_use_flg"));	 		 			
	 		 			ComSetObjValue(formObj.so_if_cd, ComGetEtcData(arrXml,"so_if_cd"));
	 		 			//ComSetObjValue(formObj.altn_curr_div_cd, ComGetEtcData(arrXml,"altn_curr_div_cd"));
	 		 			ComSetObjValue(formObj.finc_rgn_cd, ComGetEtcData(arrXml,"finc_rgn_cd"));
	 		 			ComSetObjValue(formObj.delt_flg, ComGetEtcData(arrXml,"delt_flg"));	
	 		 			ComSetObjValue(formObj.doc_rcvr_hide_flg, ComGetEtcData(arrXml,"doc_rcvr_hide_flg"));
	 		 			ComSetObjValue(formObj.ofc_rfa_sc_use_flg, ComGetEtcData(arrXml,"ofc_rfa_sc_use_flg"));
	 		 			ComSetObjValue(formObj.finc_hide_flg, ComGetEtcData(arrXml,"finc_hide_flg"));
	 		 			ComSetObjValue(formObj.finc_psdo_ofc_flg, ComGetEtcData(arrXml,"finc_psdo_ofc_flg"));
	 		 			ComSetObjValue(formObj.ap_euro_curr_use_flg, ComGetEtcData(arrXml,"ap_euro_curr_use_flg"));
	 		 			ComSetObjValue(formObj.comm_if_ind_cd, ComGetEtcData(arrXml,"comm_if_ind_cd"));
	 		 			ComSetObjValue(formObj.ar_agn_stl_cd, ComGetEtcData(arrXml,"ar_agn_stl_cd"));
	 		 			//ComSetObjValue(formObj.intl_phn_no, ComGetEtcData(arrXml,"intl_phn_no"));
	 		 			//ComSetObjValue(formObj.intl_fax_no, ComGetEtcData(arrXml,"intl_fax_no"));

	 		 			formObj.ar_hd_qtr_ofc_cd.value = ComGetEtcData(arrXml,"ar_hd_qtr_ofc_cd");
	 		 			//ComSetObjValue(formObj.ppd_pty_tp_cd, ComGetEtcData(arrXml,"ppd_pty_tp_cd"));
	 		 			// modi_ofc_cd은 콤보가 아니고 일단 Text type
//	 		 			ComSetObjValue(modi_ofc_cd, ComGetEtcData(arrXml,"modi_ofc_cd"));
	 		 			document.form.modi_ofc_cd.value = ComGetEtcData(arrXml,"modi_ofc_cd");
	 		 			document.form.old_modi_ofc_cd.value = ComGetEtcData(arrXml,"modi_ofc_cd");
	 		 			//document.form.modi_cost_ctr_cd.value = ComGetEtcData(arrXml,"modi_cost_ctr_cd");
	 		 			//document.form.modi_agn_cd.value = ComGetEtcData(arrXml,"modi_agn_cd");
	 		 			
	 		 			formObj.ibflag.value="U";
	 		 		}else { 
     					
	 		 			formObj.input_flg.value="Y";
	 		 			formObj.ibflag.value="I";
	 	                if(!ComShowConfirm(ComGetMsg("CCD00034", "Office Code"))){
	 	                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
	 	                }else{
	 	                	ComBtnDisable('btn_Create');
	 	                }
	 		 		}	
	 		 		break;				 		
	    		case SEARCH02: // MDM AUTH_TP_CD query
					var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
 					var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
					// global var setting
					G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
					G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
					break;
		 		case IBCLEAR:      // 초기화 	 
		 			formObj.reset();
		 			sheetObj.RemoveAll();
		 			formObj.ofc_cd.readOnly = false;
		 			formObj.fax_ip.value="";
		 			formObj.ofc_pson_knt.value="";
		 			formObj.gl_ctr_cd.value="";
		 			formObj.usa_brk_brnc_rqst_ctrl_ofc_cd.value="";
		 			formObj.ibflag.value = "I";
		 			formObj.edi_if_flg.value = "N";
		 			formObj.old_modi_ofc_cd.value = "";
		 			formObj.ofc_tp_cd.text = "";
		 			formObj.ofc_knd_cd.text = "";
		 			formObj.agn_knd_cd.text = "";
		 			formObj.ofc_sls_delt_flg.text = "";
		 			formObj.doc_rcvr_hide_flg.text = "";
		 			formObj.ofc_rfa_sc_use_flg.text = "";
		 			formObj.finc_hide_flg.text = "";
		 			formObj.finc_psdo_ofc_flg.text = "";
		 			formObj.ap_ho_acct_cd.text = "";
		 			formObj.comm_if_ind_cd.text = "";
		 			formObj.ar_agn_stl_cd.text = "";
		 			//formObj.intl_phn_no.text = "";
		 			//formObj.intl_fax_no.text = "";
		 			formObj.ap_euro_curr_use_flg.text = "";
		 			formObj.subs_co_flg.text = "";
		 			formObj.sls_ofc_div_cd.text = "";
		 			//formObj.mnl_bkg_no_opt_cd.text = "";
		 			formObj.sub_agn_flg.text = "";
		 			formObj.so_if_cd.text = "";
		 			formObj.delt_flg.text = "";
		 			//formObj.altn_curr_div_cd.text = "USD";
		 			formObj.finc_rgn_cd.text = "";
		 			//formObj.sprt_eml_inv_flg.text = "N";
		 			formObj.ar_hd_qtr_ofc_cd.text = "";
		 			formObj.delt_flg.Code ='N';
		 			formObj.ofc_cd.className = "input1";
		 			ComBtnEnable('btn_Create');
//		    		doc_rcvr_hide_flg.SetSelectCode("");
//		    		finc_hide_flg.SetSelectCode("");
//		    		ofc_rfa_sc_use_flg.SetSelectCode("");
		    		//ap_euro_curr_use_flg.SetSelectCode("");
		    		//ar_hd_qtr_ofc_cd.SetSelectCode(-1);
		    		//ppd_pty_tp_cd.SetSelectIndex(0, 0);wlrma
		 			//formObj.ofc_cd.focus();					
	 		 		break;			
		 		case IBSAVE: // 저장
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!ComShowCodeConfirm("COM130101", "Data")) {
					    return false;
					}

					
					formObj.vndr_seq.value =formObj.vndr_cd.value.substring(2, 7);
				    formObj.vndr_cnt_cd.value =formObj.vndr_cd.value.substring(0, 2);
		 			formObj.f_cmd.value=MULTI;
//		 			var sParam = sheetObj.GetSaveString(false, true);
//		 			sParam += "&f_cmd=" + formObj.f_cmd.value;
		 			var sParam=FormQueryString(formObj);
 		 			var sXml=sheetObj.GetSaveXml("BCM_CCD_0032GS.do", sParam);
		 			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		 			sheetObj.LoadSaveXml(sXml);
		     	    if(sav == "S"  ){
		     		  ComShowCodeMessage("COM130102", "Data");
		     		  doActionIBSheet(sheetObj, formObj, SEARCH01);
		       	    }else{
		       		  ComShowCodeMessage("COM130103", "Data");
		       	    }
 		 			
	 		 		break;
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally {
			 ComOpenWait(false);
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
   * registering IBCombo Object as list
   * adding process for list in case of needing batch processing with other items 
   * defining list on the top of source
   */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}	
    /**
     * All the combo box query
     */
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
		switch (sAction) {
			case SEARCH: // load page 시
 	     		var sXml=sheetObj.GetSearchXml("BCM_CCD_0032GS.do", "f_cmd=" + SEARCH);
				var arrXml=sXml.split("|$$|");
/*				if (arrXml.length > 0) 
					ComXml2ComboItem(arrXml[0], formObj.intl_phn_no, "cd", "cd|cd_desc");
					ComXml2ComboItem(arrXml[0], formObj.intl_fax_no, "cd", "cd|cd_desc");*/
				if (arrXml.length > 1) 
					ComXml2ComboItem(arrXml[1], formObj.ofc_tp_cd, "cd", "cd|cd_desc");
				if (arrXml.length > 2) 
					ComXml2ComboItem(arrXml[2], formObj.ofc_knd_cd, "cd", "cd|cd_desc");
				if (arrXml.length > 3) 
					ComXml2ComboItem(arrXml[3], formObj.agn_knd_cd, "cd", "cd|cd_desc");
/*				if (arrXml.length > 4) 
					ComXml2ComboItem(arrXml[4], formObj.ofc_sls_delt_flg, "cd", "cd|cd_desc");*/
				//if (arrXml.length > 5) 		
				if (arrXml.length > 6) 
					ComXml2ComboItem(arrXml[6], formObj.sls_ofc_div_cd, "cd", "cd|cd_desc");	
/*				if (arrXml.length > 8)
					ComXml2ComboItem(arrXml[8], formObj.ar_hd_qtr_ofc_cd, "cd", "cd_desc");*/
				if (arrXml.length > 10)
					ComXml2ComboItem(arrXml[10], formObj.finc_rgn_cd, "cd", "cd|cd_desc");
				if (arrXml.length > 12) {
					ComXml2ComboItem(arrXml[12], formObj.sub_agn_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[12], formObj.ap_euro_curr_use_flg, "cd", "cd");
				}
				if (arrXml.length > 13){
					ComXml2ComboItem(arrXml[13], formObj.so_if_cd, "cd", "cd|cd_desc");
					ComXml2ComboItem(arrXml[13], formObj.comm_if_ind_cd, "cd", "cd|cd_desc");
					ComXml2ComboItem(arrXml[13], formObj.ar_agn_stl_cd, "cd", "cd|cd_desc");
				}
				if(arrXml.length > 14){
					ComXml2ComboItem(arrXml[14], formObj.subs_co_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.delt_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.ofc_sls_delt_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.doc_rcvr_hide_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.ofc_rfa_sc_use_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.finc_hide_flg, "cd", "cd");
					ComXml2ComboItem(arrXml[14], formObj.finc_psdo_ofc_flg, "cd", "cd");
					
				}
     		break;
     	}
	}	
 	/**
 	 * OnSearchEnd event function <br>
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){

	    ComOpenWait(false);
	    
 		var formObj=document.form; 		
		if (sheetObj.RowCount> 0){
	 		formObj.ofc_cd.readOnly=true;
	 		formObj.ofc_cd.className = "input2";
	 		formObj.onchange_flag.value = "N";
	 		// in sheet form Object set in the contents are retrieved.
			formObj.ofc_cd.value = sheetObj.CellValue(1, "ofc_cd");
			formObj.ofc_eng_nm.value = sheetObj.CellValue(1, "ofc_eng_nm");
			//formObj.ofc_locl_nm.value = sheetObj.CellValue(1, "ofc_locl_nm");
			formObj.ofc_addr.value = sheetObj.CellValue(1, "ofc_addr");
			formObj.ofc_zip_cd.value = sheetObj.CellValue(1, "ofc_zip_cd");
			formObj.vndr_cd.value = sheetObj.CellValue(1, "vndr_seq") ;
			formObj.vndr_cnt_cd.value = sheetObj.CellValue(1, "vndr_cnt_cd");
			//formObj.intl_phn_no.value = sheetObj.CellValue(1, "intl_phn_no");
			formObj.ofc_phn_no.value = sheetObj.CellValue(1, "ofc_phn_no");
			//formObj.intl_fax_no.value = sheetObj.CellValue(1, "intl_fax_no");
			formObj.ofc_fax_no.value = sheetObj.CellValue(1, "ofc_fax_no");
			formObj.ofc_rmk.value = sheetObj.CellValue(1, "ofc_rmk");
			formObj.loc_cd.value = sheetObj.CellValue(1, "loc_cd");
			formObj.bil_curr_cd.value = sheetObj.CellValue(1, "bil_curr_cd");
			formObj.ar_curr_cd.value = sheetObj.CellValue(1, "ar_curr_cd");
			formObj.ar_ctr_cd.value = sheetObj.CellValue(1, "ar_ctr_cd");
			formObj.prnt_ofc_cd.value = sheetObj.CellValue(1, "prnt_ofc_cd");

			formObj.opn_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "opn_dt"), "ymd");
			formObj.clz_dt.value = ComGetMaskedValue(sheetObj.CellValue(1, "clz_dt"), "ymd");
			//formObj.finc_rgn_cd.value=sheetObj.CellValue(1, "finc_rgn_cd");
			formObj.ar_ofc_cd.value = sheetObj.CellValue(1, "ar_ofc_cd");
			formObj.ib_cr_term_dys.value = sheetObj.CellValue(1, "ib_cr_term_dys");
			formObj.ob_cr_term_dys.value = sheetObj.CellValue(1, "ob_cr_term_dys");
			if(sheetObj.CellValue(1, "rep_cust_cnt_cd")!=undefined){
				formObj.rep_cust_cd.value = sheetObj.CellValue(1, "rep_cust_cnt_cd")+sheetObj.CellValue(1, "rep_cust_seq");
				sheetObj.CellValue(1, "rep_cust_cd") = sheetObj.CellValue(1, "rep_cust_cnt_cd")+sheetObj.CellValue(1, "rep_cust_seq");
	 		}else{
	 			formObj.rep_cust_cd.value = "";
	 		}
			formObj.inv_pfx_cd.value=sheetObj.CellValue(1, "inv_pfx_cd");
			formObj.ap_ofc_cd.value=sheetObj.CellValue(1, "ap_ofc_cd");
			formObj.ap_ctrl_ofc_cd.value=sheetObj.CellValue(1, "ap_ctrl_ofc_cd");
			formObj.ap_ctr_cd.value=sheetObj.CellValue(1, "ap_ctr_cd");
			formObj.fx_curr_rt.value=sheetObj.CellValue(1, "fx_curr_rt");
			formObj.asa_cr_term_dys.value=sheetObj.CellValue(1, "asa_cr_term_dys");
			formObj.ofc_tax_id.value=sheetObj.CellValue(1, "ofc_tax_id");
			formObj.fax_ip.value=sheetObj.CellValue(1, "fax_ip");
			formObj.ofc_cmmc_cd.value=sheetObj.CellValue(1, "ofc_cmmc_cd");
			formObj.ofc_url.value=sheetObj.CellValue(1, "ofc_url");
			formObj.ofc_rep_eml.value=sheetObj.CellValue(1, "ofc_rep_eml");
			formObj.gl_ctr_cd.value=sheetObj.CellValue(1, "gl_ctr_cd");
			formObj.ofc_locl_lang_addr.value=sheetObj.CellValue(1, "ofc_locl_lang_addr");
			//formObj.ppd_pty_tp_cd.value=sheetObj.CellValue(1, "ppd_pty_tp_cd");
			formObj.modi_ofc_cd.value=sheetObj.CellValue(1, "modi_ofc_cd");
			formObj.cre_usr_id.value=sheetObj.CellValue(1, "cre_usr_id");
			formObj.cre_dt.value=sheetObj.CellValue(1, "cre_dt").substring(0, 19);
			formObj.upd_usr_id.value=sheetObj.CellValue(1, "upd_usr_id");
			formObj.upd_dt.value=sheetObj.CellValue(1, "upd_dt").substring(0, 19);
			
			formObj.ofc_pson_knt.value=sheetObj.CellValue(1, "ofc_pson_knt");
			formObj.usa_brk_brnc_rqst_ctrl_ofc_cd.value=sheetObj.CellValue(1, "usa_brk_brnc_rqst_ctrl_ofc_cd");
			formObj.ap_ho_acct_cd.value=sheetObj.CellValue(1, "ap_ho_acct_cd");
			formObj.comm_if_ind_cd.value=sheetObj.CellValue(1, "comm_if_ind_cd");
			formObj.ar_agn_stl_cd.value=sheetObj.CellValue(1, "ar_agn_stl_cd");
/*			formObj.ap_euro_curr_use_flg.value=sheetObj.CellValue(1, "ap_euro_curr_use_flg");
			formObj.finc_hide_flg.value=sheetObj.CellValue(1, "finc_hide_flg");
			formObj.doc_rcvr_hide_flg.value=sheetObj.CellValue(1, "doc_rcvr_hide_flg");
			formObj.ofc_rfa_sc_use_flg.value=sheetObj.CellValue(1, "ofc_rfa_sc_use_flg");
			formObj.finc_psdo_ofc_flg.value=sheetObj.CellValue(1, "finc_psdo_ofc_flg");*/

			ComBtnEnable('btn_Create');
		}
			//formObj.sprt_eml_inv_flg.value=sheetObj.CellValue(1, "sprt_eml_inv_flg");
		
 	}	
    /**
     * handling process for input validation <br>
     */
 	function validateForm(sheetObj, formObj, sAction) {
    	 switch (sAction) {
	    	 case SEARCH01: // retrieve
	    		// Office Code is null
		    	 if(formObj.ofc_cd.value == "") {
						ComShowCodeMessage('CCD00001',"Office Code"); 
						ComSetFocus(document.form.ofc_cd);					
						return false;
					}
	    	 	break;
	    	 case IBSAVE: // save
	             if(formObj.onchange_flag.value != "Y") {
	                 ComShowCodeMessage("COM130503");
	                 return;
	              }
	             
	    		// Office Code is null
		    	 if(formObj.ofc_cd.value == "") {
						ComShowCodeMessage('CCD00001',"Office Code"); 
						ComSetFocus(document.form.ofc_cd);					
						return false;
					}
	    		 //English Name is null
	    		 if(formObj.ofc_eng_nm.value == "") {
						ComShowCodeMessage('CCD00001',"English Name"); 
						ComSetFocus(document.form.ofc_eng_nm);					
						return false;
					}
	    		// Tel. No is null
/*	    		 if(formObj.intl_phn_no.value == "") {
						ComShowCodeMessage('CCD00001',"Tel. No"); 
						ComSetFocus(document.form.intl_phn_no);					
						return false;
					}*/
	    		// Tel. No is null
	    		 if(formObj.ofc_phn_no.value == "") {
						ComShowCodeMessage('CCD00001',"Tel. No"); 
						ComSetFocus(document.form.ofc_phn_no);					
						return false;
					}
		    	// Address is null
	    		 if(formObj.ofc_addr.value == "") {
						ComShowCodeMessage('CCD00001',"Address"); 
						ComSetFocus(document.form.ofc_addr);
						return false;
					}
	          	//Office Type is null
	          	if(formObj.ofc_tp_cd.Code==""){
	          		ComShowCodeMessage('CCD00001',"Office Type");
      				ComSetFocus(document.form.ofc_tp_cd);
	          		return false;
	          	}else if (formObj.ofc_tp_cd.Code== "BA"){
	          			if (formObj.agn_knd_cd.Code== ""){
	          				ComShowCodeMessage('CCD00001',"Agent Type"); 
	          				ComSetFocus(document.form.ofc_tp_cd);
	          				return false;
	          			}else if (formObj.agn_knd_cd.Code== " "){
	          				ComShowCodeMessage('CCD00001',"Agent Type");
	          				ComSetFocus(document.form.ofc_tp_cd);
	          				return false;
	          			}
	           	}
	          	//Office Kind is null
	          	if(formObj.ofc_knd_cd.Code==""){
	          		ComShowCodeMessage('CCD00001',"Office Kind");
      				ComSetFocus(document.form.ofc_knd_cd);
	          		return false;
	          	}
	          	
	            //ALPS Security DIV is null
    		    if(formObj.sls_ofc_div_cd.value == "") {
					ComShowCodeMessage('CCD00001',"ALPS Security DIV"); 
					ComSetFocus(document.form.sls_ofc_div_cd);
					return false;
				}
	          //Location Code is null
	    		 if(formObj.loc_cd.value == "") {
						ComShowCodeMessage('CCD00001',"Location Code"); 
						ComSetFocus(document.form.loc_cd);
						return false;
					}
	    	      //A/R Regional HQ is null
	    	     if(formObj.ofc_tp_cd.Code!= "HO"){
	    	    	 if(formObj.ar_hd_qtr_ofc_cd.value== "") {
	    				ComShowCodeMessage('CCD00001',"A/R Regional HQ");
						ComSetFocus(document.form.ar_hd_qtr_ofc_cd);
						return false;
	    	    	 }else if (formObj.ar_hd_qtr_ofc_cd.value== "")	 {
						ComShowCodeMessage('CCD00001',"A/R Regional HQ");
						ComSetFocus(document.form.ar_hd_qtr_ofc_cd);
						return false;
	    	    	 }
	    	     }
	    	     
	    	     if (formObj.modi_ofc_cd.value == "") {
					ComShowCodeMessage('CCD00001', "Legacy Code");
					ComSetFocus(document.form.modi_ofc_cd);
					return false;
				 }

/*				 if (formObj.modi_cost_ctr_cd.value == "") {
					ComShowCodeMessage('CCD00001', "Sakura CTR Code");
					ComSetFocus(document.form.modi_cost_ctr_cd);
					return false;
				 }*/

/*				 if (formObj.modi_agn_cd.value == "") {
					ComShowCodeMessage('CCD00001', "Sakura Agent Code");
					ComSetFocus(document.form.modi_agn_cd);
					return false;
				 }*/
	    	     
	    	     if (formObj.modi_ofc_cd.value != formObj.old_modi_ofc_cd.value) {
	    	    	 formObj.edi_if_flg.value = "Y";
	    	     } else {
	    	    	 formObj.edi_if_flg.value = "N";
	    	     }
	    		 break;
    	 }
 		return true;
 	}	
    /**
     * Axon  EVENT Catch.<br>
     */    
      function initControl() {
    	var formObj=document.form;
    	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
 		axon_event.addListenerForm('change', 'obj_change', formObj);
 		axon_event.addListener('blur', 'isEmailAddr', 'ofc_rep_eml');
          //Axon event handling catch            
//        axon_event.addListenerForm('keydown', 'obj_deactivate', document.form);   
// 		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	);
 		//axon_event.addListener('blur', 'isIpAddr', 'fax_ip');
 		//Only English 
/* 		ComClearSeparator (document.form.ofc_eng_nm,"eng"); 
 		ComClearSeparator (document.form.ofc_url,"eng"); 
 		//ComClearSeparator (document.form.ofc_rep_eml,"eng");
 		ComClearSeparator (document.form.ofc_cmmc_cd,"eng");*/
      } 
      /**
       * If the event data fields to be CHANGE
       */
      function obj_change(){
    	  document.form.onchange_flag.value = "Y";
      	  var formObject=document.form;
      	  /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
      		try {
      		var srcName=ComGetEvent("name");
              switch(srcName) {                
	              	case "ofc_cd":	              	
	              		if(formObject.ofc_cd.value.length > 0){	              			
	        		        doActionIBSheet(sheetObject1, formObject, SEARCH01);
	              		}
	              		break;
	              	case "prnt_ofc_cd":
	              		if(formObject.prnt_ofc_cd.value.length>0){	
	              			formObject.f_cmd.value=SEARCH02;
	    		 			var sParam="f_cmd="+formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.prnt_ofc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	        		        if(hidden_ofc_cd == ""){
	        		        	formObject.prnt_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Parent Office"); 		
	        		        	ComSetFocus(document.form.prnt_ofc_cd);		
	        		        } 
	              		}
	              		break;
	              	case "ar_ofc_cd":
	              		if(formObject.ar_ofc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH02;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.ar_ofc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.ar_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/R Office"); 	
	        		        	ComSetFocus(document.form.ar_ofc_cd);		
	        		        }     
	              		}
	              		break;
	              	case "usa_brk_brnc_rqst_ctrl_ofc_cd":
	              		if(formObject.usa_brk_brnc_rqst_ctrl_ofc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH02;
	              			var sParam="f_cmd="       +formObject.f_cmd.value
	              			+ "&hidden_ofc_cd=" +formObject.usa_brk_brnc_rqst_ctrl_ofc_cd.value;
	              			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	              			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	              			if(hidden_ofc_cd == ""){
	              				formObject.usa_brk_brnc_rqst_ctrl_ofc_cd.value="";
	              				ComShowCodeMessage("COM130402", "A/R Office"); 	
	              				ComSetFocus(document.form.ar_ofc_cd);		
	              			}     
	              		}
	              		break;
//	              	case "ar_ctrl_ofc_cd":
//	              		if(formObject.ar_ctrl_ofc_cd.value.length>0){
//	              			formObject.f_cmd.value=SEARCH02;
//	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
//	    		 						+ "&hidden_ofc_cd=" +formObject.ar_ctrl_ofc_cd.value;
// 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
//	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
//	    		 			 if(hidden_ofc_cd == ""){
//	        		        	formObject.ar_ctrl_ofc_cd.value="";
//	        		        	ComShowCodeMessage("COM130402", "A/R Control Office"); 	
//	        		        	ComSetFocus(document.form.ar_ctrl_ofc_cd);	
//	        		        }    
//	              		}
//	              		break;
	              	case "ar_hd_qtr_ofc_cd":
	              		if(formObject.ar_hd_qtr_ofc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH02;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.ar_hd_qtr_ofc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.ar_hd_qtr_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/R Regional HQ"); 	
	        		        	ComSetFocus(document.form.ar_hd_qtr_ofc_cd);
	        		        }      		        
	              		}
	              		break;
	              	case "ap_ofc_cd":
	              		if(formObject.ap_ofc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH02;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.ap_ofc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.ap_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/P Office"); 	
	        		        	ComSetFocus(document.form.ap_ofc_cd);		
	        		        }    
	              		}
	              		break;
	              	case "ap_ctrl_ofc_cd":
	              		if(formObject.ap_ctrl_ofc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH02;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.ap_ctrl_ofc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.ap_ctrl_ofc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/P Control Office"); 	
	        		        	ComSetFocus(document.form.ap_ctrl_ofc_cd);		
	        		        }   
	              		}
	              		break;
	              	case "loc_cd":
	              		if(formObject.loc_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH03;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.loc_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.loc_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Location Code"); 	
	        		        	ComSetFocus(document.form.loc_cd);		
	        		        }   
	              		}
	              		break;
	              	case "ar_curr_cd":
	              		if(formObject.ar_curr_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH04;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.ar_curr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.ar_curr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/R Currency"); 	
	        		        	ComSetFocus(document.form.ar_curr_cd);		
	        		        }   
	              		}
	              		break;
	              	case "bil_curr_cd":
	              		if(formObject.bil_curr_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH04;
	    		 			var sParam="f_cmd="       +formObject.f_cmd.value
	    		 						+ "&hidden_ofc_cd=" +formObject.bil_curr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd=ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.bil_curr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/P Currency"); 	
	        		        	ComSetFocus(document.form.bil_curr_cd);		
	        		        }   
	              		}
	              		break;
	              	case "rep_cust_cd":
	              		if(formObject.rep_cust_cd.value.length>0){
	              			if(formObject.rep_cust_cd.value.length!=8 || !ComIsNumber(formObject.rep_cust_cd.value.substring(3,6))){
	        		        	formObject.rep_cust_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Rep. Customer Code"); 	
	        		        	ComSetFocus(document.form.rep_cust_cd);	
	        		        	return false;
	              			}
	              			formObject.f_cmd.value=SEARCH05;
	    		 			var sParam="f_cmd="+formObject.f_cmd.value + "&hidden_ofc_cd=" +formObject.rep_cust_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd = ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ofc_cd == ""){
	        		        	formObject.rep_cust_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "Rep. Customer Code"); 	
	        		        	ComSetFocus(document.form.rep_cust_cd);		
	        		        }   
	              		}
	              		break;
	              	case "vndr_cd":
	              		if(formObject.vndr_cd.value.length>0){
	              			//var vndrSeq = formObject.vndr_cd.value.substring(0, 2);
	              			//var vndrCntCd = formObject.vndr_cd.value.substring(2, 7);
	    		 			var sParam = "f_cmd="+SEARCH06+"&hidden_ofc_cd=" +formObject.vndr_cd.value;
	    		 			var sParam2 = "f_cmd="+ SEARCH07+ "&hidden_ofc_cd=" +formObject.vndr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ofc_cd = ComGetEtcData(sXml, "result");	
	    		 			var sXml2 = sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam2);
	    		 			sheetObjects[0].CellValue(1, "vndr_cnt_cd") =ComGetEtcData(sXml2, "result");
	    		 			formObject.vndr_cnt_cd.value = ComGetEtcData(sXml2, "result");
	    		 			if(hidden_ofc_cd == undefined||hidden_ofc_cd == ""){
	        		        	formObject.vndr_cd.value="";
	        		        	sheetObjects[0].CellValue(1, "vndr_cnt_cd") = "";
	        		        	formObject.vndr_cnt_cd.value ="";
	        		        	ComShowCodeMessage("COM130402", "Vendor Code"); 	
	        		        	ComSetFocus(document.form.vndr_cd);		
	        		        }
	              		}else{
	              			sheetObjects[0].CellValue(1, "vndr_cnt_cd") ="";
	              			formObject.vndr_cnt_cd.value ="";
	              		}
	              		break;
	              	case "ar_ctr_cd":	
	              		if(formObject.ar_ctr_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH08;
	    		 			var sParam="f_cmd="+formObject.f_cmd.value + "&hidden_ctr_cd=" +formObject.ar_ctr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ctr_cd = ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ctr_cd == ""){
	        		        	formObject.ar_ctr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/R Center Code"); 	
	        		        	ComSetFocus(document.form.ar_ctr_cd);		
	        		        }   
	              		}
	              		break;
	              	case "ap_ctr_cd":		
	              		if(formObject.ap_ctr_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH08;
	    		 			var sParam="f_cmd="+formObject.f_cmd.value + "&hidden_ctr_cd=" +formObject.ap_ctr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ctr_cd = ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ctr_cd == ""){
	        		        	formObject.ap_ctr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "A/P Center Code"); 	
	        		        	ComSetFocus(document.form.ap_ctr_cd);		
	        		        }   
	              		}
	              		break;
	              	case "gl_ctr_cd":	
	              		if(formObject.gl_ctr_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH08;
	    		 			var sParam="f_cmd="+formObject.f_cmd.value + "&hidden_ctr_cd=" +formObject.gl_ctr_cd.value;
 	    		 			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	    		 			var hidden_ctr_cd = ComGetEtcData(sXml, "result");
	    		 			 if(hidden_ctr_cd == ""){
	        		        	formObject.ar_ctr_cd.value="";
	        		        	ComShowCodeMessage("COM130402", "G/L Center Code"); 	
	        		        	ComSetFocus(document.form.gl_ctr_cd);		
	        		        }   
	              		}
	              		break;
	              	case "ap_ho_acct_cd":	
	              		if(formObject.ap_ho_acct_cd.value.length>0){
	              			formObject.f_cmd.value=SEARCH09;
	              			var sParam="f_cmd="+formObject.f_cmd.value + "&hidden_acct_cd=" +formObject.ap_ho_acct_cd.value;
	              			var sXml=sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam);
	              			var hidden_acct_cd = ComGetEtcData(sXml, "result");
	              			if(hidden_acct_cd == ""){
	              				formObject.ap_ho_acct_cd.value="";
	              				ComShowCodeMessage("COM130402", "A/P Head Office Account"); 	
	              				ComSetFocus(document.form.ap_ho_acct_cd);		
	              			}   
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
       * Onbeforedeactivate  event handling. <br>
       */   
       function obj_deactivate() {
           var formObj=document.form;
           var sheetObj=sheetObjects[0];   
           var eleName=event.srcElement.name;
           switch(eleName){     
           		case "fx_curr_rt":
           			ComChkObjValid(event.srcElement);         			
           			com_change_sheet( sheetObj, eleName );
               default:      
            	   com_change_sheet( sheetObj, eleName );
           }          
       }  
   /**
    * When you change the value of the hidden Sheet Html Object to reflect the changed value.<br>
    * Value is stored using a hidden sheet.<br>
    */  
    function com_change_sheet( sheetObj, colNm ){
    	var formObj=document.form;
        var eleValue="";
        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                default:
                    eleValue=document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.CellValue(1, colNm) = eleValue;
        }else{
            sheetObj.CellValue(1,colNm) = document.getElementById(colNm).value;
        }
    }
    
    /**
     * COM_ENS_071 : Values ​​are selected from a pop-up
     */
    function getCOM_ENS_071_ofc_cd(rowArray) {
    	var formObj=document.form;
    	var colArray=rowArray[0];
    	formObj.ofc_cd.value=colArray[1];
    	doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
		com_change_sheet( sheetObjects[0], "ofc_cd" );
		document.form.onchange_flag.value = "Y";
    }	
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_prnt_ofc_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.prnt_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "prnt_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    }
    /**
     * COM_ENS_071 :Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_ar_ofc_cd(rowArray) {  
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ar_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ar_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    }
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
      */
    function getCOM_ENS_071_ar_ctrl_ofc_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ar_ctrl_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ar_ctrl_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    }
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_ar_hd_qtr_ofc_cd(rowArray) {    
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ar_hd_qtr_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ar_hd_qtr_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    }   
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_usa_ofc_cd(rowArray) {    
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	ar_hd_qtr_ofc_cd.value=colArray[1];		
    	com_change_sheet( sheetObjects[0], "usa_brk_brnc_rqst_ctrl_ofc_cd" );	
    	document.form.onchange_flag.value = "Y";
    }   
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_ap_ofc_cd(rowArray) {    
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ap_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ap_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    } 
    /**
     * COM_ENS_071 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_071_ap_ctrl_ofc_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ap_ctrl_ofc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ap_ctrl_ofc_cd" );	
		document.form.onchange_flag.value = "Y";
    }    
    /**
     * COM_ENS_071 :Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_051_loc_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.loc_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "loc_cd" );	
		document.form.onchange_flag.value = "Y";
    }  
    /**
     * COM_ENS_N13 :Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_N13_ar_curr_cd(rowArray) { 
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.ar_curr_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "ar_curr_cd" );	
		document.form.onchange_flag.value = "Y";
    } 
    /**
     * COM_ENS_N13 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_N13_bil_curr_cd(rowArray) {       	
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.bil_curr_cd.value=colArray[1];		
		com_change_sheet( sheetObjects[0], "bil_curr_cd" );	
		document.form.onchange_flag.value = "Y";
    } 
    /**
     * COM_ENS_041 : Check the selection in the pop-up a multi-input hangyeongwoo one at a row
     */
    function getCOM_ENS_041_rep_cust_cd(rowArray) {   
    	var formObj=document.form;
    	var colArray=rowArray[0];	
    	formObj.rep_cust_cd.value=colArray[3];		
		com_change_sheet( sheetObjects[0], "rep_cust_cd" );	
		document.form.onchange_flag.value = "Y";
    } 
    /**
     * COM_ENS_0C1 : Vendor code 
     */
   function getCOM_ENS_0C1_vndr_cd(rowArray, row, col) {   
   	var formObj=document.form;
	var colArray=rowArray[0];	
	formObj.vndr_cd.value=colArray[2];		
	sheetObjects[0].SetCellValue(1, "vndr_cnt_cd",colArray[7]);
	com_change_sheet( sheetObjects[0], "vndr_cd" );
	document.form.onchange_flag.value = "Y";
    } 
   

   
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function ofc_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		ofc_tp_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "ofc_tp_cd" );
    }*/    
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function ofc_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		ofc_knd_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "ofc_knd_cd" );
    }    */
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function agn_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		agn_knd_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "agn_knd_cd" );
    } */   
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function ofc_sls_delt_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		ofc_sls_delt_flg.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "ofc_sls_delt_flg" );
    }    */
//    /**
//     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
//     * The changes com_change_sheet () function should be reflected in Sheet. <br>
//     */     
//    function doc_rcvr_hide_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
//        var formObj=document.form;
//        var sheetObj=sheetObjects[0];
//        var arrText=text.split("|");
//    	if (arrText != null && arrText.length > 1) {
//    		doc_rcvr_hide_flg.SetSelectCode(-1);
//    	}
//        com_change_sheet( sheetObj, "doc_rcvr_hide_flg" );
//    }  
//    /**
//     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
//     * The changes com_change_sheet () function should be reflected in Sheet. <br>
//     */     
//    function finc_hide_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
//        var formObj=document.form;
//        var sheetObj=sheetObjects[0];
//        var arrText=text.split("|");
//    	if (arrText != null && arrText.length > 1) {
//    		finc_hide_flg.SetSelectCode(-1);
//    	}
//        com_change_sheet( sheetObj, "finc_hide_flg" );
//    }  
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function subs_co_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		subs_co_flg.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "subs_co_flg" );
    } */ 
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function sls_ofc_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		sls_ofc_div_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "sls_ofc_div_cd" );
    }  */
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function mnl_bkg_no_opt_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		mnl_bkg_no_opt_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "mnl_bkg_no_opt_cd" );
    }  */
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function so_if_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		so_if_cd.SetSelectCode(-1);
    	}
        com_change_sheet( sheetObj, "so_if_cd" );
    }*/  
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
   function delt_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
			document.form.onchange_flag.value = "Y";
    }
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */
/*    function ar_hd_qtr_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
     		ar_hd_qtr_ofc_cd.SetSelectCode(-1);
     	}
         com_change_sheet( sheetObj, "ar_hd_qtr_ofc_cd" );
    } //comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode
*/
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */
/*    function altn_curr_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		altn_curr_div_cd.SetSelectCode(-1);
     	}
         com_change_sheet( sheetObj, "altn_curr_div_cd" );
    } //comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode
*/
    /**
     * IBMulti Combo Item's selected the events that occur when changes are made.<br>
     * The changes com_change_sheet () function should be reflected in Sheet. <br>
     */     
/*    function ppd_pty_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var arrText=text.split("|");
      	if (arrText != null && arrText.length > 1) {
      		ppd_pty_tp_cd.SetSelectCode(-1);
      	}
        com_change_sheet( sheetObj, "ppd_pty_tp_cd" );
    }*/
    /**
     * OnKeyPress event handling. <br>
     */     
    function obj_keypress() {	   
    	obj=ComGetEvent();
		keyValidation(obj);
        var formObj=document.form;
        var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "opn_dt":						
        		checkDateForm(formObj.opn_dt);
        		break;
        	case "clz_dt":				
        		checkDateForm(formObj.clz_dt);
        		break;
        }
   } 
   function email() {
	   ComKeyOnlyAlphabet('num', "45|46|64|95");
   }
	/**
	 * Center 조회 후 값 Return 받아 셋팅한다.
	 */
	function setARCenter(aryPopupData) {
		if(aryPopupData[0][1] =="Center") return;
	    document.form.ar_ctr_cd.value=aryPopupData[0][1];
	    document.form.onchange_flag.value = "Y";
	}
	/**
	 * Center 조회 후 값 Return 받아 셋팅한다.
	 */
	function setAPCenter(aryPopupData) {
		if(aryPopupData[0][1] =="Center") return;
	    document.form.ap_ctr_cd.value=aryPopupData[0][1];
	    document.form.onchange_flag.value = "Y";
	}
	function setGLCenter(aryPopupData) {
		if(aryPopupData[0][1] =="Center") return;
		document.form.gl_ctr_cd.value=aryPopupData[0][1];
		document.form.onchange_flag.value = "Y";
	}
	function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
		document.form.onchange_flag.value = "N";
	    ComOpenWait(false);
	}
	
	   /**
	    * COM_COM_0007 : Vendor code
	    */
	function getBtn_vndr_cd_pop(rowArray) {    	
	   	var formObj=document.form;
	   	var colArray=rowArray[0];	
	   	formObj.vndr_cd.value=colArray[2];
	    var sheetObject1=sheetObjects[0];
	    var vndrCd = formObj.vndr_cd.value;
		if (vndrCd !=""){
			var sParam2 = "f_cmd="+ SEARCH07+ "&hidden_ofc_cd=" +vndrCd;
 			var sXml2 = sheetObject1.GetSearchXml("BCM_CCD_0032GS.do", sParam2);
 			sheetObjects[0].CellValue(1, "vndr_cnt_cd") =ComGetEtcData(sXml2, "result");
 			formObj.vndr_cnt_cd.value = ComGetEtcData(sXml2, "result");
		}	
	}
	
/*	function intl_phn_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
    }
	function intl_fax_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}*/
	function ofc_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function ofc_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function ofc_sls_delt_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function doc_rcvr_hide_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function ofc_rfa_sc_use_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function subs_co_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function sls_ofc_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function finc_hide_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function agn_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function finc_psdo_ofc_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function ar_hd_qtr_ofc_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function finc_rgn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function sub_agn_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function so_if_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function comm_if_ind_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	function ap_euro_curr_use_flg_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	
	function ar_agn_stl_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, text, code) {
		document.form.onchange_flag.value = "Y";
	}
	
