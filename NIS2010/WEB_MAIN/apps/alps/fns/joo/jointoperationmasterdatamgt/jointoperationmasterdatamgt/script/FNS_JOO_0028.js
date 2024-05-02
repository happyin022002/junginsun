/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_joo_0028.js
 *@FileTitle : Settlement Item & Account Code List
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.04.24 박희동
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
 * @class fns_joo_0028 : fns_joo_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function fns_joo_0028() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

//row 단위로 처리할 일이 있을 경우를 위해 현재 row를 전역변수로 관리하기 위함
var gCurrRow;
//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {

			case "btn_Add":
				doActionIBSheet(sheetObject1, formObj, IBINSERT);
				break;
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				break;
	
			case "btn_Save":
				doActionIBSheet(sheetObject1, formObj, IBSAVE);
				break;
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObject1, formObj, IBDOWNEXCEL);
				break;
				
			case "btn_Delete":
				JooRowHideDelete(sheetObject1, "sheet1_del_chk");
				break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('JOO00001');
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    initControl();
}


function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	
    //Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur'    , formObj);
	axon_event.addListenerFormat('beforeactivate'  , 'obj_focus'   , formObj);
    axon_event.addListenerFormat('keypress'        , 'obj_keypress', formObj);
    axon_event.addListenerFormat('keyup'           , 'form_keyup'  , formObj);
}

function form_keyup(){
	ComKeyEnter('lengthnextfocus');  
} 

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 462;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			var HeadTitle  = "STS||Item|Other\nSettle|Basic\nPort\nCheck|Full Name|Expense Account Code|Expense Account Code|Revenue Account Code|Revenue Account Code|Performance of Estimated|Performance of Estimated";
			var HeadTitle1 = "STS||Item|Other\nSettle|Basic\nPort\nCheck|Full Name|DR|CR|DR|CR|EXP.|REV.";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle , true);
			InitHeadRow(1, HeadTitle1, true);

			var prefix = "sheet1_";

			//InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "skd_id", false, "", dfNone, 0, false, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus  , 0, daCenter, true , prefix + "ibflag");//<<<< 주의
			InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, true , prefix + "del_chk");
			InitDataProperty(0, cnt++, dtData    , 0, daCenter, true , prefix + "jo_stl_itm_cd"   , true , "", dfNone, 0, false, true, 3);
			InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, true , prefix + "jo_mnl_cre_flg"  , false, "", dfNone, 0, true , true,-1,false,true,"",false);
			InitDataProperty(0, cnt++, dtCheckBox, 0, daCenter, true , prefix + "jo_auto_cre_flg" , false, "", dfNone, 0, true , true,-1,false,true,"",false);
			InitDataProperty(0, cnt++, dtData    , 0, daLeft  , true , prefix + "jo_stl_itm_nm"   , true , "", dfNone, 0, true , true,50);
			InitDataProperty(0, cnt++, dtData    , 0, daCenter, true , prefix + "e_dr_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			InitDataProperty(0, cnt++, dtData    , 0, daCenter, true , prefix + "e_cr_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			InitDataProperty(0, cnt++, dtData    , 0, daCenter, true , prefix + "r_dr_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			InitDataProperty(0, cnt++, dtData    , 0, daCenter, true , prefix + "r_cr_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			InitDataProperty(0, cnt++, dtCombo   , 0, daCenter, true , prefix + "e_es_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			InitDataProperty(0, cnt++, dtCombo   , 0, daCenter, true , prefix + "r_es_acct_cd"    , true , "", dfNone, 0, true , true, 6);
			
			var tmpArr = gEstmAcctCd.split("|");
			
			var rAcct="";
			var eAcct="";
			for (var i=0; i<tmpArr.length; i++)
				//4로 시작하는 Account Code는 Revenue
				if (tmpArr[i].substring(0,1) == "4")
					rAcct=rAcct+tmpArr[i]+"|";
				//5로 시작하는 Account Code는 Expense
				else if (tmpArr[i].substring(0,1) == "5")
					eAcct=eAcct+tmpArr[i]+"|";
			
			if (rAcct.length > 0)
				rAcct = rAcct.substring(0, rAcct.length-1)

			if (eAcct.length > 0)
				eAcct = eAcct.substring(0, eAcct.length-1)

			InitDataCombo(0, prefix+"e_es_acct_cd", eAcct, eAcct);
			InitDataCombo(0, prefix+"r_es_acct_cd", rAcct, rAcct);
			
			InitDataValid(0, prefix+"jo_stl_itm_cd", vtEngUpOther, "/"); //영문대문자와 숫자만 올 수 있음
			InitDataValid(0, prefix+"e_dr_acct_cd" , vtNumericOnly); //숫자만
			InitDataValid(0, prefix+"e_cr_acct_cd" , vtNumericOnly); //숫자만
			InitDataValid(0, prefix+"r_dr_acct_cd" , vtNumericOnly); //숫자만
			InitDataValid(0, prefix+"r_cr_acct_cd" , vtNumericOnly); //숫자만
			InitDataValid(0, prefix+"jo_stl_itm_nm", vtEngOther, gVtOther); //영문자만...
			
			FitColWidth("3|3|7|7|7|18|9|9|9|9|9|9");
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	var prefix = "sheet1_";
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_JOO_0028GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			break;
	
		case IBSAVE: //저장
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}//end if
			
			formObj.f_cmd.value = MULTI;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			sheetObj.DoSave("FNS_JOO_0028GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix), -1, false);
			ComOpenWait(false);
			break;

		//Expense DR Account Validation Check			
		case IBSEARCH_ASYNC01: 
			formObj.f_cmd.value = SEARCHLIST09;
			formObj.code.value = sheetObj.CellValue(gCurrRow,prefix+"e_dr_acct_cd");
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";

			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"CHECKVVD")=="E"){
				ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				sheetObj.CellValue (gCurrRow,prefix+"e_dr_acct_cd")=""; //VVD Clear
				sheetObj.SelectCell(gCurrRow,prefix+"e_dr_acct_cd",true);
			}

			break;

		//Expense CR Account Validation Check
		case IBSEARCH_ASYNC02:  
			formObj.f_cmd.value = SEARCHLIST09;
			formObj.code.value = sheetObj.CellValue(gCurrRow,prefix+"e_cr_acct_cd");
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";

			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));

			if (ComGetEtcData(sXml,"CHECKVVD")=="E"){
				ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				sheetObj.CellValue (gCurrRow,prefix+"e_cr_acct_cd")=""; //VVD Clear
				sheetObj.SelectCell(gCurrRow,prefix+"e_cr_acct_cd",true);
			}

			break;

		//Revenue DR Account Validation Check
		case IBSEARCH_ASYNC03:  
			formObj.f_cmd.value = SEARCHLIST09;
			formObj.code.value = sheetObj.CellValue(gCurrRow,prefix+"r_dr_acct_cd");
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";

			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"CHECKVVD")=="E"){
				ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				sheetObj.CellValue (gCurrRow,prefix+"r_dr_acct_cd")=""; //VVD Clear
				sheetObj.SelectCell(gCurrRow,prefix+"r_dr_acct_cd",true);
			}

			break;

		//Revenue CR Account Validation Check
		case IBSEARCH_ASYNC04:  
			formObj.f_cmd.value = SEARCHLIST09;
			formObj.code.value = sheetObj.CellValue(gCurrRow,prefix+"r_cr_acct_cd");
			formObj.super_cd1.value = "";
			formObj.super_cd2.value = "";

			var sXml = sheetObj.GetSearchXml("JOOCommonGS.do", FormQueryString(formObj));
			
			if (ComGetEtcData(sXml,"CHECKVVD")=="E"){
				ComShowMessage(ComGetEtcData(sXml,"VVDMSG"));
				sheetObj.CellValue (gCurrRow,prefix+"r_cr_acct_cd")=""; //VVD Clear
				sheetObj.SelectCell(gCurrRow,prefix+"r_cr_acct_cd",true);
			}

			break;
			
		case IBINSERT: // 입력
			sheetObj.DataInsert(-1);
			var row = sheetObj.LastRow;
			sheetObj.CellValue2(row, prefix+"r_es_acct_cd") = "";
			sheetObj.CellValue2(row, prefix+"e_es_acct_cd") = "";
			break;

		case IBDOWNEXCEL: // 엑셀내려받기
			sheetObj.SpeedDown2Excel(1);
			break;
	}
}

//sheet1_OnChange
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix="sheet1_";
	var formObj = document.form;

	gCurrRow = Row;

	if (sheetObj.ColSaveName(Col)== prefix+"e_dr_acct_cd"){
		if (sheetObj.CellValue(Row, prefix+"e_dr_acct_cd").length==6){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
		}
	}else if (sheetObj.ColSaveName(Col)== prefix+"e_cr_acct_cd"){
		if (sheetObj.CellValue(Row, prefix+"e_cr_acct_cd").length==6){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		}
	}else if (sheetObj.ColSaveName(Col)== prefix+"r_dr_acct_cd"){
		if (sheetObj.CellValue(Row, prefix+"r_dr_acct_cd").length==6){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		}
	}else if (sheetObj.ColSaveName(Col)== prefix+"r_cr_acct_cd"){
		if (sheetObj.CellValue(Row, prefix+"r_cr_acct_cd").length==6){
			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
		}
	} 
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var prefix="sheet1_";
	switch (sAction) {
		case IBSAVE:   //저장
			var cnt = 0;
			for(var inx=sheetObj.HeaderRows; inx<=sheetObj.LastRow; inx++){
				var status = sheetObj.RowStatus(inx);

				//수정되지 않은 값은 skip
				if (status == "R"){
					continue;
				}
				cnt++;
				
				//삭제될 건은 validation check하지 않고 cnt만 증가시킨다.
				if (status == "D")
					continue;

				//del_chk 체크만 한 경우를 방지하기 위함 
				if ((status == "I" || status == "U") && sheetObj.CellValue(inx,prefix+"del_chk") == "1"){
					ComShowCodeMessage("JOO00079");
					sheetObj.SelectCell(inx,prefix+"del_chk",true);
					return false;
				}

				var rownum = (inx-1)+"th row";
				if (inx-1 == 1){
					rownum = (inx-1)+"st row";
				}else if (inx-1==2){
					rownum = (inx-1)+"nd row";
				}
				
				if (sheetObj.CellValue(inx,prefix+"jo_stl_itm_cd").length < 3){
					ComShowCodeMessage('JOO00017',rownum);
					sheetObj.SelectCell(inx,prefix+"jo_stl_itm_cd",true);
					return false;
				}
	
				if (sheetObj.CellValue(inx,prefix+"jo_stl_itm_nm").length == 0){
					ComShowCodeMessage('JOO00052',rownum);
					sheetObj.SelectCell(inx,prefix+"jo_stl_itm_nm",true);
					return false;
				}
	
				if (sheetObj.CellValue(inx,prefix+"e_dr_acct_cd").length < 6){
					ComShowCodeMessage('JOO00053',rownum);
					sheetObj.SelectCell(inx,prefix+"e_dr_acct_cd",true);
					return false;
				}
	
				if (sheetObj.CellValue(inx,prefix+"e_cr_acct_cd").length < 6){
					ComShowCodeMessage('JOO00053',rownum);
					sheetObj.SelectCell(inx,prefix+"e_cr_acct_cd",true);
					return false;
				}
	
				if (sheetObj.CellValue(inx,prefix+"r_dr_acct_cd").length < 6){
					ComShowCodeMessage('JOO00053',rownum);
					sheetObj.SelectCell(inx,prefix+"r_dr_acct_cd",true);
					return false;
				}
	
				if (sheetObj.CellValue(inx,prefix+"r_cr_acct_cd").length < 6){
					ComShowCodeMessage('JOO00053',rownum);
					sheetObj.SelectCell(inx,prefix+"r_cr_acct_cd",true);
					return false;
				}
			}

			if (cnt==0){
				ComShowCodeMessage('JOO00036');
				return false;
			}
			
			break;
		case IBSEARCH: //조회
			break;
	}
	return true;
}

/* 개발자 작업  끝 */