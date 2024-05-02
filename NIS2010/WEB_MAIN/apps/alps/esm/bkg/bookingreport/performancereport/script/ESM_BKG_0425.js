/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESM_BKG_0425.js
 *@FileTitle : Email Account Set-up for Front Office
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.03.07
 *@LastModifier : 김기종
 *@LastVersion : 1.0
 * 2011.03.07 김기종
 * 1.0 Creation
 * 2011.11.23 정선용 [CHM-201113594-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
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
 * @class ESM_BKG_0425 : ESM_BKG_0425 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0425() {
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
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;

			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;

			case "btn_downexcel":
				sheetObject.SpeedDown2Excel(-1);
				break;

			case "btn_add":
				doActionIBSheet(sheetObjects[0], formObject, IBINSERT);
				break;

			case "btn_delete":
				doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObject = document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 **/
function obj_keypress() {
	switch (event.srcElement.dataformat) {
		case "int":
			//숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
			break;
		case "float":
			//숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, ".");
			break;
		case "eng":
			//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
			ComKeyOnlyAlphabet();
			break;
		case "engdn":
			//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
			ComKeyOnlyAlphabet('lower');
			break;
		case "engup":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('upper');
			break;
		case "engupnum":
			//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
			ComKeyOnlyAlphabet('uppernum');
			break;
		default:
			//숫자만입력하기(정수,날짜,시간)
			ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
		case "sheet1":
			with (sheetObj) {

				// 높이 설정
				style.height = 400;
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
				InitRowInfo(2, 1, 9, 100);
				var HeadTitle1 = " |Del.|BKG\nOffice|Inc\nSub.|SVC Kind|Criteria|Priority|Contents of Criteria|Contents of Criteria|Contents of Criteria|Contents of Criteria|Contents of Criteria|Copy To Email Address|Region|By|Update Time|eml_acct_seq";
				var HeadTitle2 = " |Del.|BKG\nOffice|Inc\nSub.|SVC Kind|Criteria|Priority|Value|POL|by|DEL|by|Copy To Email Address|Region|By|Update Time|eml_acct_seq";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false, false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheck,	30,		daCenter,	true,		"del_chk");
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,		"ibflag");
				InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"bkg_ofc_cd",				true,		"",		dfNone,		0,		false,		true,	6);
				InitDataProperty(0, cnt++ , dtCheckBox,	40,		daCenter,	true,		"incl_sub_ofc_flg",			false,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		"dpcs_eml_svc_knd_cd",		true,		"",		dfNone,		0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		"dpcs_eml_stnd_grp_tp_cd",	true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,	50,		daCenter,	true,		"eml_prio_no",				false,		"",		dfNone,		0,		true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"vbs_ctnt",					false,		"",		dfNone,		0,		true,		false,	10);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"pol_cd",					false,		"",		dfNone,		0,		true,		false,	5);
				InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		"pol_dpcs_eml_loc_grp_tp_cd",false,		"",		dfNone,		0,		true,		false);
				InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,		"del_cd",					false,		"",		dfNone,		0,		true,		false,	5);
				InitDataProperty(0, cnt++ , dtCombo,	70,		daCenter,	true,		"del_dpcs_eml_loc_grp_tp_cd",false,		"",		dfNone,		0,		true,		false);
				
				InitDataProperty(0, cnt++ , dtData,		200,	daLeft,		true,		"eml_cpy_to_eml",			true,		"",		dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtCombo,	70,		daLeft,		true,		"rgn_ofc_cd",				false,		"",		dfNone,		0,		true,		true,	6);
				InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"upd_usr_id",				false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"upd_dt",					false,		"",		dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtHidden,	40,		daCenter,	true,		"eml_acct_seq",				false,		"",		dfNone,		0,		false,		false);
				CountPosition = 2;
				
				//영문과 "1", "2", "3", "9" ,'@' 글자도 입력하기
				InitDataValid(0, "eml_cpy_to_eml", vtEngOther, "1234567890@_-.");
				InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
				InitDataValid(0, "vbs_ctnt",vtEngUpOther, "1234567890");
				InitDataValid(0, "pol_cd", vtEngUpOnly);
				InitDataValid(0, "del_cd", vtEngUpOnly);
				InitDataValid(0, "eml_prio_no", vtNumericOnly);
				FocusEditMode = -1;
				SelectHighLight = false;
				FrozenCols = 7;

			}
			break;

	}
}
//Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg = false;
     switch(sAction) {
         case IBCLEAR: // 화면 로딩시 코드 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0425GS.do",FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0){ 
					arrXml[0] = ComReplaceStr(arrXml[0], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObj,  arrXml[0], "dpcs_eml_svc_knd_cd",false,"","","","cd");
				}	
				if (arrXml.length > 1){ 
					arrXml[1] = ComReplaceStr(arrXml[1], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObj,  arrXml[1], "dpcs_eml_stnd_grp_tp_cd",true,"","","","cd");
				}	
				if (arrXml.length > 2){ 
					arrXml[2] = ComReplaceStr(arrXml[2], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObj,  arrXml[2], "pol_dpcs_eml_loc_grp_tp_cd" ,false,"","","","cd");
					ComSetIBCombo(sheetObj,  arrXml[2], "del_dpcs_eml_loc_grp_tp_cd" ,false,"","","","cd");
				}
				if (arrXml.length > 3){ 
					arrXml[3] = ComReplaceStr(arrXml[3], "val|multidesc|ibflag|desc|name|", "cd|multidesc|ibflag|desc|nm|");
					ComSetIBCombo(sheetObj,  arrXml[3], "rgn_ofc_cd" ,false,"","","","cd");
				}
				
				break;	
        case IBSEARCH:      //조회
	          if(validateForm(sheetObj,formObj,sAction)){
	        	  formObj.f_cmd.value = SEARCH;
	        	  sheetObj.WaitImageVisible = false;
	        	  ComOpenWait(true);
	        	  var sXml = sheetObj.GetSearchXml("ESM_BKG_0425GS.do",FormQueryString(formObj));
	        	  sheetObj.LoadSearchXml(sXml);
	        	  ComOpenWait(false);
	          }	
            	break;

        case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					/*var rowM = sheetObjects[0].ColValueDup("bkg_ofc_cd|dpcs_eml_svc_knd_cd|pol_cd|del_cd");
					if (rowM >= 0) {
						 var msg = ComGetMsg("BKG06018");
						 msg += "\n----------------------------------";
						 msg += "\nBKG Office : " + sheetObjects[0].CellValue(rowM, "bkg_ofc_cd");
						 msg += "\nSVC Kind : " + sheetObjects[0].CellValue(rowM, "dpcs_eml_svc_knd_cd");
						 msg += "\nEmail : " + sheetObjects[0].CellValue(rowM, "dpcs_eml_svc_knd_cd");
						 msg += "\nPol : " + sheetObjects[0].CellValue(rowM, "pol_cd");
						 msg += "\nDel : " + sheetObjects[0].CellValue(rowM, "del_cd");
						 msg += "\n----------------------------------";
						 alert(msg);
						 return false;
				    }	 */
					sheetObj.WaitImageVisible = false;
		        	ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					
					sheetObj.DoSave("ESM_BKG_0425GS.do", FormQueryString(formObj));
					/*
					if (sheetObj.EtcData("TRANS_RESULT_KEY") != 'F') {
			        	doActionIBSheet(sheetObj,formObj,IBSEARCH);
		        	}*/
					ComOpenWait(false);
				}
				break;
        
			case IBINSERT:      // 입력
				//신규행 추가
				sheetObj.DataInsert(-1);
				sheetObj.SelectCell(sheetObj.LastRow, "bkg_ofc_cd");
				break;
			case IBDELETE:      // 삭제
				//행 삭제 FLAG처리
				sheetObj.CellValue2(sheetObj.SelectRow, "ibflag") = "D";
				ComRowHideDelete(sheetObj, "del_chk");
				break;	
     }
 }

 /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
 function validateForm(sheetObj,formObj,sAction){
 	switch(sAction) {
         case IBSAVE: // 저장시 확인
      		if (!ComChkValid(formObj)) return false;
      		break;
     }
     return true;
 }
  function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var param;
	with (sheetObj) {

		var sName = ColSaveName(Col);
		if (CellValue(Row, Col) == "")
			return;

		if (sName == 'bkg_ofc_cd') {
			if (CellValue(Row, 'bkg_ofc_cd') != "") {
				param = param + "&f_cmd=" + COMMAND01;
				param = param + "&bkg_ofc_cd=" + CellValue(Row, Col);
				checkSheetCode(sheetObj, Row, Col, param);
			}
		} else if (sName == 'vbs_ctnt' && CellValue(Row, "dpcs_eml_stnd_grp_tp_cd") != "") {
			if (ComTrim(CellValue(Row, 'vbs_ctnt')) != "") {
				param = param + "&f_cmd=" + COMMAND01;
				param = param + "&dpcs_eml_stnd_grp_tp_cd=" + CellValue(Row, "dpcs_eml_stnd_grp_tp_cd");
				param = param + "&vbs_ctnt=" + CellValue(Row, "vbs_ctnt");
				checkSheetCode(sheetObj, Row, Col, param);
			}
		} else if (sName == 'pol_cd') {
			if (CellValue(Row, 'pol_cd') != "" && CellValue(Row, "pol_dpcs_eml_loc_grp_tp_cd") != "") {
				param = param + "&f_cmd=" + COMMAND01;
				param = param + "&pol_dpcs_eml_loc_grp_tp_cd=" + CellValue(Row, "pol_dpcs_eml_loc_grp_tp_cd");
				param = param + "&pol_cd=" + CellValue(Row, "pol_cd");
				checkSheetCode(sheetObj, Row, Col, param);
			}
		} else if (sName == 'del_cd') {
			if (CellValue(Row, 'del_cd') != "" && CellValue(Row, "del_dpcs_eml_loc_grp_tp_cd") != "") {
				param = param + "&f_cmd=" + COMMAND01;
				param = param + "&del_dpcs_eml_loc_grp_tp_cd=" + CellValue(Row, "del_dpcs_eml_loc_grp_tp_cd");
				param = param + "&del_cd=" + CellValue(Row, "del_cd");
				checkSheetCode(sheetObj, Row, Col, param);
			}
		}

		//SaveName을 이용하여 컬럼 번호을 가져온다.
		var iCol = SaveNameCol("dpcs_eml_stnd_grp_tp_cd");
		if (Col == iCol) {
			setSheetCellEditable(sheetObj, Row, CellValue(Row, "dpcs_eml_stnd_grp_tp_cd"),false);
		}
		
		if (Col == SaveNameCol("bkg_ofc_cd")) {
			setSheetCellEditable(sheetObj, Row, CellValue(Row, "dpcs_eml_stnd_grp_tp_cd"),false);
		}

	}
} 
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	with(sheetObj){
	  for (i=1; i<= LastRow; i++) {
		  setSheetCellEditable(sheetObj, i, CellValue(i, "dpcs_eml_stnd_grp_tp_cd"),true);
	  }
	}
 }
 function setSheetCellEditable(sheetObj, row, val,loadingMode){
	with(sheetObj){
		  if (val == "L" || val == "S" || val == "O"){
			  CellEditable(row,"pol_dpcs_eml_loc_grp_tp_cd") = false;
			  CellEditable(row,"pol_cd") = false;
			  CellEditable(row,"del_dpcs_eml_loc_grp_tp_cd") = false;
			  CellEditable(row,"del_cd") = false;
			  if (val == "O"){
				  CellEditable(row,"vbs_ctnt") = false;
				  if (loadingMode == false){
					  CellValue2(row, "vbs_ctnt") = CellValue(row, "bkg_ofc_cd");
				  }
			  }else{
				  CellEditable(row,"vbs_ctnt") = true;
				  if (loadingMode == false){
					  CellValue2(row, "vbs_ctnt") = "";
				  }	  
			  }	  
		  }else if (val == "R" ){
			  CellEditable(row,"pol_dpcs_eml_loc_grp_tp_cd") = true;
			  CellEditable(row,"pol_cd") = true;
			  CellEditable(row,"del_dpcs_eml_loc_grp_tp_cd") = true;
			  CellEditable(row,"del_cd") = true;
			  CellEditable(row,"vbs_ctnt") = false;
			  CellValue2(row, "vbs_ctnt") = "";
		  }
	}
}
 
function checkSheetCode(sheetObj,Row,Col,param) {
	var formObj = document.form;
	var param;
	with (sheetObj) {
		if (CellValue(Row, Col) == "")
			return;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0425GS.do", param);
		if (ComResultMessage(sXml) != '') {
			alert(ComResultMessage(sXml));
			CellValue2(Row, Col) = "";
			SelectCell(Row, Col, false);
			return;
		}
	}
}
 
/* 개발자 작업  끝 */