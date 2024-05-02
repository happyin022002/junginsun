/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0951 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0951() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var cntrck = false; //Verify를 유무 확인
var sheetObjSingle;

var R = 0;
var G = 255;
var B = 0;
/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */

function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	sheetObjSingle = opener.getSheetObj();
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	//html컨트롤 이벤트초기화
	initControl();
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
    //Axon ??? ??1. ???catch
//            axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//            axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//            axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//            axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//            axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//            axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
//            axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}


//Axon ??? ??2. ??????? --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//            ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//            form.boo_bkg_no.readOnly =!form.manual.checked;
}

/**
 * BKG Creation탭의 Booking No가 바뀐경우 기능을 처리한다. <br>
 **/
function bkgno_keyup() {
    //bkg_no를 수정해서 저장된값과 다른경우 bl_no를 지우고, 같은경우 bl_no를 살린다.
/*
    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
        form.boo_bl_no.value = "";
    else
        form.boo_bl_no.value = form.hdn_boo_bl_no.value;
*/
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_blur(){
    //입력Validation 확인하기
//            return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//            ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//            ComKeyOnlyNumber(event.srcElement);
}

//Axon 이벤트 처리2. 이벤트처리함수 --- end


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
				// 높이 설정
				style.height = GetSheetHeight(11) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(14, 0 , 0, true);
				InitHeadMode(true, true, true, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle =  "SEQ|||EQ No|Verify Result|EQ TP/SZ" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성[ROW,COL,DATATYPE,    WIDTH,DATAALIGN,COLMERGE,SAVENAME,      KEYFIELD, CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtDataSeq     ,  30,  daCenter, false, "seq"          , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHiddenStatus,  30,  daCenter, true , "ibflag"       , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtCheckBox    ,  30,  daCenter, false, "chk1"         , false, "", dfNone   , 0, true , true );
				InitDataProperty(0, cnt++, dtData        ,  90,  daCenter, false, "eq_no"        , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData        , 140,  daCenter, false, "verfy_result" , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  30,  daCenter, false, "eq_tpsz_cd"   , false, "", dfNone   , 0, false, false);

				InitDataProperty(0, cnt++, dtHidden      ,  80,  daCenter, true , "lessor"       , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  80,  daCenter, true , "lstm_cd"      , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      ,  80,  daCenter, true , "ownr_co_cd"   , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      , 100,  daCenter, true , "eq_used"      , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      , 100,  daCenter, true , "movement_sts" , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      , 100,  daCenter, true , "creation_yard", false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtHidden      , 100,  daCenter, true , "event_date"   , false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 80, daCenter, true, "offh_yd_cd", false, "", dfNone, 0, false, false);
				EditableColorDiff = false; //배경 색을 유지한다. false일 경우만.
			}
		break;
		case 2:      //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 0;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(10, 0 , 0, true);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				var HeadTitle =  "CNTR No";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성[ROW,COL,DATATYPE,    WIDTH,DATAALIGN,COLMERGE,SAVENAME,      KEYFIELD, CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtData,  90, daCenter, false, "eq_no"        , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData,  30, daCenter, false, "eq_tpsz_cd"   , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true , "lessor"       , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true , "lstm_cd"      , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData,  80, daCenter, true , "ownr_co_cd"   , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true , "eq_used"      , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true , "movement_sts" , false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true , "creation_yard", false, "", dfNone   , 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100, daCenter, true , "event_date"   , false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50,  daCenter, true , "offh_yd_cd", false, "", dfNone   , 0, false, false);
			}
		break;
	}
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];

	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btng_fileselect":
				doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
			break;
			
			case "btng_delete":
				doActionIBSheet(sheetObject, formObject, IBDELETE);
			break;
			
			case "btng_verify":
				if( gainEqNo(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH);
				}
			break;

			case "btng_apply":
				doCNTRapply(sheetObject, sheetObjSingle);
			break;
			
			case "btn_close":
				window.close();
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH02;
			sheetObj.DoSearch4Post("ESD_TRS_0951GS.do", TrsFrmQryString(formObj));
			doCNTRcheck(sheetObjects[0], sheetObj, sheetObjSingle);
		break;

		case IBDELETE:        //저장
			var checkList = sheetObj.FindCheckedRow('chk1');
			var checkArray = checkList.split('|');
			for(var k=checkArray.length-2; k>=0; k--) {
				sheetObj.RowDelete(checkArray[k], false);
			}
			cntrck = false;
		break;

		case IBLOADEXCEL:     //엑셀 업로드
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObj.LoadExcel();
//			sheetObj.TotalRows = sheetObj.RowCount; 
			cntrck = false;
		break;
	}
}

/*
 * Shee1에서 OnChange 이벤트 발생시 처리
 */
function sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( sheetObj.CellValue(row, "verfy_result").length > 4 )  {
			sheetObj.CellValue2(row, "chk1") = "0";
			sheetObj.RowStatus(row) = "R";
		} else {
			if ( value == "1") {
				sheetObj.RowStatus(row) = "U";
			} else {
				sheetObj.RowStatus(row) = "R";
			}
		}
	}
}

/*
 * Container No를 그리드 상에서 얻는다.
 */
function gainEqNo(sheetObj, formObj) {
	if( sheetObj.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var lvEqno = "";
	//데이터 행의 개수 확인
	var fromRow = 0;
	var sRow = sheetObj.FindCheckedRow("chk1");

	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		fromRow = arrRow[i];
		sheetObj.CellValue2(fromRow, "eq_no") = cntrCheckDigit(sheetObj.CellValue(fromRow, "eq_no"));
		if( i == ( arrRow.length - 2 ) ) {
			lvEqno = lvEqno + sheetObj.CellValue(fromRow, "eq_no");
		} else {
			lvEqno = lvEqno + sheetObj.CellValue(fromRow, "eq_no") + ",";
		}
	}
	document.form.hid_eq_no.value = lvEqno;
	return true;
}

/*
 * Container 유무 체크
 */
function doCNTRcheck(frmSheet, toSheet, bodySheet) {
	cntrck = true; //verify를 했는지 안했는지 유무체크
	var lvcheck = false;
	if( frmSheet.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var sRow = frmSheet.FindCheckedRow("chk1");
	var arrRow = sRow.split("|");
	for( var i = 0; i < arrRow.length-1; i++ ) {
		lvcheck = false;
		var lvcntr = frmSheet.CellValue(arrRow[i], "eq_no");
		
		for( var j = 1; j < toSheet.RowCount+1; j++ ) {
			if( lvcntr == toSheet.CellValue(j, "eq_no") ) {
				frmSheet.CellValue2(arrRow[i], "eq_tpsz_cd"   ) = toSheet.CellValue(j, "eq_tpsz_cd");
				frmSheet.CellValue2(arrRow[i], "lessor"       ) = toSheet.CellValue(j, "lessor");
				frmSheet.CellValue2(arrRow[i], "lstm_cd"      ) = toSheet.CellValue(j, "lstm_cd");
				frmSheet.CellValue2(arrRow[i], "ownr_co_cd"   ) = toSheet.CellValue(j, "ownr_co_cd");
				frmSheet.CellValue2(arrRow[i], "eq_used"      ) = toSheet.CellValue(j, "eq_used");
				frmSheet.CellValue2(arrRow[i], "movement_sts" ) = toSheet.CellValue(j, "movement_sts");
				frmSheet.CellValue2(arrRow[i], "creation_yard") = toSheet.CellValue(j, "creation_yard");
				frmSheet.CellValue2(arrRow[i], "event_date"   ) = toSheet.CellValue(j, "event_date");
				frmSheet.CellValue2(arrRow[i], "offh_yd_cd"   ) = toSheet.CellValue(j, "offh_yd_cd");
				frmSheet.CellValue2(arrRow[i], "verfy_result" ) = "OK";
				lvcheck = true;
				break;
			}
		}
		if( !lvcheck ) {
			frmSheet.CellValue2(arrRow[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
			frmSheet.RowStatus(arrRow[i]) = "R";
			frmSheet.CellValue2(arrRow[i], "verfy_result") = "No Data";
			frmSheet.RowBackColor(arrRow[i]) = frmSheet.RgbColor(R,G,B);
		}
	}
	for( var i = 0; i < arrRow.length-1; i++ ) {
		var lvcntr = frmSheet.CellValue(arrRow[i], "eq_no");
		for( var j = (i+1); j < arrRow.length-1; j++ ) {
			if( lvcntr == frmSheet.CellValue(arrRow[j], "eq_no") ) {
				frmSheet.CellValue2(arrRow[j], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
				frmSheet.RowStatus(arrRow[j]) = "R";
				frmSheet.CellValue2(arrRow[j], "verfy_result") = "Same Data";
				frmSheet.RowBackColor(arrRow[j]) = frmSheet.RgbColor(R,G,B);
			}
		}
	}

	//Body의 컨테이너 번호를 비교한다.
	var sRow2 = frmSheet.FindCheckedRow("chk1");
	var arrRow2 = sRow.split("|");
	for( var i = 0; i < arrRow2.length-1; i++ ) {
		var doceqno = frmSheet.CellValue(arrRow2[i], "eq_no");
		for( var j = 1; j < bodySheet.RowCount+1; j++ ) {
			if( doceqno == bodySheet.CellValue(j, "eq_no") ) {
				frmSheet.CellValue2(arrRow2[i], "chk1") = "0"; //체크한 박스를 체크 해제를 시킨다.
				frmSheet.RowStatus(arrRow2[i]) = "R";
				frmSheet.CellValue2(arrRow2[i], "verfy_result") = "Body Same Data";
				frmSheet.RowBackColor(arrRow2[i]) = frmSheet.RgbColor(R,G,B);
				break;
			}
		}
	}
}

/*
 * Apply버튼 클릭시 처리해 주는 로직
 */
function doCNTRapply(frmSheet, toSheet) { //child Sheet, Body Sheet
	if( !cntrck ) {
		errMsg = ComGetMsg("TRS90055");
		ComShowMessage(errMsg);
		return false;
	}
	cntrck = false; //Verify를 유무 확인
	var lvcheck = false;
	if( frmSheet.RowCount("U") < 1 ) {
		errMsg = ComGetMsg("TRS90036");
		ComShowMessage(errMsg);
		return false;
	}
	var fromRow = 0;
	var toRow = 0;
	var sFromRow = frmSheet.FindCheckedRow("chk1");
	var sToRow  = toSheet.FindCheckedRow("chk1");
	var arrFRow = sFromRow.split("|");
	var arrTRow = sToRow.split("|");
	for( var i = 0; i < arrFRow.length - 1; i++ ) {
		var docEqtpszcd = frmSheet.CellValue(arrFRow[i], "eq_tpsz_cd");
		for( var j = 0; j < arrTRow.length - 1; j++ ) {
			var doceqno2 = toSheet.CellValue(arrTRow[j], "eq_no");
			var doceqtpszcd2 = toSheet.CellValue(arrTRow[j], "eq_tpsz_cd");
			if( docEqtpszcd == doceqtpszcd2 && doceqno2 == "" ) {
				toSheet.CellValue2(arrTRow[j], "eq_no"        ) = frmSheet.CellValue(arrFRow[i], "eq_no");
				toSheet.CellValue2(arrTRow[j], "eq_tpsz_cd"   ) = doceqtpszcd2;
				toSheet.CellValue2(arrTRow[j], "lessor"       ) = frmSheet.CellValue(arrFRow[i], "lessor");
				toSheet.CellValue2(arrTRow[j], "lstm_cd"      ) = frmSheet.CellValue(arrFRow[i], "lstm_cd");
				toSheet.CellValue2(arrTRow[j], "ownr_co_cd"   ) = frmSheet.CellValue(arrFRow[i], "ownr_co_cd");
				toSheet.CellValue2(arrTRow[j], "eq_used"      ) = frmSheet.CellValue(arrFRow[i], "eq_used");
				toSheet.CellValue2(arrTRow[j], "movement_sts" ) = frmSheet.CellValue(arrFRow[i], "movement_sts");
				toSheet.CellValue2(arrTRow[j], "creation_yard") = frmSheet.CellValue(arrFRow[i], "creation_yard");
				toSheet.CellValue2(arrTRow[j], "event_date"   ) = frmSheet.CellValue(arrFRow[i], "event_date");
				
				if( opener.form.page_type.value == 'C' 
					&& toSheet.CellValue(arrTRow[j], "trsp_cost_dtl_mod_name") == 'Off-Hire' 
					&& toSheet.CellValue(arrTRow[j], "org_eq_no") == '' 
					&& frmSheet.CellValue(arrFRow[i], "offh_yd_cd") != ''){
						//PLAN의 TO NODE CODE와 Off-Hire Node code가 다를 경우 경고 메시지 
						if(toSheet.CellValue(arrTRow[j], "to_nod_cd") != frmSheet.CellValue(arrFRow[i], "offh_yd_cd")){
							ComShowCodeMessage('TRS90527',toSheet.CellValue(arrTRow[j], "to_nod_cd"),frmSheet.CellValue(arrFRow[i], "offh_yd_cd"));
						}
					toSheet.CellValue2(arrTRow[j], "to_nod_cd") = frmSheet.CellValue(arrFRow[i], "offh_yd_cd");
					toSheet.CellValue2(arrTRow[j], "lse_cntr_flg") = 'Y';
				}

				break;
			}
		}
	}
	window.close();
}