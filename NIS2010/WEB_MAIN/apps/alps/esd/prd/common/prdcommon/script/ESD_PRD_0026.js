// 공통전역변수 
var ipageNo =1 ;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
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

         	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

       	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

       	    case "btn_ok":
                    popupOK(sheetObject);
        	        break;

       	    case "btn_close":
    	            self.close();
        	        break;

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert(ComGetMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    function popupOK(sheetObject) {
          var openerSheet = window.opener.document.sheet1 ;
          if(sheetObject.CheckedRows("radio")>0) {
                var iRow = openerSheet.SelectRow;
                var iCheckRow = sheetObject.FindCheckedRow("radio");
                
                var arrRow = iCheckRow.split("|");
                var insertRow = arrRow[0];
                openerSheet.CellValue2( iRow, "vndr_seq"        ) = sheetObject.CellValue( insertRow , "vndr_seq") ;
                openerSheet.CellValue2( iRow, "vndr_name"        ) = sheetObject.CellValue( insertRow , "vndr_lgl_eng_nm") ;
           }
          window.close();            
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
        // 초기화면에서 조회내용을 보기 위한 소스 추후 삭제
         var sheetObject = sheetObjects[0];
         var formObject = document.form;
      	 doActionIBSheet(sheetObject,formObject,IBSEARCH);

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
                    style.height = GetSheetHeight(10) ;
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
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle = "||Service Provider Code|Control Office|Service Provider Name" ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtRadioCheck,20,    daCenter,  false,    "radio",        false,          "",       dfNone,	    0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,  20,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);

                    InitDataProperty(0, cnt++ , dtData,     200,    daCenter,  false,    "vndr_seq",        false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     100,    daCenter,  false,    "ofc_cd",        false,          "",       dfNone,       0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,     200,    daCenter,  false,    "vndr_lgl_eng_nm",        false,          "",       dfNone,       0,     true,       true);

                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_abbr_nm",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "prnt_vndr_seq",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "vndr_cnt_cd",        false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtHidden,     0,    daCenter,  false,    "org_vndr_seq",        false,          "",       dfNone,       0,     false,       true);
                    
                    WaitImageVisible=false;
               }
                break;
        }
    }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction));
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;   
                selectVal = PrdFQString(formObj)
                sheetObj.DoSearch4Post("ESD_PRD_0026GS.do", selectVal); 
                formObj.ofc_cd.value = sheetObj.EtcData("ofc_cd");               
                ComOpenWait(false);	
                break;

           case IBSEARCHAPPEND:  // 페이징 조회
           		ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("ESD_PRD_0026GS.do", selectVal, "iPage=" + PageNo, true);  
                ComOpenWait(false);
           break;  

        }
    }

//    function sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
//        // TODO:sheet에 해당하는 객체와 폼 오브젝트를 doActionIBSheet 함수에 보내 주어야합니다.
//        doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
//    }   
    
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
