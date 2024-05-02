/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0256.js
*@FileTitle : Unmatch B/L Inquiry by Auditor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
* 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.06.22 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.10.23 조정민 [CHM-201220701] [BKG/DOC - Revenue Audit System] Error B/L Inqjuiry, RDN Status Inquiry 기능에 GSO 검색조건 추가
* 2017.03.28 김동호 B/L Count 버튼 활성/비활성화 조건 추가(Radio Appl Date 선택시에만), B/L Count 조건 변경 (Appl Date 내 모든 firm 부킹 count)
* 2017.05.17 김동호 [CSR #792] B/L Count 버튼 활성/비활성화 조건 변경(Radio PCT 선택시에만), 
*                              B/L Count 조건 변경 (BKG모듈 Port Closing Status Report 메뉴 Total COUNT와 동일하게)
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
     * @class esm_bkg_0256 : esm_bkg_0256 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0256() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		    = setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl              = initControl;
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
    var sheet1;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var sheet1;
    
    var intervalId;
    var intervalTime = 2000;
    var processCnt = 0;
    var backEndType;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

     /**
	  * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     processButtonClick();
	  * </pre>
	  * @return 없음
	  * @author 이승준
	  * @version 2009.04.17
	  */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            	switch(srcName) {
	    	        case "btns_calendar1": //달력버튼
			        	var cal = new ComCalendar();
			        	cal.select(form.rt_aply_dt_from, 'yyyy-MM-dd');
			        	break;
		        
	    	        case "btns_calendar2":
				        var cal = new ComCalendar();
				        cal.select(form.rt_aply_dt_to, 'yyyy-MM-dd');
				        break;
				        
//					case "pol_popup":
//						ComOpenPopup("COM_ENS_051.do", 650, 440,"setPolCd", "1,0,1,1,1", false);
//						break;
            	
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
						break;
					
					case "btn_New":
						removeAll(formObject);
						break;
					
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;
					
					case "btn_DownExcel":						
						sheetObjects[1].Copy2SheetCol(sheetObjects[1],"bkg_contract","bkg_contract_bk");
						sheetObjects[1].Down2Excel(-1);
						resetUnMatchDetail();
						sheetObjects[1].SetMergeCell (0, 17, 2, 1);
						break;
				        
					case "btn_Filtered_Bl":
						
						//if (!validateForm(sheetObjects[1], formObject, IBSEARCH_ASYNC03)) { return false; }
				 		if (!validateForm(sheetObjects[1],formObject,IBSEARCH)) { return false; }
						
			        	try {
						
							ComOpenWait(true);			
							sheetObjects[0].WaitImageVisible = false;
							
			        		formObject.f_cmd.value = SEARCH02;
							var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0256GS.do", FormQueryString(formObject));
							var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
							if (backendJobKey.length > 0) {
								formObject.backendjob_key.value = backendJobKey;
								sheetObjects[0].RequestTimeOut = 10000;
								timer = setInterval(getBackEndJobStatus, 3000); // 3초 후에
																				// getBackEndJobStatus함수
																				// 실행 - 재귀호출
			    			}else{
			        			ComOpenWait(false);
			    			}
			        	}catch(e){
			        		ComShowMessage(e);
			    			ComOpenWait(false);
			        	}
					
						break;
						
					case "btn_ReAudit":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
						break;
					
					case "btn_Settle":
						doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
						break;
     				
					case "audit_seq_radio":
						obj_click();
						break;
						
					case "dt_type":
						var formObj  = document.form;
						var dt_type  = ComGetObjValue(formObj.dt_type[0]);
						
						if (dt_type == "PCT") {
							ComBtnEnable("btn_Filtered_Bl");
						} else {
							ComBtnDisable("btn_Filtered_Bl");
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
        
        /**
	   	  * BackEndJob 관련 Status='3' 이 될때까지 확인한다. <br>
	   	  * <br><b>Example :</b>
	   	  * <pre>
	   	  *     getBackEndJobStatus()
	   	  * </pre>
	   	  * @param 없음
	   	  * @return 없음
	   	  * @author 이승준
	   	  * @version 2009.04.17
	   	  */
        function getBackEndJobStatus() {
	   		try {
	        	var form = document.form;	
	        	form.f_cmd.value = SEARCH03;
	        	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0256GS.do", FormQueryString(form));
	        	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	        	if (jobState == "3") {
	        		getBackEndJobLoadFile();
	        		clearInterval(timer);
	        	} else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
	        		ComShowCodeMessage("BKG95019"); //msgs['BKG95019'] = 'Failed to download. Please try again.';
	        		clearInterval(timer);	
	        		ComOpenWait(false);	
	        	} else if (jobState == "5") {
	        		ComShowCodeMessage("BKG95020"); //msgs['BKG95020'] = 'Data was downloaded successfully.';
	        		clearInterval(timer);
	        		ComOpenWait(false);	
	        	}
	   		}catch(e){
	   			ComShowMessage(e);
	   			ComOpenWait(false);
	   		}
        }

        /**
	   	  * BackEndJob의 결과가 완료되면 Excel파일로 내려받음.(Request Expense Inital)<br>
	   	  * <br><b>Example :</b>
	   	  * <pre>
	   	  *     getBackEndJobLoadFile()
	   	  * </pre>
	   	  * @param 없음
	   	  * @return 없음
	   	  * @author 이승준
	   	  * @version 2009.04.17
	   	  */
        function getBackEndJobLoadFile() {
	   		try {	   		  
	        	var form = document.form;
	        	form.f_cmd.value = SEARCH04;
	        	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0256GS.do", FormQueryString(form));
	        	form.filtered_bkg_count.value = ComAddComma(ComGetEtcData(sXml, "RESULT"));
	   		}catch(e){
	   			ComShowMessage(e);
	   		}finally{        	
	   			ComOpenWait(false);        		
	   		}
        }

        /**
         * IBSheet Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setSheetObject(sheetObj);
         * </pre>
         * @param {ibsheet} sheet_obj 필수 IBSheet Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }

        /**
         * IBMulti Combo Object를 배열로 등록 <br>
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
         * 배열은 소스 상단에 정의 <br>
         * <br><b>Example :</b>
         * <pre>
         *     setComboObject(combo_obj);
         * </pre>
         * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */ 
        function setComboObject(combo_obj){
     		comboObjects[comboCnt++] = combo_obj;
     	}
        

        /**
         * Sheet 기본 설정 및 초기화 <br>
         * body 태그의 onLoad 이벤트핸들러 구현 <br>
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     loadPage();
         * </pre>
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function loadPage() {

        	sheet1 = sheetObjects[1];
        	sheet2 = sheetObjects[2]; 
        	sheet4 = sheetObjects[4]; 
        	
			//IBMultiCombo초기화
     	    for(var k = 0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }
     	    sheet1 = sheetObjects[1];
        	for(i=0;i<sheetObjects.length;i++){
				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i],i+1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
     		axon_event.addListenerForm('keypress', 'obj_keypress', document.form);
     	    axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
   		    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
   	        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');   		    
     	    
   	        // 김대호 Re Audit 테스트
   	        /*
   	        var form = document.form;
   	        form.rt_aply_dt_from.value = "2008-01-01";
   	        form.rt_aply_dt_to.value = "2009-12-31";
   	        form.rev_aud_sts_cd.Code = "";
   	        doActionIBSheet(sheet1,document.form,IBSEARCH);
   	        */
   	    
   	        doActionIBSheet(sheet2, form, IBSEARCH_ASYNC03);

   	        doActionIBSheet(sheet4, form, IBSEARCH_ASYNC04);
   	        
   	        var formObj    = document.form;
			var dt_type  = ComGetObjValue(formObj.dt_type[0]);
			
			if (dt_type == "PCT") {
				ComBtnEnable("btn_Filtered_Bl");
			} else {
				ComBtnDisable("btn_Filtered_Bl");
			}

    	}
        
         function sheet1_OnLoadFinish(sheetObj) {
// Error Status 칼럼을 강제로 Merge 시키는 Script 가 IBSheet Error 를 발생시켜서 임시로 막아둠.         	 
//        	 sheetObj.SetMergeCell (0, 20, 2, 2);
        	 initIBComboItem();
         } 
         
        
/** 
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.04
*/ 
function obj_keypress(){
	var obj = event.srcElement;
	var objName = obj.getAttribute("name");

 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //날짜 입력하기
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //숫자만 입력
 	case "number": //숫자만 입력 	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}         

/** 
* Object 의 Onbeforedeactivate 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.04
*/ 
function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
		case "vvd_cd":
		case "gso":
		case "bl_no":
			var vvdObj  = form.vvd_cd;
			var blNoObj = form.bl_no;
			var fmDtObj = form.rt_aply_dt_from;
			var toDtObj = form.rt_aply_dt_to;
			if(vvdObj.value.length == vvdObj.maxLength || blNoObj.value.length == blNoObj.maxLength){
				fmDtObj.className = "input";
				toDtObj.className = "input";
			}else{
				fmDtObj.className = "input1";
				toDtObj.className = "input1";
			}
			break;
		case "contract_no":
		case "por_cd":
		case "pol_cd":
		case "pod_cd":
		case "del_cd":
			break;
					
		default :
			ComChkObjValid(formObj);
	}
}

/**
 * OnBeforeActivate   event를 처리한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     obj_activate()
 * </pre>
 * @param 없음
 * @return 없음
 * @author 이승준
 * @version 2009.04.17
 */  
function obj_activate() {
	ComClearSeparator (event.srcElement);	   
}
     	
     	/**
         * IBSHEET COMBO를 LOAD하는 함수<br>
         * <br><b>Example :</b>
         * <pre>
         * 		initCombo(comboObj, comboNo)
         * </pre>
         * @return 없음
         * @author 이승준
         * @version 2009.06.10
         */ 
        function initCombo(comboObj, comboNo) {
            switch(comboObj.id) {
            
            case "rct_rhq_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;
                
            case "conti_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;   
                            
            case "rct_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;    
            
            case "bkg_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
                }
                break;      
                
            case "umch_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;          
                
            case "auto_rat_flg":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;  
                
            case "rev_aud_sts_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;    
            
            case "rev_aud_stl_knd_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);     // 영문만 입력 + 특수문자
                }
                break;       
                
            case "bdr_status_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 2);    // 영문만 입력 + 특수문자
                }
                break;    
    		case "chg_cd":
    			var i = 0;
    			with (comboObj) {
    				DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 3;      // 3자리만 입력
    			}
    			break;
            case "err_umch_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(2, 1);    // 영문대문자 + 숫자
                	MaxLength = 2;
                }
                break;   
            }
      	}
//        /**
//         * comboObjects[0]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getRctRhqCd();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getRctRhqCd() {
//      		return comboObjects[0].Code;
//      	}
//        /**
//         * comboObjects[2]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getBkgCtrtTpCd();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getBkgCtrtTpCd() {
//      		return comboObjects[2].Code;
//      	}
//        /**
//         * comboObjects[3]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getUmchTpCd();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getUmchTpCd() {
//      		return comboObjects[3].Code;
//      	}
//        /**
//         * comboObjects[4]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getAutoRatFlg();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getAutoRatFlg() {
//      		return comboObjects[4].Code;
//      	}
//        /**
//         * comboObjects[5]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getRevAudStsCd();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getRevAudStsCd() {
//      		return comboObjects[5].Code;
//      	}
//        /**
//         * comboObjects[6]의 code값을 리턴<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		var code = getRevAudStlKndCd();
//         * </pre>
//         * @return String <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function getRevAudStlKndCd() {
//      		return comboObjects[6].Code;
//      	}
//        
//        /**
//         * pol pop close 시 return value setting<br>
//         * <br><b>Example :</b>
//         * <pre>
//         * 		setPolCd(aryPopupData);
//         * </pre>
//         * @param String[][] aryPopupData
//         * @return 없음 <br>
//         * @author 이승준
//         * @version 2009.06.10
//         */
//        function setPolCd(aryPopupData) {
//        	//axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
//    		form.pol_cd.value = aryPopupData[0][3];
//    		//form.vsl_eng_nm.value = aryPopupData[0][3];
//    		//axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');			//Vessel Code 입력 후 Name정보 가져오기
//     		
//       	}
        
      
        /**
         * rct_rhq_cd 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function rct_rhq_cd_OnChange(comboObj, code, text) {
			
        	if(comboObj.Index == "0") {
 				comboObjects[1].removeAll();
 				return;
 			}
        	
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc2.value 	= code;
 				
 				// 조직도 combo2
 	        	formObj.f_cmd.value = COMMAND02;
 				var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
 				ComXml2ComboItem(sXml, comboObjects[1], "cd", "cd");
 				formObj.rct_ofc_cd.InsertItem(0,'','');
     		} 
     		
       	}
        
        
        /**
         * rev_aud_sts_cd 변경시 활성화됨<br>
         * qttn_ver_no로 조회한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		
         * </pre>
         * @param {comboObj} comboObj    필수,comboObj Object
         * @param {String} code    
         * @param {String} text 
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */ 
        function rev_aud_sts_cd_OnChange(comboObj, code, text) {
        		
     		if(comboObj.GetCount () > 0 && comboObj.Index != "-1") {
     			//settle
     			if(code == "S") {
     				document.form.rev_aud_stl_knd_cd.Index = "-1";
     				document.form.rev_aud_stl_knd_cd.Enable = true;
     			} else {
     				document.form.rev_aud_stl_knd_cd.Index = "-1";
     				document.form.rev_aud_stl_knd_cd.Enable = false;
     			}
     		} 
     		
       	}
                      
 /**
  * IBMultiCombo 에 Item을 setting한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *     initIBComboItem();
  * </pre>
  * @return 없음
  * @author 김대호
  * @version 2009.12.15
  */
function initIBComboItem() {
    ComBkgTextCode2ComboItem(rhqComboValue,          rhqComboValue,         getComboObject(comboObjects, 'rct_rhq_cd'),         "|", "\t" );
    ComBkgTextCode2ComboItem(scpComboValue,          scpComboValue,         getComboObject(comboObjects, 'svc_scp_cd'),         "|", "\t" );
    ComBkgTextCode2ComboItem(contiCdComboValue,		 contiCdComboText,      getComboObject(comboObjects, 'conti_cd'),	        "|", "\t" );
    ComBkgTextCode2ComboItem(contiCdComboValue,		 contiCdComboText,      getComboObject(comboObjects, 'conti_cd2'),	        "|", "\t" );
	ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(errorTypeComboValue,    errorTypeComboText,    getComboObject(comboObjects, 'umch_tp_cd'),         "|", "\t" );
	ComBkgTextCode2ComboItem(ratingTypeComboValue,   ratingTypeComboText,   getComboObject(comboObjects, 'auto_rat_flg'),       "|", "\t" );
    ComBkgTextCode2ComboItem(chargeCodeComboValue,   chargeCodeComboText,   getComboObject(comboObjects, 'chg_cd'),	            "|", "\t" );
	ComBkgTextCode2ComboItem(status1ComboValue,      status1ComboText,      getComboObject(comboObjects, 'rev_aud_sts_cd'),     "|", "\t" );
	ComBkgTextCode2ComboItem(status2ComboValue,      status2ComboText,      getComboObject(comboObjects, 'rev_aud_stl_knd_cd'), "|", "\t" );
	getComboObject(comboObjects, 'rev_aud_sts_cd').Code = 'U'; 
    
	document.form.bdr_status_cd.InsertItem(0,'','');
	document.form.bdr_status_cd.InsertItem(1,'Yes','Y');
	document.form.bdr_status_cd.InsertItem(2,'No','N');
	getComboObject(comboObjects, 'bdr_status_cd').Code = ''; 
}

        /**
         * 시트 초기설정값, 헤더 정의 <br>
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
         * <br><b>Example :</b>
         * <pre>
         *     initSheet(sheetObj,1);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function initSheet(sheetObj,sheetNo) {

        	var cnt = 0;
            var sheetID = sheetObj.id;
            switch(sheetID) {
            
        		case "sheet0":      //hidden 
    	             with (sheetObj) {
    	            	 // Host정보 설정[필수][HostIp, Port, PagePath]
    	 				 if (location.hostname != "")
    	 					InitHostInfo(location.hostname, location.port, page_path);
    											
    	             }
    	             break; 
        
        		case "sheet1":      //sheet1 init:      //sheet1 init
 	               with (sheetObj) {
 	
 	                   // 높이 설정
 	                   style.height = 300;
 	                   //전체 너비 설정
 	                   SheetWidth = mainTable.clientWidth;
 	
 	                   //Host정보 설정[필수][HostIp, Port, PagePath]
 	                   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
 	
 	                   //전체Merge 종류 [선택, Default msNone]
 	                   MergeSheet = msHeaderOnly;
 						//MergeSheet = msPrevColumnMerge + msHeaderOnly;
 	                   //MergeSheet = msAll;
 	
 	                   //전체Edit 허용 여부 [선택, Default false]
 	                   Editable = true;
 	
 	                   //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                   InitRowInfo(2, 1, 2, 100);
 	
 	                   var HeadTitle1 = "|Sel.|RHQ|Office|Scope|B/L No.|Appl. Date|POL ETD|T/VVD|Error\nSeq.|Error\nLapse|BDR\nStatus|POR|POL|POD|DEL|Contract\nType|Contract No.|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Non-\nRevenue|Revenue|Revenue|Revenue|Revenue|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nIssuance|RDN\nStatus|Error Status|Settle Type|Manual Settle\nRequest|Manual Settle\nRequest|Remarks\n(Office)|Remarks\n(Auditor)|Audit Amount\n(USD)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|PCT\n(Port Closing\nTime)|Audit Type|Settle Date|Settler ID|Settle\nPeriod|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|bdr_flg";
 	                   var HeadTitle2 = "|Sel.|RHQ|Office|Scope|B/L No.|Appl. Date|POL ETD|T/VVD|Error\nSeq.|Error\nLapse|BDR\nStatus|POR|POL|POD|DEL|Contract\nType|Contract No.|A1|A2|B|C|D|E|F|G|Error\nDetails|Error Charge|Diff Amount\n(USD)|Self Audit|RDN\nIssuance|RDN\nStatus|Error Status|Settle Type|Sel.|Kind|Remarks\n(Office)|Remarks\n(Auditor)|Audit Amount\n(USD)|Rater ID|Sales Rep.|BDR Date|Audit Date\n(Initial)|Audit Date\n(Update)|PCT\n(Port Closing\nTime)|Audit Type|Settle Date|Settler ID|Settle\nPeriod|bkg_no|ctrt_tp_cd|Error Details|rev_aud_sts_cd|bdr_flg";
 	                   var headCount = ComCountHeadTitle(HeadTitle1);
 	
 	                   //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                   InitColumnInfo(headCount, 0, 0, true);
 	
 	                   // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                   InitHeadMode(true, true, true, true, false, false);
 	
 	                   //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                   InitHeadRow(0, HeadTitle1, true);
 	                   InitHeadRow(1, HeadTitle2, true);
 	
 	                   //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 						//InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, 	false,	"ibflag");
 	                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter, 	false,	"ibflag");
 						InitDataProperty(0, cnt++ , dtDummyCheck,	40,	daCenter,	true,	"chk",					false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"rct_rhq_cd",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"bkg_ofc_cd",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"svc_scp_cd",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtPopup,	    120,daCenter,	true,	"bl_no",				false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtData,			65,	daCenter,	true,	"rt_aply_dt",			false,	"",  dfDateYmd,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			65,	daCenter,	true,	"pol_etd",			false,	"",  dfDateYmd,	0,	false    ,false );	
 						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"vvd_cd",				false,	"",  dfNone,	0,	false    ,false );

 						InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	"umch_bkg_seq",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true,	"error_lapse",		    false,	"",  dfNone,	0,	false    ,false ); //4. 추가
 						InitDataProperty(0, cnt++ , dtData,			60, daCenter,	true,	"bdr_flg",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"por_cd",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"pol_cd",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"pod_cd",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"del_cd",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,	        70, daCenter,	true,	"ctrt_tp_cd",	        false,	"",  dfNone,	0,	false     ,false ); //2. 추가
 						InitDataProperty(0, cnt++ , dtPopup,	    100,daCenter,	true,	"sc_rfa_no",			false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_al",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_all",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_b",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_c",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_d",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_e",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_f",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtImageText,	25,	daCenter,	false,	"umch_g",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtPopup,	    70, daLeft,		true,	"bkg_contract_bk",		false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtData,	    	200, daLeft,	true,	"err_chg",				false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtPopup,	    100,daRight,	true,	"diff_usd_amt",			false,	"",  dfFloat,	2,	true     ,true );
 						InitDataProperty(0, cnt++ , dtPopup,	    70, daRight,	true,	"self_audit",			false,	"",  dfFloat,	2,	true     ,true ); //1. 추가
 						
 						InitDataProperty(0, cnt++ , dtPopup,	    100,daCenter,	true,	"rdn_no",				false,	"",  dfNone,	0,	true     ,true );
 						InitDataProperty(0, cnt++ , dtData,		    75, daCenter,	true,	"rdn_status",		    false,	"",  dfNone,	0,	false    ,false ); //5. 추가
 						InitDataProperty(0, cnt++ , dtData,		    100,daCenter,	true,	"rev_aud_sts_nm",		false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"rev_aud_stl_knd_nm",	false,	"",  dfNone,	0,	false    ,false );
 						
 						InitDataProperty(0, cnt++ , dtCheckBox,		40, daCenter,	true,	"mnl_stl_rqst_flg",		false,	"",  dfNone,	0,	false    ,false,   -1, 	false,	true, "",	false ); 						
 						InitDataProperty(0, cnt++ , dtCombo,	    100,daCenter,	true,	"mnl_stl_tp",		    false,	"",  dfNone,	0,	true    ,true );
 						InitDataProperty(0, cnt++ , dtData,			200,daLeft,		true,	"umch_rsn_rmk",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			200,daLeft,		true,	"rgn_grp_avc_rmk",		false,	"",  dfNone,	0,	true    ,true );
 						InitDataProperty(0, cnt++ , dtData,         120,daRight,    true,   "rev_aud_amt",          false,  "",  dfFloat,   2,  true    ,true );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rater_id",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"srep_cd",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"bdr_dt",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"n1st_umch_fnd_dt",		false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true,	"lst_umch_fnd_dt",		false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"port_clz_dt",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true,	"rev_aud_tp_nm",		false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80, daCenter,	true,	"upd_dt",				false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"upd_usr_id",			false,	"",  dfNone,	0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"stl_prd",				false,	"",  dfNone,	0,	false    ,false );

 						InitDataProperty(0, cnt++ , dtHidden, 		50, daLeft,     false, 	"bkg_no",     			false,  "", dfNone,     0,  false    ,false );
 		       			InitDataProperty(0, cnt++ , dtHidden, 		50, daLeft, 	false,  "ctrt_tp_cd", 			false,  "", dfNone, 	0,  false    ,false );
 		       			InitDataProperty(0, cnt++ , dtHidden,	    50, daLeft,		false,	"bkg_contract",			false,  "", dfNone, 	0,  false    ,false );
 						InitDataProperty(0, cnt++ , dtHidden,	    50,	daLeft,	    false,	"rev_aud_sts_cd",		false,	"", dfNone,	    0,	false    ,false );
 						InitDataProperty(0, cnt++ , dtHidden,	    50,	daLeft,	    false,	"bdr_flg",		false,	"", dfNone,	    0,	false    ,false );
 						//InitDataProperty(0, cnt++ , dtHidden,	    50,	daLeft,	    false,	"conti_cd",		false,	"", dfNone,	    0,	false    ,false );//추가
 						ShowButtonImage = 2;
 						AutoRowHeight = false;	
 						FrozenCols = 6;
 						
 		       			ImageList("myImage1") = "img/btns_search.gif";
 		       			CellImage(0, 18) = "myImage1";                     /*IMAGE 위치 Y축 하나씩 증가시킴*/
 		       			CellImage(0, 19) = "myImage1";
 		       			HeaderImageAlign(0,16) = daRight;
 		       			HeaderImageAlign(0,20) = daRight; 
 		       			
 		                UnEditableColor = RgbColor(255,255,255);                    
 		       			 						
 	//       			SelectHighLight = false;
 	              }
 	               break;
 	               
        		case "sheet2": // 콤보용
        	  		with (sheetObj) {
        		
        	            //높이 설정
        	            style.height = 100;
        	            //전체 너비 설정
        	            SheetWidth = 300;
        	            //Host정보 설정[필수][HostIp, Port, PagePath]
        	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        	            //전체Merge 종류 [선택, Default msNone]
        				MergeSheet = msHeaderOnly;
        	            //전체Edit 허용 여부 [선택, Default false]
        	            Editable = true;
        	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        	            InitRowInfo(1, 1, 2, 100);
        	            var HeadTitle1 = "Seq.|chg_cd|chg_nm|rep_chg_cd"
        	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
        	            //해더에서 처리할 수 있는 각종 기능을 설정한다
        	            InitHeadMode(true, true, false, true, false, false);
        	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        	            InitHeadRow(0, HeadTitle1, true);
        	            
				        //데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME      ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
				        InitDataProperty(0 ,cnt++ ,dtDataSeq,40	  ,daCenter ,false   ,"seq"                                           );            
				        InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"chg_cd"      ,false   ,""        ,dfNone    ,0 );
				        InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"chg_nm"      ,false   ,""        ,dfNone    ,0 );
				        InitDataProperty(0 ,cnt++ ,dtData   ,50   ,daLeft   ,false   ,"rep_chg_cd"  ,false   ,""        ,dfNone    ,0 );
        	            
        			}
        			break;
        			
        		case "sheet4": // 콤보용
        	  		with (sheetObj) {
        	            //높이 설정
        	            style.height = 180;
        	            //전체 너비 설정
        	            SheetWidth = 210;
        	            //Host정보 설정[필수][HostIp, Port, PagePath]
        	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        	            //전체Merge 종류 [선택, Default msNone]
        				MergeSheet = msHeaderOnly;
        	            //전체Edit 허용 여부 [선택, Default false]
        	            Editable = false;
        	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
        	            InitRowInfo(1, 1, 3, 100);
        	            var HeadTitle1 = "Error Kind|Description|Type";
        	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
        	            //해더에서 처리할 수 있는 각종 기능을 설정한다
        	            InitHeadMode(true, true, false, true, false, false);
        	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
        	            InitHeadRow(0, HeadTitle1, true);
        	            
				        //데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME      ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
        	            InitDataProperty(0 ,cnt++ ,dtData       ,20     ,daCenter	 ,false     ,"umch_tp_cd"  	    ,false ,""          ,dfNone           ,0);                                                                                                        
        	            InitDataProperty(0 ,cnt++ ,dtData       ,150    ,daCenter    ,false     ,"umch_tp_desc"     ,false ,""          ,dfNone           ,0);
        	            InitDataProperty(0 ,cnt++ ,dtData       ,40     ,daCenter    ,false     ,"rev_umch_clss_nm" ,false ,""          ,dfNone           ,0);
        	            
        			}
        			break;

            }
        }


        /**
         * Sheet관련 프로세스 처리 <br>
         * <br><b>Example :</b>
         * <pre>
         *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {form} formObj 필수 html form object
         * @param {int} sAction 필수 프로세스 플래그 상수
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
        	 
            sheetObj.ShowDebugMsg = false;
            
			var form = document.form;
			
			var chkRows = sheet1.FindCheckedRow("chk");
			var arrRow = chkRows.split("|");
			var arrLen = arrRow.length - 1;
            
            switch(sAction) {
              
            	case IBSEARCH:      //조회
            		
            		if (!validateForm(sheetObj,formObj,sAction)) { return false; }
            			
        			formObj.f_cmd.value = SEARCH01;

        			setAuditSeqCd(formObj);
        			
    	    		ComOpenWait(true);
    	    		sheetObj.WaitImageVisible = false;

        			var sXml = sheetObj.GetSearchXml("ESM_BKG_0256GS.do" , FormQueryString(formObj));
        			sheetObj.LoadSearchXml(sXml);    // Grid1.
        			
    				ComOpenWait(false);        		
                    	
            	    break;
            		
    			case IBSAVE:        //저장
    				
	    			if(!sheet1.IsDataModified) {
	    	  			ComShowCodeMessage("BKG95005");
	    			    return false;
	    	  		}

	 				if (!ComShowCodeConfirm("BKG95003", "save Remarks & audit amount")) { return false; }
	 				
	 				formObj.f_cmd.value = MULTI02;
	 	   			
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheet1.GetSaveString();
					
	    			if("" == sParamSheet1) {
	    	  			ComShowCodeMessage("BKG95005");
	    			    return false;
	    	  		}
	    	  		
					sParam += "&" + sParamSheet1;
					
		    		ComOpenWait(true);
					
					var sXml = sheet1.GetSaveXml("ESM_BKG_0256GS.do", sParam);
					sheet1.LoadSaveXml(sXml);
		 			
					ComOpenWait(false);        		

					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG95033"); // "Saved."
						doActionIBSheet(sheet1,document.form,IBSEARCH);
					}
					
	        		break;
	        		
	        	
    			case IBSEARCH_ASYNC01:        //settle

	    	  		//체크된 항목이 없으면
	    	  		if(arrLen < 1) {
	    	  			ComShowCodeMessage("BKG95031", "the Error B/L that you want to settle manually");
	    			    return false;
	    	  		}
	    	  		
	    	  		for(var i=2; i<= sheet1.RowCount+2; i++){
	    				
	    				if(sheet1.CellValue(i, "chk") == "1"){		
	    					if(sheet1.CellValue(i, "mnl_stl_tp") == "" ){
	    						
	    						ComShowCodeMessage("BKG06174");  //Please select Manual Settle Kind.
	    						return false;
	    					}
	    				}
	    			}
	 				
	 				if (!ComShowCodeConfirm("BKG95003", "settle the Error manually")) { return; }
	 				
	 				
	 				
	 				formObj.f_cmd.value = MULTI02;
	 	   			
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheet1.GetSaveString();
					
	    			if("" != sParamSheet1) {
	    				sParam += "&" + sParamSheet1;						
			    		ComOpenWait(true);
						
						var sXml = sheet1.GetSaveXml("ESM_BKG_0256GS.do", sParam);
						sheet1.LoadSaveXml(sXml);
	    	  		}
					
					
	 				
	 				formObj.f_cmd.value = MULTI04;
	 				backEndType = 'settle';
	 				
	 				var bkgNoArrObj = form.bkg_no_arr;
					bkgNoArrObj.value = "";
					var rowIdx, bkgNo, bkgNoStr = "";
					for(var idx = 0; idx < arrLen; idx++){
						bkgNo = sheet1.CellValue(arrRow[idx], "bkg_no");
						if(idx ==0) {
							bkgNoStr = bkgNo; 
						}else{
							bkgNoStr = bkgNoStr + "|" + bkgNo;
						}
					}
					bkgNoArrObj.value = bkgNoStr;
	 	   			
					var sParam = FormQueryString(formObj);
					var sParamSheet1 = sheet1.GetSaveString(false, true, "chk");
					
					sParam += "&" + sParamSheet1;
										
		    		ComOpenWait(true);
		    		
					var sXml = sheet1.GetSaveXml("ESM_BKG_0256GS.do", sParam);     		
					
					var arrXml = sXml.split("|$$|");
					if (ComGetEtcData(arrXml[0], "jobID")) {
						ComSetObjValue(formObj.backendjob_key, ComGetEtcData(arrXml[0], "jobID"));
						
			            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
					} else {  //backendJob 호출 실패
						ComOpenWait(false);
					}
					
	        		break;
	        		
    			case IBSEARCH_ASYNC02: // Re Audit
    			
					if (arrLen < 1) {
						ComShowCodeMessage("BKG95028"); // "Please select the B/L that you want to audit again."
						return false;
					}
					
					if (ComShowCodeConfirm("BKG95029")) { // "Do you want to execute Re-Audit?"
						
						var bkgNoArrObj = form.bkg_no_arr;
						bkgNoArrObj.value = "";
						var rowIdx, bkgNo, bkgNoStr = "";
						for(var idx = 0; idx < arrLen; idx++){
							bkgNo = sheet1.CellValue(arrRow[idx], "bkg_no");
							if(idx == 0) {
								bkgNoStr = bkgNo; 
							}else{
								bkgNoStr = bkgNoStr + "|" + bkgNo;
							}
						}
						bkgNoArrObj.value = bkgNoStr;
						form.f_cmd.value = MULTI03;
						backEndType = 'reaudit';
						var params = FormQueryString(formObj);

						ComOpenWait(true);

			    		var sXml = sheet1.GetSaveXml("ESM_BKG_0256GS.do", params);
			    		
			    		var arrXml = sXml.split("|$$|");
						if (ComGetEtcData(arrXml[0], "jobID")) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(arrXml[0], "jobID"));
							
				            intervalId = setInterval(callIntervalBackEndJob, intervalTime);
						} else {  //backendJob 호출 실패
							ComOpenWait(false);
						}
						
					}
					
	        		break;
	        		
	        		
	       			case IBSEARCH_ASYNC03:
	       				
	       					sheetObjects[2].ShowDebugMsg = false;
	        	        	gXml = sheetObjects[2].GetSearchXml("RASCommonGS.do?", "f_cmd=" + COMMAND12);
	        				ComXml2ComboItem(gXml, formObj.mnl_stl_tp_cd, "mnl_stl_tp_cd", "cd|nm|etc1");
	        				formObj.mnl_stl_tp_cd.InsertItem(0, "", "");
	        				

	        				var arrCombo = ComXml2ComboString(gXml, "etc2", "cd");
	        				sheetObjects[1].InitDataCombo(0, "mnl_stl_tp", arrCombo[0], arrCombo[1]);
	        				
    				break;
    				
	       			case IBSEARCH_ASYNC04:

	       				sheetObjects[4].ShowDebugMsg = false;
        	        	gXml = sheetObjects[4].GetSearchXml("ESM_BKG_1055GS.do?", "f_cmd=" + SEARCH);
        				ComXml2ComboItem(gXml, comboObjects[12], "umch_tp_cd", "umch_tp_cd|umch_tp_desc|rev_umch_clss_nm");
        				formObj.err_umch_tp_cd.InsertItem(0, "", "");
//        				sheetObjects[2].LoadSearchXml(gXml);
        				break;
    				
	       			case SEARCH05:

	    		    	ComSetObjValue(formObj.f_cmd,SEARCH05);
	    		    	params = FormQueryString(formObj);
	    		    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0256GS.do", params);
	    		    	var arrXml = sXml.split("|$$|");
	    				var jobState = ComGetEtcData(arrXml[0], "jb_sts_flg");
	    				if ("3"==jobState) {  // BackEndJob 성공
	    					clearInterval(intervalId);
	    		            doActionIBSheet(sheetObjects[1], document.form, SEARCH06);  // BackEndJob 결과 조회
	    				} else if ("4"==jobState) {  // BackEndJob 실패
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					if(backEndType == 'reaudit'){
	    						ComShowCodeMessage("BKG00110", "Re-Audit");
	    					}else if(backEndType == 'settle'){
	    						ComShowCodeMessage("BKG00110", "Manual Settle");
	    					}  

	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else if ("5"==jobState) {  // 이미 BackEndJob 결과 파일을 읽었습니다.
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				}
	       				break;
	       				
	    	    	case SEARCH06: // BackEndJob 결과 조회
	    		    	ComSetObjValue(formObj.f_cmd,SEARCH06);
	    		    	params = FormQueryString(formObj);
	    		    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0256GS.do", params);
	    		    	var arrXml = sXml.split("|$$|");
	    		    	if ("Y"==ComGetEtcData(arrXml[0], "result")) {
	    		    		clearInterval(intervalId);
	    					ComOpenWait(false);
	    					
	    					if(backEndType == 'reaudit'){
	    						ComShowCodeMessage("BKG95030");
	    					}else if(backEndType == 'settle'){
	    						ComShowCodeMessage("BKG95032");
	    					}
	    					
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else if ("N"!=ComGetEtcData(arrXml[0], "result")) {  // BackEndJob 9분30초 경과
	    					ComShowMessage(ComGetEtcData(arrXml[0], "result"));
	    					ComOpenWait(false);
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				} else { // Re-audit 중 Exception 발생
	    					clearInterval(intervalId);
	    					ComOpenWait(false);
	    					
	    					if(backEndType == 'reaudit'){
	    						ComShowCodeMessage("BKG00110", "Re-Audit");
	    					}else if(backEndType == 'settle'){
	    						ComShowCodeMessage("BKG00110", "Manual Settle");
	    					}   
	    					
	    					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	    				}
	    		    	break;
            }
            
        }


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 이승준
 * @version 2009.04.17
 */
function validateForm(sheetObj, formObj, sAction){
	 var form = document.form;
	 switch (sAction) {
  
	 	case IBSEARCH: // 조회
	 		
	 		var isChkDt = true;
	 		var vvdObj  = form.vvd_cd;
	 		var blNoObj = form.bl_no;
	 		var fmDtObj = form.rt_aply_dt_from;
	 		var toDtObj = form.rt_aply_dt_to;
	 		var fmDtValue = fmDtObj.value.replace(/-/g, "");
	 		var toDtValue = toDtObj.value.replace(/-/g, "");
	 		
 			if(!ComChkObjValid(fmDtObj)) { return false; }	 			
 			if(!ComChkObjValid(toDtObj)) { return false; }
		
 			if("O" == form.err_umch_tp_cd.text){
 				ComShowCodeMessage("BKG95025", "error kind except Other (H/O Use)"); // "Please input {?msg2}."
				return false;
 			}
 			
	 		if("" == vvdObj.value && "" == blNoObj.value && ("" == fmDtValue || "" == toDtValue)) {
				 ComShowCodeMessage("BKG95025", "Audit Date(Update) or T/VVD or B/L No"); // "Please input {?msg2}."
				 if("" == fmDtObj.value) {
					 ComSetFocus(fmDtObj);
				 }else{
					 ComSetFocus(toDtObj);
				 }
				 return false;
	 		}
	 		
			if(vvdObj.value.length == vvdObj.maxLength || blNoObj.value.length == blNoObj.maxLength){
				isChkDt = false;
			}else{
				isChkDt = true;
			}
	 		
 			if(isChkDt){
 		 		if("" == fmDtValue || "" == toDtValue){
 					 ComShowCodeMessage("BKG95025", "Audit Date(Update)"); // "Please input {?msg2}."
 					 if("" == fmDtValue){
 	 					 ComSetFocus(fmDtObj);
 					 }else{
 	 					 ComSetFocus(toDtObj);
 					 }
 					 return false;
 		 		}
	 		}

 			if( "" != fmDtValue && "" != toDtValue && ( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) ) {
				 ComShowCodeMessage("BKG95026", "From Date", "To Date");
				 ComSetFocus(fmDtObj);
				 return false;
	 		}
 			
 			if(isChkDt){
 	 			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 99, "", true);
 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
 	 				ComShowCodeMessage("BKG95027", "100 days"); // "The period of Date can't be over {?msg1}."
 	 				ComSetFocus(fmDtObj);
 	 				return false;
 	 			}
 			}
 			
			return true;
			break;

	 	case IBSEARCH_ASYNC03: // bl count
	 		
			if(!ComChkObjValid(formObj.rt_aply_dt_from)) { return false; }
			if(!ComChkObjValid(formObj.rt_aply_dt_to)) { return false; }
			
			var vvdObj = formObj.vvd_cd;
			if( !ComIsEmpty(vvdObj.value) && (vvdObj.value.length != vvdObj.maxLength) ) {
				ComShowCodeMessage("BKG95018", vvdObj.caption, vvdObj.maxLength);
 				ComSetFocus(vvdObj);
				return false;
			}

			return true;
			break;
			
	 }

}

       /** 
        * sheet1 팝업연결 선택시 발생하는 sheet1_OnPopupClick 이벤트핸들러 <br>
        * <br><b>Example :</b>
        * <pre>
        * </pre>
        * @param  {IBSheet} sheetObj : 시트오브젝트  
        * @param  {Long} Row : 해당 셀의 Row Index
        * @param  {Long} Col : 해당 셀의 Column Index
        * @return  
        * @see #
        * @author 김대호
        * @version 2010.01.20
        */
    	function sheet1_OnPopupClick(sheetObj, Row, Col) {

    		var form  = document.form;

			var sName      = sheet1.ColSaveName(Col);
        	var scRfaNo    = sheet1.CellValue(Row, "sc_rfa_no");			
			var ctrtTpCd   = sheet1.CellValue(Row, "ctrt_tp_cd");
			var blNo 	   = sheet1.CellValue(Row, "bl_no");    			
			var bkgNo 	   = sheet1.CellValue(Row, "bkg_no");
			var umchBkgSeq = sheet1.CellValue(Row, "umch_bkg_seq");
			var rdnNo      = sheet1.CellValue(Row, "rdn_no");
			var rctRhqCd   = sheet1.CellValue(Row, "rct_rhq_cd");
			var rctOfcCd   = sheet1.CellValue(Row, "bkg_ofc_cd");
			
			switch(sName) {
			
    			case "sc_rfa_no":
    	        	if(null == scRfaNo || "" == scRfaNo) { return; }
    	        	
    	    		var pgmNo = "ESM_PRI_0004";
    	    		var scRfaNoP = scRfaNo.substr(0, 3);
    	    		var scRfaNoS = scRfaNo.substr(3);
    	    		var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS + "&eff_dt=" + form.rt_aply_dt_from.value + "&exp_dt=" + form.rt_aply_dt_to.value;
    	    		
    	    		if(ctrtTpCd == "RFA") { // RFA
    	    			
    		    		pgmNo = "ESM_PRI_2019";
    		    		popParams = "s_rfa_no=" + scRfaNo;
    		    	}
    		    	else if(ctrtTpCd == "TAA") { // TAA
    		    		pgmNo = "ESM_PRI_3007";
		    			popParams = "cond_taa_no=" + scRfaNo;    			
    		    	}
    	        	comRASCallPop(pgmNo, "ESM_BKG_0256", popParams, "");
    				break;
    	    		
    			case "bl_no":
    	        	if(null == bkgNo || "" == bkgNo) { return; }
		         	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
    	        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0256", popParams, "");
    				break;
				
				case "bkg_contract_bk":
    	    		var popParams = "bl_no=" + blNo + "&bkg_no=" + bkgNo + "&umch_bkg_seq=" + umchBkgSeq;
					comRASCallPop("ESM_BKG_1049", "ESM_BKG_0256", popParams, "");
					break;
					
				case "diff_usd_amt":
					var popParams = "bkg_no="+bkgNo+"&umch_bkg_seq="+umchBkgSeq;
					comRASCallPop("ESM_BKG_0698", "ESM_BKG_0256", popParams, "");
					break;
					
					
					
				case "self_audit":
//					var popParams = "bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq;   /*추가*/
//					comRASCallPop("ESM_BKG_0263", "ESM_BKG_0256", popParams, "");
//					break;
					var _Width = '1000';
					var _Height = '728';
					var pgmNo = "&pgmNo=ESM_BKG_0263";
					var popParams = "bl_no="+blNo+"&umch_bkg_seq="+umchBkgSeq +"&ca_flg=N"; 
					var url = "ESM_BKG_0263.do?" + popParams + pgmNo;
					ComOpenPopupWithTarget(url, _Width, _Height, "","none",false);
					break;
					

				case "rdn_no":
				    //B/L No ( <- B/L No ), Receipt RHQ ( <- RHQ ), Receipt Office( <- Office ), Responsible RHQ ( <- RHQ ), Responsible Office ( <- Office ) 항목 복사해 줌
					var popParams = "rdn_no=" + rdnNo + "&bl_no=" + blNo + "&rct_rhq_cd=" + rctRhqCd + "&rct_ofc_cd=" + rctOfcCd;
    	    		comRASCallPop("ESM_BKG_0426", "ESM_BKG_0256", popParams, "");
					break;
			}
    	}
    	
    	/** 
         * sheet1 search end 시 호출되는 이벤트핸들러 <br>
         * <br><b>Example :</b>
         * <pre>
         * </pre>
         * @param  {IBSheet} sheetObj : 시트오브젝트  
         * @param  {String} ErrMsg 
         * @see #
         * @author 이승준
         * @version 2009.10.16
         */
    	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	    		var formObj = document.form;
	    		
	    		var unmatched_bl_count = 0;
	    		var unmatched_case_count = 0;
	    		
	    		var unmatch_al = 0;  //수정
	    		var unmatch_all = 0; //추가
	    		
	    		var unmatch_b = 0;
	    		var unmatch_c = 0;
	    		var unmatch_d = 0;
	    		var unmatch_e = 0;
	    		var unmatch_f = 0;
	    		var unmatch_g = 0;
	    		
 	 	 		var startRow1 = sheet1.HeaderRows;
 	 			var endRow1 = sheet1.HeaderRows + sheet1.RowCount;
	    		
				for(var i = startRow1; i < endRow1; i++) {
					
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_al"))) { unmatch_al++; }     /**수정**/
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_all"))) { unmatch_all++; }   /**추가**/
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_b"))) { unmatch_b++; }
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_c"))) { unmatch_c++; }
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_d"))) { unmatch_d++; }
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_e"))) { unmatch_e++; }
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_f"))) { unmatch_f++; }
	 	 			if(!ComIsEmpty(sheetObj.CellValue(i,"umch_g"))) { unmatch_g++; }
	 	 			
	 	 			if(sheetObj.CellValue(i, "rev_aud_sts_cd") != "U") {
	 	 				sheetObj.CellEditable(i, "chk") = false;
	 	 				sheetObj.CellBackColor(i, "chk") = sheetObj.RgbColor(239,240,243);
	 	 			}
	 	 			
	 	 		}
				
				//total
				unmatched_bl_count = sheetObj.TotalRows; 
				unmatched_case_count = unmatch_al + unmatch_all +unmatch_b + unmatch_c + unmatch_d + unmatch_e + unmatch_f + unmatch_g;  //수정
				
				formObj.filtered_bkg_count.value = "";
				formObj.unmatched_bl_count.value = ComAddComma(unmatched_bl_count);
				formObj.unmatched_case_count.value = ComAddComma(unmatched_case_count);
				
				formObj.unmatch_al.value = ComAddComma(unmatch_al);//수정
				formObj.unmatch_all.value = ComAddComma(unmatch_all);//추가
				formObj.unmatch_b.value = ComAddComma(unmatch_b);
				formObj.unmatch_c.value = ComAddComma(unmatch_c);
				formObj.unmatch_d.value = ComAddComma(unmatch_d);
				formObj.unmatch_e.value = ComAddComma(unmatch_e);
				formObj.unmatch_f.value = ComAddComma(unmatch_f);
				formObj.unmatch_g.value = ComAddComma(unmatch_g);
	 			
    	}
    	
 	 	/**
 	     * OnClick 이벤트 발생시 호출되는 function <br>
 	     * 주소입력시 메모장을 화면에 표시한다. <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     *
 	     * </pre>
 	     * @param {ibsheet} sheetObj 필수 IBSheet Object
 	     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 	     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 	     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 	     * @return 없음
 	     * @author 이승준
 	     * @version 2009.06.03
 	     */  	           
 	     function sheet1_OnClick(sheetObj, Row, Col, Value) {
 		    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 		    var colname = sheetObj.ColSaveName(Col);  	 
 	     	switch(colname){
 	 	    	case "umch_rsn_rmk":
 	 	    		ComShowMemoPad(sheetObj,Row,Col,true,200,200); 
 	 	    		break;
// 	 	    	case "rgn_grp_avc_rmk":
// 	 	    		ComShowMemoPad(sheetObj,Row,Col,false,200,200);
// 	 	    		break;
 	     	}    	 

 	    }
 	 	
 	 	
 	     
/**
 * OnMouseDown 이벤트 발생시 호출되는 function <br>
 * 주소입력시 메모장을 화면에 표시한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} Button : 마우스버튼 방향, 1:왼쪽, 2:오른쪽
 * @param {int} Shift : Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param {Long} X : X 좌표
 * @param {Long} Y : Y 좌표 
 * @return 없음
 * @author 김대호
 * @version 2009.10.06
 */  	           
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	var rowIdx = sheetObj.MouseRow;
	var colIdx = sheetObj.MouseCol;
	
	if( rowIdx == 0 && (14 < colIdx && colIdx < 16) ) {
		var popParams = "";
		comRASCallPop("ESM_BKG_1055", "ESM_BKG_0256", popParams, "")		
	}
}
 	     

 	     /**
		 * 화면을 전체 리셋한다.<br>
		 * <br><b>Example :</b>
		 * <pre>
		 *     removeAll(formObj)
		 * </pre>
		 * @param {formObj} formObj    
		 * @return 없음
		 * @author 이승준
		 * @version 2009.06.10
		 */
  	 	function removeAll(formObj) {
  	 		//self.location.reload();
  	 		formObj.reset();
  	 		comboObjects[1].removeAll(); // 순서중요
  	 		comboObjects[0].Index = "-1";
  	 		comboObjects[2].Index = "-1";
  	 		comboObjects[3].Index = "-1";
  	 		comboObjects[4].Index = "-1";
  	 		comboObjects[5].Code = "-1";
  	 		comboObjects[6].Index = "U";
  	 		comboObjects[7].Index = "-1";
  	 		comboObjects[12].Index = "-1";
 	 		sheetObjects[1].RemoveAll();
  		} 
 
 	     
  	 	/**
  	     * radio버튼 click 이벤트 발생시 호출되는 function <br>
  	     * <br><b>Example :</b>
  	     * <pre>
  	     *     
  	     * </pre>
  	     * @param 없음
  	     * @returns 없음
  	     * @author 이승준
  	     * @version 2009.04.17
  	     */ 	
  	 	function obj_click()
  	 	{	 		
  	 		//bdr_status 세팅
  	 		setAuditSeqCd(document.form);
  	  	}
  	 	
  	 	/**
  	     * Error Seq 라디오 버튼의 현재 세팅값을 세팅한다.<br>
  	     * <br><b>Example :</b>
  	     * <pre>
  	     *    setBdrStatusCd(formObj)
  	     * </pre>
  	     * @param {form} formObj    
  	     * @return 없음
  	     * @author 이승준
  	     * @version 2009.06.10
  	     */
  	 	function setAuditSeqCd(formObj) {
  	 		if (formObj.audit_seq_radio[0].checked == true){
  	        	formObj.audit_seq_cd.value = formObj.audit_seq_radio[0].value;
  	        } else if(formObj.audit_seq_radio[1].checked == true) {
  	        	formObj.audit_seq_cd.value = formObj.audit_seq_radio[1].value;
  	        }
  	 	}
  	 	
  	 	
  	 	/**
  	     * UnMatch Detail의 값을 reset한다. <br>
  	     * <br><b>Example :</b>
  	     * <pre>
  	     *     resetUnMatchDetail()
  	     * </pre>
  	     * @param 없음
  	     * @return 없음
  	     * @author 이승준
  	     * @version 2009.04.17
  	     */
  	    function resetUnMatchDetail() {
  	    	var sheetObj = sheetObjects[1];
  	    	
  	    	for (var i = sheetObj.HeaderRows-1, n = sheetObj.HeaderRows+sheetObj.RowCount ; i < n; i++) {
  	    		sheetObj.CellValue(i, "bkg_contract_bk") = "";
  	    	}
  	    }
  	    
  	    //BackEndJob 상태 조회용 루프 함수
  	    function callIntervalBackEndJob() {
  	    	if (600==processCnt++) {  //intervalTime(3초) * 600 = 30분
  	    		clearInterval(intervalId);
  	    		ComOpenWait(false);
  	    		return;
  	    	}
  	        doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
  	    }

  	 	
	/* 개발자 작업  끝 */