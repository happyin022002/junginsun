/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1043.js
*@FileTitle : OP/MG Forecast Log
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.20
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.02.21 신용찬 [CHM-201323022]    OP/MG FCST HISTORY 화면생성(버튼)
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var headCount = 0;
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1043 : EES_EQR_1044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1043() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var shtCnt = 0;
        var sheetObject = sheetObjects[shtCnt++];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_downexcel":
                    if(sheetObjects[0].RowCount > 0){
                        doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
                    }
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

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
            	
                    // 높이 설정
                    style.height = 540;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msNone;
                    MergeSheet = msPrevColumnMerge;
                    
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle = "Balance Report ID|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5|User Name|Office|Date(Local)|Date(GMT)";
                    headCount = ComCountHeadTitle(HeadTitle);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    CountPosition = 0;  //페이지카운트 없애기

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    sheetObj.FrozenCols = 1; 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,        120,     daCenterTop,true,   "inp_yrwk",         false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "d2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "d4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "d5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "d7_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "r2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "r5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "r9_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "o2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "s2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "o4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "s4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "o5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "f2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "a2_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "f4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "a4_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "f5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,         45,     daRight,    false,  "a5_fcast_qty",     false,  "", dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,        100,     daCenter,   false,  "usr_nm",  	   	    false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,         75,     daCenter,   false,  "ofc_cd",           false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,        120,     daCenter,   false,  "locl_dt",          false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,        120,     daCenter,   false,  "cre_dt",           false,  "", dfNone);

               }
               break;               
        }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {

        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {

            case IBSEARCH:      //조회
            	sheetObj.WaitImageVisible=false;
            	ComOpenWait(true); 
                formObj.f_cmd.value = SEARCH;
                
                var sXml = sheetObj.GetSearchXml("EES_EQR_1043GS.do",FormQueryString(formObj));
                sheetObj.LoadSearchXml(sXml);

                ComOpenWait(false); 
                break;
                
            case IBDOWNEXCEL:      // 입력
            	sheetObj.Down2Excel(-1, false, false, true);

             break;
        }
    }    

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function sheet1_OnSearchEnd(sheetObj, msg){
 		if ( document.form.search_flag.value=="0" ) {  // DRY
			setCellHidden(sheetObj,false,true);
		} else if ( document.form.search_flag.value=="1" ) { // SPCL
			setCellHidden(sheetObj,true,false);
		} else {  // ALL
			setCellHidden(sheetObj,false,false);
		}
     }

     /**
      * 관리대상 EQ TP/SZ를 결정
      */
     function setCellHidden(sheetObj,showFlag1,showFlag2) {
 			
 		sheetObj.ColHidden("d2_fcast_qty") = showFlag1;
 		sheetObj.ColHidden("d4_fcast_qty") = showFlag1;
 		sheetObj.ColHidden("d5_fcast_qty") = showFlag1;
 		sheetObj.ColHidden("d7_fcast_qty") = showFlag1;
 		
 		sheetObj.ColHidden("r2_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("r5_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("r9_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("o2_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("s2_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("o4_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("s4_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("o5_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("f2_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("a2_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("f4_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("a4_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("f5_fcast_qty") = showFlag2;
 		sheetObj.ColHidden("a5_fcast_qty") = showFlag2;
    }
    
	    
      
