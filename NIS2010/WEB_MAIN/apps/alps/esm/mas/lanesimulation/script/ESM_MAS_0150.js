/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_MAS_0150.js
*@FileTitle     : LaneSimulation >> Step1 >> Continent_pair (popup)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.24
*@LastModifier  : 이연각
*@LastVersion   : 1.1
* 2006-08-28 eunju park
* 1.0 최초 생성
* =======================================================
* History
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
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
                
                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
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
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
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
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msPrevColumnMerge;                             //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(12, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle = "DEL|STS|R.Lane|Bound|IOC|From Conti|To Conti|Trade|Sub Trade|S.Lane||";
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        //데이터속성[ ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,    SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtDelCheck, 30,     daCenter,   false,      "delflag",           false,      "",        dfNone,      0,    true,       true);
                    InitDataProperty(0,     cnt++,  dtStatus,   30,     daCenter,   false,      "ibflag",            false,      "",        dfNone,      0,    false,      false);
                    InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,       "rlane_cd",          true,       "",        dfEngUpKey,  0,    false,      true,    5, true);
                    InitDataProperty(0,     cnt++,  dtCombo,    60,     daCenter,   true,       "skd_dir_cd",        true,       "",        dfNone,      0,    false,      true);
                    InitDataProperty(0,     cnt++,  dtCombo,    40,     daCenter,   true,       "ioc_cd",            true,       "",        dfNone,      0,    false,      true);
                    InitDataProperty(0,     cnt++,  dtCombo,    80,     daCenter,   true,       "fm_conti_cd",       true,       "",        dfNone,      0,    true,       true);
                    InitDataProperty(0,     cnt++,  dtCombo,    80,     daCenter,   true,       "to_conti_cd",       true,       "",        dfNone,      0,    true,       true);
                    InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,       "trd_cd",            false,      "",        dfNone,      0,    false,      true);
                    InitDataProperty(0,     cnt++,  dtData,     70,     daCenter,   true,       "sub_trd_cd",        false,      "",        dfNone,      0,    false,      true);
                    InitDataProperty(0,     cnt++,  dtData,     60,     daCenter,   true,       "slan_cd",         false,      "",        dfNone,      0,    false,      false);
                    InitDataProperty(0,     cnt++,  dtHidden,   60,     daCenter,   true,       "org_fm_conti_cd",   false,      "",        dfNone,      0,    false,      false);
                    InitDataProperty(0,     cnt++,  dtHidden,   60,     daCenter,   true,       "org_to_conti_cd",   false,      "",        dfNone,      0,    false,      false);
                    
                    CountPosition  = 0 ;
                    
                    style.height = GetSheetHeight(14) ;
					InitDataCombo(0, "fm_conti_cd", " |ASIA|EUROPE|AFRICA|AMERICA", " |A|E|F|M");
					InitDataCombo(0, "to_conti_cd", " |ASIA|EUROPE|AFRICA|AMERICA", " |A|E|F|M");
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0150GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComMasSetIBCombo(sheetObj, arrXml[0], "skd_dir_cd", true, 0);
				if (arrXml.length > 1)
					ComMasSetIBCombo(sheetObj, arrXml[1], "ioc_cd", true, 0);
				ComOpenWait(false);
				break;    
            case IBSEARCH:      /*조회*/
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                formObj.slan_cd.value = formObj.f_slan_cd.value;
                formObj.sim_no.value = formObj.f_sim_no.value;
                formObj.sim_dt.value = formObj.f_sim_dt.value;
                formObj.dept_cd.value = formObj.f_dept_cd.value;
                formObj.usr_id.value = formObj.f_usr_id.value;
                sheetObj.DoSearch("ESM_MAS_0150GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;
            
            case IBSAVE:        /*저장*/
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;   
                formObj.slan_cd.value = formObj.f_slan_cd.value;
                formObj.sim_no.value = formObj.f_sim_no.value;
                formObj.sim_dt.value = formObj.f_sim_dt.value;
                formObj.dept_cd.value = formObj.f_dept_cd.valu
                formObj.usr_id.value = formObj.f_usr_id.value;
                sheetObj.DoSave("ESM_MAS_0150GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;
            
            case IBINSERT:      /* 입력*/
                sheetObj.DataCopy();
                sheetObj.CellValue2(sheetObj.SelectRow,"fm_conti_cd") = "";
                sheetObj.CellValue2(sheetObj.SelectRow,"to_conti_cd") = "";
                break;

        }
    }
    
    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        
    }
    
    


