/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_9001.js
 *@FileTitle : Lane/Port Registration
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.08.03
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 * 2012.08.03 이혜민
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class VOP_VSK_9001 : VOP_VSK_9001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_9001() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Close":
			window.dialogArguments.doActionIBSheet(window.dialogArguments.sheetObjects[0], window.dialogArguments.document.form, COMMAND09);
			window.close();
			break;

		case "btn_RowAdd":
			sheetObject1.DataInsert(-1);
			break;

		case "btn_Delete":
			if(sheetObject1.FindCheckedRow("del_chk")==""){
				ComShowCodeMessage("VSK00010");
			}else if(ComShowCodeConfirm("VSK00005")){ 
				ComRowHideDelete(sheetObject1, "del_chk");
			}
			break;

		case "btn_Save":
			btnSave(sheetObject1);
			
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 280;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(9, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, true, false, false, false);

			var HeadTitle = "||Group|Lane|Lane Name|Dir.|Port|Port Name|AMP Type";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter,   false,	"ibflag", 				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox,		30, daCenter,   true,	"del_chk",			    false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo,	 		65, daCenter,   false,	"usr_def_grp_nm",		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit, 	65, daCenter,   false,	"vsl_slan_cd", 			false, "", dfNone, 0, true, true, 3);
			InitDataProperty(0, cnt++, dtData, 			170, daLeft, 	false,	"vsl_slan_nm",			false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 		65, daCenter, 	false,	"dir_cd",				false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtPopupEdit, 	80, daCenter, 	false,	"port_cd",				false, "", dfNone, 0, true, true, 5);
			InitDataProperty(0, cnt++, dtData, 			120, daLeft, 	false,	"port_nm",				false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtCombo, 	    70, daLeft, 	false,	"amp_tp_cd",			false, "", dfNone, 0, true, true);

			
			InitDataCombo(0, "usr_def_grp_nm", "A|B|C|D|E|F|G|H|I|J|K", "A|B|C|D|E|F|G|H|I|J|K");
			InitDataCombo(0, "dir_cd", " |E|W|N|S", " |E|W|N|S");
			InitDataCombo(0, "amp_tp_cd", "N/A|CNTR|FIXED|", "N|C|F");


			InitDataValid(0, 3, vtEngUpOther, "0123456789");
			InitDataValid(0, 6, vtEngUpOther, "0123456789");
			PopupImage = "/hanjin/img/btns_search.gif";
			ShowButtonImage = 2;

			// uneditable 칼라를 회색이 아닌 흰색으로 변경
			UnEditableColor = RgbColor(255, 255, 255);

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_9001GS.do", sParam);
		sheetObj.LoadSearchXml(sXml);
		ComOpenWait(false);
		break;

	case IBSAVE: // 저장
		var sSaveParam = sheetObj.GetSaveString(true);
		
		// 변경사항이 없으면 거래를 발생시키지 않음
		if(!sheetObj.IsDataModified || sSaveParam==""){
			ComShowCodeMessage('VSK00064');
			return;
		}else{
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var sParam = FormQueryString(formObj) + "&" + sSaveParam;
			var sXml = sheetObj.GetSaveXml("VOP_VSK_9001GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
			ComOpenWait(false);
		}
		break;
		
	case SEARCH02: // vsl_slan_nm 조회
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND12;
		var sParam = FormQueryString(formObj) + "&vsl_slan_cd=" + formObj.tmp_vsl_slan_cd.value;
		var sXml = sheetObj.GetSearchXml("VSK_GLOGS.do", sParam);
		ComOpenWait(false);
		var vsl_slan_nm = ComGetEtcData(sXml, "checkLane");
		return vsl_slan_nm;
		break;

	

	case SEARCH03: // port_nm 조회
		ComOpenWait(true);
		formObj.f_cmd.value = COMMAND13;
		var sParam = FormQueryString(formObj) + "&loc_cd=" + formObj.tmp_port_cd.value;
		var port_cd = formObj.tmp_port_cd.value;
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op_=0043&port_cd="+port_cd, sParam);
		ComOpenWait(false);
		var port_nm = ComGetEtcData(sXml, "port_name");
		return port_nm;
		break;

	}
	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {

}



function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}

function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj = document.form;
	if(Col==3){
		var sUrl = "/hanjin/VOP_VSK_0202.do?intg_cd_id=CD00717";
		ComOpenPopupWithTarget(sUrl, 428, 470, "sheet1_vsl_slan_cd:tmp_vsl_slan_cd|sheet1_vsl_slan_nm:tmp_vsl_slan_nm", "0,0", true);
		if(formObj.tmp_vsl_slan_cd.value != ""){
			sheetObj.CellValue(Row, Col) = formObj.tmp_vsl_slan_cd.value;
			sheetObj.CellValue(Row, Col+1) = formObj.tmp_vsl_slan_nm.value;
			sheet1_OnAfterEdit(sheetObj, Row, Col);
			}
		}
	
	if(Col==6){
		var sUrl = "/hanjin/VOP_VSK_0043.do";
		ComOpenPopupWithTarget(sUrl, 428, 520, "loc_cd:tmp_port_cd|loc_nm:tmp_port_nm", "0,0", true);
		if(formObj.tmp_port_cd.value != ""){
			sheetObj.CellValue(Row, Col) = formObj.tmp_port_cd.value;
			sheetObj.CellValue(Row, Col+1) = formObj.tmp_port_nm.value;
			sheet1_OnAfterEdit(sheetObj, Row, Col);
		}
	}
}

function sheet1_OnAfterEdit(sheetObj, Row, Col){
	
	var formObj = document.form;
	
	// Lane 컬럼에 대해서만 수행
	if(Col==3){
		// Lane 컬럼의 길이가 3일때(Lane 값을 다 입력했을때)
		if(ComChkLen(sheetObj.CellValue(Row, 3), 3)==2){
			
			formObj.tmp_vsl_slan_cd.value = sheetObj.CellValue(Row, Col);
			var vsl_slan_nm = doActionIBSheet(sheetObj, formObj, SEARCH02);
			if(vsl_slan_nm){
				sheetObj.CellValue2(Row, Col+1) = vsl_slan_nm;
			}else{
				ComShowCodeMessage('VSK00021', sheetObj.CellValue(Row, Col));
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.CellValue2(Row, Col+1) = "";
			}
		}	
	}
	// Port 컬럼에 대해서만 수행
	if(Col == 6){
		// Port 컬럼의 길이가 5일때(Port값을 다 입력했을때)	
		if(ComChkLen(sheetObj.CellValue(Row, 6), 5)==2){	
			formObj.tmp_port_cd.value = sheetObj.CellValue(Row, Col);
			var port_nm = doActionIBSheet(sheetObj, formObj, SEARCH03);
			if(port_nm){
				sheetObj.CellValue2(Row, Col+1) = port_nm;
			}else{
				ComShowCodeMessage('VSK00021', sheetObj.CellValue(Row, Col));
				sheetObj.CellValue2(Row, Col) = "";
				sheetObj.CellValue2(Row, Col+1) = "";
			}
		}	
	}
	

}
	
function btnSave(sheetObj){
	
	// Lane 값의 길이가 3이 아닌것 체크
	for(var i=1; i<=sheetObj.LastRow; i++){
		if(sheetObj.CellValue(i, 3)=="" && sheetObj.CellValue(i, 6)==""){
			ComShowCodeMessage('VSK00027', "Lane or Port");
			return false;
		}else if(sheetObj.CellValue(i, 3)!="" && sheetObj.CellValue(i, 6)=="" && ComChkLen(sheetObj.CellValue(i, 3), 3) != 2){
			ComShowCodeMessage('VSK00021', "Lane");
			return false;
		}
		
		if(sheetObj.CellValue(i, 3)!="" && sheetObj.CellValue(i, 5)=="" && sheetObj.CellValue(i,6)==""){
			ComShowCodeMessage('VSK00027', "Dir");
			return false;
		}
	}
	
	// Port 값의 길이가 5이 아닌것 체크
	for(var i=1; i<=sheetObj.LastRow; i++){
		if(sheetObj.CellValue(i, 3)== ""  && sheetObj.CellValue(i, 6)==""){
			ComShowCodeMessage('VSK00027', "Lane or Port");
			return false;
		}else if(sheetObj.CellValue(i, 3)==""  && sheetObj.CellValue(i, 6)!="" && ComChkLen(sheetObj.CellValue(i, 6), 5) != 2){
			ComShowCodeMessage('VSK00021', "Port");
			return false;
		}
	}
	

	
	// 이미 입력한 정보와 비교해서 중복한 값이 있는지 체크한다.
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
			
		if(sheetObj.RowHidden(i)){
			continue;
		}
		
		for(var j=i+1; j<sheetObj.HeaderRows + sheetObj.RowCount; j++){
			if(sheetObj.CellValue(i, 3)!=" " && sheetObj.CellValue(i, 6)!=" "){
				if(sheetObj.CellValue(i, 2) + sheetObj.CellValue(i, 3) + sheetObj.CellValue(i, 5) + sheetObj.CellValue(i, 6) +sheetObj.CellValue(i, 8) == sheetObj.CellValue(j, 2) + sheetObj.CellValue(j, 3) + sheetObj.CellValue(j, 5) + sheetObj.CellValue(j, 6) + sheetObj.CellValue(j, 8)){
					ComShowCodeMessage('VSK00002', "Group=" + sheetObj.CellValue(i, 2) + ", Lane=" + sheetObj.CellValue(i, 3) + ", Dir=" + sheetObj.CellValue(i, 5) + ", Port=" + sheetObj.CellValue(i, 6) + ", AMP=" + sheetObj.CellValue(i, 8));
					sheetObj.CellValue(j, 3) = "";
					sheetObj.CellValue(j, 4) = "";
					sheetObj.CellValue(j, 5) = "";
					sheetObj.CellValue(j, 6) = "";
					sheetObj.CellValue(j, 7) = "";	
					return false;
				}
			}
			//Lane code만 존재할 떄
			if(sheetObj.CellValue(i, 3)!=" " && sheetObj.CellValue(i, 6)==" "){
				if(sheetObj.CellValue(i, 2) + sheetObj.CellValue(i, 3) + sheetObj.CellValue(i, 5)+sheetObj.CellValue(i, 8) == sheetObj.CellValue(j, 2) + sheetObj.CellValue(j, 3) + sheetObj.CellValue(j, 5)+sheetObj.CellValue(j, 8)){
					ComShowCodeMessage('VSK00002', "Group=" + sheetObj.CellValue(i, 2) + ", Lane=" + sheetObj.CellValue(i, 3) + ", Dir=" + sheetObj.CellValue(i, 5)+ ", AMP=" + sheetObj.CellValue(i, 8));
					sheetObj.CellValue(j, 3) = "";
					sheetObj.CellValue(j, 4) = "";
					sheetObj.CellValue(j, 5) = "";
					sheetObj.CellValue(j, 6) = "";
					sheetObj.CellValue(j, 7) = "";	
					return false;
				}
			}
			//Port code만 존재할 때
			if(sheetObj.CellValue(i, 3)==" " && sheetObj.CellValue(i, 6)!=" "){
				if(sheetObj.CellValue(i, 2) + sheetObj.CellValue(i, 6) +sheetObj.CellValue(i, 8) == sheetObj.CellValue(j, 2) + sheetObj.CellValue(j, 6) + sheetObj.CellValue(j, 8)){
					ComShowCodeMessage('VSK00002', "Group=" + sheetObj.CellValue(i, 2) + ", Port=" + sheetObj.CellValue(i, 6)+ ", AMP=" + sheetObj.CellValue(i, 8));
					sheetObj.CellValue(j, 3) = "";
					sheetObj.CellValue(j, 4) = "";
					sheetObj.CellValue(j, 5) = "";
					sheetObj.CellValue(j, 6) = "";
					sheetObj.CellValue(j, 7) = "";	
					return false;
				}
			}

		}
	}		
	
//	for(var i=1; i<=sheetObj.LastRow; i++){
//
//		if(sheetObj.CellValue(i, 3)!="" && sheetObj.CellValue(i, 6)==" " || sheetObj.CellValue(i, 6)==""){
//			sheetObj.CellValue(i, 6) = "LLLLL";
//		}
//		if(sheetObj.CellValue(i, 3)==" " || sheetObj.CellValue(i, 3)=="" && sheetObj.CellValue(i, 6)!=""){
//			sheetObj.CellValue(i, 3) = "LLL";
//			sheetObj.CellValue(i, 5) = "L";
//		}
//	}
	
	doActionIBSheet(sheetObj, document.form, IBSAVE);
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
	
}


function sheet1_OnChange(sheetObj){
	
	for(var i=1; i<=sheetObj.LastRow; i++){
		if(sheetObj.CellValue(i, 3)=="" && sheetObj.CellValue(i, 6)!=""){
			sheetObj.CellValue(i, 4) = ""; //Lane name
			sheetObj.CellValue(i, 5) = ""; //Lane dir
		}
		if(sheetObj.CellValue(i, 3)!="" && sheetObj.CellValue(i, 6)==""){
			sheetObj.CellValue(i, 7) = ""; //Port name
		}
	}
}


