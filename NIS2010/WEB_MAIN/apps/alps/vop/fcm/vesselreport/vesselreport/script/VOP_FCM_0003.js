/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : VOP_FCM_0003.js
 *@FileTitle : PK Mismatched(Departure Report)(Popup)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.18
 *@LastVersion : 1.0
 * 1.0 Creation
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
 * @class VOP_FCM_0003 : VOP_FCM_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0003() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var fmDtTmp = "";
var toDtTmp = "";
var vslSlanCdTmp = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	var sheetObject = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_calendarfm":
				var cal = new ComCalendar();
				cal.select(formObj.fm_dt, 'yyyy-MM-dd');
				break;
			
			case "btn_calendarto":
				var cal = new ComCalendar();
				cal.select(formObj.to_dt, 'yyyy-MM-dd');
				break;
				
			case "btn_Retrieve":
				doActionIBSheet(sheetObject2, formObj, IBSEARCH);
				break;
				
			case "btn_Save":
				doActionIBSheet(sheetObject, formObj, MULTI);
				break;
				
			case "btn_Close":
				self.close();
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	for(var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}

	initControl();

	formObj.fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -14);
	fmDtTmp = formObj.fm_dt.value.replace(/-/gi, "");
	formObj.to_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "d", -1);
	toDtTmp = formObj.to_dt.value.replace(/-/gi, "");
	
	doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 조회
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다.
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('click', 'obj_click', formObj);
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListenerForm("deactivate", "obj_deactivate", formObj);
	axon_event.addListenerForm('propertychange', 'obj_propertychange', formObj);
}

/**
 * Click 이벤트 처리
 */
function obj_click() {
	var obj = event.srcElement.name;
	
	if (obj == "chk_perfo" || obj == "chk_fuel" || obj == "chk_rob" || obj == "chk_dest" || obj == "chk_time" || obj == "chk_condi") {
		processCellHidden();
	}
}

/**
 * Keypress 이벤트 처리
 */
function obj_keypress() {
	switch(event.srcElement.name){
		case "fm_dt":
		case "to_dt":
			ComKeyOnlyNumber();
			break;
		case "last_port":
		case "dep_port":
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}

/**
 * Activate 이벤트 처리
 */
function obj_activate() {
	switch(event.srcElement.name){
	case "fm_dt":
		fmDtTmp = event.srcElement.value.replace(/-/gi, "");
		ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
		break;
	case "to_dt":
		toDtTmp = event.srcElement.value.replace(/-/gi, "");
		ComClearSeparator(event.srcElement); // 입력시 마스크 안보이기
		break;
	}
	
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
}

/**
 * Deactivate 이벤트 처리
 */
function obj_deactivate() {
	var obj = event.srcElement;
	
	switch(obj.name){
		case "fm_dt":
			fmDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 날짜 유효성 체크
			break;
		case "to_dt":
			toDtTmp = event.srcElement.value.replace(/-/gi, "");
			ComChkObjValid(event.srcElement); // 날짜 유효성 체크
			break;
	}
}

/**
 * Propertychange 이벤트 처리
 */
function obj_propertychange(){
	var obj = event.srcElement;
	var formObj = document.form;
	
	if(event.propertyName=="value"){
		switch(obj.name){
			case "fm_dt":
				if(fmDtTmp.length == 8 && obj.value.replace(/-/gi, "").length == 8 && obj.value.replace(/-/gi, "") != fmDtTmp){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 재조회
					vslSlanCdTmp = "";
				} else {
					return false;
				}
				break;
			case "to_dt":
				if(toDtTmp.length == 8 && obj.value.replace(/-/gi, "").length == 8 && obj.value.replace(/-/gi, "") != toDtTmp){
					doActionIBSheet(sheetObjects[0], formObj, SEARCH); // 전체 콤보박스 정보 재조회
					vslSlanCdTmp = "";
				} else {
					return false;
				}
				break;
		}
	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    switch(comboObj.id) {
	case "vsl_slan_cd":
		with (comboObj) { 
			MultiSelect = true;
			MultiSeparator = ",";
			DropHeight = 320
			UseAutoComplete = true;
			ValidChar(2, 1); //영문대문자 & 숫자만 입력가능
			MaxLength = 3;
		}
		break;
	case "vsl_cd":
		with (comboObj) { 
			MultiSelect = true;
			MultiSeparator = ",";
			DropHeight = 320;
			UseAutoComplete = true;
			ValidChar(2, 1); //영문대문자 & 숫자만 입력가능
			MaxLength = 4;
		}
		break;
		
	case "vps_port_cd":
		with (comboObj) { 
			MultiSelect = true;
			MultiSeparator = ",";
			DropHeight = 320;
			UseAutoComplete = true;
			ValidChar(2, 0); //영문대문자만 입력가능
			MaxLength = 5;
		}
		break;
		
	case "skd_dir_cd":
		with (comboObj) { 
			MultiSelect = false;
			DropHeight = 320;
//			InsertItem(0, '','');
			InsertItem(0, 'E','E');
			InsertItem(1, 'W','W');
			InsertItem(2, 'S','S');
			InsertItem(3, 'N','N');
			UseAutoComplete = true;
			ValidChar(2, 0); //영문대문자만 입력가능
			MaxLength = 1;
		}
		break;
	}//end of switch
}
     
     
     
   /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
    var cnt = 0;
    switch(sheetNo) {
    case 1:      //IBSheet1 init
        with (sheetObj) {
            // 높이 설정
            style.height = 65;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=50]
            InitRowInfo(1, 1, 1, 1);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)
            
            var HeadTitle = "STS.|Lane|VSL CD|Voy. NO.|Calling SEQ.|DEP. Port|Next Port|S/B Engine Time|R/Up Engine Time||||||||||" ;
            var headCount = ComCountHeadTitle(HeadTitle);
            
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]                    
            InitColumnInfo(headCount, 0, 0, true);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHidden,   35,    daCenter,  false,    "");
            InitDataProperty(0, cnt++ , dtData,     50,		daCenter,  false,	"vsl_slan_cd",	false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,     60,		daCenter,  false,	"vsl_cd", 		false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,     70,	daCenter,  false,	"skd_voy_dir", 	true, "", dfNone, 0,  true, true, 5);
            InitDataProperty(0, cnt++ , dtData,     90,		daCenter,  false,	"clpt_ind_seq", true, "", dfNumber, 0,true, true, 2);
            InitDataProperty(0, cnt++ , dtData,     70,		daCenter,  false,	"dep_port_cd", 	true, "", dfNone, 0,  true, true, 5);
            InitDataProperty(0, cnt++ , dtData,     70,		daCenter,  false,	"nxt_port_cd", 	false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,		0,		daCenter,  false,	"sb_eng_dt", 		false, "", dfNone, 0, false, false);
            InitDataProperty(0, cnt++ , dtData,		0,		daCenter,  false,	"rup_dt", 		false, "", dfNone, 0, false, false);
            
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"old_vsl_cd");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"old_skd_voy_no");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"old_skd_dir_cd");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"old_dep_port_cd");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"old_clpt_ind_seq");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"dep_rpt_err_seq");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"skd_voy_no");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"skd_dir_cd");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"rcv_dt");
            InitDataProperty(0, cnt++ , dtHidden,   0,		daCenter,  false,	"rcv_seq");     
            
            InitDataValid(0, 	"vsl_cd",    		vtEngUpOnly);
            InitDataValid(0,    "skd_voy_dir",    	vtEngUpOther, "1234567890");
            InitDataValid(0, 	"dep_port_cd",    	vtEngUpOnly);
            CountPosition = 0; 
        }
        
        break; 
        
    case 2:      //IBSheet1 init
        with (sheetObj) {
            // 높이 설정
            style.height = 220;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

            //전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=50]
            InitRowInfo(1, 1, 9, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]                    
            InitColumnInfo(9, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false, false)
            
            var HeadTitle = "";
            HeadTitle = "Seq.|Lane|VSL CD|Voy. NO.|Calling SQE.|DEP. Port|Next Port|ETD|Matching" ;

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  false,    "seq");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"vsl_slan_cd");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"vsl_cd");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"skd_voy_dir");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"clpt_ind_seq");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"dep_port_cd");
            InitDataProperty(0, cnt++ , dtData,     0,		daCenter,  false,	"nxt_port_cd");
			InitDataProperty(0, cnt++ , dtData,		120,	daCenter,  false,	"vps_etd_dt");
			InitDataProperty(0, cnt++ , dtData,		0,		daCenter,  false,	"mtc_yn");

        }
            
        break;     
                
    }//end of switch
}


  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {      
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
	case SEARCH: // 전체 콤보박스 정보 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		
		formObj.vsl_slan_cd.removeAll();
		formObj.vsl_cd.removeAll();
		formObj.vps_port_cd.removeAll();
		
		var sXml = sheetObj.GetSearchXml("VOP_FCM_0003GS.do", FormQueryString(formObj));
		var vslSlanCds = (","+ComGetEtcData(sXml, "vsl_slan_cd")).split(",");
		var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
		var vpsPortCds = (","+ComGetEtcData(sXml, "vps_port_cd")).split(",");
		
		for(var i=0; i<comboObjects.length; i++){
			if(comboObjects[i].id == "vsl_slan_cd"){
				appendMultiComboItem(comboObjects[i], vslSlanCds, vslSlanCds, "");
			} else if(comboObjects[i].id == "vsl_cd"){
				appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
			} else if(comboObjects[i].id == "vps_port_cd"){
				appendMultiComboItem(comboObjects[i], vpsPortCds, vpsPortCds, "");
			}
		}
		ComOpenWait(false);
		break;
		
	case SEARCH01: // Vessel 콤보박스 정보 조회
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		
		formObj.vsl_cd.removeAll();
		
		var sXml = sheetObj.GetSearchXml("VOP_FCM_0003GS.do", FormQueryString(formObj));
		var vslCds     = (","+ComGetEtcData(sXml, "vsl_cd")).split(",");
		
		for(var i=0; i<comboObjects.length; i++){
			if(comboObjects[i].id == "vsl_cd"){
			appendMultiComboItem(comboObjects[i], vslCds, vslCds, "");
		}
		}
		ComOpenWait(false);
		break;
		
	
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST;
			var sXml = sheetObj.GetSearchXml("VOP_FCM_0003GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}
		break;
		
	case MULTI: // 업데이트
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var saveStr =sheetObj.GetSaveString(false);
			var sXml = sheetObj.GetSaveXml("VOP_FCM_0003GS.do", saveStr + "&" + FormQueryString(formObj));
			ComOpenWait(false);
			
			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
				ComShowCodeMessage("COM130102", "Data");
			}
		}
		break;
	}//end of switch
}



   /**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
    	switch(sAction){
		case IBSEARCH:
			var fmDt = formObj.fm_dt.value;
			var toDt = formObj.to_dt.value;
			
			if (fmDt == "" || toDt == "") {
				ComShowCodeMessage("FCM00006", "Period");
				return false;
			}
			
			var tmpDt = ComGetDateAdd(fmDt, "Y", 1);
			
            if (parseInt(toDt.replace(/-/g, '')) < parseInt(fmDt.replace(/-/g, ''))) {
            	ComShowCodeMessage("COM12133", "To Date", "From Date", "later");
				return false;
			} else {
				if(ComChkPeriod(toDt, tmpDt) == 1){
					return true;
				}else{
					ComShowCodeMessage("FCM00005", "1 year");
					return false;
				}
			}
			break;
			
		case MULTI:
			var skdVoDir = sheetObj.CellValue(0, "skd_voy_dir");
			sheetObj.CellValue2(0, "skd_voy_no") = skdVoDir.substr(0, 4);
			sheetObj.CellValue2(0, "skd_dir_cd") = skdVoDir.substr(4, 1);
			
			break;
    	}

    }

    return true;
}

/**
 * Mutil Combo에 item을 추가한다.
 * @param comboObj
 * @param optionCds
 * @param optionTxts
 * @param selCode
 * @return
 */
function appendMultiComboItem(comboObj, optionCds, optionTxts, selCode){
	comboObj.InsertItem(0, "ALL", '');
	for(var i=1; i<optionCds.length; i++) {
		comboObj.InsertItem(i, optionCds[i], optionTxts[i]);
	}
}

/**
 * Lane 콤보박스 CheckClick 이벤트 처리
 */
function vsl_slan_cd_OnCheckClick(comboObj,index){
 	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * Vessel 콤보박스 CheckClick 이벤트 처리
 */
function vsl_cd_OnCheckClick(comboObj,index){
 	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * Vessel 콤보박스 CheckClick 이벤트 처리
 */
function vps_port_cd_OnCheckClick(comboObj,index){
 	if(index==0) {
		var bChk = comboObj.CheckIndex(index);
		if(bChk){
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = true;
			}
		} else {
			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
				comboObj.CheckIndex(i) = false;
			}
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}

/**
 * Lane 콤보박스 OnBlur 이벤트 처리
 */
function vsl_slan_cd_OnBlur(){
	var formObj = document.form;
	var tmpComboTxt = comboObjects[0].Text();
	
	if (vslSlanCdTmp != tmpComboTxt) {
		doActionIBSheet(sheetObjects[0], formObj, SEARCH01); // Vessel 콤보박스 정보 조회
	}
	
	vslSlanCdTmp = tmpComboTxt;
}

function setInitVal4Search(fmDt, toDt, vslCd, vslSlanCd, vvd, clptIndSeq, depPortCd, nxtPortCd, rupdt, depRptErrSeq, rcvDt, rcvSeq, sbEngDt){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	//form 값 설정
	formObj.fm_dt.value = fmDt;
	formObj.to_dt.value = toDt;
	
	document.getElementById("vsl_cd").Code2 = vvd.substr(0, 4);
	
	//sheet1값 설정
	var idx = sheetObj.DataInsert(-1);
	
	sheetObj.CellValue2(idx, "vsl_slan_cd") = vslSlanCd;
	sheetObj.CellValue2(idx, "vsl_cd") = vvd.substr(0, 4);
	sheetObj.CellValue2(idx, "skd_voy_dir") = vvd.substr(4, 5);
	sheetObj.CellValue2(idx, "clpt_ind_seq") = clptIndSeq;
	sheetObj.CellValue2(idx, "dep_port_cd") = depPortCd;
	sheetObj.CellValue2(idx, "nxt_port_cd") = nxtPortCd;
	sheetObj.CellValue2(idx, "skd_voy_no") = vvd.substr(4, 4);
	sheetObj.CellValue2(idx, "skd_dir_cd") = vvd.substr(8, 1);	
	sheetObj.CellValue2(idx, "rup_dt") = rupdt;
	//old값설정
	sheetObj.CellValue2(idx, "old_vsl_cd") = vvd.substr(0, 4);
	sheetObj.CellValue2(idx, "old_skd_voy_no") = vvd.substr(4, 4);
	sheetObj.CellValue2(idx, "old_skd_dir_cd") = vvd.substr(8, 1);
	sheetObj.CellValue2(idx, "old_dep_port_cd") = depPortCd;
	sheetObj.CellValue2(idx, "old_clpt_ind_seq") = clptIndSeq;
	sheetObj.CellValue2(idx, "dep_rpt_err_seq") = depRptErrSeq; //FCM_DEP_RPT_ERR KEY
	sheetObj.CellValue2(idx, "rcv_dt") = rcvDt; 				//FCM_DEP_RPT_LOG KEY
	sheetObj.CellValue2(idx, "rcv_seq") = rcvSeq;				//FCM_DEP_RPT_LOG KEY
	sheetObj.CellValue2(idx, "sb_eng_dt") = sbEngDt;
	
	sheetObj.CellBackColor(idx, "dep_port_cd") = sheetObj.RgbColor(195,195,195);
	sheetObj.CellBackColor(idx, "rup_dt") = sheetObj.RgbColor(195,195,195);
	sheetObj.SelectCell(0, 0);

	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
}

/**
 * Sheet2의 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
 */
function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	for (var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
		sheetObj.CellBackColor(i, "dep_port_cd") = sheetObj.RgbColor(195,195,195);
		sheetObj.CellBackColor(i, "vps_etd_dt") = sheetObj.RgbColor(195,195,195);
	}
}

/* 개발자 작업 끝 */
