/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0311.js
 *@FileTitle : [CPS_CNI_0311] Handler History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.04.19
 *@LastModifier : 정행룡
 *@LastVersion : 1.0
 * 2010.04.19 정행룡
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0311] Manager History
 * 
 * @extends
 * @class Manager History 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function cps_cni_0311() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject     = setSheetObject;
	this.loadPage           = loadPage;
	this.initSheet          = initSheet;
	this.initControl        = initControl;
	this.doActionIBSheet    = doActionIBSheet;
	this.setTabObject       = setTabObject;
	this.validateForm       = validateForm;
}

//===================================================================================
//전역변수 & 추상함수
//===================================================================================

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;

//html form
var frm = null;

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 * @param {ibsheet} sheetObj IBSheet Object  
 **/
function setSheetObject(sheetObj){
    sheetObjects[sheetCnt++] = sheetObj;
}

//===================================================================================
//초기화 
//===================================================================================

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	//전역 변수 설정 
	frm = document.form;
	sheet1 = sheetObjects[0];
	sheet2 = sheetObjects[1];
	sheetCnt = sheetObjects.length;
    
	// 시트 초기화
	for ( var i = 0; i < sheetCnt; i++) {
		
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//Form 이벤트 등록
	initControl();
	
 	sheet1.WaitImageVisible = false;	    
 	var claim_no = frm.dw_clm_no.value;
 	
 	if (claim_no != "") {
 		doActionIBSheet(SEARCHLIST01);
 	}
 	sheet1.WaitImageVisible = true;
 	
 	sheet2.WaitImageVisible = false;	    
 	var claim_no = frm.dw_clm_no.value;
 	if (claim_no != "") {
 		doActionIBSheet(SEARCHLIST02);
 	}
 	sheet2.WaitImageVisible = true;
}

/**
 * Form 이벤트 등록
 **/
function initControl() {
	//keypress
	axon_event.addListenerForm('keypress',        'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	//key up
	axon_event.addListenerForm('keyup',			   'obj_keyup', frm); 
}

 /**
  * HTML Control KeyPress 이벤트 호출
  */
function obj_keypress() {
	switch (event.srcElement.name) {    
    case "dw_clm_no":
    	ComKeyOnlyAlphabet('uppernum');
    	if (event.keyCode == 13) {
    		doActionIBSheet(SEARCHLIST01);
     		sheet2.WaitImageVisible = false;
     		doActionIBSheet(SEARCHLIST02);
     		sheet2.WaitImageVisible = true;
 		}
 		break;
 	}
}

 /**
  * HTML Control KeyUp 이벤트 호출
  **/
 function obj_keyup() {
 	switch (event.srcElement.name) {    
     case "dw_clm_no":
     	ComKeyOnlyAlphabet('uppernum');
     	if (frm.dw_clm_no.value.length == 10) {
     		doActionIBSheet(SEARCHLIST01);
     		sheet2.WaitImageVisible = false;
     		doActionIBSheet(SEARCHLIST02);
     		sheet2.WaitImageVisible = true;
  		}
  		break;
  	}
 }

 /**
 * 화면 깜박임 방지 (페이지 로딩후 실행) 
 * @param {ibsheet} sheet  sheet
 */
 function sheet2_OnLoadFinish(sheet) {
 	
 }
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼이름으로 구분하여 처리할 작업을 수행하는 이벤트 핸들러
 * @param none 
 **/
function processButtonClick() {
	
	// 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 
	// var sheetObject1 = sheetObjects[0];
   	// var formObject = document.form;
	
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		
			case "btn2_Row_Add":
				doActionIBSheet(IBINSERT);
				break;
	
	        case "btn2_Row_Delete":
	        	if (sheet2.RowCount > 0) {
	        		SheetRowDelete(sheet2,sheet2.SelectRow);
	        	}
	    		break; 
	            
			case "btn1_Retrieve":
				if (validateForm(SEARCHLIST01)) {
					doActionIBSheet(SEARCHLIST01);
					sheet2.WaitImageVisible = false;
					doActionIBSheet(SEARCHLIST02);
					sheet2.WaitImageVisible = true;
				}	
				break;
	
			case "btn1_New":
				doActionIBSheet(IBCLEAR);
				break;
			
			case "btn1_Save":
				var changeRowCnt = sheet2.RowCount("I") + 
				                   sheet2.RowCount("U") +
				                   sheet2.RowCount("D");
				if (changeRowCnt == 0) {
					ComShowCodeMessage("CNI00022");//"There is no contents to save.";
					return;
				} else {	
					if (ComShowCodeConfirm("CNI00012")) { //"Data was changed. Do you want to save it?"
						doActionIBSheet(MULTI);
					} 
				}	
	            break;
	            
			case "btn1_Close":
				window.close();
				break;

		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
		    ComShowMessage(OBJECT_ERROR);
		} else {
	       ComShowMessage(e);
		}
	}
}




/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 **/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 120;

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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "||Seq.|Handler|Office|STS|Description|Working Period|Working Period|Working Period|Date|User";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtRadioCheck,    20, 	daCenter, true, "crnt_hdlr_flg", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtDataSeq,       30, 	daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 			60, 	daCenter, true, "hdlr_usr_id", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			50, 	daCenter, true, "hdlr_ofc_cd", 		false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			30, 	daCenter, true, "dw_clm_sts_cd", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			80, 	daCenter, true, "dw_clm_sts_nm", 	false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65,	    daCenter, true, "eff_dt", 			false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			20,	    daCenter, true, "tmp_bar", 			false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, true, "exp_dt", 			false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			65, 	daCenter, true, "upd_dt", 			false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, true, "cre_usr_id", 		false, "", dfNone, 0, true, true);
			
			//CountPosition = 0;
		    //CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
	    break;
	case "sheet2": //sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 120;

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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Manager|Office|Date|User|||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, true,	"ibflag");
			InitDataProperty(0, cnt++, dtDataSeq,     	50, 	daCenter, true, "seq");
			InitDataProperty(0, cnt++, dtData, 			140, 	daCenter, true, "hdlr_usr_id", 	true,	"", dfNone, 	0, true, true, 20);
			InitDataProperty(0, cnt++, dtData, 			120, 	daCenter, true, "hdlr_ofc_cd", 	false,	"", dfNone, 	0, false, false);//읽기전용
			InitDataProperty(0, cnt++, dtData, 			120,	daCenter, true, "upd_dt", 		false,	"", dfDateYmd, 	0, false, false);//읽기전용
			InitDataProperty(0, cnt++, dtData, 			0, 		daCenter, true, "upd_usr_id", 	false,	"", dfNone, 	0, false, false);//읽기전용
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, "dw_clm_no");
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, "dw_clm_his_seq");
			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, true, "dw_clm_sts_cd");
			
			//CountPosition = 0;
		    //CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;


	}
}
/**
 * Sheet관련 프로세스 처리
 **/
function doActionIBSheet(sAction) {
	
	frm.f_cmd.value = sAction;
	
	switch (sAction) {

	case SEARCHLIST01: // Retrieve Handler History
		var sXml = sheet1.GetSearchXml("CPS_CNI_0310GS.do",	FormQueryString(frm));
		var list = SheetXml2ListMap(sXml);
		if (list.length == 0) {
			ComShowCodeMessage("CNI00013");
		}
		sheet1.LoadSearchXml(sXml);
		break;
		
	case SEARCHLIST02: // Retrieve Manager History
		var sXml = sheet2.GetSearchXml("CPS_CNI_0311GS.do",	FormQueryString(frm));
		sheet2.LoadSearchXml(sXml);
		frm.dw_clm_no.focus();
		break;
		
	case IBCLEAR: // New  
		//CNI00015 Do you want to initialize?
		if (ComShowCodeConfirm("CNI00015") ) {
			frm.dw_clm_no.value= "" ;
			sheet1.RemoveAll();
			sheet2.RemoveAll();
			frm.dw_clm_no.focus();
		}
		break;
		
	case IBINSERT: // Row Add
	    if (!validateForm(sAction)) { return; }
		var row = sheet2.DataInsert(-1);		
		sheet2.SelectCell(row,"hdlr_usr_id",true);
		sheet2.CellValue2(row, "dw_clm_no") = frm.dw_clm_no.value; 
		sheet2.CellValue2(row, "upd_usr_id") = frm.usr_id.value;
		sheet2.CellValue2(row, "upd_dt") = setDate();
		sheet2.CellValue2(row, "upd_ofc_cd") = userOfficeCode;
		sheet2.CellValue2(row, "hdlr_ofc_cd") = userOfficeCode;
		sheet2.CellValue2(row, "dw_clm_sts_cd") = sheet1.CellValue(1, "dw_clm_sts_cd"); //Handler 첫번째 Row의 상태값으로 셋팅 
		break;
	
	case MULTI: //Save
		
		if (!validateForm(sAction)) { return; }
		
		var param = FormQueryString(frm);
	
		var saveString = sheet2.GetSaveString(); 
		if (sheet2.IsDataModified && ComIsNull(saveString))  {			
			return;
		}
		saveString = ComSetPrifix(saveString, "sheet2_");
		param += "&" + saveString;	
       
		var sXml = sheet2.GetSaveXml("CPS_CNI_0311GS.do", param);
		
		sheet2.LoadSaveXml(sXml);
		break;
	}	
}

 /**
  * 현재 날짜,시간 구하기
  */ 
 function setDate(){
 	 var d = new Date;
 	 var s = leadingZeros(d.getFullYear(), 4) + '-'
 		   + leadingZeros(d.getMonth() + 1, 2) + '-'
 		   + leadingZeros(d.getDate(), 2) + ' ';

 	 return s;
 }

 function leadingZeros(n, digits) {
     var zero = '';
     n = n.toString();

     if (n.length < digits) {
       for (i = 0; i < digits - n.length; i++)
         zero += '0';
     }
     return zero + n;
}
 
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 **/
function validateForm(sAction) {
	 
	if (!ComChkValid(frm)) return false;
	
	var dw_clm_no = frm.dw_clm_no.value;
	
	if(dw_clm_no == "") {
		ComShowCodeMessage("CNI00003","Claim No");
		frm.dw_clm_no.focus();
		return false;
	}
	return true;
}

