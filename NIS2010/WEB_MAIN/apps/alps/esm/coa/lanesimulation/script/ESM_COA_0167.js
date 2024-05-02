/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_COA_0167.js
*@FileTitle     : LaneSimulation >> Step3 >> Tap4 TC/O Hire Table(popup)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.24
*@LastModifier  : 이연각
*@LastVersion   : 1.0
* 2009-02 eunju park
* 1.0 최초 생성
* =======================================================
* History : 
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.09 시트의 상태값 변경하기 JS 가이드 적용 cellvalue -> rowstatus
========================================================= */
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
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj) {
        var cnt = 0;

        with (sheetObj) {
            SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
            MergeSheet = msHeaderOnly;                             //전체Merge 종류 [선택, Default msNone]
            Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
            InitRowInfo( 2, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitColumnInfo(7, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다

            var HeadTitle0 = "STS|Del|Vessel Capa.\n(from~)|TC/O Revenue|TC/O Revenue||SEQ|MIN SEQ";
            var HeadTitle1 = "STS|Del|Vessel Capa.\n(from~)|Per TEU|Per Day||SEQ|MIN SEQ";
 
                    InitHeadRow(0, HeadTitle0, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(1, HeadTitle1, true); 
            
            //데이터속성[         ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
            InitDataProperty(0, cnt++, dtStatus,    30, daCenter, true,  "ibflag",         false, "", dfNone,   0, false, false);
            InitDataProperty(0, cnt++, dtDelCheck,  30, daCenter, true,  "del_chk",        false, "", dfNone);
            InitDataProperty(0, cnt++, dtData,      80, daCenter, true,  "vsl_clss_capa",  false, "", dfNumber, 0, false, true);
            InitDataProperty(0, cnt++, dtData,     100, daRight,  false, "vsl_teu_uc_amt", false, "", dfNumber, 0, true,  true);
            InitDataProperty(0, cnt++, dtData,     100, daRight,  false, "vsl_dly_uc_amt", false, "", dfNumber, 0, true,  true);
            InitDataProperty(0, cnt++, dtHidden,   100, daRight,  false, "to_hir_seq",     false, "", dfNumber, 0, true,  true);
            InitDataProperty(0, cnt++, dtHidden,   100, daRight,  false, "min_seq",        false, "", dfNumber, 0, true,  true);
            
            CountPosition  = 0 ;
            style.height = GetSheetHeight(10) ;
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
                sheetObj.DoSearch4Post("ESM_COA_0167GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            
            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                sheetObj.DoAllSave("ESM_COA_0167GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
                
            case IBINSERT:        //저장
                sheetObj.DataInsert();
                break;
                

        }
    }
    
    var chkFlag;
    /**
     * Click event 시의 ibflag를 체크한다.
     */
    function sheet1_OnClick(sheetObj, row, col, value){
        //chkFlag = sheetObj.CellValue(row,"ibflag");
        chkFlag = sheetObj.RowStatus(row);
    }
    
    /**
     * 이전 컬럼의 상태를 변경시켜 준다.
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        // Row 의  from vessel class 가 변경되면 이전 Row의 to vessel class 도 변경되어야 
        // 하기 때문에 이전 Row의 상태를 Update로 변경한다.
        if(row > 1 && chkFlag != "I" &&
           (
            sheetObj.SaveNameCol("del_chk")== col  ||
            sheetObj.SaveNameCol("vsl_clss_capa")== col  ||
            sheetObj.SaveNameCol("vsl_teu_uc_amt")== col ||
            sheetObj.SaveNameCol("vsl_dly_uc_amt")== col
           )){
            // 이전 Row의 상타가 D/U/I 일경우는 상태를 변경시키지 않는다.
            //if(sheetObj.CellValue(row-1,"ibflag")== "R") sheetObj.CellValue2(row-1, "ibflag") = "U";
            if(sheetObj.RowStatus(row-1)== "R") sheetObj.RowStatus(row-1) = "U";
        }
    }

    
    


