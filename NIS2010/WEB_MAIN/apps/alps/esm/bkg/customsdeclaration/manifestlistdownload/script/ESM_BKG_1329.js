/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1329.js
*@FileTitle : Korea Manifest Download
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.05.25 박상훈
* 1.0 Creation
* --------------------------------------------------------
* history
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * JSDOC 을 위한 함수정의
 */
function esm_bkg_1329()
{
	this.processButtonClick		= processButtonClick;
	this.sheet1_OnClick			= sheet1_OnClick;
	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
	this.sheet1_OnMouseDown		= sheet1_OnMouseDown;
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.doActionIBSheet 		= doActionIBSheet;
	this.doActionValidationResult = doActionValidationResult;
	this.funcOnFocus			= funcOnFocus;
	this.funcSetBoundOption		= funcSetBoundOption;
	this.funcSetDownLoadOption	= funcSetDownLoadOption;
	this.funcSelectValidate		= funcSelectValidate;
	this.funcShowValueRows		= funcShowValueRows;
	this.funcShowAllRows		= funcShowAllRows;
	this.funcShowCheckError		= funcShowCheckError;
	this.funcBlTypeOnChange		= funcBlTypeOnChange;
	this.funcElTypeOnChange		= funcElTypeOnChange;
	this.funcCargoTypeOnChange	= funcCargoTypeOnChange;
	this.correction_OnChange	= correction_OnChange;
	this.funcClearAll			= funcClearAll;
	this.funcBlAddnEditPopup	= funcBlAddnEditPopup;
	this.funcSelectAll			= funcSelectAll;
	this.validateForm 			= validateForm;
	this.updateSummary			= updateSummary;
}


/* 개발자 작업	*/
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var cur_pol_pod = 'pod';
var hiddenIndex = new Array();
var IndexTop = 0;
var crossChk = false;

document.onclick = processButtonClick;

var IBTRANS = 1092;

var ViewOptionErrCheck = '';		//'', 'E'
var ViewOptionBlType = '';			//'', 'S', 'C', 'E'
var ViewOptionElNo = '';			//'', 'Y', 'N'
var ViewOptionCorrection = '';		//'', 'N', 'I', 'X', 'V', 'U'
var ViewOptionCargoType = '';

var thisRow = 0;
var intervalId = "";

var comboObjects = new Array();
var comboCnt = 0;
/***************************************************************************************************
 * 화면 마우스 클릭 이벤트를 받아서 해당 컴포넌트 명으로 구분지어 명령처리
 *
 ***************************************************************************************************/
function processButtonClick()
{
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject  = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];

	crossChk = false;

	var formObj = document.form;
	try
	{
		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName)
		{
			case "btn_retrieve":
				if (formObj.rad_crscheck.checked) {
					crossChk = true;
				} else {
					crossChk = false;
				}
				doActionIBSheet(sheetObject, formObj, SEARCH);
				break;
			case "btn_New":
				formObj.reset();
				funcOnFocus('pod');
				funcClearAll(sheetObjects, formObj);
				updateSummary();
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObject, formObj, IBDELETE);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
				break;
			case "btn_DataDL":
				doActionIBSheet(sheetObject, formObj, IBINSERT);
				break;
			case "btn_AddBL":
				funcBlAddnEditPopup('ADD');
				break;
			case "btn_EditBL":
				funcBlAddnEditPopup('EDIT');
				break;
			case "btn_Transmission":
				ComOpenWait(true);
				if (document.transmitForm) {
					var N = document.transmitForm;
					N.parentNode.removeChild(N);
				}

				var f = document.createElement("form");
				f.name = "transmitForm";
				f.method = "POST";
				f.action = "/hanjin/ESM_BKG_1344.do?pgmNo=ESM_BKG_1344";
				f.target = "transmitWindow";
				document.appendChild(f);

				addHiddenField(f, "in_vvd", 	formObj.in_vvd.value);
				addHiddenField(f, "in_pol", 	formObj.in_pol.value);
				// Inbound 일때는 in_type(=sel_type)을 N으로 설정한다.
				if(formObj.in_bound.value == "I"){
					addHiddenField(f, "in_type", 	"N");
				} else {
					addHiddenField(f, "in_type", 	formObj.sel_type.value);
				}
				addHiddenField(f, "in_pod", 	formObj.in_pod.value);
				addHiddenField(f, "in_blno", 	formObj.in_blno.value);
				addHiddenField(f, "in_bound", 	formObj.in_bound.value);
				addHiddenField(f, "in_tml", 	formObj.in_hn.value);
				addHiddenField(f, "dwell", 		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_dwell_dt"));
				addHiddenField(f, "ib_vvd", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_ib_vvd"));
				addHiddenField(f, "ib_seq", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_ib_trns_seq"));
				addHiddenField(f, "ib_cblno", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_c_bl_no"));
				addHiddenField(f, "ib_port", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_ib_dmst_port_cd"));
				addHiddenField(f, "ib_bkgno", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_ib_mty_bkg_no"));
				addHiddenField(f, "ib_type", 	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 	"sheet1_ib_cstms_decl_tp_cd"));

				var inboundVVd  = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_ib_vvd");
				// 선택된 셀에 InBound Empty VVD 가 존재하면 같은 VVD 들 취합
				if (inboundVVd.trim().length > 1) {
					for(var i=2; i < sheetObjects[0].RowCount+2; i++) {
						if (sheetObjects[0].CellValue(i, "sheet1_ib_vvd")!=inboundVVd) continue;

						addHiddenField(f, "ib_ts_seq", 		sheetObjects[0].CellValue(i, "sheet1_ib_trns_seq"));
						addHiddenField(f, "ib_ts_cblno", 	sheetObjects[0].CellValue(i, "sheet1_ib_mty_bl_no"));
						addHiddenField(f, "ib_ts_port", 	sheetObjects[0].CellValue(i, "sheet1_ib_dmst_port_cd"));
						addHiddenField(f, "ib_ts_bkgno", 	sheetObjects[0].CellValue(i, "sheet1_ib_mty_bkg_no"));
						addHiddenField(f, "ib_ts_type", 	sheetObjects[0].CellValue(i, "sheet1_ib_cstms_decl_tp_cd"));
						addHiddenField(f, "ib_ts_vvd", 		sheetObjects[0].CellValue(i, "sheet1_ib_vvd"));
					}
				}
				ComOpenWait(false);
				window.open('about:blank', 'transmitWindow', 'width=1050, height=550, scrollbars=no');
				f.submit();
				break;
			case "rad_ib":
				funcOnFocus('pod');
				formObj.el_type.value = "";
				funcElTypeOnChange(formObj.el_type);
				break;
			case "rad_ob":
				funcOnFocus('pod');
				formObj.cgo_tp.value = "";
				funcCargoTypeOnChange(formObj.cgo_tp);
				break;
			case "rad_nodownlist":
				formObj.rad_nodownlist.checked = true;
				formObj.rad_downedlist.checked = false;
				formObj.rad_mftcheck.checked = false;
				formObj.rad_crscheck.checked = false;
				formObj.bl_dl.value = 'bl';
				formObj.bl_bkg_tp.value="BL";
				formObj.bl_bkg_tp.disabled = true;
				// MSN Save 버튼 처리
				formObj.msn_start_num.style.display="none";
				document.all.tb_msn_save.style.display="none";
				// ETB 숨김
				document.all.etb_td1.style.display="none";
				document.all.etb_td2.style.display="none";
				// SC 숨김
				document.all.sc_td1.style.display="none";
				document.all.sc_td2.style.display="none";

				// Result & Remark Save 버튼 처리
				//formObj.msn_start_num.style.display="none";
				document.all.tb_rlst_save.style.display="none";
				break;
			case "rad_downedlist":
				formObj.rad_nodownlist.checked = false;
				formObj.rad_downedlist.checked = true;
				formObj.rad_mftcheck.checked = false;
				formObj.rad_crscheck.checked = false;
				formObj.bl_dl.value = 'dl';
				formObj.bl_bkg_tp.disabled = false;
				// MSN Save 버튼 처리
				if (formObj.in_pod.value=="KRPUS" && formObj.rad_ib.checked) {
//					formObj.msn_start_num.style.display="inline";
//					document.all.tb_msn_save.style.display="inline";
				} else {
					formObj.msn_start_num.style.display="none";
					document.all.tb_msn_save.style.display="none";
				}
				// ETB 표시
				if (formObj.rad_ob.checked) {
//					document.all.etb_td1.style.display="inline";
//					document.all.etb_td2.style.display="inline";
				}
				// SC 숨김
				document.all.sc_td1.style.display="none";
				document.all.sc_td2.style.display="none";

				// Result & Remark Save 버튼 처리
				//formObj.msn_start_num.style.display="none";
				document.all.tb_rlst_save.style.display="none";
				break;
			case "rad_mftcheck":
				formObj.rad_nodownlist.checked = false;
				formObj.rad_downedlist.checked = false;
				formObj.rad_crscheck.checked = false;
				formObj.rad_mftcheck.checked = true;
				formObj.bl_dl.value = 'mc';
				formObj.bl_bkg_tp.disabled = false;
				// MSN Save 버튼 처리
				formObj.msn_start_num.style.display="none";
				document.all.tb_msn_save.style.display="none";
				// ETB 숨김
				document.all.etb_td1.style.display="none";
				document.all.etb_td2.style.display="none";
				// SC 보여줌
//				document.all.sc_td1.style.display="inline";
//				document.all.sc_td2.style.display="inline";

				// Result & Remark Save 버튼 처리
				//formObj.msn_start_num.style.display="none";
				document.all.tb_rlst_save.style.display="none";
				break;
			case "rad_crscheck":
				formObj.rad_nodownlist.checked = false;
				formObj.rad_downedlist.checked = false;
				formObj.rad_mftcheck.checked = false;
				formObj.rad_crscheck.checked = true;
				formObj.bl_dl.value = 'cr';
				formObj.bl_bkg_tp.disabled = false;
				// MSN Save 버튼 처리
				formObj.msn_start_num.style.display="none";
				document.all.tb_msn_save.style.display="none";
				// ETB 숨김
				document.all.etb_td1.style.display="none";
				document.all.etb_td2.style.display="none";
				// SC 보여줌
				document.all.sc_td1.style.display="none";
				document.all.sc_td2.style.display="none";

				// Result & Remark Save 버튼 처리
				//formObj.msn_start_num.style.display="none";
				document.all.tb_rlst_save.style.display="inline";
				break;
			case "rad_all":
				formObj.all_err.value = "all";
				formObj.rad_all.checked = true;
				formObj.rad_err.checked = false;
				ViewOptionErrCheck = '';
				funcShowValueRows();
				break;
			case "rad_err":
				formObj.all_err.value = "err";
				formObj.rad_all.checked = false;
				formObj.rad_err.checked = true;
				ViewOptionErrCheck = 'E';
				funcShowValueRows();
				break;
			case "in_pol":
				funcOnFocus('pod');
				formObj.in_pol.focus();
				break;
			case "in_pod":
				funcOnFocus('pod');
				formObj.in_pod.focus();
				break;
			case "btn_msn_save":
				if (formObj.msn_start_num.value.length < 4) {
					ComShowCodeMessage("COM130201", "MSN No.");
					formObj.msn_start_num.focus();
				}else {
					doActionIBSheet(sheetObject, formObj, COMMAND01);
				}
				break;
			case "btn_rlst_save":
				doActionIBSheet(sheetObject, formObj, COMMAND02);
				break;
		} // end switch
	}
	catch(e)
	{
		if( e == "[object Error]")
		{
			ComShowMessage(OBJECT_ERROR);
		}
		else
		{
			ComShowMessage(e);
		}
	}
}

/**
 * Sheet Click 이벤트 처리
 * @param Obj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnClick(Obj, Row, Col)
{
	var Obj1 = Obj;
	var Obj2 = sheetObjects[1];



	if( Obj1.ColSaveName(Col) =="sheet1_crs_chk_rmk"){

		ComShowMemoPad(sheetObjects[0], Row, Col, false, 200, 200);
	}

	if(Obj1.ColSaveName(Col) != "sheet1_sel") return;
	var colIndex1 = Obj1.SaveNameCol("sheet1_a_bkg_no");
	var colIndex2 = Obj2.SaveNameCol("sheet2_bkg_no");
	var updIndex1 = Obj1.SaveNameCol("sheet1_ibflag");
	var updIndex2 = Obj2.SaveNameCol("sheet2_ibflag");


	if(Obj1.CellValue(Row, Col) == 1)
	{
		var text = Obj1.CellValue(Row, colIndex1);
		for(var i=1;i<=Obj2.RowCount;i++)
		{
			if(Obj2.CellValue(i, colIndex2) == text)
			{
				var SelIndex = Obj2.SaveNameCol("sheet2_sel");
				Obj2.CellValue(i, SelIndex) = 0;
				Obj2.CellValue(i, updIndex2) = "";
			}
		}
	}
	else
	{
		var text = Obj1.CellValue(Row, colIndex1);
		for(var i=1;i<=Obj2.RowCount;i++)
		{
			if(Obj2.CellValue(i, colIndex2) == text)
			{
				var SelIndex = Obj2.SaveNameCol("sheet2_sel");
				Obj2.CellValue(i, SelIndex) = 1;
				Obj2.CellValue(i, updIndex2) = "U";
			}
		}
	}

}


 /**
  * Sheet Click 이벤트 처리
  * @param Obj
  * @param Row
  * @param Col
  * @return
  */
 function sheet4_OnClick(Obj, Row, Col)
 {
 	var Obj1 = Obj;
 	var Obj2 = sheetObjects[3];



 	if( Obj1.ColSaveName(Col) =="sheet4_cstms_rmk1"){

 		ComShowMemoPad(sheetObjects[3], Row, Col, false, 200, 200);

 		var colIndex2 = sheetObjects[3].SaveNameCol("sheet4_rmk_bkg_no");
 	 	var updIndex1 = sheetObjects[3].SaveNameCol("sheet4_ibflag");

	 	 	if(sheetObjects[3].CellValue(Row, colIndex2) == ""){
	 	 		sheetObjects[3].CellValue(Row, updIndex1) = "I";
	 	 	}

 	}




 }

/**************************************************************************************************
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 **************************************************************************************************/
function setSheetObject(sheet_obj)
{
   sheetObjects[sheetCnt++] = sheet_obj;
}
 /**
  * 콤보 초기설정값
  * @param {IBMultiCombo} comboObj  comboObj
  */
  function initCombo(comboObj) {
  	comboObj.MultiSelect = false;
//  	comboObj.UseCode = true;
  	comboObj.LineColor = "#ffffff";
  	comboObj.SetColAlign("left|left");
  	comboObj.MultiSeparator = "|";
  }
 /**
  * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
  * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
  **/
  function setComboObject(combo_obj){
    comboObjects[comboCnt++] = combo_obj;
  }

/**************************************************************************************************
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 **************************************************************************************************/
function loadPage()
{
	var form = document.form;

	for(i=0;i<sheetObjects.length;i++)
	{
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i], i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}

//	 IBMultiCombo초기화
    for(var j=0; j<comboObjects.length; j++){
        initCombo(comboObjects[j]);
    }

	with(form.correction)
	{
        var i=0;
        MultiSelect = true;
        InsertItem(i++, "All", "01");
        InsertItem(i++, "NO", "02");
        InsertItem(i++, "YES I - B/L 추가", "I");
        InsertItem(i++, "YES X - B/L 삭제", "X");
        InsertItem(i++, "YES V - VVD 또는 Rout 변경", "V");
        InsertItem(i++, "YES U - Packages, Weight, E/L 정보변경", "U");
        Code="01";
    }

	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("Keypress","obj_KeyPress", form);
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	doActionIBSheet(sheetObjects[1],document.form,INIT);
}

/**
 * Sheet 의 Load 가 완료된 후 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	funcSetDownLoadOption(document.form, "bl");
	ComBtnDisable("btn_DataDL");
	if (document.form.strOfc_cd.value.substring(0,5)=="SELSC") {
		funcOnFocus('pod');
	} else {
    	funcOnFocus('pod');
    }
}

/**************************************************************************************************
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 **************************************************************************************************/
function initSheet(sheetObj,sheetNo)
{
	var cnt = 0;
	var sheetId = sheetObj.id;
	switch(sheetId)
	{
	case "sheet1":      //sheet1 init
		with(sheetObj)
		{
			style.height = 320;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			MergeSheet = msHeaderOnly;
			Editable = true;
			InitRowInfo(2, 1, 22, 100);

//			if (!crossChk) {
				var HeadTitle1 = " |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP|Customer Name||I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume||||||||";
				var HeadTitle2 = " |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP|BL_TP|Customer Name|Package|Package|Weight|Weight|Match|Pre VVD|||||||VVD|Bond Area|ETA|Dwell||||||||";
//			} else {
//				var HeadTitle1 = " |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP|Customer Name||I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume||||||||";
//				var HeadTitle2 = " |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|POL|POD|Package|Package|Weight|Weight|Result|Remark|N|A|N|A|N|A|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP|BL_TP|Customer Name|Package|Package|Weight|Weight|Match|Pre VVD|||||||VVD|Bond Area|ETA|Dwell||||||||";
//			}
			var headCount = ComCountHeadTitle(HeadTitle1);

			InitColumnInfo(headCount, 9, 0, true);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]dtHiddenStatus
			var prefix = "sheet1_";
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtData, 		30, daCenter,   true,   prefix + "errchk");
			InitDataProperty(0, cnt++ , dtHidden, 		30, daCenter,   true,   prefix + "hidden3");
			InitDataProperty(0, cnt++ , dtHidden, 		30, daCenter,   true,   prefix + "cntr_cnt");
			InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix + "a_bkg_no",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	prefix + "sel",			false,	"",  dfNone,		0,	true,true,  0, false, false);
			InitDataProperty(0, cnt++ , dtDataSeq,      40, daCenter,  	true,   prefix + "Seq",			false,  "",  dfNone,		0,  true, true, 0, false, false);
			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	prefix + "bl_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			100,daLeft,		true,	prefix + "bkg_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30, daCenter,	true,	prefix + "down_yn",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30, daCenter,	true,	prefix + "ro_chk",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		30, daCenter,	true,	prefix + "other_vvd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "msn",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	prefix + "correction",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "tp",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "fe",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "pol",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "pod",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	prefix + "pck_qty",		false,	"",  dfNullInteger,	0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			25,	daCenter,	true,	prefix + "pck_tp_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	prefix + "act_wgt",		false,	"",  dfNullFloat,	3,	false,true);
			InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	prefix + "wgt_ut_cd",	false,	"",  dfNone,		0,	false,true);
//			if (!crossChk) {
				InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	prefix + "meas_qty",	false,	"",  dfNullFloat,	3,	false,true);
				InitDataProperty(0, cnt++ , dtData,			35,	daCenter,	true,	prefix + "meas_ut_cd",	false,	"",  dfNone,		0,	false,true);
//			} else {
//				InitDataProperty(0, cnt++ , dtComboEdit,			70,	    daCenter,	true,	prefix + "crs_chk_rslt_flg",	false,	"",  dfNone,	3,	true, true);
//				InitDataProperty(0, cnt++ , dtData,			200,	daRight,	true,	prefix + "crs_chk_rmk",	        false,	"",  dfNone,	3,	false , true);
//				InitDataCombo(0, prefix + "crs_chk_rslt_flg", "Y|N", "Y|N");
//			}
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "shpr_n",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "shpr_a",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "cnee_n",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "cnee_a",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "ntfy_n",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "ntfy_a",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "cntr",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "bac",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "wh",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "desc_code",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "tr",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		30,	daCenter,	true,	prefix + "cm",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "bz",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "elno_a",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "elno_b",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			30,	daCenter,	true,	prefix + "sc",			false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "cust_type",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix + "bl_tp",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			250,daLeft,		true,	prefix + "cust_name",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	prefix + "pkg_value",	false,	"",  dfNullInteger,	0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			25,	daCenter,	true,	prefix + "pkg_code",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	prefix + "wgt_value",	false,	"",  dfNullFloat,	3,	false,true);
			InitDataProperty(0, cnt++ , dtData,			25,	daCenter,	true,	prefix + "wgt_code",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "match",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "pre_vvd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "ib_dmst_port_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "ib_mty_bkg_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "c_bl_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "ib_mty_bl_no",false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "ib_cstms_decl_tp_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "ib_trns_seq",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "ib_vvd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "bac_nm",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			120,daCenter,	true,	prefix + "ib_eta_dt",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "dwell_dt",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "pck_qty_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "pck_tp_cd_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "cntr_ttl_wgt_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "wgt_ut_cd_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "meas_qty_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "meas_ut_cd_chk",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		80,	daCenter,	true,	prefix + "dmst_port_cd",	false,	"",  dfNone,		0,	false,true);


			//카운트를 표시할 포지션 /0의 경우 비표시
			CountPosition = 0;
			SetmergeCell(0, 37, 2, 2);  // EL N/O
			SetmergeCell(0, 41, 2, 2);  // Customer Name

		}
		break;
	case "sheet2":
		with (sheetObj)
		{
			style.height = 0;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			MergeSheet = msHeaderOnly;
			Editable = true;

			InitRowInfo(1, 1, 15, 100);
			var HeadTitle1 = " ||Sel.|Seq.|BkgNo|TP|cntr_no|cntr_tpsz_cd|cntr_seal_no1|cntr_seal_no2|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|op_cntr_qty|cntr_vol_qty|bl_no";

			var headCount = ComCountHeadTitle(HeadTitle1);

			InitColumnInfo(headCount, 9, 0, true);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet2_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,		30,	daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtHidden, 		30, daCenter,   true,   prefix + "errchk");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	prefix + "sel",				false,	"",  dfNone,		0,	true,true,   0, false, false);
			InitDataProperty(0, cnt++ , dtSeq,			30,	daCenter,	true,	prefix + "Seq",				false,  "",  dfNone,	 	0,	false,false, 0, false, false);
			InitDataProperty(0, cnt++ , dtData,			130,daCenter,	true,	prefix + "bkg_no",			false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "tp_cd",			false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_no",			false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_tpsz_cd",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_seal_no1",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_seal_no2",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "pck_qty",			false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "pck_tp_cd",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_wgt",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "wgt_ut_cd",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "meas_qty",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "meas_ut_cd",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "op_cntr_qty",		false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cntr_vol_qty",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "bl_no",			false,	"",  dfNone,		0,	true,true);
		}
		break;
	case "sheet3":
		with (sheetObj)
		{
			style.height = 0;
			SheetWidth = mainTable.clientWidth;
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			MergeSheet = msHeaderOnly;
			Editable = true;

			InitRowInfo(1, 1, 15, 100);
			var HeadTitle1 = "|Sel.|Seq";
			var headCount = ComCountHeadTitle(HeadTitle1);

			InitColumnInfo(headCount, 9, 0, true);
			InitHeadMode(true, true, true, true, false, false);
			InitHeadRow(0, HeadTitle1, true);
			var prefix = "sheet3_";
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtStatus,		30,	daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	prefix + "sel",				false,	"",  dfNone,		0,	true,true,   0, false, false);
		}
		break;

	case "sheet4":      //sheet4 init
	with(sheetObj)
	{
		style.height = 0;
		SheetWidth = mainTable.clientWidth;
		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		MergeSheet = msHeaderOnly;
		Editable = true;
		InitRowInfo(2, 1, 22, 100);


		var HeadTitle1 = " |||||Sel.|Seq.|B/L No.|SC|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Download|Download|Download|Download|Download|Download|Download|Remark|bkg_no|tp|fe|rmk_bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|port_cd|BL_TP|CNTR_CNT";
   		var HeadTitle2 = " |||||Sel.|Seq.|B/L No.|SC|POL|POD|Package|Package|Weight|Weight|Measure|Measure|E/L NO.|Package|Package|Weight|Weight|Measure|Measure|E/L NO.|Remark|bkg_no|tp|fe|rmk_bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|port_cd|BL_TP|CNTR_CNT";

   		var headCount = ComCountHeadTitle(HeadTitle1);

		InitColumnInfo(headCount, 8, 0, true);
		InitHeadMode(true, true, true, true, false, false);
		InitHeadRow(0, HeadTitle1, true);
		InitHeadRow(1, HeadTitle2, true);
		//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]dtHiddenStatus
		var prefix = "sheet4_";
		//dtHiddenStatus

			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	prefix + "ibflag");
			InitDataProperty(0, cnt++ , dtData, 		30, daCenter,   true,   prefix + "errchk");
			InitDataProperty(0, cnt++ , dtHidden, 		30, daCenter,   true,   prefix + "hidden3");
			InitDataProperty(0, cnt++ , dtHidden, 		30, daCenter,   true,   prefix + "cntr_cnt");
			InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix + "a_bkg_no",	false,	"",  dfNone,		0,	true,true);
			InitDataProperty(0, cnt++ , dtCheckBox,		40,	daCenter,	true,	prefix + "sel",			false,	"",  dfNone,		0,	true,true,  0, false, false);
			InitDataProperty(0, cnt++ , dtDataSeq,      40, daCenter,  	true,   prefix + "Seq",			false,  "",  dfNone,		0,  true, true, 0, false, false);
			InitDataProperty(0, cnt++ , dtData,			90,	daLeft,		true,	prefix + "bl_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			40,	daCenter,	true,	prefix + "sc",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	prefix + "pol_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	prefix + "pod_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,daRight,	true,	prefix + "pck_qty",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "pck_tp_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	true,	prefix + "act_wgt",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "wgt_ut_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			100,daRight,	true,	prefix + "meas_qty",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			50,	daCenter,	true,	prefix + "meas_ut_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix + "xpt_lic_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	true,	prefix + "dn_pck_qty",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,daCenter,	true,	prefix + "dn_pck_tp_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daRight,	true,	prefix + "cntr_ttl_wgt",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	prefix + "dn_wgt_ut_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,daRight,	true,	prefix + "dn_meas_qty",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			50,	daCenter,	true,	prefix + "bl_meas_ut_cd",	false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix + "dn_xpt_lic_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	prefix + "cstms_rmk1",		false,	"",  dfNone,		0,	false,false);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "bkg_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "tp",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "fe",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "rmk_bkg_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "vsl_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "skd_voy_no",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "skd_dir_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,			80,	daCenter,	true,	prefix + "port_cd",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix + "bl_tp",		false,	"",  dfNone,		0,	false,true);
			InitDataProperty(0, cnt++ , dtHidden,		0,	daRight,	true,	prefix + "cntr_cnt",		false,	"",  dfNone,		0,	false,true);

		//카운트를 표시할 포지션 /0의 경우 비표시
		CountPosition = 0;
//		SetmergeCell(0, 37, 2, 2);  // EL N/O
//		SetmergeCell(0, 41, 2, 2);  // Customer Name


	break;
  }

	}
}


/**************************************************************************************************
 * Sheet관련 프로세스 처리
 **************************************************************************************************/
function doActionIBSheet(sheetObj,formObj,sAction)
{
	sheetObj.ShowDebugMsg = false;

	var ret = ComGetPrefixParam("sheet1_");
	var aryPrefix = new Array("sheet1_", "sheet2_");
	var ret1 = ComGetPrefixParam("sheet4_");
	ret = ComGetPrefixParam(aryPrefix);
    //ret1 = ComGetPrefixParam(aryPrefix);

	switch(sAction)
	{
		case INIT:      //Default
			formObj.f_cmd.value = INIT;
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1329GS.do", FormQueryString(formObj));
			var arrXml = sXml.split("|$$|");
			ComOpenWait(false);
			ComXml2ComboItem(arrXml[0], formObj.sc, "val", "val|desc");
			ComSetObjValue(formObj.sc, "A");
			break;
		case SEARCH:      //조회

		if (!crossChk) {
			formObj.f_cmd.value = SEARCH;
			formObj.mrn_nbr.value = '';
			formObj.mrn_chk_no.value = '';
			if(funcSelectValidate(formObj) == true)
			{
				formObj.eta_etd.value="";
				formObj.etb_dt.value="";
				if (formObj.bl_bkg_tp.value=="BKG") {
					formObj.in_bkg_no.value = formObj.bl_bkg_no.value;
					formObj.in_blno.value ="";
				}else {
					formObj.in_blno.value = formObj.bl_bkg_no.value;
					formObj.in_bkg_no.value="";
				}
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1329GS.do", FormQueryString(formObj) + "&" + ret);
				var arrXml = sXml.split("|$$|");
				//initsheet 불러오기 (Measure 항목을 result와 remark로 나누도록 )
				//if(form.rad_crscheck.checked){
//				sheetObjects[0].RemoveAll();
//				initSheet(sheetObj, 0);
				//}
				if(!formObj.rad_crscheck.checked){
					sheetObjects[0].style.height = 320;
					sheetObjects[3].style.height = 0;
				}else{
					sheetObjects[0].style.height = 0;
					sheetObjects[3].style.height = 320;
				}

				for(var i = 0; i < arrXml.length; i++)
				{

					sheetObjects[i].Redraw = false;
					if(i > 0)
					{
						sheetObjects[i].WaitImageVisible = false;
					}
					sheetObjects[i].LoadSearchXml(arrXml[i]);
					sheetObjects[i].CheckAll(aryPrefix[i]+"sel") = 1;
					funcShowValueRows();
				}

				sheetObjects[0].ColumnSort("sheet1_bl_no|sheet1_bkg_no", "DESC", "ASC|DESC", true);
				sheetObjects[1].ColumnSort("sheet2_cntr_no", "ASC");
				funcShowCheckError(sheetObj, formObj);
				sheetObj.Redraw = true;
				sheetObjects[1].Redraw = true;

				var mrn_no = sheetObj.EtcData('mrn_nbr');

				if(mrn_no.length < 10)
				{
					formObj.mrn_nbr.value = '';
					formObj.mrn_no.value = '';
					formObj.mrn_chk_no.value = '';
				}
				else
				{
					formObj.mrn_chk_no.value = sheetObj.EtcData('mrn_chk_no');
					formObj.mrn_no.value = mrn_no + sheetObj.EtcData('mrn_chk_no');
					formObj.mrn_nbr.value = sheetObj.EtcData('mrn_nbr');
				}

				var bd = sheetObj.EtcData('bl_dl');
				if(bd != 'bl' && bd != 'dl' && bd != 'mc'&& bd != 'cr')
				{
					if(formObj.rad_nodownlist.checked) bd = 'bl';
					else if(formObj.rad_downedlist.checked)  bd = 'dl'
					else if(formObj.rad_mftcheck.checked)  bd = 'mc'
					else bd = 'cr';
				}
				if (formObj.rad_ib.checked) {
					document.all.span_eta_etd.innerHTML="ETA";
				}else {
					document.all.span_eta_etd.innerHTML="ETD";
				}
				if (sheetObj.EtcData("eta_etd")) formObj.eta_etd.value = sheetObj.EtcData("eta_etd");
				if (sheetObj.EtcData("etb_dt")) formObj.etb_dt.value = sheetObj.EtcData("etb_dt");
				// MSN Save 버튼 처리
				if (formObj.in_pod.value=="KRPUS" && formObj.rad_ib.checked && bd=="dl") {
					formObj.msn_start_num.style.display="inline";
					document.all.tb_msn_save.style.display="inline";
				} else {
					formObj.msn_start_num.style.display="none";
					document.all.tb_msn_save.style.display="none";
				}
				// DL, RO 컬럼 처리
				if (formObj.rad_nodownlist.checked) {
					sheetObjects[0].ColHidden("sheet1_down_yn") = false;
					if (formObj.rad_ib.checked) {
						sheetObjects[0].ColHidden("sheet1_ro_chk") = true;
					} else {
						sheetObjects[0].ColHidden("sheet1_ro_chk") = false;
					}
				} else {
					sheetObjects[0].ColHidden("sheet1_down_yn") = true;
					sheetObjects[0].ColHidden("sheet1_ro_chk") = true;
				}

				funcSetDownLoadOption(formObj, bd);
				ComOpenWait(false);
			}
			updateSummary();
		}else{
			formObj.f_cmd.value = SEARCH04;
			formObj.mrn_nbr.value = '';
			formObj.mrn_chk_no.value = '';
			if(funcSelectValidate(formObj) == true)
			{
				formObj.eta_etd.value="";
				formObj.etb_dt.value="";
				if (formObj.bl_bkg_tp.value=="BKG") {
					formObj.in_bkg_no.value = formObj.bl_bkg_no.value;
					formObj.in_blno.value ="";
				}else {
					formObj.in_blno.value = formObj.bl_bkg_no.value;
					formObj.in_bkg_no.value="";
				}
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1329GS.do", FormQueryString(formObj) + "&" + ret1);
				var arrXml = sXml.split("|$$|");


				if(!formObj.rad_crscheck.checked){
					sheetObjects[0].style.height = 320;
					sheetObjects[3].style.height = 0;
				}else{
					sheetObjects[0].style.height = 0;
					sheetObjects[3].style.height = 320;
				}

				for(var i = 0; i < arrXml.length; i++)
				{
					//sheetObjects[3].Redraw = false;
					if(i > 0)
					{
						//sheetObjects[3].WaitImageVisible = false;
					}

					sheetObjects[3].LoadSearchXml(arrXml[i]);
//					funcShowValueRows();
				}
				if (ComGetEtcData(sXml, "eta_etd")) formObj.eta_etd.value = ComGetEtcData(sXml, "eta_etd");
				if (ComGetEtcData(sXml, "etb_dt")) formObj.etb_dt.value = ComGetEtcData(sXml, "etb_dt");

//				formObj.bl_local.value = ComGetEtcData(sXml, "bl_local");
//				formObj.bl_ts.value = ComGetEtcData(sXml, "bl_ts");
//				formObj.bl_empty.value = ComGetEtcData(sXml, "bl_empty");
//				formObj.bl_ts_empty.value = ComGetEtcData(sXml, "bl_ts_empty");
//				formObj.cntr_local.value = ComGetEtcData(sXml, "cntr_local");
//				formObj.cntr_ts.value = ComGetEtcData(sXml, "cntr_ts");
//				formObj.cntr_empty.value = ComGetEtcData(sXml, "cntr_empty");
//				formObj.cntr_ts_empty.value = ComGetEtcData(sXml, "cntr_ts_empty");
//				formObj.bl_total.value = ComGetEtcData(sXml, "bl_total");
//				formObj.cntr_total.value = ComGetEtcData(sXml, "cntr_total");

				var mrn_no = ComGetEtcData(sXml, "mrn_nbr");

				if(mrn_no.length < 10)
				{
					formObj.mrn_nbr.value = '';
					formObj.mrn_no.value = '';
					formObj.mrn_chk_no.value = '';
				}
				else
				{
					formObj.mrn_chk_no.value = ComGetEtcData(sXml, "mrn_chk_no");
					formObj.mrn_no.value = mrn_no + ComGetEtcData(sXml, "mrn_chk_no");
					formObj.mrn_nbr.value = mrn_no;
				}

				ComOpenWait(false);
			}
			updateSummary();
			funcShowValueRows();
		}
			break;

		case IBINSERT:      // B/L List DownLoad
			if(funcSelectValidate(formObj) == true)
			{
				ComOpenWait(true);
			    sheetObjects[0].WaitImageVisible = false;

				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel") + "&" +
				              ComGetSaveString(sheetObjects[1],true,false, "sheet2_sel");
			    if (sParam == "&") {
			    	ComShowCodeMessage('BKG00249');
			    	ComOpenWait(false);
				    sheetObjects[0].WaitImageVisible = true;
			    	return;
			    }

			    sParam += "&" + FormQueryString(formObj);
			    var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_1329GS.do", sParam);
			    var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			}
			break;

		case IBDELETE:
			if (ComShowCodeConfirm('BKG00535')) {
				var sParam = ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel") + "&" +
	              ComGetSaveString(sheetObjects[1],true,false, "sheet2_sel");
				  if (sParam == "&") {
				  	ComShowCodeMessage('BKG00249');
				  	return;
				  }
				formObj.f_cmd.value = REMOVE;
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1329GS.do", sParam + "&"+FormQueryString(formObj) + "&" + ret);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				var delCount = sheetObj.EtcData('delcount');
				doActionIBSheet(sheetObj, formObj, SEARCH);
			}
			break;

		case IBDOWNEXCEL:      // 엑셀 다운로드
		if (formObj.rad_crscheck.checked) {
		   sheetObjects[3].Down2Excel(-1, false, false, true, "", "", false, false, "", true, "sheet4_sel");
		}else{
		   sheetObj.Down2Excel(-1, false, false, true, "", "", false, false, "", true, "sheet1_sel");
		}
            break;
		case COMMAND01:		// MSN save
			if (ComShowCodeConfirm("BKG00824")) {
				ComOpenWait(true);
			    sheetObjects[0].WaitImageVisible = false;

				formObj.f_cmd.value = COMMAND01;
				var sParam = ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel");
			    if (sParam == "") {
			    	ComShowCodeMessage('BKG00249');
			    	ComOpenWait(false);
				    sheetObjects[0].WaitImageVisible = true;
			    	return;
			    }

			    sParam += "&in_vvd="+formObj.in_vvd.value+"&msn_start_num="+formObj.msn_start_num.value
			            + "&in_pod="+formObj.in_pod.value+"&f_cmd="+COMMAND01;
			    sheetObjects[2].RemoveAll();
			    sheetObjects[2].DataInsert(-1);
			    sheetObjects[2].DoSave("ESM_BKG_1329GS.do", sParam, -1, false);
			    var key = sheetObjects[2].EtcData("TRANS_RESULT_KEY");

			    // 저장 성공시 자동조회 처리
			    if (key=="S") doActionIBSheet(sheetObj, formObj, SEARCH);
			    ComOpenWait(false);
			}
			break;

		case COMMAND02:		// cross check Result, Remark save
		if (ComShowCodeConfirm("BKG00824")) {
			ComOpenWait(true);
		    sheetObjects[3].WaitImageVisible = false;

			formObj.f_cmd.value = COMMAND02;

//
//			var colIndex2 = sheetObjects[3].SaveNameCol("sheet4_rmk_bkg_no");
//		 	var updIndex1 = sheetObjects[3].SaveNameCol("sheet4_ibflag");
//
//
//
//		 		for(var i=1;i<=sheetObjects[3].RowCount;i++)
//		 		{
//		 			if(sheetObjects[3].CellValue(i, colIndex2) == "")
//		 			{
//		 				sheetObjects[3].CellValue(i, updIndex1) = "I";
//		 			}
////		 			else{
////
////		 				sheetObjects[3].CellValue(i, updIndex1) = "U";
////		 		}
//		 	    }


			if (sParam == "") {
		    	ComShowCodeMessage('BKG00249');
		    	ComOpenWait(false);
			    sheetObjects[3].WaitImageVisible = true;
		    	return;
		    }

			var sParam = "f_cmd="+COMMAND02;

		    sheetObjects[3].DoSave("ESM_BKG_1329GS.do", sParam, "sheet4_ibflag", false);
		    //alert("2:: " + sParam);

		    var key = sheetObjects[3].EtcData("TRANS_RESULT_KEY");

		    // 저장 성공시 자동조회 처리
		    if (formObj.rad_crscheck.checked) {
				crossChk = true;
			}
		    if (key=="S") doActionIBSheet(sheetObj, formObj, SEARCH);
		    ComOpenWait(false);
		}
		break;
	}
}

/**
 * Backend Job 처리 결과 조회에 따른 처리
 * @param sheetObj
 * @param sKey
 * @return
 */
function doActionValidationResult(sheetObj, sKey) {
	var formObj = document.form;
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1329GS.do?f_cmd=" + SEARCH03
			+ "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		// 성공메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		// sheet1, sheet2 다시 조회
		formObj.rad_downedlist.click();
	    doActionIBSheet(sheetObj, formObj, SEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**************************************************************************************************
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 **************************************************************************************************/
function validateForm(sheetObj,formObj,sAction)
{
    with(formObj)
    {
    }
    return true;
}

/**
 * FOCUS 처리
 * @param objName
 * @return
 */
function funcOnFocus(objName)
{
	var form = document.form;
	if(objName == 'pol')
	{
		funcSetBoundOption(form, 'out');
		form.in_pol.disabled=false;
		form.in_pol.className="input1";
		form.in_pod.disabled=true;
		form.in_pod.className="input2";
		form.in_hn.disabled =true;
		form.in_hn.className="input2";
		document.all.el_no1.style.display="inline";
		document.all.el_no2.style.display="inline";
		document.all.cgo_tp1.style.display="none";
		document.all.cgo_tp2.style.display="none";
	}
	else if(objName == 'pod')
	{
		funcSetBoundOption(form, 'in');
		form.in_pod.disabled=false;
		form.in_pod.className="input1";
		form.in_hn.disabled=false;
		form.in_hn.className="input";
//		form.in_pol.disabled=true;
//		form.in_pol.className="input2";
		document.all.el_no1.style.display="none";
		document.all.el_no2.style.display="none";
		document.all.cgo_tp1.style.display="inline";
		document.all.cgo_tp2.style.display="inline";
	}

	if (form.rad_ib.checked) {
		document.all.span_eta_etd.innerHTML="ETA";
	}else {
		document.all.span_eta_etd.innerHTML="ETD";
	}
	// MSN Save 버튼 처리
	if (form.in_pod.value=="KRPUS" && form.rad_ib.checked && !form.rad_nodownlist.checked && !form.rad_mftcheck.checked && !form.rad_crscheck.checked) {
		form.msn_start_num.style.display="inline";
		document.all.tb_msn_save.style.display="inline";
	} else {
		form.msn_start_num.style.display="none";
		document.all.tb_msn_save.style.display="none";
	}
	// ETB DT 처리
	if (form.rad_ob.checked && form.rad_downedlist.checked) {
		document.all.etb_td1.style.display="inline";
		document.all.etb_td2.style.display="inline";
	}else {
		document.all.etb_td1.style.display="none";
		document.all.etb_td2.style.display="none";
	}
}

/**************************************************************************************************
 * InBound, OutBound 별 조회 옵션 설정
 **************************************************************************************************/
function funcSetBoundOption(formObj, op)
{
	if(op == 'out')
	{
		if(cur_pol_pod == 'pod') cur_pol_pod = 'pol';
		formObj.in_pod.value = "";
		formObj.rad_ib.checked = false;
		formObj.rad_ob.checked = true;
		formObj.in_bound.value = 'O';
		formObj.in_pol.className = "input1";
		formObj.in_pod.className = "input";
		// Type 종류 - A,B,C,D
		var in_select = document.getElementById("sel_type");

		// option 항목을 삭제
		if(in_select.childNodes.length != 4) {
			for(var i=0; i<in_select.childNodes.length; i++){
				if(in_select.childNodes[i].nodeName == "OPTION"){
					in_select.childNodes[i].removeNode();
				}
			}
		}

		// Inbound용 option 항목을 추가
		var optionList = ["A : 미주 Local","B : 아/구주 Local","C : T/S","D : A+B+C+M","M : eMpty Local"," "];
		var valueList  = ["A","B","C","D","M"," "];
		for(var i=0; i<optionList.length; i++){
			in_select.options[i] =new Option(optionList[i], valueList[i]);
		}

		formObj.sel_type.value='A';
		formObj.sel_type.className = "input";
		formObj.sel_type.disabled = false;
	}
	else if(op == 'in')
	{
		if(cur_pol_pod == 'pol') cur_pol_pod = 'pod';
//		formObj.in_pol.value = "";
//		formObj.in_pol.className = "input";
		formObj.in_pod.className = "input1";
		formObj.rad_ib.checked = true;
//		formObj.rad_ob.checked = false;
		formObj.in_bound.value = 'I';
		// Type 종류 - A,Blank
		var in_select = document.getElementById("sel_type");

		// option 항목을 삭제
		for(var i=0; i<in_select.childNodes.length; i++){
			if(in_select.childNodes[i].nodeName == "OPTION"){
				in_select.childNodes[i].removeNode();
			}
		}

		// Inbound용 option 항목을 추가[blank, A, M]
		var optionList = [" ","A : Local","M : eMpty Local"];
		var valueList  = [" ","A","M"];
		for(var i=0; i<optionList.length; i++){
			in_select.options[i] = new Option(optionList[i], valueList[i]);
			if(i==0){
				in_select.options[i].selected = true;
			}
		}

		formObj.sel_type.className = "input";
		formObj.sel_type.disabled = false;
	}
}

/**************************************************************************************************
 * DownLoad대상 조회, Transmit대상 조회 옵션설정
 **************************************************************************************************/
function funcSetDownLoadOption(formObj, op)
{
	if(op == 'bl')
	{
		formObj.rad_nodownlist.checked = true;
		formObj.rad_downedlist.checked = false;
		formObj.rad_mftcheck.checked = false;
		formObj.rad_crscheck.checked = false;

		ComBtnDisable("btn_Delete");
		ComBtnDisable("btn_AddBL");
		ComBtnDisable("btn_EditBL");
		ComBtnDisable("btn_Transmission");
		ComBtnEnable("btn_DataDL");
	}
	else if(op == 'dl')
	{
		formObj.rad_nodownlist.checked = false;
		formObj.rad_downedlist.checked = true;
		formObj.rad_mftcheck.checked = false;
		formObj.rad_crscheck.checked = false;

		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_AddBL");
		ComBtnEnable("btn_EditBL");
		ComBtnEnable("btn_Transmission");
		ComBtnDisable("btn_DataDL");
	}
	else if(op == 'mc')
	{
		formObj.rad_nodownlist.checked = false;
		formObj.rad_downedlist.checked = false;
		formObj.rad_mftcheck.checked = true;
		formObj.rad_crscheck.checked = false;

		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_AddBL");
		ComBtnEnable("btn_EditBL");
		ComBtnEnable("btn_Transmission");
		ComBtnDisable("btn_DataDL");
	}
	else if(op == 'cr')
	{
		formObj.rad_nodownlist.checked = false;
		formObj.rad_downedlist.checked = false;
		formObj.rad_mftcheck.checked = false;
		formObj.rad_crscheck.checked = true;

		ComBtnEnable("btn_Delete");
		ComBtnEnable("btn_AddBL");
		ComBtnEnable("btn_EditBL");
		ComBtnEnable("btn_Transmission");
		ComBtnDisable("btn_DataDL");
	}
	formObj.bl_dl.value = op;
}

/**
 * 선택값에 대한 검증 처리
 * @param formObj
 * @return
 */
function funcSelectValidate(formObj)
{
	if(formObj.in_bound.value == 'I')
	{
		var in_vvd = formObj.in_vvd.value;
		var in_pod = formObj.in_pod.value;
		var in_hn  = formObj.in_hn.value;

		if (in_vvd.length != 9)
		{
			ComShowCodeMessage("BKG00566");
			formObj.in_vvd.focus();
   			return false;
		}

		if (in_pod.length != 5)
		{
			ComShowCodeMessage("COM12114", "POD");
			formObj.in_pod.focus();
   			return false;
		}

		formObj.in_pod_tmnl.value = in_pod + in_hn;
	}
	else if(formObj.in_bound.value == 'O')
	{
		var in_vvd = formObj.in_vvd.value;
		var in_pol = formObj.in_pol.value;
		var in_type = formObj.sel_type.value;

		if (in_vvd.length != 9)
		{
			ComShowCodeMessage("BKG00566");
			formObj.in_vvd.focus();
   			return false;
		}

		if (in_pol.length != 5)
		{
			ComShowCodeMessage("COM12114", "POL");
			formObj.in_pol.focus();
   			return false;
		}

		if (in_type != "A" && in_type != "B" && in_type != "C" && in_type != "D" && in_type != "M")
		{
			ComShowCodeMessage("COM12114", "TYPE");
   			return false;
		}
		formObj.in_pod_tmnl.value = '';
	}
	else
	{
		ComShowCodeMessage("COM12114", "BND");
		return false;
	}

	return true;
}

/**************************************************************************************************
 * IBSheet 내용을 특정 데이타만 걸러내서 보여주기
 * @param sheetObj : IBSheetName
 *        flagName : IBSheet에서 Show,Hidden여부를 판단할 대상필드명
 *        hiddenValue : IBSheet에서 Hidden여부를 결정지을 값
 * @return void
 **************************************************************************************************/
function funcShowValueRows()
{
	var formObj = document.form;

	if ( formObj.rad_crscheck.checked ){
		var sheetObj = sheetObjects[3];

		if( ViewOptionBlType == ''  )
		{
			for(var i=2;i < sheetObj.RowCount + 2; i++)
			{
				sheetObj.RowHidden(i) = false;
			}
		}
		else
		{
			for(var i=2;i <= sheetObj.RowCount + 2; i++)
			{
				if(ViewOptionBlType != '')
				{
					if (sheetObj.CellValue(i, "sheet4_bl_tp") != ViewOptionBlType) {
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}
			}
		}

	} else {
		var sheetObj = sheetObjects[0];
		var ColEr = sheetObj.SaveNameCol("sheet1_errchk");
		var ColBl = sheetObj.SaveNameCol("sheet1_sc");
		var ColEl = sheetObj.SaveNameCol("sheet1_elno_a");
		var ColCr = sheetObj.SaveNameCol("sheet1_correction");
		var ColCntr = sheetObj.SaveNameCol("sheet1_cntr");
		var ColEl = sheetObj.SaveNameCol("sheet1_elno_a");
		var ColTp = sheetObj.SaveNameCol("sheet1_tp");

		if(ViewOptionErrCheck == '' && ViewOptionBlType == '' && ViewOptionElNo == '' && (ViewOptionCorrection == '' || ViewOptionCorrection == '01') && ViewOptionCargoType == '' )
		{
			for(var i=2;i < sheetObj.RowCount + 2; i++)
			{
				sheetObj.RowHidden(i) = false;
			}
		}
		else
		{
			for(var i=2;i <= sheetObj.RowCount + 2; i++)
			{
				if(ViewOptionErrCheck != '')
				{
					if(ViewOptionErrCheck != sheetObj.CellValue(i, ColEr))
					{
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}

				if(ViewOptionBlType != '')
				{
					if (sheetObj.CellValue(i, "sheet1_bl_tp") != ViewOptionBlType) {
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}

				if(ViewOptionElNo != '')
				{
					if(ViewOptionElNo != sheetObj.CellValue(i, ColEl))
					{
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}

				if(ViewOptionCargoType != '')
				{
					if(ViewOptionCargoType != sheetObj.CellValue(i, ColTp))
					{
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}

				if(sheetObj.CellValue(i,ColCr)!=null && ViewOptionCorrection != '' && ViewOptionCorrection != '01')
				{
					var vocArray = ViewOptionCorrection.split(",");
					var vocCheck = false;
					for(var j=0; j < vocArray.length; j++) {

						if (vocArray[j] == "01") {
							vocCheck = true;
							break;
						} else if (vocArray[j] == "02" && sheetObj.CellValue(i,ColCr).trim().length < 1) {
							vocCheck = true;
							break;
						}else if (vocArray[j] == sheetObj.CellValue(i, ColCr).trim()) {
							vocCheck = true;
							break;
						}

					}

					if (vocCheck == false) {
						sheetObj.RowHidden(i) = true;
						continue;
					}
				}

				sheetObj.RowHidden(i) = false;

			}
		}
	}

	updateSummary();
}

/**
 * 전체 ROW 보이기
 * @param sheetObj
 * @return
 */
function funcShowAllRows(sheetObj)
{
	for(var i=0; i<=IndexTop; i++)
	{
		sheetObj.RowHidden(hiddenIndex[i]) = false;
	}
	IndexTop = 0;
	updateSummary();
}

/**
 * 에러 표시 처리
 * @param sheetObj
 * @param formObj
 * @return
 */
function funcShowCheckError(sheetObj, formObj)
{
	var prefix="sheet1_";
	for(var i=2;i < sheetObj.RowCount + 2;i++)
	{
		if(sheetObj.CellValue(i, prefix+"errchk") == "E") sheetObj.CellFontColor(i, prefix + "bl_no" ) = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"shpr_n") == "N") sheetObj.CellFontColor(i, prefix + "shpr_n") = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"shpr_a") == "N") sheetObj.CellFontColor(i, prefix + "shpr_a") = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"cnee_n") == "N") sheetObj.CellFontColor(i, prefix + "cnee_n") = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"cnee_a") == "N") sheetObj.CellFontColor(i, prefix + "cnee_a") = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"cntr") == "0"  ) sheetObj.CellFontColor(i, prefix + "cntr"  ) = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"desc_code") == "N"  ) sheetObj.CellFontColor(i, prefix + "desc_code"  ) = sheetObj.RgbColor(255, 0, 0);
		if(sheetObj.CellValue(i, prefix+"bz") == "N"  ) sheetObj.CellFontColor(i, prefix + "bz"  ) = sheetObj.RgbColor(255, 0, 0);

		// INBOUND 시
		if (formObj.in_bound.value=="I") {
			if(sheetObj.CellValue(i, prefix+"bac") == "N"  ) sheetObj.CellFontColor(i, prefix + "bac") = sheetObj.RgbColor(255, 0, 0);
			if(sheetObj.CellValue(i, prefix+"wh") == "N"   ) sheetObj.CellFontColor(i, prefix + "wh" ) = sheetObj.RgbColor(255, 0, 0);
		}else {
			// OUT BOUND시
			if(sheetObj.CellValue(i, prefix+"elno_a") == "Y" && sheetObj.CellValue(i, prefix+"elno_b") == "U") {
				sheetObj.CellFontColor(i, prefix + "elno_a" ) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix + "elno_b" ) = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(i, prefix+"sc") == "S" && sheetObj.CellValue(i, prefix+"elno_a") == "N") sheetObj.CellFontColor(i, prefix + "elno_a" ) = sheetObj.RgbColor(255, 0, 0);
			if(sheetObj.CellValue(i, prefix+"sc") == "S" && sheetObj.CellValue(i, prefix+"elno_b") == "N") sheetObj.CellFontColor(i, prefix + "elno_b" ) = sheetObj.RgbColor(255, 0, 0);
			if(sheetObj.CellValue(i, prefix+"match") == "N") sheetObj.CellFontColor(i, prefix + "match" ) = sheetObj.RgbColor(255, 0, 0);
		}

		if (formObj.bl_dl.value=="mc") {
			if(sheetObj.CellValue(i, prefix+"pck_qty_chk") == "Y" || sheetObj.CellValue(i, prefix+"pck_tp_cd_chk") == "Y") {
				sheetObj.CellFontColor(i, prefix + "pck_qty" ) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix + "pck_tp_cd" ) = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(i, prefix+"cntr_ttl_wgt_chk") == "Y" || sheetObj.CellValue(i, prefix+"wgt_ut_cd_chk") == "Y") {
				sheetObj.CellFontColor(i, prefix + "act_wgt" ) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix + "wgt_ut_cd" ) = sheetObj.RgbColor(255, 0, 0);
			}
			if(sheetObj.CellValue(i, prefix+"meas_qty_chk") == "Y" || sheetObj.CellValue(i, prefix+"meas_ut_cd_chk") == "Y") {
				sheetObj.CellFontColor(i, prefix + "meas_qty" ) = sheetObj.RgbColor(255, 0, 0);
				sheetObj.CellFontColor(i, prefix + "meas_ut_cd" ) = sheetObj.RgbColor(255, 0, 0);
			}
		}
	}
}

/**
 * BL TYPE 변경처리
 * @param obj
 * @return
 */
function funcBlTypeOnChange(obj)
{
	ViewOptionBlType = obj.value;
	funcShowValueRows();
}

/**
 * EL No 변경 처리
 * @param obj
 * @return
 */
function funcElTypeOnChange(obj)
{
	ViewOptionElNo = obj.value;
	funcShowValueRows();
}

/**
 * Correction 변경 처리
 * @param obj
 * @return
 */
function correction_OnChange(comboObj, val, text)
{
	ViewOptionCorrection = val;
	funcShowValueRows();
}

 /**
  * Cargo Type 변경 처리
  * @param obj
  * @return
  */
 function funcCargoTypeOnChange(obj)
 {
 	ViewOptionCargoType = obj.value;
 	funcShowValueRows();
 }

/**
 * 초기화 처리
 * @param sheetObjects
 * @param formObj
 * @return
 */
function funcClearAll(sheetObjects, formObj)
{
	var len = sheetObjects.length;
	if(isNaN(len))
	{
		var sheetObj = sheetObjects;
		sheetObj.RemoveAll();
	}
	else
	{
		for(var i=0;i<len;i++)
		{
			sheetObj = sheetObjects[i];
			sheetObj.RemoveAll();
		}
	}

	formObj.mrn_nbr.value = '';
	formObj.in_vvd.value = '';
	formObj.in_pol.value = '';
	formObj.in_pod.value = '';
	formObj.in_blno.value = '';
	formObj.in_hn.value = '';
	formObj.correction.Code="01";
	formObj.correction.Text="All";
}

/**
 * BL ADD & EDIT POP-UP 처리
 * @param mode
 * @return
 */
function funcBlAddnEditPopup(mode)
{
	thisRow = sheetObjects[0].SelectRow;
	if (thisRow < 2) thisRow = 2;
	var formObj = document.form;
	var params = "?io_bnd_cd=" + formObj.in_bound.value +
				 "&mrn_no=" + formObj.mrn_no.value +
				 "&mode="+mode + "&vvd=" + formObj.in_vvd.value +
				 "&cstms_decl_tp_cd="+sheetObjects[0].CellValue(thisRow, "sheet1_tp");
	if (formObj.in_hn.value.trim()!="") params = params + "&pod_tml_cd="+formObj.in_pod.value+formObj.in_hn.value;
	if (mode=="EDIT") {
		params = params + "&bl_no=" + sheetObjects[0].CellValue(thisRow, "sheet1_bl_no");
	}
	if (formObj.in_bound.value=="I") {
		if (formObj.in_pod.value==sheetObjects[0].CellValue(thisRow, "sheet1_pod")) params = params + "&cgo_spec_clear=Y";
	}
	var port_cd = formObj.in_pol.value;
	if (port_cd=='') port_cd = formObj.in_pod.value;

	params = params + "&port_cd="+port_cd+"&pgmNo=ESM_BKG_0505";
	ComOpenWindowCenter("/hanjin/ESM_BKG_0505.do"+params, "ESM_BKG_0505", 1024, 610);
}

/**
 * 전체 선택 처리
 * @param sheetObj1
 * @param ColName1
 * @param sheetObj2
 * @param ColName2
 * @param op
 * @return
 */
function funcSelectAll(sheetObj1, ColName1, sheetObj2, ColName2, op)
{
	var updIndex1 = sheetObj1.SaveNameCol("sheet1_ibflag");
	var updIndex2 = sheetObj2.SaveNameCol("sheet2_ibflag");
	var SelIndex1 = sheetObj1.SaveNameCol(ColName1);
	var SelIndex2 = sheetObj2.SaveNameCol(ColName2);

	if(op)
	{
		for(var i=2;i < sheetObj1.RowCount + 2; i++)
		{
			sheetObj1.CellValue(i, SelIndex1) = 1;
			sheetObj1.CellValue(i, updIndex1) = "U";
		}

		for(var i=1;i < sheetObj2.RowCount + 1; i++)
		{
			sheetObj2.CellValue(i, SelIndex2) = 1;
			sheetObj2.CellValue(i, updIndex2) = "U";
		}
	}
	else
	{
		for(var i=2;i < sheetObj1.RowCount + 2; i++)
		{
			sheetObj1.CellValue(i, SelIndex1) = 0;
			sheetObj1.CellValue(i, updIndex1) = "";
		}

		for(var i=1;i < sheetObj2.RowCount + 1; i++)
		{
			sheetObj2.CellValue(i, SelIndex2) = 0;
			sheetObj2.CellValue(i, updIndex2) = "";
		}
	}
}

/**
 * Sheet1 의 마우스 클릭 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseDown(Button, Shift, X, Y) {
	// 헤더 클릭시 처리 (전체 선택/해제)
	if (sheetObjects[0].MouseCol==5) {
		if (sheetObjects[0].MouseRow < 2 && sheetObjects[0].MouseRow > -1) {
			if (sheetObjects[0].RowCount > 2) {
				if (sheetObjects[0].CellValue(2,"sheet1_sel")==0) {
					// 전체 선택처리
					sheetObjects[1].CheckAll("sheet2_sel") = 1;
				}else {
					// 전체 선택해제 처리
					sheetObjects[1].CheckAll("sheet2_sel") = 0;
				}
			}
		}
	}
}

/**
 * 하단 통계부분 재계산
 * @return
 */
function updateSummary() {

	var formObj = document.form;

	var bl_local = 0, bl_ts =0, bl_empty = 0, bl_ts_empty = 0;
	var cntr_local = 0, cntr_ts = 0, cntr_empty = 0, cntr_ts_empty = 0;
	var prev_cntr_no, cntrRow;

	if ( formObj.rad_crscheck.checked ){

		var prefix="sheet4_";
		var sheetObj = sheetObjects[3];

		// 루프돌며 계산
		for(var i=2; i < sheetObj.RowCount+2; i++) {

			// HIDDEN 은 패스~
			if (sheetObj.RowHidden(i)) continue;

			if ( sheetObj.CellValue(i, prefix+"bkg_no") != sheetObj.CellValue(i-1, prefix+"bkg_no")){
				// EMPTY 체크 ( KCD_TP 가 T 인경우만 EMPTY 로 )
				if ( (sheetObj.CellValue(i, prefix+"fe")=="P" || sheetObj.CellValue(i, prefix+"fe")=="R") && (sheetObj.CellValue(i, prefix+"tp")!="T" && sheetObj.CellValue(i, prefix+"tp")!="R") ) {

					bl_empty++;
					cntr_empty = cntr_empty + eval(sheetObj.CellValue(i, prefix+"cntr_cnt"));
					sheetObj.CellValue(i, prefix+"bl_tp") = "E";

				}else if (sheetObj.CellValue(i, prefix+"fe")=="P" && (sheetObj.CellValue(i, prefix+"tp")=="T" || sheetObj.CellValue(i, prefix+"tp")=="R") ) {
					// TS EMPTY 체크
					bl_ts_empty++;
					cntr_ts_empty = cntr_ts_empty + eval(sheetObj.CellValue(i, prefix+"cntr_cnt"));
					sheetObj.CellValue(i, prefix+"bl_tp")="M";

				}else {
					// EMPTY 가 아닌 경우 LOCAL / TS 구분
					if (sheetObj.CellValue(i, prefix+"tp")=="I" || sheetObj.CellValue(i, prefix+"tp")=="E") {
						// LOCAL
						bl_local++;
						cntr_local = cntr_local + eval(sheetObj.CellValue(i, prefix+"cntr_cnt"));
					}else {
						// TS
						bl_ts++;
						cntr_ts = cntr_ts + eval(sheetObj.CellValue(i, prefix+"cntr_cnt"));
					}
					sheetObj.CellValue(i, prefix+"bl_tp") = sheetObj.CellValue(i, prefix+"sc");
				}
			}
		}

	} else {
		var prefix="sheet1_";
		var sheetObj = sheetObjects[0];

		// 컨테이너 카운트를 위한 조건변수
		var cntr_find_field = "bkg_no";
		if (formObj.rad_downedlist.checked) cntr_find_field = "bl_no";

		// 루프돌며 계산
		for(var i=2; i < sheetObj.RowCount+2; i++) {

			// HIDDEN 은 패스~
			if (sheetObj.RowHidden(i)) continue;

			// EMPTY 체크 ( KCD_TP 가 T 인경우만 EMPTY 로 )
			if ( (sheetObj.CellValue(i, prefix+"fe")=="P" || sheetObj.CellValue(i, prefix+"fe")=="R") && (sheetObj.CellValue(i, prefix+"tp")!="T" && sheetObj.CellValue(i, prefix+"tp")!="R") ) {

				bl_empty++;
				sheetObj.CellValue(i, prefix+"bl_tp") = "E";

				// 컨테이너 정보 셋팅
				cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.CellValue(i, prefix+cntr_find_field));
				while(cntrRow > 0) {
					sheetObjects[1].CellValue(cntrRow, "sheet2_tp_cd") = "E";
					cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.CellValue(i, prefix+cntr_find_field), cntrRow+1 );
				}
			}else if (sheetObj.CellValue(i, prefix+"fe")=="P" && (sheetObj.CellValue(i, prefix+"tp")=="T" || sheetObj.CellValue(i, prefix+"tp")=="R") ) {
				// TS EMPTY 체크
				bl_ts_empty++;
				sheetObj.CellValue(i, prefix+"bl_tp")="M";

				cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.CellValue(i, prefix+cntr_find_field));
				while(cntrRow > 0) {
					sheetObjects[1].CellValue(cntrRow, "sheet2_tp_cd") = "M";
					cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.CellValue(i, prefix+cntr_find_field), cntrRow+1 );
				}

			}else {
				// EMPTY 가 아닌 경우 LOCAL / TS 구분
				if (sheetObj.CellValue(i, prefix+"tp")=="I" || sheetObj.CellValue(i, prefix+"tp")=="E") {
					// LOCAL
					bl_local++;

					// 컨테이너 정보 셋팅
					cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.CellValue(i, prefix+cntr_find_field));
					while(cntrRow > 0) {
						sheetObjects[1].CellValue(cntrRow, "sheet2_tp_cd") = "L";
						cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.CellValue(i, prefix+cntr_find_field), cntrRow+1 );
					}
				}else {
					// TS
					bl_ts++;
					// 컨테이너 정보 셋팅
					cntrRow = sheetObjects[1].FindText("sheet2_bkg_no", sheetObj.CellValue(i, prefix+"bkg_no"));
					while(cntrRow > 0) {
						sheetObjects[1].CellValue(cntrRow, "sheet2_tp_cd") = "T";
						cntrRow = sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.CellValue(i, prefix+cntr_find_field), cntrRow+1 );
					}
				}
				sheetObj.CellValue(i, prefix+"bl_tp") = sheetObj.CellValue(i, prefix+"sc");
			}

		}

		// 컨테이너 갯수 계산
		for(var i=1; i <= sheetObjects[1].RowCount; i++) {

			// BKG_NO 가 메인테이블에서 Hidden 이면 카운트하지 않음
			cntrRow = sheetObj.FindText("sheet1_bkg_no", sheetObjects[1].CellValue(i,"sheet2_bkg_no"));
			if (cntrRow > 0 && sheetObj.RowHidden(cntrRow) ) continue;

			if (prev_cntr_no != sheetObjects[1].CellValue(i, "sheet2_cntr_no")) {
				// 중복이 아니면 카운트
				if (sheetObjects[1].CellValue(i, "sheet2_tp_cd")=="E") cntr_empty++;
				if (sheetObjects[1].CellValue(i, "sheet2_tp_cd")=="L") cntr_local++;
				if (sheetObjects[1].CellValue(i, "sheet2_tp_cd")=="T") cntr_ts++;
				if (sheetObjects[1].CellValue(i, "sheet2_tp_cd")=="M") cntr_ts_empty++;
			}
			prev_cntr_no = sheetObjects[1].CellValue(i, "sheet2_cntr_no");
		}
	}

	// 계산결과 뿌려주기
	formObj.bl_local.value = bl_local;
	formObj.bl_ts.value = bl_ts;
	formObj.bl_empty.value = bl_empty;
	formObj.bl_ts_empty.value = bl_ts_empty;
	formObj.cntr_local.value = cntr_local;
	formObj.cntr_ts.value = cntr_ts;
	formObj.cntr_empty.value = cntr_empty;
	formObj.cntr_ts_empty.value = cntr_ts_empty;
	formObj.bl_total.value = bl_local + bl_ts + bl_empty + bl_ts_empty;
	formObj.cntr_total.value = cntr_local + cntr_ts + cntr_empty + cntr_ts_empty;

}

function addHiddenField(parentForm, fieldName, value)
{
	var x = document.createElement("input");
	x.type = "hidden";
	x.name = fieldName;
	x.value = value;
	parentForm.appendChild(x);
}
/**
* 조회조건 입력할 때 처리
*/
function obj_KeyUp() {
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	 var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}


}