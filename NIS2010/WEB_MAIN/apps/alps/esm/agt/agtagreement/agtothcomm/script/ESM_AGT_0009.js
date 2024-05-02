/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_AGT_009.js
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.10 추경원
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
     * @class ESM_AGT_009 : ESM_AGT_009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_AGT_009() {
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

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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

                    case "btns_calendar1":
        				 var cal = new ComCalendar();
        				 cal.select(formObject.comm_yrmon1, 'yyyy-MM');
                        break;
    										
    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
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
    					style.height = GetSheetHeight(15) ;
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msPrevColumnMerge;

    				   //전체Edit 허용 여부 [선택, Default false]
    					Editable = false;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(25, 2 , 0, true);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					//var HeadTitle = "Kind|Bound|D2|D4|D5|D7|F2|F4|F5|7|O2|O4|O5|O7|P2|P4|P5|P7|R2|R4|R5|R7|T2|T4|T5|T7|Z2|Z4|Z5|Z7|Q2|Q4|Q5|Q7|S2|S4|S5|S7|A2|A4|A5|A7";
    					var HeadTitle = "Kind|Bound|D2|D4|D5|D7|D9|R2|R4|R5|R7|F2|F4|O2|O4|P2|P4|S2|S4|T2|T4|A2|A4|DW|DX|";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,       80,    daCenter,  true,     "kind",     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,    "bnd",     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "d2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "d4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "d5",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "d7",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "d9",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "r2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "r4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "r5",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "r7",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "f2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "f4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "o2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "o4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "p2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "p4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "s2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "s4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "t2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "t4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "a2",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "a4",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "dw",     false,          "",       dfFloat,         2,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   false,    "dx",     false,          "",       dfFloat,         2,     true,       true);

    					CountPosition  = 0;
    				}
    				break;

    		}
    	}
    	
       /**
    	* Sheet관련 프로세스 처리
    	*/  
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;
            var newRow = -1;

    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)) {
    				    return false;
    				}
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.DoSearch4Post("ESM_AGT_0009GS.do", agtQryStr(formObj));
    				break;

    			case IBDOWNEXCEL:        //엑셀 다운로드
    				sheetObj.SpeedDown2Excel(-1);
    				break;	

    		}
    	}

        /**
         * 검색시 필수입력사항 체크 
         */
        function chkValidSearch(){
            var formObj = document.form;

    		if (formObj.ofc_cd.value.trim() == "") {
    		    ComShowMessage(ComGetMsg("AGT10001", "Office", "", ""));
    		    formObj.ofc_cd.focus();
    			return false;
    		}

    		if (formObj.comm_yrmon1.value.trim() == "") {
    		    ComShowMessage(ComGetMsg("AGT10001", "Apply Month", "", ""));
    		    formObj.comm_yrmon1.focus();
    			return false;
    		}

    		return true;
        }

    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    		    if(!chkValidSearch()) return false;
    		}
    	
    		return true;
    	}

    	/**
    	 * Office 조회 팝업 열기
    	 */	
    	function openWindowOffice(formObj) {
    		var url = "COM_ENS_071.do";
    		var width = 775;
    		var height = 460;
    		var func = "setOffice";
    		var display = '1,0,1,1,1,1,1,1';
    		ComOpenPopup(url, width, height, func, display, true, false);
    	}

    	/**
    	 * POR 조회 팝업 열기
    	 */	
    	function openWindowLocation(formObj, gubun) {
    	    
    		var url = "COM_ENS_051.do";
    		var width = 775;
    		var height = 484;
    		var func = "";
    		var display = '1,0,1,1,1,1,1,1';
    		
    		if(gubun == "POR") {
    		    func = "setPOR";
    		} else if(gubun == "DEL") {
    		    func = "setDEL";
    		}
    		//ComOpenPopup(url, width, height, func, display, bModal, b2ndSheet);
    		ComOpenPopup(url, width, height, func, display, true, false);
    	}

    	/**
    	 * Office 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setOffice(rowArray, row, col) {
    		var colArray = rowArray[0];
    		var office_cd = colArray[3].trim();
    		
    		document.form.ofc_cd.value = office_cd;
    		
    		if(office_cd.length > 0) {
    		    searchUpdate();
    		}
    	}
    	
    	/**
    	 * POR 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setPOR(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.bkg_por_cd.value = colArray[3]; 
    	}
    	
    	/**
    	 * DEL 조회 후 값 Return 받아 셋팅한다.
    	 */
    	function setDEL(rowArray, row, col) {
    		var colArray = rowArray[0];
    		
    		document.form.bkg_del_cd.value = colArray[3]; 
    	}

    	/**
    	 * Update를 조회한다.
    	 */
    	function searchUpdate() {

    	    var form1 = document.hiddenF;
    	    var form2 = document.form;
            var sheetObj = sheetObjects[0];
    	    var ofc_cd = form2.ofc_cd.value.replace(/\/|\-|\./g,"");
    	    var comm_yrmon = form2.comm_yrmon1.value.replace(/\/|\-|\./g,"");
    	    var oldOfficeCd = form2.old_OfficeCd.value.replace(/\/|\-|\./g,"");
    	    var oldCommYrmon = form2.old_CommYrmon.value.replace(/\/|\-|\./g,"");

    	    form2.old_OfficeCd.value = ofc_cd;
    	    form2.old_CommYrmon.value = comm_yrmon;

    	    if(ofc_cd.length > 0 && comm_yrmon.length > 0) {

    	        if( (oldOfficeCd != ofc_cd) || (oldCommYrmon != comm_yrmon) ) {

    	            form2.selUpdateDate.value = "";

                    // Office와 Apply Month가 존재할 경우 Update Date를 조회하여 보여준다.
        	    

        	        form1.ofc_cd.value = ofc_cd;
        	        form1.comm_yrmon.value = comm_yrmon;
                    form1.f_cmd.value = SEARCH01;
                   // form1.submit();
			var sXml = sheetObj.GetSearchXml("ESM_AGT_0009GS.do", agtQryStr(form1));
			var creDt = ComGetEtcData(sXml, "creDt");
			//sheetObj.LoadSearchXml(sXml);
			if(creDt!=null){
        		form2.selUpdateDate.value = creDt;
        		
        		ComSetNextFocus();
			}
        	   }
    	    }
    	}

    	/**
    	 * 날짜 체크 후 Update Date를 조회한다.
    	 */
    	function checkUpdateDt(obj) {
    	    if(!ComChkObjValid(obj)) {
    	        return false;
    	    } else {
    	        searchUpdate();
    	    }
    	    
    	    return true;
    	}

    	/**
         * Inputbox에서 Enter Key Event 발생시 조회 실행한다.
         * @param    : obj => 객체
         * sample	: <input type ="text" name ="data" style="ime-mode:disabled" onkeyUp="checkEnterOffice(this)"  >
         */
        function checkEnterOffice(obj) {

            obj.value = obj.value.trim().toUpperCase();

            if ( window.event.keyCode == 13 ) {
        	    obj.blur(); // Update Date 조회
        	    document.btn_retrieve.click(); // 조회 실행
            }

            return true;
        }


	/* 개발자 작업  끝 */