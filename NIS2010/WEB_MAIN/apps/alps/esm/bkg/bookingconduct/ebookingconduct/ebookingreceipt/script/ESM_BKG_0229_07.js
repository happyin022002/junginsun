/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_07.js
 *@FileTitle : e-Booking & SI Process Detail(REEFER)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.24
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.24 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2011.12.14 정선용 [CHM-201114900-01]	RF E-BKG Vent 단위 및 Remark 추가 요청
 2013.05.02 임재관 [CHM-201324228] e-BKG &S/I Process 메뉴 수정 요청 - CLNG_TP_CD Full Name 조회
=========================================================*/
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
 * @class esm_bkg_0229_07 : esm_bkg_0229_07 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_07() {
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
var prefix = "t7sheet1_";

var cmdtPosition = 0;

var cntrTpsz_cd = "";
var cntrTpsz_id = "";

var max_rc_seq = 0;
var copyToAlps = false;

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
			copyToAlps = false;
			parent.document.form.reeferTabCancel.value = "Y";
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
		// IBMultiCombo
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
		sheetObj.SheetWidth = 350;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 17, 100);

			var HeadTitle1 = "ibflag|bkg_no|rc_seq|cntr_tpsz_cd|cntr_no|cmdt_cd|cmdt_desc|fdo_temp|cdo_temp|pwr_spl_cbl_flg|vent_rto|clng_tp_cd|humid_no|MAX||"
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
			sheetObj.InitDataProperty(0, cnt++, dtStatus, 30,  daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "rc_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cntr_tpsz_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cntr_no");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cmdt_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cmdt_desc");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "fdo_temp", false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cdo_temp", false, "", dfNullFloat);
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "pwr_spl_cbl_flg");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "vent_rto");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "clng_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "humid_no");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "max_rc_seq");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "diff_rmk");
			sheetObj.InitDataProperty(0, cnt++, dtData,   70, daLeft, true, "cntr_vent_tp_cd");
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
			var obj = null;
			var objNm = null;
			var objVal = null;
			var obj2 = null;
			var objNm2 = null;
			var objVal2 = null;
			var sameCntr = "false";
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						for ( var j = 0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								objVal2 = formObj.elements[j].value;

								if (objNm2 == "cntr_no") {
									if (objVal == objVal2) {
										sameCntr = "true";
										break;
									} else {
										sameCntr = "false";
									}
								}
							}
						}
						if (sameCntr == "true") {
							compareCntr(obj2[1], obj[1]);
						}
					}
				}
			}
			var sXml = formObj.sXml.value;
			var arrXml = sXml.split("|$$|");
			sheetObjects[0].LoadSearchXml(arrXml[0]);
		}

		for(var i=1;i<sheetObjects[0].Rows;i++){
			if(max_rc_seq<parseInt(sheetObjects[0].CellValue(i, "rc_seq"))){
				max_rc_seq = parseInt(sheetObjects[0].CellValue(i, "rc_seq"));
			}
		}
		
		if(parent.document.form.reeferTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");
			parent.document.form.reeferTabCancel.value = "N";
		}
		if(top.document.form.tabload7.value == "COPY"){
			dataCopy();
		} else {
			compareItem();
		}
		
		if(parent.frames("t1frame").document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoalps");
		}
		
		top.document.form.tabload7.value = "LOAD";
		break;

	case IBSEARCH: //조회
		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_07.do";
		formObj.submit();
		parent.tabObjects[0].TabBackColor(6) = "#96c792";
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		// DHTML 테이블 생성
		var ins_tables = document.getElementById("INS_TABLES");
		ins_tables.innerHTML = "";
		var insTableDiv = "";

		var maxSeq = 0;
		for ( var k = 0; k < formObj.elements.length; k++) {
			if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
				var elValue = parseInt(formObj.elements[k].value);
				if (elValue > maxSeq)
				//if (formObj.elements[k].value > maxSeq)
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
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						for ( var j = 0; j < formObj.elements.length; j++) {
							if ((formObj.elements[j].name).indexOf("__") > 0) {
								obj2 = (formObj.elements[j].name).split("__");
								objNm2 = obj2[0];
								objVal2 = formObj.elements[j].value;

								if (objNm2 == "cntr_no") {
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
							createCntr(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							updateCntr(obj2[1], obj[1]);
						}

					}
				}
			}
		} else {
			for ( var i = 0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text"
						&& (formObj2.elements[i].name).indexOf("__") > 0) {
					obj = (formObj2.elements[i].name).split("__");
					objNm = obj[0];
					objVal = formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv = createTable(maxSeq);
						ins_tables.innerHTML = ins_tables.innerHTML + insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}
		parent.tabObjects[0].TabBackColor(6) = "#fff270";
		compareItem();
		initControl();
		break;

	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		
		var params = getSaveStringForUpload();
		
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_07GS.do", params);
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
//	if (!sheetObj.IsDataModified) {
//		ComShowCodeMessage("BKG00743");
//		return false;
//	}
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

	
	// reefer min(섭씨) 값이 null일 경우, 필수 validation을 추가. (MSG NO : BKG95008) 
	if ( formObj.maxBkgSeq.value > 0 ||  copyToAlps) {
		
        try {
			for (var z=0; z < formObj.maxXterSeq.value; z++ ) { 
				if (eval("formObj.cdo_temp__" +(z+1)).value == "" ) {
					ComShowCodeMessage("BKG95008", "Temperature");		
					eval("formObj.cdo_temp__" + (z+1)).focus();
					return false;
				}
				if (eval("formObj.vent_rto__" +(z+1)).value == "" ){
					ComShowCodeMessage("BKG02089", "[Seq: "+(z+1)+"]");
					eval("formObj.vent_rto__" + (z+1)).focus();
					return false;
				}
//				if (eval("formObj.cntr_tpsz_cd__" +(z+1)).value == "" ){
//					ComShowCodeMessage("BKG00054");
//					eval("formObj.cntr_tpsz_cd__" + (z+1)).focus();
//					return false;
//				} 
//				
//				if (!ComIsNull(eval("formObj.cntr_tpsz_cd__" +(z+1)).value)){
//	  			    var param = "&f_cmd=" + SEARCH02 + "&cntrtpsz=" + eval("formObj.cntr_tpsz_cd__" +(z+1)).value ;
//   			        var sXml = sheetObj.GetSearchXml("ESM_BKG_0229_07GS.do", param);
//   			        var cntr_tpsz_flag = ComGetEtcData(sXml, "cntrTpSzChk");	
//   			        
//					if(cntr_tpsz_flag == "N"){
//						ComShowCodeMessage("BKG00062",eval("formObj.cntr_tpsz_cd__" +(z+1)).value);
//						eval("formObj.cntr_tpsz_cd__" + (z+1)).focus();
//						return false;
//					}
//				}
			}	
        } catch(err) {       	
        }
	}
	
	//단위 칼럼 공란이거나 다른 단위일 경우 "% open"으로 처리하고, 경고 메시지 
    //"Ventilation Type is blank or invalid. Ventilation will be uploaded as %."
	var formObj2  = document.form2;
	for ( var i = 0; i < formObj2.elements.length; i++) {
		if (formObj2.elements[i].name.indexOf("cntr_vent_tp_cd") == 0){
			if(formObj2.elements[i].value!='C' && formObj2.elements[i].value!='P'  ){
				ComShowCodeMessage("BKG08218");		
				break;
			}
		}
	}

	if ( parent.frames("t1frame").document.form.save_cntr_flag.value == "N" ) {
		doSaveCopy();
		// At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
	   	// 조건: POD = US, POD= CA,  US Frob의 경우
	   	var params = "f_cmd="+SEARCH03;
	   	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
	   	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_07GS.do", params);
	   	var arrXml = sXml.split("|$$|");
	   	var rskFlg = ComGetEtcData(arrXml[0],"rskFlg");
	   	if(rskFlg =="Y"){
	   		ComShowMessage(ComGetMsg("BKG08275"));
	   	}
	} else {
		if ( parent.frames("t3frame").document.form.rsk_flg.value == "N" ) {
			doSaveCopy();
			// At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
		   	// 조건: POD = US, POD= CA,  US Frob의 경우
		   	var params = "f_cmd="+SEARCH03;
		   	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");
		   	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_07GS.do", params);
		   	var arrXml = sXml.split("|$$|");
		   	var rskFlg = ComGetEtcData(arrXml[0],"rskFlg");
		   	if(rskFlg =="Y"){
		   		ComShowMessage(ComGetMsg("BKG08275"));
		   	}
		}
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
	if (sheetObjects[0].RowCount>0) {
		params = "f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), prefix);
 	}
 	
// 	a"lert("getSaveStringForUpload in ESM_BKG_0229_04.js params=[" + params + "]");
 	return (params);
}

/**
 * e-Booking Upload Copy 팝업에서 [OK]버튼 클릭시
 */
function dataCopy() {
	copyToAlps = true; 
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

function doSaveCopy(){
	copyToAlps = true;
 	var formObj=document.form;
	var sheetObj = sheetObjects[0];
	var maxSeq = 0;

	for ( var k = 0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("cntr_seq__") == 0) {
			var elValue = parseInt(formObj.elements[k].value);
			if (elValue > maxSeq)
			//if (formObj.elements[k].value > maxSeq)
				maxSeq = formObj.elements[k].value;
		}
	}
	// [Data Copy to ALPS]에 의해 생긴 New 
	for (var i = sheetObj.RowCount; i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
	
	var obj=null;
	var objNm=null;
	var objSeq=null;
	var objVal=null;
	var cntrNo=null;
	var ibflag=null;
	var cdo_temp = "";
	var fdo_temp = "";
	for(var i=0; i<formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("__") > 0) {
			obj = (formObj.elements[i].name).split("__");
			objNm = obj[0];
			objSeq = obj[1];
			objVal = formObj.elements[i].value;
			if (sheetObjects[0].CellValue(objSeq,"bkg_no") == "") {
				sheetObjects[0].CellValue2(objSeq,"bkg_no") = formObj.bkg_no.value;
			}
			if ( objNm == "rc_seq")			sheetObjects[0].CellValue2(objSeq,"rc_seq") = objVal;
			if ( objNm == "cntr_no")		sheetObjects[0].CellValue2(objSeq,"cntr_no") = ComTrimAll(objVal);
			if ( objNm == "cntr_tpsz_cd" )	sheetObjects[0].CellValue2(objSeq,"cntr_tpsz_cd") = objVal;
			if ( objNm == "cmdt_cd")		sheetObjects[0].CellValue2(objSeq,"cmdt_cd") = objVal;
			if ( objNm == "cmdt_desc" )		sheetObjects[0].CellValue2(objSeq,"cmdt_desc") = objVal;
			if ( objNm == "temperature1" )	cdo_temp = objVal;
			if ( objNm == "cdo_temp" )     	sheetObjects[0].CellValue2(objSeq,"cdo_temp") = cdo_temp + objVal;
			if ( objNm == "temperature2" )	fdo_temp = objVal;
			if ( objNm == "fdo_temp" )      sheetObjects[0].CellValue2(objSeq,"fdo_temp") = fdo_temp + objVal;
			if ( objNm == "pwr_spl_cbl_flg")sheetObjects[0].CellValue2(objSeq,"pwr_spl_cbl_flg") = objVal;
			if ( objNm == "vent_rto" )		sheetObjects[0].CellValue2(objSeq,"vent_rto") = objVal;
			if ( objNm == "clng_tp_cd" )	sheetObjects[0].CellValue2(objSeq,"clng_tp_cd") = objVal;
			if ( objNm == "humid_no" )		sheetObjects[0].CellValue2(objSeq,"humid_no") = objVal;
			if ( objNm == "cntr_vent_tp_cd" )		sheetObjects[0].CellValue2(objSeq,"cntr_vent_tp_cd") = objVal;
			if ( objNm == "diff_rmk" )		sheetObjects[0].CellValue2(objSeq,"diff_rmk") = objVal;
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
	var sameCntr = "false";
	for ( var i = 0; i < formObj2.elements.length; i++) {
		if ((formObj2.elements[i].name).indexOf("__") > 0) {
			obj = (formObj2.elements[i].name).split("__");
			objNm = obj[0];
			objVal = formObj2.elements[i].value;
			if (objNm == "cntr_no_cmpr") {
				for ( var j = 0; j < formObj.elements.length; j++) {
					if ((formObj.elements[j].name).indexOf("__") > 0) {
						obj2 = (formObj.elements[j].name).split("__");
						objNm2 = obj2[0];
						objVal2 = formObj.elements[j].value;

						if (objNm2 == "cntr_no_cmpr") {
							if (objVal == objVal2) {
								sameCntr = "true";
								break;
							} else {
								sameCntr = "false";
							}
						}
					}
				}
				if (sameCntr == "true") {
					compareCntr(obj2[1], obj[1]);
				}
			}
		}
	}	
}

function form_onChange(){
//	var formObj = document.form;
//	var srcName = window.event.srcElement.getAttribute("name");
//	var srcValue = window.event.srcElement.getAttribute("value");
//	var obj = document.getElementById(srcName);

//	if (srcName.indexOf("net_wgt") == 0) 		obj.value = makeComma(srcValue.replace(/,/g, ""));
//	if (srcName.indexOf("pck_qty") == 0) 		obj.value = ComAddComma(srcValue, "#,##0");		

	compareItem();
}

function loadCntrTpsz(cd, id) {
	cntrTpsz_cd = cd;
	cntrTpsz_id = id;
}

function createTable(seq) {
	var insTableDiv = "";
	insTableDiv = insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv = insTableDiv + "</div>\n";
	return insTableDiv;
}

function createCntr(leftSeq, rightSeq) {
	var formObj2 = document.form2;
	var tabSeq = "table_" + leftSeq;
	var dyntbl1 = document.getElementById(tabSeq);
	dyntbl1.innerHTML = "";
	var oCell1 = "";
	
	max_rc_seq++;
	
	oCell1 = oCell1 + "<table id=\"table" + leftSeq+ "\" class=\"search\" border=\"0\">\n";
	oCell1 = oCell1 + "	<input type=\"hidden\" name=\"cntr_no_cmpr__" + leftSeq + "\" value=\""
					+ eval("formObj2.cntr_no__" + rightSeq).value
					+ eval("formObj2.rc_seq__" + rightSeq).value + "\">\n";
	oCell1 = oCell1 + "<input type=\"hidden\" name=\"rc_seq__" + leftSeq 
					+ "\" value='" + max_rc_seq + "'>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td width=\"30\" valign=\"top\" rowspan=\"5\"><input type=\"text\" name=\"cntr_seq__" + leftSeq
			+ "\" style=\"width:25;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" readOnly></td>\n";
	oCell1 = oCell1 + "		<td width=\"80\">CNTR No.</td>\n";
	oCell1 = oCell1 + "		<td width=\"180\">&nbsp;\n";
	oCell1 = oCell1 + "		  <select name=\"cntr_no__" + leftSeq
			+ "\" style=\"width:105;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";
	var cntrTpsz_cdArr = cntrTpsz_cd.split("|");
	var cntrTpsz_idArr = cntrTpsz_id.split("|");
	for ( var j = 0; j < cntrTpsz_cdArr.length; j++) {
		if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
			continue;
		if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		} else {
			oCell1 = oCell1 + "<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\""
					+ cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]
					+ "</option>\n";
		}
	}
	oCell1 = oCell1 + "		  </select>&nbsp;<input type=\"text\" name=\"cntr_tpsz_cd__" + leftSeq
			+ "\" style=\"width:40;\" maxlength=\"2\" dataformat=\"etc\" class=\"input\" value=\""
			+ eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\"></td>\n";
	oCell1 = oCell1 + "		<td width=\"60\">Status</td>\n";
	oCell1 = oCell1 + "		<td width=\"100\" colspan=\"2\"><input type=\"text\" name=\"status__" + leftSeq
			+ "\" style=\"width:95;\" class=\"input2\" value=\"New\" readOnly></td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>Commodity</td>\n";
	oCell1 = oCell1 + "		<td colspan=\"4\">&nbsp;\n<input type=\"text\" required caption=\"Commodity\" name=\"cmdt_cd__" 
			+ leftSeq + "\" style=\"width:90;\" class=\"input\" maxlength=\"10\" dataformat=\"etc\" value=\""
			+ eval("formObj2.cmdt_cd__" + rightSeq).value + "\">\n";
	oCell1 = oCell1 + "		  <a href=\"javascript:comBkgCallPop0653_position('setCallBack0653', document.form.cmdt_cd__" + leftSeq + ".value, '" + leftSeq
			+ "');\"><img class=\"cursor\" src=\"img/btns_search.gif\" width=\"19\" height=\"20\" border=\"0\" align=\"absmiddle\"></a>\n";
	oCell1 = oCell1 + "		  <input type=\"text\" name=\"cmdt_desc__" + leftSeq
			+ "\" style=\"width:190;\" maxlength=\"4000\" dataformat=\"engup\" class=\"input\" value=\"" + eval("formObj2.cmdt_desc__" + rightSeq).value + "\">\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>Temperature</td>\n";
	oCell1 = oCell1 + "		<td width=\"180\" class=\"stm\">&nbsp;\n";
	var plusminus = eval("formObj2.temperature1__" + rightSeq).value;
	var cdoTemp = eval("formObj2.min_temp__" + rightSeq).value;
	var fdoTemp = eval("formObj2.min_temp__" + rightSeq).value;
	var temp11 = null;
	var temp12 = null;
	var temp21 = null;
	var temp22 = null;
	
	if (cdoTemp != "") {
		if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value == "C") {
			
			fdoTemp = calcTemperature(plusminus + fdoTemp, "F");
			cdoTemp = cdoTemp;
	
			if (eval("formObj2.temperature1__" + rightSeq).value == "-") {
				temp11 = "selected";
				temp12 = "";
			} else {
				temp11 = "";
				temp12 = "selected";
			}
			if (fdoTemp.toString().substring(0, 1) == "-") {
				temp21 = "selected";
				temp22 = "";
				fdoTemp = fdoTemp.toString().substring(1, fdoTemp.length);
			} else {
				temp21 = "";
				temp22 = "selected";
			}
		} else {
			fdoTemp = fdoTemp;
			cdoTemp = calcTemperature(plusminus + cdoTemp, "C");
	
			if (eval("formObj2.temperature1__" + rightSeq).value == "-") {
				temp21 = "selected";
				temp22 = "";
			} else {
				temp21 = "";
				temp22 = "selected";
			}
			if (cdoTemp.toString().substring(0, 1) == "-") {
				temp11 = "selected";
				temp12 = "";
				cdoTemp = cdoTemp.toString().substring(1, cdoTemp.length);
			} else {
				temp11 = "";
				temp12 = "selected";
			}
		}
	}
	
	
	oCell1 = oCell1 + "		  <select name=\"temperature1__" + leftSeq
			+ "\" style=\"width:33;text-align:center;\" onChange=\"javascript:changeTemperature(this,'" + leftSeq + "')\">\n";
	oCell1 = oCell1 + "		    <option value=\"-\" " + temp11 + ">-</option>\n";
	oCell1 = oCell1 + "		    <option value=\"+\" " + temp12 + ">+</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		  <input type=\"text\" name=\"cdo_temp__" + leftSeq
			+ "\" dataformat=\"float\" pointcount=\"1\" maxlength=\"6\" style=\"width:33;display:\" class=\"input\" value=\""
			+ cdoTemp + "\" onChange=\"javascript:changeTemperature(this,'" + leftSeq + "')\">&nbsp;C\n";

	oCell1 = oCell1 + "		  <select name=\"temperature2__" + leftSeq
			+ "\" style=\"width:33;text-align:center;\" onChange=\"javascript:changeTemperature(this,'"
			+ leftSeq + "')\">\n";
	oCell1 = oCell1 + "		    <option value=\"-\" " + temp21 + ">-</option>\n";
	oCell1 = oCell1 + "		    <option value=\"+\" " + temp22 + ">+</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		  <input type=\"text\" name=\"fdo_temp__" + leftSeq
			+ "\" dataformat=\"float\" pointcount=\"1\" maxlength=\"6\" style=\"width:33;display:\" class=\"input\" value=\""
			+ fdoTemp + "\" onChange=\"javascript:changeTemperature(this,'"
			+ leftSeq + "')\">&nbsp;F\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "		<td width=\"60\">Genset</td>\n";
	oCell1 = oCell1 + "		<td width=\"100\" colspan=\"2\">\n";
	oCell1 = oCell1 + "		  <select name=\"pwr_spl_cbl_flg__" + leftSeq
			+ "\" style=\"width:72;text-align:center;\">\n";
	var genset1 = null;
	var genset2 = null;
	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value == "Y")
		genset1 = "selected";
	else
		genset1 = "";
	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value == "N")
		genset2 = "selected";
	else
		genset2 = "";
	oCell1 = oCell1 + "		    <option value=\"Y\" " + genset1 + ">Yes</option>\n";
	oCell1 = oCell1 + "		    <option value=\"N\" " + genset2 + ">No</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>Ventilation</td>\n";
	oCell1 = oCell1 + "		<td colspan=\"4\" class=\"stm\">&nbsp;\n<input type=\"text\" name=\"vent_rto__" + leftSeq
			+ "\" style=\"width:40;\" maxlength=\"5\" dataformat=\"float\" class=\"input\" value=\""
			+ eval("formObj2.vent_rto__" + rightSeq).value
			+ "\">&nbsp;" 
	oCell1 = oCell1 + "		  <select name=\"cntr_vent_tp_cd__" + leftSeq
			+ "\" style=\"width:80;\">\n";		
	var venttpcd1 = "";
	var venttpcd2 = "";
	if (eval("formObj2.ventilation_alpscopy__" + rightSeq).value == "P")
		venttpcd1 = "selected";
	else
		venttpcd1 = "";
	if (eval("formObj2.ventilation_alpscopy__" + rightSeq).value == "C")
		venttpcd2 = "selected";
	else
		venttpcd2 = "";
	oCell1 = oCell1 + "		    <option value=\"P\" " + venttpcd1 + ">% Open</option>\n";
	oCell1 = oCell1 + "		    <option value=\"C\" " + venttpcd2 + ">CMH</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
//	
	oCell1 = oCell1 + "		</td>\n";
	
	oCell1 = oCell1 + "	</tr>\n";
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>Nature</td>\n";
	oCell1 = oCell1 + "		<td width=\"150\">&nbsp;\n";
	oCell1 = oCell1 + "		  <select name=\"clng_tp_cd__" + leftSeq
			+ "\" style=\"width:105;text-align:center;\">\n";
	var nature1 = null;
	var nature2 = null;
	var nature3 = null;
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "Chilled")
		nature1 = "selected";
	else
		nature1 = "";
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "Frozen")
		nature2 = "selected";
	else
		nature2 = "";
	if (eval("formObj2.clng_tp_cd__" + rightSeq).value == "Fresh")
		nature3 = "selected";
	else
		nature3 = "";
	oCell1 = oCell1 + "		    <option value=\"C\" " + nature1 + ">Chilled</option>\n";
	oCell1 = oCell1 + "		    <option value=\"F\" " + nature2 + ">Frozen</option>\n";
	oCell1 = oCell1 + "		    <option value=\"S\" " + nature3 + ">Fresh</option>\n";
	oCell1 = oCell1 + "		  </select>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "		<td width=\"60\">Humidity</td>\n";
	oCell1 = oCell1 + "		<td width=\"50\" class=\"stm\"><input type=\"text\" name=\"humid_no__" + leftSeq
			+ "\" style=\"width:35;\" maxlength=\"4\" dataformat=\"int\" class=\"input\" value=\""
			+ eval("formObj2.humid_no__" + rightSeq).value + "\">%</td>\n";
	oCell1 = oCell1 + "		<td valign=\"bottom\">\n";
	oCell1 = oCell1 + "			<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button\">\n";
	oCell1 = oCell1 + "			<tr><td class=\"btn2_left\"></td>\n";
	oCell1 = oCell1 + "			<a href=\"javascript:btn_deleteTable('table" + leftSeq
			+ "','" + leftSeq + "');\"><td class=\"btn2\" name=\"btn_delete\">Delete</td></a>\n";
	oCell1 = oCell1 + "			<td class=\"btn2_right\"></td>\n";
	oCell1 = oCell1 + "			</tr>\n";
	oCell1 = oCell1 + "			</table>\n";
	oCell1 = oCell1 + "		</td>\n";
	oCell1 = oCell1 + "	</tr>\n";
	
	oCell1 = oCell1 + "	<tr class=\"h23\">\n";
	oCell1 = oCell1 + "		<td>&nbsp;</td>\n";
	oCell1 = oCell1 + "		<td>Remark(s)</td>\n";
	oCell1 = oCell1 + "  	<td colspan=\"3\" class=\"stm\">&nbsp;<textarea name=\"diff_rmk__"+ leftSeq
			+ "\" style=\"width:300;height:40\" class=\"textarea\" >"+eval("formObj2.diff_rmk__"+rightSeq).value+"</textarea></td>\n";
	oCell1 = oCell1 + "			</tr>\n";	
	
	oCell1 = oCell1 + "	<tr class=\"height_10\"><td colspan=\"8\"></td></tr>\n";
	oCell1 = oCell1 + "</table>\n";

	dyntbl1.innerHTML = oCell1;
}

function updateCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;

	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;

	if (eval("formObj2.cntr_no__" + rightSeq).value != null && eval("formObj2.cntr_no__" + rightSeq).value != '')
		eval("formObj.cntr_no__" + leftSeq).value = eval("formObj2.cntr_no__" + rightSeq).value;
	
	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value = eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	
	if (eval("formObj2.cmdt_cd__" + rightSeq).value != null && eval("formObj2.cmdt_cd__" + rightSeq).value != '')
		eval("formObj.cmdt_cd__" + leftSeq).value = eval("formObj2.cmdt_cd__" + rightSeq).value;
	
	if (eval("formObj2.cmdt_desc__" + rightSeq).value != null && eval("formObj2.cmdt_desc__" + rightSeq).value != '')
		eval("formObj.cmdt_desc__" + leftSeq).value = eval("formObj2.cmdt_desc__" + rightSeq).value;

	var cdoTemp = null;
	var fdoTemp = null;
	if (eval("formObj2.min_temp__" + rightSeq).value != null && eval("formObj2.min_temp__" + rightSeq).value != '') {
		if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value == "C") { 
			cdoTemp = eval("formObj2.temperature1__" + rightSeq).value + eval("formObj2.min_temp__" + rightSeq).value;
			fdoTemp = calcTemperature( eval("formObj2.temperature1__" + rightSeq).value + eval("formObj2.min_temp__" + rightSeq).value, "F");

			if (cdoTemp.substring(0, 1) == "-") {
				eval("formObj.temperature1__" + rightSeq).selectedIndex = 0;
				eval("formObj.cdo_temp__" + leftSeq).value = eval("formObj2.min_temp__" + rightSeq).value;
			} else
				eval("formObj.temperature1__" + rightSeq).selectedIndex = 1;
			if (fdoTemp.toString().substring(0, 1) == "-") {
				eval("formObj.temperature2__" + rightSeq).selectedIndex = 0;
				eval("formObj.fdo_temp__" + leftSeq).value = parseFloat(String(fdoTemp).replace('-','')).toFixed(1);
			} else
				eval("formObj.temperature2__" + rightSeq).selectedIndex = 1;
		} else {
			eval("formObj.cdo_temp__" + leftSeq).value = calcTemperature( eval("formObj2.min_temp__" + rightSeq).value, "C");
			eval("formObj.fdo_temp__" + leftSeq).value = eval("formObj2.min_temp__" + rightSeq).value;
			
//			eval("formObj.cdo_temp__" + leftSeq).value = calcTemperature(
//					eval("formObj2.temperature1__" + rightSeq).value
//							+ eval("formObj2.min_temp__" + rightSeq).value, "C");
//			eval("formObj.fdo_temp__" + leftSeq).value = eval("formObj2.temperature1__"
//					+ rightSeq).value
//					+ eval("formObj2.min_temp__" + rightSeq).value;
			
//			cdoTemp, fdoTemp 변수가 정의 되었으나, 값이 들어가지 않아 아래 부분에서는 필요가 없어 막음.
//			if (cdoTemp.substring(0, 1) == "-") {
//				eval("formObj.temperature1__" + rightSeq).selectedIndex = 0;
//
//				eval("formObj.cdo_temp__" + leftSeq).value = eval("formObj2.min_temp__"
//						+ rightSeq).value;
//			} else
//				eval("formObj.temperature1__" + rightSeq).selectedIndex = 1;
//			if (fdoTemp.toString().substring(0, 1) == "-") {
//				eval("formObj.temperature2__" + rightSeq).selectedIndex = 0;
//				eval("formObj.fdo_temp__" + leftSeq).value = calcTemperature(
//						eval("formObj2.temperature1__" + rightSeq).value
//								+ eval("formObj2.min_temp__" + rightSeq).value,
//						"F");
//			} else
//				eval("formObj.temperature2__" + rightSeq).selectedIndex = 1;
		}
	}

	if (eval("formObj2.min_temp_ut_cd__" + rightSeq).value != null && eval("formObj2.min_temp_ut_cd__" + rightSeq).value != '') {
		for ( var j = 0; j < eval("formObj.temperature2__" + leftSeq).length; j++) {
			if (eval("formObj.temperature2__" + leftSeq)[j].value == eval("formObj2.min_temp_ut_cd__" + rightSeq).value) {
				eval("formObj.temperature2__" + leftSeq).selectedIndex = j;
				break;
			}
		}
	}

	if (eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value != null && eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value != '') {
		for ( var k = 0; k < eval("formObj.pwr_spl_cbl_flg__" + leftSeq).length; k++) {
			if (eval("formObj.pwr_spl_cbl_flg__" + leftSeq)[k].value == eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value) {
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex = k;
				break;
			}
			if("Y"==eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value){
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex = 0;
			} else {
				eval("formObj.pwr_spl_cbl_flg__" + leftSeq).selectedIndex = 1;				
			}
		}
	}

	if (eval("formObj2.vent_rto__" + rightSeq).value != null && eval("formObj2.vent_rto__" + rightSeq).value != '')
		eval("formObj.vent_rto__" + leftSeq).value = eval("formObj2.vent_rto__" + rightSeq).value;
	
	//ventilation_alpscopy__ 를 사용 하는거에 주의 
	if (eval("formObj2.ventilation_alpscopy__" + rightSeq).value != null && eval("formObj2.ventilation_alpscopy__" + rightSeq).value != '')
		eval("formObj.cntr_vent_tp_cd__" + leftSeq).value = eval("formObj2.ventilation_alpscopy__" + rightSeq).value;

	if (eval("formObj2.diff_rmk__" + rightSeq).value != null && eval("formObj2.diff_rmk__" + rightSeq).value != '')
		eval("formObj.diff_rmk__" + leftSeq).value = eval("formObj2.diff_rmk__" + rightSeq).value;

	if (eval("formObj2.clng_tp_cd__" + rightSeq).value != null && eval("formObj2.clng_tp_cd__" + rightSeq).value != '') {
		if("Chilled"==eval("formObj2.clng_tp_cd__" + rightSeq).value){
			eval("formObj.clng_tp_cd__" + leftSeq).value = 'C';
		} else if("Frozen"==eval("formObj2.clng_tp_cd__" + rightSeq).value){
			eval("formObj.clng_tp_cd__" + leftSeq).value = 'F';
		} else if("Fresh"==eval("formObj2.clng_tp_cd__" + rightSeq).value){
			eval("formObj.clng_tp_cd__" + leftSeq).value = 'S';
		}
//		eval("formObj.clng_tp_cd__" + leftSeq).value = eval("formObj2.clng_tp_cd__" + rightSeq).value;
	}
	
	if (eval("formObj2.humid_no__" + rightSeq).value != null && eval("formObj2.humid_no__" + rightSeq).value != '')
		eval("formObj.humid_no__" + leftSeq).value = eval("formObj2.humid_no__" + rightSeq).value;
}

function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj = document.form;
	var formObj2 = document.form2;
	var tmp = eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color = "blue"
	} else {
		tmp.style.color = "#606060";
	}	
}

function compareCntr(leftSeq, rightSeq) {
	var formObj = document.form;
	var formObj2 = document.form2;
	var clngtpcdv = "";
	setCntrDiffCheckColor(eval("formObj.cntr_no__" 			+ leftSeq).value, eval("formObj2.cntr_no__" 		+ rightSeq).value, ("formObj2.cntr_no__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 	+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 	+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_cd__" 			+ leftSeq).value, eval("formObj2.cmdt_cd__" 		+ rightSeq).value, ("formObj2.cmdt_cd__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cmdt_desc__" 		+ leftSeq).value, eval("formObj2.cmdt_desc__" 		+ rightSeq).value, ("formObj2.cmdt_desc__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.temperature1__" 	+ leftSeq).value, eval("formObj2.temperature1__" 	+ rightSeq).value, ("formObj2.temperature1__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.cdo_temp__" 		+ leftSeq).value, eval("formObj2.min_temp__" 		+ rightSeq).value, ("formObj2.min_temp__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.pwr_spl_cbl_flg__" 	+ leftSeq).value, eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value, ("formObj2.pwr_spl_cbl_flg__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.vent_rto__" 		+ leftSeq).value, eval("formObj2.vent_rto__" 		+ rightSeq).value, ("formObj2.vent_rto__" 			+ rightSeq));
	if ("Chilled"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "C";
	} else if ("Frozen"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "F";
	} else if ("Fresh"==eval("formObj2.clng_tp_cd__"+ rightSeq).value){
		clngtpcdv = "S";
	}
	setCntrDiffCheckColor(eval("formObj.clng_tp_cd__" 		+ leftSeq).value, clngtpcdv, ("formObj2.clng_tp_cd__" 		+ rightSeq));
	//setCntrDiffCheckColor(eval("formObj.clng_tp_cd__" 		+ leftSeq).value, eval("formObj2.clng_tp_cd__" 		+ rightSeq).value, ("formObj2.clng_tp_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.humid_no__" 		+ leftSeq).value, eval("formObj2.humid_no__" 		+ rightSeq).value, ("formObj2.humid_no__" 			+ rightSeq));
	
//	if (eval("formObj.cntr_no__" + leftSeq).value != eval("formObj2.cntr_no__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_no__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.cmdt_cd__" + leftSeq).value != eval("formObj2.cmdt_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.cmdt_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.cmdt_desc__" + leftSeq).value != eval("formObj2.cmdt_desc__" + rightSeq).value) {
//		var tmp = eval("formObj2.cmdt_desc__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.temperature1__" + leftSeq).value != eval("formObj2.temperature1__" + rightSeq).value) {
//		var tmp = eval("formObj2.temperature1__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.cdo_temp__" + leftSeq).value != eval("formObj2.min_temp__" + rightSeq).value) {
//		var tmp = eval("formObj2.min_temp__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.temperature2__" + leftSeq).value != eval("formObj2.min_temp_ut_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.min_temp_ut_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.pwr_spl_cbl_flg__" + leftSeq).value != eval("formObj2.pwr_spl_cbl_flg__" + rightSeq).value) {
//		var tmp = eval("formObj2.pwr_spl_cbl_flg__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.vent_rto__" + leftSeq).value != eval("formObj2.vent_rto__" + rightSeq).value) {
//		var tmp = eval("formObj2.vent_rto__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.clng_tp_cd__" + leftSeq).value != eval("formObj2.clng_tp_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.clng_tp_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.humid_no__" + leftSeq).value != eval("formObj2.humid_no__" + rightSeq).value) {
//		var tmp = eval("formObj2.humid_no__" + rightSeq);
//		tmp.style.color = "blue";
//	}
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

	for ( var i = 0; i < formObj.elements.length; i++) {
		var objNm = (formObj.elements[i].name).split("__");
		if (objNm[0] == "cntr_seq") {
			formObj.elements[i].value = seq++;
		}
	}
}

function btn_delete(tableId, seq) {
	var formObj = document.form;
	doSaveCopy();
	for (var i=1; i<sheetObjects[0].RowCount+1; i++) {
		if (sheetObjects[0].CellValue(i, "rc_seq") == eval("formObj.rc_seq__" + seq).value) {
			sheetObjects[0].RowStatus(i) = "D";
			break;
		}
	}
	btn_deleteTable(tableId);
}


function calcTemperature(val, dir) {
	var ret = 0;
	if (val.indexOf("+") != -1)
		val = val.substring(1, val.length);
	if (dir == "C") {
		ret = roundXL(((5 * parseFloat(val)) - 160) / 9, 1);
	} else {
		ret = roundXL((9 / 5) * parseFloat(val) + 32, 1);
	}
	return ret;
}

function changeTemperature(obj, seq) {
	var formObj = document.form;
	var temp1 = eval("formObj.temperature1__" + seq);
	var temp2 = eval("formObj.temperature2__" + seq);
	var cdoV = eval("formObj.cdo_temp__" + seq);
	var fdoV = eval("formObj.fdo_temp__" + seq);
	
	// cdoV값이 널일경우 변환을 하지 않는다.
	if (cdoV.value == "") {
		fdoV.value = "";
		return;
	}
	
	if (temp1.value.indexOf("-") == -1)
		temp1.value = "";
	else
		temp1.value = "-";
	if (temp2.value.indexOf("-") == -1)
		temp2.value = "";
	else
		temp2.value = "-";

	if (obj.name == "temperature1__" + seq || obj.name == "cdo_temp__" + seq) {
		var fdoTemp = calcTemperature(temp1.value + cdoV.value, "F");
		fdoV.value = fdoTemp;
		cdoV.value = temp1.value + cdoV.value;
	} else {
		var cdoTemp = calcTemperature(temp2.value + fdoV.value, "C");
		cdoV.value = cdoTemp;
		fdoV.value = temp2.value + fdoV.value;
	}

	if (cdoV.value.indexOf("-") != -1) {
		temp1.selectedIndex = 0;
		cdoV.value = cdoV.value.substring(1, cdoV.value.length);
	} else {
		temp1.selectedIndex = 1;
	}

	if (fdoV.value.indexOf("-") != -1) {
		temp2.selectedIndex = 0;
		fdoV.value = fdoV.value.substring(1, fdoV.value.length);
	} else {
		temp2.selectedIndex = 1;
	}
//	obj.value = makeComma(obj.value);
}

function makeComma(srcValue) {
	var arrVal = srcValue.split(".");

	if (arrVal.length > 1) {
		srcValue = arrVal[0] + "." + ComRpad(arrVal[1], 3, "0");
	} else {
		srcValue = arrVal[0] + ".0";
	}
	return srcValue;
}

function roundXL(n, digits) {
	if (digits >= 0)
		return parseFloat(n.toFixed(digits));
	digits = Math.pow(10, digits);
	var t = Math.round(n * digits) / digits;
	return parseFloat(t.toFixed(0));
}

function changeCmdtDesc(obj) {
	var formObj = document.form;
	formObj.cmdt_cd.value = obj.value;
	formObj.f_cmd.value = SEARCH01;

	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_07GS.do", FormQueryString(formObj));
	var cmdtDesc = ComGetEtcData(sXml, "cmdt_desc");
	var objSeq = (obj.name).split("__");
	if (cmdtDesc == "") {
		var cmdtCdObj = eval("formObj.cmdt_cd__" + objSeq[1]);
		var cmdtDescObj = eval("formObj.cmdt_desc__" + objSeq[1]);
		cmdtCdObj.value = "";
		cmdtDescObj.value = "";
	} else {
		var cmdtDescObj = eval("formObj.cmdt_desc__" + objSeq[1]);
		cmdtDescObj.value = cmdtDesc;
	}
}

function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id = obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value = obj_id;
	}
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
