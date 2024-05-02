/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_LEA_0021.js
 *@FileTitle : Accrual Adjustment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.21
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.08.28 민정호
 * 1.0 Creation
 * 
 * 2011.10.31 [CHM-201114105] [LEA] ALPS UI에 조정계수 입력화면 Accrual Adjustment 추가
 * 2011.12.26 [CHM-201115071] [LEA] Full Volume Incentive Auto 변환 관련 화면변경 요청
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
 * @extends
 * @class ESD_LEA_0021 : ESD_LEA_0021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_LEA_0021() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.setComboObject 		= setComboObject;    	
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.obj_blur				= obj_blur;
	this.obj_focus				= obj_focus;
	this.obj_keypress			= obj_keypress;    	    	
	this.doActionIBSheet 		= doActionIBSheet;
	this.setTabObject 			= setTabObject;
	this.validateForm 			= validateForm;
}

/* 개발자 작업	*/
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var isRetrieve = 0;				// 조회 버튼 실행 여부
var isApply = 0;				// 배치실행여부
var isSave = 0;					// 저장 버튼 실행 여부 

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	
	isRetrieve = 0;				// 조회시 Verify하지 않는다.
	isApply = 0;				// 배치실행여부
	isSave = 0;					// 저장
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			isRetrieve = 1;				// 조회시 Verify하지 않는다.
			sheetObject.RemoveAll();
			resetFormData();
			doActionIBSheet(sheetObject,document.form,IBSEARCH);			
			break;
		case "btn_reset":
			if(sheetObject.RowCount < 1){
				return;
			}
			resetFormData();			
			for(var i=1; i<sheetObject.RowCount+1; i++){				
				sheetObject.Cellvalue(i,'accl_adj_fctr_rt') = 1;
				sheetObject.Cellvalue(i,'verify') = '';				
				sheetObject.Cellvalue(i,'accl_adj_fctr_cfm_flg') = '';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_proc_cd') = '';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_st_dt') = '';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_end_dt') = '';
				sheetObject.CellEditable(i, "accl_adj_fctr_rt") = true;
			}			
			break;			
		case "btn_save":
			if(sheetObject.RowCount < 1){
				return;
			}
			isSave = 1;			// 저장시구분
			resetFormData();
			for(var i=1; i<sheetObject.RowCount+1; i++){							
				sheetObject.Cellvalue(i,'verify') = '';				
				sheetObject.Cellvalue(i,'accl_adj_fctr_cfm_flg') = 'N';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_proc_cd') = 'N';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_st_dt') = '';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_end_dt') = '';					
			}			
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);				
			break;			
		case "btn_verify":
			if(sheetObject.RowCount < 1){
				return;
			}
			chkVerify();
			ComBtnEnable( "btn_confirm" );
			break;
		case "btn_confirm":
			if(sheetObject.RowCount < 1){
				return;
			}
			for(var i=1; i<sheetObject.RowCount+1; i++){
				sheetObject.Cellvalue(i,'accl_adj_fctr_cfm_flg') = 'Y';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_proc_cd') = 'N';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_st_dt') = '';
				sheetObject.Cellvalue(i,'accl_adj_fctr_aply_end_dt') = '';					
			}
			doActionIBSheet(sheetObjects[0],document.form,IBSAVE);		
			ComBtnDisable( "btn_confirm" );
			break;
		case "btn_apply":
			if(sheetObject.RowCount < 1){
				return;
			}
			chkVerify();
			isApply = 1;				// 배치실행여부			
			doActionIBSheet(sheetObjects[0],document.form,IBINSERT);	
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
			break;
		case "btn_downexcel":		
			if(sheetObject.RowCount < 1){
				return;
			}
			doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
			break;			
		case "btn_finalize":
			if(sheetObject.RowCount < 1){
				return;
			}
			doActionIBSheet(sheetObjects[0],document.form,MULTI03);	
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
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	resetFormData();
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //IBSheet1 init
		with (sheetObj) {
			//높이 설정
			style.height = 400;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 10, 100);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			// ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize],
			// [RowMove],[Head3D])
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "Exe.Month|Rev.Month|Accrual Type|Accrual Adjustment|Verify Result||||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "exe_yrmon", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "rev_yrmon", 		false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "accl_lgc_tp_cd", 	false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 250, daCenter, true, "accl_adj_fctr_rt", false, "", dfNumber, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "verify", 			false, "", dfNone, 0, false, false);			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "accl_adj_fctr_cfm_flg");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "accl_adj_fctr_aply_proc_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "accl_adj_fctr_aply_st_dt", false, "", dfUserFormat2, 0, false, false);		
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "accl_adj_fctr_aply_end_dt",false, "", dfUserFormat2, 0, false, false);	
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "adjustment_apply_flag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "accl_adj_fctr_fnl_flg");
			InitDataProperty(0, cnt++, dtHiddenStatus, 0,    daCenter,  false,   "ibflag");
			
			InitUserFormat2(0, "accl_adj_fctr_aply_st_dt", "####-##-## ##:##:##", "-|:" );
			InitUserFormat2(0, "accl_adj_fctr_aply_end_dt", "####-##-## ##:##:##", "-|:" );			
			
			SelectHighLight = false;
			FocusAfterProcess = false;			
		}
		break;
	}
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		formObj.date_sts.value = '0';	
		if(formObj.exe_yrmon.value.substring(0,4) >= 2012 && formObj.exe_yrmon.value.substring(5,7)>=6){
			formObj.date_sts.value = '1';
		}
		sheetObj.DoSearch("ESD_LEA_0021GS.do", FormQueryString(formObj));
		sheetObj.FocusAfterProcess = false;
		ComOpenWait(false);		
		break;
	case IBSAVE:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		sheetObj.DoSave("ESD_LEA_0021GS.do", FormQueryString(formObj),-1,false);
		ComOpenWait(false);		
		break;
	case IBINSERT:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI01;		
		if(sheetObj.CellValue(1,"adjustment_apply_flag") == "1"){
			sheetObj.CellValue(1,"adjustment_apply_flag") = "2";
		}else{
			sheetObj.CellValue(1,"adjustment_apply_flag") = "1";			
		}
		sheetObj.DoSave("ESD_LEA_0021GS.do", FormQueryString(formObj),-1,false);
		ComOpenWait(false);		
		break;		
	case IBDOWNEXCEL:
		if(sheetObj.RowCount > 0){
			sheetObj.Down2Excel(-1);
		}
		break;
	case IBSEARCH_ASYNC01: //Batch Start
		formObj.f_cmd.value = MULTI02;		
		var savexml = sheetObj.GetSaveXml("ESD_LEA_0021GS.do", FormQueryString(formObj));
		var msg = "";
	    if (savexml != "") sheetObj.LoadSaveXml(savexml,true);
	    if(sheetObj.EtcData("BATCH_EXE_RESULT") == "null"){
	    	msg = "Accrual Adjustment Starting!";
	    }else{	    	
	    	msg = sheetObj.EtcData("BATCH_EXE_RESULT");
	    }
	    ComShowMessage(msg);		
		break;
	case MULTI03:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		sheetObj.CellValue(1,"accl_adj_fctr_fnl_flg") = "Y";
		formObj.f_cmd.value = MULTI03;
		sheetObj.DoSave("ESD_LEA_0021GS.do", FormQueryString(formObj),-1,false);
		ComOpenWait(false);				
		break;
	}
}

/**
 * 저장 후 실행
 */
function sheet1_OnSaveEnd(sheetObj,ErrMsg){	
	var saveMsgFlg = ComIsNull(ErrMsg);
	if(isApply == 0){		
		if (saveMsgFlg) {
			ComShowCodeMessage("LEA90026");  //Data Saved Successfully!!
		} else {
			ComShowCodeMessage("LEA90027");  //Data Save Action Failed!!
			return;
		}
		
	    if(document.form.exe_yrmon.value!=""){
	    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
	    }
	}else{
		ComBtnDisable( "btn_apply" );		// isApply == 1		
	}
}

/**
 * 조회 후 실행
 */
function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	if(sheetObj.CellValue(1,'accl_adj_fctr_cfm_flg') == 'Y'){
		document.form.confirmInfo.value = 'Adjustment is confirmed.';
		document.form.applyStartDate.value = fDate(sheetObj.CellValue(1,'accl_adj_fctr_aply_st_dt'));
		document.form.finishDate.value = fDate(sheetObj.CellValue(1,'accl_adj_fctr_aply_end_dt'));
		if(isRetrieve == 0){
			chkVerify();
		}				
	}else{
		document.form.confirmInfo.value = '';
		document.form.applyStartDate.value = '';
		document.form.finishDate.value = '';		
	}
		
	cellBackColor(sheetObj);
	
	if( ( sheetObj.CellValue(1,'accl_adj_fctr_cfm_flg') == 'Y' && sheetObj.CellValue(1,'accl_adj_fctr_aply_proc_cd') == 'N' )
		|| 	 ( sheetObj.CellValue(1,'accl_adj_fctr_cfm_flg') == 'Y' && sheetObj.CellValue(1,'accl_adj_fctr_aply_proc_cd') == 'F' ) ){
		ComBtnEnable( "btn_apply" );
	}else{
		ComBtnDisable( "btn_apply" );
	}
	
	if( sheetObj.CellValue(1,'accl_adj_fctr_cfm_flg') == 'Y' && sheetObj.CellValue(1,'accl_adj_fctr_aply_proc_cd') == 'P'){			// 진행중.
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_verify");
		ComBtnDisable("btn_confirm");
	}else{
		ComBtnEnable("btn_save");
		ComBtnEnable("btn_verify");
		ComBtnEnable("btn_confirm");		
	}
	
	if(isRetrieve == 1){
		ComBtnDisable( "btn_apply" );		
		ComBtnDisable( "btn_confirm" );		
	}
	
	if(isSave == 1){
		ComBtnDisable( "btn_confirm" );
	}

	if(sheetObj.CellValue(1,"accl_adj_fctr_fnl_flg") == 'Y'){		
		for(var i=1; i<sheetObj.RowCount+1; i++){				
			sheetObj.CellEditable(i, "accl_adj_fctr_rt") = false;
			sheetObj.CellValue(i,"verify") = '';
		}		
		cellBackColor(sheetObj);		
		ComBtnDisable( "btn_reset" );
		ComBtnDisable( "btn_save" );
		ComBtnDisable( "btn_verify" );
		ComBtnDisable( "btn_confirm" );
		ComBtnDisable( "btn_apply" );
		ComBtnDisable( "btn_finalize" );		
	}else{
		ComBtnEnable( "btn_reset" );
		if(document.form.finishDate.value != ''){
			ComBtnEnable( "btn_finalize" );
		}
	}	
}
 
 /**
  * 날짜형식
  */
function fDate(str){
	if(str.length == 14){
		return 	str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6,8) + " " +
				str.substring(8,10) + ":" + str.substring(10,12) + ":" + str.substring(12,14);
	}else{
		return "";
	}
}
 
/**
 * Verify
 */
function chkVerify(){
	var sheetObject = sheetObjects[0];
	var formObj = document.form;
	
	for(var i=1; i<sheetObject.RowCount+1; i++){
		var adjust = sheetObject.Cellvalue(i,'accl_adj_fctr_rt');
		var verifyMsg = "";			
		if(eval(adjust) > 1.5){ 
			verifyMsg = "Too large adjustment factor";
//		}else if(eval(adjust) == 0 || adjust == ''){
		}else if(eval(adjust) == 0){			
			verifyMsg = "Zero";
		}else if(eval(adjust) < 0.3){
			verifyMsg = "Too small adjustment factor";			
		}else{
			verifyMsg = "Normal";
		}					
		sheetObject.Cellvalue(i,'verify') = verifyMsg;
		
		if(verifyMsg == "Zero"){
			sheetObject.CellFontColor(i, 'verify') = sheetObject.RgbColor(255, 0, 0);		// red color
		}else if(verifyMsg != "Normal"){
			sheetObject.CellFontColor(i, 'verify') = sheetObject.RgbColor(0, 0, 255);		// blue color
		}else{
			sheetObject.CellFontColor(i, 'verify') = sheetObject.RgbColor(0, 0, 0);
		}
	}
}

/**
 * Form 초기화
 */
function resetFormData()  {
	document.form.confirmInfo.value = '';
	document.form.applyStartDate.value = '';
	document.form.finishDate.value = '';	
	
	ComBtnDisable( "btn_apply" );		
	ComBtnDisable( "btn_confirm" );
	ComBtnDisable( "btn_finalize" );
}

 
 /**
  * 입력시 셀의 값이 바뀌었을 때 발생
  */ 
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var sName = sheetObj.ColSaveName(Col);  
	if(sName == 'accl_adj_fctr_rt'){ 
		if(Value < 0){
			sheetObj.CellValue2(Row,Col) = 0;
		}
		if(Value >= 9999.0){
			sheetObj.CellValue2(Row,Col) = '';
		}
	}
}

  /**
   * 셀 칼라 표시
   */   
function cellBackColor(sheetObj){  
	sheetObj.RowBackColor(1) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(2) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(3) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(4) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(5) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(6) = sheetObj.RgbColor(255, 255, 255);
	
	sheetObj.RowBackColor(7) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(8) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(9) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(10) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(11) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(12) = sheetObj.RgbColor(231, 250, 246);
	
	sheetObj.RowBackColor(13) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(14) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(15) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(16) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(17) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(18) = sheetObj.RgbColor(255, 255, 255);	
		
	sheetObj.RowBackColor(19) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(20) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(21) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(22) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(23) = sheetObj.RgbColor(231, 250, 246);
	sheetObj.RowBackColor(24) = sheetObj.RgbColor(231, 250, 246);	
	
	sheetObj.RowBackColor(25) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(26) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(27) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(28) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(29) = sheetObj.RgbColor(255, 255, 255);
	sheetObj.RowBackColor(30) = sheetObj.RgbColor(255, 255, 255);
	if(document.form.exe_yrmon.value.substring(5,7)>5){
		sheetObj.RowBackColor(31) = sheetObj.RgbColor(231, 250, 246);
		sheetObj.RowBackColor(32) = sheetObj.RgbColor(231, 250, 246);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>6){
		sheetObj.RowBackColor(33) = sheetObj.RgbColor(255, 255, 255);
		sheetObj.RowBackColor(34) = sheetObj.RgbColor(255, 255, 255);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>7){
		sheetObj.RowBackColor(35) = sheetObj.RgbColor(231, 250, 246);
		sheetObj.RowBackColor(36) = sheetObj.RgbColor(231, 250, 246);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>8){
		sheetObj.RowBackColor(37) = sheetObj.RgbColor(255, 255, 255);
		sheetObj.RowBackColor(38) = sheetObj.RgbColor(255, 255, 255);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>9){
		sheetObj.RowBackColor(39) = sheetObj.RgbColor(231, 250, 246);
		sheetObj.RowBackColor(40) = sheetObj.RgbColor(231, 250, 246);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>10){
		sheetObj.RowBackColor(41) = sheetObj.RgbColor(255, 255, 255);
		sheetObj.RowBackColor(42) = sheetObj.RgbColor(255, 255, 255);	
	}
	if(document.form.exe_yrmon.value.substring(5,7)>11){
		sheetObj.RowBackColor(43) = sheetObj.RgbColor(231, 250, 246);
		sheetObj.RowBackColor(44) = sheetObj.RgbColor(231, 250, 246);	
	}
}
/* 개발자 작업  끝 */