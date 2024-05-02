/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0565.js
*@FileTitle : RDN Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.04.24 김진주 [CHM-201324159] [BKG/DOC - Revenue Audit Systme] 수입심사 시스템 보완 요청 (김진주 수석님)
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
     * @class esm_bkg_0565 : esm_bkg_0565 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0565() {
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

        function sheet1_OnLoadFinish(sheetObj) {
//		IBSheet Bug 로 임시 Commnet 처리
//       	 	sheetObj.SetMergeCell (0, 31, 2, 3);
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
    	    //doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);

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
		 * OnBeforeDeActivate   event를 처리한다. <br>
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
                
            case "respb_ofc_cd":
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
//        	formObj.etc2.value = getRctpbRhqCd();
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.rct_ofc_cd, "cd", "cd");
			formObj.rct_ofc_cd.InsertItem(0,'','');
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
//        	formObj.etc2.value = getRespbRhqCd();
			var sXml = sheetObjects[0].GetSearchXml("RASCommonGS.do", FormQueryString(formObj));
			// 조직도 combo3
 			ComXml2ComboItem(sXml, formObj.respb_ofc_cd, "cd", "cd");
 			formObj.respb_ofc_cd.InsertItem(0,'','');
        }
        
        
//        //rct_ofc_cd 변경시
//        function rct_ofc_cd_OnChange(comboObj, code, text) {
//        	
//        	//alert(respb_ofc_cd_hidden)
//        	var formObj = document.form;
//        	
//     		if(comboObjects[1].GetCount () > 0 && comboObjects[1].Index != "-1") {
//     			//조회된 값이 없으면
//     			if(formObj.respb_ofc_cd_hidden.value == "") {
//     				comboObjects[3].Index = comboObjects[2].Index
//     			}
//     			
//     		} 
//     		
//       	}

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
    ComBkgTextCode2ComboItem(rhqComboValue, rhqComboValue, getComboObject(comboObjects, 'rct_rhq_cd'),   "|", "\t" );
    ComBkgTextCode2ComboItem(respComboValue,respComboValue,getComboObject(comboObjects, 'respb_rhq_cd'), "|", "\t" );
    form.respb_rhq_cd.InsertItem(0,'','');
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

				case "sheet1":
					with (sheetObj) {

						// 높이 설정
						style.height = 372	;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;

						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

						//전체Merge 종류 [선택, Default msNone]
//						MergeSheet = msPrevColumnMerge + msHeaderOnly;
						
						MergeSheet = msHeaderOnly;

						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;

						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo(3, 1, 1, 100);

						var HeadTitle1 = "|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|Non-\nCharged B/L|Non-\nCharged B/L|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|OFT Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Surcharge Discrepancy|Grand Total||BLCorrection";
						var HeadTitle2 = "|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice| | |CNTR Qty|CNTR Qty|GRI|GRI|Cargo Type|Cargo Type|Route|Route|Others|Others|Sub Total|Sub Total|IHC|IHC|Bunker|Bunker|DG|DG|WSC|WSC|Others|Others|Sub Total|Sub Total|Grand Total||BLCorrection";
						var HeadTitle3 = "|Receipt\nRHQ|Receipt\nOffice|Resp.\nRHQ|Resp.\nOffice|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|Cnt|Amt|BLCorrection";

						var headCount = ComCountHeadTitle(HeadTitle1); 

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);

						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, false, true, false,false);

						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						InitHeadRow(2, HeadTitle3, true);

						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rct_rhq_cd",		false,	"",	dfNone,			0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"rct_ofc_cd",		false,	"",	dfNone,			0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"respb_rhq_cd",		false,	"",	dfNone,			0,	true,	true);
						InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"respb_ofc_cd",		false,	"",	dfNone,			0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		40,	daRight,	true,	"cnt1",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		40,	daRight,	true,	"amt1",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt2",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt2",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt3",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt3",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt4",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt4",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt5",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt5",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt6",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt6",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"oft_subCnt",		false,	"|cnt2|+|cnt3|+|cnt4|+|cnt5|+|cnt6|",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"oft_subAmt",		false,	"|amt2|+|amt3|+|amt4|+|amt5|+|amt6|",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt7",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt7",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt8",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt8",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt9",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt9",				false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt10",			false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt10",			false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"cnt11",			false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"amt11",			false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"surcharge_subCnt",	false,	"|cnt7|+|cnt8|+|cnt9|+|cnt10|+|cnt11|",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		35,	daRight,	true,	"surcharge_subAmt",	false,	"|amt7|+|amt8|+|amt9|+|amt10|+|amt11|",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		57,	daRight,	true,	"GrandCntTotal",	false,	"|cnt1|+|oft_subCnt|+|surcharge_subCnt|",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++ , dtAutoSum,		45,	daRight,	true,	"GrandAmtTotal",	false,	"|amt1|+|oft_subAmt|+|surcharge_subAmt|",	dfNullInteger,	0,	true,	true);
//						InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	true,	"BLCorrection",		false,	"",	dfNullInteger,	0,	true,	true);
						InitDataProperty(0, cnt++, dtHidden, 		0, daLeft, 	false,  "BLCorrection", 			false,   "", dfNone, 	0,  false,  false);
						FrozenCols = 5;

//						ColHidden("BLCorrection") = true;
						CountPosition = 0;
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
              
            	case IBSEARCH:      //조회
            		
            		if (validateForm(sheetObj,formObj,sAction)) {
            			
        	    		ComOpenWait(true);		
        	    		sheetObj.WaitImageVisible = false;
            			
            			formObj.f_cmd.value = SEARCH01;
           			    sheetObj.DoSearch("ESM_BKG_0565GS.do", FormQueryString(formObj));
           			    
        	    		ComOpenWait(false);		
           			    
    	        	}    
            	    break;
            	    
            	case IBDOWNEXCEL:
            		sheetObj.Down2Excel(-1);
            		//sheetObj.SpeedDown2Excel(-1);            		
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
	   	 		
		    		if(!ComChkObjValid(fmDtObj)) { return false; }
		    		if(!ComChkObjValid(toDtObj)) { return false; }
		    		
	 		 		if("" == fmDtValue || "" == toDtValue){
	 					 ComShowCodeMessage("BKG95025", "Date"); // "Please input {?msg2}."
	 					 if("" == fmDtValue){
	 	 					 ComSetFocus(fmDtObj);
	 					 }else{
	 	 					 ComSetFocus(toDtObj);
	 					 }
	 					 return false;
	 		 		}
	   	 		
	 	 			if( parseInt(fmDtValue,10) > parseInt(toDtValue, 10) ) {
	 					 ComShowCodeMessage("BKG95026", "From Date", "To Date");
	 					 ComSetFocus(fmDtObj);
	 					 return false;
	 		 		}
	 		 		
	 	 			var fromAddDays = ComGetDateAdd(fmDtValue, "D", 364, "", true);
	 	 			if( parseInt(toDtValue,10) > parseInt(fromAddDays, 10) ) {
	 	 				ComShowCodeMessage("BKG95027", "365 days"); // "The period of Date can't be over {?msg1}."
	 	 				ComSetFocus(fmDtObj);
	 	 				return false;
	 	 			}
			   	 				   	 	
			   	 	makeInParam(formObj);
	    			
	   				return true;
	   	 			break;
	       	 }	
        }
        
        /**
         * all 클릭시  체크 또는 언체크한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     checkAll()
         * </pre>
         * @param 없음
         * @return 없음<br>
         * @author 이승준
         * @version 2009.04.17
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
         * search 시 체크 된 status 항목을 쉼표로 조합 (IS,ST 등)한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     makeInParam(formObj)
         * </pre>
         * @param {form} formObj
         * @return 없음<br>
         * @author 이승준
         * @version 2009.04.17
         */
 	 	function makeInParam(formObj) {
 	 		
 	 		var rdn_sts_cd = "";
 	 		var cntCheck = 0;
 	 		//alert("e" + rdn_sts_check[0])
 	 		for(var i=0;i<formObj.rdn_sts_check.length;i++){
 	 			 if(formObj.rdn_sts_check[i].checked)
 	 				cntCheck = i;
 	 		}
 	 		
 	 		
 	 		for(var i=0;i<formObj.rdn_sts_check.length;i++){
 	 			
 	 		    if(formObj.rdn_sts_check[i].checked) {
 	 			    //alert("e" + formObj.rdn_sts_check[i].value)
 	 			    rdn_sts_cd = rdn_sts_cd + "'" + formObj.rdn_sts_check[i].value + "'";
 	 			    if(i < (formObj.rdn_sts_check.length-1) && i < cntCheck) {
 	 				    rdn_sts_cd = rdn_sts_cd + ",";
 	 			    }	  
 	 		    }
 	 		}
 	 		
 	 		formObj.rdn_sts_cd.value = rdn_sts_cd;
 	 		//alert("e" + formObj.rdn_sts_cd.value)
 		}
 	 	
/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.05
*/ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with(sheetObj) {
		ShowSubSum("rct_rhq_cd", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33", -1, false, false, 0, "rct_rhq_cd=%s;rct_ofc_cd=Sub Total");
		var sRow = FindSubSumRow();
		var arrRow = sRow.split("|");
		for (idx=0; idx < arrRow.length-1; idx++){ 
//		    SetMergeCell (arrRow[idx], 2, 0, 3);
//		    CellAlign(arrRow[idx], "rct_rhq_cd") = daRight;
//		    CellAlign(arrRow[idx], "rct_ofc_cd") = daLeft;
		}
		SetMergeCell (LastRow, 1, 0, 4);
		SumText(0, "rct_rhq_cd") = "Grand Total";
		SumBackColor = RgbColor(0,255,255);
	}
}
         
 	 	/**
         * sheet의 값이 변경될 때 subsum의 항목을 표시한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {sheetObj} sheetObj
         * @param {int} Row
         * @return 없음<br>
         * @author 이승준
         * @version 2009.04.17
         */
         /*
		function sheet1_OnChangeSum(sheetObj, Row)
		{
			with(sheetObj)
			{
				SumText(0, "rct_rhq_cd") = "Grand";
				CellAlign(Row, "rct_rhq_cd") = daRight;
				SumText(0, "rct_ofc_cd") = "Total";
				CellAlign(Row, "rct_ofc_cd") = daLeft;
			}
		}
		*/
	
		/**
         * search가 끝난 후 subsum의 항목을 설정한다. <br>
         * <br><b>Example :</b>
         * <pre>
         *     
         * </pre>
         * @param {sheetObj} sheetObj
         * @param {String} ErrMsg
         * @return 없음<br>
         * @author 이승준
         * @version 2009.04.17
         */
         /*
		function sheet1_OnSearchEnd(sheetObj, ErrMsg)
		{
			with(sheetObj)
			{
				ShowSubSum("rct_rhq_cd", "5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32", -1, false, false, 0, "rct_rhq_cd=%s;rct_ofc_cd=TOTAL");
			}
    	}
    	*/
    		
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
 	 		comboObjects[2].removeAll();
 	 		
 	 		sheetObjects[1].RemoveAll();
 	 		
 		}	


	/* 개발자 작업  끝 */