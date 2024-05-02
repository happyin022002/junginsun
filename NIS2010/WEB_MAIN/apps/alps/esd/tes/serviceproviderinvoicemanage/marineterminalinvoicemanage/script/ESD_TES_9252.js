 /*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9252.js
*@FileTitle : TES 3rd Party Billing Input Popup화면-Marine Terminal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-11-23 kimjinjoo
* 1.0 최초 생성
=========================================================*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var doneDefN3ptyBilCSCD = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
         	    case "btn_close":
    	            window.close();
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
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
        var sheetObject = sheetObjects[0];
        var formObj = document.form;
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
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(12, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "Seq|Container No.|Billing Case|Curr.|Amount|3rd Party|3rd Party|Remark";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtSeq		 ,     30,    daCenter,  false,   ""   );
                    InitDataProperty(0, cnt++, dtData		 ,    100,    daCenter,  false,   "cntr_no"			 ,       false,           "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		 ,    120,    daCenter,  false,   "n3pty_bil_tp_nm"	 ,       false,           "",       dfNone,    0,     true ,       true);
					InitDataProperty(0, cnt++, dtData		 ,    50,    daCenter,  false,   "curr_cd"			 ,       false,           "",       dfNone,    0,     false,       false);
                    //if(document.form.curr_cd.value == 'KRW' || document.form.curr_cd.value == 'JPY'){
					if (tes_isNoDecimalPointCurrCD(document.form.curr_cd.value)) {
                        InitDataProperty(0, cnt++, dtData    ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfInteger,  0,     true ,       true);
                    }else{
                        InitDataProperty(0, cnt++, dtData	 ,     60,    daRight ,  false,   "if_amt"			 ,       false,          "",      dfFloat,    2,     true ,       true);
                    }
                    InitDataProperty(0, cnt++, dtCombo		 ,     80,    daCenter,  false,   "vndr_cust_div_cd" ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtPopup		 ,    100,    daCenter,  false,   "pop_value"		 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtData		 ,    180,    daCenter,  false,   "if_rmk"			 ,       false,          "",       dfNone,    0,     true ,       true);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "vndr_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "n3pty_vndr_seq"   ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_cnt_cd"      ,       false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		 ,     90,    daCenter,  true ,   "cust_seq"      	 ,       false,          "",       dfNone,    0,     false,       false);

                    InitComboNoMatchText(true);

					InitDataCombo (0, "vndr_cust_div_cd", combo01Text, combo01Code);

               }
                break;
        }
    }


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction){
            case IBSEARCH:
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9252GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;
        }
    }


    function sheet_OnSearchEnd(sheetObj){
        var sheetObj = sheetObjects[0];

        for(var i=1; i<1+sheetObj.RowCount; i++){
            if(sheetObj.CellValue(i,'vndr_cust_div_cd') == ''){
                sheetObj.CellValue(i,'vndr_cust_div_cd')='C';
    	    }else if(sheetObj.CellValue(i,'vndr_cust_div_cd') == 'C'){
    	        sheetObj.CellValue(i,"pop_value") = sheetObj.CellValue(i,"cust_cnt_cd") + sheetObj.CellValue(i,"cust_seq");
    	    }else if(sheetObj.CellValue(i,'vndr_cust_div_cd') == 'S'){
    	        sheetObj.CellValue(i,"pop_value") = sheetObj.CellValue(i,"n3pty_ofc_cd");
    	    }else if(sheetObj.CellValue(i,'vndr_cust_div_cd') == 'V'){
    	        sheetObj.CellValue(i,"pop_value") = sheetObj.CellValue(i,"vndr_cnt_cd") + sheetObj.CellValue(i,"n3pty_vndr_seq");
    	    }
        }
    }