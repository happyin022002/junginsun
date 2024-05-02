/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0079.js
*@FileTitle : Control Office Exception Case Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : poong
*@LastVersion : 1.0
* 2006-09-25 poong
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

/**
 * @fileoverview 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0079 : 예)Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TRS_0079() {
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
//var calPop = new calendarPopupGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var cntr_tp_cdText = '';
var cntr_tp_cdCode = '';
var cntr_sz_cdText = '';
var cntr_sz_cdCode = '';
var F_trsp_cost_dtl_mod_cdCode = 'CY|DR';
var F_trsp_cost_dtl_mod_cdText = 'CY|DOOR';
var M_trsp_cost_dtl_mod_cdCode = 'ER|CN|CF';
var M_trsp_cost_dtl_mod_cdText = 'EMPTY REPO|CNTR S/T ON-HIRE|CNTR S/T OFF-HIRE';
var A_trsp_cost_dtl_mod_cdCode = 'CY|DR|ER|CN|CF';
var A_trsp_cost_dtl_mod_cdText = 'CY|DOOR|EMPTY REPO|CNTR S/T ON-HIRE|CNTR S/T OFF-HIRE';


var M_trsp_crr_mod_cdCode = 'WD|TD|RD';
var M_trsp_crr_mod_cdText = 'WD|TD|RD';

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

	var formObj = document.form;
	formObj.f_cmd.value = SEARCH04;
	sheetObjects[0].DoSearch("ESD_TRS_0079GS.do", TrsFrmQryString(formObj));
	
	formObj.f_cmd.value = SEARCH05;
	sheetObjects[0].DoSearch("ESD_TRS_0079GS.do", TrsFrmQryString(formObj));

	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
    //Axon 이벤트 처리1. 이벤트catch
//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
//		axon_event.addListener  ('click', 'manual_click', 'manual');    //BKG Creation탭의 manual이 바뀐경우
//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); //BKG Creation탭의 Booking No가 바뀐경우
//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onblur이벤트에 코드 처리
//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onfocus이벤트에 코드 처리
//		axon_event.addListenerFormat('keypress','obj_keypress', form);  //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리   
//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     //Cust탭의 Cusromer_nm이 바뀐경우
}

//Axon 이벤트 처리2. 이벤트처리함수 --- start
/**
* HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
 **/
function engnum_keypress() {
    //???? ????
//    ComKeyOnlyAlphabet('uppernum');
}

/**
 * BKG Creation?? manual? ???? ??? ????. <br>
 **/
function manual_click() {
    //manual이 체크된 경우만 Bkg_no를 편집 가능으로 한다.
//    form.boo_bkg_no.readOnly =!form.manual.checked;
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
//    return ComChkObjValid(event.srcElement);
}

/**
 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
 **/
function obj_focus(){
    //?????? ???
//    ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress(){
    //???????
//    ComKeyOnlyNumber(event.srcElement);
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
				style.height = 480;
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
				InitColumnInfo(27, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "Del.|For COP/\nMTY Plan|Cost\nMode|Trans\nMode|Equipment\nTP     SZ|Equipment\nTP     SZ"
								+"|From Node|From Node|Via Node|Via Node|To Node|To Node|Door Node|Door Node"
								+"|Control\nOffice\nSetting|Control\nOffice\nCode|Creation\nDate"
								+"|Creation\nUser Name|Delete Date|Delete\nUser Name";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
 
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtCheckBox, 30, daCenter,	true,	  "delcheck",       false,          "",      dfNone,      0,     true,       true,        5,  false,    true,    "",        false);
				InitDataProperty(0,	cnt++,	dtCombo,	80,	daCenter,	true,	  "cgo_tp_cd",	   true,		 "",	 dfNone,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtCombo,	60,	daCenter,	true,	  "trsp_cost_dtl_mod_cd",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtCombo,	60,	daCenter,	true,	  "trsp_crr_mod_cd",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtCombo,	40,	daCenter,	true,	  "cntr_tp_cd",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtCombo,	40,	daCenter,	true,	  "cntr_sz_cd",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	  "fm_loc_value",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		40, daLeft,		true,	  "fm_yard_value",	   false,		 "",	   dfNone,		  0,	  false,	  true,	  2,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	  "via_loc_value",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		40, daLeft,		true,	  "via_yard_value",	   false,		 "",	   dfNone,		  0,	  false,	  true,	  2,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	  "to_loc_value",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		40, daLeft,		true,	  "to_yard_value",	   false,		 "",	   dfNone,		  0,	  false,	  true,	  2,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		60,	daCenter,	true,	  "dor_loc_value",	   false,		 "",	 dfEngUpKey,		  0,	  false,	  true,	  5,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		40, daLeft,		true,	  "dor_yard_value",	   false,		 "",	   dfNone,		  0,	  false,	  true,	  2,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtCombo,	90, daLeft,		true,	  "ctrl_ofc_div_cd", true,		 "",	   dfNone,		  0,	  false,	  true,	  400,	 false,	 true,	   "",	  false);

				InitDataProperty(0,	cnt++,	dtData,		90,	daLeft,		true,	  "ctrl_ofc_cd",	   true,		 "",	   dfNone,		  0,	  false,	  true,	  400,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daLeft,		true,	  "cre_dt",	   false,		 "",	   dfDateYmd,		  0,	  false,	  false,	  20,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daLeft,		true,	  "cre_usr_id",	   false,		 "",	   dfNone,		  0,	  false,	  false,	  10,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daLeft,		true,	  "upd_dt",	   false,		 "",	   dfDateYmd,		  0,	  false,	  false,	  20,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtData,		90,	daLeft,		true,	  "upd_usr_id",	   false,		 "",	   dfNone,		  0,	  false,	  false,	  10,	 false,	 true,	   "",	  false);
				InitDataProperty(0,	cnt++,	dtStatus,	40,	daCenter,	true,	  "ibflag");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "fm_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "to_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "via_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "dor_nod_cd");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "delt_flg");
				InitDataProperty(0, cnt++ , dtHidden,   0,  daCenter,	false,	  "org_delt_flg");
				
								
				ColHidden('ibflag')				= true;

				InitDataCombo(0, "ctrl_ofc_div_cd", "By_From|By_To|By_Via|By_Door","F|T|V|D", "By_Form", "F");
				InitDataCombo(0, 'cgo_tp_cd', cgo_tp_cdText, cgo_tp_cdCode);
				InitDataCombo(0, 'trsp_cost_dtl_mod_cd', ""+A_trsp_cost_dtl_mod_cdText, ""+A_trsp_cost_dtl_mod_cdCode);
				InitDataCombo(0, 'trsp_crr_mod_cd', ""+trsp_crr_mod_cdText, ""+trsp_crr_mod_cdCode);
				
				ColHidden("cgo_tp_cd") = true;
				ColHidden("trsp_cost_dtl_mod_cd") = true;
				ColHidden("trsp_crr_mod_cd") = true;
				ColHidden("cntr_tp_cd") = true;
				ColHidden("cntr_sz_cd") = true;
				ColHidden("ctrl_ofc_div_cd") = true;
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


			case "btng_rowadd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;

			case "btng_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e);
		}
	}
}

/* Sheet관련 프로세스 처리 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {

	   case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0079GS.do", TrsFrmQryString(formObj));
			break;

		case IBSAVE:        //저장
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_TRS_0079GS.do", TrsFrmQryString(formObj), 'ibflag', false);

			break;
	  case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);

		  break;

	   case IBINSERT:      // 입력
			var row = sheetObj.DataInsert(-1);
			sheetObj.InitCellProperty(row, 'fm_yard_value', dtCombo);
			sheetObj.InitCellProperty(row, 'to_yard_value', dtCombo);
			sheetObj.InitCellProperty(row, 'via_yard_value', dtCombo);
			sheetObj.InitCellProperty(row, 'dor_yard_value', dtCombo);

			sheetObj.CellValue2(row, "cgo_tp_cd") = "F";
			sheetObj.CellValue2(row, "ctrl_ofc_div_cd") = "F";
	
			sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', ""+F_trsp_cost_dtl_mod_cdText, ""+F_trsp_cost_dtl_mod_cdCode);
			break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	
	switch(sAction){
		case IBSAVE:
			
			for(var k=1; k<sheetObj.RowCount+1; k++)
			{
//				var ctl_ofc_set = sheetObj.CellValue(k, 'ctrl_ofc_div_cd');
//				if(sheetObj.RowStatus(k)=='I' && ctl_ofc_set == 'V' && sheetObj.CellValue(k, 'via_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'Via Node');
//					sheetObj.SelectCell(k, 'via_loc_value');
//					return false;
//				}
//
//				if(sheetObj.RowStatus(k)=='I' && ctl_ofc_set == 'D' && sheetObj.CellValue(k, 'dor_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'Door Node');
//					sheetObj.SelectCell(k, 'dor_loc_value');
//					return false;
//				}

//				if( sheetObj.CellEditable(k,'to_yard_value') && sheetObj.CellValue(k, 'to_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'To Node');
//					sheetObj.SelectCell(k, 'to_loc_value');
//					return false;
//				}
//  
//				if( sheetObj.CellEditable(k,'fm_loc_value') && sheetObj.CellValue(k, 'fm_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'From Node');
//					sheetObj.SelectCell(k, 'fm_loc_value');
//					return false;
//				}
//
//				if( sheetObj.CellEditable(k,'via_yard_value') && sheetObj.CellValue(k, 'via_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'Via Node');
//					sheetObj.SelectCell(k, 'via_loc_value');
//					return false;
//				}
//  
//				if( sheetObj.CellEditable(k,'dor_loc_value') && sheetObj.CellValue(k, 'dor_loc_value')==''){
//					ComShowCodeMessage('COM12114', 'Door Node');
//					sheetObj.SelectCell(k, 'dor_loc_value');
//					return false;
//				}
			}
			
		return true;
	}
}


/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet_OnSearchEnd(sheetObj,errMsg){
	var formObj = document.form;
	if(errMsg!=null && errMsg != ''){
		ComShowMessage(errMsg);
	}else if(formObj.f_cmd.value == SEARCH05){
		cntr_tp_cdText = sheetObj.EtcData('TEXT');
		cntr_tp_cdCode = sheetObj.EtcData('TEXT');
		sheetObj.RemoveEtcData();
		sheetObj.InitDataCombo(0, 'cntr_tp_cd', " |"+cntr_tp_cdText, " |"+cntr_tp_cdCode);
	}else if(formObj.f_cmd.value == SEARCH04){
		cntr_sz_cdText = sheetObj.EtcData('TEXT');
		cntr_sz_cdCode = sheetObj.EtcData('TEXT');
		sheetObj.RemoveEtcData();
		sheetObj.InitDataCombo(0, 'cntr_sz_cd', " |"+cntr_sz_cdText, " |"+cntr_sz_cdCode);
	}else if(formObj.f_cmd.value == SEARCH06){
		var ofc_cd = sheetObj.EtcData('OFC_CD');
		var ofc_tp_cd = sheetObj.EtcData('OFC_TP_CD');
		sheetObj.RemoveEtcData();
		if(ofc_cd == undefined || ofc_cd == '' || ofc_tp_cd == 'NO'){
			ComShowCodeMessage('LEA90008');
			sheetObj.CellValue2(sheetObj.SelectRow, 'ctrl_ofc_cd') = '';
		}
	}
}

/**
 * Location 이나 Contry Code 입력시 이벤트처리 
 *
 */
function sheet_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	if (!checkNode(sheetObj, row, colName, value)) return;
	formObject.TRSP_SO_EQ_KIND.value = '';
	if(value.length == 5) {
		formObject.f_cmd.value = SEARCH01;
		switch(colName){
			case 'fm_loc_value':
				if(sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') == 'CN'){
					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=fm_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'fm_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'fm_yard_value') = true;

				fm_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				sheetObj.CellComboItem(row, 'fm_yard_value', " |"+fm_yard_value, " |"+fm_yard_value) 
				break;

			case 'to_loc_value':
				if(sheetObj.CellValue(row, 'trsp_cost_dtl_mod_cd') == 'CF'){
					formObject.TRSP_SO_EQ_KIND.value = 'N';
				}
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=to_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'to_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'to_yard_value') = true;
				
				to_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				sheetObj.CellComboItem(row, 'to_yard_value', " |"+to_yard_value, " |"+to_yard_value);
				break;

			case 'via_loc_value':
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=via_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'via_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'via_yard_value') = true;
				
				via_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				sheetObj.CellComboItem(row, 'via_yard_value', " |"+via_yard_value, " |"+via_yard_value);
				break;

			case 'dor_loc_value':
				sheetObj.cellValue2(row, colName) = sheetObj.cellValue(row, colName).toUpperCase();
				var queryString = "col=dor_yard_value&row="+row+"&empty=Y&searchStr="+sheetObj.cellValue(row, colName)+"&"+TrsFrmQryString(formObject);
				sheetObj.InitCellProperty(row, 'dor_yard_value', dtCombo);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				sheetObj.CellEditable(row,'dor_yard_value') = true;
				
				dor_yard_value = sheetObj.EtcData('nod');
				sheetObj.RemoveEtcData();
				sheetObj.CellComboItem(row, 'dor_yard_value', " |"+dor_yard_value, " |"+dor_yard_value);
				break;
		}
	}else if(value.length == 2)
	{
		removeYard(sheetObj, row, colName, value);
		formObject.f_cmd.value = SEARCH02;
		switch(colName){
			case 'fm_loc_value':
				var queryString = "col=fm_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				if(!checkCountry(sheetObj.EtcData('CNT_CD'))){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'fm_yard_value') = false;
				break;

			case 'to_loc_value':
				var queryString = "col=to_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				if(!checkCountry(sheetObj.EtcData('CNT_CD'))){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'to_yard_value') = false;
				break;

			case 'via_loc_value':
				var queryString = "col=via_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				if(!checkCountry(sheetObj.EtcData('CNT_CD'))){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'via_yard_value') = false;
				break;

			case 'dor_loc_value':
				var queryString = "col=dor_yard_value&row="+row+"&searchStr="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				if(!checkCountry(sheetObj.EtcData('CNT_CD'))){
					sheetObj.CellValue2(row, colName) = '';
					return;
				}
				sheetObj.CellEditable(row,'dor_yard_value') = false;
				break;
		}
	}

	switch(colName){
		case 'ctrl_ofc_div_cd':
		case 'fm_loc_value':
		case 'to_loc_value':
		case 'via_loc_value':
		case 'dor_loc_value':
			//setControlOfficeSettring(sheetObj, row);
			break;
		case 'delcheck':
			if (value == '1'){
				sheetObj.CellValue2(row, 'delt_flg') = 'Y';
			}else{
				sheetObj.CellValue2(row, 'delt_flg') = 'N';
			}
			if(sheetObj.CellValue(row, 'org_delt_flg') == sheetObj.CellValue(row, 'delt_flg')){
				sheetObj.RowStatus(row) = 'R';
			}
			break;
//		case 'cgo_tp_cd':
//			if(value=='F'){
//				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', ""+F_trsp_cost_dtl_mod_cdText, ""+F_trsp_cost_dtl_mod_cdCode);
//				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', ""+trsp_crr_mod_cdText, ""+trsp_crr_mod_cdCode);
//			}else if(value=='M'){
//				sheetObj.CellComboItem(row, 'trsp_cost_dtl_mod_cd', ""+M_trsp_cost_dtl_mod_cdText, ""+M_trsp_cost_dtl_mod_cdCode);
//				sheetObj.CellComboItem(row, 'trsp_crr_mod_cd', ""+M_trsp_crr_mod_cdText, ""+M_trsp_crr_mod_cdCode);
//			}
//			break;
		case 'ctrl_ofc_cd':
			value = value.toUpperCase();
			sheetObj.CellValue2(row, colName) = value;
			if(ComTrim(value) != ''){
				formObject.f_cmd.value = SEARCH06;
				var queryString = "ctrl_ofc_cd="+value+"&"+TrsFrmQryString(formObject);
				sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
				//sheetObj.DoSearch("ESD_TRS_0079GS.do", queryString);
			}
			break;
	}

	switch(colName){
		case('fm_loc_value'):
		case('fm_yard_value'):
			sheetObj.CellValue2(row, 'fm_nod_cd') = sheetObj.CellValue(row, 'fm_loc_value')+sheetObj.CellValue(row, 'fm_yard_value');
			break;
		case('to_loc_value'):
		case('to_yard_value'):
			sheetObj.CellValue2(row, 'to_nod_cd') = sheetObj.CellValue(row, 'to_loc_value')+sheetObj.CellValue(row, 'to_yard_value');
			break;
		case('via_loc_value'):
		case('via_yard_value'):
			sheetObj.CellValue2(row, 'via_nod_cd') = sheetObj.CellValue(row, 'via_loc_value')+sheetObj.CellValue(row, 'via_yard_value');
			break;
		case('dor_loc_value'):
		case('dor_yard_value'):
			sheetObj.CellValue2(row, 'dor_nod_cd') = sheetObj.CellValue(row, 'dor_loc_value')+sheetObj.CellValue(row, 'dor_yard_value');
			break;

//		case('trsp_cost_dtl_mod_cd'):
//			sheetObj.CellValue2(row, 'fm_loc_value')="";
//			sheetObj.CellValue2(row, 'to_loc_value')="";
//			removeYard(sheetObj, row, 'fm_loc_value', value);
//			removeYard(sheetObj, row, 'to_loc_value', value);
//			
//			if(value == "DR" || value.trim() == "") {
//				sheetObj.CellEditable(row,'dor_yard_value') = true;
//				sheetObj.CellEditable(row,'dor_loc_value') = true;
//			}else{
//				sheetObj.CellValue2(row, 'dor_loc_value')="";
//				removeYard(sheetObj, row, 'dor_loc_value', value);
//				sheetObj.CellEditable(row,'dor_yard_value') = false;
//				sheetObj.CellEditable(row,'dor_loc_value') = false;
//			}
//			
//			if(value == 'CN' || value == 'CF'){
//				sheetObj.CellValue2(row, 'trsp_crr_mod_cd')="TD";
//				sheetObj.CellEditable(row,'trsp_crr_mod_cd') = false;
//			}else{
//				sheetObj.CellEditable(row,'trsp_crr_mod_cd') = true;
//			}
//			break;
//		
//		case('trsp_crr_mod_cd'):
//			if(value == 'RD' || value == 'TD' || value == 'WD'){
//				sheetObj.CellValue2(row, 'via_loc_value')="";
//				removeYard(sheetObj, row, 'via_loc_value', value);
//				sheetObj.CellEditable(row,'via_yard_value') = false;
//				sheetObj.CellEditable(row,'via_loc_value') = false;
//			}else{
//				sheetObj.CellEditable(row,'via_yard_value') = true;
//				sheetObj.CellEditable(row,'via_loc_value') = true;
//			}
//			break;
//
//		case('cgo_tp_cd'):
//			if(value == 'M'){
//				sheetObj.CellValue2(row, 'via_loc_value')="";
//				removeYard(sheetObj, row, 'via_loc_value', value);
//				sheetObj.CellEditable(row,'via_yard_value') = false;
//				sheetObj.CellEditable(row,'via_loc_value') = false;
//				
//				sheetObj.CellValue2(row, 'dor_loc_value')="";
//				removeYard(sheetObj, row, 'dor_loc_value', value);
//				sheetObj.CellEditable(row,'dor_yard_value') = false;
//				sheetObj.CellEditable(row,'dor_loc_value') = false;
//			}else{
//				sheetObj.CellEditable(row,'via_yard_value') = false;
//				sheetObj.CellEditable(row,'via_loc_value') = false;
//
//				sheetObj.CellEditable(row,'dor_yard_value') = false;
//				sheetObj.CellEditable(row,'dor_loc_value') = false;
//			}
//			break;
	}
}


function checkNode(sheetObj, row, colName, value)
{
	if (colName != 'fm_loc_value' && colName != 'to_loc_value' && colName != 'via_loc_value' && colName != 'dor_loc_value' )
	{
		return true;
	}

	if(value.length != 2 && value.length != 5)
	{
		switch(colName){
			case 'fm_loc_value':
				sheetObj.CellValue2(row, 'fm_loc_value')="";
				break;
			case 'to_loc_value':
				sheetObj.CellValue2(row, 'to_loc_value')="";
				break;
			case 'via_loc_value':
				sheetObj.CellValue2(row, 'via_loc_value')="";
				break;
			case 'dor_loc_value':
				sheetObj.CellValue2(row, 'dor_loc_value')="";
				break;
		}
		removeYard(sheetObj, row, colName, value);
		return false;
	}

	return true;
}

function removeYard(sheetObj, row, col, value){
	switch(col){
			case 'fm_loc_value':
				sheetObj.CellValue2(row, 'fm_yard_value')="";
				sheetObj.CellComboItem(row, 'fm_yard_value', '', '');
				break;
			case 'to_loc_value':
				sheetObj.CellValue2(row, 'to_yard_value')="";
				sheetObj.CellComboItem(row, 'to_yard_value', '', '');
				break;
			case 'via_loc_value':
				sheetObj.CellValue2(row, 'via_yard_value')="";
				sheetObj.CellComboItem(row, 'via_yard_value', '', '');
				break;
			case 'dor_loc_value':
				sheetObj.CellValue2(row, 'dor_yard_value')="";
				sheetObj.CellComboItem(row, 'dor_yard_value', '', '');
				break;
		}
}


function checkCountry(value)
{
	if(value == '' || value == undefined)
	{
		ComShowCodeMessage('TRS90115');
		return false;
	}else{
		return true;
	}
}


function setControlOfficeSettring(sheetObj, row){
	var value = sheetObj.CellValue(row, 'ctrl_ofc_div_cd');
	var formObject = document.form;
	formObject.f_cmd.value = SEARCH03;
	var selectColumnName = '';
	if(value == 'F') selectColumnName = 'fm_loc_value';
	else if(value == 'T') selectColumnName = 'to_loc_value';
	else if(value == 'V') selectColumnName = 'via_loc_value';
	else if(value == 'D') selectColumnName = 'dor_loc_value';
	var locationValue = sheetObj.CellValue(row, selectColumnName);

	if(locationValue.length == 5){
		var queryString = "col=ctrl_ofc_cd&row="+row+"&searchStr="+locationValue+"&"+TrsFrmQryString(formObject);
			sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
	}else{
		sheetObj.CellValue2(row, 'ctrl_ofc_cd') = '';
	}
}

