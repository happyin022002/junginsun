/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : VOP_VSK_0012.js
 *@FileTitle : Long Range SKD  Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.12.26
 *@LastModifier : 이혜민	
 *@LastVersion : 1.0
 * 2009.07.01 유혁
 * 1.0 Creation
 *
 * History
 * 2010.09.09 유혁 CHM-201005742-01 Non-Weekly P/F SKD 생성과 관련한 LRS 조회
 * 2010.12.27 진마리아 CHM-201007036 Down Excel Format 변경 요청건
 * 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
 * 2011.08.19 진마리아 CHM-201111568-01 [VOP-VSK] LRS SKD inquiry 화면 및 로직 수정 요청건
 * 2012.12.26 이혜민   CHM-201221990-01 [VOP-VSK] LRS inquiry remark 변경 요청
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


/* Update History
 * 
 * 2010.06.22 
 * onpropertychange 이벤트 추가 : btns_calender1, btns_calendar2를 클릭하여 날짜를 변경하는 경우 년도와 분기가 변경되도록 수정
 * 
 */

/**
 * @extends
 * @class LRS Creation : LRS Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0012() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject 	= setSheetObject;
	this.loadPage 			= loadPage;
	this.initSheet 			= initSheet;
	this.initControl 		= initControl;
	this.doActionIBSheet 	= doActionIBSheet;
	this.setTabObject 		= setTabObject;
	this.validateForm 		= validateForm;
}

/* 개발자 작업 */
var Map = function()
{
    var mapVal  = {};    // private
    var pos     = new Array();

    this.get = function( key )
    {
        return mapVal[ key ];
    }

    this.getPos = function( n )
    {
        return mapVal[ pos[n] ];
    }

    this.remove = function( n )
    {
    	var oldSize = pos.length;
        var ary = new Array();
        for( var i=0; i<oldSize; i++ )
        {
            if( i != n )
            {
                ary.push( pos[i] );
            }
        }
        pos = ary;
    }

    this.put = function( key, val )
    {
        mapVal[key] = val;

        var flg = true;
        for( var i=0; i<pos.length; i++ )
        {
            if( key == pos[i] )
                flg = false;
        }

        if( flg )
            pos.push( key );
    }

    this.size = function()
    {
        return pos.length;
    }
    
    this.exist = function( key )
    {
    	var idx = -1;
    	for(var i=0; i<pos.length; i++){
    		if(key == pos[i]){
    			idx = i;
    			break;
    		}
    	}
    	return idx;
    }
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var arrXml = new Array();
var searchComplete;
var subGridHeight;

var vvdMap = new Map();

var slanObj1;
var slanObj2;

var vslEngNmEtcData = "";
var portNMEtcData = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject1 = sheetObjects[0];
//	var sheetObject1 = sheetObjects[1];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btns_search1":	// Lane Code 조회
			var sUrl = "/hanjin/VOP_VSK_0202.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 428, 470,
					"sheet1_vsl_slan_cd:vsl_slan_cd_1", "0,0", true);
			break;
			
		case "btns_search2": // Vessel Code 조회
			var sUrl = "/hanjin/VOP_VSK_0219.do?vsl_cd=" + formObj.vsl_cd.value + "&inc_del_vsl_pop=Y";
			var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
			if(rVal){
				formObj.vsl_cd.value = rVal;
				formObj.vsl_cd.fireEvent("ondeactivate");
			}
			break;

		case "btns_back1":
			with(formObj) {
				start_year.value = parseInt(start_year.value) - 1;
				start_date.value = ComGetMaskedValue(startQuarterDay(start_year.value, start_qt.value), "ymd");
				start_date.blur();
			}
			break;

		case "btns_next1":
			with(formObj) {
				// start_year가 증가될때, end_year가 같이 증가되어야 하는 경우
				// start_date가 end_date보다 미래의 경우
				start_year.value = parseInt(start_year.value)+1;
    			start_date.value = ComGetMaskedValue(startQuarterDay(start_year.value,start_qt.value), "ymd");
    			
				if(start_date.value > end_date.value){
					end_year.value = parseInt(end_year.value)+1;
        			end_date.value = ComGetMaskedValue(endQuarterDay(end_year.value, end_qt.value), "ymd");
				}
			}
			break;

		case "btns_back2":
			with(formObj){
				// end_year가 감소될때, start_year가 같이 감소되어야 하는 경우
				// end_date가 start_date보다 과거의 경우
				end_year.value = parseInt(end_year.value)-1;
    			end_date.value = ComGetMaskedValue(endQuarterDay(end_year.value,end_qt.value), "ymd");
    			
				if(end_date.value < start_date.value){
					start_year.value = parseInt(start_year.value)-1;
        			start_date.value = ComGetMaskedValue(startQuarterDay(start_year.value,start_qt.value), "ymd");
				}
			}
			break;

		case "btns_next2":
			with(formObj) {
				end_year.value = parseInt(end_year.value) + 1;
				end_date.value = ComGetMaskedValue(endQuarterDay(end_year.value,end_qt.value), "ymd");
			}
			break;

		case "btns_calendar1":
			var cal = new ComCalendar();
			cal.select(formObj.start_date, 'yyyy-MM-dd');

			break;

		case "btns_calendar2":
			var cal = new ComCalendar();
			cal.select(formObj.end_date, 'yyyy-MM-dd');

			break;

		case "btn_Retrieve":
			
			/* date format validation check logic ::2013-04-23 */
			var start_date 	= formObj.start_date.value;
			var end_date 	= formObj.end_date.value;
			if(!ComIsDate(start_date))	return;
			if(!ComIsDate(end_date))	return;
			////////////////////////////////////////////////////
			if(ComChkPeriod(start_date, end_date) != 1)	return;
            ////////////////////////////////////////////////////
			
			if(checkPeriod(formObj)){
				if(slanObj1.style.display=="block" && formObj.vsl_slan_cd_1.value==""){
					doActionIBSheet(sheetObject1, formObj, SEARCH03);
				}else{
					doActionIBSheet(sheetObject1, formObj, SEARCH02);
				}
			}else{
				ComShowCodeMessage("VSK00105", "1 year");
			}
			break;

		case "btn_New":
			slanObj1.style.display = "block";
			slanObj2.style.display = "none";
			
			with (formObj) {
				vsl_slan_cd.value = "";
				vsl_slan_cd_1.value = "";
				tmp_vsl_slan_cd.value = "";

				setCurrentPeriod();
				
				vsl_cd.value = "";
				tmp_vsl_cd.value = "";
				cre_dt.value = "";
				cre_usr_id.value = "";
				upd_dt.value = "";
				upd_usr_id.valur = "";
				
				vsl_slan_cd_1.focus();
			}
			
			vslEngNmEtcData = "";
			portNmEtcData = "";
			
			deleteSheet();
			break;
			
		case "btn_EMail":
			
			var sheetDiv = document.getElementById("sheet_div");
			var iframes = sheetDiv.getElementsByTagName("iframe");
			
			if(iframes.length>0){
				formObj.com_subject.value = "Long Range SKD Inquiry [" + formObj.vsl_slan_cd.value + "]";
		    	formObj.com_content.value = "Lane : " + formObj.vsl_slan_cd.value;
		    	formObj.com_content.value += "<br>Period : From " + formObj.start_date.value + " To " + formObj.end_date.value;
				ComSendMailModal();
			}
			break;

		case "btn_DownExcel":
			
			for(var i=0; i<arrXml.length-1; i++){
				if(i==0){
					document.frames[i].Down2Excel(-1, false);
				}else{
					document.frames[i].Down2Excel(-1, true);
				}
			}
			
			if(sheetObjects[0].SearchRows>0){
				ComOpenWait(true);
				sheetObjects[0].Down2Excel(-1, true, true, true, "", "", false, false, "Remark", true, "", "", false, false, "");
				ComOpenWait(false);
			}
			
			if(sheetObjects[1].SearchRows>0){
				ComOpenWait(true);
				sheetObjects[1].Down2Excel(-1, true, true, true, "", "", false, false, "Vessel&Port Code", true, "", "", false, false, "");
				ComOpenWait(false);
			}
			
			if(sheetObjects[2].SearchRows>0){
				ComOpenWait(true);
				sheetObjects[2].Down2Excel(-1, true, false, true, "", "", false, false, "", true, "", "", false, false, "");
				ComOpenWait(false);
			}
			
			break;
			
		case "btn_OK":
			
			var vvdArr = new Array();
			for(var i=0; i<vvdMap.size(); i++){
				vvdArr.push(vvdMap.getPos(i));
			}
			window.returnValue = vvdArr;
			window.close();
			break;
			
		case "btn_Close":
			window.close();
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {

	var formObj = document.form;
	
	/////////////////////////////////////////////////////////
	if("Y"==formObj.pop_yn.value){
		//팝업버튼영역 보이기
		document.all.popLayer.style.display = "";
	}
	/////////////////////////////////////////////////////////
	
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i]);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initControl();

	setCurrentPeriod();
	
	formObj.vsl_slan_cd_1.select();
	slanObj1 = document.getElementById("span_vsl_slan_cd_1");
	slanObj2 = document.getElementById("span_vsl_slan_cd_2");
	initVslSlanCd("1");
}

function initPage(){
	var formObj = document.form;
	formObj.cre_dt.value = '';
	formObj.cre_usr_id.value = '';
	formObj.upd_dt.value = '';
	formObj.upd_usr_id.value = '';
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj) {

	var cnt = 0;
	var sheetId = sheetObj.id;
	
	switch (sheetId) {
	case "sheet1": // Remark Grid
		with(sheetObj) {
			
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
			//InitRowInfo(4, 1, 3, 100);
			InitRowInfo(1, 1, 1, 100);
			
			var HeadTitle = "Remark(s)|Remark(s)|Remark(s)";
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(headCount, 4, 0, true);
			InitColumnInfo(headCount, 0, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,     	40,	daCenterTop,	true,			"",					false,	"",		dfNone,				0,			false, 	false);
			InitDataProperty(0, cnt++ , dtData,     	80,	daCenterTop,	true,			"VVD",				false,	"",		dfNone,				0,			false, 	false);
			InitDataProperty(0, cnt++ , dtData,			40,	daLeft,		true,			"RMK",				false,	"",		dfNone,				0,			false, 	false);
			WaitImageVisible = false;

		}
		break;
		
	case "sheet2": // Vessel Names
		with(sheetObj) {
			
			tabIndex = -1;
			
			// 높이 설정
			style.height = 0;
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
			//InitRowInfo(4, 1, 3, 100);
			InitRowInfo(1, 1, 1, 100);
			
			var HeadTitle = "|";
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(headCount, 4, 0, true);
			InitColumnInfo(headCount, 0, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,     80,	daCenter,	true,			"vsl_cd",		false,	"",		dfNone,				0,			false, 	false);
			InitDataProperty(0, cnt++ , dtData,		80,	daLeft,		true,			"vsl_eng_nm",	false,	"",		dfNone,				0,			false, 	false);
			
			WaitImageVisible = false;
		}
		break;
		
	case "sheet3": // Port Names
		with(sheetObj) {
			
			tabIndex = -1;
			
			// 높이 설정
			style.height = 0;
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
			//InitRowInfo(4, 1, 3, 100);
			InitRowInfo(1, 1, 1, 100);
			
			var HeadTitle = "|";
			var headCount = ComCountHeadTitle(HeadTitle);
			
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(headCount, 4, 0, true);
			InitColumnInfo(headCount, 0, 0, false);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, false, false, false, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,     	80,	daCenter,	true,			"port_cd",	false,	"",		dfNone,				0,			false, 	false);
			InitDataProperty(0, cnt++ , dtData,     	80,	daLeft,	true,			"port_nm",	false,	"",		dfNone,				0,			false, 	false);
			
			WaitImageVisible = false;
		}
		break;
		
	}
}

// 이벤트 등록
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
	axon_event.addListenerForm("focus", "obj_focus", formObj);
	
	axon_event.addListenerForm("change", "obj_change", formObj); 					// - 변경데이타 처리
	axon_event.addListenerForm('propertychange', 'obj_propertychange', formObj); 	// - 변경데이타 처리
	axon_event.addListenerForm("keypress", "eng_keypress", formObj); 				// - 영문자 입력하기
	axon_event.addListenerForm("keypress", "num_keypress", formObj); 				// - 숫자 입력하기
	axon_event.addListenerForm("keypress", "enter_keypress", formObj); 				// - Enter키 처리
	axon_event.addListenerForm("keyup", "VskKeyFocus", formObj); 					// - 자동포커스 처리
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회

		formObj.f_cmd.value = SEARCH;
		var sParam = FormQueryString(formObj);
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0012GS.do" , sParam);
		ComOpenWait(false);
		var vsl_slan_nm = ComGetEtcData(sXml, "vsl_slan_nm");
		if(!vsl_slan_nm){
			ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
			formObj.tmp_vsl_slan_cd.value = "";
			formObj.vsl_slan_cd.value = "";
			formObj.vsl_slan_cd_1.value = "";
			formObj.vsl_slan_cd_1.focus();
		}else{
			formObj.tmp_vsl_slan_cd.value = formObj.vsl_slan_cd.value;
			ComSetNextFocus();
		}
//		initPage();
		break;
		
	case SEARCH01: // Vessel Code 조회
			
			formObj.f_cmd.value = SEARCH01;
			var sParam = FormQueryString(formObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0012GS.do", sParam);
			ComOpenWait(false);
			var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
			if(!vsl_eng_nm){
				ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
				formObj.tmp_vsl_cd.value = '';
				formObj.vsl_cd.value = '';
				return false;
			}else{
				//ComSetNextFocus();
				formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
//				formObj.vsl_cd.focus();
				return true;
			}
	//		initPage();
			break;
		
	case SEARCH02: // Long Range SKD Inquiry 실행

		if(slanObj1.style.display=="block"){
			formObj.vsl_slan_cd.value = formObj.vsl_slan_cd_1.value;
		}else if(slanObj2.style.display=="block"){
			formObj.vsl_slan_cd.value = formObj.vsl_slan_cd_2.value;
		}
		
		if (validateForm(sheetObj, formObj, sAction)){
			formObj.f_cmd.value = SEARCH02;
			initPage();
			
			var sParam = FormQueryString(formObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("VOP_VSK_0012GS.do", sParam);
			
			arrXml = sXml.split("|$$|");
			deleteSheet();

			if(VskGetErrorXml(sXml)){
				ComOpenWait(false);
				sheetObj.LoadSearchXml(sXml);
			}else{
				
				vslEngNmEtcData = ComGetEtcData(arrXml[0], "vsl_eng_nms");
				portNmEtcData = ComGetEtcData(arrXml[0], "port_nms");
				
				// 그리드의 갯수만큼 searchComplete 항목을 초기화한다.
				searchComplete = new Array();
				subGridHeight = new Array();
				for(var idx=1; idx<arrXml.length; idx++){
					searchComplete[idx] = false;
					subGridHeight[idx] = 0;
				}
				
				// arrXml[0]는 ETC 데이터 영역이므로 1부터 시작
				for(var idx=1; idx<arrXml.length; idx++){
					// sheet1 은 remark 그리드로 이미 배정되어 있으므로,
					// sheet2 부터 시작한다.
					var sheetid = "sheet" + (idx+1);
					ComSheetObject4VSK("sheet_div" , sheetid, idx);
				}
			}
		}
		
		break;

	case SEARCH03: // Lane Code가 없는 상태에서 Vessel Code 조회
		
		if (!validateForm(sheetObj, formObj, sAction)){
			return false;
		}
			
		
		formObj.vsl_slan_cd.value = "";
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj);
		
		ComOpenWait(true);
		var sXml = sheetObj.GetSearchXml("VOP_VSK_0012GS.do", sParam);
		ComOpenWait(false);
		
		var vsl_eng_nm = ComGetEtcData(sXml, "vsl_eng_nm");
		if(!vsl_eng_nm){
			ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
			formObj.tmp_vsl_cd.value = "";
			formObj.vsl_cd.value = "";
		}else{
			
			var vsl_slan_cd_arr = ComGetEtcData(sXml, "vsl_slan_cd_arr");
			var spanObj = null;
			
			initVslSlanCd("2");
			
			var comboObj = formObj.vsl_slan_cd_2;
			comboObj.options.length = 0;
			comboObj.options.add(new Option("ALL", ""));
			
			if(vsl_slan_cd_arr){
				vsl_slan_cd_arr = vsl_slan_cd_arr.split("|");
				for(var i=1; i<vsl_slan_cd_arr.length; i++){ // i=0일때는 그냥 공백이므로 제외
					comboObj.options.add(new Option(vsl_slan_cd_arr[i], vsl_slan_cd_arr[i]));	
				}
			}
			
			formObj.tmp_vsl_cd.value = formObj.vsl_cd.value;
			formObj.vsl_cd.focus();
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if(ComChkLen(vsl_slan_cd.value, 3)==2 || ComChkLen(vsl_cd.value, 4)==2){
			return true;
		}else{
			ComShowCodeMessage('VSK00027', 'Lane Code or Vessel Code');
			return false;
		}
	}
}

/**
 * 변경데이타 처리
 */
function obj_change() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	switch (event.srcElement.name) {
		case "start_qt":
			formObj.start_date.value = ComGetMaskedValue(startQuarterDay(
					parseInt(formObj.start_year.value), formObj.start_qt.value), "ymd");
			if(formObj.start_date.value > formObj.end_date.value){
				formObj.end_qt.value = formObj.start_qt.value;
				formObj.end_date.value = ComGetMaskedValue(endQuarterDay(
						parseInt(formObj.end_year.value), formObj.end_qt.value), "ymd");
			}
			
			break;
	
		case "end_qt":
			formObj.end_date.value = ComGetMaskedValue(endQuarterDay(
					parseInt(formObj.end_year.value), formObj.end_qt.value), "ymd");
			if(formObj.start_date.value > formObj.end_date.value){
				formObj.start_qt.value = formObj.end_qt.value;
				formObj.start_date.value = ComGetMaskedValue(startQuarterDay(
						parseInt(formObj.start_year.value), formObj.start_qt.value), "ymd");
			}
			
			break;
			
		case "start_date":
			controlYearQuarterByDate(formObj, "start_date");
			break;
			
		case "end_date":
			controlYearQuarterByDate(formObj, "end_date");
			break;
	}
}

function obj_propertychange() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	switch (event.srcElement.name) {
		case "start_date":
			controlYearQuarterByDate(formObj, "start_date");
			break;
		case "end_date":
			controlYearQuarterByDate(formObj, "end_date");
			break;
	}
}

function controlYearQuarterByDate(formObj, objName){
	switch(objName){
		case "start_date":
			var start_date = formObj.start_date.value;
			if(ComIsDate(start_date)){
				start_date = ComGetUnMaskedValue(start_date, "ymd");
				formObj.start_year.value =  start_date.substring(0, 4);
				formObj.start_qt.value = checkQuarter(start_date);
			}
			break;
		case "end_date":
			var end_date = formObj.end_date.value;
			if(ComIsDate(end_date)){
				end_date = ComGetUnMaskedValue(end_date, "ymd");
				formObj.end_year.value =  end_date.substring(0, 4);
				formObj.end_qt.value = checkQuarter(end_date);
			}
			break;
	}
}

/**
 * 영문자 입력하기
 */
function eng_keypress() {
	var formObj = document.form;
	switch (event.srcElement.name) {
		case "vsl_slan_cd_1":
		case "vsl_cd":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * 숫자 입력하기
 */
function num_keypress() {
	var formObj = document.form;
	switch (event.srcElement.name) {
		case "start_year":
		case "end_year":
		case "start_date":
		case "end_date":
			ComKeyOnlyNumber();
			break;
	}
}

/**
 * 엔터키로 연결된 화면 대표 이벤트
 */
function enter_keypress(){
	VskKeyEnter();
}

function obj_deactivate() {
	
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var obj = event.srcElement;
	
	switch(obj.name){
	
		case "start_date":
		case "end_date":
			ComChkObjValid(event.srcElement); // 포커스 나갈때 기간체크도 실시함
			break;
			
		case "vsl_slan_cd_1":
			if(formObj.vsl_slan_cd_1.value!="" &&
					formObj.vsl_slan_cd_1.value!=formObj.tmp_vsl_slan_cd.value){
				formObj.vsl_slan_cd.value = formObj.vsl_slan_cd_1.value;
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;
			
		case "vsl_cd":
			if(obj.value==""){
				formObj.tmp_vsl_cd.value = "";
				if(slanObj2.style.display == "block"){
					initVslSlanCd("1");
				}
				return false;
			}
			
			if(obj.value!=formObj.tmp_vsl_cd.value){
				if(doActionIBSheet(sheetObj, formObj, SEARCH01)){
					// vsl_slan_cd가 지정되어 있지 않고, vssel code 조회 결과가 true이면 lane list를 조회한다.
					if(slanObj2.style.display == "block" ||
						(slanObj1.style.display == "block" && formObj.vsl_slan_cd_1.value=="")
					){
						doActionIBSheet(sheetObj, formObj, SEARCH03);
					}
				}else{
					// CHM-201005742-01
					initVslSlanCd("1");
					formObj.vsl_cd.focus();
					return false;
				}
			}
			break;
		
	}
	
}

function obj_focus(){
	ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

/**
 * 시작 분기별 마지막 날짜 반환
 */
function startQuarterDay(year, Quarter) {
	switch (Quarter) {
	case "1":
		return year + "0101";
		break;
	case "2":
		return year + "0401";
		break;
	case "3":
		return year + "0701";
		break;
	case "4":
		return year + "1001";
		break;
	}
	return true;
}
/**
 * 종료 분기별 마지막 날짜 반환
 */
function endQuarterDay(year, Quarter) {
	switch (Quarter) {
	case "1":
		return year + "0331";
		break;
	case "2":
		return year + "0630";
		break;
	case "3":
		return year + "0930";
		break;
	case "4":
		return year + "1231";
		break;
	}
	return true;
}

function ComSheetObject4VSK(objectid, sheetid, idx){
    try {
    	var target = document.getElementById(objectid);
    	if(!target){
    		return null;
    	}
    	
    	var ifr = document.createElement('<iframe name="ifr_' + sheetid + '" id="ifr_' + sheetid + '" frameborder="no" scrolling="no" width="100%" height="0" src="VOP_VSK_0012_01.do" onload=postLoad("ifr_' + sheetid + '",' + idx + ')></iframe>');
    	target.appendChild(ifr);
    	
    } catch(err) { ComFuncErrMsg(err.message); }
}

function postLoad(frameid, idx){
	
	var ifrObj = document.getElementById(frameid);
	
	var HeadCol1 = ComGetEtcData(arrXml[0], "HeadTitle1_" + (idx));          
    var HeadCol2 = ComGetEtcData(arrXml[0], "HeadTitle2_" + (idx));          
    var HeadCol3 = ComGetEtcData(arrXml[0], "HeadTitle3_" + (idx));          
    var HeadCol4 = ComGetEtcData(arrXml[0], "HeadTitle4_" + (idx));
    var HeadCol5 = ComGetEtcData(arrXml[0], "HeadTitle5_" + (idx));
    var HeadCol6 = ComGetEtcData(arrXml[0], "HeadTitle6_" + (idx));
    var HeadCol7 = ComGetEtcData(arrXml[0], "HeadTitle7_" + (idx));
    
    // arrXml[0] 에는 Header Title 정보와 Remark 정보가 있다.
    // 스케쥴 정보는 arrXml[1] 부터 들어있다.
    //
    // 예를 들어, 스케쥴 그리드의 갯수가 3개일때,
    //
    // 그리드의 id
    // sheet1, sheet2, sheet3, sheet4 (sheet1은 remark용)
    //
    // frameid와 idx의 짝
    // [ifr_sheet2 : 1], [ifr_sheet3 : 2], [ifr_sheet4 : 3]
    //
    // 결과 xml(arrXml) 배열 
    // arrXml[0], arrXml[1], arrXml[2], arrXml[3] (arrXml[0]은 remark용)

    document.frames[frameid].loadXml(idx, arrXml[idx], HeadCol1, HeadCol2, HeadCol3, HeadCol4, HeadCol5, HeadCol6, HeadCol7);
}

function setSize(frameid, height){
//	var ifrObj = document.getElementById('ifr_sheet' + (frameid+1));
	//ifrObj.height = rows * 20 + 10;
	//ifrObj.height = height + 10;
	
	subGridHeight[frameid] = height + 10;
	
}

function deleteSheet(){
	var sheetDiv = document.getElementById("sheet_div");
	var iframes = sheetDiv.getElementsByTagName("iframe");
	
	// sheet객체 삭제
	for(var idx = 0; idx<iframes.length; idx++){
		document.frames['ifr_sheet' + (idx+2)].resetSheet();
	}
	
	// iframe 삭제
	for(var idx=iframes.length; idx>0; idx--){
		sheetDiv.removeChild(iframes[idx-1]);
	}
	
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}

function getSubInfo(){
	var formObj = document.form;
	var info = new Object();
	info.vvdMap = vvdMap;
	info.select_yn = formObj.select_yn.value;
	info.pop_yn = formObj.pop_yn.value;
	return info;
}

function postProcess(idx){
	var formObj = document.form;
	searchComplete[idx] = true;
	
	var flag = true;
	for(var idx=1; idx<searchComplete.length; idx++){
		flag = flag && searchComplete[idx];
	}
	
	// 그리드가 모두 로딩되면 후행 프로세스를 시작한다.
	// height 조정 등등
	if(flag){
		// Remark
		ComOpenWait(true);
		sheetObjects[0].LoadSearchXml(arrXml[0]);
		ComOpenWait(false);
		
		for(var idx=1; idx<subGridHeight.length; idx++){
			document.getElementById('ifr_sheet' + (idx+1)).height = subGridHeight[idx];
		}
		
		if("Y"!=formObj.pop_yn.value){
			parent.syncHeight();
		}
		
		var vslEngNms = vslEngNmEtcData.split(";");
		var portNms = portNmEtcData.split(";");
		
		var Row;
		var vslEngNm;
		var portNm;
		
		if(vslEngNms.length>0){
			var rowCnt = Math.floor(vslEngNms.length/3);
			for(var i=0; i<rowCnt; i++){
				sheetObjects[1].DataInsert();
				sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows + i, 0) = "Vessel Code";
				vslEngNm = vslEngNms[3*i].split("|");
				var vslEngNmFull = vslEngNm[0]+"("+vslEngNm[1]+")";
				for(var j=3*i+1; j<3*(i+1); j++){
					vslEngNm = vslEngNms[j].split("|");
					vslEngNmFull = vslEngNmFull+", "+vslEngNm[0]+"("+vslEngNm[1]+")";
				}
				sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows + i, 1) = vslEngNmFull;
			}
			
			if(vslEngNms.length != 3*rowCnt){
				sheetObjects[1].DataInsert();
				sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows + rowCnt, 0) = "Vessel Code"; 
				vslEngNm = vslEngNms[rowCnt*3].split("|");
				var vslEngNmFull = vslEngNm[0]+"("+vslEngNm[1]+")";
				for(var j=3*rowCnt+1; j<vslEngNms.length; j++){
					vslEngNm = vslEngNms[j].split("|");
					vslEngNmFull = vslEngNmFull+", "+vslEngNm[0]+"("+vslEngNm[1]+")";
				}
				sheetObjects[1].CellValue2(sheetObjects[1].HeaderRows + rowCnt, 1) = vslEngNmFull;
			}
		}

		if(portNms.length>0){
			var rowCnt = Math.floor(portNms.length/3);
			for(var i=0; i<rowCnt; i++){
				sheetObjects[2].DataInsert();
				sheetObjects[2].CellValue2(sheetObjects[2].HeaderRows + i, 0) = "Port Code";
				portNm = portNms[3*i].split("|");
				var portNmFull = portNm[0]+"("+portNm[1]+")";
				for(var j=3*i+1; j<3*(i+1); j++){
					portNm = portNms[j].split("|");
					portNmFull = portNmFull+", "+portNm[0]+"("+portNm[1]+")";
				}
				sheetObjects[2].CellValue2(sheetObjects[2].HeaderRows + i, 1) = portNmFull;
			}
			
			if(portNms.length != 3*rowCnt){
				sheetObjects[2].DataInsert();
				sheetObjects[2].CellValue2(sheetObjects[2].HeaderRows + rowCnt, 0) = "Port Code"; 
				portNm = portNms[rowCnt*3].split("|");
				var portNmFull = portNm[0]+"("+portNm[1]+")";
				for(var j=3*rowCnt+1; j<portNms.length; j++){
					portNm = portNms[j].split("|");
					portNmFull = portNmFull+", "+portNm[0]+"("+portNm[1]+")";
				}
				sheetObjects[2].CellValue2(sheetObjects[2].HeaderRows + rowCnt, 1) = portNmFull;
			}
		}
	}
	
}

function checkPeriod(formObj){
	var startDate 	= ComReplaceStr(formObj.start_date.value, "-", "");
	var endDate 	= ComReplaceStr(formObj.end_date.value, "-", "");
	var tmpDate 	= ComGetDateAdd(startDate, "Y", 1);
	
	if(ComChkPeriod(endDate, tmpDate)==1){			
		return true;
	}else{
		return false;
	}
}

/**
 * 주어진 날짜가 몇분기에 속하는지 체크한다.
 * 1분기 : "1" 반화
 * 2분기 : "2" 반환
 * 3분기 : "3" 반환
 * 4분기 : "4" 반환
 * 
 * @param date
 * @return
 */
function checkQuarter(date){
	
	var month_date = date.substring(4, 8);
	
	if(month_date <= "0331"){
		return "1";
	}else if(month_date <= "0630"){
		return "2";
	}else if(month_date <= "0930"){
		return "3";
	}else{
		return "4";
	}
	
}

// 현재년도설정
function setCurrentPeriod(){

	var today = new Date();
	var formObj = document.form;
	
	with (formObj) {
		var nowDate = ComGetUnMaskedValue(ComGetNowInfo(), "ymd");
		start_year.value = today.getFullYear();
		end_year.value = today.getFullYear();
		var quarter = checkQuarter(nowDate);
		start_qt.value = quarter;
		end_qt.value = quarter;
		start_date.value = ComGetMaskedValue(startQuarterDay(
				parseInt(start_year.value), quarter), "ymd");
		end_date.value = ComGetMaskedValue(endQuarterDay(
				parseInt(end_year.value), quarter), "ymd");
	}	
}

/**
 * type이 1이면 : vsl_slan_cd_1(input) 활성화
 * type이 2이면 : vsl_slan_cd_2(combo) 활성화
 */
function initVslSlanCd(type) {
	var formObj = document.form;
	if(type=="1"){
		slanObj1.style.display = "block";
		slanObj2.style.display = "none";
	}else if(type=="2"){
		slanObj1.style.display = "none";
		slanObj2.style.display = "block";
	}
	formObj.vsl_slan_cd_1.value = "";
	formObj.vsl_slan_cd_2.value = "";
	formObj.vsl_slan_cd.value = "";
}

function sheet1_OnClick(sheetObj, row, col, value) {
	//remark 셀을 클릭했을때 MemoPad를 표시
	if (sheetObj.ColSaveName(col) == "RMK") {
		// 	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)
		ComShowMemoPad(sheetObj, null, null, true, 600, null, 2000);
	}
}
	