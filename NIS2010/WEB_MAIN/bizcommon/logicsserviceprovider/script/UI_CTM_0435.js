/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0423.js
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민 
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
     * @class Restuffing Inquiry : Restuffing Inquiry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function UI_CTM_0435() 
    {
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
var selectVal;

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
		        case "btn_Retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
					
                case "btn_new":
                	sheetObject.RemoveAll();
    	            formObject.reset();
                    break;
                    
                case "btn_ok":
                	doActionIBSheet(sheetObject, document.form, COMMAND01);
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        axon_event.addListenerFormat('keypress', 'obj_keypress', form); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
     
 	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "engup":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
	    }
	}

	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) 
     {
        var cnt = 0;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 177;
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

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
                    InitHeadMode(true, true, false, true, false,false)
                    
                    var HeadTitle = "||S/P Code|Control Office|Name|Address";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",       false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  50,    daCenter,  false,    "checkbox",       false,          "",       dfNone,   	0,     true,       true);

                    InitDataProperty(0, cnt++ , dtData,      60,    daCenter,  false,     "vndr_seq",     false,          "",      dfNone      );
                    InitDataProperty(0, cnt++ , dtData,      90,    daCenter,  false,     "ofc_cd",     false,          "",      dfNone      );
                    InitDataProperty(0, cnt++ , dtData,      210,    daLeft,  false,     "vndr_lgl_eng_nm",     false,          "",      dfNone     ,0          , false,       false,      25 );
                    InitDataProperty(0, cnt++ , dtData,      110,    daLeft,  false,     "eng_addr",     false,          "",      dfNone     ,0          , false,       false,      30  );
                    InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	true,		"pagerows",			false,		"",			dfNone,		0,			true,		true);
                    InitDataProperty(0, cnt++ , dtHiddenStatus,0,		daCenter,	false,		"ibflag");
               }
                break;
        }
    }

     function sheet1_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) 
     {
         // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
     } 

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) 
     {
        sheetObj.ShowDebugMsg = false;

         switch(sAction) 
        {
	       	case IBSEARCH: // 조회
		   		if (sheetObj.id == "sheet1") {
		   			formObj.f_cmd.value = SEARCH;
		   			sheetObj.DoSearch("UI_CTM_0435GS.do", FormQueryString(formObj));
		   		}
		   		break;
	
			case COMMAND01: // 선택
		   		var selrow = sheetObj.SelectRow;
		   		if (selrow > 0) {
		   			comPopupOK();
		   		}
		   		break;

           case IBSEARCHAPPEND:  // 페이징 조회
	           formObj.f_cmd.value = SEARCH;         
	           sheetObj.DoSearch4Post("UI_CTM_0435GS.do", selectVal, "iPage=" + PageNo, true);  
	           break;
        }
         sheetObj.ShowDebugMsg = false;
    }

	/**
	 * 그리드에서 더블클릭했을 때의 처리 : 선택한 값을 부모창으로 리턴하고, 팝업창을 닫는다.
	 */
	function sheet1_OnDblClick(sheetObj, row, col, value) {
		var selrow = sheetObj.SelectRow;
		if (selrow > 0) {
			comPopupOK();
		}
	}
