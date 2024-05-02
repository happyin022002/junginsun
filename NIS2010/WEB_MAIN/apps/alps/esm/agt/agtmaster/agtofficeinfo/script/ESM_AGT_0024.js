// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
				
			case "btng_rowadd":
			    doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
    	        break;
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ShowErrMessage(getMsg("COM12111", "", ""));
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
				style.height = GetSheetHeight(15) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 16, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(8, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false) ;

				var HeadTitle = "STS|Vessel|Agent Code|A/R Office|*|Vendor Code|Customer Code|Delete";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,   			KEYFIELD, CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtStatus,   50,    daCenter,  false,    "ibflag",			false,    "",         dfNone,		0,     		false,      true);
				InitDataProperty(0, cnt++, dtData,     120,    daCenter,  true,     "vsl_cd",			true,     "",         dfNone,		0,     		false,      true,		4);
				InitDataProperty(0, cnt++, dtData,     150,   daCenter,  true,     "agn_cd",			false,    "",         dfNone,		0,     		true,       true,		6);
				InitDataProperty(0, cnt++, dtData,     150,   daCenter,  true,     "agn_finc_ofc_cd",	false,    "",         dfNone,		0,     		false,      false,		6);
				InitDataProperty(0, cnt++, dtHidden,   100,   daCenter,  true,     "agn_vndr_cnt_cd",	false,    "",         dfNone,		0,     		false,      false);
				InitDataProperty(0, cnt++, dtData,     200,   daCenter,  true,     "agn_vndr_seq",		false,    "",         dfNone,		0,     		true,       true,		6);
				InitDataProperty(0, cnt++, dtData,     200,   daCenter,  true,     "cust_cd",			false,    "",         dfNone,		0,     		true,       true,		8);
				InitDataProperty(0, cnt++, dtCombo,    60,    daCenter,  false,    "delt_flg",			false,    "",         dfNone,		0,     		true,       true);
				
				InitDataValid(0, "vsl_cd", vtEngUpOther, "");	//영대문자만 입력되도록 설정
                InitDataValid(0, "agn_cd", vtEngUpOther, "");	//영대문자만 입력되도록 설정
//                InitDataValid(0, "agn_vndr_seq", vtEngUpOther, "1234567890");//영대문자 + 숫자만 입력되도록 설정
                InitDataValid(0, "agn_vndr_seq", vtNumericOnly, "");
                InitDataValid(0, "cust_cd", vtEngUpOther, "1234567890");//영대문자 + 숫자만 입력되도록 설정
                InitDataCombo(0, "delt_flg", "Y|N", "Y|N","N");
			}
			break;
	}
}

   // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:	  //조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0024GS.do", agtQryStr(formObj));
			break;
			
		case IBSAVE:		//저장
			if(!validateForm(sheetObj,formObj,sAction))	return false;

			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0024GS.do", agtQryStr(formObj));
			break;
			
		case IBINSERT:	  //입력
			var Row = sheetObj.DataInsert();
			sheetObj.CellValue2(Row, "agn_finc_ofc_cd") = formObj.agn_finc_ofc_cd.value;
			sheetObj.SelectCell(Row, "vsl_cd");	
			break;
			
		case IBDOWNEXCEL:  //엑셀내려받기
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}
	
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	var Row = sheetObj.SelectRow;
	switch(sAction) {
		case IBSAVE:
			var cust_cd = sheetObj.CellValue(Row, "cust_cd");
			var agn_vndr_seq = sheetObj.CellValue(Row, "agn_vndr_seq");
			
			if (agn_vndr_seq == "") {
				ComShowMessage(ComGetMsg("AGT10001", "Vendor Code", "", ""));
				ValidateFail = true;
				SelectCell(Row, "agn_vndr_seq");
			}
			
			if (cust_cd == "") {
				ComShowCodeMessage("AGT10001", "Customer Code", "", "");
				ValidateFail = true;
				SelectCell(Row, "cust_cd");
			}
		
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var vsl_cd_check1 = sheetObj.CellValue(i,"vsl_cd");
				}else{
					var vsl_cd_check2 = sheetObj.CellValue(i,"vsl_cd");
				}
				if(vsl_cd_check1 == vsl_cd_check2){
					ComShowMessage(ComGetMsg('AGT00080', '"'+vsl_cd_check1+'" '));
					sheetObj.SelectCell(i, "vsl_cd");
			        return false;
				}
			}
		break;
	}
		
	return true;
//	with(formObj){
//	    if (!ComIsNumber(iPage)) {
//	        return false;
//	    }
//	}
//
//	return true;
}

function sheet1_OnChange(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == "cust_cd") {
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		var custCd = sheetObj.CellValue(row, col);
		if(!ComIsAlphabet(custCd.substring(0,2)) || !ComIsNumber(custCd.substring(2))){
			ComShowCodeMessage('AGT00081', 'Customer CD','','');
			sheetObj.CellValue2(row, col) = "";
		}
	}
}

//Save 성공여부
//function sheet1_OnSaveEnd(sheetObj, ErrMsg){
//	if(ErrMsg == ""){
//		ComShowMessage(ComGetMsg('AGT00079','Success!'));
//	}else{
//		ComShowMessage(ComGetMsg('AGT00079','Fail!'));
//	}
//}
	