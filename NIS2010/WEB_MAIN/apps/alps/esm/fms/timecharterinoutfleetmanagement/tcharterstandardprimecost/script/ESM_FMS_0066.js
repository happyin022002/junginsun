/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0066.js
*@FileTitle : Hire Inquiry
*@LastModifyDate : 2009.05.20
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.20 최우석
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
     * @class Hire Creation : Hire Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0066() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.obj_deactivate 		= obj_deactivate;
    	this.obj_keypress		    = obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initConfirm			= initConfirm;
    	this.inputReadOnly			= inputReadOnly;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.obj_activate			= obj_activate;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
    var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObject = sheetObjects[0];
	 	var sheetObject1 = sheetObjects[1];
	
	 	/*******************************************************/
	 	var formObject = document.form;
	
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	
	        switch(srcName) {
	         	case "btn_retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                break;
	
	 			case "btn_new":
    		 		ComResetAll();
    		 		//inputReadOnly("0");
	                break;
	                 
	 			case "btn_savetofile":
	 				//sheetObject.SpeedDown2Excel(-1);
	 				sheetObject.Down2Excel(-1);
	                break;

	 			case "btn_print":
	 				rdOpen(rdObjects[0], document.form);
	                break;

	 			case "btn_hbYrmon":
	 				var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.rngYr, 'yyyy-MM');
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
	 	    
	 	   sheetObjects[i].ExtendLastCol = false;
	    }

        //html컨트롤 이벤트초기화
   	 	initControl();
   	 	
   	 	//RD
		initRdConfig(rdObjects[0]);
	}
	 
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
        //** Date 구분자 **/
      	DATE_SEPARATOR = "-";
      	
        //Axon 이벤트 처리1. 이벤트catch
      	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerFormat('focus', 'obj_activate', form);
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Year의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	
        //입력Validation 확인하기
    	switch(event.srcElement.name){
	    	case "rngYr":
	    		ComChkObjValid(event.srcElement);
    			break;
    		default:
    			//ComAddSeparator(event.srcElement);
    			ComChkObjValid(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
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
	         case 1:      //sheet1 init
	             with (sheetObj) {
	
	                // 높이 설정
	                style.height = 399;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 2, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle1 = "|Seq|Market|Vessel Code|Vessel's \nFull Name|Flag|Type|Designed TEU|Designed TEU|Daily Hire Rate|Daily Hire Rate|Max 1T Rate|Std Hire of Max|Diff Hire-std\n(Max)|14Ton 1T Rate|Std Hire of 14Ton|Diff Hire-std\n(14Ton)";
	                var HeadTitle2 = "|Seq|Market|Vessel Code|Vessel's \nFull Name|Flag|Type|Max|14Ton|USD|Others to USD|Max 1T Rate|Std Hire of Max|Diff Hire-std\n(Max)|14Ton 1T Rate|Std Hire of 14Ton|Diff Hire-std\n(14Ton)";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	                 
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 5, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                 
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,  	30,     daCenter, 	true,	"ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,         		100,    daCenter,  	true,	"Seq");
	                InitDataProperty(0, cnt++ , dtCheckBox,   	 	50,    	daCenter, 	true,   "mkt_rt_aply_flg",   		false,  "",	dfNone,		0,	false,	false);
	                InitDataProperty(0, cnt++ , dtData,    			90,    	daCenter, 	true,   "vsl_cd",   				false,  "", dfNone,     0,  false,	false);
	                InitDataProperty(0, cnt++ , dtData,  		  	160,    daLeft, 	true,   "vsl_eng_nm",  				false,  "", dfNone,     0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtData,   	 		50,    	daCenter, 	true,   "vsl_cnt_cd",     	 		false,  "", dfNone,     0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtData,   	 		50,    	daCenter, 	true,   "flet_ctrt_tp_cd",     	 	false,  "", dfNone,     0,  false,	false);
	 								                                                                                                                                                  
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	75,    	daRight,  	false,  "vsl_dznd_capa",     	 	false,  "", dfInteger,  0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	75,    	daRight,  	false,  "bse_14ton_vsl_capa",     	false,  "", dfInteger,  0,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	false,  "hir_rt_n1st_amt",     	 	false,  "", dfFloat,	2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	false,  "hir_rt_n2nd_amt",     	 	false,  "", dfFloat,   	2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	true,   "max_teu_rt_amt",     		false,  "", dfFloat,   	2,  false,	false);
	                                                                                                                                               
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	110,    daRight,  	true,   "stnd_max_hir_amt",     	false,  "", dfFloat,   	2,  false,	false, 17);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	true,   "diff_stnd_max_hir_amt",    false,  "", dfFloat,	2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	95,    	daRight,  	true,   "teu_14ton_rt_amt",     	false,  "", dfFloat,	2,  false,	false);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	110,   	daRight,  	true,   "stnd_14ton_hir_amt",     	false,  "", dfFloat,   	2,  false,	false, 17);
	 				InitDataProperty(0, cnt++ , dtAutoSum,   	 	85,    	daRight,  	true,   "diff_stnd_14ton_hir_amt",	false,	"", dfFloat,   	2,  false,	false);
	 				
	 				MessageText("Sum")  = "Total Amount";
	            }
	 			break;
	     	}
	}
	
	/**
	 * Sheet관련 프로세스를 처리한다.<br>
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,searchType) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {
	     	case IBSEARCH:      // 조회
		 		if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESM_FMS_0066GS.do", FormQueryString(formObj));
					//inputReadOnly("1");
				}
	            break;
	     }
	}
	
	/**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
	function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
	
	    return true;
	}
	     
	/**
     * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
     **/
	function inputReadOnly(flag) {
	 	if(flag == "1") {
	 		form.rngYr.readOnly = true;
	 		form.btn_hbYrmon.style.cursor = "default";
	 		document.images["btn_hbYrmon"].name = "";
	 	} else {
	 		form.rngYr.readOnly = false;
	 		form.btn_hbYrmon.style.cursor = "hand";
	 		document.images["btn_hbYrmon"].name = "btn_hbYrmon";
	 	}
	}
	
	/**
 	 * 페이지에 있는 RD Object를 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
 	 * @param {rdObject} rdObject    RD Object
 	 **/
 	function initRdConfig(rdObject){
 	    var Rdviewer = rdObject ;
 	    Rdviewer.style.height = 0;
 	    Rdviewer.style.width = 0;
 	    
 	    Rdviewer.AutoAdjust = true;
 	    Rdviewer.ViewShowMode(0);

 		Rdviewer.setbackgroundcolor(128,128,128);
 		Rdviewer.SetPageLineColor(128,128,128);
 	}
 	
 	/**
 	 * 조회된 정보를 인쇄한다.<br>
 	 */
 	function rdOpen(rdObject, formObject){
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}

		var Rdviewer = rdObject ;
	
		rdParam = RD_FormQueryString(formObject,1);
		var rdParam = '/rv '+ rdParam;
		var rdFile = 'ESM_FMS_067.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tcharterstandardprimecost/report/'+rdFile, RDServer+rdParam);
		Rdviewer.CMPrint (); //인쇄 시작
	}
 	
 	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	 
	/**
	 * vsl_cd의 Font를 변경한다.
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		ComColFontName(sheetObj, "vsl_cd", "Courier New"); 
	}
	/* 개발자 작업  끝 */