/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0445.js
*@FileTitle : Booking Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.04 우경민
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
     * @class EES_CTM_0445 : EES_CTM_0445 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0445() {
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

var sheetSelect = false;


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
 		        	 if (!checkFormField()) return;
 		        	 if (checkValidation(formObject))
 		        		 doActionIBSheet(sheetObject,formObject,IBSEARCH)
                     break;

                  case "btn_select":
                     Row = sheetObject.SelectRow;
                     if (Row == '') return;
                     if (Row == '0' || sheetSelect == false) {
                    	 ComShowCodeMessage("CTM30001");
                    	 return;
                     }
                     Sts = sheetObject.CellValue(Row, "mvmt_sts_cd");
                     if (Sts == "VL" || Sts == "VD" || Sts == "EN" || Sts == "TN" || Sts == "MT") {
                    	 ComShowCodeMessage("CTM20054");
                    	 return;
                     }
                     lstRow = sheetObject.LastRow;
                     if (Row == lstRow) {
                    	 ComShowCodeMessage("CTM20107");
                    	 return;
                     }
                     cntrNo = sheetObject.CellValue(Row, "cntr_no");
                     cntrTpsz = sheetObject.CellValue(Row, "cntr_tpsz_cd");
                     checkDigit = sheetObject.CellValue(Row, "check_digit");
                     sealNo = sheetObject.CellValue(Row, "cntr_seal_no");
                     chssNo = sheetObject.CellValue(Row, "chss_no");
                     mgstNo = sheetObject.CellValue(Row, "mgst_no");
                     bkgNo  = sheetObject.CellValue(Row, "bkg_no");
                     vvdNo  = sheetObject.CellValue(Row, "vvd_cd");
                     yardCd = sheetObject.CellValue(Row, "org_yd_cd");
                     cymvNo = sheetObject.CellValue(Row, "cnmv_cyc_no");
                     cnmvCd = sheetObject.CellValue(Row, "cnmv_id_no");
                     cnmvYr = sheetObject.CellValue(Row, "cnmv_yr");
                     mvmtStsCd = sheetObject.CellValue(Row, "mvmt_sts_cd");
                     yd = document.form.yd.value;
                     if (yardCd.substring(0,2) != yd.substring(0,2)) {
                       	 ComShowCodeMessage("CTM10007");
                       	 return;
                     }
                     window.returnValue = sealNo + "|" + chssNo + "|" + mgstNo + "|" + bkgNo + "|" + vvdNo + "|" + yardCd + "|" + cnmvCd + "|" + cnmvYr + "|" + mvmtStsCd + "|" + cntrNo + "|" + cntrTpsz + "|" + checkDigit;
                     document.form.unload_flag.value = "returnValue";
                     window.close();
                     break;

                 case "btn_close":
                     document.form.unload_flag.value = "close";
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
     * 조회조건에 대한 Validation 정리
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function checkValidation(formObject) {
        return true;
    }


     /**
      * IBSheet Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setSheetObject(sheet_obj) {
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
         // OnKeyPress 이벤트
         setEventProcess();
         document.form.p_cntrno.focus();
         sheetObject = sheetObjects[0];
         formObject  = document.form;
         ComBtnDisable("btn_select");

         //doActionIBSheet(sheetObject,formObject,IBSEARCH);

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
                     style.height = 285;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(15, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "Seq.|CYC|STS|Yard|Booking No.|VVD Code|Seal No.|Chassis No.|M.G Set|Cntr No|Tp/Sz";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, dtSeq,     35,    daCenter,  false,    "SEQ");
                     InitDataProperty(0, cnt++, dtData,    35,    daCenter,  false,    "cnmv_cyc_no");
                     InitDataProperty(0, cnt++, dtData,    35,    daCenter,  false,    "mvmt_sts_cd");
                     InitDataProperty(0, cnt++, dtData,    70,    daCenter,  false,    "org_yd_cd");
                     InitDataProperty(0, cnt++, dtData,    115,    daCenter, false,    "bkg_no");
                     InitDataProperty(0, cnt++, dtData,    75,    daCenter,  false,    "vvd_cd");
                     InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "cntr_seal_no");
                     InitDataProperty(0, cnt++, dtData,    80,    daCenter,  false,    "chss_no");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "mgst_no");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "cntr_no");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "cntr_tpsz_cd");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "check_digit");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "cnmv_cyc_no");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "cnmv_yr");
                     InitDataProperty(0, cnt++, dtData,    120,   daCenter,  false,    "cnmv_id_no");

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
                if(validateForm(sheetObj,formObj,sAction))
                if(sheetObj.id == "sheet1") {
                    ComOpenWait(true);
                    sheetObj.WaitImageVisible = false;
                    frmObj = document.form;
                    sheetObj.DoSearch4Fx("EES_CTM_0445GS.do", "f_cmd=" + SEARCH + "&cntr_no=" + formObj.p_cntrno.value + "&check_digit=" + formObj.check_digit.value);
                }
                break;
        }
    }


    /**
     * Sheet1의 OnSearchEnd 이벤트 처리
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        sheetSelect = false;
        if (ErrMsg == "") {
            // 조회결과가 있으면
            if (sheetObj.RowCount > 0) {
                // btn_del 버튼 Enable
                ComBtnEnable("btn_select");
                sheetObj.SelectCell(sheetObj.LastRow, 0);
            } else {
                // btn_del 버튼 Enable
                ComBtnDisable("btn_select");
            }
        }
        ComOpenWait(false);
        sheetObj.WaitImageVisible = true;
    }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }


    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        if (NewRow > 0) sheetSelect = true;
    }


    /**
     * HTML Object의 OnUnLoad 이벤트 처리
     */
    function unloadPage(value) {
        if (value == "returnValue") {
            document.form.unload_flag.value = "";
        } else if (value == "close") {
            window.returnValue = "";
            document.form.unload_flag.value = "";
        }
    }

	/* 개발자 작업  끝 */