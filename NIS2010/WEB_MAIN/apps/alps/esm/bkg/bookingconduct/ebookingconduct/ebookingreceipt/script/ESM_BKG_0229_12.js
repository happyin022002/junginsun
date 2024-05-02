/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0229_12.jsp
*@FileTitle : e-Booking & SI Process Detail(Break Bulk)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.20
*@LastModifier : KJY
*@LastVersion : 1.0
* 2013.05.20 KJY
* 1.0 Creation
===============================================================================
 History
 2013.05.20 KJY B.Bulk BKG 수용을 위한 홈페이지, ALPS 변경 요청
=========================================================*/
﻿
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author SM LINE
 */

/**
 * @extends
 * @class esm_bkg_0229_12 : esm_bkg_0229_12 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_12() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isCopy = "false";

var akPosition = 0;

var cntrTpsz_cd = "";
var cntrTpsz_id = "";

//var wgt_cd = "";
//var wgt_nm = "";

var wgt_cd = "KGS|LBS";
var wgt_nm = "KGS|LBS";


var prefix = "t12sheet1_";
var max_bb_cgo_seq = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case IBCLEAR:
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;
		case "btn_cancelcopydata":
			parent.document.form.breakBulkTabCancel.value = "Y";
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			isCopy = "false";
			top.isCopyAllRequested = false;
			break;
		case "btn_datacopytoalps":
			
			doSaveCopy();
			
			if (isCopy == "false") {
				dataCopy();
			}
			break;
		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);

	applyShortcut();
}

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;

	switch (sheetID) {
	case "sheet1":
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
			sheetObj.SheetWidth = 390;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "ibflag|bkg_no|bb_cgo_seq|cntr_no|cntr_tpsz_cd|cmdt_cd|dim_len|dim_wdt|dim_hgt|grs_wgt|wgt_ut_cd|pck_qty|pck_tp_cd|net_wgt|diff_rmk|max_bb_cgo_seq|ovr_fwrd_len|ovr_bkwd_len|ovr_hgt|ovr_lf_len|ovr_rt_len|ovr_void_slt_qty|in_ga_flg|cgo_dchg_sd_cd";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtStatus,30, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "bb_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_no");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cntr_tpsz_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "cmdt_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "dim_len", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "dim_wdt", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "dim_hgt", 	false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "grs_wgt", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "wgt_ut_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_qty", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "pck_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "net_wgt", 		false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "diff_rmk");
			sheetObj.InitDataProperty(0, cnt++, dtData, 	50, daCenter, true, "max_bb_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_fwrd_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_bkwd_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_hgt");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_lf_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_rt_len");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "ovr_void_slt_qty");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "in_ga_flg");
			sheetObj.InitDataProperty(0, cnt++, dtData,50, daCenter, true, "cgo_dchg_sd_cd");
			sheetObj.CountPosition = 0;
		//}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: //조회
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {

			var formObj2 = document.form2;

			for ( var i = 0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("dim_len") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("dim_wdt") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("dim_hgt") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
				if (formObj.elements[i].name.indexOf("grs_wgt") == 0)
					formObj.elements[i].value = makeComma(formObj.elements[i].value.replace(/,/g, ""));
				if (formObj.elements[i].name.indexOf("pck_qty") == 0)
					formObj.elements[i].value = ComAddComma(formObj.elements[i].value, "#,###");
			}
			for ( var j = 0; j < formObj2.elements.length; j++) {
				if (formObj2.elements[j].name.indexOf("dim_len") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("dim_wdt") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("dim_hgt") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");
				if (formObj2.elements[j].name.indexOf("grs_wgt") == 0)
					formObj2.elements[j].value = makeComma(formObj2.elements[j].value.replace(/,/g, ""));
				if (formObj2.elements[j].name.indexOf("pck_qty") == 0)
					formObj2.elements[j].value = ComAddComma(formObj2.elements[j].value, "#,###");;
			}
			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			for ( var i = 0; i < arrXml.length; i++) {
				sheetObjects[i].Redraw = false;
				if (i > 0) {
					sheetObjects[i].WaitImageVisible = false;
				}
				sheetObjects[i].LoadSearchXml(arrXml[i]);
				sheetObjects[i].Redraw = true;
			}
		}
	
		for(var i=1;i<sheetObjects[0].Rows;i++){
			if(max_bb_cgo_seq<parseInt(sheetObjects[0].CellValue(i, "bb_cgo_seq"))){
				max_bb_cgo_seq = parseInt(sheetObjects[0].CellValue(i, "bb_cgo_seq"));
			}
		}
		
		if(parent.document.form.breakBulkTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			parent.document.form.breakBulkTabCancel.value = "N";
		}
		if(top.document.form.tabload12.value == "COPY"){
			dataCopy();
		} else {
			compareItem();			
		}

		if(parent.frames("t1frame").document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoalps");
		}
		
		top.document.form.tabload12.value = "LOAD";
		break;

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_12.do";
		formObj.submit();
		parent.tabObjects[0].TabBackColor(9) = "#96c792";
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		
		// DHTML 테이블 생성
		var ins_tables = document.getElementById("INS_TABLES");
		ins_tables.innerHTML = "";
		var insTableDiv = "";

		var maxSeq = 0;
		for ( var k = 0; k < formObj.elements.length; k++) {
			if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
				if (formObj.elements[k].value > maxSeq)
					maxSeq = formObj.elements[k].value;
			}
		}

		// 컨테이너 비교
		var formObj2 = document.form2;
		var obj = null;
		var objNm = null;
		var objVal = null;
		var obj2 = null;
		var objNm2 = null;
		var objVal2 = null;

		var isInsert = "false";

		if (maxSeq > 0) {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "bb_cgo_seq") {
						for ( var j = 0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								objVal2 = formObj.elements[j].value;
								if (objNm2 == "bb_cgo_seq") {
									if (objVal == objVal2) {
										isInsert = "false";
										break;
									} else {
										isInsert = "true";
									}
								}
							}
						}
						if (isInsert == "true") {
							maxSeq++;
							var insTableDiv = createTable(maxSeq);
							ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
							createBbCargo(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							updateBbCargo(obj2[1], obj[1]);
						}
					}
					

				}
			}
		} else {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if ((formObj2.elements[i].name).indexOf("__") > 0) {
					
					
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "bb_cgo_seq") {
						maxSeq++;
						var insTableDiv = createTable(maxSeq);
						ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
						createBbCargo(maxSeq, obj[1]);
					}
				}
			}
		}
		
//		if (maxSeq > 0) {
//			for ( var i = 0; i < formObj2.elements.length; i++) {
//				if ((formObj2.elements[i].name).indexOf("__") > 0) {
//					obj = (formObj2.elements[i].name).split("__");
//					objNm = obj[0];
//					objVal = formObj2.elements[i].value;
//					if (objNm == "cntr_no") {
//						for ( var j = 0; j < formObj.elements.length; j++) {
//							if ((formObj.elements[j].name).indexOf("__") > 0) {
//								obj2 = (formObj.elements[j].name).split("__");
//								objNm2 = obj2[0];
//								objVal2 = formObj.elements[j].value;
//								if (objNm2 == "cntr_no") {
//									if (objVal == objVal2) {
//										isInsert = "false";
//										break;
//									} else {
//										isInsert = "true";
//									}
//								}
//							}
//						}
//						if (isInsert == "true") {
//							maxSeq++;
//							var insTableDiv = createTable(maxSeq);
//							ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
//							createBbCargo(maxSeq, obj[1]);
//						} else if (isInsert == "false") {
//							updateBbCargo(obj2[1], obj[1]);
//						}
//					}
//				}
//			}
//		} else {
//			for ( var i = 0; i < formObj2.elements.length; i++) {
//				if ((formObj2.elements[i].name).indexOf("__") > 0) {
//					obj = (formObj2.elements[i].name).split("__");
//					objNm = obj[0];
//					objVal = formObj2.elements[i].value;
//					if (objNm == "cntr_no") {
//						maxSeq++;
//						var insTableDiv = createTable(maxSeq);
//						ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
//						createBbCargo(maxSeq, obj[1]);
//					}
//				}
//			}
//		}

		parent.tabObjects[0].TabBackColor(9) = "#fff270";
		isCopy = "true";
		compareItem();
		initControl();
		break;
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		
		var params = getSaveStringForUpload();

		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_12GS.do", params);

		if(ComBkgErrMessage(sheetObjects[0], sXml)) {
			sheetObj.LoadSaveXml(sXml);
			// 에러없으면 다시 조회
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
 function validateForm(sheetObj, formObj, sAction) {
	for ( var i = 0; i < formObj.elements.length; i++) {
		if (formObj.elements[i].name.indexOf("cmdt_cd") == 0){
			if(haveOnlyNumber(formObj.elements[i].value)==false){
				ComShowCodeMessage("BKG00010");		
				ComSetFocus(formObj.elements[i]);
				return false;
			}
		}
	}
	if (!ComChkValid(formObj))
		return false;
	
	switch(sAction) {
	case IBSAVE:
		for(var i=0; i<formObj.elements.length; i++) {
			if ((formObj.elements[i].name).indexOf("__") > 0) {
				obj = (formObj.elements[i].name).split("__");
				objNm = obj[0];
				objSeq = obj[1]; // sheet상 row
				
				objVal = formObj.elements[i].value;

				if ( objNm == "cgo_dchg_sd_cd" ){
					if ( objVal == "" ){
						ComShowMessage(ComGetMsg("BKG00404","Disch.side","Disch.side"));
						return false;
					}
				}
			}
		}
	break;
	}
	
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * Validate 실패 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동
 * Focus 이동까지 한 후 return false
 */
function validateForUpload() {
	return validateForm(sheetObjects[0], document.form, IBSAVE);
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	// form 데이타를 sheet로 copy
	doSaveCopy();
	
	var params = "";	
	if (sheetObjects[0].RowCount>=1) {
		params = "f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), prefix);
		//alert(ComSetPrifix(sheetObjects[0].GetSaveString(true), prefix));
	}
	
//	al"ert("getSaveStringForUpload in ESM_BKG_0229_09.js params=[" + params + "]");
	return (params);
}

 /**
  * e-Booking Upload Copy 팝업에서 [OK]버튼 클릭시
  */
function dataCopy() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

function doSaveCopy(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var maxSeq = 0;

	for ( var k = 0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
			if (formObj.elements[k].value > maxSeq)
				maxSeq = formObj.elements[k].value;
		}
	}
	// [Data Copy to ALPS]에 의해 생긴 New 
	for (var i = sheetObj.RowCount; i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
	
	var obj		= null;
	var objNm	= null;
	var objSeq	= null;
	var objVal	= null;
	var cntrNo	= null;
	var ibflag	= null;
		
	//현재 화면의 ALPS Data를 sheet에 넣는다.
	for(var i=0; i<formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj = (formObj.elements[i].name).split("__");
			objNm = obj[0];
			objSeq = obj[1]; // sheet상 row
			
			objVal = formObj.elements[i].value;
			if (sheetObjects[0].CellValue(objSeq,"bkg_no") == "") {
				sheetObjects[0].CellValue2(objSeq,"bkg_no") = formObj.bkg_no.value;
			}
			if ( objNm == "bb_cgo_seq" )	sheetObjects[0].CellValue2(objSeq, "bb_cgo_seq")	= objVal;
//			if ( objNm == "cntr_no" )		sheetObjects[0].CellValue2(objSeq, "cntr_no") 		= ComTrimAll(objVal);
//			if ( objNm == "cntr_tpsz_cd" )	sheetObjects[0].CellValue2(objSeq, "cntr_tpsz_cd")	= objVal;
			if ( objNm == "cmdt_cd" )   	sheetObjects[0].CellValue2(objSeq, "cmdt_cd")		= objVal;
			if ( objNm == "dim_len" )	sheetObjects[0].CellValue2(objSeq, "dim_len")	= objVal;
			if ( objNm == "dim_wdt" )	sheetObjects[0].CellValue2(objSeq, "dim_wdt")	= objVal;
			if ( objNm == "dim_hgt" )	sheetObjects[0].CellValue2(objSeq, "dim_hgt")	= objVal;
			if ( objNm == "grs_wgt" ) 		sheetObjects[0].CellValue2(objSeq, "grs_wgt") 		= objVal;
			if ( objNm == "wgt_ut_cd" ) 	sheetObjects[0].CellValue2(objSeq, "wgt_ut_cd") 	= objVal;
			if ( objNm == "pck_qty" ) 		sheetObjects[0].CellValue2(objSeq, "pck_qty") 		= objVal;
			if ( objNm == "pck_tp_cd" ) 	sheetObjects[0].CellValue2(objSeq, "pck_tp_cd")		= objVal;
			if ( objNm == "net_wgt" ) 		sheetObjects[0].CellValue2(objSeq, "net_wgt")		= objVal;
			if ( objNm == "diff_rmk" )sheetObjects[0].CellValue2(objSeq, "diff_rmk")= objVal;

			if ( objNm == "cgo_dchg_sd_cd" )sheetObjects[0].CellValue2(objSeq, "cgo_dchg_sd_cd")= objVal;
		}
	}
}

function compareItem() {
	var obj = null;
	var objNm = null;
	var objVal = null;
	var obj2 = null;
	var objNm2 = null;
	var objVal2 = null;
	var formObj  = document.form;
	var formObj2 = document.form2;
	var sameSeq = "false";
	
//	bb_cgo_seq
	
	for ( var i = 0; i < formObj2.elements.length; i++) {
		if ((formObj2.elements[i].name).indexOf("__") > 0) {
			obj = (formObj2.elements[i].name).split("__");
			objNm = obj[0];
			objVal = formObj2.elements[i].value;
			if (objNm == "bb_cgo_seq") {
				for ( var j = 0; j < formObj.elements.length; j++) {
					if ((formObj.elements[j].name).indexOf("__") > 0) {
						obj2 = (formObj.elements[j].name).split("__");
						objNm2 = obj2[0];
						objVal2 = formObj.elements[j].value;

						if (objNm2 == "bb_cgo_seq") {
							if (objVal == objVal2) {
								sameSeq = "true";
								break;
							} else {
								sameSeq = "false";
							}
						}
					}
				}
				if (sameSeq == "true") {
					compareBbCgo(obj2[1], obj[1]);
				}
			}
		}
	}
	
//	for ( var i = 0; i < formObj2.elements.length; i++) {
//		if ((formObj2.elements[i].name).indexOf("__") > 0) {
//			obj = (formObj2.elements[i].name).split("__");
//			objNm = obj[0];
//			objVal = formObj2.elements[i].value;
//			if (objNm == "cntr_no") {
//				for ( var j = 0; j < formObj.elements.length; j++) {
//					if ((formObj.elements[j].name).indexOf("__") > 0) {
//						obj2 = (formObj.elements[j].name).split("__");
//						objNm2 = obj2[0];
//						objVal2 = formObj.elements[j].value;
//
//						if (objNm2 == "cntr_no") {
//							if (objVal == objVal2) {
//								sameCntr = "true";
//								break;
//							} else {
//								sameCntr = "false";
//							}
//						}
//					}
//				}
//				if (sameCntr == "true") {
//					compareCntr(obj2[1], obj[1]);
//				}
//			}
//		}
//	}	
}


function setBbCgoDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj = document.form;
	var formObj2 = document.form2;
	var tmp = eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color = "blue"
	} else {
		tmp.style.color = "#606060";
	}	
}

function compareBbCgo(leftSeq, rightSeq) {
	if(leftSeq==0||rightSeq==0) return;
	var formObj = document.form;
	var formObj2 = document.form2;
//	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 	+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 	+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 	+ rightSeq));
//	setCntrDiffCheckColor(eval("formObj.cmdt_cd__" 			+ leftSeq).value, eval("formObj2.cmdt_cd__" 		+ rightSeq).value, ("formObj2.cmdt_cd__" 		+ rightSeq));
	
	setBbCgoDiffCheckColor(eval("formObj.dim_len__"		+ leftSeq).value, eval("formObj2.dim_len__" 	+ rightSeq).value, ("formObj2.dim_len__" 	+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.dim_wdt__" 		+ leftSeq).value, eval("formObj2.dim_wdt__" 	+ rightSeq).value, ("formObj2.dim_wdt__" 	+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.dim_hgt__" 		+ leftSeq).value, eval("formObj2.dim_hgt__" 	+ rightSeq).value, ("formObj2.dim_hgt__" 	+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.grs_wgt__" 			+ leftSeq).value, eval("formObj2.grs_wgt__" 		+ rightSeq).value, ("formObj2.grs_wgt__" 		+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.wgt_ut_cd__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd__" 	+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.pck_qty__"			+ leftSeq).value, eval("formObj2.pck_qty__" 		+ rightSeq).value, ("formObj2.pck_qty__" 		+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.pck_tp_cd__" 		+ leftSeq).value, eval("formObj2.pck_tp_cd__" 		+ rightSeq).value, ("formObj2.pck_tp_cd__" 		+ rightSeq));
//	setCntrDiffCheckColor(eval("formObj.net_wgt__" 			+ leftSeq).value, eval("formObj2.net_wgt__" 		+ rightSeq).value, ("formObj2.net_wgt__" 		+ rightSeq));
//	setCntrDiffCheckColor(eval("formObj.wgt_ut_cd2__" 		+ leftSeq).value, eval("formObj2.wgt_ut_cd2__" 		+ rightSeq).value, ("formObj2.wgt_ut_cd2__" 	+ rightSeq));
	setBbCgoDiffCheckColor(eval("formObj.diff_rmk__" 	+ leftSeq).value, eval("formObj2.diff_rmk__" 	+ rightSeq).value, ("formObj2.diff_rmk__" + rightSeq));
	
	var cgo_dchg_sd_cd2 = "";
	if(eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Sea(barge)"){
		cgo_dchg_sd_cd2 = "S";
	} else if(eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Land"){
		cgo_dchg_sd_cd2 = "L";
	}
	setBbCgoDiffCheckColor(eval("formObj.cgo_dchg_sd_cd__" 	+ leftSeq).value, cgo_dchg_sd_cd2, ("formObj2.cgo_dchg_sd_cd__" + rightSeq));
		
//	var tmp = null;
//	tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.cmdt_cd__" + rightSeq);
//	if (eval("formObj.cmdt_cd__" + leftSeq).value != eval("formObj2.cmdt_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.dim_len__" + rightSeq);
//	if (eval("formObj.dim_len__" + leftSeq).value != eval("formObj2.dim_len__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.dim_wdt__" + rightSeq);
//	if (eval("formObj.dim_wdt__" + leftSeq).value != eval("formObj2.dim_wdt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.dim_hgt__" + rightSeq);
//	if (eval("formObj.dim_hgt__" + leftSeq).value != eval("formObj2.dim_hgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.grs_wgt__" + rightSeq);
//	if (eval("formObj.grs_wgt__" + leftSeq).value != eval("formObj2.grs_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd1__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd__" + leftSeq).value != eval("formObj2.wgt_ut_cd1__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_qty__" + rightSeq);
//	if (eval("formObj.pck_qty__" + leftSeq).value != eval("formObj2.pck_qty__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.pck_tp_cd__" + rightSeq);
//	if (eval("formObj.pck_tp_cd__" + leftSeq).value != eval("formObj2.pck_tp_cd__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.net_wgt__" + rightSeq);
//	if (eval("formObj.net_wgt__" + leftSeq).value != eval("formObj2.net_wgt__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.wgt_ut_cd2__" + rightSeq);
//	if (eval("formObj.wgt_ut_cd2__" + leftSeq).value != eval("formObj2.wgt_ut_cd2__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
//	tmp = eval("formObj2.stwg_rqst_desc__" + rightSeq);
//	if (eval("formObj.stwg_rqst_desc__" + leftSeq).value != eval("formObj2.stwg_rqst_desc__"+ rightSeq).value) {
//		tmp.style.color = "blue";
//	} else {
//		tmp.style.color = "#606060";
//	}
}

// 수정시 자리수 맞춤
function form_onChange(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcValue = window.event.srcElement.getAttribute("value");
	var obj = document.getElementById(srcName);

	if (srcName.indexOf("dim_len") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("dim_wdt") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("dim_hgt") == 0) 	obj.value = ComAddComma(srcValue, "#,###");
	if (srcName.indexOf("grs_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
	if (srcName.indexOf("net_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
	if (srcName.indexOf("pck_qty") == 0) 		obj.value = ComAddComma(srcValue, "#,##0");
	
	if (srcName.indexOf("cmdt_cd") == 0){
		if(!ComIsNull(srcValue)){
			obj.value = ComLpad(srcValue,6,"0");
			validatePrecaution(formObj,srcName,ComLpad(srcValue,6,"0"));
		}else{
			ComSetObjValue(eval("formObj.cmdt_desc__"+srcName.substr(srcName.length-1,1)),"");
		}
 	}

	compareItem();
}

function createTable(seq) {
	var insTableDiv = "";
	insTableDiv = insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv = insTableDiv + "</div>\n";
	return insTableDiv;
}

function createBbCargo(leftSeq, rightSeq) {
	var formObj2 = document.form2;
	var tabSeq = "table_" + leftSeq;
	var dyntbl1 = document.getElementById(tabSeq);
	dyntbl1.innerHTML = "";
	var oCell1 = "";
	var wgt_cdArr = wgt_cd.split("|");
	var wgt_nmArr = wgt_nm.split("|");

	max_bb_cgo_seq++;
	
	
	oCell1 = oCell1 + "<table id=\"table" + leftSeq
			+ "\" class=\"search\" border=\"0\">\n";
	oCell1 = oCell1 + "<input type=\"hidden\" name=\"bb_cgo_seq__" + leftSeq + 
			"\" value='" + max_bb_cgo_seq + "'>\n";
	
	
//	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
//	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
//			+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
//	oCell1 = oCell1 + "		<td width=\"90\">CNTR No.</td>\n";
//	oCell1 = oCell1 + "		<td width=\"180\">\n";
//	oCell1 = oCell1 + "		  <select name=\"cntr_no__" + leftSeq
//			+ "\" style=\"width:105;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";

//	alert("createBbCargo - 2" );

//	var cntrTpsz_cdArr = cntrTpsz_cd.split("|");
//	var cntrTpsz_idArr = cntrTpsz_id.split("|");
//	for ( var j = 0; j < cntrTpsz_cdArr.length; j++) {
//		if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
//			continue;
//		if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
//			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
//					+ cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j]
//					+ "</option>\n";
//		} else {
//			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
//					+ cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]
//					+ "</option>\n";
//		}
//	}
	
//	alert("createBbCargo - 3" );
//	alert(" leftSeq : " + leftSeq + "\n rightSeq : " + rightSeq);
//	alert("oCell1 : " + oCell1 );
	
//	oCell1 = oCell1 + "		  </select>&nbsp;<input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq
//			+ "\" style=\"width:35;\" maxlength=\"4\" dataformat=\"eng\" class=\"input\" value=\""
//			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\"></td>\n";

	
//	oCell1 = oCell1 + "		<td width=\"50\">Status</td>\n";
//	oCell1 = oCell1 + "		<td width=\"\"><input type=\"text\" name=\"status__" + leftSeq
//			+ "\" style=\"width:80;color:blue\" class=\"input2\" value=\"New\" readOnly></td>\n";
//	oCell1 = oCell1 + "	</tr>\n";

//	alert("createBbCargo - 3 - 1" );
	
//	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
//	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"></td>\n";
//	oCell1 = oCell1 + "		<td width=\"80\">Commodity</td>\n";
//	oCell1 = oCell1 + "		<td colspan=\"4\"><input type=\"text\" required caption=\"Commodity\" name=\"cmdt_cd__" + leftSeq
//			+ "\" style=\"width:90;\" maxlength=\"8\" dataformat=\"etc\" class=\"input\" value=\""
//			+ eval("formObj2.cmdt_cd__" + rightSeq).value + "\">"
//			+ "&nbsp;<a href=\"javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__" + leftSeq + ".value, '" + leftSeq
//			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a>";
//	oCell1 = oCell1 + "		  <input type=\"text\" name=\"cmdt_desc__" + leftSeq
//	+ "\" style=\"width:190;\" maxlength=\"4000\" dataformat=\"engup\" class=\"input2\" value=\"" + eval("formObj2.cmdt_desc__" + rightSeq).value + "\" readonly=\"readonly\"></td>\n";
//	oCell1 = oCell1 + "	</tr>\n";

	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
	+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Length</td>\n";
	oCell1 = oCell1 + "		<td width=\"180\" class=\"stm\"><input type=\"text\" name=\"dim_len__" + leftSeq
			+ "\" style=\"width:80;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.dim_len__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	
	oCell1 = oCell1 + "		<td width=\"70\">Width</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" name=\"dim_wdt__" + leftSeq
			+ "\" style=\"width:110;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.dim_wdt__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	oCell1 = oCell1 + "	</tr>\n";

	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Height</td>\n";
	oCell1 = oCell1 + "		<td width=\"\" class=\"stm\"><input type=\"text\" name=\"dim_hgt__" + leftSeq
			+ "\" style=\"width:80;text-align:right\" maxlength=\"7\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.dim_hgt__" + rightSeq).value
			+ "\">&nbsp;CM</td>\n";
	oCell1 = oCell1 + "		<td width=\"50\">Package</td>\n";
	oCell1 = oCell1 + "		<td width=\"170\"><input type=\"text\" name=\"pck_qty__" + leftSeq
			+ "\" style=\"width:65;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.pck_qty__" + rightSeq).value
			+ "\">&nbsp;<input type=\"text\" dataformat=\"eng\" maxlength=\"2\" required caption=\"Package Type Code\" name=\"pck_tp_cd__" + leftSeq
			+ "\" style=\"width:35;\" class=\"input\" value=\""
			+ eval("formObj2.pck_tp_cd__" + rightSeq).value
			+ "\">&nbsp;<a href=\"javascript:comBkgCallPop0696_position('setCallBack0696', document.form.pck_tp_cd__" + leftSeq
			+ ".value, '" + leftSeq
			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a></td>\n";
	oCell1 = oCell1 + "	</tr>\n";

	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"85\">Gross WGT</td>\n";
	oCell1 = oCell1 + "		<td width=\"150\"><input type=\"text\" name=\"grs_wgt__" + leftSeq
			+ "\" style=\"width:90;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.grs_wgt__" + rightSeq).value + "\">&nbsp;\n";
	oCell1 = oCell1 + "<select name=\"wgt_ut_cd__" + leftSeq
			+ "\" style=\"width:47;\" class=\"input\">\n";
	
	for ( var i = 0; i < wgt_cdArr.length; i++) {
		
		if (wgt_cdArr[i] == '' && wgt_nmArr[i] == '')
			continue;
		if (wgt_cdArr[i] == eval("formObj2.wgt_ut_cd__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[i] + "\" selected>"
					+ wgt_nmArr[i] + "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[i] + "\">" + wgt_nmArr[i]
					+ "</option>\n";
		}
	}
	
	oCell1 = oCell1 + "		</td>\n";

	oCell1 = oCell1 + "		<td width=\"50\">Status</td>\n";
	oCell1 = oCell1 + "		<td width=\"\"><input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:80;color:blue\" class=\"input2\" value=\"New\" readOnly></td>\n";
	
	
//	oCell1 = oCell1 + "		<td width=\"80\">Net WGT</td>\n";
//	oCell1 = oCell1 + "		<td width=\"\" colspan=\"3\"><input type=\"text\" name=\"net_wgt__"
//			+ leftSeq
//			+ "\" style=\"width:90;text-align:right\" maxlength=\"12\" dataformat=\"float\" class=\"input\" value=\""
//			+ eval("formObj2.net_wgt__" + rightSeq).value + "\">&nbsp;\n";
//	oCell1 = oCell1 + "<select name=\"wgt_ut_cd2__" + leftSeq
//			+ "\" style=\"width:47;\" class=\"input\">\n";
//	for ( var j = 0; j < wgt_cdArr.length; j++) {
//		if (wgt_cdArr[j] == '' && wgt_nmArr[j] == '')
//			continue;
//		if (wgt_cdArr[j] == eval("formObj2.wgt_ut_cd2__" + rightSeq).value) {
//			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[j] + "\" selected>"
//					+ wgt_nmArr[j] + "</option>\n";
//		} else {
//			oCell1 = oCell1 + "<option value=\"" + wgt_cdArr[j] + "\">" + wgt_nmArr[j]
//					+ "</option>\n";
//		}
//	}
//	oCell1 = oCell1 + "		</td>\n";
	
	oCell1 = oCell1 + "	</tr>\n";	

	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"85\">Disch.side</td>\n";
	oCell1 = oCell1 + "		<td width=\"160\">\n";
	oCell1 = oCell1 + "		 <select name=\"cgo_dchg_sd_cd__"+ leftSeq+"\" style=\"width:100;\" class=\"input\">\n";
//	
	var cgo_dchg_sd_cd1 = (eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "")?"selected":"";
	var cgo_dchg_sd_cd2 = (eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Sea(barge)")?"selected":"";
	var cgo_dchg_sd_cd3 = (eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Land")?"selected":"";
//	
	oCell1 = oCell1 + "		    <option value=\"\"  " + cgo_dchg_sd_cd1 + "></option>\n";
	oCell1 = oCell1 + "		    <option value=\"S\" " + cgo_dchg_sd_cd2 + " >Sea(barge)</option>\n";
	oCell1 = oCell1 + "		    <option value=\"L\" " + cgo_dchg_sd_cd3 + ">Land</option>\n";
	
	oCell1 = oCell1 + "		 </select>\n";
	
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	
	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\">&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">Remark(s)</td>\n";
	oCell1 = oCell1 + "		<td colspan=\"2\"><textarea dataformat=\"etc\" name=\"diff_rmk__" + leftSeq
			+ "\" style=\"width:98%;height:40;\">"
			+ eval("formObj2.diff_rmk__" + rightSeq).value
			+ "</textarea></td>\n";
	oCell1 = oCell1 + "		<td width=\"85\">\n";
	oCell1 = oCell1 + "		  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">\n";
	oCell1 = oCell1 + "				<tr><td class=\"btn2_left\"></td>\n";
	oCell1 = oCell1 + "				<a href=\"javascript:btn_delete('table" + leftSeq
			+ "', '" + leftSeq + "');\"><td class=\"btn2\" name=\"btn_delete" + leftSeq
			+ "\">Delete</td></a>\n";
	oCell1 = oCell1 + "				<td class=\"btn2_right\"></td>\n";
	oCell1 = oCell1 + "				</tr>\n";
	oCell1 = oCell1 + "		  </table>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"height_10\"><td colspan=\"8\"></td></tr>\n";
	oCell1 = oCell1 + "</table>\n";

	dyntbl1.innerHTML = oCell1;
}

function updateBbCargo(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;
  
	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;

	if (eval("formObj2.dim_len__" + rightSeq).value != null && eval("formObj2.dim_len__" + rightSeq).value != '')
		eval("formObj.dim_len__" + leftSeq).value  = eval("formObj2.dim_len__" + rightSeq).value;

	if (eval("formObj2.dim_wdt__" + rightSeq).value != null && eval("formObj2.dim_wdt__" + rightSeq).value != '')
		eval("formObj.dim_wdt__" + leftSeq).value  = eval("formObj2.dim_wdt__" + rightSeq).value;
	
	if (eval("formObj2.dim_hgt__" + rightSeq).value != null && eval("formObj2.dim_hgt__" + rightSeq).value != '')
		eval("formObj.dim_hgt__" + leftSeq).value  = eval("formObj2.dim_hgt__" + rightSeq).value;
	
	if (eval("formObj2.grs_wgt__" + rightSeq).value != null && eval("formObj2.grs_wgt__" + rightSeq).value != '')
		eval("formObj.grs_wgt__" + leftSeq).value  = eval("formObj2.grs_wgt__" + rightSeq).value;
	
	if (eval("formObj2.pck_qty__" + rightSeq).value != null && eval("formObj2.pck_qty__" + rightSeq).value != '')
		eval("formObj.pck_qty__" + leftSeq).value  = eval("formObj2.pck_qty__" + rightSeq).value;
	
	if (eval("formObj2.wgt_ut_cd__" + rightSeq).value != null && eval("formObj2.wgt_ut_cd__" + rightSeq).value != '') {
		for ( var i = 0; i < eval("formObj.wgt_ut_cd__" + leftSeq).length; i++) {
			if (eval("formObj.wgt_ut_cd__" + leftSeq)[i].value == eval("formObj2.wgt_ut_cd__" + rightSeq).value) {
				eval("formObj.wgt_ut_cd__" + leftSeq).selectedIndex = i;
				break;
			}
		}
	}
	
	if (eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value != null && eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value != ''){
//		eval("formObj.cgo_dchg_sd_cd__" + leftSeq).value  = eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value;
		if(eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Sea(barge)"){
			eval("formObj.cgo_dchg_sd_cd__" + leftSeq).value  = 'S';
		} else if(eval("formObj2.cgo_dchg_sd_cd__" + rightSeq).value == "Land"){
			eval("formObj.cgo_dchg_sd_cd__" + leftSeq).value  = 'L';
		}
	}
	
}

function deleteAllTable() {
	var formObj = document.form;
	for ( var i = 0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}

function btn_deleteTable(tableId) {
	var formObj = document.form;
	var seq = 1;

	var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount = tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}

//	for ( var i = 0; i < formObj.elements.length; i++) {
//		var objNm = (formObj.elements[i].name).split("__");
//		if (objNm[0] == "cntr_seq") {
//			formObj.elements[i].value = seq++;
//		}
//	}
}

function btn_delete(tableId, seq) {
	var formObj = document.form;
	doSaveCopy();
	for (var i=1; i<sheetObjects[0].RowCount+1; i++) {
		if (sheetObjects[0].CellValue(i, "bb_cgo_seq") == eval("formObj.bb_cgo_seq__" + seq).value) {
			sheetObjects[0].RowStatus(i) = "D";
			break;
		}
	}
	btn_deleteTable(tableId);
}

function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id = obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value = obj_id;
	}
}

function loadComboData(cd, nm) {
 	wgt_cd = cd;
 	wgt_nm = nm;
}

function loadCntrTpsz(cd, id) {
	cntrTpsz_cd = cd;
	cntrTpsz_id = id;
}

function makeComma2(obj) {
	var val = makeComma(obj.value);
	obj.value = val;
}

function makeComma(srcValue) {
	var arrVal = srcValue.split(".");

	if (arrVal.length > 1) {
		srcValue = makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue = makeCommaRun(arrVal[0]) + ".000";
	}
	return srcValue;
}
	
function makeCommaRun(srcValue) {
	srcValue = srcValue.replace(/\D/g, "");
	if (srcValue.length > 9) {
		srcValue = srcValue.substring(0, 9);
	}
	l = srcValue.length - 3;
	while (l > 0) {
		srcValue = srcValue.substr(0, l) + "," + srcValue.substr(l);
		l -= 3;
	}
	return srcValue;
}

function comBkgCallPop0696_position(funcNm, val, pos) {
	pkgPosition = pos;
	comBkgCallPop0696(funcNm, val);
}

function setCallBack0696(aryPopupData) {
	var formObj = document.form;
	eval("formObj.pck_tp_cd__" + pkgPosition).value = aryPopupData[0][3];
}

function comBkgCallPop0653_position(funcNm, val, pos) {
	cmdtPosition = pos;
	comBkgCallPop0653(funcNm, val, '');
}

function setCallBack0653(aryPopupData) {
	var formObj = document.form;
	eval("formObj.cmdt_cd__" + cmdtPosition).value = aryPopupData[0][3];
	eval("formObj.cmdt_desc__" + cmdtPosition).value = aryPopupData[0][4];
}

/**
 * cmdt_cd 입력시 precaution 정보 조회
 */       
function validatePrecaution(formObj,srcName,srcValue){
	formObj.f_cmd.value = SEARCHLIST11;
	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11 + "&cmdt_cd="+srcValue);
	if (sXml != "") {
		ComSetObjValue(eval("formObj.cmdt_desc__"+srcName.substr(srcName.length-1,1)),ComGetEtcData(sXml,"cmdt_nm"));
	}
}



function voidSpaceValue(row) {

	var width1 = sheetObjects[0].CellValue(row,"ovr_lf_len");
	var width2 = sheetObjects[0].CellValue(row,"ovr_rt_len");
	var height = sheetObjects[0].CellValue(row,"ovr_hgt");

	if (width1 > 0 && width2 > 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "5";
	} else if (width1 > 0 && width2 > 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "2";
	} else if (width1 > 0 && width2 == 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "3";
	} else if (width1 == 0 && width2 > 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "3";
	} else if (width1 > 0 && width2 == 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1";
	} else if (width1 == 0 && width2 > 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1";
	} else if (width1 == 0 && width2 == 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1";
	} else {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "0";
	}
	if (sheetObjects[0].CellValue(row, "ovr_void_slt_qty") == "0") {
		sheetObjects[0].CellValue2(row, "in_ga_flg") = "Y";
	} else {
		sheetObjects[0].CellValue2(row, "in_ga_flg") = "N";
	}
}

function voidSpaceValue2(row) {

	var width1 = sheetObjects[0].CellValue(row,"ovr_lf_len");
	var width2 = sheetObjects[0].CellValue(row,"ovr_rt_len");
	var height = sheetObjects[0].CellValue(row,"ovr_hgt");
	
	if (width1 > 0 && width2 > 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "2.5";
	} else if (width1 > 0 && width2 > 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1";
	} else if (width1 > 0 && width2 == 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1.5";
	} else if (width1 == 0 && width2 > 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "1.5";
	} else if (width1 > 0 && width2 == 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "0.5";
	} else if (width1 == 0 && width2 > 0 && height == 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "0.5";
	} else if (width1 == 0 && width2 == 0 && height > 0) {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "0.5";
	} else {
		sheetObjects[0].CellValue2(row, "ovr_void_slt_qty") = "0";
	}
	if (sheetObjects[0].CellValue(row, "ovr_void_slt_qty") == "0") {
		sheetObjects[0].CellValue2(row, "in_ga_flg") = "Y";
	} else {
		sheetObjects[0].CellValue2(row, "in_ga_flg") = "N";
	}
}

////Container 리스트를 저장용 sheet로 Copy
//function doCntrSaveCopy() {
//var formObj = document.form;
//var obj = null;
//var objNm = null;
//var objSeq = null;
//var objVal = null;
//var cntrNo = null;
//var ibflag = null;
//
//for ( var i = 0; i < formObj.elements.length; i++) {
//	if ((formObj.elements[i].name).indexOf("__") > 0) {
//		obj = (formObj.elements[i].name).split("__");
//		objNm = obj[0];
//		objSeq = obj[1];
//		objVal = formObj.elements[i].value;
//		if (objNm == "ibflag") {
//			ibflag = objVal;
//			if (sheetObjects[0].CellValue(objSeq, "ibflag") != "D") {
//				sheetObjects[0].CellValue(objSeq, "ibflag") = objVal;
//			}
//		}
//		sheetObjects[0].CellValue(objSeq, "bkg_no") = formObj.bkg_no.value;
//
//		if (objNm == "bb_cgo_seq")
//			sheetObjects[0].CellValue(objSeq, "bb_cgo_seq") = objVal;
//		if (objNm == "cntr_no")
//			sheetObjects[0].CellValue(objSeq, "cntr_no") = objVal;
//		if (objNm == "cntr_tpsz_cd")
//			sheetObjects[0].CellValue(objSeq, "cntr_tpsz_cd") = objVal;
//		if (objNm == "cmdt_cd")
//			sheetObjects[0].CellValue(objSeq, "cmdt_cd") = objVal;
//		if (objNm == "dim_len")
//			sheetObjects[0].CellValue(objSeq, "dim_len") = (objVal)
//					.replaceStr(",");
//		if (objNm == "dim_wdt")
//			sheetObjects[0].CellValue(objSeq, "dim_wdt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "dim_hgt")
//			sheetObjects[0].CellValue(objSeq, "dim_hgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "grs_wgt")
//			sheetObjects[0].CellValue(objSeq, "grs_wgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "wgt_ut_cd")
//			sheetObjects[0].CellValue(objSeq, "wgt_ut_cd") = objVal;
//		if (objNm == "pck_qty")
//			sheetObjects[0].CellValue(objSeq, "pck_qty") = (objVal)
//					.replaceStr(",");
//		if (objNm == "pck_tp_cd")
//			sheetObjects[0].CellValue(objSeq, "pck_tp_cd") = objVal;
//		if (objNm == "net_wgt")
//			sheetObjects[0].CellValue(objSeq, "net_wgt") = (objVal)
//					.replaceStr(",");
//		if (objNm == "wgt_ut_cd2")
//			sheetObjects[0].CellValue(objSeq, "wgt_ut_cd2") = objVal;
//		if (objNm == "stwg_rqst_desc")
//			sheetObjects[0].CellValue(objSeq, "stwg_rqst_desc") = objVal;
//	}
//}
//}
