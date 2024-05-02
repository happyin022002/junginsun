/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BSA_0045.js
*@FileTitle      : BSA Data I/F
*Open Issues     :
*Change history  :
*@LastModifyDate : 2011.04.04
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
*=========================================================
* History
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가
*=========================================================
*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btns_calendar1":
				var cal = new ComCalendar();
				cal.select(formObject.txtSDate, 'yyyy-MM-dd');
				break;
			
			case "btns_calendar2":
				var cal = new ComCalendar();
				cal.select(formObject.txtEDate, 'yyyy-MM-dd');
				break;
			
			case "btn_confirm":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			
			case "btn_close":
				window.returnValue = "CANCEL";
				self.close();
				break;

		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	} finally {
    	ComOpenWait(false);
    }
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	 sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for (i=0; i<sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i+1, "");
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// 멀티콤보 처리
	loadingMode = true;
	loadCombo();
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	loadingMode = false;
	
//	comboObjects[0].Code2 = document.form.trade.value;
//	comboObjects[0].Code2 = document.form.lane.value;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,header) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
				style.height = getSheetHeight(8);				// 높이 설정
				SheetWidth = mainTable.clientWidth;				// 전체 너비 설정
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
				MergeSheet = msNone;									//전체Merge 종류 [선택, Default msNone]
				Editable = true;										//전체Edit 허용 여부 [선택, Default false]
				InitRowInfo( 1, 1, 9, 100);								//행정보설정[필.수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(5, 0 , 0, true);							//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, false, true, false,false);		// 해더에서 처리할 수 있는 각종 기능을 설정한다
				var HeadTitle = "STS|From|To|Trade|Lane";
				InitHeadRow(0, HeadTitle, false);						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				
				//데이터속성[ROW,COL,DATATYPE,WIDTH,DATAALIGN,COLMERGE,SAVENAME,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,		cnt++,	dtStatus,	40,		daCenter,	true,	"ibflag");
				InitDataProperty(0,		cnt++,	dtData,	    100,    daCenter,	true,	"bsa_fm_dt",	false,	"",	dfNone,     0,	false,	false);
				InitDataProperty(0,		cnt++,	dtData,		100,	daCenter,	true,	"bsa_to_dt",	false,	"",	dfNone,     0,	false,	false);
				InitDataProperty(0,		cnt++,	dtData,		100,	daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,		cnt++,	dtData,		100,	daCenter,	true,	"rlane_cd",		false,	"",	dfNone,	    0,	false,	false);
			}
			break;
	}
	sheetObj.DataInsert(0);
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

		case IBSAVE:        // 저장
			if (!validateCond(formObj, sAction)) {
				return false;
			}
			
			if (ComShowConfirm(ComGetMsg('BSA10044')) == false) { // 현재 모든 BSA Data를 삭제 합니다.
				return false;
			}
			
			// 업무처리중 버튼사용 금지 처리
            ComOpenWait(true);
            
			if(formObj.opcd.value == "J") { // 계약정보 JO
				formObj.f_cmd.value = MULTI01;
			} else if (formObj.opcd.value == "S") { // 계약정보 SC
				formObj.f_cmd.value = MULTI02;
			} else { // 단가정보
				formObj.f_cmd.value = MULTI03;
			}
			
			var sDate = formObj.txtSDate.value;
			var sEate = formObj.txtEDate.value
			
			sheetObj.CellValue2( 1, 1 ) = sDate.substring(0, 4) + sDate.substring(5, 7) + sDate.substring(8, 10);
			sheetObj.CellValue2( 1, 2 ) = sEate.substring(0, 4) + sEate.substring(5, 7) + sEate.substring(8, 10);
			sheetObj.CellValue2( 1, 3 ) = comboObjects[0].Code;
			sheetObj.CellValue2( 1, 4 ) = comboObjects[1].Code;
			
			sheetObj.DoSave("ESM_BSA_0045GS.do", bsaFormString(formObj,getParam(curPgmNo)), -1, false);
			break;

	}
}

function loadCombo() {
	var formObj = document.form;
	var sXml = formObj.sXml.value;
	
	var arrXml = sXml.split("|$$|");
	
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
	if (arrXml.length > 1)
		ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
	
	document.form.sXml.value="";
 }

/**
* 콤보 항목을 설정한다. by.yjjeon
*/
function initCombo (comboObj, comboNo) {
	with (comboObj) {
		DropHeight = 300;
		comboObj.InsertItem(0, 'All' ,''); 
		Index = 0;
	}
}

/**
* trade코드 변경시 rLane 리스트를 리플래쉬 한다.
*/
function cobTrade_OnChange(obj) {
	if (loadingMode == true) return; 
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var param = "";
	var trd_cd = "";
	sheetObj.WaitImageVisible = false;
	
	if(obj.Text != ""){
		trd_cd = obj.Code;
		param = "f_cmd="+SEARCHLIST01;
		param = param+"&trd_cd="+trd_cd;
		param = param+"&code=rLane";
		var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
		
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
		formObj.cobLane.Index = 0;
	}
	sheetObj.WaitImageVisible = true;
}

/**
* 화면 조회값에 대한 유효성검증 프로세스 처리
*/
function validateCond(formObj, sAction) {
	with(formObj){	
		if (ComTrim(txtSDate.value) == "") {
			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));

			return false;
		}
		
		if (ComTrim(txtEDate.value) == "") {
			ComAlertFocus(txtEDate, ComGetMsg('COM12130','Period','Second Element'));

			return false;
		}
		
		// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
				return false;
			}
		}
	}
	
	return true;
}

function sheet1_OnSaveEnd(sheetObj, errMsg){
	if(errMsg != "" && errMsg != null){
		ComShowMessage(errMsg);
	} else {
		window.returnValue = "reLoad";
		close();
	}
}