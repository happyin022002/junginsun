/**
 * @class ESD_TRS_0922
 */
function ESD_TRS_0922() {
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

var verifyFlag = false;
var sheetObjects = new Array();
var sheetCnt = 0;

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
			case 'btng_downexcel':
				sheetObject.Down2Excel(-1,false,false,true);
				break;
			
			case 'btn_apply':
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

			case "btn_fileselect":
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

			case "btn_verify":
				if(sheetObject.RowCount < 1) return;
				getVerifyEqNo(sheetObject, formObject);
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
 * IBSheet Object를 배열로 등록
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
				style.height = GetSheetHeight(20);
									
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
				InitColumnInfo(15, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D]) 
				InitHeadMode(true, true, true, true, false,false)

				var HeadTitle = "|Seq.| |Verify Result|EQ No|EQ TP/SZ|S/O No|W/O No|Invoice Total Amount";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
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

	var opener_queryStr = getOpenerData();
	ComOpenWait(false);
	formObj.f_cmd.value = SEARCH14;

	sheetObj.DoRowSearch("ESD_TRS_0033_01GS.do", queryStr+'&'+TrsFrmQryString(formObj)+'&'+opener_queryStr);
	
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
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_audit.CellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_audit.CellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_audit.CellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_audit.CellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_audit.CellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}

	for(var i=2; i< sheetObj_confirm.RowCount+2; i++){
		queryStr += '&'+prefix+'trsp_so_ofc_cty_cd='	+sheetObj_confirm.CellValue(i, 'trsp_so_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_so_seq='			+sheetObj_confirm.CellValue(i, 'trsp_so_seq');
		queryStr += '&'+prefix+'trsp_wo_ofc_cty_cd='	+sheetObj_confirm.CellValue(i, 'trsp_wo_ofc_cty_cd');
		queryStr += '&'+prefix+'trsp_wo_seq='			+sheetObj_confirm.CellValue(i, 'trsp_wo_seq');
		queryStr += '&'+prefix+'eq_no='					+sheetObj_confirm.CellValue(i, 'eq_no');
		queryStr += '&'+prefix+'trsp_so_cmb_seq='		+i;
		queryStr += '&'+prefix+'ibflag=R'
	}
	
	return queryStr;
}

function importInvoiceFile(sheetObj_popup){

    var opener_obj = window.dialogArguments;
	var sheetObj_main = opener_obj.sheetObjects[0];

	var formObj = document.form;
	
	var queryStr = sheetObj_popup.GetSaveString(false, true, "ibcheck");
	if(queryStr=='') return false;

	formObj.f_cmd.value = SEARCH15;
	opener_obj.form.f_cmd.value = SEARCH15;
	sheetObj_main.DoSearch4Post("ESD_TRS_0033GS.do", queryStr, TrsFrmQryString(formObj), true);
	
}