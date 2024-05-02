var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
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
    	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                  //zu_openRunning(false);
        	        break;
        	    case "btn_confirm":
        	    		comPopupOK();
       	        break;
             case "btn_close":
                  self.close();
                  break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(getMsg('COM12111'));
    		} else {
    			ComFuncErrMsg(e);
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
          ComConfigSheet(sheetObjects[i]);
          initSheet(sheetObjects[i],i+1);
          ComEndConfigSheet(sheetObjects[i]);
      			}
      doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //IBSheet1 init

                with (sheetObj) {

                    // 높이 설정
                    style.height = 270 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;

                    var HeadTitle = "||Level|Role Cd|Role Name|Role Description|Upper Role Cd|Reg Date" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,30,    daCenter,  false,    "radio",           false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",           false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,  false,    "Level",             false,        "",     dfNone,       0,        false,      false);
                    InitDataProperty(0, cnt++ , dtData,          70,   daCenter,  false,    "usr_role_cd",       true,         "",     dfNone,       0,        false,      true);
                    InitDataProperty(0, cnt++ , dtData,         120,   daLeft,    false,    "usr_role_nm",       true,         "",     dfNone,	     0,        true,       true);
                    InitDataProperty(0, cnt++ , dtData,         260,   daLeft,    false,    "usr_role_desc",     false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        90,   daCenter,  false,    "prnt_usr_role_cd",  false,        "",     dfNone,       0,        true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        80,   daCenter,  false,    "cre_dt",            false,        "",     dfDateYmd,    0,        false,      false);
                    
                    InitTreeInfo(2, "Level");
               }                                                      
                                                          
               break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회
              formObj.f_cmd.value = SEARCH;
              sheetObj.DoSearch4Post("searchUpperRole.do", FormQueryString(formObj));
              break;
            case IBSAVE:        //저장
              break;
        }
    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
    
    /**
     * opener로 값을 리턴하는 기능 구
     * opener의 폼 element로 리턴하는 경우는 settingData함수를 사용하고,
     * opener의 IBSheet로 리턴하는 경우는 settingDataIBSheet를 사용합니다.
     * 사용방법은 동일하지만 두 함수 내에서 처리하는 로직만 다릅니다.
     * 둘중 하나만 사용한다 .
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    
    	// 1. form control에 들어갈 .
        try{
         settingData(sheetObj.CellValue(Row, "usr_role_cd"));
        }catch(e){}
        
        
        
    	// 2. ibSheet control에 들어갈 .        
        try{
         settingDataIBSheet(sheetObj.CellValue(Row, "usr_role_cd"));
        }catch(e){}
        
    }