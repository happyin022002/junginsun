/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0048.js
*@FileTitle : Estimated I/F To ERP(PV)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.06 윤세영
* 1.0 Creation
* 
* --------------------------------------------------------------------------------
* 2016.02.01 손진환 [CHM-201639985] Inquiry 화면 불필요 Validation정리 
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
     * @class esm_fms_0048 : esm_fms_0048 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0048() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_change				= obj_change;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
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
            	case "btn_retrieve":
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
					
					ComResetAll();
					inputReadOnly("New");

                break;
                
				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;

				case "btn_save":
					if (ComIsBtnEnable("btn_save")) {
						doActionIBSheet(sheetObject,formObject,IBSAVE);
					}	
                break;
                
				case "btn_del":
					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
					}
                break;
	
     			case "btn_fr_duration":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.fr_duration, 'yyyy-MM');
     				
					sheetObject.RemoveAll();
					
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
     * Event에 따른 화면 처리 <br>
     * @param {String} flag     	Event 구분값
     **/
    function inputReadOnly(flag) {
    	var readOnly = true;
    	var cursor = "default";
    	var img = "no_";
    	
    	if(flag == "New") {
    		readOnly = false;
    		cursor = "hand";
    		img = "";
    	}

		form.fr_duration.readOnly = readOnly;
    	
    	document.images["btn_fr_duration"].name = img+"btn_fr_duration";
    	
    	form.btn_fr_duration.style.cursor = cursor;

		ComBtnEnable("btn_save");
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

	    obj = event.srcElement;

	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;

    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        //ComKeyOnlyNumber(event.srcElement);
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


        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();

    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
		
		sheetObj.WaitImageVisible = true;   
    }

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'				, 'obj_blur', 		document.form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , document.form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
        axon_event.addListenerForm  ('change'          , 'obj_change'    , form); 	//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_blur(){
	    ComChkObjValid(event.srcElement);
    }

    /**
     * HTML Control의 onchange이벤트에서 Vessel Code, Location변경 시 Validtion을 체크하다.<br>
     **/
    function obj_change() {
    	if((event.srcElement.name == "fr_duration")) {
    		sheetObjects[0].RemoveAll();
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
                    style.height = 420;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle = "|Sel|Seq|Period|Type|F.Lane|VVD|Hire|From Date|To Date|Days|Estimated";
					var headCount = ComCountHeadTitle(HeadTitle)+7;

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,  	40,     daCenter,   false,   "DelChk");
					InitDataProperty(0, cnt++ , dtSeq,    		50,    	daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "rev_yrmon",    	true,          "",      								dfDateYm, 	0,     false,       false);
					InitDataProperty(0, cnt++ , dtCombo,		90,	    daCenter,	false,  "flet_ctrt_tp_cd",  false,         "",      								dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,  "rlane_cd",     	false,         "",      								dfNone,   	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	false,  "vvd_cd",     		false,         "",      								dfNone,     0,     false,       false);
					                                   					
					InitDataProperty(0, cnt++ , dtData,			105,  	daRight,	false,	"hire_amt",     	false,         "",      								dfFloat,    2,     false,       false);
					InitDataProperty(0, cnt++ , dtData,   	   	109,   	daCenter,	true,   "vst_dt",   		true,          "",      								dfDateYmd,	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	109,   	daCenter,	true,   "ved_dt",   		true,          "",      								dfDateYmd,	0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,      	75,     daCenter,	false,  "days",     		true,          "DateDiff(d, |vst_dt|, |ved_dt|)+1",     dfNone,    	0,     false,      	false);
					InitDataProperty(0, cnt++ , dtData,			115,  	daRight,	false,  "est_amt", 			false,         "|hire_amt|*|days|",      				dfFloat, 	2, 	   false,       false);
					
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "vsl_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "skd_voy_no");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "skd_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "rev_dir_cd");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "subsumcol");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "exe_yrmon");
					InitDataProperty(0, cnt++ , dtHidden,		 0,		daCenter,   true,   "estm_ioc_div_cd");
					
               }

                break;

        }
    }

  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
       	   	  	if(validateForm(sheetObj,formObj,sAction)){

	        		formObj.f_cmd.value = SEARCH;
	        	   	
	        	   	sheetObj.DoSearch("ESM_FMS_0048GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));

//       	   	  		inputReadOnly("Search");
	  	   	  	}	

                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			formObj.f_cmd.value = MULTI;
	 			sheetObj.DoSave("ESM_FMS_0048GS.do", FormQueryString(formObj)); 
	 			
                break;

			case IBROWSEARCH:   //공통 코드 조회	

				if (Col == "ComCd") {//Status, Dry Dock Type
					
					CoFmsGetCombo("GRID", formObj, sheetObj, "CD01513","flet_ctrt_tp_cd", "flet_ctrt_tp_cdText");

				}	
        	   
                break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//필수 입력 등 Validation 체크
        if (!ComChkValid(formObj)) return false;

        return true;
    }

     /**
      * IBSheet를 조회 후 실행되는 이벤트
      */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){

 		ComColFontName(sheetObj, "rlane_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "vvd_cd", "Courier New"); 	
		sheetObj.ShowSubSum("flet_ctrt_tp_cd", "est_amt", -1, false, false, 9, "ved_dt=Total Amount");

    }

     /**
      * IBSheet를 저장 후 실행되는 이벤트
      */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg){

		//Interface to ERP Button Disable 하기
		ComBtnDisable("btn_save");
		
	}


	/* 개발자 작업  끝 */