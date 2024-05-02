/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0114.js
*@FileTitle : Missing List
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2007-01-15 Kim Jong Beom
* 2009.10.23 김기대 New FrameWork 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => masFormQueryString 변경
*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0114 : ESM_MAS_0114 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0114() {
    this.processButtonClick = processButtonClick ;
    this.loadPage           = loadPage           ;
    this.initSheet          = initSheet          ;
    this.setSheetObject     = setSheetObject     ;
    this.doActionIBSheet    = doActionIBSheet    ;
}



// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

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
	loadingMode = true;
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    for(k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	loadingMode = false;
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
 * IBCombo Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
  var formObj = document.form;

  switch(sheetNo) {
    case 1:      //sheet1 init
        with (sheetObj) {
          style.height = GetSheetHeight(8) ;
          
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
          InitColumnInfo(9, 1, 0, true);
          // 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
          InitHeadMode(true, true, false, true, false, false);
          
          var HeadTitle = "";
          if(formObj.f_strchkprd.value == "W")HeadTitle="YYYY-WW|";
          else HeadTitle="YYYY-MM|";
          HeadTitle=HeadTitle+"Code|Network Cost Item|Trade|R.Lane|IOC|VVD|Create Date|Remark";
          
          //헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
          InitHeadRow(0, HeadTitle, true);

          //데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
          //          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
          //          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
          //          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
          var cnt = 0;
          InitDataProperty(0, cnt++, dtData,    65, daCenter, true, "cost_yrwk",    false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtHidden,  55, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,   150, daLeft,   true, "stnd_cost_nm", false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    50, daCenter, true, "trd_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    55, daCenter, true, "rlane_cd",     false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    40, daCenter, true, "ioc_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    75, daCenter, true, "vvd_cd",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    110, daCenter, true, "cre_dt",       false, "", dfNone, 0, false, false);
          InitDataProperty(0, cnt++, dtData,    1000, daLeft, true, "cost_calc_rmk",       false, "", dfNone, 0, false, false);

          
          HeadRowHeight = 10;
          CountPosition  = 0 ;
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
  sheetObj.ShowDebugMsg = false;
  
  switch(sAction) {
	case IBCLEAR:          //조회
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		formObj.f_cmd.value = INIT;

		var sXml = sheetObj.GetSearchXml("ESM_MAS_0114GS2.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (0 < arrXml.length)
			ComXml2ComboItem(arrXml[0], formObj.f_cobcost, "code", "name");

		ComOpenWait(false);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);  //Load시 조회
		break;

    case IBSEARCH:      //조회
    	// 업무처리중 버튼사용 금지 처리
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
        formObj.f_cmd.value = SEARCHLIST;
		sheetObj.DoSearch4Post("ESM_MAS_0114GS.do", masFormQueryString(formObj));
		ComOpenWait(false);
        break;

  }
}

