/*
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESM_MAS_0192.js
 * @FileTitle : P&L by Lane (After Adjustment)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2015-05-19
 * @LastModifier : Young-Heon Lee
 * @LastVersion : 1.1
 *  2015-05-19 Young-Heon Lee
 *  1.0 최초 생성
 * =========================================================
 *  History
 *  2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
 * =========================================================
*/
  
/**
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_MAS_0192 : ESM_MAS_0192 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0192() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.setSheetObject = setSheetObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet3_OnSearchEnd = sheet3_OnSearchEnd;
	this.setPeriod = setPeriod;
//	this.setZoom = setZoom;
	this.changeCostYrmon = changeCostYrmon;
	this.doActionIBSheet = doActionIBSheet;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.doActionIBSheet3 = doActionIBSheet3;
	this.chkValidSearch = chkValidSearch;
	this.validateForm = validateForm;
	this.validateCond = validateCond;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var loadingMode = false;

var sheet_selno = "1"; //현재 선택된 SHEET ==> 1:P&L (Total), 2:P&L (Trade), 3:P&L (VVD)

var sheet_height1 = 20; // sheet1의 height
var sheet_height2 = 20; // sheet2의 height
var sheet_height3 = 20; // sheet3의 height

var gHeadCode1 = ""; // sheet1의 header
var gHeadCode2 = ""; // sheet2의 header
var gHeadCode3 = ""; // sheet3의 header

 //Fixed Header 변경시 sheet_OnSearchEnd() 에도 영향을 줌
var fixHeadCnt1 = 4; // sheet1의 fixed header count
var fixHeadCnt2 = 4; // sheet2의 fixed header count
var fixHeadCnt3 = 13; // sheet3의 fixed header count

//var zoomFlag1 = "close"; // Zoom Flag #1
//var zoomFlag2 = "close"; // Zoom Flag #2
//var zoomFlag3 = "close"; // Zoom Flag #3
//var zoomFlag4 = "close"; // Zoom Flag #4
//var zoomFlag5 = "close"; // Zoom Flag #5
//var zoomFlag6 = "close"; // Zoom Flag #6
//var zoomFlag7 = "close"; // Zoom Flag #7
//var zoomFlag8 = "close"; // Zoom Flag #8

var first_load1 = true;  //최초 Load시만 sheet1 height 조정
var first_load2 = true;  //최초 Load시만 sheet2 height 조정
var first_load3 = true;  //최초 Load시만 sheet3 height 조정


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve":
				if (sheet_selno == "1") { //첫번째 SHEET 이면
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} else if (sheet_selno == "2") { //두번째 SHEET 이면
					doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
				} else if (sheet_selno == "3") { //세번째 SHEET 이면
					doActionIBSheet3(sheetObject3,formObject,IBSEARCH);
				}
				break;

			case "btn_downexcel":
				if (sheet_selno == "1") { //첫번째 SHEET 이면
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
				} else if (sheet_selno == "2") { //두번째 SHEET 이면
					doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
				} else if (sheet_selno == "3") { //세번째 SHEET 이면
					doActionIBSheet3(sheetObject3,formObject,IBDOWNEXCEL);
				}
				break;

			case "f_rdotype":
				if (formObject.f_rdotype[0].checked) { //P&L (Total)
		    		sheet_selno = formObject.f_rdotype[0].value;
		    		tabLayer1.style.display = "inline";
		    		tabLayer2.style.display = "none";
		    		tabLayer3.style.display = "none";
		    	} else if (formObject.f_rdotype[1].checked) { //P&L (Trade)
		    		sheet_selno = formObject.f_rdotype[1].value;
		    		tabLayer1.style.display = "none";
		    		tabLayer2.style.display = "inline";
		    		tabLayer3.style.display = "none";
		    	} else if (formObject.f_rdotype[2].checked) { //P&L (VVD)
		    		sheet_selno = formObject.f_rdotype[2].value;
		    		tabLayer1.style.display = "none";
		    		tabLayer2.style.display = "none";
		    		tabLayer3.style.display = "inline";
		    	}
//            	setZoom();
				break;
				
			case "btn_create":				
				doActionIBSheet(sheetObject1,formObject,IBCREATE);
				break;
		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 */
function loadPage(hCode1,hName1,hCode2,hName2) {
	var headCode = "";
	var headName = "";
	
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		
		var id = sheetObjects[i].id;
		
		if (id=="sheet2") {
			headCode = hCode1;
			headName = hName1;
		} else if (id=="sheet3") {
			headCode = hCode2;
			headName = hName2;
		}
		initSheet(sheetObjects[i], i+1, headCode, headName);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//SELCDA일 경우만 Create 버튼 활성화 
	
	if ( document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'CLTCO'
		|| document.form.v_ofc_cd.value == 'SELAPM'){
		ComBtnEnable("btn_create");
	} else {
		ComBtnDisable("btn_create");
	}
	
	loadingMode = true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // 멀티콤보 처리
	//---------------------------------------------
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	//---------------------------------------------
	loadingMode = false;
	
	tabLayer2.style.display = "none";
	tabLayer3.style.display = "none";

	sheet_selno = "1"; //default: P&L (Total)
//	setZoom();
}

 /**
* Combo 기본 설정
* 콤보의 항목을 설정한다.
*/
function initCombo (comboObj, comboId) {
	with (comboObj) {
		Index = 0;
		DropHeight = 300;
		
		if(comboId == "f_trd_cd"){
    		ValidChar(2,0); // 영어대문자 사용
    		MaxLength = 3;
    	} else if(comboId == "f_rlane_cd"){
    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
    		MaxLength = 5;
    	} else if(comboId == "f_dir_cd"){
    		ValidChar(2,0); // 영어대문자 사용
    		MaxLength = 1;
    	}
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 */
function initSheet(sheetObj, sheetNo, headCode, headName) {
	var formObj = document.form;
	var cnt = 0;
	var varCnt = 0;
	
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {
			    if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
			    first_load1 = false;

				SheetWidth = mainTable1.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //msNone;
				Editable = false;
				InitRowInfo(2, 1, 9, 100);
				InitColumnInfo(15, 3, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle0 = "SEQ|stnd_cost_cd|Items|Weekly MAS|Weekly MAS|Weekly MAS|Weekly MAS|Adjustment|Adjustment|Adjustment|Adjustment|MAS (After Adj)|MAS (After Adj)|MAS (After Adj)|MAS (After Adj)";
				var HeadTitle1 = "SEQ|stnd_cost_cd|Items|H/H|B/H|M/B|Total|H/H|B/H|M/B|Total|H/H|B/H|M/B|Total";
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, false);


				cnt = 0;
				//데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "");
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,   220, daLeft,   true, "itm_desc",     false, "", dfNone, 0, false, false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "hh_wkly_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "bh_wkly_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "mb_wkly_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "ttl_wkly_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "hh_adj_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "bh_adj_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "mb_adj_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "ttl_adj_amt",       		false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "hh_mon_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "bh_mon_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "mb_mon_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				InitDataProperty(0,     cnt++,  dtData,         100,     daRight,   true,    "ttl_mon_amt",       	false,   "",   dfFloatOrg,     2,  false,  false);
				
				for (var i = 2 ; i < 15 ; i ++) {
					CellBackColor(1, i) = RgbColor(222,251,248);
				}
				HeadRowHeight = 10;
				CountPosition = 0;
				
				DataLinkMouse("itm_desc") = true;
				InitTreeInfo("itm_desc", "itm_name", RgbColor(0,0,255), true);
			}
			break;

		case "sheet2":      //sheet2 init
			if (headName == "") {
				headCode = "|AES|IAS|IES|IMS|TAS|TPS";
				headName = "|AES|IAS|IES|IMS|TAS|TPS";
			}
			gHeadCode4 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			var arrHead = headName.replace(/(^\s*)/g,'').split("|");
			varCnt = arrHead.length - 1;

			var headText0 = "";
			var headText1 = "";
			for (n=1; n<=varCnt; n++) {
				headText0 = headText0 + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n];
				headText1 = headText1 + "|H/H|B/H|M/B|TOT";
			}

			with (sheetObj) {
			    if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
			    first_load2 = false;
				//style.height = GetSheetHeight(sheet_height1) ;

				SheetWidth = mainTable2.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //msNone;
				Editable = false;
				InitRowInfo(2, 1, 9, 100);
				InitColumnInfo(fixHeadCnt2 + (varCnt * 4) + 1, fixHeadCnt2 - 1, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle0 = "SEQ|stnd_cost_cd|Items" + headText0 + "|COM|Total";
				var HeadTitle1 = "SEQ|stnd_cost_cd|Items" + headText1 + "|COM|Total";
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, false);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "");
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,   220, daLeft,   true, "itm_desc",     false, "", dfNone, 0, false, false);

				var calcuLogic = "";
				for (n=0; n<varCnt; n++) {
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_e_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_w_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_m_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;

					InitDataProperty(0, cnt, dtData, 90, daRight, true, "trd_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					calcuLogic = calcuLogic + "+|trd_amt"+(n+1)+"|";
					cnt++;
				}
				if (calcuLogic != "") { calcuLogic = calcuLogic.substring(1); }

				InitDataProperty(0, cnt++, dtData,  90, daRight, true, "com_amt", false, "", dfFloatOrg, 2, false, false);
				InitDataProperty(0, cnt++, dtData,  90, daRight, true, "ttl_amt", false, "", dfFloatOrg, 2, false, false);

				HeadRowHeight = 10;
				CountPosition = 0;

				DataLinkMouse("itm_desc") = true;
				InitTreeInfo("itm_desc", "itm_name", RgbColor(0,0,255), true);

			}
			break;

		case "sheet3":      //sheet3 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}
			gHeadCode3 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode3.length;

			with (sheetObj) {
			    if (first_load3 == true) { style.height = GetSheetHeight(sheet_height3); }
			    first_load3 = false;
				//style.height = GetSheetHeight(sheet_height3) ;

				SheetWidth = mainTable3.clientWidth;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(fixHeadCnt3 + varCnt, fixHeadCnt3, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir." + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "skd_dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
				
                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
					if (gHeadCode3[n] == "LOADFACT" || gHeadCode3[n] == "RPB00000" || gHeadCode3[n] == "CMCB0000" || 
				        gHeadCode3[n] == "CMB00000" || gHeadCode3[n] == "OPCB0000" || gHeadCode3[n] == "OPB00000" ||
				        gHeadCode3[n] == "BOPB0000" || gHeadCode3[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    if (gHeadCode3[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}
				HeadRowHeight = 10;
				CountPosition = 0;
				sheetObj.ColHidden("rhq") = true;
			}
			break;	
	}
}
 /**
* IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBSheet Object를 배열로 등록
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
	var fixCnt = fixHeadCnt2 - 1; //가변길이 뒤 Total 필드 제외
	var supply = 0;
	var load = 0;
	
	with(sheetObj) {
		//L/F, RPB 합계 재계산
		var loadR   = FindText("stnd_cost_cd","LOAD0000"); // Load
		var supplyR = FindText("stnd_cost_cd","BSA00000"); // Supply
		var revR    = FindText("stnd_cost_cd","REVENUE0"); // Revenue

		var t1R = FindText("stnd_cost_cd","LOADFACT"); // L/F = (Load / Supply) * 100
		var t2R = FindText("stnd_cost_cd","RPB00000"); // RPB = Revenue / Load

		var s3R = FindText("stnd_cost_cd","CMCOST00"); // Cost1 Total
		var t3R = FindText("stnd_cost_cd","CMCB0000"); // Cost1/TEU = Cost1 Total / Load
		var s4R = FindText("stnd_cost_cd","CMCTOTAL"); // CM(Net Revenue) Total
		var t4R = FindText("stnd_cost_cd","CMB00000"); // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		 
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI
		var s7R = FindText("stnd_cost_cd","BCMTOTAL"); // Branch CM(Net Revenue) Total
		var t7R = FindText("stnd_cost_cd","BCMB0000"); // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load		
		
		var s5R = FindText("stnd_cost_cd","OPCOSTEX"); // OP Cost Total(excluding interest)
		var t5R = FindText("stnd_cost_cd","OPCB0000"); // OP Cost(excluding interest) /TEU
		
		var s6R = FindText("stnd_cost_cd","OPCTOTAL"); // OP(Operating Profit) Total
		var t6R = FindText("stnd_cost_cd","OPB00000"); // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load

		var s7R = FindText("stnd_cost_cd","OPUTOTAL"); // BU OP(Operationg Profit) Total
		
		var s8R = FindText("stnd_cost_cd","BOPTTLEX"); // OP(excluding interest)
		var t8R = FindText("stnd_cost_cd","BOPB0000"); // OP(excluding)/TEU
     
		for (var i=fixCnt; i<=LastCol; i++) { //3은 seq, stnd_cost_cd, itm_desc 제외
			if (CellValue(1,i) == "H/H" || CellValue(1,i) == "B/H" || CellValue(1,i) == "M/B" || CellValue(1,i) == "TOT") {
				supply = (CellValue(supplyR,i)==null) ? 0 : CellValue(supplyR,i);
				load   = (CellValue(loadR,i)==null) ? 0 : CellValue(loadR,i);

				if (t1R > -1) CellValue2(t1R,i) = (supply==0) ? 0 : (load / supply) * 100;
				if (t2R > -1 && revR > -1) CellValue2(t2R,i) = (load==0) ? 0 : CellValue(revR,i) / load;

				if (t3R > -1 && s3R > -1) CellValue2(t3R,i) = (load==0) ? 0 : CellValue(s3R,i) / load;
				if (t4R > -1 && s4R > -1) CellValue2(t4R,i) = (load==0) ? 0 : CellValue(s4R,i) / load;
				
         		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI				
				if (t7R > -1 && s7R > -1) CellValue2(t7R,i) = (load==0) ? 0 : CellValue(s7R,i) / load;				
				//OP Cost(excluding interest) /TEU
				if (t5R > -1 && s5R > -1) CellValue2(t5R,i) = (load==0) ? 0 : CellValue(s5R,i) / load;
				if (t6R > -1 && s6R > -1) CellValue2(t6R,i) = (load==0) ? 0 : CellValue(s6R,i) / load;

				//OP(excluding)/TEU
				if (t8R > -1 && s8R > -1) CellValue2(t8R,i) = (load==0) ? 0 : CellValue(s8R,i) / load;	
			}
		}

		//Total 재계산
		supply = (CellValue(supplyR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(supplyR,"ttl_amt"));
		load   = (CellValue(loadR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(loadR,"ttl_amt"));
		if(t1R>0) CellValue2(t1R,"ttl_amt") = (supply==0) ? 0 : (load / supply) * 100;
		if(t2R>0) CellValue2(t2R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(revR,"ttl_amt")) /  load;
		if(t3R>0) CellValue2(t3R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s3R,"ttl_amt")) /  load;
		if(t4R>0) CellValue2(t4R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s4R,"ttl_amt")) /  load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI		
		if(t7R>0) CellValue2(t7R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s7R,"ttl_amt")) /  load;		
		//OP Cost(excluding interest) /TEU
		if(s5R>0) CellValue2(t5R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s5R,"ttl_amt")) /  load;
		if(t6R>0) CellValue2(t6R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s6R,"ttl_amt")) /  load;
		
		// OP(excluding)/TEU
		if(t8R>0) CellValue2(t8R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s8R,"ttl_amt")) /  load;
	}
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
		var loadC   = 0; // Load
		var supplyC = 0; // Supply
		var revC    = 0; // Revenue

		var t1C = 0; // L/F = L/F = (Load / Supply) * 100
		var t2C = 0; // RPB = Revenue / Load

		var s3C = 0; // Cost1 Total
		var t3C = 0; // Cost1/TEU = Cost1 Total / Load
		var s4C = 0; // CM(Net Revenue) Total
		var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI			
		var s7C = 0; // Branch CM(Net Revenue) Total
		var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

		var s5C = 0; // OP Cost Total(excluding interest)
		var t5C = 0; // OP Cost(excluding interest) /TEU
		
		var s6C = 0; // OP(Operating Profit) Total
		var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
				
		var s8C = 0; // OP(excluding interest)
		var t8C = 0; // OP(excluding)/TEU

		var arrCnt = gHeadCode3.length;
		for (var i=0; i<arrCnt; i++) {
			if (gHeadCode3[i] == "LOAD0000") { loadC   = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "BSA00000") { supplyC = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "REVENUE0") { revC    = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "LOADFACT") { t1C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "RPB00000") { t2C = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "CMCOST00") { s3C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMCB0000") { t3C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMCTOTAL") { s4C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMB00000") { t4C = i + fixHeadCnt3; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
			if (gHeadCode3[i] == "BCMTOTAL") { s7C = i + fixHeadCnt3; }			
			if (gHeadCode3[i] == "BCMB0000") { t7C = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "OPCOSTEX") { s5C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "OPCB0000") { t5C = i + fixHeadCnt3; }
			
			if (gHeadCode3[i] == "OPCTOTAL") { s6C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "OPB00000") { t6C = i + fixHeadCnt3; }
			
			if (gHeadCode3[i] == "BOPTTLEX") { s8C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "BOPB0000") { t8C = i + fixHeadCnt3; }
		}

		var Row = LastRow;

		supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
		load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

		if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
		if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

		if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
		if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;		
		
		if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
		if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
		if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
	}
}

/**
* trade변경시 R.Lane combo변경
*/
function f_trd_cd_OnChange(obj, code, text) {
	if (loadingMode == true)
		return;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	var tradeCombo = document.getElementById("f_trd_cd");
	var rlaneCombo = document.getElementById("f_rlane_cd");
		
	if (obj.Text != "") {
		
		formObj.f_cmd.value = SEARCHLIST11;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
			ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "code");	
			
			if(tradeCombo.Code == "COM") {
				rlaneCombo.InsertItem(-1, 'CDMCO', 'CDMCO');
				rlaneCombo.InsertItem(-1, 'CNTLY', 'CNTLY');
			} else if(tradeCombo.Code != "All") {
				rlaneCombo.InsertItem(-1, 'CNTTS', 'CNTTS');
				rlaneCombo.InsertItem(-1, 'CNTMR', 'CNTMR');
			}
		}
		
		formObj.f_rlane_cd.Index = 0;
		formObj.f_sub_trd_cd.Index = 0;
	}
}


/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComMasSetPeriod(obj);
}

//화면의 Zoom 처리
//function setZoom() {
//	if (sheet_selno == "1") { //첫번째 SHEET 이면
//		if (zoomFlag1 == "open") {
//		    div_zoom_in1.style.display  = "none";  
//		    div_zoom_out1.style.display = "inline";
//		} else if (zoomFlag1 == "close") {
//		    div_zoom_in1.style.display  = "inline"; 
//		    div_zoom_out1.style.display = "none";
//		}
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "2") { //두번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		if (zoomFlag2 == "open") {
//		    div_zoom_in2.style.display  = "none";  
//		    div_zoom_out2.style.display = "inline";
//		} else if (zoomFlag2 == "close") {
//		    div_zoom_in2.style.display  = "inline"; 
//		    div_zoom_out2.style.display = "none";
//		}
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "3") { //세번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		if (zoomFlag3 == "open") {
//		    div_zoom_in3.style.display  = "none";  
//		    div_zoom_out3.style.display = "inline";
//		} else if (zoomFlag3 == "close") {
//		    div_zoom_in3.style.display  = "inline"; 
//		    div_zoom_out3.style.display = "none";
//		}
//
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "4") { //두번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//
//		if (zoomFlag4 == "open") {
//		    div_zoom_in4.style.display  = "none";  
//		    div_zoom_out4.style.display = "inline";
//		} else if (zoomFlag4 == "close") {
//		    div_zoom_in4.style.display  = "inline"; 
//		    div_zoom_out4.style.display = "none";
//		}
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "5") { //세번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//
//		if (zoomFlag5 == "open") {
//		    div_zoom_in5.style.display  = "none";  
//		    div_zoom_out5.style.display = "inline";
//		} else if (zoomFlag5 == "close") {
//		    div_zoom_in5.style.display  = "inline"; 
//		    div_zoom_out5.style.display = "none";
//		}
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "6") { //두번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//
//		if (zoomFlag6 == "open") {
//		    div_zoom_in6.style.display  = "none";  
//		    div_zoom_out6.style.display = "inline";
//		} else if (zoomFlag6 == "close") {
//		    div_zoom_in6.style.display  = "inline"; 
//		    div_zoom_out6.style.display = "none";
//		}
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "7") { //두번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		
//		if (zoomFlag7 == "open") {
//			div_zoom_in7.style.display  = "none";  
//			div_zoom_out7.style.display = "inline";
//		} else if (zoomFlag7 == "close") {
//			div_zoom_in7.style.display  = "inline"; 
//			div_zoom_out7.style.display = "none";
//		}
//		div_zoom_in8.style.display  = "none";
//		div_zoom_out8.style.display = "none";
//	} else if (sheet_selno == "8") { //두번째 SHEET 이면
//		div_zoom_in1.style.display  = "none";
//		div_zoom_out1.style.display = "none";
//		div_zoom_in2.style.display  = "none";
//		div_zoom_out2.style.display = "none";
//		div_zoom_in3.style.display  = "none";
//		div_zoom_out3.style.display = "none";
//		div_zoom_in4.style.display  = "none";
//		div_zoom_out4.style.display = "none";
//		div_zoom_in5.style.display  = "none";
//		div_zoom_out5.style.display = "none";
//		div_zoom_in6.style.display  = "none";
//		div_zoom_out6.style.display = "none";
//		div_zoom_in7.style.display  = "none";
//		div_zoom_out7.style.display = "none";
//		
//		if (zoomFlag8 == "open") {
//			div_zoom_in8.style.display  = "none";  
//			div_zoom_out8.style.display = "inline";
//		} else if (zoomFlag8 == "close") {
//			div_zoom_in8.style.display  = "inline"; 
//			div_zoom_out8.style.display = "none";
//		}
//	}
//}

/*
 * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
 */
function changeCostYrmon(val){
}
//changeCostYrmon

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBCLEAR:          //조회
	    	formObj.f_year.value = ComGetNowInfo("yy");
	        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
	        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
	        
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			var sXml = document.form.sXml.value;
			document.form.sXml.value = "";
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			var arrXml = sXml.split("|$$|");
			formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
	        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek");
	        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
	        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear");
	        
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "code");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], formObj.f_dir_cd, "code", "code");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], formObj.f_trd_dir_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_sub_trd_cd, "code", "code");
			
			document.getElementById("f_trd_cd").InsertItem(-1, 'COM', 'COM');
			document.getElementById("f_dir_cd").InsertItem(-1, 'M', 'M');
			ComOpenWait(false);
			break;
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;    		
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST01;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경

			var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS1.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[0]);
				initSheet(sheetObj, 1, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			sheetObj.ShowTreeLevel(-1); //트리 모두펴기

			//sheetObj.SpeedDown2Excel(-1);
			//sheetObj.Down2Excel(-1, false, false, true);
			
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;
			case IBCREATE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
	  					sheetObj.WaitImageVisible = false;
	  					ComOpenWait(true);
	  					formObj.f_cmd.value = MULTI;
	  					if (formObj.f_chkprd[0].checked) {
	  						formObj.f_wk_flg.value = "yrwk";
	  					} else if (formObj.f_chkprd[1].checked){
	  						formObj.f_wk_flg.value = "yrmon";
	  					}
	  					var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS.do",  masFormQueryString(formObj));
	  				  
	  					if (sXml != "") sheetObj.LoadSearchXml(sXml);

	  					var statusCode = ComGetEtcData(sXml, "BatchStatus" );
	  					
	  					switch(statusCode){
	  						case "4": // 작업 submit			
	  							sheetObj.RemoveAll();  
	  					        ComBtnDisable("btn_create");
	  							monitoringBatchJob();
	  							break;
	  						case "5":// Error 발생
	  							ComShowMessage("P&L Adjustment Creation");
	  							break;
	  						case "6"://해당 작업이 진행 중 
	  							ComShowCodeMessage("MAS00003", "P&L Adjustment Creation");
	  							ComOpenWait(false);  
	  							break;
	  						default: break;							
	  					}  
  					}
  					
  				}
  				break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		 
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST02;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS2.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[1]);
				initSheet(sheetObj, 2, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			//sheetObj.SpeedDown2Excel(-1);
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet3(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		  
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST03;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS3.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[2]);
				initSheet(sheetObj, 3, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			view_rhq();
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			//sheetObj.SpeedDown2Excel(-1);
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;

	}
}

   /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;

		with(formObj){
            	if(f_year.value == ""){
	                ComShowMessage(ComGetMsg("COM12114","Year",""));
	                f_year.focus();
	                return false;
	            }
	            if(!ComIsDate(f_year, "yyyy")){
	 		    // [MAS1009] = Year 값을 확인하십시오.
	 		    	ComShowCodeMessage('MAS10009','Year','YYYY');
	 		    	f_year.focus();
	 		    	return false;
	 		    }
	            
	            if(f_chkprd[0].checked){
	            	if (f_to_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "week", ""));
		                f_to_wk.focus();
		                return false;
		            }
		            if (f_fm_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "Week", ""));
		                f_fm_wk.focus();
		                return false;
		            }
		            if(!ComIsWeek(f_fm_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_fm_wk.focus();
						return false;
					}
					if(!ComIsWeek(f_to_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_to_wk.focus();
						return false;
					}
	            }else{
	            	if (f_to_mon.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "month", ""))
		                f_to_mon.focus();
		                return false;
		            }   
		            if (f_fm_mon.value == "" ) {
		                ComShowMessage(ComGetMsg("COM12114", "Month", ""));
		                f_fm_mon.focus();
		                return false;
		            }
		            if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
		                ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
		                return false;
		            }
		            if(!ComIsMonth(f_fm_mon.value)){ 
						ComShowMessage(ComGetMsg("COM12114", "Month"));
						f_fm_mon.focus();
						return false;
					}
					if(!ComIsMonth(f_to_mon.value)){
						ComShowMessage(ComGetMsg("COM12114", "Month"));
						f_to_mon.focus();
						return false;
					}
	            }
            }
		return true;
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (f_year.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Year"));
			    f_year.focus();
				return false;
			}
			
			//IBCREATE : PL chart Creation은 week option에서만 생성 가능
			//           2주치까지 생성 할 수 있음.
			
			if (sAction == IBCREATE){
				if (f_chkprd[1].checked) { //Month Option이 켜져 있으면
					ComShowMessage("When you click 'create' button, the latest 1year data will be automatically created.");
					return true;
				}
				
				if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) < 0){
                    // [MAS10015] : Please check from week first.
                    ComShowMessage(ComGetMsg("MAS10015", "from week"));
                    f_fm_wk.focus();
                    return false;
				}

				 if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) > 1){
                     // [MAS10007] : A maximum of 2 weeks can be entered.
                     ComShowMessage(ComGetMsg("MAS10007", "2"));
                     f_fm_wk.focus();
                     return false;
                 }
			} else { // Create가 아닌 조회 일경우 validation
			
					if((f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == "") 
					   && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_skd_dir_cd.value == ""){
					    ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
					    return false;
					}
					if((f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == "") 
					   && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_skd_dir_cd.value == ""){
					    ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
					    return false;
					}
			}
		    if(!chkValidSearch()) return false;
			
//			if((f_chkprd[1].checked && f_year.value == "2007" && parseInt2(f_fm_mon.value) < 7) || 
//			   (f_chkprd[0].checked && f_year.value == "2007" && parseInt2(f_fm_wk.value) < 27)){
//			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
//			    ComShowMessage(ComGetMsg("MAS10037"));
//			    return false;
//			}
		    
		    // Create 기능은 Week 상태에서만 가능, 이때 필수 값은 연도,from week임.
		    // 주차는 1주만 가능 , 1주 이상일경우는 MAS10003
		    
		}
		return true;
	}
	
	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {
		with(formObj){
			// msg1 + ' 는(은) ' + msg2 + '자리가 되어야 합니다.';
			if (ComTrim(f_vsl_cd.value) != "" && ComTrim(f_vsl_cd.value).length != 4){
				ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
				f_vsl_cd.focus();
				return false;
			}
			if (ComTrim(f_skd_voy_no.value) != "" && ComTrim(f_skd_voy_no.value).length != 4){
				ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
				f_skd_voy_no.focus();
				return false;
			}
		}
	
		return true;
	}
    
    /**
	 * batch Satus가 running중이거나 Error일때 조회되지 않도록 한다.
	 */
	function validBatchStatus(sheetObj,formObj,sAction){

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
//
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"BatchStatus")== 'P') {
				ComShowMessage(ComGetMsg("MAS00003", "P&L Adjustment Creation"));
				ComOpenWait(false);
				return false;
			}
////			
			if (ComGetEtcData(sXml,"BatchStatus")== 'E') {
				ComShowMessage(ComGetMsg("MAS00005", "week"+ComGetEtcData(sXml,"BatchWeek")+" creation", "create"));
				ComOpenWait(false);
				return false;
			}
//			
			ComOpenWait(false);

		return true;
	}
	
	/**
	 *  VVD view에 office level이 regional office 경우 rhq 노출
	 */
    function view_rhq() {
    	var formObj = document.form;
        if(formObj.f_rdotype[2].checked) {
        	sheetObjects[2].ColHidden("rhq") = false;
        } else {
        	sheetObjects[2].ColHidden("rhq") = true;
        }
    }

/**
 * batch job monitoring 
 * 
 * @return 없음
 * @version 2013.02.06
 */ 
function monitoringBatchJob(){
	//개발시에는 모니터링을 하지 않는다.
	if(location.hostname == "localhost"){
		return;
	}
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("ESM_MAS_0192GS.do", FormQueryString(formObj));
	var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
	if( BatchStatus == "6" ){
		setTimeout(monitoringBatchJob,60000);
	}else{
		ComBtnEnable("btn_create");
		ComShowCodeMessage('MAS10018',"P&L Adjustment Creation"); 
		ComOpenWait(false);
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}