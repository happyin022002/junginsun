/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0427.js
*@FileTitle : RDN Status Inquery
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
* 2013.05.21 김진주 [CHM-201324699] [BKG/DOC - Rev. Audit Sys] RDN Status Inquiry 결과값 추가 요청
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
     * @class esm_bkg_0427 : esm_bkg_0427 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0427() {
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
    var sheet1;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var iterator = "|$$|";
    var arrMultiCombo;//멀티콤보 세팅할 변수

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
                	    /*
                		case "btns_calendar": //달력버튼
			    			var cal = new ComCalendarFromTo();
			                cal.select(formObject.rdn_iss_dt_from, formObject.rdn_iss_dt_to, 'yyyy-MM-dd');
			                break;		
						*/
                
            	        case "btns_calendar1": //달력버튼
	        	        	var cal = new ComCalendar();
	        	        	cal.select(form.rdn_iss_dt_from, 'yyyy-MM-dd');
	        	        	break;
        	        
            	        case "btns_calendar2":
	        		        var cal = new ComCalendar();
	        		        cal.select(form.rdn_iss_dt_to, 'yyyy-MM-dd');
	        		        break;
                
    					case "btn_SettledAll":
    						settledAll(formObject);
    						break;
    						
    					case "btn_UnsettledAll":
    						unSettledAll(formObject);
    						break;

    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
    						break;
    						
    					case "btn_New":
    						removeAll(formObject);
    						break;
    						
    					case "btn_DownExcel":
    						doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
    						break;

    					case "btn_Print":
    						//alert(srcName);
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
        	    
    		//IBMultiCombo초기화
     	    for(var k = 0; k < comboObjects.length; k++){
     	        initCombo(comboObjects[k], k + 1);
     	    }

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
            
   	        initIBComboItem();
   	       
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
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.10.20
*/ 
function obj_keypress(){
	var obj = event.srcElement;
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
 		case "rdn_no":
 		case "inv_no":
 		case "vvd_cd":
 		case "iss_ofc_cd":
 		case "gso":
 		case "bl_no":
 		case "ctrt_no":
 			setSearchCond();
 			break;
 		default :
 			ComChkObjValid(formObj);
 			break;
 	}
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
            
            case "rct_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;  
                
            case "respb_rhq_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;      
                
            case "respb_ofc_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
    				ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 6;      // 6자리만 입력
                }
                break;  
                
            case "rev_aud_tool_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 230;
    				UseAutoComplete = true;
    				ValidChar(1, 2);    // 영문만입력 + 특수문자 포함
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
                	ValidChar(2, 2);    // 영문대문자만 입력 + 특수문자
                	
                	comboObj.MultiSelect = true;
        		    comboObj.UseCode = true;
        		 	comboObj.LineColor = "#ffffff";
        		 	comboObj.SetColAlign("left|left");
        		 	comboObj.MultiSeparator = ",";
                }
                break; 
                
            case "rdn_knd_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 200;
    				UseAutoComplete = true;
                	ValidChar(1, 0);    // 영문만 입력 + 특수문자
                	
                	comboObj.MultiSelect = true;
        		    comboObj.UseCode = true;
        		 	comboObj.LineColor = "#ffffff";
        		 	comboObj.SetColAlign("left|left");
        		 	comboObj.MultiSeparator = ",";
                }
                break;
                
                
            }
      	}
        
        /**
         * comboObjects[0]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRctRhqCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRctRhqCd() {
      		return comboObjects[0].Code;
      	}
        /**
         * comboObjects[1]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRctOfcCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRctOfcCd() {
      		return comboObjects[1].Code;
      	}
        /**
         * comboObjects[2]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRespbRhqCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRespbRhqCd() {
      		return comboObjects[2].Code;
      	}
        /**
         * comboObjects[3]의 code값을 리턴<br>
         * <br><b>Example :</b>
         * <pre>
         * 		var code = getRespbOfcCd();
         * </pre>
         * @return String <br>
         * @author 이승준
         * @version 2009.06.10
         */ 
        function getRespbOfcCd() {
      		return comboObjects[3].Code;
      	}
        
        
        /**
         * rct_rhq_cd combo 변경시 활성화됨<br>
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
        		
     		if(comboObjects[0].GetCount () > 0 && comboObjects[0].Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc2.value 	= code;
 				
	 			setOfcCd1();
 					
     		} 
     		
       	}
        
        /**
         * respb_rhq_cd combo 변경시 활성화됨<br>
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
        function respb_rhq_cd_OnChange(comboObj, code, text) {
        	 
           if(comboObj.Index == "0") {
 				comboObjects[3].removeAll();
 				return;
 			}
        		
     		if(comboObjects[2].GetCount () > 0 && comboObjects[2].Index != "-1") {
     			
 				var formObj = document.form;
 				formObj.etc2.value 	= code;
 				setOfcCd2();
 					
     		} 
     		
     		
       	}
        
         /**
         * 이벤트가 발생시 rct_ofc_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setOfcCd1();
         * </pre>
         * @param 없음
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
        function setOfcCd1() {
        	var formObj = document.form;
        	// 조직도 combo2
        	formObj.f_cmd.value = COMMAND02;
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.rct_ofc_cd, "cd", "cd");
			formObj.rct_ofc_cd.InsertItem(0,'','');
		}
        
        
        /**
         * 이벤트가 발생시 respb_ofc_cd 콤보를 조회하고 hidden 값으로 세팅한다.<br>
         * <br><b>Example :</b>
         * <pre>
         * 		setOfcCd2();
         * </pre>
         * @param 없음
         * @return 없음   
         * @author 이승준
         * @version 2009.06.10
         */
        function setOfcCd2() {
        	var formObj = document.form;
        	// 조직도 combo2
        	formObj.f_cmd.value = COMMAND02;
        	formObj.etc2.value = getRespbRhqCd();
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			// 조직도 combo3
 			ComXml2ComboItem(sXml, formObj.respb_ofc_cd, "cd", "cd");
 			formObj.respb_ofc_cd.InsertItem(0,'','');
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
	  //var sXml = ComGetObjValue(formObject.sXml);
		//arrMultiCombo = sXml.split(iterator); 
		
     ComBkgTextCode2ComboItem(rhqComboValue,       rhqComboValue,      getComboObject(comboObjects, 'rct_rhq_cd'),      "|", "\t" );
     ComBkgTextCode2ComboItem(respComboValue,      respComboValue,     getComboObject(comboObjects, 'respb_rhq_cd'),    "|", "\t" );
	 ComBkgTextCode2ComboItem(auditToolComboValue, auditToolComboText, getComboObject(comboObjects, 'rev_aud_tool_cd'), "|", "\t" );
	 ComBkgTextCode2ComboItem(contractTypeComboValue, contractTypeComboText, getComboObject(comboObjects, 'bkg_ctrt_tp_cd'),     "|", "\t" );
	 ComBkgTextCode2ComboItem(discrepancyKindComboValue, discrepancyKindComboText, getComboObject(comboObjects, 'umch_tp_cd'),      "|", "\t" );
	 ComBkgTextCode2ComboItem(rdnKindComboValue, 	    rdnKindComboText,		  getComboObject(comboObjects, 'rdn_knd_cd'), "|", "\t" );
	 form.respb_rhq_cd.InsertItem(0,'','');
  }
  /*
	 * 모든 조건 값들을 초기화 한다.
	 * */
function initCom(formObject){    
		 
		var sXml = ComGetObjValue(formObject.sXml);
		arrMultiCombo = sXml.split(iterator); 
		form.reset();
		comboObj.MultiSelect = true;
		comboObj.UseCode = true;
	 	comboObj.LineColor = "#ffffff";
	 	comboObj.SetColAlign("left|left");
	 	comboObj.MultiSeparator = ",";
		ComXml2ComboItem(arrMultiCombo[0], formObject.umch_tp_cd, "val", "val|desc");
		ComXml2ComboItem(arrMultiCombo[0], formObject.rdn_knd_cd, "val", "val|desc");
		
		
	 	
		
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
             
	     		case "sheet1":      //sheet1 init
					with (sheetObj) {
	
						// 높이 설정
						style.height = 280;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);
						
						var HeadTitle = "|Issue\nOffice|Receipt\nRHQ|Receipt\nOffice|Region|Resp.\nRHQ|Resp.\nOffice|Scope|B/L No.|INV No.|VVD Code|Attachment|" +
								"RDN Kind|RDN No.|RDN Status|Contract\nType|Contract No.|Contract\nHolder|C.OFC/REP.|Error Kind|Error Factor|Error Reason|Error Remarks|USD Amount|" +
								"C/A No.|TPB No.|Remarks (Auditor)|Remarks (Office)|Audit Tool|Issue Date|Update Date|Issuer ID|Settler ID|Receiver ID|Settle Period|" +
								"BKG No.|ctrt_tp_cd|umch_tp_cd|rvis_seq";
						var headCount = ComCountHeadTitle(HeadTitle);
						
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"iss_ofc_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"rct_rhq_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"rct_ofc_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"rgn_ofc_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"respb_rhq_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"respb_ofc_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			45,	daCenter,	true,	"svc_scp_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtPopup,		110,daCenter,	true,	"bl_no",			false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,		    110,daCenter,	true,	"inv_no",			false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,		    80,daCenter,	true,	"vvd_cd",			false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtPopup,		80,daCenter,	true,	"atch_exist",		false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData, 		70,daCenter,	true,	"rdn_knd_cd",		false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtPopup,	    100,daCenter,	true,	"rdn_no",			false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,			80,	daLeft,		true,	"rdn_sts_nm",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,	        70, daCenter,	true,	"ctrt_tp_cd",	    false,	"",  dfNone,	0,	false    ,false );
						InitDataProperty(0, cnt++ , dtPopup,		100,daCenter,	true,	"sc_rfa_no",		false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,		    160,daLeft, 	true,	"ctrt_pty_nm",		false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"c_ofc_rep",		false,	"",	dfNone,		0,	true     ,true );
						InitDataProperty(0, cnt++ , dtData,			140,daLeft,		true,	"umch_tp_cd",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			140,daLeft,		true,	"umch_sub_tp_cd",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,		    140,daLeft,		true,	"rdn_iss_rsn_cd",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			200,daLeft,		true,	"umch_rmk",			false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			100,daRight,	true,	"usd_amt",			false,	"",	dfFloat,	2,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"bkg_corr_no",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"n3pty_no",			false,	"",	dfNone,	    0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			310,daLeft,		true,	"office_rdn_rmk",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			310,daLeft,		true,	"receiver_rdn_rmk",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			140,daLeft,	    true,	"rev_aud_tool_nm",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rdn_iss_dt",		false,	"",	dfDateYmd,	0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"upd_dt",			false,	"",	dfDateYmd,	0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"iss_usr_id",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"stl_usr_id",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"receiver_usr_id",	false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"stl_prd_dys",		false,	"",	dfNone,		0,	false    ,false );
						
						InitDataProperty(0, cnt++ , dtData,			95,	daLeft,	    true,	"bkg_no",			false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtHidden, 		90, daLeft, 	false,  "ctrt_tp_cd", 		false,   "", dfNone, 	0,  false    ,false );
						InitDataProperty(0, cnt++ , dtHidden, 		90, daLeft, 	false,  "umch_tp_cd", 		false,   "", dfNone, 	0,  false    ,false );
						InitDataProperty(0, cnt++ , dtHidden,	    100,daCenter,	true,	"rvis_seq",			false,	"",	dfNone,		0,	true     ,true );
						
						ShowButtonImage = 2;
		                UnEditableColor = RgbColor(255,255,255);             						
						FrozenCols = 9;
						ColHidden("bkg_no") = true;
						//ColHidden("ctrt_tp_cd") = true;
					}
					break;
             
	     		case "sheet2":      //sheet1 init
					with (sheetObj) {
	
						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(1, 1, 2, 100);
						
						var HeadTitle = "ttl_cnt|ttl_usd_amt|within_10_dys|within_20_dys|over_20_dys|over_20_dys_rto";
						var headCount = ComCountHeadTitle(HeadTitle);
						
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"ttl_cnt",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"ttl_usd_amt",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"within_10_dys",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"within_20_dys",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"over_20_dys",		false,	"",	dfNone,		0,	false    ,false );
						InitDataProperty(0, cnt++ , dtData,			55,	daCenter,	true,	"over_20_dys_rto",		false,	"",	dfNone,		0,	false    ,false );
						
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
            switch(sAction) {
              
	            case IBCLEAR:
					break;	
            
            	case IBSEARCH:      //조회
            	
            		if (validateForm(sheetObj,formObj,sAction)) {
            			formObj.f_cmd.value = SEARCH01;
            			
        	    		ComOpenWait(true);		
        	    		sheetObj.WaitImageVisible = false;
            			
           				// 2.조회조건으로 조회실행
           				var sXml = sheetObj.GetSearchXml("ESM_BKG_0427GS.do", FormQueryString(formObj));

           				// 3.조회후 결과처리
           				var arrXml = sXml.split("|$$|");
           				
           				var State = ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
           				
           				if ( State == "S" ) {
           					sheetObjects[1].LoadSearchXml(arrXml[0]);
           					sheetObjects[2].LoadSearchXml(arrXml[1]);
           				}
           			              			    
           			    
        	    		ComOpenWait(false);		

    	        	}    
            	    break;
            	
            	case IBDOWNEXCEL:
            		sheetObj.Down2Excel(-1);
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
        function validateForm(sheetObj,formObj,sAction){
	       	switch (sAction) {
	       	    
	   	 		case IBSEARCH: // 조회
	   	 		
			 		var fmDtObj = form.rdn_iss_dt_from;
			 		var toDtObj = form.rdn_iss_dt_to;
			 		var fmDtValue = fmDtObj.value.replace(/-/g, "");
			 		var toDtValue = toDtObj.value.replace(/-/g, "");
			 		var rdnNoObj  = form.rdn_no;
			 		var blNoObj   = form.bl_no;
			 		var isChkDt   = true; 

			 		if(rdnNoObj.value.length > 0 || blNoObj.value.length > 0){
			 			isChkDt = false;
			 		}
			 		
		    		if(!ComChkObjValid(fmDtObj)) { return false; }
		    		if(!ComChkObjValid(toDtObj)) { return false; }
		    		
			 		if( "" == fmDtValue && "" == toDtValue && rdnNoObj.value.length == 0 && blNoObj.value.length == 0 ){
	 					 ComShowCodeMessage("BKG95025", "Date or RDN No or B/L No"); // "Please input {?msg2}."
	 					 return false;
			 		}
		    		
	 		 		if( isChkDt && ("" == fmDtValue || "" == toDtValue) ){
	 					 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
	 					 if("" == fmDtValue){
	 	 					 ComSetFocus(fmDtObj);
	 					 }else{
	 	 					 ComSetFocus(toDtObj);
	 					 }
	 					 return false;
	 		 		}
			 		
	 	 			if( ("" != fmDtValue && "" != toDtValue) && parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
	 					 ComShowCodeMessage("BKG95026", "From Date", "To Date");
	 					 ComSetFocus(fmDtObj);
	 					 return false;
	 		 		}

	 	 			if(isChkDt) {
	 	 				/*윤년인 경우 366일로 조회 가능해야 하기 때문에 기존 364에서 365로 validation 기준 변경*/
		 	 			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 365, "", true);
		 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
		 	 				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
		 	 				ComSetFocus(fmDtObj);
		 	 				return false;
		 	 			}
	 		 		}
	 		 		
			   	 	makeInParam(formObj);
	    			
	   				return true;
	   	 			break;
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
 	 		formObj.reset();
 	 		comboObjects[0].Index = "-1";
 	 		comboObjects[1].removeAll();
 	 		comboObjects[2].Index = "-1";
 	 		comboObjects[3].removeAll();
 	 		sheetObjects[1].RemoveAll();
 	 		
 		}
 	 	
 	 	/**
	     * settle all 클릭시 settled, canceled 체크 또는 언체크한다.<br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     settledAll(formObj)
	     * </pre>
	     * @param {form} formObj    
	     * @return 없음
	     * @author 이승준
	     * @version 2009.06.10
	     */
 	 	function settledAll(formObj) {
 	 		
 	 		formObj.all.checked = false;
 	 		
 	 		formObj.rdn_sts_check[0].checked = false;
 	 		formObj.rdn_sts_check[1].checked = false;
 	 		formObj.rdn_sts_check[2].checked = false;
 	 		formObj.rdn_sts_check[3].checked = false;
 	 		formObj.rdn_sts_check[4].checked = false;
 	 		
 	 		formObj.rdn_sts_check[5].checked = true;
 	 		formObj.rdn_sts_check[6].checked = true;
 	 		formObj.rdn_sts_check[7].checked = true;
 	 		
 		}
 	 	
 	 	
 	 	/**
	     * unsettle all 클릭시 settled, canceled 외 체크 또는 언체크한다.<br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     unSettledAll(formObj)
	     * </pre>
	     * @param {form} formObj    
	     * @return 없음
	     * @author 이승준
	     * @version 2009.06.10
	     */
 	 	function unSettledAll(formObj) {
 	 		
 	 		formObj.all.checked = false;
 	 		
 	 		formObj.rdn_sts_check[0].checked = true;
 	 		formObj.rdn_sts_check[1].checked = true;
 	 		formObj.rdn_sts_check[2].checked = true;
 	 		formObj.rdn_sts_check[3].checked = true;
 	 		formObj.rdn_sts_check[4].checked = true;
 	 		
 	 		formObj.rdn_sts_check[5].checked = false;
 	 		formObj.rdn_sts_check[6].checked = false;
 	 		formObj.rdn_sts_check[7].checked = false;
 		}
 	 	
 	 	
 	 	/**
	     * unsettle all 클릭시 settled, canceled 외 체크 또는 언체크한다.<br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     checkAll()
	     * </pre>
	     * @param 없음
	     * @return 없음
	     * @author 이승준
	     * @version 2009.06.10
	     */
 	 	function checkAll() {
 	 		var formObj = document.form;
 	 		
 	 		if(formObj.all.checked) {
 	 			formObj.rdn_sts_check[0].checked = true;
 	 	 		formObj.rdn_sts_check[1].checked = true;
 	 	 		formObj.rdn_sts_check[2].checked = true;
 	 	 		formObj.rdn_sts_check[3].checked = true;
 	 	 		formObj.rdn_sts_check[4].checked = true;
 	 	 		formObj.rdn_sts_check[5].checked = true;
 	 	 		formObj.rdn_sts_check[6].checked = true;
 	 	 		formObj.rdn_sts_check[7].checked = true;
 	 		} else {
 	 			formObj.rdn_sts_check[0].checked = false;
 	 	 		formObj.rdn_sts_check[1].checked = false;
 	 	 		formObj.rdn_sts_check[2].checked = false;
 	 	 		formObj.rdn_sts_check[3].checked = false;
 	 	 		formObj.rdn_sts_check[4].checked = false;
 	 	 		formObj.rdn_sts_check[5].checked = false;
 	 	 		formObj.rdn_sts_check[6].checked = false;
 	 	 		formObj.rdn_sts_check[7].checked = false;
 	 		}
 		}
 	 	
 	 	
 	 	
 	 	/**
	     * search 시 체크 된 status 항목을 쉼표로 조합 (IS,ST 등)한다.<br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     makeInParam(formObj)
	     * </pre>
	     * @param {form} formObj    
	     * @return 없음
	     * @author 이승준
	     * @version 2009.06.10
	     */
 	 	function makeInParam(formObj) {
 	 		
 	 		var rdn_sts_cd = "";
 	 		var cntCheck = 0;

 	 		for(var i=0;i<formObj.rdn_sts_check.length;i++){
 	 			 if(formObj.rdn_sts_check[i].checked)
 	 				cntCheck = i;
 	 		}
 	 		
 	 		
 	 		for(var i=0;i<formObj.rdn_sts_check.length;i++){
 	 			
 	 		    if(formObj.rdn_sts_check[i].checked) {
 	 			    rdn_sts_cd = rdn_sts_cd + "'" + formObj.rdn_sts_check[i].value + "'";
 	 			    if(i < (formObj.rdn_sts_check.length-1) && i < cntCheck) {
 	 				    rdn_sts_cd = rdn_sts_cd + ",";
 	 			    }	  
 	 		    }
 	 		}
 	 		
 	 		formObj.rdn_sts_cd.value = rdn_sts_cd;
 		}
 	 	
/** 
* sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 이승준
* @version 2009.10.16
*/ 
function sheet2_OnSearchEnd(sheetObj, ErrMsg)
{	        	
	var formObj = document.form;
	formObj.ttl_cnt.value = sheetObj.CellValue(1,"ttl_cnt");
	formObj.ttl_usd_amt.value = ComAddComma(sheetObj.CellValue(1,"ttl_usd_amt"));
	formObj.within_10_dys.value = sheetObj.CellValue(1,"within_10_dys");
	formObj.within_20_dys.value = sheetObj.CellValue(1,"within_20_dys");
	formObj.over_20_dys.value = sheetObj.CellValue(1,"over_20_dys");
	formObj.over_20_dys_rto.value = sheetObj.CellValue(1,"over_20_dys_rto");
	
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
  * @version 2009.10.28                                                         
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var form = document.form;
	var colName  = sheet1.ColSaveName(Col);
	var scRfaNo  = sheet1.CellValue(Row, "sc_rfa_no");
	var ctrtTpCd = sheet1.CellValue(Row, "ctrt_tp_cd");	
	var bkgNo = sheet1.CellValue(Row, "bkg_no");
	var rdnNo = sheet1.CellValue(Row, "rdn_no");
 	switch(colName) {
		case "sc_rfa_no":
        	if(null == scRfaNo || "" == scRfaNo) { return; }
    		var pgmNo = "ESM_PRI_0004";
    		var scRfaNoP = scRfaNo.substr(0, 3);
    		var scRfaNoS = scRfaNo.substr(3);
        	var popParams = "sc_no_p=" + scRfaNoP + "&sc_no_s=" + scRfaNoS;
	    	if(ctrtTpCd == "RFA") { // RFA
	    		pgmNo = "ESM_PRI_2019";
	    		popParams = "s_rfa_no=" + scRfaNo;
	    	}
	    	else if(ctrtTpCd == "TAA") { // TAA
	    		pgmNo = "ESM_PRI_3007";
	    		popParams = "cond_taa_no=" + scRfaNo;
	    	}
        	comRASCallPop(pgmNo, "ESM_BKG_0427", popParams, "");
		    break;
		    
		case "bl_no":
        	if(null == bkgNo || "" == bkgNo) { return; }
         	var popParams = "bkg_no=" + bkgNo + "&openTab=B8";
        	comRASCallPop("ESM_BKG_0079", "ESM_BKG_0427", popParams, "");
			break;

		case "rdn_no":
        	if(null == rdnNo || "" == rdnNo) { return; }
    		var popParams = "rdn_no=" + rdnNo;
        	comRASCallPop("ESM_BKG_0712", "ESM_BKG_0427", popParams, "");
			break; 	 
			
		case "atch_exist":
			var rdn_no = sheet1.CellValue(Row, "rdn_no");
			var rvis_seq = sheet1.CellValue(Row, "rvis_seq");
			var edit_flg = "Y";
			
			var url = "ESM_BKG_1408.do?rdn_no="+rdn_no+"&rvis_seq="+rvis_seq+"&edit_flg="+edit_flg;
			ComOpenWindowCenter(url, "ESM_BKG_1408", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
			break;
			
 	}    	 
}

 /**                                                                                            
 * sheet1 셀 클릭시 발생하는 sheet1_OnClick <br>      
 * <br><b>Example :</b>                                                                         
 * <pre>                                                                                        
 * </pre>                                                                                       
 * @param  {IBSheet} sheetObj : sheet object                                        
 * @param  {Long} Row : 해당 셀의 Row Index                                              
 * @param  {Long} Col : 해당 셀의 Column Index  
 * @param  {String} Value : 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
 * @return 없음                                                                                 
 * @see #                                                                                       
 * @author 김대호                                                                               
 * @version 2009.10.16                                                           
 */  
 function sheet1_OnClick(sheetObj, Row, Col, Value) {
    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	var form = document.form;
	var colName  = sheet1.ColSaveName(Col);
 	switch(colName) {
    	case "office_rdn_rmk":
    		ComShowMemoPad(sheetObj,Row,Col,true,310,200); 
    		break;
    	case "receiver_rdn_rmk":
    		ComShowMemoPad(sheetObj,Row,Col,true,310,200);
    		break;	
 	}    	 

}
 	     
/** 
  * 조회조건을 체크하는 setSearchCond <br>
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param  없음  
  * @return boolean
  * @see #
  * @author 김대호
  * @version 2010.01.04
*/ 
function setSearchCond() {
	var form = document.form;
	var rdnNoObj  = form.rdn_no;
	var blNoObj   = form.bl_no;
	var fmDtObj   = form.rdn_iss_dt_from;
	var toDtObj   = form.rdn_iss_dt_to;
	var chkValLen = rdnNoObj.value.length + blNoObj.value.length; 
	if(chkValLen > 0){
	    fmDtObj.className = "input"; 
	    toDtObj.className = "input"; 
	}else{
	    fmDtObj.className = "input1"; 
	    toDtObj.className = "input1"; 
	}
} 

	/* 개발자 작업  끝 */