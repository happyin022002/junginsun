/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0171.js
*@FileTitle : Temp T/S Route
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.29 송호진
* 1.0 Creation
*=========================================================
* History
* 1.0 최초 생성
* 2009-06-10 박상희  N200905110270 MAS_Pre CM/OP Simulation : Temp T/S Route 입력기능
* 2009-10-08 송호진 ALPS 전환
* 2010-01-11 송호진 Lane Code 에서 숫자 입력이 가능하도록 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
*=========================================================*/
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
     * @class ESM_MAS_0171 : ESM_MAS_0171 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0171() {
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


        /**
         * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
         */
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;

            try {
                var srcName = window.event.srcElement.getAttribute("name");
                switch(srcName) {
                    case "btn_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;

                    case "btn_close":
                        window.close();
                        break;
                }
            } catch(e) {
                if( e == "[object Error]") {
                    ComShowMessage(OBJECT_ERROR);
                } else {
                    ComShowMessage(e);
                }
            }
        }

        /**
        * Sheet 기본 설정 및 초기화
        * body 태그의 onLoad 이벤트핸들러 구현
        * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
        */
        function loadPage(dirOpr, iocOpr) {
            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1,dirOpr, iocOpr);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
        }

        /**
         * 시트 초기설정값, 헤더 정의
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo,dirOpr, iocOpr) {
            var cnt = 0;
            var i = 0;
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with (sheetObj) {

                        SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
                        Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 2, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(9, 0 , 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        var HeadTitle  = "POL|T/S Route|T/S Route|T/S Route|T/S Route|T/S Route|T/S Route|T/S Route|POD";
                        var HeadTitle1 = "POL|1st Lane|1st TS Port|2nd Lane|2nd TS Port|3rd Lane|3rd TS Port|4th Lane|POD";
                        InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(1, HeadTitle1, true);                           //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                            //데이터속성[ ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,    SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0,     cnt++,      dtData,   70,     daCenter,    true,       "n_pol",            true,      "",        dfNone,  0,     true,       true    ,5);
                        InitDataProperty(0,     cnt++,      dtData,   70,     daCenter,   false,       "lane1",            true,      "",        dfNone,  0,     true,       true    ,3);
                        InitDataProperty(0,     cnt++,      dtData,   70,     daCenter,   false,       "port1",           false,      "",        dfNone,  0,     true,       true    ,5);
                        InitDataProperty(0,     cnt++,      dtData,   60,     daCenter,   false,       "lane2",           false,      "",        dfNone,  0,     true,       true    ,3);
                        InitDataProperty(0,     cnt++,      dtData,   70,     daCenter,   false,       "port2",           false,      "",        dfNone,  0,     true,       true    ,5);
                        InitDataProperty(0,     cnt++,      dtData,   60,     daCenter,   false,       "lane3",           false,      "",        dfNone,  0,     true,       true    ,3);
                        InitDataProperty(0,     cnt++,      dtData,   70,     daCenter,   false,       "port3",           false,      "",        dfNone,  0,     true,       true    ,5);
                        InitDataProperty(0,     cnt++,      dtData,   60,     daCenter,   false,       "lane4",           false,      "",        dfNone,  0,     true,       true    ,3);
                        InitDataProperty(0,     cnt++,      dtData,   43,     daCenter,    true,       "n_pod",            true,      "",        dfNone,  0,     true,       true    ,5);

                        style.height = GetSheetHeight(14) ;

            		    CellBackColor(1,"n_pol")    = RgbColor(231,250,249);
                        CellBackColor(1,"lane1")    = RgbColor(222, 251, 248);
            		    CellBackColor(1,"port1")    = RgbColor(255, 248, 251);
            		    CellBackColor(1,"lane2")    = RgbColor(222, 251, 248);
            		    CellBackColor(1,"port2")    = RgbColor(255, 248, 251);
            		    CellBackColor(1,"lane3")    = RgbColor(222, 251, 248);
            		    CellBackColor(1,"port3")    = RgbColor(255, 248, 251);
            		    CellBackColor(1,"lane4")    = RgbColor(222, 251, 248);
            		    CellBackColor(1,"n_pod")    = RgbColor(231,250,249);

                        DataInsert(-1); // 초기로드시 행 추가

                        // 영문자 또는 숫자만 입력
                        for(i=LeftCol; i<=LastCol; i++){ //영문 대문자만 입력허용
                        	InitDataValid(0, i , vtEngUpOther, "0123456789");
                        }
                    }
                    break;
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
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {
                case IBSAVE:        /*저장*/
                    var sheetobj2 = opener.sheetObjects[0] // 부모창의 sheet
                    var formObj2  = opener.document.form;// 부모창의 formObject
                    var l = sheetobj2.LastRow;
                    var n_ts_route = "";
                    var exist_flg ="N";

                    //pop up화면 입력값
                    var lane1 = sheetObj.CellValue(2,"lane1");
                    var port1 = sheetObj.CellValue(2,"port1");
                    var lane2 = sheetObj.CellValue(2,"lane2");
                    var port2 = sheetObj.CellValue(2,"port2");
                    var lane3 = sheetObj.CellValue(2,"lane3");
                    var port3 = sheetObj.CellValue(2,"port3");
                    var lane4 = sheetObj.CellValue(2,"lane4");

                    var cnt = sheetObjects[0].RowCount;

                    if(!validateCond()){    //MENDATORY 항목 체크
                       return false;
                    }

                    if(!port3 == ""){
                        n_ts_route = "(" + lane1 + ")-" + port1 + "-(" + lane2 + ")-" + port2 + "-(" + lane3 + ")-" + port3 + "-(" + lane4 + ")";
                    } else if(!port2 == ""){
                        n_ts_route = "(" + lane1 + ")-" + port1 + "-(" + lane2 + ")-" + port2 + "-(" + lane3 + ")";
                    } else if(!port1 == "")  {
                        n_ts_route = "(" + lane1+ ")-" + port1 + "-(" + lane2 + ")";
                    } else  {
                        n_ts_route = "(" + lane1 + ")" ;
                    }

                    for(i=2;i<l;i++){
                        if(n_ts_route == sheetobj2.CellValue(i, "ts_route")){
                            ComShowMessage(ComGetMsg('MAS10042'));
                            exist_flg = "Y";
                        }
                    }
                   //부모 sheet에 존재하는 ts route가 아닐 경우에만 값을 입력받는다.
                   if(exist_flg == "Y"){
                        window.close();
                        break;
                   } else if(exist_flg == "N"){
                        /*sheet setting*/
                        //부모 Sheet의 마지막행 추가
                        sheetobj2.DataInsert(-1);

                        var k = sheetobj2.LastRow;

                        //POL, T/S Route, POD 셋팅
                        sheetobj2.CellValue2(k, "pol") = sheetObj.CellValue(2,"n_pol");
                        if(!port3 == ""){  //TS Route
                            sheetobj2.CellValue2(k, "ts_route") = "(" + lane1 + ")-" + port1 + "-(" + lane2 + ")-" + port2 + "-(" + lane3 + ")-" + port3 + "-(" + lane4 + ")";
                        } else if(!port2 == ""){
                            sheetobj2.CellValue2(k, "ts_route") = "(" + lane1 + ")-" + port1 + "-(" + lane2 + ")-" + port2 + "-(" + lane3 + ")";
                        } else if(!port1 == "")  {
                            sheetobj2.CellValue2(k, "ts_route") = "(" + lane1+ ")-" + port1 + "-(" + lane2 + ")";
                        } else  {sheetobj2.CellValue2(k, "ts_route") = "(" + lane1 + ")" ;
                        }
                        sheetobj2.CellValue2(k, "pod") = sheetObj.CellValue(2,"n_pod");

                        /*화면 setting*/
                        //Hidden
                        formObj2.f_n_pol.value = sheetObj.CellValue(2,"n_pol");
                        formObj2.f_lane1.value = sheetObj.CellValue(2,"lane1");
                        formObj2.f_port1.value = sheetObj.CellValue(2,"port1");
                        formObj2.f_lane2.value = sheetObj.CellValue(2,"lane2");
                        formObj2.f_port2.value = sheetObj.CellValue(2,"port2");
                        formObj2.f_lane3.value = sheetObj.CellValue(2,"lane3");
                        formObj2.f_port3.value = sheetObj.CellValue(2,"port3");
                        formObj2.f_lane4.value = sheetObj.CellValue(2,"lane4");
                        formObj2.f_n_pod.value = sheetObj.CellValue(2,"n_pod");

                        //pc generation 일 경우 pod는 mendatory 항목임.
                        formObj2.f_pod_cd.value = sheetObj.CellValue(2,"n_pod");

                        sheetObj.SelectRow = 0;
                        window.close();
                        break;
                   }
            }
        }

         /**
         * 필수항목 누락여부 체크
         */
        function validateCond(){
            var sheetObj = sheetObjects[0];

            //POL, 1st Lane, POD Mendatory 항목
            if(sheetObj.cellText(2,"n_pol")== ""){
                ComShowMessage(ComGetMsg('MAS10002','POL'));
                return false;
            } else if(sheetObj.cellText(2,"lane1")== ""){
                ComShowMessage(ComGetMsg('MAS10002','1st Lane'));
                return false;
            } else if(sheetObj.cellText(2,"n_pod")== ""){
                ComShowMessage(ComGetMsg('MAS10002','POD'));
                return false;
            }

           //PORT만 입력되고 LANE이 입력되지 않은경우 체크
           if(!sheetObj.cellText(2,"port3") == "" ){
               for(i=2;i<8;i++){
                   if(sheetObj.cellText(2,i) == ""){
                     ComShowMessage(ComGetMsg('MAS10041'));
                     return false;
                   }
               }
           } else if(!sheetObj.cellText(2,"port2") == "" ){
               for(i=2;i<6;i++){
                   if(sheetObj.cellText(2,i) == ""){
                     ComShowMessage(ComGetMsg('MAS10041'));
                     return false;
                   }
               }
           } else if(!sheetObj.cellText(2,"port1") == "" ){
               for(i=2;i<4;i++){
                   if(sheetObj.cellText(2,i) == ""){
                     ComShowMessage(ComGetMsg('MAS10041'));
                     return false;
                   }
               }
           }
           return true;
        }
	/* 개발자 작업  끝 */