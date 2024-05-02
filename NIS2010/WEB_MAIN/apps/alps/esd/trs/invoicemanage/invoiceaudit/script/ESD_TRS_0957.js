/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0957 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0957() {
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
var verifyFlag = false;
var sheetCnt = 0;

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

			case "btng_fileimport":
				ComOpenWait(true);
				sheetObject.LoadExcel(-1,1,'',-1,-1,'',false);
				sheetObject.CheckAll2('ibcheck')=1;
				for(var i=1; i<sheetObject.RowCount+1; i++){
					sheetObject.CellValue2(i, 'inv_rmk') = '';
				}

				for(var a=sheetObjects[0].RowCount; a>0 ;a--){
					if(sheetObjects[0].CellValue(a, 'eq_no') == '' 
						&& sheetObjects[0].CellValue(a, 'prnt_trsp_so_ofc_cty_cd') == ''
						&& sheetObjects[0].CellValue(a, 'prnt_trsp_so_seq') == ''){
							sheetObjects[0].RowDelete(a, false);
						}
				}
				ComOpenWait(false);
				break;

			case "btng_delete":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var checkArray = checkList.split('|');
				for(var i=checkArray.length-2; i>-1 ; i--){
					sheetObject.RowDelete(checkArray[i], false);
				}	
				break;

			case "btng_verify":
				if(sheetObject.RowCount < 1) return;
				getVerifyEqNo(sheetObject, formObject);
				break;

			case "btng_apply":
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				if(checkList == ''){
					ComShowCodeMessage('COM12176');
					return false;
				}
				
				ComOpenWait(true);
				sheetObject.DoSearch4Post("ESD_TRS_0969.screen", '', '', true);
				
				if(!verifyFlag){
					ComShowCodeMessage('TRS90055');
					ComOpenWait(false);
					return;
				}
				
				importInvoiceFile(sheetObject);
				ComOpenWait(false);
				window.close();
				break;

			case "btn_close":
				window.close();
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
				style.height = GetSheetHeight(10);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//포커스 선택된 행의 하이라이트 여부를 확인하거나 설정한다.
				SelectHighLight = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 1, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				var HeadTitle = "|Seq.| |Verify Result|EQ No|EQ TP/SZ|S/O No|W/O No|Invoice Total Amount";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN,		COLMERGE,	SAVENAME,			KEYFIELD, CALCULOGIC, DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				
				InitDataProperty(0, cnt++, dtStatus,     0,    daCenter,  false,   "ibflag");
				InitDataProperty(0, cnt++, dtSeq,       50,    daCenter,  true,    "trsp_so_cmb_seq");
				InitDataProperty(0, cnt++, dtCheckBox,  20,    daCenter,  true,    "ibcheck",					false,		"",  dfNone,    0,     true,		true);
				InitDataProperty(0, cnt++, dtData,     250,    daLeft,    true,    "inv_rmk",					false,		"",  dfNone,    2000,  false,       false);
				InitDataProperty(0, cnt++, dtData,      80,    daCenter,  true,    "eq_no",						false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,      60,    daCenter,  true,    "eq_tpsz_cd",				false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,      90,    daCenter,  false,   "prnt_trsp_so_ofc_cty_cd",	false,		"",  dfNone,	0,     false,		false);
				InitDataProperty(0, cnt++, dtData,      90,    daCenter,  true,    "prnt_trsp_so_seq",			false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtData,     130,    daCenter,  true,    "inv_bzc_amt",				false,		"",  dfFloat,	2,     false,       false);
				InitDataProperty(0, cnt++, dtHidden,   100,    daCenter,  true,    "trsp_wo_ofc_cty_cd",        false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtHidden,   100,    daCenter,  true,    "trsp_wo_seq",				false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtHidden,    10,    daCenter,  true,    "trsp_so_ofc_cty_cd",		false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtHidden,    10,    daCenter,  true,    "trsp_so_seq",				false,		"",  dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++, dtCheckBox,  10,    daCenter,  true,    "nis_check");
				InitDataProperty(0, cnt++, dtHidden,    10,    daCenter,  true,    "cntr_sub_flg");
				
				ColHidden('ibflag')						= true;
				ColHidden('nis_check')					= true;
		   }
			break;
	}
}


// 숫자만 사용가능
function get_only_num(obj) {
	var str = escape(obj);
	var returnNum = '';
	for (i=0; i<str.length; i++){
		if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
		returnNum += str.charAt(i);
	}
	return returnNum;
}

function sheet1_OnChange(sheetObj, row, col, value){
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
	case 'trsp_so_ofc_cty_cd_seq':
		if(value != ''){
			sheetObj.CellValue2(i, 'trsp_so_ofc_cty_cd') = value.substring(0,3);
			sheetObj.CellValue2(i, 'trsp_so_seq') = value.substring(3);
		}
		break;
	case 'trsp_wo_ofc_cty_cd_seq':
		if(value != ''){
			sheetObj.CellValue2(i, 'trsp_wo_ofc_cty_cd') = value.substring(0,3);
			sheetObj.CellValue2(i, 'trsp_wo_seq') = value.substring(3);
		}
		break;
	}
}

function getVerifyEqNo(sheetObj, formObj){
	
	var checkList = sheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');

	if(checkList == '') return;
	ComOpenWait(true);
	sheetObj.DoSearch4Post("ESD_TRS_0969.screen", '', '', true);
	var queryStr = sheetObj.GetSaveString(false, true, 'ibcheck');
	if(queryStr=='') return;
//	var opener_queryStr = getOpenerData();
	ComOpenWait(false);
	formObj.f_cmd.value = SEARCH14;
	sheetObj.DoRowSearch("ESD_TRS_0033_01GS.do", queryStr+'&'+TrsFrmQryString(formObj));
}

/**
 * 저장결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
	//	ComShowMessage(errMsg);
	}else{
		/* 로그인한 사용자의 OFFICE CD에 해당되는 CURRENCY로 설정한다. */
		if(formObj.f_cmd.value == SEARCH14){
			verifyFlag = true;
		}
	}
}


function getOpenerData(){
	var opener_obj = window.dialogArguments;

	var sheetObj_audit = opener_obj.sheetObjects[0];
	var sheetObj_confirm = opener_obj.sheetObjects[1];
	var prefix = 'opener_';

	var queryStr = '';

	for(var i=2; i< sheetObj_audit.RowCount+2; i++){
		if(sheetObj_audit.CellValue(i, 'chk1') == 0){
			queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_audit.CellValue(i, 'trsp_so_ofc_cty_cd');
			queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_audit.CellValue(i, 'trsp_so_seq');
			queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_audit.CellValue(i, 'trsp_wo_ofc_cty_cd');
			queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_audit.CellValue(i, 'trsp_wo_seq');
			queryStr += '&'+prefix+'eq_no='					+sheetObj_audit.CellValue(i, 'eq_no');
			queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
			queryStr += '&'+prefix+'ibflag=R';
		}
	}

	for(var i=2; i< sheetObj_confirm.RowCount+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_confirm.CellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_confirm.CellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_confirm.CellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_confirm.CellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_confirm.CellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R';
	}
	
	return queryStr;
}

/**
 * Container File Imort에서 verify된 EQ_NO를 SHEET에 import한다.
 **/
function importInvoiceFile(popSheetObj){
	var opener_obj = window.dialogArguments;
	var sheetObj_main = opener_obj.sheetObjects[0];
	//var sheetObj_nis = opener.sheetObjects[4];
	var formObj = document.form;
	
	var queryStr = popSheetObj.GetSaveString(false, true, "ibcheck");
	if(queryStr=='') return false;

	var checkList = popSheetObj.FindCheckedRow('ibcheck');
	var checkArray = checkList.split('|');
	
	var main_checkList = sheetObj_main.FindCheckedRow('chk1');
	var main_checkArray = main_checkList.split('|');

	// eq_no가 비어있는 row를 array로 담는다.
	var emptyEqArray = new Array();
	var cnt=0;

	for(var k=0; k<main_checkArray.length-1; k++)
	{
		if(sheetObj_main.CellValue(main_checkArray[k], 'eq_no')==''){
			emptyEqArray[cnt++] = main_checkArray[k];
		}
	}

	for(var k=0; k<emptyEqArray.length; k++)
	{
		for(var m=0; m<checkArray.length-1; m++) {
			if(checkArray[m] != -1 &&
			   sheetObj_main.CellValue(emptyEqArray[k], 'eq_tpsz_cd') == 
				popSheetObj.CellValue(checkArray[m], 'eq_tpsz_cd') &&
			   sheetObj_main.CellValue(emptyEqArray[k], 'trsp_wo_seq') == 
				popSheetObj.CellValue(checkArray[m], 'trsp_wo_seq')
				&& sheetObj_main.CellValue(emptyEqArray[k], 'eq_no') == ''
				) {
				sheetObj_main.CellValue2(emptyEqArray[k], 'eq_no') = popSheetObj.CellValue(checkArray[m], 'eq_no');
				sheetObj_main.CellValue2(emptyEqArray[k], 'chk1') = '1';
				checkArray[m] = -1;
				break;
			}
		}
	}
	
	formObj.f_cmd.value = SEARCH15;
	opener_obj.form.f_cmd.value = SEARCH15;
	sheetObj_main.DoSearch4Post("ESD_TRS_0033GS.do", '', '', true);

	/*
	var queryStr = popSheetObj.GetSaveString(false, true, 'nis_check');

	sheetObj_nis.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', true);

	for(var i=1; i < sheetObj_nis.RowCount+1; i++){
		sheetObj_nis.CellValue2(i, 'trsp_wo_ofc_cty_cd_seq') = sheetObj_nis.CellValue(i, 'trsp_wo_ofc_cty_cd')
																+sheetObj_nis.CellValue(i, 'trsp_wo_seq');
	} */
}

