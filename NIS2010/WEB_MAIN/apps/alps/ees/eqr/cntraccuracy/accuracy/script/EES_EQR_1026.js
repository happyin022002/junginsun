/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_EQR_1026.js
 *@FileTitle : Discharging Result
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.11
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2013.07.11 SHIN DONG IL
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
 * @class EES_EQR_1026 : EES_EQR_1026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_EQR_1026() {
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
var sheetCnt     = 0;
var comboObjects = new Array();
var comboCnt 	 = 0 ;
var comObjects   = new Array();

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	var formObj = document.form;


	//Trade, Sub Trade, Lane Multi Select ComboBox
	searchOptionTrade("trade", true, true,"","","",true);
	searchOptionSubTrade("subtrade", true, true,"","","","",true);
	searchOptionLane("lane",true, true,"","","","","",true);

    for(i=0;i<sheetObjects.length;i++){
    	//시작 환경 설정 함수 이름 변경
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
		//마지막 환경 설정 함수 추가
        ComEndConfigSheet(sheetObjects[i]);
    }

	// multi combo box setting
	for(var p=0; p< comboObjects.length; p++) {
    	initCombo(comboObjects[p], p+1);
	}
	
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value ="D";
	tpszChange("D");
	
	//조회 Query,ViewAdapter에서 사용
	formObj.cntr_tpsz_cd.value = consTpsz;
	
	//Set Week 
	formObj.fm_wk.value = formObj.h_fm_wk.value
	formObj.to_wk.value = formObj.h_to_wk.value
	
	//RCC Combo 비활성화
	var h_ofc_tp_cd = formObj.h_ofc_tp_cd.value;
	//HQ : Regional Head Quarter
	//HT : Head Office Team
	
	//loc_cd 비활성화
	ComEnableObject(formObj.loc_cd, false);
	
	/*
	 * 6개 OFFICE 종류는 모든지역 조회 가능, 그 외의 office 는 자기지역의 RCC 만 선택됨.
	- HQ : Regional Head Quarter
	- QT : Reg.HQ Team
	- HT : Head Office Team
	- AF : Affiliate of HJS
	- HO : Head Office
	*/
	if(h_ofc_tp_cd != "HQ" && h_ofc_tp_cd != "QT" && h_ofc_tp_cd != "HT" && h_ofc_tp_cd != "AF" && h_ofc_tp_cd != "HO"){
		formObj.rcc_cd.value = formObj.h_rcc_cd.value;
		ComEnableObject(formObj.rcc_cd,false);
	}

}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
			break;

			case "btn_new":
				init_form();//화면 초기화.
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;
			
			case "btn_loc_cd":	//Location 조회 팝업
    			//if(formObj.loc_cd.value != "") {	
					var code_type = formObj.loc_tp_cd.value;

					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "L") {	
						ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "S"){
				    	ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }
    			//}
			    
			break; 

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR01109");//The service is not available now
		} else {
			alert(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {

       case IBSEARCH:      //조회
       		if(validateSearch()){
				sheetObj.RemoveAll();
				sheetObj.ExtendLastCol = false; // 마지막 CELL 확장금지
				
			    formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("EES_EQR_1026GS.do",FormQueryString(formObj));
			}
       break;

       case IBDOWNEXCEL:   //엑셀 다운로드
       		if(sheetObj.RowCount >0){
	       		sheetObj.Down2Excel(-1,false,false,true);
			}else{
				ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
			}
       break;
    }
}

/**
 * 조회 조건 유효성 체크
 */
function validateSearch() {
	var formObj = document.form;
	var rtn_val = true;
	
	if (ComTrimAll(formObj.fm_wk) == "") {
		formObj.fm_wk.focus();
		ComShowCodeMessage("EQR01101","From Week"); //Please input From Week
		rtn_val = false;
	}else if (ComTrimAll(formObj.to_wk) == "") {
		formObj.to_wk.focus();
		ComShowCodeMessage("EQR01101","To Week"); //Please input To Week
		rtn_val = false;				
	}else{
		if (parseInt(formObj.fm_wk.value) > parseInt(formObj.to_wk.value)) {
			formObj.to_wk.value = "";
			ComShowCodeMessage("EQR01119");
			formObj.to_wk.focus();
			rtn_val = false;	
		}else if ((parseInt(formObj.to_wk.value) - parseInt(formObj.fm_wk.value)) > 100) {
				formObj.to_wk.value = "";
				formObj.to_wk.focus();
				ComShowCodeMessage('EQR01106', '52 weeks');
				rtn_val = false;	
		}
	}
	
	return rtn_val;
}


/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt = 0;
	var col_nm = "";
	var screen_height = window.screen.height;

	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {

				// 높이 설정
				//style.height = screen_height-330;
				style.height = 555;
				// 전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				// Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				// 전체Merge 종류 [선택, Default msNone , msPrevColumnMerge + msHeaderOnly]
				MergeSheet = msPrevColumnMerge + msHeaderOnly;

				// 전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				EditableColorDiff = false;

				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				var col_cnt = 6
							+ eval(consTpszArr.length)  //Discharging result
							+ 1
							+ eval(consTpszArr.length) 	//Loading result
							+ 1
							+ eval(consTpszArr.length) 	//Difference
							+ 1
							+ eval(consTpszArr.length) 	//MT Repo guideline
							+ 1
							+ eval(consTpszArr.length)	//Difference
							+ 4
							;
				InitColumnInfo(col_cnt, 6, 0, true);				
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, true, true, false, false)
				
				//ExtendLastCol = false;  // 마지막 CELL 확장금지
				
				//======================== Set Header 0 ======================== 
				var HeadTitle0 = "Trade|Sub\nTrade|R.LANE|Week|VVD|POD";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Discharging Result(A)";//Discharging result
					
				}
				HeadTitle0 = HeadTitle0+"|Discharging Result(A)";//TTL

				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Loading Result(B)"; //Loading result
				}
				HeadTitle0 = HeadTitle0+"|Loading Result(B)"; //TTL
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Diff(A-B)"; //Difference
				}
				HeadTitle0 = HeadTitle0+"|Diff(A-B)"; //TTL
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|MT Plan(C)"; //MT Repo guideline
				}
				HeadTitle0 = HeadTitle0+"|MT Plan(C)"; //TTL
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Diff(A-C)"; //Difference
				}
				HeadTitle0 = HeadTitle0+"|Diff(A-C)| |Sort_id|ibflg"
				
				
				//======================== Set Header 1 ========================
				var HeadTitle1 = "Trade|Sub\nTrade|R.LANE|Week|VVD|POD";
				
				HeadTitle1 = HeadTitle1+"|TTL"; //Discharging result TTL
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|"+consTpszArr[i]; //Discharging result
				}
				
				HeadTitle1 = HeadTitle1+"|TTL"; //Loading result TTL
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];	//Loading result
				}
				
				HeadTitle1 = HeadTitle1+"|TTL"; //Difference TTL
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];	//Difference
				}
				
				HeadTitle1 = HeadTitle1+"|TTL"; //Difference TTL
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];	//MT Repo guideline
				}
				
				HeadTitle1 = HeadTitle1+"|TTL"; //Difference TTL				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|"+consTpszArr[i];	//Difference
				}

				HeadTitle1 = HeadTitle1+"| |Sort_id|ibflg";
				
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 			60, daCenterTop ,	true,  "trd_cd", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			70, daCenterTop ,	true,  "sub_trd_cd", 		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			50, daCenterTop , 	true,  "vsl_lane_cd",		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			60, daCenterTop, 	true,  "wk",				false, 		"", 		dfNone,     	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			70, daCenterTop, 	true,  "vvd_cd",			false,		"", 		dfNone,     	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			60, daCenter, 		true,  "pod_cd", 		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);

				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "disch_ttl",  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);

			for (var i = 0; i < consTpszArr.length; i++) { // Discharge Result
				col_nm = "disch_"+(consTpszArr[i]).toLowerCase();
		 		InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
			
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "lodg_ttl",  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) {// Loading Result
				col_nm = "lodg_"+(consTpszArr[i]).toLowerCase();
				InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false, 	col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}

				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "ab_ttl",  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);

			for (var i = 0; i < consTpszArr.length; i++) {//Difference(A-C) : Discharge Result(A) - Loading Result(B)
				col_nm = "ab_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}

				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "gline_ttl",  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);

			for (var i = 0; i < consTpszArr.length; i++) {// MT Repo Guideline(C)
				col_nm = "gline_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}

				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "ac_ttl",  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);

			for (var i = 0; i < consTpszArr.length; i++) {//Difference(A-C) : Discharge Result(A) - MT Repo Guideline(C)
				col_nm = "ac_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false, 	col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
				InitDataProperty(0, cnt++, dtHidden, 		50, daLeft, 		true,   "blk", 				false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtHidden, 		50, daLeft, 		true,   "sort_id", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtHidden, 		50, daLeft, 		true,   "ibflag", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				
		}

		break;
	}
}

/**
 * KeyPress 변경시 이벤트 처리
 * @author SHIN DONG IL
 * @version 2013.07.15 
 */
function form_keypress() {
	var formObj = document.form;

	switch (event.srcElement.name) {
	
		case "fm_wk":
			ComKeyOnlyNumber(formObj.fm_wk,"");// 숫자만 입력허용
		break;
		
		case "to_wk":
			ComKeyOnlyNumber(formObj.to_wk,"");//숫자만 입력허용
		break;
		
		case "vvd_cd":
			ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
		break;
		
		case "loc_cd":
			ComKeyOnlyAlphabet('upper');// 알파벳 대문자
		break;
			
	}
}

/**
 * 설  명 : Form Object Event - onBlur <br>
 * @author SHIN DONG IL
 * @version 2013.07.15
 */
function form_focus(){
	var formObj = document.form;
	var str_val = "";
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		
		case "eta_fm_dt":
			
		break;

	}
}

/**
 * 설  명 : Form Object Event - onBlur <br>
 * @author SHIN DONG IL
 * @version 2013.07.15
 */
function form_blur(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var diffDay = 0;
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch(srcName){
		case "fm_wk":
			if (ComTrimAll(formObj.fm_wk) != "") {
				str_val = formObj.fm_wk.value;
				
				if (str_val.length < 6) {
					formObj.fm_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}else if (str_val.length > 0 && !ComIsWeek(str_val.substring(4, 6))) {
					formObj.fm_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}else if (parseInt(str_val.substring(0, 4)) < 1900) {
					formObj.fm_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}
				// 기간 체크는 to_wk 에서만
			}
		break;
		
		case "to_wk":
			
			if (ComTrimAll(formObj.to_wk) != "") {
				str_val = formObj.to_wk.value;
				
				if (str_val.length < 6) {
					formObj.to_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (str_val.length > 0 && !ComIsWeek(str_val.substring(4, 6))) {
					formObj.to_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (parseInt(str_val.substring(0, 4)) < 1900) {
					formObj.to_wk.value = "";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (ComTrimAll(formObj.fm_wk) != "" && ComTrimAll(formObj.to_wk) != ""){
					if(parseInt(formObj.fm_wk.value) > parseInt(str_val)){
						formObj.to_wk.value = "";
						ComShowCodeMessage("EQR01119", "YYYYWW");
						formObj.to_wk.focus();
					}else if ((parseInt(str_val) - parseInt(formObj.fm_wk.value)) > 100) {
							formObj.to_wk.value = "";
							formObj.to_wk.focus();
							ComShowCodeMessage('EQR01106', '52 weeks');
					}
				}
			}
		break;
		
		case "loc_cd":
			if (ComTrimAll(formObj.loc_cd) != "" && formObj.loc_tp_cd.value !="") {
				formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("EES_EQR_1025GS.do", FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck != "T") {
					if (formObj.loc_tp_cd.value == "L") {
						ComShowCodeMessage("EQR01005");
					}else if (formObj.loc_tp_cd.value == "E") {
						ComShowCodeMessage("EQR01006");
					}else if (formObj.loc_tp_cd.value == "S") {
						ComShowCodeMessage("EQR01007");
					}

					formObj.loc_cd.value = "";
				}
			}
		break;
		
		case "vvd_cd":
			// VVD 유효성 체크
			if (ComTrimAll(formObj.vvd_cd) != "") {
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_EQR_1025GS.do", FormQueryString(formObj));
				
				var sCheck = ComGetEtcData(sXml, "check");
				
				if (sCheck == "F") {
					formObj.vvd_cd.value = "";
					ComShowCodeMessage("EQR01121", "VVD code");
				}
			}
		break;		
	}
}

/*
 * Container Type Combo OnChange Event
 *
 * */
function tpszChange(key){
    switch (key){
        case "":
            comboObjects[3].Code = consTpsz;
        break;

        case "D":
            comboObjects[3].Code = consTpszDry;
        break;

        case "R":
            comboObjects[3].Code = consTpszRfr;
        break;

        case "O":
            comboObjects[3].Code = consTpszOt;
        break;

        case "F":
            comboObjects[3].Code = consTpszFr;
        break;
    }
}

/**
 * Location Type Code변경에 따라 loc_cd 활성화/비활성화
 * @param {Object} key
 */
function locTpcdChange(key){
	var formObj = document.form;

	if (key == "") {
		formObj.loc_cd.value = "";
		ComEnableObject(formObj.loc_cd, false);
	}else {
		ComEnableObject(formObj.loc_cd, true);
		document.getElementById("loc_cd").className = "input";
	}
}

/**
 * MultiSelectCombo 기본 설정
 * 탭의 항목을 설정한다.
 */
function initCombo (comboObj, comboNo) {
    var cnt  = 0 ;
	var formObj = document.form;
	with (comboObj) {
		var strId = comboObj.id;
		switch (strId) {

			case "tpsztype":
				DropHeight = 9 * 20;

				var menuname = tpszallText.split('|');
				var menucode = tpszallCode.split('|')

				MultiSelect = true;
				MaxSelect = menuname.length;
				MultiSeparator = ",";

				for (i = 0; i < menuname.length; i++) {
					InsertItem(cnt++, menuname[i], menucode[i]);
				}
			break;
		}
	}
}

//선택된 CONTAINER TYPE/SIZE에 따라 그리드의 헤더를 변경한다.
function tpsztype_OnChange(comboObj, value, text) {

	//조회 완료 후 선택된 Container Type/Size 이외 Hidden
	hiddenCntrTpsz(value);
}


/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 *
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author
 * @version
 */
function trade_OnChange(comboObj, code, text) {

	searchOptionSubTrade("subtrade", true, true, "",  "",  code,   "", true);
	searchOptionLane("lane",true, true, "", code,"", true,"",true);

}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 *
 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
 * @param {int} text 필수 화면에 표시된 글자
 * @return 없음
 * @author
 * @version
 */
function subtrade_OnChange(comboObj, value, text) {
	searchOptionLane("lane",true,true,"",document.form.trade.Code,value,true,"",true);
}

/*
 * Container Type/Size에 따라 Grid의 컬럼을 활성화 Hidden처리
 * OnloadPage,OnSearchEnd event에서 호출
 * @param {String} tpsz_cd
 * DESC : 전체의 Container Type/Size중 선택된 Container Type/Size만 활성화 한다.
 */
function hiddenCntrTpsz(tpsz_cd){
	var sheetObj = sheetObjects[0];
	var cntr_tpsz = tpsz_cd.toLowerCase();
	var arr_tpsz = cntr_tpsz.split(",");

	for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size

		sheetObj.ColHidden("disch_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("lodg_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("ab_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("gline_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("ac_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());


	}//end for(var i=0;i<consTpszArr.length;i++)

}


/**
 * RCC Combo code 변경시 
 * Loc code초기화
 */
function change_rcc(){
	var formObj = document.form;
	if(formObj.rcc_cd.value !=""){
		formObj.loc_cd.value = "";
	}
}

 /**
  * EQR: EQR에서 취급하는 CNTR TP SZ가 맞는지 확인  
  **/
function isValidEQRCntrTpSz(arr_tpsz, tpsz) {
	for (var i=0; tpsz!=undefined && tpsz!=null && tpsz!='' && arr_tpsz!=null && i<arr_tpsz.length; i++){
  		if (arr_tpsz[i]!=undefined && arr_tpsz[i]!='' && arr_tpsz[i].toLowerCase()==tpsz.toLowerCase()){
    		return true;
   		}
	  }
	
	return false;
 }

/**
 * New 버튼 클릭시 화면 초기화.
 */
function init_form() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.fm_wk.value = formObj.h_fm_wk.value;
	formObj.to_wk.value = formObj.h_to_wk.value;
	
	formObj.trade.Code ="";
	formObj.subtrade.Code ="";
	formObj.lane.Code = "";

	formObj.vvd_cd.value = "";
	
	formObj.rcc_cd.value = "";
	formObj.loc_tp_cd.value = "";
	formObj.loc_cd.value = "";
	
	//loc_cd 비활성화
	ComEnableObject(formObj.loc_cd, false);
	
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value ="D";
	tpszChange("D");
	
	sheetObj.RemoveAll();

}