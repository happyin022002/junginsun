// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
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

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			break;

			case "btn2_Row_Add":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;

			case "btn2_Row_Copy":
				doActionIBSheet(sheetObject,formObject,IBCOPYROW);
			break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", "", ""));
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
				style.height = GetSheetHeight(16) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(16, 0 , 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				var HeadTitle = "Del.|STS|SEQ|F/Forwarder|Name|Shipper|Name";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,   DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   30,    daCenter,  false,    "",               false,    "",          dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  false,    "ibflag",         false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtSeq,        50,    daCenter,  true,     "sSeq",           false,    "",          dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  true,     "cust_cd_seq",    true,    "",           dfNone,     0,          true,       true,       8);
				InitDataProperty(0, cnt++ , dtData,       220,   daLeft,    true,     "cust_nm",        false,    "",          dfNone,     0,          true,      true);
				InitDataProperty(0, cnt++ , dtPopupEdit,  90,    daCenter,  true,     "shpr_cd_seq",    true,    "",           dfNone,     0,          true,       true,       8);
				InitDataProperty(0, cnt++ , dtData,       210,   daLeft,    true,     "shpr_nm",        false,    "",          dfNone,     0,          true,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "fac_ofc_cd",     false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_cnt_cd",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_seq",       false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_cnt_cd",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_seq",       false,    "",          dfNone,     0,          false,      true);
				
					
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_cnt_cd2",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "cust_seq2",       false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_cnt_cd2",    false,    "",          dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,  true,     "shpr_seq2",       false,    "",          dfNone,     0,          false,      true);
					
				InitDataValid(0, "cust_cd_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정
				InitDataValid(0, "shpr_cd_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정

				//CountPosition  = 0 ;
				style.height = GetSheetHeight(13) ;

			}
		break;
	}
}
/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var newRow = -1;

	switch(sAction) {
		case IBSEARCH:      //조회
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0030GS.do", agtQryStr(formObj));
		break;

		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0030GS.do", agtQryStr(formObj));
		break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.SpeedDown2Excel(-1);
		break;
				
		case IBINSERT:      // 입력
			if(!chkValidSearch()) return false;
			newRow = sheetObj.DataInsert();
			sheetObj.CellValue(newRow, "fac_ofc_cd") = formObj.fac_ofc_cd.value; // 조회 조건의 Office 를 fac_ofc_cd로 설정한다.
		break;

		case IBCOPYROW:        //행 복사
			sheetObj.DataCopy();
		break;

	}
}

/**
 * 검색시 필수입력사항 체크
 */
function chkValidSearch(){
	var formObj = document.form;
	if (formObj.fac_ofc_cd.value == "") {
		ComShowMessage(ComGetMsg("AGT10001", "Office", "", ""));
		formObj.fac_ofc_cd.focus();
		return false;
	}else {
		return true;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	if (formObj.fac_ofc_cd.value == "") {
		ComShowMessage(ComGetMsg("AGT10001", "Office", "", ""));
		formObj.fac_ofc_cd.focus();
		return false;
	}else {
		return true;
	}
}

/**
 * Grid 입력값에 대한 OnChange Event 처리
 */
//	function sheet1_OnChange(sheetObj, Row, Col, Value) {
//
//	    with(sheetObj) {
//
//	        var saveNm = ColSaveName(Col);
//
//            if( ColSaveName(Col) == "cust_cd_seq" || ColSaveName(Col) == "shpr_cd_seq" ) {
//
//                var form1 = document.hiddenF;
//                
////               Value = trim(Value);
//                Value = Value;
//
//               if( checkCustomer(Value) == true ) {
//                   form1.f_cmd.value = SEARCH01;
//                   form1.cust_cd.value = Value;
//                   form1.sheetId.value = sheetObj.id;
//                   form1.row.value = Row;
//                   form1.colNm1.value = ColSaveName(Col);
//                   form1.colNm2.value = ColSaveName(Col+1);
//                   form1.target = "frmHidden";
//                   form1.action = "ESM_AGT_CHKCUST.do";
//                   form1.submit();
//
//                   //DoRowSearch("ESM_AGT_CHKCUST.do", agtQryStr(form1));
//               } else {
//    			   CellValue2(Row, Col) = "";
//    			   CellValue2(Row, Col+1) = "";
//                   SelectCell(Row, Col);
//               }
//           }
//	    }
//	}

/**
 * Customer 조회 팝업 열기
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	if ( sheetObj.ColSaveName(Col) == "cust_cd_seq" || sheetObj.ColSaveName(Col) == "shpr_cd_seq" ) {
		var ofc_cd = sheetObj.CellValue(Row, "fac_ofc_cd");
		var cust_cd = sheetObj.CellValue(Row, Col);
		
		var width = 775;
		var height = 482;
		var func = "sheet1_setFFCntSeq";
		var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
		var chkStr = dispaly.substring(0,3) ;
		if(ofc_cd == "") {
			ofc_cd = document.form.fac_ofc_cd.value;
		}
		if(ofc_cd == "") {
			if(!chkValidSearch()) return false;
		}
		url = "?ofc_cd="+ofc_cd;
		ComOpenPopup('/hanjin/COM_ENS_041.do' + url, 770, 470, 'sheet1_setFFCntSeq', dispaly, true, false, Row, Col, 0);
    }
}

/**
 * 저장 버튼 클릭시 유효성검증 프로세스 처리
 */
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
	Value = trim(Value);
	with(sheetObj) {
		var ibStatus = RowStatus(Row);
		if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
			if ( ColSaveName(Col) == "cust_cd_seq" ) {
				if( checkCustomer(Value) == false ) {
					ComShowMessage(ComGetMsg("AGT10017", "F/Forwarder", "", ""));
					ValidateFail = true;
					SelectCell(Row, Col);
				}
			} else if( ColSaveName(Col) == "shpr_cd_seq" ) {
				if( checkCustomer(Value) == false ) {
					ComShowMessage(ComGetMsg("AGT10017", "Shipper", "", ""));
					ValidateFail = true;
					SelectCell(Row, Col);
				}
			}
		}
	}
}

/**
* Customer 조회 후 값 Return 받아 해당 셀에 셋팅한다.
*/
function sheet1_setFFCntSeq(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	    
//	var cnt_cd = colArray[3].substring(0, 2);
//	var cust_seq = colArray[3].substring(2);
    	
	if(sheetObj.ColSaveName(col) == "cust_cd_seq"){
		sheetObj.CellValue(row, "cust_cd_seq") = colArray[3];
		sheetObj.CellValue(row, "cust_nm") = colArray[4];
	}
    	
	if(sheetObj.ColSaveName(col) == "shpr_cd_seq"){
		sheetObj.CellValue(row, "shpr_cd_seq") = colArray[3];
		sheetObj.CellValue(row, "shpr_nm") = colArray[4];
	}
}

/**
 * Office 조회 팝업 열기
 */
function openWindowOffice(formObj) {
		
	var url = "COM_ENS_071.do";
	var width = 775;
	var height = 460;
	var func = "setOffice";
	var display = "1,0,1";

	ComOpenPopup(url, width, height, func, display, true);
	
//	ComOpenPopup('/hanjin/COM_ENS_071.do', width, height, 'setOffice', dispaly, true, false, Row, Col, 0);
}

/**
 * Office 조회 후 값 Return 받아 셋팅한다.
 */
function setOffice(rowArray, row, col) {
	var colArray = rowArray[0];
	document.form.fac_ofc_cd.value = colArray[3];
}