/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0412.js
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
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
     * @class BKG container update Irr. : BKG container update Irr. 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_ctm_0412() {
      this.processButtonClick    = tprocessButtonClick;
      this.setSheetObject     = setSheetObject;
      this.loadPage         = loadPage;
      this.initSheet         = initSheet;
      this.doActionIBSheet     = doActionIBSheet;
      this.validateForm       = validateForm;
    }

     /* 개발자 작업  */

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
          var sheetObject = sheetObjects[0];


          /*******************************************************/
          var formObject = document.form;

       try {
         var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {

                 case "btn_retrieve":
                     if (checkValidation(formObject))
                       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                   break;

                  case "btn_new":
                  formObject.reset();
                  document.form.p_yard2.RemoveAll()
                  sheetObject.RemoveAll();
                loadPage();
                     break;
               case "btn_Calendar1":
              case "btn_Calendar2":
               var cal = new ComCalendarFromTo();
                  cal.select(formObject.p_date1, formObject.p_date2, 'yyyy-MM-dd');
                break;

                 case "btn_print":
                     alert(srcName);
                     break;
              case "btn_Combo":
                formObject.p_reson.style.display ='none';
               itm = document.all.item("m_combo");
                itm.style.display = '';
                 break;
             case "btn_DownExcel":
                sheetObject.SpeedDown2Excel(-1);
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
     * 조회조건에 대한 Validation 정리
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function checkValidation(formObject) {
        var off_cd = formObject.p_office.value;
        var st_dt = formObject.p_date1.value;
        var ed_dt = formObject.p_date2.value;
        if (off_cd.length < 5) {
            ComShowCodeMessage("CTM00000");
            return false;
        } else if (st_dt.length < 10) {
            ComShowCodeMessage("CTM00000");
            return false;
        } else if (ed_dt.length < 10) {
            ComShowCodeMessage("CTM00000");
            return false;
        }
        return true;
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
         }

         for(k=0;k<tabObjects.length;k++){
             initTab(tabObjects[k],k+1);
         }

         setEventProcess();
         document.form.p_office.focus();
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
                     style.height = 462;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 2, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq.|Container No.|T/S|Irr. Type|Settled|Previous Booking|Previous Booking|Previous Booking|Previous Booking|Previous Booking|Current Booking|Current Booking|Current Booking|Current Booking|Current Booking|Remark(s)";
                     var HeadTitle2 = "Seq.|Container No.|T/S|Irr. Type|Settled|STS|Origin Yard|Booking No.|Booking No.|Event date|STS|Origin Yard|Booking No.|Booking No.|Event date|Remark(s)";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL, DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtSeq,       30,     daCenter,    true,     "SEQ");
                     InitDataProperty(0, cnt++, dtData,      95,     daCenter,    true,     "cntr_no");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    true,     "cntr_tpsz_cd");
                     InitDataProperty(0, cnt++, dtData,      58,     daCenter,    true,     "cntr_bkg_atch_cd");
                     InitDataProperty(0, cnt++, dtData,      50,     daCenter,    true,     "cnmv_irr_stl_flg");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "pre_cnmv_sts_cd");
                     InitDataProperty(0, cnt++, dtData,      70,     daCenter,    false,    "pre_org_yd_cd");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,      false,    "bkg_no2");
                     InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "bkg_split2");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "pre_cnmv_evnt_dt");
                     InitDataProperty(0, cnt++, dtData,      30,     daCenter,    false,    "cnmv_sts_cd");
                     InitDataProperty(0, cnt++, dtData,      70,     daCenter,      false,    "org_yd_cd");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "bkg_no1");
                     InitDataProperty(0, cnt++, dtHidden,    0,      daCenter,    false,    "bkg_split1");
                     InitDataProperty(0, cnt++, dtData,      100,    daCenter,    false,    "cnmv_evnt_dt");
                     InitDataProperty(0, cnt++, dtData,      80,     daLeft,      true,     "Remark");

                     CountPosition = 0;
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
                    if(sheetObj.id == "sheet1") {
                    formObj.f_cmd.value = SEARCH;
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    sheetObj.DoSearch4Fx("EES_CTM_0412GS.do", FormQueryString(formObj));
                    ComOpenWait(false);
                    sheetObj.WaitImageVisible = true;
                    }
                }
            break;

            case IBROWSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)) {
                    formObj.f_cmd.value = SEARCH11;
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    xml = sheetObj.GetSearchXml("CTMCommonGS.do", FormQueryString(formObj));
                    rtnValue = ComGetEtcData(xml, "rtnValue");
                    parseYardMultiCombo(rtnValue, comboObjects[0]);
                    ComOpenWait(false);
                    sheetObj.WaitImageVisible = true;
                }
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
      * IBCombo Object를 배열로 등록
      * param : combo_obj ==> 콤보오브젝트
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
         comboObjects[comboCnt++] = combo_obj;
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }


    function sheet1_OnSearchEnd(sheetObj,  ErrMsg) {

        with(sheetObj) {
        var irow = LastRow+1;

            for (i=2;i<=irow;i++){
                // Booking No컬럼에 값이 있을경우 녹색으로 표시
                if (CellValue(i, "Booking1") == "") {
                    CellBackColor(i,"Booking1") = CellBackColor(i,"TS");
                } else {
                    CellBackColor(i,"Booking1") = RgbColor(0, 255, 0);
                    CellBackColor(i,"Booking2") = RgbColor(0, 255, 0);
                }
                //*********************
                if(CellValue(i, "Booking3") == "") {
                    CellBackColor(i,"Booking3") = CellBackColor(i,"TS");
                } else {
                    CellBackColor(i,"Booking3") = RgbColor(0, 255, 0);
                    CellBackColor(i,"Booking4") = RgbColor(0, 255, 0);
                }
            }
        }
    }


  /* 개발자 작업  끝 */