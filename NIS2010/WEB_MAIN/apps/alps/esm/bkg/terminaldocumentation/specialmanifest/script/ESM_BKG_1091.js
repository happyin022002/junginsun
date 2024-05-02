/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0969.js
 *@FileTitle : ESM_BKG_0969
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.07
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2009.05.07 경종윤
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
 * @class ESM_BKG_0969 : ESM_BKG_0969 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0969() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_Select":
			// ComShowMessage("Under Construction!");
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;

		case "btn_Close":
			self.close();
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var form = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	if (form.bay_pln_id.value != "") {
		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	}

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetId = sheetObj.id;

	switch (sheetId) {

	case "sheet1":
		with (sheetObj) {

			// 높이 설정
			style.height = 300;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Sel.|Seq.|Container No|Cell Position|Gross Weight|Wgt Unit|TP/SZ(ISO)|"
					+ "POL|POD|F/M|Operator|Class|Un No.";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, false, true, false,false)
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, 	"ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, 	daCenter, true, 	"chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDataSeq, 30, 	daCenter, false, 	"seq");
			InitDataProperty(0, cnt++, dtData, 100, 	daCenter, true, 	"eur_dg_cntr_id", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, 		daCenter, true,		"cell_psn_no", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, 	daRight,  true, 	"grs_wgt", 			false, "", dfFloat, 3, false, false);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, true, 	"cntr_wgt_ut_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, 		daCenter, true,		"iso_cntr_tpsz_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, true, 	"pol_cd",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, true, 	"pod_cd",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 30, 		daCenter, true,		"eur_dg_full_mty_cd", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, 		daCenter, true,		"cntr_opr_id", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 50, 		daCenter, true,		"imdg_clss_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, 		daCenter, true,		"imdg_un_no", 		false, "", dfNone, 0, false, false);

			CountPosition = 2;

			WaitImageVisible = false;

			// 틀고정 설정 (cntr_no)
			FrozenCols = 5;

		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;

		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_1091GS.do", FormQueryString(formObj));
		ComOpenWait(false);
		break;

	case COMMAND01: // select

		if(!validateForm(sheetObj,formObj,sAction)) return false;

		var arrSaveData = getCheckedRowsByColNames(sheetObj, "chk", "eur_dg_cntr_id|cell_psn_no" );
		
		var obj = new Object();
		 obj = arrSaveData ; 
		 if(obj != undefined && obj.length > 0) {
			 window.returnValue = obj;
			 self.close();
		 }
		
		break;

	}
}

/**
 * Check된 값을 Array에 담아 넘겨준다.
 * @param sheetObj sheet Object
 * @param chkName Sheet내 Check Save이름
 * @param colName 넘겨받을 Column 리스트(a|b|c...)
 * @return
 */
function getCheckedRowsByColNames(sheetObj,chkName,colName) {
    var checkRows;
    var colsCnt = sheetObj.LastCol + 1;
    var rows = sheetObj.Rows;

    var rArray = null; // 행데이터를 담고 있는 배열
    var cArray = null; // 열데이터를 담고 있는 배열
    var colNameArr = null; 
    var colNameArrLength = 0;
    var tmpValue = "";

    checkRows = sheetObj.CheckedRows(chkName);

    if(checkRows == 0) {
        return null;
    }else {
    	
    	
      var idx = 0;
      rArray = new Array(checkRows);

      if(colName != undefined && colName != "") {
	      colNameArr = colName.split("|");
	      colNameArrLength = colNameArr.length;
      }
      
      for(var i = 0; i < rows; i++) {
        if(sheetObj.CellValue(i, chkName) == 1) {
            cArray = null;
            // 특정 컬럼명이 지정된 경우
            if(colName != null && colName != "") {
            	tmpValue = "";
            	for(var ii=0; ii<colNameArrLength; ii++) {
            		tmpValue += sheetObj.CellValue(i, colNameArr[ii]);
            		if(ii < colNameArrLength-1) {
            			tmpValue += "|";
            		}
            	}
        		cArray = tmpValue;
            } else {
              cArray = new Array(colsCnt);

              for(var j=0; j<cArray.length; j++) {
                        cArray[j] = sheetObj.CellValue(i, j);
                      }
                  }
                  rArray[idx++] = cArray;
           }
        }
      }
      return rArray;
  }

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

	var sheet1RowCnt = sheetObj.RowCount;

	switch (sAction) {
		case IBSEARCH: { // 조회
	
			// 기본포멧체크
			if (!ComChkValid(formObj))
				return false;
			break;
		}
		case COMMAND01: {
			if(formObj.openType.value != "2") { // 메인 페이지에서 팝업으로 open아니면
				return false;
			}
			
			if(formObj.currMainPageListCnt.value == "0") { // 메인 페이지 sheet에 조회된 건이 0건이면
				//ComShowMessage("메인페이지에 조회된 결과가 없습니다.!");
				ComShowMessage("Results are viewed on the main page!");
				
				return false;
			}
			
			break;
		}
	}

	return true;
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {
	// alert("데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event \n" + "Row : " + Row + "\n" +
	// "Col : " + Col);
	// alert("Forwarder Name이 Dangerous Cargo Inquiry 화면에 해당 칼럼에 자동 기입되고 화면은
	// 닫힘.");

	// var obj = new Object();
	//		   
	// obj.cd = sheetObj.CellValue(Row, "eur_dg_cntr_id");
	// obj.nm = sheetObj.CellValue(Row, "cell_psn_no");
	//		
	// if(obj.cd !="" && obj.nm != "") {
	// window.returnValue = obj;
	// self.close();
	// }
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (srcName == "bay_pln_id" && ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * 조회 처리 후 이벤트
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.checkAll2("chk") = 0;
}

/* 개발자 작업 끝 */