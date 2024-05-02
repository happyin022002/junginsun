/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_EQR_1025.js
 *@FileTitle : Loading Trend by Lane
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
 * @class EES_EQR_1025 : EES_EQR_1025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_EQR_1025() {
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
	formObj.tpsz.value ="N";
	hiddenCntrTpsz("");
	
	//조회 Query,ViewAdapter에서 사용
	formObj.cntr_tpsz_cd.value = consTpsz;
	
	//Set Week 
	formObj.fm_wk.value = formObj.h_fm_wk.value
	formObj.to_wk.value = formObj.h_to_wk.value
	
	//ETA Date 비활성화
	ComEnableObject(formObj.eta_fm_dt,false);
	ComEnableObject(formObj.eta_to_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
	
	//RCC Combo 비활성화
	var h_ofc_tp_cd = formObj.h_ofc_tp_cd.value;
	
	//Loc_cd 비활성화
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

			case "btns_calendar":
				if(formObj.dt_tp_cd[1].checked){
					var cal = new ComCalendarFromTo();
                	cal.select(formObj.eta_fm_dt, formObj.eta_to_dt, 'yyyy-MM-dd');
				}
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
			    formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("EES_EQR_1025GS.do",FormQueryString(formObj));
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
	
	if (formObj.dt_tp_cd[0].checked) {
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
	}else if (formObj.dt_tp_cd[1].checked){
		if (ComTrimAll(formObj.eta_fm_dt) == "") {
			ComShowCodeMessage("EQR01101","ETA From date"); //Please input ETA from date
			formObj.eta_fm_dt.focus();
			rtn_val = false;			
		}else if (ComTrimAll(formObj.eta_to_dt) == "") {
			ComShowCodeMessage("EQR01101","ETA To date"); //Please input ETA from date
			formObj.eta_to_dt.focus();
			rtn_val = false;					
		}else{
			var diffDay = ComGetDaysBetween(formObj.eta_fm_dt.value, formObj.eta_to_dt.value);

			if (diffDay < 0) {
				ComShowCodeMessage('EQR01118');
				formObj.eta_to_dt.value = "";
				formObj.eta_to_dt.focus();
				rtn_val = false;	
			}else if (diffDay > 365) {
				ComShowCodeMessage('EQR01106','365 days');
				formObj.eta_to_dt.value = "";
				formObj.eta_to_dt.focus();			
				rtn_val = false;		
			}
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
				style.height = screen_height-380;
//				style.height = 450;
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
				InitRowInfo(3, 1, 3, 100);

				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				var col_cnt = 11
							+ eval(consTpszArr.length)  //MT PLAN
							+ 3							//M.Ton|Teu|Box	
							+ eval(consTpszArr.length) 	//MT Booking(B)
							+ 3  						//M.Ton|Teu|Box
							+ eval(consTpszArr.length) 	//Diff(A-B)
							+ 2							//Teu|Box
							+ eval(consTpszArr.length) 	//Full BKG Load
							+ 4							//M.Ton|WT|Teu|Box
							+ eval(consTpszArr.length)	//Full BKG Disch
							+ 14
							;
				InitColumnInfo(col_cnt, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, true, true, false, false)
				
				//======================== Set Header 0 ======================== 
				var HeadTitle0 = "Trade|Sub\nTrade|R.LANE|Week|VVD|POL|ETA|ETD|FCBF\ndate|MT Plan(A)|MT Plan(A)";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|MT Plan(A)";//MT Plan(A)
					
				}
				HeadTitle0 = HeadTitle0+"|MT Plan(A)|MT Booking(B)|MT Booking(B)"

				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|MT Booking(B)"; //MT Booking(B)
				}
				
				HeadTitle0 = HeadTitle0+"|MT Booking(B)|Diff (A-B)|Diff (A-B)"
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Diff (A-B)"; //|Diff (A-B)
				}
				
				HeadTitle0 = HeadTitle0+"|Full BKG|Full BKG"
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Full BKG"; //Full BKG Load
				}
				
				HeadTitle0 = HeadTitle0+"|Full BKG|Full BKG|Full BKG|Full BKG"
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle0 = HeadTitle0+"|Full BKG"; //Full BKG Disch
				}
				
				HeadTitle0 = HeadTitle0+"|Full BKG|Void|BSA|BSA|L/F|L/F|L/F|L/F|L/F|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg"
				
				
				//======================== Set Header 1 ========================
				var HeadTitle1 = "Trade|Sub\nTrade|R.LANE|Week|VVD|POL|ETA|ETD|FCBF\ndate|MT Plan(A)|MT Plan(A)";
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|MT Plan(A)"; 	//MT PLAN
				}
				
				HeadTitle1 = HeadTitle1+"|MT Plan(A)|MT Booking(B)|MT Booking(B)";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|MT Booking(B)";	// MT Booking(B)
				}
				
				HeadTitle1 = HeadTitle1+"|MT Booking(B)|Diff(A-B)|Diff(A-B)";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|Diff(A-B)";	// Diff(A-B)
				}

				HeadTitle1 = HeadTitle1+"|Load|Load";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|Load";	// MT Booking Load
				}
				
				HeadTitle1 = HeadTitle1+"|Load|Average\nWT|Disch|Disch";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle1 = HeadTitle1+"|Disch";	// MT Booking Disch
				}
				
				HeadTitle1 = HeadTitle1+"|Disch|Void|BSA|BSA|F/D|Full|Full|TTL|TTL|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg";
				
				
				//======================== Set Header 2 ========================
				var HeadTitle2 = "Trade|Sub\nTrade|R.LANE|Week|VVD|POL|ETA|ETD|FCBF\ndate|Teu|Box";
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle2 = HeadTitle2+"|"+consTpszArr[i]; //MT Plan(A)
				}
				
				HeadTitle2 = HeadTitle2+"|M/Ton|Teu|Box";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle2 = HeadTitle2+"|"+consTpszArr[i]; //MT Booking(B)
				}
				
				HeadTitle2 = HeadTitle2+"|M/Ton|Teu|Box";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle2 = HeadTitle2+"|"+consTpszArr[i]; //Diff(A-B)
				}
				
				HeadTitle2 = HeadTitle2+"|Teu|Box";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle2 = HeadTitle2+"|"+consTpszArr[i]; //Full BKG Load
				}
				
				HeadTitle2 = HeadTitle2+"|M/Ton|Average\nWT|Teu|Box";
				
				for(var i=0; i<consTpszArr.length; i++){
					HeadTitle2 = HeadTitle2+"|"+consTpszArr[i]; //Full BKG Disch
				}
				
				HeadTitle2 = HeadTitle2+"|M/Ton|Teu| Teu|M/Ton|F/D|Teu|M/Ton|Teu|M/Ton|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);
				InitHeadRow(2, HeadTitle2, true);
				
				HeadRowHeight = 20;

				// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHidden, 		50, daCenterTop ,	true,  "trd_cd", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			38, daCenterTop ,	true,  "sub_trd_cd", 		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			45, daCenterTop , 	true,  "vsl_lane_cd",		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			43, daCenterTop, 	true,  "wk",				false, 		"", 		dfNone,     	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			68, daCenterTop, 	true,  "vvd_cd",			false,		"", 		dfNone,     	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			55, daCenter, 		true,  "pol_yd_cd", 		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			93, daCenter, 		true,  "eta_dt",			false, 		"", 		dfUserFormat,  	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData,			93, daCenter, 		true,  "etd_dt",			false, 		"", 		dfUserFormat,  	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 		    65, daCenter , 		true,  "fcbf_dt", 			false, 		"", 		dfUserFormat, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false, "mty_pln_teu",  		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false, "mty_pln_box",  		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) { // MT PLAN
				col_nm = "mty_pln_"+(consTpszArr[i]).toLowerCase();
		 		InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
				InitDataProperty(0, cnt++, dtData, 			43, daRight, 		false,  "mty_pln_ton", 		false, 		"", 		dfNullInteger, 	0,		false,	false,	0	,0	,false);
				
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "mty_bkg_teu", 		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "mty_bkg_box", 		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) {//MT Booking 
				col_nm = "mty_bkg_"+(consTpszArr[i]).toLowerCase();
				InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false, 	col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
				
				InitDataProperty(0, cnt++, dtData, 			43, daRight, 		false,  "mty_bkg_ton", 		false, 		"", 		dfNullInteger, 	0,		false,	false,	0	,0	,false);
				
				InitDataProperty(0, cnt++, dtData, 			35, daRight, 		false,  "diff_teu", 		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			35, daRight, 		false,  "diff_box", 		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) {//Diff(A-B)
				col_nm = "diff_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			35, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
			
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "bkg_lodg_teu", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "bkg_lodg_box", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) {// Full BKG Lodg
				col_nm = "bkg_lodg_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false,  col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}

				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "bkg_lodg_ton", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			55, daRight, 		 true,  "bkg_avg_wt", 		false, 		"", 		dfNullFloat, 	1,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "bkg_disch_teu", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "bkg_disch_box", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
			for (var i = 0; i < consTpszArr.length; i++) {// Full BKG Disch
				col_nm = "bkg_disch_"+(consTpszArr[i]).toLowerCase();
			 	InitDataProperty(0, cnt++, dtData, 			38, daRight, 		false, 	col_nm,  			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
			}
			
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "bkg_disch_ton", 	false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			35, daRight, 		true,   "void_teu", 		false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);

				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "bsa_teu", 			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			48, daRight, 		false,  "bsa_ton", 			false, 		"", 		dfNullInteger, 	0,		false, 	false,	0	,0	,false);
				
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		true,   "lf_fd", 			false, 		"", 		dfNone, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "lf_full_teu", 		false, 		"", 		dfNone, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "lf_full_ton", 		false, 		"", 		dfNone, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			40, daRight, 		false,  "lf_ttl_teu", 		false, 		"", 		dfNone, 	0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "lf_ttl_ton", 		false, 		"", 		dfNone, 	0,		false, 	false,	0	,0	,false);

				
				InitDataProperty(0, cnt++, dtData, 			80, daLeft, 		false,  "pln_rsn_hdr_cd", 	false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 			80, daLeft, 		false,  "pln_rsn_sub_cd", 	false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtData, 		   100, daLeft, 		true,   "pln_rsn_rmk", 		false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtHidden, 		50, daLeft, 		true,   "sort_flg", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				InitDataProperty(0, cnt++, dtHidden, 		50, daLeft, 		true,   "ibflag", 			false, 		"", 		dfNone, 		0,		false, 	false,	0	,0	,false);
				
				SetMergeCell(0,9,2,21);  //MT Plan(A) Header Merge
				SetMergeCell(0,30,2,21); //MT Booking(B) Header Merge
				SetMergeCell(0,51,2,20); //Diff(A-B) Header Merge
				SetMergeCell(0,115,2,2); //BSA Header Merge
////				SetMergeCell(0,117,2,5); //L/F Header Merge
				SetMergeCell(0,122,3,2); //ShortFall Reason Header Merge
				
				sheetObj.InitUserFormat(0, "eta_dt", 	 	"####-##-## ##:##", "-|:" );
				sheetObj.InitUserFormat(0, "etd_dt", 	 	"####-##-## ##:##", "-|:" );
				sheetObj.InitUserFormat(0, "fcbf_dt", 	 	"####-##-##", "-|" );
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
		
		case "eta_fm_dt":
			ComKeyOnlyNumber(formObj.eta_fm_dt,"");//숫자만 입력허용
		break;
		
		case "eta_to_dt":
			ComKeyOnlyNumber(formObj.eta_to_dt,"");//숫자만 입력허용
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
			formObj.eta_fm_dt.value = ComTrimAll(formObj.eta_fm_dt.value, "-");
		break;
		
		case "eta_to_dt":
			formObj.eta_to_dt.value = ComTrimAll(formObj.eta_to_dt.value, "-");
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
					if (parseInt(formObj.fm_wk.value) > parseInt(str_val)) {
						formObj.to_wk.value = "";
						ComShowCodeMessage("EQR01119");
						formObj.to_wk.focus();
					}else if ((parseInt(str_val) - parseInt(formObj.fm_wk.value)) > 100) {
							formObj.to_wk.value = "";
							formObj.to_wk.focus();
							ComShowCodeMessage('EQR01106', '52 weeks');
					}
				}
			}
		break;
		
		case "eta_fm_dt":
//			// 기간 체크는 eta_to_dt 에서만
			if(ComTrimAll(formObj.eta_fm_dt.value, "-").length == 8){
				formObj.eta_fm_dt.value = ComTrimAll(formObj.eta_fm_dt.value, "-").substr(0,4)+"-"
										+ ComTrimAll(formObj.eta_fm_dt.value, "-").substr(4,2)+"-"
										+ ComTrimAll(formObj.eta_fm_dt.value, "-").substr(6,2)
			}
		break;
		
		case "eta_to_dt":
			
			if (ComTrimAll(formObj.eta_fm_dt) != "" && ComTrimAll(formObj.eta_to_dt) != "") {

				diffDay = ComGetDaysBetween(formObj.eta_fm_dt, formObj.eta_to_dt);
	
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.eta_to_dt.value = "";
					formObj.eta_to_dt.focus();
				}else if (diffDay > 365) {
					ComShowCodeMessage('EQR01106','365 days');
					formObj.eta_to_dt.value = "";
					formObj.eta_to_dt.focus();				
				}
			}
			if(ComTrimAll(formObj.eta_to_dt.value, "-").length == 8){
				formObj.eta_to_dt.value = ComTrimAll(formObj.eta_to_dt.value, "-").substr(0,4)+"-"
										+ ComTrimAll(formObj.eta_to_dt.value, "-").substr(4,2)+"-"
										+ ComTrimAll(formObj.eta_to_dt.value, "-").substr(6,2)
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

/**
 * 설  명 : Data Selection Check Event -  <br>
 * @author SHIN DONG IL
 * @version 2013.07.15
 */
function form_data_selection(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var arr_cntr_tpsz = (comboObjects[3].Code).split(",");
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		
		case "wgt":
			// Weight : M/Ton column Hidden
			if(formObj.wgt.checked){
				if(formObj.pln.checked){
					sheetObj.ColHidden("mty_pln_ton") 		= false;
				}
				
				sheetObj.ColHidden("mty_bkg_ton") 		= false;
				
				if(formObj.bkg.checked){
					sheetObj.ColHidden("bkg_lodg_ton") 		= false;
					sheetObj.ColHidden("bkg_disch_ton") 	= false;
					sheetObj.ColHidden("bkg_avg_wt") 		= false;
				}
				
				sheetObj.ColHidden("bsa_ton") 			= false;
				sheetObj.ColHidden("lf_full_ton") 		= false;
				sheetObj.ColHidden("lf_ttl_ton") 		= false;
				
			}else{
				sheetObj.ColHidden("mty_pln_ton") 		= true;
				sheetObj.ColHidden("mty_bkg_ton") 		= true;
				sheetObj.ColHidden("bkg_lodg_ton") 		= true;
				sheetObj.ColHidden("bkg_disch_ton")		= true;
				sheetObj.ColHidden("bkg_avg_wt") 		= true;
				sheetObj.ColHidden("bsa_ton") 			= true;
				sheetObj.ColHidden("lf_full_ton") 		= true;
				sheetObj.ColHidden("lf_ttl_ton") 		= true;
			}
			
		break;
		
		case "pln":
			// Weight : M/Ton column Hidden
			if(formObj.pln.checked){
				if(formObj.wgt.checked){
					sheetObj.ColHidden("mty_pln_ton")= false;
				}
				
				sheetObj.ColHidden("mty_pln_teu")= false;	
				sheetObj.ColHidden("mty_pln_box")= false;
				
				for (var i = 0; arr_cntr_tpsz.length >0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.ColHidden("mty_pln_"	+arr_cntr_tpsz[i].toLowerCase())= false;

				}
			}else{
				sheetObj.ColHidden("mty_pln_teu")= true;
				sheetObj.ColHidden("mty_pln_box")= true;
				sheetObj.ColHidden("mty_pln_ton")= true;
				
				for(var i=0;i<consTpszArr.length;i++ ){
					sheetObj.ColHidden("mty_pln_"	+consTpszArr[i].toLowerCase())= true;					
				}
			}
			
		break;
		
		case "dif":
			// Weight : M/Ton column Hidden
			if(formObj.dif.checked){
				sheetObj.ColHidden("diff_teu")= false;
				sheetObj.ColHidden("diff_box")= false;
				for (var i = 0; arr_cntr_tpsz.length > 0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.ColHidden("diff_"	+arr_cntr_tpsz[i].toLowerCase())= false;

				}
			}else{
				sheetObj.ColHidden("diff_teu")= true;
				sheetObj.ColHidden("diff_box")= true;				
				for(var i=0;i<consTpszArr.length;i++ ){
					sheetObj.ColHidden("diff_"	+consTpszArr[i].toLowerCase())= true;
				}
			}
		break;
		
		case "bkg":
			//Full Booking Container Type Size column Hidden
			if(formObj.bkg.checked){
				if(formObj.wgt.checked){
					sheetObj.ColHidden("bkg_lodg_ton")	= false;
					sheetObj.ColHidden("bkg_avg_wt")	= false;
					sheetObj.ColHidden("bkg_disch_ton")	= false;
				}
				
				sheetObj.ColHidden("bkg_lodg_teu")	= false;
				sheetObj.ColHidden("bkg_lodg_box")	= false;
				sheetObj.ColHidden("bkg_disch_teu")	= false;
				sheetObj.ColHidden("bkg_disch_box")	= false;								
				
				for (var i = 0; arr_cntr_tpsz.length >0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.ColHidden("bkg_lodg_"	+arr_cntr_tpsz[i].toLowerCase())= false;
					sheetObj.ColHidden("bkg_disch_"	+arr_cntr_tpsz[i].toLowerCase())= false;

				}
			}else{
				sheetObj.ColHidden("bkg_lodg_teu")	= true;
				sheetObj.ColHidden("bkg_lodg_box")	= true;
				sheetObj.ColHidden("bkg_lodg_ton")	= true;
				sheetObj.ColHidden("bkg_avg_wt")	= true;
				sheetObj.ColHidden("bkg_disch_teu")	= true;
				sheetObj.ColHidden("bkg_disch_box")	= true;
				sheetObj.ColHidden("bkg_disch_ton")	= true;						
				for (var i = 0; i < consTpszArr.length; i++) {
					sheetObj.ColHidden("bkg_lodg_"	+consTpszArr[i].toLowerCase())= true;
					sheetObj.ColHidden("bkg_disch_"	+consTpszArr[i].toLowerCase())= true;

				}
			}
		break;
		
		case "avg":
			//Average Row Hidden
			if(sheetObj.RowCount  > 0){
				if(formObj.avg.checked){
					for(var i = 0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+3,"sort_flg")=="3" || sheetObj.CellValue(i+3,"sort_flg")=="4"){
							sheetObj.RowHidden(i+3) = false;
						}
					}
				}else{
					for(var i = 0; i<sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i+3,"sort_flg")=="3" || sheetObj.CellValue(i+3,"sort_flg")=="4"){
							sheetObj.RowHidden(i+3) = true;
						}
					}
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
		
		case "N":
            comboObjects[3].Code = "";
        break;
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
 * RCC Combo code 변경시 
 * Loc code초기화
 */
function change_rcc(){
	var formObj = document.form;
	if(formObj.rcc_cd.value !=""){
		formObj.loc_cd.value = "";
	}
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

		sheetObj.ColHidden("mty_pln_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("mty_bkg_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("diff_"		+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("bkg_lodg_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden("bkg_disch_"	+consTpszArr[i].toLowerCase())= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());

	}//end for(var i=0;i<consTpszArr.length;i++)
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
	
	formObj.dt_tp_cd[0].checked= true;
	
	formObj.fm_wk.value = formObj.h_fm_wk.value;
	formObj.to_wk.value = formObj.h_to_wk.value;
	formObj.eta_fm_dt.value = "";
	formObj.eta_to_dt.value = "";
	
	ComEnableObject(formObj.fm_wk,true);
	ComEnableObject(formObj.to_wk,true);
	ComEnableObject(formObj.eta_fm_dt,false);
	ComEnableObject(formObj.eta_to_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
	
	document.getElementById("fm_wk").className = "input";
	document.getElementById("to_wk").className = "input";
	
	formObj.trade.Code ="";
	formObj.subtrade.Code ="";
	formObj.lane.Code = "";

	formObj.vvd_cd.value = "";
	
	formObj.rcc_cd.value = "";
	formObj.loc_tp_cd.value = "";
	formObj.loc_cd.value = "";

	//Loc_cd 비활성화
	ComEnableObject(formObj.loc_cd, false);
	
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value ="N";
	tpszChange("N");
	
	formObj.wgt.checked = true;
	formObj.pln.checked = true;
	formObj.dif.checked = true;
	formObj.bkg.checked = true;
	formObj.avg.checked = true;
	
	sheetObj.RemoveAll();

}

/**
 * Radio Button Click Event
 */
function chg_dt_tp() {
	var formObj = document.form;
	
	if(formObj.dt_tp_cd[0].checked){
		if (ComTrimAll(formObj.fm_wk) == "" && ComTrimAll(formObj.to_wk) == "") {
			formObj.fm_wk.value = formObj.h_fm_wk.value;
			formObj.to_wk.value = formObj.h_to_wk.value;
		}	
		
		ComEnableObject(formObj.fm_wk,true);
		ComEnableObject(formObj.to_wk,true);
		ComEnableObject(formObj.eta_fm_dt,false);
		ComEnableObject(formObj.eta_to_dt,false);
		ComEnableObject(formObj.btns_calendar,false);
		
		document.getElementById("fm_wk").className = "input";
		document.getElementById("to_wk").className = "input";
		
	}else if(formObj.dt_tp_cd[1].checked){
		if (ComTrimAll(formObj.eta_fm_dt) == "" && ComTrimAll(formObj.eta_to_dt) == "") {
			formObj.eta_fm_dt.value = formObj.h_eta_fm_dt.value;
			formObj.eta_to_dt.value = formObj.h_eta_to_dt.value;
		}
		
		ComEnableObject(formObj.fm_wk,false);
		ComEnableObject(formObj.to_wk,false);
		ComEnableObject(formObj.eta_fm_dt,true);
		ComEnableObject(formObj.eta_to_dt,true);
		ComEnableObject(formObj.btns_calendar,true);

		document.getElementById("eta_fm_dt").className = "input";
		document.getElementById("eta_to_dt").className = "input";
	}
	
}