/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0038.js
*@FileTitle : Revenue VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.01 윤세영
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
     * @class esm_fms_0038 : esm_fms_0038 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0038() {
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

            	case "btn_retrieve":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
	             	
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;

				case "btn_new":
	             	if(!CoFmsInitConfirm(sheetObject)) return;
					
					ComResetAll();
                break;

				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
                break;

     			case "btn_period_from":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.rev_yrmon_from, 'yyyy-MM');
     				
					break;					

     			case "btn_period_to":
     				var cal = new ComCalendar();

 					cal.setDisplayType('month');
					cal.select(form.rev_yrmon_to, 'yyyy-MM');
     				
					break;					
                    
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 440,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
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

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;

        //html컨트롤 이벤트초기화
        initControl();
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListener      ('keypress',        'engnum_keypress' , 'slan_cd', 'rlane_cd');  // 영문 대문자/숫자만 입력하기 
    	axon_event.addListenerForm  ('blur'				, 'obj_deactivate', form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

        axon_event.addListener  ('keypress', 'obj_keypress' , form);					//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('change'  , 'lane_cd_change', 'slan_cd');				//- Service Lane Code 입력 후 코드 검증
        axon_event.addListener  ('change'  , 'rlane_cd_change', 'rlane_cd');			//- Revenue Lane Code 입력 후 코드 검증
        axon_event.addListener  ('click'   , 'lane_search_click', 'lane_search');		//- Lane Search 클릭시 검색 조건 및 버튼 제어
        axon_event.addListener  ('click'   , 'condition_click', 'condition');			//- Condition 클릭시 Lane Code 종류 제어
		
		//Created Type에 따라 검색 조건 및 버튼 제어
		lane_search_click();
		
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function engnum_keypress() {
        //영대문자 자동변환
        ComKeyOnlyAlphabet('uppernum');
    } 
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
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
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
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

    	form.rev_yrmon.readOnly = readOnly;
    	form.slan_cd.readOnly = readOnly;
    	form.rlane_cd.readOnly = readOnly;
    	form.lane_search[0].disabled = readOnly;
    	form.lane_search[1].disabled = readOnly;
    	form.condition[0].disabled = readOnly;
    	form.condition[1].disabled = readOnly;
    	
    	document.images["btn_period_from"].name = img+"btn_period_from";
    	document.images["btn_period_to"].name = img+"btn_period_to";
    	document.images["btn_lanepop"].name = img+"btn_lanepop";
    	
    	form.btn_period_from.style.cursor = cursor;
    	form.btn_period_to.style.cursor = cursor;
    	form.btn_lanepop.style.cursor = cursor;

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
					style.height = 325;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|Seq|Revenue Month|Service Lane|Revenue Lane|Service Lane Direction|VVD Code|Start Date|End Date";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,    		 40,    daCenter,  	true,   "Seq");
                    InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	true,   "rev_yrmon",    	false,          "",      dfDateYm, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	true,   "slan_cd", 			false,          "",      dfNone,     0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 130,   daCenter,  	false,  "rlane_cd",	 		false,          "",      dfNone,   	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       	 170,   daCenter,  	false,  "skd_dir_cd",  		false,          "",      dfNone, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 120,   daCenter,  	true,   "vvd_cd",     		false,          "",      dfNone, 	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,   	   	 100,   daCenter,  	true,   "vst_dt",   		false,          "",      dfDateYmd,	0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      	 100,   daCenter,  	true,   "ved_dt",   		false,          "",      dfDateYmd,	0,     false,      false);

                }
                break;

         }
     }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj, sAction, Col, Row) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
         	
	 			if(!validateForm(sheetObj,formObj,sAction))return;

         		formObj.f_cmd.value = SEARCH;

        	   	sheetObj.DoSearch("ESM_FMS_0038GS.do", ComReplaceStr(FormQueryString(formObj),"-",""));
        	   
                break;

			case IBROWSEARCH:   	

	    		if (Col == "slan_cd") {//Service Lane 코드 체크
					
					var param = 'f_cmd='+SEARCH05;
					if(typeof Row == "undefined" || Row == "" ) {
						param += "&lane_cd="+formObj.slan_cd.value;		//form에서 호출하는 경우
					} else {
						param += "&lane_cd="+sheetObj.CellValue(Row, Col);//grid에서 호출하는 경우
					}

		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName == "undefined" || cdName == "" ) {

						if(typeof Row == "undefined" || Row == "" ) {
							formObj.slan_cd.value = "";
							ComAlertFocus(formObj.slan_cd, ComGetMsg("FMS01237"));
						} else {
							ComShowCodeMessage("FMS01237");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
						}
						
					}

	    		} else if (Col == "rlane_cd") {//Revenue Lane 코드 체크
					
					var param = 'f_cmd='+SEARCH07;
					if(typeof Row == "undefined" || Row == "" ) {
						param += "&rlane_cd="+formObj.rlane_cd.value;		//form에서 호출하는 경우
					} else {
						param += "&rlane_cd="+sheetObj.CellValue(Row, Col);//grid에서 호출하는 경우
					}
		
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do" , param);
		
		   			var cdName = ComGetEtcData(sXml, "cdName");
		   			
		   			if(typeof cdName == "undefined" || cdName == "" ) {

						if(typeof Row == "undefined" || Row == "" ) {
							formObj.rlane_cd.value = "";
							ComAlertFocus(formObj.rlane_cd, ComGetMsg("FMS01237"));
						} else {
							ComShowCodeMessage("FMS01237");
							sheetObj.CellValue2(Row, Col) = "";
							sheetObj.SelectCell(Row, Col);
						}
						
					}
				}	
        	   
                break;
        }
    }

    /**
	 * Lane Code 입력부분.<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.slan_cd.value = aryPopupData[0][3];
	}
    
    /**
     * Service LaneCd 변경 시 해당 Lane Code 체크. <br>
     **/
    function lane_cd_change() {
    	if (form.slan_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'slan_cd');
    	}
    }
    
    /**
     * Revenue LaneCd 변경 시 해당 Lane Code 체크. <br>
     **/
    function rlane_cd_change() {
    	if (form.rlane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'rlane_cd');
    	}
    }
    
    /**
     * Lane Search 클릭 시 검색 조건 및 버튼 제어. <br>
     **/
    function lane_search_click() {
    	if (form.lane_search[0].checked) {//Overall
    		
   			form.slan_cd.disabled = true;
   			form.slan_cd.value = '';
   			form.slan_cd.className = "input2";
   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = '';
   			form.rlane_cd.className = "input2";
	    	form.condition[0].disabled = true;
	    	form.condition[1].disabled = true;
	    	form.condition[0].checked = true;
    		document.images["btn_lanepop"].name = "no_btn_lanepop";
	    	form.btn_lanepop.style.cursor = "default";

    	} else {//Each Lane

   			form.slan_cd.disabled = false;
   			form.slan_cd.className = "input";
   			form.rlane_cd.disabled = false;
   			form.rlane_cd.className = "input";
	    	form.condition[0].disabled = false;
	    	form.condition[1].disabled = false;
	    	form.condition[0].checked = true;
    		document.images["btn_lanepop"].name = "btn_lanepop";
	    	form.btn_lanepop.style.cursor = "hand";
    		
    		condition_click();

    	}
    }

    /**
     * Condition 클릭시 Lane Code 종류 제어 <br>
     **/
    function condition_click() {
    	if (form.condition[0].checked) {//Service
   			form.slan_cd.disabled = false;
   			form.slan_cd.className = "input";
   			form.rlane_cd.disabled = true;
   			form.rlane_cd.value = '';
   			form.rlane_cd.className = "input2";
    		document.images["btn_lanepop"].name = "btn_lanepop";
	    	form.btn_lanepop.style.cursor = "hand";
    	} else {//Revenue
   			form.slan_cd.disabled = true;
   			form.slan_cd.value = '';
   			form.slan_cd.className = "input2";
   			form.rlane_cd.disabled = false;
   			form.rlane_cd.className = "input";
    		document.images["btn_lanepop"].name = "no_btn_lanepop";
	    	form.btn_lanepop.style.cursor = "default";
    	}
    }

	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
	
		if (!ComChkValid(formObj)) return false;
	
	 return true;
	}

     /**
      * IBSheet Object에서 팝업을 클릭시
      */
 	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
 		ComColFontName(sheetObj, "slan_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "rlane_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "skd_dir_cd", "Courier New"); 	
 		ComColFontName(sheetObj, "vvd_cd", "Courier New"); 	
	}	

	/* 개발자 작업  끝 */