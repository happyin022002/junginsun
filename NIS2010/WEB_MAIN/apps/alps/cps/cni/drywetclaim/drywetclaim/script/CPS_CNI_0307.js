/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0307.js
*@FileTitle : R.O.E. (Rate of Exchange) Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
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
     * @class R.O.E. (Rate of Exchange) Inquiry : R.O.E. (Rate of Exchange) Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0307() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
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
                
                case "cal_fm_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.fm_dt, 'yyyy-MM');
                    break; 
                
                case "cal_to_dt":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.to_dt, 'yyyy-MM');
                    break; 

				case "btn1_Retrieve":
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;

                case "btn1_New":
					ComResetAll();
                    break; 
			
				case "btn1_Select":
					sheet1_OnDblClick(sheetObject, sheetObject.SelectRow, 0)
	            break;
				
				case "btn1_Close":
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
        //khlee-시작 환경 설정 함수 이름변경
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    }


    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 						//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        
        axon_event.addListener ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');

    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        ComChkObjValid(event.srcElement);
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.name){
	        case "search_curr_cd":
	            ComKeyOnlyAlphabet('uppernum');
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
                    style.height = 240;
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

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false)
					var HeadTitle1 = "Seq|Year-Month|Local Currency|Description|Rate of Exchange (R.O.E.)|Rate of Exchange (R.O.E.)|Rate of Exchange (R.O.E.)|Created Date|Updated Date";
					var HeadTitle2 = "Seq|Year-Month|Local Currency|Description|USD/Local|Local/KRW|USD/KRW|Created Date|Updated Date";
					var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
         			InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  
					InitDataProperty(0, cnt++ , dtSeq,    		30, daCenter,  	true,    	"Seq");
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		"acct_xch_rt_yrmon",	false,  "",	dfDateYm,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			95,	daCenter,	true,		"curr_cd",				false,  "",	dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daCenter,	true,		"curr_nm",				false,  "",	dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daRight,	true,		"usd_locl_xch_rt",		false,  "",	dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daRight,	true,		"locl_krw_xch_rt",		false,  "",	dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daRight,	true,		"usd_krw_xch_rt",		false,  "",	dfNone,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daCenter,	true,		"cre_dt",				false,  "",	dfDateYmd,	0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,	daCenter,	true,		"upd_dt",				false,  "",	dfDateYmd,	0,	false,		false);
               }
                break;
        }
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다. <br>
     * {@link #processButtonClick}함수에서 이 함수를 호출하여 버튼에서 IBSheet의 기능을 호추할 때 사용한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     처리할 Action 코드(예:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL 등이며 CoObject.js에 정의됨)
     * @param {String}  gubun     	처리할 gubun 값
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
        	case IBSEARCH:      //조회

        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value = SEARCH;
        			sheetObj.DoSearch("CPS_CNI_0307GS.do", FormQueryString(formObj));
        		}
        		break;
        }
    }

	// ===================================================================================
	// Sheet 이벤트 처리
	// ===================================================================================
	/**
	* sheet1 doubleClick후 이벤트 
	* @param {ibsheet} sheet 해당 시트   
	* @param {long} row 해당 셀의 Row Index
	* @param {long} col 해당 셀의 Column Index
	*/
	function sheet1_OnDblClick(sheetObj, row, col) {	
		if (row < 1) {
			return;
		}
		
		var xchRtVo = {
				curr_cd:sheetObj.CellValue(row , "curr_cd"),
				usd_locl_xch_rt:sheetObj.CellValue(row , "usd_locl_xch_rt"),
				locl_krw_xch_rt:sheetObj.CellValue(row , "locl_krw_xch_rt"),
				usd_krw_xch_rt:sheetObj.CellValue(row , "usd_krw_xch_rt")
		};
		
		opener.setCurrencyROE(xchRtVo);
		self.close();
	}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	화면 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	sheetObj의 입력값
     * @return {boolean} 정상 여부
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (!ComChkValid(formObj)) return false;
        }

        return true;
    }

	/* 개발자 작업  끝 */