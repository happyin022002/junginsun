﻿﻿﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_04.js
 *@FileTitle : e-Booking & SI Process Detail(M&D)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.16
 *@LastModifier : 전용진 
 *@LastVersion : 1.0
 * 2009.06.16 전용진
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 * 2010.10.12 이일민 upload 시 발생하는 스크립트 오류 수정
 * 2010.10.20 이일민 [CHM-201006496-01] M&D No of PKG/CNTR Copy의 버그 수정 요청
 * 2010.10.21 이일민 [CHM-201006499-01] Split 01-M&D Tab-Export/Import Info의 E/L No Validation 로직 추가
 * 2010.10.22                           2010.10.25 라이브 반영을 위해 1756라인,2968라인 임시 블럭 주석 처리
 * 2010.10.27                           2010.10.25 라이브 반영을 위해 1756라인,2968라인 임시 블럭 주석 제거
 * 2011.06.20,23 김진승 [CHM-201111528]R9 CNTR의 BKG UPDATE 요청 - R4, R5부분 변경; R9, 45HR에서 40HR로 매핑 처리. 
 * 2011.07.05 김진승 [CHM-201111968-01][ALPS] Freight Term Copy 보완 (e-S/I)
 * 2011.12.06 정선용 [CHM-201114657-01][ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청
 * 2011.12.20 정선용 [CHM-201115077-01][UI_BKG_0361_11] Export/Import information (Turkey) - 터키 Tax ID컬럼 추가
 * 2012.01.09 정선용 [CHM-201215422-01]Export Information Overwriting Issue 해결을 위한 ALPS 로직 보완
 * 2012.01.19 정선용 [CHM-201215642-01]e-Booking & SI Process 로직 보완 요청
 * 2012.02.02 변종건 [CHM-201215949-01]e-Booking & SI upload 화면의 USA export 정보 변경 요청
 * 2012.02.28 정선용 [CHM-201215444-01][웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.08.03 이재위 [CHM-201219302] Split 02-[M&D Export&Import Information] Israel VAT ID추가
 * 2012.10.16 이재위 [CHM-201220620] Split 02-[M&D Export/Import Information] Lebanon의 VAT ID추가
 * 2012.11.05 김현화 [CHM-201220991] Split 02-O5 추가 관련 프로그램 수정- O4 와 동일하게 처리.
 * 2012.11.15 김현화 [CHM-201220707] e-booking & e-si upload 화면에 P.O. NO. 입력 필수 validation 및 경고 문구 추가
 * 2012.12.11 김현화 [CHM-201221769] WEB 면장 UPDATE  로직 변경 요청(Export info. Korea)
 * 2012.12.17 김현화 [CHM-201221669] Exception 체크 하지 않을 시, B/L Preview에 행 삭제 요청 :USA, CANADA 
 *                                 aes_expt_ctnt, ndr_ref_ctnt 항상 입력 가능하도록 수정.
 * 2013.01.07 김현화 [CHM-201222209] BRAZIL TAX ID 추가 요청
 * 2013.05.20 임재관 [CHM-201324732] Split 01-한국지역 WHF 신고방법 간소화
 * 2014.01.13 최도순 [CHM-201433292] e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
 * =========================================================*/
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
 * @class esm_bkg_0229_04 : esm_bkg_0229_04 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_04() {
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

var isCopy = "false";

var div1sheet1 = null;
var div2sheet1 = null;
var div3sheet1 = null;
var div3sheet2 = null;
var div3sheet3 = null;
var div4sheet1 = null;
var div4sheet2 = null;
var div5sheet1 = null;
var div6sheet1 = null;
var div7sheet1 = null;
var div7sheet2 = null;
var div8sheet1 = null;
var div8sheet2 = null;
var div10sheet1 = null;
var sheetObject1 = null;
var innerPackageSheet = null;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function isElementExsits(id){
	var element =  document.getElementById(id);
	if (typeof(element) != 'undefined' && element != null) {
		return true;
	} else {
		return false;
	}
}


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	/*******************************************************/
	var formObject = document.form;

	var sheetIdx = 0;
	if(Number(ComGetObjValue(formObject.kr_xpt_lic_cnt)) > 0) div1sheet1 = sheetObjects[sheetIdx++];
	if(Number(ComGetObjValue(formObject.id_xpt_lic_cnt)) > 0) div8sheet1 = sheetObjects[sheetIdx++];
	if(Number(ComGetObjValue(formObject.kr_xpt_lic_cnt)) > 0) div2sheet1 = sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.id_xpt_lic_cnt)) > 0) div8sheet2 = sheetObjects[sheetIdx++];
    
    if(Number(ComGetObjValue(formObject.xterInnerPackageVOsCnt)) > 0) innerPackageSheet 	= sheetObjects[sheetIdx++];
    div3sheet1 			= sheetObjects[sheetIdx++];
    div3sheet2 			= sheetObjects[sheetIdx++];
    div3sheet3 			= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.xterCntrPoNoVOsCnt)) > 0) div4sheet1 	= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.xterPoDtlVOsCnt)) > 0) div4sheet2 	= sheetObjects[sheetIdx++]; 
    div5sheet1 			= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.xterRqstNoVOsCnt)) > 0) div6sheet1 	= sheetObjects[sheetIdx++];
    div7sheet1 			= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.xterKrWhfBlExptInfoVOsCnt)) > 0) div7sheet2 	= sheetObjects[sheetIdx++];    
    div9sheet1 			= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObject.xterRefDtlVOsCnt)) > 0) div9sheet2 	= sheetObjects[sheetIdx++]; 
    div10sheet1 		= sheetObjects[sheetIdx++];
    sheetObject1 		= sheetObjects[sheetIdx++];
   
    
	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_cancelcopydata":
				parent.document.form.mndTabCancel.value = "Y";
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
				isCopy = "false";
				top.isCopyAllRequested = false;
				break;
	
			case "btn_datacopytoalps":
			 	if (isCopy == "false") {
					dataCopy();
			 	}
				break;
	
			case "btn_datacopyfromcm":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
				break;
	
			case "btn_upload":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
				
			case "btn_find_package":
				comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value);
				break;
			
			case "btn_copy":
				doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
				break;
				
			case "btn_BLRider":
				showBlRider();
				break;
	
			case "btn_ExportInfo"://	
				showXptLicNo();
				break;
			
			case "btn_POOtherNo":
				showPoOther();
				break;
				
			case "btn_Surcharge":
				showSurcharge();
				break;				
				
			case "btn_ExportInfo2":
				showXptLicNo2();
				break;
				
			case "btn_POOtherNo2":
				showPoOther2();
				break;
				
			case "btn_MiscInfo2":
				showMiscDesc();
				break;
				
			case "btn_InnerPackage2":				
				showInnerPackage();				
				break;
				
			case "btn_BLRider2":
				showBlRider2();
				break;
				
			case "btn_Surcharge2":
				showSurcharge2();
				break;				
			
			case "btn_RefDtl":
				showRefDtl();
				break;		
			
			case "btn_RefDtl2":
				showRefDtl2();
				break;	
				
			case "btn_Calendar": //calender button
				var cal = new ComCalendar();
				cal.select(formObject.lcdt, 'yyyy-MM-dd');
				break;
				
			case "btn_krRowAdd":
				var newRow = div1sheet1.DataInsert(-1);
				div1sheet1.CellValue(newRow, "bkg_no") 		= formObject.bkg_no.value;
				div1sheet1.CellValue(newRow, "io_bnd_cd") 	= "O";	
				div1sheet1.CellValue(newRow, "xpt_imp_seq") = "";//없는 row는 sql에서 재 계산 
				div1sheet1.CellValue(newRow, "cnt_cd") 		= "KR";
				div1sheet1.CellValue(newRow, "wgt_ut_cd") 	= "KGS";
				
				div1sheet1.CellValue2(div1sheet1.LastRow, 1) = "";
				div1sheet1.CellValue2(div1sheet1.LastRow, "ts_ref_no") = "TOTAL";
				div1sheet1.CellAlign(div1sheet1.LastRow, "ts_ref_no") = daCenter;
				break; 
            
			case "btn_krRowDelete":
				if (!ComShowCodeConfirm("COM12188")) return;
				var rCnt = div1sheet1.Rowcount+1;
			    var chkCnt=0
				for(i=1;i<rCnt;i++){
					if(div1sheet1.CellValue(i, "check") == 1){
						chkCnt++	
					}
				}
			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
				for(i=rCnt;i>0;i--){
					if(div1sheet1.CellValue(i, "check") == 1){
						div1sheet1.RowDelete(i, false);
					}
				}			    
				break;
				
			case "btn_idRowAdd":
				var newRow = div8sheet1.DataInsert(-1);
				div8sheet1.CellValue(newRow, "ibflag") 		= "I";
				div8sheet1.CellValue(newRow, "bkg_no") 		= formObject.bkg_no.value;
				div8sheet1.CellValue(newRow, "io_bnd_cd") 	= "O";
				div8sheet1.CellValue(newRow, "xpt_imp_seq") = "";//없는 row는 sql에서 재 계산 
				div8sheet1.CellValue(newRow, "cnt_cd") 		= "ID";
				break; 
				
			case "btn_idRowDelete":
				if (!ComShowCodeConfirm("COM12188")) return;
				var rCnt = div8sheet1.Rowcount+1;
			    var chkCnt=0
				for(i=1;i<rCnt;i++){
					if(div8sheet1.CellValue(i, "check") == 1){
						chkCnt++	
					}
				}
			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
				for(i=rCnt;i>0;i--){
					if(div8sheet1.CellValue(i, "check") == 1){
						div8sheet1.RowDelete(i, false);
					}
				}			    
				break;
				
			case "btn_Po_Add":
				var newRow = div3sheet2.DataInsert(-1);
				div3sheet2.CellValue(newRow, "bkg_no") = formObject.bkg_no.value;
				div3sheet2.CellValue(newRow, "cntr_no") = formObject.cntr_no.value;
				break;      
			
			case "btn_Po_Delete":
				if (!ComShowCodeConfirm("COM12188")) return;
				var rCnt = div3sheet2.Rowcount+1;
			    var chkCnt=0
				for(i=1;i<rCnt;i++){
					if(div3sheet2.CellValue(i, "check") == 1){
						chkCnt++	
					}
				}
			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
				ComRowHideDelete(div3sheet2, "check");
				break;
				
			case "btn_Clz_Add":
				var newRow = div10sheet1.DataInsert(-1);
				div10sheet1.CellValue(newRow, "bkg_no") = formObject.bkg_no.value;
				div10sheet1.CellValue(newRow, "cluz_lck_tp_cd") ="D";
				break;      
			
			case "btn_Clz_Delete":
				if (!ComShowCodeConfirm("COM12188")) return;
				div10sheet1.RowStatus(div10sheet1.SelectRow) = "D";
				div10sheet1.RowHidden(div10sheet1.SelectRow) = true;
				break;
				
			case "btn_vinNo":
				var bkg_no = formObject.bkg_no.value;
				var vin_no_list = formObject.exp_vin_ctnt.value;
				var url = "ESM_BKG_0362.do?bkg_no=" +bkg_no+ "&vin_no_list=" + encodeURIComponent(vin_no_list)+ "&ui_id=ESM_BKG_0361";
				//ComOpenWindow(url, "ESM_BKG_0697", "width=300,height=280", false);이거아님
				ComOpenWindowCenter(url, "ESM_BKG_0362", 300, 400, true)				
				break;
			
			case "btn_vinNo2":
				var bkg_no = formObject.bkg_no.value;
				var vin_no_list = formObject.exp_vin_ctnt2.value;
				var url = "ESM_BKG_0362.do?bkg_no=" +bkg_no+ "&vin_no_list=" + encodeURIComponent(vin_no_list)+ "&ui_id=ESM_BKG_0229";
				//ComOpenWindow(url, "ESM_BKG_0697", "width=300,height=280", false);이거아님
				ComOpenWindowCenter(url, "ESM_BKG_0362", 300, 400, true)				
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
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetIdx = 0;
	var formObj = document.form;
	// alps kr export
	if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0) div1sheet1 = sheetObjects[sheetIdx++];
	// alps indonesia export
	if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0) div8sheet1 = sheetObjects[sheetIdx++];
	// e-svc kr export
	if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0) div2sheet1 = sheetObjects[sheetIdx++];
	// e-svc e-svc indonesia export
	if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0) div8sheet2 = sheetObjects[sheetIdx++];
	
    //xterInnerPackageVOsCnt	
	if(Number(ComGetObjValue(formObj.xterInnerPackageVOsCnt)) > 0) innerPackageSheet 	= sheetObjects[sheetIdx++];
    
    // alps po no
    div3sheet1 			= sheetObjects[sheetIdx++];
    div3sheet2 			= sheetObjects[sheetIdx++];
    div3sheet3 			= sheetObjects[sheetIdx++];    
    // e-svc po no
    if(Number(ComGetObjValue(formObj.xterCntrPoNoVOsCnt)) > 0) div4sheet1 	= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObj.xterPoDtlVOsCnt)) > 0) div4sheet2 	= sheetObjects[sheetIdx++];
        
    // alps b/l rider
    div5sheet1 			= sheetObjects[sheetIdx++];
    // e-svc b/l rider
    if(Number(ComGetObjValue(formObj.xterRqstNoVOsCnt)) > 0) div6sheet1 	= sheetObjects[sheetIdx++];
    
    // alps surcharge
    div7sheet1			= sheetObjects[sheetIdx++];
    // e-svc surcharge
    if(Number(ComGetObjValue(formObj.xterKrWhfBlExptInfoVOsCnt)) > 0) div7sheet2 	= sheetObjects[sheetIdx++];
    
    //shipId
    div9sheet1			= sheetObjects[sheetIdx++];
    if(Number(ComGetObjValue(formObj.xterRefDtlVOsCnt)) > 0) div9sheet2 	= sheetObjects[sheetIdx++];
    
    //clause lock
    div10sheet1			= sheetObjects[sheetIdx++];
    
    // internal sheet for save
    sheetObject1 		= sheetObjects[sheetIdx++];
    
    var comboLen = comboObjects.length;
    
    for(var k=0;k<comboLen;k++){
        initCombo(comboObjects[k],k+1);       
    }

	doActionIBSheet(sheetObject1, formObj, IBSEARCH);

	initControl();
	
	comboObjects[2].Enable = false;
	comboObjects[2].Code = document.form.aes_expt_id_tmp.value;

	// 추가 service call 삭제
//	makeCombo();
}

function initControl() {
	var formObject = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerFormat("keypress", 		"obj_KeyPress", formObject); //- 키보드 입력할때
    axon_event.addListenerFormat("beforeactivate", 	"obj_activate", formObject);
//	axon_event.addListenerForm("blur", 		 "form1_onBlur", 	formObject);
	axon_event.addListenerForm("change",	 "form1_onChange", 	formObject);
	axon_event.addListenerForm("deactivate", "form1_blur", 		formObject);

	applyShortcut();
}

/**
 * 콤보 초기설정값
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {	
    switch(comboObj.id) {
    	case "ndr_ref_id": 
    		var i=0;	            
    	    comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.|NDR1",            "NDR1");
            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000|NDR2",          "NDR2");
           
            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or|NDR3 ",           "NDR3");
            comboObj.InsertItem(i++, "|commercial use|NDR3",           "NDR3");
            
//            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under |NDR4", "NDR4");
//            comboObj.InsertItem(i++, "|any of tariff item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set|NDR4", "NDR4");
//            comboObj.InsertItem(i++, "|out in the schedule to the Customs Tariff|NDR4", "NDR4");
            
            comboObj.InsertItem(i++, "NDR4|Goods exported from Canada on a temporary basis by using ATA carnet numbers are required as |NDR4", "NDR4");
            comboObj.InsertItem(i++, "|part of the NDR|NDR4", "NDR4");
            
//            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation|NDR5",        "NDR5");
//            comboObj.InsertItem(i++, "|under tariff item No. 980l.10.00 in the List of Tariff Provisions set out in the schedule to the|NDR5",        "NDR5");
//            comboObj.InsertItem(i++, "|to the Customs Tariff|NDR5",        "NDR5");
            
            comboObj.InsertItem(i++, "NDR5|Goods that were temporarily imported and documented on a Form E29B, Temporary Admission|NDR5",        "NDR5");
            comboObj.InsertItem(i++, "|Permit, and are subsequently exported; E29B numbers are required as part of the NDR.|NDR5",        "NDR5");
            
            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international|NDR6",       "NDR6");
            comboObj.InsertItem(i++, "|commercial transportation of goods|NDR6",       "NDR6");
            
            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use|NDR7",         "NDR7");
            
            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances|NDR8",         "NDR8");

//            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported|NDR9",         "NDR9");
//            comboObj.InsertItem(i++, "|in transit through Canada en route to a non-Canadian destination|NDR9",         "NDR9");
            
            comboObj.InsertItem(i++, "NDR9|NDR9 is no longer in use.|NDR9",         "NDR9");

//            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for|NDR10",         "NDR10");
//            comboObj.InsertItem(i++, "|the purpose of being transshipped through another country to another Canadian destination|NDR10",         "NDR10");
            
            comboObj.InsertItem(i++, "NDR10|Goods exported for repair or warranty repair regardless of value that will be returned to Canada.|NDR10",         "NDR10");

//		            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada|NDR11",         "NDR11");
            
            comboObj.InsertItem(i++, "NDR11|Goods imported for repair or addition, which are subsequently exported, where the value of|NDR11",         "NDR11");
            comboObj.InsertItem(i++, "|the repair or addition is less than CAN $2,000 or is covered by a warranty.|NDR11",         "NDR11");
            
            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier|NDR12",         "NDR12");
            
            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export from a bonded|NDR13",         "NDR13");
            comboObj.InsertItem(i++, "|warehouse or sufferance warehouse|NDR13",         "NDR13");
            
            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned to Canada within|NDR14",         "NDR14");
            comboObj.InsertItem(i++, "|12 months after the date of exportation|NDR14",         "NDR14");
            
            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to an emergency|NDR15",         "NDR15");
            comboObj.InsertItem(i++, "|will report orally according to section 15 of the export regulations|NDR15",         "NDR15");

//            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export|NDR16",         "NDR16");
            
            comboObj.InsertItem(i++, "NDR16|Other (this includes non-restricted goods used for unique situations). For this category,|NDR16",         "NDR16");
            comboObj.InsertItem(i++, "|the reason for the NDR must be pre-authorized by the CBSA.|NDR16",         "NDR16");
            comboObj.Code = "";
            comboObj.SetColWidth("50|550|0");
            comboObj.DropHeight= 350;
            comboObj.ColBackColor(0) = "#eeeeee";
            break;

	    default:
	    	comboObj.MultiSelect = false;
			comboObj.UseCode = true;
			comboObj.LineColor = "#ffffff";
			comboObj.SetColAlign("left|left");
			comboObj.MultiSeparator = "|";
	    	break;
    }
}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * 
 * @param {IBMultiCombo}
 *            combo_obj IBMultiCombo Object
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
	case "div1sheet1":      //alps korea export licens no
		//with (sheetObj) {
			// 높이 설정
			sheetObj.style.height = 140;
	
			//전체 너비 설정
			sheetObj.SheetWidth = 500;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 5, 100);
	
			var HeadTitle = "|||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package";
			var headCount = ComCountHeadTitle(HeadTitle);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다 
			sheetObj.InitHeadMode(true, true, false, true, false, false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
						
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	false,	"ibflag");
			sheetObj.InitDataProperty(0,	cnt++,	dtSeq,			20,		daCenter,	false,	"seq");
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,		25,		daCenter,	false,	"check",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"bkg_no", 			true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"io_bnd_cd",		true,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"xpt_imp_seq",		true,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"cnt_cd",			false,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"xpt_lic_no",		false,	"",      dfNone,		0,		true,		true, 15);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"ts_ref_no",		false,	"",      dfNone,		0,		true,		true, 18);
			sheetObj.InitDataProperty(0, cnt++ , dtAutoSum,		50,		daRight,	false,	"pck_qty",			true,	"",      dfInteger,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"pck_tp_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,	"mf_wgt",			true,	"",      dfFloat,		3,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	false,	"wgt_ut_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,		40,		daRight,	false,	"divd_seq",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	false,	"sam_pck_id",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daRight,	false,	"sam_pck_qty",		false,	"",      dfInteger,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtPopupEdit,	55,		daCenter,	false,	"sam_pck_tp_cd",	false,	"",      dfNone,		0,		true,		true);
			
			
			//sheetObj.InitUserFormat(0, "xpt_lic_no", "AAA-AA-AA-AAAAAAA-A", "-" );
			sheetObj.InitDataValid(0, "xpt_lic_no", vtEngUpOther, "0123456789");
			sheetObj.InitDataCombo(0, "wgt_ut_cd", " |KGS|LGB", " |KGS|LGB");
			sheetObj.InitDataCombo(0, "divd_seq", " |1|2|3|4", " |1|2|3|4");
			sheetObj.InitDataCombo(0, "sam_pck_id", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", " |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z");
		
			sheetObj.ShowButtonImage = 2;	
		//}
		break;

	case "div2sheet1":      //esvc korea export licens no
		//with (sheetObj) {
			// 높이 설정
			sheetObj.style.height = 140;
	
			//전체 너비 설정
			sheetObj.SheetWidth = 500;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 5, 100);
	
			var HeadTitle = "||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package";
			var headCount = ComCountHeadTitle(HeadTitle);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
						
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0,	cnt++,	dtHiddenStatus,	20,		daCenter,	false,	"ibflag2");
			sheetObj.InitDataProperty(0,	cnt++,	dtSeq,			20,		daCenter,	false,	"seq2");
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"bkg_no2", 			true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"io_bnd_cd2",		true,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"xpt_imp_seq2",		true,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,		80,		daCenter,	false,	"cnt_cd2",			false,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"xpt_lic_no2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daLeft,		false,	"ts_ref_no2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtAutoSum,		50,		daRight,	false,	"pck_qty2",			true,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"pck_tp_cd2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,	"mf_wgt2",			true,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"wgt_ut_cd2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			40,		daRight,	false,	"divd_seq2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"sam_pck_id2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daRight,	false,	"sam_pck_qty2",		false,	"",      dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"sam_pck_tp_cd2",	false,	"",      dfNone,		0,		false,		false);
		//}
		break;
		
	case "sheet1": // bkg_xpt_imp_lic에 insert하기 위한 sheet
		//with (sheetObj) {
			// 높이 설정
			sheetObj.style.height = 0;

			//전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 5, 100);

			var HeadTitle = "ib_flg|seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|Export License Number|Other Reference No.|pck_qty|pck_tp_cd|wgt|wgt_ut_cd"
						+	"|sam_pck_id|sam_pck_qty|sam_pck_tp_cd|divd_flg|divd_seq|divd_pck_qty|divd_pck_tp_cd|divd_wgt|divd_wgt_ut_cd"
						+	"|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt"
						+	"|caed_tp_cd|caed_ctnt|g7_edi_ctnt|b13a_xpt_ctnt|mf_smry_rpt_no|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt"
						+ 	"|mx_shpr_tax_id|mx_cnee_tax_id|mx_ntfy_tax_id|tr_shpr_tax_id|tr_cnee_tax_id|tr_ntfy_tax_id|il_shpr_tax_id|il_cnee_tax_id|il_ntfy_tax_id|lb_shpr_tax_id|lb_cnee_tax_id|lb_ntfy_tax_id|br_shpr_tax_id|br_cnee_tax_id|br_ntfy_tax_id|brz_decl_no|shpr_tax_cpy_desc_flg|cnee_tax_cpy_desc_flg|ntfy_tax_cpy_desc_flg|brz_decl_cpy_desc_flg|vin_ctnt"
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0,	cnt++,	dtStatus,		20,		daCenter,	false,	"ibflag");
			sheetObj.InitDataProperty(0,	cnt++,	dtSeq,			20,		daCenter,	false,	"seq");
			sheetObj.InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"bkg_no", 			false);
			sheetObj.InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"io_bnd_cd",		false,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"xpt_imp_seq",		false,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0,	cnt++,	dtData,			80,		daCenter,	false,	"cnt_cd",			false,	"",		 dfNone,		0,		false,		false);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daCenter,	false,	"xpt_lic_no",		false,	"",      dfNone,		0,		true,		true, 15);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			145,	daCenter,	false,	"ts_ref_no",		false,	"",      dfNone,		0,		true,		true, 18);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			50,		daRight,	false,	"pck_qty",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"pck_tp_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	false,	"mf_wgt",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"wgt_ut_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"sam_pck_id",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"sam_pck_qty",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"sam_pck_tp_cd",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			25,		daCenter,	false,	"divd_flg",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"divd_seq",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"divd_pck_qty",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"divd_pck_tp_cd",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"divd_wgt",			false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	false,	"divd_wgt_ut_cd",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_tp_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_inlnd_trns_no",false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_pta_no1",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_pta_no2",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_pta_dt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_ptu_no",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_ptu_dt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_dwn_no",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_dwn_dt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_expt_id",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"aes_expt_ctnt",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"caed_tp_cd",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"caed_ctnt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"g7_edi_ctnt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"b13a_xpt_ctnt",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"mf_smry_rpt_no",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"cgo_ctrl_no",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"ndr_ref_id",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"ndr_ref_ctnt",		false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"mx_shpr_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"mx_cnee_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"mx_ntfy_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"tr_shpr_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"tr_cnee_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"tr_ntfy_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"il_shpr_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"il_cnee_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"il_ntfy_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"lb_shpr_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"lb_cnee_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"lb_ntfy_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"br_shpr_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"br_cnee_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"br_ntfy_tax_id",	false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"brz_decl_no",	    false,	"",      dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"shpr_tax_cpy_desc_flg", false,	"",  dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"cnee_tax_cpy_desc_flg", false,	"",  dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"ntfy_tax_cpy_desc_flg", false,	"",  dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,		    40,		daCenter,	false,	"brz_decl_cpy_desc_flg", false,	"",  dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++,	dtData,		80,		daCenter,	false,	"vin_ctnt",			false,	"",			dfNone,		0,			false,		false);
		//}
		break;
		
 	case "sheet2": // sheet2 init //inner package
		//with (sheetObj) {
			// 높이 설정
 			sheetObj.style.height = 108;
			// 전체 너비 설정
 			sheetObj.SheetWidth = 350;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 4, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "ibflag|Seq|No|PKG|Level|PKG CD|PKG DESC";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, false, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "mk_seq",			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "mk_sub_seq",		false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "ttl_pck_qty", 	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "ttl_pck_lvl", 	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "ttl_pck_tp_nm", 	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daCenter, false, "ttl_pck_desc", 	false, "", dfNone, 2, true, true);
			
			sheetObj.CountPosition = 0;
		//}
		break;		
		
	case "div3sheet1":      //alps po other no1
		//with (sheetObj) {	
			// 높이 설정
			sheetObj.style.height = 142;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 1, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(10, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle1 = "|Container No.|P/O No.(CNTR)";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			sheetObj.InitDataProperty(0,	cnt++, dtSeq,			20,		daCenter,	false,"seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, "c_cntr_no", 			false, "", dfNone, 0, false, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtData,			100, 	daLeft, 	true, "cust_ref_no_ctnt", 	false, "", dfNone, 0, true, 	true, 50, false);
	
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, 	true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "ref_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "cntr_no");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "pck_qty");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "cntr_mf_wgt");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "meas_qty");
	
			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;	
		//}
		break;
	
	case "div3sheet2":      //alps po other no2
		//with (sheetObj) {	
			// 높이 설정
			sheetObj.style.height = 142;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
			// 자동 트림하여 조회및 저장
			sheetObj.DataAutoTrim = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(15, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle1 = "||P/O No.(byItem)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		20, daCenter, 	true,  "check");
			sheetObj.InitDataProperty(0,	cnt++, dtSeq,			20,	daCenter,	false, "seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			99, daLeft, 	true,  "po_no",			false, "", dfNone, 		0, true, true, 50, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daLeft, 	true,  "itm_no", 		false, "", dfNone, 		0, true, true, 15, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			70, daLeft, 	true,  "itm_desc", 		false, "", dfNone, 		0, true, true, 50, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "pck_qty", 		false, "", dfNullFloat, 3, true, true, 12, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtPopupEdit, 	20, daRight, 	false, "pck_tp_cd", 	false, "", dfNone, 		0, true, true, 2);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "cntr_wgt", 		false, "", dfNullFloat, 3, true, true, 18, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtCombo, 		30, daRight, 	false, "wgt_ut_cd", 	false, "", dfNone, 		0, true, true, 3, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "meas_qty", 		false, "", dfNullFloat, 3, true, true, 12, 	false);
			sheetObj.InitDataProperty(0, cnt++, dtCombo, 		30, daRight, 	false, "meas_ut_cd",	false, "", dfNullFloat, 3, true, true, 3, 	false);
	
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 	daCenter, 	true,  "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 	daCenter, 	true,  "bkg_no");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 	daCenter, 	true,  "ref_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, 	daCenter, 	true,  "cntr_no");
	
			sheetObj.InitDataValid(0, "pck_tp_cd", vtEngUpOther);
			sheetObj.InitDataValid(0, "itm_no", vtNumericOnly);
			sheetObj.InitDataCombo(0, "wgt_ut_cd",  " |KGS|LGB", " |KGS|LGB");
			sheetObj.InitDataCombo(0, "meas_ut_cd", " |CBM|CBF", " |CBM|CBF");
	
			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.DataLinkMouse("pck_tp_cd") = true;
			sheetObj.DataLinkMouse("wgt_ut_cd") = true;
			sheetObj.DataLinkMouse("meas_ut_cd") = true;
			sheetObj.CountPosition = 0;
		//}
		break;

	case "div3sheet3":      //alps po other no3
		//with (sheetObj) {
			// 높이 설정
			sheetObj.style.height = 0;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(7, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "|bkg_no|ref_seq|bl_no|bl_tp|bkg_ref_tp_cd|cust_ref_no_ctnt";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	0, daCenter, true, "ibflag",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "bkg_no",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "ref_seq",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "bl_no",				false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "bl_no_tp",			false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "bkg_ref_tp_cd",		false, "", dfNone, 		0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0, daCenter, true, "cust_ref_no_ctnt",	false, "", dfNone, 		0, true, true);
			sheetObj.CountPosition = 0;
		//}
		break;
		
	case "div4sheet1":      //esvc po other no1
		//with (sheetObj) {	
			// 높이 설정
			sheetObj.style.height = 165;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 0, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(4, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle1 = "|Container No.|P/O No.(CNTR)";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			sheetObj.InitDataProperty(0,	cnt++, dtSeq,			20,		daCenter,	false,"seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			100, 	daLeft, 	true, "cntr_no", 	false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			100,	daLeft, 	true, "po_no", 		false, "", dfNone, 0, true, true, 50, false);
	
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	0, 		daCenter, 	true, "ibflag");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "bkg_no");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "ref_seq");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "cntr_no");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "pck_qty");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "cntr_mf_wgt");
//			InitDataProperty(0, cnt++, dtHidden, 		0, 		daCenter, 	true, "meas_qty");
			sheetObj.CountPosition = 0;	
		//}
		break;
	
	case "div4sheet2":      //esvc po other no2
		//with (sheetObj) {	
			// 높이 설정
			sheetObj.style.height = 165;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
			// 자동 트림하여 조회및 저장
			sheetObj.DataAutoTrim = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(12, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle1 = "|P/O No.(byItem)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0,	cnt++, dtSeq,			20,	daCenter,	false, "seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			99, daLeft, 	true,  "po_no", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daLeft, 	true,  "itm_no", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			70, daLeft, 	true,  "itm_desc", 		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "pck_qty", 		false, "", dfNone, 3, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtPopupEdit, 	20, daRight, 	false, "pck_tp_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "cntr_wgt", 		false, "", dfNone, 3, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daRight, 	false, "wgt_ut_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			65, daRight, 	false, "meas_qty", 		false, "", dfNone, 3, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daRight, 	false, "meas_ut_cd",	false, "", dfNone, 3, true, true);
	
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0,  daCenter, 	true,  "ref_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		0,  daCenter, 	true,  "cntr_no");
			sheetObj.CountPosition = 0;	
		//}
		break;
		
	case "div5sheet1":      //alps b/l rider2
		//with (sheetObj) {			// 높이 설정
			sheetObj.style.height = 182;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(11, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, true, true, false, false)
	
			var HeadTitle = "|File Name|File Size|file_path_rmk|ridr_tp_cd|file_sav_id|img_seq|dcgo_seq|bb_cgo_seq|file_desc|awk_cgo_seq";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtPopup, 175, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
	
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path_rmk");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bb_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_desc");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "awk_cgo_seq");	
			
			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
		//}
		break;		

	case "div6sheet1":      // esvc b/l rider2
		//with (sheetObj) {			// 높이 설정
			sheetObj.style.height = 182;
			// 전체 너비 설정
			sheetObj.SheetWidth = mainTable.clientWidth;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 3, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(14, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, true, true, false, false)
	
			var HeadTitle = "|File Name|File Size|file_path_rmk|ridr_tp_cd|file_sav_id|img_seq|xter_rqst_seq|dcgo_seq|bb_cgo_seq|xter_rqst_no|file_desc|awk_cgo_seq|xter_sndr_id";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtPopup, 175, daLeft, false, "file_nm", false, "", dfNone, 0, false, false);
			sheetObj.InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "file_size", false, "", dfNone, 0, false, false);
	
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_path_rmk");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "ridr_tp_cd");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_sav_id");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "img_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "xter_rqst_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "dcgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "bb_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "xter_rqst_no");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "file_desc");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "awk_cgo_seq");
			sheetObj.InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "xter_sndr_id");	
			
			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.SheetBackColor = sheetObj.RgbColor(248, 248, 248);
			sheetObj.SelectBackColor = sheetObj.RgbColor(236, 246, 247);
			sheetObj.CountPosition = 0;
		//}
		break;		
		
 	case "div7sheet1": // div7sheet1 init // alps Surcharge Adjustment
		//with (sheetObj) {
			// 높이 설정
 			sheetObj.style.height = 185;
			// 전체 너비 설정
 			sheetObj.SheetWidth = 150;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = " | |Exempt Condition| | |사업자등록번호";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"kr_whf_expt_cd",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		false,			"kr_whf_expt_desc",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"kr_whf_expt_appl_flg",		false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,			20,		daCenter,	false,			"radio",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,			"registno",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		false,			"bkg_no",					false,			"",   dfNone, 0,	true,	true);
			
			sheetObj.MultiSelection = false;
			sheetObj.CountPosition = 0;
		//}
		break;		

 	case "div7sheet2": // e-svc Surcharge Adjustment
		//with (sheetObj) {
			// 높이 설정
 			sheetObj.style.height = 90;
			// 전체 너비 설정
 			sheetObj.SheetWidth = 150;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(7, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = " | |Exempt Condition| | |사업자등록번호";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"kr_whf_expt_cd",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		false,			"kr_whf_expt_desc",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"kr_whf_expt_appl_flg",		false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,			20,		daCenter,	false,			"radio",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		true,			"registno",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			50,		daLeft,		false,			"bkg_no",					false,			"",   dfNone, 0,	true,	true);
			
			sheetObj.CountPosition = 0;
		//}
		break;		
		
	case "div8sheet1": // div8sheet1 init // alps indonesia peb no
		//with (sheetObj) {
			// 높이 설정
			sheetObj.style.height = 105;
			// 전체 너비 설정
			sheetObj.SheetWidth = 150;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 2, 100);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "||Seq|||||PEB No|PEB Issue Date|Customs Office|Qualifier";
			var headCount = ComCountHeadTitle(HeadTitle);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(headCount, 0, 0, true);
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtCheckBox,			25,		daCenter,	false,	"check",			false,	"",		dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++, 	dtSeq,				30,		daCenter,	false, 	"seq");
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,			80,		daCenter,	false,	"bkg_no", 			false,	"",		dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,			80,		daCenter,	false,	"io_bnd_cd",		false,	"",		dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,			80,		daCenter,	false,	"xpt_imp_seq",		false,	"",		dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0,	cnt++,	dtHidden,			80,		daCenter,	false,	"cnt_cd",			false,	"",		dfNone,		0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++, 	dtData,				80,		daCenter,	false,	"id_xpt_no",		false,	"",   	dfNone, 	0,		true,		true);
			sheetObj.InitDataProperty(0, cnt++, 	dtPopupEditFormat, 	140, 	daCenter, 	false, 	"id_xpt_no_iss_dt", false, 	"", 	dfDateYmd, 	0, 		true,  		true, 8);
			sheetObj.InitDataProperty(0, cnt++,  dtCombo,            120, 	daCenter, 	false, 	"id_ofc_cd",        false, 	"", 	dfNone,    	0, 		true,  		true);
			sheetObj.InitDataProperty(0, cnt++,  dtCombo,           	80, 	daCenter, 	false, 	"id_decl_cd",       false, 	"", 	dfNone,    	0, 		true, 		true);
			
			sheetObj.InitDataValid   (0, "id_xpt_no", 	vtNumericOnly);
			sheetObj.InitDataCombo   (0, "id_ofc_cd", 	" |BANBA|JKTBA|SRGBA|SUBBA", " |010700|040300|060100|070100", "", "");
			sheetObj.InitDataCombo   (0, "id_decl_cd", 	" |PEB|PKB", " |E|K", "", "");
			sheetObj.PopupImage = "/hanjin/img/btns_calendar.gif";
			sheetObj.ShowButtonImage = 2;
			sheetObj.MultiSelection = false;
		//}
		break;	
		
 	case "div8sheet2": // div8sheet2 init // e-svc indonesia peb no
		//with (sheetObj) {
			// 높이 설정
 			sheetObj.style.height = 105;
			// 전체 너비 설정
 			sheetObj.SheetWidth = 150;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(6, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "|Seq|PEB No|PEB Issue Date|Customs Office|Qualifier";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");
			sheetObj.InitDataProperty(0,	cnt++, 	dtSeq,				30,		daCenter,	false, 	"seq");
			sheetObj.InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	false,	"xpt_lic_no",		false,	"",   dfNone, 		0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtData, 			100,	daCenter,	false,	"id_xpt_no_iss_dt",	false,	"",   dfDateYmd, 	0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,			150,	daCenter,	false,	"id_ofc_id",		false,	"",   dfNone, 		0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtCombo,			60,		daCenter,	false,	"id_decl_cd",		false,	"",   dfNone, 		0,	true,	true);
			sheetObj.InitDataCombo   (0, "id_ofc_id", 	" |BANBA|JKTBA|SRGBA|SUBBA", " |010700|040300|060100|070100", "", "");
			sheetObj.InitDataCombo   (0, "id_decl_cd", 	" |PEB|PKB", " |E|K", "", "");
			sheetObj.MultiSelection = false;
			sheetObj.CountPosition = 0;
		//}
		break;	
		
 	case "div9sheet1": // div9sheet1 init // Ship Id
		//with (sheetObj) {
			// 높이 설정
 			sheetObj.style.height = 185;
			// 전체 너비 설정
 			sheetObj.SheetWidth = 150;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msNone;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = false;
	
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(6, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)
	
			var HeadTitle = "||Ship ID|||";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);
	
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"ref_seq",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		false,			"de_no",			false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"prt_no",		false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cust_ref_tp_cd",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"bkg_no",					false,			"",   dfNone, 0,	true,	true);
			
			sheetObj.MultiSelection = false;
			sheetObj.CountPosition = 0;
		//}
		break;		

 	case "div9sheet2": //Ship Id
		//with (sheetObj) {
 		// 높이 설정
			sheetObj.style.height = 185;
		// 전체 너비 설정
			sheetObj.SheetWidth = 150;

		// Host정보 설정[필수][HostIp, Port, PagePath]
		if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

		// 전체Merge 종류 [선택, Default msNone]
		sheetObj.MergeSheet = msNone;

		// 전체Edit 허용 여부 [선택, Default false]
		sheetObj.Editable = false;

		// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		sheetObj.InitRowInfo(1, 1, 2, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		sheetObj.InitColumnInfo(5, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		sheetObj.InitHeadMode(true, true, false, true, false, false)

		var HeadTitle = "||Ship ID||";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		sheetObj.InitHeadRow(0, HeadTitle, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
		// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
		// SAVESTATUS, FORMATFIX]
		sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
		sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"ref_seq",			false,			"",   dfNone, 0,	true,	true);
		sheetObj.InitDataProperty(0, cnt++ , dtData,				150,	daLeft,		false,			"de_no",			false,			"",   dfNone, 0,	true,	true);
		sheetObj.InitDataProperty(0, cnt++ , dtHidden,			30,		daLeft,		false,			"prt_no",		false,			"",   dfNone, 0,	true,	true);
		sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cust_ref_tp_cd",					false,			"",   dfNone, 0,	true,	true);
		
		sheetObj.MultiSelection = false;
		sheetObj.CountPosition = 0;
		//}
		break;
		
 	case "div10sheet1":      //clause lock
		//with (sheetObj) {	
			// 높이 설정
			sheetObj.style.height = 43;
			// 전체 너비 설정
			sheetObj.SheetWidth = 480;
	
			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);
	
			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;
	
			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;
			// 자동 트림하여 조회및 저장
			sheetObj.DataAutoTrim = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(0, 1, 2, 100);
	
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(6, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(false, false, false, false, false, false)
	
			var HeadTitle1 = "|||||";
	
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true,true);	
			
			sheetObj.InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,			"ibflag");
			//sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		20, daCenter, 	true,  "check");
			sheetObj.InitDataProperty(0,	cnt++, 	dtSeq,				30,		daCenterTop ,	false, 	"seq");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			400, daLeft, 	true,  "cluz_lck_desc",			false, "", dfNone, 		0, true, true, 5000, 	false);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"bkg_no",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cluz_lck_seq",					false,			"",   dfNone, 0,	true,	true);
			sheetObj.InitDataProperty(0, cnt++ , dtHidden,			20,		daCenter,	false,			"cluz_lck_tp_cd",					false,			"",   dfNone, 0,	true,	true);
	
			//sheetObj.InitDataValid(0, "cluz_lck_desc", vtEngUpOther);
			
			sheetObj.MultiSelection = false;
			sheetObj.SelectHighLight = true;
			sheetObj.CountPosition = 0;
			sheetObj.ScrollTrack = true;

		//}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBSAVE:
		if(validateForm(sheetObj, formObj, sAction)==false){
			return false;
		}
		var params = getSaveStringForUpload();
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_04GS.do", params);
		
		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
			sheetObj.LoadSaveXml(sXml);
		}
		break;

	case IBSEARCH_ASYNC01: //조회
		parent.tabObjects[0].TabBackColor(3) = "#96c792";
			
		with(formObj){
			mk_desc.value="";
            pck_qty.value="";
			pck_tp_cd.value="";
			pck_nm.value="";
			act_wgt.value="";
			meas_qty.value="";
			wgt_ut_cd.selectedIndex="-1";
			meas_ut_cd.selectedIndex="-1"; 
			pck_cmdt_desc.value="";
			cntr_cmdt_desc.value="";
			dg_cmdt_desc.value="";
			cstms_desc.value="";
		}

		formObj.f_cmd.value = SEARCH;
		formObj.method = "post";
		formObj.target = "_self";
		formObj.action = "/hanjin/ESM_BKG_0229_04.do";
		formObj.submit();
		break;

	case IBSEARCH: //조회	
		var sXml = formObj.sXml.value;		
		var arrXml = sXml.split("|$$|");
		var arrCnt = 0;
		if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
			if (arrXml.length > arrCnt) {// esvc korea export licens no
				div2sheet1.Redraw = false;
				div2sheet1.LoadSearchXml(arrXml[arrCnt]);
				div2sheet1.Redraw = true;
			}
		}
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterCntrPoNoVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // esvc cntr po no
				div4sheet1.Redraw = false;
				div4sheet1.LoadSearchXml(arrXml[arrCnt]);
				div4sheet1.Redraw = true;
			}
		}
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterPoDtlVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // esvc cntr po no detail
				div4sheet2.Redraw = false;
				div4sheet2.LoadSearchXml(arrXml[arrCnt]);
				div4sheet2.Redraw = true;
			}
		}
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterRefDtlVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // esvc ship Id
				div9sheet2.Redraw = false;
				div9sheet2.LoadSearchXml(arrXml[arrCnt]);
				div9sheet2.Redraw = true;
			}
		}
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterInnerPackageVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // Inner Package
				innerPackageSheet.Redraw = false;
				innerPackageSheet.LoadSearchXml(arrXml[arrCnt]);
				innerPackageSheet.Redraw = true;
			}
		}
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // alps export licens no
			sheetObject1.Redraw = false;
			sheetObject1.LoadSearchXml(arrXml[arrCnt]);
			sheetObject1.Redraw = true;
		}

		arrCnt++;
		if (arrXml.length > arrCnt) { // alps bkg po no
			div3sheet3.Redraw = false;
			div3sheet3.LoadSearchXml(arrXml[arrCnt]);
			div3sheet3.Redraw = true;
			getPoOtherNoToForm();
		}
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // alps cntr po no
			div3sheet1.Redraw = false;
			div3sheet1.LoadSearchXml(arrXml[arrCnt]);
			div3sheet1.Redraw = true;
		}
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // alps cm po no
			div3sheet2.Redraw = false;
			div3sheet2.LoadSearchXml(arrXml[arrCnt]);
			div3sheet2.Redraw = true;
			div3sheet1_OnClick(div3sheet1, 1, 1, "");
		}	
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // alps ship Id
			div9sheet1.Redraw = false;
			div9sheet1.LoadSearchXml(arrXml[arrCnt]);
			div9sheet1.Redraw = true;
		}	
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // aes exception
			ComXml2ComboItem(arrXml[arrCnt], comboObjects[0], "val", "name");
			ComXml2ComboItem(arrXml[arrCnt], comboObjects[2], "val", "name");
		}
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // alps B/L Rider 
			div5sheet1.Redraw = false;
			div5sheet1.LoadSearchXml(arrXml[arrCnt]);
			div5sheet1.Redraw = true;
		}	
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterRqstNoVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // e-svc B/L Rider 
				div6sheet1.Redraw = false;
				div6sheet1.LoadSearchXml(arrXml[arrCnt]);
				div6sheet1.Redraw = true;
			}
		}
		
		var scgAlps = null;
		var scgEsvc = null;
		arrCnt++;
		if (arrXml.length > arrCnt) { // ALPS Surcharge Adjustment
			div7sheet1.Redraw = false;
			div7sheet1.LoadSearchXml(arrXml[arrCnt]);
			div7sheet1.Redraw = true;
			for( var i=0; i< div7sheet1.RowCount; i++ ){
				if( 'Y' == div7sheet1.CellValue( i+1, 'kr_whf_expt_appl_flg' ) ) {
					div7sheet1.CellValue2( i+1, 'radio' )  = 1 ;
					div7sheet1.CellValue2( i+1, 'ibflag' ) = "" ;
					scgAlps = div7sheet1.CellValue( i+1, 'kr_whf_expt_cd' );
				} 
				else{
					div7sheet1.CellValue2( i+1, 'radio' )  = 0 ;
				}
			}
		}		

		arrCnt++;
		if(Number(ComGetObjValue(formObj.xterKrWhfBlExptInfoVOsCnt)) > 0){
			if (arrXml.length > arrCnt) { // e-svc Surcharge Adjustment
				div7sheet2.Redraw = false;
				div7sheet2.LoadSearchXml(arrXml[arrCnt]);
				div7sheet2.Redraw = true;
				for( var i=0; i< div7sheet2.RowCount; i++ ){
					if( 'Y' == div7sheet2.CellValue( i+1, 'kr_whf_expt_appl_flg' ) ) {
						div7sheet2.CellValue2( i+1, 'radio' )  = 1 ;
						div7sheet2.CellValue2( i+1, 'ibflag' ) = "" ;
						scgEsvc = div7sheet2.CellValue( i+1, 'kr_whf_expt_cd' );
					}
				}
			}	
		}

		arrCnt++;
		if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0){
			if (arrXml.length > arrCnt) { // alps indonesia peb no
				div8sheet1.Redraw = false;
				div8sheet1.LoadSearchXml(arrXml[arrCnt]);
				div8sheet1.Redraw = true;
			}
		}
		
		arrCnt++;
		if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0){
			if (arrXml.length > arrCnt) { // e-svc indonesia peb no
				div8sheet2.Redraw = false;
				div8sheet2.LoadSearchXml(arrXml[arrCnt]);
				div8sheet2.Redraw = true;
			}
		}
		
		arrCnt++;
		if (arrXml.length > arrCnt) { // clause lock
			div10sheet1.Redraw = false;
			div10sheet1.LoadSearchXml(arrXml[arrCnt]);
			div10sheet1.Redraw = true;
		}
		
		/* 값이 있을 경우 버튼 색 변화 */
		getBtnObject("btn_ExportInfo").style.color 		= (sheetObject1.TotalRows>0)     ?"blue":"#737373";
		getBtnObject("btn_ExportInfo2").style.color 	= (formObj.xpt_imp2.value=="Y")  ?"blue":"#737373";
		getBtnObject("btn_MiscInfo2").style.color 		= (formObj.misc2.value   =="Y")  ?"blue":"#737373";
		getBtnObject("btn_BLRider").style.color 		= (div5sheet1.TotalRows>0)  	 ?"blue":"#737373";
		if(Number(ComGetObjValue(formObj.xterRqstNoVOsCnt)) > 0){
			getBtnObject("btn_BLRider2").style.color 		= (div6sheet1.TotalRows>0)  	 ?"blue":"#737373";
		}
		if(Number(ComGetObjValue(formObj.xterInnerPackageVOsCnt)) > 0){
			getBtnObject("btn_InnerPackage2").style.color 	= (innerPackageSheet.TotalRows>0)?"blue":"#737373";
		} else {
			ComBtnDisable("btn_InnerPackage2");
		}
		getBtnObject("btn_Surcharge2").style.color 		= (scgAlps!=scgEsvc)			 ?"blue":"#737373";
		
		getBtnObject("btn_RefDtl").style.color 		= (div9sheet1.TotalRows>0)  	 ?"blue":"#737373";
		if(Number(ComGetObjValue(formObj.xterRefDtlVOsCnt)) > 0){
			getBtnObject("btn_RefDtl2").style.color 		= (div9sheet2.TotalRows>0)  	 ?"blue":"#737373";
		}

		var cntrPo = false;
		for(var i=1;i<div3sheet1.RowCount + 1;i++){
			if(div3sheet1.CellValue(i, "cust_ref_no_ctnt").length>1 && ComTrim(div3sheet1.CellValue(i, "cust_ref_no_ctnt"))!=null){
				cntrPo = true;
				break;
			}
		}
		
		if(cntrPo == true||div3sheet2.RowCount>0
			||((formObj.bkpo.value+formObj.hinv.value+formObj.hpdp.value+formObj.lcno.value+formObj.lcdt.value+formObj.othr.value).lenght>1)){
			getBtnObject("btn_POOtherNo").style.color = "blue";
		} else {
			getBtnObject("btn_POOtherNo").style.color = "#737373";
		}
		if(Number(ComGetObjValue(formObj.xterCntrPoNoVOsCnt)) > 0){
			if((formObj.po_no2.value  =="Y")||div4sheet1.RowCount>0){
				getBtnObject("btn_POOtherNo2").style.color = "blue";
			} else {
				getBtnObject("btn_POOtherNo2").style.color = "#737373";
			}
		} else {			
			if(formObj.po_no2.value  =="Y"){
				getBtnObject("btn_POOtherNo2").style.color = "blue";
			} else {
				getBtnObject("btn_POOtherNo2").style.color = "#737373";
			}
			
		}

//		/*
//		 * - 2009.05.22일 추가 -
//		 * Mandatory Item(s) Setup for Customized Service (UI_BKG-1030) 에 등록된 화주의 B/L인 경우, 빨간색으로 버튼 highlight 함
//		 * UI_BKG-0367-01에 입력된 데이터가 있는 경우 파란색으로 highlight 함
//		 */
//		var po1 = formObj.po_cust_flag.value;
//		var po2 = formObj.po_ref_flag.value;
//		var po3 = formObj.po_ref_dtl_flag.value;
//		if(po2 != '0' || po3 != '0'){
//			getBtnObject("btn_POOtherNo").style.color = "blue";
//		}else{
//			if(po1 != '0'){
//				//getBtnObject("btn_POOtherNo").className = "btn2_3";
//				getBtnObject("btn_POOtherNo").style.color = "red";
//			}else{
//				getBtnObject("btn_POOtherNo").style.color = "#737373";
//			}
//		}
// BKG 생성 전이면, po1~po3 는 null 임. 이에 대해 보완. : 전창현. 2010-02-18
//		if((!ComIsNull(po2) && po2 != '0') || (!ComIsNull(po3) && po3 != '0')){
//			getBtnObject("btn_POOtherNo").style.color = "blue";
//		}else{
//			if(!ComIsNull(po1) && po1 != '0'){
//				getBtnObject("btn_POOtherNo").style.color = "red";
//			}else{
//				getBtnObject("btn_POOtherNo").style.color = "#737373";
//			}
//		}
		
// 하기 사항은 일반 BKG M&D 화면에서 처리하는 callbackPOOtherNo 함수에서 N, Y 로 사용하기 위해 세팅하는 것임.
// 그대로 두면, Copy 에 대한 Cancel 시 오류남. : 전창현. 2010-02-18
//		formObj.po_cust_flag.value    = (po1=='0') ? 'N' : 'Y';
//		formObj.po_ref_flag.value     = (po2=='0') ? 'N' : 'Y';
//		formObj.po_ref_dtl_flag.value = (po3=='0') ? 'N' : 'Y';
		
		if(ComIsNull(formObj.bkg_no.value)){
			ComBtnDisable("btn_BLRider");			
		} else {
			ComBtnEnable("btn_BLRider");			
		}
		
		if(formObj.act_wgt_prn_flg.value=="Y"){
			formObj.act_wgt_prn_flg.value = "Y";
			formObj.act_wgt_prn_flg.checked = true;			
		} else {
			formObj.act_wgt_prn_flg.value = "N";
			formObj.act_wgt_prn_flg.checked = false;			
		}
		
		if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
			// Weight QTY
			// Weight 등이 업데이트 되면 M&D TAB 존재 시 Update 하기 위해 method로 뺌
			formObj.act_wgt.value = parent.frames("t1frame").document.form.estm_wgt2.value;
		}

		formObj.pck_qty2.value  = ComAddComma3(formObj.pck_qty2.value, "#,###");			
		formObj.act_wgt2.value  = ComAddComma3(formObj.act_wgt2.value, "#,###.000");
		formObj.meas_qty2.value = ComAddComma3(formObj.meas_qty2.value,"#,###.000");
		formObj.pck_qty.value   = ComAddComma3(formObj.pck_qty.value,  "#,###");
		formObj.act_wgt.value   = ComAddComma3(formObj.act_wgt.value,  "#,###.000");
		formObj.meas_qty.value  = ComAddComma3(formObj.meas_qty.value, "#,###.000");
		
		// Freight Term: PREPAID OR COLLECT(BKG tab에서 가져와서 다시 넣음)   
		formObj.frt_term_cd.value = parent.frames("t1frame").document.form.frt_term_cd.value;
		formObj.tmp_frt_term_cd.value = parent.frames("t1frame").document.form.tmp_frt_term_cd.value;
		formObj.frt_term_cd2.value = parent.frames("t1frame").document.form.frt_term_cd2.value;
		
		if ( parent.frames("t1frame").document.form == false || parent.frames("t1frame").document.form.bkg_upld_sts_cd.value != "F" ) { /// 2011.07.05
			if (formObj.frt_term_cd2.value == "P" ||
				formObj.frt_term_cd2.value == "PREPAID") {
				ComSetObjValue(document.form.frt_term_cd, "P");
				formObj.tmp_frt_term_cd.value = "PREPAID"; //add jsy 2011.12.02
	//			document.getElementsByName("frt_term_cd").Code = "P";
			}
			else if (formObj.frt_term_cd2.value == "C" ||
				formObj.frt_term_cd2.value == "COLLECT") {
				ComSetObjValue(document.form.frt_term_cd, "C");
				formObj.tmp_frt_term_cd.value = "COLLECT";
	//			document.getElementsByName("frt_term_cd").Code = "C";
			}
		}
		
		if (!ComIsEmpty(formObj.frt_term_cd.value) && formObj.frt_term_cd.value.substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){		
//			formObj.frt_term_cd.FontColor="Red"; 
			formObj.tmp_frt_term_cd.style.color = "Red";
			formObj.frt_term_cd2.style.color = "Red";
		} else {
//			formObj.frt_term_cd.FontColor= "#606060";
			formObj.tmp_frt_term_cd.style.color = "#606060";
			formObj.frt_term_cd2.style.color = "#606060";		
		}
		//Export Info form으로 조회
		getExportInfoToForm();

		compareItem();
		if(parent.document.form.mndTabCancel.value=="Y"){
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");

			parent.frames("t1frame").document.form.act_wgt.value = parent.frames("t1frame").document.form.act_wgt_old.value;
			form.act_wgt.value = parent.frames("t1frame").document.form.act_wgt.value;
			parent.document.form.mndTabCancel.value = "N";
		}
		if(top.document.form.tabload4.value == "COPY"){
			dataCopy();
		}
		top.document.form.tabload4.value = "LOAD";
		
		if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
			if (div1sheet1.RowCount > 0) {
				div1sheet1.CellValue2(div1sheet1.LastRow, 1) = "";
				div1sheet1.CellValue2(div1sheet1.LastRow, "ts_ref_no") = "TOTAL";
				div1sheet1.CellAlign(div1sheet1.LastRow, "ts_ref_no") = daCenter;
			}
		}
		
		if( formObj.exp_vin_ctnt2.value == "" ){
			formObj.vin_exist_flg2.checked = false;    			
		}else{
			formObj.vin_exist_flg2.checked = true;
		}
		
		//** 2012.12.04 check box 미 check 시 입력되지 않도록 함.**//
		var obj = document.getElementsByName("aes_tp_cd");
		for(var i=0; i<obj.length; i++){
			if(obj[i].checked == false){
				switch(obj[i].value) {
					case "AE":  
		             	 formObj.aes_inlnd_trns_no.value='';
		        	     formObj.aes_inlnd_trns_no.readOnly=true;
		        	     break;
			        case "PA": 
			        	 formObj.aes_pta_no1.value='';
			             formObj.aes_pta_no1.readOnly=true;
			             formObj.aes_pta_no2.value='';
			             formObj.aes_pta_no2.readOnly=true;
			             formObj.aes_pta_dt.value='';
			             formObj.aes_pta_dt.readOnly=true;
			             break;
			        case "PU":
			        	 formObj.aes_ptu_no.value='';
			             formObj.aes_ptu_no.readOnly=true;
			             formObj.aes_ptu_dt.value='';
			             formObj.aes_ptu_dt.readOnly=true;
			             break;
			        case "DN":
			        	 formObj.aes_dwn_no.value='';
			             formObj.aes_dwn_no.readOnly=true;
			             formObj.aes_dwn_dt.value='';
			             formObj.aes_dwn_dt.readOnly=true;
			             break;
			        case "EX":
			        	 formObj.aes_expt_id.Code='';
			             formObj.aes_expt_id.Enable=false;
			             break;
				}	
		    }		
	    }
        var obj2 = document.getElementsByName("caed_tp_cd");
        var chkcnt = 0
       	for(var i=0; i<obj2.length; i++){            
        	if(obj2[i].checked == false){
	            switch(obj2[i].value) {
					case "CE":  
						formObj.caed_ctnt.readOnly=true;
						formObj.caed_ctnt.value ='';
						break;
					case "G7": 
					    formObj.g7_edi_ctnt.readOnly=true;
					    formObj.g7_edi_ctnt.value ='';
					    break;
					case "SM":
					    formObj.mf_smry_rpt_no.readOnly=true;
					    formObj.mf_smry_rpt_no.value ='';
					    break;
					case "EX":
					    formObj.b13a_xpt_ctnt.readOnly=true;
					    formObj.b13a_xpt_ctnt.value ='';
					    break;
					case "IT":
					    formObj.cgo_ctrl_no.readOnly=true;
					    formObj.cgo_ctrl_no.value ='';
					    break;
					case "ND":
						formObj.ndr_ref_id.Enable=false;
						formObj.ndr_ref_id.value ='';
						break;
	           	}
           	}              
        }    		
		break;

	case IBSEARCH_ASYNC02: //Data Copy
		parent.tabObjects[0].TabBackColor(3) = "#fff270";
	
		if (formObj.mk_desc.value != null && formObj.mk_desc2.value != '')
			formObj.mk_desc.value = formObj.mk_desc2.value;

		if (formObj.dg_cmdt_desc2.value != null && formObj.dg_cmdt_desc2.value != ''){
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc2.value;
			if (parent.frames("t1frame").document.form.sender_id.value == "SEANACCS") {
				formObj.cstms_desc.value = formObj.dg_cmdt_desc.value.substring(0,(formObj.dg_cmdt_desc.value).indexOf("\r\n"));
			}		
		}
		
		//[CHM-201323520]: SI Customs Description column 추가 요청에 따른 Customs Description Copy 부분 추가
		if (formObj.cstms_desc2.value != null && formObj.cstms_desc2.value != '')
        	formObj.cstms_desc.value = formObj.cstms_desc2.value;
		
		formObj.act_wgt_prn_flg.value = "Y";
		formObj.act_wgt_prn_flg.checked = true;	
		
		copyPckWgtMeas();

		if ( parent.frames("t1frame").document.form == false || parent.frames("t1frame").document.form.bkg_upld_sts_cd.value != "F" ) { /// 2011.07.05
			// Freight Term: PREPAID OR COLLECT
			if (formObj.frt_term_cd2.value == "P" ||
					formObj.frt_term_cd2.value == "PREPAID") {
//				comboObjects[2].Code = "P";
				ComSetObjValue(document.form.frt_term_cd, "P");
				formObj.tmp_frt_term_cd.value = "PREPAID"; //add jsy 2011.12.02
			}
			else if (formObj.frt_term_cd2.value == "C" ||
					formObj.frt_term_cd2.value == "COLLECT") {
//				comboObjects[2].Code = "C";
				ComSetObjValue(document.form.frt_term_cd, "C");
				formObj.tmp_frt_term_cd.value = "COLLECT";
			}
	
			if (parent.frames("t1frame").document.form) {
//				ComSetObjValue(parent.frames("t1frame").document.form.frt_term_cd, comboObjects[2].Code);
				ComSetObjValue(parent.frames("t1frame").document.form.frt_term_cd, document.form.frt_term_cd.value);
			}
		}
		
		getBtnObject("btn_ExportInfo").style.color = "#737373";
		
		// export licens number copy
		// USA
		if(ComIsNull(formObj.aes_inlnd_trns_no.value) && !ComIsNull(formObj.aes_inlnd_trns_no2.value)){
			formObj.aes_inlnd_trns_no.value = formObj.aes_inlnd_trns_no2.value;			
			formObj.aes_tp_cd[0].checked = true;
			formObj.aes_inlnd_trns_no.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_pta_no1.value) && !ComIsNull(formObj.aes_pta_no12.value)){
			formObj.aes_pta_no1.value 		= formObj.aes_pta_no12.value;			
			formObj.aes_tp_cd[1].checked = true;
			formObj.aes_pta_no1.readOnly=false;
            formObj.aes_pta_no2.readOnly=false;
            formObj.aes_pta_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_pta_no2.value) && !ComIsNull(formObj.aes_pta_no22.value)){
			formObj.aes_pta_no2.value 		= formObj.aes_pta_no22.value;		
			formObj.aes_tp_cd[1].checked = true;
			formObj.aes_pta_no1.readOnly=false;
            formObj.aes_pta_no2.readOnly=false;
            formObj.aes_pta_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_pta_dt.value) && !ComIsNull(formObj.aes_pta_dt2.value)){
			formObj.aes_pta_dt.value 		= formObj.aes_pta_dt2.value;		
			formObj.aes_tp_cd[1].checked = true;
			formObj.aes_pta_no1.readOnly=false;
            formObj.aes_pta_no2.readOnly=false;
            formObj.aes_pta_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_ptu_no.value) && !ComIsNull(formObj.aes_ptu_no2.value)){
			formObj.aes_ptu_no.value 		= formObj.aes_ptu_no2.value;		
			formObj.aes_tp_cd[2].checked = true;
			formObj.aes_ptu_no.readOnly=false;
			formObj.aes_ptu_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_ptu_dt.value) && !ComIsNull(formObj.aes_ptu_dt2.value)){
			formObj.aes_ptu_dt.value 		= formObj.aes_ptu_dt2.value;		
			formObj.aes_tp_cd[2].checked = true;
			formObj.aes_ptu_no.readOnly=false;
			formObj.aes_ptu_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_dwn_no.value) && !ComIsNull(formObj.aes_dwn_no2.value)){
			formObj.aes_dwn_no.value 		= formObj.aes_dwn_no2.value;		
			formObj.aes_tp_cd[3].checked = true;
			formObj.aes_dwn_no.readOnly=false;
            formObj.aes_dwn_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.aes_dwn_dt.value) && !ComIsNull(formObj.aes_dwn_dt2.value)){
			formObj.aes_dwn_dt.value 		= formObj.aes_dwn_dt2.value;		
			formObj.aes_tp_cd[3].checked = true;
			formObj.aes_dwn_no.readOnly=false;
            formObj.aes_dwn_dt.readOnly=false;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}

		if(ComIsNull(comboObjects[0].Code) && !ComIsNull(formObj.aes_expt_id_tmp.value)){
			comboObjects[0].Code			= formObj.aes_expt_id_tmp.value;		
			formObj.aes_tp_cd[4].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		if(ComIsNull(formObj.aes_expt_ctnt.value) && !ComIsNull(formObj.aes_expt_ctnt2.value)){
			formObj.aes_expt_ctnt.value		= formObj.aes_expt_ctnt2.value;		
//	aes_expt_ctnt 를 aes_tp_cd 와 무관하게 항상 입력 가능하도로 수정함. 2012.12.20	
//			formObj.aes_tp_cd[4].checked = true; 
			getBtnObject("btn_ExportInfo").style.color = "blue";
//		}else{
//			formObj.aes_expt_ctnt.enable = false ;
		}
		
		
		if(formObj.exp_vin_ctnt.value != formObj.exp_vin_ctnt2.value && !ComIsNull(formObj.exp_vin_ctnt2.value)){
			formObj.exp_vin_ctnt.value		= formObj.exp_vin_ctnt2.value;			
			formObj.vin_exist_flg.checked = true; 			
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}

		// mexico
		if(ComIsNull(formObj.mx_shpr_tax_id.value) && !ComIsNull(formObj.mx_shpr_tax_id2.value)){
			formObj.mx_shpr_tax_id.value 	= formObj.mx_shpr_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.mx_cnee_tax_id.value) && !ComIsNull(formObj.mx_cnee_tax_id2.value)){
			formObj.mx_cnee_tax_id.value 	= formObj.mx_cnee_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.mx_ntfy_tax_id.value) && !ComIsNull(formObj.mx_ntfy_tax_id2.value)){
			formObj.mx_ntfy_tax_id.value 	= formObj.mx_ntfy_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		// turkey add jsy 2011.12.14
		if(ComIsNull(formObj.tr_shpr_tax_id.value) && !ComIsNull(formObj.tr_shpr_tax_id2.value)){
			formObj.tr_shpr_tax_id.value 	= formObj.tr_shpr_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.tr_cnee_tax_id.value) && !ComIsNull(formObj.tr_cnee_tax_id2.value)){
			formObj.tr_cnee_tax_id.value 	= formObj.tr_cnee_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.tr_ntfy_tax_id.value) && !ComIsNull(formObj.tr_ntfy_tax_id2.value)){
			formObj.tr_ntfy_tax_id.value 	= formObj.tr_ntfy_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		// 이스라엘 add jLee 2012.07.24
		if(ComIsNull(formObj.il_shpr_tax_id.value) && !ComIsNull(formObj.il_shpr_tax_id2.value)){
			formObj.il_shpr_tax_id.value 	= formObj.il_shpr_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.il_cnee_tax_id.value) && !ComIsNull(formObj.il_cnee_tax_id2.value)){
			formObj.il_cnee_tax_id.value 	= formObj.il_cnee_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.il_ntfy_tax_id.value) && !ComIsNull(formObj.il_ntfy_tax_id2.value)){
			formObj.il_ntfy_tax_id.value 	= formObj.il_ntfy_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		// 리비아 add jLee 2012.09.25
		if(ComIsNull(formObj.lb_shpr_tax_id.value) && !ComIsNull(formObj.lb_shpr_tax_id2.value)){
			formObj.lb_shpr_tax_id.value 	= formObj.lb_shpr_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.lb_cnee_tax_id.value) && !ComIsNull(formObj.lb_cnee_tax_id2.value)){
			formObj.lb_cnee_tax_id.value 	= formObj.lb_cnee_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.lb_ntfy_tax_id.value) && !ComIsNull(formObj.lb_ntfy_tax_id2.value)){
			formObj.lb_ntfy_tax_id.value 	= formObj.lb_ntfy_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		// canada
		if(ComIsNull(formObj.caed_ctnt.value) && !ComIsNull(formObj.caed_ctnt2.value)){
			formObj.caed_ctnt.value 		= formObj.caed_ctnt2.value;
			formObj.caed_tp_cd[0].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.g7_edi_ctnt.value) && !ComIsNull(formObj.g7_edi_no2.value)){
			formObj.g7_edi_ctnt.value 		= formObj.g7_edi_no2.value;
			formObj.caed_tp_cd[1].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.mf_smry_rpt_no.value) && !ComIsNull(formObj.mf_smry_rpt_ctnt2.value)){
			formObj.mf_smry_rpt_no.value 	= formObj.mf_smry_rpt_ctnt2.value;
			formObj.caed_tp_cd[2].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.b13a_xpt_ctnt.value) && !ComIsNull(formObj.b13a_xpt_ctnt2.value)){
			formObj.b13a_xpt_ctnt.value 	= formObj.b13a_xpt_ctnt2.value;
			formObj.caed_tp_cd[3].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.cgo_ctrl_no.value) && !ComIsNull(formObj.cgo_ctrl_no2.value)){
			formObj.cgo_ctrl_no.value 		= formObj.cgo_ctrl_no2.value;
			formObj.caed_tp_cd[4].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.ndr_ref_id.value) && !ComIsNull(formObj.ndr_ref_id2.value)){
			formObj.ndr_ref_id.value 		= formObj.ndr_ref_id2.value;
			formObj.caed_tp_cd[5].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.ndr_ref_ctnt.value) && !ComIsNull(formObj.ndr_ref_ctnt2.value)){
			formObj.ndr_ref_ctnt.value	 	= formObj.ndr_ref_ctnt2.value;	
            //	ndr_ref_ctnt 를 ndr_ref_id 와 무관하게 처리되도록 수정함. 2012.12.20
			//formObj.caed_tp_cd[5].checked = true;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		
		//Brazil 추가  2013.01.07
		if(ComIsNull(formObj.br_shpr_tax_id.value) && !ComIsNull(formObj.br_shpr_tax_id2.value)){
			formObj.br_shpr_tax_id.value 	= formObj.br_shpr_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.br_cnee_tax_id.value) && !ComIsNull(formObj.br_cnee_tax_id2.value)){
			formObj.br_cnee_tax_id.value 	= formObj.br_cnee_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}
		if(ComIsNull(formObj.br_ntfy_tax_id.value) && !ComIsNull(formObj.br_ntfy_tax_id2.value)){
			formObj.br_ntfy_tax_id.value 	= formObj.br_ntfy_tax_id2.value;
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}	
		
		// korea export		
		if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
			if(div2sheet1.TotalRows>0){			
				var isChanged = false;
				//  2012.12.11 KOR Export  licence no 관련 부분  data copy 시 Org data가 있는 경우는 모두 새로 넣도록 함. update 되는 부분  막음. 
				initSheet(div1sheet1, 1);
				for(var i=1;i<div2sheet1.TotalRows + 1;i++){					
					isChanged = true;
					
					var newRow = div1sheet1.DataInsert(-1);
					div1sheet1.RowStatus(newRow) 					= "U";
					div1sheet1.CellValue2(newRow, "bkg_no") 		= formObj.bkg_no.value; 
					div1sheet1.CellValue2(newRow, "io_bnd_cd") 		= div2sheet1.CellValue(i, "io_bnd_cd2"); 
					div1sheet1.CellValue2(newRow, "cnt_cd") 		= div2sheet1.CellValue(i, "cnt_cd2"); 
					div1sheet1.CellValue2(newRow, "xpt_lic_no") 	= div2sheet1.CellValue(i, "xpt_lic_no2");
					div1sheet1.CellValue2(newRow, "ts_ref_no") 		= div2sheet1.CellValue(i, "ts_ref_no2");
					div1sheet1.CellValue2(newRow, "pck_qty") 		= div2sheet1.CellValue(i, "pck_qty2");
					div1sheet1.CellValue2(newRow, "pck_tp_cd") 		= div2sheet1.CellValue(i, "pck_tp_cd2"); 
					div1sheet1.CellValue2(newRow, "mf_wgt") 		= div2sheet1.CellValue(i, "mf_wgt2");
					div1sheet1.CellValue2(newRow, "wgt_ut_cd") 		= div2sheet1.CellValue(i, "wgt_ut_cd2");
					div1sheet1.CellValue2(newRow, "divd_seq") 		= div2sheet1.CellValue(i, "divd_seq2");
					div1sheet1.CellValue2(newRow, "sam_pck_id") 	= div2sheet1.CellValue(i, "sam_pck_id2");
					div1sheet1.CellValue2(newRow, "sam_pck_qty") 	= div2sheet1.CellValue(i, "sam_pck_qty2");
					div1sheet1.CellValue2(newRow, "sam_pck_tp_cd")	= div2sheet1.CellValue(i, "sam_pck_tp_cd2");					
				}
				
				if (isChanged) {
					getBtnObject("btn_ExportInfo").style.color = "blue";
				}
			}
			if (div1sheet1.RowCount > 0) {
				div1sheet1.CellValue2(div1sheet1.LastRow, 1) = "";
				div1sheet1.CellValue2(div1sheet1.LastRow, "ts_ref_no") = "TOTAL";
				div1sheet1.CellAlign(div1sheet1.LastRow, "ts_ref_no") = daCenter;
			}
		}
		
		// indonesia
		if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0){
			if(div8sheet2.TotalRows>0){			
				var isChanged = false; 
				initSheet(div8sheet1, 3);
				div8sheet1.RemoveAll();
				for(var i=1;i<div8sheet2.TotalRows + 1;i++){					
					isChanged = true;
					
					var newRow = div8sheet1.DataInsert(-1);
					div8sheet1.RowStatus(newRow) 						= "I";
					div8sheet1.CellValue2(newRow, "bkg_no") 			= formObj.bkg_no.value; 
					div8sheet1.CellValue2(newRow, "io_bnd_cd") 			= "O"; 
					div8sheet1.CellValue2(newRow, "cnt_cd") 			= "ID";
					div8sheet1.CellValue2(newRow, "id_xpt_no") 			= div8sheet2.CellValue(i, "xpt_lic_no");
					div8sheet1.CellValue2(newRow, "id_xpt_no_iss_dt") 	= div8sheet2.CellValue(i, "id_xpt_no_iss_dt");
					div8sheet1.CellValue2(newRow, "id_ofc_cd") 			= div8sheet2.CellValue(i, "id_ofc_id");
					div8sheet1.CellValue2(newRow, "id_decl_cd") 		= div8sheet2.CellValue(i, "id_decl_cd");					
				}
				if (isChanged) {
					getBtnObject("btn_ExportInfo").style.color = "blue";
				}
			}
		}
		
		if(sheetObject1.TotalRows>0){
			getBtnObject("btn_ExportInfo").style.color = "blue";
		}		 

		setExportInfoToSheet();
		
		// p/o & other no copy
		if(!ComIsNull(formObj.bkpo2.value)) 	formObj.bkpo.value	 	= formObj.bkpo2.value;
		if(!ComIsNull(formObj.lcno2.value)) 	formObj.lcno.value	 	= formObj.lcno2.value;
		if(!ComIsNull(formObj.hinv2.value)) 	formObj.hinv.value	 	= formObj.hinv2.value;
		if(!ComIsNull(formObj.lcdt2.value)) 	formObj.lcdt.value	 	= formObj.lcdt2.value;
		if(!ComIsNull(formObj.hpdp2.value)) 	formObj.hpdp.value	 	= formObj.hpdp2.value;
		if(!ComIsNull(formObj.othr2.value)) 	formObj.othr.value	 	= formObj.othr2.value;
		
		if(Number(ComGetObjValue(formObj.xterCntrPoNoVOsCnt)) > 0){
			if(div4sheet1.TotalRows>0){
				for(var i=1;i<div4sheet1.TotalRows + 1;i++){
					var isInsert = "true";
					for(var j=1;j<div3sheet1.TotalRows + 1;j++){
						if(div3sheet1.CellValue(j, "c_cntr_no")==div4sheet1.CellValue(i, "cntr_no")){
							div3sheet1.RowStatus(j) = "U";
							div3sheet1.CellValue2(j, "cust_ref_no_ctnt") = div4sheet1.CellValue(i, "po_no");
							if("D"==div3sheet1.RowStatus(j)){
								isInsert = "true"
								break;
							}						
							isInsert = "false"
							break;
						} else {
							isInsert = "true";
						}
					}
					if(isInsert=="true"){
						var newRow = div3sheet1.DataInsert(-1);
						div3sheet1.RowStatus(newRow) = "I";
						div3sheet1.CellValue2(newRow, "c_cntr_no") 		  = div4sheet1.CellValue(i, "cntr_no"); 
						div3sheet1.CellValue2(newRow, "cntr_no") 		  = div4sheet1.CellValue(i, "cntr_no"); 
						div3sheet1.CellValue2(newRow, "cust_ref_no_ctnt") = div4sheet1.CellValue(i, "po_no");
					}
				}
			}
		}
		if(Number(ComGetObjValue(formObj.xterPoDtlVOsCnt)) > 0){
			if(div4sheet2.TotalRows>0){
				for(var i=1;i<div4sheet2.TotalRows + 1;i++){
					var isInsert = "true";
					for(var j=1;j<div3sheet2.TotalRows + 1;j++){
						if(div3sheet2.CellValue(j, "cntr_no")==div4sheet2.CellValue(i, "cntr_no")
							&& div3sheet2.CellValue(j, "po_no")==div4sheet2.CellValue(i, "po_no")
							&& div3sheet2.CellValue(j, "seq")==div4sheet2.CellValue(i, "seq")){
							if("D"==div3sheet2.RowStatus(j)){
								isInsert = "true"
								break;
							}						
							div3sheet2.RowStatus(j) = "U";
							div3sheet2.CellValue2(j, "cntr_no") 	= div4sheet2.CellValue(i, "cntr_no");
							div3sheet2.CellValue2(j, "po_no") 		= div4sheet2.CellValue(i, "po_no");
							div3sheet2.CellValue2(j, "itm_no") 		= div4sheet2.CellValue(i, "itm_no");
							div3sheet2.CellValue2(j, "itm_desc") 	= div4sheet2.CellValue(i, "itm_desc");
							div3sheet2.CellValue2(j, "pck_qty") 	= div4sheet2.CellValue(i, "pck_qty");
							div3sheet2.CellValue2(j, "pck_tp_cd") 	= div4sheet2.CellValue(i, "pck_tp_cd");
							div3sheet2.CellValue2(j, "cntr_wgt") 	= div4sheet2.CellValue(i, "cntr_wgt");
							div3sheet2.CellValue2(j, "wgt_ut_cd") 	= div4sheet2.CellValue(i, "wgt_ut_cd");						
							div3sheet2.CellValue2(j, "meas_qty") 	= div4sheet2.CellValue(i, "meas_qty");
							div3sheet2.CellValue2(j, "meas_ut_cd") 	= div4sheet2.CellValue(i, "meas_ut_cd");
							isInsert = "false"
							break;
						} else {
							isInsert = "true";
						}
					}
					if(isInsert=="true"){
						var newRow = div3sheet2.DataInsert(-1);
						div3sheet2.RowStatus(newRow) = "I";
						div3sheet2.CellValue2(newRow, "cntr_no") 	= div4sheet2.CellValue(i, "cntr_no");
						div3sheet2.CellValue2(newRow, "po_no") 		= div4sheet2.CellValue(i, "po_no");
						div3sheet2.CellValue2(newRow, "itm_no") 	= div4sheet2.CellValue(i, "itm_no");
						div3sheet2.CellValue2(newRow, "itm_desc") 	= div4sheet2.CellValue(i, "itm_desc");
						div3sheet2.CellValue2(newRow, "pck_qty") 	= div4sheet2.CellValue(i, "pck_qty");
						div3sheet2.CellValue2(newRow, "pck_tp_cd") 	= div4sheet2.CellValue(i, "pck_tp_cd");
						div3sheet2.CellValue2(newRow, "cntr_wgt") 	= div4sheet2.CellValue(i, "cntr_wgt");
						div3sheet2.CellValue2(newRow, "wgt_ut_cd") 	= div4sheet2.CellValue(i, "wgt_ut_cd");
						div3sheet2.CellValue2(newRow, "meas_qty") 	= div4sheet2.CellValue(i, "meas_qty");
						div3sheet2.CellValue2(newRow, "meas_ut_cd") = div4sheet2.CellValue(i, "meas_ut_cd");					
					}
				}			
			}
		}
		div3sheet1_OnClick(div3sheet1, 1, 1, "");

		var cntrPo = false;
		for(var i=1;i<div3sheet1.RowCount + 1;i++){
			if(div3sheet1.CellValue(i, "cust_ref_no_ctnt").length>1 && ComTrim(div3sheet1.CellValue(i, "cust_ref_no_ctnt"))!=null){
				cntrPo = true;
				break;
			}
		}
		
		if(cntrPo == true||div3sheet2.RowCount>0
			||((formObj.bkpo.value+formObj.hinv.value+formObj.hpdp.value+formObj.lcno.value+formObj.lcdt.value+formObj.othr.value).lenght>1)){
			getBtnObject("btn_POOtherNo").style.color = "blue";
		} else {
			getBtnObject("btn_POOtherNo").style.color = "#737373";
		}
		
		// B/L Rider Copy 
		if(Number(ComGetObjValue(formObj.xterRqstNoVOsCnt)) > 0){
			if(div6sheet1.TotalRows>0){
				for(var i=1;i<div6sheet1.TotalRows + 1;i++){
					var isInsert = "true";
					for(var j=1;j<div5sheet1.TotalRows + 1;j++){
						if(div5sheet1.CellValue(j, "file_sav_id")==div6sheet1.CellValue(i, "file_sav_id")){
							isInsert = "false"
							break;
						} else {
							isInsert = "true";
						}
					}
					if(isInsert=="true"){
						var newRow = div5sheet1.DataInsert(-1);
						div5sheet1.RowStatus(newRow) = "I";
						div5sheet1.CellValue2(newRow, "file_nm") 		= div6sheet1.CellValue(i, "file_nm"); 
						div5sheet1.CellValue2(newRow, "file_size") 		= div6sheet1.CellValue(i, "file_size");
						div5sheet1.CellValue2(newRow, "file_path_rmk") 	= div6sheet1.CellValue(i, "file_path_rmk");
						div5sheet1.CellValue2(newRow, "ridr_tp_cd") 	= div6sheet1.CellValue(i, "ridr_tp_cd");
						div5sheet1.CellValue2(newRow, "file_sav_id") 	= div6sheet1.CellValue(i, "file_sav_id");
						div5sheet1.CellValue2(newRow, "img_seq") 		= div6sheet1.CellValue(i, "img_seq");
						div5sheet1.CellValue2(newRow, "dcgo_seq") 		= div6sheet1.CellValue(i, "dcgo_seq");
						div5sheet1.CellValue2(newRow, "bb_cgo_seq") 	= div6sheet1.CellValue(i, "bb_cgo_seq");
						div5sheet1.CellValue2(newRow, "file_desc") 		= div6sheet1.CellValue(i, "file_desc");
						div5sheet1.CellValue2(newRow, "awk_cgo_seq") 	= div6sheet1.CellValue(i, "awk_cgo_seq");
					}
				}
			}
		}
		
		// Ship Id Copy 
		if(Number(ComGetObjValue(formObj.xterRefDtlVOsCnt)) > 0){
			if(div9sheet2.TotalRows>0){
				for(var i=1;i<div9sheet2.TotalRows + 1;i++){
					var isInsert = "true";
					for(var j=1;j<div9sheet1.TotalRows + 1;j++){
						if(div9sheet2.CellValue(i, "de_no")==div9sheet1.CellValue(j, "de_no")
								&& div9sheet2.CellValue(i, "ref_seq")==div9sheet1.CellValue(j, "ref_seq")){
							isInsert = "false"
							break;
						} else {
							isInsert = "true";
						}
					}
					if(isInsert=="true"){
						var newRow = div9sheet1.DataInsert(-1);
						div9sheet1.RowStatus(newRow) = "I";
						div9sheet1.CellValue2(newRow, "ref_seq") 		= div9sheet2.CellValue(i, "ref_seq"); 
						div9sheet1.CellValue2(newRow, "cust_ref_tp_cd") = div9sheet2.CellValue(i, "cust_ref_tp_cd");
						div9sheet1.CellValue2(newRow, "de_no") 			= div9sheet2.CellValue(i, "de_no");
					}
				}
			}
		}
		
		compareItem();
		
		isCopy = "true";
		break;

	case IBSEARCH_ASYNC03: //Data Copy From CM
		if(parent.frames("t5frame").document.form) {
			ComShowCodeMessage("BKG00068", "C/M data");
			return;
		}
		if(parent.document.form.tabload5.value == "NOT LOAD"){
			ComShowCodeMessage("BKG00068", "C/M data");
			return;
		}
		var cmSheet = parent.document.frames("t5frame").sheetObjects[0];
		var seq = 0;
		var pck_qty = 0;
		var act_wgt = 0;
		var meas_qty = 0;
		var desc_all = "";
		var mns_all = "";

		var pck_tp_cd = formObj.pck_tp_cd.value;
		var samePckCd = true;
		var wgt_ut_cd = formObj.wgt_ut_cd.value;
		var sameWgtCd = true;
		var meas_ut_cd = formObj.meas_ut_cd.value;
		var sameMeasCd = true;

		if (cmSheet.TotalRows > 0) {
			for ( var i = 0; i < cmSheet.TotalRows; i++) {
				if (pck_tp_cd == cmSheet.CellValue(parseInt(seq + 5), "sheet1_pck_tp_cd")) {
					pck_qty += parseInt(cmSheet.CellValue(parseInt(seq + 5), "sheet1_pck_qty"));
				} else {
					samePckCd = false;
				}
				if (wgt_ut_cd == cmSheet.CellValue(parseInt(seq + 5), "sheet1_wgt_ut_cd")) {
					act_wgt += parseFloat(cmSheet.CellValue(parseInt(seq + 5), "sheet1_cntr_mf_wgt"));
				} else {
					sameWgtCd = false;
				}
				if (meas_ut_cd == cmSheet.CellValue(parseInt(seq + 5), "sheet1_meas_ut_cd")) {
					meas_qty += parseFloat(cmSheet.CellValue(parseInt(seq + 5), "sheet1_meas_qty"));
				} else {
					sameMeasCd = false;
				}
				desc_all += cmSheet.CellValue(parseInt(seq + 7), "sheet1_description") + "\r\n";
				mns_all += cmSheet.CellValue(parseInt(seq + 9), "sheet1_marks") + "\r\n";

				seq += 5;
			}

			if (samePckCd){
				formObj.pck_qty.value = pck_qty;
			} else {
				formObj.pck_qty.value = ComAddComma(parseInt(cmSheet.CellValue(5, "sheet1_pck_qty")), "#,###");
			}
			if (sameWgtCd) {
				formObj.act_wgt.value = act_wgt;
			} else {
				formObj.act_wgt.value = ComAddComma(parseFloat(cmSheet.CellValue(5, "sheet1_cntr_mf_wgt")), "#,###.000");
			}
			if (sameMeasCd){
				formObj.meas_qty.value = meas_qty;
			} else {
				formObj.meas_qty.value = ComAddComma(parseFloat(cmSheet.CellValue(5, "sheet1_meas_ut_cd")), "#,###.000");
			}
			formObj.dg_cmdt_desc.value = desc_all;
			formObj.mk_desc.value = mns_all;
		}

		compareItem();
		break;
		
	case IBCOPYROW:      // copy 
		//2. CFS가 아닐때 Package Qty 및 Type이 변경될 때 Description of Goods의 첫줄을 변경한다. QTY + TYPE의 desc + SAID TO CONTAIN:
		var bkgPod = parent.frames("t1frame").document.form.bkg_pod_cd.value;
		var bkgPol = parent.frames("t1frame").document.form.bkg_pol_cd.value;
		if(ComGetObjValue(parent.frames("t1frame").document.form.rcv_term_cd) !="S"
			||(bkgPod.substring(0,2)=="VN" 
				&& bkgPol.substring(0,2)=="KR"
				&& ComGetObjValue(parent.frames("t1frame").document.form.rcv_term_cd) =="S"
				&& ComGetObjValue(parent.frames("t1frame").document.form.de_term_cd) =="Y")){
//			formObj.cntr_cmdt_desc.value = formObj.cntr_desc.value;
			var cntr_cmdt_desc = "";
			var cntrTpSzDesc = new Array (
					    new Array ("A2","20FR"), new Array ("A4","40FR"), new Array ("A5","40HA"),
						new Array ("D2","20ST"), new Array ("D3","2OFT"),
						new Array ("D4","40ST"), new Array ("D5","40HC"),
						new Array ("D7","45HC"), new Array ("D8","48ST"),
						new Array ("D9","48HC"),
						new Array ("DW","53ST"), new Array ("DX","53HC"),
						new Array ("F2","20FR"), new Array ("F4","40FR"), new Array ("F5","40FT"),
						new Array ("O2","20OT"), new Array ("O4","40OT"), new Array ("O5","40OT"),
						new Array ("P2","20PF"), new Array ("P4","40PF"),
						new Array ("R2","20RF"), new Array ("R4","40RF"), new Array ("R5","40HR"), new Array ("R7","45HR"), new Array ("R9","40HR"), /// 2011.06.20, 2011.06.23
						new Array ("S2","20OT"), new Array ("S4","40OT"),
						new Array ("T2","20TK"), new Array ("T4","40TK"));
			var qtySheet = parent.frames("t1frame").sheetObjects[0];
			var only1cntr = true;
			if(qtySheet.Rows>2) only1cntr = false;
			
			for(var qtyIdx = 1; qtyIdx<qtySheet.Rows; qtyIdx++){
				for(var i = 0; i<cntrTpSzDesc.length; i++) {
					if (qtySheet.CellValue(qtyIdx, "cntr_tpsz_cd") == (cntrTpSzDesc[i][0])) {
						var tpszDesc = qtySheet.CellValue(qtyIdx, "op_cntr_qty") + "X" + cntrTpSzDesc[i][1];
						if(parseInt(qtySheet.CellValue(qtyIdx, "op_cntr_qty"))>1) only1cntr = false;
						if(cntr_cmdt_desc==""){
							cntr_cmdt_desc = tpszDesc;
						} else {
							cntr_cmdt_desc = cntr_cmdt_desc + ", " + tpszDesc;
						}
					}					
				}
			}
			
			if(cntr_cmdt_desc!=""){
				if(only1cntr){
					formObj.cntr_cmdt_desc.value = cntr_cmdt_desc + " CONTAINER SAID TO CONTAIN:";
				} else {
					formObj.cntr_cmdt_desc.value = cntr_cmdt_desc + " CONTAINER(S) SAID TO CONTAIN:";	
				}
			}
		}

		getPckDesc();
		formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\r\n" + formObj.cstms_desc.value;
		break;
	} // end of switch
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
		if (ComIsEmpty(formObj.pck_qty.value) || formObj.pck_qty.value == '0') {
			ComShowMessage(ComGetMsg('BKG00505'));
			ComSetFocus(formObj.pck_qty);
			return false;
		}
		if (ComIsEmpty(formObj.pck_tp_cd.value)) {
			ComShowMessage(ComGetMsg('BKG00504'));
			ComSetFocus(formObj.pck_tp_cd);
			return false;
		}
		if(ComTrim(formObj.cstms_desc.value)==""||formObj.cstms_desc.value==null){
			ComShowMessage(ComGetMsg('BKG00767', "[Customs Description]"));  
			ComSetFocus(formObj.cstms_desc);
			return false;
		}		
	}
	if (ComIsEmpty(formObj.act_wgt.value)||formObj.act_wgt.value == "0" ||formObj.act_wgt.value=="0.000") {
		formObj.act_wgt.value = parent.frames("t1frame").document.form.act_wgt.value;
	}
	if (parent.document.frames("t1frame").form.doc_tp_cd.value == "S" &&
		parent.document.frames("t2frame").form &&
		parent.document.frames("t2frame").form.kr_cstms_cust_tp_cd.Code == "S"){
		if(formObj.act_wgt.value != formObj.act_wgt2.value 
				|| formObj.pck_qty.value != formObj.pck_qty2.value ){
			var msg = "There is one more discrepancy of quantity ALPS and E-SVC.\n";
			msg = msg + "[ALPS] PKG : " + formObj.pck_qty.value + " " + formObj.pck_tp_cd.value + " / " +
					       	   "WGT : " + formObj.act_wgt.value + " " + ComGetObjValue(formObj.wgt_ut_cd) + "\n" +
						"[E-SVC] PKG : " + formObj.pck_qty2.value + " " + formObj.pck_tp_cd2.value + " / " +
						       "WGT : " + formObj.act_wgt2.value + " " + ComGetObjValue(formObj.wgt_ut_cd2);
			if (!ComShowConfirm(msg)) {
				return false;
			}
		}
	}
	
    if( ComIsEmpty(formObj.aes_expt_ctnt)){
   	   formObj.aes_expt_ctnt.value = "";
    }
	if( ComIsEmpty(formObj.ndr_ref_ctnt)){
        formObj.ndr_ref_ctnt.value = "";
    }
	
	var size = formObj.aes_tp_cd.length;
	for(var i = 0; i < size; i++) {
		if(formObj.aes_tp_cd[i].checked) {
			var objs = document.all.item("showXptLicNo");
// 2012.12.17 aes_expt_ctnt는 항상 입력가능하도록 수정함.		
//			if (formObj.aes_tp_cd[i].value=="EX"&&formObj.aes_expt_id.Code!=""&&formObj.aes_expt_ctnt.value!=""){	
//        		document.all.showXptLicNo.style.visibility = 'visible';
//	         	ComAlertFocus(formObj.aes_expt_id, ComGetMsg("BKG00198"));
//				return false;
//			}		
			switch(formObj.aes_tp_cd[i].value) {
		        case "AE":     
		        	if(formObj.aes_inlnd_trns_no.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_inlnd_trns_no, ComGetMsg("BKG08245", "AES (AES ITN)" ));
		        		return false;
		        	}
		        	if(!ComIsAesNo(formObj.aes_inlnd_trns_no.value)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));		        		
		        		return false;
		        	}else{
		        		var re = new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
		        		formObj.aes_inlnd_trns_no.value  = formObj.aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
		        	}
		        	break;
		        	
		        case "PA": 
		        	if(formObj.aes_pta_no1.value==''||formObj.aes_pta_no1.value.length<9){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		             	ComAlertFocus(formObj.aes_pta_no1, ComGetMsg("BKG08245", "PTA (Post Agent)" ));
		        		return false;
		        	}
		        	if(formObj.aes_pta_no2.value==''||formObj.aes_pta_no2.value.length<9){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_pta_no2, ComGetMsg("BKG08245", "PTA (Post Agent)" ));
		        		return false; 
		        	}
		        	if(formObj.aes_pta_dt.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_pta_dt, ComGetMsg("BKG08245", "PTA (Post Agent)" ));
		        		return false;
		        	}			        	 
	        	 	var sVal = ComTrimAll(formObj.aes_pta_dt.value, "-", "/", ".");
	                if (!ComIsDateMod(formObj.aes_pta_dt.value)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_pta_dt,  ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
		        		return false;
	                } else {
	                	var re = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
	                	formObj.aes_pta_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	                }		                    
	                break;
	                
		        case "PU":
		        	if(formObj.aes_ptu_no.value==''||formObj.aes_ptu_no.value.length<9){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_ptu_no, ComGetMsg("BKG08245", "PTU (Post USPPI)" ));
		        		return false;
		        	}
		        	if(formObj.aes_ptu_dt.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_ptu_dt, ComGetMsg("BKG08245", "PTU (Post USPPI)" ));
		        		return false;
		        	}
		        	var sVal = ComTrimAll(formObj.aes_ptu_dt.value, "-", "/", ".");
	                if (!ComIsDateMod(formObj.aes_ptu_dt.value)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
		        		return false;
	                }else{
	                	var re = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
	                	formObj.aes_ptu_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	                }		
		        	break;
		        	
		        case "DN":				        	 
		        	if(formObj.aes_dwn_no.value==''||formObj.aes_dwn_no.value.length<9){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_dwn_no, ComGetMsg("BKG08245", "Down (AES Down)" ));
		        		return false;
		        	}
		        	if(formObj.aes_dwn_dt.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_dwn_dt, ComGetMsg("BKG08245", "Down (AES Down)" ));
		        		return false;
		        	}		        	
		        	var sVal = ComTrimAll(formObj.aes_dwn_dt.value, "-", "/", ".");
	                if (!ComIsDateMod(formObj.aes_dwn_dt.value)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
		        		return false;
	                } else {
	                	var re = new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
	                	formObj.aes_dwn_dt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	                }		
		        	break;
		        	
		        case "EX":
		        	if(formObj.aes_expt_id.Code==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.aes_expt_id, ComGetMsg("BKG08245", "Exception" ));
		        		return false;
		        	}
		        	break;
		 	}
	  	}
	}
	size = formObj.caed_tp_cd.length;	
	for(var i = 0; i < size; i++) {
		if(formObj.caed_tp_cd[i].checked) {
			var objs = document.all.item("showXptLicNo");
			switch(formObj.caed_tp_cd[i].value) {
		        case "CE": 
		        	if( ComIsEmpty(formObj.caed_ctnt)){
			            formObj.caed_ctnt.value = "";
			        }
		        	if(formObj.caed_ctnt.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.caed_ctnt, ComGetMsg("BKG08245", "CAED No." ));
		        		return false;
		        	}
		        	var sVal = ComTrimAll(formObj.caed_ctnt.value, "-", "/", ".");
		        	if (!ComIsCaedNo(sVal)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.caed_ctnt, ComGetMsg("COM12128","a valid format : NNANNN(6) - AAANNN(6) - NNNNNNNNNNN(11)"));				        		 
		        		return false;
		        	}else{
		        		var re = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
		        		var re2 = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
		        		if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
		 	   				formObj.caed_ctnt.value  =sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3').toUpperCase();
			   			}else{
			   				formObj.caed_ctnt.value  =sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3').toUpperCase();
			   			}
		        	}
		        	break;
		        	
		        case "G7":
		        	if( ComIsEmpty(formObj.g7_edi_ctnt)){
			            formObj.g7_edi_ctnt.value = "";
			        }
		        	if(formObj.g7_edi_ctnt.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		             	ComAlertFocus(formObj.g7_edi_ctnt, ComGetMsg("BKG08245", "G7 EDI No." ));
		        		return false;
		        	}	        	 
	        	 	var sVal = ComTrimAll(formObj.g7_edi_ctnt.value, "-", "/", ".");
	                if (!ComIsG7EdiNo(sVal)){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.g7_edi_ctnt, ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));				        		 
		        		return false;
	                }else{
	                	var re = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	                	formObj.g7_edi_ctnt.value = sVal.replace(re,'$1' + "-" + '$2');
	                }		                    
	                break;
	                
		        case "SM":
		        	if(formObj.mf_smry_rpt_no.value==''){
		        		document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.mf_smry_rpt_no, ComGetMsg("BKG08245", "Summary Report" ));
		        		return false;
		        	}
		        	if(formObj.mf_smry_rpt_no.value.length<4){
			        	document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.mf_smry_rpt_no,  ComGetMsg("COM12114", "Summary Report"));		        		
		        		return false;
		        	}
		        	if(formObj.mf_smry_rpt_no.value.length>4){
			        	document.all.showXptLicNo.style.visibility = 'visible';
		        		ComAlertFocus(formObj.mf_smry_rpt_no,  ComGetMsg("COM12114", "Summary Report"));
		        		return false;
		        	}
		        	break;
		        	
		        case "EX":
		        	if( ComIsEmpty(formObj.b13a_xpt_ctnt)){
			            formObj.b13a_xpt_ctnt.value = "";
			        }		        	
		        	if(formObj.b13a_xpt_ctnt.value==''){	
		        		document.all.showXptLicNo.style.visibility = 'visible';		
		        		ComAlertFocus(formObj.b13a_xpt_ctnt, ComGetMsg("BKG08245", "EXD (Form B13A)" ));
		        		return false;
		        	}		        	
		        	var sVal = ComTrimAll(formObj.b13a_xpt_ctnt.value, "-", "/", " ",":");
	                if (!ComIsB13aXptNo(sVal)){
		        		document.all.showXptLicNo.style.visibility = 'visible';		
		        		ComAlertFocus(formObj.b13a_xpt_ctnt, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));				        		 
		        		return false;
	                } else { 
	                	var re = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
	                	formObj.b13a_xpt_ctnt.value  = sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	                }		
		        	break;
		        	
		        case "IT":
		        	if(formObj.cgo_ctrl_no.value==''){	
		        		document.all.showXptLicNo.style.visibility = 'visible';		
		        		ComAlertFocus(formObj.cgo_ctrl_no, ComGetMsg("BKG08245", "In-Transit Cargo" ));
		        		return false;
		        	}
		        	break;
		        	
		        case "ND":
// 2012.12.17 ndr_ref_ctnt는 항상 입력 가능하도록 수정함.			        	
//		        	if (formObj.ndr_ref_id.Code!=""&&formObj.ndr_ref_ctnt.value!=""){	
//	                    document.all.showXptLicNo.style.visibility = 'visible';	
//                    	ComAlertFocus(formObj.ndr_ref_id, ComGetMsg("BKG00198"));
//                  	    return false;
//                   }
		        	if(formObj.ndr_ref_id.Code=='' ){			
		        		document.all.showXptLicNo.style.visibility = 'visible';		
		        		ComAlertFocus(formObj.ndr_ref_id, ComGetMsg("BKG08245", "No Declaration" ));
		        		return false;
		        	}
		        	break;
		 	}
	  	}
	}
	
	//Korea
	if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
	    var Value = "";
	    var Value2 = "";
	    var ibflag = "";
	    var pkg = 0;
	    var sumQty = 0;
		var wgt = 0.000;
		var T=Number("1e"+1);
		for (var j=1; j<div1sheet1.RowCount+1; j++) {
			ibflag = div1sheet1.CellValue(j,"ibflag");
			Value  = div1sheet1.CellValue(j,"xpt_lic_no");
			Value2 = div1sheet1.CellValue(j,"ts_ref_no");
			if ("D"!=ibflag) {
				pkg += parseInt(div1sheet1.CellValue(j,"pck_qty"));
				wgt += parseFloat(div1sheet1.CellValue(j,"mf_wgt"));
			}
			sumQty = Math.round((pkg + wgt) * T) / T;
			if ("I"==ibflag || "U"==ibflag) {
				if (""==Value && ""==Value2) {
	             	ComShowCodeMessage("COM12138","Export License Number","Other Reference No.");
	             	div1sheet1.SelectCell(j,"xpt_lic_no");
					return false;
				}
				if (0<Value.length && 14>Value.length) {
					ComShowCodeMessage("BKG00257");
					div1sheet1.SelectCell(j,"xpt_lic_no");
					return false;
				} else if (14<Value.length) {
//					var total = 0;
//					for (var i=1; i<15; i++) {
//						switch (i%3) {
//							case 1:
//								total += parseInt(((Value.substring(i-1,i)*7)%10));
//								break;	
//							case 2:
//								total += parseInt(((Value.substring(i-1,i)*3)%10));
//								break;
//							case 0:
//								total += parseInt((Value.substring(i-1,i)*1));
//								break;
//						}
//					}
//					chkDigit = (10-(total%10))%10;
//					if (15==Value.length) {
//			 			if (chkDigit != Value.substring(14,15)) {
//			             	ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
//			             	div1sheet1.CellValue(j,"xpt_lic_no") = Value.substring(0,14);
//			             	div1sheet1.SelectCell(j,"xpt_lic_no");
//			 				return false;
//			 			}
//			 		} else {
//			 			div1sheet1.CellValue2(j,"xpt_lic_no") = Value+chkDigit;
//			 		}
				}
			}
		}

		// 2010-06-30 KMJ E-BKG & SI Validation 로직 추가
		if (div1sheet1.RowCount > 0) {
			var bkg_pck_qty = formObj.pck_qty.value.replace(",", "");
			var bkg_act_wgt = formObj.act_wgt.value.replace(",", "");
			var exp_pck_qty = div1sheet1.ComputeSum("9");
			var exp_mf_wgt  = div1sheet1.ComputeSum("11");
			
			if (bkg_pck_qty != exp_pck_qty || bkg_act_wgt != exp_mf_wgt) {
				var mText = new Array(bkg_pck_qty, bkg_act_wgt, exp_pck_qty, exp_mf_wgt);
				
				if (!ComShowCodeConfirm2("BKG00199", mText)) {
					return false;
				}
			}
		}
	}

	// 2013.01.29 Brazil Tax ID length check	
	if(ComGetLenByByte(formObj.br_shpr_tax_id.value) > 14){
		document.all.showXptLicNo.style.visibility = 'visible';
		ComAlertFocus(formObj.br_shpr_tax_id, ComGetMsg("BKG40106", "Shipper CNPJ", "14" ));
		return false;
	}
    if(ComGetLenByByte(formObj.br_cnee_tax_id.value) > 14){
    	document.all.showXptLicNo.style.visibility = 'visible';
    	ComAlertFocus(formObj.br_cnee_tax_id, ComGetMsg("BKG40106", "Consignee CNPJ", "14" ));
	   return false;
    }
    if(ComGetLenByByte(formObj.br_ntfy_tax_id.value) > 14){
    	document.all.showXptLicNo.style.visibility = 'visible';
    	ComAlertFocus(formObj.br_ntfy_tax_id, ComGetMsg("BKG40106", "Notify CNPJ", "14" ));
	   return false;
    }
    
    // CHM-201642153 New Regulation of Turkish Customs 관련 HS CODE/ TAX NUMBER란 필수입력으로 변경 요청->e-booking 에도 적용 
    if(("TR"==parent.frames("t1frame").document.form.bkg_del_cd.value.substring(0,2)
    		|| "TR"==parent.frames("t1frame").document.form.bkg_pod_cd.value.substring(0,2))
    			&& parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){    	
    	
    	if(ComIsEmpty(formObj.tr_cnee_tax_id.value)){
    		//document.all.showXptLicNo.style.visibility = 'visible';
    		showXptLicNo();
    		ComAlertFocus(formObj.tr_cnee_tax_id, ComGetMsg("BKG95116"));
    		return false;
    	} else if(ComIsEmpty(formObj.tr_ntfy_tax_id.value)){
    		//document.all.showXptLicNo.style.visibility = 'visible';
    		showXptLicNo();
    		ComAlertFocus(formObj.tr_ntfy_tax_id, ComGetMsg("BKG95116"));
    		return false;
    	}
    }
    
    //2013.03.22 [CHM-201323590] ALPS BKGDoc Reefer 화물 SI M&D 화면 Pop-Up Message 설정 요청 작업
    if(parent.frames("t1frame").document.form.rc_flg.checked == true && parent.frames("t4frame").document.form.dg_cmdt_desc.value != ""){
		if(!ComShowCodeConfirm("BKG02216")){
			return false;
		}
	}
    
    //[CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block
	if(formObj.meas_qty.value<=0 && "BH"==parent.frames("t1frame").document.form.bkg_del_cd.value.substring(0,2)){
		ComAlertFocus(formObj.meas_qty, ComGetMsg("BKG95112"));
		return false;
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
	var formObj = document.form;	
	if( validate_Mandatory_Item(sheetObject1, formObj) == false){
		return false;
	}
	if(validateForm(sheetObject1, formObj, IBSAVE)==false){
		return false;
	}	
	return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨
 * TAB에 상관 없이 동일 이름의 함수를 가짐
 * 내용은 TAB에 맞게 구현
 * 각 화면에서 Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
 */
function getSaveStringForUpload() {
	var formObj = document.form;

	// 중복전송을 막기 위해 form상의 response data를 지운다
	var sXml = formObj.sXml.value;
	formObj.sXml.value = "";

	formObj.f_cmd.value = MULTI;
	/* Unmask: 문자형이 숫자형으로 바뀔 수 있도록, 콤마 등에 Separator를 제거 함 */
	ComClearSeparator(formObj.pck_qty);
	ComClearSeparator(formObj.act_wgt);
	ComClearSeparator(formObj.meas_qty);

	setExportInfoToSheet();
	
	setPoOtherNoToSheet();

	var params = FormQueryString(formObj);
	// grid for save bkg_xpt_imp_lic_no
	params = params + "&" + ComSetPrifix(sheetObject1.GetSaveString(true), "sheet1_");	
	// cntr po no 
	params = params + "&" + ComSetPrifix(div3sheet3.GetSaveString(true), "sheet2_");
	params = params + "&" + ComSetPrifix(div3sheet1.GetSaveString(true), "sheet3_");
	params = params + "&" + ComSetPrifix(div3sheet2.GetSaveString(true), "sheet4_");
	// b/l rider
	params = params + "&" + ComSetPrifix(div5sheet1.GetSaveString(true), "sheet5_");
	// Warfage
	params = params + "&" + ComSetPrifix(div7sheet2.GetSaveString(true), "sheet6_");
	// indonesia
	if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0){
		params = params + "&" + ComSetPrifix(div8sheet1.GetSaveString(true), "sheet7_"); 
	}
	// Ship Id
	params = params + "&" + ComSetPrifix(div9sheet1.GetSaveString(true), "sheet9_");
	
	// Clause Lock
	params = params + "&" + ComSetPrifix(div10sheet1.GetSaveString(true), "sheet10_");
	
	// M&D에서 Rout 가 필요함.
	params = params + "&" + "por_cd=" + parent.frames("t1frame").document.form.bkg_por_cd.value;
	params = params + "&" + "pol_cd=" + parent.frames("t1frame").document.form.bkg_pol_cd.value;
	params = params + "&" + "pod_cd=" + parent.frames("t1frame").document.form.bkg_pod_cd.value;
	params = params + "&" + "del_cd=" + parent.frames("t1frame").document.form.bkg_del_cd.value;
	formObj.sXml.value = sXml;
	return (params);
}  

//색 비교 처리
function compareItem() {
	var formObj = document.form;
	setDiffCheckColor(formObj.mk_desc.value,   	formObj.mk_desc2.value,   "mk_desc2");
	
	setDiffCheckColor(formObj.pck_qty.value,   	formObj.pck_qty2.value,   "pck_qty2");
	setDiffCheckColor(formObj.pck_tp_cd.value, 	formObj.pck_tp_cd2.value, "pck_tp_cd2");
	setDiffCheckColor(formObj.act_wgt.value,   	formObj.act_wgt2.value,   "act_wgt2");
	setDiffCheckColor(formObj.wgt_ut_cd.value, 	formObj.wgt_ut_cd2.value, "wgt_ut_cd2");
	setDiffCheckColor(formObj.meas_qty.value,  	formObj.meas_qty2.value,  "meas_qty2");
	setDiffCheckColor(formObj.meas_ut_cd.value, formObj.meas_ut_cd2.value,  "meas_ut_cd2");

	setDiffCheckColor(formObj.dg_cmdt_desc.value, formObj.dg_cmdt_desc2.value, "dg_cmdt_desc2");
	setDiffCheckColor(formObj.cstms_desc.value,	formObj.cstms_desc2.value, "cstms_desc2");
}

function dataCopy() {
 	doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC02);
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
}

function getExportInfoToForm(){
	var formObj = document.form;
	for(var i=1; i<sheetObject1.Rows; i++){			
		if(sheetObject1.CellValue(i, "cnt_cd")=="KR"){
			if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
				var newRow = div1sheet1.DataInsert(-1);
				div1sheet1.RowStatus(newRow) = "U";
				div1sheet1.CellValue2(newRow, "seq") 			= div1sheet1.Rows;  
				div1sheet1.CellValue2(newRow, "Check") 			= sheetObject1.CellValue(i, "Check");
				div1sheet1.CellValue2(newRow, "bkg_no") 		= sheetObject1.CellValue(i, "bkg_no");
				div1sheet1.CellValue2(newRow, "io_bnd_cd") 		= sheetObject1.CellValue(i, "io_bnd_cd");
				div1sheet1.CellValue2(newRow, "xpt_imp_seq") 	= sheetObject1.CellValue(i, "xpt_imp_seq");
				div1sheet1.CellValue2(newRow, "cnt_cd") 		= sheetObject1.CellValue(i, "cnt_cd");
				div1sheet1.CellValue2(newRow, "xpt_lic_no") 	= sheetObject1.CellValue(i, "xpt_lic_no");
				div1sheet1.CellValue2(newRow, "ts_ref_no") 		= sheetObject1.CellValue(i, "ts_ref_no");
				div1sheet1.CellValue2(newRow, "pck_qty") 		= sheetObject1.CellValue(i, "pck_qty");
				div1sheet1.CellValue2(newRow, "pck_tp_cd") 		= sheetObject1.CellValue(i, "pck_tp_cd");
				div1sheet1.CellValue2(newRow, "mf_wgt") 		= sheetObject1.CellValue(i, "mf_wgt");
				div1sheet1.CellValue2(newRow, "wgt_ut_cd") 		= sheetObject1.CellValue(i, "wgt_ut_cd");
				div1sheet1.CellValue2(newRow, "divd_seq") 		= sheetObject1.CellValue(i, "divd_seq");
				div1sheet1.CellValue2(newRow, "sam_pck_id") 	= sheetObject1.CellValue(i, "sam_pck_id");
				div1sheet1.CellValue2(newRow, "sam_pck_qty") 	= sheetObject1.CellValue(i, "sam_pck_qty");
				div1sheet1.CellValue2(newRow, "sam_pck_tp_cd") 	= sheetObject1.CellValue(i, "sam_pck_tp_cd");
			}
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="US"){
			if(sheetObject1.CellValue(i, "aes_tp_cd") == "AE"){
				formObj.aes_tp_cd[0].checked = true;
				formObj.aes_inlnd_trns_no.value = sheetObject1.CellValue(i, "aes_inlnd_trns_no");
			} else if(sheetObject1.CellValue(i, "aes_tp_cd") == "PA"){
				formObj.aes_tp_cd[1].checked = true;
				formObj.aes_pta_no1.value = sheetObject1.CellValue(i, "aes_pta_no1");
				formObj.aes_pta_no2.value = sheetObject1.CellValue(i, "aes_pta_no2");
				formObj.aes_pta_dt.value = sheetObject1.CellValue(i, "aes_pta_dt");				
			} else if(sheetObject1.CellValue(i, "aes_tp_cd") == "PU"){
				formObj.aes_tp_cd[2].checked = true;
				formObj.aes_ptu_no.value = sheetObject1.CellValue(i, "aes_ptu_no");
				formObj.aes_ptu_dt.value = sheetObject1.CellValue(i, "aes_ptu_dt");				
			} else if(sheetObject1.CellValue(i, "aes_tp_cd") == "DN"){
				formObj.aes_tp_cd[3].checked = true;
				formObj.aes_dwn_no.value = sheetObject1.CellValue(i, "aes_dwn_no");
				formObj.aes_dwn_dt.value = sheetObject1.CellValue(i, "aes_dwn_dt");	
			} else if(sheetObject1.CellValue(i, "aes_tp_cd") == "EX"){
				formObj.aes_tp_cd[4].checked = true;
				comboObjects[0].Code = sheetObject1.CellValue(i, "aes_expt_id");					
			}
			formObj.aes_expt_ctnt.value = sheetObject1.CellValue(i, "aes_expt_ctnt");
			
			if( ComTrim(sheetObject1.CellValue(i,"vin_ctnt")) == "" ){
    			formObj.vin_exist_flg.checked = false;    			
    		}else{
    			formObj.vin_exist_flg.checked = true;
    			formObj.exp_vin_ctnt.value = sheetObject1.CellValue(i, "vin_ctnt");
    		}
			
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="MX"){
			formObj.mx_shpr_tax_id.value 	= sheetObject1.CellValue(i, "mx_shpr_tax_id");
			formObj.mx_cnee_tax_id.value 	= sheetObject1.CellValue(i, "mx_cnee_tax_id");
			formObj.mx_ntfy_tax_id.value 	= sheetObject1.CellValue(i, "mx_ntfy_tax_id");									
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="TR"){
			formObj.tr_shpr_tax_id.value 	= sheetObject1.CellValue(i, "tr_shpr_tax_id");
			formObj.tr_cnee_tax_id.value 	= sheetObject1.CellValue(i, "tr_cnee_tax_id");
			formObj.tr_ntfy_tax_id.value 	= sheetObject1.CellValue(i, "tr_ntfy_tax_id");	
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="IL"){
			formObj.il_shpr_tax_id.value 	= sheetObject1.CellValue(i, "il_shpr_tax_id");
			formObj.il_cnee_tax_id.value 	= sheetObject1.CellValue(i, "il_cnee_tax_id");
			formObj.il_ntfy_tax_id.value 	= sheetObject1.CellValue(i, "il_ntfy_tax_id");	
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="LB"){
			formObj.lb_shpr_tax_id.value 	= sheetObject1.CellValue(i, "lb_shpr_tax_id");
			formObj.lb_cnee_tax_id.value 	= sheetObject1.CellValue(i, "lb_cnee_tax_id");
			formObj.lb_ntfy_tax_id.value 	= sheetObject1.CellValue(i, "lb_ntfy_tax_id");
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="BR"){
			// brazil 추가 (2013.01.07)
			formObj.br_shpr_tax_id.value 	= sheetObject1.CellValue(i, "br_shpr_tax_id");
			formObj.br_cnee_tax_id.value 	= sheetObject1.CellValue(i, "br_cnee_tax_id");
			formObj.br_ntfy_tax_id.value 	= sheetObject1.CellValue(i, "br_ntfy_tax_id");	
			formObj.brz_decl_no.value    	= sheetObject1.CellValue(i, "brz_decl_no");
			formObj.brz_decl_cpy_desc_flg.value = sheetObject1.CellValue(i, "brz_decl_cpy_desc_flg");
			formObj.shpr_tax_cpy_desc_flg.value	= sheetObject1.CellValue(i, "shpr_tax_cpy_desc_flg");
			formObj.cnee_tax_cpy_desc_flg.value	= sheetObject1.CellValue(i, "cnee_tax_cpy_desc_flg");	
			formObj.ntfy_tax_cpy_desc_flg.value	= sheetObject1.CellValue(i, "ntfy_tax_cpy_desc_flg");
		} else if(sheetObject1.CellValue(i, "cnt_cd")=="CA"){
			if(sheetObject1.CellValue(i, "caed_tp_cd")=="CE"){
				formObj.caed_tp_cd[0].checked = true;
			} else if(sheetObject1.CellValue(i, "caed_tp_cd")=="G7"){
				formObj.caed_tp_cd[1].checked = true;
			} else if(sheetObject1.CellValue(i, "caed_tp_cd")=="SM"){
				formObj.caed_tp_cd[2].checked = true;
			} else if(sheetObject1.CellValue(i, "caed_tp_cd")=="EX"){
				formObj.caed_tp_cd[3].checked = true;
			} else if(sheetObject1.CellValue(i, "caed_tp_cd")=="IT"){
				formObj.caed_tp_cd[4].checked = true;
			} else if(sheetObject1.CellValue(i, "caed_tp_cd")=="ND"){
				formObj.caed_tp_cd[5].checked = true;	
			}
			formObj.caed_ctnt.value 		= sheetObject1.CellValue(i, "caed_ctnt");
			formObj.g7_edi_ctnt.value 		= sheetObject1.CellValue(i, "g7_edi_ctnt");
			formObj.b13a_xpt_ctnt.value 	= sheetObject1.CellValue(i, "b13a_xpt_ctnt");
			formObj.mf_smry_rpt_no.value 	= sheetObject1.CellValue(i, "mf_smry_rpt_no");
			formObj.cgo_ctrl_no.value 		= sheetObject1.CellValue(i, "cgo_ctrl_no");
			comboObjects[1].Code 			= sheetObject1.CellValue(i, "ndr_ref_id");
			formObj.ndr_ref_ctnt.value	 	= sheetObject1.CellValue(i, "ndr_ref_ctnt");				
		}
	}
}

function setExportInfoToSheet(){
	var formObj = document.form;
	var newRow = 0;
	sheetObject1.RemoveAll();
	var usaExportData = formObj.aes_inlnd_trns_no.value 
						+ formObj.aes_pta_no1.value
						+ formObj.aes_pta_no2.value
						+ formObj.aes_pta_dt.value
						+ formObj.aes_ptu_no.value
						+ formObj.aes_ptu_dt.value
						+ formObj.aes_dwn_no.value
						+ formObj.aes_dwn_dt.value
						+ comboObjects[0].Text
						+ formObj.aes_expt_ctnt.value;
	if (usaExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "US";
		if(formObj.aes_tp_cd[0].checked == true){
			sheetObject1.CellValue2(newRow, "aes_tp_cd") 	= "AE";
		} else if(formObj.aes_tp_cd[1].checked == true){
			sheetObject1.CellValue2(newRow, "aes_tp_cd") 	= "PA";
		} else if(formObj.aes_tp_cd[2].checked == true){
			sheetObject1.CellValue2(newRow, "aes_tp_cd") 	= "PU";
		} else if(formObj.aes_tp_cd[3].checked == true){
			sheetObject1.CellValue2(newRow, "aes_tp_cd") 	= "DN";
		} else if(formObj.aes_tp_cd[4].checked == true){
			sheetObject1.CellValue2(newRow, "aes_tp_cd") 	= "EX";
		}
		sheetObject1.CellValue2(newRow, "aes_inlnd_trns_no")= formObj.aes_inlnd_trns_no.value;
		sheetObject1.CellValue2(newRow, "aes_pta_no1") 		= formObj.aes_pta_no1.value;	
		sheetObject1.CellValue2(newRow, "aes_pta_no2") 		= formObj.aes_pta_no2.value;		
		sheetObject1.CellValue2(newRow, "aes_pta_dt") 		= formObj.aes_pta_dt.value;		
		sheetObject1.CellValue2(newRow, "aes_ptu_no") 		= formObj.aes_ptu_no.value;		
		sheetObject1.CellValue2(newRow, "aes_ptu_dt") 		= formObj.aes_ptu_dt.value;		
		sheetObject1.CellValue2(newRow, "aes_dwn_no") 		= formObj.aes_dwn_no.value;		
		sheetObject1.CellValue2(newRow, "aes_dwn_dt") 		= formObj.aes_dwn_dt.value;	
		sheetObject1.CellValue2(newRow, "aes_expt_id") 		= comboObjects[0].Code;		
		sheetObject1.CellValue2(newRow, "aes_expt_ctnt") 	= formObj.aes_expt_ctnt.value;	
		sheetObject1.CellValue2(newRow, "vin_ctnt") 	= formObj.exp_vin_ctnt.value;	
	}
	
	var mexicoExportData = formObj.mx_shpr_tax_id.value 
						+ formObj.mx_cnee_tax_id.value
						+ formObj.mx_ntfy_tax_id.value;
	if(mexicoExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "MX";
		sheetObject1.CellValue2(newRow, "mx_shpr_tax_id") 	= formObj.mx_shpr_tax_id.value; 
		sheetObject1.CellValue2(newRow, "mx_cnee_tax_id") 	= formObj.mx_cnee_tax_id.value;
		sheetObject1.CellValue2(newRow, "mx_ntfy_tax_id") 	= formObj.mx_ntfy_tax_id.value;
	}

	var turkeyExportData = formObj.tr_shpr_tax_id.value 
						+ formObj.tr_cnee_tax_id.value
						+ formObj.tr_ntfy_tax_id.value;
	if(turkeyExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "TR";
		sheetObject1.CellValue2(newRow, "tr_shpr_tax_id") 	= formObj.tr_shpr_tax_id.value; 
		sheetObject1.CellValue2(newRow, "tr_cnee_tax_id") 	= formObj.tr_cnee_tax_id.value;
		sheetObject1.CellValue2(newRow, "tr_ntfy_tax_id") 	= formObj.tr_ntfy_tax_id.value;
	}
	
	var israelExportData = formObj.il_shpr_tax_id.value 
						+ formObj.il_cnee_tax_id.value
						+ formObj.il_ntfy_tax_id.value;
	if(israelExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "IL";
		sheetObject1.CellValue2(newRow, "il_shpr_tax_id") 	= formObj.il_shpr_tax_id.value; 
		sheetObject1.CellValue2(newRow, "il_cnee_tax_id") 	= formObj.il_cnee_tax_id.value;
		sheetObject1.CellValue2(newRow, "il_ntfy_tax_id") 	= formObj.il_ntfy_tax_id.value;
	}
	
	var lebanonExportData = formObj.lb_shpr_tax_id.value 
						+ formObj.lb_cnee_tax_id.value
						+ formObj.lb_ntfy_tax_id.value;
	if(lebanonExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "LB";
		sheetObject1.CellValue2(newRow, "lb_shpr_tax_id") 	= formObj.lb_shpr_tax_id.value; 
		sheetObject1.CellValue2(newRow, "lb_cnee_tax_id") 	= formObj.lb_cnee_tax_id.value;
		sheetObject1.CellValue2(newRow, "lb_ntfy_tax_id") 	= formObj.lb_ntfy_tax_id.value;
	}
	
	// brazil 추가 (2013.01.07)
	var brazilExportData = formObj.br_shpr_tax_id.value 
						+ formObj.br_cnee_tax_id.value
						+ formObj.br_ntfy_tax_id.value;
	if(brazilExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "BR";
		sheetObject1.CellValue2(newRow, "br_shpr_tax_id") 	= formObj.br_shpr_tax_id.value; 
		sheetObject1.CellValue2(newRow, "br_cnee_tax_id") 	= formObj.br_cnee_tax_id.value;
		sheetObject1.CellValue2(newRow, "br_ntfy_tax_id") 	= formObj.br_ntfy_tax_id.value;
		sheetObject1.CellValue2(newRow, "brz_decl_no") 	    = formObj.brz_decl_no.value;
		sheetObject1.CellValue2(newRow, "brz_decl_cpy_desc_flg") = formObj.brz_decl_cpy_desc_flg.value;
		sheetObject1.CellValue2(newRow, "shpr_tax_cpy_desc_flg") = formObj.shpr_tax_cpy_desc_flg.value;
		sheetObject1.CellValue2(newRow, "cnee_tax_cpy_desc_flg") = formObj.cnee_tax_cpy_desc_flg.value;
		sheetObject1.CellValue2(newRow, "ntfy_tax_cpy_desc_flg") = formObj.ntfy_tax_cpy_desc_flg.value;
	}

	var canadaExportData = formObj.caed_ctnt.value
						+ formObj.g7_edi_ctnt.value
						+ formObj.mf_smry_rpt_no.value
						+ formObj.b13a_xpt_ctnt.value
						+ formObj.cgo_ctrl_no.value
						+ comboObjects[1].Text
						+ formObj.ndr_ref_ctnt.value;
	if(canadaExportData.length>0){
		newRow = sheetObject1.DataInsert(-1);
		sheetObject1.CellValue2(newRow, "cnt_cd") 			= "CA";
		if(formObj.caed_tp_cd[0].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "CE";
		} else if(formObj.caed_tp_cd[1].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "G7";
		} else if(formObj.caed_tp_cd[2].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "SM";
		} else if(formObj.caed_tp_cd[3].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "EX";
		} else if(formObj.caed_tp_cd[4].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "IT";
		} else if(formObj.caed_tp_cd[5].checked == true){
			sheetObject1.CellValue2(newRow, "caed_tp_cd") 	= "ND";
		}
		sheetObject1.CellValue2(newRow, "caed_ctnt")		= formObj.caed_ctnt.value;
		sheetObject1.CellValue2(newRow, "g7_edi_ctnt")		= formObj.g7_edi_ctnt.value;
		sheetObject1.CellValue2(newRow, "mf_smry_rpt_no")	= formObj.mf_smry_rpt_no.value;
		sheetObject1.CellValue2(newRow, "b13a_xpt_ctnt")	= formObj.b13a_xpt_ctnt.value;
		sheetObject1.CellValue2(newRow, "cgo_ctrl_no")		= formObj.cgo_ctrl_no.value;
		sheetObject1.CellValue2(newRow, "ndr_ref_id")		= comboObjects[1].Code;
		sheetObject1.CellValue2(newRow, "ndr_ref_ctnt") 	= formObj.ndr_ref_ctnt.value;
	}

	//korea
	if(Number(ComGetObjValue(formObj.kr_xpt_lic_cnt)) > 0){
		if(div1sheet1.Rows>0){
			for(var j=1;j<div1sheet1.Rows-1;j++){
				newRow = sheetObject1.DataInsert(-1);
				sheetObject1.CellValue2(newRow, "cnt_cd") 		= "KR"; 
				sheetObject1.CellValue2(newRow, "xpt_lic_no") 	= div1sheet1.CellValue(j, "xpt_lic_no");
				sheetObject1.CellValue2(newRow, "ts_ref_no") 	= div1sheet1.CellValue(j, "ts_ref_no");
				sheetObject1.CellValue2(newRow, "pck_qty") 		= div1sheet1.CellValue(j, "pck_qty");
				sheetObject1.CellValue2(newRow, "pck_tp_cd") 	= div1sheet1.CellValue(j, "pck_tp_cd"); 
				sheetObject1.CellValue2(newRow, "mf_wgt") 		= div1sheet1.CellValue(j, "mf_wgt");
				sheetObject1.CellValue2(newRow, "wgt_ut_cd") 	= div1sheet1.CellValue(j, "wgt_ut_cd");
				sheetObject1.CellValue2(newRow, "divd_seq") 	= div1sheet1.CellValue(j, "divd_seq");
				sheetObject1.CellValue2(newRow, "sam_pck_id") 	= div1sheet1.CellValue(j, "sam_pck_id");
				sheetObject1.CellValue2(newRow, "sam_pck_qty") 	= div1sheet1.CellValue(j, "sam_pck_qty");
				sheetObject1.CellValue2(newRow, "sam_pck_tp_cd")= div1sheet1.CellValue(j, "sam_pck_tp_cd");
			}		
		}
	}
	for(var j=1;j<sheetObject1.Rows;j++){
		sheetObject1.RowStatus(newRow)    = "U";
		sheetObject1.CellValue2(j, "bkg_no") 	= formObj.bkg_no.value; 
		sheetObject1.CellValue2(j, "io_bnd_cd") = "O";
	}	
	
	// indonesia
	if(Number(ComGetObjValue(formObj.id_xpt_lic_cnt)) > 0){
		if (0<div8sheet1.RowCount) {
			for (var row=1; row<=div8sheet1.RowCount; row++) {
				if ("I"==div8sheet1.CellValue(row, "ibflag") &&
					""==div8sheet1.CellValue(row, "id_xpt_no") &&
					""==div8sheet1.CellValue(row, "id_xpt_no_iss_dt") &&
					""==div8sheet1.CellValue(row, "id_ofc_cd") &&
					""==div8sheet1.CellValue(row, "id_decl_cd")) {
					div8sheet1.CellValue2(row, "ibflag") = "D";
				}
			}
		}
	}
}

function getPoOtherNoToForm(){
	var formObj = document.form;
	var sObject = div3sheet3;
	var c_row = sObject.LastRow;
	for ( var row = 1; row <= c_row; row++) {
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'BKPO') {
			formObj.bkpo.value = sObject.CellValue(row, "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'LCNO') {
			formObj.lcno.value = sObject.CellValue(row, "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'HINV') {
			formObj.hinv.value = sObject.CellValue(row, "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'LCDT') { // YYYY-MM-DD
			formObj.lcdt.value = sObject.CellValue(row, "cust_ref_no_ctnt");//.getDataString();
			ComAddSeparator(formObj.lcdt);			
		}
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'HPDP') {
			formObj.hpdp.value = sObject.CellValue(row, "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, "bkg_ref_tp_cd") == 'OTHR') {
			formObj.othr.value = sObject.CellValue(row, "cust_ref_no_ctnt");
		}
	}
}

function setPoOtherNoToSheet(){
	var formObj = document.form;
	var sObject = div3sheet3;
	sObject.RemoveAll();
	var row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "BKPO";
	sObject.CellValue(row, "cust_ref_no_ctnt") = formObj.bkpo.value;
	
	row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "LCNO";
	sObject.CellValue(row, "cust_ref_no_ctnt") = formObj.lcno.value;
	
	row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "HINV";
	sObject.CellValue(row, "cust_ref_no_ctnt") = formObj.hinv.value;
	
	row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "LCDT";
	sObject.CellValue(row, "cust_ref_no_ctnt") = ComClearSeparator(formObj.lcdt);
	
	row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "HPDP";
	sObject.CellValue(row, "cust_ref_no_ctnt") = formObj.hpdp.value;
	
	row = sObject.DataInsert(-1);
	sObject.CellValue(row, "bkg_no") = formObj.bkg_no.value;
	sObject.CellValue(row, "bkg_ref_tp_cd") = "OTHR";
	sObject.CellValue(row, "cust_ref_no_ctnt") = formObj.othr.value;	
}

function copyPckWgtMeas(){
	var formObj = document.form;

	formObj.pck_qty.value = formObj.pck_qty2.value;
	if (formObj.pck_tp_cd2.value != null && formObj.pck_tp_cd2.value != ''){
		formObj.pck_tp_cd.value = formObj.pck_tp_cd2.value;
	}

	// mnd에 wgt가 없는 경우 bkg에서 가져온다
	if(parseInt((formObj.act_wgt2.value==".000")?"0":ComClearSeparator(formObj.act_wgt2.value))<=0){
		if(parseInt((formObj.act_wgt2.value==".000")?"0":ComClearSeparator(formObj.act_wgt.value))<=0){
			formObj.act_wgt.value = parent.frames("t1frame").document.form.act_wgt.value;
		}
	} else {
		formObj.act_wgt.value = formObj.act_wgt2.value;
	}
	if(formObj.wgt_ut_cd2.value==null || formObj.wgt_ut_cd2.value==''){
		ComSetObjValue(formObj.wgt_ut_cd, "KGS");
	} else if(formObj.wgt_ut_cd2.value.substring(0,1)=="K"){
		ComSetObjValue(formObj.wgt_ut_cd, "KGS");	
	} else if(formObj.wgt_ut_cd2.value.substring(0,1)=="L"){
		ComSetObjValue(formObj.wgt_ut_cd, "LBS");
	}
	if(formObj.wgt_ut_cd.value==null){
		formObj.wgt_ut_cd.value = parent.frames("t1frame").document.form.wgt_ut_cd.value;
	}
	
	formObj.meas_qty.value = formObj.meas_qty2.value;
	if(formObj.meas_ut_cd2.value==null || formObj.meas_ut_cd2.value=='' ){
		formObj.meas_ut_cd.value = "CBM";
	} else if(formObj.meas_ut_cd2.value.substring(0,1)=="X"){
		formObj.meas_ut_cd.value = "CBM";
	} else if(formObj.meas_ut_cd2.value.substring(0,1)=="E"){
		formObj.meas_ut_cd.value = "CBF";
	} else {
		formObj.meas_ut_cd.value = formObj.meas_ut_cd2.value; 
	}
}

function showMiscDesc() {
	if (document.all.showMisc.style.visibility == 'hidden'){
		document.all.showMisc.style.visibility = 'visible';
	} else {
		document.all.showMisc.style.visibility = 'hidden';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';
	document.all.blRider2.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showInnerPackage() {	
	if(isElementExsits('innerPackage')){
		if (document.all.innerPackage.style.visibility == 'hidden'){
			document.all.innerPackage.style.visibility = 'visible';
		} else {
			document.all.innerPackage.style.visibility = 'hidden';
		}
	}
	
	if(isElementExsits('showXptLicNo')) document.all.showXptLicNo.style.visibility = 'hidden';	
	if(isElementExsits('showXptLicNo2')) document.all.showXptLicNo2.style.visibility = 'hidden';	
	if(isElementExsits('poOther')) document.all.poOther.style.visibility = 'hidden';
	if(isElementExsits('poOther2')) document.all.poOther2.style.visibility = 'hidden';
	if(isElementExsits('blRider2')) document.all.blRider2.style.visibility = 'hidden';
	if(isElementExsits('showMisc')) document.all.showMisc.style.visibility = 'hidden';
	if(isElementExsits('blSurcharge')) document.all.blSurcharge.style.visibility = 'hidden';	
	if(isElementExsits('blSurcharge2')) document.all.blSurcharge2.style.visibility = 'hidden';
	if(isElementExsits('shipId')) document.all.shipId.style.visibility = 'hidden';
	if(isElementExsits('shipId2')) document.all.shipId2.style.visibility = 'hidden';
}

function showXptLicNo(){
	if (document.all.showXptLicNo.style.visibility == 'hidden'){
		document.all.showXptLicNo.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.showXptLicNo.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';
	document.all.blRider2.style.visibility = 'hidden';
	document.all.blRider.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showXptLicNo2(){
	if (document.all.showXptLicNo2.style.visibility == 'hidden'){
		document.all.showXptLicNo2.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.showXptLicNo2.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';
	document.all.blRider2.style.visibility = 'hidden';
	document.all.showMisc.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showPoOther(){
	if (document.all.poOther.style.visibility == 'hidden'){
		document.all.poOther.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.poOther.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';
	document.all.blRider2.style.visibility = 'hidden';
	document.all.blRider.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showPoOther2(){
	if(isElementExsits('poOther2')){
		if (document.all.poOther2.style.visibility == 'hidden'){
			document.all.poOther2.style.visibility = 'visible';
			document.all.cluzLock.style.visibility = 'hidden';
		} else {
			document.all.poOther2.style.visibility = 'hidden';
			document.all.cluzLock.style.visibility = 'visible';
		}
	}
	if(isElementExsits('showXptLicNo')) document.all.showXptLicNo.style.visibility = 'hidden';	
	if(isElementExsits('showXptLicNo2')) document.all.showXptLicNo2.style.visibility = 'hidden';	
	if(isElementExsits('poOther')) document.all.poOther.style.visibility = 'hidden';
	if(isElementExsits('innerPackage')) document.all.innerPackage.style.visibility = 'hidden';	
	if(isElementExsits('blRider2')) document.all.blRider2.style.visibility = 'hidden';	
	if(isElementExsits('blSurcharge')) document.all.blSurcharge.style.visibility = 'hidden';	
	if(isElementExsits('blSurcharge2')) document.all.blSurcharge2.style.visibility = 'hidden';
	if(isElementExsits('shipId')) document.all.shipId.style.visibility = 'hidden';
	if(isElementExsits('shipId2')) document.all.shipId2.style.visibility = 'hidden';
}

function showBlRider2() {
	if (document.all.blRider2.style.visibility == 'hidden'){
		document.all.blRider2.style.visibility = 'visible';
	} else {
		document.all.blRider2.style.visibility = 'hidden';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';	
	document.all.showMisc.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showBlRider() {
	if (document.all.blRider.style.visibility == 'hidden'){
		document.all.blRider.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.blRider.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showSurcharge2() {
	if (document.all.blSurcharge2.style.visibility == 'hidden'){
		document.all.blSurcharge2.style.visibility = 'visible';
	} else {
		document.all.blSurcharge2.style.visibility = 'hidden';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';	
	document.all.showMisc.style.visibility = 'hidden';
	document.all.blRider.style.visibility = 'hidden';	
	document.all.blRider2.style.visibility = 'hidden';	
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showSurcharge() {
	if (document.all.blSurcharge.style.visibility == 'hidden'){
		document.all.blSurcharge.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.blSurcharge.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';	
	document.all.blRider.style.visibility = 'hidden';	
	document.all.blRider2.style.visibility = 'hidden';	
	document.all.shipId.style.visibility = 'hidden';
	document.all.shipId2.style.visibility = 'hidden';
}

function showRefDtl(){
	if (document.all.shipId.style.visibility == 'hidden'){
		document.all.shipId.style.visibility = 'visible';
		document.all.cluzLock.style.visibility = 'hidden';
	} else {
		document.all.shipId.style.visibility = 'hidden';
		document.all.cluzLock.style.visibility = 'visible';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';	
	document.all.showMisc.style.visibility = 'hidden';
	document.all.blRider.style.visibility = 'hidden';	
	document.all.blRider2.style.visibility = 'hidden';
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
}

function showRefDtl2(){
	if (document.all.shipId2.style.visibility == 'hidden'){
		document.all.shipId2.style.visibility = 'visible';
	} else {
		document.all.shipId2.style.visibility = 'hidden';
	}
	document.all.showXptLicNo.style.visibility = 'hidden';	
	document.all.showXptLicNo2.style.visibility = 'hidden';	
	document.all.poOther.style.visibility = 'hidden';
	document.all.poOther2.style.visibility = 'hidden';
	document.all.innerPackage.style.visibility = 'hidden';	
	document.all.showMisc.style.visibility = 'hidden';
	document.all.blRider.style.visibility = 'hidden';	
	document.all.blRider2.style.visibility = 'hidden';	
	document.all.blSurcharge.style.visibility = 'hidden';	
	document.all.blSurcharge2.style.visibility = 'hidden';
}

//package description을 조회한 후 changePackageDesc() 실행
function getPckDesc(){
	var formObj = document.form;
	var pckNm = "";
	if(!ComIsNull(formObj.pck_tp_cd.value)){
		var rXml = sheetObject1.GetSearchXml("ESM_BKG_0079_06GS.do", "f_cmd="+SEARCH03+"&pck_tp_cd="+formObj.pck_tp_cd.value);
		pckNm = ComGetEtcData(rXml, "pck_nm");
	}
	if(pckNm == undefined || pckNm == ""){
		ComShowCodeMessage("BKG00530");
		ComSetFocus(formObj.pck_tp_cd);
		return "";
	}
	//pck_nm
	formObj.pck_nm.value = pckNm;
	changePackageDesc();
}

// No. of PKG/CNTR, Total No. of PKG/CNTR in Word에 지정
function changePackageDesc() {	
	var formObj = document.form;
	var pckDesc = "";
	var pckQty = (formObj.pck_qty.value=='') ? 0 : BkgParseInt(ComTrimAll(formObj.pck_qty.value, ','));
	if(pckQty > 1){
		pckDesc = pckQty + " " + formObj.pck_nm.value + ("BOX"==formObj.pck_nm.value ? "E":"") + "S IN TOTAL";
	}else if(pckQty == 1){
		pckDesc = pckQty + " " + formObj.pck_nm.value + " IN TOTAL";
	}else{
		pckDesc = "";
	}
	formObj.pck_cmdt_desc.value = pckDesc;
	if(ComGetObjValue(parent.frames("t1frame").document.form.rcv_term_cd)=="S"){
		formObj.ttl_pck_desc.value = pckDesc;
	}
}

function radioBtnSet(obj){
	var formObj = document.form;
	
	if(obj.name=='aes_tp_cd'&& obj.checked==true){ 
		var obj2 = document.getElementsByName("aes_tp_cd");
	    for(var i=0; i<obj2.length; i++){
	        if(obj2[i] != obj){
	            obj2[i].checked = false;
	        }
	    }
    	switch(obj.value) {
	        case "AE":
//	        	formObj.aes_inlnd_trns_no.focus();
	        	ComSetFocus(formObj.aes_inlnd_trns_no);
	        	formObj.aes_inlnd_trns_no.readOnly=false;
	            formObj.aes_pta_no1.value='';
	            formObj.aes_pta_no1.readOnly=true;
	            formObj.aes_pta_no2.value='';
	            formObj.aes_pta_no2.readOnly=true;
	            formObj.aes_pta_dt.value='';
	            formObj.aes_pta_dt.readOnly=true;
	            formObj.aes_ptu_no.value='';
	            formObj.aes_ptu_no.readOnly=true;
	            formObj.aes_ptu_dt.value='';
	            formObj.aes_ptu_dt.readOnly=true;
	            formObj.aes_dwn_no.value='';
	            formObj.aes_dwn_no.readOnly=true;
	            formObj.aes_dwn_dt.value='';
	            formObj.aes_dwn_dt.readOnly=true;
	            formObj.aes_expt_id.Code='';
	            formObj.aes_expt_id.Enable=false;
	            // formObj.aes_expt_ctnt.value='';
	            // formObj.aes_expt_ctnt.readOnly=true;
	            break;
	            
	        case "PA": 
	        	formObj.aes_pta_no1.focus();
	            formObj.aes_pta_no1.readOnly=false;
	            formObj.aes_pta_no2.readOnly=false;
	            formObj.aes_pta_dt.readOnly=false;
	            formObj.aes_inlnd_trns_no.value='';
	        	formObj.aes_inlnd_trns_no.readOnly=true;
	            formObj.aes_ptu_no.value='';
	            formObj.aes_ptu_no.readOnly=true;
	            formObj.aes_ptu_dt.value='';
	            formObj.aes_ptu_dt.readOnly=true;
	            formObj.aes_dwn_no.value='';
	            formObj.aes_dwn_no.readOnly=true;
	            formObj.aes_dwn_dt.value='';
	            formObj.aes_dwn_dt.readOnly=true;
	            formObj.aes_expt_id.Code='';
	            formObj.aes_expt_id.Enable=false;
	            // formObj.aes_expt_ctnt.value='';
	            // formObj.aes_expt_ctnt.readOnly=true;
	            break;
	            
	        case "PU":
	        	formObj.aes_ptu_no.focus();
	            formObj.aes_ptu_no.readOnly=false;
	            formObj.aes_ptu_dt.readOnly=false;
	            formObj.aes_inlnd_trns_no.value='';
	        	formObj.aes_inlnd_trns_no.readOnly=true;
	            formObj.aes_pta_no1.value='';
	            formObj.aes_pta_no1.readOnly=true;
	            formObj.aes_pta_no2.value='';
	            formObj.aes_pta_no2.readOnly=true;
	            formObj.aes_pta_dt.value='';
	            formObj.aes_pta_dt.readOnly=true;
	            formObj.aes_dwn_no.value='';
	            formObj.aes_dwn_no.readOnly=true;
	            formObj.aes_dwn_dt.value='';
	            formObj.aes_dwn_dt.readOnly=true;
	            formObj.aes_expt_id.Code='';
	            formObj.aes_expt_id.Enable=false;
	            // formObj.aes_expt_ctnt.value='';	
	            // formObj.aes_expt_ctnt.readOnly=true;
	            break;
	            
	        case "DN":
	        	formObj.aes_dwn_no.focus();
	            formObj.aes_dwn_no.readOnly=false;
	            formObj.aes_dwn_dt.readOnly=false;
	            formObj.aes_inlnd_trns_no.value='';
	        	formObj.aes_inlnd_trns_no.readOnly=true;
	            formObj.aes_pta_no1.value='';
	            formObj.aes_pta_no1.readOnly=true;
	            formObj.aes_pta_no2.value='';
	            formObj.aes_pta_no2.readOnly=true;
	            formObj.aes_pta_dt.value='';
	            formObj.aes_pta_dt.readOnly=true;
	            formObj.aes_ptu_no.value='';
	            formObj.aes_ptu_no.readOnly=true;
	            formObj.aes_ptu_dt.value='';
	            formObj.aes_ptu_dt.readOnly=true;
	            formObj.aes_expt_id.Code='';
	            formObj.aes_expt_id.Enable=false;
	            // formObj.aes_expt_ctnt.value='';
	            // formObj.aes_expt_ctnt.readOnly=true;
	            break;
	            
	        case "EX":
	        	formObj.aes_expt_id.Enable=true;
	            formObj.aes_expt_ctnt.readOnly=false;
	            formObj.aes_inlnd_trns_no.value='';
	        	formObj.aes_inlnd_trns_no.readOnly=true;
	            formObj.aes_pta_no1.value='';
	            formObj.aes_pta_no1.readOnly=true;
	            formObj.aes_pta_no2.value='';
	            formObj.aes_pta_no2.readOnly=true;
	            formObj.aes_pta_dt.value='';
	            formObj.aes_pta_dt.readOnly=true;
	            formObj.aes_ptu_no.value='';
	            formObj.aes_ptu_no.readOnly=true;
	            formObj.aes_ptu_dt.value='';
	            formObj.aes_ptu_dt.readOnly=true;
	            formObj.aes_dwn_no.value='';
	            formObj.aes_dwn_no.readOnly=true;
	            //formObj.aes_dwn_dt.value='';
	            // formObj.aes_dwn_dt.readOnly=true;
	            break;	            
    	}
	} 
		
	if(obj.name=='aes_tp_cd'&& obj.checked==false){ 
		var obj2 = document.getElementsByName("aes_tp_cd");
		var chkcnt = 0
		for(var i=0; i<obj2.length; i++){
	        if(obj2[i] != obj){
	        	if(obj2[i].checked == true){
	            	chkcnt++ ;
	            }
	        }
	    }

		if(chkcnt==0){
			formObj.aes_inlnd_trns_no.value='';
        	formObj.aes_inlnd_trns_no.readOnly=true;
            formObj.aes_pta_no1.value='';
            formObj.aes_pta_no1.readOnly=true;
            formObj.aes_pta_no2.value='';
            formObj.aes_pta_no2.readOnly=true;
            formObj.aes_pta_dt.value='';
            formObj.aes_pta_dt.readOnly=true;
            formObj.aes_ptu_no.value='';
            formObj.aes_ptu_no.readOnly=true;
            formObj.aes_ptu_dt.value='';
            formObj.aes_ptu_dt.readOnly=true;
            formObj.aes_dwn_no.value='';
            formObj.aes_dwn_no.readOnly=true;
            formObj.aes_dwn_dt.value='';
            formObj.aes_dwn_dt.readOnly=true;
            formObj.aes_expt_id.Code='';
            formObj.aes_expt_id.Enable=false;
            // formObj.aes_expt_ctnt.value='';
            // formObj.aes_expt_ctnt.readOnly=true;
		}
	}	 

	if(obj.name=='caed_tp_cd'&& obj.checked==true){   
		var obj2 = document.getElementsByName("caed_tp_cd");
	    for(var i=0; i<obj2.length; i++){
	        if(obj2[i] != obj){
	            obj2[i].checked = false;
	        }
	    }
		switch(obj.value) {
	        case "CE":  
	        	formObj.caed_ctnt.readOnly=false;
	            formObj.g7_edi_ctnt.value='';
	            formObj.g7_edi_ctnt.readOnly=true;
	            formObj.mf_smry_rpt_no.value='';
	            formObj.mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_ctnt.value='';
	            formObj.b13a_xpt_ctnt.readOnly=true;
	            formObj.cgo_ctrl_no.value='';
	            formObj.cgo_ctrl_no.readOnly=true;
	            comboObjects[1].index='';
	            comboObjects[1].Enable=false;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	            break;
	            
	        case "G7": 
	        	formObj.caed_ctnt.value='';
	        	formObj.caed_ctnt.readOnly=true;
	            formObj.g7_edi_ctnt.readOnly=false;
	            formObj.mf_smry_rpt_no.value='';
	            formObj.mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_ctnt.value='';
	            formObj.b13a_xpt_ctnt.readOnly=true;
	            formObj.cgo_ctrl_no.value='';
	            formObj.cgo_ctrl_no.readOnly=true;
	            comboObjects[1].index='';
	            comboObjects[1].Enable=false;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	            break;
	            
	        case "SM":
	        	formObj.caed_ctnt.value='';
	        	formObj.caed_ctnt.readOnly=true;
	            formObj.g7_edi_ctnt.value='';
	            formObj.g7_edi_ctnt.readOnly=true;
	            formObj.mf_smry_rpt_no.readOnly=false;
	            formObj.b13a_xpt_ctnt.value='';
	            formObj.b13a_xpt_ctnt.readOnly=true;
	            formObj.cgo_ctrl_no.value='';
	            formObj.cgo_ctrl_no.readOnly=true;
	            comboObjects[1].index='';
	            comboObjects[1].Enable=false;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	            break;
	            
	        case "EX":
	        	formObj.caed_ctnt.value='';
	        	formObj.caed_ctnt.readOnly=true;
	            formObj.g7_edi_ctnt.value='';
	            formObj.g7_edi_ctnt.readOnly=true;
	            formObj.mf_smry_rpt_no.value='';
	            formObj.mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_ctnt.readOnly=false;
	            formObj.cgo_ctrl_no.value='';
	            formObj.cgo_ctrl_no.readOnly=true;
	            comboObjects[1].index='';
	            comboObjects[1].Enable=false;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	            break;
	            
	        case "IT":
	        	formObj.caed_ctnt.value='';
	        	formObj.caed_ctnt.readOnly=true;
	            formObj.g7_edi_ctnt.value='';
	            formObj.g7_edi_ctnt.readOnly=true;
	            formObj.mf_smry_rpt_no.value='';
	            formObj.mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_ctnt.value='';
	            formObj.b13a_xpt_ctnt.readOnly=true;
	            formObj.cgo_ctrl_no.readOnly=false;
	            comboObjects[1].index='';
	            comboObjects[1].Enable=false;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	            break;
	            
	        case "ND":
	        	formObj.caed_ctnt.value='';
	        	formObj.caed_ctnt.readOnly=true;
	            formObj.g7_edi_ctnt.value='';
	            formObj.g7_edi_ctnt.readOnly=true;
	            formObj.mf_smry_rpt_no.value='';
	            formObj.mf_smry_rpt_no.readOnly=true;
	            formObj.b13a_xpt_ctnt.value='';
	            formObj.b13a_xpt_ctnt.readOnly=true;
	            formObj.cgo_ctrl_no.value=''
	            formObj.cgo_ctrl_no.readOnly=true;
	            comboObjects[1].Enable=true;
	            //formObj.ndr_ref_ctnt.value='';
	            //formObj.ndr_ref_ctnt.readOnly=true;
	        	break;
		}
	}
	if(obj.name=='caed_tp_cd'&& obj.checked==false){   		 
		var obj2 = document.getElementsByName("caed_tp_cd");
		var chkcnt = 0
		for(var i=0; i<obj2.length; i++){
	        if(obj2[i] != obj){		            
	        	if(obj2[i].checked == true){
	            	chkcnt++ ;
	            }
	        }
	    }
		
		if(chkcnt==0){
			formObj.caed_ctnt.value='';
        	formObj.caed_ctnt.readOnly=true;
            formObj.g7_edi_ctnt.value='';
            formObj.g7_edi_ctnt.readOnly=true;
            formObj.mf_smry_rpt_no.value='';
            formObj.mf_smry_rpt_no.readOnly=true;
            formObj.b13a_xpt_ctnt.value='';
            formObj.b13a_xpt_ctnt.readOnly=true;
            formObj.cgo_ctrl_no.value=''
            formObj.cgo_ctrl_no.readOnly=true;
            comboObjects[1].index='';
            comboObjects[1].Enable=false;
            //formObj.ndr_ref_ctnt.readOnly=false;
		}
	}
}

function copyToDesc(chkObj){
	var formObj = document.form; 
    if (chkObj.checked) {
		if(chkObj.name=="shpr_tax_cpy_desc_flg"){
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Shipper CPF/CPNJ "+formObj.shpr_tax_no.value;	
		}
		if(chkObj.name=="cnee_tax_cpy_desc_flg"){
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Consignee CPF/CPNJ "+formObj.cnee_tax_no.value;	
		}
		if(chkObj.name=="ntfy_tax_cpy_desc_flg"){
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Notify CPF/CPNJ "+formObj.ntfy_tax_no.value;	
		}
		if (chkObj.name == "check_bkpo") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n P/O No:" + form.bkpo.value;			
		}
		if (chkObj.name == "check_lcno") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n L/C No:" + form.lcno.value;
		}
		if (chkObj.name == "check_hinv") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Invoice No:" + form.hinv.value;
		}
		if (chkObj.name == "check_lcdt") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n L/C Date:" + form.lcdt.value;
		}
		if (chkObj.name == "check_hpdp") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Department No:" + form.hpdp.value;
		}
		if (chkObj.name == "check_othr") {
			formObj.dg_cmdt_desc.value = formObj.dg_cmdt_desc.value + "\n Other Ref. No:" + form.othr.value;
		}	
    }
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

function ComClearSeparatorMod(obj,sFormat,sDelim){
    try{
        if (typeof(obj) != "object" ) return;        
        obj.value = ComTrimAll(obj.value, "-", "/", ":"," ");        
        if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus = new Function("this.select()");

		event.returnValue=true;
    } catch(err) { 
    	ComFuncErrMsg(err.message);
    }
}

function ComIsDateMod(obj, sFlag) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);

        //날짜구분자로 사용될수 있는는 "/", "-", "."를 제거되고 비교한다.
        sVal = sVal.replace(/\/|\-|\./g,"");

        if (!ComIsNumber(sVal)) return false;
        if (sFlag==undefined || sFlag==null) sFlag = "mdy";

        var year, month, day, week;       
        if (sVal.length != 8) return false;
        year  = sVal.substring(4,8);
        month = sVal.substring(0,2);
        day   = sVal.substring(2,4);
        if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)) return false;
        
        return true;
    } catch(err) { 
    	ComFuncErrMsg(err.message); 
    }
}

function ComIsAesNo(obj, sFlag) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);

        //날짜구분자로 사용될수 있는는 "/", "-", "."를 제거되고 비교한다.
        sVal = sVal.replace(/\/|\-|\./g,"");
        if (sVal.length != 15) return false;
        
        if (!ComIsNumber(sVal.substring(1,15))) return false;
        if (!isAlpha(sVal.substring(0,1))) return false;      
        
        return true;
    } catch(err) { 
    	ComFuncErrMsg(err.message); 
    }
}

function ComIsCaedNo(obj, sFlag) {
    try {
        var sVal = getArgValue(obj);

        sVal = sVal.replace(/\/|\-|\./g,"");
        if (sVal.length != 23) return false;
        
        if (!ComIsNumber(sVal.substring(0,2))) return false;
        if (!isAlpha(sVal.substring(2,3))) return false;      
        if (!ComIsNumber(sVal.substring(3,6))) return false;
        if (!isAlpha(sVal.substring(6,8))) return false;  
        if (!isAlpha(sVal.substring(8,9))&&!ComIsNumber(sVal.substring(8,9))) return false;
        if (!ComIsNumber(sVal.substring(9,23))) return false;
        
        return true;
    } catch(err) { 
    	ComFuncErrMsg(err.message); 
    }
}

function ComIsG7EdiNo(obj, sFlag) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);

        sVal = sVal.replace(/\/|\-|\./g,"");
        if (sVal.length != 17) return false;
        
        if (!ComIsNumber(sVal.substring(0,2))) return false;
        if (!isAlpha(sVal.substring(2,3))) return false;      
        if (!ComIsNumber(sVal.substring(3,17))) return false;
        
        return true;
    } catch(err) { 
    	ComFuncErrMsg(err.message); 
    }
}

function ComIsB13aXptNo(obj, sFlag) {
    try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);

        sVal = sVal.replace(/\/|\-|\./g," ");
        if (sVal.length != 21) return false;
        if (!ComIsNumber(sVal)) return false;

        var year, month, day, week;
       
        year  = sVal.substring(0,4);
        month = sVal.substring(4,6);
        day   = sVal.substring(6,8);
        hm   = sVal.substring(8,12);
        if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)|| !ComIsTime(hm, "hm")) return false;
        
        return true;
    } catch(err) { 
    	ComFuncErrMsg(err.message); 
    }
}

function ChkComIsCaedNo(obj){
	var size = 0;
	var sVal = "";
	if(obj.form.name=='form'){
    	size = document.form.caed_tp_cd.length;	
    	j=0
		for(var i = 0; i < size; i++) {
			if(document.form.caed_tp_cd[i].checked) {
				if(document.form.caed_tp_cd[i].value!='CE') return false;
				j++
			}				
		}
    	if(j<1) return false;
	}else{		
		size = document.form2.imp_caed_tp_cd.length;	
		j=0
		for(var i = 0; i < size; i++) {
			if(document.form2.imp_caed_tp_cd[i].checked) {
				if(document.form2.imp_caed_tp_cd[i].value!='CE') return false;
				j++
			}				
		}
		if(j<1) return false;
	}
	
	if (!ComIsCaedNo(obj.value)){
		 if(obj.form.name=='form'){
			 //ComAlertFocus(document.form.caed_ctnt,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
		 }else{
			 //ComAlertFocus(document.form2.caed_ctnt,  ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));
		 }
		 return false;
   	}else{
   		var re = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
   		var re2 = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
   		sVal = obj.value.toUpperCase()
   		if(obj.form.name=='form'){
   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
   				document.form.caed_ctnt.value  =sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
   			}else{
   				document.form.caed_ctnt.value  =sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
   			}
   		}else{
   			if("A"<=sVal.substring(8,9)&&"Z">=sVal.substring(8,9)){
   				document.form2.caed_ctnt.value  = sVal.replace(re2,'$1' + "-" + '$2' + "-" + '$3');
   			}else{
   				document.form2.caed_ctnt.value  = sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
   			}
   		}
   	}
}

function ChkComIsG7EdiNo(obj){
	var size = 0;
	var sVal = "";
	if(obj.form.name=='form'){
    	size = document.form.caed_tp_cd.length;	
    	j=0
		for(var i = 0; i < size; i++) {
			if(document.form.caed_tp_cd[i].checked) {
				if(document.form.caed_tp_cd[i].value!='G7') return false;
				j++
			}				
		}
    	if(j<1) return false;
	}else{		
		size = document.form2.imp_caed_tp_cd.length;	
		j=0
		for(var i = 0; i < size; i++) {
			if(document.form2.imp_caed_tp_cd[i].checked) {
				if(document.form2.imp_caed_tp_cd[i].value!='G7') return false;
				j++
			}				
		}
		if(j<1) return false;
	}
	
	if (!ComIsG7EdiNo(obj.value)){
		 if(obj.form.name=='form'){
			 //ComAlertFocus(document.form.g7_edi_ctnt,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
		 }else{
			 //ComAlertFocus(document.form2.g7_edi_ctnt,  ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));
		 }
   	}else{
   		var re = new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
   		sVal = obj.value.toUpperCase()
   		if(obj.form.name=='form'){
   			document.form.g7_edi_ctnt.value  = sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
   		}else{
   			document.form2.g7_edi_ctnt.value  = sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
   		}
   	}
}

function ChkComIsB13aXptNo(obj){
	var size = 0;
	var sVal = "";
	if(obj.form.name=='form'){
    	size = document.form.caed_tp_cd.length;	
    	j=0
		for(var i = 0; i < size; i++) {				
			if(document.form.caed_tp_cd[i].checked) {
				if(document.form.caed_tp_cd[i].value!='EX') return false;
				j++
			}
		}
    	if(j<1) return false;
	}else{		
		size = document.form2.imp_caed_tp_cd.length;	
		j=0
		for(var i = 0; i < size; i++) {
			if(document.form2.imp_caed_tp_cd[i].checked) {
				if(document.form2.imp_caed_tp_cd[i].value!='EX') return false;
				j++
			}				
		}
		if(j<1) return false;
	}
	
	if (!ComIsB13aXptNo(obj.value)){
		 if(obj.form.name=='form'){
			 //ComAlertFocus(document.form.b13a_xpt_ctnt, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
		 }else{
			 //ComAlertFocus(document.form2.b13a_xpt_ctnt, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));
		 }
   	}else{
   		var re = new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
    	if(obj.form.name=='form'){
   			document.form.b13a_xpt_ctnt.value = obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
   		}else{
   			document.form2.b13a_xpt_ctnt.value = obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
   		}
   	}
}

function isAlpha(str) {
    var pattern = /^[a-zA-Z]+$/;
    return (pattern.test(str)) ? true : false;
}

//function obj_keypress() {
//	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which
//			: event.charCode;
//	switch (event.srcElement.dataformat) {
//	case "int":
//		//숫자만입력하기
//		//ComAddSeparator(event.srcElement, "int");
//		ComKeyOnlyNumber(event.srcElement);
//		break;
//	case "float":
//		//숫자+"."입력하기
//		ComKeyOnlyNumber(event.srcElement, ".");
//		break;
//	case "eng":
//		//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
//		ComKeyOnlyAlphabet();
//		break;
//	case "engdn":
//		//영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
//		ComKeyOnlyAlphabet('lower');
//		break;
//	case "engup":
//		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//		//	            ComKeyOnlyAlphabet('uppernum');
//		if (keyValue >= 97 && keyValue <= 122) {//소문자
//			event.keyCode = keyValue + 65 - 97;
//		}
//		break;
//	case "uppernum":
//		//영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
//		ComKeyOnlyAlphabet('uppernum');
//		break;
//	default:
//		//숫자만입력하기(정수,날짜,시간)
//		ComKeyOnlyNumber(event.srcElement);
//	}
//}

function obj_activate(){
	switch (event.srcElement.name) {
		case "caed_ctnt":
		case "g7_edi_ctnt":
		case "mf_smry_rpt_no":
		case "b13a_xpt_ctnt":
		case "cgo_ctrl_no":
		case "aes_pta_dt":
		case "aes_ptu_dt":
		case "aes_dwn_dt":
	    	ComClearSeparatorMod(event.srcElement);
    	break;
	}
}

function form1_onBlur() {
//	ComChkObjValid(event.srcElement);
}

function form1_onChange() {
	var srcName = event.srcElement.getAttribute("name");
	// 2018.05.25 iylee Form Change 일때 소문자 -> 대문자로 바꾸어줌.
	ComSetUpperChange(srcName, event.srcElement.value);

	switch(srcName){
		case "pck_tp_cd":
			var cVal = event.srcElement.value;
			if(cVal==''){
				return false;
			} else {			
				getPckDesc();
			}	
			break;
			
			
		case "bkpo":
			var cVal = event.srcElement.value;
			if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S" && cVal!=""){
				
				var sh_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_cnt_cd);
				var sh_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_seq);
				var cn_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_cnt_cd);
				var cn_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_seq);
				var nf_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_cnt_cd);
				var nf_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_seq);
				
				var bkg_no = ComGetObjValue(parent.document.frames("t1frame").form.bkg_no);
				var sc_no  = ComGetObjValue(parent.document.frames("t1frame").form.sc_no);   
				var rfa_no = ComGetObjValue(parent.document.frames("t1frame").form.rfa_no); 
				var por_cd = ComGetObjValue(parent.document.frames("t1frame").form.bkg_por_cd);
				var del_cd = ComGetObjValue(parent.document.frames("t1frame").form.bkg_del_cd);
				var svc_scp_cd = ComGetObjValue(parent.document.frames("t2frame").form.svc_scp_cd);

			    var param = "&f_cmd=" + SEARCH01 + "&bkg_no=" + bkg_no+ "&sc_no=" + sc_no+ "&rfa_no=" + rfa_no ;
			        param = param + "&por_cd=" + por_cd+ "&del_cd=" + del_cd+ "&svc_scp_cd=" + svc_scp_cd ;
			        param = param + "&sh_cust_cnt_cd=" + sh_cust_cnt_cd+ "&sh_cust_seq=" + sh_cust_seq ;
			        param = param + "&cn_cust_cnt_cd=" + cn_cust_cnt_cd+ "&cn_cust_seq=" + cn_cust_seq ;
			        param = param + "&nf_cust_cnt_cd=" + nf_cust_cnt_cd+ "&nf_cust_seq=" + nf_cust_seq ;
			   
			    var sXml = sheetObject1.GetSearchXml("ESM_BKG_0229_04GS.do", param);
			    var pathItem = ComGetEtcData(sXml, "path_item");
			    var pob ="N";
			    var poc ="N";
			    var pom ="N";
			    if (pathItem !='') { 
			    	 var pathArr = pathItem.split(",");
				     for (var i = 0 ; i < pathArr.length ; i++) {
				    	  if (pathArr[i] == "POB"){
				    		  pob ="Y";
				    	  }else if(pathArr[i] == "POC"){
				    		  poc ="Y";
				    	  }else if(pathArr[i] == "POM"){
				    		  pom ="Y";
				    	  }
				     }   	
			  	}
			    if(pob == "Y" && poc == "Y"){
					var sObject = div3sheet1;
					var c_row = sObject.LastRow;		
					for ( var row = 1; row <= c_row; row++) {
						if ('' != sObject.CellValue(row, "c_cntr_no") && '' == sObject.CellValue(row, "cust_ref_no_ctnt")) {
							sObject.CellValue2(row, "cust_ref_no_ctnt") = cVal;
						}
					}
			            
			    }
			}
			
			break;
	}
	compareItem();
	isCopy = "false";
}

function wgt_ut_cd_OnChange(comboObj, value, text) {
	if (parent.frames("t1frame").document.form) {
		ComSetObjValue(parent.frames("t1frame").document.form.wgt_ut_cd, value);
	}
}

function div1sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	var srcName = sheetObj.ColSaveName(Col);

	if ("xpt_lic_no"==srcName) {
		if (""!=Value && 14>Value.length) {
			ComShowCodeMessage("BKG00257");
			sheetObj.SelectCell(Row, Col);
		} else {
//			var total = 0;
//			for (var i=1; i<15; i++) {
//				switch (i%3) {
//					case 1:
//						total += parseInt(((Value.substring(i-1,i)*7)%10));
//						break;	
//					case 2:
//						total += parseInt(((Value.substring(i-1,i)*3)%10));
//						break;
//					case 0:
//						total += parseInt((Value.substring(i-1,i)*1));
//						break;
//				}
//			}     	
//			chkDigit = (10-(total%10))%10;
//			if (15==Value.length) {
//    			if (chkDigit!=Value.substring(14,15)) {
//    				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
//    				sheetObj.CellValue(Row, Col) = Value.substring(0,14);
//    				sheetObj.SelectCell(Row, Col);
//    			}
//    		} else if (14==Value.length) {
//    			sheetObj.CellValue2(Row, Col) = Value+chkDigit;
//    		}
		}
	} else if ("pck_tp_cd"==srcName || "sam_pck_tp_cd"==srcName) {
		sheetObj.CellValue2(Row,srcName) = Value.toUpperCase();
	}
}

function div1sheet1_OnPopupClick(sheetObj,Row,Col){
	comBkgCallPop0696("setSheetCallBack0696",sheetObj.CellValue(Row, Col));
}

/**
 * Sheet관련 컬럼 onClick 엑션 이벤트 처리 
 */
function div3sheet1_OnClick(sheetObject, Row, Col, Value) {
	var target_cntr = sheetObject.CellValue(Row, "c_cntr_no");
	document.form.cntr_no.value = target_cntr ;
	var cnt = div3sheet2.RowCount;
	for (var ix = 1; ix <= cnt; ix++) {
		if (div3sheet2.RowStatus(ix) == 'D') {
		} else if (div3sheet2.CellValue(ix, "cntr_no") == target_cntr) {
			div3sheet2.RowHidden(ix) = false;
		} else {
			div3sheet2.CheckAll2("check") = 0;
			div3sheet2.RowHidden(ix) = true;
		}
	}
}
 
function setSheetCallBack0696(aryPopupData) {
	var sheetObj = sheetObjects[0];
	sheetObj.CellValue(sheetObj.SelectRow, sheetObj.SelectCol) = aryPopupData[0][3];
}

function comBkgCallPop0369(cd) {
	var formObj = document.form;
	var param = "?bkg_no=" + formObj.bkg_no.value + "&ridr_tp_cd=" + cd;
	//    	ComOpenWindow("/hanjin/ESM_BKG_0207.do" + param, "PopupEsmBkg0207", "dialogWidth:525px; dialogHeight:550px", true);
	ComOpenWindow("/hanjin/ESM_BKG_0369.do" + param, "PopupEsmBkg0369", "width=380,height=370", false);
}

function setCallBack0696(aryPopupData) {
	var formObj = document.form;
	formObj.pck_tp_cd.value = aryPopupData[0][3];
}

function callbackPckTp(returnVal){
//	if(document.form.obl_iss_flg.value == 'Y') return false;
	document.form.pck_tp_cd.value = returnVal[0][3];
	document.form.pck_nm.value = returnVal[0][4];
	changePackageDesc();
}

/**
* 조회 후 처리
* @param sheetObj Sheet
* @param ErrMsg 에러메시지
*/
function div2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	if (sheetObj.RowCount > 0) {
		sheetObj.CellValue2(sheetObj.LastRow, 1) = "";
		sheetObj.CellValue2(sheetObj.LastRow, "ts_ref_no2") = "TOTAL";
		sheetObj.CellAlign(sheetObj.LastRow, "ts_ref_no2") = daCenter;
	}
}

function form1_blur(){
	var obj = event.srcElement;
	if (obj && ("pck_qty"==obj.name || "act_wgt"==obj.name || "meas_qty"==obj.name)) {
		ComAddSeparator(obj);
	}
}

/**
 * 콤보 aes_expt_id2 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function aes_expt_id2_OnChange(comboObj,value,text) {
	document.form.aes_expt_id_tmp.value = value;
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function div5sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Col != 1) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

function div6sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Col != 1) return;
	 
	// 파일명이 없거나, 신규생성Row이거나, 파일을 새로 선택했을 경우 파일선택창을 띄운다.
//	if (sheetObj.CellText(Row, prefix + "file_nm") == "" || sheetObj.RowStatus(Row) == "I") {
//		selectFile(sheetObj, Row, Col);
//		return;
//	}
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}

/**
* PO No Mandatory Item별 PO No 존재여부 check.
* div3sheet1 = sheetObjects[3]
* div3sheet2 = sheetObjects[4]
* POB : P/O No (by BKG)
* POC : P/O No (by CNTR)
* POM : P/O No (by ITEM)
*/
function validate_Mandatory_Item(sheetObj, formObj) {
	var sh_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_cnt_cd);
	var sh_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_seq);
	var cn_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_cnt_cd);
	var cn_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_seq);
	var nf_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_cnt_cd);
	var nf_cust_seq    = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_seq);
	
	var bkg_no = ComGetObjValue(parent.document.frames("t1frame").form.bkg_no);
	var sc_no  = ComGetObjValue(parent.document.frames("t1frame").form.sc_no);   
	var rfa_no = ComGetObjValue(parent.document.frames("t1frame").form.rfa_no); 
	var por_cd = ComGetObjValue(parent.document.frames("t1frame").form.bkg_por_cd);
	var del_cd = ComGetObjValue(parent.document.frames("t1frame").form.bkg_del_cd);
	var svc_scp_cd = ComGetObjValue(parent.document.frames("t2frame").form.svc_scp_cd);

    var param = "&f_cmd=" + SEARCH01 + "&bkg_no=" + bkg_no+ "&sc_no=" + sc_no+ "&rfa_no=" + rfa_no ;
        param = param + "&por_cd=" + por_cd+ "&del_cd=" + del_cd+ "&svc_scp_cd=" + svc_scp_cd ;
        param = param + "&sh_cust_cnt_cd=" + sh_cust_cnt_cd+ "&sh_cust_seq=" + sh_cust_seq ;
        param = param + "&cn_cust_cnt_cd=" + cn_cust_cnt_cd+ "&cn_cust_seq=" + cn_cust_seq ;
        param = param + "&nf_cust_cnt_cd=" + nf_cust_cnt_cd+ "&nf_cust_seq=" + nf_cust_seq ;
   
    var sXml = sheetObj.GetSearchXml("ESM_BKG_0229_04GS.do", param);
    var pathItem = ComGetEtcData(sXml, "path_item");
    var pob ="N";
    var poc ="N";
    var pom ="N";
	var dpt ="N";

    
    
    var bkpo = ComGetObjValue(formObj.bkpo);
    var hpdp = ComGetObjValue(formObj.hpdp);
    if (pathItem !='') { 
    	 var pathArr = pathItem.split(",");
	     for (var i = 0 ; i < pathArr.length ; i++) {
	    	  if (pathArr[i] == "POB"){
	    		  pob ="Y";
	    	  }else if(pathArr[i] == "POC"){
	    		  poc ="Y";
	    	  }else if(pathArr[i] == "POM"){
	    		  pom ="Y";
	    	  }else if(pathArr[i] == "DPT"){
	    		  dpt ="Y";
	    	  }
	     }   	
  	}
    
	if(pob == "Y" && poc == "Y" && parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){

		var cntrSheet = parent.document.frames("t3frame").sheetObjects[0];
		var poCntrSheet = div3sheet1;
		if(cntrSheet.RowCount>0){
			for (var rr = 1; rr < cntrSheet.RowCount + 1; rr++) {
	
				if(poCntrSheet.FindText("c_cntr_no", cntrSheet.CellValue(rr, "cntr_no"), -1, true)==-1){
					var newRow = poCntrSheet.DataInsert(-1);
					poCntrSheet.CellValue2(newRow, "c_cntr_no") =  cntrSheet.CellValue(rr, "cntr_no");
					poCntrSheet.CellValue2(newRow, "cntr_no") =  cntrSheet.CellValue(rr, "cntr_no");
				}
			}
		}

		if(poCntrSheet.RowCount>0){
			for (var rr = 1; rr < poCntrSheet.RowCount + 1; rr++) {
				if(cntrSheet.FindText("cntr_no", poCntrSheet.CellValue(rr, "c_cntr_no"), -1, true)==-1){
					poCntrSheet.RowDelete(rr, false);
	
				}
			}
		}

	}
	


	if (pob == "Y") {
		if (bkpo == '') {
			if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
				ComShowCodeMessage("BKG00888", "P/O No");
				return false;
			} else {
				ComShowCodeMessage("BKG95095", "P/O No");
			}
			
		}
	}
	
	if (dpt == "Y") {
		if (hpdp == '') {
			if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
				showPoOther();
				ComAlertFocus(document.form.hpdp, ComGetMsg("BKG00888", "Department No." ));
				return false;
			} else {
				ComShowCodeMessage("BKG95095", "Department No.");
			}
			
		}
	}
	
	if (poc == "Y") {
		//P/O Nl ( by CNTR) div3sheet1의  컬럼값 체크  
		var sObject = div3sheet1;
		var c_row = sObject.LastRow;		
		for ( var row = 1; row <= c_row; row++) {
			if ('' != sObject.CellValue(row, "c_cntr_no") && '' == sObject.CellValue(row, "cust_ref_no_ctnt")) {
				if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
					ComShowCodeMessage("BKG00888", sObject.CellValue(row, "c_cntr_no") + "  P/O No(by CNTR)");
					sObject.SelectCell(row,  "cust_ref_no_ctnt", true);
					return false;
				}else {
					ComShowCodeMessage("BKG95095", sObject.CellValue(row, "c_cntr_no") + " P/O No(by CNTR)");
				}
			}
		}
	}
	if (pom == "Y") {
		//POM : P/O No (by ITEM) div3sheet2의 컬럼값 체크 
		var sObject = div3sheet2;
		var c_row = sObject.LastRow;
	
		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, "po_no")) {
				if(parent.frames("t1frame").document.form.doc_tp_cd.value =="S"){
					ComShowCodeMessage("BKG00888", row + " row P/O No(by ITEM)");
					sObject.SelectCell(row, "po_no", true);
					return false;
				}else {
					ComShowCodeMessage("BKG95095", row + "row P/O No(by ITEM)");
				}
			}
		}
	}
	return true;
}

/**
* initCombo 이벤트 처리<br>
* weight 단위 와 measuer 단위를 가져온다. <br>
* @param 
* @exception EventException
*/
//function makeCombo() {
//	var formObj = document.form;
//	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
//
//	try {
//		var param = FormQueryString(formObj);
//		param = param + "&cm_code=CD00775";
//
//		var sXml = sheetObjects[4].GetSearchXml("ESM_Booking_UtilGS.do", param);
//		var arrXml = sXml.split("|$$|");
//
//		if (arrXml[0].length > 0) {
//			var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
//			sheetObjects[4].InitDataCombo(0, "wgt_ut_cd", "|" + arrCombo[0], "|" + arrCombo[1],"KGS");
//		}
//
//		var param = FormQueryString(formObj);
//		param = param + "&cm_code=CD01116";
//
//		var sXml = sheetObjects[4].GetSearchXml("ESM_Booking_UtilGS.do", param);
//		var arrXml = sXml.split("|$$|");
//
//		if (arrXml[0].length > 0) {
//			var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
//			sheetObjects[4].InitDataCombo(0, "meas_ut_cd", arrCombo[0], arrCombo[1],"CBM");
//		}
//
//	} catch (ex) {
//		bkg_error_alert('', ex);
//		return false;
//	}
//	return true;
//}

function aes_expt_id_OnChange(comboObj, value, text) {
	var formObj = document.form;
	if (formObj.aes_expt_id.value != '') {
//        formObj.aes_expt_ctnt.value='';
//        formObj.aes_expt_ctnt.readOnly=true;
	}
}

function div8sheet1_OnPopupClick(sheetObj, Row, Col) {
	if ("id_xpt_no_iss_dt"==sheetObj.ColSaveName(Col)) {
		new ComCalendarGrid().select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
}

function div10sheet1_OnMouseDown(button, shift, X, Y){
	var selText = "";
	if (window.getSelection) {
		selText =  window.getSelection().toString();
    } else if (document.selection) {
    	selText =  document.selection.createRange().text;
    }
	
	if(selText != "" ){	
		div10sheet1.CellValue(div10sheet1.MouseRow,"cluz_lck_desc") = selText;		
	}
}

function div10sheet1_OnDblClick(sheetObj, row, col) {
	if (col != 1) {		
		var col_save_name = sheetObj.ColSaveName(col);
		if (col_save_name == "cluz_lck_desc") {
			ComShowMemoPad(sheetObj, row, "cluz_lck_desc", false, 250, 300);
		} 
	}
} 

