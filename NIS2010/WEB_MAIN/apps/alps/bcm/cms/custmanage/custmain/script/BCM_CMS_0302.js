/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CMS_0302.js
*@FileTitle  : Customer 
*@author     : Hipluscard
*@version    : 1.0
*@since      : 2017/06/07
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
		       MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
		       OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    function BCM_CMS_0302() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl; 
    	this.doActionIBSheet 		= doActionIBSheet;
		this.obj_keypress_loc       = obj_keypress_loc;
		this.obj_keyup              = obj_keyup;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initTab                = initTab;
    	this.tab3_OnChange          = tab3_OnChange;
    	this.ida_ste_cd_OnChange    = ida_ste_cd_OnChange;
    }

    /** Common global variable */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	
    var tabObjects = new Array(); 
    var tabCnt = 0 ; 
    //var beforetab_trob = 1; 
    
    var x_sheetObject1 = null;
    var x_sheetObject2 = null;
    var x_sheetObject3 = null;
    var x_sheetObject4 = null;
    var x_sheetObject5 = null;
    
    var bkg_alt_fm_dt_old = null;
    var bkg_alt_to_dt_old = null;
    var nvocc_bd_st_eff_dt_old = null;
    var nvocc_bd_end_eff_dt_old = null;
    var sls_delt_eff_dt = null;
    
    var typeListXml = new Array();
	
	/** Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name */
	function processButtonClick() {
		/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		/** **************************************************** */
		var formObj=document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
				//if(window.event.srcElement.style.cursor == "default") return;
			switch (srcName) {
			case "btn_Retrieve":
				formObj.creflag.value="N";
				doActionIBSheet(sheetObject,formObj,SEARCH);
				break;
			case "btn_Save":  
			    doActionIBSheet(sheetObjects[0],formObj,MULTI); 
			    formObj.cust_cd.readOnly=false;
				break;
			case "btn_GstSave":  
			    doActionIBSheet(sheetObjects[0],formObj,MULTI01); 
			    formObj.cust_cd.readOnly=false;
				break;
			case "btn_Close":
				self.close();
				break;
			case "btn_New":
				formObj.cust_cd.style.backgroundColor="#d4f6ff";
				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
				formObj.cust_cd.value="";
 				formObj.creflag.value="N";
 				formObj.saveflag.value="N";
 				formObj.cust_cd.readOnly=false;
 				formObj.bzet_addr.readOnly=false;
 				formObj.bzet_addr.style.backgroundColor="#d4f6ff";
 				formObj.srep_cd.readOnly=false;
 				ComBtnEnable("btn_Create");
 				ComBtnDisable("btn_Save");
 				ComBtnDisable("t2_btn_t3bAdd");
 				ComBtnDisable("t2_btn_t4bAdd");
 				ComBtnDisable("t2_btn_t5bAdd");
 				ComBtnEnable("btn_com_ens_041");
 				ComImageChange("btn_com_ens_043","img/btns_search.gif",false);
			    break;	
			/*case "btn_CheckDup":
			    param=param + "&cust_cnt_cd=" + formObj.cust_cnt_cd.value+" &cust_nm=" + formObj.cust_lgl_eng_nm.value+"&loc_cd=" 
				              + formObj.loc_cd.value+" &cust_rgst_no=" + formObj.cust_rgst_no.value;
				var rtn=ComOpenPopup('/hanjin/BCM_CMS_0304.do?' + param, 780, 470, '', '0,0', true); 
				break;*/
			case "btn_com_ens_041":
				//if(formObj.creflag.value != "Y"){
				   var param="";
   	    	  	   //param=param + "&" + "cust_seq=" + form.cust_seq.value+"&mdm_yn="+ formObj.mdm_yn.value;
	    		   ComOpenPopup('/hanjin/COM_ENS_041.do?' + param, 780, 500, 'setCallBack0B2', '1,0,1,1,1,1,1,1', true);
				//}
				break;
			case "btn_com_ens_0M1": // country pop-up
				var param="";
	    		param=param + "&" + "cust_cnt_cd=" + form.cust_cnt_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0M1.do?' + param, 780, 470, 'setCallBack0B5', '1,0,1,1,1,1,1,1', true);
				break;
             case "btn_com_ens_051": // location pop-up
				var param="";
	    		param=param + "&" + "loc_cd=" + form.loc_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_051.do?' + param, 780, 470, 'setCallBack0B1', '1,0,1,1,1,1,1,1', true);
				break;
             case "btn_com_ens_071": // office pop-up
 				var param="";
 	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
 	    		ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
 				break;
             case "btn_com_ens_0C1": // vendor pop-up
  				var param="";
  	    		param=param + "&" + "vndr_seq=" + form.vndr_seq.value;
  	    		ComOpenPopup('/hanjin/COM_ENS_0C1.do?' + param, 780, 540, 'setCallBack0B4', '1,0,1,1,1,1,1,1', true);
  				break;
             case "btn_com_ens_n13": // currency pop-up
   				var param="";
   	    		param=param + "&" + "curr_cd=" + form.capi_curr_cd.value;
   	    		ComOpenPopup('/hanjin/COM_ENS_N13.do?' + param, 700, 500, 'setCallBack0B6', '1,0,1,1,1,1,1,1', true);
   				break;
 			case "btn_BCM_CMS_0301": //group customer pop-up
				var param="";	
	    		param=param + "cust_grp_id=" + form.cust_grp_id.value;	    		
	    		ComOpenPopup('/hanjin/BCM_CMS_0301.do?' + param, 780, 430, 'setCustGrpId', '1,0,1,1,1,1,1,1', true);				
				break;
            /*case "btn_com_ens_0G1":
    			var param="";
    			ComOpenPopup('/hanjin/COM_ENS_0G1.do', 600, 430, 'setCallBack0B9', "1,0,1", true);
    			break;*/
            case "btn_com_ens_043": // sales rep
			   var param="";
			   if(!form.btn_com_ens_043.disabled)
				   ComOpenPopup('/hanjin/COM_ENS_043.do?' + param, 780, 400, 'setCallBack0B7', '1,0,1,1,1,1,1,1', true);
    		   break;
     		case "bkg_alt_date":
    			var cal = new ComCalendarFromTo();
    			cal.select(document.form.bkg_alt_fm_dt, document.form.bkg_alt_to_dt,'yyyy-MM-dd');
    			break;
     		case "nvocc_bd_eff_date":
    			var cal = new ComCalendarFromTo();
    			cal.select(document.form.nvocc_bd_st_eff_dt, document.form.nvocc_bd_end_eff_dt,'yyyy-MM-dd');
    			break;
    			
     		case "sls_delt_eff_date":
     			var cal = new ComCalendar();
    			cal.select(document.form.sls_delt_eff_dt,'yyyyMMdd');
    			break;
    			
     		case "btn_t2BLRider":
     			if(formObj.loc_cd.value.substr(0,2) == "IN" && formObj.ida_spcl_ecn_zn_ut_flg.value == 'Y'){
     				doActionIBSheet(sheetObjects[0],document.form,MULTI03);  
     			}
                break;
                
     		case "btn_t2Del":
     			if(formObj.loc_cd.value.substr(0,2) == "IN"){
	     			formObj.file_nm.value = "";
	     			formObj.file_sav_id.value = "delete";
	     			setFileNm("");
     			}
     			break;
    			
            case "btn_Create":
 				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 				formObj.cust_cd.value="";
 				formObj.creflag.value="Y";
 			    formObj.saveflag.value="N";
 			    formObj.bzet_addr.readOnly=false;
 			    formObj.bzet_addr.style.backgroundColor="#d4f6ff";
 				formObj.cust_cd.readOnly=true;
 				formObj.cust_cd.style.backgroundColor="#bebebe";
 				formObj.srep_cd.readOnly=false;
 				ComBtnDisable("btn_Create");
 				ComBtnDisable("t2_btn_t3bAdd");
 				ComBtnDisable("t2_btn_t4bAdd");
 				ComBtnDisable("t2_btn_t5bAdd");
 				ComBtnDisable("btn_com_ens_041");
 				ComBtnEnable("btn_Save");
 				ComImageChange("btn_com_ens_043","img/btns_search.gif",false);
 			    break;
             case "t2_btn_t3bAdd":
				x_sheetObject2.DataInsert(-1);   
				break;
             case "t2_btn_t3bDel":
            	var nRow = x_sheetObject2.CheckedRows("del_chk");
				if (nRow <= 0) {
					ComShowCodeMessage("SAM00023");
					return false;
				} else {
					if (ComShowConfirm(ComGetMsg("SAM00014"))) { 
						ComRowHideDelete(x_sheetObject2, "del_chk");
					} else {
						return false;
					}
				}
            	break;
             case "t2_btn_t4bAdd":
				x_sheetObject3.DataInsert(-1);   
				break;
             case "t2_btn_t4bDel":
             	var nRow = x_sheetObject3.CheckedRows("del_chk");
 				if (nRow <= 0) {
 					ComShowCodeMessage("SAM00023");
 					return false;
 				} else {
 					if (ComShowConfirm(ComGetMsg("SAM00014"))) { 
 						ComRowHideDelete(x_sheetObject3, "del_chk");
 					} else {
 						return false;
 					}
 				}
             	break;
             case "t2_btn_t5bAdd":
				var rowj = x_sheetObject4.DataInsert(-1);   
				x_sheetObject4.CellEditable(rowj, "srep_cd") = true;
				x_sheetObject4.SelectCell(rowj, "srep_cd");
				break;
             case "t2_btn_t5bDel":
              	var nRow = x_sheetObject4.CheckedRows("del_chk");
  				if (nRow <= 0) {
  					ComShowCodeMessage("SAM00023");
  					return false;
  				} else {
  					if (ComShowConfirm(ComGetMsg("SAM00014"))) { 
  						ComRowHideDelete(x_sheetObject4, "del_chk");
  					} else {
  						return false;
  					}
  				}
              	break;
			} 
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage("COM12111");
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
	function setSheetObject(sheet_obj) {
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
  	  * setting sheet initial values and header
  	  * param : sheetObj, sheetNo
  	  * adding case as numbers of counting sheets
  	  */
	  	
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		formObj.creflag.value="N";
	   formObj.saveflag.value="N";
	   initComboSetVal(sheetObjects[0],document.form);
	   
	   for(var k=0;k<comboObjects.length;k++){
	 		initCombo(comboObjects[k],comboObjects[k].id);
	 	}
	    
        //---------------
        //tab 초기화 
       for(var k=0; k<tabObjects.length; k++){
           initTab(tabObjects[k],k+1);
       }   
	   x_sheetObject1 = sheetObjects[0];  //customer main
 	   x_sheetObject2 = sheetObjects[1];  //keyman
 	   x_sheetObject3 = sheetObjects[2];  //address
 	   x_sheetObject4 = sheetObjects[3];  //coverage team
 	   x_sheetObject5 = sheetObjects[4];  //History
 	   	
 	   axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   //axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
 	   //axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
 	   
 	   ComBtnDisable("btn_Save");
 	   ComBtnDisable("t2_btn_t3bAdd");
	   ComBtnDisable("t2_btn_t4bAdd");
	   ComBtnDisable("t2_btn_t5bAdd");
	   if (!(ComIsNull(formObj.cust_cd.value))) {
		   doActionIBSheet(sheetObjects[0],formObj,SEARCH);
	   }

	   if (formObj.proc_tp_cd.value == "Create") {
		   doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			formObj.cust_cd.value="";
			formObj.creflag.value="Y";
		    formObj.saveflag.value="N";
		    formObj.bzet_addr.readOnly=false;
		    formObj.bzet_addr.style.backgroundColor="#d4f6ff";
			formObj.cust_cd.readOnly=true;
			formObj.cust_cd.style.backgroundColor="#bebebe";
			ComBtnDisable("btn_Create");
			ComBtnDisable("t2_btn_t3bAdd");
			ComBtnDisable("t2_btn_t4bAdd");
			ComBtnDisable("t2_btn_t5bAdd");
			ComBtnEnable("btn_Save");
			ComEnableObject(formObj.btn_com_ens_041, false);
	   }
	   
	   ComSetDisplay("btn_Create1", false);
	   ComSetDisplay("btn_GstSave1", false);
	   //ComSetDisplay("bth_cov_row_add", false);
	   //ComSetDisplay("bth_cov_row_del", false);
	   //ComSetDisplay("bth_key_row_add", false);
	   //ComSetDisplay("bth_key_row_del", false);
	   //ComSetDisplay("bth_addr_row_add", false);
	   ComSetDisplay("bth_addr_row_del", false);
	   
		if(ComGetObjValue(document.form.isInquiry) == "Y"){
		    /*var objs = document.all.item("buttonLayer");
		    objs.style.display = "none";
		    ComSetDisplay("btn_retrieve_inttra1", false);
			ComSetDisplay("btn_reject_inttra1", false);*/
			ComSetDisplay("btn_Save1", false);
		}
	   
	   //doActionIBSheet(sheetObjects[0],formObj,SEARCH13);

 	   initControl();
 	   
	}
	
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObj);
        /*axon_event.addListenerFormat('keypress', 		'bkg007901_keypress',   formObj); //- 키보드 입력할때
        axon_event.addListenerFormat('keyup',			'bkg007901_keyup',    	formObj); //- 키보드 입력후
        axon_event.addListenerForm('beforedeactivate', 	'bkg007901_deactivate', formObj); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 	'bkg007901_activate',   formObj); //- 포커스 들어갈때
        axon_event.addListenerForm('click', 			'bkg007901_click',    	formObj);*/ //- 클릭시
 	   	axon_event.addListenerFormat('keypress', 'obj_keypress_loc', document.form);
 	   	axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   	axon_event.addListenerForm  ('click',    'obj_click',        document.form); 
 	    axon_event.addListenerForm	('keydown',  'check_Enter', 	 document.form);
 	    axon_event.addListenerForm  ('beforedeactivate'	, 'obj_deactivate'	, document.form); 
        
        //applyShortcut();
    }	

	 function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
	    switch(sheetObj.id) {
	        case "sheet1":   //sheet1 init
	            with (sheetObj) {
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	                  //나머지는 속성이나 함수는 필요하지 않으므로 모두 생략한다.
	                
	              //전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msNone;
	
	    			//전체Edit 허용 여부 [선택, Default false]
	    			Editable = true;
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo(1, 1, 15, 100);
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(66, 0, 0, true);
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	    			var HeadTitle1 = " |";
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          40,    daCenter,  false,   "Seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_lgl_eng_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_locl_lang_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bzet_addr");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_abbr_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_rgst_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "loc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ofc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "indiv_corp_div_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cntr_div_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rvis_cntr_cust_tp_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_div_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd1");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd2");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nbs_clss_cd3");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "vbs_clss_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "vndr_seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_grp_id");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "indus_desc");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nmd_cust_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "delt_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cts_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "sls_delt_eff_dt");
					
					//More info1
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "intl_phn_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "phn_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "intl_fax_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "fax_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_eml");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_url");
					
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "prf_svc_desc");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "prf_svc_dtl_desc");	
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cmpt_desc");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "spcl_req_desc");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "prf_cntr_tpsz_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crnt_vol_knt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "new_key_acct_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rgn_acct_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_rmk");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bkg_alt_rsn");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bkg_alt_msg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bkg_alt_fm_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bkg_alt_to_dt");
					
					//More Info2
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_lic_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_bd_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_bd_amt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_hjs_scac_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "frt_fwrd_fmc_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_bd_st_eff_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nvocc_bd_end_eff_dt");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "oti_orz_no");

					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_ste_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ste_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_terr_div_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_pan_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_gst_rgst_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_co_type_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_spcl_ecn_zn_ut_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ida_cust_eml");
					
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "file_sav_id");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "file_nm");
					
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "subs_co_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "co_chn_tp_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "co_chn_no");
					
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "crm_row_id");
	            }
	            break;
					
	        case "t2bsheet1_keyman":		
				with (sheetObj) {
					// 높이 설정
					style.height = 220;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|SEQ|Primary|Detail|First Name|Last Name|Mr/Ms|Job Title|S. Rep.|S. Rep.|Country Phone|Work Fax#|eMail|Key Man Sequence|||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,			daCenter,	false,		"ibflag"); 
					InitDataProperty(0, cnt++ , dtCheckBox,	45,			daCenter,	false,		"del_chk",	        false,		"",	dfNone,		0,		true,		true);  //저장용 all-grid 보관시 사용됨 
				
					InitDataProperty(0, cnt++ , dtHidden,		50,			daCenter,	false,		"seq",          	false,      "", dfNumber,   0,      true,      	true);
					InitDataProperty(0, cnt++ , dtRadioCheck,	70,			daCenter,	false,		"prmry_chk_flg",    false,      "", dfNone,   	0,      true,      	true,1);
					InitDataProperty(0, cnt++,  dtHidden,        40,   		daCenter,   false,     	"KEYMANPop",        false,     	"", dfNone,    	0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,			130,		daLeft,		false,		"fst_name",     	true,      	"", dfEngUpKey,   	0,      true,      	true,50);
					InitDataProperty(0, cnt++ , dtData,		    100,		daLeft,		false,		"last_name",		true,		"",	dfEngUpKey,		0,		true,		true,50);
					InitDataProperty(0, cnt++ , dtCombo,		60,  		daCenter,  	false,		"per_title",		false,	    "",	dfNone,	    0,		true,       true, 14);  //, true -> fullinput  dfEngUpKey
					InitDataProperty(0, cnt++ , dtData,			130,		daLeft,		false,		"job_title",	    false,		"",	dfEngUpKey,	0,		true,		true, 75);
					
					InitDataProperty(0, cnt++ , dtData,	        50,	    	daCenter,	false,		"srep_cd",			false,		"",	dfEngUpKey,	0,		true,		true, 5);
					InitDataProperty(0, cnt++,  dtPopup,        20,   		daCenter,   false,     	"SREPPop",          false,     	"", dfNone,    	0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,			120,		daLeft,		false,		"work_ph_num",		false,		"",	dfEngUpKey,	0,		true,		true, 40);
					InitDataProperty(0, cnt++ , dtData,			120,		daLeft,		false,		"fax_ph_num",		false,		"",	dfEngUpKey,	0,		true,		true, 40);
					InitDataProperty(0, cnt++ , dtData,			130,		daLeft,		false,		"email_addr",		false,		"",	dfEngUpKey,	0,		true,		true, 100);
					InitDataProperty(0, cnt++ , dtHidden,		30,			daCenter,	false,		"keyman_seq",		false,		"",	dfNumber,	0,		true,		true, 10);
					
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	false,		"cust_cnt_cd",		false,		"",	dfNone,		0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtHidden,		130,		daCenter,	false,		"cust_seq",			false,		"",	dfNumber,	0,		true,		true, 6);

					
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "pager_pin", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "occupation", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "eye_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "birth_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, true, "wed_anvrsry_dt", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "hair_color", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "spouse_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "con_manager_name", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "cell_ph_num", false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden, 160, daCenter, false, "home_ph_num", false, "", dfNone, 0, false, false);
					
					
					InitDataCombo(0, "per_title", "Mr|Ms", "Mr|Ms");
					
					PopupImage = "img/btns_calendar.gif";
					ShowButtonImage = 2;	
					
					WaitImageVisible = false;   
				}
				break;    	
	        case "t2bsheet1_adress":		
				with (sheetObj) {
					// 높이 설정
					style.height = 220;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel.|Seq.|Primary|Type|Status|Address|Country|"+
					                "State|State|City|Zip Code|||||";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag"); 
					InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	false,		"del_chk",		    false,		"",	dfNone,		0,		true,		true);					
				
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,		"addr_seq",         false,      "", dfNumber,   0,      true,      	false);
					InitDataProperty(0, cnt++ , dtRadioCheck,	70,		daCenter,	false,		"prmry_chk_flg",    false,      "", dfNone,   	0,      true,      	true,1);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	false,		"addr_tp_cd",      	false,      "", dfNone,  	0,      true,      	true,50);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,		"delt_flg",      	false,      "", dfNone,   	0,      true,      	false,1);
					InitDataProperty(0, cnt++ , dtData,			300,  	daLeft,  	false,		"bzet_addr",		true,	    "",	dfNone,	    0,		true,       true, 200);  
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"cnt_cd",	    	true,		"",	dfEngUpKey,	0,		true,		true, 2);
					
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"ste_cd",		    false,		"",	dfEngUpKey,	0,		true,      	true, 3);
					InitDataProperty(0, cnt++,  dtPopup,        20,   	daCenter,   false,     	"STEPop",          	false,     	"", dfNone,    	0,      true,       true);
					InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		false,		"cty_nm",	    	false,		"",	dfNone,		0,		true,		true, 50);
					InitDataProperty(0, cnt++ , dtData,	        40,	    daCenter,	false,		"zip_cd",			false,		"",	dfNone,		0,		true,		true, 10);
					
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_cnt_cd,",		false,		"",	dfEngUpKey,	0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_seq",			false,		"",	dfNumber,	0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"addr_row_id",		false,		"",	dfNone,		0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cre_usr_id",		false,		"",	dfNumber,	0,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cre_dt",			false,		"",	dfNone,		0,		true,		true, 6);
					
					InitDataCombo(0, "addr_tp_cd", "Main Address|B/L Delivery|B/L Invoicing", "1|3|4");
					InitDataCombo(0, "delt_flg", "Active|Inactive", "N|Y");
					ShowButtonImage = 2;	
					WaitImageVisible = false;   
				}
				break;   
	        case "t2bsheet1_coverage":		
				with (sheetObj) {
					// 높이 설정
		        	style.height = 220;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
	
					var HeadTitle = "|Sel.|Primary|S.Rep code|S.Rep code|Name|Status|"+
					                "Role|Office Code|AREA Code|Phone #|Email|cnt|";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag"); 
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		"ibflag", 			false,		"",	dfNone,		0,		true,		true); 
					InitDataProperty(0, cnt++ , dtCheckBox,	30,		daCenter,	false,		"del_chk",		    false,		"",	dfNone,		0,		true,		true);					
				
					InitDataProperty(0, cnt++ , dtRadioCheck,	70,		daCenter,	false,		"prmry_chk_flg",    false,      "", dfNone,   	0,      true,      	true,1);
					InitDataProperty(0, cnt++ , dtData,			80,  	daCenter,  	false,		"srep_cd",			true,	    "",	dfEngUpKey,	0,		false,      true, 5);  //, true -> fullinput  dfEngUpKey
					InitDataProperty(0, cnt++,  dtPopup,        20,   	daCenter,   false,     	"SREPPop",          false,     	"", dfNone,    	0,      false,       true);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		false,		"srep_nm",      	false,      "", dfNone,   	0,      false,      false);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	false,		"srep_flg",	    	false,		"",	dfNone,		0,		false,		false, 4);
					
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	false,		"role",		   	 	false,		"",	dfNone,		0,		false,      false, 3);					
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,		"ofc_cd",	    	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	        80,	    daCenter,	false,		"area_code",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	        150,	daLeft,		false,		"intl_mphn_no",		false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,	        150,	daLeft,		false,		"srep_eml",			false,		"",	dfNone,		0,		false,		false);
					
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_cnt_cd,",		false,		"",	dfEngUpKey,	0,		false,		false, 2);
					InitDataProperty(0, cnt++ , dtHidden,		130,	daCenter,	false,		"cust_seq",			false,		"",	dfNumber,	0,		false,		false, 6);
					
					InitDataCombo(0, "srep_flg", "Active|Inactive", "N|Y");
					ShowButtonImage = 2;	
					WaitImageVisible = false;   
				}
				break;   
				
	        case "t2bsheet1_history":      //t1sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		        	style.height = 220;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|Item|Item|Now Read|Previous|User Name|Office|Date(Local)|Date(GMT)";
					var headCount = ComCountHeadTitle(HeadTitle);
			
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);	
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
			
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtHidden,    110,   daLeft,  	 true,    "his_seq",      false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 80,    daLeft,  	 true,    "item_hdr",     false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 130,   daLeft,  	 true,    "his_cate_nm",  false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 210,   daLeft,  	 false,   "crnt_ctnt",    false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 180,   daLeft,      false,   "pre_ctnt",     false,   "",      dfNone, 		0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,    	 false,   "cre_usr_id",   false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 60,    daCenter,    false,   "office",       false,   "",      dfNone, 		0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,    false,   "cre_dt",       false,   "",      dfNone, 		0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,    false,   "gmt_dt",       false,   "",      dfNone, 		0,     false,       false);
		            
	
					//InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
					CountPosition = 0;
		        }
		        break;
	    }
	}
	
	 /**
	  * setDataInsert call .<br>
	  * DELT FLG setting 'N' 
	  * @param sheetObj, sNo
	  */
		function setDataInsert(sheetObj, sNo) {
			var formObj=document.form;
			switch (sNo) {
			case 1:
				var prefix="";
				var nRow=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(nRow, prefix + "delt_flg",'N');
				break;
			}
			return nRow;
		}
		
		/**
      * 콤보 초기설정값
      * @param {IBMultiCombo} comboObj  comboObj
      */
      function initCombo(comboObj, comboId) {
    	  /*comboObj.MultiSelect = false;
    	  comboObj.UseCode = true;
    	  comboObj.MultiSeparator = ",";
    	  comboObj.DropHeight = 150;*/      	
    	  
    	  if (comboId == "rvis_cntr_cust_tp_cd"){
        	  comboObj.BackColor = "#CCFFFD";
    	  }
    	  
    	  UseAutoComplete = true; // 편집시 자동 코드 검색
      } 
		
	 /**
	 * BCM_CMS_0302 콤보 데이타를 가져온다.
	 **/
	 function initComboSetVal(sheetObj,formObj){
	 	formObj.f_cmd.value = SEARCH01;
		var sXml = sheetObj.GetSearchXml("BCM_CMS_0302GS.do", FormQueryString(formObj));
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.indiv_corp_div_cd, "cd", "cd_desc");
		if (arrXml.length > 1) 
			ComXml2ComboItem(arrXml[1], formObj.rvis_cntr_cust_tp_cd, "cd", "cd_desc");
		if (arrXml.length > 2) 
			ComXml2ComboItem(arrXml[2], formObj.nbs_clss_cd1, "cd", "cd_desc");
		if (arrXml.length > 3) 
			ComXml2ComboItem(arrXml[3], formObj.nbs_clss_cd2, "cd", "cd_desc");
		if (arrXml.length > 4) 
			ComXml2ComboItem(arrXml[4], formObj.nbs_clss_cd3, "cd", "cd_desc");
		if (arrXml.length > 5) 
			ComXml2ComboItem(arrXml[5], formObj.vbs_clss_cd, "cd", "cd_desc");
		if (arrXml.length > 7) 
			ComXml2ComboItem(arrXml[7], formObj.ida_co_type_cd, "cd", "cd_desc");
		if (arrXml.length > 8) 
			ComXml2ComboItem(arrXml[8], formObj.prf_cntr_tpsz_cd, "cd", "cd|cd_desc");
		if (arrXml.length > 9) {
			ComXml2ComboItem(arrXml[9], formObj.prf_svc_desc, "cd", "cd|cd_desc");
			ComXml2ComboItem(arrXml[9], formObj.prf_svc_dtl_desc, "cd", "cd|cd_desc");
		}
		if (arrXml.length > 12) {
			ComXml2ComboItem(arrXml[12], formObj.intl_phn_no, "cd", "cd|cd_desc");
			ComXml2ComboItem(arrXml[12], formObj.intl_fax_no, "cd", "cd|cd_desc");
		}
		if (arrXml.length > 13) 
			ComXml2ComboItem(arrXml[13], formObj.co_chn_tp_cd, "cd", "cd_desc");
		if (arrXml.length > 14) 
			ComXml2ComboItem(arrXml[14], formObj.subs_co_cd, "cd", "cd_desc|cd");
		/*if (arrXml.length > 10) 
			ComXml2ComboItem(arrXml[10], formObj.ida_ste_cd, "cd", "cd|cd_desc|cd_etc");*/
	 }	
		 
		 // Sheet관련 프로세스 처리
		 function doActionIBSheet(sheetObj, formObj, sAction) {
		     sheetObj.ShowDebugMsg = false;
		     switch(sAction) {
		
		 		case SEARCH: //retrieve
					if(!validateForm(sheetObj, formObj, sAction)) {
						return false;
					}
					if(formObj.cust_cd.value.length>2){	   
			  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
			  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
					}
					
					ComOpenWait(true);					
					
					formObj.f_cmd.value = SEARCH;
					
					formObj.creflag.value="R";

	    		    var sXml = sheetObj.GetSearchXml("BCM_CMS_0302GS.do", FormQueryString(formObj));				
					var arrXml = sXml.split("|$$|"); 
					
					if (arrXml.length > 0) {
						x_sheetObject1.LoadSearchXml(arrXml[0]); 
					}
					
					if (arrXml.length > 1) {
						x_sheetObject2.LoadSearchXml(arrXml[1]); 
					}
					
					if (arrXml.length > 2) {
						x_sheetObject3.LoadSearchXml(arrXml[2]); 
					}
					
					if (arrXml.length > 3) {
						x_sheetObject4.LoadSearchXml(arrXml[3]); 
					}
					
					if (arrXml.length > 4) {
						x_sheetObject5.LoadSearchXml(arrXml[4]); 
					}

	    		    if (sheetObj.CellValue(1, "cust_lgl_eng_nm") != undefined){
	    		    	formSettingVal(sheetObj,formObj,arrXml[0]);
	    		    	
	    		    } else {
	    		    	ComOpenWait(false);
		        		return;
	    		    }
	    		    	
	    		    ComOpenWait(false);
	    		    
	    		    formObj.creflag.value="N";
	    		    
	    		    setIndiaLocChange(formObj.loc_cd.value.substr(0,2));
					
	    		    bkg_alt_fm_dt_old = formObj.bkg_alt_fm_dt.value;
	    		    bkg_alt_to_dt_old = formObj.bkg_alt_to_dt.value;
	    		    nvocc_bd_st_eff_dt_old = formObj.nvocc_bd_st_eff_dt.value;
	    		    nvocc_bd_end_eff_dt_old = formObj.nvocc_bd_end_eff_dt.value;
	    		    sls_delt_eff_dt_old = formObj.sls_delt_eff_dt.value;
				
	    		    if (sheetObj.CellValue(1, "cust_lgl_eng_nm") == ""){
	    		    	ComBtnDisable("btn_Save");
	    		    	ComShowCodeMessage("CCD00002");
	    		    }
					
	    		    ComBtnEnable("btn_Save");
					ComBtnEnable("btn_Create");
					ComBtnEnable("t2_btn_t3bAdd");
					ComBtnEnable("t2_btn_t4bAdd");
					ComBtnEnable("t2_btn_t5bAdd");
					ComBtnDisable("btn_com_ens_043");
					ComImageChange("btn_com_ens_043","img/btns_search_off.gif",true);
					formObj.cust_cd.readOnly=true;
					formObj.bzet_addr.readOnly=true;
					formObj.srep_cd.readOnly=true;
	 				formObj.cust_cd.style.backgroundColor="#bebebe";
	 				formObj.bzet_addr.style.backgroundColor="#bebebe";
	 				formObj.srep_cd.style.backgroundColor="#bebebe";
	 				
	 				//ComEnableObject(formObj.btn_com_ens_043, false);

		    		/*formObj.cust_seq.readOnly=true;		//Modifying the contents of a query for the update, so that cases can not change the key values ​​to disable
		    		formObj.cust_cnt_cd.readOnly=true;*/
		    		break;		
		    		
				case MULTI:        //저장
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}

					var confMsg;
					var saveMsg;
					if( formObj.creflag.value == "Y" && formObj.cust_cd.value == "" ) {
						var param="";
						param=param + "&cust_cnt_cd=" + form.cust_cnt_cd.value+" &cust_nm=" + form.cust_lgl_eng_nm.value+"&loc_cd=" 
						              + form.loc_cd.value+" &cust_rgst_no=" + form.cust_rgst_no.value;
						ComOpenPopup('/hanjin/BCM_CMS_0304.do?' + param, 780, 470, "getBCM_CMS_0302_saveflag", '0,0', true);
					} else {
						confMsg=ComGetMsg('CCD00023', 'save');
						saveMsg=ComGetMsg("COM130102", "Data");
						setSave(confMsg,saveMsg);
					}
	 		 		break;	
	 		 		
				case MULTI01:        //저장
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}

					var confMsg;
					var saveMsg;
					confMsg=ComGetMsg('CCD00023', 'save');
					saveMsg=ComGetMsg("COM130102", "Data");

					formObj.f_cmd.value=MULTI01;
					var sParam = FormQueryString(formObj);

					ComOpenWait(true); //대기이미지 표시

					var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0302GS.do", sParam);
					var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
					
					ComOpenWait(false); //대기이미지 숨김
					
					if(sav == "S"  ){
						ComShowCodeMessage("COM130102", "Data");
		 				formObj.cust_cd.readOnly=false;
		 				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		 			}else{
		 				ComShowCodeMessage("COM130103", "Data");
		 			}
	 		 		break;	
	 		 		
				case IBCLEAR:      //Initialization
					formObj.cust_seq.readOnly=false;
					formObj.cust_cd.value="";
		//			formObj.cust_cnt_cd.readOnly = false;
					formObj.reset();
					//sheetObjects[1].reset();
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
					sheetObjects[3].RemoveAll();
					sheetObjects[4].RemoveAll();

					formObj.ibflag.value="I";

					ComSetObjValue(formObj.nbs_clss_cd1,"");
			    	ComSetObjValue(formObj.nbs_clss_cd2,"");
			    	ComSetObjValue(formObj.nbs_clss_cd3,"");
			    	ComSetObjValue(formObj.vbs_clss_cd,"");
			    	
			    	ComSetObjValue(formObj.rvis_cntr_cust_tp_cd,"");
			    	ComSetObjValue(formObj.indiv_corp_div_cd,"");
			    	ComSetObjValue(formObj.prf_cntr_tpsz_cd,"");
			    	ComSetObjValue(formObj.prf_svc_desc,"");
			    	ComSetObjValue(formObj.prf_svc_dtl_desc,"");
			    	ComSetObjValue(formObj.ida_co_type_cd,"");
			    	ComSetObjValue(formObj.intl_phn_no,"");
			    	ComSetObjValue(formObj.intl_fax_no,"");
			    	ComSetObjValue(formObj.subs_co_cd,"");
			    	ComSetObjValue(formObj.co_chn_tp_cd,"");
			    	ComSetObjValue(formObj.delt_flg,"N");
			    	setFileNm("");
					
					break;	 		

				case SEARCH03:      //Location Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH03;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Location Code");
				        	formObj.loc_cd.value="";
				        }
						ComOpenWait(false);
					}
					break;
			
				case SEARCH04:      //Office Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH04;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "REP. Office");
				        	formObj.ofc_cd.value="";
				        }
						ComOpenWait(false);
					}
					break;
				
				case SEARCH07:      //Location Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH07;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var steNm=ComGetEtcData(sXml, "steNm");
				        var idaSteCd=ComGetEtcData(sXml, "idaSteCd");
				        var idaTerrDivCd=ComGetEtcData(sXml, "idaTerrDivCd");
				        if(steNm=="" ){
				        	formObj.ste_nm.value="";
				        	formObj.ida_ste_cd.value="";
				        	formObj.ida_terr_div_cd.value="";
				        } else {
				        	formObj.ste_nm.value=steNm;
				        	formObj.ida_ste_cd.value=idaSteCd;
				        	formObj.ida_terr_div_cd.value=idaTerrDivCd;
				        }
						ComOpenWait(false);
					}
					break;
					
				case SEARCH08:      //Internation no
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH08;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Contact Phone International No");
				        	formObj.intl_phn_no.value="";
				        	document.form.intl_phn_no.focus();
				        }
						ComOpenWait(false);
					}
				break;
				
				case SEARCH09:      //Customer Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH09;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        ;
				        if(result=="" ){
				        	ComShowCodeMessage("COM130402", "Customer Code");
				        	formObj.cust_cnt_cd.value="";
				        	formObj.cust_seq.value="";
				        	formObj.cust_cd.value="";
				        }
						ComOpenWait(false);
					}
				break;
				
				case SEARCH10:      //Sales Rep Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH10;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Sales Rep Code");
				        	formObj.srep_cd.value="";
				        	document.form.srep_cd.focus();
				        }
						ComOpenWait(false);
					}
				break;
				
		    	case SEARCH11:      //Group Customer Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH11;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Group Customer Code");
				        	formObj.cust_grp_id.value="";
				        	document.form.cust_grp_id.focus();
				        }
						ComOpenWait(false);
					}
					break;
					
		    	case SEARCH13:      //User MDM Auth check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH13;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0309GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result=="N"){
				        	ComSetDisplay("btn_Save1", false);
				     	    ComSetDisplay("bth_cov_row_add", false);
				     	    ComSetDisplay("bth_cov_row_del", false);
				     	    ComSetDisplay("bth_key_row_add", false);
				     	    ComSetDisplay("bth_key_row_del", false);
				     	    ComSetDisplay("bth_addr_row_add", false);
				     	    /*document.all.item("user_mdm_auth").style.display = "block";
				        	document.all.item("user_mdm_auth").innerText = "You have no authority to update MDM. Request MDM role in advance.";*/
				        }
						ComOpenWait(false);
					}
					break;
					
		    	case SEARCH16:      //Trade1 Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH16;
						var sParam=FormQueryString(formObj)+"&trd_cd=" + form.prf_svc_desc.value;
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Trade Code");
				        	formObj.prf_svc_desc.value="";
				        	document.form.prf_svc_desc.focus();
				        }
						ComOpenWait(false);
					}
					break;
		    	case SEARCH17:      //Trade2 Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH16;
						var sParam=FormQueryString(formObj)+"&trd_cd=" + form.prf_svc_dtl_desc.value;
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Trade Code");
				        	formObj.prf_svc_dtl_desc.value="";
				        	document.form.prf_svc_dtl_desc.focus();
				        }
						ComOpenWait(false);
					}
					break;
					
                case MULTI03:  //Btn_Attach
                    doUpload(document.getElementsByName("subSysCd"));
                    break;  
				
				case SEARCH05:      //Vendor Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH05;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Vendor Code");
				        	formObj.vndr_seq.value="";
				        }
						ComOpenWait(false);
					}
					break;
				/*case SEARCH06:      //Capital Currency Code check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH06;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchData("BCM_CMS_0302GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result==""){
				        	ComShowCodeMessage("COM130402", "Capital Currency Code");
				        	formObj.capi_curr_cd.value="";
				        }
						ComOpenWait(false);
					}
				break;
				
		    	
				
		    	
				}	*/
		     }
		 }

	/**
	 * Checkbox in the pop-up when you pass a value to parent window. <br>
	 * @param {ibsheet} sheetObj IBSheet Object
	 * @param {String} value sheetObj input value
	 */
	function chkCallPopupOK(sheetObj) {
		var formObj=document.form;
		var calllFunc;
		var rArray=null;
		rArray=chkGetLocalCheckedRows(sheetObj);
		if(rArray == null) {
			ComShowCodeMessage("COM12114", "row");
			return;
		}
		calllFunc=formObj.calllFunc.value;
		opener.eval(calllFunc)(rArray);
		ComClosePopup(); 
	}
	//===================================================================================
	//UI Object Event Handler
	// ===================================================================================
	/**
	 * Location Code Pop up to read from. <br>
	 */ 

	function setCallBack0B1(aryPopupData) {
		var form=document.form;
		if (form.loc_cd.value != aryPopupData[0][3]){
			form.loc_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
			setIndiaLocChange(form.loc_cd.value.substr(0,2));
			/*if(form.loc_cd.value.substr(0,2) == "IN"){
				form.ida_pan_no.disabled=false;
				form.ida_gst_rgst_no.disabled=false;
				form.ida_spcl_ecn_zn_ut_flg.disabled = false;
				form.ida_cust_eml.disabled = false;
				comboObjects[9].Enable = true; // Company Type
				doActionIBSheet(sheetObjects[0], form, SEARCH07);
			} else {
				form.ida_pan_no.disabled=true;
				form.ida_gst_rgst_no.disabled=true;
				form.ida_spcl_ecn_zn_ut_flg.disabled = true;
				form.ida_cust_eml.disabled = true;
				comboObjects[9].Enable = false; // Company Type
				form.ida_ste_cd.value = "";
				form.ste_nm.value = "";
				form.ida_terr_div_cd.value = "";
				form.ida_pan_no.value="";
				form.ida_gst_rgst_no.value="";
				form.ida_spcl_ecn_zn_ut_flg.value = "";
				form.ida_cust_eml.value = "";
				ComSetObjValue(form.ida_co_type_cd,"");
				setFileNm("");
			}*/

		}
	}
	/**
	 * Customer Code Pop up to read from. <br>
	 */
	function setCallBack0B2(aryPopupData) {
		var form=document.form;
		form.cust_seq.value=aryPopupData[0][3].substring(2,8);
		form.cust_cnt_cd.value=aryPopupData[0][3].substring(0,2);
		form.cust_cd.value=aryPopupData[0][3];
		doActionIBSheet(sheetObjects[0], form, SEARCH);
	}
	/**
	 * Office Code Pop up to read from. <br>
	 */
	function setCallBack0B3(aryPopupData) {
		var form=document.form;
		if (form.ofc_cd.value != aryPopupData[0][3]){
			form.ofc_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	function setCallBack0B4(aryPopupData) {
		var form=document.form;
		if (form.vndr_seq.value != aryPopupData[0][2]){
			form.vndr_seq.value=aryPopupData[0][2];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	function setCallBack0B5(aryPopupData) {
		var form=document.form;
		if (form.cust_cnt_cd.value != aryPopupData[0][3]){
			form.cust_cnt_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	function setCallBack0B6(aryPopupData) {
		var form=document.form;
		x_sheetObject3.CellValue2(x_sheetObject3.SelectRow, "ste_cd") = aryPopupData[0][3];
	}
	/**
	 * Sales Rep Code Pop up to read from. <br>
	 */
	function setCallBack0B7(aryPopupData) {
		var form=document.form;
		if (form.srep_cd.value != aryPopupData[0][4]){
			form.srep_cd.value=aryPopupData[0][4];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
	}
	/**
	 * Sales Rep Code Pop up to read from. <br>
	 */
	function setCallBack0B8(aryPopupData) {
		var form=document.form;
		x_sheetObject4.CellValue2(x_sheetObject4.SelectRow, "srep_cd") = aryPopupData[0][4];
		x_sheetObject4.CellValue2(x_sheetObject4.SelectRow, "srep_nm") = aryPopupData[0][5];
		x_sheetObject4.CellValue2(x_sheetObject4.SelectRow, "ofc_cd") = aryPopupData[0][3];
		x_sheetObject4.CellValue2(x_sheetObject4.SelectRow, "intl_mphn_no") = aryPopupData[0][8];
		x_sheetObject4.CellValue2(x_sheetObject4.SelectRow, "srep_eml") = aryPopupData[0][7];
	}
	function setCallBack0B9(aryPopupData) {
		var form=document.form;
		x_sheetObject2.CellValue2(x_sheetObject2.SelectRow, "srep_cd") = aryPopupData[0][4];
	}
	
    function setCustGrpId(aryPopupData){
	    var form=document.form;
	    if (form.cust_grp_id.value != aryPopupData[0][2]){
			form.cust_grp_id.value=aryPopupData[0][2];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		 }
    }
	 /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		 switch (sAction) {
	    	case SEARCH:
	    		if( ComIsNull(formObj.cust_cd) ){
	    			ComShowCodeMessage("CCD00001", "Customer Code");
	    			document.form.cust_cd.focus();
	    			return false;
	    		}
	    		break;
	    	case MULTI:
/*		    	if(formObj.creflag.value == "N" && formObj.rqst_no.value == ''){
		    		if(formObj.cust_cd.value == "" || formObj.cust_cd.value == null){
		    			ComShowCodeMessage("CCD00001", "Customer Code");
//		    			document.form.cust_cd.focus();
		    			return false;
		    		}
		    	}*/
	    		var chg_flag = "N";
	    		if(formObj.delt_flg.value != 'Y'){
	    		
		    		if(ComTrim(formObj.cust_lgl_eng_nm.value) == "" || formObj.cust_lgl_eng_nm.value == null){
		    			ComShowCodeMessage("CCD00001", "Legal English Name");
		    			document.form.cust_lgl_eng_nm.focus();
		    			return false;
		    		}
		    		if((formObj.bzet_addr.value == "" || formObj.bzet_addr.value == null) && formObj.creflag.value == "Y"){
		    			ComShowCodeMessage("CCD00001", "Address");
		    			document.form.bzet_addr.focus();
		    			return false;
		    		}
		    		if(formObj.loc_cd.value == "" || formObj.loc_cd.value == null){
		    			ComShowCodeMessage("CCD00001", "Location Code");
		    			document.form.loc_cd.focus();
		    			return false;
		    		}
		    		
		    		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
		    		if(formObj.ofc_cd.value == "" || formObj.ofc_cd.value == null){
		    			//ComShowCodeMessage("CCD00001", "REP. Office");
		    			document.form.ofc_cd.focus();
		    			return false;
		    		}
		    		/*if(formObj.srep_cd.value == "" || formObj.srep_cd.value == null){
		    			ComShowCodeMessage("CCD00001", "Sales Rep");
		    			document.form.srep_cd.focus();
		    			return false;
		    		}*/
		    		if(ComGetObjValue(formObj.rvis_cntr_cust_tp_cd) == "" || ComGetObjValue(formObj.rvis_cntr_cust_tp_cd) == null){
		    			ComShowCodeMessage("CCD00001", "Container Customer Type");
		    			document.form.rvis_cntr_cust_tp_cd.focus();
		    			return false;
		    		}
		    		
		    		// date change
		    		if (formObj.ibflag.value != "I" &&
		    				(formObj.nvocc_bd_st_eff_dt.value != nvocc_bd_st_eff_dt_old || formObj.nvocc_bd_end_eff_dt.value != nvocc_bd_end_eff_dt_old 
		    						|| formObj.bkg_alt_fm_dt.value != bkg_alt_fm_dt_old || formObj.bkg_alt_to_dt.value != bkg_alt_to_dt_old
		    						|| formObj.sls_delt_eff_dt.value != sls_delt_eff_dt_old)){
		    			formObj.ibflag.value					="U";
		    		}
		    		
		    		if(formObj.bkg_alt_fm_dt.value != ""){
	    			//Check the date format is correct for input
						if(!checkDateValue(formObj.bkg_alt_fm_dt)){
							formObj.bkg_alt_fm_dt.value="";
							formObj.bkg_alt_fm_dt.focus();
							return false;
						}
		    		}	    		
		    		if(formObj.bkg_alt_to_dt.value != ""){
		    			//Check the date format is correct for input
						if(!checkDateValue(formObj.bkg_alt_to_dt)){
							formObj.bkg_alt_fm_dt.value="";
							formObj.bkg_alt_fm_dt.focus();
							return false;
						}
		    		}
		    		
		    		if(formObj.nvocc_bd_st_eff_dt.value != ""){
		    			//Check the date format is correct for input
						if(!checkDateValue(formObj.nvocc_bd_st_eff_dt)){
							formObj.nvocc_bd_st_eff_dt.value="";
							formObj.nvocc_bd_st_eff_dt.focus();
							return false;
						}
		    		}
		    		if(formObj.nvocc_bd_end_eff_dt.value != ""){
		    			//Check the date format is correct for input
						if(!checkDateValue(formObj.nvocc_bd_end_eff_dt)){
							formObj.nvocc_bd_end_eff_dt.value="";
							formObj.nvocc_bd_end_eff_dt.focus();
							return false;
						}
		    		}
		    		if(formObj.sls_delt_eff_dt.value != ""){
		    			//Check the date format is correct for input
						if(!checkDateValue(formObj.sls_delt_eff_dt)){
							formObj.sls_delt_eff_dt.value="";
							formObj.sls_delt_eff_dt.focus();
							return false;
						}
		    		}
		    		
		    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.cust_rgst_no.value == "" && formObj.nmd_cust_flg.value != "Y"){
		    			ComShowCodeMessage("SAM00022");
		    			document.form.cust_rgst_no.focus();
		    			return false;
		    		}
		    		
		    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.cust_locl_lang_nm.value == "" ){
		    			ComShowCodeMessage("SAM00030");
		    			document.form.cust_locl_lang_nm.focus();
		    			return false;
		    		}
		    		
		    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.nmd_cust_flg.value != "Y"){
		    			if (!chkWorkNumb(formObj.cust_rgst_no.value)){
		    				document.form.cust_rgst_no.focus();
		    				return false;
		    			}
		    		}
		    		
		    		if (formObj.loc_cd.value.substr(0,2) == "IN" && formObj.ida_spcl_ecn_zn_ut_flg.value == 'Y' && formObj.file_nm.value == ""){
		    			ComShowCodeMessage("SAM00024");
		    			return false;
		    		}
	    		
		    		//KEYMAN MANDATORY CHECK
		    		for (var i=1; i<=x_sheetObject2.RowCount; i++) {
		    			if (ComTrim(x_sheetObject2.CellValue(i, "fst_name")) == ""){
		    				ComShowCodeMessage("SAM00009", "First Name");
		    				x_sheetObject2.SelectCell(i, "fst_name");
		    				return false;
		    			}
		    			if (ComTrim(x_sheetObject2.CellValue(i, "last_name")) == ""){
		    				ComShowCodeMessage("SAM00009", "Last Name");
		    				x_sheetObject2.SelectCell(i, "last_name");
		    				return false;
		    			}
		    			if (x_sheetObject2.CellValue(i, "ibflag") == "I" || x_sheetObject2.CellValue(i, "ibflag") == "U" || x_sheetObject2.CellValue(i, "ibflag") == "D"){
		    				var chg_flag = "Y";
		    			}
		    		}
		    		
		    		//ADDRESS MANDATORY CHECK
		    		for (var i=1; i<=x_sheetObject3.RowCount; i++) {
		    			if (x_sheetObject3.CellValue(i, "cnt_cd") == ""){
		    				ComShowCodeMessage("SAM00009", "Address Country");
		    				x_sheetObject3.SelectCell(i, "cnt_cd");
		    				return false;
		    			}
		    			if (ComTrim(x_sheetObject3.CellValue(i, "bzet_addr")) == ""){
		    				ComShowCodeMessage("SAM00009", "Address");
		    				x_sheetObject3.SelectCell(i, "bzet_addr");
		    				return false;
		    			}
		    			if (x_sheetObject3.CellValue(i, "ibflag") == "I" || x_sheetObject3.CellValue(i, "ibflag") == "U"){
		    				var chg_flag = "Y";
		    			}
		    		}
		    		
		    		//COVERAGE TEAM MANDATORY CHECK
		    		for (var i=1; i<=x_sheetObject4.RowCount; i++) {
		    			if (x_sheetObject4.CellValue(i, "srep_cd") == ""){
		    				ComShowCodeMessage("SAM00009", "Sales Rep");
		    				x_sheetObject4.SelectCell(i, "srep_cd");
		    				return false;
		    			}
		    			if (x_sheetObject4.CellValue(i, "ibflag") == "I" || x_sheetObject4.CellValue(i, "ibflag") == "U" || x_sheetObject4.CellValue(i, "ibflag") == "D"){
		    				var chg_flag = "Y";
		    			}
		    		}
		    		if (formObj.nmd_cust_flg.checked){
		    			if (!ComShowConfirm(ComGetMsg("SAM00011"))) { 
							return false;
						}
		    		}
	    		}
	    		
	    		if (formObj.ibflag.value == "N" && chg_flag == "N"){
	    			ComShowCodeMessage("SAM00006")
	    			return false;
	    		}
	    		
               break;
               
	    	case MULTI01:
	    		if (formObj.loc_cd.value.substr(0,2) == "IN" && formObj.ida_spcl_ecn_zn_ut_flg.value == 'Y' && formObj.file_nm.value == ""){
	    			ComShowCodeMessage("SAM00024");
	    			return false;
	    		}
	    	}
	    	return true;
		}
		/*
		 * 저장을 위한 데이타 값 처리
		 * 
		 */
/*		function t2bsheet1_adress_OnValidation(sheetObj, rowIdx, colIdx, value) {
			
			if (sheetObj.CellValue(rowIdx, "ibflag") == 'I' || sheetObj.CellValue(rowIdx, "ibflag") == 'U'){
				
				if (colIdx == sheetObj.SaveNameCol("cnt_cd") || colIdx == sheetObj.SaveNameCol("bzet_addr")) {
					if(ComIsNull(value)) {
						ComShowCodeMessage("SAM00009", "Address Country");
						sheetObj.ValidateFail = true;
						sheetObj.SelectCell(rowIdx, colIdx);
					}
				}
			}
		}*/
	
	   /**
        * When Save, Call Function 
       */
	    function setSave(confMsg, saveMsg) {
			var formObj   = document.form;
			var sheetObj  = sheetObjects[0];
			if (formObj.cust_seq.value == "" && formObj.saveflag.value == "N") return;	
			if (!confirm(confMsg)) {
				formObj.saveflag.value="N";
			    return false;
			}
			if (formObj.cust_cnt_cd.value == "" ) {
				formObj.cust_cnt_cd.value=formObj.loc_cd.value.substr(0,2);
			}

			formObj.f_cmd.value=MULTI;
			
			var sParam1 = ComSetPrifix(x_sheetObject2.GetSaveString(), "t2bsheet2_"); 
      	    var sParam2 = ComSetPrifix(x_sheetObject3.GetSaveString(), "t2bsheet3_"); 
      	    var sParam3 = ComSetPrifix(x_sheetObject4.GetSaveString(), "t2bsheet4_"); 
      	    
      	    //if (sParam1+sParam2+sParam3 == "") return;
      	    var sParam = FormQueryString(formObj);

      	    sParam += "&" + sParam1; 
      	    sParam += "&" + sParam2; 
      	    sParam += "&" + sParam3; 
      	    
			ComOpenWait(true); //대기이미지 표시

			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0302GS.do", sParam);
			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
			
			ComOpenWait(false); //대기이미지 숨김

			if(sav == "S"  ){
				formObj.cust_cnt_cd.value = ComGetEtcData(SaveXml, "custCntCd");
				formObj.cust_seq.value = ComGetEtcData(SaveXml, "custSeq");
				
				var custlpad="";
           		if (formObj.cust_seq.value.length <6 ){
           			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
           				 custlpad=custlpad+"0" ;
           			}
           			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
           		}

 				ComShowCodeMessage("COM130102", "Data");
 				formObj.cust_cd.readOnly=false;
 				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
 			}else{
 				ComShowCodeMessage("COM130103", "Data");
 			}
	   }
		 /**
	     * Call Back Function  
	     */
	   function getBCM_CMS_0302_saveflag(saveFlag) {
			var formObj   = document.form;
 		    var confMsg;
			var saveMsg;
			formObj.saveflag.value=saveFlag;
			confMsg=ComGetMsg("CCD00030");
			saveMsg=ComGetMsg("CCD00031");
			setSave(confMsg, saveMsg );
			//ComShowCodeMessage("CCD00031", "Data");
	   }
	
	
		function obj_focus() {
	      	if(event.srcElement.options){
//	      		event.srcElement.focus();
	      	}else{
	      		event.srcElement.select();
	      	}
	    }
		
		//IB sheet의 값이 변경될경우.
		function t2bsheet1_keyman_OnChange(sheetObj,row,col,value){
			var formObj = document.form;
			var val_type = "";
			var val_value = "";
			
			/* ColSaveName */
			var col_save_name = sheetObj.ColSaveName(col);
			var data_type = sheetObj.ReadDataProperty(row, col, 0);
			
			if (col_save_name == "srep_cd" || col_save_name == "srep_cd") {
	        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        		val_type = "Sales Rep Code";
	        		val_value = sheetObj.CellValue(row,col_save_name);
	        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
	        			sheetObj.CellValue2(row,col_save_name) = "";
	        			sheetObj.SelectCell(row, col);
	        		}
	        	}
	        }

			if (col_save_name == "del_chk" && value == "1" && sheetObj.CellValue(row,"prmry_chk_flg") == "1") {
				ComShowCodeMessage("CCD00008");
				sheetObj.CellValue2(row,col_save_name) = "0";
			}
		}
		
		function t2bsheet1_keyman_OnPopupClick(sheetObj, row, col){
	        var col_name = sheetObj.ColSaveName(col);
			switch(col_name) {
				case "SREPPop":
					var param="";
					ComOpenPopup('/hanjin/COM_ENS_043.do?' + param, 780, 400, 'setCallBack0B9', '1,0,1,1,1,1,1,1', true);
					break;
				case "KEYMANPop":
					var goUrl = "";
					goUrl = "/hanjin/BCM_CMS_0308.do?";
					if (sheetObj.CellValue(row,"ibflag")!="I"){
						ComOpenWindowCenter(goUrl+"&keyman_seq="+sheetObj.CellValue(row,"keyman_seq"),"BCM_CMS_0308",800,380,true);
					}
				    
					break;
				
			}		
		}
		
	    /**
	     * 시트를 더블클릭했을 때 처리
	     * @param row
	     * @param col
	     * @return
	     */
/*	    function t2bsheet1_keyman_OnDblClick(sheetObj, row, col) {
	    	var formObj=document.form;
				var param = "";
				var keyman_seq = sheetObj.CellValue(row, "keyman_seq");
				if ( keyman_seq != "" ) {	
		    		param=param + "&" + "keyman_seq=" + keyman_seq  + "&fst_name=" + fst_name  ;
		    		ComOpenWindowCenter("/hanjin/BCM_CMS_0308.do?"+param, "BCM_CMS_0308", 800, 380, true, "yes");
				}
	    }*/

		
		//IB sheet의 값이 변경될경우.
		function t2bsheet1_adress_OnChange(sheetObj,row,col,value){
			var formObj = document.form;
			var val_type = "";
			var val_value = "";
			
			/* ColSaveName */
			var col_save_name = sheetObj.ColSaveName(col);
			var data_type = sheetObj.ReadDataProperty(row, col, 0);
			
			if (col_save_name == "cnt_cd") {
	        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        		val_type = "Country";
	        		val_value = sheetObj.CellValue(row,col_save_name);
	        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
	        			sheetObj.CellValue2(row,col_save_name) = "";
	        			sheetObj.SelectCell(row, col);
	        		}
	        	}
	        }
			if (col_save_name == "ste_cd") {
	        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        		val_type = "State";
	        		val_value = sheetObj.CellValue(row,col_save_name);
	        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
	        			sheetObj.CellValue2(row,col_save_name) = "";
	        			sheetObj.SelectCell(row, col);
	        		}
	        	}
	        }
			
			if (col_save_name == "prmry_chk_flg" ) {
	        	if(sheetObj.CellValue(row,col_save_name)=="1" ){
	        		formObj.bzet_addr.value = sheetObj.CellValue(row,"bzet_addr")
	        	}
	        }
			
			if (col_save_name == "del_chk" && value == "1" && sheetObj.CellValue(row,"prmry_chk_flg") == "1") {
				ComShowCodeMessage("CCD00008");
				sheetObj.CellValue2(row,col_save_name) = "0";
			}
			
		}
		
		function t2bsheet1_adress_OnPopupClick(sheetObj, row, col){
	        var col_name = sheetObj.ColSaveName(col);
			switch(col_name) {
				case "STEPop":
					if (sheetObj.CellValue(row, "cnt_cd").length > 1) {
						var param="cnt_cd="+sheetObj.CellValue(row, "cnt_cd");
						ComOpenPopup('/hanjin/COM_ENS_0X1.do?' + param, 300, 350, 'setCallBack0B6', '1,0,1,1,1,1,1,1', true);
					}
					break;
			}		
		}
		
		//IB sheet의 값이 변경될경우.
		function t2bsheet1_coverage_OnChange(sheetObj,row,col,value){
			var formObj = document.form;
			var val_type = "";
			var val_value = "";
			
			/* ColSaveName */
			var col_save_name = sheetObj.ColSaveName(col);
			var data_type = sheetObj.ReadDataProperty(row, col, 0);
			
			if (col_save_name == "srep_cd") {
	        	if(sheetObj.CellValue(row,col_save_name)!="" ){
	        		val_type = "Sales Rep Code";
	        		val_value = sheetObj.CellValue(row,col_save_name);
	        		if(!searchValidationData(sheetObj, val_type, val_value, row)) {
	        			sheetObj.CellValue2(row,"srep_nm") = "";
			        	sheetObj.CellValue2(row,"ofc_cd") = "";
			        	sheetObj.CellValue2(row,"intl_mphn_no") = "";
			        	sheetObj.CellValue2(row,"srep_eml") = "";   
	        			sheetObj.CellValue2(row,col_save_name) = "";
	        			sheetObj.SelectCell(row, col);
	        		}
	        	}
	        }
			
			if (col_save_name == "prmry_chk_flg" ) {
	        	if(sheetObj.CellValue(row,col_save_name)=="1" ){
	        		formObj.srep_cd.value = sheetObj.CellValue(row,"srep_cd")
		  			formObj.ibflag.value="U";
	        	}
	        }
			
			if (col_save_name == "del_chk" && value == "1" && sheetObj.CellValue(row,"prmry_chk_flg") == "1") {
				ComShowCodeMessage("CCD00008");
				sheetObj.CellValue2(row,col_save_name) = "0";
			}
		}
		
		function t2bsheet1_coverage_OnPopupClick(sheetObj, row, col){
	        var col_name = sheetObj.ColSaveName(col);
			switch(col_name) {
				
				case "SREPPop":
					var param="";
					ComOpenPopup('/hanjin/COM_ENS_043.do?' + param, 780, 400, 'setCallBack0B8', '1,0,1,1,1,1,1,1', true);
				break;
				
			}		
		}
		
		/**
		 * 저장시 시트의 값에 따른 Validation을 실시한다.<br>
		 * @param {ibsheet} sheetObj 필수 IBSheet Object
		 * @param {String} lane_cd  
		 * @param {String} dir_cd  
		 * @param {String} cmdt_cd 
		 * @returns bool <br>
		 *          true  : 폼입력값이 유효할 경우<br>
		 *          false : 폼입력값이 유효하지 않을 경우
		 * @author 최문환
		 * @version 2014.01.07
		 */
		function searchValidationData(sheetObj, val_type, val_value, row) {
			var formObj = document.form;
			var sParam  = "";
			var result  = "";
			var sXml    = "";

	    	ComOpenWait(true);
	    	if (val_type == "Sales Rep Code") {
		    	sParam = "f_cmd=110&" + "&val_type="+val_type+"&srep_cd="+val_value;
		    	sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        result=ComGetEtcData(sXml, "result");
		        if (sheetObj.id == "t2bsheet1_coverage" && result!=""){
		        	sheetObj.CellValue2(row,"srep_nm") = ComGetEtcData(sXml, "srep_nm");
		        	sheetObj.CellValue2(row,"ofc_cd") = ComGetEtcData(sXml, "ofc_cd");
		        	sheetObj.CellValue2(row,"intl_mphn_no") = ComGetEtcData(sXml, "mphn_no");
		        	sheetObj.CellValue2(row,"srep_eml") = ComGetEtcData(sXml, "srep_eml");		        	
		        }
	    	} else if (val_type == "Country") {
	    		sParam = "f_cmd=102&" + "&val_type="+val_type+"&cust_cnt_cd="+val_value;
		    	sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        result=ComGetEtcData(sXml, "result");
	    	} else if (val_type == "State") {
	    		sParam = "f_cmd=112&" + "&val_type="+val_type+"&ste_cd="+val_value+"&cnt_cd="+sheetObj.CellValue(row,"cnt_cd");
	    		sXml=sheetObj.GetSearchXml("BCM_CMS_0302GS.do", sParam);
		        result=ComGetEtcData(sXml, "result");
	    	}

		    ComOpenWait(false);
	        
	        if(result==""){
	        	ComShowCodeMessage("COM130402", val_type);
	        	return false;
	        }
			 
			return true;
		}
		
		function form_onChange(evt,el) {
		  	var formObj = document.form;
		  	var xml = "";
		  	var srcName;
		  	var srcValue;
			var srcObj;
		  	if (el) {
		  		srcObj = el;
		  		srcName = el.getAttribute("name");
		  		srcValue = el.getAttribute("value");
		  		
		  	} else {
		  		srcObj = window.event.srcElement;
		  		srcName = srcObj.getAttribute("name");
		  		srcValue = srcObj.getAttribute("value");
		  		if(srcName != "cust_cd" && formObj.ibflag.value != 'I'){
		  			formObj.ibflag.value					="U";
		  		}
		  	}

		  	switch(srcName) {
		  		case "cust_cd":
			  		if(formObj.cust_cd.value.length>2){	   
			  			formObj.cust_cnt_cd.value=formObj.cust_cd.value.substr(0,2);
			  			formObj.cust_seq.value=formObj.cust_cd.value.substr(2,6);
	               		if(formObj.cust_seq.value.match(/[^0-9]{1}/)){
	               			  ComShowCodeMessage("CCD00039", "Customer Code");
	               			  formObj.cust_cd.value='';
	               			  return false;
	               		}  
	               		var custlpad="";
	               		if (formObj.cust_seq.value.length <6 ){
	               			for(i=1; i <= 6- formObj.cust_seq.value.length; i++){
	               				 custlpad=custlpad+"0" ;
	               			}
	               			formObj.cust_cd.value=formObj.cust_cnt_cd.value+custlpad+formObj.cust_seq.value ;
	               		}
	               		doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
	        			if(formObj.cust_cd.value.length==0){
	//            			document.form.cust_cd.focus();
	            		}else{
	        				formObj.ibflag.value="U";
	        				formObj.cust_cd.readOnly=true;		
	//            				document.form.cust_lgl_eng_nm.focus();
	        				doActionIBSheet(sheetObjects[0], formObj, SEARCH);
	            		}
	        		}
			  		break;
		  	
		  		case "loc_cd":
		    		if(formObj.loc_cd.value.length>0){
		    			doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
		    			if(formObj.loc_cd.value.length==0){
		    					document.form.loc_cd.focus();
		        			}else{
		        				document.form.ofc_cd.focus();
		        			}
		    			if(formObj.creflag.value == "Y"){
		    				formObj.cust_cnt_cd.value=formObj.loc_cd.value.substr(0,2);
		    			}
		    			
		    			setIndiaLocChange(formObj.loc_cd.value.substr(0,2));
		    			/*if(formObj.loc_cd.value.substr(0,2) == "IN"){
		    				formObj.ida_pan_no.disabled=false;
		    				formObj.ida_gst_rgst_no.disabled=false;
		    				formObj.ida_spcl_ecn_zn_ut_flg.disabled = false;
		    				formObj.ida_cust_eml.disabled=false;
		    				comboObjects[9].Enable = true; // Company Type
		    				doActionIBSheet(sheetObjects[0], formObj, SEARCH07);
		    			} else {
		    				formObj.ida_pan_no.disabled=true;
		    				formObj.ida_gst_rgst_no.disabled=true;
		    				formObj.ida_spcl_ecn_zn_ut_flg.disabled = true;
		    				formObj.ida_cust_eml.disabled=true;
		    				comboObjects[9].Enable = false; // Company Type
		    				formObj.ida_ste_cd.value = "";
		    				formObj.ste_nm.value = "";
		    				formObj.ida_terr_div_cd.value = "";
		    				formObj.ida_pan_no.value="";
		    				formObj.ida_gst_rgst_no.value="";
		    				formObj.ida_spcl_ecn_zn_ut_flg.value = "";
		    				formObj.ida_cust_eml.value = "";
		    				ComSetObjValue(formObj.ida_co_type_cd,"");
		    				setFileNm("");
		    			}*/
		    		}
		    		break;
		  		case "ofc_cd":
            		if(formObj.ofc_cd.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
            			if(formObj.ofc_cd.value.length==0){
            					document.form.ofc_cd.focus();
	            			}else{
	            				document.form.srep_cd.focus();
	            			}
            		}
            		break;
		  		/*case "intl_phn_no":
            		if(formObj.intl_phn_no.value.length>0){
            			formObj.intl_no.value = formObj.intl_phn_no.value;
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH08);
            			if(formObj.intl_phn_no.value.length==0){
            					document.form.intl_phn_no.focus();
	            			}else{
	            				//document.form.srep_cd.focus();
	            			}
            		}
            		break;
		  		case "intl_fax_no":
            		if(formObj.intl_fax_no.value.length>0){
            			formObj.intl_no.value = formObj.intl_fax_no.value;
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH08);
            			if(formObj.intl_fax_no.value.length==0){
            					document.form.intl_fax_no.focus();
	            			}else{
	            				//document.form.srep_cd.focus();
	            			}
            		}
            		break;*/
            	
            	case "srep_cd":
            		if(formObj.srep_cd.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
            			if(formObj.srep_cd.value.length==0){
	            				document.form.srep_cd.focus();
	            			}else{
	            				document.form.rvis_cntr_cust_tp_cd.focus();
	            			}
            		}
	            	break;
	            case "cust_grp_id":
            		if(formObj.cust_grp_id.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH11);
            			if(formObj.cust_grp_id.value.length==0){
            					document.form.cust_grp_id.focus();
	            			}else{
	            				document.form.nbs_clss_cd1.focus();
	            			}
            		}
            		break;
	            case "prf_svc_desc":
            		if(formObj.prf_svc_desc.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH16);
            			if(formObj.prf_svc_desc.value.length==0){
            					document.form.prf_svc_desc.focus();
	            			}else{
	            				document.form.prf_svc_dtl_desc.focus();
	            			}
            		}
            		break;
	            case "prf_svc_dtl_desc":
            		if(formObj.prf_svc_dtl_desc.value.length>0){
            			doActionIBSheet(sheetObjects[0], formObj, SEARCH17);
            			if(formObj.prf_svc_dtl_desc.value.length==0){
	            				document.form.prf_svc_dtl_desc.focus();
	            			}else{
//	            				document.form.mlt_trd_acct_flg.focus();
	            			}
            		}
            		break;
              	case "vndr_seq":
              		if(formObj.vndr_seq.value.length>0){
              			doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
            			if(formObj.vndr_seq.value.length==0){
	            				document.form.vndr_seq.focus();
	            			}else{
//	            				document.form.mlt_trd_acct_flg.focus();
	            			}
            		}
            		break;
	            case "nmd_cust_flg":
	            	if (formObj.nmd_cust_flg.checked) {
	    				formObj.nmd_cust_flg.value = "Y";
	    			} else {
	    				formObj.nmd_cust_flg.value = "N";
	    			}
	            	break;
	            case "new_key_acct_flg":
	            	if (formObj.new_key_acct_flg.checked) {
	    				formObj.new_key_acct_flg.value = "Y";
	    			} else {
	    				formObj.new_key_acct_flg.value = "N";
	    			}
	            	break;
	            
	            case "rgn_acct_flg":
	            	if (formObj.rgn_acct_flg.checked) {
	    				formObj.rgn_acct_flg.value = "Y";
	    			} else {
	    				formObj.rgn_acct_flg.value = "N";
	    			}
	            	break;
	            case "ida_spcl_ecn_zn_ut_flg":
	            	if (formObj.ida_spcl_ecn_zn_ut_flg.value == "N"){
	            		formObj.file_nm.value = "";
	            		setFileNm("");
	            	}
	            	break;
	            case "cust_eml":
	            	if (!checkEmailValue(formObj.cust_eml)){
	            		formObj.cust_eml.value = "";
	            		document.form.cust_eml.focus();
	            	} else {
	            		formObj.cust_eml_add.value = formObj.cust_eml.value;
	            	}
	            	break;
	            case "ida_cust_eml":
	            	if (!checkEmailValue(formObj.ida_cust_eml)){
	            		formObj.ida_cust_eml.value = "";
	            		document.form.ida_cust_eml.focus();
	            	}
	            	break;
		  	}
		}
	    
		// Customer Type 변경시
		function rvis_cntr_cust_tp_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Firm/Private 변경시
		function indiv_corp_div_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Need Base Seg. Class1 변경시
		function nbs_clss_cd1_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Need Base Seg. Class2 변경시
		function nbs_clss_cd2_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Need Base Seg. Class3 변경시
		function nbs_clss_cd3_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Value Base Seg. Class 변경시
		function vbs_clss_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		
		// Major Trade Type 변경시
		function prf_svc_desc_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Major Trade Type 변경시
		function prf_svc_dtl_desc_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Equipment 변경시
		function prf_cntr_tpsz_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Company Type 변경시
		function ida_co_type_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// International phone no 변경시
		function intl_phn_no_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// International fax no 변경시
		function intl_fax_no_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// China company code 변경시
		function co_chn_tp_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Subsidiary Company 변경시
		function subs_co_cd_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		// Delete 변경시
		function delt_flg_OnChange(Code, Text){
			var formObj = document.form;
			if(formObj.ibflag.value == 'N' ){
	  			formObj.ibflag.value					="U";
	  		}
		}
		
	    function formSettingVal(sheetObj,formObj,sXml){
	    	formObj.cust_lgl_eng_nm.value 		= sheetObj.CellValue(1, "cust_lgl_eng_nm");
	    	formObj.cust_locl_lang_nm.value 	= sheetObj.CellValue(1, "cust_locl_lang_nm");
	    	formObj.bzet_addr.value 			= sheetObj.CellValue(1, "bzet_addr");
	    	formObj.cust_abbr_nm.value 			= sheetObj.CellValue(1, "cust_abbr_nm");
	    	formObj.cust_rgst_no.value 			= sheetObj.CellValue(1, "cust_rgst_no");
	    	formObj.loc_cd.value 				= sheetObj.CellValue(1, "loc_cd");
	    	formObj.ofc_cd.value 				= sheetObj.CellValue(1, "ofc_cd");
	    	formObj.srep_cd.value 				= sheetObj.CellValue(1, "srep_cd");
	    	
	    	ComSetObjValue(formObj.indiv_corp_div_cd,sheetObj.CellValue(1, "indiv_corp_div_cd"));
	    	ComSetObjValue(formObj.rvis_cntr_cust_tp_cd,sheetObj.CellValue(1, "rvis_cntr_cust_tp_cd"));
	    	
	    	ComSetObjValue(formObj.nbs_clss_cd1,sheetObj.CellValue(1, "nbs_clss_cd1"));
	    	ComSetObjValue(formObj.nbs_clss_cd2,sheetObj.CellValue(1, "nbs_clss_cd2"));
	    	ComSetObjValue(formObj.nbs_clss_cd3,sheetObj.CellValue(1, "nbs_clss_cd3"));
	    	ComSetObjValue(formObj.vbs_clss_cd,sheetObj.CellValue(1, "vbs_clss_cd"));
	    	ComSetObjValue(formObj.subs_co_cd,sheetObj.CellValue(1, "subs_co_cd"));
	    	formObj.sls_delt_eff_dt.value		= sheetObj.CellValue(1, "sls_delt_eff_dt");
	    	
	    	formObj.cust_grp_id.value 			= sheetObj.CellValue(1, "cust_grp_id");
	    	formObj.vndr_seq.value 				= sheetObj.CellValue(1, "vndr_seq");
	    	formObj.cts_no.value 				= sheetObj.CellValue(1, "cts_no");
	    	
	    	formObj.indus_desc.value 			= sheetObj.CellValue(1, "indus_desc");
	    	
	    	//More info1
			formObj.intl_phn_no.value 			= sheetObj.CellValue(1, "intl_phn_no");
			formObj.phn_no.value 				= sheetObj.CellValue(1, "phn_no");
			formObj.intl_fax_no.value 			= sheetObj.CellValue(1, "intl_fax_no");
			formObj.fax_no.value 				= sheetObj.CellValue(1, "fax_no");
			formObj.cust_eml.value 				= sheetObj.CellValue(1, "cust_eml");
			formObj.cust_eml_add.value			= sheetObj.CellValue(1, "cust_eml");
			formObj.cust_url.value 				= sheetObj.CellValue(1, "cust_url");
			ComSetObjValue(formObj.prf_svc_desc,sheetObj.CellValue(1, "prf_svc_desc"));
			ComSetObjValue(formObj.prf_svc_dtl_desc,sheetObj.CellValue(1, "prf_svc_dtl_desc"));
			ComSetObjValue(formObj.intl_phn_no,sheetObj.CellValue(1, "intl_phn_no"));
			ComSetObjValue(formObj.intl_fax_no,sheetObj.CellValue(1, "intl_fax_no"));
	    	formObj.cmpt_desc.value 			= sheetObj.CellValue(1, "cmpt_desc");
			formObj.spcl_req_desc.value			= sheetObj.CellValue(1, "spcl_req_desc");
			ComSetObjValue(formObj.prf_cntr_tpsz_cd,sheetObj.CellValue(1, "prf_cntr_tpsz_cd"));
			formObj.crnt_vol_knt.value			= sheetObj.CellValue(1, "crnt_vol_knt");
			formObj.new_key_acct_flg.value		= sheetObj.CellValue(1, "new_key_acct_flg");
			formObj.rgn_acct_flg.value			= sheetObj.CellValue(1, "rgn_acct_flg");
			formObj.cust_rmk.value				= sheetObj.CellValue(1, "cust_rmk");
			formObj.bkg_alt_rsn.value			= sheetObj.CellValue(1, "bkg_alt_rsn");
			formObj.bkg_alt_msg.value			= sheetObj.CellValue(1, "bkg_alt_msg");
			formObj.bkg_alt_fm_dt.value			= sheetObj.CellValue(1, "bkg_alt_fm_dt");
			formObj.bkg_alt_to_dt.value			= sheetObj.CellValue(1, "bkg_alt_to_dt");
			if (sheetObj.CellValue(1, "new_key_acct_flg") == "Y") {
				formObj.new_key_acct_flg.checked = true;
			} else {
				formObj.new_key_acct_flg.checked = false;
			}
			if (sheetObj.CellValue(1, "rgn_acct_flg") == "Y") {
				formObj.rgn_acct_flg.checked = true;
			} else {
				formObj.rgn_acct_flg.checked = false;
			}
			if (sheetObj.CellValue(1, "nmd_cust_flg") == "Y") {
				formObj.nmd_cust_flg.checked = true;
			} else {
				formObj.nmd_cust_flg.checked = false;
			}
			/*if (sheetObj.CellValue(1, "delt_flg") == "Y") {
				formObj.delt_flg.checked = true;
			} else {
				formObj.delt_flg.checked = false;
			}*/
			ComSetObjValue(formObj.delt_flg,sheetObj.CellValue(1, "delt_flg"));
			
			//More Info2
			formObj.nvocc_lic_no.value				= sheetObj.CellValue(1, "nvocc_lic_no");
			formObj.nvocc_bd_no.value				= sheetObj.CellValue(1, "nvocc_bd_no");
			formObj.nvocc_bd_amt.value				= sheetObj.CellValue(1, "nvocc_bd_amt");
			formObj.nvocc_hjs_scac_cd.value			= sheetObj.CellValue(1, "nvocc_hjs_scac_cd");
			formObj.frt_fwrd_fmc_no.value			= sheetObj.CellValue(1, "frt_fwrd_fmc_no");
			formObj.nvocc_bd_st_eff_dt.value		= sheetObj.CellValue(1, "nvocc_bd_st_eff_dt");
			formObj.nvocc_bd_end_eff_dt.value		= sheetObj.CellValue(1, "nvocc_bd_end_eff_dt");
			formObj.oti_orz_no.value				= sheetObj.CellValue(1, "oti_orz_no");
			
			//More Info2 INDIA
			formObj.ida_ste_cd.value				= sheetObj.CellValue(1, "ida_ste_cd");
			//ComSetObjValue(formObj.ida_ste_cd,sheetObj.CellValue(1, "ida_ste_cd"));
			formObj.ste_nm.value					= sheetObj.CellValue(1, "ste_nm");
			formObj.ida_terr_div_cd.value			= sheetObj.CellValue(1, "ida_terr_div_cd");

			formObj.ida_pan_no.value				= sheetObj.CellValue(1, "ida_pan_no");
			formObj.ida_gst_rgst_no.value			= sheetObj.CellValue(1, "ida_gst_rgst_no");
			ComSetObjValue(formObj.ida_co_type_cd,sheetObj.CellValue(1, "ida_co_type_cd"));
			formObj.ida_spcl_ecn_zn_ut_flg.value	= sheetObj.CellValue(1, "ida_spcl_ecn_zn_ut_flg");
			formObj.ida_cust_eml.value				= sheetObj.CellValue(1, "ida_cust_eml");
			
			formObj.file_sav_id.value			= sheetObj.CellValue(1, "file_sav_id");
			
			setFileNm(sheetObj.CellValue(1, "file_nm"));
			formObj.file_nm.value			= sheetObj.CellValue(1, "file_nm");
			ComSetObjValue(formObj.co_chn_tp_cd,sheetObj.CellValue(1, "co_chn_tp_cd"));
			formObj.co_chn_no.value			= sheetObj.CellValue(1, "co_chn_no");
			
			formObj.crm_row_id.value			= sheetObj.CellValue(1, "crm_row_id");
			
	    	formObj.ibflag.value				="N";
	    	
		 }	  
	    
	    function callShowMessageAddSeq() {
	    	ComShowCodeMessage("COM12130", "click event", "AddSeq button");
	    }
	    
		/**
		 * Tab 기본 설정
		 * 탭의 항목을 설정한다.
		 */
		function initTab(tabObj, tabNo) {
		     switch(tabNo) {
		         case 1:
		            with (tabObj) {
		                var cnt  = 0 ;
		                InsertTab( cnt++ , "More Info1" , -1 );
		                InsertTab( cnt++ , "More Info2" , -1 );
		                InsertTab( cnt++ , "KeyMan" , -1 );
		                InsertTab( cnt++ , "Address" , -1 );
		                InsertTab( cnt++ , "Coverage Team" , -1 );
		                InsertTab( cnt++ , "History" , -1 );
		                BaseColor = "243,242,248"; 
		            }
		         break;
		     }
		} 	    
		
	    function setTabObject(tab_obj){
	        tabObjects[tabCnt++] = tab_obj;
	    }    
		
	    //######################[1. Event]############################################################
	    /**
	     * Tab 클릭시 이벤트 관련
	     * 선택한 탭의 요소가 활성화 된다.
	     */
	    function tab3_OnChange(tabObj , nItem)
	    {
	        //var objs = document.all.item("tabLayer_moreinfo");
	        var formObj = document.form;
	        
	        switch(nItem) {
	         	case 0:
		        	 tabLayer_moreinfo.style.display = "Inline";
				     tabLayer_more2.style.display = "none";
				     tabLayer_keyman.style.display = "none";
				     tabLayer_adress.style.display = "none";
				     tabLayer_coverage.style.display = "none";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 1:
		        	 tabLayer_moreinfo.style.display = "none";
				     tabLayer_more2.style.display = "Inline";
				     tabLayer_keyman.style.display = "none";
				     tabLayer_adress.style.display = "none";
				     tabLayer_coverage.style.display = "none";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 2:
		        	 tabLayer_moreinfo.style.display = "none";
				     tabLayer_more2.style.display = "none";
				     tabLayer_keyman.style.display = "Inline";
				     tabLayer_adress.style.display = "none";
				     tabLayer_coverage.style.display = "none";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 3:
		        	 tabLayer_moreinfo.style.display = "none";
				     tabLayer_more2.style.display = "none";
				     tabLayer_keyman.style.display = "none";
				     tabLayer_adress.style.display = "Inline";
				     tabLayer_coverage.style.display = "none";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 4:
		        	 tabLayer_moreinfo.style.display = "none";
				     tabLayer_more2.style.display = "none";
				     tabLayer_keyman.style.display = "none";
				     tabLayer_adress.style.display = "none";
				     tabLayer_coverage.style.display = "Inline";
				     tabLayer_history.style.display = "none";
				     break;
	         	case 5:
		        	 tabLayer_moreinfo.style.display = "none";
				     tabLayer_more2.style.display = "none";
				     tabLayer_keyman.style.display = "none";
				     tabLayer_adress.style.display = "none";
				     tabLayer_coverage.style.display = "none";
				     tabLayer_history.style.display = "Inline";
				     break;
				     
	        }

	    	/*objs[beforetab_trob].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	beforetab_trob = nItem;*/
	    	
	    }
	    
		// 업무 자바스크립트 OnKeyPress 이벤트 처리
		function obj_keypress_loc() {
			var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
			switch(event.srcElement.dataformat){
		       case "float":
		           //숫자+"."입력하기
		           ComKeyOnlyNumber(event.srcElement, ".");
		           break;
		       case "eng":
		           //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
		           ComKeyOnlyAlphabet();
		           break;
		       case "engdn":
		           //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
		           ComKeyOnlyAlphabet('lower');
		           break;
		       case "engup":
		           //영문 대문자만 입력하기
		           ComKeyOnlyAlphabet('upper');
		           break;
		       case "int":
		           //숫자만입력하기(정수,날짜,시간)
		           ComKeyOnlyNumber(event.srcElement);
		           break;
		       case "uppernum": //모든 문자 가능하지만 영문은 대문자로
		       	   if(keyValue >= 97 && keyValue <= 122) {//소문자
		     			event.keyCode = keyValue + 65 - 97;
		     		}
		           break;
		       case "tel":
			        // 숫자+"-"입력하기
			        ComKeyOnlyNumber(event.srcElement, "-"); 
			        break;
	           case "engupspecial": // 영문대문자+숫자 + Space + &*-,./
		   		   ComKeyOnlyAlphabet('uppernum', "32|38|42|45|44|46|47");
		    	   break;
		    }
		}
		function obj_keyup() {
			var formObj = document.form;
			with (formObj) {
				//textarea : enter 제외
				if (event.srcElement.type == "textarea") {
					return;
				}			
			}
		}  	 
		
	    /**
	     * Event 처리 <br>
	     * </pre>
	     * @return 없음
	     * @author 최문환
	     * @version 2014.01.07
	     */
		function form1_keypress(){
			if (event.srcElement.type == "text" && event.keyCode == 13 ) {
	   			doActionIBSheet(sheetObjects[0], document.form, SEARCH);
			}
			switch(event.srcElement.dataformat){
				case "engupnum":
					ComKeyOnlyAlphabet("uppernum");
				break;
			}	
		}
		
	   /**
	   * India State Code 콤보 선택변경시, 이벤트처리
	   */
	   function ida_ste_cd_OnChange(comboObj, idx_cd, text) {
		   var formObj = document.form;
		   formObj.ste_nm.value				= comboObj.GetText(idx_cd, 1);
		   formObj.ida_terr_div_cd.value		= comboObj.GetText(idx_cd, 2);
	   }
	    
       function doUpload(subSysCd){
           var returnValue = openUpload("BKG", "1", "1");
           if( returnValue == undefined || returnValue == "" ){
               return;
           }

           if(returnValue != undefined && returnValue != "" ){
        	   var fileInfo = returnValue.split('<>');
        	   document.form.file_sav_id.value = fileInfo[0];
        	   document.form.file_nm.value = fileInfo[1].replace(/^.*[\\\/]/, '');
               setFileNm(fileInfo[1].replace(/^.*[\\\/]/, ''));
               form.ibflag.value="U";
           }
       }
    
       function fileDown(){
    	   if(document.form.file_sav_id.value != ''){
    		   ComDownLoad('FileDownload', 'key=' + document.form.file_sav_id.value);
    	   }
       }
       
       function setFileNm(fileNm){
    	   var aTag = '<a href="javascript:fileDown()">' + fileNm + '</a>';
    	   $("#file_nm").html(aTag);
       }
       
       function ComImageChange(name, imagePath, disabled) {
	   		var img = eval('document.form.' + name);
	   		img.src = imagePath;
	   		img.disabled = disabled;
   		}
       
       function setIndiaLocChange(cntCd){
    	   var formObj = document.form;
    	   if(cntCd == "IN"){
				formObj.ida_pan_no.disabled=false;
				formObj.ida_gst_rgst_no.disabled=false;
				formObj.ida_spcl_ecn_zn_ut_flg.disabled = false;
				formObj.ida_cust_eml.disabled=false;
				formObj.ida_co_type_cd.Enable=true;
				doActionIBSheet(sheetObjects[0], formObj, SEARCH07);
			} else {
				formObj.ida_pan_no.disabled=true;
				formObj.ida_gst_rgst_no.disabled=true;
				formObj.ida_spcl_ecn_zn_ut_flg.disabled = true;
				formObj.ida_cust_eml.disabled=true;
				formObj.ida_co_type_cd.Enable=false;
				formObj.ida_ste_cd.value = "";
				formObj.ste_nm.value = "";
				formObj.ida_terr_div_cd.value = "";
				formObj.ida_pan_no.value="";
				formObj.ida_gst_rgst_no.value="";
				formObj.ida_spcl_ecn_zn_ut_flg.value = "";
				formObj.ida_cust_eml.value = "";
				ComSetObjValue(formObj.ida_co_type_cd,"");
				setFileNm("");
			}
       }
       
       function chkWorkNumb(strNumb) {
    	    strNumb = Replace(strNumb,"-");
    	    if (strNumb.length != 10) {
    	        alert("사업자등록번호가 잘못되었습니다.");
    	        return false;
    	    }
    	    
    	    sumMod = 0;
    	    sumMod += parseInt(strNumb.substring(0,1));
    	    sumMod += parseInt(strNumb.substring(1,2)) * 3 % 10;
    	    sumMod += parseInt(strNumb.substring(2,3)) * 7 % 10;
    	    sumMod += parseInt(strNumb.substring(3,4)) * 1 % 10;
    	    sumMod += parseInt(strNumb.substring(4,5)) * 3 % 10;
    	    sumMod += parseInt(strNumb.substring(5,6)) * 7 % 10;
    	    sumMod += parseInt(strNumb.substring(6,7)) * 1 % 10;
    	    sumMod += parseInt(strNumb.substring(7,8)) * 3 % 10;
    	    sumMod += Math.floor(parseInt(strNumb.substring(8,9)) * 5 / 10);
    	    sumMod += parseInt(strNumb.substring(8,9)) * 5 % 10;
    	    sumMod += parseInt(strNumb.substring(9,10));
    	    
    	    if (sumMod % 10 != 0) {
    	        alert("사업자등록번호가 잘못되었습니다.");
    	        return false;
    	    }
    	    return true;
    	}
    	 
    	function Replace(strString, strChar) {
    	    var strTmp = "";
    	    for (i = 0; i< strString.length; i++) {
    	        if (strString.charAt(i) != strChar) {
    	            strTmp = strTmp + strString.charAt(i);
    	        }
    	    }
    	    return strTmp;
    	} 
    	
    	function deleteMsg(){
    		ComShowCodeMessage("SAM00027");
    		if (document.form.delt_flg.checked == true) {
    			document.form.delt_flg.checked = false;
    		} else {
    			document.form.delt_flg.checked = true;
    		}
    	}
