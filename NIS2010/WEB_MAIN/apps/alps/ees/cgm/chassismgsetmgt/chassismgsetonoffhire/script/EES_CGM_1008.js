/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1008.js
 *@FileTitle : Chassis On-Hire Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.26
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.06.26 박의수
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.09.14 허철용 [CSR 선처리] 날짜 Validation 오류수정
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
 * @class ees_cgm_1008 : ees_cgm_1008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1008() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];
	var sheetObj1 = sheetObjects[1];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_rowadd":
			sheetObj.DataInsert();
			// 히든 컬럼값 셋팅(CUD Query에서 필수 컬럼값)
			for(i=1; i<sheetObj.rowCount+1; i++){
				sheetObj.CellValue(i, "eq_knd_cd") = document.forms[0].eq_knd_cd.value;	
				if(sheetObj.CellValue(i, "cre_usr_id") == ""){
					sheetObj.CellValue(i, "cre_usr_id") = document.forms[0].cre_id.value;	
				}
			}
			// 콤보 로직 추가할것
			break;

		case "btn_delete":
			// 화면에서만 삭제(삭제함수 호출)
			rowDelete(sheetObj);
			break;

		case "btn_excel":
			doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
			break;

		case "btn_new":
			// SHEET RESET
			sheetObj.RemoveAll();
			
			// HTML OBJECT RESET
			formObj.reset();
			chk('O');
			break;

		case "btn_verify":
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;

		case "btn_confirm":
			doActionIBSheet(sheetObj,formObj,IBSAVE);
			break;
			
		case "btn_Calendar_a":
			if(window.event.srcElement.disabled) {
				return;
			}
			var cal = new ComCalendar();
			cal.select(formObj.onh_dt, "yyyy-MM-dd");
			break;

		case "ComOpenPopupWithTargetOffice":
			ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do?pgmNo=COM_ENS_071', 800, 480, "ofc_cd:onh_ofc_cd", "1,0,1,1,1,1,1", true);
			Matched_Chk('Office');
		    Verify_Status_chk();
			break;

		case "ComOpenPopupWithTargetYard":
			ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do?pgmNo=COM_ENS_061', 800, 475, "3:onh_yd_cd", "1,0,1,1,1,1,1", true);
			Matched_Chk('Yard');
			Verify_Status_chk();
			break;

		case "ComOpenPopupWithTargetAgree":
			if(formObj.ownleas[1].checked == true){
				ComOpenPopup('/hanjin/EES_CGM_1117.do?pgmNo=EES_CGM_1117', 820, 420, "setProgramNo", "1,0,1,1,1,1", true, false);
			}
			
			break;
        case "btn_downexcel":
        	 sheetObj.SpeedDown2Excel(-1);  
	       	break;
		} // end switch
	} catch (e) {
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		yard_Chk();
	}

}
 /**
  * 
  * @param sheetObj
  * @return
  */
 function sheet1_OnLoadFinish(sheetObj) {
     sheetObj.WaitImageVisible = false;
     var formObj = document.form;
     axon_event.addListenerFormat("keypress",			"obj_keypress",		form);
     axon_event.addListenerFormat("keypress",			"obj_keydown",		form);
     axon_event.addListenerForm  ("beforedeactivate",	"obj_deactivate",	form);
 	 axon_event.addListenerFormat("beforeactivate",		"obj_activate",		form);
 	 axon_event.addListener      ("click",				"obj_onclick",		"ownleas");

// 	axon_event.addListener('focusout', 'obj_focusout' , 'onh_ofc_cd' , 'onh_yd_cd', 'agreement_no'  ); 
 	axon_event.addListener('focusout', 'obj_focusout' , 'onh_ofc_cd' , 'agreement_no' ,'onh_dt','onh_dt_hm','onh_yd_cd' ); 
 	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
 	doActionIBSheet(sheetObj, formObj, SEARCH08); // COMBO 조회(STATE CODE)
 	doActionIBSheet(sheetObj, formObj, SEARCH04); // COMBO 조회(TYPE SIZE)
    sheetObj.WaitImageVisible = true; 
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
			style.height = 380;
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

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(27, 5, 0, true);
			
			var HeadTitle = "Status||Seq.|Chassis No.|Type/Size|Manufacture Date|Weight(lbs)|Reg.State|Reg.Year|Expiry Date|Expiry Date|License No.|Vehicle ID No.|Title No.|Alias No.1|Alias No.2|Verify Status|Created By|eq_knd_cd|own_lse|onh_dt|vndr_seq|agmt_lstm_cd";

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0,	cnt++,	dtCheckBox,		30,		daCenter,	false,	"del_chk");
			InitDataProperty(0,	cnt++,	dtDataSeq,		40,		daCenter,	false,	"Seq");
			InitDataProperty(0,	cnt++,	dtData,			130,	daCenter,	false,	"eq_no",			false,	"",	dfNone,			0,	true,	true,	10);
			InitDataProperty(0,	cnt++,	dtCombo,		70,		daCenter,	false,	"eq_tpsz_cd",		false,	"",	dfNone,			0,	false,	false);

			InitDataProperty(0,	cnt++,	dtPopupEdit,	120,	daCenter,	false,	"mft_dt",			false,	"",	dfDateYmd,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			90,		daRight,	false,	"chss_tare_wgt",	false,	"",	dfNullInteger,	0,	false,	false);
			InitDataProperty(0,	cnt++,	dtCombo,		190,	daCenter,	false,	"chss_rgst_ste_cd",	false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"chss_rgst_yr",		false,	"",	dfNone,			0,	false,	false,	4);
			InitDataProperty(0,	cnt++,	dtCombo,		60,		daCenter,	false,	"chss_rgst_exp_div",false,	"",	dfNone,			0,	false,	false);

			InitDataProperty(0,	cnt++,	dtPopupEdit,	100,	daCenter,	false,	"chss_rgst_exp_dt",	false,	"",	dfDateYmd,		0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"chss_rgst_lic_no",	false,	"",	dfNone,			0,	false,	false,	12);
			InitDataProperty(0,	cnt++,	dtData,			140,	daCenter,	false,	"chss_veh_id_no",	false,	"",	dfNone,			0,	false,	false,	20);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"chss_tit_no",		false,	"",	dfNone,			0,	false,	false,	15);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"chss_als_no",		false,	"",	dfNone,			0,	false,	false,	11);

			InitDataProperty(0,	cnt++,	dtData,			120,	daLeft,		false,	"n2nd_chss_als_no",	false,	"",	dfNone,			0,	false,	false,	11);
			InitDataProperty(0,	cnt++,	dtData,			120,	daCenter,	false,	"verify",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"cre_usr_id",		false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0,	cnt++,	dtHidden,	    50,		daLeft,		false,	"eq_knd_cd",		false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		80,		daLeft,		false,	"own_lse",			false,	"",	dfNone,			0,	true,	true);

			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_dt",			false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agreement_no",		false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agmt_ver_no",		false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_ofc_cd",		false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"onh_yd_cd",		false,	"",	dfNone,			0,	true,	true);
			
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"vndr_seq",		    false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0,	cnt++,	dtHidden,		100,	daLeft,		false,	"agmt_lstm_cd",		false,	"",	dfNone,			0,	true,	true);
			

			InitDataCombo(0, "chss_rgst_exp_div", "PMNT|Fixed", "P|F");
			PopupImage = "img/btns_calendar.gif";
			ShowButtonImage = 2;
			SelectionMode   = smSelectionFree;
		}
		sheetObj.InitDataValid(0, "eq_no", vtEngUpOther, "1234567890"); // 영문 대문자와 숫자만 입력
		sheetObj.InitDataValid(0, "chss_rgst_yr", vtNumericOnly);       // 숫자만 입력
		 
		break;
	}
}


/**
 * Sheet관련 프로세스 처리 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		var verifyFlag = false;
		var chkFlag    = false;
		var typFlag    = false;
		
		
		
		formObj.f_cmd.value = SEARCHLIST;
		queryString = "f_cmd=" + SEARCHLIST;
		
		if(formObj.onh_ofc_cd.value == ""){
			ComShowCodeMessage("CGM10004", "Office");
			formObj.onh_ofc_cd.focus();
			return;
		}
		if(formObj.onh_dt.value == ""){
			ComShowCodeMessage("CGM10004", "On-Hire Date");
			formObj.onh_dt.focus();
			return;
		}
		if(formObj.onh_yd_cd.value == ""){
			ComShowCodeMessage("CGM10004", "On-Hire Yard");
			formObj.onh_yd_cd.focus();
			return;
		}
		if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
			 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
		 	 formObj.onh_yd_cd.focus();
		     return false;
		}
		if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
			ComShowCodeMessage("CGM10004", "Agreement No");
			formObj.agreement_no.focus();
			return;
		}
		
		for(i=1; i<sheetObj.rowCount+1; i++){
			var del_chk = sheetObj.CellValue(i, "del_chk");
			// 필수 입력값 검증
			if(del_chk == "1" && sheetObj.CellValue(i, "eq_no")==""){
				sheetObj.RowStatus(i) = "R";
				sheetObj.CellValue(i, "del_chk")= "0";
			} else if(del_chk == "1" && sheetObj.CellValue(i, "eq_no")!=""){
				sheetObj.RowStatus(i) = "U";
				sheetObj.CellValue(i, "own_lse") = formObj.own_lse.value;
//				if(formObj.ownleas[1].checked == true && sheetObj.CellValue(i, "eq_tpsz_cd") == ""){
//					typFlag = true;
//				}
				if(formObj.ownleas[1].checked == true  ){
					sheetObj.CellValue(i, "agreement_no") = formObj.agreement_no.value;
				}
				chkFlag = true;
			}
			sheetObj.CellValue(i, "onh_dt")       =  formObj.onh_dt.value + " " + formObj.onh_dt_hm.value;
		}
//		if(typFlag){
 
//			return false;
//		}
		
		var params = sheetObj.GetSaveString(true);
		if(sheetObj.rowCount>0 && chkFlag){
			sheetObj.WaitImageVisible=false;
 	        ComOpenWait(true);
			sheetObj.DoSearch("EES_CGM_1008GS.do", queryString+"&"+params);
			for(i=1; i<sheetObj.rowCount+1; i++){
				var verify = sheetObj.CellValue(i, "verify")
				// 필수 입력값 검증
				
				if(verify != "OK"){
					if(sheetObj.CellValue(i, "eq_no") == ""){
						//sheetObj.CellValue(i, "del_chk") = "1";
					} else {
						verifyFlag = true;
					}
				}
			}
			ComOpenWait(false);
			if(verifyFlag){
				// 상태 확인 메세지 
				ComShowCodeMessage("CGM10005");
				//return;
			}
		} else {
			// 행 선택 메세지
			ComShowCodeMessage("CGM10008");	
			return;
		}
		// Expiry Date 가 PMNT인 경우 Data Disable
		for(i=1; i<sheetObj.rowCount+1; i++){
			if(sheetObj.CellValue(i, "chss_rgst_exp_div") == 'P'){
				sheetObj.CellEditable(i, "chss_rgst_exp_dt") = false;
			} else {
				sheetObj.CellEditable(i, "chss_rgst_exp_dt") = true;
			}
		}
		
		// Verify 가 OK 아니면   1.체크박스 선택 불가처리 및  2.글자색을 빨간색으로변경
		for(i=1; i<sheetObj.rowCount+1; i++){
			if(sheetObj.CellValue(i, "verify") == "OK" && sheetObj.CellValue(i, "del_chk") == "1"){
				sheetObj.CellEditable(i, "del_chk") = true;
				sheetObj.CellEditable(i, "eq_no") = false;
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 0);
			} else if(sheetObj.CellValue(i, "verify") != "OK" && sheetObj.CellValue(i, "del_chk") == "1"){
				sheetObj.CellValue(i, "del_chk") = "0";
				sheetObj.CellEditable(i, "del_chk") = true;
				sheetObj.CellEditable(i, "mft_dt")           = true;
				sheetObj.CellEditable(i, "chss_tare_wgt")    = true;
				sheetObj.CellEditable(i, "chss_rgst_ste_cd") = true;
				sheetObj.CellEditable(i, "chss_rgst_yr")     = true;
				
				sheetObj.CellEditable(i,"chss_rgst_exp_dt")  = true;
				sheetObj.CellEditable(i,"chss_rgst_lic_no")  = true;
				sheetObj.CellEditable(i,"chss_veh_id_no")    = true;
				sheetObj.CellEditable(i,"chss_tit_no")       = true;
				sheetObj.CellEditable(i,"chss_als_no")       = true;

				sheetObj.CellEditable(i,"n2nd_chss_als_no")  = true;
				
				sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
//				sheetObj.CellValue(i, "ibflag") = "";
			}
		}
		break;

	case IBSAVE: // 저장
		var actionFlag = true; 
	    var VerifyFlag = false; 
	    
		if(formObj.onh_ofc_cd.value == ""){
			ComShowCodeMessage("CGM10004", "Office");
			formObj.onh_ofc_cd.focus();
			return;
		}
		if(formObj.onh_dt.value == ""){
			ComShowCodeMessage("CGM10004", "On-Hire Date");
			formObj.onh_dt.focus();
			return;
		}
		if(formObj.onh_yd_cd.value == ""){
			ComShowCodeMessage("CGM10004", "On-Hire Yard");
			formObj.onh_yd_cd.focus();
			return;
		}
		if(formObj.onh_yd_cd.value!='' && formObj.onh_yd_cd.value.length !=7){
			 ComShowCodeMessage('CGM10044','On-Hire Yard (7)');
		 	 formObj.onh_yd_cd.focus();
		     return false;
		}
		if(formObj.agreement_no.value == "" && formObj.ownleas[0].checked != true){
			ComShowCodeMessage("CGM10004", "Agreement No");
			formObj.agreement_no.focus();
			return;
		}
		
		
		
		formObj.f_cmd.value = MULTI;
		for(i=1; i<sheetObj.rowCount+1; i++){
			var verify = sheetObj.CellValue(i, "verify");
			if(verify == "OK" &&sheetObj.CellValue(i, "del_chk") == "1"){
				// 필수 입력값 검증
				sheetObj.CellValue(i, "onh_dt")       =  formObj.onh_dt.value + " " + formObj.onh_dt_hm.value;
				if(formObj.ownleas[1].checked){
					sheetObj.CellValue(i, "agreement_no") =  formObj.agreement_no.value ;
					sheetObj.CellValue(i, "agmt_ver_no")  =  formObj.agmt_ver_no.value ;
					sheetObj.CellValue(i, "agmt_lstm_cd") =  formObj.agmt_lstm_cd.value ;
					sheetObj.CellValue(i, "vndr_seq")     =  formObj.vndr_seq.value ;
					
				}
				
				
				sheetObj.CellValue(i, "onh_yd_cd")    =  formObj.onh_yd_cd.value ;
				sheetObj.CellValue(i, "onh_ofc_cd")   =  formObj.onh_ofc_cd.value ;
				sheetObj.CellValue(i, "eq_knd_cd")    =  "Z" ;
				
				sheetObj.RowStatus(i) = "I";
			} else if(verify == "" && sheetObj.CellValue(i, "del_chk")== "1" ) {
				ComShowCodeMessage("CGM10004", "verify");
				sheetObj.RowStatus(i) = "R";
				actionFlag = false; 
				break;
			} else if(verify != "OK" && sheetObj.CellValue(i, "del_chk")== "1" ) {
				VerifyFlag = true; 
				sheetObj.RowStatus(i) = "R";
				break;
			} else {
				sheetObj.RowStatus(i) = "R";
			}
		}
		// CONFIRM
		if(VerifyFlag){
        	ComShowCodeMessage("CGM10005");
	    }else if(actionFlag){
 			formObj.f_cmd.value = MULTI;
			queryString = "f_cmd=" + MULTI ;
			sheetObj.WaitImageVisible=false;
 	        ComOpenWait(true);
			var params = sheetObj.GetSaveString(true);
			if(sheetObj.DoSave("EES_CGM_1008GS.do",queryString + "&" + ComGetPrefixParam("")),'del_chk')
			{
				//취소시 
				for(i=1; i<sheetObj.rowCount+1; i++){
					if(sheetObj.CellValue(i, "del_chk") == "1"){
						sheetObj.RowStatus(i) = "R";
					}
				}
			}
			ComOpenWait(false);
		}
		else
		{
			ComShowCodeMessage("CGM10008");
		}
		
		break;
		
	// AGREEMENT NO 조회(엔터키로 단건 조회)
	case IBSEARCH_ASYNC01:
	formObj.f_cmd.value = SEARCH12;
    formObj.agmt_no.value = formObj.agreement_no.value;
    var sXml = sheetObj.GetSearchXml("CgmCodeMgtGS.do" , FormQueryString(formObj));
    
    // 데이터 건수
    var dataCount = ComGetTotalRows(sXml);
    
    // 데이터가 존재할 경우
    if(dataCount > 0){
    	
    	var lstmCd                    = DomXml2String(sXml,"agmt_lstm_cd");
    	
        if(formObj.ownleas[0].checked == true  ){
	       	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
	       		 ComShowCodeMessage('CGM10066',formObj.agreement_no.value);
	           	 return false;
	       	 } else {
	       		formObj.agreement_no.value    = DomXml2String(sXml,"agmt_no");
	        	formObj.agmt_ref_no.value     = DomXml2String(sXml,"agmt_ref_no");
	        	formObj.agmt_lstm_cd.value    = DomXml2String(sXml,"agmt_lstm_cd");
	        	// AGREEMENT NO POST PROCESS CALL
	        	formObj.vndr_lgl_eng_nm.value = DomXml2String(sXml,"vndr_lgl_eng_nm");
	        	formObj.vndr_seq.value        = DomXml2String(sXml,"vndr_seq");
	        	formObj.agmt_ver_no.value     = DomXml2String(sXml,"agmt_ver_no");
	        	agreementNoChk(lstmCd);
	       	 }
       	 
        } else if(formObj.ownleas[1].checked == true ){
	       	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
	       		 ComShowCodeMessage('CGM10065',formObj.agreement_no.value);
	           	 return false;
	       	 }  else if(lstmCd =="CP"  ){
	       		 ComShowCodeMessage('CGM10029');
	           	 return false;
	       	 } else {
	       		formObj.agreement_no.value    = DomXml2String(sXml,"agmt_no");
	        	formObj.agmt_ref_no.value     = DomXml2String(sXml,"agmt_ref_no");
	        	formObj.agmt_lstm_cd.value    = DomXml2String(sXml,"agmt_lstm_cd");
	        	// AGREEMENT NO POST PROCESS CALL
	        	formObj.vndr_lgl_eng_nm.value = DomXml2String(sXml,"vndr_lgl_eng_nm");
	        	formObj.vndr_seq.value        = DomXml2String(sXml,"vndr_seq");
	        	formObj.agmt_ver_no.value     = DomXml2String(sXml,"agmt_ver_no");
	        	agreementNoChk(lstmCd);
	       	 }
       	 
        }
    	return true;
    } else {
    	// Form Object 초기화
    	ComShowCodeMessage("CGM10009","Agreement No");
    	formObj.agreement_no.value    = "";
    	formObj.agmt_ref_no.value     = "";
    	formObj.agmt_lstm_cd.value    = "";
    	formObj.vndr_lgl_eng_nm.value = "";
    	formObj.vndr_seq.value        = "";
    	return false;
    }
    break;
    
    // LOAD EXCEL
	case IBLOADEXCEL:
		if (sheetObj.id == "sheet1") {
			sheetObj.RemoveAll(); 	
			sheetObj.LoadExcel();
		}
		// Expiry Date 가 PMNT인 경우 Data Disable
		for(i=1; i<sheetObj.rowCount+1; i++){
			if(sheetObj.CellValue(i, "chss_rgst_exp_div") == 'P'){
				sheetObj.CellEditable(i, "chss_rgst_exp_dt") = false;
			} else {
				sheetObj.CellEditable(i, "chss_rgst_exp_dt") = true;
			}
			
			if(formObj.ownleas[1].checked == true){ //Leased 
				// 데이타가 존재하지 않을 경우
				sheetObj.CellValue2(i,"cre_usr_id")       = document.forms[0].cre_id.value;
				sheetObj.CellEditable(i, "eq_tpsz_cd")       = true;
				sheetObj.CellEditable(i, "mft_dt")           = true;
				sheetObj.CellEditable(i, "chss_tare_wgt")    = true;
				sheetObj.CellEditable(i, "chss_rgst_ste_cd") = true;
				sheetObj.CellEditable(i, "chss_rgst_yr")     = true;
				sheetObj.CellEditable(i,"chss_rgst_exp_dt")  = true;
				sheetObj.CellEditable(i,"chss_rgst_lic_no")  = true;
				sheetObj.CellEditable(i,"chss_veh_id_no")    = true;
				sheetObj.CellEditable(i,"chss_tit_no")       = true;
				sheetObj.CellEditable(i,"chss_als_no")       = true;
				sheetObj.CellEditable(i,"n2nd_chss_als_no")  = true;
			}else{	//OWN
				// chungpa 20100115 1008, 2007 : Own 장비의 verify 시 입력된 eq_no 별 agmt_no(agmt_ver_no 포함) 를 조회하여 가져오도록 event 발생 처리.
				// start
		     	formObj.f_cmd.value = SEARCH;
				formObj.eq_no.value = sheetObj.CellValue(i, "eq_no");
				if(formObj.eq_no.value !=""){
					var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do", FormQueryString(formObj));
			 		var dataCount = ComGetTotalRows(sXml);
			 		if(dataCount > 0){
						sheetObj.CellValue2(i,"agreement_no")     = DomXml2String(sXml,"agreement_no");
						sheetObj.CellValue2(i,"agmt_ver_no")      = DomXml2String(sXml,"agmt_ver_no");
						sheetObj.CellValue2(i,"vndr_seq")         = DomXml2String(sXml,"vndr_seq");
						sheetObj.CellValue2(i,"agmt_lstm_cd")     = DomXml2String(sXml,"agmt_lstm_cd");			
						sheetObj.CellValue2(i,"eq_tpsz_cd")    = DomXml2String(sXml,"eq_tpsz_cd");
					} else {
						sheetObj.CellValue2(i,"eq_no") = "";
						ComShowCodeMessage("CGM20003");
					}
				}			
				// chungpa 20100115 1008, 2007 : Own 장비의 verify 시 입력된 eq_no 별 agmt_no(agmt_ver_no 포함) 를 조회하여 가져오도록 event 발생 처리.
				// end			
			}
		}
	break;
	
	case SEARCH08: //그리드내  다중콤보(REG.STATE)
		formObj.f_cmd.value = SEARCH08;
		var sXml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
 	  	var cols = ComCgmXml2ComboString(sXml, "code1", "code1|desc1", "\t");
 	  	sheetObj.InitDataCombo(0, "chss_rgst_ste_cd", " |" + cols[1], " |" + cols[0], "", "", 0);
 	break;

	case SEARCH04: //그리드내  다중콤보(TYPE/SIZE)
        formObj.f_cmd.value = SEARCH04;
        var sXml = sheetObj.GetSearchXml ("CgmCodeMgtGS.do", FormQueryString(formObj));
        var sStr = ComGetEtcData(sXml,"comboList");
        var arrStr = sStr.split("@");
        var arrCode1 ="";
        var arrCode2 ="";
        for (var i = 0; i < arrStr.length;i++ ) {
        	var arrCode = arrStr[i].split("|");
        	if(i==0){
        		arrCode1 = arrCode1+" " +"|"+ arrCode[1];
        		arrCode2 = arrCode2+" " +"|"+ arrCode[0];
        	} else {
        		arrCode1 = arrCode1 +"|"+ arrCode[1];
        		arrCode2 = arrCode2 +"|"+ arrCode[0];
        	}
        }
        sheetObj.InitDataCombo(0, "eq_tpsz_cd",   arrCode1,   arrCode2, "", "", 0);
	 	break;
	case IBSEARCH_ASYNC02:	// Office Code 에 대한 Validation 체크 
	   	formObj.f_cmd.value = COMMAND01;
	   	formObj.ofc_cd.value = formObj.onh_ofc_cd.value;
	   	var sXml = sheetObj.GetSearchXml("CgmValidationGS.do", FormQueryString(formObj));
	   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
	   	
	   	if(sCheckResult == COM_VALIDATION_FALSE){
	   		ComShowCodeMessage('CGM10009','Office');
	   		formObj.onh_ofc_cd.value = "";
	   		formObj.onh_ofc_cd.focus();
	   	} else {
	   		formObj.onh_dt.focus();
	   		Matched_Chk('Office');
	   	}
	   	
	   	break;
	case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크 
	   	formObj.f_cmd.value = COMMAND01;
	   	formObj.yd_cd.value = formObj.onh_yd_cd.value;
	   	var sXml = sheetObj.GetSearchXml("Check_YardGS.do", FormQueryString(formObj));
	   	var sCheckResult = ComGetEtcData(sXml,"checkResult");    	
	   	
	   	if(sCheckResult == COM_VALIDATION_FALSE){
	   		ComShowCodeMessage('CGM10009','Yard');
	   		formObj.onh_yd_cd.value = "";
	   		formObj.onh_yd_cd.focus();
	   	} else {
	   		formObj.agreement_no.focus();
	   		Matched_Chk('Yard');
	   	}
	   	break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}
	return true;
}


function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	ComShowMessage("popup_click");
}


/**
 * SHEET1 ONCHANGE EVENT
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
//	 alert(Row+"::"+Col+"::"+Value);
	var formObj   = document.form;
	var sheetObj  = sheetObjects[0];
	
	var targetCol = sheetObj.SaveNameCol("eq_no");
	var eqNo      = sheetObj.CellValue(Row, "eq_no");
	
	with(sheetObj){
		var colName = colSaveName(Col);
		switch(colName){
		case "eq_no":
	     	formObj.f_cmd.value = SEARCH;
			formObj.eq_no.value = eqNo;
			
			if(Row >1){
				// chassis no 체크
				for(i=1; i<sheetObj.rowCount; i++){
					if(sheetObj.CellValue(i, "eq_no")== Value && Row != i  && sheetObj.CellValue(i, "eq_no")!='')
 					{
						// 체크 메시지 출력
			        	// ComShowMessage('CGM20007');
	 
						ComShowCodeMessage("CGM20004",sheetObj.CellValue(i, "eq_no"));
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue(Row, "eq_no") = "";
			        	return false;
 					}
				}
				
				 
			} 
		
			if(formObj.eq_no.value !=""){
				var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do", FormQueryString(formObj));
		 		//ComShowMessage("####### "+sXml);
		 		// 데이터 건수
		 		var dataCount = ComGetTotalRows(sXml);
		 		
		 		if(dataCount > 0){
					
					var lstmCd = DomXml2String(sXml,"agmt_lstm_cd");
					if(formObj.ownleas[1].checked == true){
						if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
				       		 ComShowCodeMessage('CGM10065',formObj.eq_no.value);
				           	 return false;
				       	 }
						sheetObj.CellValue2(Row,"cre_usr_id")   = DomXml2String(sXml,"cre_usr_id");
					} else {
						//sheetObj.CellValue2(Row,"cre_usr_id")   = "";
						sheetObj.CellValue2(Row,"cre_usr_id")   = DomXml2String(sXml,"cre_usr_id");
						if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
				       		 ComShowCodeMessage('CGM10066',formObj.eq_no.value);
				           	 return false;
				       	} 
					}
					
					sheetObj.CellValue2(Row,"eq_tpsz_cd")       = DomXml2String(sXml,"eq_tpsz_cd");
					sheetObj.CellValue2(Row,"mft_dt")           = DomXml2String(sXml,"mft_dt");
					sheetObj.CellValue2(Row,"chss_tare_wgt")    = DomXml2String(sXml,"chss_tare_wgt");
					sheetObj.CellValue2(Row,"chss_rgst_ste_cd") = DomXml2String(sXml,"chss_rgst_ste_cd");
					sheetObj.CellValue2(Row,"chss_rgst_yr")     = DomXml2String(sXml,"chss_rgst_yr");

					sheetObj.CellValue2(Row,"chss_rgst_exp_dt") = DomXml2String(sXml,"chss_rgst_exp_dt");
					sheetObj.CellValue2(Row,"chss_rgst_lic_no") = DomXml2String(sXml,"chss_rgst_lic_no");
					sheetObj.CellValue2(Row,"chss_veh_id_no")   = DomXml2String(sXml,"chss_veh_id_no");
					sheetObj.CellValue2(Row,"chss_tit_no")      = DomXml2String(sXml,"chss_tit_no");
					sheetObj.CellValue2(Row,"chss_als_no")      = DomXml2String(sXml,"chss_als_no");

					sheetObj.CellValue2(Row,"n2nd_chss_als_no") = DomXml2String(sXml,"n2nd_chss_als_no");
					sheetObj.CellValue2(Row,"agreement_no")     = DomXml2String(sXml,"agreement_no");
					sheetObj.CellValue2(Row,"agmt_ver_no")      = DomXml2String(sXml,"agmt_ver_no");
					
					sheetObj.CellValue2(Row,"vndr_seq")         = DomXml2String(sXml,"vndr_seq");
					sheetObj.CellValue2(Row,"agmt_lstm_cd")     = DomXml2String(sXml,"agmt_lstm_cd");
					
					if(formObj.ownleas[0].checked != true){
						sheetObj.CellEditable(Row, "eq_tpsz_cd")       = true;
					}
					
					sheetObj.CellEditable(Row, "mft_dt")           = true;
					sheetObj.CellEditable(Row, "chss_tare_wgt")    = true;
					sheetObj.CellEditable(Row, "chss_rgst_ste_cd") = true;
					sheetObj.CellEditable(Row, "chss_rgst_yr")     = true;
					
					sheetObj.CellEditable(Row,"chss_rgst_exp_dt")  = true;
					sheetObj.CellEditable(Row,"chss_rgst_lic_no")  = true;
					sheetObj.CellEditable(Row,"chss_veh_id_no")    = true;
					sheetObj.CellEditable(Row,"chss_tit_no")       = true;
					sheetObj.CellEditable(Row,"chss_als_no")       = true;

					sheetObj.CellEditable(Row,"n2nd_chss_als_no")  = true;
					
				} else {
					// 데이타가 존재하지 않을 경우
					sheetObj.CellValue2(Row,"eq_tpsz_cd")       = "";
					sheetObj.CellValue2(Row,"mft_dt")           = "";
					sheetObj.CellValue2(Row,"chss_tare_wgt")    = "";
					sheetObj.CellValue2(Row,"chss_rgst_ste_cd") = "";
					sheetObj.CellValue2(Row,"chss_rgst_yr")     = "";

					sheetObj.CellValue2(Row,"chss_rgst_exp_dt") = "";
					sheetObj.CellValue2(Row,"chss_rgst_lic_no") = "";
					sheetObj.CellValue2(Row,"chss_veh_id_no")   = "";
					sheetObj.CellValue2(Row,"chss_tit_no")      = "";
					sheetObj.CellValue2(Row,"chss_als_no")      = "";

					sheetObj.CellValue2(Row,"n2nd_chss_als_no") = "";
					sheetObj.CellValue2(Row,"agreement_no")     = "";
					sheetObj.CellValue2(Row,"agmt_ver_no")      = "";
					sheetObj.CellValue2(Row,"cre_usr_id")       = document.forms[0].cre_id.value;
					sheetObj.CellValue2(Row,"vndr_seq")         = "";
					sheetObj.CellValue2(Row,"agmt_lstm_cd")     = "";
					if(formObj.ownleas[0].checked == true){
 
						ComShowCodeMessage("CGM20003");
			        	// 해당 Cell 값을 Null로 설정
						sheetObj.CellValue(Row, "eq_no") = "";
						sheetObj.SelectCell(Row, "eq_no", true);
						 return false;
					}
					
					if(formObj.ownleas[0].checked != true){
						sheetObj.CellEditable(Row, "eq_tpsz_cd")       = true;
					}
					sheetObj.CellEditable(Row, "mft_dt")           = true;
					sheetObj.CellEditable(Row, "chss_tare_wgt")    = true;
					sheetObj.CellEditable(Row, "chss_rgst_ste_cd") = true;
					sheetObj.CellEditable(Row, "chss_rgst_yr")     = true;
					
					sheetObj.CellEditable(Row,"chss_rgst_exp_dt")  = true;
					sheetObj.CellEditable(Row,"chss_rgst_lic_no")  = true;
					sheetObj.CellEditable(Row,"chss_veh_id_no")    = true;
					sheetObj.CellEditable(Row,"chss_tit_no")       = true;
					sheetObj.CellEditable(Row,"chss_als_no")       = true;

					sheetObj.CellEditable(Row,"n2nd_chss_als_no")  = true;
				}
			} else {
				// 데이타가 존재하지 않을 경우
				sheetObj.CellValue2(Row,"eq_tpsz_cd")       = "";
				sheetObj.CellValue2(Row,"mft_dt")           = "";
				sheetObj.CellValue2(Row,"chss_tare_wgt")    = "";
				sheetObj.CellValue2(Row,"chss_rgst_ste_cd") = "";
				sheetObj.CellValue2(Row,"chss_rgst_yr")     = "";

				sheetObj.CellValue2(Row,"chss_rgst_exp_dt") = "";
				sheetObj.CellValue2(Row,"chss_rgst_lic_no") = "";
				sheetObj.CellValue2(Row,"chss_veh_id_no")   = "";
				sheetObj.CellValue2(Row,"chss_tit_no")      = "";
				sheetObj.CellValue2(Row,"chss_als_no")      = "";

				sheetObj.CellValue2(Row,"n2nd_chss_als_no") = "";
				sheetObj.CellValue2(Row,"agreement_no")     = "";
				sheetObj.CellValue2(Row,"agmt_ver_no")      = "";
				sheetObj.CellValue2(Row,"cre_usr_id")       = document.forms[0].cre_id.value;
				sheetObj.CellValue2(Row,"vndr_seq")         = "";
				sheetObj.CellValue2(Row,"agmt_lstm_cd")     = "";
				sheetObj.CellEditable(Row, "eq_tpsz_cd")       = false;
				sheetObj.CellEditable(Row, "mft_dt")           = false;
				sheetObj.CellEditable(Row, "chss_tare_wgt")    = false;
				sheetObj.CellEditable(Row, "chss_rgst_ste_cd") = false;
				sheetObj.CellEditable(Row, "chss_rgst_yr")     = false;
				sheetObj.CellEditable(Row, "chss_rgst_exp_div")= false;
				sheetObj.CellEditable(Row,"chss_rgst_exp_dt")  = false;
				sheetObj.CellEditable(Row,"chss_rgst_lic_no")  = false;
				sheetObj.CellEditable(Row,"chss_veh_id_no")    = false;
				sheetObj.CellEditable(Row,"chss_tit_no")       = false;
				sheetObj.CellEditable(Row,"chss_als_no")       = false;

				sheetObj.CellEditable(Row,"n2nd_chss_als_no")  = false;
			}
			
			if(sheetObj.CellValue(Row, "chss_rgst_exp_div") == 'P'){
				sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = false;
			} else {
				sheetObj.CellEditable(Row, "chss_rgst_exp_dt") = true;
			}
			sheetObj.CellEditable(Row, "chss_rgst_exp_div") = true;
			break;
		case "chss_veh_id_no":
		    if(sheetObj.CellValue(Row, "chss_veh_id_no") == "" || sheetObj.CellValue(Row, "chss_veh_id_no") == null){
		    	return;
		    } else {
		    	formObj.chss_veh_id_no_tmp.value = sheetObj.CellValue(Row, "chss_veh_id_no");
		    	formObj.eq_no.value = sheetObj.CellValue(Row, "eq_no");
				formObj.chss_als_no_tmp.value    = sheetObj.CellValue(Row, "chss_als_no");
				formObj.chss_tit_no_tmp.value    = sheetObj.CellValue(Row, "chss_tit_no");
				formObj.n2nd_chss_als_no_tmp.value = sheetObj.CellValue(Row, "n2nd_chss_als_no");
				formObj.f_cmd.value = SEARCH03;
			    var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do", FormQueryString(formObj));

			    // 데이타 건수
			    var dataCount = ComGetTotalRows(sXml);
			    if(dataCount > 0){
			    	// 데이타가 있을 경우 메세지
			    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
			    	sheetObj.CellValue2(Row, Col) = "";
			    	sheetObj.SelectCell(Row, Col, true);
			    } else {
			    	//데이타가 없을 경우
			    	return;
			    }
		    }
			break;

		case "chss_tit_no":
			if(sheetObj.CellValue(Row, "chss_tit_no") == "" || sheetObj.CellValue(Row, "chss_tit_no") == null){
		    	return;
		    } else {
		    	formObj.chss_veh_id_no_tmp.value = sheetObj.CellValue(Row, "chss_veh_id_no");
		    	formObj.eq_no.value = sheetObj.CellValue(Row, "eq_no");
				formObj.chss_als_no_tmp.value    = sheetObj.CellValue(Row, "chss_als_no");
				formObj.chss_tit_no_tmp.value    = sheetObj.CellValue(Row, "chss_tit_no");
				formObj.n2nd_chss_als_no_tmp.value = sheetObj.CellValue(Row, "n2nd_chss_als_no");
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do", FormQueryString(formObj));
			    
				// 데이타 건수
				var dataCount = ComGetTotalRows(sXml);
				if(dataCount > 0){
			    	// 데이타가 있을 경우 메세지
			    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
			    	sheetObj.CellValue2(Row, Col) = "";
			    	sheetObj.SelectCell(Row, Col, true);
			    } else {
			    	//데이타가 없을 경우
			    	return;
			    }
			}
			break;

		case "chss_als_no":
			if(sheetObj.CellValue(Row, "chss_als_no") == "" || sheetObj.CellValue(Row, "chss_als_no") == null){
		    	return;
		    } else {
		    	formObj.chss_veh_id_no_tmp.value = sheetObj.CellValue(Row, "chss_veh_id_no");
		    	formObj.eq_no.value = sheetObj.CellValue(Row, "eq_no");
				formObj.chss_als_no_tmp.value    = sheetObj.CellValue(Row, "chss_als_no");
				formObj.chss_tit_no_tmp.value    = sheetObj.CellValue(Row, "chss_tit_no");
				formObj.n2nd_chss_als_no_tmp.value = sheetObj.CellValue(Row, "n2nd_chss_als_no");
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do" , FormQueryString(formObj));
				
				// 데이타 건수
				var dataCount = ComGetTotalRows(sXml);
			    if(dataCount > 0){
			    	// 데이타가 있을 경우 메세지
			    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
			    	sheetObj.CellValue2(Row, Col) = "";
			    	sheetObj.SelectCell(Row, Col, true);
			    } else {
			    	//데이타가 없을 경우
			    	if(sheetObj.CellValue(Row, "chss_als_no") == sheetObj.CellValue(Row, "n2nd_chss_als_no"))
			    	{
			    		//ComShowMessage('Please check up the Duplicated Alias No1');
						ComShowCodeMessage("CGM10017","Alias No1");
			    		sheetObj.CellValue2(Row, Col) = "";
			    		sheetObj.SelectCell(Row, Col, true);
			    	}
			    	return;
			    }
		    }
			break;

		case "n2nd_chss_als_no":
			if(sheetObj.CellValue(Row, "n2nd_chss_als_no") == "" || sheetObj.CellValue(Row, "n2nd_chss_als_no") == null){
		    	return;
		    } else {
		    	formObj.chss_veh_id_no_tmp.value = sheetObj.CellValue(Row, "chss_veh_id_no");
		    	formObj.eq_no.value = sheetObj.CellValue(Row, "eq_no");
				formObj.chss_als_no_tmp.value    = sheetObj.CellValue(Row, "chss_als_no");
				formObj.chss_tit_no_tmp.value    = sheetObj.CellValue(Row, "chss_tit_no");
				formObj.n2nd_chss_als_no_tmp.value = sheetObj.CellValue(Row, "n2nd_chss_als_no");
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchXml("EES_CGM_1008GS.do" , FormQueryString(formObj));
				
				// 데이터 건수
				var dataCount = ComGetTotalRows(sXml);
			    if(dataCount > 0){
			    	// 데이타가 있을 경우 메세지
			    	ComShowCodeMessage("CGM10017", DomXml2String(sXml, "eq_no"));
			    	sheetObj.CellValue2(Row, Col) = "";
			    	sheetObj.SelectCell(Row, Col, true);
			    } else {
			    	//데이타가 없을 경우
			    	if(sheetObj.CellValue(Row, "chss_als_no") == sheetObj.CellValue(Row, "n2nd_chss_als_no"))
			    	{
			    		//ComShowMessage('Please check up the Duplicated Alias No2');
						ComShowCodeMessage("CGM10017","Alias No2");
			    		sheetObj.CellValue2(Row, Col) = "";
			    		sheetObj.SelectCell(Row, Col, true);
			    	}
			    	return;
			    }
		    }
			break;
			
		case "chss_rgst_exp_div":
			if(CellValue(Row, "chss_rgst_exp_div") == 'F'){
				CellEditable(Row, "chss_rgst_exp_dt") = true;
			} else {
				// 셀 값을 삭제하고 읽기 속성을 부여한다.
				CellValue2(Row, "chss_rgst_exp_dt") = "";
				CellEditable(Row, "chss_rgst_exp_dt") = false;
			}
			break;
		}
	}
}

/**
 * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;
	 
	 switch(obj.dataformat) {
  	    case "engup":
    		ComKeyOnlyAlphabet("uppernum");
	        break;
  	    case "enghi":
  	    	ComKeyOnlyAlphabet("upper");
  	    	break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
	    case "int":
 	    	ComKeyOnlyNumber(obj);
 	        break;
 	    // 일달력
  	 	case "ymd":
  	 		ComKeyOnlyNumber(obj);
  	        break;
  	  	   // 월달력
  	 	case "ym":
  	 		ComKeyOnlyNumber(obj);
  	        break;
  	  	   // 시분
  	 	case "hm":
  	 		ComKeyOnlyNumber(obj);
  	        break;
	 }
}


/**
 * AXON 이벤트 처리
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


/** 
 * OBJECT DEACTIVATE 이벤트에 대한 처리  <br>
 */
function obj_deactivate(){
	var formObj = document.form;
	obj = event.srcElement;
	
	if(obj.name == "onh_dt"){
		with(formObj){
			var creDtFr = ComReplaceStr(onh_dt.value, "-", "");
		}
        ComChkObjValid(event.srcElement);
	}
   else if(obj.name == "onh_dt_hm"){
		with(formObj){
			var onhDtHm = ComReplaceStr(onh_dt_hm.value, ":", "");
		}
		ComChkObjValid(event.srcElement);
	}
}


/**
 * PROGRAMNO POPUP 에서 해당하는 값들 입력부분.
 */   
function setProgramNo(aryPopupData, row, col, sheetIdx){
	 var formObj  = document.form;
	 var sheetObj = sheetObjects[0];
	 var agreeNo  = "";
	 var referNo  = "";
	 var lessNm   = "";
	 var lstmCd   = "";
	 var vndrSq   = "";
	 var agmtVerNo   = "";
	 var i = 0;
	 for(i = 0; i < aryPopupData.length; i++){
/*
		 //유지보수시 값 확인 하기 위하여 아래 로그 남겨 놓음 지우지 마세요.
		 ComShowMessage(aryPopupData[i][0]); // 1
		 ComShowMessage(aryPopupData[i][1]); // 0
		 ComShowMessage(aryPopupData[i][2]); // NYC000027
		 ComShowMessage(aryPopupData[i][3]); // ZOWGN85003
		 ComShowMessage(aryPopupData[i][4]); // OW
		 ComShowMessage(aryPopupData[i][5]); // 111635
		 ComShowMessage(aryPopupData[i][6]); // SM Line Corporation
		 ComShowMessage(aryPopupData[i][7]); // 19930601
		 ComShowMessage(aryPopupData[i][8]); // 20101231
		 ComShowMessage(aryPopupData[i][9]); // SELCOE
		 ComShowMessage(aryPopupData[i][10]);// 19980329  
*/
		 vndrSq   = vndrSq  + aryPopupData[i][5];  // vndr_seq
		 agreeNo  = agreeNo + aryPopupData[i][2];  // agreement_no
		 referNo  = referNo + aryPopupData[i][3];  // reference_no
		 lstmCd   = lstmCd  + aryPopupData[i][4];  // lease term
		 lessNm   = lessNm  + aryPopupData[i][6];  // lessor
		 agmtVerNo = aryPopupData[i][11];  // lessor
	 }
	 
     if(formObj.ownleas[0].checked == true  ){
    	 if(lstmCd !="OW" && lstmCd !="OL" && lstmCd !="LP"){
    		 ComShowCodeMessage('CGM10066',agreeNo);
        	 return false;
    	 } else {
    		 formObj.vndr_seq.value        = vndrSq;
    		 formObj.agreement_no.value    = agreeNo;
    		 formObj.agmt_ref_no.value     = referNo;
    		 formObj.agmt_lstm_cd.value    = lstmCd;
    		 // AGREEMENT NO POST PROCESS CALL
    		 formObj.vndr_lgl_eng_nm.value = lessNm;
    		 formObj.agmt_ver_no.value     = agmtVerNo;
    		 agreementNoChk(lstmCd);
    	 }
    	 
     } else if(formObj.ownleas[1].checked == true ){
    	 if(lstmCd =="OW" || lstmCd =="OL" || lstmCd =="LP"){
    		 ComShowCodeMessage('CGM10065',agreeNo);
        	 return false;
    	 }  else if(lstmCd =="CP"  ){
       		 ComShowCodeMessage('CGM10029');
           	 return false;
    	 } else {
    		 formObj.vndr_seq.value        = vndrSq;
    		 formObj.agreement_no.value    = agreeNo;
    		 formObj.agmt_ref_no.value     = referNo;
    		 formObj.agmt_lstm_cd.value    = lstmCd;
    		 // AGREEMENT NO POST PROCESS CALL
    		 formObj.vndr_lgl_eng_nm.value = lessNm;
    		 formObj.agmt_ver_no.value     = agmtVerNo;
    		 agreementNoChk(lstmCd);
    	 }
    	 
     }
     
	
}


/**
 * AGREEMENT NO POST PROCESS CALL
 */
function agreementNoChk(lstmCd){
	var formObj = document.form;
	if(formObj.ownleas[0].checked == true){
		if(!(lstmCd == "OW" || lstmCd == "OL" || lstmCd =="LP")){
			// 메세지를 띠워주고 해당 오브젝트를 초기화
			ComShowCodeMessage('CGM10029');
			formObj.agreement_no.value    = "";
			formObj.agmt_ref_no.value     = "";
			formObj.agmt_lstm_cd.value    = "";
			formObj.vndr_lgl_eng_nm.value = "";
			formObj.agreement_no.focus();
		}
	}
}


/**
 * Object 의 Keydown 이벤트에 대한 처리  <br>
 * 객체가 agreement_no 일 경우에만 enter 키 발생시 조회실행.  <br>
 */ 
function obj_keydown(){
	var obj = event.srcElement;
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    	
    switch(obj.name){
    case 'agreement_no':
//    	var keyValue = null;
//        if(event == undefined || event == null) {
//        	keyValue = 13;
//        } else {
//        	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//        }
//
//        if(keyValue != 13) return;
//            	
//    	var agmtNo = formObj.agreement_no.value;
//    	var result = true;
//    	 		
//    	if(agmtNo != ""){
//    		if(agmtNo.length <= 3){
//    			result = false;
//    		} else {
//    			if(ComIsNumber(agmtNo.substring(3))==false){
//    				result = false;
//    			}
//    		}
//    	} else {
//    		result = true;
//    	}
//
//    	if(!result){
//    		ComShowCodeMessage('CGM10004','Agreement No.');
//    		formObj.agreement_no.value = "";
//    	 	ComSetFocus(formObj.agreement_no);
//    	} else {
//    		if(!doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01)){
//    			formObj.agreement_no.focus();
//    		} else {
//    			ComKeyEnter();
//    		}
//    	}
//    	break;
    }
}


/**
 * 선택된 ROW 삭제 
 */
function rowDelete(sheetObj){
	for(i=sheetObj.rowCount; i>0; i--){
		if(sheetObj.CellValue(i, "ibflag") != ""   &&  sheetObj.CellValue(i, "del_chk") == "1") {
			sheetObj.RowDelete(i, false);
		}
	}
}


/**
 * 시트내 팝업 클릭(달력 호출)
 */
function sheet1_OnPopupClick(sheetObj, row, col){
	switch (sheetObj.ColSaveName(col)) {
	case "mft_dt" :
		if (sheetObj.ColSaveName(col) != "mft_dt"){
			return;
		}
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		break;

	case "chss_rgst_exp_dt" :
		if (sheetObj.ColSaveName(col) != "chss_rgst_exp_dt"){
			return;
		}
		var cal = new ComCalendarGrid("myCal");
		cal.select(sheetObj, row, col, 'yyyy-MM-dd');
		break;
	}
}


/**
 * OWN, Leased 라디오 버튼
 */
function obj_onclick(radioObj){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	if(formObj.ownleas[0].checked == true){
		formObj.own_lse.value = "O";
	} else {
		formObj.own_lse.value = "L";
	}
}

//아래 공통에서 퍼온 소스이므로 그대로 사용(수정할 사항 없슴)//////////////////////////////////


/** 
 * Object 의 focusout 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 최민회
 * @version 2009.05.20
 */  
    function obj_focusout(){
    	 var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 obj = event.srcElement;
    	 switch(obj.name){
 	 
    	   case "onh_ofc_cd":
    	 		if(formObj.onh_ofc_cd.value != ''){
    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
    	 			Verify_Status_chk();
    	 			break;
    	 		} 
    	 		break;
    	   case "onh_yd_cd":
    		    // chungpa 20100414 keyup->focusout start
	    	    var onh_yd_cd;
		    	onh_yd_cd = formObj.onh_yd_cd.value;
		    	if (onh_yd_cd.length == 7) {
		    		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
		    	}
		    	// chungpa 20100414 keyup->focusout end
				break;
    	   case "agreement_no":
    		   
    		   if(formObj.agreement_no.value != ''){
      	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
      	 			Verify_Status_chk();
      	 			break;
    		   } else if(formObj.agreement_no.value == ''){
    			   formObj.agmt_ref_no.value ="";
    			   formObj.agmt_lstm_cd.value ="";
    			   formObj.vndr_lgl_eng_nm.value ="";
    			   Verify_Status_chk();
      	 			break;
    		   }
    		   break;
    	   case "onh_dt":
    		   
    		   if(formObj.onh_dt.value != ''){
     	 			if(ComGetUnMaskedValue(formObj.onh_dt.value, "ymd") > ComGetUnMaskedValue(formObj.form_day.value, "ymd")){
						ComShowCodeMessage("CGM10062");
      	 				formObj.onh_dt.value ="";
      	 				formObj.onh_dt.focus();
      	 			}
      	 			
    		   } 
    		   Verify_Status_chk();
    		   break;
    	   case "onh_dt_hm" :
	    	   Verify_Status_chk();
			   break;
    	 }   
    }
 
     /**
      * YA_CD 값 체크
      * @return
      */
     function obj_keyup(){
		 var formObj = document.form;
		 var sheetObj = sheetObjects[0];
		 obj = event.srcElement;
		 switch(obj.name){
		 	case "onh_yd_cd":
		 		// chungpa 20100414 keyup->focusout start
		 		ComKeyEnter('lengthnextfocus');
		    	// chungpa 20100414 keyup->focusout start end 
		    	break;
		 }
	}
    
 /**
  * OWN,Leased 선택시 화면 초기 화 
  * @param a
  * @return
  */
    function chk(a){
    	var formObj = document.form;
    	 var sheetObj = sheetObjects[0]; 
    	 sheetObj.RemoveAll();
			// HTML OBJECT RESET
    	 formObj.reset();
    	 if(a=="O"){
    		 formObj.ownleas[0].checked = true;
    	 } else {
    		 formObj.ownleas[1].checked = true;
    	 }
    	 yard_Chk();
    }
  
//저장후 조회 기능 
  function sheet1_OnSaveEnd(sheetObj, errMsg) {
	  if(errMsg =='') {   
		  ComShowCodeMessage('CGM00003');
            for(i=sheetObj.LastRow; i>0; i--){
			  if(sheetObj.CellValue(i, "del_chk") == "1" ){
				  sheetObj.RowDelete(i, false);
			  } 
			}
		}
  }    

/**
 * Form 의 Date yard 제어
 * @return
 * @author 최민회
 * @version 2009.06.04
 */
function yard_Chk(){
	  formObj = document.form;
	  var l_chk ,f_chk;
	  var l_cName,f_cName;
	  if(formObj.ownleas[0].checked == true){

		  l_chk = true;
		  f_chk = false;
		  l_cName = "input2";
		  formObj.agreement_no.value="";
	  } else {
 		  l_chk = false;
 		  f_chk = true;
		  l_cName = "input1";
	  }
	  
	  formObj.agreement_no.readOnly = l_chk;
      ComEnableObject(formObj.ComOpenPopupWithTargetAgree, f_chk);
      formObj.agreement_no.className = l_cName;
}

 
 /**
  * 야드와 오피스 체크
  * @param chk
  * @return
  */
 function Matched_Chk(chk){
	 formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 if(formObj.onh_yd_cd.value != "" && formObj.onh_ofc_cd.value != "" ){
		 
		    formObj.f_cmd.value = SEARCH01;
		    formObj.ofc_cd.value = formObj.onh_ofc_cd.value;		//   ( location)
		    formObj.loc_cd.value = formObj.onh_yd_cd.value.substr(0,5);
	   		var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do", FormQueryString(formObj));
		    if(DomXml2String(sXml, "chk")!="OK"){
				ComShowCodeMessage("CGM10028");
				if(chk == 'Yard'){
					formObj.onh_yd_cd.value = "";
					formObj.onh_yd_cd.focus();
				} else {
					formObj.onh_ofc_cd.value = "";
					formObj.onh_ofc_cd.focus();
				}
				
				return;
		    }
		 
	 }
	 
 }
 
 function Verify_Status_chk(){
	 var sheetObj = sheetObjects[0];
	 for(i=1; i<sheetObj.rowCount+1; i++){
		 sheetObj.CellValue(i, "verify") = "";
	 }
	 
 }
/* 개발자 작업 끝 */
