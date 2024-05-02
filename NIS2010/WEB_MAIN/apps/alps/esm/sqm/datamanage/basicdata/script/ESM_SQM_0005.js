/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0005.js
*@FileTitle      : Target VVD Fix
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   :  
*@LastVersion    : 1.0
* 2013.05.08  
* 1.0 Creation
* 2013.11.13 Down Excel 버튼제어 변경
*                          SKD & BSA Inquiry 클릭으로 데이터 조회 후 데이터가 있으면 Down Excel 버튼을 활성화 한다.
* 2014.01.16 IAS Sector Sales 판매시스템 개발
* 2015.11.27 [SQM] 연간 판매목표 VBP SKD I/F 후 매뉴얼 수정관련 로직 수정 요청
* 2016.04.20 Target VVD Fix 월기준 항차 생성 등 개선 CSR
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0005 : ESM_SQM_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0005() {
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

var comboObjects = new Array();
var comboCnt = 0;

var comboXml; //화면 시작시 각 콤보 세팅을 위한 xml 을 나중에 사용하기 위해서 저장
var subTrdXml; //Trad선택시 변경되는 Sub trade용 xml
var rlaneXml;//Trad선택시 변경되는 rlane용 xml
var Sheet1ColCnt=0; //Sheet1 의 컬럼 갯수

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObject  = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_Retrieve1":
				//SKD & BSA Inquiry
				doActionIBSheet(sheetObject,formObject,SEARCH01);
				break;

			case "btn_Creation":
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case "btn_0006Pop":
				var bseTpCd = (formObject.f_bse_tp_cd[0].checked)? "Y":"Q";
//	        	var param = "trd_cd=" + formObject.f_trd_cd.text
//			    + "&lane_cd=" + formObject.f_rlane_cd.text
//			    + "&dir_cd=" + formObject.f_dir_cd.text
//			    + "&sub_trd_cd=" + formObject.f_sub_trd_cd.text
//			    + "&bse_yr=" + formObject.f_bse_yr.text
//			    + "&bse_qtr_cd=" + formObject.f_bse_qtr_cd.text
//			    + "&bse_tp_cd=" + bseTpCd
//			    + "&div_period=" + document.getElementById("div_period").innerHTML;
				var param = searchParams + "&div_period=" + document.getElementById("div_period").innerHTML;
	        	ComOpenPopup("/hanjin/ESM_SQM_0006.do?"+param, 650, 420,'setLaneDisableCallBack','0,1,1,1,1,1,1,1',true);


				break;
			case "btn_Downexcel":
				sheetObject.SpeedDown2Excel(-1);
				break;
			case "btn_Rowadd":
				doActionIBSheet( sheetObject, formObject, IBINSERT);
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

/**
 * IBSheet Object 를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObject  = document.form;
	loadingMode = true;

	doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);

	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	loadingMode = false;
	ComBtnDisable("btn_Rowadd");
}

function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {

				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 =  "STS|SEQ|Trade|Lane Bound|Sub-Trade|Lane|Year|Quarter|Week|Month|VVD||||BSA(TEU)|MAS Year|MAS Week|MAS Month|MAS BSA||||||Disable||";

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);

				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(19);

				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	daCenter,	false,	"ibflag",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtSeq,			30,	daCenter,	true,	"seq",		   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daCenter,	true,	"trd_cd",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"dir_cd",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	true,	"sub_trd_cd",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	daCenter,	true,	"rlane_cd",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"bse_yr",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"bse_qtr_cd",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"bse_wk",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,	daCenter,	false,	"bse_mon",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			120,daCenter,	false,	"vvd",	       false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50, daCenter,	false,	"vsl_cd",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50, daCenter,	false,	"skd_voy_no",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50, daCenter,	false,	"skd_dir_cd",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			100,daCenter,	false,	"fnl_bsa_capa",false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++,	dtHidden,		80,daCenter,	false,	"cost_yr",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,daCenter,	false,	"cost_wk",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,daCenter,	false,	"cost_mon",  false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		80,daCenter,	false,	"vvd_bsa_capa", false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		20,daCenter,	false,	"year_dif",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		20,daCenter,	false,	"wk_dif",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		20,daCenter,	false,	"mon_dif",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		20,daCenter,	false,	"delt_dif",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		20,daCenter,	false,	"bsa_dif",	   false,	"",	dfNone,	0,	false,	false);
				
				InitDataProperty(0,	cnt++,	dtCombo,		50,	daCenter,	false,	"delt_flg",	   true,	"",	dfNone,	0,	true,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,	daCenter,	false,	"blank",	   false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtHidden,		50,	daCenter,	false,	"ioc_cd",	   false,	"",	dfNone,	0,	false,	false);

				// 영문자 또는 숫자만 입력
                InitDataValid(0, "vvd", vtEngUpOther, "1234567890");
                
				Sheet1ColCnt = cnt;
				InitDataCombo(0,"delt_flg", "N|Y", "N|Y");

			}
			break;
	}
}

/**
 * 멀티콤보 항목을 설정한다.
 */
function initCombo(comboObj, comboId) {

		switch(comboObj.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				DropHeight = 300;
			}
			break;

		default:
			with (comboObj) {
				DropHeight = 300;
				Index      = 0;
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
		case IBCLEAR:          //조회
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);

			formObj.f_cmd.value = INIT;

			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0005GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			var arrXml = sXml.split("|$$|");
			comboXml = arrXml;
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_trd_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_dir_cd, "code", "name");

			doActionIBSheet(sheetObj,formObj,SEARCH02);
			ComOpenWait(false);
			break;

		case IBSEARCH_ASYNC01:          // Creation시에
		 	if(formObj.cre_flg.value != "Y") {
		 	   if (ComShowConfirm (ComGetMsg("SQM00069")) != 1) {
	                return false;
	            }   
		 	}
		 	
            if (ComShowConfirm (ComGetMsg("SQM00041")) != 1) {
                return false;
            }
		 	
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI01;

			//변수 세팅
			var flg = (formObj.vbp_if_flg.checked)?"Y":"N";
			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			sheetObj.DoSearch("ESM_SQM_0005GS.do",  FormQueryString(formObj)+ "&vbp_if_flg=" + flg);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			ComOpenWait(false);
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;

		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			sheetObj.MergeSheet = msAll;
			
			//disable컬럼 히든처리
			sheetObj.ColHidden("delt_flg") = false;
			sheetObj.ColHidden("blank") = true;
			ComBtnEnable("btn_Rowadd");
			if( formObj.mas_flg.checked ){
				sheetObj.ColHidden("cost_yr") = false;
				sheetObj.ColHidden("cost_mon") = false;
				sheetObj.ColHidden("cost_wk") = false;
				sheetObj.ColHidden("vvd_bsa_capa") = false;
			} else {
				sheetObj.ColHidden("cost_yr") = true;
				sheetObj.ColHidden("cost_mon") = true;
				sheetObj.ColHidden("cost_wk") = true;
				sheetObj.ColHidden("vvd_bsa_capa") = true;
			}
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0005GS.do", searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
                formObj.cre_flg.value = "Y";
				toggleButtons("INIT");
			} else {
                formObj.cre_flg.value = "N";
				toggleButtons("SEARCH");
			}
			ComOpenWait(false);
			sheetObj.ReDraw = true;
			break;

		case SEARCH02:          // 화면 오픈시
			formObj.f_cmd.value = SEARCH02;
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0005GS.do", FormQueryString(formObj));
			var etcData = getEtcData(rtnXml);
			if (etcData["dataCnt"] == 0) {
			    formObj.cre_flg.value = "Y";
				toggleButtons("INIT");
			} else {
			    formObj.cre_flg.value = "N";
				toggleButtons("SEARCH");
			}
			break;

		case SEARCH01:          //SKD & BSA Inquiry
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;

			//변수 세팅
			var flg = (formObj.vbp_if_flg.checked)?"Y":"N";
			formObj.f_fm_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][0].substring(3,5);
			formObj.f_to_wk.value = qtaWeekArr[ComGetObjValue(formObj.f_bse_qtr_cd)][1].substring(3,5);

			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0005GS.do", FormQueryString(formObj)+ "&vbp_if_flg=" + flg);
			sheetObj.LoadSearchXml(rtnXml);

			//disable컬럼 히든처리
			sheetObj.ColHidden("delt_flg") = true;
			sheetObj.ColHidden("blank") = false;

	 	    if (sheetObj.RowCount>0)
	 	    	ComBtnEnable("btn_Downexcel");
	 	    else
	 	    	ComBtnDisable("btn_Downexcel");

			ComOpenWait(false);
			break;

		case IBSAVE:          // 화면 저장시
			var dup = sheetObj.ColValueDup("2|3|4|5|6|7|10");
			if( dup > -1){
				ComShowCodeMessage("SQM00064");
				return false;
			}
			if (sheetObj.isDataModified == false) {
				ComShowCodeMessage("SQM00006");
			    return false;
			} else if (ComShowConfirm (ComGetMsg("SQM00004")) != 1) {
				return false;
			}
			ComSetSearchParams("f_cmd", MULTI);
			
			var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObjects[0].GetSaveXml("ESM_SQM_0005GS.do", searchParams + "&" +sParam);
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State != "S"){
				if(sXml.indexOf("COM12240")>0){
					ComShowCodeMessage('SQM00066');
				}else
					ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data');
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}

			break;
			
		case IBINSERT:                  // Row add
			if( sheetObj.RowCount > 0 ){
				sheetObj.MergeSheet = msNone;
//				var iRow = sheetObj.DataCopy();
				var iRow = sheetObj.DataInsert(); //선택한 Row 바로 아래 Row Insert
				
				sheetObj.CellEditable(iRow,  "trd_cd") = true;
				sheetObj.CellEditable(iRow,  "dir_cd") = true;
				sheetObj.CellEditable(iRow,  "sub_trd_cd") = true;
				sheetObj.CellEditable(iRow,  "rlane_cd") = true;
				sheetObj.CellEditable(iRow,  "bse_yr") = false;
				sheetObj.CellEditable(iRow,  "bse_qtr_cd") = false;
				sheetObj.CellEditable(iRow,  "delt_flg") = true;
				sheetObj.CellEditable(iRow,  "vvd") = true;

//				//Trade 를 콤보로 변경
				setCellCombo( sheetObj, comboObjects[2], "trd_cd", iRow, 2 );

				//Bound 를 콤보로 변경
				setCellCombo( sheetObj, comboObjects[3], "dir_cd", iRow, 3 );
				
				//Sub Trade 를 콤보로 변경
				setCellCombo( sheetObj, comboObjects[4], "sub_trd_cd", iRow, 4 );

				//RLane 를 콤보로 변경
				setCellCombo( sheetObj, comboObjects[5], "rlane_cd", iRow, 5 );
				
				//그외 모든 cell data copy
				for(var k=6 ; k<8 ; k++ ) {
					sheetObj.CellValue( iRow , k ) = sheetObj.CellValue( iRow-1 , k );
				}

			}
			break;
    }
}

/**
 * Cell을 copy하고 난 후 해당 cell을 combo로 변경
 * @param sheetObj - sheet 객체
 * @param objItem - Combo에 들어갈 item
 * @param objName - cell의 이름
 * @param row - cell이 속한 row
 * @param cellIdx - cell의 column
 */
function setCellCombo( sheetObj, objItem, objName, row, cellIdx ){
	var item = "";
	for( var x=0; x<objItem.GetCount; x++ ) {
		var txt = objItem.GetIndexText(x,0);
		if( txt == "All" )
			txt = " ";
		item += "|"+txt;
	}
	sheetObj.InitCellProperty ( row , cellIdx , dtCombo , daCenter , objName , "" , dfNone );
	
	if(cellIdx != 5){
		sheetObj.InitDataCombo(0, cellIdx, item, item );
	}
}

 /**
 * onChange event
 * f_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */
 function f_trd_cd_OnChange(obj, value, text) {
		var formObj = document.form;
		var trdcd  = comboObjects[2].Code;	// trade code
		if (value != "All") {

			var param = "f_cmd=" + SEARCH01
		    + "&code_name=rLane,subTrade"
		    + "&code_param=" + trdcd + "," + trdcd
		    + "&all_flag=All,All";	// Trade

			var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
			var arrXml = xmlStr.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "name");

			comboObjects[4].Index = 0;
			comboObjects[5].Index = 0;

		} else {
			formObj.f_rlane_cd.RemoveAll();
			formObj.f_rlane_cd.InsertItem(0, "All", "All");
			formObj.f_sub_trd_cd.RemoveAll();
			formObj.f_sub_trd_cd.InsertItem(0, "All", "All");
			comboObjects[4].Index = 0;
			comboObjects[5].Index = 0;
		}
	}

 
 /**
 * onChange event
 * f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
 */	 
 function f_sub_trd_cd_OnChange(obj, value, text) {
		var formObj = document.form;
		var code  = comboObjects[2].Code + "|" + comboObjects[4].Code;	// trd,subtrade code
		var param = "f_cmd=" + SEARCH01
		    + "&code_name=rLane"
		    + "&code_param=" + code
		    + "&all_flag=All";	// Trade

			var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
			var arrXml = xmlStr.split("|$$|");
			if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");

			comboObjects[5].Index = 0;

	}

 /**
 * Sheet1 값 변경시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, row, col, value){
	var formObj = document.form;
	var sName   = sheetObj.ColSaveName(col);

	switch(sName){
		case "delt_flg":
			setCancelLine(sheetObj,row,value);
			break;
			
		case "vvd":
			var vvd = sheetObj.CellValue( row, col );
			if( vvd.length != 9 ){
				ComShowMessage(ComGetMsg("SQM00065"));
				break;
			}
			vvd = vvd.toUpperCase();
			sheetObj.CellValue2( row , "vvd" ) = vvd;
			sheetObj.CellValue2( row , "vsl_cd" ) = vvd.substring(0,4);
			sheetObj.CellValue2( row , "skd_voy_no" ) = vvd.substring(4,8);
			sheetObj.CellValue2( row , "skd_dir_cd" ) = vvd.substring(8);
			break;
			
		case "trd_cd":
		
			var text = getSheetComboCode(sheetObj, row, col);
			sheetObj.CellValue2(row, col) = text;
			
			if (text != " ") {
				var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=subTrade&code_param="+text+"&all_flag=All");
				sXml = sXml.replace("<TR><![CDATA[☜☞☜☞All☜☞All☜☞]]></TR>",""); 
				sXml = sXml.replace("<TR><![CDATA[☜☞☜☞All☜☞All☜☞]]></TR>",""); 
				
				ComSqmSetIBCombo(sheetObj, sXml, "sub_trd_cd", true, 0, row);
			} else {
				sheetObj.CellComboItem(row, "sub_trd_cd", "", "");
			}
			break;
			
		case "sub_trd_cd":
		
		var text = getSheetComboCode(sheetObj, row, col);
					sheetObj.CellValue2(row, col) = text;
					
					if (text != " ") {
						var sXml = sheetObj.GetSearchXml("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param="+sheetObj.CellValue(row, "trd_cd")+"|"+text+"&all_flag=All");
						sXml = sXml.replace("<TR><![CDATA[☜☞☜☞All☜☞All☜☞]]></TR>",""); 
						sXml = sXml.replace("<TR><![CDATA[☜☞☜☞All☜☞All☜☞]]></TR>",""); 
						
						ComSqmSetIBCombo(sheetObj, sXml, "rlane_cd", true, 0, row);
					} else {
						sheetObj.CellComboItem(row, "rlane_cd", "", "");
					}
		break;

	}
}
 /**
 * setLaneDisableCallBack
 * 팝업화면에서 선택된 노선을 all disable
 * @param aryPopupData
 */
function setLaneDisableCallBack(aryPopupData) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	ComOpenWait(true);
	for(var i =0;i<aryPopupData.length;i++){
		for(var j=0;j<sheetObj.Rows;j++){
			if((aryPopupData[i][1] == sheetObj.CellValue(j,"trd_cd"))
					&&(aryPopupData[i][2] == sheetObj.CellValue(j,"dir_cd"))
					&&(aryPopupData[i][3] == sheetObj.CellValue(j,"sub_trd_cd"))
					&&(aryPopupData[i][4] == sheetObj.CellValue(j,"rlane_cd"))){
				sheetObj.CellValue(j,"delt_flg") = "Y"
			}
		}

	}
	ComOpenWait(false);
	ComShowCodeMessage('SQM00011',"The disable lanes");
}
 /**
 * delt_flg값에 따라 취소선 설정
 * @param sheetObj
 * @param row
 * @param value
 */
 function setCancelLine(sheetObj,row,value) {
		if(value == "Y"){
			//취소선
			sheetObj.CellFont("FontStrikethru", row, 6,	row, 14) = true;
		}else {
			sheetObj.CellFont("FontStrikethru", row, 6,	row, 14) = false;
		}

	}

 /**
 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var row = 0;
	while ((row = sheetObj.FindText("delt_flg", "Y", row + 1)) > 0) {
		setCancelLine(sheetObj, row, "Y");
	}

	if (document.form.mas_flg.checked) {
		setSheetData(sheetObj);
	}
}

 function setSheetData(sheetObj){
	 var colCnt = sheetObj.LastCol;
	 var rowCnt = sheetObj.RowCount;
	 
	 for(var x=1 ; x<=rowCnt ; x++ ){
		 var yearDif = sheetObj.CellValue( x , "year_dif" );//D:DIFF , E:EQU
		 var monDif = sheetObj.CellValue( x , "mon_dif" );//D:DIFF , E:EQU
		 var wkDif = sheetObj.CellValue( x , "wk_dif" );//D:DIFF , E:EQU
		 var bsaDif = sheetObj.CellValue( x , "bsa_dif" );//D:DIFF , E:EQU
		 var deltDif = sheetObj.CellValue( x , "delt_dif" ); //MD:MAS DELETE, SD:SQM DELETE, BD:BOTH DELETE, N:NO DEL
		 
		 if( deltDif == "N" && yearDif == "D" ) {
			 //배경색 변경
			 sheetObj.CellBackColor(x, "cost_yr") = sheetObj.RgbColor(255,0,0);
		 }
		 
		 if( deltDif == "N" && monDif == "D" ) {
			 //배경색 변경
			 sheetObj.CellBackColor(x, "cost_mon") = sheetObj.RgbColor(255,0,0);
		 }
		 
		 if( deltDif == "N" && wkDif == "D" ) {
			 //배경색 변경
			 sheetObj.CellBackColor(x, "cost_wk") = sheetObj.RgbColor(255,0,0);
		 }
		 
		 if( deltDif == "N" && bsaDif == "D" ) {
			 //배경색 변경
			 sheetObj.CellBackColor(x, "vvd_bsa_capa") = sheetObj.RgbColor(255,0,0);
		 }
		 
		 if( deltDif == "N" && yearDif == "E" && monDif == "E" && wkDif == "E" && wkDif == "E" && bsaDif == "E") {
			 sheetObj.CellValue2( x , "vvd_bsa_capa")="";
			 sheetObj.CellValue2( x , "cost_wk")="";
			 sheetObj.CellValue2( x , "cost_mon")="";
			 sheetObj.CellValue2( x , "cost_yr")="";
		 }
		 
		 if( deltDif != "N"){
			 sheetObj.CellValue2( x , "vvd_bsa_capa")="";
			 sheetObj.CellValue2( x , "cost_wk")="";
			 sheetObj.CellValue2( x , "cost_mon")="";
			 sheetObj.CellValue2( x , "cost_yr")="";
			 
			 sheetObj.CellBackColor(x, "bse_yr") = sheetObj.RgbColor(255,0,0);
			 sheetObj.CellBackColor(x, "bse_mon") = sheetObj.RgbColor(255,0,0);
			 sheetObj.CellBackColor(x, "bse_wk") = sheetObj.RgbColor(255,0,0);
			 sheetObj.CellBackColor(x, "vvd") = sheetObj.RgbColor(255,0,0);
			 sheetObj.CellBackColor(x, "fnl_bsa_capa") = sheetObj.RgbColor(255,0,0);
			 sheetObj.CellBackColor(x, "bse_qtr_cd") = sheetObj.RgbColor(255,0,0);
		 }
		 sheetObj.CellValue(x,"ibflag")="";
	 }
 }

	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리
	 */
function toggleButtons(step) {
	var formObj = document.form;
    switch (step) {
    case "INIT":
        ComBtnDisable("btn_Save");
        ComBtnDisable("btn_0006Pop");
        ComBtnDisable("btn_Downexcel");
        /*
        if(formObj.cre_flg.value == "Y")
        	ComBtnEnable("btn_Creation");
        else
        	ComBtnDisable("btn_Creation");
 	    ComBtnEnable("btn_Retrieve1");
 	    */
        break;
    case "SEARCH":
 	   ComBtnEnable("btn_Save");
 	   //ComBtnDisable("btn_Creation");
 	   ComBtnEnable("btn_Downexcel");
 	   ComBtnEnable("btn_0006Pop");
 	   //ComBtnDisable("btn_Retrieve1");
        break;

    }
}

 /**
  * f_bse_tp_cd 바뀌었을때 qtr_cd, week 변경
  */
 function f_bse_tp_cd_OnChange() {
		var formObj    = document.form;
		var bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd[0]);
		var div_qtr    = document.getElementById("div_qtr");
		var div_period = document.getElementById("div_period");
		
		sheetObjects[0].RemoveAll();

		if (bse_tp_cd == "Y") {
			div_qtr.style.display = "none";
			div_period.style.display = "none";
			formObj.f_bse_qtr_cd.style.display = "none";
			div_vbp.style.display = "none";
			formObj.vbp_if_flg.style.display = "none";
		} else {
			div_qtr.style.display = "inline";
			div_period.style.display = "inline";
			formObj.f_bse_qtr_cd.style.display = "inline";
			div_vbp.style.display = "inline";
			formObj.vbp_if_flg.style.display = "inline";
		}

 	if (bse_tp_cd == "Y") {
 		formObj.f_bse_qtr_cd.Enable = false;
 		sheetObjects[0].ColHidden("bse_qtr_cd") = true;
 	} else {
 		formObj.f_bse_qtr_cd.Enable = true;
 		sheetObjects[0].ColHidden("bse_qtr_cd") = false;
 	}

 	period_change();
 	if(comboObjects[0].Code!=""&&comboObjects[1].Code!="")
 		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
 }


  /**
   * f_bse_yr가 바뀌었을때 period 의 year 변경
   */
  function f_bse_yr_OnChange(obj, value, text) {
	var formObj    = document.form;
  	period_change();
  	if(comboObjects[1].Code!="")
  		doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
  }

  /**
   * f_bse_qtr_cd 바뀌었을때 period 의 week 기간변경
   */
  function f_bse_qtr_cd_OnChange(obj, value, text) {
	var formObj    = document.form;
  	period_change();
  	doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
  }
  
 /**
 * Sheet1 클릭 시
 *
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnClick(sheetObj, row, col){
	switch(sheetObj.ColSaveName(col)){
		case "bse_wk":
//			if (document.form.f_bse_tp_cd[0].checked) {  
				sheetObj.CellEditable(row, "bse_wk") = true;
//			} 
			break;
		case "bse_mon":
//			if (document.form.f_bse_tp_cd[0].checked) {  
				sheetObj.CellEditable(row, "bse_mon") = true;
//			}
			break;
		case "fnl_bsa_capa":
//			if (document.form.f_bse_tp_cd[0].checked) {  
				sheetObj.CellEditable(row, "fnl_bsa_capa") = true;
//			}
			break;
	}
}
/* 개발자 작업  끝 */