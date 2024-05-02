var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var formObject = document.form1;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_Retrieve":
    	            doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    	            //doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
        	        break;

                case "btn_Save":
                  if(confirm("Do you save selected codes?")){
                    //doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
                  }
        	        break;

        	    case "btn_OK":
        	    	ComShowMessage("btn_ok Click!!");
        	      break;

        	    case "btn_Close":
    	              window.close();
        	      break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
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
        initControl();
    }

    function initControl() {
      	var formObject = document.form1;
          //Axon 이벤트 처리1. 이벤트catch(개발자변경)
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form1');
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
                    style.height = 150 ;
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
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false) ;

                    var HeadTitle = "|STS|SubSystem|Cd ID|Cd Name|Length|Flag" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성      [ROW, COL,       DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,     dtCheckBox,    30,  daCenter,    false,   "check");
                    InitDataProperty(0, cnt++, dtHiddenStatus,    30,  daCenter,    false,  "ibflag");
                    InitDataProperty(0, cnt++,         dtData,    70,  daCenter,    false,    "var1",    false,        "",   dfDateYmd,   	    0,     false,       false);
                    InitDataProperty(0, cnt++,         dtData,    60,  daCenter,    false, "groupid",    false,        "",    dfNone,       	0,     false,       false);
                    InitDataProperty(0, cnt++,         dtData,   160,    daLeft,    false,    "name",    false,        "",      dfNone,	        0,     false,       false);
                    InitDataProperty(0, cnt++,         dtData,    50,  daCenter,    false,    "len",    false,        "",      dfNone,   	    0,     false,       false);
                    InitDataProperty(0, cnt++,         dtData,    40,  daCenter,    false,    "var5",    false,        "",      dfNone,   	    0,     false,       false);
                    
//                    FitColWidth();

               }
               break;
             case 2:      //IBSheet2 init

                with (sheetObj) {

                    // 높이 설정
                    style.height = 150 ;
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
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Cd ID|Cd Val|Cd Val Display Name|Order" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      60,     daCenter,  false,   "codeid",        false,         "",   dfDateYmd,       	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      60 ,    daCenter,  false,   "key",        false,         "",    dfTimeHm,       	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      250,    daLeft,    false,   "value",        false,         "",      dfNone,	        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      50,     daCenter,  false,   "codeorder",        false,         "",      dfNone,   	    0,     false,       false);

               }
               break;

             case 3:      //IBSheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 150 ;
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
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false) ;

                    var HeadTitle = "SubSystem|Cd ID|Cd Name|Length|Flag" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  false,   "ownr_sub_sys_cd",    false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  false,   "intg_cd_id", false,          "",       dfTimeHm,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       200,    daLeft,    false,   "intg_cd_nm",    false,          "",       dfNone,	        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  false,   "intg_cd_len",    false,          "",       dfNone,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  false,   "intg_cd_use_flg",        false,          "",       dfNone,   	0,     false,       false);
                    
//                    FitColWidth();

               }
               break;
             case 4:      //IBSheet4 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 150 ;
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
                    InitColumnInfo(4, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Cd ID|Cd Val|Cd Val Display Name|Order" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,      60,  daCenter,  false,   "intg_cd_id",         false,          "",       dfDateYmd,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      60,  daCenter,  false,   "intg_cd_val_ctnt",         false,          "",       dfTimeHm,   	0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      250, daLeft,    false,   "intg_cd_val_dp_desc",         false,          "",       dfNone,	        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      50,  daCenter,  false,   "intg_cd_val_dp_seq",         false,          "",       dfNone,   	0,     false,       false);

               }
               break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){

                    if ( sheetObj.id == "sheet1" ) {
                      formObj.f_cmd.value = SEARCH01;
                      sheetObj.CheckAll("check")='0';
                      sheetObj.DoSearch4Post("searchCodepublish.do", FormQueryString(formObj));
                      sheetObjects[1].RemoveAll();
                      sheetObjects[2].RemoveAll();
                      sheetObjects[3].RemoveAll();
                    } else if ( sheetObj.id == "sheet2" ) {
                      formObj.f_cmd.value = SEARCH02;
                      sheetObj.DoSearch4Post("searchCodepublish.do", FormQueryString(formObj));
                    } else if ( sheetObj.id == "sheet3" ) {
                      formObj.f_cmd.value = SEARCH03;
                      sheetObj.DoSearch4Post("searchCodepublish.do", FormQueryString(formObj));
                      sheetObjects[3].RemoveAll();
                    } else if ( sheetObj.id == "sheet4" ) {
                      formObj.f_cmd.value = SEARCH04;
                      sheetObj.DoSearch4Post("searchCodepublish.do", FormQueryString(formObj));
                    }
                }
                break;
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value = MULTI;
                setSelectedCodes(sheetObj);
                sheetObj.DoSave("searchCodepublish.do", FormQueryString(formObj),"ibflag", false);
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

    function sheet1_OnDblClick(sheetObj, Row, Col) {
      document.form1.codeid.value = sheetObj.CellValue(Row,"groupid");
      document.form1.selectedcodes.value = sheetObj.CellValue(Row,"groupid");
      doActionIBSheet(sheetObjects[1],document.form1,IBSEARCH);
      doActionIBSheet(sheetObjects[2],document.form1,IBSEARCH);
      doActionIBSheet(sheetObjects[3],document.form1,IBSEARCH);
    }

    function sheet3_OnDblClick(sheetObj, Row, Col) {
      document.form1.codeid.value = sheetObj.CellValue(Row,"groupid");
      doActionIBSheet(sheetObjects[3],document.form1,IBSEARCH);
    }
    
    /**
     * 데이타를 저장한 후에 처리하는 함수
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
    function sheet1_OnSaveEnd(sheetObj,errMsg){
      if(errMsg == null || errMsg == ""){
        //sheet1_SetAllCheckBox(sheetObj,"check",false);
        doActionIBSheet(sheetObjects[0],document.form1,IBSEARCH);
        doActionIBSheet(sheetObjects[2],document.form1,IBSEARCH);
      }else{
    	  ComShowMessage(errMsg);
      }
    }
    
    /**
     * 정상적으로 저장된 코드정보를 조회하기 위한 코드파라메터를 form에 등록한다
     */
    function setSelectedCodes(sheetObj){
      var codes = new Array();
      var j = 0;
      for(i=1;i<sheetObj.RowCount+1;i++){
        if (sheetObj.CellValue(i, "check") == '0') continue;
        codes[j++] = sheetObj.CellValue(i,"groupid");
      }
      document.form1.selectedcodes.value = codes.join("|");
    }
    
    /**
     * 정상적으로 저장된 후 체크박스를 초기화시킨다
     */
    function sheet1_SetAllCheckBox(sheetObj,savename,sAction){
      for(i=1;i<sheetObj.RowCount;i++){
        sheetObj.RowStatus(i) = 'R';
      }
      
      if(sAction){
        sheetObj.CheckAll(savename)='1';
      }else{
        sheetObj.CheckAll(savename)='0';
      }
    }