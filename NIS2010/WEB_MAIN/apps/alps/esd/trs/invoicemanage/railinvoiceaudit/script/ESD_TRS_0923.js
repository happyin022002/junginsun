/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0923 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0923() {
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

// 부모창 관련 컨트롤(변수 및 함수 , 그리드 컨트롤)
var opener = window.dialogArguments;

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

			case "btng_select":
				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
				break;

			case "btng_verify":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;

			case "btn_apply":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_close":
				window.close();
				break;

		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("TRS90392");
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
				style.height = GetSheetHeight(8) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(39, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				var HeadTitle = "STS|Seq.|S|A|CNTR No.|Waybill No.|Waybill Date|Origin|Destination|Amount|Verify Result";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]                    
				InitDataProperty(0, cnt++ , dtStatus,	  30,    daCenter,  true,      "ibflag",        false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtDataSeq,	  30,    daCenter,   false,    "seq",      false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,   false,    "ibcheck",  false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtCheckBox,   30,    daCenter,   false,    "apply_check",  false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "cntr_no",   false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "wbl_no",     false,          "",      dfNone,          0,     true,       true , 6 );
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "wbl_dt",     false,          "",      dfDateYmd,       0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     false,    "inv_org_nod_nm",     false,          "",      dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      120,    daLeft,     false,    "inv_dest_nod_nm",false,          "",      dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       60,    daRight,    false,    "inv_bil_amt",     false,          "",      dfFloat,       2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daLeft,     false,    "result",     false,          "",      dfNone,          0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  true,    "eq_no",        false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,       40,    daCenter,  true,    "eq_tpsz_cd",        false,          "",       dfNone,    0,     false,      false);
				InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,    "cgo_tp_cd",        false,          "",       dfNone,    0,     false,      true);
				InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,    "fm_nod_cd1",        false,          "",       dfEngUpKey,    0,     false,       true ,5 , true);
				InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true,    "fm_nod_cd2",        false,          "",       dfNone,    0,     false,       true);
				
				InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,    "to_nod_cd1",        false,          "",       dfEngUpKey,    0,     false,       true ,5 , true);
				InitDataProperty(0, cnt++ , dtHidden,       30,    daCenter,  true,    "to_nod_cd2",        false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      60,    daCenter,  true,    "curr_cd",        false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "bzc_amt",        false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "fuel_scg_amt",        false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "hzd_mtrl_scg_amt",        false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "etc_add_amt",        false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "ovr_wgt_scg_amt",        false,          "",       dfFloat,    2,     false,       false);
				
				InitDataProperty(0, cnt++ , dtHidden,      60,    daCenter,  true,    "inv_curr_cd",        false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "inv_etc_add_amt",        false,          "",       dfFloat,    2,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       70,    daRight,  true,    "inv_bzc_amt",        false,          "|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",       dfFloat,    2,     false,       false);
				
				InitDataProperty(0, cnt++ , dtHidden,       80,    daCenter,  true,    "rail_bil_dt",        false,          "",       dfDateYmd,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       50,    daCenter,  true,    "org_trsp_rail_inv_aud_cd",        false,          "",       dfNone,    0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "fm_nod_cd",        false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "to_nod_cd",        false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "trsp_so_ofc_cty_cd",        false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "trsp_so_seq",        false,          "",       dfNone,    0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "trsp_inv_tp_cd");
				InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,  true,    "trsp_inv_co_ind_cd");
				InitDataProperty(0, cnt++, dtCheckBox,    10,    daCenter,  true,    "coincidence_check");
				InitDataProperty(0, cnt++, dtCheckBox,    10,    daCenter,  true,    "descrepancy_check");
				InitDataProperty(0, cnt++, dtCheckBox,    10,    daCenter,  true,    "inv_only_check");
				InitDataProperty(0, cnt++, dtCheckBox,     0,    daCenter,  true,    "pay_flg");

				ColHidden('delcheck')								= true;
				ColHidden('ibflag')									= true;
				ColHidden('coincidence_check')						= true;
				ColHidden('descrepancy_check')						= true;
				ColHidden('inv_only_check')							= true;
				ColHidden('pay_flg')								= true;
		   }
		   break;
	}
}


// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSAVE:        //verify result

			formObj.f_cmd.value	= SEARCH01;
			var param			= '';
			var checkList		= sheetObj.FindCheckedRow('ibcheck');
			var checkArray		= checkList.split('|');

			if(checkList == ''){
					ComShowCodeMessage('COM12176');					
					ComOpenWait(false);
					return false;				
			}

			for(var i=0; i<checkArray.length-1; i++){
				param	+= '&ibflag=R&result=';
				param	+= '&seq='+sheetObj.CellValue(checkArray[i], 'seq');
				param	+= '&cntr_no='+sheetObj.CellValue(checkArray[i], 'cntr_no');
				param	+= '&wbl_dt='+sheetObj.CellValue(checkArray[i], 'wbl_dt');
				param	+= '&inv_bil_amt='+sheetObj.CellValue(checkArray[i], 'inv_bil_amt');
			}

			var sXml = sheetObj.GetSaveXml("ESD_TRS_0923GS.do", param+"&"+TrsFrmQryString(formObj));
			sheetObj.LoadSearchXml(sXml,false, -1, true);
		break;
		
	   case IBSEARCH:
			apply(sheetObj);
		   break;

	   case IBLOADEXCEL:        //엑셀 업로드
		  sheetObj.LoadExcel();
		  var cntr_no = null;
		  for(var row=1; row< sheetObj.RowCount+1; row++){
			cntr_no = sheetObj.CellValue(row, 'cntr_no') != null && sheetObj.CellValue(row, 'cntr_no') != "" ? ComTrim(sheetObj.CellValue(row, 'cntr_no')) : sheetObj.CellValue(row, 'cntr_no');
			if( cntr_no.length == 10 ){
				sheetObj.CellValue2(row, 'cntr_no') = ComGetCntrNoFull(cntr_no);
			}
		  }
		  //CNTR No, Waybill No, Waybill Date 미존재시 Row Delete 2013.11.13 조인영
			for(var a=sheetObj.RowCount; a>0 ;a--){
				if(sheetObj.CellValue(a, 'cntr_no') == '' 
					&& sheetObj.CellValue(a, 'wbl_no') == ''
					&& sheetObj.CellValue(a, 'wbl_dt') == ''){
					sheetObj.RowDelete(a, false);
					}
				//Waybill Date 미존재시 Validation 추가 2013.11.13 조인영
				if(sheetObj.CellValue(a, 'wbl_dt') == ''){
					ComShowCodeMessage('COM12114', 'Waybill Date');
					sheetObj.SelectCell(a, 'wbl_dt');
					return false;
					}
			}
		  sheetObj.CheckAll('ibcheck') = '1';
		  break;
	}
}

function sheet1_OnSearchEnd(sheetObj , ErrMsg)
{
	var formObj = document.form;

	if( ErrMsg != null && ErrMsg != '' ) {
		ComShowMessage(ErrMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH01){
			setMainControl();
		}
	}
}

function sheet1_OnChange(sheetObj, row, col, value){
	var colName = sheetObj.ColSaveName(col);
	var formObj = document.form;

	switch(colName)
	{
		case('cntr_no'):
			sheetObj.CellValue2(row, colName) = ComGetCntrNoFull(value);
			break;

		case('apply_check'):
			if(value == 1 && sheetObj.CellValue(row, 'result') == '') {
				sheetObj.CellValue2(row, col) = 0;
			}
			break;
	}
}

function setMainControl()
{
	opener.document.form.inv_no.readOnly=true ;
	opener.document.form.currency.disabled= true;
	opener.document.rail_road_code.Enable  =false;
}

function apply(sheetObj){
	for (idx=1; idx<sheetObj.RowCount+1; idx++){
		if(sheetObj.CellValue(idx, 'apply_check') == '0'){
			sheetObj.CellValue2(idx, 'coincidence_check')	= '0';
			sheetObj.CellValue2(idx, 'descrepancy_check')	= '0';
			sheetObj.CellValue2(idx, 'inv_only_check')		= '0';
		}
	}

	var queryStr = sheetObj.GetSaveString(false, false, 'coincidence_check');
	var xml = null;
	if(queryStr !=''){
		xml = sheetObj.GetSearchXml("ESD_TRS_0969.screen", queryStr,'', true);
		opener.document.t1sheet1.LoadSearchXml(xml,false);
	}

	queryStr = sheetObj.GetSaveString(false, false, 'descrepancy_check');
	if(queryStr !=''){
		xml = sheetObj.GetSearchXml("ESD_TRS_0969.screen", queryStr,'', true);
		opener.document.t2sheet1.LoadSearchXml(xml,false);
	}

	queryStr = getInvoiceOnlyStr(sheetObj);
	if(queryStr !=''){
		xml = sheetObj.GetSearchXml("ESD_TRS_0969.screen", queryStr,'', true);
		opener.document.t3sheet1.LoadSearchXml(xml,false);
	}

	opener.document.form.sts_cd.value = "FI";
	opener.setTotalAmtForPayment();

	ComShowCodeMessage('COM12116', 'Apply');
	window.close();
}

function getInvoiceOnlyStr(sheetObj){

	var checkList		= sheetObj.FindCheckedRow('inv_only_check');
	var checkArray		= checkList.split('|');
	var queryStr		= '';
	var result			= '';

	for(var i=0; i<checkArray.length-1; i++){
		if(i!=0){
			queryStr += '&'
		}
		queryStr += 'ibflag='+sheetObj.CellValue(checkArray[i], 'ibflag');
		queryStr += '&trsp_inv_co_ind_cd='+sheetObj.CellValue(checkArray[i], 'trsp_inv_co_ind_cd');
		queryStr += '&eq_no='+sheetObj.CellValue(checkArray[i], 'eq_no');
		queryStr += '&eq_tpsz_cd='+sheetObj.CellValue(checkArray[i], 'eq_tpsz_cd');
		queryStr += '&wbl_no='+sheetObj.CellValue(checkArray[i], 'wbl_no');
		queryStr += '&wbl_dt='+sheetObj.CellValue(checkArray[i], 'wbl_dt');
		queryStr += '&inv_org_nod_nm='+sheetObj.CellValue(checkArray[i], 'inv_org_nod_nm');
		queryStr += '&inv_dest_nod_nm='+sheetObj.CellValue(checkArray[i], 'inv_dest_nod_nm');
		queryStr += '&inv_bil_amt='+sheetObj.CellValue(checkArray[i], 'inv_bil_amt');
		queryStr += '&result='+sheetObj.CellValue(checkArray[i], 'result');
		queryStr += '&inv_curr_cd='+sheetObj.CellValue(checkArray[i], 'inv_curr_cd');		
	}
	return queryStr;
}