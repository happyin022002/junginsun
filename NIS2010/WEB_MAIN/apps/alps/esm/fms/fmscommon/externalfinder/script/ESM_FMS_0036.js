/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0036.js
*@FileTitle : Lane Code Search - Window
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.13 윤세영
* 1.0 Creation
* 2010.08.11 이준범 CHM-201005317-01 
*            - Lane Name 입력시 대문자변환등 이벤트 제거 initControl()
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
     * @class esm_fms_0036 : esm_fms_0036 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0036() {
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
					if (formObject.vsl_slan_cd.value.length < 1 && formObject.vsl_slan_nm.value.length < 1) {
						ComAlertFocus(formObject.vsl_slan_cd, ComGetMsg('FMS01081'));
						return;
					}
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;

				case "btn_confirm":
					comPopupOK();
	            break;
				
				case "btn_close":
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
        //2010.08.11 이준범 axon_event.addListener () 에서 "vsl_slan_nm" 제거
        axon_event.addListener ('keypress', 'eng_keypress');
        axon_event.addListener ('keypress', 'eng_num_keypress', 'vsl_slan_cd');
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        document.form.vsl_slan_cd.focus();
    }

    //업무 자바스크립트 OnKeyPress 이벤트 처리
    function eng_keypress() {
        //영대문자 자동변환 
        ComKeyOnlyAlphabet('upper');
    }

    /**
    * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
    **/
   function eng_num_keypress() {
       //영대문자 자동변환
       ComKeyOnlyAlphabet('uppernum');
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
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                    InitHeadMode(true, true, false, true, false,false)
                    var HeadTitle = "||Seq|Lane Code|Lane Name|SVC Type|Trunk On Off";
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE, SAVENAME,		KEYFIELD,	CALCULOGIC,	DATAFORMAT,		POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                  
                    InitDataProperty(0, cnt++, 	dtRadioCheck,	0,    	daCenter,  	false,		"radio",   		false,      "",     dfNone,	    	0,     		true,       true);
                    InitDataProperty(0, cnt++, 	dtCheckBox,  	0,    	daCenter,  	false,   	"check",   		false,      "",     dfNone,   		0,     		true,       true);
					InitDataProperty(0, cnt++ , dtDataSeq,    	30,    	daCenter,  	true,    	"Seq");
					InitDataProperty(0, cnt++ , dtData,   		75,   	daCenter,  	false,   	"vsl_slan_cd",	false,        "",     dfNone,   	0,    false,      false);
					InitDataProperty(0, cnt++ , dtData,   		241,  	daLeft,  	false,   	"vsl_slan_nm",  false,        "",     dfNone,     	0,    false,      false, 50);
                    InitDataProperty(0, cnt++ , dtData,      	70,    	daCenter,  	false,     	"vsl_svc_tp_cd",false,          "",      dfNone,      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      	95,     daCenter,  	false,     	"trunk_on_off", false,          "",      dfNone,      0,     false,       false);
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
    function doActionIBSheet(sheetObj,formObj,sAction, col) {
//        sheetObj.ShowDebugMsg = true;
        switch(sAction) {
        	case IBSEARCH:      //조회
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value = SEARCH;
        	   		sheetObj.DoSearch("ESM_FMS_0036GS.do", FormQueryString(formObj));
        		}
        		break;


        }
    }

    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
   		sheetObj.ColumnSort("vsl_slan_nm");
 		ComColFontName(sheetObj, "vsl_slan_cd", "Courier New"); 	
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
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
        }

        return true;
    }


	/* 개발자 작업  끝 */