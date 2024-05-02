/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1119.js
*@FileTitle : Korea B/L Application List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.01
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.12.01 김종호
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * @extends 
 * @class esm_bkg_1119 : esm_bkg_1119 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1119() {
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
			doActionIBSheet(sheetObject,formObject,IBSEARCH,"","");
			break;
			
		case "btn_new":
			sheetObject.RemoveAll();
			formObject.reset();
			initControl();
			formObject.rqst_bl_tp_cd.Code = "";
			formObject.bl_iss_sts_cd.Code = "";
			break;
			
		case "btn_delete":
			doActionIBSheet(sheetObject,formObject,IBDELETE,"","");
			break;
			
		case "btn_print":
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC02,"","");
			break;

		case "btn_exceldown":
			doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL,"","");
			break;

		case "btn_detail":
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01,"","");
			break;

		case "btns_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.rqst_from_dt, formObject.rqst_to_dt,'yyyy-MM-dd');
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
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR,"","");
	document.form.sXml.value = null;
	initControl();
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
			InitColumnInfo(18, 0, 0, true);

			//헤더에서 처리할 수 있는 각종 기능을 설정한다
//			InitHeadMode(true, true, true, true, false, false);
			InitHeadMode(true, true, true, true, false,false);

			var HeadTitle1 = "|Sel.|No|Type|B/L No|신청업체|POL|B/L 발급 신청|B/L 발급 신청|B/L 발급 신청|Via|B/L 발급|B/L 발급|LOADING VESSEL|LOADING VESSEL|Delete ID";//|RQST NO|RQST SEQ";//|bll_vvd|bl_on_dt|cust_cnt_cd|cust_seq|bl_no_tp|bl_iss_rjct_dt|bl_iss_rmk|rqst_co_nm|rqst_usr_eml|rqst_atnd_nm|rqst_phn_no|bl_rqst_rmk|act_shpr_rgst_no|tax_inv_rcvr_co_nm|tax_inv_rcvr_rgst_no|tax_inv_rcvr_atnd_nm|tax_inv_rcvr_phn_no|remit_co_nm|remit_knd_cd|crr_bank_nm|crr_bank_acct_no|crr_remit_amt|crr_acct_curr_cd";
			var HeadTitle2 = "|Sel.|No|Type|B/L No|신청업체|POL|H.Sts|Request Date|접수지|Via|Approval(Rejection) Date|H.OFC|VVD|ETD|Delete ID";//|RQST NO|RQST SEQ";//|bll_vvd|bl_on_dt|cust_cnt_cd|cust_seq|bl_no_tp|bl_iss_rjct_dt|bl_iss_rmk|rqst_co_nm|rqst_usr_eml|rqst_atnd_nm|rqst_phn_no|bl_rqst_rmk|act_shpr_rgst_no|tax_inv_rcvr_co_nm|tax_inv_rcvr_rgst_no|tax_inv_rcvr_atnd_nm|tax_inv_rcvr_phn_no|remit_co_nm|remit_knd_cd|crr_bank_nm|crr_bank_acct_no|crr_remit_amt|crr_acct_curr_cd";

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,  30, daCenter,  true,       "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,      40, daCenter,  true,       "del_check");
			InitDataProperty(0, cnt++ , dtSeq, 	         40, daCenter,  true,       "seq");
			InitDataProperty(0, cnt++ , dtData, 	 100,     daCenter,  true,       "rqst_bl_tp_cd",   	false,          "",      dfNone,      	  	0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 100,    daCenter,  true,       "bl_no",   			false,          "",      dfNone,      	  	0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 150,    daCenter,  true,   	"rqst_co_nm",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 70,     daCenter,  true,   	"pol_cd",     		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,		 120,     daCenter,  false,   	"bl_iss_sts_cd", 	false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 100,    daCenter,  false,      "bl_iss_rqst_dt",   false,          "",      dfNone,      		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 70,     daCenter,  false,   	"rqst_rct_loc_cd",  false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 70,     daCenter,  false,   	"bl_iss_rqst_cd",  false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,      160,    daCenter,  false,   	"bl_iss_act_dt",    false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,      70,     daCenter,  false,   	"ofc_cd",     		false,          "",      dfNone,     		0,     false,       true);
			InitDataProperty(0, cnt++ , dtData,		 100,    daCenter,  false,   	"vvd", 				false,          "",      dfNone,     		0,     false,       true);		
			InitDataProperty(0, cnt++ , dtData, 	 100,    daCenter,  false,   	"vps_etd_dt",   	false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtData, 	 80,     daCenter, 	true,   	"delt_id",   		false,          "",      dfNone,   			0,     false,       true);
			InitDataProperty(0, cnt++ , dtHidden,	 80,  	 daCenter,	false,		"xter_rqst_no");
			InitDataProperty(0, cnt++ , dtHidden,	 80,	 daCenter,	false,		"xter_rqst_seq");
			CountPosition = 2;
			sheetObj.FrozenCols = 6;
			SetMergeCell(0,10,2,1);
		}
		break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction,sCondParam,PageNo) {
    // sheetObj.ShowDebugMsg = 1;
    switch(sAction) {
    
	case IBCLEAR:      //Combo조회
		//콤보 Value를 가져와서 화면에 세팅
		initCom(formObj);
		break;
		
	case IBSEARCH: //조회Retrieve
		document.form.sXml.value = null;
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
    		sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH;
         	sheetObj.DoSearch("ESM_BKG_1119GS.do", FormQueryString(formObj), "page_no=1", false);
         	// Handling Office 컬럼에 값 넣기
         	var cnt = sheetObj.RowCount;
            if (cnt > 0) {
                for (var i = 2; i <= cnt+1; i++) {
                    sheetObj.CellValue(i, "ofc_cd") = formObj.usr_ofc_cd.value;
                }
            }
			ComOpenWait(false);
		}
		break;

	case IBDOWNEXCEL:      //Excel down
		sheetObj.SpeedDown2Excel(1);
		break;

	case IBDELETE: //Delete
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		if (sheetObj.id == "sheet1") {
			if(ComShowCodeConfirm('BKG00535')){ //delete를 할 것인지 확인하는 컨펌창 보여주기. Yes 선택할 경우 아래 실행
//					//Sheet에 체크된 값 가져오기
				var iCheckRow = sheetObj.FindCheckedRow("del_check");
				var arrRow = iCheckRow.split("|");
				for (var idx=0; idx<arrRow.length - 1; idx++) {
					//화면에서 행 안보이게 하기
					sheetObj.RowHidden(arrRow[idx])= true;
				}
				
				//체크된 행의 데이터를 저장한다
				formObj.f_cmd.value = MODIFY01;
//					var subParam = "f_cmd="+MODIFY01+"&xter_rqst_no="+xter_rqst_no+"&xter_rqst_seq="+xter_rqst_seq;
//					sheetObj.DoSearch("ESM_BKG_1119GS.do", subParam , "del_check", true, true);
				sheetObj.DoSave("ESM_BKG_1119GS.do", "f_cmd="+MODIFY01 , "del_check", true, true);
				//DB에 delt_flg업데이트후 재조회
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"","");
			}
        }
		break;
	
	case IBSEARCH_ASYNC01: //btn_detail
		
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}
		var _Width = '1020';
		var _Height = '680';
		var selectRow = sheetObj.SelectRow;
		var xter_rqst_no = sheetObj.CellValue(selectRow, "xter_rqst_no");
		var xter_rqst_seq = sheetObj.CellValue(selectRow, "xter_rqst_seq");
		var bl_iss_sts_cd = sheetObj.CellValue(selectRow, "bl_iss_sts_cd");
		
		var param = "f_cmd="+SEARCH01+"&xter_rqst_no="+xter_rqst_no+"&xter_rqst_seq="+xter_rqst_seq;
		var url = "ESM_BKG_1119_01.do?"+param;
		
		var rtnVal = 
		//ComOpenWindowCenter의 파라미터를 true로 세팅할 경우 modal로 창을 띄워서 returnValue를 사용할 수 있게 됨.
		ComOpenWindowCenter(url, "BKG_Win", _Width, _Height, true,"scrollbars=yes");
		
		//popup 창을 통해 저장이 일어난 경우 부모창의 시트 값을 해당 값으로 변경. 
		if (rtnVal != 'N'){ 

			if (rtnVal == 'A'){ //approval 버튼을 통해 저장이 성공한 경우
				sheetObj.CellValue(selectRow, 'bl_iss_sts_cd') = "승인상태(발급완료)";
				
			}else if (rtnVal == 'X'){ //reject 버튼을 통해 저장이 성공한 경우
				sheetObj.CellValue(selectRow, 'bl_iss_sts_cd') = "요청거절";

			}
			
			var now = new Date(); //부모창 시트 값 변경에 사용할 현재 시각 정보 생성.
			sheetObj.CellValue(selectRow, 'bl_iss_act_dt') = returnTime(now);
		}
		
		break;
		
	case IBSEARCH_ASYNC02: //btn_print
		if(!validateForm(sheetObj,formObj,sAction)) {
			return false;
		}	
		if (0==sheetObj.CheckedRows("del_check")) {
			ComShowCodeMessage("BKG00155");
			return false;
		}
		if (200<sheetObj.CheckedRows("del_check")) {
			ComShowCodeMessage("BKG08124",200);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
			return false;
		}
		var arrRow = ComFindText(sheetObj, "del_check", 1);
		var formObject = document.form;
		if (arrRow && 0<arrRow.length && 500>=arrRow.length) {
			var bkgNoList ="";
			var seqList = "";
			for (var i=0; i<arrRow.length; i++) {
				bkgNoList += "'"+sheetObj.CellValue(arrRow[i],"xter_rqst_no")+"',";
				seqList   += "'"+sheetObj.CellValue(arrRow[i],"xter_rqst_seq")+"',";
			}
			formObject.com_mrdPath.value = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_1160.mrd";
			formObject.bkgNoList.value = bkgNoList;
			formObject.seqList.value = seqList;
			formObject.com_mrdBodyTitle.value = "Korea B/L Application";
			formObject.com_mrdTitle.value = "Korea B/L Application";
//			formObject.com_mrdSaveDialogFileName.value = sheetObject2.CellValue(arrRow[0],prefix2+"bkg_no");
			ComPostOpenWindow("/hanjin/ESM_BKG_1161.do", "ReportDesignerCommonPopup", "resizable=yes, width=900, height=800");

		}
		break;
    }
}
    
/*
 * 폼의 콤보박스 값을 설정한다.
 * */
function initCom(formObject){    
	formObject.f_cmd.value = INIT;
	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1119GS.do", FormQueryString(formObject));
	arrMultiCombo = sXml.split(iterator); 
	ComXml2ComboItem(arrMultiCombo[0], formObject.rqst_bl_tp_cd, "val", "name");
	ComXml2ComboItem(arrMultiCombo[1], formObject.bl_iss_sts_cd, "val", "name");
	ComXml2ComboItem(arrMultiCombo[2], formObject.bl_iss_rqst_cd, "val", "name");

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction) {
		case IBSEARCH:	//retrieve
			if( formObj.rqst_from_dt.value == "" ){
				ComShowCodeMessage( "COM12114", "Request DT"  );
				formObj.rqst_from_dt.focus();
				return false;
			}
			if( formObj.rqst_to_dt.value == "" ){
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

		case IBDELETE:	//delete
			if (sheetObj.CheckedRows("del_check") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			break;

		case IBSEARCH_ASYNC01:	//발급신청명세 btn_detail
			if (sheetObj.RowCount == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			break;
		}
	}

    return true;
}

/**
 * 시트를 더블클릭했을 때 처리
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObject = document.form;
	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01,"","");
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
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH,"","");
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


/**
 *  10 이하의 데이터 앞에 0을 붙이기 위해 lpad 함수 작성
 */	
function lpad(value) {

	if (value < 10){
		value = "0" + value 
	}
	return value;
}



	