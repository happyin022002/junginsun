/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4024.js
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연
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
     * @class ESM_PRI_4024 : ESM_PRI_4024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4024() {
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
					
				case "btn_Close":
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
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
     * @author 김재연
     * @version 2009.09.24
     */
    function loadPage() {
    	 for (i = 0; i < sheetObjects.length; i++) {
  			// khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  	
  			initSheet(sheetObjects[i], i + 1);
  			// khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
    	 
    	pageOnLoadFinish();
    }
    
    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
    function pageOnLoadFinish() {
    	initControl();
    	document.form.from_acct_xch_rt_yrmon.value = ComGetNowInfo("ym");
    }
     
    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.09.24
	 **/
	function initControl() {
		//** Date 구분자 **/
		//DATE_SEPARATOR = "/";
	
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm('blur', 'obj_blur', form);
		axon_event.addListenerForm('focus', 'obj_focus', form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
	}
	
	/**
     * OnKeyPress시 호출되는 function <br>
     * HTML Control의 onkeypress 이벤트에서 해당 key만 입력되게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
	function obj_keypress(){
		switch(event.srcElement.dataformat){
			case "int":
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
				
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
				
			case "eng":
		        //영문만입력하기
	            ComKeyOnlyAlphabet("upper");
	            break;
	            
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
     * OnBlur 이벤트 발생시 호출되는 function <br>
     * format 및 validation 확인 <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
  	function obj_blur() {

  		 switch(event.srcElement.name) {
 		
 			case "from_acct_xch_rt_yrmon":
 				event.srcElement.value = ComGetMaskedValue(event.srcElement.value, "ym");
 				break;
 			
 			case "to_acct_xch_rt_yrmon":
 				event.srcElement.value = ComGetMaskedValue(event.srcElement.value, "ym");
 				break;
 			
 			case "curr_cd":
 				var formObj = document.form;
 				formObj.f_cmd.value = COMMAND16; 	    			
 				var sXml = sheetObjects[1].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&etc1="+formObj.curr_cd.value);
 				var arrDesc = ComPriXml2Array(sXml, "cd|nm");
 				
 				if (arrDesc == null) {
 					formObj.curr_cd.value = "";
 				}
 				break;	
 		} 
  	}
  	
  	/**
     * OnFocus 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.09.24
     */
   	function obj_focus() {
   		srcName = event.srcElement.name;
  		srcValue = event.srcElement.value;
  		
  		switch(srcName) {
  		
  			case "from_acct_xch_rt_yrmon":
  				ComClearSeparator(event.srcElement, "ym");
  				event.srcElement.select();
  				break;
  			
  			case "to_acct_xch_rt_yrmon":
  				ComClearSeparator(event.srcElement, "ym");
  				event.srcElement.select();
  				break;
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
     * @author 김재연
     * @version 2009.09.24
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetId = sheetObj.id;

        switch(sheetId) {

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 440;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 15, 100);

					var HeadTitle1 = "Seq.|Year/Month|Cur. Code|Description|Account Rate|Account Rate|Account Rate|Creation\nDate|Updated\nDate";
					var HeadTitle2 = "Seq.|Year/Month|Cur. Code|Description|USD(LOCAL)|LOCAL(KRW)|USD(KRW)|Creation\nDate|Updated\nDate";

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN,	COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtSeq,	40,	 	daCenter,	true,	"seq",					false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtData,	100,  	daCenter,	true,	"acct_xch_rt_yrmon",	false,	"",	dfDateYm,	0);
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,	true,	"curr_cd",				false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtData,	180, 	daLeft,		true,	"curr_nm",				false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"usd_locl_xch_rt",		false,	"",	dfFloat,	4);
					InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"locl_krw_xch_rt",		false,	"",	dfFloat,	4);
					InitDataProperty(0, cnt++, dtData,	110,	daRight,	true,	"usd_krw_xch_rt",		false,	"",	dfFloat,	4);
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,	true,	"cre_dt",				false,	"",	dfDateYmd,	0);
					InitDataProperty(0, cnt++, dtData,	100,	daCenter,	true,	"upd_dt",				false,	"",	dfDateYmd,	0);

					CountPosition = 0;
					AutoRowHeight = false;
					WaitImageVisible = false;
			}
			break;
			
        case "sheet2":
	     
			with (sheetObj) {
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(1, 0, 0, true);
                
                var HeadTitle = "";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

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
     * @author 김재연
     * @version 2009.09.24
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {

        	case IBSEARCH:
        		ComOpenWait(true);
        		if (!validateForm(sheetObj, formObj, sAction)) {
        			ComOpenWait(false);
        			return false;
	      		}
	    		
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_4024GS.do", FormQueryString(formObj));
				ComOpenWait(false);
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
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 김재연
     * @version 2009.09.24
     */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if(!ComChkRequired(formObj)) return false;
        	
        	if(!ComIsNull(to_acct_xch_rt_yrmon.value) && from_acct_xch_rt_yrmon.value > to_acct_xch_rt_yrmon.value) {
        		ComShowCodeMessage('PRI00305','Year/Month');
        		return false;
        	}
        }
        return true;
    }
	
	/* 개발자 작업  끝 */