/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_0063.js
*@FileTitle : Uncollected Cargo Creation (New Van)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.02
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2014.07.02 김현주
* 1.0 Creation
* 
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
	 * @class EES_CIM_0063 : EES_CIM8_0063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CIM_0063() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.doActionIBCombo 		= doActionIBCombo;
    	this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	//공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// tab 관련
	var beforetab = 1;
	var openTabIndex = 0;
	
	// Del seq 처리변수
	var ucCsNo = ""; //UC Case No
	var ucSeq = ""; //Sequence select
	var ucSeqTtl = ""; //Sequence selected		
	var delSeqFlag = false;
	
	// 권한 변수
	var isauthority="";
	var isoffcd="";
	var authorityKey="";
			
	
	
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
	document.onclick = processButtonClick;
	
    var controlHidden = false;
    
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function processButtonClick(){
		var formObj = document.form;
		var strAuthority = formObj.auth_cd.value;
		var strMode = getOperationMode();
		var strTmp;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {						
				case "btn_retrieve"://조회버튼										
					strTmp = formObj.bl_no.value;	// 조회 전 bl_no 백업
					
					if(doActionIBSheet(sheetObjects[0],formObj,IBSEARCH)){
						formObj.search_flg.checked = false;
						setAuthority();
						setSearchMode(formObj.search_flg.checked);
						setAddSequenceMode(true);
						
						//Key 값 보존
						formObj.uc_cs_no.readOnly = true;
						formObj.bl_no.readOnly = true;
						formObj.cnee_uc_dt.readOnly = true;
						
						
						// 조회한 b/l no로 설정
						if (strTmp != "") formObj.bl_no_lst.Text = strTmp;
						
						// reopen enable/disable
						formObj.chk_uc_ropn_flg.checked = false;
						if ( formObj.auth_cd.value == "O" && (formObj.uc_sts_cd.Code == "CL"||formObj.uc_sts_cd.Code == "CN" )){
							formObj.chk_uc_ropn_flg.disabled = false;
						} else {
							formObj.chk_uc_ropn_flg.disabled = true;
						}
						
						//조회후 권한에 대한 화면설정을 다시한다.
						authorityUiControl();						
					} else {
						formObj.uc_cs_no.readOnly = false;
						formObj.bl_no.readOnly = false;
						formObj.cnee_uc_dt.readOnly = false;
					}										
					break;
				case "btn_add_seq":
					// Authority 에 따른 제한
	            	if (!validateAuthority(strAuthority, strMode, srcName)) {
	            		break;
	            	}
					
					//조회 된 값이 없으면 Sequence 증가하지 않는다.
					if (formObj.uc_seq.GetCount() == 0) {
						break;
					}
					
					ucCsNo = formObj.uc_cs_no.value; //UC Case No
					ucSeq = formObj.uc_seq.index; //Sequence select
					ucSeqTtl = formObj.uc_seq_ttl.value; //Sequence selected							

					//버튼 Sequence를 증가 시킨다.
					var cboVal = formObj.uc_seq.GetCount() + 1;
					formObj.uc_seq.InsertItem(-1, cboVal);
					formObj.uc_seq.Index2 = cboVal*1 - 1;
					formObj.uc_seq_ttl.value = cboVal;
					formObj.bl_no_lst.Index2 = -1;
					
					//Add SEeq 버튼관련 비활성화
					setAddSequenceMode(false); 
					formObj.bl_no.readOnly = false;
					
					// Deatil info 초기화
					setFormReset();
					break;
				case "btn_del_seq":
					delSeqFlag = true;
					if(!ComShowConfirm(msgs["CIM30039"])) break;
					
					formObj.uc_cs_no.value = ucCsNo; //UC Case No
 					formObj.bl_no.value = "";
 					formObj.ctrt_ttl_vol_ctnt.value = "";
					
					//Add SEeq 버튼관련 비활성화
					setAddSequenceMode(true); 
					formObj.bl_no.readOnly = true;
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH)
					break;
					
	            case "btn_save": 
	            	// Authority 에 따른 제한
	            	if( isauthority==0){ // 관리자일경우 그냥 저장시킨다.
		           		if (!validateAuthority(strAuthority, strMode, srcName)) {
		            		break;
		            	}
	            	}
	           	
	           		// strMode 값
	           		// "C" : UC Case NO 가 없는 경우(신규저장)			=> Master : input, Detail : input    (CREATE)
	           		// "U" : UC Case NO 가 있는 경우(기존 Seq 변경)  	=> Master : update, Detail : update  (UPDATE)
	           		// "A" : UC Case NO 가 있는 경우(신규 Seq 추가/저장)	=> Master : update, Detail input	 (ADD)
	           		if (strMode == "C") {
	           			// 신규 UC Creation
	           			if (!doActionIBSheet(sheetObjects[0],document.form,IBCREATE)) break;
	           			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	           			setAuthority();
	           			setSearchMode(formObj.search_flg.checked);
	           		} 
	           		if(strMode == "U") {
	           			// Add Seq 버튼 활성화 : 기존 UC 데이타 변경
	           			var strSeqTmp = formObj.uc_seq.Text;
	           			
	           			if( !doActionIBSheet(sheetObjects[0],document.form,IBSAVE)) break;
	           			
	           			
	           			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	           			setAuthority();
	           			formObj.uc_seq.Text = strSeqTmp;
	           			setSearchMode(formObj.search_flg.checked);
	           			
						// reopen enable/disable
	           			formObj.chk_uc_ropn_flg.checked = false;
						if ( formObj.auth_cd.value == "O" && (formObj.uc_sts_cd.Code == "CL"||formObj.uc_sts_cd.Code == "CN" )){
							formObj.chk_uc_ropn_flg.disabled = false;
						} else {
							formObj.chk_uc_ropn_flg.disabled = true;
						}
	           		}
	           		if (strMode == "A") {
	            		// Add Seq 버튼 비활성화 : 기존 UC 데이타에 Sequence 추가 상황.( Master도 변경했을 가능성은 있음)
	           			if( !doActionIBSheet(sheetObjects[0],document.form,IBINSERT)) break;
	           			
	           			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		            	setAuthority();
		            	formObj.uc_seq.Index = formObj.uc_seq.GetCount() - 1;
		            	setSearchMode(formObj.search_flg.checked);
	           		}
	           		// 저장 성공 메세지 출력
	           		ComShowMessage(msgs["CIM30019"]);
	           			
					//Add SEeq 버튼관련 활성화
	           		setAddSequenceMode(true);
	           		
	           		formObj.uc_cs_no.readOnly = true;
					formObj.bl_no.readOnly = true;
					formObj.cnee_uc_dt.readOnly = true;
					authorityUiControl();	

					break;

				case "btn_new":					
					// 최초 login 상태로 돌림
					setFormReset("ALL");
					setSearchMode(false);
					document.form.auth_cd.value = "A"
					setAddSequenceMode(false);
										
					formObj.uc_cs_no.readOnly = true;
					formObj.bl_no.readOnly = false;
					formObj.cnee_uc_dt.readOnly = false;
					
					formObj.search_flg.checked = false;
														
					formObj.uc_sts_cd.Code = "OS";
					ComBtnDisable("btn_uc_activity");
									
					// new 버튼후 번한에 따른 화면제어를 다시한다.
					authorityUiControl();									
					break;
				case "btn_info":
					openBookingInfoPopup(formObj.bl_no.value,'','N');
					break;

				case "btn_dem_det_info":
					openDemDetInfoPopup(formObj.bl_no.value,'','N');
					break;

	            case "btn_hidden":            	
	            	setControlHidden();
	            	break;
	            	
	            case "btn_uc_activity":
	            	var pIsReadOnly="N";
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}
	            	}
	            	openUcActivityPopup(formObj.uc_cs_no.value,'UCA',pIsReadOnly);	// UC Activity 팝업 호출 file
	            	break;
	            		
				case "btn_bl_cntr_dtl":
	            	var pIsReadOnly="N";
	            		            	
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}
	            	}					
					// 인자 : 'BL', UC No, B/L No, B/L 컨테이너 갯수, 컨테이너 List
					openVolDtlPopup('BL',formObj.uc_cs_no.value,formObj.bl_no.value,formObj.ctrt_ttl_vol_ctnt.value,formObj.cntr_list.value,pIsReadOnly);	 // BL No만 입력 시 컨테이너 멀티선택할 수 있는 팝업호출 - Contract of Carriage에서 사용
					break;

				case "btn_uc_cntr_dtl":
	            	var pIsReadOnly="N";	            		                        		
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}

	            	}							
					openVolDtlPopup('UC',formObj.uc_cs_no.value,'',formObj.ctrt_ttl_vol_ctnt.value,formObj.cntr_list.value,pIsReadOnly);	// BL No만 입력 시 컨테이너 멀티선택할 수 있는 팝업호출 - Contract of Carriage에서 사용
					break;
					
				case "btn_inv_exchange":
					var pIsReadOnly="N";
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}
	            	}					
					openHelpExchangePopup('INV',pIsReadOnly);	// UC Details - Invoice Value 팝업 호출
					break;
					
				case "btn_cur_exchange":
					var pIsReadOnly="N";
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}
	            	}					
					openHelpExchangePopup('CRNT',pIsReadOnly);	// UC Details - Current Value 팝업 호출
					break;

				case "btn_help_exchange":
					var pIsReadOnly="N";
	            	if(isauthority!=0){
	            		// 2014.11.13 민정호
	            		if(form.uc_cs_no.value != ""){
	            			pIsReadOnly="Y";	            			
	            			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value){	            				            			            		
	            				pIsReadOnly="N";
	            			}
	            		}
	            	}					
					openHelpExchangePopup('OTS',pIsReadOnly);	// Outstanding Charge & Cost - Help Exchange 팝업 호출
					break;
	            case "btn_mSave": 
	            	doActionIBSheet(sheetObjects[0],formObj,MULTI05);

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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		
    	var sheetObj = sheetObjects[0];

  		for(i=0;i<sheetObjects.length;i++){ 
  	         //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet (sheetObjects[i] );  			
			initSheet(sheetObjects[i],i+1);
	         //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);			
		}
  		
		// IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){  	    	
	        initCombo(comboObjects[k],k+1);
	    } 	
	    
		//html컨트롤 이벤트초기화
		initControl();
		
		setSearchMode(false);
		
		document.form.auth_cd.value = "A";		// 최초 신규 입력 모드
		document.form.uc_sts_cd.Code = "OS";	// 최초 Status : Outstanding으로 설정
		ComBtnDisable("btn_uc_activity");		// 최초 disalbe, 조회 : enable, new : disable
		ComBtnDisable("btn_del_seq");           // 최초 로드시 del seq 관련 값이없으므로 비활성화
		top.document.body.scrollTop = 0;
		
		// Popup 으로 실행되는 경우.
		if (document.form.uc_cs_no.value != "" ) {
			setSearchMode(true);			// btn_retrieve 활성화 시켜야함.
			document.getElementById('btn_retrieve').fireEvent('onclick');
		}				
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
    function initTab(tabObj , tabNo,isauthority) {
        switch(tabNo) {
            case 1:
               with (tabObj) {
            	tabObj.RemoveAll()
                   var cnt  = 0 ;
                   InsertTab( cnt++ , "Fact Findings & Activities" , -1 );
                   InsertTab( cnt++ , "Handling Office Opinion" , -1 );
                   InsertTab( cnt++ , "Counter Office Opinion" , -1 );
               	   if(authorityKey==2){ // 권한테이블에 등록되지 않은자  
               		   InsertTab( cnt++ , "HO Memo" , -1 );
               	   }else if(isauthority==1){ // offcd 가 HAMUR, SINWA, SHAAS, SELIB, TYOIB 로 등록된자
                	   InsertTab( cnt++ , "RHQ Memo" , -1 );
                   }else if(isauthority==2){ // offcd 가 SELCOE 로 등록된자 
                	   InsertTab( cnt++ , "HO Memo" , -1 );
                   }
               }
            break;
        }
    }

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	*/
	
	function tab1_OnChange(tabObj , nItem){
	
		var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= nItem;
        
	}

	function tab1_OnClick(tabObj , nItem){
		if (openTabIndex != nItem) {
			openTabIndex = nItem;
		}
	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	var strAction;
    	strAction = sAction;
    	if (strAction == IBSAVE || strAction == IBCREATE ||strAction == IBINSERT ) strAction = IBSAVE;

    	with (formObj) {
    		switch (strAction) {
    		case IBSEARCH:
    			// Save 시 Mandatory Item : 2개 (Uc Case No, B/L No)
    			
    			if (ComTrim(uc_cs_no) == "" && ComTrim(bl_no) == ""){
    				ComShowCodeMessage("CIM21001", "UC Case No or B/L No");
    				return false;
    			}
    			return true;
    			break;
    			
    		case IBSAVE:				//  IBSAVE, IBCREATE, IBINSERT
    			
    			// Reopen 권한을 가진경우. reopen checkbox가 체크 된 상태만 저장 Process 진행.
    			if (auth_cd.value == "O"){	
        			if (!formObj.chk_uc_ropn_flg.checked) {
     					ComShowMessage("Please, Check Reopen Checkbox, if you want to reopen this UC");
     					return false;
     				}
    			}
    			
    			//Counter Office-Branch/Agent, Handler, Counter Office Opinion 만 수정가능한 경우 ( UC Case No, B/L No 필수)
    			if (auth_cd.value == "P"){	
    				
        			if (ComTrim(uc_cs_no) == ""){
        				ComShowCodeMessage("CIM21001", "UC Case No");
        				return false;
        			}
        			if (ComTrim(bl_no) == ""){
        				ComShowCodeMessage("CIM21001", "B/L No");
        				return false;
        			}
    			}
    			
    			// 신규생성, 전체수정하는 경우
    			if (auth_cd.value == "A"){	
	    			// Save 시 Mandatory Item List
	    			if (sAction != IBCREATE) {		// UC Case 정보를 최초 생성하는 경우에는 UC Case NO가 필수가 아님.
	        			if (ComTrim(uc_cs_no) == ""){
	        				ComShowCodeMessage("CIM21001", "UC Case No");
	        				return false;
	        			}
	    			}
	    			if (ComTrim(hndl_rhq_cd) == ""){
	    				ComShowCodeMessage("CIM21001", "Handling Office - RHQ");
	    				return false;
	    			}
	    			if (ComTrim(hndl_brnc_cd) == ""){
	    				ComShowCodeMessage("CIM21001", "Handling Office - Branch/Agent");
	    				return false;
	    			}
	    			if (ComTrim(hndl_hdlr_usr_id) == ""){
	    				ComShowCodeMessage("CIM21001", "Handling Office - Handler");
	    				return false;
	    			}
	    			if (ComTrim(kntr_rhq_cd) == ""){
	    				ComShowCodeMessage("CIM21001", "Counter Office");
	    				return false;
	    			}
	    			if (ComTrim(kntr_brnc_cd) == ""){
	    				ComShowCodeMessage("CIM21001", "Counter Office - Branch/Agent");
	    				return false;
	    			}
	    			if (ComTrim(cnee_uc_dt) == ""){
	    				ComShowCodeMessage("CIM21001", "UC Date");
	    				return false;
	    			}
	    			if (ComTrim(bl_no) == ""){
	    				ComShowCodeMessage("CIM21001", "B/L No");
	    				return false;
	    			}
	    			if (ComTrim(ctrt_ttl_vol_ctnt) == ""){
	    				ComShowCodeMessage("CIM21001", "CNTR Vol");
	    				return false;
	    			}
	    			if (ComTrim(uc_rsn_cd.Text) == ""){
	    				ComShowCodeMessage("CIM21001", "UC Reasons");
	    				return false;
	    			}
	    			if (ComTrim(fact_fnd_act_desc) == ""){
	    				ComShowCodeMessage("CIM21001", "Fact Finding & Activity");
	    				return false;
	    			}
	    			
	    			// Handling Branch/Agent 와 Counter Branch/Agent 동일하게 입력못하게 처리
	    			if (ComTrim(hndl_brnc_cd) == ComTrim(kntr_brnc_cd)){
	    				ComShowMessage("Handling - Branch/Agent must not be the same Counter - Branch/Agent.");
	    				return false;
	    			}
	    			
	    			// Close : 5개의 Mandatory 항목 check (C/Office의 Agent,Handler, Disposal Solution, Counter Office Opinion + Close Date)
	    			if (uc_sts_cd.Code == "CL"){
	        			if (ComTrim(kntr_brnc_cd) == ""){
	        				ComShowCodeMessage("CIM21001", "Counter Office - Branch/Agent");
	        				return false;
	        			}
	        			if (ComTrim(uc_disp_opt_cd.text) == ""){
	        				ComShowCodeMessage("CIM21001", "Disposal Solution");
	        				return false;
	        			}
	        			if (ComTrim(uc_clz_dt) == ""){
	        				ComShowCodeMessage("CIM21001", "Close Date");
	        				return false;
	        			}
	    			}
	
	    			// Close Application : 4개의 Mandatory 항목 Check(C/Office의 Agent,Handler, Disposal Solution, Close Date )
	    			if (uc_sts_cd.Code == "CA") {
	        			if (ComTrim(kntr_brnc_cd) == ""){
	        				ComShowCodeMessage("CIM21001", "Counter Office - Branch/Agent");
	        				return false;
	        			}
	    				if (ComTrim(uc_disp_opt_cd.text) == ""){
	    					ComShowCodeMessage("CIM21001", "Disposal Solution");
	    					return false;
	    				}
	    				if (ComTrim(uc_clz_dt) == ""){
	    					ComShowCodeMessage("CIM21001", "Close Date");
	    					return false;
	    				}
	    			}
	    			
	    			var strPodDt = allReplace(pod_eta,"-");
	    			var strClsDt = allReplace(uc_clz_dt,"-");
	    			var strUcDt = allReplace(cnee_uc_dt,"-");

	    			// POD < UC DATE < CLOSE DATE 가 정상적인 Date : POD, CLOSE DATE는 없을 수도 있다. 
	    			if ( strPodDt != "" && strClsDt == "" ){
	    				if (strPodDt > strUcDt){
	    					ComShowMessage("POD must be earlier than UC Date.");
	    					return false;
	    				}
	    			} else if ( strPodDt == "" && strClsDt != "") {
	    				if (strUcDt > strClsDt){
	    					ComShowMessage("UC Date must be earlier than Close Date.");
	    					return false;
	    				}
	    			} else if  ( strPodDt != "" && strClsDt != "") {
	    				if ((strPodDt > strUcDt) || (strUcDt > strClsDt)){
	    					ComShowMessage("POD must be earlier than UC Date and UC Date must be earlier than Close Date.");
	    					return false;
	    				}
	    			}
    			}
    			return true;
    			break;
    		default:				//  조회, 저장 제외 기타
    			return true;
    			break;
    		} // switch
    	} // with 
    }		 

    function validateDate() {
    	
    	var formObj = document.form;
    	
		var strPodDt = allReplace(formObj.frst_pod_eta,"-");
		var strClsDt = allReplace(formObj.uc_clz_dt,"-");
		var strUcDt = allReplace(formObj.cnee_uc_dt,"-");
		
		if (strClsDt != "" && strUcDt != "" ){
			if (strPodDt == "") {
				// cls vs uc 비교
				if (strUcDt > strClsDt){
					ComShowMessage("UC Date must be earlier than Close Date.");
					return false;
				}
			} else {
				// pod vs cls vs uc 비교
				if ((strPodDt > strUcDt) || (strUcDt > strClsDt)){
					ComShowMessage("POD must be earlier than UC Date and UC Date must be earlier than Close Date.");
					return false;
				}
			}
		}

		if (strClsDt == "" && strUcDt != "" ){
			if (strPodDt == "") {
				// 비교 안함
				return true;
			} else {
				//pod vs uc 비교
				if (strPodDt > strUcDt){
					ComShowMessage("POD must be earlier than UC Date.");
					return false;
				}
			}
		}
		
		if (strClsDt != "" && strUcDt == "" ){
			if (strPodDt == "") {
				// 비교 안함
				return true;
			} else {
				// pod vs cls 비교
				if (strPodDt > strClsDt){
					ComShowMessage("POD must be earlier than Close Date.");
					return false;
				}
			}
		}
		return true;
    }
    
	/**
	 * 선택된 탭의 fm_dt 자릿수 체크하여  to_dt로 포커스 이동 시켜주는 함수<br>
	 * <br><b>Example : </b>
	 * <pre>
	 *    checkCustLeng('20090901');
	 * </pre>
	 * @param string value
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function checkFmDtLeng(value){    	  
		if(ComTrimAll(value," ", "-", ":").length==8){
			if(form.to_dt.value==""){
				form.to_dt.value = ComTrimAll(value," ", "-", ":");
			}
			form.to_dt.select(); 
		}
	}
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10
	 */
	function initControl() {		
		var formObj = document.form;
		
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListener('change', 	'obj_change_seq', 		'uc_seq'); 
		axon_event.addListener('change', 	'obj_change_bl', 			'bl_no_lst'); 
		axon_event.addListener('click',  	'obj_change_srchflg', 		'search_flg'); 
		axon_event.addListener('click',  	'obj_change_reopen', 		'chk_uc_ropn_flg');
		axon_event.addListener('change',  	'obj_change_reason', 	'uc_rsn_cd'); 
		axon_event.addListener('change',  	'obj_change_status', 		'uc_sts_cd');
		//2014.11.13 민정호
		axon_event.addListener('change',  	'obj_change_bl_no', 		'bl_no');		

	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerFormat('blur', 					'obj_deactivate',  		formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리	
		axon_event.addListenerFormat('focus', 				'obj_activate'  ,  		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 			'obj_keypress'  , 		formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리	    
	    axon_event.addListenerFormat('keyup', 				'obj_keyup'     ,  		formObj);
	    
	    var texArr = document.getElementsByTagName("input");
	    var i=0;

	    for(i;i<texArr.length ; i++){
	    	if(texArr[i].getAttribute("dataformat")=="ymd"){
	    		if(texArr[i].name!="por_dt" && texArr[i].name!="pol_etd" && texArr[i].name!="pod_eta" && texArr[i].name!="del_dt" && texArr[i].name!="uc_do_iss_dt"){
	    			texArr[i].title="YYYY-MM-DD";
	    		}  
	    	}
	    }
	    
	   var getAuthority =  doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC08)
	   isauthority = getAuthority.split(",")[0]
	   isoffcd     = getAuthority.split(",")[1]
	   authorityKey = isauthority;
	   
   	   formObj.isauthority.value=isauthority;
	   for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1,0);
	   }
	}
	
	//권한에 따른 화면 제어(2014.11.18 민정호)
	function authorityUiControl(){
						
		
		var inputArr = document.getElementsByTagName("input");
		var textareaArr = document.getElementsByTagName("textarea");
			
		//2014.12.03 민정호
		if (form.chk_uc_ofc_trns_flg.checked) {				
			if(form.ofc_cd.value == form.kntr_brnc_cd.value){
				ComBtnEnable("btn_save");// 저장	
			}else{
				ComBtnDisable("btn_save");// 저장
			}
			return;
		}		
		
		
			// input 박스 체크
			var i=0;
			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
					document.form.hndl_brnc_cd.value == ""
					){
						for(i;i<inputArr.length ; i++){							
							if(inputArr[i].className != "input2"){		//2014.12.03 민정호
								inputArr[i].readOnly = false;								
							}
						}						
			}else{
						for(i;i<inputArr.length ; i++){
							inputArr[i].readOnly = true;
							inputArr[i].className = "input";
						}		
			}
							
			// input박스의 클래스 조절
			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
					document.form.hndl_brnc_cd.value == ""
					){											
				form.hndl_brnc_cd.className = "input1";
				form.hndl_hdlr_usr_id.className = "input1";
				form.kntr_brnc_cd.className = "input1";
				form.cnee_uc_dt.className = "input1";
				form.bl_no.className = "input1";
				form.ctrt_ttl_vol_ctnt.className = "input1";
				form.cntr_list.className = "input1";				
				
				form.hndl_brnc_cd.readOnly = false;
				form.hndl_hdlr_usr_id.readOnly = false;
				form.kntr_brnc_cd.readOnly = false;
				form.cnee_uc_dt.readOnly = false;
				form.bl_no.readOnly = false;
				form.ctrt_ttl_vol_ctnt.readOnly = false;
				form.cntr_list.readOnly = false;
			}else{				
				form.hndl_brnc_cd.className = "input";
				form.hndl_hdlr_usr_id.className = "input";
				form.kntr_brnc_cd.className = "input";
				form.cnee_uc_dt.className = "input";
				form.bl_no.className = "input";
				form.ctrt_ttl_vol_ctnt.className = "input";
				form.cntr_list.className = "input";				
				
				form.hndl_brnc_cd.readOnly = true;
				form.hndl_hdlr_usr_id.readOnly = true;
				form.kntr_brnc_cd.readOnly = true;
				form.cnee_uc_dt.readOnly = true;
				form.bl_no.readOnly = true;
				form.ctrt_ttl_vol_ctnt.readOnly = true;
				form.cntr_list.readOnly = true;												
			}			
			//-----------------------------------------------------------------------------------						
			if (  (form.uc_sts_cd.Code == "CL"||form.uc_sts_cd.Code == "CA" )){
				document.form.chk_uc_ropn_flg.disabled = false;
			} else {
				document.form.chk_uc_ropn_flg.disabled = true;
			}			
			
			// 메모박스 체크
			var i=0;			
			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
					document.form.hndl_brnc_cd.value == ""
				){														
				for(i;i<textareaArr.length ; i++){
					if(textareaArr[i].name != 'manager_memo'){
						textareaArr[i].readOnly = false;						
					}
				}
			}else{
				for(i;i<textareaArr.length ; i++){
					if(textareaArr[i].name != 'manager_memo'){
						textareaArr[i].readOnly = true;
						textareaArr[i].className = "input";
						
					}
				}				
			}
								
			// 콤보박스 비활성화
			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
				document.form.hndl_brnc_cd.value == ""
			){
				form.uc_rsn_cd.Enable=true;
				form.uc_disp_opt_cd.Enable=true;
				form.uc_obl_hld_cd.Enable=true;
				form.uc_piclb_cd.Enable=true;								
			}else{
				form.uc_rsn_cd.Enable=false;
				form.uc_disp_opt_cd.Enable=false;
				form.uc_obl_hld_cd.Enable=false;
				form.uc_piclb_cd.Enable=false;				
			}
						
			// 버튼 비활성화			
			if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
					document.form.hndl_brnc_cd.value == ""
			){
				ComBtnEnable("btn_add_seq"); // add seq				
			}else{
				ComBtnDisable("btn_add_seq"); // add seq				
			}
			
			if(isauthority==0){
				document.all.reopen_display.style.visibility="hidden";
				form.uc_sts_cd.DeleteItem("CL");
				
				// 버튼 비활성화			
				if(document.form.ofc_cd.value == document.form.hndl_brnc_cd.value ||
						document.form.hndl_brnc_cd.value == ""
				){
					ComBtnEnable("btn_save"); 				
				}else{
					ComBtnDisable("btn_save");				
				}				
				
				
			}else if(isauthority==1||isauthority==2){
				document.all.reopen_display.style.visibility="";
						
				document.form.uc_clz_dt.readOnly = false;
				document.form.search_flg.readOnly = false;
				document.form.uc_cs_no.readOnly = false;		
				
				ComBtnDisable("btn_del_seq"); // del seq			
				ComBtnEnable("btn_save");// 저장					
			}
			
			obj_change_status();					
	}	
	
	// Total Change & Cost, Net Loss 계산
	function caculateOutstandingCost() {
		var formObj = document.form;
		with (formObj){
			// Total Charge & Cost = OFT+Sucharge+MSC Charge+DMT+Storage+Other Cost 더한 금액을 보여준다
			ots_total.value = (allReplace(ots_oft_amt,",")*1 + allReplace(ots_otr_amt,",")*1 + allReplace(ots_dmdt_amt,",")*1 + allReplace(ots_sto_amt,",")*1 + allReplace(ots_otr_cost_amt,",")*1).toFixed(2);
			net_loss.value = (allReplace(ots_total,",")*1 - allReplace(ots_rcvr_amt,",")*1).toFixed(2);

			setCostFormat();
		}
	}
	
	// OutStanding Chare & Cost 에서 dataformat 설정
	function setCostFormat() {
		var formObj = document.form;
		with (formObj){
			
			ots_oft_amt.value = (allReplace(ots_oft_amt,",")*1).toFixed(2);
			ots_otr_amt.value = (allReplace(ots_otr_amt,",")*1).toFixed(2);
			ots_dmdt_amt.value = (allReplace(ots_dmdt_amt,",")*1).toFixed(2);
			ots_sto_amt.value = (allReplace(ots_sto_amt,",")*1).toFixed(2);
			ots_otr_cost_amt.value = (allReplace(ots_otr_cost_amt,",")*1).toFixed(2);
			ots_insur_cvr_amt.value = (allReplace(ots_insur_cvr_amt,",")*1).toFixed(2);
			ots_total.value = (allReplace(ots_total,",")*1).toFixed(2);		
			net_loss.value = (allReplace(net_loss,",")*1).toFixed(2);
			ots_rcvr_amt.value = (allReplace(ots_rcvr_amt,",")*1).toFixed(2);
			
			ComChkObjValid(ots_oft_amt);
			ComChkObjValid(ots_otr_amt);
			ComChkObjValid(ots_dmdt_amt);
			ComChkObjValid(ots_sto_amt);
			ComChkObjValid(ots_otr_cost_amt);
			ComChkObjValid(ots_insur_cvr_amt);
			ComChkObjValid(ots_total);	
			ComChkObjValid(net_loss);
			ComChkObjValid(ots_rcvr_amt);

			if (ots_oft_amt.value == "0"||ots_oft_amt.value == "0.00" ) ots_oft_amt.value = "";
			if (ots_otr_amt.value == "0"||ots_otr_amt.value == "0.00") ots_otr_amt.value = "";
			if (ots_dmdt_amt.value == "0"||ots_dmdt_amt.value == "0.00" ) ots_dmdt_amt.value = "";
			if (ots_sto_amt.value == "0"||ots_sto_amt.value == "0.00") ots_sto_amt.value = "";
			if (ots_otr_cost_amt.value == "0"||ots_otr_cost_amt.value == "0.00" ) ots_otr_cost_amt.value = "";
			if (ots_insur_cvr_amt.value == "0"||ots_insur_cvr_amt.value == "0.00") ots_insur_cvr_amt.value = "";
			if (ots_total.value == "0"||ots_total.value == "0.00" ) ots_total.value = "";
			if (net_loss.value == "0"||net_loss.value == "0.00") net_loss.value = "";
			if (ots_rcvr_amt.value == "0"||ots_rcvr_amt.value == "0.00") ots_rcvr_amt.value = "";
		}
	}
	
	// uc_dys 설정 : Close Date-UC date, Close Date가 null 이면 오늘-UC Date
	function caculateUCDys() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var strTmp;
		with (formObj){
			
		 	if (ComTrim(uc_clz_dt) == ""){
		 		if ( sheetObj.Rows != 1){
		 			strTmp = sheetObj.CellValue(1, 'today');	
		 		} else {
		 			var today = new Date();
		 		    var year= today.getFullYear();
		 		    var mon = (today.getMonth()+1)>9 ? ''+(today.getMonth()+1) : '0'+(today.getMonth()+1);
		 		    var day = today.getDate()>9 ? ''+today.getDate() : '0'+today.getDate();
		 		    
		 			strTmp = year + "-" + mon + "-" + day;
		 		}
		 		
		 	} else {
		 		strTmp = uc_clz_dt.value;
		 	}
		 	if (ComTrim(cnee_uc_dt.value) == "") {
		 		uc_dys.value = ""
		 	} else {
		 		uc_dys.value = ComGetDaysBetween (cnee_uc_dt.value, strTmp);	
		 	}
		}
	}

	// uc_dchg_dys 설정 : close date (없음 오늘 날짜) - 조회된 B/L 정보중 제일 빠른 pod_eta 값
	function caculateDysFmDisch() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var strTmp;
		var strMax;
		with (formObj){
			
			strMax = ComTrim(frst_pod_eta) + "";

		 	// 2.2 Clsoe Date or Sysdate 산출
		 	if (ComTrim(uc_clz_dt) == "" ){
		 		strTmp = sheetObj.CellValue(1, 'today');
		 	} else {
		 		strTmp = uc_clz_dt.value;
		 	}
		 	
		 	// 2.3 최종 Days from Disch 산출
		 	if (strMax == null || strMax == "" ) {
		 		uc_dchg_dys.value = "";
		 	} else {
		 		uc_dchg_dys.value = ComGetDaysBetween (strMax, strTmp);
		 	}
		}
	}
	
	// 가장 빠른 POD_ETA 값 산출
	function caculatePodEta() {
		
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var strTmp = "";
		var strMax = "";
		with (formObj){
		 	// 2.1 가장 빠른 POD_ETA 값 산출
		 	for (var i = 1; i < sheetObj.rows; i++) {
		 		strTmp = ComReplaceStr(sheetObj.CellValue(i, 'pod_eta'), "-", "");
		 		if (strTmp != null && strTmp != "") {
			 		if (strMax == null) {
			 			strMax = strTmp;
			 		} else if (strMax < strTmp ) {
			 			strMax = strTmp;
			 		}	
		 		}
		  	}
		}
		return strMax;
	}
	
	function allReplace(strCnt, strRmv) {
		var re = new RegExp(strRmv,"g");
	    strCnt = ComTrim(strCnt);
	    return strCnt.replace(re, "");
	}

	
function obj_change_bl_no(){	
	var bReturn = "TRUE";
	var srcCD = event.srcElement.getAttribute("name");
	var chgObj = event.srcElement;
	var srcCDName;		
	var formObj = document.form;
				
	if (srcCD == "bl_no" && event.srcElement.value != ""){
		// 기존 BKG_BOOKING 테이블에 존재하는 B/L No 인지 확인
		srcCDName = "B/L No";
		formObj.ctrt_ttl_vol_ctnt.value="";
		formObj.intg_cd.value = ComTrim(formObj.bl_no);	// bl_no를 넣는다.
		bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
		if (bReturn != "FALSE") {
			// 기존 CIM_UC_CGO_DTL 테이블에 존재하는 B/L No 인지 확인. 존재하면 해당 UC CS No 값을 받음.
			bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC05);
			srcCDName = "B/L No (There is already this B/L No in '" + bReturn + "')";
			// FALSE 값 : 기존에 사용한 B/L 이 없다는 뜻, 사용해도 된다.
			if (bReturn != "FALSE") {
				bReturn = "FALSE";		// bReturn 값이 FALSE가 아닌 UC_CS_NO 값을 가진다. => 기존에 데이타 존재.Error
				setBlInfo(false,"");
			} else {
				bReturn = "TRUE";		// bReturn 값이 True이면 UC_CS_NO 에 해당 B/L 사용가능.
				// 해당 b/l 정보를 읽어 온다.
				formObj.intg_cd.value = ComTrim(formObj.bl_no);	// bl_no를 넣는다.
				bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC06);
			}
		} else {
			setBlInfo(false,"");
		}
	}	
}	
	
	function obj_deactivate() {
		var bReturn = "TRUE";
		var srcCD = event.srcElement.getAttribute("name");
		var chgObj = event.srcElement;
		var srcCDName;		
		var formObj = document.form;
		var strMode;
		
		// 1. DB Validation 항목 Check;
		
		// 최초 UC 생성, ADD SEQ 인 경우만 Validation Check, 그 외 경우는 BL/NO 변경 불가		
		// B/L Validation - add seq 버튼 비활성, 값이 있을때, Search 모드가 아닐경우, 즉 bl no 입력해서 저장 하는 경우 실행
		strMode = getOperationMode();
				
		// Handling Office: Branch/Agent Validation
		if (srcCD == "hndl_brnc_cd"){
			if ( ComTrim(event.srcElement.value) == "" ){
				formObj.hndl_brnc_cd.value = "";
				formObj.hndl_rhq_cd.value = "";
				bReturn = true;
			} else {
				srcCDName = "Handling Office: Branch/Agent";
				formObj.intg_cd.value = ComTrim(formObj.hndl_brnc_cd);
				bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				// Agent 값으로 RHQ 값 자동 설정
				if (bReturn != "FALSE"){
					bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
					if (bReturn != "FALSE"){
						formObj.hndl_rhq_cd.value = bReturn;
					}
				} else {
					formObj.hndl_rhq_cd.value = "";
				}
			}
		}
				
		// Counter Office: Branch/Agent Validation
		if (srcCD == "kntr_brnc_cd"){
			if ( ComTrim(event.srcElement.value) == "" ){
				formObj.kntr_brnc_cd.value = "";
				formObj.kntr_rhq_cd.value = "";
				bReturn = true;
			} else {
				srcCDName = "Counter Office: Branch/Agent";
				formObj.intg_cd.value = ComTrim(formObj.kntr_brnc_cd);
				bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				// Agent 값으로 RHQ 값 자동 설정
				if (bReturn != "FALSE"){
					bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
					if (bReturn != "FALSE"){
						formObj.kntr_rhq_cd.value = bReturn;
					}
				} else {
					formObj.kntr_rhq_cd.value = "";
				}
			}
		}
		
		// Handling Office: Handler Validation
		if (srcCD == "hndl_hdlr_usr_id" && event.srcElement.value != ""){
			srcCDName = "Handling Office: Handler";
			formObj.intg_cd.value = ComTrim(formObj.hndl_hdlr_usr_id);
			bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
		}

		// Counter Office: Handler Validation
		if (srcCD == "kntr_hdlr_usr_id" && event.srcElement.value != "" ){
			srcCDName = "Counter Office: Handler";
			formObj.intg_cd.value = ComTrim(formObj.kntr_hdlr_usr_id);
			bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
		}

		// Error Message Handling 
		if (bReturn == "FALSE"){
			ComShowCodeMessage("CIM30013", srcCDName);
			event.srcElement.value = "";
			ComSetFocus(event.srcElement);
			return; 	// DB Validation Error 나면 일단 Process 종료
		}		
		
		// 1.1 : UC Case NO 와 Branch/Agent 비교 
		// Handling Office: Branch/Agent Validation
		if (srcCD == "hndl_brnc_cd" && event.srcElement.value != "" ){
			var strUCTmp = ComTrim(formObj.uc_cs_no.value);		// uc case no
			var strBrnTmp = ComTrim(formObj.hndl_brnc_cd.value);			// Branch/Agent
			if ( strUCTmp != "" ) {
				strUCTmp = strUCTmp.substr(2,3);
				strBrnTmp = strBrnTmp.substr(0,3);
				if ( strUCTmp != strBrnTmp) {
					ComShowMessage("Handling Office: Branch/Agent doesn't match UC Case No.");
					formObj.hndl_rhq_cd.value = "";	
					event.srcElement.value  = "";
					event.srcElement.select();
					ComSetFocus(chgObj);
					return;
				}
			}
		}
		
		// 1.2 : handling : Office vs Handler Matching Check
		if (srcCD == "hndl_brnc_cd" || srcCD == "hndl_hdlr_usr_id" ) {
			if ( ComTrim(formObj.hndl_brnc_cd) != "" && ComTrim(formObj.hndl_hdlr_usr_id) != "" ) {
				formObj.intg_cd.value = "H";		// Handling
				bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC07);	// Search09
			}
			if (bReturn == "FALSE"){
				ComShowMessage("Branch/Agent doesn't match Handler");
				if(srcCD == "hndl_brnc_cd") {
					formObj.hndl_rhq_cd.value = "";
				}
				event.srcElement.value = "";
				event.srcElement.select();
				ComSetFocus(chgObj);
				return; 	// DB Validation Error 나면 일단 Process 종료
			}	
		}
		
		// 1.3 : Counter : Office vs Handler Matching Check
		if (srcCD == "kntr_brnc_cd" || srcCD == "kntr_hdlr_usr_id") {
			if ( ComTrim(formObj.kntr_brnc_cd) != "" && ComTrim(formObj.kntr_hdlr_usr_id) != "" ) {
				formObj.intg_cd.value = "C";		// Counter
				bReturn = doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC07);	// Search09
			}
			if (bReturn == "FALSE"){
				ComShowMessage("Branch/Agent doesn't match Handler");
				if(srcCD == "kntr_brnc_cd") {
					formObj.kntr_rhq_cd.value = "";
				}
				event.srcElement.value = "";
				event.srcElement.select();
				ComSetFocus(chgObj);
				return; 	// DB Validation Error 나면 일단 Process 종료
			}	
		}
		
		// 2. DB Validation 항목을 제외한 항목들 format check
		
		// dataformat = int 인경우 =>Skip, format masked 된 값 안받도록. 
		if (srcCD == "hndl_hdlr_usr_id"||srcCD == "kntr_hdlr_usr_id") return;

		// DB Validation 항목을 제외한 항목들 format check
		if (!ComChkObjValid(chgObj)) {
			event.srcElement.value  = "";
			event.srcElement.select();
			ComSetFocus(chgObj);
			return;
		}
		
		// 3. Close Date, UC Date 변경시 Validation Check
		if (srcCD == "uc_clz_dt" || srcCD == "cnee_uc_dt" ) {
			if (!validateDate()) {
				event.srcElement.value  = "";
				event.srcElement.select();
				ComSetFocus(chgObj);
			}
		}
		
		// 4. 변경시 무조건 재계산 항목들 
		// 4.1 Outstanding Change & Cost 관련 항목 변경시 무조건 재계산
		if (srcCD == "ots_oft_amt" ||srcCD == "ots_otr_amt" || srcCD == "ots_dmdt_amt" || srcCD == "ots_sto_amt"|| srcCD == "ots_otr_cost_amt"|| srcCD == "ots_rcvr_amt"|| srcCD == "ots_insur_cvr_amt"){
			chgObj.value = (allReplace(chgObj,",")*1).toFixed(2);
			if (chgObj.value == "0"||chgObj.value == "0.00" ) chgObj.value = "";
			caculateOutstandingCost();
		}

	 	// 4.2 uc_dchg_dys 설정 : close date (없음 오늘 날짜) - 조회된 B/L 정보중 제일 빠른 pod_eta 값(close Date 변경시 무조건 재계산)
		if (srcCD == "uc_clz_dt") {
			caculateDysFmDisch();
		}
		
		// 4.3 uc_dys 설정 : Close Date-UC date, Close Date가 null 이면 오늘- UC Date (close Date, UC Date 변경시 무조건 재계산)
		if (srcCD == "uc_clz_dt" ||srcCD == "cnee_uc_dt" ) {
			caculateUCDys();
		}
	 			
	}
	
    /**
     * 금액 속성 설정 - 금액 변경시 calculate() 호출
     **/
    function obj_change_currency(){
    	var obj = event.srcElement
		var formObj = document.form;
    	obj.value = obj.value.trim();
    	obj.value = ComAddComma2(ComTrimAll(obj.value,","), "#,###");
    }   	
	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	function obj_keyup() {
		ComKeyEnter('lengthnextfocus');
	}
	
	
	
	/**KEY Event<br>
	 * @author Choi Do Soon
	 * @version 2009.11.10R
	 */
	
	function obj_keypress(){
		obj = event.srcElement;
		
		switch(event.srcElement.dataformat){
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "ymd":
			//숫자+"-"입력하기
			ComKeyOnlyNumber(event.srcElement,"-");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engnum":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet('num');
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "int":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('int');
			break;
		case "num":
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber('');
			break;
		default:
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
		}
	} 
	
	
    /** 
     * 문자에 대해 특정 문자열을 다른 문자열로 치환<br>
     * <br><b>Example :</b>
     * <pre>
     * </pre>
     * @param  {String} strTemp : 치환 대상 문자
     * @param  {String} strValue1 : 대상문자에서 치환할 문자
     * @param  {String} strValue2 : 다른 문자열로 치환할 문자
     * @return {String} 중국어 금액
     * @see #
     * @author 한동훈
     * @version 2009.10.19
     */
    function replaceAll(strTemp, strValue1, strValue2){
  	  while(1){
  	    if( strTemp.indexOf(strValue1) != -1 ){
  	       strTemp = strTemp.replace(strValue1, strValue2);
  	    }else{
  	       break;
  	    }   
  	  }
  	   return strTemp;   	 
  	}

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }     
     
/*     *//**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 	/**
	 * doActionIBSheet
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {  
		// Validation Check - IBCREATE의 경우는 US Csae No 생성후 Validation Check 실행
    	if (sAction != IBCREATE) {
    		if (!validateForm(sheetObj, formObj, sAction)) return false;
    	}
    	
        switch(sAction) {
			case IBSEARCH:      //조회								
			    sheetObj.WaitImageVisible=false;
			    ComOpenWait(true);			
				formObj.f_cmd.value = SEARCH;
				
 				var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
 				sheetObjects[0].LoadSearchXml(sXml);
 				
 				ComOpenWait(false);
 				if (ComGetEtcData(sXml,"RTNVAL") != "TRUE"){
 					ComShowMessage(msgs["CIM29030"]);
 					return false;
 				}
 								
 				//조회된 데이터를 조회할 권한을 가진자인지 체크 - 2014.10.23 일에 추가
 			    var ucOfcTrnsFlg = sheetObj.CellValue(1, 'uc_ofc_trns_flg'); //OFC Transfer 
 			    var hndlRhqCd = sheetObj.CellValue(1, 'hndl_rhq_cd'); // Handling Office  | RHQ
 			    var kntrRhqCd = sheetObj.CellValue(1, 'kntr_rhq_cd'); // Counter Office   | RHQ
 			    var lgnUsrOfc = ComTrim(formObj.ofc_cd);  // 로그인 한자의 offcd

 			    // uc_sts_cd 를 다시 셋팅한다.
 			    form.uc_sts_cd.RemoveAll();
 			    MakeComboObjectLocal(form.uc_sts_cd, onStsCdArrStr, 1, 0, 50,200);
 			    document.form.uc_sts_cd.Code = "OS";	// 최초 Status : Outstanding으로 설정 			    	
 			    				
 			    if(isauthority!=2){
	 			    if(ucOfcTrnsFlg!="Y"){ // OFC Transfer 체크
	 			    	if(hndlRhqCd != isoffcd) {
	 			    		isauthority=0;
	 			    		formObj.isauthority.value=0;
	 			    	}else{
	 			    		isauthority=authorityKey;
	 			    		formObj.isauthority.value=authorityKey;
	 			    		
	 			    	}
	 			    }else{
	 			    	if(kntrRhqCd != isoffcd) {
	 			    		isauthority=0;
	 			    		formObj.isauthority.value=0;
	 			    	}else{
	 			    		isauthority=authorityKey;
	 			    		formObj.isauthority.value=authorityKey;
	 			    		
	 			    	}
 			       }
 			    }
 			    				
 			    for(k=0;k<tabObjects.length;k++){
 					initTab(tabObjects[k],k+1,isauthority);
 			    }	 			    
 				
 			    // 조회 Data Display from Sheet to html object
 				setFormReset();
				setSearchValue(sheetObj, formObj, 1);
				
				// 조회 후 Objcect handling
				with (formObj){

					// Head 성 정보 설정
					// 1.  uc_seq_ttl, Sequence, B/L inquiry 설정
					uc_seq_ttl.value = "";
					uc_seq.RemoveAll();
					bl_no_lst.RemoveAll();
				 	for (var i = 1; i < sheetObj.rows; i++) {
				 		if ( i == 1 ){
				 			uc_seq_ttl.value = sheetObj.SearchRows;
				 		}
				 		// Seqeence combo 에 insert
				 		uc_seq.InsertItem(-1,ComTrim(sheetObj.CellValue(i, 'uc_seq'))); 
				 		// B/L inquiry combo에 insert
				 		bl_no_lst.InsertItem(-1,ComTrim(sheetObj.CellValue(i, 'bl_no')));
				  	}
				 	uc_seq.index2 = 0;
				 	bl_no_lst.index2 = 0;
				 
					// 가장 빠른 pod_eta 값 구함.
					formObj.frst_pod_eta.value = caculatePodEta();
					
				 	// 2. uc_dchg_dys 설정 : close date (없음 오늘 날짜) - 조회된 B/L 정보중 제일 빠른 pod_eta 값
				 	caculateDysFmDisch();
				 	
				 	// 3. uc_dys 설정 : Close Date-UC date, Close Date가 null 이면 오늘-UC Date
				 	caculateUCDys();

				 	// 4. Status 활성 비활성화
				 	if (uc_sts_cd.Code == "CL"||uc_sts_cd.Code == "CN" ) {
						uc_sts_cd.enable = false;
						uc_sts_cd.readOnly = false;
				 	} else {
						uc_sts_cd.enable = true;
						uc_sts_cd.readOnly = true;
				 	}
				 	
					// 5. file upload 활성화
					ComBtnEnable("btn_uc_activity");
				}
											
 				if(delSeqFlag){
 					delSeqFlag = false;
 					formObj.uc_seq.index2=ucSeq;
 					formObj.uc_seq_ttl.value = ucSeqTtl; //Sequence selected
 					obj_change_seq();
 				}			
 				authorityUiControl()
				return true;
				break;
		case IBCREATE:
			// Case1_MULTI   :  UC Case NO 가 없는 경우  => Master : input, Detail : input
			// Validation Check
        	if (!validateForm(sheetObj, formObj, sAction)){
        		return false;
        	}
        	
			// UC Case No생성
			formObj.f_cmd.value = SEARCH11;
	    	var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));	
	    	var flag = ComGetEtcData(sXml, "Flag"); 
	    	
	    	if(flag == 'N'){
	    		ComShowMessage("The B/L number is already registered and please contact H/O if additional creation is necessary");
	    		return false;
	    	}

			// UC Case No생성
			formObj.f_cmd.value = SEARCH02;
	    	var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));	
	    	formObj.uc_cs_no.value = ComGetEtcData(sXml, "UCCaseNo"); 
			
    	    // Case1_MULTI   :  UC Case NO 가 없는 경우  => Master : input, Detail : input 
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false; 			
 			ComOpenWait(true);	
 			
			var sXml = sheetObj.GetSaveXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			
			ComOpenWait(false);
			
			if (ComGetEtcData(sXml,"RTNVAL") != "N"){
				ComShowMessage(ComGetEtcData(sXml,"RTNVAL"));
				return false;
			}
			return true;
			break;			
		case IBSAVE:
			// "A"(all) : 권한/ Case1_MULTI01 :  UC Case NO 가 있는 경우(기존 Seq 변경)  => Master : update, Detail : update (MULTI01)
			// "P"(part): 권한/ 3개의 항목만 수정 가능 => Master : update, Detail : update(MULTI03)
			// "O"(Open/Reopen): Uncollected Cargo Status 가 Cancel, Closed 된 것을 Reopen 시킬수 있다
						
 			if (formObj.auth_cd.value == "P") {
 				formObj.f_cmd.value = MULTI03;
 			} else if (formObj.auth_cd.value == "O") {
 				formObj.f_cmd.value = MULTI04;
 				if (!formObj.chk_uc_ropn_flg.checked) {
 					ComShowMessage("Current user does not have permission to save.");
 					return;
 				}
 			} else {
 				formObj.f_cmd.value = MULTI01;
 			}
 			
 			// Check Box 값 Handling 			
 			if (formObj.chk_uc_ofc_trns_flg.checked) {
 				formObj.uc_ofc_trns_flg.value = "Y";
 			} else {
 				formObj.uc_ofc_trns_flg.value = "N";
 			}
 			
 			sheetObj.WaitImageVisible=false; 			
 			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			ComOpenWait(false);

			if (ComGetEtcData(sXml,"RTNVAL") != "N"){
				return false;
			} else {
				return true;
			}
			break;	
		case IBINSERT:        //저장
			// Case1_MULTI02 :  UC Case NO 가 있는 경우(Seq 추가 후 변경)  => Master update, Detail input
			formObj.f_cmd.value = MULTI02;
			
			sheetObj.WaitImageVisible=false; 			
 			ComOpenWait(true);
 			var sXml = sheetObj.GetSaveXml("EES_CIM_0063GS.do", FormQueryString(formObj));	
 			ComOpenWait(false);
 			
			if (ComGetEtcData(sXml,"RTNVAL") != "N"){
//				ComShowMessage(ComGetEtcData(sXml,"RTNVAL"));
				return false;
			} else {
				return true;
			}
			
			break;
		case IBSEARCH_ASYNC01: //BL No Validation Check - 실제 존재하는 BL 유무 확인
			formObj.f_cmd.value = SEARCH03;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			
			return ComGetEtcData(sXml,"RTNVAL");
			break;
		case IBSEARCH_ASYNC02: //Branch/Agent Validation Check - 실제 존재하는 Branch/Agent 유무 확인
			formObj.f_cmd.value = SEARCH04;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml,"RTNVAL");
			break;
		case IBSEARCH_ASYNC03: //RHQ Validation Check - Agent 에 해당하는 RHQ 리턴
			formObj.f_cmd.value = SEARCH05;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml,"RTNVAL");
			break;
		case IBSEARCH_ASYNC04: //HANDLER Validation Check - 실제 존재하는 HANDLER 유무 확인
			formObj.f_cmd.value = SEARCH06;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml,"RTNVAL");
			break;	
		case IBSEARCH_ASYNC05: //BL No Validation Check - CIM_UC_CGO_DTL 에 해당 B/L NO 존재 여부 조회
			formObj.f_cmd.value = SEARCH07;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml,"RTNVAL");
			break;
		case IBSEARCH_ASYNC06: //BL No Data Inquiry
			formObj.f_cmd.value = SEARCH08;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			setBlInfo(true,sXml);		
			return true;
			break;
		case IBSEARCH_ASYNC07: // Office vs handler : Match Check
			formObj.f_cmd.value = SEARCH09;
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			return ComGetEtcData(sXml,"RTNVAL");
			break;
		case IBSEARCH_ASYNC08: // 권한 조회
			formObj.f_cmd.value = SEARCH10;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			
			return ComGetEtcData(sXml,"getAuthority");
			break;
        case MULTI05:
	    	// Authority 에 따른 제한
	   		if (!validateAuthority("", "", "btn_mSave")) {
	    		break;
	    	}
	   		formObj.f_cmd.value = MULTI05;
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("EES_CIM_0063GS.do", FormQueryString(formObj));
			ComOpenWait(false);
	
			if (ComGetEtcData(sXml,"RTNVAL") != "N"){
	       		// 저장 성공 메세지 출력
	       		ComShowMessage(msgs["CIM30019"]);
			} else {
				return true;
			}
			
			break;
        }
        return true;
    }

    function setBlInfo(bTmp, sXml){
    	var formObj = document.form;  
    	
    	with (formObj) {
    		if (bTmp) {
        		vvd.value = ComGetEtcData(sXml,"vvd");
        		vsl_nm.value = ComGetEtcData(sXml,"vsl_nm");
        		por.value = ComGetEtcData(sXml,"por");
        		pol.value = ComGetEtcData(sXml,"pol");
        		pol_etd.value = ComGetEtcData(sXml,"pol_etd");
        		pod.value = ComGetEtcData(sXml,"pod");
        		pod_eta.value = ComGetEtcData(sXml,"pod_eta");
        		del_cd.value = ComGetEtcData(sXml,"del_cd");
        		shpr.value = ComGetEtcData(sXml,"shpr");
        		cnee.value = ComGetEtcData(sXml,"cnee");
        		noti.value = ComGetEtcData(sXml,"noti");
        		frwd.value = ComGetEtcData(sXml,"frwd");
        		cmdt.value = ComGetEtcData(sXml,"cmdt");
        		uc_do_iss_dt.value = ComGetEtcData(sXml,"uc_do_iss_dt");
        		
        		if(ComGetEtcData(sXml,"prepaid")==null||ComGetEtcData(sXml,"prepaid")==""){
        			prepaid.value = ComAddComma2("0", "#,###.00");
        		}else{
        			prepaid.value = ComAddComma2(ComGetEtcData(sXml,"prepaid"), "#,###.00");
        		}
        		
        		if(ComGetEtcData(sXml,"collect")==null || ComGetEtcData(sXml,"collect")==""){
        			collect.value = ComAddComma2("0", "#,###.00");
        		}else{
        			collect.value = ComAddComma2(ComGetEtcData(sXml,"collect"), "#,###.00");
        		}
        		
        		prepaid.value = (allReplace(prepaid,",")*1).toFixed(2);
        		collect.value = (allReplace(collect,",")*1).toFixed(2);
    			
        		ComChkObjValid(pol_etd);
        		ComChkObjValid(pod_eta);
        		ComChkObjValid(uc_do_iss_dt);
        		
    		} else {
        		vvd.value = "";
        		vsl_nm.value = "";
        		por.value = "";
        		pol.value = "";
        		pol_etd.value = "";
        		pod.value = "";
        		pod_eta.value = "";
        		del_cd.value = "";
        		shpr.value = "";
        		cnee.value = "";
        		noti.value = "";
        		frwd.value = "";
        		cmdt.value = "";
        		prepaid.value = "";
        		collect.value = "";
        		uc_do_iss_dt.value = "";
    		}
    	}
     }     
	  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
     function initSheet(sheetObj,sheetNo) {
          var cnt = 0;
          switch (sheetObj.id) {
	        case 'sheet1': 
	     	     with(sheetObj){
		          // 높이 설정
	     		 style.height = 0;
		         
		         //전체 너비 설정
		         SheetWidth = mainTable.cleintWidth;
		
		         //Host정보 설정[필수][HostIp, Port, PagePath]
				 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		          //전체Merge 종류 [선택, Default msNone]
		          MergeSheet = msNone;
		
		          //전체Edit 허용 여부 [선택, Default false]
		          Editable = true;
		
		          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		          InitRowInfo( 1, 1, 3, 100);
		
		          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		          InitColumnInfo(86, 0, 0, true);          
		
		          // 해더에서 처리할 수 있는 각종 기능을 설정한다
		          InitHeadMode(true, true, true, true, false,false)
		
		          var HeadTitle = "|uc_cs_no|bl_no|uc_seq|hndl_rhq_cd|hndl_brnc_cd|hndl_hdlr_usr_id|hndl_upd_id|hndl_upd_dt|kntr_rhq_cd|kntr_brnc_cd|ntr_hdlr_usr_id|kntr_upd_id|kntr_upd_dt"
		        	  			+ "|uc_sts_cd|uc_ropn_flg|uc_ofc_trns_flg|cnee_uc_dt|uc_clz_dt|uc_dys|uc_dchg_dys|ctrt_ttl_vol_ctnt|uc_ctrt_rmk|uc_rsn_cd|uc_inv_amt|uc_inv_curr_cd|uc_inv_xch_rt"
		        	  			+ "|uc_inv_usd_amt|uc_crnt_amt|uc_crnt_curr_cd|uc_crnt_xch_rt|uc_crnt_usd_amt|uc_obl_hld_cd|uc_piclb_cd|uc_piclb_ref_no|uc_do_iss_dt|uc_disp_opt_cd|aban_ltr_shpr_dt"
		        	  			+ "|aban_ltr_cnee_dt|uc_cgo_loc_nm|uc_cgo_n1st_ntc_dt|uc_cgo_n2nd_ntc_dt|uc_cgo_n3rd_ntc_dt|uc_cgo_fnl_ntc_dt|uc_cgo_ntc_rmk|ots_oft_amt|ots_otr_amt|ots_dmdt_amt|ots_dmdt_dt"
		        	  			+ "|ots_sto_amt|ots_sto_dt|ots_otr_cost_amt|ots_otr_cost_dt|ots_rcvr_amt|ots_insur_cvr_amt|ots_rmk|fact_fnd_act_desc|hndl_ofc_opin_desc|kntr_ofc_opin_desc|cre_usr_id"
		        	  			+ "|cre_dt|upd_usr_id|upd_dt|vvd|por|pol|pod|del_cd|pol_etd|pod_eta|shpr|cnee|noti|frwd|cmdt|prepaid|collect|today|vsl_nm|uc_ctrt_ttl_vol|por_dt|del_dt|file_cnt|hndl_hdlr_usr_nm|kntr_hdlr_usr_nm|manager_memo"
		        	   			
		          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		          InitHeadRow(0, HeadTitle, true);
		
		          //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		          InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
		          
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cs_no",			  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"bl_no",			  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_seq",			  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_rhq_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_brnc_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_hdlr_usr_id",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_upd_id",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_upd_dt",		  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_rhq_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_brnc_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_hdlr_usr_id",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_upd_id",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_upd_dt",		  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_sts_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_ropn_flg",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_ofc_trns_flg",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cnee_uc_dt",		  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_clz_dt",	 	  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_dys",			  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_dchg_dys",		  	false,	"",	dfNone,	0,	false,	false);
		          
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ctrt_ttl_vol_ctnt",  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_ctrt_rmk",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_rsn_cd",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_inv_amt",		  	false,	"",	dfNullFloat,	2,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_inv_curr_cd",	  	false,	"",	dfNone,	0,	false,	false);    
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_inv_xch_rt",	  	false,	"",	dfNullFloat,	2,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_inv_usd_amt",	  	false,	"",	dfNullFloat,	2,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_crnt_amt",		  	false,	"",	dfNullFloat,	2,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_crnt_curr_cd",	  	false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_crnt_xch_rt",	  	false,	"",	dfNullFloat,	2,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_crnt_usd_amt",	  	false,	"",	dfNullFloat,	2,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_obl_hld_cd",	  	false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_piclb_cd",		  	false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_piclb_ref_no",	  	false,	"",	dfNone,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_do_iss_dt",		  	false,	"",	dfUserFormat,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_disp_opt_cd",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"aban_ltr_shpr_dt",	  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"aban_ltr_cnee_dt",	  	false,	"",	dfNone,	0,	false,	false);      
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_loc_nm",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_n1st_ntc_dt", 	false,	"",	dfUserFormat,	0,	false,	false);
		          
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_n2nd_ntc_dt", 	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_n3rd_ntc_dt", 	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_fnl_ntc_dt",  	false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_cgo_ntc_rmk",	  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_oft_amt",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_otr_amt",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_dmdt_amt",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_dmdt_dt",		 	 false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_sto_amt",	  		false,	"",	dfNone,	0,	false,	false);      
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_sto_dt",	  		false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_otr_cost_amt", 	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_otr_cost_dt", 		false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_rcvr_amt", 		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_insur_cvr_amt",  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"ots_rmk",	  			false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"fact_fnd_act_desc",	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_ofc_opin_desc",	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_ofc_opin_desc",	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cre_usr_id",		  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cre_dt",	  			false,	"",	dfUserFormat,	0,	false,	false);      
		          
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"upd_usr_id",	  		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"upd_dt", 				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"vvd", 					false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"por", 					false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"pol",  				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"pod",	  				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"del_cd",		  		false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"pol_etd",		  		false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"pod_eta",		  		false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"shpr",		  			false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cnee",	  				false,	"",	dfNone,	0,	false,	false);      
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"noti",	  				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"frwd", 				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"cmdt", 				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"prepaid", 				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"collect",  			false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"today",  				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"vsl_nm",  				false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"uc_ctrt_ttl_vol",  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"por_dt",		  		false,	"",	dfUserFormat,	0,	false,	false);  
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"del_dt",		  		false,	"",	dfUserFormat,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"file_cnt",  			false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"hndl_hdlr_usr_nm",  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"kntr_hdlr_usr_nm",  	false,	"",	dfNone,	0,	false,	false);
		          InitDataProperty(0,	cnt++,	dtData,			30,	daCenter,	true,	"manager_memo",      	false,	"",	dfNone,	0,	false,	false);
		          				  
				  //yyyy-mm-dd
				  InitUserFormat(0, "cre_dt", "####-##-##", "-");
				  InitUserFormat(0, "hndl_upd_dt", "####-##-##", "-");
				  InitUserFormat(0, "kntr_upd_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_cgo_n1st_ntc_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_cgo_n2nd_ntc_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_cgo_n3rd_ntc_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_cgo_fnl_ntc_dt", "####-##-##", "-");
				 
				  InitUserFormat(0, "cnee_uc_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_clz_dt", "####-##-##", "-");
				  InitUserFormat(0, "pol_etd", "####-##-##", "-");
				  InitUserFormat(0, "pod_eta", "####-##-##", "-");
				  InitUserFormat(0, "del_dt", "####-##-##", "-");
				  InitUserFormat(0, "por_dt", "####-##-##", "-");
				  InitUserFormat(0, "aban_ltr_shpr_dt", "####-##-##", "-");
				  InitUserFormat(0, "aban_ltr_shpr_dt", "####-##-##", "-");
				  InitUserFormat(0, "uc_do_iss_dt", "####-##-##", "-");
				  InitUserFormat(0, "ots_dmdt_dt", "####-##-##", "-");
				  InitUserFormat(0, "ots_sto_dt", "####-##-##", "-");
				  InitUserFormat(0, "ots_otr_cost_dt", "####-##-##", "-");
	     	}
	        break;
          }
     }

    function setSearchValue(sheetObj, formObj, index) {
    	var strTmp;
    	
		ComSetObjValue(formObj.uc_cs_no, 			sheetObj.CellValue(index, 'uc_cs_no'));
		ComSetObjValue(formObj.bl_no, 				sheetObj.CellValue(index, 'bl_no'));
		ComSetObjValue(formObj.uc_seq, 				sheetObj.CellValue(index, 'uc_seq'));
		ComSetObjValue(formObj.hndl_rhq_cd, 		sheetObj.CellValue(index, 'hndl_rhq_cd'));
		ComSetObjValue(formObj.hndl_brnc_cd, 		sheetObj.CellValue(index, 'hndl_brnc_cd')); 
		ComSetObjValue(formObj.hndl_hdlr_usr_id, 	sheetObj.CellValue(index, 'hndl_hdlr_usr_id'));
		// Handler 에 툴립으로 이름보여주기
		formObj.hndl_hdlr_usr_id.title=sheetObj.CellValue(index, 'hndl_hdlr_usr_nm');
		
		ComSetObjValue(formObj.hndl_upd_id, 		sheetObj.CellValue(index, 'hndl_upd_id'));
		ComSetObjValue(formObj.hndl_upd_dt, 		sheetObj.CellValue(index, 'hndl_upd_dt'));
		ComSetObjValue(formObj.kntr_rhq_cd, 		sheetObj.CellValue(index, 'kntr_rhq_cd'));
		ComSetObjValue(formObj.kntr_brnc_cd,		sheetObj.CellValue(index, 'kntr_brnc_cd'));
		ComSetObjValue(formObj.kntr_hdlr_usr_id, 	sheetObj.CellValue(index, 'kntr_hdlr_usr_id'));
		// Handler 에 툴립으로 이름보여주기
		formObj.kntr_hdlr_usr_id.title=sheetObj.CellValue(index, 'kntr_hdlr_usr_nm');

		ComSetObjValue(formObj.kntr_upd_id, 		sheetObj.CellValue(index, 'kntr_upd_id'));
		ComSetObjValue(formObj.kntr_upd_dt, 		sheetObj.CellValue(index, 'kntr_upd_dt'));
		ComSetObjValue(formObj.uc_sts_cd, 			sheetObj.CellValue(index, 'uc_sts_cd'));
		
		// 해당 UC Case No 에 첨부된 첨부 파일 갯수를 버튼에 보여준다.
		document.getElementById("btn_uc_activity").innerHTML = "File(" + sheetObj.CellValue(index, 'file_cnt') + ")"
				
		strTmp = sheetObj.CellValue(index, 'uc_ofc_trns_flg');
		if (strTmp == "Y") strTmp = "1"; else strTmp = "0";  
		formObj.chk_uc_ofc_trns_flg.checked = strTmp*1;
		
		ComSetObjValue(formObj.cnee_uc_dt, 			sheetObj.CellValue(index, 'cnee_uc_dt'));
		ComSetObjValue(formObj.uc_clz_dt, 			sheetObj.CellValue(index, 'uc_clz_dt'));
		ComSetObjValue(formObj.ctrt_ttl_vol_ctnt, 	sheetObj.CellValue(index, 'ctrt_ttl_vol_ctnt'));
		ComSetObjValue(formObj.uc_ctrt_ttl_vol, 	sheetObj.CellValue(index, 'uc_ctrt_ttl_vol'));
		ComSetObjValue(formObj.uc_ctrt_rmk, 		sheetObj.CellValue(index, 'uc_ctrt_rmk'));
		ComSetObjValue(formObj.uc_rsn_cd,			sheetObj.CellValue(index, 'uc_rsn_cd'));
		ComSetObjValue(formObj.uc_inv_amt, 			sheetObj.CellText(index, 'uc_inv_amt'));
		ComSetObjValue(formObj.uc_inv_curr_cd, 		sheetObj.CellValue(index, 'uc_inv_curr_cd'));
		ComSetObjValue(formObj.uc_inv_xch_rt, 		sheetObj.CellText(index, 'uc_inv_xch_rt'));
		
		ComSetObjValue(formObj.uc_inv_usd_amt, 		sheetObj.CellText(index, 'uc_inv_usd_amt'));
		ComSetObjValue(formObj.uc_crnt_amt, 		sheetObj.CellText(index, 'uc_crnt_amt'));
		ComSetObjValue(formObj.uc_crnt_curr_cd, 	sheetObj.CellValue(index, 'uc_crnt_curr_cd'));
		ComSetObjValue(formObj.uc_crnt_xch_rt, 		sheetObj.CellText(index, 'uc_crnt_xch_rt'));
		ComSetObjValue(formObj.uc_crnt_usd_amt, 	sheetObj.CellText(index, 'uc_crnt_usd_amt'));
		ComSetObjValue(formObj.uc_obl_hld_cd, 		sheetObj.CellValue(index, 'uc_obl_hld_cd'));
		ComSetObjValue(formObj.uc_piclb_cd, 		sheetObj.CellValue(index, 'uc_piclb_cd'));
		ComSetObjValue(formObj.uc_piclb_ref_no, 	sheetObj.CellValue(index, 'uc_piclb_ref_no'));
		ComSetObjValue(formObj.uc_do_iss_dt, 		sheetObj.CellValue(index, 'uc_do_iss_dt'));
		ComSetObjValue(formObj.uc_disp_opt_cd,		sheetObj.CellValue(index, 'uc_disp_opt_cd'));
		ComSetObjValue(formObj.aban_ltr_shpr_dt, 	sheetObj.CellValue(index, 'aban_ltr_shpr_dt'));
		ComSetObjValue(formObj.aban_ltr_cnee_dt, 	sheetObj.CellValue(index, 'aban_ltr_cnee_dt'));
		ComSetObjValue(formObj.uc_cgo_loc_nm, 		sheetObj.CellValue(index, 'uc_cgo_loc_nm'));
		
		ComSetObjValue(formObj.uc_cgo_n1st_ntc_dt, 	sheetObj.CellValue(index, 'uc_cgo_n1st_ntc_dt'));
		ComSetObjValue(formObj.uc_cgo_n2nd_ntc_dt, 	sheetObj.CellValue(index, 'uc_cgo_n2nd_ntc_dt'));
		ComSetObjValue(formObj.uc_cgo_n3rd_ntc_dt, 	sheetObj.CellValue(index, 'uc_cgo_n3rd_ntc_dt'));
		ComSetObjValue(formObj.uc_cgo_fnl_ntc_dt, 	sheetObj.CellValue(index, 'uc_cgo_fnl_ntc_dt'));
		ComSetObjValue(formObj.uc_cgo_ntc_rmk, 		sheetObj.CellValue(index, 'uc_cgo_ntc_rmk'));
		ComSetObjValue(formObj.ots_oft_amt, 		sheetObj.CellValue(index, 'ots_oft_amt'));
		ComSetObjValue(formObj.ots_otr_amt, 		sheetObj.CellValue(index, 'ots_otr_amt'));
		ComSetObjValue(formObj.ots_dmdt_amt, 		sheetObj.CellValue(index, 'ots_dmdt_amt'));
		ComSetObjValue(formObj.ots_dmdt_dt, 		sheetObj.CellValue(index, 'ots_dmdt_dt'));
		ComSetObjValue(formObj.ots_sto_amt,			sheetObj.CellValue(index, 'ots_sto_amt'));
		ComSetObjValue(formObj.ots_sto_dt, 			sheetObj.CellValue(index, 'ots_sto_dt'));
		ComSetObjValue(formObj.ots_otr_cost_amt, 	sheetObj.CellValue(index, 'ots_otr_cost_amt'));
		ComSetObjValue(formObj.ots_otr_cost_dt, 	sheetObj.CellValue(index, 'ots_otr_cost_dt'));
		
		ComSetObjValue(formObj.ots_rcvr_amt, 		sheetObj.CellValue(index, 'ots_rcvr_amt'));
		ComSetObjValue(formObj.ots_insur_cvr_amt, 	sheetObj.CellValue(index, 'ots_insur_cvr_amt'));
		ComSetObjValue(formObj.ots_rmk, 			sheetObj.CellValue(index, 'ots_rmk'));
		ComSetObjValue(formObj.fact_fnd_act_desc, 	sheetObj.CellValue(index, 'fact_fnd_act_desc'));
		ComSetObjValue(formObj.hndl_ofc_opin_desc,	sheetObj.CellValue(index, 'hndl_ofc_opin_desc'));
		ComSetObjValue(formObj.kntr_ofc_opin_desc, 	sheetObj.CellValue(index, 'kntr_ofc_opin_desc'));
		ComSetObjValue(formObj.cre_dt, 				sheetObj.CellValue(index, 'cre_dt'));
		ComSetObjValue(formObj.vvd, 				sheetObj.CellValue(index, 'vvd'));
		ComSetObjValue(formObj.vsl_nm, 				sheetObj.CellValue(index, 'vsl_nm'));
		ComSetObjValue(formObj.por, 				sheetObj.CellValue(index, 'por'));
		ComSetObjValue(formObj.pol, 				sheetObj.CellValue(index, 'pol'));

		ComSetObjValue(formObj.pod, 				sheetObj.CellValue(index, 'pod'));
		ComSetObjValue(formObj.del_cd, 				sheetObj.CellValue(index, 'del_cd'));
		ComSetObjValue(formObj.pol_etd, 			sheetObj.CellValue(index, 'pol_etd'));
		ComSetObjValue(formObj.pod_eta, 			sheetObj.CellValue(index, 'pod_eta'));
		ComSetObjValue(formObj.shpr, 				sheetObj.CellValue(index, 'shpr'));
		ComSetObjValue(formObj.cnee, 				sheetObj.CellValue(index, 'cnee'));
		ComSetObjValue(formObj.noti, 				sheetObj.CellValue(index, 'noti'));
		ComSetObjValue(formObj.frwd, 				sheetObj.CellValue(index, 'frwd'));
		ComSetObjValue(formObj.cmdt, 				sheetObj.CellValue(index, 'cmdt'));
		ComSetObjValue(formObj.manager_memo, 	    sheetObj.CellValue(index, 'manager_memo'));
		
		if(sheetObj.CellValue(index, 'prepaid')==null||sheetObj.CellValue(index, 'prepaid')==""){
			ComSetObjValue(formObj.prepaid, 			ComAddComma2("0", "#,###.00"));
		}else{
			ComSetObjValue(formObj.prepaid,				ComAddComma2(sheetObj.CellValue(index, 'prepaid'), "#,###.00"));
		}
		
		if(sheetObj.CellValue(index, 'collect')==null || sheetObj.CellValue(index, 'collect')==""){
			ComSetObjValue(formObj.collect, 			ComAddComma2("0", "#,###.00"));
		}else{
			ComSetObjValue(formObj.collect, 			ComAddComma2(sheetObj.CellValue(index, 'collect'), "#,###.00"));
		}

		// Date 형식 활성화	
		if (formObj.cnee_uc_dt.value.trim() != "") 			ComChkObjValid(formObj.cnee_uc_dt);
		if (formObj.uc_clz_dt.value.trim() != "") 			ComChkObjValid(formObj.uc_clz_dt);
		if (formObj.pol_etd.value.trim() != "") 			ComChkObjValid(formObj.pol_etd);
		if (formObj.pod_eta.value.trim() != "") 			ComChkObjValid(formObj.pod_eta);
		if (formObj.aban_ltr_shpr_dt.value.trim() != "") 	ComChkObjValid(formObj.aban_ltr_shpr_dt);
		if (formObj.aban_ltr_cnee_dt.value.trim() != "") 	ComChkObjValid(formObj.aban_ltr_cnee_dt);
		if (formObj.uc_do_iss_dt.value.trim() != "") 		ComChkObjValid(formObj.uc_do_iss_dt);
		if (formObj.ots_dmdt_dt.value.trim() != "") 		ComChkObjValid(formObj.ots_dmdt_dt);
		if (formObj.ots_sto_dt.value.trim() != "") 			ComChkObjValid(formObj.ots_sto_dt);
		if (formObj.ots_otr_cost_dt.value.trim() != "")		ComChkObjValid(formObj.ots_otr_cost_dt);
		
		if (formObj.cre_dt.value.trim() != "")				ComChkObjValid(formObj.cre_dt);
		if (formObj.hndl_upd_dt.value.trim() != "")			ComChkObjValid(formObj.hndl_upd_dt);
		if (formObj.kntr_upd_dt.value.trim() != "")			ComChkObjValid(formObj.kntr_upd_dt);
		if (formObj.uc_cgo_n1st_ntc_dt.value.trim() != "")	ComChkObjValid(formObj.uc_cgo_n1st_ntc_dt);
		if (formObj.uc_cgo_n2nd_ntc_dt.value.trim() != "")	ComChkObjValid(formObj.uc_cgo_n2nd_ntc_dt);
		if (formObj.uc_cgo_n3rd_ntc_dt.value.trim() != "")	ComChkObjValid(formObj.uc_cgo_n3rd_ntc_dt);
		if (formObj.uc_cgo_fnl_ntc_dt.value.trim() != "")	ComChkObjValid(formObj.uc_cgo_fnl_ntc_dt);
		
		// Outstanding Total Change& Cost, Net Loss 값 계산
		caculateOutstandingCost();
		
		// 2)O/Freight
		if (formObj.prepaid.value.trim() != "") 			ComChkObjValid(formObj.prepaid);
		if (formObj.collect.value.trim() != "") 			ComChkObjValid(formObj.collect);
		
		caculateDysFmDisch();
		
	}
     
     /**
      * Combo 기본 설정 param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에
      * 붙인 일련번호 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */ 
    function initCombo(comboObj, comboNo) {
    	var formObject = document.form;   

		switch(comboNo) {       
		case 1: 
			with (comboObj) {	
			       // UC Stats
				   SetColAlign("center|left");        
				   SetColWidth("100|200");         
				   DropHeight = 160;                         
			}   
			break;   
		case 2: 
			with (comboObj) { 
				   // UC Seq
				   SetColAlign("center");        
				   SetColWidth("80");         
				   DropHeight = 160; 
			}   
			break; 
		case 3: 
			with (comboObj) { 
				   // UC RSN CD
				   SetColAlign("left");        
				   SetColWidth("170");         
				   DropHeight = 160;
			}   
			break; 
				   
	   	case 4:
	   		with (comboObj) { 
	   			  // UC BL list
			      SetColAlign("left|left");        
			      SetColWidth("100|200");         
			      DropHeight = 320;                         
		    } 
   	        break;				   
	   	case 5:
	   		with (comboObj) { 
	   		// UC BL list
	   		SetColAlign("left|left");        
	   		SetColWidth("100|200");         
	   		DropHeight = 320;                         
   	   	     } 
	   	case 6:
	   		with (comboObj) { 
	   		// UC BL list
	   		SetColAlign("left|left");        
	   		SetColWidth("100|200");         
	   		DropHeight = 320;                         
	   	    } 
	   		break;				   
		 } 
    	
   	    switch(comboObj.name) {  
   	    	case "uc_sts_cd":
   	    		formObject.intg_cd.value = "CD03292";
				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
				break;
			 case "uc_rsn_cd":
				 formObject.intg_cd.value = "CD03293";
				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC02,comboObj);
				break;
			 case "uc_disp_opt_cd":
				 formObject.intg_cd.value = "CD03294";
				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC03,comboObj);
				break;
			 case "uc_obl_hld_cd":
				 formObject.intg_cd.value = "CD03296";
				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC04,comboObj);
				break;
			 case "uc_piclb_cd":
				 formObject.intg_cd.value = "CD03295";
				doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC05,comboObj);
				break;

// 아래는 조회후 연동됨
	   	    	case "uc_seq":  					  
//					doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
					break;
				 case "bl_no_lst":
//					doActionIBCombo(sheetObjects[0],formObject,IBSEARCH_ASYNC01,comboObj);
					break;
					
   	     }     	    
     }
     var onStsCdArrStr=""; // uc_sts_cd 권한에 따라 변해야 하기때문에 한번조회후 다시 조회 하지않기 위해 전역 변수로 선언해둔다.
     function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
         sheetObj.ShowDebugMsg = false;
		 sheetObj.WaitImageVisible = false;
         switch(sAction) {            					
	        case IBSEARCH_ASYNC01:    	        	
				formObj.f_cmd.value = SEARCH01;
	    	    var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj) );
				var sStr = ComGetEtcData(sXml, "comboList");    					
				    onStsCdArrStr = sStr.split("@");    					
				MakeComboObjectLocal(formObj.uc_sts_cd, onStsCdArrStr, 1, 0, 50,200); 		    	   
	    	    break;	    
	        case IBSEARCH_ASYNC02:    	
				formObj.f_cmd.value = SEARCH01;
	    	    var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml, "comboList");    					
				var arrStr = sStr.split("@");    					
				MakeComboObjectLocal(formObj.uc_rsn_cd, arrStr, 1, 0, 70, 280); 		    	   
	    	    break;	    
	        case IBSEARCH_ASYNC03:    	
				formObj.f_cmd.value = SEARCH01;
	    	    var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));    	    
				var sStr = ComGetEtcData(sXml, "comboList");    					
				var arrStr = sStr.split("@");    					
				MakeComboObjectLocal(formObj.uc_disp_opt_cd, arrStr, 1, 0, 50, 170 ); 		    	   
	    	    break;	    
	        case IBSEARCH_ASYNC04:    	
				formObj.f_cmd.value = SEARCH01;
	    	    var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml, "comboList");    					
				var arrStr = sStr.split("@");    					
				MakeComboObjectLocal(formObj.uc_obl_hld_cd, arrStr, 1, 0, 50, 170); 		    	   
	    	    break;	       
	        case IBSEARCH_ASYNC05:    	
				formObj.f_cmd.value = SEARCH01;
	    	    var sXml = sheetObj.GetSearchXml("EES_CIM_0063GS.do", FormQueryString(formObj));		    	    
				var sStr = ComGetEtcData(sXml, "comboList");    					
				var arrStr = sStr.split("@");    					
				MakeComboObjectLocal(formObj.uc_piclb_cd, arrStr, 1, 0, 70, 450); 		    	   
	    	    break;	    

	    	    
         }
		 sheetObj.WaitImageVisible = true;
      }

     /**
      * 콤보 오브젝트 생성(Spec No * Type/Size)
      */
     function MakeComboObjectLocal(cmbObj, arrStr, txtCol, codeCol, codeWdth, cmbObjWdth) {
 		 cmbObj.RemoveAll();
 		 cmbObj.InsertItem(0, "", "");
 		 
 		 var txtWdth;
 		 for (var i=0; i<arrStr.length; i++) {
 		    var arrCode = arrStr[i].split("|");
 			cmbObj.InsertItem(i+1, arrCode[codeCol] + '|' + arrCode[txtCol], arrCode[codeCol]);
 		 }
 		 cmbObj.Index2 = "" ;
 		 
 		 if (codeWdth != null && cmbObjWdth != null){
 			txtWdth = cmbObjWdth - codeWdth;
 			cmbObj.SetColWidth(codeWdth+""+"|"+txtWdth+"");
 			cmbObj.SetColAlign("center|left");
 		 }
 		 
     }
     	 
	  /**
	  * 기본 오브젝트 초기화 
	  */
	  function objectClear(){
		var formObj = document.form;
		var sheetObj  = sheetObjects[0];

		// 데이타 초기화
		sheetObj.RemoveAll();

		// 화면 초기화
		formObj.reset();
	  }

	  function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		     var sheetObj  = sheetObjects[0];
	         if (ErrMsg == "") {
	         } else {
	             sheetObj.EtcData("lot_no") = "";
	         }
		  }

		 /**
		  * 콤보필드에 데이터를 추가해준다.
		  */
		 function addComboItem(comboObj, comboItems) {
			  for ( var i = 0; i < comboItems.length; i++) {
		 		var comboItem = comboItems[i].split(",");
		 		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
		 	}
			  comboObj.InsertItem(0,"","");
		 } 
		 

function obj_change_seq(){ 
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var i =  formObj.uc_seq.text;

	formObj.bl_no_lst.index2 = i-1;
	setFormReset();
	setSearchValue(sheetObj, formObj, i);
}

function obj_change_bl(){ 
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var i =  formObj.bl_no_lst.index;

	formObj.uc_seq.index2 = i;
	
	setFormReset();
	i = i*1 + 1; 
	setSearchValue(sheetObj, formObj, i);
}

function obj_change_srchflg(){ 
	var formObj = document.form;
	setSearchMode(formObj.search_flg.checked);
	if (formObj.search_flg.checked) setFormReset("ALL");
}

function obj_change_reopen(){ 

	var formObj = document.form;
	
	if (formObj.chk_uc_ropn_flg.checked) {
		formObj.bk_uc_sts_cd.value = formObj.uc_sts_cd.Code;
		formObj.uc_sts_cd.Code = "OS";
		formObj.uc_ropn_flg.value = "Y";
	} else {
		formObj.uc_sts_cd.Code = formObj.bk_uc_sts_cd.value;
		formObj.uc_ropn_flg.value = "N";
	}	
}

function obj_change_reason(){ 
	
	var formObj = document.form;
	formObj.uc_rsn_desc.value = formObj.uc_rsn_cd.GetText(formObj.uc_rsn_cd.Code,1);
}

function obj_change_status(){ 
	if(isauthority!=0){
		if((form.uc_sts_cd.Code=="CL" || form.uc_sts_cd.Code == "CA")){
			document.form.kntr_brnc_cd.readOnly=false;
			document.form.kntr_hdlr_usr_id.readOnly=false;
			document.form.kntr_ofc_opin_desc.readOnly=false;
			form.uc_disp_opt_cd.Enable=true;				
		}
	}
}

/** 
 * 화면 초기화 함수
 * @author KIMHYUNJOO
 */  

function setFormReset(strOpt){
	//Combo reset
	var i
	if (strOpt == "ALL"){
		i = 0;
	}else{
		i = 3;
	}
	for(var i; i< comboObjects.length; i++){
		comboObjects[i].Index2 = -1;
	}
	
	// text 
	with (document.form){
		
		if (strOpt == "ALL"){
			// Master 부분
			uc_cs_no.value = "";
			 				
			uc_seq.value = ""; 			
			hndl_rhq_cd.value = ""; 		
			hndl_brnc_cd.value = ""; 		
			hndl_hdlr_usr_id.value = ""; 	
			hndl_upd_id.value = ""; 		
			hndl_upd_dt.value = ""; 		
			kntr_rhq_cd.value = ""; 		
			kntr_brnc_cd.value = "";		
			kntr_hdlr_usr_id.value = ""; 	
			kntr_upd_id.value = ""; 		
			kntr_upd_dt.value = ""; 		
			
			uc_sts_cd.value = ""; 			
			uc_ropn_flg.value = ""; 		
			uc_ofc_trns_flg.value = ""; 	
			cnee_uc_dt.value = ""; 		
			uc_clz_dt.value = ""; 			
			uc_dys.value = ""; 			
			uc_dchg_dys.value = ""; 	
			
			uc_ctrt_ttl_vol.value = "";
			uc_seq_ttl.value = "";
			uc_seq.RemoveAll();
			bl_no_lst.RemoveAll();
			
			document.getElementById("btn_uc_activity").innerHTML = "File"
			
			chk_uc_ropn_flg.checked = false;
			chk_uc_ofc_trns_flg.checked = false;
			
			frst_pod_eta.value = "";

		} 
		
		// Detail 부분
		bl_no.value = "";
		ctrt_ttl_vol_ctnt.value = "";
		cntr_list.value = "";
		
		uc_ctrt_rmk.value = ""; 		
		uc_rsn_cd.value = "";			
		uc_inv_amt.value = ""; 		
		uc_inv_curr_cd.value = ""; 	
		uc_inv_xch_rt.value = ""; 		
		
		uc_inv_usd_amt.value = ""; 	
		uc_crnt_amt.value = ""; 		
		uc_crnt_curr_cd.value = ""; 	
		uc_crnt_xch_rt.value = ""; 	
		uc_crnt_usd_amt.value = ""; 	
		uc_obl_hld_cd.value = ""; 		
		uc_piclb_cd.value = ""; 		
		uc_piclb_ref_no.value = ""; 	
		uc_do_iss_dt.value = ""; 		
		uc_disp_opt_cd.value = "";		
		aban_ltr_shpr_dt.value = ""; 	
		aban_ltr_cnee_dt.value = ""; 	
		uc_cgo_loc_nm.value = ""; 		
		
		uc_cgo_n1st_ntc_dt.value = ""; 
		uc_cgo_n2nd_ntc_dt.value = ""; 
		uc_cgo_n3rd_ntc_dt.value = ""; 
		uc_cgo_fnl_ntc_dt.value = ""; 	
		uc_cgo_ntc_rmk.value = ""; 	
		ots_oft_amt.value = ""; 		
		ots_otr_amt.value = ""; 		
		ots_dmdt_amt.value = ""; 		
		ots_dmdt_dt.value = ""; 		
		ots_sto_amt.value = "";		
		ots_sto_dt.value = ""; 		
		ots_otr_cost_amt.value = ""; 	
		ots_otr_cost_dt.value = ""; 	

		ots_total.value = ""; 	
		net_loss.value = ""; 	
		
		ots_rcvr_amt.value = ""; 		
		ots_insur_cvr_amt.value = ""; 	
		ots_rmk.value = ""; 			
		fact_fnd_act_desc.value = ""; 	
		hndl_ofc_opin_desc.value = "";	
		kntr_ofc_opin_desc.value = "";  	
		manager_memo.value = "";		// 2014.12.03 민정호
		cre_dt.value = ""; 			
		vvd.value = ""; 				
		vsl_nm.value = ""; 				
		por.value = ""; 
		por_dt.value = "";
		pol.value = ""; 				

		pod.value = ""; 				
		del_cd.value = "";
		del_dt.value = "";
		pol_etd.value = ""; 			
		pod_eta.value = ""; 			
		shpr.value = ""; 				
		cnee.value = ""; 				
		noti.value = ""; 				
		frwd.value = ""; 				
		cmdt.value = ""; 				
		prepaid.value = "";			
		collect.value = ""; 			
	}
	if (strOpt == "ALL"){
		//Sheet reset
		sheetObjects[0].RemoveAll();
	}
	
	
}

/** 
 * Search Mode/ Non Search Mode 별 Object 활성/비활성 설정
 * Search Mode/ Non Search MOde 구별은 formObj.search_flg.checked 값으로 구분한다.
 * @author KIMHYUNJO
 */  
function setSearchMode(strOpt){
	with (document.form){		
		if (strOpt){
			// true : Search Mode
			uc_cs_no.readOnly = false; 
			uc_cs_no.className = "input1";			
			bl_no.readOnly = false; 			
			ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_save");
			bl_no.enable = true;
			uc_sts_cd.Index2 = -1;
			
			ComBtnDisable("btn_uc_activity");
		} else {
			// false : Insert, Update Mode
			uc_cs_no.readOnly = true; 
			uc_cs_no.className = "input";
			ComBtnDisable("btn_retrieve");
			if (auth_cd.value == "R") {
				ComBtnDisable("btn_save");
			} else {
				ComBtnEnable("btn_save");	// "A","P","O" 권한은 저장은 가능하다
			}		
			bl_no.enable = false;
		}
	}
}

function setAddSequenceMode(bSet) {
	var formObj = document.form;
	if (bSet) {
		ComBtnEnable("btn_add_seq");
		ComBtnDisable("btn_del_seq");
	} else {
		//Add SEeq 버튼관련 비활성화
		ComBtnDisable("btn_add_seq");
		ComBtnEnable("btn_del_seq");
	}
	formObj.uc_seq.enable = bSet;
	formObj.bl_no_lst.enable = bSet;	
	formObj.bl_no.readOnly = bSet;
}




/** 
 * Login 한 User의 Operation권한 설정  <br>
 * Authority = "A" : All, "R" : ReadOnly, "P", Portion (3개 항목만 수정가능), "O" : Open (Reopen) 권한
 * @author KIMHYUNJOO
 */  

function setAuthority(){
	
	var formObj = document.form;
	
	var lgnUsrId = ComTrim(formObj.usr_id);
	var lgnUsrOfc = ComTrim(formObj.ofc_cd);
	var lgnRHQ = ComTrim(formObj.rhq_ofc_cd);
	var hndlOfc = ComTrim(formObj.hndl_brnc_cd);
	var hndlRHQ = ComTrim(formObj.hndl_rhq_cd);
	var cuntOfc = ComTrim(formObj.kntr_brnc_cd);
	var bTrns = formObj.chk_uc_ofc_trns_flg.checked;
	var strAuth;
	
	if ( lgnUsrOfc == hndlRHQ ) {
		strAuth = "O";
		formObj.auth_cd.value = strAuth;
		return;
	}
	if (!bTrns){
		switch (lgnUsrOfc){
		case hndlOfc:	// Handling Office 인 경우 : All 권한
			strAuth = "A";
			break;
		case cuntOfc:	// Counter Office 인 경우 : Portion 권한
			strAuth = "P";
			break;
		default:		// ReadOnly 권한
			strAuth = "R";
			break;
		}
		
	} else {
		switch (lgnUsrOfc){
		case cuntOfc:	// Counter Office 인 경우 : All 권한
			strAuth = "A";
			break;
		default:		// ReadOnly 권한
			strAuth = "R";
			break;		
		}
	}
	
	if(isauthority == 0){
		formObj.auth_cd.value = strAuth;
	}else{
		//관리자 일경우 모든 권한
		formObj.auth_cd.value = "A";
	}
}	

/** 
 * 조회된 데이타에 대한 유저 권한별 Operation 제한  <br>
 * @param  strOpt : Authority
 * @param  sAction : Validate Authority 생성 지점
 * @author KIMHYUNJOO 
 */  
function validateAuthority(strOpt, strMode, sAction){
	//	sAction : btn_save, btn_add_seq
	//  strOpt(유저권한)  		= "R" : ReadOnly, "P" : 3항목만 변경 가능권한, "A" : CRUD 모든 권한
	//  strMode(Operation 모드)	= "C" : CREATE, "U" : UPDATE, "A" : ADD , "R" : Search/Read
	var bTemp 
	var formObj = document.form;
	
	switch (sAction){
	case "btn_save":
		if (formObj.cntr_list.value == ""){
			ComShowMessage("Mandatory field is missing. Please enter [CNTR Vol].");
			return false;
		} 
	
		if (formObj.uc_sts_cd.Code == ""){
			ComShowMessage("Mandatory field is missing. Please enter [Status].");
			return false;
		} 
			
		if (strOpt == "R"){
			ComShowMessage("Current user does not have permission to save.");
			bTemp =  false;
		} 
		if (strOpt == "P"){
			
			//"P" 권한으로 신규 데이타 생성 ("C","A")시 오류발생
			if (strMode == "C" || strMode == "A") {
				ComShowMessage("Current user does not have permission to create new data.");
				bTemp = false;
			}
			
			// "P" 권한으로 Update 시 3개만 저장 가능하다는 사실을 인지 시킨다.
			if (ComShowConfirm("Current user has permission to save only three items(Counter Office-Branch/Agent, Handler, Counter Office Opinion). Do you want to save?")) {
				bTemp = true;	
			} else {
				bTemp = false;
			}
		} 
		if (strOpt == "O"){
			
			//"O" 권한으로 신규 데이타 생성 ("C","A")시 오류발생
			if (strMode == "C" || strMode == "A") {
				ComShowMessage("Current user does not have permission to create new data.");
				bTemp = false;
			}
			
			// "O" 권한으로 Reopen 만 가능하다.
			if (ComShowConfirm("Current user has permission to reopen only UC. Do you want to save?")) {
				bTemp = true;	
			} else {
				bTemp = false;
			}
		} 
		if (strOpt == "A"){
			bTemp = true;
		} 
		break;
	case "btn_add_seq":	
		if (strOpt != "A"){
			ComShowMessage("Current user does not have permission to create new data.");
			bTemp = false;
		} else{
			bTemp = true;
		} 
		break;
	case "btn_mSave":	
	      return bTemp = true;
		break;
	default:		
		bTemp = true;
		break;
	}
	return bTemp;
}




/** 
 * Form Object 활성 비활성  <br>
 * @param  strOpt : Authority
 * @param  sAction : Validate Authority 생성 지점
 * @author KIMHYUNJOO 
 */  
function allDisable (strOpt, strMode, sAction){

}

/** 
 * 어떤 Case 의 SAVE 인지 판별 
 * @return strMode : "C" : Create, "U" : Update, "A" : Add , "R" : Read 
 * @author KIMHYUNJOO
 */  
function getOperationMode(){
	
	var strMode;
	var formObj = document.form;
	
	// Case1_MULTI   : UC Case NO 가 없는 경우(신규저장)				=> Master : input, Detail : input    (CREATE)
	// Case1_MULTI01 : UC Case NO 가 있는 경우(기존 Seq 변경)  		=> Master : update, Detail : update  (UPDATE)
	// Case1_MULTI02 : UC Case NO 가 있는 경우(신규 Seq 추가/저장)  	=> Master : update, Detail input	 (ADD)

	if (formObj.search_flg.checked) {
		strMode = "R";		// Retrieve
	} else if (formObj.uc_seq.GetCount() == 0) {
		strMode = "C";		// Create
	} else if(ComIsBtnEnable("btn_add_seq")) {
		strMode = "U";		// Update
	} else {
		strMode = "A";		// Add
	}
	
	//2014.11.13 민정호
	if(ComTrim(formObj.uc_cs_no.value) != ""){
		if(isauthority != 0){
			
			//관리자 일경우 update 
			strMode = "U";		// Update
			formObj.auth_cd.value="A"

			
			if(ComIsBtnEnable("btn_add_seq") == false && ComIsBtnEnable("btn_del_seq")  == true){
				// 관리자도 입력 할 수 있다.
				if (formObj.search_flg.checked) {
					strMode = "R";		// Retrieve
				} else if (formObj.uc_seq.GetCount() == 0) {
					strMode = "C";		// Create
				} else if(ComIsBtnEnable("btn_add_seq")) {
					strMode = "U";		// Update
				} else {
					strMode = "A";		// Add
				}
			}				
		}
	}
	return strMode;
}

	function setControlHidden(){
 		if (!controlHidden){
 			document.all.subterms.style.display = "none";
 			controlHidden = true;
 		}else{
 			document.all.subterms.style.display = "inline";
 			controlHidden = false;
// 			sheet1_OnSearchEnd(sheetObjects[1], "");
 		}
 		try{
 		    parent.syncHeight();  // 펼쳤을때 화면하단 안보이는 문제 해결
 		}catch(e){}
 	}

/**
 * [Uncollected Cargo] - Booking Inquiry 팝업을 띄우는 함수 
*/
function openBookingInfoPopup() {
	var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+ document.form.bl_no.value;
	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, false);
}

/**
 * [Uncollected Cargo] - Charge Inquiry by Booking 팝업을 띄우는 함수 
*/
function openDemDetInfoPopup() {
	var sUrl  = "EES_DMT_3005.do?bkg_no="+ document.form.bl_no.value;
	ComOpenWindowCenter(sUrl, "EES_DMT_3005", 1030, 630, false);
}	   
	
	  /**
	    * [Uncollected Cargo] - UC Activity 팝업을 띄우는 함수 
	    * @param : uc_cs_no
	    * @param : uc_cgo_file_id
	    * @param : pIsReadOnly
	    */
	   function openUcActivityPopup(uc_cs_no, uc_cgo_file_id, pIsReadOnly) {
	   	var theURL = "EES_CIM_0066.do?uc_cs_no="+uc_cs_no+"&uc_cgo_file_id="+uc_cgo_file_id+"&is_read_only="+pIsReadOnly;
	   	var winName = "EES_CIM_0066";
	   	var features = "scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:550px";
	   	ComOpenWindow(theURL,winName,features,true); 
	   }


	   /**
	    * [Uncollected Cargo] - UC Help Exchange 팝업을 띄우는 함수 
	    * @param : exch_pop_gb
	    * @param : pIsReadOnly
	    */
	   function openHelpExchangePopup(exch_pop_gb, pIsReadOnly) {
	   	var theURL = "EES_CIM_0071.do?exch_pop_gb="+exch_pop_gb+"&is_read_only="+pIsReadOnly;
	   	var winName = "openHelpExchangePopup";
	   	var features = "scroll:no;status:no;help:no;dialogWidth:535px;dialogHeight:170px";
	   	ComOpenWindow(theURL,winName,features,true);
	   }   	

	   /**
	   * [Uncollected Cargo] - UC VOL_DTL 팝업을 띄우는 함수 
	   * @param : vol_dtl_gb
	   * @param : uc_cs_no
	   * @param : bl_no
	   * @param : pIsReadOnly
	   */
	   function openVolDtlPopup(vol_dtl_gb, uc_cs_no, bl_no, ctrt_ttl_vol_ctnt,cntr_list, pIsReadOnly) {
	   var theURL = "EES_CIM_0070.do?vol_dtl_gb="+vol_dtl_gb+"&uc_cs_no="+uc_cs_no+"&bl_no="+bl_no+"&ctrt_ttl_vol_ctnt="+ctrt_ttl_vol_ctnt+"&cntr_list="+cntr_list+"&is_read_only="+pIsReadOnly;
	   var winName = "EES_CIM_0070";
	   var features = "scroll:no;status:no;help:no;dialogWidth:300px;dialogHeight:500px";
	   ComOpenWindow(theURL,winName,features,true);
	   }

/* 개발자 작업  끝 */