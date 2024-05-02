// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 
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
	var formObj = document.form;
	var sheetObj = sheetObjects[0];		
	if(formObj.s_csr_no.value != ""){
		doActionIBSheet(sheetObj,formObj,IBSEARCH);            
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
				//높이 설정
				style.height = GetSheetHeight(16);
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   	//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 1000);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 1, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, true, true, false, false) ;

				var HeadTitle1 = "BKG No.|G.Rev.|N.Rev.|Vol.|O/B|I/B|T/S,T/R|CHF|Brokerage|Doc/Oth|DMDT|VSL Oper.";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);


				//데이터속성  [ROW, COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(0, cnt++ , dtStatus,	30,		daCenter,  	true,		"ibflag",	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtData,			90,		daCenter,   true,    	"bkg_no",     false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,   true,    	"g_rev",    false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	100,	daRight,   true,    	"n_rev", 	false,		"",			dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,   true,    	"qty",		false,		"",			dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,   true,    	"out_bound",	false,	"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,   true,    	"in_bound",	false,		"",			dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,   true,    	"trans",	false,		"",			dfFloat,		2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,    true,    	"chf",   false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,    true,    	"brog",    false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,    true,    	"doc_oth",    false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,    true,    	"dmdt",     false,		"",			dfFloat,	2,			false,		false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	100,	daRight,    true,    	"vsl_opr",     	false,		"",			dfFloat,	2,			false,		false);

				//전체선택시 이벤트 발생안함
                AllowEvent4CheckAll = false;
			}
			break;
	}
}

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
				
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case "btn_close":
				  window.close();
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

	switch(sAction) {
	    case IBSEARCH:		//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;

			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0053GS.do", agtQryStr(formObj));
			
			break;
			
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		
		switch(sAction) {
		    case IBSEARCH:	//Retrieve

		    	break;
		    	
		    case IBSEARCH_ASYNC01:	//Detail
				//선택건수 체크(Header가 2줄이므로, SelectRow가 2보다 작으면 선택한 행이 없는것임)
				var sRow = sheetObj.SelectRow;
				if(sRow < 2){
					ComShowCodeMessage("COM12113", "row for detail information", "", "");
					return false;
				}	  
				break; 
	}
	return true;
}

}
	
