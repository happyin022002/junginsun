/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_COA_0165.js
*@FileTitle     : LaneSimulation >> Step1 >> File_Mgmt(popup)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.22
*@LastModifier  : 이연각
*@LastVersion   : 1.0
* 2006-08-28 eunju park
* 1.0 최초 생성
* =======================================================
* History
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.14 CHM-200901719 윤진영 UI표준처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - showErrMessage -> ComShowMessage로 수정
========================================================= */
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
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
    function loadPage(slan_cd, simCode) {
    	loadingMode = true;
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        loadingMode = false;
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
            MergeSheet = msPrevColumnMerge;                             //전체Merge 종류 [선택, Default msNone]
            Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
            InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitColumnInfo(8, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다

            FitColWidth("") ;
            Rows = 30;


            var HeadTitle0 = "S.Lane|Simulation No|STS|Del|report No|remark";

            InitHeadRow(0, HeadTitle0, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

            //데이터속성[    ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
            InitDataProperty(0,     cnt++,  dtData,     50,     daCenter,   true,      "slan_cd",        false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtData,    180,     daCenter,   true,      "Simulation",   false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtStatus,   30,     daCenter,   false,     "ibflag",       false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtDelCheck, 30,     daCenter,   false,     "Del",          false,      "",        dfNone,    0,          true,      true);
            InitDataProperty(0,     cnt++,  dtData,     70,     daCenter,   true,      "report",       false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtData,    150,       daLeft,   true,      "remark",       false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtHidden,    0,     daCenter,   false,     "sim_dt",        false,      "",        dfNone,    0,          false,     false);
            InitDataProperty(0,     cnt++,  dtHidden,    0,     daCenter,   false,     "sim_no",        false,      "",        dfNone,    0,          false,     false);

            CountPosition  = 0 ;
            style.height = GetSheetHeight(12) ;
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

				var sXml = sheetObj.GetSearchXml("ESM_COA_0165GS2.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_slan_cd, "code", "name");
				ComSetObjValue(formObj.f_slan_cd,ComGetObjValue(formObj.tmp_slan_cd));
				ComOpenWait(false);
				break;
        	case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                formObj.f_slan_cd.code = formObj.tmp_slan_cd.value;
                sheetObj.DoSearch("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                formObj.f_cmd.value = MULTI01;

                    var sheetObj1 = sheetObjects[0];

                    /*var lastRow = sheetObj1.LastRow;
                    var cnt;

                    for(var i = 1; i < lastRow+1; i++){
                         cnt = sheetObj1.CellValue(i, "Del");

                         if(cnt == 1){
                             rp = sheetObj1.CellValue(i, "report").substring(2, 5);
                             if(rp == "001"){
                             }
                             sim_dt = sheetObj1.CellValue(i, "sim_dt");
                             sim_no = sheetObj1.CellValue(i, "sim_no");

                         }
                    }*/

                    var iCheckRow = sheetObj1.FindCheckedRow("Del");
                    var arrRow = iCheckRow.split("|");
                    var sim_dt = "";;
                    var sim_no = "";
                    var reportNo = "";
                    var saVar = "0";
                    var vaVar = "0";

                    for (idx=0; idx<arrRow.length-1; idx++){

                        sim_dt    += sheetObj1.CellValue(arrRow[idx], "sim_dt")+"|";
                        sim_no    += sheetObj1.CellValue(arrRow[idx], "sim_no")+"|";
                        reportNo += sheetObj1.CellValue(arrRow[idx], "report")+"|";

                        if(sheetObj1.CellValue(arrRow[idx], "report").substring(2, 5) == "001"){
                            saVar = "1";
                        }else{
                            vaVar = "1";
                        }
                    }

                    if(saVar == "1" && vaVar == "0"){
                        if ( confirm("If 001 report is deleted, related simulations will be deleted. Will you proceed?") ) {
                        	// 업무처리중 버튼사용 금지 처리
                        	sheetObj.WaitImageVisible = false;
                        	ComOpenWait(true);
                            sheetObj.DoSave("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                            formObj.f_cmd.value = SEARCH;
                            sheetObj.DoSearch4Post("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                            ComOpenWait(false);
                        }
                    }else if(saVar == "1" && vaVar == "1"){
                        if ( confirm("If 001 report is deleted, related simulations will be deleted. Will you proceed?") ) {
                            if ( confirm("When report deleted, cannot be restored. Will you proceed?") ) {
                            	// 업무처리중 버튼사용 금지 처리
                            	sheetObj.WaitImageVisible = false;
                            	ComOpenWait(true);
                                sheetObj.DoSave("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                                formObj.f_cmd.value = SEARCH;
                                sheetObj.DoSearch4Post("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                                ComOpenWait(false);
                            }
                        }
                    }else if(saVar == "0" && vaVar == "1"){
                            if ( confirm("When report deleted, cannot be restored. Will you proceed?") ) {
                            	// 업무처리중 버튼사용 금지 처리
                            	sheetObj.WaitImageVisible = false;
                            	ComOpenWait(true);
                                sheetObj.DoSave("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                                formObj.f_cmd.value = SEARCH;
                                sheetObj.DoSearch4Post("ESM_COA_0165GS.do", coaFormQueryString(formObj));
                                ComOpenWait(false);
                            }
                    }



                break;

        }
    }

     /**
     * slan_cd 데이터 변경시 Simulation Number combo box를 다시 세팅한다.
     */
    function f_slan_cd_OnChange(cboObj, value, text){
        var formObj = document.form;
        text = text.toUpperCase();
        //formObj.slan_cd.value = value;

        formObj.f_slan_cd.value = value;

        if(value != "" ) { // S.Lane
            chgslan_cd(formObj.f_slan_cd);
        } else{// S.Lane
        //1개의 Item을 맨 아래 위치에 추가한다. 추가된 행의 Index를 반환하고, 실패하면 -1을 반환한다.
            cboObj.InsertItem(-1,text,text);
            cboObj.Code = text;
        }
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
 		with (comboObj) {
 			DropHeight = 300;
 			Index = 0;
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }



