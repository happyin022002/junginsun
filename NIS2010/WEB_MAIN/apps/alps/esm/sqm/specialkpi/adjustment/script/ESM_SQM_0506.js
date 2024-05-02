/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0506.js
*@FileTitle      : KPI Creation & Edit_New Office Add Pop up
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.19
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.19 이혜민
* 1.0 Creation
* 2014.01.09 박은주 [CHM-201428372] SELBB, TYOBB 조직 LEVEL 변경 건
* 2014.01.16 박은주 [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.06.24 이혜민 [CHM-201430703] SQM 신규 Office 등록 로직 변경
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0506 : ESM_SQM_0506 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0506() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var qtaWeekArr = new Array();
qtaWeekArr["1Q"] = new Array(".wk00",".wk13");
qtaWeekArr["2Q"] = new Array(".wk14",".wk26");
qtaWeekArr["3Q"] = new Array(".wk27",".wk39");
qtaWeekArr["4Q"] = new Array(".wk40",".wk53");

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
		case "btn_RowAdd":
			sheetObj.DataInsert(-1);
			sheetObj.CellValue2(sheetObj.SelectRow, "chk_flg") = 1;
			sheetObj.InitCellProperty(sheetObj.SelectRow , "trd_cd", dtCombo);
			sheetObj.InitCellProperty(sheetObj.SelectRow , "conv_dir_cd", dtCombo);
			sheetObj.InitCellProperty(sheetObj.SelectRow , "rhq_cd", dtCombo);
			sheetObj.InitCellProperty(sheetObj.SelectRow , "src_rhq_cd", dtCombo);
			//코드 값 조회
			doActionIBSheet(sheetObj, formObj, IBCLEAR);
			break;

		case "btn_Creation":
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			break;

		case "btn_Close":
	    	//window.returnValue = "CLOSE";
	    	self.close();
	        break;

		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComSetObjValue(formObj.f_bse_tp_cd[0], formObj.p_bse_tp_cd.value);
	ComSetObjValue(formObj.f_spcl_tgt_cd[0], formObj.p_spcl_tgt_cd.value);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	if(formObj.p_bse_tp_cd.value == "Q"){
		var year = formObj.f_bse_yr.value;
		var qta = formObj.f_bse_qtr_cd.value;
		document.getElementById("div_period").innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
	}else{
		var year = formObj.f_bse_yr.value;
		document.getElementById("div_period").innerHTML = "(" + year + ")";
		formObj.f_bse_qtr_cd.value = "All";
	}

	loadingMode = false;
}

var initSheetFn = function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 =  "STS|SEL|SEQ|qta_flag|Trade|Trade\nBound|Lane|New RHQ|New Office|Copy Source RHQ|Copy Source Office";

				var headCount = ComCountHeadTitle(HeadTitle1);
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(10);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		35,		daCenter,	true,	"chk_flg",			false,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtSeq,			40,		daCenter,	true,	"seq",				false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	true,	"qta_flag",			false,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"trd_cd",			true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	true,	"conv_dir_cd",		true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	true,	"rlane_cd",			true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			95,		daCenter,	true,	"rhq_cd",			true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			95,		daCenter,	true,	"rgn_ofc_cd",		true,	"",	dfNone,		0,	false,	true, 5);
				InitDataProperty(0,	cnt++,	dtData,			125,	daCenter,	true,	"src_rhq_cd",		true,	"",	dfNone,		0,	false,	true);
				InitDataProperty(0,	cnt++,	dtData,			125,	daCenter,	true,	"src_rgn_ofc_cd",	true,	"",	dfNone,		0,	false,	true, 5);

				CountPosition = 0;
				InitDataValid(0,"rgn_ofc_cd",vtEngUpOnly );
				InitDataValid(0,"src_rgn_ofc_cd",vtEngUpOnly );
			}
			break;
	}
}

 /**
  * Sheet 관련 프로세스 처리
  */
function doActionIBSheet(sheetObj, formObj, sAction) {
 	sheetObj.ShowDebugMsg = false;
 	switch(sAction) {
	 	case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0506GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				var trade = ComXml2ComboString(arrXml[0], "code", "name");
				sheetObj.CellComboItem(sheetObj.SelectRow, "trd_cd",  " |"+trade[0],  " |"+trade[1]);
			if (arrXml.length > 1)
				var bound = ComXml2ComboString(arrXml[1], "code", "name");
				sheetObj.CellComboItem(sheetObj.SelectRow, "conv_dir_cd",  " |"+bound[0],  " |"+bound[1]);
			if (arrXml.length > 2)
				var rhq = ComXml2ComboString(arrXml[2], "code", "name");
				sheetObj.CellComboItem(sheetObj.SelectRow, "rhq_cd",  " |"+rhq[0],  " |"+rhq[1]);
				sheetObj.CellComboItem(sheetObj.SelectRow, "src_rhq_cd",  " |"+rhq[0],  " |"+rhq[1]);

			ComOpenWait(false);
			break;

	 	case IBSEARCH:          // 화면 접속 시 SQM_SPCL_NEW_OFC History조회
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("ESM_SQM_0506GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
			checkQtaFlag(sheetObj);
			break;

		case SEARCH01:		//Trade에 맞는 Lane 조회
			ComOpenWait(true);
			var sheetTrdCd = sheetObj.CellValue(sheetObj.SelectRow, "trd_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param=" + sheetTrdCd + "&all_flag=");
			var rlane = ComXml2ComboString(sXml, "code", "name");
			sheetObj.CellComboItem(sheetObj.SelectRow, "rlane_cd",  " |"+rlane[0],  " |"+rlane[1]);
			ComOpenWait(false);
			break;

//		case SEARCH02:		//RHQ에 맞는 Office 조회
//			ComOpenWait(true);
//			var sheetRhqCd = sheetObj.CellValue(sheetObj.SelectRow, "rhq_cd");
//			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + sheetRhqCd + "&all_flag=" );
//			var arrXml = sXml.split("|$$|");
//			if (arrXml.length > 0) {
//				var office = ComXml2ComboString(arrXml[0], "code", "name");
//				sheetObj.CellComboItem(sheetObj.SelectRow, "rgn_ofc_cd",  " |"+office[0],  " |"+office[1]);
//			}
//			ComOpenWait(false);
//			break;
//
		case SEARCH03:		//RHQ에 맞는 Source Office 조회
			ComOpenWait(true);
			var sheetRhqCd = sheetObj.CellValue(sheetObj.SelectRow, "src_rhq_cd");
			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + sheetRhqCd + "&all_flag=" );
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0) {
				var office = ComXml2ComboString(arrXml[0], "code", "name");
				sheetObj.CellComboItem(sheetObj.SelectRow, "src_rgn_ofc_cd",  " |"+office[0],  " |"+office[1]);
			}
			ComOpenWait(false);
			break;

		case IBCREATE:          // creation
			if (!validateForm(sheetObj, formObj, sAction)) return;

			//New RHQ, Office와 Source RHQ, Office가 같은 row 체크
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount ; i++){
				if (sheetObj.CellValue(i, "rhq_cd") == sheetObj.CellValue(i, "src_rhq_cd") &&
					sheetObj.CellValue(i, "rgn_ofc_cd") == sheetObj.CellValue(i, "src_rgn_ofc_cd")
					)
				{
					ComShowCodeMessage("SQM00028", "New Office", "Copy Source Office", "Office");
					return false;
			    }
			}

			var sParam = ComGetSaveString(sheetObj, false, false, "chk_flg");
			if (sParam == ""){
				ComShowCodeMessage('SQM00006'); //There is no data to Save.
				return;
			} else {
				if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) {
					return false;
			    }
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sParam = sParam + "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveXml("ESM_SQM_0506GS.do", sParam);
				ComOpenWait(false);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('SQM00010', 'Data');
				    window.returnValue = "S"; // 메인화면의 재조회하기 위해 성공시 플래그를 넘김
				    window.close();
//					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}
			break;
    }
}
/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBCREATE:  // 화면 저장시에
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount ; i++){
				if(sheetObj.CellValue(i,"ibflag") != "R"){
					if(sheetObj.CellValue(i,"trd_cd") == ""){
						ComShowCodeMessage("SQM00013", "Trade");
						return false;
					}
					if(sheetObj.CellValue(i,"conv_dir_cd") == ""){
						ComShowCodeMessage("SQM00013", "Bound");
						return false;
					}
					if(sheetObj.CellValue(i,"rlane_cd") == ""){
						ComShowCodeMessage("SQM00013", " Lane");
		  				return false;
		  	  		}
					if(sheetObj.CellValue(i,"rhq_cd") == ""){
						ComShowCodeMessage("SQM00013", "New RHQ");
		  				return false;
		  	  		}
					if(sheetObj.CellValue(i,"rgn_ofc_cd") == ""){
						ComShowCodeMessage("SQM00013", "New Office");
		  				return false;
		  	  		}
					if(sheetObj.CellValue(i,"src_rhq_cd") == ""){
						ComShowCodeMessage("SQM00013", "Copy Source RHQ");
		  				return false;
		  	  		}
					if(sheetObj.CellValue(i,"src_rgn_ofc_cd") == ""){
						ComShowCodeMessage("SQM00013", "Copy Source Office");
		  				return false;
		  	  		}
				}
			}
		 	break;
	}
	return true;
}

function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var colName = sheetObj.ColSaveName(Col);
	if(colName == "trd_cd"){
		sheetObj.InitCellProperty(sheetObj.SelectRow , "rlane_cd", dtCombo);
		if(sheetObj.CellValue(Row, "trd_cd") != ""){
			//Lane code 조회
			doActionIBSheet(sheetObj, formObj, SEARCH01);
		}
//	}else if(colName == "rhq_cd"){
//		sheetObj.InitCellProperty(sheetObj.SelectRow , "rgn_ofc_cd", dtCombo);
//		if(sheetObj.CellValue(Row, "rhq_cd") != ""){
//			//Office code 조회
//			doActionIBSheet(sheetObj, formObj, SEARCH02);
//		}
	}else if(colName == "src_rhq_cd"){
		sheetObj.InitCellProperty(sheetObj.SelectRow , "src_rgn_ofc_cd", dtCombo);
		if(sheetObj.CellValue(Row, "src_rhq_cd") != ""){
			//Office code 조회
			doActionIBSheet(sheetObj, formObj, SEARCH03);
		}
	}
}

//확정쿼터에 아직 데이터를 생성하지 않은 경우=SQM_SPCL_NEW_OFC에만 데이터가 있고 SQM_SPCL_CFM_QTA에 데이터 없음((qta_flag") == "N") 
function checkQtaFlag(sheetObj){
	var formObj = document.form;
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount ; i++){
		if(sheetObj.CellValue(i,"qta_flag") == "N" ){
			//Copy Source RHQ, Office 수정가능
			sheetObj.CellEditable(i, "chk_flg") = true;
			sheetObj.CellEditable(i, "src_rhq_cd") = true;
			sheetObj.CellEditable(i, "src_rgn_ofc_cd") = true;
			sheetObj.CellValue2(i, "ibflag") = "U";
			//RHQ 코드값 세팅
			sheetObj.InitCellProperty(i , "src_rhq_cd", dtCombo);
//			sheetObj.InitCellProperty(i , "src_rgn_ofc_cd", dtCombo);
			formObj.f_cmd.value = INIT;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0506GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 2){
				var rhq = ComXml2ComboString(arrXml[2], "code", "name");
				sheetObj.CellComboItem(i, "src_rhq_cd", rhq[0], rhq[1]);
			}
//			//Office 코드값 세팅
//			var sheetRhqCd = sheetObj.CellValue(i, "src_rhq_cd");
//			var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=office&code_param=" + sheetRhqCd + "&all_flag=" );
//			var arrXml = sXml.split("|$$|");
//			if (arrXml.length > 0) {
//				var office = ComXml2ComboString(arrXml[0], "code", "name");
//				sheetObj.CellComboItem(i, "src_rgn_ofc_cd", office[0], office[1]);
//			}
		}

	}

}
/* 개발자 작업  끝 */