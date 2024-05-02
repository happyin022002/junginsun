﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0031.js
*@FileTitle : Manifest Amendment Transmission To Korean Customs 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.02 박상훈
* 1.0 Creation
=========================================================*/

/**
 * JSDOC 생성을 위한 함수 정의
 */
function esm_bkg_0031()
{
	this.processButtonClick			= processButtonClick;
	this.setSheetObject				= setSheetObject;
	this.loadPage					= loadPage;
	this.t1sheet1_OnLoadFinish		= t1sheet1_OnLoadFinish;
	this.initSheet					= initSheet;
	this.initCombo					= initCombo;
	this.cboReceiver_OnChange		= cboReceiver_OnChange;
	this.cboGoods_OnFocus			= cboGoods_OnFocus;
	this.cboGoods_OnChange			= cboGoods_OnChange;
	this.cboGoods_OnBlur			= cboGoods_OnBlur;
	this.cboTrans_OnFocus			= cboTrans_OnFocus;
	this.cboTrans_OnChange			= cboTrans_OnChange;
	this.cboTrans_OnBlur			= cboTrans_OnBlur;
	this.cboCorrection_OnChange		= cboCorrection_OnChange;
	this.cboCargoSpec_OnChange		= cboCargoSpec_OnChange;
	this.cboCargoSpec_OnFocus		= cboCargoSpec_OnFocus;
	this.cboCargoSpec_OnBlur		= cboCargoSpec_OnBlur;
	this.cboWhTpCd_OnChange			= cboWhTpCd_OnChange;
	this.cboBizNo_OnFocus			= cboBizNo_OnFocus;
	this.cboBizNo_OnChange			= cboBizNo_OnChange;
	this.cboBizNo_OnBlur			= cboBizNo_OnBlur;
	this.cboPackage_OnFocus			= cboPackage_OnFocus;
	this.cboPackage_OnChange		= cboPackage_OnChange;
	this.cboPackage_OnBlur			= cboPackage_OnBlur;
	this.cboMeaUnit_OnChange		= cboMeaUnit_OnChange;
	// 4세대 MACAMD 변경
	this.cboMeaUnit_OnFocus			= cboMeaUnit_OnFocus;
	this.cboMeaUnit_OnBlur			= cboMeaUnit_OnBlur;
	
	this.resetForm					= resetForm;
	this.doActionIBSheet			= doActionIBSheet;
	this.setTabObject				= setTabObject;
	this.initTab					= initTab;
	this.tab1_OnChange				= tab1_OnChange;
	this.setComboObject				= setComboObject;
	this.validateForm				= validateForm;
	this.ComXml2ComboString2		= ComXml2ComboString2;
	this.changeTextToNumberFormat	= changeTextToNumberFormat;
	this.changeNumberToTextFormat	= changeNumberToTextFormat;
	this.t1sheet1_OnBeforeEdit		= t1sheet1_OnBeforeEdit;
	this.t1sheet1_OnAfterEdit		= t1sheet1_OnAfterEdit;
	this.t1sheet1_OnChange			= t1sheet1_OnChange;
	this.t3sheet1_OnBeforeEdit		= t3sheet1_OnBeforeEdit;
	this.t3sheet1_OnAfterEdit		= t3sheet1_OnAfterEdit;
	this.t3sheet1_OnChange			= t3sheet1_OnChange;
	this.pod_onChange				= pod_onChange;
	this.pol_onChange				= pol_onChange;
	this.bdAreaCd_onChange			= bdAreaCd_onChange;
	this.cntrTtlWgt_onChange		= cntrTtlWgt_onChange;
	this.measQty_onChange			= measQty_onChange;
	this.pckQty_onChange			= pckQty_onChange;
	this.setPckOldData				= setPckOldData;
	this.vslNm_onChange				= vslNm_onChange;
	this.vvd_onChange				= vvd_onChange;
	this.vslCallSgnCd_onChange		= vslCallSgnCd_onChange;
	this.vslCntCd_onChange			= vslCntCd_onChange;
	this.ioTmlLocCd_onChange		= ioTmlLocCd_onChange;
	this.measUtCd_onChange			= measUtCd_onChange;
	this.bbCgoWgt_onChange			= bbCgoWgt_onChange;
	this.bbCgoMeasQty_onChange		= bbCgoMeasQty_onChange;
	this.krCstmsBlTpCd_onChange		= krCstmsBlTpCd_onChange;
	this.cstmsFwrdId_OnFocus		= cstmsFwrdId_OnFocus;
	this.cstmsFwrdId_OnChange		= cstmsFwrdId_OnChange;
	this.dchgMzdCd_onChange			= dchgMzdCd_onChange;
	this.imdgClssCd_onChange		= imdgClssCd_onChange;
	this.n2ndImdgClssCd_onChange	= n2ndImdgClssCd_onChange;
	this.n3rdImdgClssCd_onChange	= n3rdImdgClssCd_onChange;
	this.sCustNm_onChange			= sCustNm_onChange;
	this.sCustAddr_onChange			= sCustAddr_onChange;
	this.cCustNm_onChange			= cCustNm_onChange;
	this.cCustAddr_onChange			= cCustAddr_onChange;
	this.nCustNm_onChange			= nCustNm_onChange;
	this.nCustAddr_onChange			= nCustAddr_onChange;
	this.setOldData					= setOldData;
	this.addCorrList				= addCorrList;
	this.ComAddComma3				= ComAddComma3;
}

//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// OLD 값 처리
var oldData = "";
// NEW 값 처리
var newData = "";
var pkgOldData = "";

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];

	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

		/** TAB [Container Info] (S) **/

		case "btn_t1RowAdd":
			sheetObject1.DataInsert(-1);
			sheetObject1.CellValue2(sheetObject1.SelectRow, "pck_qty") = "0";
			sheetObject1.CellValue2(sheetObject1.SelectRow, "pck_qty") = "0";
			sheetObject1.CellValue2(sheetObject1.SelectRow, "cntr_wgt") = "0";
			sheetObject1.CellValue2(sheetObject1.SelectRow, "meas_qty") = "0";
			sheetObject1.CellValue2(sheetObject1.SelectRow, "pck_tp_cd") = "";			
			// HEAD 부분의 Correction 이 D 인경우 Correction 은 I로 초기화
			if (comboObjects[2].Code=="03") {
				sheetObject1.CellValue(sheetObject1.SelectRow, "kr_cstms_corr_id") = "I";
			} else if (comboObjects[2].Code=="04") {
				// HEAD 부분의 Correction 이 F 인경우 Correction 은 D로 초기화
				sheetObject1.CellValue2(sheetObject1.SelectRow, "kr_cstms_corr_id") = "D";
			} else {
				sheetObject1.CellValue(sheetObject1.SelectRow, "kr_cstms_corr_id") = "A";
			}
			sheetObject1.CellValue(sheetObject1.SelectRow, "full_mty_cd") = "F";
			break;
		case "btn_t1SelectAll":
			sheetObject1.CheckAll(1) = 2;
			if (sheetObject1.CheckedRows(1) < 1) {
				document.getElementById("btn_t1SelectAll").innerHTML  = "Select All";
			}else {
				document.getElementById("btn_t1SelectAll").innerHTML  = "Deselect All";
			}
			break;
		case "btn_t3SelectAll":
			sheetObject2.CheckAll(1) = 2;
			if (sheetObject2.CheckedRows(1) < 1) {
				document.getElementById("btn_t3SelectAll").innerHTML  = "Select All";
			}else {
				document.getElementById("btn_t3SelectAll").innerHTML  = "Deselect All";
			}
			break;
		case "btn_t4SelectAll":
			sheetObject3.CheckAll(1) = 2;
			if (sheetObject3.CheckedRows(1) < 1) {
				document.getElementById("btn_t4SelectAll").innerHTML  = "Select All";
			}else {
				document.getElementById("btn_t4SelectAll").innerHTML  = "Deselect All";
			}
			break;

		case "btn_t1Delete":
			doActionIBSheet(sheetObject1,document.form,IBDELETE);
			break;

		case "btn_t1LoadExcel":
			sheetObject1.Redraw = false;
			ComOpenWait(true);
			var columns = "4=>cntr_no|5=>pre_cntr_no|6=>cntr_tpsz_cd|7=>cntr_seal_no1|8=>cntr_seal_no2|9=>pck_qty|10=>pck_tp_cd|11=>cntr_wgt|12=>wgt_ut_cd|13=>meas_qty|14=>meas_ut_cd|20=>full_mty_cd|21=>chk_empty";
			var oldCnt = sheetObject1.RowCount;
			var cnt = 0;
			sheetObject1.LoadExcel(1, 1, "", -1, -1, "", true, false, columns );
			sheetObject1.Redraw = true;
			for(var i=oldCnt+1; i <= sheetObject1.RowCount; i++) {
				// Correction Code 변경
				// HEAD 부분의 Correction 이 D 인경우 Correction 은 I로 초기화
				if (comboObjects[2].Code=="03") {
					sheetObject1.CellValue(i, "kr_cstms_corr_id") = "I";
				} else if (comboObjects[2].Code=="04") {
					// HEAD 부분의 Correction 이 F 인경우 Correction 은 D로 초기화
					sheetObject1.CellValue2(i, "kr_cstms_corr_id") = "D";
				} else {
					sheetObject1.CellValue(i, "kr_cstms_corr_id") = "A";
				}
				// 엑셀에서 로드한 데이터 중 12번 컬럼이 P 이거나 E인 경우 MTY_CD 를 E로 설정
				if (sheetObject1.CellValue(i, "chk_empty")=="P" || sheetObject1.CellValue(i, "chk_empty")=="E" ) {
					sheetObject1.CellValue(i, "full_mty_cd") = "E";
				}else {
					sheetObject1.CellValue(i, "full_mty_cd") = "F";
				}
				// CNTR_NO 체크하여 첫번째 문자가 97보다 크거나 같고 122보다 작거나 같으면 삭제처리
				if (sheetObject1.CellValue(i, "cntr_no").length > 0 ) {
					var charCode = sheetObject1.CellValue(i, "cntr_no").charCodeAt(0);
					if (97 <= charCode && charCode <= 122 ) sheetObject1.RowDelete(i, false);
				}
			}
			// 중복 컨테이너 제거
			for(var i=1; i <= sheetObject1.RowCount; i++) {
				for(var j=1; j <= sheetObject1.RowCount;j++) {
					if (i==j) continue;
					
					if (sheetObject1.CellValue(i,"cntr_no")==sheetObject1.CellValue(j, "cntr_no")) {
						sheetObject1.RowDelete(j, false);
					}
				}
			}
			ComOpenWait(false);
			cnt = sheetObject1.RowCount - oldCnt;
			ComShowCodeMessage("BKG95021", cnt);
			break;

		case "btn_t3RowAdd":
			sheetObject2.DataInsert(-1);
			sheetObject2.CellValue2(sheetObject2.SelectRow, "divd_pck_ut_cd") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "pck_tp_cd") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "kr_cstms_corr_id") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "wgt_ut_cd") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "prt_lodg_flg") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "kr_xpt_pck_id") = "";
			sheetObject2.CellValue2(sheetObject2.SelectRow, "kr_xpt_pck_id") = "";
			break;

		case "btn_t3Delete":
			doActionIBSheet(sheetObject2,document.form,IBDELETE);
			break;

		case "btn_t3LoadExcel":
			alert(srcName);
			break;

		case "btn_t4RowAdd":
			sheetObject3.DataInsert(-1);
			break;

		case "btn_t4Delete":
			doActionIBSheet(sheetObject3,document.form,IBDELETE);
			break;

		case "btn_t4LoadExcel":
			alert(srcName);
			break;

		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;

		case "btn_New":
			resetForm();
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject4, document.form, IBSAVE);
			break;

		case "btn_CorrectionListClear":
			// Correction List를 모두 Clear
			// Container TAB 처리
			for(var i=1; i <= sheetObjects[0].RowCount; i++) {
				sheetObjects[0].CellValue(i, "kr_cstms_corr_id") = "";
				sheetObjects[0].CellValue(i, "kr_cstms_corr_id2") = "";
				sheetObjects[0].CellValue(i, "corr_rsn") = "";
				sheetObjects[0].CellValue(i, "pre_dat_ctnt") = "";
				sheetObjects[0].CellValue(i, "crnt_dat_ctnt") = "";
			}
			// Export License TAB 처리
			for(var i=1; i <= sheetObjects[1].RowCount; i++) {
				sheetObjects[1].CellValue(i, "kr_cstms_corr_id") = "";
				sheetObjects[1].CellValue(i, "corr_rsn") = "";
			}
			// VVD BL Corr TAB 처리
			sheetObjects[2].RemoveAll();
			break;

		case "btn_TransAmendment":
			doActionIBSheet(sheetObject4, document.form, MODIFY01);
			break;
		case "btn_TransDischAmend":
			doActionIBSheet(sheetObject4, document.form, MODIFY02);
			break;
			
		} // end switch
	}catch(e) {
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

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet (sheetObjects[i] );

		initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    // Key 입력 처리
	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	// 코드성 데이터 조회
	doActionIBSheet(sheetObjects[0], document.form, COMMAND09);

	// Edit Mode 일 경우 조회
	if (document.form.mode.value=="EDIT") {
		// B/L 과 Trans Check
		if (document.form.cstms_decl_tp_cd.value.length < 1) {
			ComShowCodeMessage('BKG95018', "Trans");
			self.close();
		}
		if (document.form.bl_no.value.length < 12) {
			ComShowCodeMessage('BKG00686');
			self.close();
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		document.form.bkg_no.className = "input2";		
		document.form.bkg_no.readOnly=true;		
	}else {
		document.form.bkg_no.className = "input";
		ComBtnDisable('btn_Retrieve');
	}
	// OUT BOUND 의 경우는 MSN 비활성화
	if (document.form.io_bnd_cd.value=="O") {
		document.form.msn_no.disabled=true;
		document.form.msn_no.className="input2";
		form.cstms_fwrd_id.style.display = 'none';
	}else {
		form.cstms_fwrd_id.style.display = 'inline';
	}
	
	// cstms_decl_tp_cd 처리
	comboObjects[1].Code2 = document.form.cstms_decl_tp_cd.value;

	ComBtnDisable("btn_TransAmendment");		
	ComBtnDisable("btn_TransDischAmend");		
}

/**
* SHEET1 로드 완료 이벤트 처리
* @param sheetObj
* @return
*/
function t1sheet1_OnLoadFinish(sheetObj) {

	// TRANS TP 
	form.old_cstms_decl_tp_cd.value = form.cstms_decl_tp_cd.value;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

	var cnt = 0;
	var sheetid = sheetObj.id;
	switch(sheetid) {

	case "t1sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 147;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel|Seq.|Container No.|Pre-CNTR No.|TP|Seal No1.|Seal No2.|Package|Package|Weight|Weight|Measure|Measure|Correction|Correction Code2|Correct Reason|Old|New|||";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 8, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성    [ROW, COL,   DATATYPE,     WIDTH,  DATAALIGN, COLMERGE,     SAVENAME,         	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,		30,		daCenter,	true,		"Seq");
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cntr_no",			true,		"",		dfEngUpKey,	0,		true,		true,	11);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"pre_cntr_no",		false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,		"cntr_tpsz_cd",		false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cntr_seal_no1",	false,		"",		dfNone,		0,		true,		true,	8);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cntr_seal_no2",	false,		"",		dfNone,		0,		true,		true,	8);
			InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		"pck_qty",			false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		"pck_tp_cd",		false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,		"cntr_wgt",			false,		"",		dfNullFloat,3,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		"wgt_ut_cd",		false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,		"meas_qty",			false,		"",		dfNullFloat,3,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		"meas_ut_cd",		false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtCombo,		120,	daLeft,		true,		"kr_cstms_corr_id",	false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"kr_cstms_corr_id2",false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,		"corr_rsn",			false,		"",		dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"pre_dat_ctnt",		false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"crnt_dat_ctnt",	false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"full_mty_cd",		false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"chk_empty",		false,		"",		dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		"org_bl_no",		false,		"",		dfNone,		0,		false,		false);
			
			// OUT BOUND 의 경우
			if (document.form.io_bnd_cd.value=="O") {
				ColHidden("kr_cstms_corr_id2") = true;
				ColHidden("pre_dat_ctnt") = true;
				ColHidden("crnt_dat_ctnt") = true;
				CellValue(0,"kr_cstms_corr_id") = "Correction";
				ColWidth("kr_cstms_corr_id") = 170;
			}else {
				// IN BOUND 의 경우
				CellValue(0,"kr_cstms_corr_id") = "Correction Code1";
				ColWidth("kr_cstms_corr_id") = 170;
			}

			// COMBO 초기화
			InitDataCombo(0, "cntr_tpsz_cd", "D2|D4|D5|D7|R5", "D2|D4|D5|D7|R5");
			InitDataCombo(0, "pck_tp_cd", "AE|AR|PK", "AE|AR|PK");
			InitDataCombo(0, "wgt_ut_cd", "KGS|LBS", "KGS|LBS");
			InitDataCombo(0, "meas_ut_cd", "CBM|CBF", "CBM|CBF");
			InitDataCombo(0, "kr_cstms_corr_id", " \t |I\tMB/L 추가|A\tCNTR 추가|U\tContainer No 이외 정정|D\tCNTR 삭제|X\tContainer No 및 내용정정", " |I|A|U|D|X", "MB/L 추가", "I", 1);

			ShowButtonImage = 2;
			DataRowMerge(0) = true;
			CountPosition  = 0;

		}
		break;		

	case "t3sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 147;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel|Seq.|Export No.|Pre-Export No.|Package|Package|Weight|Weight|Divide|Ship|동시포장|동시포장 Package|동시포장 Package|Correction Code|Correct Reason";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 5, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);



			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,				40,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,				30,		daCenter,	true,		"Seq");
			InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	true,		"xpt_lic_no",		true,		"",	dfEngUpKey,	0);
			InitDataProperty(0, cnt++ , dtData,					120,	daCenter,	true,		"pre_xpt_lic_no",	false,		"",	dfNone,		0, false, false);
			InitDataProperty(0, cnt++ , dtData,					50,		daRight,	true,		"pck_qty",			false,		"",	dfNullInteger,0);
			InitDataProperty(0, cnt++ , dtCombo,				40,		daCenter,	true,		"pck_tp_cd",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					60,		daRight,	true,		"cntr_wgt",			false,		"",	dfNullFloat,	3);
			InitDataProperty(0, cnt++ , dtCombo,				40,		daCenter,	true,		"wgt_ut_cd",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"prt_lodg_flg",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"prt_lodg_seq",		false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtCombo,				80,		daCenter,	true,		"kr_xpt_pck_id",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					60,		daCenter,	true,		"divd_pck_qty",		false,		"",	dfNullInteger,	0);
			InitDataProperty(0, cnt++ , dtCombo,				60,		daCenter,	true,		"divd_pck_ut_cd",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtCombo,				170,	daLeft,		true,		"kr_cstms_corr_id",	false,		"",	dfNone,		0);
			InitDataProperty(0, cnt++ , dtData,					100,	daLeft,		true,		"corr_rsn",			false,		"",	dfNone,		0);

			InitDataCombo(0, "pck_tp_cd", "AE|AR|PK", "AE|AR|PK");
			InitDataCombo(0, "wgt_ut_cd", "KGS|LBS| ", "KGS|LBS| ");
			InitDataCombo(0, "prt_lodg_flg", "Y|N| ", "Y|N| ");
			InitDataCombo(0, "kr_xpt_pck_id", "A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z| ", "A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|");
			InitDataCombo(0, "divd_pck_ut_cd", " |AE|AR|AT|BA|BB|BC", "|AE|AR|AT|BA|BB|BC");
			InitDataCombo(0, "kr_cstms_corr_id", " \t |I\tMB/L 추가|A\tE/L 추가|U\tE/L No 이외 정정|D\tE/L 삭제|X\tE/L No 및 내용정정", " |I|A|U|D|X", "MB/L 추가", "I", 1);

			ShowButtonImage = 2;
			DataRowMerge(0) = true;
			CountPosition  = 0;

		}
		break;

	case "t4sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 147;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle1 = "|Sel|Seq.|Corr. CD|Correct Reason|Old 1|New 1|Old 2|New 2";
			var headCount = ComCountHeadTitle(HeadTitle1);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);



			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,			0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,				40,		daCenter,	true,		"Sel");
			InitDataProperty(0, cnt++ , dtDataSeq,				70,		daCenter,	true,		"Seq");
			InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	true,		"kr_cstms_corr_id",		false,		"",	dfNone,		0, false, false);
			// IN BOUND 의 경우 콤보로 설정하고 OUT BOUND 시에는 DATA로 처리
			if (document.form.io_bnd_cd.value=="I") {
				InitDataProperty(0, cnt++ , dtCombo,				360,	daLeft,		true,		"corr_rsn",		false,		"",	dfNone,		0);
				var corr_rsn_data = " |01 적하목록작성자의 단순 기재오류에 기인한 경우|02 적하목록에 등재되지 않은 무적화물(오착화물, 선착화물등)|03 Shipper측 사무착오(화물선적되지않음), 다른곳에 화물적재|04 항행/운송중 사고로 화물이 도난,유실,파손된 경우|05 Shipper측의 사무착오로 B/L(AWB)정보가 이중으로 기재된 경우|06 적하목록상 양륙항이 아닌 다른 항구/공항에 잘못 하역한 경우|07 하역해야 할 화물이 선박(항공기)에 계속하여 남아있는 경우|08 양륙항이 당해 항구(공항)가 아닌 화물을 잘못 하역한 경우|09 하역시 이상없는 화물이 CY/CFS에 장치중 이상 생긴 경우|10 혼재화물 적하목록을 기한내 제출하지 않은 물품 추후에 보완|11 컨테이너 개장결과 과부족발생 경우,세관장이 봉인이상없음 확인|12 B/L(AWB)번호의 상이(B/L분할 또는 단순 기재오류인 경우)|13 B/L(AWB)양수도로 인하여 수하인의 주소,성명이 변경된 경우|14 통과(T/S)화물을 수입화물로 잘못기재한 경우|15 수입화물을 통과(T/S)화물로 잘못 기재한 경우|16 기타사유로 물품의 과부족등 적하목록에 이상이 있는 경우|17 일괄구매물품 B/L분할정정|18 벌크 환적화물 컨테이너 정정";
				var corr_rsn_key = "|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18";
				InitDataCombo(0, "corr_rsn", corr_rsn_data, corr_rsn_key);
			} else {
				InitDataProperty(0, cnt++ , dtData,					360,	daLeft,		true,		"corr_rsn",		false,		"",	dfNone,		0);
			}
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"pre_ctnt1",			false,		"",	dfNone,		0, false, false);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"crnt_ctnt1",			false,		"",	dfNone,		0, false, false);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"pre_ctnt2",			false,		"",	dfNone,		0, false, false);
			InitDataProperty(0, cnt++ , dtData,					100,	daCenter,	true,		"crnt_ctnt2",			false,		"",	dfNone,		0, false, false);

			ShowButtonImage = 2;
			DataRowMerge(0) = true;
			CountPosition  = 0;
		}
		break;
		
	case "t4sheet2":
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			//전체 너비 설정
			SheetWidth = 0;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);
			
			var HeadTitle1 = "|Sel";
			var headCount = ComCountHeadTitle(HeadTitle1);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		"Sel");
			
		}
		break;

	}
}

/**
 * 콤보 초기화
 * @param comboObj
 * @param comboNo
 * @return
 */ 
function initCombo(comboObj, comboNo) {
	 var cnt = 0;	
	 switch(comboObj.id) {
	 case "cboReceiver":
		 with (comboObj) {
			 SetColAlign("center|left");
			 SetColWidth("50|140");			
			 DropHeight = 400;
			 ShowCol = 0;
			 SetTitle("Code|Description");
			 MultiSelect = false;
			 MaxSelect = 1 ;
			 InsertItem(cnt ++, "A|관세청 & 해양수산부", "A");
			 InsertItem(cnt ++, "C|관세청", "C");
			 InsertItem(cnt ++, "P|해양수산부", "P");
			 Code = "A";
			 document.form.amdt_rcvr_flg.value=Code;
		 }
		 break;    	            
	 case "cboTrans":
		 with (comboObj) {
			 SetColAlign("left");
			 SetColWidth("90");			
			 DropHeight = 400;
			 ShowCol = 0;
			 MultiSelect = false;
			 MaxSelect = 1 ;
			 if (document.form.io_bnd_cd.value=="O") {
				 InsertItem(cnt ++, "Export", "E");
				 InsertItem(cnt ++, "T/S Export", "R");
				   if (document.form.cstms_decl_tp_cd.value.length > 0)        //New
                       comboObj.Code2 = document.form.cstms_decl_tp_cd.value;      //New
                       else                                                        //New                                          
                       comboObj.Code = "E";                                        //New
			 }else {
				 InsertItem(cnt ++, "Import", "I");
				 InsertItem(cnt ++, "T/S Import", "T");
				   if (document.form.cstms_decl_tp_cd.value.length > 0)        //New
                      comboObj.Code2 = document.form.cstms_decl_tp_cd.value;  //New
                   else                                                        //New    
                      comboObj.Code = "I";	                                //New  
			 }
		 }
		 break;    	            
	 case "cboCorrection":
		 with (comboObj) {
			 SetColAlign("center|left");
			 SetColWidth("50|140");			
			 DropHeight = 400;
			 ShowCol = 0;
			 SetTitle("Code|Description");
			 MultiSelect = false;
			 MaxSelect = 1 ;
			 InsertItem(cnt ++, "01|운항정보 정정", "01");
			 InsertItem(cnt ++, "02|Master B/L 정정", "02");
			 InsertItem(cnt ++, "03|Master B/L 추가", "03");
			 InsertItem(cnt ++, "04|Master B/L 삭제", "04");
			 Code = "01";
		 }		 
		 break;    	            
	 case "cboCargoSpec":
		 with(comboObj) {
			 DropHeight = 300;
			 MultiSelect = false;
			 MaxSelect = 0;
			 comboObj.InsertItem( cnt ++, " ",     				 " ");
			 comboObj.InsertItem( cnt ++, "1. 국내개항간 외항선 운송" ,     				 "1");
			 comboObj.InsertItem( cnt ++, "2. 수출화물로써 국내개항에 일시 양륙하는 화물" ,  "2");
		 }
		 break;         
	 case "cboWhTpCd":
		 with(comboObj) {
			 DropHeight = 300;
			 MultiSelect = false;
			 MaxSelect = 0;
			 SetColAlign("center|left");
             SetColWidth("60|200");
			 SetTitle("Code|Description");
			 var arrayKind = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' ];
			 var arrayBondedType = [ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
			                       '부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
			                       'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
			                       '자선', '타소 장치', 'Empty 컨테이너' ];
			 for(i=0; i < arrayKind.length; i++) {
				 comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			 }			 
		 }
		 break;         
	 case "cboBizNo":
		 with(comboObj) {
			 DropHeight = 300;
			 MultiSelect = false;
			 MaxSelect = 0;			 
			 SetColAlign("center|left");
			 SetColWidth("100|130");
			 var arrayKind 		 = [ '401-85-08615', '105-81-59519', '137-85-00522', '416-85-06244', '506-85-03346', ' ' ];
			 var arrayKindVal 	 = [ '4018508615', '1058159519', '1378500522', '4168506244', '5068503346', '' ];
			 var arrayBondedType = [ '대우자동차', '효성', '동부제강', '현대하이스코', '동국제강㈜ ', ''];
			 for(i=0; i < arrayKind.length; i++) {
				 comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKindVal[i]);
			 }
		 }
		 break;         
	 case "cboPackage":
		 with(comboObj) {
			 DropHeight = 300;
			 MultiSelect = false;
			 MaxSelect = 1;
			 SetColAlign("center|left");
			 SetColWidth("60|200");
			 SetTitle("Code|Description");
		 }
		 break;         
	 case "cboMeaUnit":
		 with(comboObj) {
			 SetColAlign("center|left");
			 SetColWidth("50|140");			
			 DropHeight = 400;
			 ShowCol = 0;
			 SetTitle("Code|Description");
			 MultiSelect = false;
			 MaxSelect = 1 ;
			 InsertItem(cnt ++, "M|Measurement Ton", "M");
			 InsertItem(cnt ++, "B|Barrel", "B");
			 Code = "M";
		 }		 
		 break;   
	 case "cboGoods":
		 var i=0;
		 with(comboObj) {
			 DropHeight = 300;
			 MultiSelect = false;
			 MaxSelect = 0;
			 ShowCol = 1;
			 SetColAlign("center|left");
			 SetColWidth("60|80");
			 var arrayKind = [ '00', '99' ];
			 var arrayBondedType = [ '630700', '530620' ];
			 for(i=0; i < arrayKind.length; i++) {
				 comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			 }
		 }
		 break;
	 }
} 

/**
 * Receiver 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboReceiver_OnChange(comboObj,value,text) {
	var form = document.form;
	form.amdt_rcvr_flg.value = value;
}

/**
 * HS CODE 포커스 인 처리 
 * @param comboObj
 * @return
 */
function cboGoods_OnFocus(comboObj) {
	oldData = comboObj.Code;
}

/**
 * HS CODE 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboGoods_OnChange(comboObj, value, text) {
	var form = document.form;
	form.cmdt_cd.value = value;
	newData = value;
}

/**
 * HS CODE 포커스 아웃 처리
 * @param comboObj
 * @return
 */
function cboGoods_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form = document.form;
		// Receiver 변경
		comboObjects[0].Code = "A";
		// 이력 추가
		// IN BOUND의 경우
		if (form.io_bnd_cd.value=="I") {
			// 4세대 MACAMD는 BF에서 ZA3으로 변경
			addCorrList("BF", "", oldData, newData);
			//addCorrList("ZA3", "", oldData, newData);
		}else {
			// 4세대 MACAMD는 BF에서 ZA3으로 변경
			addCorrList("BF", "화주 요청에 의한 정정", oldData, newData);
			//addCorrList("ZA3", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData = "";
		newData = "";
	}
}

/**
 * Trans 포커스 인 처리
 * @param comboObj
 * @return
 */ 
function cboTrans_OnFocus(comboObj) {
	oldData = comboObj.Code;
}

/**
 * Trans 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboTrans_OnChange(comboObj,value,text) {
	var form = document.form;
	form.cstms_decl_tp_cd.value = value;
	newData = value;	
}

/**
 * Trans 포커스 아웃 처리 
 * @param comboObj
 * @return
 */
function cboTrans_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form = document.form;
		// Receiver 변경
		comboObjects[0].Code = "A";
	
		// 이력 추가
		// IN BOUND의 경우
		if (form.io_bnd_cd.value=="I") {
			addCorrList("BM", "", oldData, newData);
		}else {
			// 4세대 MACAMD는 변경: BM 에서 ZB1
			addCorrList("BM", "화주 요청에 의한 정정", oldData, newData);
			//addCorrList("ZB1", "화주 요청에 의한 정정", oldData, newData);
			
		}
		newData = "";
		oldData = "";
	}
}

/**
 * Correction 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCorrection_OnChange(comboObj,value,text) {
	var form = document.form;
	form.kr_cstms_corr_id.value = value;
	if ( value=="03" ) {
		form.corr_rsn.value = "오류로 인한 Master B/L 추가";
	}else if ( value=="04" ) {
		form.corr_rsn.value = "선적취소로 인한 Master B/L 삭제";
	}else {
		form.corr_rsn.value = "";
	}

	// 콤보 값이 바뀌면 Container Info TAB과 Export License TAB의 Correction 초기화
	switch(value) {	 
	case "01":
		for(var i=1; i <= sheetObjects[0].RowCount; i++ ) {
			sheetObjects[0].CellValue(i, "kr_cstms_corr_id") = "";
		}
		for(var i=1; i <= sheetObjects[1].RowCount; i++ ) {
			sheetObjects[1].CellValue(i, "kr_cstms_corr_id") = "";
		}
		break;
	case "02":
		for(var i=1; i <= sheetObjects[0].RowCount; i++ ) {
			sheetObjects[0].CellValue(i, "kr_cstms_corr_id") = "";
		}
		for(var i=1; i <= sheetObjects[1].RowCount; i++ ) {
			sheetObjects[1].CellValue(i, "kr_cstms_corr_id") = "";
		}
		break;
	case "03":
		for(var i=1; i <= sheetObjects[0].RowCount; i++ ) {
			sheetObjects[0].CellValue(i, "kr_cstms_corr_id") = "I";
		}
		for(var i=1; i <= sheetObjects[1].RowCount; i++ ) {
			sheetObjects[1].CellValue(i, "kr_cstms_corr_id") = "I";
		}
		break;
	case "04":
		for(var i=1; i <= sheetObjects[0].RowCount; i++ ) {
			sheetObjects[0].CellValue(i, "kr_cstms_corr_id") = "D";
		}
		for(var i=1; i <= sheetObjects[1].RowCount; i++ ) {
			sheetObjects[1].CellValue(i, "kr_cstms_corr_id") = "D";
		}
		break;
	}
} 

// Cargo Spec 포커스 인 처리
function cboCargoSpec_OnFocus(comboObj) {
	if (comboObj.Code=="1") {
		oldData = "1";
	}else if (comboObj.Code=="2") {
		oldData = "2";
	}else {
		oldData = "";
	}	
}

/**
 * Cargo Spec 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoSpec_OnChange(comboObj,value,text) {
	var form = document.form;
	form.cgo_spec.value = value;
	if (value=="1") {
		newData = "1";
	}else if (value=="2") {
		newData = "2";
	}else {
		newData = "";
		form.cgo_spec.value="";
	}	
}

// Cargo Spec 포커스 아웃 처리
function cboCargoSpec_OnBlur(comboObj) {
	var form = document.form;
	
	if (oldData != newData) {
	
		if (form.io_bnd_cd.value=="I") {
			addCorrList("EL", "", oldData, newData);
		} else {
			addCorrList("EL", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData = "";
		newData = "";
	}
}

/**
 * Warehouse Type 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboWhTpCd_OnChange(comboObj,value,text) {
	var form = document.form;
	form.kr_cstms_wh_tp_cd.value = value;
}

/**
 * BIZ NO 포커스 인 처리
 * @param comboObj
 * @return
 */
function cboBizNo_OnFocus(comboObj) {
	oldData = comboObj.Code;
}

/**
 * BIZ NO 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboBizNo_OnChange(comboObj,value,text) {
	var form = document.form;
	var bizNo = value;
	
	if (bizNo.length < 1 ) bizNo = text;
	
	var index = comboObj.FindIndex(ComGetMaskedValue(bizNo, "saupja"),0);
	if (index < 0 ) {
		comboObj.insertItem(-1, ComGetMaskedValue(bizNo, "saupja")+"|", bizNo); 
	}
	
	form.biz_no.value = bizNo;
	newData = bizNo;
}

/**
 * BIZ NO 포커스 아웃 처리 
 * @param comboObj
 * @return
 */
function cboBizNo_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form = document.form;
		// Receiver 변경
		comboObjects[0].Code = "P";
		// 이력 추가
		// IN BOUND의 경우
		if (form.io_bnd_cd.value=="I") {
			addCorrList("ZA6", "", oldData, newData);
		}else {
			addCorrList("ZA6", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData = "";
		newData = "";
	}
}

/**
 * 패키지 코드 포커스 인 처리
 * @param comboObj
 * @return
 */
function cboPackage_OnFocus(comboObj) {
	oldData = comboObj.Code;
}

/**
 * 패키지 코드 변경시 처리 
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboPackage_OnChange(comboObj,value,text) {
	var form = document.form;
	form.pck_tp_cd.value = value;
	newData = value;
}

function sleep(milliseconds) {
	
	var start = new Date().getTime();
	for(var i=0; i < 1e7; i++) {
		if ( (new Date().getTime() - start )  > milliseconds ) {
			break;
		}
	}
}
/**
 * 패키지 코드 포커스 아웃 처리 
 * @param comboObj
 * @return
 */
function cboPackage_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form = document.form;
		// Receiver 변경
		comboObjects[0].Code = "A";
		// 이력 추가
		// IN BOUND의 경우
		if (form.io_bnd_cd.value=="I") {
			addCorrList("BG", "", oldData, newData);
		}else {
			addCorrList("BG", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData = "";
		newData = "";
	}
}

/**
 * Mea 코드 포커스 인 처리: 4세대 MACAMD
 * @param comboObj
 * @return
 */
function cboMeaUnit_OnFocus(comboObj) {
	oldData = comboObj.Code;
}

/**
 * Mea Unit 변경시 처리 : 4세대 MACAMD
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboMeaUnit_OnChange(comboObj,value,text) {
	var form = document.form;
	form.kr_meas_ut_cd.value = value;
	// 4세대 MACAMD
	newData = value;
}


/**
 * MEA 코드 포커스 아웃 처리 : 4세대 MACAMD
 * @param comboObj
 * @return
 */
function cboMeaUnit_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form = document.form;
		// Receiver 변경
		// Receiver P로
	  	comboObjects[0].Code = "P";
	  
	  	// IN BOUND의 경우
	  	if (document.form.io_bnd_cd.value=="I") {
	  		addCorrList("ZA4", "", oldData, newData);
	  	}else {
	  		addCorrList("ZA4", "화주 요청에 의한 정정", oldData, newData);
	  	}
		
		oldData = "";
		newData = "";
	}
}

// 콤보, Grid 및 폼  초기화
function resetForm()
{
	var form = document.form;

	form.reset();

	// 콤보 초기화
	comboObjects[0].Code = "A";
	comboObjects[1].Code = document.form.cstms_decl_tp_cd.value;
	comboObjects[2].Code = "01";
	comboObjects[3].Code = "";
	comboObjects[4].Code = "";
	comboObjects[5].Code = "";
	comboObjects[6].Code = "";
	comboObjects[7].Code = "";
	comboObjects[8].Code = "M";

	// Grid 초기화
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();

}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	switch(sAction) {

	case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;	
			// portCd 저장
			var portCd = formObj.port_cd.value;
			var cstmsDeclTpCd = formObj.cstms_decl_tp_cd.value;
			sheetObj.Redraw = false;
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			var sXml = sheetObj.getSearchXml("ESM_BKG_0031GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");	
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			ComEtcDataToForm(formObj, sheetObj);
			// PortCd 복구
			formObj.port_cd.value = portCd;
			formObj.cstms_decl_tp_cd.value = cstmsDeclTpCd;
			// 검색결과의 Trans 코드 저장 
			formObj.old_cstms_decl_tp_cd.value = formObj.cstms_decl_tp_cd.value;
			// 그리드 적용
			sheetObjects[1].LoadSearchXml(arrXml[1]);
			sheetObjects[2].LoadSearchXml(arrXml[2]);
			
			// Multi Combo 처리
			// RECEIVER
			if (formObj.amdt_rcvr_flg.value.length > 0) {
				comboObjects[0].Code2 = formObj.amdt_rcvr_flg.value;
			}else {
				formObj.amdt_rcvr_flg.value = comboObjects[0].Code;
			}
			// Correction
			comboObjects[2].Code2 = formObj.kr_cstms_corr_id.value;
			if (comboObjects[2].Code == "03" || comboObjects[2].Code == "04") {
				comboObjects[0].Code = "A";
			}
			// Cargo Spec
			comboObjects[3].Code2 = formObj.cgo_spec.value;
			if (formObj.cgo_spec_clear.value=="Y") comboObjects[3].Code = "";
			// HS CODE
			comboObjects[4].Code2 = formObj.cmdt_cd.value; 
			// PACKAGE
			comboObjects[5].Code2 = formObj.pck_tp_cd.value;
			// BIZ NO
			var bizNo = ComGetMaskedValue(formObj.biz_rgst_no.value,  "saupja");
			var itemIndex = comboObjects[6].FindIndex(bizNo,0);
			if (itemIndex==-1) {
				comboObjects[6].InsertItem(-1, bizNo+"| ", formObj.biz_rgst_no.value);
				comboObjects[6].Code2 = formObj.biz_rgst_no.value;
			}else {
				comboObjects[6].Code2 = itemIndex;
			}
			// Warehouse
			comboObjects[7].Code2 = formObj.kr_cstms_wh_tp_cd.value;
			// MEA UNIT
			comboObjects[8].Code2 = formObj.kr_meas_ut_cd.value;
			// FORM 값 자릿수 정리
			formObj.cstms_ofc_cty_cd.value = ComLpad(formObj.cstms_ofc_cty_cd.value, 3, "0");
			formObj.kr_cstms_dept_cd.value = ComLpad(formObj.kr_cstms_dept_cd.value,2,"0");
			formObj.kr_port_auth_cd.value = ComLpad(formObj.kr_port_auth_cd.value,3,"0");
			formObj.call_knt.value = ComLpad(formObj.call_knt.value,3,"0");
		
			sheetObj.Redraw = true;
			// 숫자 자릿수 처리
			formObj.cntr_ttl_wgt.value  = ComAddComma3(formObj.cntr_ttl_wgt.value, 	"#,###.000");
			formObj.meas_qty.value 		= ComAddComma3(formObj.meas_qty.value,		"#,###.000");
			ComOpenWait(false);
		}
		break;

	case MODIFY01:      // TRANSMIT
		if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?		
			
			if (!validateForm(sheetObjects[2], formObj, sAction))  return;
			
			ComOpenWait(true);
			// SAVE 
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].RowStatus(1) = "U";
			formObj.f_cmd.value = MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_TransAmendment");
			ComBtnDisable("btn_TransDischAmend");
			tabObjects[0].SelectedIndex = 0;
			var params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_")+"&c_trns_seq="+form.c_trns_seq.value+"&dmst_port_cd="+form.dmst_port_cd.value;
			
			sheetObjects[3].getSearchXml("ESM_BKG_0031GS.do", params);
			// Receiver 백업
			var rcv = comboObjects[0].Code;			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			// Receiver 복구
			comboObjects[0].Code = rcv;
			// Transmit
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].RowStatus(1) = "U";
			formObj.f_cmd.value = MODIFY01;		
			params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_")+"&c_trns_seq="+form.c_trns_seq.value+"&dmst_port_cd="+form.dmst_port_cd.value;
			params = params + "&trans_dmr=N";			                
			sheetObjects[3].DoSave("ESM_BKG_0031GS.do", params, -1, false);
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_TransAmendment");	
			// InBound 의 경우는 버튼 활성처리
			if (formObj.io_bnd_cd.value=="I") {
				ComBtnEnable("btn_TransDischAmend");
			} else {
				ComBtnDisable("btn_TransDischAmend");
			}			
			// 자동 조회			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComBtnEnable("btn_Save");
			// Receiver 복구
			comboObjects[0].Code = rcv;
			ComOpenWait(false);
		}
		break;
	case MODIFY02:      // TRANSMIT DISCH
		if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?		
			
			if (!validateForm(sheetObjects[2], formObj, sAction))  return;
			
			ComOpenWait(true);
			// SAVE 
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].RowStatus(1) = "U";
			formObj.f_cmd.value = MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_TransAmendment");
			ComBtnDisable("btn_TransDischAmend");
			tabObjects[0].SelectedIndex = 0;
			var params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			sheetObjects[3].getSearchXml("ESM_BKG_0031GS.do", params);
			// Receiver 백업
			var rcv = comboObjects[0].Code;			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			// Receiver 복구
			comboObjects[0].Code = rcv;
			// Transmit
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].RowStatus(1) = "U";
			formObj.f_cmd.value = MODIFY01;		
			params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			params = params + "&trans_dmr=Y";            
			sheetObjects[3].DoSave("ESM_BKG_0031GS.do", params, -1, false);
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_TransAmendment");			
			ComBtnEnable("btn_TransDischAmend");			
			// 자동 조회			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComBtnEnable("btn_Save");
			// Receiver 복구
			comboObjects[0].Code = rcv;
			ComOpenWait(false);
		}
		break;
	
	case COMMAND09: 	// 코드 데이터 조회
		// 패키지 정보 조회 후 콤보들에 적용
		formObj.f_cmd.value= COMMAND09;
		var sXml = sheetObj.GetSearchXML("ESM_BKG_0505GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		ComXml2ComboItem(arrXml[1], comboObjects[4], "cmdt_cd", "rep_cmdt_cd|cmdt_cd");
		ComXml2ComboItem(arrXml[0], comboObjects[5],  "pck_cd",			"pck_cd|pck_nm");
		var comboXML  = ComXml2ComboString2(arrXml[0], "pck_cd", 		"pck_nm");
		var comboXML2 = ComXml2ComboString (arrXml[2], "cntr_tpsz_cd", 	"cntr_tpsz_cd");
		sheetObjects[0].InitDataCombo(0, "pck_tp_cd", 		comboXML[0]+"| ", 	comboXML[1]+"|");
		sheetObjects[0].InitDataCombo(0, "cntr_tpsz_cd", 	comboXML2[0]+"| ", 	comboXML2[1]+"|");
		sheetObjects[1].InitDataCombo(0, "pck_tp_cd", 		comboXML[0]+"| ", 	comboXML[1]+"|");
		break;
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
		break;
	case IBSAVE:	// 추가/수정/삭제
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			
			if (!validateForm(sheetObjects[2], formObj, sAction))  return;
			
			
			ComOpenWait(true);
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].RowStatus(1) = "U";
			formObj.f_cmd.value = MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			var params = FormQueryString(formObj);
			params = params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
			                + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			if (sheetObjects[3].DoSave("ESM_BKG_0031GS.do", params, -1, false)) {
				// Receiver 백업
				var rcv = comboObjects[0].Code;
				// 자동 조회				
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				ComBtnEnable("btn_TransAmendment");
				// InBound 의 경우는 버튼 활성처리
				if (formObj.io_bnd_cd.value=="I") {
					ComBtnEnable("btn_TransDischAmend");
				} else {
					ComBtnDisable("btn_TransDischAmend");
				}
				// Receiver 복구
				comboObjects[0].Code = rcv;
			}
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_Save");			
			ComOpenWait(false);
		}
		break;
	}
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {

			var cnt  = 0 ;
			InsertTab( cnt++ , "Container Info." , -1 );
			InsertTab( cnt++ , "Customer Info." , -1 );
			InsertTab( cnt++ , "Export No." , -1 );
			InsertTab( cnt++ , "VVD-B/L Cor List" , -1 );

		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{


	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
	beforetab= nItem;
}

//페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;	
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
	case MODIFY01:
	case MODIFY02:
	case IBSAVE:
		
		if(form.kr_cstms_corr_id.value == '' || form.kr_cstms_corr_id.value == null ){
			ComShowCodeMessage("BKG00626",'Correction');
			form.cboCorrection.focus();
			return false;
		}
		
		if(form.corr_rsn.value == '' || form.corr_rsn.value == null ){
			ComShowCodeMessage("BKG00626",'Reason');
			form.corr_rsn.focus();
			return false;
		}
		
		if(form.cgo_desc1.value == '' || form.cgo_desc1.value == null ){
			ComShowCodeMessage("BKG00626",'Cargo Desc. 1');
			form.cgo_desc1.focus();
			return false;
		}
		
		if(sheetObj.RowCount > 0){
			for (var i=1; i <= sheetObj.RowCount; i++ ) {
				if(sheetObj.CellValue(i, "corr_rsn") == ""){
					ComShowCodeMessage("BKG00626",'Correction Reason (VVD-B/L Cor List tab)');
					sheetObj.SelectCell(i, "corr_rsn ");
					return false;
				}
			}
			
		}
		break;
	}
	return true;
}

 /**
 * Sheet Comobo 에 XML 적용시 코드와 값 컬럼 2개를 적용할 수 있도록 수정된 함수 
 * @param xmlStr
 * @param codeCol
 * @param textCol
 * @return
 */
function ComXml2ComboString2(xmlStr, codeCol, textCol) {
	 var rtnArr = new Array();

	 if (xmlStr == null || xmlStr == "") {
		 return;
	 }
	 if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		 return;
	 }

	 try {
		 var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		 xmlDoc.loadXML(xmlStr);

		 var xmlRoot = xmlDoc.documentElement;
		 if (xmlRoot == null) {
			 return;
		 }

		 var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		 if (dataNode == null || dataNode.attributes.length < 3) {
			 return;
		 }

		 var col = dataNode.getAttribute("COLORDER");
		 var colArr = col.split("|");
		 var sep = dataNode.getAttribute("COLSEPARATOR");
		 var total = dataNode.getAttribute("TOTAL");

		 var dataChildNodes = dataNode.childNodes;
		 if (dataChildNodes == null) {
			 return;
		 }

		 var colListIdx = Array();
		 for ( var i = 0; i < colArr.length; i++) {
			 if (colArr[i] == codeCol) {
				 colListIdx[0] = i;
			 }
			 if (colArr[i] == textCol) {
				 colListIdx[1] = i;
			 }		
		 }

		 var sCode = "";
		 var sText = "";
		 for ( var i = 0; i < dataChildNodes.length; i++) {
			 if (dataChildNodes[i].nodeType != 1) {
				 continue;
			 }
			 var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

			 sCode += arrData[colListIdx[0]];
			 sText += arrData[colListIdx[0]]+"\t"+arrData[colListIdx[1]];

			 if (i != dataChildNodes.length - 1) {
				 sCode += "|";
				 sText += "|";
			 }
		 }
		 rtnArr.push(sText);
		 rtnArr.push(sCode);
		 
	 } catch (err) {
		 ComFuncErrMsg(err.message);
	 }

	 return rtnArr;
}


/**
 * 숫자형태 콤마 등 추가
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.pck_qty.value 			= ComGetMaskedValue(formObj.pck_qty.value, 			"int");
	formObj.cntr_ttl_wgt.value  	= ComGetMaskedValue(formObj.cntr_ttl_wgt.value, 	"float");
	formObj.meas_qty.value  		= ComGetMaskedValue(formObj.meas_qty.value,			"float");
	formObj.bb_cgo_meas_qty.value  	= ComGetMaskedValue(formObj.bb_cgo_meas_qty.value, 	"float");
}

/**
 * 숫자형태 콤마 제거
 * @param formObj
 * @return
 */
function changeNumberToTextFormat(formObj) {
	formObj.pck_qty.value 			= ComGetUnMaskedValue(formObj.pck_qty.value, 		"int");
	formObj.cntr_ttl_wgt.value  	= ComGetUnMaskedValue(formObj.cntr_ttl_wgt.value, 	"float");
	formObj.meas_qty.value  		= ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.meas_qty.value  		= ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.bb_cgo_meas_qty.value  	= ComGetUnMaskedValue(formObj.bb_cgo_meas_qty.value,"float");
}

// Sheet1 Container 편집시 이전 정보 처리
function t1sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	// 수정시에만 적용
	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.CellValue(Row, "pre_cntr_no") == "") sheetObj.CellValue(Row, "pre_cntr_no") = sheetObj.CellValue(Row, Col);
		}else{
			oldData = sheetObj.CellValue(Row, Col);
		}
	}
}

// Sheet1 Container 편집 후 처리 
function t1sheet1_OnAfterEdit(sheetObj, Row, Col) {
	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.CellValue(Row, "cntr_no")==sheetObj.CellValue(Row, "pre_cntr_no")) 
				sheetObj.CellValue(Row, "pre_cntr_no") = "";
		}
	}
}

/**
 * Tab1 Sheet1 변경시 처리 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t1sheet1_OnChange(sheetObj, Row, Col) {

	// Container 변경시
	if (Col==3) {
		var formObj = document.form;
		if (Col==3) {
			// 데이터 조회
			formObj.f_cmd.value = COMMAND02;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_0031GS.do?cntr_no="+sheetObj.CellValue(Row,Col)+"&f_cmd="+formObj.f_cmd.value);
			if (ComGetEtcData(sXml, "tpsz_cd")!=null && ComGetEtcData(sXml, "tpsz_cd").length > 1) {
				sheetObj.CellValue(Row, "cntr_tpsz_cd") = ComGetEtcData(sXml, "tpsz_cd");
			}
		}
	}

	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		// Container No 변경시 처리 
		if (Col==3) {
			if (sheetObj.CellValue(Row, "cntr_no")==sheetObj.CellValue(Row, "pre_cntr_no")) 
				sheetObj.CellValue(Row, "pre_cntr_no") = "";
			if (sheetObj.CellValue(Row, "pre_cntr_no") !="") {
				sheetObj.CellValue(Row, "kr_cstms_corr_id") = "X";
				sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EH";
				sheetObj.CellValue(Row, "pre_dat_ctnt") = sheetObj.CellValue(Row, "pre_cntr_no");
				sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "cntr_no");
			}
		}else if (Col==5) {
			// TP 변경시 처리
			sheetObj.CellValue(Row, "pre_dat_ctnt") = oldData;
			sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "cntr_tpsz_cd");
			sheetObj.CellValue(Row, "kr_cstms_corr_id") = "U";
			sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EA";
			oldData = "";
		}else if (Col==6) {
			// Seal No1 변경시 처리
			sheetObj.CellValue(Row, "pre_dat_ctnt") = oldData;
			sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "cntr_seal_no1");
			sheetObj.CellValue(Row, "kr_cstms_corr_id") = "U";
			sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EB";
			oldData = "";
		}else if (Col==7) {
			// Seal No2 변경시 처리
			sheetObj.CellValue(Row, "pre_dat_ctnt") = oldData;
			sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "cntr_seal_no2");
			sheetObj.CellValue(Row, "kr_cstms_corr_id") = "U";
			sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EB";
			oldData = "";
		}else if (Col==8) {
			// Package 변경시 처리
			sheetObj.CellValue(Row, "pre_dat_ctnt") = oldData;
			sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "pck_qty");
			sheetObj.CellValue(Row, "kr_cstms_corr_id") = "U";
			sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EJ";
			oldData = "";
		}else if (Col==9) {
			// Package Code 변경시 처리
			sheetObj.CellValue(Row, "pre_dat_ctnt") = oldData;
			sheetObj.CellValue(Row, "crnt_dat_ctnt") = sheetObj.CellValue(Row, "pck_tp_cd");
			sheetObj.CellValue(Row, "kr_cstms_corr_id") = "U";
			sheetObj.CellValue(Row, "kr_cstms_corr_id2") = "EK";
			oldData = "";
		}
	}

	// Correction 수정시
	if (Col==14) {
		switch(sheetObj.CellValue(Row, Col)) {
		case "A":
			sheetObj.CellValue(Row, "corr_rsn") = "CNTR 추가";
			break;
		case "U":
			sheetObj.CellValue(Row, "corr_rsn") = "Container No 이외의 정정";
			break;
		case "D":
			sheetObj.CellValue(Row, "corr_rsn") = "CNTR 삭제";
			break;
		case "X":
			sheetObj.CellValue(Row, "corr_rsn") = "Container No 및 내용정정";
			break;
		default:
			sheetObj.CellValue(Row, "corr_rsn") = "";
		break
		}

	}
}

/**
 * Tab3 Export No Sheet 변경 전 처리
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	// 수정시에만 적용
	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.CellValue(Row, "pre_xpt_lic_no") == "") sheetObj.CellValue(Row, "pre_xpt_lic_no") = sheetObj.CellValue(Row, Col);
		}else{
			oldData = sheetObj.CellValue(Row, Col);
		}
	}
}

/**
 * Tab3 Export No Sheet 변경 후 처리 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnAfterEdit(sheetObj, Row, Col) {
	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.CellValue(Row, "xpt_lic_no")==sheetObj.CellValue(Row, "pre_xpt_lic_no")) 
				sheetObj.CellValue(Row, "pre_xpt_lic_no") = "";
		}
	}
}

/**
 * Tab3 Export No Sheet 변경 처리 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnChange(sheetObj, Row, Col) {
	if (sheetObj.CellValue(Row, "ibflag")!="I") {
		// Container No 변경시 처리 
		if (Col==3) {
			if (sheetObj.CellValue(Row, "xpt_lic_no")==sheetObj.CellValue(Row, "pre_xpt_lic_no")) sheetObj.CellValue(Row, "pre_xpt_lic_no") = "";
			if (sheetObj.CellValue(Row, "pre_xpt_lic_no") !="") sheetObj.CellValue(Row, "kr_cstms_corr_id") = "X";
		}
	}
}

// POD 변경시 처리
function pod_onChange()
{
	var form = document.form;

	comboObjects[0].Code = "A";

	// 이력 추가 
	if (form.io_bnd_cd.value=="I") {
		addCorrList("BA", "", oldData, form.pod_cd.value);
	}else {
		addCorrList("BA", "화주 요청에 의한 정정", oldData, form.pod_cd.value);
	}
	oldData = "";
	form.vsl_call_sgn_cd.focus();

}

// POL 변경시 처리
function pol_onChange()
{
	var form = document.form;

	comboObjects[0].Code = "A";

	// 이력 추가 
	if (form.io_bnd_cd.value=="I") {
		addCorrList("AE", "", oldData, form.pol_cd.value);
	}else {
		addCorrList("AE", "화주 요청에 의한 정정", oldData, form.pol_cd.value);
	}
	oldData = "";
	form.pod_cd.focus();

}

// Bond Area Code 변경시 처리
function bdAreaCd_onChange()
{
	// Receiver 는 A로
	comboObjects[0].Code = "A";

	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BT", "", oldData, document.form.bd_area_cd.value);
	}else {
		addCorrList("BN", "화주 요청에 의한 정정", oldData, document.form.bd_area_cd.value);
	}
	oldData = "";
	form.kr_wh_cd.focus();
}

// Weight 변경시 처리
function cntrTtlWgt_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";
	
	// 콤마 추가
	document.form.cntr_ttl_wgt.value = ComAddComma3(document.form.cntr_ttl_wgt.value, "#,###.000");

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CB", "", oldData, document.form.cntr_ttl_wgt.value);
	}else {
		// 4세대 MACAMD는 BH에서 CB로 변경
		addCorrList("BH", "화주 요청에 의한 정정", oldData, document.form.cntr_ttl_wgt.value);
		//addCorrList("CB", "화주 요청에 의한 정정", oldData, document.form.cntr_ttl_wgt.value);
		
	}
	oldData = "";
	form.wgt_ut_cd.focus();

}

// MEAS 변경시 처리 
function measQty_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CC", "", oldData, document.form.meas_qty.value);
	}else {
		// 4세대 MACAMD BJ에서 CC로 변경
		addCorrList("BJ", "화주 요청에 의한 정정", oldData, document.form.meas_qty.value);
		//addCorrList("CC", "화주 요청에 의한 정정", oldData, document.form.meas_qty.value);
		
	}
	oldData = "";
	form.meas_ut_cd.focus();
}

// Package 변경시 처리 
function pckQty_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CA", "", pkgOldData, document.form.pck_qty.value);
	}else {
		addCorrList("BK", "화주 요청에 의한 정정", pkgOldData, document.form.pck_qty.value);
	}
	pkgOldData = "";
}

function setPckOldData(val) {
	pkgOldData = val;
}

// VSL NAME 변경시 처리
function vslNm_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AA", "", oldData, document.form.vsl_nm.value);
	}else {
		addCorrList("AA", "화주 요청에 의한 정정", oldData, document.form.vsl_nm.value);
	}
	oldData = "";
	form.vsl_cnt_cd.focus();
}

// VVD 변경시 처리
function vvd_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AB", "", oldData, document.form.vvd.value);
	}else {
		addCorrList("AB", "화주 요청에 의한 정정", oldData, document.form.vvd.value);
	}
	oldData = "";
	form.pol_cd.focus();
}

// Call Sign 변경시 처리
function vslCallSgnCd_onChange()
{
	// Receiver C로
	comboObjects[0].Code = "C";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AC", "", oldData, document.form.vsl_call_sgn_cd.value);
	}else {
		addCorrList("AC", "화주 요청에 의한 정정", oldData, document.form.vsl_call_sgn_cd.value);
	}
	oldData = "";
	form.eta_dt.focus();
}

// Flag 변경시 처리
function vslCntCd_onChange()
{
	// Receiver A로
	comboObjects[0].Code = "A";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AD", "", oldData, document.form.vsl_cnt_cd.value);
	}else {
		addCorrList("AD", "화주 요청에 의한 정정", oldData, document.form.vsl_cnt_cd.value);
	}
	oldData = "";
	form.imdg_clss_cd.focus();
}

// QUAY 변경시 처리
function ioTmlLocCd_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA2", "", oldData, document.form.io_tml_loc_cd.value);
	}else {
		addCorrList("ZA2", "화주 요청에 의한 정정", oldData, document.form.io_tml_loc_cd.value);
	}
	oldData = "";
	form.dchg_mzd_cd.focus();
}

// MEAS UT 변경시 처리
function measUtCd_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		// 4세대 MACAMD: 주석처리: cboMeaUnit로 이동
		//addCorrList("ZA4", "", oldData, document.form.meas_ut_cd.value);
	}else {
		// 4세대 MACAMD: 주석처리: cboMeaUnit로 이동
		//addCorrList("ZA4", "화주 요청에 의한 정정", oldData, document.form.meas_ut_cd.value);
	}
	oldData = "";
	form.dchg_mzd_cd.focus();
}

// Bulk Weight 변경시 처리
function bbCgoWgt_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA7", "", oldData, document.form.bb_cgo_wgt.value);
	}else {
		addCorrList("ZA7", "화주 요청에 의한 정정", oldData, document.form.bb_cgo_wgt.value);
	}
	oldData = "";
	form.bb_cgo_meas_qty.focus();
}

// Bulk Mea 변경시 처리
function bbCgoMeasQty_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA8", "", oldData, document.form.bb_cgo_meas_qty.value);
	}else {
		addCorrList("ZA8", "화주 요청에 의한 정정", oldData, document.form.bb_cgo_meas_qty.value);
	}
	oldData = "";
	form.io_tml_loc_cd.focus();
}

// BL Type 변경시 처리
function krCstmsBlTpCd_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BO", "", oldData, document.form.kr_cstms_bl_tp_cd.value);
	}else {
		// 4세대: 주석처리함. 신고하지 않음.
		//addCorrList("BO", "화주 요청에 의한 정정", oldData, document.form.kr_cstms_bl_tp_cd.value);
		
		
	}
	oldData = "";
	form.vvd.focus();
}

// Forward 포커스 인 처리
function cstmsFwrdId_OnFocus()
{
	var form = document.form;
	oldData = form.cstms_fwrd_id.value;
}

// Forward 변경시 처리
function cstmsFwrdId_OnChange()
{
	var form = document.form;
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BO", "", oldData, form.cstms_fwrd_id.value);
	}else {
		addCorrList("BO", "화주 요청에 의한 정정", oldData, form.cstms_fwrd_id.value);
	}
	oldData = "";
	newData = "";
}

// 하역방법 변경시 처리
function dchgMzdCd_onChange()
{
	// Receiver P로
	comboObjects[0].Code = "P";

	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA1", "", oldData, document.form.dchg_mzd_cd.value);
	}else {
		addCorrList("ZA1", "화주 요청에 의한 정정", oldData, document.form.dchg_mzd_cd.value);
	}
	oldData = "";
	form.cgo_desc1.focus();
}

// IMDG1 변경시 처리
function imdgClssCd_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].Code = "A";
		addCorrList("BP", "", oldData, document.form.imdg_clss_cd.value);
	}else {
		comboObjects[0].Code = "P";
		addCorrList("BP", "화주 요청에 의한 정정", oldData, document.form.imdg_clss_cd.value);
	}
	oldData = "";
	form.n2nd_imdg_clss_cd.focus();
}

// IMDG2 변경시 처리
function n2ndImdgClssCd_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].Code = "C";
		addCorrList("BQ", "", oldData, document.form.n2nd_imdg_clss_cd.value);
	}else {
		comboObjects[0].Code = "P";
		addCorrList("BQ", "화주 요청에 의한 정정", oldData, document.form.n2nd_imdg_clss_cd.value);
	}
	oldData = "";
	form.n3rd_imdg_clss_cd.focus();
}

// IMDG3 변경시 처리
function n3rdImdgClssCd_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].Code = "C";
		addCorrList("BR", "", oldData, document.form.n3rd_imdg_clss_cd.value);
	}else {
		comboObjects[0].Code = "P";
		addCorrList("BR", "화주 요청에 의한 정정", oldData, document.form.n3rd_imdg_clss_cd.value);
	}
	oldData = "";
	form.pck_qty.focus();
}

// Shipper Name 변경시 처리
function sCustNm_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BC", "", oldData, document.form.s_cust_nm.value);
	}else {
		addCorrList("BC", "화주 요청에 의한 정정", oldData, document.form.s_cust_nm.value);
	}
	oldData = "";
	form.s_cust_addr.focus();
}

// Shipper Addr 변경시 처리
function sCustAddr_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		// 4세대 IMFMOD MACAMD BC에서 BC1으로 변경
		//addCorrList("BC", "", oldData, document.form.s_cust_addr.value);
		addCorrList("BC1", "", oldData, document.form.s_cust_addr.value);
	}else {
		addCorrList("BC1", "화주 요청에 의한 정정", oldData, document.form.s_cust_addr.value);
	}
	oldData = "";
	form.c_cust_nm.focus();
}

// Cosignee Name 변경시 처리
function cCustNm_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BD", "", oldData, document.form.c_cust_nm.value);
	}else {
		addCorrList("BD", "화주 요청에 의한 정정", oldData, document.form.c_cust_nm.value);
	}
	oldData = "";
	form.c_cust_addr.focus();
}

// Cosignee Addr 변경시 처리
function cCustAddr_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BD1", "", oldData, document.form.c_cust_addr.value);
	}else {
		addCorrList("BD1", "화주 요청에 의한 정정", oldData, document.form.c_cust_addr.value);
	}
	oldData = "";
	form.n_cust_nm.focus();
}

// Notify Name 변경시 처리
function nCustNm_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BE", "", oldData, document.form.n_cust_nm.value);
	}else {
		addCorrList("BE", "화주 요청에 의한 정정", oldData, document.form.n_cust_nm.value);
	}
	oldData = "";
	form.n_cust_addr.focus();
}

// Notify Addr 변경시 처리
function nCustAddr_onChange()
{
	// IN BOUND의 경우
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BE1", "", oldData, document.form.n_cust_addr.value);
	}else {
		addCorrList("BE1", "화주 요청에 의한 정정", oldData, document.form.n_cust_addr.value);
	}
	oldData = "";
}

// 이전 값 저장
function setOldData(val) {	
	oldData = val;
}

// VVD-B/L Cor List 그리드에 이력 추가
function addCorrList(corr_id, corr_rsn, old1, new1)
{
	var canUpdate = false;
	// 동일한 corr_id 가 존재하고 old2, new2 값이 비어있으면 UPDATE 처리한다
	for (var i=1; i <= sheetObjects[2].RowCount; i++ ) {
		if (sheetObjects[2].CellValue(i, "pre_ctnt2")!="" || sheetObjects[2].CellValue(i, "pre_ctnt2")!="") continue;
		if (sheetObjects[2].CellValue(i, "kr_cstms_corr_id")!=corr_id) continue;
		canUpdate = true;
		sheetObjects[2].CellValue(i, "pre_ctnt2") = old1;
		sheetObjects[2].CellValue(i, "crnt_ctnt2") = new1;
		break;
	}
	if (canUpdate==false) {
		sheetObjects[2].DataInsert(-1);	  
		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "pre_ctnt1") = old1;
		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "crnt_ctnt1") = new1;
		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "kr_cstms_corr_id") = corr_id;
		sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "corr_rsn") = corr_rsn;
	}
}

/**
 * 숫자형태 콤마 추가 함수 
 * @param obj
 * @param sFormat
 * @return
 */
function ComAddComma3(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal = getArgValue(obj);

		switch(sFormat)
		{
		case "#,###" :
			return ComAddComma(sVal);
		case "#,###.0" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".0";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.00" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".00";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.000" :
			p = sVal.split(".");
			p[0] = ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".000";
			else if (p.length == 2) {
             	if(p[1].length == 1)
             		return p[0]+"."+p[1]+"00";
             	else if(p[1].length == 2)
             		return p[0]+"."+p[1]+"0";
             	else 
             		return p[0]+"."+p[1]
             }
			else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}  