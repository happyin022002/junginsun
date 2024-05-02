/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_PSO_0039.js
*@FileTitle : Tariff Simulation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.25
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.06.10 진마리아
* 1.0 Creation
* 
* History
* 2011.06.15 진마리아 CHM-201111910-01 [PSO] Tariff Simulation By VVD 신규화면 생성
* 2012.09.25 진마리아 CHM-201220208-01 YD/ACCT별 Detail 비용을 Excel Down 기능 추가
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
 * @class VOP_PSO_0039 : VOP_PSO_0039 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_PSO_0039() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo				= initCombo;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var sheetCnt = 0;

//for handling detail grid
var yards = "";
var accts = "";
var acctNms = "";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
				
			case "btn_Calculation":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;
				
			case "btn_DownExcel":
				if(!handlingDetailGrid()){
					ComShowMessage("There is no Port except Virtual Port in this VVD.");
				}else{
					sheetObjects[2].Down2Excel(-1);
				}
				break;
		} 
	}catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	initControl(sheetObjects[0]);
	document.form.vvd.focus();
}

function initControl(sheetObj){
	// Form 객체 선언
	formObj = document.form;
	// axon event 등록
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
}

function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	
	switch(sheetid) {
		
		case "sheet1":	//Objects (Auto)
			with (sheetObj) {
				// 높이 설정
				style.height = 360;
//				style.width = 700;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "|Port|clpt_ind_seq|Yard|Type|Ratio|Ratio|Currency|Issue Date\n(ETD)|Tariff Cost Amount";
				var HeadTitle2 = "|Port|clpt_ind_seq|Yard|Type|I/B|O/B|Currency|Issue Date\n(ETD)|Tariff Cost Amount";
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, false);
				var prefix = "sheet1_";
				
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"vps_port_cd",   false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,		prefix+"clpt_ind_seq",  false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"yd_cd",			false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtCombo,		80,		daCenter,	true,		prefix+"port_type",		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"ib_ratio",		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"ob_ratio",		false,	"",			dfNone,			0,		false,  false);
//				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"dp_io_bnd_cd",	false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"curr_cd",		false,	"",			dfNone,			0,		false,  false);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"vps_etd_dt",	false,	"",			dfUserFormat,	0,		false,  false);
				InitDataProperty(0, cnt++ , dtAutoSumEx,	150,	daRight,	true,		prefix+"yd_ttl_usd_amt",false,	"",			dfFloat,		2,		false,  false);
			
				InitUserFormat(0, prefix+"vps_etd_dt", "####-##-##", "-");
				InitDataCombo(0, prefix+"port_type", "Turning|Virtual|", "T|V|");
				
				RowHeight(0)=20;
				RowHeight(1)=20;
				
				WaitImageVisible = false;
			}
		break;
		
		case "sheet2":	//detail(account별)
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "|Yard|Acct|Amt";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet2_";
			
			//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	60,		daCenter,	true,		prefix+"ibflag");
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"yd_cd",   	false,	"",			dfNone,		0,		false,  false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"acct_cd",  			false,	"",			dfNone,		0,		false,  false);
//			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		prefix+"curr_cd",			false,	"",			dfNone,		0,		false,  false);
			InitDataProperty(0, cnt++ , dtData,			150,	daRight,	true,		prefix+"tariff_usd_amount",	false,	"",			dfNone,		0,		false,  false);
			
			WaitImageVisible = false;
		}
		break;
		
		case "sheet3":  //excel download
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:      // 조회
			if (validateForm(sheetObj, formObj, sAction)){
				var aryPrefix = new Array("sheet1_", "sheet2_");
				formObj.f_cmd.value = SEARCH;
				sheetObj.Redraw = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("VOP_PSO_0039GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				ComOpenWait(false);
				var arrXml = sXml.split("|$$|");
				sheetObjects[0].LoadSearchXml(arrXml[0]);
				sheetObjects[1].LoadSearchXml(arrXml[1]);
				sheetObjects[1].ColumnSort("sheet2_acct_cd");
				sheetObj.Redraw = true;
				
				yards = ComGetEtcData(arrXml[0], "yards");
				accts = ComGetEtcData(arrXml[0], "accts");
				acctNms = ComGetEtcData(arrXml[0], "acctNms");
				
			}
			break;
		
		case IBCLEAR:  
			//VVD
			formObj.vvd.value = "";
			formObj.exp_rto.checked = false;
			//Sheets	
			for(var i=0; i<sheetObjects.length; i++){
		 		sheetObjects[i].RemoveAll();
		 	}
			
			yards = "";
			accts = "";
			acctNms = "";
		break;        
	
	}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
			//vvd
			if(formObj.vvd.value.length < 9){
				ComShowCodeMessage('PSO00001', 'VVD');
				formObj.vvd.focus();
				return false;
			}	
		break;
	}
	return true;
}


function obj_keypress(){
	obj = event.srcElement;
	if(obj.dataformat == null) return;

	window.defaultStatus = obj.dataformat;

	switch(obj.dataformat) {
		case "engup":
			if(obj.name=="vvd"){
				ComKeyOnlyAlphabet('uppernum');
			} else {
				ComKeyOnlyAlphabet('upper');
			}
			
			break;
	}
}

/*
* 조회 후처리
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
		sheetObj.CellValue(i, "sheet1_curr_cd") = "USD";
	}
}

function handlingDetailGrid(){
	var sheetObj1 = sheetObjects[1];
	var sheetObj = sheetObjects[2]; //Download용

	if(yards=="" || accts==""){
		return false;
	}
	var acctList = accts.split("|");
	var acctNmsList = acctNms.split("|");
	//USNYC|MXESE|USSAV|USILM
	var yardList = yards.split("|");
	var yardCnt = yardList.length;
	var sheetHdr1 = "ACCT|ACCT|";
	var sheetHdr2 = "ACCT|ACCT|";

	for(var i=0; i<yardCnt; i++){
		sheetHdr1 = sheetHdr1+yardList[i]+"|"+yardList[i];
		sheetHdr2 = sheetHdr2 + "CUR|Tariff Cost";
		
		if(i<yardCnt-1){
			sheetHdr1 = sheetHdr1+"|";
			sheetHdr2 = sheetHdr2+"|";
		}
	}
	
	initExcelSheet(sheetObj, sheetHdr1, sheetHdr2, yardList);
	inputAcctList(sheetObj, acctList, acctNmsList); //excel sheet에 account를 셋팅
	inputTariffData(sheetObj, acctList, yardList); //excel sheet에 tariff amount를 셋팅
	
	return true;
}

function initExcelSheet(sheetObj, sheetHdr1, sheetHdr2, yardList) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	
	switch(sheetid) {
		
		case "sheet3":	//Excel Download용
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = sheetHdr1;
				var HeadTitle2 = sheetHdr2;
				var headCount = ComCountHeadTitle(HeadTitle1);
				
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, false);
				var prefix = "sheet3_";
				
				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		prefix+"acct_cd");
				InitDataProperty(0, cnt++ , dtData,	60,		daLeft,		true,		prefix+"acct_eng_nm");
				for(var i=0; i<yardList.length; i++){
					InitDataProperty(0, cnt++ , dtData,	60,		daCenter,	true,		prefix+"curr_cd_"+i);
					InitDataProperty(0, cnt++ , dtAutoSumEx,	60,		daRight,	true,		prefix+"tariff_usd_amount_"+i,false,	"",			dfNullFloat,		2,		false,  false);
				}
			
				RowHeight(0)=20;
				RowHeight(1)=20;
				
				SetMergeCell(0, 0, 2, 2);//Header 강제 merge
				
				WaitImageVisible = false;
			}
		break;
	}
}

function inputAcctList(sheetObj, acctList, acctNmsList){
	
	for(var i=0; i<acctList.length; i++){
		var row = sheetObj.DataInsert(-1);
		sheetObj.CellValue2(row, "sheet3_acct_cd") = acctList[i];
		sheetObj.CellValue2(row, "sheet3_acct_eng_nm") = acctNmsList[i];
	}
}

function inputTariffData(sheetObj, acctList, yardList){
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		for(var j=0; j<yardList.length; j++){
			sheetObj.CellValue2(i,2*j+3) = findExactData(acctList[i-sheetObj.HeaderRows], yardList[j]);//tariff amount
			sheetObj.CellValue2(i,2*j+2) = "USD";//currency
		}
		
	}
}

//raw data에서 주어진 acct,yd 에 해당하는 tariff amount를 찾는다. 단, vndr가 여럿인 경우로 인해 합산 필요.
function findExactData(acct, yard){
	var sheetObj2 = sheetObjects[1];
	var amount = "";
	for(var i=sheetObj2.HeaderRows; i<sheetObj2.HeaderRows+sheetObj2.RowCount; i++){
		if(yard==sheetObj2.CellValue(i, "sheet2_yd_cd") && acct==sheetObj2.CellValue(i, "sheet2_acct_cd")){
			amount = Number(amount) + Number(sheetObj2.CellValue(i, "sheet2_tariff_usd_amount"));
		}
	}
	return amount;
}

 /* 개발자 작업  끝 */