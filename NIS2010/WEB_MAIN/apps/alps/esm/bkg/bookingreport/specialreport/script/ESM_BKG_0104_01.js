/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0104_01.js
*@FileTitle : Report Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* 2013.03.11 김진주 [CHM-201322943] [Invalid VVD 추가] - Booking status report
* 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
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
     * @extends 
     * @class esm_bkg_0104_01  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0104_01() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;    	
    }
    
   	/* 개발자 작업	*/
/*
 * 입력한 조건 값을 폼에 초기 값으로 처리하기 위한 변수
 * */
var arrFormElementMap = {vvd_cd:'input',       trunk_flag:'check',     lane_cd:'input',			 dir_cd:'multi',				 pol_cd:'input', 
                         pol_yard_cd:'input',  pol_local:'check',      pol_ts:'check',			 pod_cd:'input',				 pod_yard_cd:'input', 
												 pod_local:'check',    pod_ts:'check',         por_cd:'input',			 del_cd:'input',				 r_term:'multi', 
												 d_term:'multi',       zone_cd:'select',       deli_mode:'multi',		 board_from_dt:'input',  board_to_dt:'input', 
												 bkg_from_dt:'input',  bkg_to_dt:'input',	   eta_from_dt:'input', 	 eta_to_dt:'input',      
												 bkg_kind:'multi',	   b_ofc_cd:'input',       b_ofc_cd_sub:'check', 
												 b_staff_id:'combo',   ca_flag:'check',        agent_cd:'input',		 agent_cd_all:'check',   eq_type:'multi', 
												 cmdt_cd:'input',      cmdt_nm:'input',        wgt_from:'input',		 wgt_to:'input',         so_no:'input', 
												 l_ofc_cd:'input',     l_ofc_cd_sub:'check',   l_team_cd:'input',			 l_rep_id:'combo',       c_ofc_cd:'input', 
												 c_ofc_cd_sub:'check', c_rep_id:'input',       ctr_rfa_cd:'radio',	 ctr_rfa_no:'input',     s_mode_ori:'multi', 
												 s_mode_dest:'multi',  s_route_ori:'multi',    s_route_dest:'multi', fv_pre_pst_cd:'radio',  fv_vvd_cd:'input', 
												 fv_pol_cd:'input',    fv_pol_yard_cd:'input', fv_pol_local:'check', fv_pod_cd:'input',      fv_pod_yard_cd:'input', 
												 fv_pod_local:'check', cust_tp_cd_s:'check',   cust_tp_cd_c:'check', cust_tp_cd_n:'check',   cust_tp_cd_f:'check', 
												 cust_tp_cd_a:'check', cust_tp_cd_g:'check',   cust_cnt_cd:'input',  cust_seq:'input',       cust_nm:'input', 
												 cust_tp_cd:'multi',   sp_cargo_dg:'check',    sp_cargo_rf:'check',  sp_cargo_ak:'check',    sp_cargo_bb:'check', 
												 sp_cargo_hg:'check',  sp_cargo_soc:'check',   sp_cargo_eq:'check',  sp_cargo_rd:'check',     
												 sp_cargo_pc:'check',  sp_cargo_fg:'check',    sp_cargo_hd:'check',  sp_cargo_rb:'check',    cargo_tp_f:'check', 
												 cargo_tp_p:'check',   cargo_tp_r:'check',     bkg_sts_cd_f:'check', bkg_sts_cd_x:'check',   bkg_sts_cd_a:'check', 
												 bkg_sts_cd_w:'check', non_sp_cargo:'check',   holding:'check',      bl_type_a:'check',      bl_type_s:'check', 
												 rev:'check',          non_rev:'check',        aes_y:'check',        aes_n:'check',          stop_cargo:'check', 
												 ro_y:'multi',                                 caed_y:'check',       caed_n:'check',         crn_no_flag:'check', 
												 certi_y:'check',      certi_n:'check',        certi_d:'check',      certi_a:'check',        certi_b:'check',
												 certi_g:'check',      certi_c:'check',		   rate_check:'check',	 bkg_sts_cd_i:'check'
                        }
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var prefix = "";//IBSheet 구분자
 
 /*********************** EDTITABLE MULIT COMBO START ********************/
 var comboCnt = 0;
 var comboObjects = new Array();
 var b_staff_idMultiComboDataAdded = false;
 var l_rep_idMultiComboDataAdded = false;
 var l_team_cdMultiComboDataAdded = false;
   /*********************** EDTITABLE MULIT COMBO END ********************/
 	
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
      /**
      * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
      * ComComboObject생성자 메소드에서 호출됨 
	 	 	* param : comboObj ==> 콤보오브젝트
	 	 	* 
      */
     function setComboObject(combo_obj){
 			comboObjects[comboCnt++] = combo_obj;
 		}	
 		 	
     /**
      * Sheet 기본 설정 및 초기화
      * body 태그의 onLoad 이벤트핸들러 구현
      * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }
		    
		      //MultiCombo초기화 
	 	    for(var k=0;k<comboObjects.length;k++){
	 	        initCombo(comboObjects[k],comboObjects[k].id);
	 	    }
	 	    	
	 	    //setItemOptionHidden();//Item Option Hidden 처리
		    initControl();
		    
		     if (document.form.edit_yn.value == "N"){
            	ComBtnDisable("btn_OK");
            	ComBtnDisable("btn_New");
		     }
		     
		     
		     doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
				 setFeederVessel(); // Trunk에 따라 Feeder Vessel 초기화
				 setCRNNo();// POD T/S에 따라 CRN No. 초기화
		 		
     }


	/**
	 	 * Combo 기본 설정 
	 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 	 */ 
	 	function initCombo(comboObj, comboId) {
	 	    var formObject = document.form
 				initComboEditable(comboObj, comboId)
	 	}
	 	
 	 //콤보 멀티 셀렉트 및 수정 여부 초기 설정
 	 function initComboEditable(combo, comboId){
	 	 	with (combo) {
	 	 		if(comboId == "b_staff_id" || comboId == "report_type" || comboId == "ro_y" ){
	 	 			
		 	 		MultiSelect = false;
		 	 		UseAutoComplete = true; 
			 	  UseEdit = false;	 
			 	  	 			
	 	 		} else if(comboId == "l_rep_id" || comboId == "l_team_cd"){
	 	 	 		MultiSelect = false;
	 		 	  	UseEdit = true;
	 	 	 	}	 	 		else{
		 	 		MultiSelect = true;
			 	  UseEdit = false;	 	 			
	 	 			
	 	 		}
	 	 	}
 	 }

    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('blur', 'bkg_blur',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
    }
    
/*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	 
				case "custname":
	        //영문,숫자,공백,기타문자(.,등)
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	      break;	            	        
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_blur() {
    	var srcObj = window.event.srcElement;
     	var srcName = srcObj.getAttribute("name");
     	var srcValue = srcObj.getAttribute("value");
    	
    	var formObj = document.form;    	
	    switch (srcName) {
	    	case "b_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
					break;	    		
	    	case "l_ofc_cd":
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
	     		break;	    		
	    	case "board_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "board_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "bkg_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "eta_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "eta_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "board_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "board_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "bkg_from_dt":
	    		ComClearSeparator(event.srcElement);
					break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(event.srcElement);
					break;
			default:
					break;
		}
	}  
/**
	 	 * Trunk에 따라 Feeder Vessel 초기화 
	 	 * param : 
	 	 * Trunk에 따라 Feeder Vessel 초기화 
	 	 */ 
function setFeederVessel(){
	if(form.trunk_flag.checked){
		form.fv_vvd_cd.disabled        = false;
		form.fv_pre_pst_cd[0].disabled = false;
		form.fv_vvd_cd.disabled        = false;
		form.fv_pre_pst_cd[0].disabled = false;
		form.fv_pre_pst_cd[1].disabled = false;
		form.fv_vvd_cd.disabled        = false;
		form.fv_pol_cd.disabled        = false;
		form.fv_pol_yard_cd.disabled   = false;
		form.fv_pol_local.disabled     = false;
		form.fv_pod_cd.disabled        = false;
		form.fv_pod_yard_cd.disabled   = false;
		form.fv_pod_local.disabled     = false;
		form.fv_vvd_cd.style.background = "#FFFFFF";
		form.fv_pol_cd.style.background = "#FFFFFF";
		form.fv_pol_yard_cd.style.background = "#FFFFFF";
		form.fv_pod_cd.style.background      = "#FFFFFF";
		form.fv_pod_yard_cd.style.background = "#FFFFFF";		
	}else{
		form.fv_vvd_cd.value = "";
		form.fv_pre_pst_cd[0].checked = false;
		form.fv_pre_pst_cd[1].checked = false;
		form.fv_vvd_cd.value          = "";
		form.fv_pol_cd.value          = "";
		form.fv_pol_yard_cd.value     = "";
		form.fv_pol_local.checked     = false;
		form.fv_pod_cd.value          = "";
		form.fv_pod_yard_cd.value     = "";
		form.fv_pod_local.checked     = false;
		
		form.fv_vvd_cd.disabled        = true;
		form.fv_vvd_cd.disabled        = true;
		form.fv_pre_pst_cd[0].disabled = true;
		form.fv_pre_pst_cd[0].disabled = true;
		form.fv_pre_pst_cd[1].disabled = true;
		form.fv_vvd_cd.disabled        = true;
		form.fv_pol_cd.disabled        = true;
		form.fv_pol_yard_cd.disabled   = true;
		form.fv_pol_local.disabled     = true;
		form.fv_pod_cd.disabled        = true;
		form.fv_pod_yard_cd.disabled   = true;
		form.fv_pod_local.disabled     = true;
		
		form.fv_vvd_cd.style.background = "#E8E7EC";
		form.fv_pol_cd.style.background = "#E8E7EC";
		form.fv_pol_yard_cd.style.background = "#E8E7EC";
		form.fv_pod_cd.style.background      = "#E8E7EC";
		form.fv_pod_yard_cd.style.background = "#E8E7EC";
		
	}
}	

/*********************** KEY EVENT END ********************/
  
	/**
	 	 * POD T/S에 따라 CRN No.체크버튼 초기화 
	 	 * param : 
	 	 */ 
function setCRNNo(){
	if(form.pod_ts.checked){
		form.crn_no_flag.disabled        = false;
		form.crn_no_flag.style.background = "#FFFFFF";
	}else{
		form.crn_no_flag.checked     = false;
		form.crn_no_flag.disabled    = true;
		
		form.crn_no_flag.style.background = "#E8E7EC";
		
	}
}

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;
		var tempSqlCon = "";
		var nullMultiComboStr = "<SHEET> <DATA COLORDER='val' COLSEPARATOR='☜☞' TOTAL='1'> <TR><![CDATA[]]></TR> </DATA> </SHEET> ";
		var roYComboStr = "<SHEET> <DATA COLORDER='val|desc' COLSEPARATOR=',' TOTAL='6'> 	<TR><![CDATA[,]]></TR> 	<TR><![CDATA[1,Over 1 time]]></TR> 	<TR><![CDATA[2,Over 2 times]]></TR> 	<TR><![CDATA[3,Over 3 times]]></TR> 	<TR><![CDATA[4,Over 4 times]]></TR> 	<TR><![CDATA[5,Over 5 times]]></TR> </DATA> </SHEET> ";
 	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject1 = sheetObjects[0];
					
					var comboObject1 = comboObjects[0]; 
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 					
		 				case "btn_Save":
		 					doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					break;
		 							 					
		 				case "btn_OK":
		 					opener.setSearchOption(getValidCondition(FormQueryString(formObject)));
		 					/* 2010.01.21 0104 의 Save 버튼을 눌러준다 */
		 					opener.setSearchSaveOption();
		 					self.close();
		 					break;
		 				case "btn_Set":
		 					setCondition(tempSqlCon);
		 					break;
		 				case "btn_New":
		 					initAll(formObject);
		 					//sheetObject1.RemoveAll();  
		 					break;
		 				case "btn_Close":
		 					self.close();
		 					break;
		 				case "btn_commodity_pop": 		
							comBkgCallPop0653("setCallBack0653",formObject.cmdt_cd.value,'','Commo Pop');
							break;		 								
		 				case "btn_ctr_fra_pop": 		
							var param= "?cust_cd="+formObject.cust_cnt_cd.value+eval(formObject.cust_seq.value);
	 						ComOpenPopup('/hanjin/COM_ENS_021.do'+param, 780, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"fra_pop");
							break;		 								
		 				case "btn_customer_pop":
		 					var param= "" ;
		 					param = "?cust_cd="+formObject.cust_cnt_cd.value;
		 					if(formObject.cust_seq.value != ""){
		 						param += eval(formObject.cust_seq.value);
		 					}
		 					param += "&cust_nm="+formObject.cust_nm.value;	
	 						ComOpenPopup('/hanjin/COM_ENS_041.do'+param, 770, 430, 'setCustomer', '1,0,1,1,1,1,1,1,1,1', false,false, 0, 0, 0,"customer_pop");
							break;		
						case "btn_board_date":
		 					var cal = new ComCalendarFromTo();
							cal.select(formObject.board_from_dt, formObject.board_to_dt,'yyyy-MM-dd');
						 	break;
						case "btn_bkg_date":
							var cal = new ComCalendarFromTo();
							cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
							break;
							
						case "btn_eta_date":
							var cal = new ComCalendarFromTo();
							cal.select(formObject.eta_from_dt, formObject.eta_to_dt,'yyyy-MM-dd');
							break; 		
						case "cust_tp_cd_g":
							if(form.cust_tp_cd_g.checked){
								form.cust_tp_cd_s.checked = false;
								form.cust_tp_cd_c.checked = false;
								form.cust_tp_cd_n.checked = false;
								form.cust_tp_cd_f.checked = false;
								form.cust_tp_cd_a.checked = false;
							}
							break;
						case "trunk_flag":
							setFeederVessel();
							break; 	
						case "cust_tp_cd_s":
							form.cust_tp_cd_g.checked =false;
							break; 								
						case "cust_tp_cd_c":
							form.cust_tp_cd_g.checked =false;
							break; 								
						case "cust_tp_cd_n":
							form.cust_tp_cd_g.checked =false;
							break; 								
						case "cust_tp_cd_f":
							form.cust_tp_cd_g.checked =false;
							break; 								
						case "cust_tp_cd_a":
							form.cust_tp_cd_g.checked =false;
							break;
							
						case "pol_local":
							if(form.pol_local.checked){
								form.pol_ts.checked = false;
							}
							break; 		
						case "pol_ts":
							if(form.pol_ts.checked){
								form.pol_local.checked = false;
							}
							break; 										
						case "pod_local":
							if(form.pod_local.checked){
								form.pod_ts.checked = false;
							}
							break; 		
						case "pod_ts":
							if(form.pod_ts.checked){
								form.pod_local.checked = false;
							}
							setCRNNo();
							break; 										
						case "rev":
							if(form.rev.checked){
								form.non_rev.checked = false;
							}
							break; 		
						case "non_rev":
							if(form.non_rev.checked){
								form.rev.checked = false;
							}
							break; 		
						case "aes_y":
							if(form.aes_y.checked){
								form.aes_n.checked = false;
							}
							break; 		
						case "aes_n":
							if(form.aes_n.checked){
								form.aes_y.checked = false;
							}
							break; 		
//		        		case "ro_y":
//							if(form.ro_y.checked){
//								form.ro_n.checked = false;
//							}
//							break; 		
//		        		case "ro_n":
//							if(form.ro_n.checked){
//								form.ro_y.checked = false;
//							}
//							break; 		
						case "caed_y":
							if(form.caed_y.checked){
								form.caed_n.checked = false;
							}
							break; 		
						case "caed_n":
							if(form.caed_n.checked){
								form.caed_y.checked = false;
							}
							break; 		
						case "certi_y":
							if(form.certi_y.checked){
								form.certi_n.checked = false;
							}
							break; 		
						case "certi_n":
							if(form.certi_n.checked){
								form.certi_y.checked = false;
							}
							break; 		
						case "bl_type_a":
							if(form.bl_type_a.checked){
								form.bl_type_s.checked = false;
							}
							break; 		
						case "bl_type_s":
							if(form.bl_type_s.checked){
								form.bl_type_a.checked = false;
							}
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



   // Sheet관련 프로세스 처리
     var arrMultiCombo;//멀티콤보 세팅할 변수
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo,subGubun) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case SEARCH01:      //조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH01;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj));
							arrMultiCombo = sXml.split("|$$|");	
							initAll(formObj);
							initReportType();
						  setCondition(tempform.report_type.Code);
						  //debugdiv.innerHTML=ComReplaceStr(arrXml[1], "<", "&lt") ;
						  //var p_skd_dir_cd ="<SHEET> <DATA COLORDER='val|ibflag|desc|name|comboCd|pagerows|'	COLSEPARATOR='~~' TOTAL='3'> <TR> 	<![CDATA[A~~~~ALL~~ ~~CD00714~~]]> </TR> <TR> 	<![CDATA[E~~~~EAST~~EAST~~CD00714~~]]> </TR> <TR> 	<![CDATA[W~~~~WEST~~WEST~~CD00714~~]]> </TR> </DATA> </SHEET>"
						  //var arrData = ComXml2ComboItem(p_skd_dir_cd , formObj.skd_dir_cd, "val", "name");
						  
							break;
			 			case SEARCH02:      //Staff List 조회
							//if(!validateForm(sheetObj,formObj,sAction)) return;
							formObj.f_cmd.value = SEARCH02;
							var p_ofc_cd ="";
							var p_ofc_gubun ="";
							if(subGubun =="b_ofc_cd"){
								p_ofc_cd =formObj.b_ofc_cd.value;
								p_ofc_gubun ="BO";
							}else if(subGubun =="l_ofc_cd"){
								p_ofc_cd =formObj.l_ofc_cd.value;
								p_ofc_gubun ="LO";
							}
							var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd+"&p_ofc_gubun="+p_ofc_gubun);
						
							if(subGubun =="b_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.b_staff_id, "usr_id", "usr_id");
							}else if(subGubun =="l_ofc_cd"){
							  ComXml2ComboItem(sXml, formObj.l_rep_id, "srep_cd", "srep_cd");
							}
							break;
							
			 			case SEARCH06:      //Sales Team 조회
			 				formObj.f_cmd.value = SEARCH06;
			 				var p_ofc_cd = formObj.l_ofc_cd.value;			
			 				if(p_ofc_cd != 'SELSC') p_ofc_cd = '';
			 				
			 				var sXml = sheetObj.GetSearchXml("ESM_BKG_0104GS.do", FormQueryString(formObj)+"&p_ofc_cd="+p_ofc_cd);
			 			
			 				l_team_cdMultiComboDataAdded = false;
			 				ComXml2ComboItem(sXml, formObj.l_team_cd, "ofc_team_cd", "ofc_team_cd");
			 				
			 				if(p_ofc_cd == 'SELSC'){
			 					formObj.l_team_cd.Enable = true;
			 				}else{
			 					formObj.l_team_cd.Enable = false;
			 				}
			 				break;

 						case IBSEARCHAPPEND:  // 페이징 조회
						case IBINSERT:      // 입력					
							sheetObj.DataInsert(-1);
							break;
					
			
			    }
     }
     

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
     	return true;
    	switch(sAction) {
    		case IBSEARCH:
	    		if (ComIsNull(formObj.p_pod_cd)) {
	     					ComShowCodeMessage('BKG00626','POD Code');
	     					return false;
			  	}
			  	
	    		if (formObj.p_pod_cd.value.length !=5) {
	     					ComShowCodeMessage('BKG95018','POD Code','5');
	     					return false;
			  	}
			  		
	  			break;
    		case IBSAVE:
	  			break;
    	 }
         return true;
     }
     
	 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
   function initSheet(sheetObj,sheetNo) {}
	
/*############################# combo onchage start ########################*/
/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
	 * 입력값을 upper로 변경하여 재등록 한다.
	 * @param comboObj
	 * @return
	 */
	function report_type_OnChange(comboObj) {
		initAll(document.form);
		setCondition(comboObj.Code);
		setFeederVessel(); 
	}
	 
	function b_staff_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function l_rep_id_OnChange(comboObj) {
		//combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }

	function combo_Change(comboObj, multiComboDataAddedFlag) {
		var formObject = document.form;  

		// 사용자 입력값을 uppercase로 변경  
   	 	var comboText =  comboObj.Text.toUpperCase();
   	 	 
   	 	// 이전에 등록되었으면 삭제 
   	 	if (multiComboDataAddedFlag) { 
	 			comboObj.DeleteItem(0); 
	 			multiComboDataAddedFlag = false; 
   	 	} 
   	 	
   	 	// 선택 또는 입력한  값이 콤보에 있으면 리턴
   	 	if (comboObj.FindIndex(comboText, 0) != -1) { 
   	 		return; 
   	 	} 

   	 	comboObj.InsertItem(0, comboText, comboText); 
	 		multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수) 
	 		comboObj.Text2 = comboText;  // 입력값이 선택되게 한다. 

	 }	 
	 
/*############################# combo onchage end ########################*/		

	 /*
	  * 파라메터로 넘겨받은 Report Template의 이름
	  * 초기 Report Type을 세팅함.
	  */
	var paramReportName="";
	
	/*
	 * 모든 조건 값들을 초기화 한다.
	 * */
	function initAll(formObject){
		form.reset();
		ComXml2ComboItem(roYComboStr, formObject.ro_y, "val", "desc");
		ComXml2ComboItem(nullMultiComboStr, formObject.b_staff_id, "val", "val");
		ComXml2ComboItem(nullMultiComboStr, formObject.l_rep_id, "val", "val");
		ComXml2ComboItem(arrMultiCombo[0], formObject.dir_cd, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[1], formObject.r_term, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[2], formObject.d_term, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[3], formObject.deli_mode, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[4], formObject.bkg_kind, "desc", "desc");
	  ComXml2ComboItem(arrMultiCombo[5], formObject.eq_type, "cntr_tpsz_cd", "cntr_tpsz_cd");
	  ComXml2ComboItem(arrMultiCombo[6], formObject.s_mode_ori, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[6], formObject.s_mode_dest, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[7], formObject.s_route_ori, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[7], formObject.s_route_dest, "val", "val");
	  ComXml2ComboItem(arrMultiCombo[8], formObject.cust_tp_cd, "val", "val");	  
	}
	
	function initReportType(){
		ComXml2ComboItem(arrMultiCombo[9], tempform.report_type, "bzc_cond_sql_ctnt", "rpt_nm");
	  var arr = ComBkgXml2Array(arrMultiCombo[9], "rpt_nm");
	  var chkRptTypeFlg = false;
	  for(var index=0; index<arr.length; index++) {
	  	if(arr[index] == paramReportName){
	  		chkRptTypeFlg  = true;
	  		tempform.report_type.Index = index;
	  	}
	  }
	  if(!chkRptTypeFlg){
	  	tempform.report_type.Text2 = arr[0];
	  }
	}

    /**
     * condition setting
     */ 
  function setCondition(sqlCtnt){
  	
  	var arrSqlCtnt = sqlCtnt.URLDecode().split("|");
   	var formNameValue ; 
  	var field;
  	try{
	   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
	   			formNameValue = arrSqlCtnt[i].split("=");
	   			if(formNameValue[1] =="") continue;
	   			if(arrFormElementMap[formNameValue[0]] == "check"){
						eval("form."+formNameValue[0]).checked = true;
						
					}else if(arrFormElementMap[formNameValue[0]] == "radio"){
						field = eval("form."+formNameValue[0]);
							for(var j = 0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].checked = true;
									break;
								}
									
							}
							
					}else if(arrFormElementMap[formNameValue[0]] == "select"){
						field = eval("form."+formNameValue[0]);
							for(var j = 0; j < field.length; j++) {
								if(field[j].value == formNameValue[1]){
									field[j].selected = true;
									break;
								}
							}
							
					}else if(arrFormElementMap[formNameValue[0]] == "combo"){
						eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
					}else if(arrFormElementMap[formNameValue[0]] == "multi"){
						eval("form."+formNameValue[0]).Code=formNameValue[1].URLDecode();
					}else{
						field = eval("form."+formNameValue[0]);
						field.value=formNameValue[1];
						if(field.name == "b_ofc_cd")
							doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','b_ofc_cd');
						else if(field.name == "l_ofc_cd")
							doActionIBSheet(sheetObjects[0],document.form,SEARCH02,'','','','l_ofc_cd');  	

		     		    doActionIBSheet(sheetObjects[0],document.form,SEARCH06);
	   			}
	   	}//end for
	   	
  	}catch(e){}
  }
    
		/*
		 * Customer 조회 결과를 세팅하는 콜백 메소드
		 * */
		function setCustomer(val){
				var c_cd = val[0][3];
				var c_name = val[0][4];
				form.cust_cnt_cd.value=c_cd.substring(0,2);
				form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
				form.cust_nm.value=c_name;
		} 
	
		 /**
		 * Commodity Code를 입력하기 위해 Code를 검색  .<br>
		 * @param {arry} aryPopupData
		 */
		function setCallBack0653(aryPopupData) {
			var formObject = document.form;
			formObject.cmdt_cd.value = aryPopupData[0][3];
			//formObject.rep_cmdt_cd.value = aryPopupData[0][5];
			formObject.cmdt_nm.value = aryPopupData[0][4];
		}
		

	/**
  * 조건 중 값이 없는 것은 제거한다. 
  */ 
  function getValidCondition(sql){
  	
  	var arrSqlCtnt = sql.URLDecode().split("&");
   	var formNameValue ;
   	var returnSql = ""; 
   	for (var i = 0 ; i < arrSqlCtnt.length ; i++){
   			formNameValue = arrSqlCtnt[i].split("=");
   			if(formNameValue[1] == undefined || formNameValue[1] == "") continue;
   			
   			returnSql += formNameValue[0]+"="+formNameValue[1].URLEncode()+"|";
   			
   	}//end for
   	
   	return returnSql;
  }
   
  /* version up 2010.1.22 */
	/* 개발자 작업  끝 */    
										
		