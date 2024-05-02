/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CMS_0309.js
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
    function BCM_CMS_0309() {
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
    
    var request_flag = null;
    
    var bkg_alt_fm_dt_old = null;
    var bkg_alt_to_dt_old = null;
    var nvocc_bd_st_eff_dt_old = null;
    var nvocc_bd_end_eff_dt_old = null;
    
    var typeListXml = new Array();
	
	/** Event handler processing by button click event */
	document.onclick=processButtonClick;
	/** Event handler processing by button name */
	function processButtonClick() {
		/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
		
		var sheetObject=sheetObjects[0];
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
				doActionIBSheet(sheetObject,formObj,MULTI); 
			    formObj.rqst_no.readOnly=false;
				break;
			case "btn_Request":  
				doActionIBSheet(sheetObject,formObj,MULTI01);
				formObj.rqst_no.readOnly=false;
				break;
			case "btn_Close":
				self.close();
				break;
			case "btn_New":
				document.getElementById("btn_Request").style.color = "#D8D8D8";
				formObj.rqst_no.style.backgroundColor="#d4f6ff";
				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
				formObj.rqst_no.value="";
 				formObj.creflag.value="N";
 				formObj.saveflag.value="N";
 				formObj.rqst_no.readOnly=false;
 				formObj.bzet_addr.readOnly=false;
 				formObj.bzet_addr.style.backgroundColor="#d4f6ff";
 				formObj.srep_cd.readOnly=false;
 				ComBtnEnable("btn_Create");
 				ComBtnDisable("btn_Save");
 				ComBtnDisable("btn_Request");
 				ComEnableObject(formObj.grp_indiv_div, false);
 				requestdisable();
			    break;	
			case "btn_CheckDup":
			    param=param + "&cust_cnt_cd=" + formObj.cust_cnt_cd.value+" &cust_nm=" + formObj.cust_lgl_eng_nm.value+"&loc_cd=" 
				              + formObj.loc_cd.value+" &cust_rgst_no=" + formObj.cust_rgst_no.value;
				var rtn=ComOpenPopup('/hanjin/BCM_CMS_0304.do?' + param, 780, 470, '', '0,0', true); 
				break;

			case "btn_com_ens_0M1": // country pop-up
				var param="";
	    		param=param + "&" + "cust_cnt_cd=" + form.cust_cnt_cd.value;
	    		ComOpenPopup('/hanjin/COM_ENS_0M1.do?' + param, 780, 470, 'setCallBack0B5', '1,0,1,1,1,1,1,1', true);
				break;
             case "btn_com_ens_051": // location pop-up
				var param="";
	    		param=param + "&" + "loc_cd=" + form.loc_cd.value;
	    		if(!form.btn_com_ens_051.disabled)
	    			ComOpenPopup('/hanjin/COM_ENS_051.do?' + param, 780, 470, 'setCallBack0B1', '1,0,1,1,1,1,1,1', true);
				break;
             case "btn_com_ens_071": // office pop-up
 				var param="";
 	    		param=param + "&" + "ofc_cd=" + form.ofc_cd.value;
 	    		if(!form.btn_com_ens_071.disabled)
 	    			ComOpenPopup('/hanjin/COM_ENS_071.do?' + param, 780, 520, 'setCallBack0B3', '1,0,1,1,1,1,1,1', true);
 				break;
 			case "btn_bcm_cms_0301": //group customer pop-up
				var param="";	
	    		param=param + "cust_grp_id=" + form.cust_grp_id.value;
	    		if(!form.btn_bcm_cms_0301.disabled)
	    			ComOpenPopup('/hanjin/BCM_CMS_0301.do?' + param, 780, 430, 'setCustGrpId', '1,0,1,1,1,1,1,1', true);				
				break;
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
    			
            case "btn_Create":
            	document.getElementById("btn_Request").style.color = "#D8D8D8";
 				doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
 				formObj.rqst_no.value="";
 				formObj.creflag.value="Y";
 			    formObj.saveflag.value="N";
 			    formObj.bzet_addr.readOnly=false;
 			    formObj.bzet_addr.style.backgroundColor="#d4f6ff";
 				formObj.rqst_no.readOnly=true;
 				formObj.rqst_no.style.backgroundColor="#bebebe";
 				formObj.srep_cd.readOnly=false;
 				ComBtnDisable("btn_Create");
 				ComBtnDisable("btn_Request");
 				ComBtnEnable("btn_Save");
 				ComEnableObject(formObj.grp_indiv_div, true);
 				formObj.grp_indiv_div.style.backgroundColor="#d4f6ff";
 				requestdisable();
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
	   x_sheetObject1 = sheetObjects[0];  //customer main
 	   	
 	   axon_event.addListenerForm  ('keyup',    'obj_keyup',        document.form);  
 	   //axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
 	   //axon_event.addListener('keydown', 'ComKeyEnter', 'form');                             //엔터키 조회 이벤트처리
 	   
 	   ComBtnDisable("btn_Save");
 	   ComBtnDisable("btn_Request");
 	   ComEnableObject(formObj.grp_indiv_div, false);
 	   
	   if (!(ComIsNull(formObj.rqst_no.value))) {
		   doActionIBSheet(sheetObjects[0],formObj,SEARCH);
	   }

	   if (formObj.proc_tp_cd.value == "Create") {
		    doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
			formObj.rqst_no.value="";
			formObj.creflag.value="Y";
		    formObj.saveflag.value="N";
		    formObj.bzet_addr.readOnly=false;
		    formObj.bzet_addr.style.backgroundColor="#d4f6ff";
			formObj.rqst_no.readOnly=true;
			formObj.rqst_no.style.backgroundColor="#bebebe";
			ComBtnDisable("btn_Create");
			ComBtnEnable("btn_Save");
			ComBtnDisable("btn_Request");
			ComEnableObject(formObj.grp_indiv_div, true);
			formObj.grp_indiv_div.style.backgroundColor="#d4f6ff";
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
	    			InitColumnInfo(60, 0, 0, true);
	
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(true, true, false, true, false, false)
	    			var HeadTitle1 = " |";
	
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, HeadTitle1, true);
	
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,          40,    daCenter,  false,   "Seq");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_lgl_eng_nm");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "bzet_addr");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_rgst_no");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "loc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "ofc_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "srep_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "grp_indiv_div");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rvis_cntr_cust_tp_cd");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_grp_id");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "nmd_cust_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "delt_flg");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "rqst_sts");
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cts_no");
					
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
					
					InitDataProperty(0, cnt++ , dtData,         40,    daCenter,  false,   "cust_cd");

					
	            }
	            break;
	    }
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
		/*if (arrXml.length > 0) 
			ComXml2ComboItem(arrXml[0], formObj.indiv_corp_div_cd, "cd", "cd_desc");*/
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
					
					ComOpenWait(true);					
					
					formObj.f_cmd.value = SEARCH;
					
					formObj.creflag.value="R";

	    		    var sXml = sheetObj.GetSearchXml("BCM_CMS_0309GS.do", FormQueryString(formObj));				
					var arrXml = sXml.split("|$$|"); 
					
					if (arrXml.length > 0) {
						x_sheetObject1.LoadSearchXml(arrXml[0]); 
					}
					
	    		    if (sheetObj.CellValue(1, "cust_lgl_eng_nm") != undefined){
	    		    	formSettingVal(sheetObj,formObj,arrXml[0]);
	    		    	
	    		    } else {
	    		    	ComOpenWait(false);
		        		return;
	    		    }
	    		    	
	    		    ComOpenWait(false);
	    		    
	    		    formObj.creflag.value="N";
	    		    
	    		    bkg_alt_fm_dt_old = formObj.bkg_alt_fm_dt.value;
	    		    bkg_alt_to_dt_old = formObj.bkg_alt_fm_dt.value;
	    		    nvocc_bd_st_eff_dt_old = formObj.nvocc_bd_st_eff_dt.value;
	    		    nvocc_bd_end_eff_dt_old = formObj.nvocc_bd_end_eff_dt.value;
	    		    
	    		    if (formObj.delt_flg.value == "N" || formObj.delt_flg.value == "R" ){
	    		    	ComBtnEnable("btn_Request");
	    		    	ComBtnEnable("btn_Save");
	    		    	document.getElementById("btn_Request").style.color = "red";
	    		    } else {
	    		    	document.getElementById("btn_Request").style.color = "#D8D8D8";
	    		    	ComBtnDisable("btn_Request");
	    		    	ComBtnDisable("btn_Save");
	    		    }
	    		    requestdisable();
				
					ComBtnEnable("btn_Create");
					formObj.rqst_no.readOnly=true;
	 				formObj.rqst_no.style.backgroundColor="#bebebe";
	 				ComEnableObject(formObj.grp_indiv_div, false);
					break;		
		    		
				case MULTI:        //저장
					if(!validateForm(sheetObj,formObj,sAction)) {
						return false;
					}
					
					var confMsg;
					var saveMsg;
					if( formObj.creflag.value == "Y" && formObj.rqst_no.value == "" && formObj.grp_indiv_div.value == "I") {
						var param="";
						param=param + "&cust_cnt_cd=" + form.cust_cnt_cd.value+" &cust_nm=" + form.cust_lgl_eng_nm.value+"&loc_cd=" 
						              + form.loc_cd.value+" &cust_rgst_no=" + form.cust_rgst_no.value;
						ComOpenPopup('/hanjin/BCM_CMS_0304.do?' + param, 780, 470, "getBCM_CMS_0309_saveflag", '0,0', true);
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

					confMsg=ComGetMsg('CCD00023', 'request');
					saveMsg=ComGetMsg("COM130102", "Request");
					
					if (!confirm(confMsg)) {
						formObj.saveflag.value="N";
					    return false;
					}

					formObj.creflag.value="Y";
					formObj.f_cmd.value=MULTI01;
					var sParam = FormQueryString(formObj);

					ComOpenWait(true); //대기이미지 표시
					var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0309GS.do", sParam);
					var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
					
					
					formObj.creflag.value="N";
					if(sav == "S"  ){
						ComShowCodeMessage("COM130102", "Data"); 
						if (formObj.grp_indiv_div.value == "G"){
							setTimeout(function(){ 
								
									var sParam = FormQueryString(formObj);							
									
									var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0309GS.do", sParam);
									var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
					 				//formObj.cust_cd.readOnly=false;
					 				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
					 				ComOpenWait(false); //대기이미지 숨김
								
							}, 5000);
						} else {
							doActionIBSheet(sheetObjects[0], document.form, SEARCH);
							ComOpenWait(false); //대기이미지 숨김
						}
						
		 			}else{
		 				ComOpenWait(false); //대기이미지 숨김
		 				ComShowCodeMessage("COM130103", "Data");
		 			}
	 		 		break;
	 		 		
				case IBCLEAR:      //Initialization
					formObj.rqst_no.value="";
					formObj.reset();
					formObj.ibflag.value="I";

			    	ComSetObjValue(formObj.rvis_cntr_cust_tp_cd,"");
			    	ComSetObjValue(formObj.prf_cntr_tpsz_cd,"");
			    	ComSetObjValue(formObj.prf_svc_desc,"");
			    	ComSetObjValue(formObj.prf_svc_dtl_desc,"");
			    	ComSetObjValue(formObj.intl_phn_no,"");
			    	ComSetObjValue(formObj.intl_fax_no,"");
					break;	 
					
				case SEARCH02:      //Request no check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0309GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        ;
				        if(result=="" ){
				        	ComShowCodeMessage("COM130402", "Request No");
				        	formObj.rqst_no.value="";
				        }
						ComOpenWait(false);
					}
					break

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
				        	formObj.rqst_no.value="";
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
				        	//document.form.srep_cd.focus();
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
				        	//document.form.cust_grp_id.focus();
				        }
						ComOpenWait(false);
					}
					break;
					
		    	case SEARCH13:      //Customer register no check
					if(validateForm(sheetObj,formObj,sAction)){
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH13;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSearchXml("BCM_CMS_0309GS.do", sParam);
				        var result=ComGetEtcData(sXml, "result");
				        if(result!=""){
				        	ComShowCodeMessage("SAM00007","Tax Payer ID");
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
				        	//document.form.prf_svc_desc.focus();
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
				        	//document.form.prf_svc_dtl_desc.focus();
				        }
						ComOpenWait(false);
					}
					break;
					
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
		}
	}
	/**
	 * Customer Code Pop up to read from. <br>
	 */
	function setCallBack0B2(aryPopupData) {
		var form=document.form;
		form.rqst_no.value=aryPopupData[0][3];
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
	function setCallBack0B5(aryPopupData) {
		var form=document.form;
		if (form.cust_cnt_cd.value != aryPopupData[0][3]){
			form.cust_cnt_cd.value=aryPopupData[0][3];
			if (form.ibflag.value=="N") {
				form.ibflag.value="U";
			}
		}
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
	    		if( ComIsNull(formObj.rqst_no) ){
	    			ComShowCodeMessage("CCD00001", "Customer Code");
	    			document.form.rqst_no.focus();
	    			return false;
	    		}
	    		break;
	    	case SEARCH08:
	    		if(formObj.loc_cd.value == "" || formObj.loc_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Location Code");
//	    			document.form.loc_cd.focus();
	    			return false;
	    		}
	    		break;
	    	case MULTI:
	    		if(ComTrim(formObj.cust_lgl_eng_nm.value) == "" || formObj.cust_lgl_eng_nm.value == null){
	    			ComShowCodeMessage("CCD00001", "Legal English Name");
	    			document.form.cust_lgl_eng_nm.focus();
	    			return false;
	    		}
	    		if (formObj.grp_indiv_div.value == "G" && formObj.cust_lgl_eng_nm.value.length>50){
        			ComShowCodeMessage("SAM00028", "Group Customer Name-50");
        			document.form.cust_lgl_eng_nm.focus();
        			return false;
        		}
	    		if((ComTrim(formObj.bzet_addr.value) == "" || formObj.bzet_addr.value == null) && formObj.creflag.value == "Y"){
	    			ComShowCodeMessage("CCD00001", "Address");
	    			document.form.bzet_addr.focus();
	    			return false;
	    		}
	    		if(formObj.loc_cd.value == "" || formObj.loc_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "Location Code");
	    			document.form.loc_cd.focus();
	    			return false;
	    		}
	    		if(formObj.ofc_cd.value == "" || formObj.ofc_cd.value == null){
	    			ComShowCodeMessage("CCD00001", "REP. Office");
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
	    		if(ComGetObjValue(formObj.grp_indiv_div) == "" || ComGetObjValue(formObj.grp_indiv_div) == null){
	    			ComShowCodeMessage("CCD00001", "Group/Individual");
	    			document.form.grp_indiv_div.focus();
	    			return false;
	    		}
	    		
	    		// date change
	    		if (formObj.ibflag.value != "I" &&
	    				(formObj.nvocc_bd_st_eff_dt.value != nvocc_bd_st_eff_dt_old || formObj.nvocc_bd_end_eff_dt.value != nvocc_bd_end_eff_dt_old || formObj.bkg_alt_fm_dt.value != bkg_alt_fm_dt_old || formObj.bkg_alt_to_dt.value != bkg_alt_to_dt_old)){
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
	    		
	    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.cust_rgst_no.value == "" && formObj.nmd_cust_flg.value != "Y" && ComGetObjValue(formObj.grp_indiv_div) == "I"){
	    			ComShowCodeMessage("SAM00022");
	    			document.form.cust_rgst_no.focus();
	    			return false;
	    		}
	    		
	    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.nmd_cust_flg.value != "Y"  && ComGetObjValue(formObj.grp_indiv_div) == "I"){
	    			if (!chkWorkNumb(formObj.cust_rgst_no.value)){
	    				document.form.cust_rgst_no.focus();
	    				return false;
	    			}
	    		}
	    		if (formObj.loc_cd.value.substr(0,2) == "KR" && formObj.cust_rgst_no.value != ""){
	    			//doActionIBSheet(sheetObjects[0],formObj,SEARCH13);
	    			formObj.f_cmd.value=SEARCH13;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchXml("BCM_CMS_0309GS.do", sParam);
			        var result=ComGetEtcData(sXml, "result");
			        if(result!=""){
			        	ComShowCodeMessage("SAM00007","Tax Payer ID");
						return false;
			        }
	    		}
	    			
                break;
               
	    	case MULTI01:
	    		if (formObj.ibflag.value == "U"){
	    			if (ComShowConfirm(ComGetMsg("SAM00010"))) {
	    				request_flag = "Y";
	    				doActionIBSheet(sheetObj,formObj,MULTI);
	    				if (request_flag == "Y") {
	    					return false;
	    				}
	    			} else {
						return false;
					}
	    		}
	    		
	    		if (formObj.nmd_cust_flg.checked){
	    			if (!ComShowConfirm(ComGetMsg("SAM00011"))) { 
						return false;
					}
	    		}
	    		break;
	    	}
	    	return true;
		}
	   /**
        * When Save, Call Function 
       */
	    function setSave(confMsg, saveMsg) {
			var formObj   = document.form;
			var sheetObj  = sheetObjects[0];
			//if (formObj.cust_seq.value == "" && formObj.saveflag.value == "N") return;	
			if (request_flag != "Y"){
				if (!confirm(confMsg)) {
					formObj.saveflag.value="N";
				    return false;
				}
			}
			if (formObj.cust_cnt_cd.value == "" ) {
				formObj.cust_cnt_cd.value=formObj.loc_cd.value.substr(0,2);
			}

			formObj.f_cmd.value=MULTI;
      	    
      	    //if (sParam1+sParam2+sParam3 == "") return;
      	    var sParam = FormQueryString(formObj);

			ComOpenWait(true); //대기이미지 표시

			var SaveXml = sheetObj.GetSaveXml("BCM_CMS_0309GS.do", sParam);
			var sav=ComGetEtcData(SaveXml, "TRANS_RESULT_KEY");
			
			ComOpenWait(false); //대기이미지 숨김
			
			if(sav == "S"  ){
				formObj.rqst_no.value = ComGetEtcData(SaveXml, "rqstNo");

				ComShowCodeMessage("SAM00029");
 				//ComShowCodeMessage("COM130102", "Data");
 				formObj.rqst_no.readOnly=false;
 				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
 				request_flag = "N";
 			}else{
 				ComShowCodeMessage("COM130103", "Data");
 			}
	   }
		 /**
	     * Call Back Function  
	     */
	   function getBCM_CMS_0309_saveflag(saveFlag) {
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
		  		if(srcName != "rqst_no" && formObj.ibflag.value != 'I'){
		  			formObj.ibflag.value					="U";
		  		}
		  	}
		  	
		  	switch(srcName) {
				case "rqst_no":
					doActionIBSheet(sheetObjects[0], formObj, SEARCH02);
			  		if(formObj.rqst_no.value.length>2){	   
		           		//doActionIBSheet(sheetObjects[0], formObj, SEARCH09);
		    			if(formObj.rqst_no.value.length==0){
	            			document.form.rqst_no.focus();
		        		}else{
		    				formObj.ibflag.value="U";
		    				formObj.rqst_no.readOnly=true;		
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
	            case "cust_eml":
	            	if (!checkEmailValue(formObj.cust_eml)){
	            		formObj.cust_eml.value = "";
	            		document.form.cust_eml.focus();
	            	}
	            	break;
	            case "grp_indiv_div":
	            	if (formObj.grp_indiv_div.value == "I"){
	            		formObj.cust_lgl_eng_nm.setAttribute("maxLength","100");
	            	} else {
	            		formObj.cust_lgl_eng_nm.setAttribute("maxLength","50");
	            		if(formObj.cust_lgl_eng_nm.value.length>50){
	            			ComShowCodeMessage("SAM00028", "Group Customer Name-50");
	            			document.form.cust_lgl_eng_nm.focus();
	            		}
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
		// International phn no 변경시
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
		
	    function formSettingVal(sheetObj,formObj,sXml){
	    	formObj.cust_lgl_eng_nm.value 		= sheetObj.CellValue(1, "cust_lgl_eng_nm");
	    	formObj.bzet_addr.value 			= sheetObj.CellValue(1, "bzet_addr");
	    	formObj.cust_rgst_no.value 			= sheetObj.CellValue(1, "cust_rgst_no");
	    	formObj.loc_cd.value 				= sheetObj.CellValue(1, "loc_cd");
	    	formObj.ofc_cd.value 				= sheetObj.CellValue(1, "ofc_cd");
	    	formObj.srep_cd.value 				= sheetObj.CellValue(1, "srep_cd");
	    	formObj.grp_indiv_div.value 		= sheetObj.CellValue(1, "grp_indiv_div");
	    	//formObj.cust_cd.value 				= sheetObj.CellValue(1, "cust_cd");
	    	
	    	ComSetObjValue(formObj.rvis_cntr_cust_tp_cd,sheetObj.CellValue(1, "rvis_cntr_cust_tp_cd"));
	    	
	    	formObj.cust_grp_id.value 			= sheetObj.CellValue(1, "cust_grp_id");
	    	formObj.cts_no.value 				= sheetObj.CellValue(1, "cts_no");
	    	//More info1
			formObj.intl_phn_no.value 			= sheetObj.CellValue(1, "intl_phn_no");
			formObj.phn_no.value 				= sheetObj.CellValue(1, "phn_no");
			formObj.intl_fax_no.value 			= sheetObj.CellValue(1, "intl_fax_no");
			formObj.fax_no.value 				= sheetObj.CellValue(1, "fax_no");
			formObj.cust_eml.value 				= sheetObj.CellValue(1, "cust_eml");
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
			formObj.delt_flg.value				= sheetObj.CellValue(1, "delt_flg");
			formObj.rqst_sts.value				= sheetObj.CellValue(1, "rqst_sts");
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
			//More Info2
			formObj.nvocc_lic_no.value				= sheetObj.CellValue(1, "nvocc_lic_no");
			formObj.nvocc_bd_no.value				= sheetObj.CellValue(1, "nvocc_bd_no");
			formObj.nvocc_bd_amt.value				= sheetObj.CellValue(1, "nvocc_bd_amt");
			formObj.nvocc_hjs_scac_cd.value			= sheetObj.CellValue(1, "nvocc_hjs_scac_cd");
			formObj.frt_fwrd_fmc_no.value			= sheetObj.CellValue(1, "frt_fwrd_fmc_no");
			formObj.nvocc_bd_st_eff_dt.value		= sheetObj.CellValue(1, "nvocc_bd_st_eff_dt");
			formObj.nvocc_bd_end_eff_dt.value		= sheetObj.CellValue(1, "nvocc_bd_end_eff_dt");
			formObj.oti_orz_no.value				= sheetObj.CellValue(1, "oti_orz_no");
			
			if (formObj.grp_indiv_div.value == "I"){
        		formObj.cust_lgl_eng_nm.setAttribute("maxLength","100");
        	} else {
        		formObj.cust_lgl_eng_nm.setAttribute("maxLength","50");
        	}
			
	    	formObj.ibflag.value				="N";
		 }	  
	    
	    function callShowMessageAddSeq() {
	    	ComShowCodeMessage("COM12130", "click event", "AddSeq button");
	    }
	    
	    function requestdisable(){
	    	var formObj = document.form;

	    	if (formObj.rqst_sts.value == "Requested" || formObj.rqst_sts.value == "Approved" ){
	    		formObj.cust_lgl_eng_nm.disabled=true;
	    		formObj.bzet_addr.disabled=true;
	    		formObj.cust_rgst_no.disabled=true;
	    		formObj.loc_cd.disabled=true;
	    		formObj.ofc_cd.disabled=true;
	    		formObj.srep_cd.disabled=true;
	    		formObj.cts_no.disabled=true;
	    		formObj.cust_grp_id.disabled=true;
	    		formObj.phn_no.disabled=true;
	    		formObj.fax_no.disabled=true;
	    		formObj.cust_eml.disabled=true;
	    		formObj.cust_url.disabled=true;
	    		formObj.cmpt_desc.disabled=true;
	    		formObj.spcl_req_desc.disabled=true;
	    		formObj.crnt_vol_knt.disabled=true;
	    		formObj.new_key_acct_flg.disabled=true;
	    		formObj.rgn_acct_flg.disabled=true;
	    		formObj.cust_rmk.disabled=true;
	    		formObj.bkg_alt_rsn.disabled=true;
	    		formObj.bkg_alt_fm_dt.disabled=true;
	    		formObj.bkg_alt_to_dt.disabled=true;
	    		formObj.bkg_alt_msg.disabled=true;
	    		formObj.nvocc_lic_no.disabled=true;
	    		formObj.nvocc_bd_no.disabled=true;
	    		formObj.nvocc_bd_amt.disabled=true;
	    		formObj.nvocc_hjs_scac_cd.disabled=true;
	    		formObj.frt_fwrd_fmc_no.disabled=true;
	    		formObj.nvocc_bd_st_eff_dt.disabled=true;
	    		formObj.nvocc_bd_end_eff_dt.disabled=true;
	    		formObj.oti_orz_no.disabled=true;
	    		
	    		formObj.nmd_cust_flg.disabled = true;
	    		formObj.new_key_acct_flg.disabled = true;
	    		formObj.rgn_acct_flg.disabled = true;
	    		formObj.btn_com_ens_051.disabled = true;
	    		formObj.btn_com_ens_071.disabled = true;
	    		formObj.btn_com_ens_043.disabled = true;   
	    		formObj.btn_bcm_cms_0301.disabled = true;  
	    		
	    		formObj.rvis_cntr_cust_tp_cd.Enable=false;
	    		formObj.prf_svc_desc.Enable=false;
	    		formObj.prf_svc_dtl_desc.Enable=false;
	    		formObj.intl_phn_no.Enable=false;
	    		formObj.intl_fax_no.Enable=false;
	    		formObj.prf_cntr_tpsz_cd.Enable=false;
	    		
	    	} else {
	    		formObj.cust_lgl_eng_nm.disabled=false;
	    		formObj.bzet_addr.disabled=false;
	    		formObj.cust_rgst_no.disabled=false;
	    		formObj.loc_cd.disabled=false;
	    		formObj.ofc_cd.disabled=false;
	    		formObj.srep_cd.disabled=false;
	    		formObj.cts_no.disabled=false;
	    		formObj.cust_grp_id.disabled=false;
	    		formObj.phn_no.disabled=false;
	    		formObj.fax_no.disabled=false;
	    		formObj.cust_eml.disabled=false;
	    		formObj.cust_url.disabled=false;
	    		formObj.cmpt_desc.disabled=false;
	    		formObj.spcl_req_desc.disabled=false;
	    		formObj.crnt_vol_knt.disabled=false;
	    		formObj.new_key_acct_flg.disabled=false;
	    		formObj.rgn_acct_flg.disabled=false;
	    		formObj.cust_rmk.disabled=false;
	    		formObj.bkg_alt_rsn.disabled=false;
	    		formObj.bkg_alt_fm_dt.disabled=false;
	    		formObj.bkg_alt_to_dt.disabled=false;
	    		formObj.bkg_alt_msg.disabled=false;
	    		formObj.nvocc_lic_no.disabled=false;
	    		formObj.nvocc_bd_no.disabled=false;
	    		formObj.nvocc_bd_amt.disabled=false;
	    		formObj.nvocc_hjs_scac_cd.disabled=false;
	    		formObj.frt_fwrd_fmc_no.disabled=false;
	    		formObj.nvocc_bd_st_eff_dt.disabled=false;
	    		formObj.nvocc_bd_end_eff_dt.disabled=false;
	    		formObj.oti_orz_no.disabled=false;
	    		
	    		formObj.nmd_cust_flg.disabled = false;
	    		formObj.new_key_acct_flg.disabled = false;
	    		formObj.rgn_acct_flg.disabled = false;
	    		formObj.btn_com_ens_051.disabled = false;
	    		formObj.btn_com_ens_071.disabled = false;
	    		formObj.btn_com_ens_043.disabled = false;  
	    		formObj.btn_bcm_cms_0301.disabled = false;  
	    		
	    		formObj.rvis_cntr_cust_tp_cd.Enable=true;
	    		formObj.prf_svc_desc.Enable=true;
	    		formObj.prf_svc_dtl_desc.Enable=true;
	    		formObj.intl_phn_no.Enable=true;
	    		formObj.intl_fax_no.Enable=true;
	    		formObj.prf_cntr_tpsz_cd.Enable=true;
	    	}
	    	
	    	return;
	    }
	    
       function ComImageChange(name, imagePath, disabled) {
	   		var img = eval('document.form.' + name);
	   		img.src = imagePath;
	   		img.disabled = disabled;
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
		
       function ComImageChange(name, imagePath, disabled) {
	   		var img = eval('document.form.' + name);
	   		img.src = imagePath;
	   		img.disabled = disabled;
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
       