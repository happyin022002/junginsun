/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0013.js
 *@FileTitle : Trendline Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.02
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
 * 2013.01.02 진마리아 CHM-201322241-01 FCM 사용 하지않는 소스 및 화면 정리
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
 * @class VOP_FCM_0013 : VOP_FCM_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0013() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var chartObjects = new Array();
var sheetCnt = 0;
var chartCnt = 0;

var visibleChtNo = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_New":
			formObj.trnd_line_tp_cd.Code = "";
			formObj.vsl_clss_cd.value = "";
			formObj.vsl_clss_sub_cd.value = "";
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_cd.value = "";
			formObj.skd_dir_cd.value = "";
			formObj.trnd_line_no.value = "";
			formObj.trnd_line_tp_sub_cd.value = "";
			formObj.trnd_line_rmk.value = "";
//			formObj.trnd_line_cht_tp_cd.Code = "";
//			formObj.trnd_line_cht_tp_cd.CheckIndex(0) = true;
			clearSheet(sheetObjects);
			clearChart(chartObjects);
			break;
			
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			break;

		case "btn_trnd_line_no":
			if(formObj.trnd_line_tp_cd.Code!=""){
				ComOpenPopup('/hanjin/VOP_FCM_0014.do?trndLineTpCd='+formObj.trnd_line_tp_cd.Code, 950, 650, 'setTrndLineNo', '0,0', false, false);
			}
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function setChartObject(chart_obj){
	chartObjects[chartCnt++] = chart_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

 	with (formObj.trnd_line_tp_cd) {
	 		//MultiSelect = true;
	 		MultiSeparator = ",";
	 		DropHeight = 320;
	 		InsertItem(0, '1 - Design Capa/Lane',		'1');
	 		InsertItem(1, '2 - Design Capa/All',		'2' );
	 		InsertItem(2, '3 - Vessel/Bound',	'3');
	 		InsertItem(3, '4 - Vessel/All', 	'4');
	 	}
 	

    for(k=0;k<chartObjects.length;k++){
        initChart(chartObjects[k],k+1);
    }
    
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("keypress", "obj_keypress", formObj);

}

function obj_activate() {
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

function obj_keypress() {
	var formObj = document.form;
	var obj = event.srcElement;

	switch (event.srcElement.name) {
//		case "trnd_line_seq":
//			ComKeyOnlyNumber();
//			break;
		default:
			ComKeyOnlyAlphabet("upper");
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 200;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "CHT|Design\nCapa|Sub\nClass|Lane|Vessel|Bound|Slip\n(Adjusted)|X2|X|C|Formula|24\nG/E|24\nBLR|Speed|Speed|Created\nDate|Created\nID";
			var HeadTitle2 = "CHT|Design\nCapa|Sub\nClass|Lane|Vessel|Bound|Slip\n(Adjusted)|X2|X|C|Formula|24\nG/E|24\nBLR|MAX|MIN|Created\nDate|Created\nID";
			
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
//			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성                 [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"trnd_line_cht_tp_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"vsl_clss_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"vsl_clss_sub_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"vsl_slan_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"vsl_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daCenter,	true,	"skd_dir_cd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	65,		daRight,	true,	"aply_slp_rt"		);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	120,	daLeft,		true,	"n1st_coef_val"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	120,	daLeft,		true,	"n2nd_coef_val"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	120,	daLeft,		true,	"trnd_line_cons_val"		);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	140,	daLeft,		true,	"foml_desc"		);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	40,		daRight,	true,	"avg_gnr_csm_wgt");
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	40,		daRight,	true,	"avg_blr_csm_wgt");
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daRight,	true,	"op_max_spd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	50,		daRight,	true,	"op_min_spd"	);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	80,		daCenter,	true,	"cre_dt"		);
			setInitDataProperty(sheetObj, 0, cnt++ , dtData,	80,		daCenter,	true,	"cre_usr_id"	);

			CountPosition = 0;
		}
		break;
		
	}
}

function setInitDataProperty(sheetObj, row, col, datatype, width, dataalign, colmerge, savename){
		sheetObj.InitDataProperty(row, col, datatype, width, dataalign, colmerge, savename,
						false,	//KEYFIELD
						"",		//CALCULOGIC
						dfNone,	//DATAFORMAT
						0,		//POINTCOUNT
						false,	//UPDATEEDIT
						false); //INSERTEDIT
		
}

/**
 * Chart 기본 설정
 * Chart의 항목을 설정한다.
 */
function initChart(chartObj , chartNo) {
	
	var chart = chartObj.Chart(ibcChartPrimary);
	var subchart = chartObj.Chart(ibcChartSecondary);
	var points = null;
	
	chartObj.AutoRedraw = false;
	chartObj.Plot.PlotArea.Boxline = false;
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY).Min = 0;
	chartObj.Plot.Axis(ibcAxisY).Max = 200;
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY2).Min = 0;
	chartObj.Plot.Axis(ibcAxisY2).Max = 200;
	
	// 차트 X축 설정
	chartObj.Plot.Axis(ibcAxisX).Min = 0;
	chartObj.Plot.Axis(ibcAxisX).Max = 26;
	
	// 모눈 설정
	chartObj.Plot.Axis(ibcAxisX).Grid.Interval.Auto = false;
	chartObj.Plot.Axis(ibcAxisY).Grid.Interval.Auto = false;
	
	chartObj.Plot.Axis(ibcAxisX).Grid.Interval = 1;
	chartObj.Plot.Axis(ibcAxisY).Grid.Interval = 10;
	
	// X축 레이블.
	chartObj.Plot.Axis(ibcAxisX).Annotation.AnnonateType = ibcAnnotationTypeValues;
	
	// Y축 레이블.
	chartObj.Plot.Axis(ibcAxisY).Annotation.AnnonateType = ibcAnnotationTypeValues;

	// 꺾은선 차트로 설정한다.
	chart.ChartType = ibcType2dPlot;
	subchart.ChartType = ibcType2dPlot;
	
}

function printAllChart(){
	for(k=0;k<chartObjects.length;k++){
		printChart(chartObjects[k],k+1);
    }	
}

function printOneChart(chartId){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
	 clearChart(chartObjects);
	 for(var i=0; i<sheetObj.SearchRows; i++){
		 if(i==chartId){
			 printChart(chartObjects[i], i+1);
			 if(i==0){
				 chartObjects[i].Title.Caption = "C.Spd vs M/E FOC";
			 }else if(i==1){
				 chartObjects[i].Title.Caption = "A.Spd vs M/E FOC";
			 }else if(i==2){
				 chartObjects[i].Title.Caption = "C.Spd vs RPM";
			 }else if(i==3){
				 chartObjects[i].Title.Caption = "RPM vs M/E FOC";
			 }else if(i==4){
				 chartObjects[i].Title.Caption = "LOAD vs M/E FOC";
			 }else{
				 chartObjects[i].Title.Caption = "C.Spd vs LOAD";
			 }
			  // 머리글의 색상 및 문자 정렬 방식을 지정한다.
			 chartObjects[i].Title.ForeColor = '#ddffdd';
			 chartObjects[i].Title.BackColor = '#506acc';
			 chartObjects[i].Title.TextAlign = ibcTextAlignLeft;
			  // 머리글의 글꼴을 설정한다.
			 chartObjects[i].Title.Font.Name = '굴림';
			 chartObjects[i].Title.Font.Size = 10;
			 chartObjects[i].Title.Font.Bold = true;
			  // 머리글의 위치를 지정한다.
			 chartObjects[i].Title.Location.Left.Auto = true;
			 chartObjects[i].Title.Location.Top.Auto = true;
			  // 머리글의 테두리를 설정한다.
			 chartObjects[i].Title.Frame.Style = ibcFrameStyle3DOut;
			 chartObjects[i].Title.Frame.Width = 2;
		 }else{
			 chartObjects[i].style.height=0;
		 }
	 }
}

function printChart(chartObj, chartNo){
	var sheetObj = sheetObjects[0];
	
	if(sheetObj.SearchRows==0){
		return false;
	}
	
	chartObj.style.height=390;
	chartObj.AutoRedraw = false;
	var chart = chartObj.Chart(ibcChartPrimary);
	var subchart = chartObj.Chart(ibcChartSecondary);
	var points = null;
	
	var x2Coef = null;
	var xCoef = null;
	var consts = null;
	
	chart.Series.Add('s01');
	subchart.Series.Add('s02');

	// 시리즈들의 괘선을 숨기고 심벌을 설정한다.
	chart.Series('s01').Style.Line.Pattern = ibcLineNone;
	chart.Series('s01').Style.Symbol.Color = '#00ff00';
	chart.Series('s01').Style.Symbol.SymbolType = ibcSymbolDot;
	chart.Series('s01').Style.Symbol.Size = 3;
//	chart.Series('s01').Label = "후후후";
	
	// 시리즈들의 심벌을 숨기고 Line을 설정한다.
	subchart.Series('s02').Style.Line.Pattern = ibcLineSolid;
	subchart.Series('s02').Style.Line.Width = 3;
	subchart.Series('s02').Style.Line.Color = '#CE44CE';
	subchart.Series('s02').Style.Symbol.Size = 0;
//	subchart.Series('s02').Label = "뭐임";

	//////////////////////// S01
	
	points = chart.Series('S01').Point;
	
	var rawDatas = chartObj.rawData;
	var rawData;
	var x;
	var y;
	var maxX=Number.MIN_VALUE;
	var minX=Number.MAX_VALUE;
//	var maxY=180;
//	var minY=0;
	var maxY=Number(0);
	var minY=Number(0);
	
	if(rawDatas!="0:0"){
		for(var k=0; k<rawDatas.length; k++){
			rawData = rawDatas[k];
			if(!rawData){
				continue;
			}
			x = rawData.split(":")[0];
			y = rawData.split(":")[1];
			if(x && y && x!="0" && y!="0"){
				
				if(Number(x) > maxX){
					maxX = Number(x);
				}
				if(Number(x) < minX){
					minX = Number(x);
				}
				points.Add(Number(y), Number(x));
			}
		}
	}
	
	//////////////////////// S02
	
	x2Coef = getCoefficient(sheetObj,
			 chartNo+1,
			 2); //2차식
	
	xCoef = getCoefficient(sheetObj,
			chartNo+1,
			1); //1차식
	
	consts = getCoefficient(sheetObj,
			 chartNo+1,
			 0); //상수
	
	points = subchart.Series('s02').Point;
	
	// 데이터 포인트를 추가한다.
	if(x2Coef==0 && xCoef==0 && consts==0){
		points.Add(-1, -1);
	}else{
		for(var i=minX; i<=maxX; i=i+0.1){
			x = i;
			y = Number((x2Coef*x*x) + (xCoef*x) + consts);
			if(y < minY){
				minY = y;
			}
			if(y > maxY){
				maxY = y;
			}
			points.Add(y, x);
		}
	}
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY).Max = maxY+20;
	
	// 차트 Y축 설정
	chartObj.Plot.Axis(ibcAxisY2).Min = (minY-20>0)?minY-20:0;
	chartObj.Plot.Axis(ibcAxisY2).Max = maxY+20;
	
	// 차트 X축 설정
	chartObj.Plot.Axis(ibcAxisX).Min = (minX-10>0)?minX-10:0;
	chartObj.Plot.Axis(ibcAxisX).Max = maxX+10;
	
	chartObj.AutoRedraw = true;
}

function getCoefficient(sheetObj, row, degree){
	var coefficient = 0;
	var saveName = "";
	if(degree==2){
		saveName = "n1st_coef_val";
	}else if(degree==1){
		saveName = "n2nd_coef_val";
	}else if(degree==0){
		saveName = "trnd_line_cons_val";
	}
	if(sheetObj.SearchRows>0){
		coefficient = Number(sheetObj.CellValue(row, saveName));
	}
	return coefficient;
}

function clearSheet(sheets){
	var sheetObj = null;
	ComOpenWait(true);
	for(var k=0;k<sheets.length;k++){
		sheetObj = sheets[k];
		sheetObj.RemoveAll();
	}
	ComOpenWait(false);
}

function clearChart(charts){
	var chartObj = null;
	for(var k=0;k<charts.length;k++){
		chartObj = charts[k];
		chartObj.AutoRedraw = false;
		var points = chartObj.Chart(ibcChartPrimary).Series.RemoveAll();
		var points = chartObj.Chart(ibcChartSecondary).Series.RemoveAll();
		chartObj.AutoRedraw = true;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			
			// 기존 차트 내용 초기화
	        clearChart(chartObjects);
			
			formObj.f_cmd.value = SEARCH;
			var rXml = sheetObj.GetSearchXml("VOP_FCM_0013GS.do", FormQueryString(formObj));
			var trndLineRmk = ComGetEtcData(rXml, "trnd_line_rmk");
			if(trndLineRmk){
				formObj.trnd_line_rmk.value = trndLineRmk;
			}
			
			makePoint(rXml);
			sheetObj.LoadSearchXml(rXml);
			ComOpenWait(false);
//			printAllChart();
			printOneChart(0);
			parent.syncHeight();
		}
		break;

	}
}

function makePoint(rXml){
	var points = ComGetEtcData(rXml, "CHART01");
	setRawData(chartObjects[0], points);
	
	var points = ComGetEtcData(rXml, "CHART02");
	setRawData(chartObjects[1], points);
	
	var points = ComGetEtcData(rXml, "CHART03");
	setRawData(chartObjects[2], points);
	
	var points = ComGetEtcData(rXml, "CHART04");
	setRawData(chartObjects[3], points);
	
	var points = ComGetEtcData(rXml, "CHART05");
	setRawData(chartObjects[4], points);
	
	var points = ComGetEtcData(rXml, "CHART06");
	setRawData(chartObjects[5], points);
}

function setRawData(chartObj, points){
	var rawData = new Array();
	if(points){
		rawData = points.split(",");
	}
	chartObj.rawData = rawData;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var trndLineTpCd = formObj.trnd_line_tp_cd;
	var trndLineNo = formObj.trnd_line_no;
	
	if(!trndLineTpCd.Code){
		ComShowCodeMessage('COM12113', 'Trend Line Type Code');
		trndLineTpCd.focus();
		return false;
	}else if(!trndLineNo.value){
		ComShowCodeMessage('COM12113', 'Trend Line Sequence');
		trndLineNo.focus();
		return false;
	}
	return true;
}

function setTrndLineNo(aryPopupData, row, col, sheetIdx) {
	 var formObj = document.form;
	 if(aryPopupData!=""){
		 formObj.vsl_clss_cd.value="";
		 formObj.vsl_clss_sub_cd.value="";
		 formObj.vsl_slan_cd.value="";
		 formObj.vsl_cd.value="";
		 formObj.skd_dir_cd.value="";
		 
		 formObj.trnd_line_no.value=aryPopupData[0][14];
		 formObj.trnd_line_use_tp_cd.value=aryPopupData[0][15];
		 formObj.trnd_line_tp_sub_cd.value=aryPopupData[0][7];
		 if(aryPopupData[0][1]=="1" || aryPopupData[0][1]=="2"){
			 formObj.vsl_clss_cd.value=aryPopupData[0][3];
			 if(aryPopupData[0][4]!=""){
				 formObj.vsl_clss_sub_cd.value=aryPopupData[0][4];
			 }
			 if(aryPopupData[0][2]=="ALL"){
				 formObj.vsl_slan_cd.value="A";
			 }else{
				 formObj.vsl_slan_cd.value=aryPopupData[0][2];
			 }
		 }else if(aryPopupData[0][1]=="3" || aryPopupData[0][1]=="4"){
			 formObj.vsl_cd.value=aryPopupData[0][5];
			 if(aryPopupData[0][6]=="ALL"){
				 formObj.skd_dir_cd.value="A";
			 }else{
				 formObj.skd_dir_cd.value=aryPopupData[0][6];
			 }
		 }
		 formObj.trnd_line_fm_dt.value=aryPopupData[0][11];
		 formObj.trnd_line_to_dt.value=aryPopupData[0][12];
	 }
}

/*
* 조회 후처리
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	var formObj = document.form;
	if(sheetObj.SearchRows>0){
		if(formObj.trnd_line_tp_cd.Code=="1" || formObj.trnd_line_tp_cd.Code=="2"){
			sheetObj.ColHidden("vsl_clss_cd") = false;
			sheetObj.ColHidden("vsl_clss_sub_cd") = false;
			sheetObj.ColHidden("vsl_slan_cd") = false;
			sheetObj.ColHidden("vsl_cd") = true;
			sheetObj.ColHidden("skd_dir_cd") = true;
		}else{
			sheetObj.ColHidden("vsl_clss_cd") = true;
			sheetObj.ColHidden("vsl_clss_sub_cd") = true;
			sheetObj.ColHidden("vsl_slan_cd") = true;
			sheetObj.ColHidden("vsl_cd") = false;
			sheetObj.ColHidden("skd_dir_cd") = false;
		}
	}
	visibleChtNo = 0; //initializing
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	if(Row!=visibleChtNo+sheetObj.HeaderRows){
		visibleChtNo = Row-sheetObj.HeaderRows;
		printOneChart(Row-sheetObj.HeaderRows);
	}
}

function trnd_line_tp_cd_OnChange(){
	var formObj = document.form;
	formObj.trnd_line_no.value="";
	formObj.trnd_line_rmk.value="";
	clearChart(chartObjects);
	clearSheet(sheetObjects);
}

/* 개발자 작업 끝 */