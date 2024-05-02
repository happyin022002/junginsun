/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0925.js
*@FileTitle : Re-Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.27
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2009.08.20 조풍연
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.22 민정호     1.1 [CHM-201007223] Invoice only 로 처리되는 건들에 대한 Currency check validation 추가
* 2011.07.27 최 선         1.2 [] S/O 상에 Currency 가 없고 Amount 가  0 인 경우에 한해서는 Invoice 진행 가능 하도록 로직 추가
=========================================================*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0925 : Booking ??? ?? ???? ???? ?? ????? ????.
 */
function ESD_TRS_0925() {
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
var before_click_row = 1;

// 부모창 관련 컨트롤(변수 및 함수 , 그리드 컨트롤)
var opener = window.dialogArguments;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 var sheetObject = sheetObjects[0];
	 var sheetObject1 = sheetObjects[1];
	 var sheetObject2 = sheetObjects[2];
	 var sheetObject3 = sheetObjects[3];

	 /*******************************************************/
	 var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {
			case "btn_apply":
				if(formObject.mode.value == 'search') return;

//				if(opener.document.tab1.SelectedIndex == 0 )
//				{
//					return;
//				}

				if(sheetObject3.CheckedRows('sel') != "1")
				{
					ComShowCodeMessage("COM12177" );
					return;
				}

				if (chkCntr(sheetObject3))
				{
					ComShowCodeMessage("TRS90003" );
					return;
				}

				if (chkEnis(sheetObject3))
				{
					ComShowCodeMessage("COM12113", 'ALPS or DOM');
					return;
				}
				
				if(!chkCUR(sheetObject, sheetObject3)){
					ComShowCodeMessage("TRS90407" );
					return;
				}

				setCoincidence();
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

	fillFormData();
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
				style.height = GetSheetHeight(7) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(12, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "Seq.|CNTR\nNo.|Waybill\nDate|Invoice\nOrigion|Invoice\nDest.|Invoice\nCUR|Invoice\nAmount";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDataSeq,        30,    daCenter,   false,    "seq",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "eq_no",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "wbl_dt",     false,          "",       dfDateYmd,       0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daLeft,   false,    "inv_org_nod_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daLeft,   false,    "inv_dest_nod_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       45,    daCenter,   false,    "inv_curr_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       50,    daRight,    false,    "inv_bzc_amt",     false,          "",       dfFloat,       2,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "inv_bil_amt");
				InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "wbl_no");
				InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "eq_tpsz_cd");
				InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "sub_inv_seq");
				InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "eq_seq");
				
				InitDataCombo(0, 'inv_curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
		   }
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(7) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "Rail\nRoad|Sight ABBR|Arrival\nDate|Arrival\nLocation|Arrival\nLocation|Dest.\nLocation|Dest.\nLocation";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "clm_crr_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       80,    daCenter,   false,    "clm_sght_abbr_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "arr_dt",     false,          "",       dfDateYmd,       0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       85,    daCenter,   false,    "arr_loc_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "arr_ste_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       85,    daCenter,   false,    "dep_loc_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       20,    daCenter,   false,    "dep_ste_cd",     false,          "",       dfNone,          0,     true,       true);
		   }
			break;
		case 3:      //sheet3 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(7) ;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			   //전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(11, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = "Vendor|Vendor|Invoice\nOrigin|Invoice\nDestination|Invoice\nCUR|Invoice\nAmount|Invoice No.|Invoice\nStatus|Non\nBill|Waybill\nDate|Paid\nDate";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "inv_vndr_seq",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "vndr_abbr_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "inv_org_nod_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "inv_dest_nod_nm",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtCombo,       50,    daCenter,   false,   "inv_curr_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daRight,    false,    "non_bil_inv_amt",     false,          "",       dfFloat,         2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       100,    daCenter,   false,   "inv_no",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "trsp_inv_aud_sts_cd",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       40,    daCenter,   false,    "non_bill",     false,          "",       dfNone,          0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "wbl_dt",     false,          "",       dfDateYmd,       0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "pay_dt",     false,          "",       dfDateYmd,       0,     true,       true);
				
				InitDataCombo(0, 'inv_curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
		   }
			break;
		case 4:      //sheet4 init
			with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(7) ;
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
				InitColumnInfo(42, 0 , 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false) ;

				var HeadTitle = " |Vendor|Vendor|From Node|From Node|To Node|To Node|ALPS\nCUR|ALPS\nAmount|Invoice\nNo.|Invoice\nStatus|Cargo|Rail Billing\nDate|Remark";

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtRadioCheck, 30,    daCenter,   false,    "sel");
				InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   false,    "vndr_seq",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "vndr_abbr_nm",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "fm_nod_cd1",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       20,    daCenter,   false,    "fm_nod_cd2",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "to_nod_cd1",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       20,    daCenter,   false,    "to_nod_cd2",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtCombo,      40,    daCenter,   false,    "curr_cd",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       65,    daRight,    false,    "ttl_amt",			false,          "|bzc_amt|+|fuel_scg_amt|+|hzd_mtrl_scg_amt|+|etc_add_amt|+|ovr_wgt_scg_amt|",       dfFloat,         2,     false,       false);
				InitDataProperty(0, cnt++ , dtData,      100,    daCenter,   false,    "inv_no",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "trsp_inv_aud_sts_cd",false,         "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtCombo,      45,    daCenter,   false,    "cgo_tp_cd",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       65,    daCenter,   false,    "rail_bil_dt",		false,          "",       dfDateYmd,       0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,       70,    daCenter,   false,    "spcl_instr_rmk",	false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,	 daCenter,   false,    "trsp_inv_co_ind_cd",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_so_ofc_cty_cd",false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "trsp_so_seq",		false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "fm_nod_cd",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "to_nod_cd",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "pay_flg",			false,          "",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "org_trsp_rail_inv_aud_cd",	false,	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,     0,     daCenter,   false,    "crnt_trsp_rail_inv_aud_cd",	false,	"",       dfNone,          0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "ibflag");

				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "eq_no");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "eq_tpsz_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "bzc_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "fuel_scg_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "ovr_wgt_scg_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "hzd_mtrl_scg_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "etc_add_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_org_nod_nm");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_dest_nod_nm");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_curr_cd");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_bil_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_bzc_amt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "wbl_dt");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "wbl_no");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "inv_rmk");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "wbl_no");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "sub_inv_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "sub_rail_seq");
				InitDataProperty(0, cnt++ , dtHidden,	  0,     daCenter,   false,    "trsp_inv_tp_cd");
				
				InitDataCombo(0, 'cgo_tp_cd', " |"+cgo_tp_cdText, " |"+cgo_tp_cdCode);
				InitDataCombo(0, 'curr_cd', " |"+inv_curr_cdText, " |"+inv_curr_cdCode);
				
		   }
			break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {

	   case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH;
//			CJO CHANGE 20090902
			var sXml = sheetObj.GetSearchXml("ESD_TRS_0925GS.do" , TrsFrmQryString(formObj));
			var arrXml = sXml.split("|$$|");
			sheetObj.RemoveEtcData();
			if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);
			if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);
			if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);
			sheetObj.ShowDebugMsg = false;
			break;

	   case IBLOADEXCEL:        //엑셀 업로드
		  sheetObj.LoadExcel();
		  break;
	}
}


function sheet1_OnClick(sheetObj , row , col)
{
	if(before_click_row == row) return;

	document.form.eq_no.value = sheetObj.CellValue(row,"eq_no");
	document.form.wbl_dt.value = sheetObj.CellValue(row,"wbl_dt");
	doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
	setSheetData(row);

	before_click_row = row;
	sheetObj.SelectCell(row, col);
}

function sheet1_OnKeyUp(sheetObj, row, col, keycode, shift)
{

	if(before_click_row != row){
		document.form.eq_no.value = sheetObj.CellValue(row,"eq_no");
		document.form.wbl_dt.value = sheetObj.CellValue(row,"wbl_dt");
		doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
		setSheetData(row);
		before_click_row = row;
	}
	sheetObj.SelectCell(row, col);
}


function setSheetData(row)
{
	 for(var i=1 ; i < sheetObjects[3].RowCount+1 ; i++)
	 {
		 sheetObjects[3].CellValue2(i, "seq") = sheetObjects[0].CellValue(row, "seq");
	 }
}

/**
 *  초기 road 시 form 에 Data를 입력한다
 */
function fillFormData()
{	 
	var formObj = document.form;//INV_NO='20090612HCD'
	moveSheetData(opener.sheetObjects[formObj.sel_sheet_idx.value] , sheetObjects[0] , 'sel');
	document.form.eq_no.value = sheetObjects[0].CellValue(1,"eq_no");
	document.form.wbl_dt.value = sheetObjects[0].CellValue(1,"wbl_dt");
	document.form.rail_road_code.value = opener.document.rail_road_code.Text;
	doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
	setSheetData(1);
}
 
function chkCntr(sheetObj)
{
	var row ;
	var sts;

	row = sheetObj.FindCheckedRow('sel');
	sts = sheetObj.CellValue(row.substring(0, row.length-1),'trsp_inv_aud_sts_cd');

	if (sts == "CF")
	{
		return true;
	}
	return false;
}

function chkEnis(sheetObj)
{
	var row ;
	var sts;
	row = sheetObj.FindCheckedRow('sel');
	sts = sheetObj.CellValue(row.substring(0, row.length-1),'trsp_inv_co_ind_cd');

	if (sts != "SML" && sts != "DOM")
	{
		return true;
	}
	return false;
}

/*
 *  Re-Audit List 의  Invoice CUR 와  Billing 의 ALPS CUR 비교
 */
function chkCUR(sheetObj1, sheetObj2){
	 var inv_curr_cd = sheetObj1.CellValue(1,'inv_curr_cd');
	 var row = sheetObj2.FindCheckedRow('sel');
	 var curr_cd = sheetObj2.CellValue(row.substring(0, row.length-1),'curr_cd');
	 var bzc_amt = sheetObj2.CellValue(row.substring(0, row.length-1),'bzc_amt');

	 if(inv_curr_cd == curr_cd || (curr_cd == "" && bzc_amt == "0")){
		 return true;
	 }else{
		 return false;
	 }	
}

function setCoincidence(){

	var formObj = document.form;
	var reAuditList_sheetObj	= sheetObjects[0];
	var billing_SheetObj		= sheetObjects[3];
	var coincidence_sheetObj	= opener.sheetObjects[0];
	var invoiceOnly_sheetObj	= opener.sheetObjects[formObj.sel_sheet_idx.value];
	var row						= billing_SheetObj.FindCheckedRow('sel');
	row							= row.substring(0, row.length-1);
	var so_seq					= billing_SheetObj.CellValue(row , 'trsp_so_seq');
	var coincidence_row			= coincidence_sheetObj.FindText('trsp_so_seq' , so_seq );
	var orgTrspRailInvAudCd		= 'I';
	if(coincidence_row != -1 ){
		if(confirm(ComGetMsg("COM12115",'S/O')+'\nAre you sure you want to proceed?')) {
			coincidence_sheetObj.RowDelete(coincidence_row , false);
		}else{
			return;
		}
	}

	if (formObj.sel_sheet_idx.value == '1') orgTrspRailInvAudCd = 'D'

	billing_SheetObj.CellValue2(row, 'pay_flg')						= '1';
	billing_SheetObj.CellValue2(row, 'org_trsp_rail_inv_aud_cd')	= orgTrspRailInvAudCd;
	billing_SheetObj.CellValue2(row, 'crnt_trsp_rail_inv_aud_cd')	= 'C';
	
	var queryStr				= billing_SheetObj.GetSaveString(false, false, 'sel');
	coincidence_sheetObj.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', true);
	var coincidence_lastRow		= coincidence_sheetObj.LastRow;
	var colName = null;

	for ( var k=0 ; k < reAuditList_sheetObj.LastCol ; k++){
		colName					= reAuditList_sheetObj.ColSaveName(k);
		coincidence_sheetObj.CellValue(coincidence_lastRow, colName) 
								= reAuditList_sheetObj.CellValue(before_click_row, colName);
	}
	var eq_seq_row = invoiceOnly_sheetObj.FindText('eq_seq', reAuditList_sheetObj.CellValue(before_click_row, 'eq_seq'));

	var trsp_inv_tp_cd = invoiceOnly_sheetObj.CellValue(eq_seq_row, 'trsp_inv_tp_cd');
	if(trsp_inv_tp_cd == 'M')
		coincidence_sheetObj.CellValue2(coincidence_lastRow, 'trsp_inv_tp_cd') = trsp_inv_tp_cd;
	else 
		coincidence_sheetObj.CellValue2(coincidence_lastRow, 'trsp_inv_tp_cd') = 'F';

	
	invoiceOnly_sheetObj.CellValue(eq_seq_row, "pay_flg") = 0;
	invoiceOnly_sheetObj.RowDelete(eq_seq_row , false);
	reAuditList_sheetObj.RowDelete(before_click_row , false);
	ComShowCodeMessage("COM12116",'Apply');
	
	if(reAuditList_sheetObj.RowCount > 0){
		var new_row = reAuditList_sheetObj.SelectRow;
		var col = 1;
		document.form.eq_no.value = reAuditList_sheetObj.CellValue(new_row,"eq_no");
		document.form.wbl_dt.value = reAuditList_sheetObj.CellValue(new_row,"wbl_dt");
		doActionIBSheet(sheetObjects[1], document.form , IBSEARCH);
		setSheetData(new_row);

		before_click_row = new_row;
		reAuditList_sheetObj.SelectCell(new_row, col);
	}
}

/*
* 2개 Sheet에서 데이터 이동하기 - 체크된 데이터만 이동하기
* @param : fromSheet - 이동 원본 Sheet의 Object id
* @param : toSheet   - 이동 대상 Sheet의 Object id
* @param : chkCol    - 체크박스 컬럼의 인덱스
* @return : 없음
* @sample
*  moveSheetData(mySheet1, mySheet2, 2);
*/
function moveSheetData(fromSheet, toSheet, chkCol)  {

	var queryStr = fromSheet.GetSaveString(false, false, chkCol);
	toSheet.DoSearch4Post("ESD_TRS_0969.screen", queryStr, '', true);
}