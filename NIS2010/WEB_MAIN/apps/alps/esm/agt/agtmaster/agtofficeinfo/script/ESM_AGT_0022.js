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
				case "btng_rowadd":
					doActionIBSheet(sheetObject,formObject,IBINSERT);
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
				InitColumnInfo(10, 0 , 0, true);
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;
				var HeadTitle = "Del.|STS|SEQ|Agent|Agent Name|Vendor Code|A/R Office|Del|*|*|";
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				//데이터속성    [ROW, COL,   DATATYPE,    WIDTH,   DATAALIGN,  COLMERGE, SAVENAME,						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,  30,      daCenter,   false,    "delflag",					false,    "",         dfNone,     0,          true,       true);
				InitDataProperty(0, cnt++ , dtStatus,    30,      daCenter,   false,    "ibflag",					false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtSeq,       60,      daCenter,   true,     "sSeq",						false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++ , dtData,      100,      daCenter,   true,     "chn_agn_cd",	true,     "",         dfNone,     0,          false,       true,        2);
				InitDataProperty(0, cnt++ , dtData,     480,      daLeft,     true,     "agn_nm",					false,    "",         dfNone,     0,          true,       true,       50);
				//InitDataProperty(0, cnt++ , dtData,      90,      daCenter,   true,     "vndr_seq",    false,    "",         dfNone,     0,          true,       true,        8);
				InitDataProperty(0, cnt++ , dtData,      110,      daCenter,   true,     "vndr_seq",					false,    "",         dfNone,     0,          true,       true,        6);
				InitDataProperty(0, cnt++ , dtData,      110,      daCenter,   true,     "finc_ofc_cd",				false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtCombo,     20,      daCenter,   true,     "delt_flg",					false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    40,      daCenter,   true,     "bkg_blck_flg",				false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++ , dtHidden,    40,      daCenter,   true,     "old_chn_agn_cd",			false,    "",         dfNone,     0,          false,      false);
				
				InitDataValid(0, "chn_agn_cd", vtEngUpOnly);
				InitDataValid(0, "agn_nm", vtEngOther, " `0123456789-=~!@#$%^&*()_+[]\\;',.{}|:\"?"); // 한글<>/ 제외
				InitDataValid(0, "vndr_seq", vtNumericOnly);	// 숫자만 입력되도록 설정
				//InitDataValid(0, "vndr_seq", vtEngUpOther, "0123456789");	// 영대문자, 숫자만 입력되도록 설정
				InitDataCombo (0,"delt_flg","Y|N","Y|N","N");
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
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0022GS.do", agtQryStr(formObj));
		break;
		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0022GS.do", agtQryStr(formObj));				
		break;
		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.SpeedDown2Excel(-1);
		break;            
		case IBINSERT:      // 입력
			newRow = sheetObj.DataInsert();
			sheetObj.CellValue(newRow, 6) = formObj.finc_ofc_cd.value; // 조회 조건의 Control Office 를 finc_ofc_cd에 설정한다.
		break;
				
	}
}
/**
* Sheet1 의 OnSearchEnd 이벤트처리 <br>
* @param  {object} sheetObj	필수	 Sheet Object
* @param  {string} ErrMsg		필수 String
* @return 없음
* @version 2009.08.24
*/ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	with(sheetObj){
		for (var i = 1; i <= LastRow; i ++){
			if ("Y" == CellValue(i, "delt_flg")){
						RowEditable(i) = false;
			}
		}
	}
}
/**
* Sheet1 의 OnSaveEnd 이벤트처리 <br>
* @param  {object} sheetObj	필수	 Sheet Object
* @param  {string} ErrMsg		필수 String
* @return 없음
* @version 2009.08.25
*/ 
function sheet1_OnSaveEnd(sheetObj, ErrMsg){
	with(sheetObj){
		for (var i = 1; i <= LastRow; i ++){
			if ("Y" == CellValue(i, "delt_flg")){
				RowEditable(i) = false;
			}
		}
	}
}
/**
 * Grid에서 OnChange Event 처리
 */	
function sheet1_OnChange(sheetObj, Row, Col, Value){
	with(sheetObj) {
		if( ColSaveName(Col) == "delflag" ) {
			if(Value == 1) {
				CellValue2(Row, "delt_flg") = "Y";
			} else {
				CellValue2(Row, "delt_flg") = "N";
			}
		}
		
		if( ColSaveName(Col) == "agn_nm" ) {
			sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
		}
		
//		if( ColSaveName(Col) == "chn_agn_cd" ) {
//			CellValue2(Row, "chn_agn_cd") = Value.substring(3);
//		}
	}
}
    
/**
 * 저장 버튼 클릭시 유효성검증 프로세스 처리
 */	
function sheet1_OnValidation(sheetObj, Row, Col, Value) {
//	alert(Value);
//	Value = trim(Value);
	with(sheetObj) {
		var ibStatus = RowStatus(Row);
            if( ibStatus.toUpperCase() == "I" || ibStatus.toUpperCase() == "U" ) {
            	
            	if( ColSaveName(Col) == "vndr_seq" ) {
            		if (Value == "") {
            			ComShowMessage(ComGetMsg("AGT10001", "Vendor Code", "", ""));
                        ValidateFail = true;
                        SelectCell(Row, Col);
/*                        
                    } else if( Value.length > 2 ) {
        	            var vndr_seq = Value.substring(2, Value.length);
        	            if(isNumber2(vndr_seq) == false) {
                            ComShowMessage(ComGetMsg("AGT10017", "Vendor Code", "", ""));
                            ValidateFail = true;
                            SelectCell(Row, Col);
        	            }
*/        	            
        	        }
        	    }
            }
            
    	}
	}

//필수 입력 데이터의 중복 Check////////////////////////////
function validateForm(sheetObj,formObj,sAction){
	var sheetObject = sheetObjects[0];
	var empty ="";
	var emptyCheck = "";
	var emptySplit = new Array();
	switch(sAction) {
		case IBSAVE:
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var chn_agn_cd_check1 = sheetObj.CellValue(i,"chn_agn_cd");
//					empty = empty+sheetObj.CellValue(i,"chn_agn_cd")+";";
					
				}else{
					var chn_agn_cd_check2 = sheetObj.CellValue(i,"chn_agn_cd");
				}
				
				if(chn_agn_cd_check1 == chn_agn_cd_check2){
					ComShowMessage(ComGetMsg('AGT00080', '"'+chn_agn_cd_check1+'" '));
					sheetObj.SelectCell(i, "chn_agn_cd");
			        return false;
				}
//				emptyCheck = empty;
			}
//			emptySplit = emptyCheck.split(";");
//			if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
//				for(var k=0;k<emptySplit.length-1; k++){
//					var emptySplitValue1 = emptySplit[k]; 
//					
//					for(h=1;h<k+1; h++){
//						var emptySplitValue2 = emptySplit[h];
//						alert(emptySplitValue1+","+emptySplitValue2);
//						if(emptySplitValue2 != ""){
//							
//							if(emptySplitValue1 == emptySplitValue2){
//								ComShowMessage(ComGetMsg('AGT00080', '"'+emptySplitValue1+'" '));
//						        return false;
//							}
//						}
//					}
//					
//				}
//			}
		break;
	}
	return true;
}
///////////////////////////////////////////////////////////////
	