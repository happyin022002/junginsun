// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 
 * IBSheet Action 추가 
 */
var IBCONFIRM = 21;	//Confirm
var IBCLOSE   = 22;	//Close

/* 
 * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
 */
document.onclick = processButtonClick;

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
	    //시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
	    //마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//ESM_AGT_010 화면에서 넘겨받은 파라미터로 조회
    var formObj = document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
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
				//높이 설정
				style.height = 0;
				
				//전체 너비 설정
				SheetWidth = 0;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
			    //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);
	
				//해더기능설정[선택][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "apro_no|bl_no|agn_cd|io_bnd_cd|ac_seq|act_if_comm_amt|act_if_locl_comm_amt";
				InitHeadRow(0, HeadTitle, true);
	
				//데이터속성    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "apro_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_locl_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				//CountPosition  = 0 ;
			}
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
				//높이 설정
				style.height = GetSheetHeight(12);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(9, 0, 0, true);
//				InitColumnInfo(7, 0, 0, true);
				//해더기능설정[선택][SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "STS|BKG No|B/L No|AGN CD|I/O|SEQ|USD Amount|PYMT Amount";
//				var HeadTitle = "BKG No|B/L No|AGN CD|I/O|SEQ|USD Amount|PYMT Amount";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,   DATATYPE,  WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHidden,    30,    daCenter,  false,    "ibflag",  false,    "",         dfNone,     0,          false,      true);
				InitDataProperty(0, cnt++, dtData,    125,   daLeft,  true,     "bkg_no",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtData,    125,   daCenter,  true,     "bl_no",   false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "agn_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "io_bnd_cd",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ac_seq",  false,    "",         dfNone,     0,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtAutoSum, 100,   daRight,   true,     "act_if_locl_comm_amt",       false,    "",         dfFloat,    2,          false,      false);
				InitDataProperty(0, cnt++, dtHidden,  100,   daCenter,  true,     "ar_ofc_cd",  false,    "",         dfNone,     0,          false,      false);
				//CountPosition  = 0 ;
			}
			break;
			
		
		
	}
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;	
			case "btn_confirm":
				doActionIBSheet(sheetObject1,formObject,IBCONFIRM);
				break;
				
			case "btn_close":
				doActionIBSheet(sheetObject1,formObject,IBCLOSE);
				break;
		} // end switch
		
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111", "", "");
		} else {
			ComShowMessage(e);
		}
	}
}

/*
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	switch(sAction) {
	    case IBSEARCH:		//조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;

	    	formObj.f_cmd.value = SEARCH;
	    	sheetObj.DoSearch4Post("ESM_AGT_0036GS.do", agtQryStr(formObj));
//			alert(sheetObjects[0].CellValue(1, "apro_no"));
			if(sheetObject.cellValue(1, "apro_no")!=null){
        		formObj.s_apro_no.value = sheetObject.cellValue(1, "apro_no");
        	}

			var bkgNoArray = new Array();
			bkgNoArray = formObj.sheet.value;
			var bkgNoArraySplit = bkgNoArray.split(",");
			var queryVal = "";
			for(j=0;j<bkgNoArraySplit.length; j++){
				if(j < bkgNoArraySplit.length-1){
					queryVal += bkgNoArraySplit[j]+"','";
				}else{
					queryVal += bkgNoArraySplit[j];
				}
			}
			
			formObj.arr_val.value = "'"+queryVal+"'";
			
			formObj.f_cmd.value = SEARCH01;
			
	    		

			sheetObject1.DoSearch("ESM_AGT_0036GS.do", agtQryStr(formObj));
			
			break;
		case IBCONFIRM:
			if(!validateForm(sheetObjects[1],formObj,sAction))	return false;
			formObj.f_cmd.value = MODIFY;
//			alert(agtQryStr(formObj));
//			alert(sheetObject1.GetSaveString(true));
			sheetObject1.DoAllSave("ESM_AGT_0036GS.do", agtQryStr(formObj));
			window.close();
			break;	

		case IBCLOSE:
			window.close();
			break;	
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction) {
	with(formObj){
//		if (!isNumber(iPage)) {
//			return false;
//		}
		
		switch(sAction) {
		    case IBSEARCH:	//조회
				break;
			case IBCONFIRM:	//승인
				var approvalNo = formObj.s_apro_no.value;
//				alert("approvalNo="+approvalNo);
				if (approvalNo == "") {
					//[COM12114]Please check **
					ComShowMessage(ComGetMsg("COM12114", "Approval No", ""));
					return false;
				}
				
				row = sheetObj.SelectRow;
				if(row < 1){
					//[COM12114]Please check **
					ComShowMessage(ComGetMsg("COM12114", "retrieved data", "", ""));
					return false;
				}	  
				break; 
		}			
	}

	return true;
}

