/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : EES_EQR_1008.js
 *@FileTitle : Empty Repo Guideline Creation.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.5.27
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2013.05.27 SHIN DONG IL
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
 * @class EES_EQR_1008 : EES_EQR_1008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function EES_EQR_1008() {
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
var pri_combo_cd = "";

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
function loadPage(mainpage) {
	var formObj = document.form;

	//Trade, Sub Trade, Lane Multi Select ComboBox
	searchOptionTrade("trade", true, true,"","","",true);
	searchOptionSubTrade("subtrade", true, true,"","","","",true);
	searchOptionLane("lane",true, true,"","","","","",true);

	formObj.trade.Code ="";
	formObj.subtrade.Code ="";
	formObj.lane.Code = "";

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
	
//	comboObjects[0].Enable = false;
	
	//화면 권한 제어
	if(mainpage == "true"){ // EES_EQR_1008 에서 오픈
		ComBtnEnable("btn_save");
		ComBtnEnable("btn_email");		
		ComBtnEnable("btn_guideline_add");
		ComBtnEnable("btn_guideline_amend");
		ComBtnEnable("btn_guideline_del");
		ComBtnEnable("btn_pod_add");
		ComBtnEnable("btn_pod_del");
		
	}else{  // EES_EQR_1011 에서 오픈
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_email");		
		ComBtnDisable("btn_guideline_add");
		ComBtnDisable("btn_guideline_amend");
		ComBtnDisable("btn_guideline_del");
		ComBtnDisable("btn_pod_add");
		ComBtnDisable("btn_pod_del");
	}

	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value ="D";
	tpszChange("D");

	formObj.cntr_tpsz_cd.value =("D2,D4,D5,D7,R2,R5,R9,O2,O4,O5,S2,S4,F2,F4,F5,A2,A4,A5").toLowerCase();

	//Grid Header Hidden
	setGridHidden(comboObjects[3].Code);
	
	ComEnableObject(formObj.s_eff_st_dt,false);
	ComEnableObject(formObj.s_eff_end_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
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

			case "btn_save":
			    if(validateSave()){
					doActionIBSheet(sheetObject, formObj, MULTI);
				}
			break;

			case "btn_new":
				init_form();//화면 초기화.
			break;

			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;

			case "btn_guideline_add":
			    var url = "EES_EQR_1009.do"
      					+ "?f_cmd=-1"   // DEFAULT 호출
      					+ "&event_div=A" // Guideline Add
      		            ;

				ComOpenWindowCenter(url,"EES_EQR_1009",850,150, true);
					
			break;

			case "btn_guideline_amend":
				if (sheetObject.RowCount > 0) {
					var trade 		= 	sheetObject.cellValue(sheetObject.SelectRow, "trd_cd");
					var subtrade 	=	sheetObject.cellValue(sheetObject.SelectRow, "sub_trd_cd");
					var lane 		=	sheetObject.cellValue(sheetObject.SelectRow, "vsl_lane_cd")
					
					if(validateAmend()){
						var url = "EES_EQR_1009.do" 
								+"?f_cmd=-1" // DEFAULT 호출
								+"&event_div=M" // Guideline Amend
								+"&trade=" +trade // Trade Code
								+"&subtrade=" +trade+subtrade// Sub Trade Code
	 							//+"&lane=" +trade+subtrade+lane // Lane Code
	 							+"&lane=" +lane // Lane Code
	 							+"&h_eta_dt=" +sheetObject.cellValue(sheetObject.SelectRow, "eff_st_dt") // Effective start date
								;

						ComOpenWindowCenter(url,"EES_EQR_1009",850,150, true);	

					}
				}else{
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
			break;

			case "btn_guideline_del":
				if (sheetObject.RowCount > 0) {
					doActionIBSheet(sheetObject, formObj, REMOVE01);
				}else{
					ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
				}
			break;

			case "btn_pod_add":
				if (check_confirm()) {
					pod_row_add(sheetObject);
				}else{
					ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
				}
			break;

			case "btn_pod_del":
				if (check_confirm()) {
					if (sheetObject.RowCount > 0) {
						doActionIBSheet(sheetObject, formObj, REMOVE02);
					}
					else {
						ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
					}
				}else{
					ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
				}
			break;

			case "btns_calendar":
				if (formObj.s_dt_tp_cd[1].checked) {
					var cal = new ComCalendarFromTo();
					cal.select(formObj.s_eff_st_dt, formObj.s_eff_end_dt, 'yyyy-MM-dd');
				}
            break;
			
			case "btn_loc_cd":	//Location By 조회 팝업
		
    			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 457, "s_loc_cd:s_sub_loc_cd", "0,1,1,1,1,1", true);
			    
			break;  
			
			case "btn_Lane":
				ComOpenPopupWithTarget("/hanjin/COM_ENS_081.do", 780, 420, "col1:lane_direct", '1,0,1,1,1,1,1,1', true);
			break;	
						
			case "btn_email":  // EMAIL SEND 화면 호출
			    var url = "EES_EQR_1031.do"
      		            ;

				ComOpenWindowCenter(url,self,500,200, true);
				
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
       		if(validateForm()){
				sheetObj.RemoveAll();
	       		formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("EES_EQR_1008GS.do", FormQueryString(formObj));
			}
       break;

	   case MULTI:	// Save
		    formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("EES_EQR_1008GS.do",FormQueryString(formObj));
	   break;
	   
	   case REMOVE01:   //Guideline Delete
		   	var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
			var mrg_to_row = Number(sheetObj.GetMergedEndCell(sheetObj.SelectRow,"pol_cd").split(",")[0]);
			if(check_confirm()){
				for(var i=mrg_fm_row; i<=mrg_to_row;i++){
					sheetObj.cellValue(i,"ibflag") ="D";
					sheetObj.RowHidden(i) = true;			
				}
			}else{
				ComShowCodeMessage("EQR01116"); //Confirm된 Guideline을  수정할 수 없습니다.
			}

	   break;
	   
	   case REMOVE02:  // POD Delete
	   		//POD 입력하지 않는 ROW 모두 삭제
	  		if (sheetObj.cellValue(sheetObj.SelectRow, "pod_cd") == "") {
				sheetObj.RowDelete(sheetObj.SelectRow, false);
			}else{
				if(sheetObj.cellValue(sheetObj.SelectRow,"sort_id")=="3"){
					sheetObj.RowHidden(sheetObj.SelectRow) = true;
					sheetObj.cellValue(sheetObj.SelectRow,"ibflag") ="D";
				}else{
					ComShowCodeMessage("EQR01102","POD");//POD를 선택하세요.
				}	
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
function validateForm() {
	var formObj = document.form;
	var rtn_val = true;
	
	
	if(formObj.s_dt_tp_cd[0].checked){
		if (ComIsEmpty(formObj.s_eta_dt)) {
			ComShowCodeMessage('EQR01105','Latest Date');
			formObj.s_eta_dt.focus() ;
			return false ;
		}
	}else if(formObj.s_dt_tp_cd[1].checked){
		if (ComIsEmpty(formObj.s_eff_st_dt)) {
			ComShowCodeMessage('EQR01105','Duration From date') ;
			formObj.s_eff_st_dt.focus() ;
			return false ;
		}
		
		if (ComIsEmpty(formObj.s_eff_end_dt)) {
			ComShowCodeMessage('EQR01105','Duration To Date') ;
			formObj.s_eff_end_dt.focus() ;
			return false ;
		}
		
		var diffDay = ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
		
		if(diffDay < 0){
			ComShowCodeMessage('EQR01118') ;
			formObj.s_eff_end_dt.value = "";
			formObj.s_eff_end_dt.focus() ;
			return false ;
		}
		
//		if(diffDay > 30){
//			ComShowCodeMessage('EQR01106','30') ;
//			formObj.s_eff_end_dt.focus() ;
//			return false ;
//		}
	}
	

	if(comboObjects[3].Code == ""){
		ComShowCodeMessage("EQR01101");
		rtn_val = false;
	}

	return rtn_val;
}

/**
 * 저장시 유효성 체크
 */
function validateSave() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var row_cnt = sheetObj.RowCount;
	var rtn_val = true;
	var cnt = 0;
	var pod_cnt =0;
	var pod_leng =0;
	var str_cfm_flg = "";
	
	var pcnt_d2 = 0;
	var pcnt_d4 = 0;
	var pcnt_d5 = 0;
	var pcnt_d7 = 0;
	
	var unit_d2 = "";
	var unit_d4 = "";
	var unit_d5 = "";
	var unit_d7 = "";
	
	var pcnt_sum= 0;
	
	for(var i=0 ; i<row_cnt; i++){

		
		if(sheetObj.RowStatus(i+2) != "R"){    //변경된 건  일 경우
			//ETA가 현재일자보다 클 경우 Confirm된 건은 Confirm Cancel할 수 없다.
			str_cfm_flg = sheetObj.CellSearchValue(i+2, "cfm_flg");
			if (sheetObj.CellValue(i + 2, "sort_id") == "1") {	// Guideline Header
				if (str_cfm_flg == "1" && sheetObj.CellValue(i + 2, "sort_id") == "1") { //confirm flag가 Y이고 Guideline Header일 경우
					if (sheetObj.CellValue(i + 2, "cfm_flg") == "0") {
						if (ComGetDaysBetween(sheetObj.CellValue(i + 2, "eff_st_dt"), formObj.h_eta_dt.value) > 0) {
							sheetObj.CellValue2(i+2, "cfm_flg")='1';
							ComShowCodeMessage("EQR01108");//Confirm 취소할 수 없습니다.
							rtn_val = false;
						}
					}
				}
			}
			if(sheetObj.CellValue(i + 2, "sort_id") == "3"){
				//POD 입력 여부 체크.
				if (sheetObj.CellValue(i + 2, "pod_cd") == "") { 
					pod_cnt++;
				}
				
				//POD 입력 여부 체크.
				if ((sheetObj.CellValue(i + 2, "pod_cd")).length <5) { 
					pod_leng++;
				}
			}
			
			// CHM-201432588, 데이터 매뉴얼 입력 및 Validation 요청 (신용찬, 2014-11-05)
			// % 라인의 합이 0 인지 100인지 확인
			if (sheetObj.CellValue(i + 2, "sort_id") == "2") {	// % line
				pcnt_d2 = sheetObj.CellValue(i + 2, "d2_qty");
				pcnt_d4 = sheetObj.CellValue(i + 2, "d4_qty");
				pcnt_d5 = sheetObj.CellValue(i + 2, "d5_qty");
				pcnt_d7 = sheetObj.CellValue(i + 2, "d7_qty");
				
				unit_d2 = sheetObj.CellValue(i + 2, "d2_ut");
				unit_d4 = sheetObj.CellValue(i + 2, "d4_ut");
				unit_d5 = sheetObj.CellValue(i + 2, "d5_ut");
				unit_d7 = sheetObj.CellValue(i + 2, "d7_ut");				
				
				if(pcnt_d2==null || pcnt_d2=="" || unit_d2 != "P") pcnt_d2 = 0;  // % 가 아닌 경우도 0 으로 취급
				if(pcnt_d4==null || pcnt_d4=="" || unit_d4 != "P") pcnt_d4 = 0;
				if(pcnt_d5==null || pcnt_d5=="" || unit_d5 != "P") pcnt_d5 = 0;
				if(pcnt_d7==null || pcnt_d7=="" || unit_d7 != "P") pcnt_d7 = 0;
				
				pcnt_sum = parseInt(pcnt_d2) + parseInt(pcnt_d4) + parseInt(pcnt_d5) + parseInt(pcnt_d7);
				
//				alert("pcnt_d2 : "+pcnt_d2+", pcnt_d4 : "+pcnt_d4+", pcnt_d5 : "+pcnt_d5+", pcnt_d7 : "+pcnt_d7);
//				alert("summary : " +pcnt_sum);
				
				// DRY 타입사이즈 UNIT = % 일때만 validation 로직 가동 
				if(unit_d2 == "P" && unit_d4 == "P" && unit_d5 == "P" && unit_d7 == "P") {
					if(pcnt_sum == 0 || pcnt_sum == null) {  // % 의 합=0 
//						alert("Please fill in '%' column");
						ComShowCodeMessage("EQR01143");
						rtn_val = false;
						break;
					}else if(pcnt_sum != 100) {              // % 의 합 <> 0 AND 합 <> 100
//						alert("Total value in '%' should be 100% ");
						ComShowCodeMessage("EQR01144");
						rtn_val = false;	
						break;
					}
				}
			}
			
			cnt++;
		}
	}
 	
	if (row_cnt == 0) {
		ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
		rtn_val = false;
	}else if (cnt == 0) {//데이터 변경 유무체크
		ComShowCodeMessage("EQR01107");
		rtn_val = false;
	}else if (pod_cnt > 0) { //POD 입력 여부 체크. 
		ComShowCodeMessage("EQR01102","POD");//'POD를 선택하세요.';
		rtn_val = false;
	}else if (pod_leng > 0) {
		ComShowCodeMessage("EQR01115");//'POD를 선택하세요.';
		rtn_val = false;	
	}
	
	return rtn_val;
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo){
	var cnt = 0;

	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {

				// 높이 설정
				style.height = 410;
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
				InitColumnInfo(56, 9, 0, true);
				
				//Row Height Fix
				AutoRowHeight = false;  

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, false, true, true, false, false)
				
				WordWrap = true;

				var HeadTitle0 = "Trade|Sub|LANE|Effective|Effective|Effective|Effective|Effective|Effective|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Guideline|Expiration\nDate|Confirm|Update\nDate|Update\nUser|";
				var HeadTitle1 = "Trade|Sub|LANE||VVD|POL|ETA|Remark|POD|D2|D2|D4|D4|D5|D5|D7|D7|R2|R2|R5|R5|R9|R9|O2|O2|O4|O4|O5|O5|S2|S2|S4|S4|F2|F2|F4|F4|F5|F5|A2|A2|A4|A4|A5|A5|Expiration\nDate|Confirm|Update\nDate|Update\nUser|";

				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, true);

				// 데이터속성 [   ROW, COL, DATATYPE,       WIDTH,DATAALIGN,	COLMERGE,  SAVENAME,	  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData, 			40,	daCenterTop ,	 true,  "trd_cd", 		false, "", dfNone, 			0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 			30, daCenterTop ,	 true,  "sub_trd_cd", 	false, "", dfNone, 			0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 			35, daCenterTop , 	 true,  "vsl_lane_cd",	false, "", dfNone, 			0,false, 	false);
				InitDataProperty(0, cnt++, dtHidden,		80, daCenter, 		 true,  "eq_gline_seq",	false, "", dfNone,      	0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 			65, daCenterTop , 	 true,  "vvd", 			false, "", dfNone, 			0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 			45, daCenterTop, 	 true,  "pol_cd", 		false, "", dfNone, 			0,false, 	false);
				InitDataProperty(0, cnt++, dtData,			50, daCenterTop, 	 true,  "eta_dt",		false, "", dfNone,  		0,false,	false);
				InitDataProperty(0, cnt++, dtData, 		   120, daLeftTop, 		 true,  "repo_gline_rmk",false, "", dfNone, 		0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			50, daCenter, 		 true,  "pod_cd", 		false, "", dfEngUpKey, 		0,false, 	true,	5);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "d2_qty",  		false, "", dfNullInteger, 	0,true, 	true,	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "d2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "d4_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "d4_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "d5_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "d5_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "d7_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "d7_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "r2_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "r2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "r5_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "r5_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "r9_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "r9_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "o2_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "o2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "o4_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "o4_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "o5_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "o5_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "s2_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "s2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "s4_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "s4_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "f2_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	50, daLeft, 		false,  "f2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "f4_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "f4_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "f5_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "f5_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "a2_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "a2_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "a4_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "a4_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 			45, daRight, 		false,  "a5_qty",  		false, "", dfNullInteger, 	0,true, 	true, 	5);
				InitDataProperty(0, cnt++, dtComboEdit, 	40, daLeft, 		false,  "a5_ut",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 		    65, daCenter, 		true,  "eff_end_dt",  	false, "", dfUserFormat,	0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 			50, daCenter, 		true,  "cfm_flg",  		false, "", dfNone, 			0,true, 	true);
				InitDataProperty(0, cnt++, dtData, 		   120, daCenter, 		true,  "upd_dt",  		false, "", dfUserFormat,	0,false, 	false);
				InitDataProperty(0, cnt++, dtData, 		   120, daLeft, 		true,  "upd_usr_nm",  	false, "", dfNone, 			0,false, 	false);
				
				InitDataProperty(0, cnt++, dtHidden,		80, daCenter, 		true,  "eff_st_dt",		false, "", dfNone,      0,false, false);
				InitDataProperty(0, cnt++, dtHidden, 		90, daRight, 		true,  "upd_usr_id",  	false, "", dfNone, 		0,false, false);
				InitDataProperty(0, cnt++, dtHidden, 		90, daRight, 		true,  "vsl_cd",      	false, "", dfNone, 		0,false, false);
				InitDataProperty(0, cnt++, dtHidden, 		90, daRight, 		true,  "skd_voy_no",  	false, "", dfNone, 		0,false, false);
				InitDataProperty(0, cnt++, dtHidden, 		90, daRight, 		true,  "skd_dir_cd",  	false, "", dfNone, 		0,false, false);

				InitDataProperty(0, cnt++, dtHidden, 	    40, daCenter, 		true,  "sort_id",  		false, "", dfNone, 		0,false, false);
				InitDataProperty(0, cnt++, dtHiddenStatus, 	10, daCenter, 		true,  "ibflag",  		false, "", dfNone, 		0,false, false);			
				
				InitDataValid(0, "pod_cd", vtEngUpOnly, "");
				
				sheetObj.InitUserFormat(0, "eff_end_dt", 	"####-##-##", "-" );
    			sheetObj.InitUserFormat(0, "upd_dt", 	 	"####-##-## ##:##:##", "-|:" );

				InitDataCombo (0 , "d2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "d4_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "d5_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "d7_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "r2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "r5_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "r9_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "o2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "o4_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "o5_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "s2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "s4_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "f2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "f4_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "f5_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "a2_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "a4_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
				InitDataCombo (0 , "a5_ut" ,    " |"+glinetpText,	" |"+glinetpCode);
			}

		break;
	}
}

/**
 * OnKeyPress 이벤트 처리
 */
function form_keypress() {
	var formObject = document.form;
	switch (event.srcElement.name) {
		case "s_sub_loc_cd":
			ComKeyOnlyAlphabet('upper');// 알파벳 대문자,숫자만 입력허용
		break;
			
	}
}

/**
 * 설  명 : Form Object Event - onBlur <br>
 * @author SHIN DONG IL
 * @version 2013.05.27
 */
function form_focus(){
	var formObj = document.form;
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "s_eta_dt":
			formObj.s_eta_dt.value = ComTrimAll(formObj.s_eta_dt.value, "-");
		break;
		
		case "s_eff_st_dt":
			formObj.s_eff_st_dt.value = ComTrimAll(formObj.s_eff_st_dt.value, "-");
		break;
		
		case "s_eff_end_dt":
			formObj.s_eff_end_dt.value = ComTrimAll(formObj.s_eff_end_dt.value, "-");
		break;
	}
}

/**
 * 설  명 : Form Object Event - onBlur <br>
 * @author SHIN DONG IL
 * @version 2013.05.27
 */
function form_blur(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "s_eta_dt":
			formObj.s_eta_dt.value = ComGetMaskedValue(formObj.s_eta_dt.value, "ymd");
		break;
			
		case "s_eff_st_dt":
			formObj.s_eff_st_dt.value = ComGetMaskedValue(formObj.s_eff_st_dt.value, "ymd");
			
			// 기준일로부터 30일 이후 일자 자동 셋팅
			if (ComTrimAll(formObj.s_eff_st_dt) != "") {
				
				formObj.s_eff_end_dt.value = ComGetDateAdd(formObj.s_eff_st_dt.value, "D", 30, "-");
			}
			
			var diffDay = ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
			
			if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.s_eff_end_dt.value = "";
					formObj.s_eff_end_dt.focus();
					return false;
				}
			}
			
		break;
		
		case "s_eff_end_dt":
			formObj.s_eff_end_dt.value = ComGetMaskedValue(formObj.s_eff_end_dt.value, "ymd");
			
			if (ComTrimAll(formObj.s_eff_st_dt) != "" && ComTrimAll(formObj.s_eff_end_dt) != "") {
				var diffDay = ComGetDaysBetween(formObj.s_eff_st_dt, formObj.s_eff_end_dt);
				
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.s_eff_end_dt.value = "";
					formObj.s_eff_end_dt.focus();
					return false;
				}
			}
		break;
			
		case "s_sub_loc_cd":
			if (ComTrimAll(formObj.s_sub_loc_cd) != "") {
				formObj.f_cmd.value = SEARCH01;
				
				var sXml = sheetObj.GetSearchXml("EES_EQR_1008GS.do", FormQueryString(formObj));
				var sCheck = ComGetEtcData(sXml, "check");
				if (sCheck != "T") {
					ComShowCodeMessage("EQR01005");
					formObj.s_sub_loc_cd.value = "";
				}
			}
		break;
	}
		
}


/*
 * Container Type Combo OnChange Event
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
	setGridHidden(comboObj.Code);
	var arr_combo_cd = value.split(",");
	
	//Priority ComboBox Code 설정
	pri_combo_cd = "";
	for (var i = 0; i < arr_combo_cd.length; i++) {
		pri_combo_cd = pri_combo_cd + (i + 1) + "|";
	}
	
	pri_combo_cd = pri_combo_cd.substring(0, pri_combo_cd.length - 1);
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
 * @param {int} code 필수 Onclick 이벤트가 발생한 해당 sub trade code
 * @param {int} text 필수 화면에 표시된 글자(Trade code)
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
function setGridHidden(tpsz_cd){
	var sheetObj = sheetObjects[0];
	var arr_tpsz = tpsz_cd.split(",");

	for(var i=0;i<consTpszArr.length;i++){ //전체의 Container Type/Size

		sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_qty")= !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());
		sheetObj.ColHidden(consTpszArr[i].toLowerCase()+"_ut") = !isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase());

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
 * 조회 완료 이벤트 후 로직 <br>
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

}

 /**
 * 셀을 마우스 클릭했을때 발생하는 이벤트 <br>
 */
function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	
    switch (sheetObj.ColSaveName(Col)) {
        case "repo_gline_rmk":
			var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
			if(sheetObj.CellValue (mrg_fm_row,"cfm_flg")!="1"){ // Guideline Header일 경우만.
	            sheetObj.CellEditable(Row, Col) = false;
			 	//ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax, bEventRaise)
			 	if (formObj.main_page.value == "true") {//Guideline Creation 화면일 경우
					ComShowMemoPad(sheetObj, Row, Col, false, 300, 200, 1000, true);
				}else {//Guideline Inquiry 화면일 경우
					ComShowMemoPad(sheetObj, Row, Col, true, 300, 200, 1000, true);
				}
				
			}
        break;

		case "d2_ut":
		case "d4_ut":
		case "d5_ut":
		case "d7_ut":
		case "r2_ut":
		case "r5_ut":
		case "r9_ut":
		case "o2_ut":
		case "o4_ut":
		case "o5_ut":
		case "s2_ut":
		case "s4_ut":
		case "f2_ut":
		case "f4_ut":
		case "f5_ut":
		case "a2_ut":
		case "a4_ut":
		case "a5_ut":
			if (sheetObj.CellValue(Row, "sort_id") == "1") {// Gudideline Header일 경우 콤보박스
				sheetObj.CellComboItem(Row, Col, " |" + pri_combo_cd, " |" + pri_combo_cd);
			}else {
				sheetObj.CellComboItem (Row, sheetObj.ColSaveName(Col), " |"+glinetpText," |"+glinetpCode);
			}
		break;

    }
}

// Grid Change Event
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	//Priority와 % rate는 같은 Table에 들어가야 하기때문에  Ibflag 상태는 한쌍으로 변경한다.
	if(sheetObj.CellValue(Row,"sort_id")=="1" && sheetObj.CellValue(Row,"ibflag") == "U"){
		sheetObj.CellValue(Row+1,"ibflag") = "U";	
	}if (sheetObj.CellValue(Row, "sort_id") == "2" && sheetObj.CellValue(Row,"ibflag") == "U") {
		sheetObj.CellValue(Row-1,"ibflag") = "U";
	}

	 switch (sheetObj.ColSaveName(Col)) {
	 	case "pod_cd":
			var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
			var mrg_to_row = Number(sheetObj.GetMergedEndCell(sheetObj.SelectRow,"pol_cd").split(",")[0]);
			var dup_cnt = 0;
			var chk_pol_cd = "";
			
			for(var i=mrg_fm_row; i <=mrg_to_row; i++){
				if(sheetObj.CellValue(i,"pod_cd") == Value){
					dup_cnt++
				}
			}
			
			if(dup_cnt > 1){//중복 POD Chcek
				sheetObj.CellValue(Row,"pod_cd") = "";
				ComShowCodeMessage("EQR01114");//중복된 POD가 있습니다.';				
			}

			// POD CD 유효성 체크
			if(sheetObj.CellValue(Row, "sort_id") == "3"){  //POD열일경우
				if (Value != "") {
					formObj.f_cmd.value = SEARCH03;
					sXml = sheetObj.GetSearchXml("EES_EQR_1008GS.do", FormQueryString(formObj) + "&pod_cd=" + Value);
					
					chk_pol_cd = ComGetEtcData(sXml, "chk_pod_cd");
				}
				
			}
			
			if(dup_cnt > 1){//중복 POD Chcek
				sheetObj.CellValue(Row,"pod_cd") = "";
				ComShowCodeMessage("EQR01114");//중복된 POD가 있습니다.';				
			}else if(chk_pol_cd == "F"){
					ComShowCodeMessage('EQR01103',"POD"); //유효하지 않은 POD입니다.
					sheetObj.CellValue2(Row,"pod_cd") = "";
					return;		
			}

		break;
		
		case "repo_gline_rmk":
	
			var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
			var mrg_to_row = Number(sheetObj.GetMergedEndCell(sheetObj.SelectRow,"pol_cd").split(",")[0]);
			sheetObj.MergeSheet = msNone;
			for (var i = mrg_fm_row; i <= mrg_to_row; i++) {
				sheetObj.CellValue2(i,"repo_gline_rmk") = Value;
			}
			sheetObj.MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		break;
		
		case "d2_ut":
		case "d4_ut":
		case "d5_ut":
		case "d7_ut":
		case "r2_ut":
		case "r5_ut":
		case "r9_ut":
		case "o2_ut":
		case "o4_ut":
		case "o5_ut":
		case "s2_ut":
		case "s4_ut":
		case "f2_ut":
		case "f4_ut":
		case "f5_ut":
		case "a2_ut":
		case "a4_ut":
		case "a5_ut":
		    //Unit Code가 REST일 경우 QTY항목을 초기화 한다.
			if(Value=="R"){
				var col_nm = (sheetObj.ColSaveName(Col)).substring(0,2)+'_qty';
				sheetObj.CellValue(Row,col_nm) = "";
			}
		break;
		
		case "cfm_flg":
			if(sheetObj.CellValue(Row,"sort_id")=="1"){
				var search_cfm_flg = sheetObj.CellSearchValue(Row, "cfm_flg");
				if(search_cfm_flg == "1" && search_cfm_flg != Value){
					if (ComGetDaysBetween(sheetObj.CellValue(Row, "eff_st_dt"), formObj.h_eta_dt.value) > 0) {
						sheetObj.CellValue2(Row, "cfm_flg")='1';
						ComShowCodeMessage("EQR01108");//Confirm 취소할 수 없습니다.
					}
				}
			}
		break;		
	}
}

// 저장후 메세지 표현
function sheet1_OnSaveEnd(sheetObj, errMsg){
	var formObj = document.form;
	
	if (errMsg == "") {
		ComShowCodeMessage("EQR01001");
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}

// POD Add버튼 클릭시 Row Add
function pod_row_add(sheetObj){
	if(sheetObj.RowCount > 0){
		if(sheetObj.cellvalue(sheetObj.SelectRow,"sort_id")!="1"){
			sheetObj.DataInsert();
			sheetObj.CellEditable(sheetObj.SelectRow, "pol_cd") 	= true;	
			sheetObj.cellvalue(sheetObj.SelectRow,"trd_cd") 		= sheetObj.cellvalue(sheetObj.SelectRow-1,"trd_cd");
			sheetObj.cellvalue(sheetObj.SelectRow,"sub_trd_cd") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"sub_trd_cd");
			sheetObj.cellvalue(sheetObj.SelectRow,"vsl_lane_cd") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"vsl_lane_cd");
			sheetObj.cellvalue(sheetObj.SelectRow,"vvd") 			= sheetObj.cellvalue(sheetObj.SelectRow-1,"vvd");
			sheetObj.cellvalue(sheetObj.SelectRow,"eta_dt") 		= sheetObj.cellvalue(sheetObj.SelectRow-1,"eta_dt");
			sheetObj.cellvalue(sheetObj.SelectRow,"repo_gline_rmk")	= sheetObj.cellvalue(sheetObj.SelectRow-1,"repo_gline_rmk");
			sheetObj.cellvalue(sheetObj.SelectRow,"eff_st_dt") 		= sheetObj.cellvalue(sheetObj.SelectRow-1,"eff_st_dt");
			sheetObj.cellvalue(sheetObj.SelectRow,"eff_end_dt") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"eff_end_dt");
			sheetObj.cellvalue(sheetObj.SelectRow,"pol_cd") 		= sheetObj.cellvalue(sheetObj.SelectRow-1,"pol_cd");
			sheetObj.cellvalue(sheetObj.SelectRow,"eq_gline_seq") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"eq_gline_seq");
			sheetObj.cellvalue(sheetObj.SelectRow,"sort_id") 		= "3";
			sheetObj.cellvalue(sheetObj.SelectRow,"vsl_cd") 		= sheetObj.cellvalue(sheetObj.SelectRow-1,"vsl_cd");
			sheetObj.cellvalue(sheetObj.SelectRow,"skd_voy_no") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"skd_voy_no");
			sheetObj.cellvalue(sheetObj.SelectRow,"skd_dir_cd") 	= sheetObj.cellvalue(sheetObj.SelectRow-1,"skd_dir_cd");
			//Confirm flag 비활성화
			sheetObj.CellEditable(sheetObj.SelectRow,"cfm_flg") 	=  false;
			
		}
	}else{
		ComShowCodeMessage("EQR01104");//조회된 데이터가 없습니다
		return;
	}
}

/**
 * Amend Button Click시 제약조건
 * 조회된 TRADE, SUB TRADE,LANE의 마지막 차수에서만 AMEND가능하다. 
 */
function validateAmend() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var rtn_val = true;
	
	var str_trd_cd 			= sheetObj.cellvalue(sheetObj.SelectRow,"trd_cd") ;
	var str_sub_trd_cd 		= sheetObj.cellvalue(sheetObj.SelectRow,"sub_trd_cd");
	var str_vsl_lane_cd 	= sheetObj.cellvalue(sheetObj.SelectRow,"vsl_lane_cd"); 
	var str_eq_gline_seq 	= sheetObj.cellvalue(sheetObj.SelectRow,"eq_gline_seq");

	var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
	
	formObj.f_cmd.value = SEARCH02;

    sXml = sheetObj.GetSearchXml("EES_EQR_1008GS.do" ,FormQueryString(formObj)+"&str_trd_cd="+str_trd_cd+"&str_sub_trd_cd="+str_sub_trd_cd+"&str_vsl_lane_cd="+str_vsl_lane_cd+"&str_eq_gline_seq="+str_eq_gline_seq);
	
	//선택된 ROW가 최종 CONFIRM여부 확인
	var max_gline_seq = ComGetEtcData(sXml,"max_gline_seq");
	if(sheetObj.CellValue(mrg_fm_row,"cfm_flg") == "0"){
		ComShowCodeMessage('EQR01112');
		rtn_val = false;		
	}else if(str_eq_gline_seq != max_gline_seq){
		ComShowCodeMessage('EQR01117');
		rtn_val = false;
	}
	
	return rtn_val;
}

/**
 * New 버튼 클릭시 화면 초기화.
 */
function init_form() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	formObj.s_dt_tp_cd[0].checked= true;	
	formObj.s_eta_dt.value = formObj.h_eta_dt.value;
	
	formObj.s_eff_st_dt.value = "";
	formObj.s_eff_end_dt.value = "";
	
	formObj.trade.Code ="";
	formObj.subtrade.Code ="";
	formObj.lane.Code = "";
	formObj.lane_direct.value = ""; // lane code 입력값 초기화
	
	//CNTR TY/SZ DRY로 설정
	formObj.tpsz.value ="D";
	tpszChange("D");
	
	formObj.s_cfm_flg.value = "";
	
	formObj.s_loc_cd.value="";
	formObj.s_sub_loc_cd.value="";
	
	sheetObj.RemoveAll();

}

/**
 * Guideline Del, POD Add, POD Del시 
 * Confirm 유무 체크
 * Confirm된 건은 수정불가.
 * */
function check_confirm() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var rtn_val = true;
	var mrg_fm_row = 0 ;
	
	if (sheetObj.RowCount > 0) {
	
		var mrg_fm_row = Number(sheetObj.GetMergedStartCell(sheetObj.SelectRow, "pol_cd").split(",")[0]);
		
		if (sheetObj.CellValue(mrg_fm_row, "cfm_flg") == "1") {
			rtn_val = false;
		}
	}
	
	return rtn_val;
}

/**
 * Date Type 변경시 이벤트 처리 
 */
function chg_dt_tp() {
	var formObj = document.form;
	
	if(formObj.s_dt_tp_cd[0].checked){
		formObj.s_eta_dt.value = formObj.h_eta_dt.value;
		formObj.s_eff_st_dt.value = "";
		formObj.s_eff_end_dt.value = "";
		
		ComEnableObject(formObj.s_eta_dt,true);
		ComEnableObject(formObj.s_eff_st_dt,false);
		ComEnableObject(formObj.s_eff_end_dt,false);
		ComEnableObject(formObj.btns_calendar,false);
		
		document.getElementById("s_eta_dt").className = "input1";
		
	}else if(formObj.s_dt_tp_cd[1].checked){
		formObj.s_eta_dt.value = "";
		ComEnableObject(formObj.s_eta_dt,false);
		ComEnableObject(formObj.s_eff_st_dt,true);
		ComEnableObject(formObj.s_eff_end_dt,true);
		ComEnableObject(formObj.btns_calendar,true);

		document.getElementById("s_eff_st_dt").className = "input1";
		document.getElementById("s_eff_end_dt").className = "input1";
		

	}
}

/**
 * 설  명 : To Date = From Date + 30  <br>
 * <br><b>Example : </b>
 * <pre>
 *     calToDate()
 * </pre>
 * @see #링크연결
 * @author 작성자
 * @version 2009.01.01
 */
function calToDate(){
	formObj = document.form;
	var to_dt = calc_Date(formObj.eff_st_dt.value,30,true);

	if (formObj.eff_st_dt.value != "" && to_dt == "") {
		ComShowCodeMessage('EQR90222','YYYY-MM-DD');
		formObj.eff_st_dt.value = "";
		formObj.eff_end_dt.value = "";
		formObj.eff_st_dt.focus();
		return false;
	} else {
		formObj.eff_end_dt.value = to_dt;
	}
}