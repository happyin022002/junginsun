/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : VOP_VSK_0030.js
 *@FileTitle : Drewry Vessel On-Time Report
 *Open Issues :
 *Change history : 2016.02.19
 *@LastModifyDate : 2016.02.19 
 *@LastModifier : 임예지
 *@LastVersion : 1.0
 *2016.02.19 임예지
 * 1.0 Creation
=========================================================*/


/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/**
 * @extends
 * @class VOP_VSK_0030 : VOP_VSK_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0030() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initCombo 			= initCombo;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.validateForm 		= validateForm;
}

/* 개발자 작업 */
// 현재 포커스를 가지고 있는 객체명 변수
var focusObj 		= null; 
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var tmpExit 		= 0;
var grd_vvd 		= "";
var backValue 		= null;

//User_Condition Tab Setting  
var delayConData = null;
var skipConData = null;
var skipChangeConData = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

			case "btns_search1":
				openLandCdHelp(sheetObject1);
				break;
			
			case "btns_search2":
				openPortCdHelp(sheetObject1,"F");
				break;
			
			case "btns_search3":
				openPortCdHelp(sheetObject1,"T");
				break;
			
			case "btn_Retrieve":			
				if(checkPeriod(formObj)){
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
				}else{
					ComShowCodeMessage("VSK00105", "1 year");
				}
				break;
				
			case "btn_Save":
				var updCnt = 0;
				for(var i = sheetObject1.HeaderRows; i <= sheetObject1.LastRow ; i++ ){
					if( sheetObject1.CellValue(i, "ibflag") == "U" && sheetObject1.CellValue(i, "del_flag") == "0"){
						updCnt++;
					}
				}
				
				if(updCnt > 0){
					if(ComShowCodeConfirm('COM12147', 'data')){
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
					}
				}else{
					ComShowCodeMessage("VSK00012", '');
				}
				break;
				
			case "btn_Delete":
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
				break;
	
			case "btn_New":
				doNew();
				
				break;
	
			case "btn_PortSetUp":
				openPortSettingPop();
				break;
				
			case "btn_TradeSetUp":
				openTradeSettingPop();
				break;
				
			case "btns_calendar_s":
	        	var cal = new ComCalendar();
	        	cal.setDisplayType('month');
	        	cal.select(formObj.drw_fm_dt, "yyyy-MM");
	        	break;
	        case "btns_calendar_e":
	        	var cal = new ComCalendar();
	        	cal.setDisplayType('month');
	        	cal.select(formObj.drw_to_dt, "yyyy-MM");
	        	break;	
	        case "btn_DownExcel":
	        	if(sheetObjects[0].SearchRows>0){
					ComOpenWait(true);
					sheetObjects[0].Down2Excel(-1, true, true, true, "", "", false, false, "Drewry Vessel On-Time Report", true, "", "", false, false, "");
					ComOpenWait(false);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
	formObj.drw_opt.value = 24;
	
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	comboObjects[0].Code = "ALL";
	comboObjects[1].Code = "ALL";

	initControl();
	
}

function initCombo(comboObj, comboNo) {
	var formObj = document.form;
	
	switch(comboObj.id) { 
		case "drw_pol_cd": 
			with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left");        
				DropHeight = 160;
		   	}
			break;
			
		case "drw_pod_cd": 
			with (comboObj) { 
				MultiSelect = false;
				UseAutoComplete = true;	
				SetColAlign("left");        
				DropHeight = 160;
		   	}
			break;
	}
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
			style.height = 350;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet =  msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 8, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// InitHeadMode(true, true, false, true, false, false)
			InitHeadMode(false, false, true, false, false, false)

			//SelectionMode = smSelectionList;
			
			var HeadTitle1 = "||Port Pair|Port Pair|Port Pair|Port Pair|Port Pair|Port Pair|Port Pair|Port Pair|LANE|VVD|Carrier|Design\n TEU|POL|POL|POD|POD|POD|POD|Result|Result|Status|Saved\nMonth";
			var HeadTitle2 = "||POL|POL|POL|POL|POD|POD|POD|POD|LANE|VVD|Carrier|Design\n TEU|ATD|Creation\nDate|ETA|ETB|ATA|ATB|Delay\n(hrs)|On-\nTime|Status|Saved\nMonth";
			
			
			
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);


			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			
			var Rowcnt = 0;
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(Rowcnt, cnt++, dtHiddenStatus, 50, 	daCenter, true,		"ibflag");		
			InitDataProperty(Rowcnt, cnt++, dtCheckBox,		20,		daCenter, true,		"del_flag");
 			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"pol_cd",				false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pol_yd_cd",			false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pol_clpt_ind_seq",		false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pol_clpt_seq",			false, "", dfNone, 0, false, 	false);

			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"pod_cd",				false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pod_yd_cd",			false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pod_clpt_ind_seq",		false, "", dfNone, 0, false, 	false);
 			InitDataProperty(Rowcnt, cnt++, dtHidden, 		50, 	daCenter, true, 	"pod_clpt_seq",			false, "", dfNone, 0, false, 	false);
 			
			InitDataProperty(Rowcnt, cnt++, dtData, 		40, 	daCenter, true, 	"slan_cd",				false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		75, 	daCenter, true, 	"vvd",					false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"crr_cd",				false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"teu",					false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pol_act_dep_dt",		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pol_act_atd_inp_dt",	false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pod_vps_eta_dt",		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pod_vps_etb_dt",		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pod_act_arr_dt",		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		100, 	daCenter, true, 	"pod_act_brth_dt",		false, "", dfUserFormat2, 0, false, false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"delay",				false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		50, 	daCenter, true, 	"ontime",				false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtHidden, 		0, 		daCenter, true, 	"opt",					false, "", dfNone, 0, false, 	false);
			InitDataProperty(Rowcnt, cnt++, dtData, 		80, 	daCenter, true, 	"drw_inp_yrmon",		false, "", dfUserFormat2, 0, false, 	false);

		
			InitUserFormat2(0, "pol_act_dep_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "pol_act_atd_inp_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "pod_vps_eta_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "pod_vps_etb_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "pod_act_arr_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "pod_act_brth_dt", "####-##-## ##:##", "-|:" );
			InitUserFormat2(0, "drw_inp_yrmon", "####-##", "-" );

			SelectHighLight = false;
			EditableColorDiff = false;

			

		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg 		= false;
	sheetObj.WaitImageVisible 	= false;
	
	switch (sAction) {
	
	case IBSEARCH: // 조회
		//alert(IBSEARCH);
		formObj.f_cmd.value 		= SEARCH;
		var sParam 					= FormQueryString(formObj);
		ComOpenWait(true);
		//alert('ComOpenWait');
		var sXml 					= sheetObj.GetSearchXml("VOP_VSK_0030GS.do", sParam);
		//alert('ComOpenWait');
		
		
//		sheetObj.CheckAll("del_flag") = 0;
		ComOpenWait(false);
				
		sheetObj.LoadSearchXml(sXml);
		 
		break;
		
	case COMMAND01: //Drewry Target Port combo
		formObj.f_cmd.value = SEARCH01;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0030GS.do", sParam);

		var polCdArr	= ("ALL|"+ComGetEtcData(sXml, "port_cd")).split("|");	
		var polDescArr	= ("ALL|"+ComGetEtcData(sXml, "port_cd")).split("|");	
		
		appendMultiComboItem(getComboObject("drw_pol_cd"), polCdArr, polDescArr, "", "DEF");
		appendMultiComboItem(getComboObject("drw_pod_cd"), polCdArr, polDescArr, "", "DEF");

		break;
		
	case SEARCH01: // lane Code 조회
		formObj.f_cmd.value = COMMAND12;
		var sParam = FormQueryString(formObj);
		sParam = sParam + "&vsl_slan_cd=" + formObj.slan_cd.value; 
		ComOpenWait(true);
		
		var laneCd = document.form.slan_cd.value
		var sXml = sheetObj.getSearchXml("VSK_GLOGS.do", sParam);
		var checkLane = ComGetEtcData(sXml, "checkLane");
		ComOpenWait(false);
		if(checkLane == undefined){
			  sheetObj.LoadSearchXml(sXml);
			  formObj.slan_cd.value = "";	
			  formObj.slan_cd.focus();
		  }else{
			  var vslSlanNm = ComGetEtcData(sXml, "checkLane").split("|");
			
			  if(vslSlanNm == ""){
				  ComShowCodeMessage('VSK00021', formObj.slan_cd.value);
				  formObj.slan_cd.value = "";	
				  formObj.slan_cd.focus();
			  }
		  }
		break;		
		
		
	case IBSAVE: // 저장
		formObj.f_cmd.value = MULTI;
		var updCnt = 0;
		for(var i = sheetObj.HeaderRows; i <= sheetObj.LastRow ; i++ ){
			if( sheetObj.CellValue(i, "ibflag") == "U"){
				updCnt++;
			}
		}
		if(updCnt > 0){
			var sParam = "f_cmd=" + MULTI + "&" + ComGetSaveString(sheetObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_0030GS.do", sParam);
			ComOpenWait(false);
			
			if(!VskGetErrorXml(sXml)){
				ComShowCodeMessage('COM130102', 'Data');
				btn_Retrieve.fireEvent("onclick");
			}else{
				sheetObj.LoadSaveXml(sXml);
			}
		}
		break;
		
	case IBDELETE: // 삭제
		formObj.f_cmd.value = REMOVE;
	
		if(!ComShowCodeConfirm("VSK00005")){
			return false;
		}
		
		var delCnt = 0;
		var sParam = FormQueryString(formObj);
		
		for( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow ; i++ ){
			if( sheetObj.CellValue( i, "del_flag") == "1"){
				sheetObj.CellValue2(i, "ibflag") = "D";
				delCnt++;
			}else{
				sheetObj.CellValue2(i, "ibflag") = ""; 
			}
		}
		
		if( delCnt > 0 ){
			ComOpenWait(true); 
			alert(ComGetSaveString(sheetObj));

			var sXml = sheetObj.GetSaveXml("VOP_VSK_0030GS.do", sParam +"&" + ComGetSaveString(sheetObj) );

			ComOpenWait(false);

			if(!VskGetErrorXml(sXml)){
				ComShowCodeMessage('COM12167', 'Data');
				btn_Retrieve.fireEvent("onclick");
			}else{
				sheetObj.LoadSaveXml(sXml);	
			}
		}else{
			ComShowCodeMessage('VSK00021' , 'Saved data');
			btn_Retrieve.fireEvent("onclick");
		}
		delCnt = 0;
		break;
	
	}
}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}


function skd_dir_cd_OnKeyDown(comboObj, KeyCode, Shift){
	if(KeyCode == 13){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}
}

/**
 * Direction Combo를 Setting.
 * @return
 */
function setDirectionCombo(){
	var sheetObj = sheetObjects[0];
	var prefix = sheetObj.id + "_";
	var sXml = doActionIBSheet(sheetObj, document.form, SEARCH02);
	
	var sDirCd = "ALL|"+ComGetEtcData(sXml, "direction_cd");
	var dirCdArr = sDirCd.split("|");
	
	appendMultiComboItem(getComboObject("skd_dir_cd"), dirCdArr, dirCdArr, "ALL");
}


/**
 * Combo 값을 가져온다.
 */
function getComboObject(comboId){
	var cnt = comboObjects.length;
	if(cnt > 0){
		for(var i=0; i<cnt; i++){
			if(comboObjects[i].id == comboId){
				return comboObjects[i];
			}
		}
	}
	return null;
}

/**
 * Mutil Combo에 item을 추가한다.
 * @param comboObj
 * @param optionCds
 * @param optionTxts
 * @param selCode
 * @return
 */
function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
	comboObj.RemoveAll();
	if(optionCdArr != null){
		if(sFlag == "DEF"){
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}else{
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
			}
		}
		comboObj.Code2 = selCode;
	}
}


/**
 * 이벤트 컨드롤 정의
 */
function initControl(){
	var formObj = document.form;
    axon_event.addListenerForm("keypress", "obj_keypress", formObj);
    axon_event.addListenerForm("blur", "obj_blur", formObj);
    axon_event.addListenerForm("focus", "obj_activate", formObj);
    axon_event.addListenerForm("keyup", "obj_keyup", formObj);
    
    axon_event.addListenerForm("keypress", "enter_keypress", formObj);	//Enter키 처리
    axon_event.addListenerForm("keyup", "VskKeyFocus", formObj);		// 자동포커스																		
   
    setToday(document.form.drw_fm_dt, "ym");//올해 설정
	setToday(document.form.drw_to_dt, "ym");//올해 설정

}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

function obj_change(){
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;
	
	switch(event.srcElement.name){
		case "drw_fm_dt":
		case "drw_to_dt":
			sheetObjects[0].RemoveAll();
			break;
			
		default:
			break;
	}	
}


function obj_keypress(){
	var srcName = event.srcElement.name;
	switch(event.srcElement.name){
   	   case "drw_slan_cd":
	    	ComKeyOnlyAlphabet('uppernum');
			break;
			
	}
}
 
function obj_keyup(){
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;
			
	switch (event.srcElement.name) {
		case "drw_slan_cd":
			if(val==""){
				doNew();
				break;
			}
			
			if(!obj || val=="" || ComChkLen(val, 3)!=2){
				break;
			} else {
				sheetObj = sheetObjects[0];
				doActionIBSheet(sheetObj, formObj, SEARCH01);
			}
			break;
	}
}

/**
 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
 */
function obj_activate() {
	
	if(event.srcElement.name){
		focusObj = event.srcElement.name;
	}else{
		focusObj = "";
	}
	
	// 마스크구분자 없애기
	switch (event.srcElement.name) {
		case "drw_fm_dt":
		case "drw_to_dt":
			ComClearSeparator(event.srcElement);
			break;	
	}
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
 

/**
 * onBlur처리 
 * @return
 */
function obj_blur(){

	 var formObj = document.form;
  	 obj = event.srcElement;      	
  	 
  	 with(formObj){
  		 if(obj.name=="drw_fm_dt" || obj.name=="drw_to_dt"){
  			 var creDtFr = ComReplaceStr(drw_fm_dt.value,"-","");
  			 var creDtTo = ComReplaceStr(drw_to_dt.value,"-","");
  			 
  			 switch(obj.name) {
	    	    	case "drw_fm_dt":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				formObj.drw_fm_dt.value='';
	    	    				formObj.drw_fm_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.drw_fm_dt.value = ComGetMaskedValue(formObj.drw_fm_dt.value, "ym");
	    	            break;
	    	            
	    	    	case "drw_to_dt":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				formObj.drw_to_dt.value='';
	    	    				formObj.drw_to_dt.focus();
	    	    				return false;
	    	    			}
	    	    		}
	    	    		formObj.drw_to_dt.value = ComGetMaskedValue(formObj.drw_to_dt.value, "ym");
	    	           	break;	
	        	}
  			 
  		 	}
      }
      return true;	
} 

/**
 * Drewry Port LIST Setup  
 */
function openPortSettingPop(){
	 var formObj = document.form;
	 var targetObjList = "";
	 var v_display = "0,0";
	
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0031.do?', 845, 490, targetObjList, v_display, true);
	
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	comboObjects[0].Code = "ALL";
	comboObjects[1].Code = "ALL";
}

/**
 * Drewry Trade LIST Setup  
 */
function openTradeSettingPop(){
	 var targetObjList = "";
	 var v_display = "0,0";
	
//		ComOpenPopupWithTarget('/hanjin/VOP_VSK_0034.do?', 550, 420, targetObjList, v_display, true);
}


/**
 * Lane Code Help 파일을 오픈한다
 */  
function openLandCdHelp(sheetObj){
   var targetObjList = "sheet1_vsl_slan_cd:drw_slan_cd";
   var v_display = "0,0";
   var laneCd = document.form.drw_slan_cd.value;
	ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
} 


/**
 * Port Code Help 파일을 오픈한다
 */  
 function openPortCdHelp(sheetObj , val ){
	  var formObj = document.form;
	  var port_cd = "";
	  
	  if( val == "F" ){
		  port_cd = formObj.fm_pol_cd.value;
	  }else{
		  port_cd = formObj.to_pod_cd.value;
	  }
	  var sUrl = "/hanjin/VOP_VSK_0043.do?port_cd="+port_cd;
	  var rVal = ComOpenPopupWithTarget(sUrl, 428, 520, "", "0,0", true);
	  if(rVal){
		  if( val == "F" ){
			  formObj.fm_pol_cd.value = rVal;
		  }else{
			  formObj.to_pod_cd.value = rVal;
		  }
		  
	  }
 }   

function sheet1_OnSearchEnd(sheetObj, ErrMSg) {
	
	var formObj 	= document.form;
		
	var firstRow 	= 0;
	var endRow 		= 0;
	var delay		= 0;
	var option 	    = Number(formObj.drw_opt.value);
	
	var tot 		= 0;
	var tot_ontime	= 0;
	var tot_delay	= 0;
	var tot_skip	= 0;
	
	var avg = 0;
	with(sheetObj){
		// 데이터가 있으면...
		if(RowCount > 0){

			firstRow 	= HeaderRows;
			endRow 		= HeaderRows + RowCount - 1;
			//Redraw 		= false;

			for (var i=firstRow; i<=endRow; i++){
				if(sheetObj.CellValue( i , "pod_act_arr_dt")  != "" ){
					var act_arr = getDate(sheetObj.CellValue( i , "pod_act_arr_dt"));
					var eta_dt = getDate(sheetObj.CellValue( i , "pod_vps_eta_dt"));
					//Math.round( (act_arr - eta_dt) / (1000 * 60 * 60.0) );
					delay = Math.round( (act_arr - eta_dt) / (1000 * 60 * 60.0) );
					sheetObj.CellValue2( i , "delay" ) = delay;
					avg = avg + delay;
					
					if( Math.abs( delay ) >=  option ){
						sheetObj.CellValue2( i , "ontime" ) = "Delay";
						tot_delay++;
						
					}else{
						sheetObj.CellValue2( i , "ontime" ) = "On";
						tot_ontime++;
					}
				}else{
					if( sheetObj.CellValue( i , "opt") == "S"){
						sheetObj.CellValue2( i , "ontime" ) = "Skip";
						
						tot_skip++;
					}
				}
				
				
			}    
			
			tot = RowCount - tot_skip;
			
			formObj.tot.value = tot;
			formObj.tot_ontime.value = tot_ontime;
			formObj.tot_delay.value = tot_delay;
			formObj.tot_skip.value = tot_skip;
			formObj.tot_ratio.value = Math.round(tot_ontime/tot * 1000)/10 + '%';
			formObj.tot_avg.value = Math.round(Math.abs(avg/tot)*10)/10;
			
		}else{
		}
	}
}

function getDate(str){
	var date 	= null;
	var year 	= str.substring(0, 4);
	var month 	= ComParseInt(str.substring(4, 6)) - 1;
	var day 	= str.substring(6, 8);
	var hour 	= str.substring(8, 10);
	var minute 	= str.substring(10, 12);
	date 		= new Date(year, month, day, hour, minute);
	return date;
}

 /**
  * 두 날짜를 비교한다.
  * srcDate1 == srcDate2 이면 0
  * srcDate1 > srcDate2 이면 -1
  * srcDate1 < srcDate2 이면 1 
  */
  function compareDate(srcDate1, srcDate2){
		var date1 = getDate(srcDate1);
		var date2 = getDate(srcDate2);
		if(date2-date1>0){
			return 1;
		}else if(date2-date1<0){
			return -1;
		}else{
			return 0;
		}
	}
 
  
  /**
   * 두 날짜를 비교한다.
   * srcDate1 == srcDate2 이면 0
   * srcDate1 > srcDate2 이면 -1
   * srcDate1 < srcDate2 이면 1 
   */
  function compareDate1 (srcDate1, srcDate2){
  	var date1 = getDate(srcDate1);
  	var date2 = getDate(srcDate2);
  	var rtn = 1;
    if (srcDate1 == ""|| srcDate2 == "") {
    	rtn = 2;
    } else {
     	if(date2 > date1 ){
     		if ( Math.floor( (date2 - date1) / (1000 * 60 * 60.0) )  >= 24 ) {
    			rtn = 1; 
    		} else {
    			rtn = 0;
    		}
      		
      	}else if(date2 < date1){
      		
      		//on-time 기준변경::2013-03-29 -48~<ON-TIME<+24 ==> -24~<ON-TIME<+24
    		if ( Math.floor( (date1 - date2) / (1000 * 60 * 60.0) )  >= 24 ) {
    			rtn = 1; 
    		} else {
    			rtn = 0;
    		}
      	}else{
      		rtn = 0;
      	}   	
    }
    return rtn;	
    
  }

 
/**
 * 두 날짜가 같은 날(YYYY-MM-DD)인지 비교한다.
 * 같은 날이면 true 반환
 * 다른 날이면 false 반환
 */
function isSameDate(srcDate1, srcDate2){
	srcDate1 = srcDate1.substring(0, 8)+"0000";
	srcDate2 = srcDate2.substring(0, 8)+"0000";
	var date1 = getDate(srcDate1);
	var date2 = getDate(srcDate2);
	if(date2-date1==0){
		return true;
	}else{
		return false;
	}
}



/**
* 초기화   
*/
function doNew(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	setToday(document.form.drw_fm_dt, "ym");//올해 설정
	setToday(document.form.drw_to_dt, "ym");//올해 설정

	formObj.drw_pol_cd.value = "";
	formObj.drw_pod_cd.value = "";
	formObj.drw_crr_cd.value = "A";
	formObj.drw_teu.value = "";
	formObj.drw_opt.value = "";
	formObj.tot.value = "";
	formObj.tot_ontime.value = "";
	formObj.tot_delay.value = "";
	formObj.tot_skip.value = "";
	formObj.tot_ratio.value = "";
	formObj.tot_avg.value = "";
	formObj.drw_slan_cd.value = "";
	
	sheetObj.RemoveAll();
	
	doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
	comboObjects[0].Code = "ALL";
	comboObjects[1].Code = "ALL";
}



function checkPeriod(formObj){
	var fmDt = ComReplaceStr(formObj.drw_fm_dt.value, "-", "");
	var toDt = ComReplaceStr(formObj.drw_to_dt.value, "-", "");
	
	fmDt = fmDt + "01";
	toDt = toDt + ComGetLastDay(toDt.substring(0, 4).parseInt(), toDt.substring(4, 6).parseInt());
	
	var tmpDt = ComGetDateAdd(fmDt, "Y", 1);
	if(ComChkPeriod(toDt, tmpDt)==1){
		return true;
	}else{
		return false;
	}
}

//Event 

