/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0089.js
*@FileTitle : RF Status Inquiry By VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.05 민정호
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
     * @class esm_fms_0089 : esm_fms_0089 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0089() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 				= validateForm;
    	this.initControl            		= initControl;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress				= obj_keypress;    	    	
    	this.setGrid						= setGrid;
    }
    
   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
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
    		 		setGrid();
	                break;
		                	                
				case "btn_condition":
					setGrid();
					break;
					
				case "btn_savetofile":
					sheetObject.SpeedDown2Excel(-1);
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
		for(i=0;i<sheetObjects.length;i++) {
	    	// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
	    	// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
			
			sheetObjects[i].ExtendLastCol = false;
	    }	    
	    initControl();	    
	    setGrid();
		form.vvd.focus();	    
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
	                style.height = 370;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = "|Seq|Yard|ETA|ETD|Loading|Discharging|Cell To Cell|ROB|Loading Port|Discharging Port|Operator|CNTR No|Kind";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,	false,  "ibflag");
					InitDataProperty(0, cnt++ , dtSeq,    		 40,    	daCenter,  	true,   "Seq");	                
					InitDataProperty(0, cnt++ , dtData,      	70,   	daCenter,  	true,   "yard", 			false,  "", dfNone, 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	true,   "vpsetadt", 		false,  "", dfNone, 0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	true,   "vpsetddt", 		false,  "", dfNone, 0,	false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,      60,   	daRight,  	true,  "loading",	 		false,  "", dfInteger, 0,  false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,       80,   	daRight,  	true,  "discharging",  		false,  "", dfInteger, 0,  false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,       80,   	daRight,  	true,  "celltocell"	,  		false,  "", dfInteger, 0,  false,	false);
					InitDataProperty(0, cnt++ , dtAutoSum,       80,   	daRight,  	true,  "rob",  				false,  "", dfInteger, 0, 	false,	false);
					InitDataProperty(0, cnt++ , dtData,   	   	100,   	daCenter,  	true,   "loadingport",   	false,  "", dfNone,	0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "dischargingport",  false,  "", dfNone,	0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "operator",   		false,  "", dfNone,	0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "cntrno",   		false,  "", dfNone,	0,  false,	false);
					InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   "kind",   			false,  "", dfNone,	0,  false,	false);					
					
					InitDataValid(0, "yard",		vtEngUpOnly);
					InitDataValid(0, "loadingport",	vtEngUpOther, "0123456789");
					InitDataValid(0, "dischargingport",	vtEngUpOther, "0123456789");
					InitDataValid(0, "operator",	vtEngUpOther, "0123456789");
					InitDataValid(0, "cntrno",	vtEngUpOther, "0123456789");
					InitDataValid(0, "kind",	vtEngUpOther, "0123456789");					
					
	           	}

				break;
		}
	}

	/**
	 * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다.<br>
	 **/
	function doActionIBSheet(sheetObj, formObj, sAction, objNm, row) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	       	case IBSEARCH:      //조회
		       	if(validateForm(sheetObj, formObj, sAction)) {
					formObj.f_cmd.value = SEARCH;
					
		    		if(formObj.btn_condition[0].checked) {
						formObj.search_type.value = "S";		    			
		    		}else if(formObj.btn_condition[1].checked) {
						formObj.search_type.value = "D";		    			
		    		}else{
						formObj.search_type.value = "";		    			
		    		}
										
					sheetObj.DoSearch("ESM_FMS_0089GS.do", FormQueryString(formObj));
				}

	            break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 Validation을 체크한다.<br>
	 */
	function validateForm(sheetObj,formObj,sAction) {
			
    	switch(sAction) {
			case IBSEARCH:
				if (formObj.vvd.value.length <9 ){										
    				ComShowMessage(ComGetMsg('FMS01232'));
					formObj.vvd.focus();
					return false;
				}				
  			break;  			
    	}
    	return true;
	}
	 	
 	/**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
 	function initControl() {
 		// Axon 이벤트 처리1. 이벤트catch
        axon_event.addListenerFormat('keypress', 'obj_keypress'  	, form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리        
 	}
 	    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     **/
    
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
  	        case "engupnum":
  	        	//숫자+"영문대분자"입력하기
			    ComKeyOnlyAlphabet('uppernum');
			    break;	            
			default:
		        //숫자만입력하기
				ComKeyOnlyAlphabet('uppernum');
    	}
    }
    
    /**
     * Search Type에 따라서 Grid 세팅<br>
     **/ 	
    function setGrid() {    	 
    	sheetObjects[0].RemoveAll();  
    	
		if(form.btn_condition[0].checked) {						
			sheetObjects[0].ColHidden("loading") = false;
			sheetObjects[0].ColHidden("discharging") = false;
			sheetObjects[0].ColHidden("celltocell") = false;
			sheetObjects[0].ColHidden("loading") = false;
			sheetObjects[0].ColHidden("rob") = false;			
			
			sheetObjects[0].ColHidden("loadingport") = true;
			sheetObjects[0].ColHidden("dischargingport") = true;
			sheetObjects[0].ColHidden("operator") = true;
			sheetObjects[0].ColHidden("cntrno") = true;
			sheetObjects[0].ColHidden("kind") = true;			
		}else{
			sheetObjects[0].ColHidden("loading") = true;
			sheetObjects[0].ColHidden("discharging") = true;
			sheetObjects[0].ColHidden("celltocell") = true;
			sheetObjects[0].ColHidden("loading") = true;
			sheetObjects[0].ColHidden("rob") = true;			
		
			sheetObjects[0].ColHidden("loadingport") = false;
			sheetObjects[0].ColHidden("dischargingport") = false;
			sheetObjects[0].ColHidden("operator") = false;
			sheetObjects[0].ColHidden("cntrno") = false;
			sheetObjects[0].ColHidden("kind") = false;				
		}		
    }

    /** 
    * 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
    * @param  {IBSheet} sheetObj : 시트오브젝트  
    * @param  {string} errMsg : 에러메세지  
    * @return 없음
    */     
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.SetMergeCell (sheetObj.LastRow, 1, 0, 2);		
		if(form.btn_condition[0].checked) {				
			sheetObj.RowHidden(sheetObj.LastRow) = false;			
		}else{
			sheetObj.RowHidden(sheetObj.LastRow) = true;
		}		
	}
	/* 개발자 작업  끝 */