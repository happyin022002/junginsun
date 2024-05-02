/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0927.js
*@FileTitle : Confirmation Message Send Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-11-23 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
/**
 * @class ESD_TRS_0927 : Confirmation Message Send Popup
 */
function ESD_TRS_0927() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var opensheetObject = opener.sheetObjects[0];
var sheetObjects = new Array();
var sheetCnt = 0;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	
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
				style.height = 240; // 높이 설정
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(19, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				var HeadTitle = "STS|Container No|SN|Related Trucker Code|Related Trucker Name|Related Trucker Fax No|Related Trucker E-Mail Address|"
                +"Shipper Name|Shipper Fax Number|Shipper E-mail Address|Sent User|Sent Time|Sent Type";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtStatus, 30, daCenter, true, "ibflag");      
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "eq_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "snd_seq");
				InitDataProperty(0, cnt++, dtPopupEdit, 150, daCenter, true, "rlt_trkr_seq", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "rlt_trkr_nm", false, "", dfEngUpKey, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "rlt_trkr_fax_no", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "rlt_trkr_eml", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "shpr_cust_nm", false, "", dfEngUpKey, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "shpr_fax_no", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtData, 200, daCenter, true, "shpr_eml", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "snd_usr_id", false, "", dfEngUpKey, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "snd_dt", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "snd_tp_cd", false, "", dfNone, 0, true, true);

				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "trsp_so_seq", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "msg_tp_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "eq_tpsz_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "snd_ofc_cd", false, "", dfNone, 0, true, true);
				InitDataProperty(0, cnt++, dtHidden, 9, daCenter, true, "snd_yn", false, "", dfNone, 0, true, true);
			}
		break;
	}
}

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
			case "btng_rowadd":
				doRowInsertData(sheetObject);	
			break;

			case "btng_send":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;

			case "btng_delete":
				doRowDeleteData(sheetObject);
			break;

			case "btn_close":
				window.close();
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH02;
			formObj.f_trsp_so_ofc_cty_cd.value = opener.parmOfccd;
			formObj.f_trsp_so_seq.value = opener.parmSoseq;
			sheetObj.DoSearch4Post("ESD_TRS_0927GS.do", TrsFrmQryString(formObj));
		break;

		case IBSAVE:        //저장
			formObj.f_cmd.value = MULTI01;
			if( sheetObj.CellValue(1, "snd_yn") != "Y" ) {
				sheetObj.RowStatus(1) = "I";
			}
			sheetObj.DoSave("ESD_TRS_0927GS.do", TrsFrmQryString(formObj), false, false);
		break;
	}
}

/*
 * 위의 Row를 copy하여 아래의 Row에 복사
 */
function doRowInsertData(sheetObj) {
	var rows = sheetObj.RowCount;
	sheetObj.DataInsert(rows+1);
	for (ic = 1; ic<=sheetObj.LastCol; ic++) { //체크 컬럼은 빼고 옮김
		sheetObj.CellValue2(rows+1, sheetObj.ColSaveName(ic)) = sheetObj.CellValue(rows, sheetObj.ColSaveName(ic));
	}
}

/*
 * 아래의 Row를 삭제
 */
function doRowDeleteData(sheetObj) {
	if( sheetObj.CellValue(sheetObj.RowCount, "ibflag") == "I" ) {
		sheetObj.RowDelete(sheetObj.RowCount, false);
	} else {
		errMsg = ComGetMsg("TRS90111");
		ComShowMessage(errMsg);
	}
}

/**
 * 저장결과 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSaveEnd에서 정의
 */
function sheet_OnSaveEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg = ComGetMsg("TRS90043");
		ComShowMessage(errMsg);
		window.close();
	}
}

/**
 * 조회결과 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj, errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	}
}

/*
 * IBSheet에서 Pop-Up창 띄우기
 */
var doc_row = "";
function sheet_OnPopupClick(sheetObj, row, col) {
	doc_row = row;
	rep_OnPopupClick();
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_rep";
		var xx1="";  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 695, 400, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		sheetObjects[0].CellValue2(doc_row, "rlt_trkr_seq") = colArray2;
	}
}