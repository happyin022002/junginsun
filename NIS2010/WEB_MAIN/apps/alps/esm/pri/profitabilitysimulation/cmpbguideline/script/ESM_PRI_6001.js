/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6001.js
*@FileTitle : CMPB Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.30 이승준
* 1.0 Creation
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
     * @class ESM_PRI_6001 : ESM_PRI_6001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_pri_6001() {
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
 
 var comboObjects = new Array();
 var comboCnt = 0;
 
 var errMsg = "";
 
 //현재 이벤트를 저장
 var eventStatus = "";
 
 var arrTransMode = new Array();
 
 var selectedGlineSeq = ""; 
 
 var isQuickDouwnExcel = false;
 
 //현재 사용자의 오피스가 작성자의 오피스 인지 여부
 var isSameOfc = false;
 
 var LoadingComplete = false;
 
 //현재 선택한  sheet1의 bse_seq
 var selectedBseSeq = -1;
 
 //현재 선택한  sheet3의 cmpb_seq
 var selectedCmpbSeq = -1;
 
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
          
 		var sheetObject1 = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];
 	
          
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

 				case "btn_retrieve":
 					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
 					break;
 	
 				case "btn1_New":
 					removeAll(document.form);
 					break;

 				case "btn1_Save":
 					
 					if (!validateForm(sheetObjects[0],formObject,IBSAVE)) {
		                return false;
		            }
 					
 					//헤더 저장시 디테일 변경사항 체크
		       		if (checkModifiedDetail(formObject)) {
		       			eventStatus = "ALLSAVE";
		       			if(ComShowCodeConfirm("PRI03001")) {
		       				doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
		       				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
		       			} else {
		       				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
		       			}
		        	} else {
		       			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
		       		}
		       		
//		       		selectedBseSeq = -1;
		       		selectedCmpbSeq = -1;
		       		
		       		eventStatus = "";
 					
 					break;
 				
 				case "btn1_Delete":
 					doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
 					break;
 				
 				case "btn1_Confirm":
 					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
 					break;

 				case "btn1_Confirm_Cancel":
 					doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
 					break;
 	
 				case "btn1_Copy":
 					popupCopy();
 					break;

 				case "btn1_Down_Excel":
 					execScript("rtn = msgbox(\"" + ComGetMsg("PRI03002") + "\", 3, \"Download Excel\")", "vbscript");
 					if (rtn == 6) {
 						isQuickDouwnExcel = true;
 						doActionIBSheet(sheetObjects[10], formObject, IBDOWNEXCEL); 
	            	} else if (rtn == 7) {
	            		isQuickDouwnExcel = false;
	            		doActionIBSheet(sheetObjects[10], formObject, IBDOWNEXCEL); 
	            	} else {
	            		return;
	            	}
 					break;
 				
 				case "btn1_Load_Excel":
 					if (validateForm(sheetObjects[10],formObject,IBSEARCH_ASYNC05)) {
 		            	var sUrl = "/hanjin/ESM_PRI_6002.do?";
 						sUrl += "svc_scp_cd=" + getSvcScpCd();
 						sUrl += "&cre_ofc_cd=" + formObject.cre_ofc_cd.value; 
 						sUrl += "&gline_seq=" + formObject.gline_seq.value; 
 						sUrl += "&prs_cust_tp_cd=" +  getPrsCustTpCd();

 						ComPriOpenWindowCenter(sUrl, "ESM_PRI_6002", 962, 556, true);
 	            	}
 					break;
 				
 				case "btn2_CMDT_Group":
 					popupCmdtGroup();
 					break;

 				case "btn2_Loc_Group":
 					popupLocGroup();
 					break;
 	
 				case "btn2_Row_Add":
 					doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
 					break;

 				case "btn2_Row_Copy":
 					doActionIBSheet(sheetObjects[1], document.form, IBCOPYROW);
 					break;

 				case "btn2_Row_Delete":
 					doActionIBSheet(sheetObjects[1], document.form, IBDELETE);
 					break;

 				case "btn2_MQC_Setting":
 					popupMQC();
 					break;
 					
 				case "btn3_Row_Add":
 					doActionIBSheet(sheetObjects[3], document.form, IBINSERT);
 					break;

 				case "btn3_Row_Copy":
 					doActionIBSheet(sheetObjects[3], document.form, IBCOPYROW);
 					break;

 				case "btn3_Row_Delete":
 					doActionIBSheet(sheetObjects[3], document.form, IBDELETE);
 					break;

 				case "btn3_Save":
 					doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
  					break;	

 				case "btns_calendar": //달력버튼
   	    			if (comboObjects[0].Code == "") {
   	    				ComShowCodeMessage('PRI08002');
   	    				return false;
   	    			}
   	    			var cal = new ComCalendarFromTo();
   	                cal.select(formObject.eff_dt_hidden, formObject.exp_dt, 'yyyy-MM-dd');
   	              	
   	                break;	
   	               
 				
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			alert("지금은 사용하실 수가 없습니다 ");
     		} else {
     			alert(e);
     		}
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
 		for(i=0;i<sheetObjects.length;i++){
	         //khlee-시작 환경 설정 함수 이름 변경
	 		 ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
        	 //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 		}
 		
 		 //IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 		
 	    var iWidth = window.document.body.clientWidth;
       
   		sheetColResize();
      
     }
 	 
 	 
 	/**
      * LoadFinish 이벤트 시 발생한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function sheet2_OnLoadFinish(sheetObj) {
    	 sheetObj.WaitImageVisible = false; 
    	 doActionIBSheet(sheetObj, document.form, IBCLEAR);
    	 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
 	     axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
 	     axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
   		
  		 toggleButtons("INIT");
  		
  		 comboObjects[0].focus();
     }
 	 
 	 
 	 /**
      * OnFocus event를 처리한다. <br>
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
  		var formObject = document.form;
  	    var srcName = event.srcElement.getAttribute("name");
  	    var comboObj = comboObjects[1];
  	    ComClearSeparator (event.srcElement);
	    if (srcName == "exp_dt" && formObject.exp_dt.value != "" && formObject.eff_dt_hidden.value != "") {
	    	var effDt = formObject.eff_dt_hidden.value;
	    	var expDt = formObject.exp_dt.value;
	    	formObject.eff_dt.value = formObject.eff_dt_hidden.value;
	    	comboObj.SetText("X", 0, effDt); 
			formObject.eff_dt_hidden.value = "";
			
	    	ComClearSeparator (event.srcElement);
	    }
  	    
  	}
  	
 	/**
     * Onbeforedeactivate  event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_deactivate()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
  	function obj_deactivate() {
  	    ComChkObjValid(event.srcElement);
  	    
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
 	        case "svc_scp_cd":
 	            var i=0;
 	            with(comboObj) {
 	            	DropHeight = 260;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	                MaxLength = 3;      // 3자리만 입력
	            }
 	            break;
 	        
 	       case "eff_dt_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	UseAutoComplete = false;
//	            	UseCode=true;
	            	SetColWidth("74|74|54|20");
	            }
	            break;
	            
 	      case "prs_cust_tp_cd":
	            var i=0;
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);
	            }
	            break;     
 	            
 	    }
 	}
  	
  	
  	/**
     * comboObjects[0]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getSvcScpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function getSvcScpCd() {
		return comboObjects[0].Code;
	}
  	/**
     * comboObjects[1]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getEffEtCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getEffEtCd() {
		return comboObjects[1].Text;
	}
	/**
     * comboObjects[2]의 CODE값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrsCustTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrsCustTpCd() {
   		return comboObjects[2].Code;
   	}
	/**
     * comboObjects[2]의 Text값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrsCustTpTxt();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
	function getPrsCustTpTxt() {
   		return comboObjects[2].Text;
   	}
  	
  	/**
     * service scope combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param {comboObj} comboObj    필수,comboObj Object
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
  	function svc_scp_cd_OnChange(comboObj, code, text) {
  		
  		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
 	 		if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
 	 			
 	 			selectedGlineSeq = "";
 	 			
 				var formObj = document.form;
 				
 				var arrText = text.split("|");
 				
				if (arrText[1] != null && arrText[1] != "undefined" && arrText[1].length > 1) {
					
					searchConditionReset(formObj,"1");
					
					formObj.svc_scp_nm.value = formObj.svc_scp_cd.GetText(code,1);
 					
					doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
					
					toggleButtons("INIT");
					
					formObj.svc_scp_nm.focus();
 				}
 				
 	 		} else {
 	 			comboObjects[0].Index = "-1";
 	  		}
  		}	
 	}
  	
  	/**
     * service scope combo 초기화시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnClear(comboObj);
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnClear(comboObj) {
		var formObject = document.form;
		formObject.svc_scp_nm.value = "";
		
		comboObj.Index2 = -1;
	
	}
  	
  	/**
     * service scope combo 포커스 아웃시 동작함<br>
     * <br><b>Example :</b>
     * <pre>
     * 		svc_scp_cd_OnBlur(comboObj)
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */
  	function svc_scp_cd_OnBlur(comboObj) {
  		
		var formObj = document.form;
		
//		formObj.svc_scp_cd_hidden.value = getSvcScpCd();
  		
		if(getSvcScpCd() == formObj.svc_scp_cd_hidden.value) return;
		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			
			var text = comboObj.GetText(code, 1);
			
			if (text != null && text != "" && text != formObj.svc_scp_nm.value) {
				
				searchConditionReset(formObj,"1");
				
				formObj.svc_scp_nm.value = comboObj.GetText(code, 1);
								
				doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
				
				toggleButtons("INIT");
				
				formObj.svc_scp_nm.focus();
			}
		}
	}
  	
  
  	/**
     * IBCombo 인 경우 날짜 포멧 체크<br>
     * <br><b>Example :</b>
     * <pre>
     * 		if(!isDateIBCombo(comboObj)) return;
     * </pre>
     * @param {comboObj} comboObj
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
  	function isDateIBCombo(comboObj) {
  		
  		if(ComIsEmpty(comboObj.Text)) return;
  		
	  	if(!ComIsDate(comboObj.Text)) {
	  		ComPriDateFormatFailed("Effective Date");
			comboObj.Text2 = "";
			comboObj.focus();
			return false;
		}
	  	
	  	return true;
  	}
 	
  	/**
     * eff_dt combo 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		eff_dt_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param {comboObj} comboObj    
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
 	function eff_dt_cd_OnChange(comboObj, code, text) {

 		if(comboObjects[1].GetCount () > 0 && comboObjects[1].Index != "-1") {
 		
 			if (validateForm(sheetObjects[0],document.form,IBCREATE)) {
 				
 				if(!isDateIBCombo(comboObj)) {
 					comboObj.focus();
 					return;
 				}
 		
		 		var formObj = document.form;
		 		
		 		var arrText = text.split("|");

		 		if (arrText[1] != null && arrText[1] != undefined) {
 					formObj.eff_dt.value =  setDash(formObj.eff_dt_cd.GetText(code,0));
					
 					if(!ComIsEmpty(formObj.eff_dt_cd.GetText(code,1))) {
 						formObj.exp_dt.value =  setDash(arrText[1]);
 						formObj.cre_ofc_cd.value =  arrText[2];
 						//formObj.cre_dt.value 	 =  arrText[2];
 						//comboObjects[2].Index 	 =  "-1";
 						comboObjects[2].Code2 	 =  arrText[3];
 						formObj.gline_seq.value =  "";
 	 					selectedGlineSeq = code;

 	 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 	 					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
 					} else {
 						formObj.exp_dt.focus();
 						
 						selectedGlineSeq = "";
 					}
 					
 					//searchConditionReset(formObj,"2");
 					
 				}
			
 			} else {
 	 			comboObjects[1].Index = "-1";
 	 			
 	 			selectedGlineSeq = "";
 	 		}
 		}
	}
 	

 	/**
     * eff_dt combo 포커스 아웃시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		eff_dt_cd_OnBlur(comboObj);
     * </pre>
     * @param {comboObj} comboObj 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
 	 function eff_dt_cd_OnBlur(comboObj) {
   		
   		var formObj = document.form;
   		
   		var selEffDt = comboObj.Text;
		
		if (selEffDt == null || selEffDt == "" || selEffDt == undefined) {
			return false;
		}
		
		selEffDt = selEffDt.replace(/-/gi, "");
		selEffDt = selEffDt.substring(0, 4) + "-" + selEffDt.substring(4, 6) + "-" + selEffDt.substring(6, 8); 
		
		var glineSeq = formObj.gline_seq.value;
 
		var code = comboObj.FindIndex(selEffDt, 0);
		var expDt = "";
		
		if(code != "-1" && !ComIsEmpty(glineSeq)) {
			expDt = comboObj.GetText(code, 1); 
		}
		
		
		if(!isDateIBCombo(comboObj)) {
			comboObj.focus();
			return;
		}
		//select
//		if(!ComIsEmpty(selectedGlineSeq)) {
//			comboObj.SetText(selectedGlineSeq, 0, selEffDt);
//			formObj.eff_dt.value = selEffDt;
//		}
		

		if(ComIsEmpty(expDt)) {	
						
			if(ComIsEmpty(expDt) || ComIsEmpty(selectedGlineSeq) || ComIsEmpty(glineSeq)) {	
				
				comboObj.SetText("X",0,selEffDt);
				comboObj.Index2 = 0;
				formObj.eff_dt.value = selEffDt;
//				var code = comboObj.FindIndex("", 1);
//				var txt =  setDash(comboObj.GetText(code,0));
//
//				if(code != "-1") {
//					comboObj.DeleteItem(code);
//				}
//
//				//combo item insert
//				comboObj.InsertItem(-1,selEffDt + "|||", selEffDt);
//				comboObj.Code = selEffDt;
//				selectedGlineSeq = comboObj.Code;
//				
//				comboObj.SetText(selEffDt,0,selEffDt);
			} 
			
		} 
		
		//auto search or select
		else {
//			if(selectedGlineSeq != "") {
				if(!isDateIBCombo(comboObj)) {
					comboObj.focus();
					return;
				}
				
				formObj.eff_dt.value = selEffDt;
				
//			}	
		}
		
   	}
   	
 	
 	/**
     * prs_cust_tp_cd 변경시 활성화됨<br>
     * <br><b>Example :</b>
     * <pre>
     * 		prs_cust_tp_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param {comboObj} comboObj    
     * @param {String} code    
     * @param {String} text 
     * @return 없음   
     * @author 이승준
     * @version 2009.06.10
     */ 
    function prs_cust_tp_cd_OnChange(comboObj, code, text) {
    	
    	if(eventStatus == "INIT") return;
    	
 		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
 			
 			if (validateForm(sheetObjects[0],document.form,IBSEARCH)) {
 				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 				doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		 	} 
 		} 
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
	 				
	 				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	 				InitRowInfo(1, 1, 3, 100);
	 				
	 				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	 				InitColumnInfo(1, 0, 0, true);
	 	
	 				// 해더에서 처리할 수 있는 각종 기능을 설정한다
	 				InitHeadMode(true, true, true, true, false, false)
	 	
	 				var HeadTitle = "status";
	 	
	 				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	 				InitHeadRow(0, HeadTitle, true);
	 	
	 				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
	 				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
	 				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
	 				// SAVESTATUS, FORMATFIX]
	 				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
	 				
	 				Visible = false;
	 				WaitImageVisible = false;
	 			 }
	        	 break;
	        	 
             case "sheet1":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 132;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1  = "|Sel.|Del Check|Seq.|SVC Lane|CMDT|Origin|O.VIA|D.VIA|Dest.|svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	DATAFORMAT, 
                     //POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter,   false, "ibflag");
 	                InitDataProperty(0, cnt++,  dtDummyCheck, 	40, daCenter,   false, "chk",false,  "", dfNone, 0,  true,  true,0,	false,false,"",true);
                    InitDataProperty(0, cnt++,  dtDelCheck, 	40, daCenter,   false, "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,    		30, daCenter,   false, "Seq");
 					InitDataProperty(0, cnt++ , dtPopup,		150,daCenter,	true,  "vsl_slan_cd",			 	true,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtPopup,		150,daCenter,	true,  "prc_cmdt_def_cd",			false,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtPopup,		145,daCenter,	true,  "org_rout_pnt_loc_def_cd",	false,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtPopup,		145,daCenter,	true,  "org_rout_via_port_def_cd",	false,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtPopup,		150,daCenter,	true,  "dest_rout_via_port_def_cd",	false,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtPopup,		150,daCenter,	true,  "dest_rout_pnt_loc_def_cd",	false,	"",	dfNone,	0,	true,	true);	
 					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "svc_scp_cd",  	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "cre_ofc_cd", 	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft,	 	false, "gline_seq", 	 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "prs_cust_tp_cd", 			true,   "", dfNone, 0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "bse_seq", 		 			true,   "", dfNone, 0,  false,  false);
 	               
 	                Ellipsis = true;
 					CountPosition = 0;
 					PopupImage  =  "img/btns_search.gif";
 					ShowButtonImage = 1;
 					ColHidden("del_chk") = true;
 					WaitImageVisible = false;
 			    }
                break;

 			case "sheet2":      // sheet1 init
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 105;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(1, 1, 15, 100);

                     var HeadTitle1  = "|Sel.|Del Check|Seq.|MQC(Min.)|MQC(Max.)|Per|Cargo Type|Currency|CMPB Guideline|Eff. Date|Exp. Date|svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq|cmpb_seq";
 					 var headCount = ComCountHeadTitle(HeadTitle1);
                     
 					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                     //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter,   false, "ibflag");
  	                InitDataProperty(0, cnt++,  dtDummyCheck, 	40, daCenter,   false, "chk");
                    InitDataProperty(0, cnt++,  dtDelCheck, 	40, daCenter,   false, "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,    		40, daCenter,   false, "Seq");
 					InitDataProperty(0, cnt++ , dtData,			110,daRight,	true,  "mqc_rng_fm_qty",	true,	"",	dfNullInteger,0,true,	true, 6);	
 					InitDataProperty(0, cnt++ , dtData,			110,daRight,	true,  "mqc_rng_to_qty",	true,	"",	dfNullInteger,0,true,	true, 6);	
 					InitDataProperty(0, cnt++ , dtCombo,		110,daCenter,	true,  "rat_ut_cd",			false,	"",	dfNone,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtCombo,		110,daCenter,	true,  "prc_cgo_tp_cd",		false,	"",	dfNone,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtCombo,		110,daCenter,	true,  "curr_cd",			true,	"",	dfNone,		0,	true,	true);	
 					InitDataProperty(0, cnt++ , dtData,			130,daRight,	true,  "cmpb_amt",			true,	"",	dfNullFloat,2,	true,	true, 9);	
 					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,  "eff_dt",			true,	"",	dfDateYmd,	0,	false,	false);	
 					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,  "exp_dt",			true,	"",	dfDateYmd,	0,	false,	false);
 					
 					InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "svc_scp_cd",  	 	false,   "", dfNone, 	0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "cre_ofc_cd", 	 	false,   "", dfNone, 	0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft,	 	false, "gline_seq", 	 	false,   "", dfNone, 	0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "prs_cust_tp_cd", 	false,   "", dfNone, 	0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "bse_seq", 		 	false,   "", dfNone, 	0,  false,  false);
 	                InitDataProperty(0, cnt++, dtHidden, 		90, daLeft, 	false, "cmpb_seq", 		 	false,   "", dfNone, 	0,  false,  false);
 	               
 					CountPosition = 0;
 					ColHidden("del_chk") = true;
 					WaitImageVisible = false;
 			    }
                break;
                
                
 			case "sheet3":  // svc lane 
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(7, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "3-1|3-2|3-3|3-4|3-5|3-6|3-7";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                //InitDataProperty(0, cnt++ , dtCheckBox,	   40, daCenter, false,	"chk",		false,	"",	dfNone,	0,	false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++,  dtData, 100, daCenter,false, "cre_ofc_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vsl_slan_cd", 	false, "", dfNone, 0, false, false);
 	                
 	                WaitImageVisible = false;
 	            }
 	            break; 
 	            
 			case "sheet4":  // commodity
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(10, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "4-1|4-2|4-3|4-4|4-5|4-6|4-7|4-8|4-9|4-10";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cmdt_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_tp_cd", 	false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prc_cmdt_def_nm", false, "", dfNone, 0, false, false);
	                
	                WaitImageVisible = false;
 	            }
 	            break;   
 	            
 			case "sheet5":  // point origin
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(13, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "5-1|5-2|5-3|5-4|5-5|5-6|5-7|5-8|5-9|5-10|5-11|5-12|5-13";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", 	false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", 		false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_nm", 		false, "", dfNone, 0, false, false);
	                
	                WaitImageVisible = false;
 	            }
 	            break; 
 	            
 	            
 			case "sheet6":  // via origin
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(11, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "6-1|6-2|6-3|6-4|6-5|6-6|6-7|6-8|6-9|6-10|6-11";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd",false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm",false, "", dfNone, 0, false, false);
	                
	                WaitImageVisible = false;
	                
 	            }
 	            break; 
 	            
 	            
 			case "sheet7":  // point via
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(11, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "8-1|8-2|8-3|8-4|8-5|8-6|8-7|8-8|8-9|8-10|8-11";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_seq", 		false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_tp_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_cd",false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_via_port_def_nm",false, "", dfNone, 0, false, false);
	                
	                WaitImageVisible = false;
 	            }
 	            break;      
 	            
 	            
 			case "sheet8":  // point dest
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 100;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msNone;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(1, 1, 3, 100);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(13, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(true, true, true, true, false, false)
 	    
 	                var HeadTitle = "7-1|7-2|7-3|7-4|7-5|7-6|7-7|7-8|7-9|7-10|7-11|7-12|7-13";
 	    
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "svc_scp_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "cre_ofc_cd", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "gline_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "prs_cust_tp_cd",  	false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bse_seq", 			false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "org_dest_tp_cd", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_seq", 		false, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_tp_cd", 	false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_cd", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_cd", 		false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rout_pnt_loc_def_nm", false, "", dfNone, 0, false, false);
	                InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_de_term_nm", 		false, "", dfNone, 0, false, false);
	                
	                WaitImageVisible = false;
 	            }
 	            break;
 	            
 			case "sheet9":      // sheet9 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 84;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

                    var HeadTitle1  = "|Sel.|Del Check|Seq.|SVC Lane|Commodity|Origin|Origin Via|Destination Via|Destination";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,			WIDTH,		DATAALIGN, COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC,	
                    //DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30, daCenter,   false, "ibflag");
 	                InitDataProperty(0, cnt++,  dtDummyCheck, 	40, daCenter,   false, "chk",false,  "", dfNone, 0,  true,  true,0,	false,false,"",true);
                    InitDataProperty(0, cnt++,  dtDelCheck, 	40, daCenter,   false, "del_chk");
                    InitDataProperty(0, cnt++ , dtSeq,    		30, daCenter,   false, "Seq");
                    InitDataProperty(0, cnt++ , dtData,	70,		daCenter,	true,  "vsl_slan_cd",				false,	"",	dfNone,0,false,	false);	
					InitDataProperty(0, cnt++ , dtData,	250,	daLeft,		true,  "prc_cmdt_def_nm",			false,	"",	dfNone,0,false,	false);	
					InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "org_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
					InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "org_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
					InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "dest_rout_via_port_def_nm",	false,	"",	dfNone,0,false,	false);	
					InitDataProperty(0, cnt++ , dtData,	160,	daLeft,		true,  "dest_rout_pnt_loc_def_nm",	false,	"",	dfNone,0,false,	false);	
					
					Ellipsis = true;
//					WordWrap = true;
					CountPosition = 0;
					ColHidden("chk") = true;
					ColHidden("del_chk") = true;
					ColHidden("Seq") = true;
					//Editable  = false;
					SelectHighLight = false;
					WaitImageVisible = false;
			   }
               break;
               
 			case "sheet10": // Excel Download용 Sheet
 	            with (sheetObj) {
 	                // 높이 설정
 	                style.height = 300;
 	                // 전체 너비 설정
 	                SheetWidth = mainTable.clientWidth;
 	    
 	                // Host정보 설정[필수][HostIp, Port, PagePath]
 	                if (location.hostname != "")
 	                    InitHostInfo(location.hostname, location.port, page_path);
 	    
 	                // 전체Merge 종류 [선택, Default msNone]
 	                MergeSheet = msHeaderOnly;
 	    
 	                // 전체Edit 허용 여부 [선택, Default false]
 	                Editable = true;
 	    
 	                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 	                InitRowInfo(2, 1, 3, 100);
 	    
 	                var HeadTitle1 = "Seq.|SVC Lane|Commodity|Commodity|Origin|Origin|Origin|O.Via|D.Via|Destination|Destination|Destination|Per|Cargo\nType|Cur.|CMPB\nGuideline|MQC\n(Min.)|MQC\n(Max.)|cnt_svc_lane";
 	                var HeadTitle2 = "Seq.|SVC Lane|Code|Description|Code|Description|Term|Code|Code|Code|Description|Term|Per|Cargo\nType|Cur.|CMPB\nGuideline|MQC\n(Min.)|MQC\n(Max.)|cnt_svc_lane";
 	                var headCount = ComCountHeadTitle(HeadTitle2);
 	    
 	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 	                InitColumnInfo(headCount, 0, 0, true);
 	    
 	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
 	                InitHeadMode(false, true, true, true, false, false)
 	        
 	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle1, true);
 	                InitHeadRow(1, HeadTitle2, false); 
 	    
 	                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 	                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 	                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 	                // SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "rout_dp_seq", true, "", dfNullInteger, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "vsl_slan_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,false, "prc_cmdt_def_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daLeft,  false, "prc_cmdt_def_nm", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,false, "org_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daLeft,  false, "org_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,false, "org_rcv_de_term_nm", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "org_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "dest_rout_via_port_def_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,false, "dest_rout_pnt_loc_def_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daLeft,  false, "dest_rout_pnt_loc_def_nm", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,false, "dest_rcv_de_term_nm", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "rat_ut_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daCenter,true,  "prc_cgo_tp_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daRight, true,  "curr_cd", true, "", dfNone, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daRight, true,  "cmpb_amt", true, "", dfNullFloat, 2, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daRight, true,  "mqc_rng_fm_qty", true, "", dfNullInteger, 0, false, false);
 	                InitDataProperty(0, cnt++, dtData, 100, daRight, true,  "mqc_rng_to_qty", true, "", dfNullInteger, 0, false, false);
 	                InitDataProperty(0, cnt++, dtHidden, 90, daLeft, false, "cnt_svc_lane", 	true,   "", dfNone, 0,  false,  false);
 	                
 	                ColHidden("cnt_svc_lane") = true;
 	                WaitImageVisible = false;
 	            }
 	            break;
 			
         }
     }
	         

     /**
      * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
      * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     sheet1_OnBeforeCheck(sheetObj, Row, Col);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} Row 
      * @param {String} Col 
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
    function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);

  		if (colName == "chk") {
  			
  			var sheetObj = new Array();
  			
  			sheetObj[0] = sheetObjects[1];
  			sheetObj[1] = sheetObjects[3];
  			
  			ComPriCheckWithPnS(sheetObj, 0, Row, Col);
  		}
  	}
     
  
    /**
     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet2_OnBeforeCheck(sheetObj, Row, Col);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {String} Row 
     * @param {String} Col 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
  	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName = sheetObj.ColSaveName(Col);
  		
  		var sheetObj = new Array();
			
		sheetObj[0] = sheetObjects[1];
		sheetObj[1] = sheetObjects[3];

  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObj, 1, Row, Col);
  		}
  	} 
     
  	/**
     * sheet에서 cell을 클릭한 경우 발생. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} OldRow 
     * @param {int} OldCol 
     * @param {int} NewRow 
     * @param {int} NewCol 
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */
     function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	 if(eventStatus == "POPUP") return;
     	 
    	 if(!isFiredNested) {
    		 selectedBseSeq = sheetObj.CellValue(NewRow,"bse_seq");
    	 	 doRowChange(OldRow, NewRow, OldCol, NewCol);
    	 }	
    	 
     }
     
     /**
      * sheet에서 cell을 클릭한 경우 발생. <br>
      * <br><b>Example :</b>
      * <pre>
      *     sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 
      * @param {int} OldCol 
      * @param {int} NewRow 
      * @param {int} NewCol 
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
      function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	  if(eventStatus != "IBSAVE" && eventStatus != "ALLSAVE" )
    		  selectedCmpbSeq = sheetObj.CellValue(NewRow,"cmpb_seq");
      }
     
     
     var isFiredNested = false;
     var supressConfirm = false;
     
     /**
      * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
      * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
      * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
      * 
      * <br><b>Example :</b>
      * <pre>
      *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 
      * @param {int} OldCol 
      * @param {int} NewRow 
      * @param {int} NewCol 
      * @param {String} sAction
      * @return 없음
      * @author 이승준
      * @version 2009.04.17
      */
     function doRowChange(OldRow, NewRow, OldCol, NewCol, sAction) {
         var formObj = document.form;
         var adjNewRow = ComGetValidRow(sheetObjects[1],"bse_seq",selectedBseSeq);

         if (!isFiredNested && (OldRow != NewRow)) {

        	 if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D" && 
        	    (sheetObjects[1].IsDataModified
        			 || sheetObjects[3].IsDataModified
        			 || sheetObjects[4].IsDataModified
                     || sheetObjects[5].IsDataModified
                     || sheetObjects[6].IsDataModified
                     || sheetObjects[7].IsDataModified
                     || sheetObjects[8].IsDataModified)) {
                 isFiredNested = true;
                 sheetObjects[1].SelectCell(OldRow, OldCol, false);
                 isFiredNested = false;
             	
                 var rslt = false;
                 if (ComShowCodeConfirm("PRI00006")) {
                     supressConfirm = true;
                     rslt = doActionIBSheet(sheetObjects[3], document.form, IBSAVE);
                     supressConfirm = false;
                 }
                 if (rslt) {
                     isFiredNested = true;
                     sheetObjects[1].SelectCell(adjNewRow, NewCol, false);
                     isFiredNested = false;
                 } else {
                     isFiredNested = true;
                     sheetObjects[1].SelectCell(OldRow, OldCol, false);
                     isFiredNested = false;
                 	return -1;
                 }
             } 
        	 
        	 
        	
        	 if (sAction == IBINSERT) {
                 isFiredNested = true;
                 var idx = sheetObjects[1].DataInsert();
                 selectedBseSeq = parseInt(ComPriGetMax(sheetObjects[1], "bse_seq"),10) + 1;
                 isFiredNested = false;
                 return idx;
             } else if (sAction == IBCOPYROW) {
                 isFiredNested = true;
                 var idx = sheetObjects[1].DataCopy();
                 selectedBseSeq = parseInt(ComPriGetMax(sheetObjects[1], "bse_seq"),10) + 1;
                 isFiredNested = false;
                 return idx;
             } else {
            	 
            	 if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D") {
            	 
	            	 formObj.bse_seq.value = sheetObjects[1].CellValue(NewRow, "bse_seq");
	                 if(formObj.bse_seq.value == undefined || formObj.bse_seq.value == null || ComIsEmpty(formObj.bse_seq.value)) {
	                 	formObj.bse_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"bse_seq");
	                 }

	                 LoadingComplete = false;
	                 doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
	                 adjNewRow = ComGetValidRow(sheetObjects[3],"cmpb_seq",selectedCmpbSeq);
	                 sheetObjects[3].SelectCell(adjNewRow,0,false);
	                 LoadingComplete = true;
	                 
            	 }  
              	 
             }
 
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
        switch(sAction) {
        
        	 case IBCLEAR: 
		        	// 화면 로딩시 Service Scope 조회
		 			formObj.f_cmd.value = SEARCH01;
		 			formObj.etc5.value="PRS";
		 			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		 			ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");
		 			
		 			// 화면 로딩시customer type 조회
					formObj.f_cmd.value = SEARCH20;
					formObj.cd.value="CD02085";
					
					sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
					ComPriXml2ComboItem(sXml, formObj.prs_cust_tp_cd, "cd", "nm");
					//formObj.prc_cust_tp_cd.InsertItem(0,'','|');
					
					//code가 BOTH 인 경우  삭제 후   Text를 ""로 세팅
					var itemindex = formObj.prs_cust_tp_cd.FindIndex("ALL",0);
					
					eventStatus = "INIT";
					
					if(itemindex != "-1") {
						formObj.prs_cust_tp_cd.DeleteItem(itemindex); 
						formObj.prs_cust_tp_cd.InsertItem(0,'','M');
					}
					
					//formObj.prs_cust_tp_cd.Code2 = 'M';
					
					eventStatus = "";
		 			
		 			// per combo
		            formObj.f_cmd.value = SEARCH03;
		            formObj.etc5.value = "PRS";
		            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		            setIBCombo(sheetObjects[3], sXml, "rat_ut_cd", true, 0, "","",true);
		            
		            //공통 cargo
		            formObj.f_cmd.value = SEARCH19;
		            formObj.cd.value="CD01701";
		            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		            setIBCombo(sheetObjects[3], sXml, "prc_cgo_tp_cd", true, 0);
		            
		            //currency combo
		            formObj.f_cmd.value = SEARCH06;
		            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		            setIBCombo(sheetObjects[3], sXml, "curr_cd", false, 0, "USD");
		            break;	
		            
	         case IBCREATE: // Service Scope 선택시, Duration 조회
		 			formObj.f_cmd.value = SEARCH04;
		 			
		 			formObj.eff_dt_cd.removeAll();
		 			
		 			var sXml = sheetObj.GetSearchXml("ESM_PRI_6001GS.do", FormQueryString(formObj));
		 			//ComPriXml2ComboItem(sXml, formObj.eff_dt, "eff_dt", "eff_dt|exp_dt");
		 			ComPriXml2ComboItem(sXml, formObj.eff_dt_cd, "duration_key", "eff_dt|exp_dt|cre_ofc_cd|prs_cust_tp_cd");
					comboObjects[1].InsertItem(0, "||", "X");
					comboObjects[1].Code = "X";
		 			break;	
	 		
	         case IBSEARCH:      //조회
	        	   if (validateForm(sheetObj, formObj, sAction)) {
	        		   
	        		   try {
	        			   sheetObjects[3].WaitImageVisible = false;
		        		   ComOpenWait(true);
		        		   
		        		   if(formObj.bse_seq.value == undefined || formObj.bse_seq.value == null || ComIsEmpty(formObj.bse_seq.value)) {
		   	                 	formObj.bse_seq.value = "";
		   	               }
		        		   
		        		   if ( sheetObj.id == "sheet0") {
		        			
		            	        formObj.f_cmd.value = SEARCH01;
		            	        
		            	       
		            		    var sXml = sheetObj.GetSearchXml("ESM_PRI_6001GS.do", FormQueryString(formObj));
			       				var arrData = ComPriXml2Array(sXml, "svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|eff_dt|exp_dt|cfm_flg|cre_dt|duration_key");
			       				if (arrData != null && arrData.length > 0) {
			       					
			       					//듀레이션
			       					formObj.eff_dt_cd.Code2	 		 	= arrData[0][8];
			       					formObj.eff_dt.value 			 	= arrData[0][4];
			       					formObj.exp_dt.value 			 	= arrData[0][5];
			       					
			       					formObj.cfm_flg.value 			 	= arrData[0][6];
			       					formObj.cre_dt.value  			 	= arrData[0][7];
			       					
			       					
			       					formObj.svc_scp_cd_hidden.value  	= arrData[0][0];
			       					formObj.cre_ofc_cd_hidden.value  	= arrData[0][1];
			       					formObj.gline_seq.value 		 	= arrData[0][2];
			       					formObj.prs_cust_tp_cd_hidden.value = arrData[0][3];
			       					formObj.eff_dt_hidden.value 	 	= arrData[0][4];
			       					formObj.exp_dt_hidden.value 		= arrData[0][5];
			       					
			       				} else {
			       					//comboObjects[2].Index = "-1";
			       					//formObj.cre_ofc_cd.value = "";
			       					formObj.cfm_flg.value = "";
			       					formObj.cre_dt.value = "";
			       					
			       					formObj.svc_scp_cd_hidden.value  	= "";
			       					formObj.cre_ofc_cd_hidden.value  	= "";
			       					formObj.gline_seq.value 		 	= "";
			       					formObj.prs_cust_tp_cd_hidden.value = "";
			       					formObj.eff_dt_hidden.value 	 	= "";
			       					formObj.exp_dt_hidden.value 		= "";
			       				}
			       				
			       			}
		        		   //Grid 1
		        		   else if (sheetObj.id == "sheet1") {
		                       for (var i = 1; i < sheetObjects.length; i++) {
		                           sheetObjects[i].RemoveAll();
		                       }
		                     
		                       formObj.f_cmd.value = SEARCH02;
		                        
		                       var sXml = sheetObj.GetSearchXml("ESM_PRI_6001GS.do" , FormQueryString(formObj));
		                       sheetObjects[1].LoadSearchXml(sXml);    // Grid1.
		                       //sheetObjects[2].LoadSearchXml(sXml);    // Grid2.
		                       
		                   } else if (sheetObj.id == "sheet2") {
		                       for (var i = 2; i < sheetObjects.length; i++) {
		                           sheetObjects[i].RemoveAll();
		                       }
		                       
		                       formObj.f_cmd.value = SEARCH03;
		                       var sXml = sheetObj.GetSearchXml("ESM_PRI_6001GS.do" , FormQueryString(formObj));
		                       var arrXml = sXml.split("|$$|");
		                       
		                       //전역변수에 저장
		                       
		                       if (arrXml.length > 0) sheetObjects[3].LoadSearchXml(arrXml[0]);    // Grid3.
		                       if (arrXml.length > 1) sheetObjects[4].LoadSearchXml(arrXml[1]);    // Hidden. Grid1의 scv lane.
		                       if (arrXml.length > 2) sheetObjects[5].LoadSearchXml(arrXml[2]);    // Hidden. Grid1의 cmdt.
		                       if (arrXml.length > 3) sheetObjects[6].LoadSearchXml(arrXml[3]);    // Hidden. Grid1의 Origin Point.
		                       if (arrXml.length > 4) sheetObjects[7].LoadSearchXml(arrXml[4]);    // Hidden. Grid1의 Origin Via.
		                       if (arrXml.length > 5) sheetObjects[8].LoadSearchXml(arrXml[5]);    // Hidden. Grid1의 Dest Via.
		                       if (arrXml.length > 6) sheetObjects[9].LoadSearchXml(arrXml[6]);    // Hidden. Grid1의 Dest Point.
	
		                   }
		        		   
		        		   ComOpenWait(false);
		        		   
	        		   } catch (e) {
	        	            if (e == "[object Error]") {
	        	                ComShowMessage(OBJECT_ERROR);
	        	            } else {
	        	                ComShowMessage(e);
	        	            }
	        	       } finally {
	        	    	   ComOpenWait(false);
	        	       }
	        		   
	        		   toggleButtons("SEARCH");
	        	   }	   
	        	   break;

			 case IBSAVE:        //저장
				 
				 	if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
				 	
				 	  
		            if (sheetObj.id == "sheet2") {
		            	
		            	formObj.f_cmd.value = MULTI01;
		            	
		            	//전체 sheet status를 재 세팅
		                for (var i = 4; i < 10; i++) {
		                	setRowStatus(sheetObjects[i],"I");
                        }
		                
//		            	setRowStatusAmt(sheetObjects[3],"I");
		            	
		                var sParam = FormQueryString(formObj);
		                var sParamSheet1 = sheetObjects[1].GetSaveString();
		                if (sParamSheet1 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
		                }
		                var sParamSheet2 = sheetObjects[3].GetSaveString();
		                if (sParamSheet2 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
		                }
		                var sParamSheet3 = sheetObjects[4].GetSaveString();
		                if (sParamSheet3 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet3, "sheet3_");
		                }
		                var sParamSheet4 = sheetObjects[5].GetSaveString();
		                if (sParamSheet4 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet4, "sheet4_");
		                }
		                var sParamSheet5 = sheetObjects[6].GetSaveString();
		                if (sParamSheet5 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet5, "sheet5_");
		                }
		                var sParamSheet6 = sheetObjects[7].GetSaveString();
		                if (sParamSheet6 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet6, "sheet6_");
		                }
		                var sParamSheet7 = sheetObjects[8].GetSaveString();
		                if (sParamSheet7 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet7, "sheet7_");
		                }
		                var sParamSheet8 = sheetObjects[9].GetSaveString();
		                if (sParamSheet8 != "") {
		                    sParam += "&" + ComPriSetPrifix(sParamSheet8, "sheet8_");
		                }
		                

		               if(eventStatus != "ALLSAVE") {
		                	
			                if (!supressConfirm && !ComPriConfirmSave()) {
			                	return false;
			                }
		               }
		               
		               try {
			                ComOpenWait(true);
			               
			                if(eventStatus != "ALLSAVE") eventStatus = "IBSAVE";
			               
			                var sXml = sheetObj.GetSaveXml("ESM_PRI_6001GS.do", sParam);
			                
			                ComOpenWait(false);
			                
		               } catch (e) {
	        	            if (e == "[object Error]") {
	        	                ComShowMessage(OBJECT_ERROR);
	        	            } else {
	        	                ComShowMessage(e);
	        	            }
	        	       } finally {
	        	    	   ComOpenWait(false);
	        	       }
			                

		                if (eventStatus != "ALLSAVE") {
		                	ComPriSaveCompleted();
		                }	
		                	

		                if (eventStatus != "ALLSAVE") {
		                	isFiredNested = true;
							doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
							isFiredNested = false;	
							
							var validRow = ComGetValidRow(sheetObjects[1],"bse_seq",selectedBseSeq);

					 		if(validRow != -1 && validRow != 1) {
					 			sheetObjects[1].SelectCell(validRow,0,false);
					 		} else {
					 			
					 			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D") {
					            	 
					            	 formObj.bse_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"bse_seq");
					               
					                 doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
					                 adjNewRow = ComGetValidRow(sheetObjects[3],"cmpb_seq",selectedCmpbSeq);
					                 sheetObjects[3].SelectCell(adjNewRow,0,false);
					         
				            	 }  
					 			
					 		}
		                }
		                
	                	if (eventStatus != "ALLSAVE") eventStatus = "";
	                	
	                	
	                
	                    return true;

		            } 
		            //헤더저장
		            else if (sheetObj.id == "sheet0") {
		            	
		            	if (eventStatus != "ALLSAVE") {
		            		if(!ComPriConfirmSave()) return false;
			            }
		            	
		            	if(eventStatus != "ALLSAVE") eventStatus = "IBSAVE";
		            	
		            	if(isOneYearBefore(getEffEtCd())) {

		            		ComShowCodeMessage('PRI03010');
		            	}
		            	try {
			            	ComOpenWait(true);
			            	
			            	formObj.f_cmd.value = MULTI06;
			       			
			            	var sParam = FormQueryString(formObj);
			               
							var sXml = sheetObj.GetSaveXml("ESM_PRI_6001GS.do", sParam);
							sheetObjects[0].LoadSaveXml(sXml);
							//sheetObjects[3].LoadSaveXml(sXml);
							
							ComOpenWait(false);
							
		            	 } catch (e) {
		        	            if (e == "[object Error]") {
		        	                ComShowMessage(OBJECT_ERROR);
		        	            } else {
		        	                ComShowMessage(e);
		        	            }
		        	    } finally {
		        	         ComOpenWait(false);
		        	    }	
		                 
						if(errMsg != "") {
							errMsg = "";
						}
						else {
							ComPriSaveCompleted();
							
							//날짜 콤보 재세팅
							doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
							isFiredNested = true;
							doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
							isFiredNested = false;
							
							
							var validRow = ComGetValidRow(sheetObjects[1],"bse_seq",selectedBseSeq);
					 		
							if(validRow != -1 && validRow != 1) {
					 			sheetObjects[1].SelectCell(validRow,0,false);
					 		}  else {
					 			
					 			if (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) != "D") {
					            	 
					            	 formObj.bse_seq.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"bse_seq");
					               
					                 doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
					                 adjNewRow = ComGetValidRow(sheetObjects[3],"cmpb_seq",selectedCmpbSeq);
					                 sheetObjects[3].SelectCell(adjNewRow,0,false);
					         
				            	}  
					 			
					 		}
							
						}
						
		            }
		            
		            if (eventStatus != "ALLSAVE") eventStatus = "";
		            
		            
		            return true;
		            break;
		            
			  case IBSEARCH_ASYNC01:        //all delete
				    if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC01)) {
						if (ComPriConfirmDeleteAll()) {
							
							try {
								ComOpenWait(true);
						
							 	formObj.f_cmd.value = MULTI03;
							 	
							 	var sParam = FormQueryString(formObj);
								
								var sXml = sheetObj.GetSaveXml("ESM_PRI_6001GS.do", sParam);
			
								ComOpenWait(false);
								
							 } catch (e) {
			        	            if (e == "[object Error]") {
			        	                ComShowMessage(OBJECT_ERROR);
			        	            } else {
			        	                ComShowMessage(e);
			        	            }
			        	       } finally {
			        	    	   ComOpenWait(false);
			        	       }	
							
							ComPriDeleteCompleted();
							removeAll2(formObj);
							
							
						}	
				    }
					break;		       
		            
				 
			 case IBSEARCH_ASYNC02:        //컨폼
					
				   if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC02)) {
						if (ComPriConfirmConfirm()) {
							
							try {
								ComOpenWait(true);
								
								formObj.f_cmd.value = MULTI04;
								
								//formObj.cfm_flg.value = "Y";
								
								var sParam = FormQueryString(formObj);
								
								var sXml = sheetObj.GetSaveXml("ESM_PRI_6001GS.do", sParam);
			
								ComOpenWait(false);
							
							 } catch (e) {
			        	            if (e == "[object Error]") {
			        	                ComShowMessage(OBJECT_ERROR);
			        	            } else {
			        	                ComShowMessage(e);
			        	            }
			        	       } finally {
			        	    	   ComOpenWait(false);
			        	       }	
							
							ComPriConfirmCompleted();
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							
						}	
				    }
					break;	
					
			 case IBSEARCH_ASYNC03:        //컨폼 CANCEL
				    if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC03)) {
						if (ComPriConfirmCancelConfirm()) {
							
							try {
								
								ComOpenWait(true);
						
							 	formObj.f_cmd.value = MULTI05;
							 	
							 	//formObj.cfm_flg.value = "N";
								
								var sParam = FormQueryString(formObj);
								
								var sXml = sheetObj.GetSaveXml("ESM_PRI_6001GS.do", sParam);
			
								ComOpenWait(false);
								
							 } catch (e) {
			        	            if (e == "[object Error]") {
			        	                ComShowMessage(OBJECT_ERROR);
			        	            } else {
			        	                ComShowMessage(e);
			        	            }
			        	       } finally {
			        	    	   ComOpenWait(false);
			        	       }	
							
							ComPriCancelConfirmCompleted();
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
							
						}	
				    }
					break;	
		
			case IBINSERT: // Row Add
				
					if (validateForm(sheetObj,document.form,sAction)) {
						if (sheetObj.id == "sheet1") {
						
							var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBINSERT);
							if (idx < 0) {
								return false;
							}
							//service scoup
							sheetObj.CellValue(idx, "svc_scp_cd") 	  = getSvcScpCd();
							//cre_ofc_cd
							sheetObj.CellValue(idx, "cre_ofc_cd") 	  = formObj.cre_ofc_cd.value;
							//Gline Seq
							sheetObj.CellValue(idx, "gline_seq") 	  = formObj.gline_seq.value;
							//customer type
							sheetObj.CellValue(idx, "prs_cust_tp_cd") = getPrsCustTpCd();
							//bse sequence
							sheetObj.CellValue(idx, "bse_seq") 	  	  = parseInt(ComPriGetMax(sheetObj, "bse_seq"),10) + 1;
							//신규로우 세팅
							formObj.bse_seq.value = sheetObj.CellValue(idx, "bse_seq");
							for (var i = 3; i < sheetObjects.length; i++) {
				                sheetObjects[i].RemoveAll();
				            }
							
							sheet1_OnPopupClick(sheetObj, idx, 4);
						}
						
						
						if (sheetObj.id == "sheet2") {
						 
							
			            	var bAddRow = false;
			            	var rowCnt = getValidRowCount(sheetObj);
			            	
			            	//Data가 한건도 없을경우 MQC의 데이터를 읽어온다.
			            	if (rowCnt == 0) {
			            		
			            		try {
				            		ComOpenWait(true);
				            		
				                    formObj.f_cmd.value = SEARCH01;
				                    var sXml = sheetObj.GetSearchXml("ESM_PRI_6004GS.do", FormQueryString(formObj));
				                    
				                    ComPriXml2Sheet(sheetObj, sXml, 2);
				                    
				                    sheetObj.SelectCell(1, "mqc_rng_fm_qty", false);
				                    
				                    if (getValidRowCount(sheetObj) > 0) {
					                    for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow && sheetObj.RowCount > 0; i++) {
					                    	if (sheetObj.RowStatus(i) == "D") {
					                    		continue;
					                    	}
					                    	initSheetData(sheetObj,formObj,i,true);
					                    	sheetObj.RowStatus(i) = "I";
					                    }
				                    } else {
				                    	bAddRow = true;
				                    }
				                    
				                    ComOpenWait(false);
				                    
			            		} catch (e) {
			        	            if (e == "[object Error]") {
			        	                ComShowMessage(OBJECT_ERROR);
			        	            } else {
			        	                ComShowMessage(e);
			        	            }
			        	        } finally {
			        	    	    ComOpenWait(false);
			        	        }
				                    
				            }
				            	
			            	if (bAddRow || rowCnt > 0) {
								var insRow = sheetObj.DataInsert();
								initSheetData(sheetObj,formObj,insRow,false);
			            	}
				            	
				       }
						
						
					}
					break;
					
			case IBCOPYROW: // Row Copy
				
				if (validateForm(sheetObj,document.form,sAction)) {
					if (sheetObj.id == "sheet1") {
//						var idx = doRowChange(sheetObjects[1], sheetObjects[3], sheetObjects[1].SelectRow, 
//								              sheetObjects[1].SelectRow + 1, sheetObjects[1].SelectCol, "3");
						var idx = doRowChange(sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, IBCOPYROW);
						if (idx < 0) {
							return false;
						}
						//service scoup
						sheetObj.CellValue(idx, "svc_scp_cd") 	  = getSvcScpCd();
						//cre_ofc_cd
						sheetObj.CellValue(idx, "cre_ofc_cd") 	  = formObj.cre_ofc_cd.value;
						//Gline Seq
						sheetObj.CellValue(idx, "gline_seq") 	  = formObj.gline_seq.value;
						//customer type
						sheetObj.CellValue(idx, "prs_cust_tp_cd") = getPrsCustTpCd();
						//bse sequence
						sheetObj.CellValue(idx, "bse_seq") 	  	  = parseInt(ComPriGetMax(sheetObj, "bse_seq"),10) + 1;
						//신규로우 세팅
						formObj.bse_seq.value = sheetObj.CellValue(idx, "bse_seq");

						eventStatus = "ROWCOPY";
						
						
						 
		                //sheetObjects copy
		                for (var a = 4; a < 10; a++) {
		                	if (sheetObjects[a].RowCount <= 0) {
		                		continue;
		                	}
		                    for (var i = sheetObjects[a].HeaderRows; i <= sheetObjects[a].LastRow; i++) {
		                        var colName = "";
		                        if (a == 6 || a == 9) {
		                            colName = "rout_pnt_seq";
		                        } else if (a == 7 || a == 8) {
		                            colName = "rout_via_seq";
		                        }

		                        sheetObjects[a].CellValue(i, "bse_seq") = formObj.bse_seq.value;
		                        sheetObjects[a].CellValue(i, colName) = i;
		                        sheetObjects[a].RowStatus(i) = "I";
		                    }
		                }

		                for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow && sheetObjects[3].RowCount > 0; i++) {
		                    sheetObjects[3].CellValue(i, "bse_seq") = formObj.bse_seq.value;
		                    sheetObjects[3].CellValue(i, "cmpb_seq") = i;
		                    sheetObjects[3].RowStatus(i) = "I";
		                }
						
		                
		                
						eventStatus = "";
						

					}
					else if (sheetObj.id == "sheet2") {
						
						copyRowCmpbGuideline(sheetObj,formObj);
						
					}
				}
			
				break;					
					
				
			case IBDELETE: // Delete

				eventStatus = "IBDELETE";
				
				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	
	        	var delCnt = deleteRowCheck(sheetObj, "chk");
	        	if (delCnt > 0 && sheetObj.id == "sheet1") {
					for (var i = 2; i < sheetObjects.length; i++) {
	                	sheetObjects[i].RemoveAll();
	            	}
	        	}
	        			
				break;
					
					
			case IBDOWNEXCEL:        //excel down
				
			   if (validateForm(sheetObj,document.form,IBSEARCH_ASYNC05)) {
				    ComOpenWait(true);
				    formObj.f_cmd.value = SEARCH05;
	                sheetObj.DoSearch("ESM_PRI_6001GS.do", FormQueryString(formObj));
			   }
			   break;	
					
			case IBSEARCH_ASYNC05:        //excel load
				
				if (validateForm(sheetObjects[0],document.form,IBSEARCH_ASYNC05)) {
				    
			    }
				break;	
        	}
    }
    
    
   
    
    
   /**
    * sheet 간의 데이터 이동시 호출하는 function <br>
    * sheet의 모든 데이터를 이동하며 원본 sheet의 데이터는 삭제한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		sheetToSheet (sheetObj1, sheetObj2)
    * </pre>
    * @param {ibsheet} sheetObj1 필수 옮길 데이터가 있는IBSheet Object 
    * @param {ibsheet} sheetObj2 필수 데이터를 로드 할 IBSheet Object(hidden 되어 있음)
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  	 	 
	function sheetToSheet (sheetObj1, sheetObj2){
		//sheetObj1 데이터를 조회XML로 만들기
		if (sheetObj1.RowCount != 0 ){
	   		var sXml = ComMakeSearchXml(sheetObj1, true, "","",false)
	   		//sheetObj2로 조회XML 로드하기

	   		if (sXml !=""){
	   			sheetObj2.LoadSearchXml(sXml);    			
	   		}	
		}

	}
    
    /*******************************************************************
     *  신규추가한 function 시작
     *  
     */
	
   /**
    * Rate sheet 에서 선택한 행을 복사하여 신규행으로 삽입한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		copyRowCmpbGuideline(sheetObj,formObj)
    * </pre>
    * @param {ibsheet} sheetObj1  
    * @param {formObj} formObj 
    * @return 없음
    * @author 이승준
    * @version 2009.05.07
    */  
    function copyRowCmpbGuideline(sheetObj,formObj){
 		if (sheetObj.CheckedRows("chk") <= 0) {
    		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
    	}
 		
 		var checkedRow = sheetObj.FindCheckedRow("chk");
 		
 		if(checkedRow != "") {
 	 		//가져온 행을 배열로 반든다.
 	 		var arrRow = checkedRow.split("|");
 	 		for(var i = 0 ; i < arrRow.length-1 ; i++){
 	 			//(TargetSheet,[SrcColumns],[DestColumns],[StartRow ],[EndRow],
                //        [DestRow],[AddType],[useSameSaveName],[raiseChangeEvent], [SrcCheckCol], [DestCheckCol]) 
 	 			sheetObj.Copy2SheetCol(sheetObj,"","",arrRow[i],arrRow[i],-1,2);
 	 			sheetObj.CellValue(sheetObj.LastRow,"chk") = 0;
 	 			//sheetObj.CellValue(sheetObj.LastRow,"cmpb_seq") = "";
 	 			//cmpb sequence
				sheetObj.CellValue(sheetObj.LastRow, "cmpb_seq") = parseInt(ComPriGetMax(sheetObj, "cmpb_seq")) + 1;
				//alert(sheetObj.CellValue(i, "cmpb_seq"))
 	 		}
 		}
    }
    
    /**
     * 신규 행 삽입시 디폴트 값을 세팅한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		initSheetData(sheetObj,formObj,row)
     * </pre>
     * @param {ibsheet} sheetObj1  
     * @param {formObj} formObj 
     * @param {int} row 
     * @return 없음
     * @author 이승준
     * @version 2009.05.07
     */  
    function initSheetData(sheetObj,formObj,row,isCopy){
 
    	//service scoup
    	sheetObj.CellValue(row, "svc_scp_cd") 	= getSvcScpCd();
		//cre_ofc_cd
		sheetObj.CellValue(row, "cre_ofc_cd") 	= formObj.cre_ofc_cd.value;
		//Gline Seq
		sheetObj.CellValue(row, "gline_seq") 		= formObj.gline_seq.value;
		//customer type
		sheetObj.CellValue(row, "prs_cust_tp_cd") = getPrsCustTpCd();
		var bse_seq = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "bse_seq");
		sheetObj.CellValue(row, "bse_seq") = bse_seq;	
		//cmpb sequence
		sheetObj.CellValue(row, "cmpb_seq") = parseInt(ComPriGetMax(sheetObj, "cmpb_seq")) + 1;
		//alert(sheetObj.CellValue(row, "cmpb_seq"))
		
		if(!isCopy)	sheetObj.CellValue(row, "mqc_rng_fm_qty") = "0";
		
    	sheetObj.CellValue(row, "curr_cd") 		= "USD";
    	sheetObj.CellValue(row, "eff_dt") 	 	= getEffEtCd();
		sheetObj.CellValue(row, "exp_dt") 	  	= formObj.exp_dt.value;
    }
    /*
    *  신규추가한 function 끝
    *  
    *******************************************************************/

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
    function validateForm(sheetObj,formObj,sAction){
    	
    	var cre_ofc_cd = formObj.cre_ofc_cd.value;
 		var user_ofc_cd_hidden = formObj.user_ofc_cd_hidden.value;
 		
 		var isSameOfc = false;
 		
 		//오피스가 같거나 처음 입력이면
 		if(cre_ofc_cd == user_ofc_cd_hidden || ComIsEmpty(user_ofc_cd_hidden)) isSameOfc = true;
    	
   	  	switch (sAction) {
   	 
	    	case IBCREATE: // service scope 선택시
	    		if (ComIsEmpty(getSvcScpCd())) {
 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
 					return false;
 				 }
	    		 return true;
	 			
	 			break;
   	 
	 		case IBSEARCH: // 조회
	 			
	 			if(eventStatus == "COPY") return true;
	 			
	 			if ( sheetObj.id == "sheet0") {
		 			
	 				if (ComIsEmpty(getSvcScpCd())) {
	 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
	 					return false;
	 				}
		 			
	 			} else if ( sheetObj.id == "sheet1") {	
	 				
	 				if (ComIsEmpty(getSvcScpCd())) {
		 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
						return false;
					}
	 			
		 			if (ComIsEmpty(getEffEtCd())) {
		 				ComPriInputValueFailed("input","Duration",comboObjects[1]);
		 				return false;
					}
		 			
		 			if (ComIsEmpty(formObj.exp_dt.value)) {
		 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
						return false;
					}

		 			if (setDash(getEffEtCd()) > formObj.exp_dt.value) {
						ComShowCodeMessage('PRI00305', '[Duration]');
						return false;
					}
		 			
		 			if (ComIsEmpty(getPrsCustTpCd())) {
		 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
						return false;
					}
		 			
	 			}
	 			
				return true;
	 			break;
	 	
	 		case IBSAVE: // 저장
	 			
	 			if(!isSameOfc) return false;
	 			
	 			if ( sheetObj.id == "sheet0") {
	 				
	 				if (ComIsEmpty(getSvcScpCd())) {
	 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
	 					return false;
	 				}
		 			
		 			if (ComIsEmpty(getEffEtCd())) {
		 				ComPriInputValueFailed("input","Duration",comboObjects[1]);
		 				return false;
					}
		 			
		 			if (ComIsEmpty(formObj.exp_dt.value)) {
		 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
						return false;
					}
		 			
		 			if (formObj.eff_dt.value > formObj.exp_dt.value) {
						ComShowCodeMessage('PRI00305', '[Duration]');
						return false;
					}
		 			
		 			if (ComIsEmpty(getPrsCustTpCd())) {
		 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
						return false;
					}
		 			
		 			if (formObj.cfm_flg.value == "Yes") {
		 				ComShowCodeMessage('PRI00105');
						return false;
					}
		 			
		 			
	 			}
	 			
	 			if ( sheetObj.id == "sheet2") {
	 				
	 				if (ComIsEmpty(formObj.gline_seq.value)) return false;
	 			
		 			if (ComIsEmpty(getSvcScpCd())) {
	 	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
	 					return false;
	 				}
		 			
		 			if (ComIsEmpty(getEffEtCd())) {
		 				ComPriInputValueFailed("input","Duration",comboObjects[1]);
		 				return false;
					}
		 			
		 			if (ComIsEmpty(formObj.exp_dt.value)) {
		 				ComPriInputValueFailed("input","Duration",formObj.exp_dt);
						return false;
					}
		 			
		 			if (formObj.eff_dt.value > formObj.exp_dt.value) {
						ComShowCodeMessage('PRI00305', '[Duration]');
						return false;
					}
		 			
		 			if (ComIsEmpty(getPrsCustTpCd())) {
		 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
						return false;
					}
		 			
		 			if (formObj.cfm_flg.value == "Yes") {
		 				ComShowCodeMessage('PRI00105');
						return false;
					}
		 			//변경사항 체크
		       		if (!checkModified(formObj)) {
		       			ComShowCodeMessage("PRI00301");
		       			return false;
		       		}
		       		
		       		//sheet1에서 하나라도 저장했는지 체크
		       		if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
		       			ComPriInputValueFailed("select ","SVC Lane","");
		       			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
	                    return false;
	                }
		       		
		       		//sheet2에서 하나라도 저장했는지 체크
		       		if (getValidRowCount(sheetObjects[1]) >= 1 && (sheetObjects[3].RowCount <= 0 || sheetObjects[3].SelectRow <= 0)) {
		       			if(eventStatus == "") {
			       			ComPriInputValueFailed("input ","MQC(Min)","");
			       			doActionIBSheet(sheetObjects[3], document.form, IBINSERT);
		                    return false;
		       			} else {    
		       				eventStatus = "";
		       			}
	                }
		       		
	
		       		
		       		if (sheetObjects[1].IsDataModified
	                        && sheetObjects[1].GetSaveString() == "") {
	                    return false;
	                }
		       		
	                if (sheetObjects[3].IsDataModified
	                        && sheetObjects[3].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[4].IsDataModified
	                        && sheetObjects[4].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[5].IsDataModified
	                        && sheetObjects[5].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[6].IsDataModified
	                        && sheetObjects[6].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[7].IsDataModified
	                        && sheetObjects[7].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[8].IsDataModified
	                        && sheetObjects[8].GetSaveString() == "") {
	                    return false;
	                }
	                if (sheetObjects[9].IsDataModified
	                        && sheetObjects[9].GetSaveString() == "") {
	                    return false;
	                }
		       		

	                /////////////////////////////////////////////////////////////////////////////////////
					// CMPB Guideline 관련 validate 추가 시작(송민석)
					sheetObj = sheetObjects[3];
					var checkedKeySet = "";
					var rowCount =  sheetObj.LastRow;
					var currKey = "";
					var COL_KEY1 = "rat_ut_cd";
					var COL_KEY2 = "prc_cgo_tp_cd";
					var COL_FROM = "mqc_rng_fm_qty" 
					var COL_TO = "mqc_rng_to_qty" 
					var currKey1 = "";
					var currKey2 = "";
					var fromValue = 0;
					var toValue = 0;
					var fromValue2 = 0;
					var toValue2 = 0;
					for(var i = sheetObj.HeaderRows ; i <= rowCount ; i++ ){
						
						if(sheetObj.RowStatus(i) == "D") continue;
						
						currKey1 = sheetObj.CellText(i,COL_KEY1);
						currKey2 = sheetObj.CellText(i,COL_KEY2);
						currKey = currKey1 +"--"+ currKey2;
						
						//한번이라도 실행했던 key 값은 다시 실행할 필요가 없다.
						if( checkedKeySet.indexOf(currKey) < 0  ){
							//alert("unique");
							fromValue = eval(sheetObj.CellValue(i,COL_FROM));
							toValue = eval(sheetObj.CellValue(i,COL_TO));						
							checkedKeySet = checkedKeySet +"|"+currKey;
							
							//from,to의 데이터가 같거나 to가 더 클경우 더이상 check stop
							if(fromValue >= toValue){
								ComShowCodeMessage('PRI08008');
								sheetObj.SelectCell(i,COL_FROM);
								return false;
							}
							for(var j = i+1 ;  j <= rowCount; j++ ){
								j = sheetObj.FindText(COL_KEY1,currKey1,j);
								if( j < 0 ){
									break;
								}
								
								//키가 같으므로 group으로 판단해서 from, to값을 판단한다.
								if( currKey2 == sheetObj.CellText(j,COL_KEY2) ){
									fromValue2 = eval(sheetObj.CellValue(j,COL_FROM));
									toValue2 = eval(sheetObj.CellValue(j,COL_TO));	
									//from,to의 데이터가 같거나 to가 더 클경우 더이상 check stop
									if(fromValue2 >= toValue2){
										ComShowCodeMessage('PRI08008');
										sheetObj.SelectCell(j,COL_FROM);
										return false;
									}	
									// toValue 보다 fromValue2가 작거나 같으면 에러 
									if(toValue >= fromValue2 ){
										ComShowCodeMessage('PRI00019',i,j);
										sheetObj.SelectCell(j,COL_FROM);
										return false;									
									}
									
								}
							}
						}
						
					}
					// CMPB Guideline 관련 validate 추가 끝		 	
					/////////////////////////////////////////////////////////////////////////////////////
	 			}	
				return true;
	 			break;
	 			
	 		case IBINSERT: // Row Add
	 			
//	 			if (eventStatus == "IBCOPY") {
//	 				return false;
//	 			}
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 				
	 			if(!isSameOfc) return false;
	 			
	 			
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "Yes") {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
				if(ComIsEmpty(formObj.gline_seq.value)) {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
				
	            if (sheetObj.id == "sheet2") {
	            	if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
	                	ComShowCodeMessage("PRI00301");
	                    return false;
	                }
	            }
				
				
				return true;
	 			break;
	 			
	 		
	 		case IBSEARCH_ASYNC01: //all delete
	 			
//	 			if (eventStatus == "IBCOPY") {
//	 				return false;
//	 			}
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 			if(!isSameOfc) return false;
	 			
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "Yes") {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
				return true;
	 			break;	
	 			
	 			
	 		case IBSEARCH_ASYNC02: //confirm
	 			
//	 			if (eventStatus == "IBCOPY") {
//	 				return false;
//	 			}
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 			if(!isSameOfc) return false;
	 		
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "Yes") {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
				//sheet1에서 하나라도 저장했는지 체크
	       		if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
	       			ComPriInputValueFailed("select ","SVC Lane","");
	       			doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
	       		
	       		//sheet2에서 하나라도 저장했는지 체크
	       		if (getValidRowCount(sheetObjects[1]) >= 1 && (sheetObjects[3].RowCount <= 0 || sheetObjects[3].SelectRow <= 0)) {
	       			if(eventStatus == "") {
		       			ComPriInputValueFailed("input ","MQC(Min)","");
		       			doActionIBSheet(sheetObjects[3], document.form, IBINSERT);
	                    return false;
	       			} else {    
	       				eventStatus = "";
	       			}
                }
	       		
	       		if (checkModified(formObj)) {
	       			ComShowCodeMessage("PRI03009","");
	       			return false;
	       		}
				
				return true;
	 			break;
	 			
	 		case IBSEARCH_ASYNC03: //confirm cancel
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 			if(!isSameOfc) return false;
	 			
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scop",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "No") {
					ComShowCodeMessage('PRI00106');
					return false;
				}
				
				return true;
	 			break;
	 			
	 			
	 		case IBCOPYROW: // Row Copy
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 			if(!isSameOfc) return false;
	 			
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "Yes") {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
	            if (sheetObj.id == "sheet2") {
	                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
	                    return false;
	                }
	            }
	            
				return true;
				break;	
	 			
	 			
	 		case IBDELETE: //row Delete
	 			
	 			if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
	 			
	 			if(!isSameOfc) return false;
	 			
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "Yes") {
					ComShowCodeMessage('PRI00105');
					return false;
				}
				
	            if (sheetObj.id == "sheet2") {
	            	if (ComIsEmpty(formObj.gline_seq.value)) {
	       				ComShowCodeMessage('PRI00309', 'Item');
	                    return false;
	                }
	       			
	                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
	                	ComShowCodeMessage("PRI00301");
	                    return false;
	                }
	            }
				return true;
	 			break;
   	  
		    case IBSEARCH_ASYNC05: // 팝업버튼 클릭시
		    	
		    	if (ComIsEmpty(formObj.gline_seq.value)) {
	 				ComShowCodeMessage('PRI08015');
	 				return false;
	 			}
		  		
		    	if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				
		    	return true;
		    	
		    	
		    case IBSEARCH_ASYNC06: // Group Commodity, Group Location
		  		
		    	if (ComIsEmpty(formObj.gline_seq.value)) {
		    		ComShowCodeMessage('PRI08015');
					return false;
                }
		    	
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				
		    	return true;
		    	
		    	
		    case IBSEARCH_ASYNC07: // copy popup
		  		
		    	if (ComIsEmpty(formObj.gline_seq.value)) {
		    		ComShowCodeMessage('PRI08015');
					return false;
                }
		    	
	 			if (ComIsEmpty(comboObjects[0].Text)) {
	 				ComPriInputValueFailed("select","Service Scope",comboObjects[0]);
					return false;
				}
	 			if (formObj.eff_dt.value == "") {
	 				ComPriInputValueFailed("input","Duration",formObj.eff_dt);
					return false;
				}
				if (formObj.exp_dt.value == "") {
					ComPriInputValueFailed("input","Duration",formObj.exp_dt);
					return false;
				}
				if (formObj.eff_dt.value > formObj.exp_dt.value) {
					ComShowCodeMessage('PRI00305', '[Duration]');
					return false;
				}
				if (ComIsEmpty(getPrsCustTpCd())) {
	 				ComPriInputValueFailed("select","Customer Type",comboObjects[2]);
					return false;
				}
				if (formObj.cfm_flg.value == "No") {
					//ComShowCodeMessage('PRI00106');
					return false;
				}
				
		    	return true;	
		    	
			}
   	  	

        return true;
    }

  
    
    /**
     * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
     * 팝업 호출 후 리턴 값을 sheet에 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnPopupClick(sheetObj, Row, Col) 
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {int}  Row        
     * @param {int}  Col    
     * @return 없음
     * @version 2009.06.10
     */
     function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	 
    	 if (!LoadingComplete) {
             return;
         } 
    	 
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        
        if (!validateForm(sheetObj,formObj,IBSEARCH_ASYNC05)) {
			return;
		}
        
        eventStatus = "POPUP";
        
        if (colName == "vsl_slan_cd") {
        	
        	//vsl cd를 |로 세팅
        	var vslCdList = makeVslCd(sheetObjects[4]);
        	
            var sUrl = "/hanjin/ESM_PRI_6039.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
            			"&gline_seq=" + formObj.gline_seq.value + "&prs_cust_tp_cd=" + getPrsCustTpCd() + 
            			"&bse_seq=" + formObj.bse_seq.value + "&svc_scp_nm=" + formObj.svc_scp_nm.value +
            			"&vslCdList=" + vslCdList;
            
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6039", 600, 425, true);
            
            if (rtnVal == "O") {
                var prevStatus = sheetObj.RowStatus(Row);
                var sCd = "";
                var sNm = "";
                
                for (var i = sheetObjects[4].HeaderRows; i <= sheetObjects[4].LastRow; i++) {

                        if (sheetObjects[4].RowStatus(i) == "D") {
                            continue;
                        }
                        sCd += sheetObjects[4].CellValue(i, "vsl_slan_cd");
                        sCd += "; ";
                        
                }
                
                if (sCd != "") {
                	var lastIdx = sCd.lastIndexOf(";");
                	sCd = sCd.substring(0, lastIdx);
                }

                sheetObj.CellValue2(Row, "vsl_slan_cd") = sCd;

            }
        }
        
        if (colName == "prc_cmdt_def_cd") {
            var sUrl = "/hanjin/ESM_PRI_6038.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
            			"&gline_seq=" + formObj.gline_seq.value + "&prs_cust_tp_cd=" + getPrsCustTpCd() + 
            			"&bse_seq=" + formObj.bse_seq.value;
            
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6038", 700, 419, true);
            
            if (rtnVal == "O") {
                var prevStatus = sheetObj.RowStatus(Row);
                var sCd = "";
                var sNm = "";
                
                for (var i = sheetObjects[5].HeaderRows; i <= sheetObjects[5].LastRow; i++) {

                        if (sheetObjects[5].RowStatus(i) == "D") {
                            continue;
                        }
                        sCd += sheetObjects[5].CellValue(i, "prc_cmdt_def_cd");
                        sCd += "; ";
                }
                
                if (sCd != "") {
                	var lastIdx = sCd.lastIndexOf(";");
                	sCd = sCd.substring(0, lastIdx);
                }

                sheetObj.CellValue2(Row, "prc_cmdt_def_cd") = sCd;
//                sheetObjects[2].CellValue2(Row, "prc_cmdt_def_nm") = sNm;
                
                //sheetObj.RowStatus(Row) = prevStatus;
            }
        }

        if (colName == "org_rout_pnt_loc_def_cd") click_route(sheetObj, Row, Col, colName);
        if (colName == "org_rout_via_port_def_cd") click_route(sheetObj, Row, Col, colName);
        if (colName == "dest_rout_via_port_def_cd") click_route(sheetObj, Row, Col, colName);
        if (colName == "dest_rout_pnt_loc_def_cd") click_route(sheetObj, Row, Col, colName);
        
        eventStatus = "";
    }
    
    
     /**
      * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
      * 팝업 화면을 호출한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *     click_route(sheetObj, Row, Col, colName)
      * </pre>
      * @param {ibsheet} sheetObj    필수,IBSheet Object
      * @param {int}  Row        
      * @param {int}  Col    
      * @param {String}  colName   
      * @return 없음
      * @version 2009.06.10
      */
    function click_route(sheetObj, Row, Col, colName) {
        
        var formObj = document.form;
        
        var sUrl = "/hanjin/ESM_PRI_6037.do?";
        var keyParam = "svc_scp_cd=" + getSvcScpCd() 
        				 + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value
        				 + "&gline_seq=" + formObj.gline_seq.value
        				 + "&prs_cust_tp_cd=" + getPrsCustTpCd() 
        				 + "&bse_seq=" + formObj.bse_seq.value ;
        				
        sUrl += keyParam;

        if (colName == "org_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6037", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "org_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "O" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6037", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_via_port_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "V";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6037", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
        if (colName == "dest_rout_pnt_loc_def_cd") {
            sUrl += "&org_dest_tp_cd=" + "D" + "&pnt_via_tp_cd=" + "P";
            var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_6037", 700, 391, true);
            
            if (rtnVal == "O") {
                setSheet2RowData(sheetObj, Row, Col);
            }
        }
       
    }
    
    /**
     * sheet에서 팝업 버튼을 클릭시 발생한다.<br>
     * 팝업 화면에서 히든 쉬트로 값을 로드하면 각행을 구분자로 붙여서 한행으로 메인쉬트에 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheet2RowData(sheetObj, Row, Col)
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {int}  Row        
     * @param {int}  Col    
     * @return 없음
     * @version 2009.06.10
     */
    function setSheet2RowData(sheetObj, Row, Col) {
        var formObj = document.form;
        var prevStatus = sheetObj.RowStatus(Row);
        
        
        
//        if (sheetObjects[6].IsDataModified) {
            var sCd = "";
            var sNm = "";
            
            
            for (var i = sheetObjects[6].HeaderRows; i <= sheetObjects[6].LastRow; i++) {
                if (sheetObjects[6].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[6].CellValue(i, "rout_pnt_loc_def_cd");
//                if (sheetObjects[6].CellValue(i, "rcv_de_term_nm") != null && sheetObjects[6].CellValue(i, "rcv_de_term_nm") != "" && sheetObjects[6].CellValue(i, "rcv_de_term_nm") != "undefined") {
//                	sCd += "(" + sheetObjects[6].CellValue(i, "rcv_de_term_nm") + ")";
//                }
                sCd += "; ";
                
//                sNm += sheetObjects[6].CellValue(i, "rout_pnt_loc_def_nm");
//                if (sheetObjects[6].CellValue(i, "rcv_de_term_nm") != null && sheetObjects[6].CellValue(i, "rcv_de_term_nm") != "") {
//                	sNm += "(" + sheetObjects[6].CellValue(i, "rcv_de_term_nm") + ")";
//                }
//                sNm += "; ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(";");
            	sCd = sCd.substring(0, lastIdx);
            }
//            if (sNm != "") {
//            	var lastIdx = sNm.lastIndexOf(";");
//            	sNm = sNm.substring(0, lastIdx);
//            }
            sheetObj.CellValue2(Row, "org_rout_pnt_loc_def_cd") = sCd;
//            sheetObjects[2].CellValue2(Row, "org_rout_pnt_loc_def_nm") = sNm;
//        }
        
//        if (sheetObjects[7].IsDataModified) {
            var sCd = "";
            var sNm = "";
            
            for (var i = sheetObjects[7].HeaderRows; i <= sheetObjects[7].LastRow; i++) {
                if (sheetObjects[7].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[7].CellValue(i, "rout_via_port_def_cd");
                sCd += "; ";
//                
//                sNm += sheetObjects[7].CellValue(i, "rout_via_port_def_nm");
//                sNm += "; ";
            }
            
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(";");
            	sCd = sCd.substring(0, lastIdx);
            }
//            if (sNm != "") {
//            	var lastIdx = sNm.lastIndexOf(";");
//            	sNm = sNm.substring(0, lastIdx);
//            }
            
            sheetObj.CellValue2(Row, "org_rout_via_port_def_cd") = sCd;
//            sheetObjects[2].CellValue2(Row, "org_rout_via_port_def_nm") = sNm;
//        }
        
//        if (sheetObjects[8].IsDataModified) {
            var sCd = "";
            var sNm = "";
            
            for (var i = sheetObjects[8].HeaderRows; i <= sheetObjects[8].LastRow; i++) {
                if (sheetObjects[8].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[8].CellValue(i, "rout_via_port_def_cd");
                sCd += "; ";
                
//                sNm += sheetObjects[8].CellValue(i, "rout_via_port_def_nm");
//                sNm += "; ";
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(";");
            	sCd = sCd.substring(0, lastIdx);
            }
//            if (sNm != "") {
//            	var lastIdx = sNm.lastIndexOf(";");
//            	sNm = sNm.substring(0, lastIdx);
//            }
            
            sheetObj.CellValue2(Row, "dest_rout_via_port_def_cd") = sCd;
//            sheetObjects[2].CellValue2(Row, "dest_rout_via_port_def_nm") = sNm;
//        }
        
//        if (sheetObjects[9].IsDataModified) {
        	//alert("sheetObjects[9].IsDataModified " + sheetObjects[9].IsDataModified)        	
            var sCd = "";
            var sNm = "";
            
            for (var i = sheetObjects[9].HeaderRows; i <= sheetObjects[9].LastRow; i++) {
                if (sheetObjects[9].RowStatus(i) == "D") {
                    continue;
                }
                sCd += sheetObjects[9].CellValue(i, "rout_pnt_loc_def_cd");
                
//                if (sheetObjects[9].CellValue(i, "rcv_de_term_nm") != null && sheetObjects[9].CellValue(i, "rcv_de_term_nm") != "" && sheetObjects[9].CellValue(i, "rcv_de_term_nm") != "undefined") {
//                	sCd += "(" + sheetObjects[9].CellValue(i, "rcv_de_term_nm") + ")";
//                }
                sCd += "; ";
                
                
//                sNm += sheetObjects[9].CellValue(i, "rout_pnt_loc_def_nm");
//                if (sheetObjects[9].CellValue(i, "rcv_de_term_nm") != null && sheetObjects[9].CellValue(i, "rcv_de_term_nm") != "") {
//                	sNm += "(" + sheetObjects[9].CellValue(i, "rcv_de_term_nm") + ")";
//                }
//                sNm += "; ";
                
            }
            if (sCd != "") {
            	var lastIdx = sCd.lastIndexOf(";");
            	sCd = sCd.substring(0, lastIdx);
            }
//            if (sNm != "") {
//            	var lastIdx = sNm.lastIndexOf(";");
//            	sNm = sNm.substring(0, lastIdx);
//            }
            
            sheetObj.CellValue2(Row, "dest_rout_pnt_loc_def_cd") = sCd;
//            sheetObjects[2].CellValue2(Row, "dest_rout_pnt_loc_def_nm") = sNm;
//        }
        
    }
    
 	
    /**
     * 메인화면 콤보의 값이 바뀐 경우 구분자에 따라 화면을 리셋한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchConditionReset(formObj,gubun)
     * </pre>
     * @param {formObj} formObj    
     * @param {String}  gubun  1: sc change , 2: eff_dt change      
     * @return 없음
     * @version 2009.06.10
     */
 	function searchConditionReset(formObj,gubun) {
 		
 		//if(eventStatus == "IBCOPY") return;
 		
 		//sc change
 		if(gubun == "1") {
 			var cre_ofc_cd = formObj.cre_ofc_cd.value
 			formObj.reset();
 			formObj.cre_ofc_cd.value = cre_ofc_cd;
 			
	 		comboObjects[1].Index2 = "-1";
	 		comboObjects[1].RemoveAll();
	 		comboObjects[2].Index2 = "-1";
	 		
	 		for (var i = 1; i < sheetObjects.length; i++) {
                sheetObjects[i].RemoveAll();
            }
 		} 
 		//eff_dt change
 		else if(gubun == "2") {	
 			
 			var cre_ofc_cd = formObj.cre_ofc_cd.value
 			formObj.reset();
 			formObj.cre_ofc_cd.value = cre_ofc_cd;
 			
 			comboObjects[2].Index2 = "-1";
	 		
 			for (var i = 1; i < sheetObjects.length; i++) {
                sheetObjects[i].RemoveAll();
            }
	 		
 		}
	}
 	
 	
 	/**
     * 날짜에 -를 세팅한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *      setDash(date)
     * </pre>
     * @param {string} 날짜 input box의 value
     * @return string
     * @author 이승준
     * @version 2009.05.18
     */
	function setDash(value) {
		
	   if(value == "" || value.length == 0) return;
	   
	   var date = ComTrimAll(value).replace(/-/g, ""); 
	  
	   var str = "";
	   for(var i=0; i<date.length; i++) {
		   if(i == 4 || i == 6) {
			  str += "-" + date.substring(i,i+1);
		   } 
		   else {
			  str += date.substring(i,i+1);
		   }
	   }
	   //alert("str : " +str)
	   return str;

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
 		
 		if (checkModified(formObj)) {
 			
 			if (ComShowCodeConfirm("PRI00006")) {
 				supressConfirm = true;
 				doActionIBSheet(sheetObjects[3], formObj, IBSAVE);
 				supressConfirm = false;
 			} else {
 				formObj.reset();
 				
 				comboObjects[0].Index = "-1";
 		 		comboObjects[1].Index = "-1";
 		 		comboObjects[1].RemoveAll();
 		 		
 		 		comboObjects[2].Index = "-1";
 		 		
 		 		for (var i = 1; i < sheetObjects.length; i++) {
 	                sheetObjects[i].RemoveAll();
 	            }
 		 		
 			}
 		} else {	
 			formObj.reset();
 			
 			comboObjects[0].Index = "-1";
	 		comboObjects[1].Index = "-1";
	 		comboObjects[1].RemoveAll();
	 		
	 		comboObjects[2].Index = "-1";
	 		
	 		for (var i = 1; i < sheetObjects.length; i++) {
                sheetObjects[i].RemoveAll();
            }
 	 		
 		}
 		
 		toggleButtons("INIT");
 		eventStatus = "";
 		formObj.svc_scp_cd.focus();
	}
 	
 	
 	/**
     * 화면을 전체 리셋한다.(DELETE 시)<br>
     * <br><b>Example :</b>
     * <pre>
     *     removeAll2(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function removeAll2(formObj) {
 		
 		formObj.reset();
 			
		comboObjects[0].Index = "-1";
 		comboObjects[1].Index = "-1";
 		comboObjects[1].RemoveAll();
 		
 		comboObjects[2].Index = "-1";
 		
 		for (var i = 1; i < sheetObjects.length; i++) {
            sheetObjects[i].RemoveAll();
        }
 	 	
 		toggleButtons("INIT");
 		eventStatus = "";
 		formObj.svc_scp_cd.focus();
	}
 	
 	
 	/**
     * sheet를 하나라도 변경한 경우 true 리턴.(날짜포함)<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkModified(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return boolean
     * @author 이승준
     * @version 2009.06.10
     */
 	function checkModified(formObj) {
 		isModified = false;
 		
		if (formObj.exp_dt.value != formObj.exp_dt_hidden.value
    		|| formObj.exp_dt.value != formObj.exp_dt_hidden.value 
    		|| sheetObjects[1].IsDataModified 
    		|| sheetObjects[3].IsDataModified 
    		|| sheetObjects[4].IsDataModified
    		|| sheetObjects[5].IsDataModified
    		|| sheetObjects[6].IsDataModified
    		|| sheetObjects[7].IsDataModified
    		|| sheetObjects[8].IsDataModified
    		|| sheetObjects[9].IsDataModified) {
			
			isModified = true;
		}
 
 		return isModified;
 	}
 	
 	
 	/**
     * sheet를 하나라도 변경한 경우 true 리턴.<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkModifiedDetail(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return boolean
     * @author 이승준
     * @version 2009.06.10
     */
 	function checkModifiedDetail(formObj) {
 		isModified = false;
 		
		if (sheetObjects[1].IsDataModified 
    		|| sheetObjects[3].IsDataModified 
    		|| sheetObjects[4].IsDataModified
    		|| sheetObjects[5].IsDataModified
    		|| sheetObjects[6].IsDataModified
    		|| sheetObjects[7].IsDataModified
    		|| sheetObjects[8].IsDataModified
    		|| sheetObjects[9].IsDataModified) {
			
			isModified = true;
		}
 
 		return isModified;
 	}
 	
 	/**
     * Item sheet에서 변경 사항 체크.<br>
     * <br><b>Example :</b>
     * <pre>
     *     checkModifiedItem(formObj)
     * </pre>
     * @param {formObj} formObj    
     * @return boolean
     * @author 이승준
     * @version 2009.06.10
     */
 	function checkModifiedItem(formObj) {
 		isModified = false;
 		
		if (sheetObjects[3].IsDataModified 
    		|| sheetObjects[4].IsDataModified
    		|| sheetObjects[5].IsDataModified
    		|| sheetObjects[6].IsDataModified
    		|| sheetObjects[7].IsDataModified
    		|| sheetObjects[8].IsDataModified
    		|| sheetObjects[9].IsDataModified) {
			
			isModified = true;
		}
 
 		return isModified;
 	}
 	
 	/**
     * 버튼을 상황에 따라 활성화, 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     toggleButtons(mode)
     * </pre>
     * @param {String} mode    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function toggleButtons(mode) {
 		
 		var formObj = document.form;
 		var cre_ofc_cd = formObj.cre_ofc_cd.value;
 		var user_ofc_cd_hidden = formObj.user_ofc_cd_hidden.value;
 		
 		if(cre_ofc_cd == user_ofc_cd_hidden || ComIsEmpty(user_ofc_cd_hidden)) isSameOfc = true;
 		else isSameOfc = false;
 		
 		var cfm_flg = formObj.cfm_flg.value;
 		
		switch (mode) {
		case "INIT":		//신규
			ComBtnEnable("btn1_Retrieve");
			ComBtnEnable("btn1_New");
			ComBtnEnable("btn1_Save");
			ComBtnDisable("btn1_Delete");
			
			ComBtnDisable("btn1_Down_Excel");
			ComBtnDisable("btn1_Load_Excel");
			
			ComBtnDisable("btn1_Confirm");
			ComBtnDisable("btn1_Confirm_Cancel");
			ComBtnDisable("btn1_Copy");
			
			ComBtnDisable("btn2_CMDT_Group");
			ComBtnDisable("btn2_Loc_Group");
			ComBtnDisable("btn2_MQC_Setting");
			
			ComBtnDisable("btn2_Row_Add");
			ComBtnDisable("btn2_Row_Copy");
			ComBtnDisable("btn2_Row_Delete");
			
			ComBtnDisable("btn3_Row_Add");
			ComBtnDisable("btn3_Row_Copy");
			ComBtnDisable("btn3_Row_Delete");
			ComBtnDisable("btn3_Save");
			
//			sheetControl(false);
			
			break;	
		case "SEARCH":		//조회 후
			enableButton("btn1_Retrieve");
			enableButton("btn1_New");
			if(isSameOfc) {
				ComBtnEnable("btn1_Save");
				if(ComIsEmpty(formObj.cfm_flg))
					ComBtnDisable("btn1_Delete");
				else
					ComBtnEnable("btn1_Delete");
//				ComBtnEnable("btn1_Load_Excel");
			} else {
				ComBtnDisable("btn1_Save");
				ComBtnDisable("btn1_Delete");
//				ComBtnDisable("btn1_Load_Excel");
			}
			
			ComBtnEnable("btn1_Down_Excel");
			
			confrimButtons(formObj,isSameOfc);
			
			break;
		}
		
	}
 	
 	
 	/**
     * cfm_flg에 따라 버튼 토글.<br>
     * <br><b>Example :</b>
     * <pre>
     *     confrimButtons(formObj,isSameOfc)
     * </pre>
     * @param {form} formObj    
     * @param {boolean} isSameOfc : 작성오피스가 자신의 오피스인지 여부
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function confrimButtons(formObj,isSameOfc) {
 		var cfm_flg = formObj.cfm_flg.value;
 		switch (cfm_flg) {
		case "":		//신규
			ComBtnDisable("btn1_Confirm");
			ComBtnDisable("btn1_Confirm_Cancel");
			ComBtnDisable("btn1_Copy");
			
			ComBtnDisable("btn2_CMDT_Group");
			ComBtnDisable("btn2_Loc_Group");
			ComBtnEnable("btn2_MQC_Setting");
			
			ComBtnEnable("btn2_Row_Add");
			ComBtnEnable("btn2_Row_Copy");
			ComBtnEnable("btn2_Row_Delete");
			
			ComBtnEnable("btn3_Row_Add");
			ComBtnEnable("btn3_Row_Copy");
			ComBtnEnable("btn3_Row_Delete");
			ComBtnEnable("btn3_Save");
			
			ComBtnEnable("btn1_Load_Excel");
			
			sheetControl(true);
			
			break;	
		case "No":		//
			if(isSameOfc) {
				ComBtnEnable("btn1_Save");
				ComBtnEnable("btn1_Delete");
				ComBtnEnable("btn1_Confirm");
				ComBtnDisable("btn1_Confirm_Cancel");
				ComBtnDisable("btn1_Copy");
				
				ComBtnEnable("btn2_CMDT_Group");
				ComBtnEnable("btn2_Loc_Group");
				ComBtnEnable("btn2_MQC_Setting");
				
				ComBtnEnable("btn2_Row_Add");
				ComBtnEnable("btn2_Row_Copy");
				ComBtnEnable("btn2_Row_Delete");
				
				ComBtnEnable("btn3_Row_Add");
				ComBtnEnable("btn3_Row_Copy");
				ComBtnEnable("btn3_Row_Delete");
				ComBtnEnable("btn3_Save");
				
				ComBtnEnable("btn1_Load_Excel");
				
				sheetControl(true);
				
			} else {
				ComBtnDisable("btn1_Save");
				ComBtnDisable("btn1_Delete");
				ComBtnDisable("btn1_Confirm");
				ComBtnDisable("btn1_Confirm_Cancel");
				ComBtnDisable("btn1_Copy");
				
				ComBtnEnable("btn2_CMDT_Group");
				ComBtnEnable("btn2_Loc_Group");
				ComBtnDisable("btn2_MQC_Setting");
				
				ComBtnDisable("btn2_Row_Add");
				ComBtnDisable("btn2_Row_Copy");
				ComBtnDisable("btn2_Row_Delete");
				
				ComBtnDisable("btn3_Row_Add");
				ComBtnDisable("btn3_Row_Copy");
				ComBtnDisable("btn3_Row_Delete");
				ComBtnDisable("btn3_Save");
				
				ComBtnDisable("btn1_Load_Excel");
				
				sheetControl(false);
			}
			
			break;
		case "Yes":		//
			if(isSameOfc) {
				ComBtnDisable("btn1_Save");
				ComBtnDisable("btn1_Delete");
				ComBtnDisable("btn1_Confirm");
				ComBtnEnable("btn1_Confirm_Cancel");
				ComBtnEnable("btn1_Copy");
				
				ComBtnEnable("btn2_CMDT_Group");
				ComBtnEnable("btn2_Loc_Group");
				ComBtnDisable("btn2_MQC_Setting");
				
				ComBtnDisable("btn2_Row_Add");
				ComBtnDisable("btn2_Row_Copy");
				ComBtnDisable("btn2_Row_Delete");
				
				ComBtnDisable("btn3_Row_Add");
				ComBtnDisable("btn3_Row_Copy");
				ComBtnDisable("btn3_Row_Delete");
				ComBtnDisable("btn3_Save");
				
				ComBtnDisable("btn1_Load_Excel");
				
				sheetControl(false);
				
			} else {
				ComBtnDisable("btn1_Save");
				ComBtnDisable("btn1_Delete");
				ComBtnDisable("btn1_Confirm");
				ComBtnDisable("btn1_Confirm_Cancel");
				ComBtnEnable("btn1_Copy");
				
				
				ComBtnEnable("btn2_CMDT_Group");
				ComBtnEnable("btn2_Loc_Group");
				ComBtnDisable("btn2_MQC_Setting");
				
				ComBtnDisable("btn2_Row_Add");
				ComBtnDisable("btn2_Row_Copy");
				ComBtnDisable("btn2_Row_Delete");
				
				ComBtnDisable("btn3_Row_Add");
				ComBtnDisable("btn3_Row_Copy");
				ComBtnDisable("btn3_Row_Delete");
				ComBtnDisable("btn3_Save");
				
				ComBtnDisable("btn1_Load_Excel");
				
				sheetControl(false);
			}
			break;
		
		}	
	}
 	
 
 	
 	/**
     * IBSheet의 Cell을  컨폼 여부에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sheetControl(mode);
     * </pre>
     * @param   {boolean} flag 필수          
     * @return 없음
     * @author 이승준
     * @version 2009.04.17
     */   
     function sheetControl(flag) {
	     	var sheetObj1 = sheetObjects[1];
	     	var sheetObj2 = sheetObjects[3];
	     	
			for (var i = 1; i <= sheetObj1.RowCount;i++) {
				sheetObj1.CellEditable(i, "chk") = flag;
				sheetObj1.CellEditable(i, "vsl_slan_cd") = flag;
				sheetObj1.CellEditable(i, "prc_cmdt_def_cd") = flag;
				sheetObj1.CellEditable(i, "org_rout_pnt_loc_def_cd") = flag;
				sheetObj1.CellEditable(i, "org_rout_via_port_def_cd") = flag;
				sheetObj1.CellEditable(i, "dest_rout_via_port_def_cd") = flag;
				sheetObj1.CellEditable(i, "dest_rout_pnt_loc_def_cd") = flag;
		    }
			
			for (var i = 1; i <= sheetObj2.RowCount;i++) {
				sheetObj2.CellEditable(i, "chk") = flag;
				sheetObj2.CellEditable(i, "mqc_rng_fm_qty") = flag;
				sheetObj2.CellEditable(i, "mqc_rng_to_qty") = flag;
				sheetObj2.CellEditable(i, "rat_ut_cd") = flag;
				sheetObj2.CellEditable(i, "prc_cgo_tp_cd") = flag;
				sheetObj2.CellEditable(i, "curr_cd") = flag;
				sheetObj2.CellEditable(i, "cmpb_amt") = flag;
			}

     }  
 	
 	
 	/**
     * description sheet에서 전체로우의 데이터가 없는 경우 row delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *    deleteRowEmpty(sheetObj, Row)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {int} Row  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function deleteRowEmpty(sheetObj, Row) {
 		
 		if(ComIsEmpty(sheetObj.CellValue(Row,"vsl_slan_cd")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"prc_cmdt_def_nm")) &&		
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_pnt_loc_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_via_port_def_nm")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_pnt_loc_def_nm")) ) {
     			
 			sheetObj.RowDelete(Row, false);
     	}
 	}
 	
 	
 	
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(SVC Lane)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet3_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
 		var vsl_slan_cd = "";
        if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "vsl_slan_cd");
//        	var xmlStr = ComPriSheet2Xml(sheetObj, "vsl_slan_cd");
        	
        	
//        	if (contentXml.length > 1) {
//	        	alert(contentXml[0])
        		
        		sheetObjects[2].RemoveAll();
        	
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "vsl_slan_cd");
	        	arrData = ComPriXml2Array(arrXml, "vsl_slan_cd");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"vsl_slan_cd") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
	
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}	
	//	        		vsl_slan_cd += arrData[i];
		        		sheetObjects[2].CellValue2(i+1,"vsl_slan_cd") = arrData[i];
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//        	}
	        	//sheetObjects[2].SelectCell(1,"vsl_slan_cd");
        }
       
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(CMDT)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet4_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "prc_cmdt_def_nm");
//        	if (contentXml.length > 2) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "prc_cmdt_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "prc_cmdt_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
	
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"prc_cmdt_def_nm") = arrData[i];
		        	}
		        	
	        	}
//        	}	
//	        	sheetObjects[2].SelectCell(1,"prc_cmdt_def_nm");
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(ROUT POINT ORIGIN)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet5_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet5_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_pnt_loc_def_nm");
//        	if (contentXml.length > 3) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");
//	        	alert(arrData.length)
	        	if(typeof arrData != "undefined" && arrData != null) {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
	        		var rcv_de_term_nm = "";

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
	
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		//rcv_de_term_nm
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"org_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        			
		        		
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"org_rout_pnt_loc_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(ROUT VIA ORIGIN)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet6_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet6_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "org_rout_via_port_def_nm");
//        	if (contentXml.length > 4) {
        		
	        	var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");

	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
	
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"org_rout_via_port_def_nm") = arrData[i];
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
        }
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(ROUT VIA DEST)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet7_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet7_OnSearchEnd(sheetObj, ErrMsg) {
 		
	   	if (ErrMsg == "") {
//	    	sXmlContents += ComPriSheet2XmlContent(sheetObj, "dest_rout_via_port_def_nm");
//	    	if (contentXml.length > 5) {

	    		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_via_port_def_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_via_port_def_nm");
//	        	alert(arrData.length)
	        	if(typeof arrData != "undefined") {
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}
	        		
		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;
	
		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_via_port_def_nm") = arrData[i];
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
//	        	sheetObjects[2].SelectCell(1,"rout_via_port_def_nm");
//        	}	
	    }
          
    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(ROUT POINT DEST)<br>
     * 각 히든 sheet에서 decription sheet로 decription을 세팅함<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet8_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet8_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {
//        	sXmlContents += ComPriSheet2XmlContent(sheetObj, "dest_rout_pnt_loc_def_nm");
        	//if (contentXml.length > 6) {
	
        		var arrData  = new Array();
	        	var arrXml = ComPriSheet2Xml(sheetObj, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	arrData = ComPriXml2Array(arrXml, "rout_pnt_loc_def_nm|rcv_de_term_nm");
	        	
	        	if(typeof arrData != "undefined") {
	        		
//	        		sheetObjects[2].RemoveAll();
	        		
	        		for(var i=1; i<=sheetObjects[2].RowCount; i++) {
		        		
		        		sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = "";
		        		
		        		deleteRowEmpty(sheetObjects[2], i+1);
		        	}

		        	for(var i=0; i<arrData.length; i++) {
		        		var insertCount = arrData.length - sheetObjects[2].RowCount;

		        		if(insertCount > 0) {
		        			sheetObjects[2].DataInsert();
		        			insertCount--;
		        		}

		        		var rcv_de_term_nm = "";
		        		if(arrData[i][1] != "" && arrData[i][1] != null && arrData[i][1] != "undefined") 
		        			rcv_de_term_nm = "(" + arrData[i][1] + ")";
		        		
		        			sheetObjects[2].CellValue2(i+1,"dest_rout_pnt_loc_def_nm") = arrData[i][0] + rcv_de_term_nm;
		        	}
		        	
		        	//sheetObjects[2].CellValue(1,"vsl_slan_cd") = vsl_slan_cd;
	        	}
	        	
        	//}	
 		}		
 		sheetObjects[2].SelectCell(1,"Seq");

    }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.(CMDT)<br>
     * DESCRTION SHEET의 첫행으로 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet9_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet9_OnSearchEnd(sheetObj, ErrMsg) {
 		if (ErrMsg == "") {

 			sheetObj.SelectCell(0,"chk");	
 		}		
     }
 	
 	/**
     * sheet에서 조회가 끝난 후 호출됨.<br>
     * 엑셀 조회용 쉬트<br>
     * <br><b>Example :</b>
     * <pre>
     *    sheet10_OnSearchEnd(sheetObj, ErrMsg)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {String} ErrMsg  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function sheet10_OnSearchEnd(sheetObj, ErrMsg) {
// 		 if (sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
 			
 		try {
// 			ComOpenWait(true);

 			if(sheetObj.SearchRows > 0) {

	 			var rout_dp_seq = sheetObj.CellValue(sheetObj.LastRow,"cnt_svc_lane");

	 			var max_arr = rout_dp_seq.split(";");
	 			//svc lane 마스터 건수
	 			var max_cnt = max_arr[1];
	 					
	 			//max rout_dp_seq 
	 			var max_rout_dp_seq = ComPriGetMax(sheetObj, "rout_dp_seq");
	 			
	 			for(var i=1; i<=max_rout_dp_seq; i++) {
	 	 			
	 				var chkArr = ComPriSheetFilterRows(sheetObj, "cnt_svc_lane", i+";"+max_cnt);

	 				//마스터 건수와 같으면  blank 처리한다.
	 				if(chkArr.length == max_cnt) {
						for(var k=0; k<chkArr.length; k++) {
				   			sheetObj.CellValue2(chkArr[k], "vsl_slan_cd") = "";
						}	
	 				}
	 				
	 	 		}
	 			
 				
 			
	 			for (var j = sheetObj.SearchRows+1; j >= 0; j--) {
	 				deleteRowEmpty2(sheetObj, j);
	        	}
	 			
	            
	            if(isQuickDouwnExcel) {
	            	 sheetObj.SpeedDown2Excel(-1);
	            } else {
	            	sheetObj.Down2Excel(-1);
	            }
 			}
 			
 			ComOpenWait(false);

 		} catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
       } finally {
    	   ComOpenWait(false);
       }
       
    }
 	
 	
 	/**
     * 엑셀 다운시 전체로우의 데이터가 없는 경우 row delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *    deleteRowEmpty(sheetObj, Row)
     * </pre>
     * @param {sheetObj} sheetObj    
     * @param {int} Row  
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
    function deleteRowEmpty2(sheetObj, Row) {
  	
 		if(ComIsEmpty(sheetObj.CellValue(Row,"rout_dp_seq")) &&		
     		   ComIsEmpty(sheetObj.CellValue(Row,"vsl_slan_cd")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"prc_cmdt_def_cd")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"org_rout_pnt_loc_def_cd")) && 
     		   ComIsEmpty(sheetObj.CellValue(Row,"o	rg_rout_via_port_def_cd")) &&
    		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_via_port_def_cd")) &&
    		   ComIsEmpty(sheetObj.CellValue(Row,"dest_rout_pnt_loc_def_cd")) &&
     		   ComIsEmpty(sheetObj.CellValue(Row,"cmpb_amt"))  ) {
 				
 			sheetObj.RowDelete(Row, false);
     	}
 	}
    
    
 	
 	/**
     * 히든 쉬트의 정보를 XML로 변환하여 리턴한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getSheetXml(sheetNo)
     * </pre>
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function getSheetXml(sheetNo) {
        var formObj = document.form;
        var sXml = "";
        var sCol = "";
        var sValue = "";
        
        if (sheetNo == 5) {
            sCol = "svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq";
            sValue = getSvcScpCd() + "|" + formObj.cre_ofc_cd.value + "|"
            		 + formObj.gline_seq.value + "|" + getPrsCustTpCd() + "|" + formObj.bse_seq.value;
            
        }
        
        sXml = ComPriSheet2Xml(sheetObjects[sheetNo], "", sCol, sValue);
        
        return sXml;
    }
 	
 	
 	/**
 	 * popup 창에서 선택한 row 를 hidden grid에 세팅<br>
     * <br><b>Example :</b>
     * <pre>
     *    setSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        var sCol = "";
        var sValue = "";
        var bAppendMode = 0;
        
        if (sheetNo == 4) {
        	sheetObjects[sheetNo].RemoveAll();
	        sheetObjects[sheetNo].LoadSearchXml(sXml, false);
	    } 
        
        if (sheetNo == 5) {
            bAppendMode = 1;
            sCol = "svc_scp_cd|cre_ofc_cd|gline_seq|prs_cust_tp_cd|bse_seq";
            sValue = getSvcScpCd() + "|" + formObj.cre_ofc_cd.value + "|"
   		 			 + formObj.gline_seq.value + "|" + getPrsCustTpCd() + "|" + formObj.bse_seq.value;
            
        }
        
        sheetObjects[sheetNo].RemoveAll();
        
        ComPriXml2Sheet(sheetObjects[sheetNo], sXml, bAppendMode, sCol, sValue);
        
//        setRowStatus(sheetObjects[sheetNo],"I");
        
    }
 	
 	/**
 	 * 쉬트를 초기화한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    removeSheetXml(sXml, sheetNo)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} sheetNo 쉬트 일련번호    
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function removeSheetXml(sXml, sheetNo) {
        var formObj = document.form;
        
        sheetObjects[sheetNo].RemoveAll();
       
    }
 	
 	
 	/**
 	 * popup에서 값 세팅 시 row status 세팅.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowStatus(sheetObj,status)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} status 쉬트 상태값 (curd)
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setRowStatus(sheetObj,status)  {
 		
 		for(var i=1; i<=sheetObj.RowCount; i++) {
 			sheetObj.RowStatus(i) = status;
 		}

 	}
 	
 	
 	/**
 	 * popup에서 값 세팅 시 Rate sheet row status 세팅.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setRowStatusAmt(sheetObj,status)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @param {String} status 쉬트 상태값 (curd)
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function setRowStatusAmt(sheetObj,status)  {
 		
 		var seq = 0;
 		for(var i=1; i<=sheetObj.RowCount; i++) {
 			sheetObj.CellValue2(i,"cmpb_seq") = i;
 			sheetObj.RowStatus(i) = status;
 		}

 	}
    
 	/**
 	 * 현재 세팅한 VslCd를 |로 연결  세팅 -  SVC LANE<br>
     * <br><b>Example :</b>
     * <pre>
     *    makeVslCd(sheetObj)
     * </pre>
     * @param {sheetObj} sheetObj   
     * @return String
     * @author 이승준
     * @version 2009.06.10
     */
 	function makeVslCd(sheetObj) {
        
        var sStr = "";
        for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            if (sheetObj.RowStatus(i) == "D") {
                continue;
            }
            sStr += sheetObj.CellValue(i, "vsl_slan_cd");
            
            if(i < sheetObj.LastRow) {
            	sStr += "|";
            }
            
        }
        return sStr;
        
    }
 	
 	/**
 	 * Group Commodity popup<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupCmdtGroup()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupCmdtGroup() {
 	
 		 var formObj = document.form;
 		
	 	 if (!validateForm(sheetObjects[1],formObj,IBSEARCH_ASYNC06)) {
				return;
		 }
     
         var sUrl = "/hanjin/ESM_PRI_6041.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
         			"&gline_seq=" + formObj.gline_seq.value + "&prs_cust_tp_cd=" + getPrsCustTpCd() +
         			"&cfm_flg=" + formObj.cfm_flg.value + "&isSameOfc=" + isSameOfc;	
         
         ComPriOpenWindowCenter(sUrl, "ESM_PRI_6041", 900, 322, true);
    }
 	
 	/**
 	 * Group Location popup<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupCmdtGroup()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupLocGroup() {
 	
 		 var formObj = document.form;
 		
	 	 if (!validateForm(sheetObjects[1],formObj,IBSEARCH_ASYNC06)) {
				return;
		 }
     
         var sUrl = "/hanjin/ESM_PRI_6042.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
         			"&gline_seq=" + formObj.gline_seq.value + "&prs_cust_tp_cd=" + getPrsCustTpCd() +
         			"&cfm_flg=" + formObj.cfm_flg.value + "&isSameOfc=" + isSameOfc;	
         
         ComPriOpenWindowCenter(sUrl, "ESM_PRI_6042", 900, 322, true);
    }
 	
 	/**
 	 * MQC popup<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupMQC()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupMQC() {
 	
 		 var formObj = document.form;
 		
	 	 if (!validateForm(sheetObjects[1],formObj,IBSEARCH_ASYNC06)) {
				return;
		 }
     
         var sUrl = "/hanjin/ESM_PRI_6004.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value + 
         			"&gline_seq=" + formObj.gline_seq.value + "&svc_scp_nm=" + formObj.svc_scp_nm.value + 
         			 "&eff_dt=" + formObj.eff_dt.value + "&exp_dt=" + formObj.exp_dt.value;
         
         ComPriOpenWindowCenter(sUrl, "ESM_PRI_6004", 398, 383, true);
    }
 	
 	
 	/**
 	 * Copy popup<br>
     * <br><b>Example :</b>
     * <pre>
     *    popupCopy()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
 	function popupCopy() {
 	
 		 var formObj = document.form;
 		
	 	 if (!validateForm(sheetObjects[1],formObj,IBSEARCH_ASYNC07)) {
				return;
		 }
     
         var sUrl = "/hanjin/ESM_PRI_6036.do?svc_scp_cd=" + getSvcScpCd() + "&cre_ofc_cd=" + formObj.cre_ofc_cd.value +
         			"&prs_cust_tp_cd=" + getPrsCustTpCd() + "&prs_cust_tp_nm=" + getPrsCustTpTxt() + 
         			"&eff_dt=" + formObj.eff_dt.value + "&exp_dt=" + formObj.exp_dt.value +
         			"&gline_seq=" + formObj.gline_seq.value; 
         
         ComPriOpenWindowCenter(sUrl, "ESM_PRI_6036", 700, 237, true);
         
         //searchCopy(rtnVal);
    }
 	
 	/**
 	 * Copy 후 재조회하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     *     searchCopy(cre_ofc_cd,eff_dt,exp_dt,isCopyed)
     * </pre>
     * @param {String} cre_ofc_cd
     * @param {String} eff_dt
     * @param {String} isCopyed
     * @return 없음 
     * @author 이승준
     * @version 2009.06.10
     */
 	function searchCopy(cre_ofc_cd,eff_dt,exp_dt,prs_cust_tp_cd,isCopyed) {
 		
 		eventStatus = "COPY";
 		
 		var formObj = document.form;
 		
 		formObj.cre_ofc_cd.value = cre_ofc_cd;
 		formObj.eff_dt.value = eff_dt;
 		formObj.exp_dt.value = exp_dt
 		
	
 		//Copy 성공여부  재조회시 flag
 		if(!isCopyed) formObj.max_gline_seq.value = "-1";
 		else {
 			//신규로 seq를 땃으므로
 			formObj.gline_seq.value = "";
 			formObj.max_gline_seq.value = "";
 		}
 		
 		
 		//날짜 콤보 재세팅
		doActionIBSheet(sheetObjects[0], formObj, IBCREATE);
		
		formObj.prs_cust_tp_cd.Code2 = prs_cust_tp_cd;
 		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
		
		formObj.max_gline_seq.value = "";
		
		eventStatus = "";
    }
 	
 	/**
 	 * amt 값이 없을 경우 0.00으로 세팅한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     setRateMinMax(idx)
     * </pre>
     * @param {int} idx 현재 Row
     * @return 없음 
     * @author 이승준
     * @version 2009.06.10
     */
 	function setRateMinMax(idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObjects[3].HeaderRows; i <= sheetObjects[3].LastRow; i++) {
                sheetObjects[3].MinimumValue(i, "cmpb_amt") = 0.00;
            }
        } else {
            sheetObjects[3].MinimumValue(idx, "cmpb_amt") = 0.00;
        }
    }
 	
 	
 	/**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * Min값이나 Max값을 변경 시 입력된 값의 validation을 체크한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		sheet2_OnChange(sheetObj, Row, Col, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 이벤트가 발생한 해당 셀의 Column Index
     * @param {string, int, number, bool} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 문동규
     * @version 2009.04.22
     */
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {
        var colName = sheetObj.ColSaveName(Col);

        if (colName == "prc_cgo_tp_cd") {
            if (Value == "AK") {
                var validPerClass = "A,F,O,Q,S,P";
                var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
                if (validPerClass.indexOf(perClass) < 0) {
                    ComShowCodeMessage("PRI08003");
                    sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
                }
            }
        }
        
        if (colName == "rat_ut_cd") {
        	var validPerClass = "A,F,O,Q,S,P";
            var perClass = sheetObj.CellValue(Row, "rat_ut_cd").charAt(0);
            if (perClass == "") {
            	return;
            }
            if (perClass == "D") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "DR"
            } else if (perClass == "R") {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "RF"
            } else if (validPerClass.indexOf(perClass) >= 0) {
            	sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "AK"
            } else {
            	if (sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK") {
	                ComShowCodeMessage("PRI08003");
	                sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
            	}
            }
        }	
	        
    }
    
    
    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * 주소입력시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet9_OnClick(sheetObj, Row, Col, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 이승준
     * @version 2009.06.03
     */  	           
//     function sheet9_OnClick(sheetObj, Row, Col, Value) {
//	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
//	    var colname = sheetObj.ColSaveName(Col);  	 
//	     
//     	switch(colname)
//     	{
//     		case "vsl_slan_cd":
//	    		ComShowMemoPad(sheetObj,Row,Col,true,160,200);
//	    		break;
//     	
// 	    	case "prc_cmdt_def_nm":
// 	    		ComShowMemoPad(sheetObj,Row,Col,true,160,200);
// 	    		break;
// 	    		
// 	    	case "org_rout_pnt_loc_def_nm":
// 	    		ComShowMemoPad(sheetObj,Row,Col,true,160,200);
// 	    		break;	
// 	    	
// 	    	case "org_rout_via_port_def_nm":
// 	    		ComShowMemoPad(sheetObj,Row,Col,true,160,200);
// 	    		break;
// 	    		
// 	    	case "dest_rout_via_port_def_nm":
// 	    		ComShowMemoPad(sheetObj,Row,Col,true,160,200);
// 	    		break;	
// 	    	
// 	    	case "dest_rout_pnt_loc_def_nm":
// 	    		ComShowMemoPad(sheetObj,Row,Col,true,186,200);
// 	    		break;	
// 	    		
//     	}    	 
//
//    }
     
     /**
      * OnSave 이벤트 발생시 호출되는 function <br>
      * 에러 발생시 전역변수에 세팅 <br>
      * <br><b>Example :</b>
      * <pre>
      *		sheet0_OnSaveEnd(sheetObj, ErrMsg)
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {String} ErrMsg 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
      * @return 없음
      * @author 이승준
      * @version 2009.06.03
      */  
     function sheet0_OnSaveEnd(sheetObj, ErrMsg)  {
//  		if (ErrMsg != "") {
  			
  			errMsg = ErrMsg;
  			
  			//ComPriSaveCompleted();
  			//doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
//  		}
  	}
     
     /**
      * 현재 날짜 보다 1년전 인지 체크 <br>
      * <br><b>Example :</b>
      * <pre>
      *		isOneYearBefore(eff_dt)
      * </pre>
      * @param {String} eff_dt 
      * @return boolean 1년 이상이면 true
      * @author 이승준
      * @version 2009.06.03
      */  
     function isOneYearBefore(eff_dt) {
    	 
    	 if(ComIsEmpty(eff_dt)) return false;
    	 
    	 var isBefore = false;
    	 
    	 var effDate = eff_dt.replace(/-/g, ""); 
    	 
    	 vn_day1 = new Date();
    	 vn_day2 = new Date(vn_day1.getYear()-1, vn_day1.getMonth(), vn_day1.getDate());
    	 
//    	 var y = "";
    	 var m = "";
    	 var d = "";
    	 
    	 var pyear = ""+(vn_day1.getYear()-1);
    	 var pmonth = ""+(vn_day2.getMonth()+1);
    	 var pdate = ""+(vn_day2.getDate());
    	 
    	 
    	 if(parseInt(pmonth,10) < 10) {
    		 m = "0"+ pmonth;
    	 } else {
    		 m = ""+pmonth;
    	 }
    	 
    	 
    	 if(parseInt(pdate,10) < 10) {
    		 d = "0"+pdate;
    	 }else {
    		 d = ""+pdate;
    	 }
    	 
    	 var oneYearBefore = pyear+m+d;

    	 
    	 if(parseInt(oneYearBefore,10) > parseInt(effDate,10) ) {
    		 isBefore = true;
    	 }
    	 
    	 return isBefore;

     }
     
     /**
      * excel upload 후 재조회 <br>
      * <br><b>Example :</b>
      * <pre>
      *		reSearch()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 이승준
      * @version 2009.06.03
      */  
     function reSearch() {
    	 doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
     } 
     
     
 	/**
  	 * window가 resize 시 sheet col width를 재조정한다.<br>
  	 * <br><b>Example :</b>
     * <pre>
     *    onResize="sheetColResize();"
     * </pre>
     * @param 없음
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */
  	function sheetColResize() {

//  		var sheetObj1 = sheetObjects[0];
  		var sheetObj1 = sheetObjects[1];
  		var sheetObj2 = sheetObjects[2];
  		var sheetObj3 = sheetObjects[3];
  		
  		sheetObj1.FitColWidth("0|4|0|4|15|15|15|15|15|15|0|0|0|0|0");
  		sheetObj2.FitColWidth("0|0|0|0|6|25|18.5|16|16|16.5");
  		sheetObj3.FitColWidth("0|4|0|4|11|11|11|12|12|14|10|9|0|0|0|0|0|0");
  		
  	}

	/* 개발자 작업  끝 */