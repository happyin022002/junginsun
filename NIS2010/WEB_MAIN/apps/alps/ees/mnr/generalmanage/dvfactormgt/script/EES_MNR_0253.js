/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESS_MNR_0253.js
*@FileTitle : Container Seal No-Creation
*Open Issues :	Container Seal No-Creation 를 조회, 등록,수정,삭제하는 화면
*Change history :
*@LastModifyDate : 2012.10.26
*@LastModifier : 조경완
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2011.11.15 김상수 [CHM-201114606-01] 1.Sheet내의 Office입력을 수동입력 & POPUP입력 가능하게 수정
                                       2.Office입력하는 POPUP에서 기본 Parent Office에 default setting값 제거
                                       3.저장시 Validation에서 Serial Range 코드 3자리 제약 제거
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
* 2012.10.26 조경완 [CHM-201220518-01] ALPS MNR-CNTR SEAL Creation 시, Logic 검토 및 보완 요청
* 										1.CNTR SEAL Creation Data 조회시 입력한 그대로 보여줌
*										2. 생성시 자리수 체크
=========================================================*/
    /****************************************************************************************
                  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
     ***************************************************************************************/

    /*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

    /**
     * @extends
     * @class ees_mnr_0253 : ees_mnr_0253 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0253() {
        this.processButtonClick		= tprocessButtonClick;
        this.setSheetObject 		= setSheetObject;
        this.loadPage 				= loadPage;
        this.initSheet 				= initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet 		= doActionIBSheet;
        this.setTabObject 			= setTabObject;
        this.validateForm 			= validateForm;
    }

    /* 개발자 작업	*/

    //공통전역변수

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];

         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_New":
                    doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
                    break;

                case "btn_Retrieve":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
                    break;

                case "btn_Save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    break;

                case "btn_RowAdd":
                    doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
                    break;

                case "btn_delete":
                    if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
                        ComShowCodeMessage("MNR00038","DELETE ");
                        return false;
                    }
                    if(ComShowCodeConfirm("MNR00026")){
                        ComRowHideDelete(sheetObjects[0], "del_chk");
                    }
                    break;

                case "btn_DownExcel":
                    sheetObjects[0].SpeedDown2Excel(-1);
                    break;

                case  "btn_loadExcel":
                    doActionIBSheet(sheetObjects[0], formObject, IBLOADEXCEL);
                    break;

                case "btn_Format_DownExcel":
                    doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
                    break;

                case "btn_fryear": //calender button
                    var cal = new ComCalendar();
                    cal.setDisplayType('year');
                    cal.select(formObject.fr_year, 'yyyy');
                    break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
         ComOpenWait(true);
         initControl();
        for(i=0;i<sheetObjects.length;i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        ComOpenWait(false);
    }


  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                // 높이 설정
                style.height = 380;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet =  msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 19, 100);

                var HeadTitle1 = "||Seq|Office|Kind of Seal|Maker Code|Maker Name|Serial Range1|Serial Range1|Serial Range2|Serial Range2|Qty|Lost Qty|User Id||||||||";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                InitDataProperty(0, cnt++,  dtHiddenStatus,		0,		daCenter,	true,	"ibflag");
                InitDataProperty(0, cnt++,  dtCheckBox,       	30,     daCenter,   true,	"del_chk");

                InitDataProperty(0, cnt++,  dtDataSeq,	   		40,		daCenter,	true,	"Seq");
                InitDataValid(0, cnt, vtEngUpOther, "0123456789");

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,	cnt++,	dtPopupEdit,		100,	daLeft,		true,	"ofc_cd",				true,	"",	dfNone,			0,	true,	true, 6);
                InitDataProperty(0,	cnt++,	dtCombo,			100,	daLeft,		true,	"seal_knd_nm",			false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,				100,	daLeft,		true,	"vndr_seq",				true,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0,	cnt++,	dtPopup,			200,	daLeft,		true,	"vndr_nm",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,				40,		daCenter,	true,	"seal_no_pfx_nm",		false,	"",	dfNone,			0,	true,	true, 3);
                InitDataProperty(0,	cnt++,	dtData,		        80,		daLeft,		true,	"n1st_ser_rng_seal_no",	true,	"",	dfNone,			0,	true,	true, 10);
                InitDataProperty(0,	cnt++,	dtData,		        40,		daCenter,	true,	"seal_no_pfx_nm0",		false,	"",	dfNone,			0,	false,	false, 3);
                InitDataProperty(0,	cnt++,	dtData,		        80,		daLeft,		true,	"lst_ser_rng_seal_no",	true,	"",	dfNone,			0,	true,	true, 10);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"pln_qty",				false,	"",	dfNullInteger,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"cntr_seal_lost_qty",	false,	"",	dfNullInteger,	0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"cre_usr_id",			false,	"",	dfNone,			0,	false,	false);

                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daRight,	true,	"upd_chk",				false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daRight,	true,	"upd_chk2",				false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	"pln_yrmon",			false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	"pln_seq",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	"fr_year",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	"pln_month",			false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtHidden,		    100,	daLeft,		true,	"upd_dt",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0, cnt++,  dtHidden, 	  	    300,	daLeft,  	true,   "rmk",        			true,   "", dfNone,			0,	false,	false );

                InitDataCombo(0, "seal_knd_nm", "High Security|General|Barrier|Plastic", "S|G|B|P");
                ShowButtonImage = 2;

                InitDataValid(0, "ofc_cd", vtEngUpOnly);
                InitDataValid(0, "seal_no_pfx_nm", vtEngUpOnly);
                InitDataValid(0, "n1st_ser_rng_seal_no", vtNumericOnly);
                InitDataValid(0, "seal_no_pfx_nm0", vtEngUpOnly);
                InitDataValid(0, "lst_ser_rng_seal_no", vtNumericOnly);

                // 자동 트림하여 조회및 저장
                DataAutoTrim = true;
                WaitImageVisible = false;

            }
            break;

            case 2:      // sheet2 init
                with (sheetObj) {
                // 높이 설정
                style.height = 380;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet =  msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 9, 100);

                var HeadTitle1 = "|Sel|Seq|Office|Kind of Seal|Maker Code|Maker Name|Serial Range1|Serial Range1|Serial Range2|Serial Range2|Qty|Lost Qty|User Id";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, false, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++,  dtHiddenStatus,		0,		daCenter,	true,	"ibflag");
                InitDataProperty(0, cnt++,  dtCheckBox,       	30,     daCenter,   true,  	"del_chk");

                InitDataProperty(0, cnt++,  dtDataSeq,	   		40,		daCenter,	true,	"Seq");
                InitDataValid(0, cnt, vtEngUpOther, "0123456789");

                InitDataProperty(0,	cnt++,	dtPopup,			100,	daLeft,		true,	"ofc_cd",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,				100,	daLeft,		true,	"seal_knd_nm",			false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,				100,	daLeft,		true,	"vndr_seq",				false,	"",	dfNone,			0,	false,	false);
                InitDataProperty(0,	cnt++,	dtPopup,			200,	daLeft,		true,	"vndr_nm",				false,	"",	dfNone,			0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,				40,		daCenter,	true,	"seal_no_pfx_nm",		false,	"",	dfEngUpKey,		0,	true,	true, 3);
                InitDataProperty(0,	cnt++,	dtData,		        80,		daLeft,		true,	"n1st_ser_rng_seal_no",	false,	"",	dfNone,			0,	true,	true, 10);
                InitDataProperty(0,	cnt++,	dtData,		        40,		daCenter,	true,	"seal_no_pfx_nm0",		false,	"",	dfEngUpKey,		0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,		        80,		daLeft,		true,	"lst_ser_rng_seal_no",	false,	"",	dfNone,			0,	true,	true, 10);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"pln_qty",				false,	"",	dfNullInteger,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"cntr_seal_lost_qty",	false,	"",	dfNullInteger,	0,	true,	true);
                InitDataProperty(0,	cnt++,	dtData,		        100,	daRight,	true,	"cre_usr_id",			false,	"",	dfNone,			0,	false,	false);

                ShowButtonImage = 2;

                InitDataValid(0, "seal_no_pfx_nm", vtEngUpOnly);
                InitDataValid(0, "n1st_ser_rng_seal_no", vtNumericOnly);
                InitDataValid(0, "seal_no_pfx_nm0", vtEngUpOnly);
                InitDataValid(0, "lst_ser_rng_seal_no", vtNumericOnly);

                WaitImageVisible = false;

            }
            break;
        }
    }


    function initControl() {
        //Axon 이벤트 처리1. 이벤트catch
        var formObject = document.form;
        axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);            //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
        axon_event.addListenerFormat('focus',    'obj_activate',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerFormat('keypress', 'obj_keypress',    formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        axon_event.addListenerFormat('change',   'obj_change',      formObject);            //- 변경될때.
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }


    //Axon 이벤트 처리2. 이벤트처리함수
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }


    function obj_activate(){
        ComClearSeparator(event.srcElement);
    }


    function obj_change(){
        var obj      = event.srcElement;
        var formObj  = document.form;
        var sheetObj = sheetObjects[0];

        if (ComTrim(obj.value) != "") {
            switch(obj.name) {
            case "empty":
                break;
            }
        }
    }


    function obj_keypress(){
        obj = event.srcElement;
        keys = event.keyCode;
        if(obj.dataformat == null) return;
        window.defaultStatus = obj.dataformat;
        var formObj  = document.form;
        if (ComTrim(obj.value) != "") {
            switch(obj.name) {
            case "empty":
                break;
            }
        }
        switch(obj.dataformat) {

        case "int":
            ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet();
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        }
    }


  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBCLEAR:  //NEW
                MnrWaitControl(true);
                sheetObj.ColBackColor("mnr_cntc_prnr_nm") = sheetObj.RgbColor(240,240,240);
                sheetObjects[0].RemoveAll();
                formObj.fr_year.value = ComGetNowInfo("yy");
                MnrWaitControl(false);
                break;

            //조회
            case IBSEARCH:
                ComOpenWait(true);
                formObj.f_cmd.value = SEARCH;
                sheetObj.DoSearch4Post("EES_MNR_0253GS.do",FormQueryString(formObj));
                ComOpenWait(false);
                break;

            //저장
            case IBSAVE:
                ComOpenWait(true);
                if (!validateForm(sheetObj,formObj,sAction)) {
                    ComOpenWait(false);
                    return;
                }
                formObj.f_cmd.value = MULTI;
                var sParam = ComGetSaveString(sheetObj);
                sParam += ("&f_cmd=" + MULTI);
                var sXml = sheetObj.GetSaveXml("EES_MNR_0253GS.do", sParam);
                //저장XML 표현하기
                if (ComGetTotalRows(sXml) > 0) {
                    sheetObj.LoadSaveXml(sXml);
                    for (var t=sheetObj.HeaderRows; t<sheetObj.RowCount+1; t++){
                        sheetObj.CellBackColor(t, "seal_no_pfx_nm") = sheetObj.RgbColor(255, 0, 0)
                        sheetObj.CellBackColor(t, "n1st_ser_rng_seal_no") = sheetObj.RgbColor(255, 0, 0)
                        sheetObj.CellBackColor(t, "seal_no_pfx_nm0") = sheetObj.RgbColor(255, 0, 0)
                        sheetObj.CellBackColor(t, "lst_ser_rng_seal_no") = sheetObj.RgbColor(255, 0, 0)
                    }
                    ComOpenWait(false);
                    //정상 데이터 저장 후 비정상 데이터 화면에 조회결과만 리턴...확인 메세지
//                    ComShowCodeMessage("MNR00008","");
                    alert("Inputed SEAL No is existing  in ALPS Now");
                    return;

                } else {
                	ComOpenWait(false);
                    if (ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
						doActionIBSheet(sheetObj,document.form,IBSEARCH);
                    	ComShowCodeMessage("MNR00009", "Container Seal No-Creation");
					}
                }

                break;

            //입력
            case IBINSERT:
                var row = sheetObj.DataInsert(-1);
                sheetObjects[0].CellValue(sheetObjects[0].LastRow,"cntr_seal_lost_qty") = "0";
                sheetObjects[0].CellValue(sheetObjects[0].LastRow,"cre_usr_id") = formObj.userId.value;
                sheetObjects[0].CellValue(sheetObjects[0].LastRow,"pln_month") = formObj.pln_month.value;
                sheetObjects[0].CellValue(sheetObjects[0].LastRow,"fr_year") = formObj.fr_year.value;
                break;

            case IBLOADEXCEL:
                sheetObj.LoadExcel();
                for(var i=sheetObj.HeaderRows ;i<=sheetObj.LastRow;i++) {
                    sheetObj.CellValue(i, "pln_month") = formObj.pln_month.value;
                    sheetObj.CellValue(i, "fr_year") = formObj.fr_year.value;
                }
                break;

            case IBDOWNEXCEL:
                var cnt = sheetObj.RowCount;
                if(cnt <= 0){
                    var Row = sheetObj.DataInsert(-1);
                    sheetObj.CellValue(Row, "cre_usr_id") = formObj.userId.value;
                    sheetObj.CellValue(Row, "del_chk") = "";
                    sheetObj.CellValue(Row, "seal_knd_nm") = "";
                }
                sheetObj.SpeedDown2Excel(-1, false,false,"", "",false,false,"",false,"");
                if(cnt <= 0){
                    sheetObj.RemoveAll();
                }
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
        with(sheetObj){
            //1. Grid Main에 Row가 한개 이상인지에 대한 체크를 수행한다.
            if(RowCount < 1) {
                //ComShowCodeMessage("MNR00072");
                return false;
            }

            for(var i=HeaderRows; i<=LastRow; i++) {
                //ofc_cd 빈값에 대한 체크를 수행 한다.
                var ofc_cd = ComTrimAll(CellValue(i, "ofc_cd")," ");
                if (ofc_cd == "") {
                    ComShowCodeMessage("MNR00172","Office Name");
                    SelectCell(i, "ofc_cd",true);
                    return false;
                }

                var n1stSerRngSealNo = parseInt(Number(CellValue(i, "n1st_ser_rng_seal_no")), 10);
                var lstSerRngSealNo = parseInt(Number(CellValue(i, "lst_ser_rng_seal_no")), 10);
                //Serial Range 존재에 대한 체크를 수행 한다.
                if (n1stSerRngSealNo < 1) {
                    ComShowCodeMessage("MNR00172","Serial Range");
                    SelectCell(i, "n1st_ser_rng_seal_no", true);
                    return false;
                }
                //Serial Range 존재에 대한 체크를 수행 한다.
                if (lstSerRngSealNo < 1) {
                    ComShowCodeMessage("MNR00172","Serial Range");
                    SelectCell(i, "lst_ser_rng_seal_no", true);
                    return false;
                }
                
                if(CellValue(i, "n1st_ser_rng_seal_no").indexOf("0")==0){
                	if(CellValue(i, "n1st_ser_rng_seal_no").length != CellValue(i, "lst_ser_rng_seal_no").length){
                		alert("Serial Range should have the same digit");
                		SelectCell(i, "lst_ser_rng_seal_no", true);
                    	return false;
                	}
                }

                var plnQty = (lstSerRngSealNo - n1stSerRngSealNo + 1);
                CellValue(i, "pln_qty") = plnQty;
                if (plnQty < 1) {
                    ComShowCodeMessage("MNR00172","Qty");
                    SelectCell(i, "pln_qty", true);
                    return false;
                }
                CellValue(i, "pln_month") = formObj.pln_month.value;
                CellValue(i, "fr_year") = formObj.fr_year.value;
            }
            if(!ComShowCodeConfirm("MNR00160")){return false;} //저장의사 확인
        }
        return true;
    }


    /**
     * Lessor 검색 팝업
     * @param {Object} sheetObj
     * @param {Object} Row
     * @param {Object} Col
     * @param {Object} Value
     */
    function sheet1_OnPopupClick(sheetObj,row,col){
        if (sheetObj.ColSaveName(col) == "ofc_cd") {
            MnrWaitControl(true);
            ComOpenPopup('/hanjin/COM_ENS_071.do?ofc_pts_cd=ALL&row=' + row + '&col=' + col, 770, 450, 'getCOM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
            MnrWaitControl(false);
        } else if (sheetObj.ColSaveName(col) == "vndr_nm" || sheetObj.ColSaveName(col) == "vndr_seq") {
            MnrWaitControl(true);
            ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
            MnrWaitControl(false);
        }
    }


    /**
     * 조회 완료 후 이벤트
     * @param {Object} sheetObj
     * @param {Object} ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        var formObj = document.form;
        if(sheetObj.RowCount > 0) {
            sheetObj.ReDraw = false;
            for(var i=sheetObj.HeaderRows; i <= sheetObj.LastRow ; i++) {
                sheetObj.CellValue2(i, "pln_month") = formObj.pln_month.value;
                sheetObj.CellValue2(i, "fr_year") = formObj.fr_year.value;
                sheetObj.CellValue2(i, "upd_chk") = "N";
                sheetObj.CellValue2(i, "upd_chk2") = "N";
            }
            sheetObj.ReDraw = true;
        }
    }


    /**
     * COM_ENS_071 의 값을 받은 함수
     * @param {Object} aryPopupData
     * @param {Object} row
     * @param {Object} col
     * @param {Object} shhetIdx
     */
    function getCOM_ENS_071(aryPopupData, row, col, shhetIdx){
         if (aryPopupData.length > 0 ) {
            sheetObjects[0].CellValue2(row,col) = aryPopupData[0][3];
         }
    }


    /**
     * (Service Provider) Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
        if ( aryPopupData.length > 0 ) {
            sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"vndr_seq") = aryPopupData[0][2];
            sheetObjects[0].CellValue(sheetObjects[0].SelectRow,"vndr_nm")  = aryPopupData[0][4];
            sheetObjects[0].CellValue(Row,Col)=aryPopupData[0][4];
        }
    }


    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            //Office Code체크
            if (ColSaveName(Col) == "ofc_cd") {
                if (ComTrimAll(Value," ") != "") {
                    var retArray = null;
                    retArray = MnrGeneralCodeCheck(sheetObj, "OFC", Value);
                    if(retArray == null){
                        ComShowCodeMessage("MNR00165", Value, "OFFICE");
                        CellValue2(Row, Col) = "";
                        SelectCell(Row, Col);
                        return;
                    } else {
                        SelectCell(Row, Col + 1);
                    }
                }

            } else {
                var n1stSerRngSealNo = parseInt(Number(CellValue(Row, "n1st_ser_rng_seal_no")), 10);
                var lstSerRngSealNo = parseInt(Number(CellValue(Row, "lst_ser_rng_seal_no")), 10);
                
                //Serial Range null체크
                if (ColSaveName(Col) == "seal_no_pfx_nm") {
                    CellValue2(Row,"upd_chk") = "Y";
                    CellValue2(Row,"seal_no_pfx_nm0") = CellValue(Row,"seal_no_pfx_nm");

                } else if (ColSaveName(Col) == "n1st_ser_rng_seal_no") {
                    CellValue2(Row,"upd_chk") = "Y";
                    CellValue2(Row,"upd_chk2") = "Y";
                    if (n1stSerRngSealNo < 1) {
                        ComShowCodeMessage("MNR00165", CellValue(Row,Col), "Serial Range");
                        SelectCell(Row,Col);
                        return;
                    }
                    
                    if (lstSerRngSealNo > 0) {
                        CellValue2(Row, "pln_qty") = (parseInt(lstSerRngSealNo, 10) - parseInt(n1stSerRngSealNo, 10) + 1);
                    } else {
                        CellValue2(Row, "pln_qty") = "";
                    }

                } else if (ColSaveName(Col) == "lst_ser_rng_seal_no") {
                    CellValue2(Row,"upd_chk") = "Y";
                    CellValue2(Row,"upd_chk2") = "Y";
                    if (lstSerRngSealNo < 1) {
                        ComShowCodeMessage("MNR00165", CellValue(Row,Col), "Serial Range");
                        SelectCell(Row,Col);
                        return;
                    }
                    CellValue2(Row, "pln_qty") = (parseInt(lstSerRngSealNo, 10) - parseInt(n1stSerRngSealNo, 10) + 1);
                }

                if ((ColSaveName(Col) == "ofc_cd") || (ColSaveName(Col) == "seal_knd_nm") || (ColSaveName(Col) == "vndr_seq") || (ColSaveName(Col) == "cntr_seal_lost_qty")) {
                    CellValue2(Row,"upd_chk2") = "Y";
                }
            }
        }
    }

/* 개발자 작업  끝 */
