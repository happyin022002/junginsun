/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0908.js
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-31 kim_sang_geun
* 1.0 최초 생성
* ------------------------------------------------------
* history
* 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @class ESD_TRS_0908 : CNTR SELECT POPUP
 */
function ESD_TRS_0908() {
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
var sheetObjSingle; //Single Transportation opener
var preSelectRow = 0;

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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[2],document.form,'IBSEARCH04');
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
				style.height = GetSheetHeight(7);
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
					InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				//포커스 선택된 행의 하이라이트 여부를 확인하거나 설정한다.
				SelectHighLight = false;

				InitRowInfo(1, 1, 7, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(13, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, false, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle0 = "|BKG No|TRO\nSEQ|S/O No|W/O No|S/O\nTP/SZ|Original\nBKG No|Revised\nTRO SEQ";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck,    30, daCenter, true, "ibcheck",               false, "", dfNone, 0, true,   true );
				InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "bkg_no",                false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "tro_seq",               false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "trsp_so_ofc_cty_cd_seq",false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "trsp_wo_ofc_cty_cd_seq",false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          60, daCenter, true, "eq_tpsz_cd",            false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "org_bkg_no",           false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "rvis_tro_seq",          false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,           0, daCenter, true, "trsp_so_ofc_cty_cd",    false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,           0, daCenter, true, "trsp_so_seq",           false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,           0, daCenter, true, "trsp_wo_ofc_cty_cd",    false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,           0, daCenter, true, "trsp_wo_seq",           false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, true, "ibflag",                false, "", dfNone, 0, false,  false);
				
				ColHidden('trsp_so_ofc_cty_cd')              = true;
				ColHidden('trsp_so_seq')                     = true;
				ColHidden('trsp_wo_ofc_cty_cd')              = true;
				ColHidden('trsp_wo_seq')                     = true;
			}
		break;

		case 2:      //sheet1 init
			with (sheetObj) {
				style.height = GetSheetHeight(7);
				SheetWidth = mainTable.clientWidth; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
				   InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = true; //전체Edit 허용 여부 [선택, Default false]
				//포커스 선택된 행의 하이라이트 여부를 확인하거나 설정한다.
				SelectHighLight = false;

				InitRowInfo(1, 1, 6, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(10, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, false, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle0 = "|BKG No|BKG STS|CNTR No|TP/SZ|Applied S/O No|Duplication Check";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtRadioCheck,    30, daCenter, true, "ibcheck",               false, "", dfNone, 0, true,   true );
				InitDataProperty(0, cnt++, dtData,          90, daCenter, true, "bkg_no",                false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "bkg_sts_cd",            false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "eq_no",                 false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,          50, daCenter, true, "eq_tpsz_cd",            false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "apply_so_seq",          false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtData,         100, daCenter, true, "dup_check",             false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, true, "ibflag",                false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtSeq         ,   0, daCenter, true, "ibseq",                 false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "org_apply_so_seq",      false, "", dfNone, 0, false,  false);
				
				ColHidden('ibseq')                     = true;

			}
		break;

		case 3:      //sheet1 init
			with (sheetObj) {
				Visible      = false;
				style.height = 0;
				SheetWidth   = 0; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
				   InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo(1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(3, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, false, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle0 = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, true, "ibflag",               false, "", dfNone, 0, false,  false );
				InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "cntr_tpsz_cd",         false, "", dfNone, 0, false,  false);
				InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "prov_cntr_tpsz_cd",    false, "", dfNone, 0, false,  false);
			}
		break;

        case 4:      //sheet1 init
			with (sheetObj) {
				Visible      = false;
				style.height = 0;
				SheetWidth   = 0; //전체 너비 설정

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "")
				   InitHostInfo(location.hostname, location.port, page_path);

				MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
				Editable = false; //전체Edit 허용 여부 [선택, Default false]

				InitRowInfo(1, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitColumnInfo(2, 0, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitHeadMode(true, true, false, true, false, false); // 해더에서 처리할 수 있는 각종 기능을 설정한다

				var HeadTitle0 = "";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle0, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus,   0, daCenter, true, "ibflag",               false, "", dfNone, 0, false,  false );
				InitDataProperty(0, cnt++, dtHidden,         0, daCenter, true, "bkg_no",         false, "", dfNone, 0, false,  false);
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
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {
			case "btn_close":
				window.close();
			break;

			case "btn_apply":
				doActionIBSheet(sheetObjects[1],formObject,'IBSEARCH03');
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			errMsg = ComGetMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e);
		}
	}
}

	
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	var opener_obj = window.dialogArguments;
	sheetObj.ShowDebugMsg = false;
    var openerMainSheet = opener_obj.sheetObjects[formObj.mainSheetArrayNo.value];
	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH01;
			
			
			var checkList = openerMainSheet.FindCheckedRow('chk1');
			var checkArray = checkList.split('|');
		
			var queryStr = '';

			for(var i=0; i<checkArray.length-1; i++){
				queryStr += '&ibflag=R';
				queryStr += '&bkg_no='+openerMainSheet.CellValue(checkArray[i], 'bkg_no');
				queryStr += '&trsp_so_ofc_cty_cd='+openerMainSheet.CellValue(checkArray[i], 'trsp_so_ofc_cty_cd');
				queryStr += '&trsp_so_seq='+openerMainSheet.CellValue(checkArray[i], 'trsp_so_seq');
			}
			

			sheetObj.DoSearch4Post("ESD_TRS_0908GS.do", TrsFrmQryString(formObj), queryStr, false);
		break;

		case 'IBSEARCH02':      //조회
			formObj.f_cmd.value = SEARCH02;
			var mainSheetObj = sheetObjects[0];
			var query = mainSheetObj.GetSaveString(true, true);
			sheetObj.DoSearch4Post("ESD_TRS_0908GS.do", TrsFrmQryString(formObj), query, false);
		break;

		case 'IBSEARCH03':      //조회
			
			formObj.f_cmd.value = SEARCH03;
			var query = '';
			for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
				sheetObj.CellValue2(i, 'dup_check') = '';
				if(sheetObj.CellValue(i, 'org_apply_so_seq') != '' && opener_obj.document.form.conti_cd.value != 'E'){
					continue;
				}else if(sheetObj.CellValue(i, 'apply_so_seq') != ''){
					query +='&ibflag=S'
					query +='&bkg_no=' + sheetObj.CellValue(i, 'bkg_no');
					query +='&eq_no=' + sheetObj.CellValue(i, 'eq_no');
					query +='&por_cd=' + i;
				}
			}

			
			var openMainQuery = '';
			var prefix = 'main_';

			openMainQuery += '&prefix='+prefix;
			openMainQuery += '&mode=duplicate_check';


			for(var i=openerMainSheet.HeaderRows; i<openerMainSheet.RowCount+openerMainSheet.HeaderRows; i++){
				if(openerMainSheet.CellValue(i, 'trsp_bnd_cd') == 'O' &&
					(openerMainSheet.CellValue(i, 'trsp_cost_dtl_mod_cd') == 'DR' ||
					openerMainSheet.CellValue(i, 'trsp_cost_dtl_mod_cd') == 'DOOR' )&&
					openerMainSheet.CellValue(i, 'eq_no') != '') {
				openMainQuery +='&'+prefix+'ibflag=S';
				openMainQuery +='&'+prefix+'bkg_no='+openerMainSheet.CellValue(i, 'bkg_no');
				openMainQuery +='&'+prefix+'eq_no='+openerMainSheet.CellValue(i, 'eq_no');
				openMainQuery +='&'+prefix+'trsp_so_ofc_cty_cd='+openerMainSheet.CellValue(i, 'trsp_so_ofc_cty_cd');
				openMainQuery +='&'+prefix+'trsp_so_seq='+openerMainSheet.CellValue(i, 'trsp_so_seq');
				openMainQuery +='&'+prefix+'tro_seq='+openerMainSheet.CellValue(i, 'tro_seq');
				}
			}
			var openerSecondSheet = opener_obj.sheetObjects[1];

			for(var i=openerSecondSheet.HeaderRows; i<openerSecondSheet.RowCount+openerSecondSheet.HeaderRows; i++){
				if(openerSecondSheet.CellValue(i, 'trsp_bnd_cd') == 'O' &&
					(openerSecondSheet.CellValue(i, 'trsp_cost_dtl_mod_cd') == 'DR' ||
					openerSecondSheet.CellValue(i, 'trsp_cost_dtl_mod_cd') == 'DOOR' ) &&
					openerSecondSheet.CellValue(i, 'eq_no') != '') {
				openMainQuery +='&'+prefix+'ibflag=S';
				openMainQuery +='&'+prefix+'bkg_no='+openerSecondSheet.CellValue(i, 'bkg_no');
				openMainQuery +='&'+prefix+'eq_no='+openerSecondSheet.CellValue(i, 'eq_no');
				openMainQuery +='&'+prefix+'trsp_so_ofc_cty_cd='+openerSecondSheet.CellValue(i, 'trsp_so_ofc_cty_cd');
				openMainQuery +='&'+prefix+'trsp_so_seq='+openerSecondSheet.CellValue(i, 'trsp_so_seq');
				openMainQuery +='&'+prefix+'tro_seq='+openerSecondSheet.CellValue(i, 'tro_seq');
				}
			}

			sheetObj.RemoveEtcData();
			formObj.f_cmd.value = SEARCH04;

			sheetObj.DoRowSearch("ESD_TRS_0968.screen", TrsFrmQryString(formObj)+query+openMainQuery, true);

			
		break;

		case 'IBSEARCH04':      //조회
			formObj.f_cmd.value = SEARCH03;
			sheetObj.DoSearch4Post("ESD_TRS_0908GS.do", TrsFrmQryString(formObj), '', false);
		break;
	}
}

function sheet1_OnChange(sheetObj, row , col , value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);

	switch(colName){
		case 'ibcheck':
			//doActionIBSheet(sheetObjects[1], formObject,'IBSEARCH02');
			var bkg_no = sheetObj.CellValue(row, 'bkg_no');
			var org_bkg_no = sheetObj.CellValue(row, 'org_bkg_no');
			var eq_tpsz_cd = sheetObj.CellValue(row, 'eq_tpsz_cd');
			
            formObject.f_cmd.value = SEARCH04;
            sheetObjects[3].DoSearch4Post("ESD_TRS_0908GS.do", TrsFrmQryString(formObject), 'orgBkgNo='+org_bkg_no+'&bkgNo='+bkg_no, false);

            changeBkgNo(sheetObjects[1], bkg_no, org_bkg_no, eq_tpsz_cd);
		break;
	}
}

function sheet2_OnChange(sheetObj, row , col , value) {

	var opener_obj = window.dialogArguments;
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(col);
	var mainSheet = sheetObjects[0];

	switch(colName){
		case 'ibcheck':
			var checkList = mainSheet.FindCheckedRow('ibcheck');
			var checkArray = checkList.split('|');

			var selectedMainRow = checkArray[0];
			var selected_bkg_no = mainSheet.CellValue(selectedMainRow, 'bkg_no');
			var selected_org_bkg_no = mainSheet.CellValue(selectedMainRow, 'org_bkg_no');
			var selected_so_no = mainSheet.CellValue(selectedMainRow, 'trsp_so_ofc_cty_cd_seq');

			for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
		
				if(sheetObj.CellValue(i, 'org_apply_so_seq') != ''){
					if ( opener_obj.document.form.conti_cd.value == 'E'){
						if( isAppliableBkgNo(sheetObj.CellValue(i, 'bkg_no')) && i == row ){
							sheetObj.CellValue2(i, 'apply_so_seq') = selected_so_no;
						} else {
							sheetObj.CellValue2(i, 'apply_so_seq') = sheetObj.CellValue(i, 'org_apply_so_seq');
						}
					}
					continue;
				}else if( 
                    //(sheetObj.CellValue(i, 'bkg_no') == selected_bkg_no ||
					//sheetObj.CellValue(i, 'bkg_no') == selected_org_bkg_no) &&
                    isAppliableBkgNo(sheetObj.CellValue(i, 'bkg_no')) &&
					i == row
					){
					sheetObj.CellValue2(i, 'apply_so_seq') = selected_so_no;
				}else if(
                    //(sheetObj.CellValue(i, 'bkg_no') == selected_bkg_no ||
					//sheetObj.CellValue(i, 'bkg_no') == selected_org_bkg_no) &&
                    isAppliableBkgNo(sheetObj.CellValue(i, 'bkg_no')) &&
					sheetObj.CellValue(i, 'apply_so_seq') == selected_so_no &&
					i != row
					){
					sheetObj.CellValue2(i, 'apply_so_seq') = '';
				}
			}
		break;
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj,errMsg){
	var formObj = document.form;

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{
		if(formObj.f_cmd.value == SEARCH01){
		        
            var checkList = sheetObj.FindCheckedRow('ibcheck');
			if(checkList == '') sheetObj.CellValue2(1, 'ibcheck') = '1';
			
            var bkg_no = sheetObj.CellValue(1, 'bkg_no');
			var org_bkg_no = sheetObj.CellValue(1, 'org_bkg_no');
            formObj.f_cmd.value = SEARCH04;
            sheetObjects[3].DoSearch4Post("ESD_TRS_0908GS.do", TrsFrmQryString(formObj), 'orgBkgNo='+org_bkg_no+'&bkgNo='+bkg_no, false);
            
            doActionIBSheet(sheetObjects[1],formObj,'IBSEARCH02');
            
            
        }
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet2_OnSearchEnd(sheetObj,errMsg){

	var formObj = document.form;
	var mainSheetObj = sheetObjects[0];

	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	}else{

		var isSelect = false;

		if(formObj.f_cmd.value == SEARCH02){
			for(var i=1; i < sheetObj.RowCount+1; i++){
				if(sheetObj.RowEditable(i) == true){
					preSelectRow = i;
					isSelect = true;
					break;
				}
			}

			if(isSelect) preSelectRow = 0;
			changeBkgNo(sheetObj, mainSheetObj.CellValue(1, 'bkg_no'), mainSheetObj.CellValue(1, 'org_bkg_no'), 
				mainSheetObj.CellValue(1, 'eq_tpsz_cd'));
		}if(formObj.f_cmd.value == SEARCH04){
			var resultStr = sheetObj.EtcData('RESULT');

			if(resultStr == 'F'){
				ComShowMessage('Duplicated data cannot be applied!!');
			}else if(resultStr == 'P'){
				applyCntrSelect(sheetObj);
			}else if(resultStr == 'S'){

				applyCntrSelect(sheetObj);
				ComShowCodeMessage('COM12116', 'Apply');
				self.window.close();
			}
		}
	}
}


function changeBkgNo(sheetObj, bkg_no, org_bkg_no, eq_tpsz_cd){

	var opener_obj = window.dialogArguments;
	for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
        if(sheetObj.CellValue(i, 'org_apply_so_seq') != ''){
        	if ( opener_obj.document.form.conti_cd.value == 'E'){
        		sheetObj.RowEditable(i) = true;
        	}
			continue;
		}else if( isAppliableBkgNo(sheetObj.CellValue(i, 'bkg_no')) &&
            //== bkg_no ||
			//sheetObj.CellValue(i, 'bkg_no') == org_bkg_no) &&
			checkReplaceCntrTpSz(eq_tpsz_cd, sheetObj.CellValue(i, 'eq_tpsz_cd'))
			) {
			sheetObj.RowEditable(i) = true;
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(239,254,184);
		}else{
			sheetObj.RowEditable(i) = false;
			sheetObj.RowBackColor(i) = sheetObj.RgbColor(239,235,239);
		}
	}
}

function checkReplaceCntrTpSz(org_eq_tpsz_cd, tgt_eq_tpsz_cd){

	if(org_eq_tpsz_cd == tgt_eq_tpsz_cd) return true;

	var sheetObj = sheetObjects[2];
	var idx = sheetObj.FindText('cntr_tpsz_cd', org_eq_tpsz_cd);
	var returnFlag = false;

	if(idx != -1){
		for(var i=idx; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
			if(org_eq_tpsz_cd == sheetObj.CellValue(i, 'cntr_tpsz_cd')){
				if(tgt_eq_tpsz_cd ==  sheetObj.CellValue(i, 'prov_cntr_tpsz_cd')){
					returnFlag = true;
					break;
				}
			}else{
				break;
			}
		}
	}
	return returnFlag;
}

function applyCntrSelect(sheetObj){
	var opener_obj = window.dialogArguments;
	var openerMainSheet = opener_obj.sheetObjects[0];
	var checkList = openerMainSheet.FindCheckedRow('chk1');
	var checkArray = checkList.split('|');
	var trsp_so_seq = '';

	for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
		if(sheetObj.CellValue(i, 'org_apply_so_seq') != '' && opener_obj.document.form.conti_cd.value != 'E'){
			continue;
		}else if(sheetObj.CellValue(i, 'apply_so_seq') != '' && 
			sheetObj.CellValue(i, 'dup_check') == ''){
			trsp_so_seq = sheetObj.CellValue(i, 'apply_so_seq').substring(3);
			for(var k=0; k<checkArray.length-1; k++){
				if( trsp_so_seq == openerMainSheet.CellValue(checkArray[k], 'trsp_so_seq') ){
//					openerMainSheet.CellValue2(checkArray[k], 'org_eq_tpsz_cd') = openerMainSheet.CellValue(checkArray[k], 'eq_tpsz_cd');
					openerMainSheet.CellValue2(checkArray[k], 'eq_no') = sheetObj.CellValue(i, 'eq_no');
					openerMainSheet.CellValue2(checkArray[k], 'eq_tpsz_cd') = sheetObj.CellValue(i, 'eq_tpsz_cd');
					break;
				}
			}
		}
	}
	
}

function isAppliableBkgNo(bkgNoValue){
    var sheetObj = sheetObjects[3];
    var returnFlag = false;
    for(var i=sheetObj.HeaderRows; i<sheetObj.RowCount+sheetObj.HeaderRows; i++){
        if(sheetObj.CellValue(i, 'bkg_no') == bkgNoValue){
            returnFlag = true;
            break;
        }
    }
    return returnFlag;
}



