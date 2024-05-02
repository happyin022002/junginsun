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
			ComShowMessage(ComGetMsg("COM12111", "", ""));
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
				//높이 설정
				style.height = GetSheetHeight(15);

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
				InitColumnInfo(11, 0, 0, true);

				//해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
				InitHeadMode(true, true, false, true, false,false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle = "Del.|STS|SEQ|F/Forwarder|Vendor|Name|*|*|*|*";
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  	DATATYPE,   	WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,   	30,    	daCenter,  	false,    	"del",     	false,      "",       	dfNone,   	0,     		true,       true);
				InitDataProperty(0, cnt++ , dtStatus,     	30,    	daCenter,  	false,    	"ibflag",   false,      "",       	dfNone,   	0,     		false,      false);
				InitDataProperty(0, cnt++ , dtSeq,        	50,    	daCenter,   true,    	"seq",   		false,      "",       	dfNone,     0,     		false,      false);
				InitDataProperty(0, cnt++ , dtPopupEdit, 	120,    daCenter,   true,    	"cust_cnt_ff",     true,       "",       	dfNone, 	0,     		true,       true,		8);
				InitDataProperty(0, cnt++ , dtPopupEdit, 	120,    daCenter,   true,    	"vndr_seq",     true,      	"",       	dfNone, 	0,     		true,       true,		8);
				InitDataProperty(0, cnt++ , dtData,      	200,    daLeft,     true,    	"cust_nm",     false,      "",       	dfNone,     0,     		false,      false,      50);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"cust_cnt_cd",  true,       "",       	dfNone, 	0,     		false,      false,		2);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"cust_seq", true,       "",       	dfNone, 	0,     		false,      false,		6);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"vndr_cnt_cd",  true,      	"",       	dfNone, 	0,     		false,      false,		2);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"vndr_seq2", true,      	"",       	dfNone, 	0,     		false,      false,		6);
				InitDataProperty(0, cnt++ , dtHidden, 		50,    	daCenter,   true,    	"vndr_cnt_cd2",  true,      	"",       	dfNone, 	0,     		false,      false,		2);

				InitDataValid(0, "cust_cnt_ff", vtEngUpOther, "1234567890");	//영대문자 + 숫자만 입력되도록 설정
                InitDataValid(0, "vndr_seq", vtEngUpOther, "1234567890");	//영대문자 + 숫자만 입력되도록 설정
			}
			break;
	}
}

   // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
	    case IBSEARCH:		//조회
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch4Post("ESM_AGT_0025GS.do", agtQryStr(formObj));
			break;

		case IBSAVE:		//저장
			if(!validateForm(sheetObj,formObj,sAction))	return false;
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESM_AGT_0025GS.do", agtQryStr(formObj));
			break;

		case IBINSERT:		//입력
			var Row = sheetObj.DataInsert();
			break;

		case IBDOWNEXCEL:	//엑셀내려받기
			sheetObj.SpeedDown2Excel(-1);
			break;
	}
}

   /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
//	with(formObj){
//		if (!ComIsNumber(pagerows)) {
//			return false;
//		}
//	}
	var checkRow = sheetObj.SelectRow;
	switch(sAction) {
		case IBSAVE:
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var cust_cnt_ff_check1 = sheetObj.CellValue(i,"cust_cnt_ff");
				}else{
					var cust_cnt_ff_check2 = sheetObj.CellValue(i,"cust_cnt_ff");
				}
				if(cust_cnt_ff_check1 == cust_cnt_ff_check2){
					ComShowMessage(ComGetMsg('AGT00083', '"'+cust_cnt_ff_check1+'" '));
					sheetObj.SelectCell(i, "cust_cnt_ff");
			        return false;
				}
			}
			/*
			for(var i = 1; i <= sheetObj.RowCount; i ++){
				if(sheetObj.CellValue(i, "ibflag") == 'I' || sheetObj.CellValue(i, "ibflag") == 'U'){
					var vndr_seq_check1 = sheetObj.CellValue(i,"vndr_seq");
				}else{
					var vndr_seq_check2 = sheetObj.CellValue(i,"vndr_seq");
				}
				if(vndr_seq_check1 == vndr_seq_check2){
					ComShowMessage(ComGetMsg('AGT00083', '"'+vndr_seq_check1+'" '));
					sheetObj.SelectCell(i, "vndr_seq");
			        return false;
				}
			}
			*/
		break;
	}

	return true;
}

/**
 * 시트에서 Biz 공통 팝업 호출
 * - comPopupInSheet() 호출 : row, col 정보를 Parameter로 전달
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	var formObj = document.form;

	//F.Forwarder Popup Click
    if (sheetObj.ColSaveName(col) == "cust_cnt_ff") {
        var cust_cd = sheetObj.CellValue(row,col);
//        alert(cust_cd);
//        alert(formObj.cust_cnt_cd.value);
        if(cust_cd == "") cust_cd = formObj.cust_cnt_cd.value;
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Row PopUp
        var classId = "COM_ENS_041";
	    var param = '?cust_cd=' + cust_cd;
		var chkStr = dispaly.substring(0,3) ;

        if(chkStr == "1,0") {
        	//Radio PopUp
        	ComOpenPopup('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_1', dispaly, true, false, row, col, 0);
        }
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
        	comPopupInSheet('/hanjin/COM_ENS_051.do' + param, 770, 470, 'getESM_AGT_025_2', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row 선택 PopUp
        	comPopupInSheet('/hanjin/COM_ENS_041.do' + param, 770, 470, 'getESM_AGT_025_3', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }*/
    }

	//Vendor Popup Click
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
        var vndr_cd = sheetObj.CellValue(row,col);
//        alert(vndr_cd);
//        alert(sheetObj.CellValue(row,"vndr_cnt_cd"));
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
        var classId = "COM_ENS_0C1";
	    var param = '?vndr_cd=' + vndr_cd;
	    var chkStr = dispaly.substring(0,3);

        if(chkStr == "1,0") {
        	//Radio PopUp
        	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_4', dispaly, true, false, row, col, 0);
        }
        /*
        else if(chkStr == "0,1") {
            //CheckBox PopUp (멀티 데이터 선택용) => Sheet를 대상으로 하는 경우는 의미가 없음
        	comPopupInSheet('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_5', dispaly, sheetIdx, row, col);
        } else if(chkStr == "0,0") {
           	//Row 선택 PopUp
        	comPopupInSheet('/hanjin/COM_ENS_0C1.do' + param, 770, 470, 'getESM_AGT_025_6', dispaly, row, col);
        } else if(chkStr == "1,1"){
           	showErrMessage("팝업을 띄우기 위한 정보가 틀립니다. \n\n예) dispaly속성 앞두자리는 [0,0], [0,1], [1,0] 만 가능합니다.");
           	return;
        } else {
           	showErrMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
           	return;
        }
        */
    }

}

/**
 * F.Forwarder(Customer) : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getESM_AGT_025_1(rowArray, row, col) {
    var sheetObj = sheetObjects[0];

	var colArray = rowArray[0];
	sheetObj.CellValue(row, "cust_cnt_ff") = colArray[3];
	sheetObj.CellValue(row, "cust_nm") = colArray[4];
}

/**
 * Vendor : 팝업에서 Radio로 단일 선택을 한경우..
 */
function getESM_AGT_025_4(rowArray, row, col) {
    var sheetObj = sheetObjects[0];

	var colArray = rowArray[0];
	sheetObj.CellValue2(row, col) = colArray[2];
	sheetObj.CellValue2(row, "vndr_cnt_cd") = colArray[7];
	sheetObj.CellValue2(row, "vndr_seq") = colArray[2];
}

