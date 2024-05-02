/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESM_SQM_0215.js
*@FileTitle      : QTA Set up for IAS Sector by Head Office_Add-Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.06.23 [CHM-201430810] 이혜민 add creation, add freezing 팝업 내 lane 콤보에 ALL Flag 삭제
* 2014.07.28 [CHM-201431109] 이혜민 QTA Set up by HO for IAS Sector_Add Creation, Add-Freezing 시 Bound 삽입 요청
* 2014.08.14 [CHM-201431421] 이혜민 Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
* 2014.08.25 [CHM-201431601] 이혜민 팝업 오픈시 부모창 조회조건을 자동세팅하도록 수정
* 2015.12.06 [CHM-201539010] Add Freezing Validation 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends
 * @class ESM_SQM_0215 : ESM_SQM_0215 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0215() {
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
var qtaWeekArr = new Array();
qtaWeekArr["1Q"] = new Array(".wk00",".wk13");
qtaWeekArr["2Q"] = new Array(".wk14",".wk26");
qtaWeekArr["3Q"] = new Array(".wk27",".wk39");
qtaWeekArr["4Q"] = new Array(".wk40",".wk53");
var rowCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObject = sheetObjects[0];
	var formObj     = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_Freezing":
				doActionIBSheet(sheetObject, formObj, "AddFreezing");
				break;
			case "btn_Close":
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

/**
* IBSheet Object 를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

function loadPage(){
	var formObj = document.form;
	loadingMode = true;

	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	// 콤보 세팅
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);

	// 부모창에서 넘어온 값 세팅
	ComSetObjValue(formObj.f_bse_tp_cd[0], formObj.p_bse_tp_cd.value);
	
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	
	ComSetObjValue(formObj.f_ias_rgn_cd, formObj.p_ias_rgn_cd.value);
	if(formObj.p_sub_trd_cd.value != "All")	ComSetObjValue(formObj.f_sub_trd_cd, formObj.p_sub_trd_cd.value);
	if(formObj.p_rlane_cd.value != "All")   ComSetObjValue(formObj.f_rlane_cd, formObj.p_rlane_cd.value);
	
	if(formObj.p_bse_tp_cd.value == "Q"){
		var year = formObj.f_bse_yr.value;
		var qta = formObj.f_bse_qtr_cd.value;
		document.getElementById("div_period").innerHTML = "(" + year + qtaWeekArr[qta][0] + " ~ " + year + qtaWeekArr[qta][1] + ")";
	}else{
		var year = formObj.f_bse_yr.value;
		document.getElementById("div_period").innerHTML = "(" + year + ")";
		formObj.f_bse_qtr_cd.value = "";
	}	
	
	loadingMode = false;
}


function initSheet(sheetObj,sheetNo) {
	var cnt = 0;

	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone]
				MergeSheet = msPrevColumnMerge;  //msNone; //msHeaderOnly //msPrevColumnMerge;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);

				var HeadTitle1 =  "STS|Trade|Sub Trade|IAS Region|R.Lane|Bound|P/F SKD Group|P/F SKD Ver.|Route|SEL";

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, true);

				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, false, false, true, false, false);

				// 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				// 전체 높이 설정
				style.height = GetSheetHeight(8);

				// 데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtStatus,		30,	  daCenter,	 true,	"ibflag",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			40,	  daCenter,	 true,	"trd_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			70,	  daCenter,	 true,	"sub_trd_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,   daCenter,	 true,	"ias_rgn_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			60,   daCenter,	 true,	"rlane_cd",		false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0, cnt++, 	dtData, 		50,   daCenter,  true, 	"dir_cd",		false,  "", dfNone, 0, 	false,  false);
				InitDataProperty(0,	cnt++,	dtData,			90,   daCenter,	 true,	"pf_grp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			80,   daCenter,	 false,	"pf_svc_tp_cd",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,			300,  daLeft,	 false,	"pf_rout_desc",	false,	"",	dfNone,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtCheckBox,		40,   daCenter,	 true,	"sel_flg",		false,	"",	dfNone,	0,	true,	true);

			}
			break;

	}
}

/**
* 멀티콤보 항목을 설정한다.
*/
function initCombo(comboObj, comboId) {
	switch(comboObj.id) {
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
		case IBCLEAR:          // 화면 접속 시
			sheetObj.WaitImageVisible = false;

			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			var sXml   = sheetObj.GetSearchXml("ESM_SQM_0215GS.do", FormQueryString(formObj));
			var State  = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			var arrXml = sXml.split("|$$|");

			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_sub_trd_cd, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ias_rgn_cd, "code", "name");
			ComOpenWait(false);
			break;


		case IBSEARCH:          // 화면 조회 시
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			formObj.f_cmd.value = SEARCH;
			searchParams = FormQueryString(formObj);
			ComOpenWait(true);
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0215GS.do",searchParams);
			sheetObj.LoadSearchXml(rtnXml);
			ComOpenWait(false);

			break;
			
		case "AddFreezing":		// Add Freezing
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			if (ComShowConfirm (ComGetMsg("SQM00009")) != 1) { //Do you want to create data?
				return false;
		    }
			ComOpenWait(true);
			
        	//시작(Load가 0이 아닌데 Grpb가 0인 데이터 찾아내는 유효성 검사)
        	var param = "f_cmd="         + COMMAND02
            + "&f_bse_tp_cd="  + ComGetObjValue(document.form.f_bse_tp_cd)
            + "&f_bse_yr="     + ComGetObjValue(document.form.f_bse_yr)
            + "&f_bse_qtr_cd=" + ComGetObjValue(document.form.f_bse_qtr_cd)
        	+ "&f_sub_trd_cd=" + ComGetObjValue(document.form.f_sub_trd_cd)
        	+ "&f_rlane_cd=" + ComGetObjValue(document.form.f_rlane_cd)
            ;
        	
        	var rtnXml = sheetObjects[0].GetSearchXml("ESM_SQM_0213GS2.do", param);
        	
        	var arrXml = rtnXml.split("<TR><![CDATA[");
        	var processedArrXml = [];
        	var combindedArrayData = '';
        	
        	if(arrXml[0].indexOf("TOTAL='0'") == -1){
        		for(a=1; a<arrXml.length; a++){ // 첫번째 배열은 버림. 불필요한 내용이 들어 있으므로
        			processedArrXml[a] = arrXml[a].replace("]]></TR>",'');
        			processedArrXml[a] = processedArrXml[a].replace(" ",''); // 공백 제거
        			if(processedArrXml[a].indexOf("</DATA>") > -1){ // 마지막 배열의 </DATA></SHEET> 문자를 제거하기 위해 만든 if절
        				processedArrXml[a] = processedArrXml[a].replace("</DATA>",'');
            			processedArrXml[a] = processedArrXml[a].replace("</SHEET>",'');
        			}
        			combindedArrayData = combindedArrayData + processedArrXml[a];
            	}
        		ComShowCodeMessage('SQM00053', ComGetObjValue(document.form.f_bse_yr), ComGetObjValue(document.form.f_bse_qtr_cd), combindedArrayData);
        		return false;
        	}
        	//끝
			
			ComSetSearchParams("f_cmd", MULTI01);
			sheetObj.DoSave("ESM_SQM_0215GS.do", searchParams, -1, false);
			ComOpenWait(false);

			var State = sheetObj.EtcData("TRANS_RESULT_KEY");
			if(State != "S"){
				ComShowMessage(ComResultMessage(sXml));
				return false;
			}else if(State == "S"){
				ComShowCodeMessage('SQM00001','Data'); //{?msg1} saved successfully.
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}
			break;
  }
}


/**
* onChange event
* f_sub_trd_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }

/**
* onChange event
* f_ias_rgn_cd 바뀌었을때  f_lane_cd 콤보조회
*/	
function f_ias_rgn_cd_OnChange(obj, value, text) {
	setLaneCombo();
}

/**
 *  f_sub_trd_cd, f_ias_rgn_cd 변경시 f_rlane_cd를 변경한다.
 */
function setLaneCombo(){
 	var formObj = document.form;
 	var sub_trd_cd = ComGetObjValue(formObj.f_sub_trd_cd);
 	var ias_rgn_cd = ComGetObjValue(formObj.f_ias_rgn_cd);
 	
 	if ( (sub_trd_cd != ""  && sub_trd_cd != "All" ) || (ias_rgn_cd != "" && ias_rgn_cd != "All")  ) {
        var param = "f_cmd=" + SEARCH02
        + "&code_name=rLaneControlSector"
        + "&code_param=null"
        + "&all_flag="
        + "&" + FormQueryString(formObj);
	
	 	var xmlStr = sheetObjects[0].GetSearchXml("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, formObj.f_rlane_cd, "code", "name");
	 	formObj.f_rlane_cd.InsertItem(0, "", "");
	 	formObj.f_rlane_cd.Index = 0;
 	} else {
		formObj.f_rlane_cd.RemoveAll();
		formObj.f_rlane_cd.Index = 0; 		
 	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
	case IBSEARCH:  //Retrieve
		if(ComGetObjValue(formObj.f_rlane_cd) == "") {
			ComShowCodeMessage("SQM00013","R/Lane"); //{?msg1} is mandatory item.
			formObj.f_rlane_cd.focus();
			return false;
		}
    	break;
	case "AddFreezing":  // Add-Creation
			if(sheetObj.CheckedRows("sel_flg") < 1){
				ComShowCodeMessage("SQM00046"); ////Please check at least one row.
				return false;
			}
    	break;
	}
	return true;
}


/* 개발자 작업  끝 */