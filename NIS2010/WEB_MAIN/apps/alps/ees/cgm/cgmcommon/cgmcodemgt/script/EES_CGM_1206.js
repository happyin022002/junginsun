/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_CGM_1206.js
 *@FileTitle : Neutral Pool Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.03.08
 *@LastModifier : 이영헌
 *@LastVersion : 1.0
 * 2013.03.08 이영헌
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
 * @class ees_cgm_1206 : ees_cgm_1206 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1206() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt     = 0;

var comboObjects = new Array();
var comboCnt = 0;

var poolArr = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObj    = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;
	var change = 0;
	var chkDel = 0;
    var sheet1RowCnt = sheetObjects[0].RowCount;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				// IBSHEET 조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
	
			case "btn_new":
				//초기화 함수 호출
				objectClear();
				break;
				
			case "btn_save":
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.CellValue(i,"ibflag")!='I' && sheetObj.CellValue(i,"ibflag")!='U' && sheetObj.CellValue(i,"ibflag")!='D'){
						change = change+1;
					}
				}
				if(change == sheet1RowCnt){
					ComShowMessage("Data was not changed!");
					break;
				}
				ComOpenWait(true);
				if(validateForm(sheetObj,formObj,srcName)){
					if(ComShowCodeConfirm('CGM10047')){
						doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
					}
				}
				ComOpenWait(false);
				break;
				
			case "btns_vndr":	// Lessor Code 가져오기 팝업
				ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
				break;
				
			case "btn_RowAdd":
				sheetObj.DataInsert(-1);
				break;
				
			case "btn_RowDel":
				for(var i=1; i <= sheet1RowCnt; i++) {
					if(sheetObj.CellValue(i, "del_chk")){
						chkDel = chkDel+1;
					}
				}
				if(chkDel == 0){
					ComShowMessage("You did'nt check any Rows!");
					break;
				}
				if(ComShowConfirm('Do you want to delete it?')){
					ComRowHideDelete(sheetObj, "del_chk");
				}
				break;
				
			case "btn_downexcel":
				doActionIBSheet(sheetObjects[0],document.form,"btn_downexcel","","");
				break;
				
			case "btn_loadexcel":
				doActionIBSheet(sheetObjects[0],document.form,"btn_loadexcel");
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 
 /** 
  * Combo Object 초기화  <br>
  * @param  {object} comboObj	필수 Combo Object
  * @return 없음
  * @author 
  * @version 2013.03.25
  */ 
 function initCombo(comboObj) {
	 switch(comboObj.id) {
	 	case "chss_pool_cd":
	 		var cnt=0;
	 		with(comboObj) {
	 			Code = "";
	 			Text = "";
	 			DropHeight = 100;
	 			MultiSelect = false;
	 			MaxSelect = 1;
	 			UseCode = true;
	 			Enable = true;
	 			comboObj.UseAutoComplete = true;
	 		}
	 		break;
	 }
 }


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// 시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// 마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// IBMultiCombo 초기화
	comboObjects[comboCnt++] = document.chss_pool_cd;
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k]);
	}
	
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	initControl();
}
 
//Axon 이벤트 처리
function initControl() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	axon_event.addListenerFormat('beforedeactivate',    'obj_blur',     form);   //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	axon_event.addListenerFormat('focus',   'obj_focus',    form);   //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keydown',	'obj_keydown',	form);   //- 키 눌렸을때
	axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
	axon_event.addListenerFormat('keypress','obj_keypress',	form);   //- 키 눌렸을때 
	
	// Multi Combo 초기화
 	document.chss_pool_cd.Text2 = "";
 	
 	// Sheet Object 초기화
 	sheetObj.RemoveAll();
}

////Axon 이벤트 처리2. 이벤트처리함수
//function obj_blur(){
//	var formObj = document.form;
//	var obj = event.srcElement;
//	
//    if (event.srcElement.name == "eff_month"){
//   		ComAddSeparator(formObj.eff_month, "ym");
//    }
//}
//
////Axon 이벤트 처리2. 이벤트처리함수
//function obj_focus(){
//	var formObj = document.form;
//	var obj = event.srcElement;
//	
//    if (event.srcElement.name == "eff_month"){		
//    	ComClearSeparator(formObj.eff_month, "ym");
//    	ComSetFocus(formObj.eff_month);
//    }	
//}

function obj_keypress(){    
    obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    
    switch(obj.dataformat) {
    	case "int":
	    	ComKeyOnlyNumber(obj);
	        break;
	        
        case "engup":
        	if(obj.name == "chss_pool_cd") {
	            ComKeyOnlyAlphabet('upper');
        	}else{
        		ComKeyOnlyAlphabet('uppernum');
        	}
            break;
    }        
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
			style.height = 420;

			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);

			var HeadTitle = "ibflag||Seq.|Pool Code|Pool Name|Vendor Code|Vendor Name|Creation Date|By Creation";
			var headCount = ComCountHeadTitle(HeadTitle);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			// 데이터속성 [ROW,	COL,	DATATYPE,		WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,	KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	false,	"seq");
			InitDataProperty(0, cnt++,	dtData,			100,	daCenter,	false,	"chss_pool_cd",		true,	"",	dfNone,			0, false, true, 4);
			InitDataProperty(0, cnt++,  dtData,			250,  	daLeft,		false,	"chss_pool_nm",		false,	"",	dfNone,			0, true, true, 100);
			InitDataProperty(0, cnt++,  dtPopupEdit,	100,	daCenter,	false,	"vndr_seq",			false,	"",	dfNone,			0, true, true, 6);
			InitDataProperty(0, cnt++,  dtData,			250,	daLeft,		false,	"vndr_lgl_eng_nm",	false,	"",	dfNone,			0, false, false, 100);
			InitDataProperty(0, cnt++,  dtData,			100,	daCenter,	false,	"cre_dt",			false,	"",	dfUserFormat,	0, false, false, 8);
			InitDataProperty(0, cnt++,  dtData,			100,	daCenter,	false,	"cre_usr_id",		false,	"",	dfNone,			0, false, false, 20);
			
			InitDataValid(0, "chss_pool_cd", vtEngUpOnly);
			InitDataValid(0, "vndr_seq", vtNumericOnly);
			InitUserFormat(0, "cre_dt", "####-##-##", "-");
			
			ShowButtonImage = 4;
			
			ImageList(0) = "/hanjin/img/btns_search.gif";
			DataLinkMouse("vndr_seq") = true;
		}
		break;
	}
}


//SHEET 관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	switch (sAction) {

		// SEARCH LOGIC
		case IBSEARCH:
			ComOpenWait(true);
			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value = SEARCH;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("EES_CGM_1206GS.do", sParam);
			sheetObj.loadSearchXml(sXml);
			ComOpenWait(false);
			break;
			
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1206GS.do", FormQueryString(formObj));
			var poolCd = ComGetEtcData(sXml, "pool_cd");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(poolCd == "" || State != "S"){
				formObj.chk_chss_pool_cd.value = "";
				break;
			}else{
				formObj.chk_chss_pool_cd.value = poolCd;
			}
			break;
			
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			sheetObj.WaitImageVisible = false;
			
			var sXml = sheetObj.GetSearchXml("EES_CGM_1206GS.do", FormQueryString(formObj));
			var valResult = ComGetEtcData(sXml, "vndr_nm");
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(valResult == "" || State != "S"){
				ComShowCodeMessage('CGM20023', "Vendor Code");
				formObj.vndr_nm.value = "";
				break;
			}else{
				formObj.vndr_nm.value = valResult;
			}
			break;
			
		case IBSEARCH_ASYNC01:	// Pool Code Combo 조회
	       	formObj.f_cmd.value = SEARCH03;
			var idx = 0
	   		var sXml = sheetObj.GetSearchXml("EES_CGM_1206GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			poolArr.length = 0;
			
	   		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    poolArr[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject(formObj.chss_pool_cd, poolArr, 0, 0);     
	 		idx++;
	       	break;
			
		// SAVE LOGIC
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("EES_CGM_1206GS.do", "f_cmd=" + MULTI + "&" +sParam);
			sheetObjects[0].LoadSaveXml(sXml);
			break;
	
		// EXCEL FILE DATA - IBSHEET GRID LOADING
		case "btn_loadexcel":		// EXCEL UPLOAD
			sheetObj.RemoveAll();
			sheetObj.Redraw = false;
			sheetObj.LoadExcel(-1);
			sheetObj.Redraw = true;
			formObj.chss_pool_cd.value = "";
			formObj.chss_pool_nm.value = "";
			formObj.vndr_seq.value = "";
			formObj.vndr_lgl_eng_nm.value = "";
			checkCount(sheetObj,formObj);
			break;
		
		case "btn_downexcel":	// EXCEL DOWNLOAD
//			sheetObj.SpeedDown2Excel(1);
			sheetObj.SpeedDown2Excel(0, false, false, "", "", false, false, "", false, "ibflag|del_chk", "");
			break;
			
		case IBRESET:
	 		var idx = 0
	 		var sXml2 = document.form2.sXml.value;
	 		var arrXml = sXml2.split("|$$|");
	
	 		if ( arrXml[idx] == null ) {return;}
	 		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
	 		for ( var i = 0; i < vArrayListData.length; i++) {
	 		    vListData = vArrayListData[i];
	 		    poolArr[i] = vListData["code1"] + "|" + vListData["desc1"];
	 		}
	 		// combo control, 결과 문자열, Text Index, Code Index
		  	MakeComboObject(formObj.chss_pool_cd, poolArr, 0, 0);     
	 		idx++;
	 		
	 		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	 var sheet1RowCnt = sheetObj.RowCount;
	 switch(sAction) {
	 case "btn_save" : 
		 for(var i=1; i <= sheet1RowCnt; i++) {
			 if(sheetObj.CellValue(i,"ibflag") != "D"){
				 if(sheetObj.CellValue(i, "chss_pool_cd") == ""){
					 ComShowCodeMessage('CGM10004',  "Pool Code");
					 return false;
				 }
				 if(sheetObj.CellValue(i, "vndr_seq") == "" || sheetObj.CellValue(i, "vndr_lgl_eng_nm") == ""){
					 ComShowCodeMessage('CGM10009',  "Vendor Code and Vendor Name");
					 return false;
				 }
				 if(sheetObj.CellValue(i,"ibflag") == "I"){
					 for(var j=1; j <= sheet1RowCnt ; j++) {
						 if (i==j) continue;
						 if (sheetObj.CellValue(i,"chss_pool_cd") == sheetObj.CellValue(j, "chss_pool_cd")) {
							 ComShowMessage(i + " and " + j + " Row's Pool Code is duplicated.");
							 return false;
						 }
					 }
				 }
				 if(sheetObj.CellValue(i, "ibflag")=="I" && sheetObj.CellValue(i,"chss_pool_cd") != ""){
					 formObj.f_cmd.value = SEARCH01;
					 formObj.chk_chss_pool_cd.value = sheetObj.CellValue(i, "chss_pool_cd");
					 doActionIBSheet(sheetObj, formObj, SEARCH01);
					 if(formObj.chk_chss_pool_cd.value != ""){
						 ComShowMessage(i + " Row's Pool Code is duplicated.");
						 return false;
					 }
				 }
			 }
		 }
		 break;
	 } // end switch()
	 return true;
}

/**
 * 기본 오브젝트 초기화 
 */
function objectClear(){
	var formObj = document.form;
	var sheetObj  = sheetObjects[0];

	// 데이타 초기화
	sheetObj.RemoveAll();
	comboObjects[0].Index = 0;
	formObj.chss_pool_nm.value = "";
	formObj.vndr_seq.value = "";
	formObj.vndr_lgl_eng_nm.value = "";
}

/**
* process when input retrieve keyword
*/
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
}

/**
* checking Load Excel Validation
* @param SheetObj
* @param formObj
*/ 
function checkCount(sheetObj,formObj){
	var sheet1RowCnt = sheetObj.RowCount;
	for(var i=1; i <= sheet1RowCnt; i++){
		if(sheetObj.CellValue(i, "ibflag")=="I" && sheetObj.CellValue(i,"vndr_seq") != ""){
			formObj.f_cmd.value = SEARCH02;
			formObj.chk_vndr_seq.value = sheetObj.CellValue(i, "vndr_seq");
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			if(formObj.vndr_nm.value != ""){
				sheetObj.CellValue2(i,"vndr_lgl_eng_nm") = formObj.vndr_nm.value;
			}else{
				sheetObj.CellValue2(i,"vndr_seq") = "";
				sheetObj.CellValue2(i,"vndr_lgl_eng_nm") = "";
			}
		}
	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col, value) {
	if (sheetObj.ColSaveName(Col) == "vndr_seq") {
//		ComOpenPopupWithTarget('/hanjin/COM_ENS_0C1.do', 700, 455, "vndr_seq:vndr_seq|vndr_lgl_eng_nm:vndr_lgl_eng_nm", "1,0,1,1,1,1", true);
		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 455, "callBackLocation", "1,0,1,1,1,1,1", true, false, Row);
	}
}

/**
* 콜백 함수. <br>
* @param  {Array} aryPopupData	필수	 Array Object
* @param  {Int} row				필수 선택한 Row
* @param  {Int} col				필수 선택한 Column
* @param  {Int} sheetIdx			필수 Sheet Index
* @return 없음
* @author 
* @version 2013.03.21
*/   
function callBackLocation(aryPopupData, row, col, sheetIdx){
   var sheetObj = sheetObjects[0];
   var vndrSeq = "";
   var vndrNm = "";
   var i = 0;
   
   for(i = 0; i < aryPopupData.length; i++){
	   vndrSeq = vndrSeq + aryPopupData[i][2];
	   vndrNm = vndrNm + aryPopupData[i][4];
   }
   sheetObj.CellValue2(row, "vndr_seq") = vndrSeq;
   sheetObj.CellValue2(row, "vndr_lgl_eng_nm") = vndrNm;
}

/**
* Sheet1 의 OnSaveEnd 이벤트처리 (저장) <br>
* @param  {object} sheetObj	필수	 Sheet Object
* @param  {string} ErrMsg		필수 String
* @return 없음
* @version 2013.03.15
*/ 
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObject = document.form;
	if(errMsg == "") {   
		ComShowCodeMessage('CGM00003');
		// 조회
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
		doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
	}
}

/** 
* Combo Object 에 값을 추가하는 처리 <br>
* @param  {object} cmbObj	필수 Combo Object
* @param  {String} arrStr	필수 대상 문자열 (다수의 경우는 '|' 로 구분) 
* @param  {String} txtCol	필수 Combo Text에 표시할 Colume Index 번호
* @param  {String} codeCol	필수 Combo Code 값에 설정할 Column Index 번호
* @return 없음
* @author 
* @version 2013.03.25
*/ 
function MakeComboObject(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	cmbObj.InsertItem(0,"","");
	for (var i = 0; i < arrStr.length;i++ ) {
		var arrCode = arrStr[i].split("|");
		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
	}
	cmbObj.Index2 = "" ;
}

/** 
 * Pool MultiCombo 의 change 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 
 * @version 2013.03.25
 */ 
function chss_pool_cd_OnChange(comboObj, idx_cd, text){

	var formObj = document.form;
	if(comboObj.Code == ""){
		formObj.chss_pool_nm.value = "";
	}
	for (var i = 0; i < poolArr.length;i++ ) {
		var arrCode = poolArr[i].split("|");
		if(arrCode[0] == text){
			formObj.chss_pool_nm.value = arrCode[1];
		}
	}
}
 
 /**
 * Sheet1 의 Change 이벤트를 정의한다.
 * @param SheetObj
 * @param Row
 * @param Col
 * @param Value
 */
 function sheet1_OnChange(sheetObj, Row, Col, Value){
 	var formObj = document.form;
 	if(sheetObj.ColSaveName(Col) == "chss_pool_cd" && sheetObj.CellValue(Row,"chss_pool_cd") != ""){
 		formObj.f_cmd.value = SEARCH01;
 		formObj.chk_chss_pool_cd.value = sheetObj.CellValue(Row, "chss_pool_cd");
 		doActionIBSheet(sheetObj, formObj, SEARCH01);
 		if(sheetObj.CellValue(Row,"ibflag") == "I" && formObj.chk_chss_pool_cd.value != ""){
			ComShowMessage(Row + " Row's Pool Code is duplicated.");
		}
 	}
 	if(sheetObj.ColSaveName(Col) == "vndr_seq" && sheetObj.CellValue(Row,"vndr_seq") != ""){
 		formObj.f_cmd.value = SEARCH02;
 		formObj.chk_vndr_seq.value = sheetObj.CellValue(Row, "vndr_seq");
 		doActionIBSheet(sheetObj, formObj, SEARCH02);
 		if(formObj.vndr_nm.value != ""){
			sheetObj.CellValue2(Row,"vndr_lgl_eng_nm") = formObj.vndr_nm.value;
		}else{
			sheetObj.CellValue2(Row,"vndr_seq") = "";
			sheetObj.CellValue2(Row,"vndr_lgl_eng_nm") = "";
		}
 	}
 }
/* 개발자 작업 끝 */
