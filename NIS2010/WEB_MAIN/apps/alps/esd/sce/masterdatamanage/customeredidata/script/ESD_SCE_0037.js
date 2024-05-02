
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
                case "btn_close" :
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
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "Seq|Standard\n EDI Status|Customer\n EDI Status|BKG No.|BKG No.|B/L No.|Truck\nVVD|Location/\nYard|Event Date|Send Date|Result|Remarks" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,     50,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     75,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     75,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  false,    "",        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     20,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     90,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                                                                                                                                               
                    InitDataProperty(0, cnt++ , dtData,     70,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     80,    daCenter,  false,    "",        false,          "",       dfNone, 0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "",        false,          "",       dfNone, 0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtData,     130,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);                                                                                                                           
                    InitDataProperty(0, cnt++ , dtData,     50,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     60,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     true,       true);
                    style.height = GetSheetHeight(10) ;
                    
                    //DoSearch("ESD_SCE_0037GS.do");
                    
                     
               }
                break;

        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
                // if(validateForm(formObj)){
    		        formObj.f_cmd.value = SEARCH01;
    			    sheetObj.DoSearch4Post("ESD_SCE_0037GS.do", SceFrmQryString(formObj));
			    // }
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
