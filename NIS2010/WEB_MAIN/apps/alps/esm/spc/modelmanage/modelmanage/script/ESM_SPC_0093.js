/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0093.js
*@FileTitle : Report by SMP
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.17 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가 
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=90;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_SPC_0093 : ESM_SPC_0093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_SPC_0093() {
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
	this.setTabObject 			= setTabObject;
}

/* 개발자 작업	*/
var sheetObjects = new Array();
var comObjects   = new Array();
var sheetCnt     = 0;
var comboCnt     = 0;
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var strSubTrd = ""; //sheet1의 header인 sub trade 를 "|"로 붙여놓은 문자열

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch (srcName) {
		case "btn_retrieve":
			if(beforetab==0){ 
        		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
			}else if(beforetab==1){
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
			}
			break;

		case "btn_new":			
			clearAll();
			break;
			
		case "btn_downexcel":
			if(beforetab==0){ 
        		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
			}else if(beforetab==1){
				doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
			}
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setComboObject(combo_obj) {
	comObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	SpcSearchOptionTrade("trade", false);
	SpcSearchOptionSubTrade("subtrade", true, true);
	SpcSearchOptionLane("lane");
	SpcSearchOptionRHQCombo("rhq",true);
	
	strSubTrd = "SUB TRADE";
		
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }
	initControl();

	var formObj = document.form;
	
	formObj.trade.Code = "TPS";
	
}

function initControl() {
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerForm('click', 'obj_click', form);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // sheet1 init		
		initSheet1(sheetObj, strSubTrd);
		sheetObj.ColHidden("cust_lgl_eng_nm") = true;
		sheetObj.ColHidden("ctrt_ofc_cd") = true;
		sheetObj.ColHidden("sc_no") = true;
		sheetObj.ColHidden("rfa_no") = true;
		break;
		
	case 2:
		initSheet2(sheetObj);
		sheetObj.ColHidden("cust_lgl_eng_nm") = true;
		sheetObj.ColHidden("ctrt_ofc_cd") = true;
		sheetObj.ColHidden("sc_no") = true;
		sheetObj.ColHidden("rfa_no") = true;
		sheetObj.ColHidden("wk_mqc_qty") = true;
		break;
	}
}

function initSheet1(sheetObj, subTrds) {
	
	with (sheetObj) {
		// 높이 설정
		style.height = 370;//getSheetHeight(17);
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = false;
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(3, 1, 9, 100);
		
		var subTrdArr = subTrds.split("|");
		var subTrdTitle1 = ""; 
		var subTrdTitle2 = ""; 
		var subTrdTitle3 = ""; 
		var cnt = 0;
		
		if(subTrdArr.length == 0){
			cnt = 1;
		}else{
			cnt = subTrdArr.length;
		}
		
		for(var i = 0 ; i < cnt ; i++){
			subTrdTitle1 = subTrdTitle1 + "|sub_trd|" + subTrdArr[i] + "|" + subTrdArr[i] + "|" + subTrdArr[i] + "|" + subTrdArr[i];
			subTrdTitle2 = subTrdTitle2 + "|sub_trd|Guided|Guided|Loading QTA|Loading QTA";
			subTrdTitle3 = subTrdTitle3 + "|sub_trd|TEU|Portion|TEU|%";
		}
		
		var HeadTitle1 = "Rep.\nTrade|RHQ|L.OFC|Yield\nGroup|ACCT\nClass|ACCT|C.OFC|SC#|RFA#|lvl" + subTrdTitle1 + "|";
		var HeadTitle2 = "Rep.\nTrade|RHQ|L.OFC|Yield\nGroup|ACCT\nClass|ACCT|C.OFC|SC#|RFA#|lvl" + subTrdTitle2 + "|";
		var HeadTitle3 = "Rep.\nTrade|RHQ|L.OFC|Yield\nGroup|ACCT\nClass|ACCT|C.OFC|SC#|RFA#|lvl" + subTrdTitle3 + "|";
		
		var headCount = ComCountHeadTitle(HeadTitle1);
 		
		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, false);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false);
 		
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		InitHeadRow(2, HeadTitle3, true);

		var cnt = 0;
		
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trd_cd"    ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "sls_rhq_cd",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "sls_rgn_ofc_cd",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_ctrl_cd"    ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "acct_clss"    ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daLeft, true, "cust_lgl_eng_nm" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "ctrt_ofc_cd"   	,	false, "", dfNone, 0, false, false);		
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no"   	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no"   	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 10, daCenter, true, "tree_lvl" ,	false, "", dfNone, 0, false, false);
		
		for(var i = 1 ; i < subTrdArr.length+1 ; i++){
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "sub_trd_cd"+i     ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "sub_trd_adj_qty_"+i     ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "sub_trd_adj_ratio_"+i   ,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "c_load_qta_"+i   		,	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "c_load_qta_ratio_"+i   	,	false, "", dfNone, 0, false, false);		
		}
		InitDataProperty(0, cnt++, dtData, 1, daCenter, true, ""   	,	false, "", dfNone, 0, false, false);
		
		InitTreeInfo("tree_lvl", "sLevel", RgbColor(0,0,255), false);
	}
}

function initSheet2(sheetObj) {
	
	with (sheetObj) {
		// 높이 설정
		style.height = 370;//getSheetHeight(17);
		// 전체 너비 설정
		SheetWidth = mainTable.clientWidth;
		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		// 전체Merge 종류 [선택, Default msNone]
		MergeSheet = msPrevColumnMerge;
		// 전체Edit 허용 여부 [선택, Default false]
		Editable = false;
		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		InitRowInfo(2, 1, 9, 100);
		
		var HeadTitle1 = "Rep.\nTrade|Sub\nTrade|Lane|RHQ|OFC|Yield\nGroup|ACCT\nClass|ACCT|C.OFC|SC#|RFA#|MVC\nVol|lvl|Guided|Guided|Loading QTA|Loading QTA|";
		var HeadTitle2 = "Rep.\nTrade|Sub\nTrade|Lane|RHQ|OFC|Yield\nGroup|ACCT\nClass|ACCT|C.OFC|SC#|RFA#|MVC\nVol|lvl|TEU|Portion|TEU|%|";
		
		var headCount = ComCountHeadTitle(HeadTitle1);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(headCount, 0, 0, false);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(false, true, true, true, false, false);
		
		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);

		var cnt = 0;
		
		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "trd_cd"    	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "sub_trd_cd"	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "rlane_cd"  	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "sls_rhq_cd",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "ofc_cd"    	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cust_ctrl_cd"	,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "acct_clss"		,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 40, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "ctrt_ofc_cd"   	,	false, "", dfNone, 0, false, false);		
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "sc_no"   	,	false, "", dfNone, 0, false, false);		
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rfa_no"   	,	false, "", dfNone, 0, false, false);		
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "wk_mqc_qty" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "tree_lvl" 		,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rlane_adj_qty" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "rlane_adj_ratio" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "c_load_qta" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 80, daCenter, true, "c_load_qta_ratio" ,	false, "", dfNone, 0, false, false);
		InitDataProperty(0, cnt++, dtData, 1, daCenter, true, "" ,	false, "", dfNone, 0, false, false);
		
		InitTreeInfo("tree_lvl", "sLevel", RgbColor(0,0,255), false);
//		ShowTreeLevel(0, 1);
	}
}

/**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initTab(tabObj , tabNo) {
	var formObj  = document.form;
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt  = 0 ;
				InsertTab( cnt++ , "By OFC" , -1 );
				InsertTab( cnt++ , "By Lane" , -1 );
			}
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, quite) {

	switch (sAction) {
	case IBSEARCH: // 조회
		if(beforetab==0){
			var sheetObj = sheetObjects[0];
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			sheetObj.RemoveAll();
			var param = SpcFormString(formObj, 'ALL');
			var rtn = sheetObj.GetSearchXml("ESM_SPC_0093GS.do", "f_cmd=" + (SEARCH) + "&" + param);

			strSubTrd = getEtcDataFromXml(rtn, "str_sub_trd");
			if(strSubTrd != ""){
				initSheet1(sheetObj, strSubTrd);
			}
			sheetObj.LoadSearchXml(rtn);
			
		}else if(beforetab==1){
			var sheetObj = sheetObjects[1];
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			sheetObj.RemoveAll();
			var param = SpcFormString(formObj, 'ALL');
			var rtn = sheetObj.GetSearchXml("ESM_SPC_0093GS2.do", "f_cmd=" + (SEARCH01) + "&" + param);
			
			sheetObj.LoadSearchXml(rtn);
		}
		
		break;
		
	case IBDOWNEXCEL:
		sheetObj.Down2Excel(-1);
		break;
	}
}

/*
 * Season Sheet Combo 를 초기화 한다.
 * @param     codes
 * @param     names
 */
function initData_season(codes, names){
    var sheetObj = document.getElementById("season");
    
    with(sheetObj){
        RemoveAll();
		SetTitle("Season|Pfmc Week");
		SetColWidth("70|120");
		SetColAlign("center|left");
        MultiSelect = false;
        MaxSelect   = 1;
        DropHeight  = 190;
        
        if(codes == undefined || codes == null || codes == ""){
        	document.form.version.Code = "";
        	return;
        }
        
	    for(var i = 0 ; i < codes.length - 1 ; i++){
//	    	var txt = names[i].split("~");
	    	
	    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
	    }
	    
	    document.form.season.Index = document.form.season.GetCount()-1;
    }
}

/*
 * Season Sheet Combo 변경시 해당 Season 의 Version 을 재조회 한다.
 * @param     comObj
 * @param     value
 * @param     text
 */
function season_OnChange(comObj, value, text ){
	var obj = document.getElementById("sts");
	obj.value = "";
	
	var rtn = getCodeXmlList("SeasonVersion", "trade="+document.form.trade.Code+"&season="+comObj.Code);
	initData_version(rtn);
}

/*
 * Version Sheet Combo 변경시 해당 Version 의 Status 를 화면에 보여준다.
 * @param     comObj
 * @param     value
 * @param     text
 */
function version_OnChange(comObj, value, text ){
	var obj = document.getElementById("sts");
	if(value==""){
		obj.value = "";
	}else{
		if(text.indexOf("|")>=0){
			obj.value = text.split("|")[1];
		}else{
			obj.value = text.split(",")[1];
		}
	}
}

/*
 * Version Sheet Combo 를 초기화 한다.
 * @param     value
 */
function initData_version(value){
    var obj = document.getElementById("version");

	obj.SetTitle("Version|Status|Version Period");
	obj.SetColWidth("70|120|130");
	obj.SetColAlign("center|left|left");
    obj.DropHeight = 190;
    obj.ShowCol(0);
   		
    ComXml2ComboItem(value, obj, "code", "code|text");
    
    document.form.version.Index = document.form.version.GetCount()-1;
    
}

function trade_OnChange(comObj,value,text ){
	if(value == "") return;
	var formObj = document.form;
	//sub_trade의 초기화
	formObj.subtrade.Index2 = 0;
	//lane의 초기화
	formObj.lane.Index2 = 0;       

	SpcSearchOptionSubTrade("subtrade", "N", "N", "N", "", value);
	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,'',true);
	
	document.form.version.RemoveAll();
	var obj = document.getElementById("sts");
	obj.value = "";
	
	var rtn = getCodeList("Season", "trade="+value);
	initData_season(rtn[0].split("|"), rtn[1].split("|"));
}

function subtrade_OnChange(comObj,value,text ){  
 	var arrTrade = text.split("|");
	var formObj = document.form;
	if(arrTrade.length > 1) {
//		formObj.trade.Code2 = arrTrade[0];
		formObj.lane.Code2 = '';
	} else {
//		formObj.trade.Code2 = comObj.GetText(value,0);  
		formObj.lane.Code2 = '';
	} 
	
	// 선택된 Sub Trade에 해당하는 Lane 정보만 가져오도록 함.
	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);
	
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		var season = comObjects[0].Code;
		if (season == "") {
			ComShowMessage(getMsg("SPC90114", "Season"));
			comObjects[0].focus();
			return false;
		}
		
		var version = comObjects[1].Code;
		if (version == "") {
			ComShowMessage(getMsg("SPC90114", "Version"));
			comObjects[1].focus();
			return false;
		}
		
		if(beforetab==0){
			if(formObj.trade.Code == ""){
				ComShowMessage(getMsg("SPC90114", "Trade"));
				formObj.trade.focus();
				return false;
			}
		}
		break;
	}
	return true;
}
 
function clearAll(){
	var formObj = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	comObjects[0].Code = "";
	comObjects[1].Code = "";
	comObjects[2].Code = "";
	comObjects[3].Code = "";
	comObjects[4].Code = "";
	comObjects[5].Code = "";
	
	strSubTrd = "SUB TRADE";
	initSheet1(sheetObjects[0], strSubTrd);
	
	var formObj = document.form;
	formObj.trade.Code = "TPS";
	
	formObj.gq_view[0].checked = true;
	formObj.gq_view[0].fireEvent('onClick');
	formObj.acct_all.checked = false;
	formObj.acct_all.fireEvent('onClick');
	formObj.acct_all_2.checked = false;
	formObj.acct_all_2.fireEvent('onClick');
}

function sheet1_OnClick(sheetObj, row, col){
	var formObj = document.form;
	switch(sheetObj.ColSaveName(col)){
	
	case "acct_clss":
		var mark   = sheetObj.CellValue(row, col);
		if(mark == "+"){
			sheetObj.RowExpanded(row) = true;
			sheetObj.CellValue2(row, col) = "-";
			
			sheetObj.ColHidden("cust_lgl_eng_nm") = false;
		}
		else if(mark == "-"){
			sheetObj.RowExpanded(row) = false;
			sheetObj.CellValue2(row, col) = "+";
			
			var cnt=0; //전체 expand 기능으로 인해, 전체 펼침 이후 하나만 닫으면 ACCT 컬럼이 닫히지 않도록.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "acct_clss")=="-"){
					cnt++;
				}
			}
			if(cnt==0){
				sheetObj.ColHidden("cust_lgl_eng_nm") = true;
				sheetObj.ColHidden("ctrt_ofc_cd") = true;
				if(formObj.trade.Code == "TPS"){
					sheetObj.ColHidden("sc_no") = true;
				}
				if(formObj.trade.Code == "AES" || formObj.trade.Code == "IAS"){
					sheetObj.ColHidden("rfa_no") = true;
				}
			}
		}
		break;
		
	case "cust_lgl_eng_nm":
		var mark   = sheetObj.CellValue(row, col);
		if(mark == "+"){
			sheetObj.RowExpanded(row) = true;
			sheetObj.CellValue2(row, col) = "-";
			sheetObj.ColHidden("ctrt_ofc_cd") = false;
			if(formObj.trade.Code=="TPS"){
				sheetObj.ColHidden("sc_no") = false;
			}
			if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
				sheetObj.ColHidden("rfa_no") = false;
			}
			sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		}
		else if(mark == "-"){
			sheetObj.RowExpanded(row) = false;
			sheetObj.CellValue2(row, col) = "+";
			
			var cnt=0; //전체 expand 기능으로 인해, 전체 펼침 이후 하나만 닫으면 ACCT 컬럼이 닫히지 않도록.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="-"){
					cnt++;
				}
			}
			if(cnt==0){
				sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 40, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
				sheetObj.ColHidden("ctrt_ofc_cd") = true;
				if(formObj.trade.Code=="TPS"){
					sheetObj.ColHidden("sc_no") = true;
				}
				if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
					sheetObj.ColHidden("rfa_no") = true;
				}
			}else{
				sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
			}
		}
	}
}

function sheet2_OnClick(sheetObj, row, col){
	var formObj = document.form;
	switch(sheetObj.ColSaveName(col)){
	  	    
	case "acct_clss":
		var mark   = sheetObj.CellValue(row, col);
		if(mark == "+"){
			sheetObj.RowExpanded(row) = true;
			sheetObj.CellValue2(row, col) = "-";
			sheetObj.ColHidden("cust_lgl_eng_nm") = false;
		}
		else if(mark == "-"){
			sheetObj.RowExpanded(row) = false;
			sheetObj.CellValue2(row, col) = "+";
			
			var cnt=0; //전체 expand 기능으로 인해, 전체 펼침 이후 하나만 닫으면 ACCT 컬럼이 닫히지 않도록.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "acct_clss")=="-"){
					cnt++;
				}
			}
			if(cnt==0){
				sheetObj.ColHidden("cust_lgl_eng_nm") = true;
				sheetObj.ColHidden("ctrt_ofc_cd") = true;
				if(formObj.trade.Code=="TPS"){
					sheetObj.ColHidden("sc_no") = true;
					sheetObj.ColHidden("wk_mqc_qty") = true;
				}
				if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
					sheetObj.ColHidden("rfa_no") = true;
					sheetObj.ColHidden("wk_mqc_qty") = true;
				}
			}
		}
		break;
		
	case "cust_lgl_eng_nm":
		var mark   = sheetObj.CellValue(row, col);
		if(mark == "+"){
			sheetObj.RowExpanded(row) = true;
			sheetObj.CellValue2(row, col) = "-";
			sheetObj.ColHidden("ctrt_ofc_cd") = false;
			if(formObj.trade.Code=="TPS"){
				sheetObj.ColHidden("sc_no") = false;
				sheetObj.ColHidden("wk_mqc_qty") = false;
			}
			if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
				sheetObj.ColHidden("rfa_no") = false;
				sheetObj.ColHidden("wk_mqc_qty") = false;
			}
			sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		}
		else if(mark == "-"){
			sheetObj.RowExpanded(row) = false;
			sheetObj.CellValue2(row, col) = "+";
			
			var cnt=0; //전체 expand 기능으로 인해, 전체 펼침 이후 하나만 닫으면 ACCT 컬럼이 닫히지 않도록.
			for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
				if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="-"){
					cnt++;
				}
			}
			
			if(cnt==0){
				sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 40, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
				sheetObj.ColHidden("ctrt_ofc_cd") = true;
				if(formObj.trade.Code=="TPS"){
					sheetObj.ColHidden("sc_no") = true;
					sheetObj.ColHidden("wk_mqc_qty") = true;
				}
				if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
					sheetObj.ColHidden("rfa_no") = true;
					sheetObj.ColHidden("wk_mqc_qty") = true;
				}
			}else{
				sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
			}
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		if(!sheetObj.IsHaveChild(i)){
			sheetObj.CellValue2(i, "acct_clss")="";
		}
	}
	expandSheet1(sheetObj);
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	sheetObj.ShowTreeLevel(0, 1);
	sheetObj.ColHidden("cust_lgl_eng_nm") = true;
	sheetObj.ColHidden("sc_no") = true;
	sheetObj.ColHidden("rfa_no") = true;
	sheetObj.ColHidden("wk_mqc_qty") = true;
	
	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
		if(!sheetObj.IsHaveChild(i)){
			sheetObj.CellValue2(i, "acct_clss")="";
		}
	}
	expandSheet2(sheetObj);
}

/**
* Tab 클릭시 이벤트 관련
* 선택한 탭의 요소가 활성화 된다.
*/
function tab1_OnChange(tabObj , nItem){
	var formObj = document.form;
    var objs = document.all.item("tabLayer");
	
	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
		
	beforetab = nItem;
	
	if(beforetab==0){
		//trade 필수 처리. sub trade, lane 잠궈
//		formObj.subtrade.RemoveAll();
		formObj.subtrade.Index2 = 0;
		formObj.subtrade.Enable = false;
		formObj.lane.Index2 = 0;
		formObj.lane.Enable = false;
//		formObj.trade.BackColor = "#CCFFFD";
	}else if(beforetab==1){
		//trade 필수 아님. sub trade, lane 열어
		formObj.subtrade.Enable = true;
		formObj.lane.Enable = true;
//		formObj.trade.BackColor = "#FFFFFF";
	}
}


function getEtcDataFromXml(xml, str){
	var pos = xml.indexOf("ETC KEY=\""+str+"\"");
	if(pos < 0) return "";
	pos = xml.indexOf(">", pos + 1);
	if(pos < 0) return "";
	var epos = xml.indexOf("</ETC>", pos + 1);
	var rtn = "";
	if(epos < 0){
		rtn = xml.substring(pos + 1);
	}
	else{
		rtn = xml.substring(pos + 1, epos);
	}
	return rtn;
}

function obj_click(){
	var formObj = document.form;
	obj = event.srcElement;
	var sheetObj = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	
	switch(obj.name){
		case "gq_view":
			//loading qta hidden
			var subTrdArr = strSubTrd.split("|");
			var cnt = 0;
			if(subTrdArr.length == 0){
				cnt = 1;
			}else{
				cnt = subTrdArr.length;
			}
			for(var i = 1 ; i < cnt+1 ; i++){
				if(formObj.gq_view[0].checked){
					sheetObj.ColHidden("c_load_qta_"+i) = false;
					sheetObj.ColHidden("c_load_qta_ratio_"+i) = false;
				}else{
					sheetObj.ColHidden("c_load_qta_"+i) = true;
					sheetObj.ColHidden("c_load_qta_ratio_"+i) = true;
				}
			}
			break;
			
		case "acct_all":
			expandSheet1(sheetObj);
			break;
			
		case "acct_all_2":
			expandSheet2(sheetObj2);
			break;
	}
}

function expandSheet1(sheetObj){
	var formObj = document.form;
	if(formObj.acct_all.checked){
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "acct_clss")=="+"){
				sheetObj.CellValue(i, "acct_clss")="-";
			}
			if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="+"){
				sheetObj.CellValue(i, "cust_lgl_eng_nm")="-";
			}
		}
		sheetObj.ShowTreeLevel(-1,2);
		sheetObj.ColHidden("cust_lgl_eng_nm") = false;
		sheetObj.ColHidden("ctrt_ofc_cd") = false;
		if(formObj.trade.Code=="TPS"){
			sheetObj.ColHidden("sc_no") = false;
		}
		if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
			sheetObj.ColHidden("rfa_no") = false;
		}
		sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		
	}else{
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "acct_clss")=="-"){
				sheetObj.CellValue(i, "acct_clss")="+";
			}
			if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="-"){
				sheetObj.CellValue(i, "cust_lgl_eng_nm")="+";
			}
		}
		sheetObj.ShowTreeLevel(0,1);
		sheetObj.ColHidden("cust_lgl_eng_nm") = true;
		sheetObj.ColHidden("ctrt_ofc_cd") = true;
		if(formObj.trade.Code=="TPS"){
			sheetObj.ColHidden("sc_no") = true;
		}
		if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
			sheetObj.ColHidden("rfa_no") = true;
		}
		sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 40, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
	}
}

function expandSheet2(sheetObj){
	var formObj = document.form;
	if(formObj.acct_all_2.checked){
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "acct_clss")=="+"){
				sheetObj.CellValue(i, "acct_clss")="-";
			}
			if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="+"){
				sheetObj.CellValue(i, "cust_lgl_eng_nm")="-";
			}
		}
		sheetObj.ShowTreeLevel(-1,2);
		sheetObj.ColHidden("cust_lgl_eng_nm") = false;
		sheetObj.ColHidden("ctrt_ofc_cd") = false;
		if(formObj.trade.Code=="TPS"){
			sheetObj.ColHidden("sc_no") = false;
			sheetObj.ColHidden("wk_mqc_qty") = false;
		}
		if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
			sheetObj.ColHidden("rfa_no") = false;
			sheetObj.ColHidden("wk_mqc_qty") = false;
		}
		sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 200, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
		
	}else{
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "acct_clss")=="-"){
				sheetObj.CellValue(i, "acct_clss")="+";
			}
			if(sheetObj.CellValue(i, "cust_lgl_eng_nm")=="-"){
				sheetObj.CellValue(i, "cust_lgl_eng_nm")="+";
			}
		}
		sheetObj.ShowTreeLevel(0,1);
		sheetObj.ColHidden("cust_lgl_eng_nm") = true;
		sheetObj.ColHidden("ctrt_ofc_cd") = true;
		if(formObj.trade.Code=="TPS"){
			sheetObj.ColHidden("sc_no") = true;
			sheetObj.ColHidden("wk_mqc_qty") = true;
		}
		if(formObj.trade.Code=="AES" || formObj.trade.Code == "IAS"){
			sheetObj.ColHidden("rfa_no") = true;
			sheetObj.ColHidden("wk_mqc_qty") = true;
		}
		sheetObj.InitDataProperty(0, sheetObj.SaveNameCol("cust_lgl_eng_nm"), dtData, 40, daLeft, true, "cust_lgl_eng_nm",	false, "", dfNone, 0, false, false);
	}
}

function enter(){
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if(keyValue != 13) return;
	if(beforetab==0){ 
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}else if(beforetab==1){
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
	}
}
/* 개발자 작업  끝 */