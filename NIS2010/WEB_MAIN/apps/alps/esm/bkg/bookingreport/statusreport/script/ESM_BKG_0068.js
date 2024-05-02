/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0068.js
*@FileTitle : B/L(Manifest) Clearance Cross-Check List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
* 1.0 Creation
* 2011.05.31 변종건 [CHM-201111165-01] BL Data Input Cross-check기능추가보완-Sailing Date 및 Multi-VVD Base검색조건 추가
* 2011.09.02 변종건 [CHM-201111165-01] [BKG] BL Data Input Cross-check 기능 추가 보완-Sailing Date 및  Multi-VVD Base 검색 조건 추가
* 2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
* 2012.04.09 채창호 [CHM-201217004-01]:컨테이너별 중량 표기 보완 요청
* 2013.04.16 김진주 [CHM-201324119] [BKG] 통합로그 Error 복구
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
     * @class esm_bkg_0068  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0068() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	this.setComboObject 		= setComboObject;
    }
    
   	/* 개발자 작업	*/
     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 // 공통전역변수
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var rowsPerPage = 999999;
 
 var prefix = "sheet1_";//IBSheet 구분자
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	var p_no_goodMultiComboDataAdded = false;
	var p_eq_typeMultiComboDataAdded = false;
	var p_rcv_term_cdMultiComboDataAdded = false;
	var p_de_term_cdMultiComboDataAdded = false;
	var p_bkg_sts_cdMultiComboDataAdded = false;
	var p_cnmv_sts_cdMultiComboDataAdded = false;
	var p_bkg_cust_tp_cdMultiComboDataAdded = false;
	var p_del_contiMultiComboDataAdded = false;
     
	//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	//ComComboObject생성자 메소드에서 호출됨
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	
/**
 * RD 프린트 시 표시할 검색 조건 생성에 사용
 */
var searchOptionsMap = { p_vvd:'comboObjects[0].Code', 
												 pol:"eval(\"form.p_pol_cd.value != '' ? form.p_pol_cd.value:''\")"+
			          						"+eval(\"form.p_pol_yd_cd.value != '' ? ' Yard:'+form.p_pol_yd_cd.value :''\")"+
			          						"+eval(\"form.p_pol_lt.options[form.p_pol_lt.selectedIndex].text != '' ? ' L/T:'+form.p_pol_lt.options[form.p_pol_lt.selectedIndex].text:''\")",											 
                         p_por_cd:'form.p_por_cd.value',
                         
												 p_apod_cd:"eval(\"form.p_apod_cd.value != '' ? form.p_apod_cd.value:''\")"+
			          						"+eval(\"form.p_apod_lt.options[form.p_apod_lt.selectedIndex].text != '' ? ' L/T:'+form.p_apod_lt.options[form.p_apod_lt.selectedIndex].text:''\")",
			          						                          
                         p_del_cd:'form.p_del_cd.value',
                         p_eq_type:"form.p_eq_type.Text" , 
                         
                        // p_rcv_term_cd:"form.p_rcv_term_cd.Text" , 
                        // p_de_term_cd:"form.p_de_term_cd.Text" ,
                         
                         rd:"eval(\"form.p_rcv_term_cd.Text != '' ? form.p_rcv_term_cd.Text+(form.p_de_term_cd.Text != '' ? '/':''):''\")"+
			          					        "+eval(\"form.p_de_term_cd.Text != '' ? form.p_de_term_cd.Text:''\")",
			          				
                          
                         p_bkg_ofc_cd:"form.p_bkg_ofc_cd.value",
                         p_doc_usr_id:"form.p_doc_usr_id.value",
                         p_ob_sls_ofc_cd:"form.p_ob_sls_ofc_cd.value",
                         p_ob_srep_cd:"form.p_ob_srep_cd.value",
                         p_ctrt_ofc_cd:"form.p_ctrt_ofc_cd.value",
                         p_ctrt_srep_cd:"form.p_ctrt_srep_cd.value",
                         p_bkg_sts_cd:"form.p_bkg_sts_cd.Text" ,
                         p_cnmv_sts_cd:"form.p_cnmv_sts_cd.Text" ,
                         p_zone_cd:"form.p_zone_cd.options[form.p_zone_cd.selectedIndex].text" ,
                          
//                         p_dcgo_flg:"form.p_dcgo_flg.checked ? 'Danger':''" , 
//                         p_rc_flg:"form.p_rc_flg.checked ? 'Reefer':''" , 
//                         p_awk_cgo_flg:"form.p_awk_cgo_flg.checked ? 'Awkward':''" , 
//                         p_bb_cgo_flg:"form.p_bb_cgo_flg.checked ? 'Break Bulk':''" ,
                         special_cargo:"eval(\"form.p_dcgo_flg.checked ? 'Danger'+(form.p_rc_flg.checked || form.p_awk_cgo_flg.checked || form.p_bb_cgo_flg.checked ? '/':''):''\")"+
														           "+eval(\"form.p_rc_flg.checked ? 'Reefer'+(form.p_awk_cgo_flg.checked || form.p_bb_cgo_flg.checked ? '/':''):''\")"+
																			 "+eval(\"form.p_awk_cgo_flg.checked ? 'Awkward'+(form.p_bb_cgo_flg.checked ? '/':''):''\")"+
																			 "+eval(\"form.p_bb_cgo_flg.checked ? 'Break Bulk':''\")",
                          
                         p_bdr_flg:"form.p_bdr_flg.options[form.p_bdr_flg.selectedIndex].text" ,
                         p_si_flg:"form.p_si_flg.options[form.p_si_flg.selectedIndex].text" ,
                         p_obl_iss_ofc_cd:"form.p_obl_iss_ofc_cd.value",
//                         p_bkg_cust_tp_cd:"form.p_bkg_cust_tp_cd.Text" ,
//                         p_cust_cnt_cd:"form.p_cust_cnt_cd.value",
//                         p_cust_seq:"form.p_cust_seq.value",
//                         p_cust_nm:"form.p_cust_nm.value",
//                         
                          customer:"eval(\"form.p_bkg_cust_tp_cd.Text != '' ? form.p_bkg_cust_tp_cd.Text+(form.p_cust_cnt_cd.value != '' || form.p_cust_seq.value != '' || form.p_cust_nm.value != '' ? '/':''):''\")"+
														       "+eval(\"form.p_cust_cnt_cd.value != '' ? ' '+form.p_cust_cnt_cd.value +(form.p_cust_seq.value != '' || form.p_cust_nm.value != '' ? '/':''):''\")"+
														       "+eval(\"form.p_cust_seq.value != '' ? ' '+form.p_cust_seq.value +(form.p_cust_nm.value != '' ? '/':''):''\")"+
																	 "+eval(\"form.p_cust_nm.value != '' ? ' '+form.p_cust_nm.value :''\")",
                         
                         p_no_good:"ComReplaceStr(form.p_no_good.Text,'|',',')" 
                          
												}	
	
/**
 * RD 프린트 시 표시할 검색 조건 제목
 */
var searchOptionsTitleMap = { p_vvd:'VVD', 
												 pol:"POL",											 
                         p_por_cd:'POR',
                         
												 p_apod_cd:"A/POD",
			          						                          
                         p_del_cd:'DEL',
                         p_eq_type:"E/Q Type" , 
                         
                         
                         rd:"R/D",
			          				
                          
                         p_bkg_ofc_cd:"BKG Office",
                         p_doc_usr_id:"BKG STF",
                         p_ob_sls_ofc_cd:"L.OFC",
                         p_ob_srep_cd:"L.REP",
                         p_ctrt_ofc_cd:"C.OFC",
                         p_ctrt_srep_cd:"C.REP",
                         p_bkg_sts_cd:"BKG Status" ,
                         p_cnmv_sts_cd:"Cargo Type" ,
                         p_zone_cd:"Zone" ,
                          
                         special_cargo:"Special Cargo",
                          
                         p_bdr_flg:"BDR Status" ,
                         p_si_flg:"S/I Received" ,
                         p_obl_iss_ofc_cd:"B/L Office",
                         
                         customer:"Customer",
                         
                         p_no_good:"No Good" 
                          
												}		
	
/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj, comboId) {
 	    var formObject = document.form
 	    if( comboId == "p_no_good" ){
 	    	comboObj.DropHeight = 200; 
        	initCombo_p_no_good();
 	    }else if( comboId == "p_vvd" ){
 	    	comboObj.MultiSelect = true;
 	    	comboObj.UseEdit = false;
 	    	comboObj.BackColor = "#CCFFFD";
 	    }else if( comboId == "blck_stwg_cd"){
 	    	comboObj.MultiSelect = true;
 	    	comboObj.UseEdit = false;
 	    	comboObj.SetColWidth("50|250");
 	    	comboObj.SetColAlign("left|left");
 	    }else{
 			initComboEditable(comboObj)
 	    } 
 	}
 	 
 	function initComboEditable(combo){
 	 	with (combo) {
 	 		MultiSelect = false;
 	 		UseEdit = true;
 	 	}
 	}
 	
    function initCombo_p_no_good() {
    	with (form.p_no_good) {
    		MultiSelect = true; 
    		MultiSeparator="|";
    		//ColCnt = 2;
				var i=0; 
				InsertItem(i++, " ", ""); 
				InsertItem(i++, "Un-Rated B/L", "BL"); 
				InsertItem(i++, "Un-Confirm CNTR", "CFC"); 
				InsertItem(i++, "Non-CM CNTR", "CMC"); 
				InsertItem(i++, "Non-M&D B/L", "MD"); 
				InsertItem(i++, "Non-VL CNTR", "VLC"); 
				InsertItem(i++, "Non-Issued B/L", "IS"); 
				InsertItem(i++, "Non-SR Received B/L", "RC"); 
				 
			} 
    }
  


	
/*############################# combo onchage start ########################*/
/**
	 * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
	 * 입력값을 upper로 변경하여 재등록 한다.
	 * @param comboObj
	 * @return
	 */
	function p_eq_type_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function p_rcv_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function p_de_term_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function p_bkg_sts_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function p_cnmv_sts_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
		
	 }
	function p_bkg_cust_tp_cd_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
	 }
	function p_del_conti_OnChange(comboObj) {
		combo_Change(comboObj, eval(comboObj.id+"MultiComboDataAdded"));
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
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
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
 	    
	 	 doActionIBSheet(sheetObjects[1], document.form, SEARCH03);
 	   
	     initControl();
	     //멀티콤보를 위해 곧 바로 조회하면 IBSheet 제대로 그려지지 않아 화면이 깨지는데 이것을 방지 하기 위해 딜레이를 0.1 초를 준다
	     setTimeout(function () { doActionIBSheet(sheetObjects[0],document.form,SEARCH01); },100);
	    
	     form.vvd_sig.focus();
	    
	     dpcsFlagCheck();
     }
	
   	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerForm("Click","obj_Click", document.form);
    	axon_event.addListenerForm('change', 'form1_change', formObject);
    }        
    
    
	/**
	 * Display DPCS 별로 SHEET를 가변적으로 변환한다.
	 * @param 
	 * @param 
	 * @return
	 */
     function dpcsFlagCheck(){    	 
    	if(document.form.p_dpcs_flg.checked){
    		
    		sheetObjects[0].ColHidden(prefix + "dpcs_i") = false;    		
    		sheetObjects[0].ColHidden(prefix + "dpcs_r") = false;
    		sheetObjects[0].ColHidden(prefix + "dpcs_q") = false;
    		sheetObjects[0].ColHidden(prefix + "dpcs_f") = false;
    		sheetObjects[0].ColHidden(prefix + "dpcs_sts") = false;
    		
    		document.getElementById("dpcs").style.display = "block";
    		document.getElementById("empty_dpcs").style.display = "none";
    		
    	}else{
    		
    		sheetObjects[0].ColHidden(prefix + "dpcs_i") = true;
    		sheetObjects[0].ColHidden(prefix + "dpcs_r") = true;
    		sheetObjects[0].ColHidden(prefix + "dpcs_q") = true;
    		sheetObjects[0].ColHidden(prefix + "dpcs_f") = true;
    		sheetObjects[0].ColHidden(prefix + "dpcs_sts") = true;	
    		
    		document.getElementById("dpcs").style.display = "none";
    		document.getElementById("empty_dpcs").style.display = "block";
    	}
    }
    
		
		
 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
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
	      case "engnum"://숫자+"영문대소"입력하기
  	  	  	ComKeyOnlyAlphabet('num'); 
	      	break;	    
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	  /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "bdr_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "from_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "bdr_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  

/*********************** KEY EVENT END ********************/
  
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 		document.onclick = processButtonClick;

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
		 				case "btn_RowAdd":
		 					doActionIBSheet(sheetObject1,formObject,IBINSERT);
		 					break;
		 				case "btn_RowDelete":
		 					ComRowHideDelete(sheetObject1,"sheet1_del_chk");
		 					break;
		 				case "btn_Retrieve":
		 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		 					break;
		 				case "btn_New":
		 					location.reload(true);
		 					formObject.vvd_sig.focus();
		 					break;
		 				case "btn_DownExcel":
		 					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					break;
		 				
		 				case "btn_Print":
		 					doActionIBSheet(sheetObjects[0],formObject,RDPRINT);
		 					break;

						case "btn_Combine":
							var chkRowArr = ComFindAll(sheetObjects[0], prefix + "check2", "1");
							if (0 < chkRowArr.indexOf("|")) {
								if (!validateForm(sheetObjects[0],formObject,"btn_Combine")) {
									return false;
								}
								comBkgCallPop0974('callBack0974');
							} else {
								ComShowCodeMessage("BKG00155");
								return false;
							}
							break;
							
						case "find_tmplt_m":
							formObject.vvd_tmp.value = "";
							ComOpenWindowCenter("ESM_BKG_0365.do?tmplt_tp_cd=V&rtn=vvd_tmp", "MnD Template", 600, 390, true);
							if( formObject.vvd_tmp.value != "" ){
								setVvds(formObject.vvd_tmp.value);
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
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

 			case IBSEARCH:      //조회

 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				
 				//Multi VVD 
	            formObj.multi_vvd.value = comboObjects[0].Code;
	            
//			 			    alert("flag" + formObj.p_dpcs_flg.checked);
			
 			    // Display DPCS Flag에 따라 SHEET가 가변적으로 변환						    			 						    
	
 				formObj.f_cmd.value = SEARCH;
 				formObj.curr_page.value = 1;//PageNo를 초기화 하기 위함
 				pagedMaxCnt = sheetObj.HeaderRows;//색상 변경을 위한 변수 초기화
				form.rows_per_page.value = rowsPerPage;
				
				sheetObj.RemoveAll();
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;

				var sXml = sheetObj.GetSearchXml("ESM_BKG_0068GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.WaitImageVisible = false;	
				sheetObj.Redraw = true; 
				if(ComGetEtcData(sXml, "total_bkg") == undefined){
					break;
				}
				formObj.total_bkg.value				= ComGetEtcData(sXml, "total_bkg");
				formObj.total_bl.value				= ComGetEtcData(sXml, "total_bl");
				formObj.total_bkg_f.value			= ComGetEtcData(sXml, "total_bkg_f");
				formObj.total_bkg_t.value			= ComGetEtcData(sXml, "total_bkg_t");
				formObj.total_ctrl_f.value			= ComGetEtcData(sXml, "total_ctrl_f");
				formObj.total_ctrl_t.value			= ComGetEtcData(sXml, "total_ctrl_t");
				formObj.total_cfm.value				= ComGetEtcData(sXml, "total_cfm");
				formObj.total_vl.value				= ComGetEtcData(sXml, "total_vl");
				formObj.total_cm.value				= ComGetEtcData(sXml, "total_cm");
				formObj.total_md.value				= ComGetEtcData(sXml, "total_md");
				formObj.total_charge.value			= ComGetEtcData(sXml, "total_charge");
				formObj.total_apprval.value			= ComGetEtcData(sXml, "total_apprval");
				formObj.total_issue.value			= ComGetEtcData(sXml, "total_issue");
				formObj.total_receiving.value 		= ComGetEtcData(sXml, "total_receiving");
				
				formObj.dpcs_ttl.value 				= ComGetEtcData(sXml, "dpcs_ttl");
				formObj.dpcs_input.value 			= ComGetEtcData(sXml, "dpcs_input");
				formObj.dpcs_rate.value 			= ComGetEtcData(sXml, "dpcs_rate");
				formObj.dpcs_qa.value 				= ComGetEtcData(sXml, "dpcs_qa");
				formObj.dpcs_bl_proof.value 		= ComGetEtcData(sXml, "dpcs_bl_proof");
				formObj.status_complete.value 		= ComGetEtcData(sXml, "status_complete");
				formObj.status_pending.value 		= ComGetEtcData(sXml, "status_pending");
				formObj.status_open.value 			= ComGetEtcData(sXml, "status_open");
				formObj.total_vgm_cnt.value 	    = ComGetEtcData(sXml, "total_vgm_cnt");
				formObj.total_cntr_cnt.value 	    = ComGetEtcData(sXml, "total_cntr_cnt");
				formObj.total_no_vgm_cnt.value 	    = ComGetEtcData(sXml, "total_no_vgm_cnt");
				
				/*
				if(ComGetEtcData(sXml, "aes_yn")=='Y'){
					sheetObj.ColHidden(prefix + "aes") = false;
				}else{
					sheetObj.ColHidden(prefix + "aes") = true;
				}*/
				// E/L
				
				
				if(form.p_pol_cd.value.substring(0,2)=='KR' || form.p_pol_cd.value.substring(0,2)=='KR'){
					sheetObj.ColHidden(prefix + "el_no") = false;
				}else{
					sheetObj.ColHidden(prefix + "el_no") = true;
				}
				
				if(form.p_pol_cd.value.substring(0,2)=='US' || form.p_pol_cd.value.substring(0,2)=='US'){
					sheetObj.ColHidden(prefix + "aes") = false;
					sheetObj.ColHidden(prefix + "cust_tp") = false;
				}else{
					sheetObj.ColHidden(prefix + "aes") = true;
					sheetObj.ColHidden(prefix + "cust_tp") = true;
				}
				
				if(form.p_pol_cd.value.substring(0,2)=='BR' || form.p_pol_cd.value.substring(0,2)=='BR'){
					sheetObj.ColHidden(prefix + "dde") = false;
				}else{
					sheetObj.ColHidden(prefix + "dde") = true;
				}
				
				if(form.p_pol_cd.value.substring(0,2)=='ID' || form.p_pol_cd.value.substring(0,2)=='ID'){
					sheetObj.ColHidden(prefix + "peb") = false;
				}else{
					sheetObj.ColHidden(prefix + "peb") = true;
				}
				
				if(form.p_pol_cd.value.substring(0,2)=='MX' || form.p_por_cd.value.substring(0,2)=='MX'|| form.p_apod_cd.value.substring(0,2)=='MX'|| form.p_del_cd.value.substring(0,2)=='MX'||
						form.p_pol_cd.value.substring(0,2)=='CO' || form.p_por_cd.value.substring(0,2)=='CO'|| form.p_apod_cd.value.substring(0,2)=='CO'|| form.p_del_cd.value.substring(0,2)=='CO'||
						form.p_pol_cd.value.substring(0,2)=='EC' || form.p_por_cd.value.substring(0,2)=='EC'|| form.p_apod_cd.value.substring(0,2)=='EC'|| form.p_del_cd.value.substring(0,2)=='EC'||
						form.p_pol_cd.value.substring(0,2)=='PE' || form.p_por_cd.value.substring(0,2)=='PE'|| form.p_apod_cd.value.substring(0,2)=='PE'|| form.p_del_cd.value.substring(0,2)=='PE'
					){
					sheetObj.ColHidden(prefix + "tax_id") = false;
				}else{
					sheetObj.ColHidden(prefix + "tax_id") = true;
				}
				
				if(form.p_pol_cd.value.substring(0,2)=='CA' || form.p_pol_cd.value.substring(0,2)=='CA'){
					sheetObj.ColHidden(prefix + "caed") = false;
				}else{
					sheetObj.ColHidden(prefix + "caed") = true;
				}
 			/*	if ("sheet1" == sheetObj.id) sheetObj.DoSearch("ESM_BKG_0071GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));*/
				
				break;
 			case IBSEARCHAPPEND:  // 페이징 조회
				formObj.f_cmd.value = SEARCH;
                formObj.curr_page.value = PageNo;
                selectVal = FormQueryString(formObj);
                sheetObj.DoSearch4Post("ESM_BKG_0068GS.do", selectVal+ "&" + ComGetPrefixParam(prefix), "iPage=" + PageNo, true); 
                break;  
           	
 			case SEARCH01:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0068GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				/*EQ TYPE - CONTAINER TYPE SIZE*/
				/*R/D R- OUTBOUND RECEIVED*/
				/*R/D D- INBOUND DELIVERY*/
				/*BOOKING STATUS*/
				/*CARGO STATUS*/
				/*CUSTOMER TYPE*/
					
			  	ComXml2ComboItem(arrXml[0], formObj.p_eq_type, "cntr_tpsz_cd", "cntr_tpsz_cd");
			  	ComXml2ComboItem(arrXml[1], formObj.p_rcv_term_cd, "val", "val");
			  	ComXml2ComboItem(arrXml[2], formObj.p_de_term_cd, "val", "val");
			  	ComXml2ComboItem(arrXml[3], formObj.p_bkg_sts_cd, "val", "val");
			  	ComXml2ComboItem(arrXml[4], formObj.p_cnmv_sts_cd, "val", "name");
			  	ComXml2ComboItem(arrXml[5], formObj.p_bkg_cust_tp_cd, "val", "val");
			  	ComXml2ComboItem(arrXml[6], formObj.p_del_conti, "conti_cd", "conti_nm");
			  	ComBkgXml2ComboItem(arrXml[7], formObj.blck_stwg_cd, "val", "desc");
			  	formObj.p_cnmv_sts_cd.Index = 0;
			  	formObj.vvd_sig.focus();
				break;
			
			 		
			case IBINSERT:      // 입력
				sheetObj.DataInsert(-1);
				break;
							
			case IBDOWNEXCEL:   // 엑셀다운로드
				
				var columnSkipList = "";
				  
				if(form.p_dpcs_flg.checked){
				   	columnSkipList = "sheet1_ibflag";
				} else {
				    columnSkipList = "sheet1_ibflag|sheet1_dpcs_i|sheet1_dpcs_r|sheet1_dpcs_q|sheet1_dpcs_f|sheet1_dpcs_sts";
			    }
			
				sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, columnSkipList, "");

				break;
					
			case RDPRINT:   		
				if (sheetObj.RowCount < 1) {
					ComShowCodeMessage("BKG00495");
					return;
				}
		 		
		 		var options ="";
				var temp = "";
				for (var key in searchOptionsMap){ //선택된헤더 컬럼 외 나머지 컬럼 헤더 생성
					temp = eval(searchOptionsMap[key]);
					if(temp != "") {
						options += searchOptionsTitleMap[key]+"-"+temp + "  |  ";
					}
         		}
         		options = options.substring(0,options.length-5);
         			
				var url = "ESM_BKG_0772.do?"+FormQueryString(formObj);	    	
				var winName = "ESM_BKG_0772";
					
				repWin = openWinCenter("about:blank",winName,1010,600);
				    
				    
		 		formObj.f_cmd.value = SEARCH02;
				var frm2 = document.form2;
				frm2.rfn.value = "/ESM_BKG_0772_1.do?"+FormQueryString(formObj);	    
				frm2.mrd.value = "apps/alps/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0772.mrd";
					
				frm2.rv.value = "options["+options+"]";		    
				frm2.rd_title.value = "B/L Data Input Cross-Check";
				    
				frm2.action = url;
				frm2.target = winName;
				frm2.submit();
				//frm2.target = "";
				repWin.focus();
					
				break;					

			case "run_combine":        //Combine 처리 서버호출
				formObj.f_cmd.value = MODIFY01;
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, prefix + "check2"), "");

				var sXml = sheetObj.GetSaveXml("ESM_BKG_0614GS.do", params);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComShowCodeMessage("BKG00166");
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				
					if("Y" == ComGetEtcData(sXml, "pre_checking")){
						comBkgCallPop0200(formObj.mst_bkg_no.value, "N");
					}
				} else {
					sheetObjects[0].LoadSearchXml(sXml);     
				}
				break;
					
			case SEARCH03:      //word template 조회
				formObj.f_cmd.value = SEARCH01;
				sheetObj.DoSearch("ESM_BKG_0079_06GS.do", FormQueryString(formObj));
	
				/* combo object */
				var vCombo = formObj.vvd_word_template;

				/* remove old value */
				var len = vCombo.length;
				for(i=1;i<len;i++) {
					vCombo.remove(len-i);
				}

				/* set new value */
				var rcnt = sheetObj.RowCount;
				for(ir=1;ir<=rcnt;ir++){
					var tmplt_type = sheetObj.CellValue(ir, "tmplt_tp_cd");
					if(tmplt_type=='V'){
						vCombo.options[vCombo.length] = new Option(sheetObj.CellValue(ir, "tmplt_hdr_nm") , sheetObj.CellValue(ir, "tmplt_seq"));
					}
				}
					
				break;

         }
     }
     

    function openWinCenter(url,winName,width,height , scrollYn) {
 	   var left = (screen.width - width)/2;    
 	   if(left < 0) {
 		   left = 0;
 	   }
        var top  = (screen.height- width)/2;   
        if( top < 0 ) {
     	   top = 0;
        }
        
        if (ComIsNull(scrollYn)) {
     	   scrollYn = "no";
        } else {
     	   if (scrollYn == "Y") {
     		   scrollYn = "yes";
     	   } else {
     		   scrollYn = "no";
     	   }
        }
        var feature = 
     	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
        
        return window.open(url,winName,feature);
 		}     
     
     
	 /**
     * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 Event <br>
     */ 
	  function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
	     
	     doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true,true, PageNo);
	  }        


     /*
      *  페이징 처리 후 해당 조회 개수만큼 처리 하기위한 변수
      * 초기값은 쉬트 헤더 개수
      */ 
    var pagedMaxCnt=2; 

    /**
     * 조회후  이벤트 처리 >>> 폰트 칼라변경
     */ 
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var tempFlag;
		with (sheetObj) {
			
			var chk = 0;
			var bkgCnt = 0;
			var cntrCnt = 0;
			var redColor = RgbColor(255, 0, 0);
			var blueColor = RgbColor(0, 0, 255);
			//2011.11.22 변종건 [CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double Booking시-IRR조기 감지 Report시스템 구축
			for(var idx=2; idx<= sheetObj.LastRow; idx++){
				
				if(sheetObj.CellValue(idx, prefix + "cntr_check") == "D"){
					if(sheetObj.CellValue(idx, prefix + "cntr_no")!= ""){
						sheetObj.CellFont("FontBold", idx, prefix + "cntr_no", idx, prefix + "cntr_no") = true;
						sheetObj.CellFontColor(idx,prefix + "cntr_no") = sheetObj.RgbColor(255,0,0);
					}
				}
				CellFontColor(idx, prefix+"bkg_no") = blueColor;
   		      	CellFontUnderline(idx, prefix+"bkg_no") = true;
   		      	
   		      	if(sheetObj.CellValue(idx, prefix + "cntr_check")!= ""){
   		      		sheetObj.CellFont("FontItalic", idx, prefix + "cntr_check") = true;
   		      		sheetObj.CellFontColor(idx, prefix + "cntr_check") = sheetObj.RgbColor(255,0,0);
   		      		
					chk = idx;
					while(sheetObj.Cellvalue(chk, prefix + "bkg_no") == sheetObj.Cellvalue(chk-1, prefix + "bkg_no")){
						chk = chk-1;
					}
					sheetObj.CellFont("FontItalic", chk, prefix + "bkg_no") = true;
					CellFontColor(chk, prefix+"bkg_no") = redColor;
		      		CellFontUnderline(chk, prefix+"bkg_no") = true;
		      		
		      		cntrCnt = cntrCnt + 1;
				}
			}
   			var rowSpan = 1, tmpCnt = rowCnt = 0;
   			for (var i = pagedMaxCnt; i < TotalRows + HeaderRows ; i++) {
	      		CellFontColor(i, prefix+"bl_no") = blueColor;
	      		CellFontUnderline(i, prefix+"bl_no") = true;
	      		
   				if(sheetObj.CellFontColor(i, prefix + "bkg_no") == redColor){
		      			bkgCnt = bkgCnt + 1;
		      	}

	      		setCelColor( CellValue(i, prefix+"cntr_cfm_flg"), sheetObj, i, prefix+"cntr_cfm_flg", redColor);
	      		setCelColor( CellValue(i, prefix+"firm"),         sheetObj, i, prefix+"firm",         redColor);
	      		setCelColor( CellValue(i, prefix+"cm"),           sheetObj, i, prefix+"cm",           redColor);
	      		setCelColor( CellValue(i, prefix+"md"),           sheetObj, i, prefix+"md",           redColor);
	      		setCelColor( CellValue(i, prefix+"charge"),       sheetObj, i, prefix+"charge",       redColor);
	      		setCelColor( CellValue(i, prefix+"apprval"),      sheetObj, i, prefix+"apprval",      redColor);
	      		setCelColor( CellValue(i, prefix+"pkg"),          sheetObj, i, prefix+"pkg",          redColor);
	      		setCelColor( CellValue(i, prefix+"weight"),       sheetObj, i, prefix+"weight",       redColor);
	      		setCelColor( CellValue(i, prefix+"measuere"),     sheetObj, i, prefix+"measuere",     redColor);
	      		setCelColor( CellValue(i, prefix+"issue"),        sheetObj, i, prefix+"issue",        redColor);
	      		setCelColor( CellValue(i, prefix +"aes"),         sheetObj, i, prefix + "aes",        redColor);
	      		setCelColor( CellValue(i, prefix +"receiving"),   sheetObj, i, prefix + "receiving",  redColor);
	      		setCelColor( CellValue(i, prefix +"el_no"),		  sheetObj, i, prefix + "el_no",	  redColor);
	      		setCelColor( CellValue(i, prefix +"dde"),		  sheetObj, i, prefix + "dde",		  redColor);
	      		setCelColor( CellValue(i, prefix +"peb"), 		  sheetObj, i, prefix + "peb",		  redColor);
	      		setCelColor( CellValue(i, prefix +"caed"),		  sheetObj, i, prefix + "caed",		  redColor);
	      		
	      		if(CellValue(i,prefix+"weight") == "E"){
	      			CellFontColor(i, prefix+"weight") = redColor;
	      			
	      		}
	      		if(CellValue(i,prefix+"pkg") == "E"){
	      			CellFontColor(i, prefix+"pkg") = redColor;
	      			
	      		}      		
	      		
	      		if(CellValue(i,prefix+"measuere") == "E"){
	      			CellFontColor(i, prefix+"measuere") = redColor;
	      			
	      		}
	      		
	      		if ( CellValue(i,prefix + "qty_bkg") != CellValue(i,prefix + "qty_cntr")){
	      			CellFontColor(i, prefix+"qty_bkg") = redColor;
	      			CellFontColor(i, prefix+"qty_cntr") = redColor;
	      		}

	      		//아래는 shipper 와 consignee 를 bkg 별로 병합하기 위해 추가함
//	      		rowSpan = Number(CellValue(i, prefix + "rows_per_bkg"));
//	      		if (rowCnt<=tmpCnt) {
//	      			tmpCnt = rowCnt = 0;
//	      		}
//	      		if (1 < rowSpan) {
//	      			if (tmpCnt==rowCnt) {
//		      			rowCnt = rowSpan;
//		      			SetMergeCell(i, 18, rowSpan, 1);
//		      			SetMergeCell(i, 19, rowSpan, 1);
//	      			}
//	      			tmpCnt++;
//	      		}
	      	}
   			
   			document.form.dup_bkg.value = bkgCnt;
   			document.form.dup_cntr.value = cntrCnt;
   			
   			sheetObj.ColBackColor(prefix + "vgm_wgt") = sheetObj.RgbColor(204, 255, 253);
   			sheetObj.ColBackColor(prefix + "vgm_wgt_ut_cd") = sheetObj.RgbColor(204, 255, 253);
   			sheetObj.ColBackColor(prefix + "vgm_vrfy_sig_ctnt") = sheetObj.RgbColor(204, 255, 253);
   			sheetObj.ColBackColor(prefix + "vgm_mzd_tp_cd") = sheetObj.RgbColor(204, 255, 253);
   			//아래 두줄은 마지막로우의 셀이 SetMergeCell 로 병합되지 않아서 넣은 구문임
			DataInsert(-1);
			RowHidden(LastRow) = true;
    	 }
    	 
    	 pagedMaxCnt = sheetObj.LastRow;
    	 
     }
     
     function setCelColor(flag, obj,idx,celName,color){
     	if(flag =="N")
     			obj.CellFontColor(idx,celName) = color;
     }
   
			/*
		 *  Search Option or Item Option Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		    
     		if( colIdx == sheetObj.SaveNameCol(prefix + 	"bkg_no")){
						var param= "?pgmNo=ESM_BKG_0079&bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
						ComOpenWindowCenter2("/hanjin/ESM_BKG_0079.do"+param, "Booking Main", 1024,740,false,"scrollbars=yes,resizable=yes");
						
     		}else if( colIdx == sheetObj.SaveNameCol(prefix + 	"bl_no")){
						var param= "?bkg_no="+sheetObj.CellValue(rowIdx, prefix+"bkg_no");
//						ComOpenWindowCenter2("/hanjin/ESM_BKG_BL_TEST.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
						ComOpenWindowCenter2("/hanjin/ESM_BKG_0927.do"+param, "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
     		}
     }	 
		 
//	 function sheet1_OnSort(sheetObj) {
//		 var rowNum = 1;
//		 var curKey ;
//		 with (sheetObj) {
//			 MergSheet = msNone;
//			 for (var i=HeaderRows ; i <= Rows; i++) {
//				 curKey =  CellValue(i,prefix+"bkg_no");
//				 CellValue2(i,prefix+"dense_rank2") = rowNum;
//				 if (CellValue(i+1,prefix+"bkg_no") != curKey){
//					 rowNum++;
//			 	 }
//			  }
//			 MergeSheet = msHeaderOnly +	msPrevColumnMerge;
//		 }
//	  }
	 function sheet1_OnSort(sheetObj,col,SortArrow) {
		 var rowNum = 1;
		 var curKey ;
		 with (sheetObj) {
			 MergSheet = msNone;
			 if (SortArrow == "DESC"){
				 for (var i=2 ; i <= Rows; i++) {
					 curKey =  CellValue(i,prefix+"bkg_no");
					 CellValue2(i,prefix+"dense_rank2") = rowNum;
					 if (CellValue(i+1,prefix+"bkg_no") != curKey){
						 rowNum++;
				 	 }
				  }

			 }
			 else{
				 for (var i=3 ; i <= Rows ; i++) {
					 curKey =  CellValue(i,prefix+"bkg_no");
					 CellValue2(i,prefix+"dense_rank2") = rowNum;
					 if (CellValue(i+1,prefix+"bkg_no") != curKey){
						 rowNum++;
				 	 }
				  }

			 }
			 MergeSheet = msHeaderOnly +	msPrevColumnMerge;  
			 
		 }
	  }
	   
	 /*
	* Rd 파라함수
	*/
	function RdParam(sheetObject,prefix) {
		var strResult = ""; 
		var inStr ="";
		var title ="0";
		var vsNM ="";
		var iCheckRow = sheetObject.FindCheckedRow(prefix + "check"); 
		var arrRow = iCheckRow.split("|");
		if(iCheckRow == "")
			 return;
			 
		for (var idx=0; idx<arrRow.length-1; idx++) {			
			if(sheetObject.CellValue(arrRow[idx],prefix+"check")==1){ 
				if (inStr.length > 1){
					inStr+=","+"('"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no")+"','"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"')";
				}else{
					inStr="('"+sheetObject.CellValue(arrRow[idx],prefix+"bl_no")+"','"+sheetObject.CellValue(arrRow[idx],prefix+"cntr_no")+"')";
				}
			}
		}
		//[(bl_no,cntr_no),(bl_no,cntr_no)] in 조건으로 배열에 넣음
		strResult= rdParamSet(inStr);		 
		
		return strResult; 
	}
	 	 
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	switch(sAction) {
    		case IBSEARCH:
	    		if( ComIsNull(comboObjects[0].Code) ) {
 					ComShowCodeMessage('BKG00227');
 					formObj.vvd_sig.focus();
 					return false;
		  		}
	    		if( comboObjects[0].Code.length < 9 ) {
 					ComShowCodeMessage('BKG00538');
 					formObj.vvd_sig.focus();
 					return false;
		  		}
	    		var cust_seq = formObj.p_cust_seq.value;
	    		if(!ComIsNumber(cust_seq) && cust_seq.length != 0 ){
	    	 		ComShowCodeMessage("BKG00458"); // invalid customer code
	    	 		formObj.p_cust_seq.focus();
	    	 		return false;
	    	 	}
	    		
		    	 formObj.multi_vvd.value = comboObjects[0].Code;
		    	  
		    	 var arVvds = formObj.multi_vvd.value.split(",");
		    	 
//		    	 if (arVvds.length >  10){
//		    		 ComShowCodeMessage("BKG02218");
//		    		 return false;
//		    	 }
	    	
	  			break;

    		case "btn_Combine":
				var param = "";
				var chkRow = ComFindAll(sheetObj, prefix + "check2", "1").split("|");
				var bdrBkgList = "";
	
				if ( 1 < chkRow.length ) {
					var bkgNo = sheetObj.CellValue(chkRow[0], prefix + "bkg_no").substring(0, 3);
					var shCd  = sheetObj.CellValue(chkRow[0], prefix + "shipper_code");
					var vvdCd  = sheetObj.CellValue(chkRow[0], prefix + "tvvd");
					var porCd = sheetObj.CellValue(chkRow[0], prefix + "por");
					var polCd = sheetObj.CellValue(chkRow[0], prefix + "pol");
					var podCd = sheetObj.CellValue(chkRow[0], prefix + "pod");
					var delCd = sheetObj.CellValue(chkRow[0], prefix + "del");
					var porNodCd = sheetObj.CellValue(chkRow[0], prefix + "por_nod_cd");
					var delNodCd = sheetObj.CellValue(chkRow[0], prefix + "del_nod_cd");
					var broker   = sheetObj.CellValue(chkRow[0], prefix + "broker");
    				var bkgOfcCd = sheetObj.CellValue(chkRow[0], prefix + "bkg_ofc_no");						
	
					for (var idx=0;idx<=chkRow.length-1;idx++) {
						if (bkgOfcCd != sheetObj.CellValue(chkRow[idx], prefix + "bkg_ofc_no")) {
    						ComShowMessage(msgs['BKG00160']);
    						return false;
						}
						if (shCd != sheetObj.CellValue(chkRow[idx], prefix + "shipper_code")) {
							ComShowMessage(msgs['BKG00157']);
							return false;
						}
						if (vvdCd != sheetObj.CellValue(chkRow[idx], prefix + "tvvd")) {
							ComShowMessage(msgs['BKG00998']);
							return false;
						}
						if (porCd != sheetObj.CellValue(chkRow[idx], prefix + "por")) {
							ComShowMessage(msgs['BKG00158']);
							return false;
						}
						if (polCd != sheetObj.CellValue(chkRow[idx], prefix + "pol")) {
							ComShowMessage(msgs['BKG00997']);
							return false;
						}
						if (podCd != sheetObj.CellValue(chkRow[idx], prefix + "pod")) {
							ComShowMessage(msgs['BKG03159']);
							return false;
						} 
						if (delCd != sheetObj.CellValue(chkRow[idx], prefix + "del")) {
							ComShowMessage(msgs['BKG00159']);
							return false;
						}
						if (porNodCd != sheetObj.CellValue(chkRow[idx], prefix + "por_nod_cd")) {
							ComShowMessage(msgs['BKG02014']);
						}
						if (delNodCd != sheetObj.CellValue(chkRow[idx], prefix + "del_nod_cd")) {
							ComShowMessage(msgs['BKG02015']);
						}
						if (broker != sheetObj.CellValue(chkRow[idx], prefix + "broker")) {
							ComShowMessage(msgs['BKG02015']);
							return false;
						}
						if(sheetObj.CellValue(chkRow[idx],prefix + "bdr")=="Y"){
							if(bdrBkgList ==""){
								bdrBkgList = sheetObj.CellValue(chkRow[idx], prefix + "bkg_no");
							} else {
								bdrBkgList = bdrBkgList + ", " + sheetObj.CellValue(chkRow[idx], prefix + "bkg_no");
							}
						}
					}
					if(bdrBkgList !=""){
						if (!ComShowCodeConfirm("BKG02038", bdrBkgList)) {
	        	    		return false;
						} 
					}
				}		
				break;

    	}
         return true;
     }
     
     /**
      * 화면 yyyyMMd 날짜 체크
      */
     function dateCheck(dateobj){
     	if(dateobj.value =="") return true;//null이면 체크 안함
      return ComIsDate(dateobj.value);
     }	


    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
    }
    

 /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         switch(sheetObj.id) {

            case "sheet1":
              with (sheetObj) {
                // 높이 설정
                style.height = 250;
                 
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly +	msPrevColumnMerge;  

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, rowsPerPage);

				var HeadTitle1 = " |No.||No.|Booking No.|B/L No.|L.OFC|Rep|C.OFC|Status|Status|Q'ty|Q'ty|Final\nConfirm|Confirm Id|Container|Container|Container|Container|Container|Container|Container|Container|Container|Container|Container|Container|Container|Event Yard|BS Code|Event date|Duplicate|Shipper|Consignee|F/Forwarder|FF|M/D|AES|US Type|TAX ID|E/L|DDE|PEB|CAED|POD|DEL|SVC Term|SVC Term|Rate|Rate|Package|Weight|Measure|Special|Special|Special|Special|BDR|B/L Issue|DPCS|DPCS|DPCS|DPCS|DPCS|Via S/I|Via S/I|S/I\nready||||||||||||||VVD";
				var HeadTitle2 = " |No.||No.|Booking No.|B/L No.|L.OFC|Rep|C.OFC|B|C|BKG|CNTR|Final\nConfirm|Confirm Id|No.|SZ|Weight|Weight|VGM|VGM|VGM|VGM|Measure Qty|Seal|Vol|ST|C/M|Event Yard|BS Code|Event date|Duplicate|Shipper|Consignee|F/Forwarder|FF|M/D|AES|US Type|TAX ID|E/L|DDE|PEB|CAED|POD|DEL|R|D|Charge|Approval|Package|Weight|Measure|D|R|A|B|BDR|B/L Issue|I|R|Q|F|STS|Receiving|Via|S/I\nready||||||||||||||VVD";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 5, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix + "ibflag",        	false,	"",	dfNone,	0,	true,	true );
				InitDataProperty(0,	cnt++ , dtHidden,		30,	daCenter,	true,	prefix + "dense_rank",      false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtCheckBox,		30,	daCenter,	true,	prefix + "check",           false,	"",	dfNone,	0,	true,	true );
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "dense_rank2",     false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			90,	daCenter,	true,	prefix + "bkg_no",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			90,	daCenter,	true,	prefix + "bl_no",         	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "ob_sls_ofc_cd",  	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "ob_srep_cd",  	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "ctrt_ofc_cd",  	false,	"",	dfNone,	0,	false,	false);
                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "bkg_sts_cd",     	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "bkg_cgo_tp_cd",  	false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			95,	daCenter,	true,	prefix + "qty_bkg",        	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			95,	daCenter,	true,	prefix + "qty_cntr",       	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "cntr_cfm_flg",   	false,	"",	dfNone,	0,	false,	false);
				                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			85,	daCenter,	true,	prefix + "cntr_cfm_id",   	false,	"",	dfNone,	0,	false,	false);

				InitDataProperty(0,	cnt++ , dtData,			85,	daCenter,	false,	prefix + "cntr_no",       	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "sz",       	    false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_wgt",    	false,	"",	dfFloat,0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "wgt_ut_cd",       false,	"",	dfNone,	0,	false,	false);

				//vgm_wgt,vgm_wgt_ut_cd
				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "vgm_wgt",    	    false,	"",	dfFloat,0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "vgm_wgt_ut_cd",   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			99,	daCenter,	true,	prefix + "vgm_vrfy_sig_ctnt",   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "vgm_mzd_tp_cd",   false,	"",	dfNone,	0,	false,	false);
				
				
				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "meas_qty",       	false,	"",	dfFloat,3,	false,	false);				
				InitDataProperty(0,	cnt++ , dtData,			35,	daCenter,	true,	prefix + "seal",     	    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "vol",      	    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "st",       	    false,	"",	dfNone,	0,	false,	false);
                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "cm",       	    false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			80,	daCenter,	true,	prefix + "event_yard",      false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			55,	daCenter,	true,	prefix + "blck_stwg_cd",  		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			110,daCenter,	true,	prefix + "event_dt",     	false,	"",	dfNone,	0,	false,	false);				
				InitDataProperty(0,	cnt++ , dtData,			85,	daCenter,	true,	prefix + "cntr_check",      false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			120,daLeft,		true,	prefix + "shipper",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			120,daLeft,		true,	prefix + "consignee",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtHidden,		120,daLeft,		true,	prefix + "ffdr",      		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "ff",           	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "md",           	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "aes",         	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "cust_tp",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "tax_id",         	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "el_no",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++ , dtData,			30,	daCenter, 	true,	prefix + "dde",				false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ ,	dtData,			30,	daCenter,	true,	prefix + "peb",				false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			40,	daCenter,	true,	prefix + "caed",			false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "pod_cd",         	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "del_cd",         	false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "rcv_term_cd",     false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	true,	prefix + "de_term_cd",      false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "charge",  	    false,	"",	dfNone,	0,	false,	false);
                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "apprval",	       	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "pkg",       	   	false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "weight",       	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "measuere",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "special_d",      	false,	"",	dfNone,	0,	false,	false);
                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "special_r",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "special_a",      	false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			25,	daCenter,	true,	prefix + "special_b",      	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "bdr",          	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			60,	daCenter,	true,	prefix + "issue",      	   	false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	false,	prefix + "dpcs_i",    	   	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	false,	prefix + "dpcs_r",     	   	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	false,	prefix + "dpcs_q",     	   	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	false,	prefix + "dpcs_f",     	   	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			30,	daCenter,	false,	prefix + "dpcs_sts",  	   	false,	"",	dfNone,	0,	false,	false);
				                                                                                                                                             
				InitDataProperty(0,	cnt++ , dtData,			70,	daCenter,	true,	prefix + "receiving",    	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "via",          	false,	"",	dfNone,	0,	false,	false); 
				InitDataProperty(0,	cnt++ , dtData,			50,	daCenter,	true,	prefix + "si_ready_flg",  	false,	"",	dfNone,	0,	false,	false);
				
				//shipper, consignee 병합 관련 추가 (1개)
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "rows_per_bkg"); 
				// combine 관련 추가 (11개)
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "shipper_code"); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "por"         ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "pol"         ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "pod"         ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "del"         ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "por_nod_cd"  ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "del_nod_cd"  ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "broker"      ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "bkg_ofc_no"  ); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "hitchment_yn"); 
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "tvvd"        ); 
				//checkbox머지 관련 컬럼 추가 (1개)
				InitDataProperty(0,	cnt++ , dtHidden,		0,	daLeft,		false,	prefix + "check2"      );
				
				InitDataProperty(0,	cnt++ , dtData,			70,	daCenter,	true,	prefix + "key_vvd",          	false,	"",	dfNone,	0,	false,	false);

				CountPosition = 0;
				
 			}
			break;

            	
            case "sheet2":
				with (sheetObj) {
					var cnt = 0;
					// 높이 설정
					style.height = 110; //getSheetHeight(1);
	
					//전체 너비 설정
					SheetWidth = 110; //mainTable.clientWidth;
	
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 9, 100);
	
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(5, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
	
					var HeadTitle = "|Template Seq.|Template Type|Template Name|Contents";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtStatus,	20,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	false,	"tmplt_seq",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,	90,		daCenter,	false,	"tmplt_tp_cd",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,		140,	daLeft,		false,	"tmplt_hdr_nm",	false,		"",      dfNone,			0,		true,		true, 10);
					InitDataProperty(0, cnt++ , dtData,		200,	daLeftTop,	false,	"tmplt_ctnt",	false,		"",      dfNone,			0,		true,		true, 45);
	
					CountPosition = 0;
				}
				break;
         }
     }
    

  	function comBkgCallPop0974(callback_func){
		var chkRow = ComFindAll(sheetObjects[0], prefix + "check2", "1").split("|");
		if (1 < chkRow.length) {
			var param = "";
			for (var idx=0; idx<chkRow.length; idx++) {
				if (0==idx) {
					param = "sheet1_ibflag=U&sheet1_bkg_no=" + sheetObjects[0].CellValue(chkRow[idx], prefix + "bkg_no")
						+"&sheet1_bdr_flg=" + ("Y"==sheetObjects[0].CellValue(chkRow[idx], prefix + "bdr") ? "YES":"NO");
				} else {
					param = param +"&sheet1_ibflag=U&sheet1_bkg_no=" + sheetObjects[0].CellValue(chkRow[idx], prefix + "bkg_no")
						+"&sheet1_bdr_flg=" + ("Y"==sheetObjects[0].CellValue(chkRow[idx], prefix + "bdr") ? "YES":"NO");
				}
			}
			ComOpenPopup("/hanjin/ESM_BKG_0974.do?"+param, 800, 350, callback_func, "1,0,1,1,1", true);
		}
	}

	function callBack0974(rArray){
		var formObj = document.form;
		formObj.mst_bkg_no.value=rArray[0];
		var chkRow = ComFindAll(sheetObjects[0], prefix + "check2", "1").split("|");
		var bdrFlg = "N";
		if (1 < chkRow.length) {
			for (var idx=0; idx<chkRow.length; idx++) {
				if (sheetObjects[0].CellValue(chkRow[idx], prefix + "bdr") == "Y") {
					bdrFlg="Y";
					break;
				}
			}
			if ("Y"==bdrFlg) {
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.mst_bkg_no), "C");
		 		doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			} else {
				doActionIBSheet(sheetObjects[0],formObj,"run_combine");
			}
		}
	}         

	/**
     * CA Reason 후속 처리 : CaReasonModify
     */ 
	function setCAReasonCallBack(arrPopupData) {
		var formObj = document.form;
		//01. CA ReasonCd, Remark 입력정보 받아서,
		var strRsnCd   = nullToBlank(arrPopupData[0][2]);
		var strRemark  = nullToBlank(arrPopupData[0][3]);
		//02. modifyCaReason(e) call
		formObj.ca_rsn_cd.value  = strRsnCd;
		formObj.ca_remark.value  = strRemark;
	}

	/**
	 * 머지된 체크박스 로우의 버그를 해결하기 위한 전역 변수와 이벤트 함수
	 */
	var startMergeRow = lastMergeRow = 0;
	function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {  //변경전이벤트
		with (sheetObj) {
	    	if (2==MouseCol) {
		    	startMergeRow = Number(GetMergedStartCell(MouseRow ,MouseCol).split(",")[0]);
		    	lastMergeRow = Number(GetMergedEndCell(MouseRow ,MouseCol).split(",")[0]);
			}
		}
	}
	function sheet1_OnChange(sheetObj, Row, Col, Value) {  //변경후이벤트
		if (2==Col) {
    		sheetObj.CellValue2(startMergeRow, prefix+"check2") = 1==Value ? "1":"";
	    	for (var i = startMergeRow; i <= lastMergeRow; i++) {
	    		sheetObj.CellValue2(i, Col) = Value;
	    	}
		}
	}
	 /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	 var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    }
     

     /**
      *Click Event 
      *@return
      */
     function obj_Click() {
     	var frm = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	var srcValue = window.event.srcElement.getAttribute("value");
     	var sheetObject1 = sheetObjects[0];
     	
//     	alert(srcName);
     	
     	if(srcName == "p_dpcs_flg")  {   	
     	
     		dpcsFlagCheck();
     	}

     }     
     
      
     /**
	  * VVD Name Upper Event
  	  */
  	 function insertItm(vvd) {
		 var formObj  = document.form;
		 
		 if (vvd.value.length != 9){
			 ComShowCodeMessage("BKG00145");//Please! Check your VVD.	
			 vvd.focus();
			 return;
		 }
		 
		 comboObjects[0].InsertItem(-1, vvd.value, vvd.value);
		 comboObjects[0].Index2 = comboObjects[0].GetCount()-1;

		 vvd.value = "";
		 vvd.focus();
	 }
	 
     /**
      * VVD Selection Inquiry Popup Open
      */ 
     function getVvds(){
    	 var param = "?max_knt=10";
    	 var pWin = ComOpenWindow("/hanjin/ESM_BKG_0753.do" + param,"open0753", "statebar=no,width=920,height=390,left=200,top=0");
     }
     
     function clearVvds(){
    	 document.form.p_vvd.RemoveAll();
     }
     
 	 /**
	  * VVD Selection Inquiry Popup Value Import
	  */
     function setVvds(vvds){
    	  
		 var formObj = document.form;
    	 var comboObj = comboObjects[0];
    	  
    	 vvds = vvds.replace(/\s/g,"");
    	 var arVvds = vvds.split(",");
    	  
    	 for( var i = 0 ; i < arVvds.length ; i++ ){
    		 if( vvds.length > 0 ){
    			 comboObj.InsertItem(-1, arVvds[i], arVvds[i]);
    		 }
    	 }
    	  
    	 comboObj.Text2 = vvds;
    	 formObj.vvd_sig.value = "";

     }
	  
	  
	  function form1_change(){
			/* 데이터 변경 여부 체크 */
			document.form.dirty_flag.value = 'Y';

			var srcName = event.srcElement.getAttribute("name");
			switch(srcName){

				case "vvd_word_template":
					document.form.vvd_tmp.value = "";
					setTemplateValues('V');

				break;
			}
		}
	  
	  function setTemplateValues(tmplt_type){
			var sheetObj = sheetObjects[1];
			var lstObj = '';
			var tgtObj = '';
			var tmplt_seq = '';
			var tmplt_ctnt = '';

			if(tmplt_type=='V'){
				lstObj = document.form.vvd_word_template;
				tgtObj = document.form.vvd_tmp;
			}

			tmplt_seq = lstObj.options[lstObj.selectedIndex].value;
			var rowCnt = sheetObj.RowCount;
			for(idx=1;idx<=rowCnt;idx++){
				if(sheetObj.CellValue(idx, "tmplt_tp_cd") == tmplt_type && sheetObj.CellValue(idx, "tmplt_seq") == tmplt_seq){
					tgtObj.value = sheetObj.CellValue(idx, "tmplt_ctnt");
				}
			}
			
			setVvds(tgtObj.value);
		}
	  
	  function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	      //풍선도움말 만들기
	      sheetObj.ToolTipOption="balloon:true;width:100;icon:0;title:";
	      var msgStr = "Note : D - Duplicate  VVD\n         A - Advanced Ship\n         S - Short Ship";
	      
	      if (sheetObj.MouseCol==sheetObj.SaveNameCol(prefix + "cntr_check")){
	    	  sheetObj.MousePointer = "Hand";
	    	  sheetObj.MouseToolTipText = msgStr;
	      }else{
	    	  sheetObj.MousePointer = "Default";
	    	  if (sheetObj.MouseToolTipText != ""){ 
	    		  sheetObj.MouseToolTipText = "";
	    	  } 
	      }
	  }

	  
     
/* 개발자 작업  끝 */    