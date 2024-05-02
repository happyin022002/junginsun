/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0017.js
*@FileTitle      : QTA Set up by Head Office RHQ Distribute Result
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @extends 
 * @class ESM_SQM_0017 : ESM_SQM_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SQM_0017() {
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

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick(){
	var sheetObj = sheetObjects[0];
	var formObj  = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
				
			case "btn_close":
				window.close();
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
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	ComSetObjValue(formObj.f_bse_tp_cd[0], p_bse_tp_cd);
	ComSetObjValue(formObj.ofc_vw_cd, (formObj.f_ofc_vw_cd.value=="C"?"Contract":"Loading"));
	
	f_bse_tp_cd_OnChange();
	
	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObjects[0].ColHidden("bse_qtr_cd") = true;
	} else {
		sheetObjects[0].ColHidden("bse_qtr_cd") = false;
	}
	obj_click();
	document.form.f_click.disabled = true;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	
	if ( formObj.f_trd_dir.value != "All" ) {
		ComSetObjValue(formObj.f_trd_dir, (formObj.f_trd_dir.value=="BH"?"B/H":"H/H"));
	}
	
	loadingMode = false;
}
/**
* f_click가 체크될때 direction콤보 change
*/ 
function obj_click() {
		var formObj = document.form;        
		
		if(formObj.f_click.checked){
		  		trd_dir.style.display = "inline";
		  		dir_cd.style.display = "none";
		   		document.all("div_dir").innerHTML = "Trade Dir.";
		}else{
		  		trd_dir.style.display = "none";
		  		dir_cd.style.display = "inline";
		   		document.all("div_dir").innerHTML = "Trade Bound";
		}
} 
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	
	switch(sheetNo) {
		case 1:		//sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(15) ;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 9, 100);
				
				var HeadTitle1 = "SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub Trade|R.Lane|Trade\nBound|Trade\nDirection|Week|VVD|Supply|RHQ|Load QTA|G.REV QTA";
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(ComCountHeadTitle(HeadTitle1) + 1, 0, 0, true);
				
				// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
				InitHeadMode(true, true, false, true, false, false);
				
				//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				
				//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign], [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat], [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort], [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
				InitDataProperty(0,	cnt++,	dtSeq,	30,	daCenter,	true,	"seq",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	40,	daCenter,	true,	"bse_yr",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	55,	daCenter,	true,	"bse_qtr_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	60,	daCenter,	true,	"ob_div_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	70,	daCenter,	true,	"ofc_vw_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	60,	daCenter,	true,	"trd_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	80,	daCenter,	true,	"sub_trd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	70,	daCenter,	true,	"rlane_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	50,	daCenter,	true,	"conv_dir_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	60,	daCenter,	true,	"hul_bnd_cd",	false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	50,	daCenter,	true,	"bse_wk",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	75,	daCenter,	true,	"vvd",			false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	65,	daRight,	true,	"fnl_bsa_capa",	false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtData,	65,	daCenter,	true,	"rhq_cd",		false,	"",	dfNone,		0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	70,	daRight,true,	"rhq_qty",		false,	"",	dfInteger,	0,	false,	false);
				InitDataProperty(0,	cnt++,	dtAutoSum,	70,	daRight,true,	"rhq_rev",		false,	"",	dfInteger,	0,	false,	false);

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
		case IBSEARCH:          // 화면 조회 시
			ComOpenWait(true);
			
			formObj.f_cmd.value = SEARCH;
			
			searchParams = FormQueryString(formObj);
			
			var rtnXml = sheetObj.GetSearchXml("ESM_SQM_0017GS.do", searchParams);
			
			sheetObj.LoadSearchXml(rtnXml);
			
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.ColHidden("bse_qtr_cd") = true;
			} else {
				sheetObj.ColHidden("bse_qtr_cd") = false;
			}
		 	sheetObj.SumText(0, "seq") = "";
		 	sheetObj.SumText(0, "bse_yr") = "TOTAL";
			ComOpenWait(false);
			break;
			
		case IBDOWNEXCEL:		// 엑셀 다운로드
			ComOpenWait(true);
			sheetObj.Down2Excel(-1, false, false, true);
			ComOpenWait(false);
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
	
	if (bse_tp_cd == "Y") {
		div_qtr.style.display = "none";
		div_period.style.display = "none";
		formObj.f_bse_qtr_cd.style.display = "none";
	} else {
		div_qtr.style.display = "inline";
		div_period.style.display = "inline";
		formObj.f_bse_qtr_cd.style.display = "inline";
	}
	
	period_change();
}
/* 개발자 작업  끝 */