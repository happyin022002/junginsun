var sheetObjects = new Array();
var sheetCnt = 0;

document.onclick = processButtonClick;

function processButtonClick(){

	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;

			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

	  		case "btn_downexcel":
				doActionIBSheet(sheetObj,formObj,IBDOWNEXCEL);
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
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
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, document.form.row_size.value);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "SEQ|Customer\nCode|S/C No.|Customer\nType|contient|sub\ncontient|country|POR/DEL|Location|Contact Person|Telephone No|E-Mail Address|Fax No.|Sendng Cycle" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE,	   SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,  true,	 "r_seq",			false,		  "",	   dfNone,   		0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  false,	"r_crm_cust_cd",	false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   80,	daCenter,  true,	 "r_sn_no",		  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_cust_tp_cd",	 false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_conti_cd",	   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_sconti_cd",	  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  true,	 "r_cnt_cd",		 false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	 "por_del_div_cd",   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   60,	daCenter,  true,	 "loc_cd",		   false,		  "",	   dfNone,  		0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  120,	daLeft,	   false,	"cntc_pson_id",	 false,		  "",	   dfNone,		 0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  false,	"phn_no",		   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	  120,	daCenter,  false,	"vis_eml",		  false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   90,	daCenter,  false,	"fax_no",		   false,		  "",	   dfNone,	 	0,	 false,	   false);
				InitDataProperty(0, cnt++ , dtData,	   70,	daCenter,  true,	 "snd_cyc_hr",	   false,		  "",	   dfNone,	 	0,	 false,	   false);

				style.height = GetSheetHeight(16) ;
		   }
			break;
	}
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:
	   		formObj.f_cmd.value = SEARCHLIST ;
			sheetObj.DoSearch4Post("ESD_SCE_0034GS.do", SceFrmQryString(formObj))
			break ;

		case IBDOWNEXCEL:		// excel down
			sheetObj.SpeedDown2Excel();
			break;
	}
}

function sheet_OnScrollNext(sheetObj,CondParam, PageNo, OnePageRow){
    var formObj = document.form ;
    selectVal = SceFrmQryString(formObj);
    sheetObj.DoSearch4Post("ESD_SCE_0034GS.do", selectVal, "cur_page=" + PageNo, true);
}