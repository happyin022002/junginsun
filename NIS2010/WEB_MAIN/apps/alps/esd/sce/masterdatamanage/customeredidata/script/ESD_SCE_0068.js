
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var selectVal;

var sheetObjects = new Array();
var sheetCnt = 0;

var selRow = 0;

var isFirst1 = 0;
var isFirst2 = 0;

var rowCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    function processButtonClick(){
        var formObject = document.form;
        var sheetObject0 = sheetObjects[0];
        var srcName = window.event.srcElement.getAttribute("name");
        var opener = window.dialogArguments;
        switch(srcName) {
            case "btn_ok":
                var chkcnt = sheetObject0.CheckedRows(0);
                if(chkcnt < 1){
                    ComShowMessage('Select check item');
    	    		return false;
                }
                /*값을 대입한다*/
                var chkrow = sheetObject0.FindCheckedRow(0).split('|')[0];
                var cs_grp_id = sheetObject0.CellValue(chkrow, "edi_grp_cd");
    	    	var tp_id = sheetObject0.CellValue(chkrow, "cust_trd_prnr_id");
    	    	var grp_nm = sheetObject0.CellValue(chkrow, "edi_grp_desc");
    	    	opener.openESD068Screen(cs_grp_id, tp_id, grp_nm);
    	    	self.close();
                break;
                
            case "btn_close":
                self.close();
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
    
    function loadPage(){
       for(i=0;i<sheetObjects.length;i++){
           //khlee-시작 환경 설정 함수 이름 변경
           ComConfigSheet (sheetObjects[i] );
           
           initSheet(sheetObjects[i]);
           
           //khlee-마지막 환경 설정 함수 추가
           ComEndConfigSheet(sheetObjects[i]);
       }
       var formObject = document.form;
       var sheetObject0 = sheetObjects[0];
       doActionIBSheet0(sheetObject0,formObject,IBSEARCH);
    }

/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj) {

        var cnt = 0;
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
            InitColumnInfo(4, 0, 0, false);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "|GroupId|EDI ID|Customer Name";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++ , dtSeq,       40,   daCenter,  true,    "",     false,          "",      dfNone,      0,     true,       true,          30);
//                    InitDataProperty(0, cnt++,  dtDelCheck,  30,   daCenter,  true,    "");
            
            InitDataProperty(0, cnt++ , dtRadioCheck,   30,    daCenter,  false,    "chk",              false,          "",       dfNone,   	0,     true,        true);//check box
            InitDataProperty(0, cnt++ , dtData,         110,    daCenter,  true,    "edi_grp_cd",     	false,          "",       dfNone ,      0,     true,       true,          30);       
            InitDataProperty(0, cnt++ , dtData,         110,    daCenter,  true,    "cust_trd_prnr_id", false,          "",      dfNone,      0,     true,       true,          30); 
            InitDataProperty(0, cnt++ , dtData,         120,    daLeft,  true,      "edi_grp_desc",     false,          "",      dfNone,      0,     true,       true,          30); 
            
        }
      // setTempInit(); 
    }
    
    function doActionIBSheet0(sheetObj,formObj,sAction){
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
             case IBSEARCH:
                    formObj.f_cmd.value = SEARCH01;  
                    selectVal = SceFrmQryString(formObj);
                    sheetObj.DoSearch4Post("ESD_SCE_0068GS.do", selectVal);
             break;          
        }
    }