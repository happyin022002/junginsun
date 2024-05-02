/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0056.js
*@FileTitle : RDR Download by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.17 장강철
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
* 2011.01.20 김상수 [CHM-201108389-01] RDR Inquiry by Lane 추가 기능 개발
*                    - Slot Release TEU, WT에 사용자가 입력하는 Data를 반영할 수 있도록 보완
* 2012.05.11 김창헌 [CHM-201217413-01]
*                  [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
*                   - Sum 기능 추가, 정렬순서 및 표시형식 변경
* 2013.06.14 이수진 [CSR 선반영건] Carrier Code Multi 선택시 공통 스크립트 오류 (100byte넘었을 경우)
*                  별도 Edit 기능이 없어 Validate 기능 주석 처리 함.
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
     * @class FNS_JOO_0056 : FNS_JOO_0056 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function FNS_JOO_0056() {
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

var comboObjects = new Array();
var comboCnt = 0;


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObj = sheetObjects[0];
        /*******************************************************/
        var frmObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btns_calendar_from": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(frmObj.pre_fr, 'yyyy-MM-dd');
                    break;

                case "btns_calendar_to": //달력버튼
                    var cal = new ComCalendar();
                    cal.select(frmObj.pre_to, 'yyyy-MM-dd');
                    break;
                case "btn_retrieve":
                    doActionIBSheet(sheetObj, frmObj, IBSEARCH);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObj, frmObj, IBSAVE);    // 저장
                    break;

                case "btn_downexcel":
                    // sheetObject1.Down2Excel(-1);
                    var paramObj = new Object();
                    paramObj.cols = 10;
                    var url = ComJooGetPgmTitle(sheetObj, paramObj);
//                    sheetObj.Down2Excel(-1, false, false, true, "", url);
                    sheetObj.Down2Excel(1, false, false, true, "", url, false, false, "", false, "empty_wt|remark|remark_cont|vsl_cd|voy_no|dir_cd|region|jo_rf_ocn_qty|jo_rf_ipt_qty|jo_void_teu_qty");
                    break;

        		case "sum_flg": //Sum 체크
	    			if (frmObj.sum_flg.checked){
	    				frmObj.sum_flg.value = "Y";
	    			}else{
	    				frmObj.sum_flg.value = "N";
	    			}
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
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }


      /**
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
      function setComboObject(combo_obj) {
         comboObjects[comboCnt++] = combo_obj;
      }


      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form, IBCLEAR);
          document.form.rlane_cd.focus();
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
         // IBMultiCombo초기화

         for(var k=0; k<comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         initControl();
     }


      /**
       * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
       * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
       * @param {ibsheet} sheetObj    IBSheet Object

       * @param {int}     sheetNo     sheetObjects 배열에서 순번
       **/
      function initControl() {
          var formObject = document.form;
          axon_event.addListenerForm  ('keydown', 'ComKeyEnter',  formObject);
          axon_event.addListenerForm  ('keydown', "fnOnKeyDown",  formObject);

          axon_event.addListenerForm  ('keypress', 'fnObjKeyPress', formObject );
          axon_event.addListenerForm  ('change'  , 'fnObjChange', formObject );
          axon_event.addListenerForm  ('keyup'   , "fnObjKeyUp",  formObject);

          axon_event.addListener      ('click',   'fnDocClick', "srch_rlane_cd");

          axon_event.addListenerFormat('deactivate',  'fnDeactivate',  formObject);
          axon_event.addListenerFormat('activate'  ,  'fnActivate',  formObject);

          axon_event.addListenerFormat('change', 'obj_change',	formObject);		//- 변경될때
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
                     style.height = 430;

                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     // Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     // 전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;//msAll;

                     // 전체Edit 허용 여부 [선택, Default false]
                     Editable = true;
                     EditableColorDiff = false;

                     // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 3, 100);

                     var HeadTitle2 = "|VVD|Port|ETD|Carrier|Allocation|Allocation|Slot Release|Slot Release|Slot Release|Adjusted Allocation|Adjusted Allocation|Total Used|Total Used|Over Used|Over Used|Short-leg Remark|Short-leg Remark|Short-leg Remark|20'HC|20'HC|40'HC|40'HC|45'|45'|RF|RF|EMPTY\nTEU|EMPTY\nWT|Remark|Remark|RemarkCont" +
                                      "|vsl_cd|voy_no|dir_cd|region|JO_RF|JO_RF|JO_VOID";
                     var HeadTitle3 = "|VVD|Port|ETD|Carrier|TEU|WT|TEU|WT|R/Option|TEU|WT|TEU|WT|TEU|WT|TEU|WT|WT to TEU|Loaded|Sub-Alloc|Loaded|Sub-Alloc|Loaded|Sub-Alloc|O|I|EMPTY\nTEU|EMPTY\nWT|Remark|Remark|RemarkCont" +
                                      "|vsl_cd|voy_no|dir_cd|region|OCN|IPT|TEU";
                     var headCount = ComCountHeadTitle(HeadTitle2);

                     // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 5, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false, false);

                     // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle2, true);
                     InitHeadRow(1, HeadTitle3, true);

                     // 데이터속성    [ROW, COL,  DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,     daCenter,    true,     "ibflag");
                     InitDataProperty(0, cnt++ , dtData,         100,    daCenter,    true,     "vvd",                      false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daCenter,    true,     "port_cd",                  false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         110,    daCenter,    true,     "vps_etd_dt",               false,    "",    dfTimeHms,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         70,     daCenter,    true,     "opr_cd",                   false,    "",    dfNone,       0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "alc_alloc",                false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "alc_wgt",                  false,    "",    dfFloat,      2,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "swap_slot",                false,    "",    dfInteger,    0,    true,     false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "swap_wgt",                 false,    "",    dfFloat,      2,    true,     false);
                     InitDataProperty(0, cnt++ , dtCombo,        90,     daLeft,      false,    "jo_slt_rlse_cd",           false,    "",    dfNone,       0,    true,     false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "adjust_teu",               false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "adjust_wt",                false,    "",    dfFloat,      2,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "act_slot",                 false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "act_wgt",                  false,    "",    dfFloat,      2,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "over_slot",                false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "over_wgt",                 false,    "",    dfFloat,      2,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "jo_shrt_leg_rmk_teu_qty",  false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "jo_shrt_leg_rmk_wgt",      false,    "",    dfFloat,      2,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         70,     daRight,     false,    "jo_shrt_leg_rmk_diff_qty", false,    "",    dfInteger,    0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "load_20",                  false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "bsa_hc20",                 false,    "",    dfInteger,    0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "load_40",                  false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "bsa_hc40",                 false,    "",    dfInteger,    0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "load_45",                  false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "bsa_45",                   false,    "",    dfInteger,    0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "r_o",                      false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     false,    "r_i",                      false,    "",    dfInteger,    0,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         60,     daRight,     true,     "empty_teu",                false,    "",    dfInteger,    0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       60,     daRight,     true,     "empty_wt",                 false,    "",    dfFloat,      2,    false,    false);

                     InitDataProperty(0, cnt++ , dtData,         58,     daCenter,    true,     "remark",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       58,     daCenter,    true,     "source",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       58,     daCenter,    true,     "remark_cont",              false,    "",    dfNone,       0,    false,    false);

                     InitDataProperty(0, cnt++ , dtHidden,       50,     daCenter,    true,     "vsl_cd",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daCenter,    true,     "voy_no",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daCenter,    true,     "dir_cd",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daCenter,    true,     "region",                   false,    "",    dfNone,       0,    false,    false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daRight,     false,    "jo_rf_ocn_qty",            false,    "",    dfInteger,    0,    true,     false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daRight,     false,    "jo_rf_ipt_qty",            false,    "",    dfInteger,    0,    true,     false);
                     InitDataProperty(0, cnt++ , dtHidden,       50,     daRight,     false,    "jo_void_teu_qty",          false,    "",    dfInteger,    0,    true,     false);

                     InitDataCombo(0, "jo_slt_rlse_cd", "Purchase|Release|Compensation", "P|R|C");    // sheet0내 Combo setting
                     ShowButtonImage = 4;

                     RowHeight(0) = 20;
                     RowHeight(1) = 20;
                     DataLinkMouse("vvd") = true;
                 }
             break;

         }
     }


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
                if (validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCHLIST01;
                    
                    if (formObj.sum_flg.value == "Y") {
                    	ComBtnDisable("btn_save");
                    } else {
                    	ComBtnEnable("btn_save");
                    }
                    
                    sheetObj.DoSearch("FNS_JOO_0056GS.do", FormQueryString(formObj));
                }
                break;

            case IBSAVE:      //저장
                if (!sheetObj.IsDataModified) {
                    ComShowCodeMessage("JOO00036");
                } else {
                    if (validateForm(sheetObj,formObj,sAction)) {
                        if (ComShowCodeConfirm("JOO00046")) {
                            formObj.f_cmd.value = MULTI;
                            sheetObj.DoSave("FNS_JOO_0056GS.do", FormQueryString(formObj), -1, false);
                        }
                    }
                }
                break;

            case IBCLEAR:
                var param = "";
                var sXml = "";
                var code = "";
                var comboString = "";
                var comboCodeList = "";
                var comboTextList = "";

                code = "CD00593";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml = sheetObj.GetSearchXml("FNS_JOO_0056GS.do", param);
                //ComXml2ComboItem(sXml, formObj.skd_dir_cd, "code", "name");

                //ComXml2ComboItem 생성후 ALL 항목을 맨앞에 추가시 index가 재설정이 안되어 아래 방식으로 적용 
                comboString = ComXml2ComboString(sXml, "code", "name");
                comboCodeList = comboString[0].split('|');
                comboTextList = comboString[1].split('|');
                formObj.skd_dir_cd.RemoveAll();
                formObj.skd_dir_cd.InsertItem(-1, "", "");
                for (var w=0; w<comboCodeList.length; w++) {
                    formObj.skd_dir_cd.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                }
                formObj.skd_dir_cd.Index2 = 0;

                code = "CD02169";
                formObj.f_cmd.value = SEARCH01;
                param = FormQueryString(formObj)+"&super_cd1="+code;
                sXml = sheetObj.GetSearchXml("FNS_JOO_0056GS.do", param);
                //ComXml2ComboItem(sXml, formObj.joRgnCdCombo, "code", "name");

                //ComXml2ComboItem 생성후 ALL 항목을 맨앞에 추가시 index가 재설정이 안되어 아래 방식으로 적용 
                comboString = ComXml2ComboString(sXml, "code", "name");
                comboCodeList = comboString[0].split('|');
                comboTextList = comboString[1].split('|');
                formObj.joRgnCdCombo.RemoveAll();
                formObj.joRgnCdCombo.InsertItem(-1, "[ALL]", "");
                for (var w=0; w<comboCodeList.length; w++) {
                    formObj.joRgnCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                }
                formObj.joRgnCdCombo.Index2 = 0;
                
//                formObj.f_cmd.value = SEARCHLIST03;
//                param = FormQueryString(formObj);
//                sXml = sheetObj.GetSearchXml("JOOCommonGS.do", param);
//                comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
//                comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
//                formObj.oprCdCombo.RemoveAll();
//                formObj.oprCdCombo.InsertItem(-1, "[ALL]", "");
//                for (var w=0; w<comboCodeList.length-1; w++) {
//                    formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
//                }
//                formObj.oprCdCombo.Index2 = 0;
                break;

            case IBSEARCH_ASYNC01:
                var code =  formObj.rlane_cd.value;
                formObj.f_cmd.value = SEARCH07;
                var param =  FormQueryString(formObj)+"&code="+code;
                var sXml =  sheetObj.GetSearchXml("JOOCommonGS.do", param);
                var sTotal =  ComGetTotalRows(sXml);
                if (sTotal == "0") {
                    ComShowCodeMessage("JOO00110");
                    formObj.rlane_cd.value = '';
                    formObj.rlane_cd.focus();
                } else {
                    formObj.rlane_cd.value = code;
                    formObj.skd_dir_cd.focus();
                }
                break;
        }
    }


    /**
     * 조회 함수를 이용하여 조회가 완료되면 실행 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            with (sheetObj) {
                ReDraw = false;
                ColFontUnderline("vvd") = true;

                for (var i=HeaderRows; i<=LastRow; i++) {
                    if (CellValue(i, "jo_slt_rlse_cd") == "C") {
                        if (Number(CellValue(i, "swap_slot")) == 0 && Number(CellValue(i, "swap_wgt")) == 0) {
                            CellEditable(i, "jo_slt_rlse_cd") = false;
                            CellBackColor(i, "jo_slt_rlse_cd") = RgbColor(240, 240, 240);
                        }
                    } else {
                        CellEditable(i, "swap_slot") = false;
                        CellEditable(i, "swap_wgt") = false;
                        CellBackColor(i, "swap_slot") = RgbColor(240, 240, 240);
                        CellBackColor(i, "swap_wgt") = RgbColor(240, 240, 240);
                    }

                    if (Number(CellValue(i, "jo_shrt_leg_rmk_teu_qty")) > 0 ||
                        Number(CellValue(i, "jo_shrt_leg_rmk_wgt")) > 0 ||
                        Number(CellValue(i, "jo_shrt_leg_rmk_diff_qty")) > 0 ||
                        Number(CellValue(i, "jo_rf_ocn_qty")) > 0 ||
                        Number(CellValue(i, "jo_rf_ipt_qty")) > 0 ||
                        Number(CellValue(i, "jo_void_teu_qty")) > 0) {

                        CellFontColor(i, "remark") = RgbColor(255, 0, 0);
                        CellBackColor(i, "source") = RgbColor(255, 200, 200);
                    }
                }
                ReDraw = true;
            }
        }
    }


    /**
     * 저장 함수를 이용하여 저장이 완료되면 실행 <br>
     * @param {ibsheet} Event       IBSheet 저장 후 발생하는 Event
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if (ErrMsg == "") {
            ComShowCodeMessage("JOO00160");
            doActionIBSheet(sheetObj, document.form, IBSEARCH);
        }
    }


    /**
     * Sheet1의 OnChange 이벤트 처리
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        with (sheetObj) {
            if (ColSaveName(Col) == "swap_slot" || ColSaveName(Col) == "swap_wgt" || ColSaveName(Col) == "jo_slt_rlse_cd") {
                if (CellSearchValue(Row, Col) == "C") {
                    if (Value != "C") {
                        CellValue(Row, "swap_slot") = "0";
                        CellValue(Row, "swap_wgt") = "0";
                    }
                    CellEditable(Row, "swap_slot") = false;
                    CellEditable(Row, "swap_wgt") = false;
                    CellBackColor(Row, "swap_slot") = RgbColor(240, 240, 240);
                    CellBackColor(Row, "swap_wgt") = RgbColor(240, 240, 240);

                } else {
                    if (Value == "C") {
                        CellEditable(Row, "swap_slot") = true;
                        CellEditable(Row, "swap_wgt") = true;
                        CellBackColor(Row, "swap_slot") = DataBackColor;
                        CellBackColor(Row, "swap_wgt") = DataBackColor;
                    }
                }
                Joo0056CalcuLogic(sheetObj, Row);
            }
        }
    }


    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     * @param comboObj
     * @param comboIndex Number
     */
    function initCombo(comboObj, comboNo ) {
        switch(comboObj.id) {
        	case "skd_dir_cd":
	            with (comboObj) {
	                MultiSelect = false;
	                UseAutoComplete = true;
	                SetColAlign("left");
	                SetColWidth("60");
	                DropHeight = 200;
	                ValidChar(2,0);
	                MaxLength = 1;
	            }
	            break;
	
	        case "joRgnCdCombo":
                comboObj.MultiSelect = true;
                comboObj.DropHeight = 200;
                break;

            case "oprCdCombo":
                comboObj.MultiSelect = true;
                comboObj.DropHeight = 200;
                break;
        }
    }

 	/**
 	 * HTML Control의 onchange 이벤트에서 Validation을 체크한다. <br>
 	 **/
 	function obj_change()
 	{	     
 		//ComChkObjValid(event.srcElement);
 		var obj      = event.srcElement; 
 		var formObj  = document.form; 
 		var sheetObj = sheetObjects[0]; 
 	
 		switch(obj.name)
 		{      
 		case "pre_fr":
 	    	oprCdCombo_clear();
 			break;
 		case "pre_to":
 	    	oprCdCombo_clear();
 			break;
 		case "rlane_cd":
 	    	oprCdCombo_clear();
 			break;
 		}
 	}
     
     //Period, Lane 변경시 Carrier 초기화
     function oprCdCombo_clear(){
//     	comboObjects[2].Index2 = -1;
//     	comboObjects[2].RemoveAll();
    	document.form.oprCdCombo.Index2 = -1;
    	document.form.oprCdCombo.RemoveAll();
     	document.form.opr_cd.value = "";

     	sheetObjects[0].RemoveAll();
     }

     function oprCdCombo_OnFocus(comboObj){
     	var formObj = document.form;
     	
     	if (formObj.pre_fr.value.length < 10){
     		ComShowCodeMessage("JOO00019", "Period");
     		formObj.pre_fr.focus();
     		return;
     	}

     	if (formObj.pre_to.value.length < 10){
     		ComShowCodeMessage("JOO00019", "Period");
     		formObj.pre_to.focus();
     		return;
     	}

     	if (formObj.rlane_cd.value.length < 3){
     		ComShowCodeMessage("JOO00019", "Lane");
     		formObj.rlane_cd.focus();
     		return;
     	}
     	
     	if (comboObj.GetCount() == 0){
     		comboObj.Enable = false;	
     		doActionIBCombo(sheetObjects[1], formObj, IBSEARCH, comboObj ,"oprCdCombo");
     		comboObj.Enable = true;	
     	}	
     }

     // 조회조건필드인 Carrier 데이터 조회
     function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboKey) {
         sheetObj.ShowDebugMsg = false;

         switch(sAction) {

            case IBSEARCH:
     			if (sComboObj.id == "oprCdCombo") {
     				//콤보필드를 초기화시킨다.
     				sComboObj.RemoveAll();
     									
     				formObj.f_cmd.value = SEARCH03;
     				     				
     				var sXml = sheetObj.GetSearchXml("FNS_JOO_0056GS.do", FormQueryString(formObj));
     				
                     var comboCodeList = ComGetEtcData(sXml, "comboCode").split("^#^");
                     var comboTextList = ComGetEtcData(sXml, "comboText").split("^#^");
                     formObj.oprCdCombo.RemoveAll();
                     formObj.oprCdCombo.InsertItem(-1, "[ALL]", "");
                     for (var w=0; w<comboCodeList.length-1; w++) {
                         formObj.oprCdCombo.InsertItem(-1, comboTextList[w], comboCodeList[w]);
                     }
                     formObj.oprCdCombo.Index2 = 0;
     			}
     	        break;
         }
     }

    /**
     * joRgnCdCombo MultiSelection OnCheckClick 이벤트 처리
     *  - MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
     *  - 'ALL'을 선택하면 다른 Item의 Check해제
     *  - Item을 선택했을 경우 SQL의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
     */
    function joRgnCdCombo_OnCheckClick(comboObj, index, code) {
        var formObject = document.form
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;
            formObject.region.value = "";

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                // Submit할 내용도 Clear
                formObject.region.value = "";

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                // Submit할 내용 Define
                formObject.region.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
            }
        }
    }


    /**
     * oprCdCombo의 MultiSelection OnCheckClick 이벤트 처리
     *  - MultiCombo(MultiSelection허용)의 MultiSelection OnCheckClick 이벤트 처리
     *  - 'ALL'을 선택하면 다른 Item의 Check해제
     *  - Item을 선택했을 경우 SQL의 In 조건에 사용가능한 "('A', 'B', 'C')" 형식을 setting
     */
    function oprCdCombo_OnCheckClick(comboObj, index, code) {
    	var formObject = document.form
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;
            formObject.opr_cd.value = "";

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                // Submit할 내용도 Clear
                formObject.opr_cd.value = "";

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                // Submit할 내용 Define
                formObject.opr_cd.value = ("'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'");
            }
        }
    }


      /**
       * Period NAVI 처리 이벤트
       * @param void
       * @return void
       */
       function fnDocClick(){
           var obj = event.srcElement;
           var formObj = document.form;

           switch (obj.name){
               case "srch_rlane_cd"://Lane 팝업 조회
                    var lane_cd = formObj.rlane_cd.value;
                    var param = "?mode=svc&lane_cd="+lane_cd;
                    ComOpenPopup("/hanjin/COM_ENS_081.do" + param, 820, 460, "getCOM_ENS_081_1", "1,0,1,1,1,1,1,1");
                    break;

           }
       }


       function getCOM_ENS_081_1(aryPopupData){
           with(document.form){
                 rlane_cd.value  = aryPopupData[0][3];
           }
       }


    /**
     * form Element의 KeyPress Event 발생시 처리.
     */
    function fnObjKeyPress() {
        var obj = event.srcElement;
        var formObj = document.form;
        var attr = obj.getAttribute("dataformat");

        switch (attr) {
            case "ymd":
                ComKeyOnlyNumber( obj );
                break;

            case "engup":
                ComKeyOnlyAlphabet( "upper" );
                break;

            case "engup":
                ComKeyOnlyAlphabet( "upper" );
                break;

            case "uppernum":
                ComKeyOnlyAlphabet( "uppernum" );
                break;

        }
    }


       /**
        * form element의 dataformat을 이용한 입력 Validate 처리,
        * focus 잃었을때발생.
        */
       function fnDeactivate(){
            var obj = event.srcElement;
            var formObj = document.form;
            var attr   =  obj.getAttribute("dataformat");

            switch(obj.name){

                case 'pre_fr':
                      ComAddSeparator(obj );
                      break;

                case 'pre_to':
                      ComAddSeparator(obj );
                      break;

//                case 'rlane_cd':
//                    if( obj.value == ""){return;}
//                    if( !ComChkObjValid(obj  )){
//                         ComSetFocus(obj);
//                         return;
//                    }
//                    break;
            }
       }


        /**
         * <pre>
         *     form element의 dataformat을 이용한 입력 Validate 처리,
         *     focus 얻었을때발생.
         * </pre>
         *
         * @return void
         */
        function fnActivate(){

            var obj = event.srcElement;
            var formObj = document.form;
            var attr   =  obj.getAttribute("dataformat");

            switch(attr){
                case 'ymd':
                     ComClearSeparator(obj );
                     break;

            }
            ComSetFocus(obj);
        }


       /**
        *
        * <pre>
        *    Form Clear 처리
        * </pre>
        *
        * @param
        * @return
        * @author jang kang cheol
        */
       function fnFormClear(){
           var formObj = document.form;
           ComClearObject(formObj.rlane_cd  );
           formObj.skd_dir_cd.Code = "";
           formObj.joRgnCdCombo.Code = "";
           if( sheetObjects[0].RowCount > 0) {
               sheetObjects[0].RemoveAll();
           }
       }


    function fnObjKeyUp() {
        var formObj = document.form;
        var obj     = event.srcElement;

        switch (obj.name) {
	        case  'skd_dir_cd':
	            if( sheetObjects[0].RowCount > 0) {
	                sheetObjects[0].RemoveAll();
	            }
	            break;

	        case 'joRgnCdCombo':
                if (sheetObjects[0].RowCount > 0) {
                    sheetObjects[0].RemoveAll();
                }
                break;

            case 'rlane_cd':
            	formObj.skd_dir_cd.Code = "";
            	//formObj.joRgnCdCombo.Code = "";
                if (sheetObjects[0].RowCount > 0) {
                    sheetObjects[0].RemoveAll();
                }
                var maxlength = obj.getAttribute("maxlength");
                if (obj.value.length != maxlength) {
                    return;
                } else {
                    doActionIBSheet( sheetObjects[0], formObj, IBSEARCH_ASYNC01);
                }
                break;
        }
    }


     /**
      *
      * <pre>
      *    Grid 클릭시 처리
      * </pre>
      *
      * @author jang kang cheol
      */
     function sheet1_OnClick(sheetObj, row, col){
         var formObj = document.form;

         switch( sheetObj.ColSaveName(col) ){
             case "remark":
                 if( sheetObj.CellValue(row, col) != "Yes" ){ return;}
                 Joo0056ShowMemoPad(sheetObj, row, sheetObj.SaveNameCol("remark_cont"));
                 break;

             case "vvd":
                   var vvd    =  sheetObj.CellValue(row, "vvd");
                   var vsl_cd = vvd.substring(0,4);
                   var voy_no = vvd.substring(4,8);
                   var dir_cd = vvd.substring(8,9);
                   var region = formObj.joRgnCdCombo.Code;

                   var param  = "?pop_mode=Y&vsl_cd="+vsl_cd+"&voy_no="+voy_no+"&dir_cd="+dir_cd+"&region="+region;
                   ComOpenPopup('/hanjin/VOP_OPF_0045_P.do'+param, 1024, 700, 'popupFinish', '1,0,1,1,1,1,1,1', true);
                   break;
         }
     }


     /**
      *
      * <pre>
      *    Grid 더블 클릭시 처리
      * </pre>
      *
      * @author jang kang cheol
      */
     function sheet1_OnDblClick(sheetObj, row, col){
         var formObj  = document.form;
         var savename = sheetObj.ColSaveName(col);

         /**   페이지이동이 필요한, SaveName  **/
         var sMovePageForSaveName = "alc_alloc,alc_wgt,act_slot,act_wgt,load_20,bsa_hc20,load_40,bsa_hc40,load_45,bsa_45,r_o,r_i,empty_teu,remark";
         if( sMovePageForSaveName.indexOf(savename) > -1 ){

             goOpfRdrInquiry(sheetObj, row, col, savename);
         }
     }


     /**
      *
      * <pre>
      *   Opf Rdr Inquiry 팝업 Call
      * </pre>
      *
      * @author jang kang cheol
      */
     function goOpfRdrInquiry(sheetObj, row, col, savename){
          var formObj  = document.form;
          var vvd     = sheetObj.CellValue(row, "vvd");
          var vsl_cd  = vvd.substring(0,4);
          var voy_no  = vvd.substring(4,8);
          var dir_cd  = vvd.substring(8,9);
          var region  = formObj.joRgnCdCombo.Code;
          var joo_init_tab = getRdrTabName(savename);
          if( joo_init_tab == ""){
             return;
          }
          var param   = "?pop_mode=Y&vsl_cd="+vsl_cd+"&voy_no="+voy_no+"&dir_cd="+dir_cd+"&region="+region+"&joo_init_tab="+joo_init_tab;
          ComOpenPopup('/hanjin/VOP_OPF_0045_P.do'+param, 1024, 700, 'popupFinish', '1,0,1,1,1,1,1,1', false);
     }


     /**
      *
      * <pre>
      *     Grid SaveName으로 Opf Rdr Inquiry의 TabName과의 Mapping 함수.
      * </pre>
      *
      * @param   Grid SaveName
      * @return  Opf TabName
      * @author  jang kang cheol
      */
     function getRdrTabName(SaveName){
         var OpfTabName = "";
         switch ( SaveName ){

             /**********************************************
              * alc_alloc
              * alc_wgt
              *            => VSL_Alloc
              **********************************************/
               case "alc_alloc"://Allocation
                    OpfTabName = "VSL_Alloc";
                    break;

               case "alc_wgt"://Allocation
                    OpfTabName = "VSL_Alloc";
                    break;

              /**********************************************
               * act_slot
               * act_wgt
               * empty_teu
               *            => SlotWGT_Util
               **********************************************/
               case "act_slot"://Total Used, Empty
                    OpfTabName = "SlotWGT_Util";
                    break;

               case "act_wgt"://Total Used, Empty
                    OpfTabName = "SlotWGT_Util";
                    break;

               case "empty_teu":
                   OpfTabName = "SlotWGT_Util";
                   break;

               /**********************************************
                * load_20
                * bsa_hc20
                * load_40
                * bsa_hc40
                * load_45
                * bsa_45
                *            => HC45
                **********************************************/
               case "load_20":
                    OpfTabName = "HC45";
                    break;

               case "bsa_hc20":
                    OpfTabName = "HC45";
                    break;

               case "load_40":
                    OpfTabName = "HC45";
                    break;

               case "bsa_hc40":
                    OpfTabName = "HC45";
                    break;

               case "load_45":
                    OpfTabName = "HC45";
                    break;

               case "bsa_45":
                    OpfTabName = "HC45";
                    break;

               case "r_o":
                    OpfTabName = "RF";
                    break;

               case "r_i":
                    OpfTabName = "RF";
                    break;

               case "remark":
                    OpfTabName = "Remark";
                    break;

         }
         return OpfTabName;
     }


     /**
      * 공통js의 ComShowMemoPad를 ReDefine
      */
    function Joo0056ShowMemoPad(sheetObj, row, col) {

        //함수의 인자 default 값 설정하기
        var iWidth = 400;
        var iHeight = 311;
        //전역변수에 값setting
        memoSheet = sheetObj;
        memoRow = row;
        memoCol = col;

        //메모를 위한 IBSheet 정보의 Validation 확인하기
        if (sheetObj.CellEditable(row, col)) {
            return ComShowMessage("[Joo0056ShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
        }
        //메모를 위한 IBSheet 정보 받기
        if (!ComIsNumber(col)) ccolol = sheetObj.SaveNameCol(col);

        //메모패드 만들기
        if (!Joo0056initMemoPad()) return;

        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col) + 2;
        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row) + sheetObj.RowHeight(row) + 2;
        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.

        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
        if (top.document != document && window.frameElement.scrolling == "no") {
            //높이초과
            if (iTop + iHeight  > document.body.clientHeight) {
                iBottom = iTop + sheetObj.RowHeight(row) - (sheetObj.RowHeight(row) * 2);
                if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;
                iTop = iBottom-iHeight;
                if (iTop <0) iTop = 0
            }

            //넓이초과
            if (iLeft + iWidth  > document.body.clientWidth) {
                iLeft = document.body.clientWidth - iWidth;
                if (iLeft<0) iLeft = 0;
            }
        }

        var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = "#E8E7EC";
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight - 26;
        _frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row, col).trim();
        _frameDoc.getElementById("_memoInput1_").value = sheetObj.CellText(row, "jo_shrt_leg_rmk_teu_qty").trim();
        _frameDoc.getElementById("_memoInput2_").value = sheetObj.CellText(row, "jo_shrt_leg_rmk_wgt").trim();
        _frameDoc.getElementById("_memoInput3_").value = sheetObj.CellText(row, "jo_shrt_leg_rmk_diff_qty").trim();
        _frameDoc.getElementById("_memoInput4_").value = sheetObj.CellText(row, "jo_rf_ocn_qty").trim();
        _frameDoc.getElementById("_memoInput5_").value = sheetObj.CellText(row, "jo_rf_ipt_qty").trim();
        _frameDoc.getElementById("_memoInput6_").value = sheetObj.CellText(row, "jo_void_teu_qty").trim();
        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = true;

        var _divMemo = document.getElementById(MEMO_DIV_NAME);
        _divMemo.style.width = iWidth;
        _divMemo.style.height = iHeight;
        _divMemo.style.top = iTop;
        _divMemo.style.left = iLeft;
        _divMemo.style.visibility = "visible";
        _divMemo.focus();

        ComSetFocus(_frameDoc.getElementById("_memoInput1_"));
    }



    /**
     * 공통js의 initMemoPad를 ReDefine
     */
    function Joo0056initMemoPad() {

        //메모용 Div가 없으면 생성한다.
        if (document.getElementById(MEMO_DIV_NAME) != null) return true;

        //메모용 Div 만들기
        var _divMemo=document.createElement("<div id='" + MEMO_DIV_NAME + "' style='position:absolute; visibility:hidden'/>");
        document.body.insertBefore(_divMemo);

        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        var _frameMemo = document.createElement("<iframe id='" + MEMO_FRAME_NAME + "' frameborder='0' marginHeight='0' marginWidth='0' width='100%' height='100%'/>");
        _divMemo.appendChild(_frameMemo);

        var _frameDoc = _frameMemo.contentWindow.document;

        //iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _frameDiv = _frameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; background-color:#E6EFF6;'/>");
        _frameDoc.appendChild(_frameDiv);

        var _frameDiv1 = _frameDoc.createElement("<span style='width:311px;'/>");
        _frameDiv.appendChild(_frameDiv1);
        //Div안에 Textarea 만들기
        _frameDiv1.appendChild(_frameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME + "' style='border:#7F9DB9 1px solid; color:#4f4f4f; width:100%'/>"));

        var _frameDiv2 = _frameDoc.createElement("<span style='padding:10px; width:85px;'/>");
        _frameDiv.appendChild(_frameDiv2);
        //Div안에 Input 만들기
        var _frameP10 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:700; color:#4f4f4f;'/>");
        _frameP10.innerHTML = "Short-leg</br>Remark";
        _frameDiv2.appendChild(_frameP10);
        var _frameP11 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:10px; color:#4f4f4f;'/>");
        _frameP11.innerText = " ▷  TEU";
        _frameDiv2.appendChild(_frameP11);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput1_' tabindex='1' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='4' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP12 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:10px; color:#4f4f4f;'/>");
        _frameP12.innerText = " ▷  WT";
        _frameDiv2.appendChild(_frameP12);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput2_' tabindex='2' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46&&event.keyCode!=110&&event.keyCode!=190)return false;' onfocusout='this.value=parent.ComAddComma2(this.value, \"#,###.00\");' maxlength='8' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP13 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:10px; color:#4f4f4f;'/>");
        _frameP13.innerText = " ▷  WT to TEU";
        _frameDiv2.appendChild(_frameP13);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput3_' tabindex='3' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='4' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP20 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:900; color:#4f4f4f;'/>");
        _frameP20.innerText = "RF";
        _frameDiv2.appendChild(_frameP20);
        var _frameP21 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP21.innerText = " ▷  O";
        _frameDiv2.appendChild(_frameP21);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput4_' tabindex='4' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='4' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP22 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP22.innerText = " ▷  I";
        _frameDiv2.appendChild(_frameP22);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput5_' tabindex='5' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='4' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));
        var _frameP30 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:12px; font-weight:900; color:#4f4f4f;'/>");
        _frameP30.innerHTML = "Void";
        _frameDiv2.appendChild(_frameP30);
        var _frameP31 = _frameDoc.createElement("<div style='font-family:Tahoma,Arial; font-size:11px; color:#4f4f4f;'/>");
        _frameP31.innerText = " ▷  TEU";
        _frameDiv2.appendChild(_frameP31);
        _frameDiv2.appendChild(_frameDoc.createElement("<input id='_memoInput6_' tabindex='6' onkeydown='if((event.keyCode<48||event.keyCode>57)&&(event.keyCode<96||event.keyCode>105)&&event.keyCode!=8&&event.keyCode!=9&&event.keyCode!=46)return false;' onfocusout='this.value=parent.ComAddComma(this.value);' maxlength='4' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; text-align:center; color:#4f4f4f; ime-mode:disabled; height:18px; width:100%'/>"));

        var _centerTag = _frameDoc.createElement("<div style='height:20px; text-align:center; vertical-align:middle;'/>");
        //Apply 버튼 만들기
        var _button1 = _frameDoc.createElement("<span id='btn_apply' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.Joo0056SetMemoValue(document.getElementById(\"" + MEMO_TEXT_NAME + "\").value," + 4000 + ");'/>");
        _button1.innerText = "Apply";
        _centerTag.appendChild(_button1);
        //Close 버튼 만들기
        var _button2 = _frameDoc.createElement("<span id='btn_close' style='font-family:Tahoma,Arial; font-size:12px; cursor:hand; width:40; height:18; padding:0,3,0,3; text-align:center; border:1 solid gray; background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
        _button2.innerText = "Close";
        _centerTag.appendChild(_button2);

        _frameDiv.appendChild(_centerTag);

        //메모용 iFrame 자동 닫기 처리
        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
            //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
            window.popupMemoOldEventListener = document.onmouseup;
            if (window.popupMemoOldEventListener != null) {
                //alert("CoObject \n" + window.popupMemoOldEventListener.toString());
                //기존에 document.onmouseup에  정의된 함수가 있는 경우
                document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
            } else {
                //기존에 document.onmouseup에  정의된 함수가 없는 경우
                document.onmouseup = ComHideMemoPad;
            }

            //ActiveX에 포커스가 갔을때 메모DiV 닫기
            var objs = document.getElementsByTagName("OBJECT")
            window.popupMemoOldObjEventListener = new Array(objs.length);
            for(var i = 0 ; i < objs.length ; i++){
                window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
                if (window.popupMemoOldObjEventListener[i] != null) {
                    //기존에 document.onmouseup에  정의된 함수가 있는 경우
                    objs[i].onfocus = new Function("window.popupMemoOldObjEventListener[" + i + "](); ComHideMemoPad();");
                } else {
                    //기존에 document.onmouseup에  정의된 함수가 없는 경우
                    objs[i].onfocus = ComHideMemoPad;
                }
            }
        }
        return true;
    }


    /**
     * 공통js의 setMemoValue를 ReDefine
     */
    function Joo0056SetMemoValue(sValue, iMax) {
        try {
            if (sValue.length > iMax) {
                ComShowMessage("characters long");
                return;
            } else {
                if (memoSheet == null) return;

                var _frameDoc = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;
                if (!_frameDoc.getElementById(MEMO_TEXT_NAME).readOnly) {
                    memoSheet.CellValue(memoRow, memoCol) = sValue;
                }

                var joShrtLegRmkTeuQty = ComNullToZero(_frameDoc.getElementById("_memoInput1_").value.trim());
                var joShrtLegRmkWgt = ComNullToZero(_frameDoc.getElementById("_memoInput2_").value.trim());
                var joShrtLegRmkDiffQty = ComNullToZero(_frameDoc.getElementById("_memoInput3_").value.trim());
                var joRfOcnQty = ComNullToZero(_frameDoc.getElementById("_memoInput4_").value.trim());
                var joRfIptQty = ComNullToZero(_frameDoc.getElementById("_memoInput5_").value.trim());
                var joVoidTeuQty = ComNullToZero(_frameDoc.getElementById("_memoInput6_").value.trim());
                memoSheet.CellValue(memoRow, "jo_shrt_leg_rmk_teu_qty") = joShrtLegRmkTeuQty;
                memoSheet.CellValue(memoRow, "jo_shrt_leg_rmk_wgt") = joShrtLegRmkWgt;
                memoSheet.CellValue(memoRow, "jo_shrt_leg_rmk_diff_qty") = joShrtLegRmkDiffQty;
                memoSheet.CellValue(memoRow, "jo_rf_ocn_qty") = joRfOcnQty;
                memoSheet.CellValue(memoRow, "jo_rf_ipt_qty") = joRfIptQty;
                memoSheet.CellValue(memoRow, "jo_void_teu_qty") = joVoidTeuQty;

                if (Number(ComGetUnMaskedValue(joShrtLegRmkTeuQty, "int")) > 0 ||
                    Number(ComGetUnMaskedValue(joShrtLegRmkWgt, "int")) > 0 ||
                    Number(ComGetUnMaskedValue(joShrtLegRmkDiffQty, "int")) > 0 ||
                    Number(ComGetUnMaskedValue(joRfOcnQty, "int")) > 0 ||
                    Number(ComGetUnMaskedValue(joRfIptQty, "int")) > 0 ||
                    Number(ComGetUnMaskedValue(joVoidTeuQty, "int")) > 0) {

                    memoSheet.CellFontColor(memoRow, "remark") = memoSheet.RgbColor(255, 0, 0);
                    memoSheet.CellBackColor(memoRow, "source") = memoSheet.RgbColor(255, 200, 200);

                } else {
                    memoSheet.CellFontColor(memoRow, "remark") = memoSheet.DataFontColor;
                    memoSheet.CellBackColor(memoRow, "source") = memoSheet. DataBackColor;
                }

                Joo0056CalcuLogic(memoSheet, memoRow);
                ComHideMemoPad(true);
            }
        } catch(err) {
            ComFuncErrMsg(err.message);
        }
    }


    /**
     * MemoPad에 값 입력 후 Sheet에서 사용되는 계산logic
     */
    function Joo0056CalcuLogic(sheetObj, sheetRow) {
        with (sheetObj) {
            // CellSearchValue
            var alcAlloc = Number(CellSearchValue(sheetRow, "alc_alloc"));
            var alcWgt = Number(CellSearchValue(sheetRow, "alc_wgt"));
            var swapSlot = Number(CellSearchValue(sheetRow, "swap_slot"));
            var swapWgt = Number(CellSearchValue(sheetRow, "swap_wgt"));
            var actWgt = Number(CellSearchValue(sheetRow, "act_wgt"));
            // CellValue
            CellValue(sheetRow, "act_slot") = Number(CellSearchValue(sheetRow, "act_slot")) + Number(CellValue(sheetRow, "jo_void_teu_qty"));
            var actSlot = Number(CellValue(sheetRow, "act_slot"));

            if (CellValue(sheetRow, "jo_slt_rlse_cd") == 'R') {
                CellValue(sheetRow, "adjust_teu") = alcAlloc;
                CellValue(sheetRow, "adjust_wt") = alcWgt;
                CellValue(sheetRow, "over_slot") = (actSlot - alcAlloc < 0 ? 0 : actSlot - alcAlloc);
                CellValue(sheetRow, "over_wgt") = (actWgt -alcWgt < 0 ? 0 : actWgt -alcWgt);

            } else {
                CellValue(sheetRow, "adjust_teu") = alcAlloc + swapSlot;
                CellValue(sheetRow, "adjust_wt") = alcWgt + swapWgt;
                CellValue(sheetRow, "over_slot") = (actSlot - (alcAlloc + swapSlot) < 0 ? 0 : actSlot - (alcAlloc + swapSlot));
                CellValue(sheetRow, "over_wgt") = (actWgt - (alcWgt + swapWgt) < 0 ? 0 : actWgt - (alcWgt + swapWgt));
            }
            CellValue(sheetRow, "r_o") = Number(CellSearchValue(sheetRow, "r_o")) + Number(CellValue(sheetRow, "jo_rf_ocn_qty"));
            CellValue(sheetRow, "r_i") = Number(CellSearchValue(sheetRow, "r_i")) + Number(CellValue(sheetRow, "jo_rf_ipt_qty"));
        }
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         switch(sAction) {
                 case IBSEARCH:
//                     if (!ComChkValid(formObj)) return false;
//                     if (formObj.joRgnCdCombo.Code == "") {
//                         ComShowCodeMessage("JOO00115", "Region");
//                         formObj.joRgnCdCombo.focus();
//                         return false;
//                     }
                     break;
         }
         return true;
     }

/* 개발자 작업  끝 */
