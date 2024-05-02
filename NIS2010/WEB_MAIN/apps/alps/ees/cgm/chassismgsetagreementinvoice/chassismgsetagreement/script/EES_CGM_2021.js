/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2021.js
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.10 김창식
* 1.0 Creation
*--------------------------------------------------
* History
* 2014-09-25 Chang Young Kim 10만불 비용지급 결재건 3차 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ees_cgm_2021 : ees_cgm_2021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cgm_2021() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (S) */ 
	if(window.addEventListener) {
		window.addEventListener("message", receiveMessage, false);
	}

	if(window.attachEvent) {
		window.attachEvent("onmessage", receiveMessage);
	}

	if(document.attachEvent) {
		document.attachEvent("onmessage", receiveMessage);
	}

	// return 처리를 위한 함수 (필수)
	function receiveMessage(event) {
		// 리턴 처리 방법
		returnGwLink(event.data)
		
	}
	/* 해당 메인에 포함되는 iframe으로 부터 값을 리턴받기 위한 정의 (E) */
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * @param 없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.15
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            	case "btn_Retrieve":
            		if(ComCgmIsActionButtonEnable(srcName)){
	 					if(validateForm(sheetObject1,formObject,IBSEARCH) != false) {
	 						// Search 실행
	 						var result = doActionIBSheet(sheetObject1, formObject, IBSEARCH);

	 						if(result){
	 							// Form Control 활성/비활성 처리
	 							doControlEnable("btn_Retrieve");
	 						
	 							// 버튼 활성/비활성 처리 
	 							doActionBtnEnable('R');
	 						}
	 					}
            		}
 					break;

                case "btn_New":
                	if(ComCgmIsActionButtonEnable(srcName)){
	 					// Form Control 초기화
 						initControl();
 						formObj.agmt_ref_no.focus();
 						
	 					// Form Control Enable 설정
	 					doControlEnable("btn_New");
	
	 					// 버튼 활성/비활성 처리
	 					formObject.agmt_no.value = "NEW";
	    		    	doActionBtnEnable('N');
 					}
                	break;

                case "btn_Delete":
                	if(ComCgmIsActionButtonEnable(srcName)){
                		if(validateForm(sheetObject1,formObject,IBDELETE) != false) {
                			if(ComShowCodeConfirm('CGM00005','the Agreement')){
		 						// 삭제 실행
		 						doActionIBSheet(sheetObject2,formObject,IBDELETE);
		 					}
                		}
 					}
                	break;

                case "btn_Save":
                	if(ComCgmIsActionButtonEnable(srcName)){
                		if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
		 					if(ComShowCodeConfirm('CGM10047')){
		 						// 저장 실행
		 						doActionIBSheet(sheetObject1,formObject,IBSAVE);
		 					}
                		}
 					}
 					break;

                case "btn_VersionUp":
                	if(ComCgmIsActionButtonEnable(srcName)){
 						// Version Up
 						doVersionUp();
 						
 						// Form Control Enable 설정
 						doControlEnable("btn_VersionUp");
 						
	 					// 버튼 활성/비활성 처리
	    		    	doActionBtnEnable('V');
	    		    	
 					}
 					break;
 					
                case "btns_Calendar_agmtDt" :		// Agreement Date
					if(!formObject.agmt_dt.readOnly){
					var cal = new ComCalendar();
					cal.select(formObject.agmt_dt, "yyyy-MM-dd");
					}
					break;
					
				case "btns_Calendar_effDt" :		// Rate Eff. Date (From Date)
					if(!formObject.eff_dt.readOnly){
						var cal = new ComCalendar();
			    		cal.select(formObject.eff_dt, "yyyy-MM-dd");
					}
	    			break;		
	    		
				//case "btns_Calendar_expDt" :		// Rate Eff. Date (To Date)
				//	if(!formObject.exp_dt.readOnly){
				//		var cal = new ComCalendar();
			    //		cal.select(formObject.exp_dt, "yyyy-MM-dd");
				//	}
		    	//	break;
		    		
				case "btns_Calendar_agmt_effDt" :		// Agreement Eff. Date (From Date)
					if(!formObject.agmt_eff_dt.readOnly){
						var cal = new ComCalendar();
			    		cal.select(formObject.agmt_eff_dt, "yyyy-MM-dd");
					}
	    			break;		
	    		
				case "btns_Calendar_agmt_expDt" :		// Agreement Eff. Date (To Date)
					if(!formObject.agmt_exp_dt.readOnly){
						var cal = new ComCalendar();
			    		cal.select(formObject.agmt_exp_dt, "yyyy-MM-dd");
					}
		    		break;
		    		
				case "btns_agmtno":	// Agreement No 가져오기 팝업
					if(!formObject.agmt_no.readOnly){
						ComOpenPopupWithTarget('/hanjin/EES_CGM_2022.do', 800, 435, "agmt_no:agmt_no", "1,0,1,1,1,1,1,1,1", true);
					}
					break;
				
				case "btns_vndr":	// Lessor Code 가져오기 팝업
					if(!formObject.vndr_seq.readOnly){
						ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
					}
					break;	
					
				case "btns_office":	// Lessor Code 가져오기 팝업
					if(!formObject.agmt_iss_ofc_cd.readOnly){
						ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 620, 480, "ofc_cd:agmt_iss_ofc_cd", "1,0,1,1,1,1", true);
					}
					break;
					
				case "btns_gwUqDoc":	// 2014-09-24 Chang Young Kim, G/W 링크 호출
					
					var csrGwUrl = formObject.csr_gw_url.value;
					
					// for Local Server Test
					if(csrGwUrl != "null") {
						
						//해당 메인에 포함되는 iframe 동적 생성 (GW 호출하기 위한 IFrame)
						ifrm = document.createElement("IFRAME");
						ifrm.setAttribute("id", "gwrequest");
						ifrm.style.width = 0+"px";
						ifrm.style.height = 0+"px";
						
						// for Local Server Test
						if(!ComIsEmpty(formObject.gw_uq_doc_no.value)) { // 계약문서 번호가 있을 때
							
							var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACTVIEW&parameter="+formObject.gw_uq_doc_no.value);
							ifrm.setAttribute("src", url);
							document.body.appendChild(ifrm);
							
						} else {
							
							 var url = "/hanjin/gwProxy.jsp?gwUrl=" + encodeURIComponent("http://"+csrGwUrl+"/Login.aspx?command=CONTRACT&parameter=ALPS|MGS");
							 ifrm.setAttribute("src", url);
							 document.body.appendChild(ifrm);
							
						}
						
					} else {
						// setting
						formObject.gw_uq_doc_no.value	= "123465";
						formObject.gw_uq_doc_tit_nm.value	= "CHS_DOCU_123456.xlsx";
						
						// button setting
						doActionBtnEnable('G');
					}
					
					break;
					
				case "btn_gwDelete":	// 2014-09-24 Chang Young Kim, GW_UQ_DOC_NO, GW_UQ_DOC_TIT_NM 개별 삭제 [Update]
					
					if(validateForm(sheetObject1,formObject,IBSAVE) != false) {
						if(!ComIsEmpty(formObject.gw_uq_doc_no.value)) {
							// setting
							formObject.gw_uq_doc_no.value	= "";
							formObject.gw_uq_doc_tit_nm.value	= "";
							
							// 저장 실행
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						} else {
							// msgs['COM130302'] = 'You can\'t delete {?msg1}.';
							ComShowCodeMessage('COM130302','a empty data');
						}
					}
					break;

            } // end switch
            tRoleApply();
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e);
     		}
     	}
    }
    
	//GW에서 리턴된 값 화면 적용
	function returnGwLink(msg) {
		
		msg = msg.split(",");
		
		var formObj = document.form;
		
		// setting
		ComSetObjValue(formObj.gw_uq_doc_no, msg[0]);
		ComSetObjValue(formObj.gw_uq_doc_tit_nm, msg[1]);

		// button setting
		doActionBtnEnable('G');
	}
	
    /**
     * IBSheet Object를 배열로 등록 <br>
     * @param  {object} sheetObj	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.15
     */
    function setSheetObject(sheet_obj){

        sheetObjects[sheetCnt++] = sheet_obj;

    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.28
     */
    function loadPage() {
    	var formObj = document.form;
    	
    	// axon event �깅줉
        axon_event.addListenerFormat('keypress', 'obj_keypress', form);
        axon_event.addListenerFormat('keydown', 'obj_keydown', form);
        axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
        axon_event.addListener('change', 'obj_change', 'agmt_no'); 
        axon_event.addListener('change', 'obj_change', 'vndr_seq'); 
        axon_event.addListener('change', 'obj_change', 'agmt_iss_ofc_cd'); 
        axon_event.addListener('change', 'obj_change', 'pay_term_dys');
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        
        for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	
        // IBMultiCombo 초기화 
        comboObjects[comboCnt++] = document.agmt_ver_no;
        comboObjects[comboCnt++] = document.agmt_lstm_cd; 

        
        for(var k=0;k<comboObjects.length;k++){
     		initCombo(comboObjects[k]);
 	    }

        // 버튼 활성/비활성 처리
    	doActionBtnEnable('L');
    	
    	// Lease Term Combo Control에  초기값을  설정한다.
//        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
    	doActionIBSheet(sheetObjects[0], formObj, IBRESET);
        // Form Control Enable 설정
        doControlEnable("LOAD");
        
        // Form Object 초기화 및  Control Value Reset 처리
     	initControl();
     	
     	tRoleApply();
    }
          
     /**
      * Form의 Conrol 를 초기화 시킨다. <br>
      * @param  없음
      * @return 없음
      * @author 김창식
      * @version 2009.05.20
      */
    function initControl(){
     	// Form 객체 선언
      	formObj = document.form;
          
        // Form Object 초기화 
        with(formObj){
         	ComCgmSetObjectValue(eq_knd_cd);
         	ComCgmSetObjectValue(agmt_ofc_cty_cd);
         	ComCgmSetObjectValue(agmt_seq);
         	ComCgmSetObjectValue(agmt_no);
         	ComCgmSetObjectValue(agmt_ver_no);
         	ComCgmSetObjectValue(lst_ver_flg);
         	ComCgmSetObjectValue(agmt_ref_no);
         	ComCgmSetObjectValue(agmt_dt);
         	ComCgmSetObjectValue(agmt_iss_ofc_cd);
        	ComCgmSetObjectValue(gw_uq_doc_tit_nm);
    		ComCgmSetObjectValue(gw_uq_doc_no);
         	ComCgmSetObjectValue(eff_dt);
         	ComCgmSetObjectValue(exp_dt);
         	ComCgmSetObjectValue(vndr_seq);
         	ComCgmSetObjectValue(vndr_lgl_eng_nm);
         	ComCgmSetObjectValue(pay_term_dys);
         	
         	ComCgmSetObjectValue(onh_hndl_rt_amt,'0.00');
         	ComCgmSetObjectValue(offh_hndl_rt_amt,'0.00');
         	ComCgmSetObjectValue(mon_dpc_rt_amt,'0.00');
         	ComCgmSetObjectValue(max_dpc_rt_amt,'0.00');
         	ComCgmSetObjectValue(init_dpc_rt_amt,'0.00');
         	
         	ComCgmSetObjectValue(onh_init_val_amt_clg,'0.00');
         	ComCgmSetObjectValue(mgst_potc_scg_rt_amt_clg,'0.00');
         	ComCgmSetObjectValue(mgst_prtc_scg_rt_amt_clg,'0.00');
         	ComCgmSetObjectValue(mgst_bldp_rt_amt_clg,'0.00');
         	ComCgmSetObjectValue(mgst_lse_fx_rt_amt_clg,'0.00');
            
         	ComCgmSetObjectValue(onh_init_val_amt_umg,'0.00');
         	ComCgmSetObjectValue(mgst_potc_scg_rt_amt_umg,'0.00');
         	ComCgmSetObjectValue(mgst_prtc_scg_rt_amt_umg,'0.00');
         	ComCgmSetObjectValue(mgst_bldp_rt_amt_umg,'0.00');
         	ComCgmSetObjectValue(mgst_lse_fx_rt_amt_umg,'0.00');
         	
         	diff_rmk.value = "";
         	 
         	ComCgmSetObjectValue(pre_eff_dt);
         	ComCgmSetObjectValue(pre_exp_dt);
         	
         	ComCgmSetObjectValue(agmt_eff_dt);
         	ComCgmSetObjectValue(agmt_exp_dt);
         	
         	agmt_ref_no.ReadOnly = true;
         	vndr_lgl_eng_nm.ReadOnly = true;
         	 
        }
        
        // MultiCombo 초기화
        comboObjects[0].RemoveAll();
   		comboObjects[1].Text2 = "";	
   		         
   		// Tab 첫번째로 이동
   		tabObjects[0].SelectedIndex = 0; 
   		
   		
   		
   		// 초기 focus
        formObj.agmt_no.focus();
    } 
      
    /**
     * Version Up 기능을 수행한다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.16
     */
    function doVersionUp(){
      	var index = comboObjects[0].GetCount(); 
      	var agmt_ver_no = index + 1;
      	 
      	// version 설정
      	comboObjects[0].InsertItem(index, agmt_ver_no, agmt_ver_no);
      	comboObjects[0].Text2 = agmt_ver_no;
           
        // eff_dt 와 exp_dt 를 저장
        document.form.pre_eff_dt.value = document.form.eff_dt.value;
        document.form.pre_exp_dt.value = document.form.exp_dt.value;
          
        document.form.eff_dt.value = "";
        document.form.exp_dt.value = document.form.agmt_exp_dt.value;
        
        // 수정중
        document.form.pre_agmt_exp_dt.value = document.form.agmt_exp_dt.value;
    }      
     
    /**
     * Control 의 Action 별 Enable 제어 기능을 수행한다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.15
     */     
    function doControlEnable(srcName){
    	
    	var formObj = document.form;
    	
    	switch(srcName){
    		case "btn_Retrieve":  			
    			setFormControlEnable(formObj, false);
    			break;
    	 		
    	 	case "btn_New":
    	 		setFormControlEnable(formObj, true);
    	 		break;
    	 			
    	 	case "btn_VersionUp":
    	 		setFormControlEnable(formObj, true);
    	        ComCgmEnableObject(formObj.agmt_no, false);
    	        ComCgmEnableObject(formObj.btns_agmtno, false);
    	        ComCgmEnableObject(formObj.agmt_eff_dt, false);
    	        ComCgmEnableObject(formObj.agmt_exp_dt, true);
    	        ComCgmEnableObject(formObj.btns_Calendar_agmt_effDt, false);
        		ComCgmEnableObject(formObj.btns_Calendar_agmt_expDt, true);
    	         
    	        comboObjects[1].Enable = false;
    	        ComCgmEnableObject(formObj.vndr_seq, false);
    	        ComCgmEnableObject(formObj.btns_vndr, false);
    	        
    	        ComCgmEnableObject(formObj.agmt_exp_dt, true, 'input1');
//    	        ComCgmEnableObject(formObj.btns_Calendar_agmt_expDt, true);
    	       // doOptionBtnAction(formObj, "agmt_exp_dt");
//    	        ComCgmEnableObject(formObj.agmt_exp_dt, true, 'input1');
    	        
    	 		break;
    	 		
    	 	default:	// Load
    	 		setFormControlEnable(formObj, false);
    	 	    ComCgmEnableObject(formObj.agmt_no, true);
    	 	    ComCgmEnableObject(formObj.btns_agmtno, true);
    	 		break;
    	}
    	tRoleApply();
    } 
     
     /**
     * Action 버튼의 활성/비활성을 설정한다. <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */
    function doActionBtnEnable (actionFlag){
    	var btnRetrieve  	= document.getElementById("btn_Retrieve");
    	var btnNew 	  		= document.getElementById("btn_New");
    	var btnSave 	  	= document.getElementById("btn_Save");
     	var btnDelete    	= document.getElementById("btn_Delete");
     	var btnVersionUp 	= document.getElementById("btn_VersionUp");
     	
     	if(actionFlag != "G") { 
			document.form.action_flag.value = actionFlag; // L, R, N, V
		}
     	
     	switch(actionFlag){
     	 	case "L":
     	 		btnRetrieve.className = BTN_ENABLE;
    			btnNew.className = BTN_ENABLE;
    			btnSave.className = BTN_DISABLE;
    			btnDelete.className = BTN_DISABLE;
    			btnVersionUp.className = BTN_DISABLE;
     	 		break;
    	 		 
    		case "N":
    			btnRetrieve.className = BTN_ENABLE;
    			btnNew.className = BTN_ENABLE;
    			btnSave.className = BTN_ENABLE;
    			btnDelete.className = BTN_DISABLE;
    			btnVersionUp.className = BTN_DISABLE;
    		 	break;
    		 		
    		case "R":
    			var lstVerFlg = document.form.lst_ver_flg.value;
    	     	 
    			btnRetrieve.className = BTN_ENABLE;
     			btnNew.className = BTN_ENABLE;
     			
     			if(lstVerFlg == 'Y'){
     				btnSave.className = BTN_DISABLE;
     				btnDelete.className = BTN_ENABLE;
     				btnVersionUp.className = BTN_ENABLE;
     	 		} else {
     	 			btnSave.className = BTN_DISABLE;
     	 			btnDelete.className = BTN_DISABLE;
     	 			btnVersionUp.className = BTN_DISABLE;
     	 		}	
     			
    		 	break;
    	
    		case "V": 
    		 	btnRetrieve.className = BTN_ENABLE;
    		 	btnNew.className = BTN_ENABLE;
    		 	btnSave.className = BTN_ENABLE;
     	 		btnDelete.className = BTN_DISABLE;
    		 	btnVersionUp.className = BTN_DISABLE;
    		 	break;
    		 	
    		case "G":
				btnRetrieve.className = BTN_ENABLE;
				btnNew.className = BTN_ENABLE;
				btnSave.className = BTN_ENABLE;
				btnDelete.className = BTN_DISABLE;
				btnVersionUp.className = BTN_DISABLE;
				break;
    	}
     	tRoleApply();
    }
          
    /**
     * Form Control 의 활성/비활성을 설정한다. <br>
     * @param  {object} formObj	필수
     * @param  {boolean} bEnable	필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */ 
    function setFormControlEnable(formObj, bEnable){
    	with(formObj){
    		
    		// 입력 불가 항목
    		ComCgmEnableObject(vndr_lgl_eng_nm, false);
    		ComCgmEnableObject(exp_dt, false);
    		
    		ComCgmEnableObject(agmt_no, 	bEnable);
    		   
    		// 필수 입력값은 enable 이 true 일 경우 style 을  input1으로 세팅
    		if(bEnable){
    			ComCgmEnableObject(agmt_ref_no, 	bEnable, 'input1');
    			ComCgmEnableObject(agmt_dt, 		bEnable, 'input1');
    			ComCgmEnableObject(agmt_iss_ofc_cd, bEnable, 'input1');
    			ComCgmEnableObject(eff_dt, 			bEnable, 'input1');
    			ComCgmEnableObject(agmt_eff_dt, 	bEnable, 'input1');
    			ComCgmEnableObject(agmt_exp_dt, 	bEnable, 'input1');
    			ComCgmEnableObject(vndr_seq,		bEnable, 'input1');
    		} else { 
    		    ComCgmEnableObject(agmt_ref_no, 	bEnable);
    			ComCgmEnableObject(agmt_dt, 		bEnable);
    			ComCgmEnableObject(agmt_iss_ofc_cd, bEnable);
    			ComCgmEnableObject(eff_dt, 			bEnable);
    			ComCgmEnableObject(agmt_eff_dt, 	bEnable);
    			ComCgmEnableObject(agmt_exp_dt, 	bEnable);
    			ComCgmEnableObject(vndr_seq,		bEnable);
    		}
    		
    		ComCgmEnableObject(pay_term_dys,bEnable);
           
    		// 이미지 버튼 Enable
    		ComCgmEnableObject(btns_Calendar_agmtDt, 	bEnable);
    		ComCgmEnableObject(btns_Calendar_effDt, 	bEnable);
    		ComCgmEnableObject(btns_Calendar_agmt_effDt,bEnable);
    		ComCgmEnableObject(btns_Calendar_agmt_expDt,bEnable);
    		ComCgmEnableObject(btns_agmtno, bEnable);
    		ComCgmEnableObject(btns_vndr, bEnable);
    		ComCgmEnableObject(btns_office, 		bEnable);
     		 
    		// 기타 Text Box
    		ComCgmEnableObject(onh_hndl_rt_amt, bEnable);
    		ComCgmEnableObject(offh_hndl_rt_amt,bEnable);
    		ComCgmEnableObject(mon_dpc_rt_amt, 	bEnable);
    		ComCgmEnableObject(max_dpc_rt_amt, 	bEnable);
    		ComCgmEnableObject(init_dpc_rt_amt, bEnable);
    		
    		ComCgmEnableObject(onh_init_val_amt_clg, 	 bEnable);
    		ComCgmEnableObject(onh_init_val_amt_umg, 	 bEnable);
    		ComCgmEnableObject(mgst_potc_scg_rt_amt_clg, bEnable);
    		ComCgmEnableObject(mgst_prtc_scg_rt_amt_clg, bEnable);
    		ComCgmEnableObject(mgst_potc_scg_rt_amt_umg, bEnable);
    		ComCgmEnableObject(mgst_prtc_scg_rt_amt_umg, bEnable);
    		ComCgmEnableObject(mgst_bldp_rt_amt_clg,	 bEnable);
    		ComCgmEnableObject(mgst_lse_fx_rt_amt_clg, 	 bEnable);
    		ComCgmEnableObject(mgst_bldp_rt_amt_umg, 	 bEnable);
    		ComCgmEnableObject(mgst_lse_fx_rt_amt_umg, 	 bEnable);
    		
    		if(bEnable){
	   			 ComCgmEnableObject(diff_rmk, bEnable);
	   		} else {
	   			 ComCgmEnableObject(diff_rmk, bEnable);
	   		}
     		 
    		// MultiCombo Enable
    		comboObjects[1].Enable = bEnable;
     		
    	}
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {int} sheetNo		필수 시트오브젝트 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김창식
     * @version 2009.05.28
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
  		var sheetID = sheetObj.id;
          
  		switch(sheetID) {
          	
            case "sheet1":
                with (sheetObj) {
                	// 높이 설정
                    style.height =82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

					var HeadTitle = "|";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]   
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                 
					CountPosition = 0;
                }
                 
                break; 
                
            case "sheet2":
                with (sheetObj) {
                	// 높이 설정
                    style.height =82;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 1, 100);

					var HeadTitle = "|";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]   
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                 
					CountPosition = 0;
                }
                 
                break; 
        }
    }
     
    /**
     * Sheet관련 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01)
     * @return 없음
     * @author 김창식
     * @version 2009.05.28
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:      //조회
	            formObj.f_cmd.value = SEARCH;
	     		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
        	    sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
	     		var sXml = sheetObj.GetSearchXml("EES_CGM_2021GS.do" , FormQueryString(formObj), '', true);
	     		ComOpenWait(false); 
	     		// Sheet Object 1
	     		sheetObj.LoadSearchXml(sXml);
         		
         		// ETC DATA 값을  FORM OBJECT 에 세팅
         		setEtcDataToForm(formObj, sheetObj);
         		
         		// 전체 데이터 건수를 가져온다.
         		var dataCount = ComGetTotalRows(sXml);
         		
         		if(dataCount != null && dataCount > 0){
         		
         			// Agreement Version Multi Combo 설정
	         		var cols = ComCgmXml2ComboString(sXml, "agmt_ver_no", "agmt_ver_no");
		         	ComCgmMakeMultiCombo(comboObjects[0], cols[0], cols[1], 0);
		         	comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
		         	
		         	return true;
         		} else {
         			ComShowCodeMessage('CGM10004', 'Agreement No.');
         			return false;
         		}
                break;

 			case IBSAVE:        //저장
 			
 				formObj.f_cmd.value = MULTI;
     			formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;

     			var sParam = FormQueryString(formObj);;
     			sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
		 	    
     			var sXml = sheetObj.GetSaveXml("EES_CGM_2021GS.do", sParam);
     			ComOpenWait(false);
     			if(formObj.action_flag.value == "N"){
     				
     				formObj.agmt_no.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_no"));
         			formObj.agmt_ofc_cty_cd.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ofc_cty_cd"));
         			formObj.agmt_seq.value = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_seq"));
         			formObj.lst_ver_flg.value = ComCgmNullToBlank(ComGetEtcData(sXml, "lst_ver_flg"));

         			// Version 정보를 MultiCombo 에 세팅
         			var agmtVerNo = ComCgmNullToBlank(ComGetEtcData(sXml, "agmt_ver_no"));
         			comboObjects[0].InsertItem(0,agmtVerNo,agmtVerNo);
         			comboObjects[0].Text2 = agmtVerNo;
     			}
     			
     			sheetObj.LoadSaveXml(sXml);
               
                break;

			case IBDELETE:		// 삭제
				formObj.f_cmd.value = REMOVE;
         		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
         		sheetObj.WaitImageVisible=false;
		 	    ComOpenWait(true);
         		var sXml = sheetObj.GetSaveXml("EES_CGM_2021GS.do", FormQueryString(formObj));
         		sheetObj.LoadSaveXml(sXml);
         		ComOpenWait(false);
         		break;
 			
 			case IBSEARCH_ASYNC01:	// Term Code MultiCombo 조회
    		
	        	formObj.f_cmd.value = SEARCH;
	        	formObj.intg_cd_id.value = COM_CD_TYPE_CD01948;		// 코드Type 설정 ( AGREEMENT LEASE TERM CODE )
	    		var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	    			    			
	    		var sStr = ComGetEtcData(sXml,"comboList");    			
	    		var arrStr = sStr.split("@");
	    			
	    		// combo control, 결과 문자열, Text Index, Code Index
	   			MakeComboObject(formObj.agmt_lstm_cd, arrStr, 0, 0);
	        	break;
	       
 			case IBSEARCH_ASYNC02:	// Vendor Code,Name 조회
	        	formObj.f_cmd.value = SEARCH07;
	        	var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do", FormQueryString(formObj), '', true);
	        	var text = ComGetEtcData(sXml,"text");
	        	var genPayTermCd = ComGetEtcData(sXml,"gen_pay_term_cd");
	        	
	        	for(var i=0; i<genPayTermCd.length; i++){
	        		if(genPayTermCd.charCodeAt(i) < 48 || genPayTermCd.charCodeAt(i) > 57){
	        			genPayTermCd = "0";
	        			break;
	        		}
	        	}
	        	if(text ==""){
	        		formObj.vndr_seq.value = "";
	        	}
	        	
	        	formObj.vndr_lgl_eng_nm.value = text;
	        	formObj.pay_term_dys.value = genPayTermCd;
	        	break;		
	        	
 			case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
	        	formObj.f_cmd.value = COMMAND01;
	        	formObj.ofc_cd.value = formObj.agmt_iss_ofc_cd.value;
	        	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj), '', true);
	        	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
	        	
	        	if(sCheckResult == COM_VALIDATION_FALSE){
	        		ComShowCodeMessage('CGM10009','Office');
	        		formObj.agmt_iss_ofc_cd.value = "";
	        		ComSetFocus(formObj.agmt_iss_ofc_cd);
	        	}
	        	
	        	break;
 			case IBRESET:
    	 		var idx = 0
    	 		var sXml2 = document.form2.sXml.value;
    	 		var arrXml = sXml2.split("|$$|");
    	
    	 		//agmt_lstm_cd
    	 		if ( arrXml[idx] == null ) {return;}
    	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
    	 	    var arrStr1 = new Array();
    	 		for ( var i = 0; i < vArrayListData.length; i++) {
    	 		    vListData = vArrayListData[i];
    	 		    arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
    	 		}
    	 		// combo control, 결과 문자열, Text Index, Code Index
    		  	MakeComboObject(formObj.agmt_lstm_cd, arrStr1, 0, 0);     
    	 		idx++;       
    	 		
    	 		 
    	  	  	
    	 		break;
        }
    }

     /**
      * ETC 데이터를 Form Tag 에 설정한다. <br>
      * @param  {object} formObj	 필수
      * @param  {object} sheetObj 필수
      * @return 없음
      * @author 김창식
      * @version 2009.06.09
      */
    function setEtcDataToForm(formObj, sheetObj){
     	
    	formObj.eq_knd_cd.value 		= ComCgmNullToBlank(sheetObj.EtcData("eq_knd_cd"));
    	formObj.agmt_ofc_cty_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_ofc_cty_cd"));
  		formObj.agmt_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_seq"));
  		formObj.lst_ver_flg.value 		= ComCgmNullToBlank(sheetObj.EtcData("lst_ver_flg"));
  		
  		formObj.agmt_no.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_no"));
  		formObj.agmt_ref_no.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_ref_no"));
  		formObj.agmt_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("agmt_dt"));
  		formObj.agmt_iss_ofc_cd.value 	= ComCgmNullToBlank(sheetObj.EtcData("agmt_iss_ofc_cd"));
		formObj.gw_uq_doc_tit_nm.value	= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_tit_nm"));
		formObj.gw_uq_doc_no.value		= ComCgmNullToBlank(sheetObj.EtcData("gw_uq_doc_no"));
  		formObj.eff_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("eff_dt"));
  		formObj.exp_dt.value 			= ComCgmNullToBlank(sheetObj.EtcData("exp_dt"));
  		formObj.agmt_eff_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_eff_dt"));
  		formObj.agmt_exp_dt.value 		= ComCgmNullToBlank(sheetObj.EtcData("agmt_exp_dt"));
  		formObj.vndr_seq.value 			= ComCgmNullToBlank(sheetObj.EtcData("vndr_seq"));
  		formObj.vndr_lgl_eng_nm.value 	= ComCgmNullToBlank(sheetObj.EtcData("vndr_lgl_eng_nm"));
  		formObj.pay_term_dys.value 		= ComCgmNullToBlank(sheetObj.EtcData("pay_term_dys"));
  		
  		formObj.onh_hndl_rt_amt.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("onh_hndl_rt_amt"))).toFixed(2);
  		formObj.offh_hndl_rt_amt.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("offh_hndl_rt_amt"))).toFixed(2);
  		formObj.mon_dpc_rt_amt.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mon_dpc_rt_amt"))).toFixed(2);
  		formObj.max_dpc_rt_amt.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("max_dpc_rt_amt"))).toFixed(2);
  		formObj.init_dpc_rt_amt.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("init_dpc_rt_amt"))).toFixed(2);
  		formObj.diff_rmk.value 			= ComCgmNullToBlank(sheetObj.EtcData("diff_rmk"));
    	
   		comboObjects[0].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_ver_no"));
   		comboObjects[1].Text2 = ComCgmNullToBlank(sheetObj.EtcData("agmt_lstm_cd"));
   		
   		formObj.onh_init_val_amt_clg.value 		= parseFloat(ComCgmNullToZero(sheetObj.EtcData("onh_init_val_amt_clg"))).toFixed(2);
   		formObj.mgst_potc_scg_rt_amt_clg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_potc_scg_rt_amt_clg"))).toFixed(2);
   		formObj.mgst_prtc_scg_rt_amt_clg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_prtc_scg_rt_amt_clg"))).toFixed(2);
   		formObj.mgst_bldp_rt_amt_clg.value 		= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_bldp_rt_amt_clg"))).toFixed(2);
   		formObj.mgst_lse_fx_rt_amt_clg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_lse_fx_rt_amt_clg"))).toFixed(2);
        
   		formObj.onh_init_val_amt_umg.value 		= parseFloat(ComCgmNullToZero(sheetObj.EtcData("onh_init_val_amt_umg"))).toFixed(2);
   		formObj.mgst_potc_scg_rt_amt_umg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_potc_scg_rt_amt_umg"))).toFixed(2);
   		formObj.mgst_prtc_scg_rt_amt_umg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_prtc_scg_rt_amt_umg"))).toFixed(2);
   		formObj.mgst_bldp_rt_amt_umg.value 		= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_bldp_rt_amt_umg"))).toFixed(2);
   		formObj.mgst_lse_fx_rt_amt_umg.value 	= parseFloat(ComCgmNullToZero(sheetObj.EtcData("mgst_lse_fx_rt_amt_umg"))).toFixed(2);	 
    }


    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Rental Rate" , -1 );
                    InsertTab( cnt++ , "Depr. For Casualty Value" , -1 );
                    InsertTab( cnt++ , "Surcharge" , -1 );
                }
              
                break;
        }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

     	objs[nItem].style.display = "Inline";
     	objs[beforetab].style.display = "none";

     	//--------------- 요기가 중요 --------------------------//
     	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	//------------------------------------------------------//
     	beforetab= nItem;
 
    }
    
    /** 
     * Combo Object 초기화  <br>
     * @param  {object} comboObj	필수 Combo Object
     * @return 없음
     * @author 김창식
     * @version 2009.06.15
     */ 
    function initCombo(comboObj) {
    	switch(comboObj.id) {
	    	case "agmt_ver_no":
	 	 		var cnt=0;
	  	        with(comboObj) {
	  	        	Code = "";
	  	            Text = "";
	  	            DropHeight = 100;
	  	            MultiSelect = false;
	  	            MaxSelect = 1;	    
	  	            UseCode = true;
	  	            Enable = true;
	  	        }
	  	        
	  	        break;
  	        
    	 	case "agmt_lstm_cd":
    	 		var cnt=0;
     	        with(comboObj) {
     	        	Code = "";
     	            Text = "";
     	            DropHeight = 100;
     	            MultiSelect = false;
     	            MaxSelect = 1;	    
     	            UseCode = true;
     	            Enable = true;
     	            comboObj.UseAutoComplete = true;
     	        }
     	        
     	        break;
    	}
    }  

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * @param  {object} sheetObj	필수	 Sheet Object
     * @param  {object} formObj	필수 Form Object
     * @param  {String} sAction	필수 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
     * @return {boolean}			false => validation 체크 오류, true => validation 체크 성공
     * @author 김창식
     * @version 2009.05.28
     */   
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
        	switch(sAction){
        	 	case IBSEARCH:	// 조회
        	 		if(agmt_no.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement No.');
        	 			agmt_no.focus();
        	 			return false;
                    } else {
                    	return true;
                    }
        	 		break;
        	 	
        	 	case IBSAVE:	// 저장
    	 			var combo_agmt_lstm_cd = comboObjects[1];
    	 			var sheet;
    	 		
    	 			// Form 입력 체크
    	 			if(agmt_ref_no.value == ''){
    	 				ComShowCodeMessage('CGM10004','Ref. No.');
    	 				agmt_ref_no.focus();
    	 				return false;
    	 			} else if(agmt_dt.value == ''){
    	 				ComShowCodeMessage('CGM10004','Agreement Date');
    	 				agmt_dt.focus();
    	 				return false;
    	 			} else if(agmt_iss_ofc_cd.value == ''){
    	 				ComShowCodeMessage('CGM10004','Office');
    	 				agmt_iss_ofc_cd.focus();
    	 				return false;
    	 			} else if(agmt_eff_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement Eff. From Date');
        	 			agmt_eff_dt.focus();
        	 			return false;
        	 		} else if(agmt_exp_dt.value == ''){
        	 			ComShowCodeMessage('CGM10004','Agreement Eff. To Date');
        	 			agmt_exp_dt.focus();
        	 			return false;	
    	 			} else if(eff_dt.value == ''){
    	 				ComShowCodeMessage('CGM10004','Rate Eff. From Date');
    	 				eff_dt.focus();
    	 				return false;
    	 			} else if(exp_dt.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Rate Eff. To Date');
	    	 			exp_dt.focus();
	    	 			return false;
    	 			} else if(combo_agmt_lstm_cd.Text == ''){
        	 			ComShowCodeMessage('CGM10004','Lease Term');
        	 			agmt_lstm_cd.focus();
        	 			return false;
	    	 		} else if(vndr_seq.value == ''){
	    	 			ComShowCodeMessage('CGM10004','Lessor');
	    	 			vndr_seq.focus();
	    	 			return false;
	    	 		} 
    	 			
    	 			// 신규 입력일 경우  eff_dt 와 agmt_eff_dt 가 같은지 체크한다.
        	 		var effDt = ComReplaceStr(eff_dt.value,"-","");
         			var expDt = ComReplaceStr(exp_dt.value,"-","");
         			var agmtEffDt = ComReplaceStr(agmt_eff_dt.value,"-","");
         			var agmtExpDt = ComReplaceStr(agmt_exp_dt.value,"-","");
        	 		
         			if(agmt_no.value == 'NEW'){
	         			if(effDt != agmtEffDt){
	         				ComShowCodeMessage('CGM10074');
	         				eff_dt.focus();
	         				return false
	         			}
         			}
    	 				
    	 			return true;
    	 			
    	 			break;
    	 		
        	 	case IBDELETE:	// 삭제
    	 			if(agmt_no.value == ''){
    	 				ComShowCodeMessage('CGM10004','Agreement No.');
    	 				agmt_no.focus();
    	 				return false;
    	 			} else if(agmt_ver_no.value == ''){
    	 				ComShowCodeMessage('CGM10004','Version');
    	 				agmt_ver_no.focus();
    	 				return false;
    	 			} else {
    	 				return true;
    	 			}
    	 		
    	 			break;
        	}
    	} 
    }
     
     /** 
      * Object 의 Keypress 이벤트에 대한 처리  <br>
      * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
      * @param  없음
      * @return 없음
      * @author 김창식
      * @version 2009.05.20
      */ 
    function obj_keypress(){
      	obj = event.srcElement;
      	if(obj.dataformat == null) return;
      	 	
      	window.defaultStatus = obj.dataformat;
      	
      	// 특수문자 아스키값
     	var specChar = '33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|'
     	specChar = specChar + '58|59|60|61|62|63|64|91|92|93|94|95|123|124|125|126';
      	 
      	switch(obj.dataformat) {
      	 	case "ym": case "ymd":
      	 		ComKeyOnlyNumber(obj);
      	 		break;
      	 	case "int":
      	    	ComKeyOnlyNumber(obj);
      	        break;
      	 	case "float":
 	            ComKeyOnlyNumber(obj, "-.");
 	            break;    
      	    case "eng":
      	        ComKeyOnlyAlphabet(); 
      	        break;
      	    case "engup":
      	        if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
      	        else if(obj.name=="agmt_no") ComKeyOnlyAlphabet('uppernum');
      	     	else if(obj.name=="agmt_ref_no") ComKeyOnlyAlphabet('uppernum',specChar);
      	        else ComKeyOnlyAlphabet('upper');
      	        break;
      	    case "engdn":
      	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
      	        else ComKeyOnlyAlphabet('lower');
      	        break;
      	}
    } 
      
    /** 
     * Object 의 Keydown 이벤트에 대한 처리  <br>
     * 객체가 agmt_no 일 경우에만 enter 키 발생시 조회실행.  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.19
     */ 
    function obj_keydown(){
    	obj = event.srcElement;
    	
    	switch(obj.name){
    		case 'agmt_no':
    			var keyValue = null;
            	if(event == undefined || event == null) {
            		keyValue = 13;
            	} else {
            		keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    			}
            	
    			if(keyValue != 13) return;
            	
    			var agmtNo = formObj.agmt_no.value;
    	 		var result = true;
    	 		
    	 		if(agmtNo != "" && agmtNo != "NEW"){
    	 			if(agmtNo.length <= 3){
	    	 			result = false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result = false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result = true;
    	 		}
    	 		
    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.agmt_no.value="";
    	 			ComSetFocus(formObj.agmt_no);
    	 		} else {
    	 			ComKeyEnter();
    	 		}
    	 		
    			break;
    	}
    }      
    
    /** 
     * Object 의 activate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_activate(){
     	ComClearSeparator(event.srcElement);
    }
    
    /** 
     * Object 의 deactivate 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */
    function obj_deactivate(){
     	var formObj = document.form;
     	obj = event.srcElement;      	
     	 
     	with(formObj){
     		if(obj.name=='agmt_dt' || obj.name=="eff_dt" || obj.name=="exp_dt" || obj.name=="agmt_eff_dt" || obj.name=="agmt_exp_dt"){
     			var effDt = ComReplaceStr(eff_dt.value,"-","");
     			var expDt = ComReplaceStr(exp_dt.value,"-","");
     			var preEffDt = ComReplaceStr(pre_eff_dt.value,"-","");
     			var preExpDt = ComReplaceStr(pre_exp_dt.value,"-","");
     			var agmtEffDt = ComReplaceStr(agmt_eff_dt.value,"-","");
     			var agmtExpDt = ComReplaceStr(agmt_exp_dt.value,"-","");
     			var preAgmtExpDt = ComReplaceStr(pre_agmt_exp_dt.value,"-","");
 	        	
     			switch(obj.name) {
 	    	    	case "eff_dt":	// Agreement From Date
 	    	    		if(effDt != '' && expDt != ''){
 	    	    			if(effDt > expDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				eff_dt.value='';
 	    	    				eff_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    	
 	    	    		if(effDt != "" && preExpDt != ""){
 	    	    			var nextEffDt = ComReplaceStr(ComGetDateAdd(pre_exp_dt.value,"D","1"),"-","");
 	    	    			
 	    	    			if(effDt <= preExpDt && effDt <= preEffDt){
 	    	    				ComShowCodeMessage('COM12133','From date', pre_eff_dt.value,'greater');
	    	    				eff_dt.value='';
	 	    	    			eff_dt.focus();
 	    	    			} else if(effDt > nextEffDt){
 	    	    				ComShowCodeMessage('CGM10032');
 	    	    				eff_dt.value = nextEffDt;
	 	    	    			exp_dt.focus();
 	    	    			}
 	    	    		}
 	    	    			
 	    	            break;
 	    	            
 	    	    	case "exp_dt":	// Agreement To Date
 	    	    		if(effDt != '' && expDt != ''){
 	    	    			if(effDt > expDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				exp_dt.value='';
 	    	    				exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    	
 	    	           	break;	
 	    	           	
 	    	    	case "agmt_eff_dt":
 	    	    		if(agmtEffDt != '' && agmtExpDt != ''){
 	    	    			if(agmtEffDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				agmt_eff_dt.value='';
 	    	    				agmt_eff_dt.focus();
 	    	    			}
 	    	    		}
 	    	    		break;
 	    	    		
 	    	    	case "agmt_exp_dt":
 	    	    		if(agmtEffDt != '' && agmtExpDt != ''){
 	    	    			if(agmtEffDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
 	    	    				agmt_exp_dt.value='';
 	    	    				agmt_exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    		
 	    	    		if(preAgmtExpDt!= '' && agmtExpDt != ''){
 	    	    			if(preAgmtExpDt > agmtExpDt){
 	    	    				ComShowCodeMessage('COM12133','Agreement Exp. Date', pre_agmt_exp_dt.value,'greater');
 	    	    				agmt_exp_dt.value= pre_agmt_exp_dt.value;
 	    	    				exp_dt.value= pre_agmt_exp_dt.value;
 	    	    				agmt_exp_dt.focus();
 	    	    				break;
 	    	    			}
 	    	    		}
 	    	    		
 	    	    		if(agmt_exp_dt.value != ''){
 	    	    			exp_dt.value = agmt_exp_dt.value.substring(0,4) + '-' + agmt_exp_dt.value.substring(4,6) + '-' + agmt_exp_dt.value.substring(6,8);
 	    	    		} else {
 	    	    			exp_dt.value = '';
 	    	    		}
 	    	    		break;
 	    	    		
 	        	} // switch 문 End
 	        	
 	        	
 	       
     		} // if End
        } // with
     	
     	if(obj.dataformat == 'ymd' || obj.dataformat == 'ym' || obj.dataformat == 'float'){
     		ComChkObjValid2(event.srcElement);
     	}
    }  
    
     function ComChkObjValid2(obj, bMsg, bTrim, bMasked){

         try {
             var sTitle  = "";
             var sMsg    = "";
             //다음 배열은 순서가 중요함
             var props   = new Array("required", "dataformat", "maxLength", "minlength", "fullfill", "maxnum", "minnum", "pointcount", "cofield");

             if (bMsg==undefined || bMsg==null)            bMsg = true;
             if (bTrim==undefined || bTrim==null)          bTrim = true;
             if (bMasked==undefined || bMasked==null)      bMasked = true;

             var sFormat     = "";
             var sVal        = "";
             var maskValue   = "";
             var iMaxLen=0, iMaxVal=null, iMinVal=null;

             sVal = ComGetObjValue(obj)
             if (obj.type=="radio") {
                 if (obj.name == null || obj.name=="") return true;
                 //radio의 경우 radio의 첫번째 요소를 Object로 설정한다.
                 var eRadio = document.all[obj.name];
                 obj=eRadio[0];
             }else if(obj.type == undefined && obj.length != undefined && obj[0].type == "radio") {
                 //radio의 경우 radio의 첫번째 요소를 Object로 설정한다.
                 obj = obj[0];
             }

             sTitle = (obj.getAttribute("caption")==null)?obj.name:obj.getAttribute("caption");


             if(bTrim) sVal = ComTrim(sVal);
             maskValue = sVal;

             //체크할 속성 확인하기
             for(var j=0; j<props.length; j++){
 	
                 var attriVal = obj.getAttribute(props[j]);
                  
                 if (attriVal == null) continue;

                 switch(props[j]) {
                     case "required":    //필수 입력 확인
                         if(sVal==""){
                         	sMsg = "'" + sTitle + "' " +Msg_Required;
                         	j = 99;
                         }
                         break;
                     case "dataformat":  //포멧 확인
                         sFormat = attriVal;
 		                //루프를 돌다가 "dataformat"을 지나게 되면 그때부터는 마스크구분자 없는 값으로 다른 Validation(길이,min,max 등)을 확인한다.
 		                if (sFormat!="") sVal = ComGetUnMaskedValue(sVal, sFormat);

                         if (sVal== "") continue;

                         //마스크값도 가져오지만 포멧Validation도 ComGetMaskedValue 함수에서 체크한다.
                         maskValue = ComGetMaskedValue(obj, sFormat);

                         if (sVal != maskValue && sFormat.indexOf("eng")>=0) obj.value = maskValue;
  
                         if (maskValue!= "") continue;
                         switch(sFormat) {
                            
                             case "float":   //실수
                                 sMsg = "'" + sTitle + "' is not valid. Please enter a correct float(real type) format.";
                             	j=99;    
                             	break; 
                            
                         }
                         break;
                     case "maxLength":   //입력최대길이 확인
                         if (sVal== "") continue;
                         iMaxLen = attriVal;
                         if(ComGetLenByByte(sVal) > iMaxLen){
                         	sMsg = ComGetMsg('COM12142', sTitle, attriVal);
                         	j=99;
                         }
                         break;
                     case "minlength":   //입력최소길이 확인
                         if (sVal== "") continue;
                         if(ComGetLenByByte(sVal) < attriVal) {
                         	sMsg = ComGetMsg('COM12143', sTitle, attriVal);
                         	j=99;
                         }
                         break;
                     case "fullfill":    //전체입력 확인
                         if (sVal== "") continue;
                         if(ComGetLenByByte(sVal) != iMaxLen) {
                         	sMsg = ComGetMsg('COM12174', sTitle, iMaxLen);
                         	j=99;
                         }
                         break;
                     case "maxnum":      //최대값 확인
                     	iMaxVal = attriVal;
                         if (sVal== "") continue;
                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg = ComGetMsg('COM12178');
                         	j=99;
                         } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                             sMsg = "is not valid. Please enter an correct number format. maxnum=" + attriVal;
                         	j=99;
                         } else if (parseFloat(sVal) > parseFloat(attriVal)) {
                             sMsg = "'" + sTitle + "' have to be less than " + attriVal;
                         	j=99;
                         }
                         break;
                     case "minnum":      //최소값 확인
                     	iMinVal = attriVal;
                         if (sVal== "") continue;
                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg = ComGetMsg('COM12178');
                         	j=99;
                         } else if(!ComIsMoneyNumber(attriVal, true, false, false)) {
                             sMsg = "is not valid. Please enter an correct number format. minnum=" + attriVal;
                         	j=99;
                        } else if (parseFloat(sVal) < parseFloat(attriVal)) {
                             sMsg = "'" + sTitle + "' have to be greater than " + attriVal;
                         	j=99;
                         }
                         break;
                     case "pointcount":	//소숫점 아랫자리수 확인
                         if (sVal== "") continue;

                         if (!ComIsMoneyNumber(sVal, true, true, true)) {
                             sMsg = ComGetMsg('COM12178');
                         	j=99;
                         } else if(!ComIsMoneyNumber(attriVal, false, false, false)) {
                             sMsg = "is not valid. Please enter an correct number format. pointcount=" + attriVal;
                         	j=99;
                         } else {
 	                        var iLeftLen = iMaxLen-attriVal-1;
                         	var iNum = sVal;
 	                        var iPointNum = 0;
 	                        
                         	if(sVal.indexOf(".") >= 0) {
 	                        	iNum = sVal.split(".")[0];		//소숫점 윗자리값
 		                        iPointNum = sVal.split(".")[1];	//소숫점 아랫자리값
                         	}
                         	
                         	if (iPointNum.length > attriVal) {
                         		//소숫점 아래 자리수가 너무 많은 경우
                                 sMsg = "'" + sTitle + "' is not valid decimal point. Please enter a maximum " + attriVal + " decimal point";
                             	j=99;
                             } else if (iMaxLen<100 && iLeftLen>0) {
                             	//"iMaxLen<100" 이조건 반드시 필요함. 
                             	//maxLength속성을 설정하지 않으면 기본적으로 2147483647로 설정되므로 너무 커서 메모리 오류 발생함

                             	//iMaxVal은 "maxnum"속성을 읽어서 미리 설정된 값이고, iMinVal은 "minnum"속성을 읽어서 미리 설정된 값임
                             	//만약 두개 속성중 하나라도 없었다면 다음 코드를 통해서 체크한다.
                             	if (iMaxVal==null) iMaxVal = eval(ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                             	if (iMinVal==null) iMinVal = eval("-" + ComLpad("9",iLeftLen,"9") + "." + ComLpad("9",attriVal,"9"));
                         		//소숫점 윗 자리수가 너무 많거나 작은 경우 & 사용자정의속성인 maxnum과 minnum이 없는 경우
 	                        	if (parseFloat(iNum) > parseFloat(iMaxVal)) {
 	                                sMsg = "'" + sTitle + "' have to be less than " +iMaxVal;
 	                            	j=99;
 	                        	} else if(parseFloat(iNum) < parseFloat(iMinVal)) {
 	                                sMsg = "'" + sTitle + "' have to be greater than " +iMinVal;
 	                            	j=99;
 		                        }
                             }
                         }
                     	break;
                     case "cofield":      //기간확인
                         switch(sFormat) {
                             case "ymd":     //yyyy-mm-dd
                             case "ymdhms":     //yyyy-mm-dd
                             case "ymdhm":     //yyyy-mm-dd
                             case "ym":      //yyyy-mm
                             case "yw":      //yyyy-ww
                             case "yyyy":      //yyyy   
                             case "hms":     //hh:mm:ss
                             case "hm":      //hh:mm
                                 var coObj = eval("document.all." + attriVal);
                                 var coVal =  ComGetObjValue(coObj);
                                 if (coVal != "" && sVal == "")          //현재Obj는 값이 없고, CoObj만 값이 있는 경우
                                     obj.value = coVal;
                                 else if (coVal == "" && sVal != "")     //현재Obj는 값이 있고, CoObj만 값이 없는 경우
                                     coObj.value = maskValue;
                                 else {  //둘다 있는 경우
 	                                var startDate, endDate;
 	                                //sourceIndex속성은 obj의 document.all의 순번임, 
 	                                //따라서 sourceIndex속성값이 작으면 시작일이고, 크면 종료일이다.
 	                                if (obj.sourceIndex < coObj.sourceIndex) {
 	                                	startDate=maskValue;
 	                                	endDate = coVal;
 	                                } else {
 	                                	startDate=coVal;
 	                                	endDate = maskValue;
 	                                }
 	                                
 	                                //기간체크
 	                                if (startDate > endDate && !CofieldFlag) {
 	                                	if (obj.sourceIndex < coObj.sourceIndex){
 		                                	CofieldFlag = true;
 		                                	sTitle2 = (coObj.getAttribute("caption")==null)?"end date":coObj.getAttribute("caption");
 	                                		sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "earlier");
 	                                	} else {
 		                                	CofieldFlag = false;
 		                                	sTitle2 = (coObj.getAttribute("caption")==null)?"start date":coObj.getAttribute("caption");
                                 			sMsg=ComGetMsg("COM12133", "'" + sTitle+ "'", "'" + sTitle2 + "'", "later");
 	                                	}
 	                                	j=99;
 	                                }else
 	                                	CofieldFlag = false;
                                 }
                                 break;
                         }
                         break;
                 }

                 if (sMsg!="") {
                 	if(event == null){
                 	 
                 		if (bMsg) ComShowMessage(sMsg);
                 		 
  		                obj.focus(); 
 		                obj.select(); 
                 	}else{
                 	//포커스 나갈수 있는 경우 : 이벤트를 통해서 함수가 호출되고, 값이 공백이거나 readonly인 경우
                 	
 	                	var canFocusOut = (event.srcElement == obj && (sVal=="" || obj.getAttribute("readOnly")==true));
 	                	
 	                    if (bMsg && !canFocusOut) ComShowMessage(sMsg);
 	
 	                    //컨트롤이 숨겨져 있을수도 있으므로 에러 감싼다.
 	                    try{                     	
 	                    	if(canFocusOut) {
 	                    		event.returnValue = true;
 	                    	} else {
 	                			//값이 정확할때 까지 포커스가 나가지 않아야 하는 경우
// 		                    	event.cancelBubble = true;
 	                			if(pastEventNum == 0){
 	                				pastEventNum = 1;
 	                				pastEventObj = event.srcElement.name;
 	                			}else if(pastEventNum ==1){
 	                				pastEventNum = 2;
 	                			}else{
 	                				pastEventNum =0;
 	                				if(pastEventObj == event.srcElement.name)
 	                					event.stopPropagation();
 	                			}
 		                    	event.returnValue = false;
 		                    	obj.value ="0";
 		                    	obj.focus(); 
 		                    	obj.select(); 
 		                    	event.stopPropagation( );
 		                    }
 	
 	                    } catch(ee) {;}
 	                }
                     return false;
                 }
             }

             if (bMasked && sFormat != "") {
                 obj.value = ComGetMaskedValue(obj, sFormat);
             }
         } catch(err) { ComFuncErrMsg(err.message); }
         
         return true;
     }

     /** 
     * Object 의 change 이벤트에 대한 처리  <br>
     * @param  없음
     * @return 없음
     * @author 김창식
     * @version 2009.06.03
     */  
    function obj_change(){ 	 
    	var formObj = document.form;
    	var sheetObj = sheetObjects[0];
    	 
    	obj = event.srcElement;
    	switch(obj.name){
    	 	case "agmt_no":
    	 		var agmtNo = formObj.agmt_no.value;
    	 		var result = true;
    	 		
    	 		if(agmtNo != "" && agmtNo != "NEW"){
    	 			if(agmtNo.length <= 3){
	    	 			result = false;
	    	 		} else {
	    	 			if(ComIsNumber(agmtNo.substring(3))==false){
	    	 				result = false;
	    	 			}
	    	 		}
    	 		} else {
    	 			result = true;
    	 		}
    	 		
    	 		if(!result){
    	 			ComShowCodeMessage('CGM10004','Agreement No.');
    	 			formObj.agmt_no.value="";
    	 			ComSetFocus(formObj.agmt_no);
    	 		}
    	 		
    	 		// 버튼 활성/비활성
    	 		if(formObj.action_flag.value == "N"){
    	 			
    	 			if(agmtNo != "NEW"){
    	 				doActionBtnEnable('L');
    	 			}
    	 			
    	 		}
    	 		
    	 		break;
    	 
    	 	case "vndr_seq":
    	 		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
    	 		
    	 		if(vndrSeq != ''){
    	 			// Lessor 명칭 가져오기
	    	 		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 		} else {
    	 			// vndr_seq 입력 텍스트에서 삭제할 경우 Lessor 명칭을 삭제
    	 			formObj.vndr_lgl_eng_nm.value = "";
    	 			formObj.pay_term_dys.value = "";
    	 		}
    	 		
    	 		break;
    	 		
    	 	case "agmt_iss_ofc_cd":
    	 		if(formObj.agmt_iss_ofc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
    	 		}
    	 		break;
    	 		
    	 	case "pay_term_dys":
    	 		
    	 		if(formObj.pay_term_dys.value !=''){
    	 			formObj.pay_term_dys.value = Math.abs(formObj.pay_term_dys.value)
    	 		}
    	 		
    	 		break;
    	 
    	}
    }  
     
    /**
  	 * Sheet1 의 OnSaveEnd 이벤트처리 (저장)<br>
  	 * @param  {object} sheetObj	필수	 Sheet Object
  	 * @param  {string} ErrMsg		필수 String
  	 * @return 없음
  	 * @version 2009.10.07
  	 */ 
  	function sheet1_OnSaveEnd(sheetObj, errMsg) {
  		
  		var formObject = document.form;
  		
  		if(errMsg =='') {   
  			ComShowCodeMessage('CGM00003');
  			
  			// 조회
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				
			// Form Control 활성/비활성 처리
			doControlEnable("btn_Retrieve");
				
			// 버튼 활성/비활성 처리
	    	doActionBtnEnable('R');
  		}
  	}    
  	 
  	/**
   	 * Sheet2 의 OnSaveEnd 이벤트처리 (삭제) <br>
   	 * @param  {object} sheetObj	필수	 Sheet Object
   	 * @param  {string} ErrMsg		필수 String
   	 * @return 없음
   	 * @version 2009.10.07
   	 */ 
   	function sheet2_OnSaveEnd(sheetObj, errMsg) {
   		
   		var formObject = document.form;
   		
   		if(errMsg =='') {  
   			ComShowCodeMessage('CGM00003');
   			
   			if(comboObjects[0].GetCount() > 1){
   				// 조회
				comboObjects[0].Text2 = "";
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
					
				// Form Control Enable 설정
				doControlEnable("btn_Retrieve");
					
				// 버튼 활성/비활성 처리
		    	doActionBtnEnable('R');
					
			} else {
				
				//Form Control 초기화
				initControl();
					
				// Form Control Enable 설정
				doControlEnable("btn_New");

				// 버튼 활성/비활성 처리
				doActionBtnEnable('L');
			}
   		}
   	}      	 
     
    /**
     * Agreement Version No 의 Change 이벤트를 정의한다. <br>
     * @param  {string} Index_Code 필수
     * @param  {string} Text 필수
     * @return 없음
     * @author 김창식
     * @version 2009.06.09
     */
    function agmt_ver_no_OnChange(Index_Code, Text){
    	var obj = document.getElementById("btn_Retrieve");
     	obj.fireEvent("onclick");
    } 

    /** 
     * Combo Object 에 값을 추가하는 처리 <br>
     * @param  {object} cmbObj	필수 Combo Object
     * @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
     * @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
     * @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
     * @return 없음
     * @author 김창식
     * @version 2009.05.20
     */ 
    function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
      	cmbObj.RemoveAll();
      	cmbObj.InsertItem(0,"","");
      	for (var i = 0; i < arrStr.length;i++ ) {
      		var arrCode = arrStr[i].split("|");
      		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
      	}
      	cmbObj.Index2 = "" ;
    } 
     
 /**
  * 기능(ex:btn_save)에 권한(trole) 적용  <br>
  * @param  없음
  * @return 없음
  * @author 조재성
  * @version 2010.03.05
  */     
  function tRoleApply() {
	  var formObj = document.form;
	  if(formObj.trole.value == "Authenticated")
	  {

	  }else
	  {
		  ComBtnDisable("btn_Delete");
		  ComBtnDisable("btn_Save");
		  ComBtnDisable("btn_VersionUp");
		  
		  // 1020은 자체적으로 en/disable시키는 함수가 있다. 따라서 아래를 강제적으로 적용해주어야 함.
	      var btnSave 	  = document.getElementById("btn_Save");
	      var btnDelete    = document.getElementById("btn_Delete");
	      var btnVersionUp = document.getElementById("btn_VersionUp");
		  btnSave.className = BTN_DISABLE;
		  btnDelete.className = BTN_DISABLE;
		  btnVersionUp.className = BTN_DISABLE;
	  }
  }      
	/* 개발자 작업  끝 */