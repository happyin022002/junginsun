/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0154.js
*@FileTitle : Space Charter Revenue Missing List
*Open Issues : Lease BSA > 0 & Space Charter Rev = 0 인 항차를 보여준다.
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2008-06-11 Park Chil Seo
* 2008.06.16 박칠서 N200805276923 S.Cht Rev Missing시 팝업 알림
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => coaFormQueryString 변경
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_COA_0154 : ESM_COA_0154 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_COA_0154() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.sheet1_OnSearchEnd = sheet1_OnSearchEnd ;
    this.doActionIBSheet    = doActionIBSheet    ;
}



// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;



/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
  var sheetObject = sheetObjects[0];
  var formObject = document.form;

  try {
    var srcName = window.event.srcElement.getAttribute("name");

    switch(srcName) {

      case "btn_Retrieve":
          doActionIBSheet(sheetObject,formObject,IBSEARCH);
          break;

      case "btn_Close":
          self.close();
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
  for (i=0; i<sheetObjects.length; i++) {
    ComConfigSheet(sheetObjects[i]);
    initSheet(sheetObjects[i], i+1, "");
    ComEndConfigSheet(sheetObjects[i]);
  }

  doActionIBSheet(sheetObjects[0], document.form, SEARCHLIST);  //Load시 조회
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,header) {
  var arrHeader = "";
  var formObj = document.form;

  switch(sheetNo) {
    case 1:      //sheet1 init
        with (sheetObj) {
          //전체 너비 설정
          SheetWidth = mainTable.clientWidth;

          //Host정보 설정[필수][HostIp, Port, PagePath]
          if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

          //전체Merge 종류 [선택, Default msNone]
          MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
          Editable = false;

          //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
          InitRowInfo(1, 1, 9, 100);

          //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
          InitColumnInfo(13, 1, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);

          var HeadTitle="Year|Week|Trade|R.Lane|Vessel|Voyage|Dir|HJS \nBSA|Lease \nBSA|HJS BSA \n(%)|Lease BSA\n(%)|Expense|Income";

          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle, true);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "sls_yrmon",    false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "cost_wk",      false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "trd_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "rlane_cd",     false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "vsl_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "skd_voy_no",   false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    30, daCenter, true, "dir_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daRight, true, "n2nd_fnl_hjs_bsa_capa",       false, "", dfNumber, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daRight, true, "co_bsa_capa",  false, "", dfNumber, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    70, daRight, true, "hjs_bsa_rto",  false, "", dfFloat, 1, false, false);
          InitDataProperty(0, cnt++, dtData,    70, daRight, true, "hjs_bsa_rto",  false, "", dfFloat, 1, false, false);
          InitDataProperty(0, cnt++, dtData,    80, daRight, true, "expn",         false, "", dfFloat, 1, false, false);
          InitDataProperty(0, cnt++, dtData,    30, daRight, true, "incm",         false, "", dfFloat, 1, false, false);

          HeadRowHeight = 30;
          CountPosition  = 0 ;
          style.height = GetSheetHeight(8) ;


        }
        break;

  }
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
* sheet1조회후 상단 정보 세팅
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    if(ComShowConfirm(ComGetMsg('COA10033')) == true) {
        opener.processButtonClick("btn_applytopl_step2");
    }

}



// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;

  switch(sAction) {

    case SEARCHLIST:      //조회
    	// 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
        formObj.f_cmd.value = SEARCHLIST;
        sheetObj.DoSearch4Post("ESM_COA_0154GS.do", coaFormQueryString(formObj));
        ComOpenWait(false);
        break;

  }
}


