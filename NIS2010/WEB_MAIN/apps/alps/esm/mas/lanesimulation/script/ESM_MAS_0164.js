/* =========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName      : ESM_MAS_0164.js
*@FileTitle     : LaneSimulation >> Step1 >> Non Operating Expense (POPUP)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.24
*@LastModifier  : 이연각
*@LastVersion   : 1.1
* 2010-01-12 jin-young Yoon
* 1.0 최초 생성
* =======================================================
* History
* 2010.01.12 윤진영 최초 개발
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.14 CHM-200901719 윤진영 UI표준처리
========================================================= */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                
                case "btn_save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                
                case "btn_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
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
            //khlee-시작 환경 설정 함수 이름 변경
        	ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        document.form.f_cost_yrmon.value = userGetYYYYMM("-");
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        document.form.f_cost_yrmon.focus();
        document.form.f_cost_yrmon.blur();
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        with (sheetObj) {
            SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
            MergeSheet = msHeaderOnly;                                  //전체Merge 종류 [선택, Default msNone]
            Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
            InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitColumnInfo(5, 0 , 0, true);                             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitHeadMode(false, false, false, true, false,false) ;      //해더에서 처리할 수 있는 각종 기능을 설정한다

            var HeadTitle0 = "DEL|STS|Vessel|Unit Cost/day";
 
            InitHeadRow(0, HeadTitle0, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            
            //데이터속성[         ROW,     COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
            InitDataProperty(     0,       cnt++,  dtDelCheck, 30,      daCenter,   false,     "delflag",        false,      "",        dfNone,       0,         true,       true);
            InitDataProperty(     0,       cnt++,  dtStatus,   30,      daCenter,   false,     "ibflag",         false,      "",        dfNone,       0,         false,      false);
            InitDataProperty(     0,       cnt++,  dtData,     120,     daCenter,   false,     "vsl_cd",         true,       "",        dfEngUpKey,   0,         false,      true,       4,     true);
            InitDataProperty(     0,       cnt++,  dtData,     120,     daRight,    false,     "uc_amt",         true,       "",        dfNumber,     0,         true,       true);
            InitDataProperty(     0,       cnt++,  dtHidden,     0,     daRight,    false,     "cost_yrmon",     true,       "",        dfNumber,     0,         true,       true);
            CountPosition  = 0 ;
            style.height = GetSheetHeight(15) ;
        }
    }
    
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                formObj.f_cost_yrmon.value = formObj.f_cost_yrmon.value.replace("-","");
                if(formObj.f_cost_yrmon.value != "") {
                    sheetObj.DoSearch4Post("ESM_MAS_0164GS.do", masFormQueryString(formObj));
                }
                ComOpenWait(false);
                break;
            
            case IBSAVE:        //저장
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                for(i=1; i<=sheetObj.LastRow; i++){       
                    sheetObj.CellValue(i,"cost_yrmon") = formObj.f_cost_yrmon.value.replace("-","");
                }
                sheetObj.DoSave("ESM_MAS_0164GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;
		   
            case IBINSERT:      //입력
                sheetObj.DataInsert();
                break;
			
        }
        document.form.f_cost_yrmon.focus();
        //document.form.f_cost_yrmon.blur();
    }

   function userGetYYYYMM(delim){
      var current_date = new Date();
      var year = current_date.getFullYear().toString();
      var month = current_date.getMonth() + 1;
      month = (month < 10 ? "0" : "") + month;
      if(delim == null) delim = "";
      return year + delim + month;
   }    

