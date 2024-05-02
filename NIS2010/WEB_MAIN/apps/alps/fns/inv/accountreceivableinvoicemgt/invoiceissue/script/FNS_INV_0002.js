/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0002.js
*@FileTitle : (China) Tax Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
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
     * @class FNS_INV_0002 : FNS_INV_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_INV_0002() {
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

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

                 case "btn_retrive":
                     doActionIBSheet(sheetObject,formObject,IBSEARCH);
                     break;

                 case "btn_new":
                	 ComResetAll();
                	 doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);	//office 콤보조회
                	 ComSetFocus(document.form.iss_dt_start);
                     break;

 		        case "btn_downExcel":
                     //sheetObject.Down2Excel();
                     sheetObject.SpeedDown2Excel();
                     break;

 		       case "btns_calendar": //달력버튼
 		    	    var cal = new ComCalendarFromTo();
		            cal.select(formObject.iss_dt_start,  formObject.iss_dt_end,  'yyyy-MM-dd');
	                break;
	                                
                case "btns_cust1": //CUST 조회버튼
   					var v_act_cust_cnt_cd = formObject.act_cust_cnt_cd.value;
   					var v_act_cust_seq = formObject.act_cust_seq.value;
   					var classId = "FNS_INV_0013";
   					var param = '?cust_cnt_cd='+v_act_cust_cnt_cd+'&cust_seq='+v_act_cust_seq+'&pop_yn=Y&classId='+classId;
   			
   					ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 650, 'getFNS_INV_0013', '1,0,1,1,1', true);
   				break;
   				
                case "btns_calendar1":
   	                var cal = new ComCalendar();
   	                cal.select(formObject.iss_dt_start, 'yyyy-MM-dd');
   	            break;
   	            
				case "btns_calendar2":
   	                var cal = new ComCalendar();
   	                cal.select(formObject.iss_dt_end, 'yyyy-MM-dd');
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

         for(i=0;i<sheetObjects.length;i++){

         //khlee-시작 환경 설정 함수 이름 변경
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
 			
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

     }

     function initControl2() {
  		var formObj = document.form;
  		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
  		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
  		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
  		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
  		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
  		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
  	}
     
     /** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 한동훈
      	 * @version 2009.10.19
	 */
	function obj_keypress(){
	    switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "ymd":
	            //숫자+"-"입력하기
	        	ComKeyOnlyNumber(event.srcElement);
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
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
	            break;
	        case "uppernum":
	        	//영문대+숫자 
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	    }
	}
     
   /**
      * 시트 초기설정값, 헤더 정의
      * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
      * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
      */
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 380;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msAll;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(14, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle       = "Seq.|Issue Date|Tax Invoice No.|B/L No.|Cust. Code|Cust. Name|Charge|Issue Curr |Issue AMT|Ex. Rate";
                     HeadTitle       += "|CNY AMT|Remark|Cancel|Cancel Remark(s)";
                 
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     var rowCnt = 0;

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(rowCnt, cnt++ , dtDataSeq,    35,    	daCenter,  false,    "SEQ",     				false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	70,    	daCenter,  false,    "iss_dt",     				false,          "",      dfDateYmd 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	100,   	daCenter,  false,    "tax_inv_no",     			false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	100,    daCenter,  false,    "bl_src_no",     			false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	80,    	daCenter,  false,    "cust_code",     			false,          "",      dfNone 	,0		,false);

                     InitDataProperty(rowCnt, cnt++ , dtData,     	300,    daLeft,    false,    "cust_locl_lang_nm",    	false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	100,    daCenter,  false,    "tax_chg_locl_nm",     	false,          "",      dfNone		,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	80,    	daCenter,  false,    "iss_curr_cd",    		false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	90,    	daRight,   false,    "chg_amt",     			false,          "",      dfFloat    ,2		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	80,    	daRight,   false,    "inv_xch_rt",     			false,          "",      dfFloat    ,2		,false);

                     InitDataProperty(rowCnt, cnt++ , dtData,     	90,    	daRight,   false,    "locl_curr_amt",     		false,          "",      dfFloat    ,2		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	150,    daLeft,	   false,    "tax_chg_rmk",     		false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	60,    	daCenter,  false,    "tax_inv_cxl_flg",     	false,          "",      dfNone 	,0		,false);
                     InitDataProperty(rowCnt, cnt++ , dtData,     	150,   	daLeft,	   false,    "tax_inv_cxl_rmk",     	false,          "",      dfNone 	,0		,false);
                     

                }
                 break;

  

         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
         	case IBSEARCH_ASYNC10: //SalesCustomer Office 조회
	      		//office 코드 세팅         	
	      		ComboObject_OfcCd(sheetObj, formObj, formObj.ofc_cd2,'N');
	      		break;
            case IBSEARCH:      //조회
            	if(validateForm(sheetObj,formObj,sAction) == false) return false;  	
            	formObj.ofc_cd.value = formObj.ofc_cd2.text;	
         		formObj.f_cmd.value = SEARCH;		
				sheetObj.DoSearch("FNS_INV_0002GS.do", FormQueryString(formObj)+"&ar_ofc_cd="+formObj.ofc_cd2.text);
                 break;
 			 case IBSAVE:        //저장
               if(validateForm(sheetObj,formObj,sAction))
                   alert (" Save .. ");
                 break;
            
 			case IBSEARCH_ASYNC20: //SalesCustomer Office 조회
         		formObj.f_cmd.value = SEARCH03;
				
				var actCustCntCd = formObj.act_cust_cnt_cd.value;
				var actCustSeq = formObj.act_cust_seq.value;
				if(actCustSeq != ""){
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj)+"&cust_cnt_cd="+actCustCntCd+"&cust_seq="+actCustSeq);	
		
					if(CoInvShowXmlMessage(sXml) != "") {
						formObj.cust_lgl_eng_nm.value = "";
						formObj.cust_locl_lang_nm.value = "";
						
						ComAlertFocus(formObj.act_cust_cnt_cd, CoInvShowXmlMessage(sXml));
					} else {
						var cust_eng_nm = ComGetEtcData(sXml,"cust_eng_nm");
						var cust_nm = ComGetEtcData(sXml,"cust_nm");
						
						formObj.cust_lgl_eng_nm.value = cust_eng_nm;
						formObj.cust_locl_lang_nm.value = cust_nm;
						
					}
				}	
				break;
         }
     }

     //업무 자바스크립트 OnBeforeActivate 이벤트 처리
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	}

	//업무 자바스크립트 Onbeforedeactivate 이벤트 처리
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		switch(event.srcElement.name){
			case "iss_dt_start":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "iss_dt_end":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;			
		}
	}	

	/**
	 *HTML Control KeyUp 이벤트 호출
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "iss_dt_start":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.iss_dt_end.focus();
				}
	 		break;
			case "iss_dt_end":
				var toDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (toDt.length == 8) {
					//formObject.tax_inv_no_start.focus();
				}
	 		break;			
	 	}
	}
	
	function obj_focusout() {
  		var sheetObject = sheetObjects[0];
  		var formObject = document.form;
  		switch(event.srcElement.name){  			
  			case "act_cust_seq":
  				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC20);
  				formObject.act_cust_seq.value = zeroInsert(formObject.act_cust_seq.value);
  			break; 
  	    }
  	}
	
	function zeroInsert(str){
	   	 var newStr = '';
	   	 str = str+"";
	   	 if(str.length < 6){
	   	  for(var i=0;i<6-str.length;i++){
	   	   newStr = newStr + '0'
	   	  }
	   	  newStr = newStr + str;
	   	 }else{
	   	  newStr = str;
	   	 }
	   	 return newStr;
	   	}
	
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
	     	case IBSEARCH: //조회				
				if (formObj.ofc_cd2.text == "") {
	      		ComShowCodeMessage('INV00004');
	      		ComSetFocus(form.ofc_cd2);
					return false;
				}
				//alert(formObj.iss_dt_start.value);
				if(formObj.bl_src_no.value == "" && formObj.tax_inv_no_start.value == "" && formObj.tax_inv_no_end.value == ""){					
					if (ComIsNull(formObj.iss_dt_start)) {
			      		ComShowCodeMessage('INV00004');
			      		ComSetFocus(form.iss_dt_start);
							return false;
					}
					if (ComIsNull(formObj.iss_dt_end)) {
			      		ComShowCodeMessage('INV00004');
			      		ComSetFocus(form.iss_dt_end);
							return false;
					}
						
	    	 	}	
				break;	     	
    	 }	
	         return true;
     }
     
 	/**
 	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 * 
 	 * </pre>
 	 * @param {ibsheet} sheetObj 필수 IBSheet Object
 	 * @return 없음
 	 */ 	  	
 	function sheet_OnLoadFinish(sheetObj){
 		var formObj = document.form;

        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);	//office 콤보조회
        ComSetFocus(formObj.iss_dt_start);
        initControl2();
 	}

     function getFNS_INV_0013() {
 		
 	}
     
   //포커스이동
	function moveNext(id_from,id_to,maxSize) {			
		var cur = document.getElementById(id_from).value;
		curSize = cur.length;
		if (curSize == maxSize) {
			document.getElementById(id_to).focus();
		}
	}
    
	/* 개발자 작업  끝 */