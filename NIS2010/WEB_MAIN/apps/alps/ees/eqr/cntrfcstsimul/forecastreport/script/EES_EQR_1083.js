/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_EQR_1083.js
*@FileTitle : MTY Repo Other 과거실적 상세내역 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2015.01.14 신용찬
* 1.0 Creation 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
    /**
    * @extends 
    * @class EES_EQR_1083 : EES_EQR_1083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function EES_EQR_1083() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
//        this.validateForm           = validateForm;
    }
    
    // 공통전역변수
    var headCount = 0;
    var headCount2= 0;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var to_yd_cd  = ""; // yard cd 조회
    var to_yd_nm  = "";
    var to_etb_dt = "";  
    
    var IBSEARCH02  = 30;    

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
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);    	
        for(i=0;i<sheetObjects.length;i++){        
            ComConfigSheet (sheetObjects[i] );  //khlee-시작 환경 설정 함수 이름 변경
            initSheet(sheetObjects[i],i+1);        
            ComEndConfigSheet(sheetObjects[i]);  //khlee-마지막 환경 설정 함수 추가
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
            case "sheet2":      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 522;

                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);

                var HeadTitle = "Yard|Lease Term|Agreement No|Vendor Name|Evnt Date|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5|A5||||||";
                headCount2 = ComCountHeadTitle(HeadTitle);                    

                //div|lvl|cre_seq|rpt_seq|to_etb_dt_org|ibflag	
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount2, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                CountPosition = 0;  //페이지카운트 없애기

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                sheetObj.FrozenCols = 5;  
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, 		DATAALIGN, COLMERGE, SAVENAME,  	 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                //InitDataProperty(0, cnt++ , dtDummyCheck,	  30,	  daCenter,	  true,  "check"		  );
                InitDataProperty(0, cnt++ , dtData,           70,     daCenter,   true,  "to_yd_cd",         false,  "",        dfNone, 		0,		false,		true,	5);
                InitDataProperty(0, cnt++ , dtData,           75,     daCenter,   true,  "lstm_cd",  	     false,  "",        dfNone, 		0,		false,		false,	3);
                InitDataProperty(0, cnt++ , dtData,           95,     daCenter,   true,  "agmt_no",          false,  "",        dfNone, 		0,		false,		false,	9);
                InitDataProperty(0, cnt++ , dtData,          100,     daCenter,   true,  "vndr_abbr_nm",     false,  "",        dfDateYmd, 	    0,		false,		false);
                InitDataProperty(0, cnt++ , dtData,           80,     daCenter,   true,  "to_etb_dt",        false,  "",        dfDateYmd, 	    0,		false,		false);
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "d2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "d4_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   ); 
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "d5_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "d7_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "r2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "r5_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "r9_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "o2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "s2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "o4_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "s4_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "o5_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "f2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "a2_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "f4_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "a4_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "f5_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                InitDataProperty(0, cnt++ , dtAutoSumEx,      38,     daRight,    true,  "a5_fcast_qty",     false,  "",        dfNullInteger,  0,      false,      false   );
                //InitDataProperty(0, cnt++ , dtData,           500,    daLeft,     true,  "remark",           false,  "",        dfNone                 );
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "div",		         false,  "",        dfNone                   );
                InitDataProperty(0, cnt++ , dtHidden,         30,     daLeft,     true,  "lvl",              false,  "",        dfNone                   );
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "cre_seq",		     false,  "",        dfNone                   );
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "rpt_seq",		     false,  "",        dfNone                   );   
                InitDataProperty(0, cnt++ , dtHidden,	      30,	  daCenter,	  true,  "to_etb_dt_org",	 false,  "",        dfNone                   );    // update, delete 에 사용되는 정보                
                InitDataProperty(0, cnt++ , dtHiddenStatus,   30,     daCenter,   false, "ibflag"                                                        );                                         
           
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
                sheetObj.Redraw = false;
                
                var sXml = sheetObj.GetSearchXml("EES_EQR_1083GS.do",FormQueryString(formObj));
                sheetObjects[0].LoadSearchXml(sXml);

                ComOpenWait(false); 
                break;
                
    		case IBSEARCH02:      //공통조회
    			form.f_cmd.value = SEARCH02;
    			var sXml = sheetObj.GetSearchXml("EES_EQR_1083GS.do" , FormQueryString(form));

//    			to_yd_cd  = ComGetEtcData(sXml,"to_yd_cd");
//    			to_yd_nm  = ComGetEtcData(sXml,"to_yd_nm");
//    			to_etb_dt = ComGetEtcData(sXml,"to_etb_dt");

    			break;
    			
            case IBDOWNEXCEL:      // 입력

            	sheetObj.Down2Excel(0,false,true,true,'','',false,false,'',false,'div|lvl|cre_seq|rpt_seq|to_etb_dt_org|ibflag');

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
     function sheet2_OnSearchEnd(sheetObj, msg){	  
       if(sheetObj.RowCount==1) {
    	   sheetObj.RowDelete(sheetObj.LastRow-1, false);
    	   
       }else if(sheetObj.RowCount > 1) {
    	 sheetObj.RowDelete(sheetObj.LastRow-1, false);
  	  	 
  	  	 sheetObj.SetMergeCell (sheetObj.LastRow, 0, 1, 4);
  	  	 sheetObj.SumBackColor  = sheetObj.WebColor2SysColor("#D3EBED");
  	  	 sheetObj.SumFontBold = true;
    
  	   }
       sheetObj.SelectHighLight = false;
  	   sheetObj.Redraw = true;
 	   
     }

      
     /**
      * 셀을 클릭했을때 발생하는 이벤트 <br>
      * 선택시 선택행 배경색 세팅
      */
     function sheet2_OnClick(sheetObj, row, col, value) {
    	 if ( row == sheetObj.LastRow ) {
    		 sheetObj.SelectHighLight = false;
   			 sheetObj.RowBackColor(row) = -1;
    	 } else {
    		 sheetObj.SelectHighLight = true;
    	 }
    	   
     } 	
          

   	
	
  	