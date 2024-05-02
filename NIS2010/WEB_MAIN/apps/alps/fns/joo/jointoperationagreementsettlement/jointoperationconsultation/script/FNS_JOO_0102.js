/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0102.js
*@FileTitle : 기 정산된 데이타가 존재하는 경우 Double Click시 History 조회 POP UP화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2015.02.09 이영두
* 1.0 Creation
=========================================================*/

    /**
    * @extends 
    * @class FNS_JOO_0102 : FNS_JOO_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function FNS_JOO_0102() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
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
                case "btn_Downexcel":
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
    	var formObject = document.form;
    	
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
                    style.height = 250;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 10, 100);

                    var HeadTitle1 = "CSR NO|TEU|Slot Price|Amount";
                    var headCount = ComCountHeadTitle(HeadTitle1);                    

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false);

                    CountPosition = 0;  //페이지카운트 없애기

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //sheetObj.FrozenCols = 5; 
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtData,         160,    daCenter,	    true,  "csr_no",          false,  "", dfNone);
                    InitDataProperty(0, cnt++ , dtData,          50,    daRight,      	true,  "e_bsa_qty",        false,  "", dfInteger);
                    InitDataProperty(0, cnt++ , dtData,          80,    daRight,   		true,  "e_bsa_slt_prc",    false,  "", dfNullFloat ,2);
                    InitDataProperty(0, cnt++ , dtData,          50,    daRight,        true,  "e_stl_locl_amt",   false,  "", dfNullFloat ,2);
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

				var sXml = sheetObjects[0].GetSearchXml("FNS_JOO_0102GS.do", FormQueryString(formObj));
                sheetObjects[0].LoadSearchXml(sXml);

            	ComOpenWait(false);             	
                break;
            case IBDOWNEXCEL:      // 엑셀다운로드
              sheetObj.SpeedDown2Excel(true);
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
        sheetObj.SelectHighLight = false;
     }
     
     /**
      * 셀을 클릭했을때 발생하는 이벤트
      * 선택시 선택행 배경색 세팅
      */
     function sheet1_OnClick(sheetObj, row, col, value) {
      	sheetObj.SelectHighLight = true;
     }	     