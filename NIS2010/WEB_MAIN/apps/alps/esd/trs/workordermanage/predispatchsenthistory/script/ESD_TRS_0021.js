/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0021.js
*@FileTitle : Pre-Dispatch Sent History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.27
*@LastModifier : 최 선
*@LastVersion : 1.2 
* 2006.12.13 kim_sang_geun
* 1.0 최초 생성
*-----------------------------------------------------------
* History
* 2010.10.19  최종혁	1.1 [CHM-201006633] pre-dispatch 조회오류 수정
* 2010.10.27  최 선	1.2 [] pre-dispatch UI 에서, Sent History 및 Preview UI 이동 시, 조회 오류 수정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0021 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0021() {
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

/* 공통전역변수 */
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var docMonth = new Array("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

var R = 222;
var G = 251;
var B = 248;

/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++] = sheet_obj;
}
	
/**
 * Sheet 기본 설정 및 초기화 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		
		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
//	getVendorComboList();
//	initVendorCombo(document.combo_svc_provider);
	//JSP ---> JS MOVE
	//doActionIBSheet(docObjects[0], document.form, IBSEARCH, "03");
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
    /*
    axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
    axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
    axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
    axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
    axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
    axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리 
    axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
    */
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
				style.height = GetSheetHeight(17);
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
				InitColumnInfo(26, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = " |STS|Seq.|Reference No.|Vendor|Vendor|S/N|Sent Time|Fax 1 Number|Fax1 Status|Fax 2 Number|Fax 2 Status|Fax3 Number|Fax3 Status|E-mail 1 Address|E-Mail 1 Status|E-Mail 2 Address|E-Mail 2 Status|E-Mail 3 Address|E-Mail 3 Status" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck, 30, daCenter, true, "chk1");
				InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtSeq, 30, daCenter, false, "seq", false, "", dfNone,0, false, false);
				InitDataProperty(0, cnt++, dtData, 100,	daCenter, false, "trsp_dis_ref_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50,	daCenter, false, "vndr_seq", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 100,	daLeft, false, "vndr_abbr_nm", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 30,	daCenter, false, "trsp_dis_iss_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120,	daCenter,  false, "snt_dt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 100,	daLeft, false, "dis_n1st_fax_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80,	daCenter, false, "dis_n1st_fax_rslt_flg", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 120,	daLeft, false, "dis_n2nd_fax_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80,	daCenter, false, "dis_n2nd_fax_rslt_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 120,	daLeft, false, "dis_n3rd_fax_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80,	daCenter, false, "dis_n3rd_fax_rslt_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 140,	daLeft, false, "dis_n1st_eml", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtData, 90,	daCenter, false, "dis_n1st_eml_rslt_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 140,	daLeft, false, "dis_n2nd_eml", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90,	daCenter, false, "dis_n2nd_eml_rslt_flg", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 140,	daLeft, false, "dis_n3rd_eml", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 90,	daCenter, false, "dis_n3rd_eml_rslt_flg", false, "", dfNone, 0, false, false);

				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "trsp_so_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "trsp_so_seq", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "trsp_wo_ofc_cty_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 10, daCenter, false, "trsp_wo_seq", false, "", dfNone, 0, false, false);
				
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "dly_dis_snt_dt", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 120, daCenter, false, "trsp_cntr_aval_snt_dt", false, "", dfNone, 0, false, false);
				
				//sheetObj.ColHidden("chk1") = true;

				HeadRowHeight = 25;
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

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_retrieve":
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
				}
			break;

			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
			break;

			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;

			case "btng_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL, "");
			break;

			case "btng_senthistory":
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "02");
			break;

			case "btng_preview":
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "04");
			break;

			case "btns_calendar":
				getCalendar();
			break;

			case "btns_vender": //Service Provider
				rep_OnPopupClick();
			break;

			case "btns_multicntr": //M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
			break;

			case "btns_multibl": //M B/L No
				openMultipleinquiry('BLN', 'B/L No');
			break;

			case "btns_multibkg": //M BKG No
				openMultipleinquiry('BKG', 'BKG No');
			break;

			case "btns_multiwrk": //Work Order No
				openMultipleinquiry('WON', 'W/O No');
			break;

			case "btns_woissoffice": //W/O Issue Office
				open_WoissOffice();
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

//라디오 버튼을 클릭시 데이터를 검색한다.
//function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, Row, NewCol) {
//	if ( OldRow > 0 ) {
//		sheetObj.RowBackColor(OldRow) = sheetObj.UnEditableColor ;
//		sheetObj.RowBackColor(Row) = sheetObj.RgbColor(R, G, B);
//	}
//	sheetObj.CellValue2(Row, "chk1") = "1";
//	var lvDate = sheetObj.CellValue(Row, "trsp_dis_ref_no");
//	var lvVndr = sheetObj.CellValue(Row, "vndr_seq");
//	var lvMon  = "";
//	if( lvDate > 7 ) {
//		lvMon = lvDate.substring(6, 8) + docMonth[eval(lvDate.substring(4, 6))-1] + lvDate.substring(2, 4);
//	} else {
//		lvMon = lvDate;
//	}
//	if( lvVndr == "" ) {
//		lvVndr = 0;
//	}
//	 
//	document.formRd.ref_no.value        = sheetObj.CellValue(Row, "trsp_dis_ref_no");
//	document.formRd.vndr_seq.value      = lvVndr;
//	document.formRd.so_ofc_cty_cd.value = sheetObj.CellValue(Row, "trsp_so_ofc_cty_cd");
//	document.formRd.so_seq.value        = sheetObj.CellValue(Row, "trsp_so_seq");
//	document.formRd.wo_ofc_cty_cd.value = sheetObj.CellValue(Row, "trsp_wo_ofc_cty_cd");
//	document.formRd.wo_seq.value        = sheetObj.CellValue(Row, "trsp_wo_seq");
//	document.formRd.sep_privew.value    = sheetObj.CellValue(Row, "trsp_dis_iss_seq");
//	document.formRd.loc_date.value      = lvMon+" 02:20:04 am";
//	document.formRd.tit_date.value      = lvMon;
//}

//유효성 체크
function validateFormSearch(formObj) {
	var lvFrmDate = doSepRemove(doSepRemove(formObj.frm_plandate.value, " "), "-");
	var lvToDate  = doSepRemove(doSepRemove(formObj.to_plandate.value , " "), "-");

	var lvBkg_no  = doSepRemove(formObj.bkg_no.value , " ");
	var lvBill_no = doSepRemove(formObj.bill_no.value, " ");
	var lvCntr_no = doSepRemove(formObj.cntr_no.value, " ");
	var lvWo_no   = doSepRemove(formObj.wo_no.value  , " ");
	var lvWo_iss_ofc = doSepRemove(formObj.wo_iss_ofc_cd.value, " ");

	if( lvFrmDate == "" ) //from date
		formObj.frm_plandate.value = "";
	if( lvToDate == "" ) //to date
		formObj.to_plandate.value = "";

	if( lvBkg_no == "" ) //BKG No
		formObj.bkg_no.value = "";
	if( lvBill_no == "" ) //B/L No
		formObj.bill_no.value = "";
	if( lvCntr_no == "" ) //CNTR No
		formObj.cntr_no.value = "";
	if( lvWo_no == "" ) //CNTR No
		formObj.wo_no.value = "";


	if( lvFrmDate == "" || lvToDate == "" ) { 
		if(formObj.reference_no.value == '' && formObj.wo_no.value == ''
			&& formObj.bkg_no.value == '' && formObj.bill_no.value == ''
			&& formObj.cntr_no.value == ''){
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}		
	}
	var days_between = ComGetDaysBetween(formObj.frm_plandate , formObj.to_plandate) ;  // 조회 기간
	if( days_between  < 0) {
		ComShowCodeMessage("TRS90118");
		formObj.frm_plandate.focus();
		return false;
	} 
	if ( days_between > 30 ) {
		ComShowMessage(" Possible inquiry period is limited to 1 month.");
		return false;
	}

	if( !doengnumcheck(lvBkg_no) ) {
		formObj.bkg_no.value = "";
		formObj.bkg_no.focus();
		return false;
	}
	if( !doengnumcheck(lvBill_no) ) {
		formObj.bill_no.value = "";
		formObj.bill_no.focus();
		return false;
	}
	if( !doengnumcheck(lvCntr_no) ) {
		formObj.cntr_no.value = "";
		formObj.cntr_no.focus();
		return false;
	}
	if( !doengnumcheck(lvWo_no) ) {
		formObj.wo_no.value = "";
		formObj.wo_no.focus();
		return false;
	}
	
	formObj.hid_frmdate.value = lvFrmDate; //from Date
	formObj.hid_todate.value  = lvToDate;  //to Date

	formObj.bkg_no.value  = lvBkg_no.toUpperCase();  //BKG No.
	formObj.bill_no.value = lvBill_no.toUpperCase(); //B/L No
	formObj.cntr_no.value = lvCntr_no.toUpperCase(); //CNTR No
	formObj.wo_no.value   = lvWo_no.toUpperCase();   //W/O No
	formObj.wo_iss_ofc_cd.value = lvWo_iss_ofc.toUpperCase();
	return true;
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, obj) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			if( obj == "01" ) {
				formObj.f_cmd.value = SEARCH;
				formObj.rtv_flg.value = "D";
				sheetObj.DoSearch4Post("ESD_TRS_0021GS.do", TrsFrmQryString(formObj));
			} else if( obj == "02" ) {
				if( sheetObj.RowCount("U") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
				} else {
  					for(var i=1;i<=sheetObj.RowCount;i++){
  						if(sheetObj.CellValue(i,"chk1") == "1"){
  							document.formRd.ref_no.value = sheetObj.CellValue(i,"trsp_dis_ref_no");
  							document.formRd.vndr_seq.value = sheetObj.CellValue(i, "vndr_seq");
  						}
  			  		}
	  				var lvDate = document.formRd.ref_no.value;
	  				var lvVndr = document.formRd.vndr_seq.value;
	  				var lvMon  = "";
	  				
	  				if( lvDate != "" && lvVndr != "" ) {
		  				if( lvDate > 7 ) {
		  					lvMon = lvDate.substring(6, 8) + docMonth[eval(lvDate.substring(4, 6))-1] + lvDate.substring(2, 4);
		  				} else {
		  					lvMon = lvDate;
		  				}
		  				if( lvVndr == "" ) {
		  					lvVndr = 0;
		  				}
		  				document.formRd.so_ofc_cty_cd.value = sheetObj.CellValue(i, "trsp_so_ofc_cty_cd");
		  				document.formRd.so_seq.value = sheetObj.CellValue(i, "trsp_so_seq");
		  				document.formRd.wo_ofc_cty_cd.value = sheetObj.CellValue(i, "trsp_wo_ofc_cty_cd");
		  				document.formRd.wo_seq.value = sheetObj.CellValue(i, "trsp_wo_seq");
		  				document.formRd.ddl.value = sheetObj.CellValue(i, "dly_dis_snt_dt");
		  				document.formRd.can.value = sheetObj.CellValue(i, "trsp_cntr_aval_snt_dt");
		  				document.formRd.sep_privew.value    = sheetObj.CellValue(i, "trsp_dis_iss_seq");
		  				document.formRd.loc_date.value      = lvMon+" 02:20:04 am";
		  				document.formRd.tit_date.value      = lvMon;
		  				
						var queryStr = sheetObj.GetSaveString(false, false, "chk1");
						formObj.f_cmd.value = "";
						formObj.queryParam.value = queryStr;
						formObj.action = "ESD_TRS_0020.do?pgmNo=ESD_TRS_0020";
						formObj.submit();
					} else {
						errMsg = ComGetMsg("TRS90132");
						ComShowMessage(errMsg);
					}
				}
//			} else if( obj == "03" && lvParam.length > 2 ) {
			} else if( obj == "03" && lvParam != '' ) {
				formObj.f_cmd.value = SEARCH01;
				formObj.rtv_flg.value = "I";
				sheetObj.DoSearch4Post("ESD_TRS_0021GS.do", lvParam+"&"+TrsFrmQryString(formObj));
			} else if( obj == "04" ) {
				if( sheetObj.RowCount("U") < 1 ) {
					errMsg = ComGetMsg("TRS90036");
					ComShowMessage(errMsg);
					return false;
				} else {
					// DDL, CAN  이 발행됐으면 CAN ( ESD_TRS_0027.mrd) 표시.  DDL 만 내역 존재시 dispatch list (ESD_TRS_0026.mrd표시) . 둘다 미존재면 err.
					for(var i=1;i<=sheetObj.RowCount;i++){
						if(sheetObj.CellValue(i,"chk1") == "1"){
							document.formRd.ref_no.value = sheetObj.CellValue(i,"trsp_dis_ref_no");
							document.formRd.vndr_seq.value = sheetObj.CellValue(i, "vndr_seq");
							document.formRd.ddl.value = sheetObj.CellValue(i,"dly_dis_snt_dt");
  							document.formRd.can.value = sheetObj.CellValue(i, "trsp_cntr_aval_snt_dt");
							document.formRd.sep_privew.value = sheetObj.CellValue(i, "trsp_dis_iss_seq");
						}
			  		}
					
	  				var ddlDate = document.formRd.ddl.value;
	  				var canDate = document.formRd.can.value;	
					var sep_privew = document.formRd.sep_privew.value;
					
					if( ddlDate != "" && canDate != "" && sep_privew == "1" ) {
						var parmObj = new Array();
						var frmObj = new Array();
						frmObj[0] = document.formRd;
						parmObj[0] = "1";
						parmObj[1] = "";
						parmObj[2] = "N";
						parmObj[3] = RD_path+"apps/alps/esd/trs/workordermanage/predispatchsenthistory/report/ESD_TRS_0027.mrd";
						parmObj[4] = "";//sheetObject;
						parmObj[5] = frmObj;
						rdObjModaless(RdReport, parmObj, 800, 700);
					} else if( ddlDate != "" && canDate == "" && sep_privew == "1" ) {
						var parmObj = new Array();
						var frmObj  = new Array();
						frmObj[0]  = document.formRd;
						parmObj[0] = "1";
						parmObj[1] = "";
						parmObj[2] = "N";
						parmObj[3] = RD_path+"apps/alps/esd/trs/workordermanage/predispatchstatus/report/ESD_TRS_0026.mrd";
						parmObj[4] = "";//sheetObject;
						parmObj[5] = frmObj;
						rdObjModaless(RdReport, parmObj, 800, 700);
					} else {
						errMsg = ComGetMsg("TRS90132");
						ComShowMessage(errMsg);
					}
				}
			}
		break;

		case IBDOWNEXCEL:        //엑셀 다운로드
			sheetObj.Down2Excel(-1, false, false, true);
		break;
	}
}

// Enter Key시 지연대리 요청 20070115
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "01");
		}
	}
}

// 일자에 더하기를 한다.
function getDateBetween(obj) {
	document.form.to_plandate.value = ComGetDateAdd(obj.value, 14);
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function Minimize(nItem) {
	var objs = document.all.item("showMin");
	if( nItem == "1" ) {
		objs.style.display = "none";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(22);
	} else {
		objs.style.display = "inline";
		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
	}
}

/*
 * 멀티 달력 입력 Pop-Up
 */
function getCalendar() {
	var cal = new ComCalendarFromTo();
	cal.displayType = "date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');
}

/**
 * rep_commodity팝업호출
 */
function rep_OnPopupClick() {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var classId ="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";

	var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 612, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
//	ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 772, 450, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity팝업호출 : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_rep(rowArray) {
	var formObj = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[0];
		var colArray2 = colArray[2];
		var colArray3 = colArray[3];
		var colArray4 = colArray[4];

		formObj.combo_svc_provider.value =colArray2;
		formObj.trsp_so_vndr_no.value = colArray4;
	}
}

/**
 * 외부 콤보박스의 리스트 가져오기 Service Provider
function getVendorComboList() {
	var formObj = document.form;
	var vendorNo = formObj.combo_svc_provider.Text;
	getVendorCombo(document.combo_svc_provider, sheetObjects[0], formObj, vendorNo);
}

function combo_svc_provider_OnKeyDown(combo, keycode, shift) {
	if(keycode == 13) {
		searchVendorName(combo);
	}
}
 **/

/**
 * service provider combo 선택시 textfield의 값 변경하는 이벤트
function combo_svc_provider_OnChange(combo, Index_Code, Text) {
	document.form.trsp_so_vndr_no.value = combo.GetText(Index_Code,1);
}

function searchVendorName(combo) {
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH11;
	document.form.trsp_so_vndr_no.value = combo.GetText(combo.Text,1);
}
 **/

/**
 * 공통 Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject = document.form;
	var cmdt_cd_val ="";   //향후 사용가능 예정변수
	var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
	var cmdt_desc_val ="";   //향후 사용가능 예정변수
	var xx1 = ""; //CONTI
	var xx2 = ""; //SUB CONTI
	var xx3 = ""; //COUNTRY
	var xx4 = ""; //STATE
	var xx5 = ""; //CONTROL OFFIC
	var xx6 = ""; //LOC CODE
	var xx7 = ""; //LOC NAME
	var xx8 = "";
	var xx9 = "";
	var classId = "getTRS_ENS_906";

	var param ="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 400, 330, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}

/**
 * Location : 팝업에서 단일 선택을 한경우..
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj = "";
	var formObject = document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray = rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj = reObj + colArray;
		} else {
			reObj = reObj + colArray + ",";
		}
	}
	if( obj == "BKG" ) {
		formObject.bkg_no.value = reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value = reObj;
	} else if( obj == "CNT" ) {
//		formObject.cntr_no.value = reObj;
		formObject.cntr_no.value = multiCntrChkDgt(reObj);

	} else if( obj == "WON" ) {
		formObject.wo_no.value = reObj;
	} else {
		errMsg = ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}

/**
 * W/O Issue Office
 */
function open_WoissOffice() {
	ComOpenPopup("/hanjin/COM_ENS_071.do", 770, 480, "getCOM_ENS_071", "1,0,1,1,1,1,1,1", true);
}

/**
 * W/O Issue Office : 팝업에서 단일 선택을 한경우..
 */
function getCOM_ENS_071(rowArray) {
	var colArray = rowArray[0];	
	document.form.wo_iss_ofc_cd.value = colArray[3];
}

function sheet1_OnSearchEnd(sheetObj,errMsg){
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		var rtv_flg = document.form.rtv_flg.value;
		
		if (rtv_flg == "I") {
			var formObj = document.formRd;
	
			for(var i=1;i<=sheetObj.RowCount;i++){
				document.formRd.ref_no.value = sheetObj.CellValue(i,"trsp_dis_ref_no");
				document.formRd.vndr_seq.value = sheetObj.CellValue(i, "vndr_seq");
				if( formObj.ref_no.value != "" && formObj.vndr_seq.value != "" )  {
					sheetObj.CellValue2(i, "chk1") = "1";
				}
			}
		}
	}
}

//Service Provider
function  vender_blur(){
	var formObj = document.form;
	var lvobj = formObj.combo_svc_provider.value;
	var error_val = "";

	if(lvobj !=""){
		for (var i = 0; i < lvobj.length; i++) {
			var oneChar = lvobj.charAt(i);
			if (oneChar != "") {
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val ="Y";
					break;
				}
			}
		}
		if(error_val !="Y" ) {
			//vender value값을 가져온다(SHEET1)
			formObj.f_cmd.value = SEARCHLIST12;
			sheetObjects[0].DoSearch4Post("ESD_TRS_0065GS.do", TrsFrmQryString(formObj));

			//1개의 파라미터의 값을 조회후 가져온다.
			var x1 = sheetObjects[0].EtcData('CNT_CD1');
			if(x1 !="" || x1 !="undefined") {
				formObj.trsp_so_vndr_no.value =x1;
			} else {
				errMsg = ComGetMsg("TRS90076");
				ComShowMessage(errMsg);
				formObj.combo_svc_provider.focus();
				formObj.trsp_so_vndr_no.value ="";
			}
		} else {
			errMsg = ComGetMsg("TRS90076");
			ComShowMessage(errMsg);
			formObj.combo_svc_provider.focus();
			formObj.trsp_so_vndr_no.value ="";
		}
	} else {
		formObj.trsp_so_vndr_no.value ="";
	}
}