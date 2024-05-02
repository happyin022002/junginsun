/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0085.js
*@FileTitle : E-mail List Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.09.09 최우석
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
     * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0085() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.initConfirm			= initConfirm;
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
        var sheetObject1 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");
        	switch(srcName) {
	        	case "btn_retrieve":
					if(!initConfirm()) return;
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
			 		break;
    	    	case "btn_new":
    	    		if(!initConfirm()) return;
    		 		ComResetAll();
    	        	break;
    	    	case "btn_save":
    	    		doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    	    	case "btn_add":
					var row = sheetObject.DataInsert(-1);
					break;
    	    	case "btn_del":
					ComRowHideDelete(sheetObject, "DelChk");
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
	        ComConfigSheet (sheetObjects[i] );
	
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
	        
	        sheetObjects[i].ExtendLastCol = false;
    	}

    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
     

    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH);
		
		sheetObj.WaitImageVisible = true;   
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;

    	switch(sheetNo) {
         	case 1:
         		with (sheetObj) {

         			// 높이 설정
         			style.height = 460;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 3, 100);
     
     				var HeadTitle1 = "|Sel|Seq|Personal Information|E-mail Address|eml_seq";
     				var headCount = ComCountHeadTitle(HeadTitle1);
     
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    	daCenter,  	true,   "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	true,   "DelChk");
                    InitDataProperty(0, cnt++, 	dtDataSeq,     	40,    	daCenter,  	true,	"Seq");
    				InitDataProperty(0, cnt++ , dtData,    		160,	daLeft,		false,	"cntc_pson_nm",		true,	"",	dfNone,	0,	true,	true, 100);
    				InitDataProperty(0, cnt++ , dtData,    		200,	daCenter,	false,	"cntc_pson_eml",	true,	"",	dfNone,	0,	true,	true, 50);
    				InitDataProperty(0, cnt++ , dtHidden,    	30,		daCenter,	false,	"eml_seq",			true,	"",	dfNone,	0,	true,	true);
    				
    				InitDataValid(0, "cntc_pson_eml", vtEngOther, "-_.@0123456789");
         		}
         		break;
    	}
    }

    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {

    	case IBSEARCH:      //조회
    		formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_FMS_0085GS.do", FormQueryString(formObj));
    		break;

    	case IBSAVE:        //저장
    		formObj.f_cmd.value = MULTI;
    		sheetObj.DoSave("ESM_FMS_0085GS.do", FormQueryString(formObj)); 
    		break;

    	case IBINSERT:      // 입력
    		break;
    	}
    }

    /**
     * 이벤트 발생시 실행여부 확인 <br>
     * @return {boolean} okYn   메세지 확인창에서 확인버튼 클릭하면 okYn:true 아니면 okYn:false
     **/
    function initConfirm() {
     	var okYn = true;
     	if(sheetObjects[0].isDataModified) {
     		var okYn = ComShowCodeConfirm("FMS00002");
     	}
     	
     	return okYn;
    }
     
    // 이메일 Validation을 체크한다.<br>
    function checkMail(strMail) {
    	/** 체크사항 
         - @가 2개이상일 경우 
         - .이 붙어서 나오는 경우 
         -  @.나  .@이 존재하는 경우 
         - 맨처음이.인 경우 
         - @이전에 하나이상의 문자가 있어야 함 
         - @가 하나있어야 함 
         - Domain명에 .이 하나 이상 있어야 함 
         - Domain명의 마지막 문자는 영문자 2~4개이어야 함 **/ 

    	var check1 = /(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;  
         
        var check2 = /^[a-zA-Z0-9\-\.\_]+\@[a-zA-Z0-9\-\.]/; 

     	if ( !check1.test(strMail) && check2.test(strMail) ) {
     		return true;
     	} else { 
     		return false; 
     	} 
    }

    /**
     * sheet1의 OnChange이벤트 발생시 이메일 Validation을 체크한다.<br>
     */
 	function sheet1_OnChange(sheetObj, row, col, value) {
        if(col == 4) {
        	if(!checkMail(value)) {
        		ComShowCodeMessage("FMS01147");
        		sheetObj.CellValue2(row, "cntc_pson_eml") = "";
        		sheetObj.SelectCell(row, "cntc_pson_eml");
        	}
        }
 	}
    /* 개발자 작업  끝 */