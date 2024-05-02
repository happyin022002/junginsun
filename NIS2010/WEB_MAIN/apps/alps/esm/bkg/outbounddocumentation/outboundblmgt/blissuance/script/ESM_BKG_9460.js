/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_9460.js
*@FileTitle : 3rd Party Billing & Issue Request
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.24 조정민
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends 
 * @class esm_bkg_9460 : esm_bkg_9460 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_9460() {
	this.processButtonClick		= processButtonClick;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initControl            = initControl;
	this.doActionIBSheet 		= doActionIBSheet;
	this.validateForm 			= validateForm;
	//this.sheet1_OnClick      = sheet1_OnClick;
}

   	/* 개발자 작업	*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var iterator = "|$$|";

var arrMultiCombo;//멀티콤보 세팅할 변수

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		case "btn_retrieve":
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;
			
		case "btn_new":
			sheetObject.RemoveAll();
			formObject.reset();
			initControl();
			formObject.rqst_bl_tp_cd.Code = "";
			formObject.n3pty_bl_sts_cd.Code = "";
			break;
			
		case "btn_SRCH_SET": //조회조건 설정
			var param = "";

			ComOpenPopup("ESM_BKG_9461.do" + param, 400, 400, "PopupEsmBkg9461",
					"1,0,1,1,1", true);

			break;

		case "btn_detail":
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
			break;

		case "btns_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt,'yyyy-MM-dd');
			break;
			
			
		case "btn_Save":
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			
		case "btn_Excel":
			if (0<sheetObject.RowCount) {
				sheetObject.Down2Excel(-1);
			} else {
				ComShowCodeMessage("BKG01092");
			}
			break;
			
			
		case "btn_Credit":
			var selRows = sheetObject.FindCheckedRow("sel");
			if(selRows == ''){
				ComShowMessage(ComGetMsg("COM12189"));
				return false;
			}
			var idxArr = selRows.split("|");
			for(var ix=0;ix<idxArr.length-1;ix++){
				sheetObject.CellValue2(idxArr[ix],"n3pty_bl_sts_cd") = "C";
				sheetObject.CellValue2(idxArr[ix],"chg_flg") = "Y";
			}
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			
			break;
			
        case "btn_close":
	        	window.close();
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
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm("keydown",	"obj_keydown", formObject);
	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
	axon_event.addListenerFormat("focus", "form_onFocus", formObject);
	axon_event.addListenerFormat("blur" , "form_onBlur" , formObject);
	ComSetObjValue(formObject.rqst_from_dt, ComGetNowInfo());
	ComSetObjValue(formObject.rqst_to_dt, ComGetNowInfo());
	applyShortcut();
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
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();

	if(document.form.ui_id.value == "ESM_BKG_0079_08"){
//		document.form.pol_ofc_cd.value = document.form.strOfc_cd.value;
//		if (ComShowCodeConfirm("BKG95074")) {  //Do you want to confirm your request?
//			doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
//		}
		
		execScript('n = msgbox("Do you want to confirm your request?","4132")', "vbscript");
		if (n == 6) {
        	doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
	case 1:      //sheet1 init
		with (sheetObj) {
			//높이 설정
//			style.height = 140;
			style.height = 340;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//Sheet의 행 다중선택 불가
			MultiSelection = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 3, 100);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(29, 0, 0, true);

			//헤더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false);
			InitHeadMode(true, true, true, true, false,false);

			var HeadTitle1 = "||No|BKG No|POL|POD|3rd Party\nOffice|Payer\nCode|Payer\nName|Payer\nContact Detail|Payment\nStatus|3rd Party B/L\nStatus|Request Date|Approval/\nRejection Date|User ID|Remark|Attachment|VVD|ETD||||||||||";
			var HeadTitle2 = "||No|BKG No|POL|POD|3rd Party\nOffice|Payer\nCode|Payer\nName|Payer\nContact Detail|Payment\nStatus|3rd Party B/L\nStatus|Request Date|Approval/\nRejection Date|User ID|Remark|Attachment|VVD|ETD||||||||||";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true); 

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  30,  	 daCenter,  true,       "ibflag");
			InitDataProperty(0, cnt++,  dtDummyCheck,    30,     daCenter,  true,       "sel");
			InitDataProperty(0, cnt++ , dtSeq, 	         40,  	 daCenter,  true,       "seq");
			InitDataProperty(0, cnt++ , dtData, 	 	 90,     daCenter,  true,       "bkg_no",   		false,          "",      dfNone,      	  	0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 50,     daCenter,  true,   	"pol_cd",     		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 50,     daCenter,  true,   	"pod_cd",     		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 60,     daCenter,  true,   	"n3pty_ofc_cd",     false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 70,     daCenter,  true,   	"payr_cust_cd",     false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 100,     daCenter,  true,   	"payr_cust_nm",     false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 		 100,    daCenter,  true,   	"shpr_cntc_phn_no", false,          "",      dfNone,     		0,     true,        true);
			InitDataProperty(0, cnt++ , dtData,	         60,     daCenter,  true,   	"n3pty_pay_sts", 	false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtCombo,	 	 110,    daCenter,  true,   	"n3pty_bl_sts_cd", 	false,          "",      dfNone,     		0,     true,        true);
			InitDataProperty(0, cnt++ , dtData,    		 115,    daCenter,  true,   	"rqst_dt",   		false,          "",      dfNone,     		0,     false,       true);	
			InitDataProperty(0, cnt++ , dtData,    		 115,    daCenter,  true,   	"act_dt",   		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,      	 70,     daCenter,  true,   	"usr_id",     		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,     	 150,    daCenter,  true,   	"bl_rmk",     		false,          "",      dfNone,     		0,     true,        true);
//			InitDataProperty(0, cnt++ , dtHidden,      	 150,    daCenter,  true,   	"bl_atch",     		false,          "",      dfNone,     		0,     true,        true);
			InitDataProperty(0, cnt++,  dtPopup,          80,    daCenter,  true,       "bl_atch",          false,    		"",      dfNone,    		0,     true,        true);
			InitDataProperty(0, cnt++ , dtData,		 	 100,    daCenter,  true,   	"vvd", 				false,          "",      dfNone,     		0,     false,       true);		
			InitDataProperty(0, cnt++ , dtData, 	 	 100,    daCenter,  true,   	"etd_dt",   		false,          "",      dfNone,   			0,     false,       true);
			
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"chg_flg",   		false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"old_n3pty_bl_sts_cd",false,        "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"usr_eml",   		false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"pol_ofc_cd",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"bkg_ofc_cd",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"bkg_usr_id",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"frt_term_cd",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"n3pty_bl_chg_ttl_amt",false,       "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"bl_iss_ofc_cd",	false,     	    "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden, 	 	 100,    daCenter,  true,   	"accss_ofc_cd",		false,     	    "",      dfNone,   			0,     false,       true);
			
			InitDataCombo(0, "n3pty_bl_sts_cd","Requested|Approved|Rejected|Credit Confirmation", "R|A|X|C"); 
			InitDataValid(0, "shpr_cntc_phn_no", vtNumericOther, "-,/.");

			CountPosition = 2;
			sheetObj.FrozenCols = 5;

		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    // sheetObj.ShowDebugMsg = 1;
    switch(sAction) {
    
	case IBCLEAR:      //Combo조회
		//콤보 Value를 가져와서 화면에 세팅
		initCom(formObj);
		break;
		
	case IBSEARCH: //조회Retrieve
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
    		sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH;
         	sheetObj.DoSearch("ESM_BKG_9460GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		}
		
		var bntFlg = "Y";
		var cBntFlg = "Y";
		for(var ir=sheetObj.HeaderRows;ir<=sheetObj.RowCount+1;ir++ ){
			if((sheetObj.CellValue(ir,"n3pty_ofc_cd")!=formObj.strOfc_cd.value)
					&&(sheetObj.CellValue(ir,"bkg_ofc_cd")!=formObj.strOfc_cd.value)
					&&(sheetObj.CellValue(ir,"pol_ofc_cd")!=formObj.strOfc_cd.value)
					&&(sheetObj.CellValue(ir,"bkg_usr_id")!=formObj.strUsr_id.value)
					&&(sheetObj.CellValue(ir,"accss_ofc_cd")!='Y')){
				bntFlg = "N";
			}
			if((sheetObj.CellValue(ir,"n3pty_ofc_cd")!=formObj.strOfc_cd.value)&&(sheetObj.CellValue(ir,"accss_ofc_cd")!='Y')){
				cBntFlg = "N";
			}
			

		}
		if(bntFlg=="Y"){
			 ComBtnEnable("btn_Save");
		}else{
			ComBtnDisable("btn_Save");
		}
		if(cBntFlg=="Y"){
			 ComBtnEnable("btn_Credit");
		}else{
			ComBtnDisable("btn_Credit");
		}
		break;


 	case IBSAVE: // Save
 		
 		if(!validateForm(sheetObj,formObj,sAction)) return false;
		var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
		var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_9460GS.do", "f_cmd=" + MULTI + "&" +sParam);
		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			ComOpenWait(false, false);
			return false;
		}else if(State == "S"){
			ComShowCodeMessage('BKG00166');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
		
		
	    case COMMAND01: // 입력        
	      formObj.f_cmd.value = MULTI01;
	      // 2.저장처리
	      var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_9460GS.do", FormQueryString(formObj));
	      // 3.저장후 결과처리
	      var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
	      if(State == null){
	              fnExceptionMessage(sXml);
	      }
	      break; 

    }
}
  

/**
* fnExceptionMessage  
* 에러처리 메세지 
* @param 
* @return 
*/
function fnExceptionMessage(rXml){
	var rMsg = ComGetEtcData(rXml,"Exception")
	var rmsg = rMsg.split("<||>");
	if(rmsg[3] != undefined && rmsg[3].length > 0) {
		ComShowMessage(rmsg[3]);
	}else{
		sheetObjects[0].LoadSaveXml(rXml);
	}
}

/*
 * 폼의 콤보박스 값을 설정한다.
 * */
function initCom(formObject){    
	formObject.f_cmd.value = INIT;
	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_9460GS.do", FormQueryString(formObject));
	arrMultiCombo = sXml.split(iterator); 
	ComXml2ComboItem(arrMultiCombo[0], formObject.rqst_bl_tp_cd, "val", "name");
	ComXml2ComboItem(arrMultiCombo[1], formObject.n3pty_bl_sts_cd, "val", "name");

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:	//retrieve
			if( formObj.rqst_from_dt.value == "" && formObj.bkg_no.value == ""){
				ComShowCodeMessage( "COM12114", "Request DT"  );
				formObj.rqst_from_dt.focus();
				return false;
			}
			if( formObj.rqst_to_dt.value == "" && formObj.bkg_no.value == ""){
				ComShowCodeMessage( "COM12114", "Request DT"  );
				formObj.rqst_to_dt.focus();
				return false;
			}
			if (formObj.rqst_from_dt.value != "" && formObj.rqst_to_dt.value != "") {
				if (ComGetDaysBetween(formObj.rqst_from_dt,formObj.rqst_to_dt) < 0) {
					ComShowMessage(msgs['BKG00818']);
					return false;
				}
			}

		
			
			break;
			
		case IBSAVE:

//			for(var ir=sheetObj.HeaderRows ;ir<=sheetObj.RowCount+1 ;ir++ ){
//				if(sheetObj.CellValue(ir,"chg_flg")=="Y" && sheetObj.CellValue(ir,"n3pty_ofc_cd")!=formObj.strOfc_cd.value){
//					ComShowCodeMessage("BKG95071", "approve or reject");
//					return false;
//				}
//
//			}
			break;

		}
	}

    return true;
}


 /**
 * 마우스 IN일때 
 */
function form_onFocus(){
	//입력Validation 확인하기
	switch(event.srcElement.name){	
    	case "rqst_from_dt":
    		ComClearSeparator(event.srcElement);
			break;
    	case "rqst_to_dt":
    		ComClearSeparator(event.srcElement);
			break;
	}
}

/**
 *  마우스 OUT할 때
 */	
function form_onBlur(){
	switch(event.srcElement.name){
    	case "rqst_from_dt":
    		ComAddSeparator(event.srcElement);
			break;
    	case "rqst_to_dt":
    		ComAddSeparator(event.srcElement);
			break;
	}
}

/**
 *  Enter 버튼 누를 시 조회처리
 */	
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var formObj  = document.form;

	if ( vKeyCode == 13 ) { //엔터키가 눌러졌을때
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	return true;
}

/**
 *  현재시각 표시
 *  부모창의 재조회 없이 ibSheet 에 저장 시각을 업데이트하기 위해
 *  시각 정보를 기존 데이터의 형식에 맞춰서 구성. 
 */	
function returnTime(now) {
	
	var time = now.getYear() + "-" ;
	time = time + lpad((now.getMonth()+1)) + "-" ; //0부터 시작하기 때문에 getMonth+1 값이 실제 월 값.
	time = time + lpad(now.getDate()) + " " ;
	time = time + lpad(now.getHours()) + ":" ;
	time = time + lpad(now.getMinutes()) ;
	return time;
	
}
function sheet1_OnSearchEnd(sheetObject, ErrMsg) {
	var formObj = document.form;
    with (sheetObject) {
        ColFontUnderline("bkg_no") = true;
        ColFontColor("bkg_no") = RgbColor(0,0,255);
        
		for(var ir=HeaderRows;ir<=RowCount+1;ir++ ){
			if((CellValue(ir,"n3pty_ofc_cd")!=formObj.strOfc_cd.value)
					&&(CellValue(ir,"bkg_ofc_cd")!=formObj.strOfc_cd.value)
					&&(CellValue(ir,"pol_ofc_cd")!=formObj.strOfc_cd.value)
					&&(CellValue(ir,"bkg_usr_id")!=formObj.strUsr_id.value)
					&&(CellValue(ir,"accss_ofc_cd")!='Y')){
				CellEditable(ir,"bl_atch") = false;
			}			
		}
    }
}

function sheet1_OnDblClick(sheetObject, row, col) {
	openBkgMainPopup(sheetObject, row, col);
}
function openBkgMainPopup(sheetObject, row, col) {
	if ("bkg_no"==sheetObject.ColSaveName(col)) {
		var bkg_no = sheetObject.CellValue(row, "bkg_no");
		if (""==bkg_no) {
			ComShowCodeMessage("BKG08017");  //BKG No. not exists
			return;
		}
		//freezing관련 수정
//		ComOpenWindowCenter("ESM_BKG_0079.do?pgmNo=ESM_BKG_0079&bkg_no="+bkg_no+"&mainPage=false", "ESM_BKG_0079", 1024, 768, false);
		comBkgCallPopBkgDetail(bkg_no);   
	}
}
function sheet1_OnChange(sheetObj, Row, Col, Value){
  	var formObj = document.form;

  	if(sheetObj.ColSaveName(Col) == "n3pty_bl_sts_cd"){
  		
  		
  		if(sheetObj.CellValue(Row, Col) != sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd")){

  			sheetObj.CellValue(Row, "chg_flg") = "Y";

  			if((sheetObj.CellValue(Row, "pol_ofc_cd")==formObj.strOfc_cd.value)
  					||(sheetObj.CellValue(Row, "bkg_ofc_cd")==formObj.strOfc_cd.value)
  					||(sheetObj.CellValue(Row, "bkg_usr_id")==formObj.strUsr_id.value)){
  				//X일때만 R로 변경가능

  				if(sheetObj.CellValue(Row, "n3pty_bl_sts_cd")!="R"
  					||sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd")!="X"){
  					sheetObj.CellValue(Row, "chg_flg") = "";
  					sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd");
  					ComShowCodeMessage("BKG95071", "change Status for this BKG");
  					return false;
  				}
  				
  				
  				
  			}else if(sheetObj.CellValue(Row, "n3pty_ofc_cd")==formObj.strOfc_cd.value
  					||sheetObj.CellValue(Row, "accss_ofc_cd")=="Y"){
  				if(sheetObj.CellValue(Row, Col)=="R"){
  		  	  		sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd");
  		  			sheetObj.CellValue2(Row, "chg_flg")="";
  		  		ComShowCodeMessage("BKG95071", "request this BKG");
  		  			return false;
  				}
  				
  				if(sheetObj.CellValue(Row, "n3pty_bl_sts_cd")=="A"
  					&& sheetObj.CellValue(Row,"n3pty_pay_sts")=="N"){
  					sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd");
  					sheetObj.CellValue2(Row, "chg_flg")="";
  					ComShowMessage(msgs['BKG95072']);
  					return false;
  				}
  				
//  				if(sheetObj.CellValue(Row, "n3pty_bl_sts_cd")=="C"){
//  					sheetObj.CellValue2(Row, "chg_flg")="";
//  				}
  				
  			}
  			
  			
  		}else{
  			sheetObj.CellValue(Row, "chg_flg") = "";
  		}

		

		


  	}else if(sheetObj.ColSaveName(Col) == "shpr_cntc_phn_no"
  		||sheetObj.ColSaveName(Col) == "bl_rmk"
  		||sheetObj.ColSaveName(Col) == "bl_atch"){
  		
			if((sheetObj.CellValue(Row, "pol_ofc_cd")==formObj.strOfc_cd.value)
  					||(sheetObj.CellValue(Row, "bkg_ofc_cd")==formObj.strOfc_cd.value)){
  				//정보변경시에 POL OFC,BKG OFC인 경우에 n3pty_bl_sts_cd R로 자동세팅

  				if(sheetObj.CellValue(Row, "old_n3pty_bl_sts_cd")=="X"){
  					sheetObj.CellValue(Row, "n3pty_bl_sts_cd") = "R";
  				}
  				
  				
  				
  			}
  	}

}



function sheet1_OnPopupClick(sheetObj, row, col){
	
    var col_name = sheetObj.ColSaveName(col);
	switch(col_name) {
		
		case "bl_atch":
			var bkg_no = sheetObj.cellValue(row, "bkg_no");
			var pol_cd = sheetObj.cellValue(row, "pol_cd");
			var n3pty_ofc_cd = sheetObj.cellValue(row, "n3pty_ofc_cd");
			var payr_cust_cnt_cd = sheetObj.cellValue(row, "payr_cust_cd").substring(0,2);
			var payr_cust_seq = Number(sheetObj.cellValue(row, "payr_cust_cd").substring(3))+"";
			var obl_iss_ofc_cd = sheetObj.cellValue(row, "bl_iss_ofc_cd");
			var n3pty_bl_chg_ttl_amt = sheetObj.cellValue(row, "n3pty_bl_chg_ttl_amt");
			var frt_term_cd = sheetObj.cellValue(row, "frt_term_cd");
			
			var url = "ESM_BKG_9463.do?bkg_no="+bkg_no+"&pol_cd="+pol_cd+"&n3pty_ofc_cd="+n3pty_ofc_cd
			+"&payr_cust_cnt_cd="+payr_cust_cnt_cd+"&payr_cust_seq="+payr_cust_seq
			+"&obl_iss_ofc_cd="+obl_iss_ofc_cd+"&n3pty_bl_chg_ttl_amt="+n3pty_bl_chg_ttl_amt
			+"&frt_term_cd="+frt_term_cd;
			ComOpenWindowCenter(url, "ESM_BKG_9463", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남

			
		break;

	}		
}

/**
 *  10 이하의 데이터 앞에 0을 붙이기 위해 lpad 함수 작성
 */	
function lpad(value) {

	if (value < 10){
		value = "0" + value 
	}
	return value;
}


	