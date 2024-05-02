/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BSA_0121.js
*@FileTitle : SML Slot Swap Information By VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.08 남궁진호
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class ESM_BSA_0121 : ESM_BSA_0121 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0121() {
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
 // 공통전역변수


    var sheetObjects = new Array();
    var sheetCnt = 0;


    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        /*
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
            var formObject = document.form;
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
                        //SheetWidth = mainTable.clientWidth;                             //전체 너비 설정
                        SheetWidth = "580";                             //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;                                      //전체Merge 종류 [선택, Default msNone]
                        Editable = true;                                                //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 2, 1, 9, 100);                                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(13, 2, 0, true);                                  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, true, false, true, false,false);             // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        
                        var HeadTitle = "STS|Carrier|Sales to(by VVD)|Sales to(by VVD)|Purchase from(by VVD)|Purchase from(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|Slot Swap(by VVD)|slt_prc_capa|hjs_bfr_sub_capa";
                        var HeadTitle1 = "";
                        if(document.form.pBsa_op_jb_cd.value == "007"){
                            HeadTitle1 = "STS|Carrier|SPC(Teu)|WGT|SPC(Teu)|WGT|Lane|VVD|SPC(Teu)|SPC(Teu)|WGT|slt_prc_capa|hjs_bfr_sub_capa";
                        } else {
                            HeadTitle1 = "STS|Carrier|SPC(BOX)|WGT|SPC(BOX)|WGT|Lane|VVD|SPC(BOX)|SPC(BOX)|WGT|slt_prc_capa|hjs_bfr_sub_capa";
                        }
                        InitHeadRow(0, HeadTitle, true);                                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(1, HeadTitle1, true);
                        
                        var slt_swap_teu = "IF(|slt_swap_teu_capa|>0, |slt_swap_teu_capa|*|slt_prc_capa|, |slt_swap_teu_capa|*|hjs_bfr_sub_capa|)";
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,    "ibflag",           false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "crr_cd",                 false,          "",       dfNone,       0,     false,      false);
                        InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight,   true,    "sls_teu_capa",           false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight,   true,    "sls_wgt",                false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight,   true,    "pur_teu_capa",           false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight,   true,    "pur_wgt",                false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "slt_swap_rlane_cd",      false,          "",       dfEngUpKey,   0,     true,       true, 5);
                        InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "slt_swap_vvd_cd",        false,          "",       dfEngUpKey,   0,     true,       true, 9);
                        InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight,   true,    "slt_swap_teu_capa",      false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight,   true,    "slt_swap_amt",           false,          slt_swap_teu,dfInteger,    0,     false,      false);
                        InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight,   true,    "slt_swap_wgt",           false,          "",       dfInteger,    0,     true,       true);
                        InitDataProperty(0, cnt++ , dtHidden,     10,    daRight,   true,    "slt_prc_capa",           false,          "",       dfInteger,    0,     false,      false);
                        InitDataProperty(0, cnt++ , dtHidden,     10,    daRight,   true,    "hjs_bfr_sub_capa",       false,          "",       dfInteger,    0,     false,      false);
                        
                        CountPosition  = 0 ;
                        style.height = GetSheetHeight(15) ;
                        RangeBackColor(1, 2, 1, 10) = RgbColor(222, 251, 248);   // ENIS
                        RangeBackColor(0, 2, 0, 3) = RgbColor(187,188,230);
                        RangeBackColor(0, 6, 0, 10) = RgbColor(187,188,230);
                        if(document.form.pBsa_op_jb_cd.value == "007"){
                            ColHidden("sls_wgt") = false;
                            ColHidden("pur_wgt") = false;
                            ColHidden("slt_swap_wgt") = false;
                        } else {
                            ColHidden("sls_wgt") = true;
                            ColHidden("pur_wgt") = true;
                            ColHidden("slt_swap_wgt") = true;
                        }                    
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
                case IBSEARCH:      //조회
                    if(!validateForm(sheetObj,formObj,sAction))return false;
                    formObj.f_cmd.value = SEARCHLIST02;
                    sheetObj.DoSearch4Post("ESM_BSA_0121GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0121')));
                    break;
                    
                case IBSAVE:       //저장
                    if(!validateForm(sheetObj,formObj,sAction))return false;
                    saveStatus = true;
                    formObj.f_cmd.value = MULTI02;
                    formObj.chgValueRowNo.value = sheetObj.FindStatusRow("I|U");
                    openerChange(sheetObj, formObj);
                    sheetObj.DoSave("ESM_BSA_0121GS.do", bsaFormString(formObj,getParam2('ESM_BSA_0121','S')), -1, false);
                    break;
            }
        }
        
        function sheet_OnSaveEnd(sheetObj, ErrMsg){
        }
        
        function sheet_OnSearchEnd(sheetObj,ErrMsg) {
          sheetObj.SumText(0,0) = "" ;
          sheetObj.SumText(0,"crr_cd") = "TOTAL" ;
        }

        /**
         * 변경된내용을 부모창에 반영한다.
         */
        function openerChange(sheetObj, formObj){
            var sRow = formObj.sRow.value;
            var chgRow = formObj.chgValueRowNo.value;
            var arrRow = chgRow.split(";");
            var j=0;
            var sls_teu = 0;
            var pur_teu = 0;
            var slt_teu = 0;
            
            for(j=0; j<arrRow.length-1; j++){
                sls_teu = 0;
                pur_teu = 0;
                slt_teu = 0;
//                if(sheetObj.CellSearchValue(arrRow[j], "sls_teu_capa") != sheetObj.CellValue(arrRow[j],"sls_teu_capa")) sls_teu = sheetObj.CellValue(arrRow[j],"sls_teu_capa");
//                if(sheetObj.CellSearchValue(arrRow[j], "pur_teu_capa") != sheetObj.CellValue(arrRow[j],"pur_teu_capa")) pur_teu = sheetObj.CellValue(arrRow[j],"pur_teu_capa");
//                if(sheetObj.CellSearchValue(arrRow[j], "slt_swap_teu_capa") != sheetObj.CellValue(arrRow[j],"slt_swap_teu_capa")) slt_teu = sheetObj.CellValue(arrRow[j],"slt_swap_teu_capa");
                sls_teu = sheetObj.CellValue(arrRow[j],"sls_teu_capa");
                pur_teu = sheetObj.CellValue(arrRow[j],"pur_teu_capa");
                slt_teu = sheetObj.CellValue(arrRow[j],"slt_swap_teu_capa");
                
                opener.changeRow(sRow, sheetObj.CellValue(arrRow[j],"crr_cd"),  sls_teu, pur_teu,  slt_teu);
            }
        }
        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
            }
            return true;
        }


	/* 개발자 작업  끝 */