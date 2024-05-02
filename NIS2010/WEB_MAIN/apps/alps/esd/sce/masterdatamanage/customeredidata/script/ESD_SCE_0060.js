
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var selRow = 0;

var isFirst1 = 0;
var isFirst2 = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	var srcName = window.event.srcElement.getAttribute("name");
    	switch(srcName) {
    		case 'btn_close':
        	    	self.close();
        	    	break;
    	}
    }

    function toUpperCase(str_){
        str="";
        for(i=0;i<str_.length;i++){
            str+=str_.charAt(i).toUpperCase(); //소문자는 대문자로
        }  
        return str;      
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

//        doActionIBSheet0(sheetObjects[0],document.form,IBSEARCH);
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:     //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(12) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, false);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //20071105 History: var HeadTitle = "ACTIVITY Code|EDI STS|SEQ|EST.DATE|EVENT DATE|Location|EDI PROCESS DATE|RESULT|COP|MAN|Updated by";
                    //20071105 History: var HeadTitle = "ACTIVITY Code|EDI STS|CUST STS|SEQ|EST.DATE|EVENT DATE|Location|EDI PROCESS DATE|RESULT|COP|MAN|Updated by";
                    var HeadTitle = "ACTIVITY Code|EDI STS|CUST STS|SEQ|EST.DATE|EVENT DATE|Location|EDI DATE(KST)|EDI DATE(LCL)|RESULT|COP|MAN|Updated by";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtSeq,       40,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
//                    InitDataProperty(0, cnt++,  dtDelCheck,  30,   daCenter,  true,    "");

                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,   "act_cd",     	 false,          "",      dfNone,      0,     true,       true,          30);                           
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,   "edi_sts",     	 false,          "",      dfNone,      0,     true,       true,          30);       
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,   "edi_sub_sts_cd",  false,          "",      dfNone,      0,     true,       true,          30);       
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,   "seq",             false,          "",      dfNone,      0,     true,       true,          30); 
                    InitDataProperty(0, cnt++ , dtData,     	120,   daCenter,  false,  "estm_dt",         false,          "",      dfNone,      0,     true,       true,          30);        
                    InitDataProperty(0, cnt++ , dtData,     	120,   daCenter,  false,  "event_dt",        false,          "",      dfNone,      0,     true,       true,          30);        
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,   "nod_cd",          false,          "",      dfNone,      0,     true,       true,          30);      
                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,   "event_date",      false,          "",      dfNone,      0,     true,       true,          30);          
                    InitDataProperty(0, cnt++ , dtData,         120,   daCenter,  true,   "edi_lcl_dt",      false,          "",      dfNone,      0,     true,       true,          30);          
                    InitDataProperty(0, cnt++ , dtData,         65,    daCenter,  true,   "edi_snd_rmk",     false,          "",      dfNone,      0,     true,       true,          30);          
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,   "snd_tp1",         false,          "",      dfNone,      0,     true,       true,          30);          
                    InitDataProperty(0, cnt++ , dtData,         50,    daCenter,  true,   "snd_tp2",         false,          "",      dfNone,      0,     true,       true,          30);          
                    InitDataProperty(0, cnt++ , dtData,         100,   daCenter,  true,   "upd_id",          false,          "",      dfNone,      0,     true,       true,          30);
 
              }
                break;

        }
      // setTempInit(); 
        
    }
// Sheet관련 프로세스 처리
    function doActionIBSheet0(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      //조회           
		        formObj.f_cmd.value = SEARCH01;
			    sheetObj.DoSearch4Post("ESD_SCE_0060GS.do", SceFrmQryString(formObj));
                break;
        }
    }

	
	
	
