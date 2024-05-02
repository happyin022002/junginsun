
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

        	    case "btn_close":
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
		case 1:	  //IBSheet1 init
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
				InitRowInfo( 2, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(16, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "SEQ|F/M|Event|Current|Current|Current|Current|Carrier|MD|Rail Origin|Rail Origin|Rail Destination|Rail Destination|Rail Destination|Train/Truck|Flat Car" ;
				var HeadTitle1 = "SEQ|F/M|Event|Location|State|Event Date|Event Date|Carrier|MD|Location|State|Location|State|Description|Train/Truck|Flat Car" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				InitHeadRow(1, HeadTitle1, true);

				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,	   30,	daCenter,  true,	"",	 false,		  "",	   dfNone,   		0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"full_mty_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   100,	daCenter,  true,	"clm_sght_abbr_nm",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   230,	daCenter,  true,	"loc_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"arr_ste_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	"arr_date",	 false,		  "",	   dfDateYmd,  	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"arr_time",	 false,		  "",	   dfTimeHm,   	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"clm_crr_nm",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   30,	daCenter,  true,	"trsp_mod_tp_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  100,	daCenter,  true,	"fm_nod_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"fm_ste_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  100,	daCenter,  true,	"to_nod_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"to_ste_cd",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  150,	daCenter,  true,	"dep_loc_nm",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  true,	"trn_no",	 false,		  "",	   dfNone,	 	0,	 true,	   true);
				InitDataProperty(0, cnt++ , dtData,	   50,	daCenter,  true,	"fcar_no",	 false,		  "",	   dfNone,	 	0,	 true,	   true);

				style.height = GetSheetHeight(16) ;
				RangeBackColor(1, 3, 1, 13) = RgbColor(222, 251, 248);   // ENIS

				var formObject = document.form;
			}
			break;
	}
}
  
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	   case IBSEARCH:	  //조회
	   		formObj.f_cmd.value = SEARCHLIST ;
				sheetObj.DoSearch4Post("ESD_SCE_0044GS.do",SceFrmQryString(formObj));
				formObj.f_cmd.value = SEARCH01 ;
				sheetObj.DoSearch4Post("ESD_SCE_0044GS.do",SceFrmQryString(formObj));
				ComEtcDataToForm(formObj,sheetObj);
			break;
	}
}

function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0044GS.do", selectVal, "cur_page=" + PageNo, true);
}