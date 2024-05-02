/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0060.js
*@FileTitle : Packing Instructions/Provisions (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.25 김현욱
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
     * @class vop_scg_0060 : vop_scg_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0060() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnDblClick 		= sheet1_OnDblClick;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt     = 0;
    var prefix       = "sheet1_";
    
    var uploadObjects = new Array();
	var uploadCnt     = 0;
	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {    	
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    }
    
 	// 업무 자바스크립트 OnKeyUp 이벤트 처리
    function obj_keypress() {
    	switch(event.srcElement.dataformat){
    	    case "engup":
    	    	switch(event.srcElement.name){
	    	        case "imdg_pck_instr_cd":	
	    	        	//공통기준:영문대, 숫자만을 인식
	        	    	ComKeyOnlyAlphabet('uppernum');
	    	        	break;
    	    	}
    	    	break; 
    	}
    }

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
				case "btn_down_excel":
    				var paramObj = new Object();
    				paramObj.title = "Packing Instructions/Provisions";
                    paramObj.orientation = "Portrait";
    				paramObj.columnwidth = "2:20|3:20|4:20|5:15";
    				paramObj.datarowheight   = "0:25";
    				var url = ComScgGetPgmTitle(sheetObjects[0], paramObj);  
    				sheetObjects[0].SpeedDown2Excel(-1, false,false, "", url );
					
//					sheetObject.SpeedDown2Excel(-1,false,false,"","",false,false,"Packing Instructions&Provisions",false);
					break;
				case "btn_OK":
					comPopupOK();
					
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
        
//        //페이지로딩시 초기 조회
        if(preConds.pop_yn == 'Y') {
       	 //초기 조건 셋팅
    	sheetObjects[0].ColHidden("checkbox") = false;
	         if(preConds.imdg_pck_instr_cd != '') {	         	
	         	ComSetObjValue(document.form.imdg_pck_instr_cd, preConds.imdg_pck_instr_cd);
	         }
	         if(preConds.imdg_pck_instr_seq != '') {	         	
		       	ComSetObjValue(document.form.imdg_pck_instr_seq, preConds.imdg_pck_instr_seq);
		     }
	        
        }
        
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        
        //이벤트 리스너 생성
        initControl();

    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //sheet1 init
                with (sheetObj) {

                    //높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                   // Editable = false;
                    Editable = true ;
                    
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    //해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)
               
                    var HeadTitle = "||No.|Seq|File Sav Id|Packing Instructions\nProvisions|Sub|FileNm|Desc.|ID|Date";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	    daCenter,   true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtRadioCheck, 	30,    	daCenter,   true,   "checkbox", 			          false,	"",     dfNone,     0,   true,  true);     
                    InitDataProperty(0, cnt++ , dtDataSeq,      30,     daCenter); 
                    InitDataProperty(0, cnt++ , dtHidden,     	30,     daLeft,	   true,    prefix+"imdg_pck_instr_seq",  false,    "",     dfNone,     0,   true,  true);
                    InitDataProperty(0, cnt++ , dtHidden,   	0,      daLeft,	   true,    prefix+"file_sav_id", 		      false,    "",     dfNone,     0,   true,  true);
                    InitDataProperty(0, cnt++ , dtData,   		160,    daLeft,	   true,    prefix+"imdg_pck_instr_cd", 	  false,    "",     dfNone,     0,   true,  true,  10);
                    InitDataProperty(0, cnt++ , dtHidden,       50,     daCenter,  true,    prefix+"imdg_pck_instr_sub_seq",  false,    "",     dfNone,     0,   true,  true,  2);
                    InitDataProperty(0, cnt++ , dtData,			120,    daLeft,	   true,    prefix+"file_nm", 	    		  false,    "",     dfNone,     0,   false, false, 200);
                    InitDataProperty(0, cnt++ , dtData,		    500,    daLeft,	   true,    prefix+"pck_desc", 	    	      false,    "",     dfNone,     0,   false, false, 4000);
                    InitDataProperty(0, cnt++ , dtData,			70,    daCenter,  true,    prefix+"cre_usr_id", 	 		  false,    "",     dfNone,     0,   false, false);
                    InitDataProperty(0, cnt++ , dtData,			70,    daCenter,  true,    prefix+"cre_dt", 	  			  false,    "",     dfDateYmd,  0,   false, false);
                   
                	ColHidden("checkbox") = true;
                	
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;		
				
					sheetObj.DoSearch("VOP_SCG_0042GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));	

				}

				break;
        }
    }
    
    /**
     * Sheet 조회완료 후 이벤트 발생
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
			
			ColFontUnderline(prefix+"file_nm") = true;
			DataLinkMouse(prefix+"file_nm") = true;
			
		}

	}
	
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/
	function sheet1_OnDblClick(sheetObj, Row, Col, Value){		
		if (sheetObj.ColSaveName(Col) != prefix+"file_nm") 
			return;
		
		//파일명이 없는 경우 오류
		if(sheetObj.CellText(Row, prefix+"file_nm") == "") {
			return;
		}
		location.href = "/hanjin/FileDownload?key="+sheetObj.CellText(Row, prefix+"file_sav_id");
		
		return;
	}


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }

        return true;
    }
      
    
	/* 개발자 작업  끝 */