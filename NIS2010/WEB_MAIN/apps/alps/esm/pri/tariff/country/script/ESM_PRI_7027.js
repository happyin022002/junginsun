/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7027.js
 *@FileTitle : Country
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
/*************************************************************************************************************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3; [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수 COMMAND01=11; ~
 * COMMAND20=30;
 ************************************************************************************************************************************************************************/

/* 공통전역변수 */
var ipageNo = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

document.onclick = processButtonClick;

function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_New":
			sheetObject.RemoveAll();
			formObject.reset();
			break;

		case "btn_Close":
			self.close();
			break;

		case "btn_OK":
			comPopupOK();
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
 * IBSheet Object를 배열로 등록 comSheetObject(id)에서 호출한다 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		var formObject = document.form;
		if (!(ComIsNull(formObject.cnt_cd) && ComIsNull(formObject.cnt_nm) && ComIsNull(formObject.conti_cd) && ComIsNull(formObject.sconti_cd))) {
			doActionIBSheet(sheetObjects[i], document.form, IBSEARCH);
		}
	}
	initControl();
}

function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

function keypressFormat() {
	obj = event.srcElement;
	if (obj.dataformat == null)
		return;
	window.defaultStatus = obj.dataformat;
	switch (obj.name) {
	case "cnt_nm":
		ComKeyOnlyAlphabet('upper');
		break;
	case "cnt_cd":
		ComKeyOnlyAlphabet('upper');
		break;
	}
}


function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    
    //sheetObj.UseUtf8 = true;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 220;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 5000);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)
                var HeadTitle = "||Seq.|Code|Name" ;
                var headCount = ComCountHeadTitle(HeadTitle);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);
    
                //데이터속성    [	ROW, COL,	DATATYPE, 		WIDTH,	DATAALIGN, 	COLMERGE,	SAVENAME,		KEYFIELD, 	CALCULOGIC,   	DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            	InitDataProperty(0, cnt++ , dtRadioCheck,	20,    	daCenter,  	false,    	"radio",		false,      "",       		dfNone,	    	0,     	true,		true);
            	InitDataProperty(0, cnt++ , dtCheckBox,  	20,    	daCenter,  	false,    	"checkbox",     false,      "",       		dfNone,   		0,     	true,       true);
            	InitDataProperty(0, cnt++ , dtSeq,       	30,    	daCenter,  	false,    	"seq",          false,      "",       		dfNone,   		0,     	false,      true);
                InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	false,    	"cnt_cd",       false,      "",       		dfNone,     	0,     	false,      true);
                InitDataProperty(0, cnt++ , dtData,      	90,   	daLeft,  	false,      "cnt_nm",    	false,      "",       		dfNone,     	0,     	false,      true);
                CountFormat = "[SELECTDATAROW / TOTALROWS]"; 
            }
            break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction, a, PageNo) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction)) {
			return false;
		}
		formObj.f_cmd.value = SEARCHLIST;
		selectVal = FormQueryString(formObj);
		sheetObj.DoSearch4Post("ESM_PRI_7027GS.do", selectVal);
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {

	}
	return true;
}