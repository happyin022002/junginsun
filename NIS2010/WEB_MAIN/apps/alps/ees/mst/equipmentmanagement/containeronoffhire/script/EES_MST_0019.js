/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mst_0019.js
*@FileTitle : Container Master Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.16 이호선
* 1.0 Creation
* history 
* 2013.07.23 채창호 [CHM-201325661] ALPS Master-Master Inquiry 및 Status Update/Inquiry화면에서  컨테이너 번호 입력란 로직 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ees_mst_0019 : ees_mst_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mst_0019() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var timer = '';
 var SEARCH_ENABLE = true;
 var bkg_click = false;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

     // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var formObj = document.form;

         try {
             var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
					case "btn_retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
					case "btn_new":
						formObj.cntr_no.value  = "";
						initDisplay(); 
						formObj.cntr_no.focus();
					break;
					
					case "btn_spec":
						openPopupSpec();
					break;
					
					case "btn_mvmt":
						openPopupMVMT();
					break;
					
					case "btn_status":
						openPopupStatus();
					break;
					
					case "btn_mnr":
						openPopupMnr();
					break;
					
					case "btn_doldoc":
						openPopupAGMT();
					break;
					
					case "btn_close":
						window.close();
					break;					
             } // end switch
         }catch(e) {
             if( e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e);
             }
         }
     }

     /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
     
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         //페이지 로드시 선처리 기능을 호출한다.
         for(i=0;i<sheetObjects.length;i++){
             //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
         }
     	 initControl();         
     }

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no1"); //- 키 눌렸을때
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no2"); //- 키 눌렸을때
  		axon_event.addListener('dblclick','obj_dblclick_1',	"bkg_no3"); //- 키 눌렸을때
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no1"); //- 키 눌렸을때
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no2"); //- 키 눌렸을때
  		axon_event.addListener('click','obj_dblclick1',	"bkg_no3"); //- 키 눌렸을때
  		axon_event.addListener('click','obj_dblclick4',	"lse_vndr_url"); //- 키 눌렸을때
	    axon_event.addListenerFormat('blur',    'obj_blur',     form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_focus',    form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때
		axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- 키 눌렸을때
		axon_event.addListenerFormat('keypress','obj_keypress',	form); //- 키 눌렸을때  
		axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때.
		axon_event.addListenerForm('onpaste',	'obj_change',	form); //- 변경될때.
		
		ComSetFocus(formObj.cntr_no);
  		
  		if (formObj.cntr_no.value.length > 0){
  		    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  		    ComSetFocus(formObj.cntr_no);
  		}    
  	}       
      
	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
	    //ComChkObjValid(event.srcElement);
	}
	
	function obj_focus(){
	    //ComClearSeparator(event.srcElement);
	}
	
  	/**
 	 * Key-Down Event 처리
 	 */
	 
 	function obj_keydown() {
		var obj      = event.srcElement;
		var vKeyCode = event.keyCode;
		var ctrlKey = event.ctrlKey;
		var formObj  = document.form;
		switch (obj.name) {
			case "cntr_no":
			if ( vKeyCode == 9 || vKeyCode == 13 ) {
				SEARCH_ENABLE = false;
	  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	  			SEARCH_ENABLE = true;
	  			ComSetFocus(formObj.cntr_no);
	  		}
	  		break;
  		}	
	} 	 
 	 
   	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;
   		switch(obj.name) {
			case "cntr_no":
  				if ( ComTrim(ComGetObjValue(obj)) != "" ) {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  		}		
  	}	
  		
	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
    	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "cntr_no":
	    			if ( SEARCH_ENABLE ) {
	    				formObj.chk_dgt.value ="";
	    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase(); // Copy&paste 소문자를 대문자로 변경
	    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	    				ComSetFocus(formObj.cntr_no);
	    			}
					break;	
		    }
		}	
	}		
 	 
 	function obj_keypress(){
	    
	    var obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	    
	    switch(obj.dataformat) {
	        case "engup":
	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "int":
	        	if(obj.name=="chk_dgt") ComKeyOnlyNumber('int');
	        break;
	    }        
	}
 	
 	function obj_dblclick1(){
 		
 		var formObj  = document.form;	
 		var obj = event.srcElement;
		var chkBkgNo = "";
		if (bkg_click == true) return;
		bkg_click = true;
		if(obj.name == "bkg_no1"){
			chkBkgNo = formObj.bkg_no1.value;
		} else if (obj.name == "bkg_no2"){
			chkBkgNo = formObj.bkg_no2.value;
		} else if (obj.name == "bkg_no3"){
			chkBkgNo = formObj.bkg_no3.value;
		}
		
		if ( chkBkgNo != "" ) {
	        var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+chkBkgNo;
	        try {
	        ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, false, "yes");
	        } catch( e ) {
	        	alert("e :::"+e)
	        }
		}
		bkg_click = false;
		/*
		var sUrl    = "ESM_BKG_0079_Q.do?bkg_no="+chkBkgNo;
		var iWidth  = 1024;
		var iHeight = 700;
		var sTargetObjList = "cntr_spec_no:cntr_spec_no";
		var sDisplay = "0,1";
		
		var param = "?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";
        
		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);		
		*/
 	}
 	
 	function obj_dblclick_1(){
 		var formObj  = document.form;	
 		var obj = event.srcElement;
		var chkBkgNo = "";
		
		if (bkg_click == true) return;
		bkg_click = true;
		
		if(obj.name == "bkg_no1"){
			chkBkgNo = formObj.bkg_no1.value;
		} else if (obj.name == "bkg_no2"){
			chkBkgNo = formObj.bkg_no2.value;
		} else if (obj.name == "bkg_no3"){
			chkBkgNo = formObj.bkg_no3.value;
		}
		
		if ( chkBkgNo != "" ) {
	        var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+chkBkgNo;
	        try {
	        ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, false, "yes");
	        } catch( e ) {
	        	alert("e :::"+e)
	        }
		}
		bkg_click = false;
 	}
 	
 	function obj_dblclick4(){
 		var formObj  = document.form;		
		var lsevndrurl = formObj.lse_vndr_url.value;

		if ( lsevndrurl != "" ) {
			window.open(lsevndrurl, "", "");
		}
 	}
 	
    /**
    * Pop-up Open 부분<br>
    */
   function openPopupSpec(){
		var formObj = document.form;
		
		var sUrl    = '/hanjin/EES_MST_0021.do';
		var iWidth  = 1020;
		var iHeight = 630;
		var sTargetObjList = "cntr_spec_no:cntr_spec_no";
		var sDisplay = "0,1";
		
		var param = "?cntr_spec_no="+formObj.cntr_spec_no.value+"&popflag=1";

		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   } 	
  	
   /**
    * Pop-up Open 부분<br>
    */
   function openPopupStatus(){
		var formObj = document.form;
		
		var sUrl    = '/hanjin/EES_MST_0029.do';
		var iWidth  = 1010;
		var iHeight = 635;
		var sTargetObjList = "cntr_no:cntr_no";
		var sDisplay = "0,1";
		
		var param = "?cntr_no="+formObj.cntr_no.value+"&popflag=1";

		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   }
    
   function openPopupAGMT(){
		var formObj = document.form;
		
		var sUrl    = '/hanjin/EES_LSE_0095Pop.do';
		var iWidth  = 1050;
		var iHeight = 650;
		var sTargetObjList = "agmt_seq:agmt_seq";
		var sDisplay = "0,1";
		
		var tmpseqno = formObj.onh_agmt_no.value.substr(3);
		var tmpseqno_1 = "";
		for (var i = 0; i < tmpseqno.length; i++){
			if(tmpseqno.substr(i,1) == "0"){
				tmpseqno_1 = tmpseqno.substr(i+1);
			} else {
				break;
			}
			
		}
		if (formObj.onh_agmt_no.value != ""){
			var param = "?agmt_seq="+tmpseqno_1;
		}

		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);
   }
   
   function openPopupMnr(){
		var formObj = document.form;
		
		var sUrl    = '/hanjin/EES_MNR_0028.do';
		var iWidth  = 1030;
		var iHeight = 700;
		var sTargetObjList = "";
		var sDisplay = "0,1";
		
		if (formObj.cntr_no.value != ""){
			var param = "?from_sys=MST&eq_no="+formObj.cntr_no.value+formObj.chk_dgt.value+"&eq_type=U";
		}

		ComOpenPopupWithTarget(sUrl+param, iWidth, iHeight, sTargetObjList, sDisplay, true);	   
   }
   
   function openPopupMVMT(){
	  var formObj = document.form;
      var cnmv_dt = ComGetNowInfo("ymd"); //formObj.cnmv_dt.value;
      
      ComOpenPopupWithTarget("/hanjin/EES_CTM_0408.do?" +
              "p_cntrno=" + formObj.cntr_no.value + "&" +
              "check_digit=" + formObj.chk_dgt.value + "&" +
              "ctnr_tpsz_cd=" + formObj.cntr_tpsz_cd.value + "&" +
              "p_date1=" + ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
              "p_date2=" + ComGetDateAdd(cnmv_dt, "M", 0, "-", true), 1020, 682, "", "0,1", true);
      
   }
   
  /**
   * 시트 초기설정값, 헤더 정의
   * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
   * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   */
  function initSheet(sheetObj,sheetNo) {
      var cnt = 0;
      switch(sheetNo) {
          case 1:      //sheet1 init
              with (sheetObj) {

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             }
          break;
      }
  }      
      
  // Sheet관련 프로세스 처리
  function doActionIBSheet(sheetObj,formObj,sAction) {
      //sheetObj.ShowDebugMsg = false;
      switch(sAction) {
		case IBSEARCH:      //조회
		        initDisplay();
            	formObj.f_cmd.value = SEARCH;
            	if (formObj.cntr_no.value.trim().length == 0) {
            		ComShowCodeMessage("MST00001", "Cntr No.");
            		ComSetFocus(formObj.cntr_no);
            		return;
            	}
            	sheetObj.WaitImageVisible=false;            	
            	ComOpenWait(true);	
            	var sXml = sheetObj.GetSearchXml("EES_MST_0019GS.do", FormQueryString(formObj));
            	var chk = sXml.indexOf("ERROR");
            	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
            		sheetObj.LoadSearchXml(sXml);
            		ComOpenWait(false);
            		return;
            	}
                // 입력 박스 데이타 채우기 	  
            	formObj.chk_dgt.value          = ComXmlString(sXml, "chk_dgt");
            	var aciacstr     = ComXmlString(sXml, "aciac_div_cd");
            	
        		if (aciacstr == "Active") {
        			div_dcond1.style.display = "inline";
        			div_dcond2.style.display = "none";
        			formObj.aciac_div_cd1.value = "Active";
        		} else if (aciacstr == "Inactive") {
        			div_dcond1.style.display = "none";
        			div_dcond2.style.display = "inline";
        			formObj.aciac_div_cd2.value = "Inactive";
        		} else {
        			div_dcond1.style.display = "inline";
        			div_dcond2.style.display = "none";
        			formObj.aciac_div_cd1.value = "";
        			ComOpenWait(false);
        			ComShowCodeMessage("MST02026");
        			return;
        		}
            	
            	formObj.cntr_tpsz_cd.value     = ComXmlString(sXml, "cntr_tpsz_cd");
            	formObj.lstm_cd.value          = ComXmlString(sXml, "lstm_cd");
            	formObj.cntr_tpsz_iso_cd.value = ComXmlString(sXml, "cntr_tpsz_iso_cd");
            	formObj.cntr_mtrl_cd.value	   = ComXmlString(sXml, "cntr_mtrl_cd");  
            	if (ComXmlString(sXml, "tare_wgt").toString() != "")
            	   formObj.tare_wgt.value          = ComAddComma(ComXmlString(sXml, "tare_wgt").toString());
            	if (ComXmlString(sXml, "tare_wgt_lbs").toString() != "")
            	   formObj.tare_wgt_lbs.value      = ComAddComma(ComXmlString(sXml, "tare_wgt_lbs").toString());
            	formObj.cntr_use_co_cd.value    = ComXmlString(sXml, "cntr_use_co_cd");
            	formObj.ownr_co_cd.value        = ComXmlString(sXml, "ownr_co_cd");
            	formObj.vndr_abbr_nm.value      = ComXmlString(sXml, "vndr_abbr_nm");
            	formObj.vndr_lgl_eng_nm.value   = ComXmlString(sXml, "vndr_lgl_eng_nm");
            	formObj.mft_dt.value            = ComXmlString(sXml, "mft_dt");
            	if (ComXmlString(sXml, "d2_payld_flg") == 'Y')
            	    formObj.d2_payld_flg.checked = true;
            	formObj.rf_tp_cd.value          = ComXmlString(sXml, "rf_tp_cd");
            	formObj.cnmv_sts_cd.value       = ComXmlString(sXml, "cnmv_sts_cd");
            	formObj.crnt_yd_cd.value        = ComXmlString(sXml, "crnt_yd_cd");
            	formObj.vsl_cd.value            = ComXmlString(sXml, "vsl_cd");
            	formObj.skd_voy_no.value        = ComXmlString(sXml, "skd_voy_no");
            	formObj.skd_dir_cd.value        = ComXmlString(sXml, "skd_dir_cd");
            	formObj.cnmv_dt.value           = ComXmlString(sXml, "cnmv_dt");
            	if (ComXmlString(sXml, "full_flg") == 'Y')
            	    formObj.full_flg.checked = true;
            	if (ComXmlString(sXml, "dmg_flg") == 'Y')
            	    formObj.dmg_flg.checked = true;
            	if (ComXmlString(sXml, "imdt_ext_flg") == 'Y')
            	    formObj.imdt_ext_flg.checked = true;
            	formObj.cntr_hngr_rck_cd.value  = ComXmlString(sXml, "cntr_hngr_rck_cd");
            	formObj.mnr_hngr_bar_tp_cd.value  = ComXmlString(sXml, "mnr_hngr_bar_tp_cd");
            	formObj.cntr_hngr_bar_atch_knt.value = ComAddComma(ComXmlString(sXml, "cntr_hngr_bar_atch_knt").toString());
            	if (ComXmlString(sXml, "disp_flg") == 'Y')
            	    formObj.disp_flg.checked = true;
            	if (ComXmlString(sXml, "plst_flr_flg") == 'Y')
            	    formObj.plst_flr_flg.checked = true;
            	if (ComXmlString(sXml, "uclm_ls") == "L")
            		formObj.ls_flg.checked = true;
            	if (ComXmlString(sXml, "uclm_ls") == "U")
            		formObj.uc_flg.checked = true;
            	if (ComXmlString(sXml, "uclm_ls") == ""){
            		formObj.ls_flg.checked = false;
            		formObj.uc_flg.checked = false;
            	}
            	
            	formObj.onh_dt.value            = ComXmlString(sXml, "onh_dt");
            	formObj.onh_cntr_sts_cd.value   = ComXmlString(sXml, "onh_cntr_sts_cd");
            	formObj.onh_agmt_no.value       = ComXmlString(sXml, "onh_agmt_no");
            	formObj.vndr_seq.value          = ComXmlString(sXml, "vndr_seq");
            	formObj.lessor_nm.value         = ComXmlString(sXml, "lessor_nm");
            	if (ComXmlString(sXml, "dpc_val").toString() != "")
            	   formObj.dpc_val.value           = ComAddComma(ComXmlString(sXml, "dpc_val").toString())
            	else
            		formObj.dpc_val.value          = "0";	
            	if (ComXmlString(sXml, "using_days").toString() != "")
            	   formObj.using_days.value        = ComAddComma(ComXmlString(sXml, "using_days").toString());
            	formObj.cre_dt.value            = ComXmlString(sXml, "cre_dt");
            	formObj.cre_usr_id.value        = ComXmlString(sXml, "cre_usr_id");
            	formObj.upd_dt.value            = ComXmlString(sXml, "upd_dt");
            	formObj.upd_usr_id.value        = ComXmlString(sXml, "upd_usr_id");
            	formObj.cntr_sts_cd.value       = ComXmlString(sXml, "cntr_sts_cd");
            	formObj.cntr_sts_evnt_dt.value  = ComXmlString(sXml, "cntr_sts_evnt_dt");
            	formObj.exit_agmt_no.value      = ComXmlString(sXml, "exit_agmt_no");
            	formObj.exit_vndr_seq.value     = ComXmlString(sXml, "exit_vndr_seq");
            	formObj.exit_vndr_eng_nm.value  = ComXmlString(sXml, "exit_vndr_eng_nm");
            	formObj.dpp_tp_cd.value         = ComXmlString(sXml, "dpp_tp_cd");
            	formObj.sub_lstm_cd.value       = ComXmlString(sXml, "sub_lstm_cd");
            	formObj.cntr_spec_no.value      = ComXmlString(sXml, "cntr_spec_no");
            	formObj.off_hire_avail.value    = ComXmlString(sXml, "off_hire_avail");
            	formObj.hid_off_hire_avail.value = ComXmlString(sXml, "off_hire_avail");
            	formObj.bkg_no1.value    = ComXmlString(sXml, "bkg_no1");
            	formObj.bkg_no2.value    = ComXmlString(sXml, "bkg_no2");
            	formObj.bkg_no3.value    = ComXmlString(sXml, "bkg_no3");
            	if (ComXmlString(sXml, "dpp_amt").toString() != "")
            	   formObj.dpp_amt.value    = ComAddComma(ComXmlString(sXml, "dpp_amt").toString())
            	else
            		formObj.dpp_amt.value   = "0";	
            	if (ComXmlString(sXml, "cost_amt").toString() != "")
            	   formObj.cost_amt.value   = ComAddComma(ComXmlString(sXml, "cost_amt").toString())
            	else    
            	   formObj.cost_amt.value   = "0";
            	if (ComXmlString(sXml, "rntl_chg_amt").toString() != "")
            	   formObj.rntl_chg_amt.value  = ComAddComma(ComXmlString(sXml, "rntl_chg_amt").toString())
            	else
            	   formObj.rntl_chg_amt.value  = "0";
            	formObj.lse_vndr_url.value = ComXmlString(sXml, "lse_vndr_url");
            	
            	formObj.certi_no.value    = ComXmlString(sXml, "certi_no");
            	formObj.apro_csc_no.value = ComXmlString(sXml, "apro_csc_no");
            	formObj.apro_tir_no.value = ComXmlString(sXml, "apro_tir_no");
            	formObj.rf_mkr_seq.value =  ComXmlString(sXml, "rf_mkr_seq");
            	formObj.rf_mdl_nm.value  =  ComXmlString(sXml, "rf_mdl_nm");
            	formObj.rf_rfr_no.value  =  ComXmlString(sXml, "rf_rfr_no"); 
            	formObj.min_temp.value   =  ComXmlString(sXml, "min_temp"); 
            	formObj.max_temp.value   =  ComXmlString(sXml, "max_temp");
            	if (ComXmlString(sXml, "cntr_rsk_flg").toString() != "N"){
            		formObj.cntr_rsk_flg.value ="At Risk";
            	}
            	
            	timer = window.setInterval('clock()', 50);
            	ComOpenWait(false);
		break;
      }
  }
      
  /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
  function validateForm(sheetObj,formObj,sAction){
      return true;
  }
   
  function initDisplay(){
	  var formObj = document.form;
	  var cntrstr = formObj.cntr_no.value;
	  var chkdgtstr = formObj.chk_dgt.value;
      formObj.reset();
      formObj.cntr_no.value = cntrstr;
      formObj.chk_dgt.value = chkdgtstr;
      if (timer) window.clearInterval(timer);      
  } 
  
  function Call(numb){ 
	  var formObj = document.form;
	  if (numb){ // 마우스 누른 효과를 발생시킨다
		  //document.getElementById("off_hire_avail").style = "color:red;background-color:D3DBFF;font-weight:bold;width:250;text-decoration:blink;"		  
           formObj.off_hire_avail.value = formObj.hid_off_hire_avail.value;
	  }
	  else {
		  //document.getElementById("off_hire_avail").style = "color:blue;background-color:D3DBFF;font-weight:bold;width:250;text-decoration:blink;"
		  formObj.off_hire_avail.value = "";
	  }
	  
  } // 텍스트 변화시키는 기능함수 종료

  function clock(){ // 타이머 기능함수 시작
	  now = new Date(); // 현재 시각을 얻어 now에 할당한다
      second = now.getSeconds(); // now에서 초를 얻어 second에 할당하고 출력한다	  
	  Call(second%2); // 초를 2로 나눈 나머지를 인수로 기능함수를 호출한다. 0은 짝수, 1은 홀수
  } // 타이머 기능함수 종료  

/* 개발자 작업  끝 */