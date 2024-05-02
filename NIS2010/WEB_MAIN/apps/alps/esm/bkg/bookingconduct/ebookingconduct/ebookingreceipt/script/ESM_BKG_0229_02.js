﻿﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0229_02.js
 *@FileTitle : e-Booking & S/I Detail (Customer)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.08
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.08 전용진
 * 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발 
 2010.10.12 전성진 [CHM-201006335] Consignee (Notify) 에 zip code와 state code 필수 로직 변경
 2010.11.09 전성진 [CHM-201004161] EORI Validation 로직 적용
 2010.11.10 전성진 [CHM-201004161] EORI Validation 로직 적용, SI일때만 체크로 수정
 2010.12.13 김영철 [] eBooking Customer Copy시에 부분적으로 Seq 값이 Copy 되지 않는 부분을 수정함.
 2011.01.04 이일민 [CHM-201008007-01] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정)
 2011.01.10 이일민 [CHM-201108147] EU24 관련 Country Code 및 EORI Code Validation 체크 로직
 2011.01.25 김영철 [CHM-201108365-01] Lowe''s CNEE Name Check Logic 추가 요청 ( Validation 추가 )
 2011.01.31 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - callback시 name, address항목 추가
 2011.02.08 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - callback시 name, address항목 제거(상단시트에서 선택시)
 2011.02.09 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - 항목조정
 2011.02.24 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - name & address 조건 수정
 2011.03.30 정선용 [CHM-201109800-01] Country Code validation in e-BKG Upload
 2011.04.11 정선용 [CHM-201109998-01]구주 24hrs Rule 관련하여 상세 주소 로직 보완 요청
 2011.05.19 김진승 [CHM-201110734] Save after chanfge of Customer not possible
 2011.11.03 정선용 [CHM-201114137-01] [ALPS] E-BKG/SI Process 화면 EDI REF 추가
 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
 2013.04.08 임재관 [] ALPS 통합 로그 ERROR 복구 작업 Country Code(2자리), Street/P.O.Box(50자리) 제한
 2013.04.19 최문환 [CHM-201323915] Blacklisted Customer 사용 시 Alert 강화 요청
 2014.09.30 최도순[CHM-201431914] Split 01-e-bkg & si process, BKG creation 화면에 “CN 404 EDI 주소city, state, zip missing”
 2014.12.09 최도순[CHM-201432911] E-bkg/Upload 스크린에 A/customer 저장 요청
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
 * @class esm_bkg_0229_02 : esm_bkg_0229_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0229_02() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.dataCopy = dataCopy;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;     

var isCopy = "false";
var isCNTsRoute = "";		// 중국 해관 : 중국 T/S 여부
var isCNTsValidation = "";	// 중국 해관 : 중국 해관 관련 validation 수행 여부

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;
	var bkgNo = formObj.bkg_no.value;
	
	var podCd = parent.document.frames("t1frame").form.bkg_pod_cd.value;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case IBCLEAR:
			doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
			break;

		case "btn_cancelcopydata":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			isCopy = "false";
			top.isCopyAllRequested = false;
			ComBtnColor("btn_cancelcopydata", "blue");
			ComBtnColor("btn_datacopytoalps", "#737373");	
			break;

		case "btn_datacopytoalps":
			if (isCopy == "false") {
				dataCopy();
			}
			break;

		case "btn_upload":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_t7Sa0190":   
			var scNo = formObj.sc_no.value;
			var rfaNo =formObj.rfa_no.value;
			var svcScpCd = formObj.svc_scp_cd.value;
			var applDt = formObj.appl_dt.value;
			var bkgUpldFlg = ""; 
			
			var porCd = parent.document.frames("t1frame").form.bkg_por_cd.value;
			var delCd = parent.document.frames("t1frame").form.bkg_del_cd.value;
			var cmdtCd =  parent.document.frames("t1frame").form.cmdt_cd.value;
			var bkgStsCd = parent.document.frames("t1frame").form.bkg_sts_cd.value;
			
			if(ComIsNull(bkgStsCd)){
				
				bkgUpldFlg="N";
				
				if(ComIsNull(scNo)){
					scNo = parent.document.frames("t1frame").form.sc_no.value;
				}
				
				if(ComIsNull(rfaNo)){
					rfaNo = parent.document.frames("t1frame").form.rfa_no.value;
				}
				
				if(ComIsNull(applDt)){
					applDt = parent.document.frames("t1frame").form.lodg_due_dt.value;
				}
			}
			
			ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObj.bkg_no.value+"&sc_no="
					+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ applDt +"&por_cd="+ porCd +"&del_cd="+ delCd +"&cmdt_cd="+ cmdtCd +"&bkg_upld_flg="+ bkgUpldFlg
					,800, 390, "callBackSa0190","1,0,1,1,1", true);	
			
			/*
			ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObj.bkg_no.value+"&sc_no="
					+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ applDt
					,800, 390, "callBackSa0190","1,0,1,1,1", true);			*/
			customerDataDiffCheck(formObj);
			break;        		
		case "btn_t7Delete":
			document.form.agmt_act_cnt_cd.value = "";
			document.form.agmt_act_cust_seq.value = "";
			displayDeleteButtonOfAcualCustomer();  // Actual Customer Delete Button ... 2011.05.19
			break;  
		case "btn_t7Sh0192":
			var custCntCd = ComGetObjValue(formObj.sh_cust_cnt_cd);
			var custSeq = ComGetObjValue(formObj.sh_cust_seq);
			var custNm = "";
			var custAddr = "";
			if(ComChkLen(formObj.sh_cust_nm) != 1){
				custNm = ComGetObjValue(formObj.sh_cust_nm).substring(0,10);
			}else{
				custNm = ComGetObjValue(formObj.sh_cust_nm);
			}
			if(ComChkLen(formObj.sh_cust_addr) != 1){
				custAddr = ComGetObjValue(formObj.sh_cust_addr).substring(0,10);
			}else{
				custAddr = ComGetObjValue(formObj.sh_cust_addr);
			}    					
			var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr="+"";
			ComOpenPopup(url,970, 660, "callBackSh0192","0,0,1,1,1", true);
			customerDataDiffCheck(formObj);
			break;    		
		case "btn_t7Cn0192":
			var custCntCd = formObj.cn_cust_cnt_cd.value;
			var custSeq = formObj.cn_cust_seq.value;
			var custNm = "";
			var custAddr = "";
			if(ComChkLen(formObj.cn_cust_nm) != 1){
				custNm = ComGetObjValue(formObj.cn_cust_nm).substring(0,10);
			}else{
				custNm = ComGetObjValue(formObj.cn_cust_nm);
			}
			if(ComChkLen(formObj.cn_cust_addr) != 1){
				custAddr = ComGetObjValue(formObj.cn_cust_addr).substring(0,10);
			}else{
				custAddr = ComGetObjValue(formObj.cn_cust_addr);
			}    					
			var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&indiv_dp_flg=Y&indiv_pson_flg="+ComGetObjValue(formObj.indiv_pson_flg)+"&cust_addr=";
			ComOpenPopup(url,970, 660, "callBackCn0192","0,0,1,1,1", true);
			customerDataDiffCheck(formObj);
			break;   		
		case "btn_t7Nf0192":
			var custCntCd = formObj.nf_cust_cnt_cd.value;
			var custSeq = formObj.nf_cust_seq.value;
			var custNm = "";
			var custAddr = "";
			if(ComChkLen(formObj.nf_cust_nm) != 1){
				custNm = ComGetObjValue(formObj.nf_cust_nm).substring(0,10);
			}else{
				custNm = ComGetObjValue(formObj.nf_cust_nm);
			}
			if(ComChkLen(formObj.nf_cust_addr) != 1){
				custAddr = ComGetObjValue(formObj.nf_cust_addr).substring(0,10);
			}else{
				custAddr = ComGetObjValue(formObj.nf_cust_addr);
			}    					
			var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr="+"";    					
			ComOpenPopup(url,970, 660, "callBackNf0192","0,0,1,1,1", true);
			customerDataDiffCheck(formObj);
			break; 
		case "btn_t7Ff0192":
			var custCntCd = formObj.ff_cust_cnt_cd.value;
			var custSeq = formObj.ff_cust_seq.value;
			var custNm = "";
			if(ComChkLen(formObj.ff_cust_nm) != 1){
				custNm = ComGetObjValue(formObj.ff_cust_nm).substring(0,10);
			}else{
				custNm = ComGetObjValue(formObj.ff_cust_nm);
			}
			var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    					
			ComOpenPopup(url,970, 660, "callBackFf0192","0,0,1,1,1", true);
			customerDataDiffCheck(formObj);
			break;
		case "btn_t7An0192":
			var custCntCd = formObj.an_cust_cnt_cd.value;
			var custSeq = formObj.an_cust_seq.value;
			var custNm = "";
			if(ComChkLen(formObj.an_cust_nm) != 1){
				custNm = ComGetObjValue(formObj.an_cust_nm).substring(0,10);
			}else{
				custNm = ComGetObjValue(formObj.an_cust_nm);
			}
			var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    		    					
			ComOpenPopup(url,970, 660, "callBackAn0192","0,0,1,1,1", true);
			customerDataDiffCheck(formObj)
			break; 
		case "btn_t7ShMdmCustNm":
			var custCntCd = formObj.sh_cust_cnt_cd.value;
			var custSeq = formObj.sh_cust_seq.value;
			var custNm = formObj.sh_cust_nm.value;
			var custAddress = formObj.sh_cust_addr.value;
			if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
				if ( ComIsNull(formObj.sh_cust_lgl_eng_nm.value) || ComIsNull(formObj.sh_mdm_address.value) ) {
					searchMdmCustNm(sheetObjects[0], formObj, "SH", custCntCd, custSeq);
				}
				if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
					if(ComShowCodeConfirm("BKG00343")){
						formObj.sh_cust_nm.value = getMakeBrData("NAME",formObj.sh_cust_lgl_eng_nm.value);
						formObj.sh_cust_addr.value = getMakeBrData("ADDR",formObj.sh_mdm_address.value); 
					}
				}else{
					formObj.sh_cust_nm.value = getMakeBrData("NAME",formObj.sh_cust_lgl_eng_nm.value);
					formObj.sh_cust_addr.value = getMakeBrData("ADDR",formObj.sh_mdm_address.value); 
				}
				if (podCd.substring(0,2)=="IN") {
					formObj.sh_eori_no.value = formObj.sh_ida_gst_rgst_no.value;
				} else if (podCd.substring(0,2)=="CN") {
					formObj.sh_eori_no.value = formObj.sh_co_chn_no.value;
				}
			}else{
				ComShowCodeMessage("BKG00340");
			}
			customerDataDiffCheck(formObj);
			break;
		case "btn_t7CnMdmCustNm":
			var custCntCd = formObj.cn_cust_cnt_cd.value;
			var custSeq = formObj.cn_cust_seq.value;
			var custNm = formObj.cn_cust_nm.value;
			var custAddress = formObj.cn_cust_addr.value;
			if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
				if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
					if(ComShowCodeConfirm("BKG00343")){
						formObj.cn_cust_nm.value = getMakeBrData("NAME",formObj.cn_cust_lgl_eng_nm.value);
						formObj.cn_cust_addr.value = getMakeBrData("ADDR",formObj.cn_mdm_address.value); 
					}
				}else{
					formObj.cn_cust_nm.value = getMakeBrData("NAME",formObj.cn_cust_lgl_eng_nm.value);
					formObj.cn_cust_addr.value = getMakeBrData("ADDR",formObj.cn_mdm_address.value); 
				}
				if (podCd.substring(0,2)=="IN") {
					formObj.cn_eori_no.value = formObj.cn_ida_gst_rgst_no.value;
				} else if (podCd.substring(0,2)=="CN") {
					formObj.cn_eori_no.value = formObj.cn_co_chn_no.value;
				}
			}else{
				ComShowCodeMessage("BKG00340");
			}
			customerDataDiffCheck(formObj);
			break;     		
		case "btn_t7NfMdmCustNm":
			var custCntCd = formObj.nf_cust_cnt_cd.value;
			var custSeq = formObj.nf_cust_seq.value;
			var custNm = formObj.nf_cust_nm.value;
			var custAddress = formObj.nf_cust_addr.value;
			if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
				if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
					if(ComShowCodeConfirm("BKG00343")){
						formObj.nf_cust_nm.value = getMakeBrData("NAME",formObj.nf_cust_lgl_eng_nm.value);
						formObj.nf_cust_addr.value = getMakeBrData("ADDR",formObj.nf_mdm_address.value); 
					}
				}else{
					formObj.nf_cust_nm.value = getMakeBrData("NAME",formObj.nf_cust_lgl_eng_nm.value);
					formObj.nf_cust_addr.value = getMakeBrData("ADDR",formObj.nf_mdm_address.value); 
				}
				if (podCd.substring(0,2)=="IN") {
					formObj.nf_eori_no.value = formObj.nf_ida_gst_rgst_no.value;
				} else if (podCd.substring(0,2)=="CN") {
					formObj.nf_eori_no.value = formObj.nf_co_chn_no.value;
				}
			}else{
				ComShowCodeMessage("BKG00340");
			}
			customerDataDiffCheck(formObj);
			break;     		
		case "btn_t7FfMdmCustNm":
			var custCntCd = formObj.ff_cust_cnt_cd.value;
			var custSeq = formObj.ff_cust_seq.value;
			var custNm = formObj.ff_cust_nm.value;
			if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
				if(!ComIsNull(custNm)){
					if(ComShowCodeConfirm("BKG00343")){    								
						if(ComIsNull(formObj.ff_cust_lgl_eng_nm.value)){
							formObj.ff_cust_nm.value = getMakeBrData("ADDR",formObj.ff_mdm_address.value);
						}else{
							if(!ComIsNull(formObj.ff_mdm_address.value)){
								formObj.ff_cust_nm.value = getMakeBrData("NAME",formObj.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.ff_mdm_address.value); 
							}
						}
					}
				}else{
					if(ComIsNull(formObj.ff_cust_lgl_eng_nm.value)){
						formObj.ff_cust_nm.value = getMakeBrData("ADDR",formObj.ff_mdm_address.value);
					}else{
						if(!ComIsNull(formObj.ff_mdm_address.value)){
							formObj.ff_cust_nm.value = getMakeBrData("NAME",formObj.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.ff_mdm_address.value); 
						}
					}
				}
			}else{
				ComShowCodeMessage("BKG00340");
			}
			customerDataDiffCheck(formObj);
			break;     		
		case "btn_t7AnMdmCustNm":    		
			var custCntCd = formObj.an_cust_cnt_cd.value;
			var custSeq = formObj.an_cust_seq.value;
			var custNm = formObj.an_cust_nm.value;
			if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
				if(!ComIsNull(custNm)){
					if(ComShowCodeConfirm("BKG00343")){
						if(ComIsNull(formObj.an_cust_lgl_eng_nm.value)){
							formObj.an_cust_nm.value = getMakeBrData("ADDR",formObj.an_mdm_address.value);
						}else{
							if(!ComIsNull(formObj.an_mdm_address.value)){
								formObj.an_cust_nm.value = getMakeBrData("NAME",formObj.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.an_mdm_address.value); 
							}
						}
					}
				}else{
					if(ComIsNull(formObj.an_cust_lgl_eng_nm.value)){
						formObj.an_cust_nm.value = getMakeBrData("ADDR",formObj.an_mdm_address.value);
					}else{
						if(!ComIsNull(formObj.an_mdm_address.value)){										
							formObj.an_cust_nm.value = getMakeBrData("NAME",formObj.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObj.an_mdm_address.value); 
						}
					}
				}
			}else{
				ComShowCodeMessage("BKG00340");
			}
			customerDataDiffCheck(formObj);
			break;
			
		case "btn_t7ShZipCode":
			var zip_cd = formObj.sh_cust_zip_id.value;
			var cnt_cd = formObj.sh_cust_cnt_cd.value;

			ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
					,800, 600, "callBackShZipCode","1,0,1,1,1", true);			
			break;
		case "btn_t7CnZipCode":
			var zip_cd = formObj.cn_cust_zip_id.value;
			var cnt_cd = formObj.cn_cust_cnt_cd.value;
			ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
					,800, 600, "callBackCnZipCode","1,0,1,1,1", true);			
			break;
		case "btn_t7NfZipCode":
			var zip_cd = formObj.nf_cust_zip_id.value;
			var cnt_cd = formObj.nf_cust_cnt_cd.value;
			ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
					,800, 600, "callBackNfZipCode","1,0,1,1,1", true);			
			break;
		case "btn_t7Ex0192":
//			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
//				break;
//			}    					
			var custCntCd = formObj.ex_cust_cnt_cd.value;
			var custSeq = formObj.ex_cust_seq.value;
			ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq,970, 655, "callBackEx0192","0,0,1,1,1", true);
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
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {	
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    // IBMultiCombo초기화
	
	var comboLen = comboObjects.length;
	
    for(var j=0; j<comboLen; j++){
        initCombo(comboObjects[j]);
    }     
	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	initControl();
	displayDeleteButtonOfAcualCustomer();  // Actual Customer Delete Button ... 2011.05.19 	
}

function initControl() {
	var formObj = document.form;

	axon_event.addListenerFormat("keypress", "form_keypress", formObj);
//	axon_event.addListenerForm  ("blur", "form_blur", formObj);
	axon_event.addListenerForm  ("change", "form_onChange", formObj);
	axon_event.addListenerForm  ('click', 'form_click', formObj); //- 클릭시
	axon_event.addListenerForm  ('beforedeactivate', 'form_deactivate',  formObj); //- 포커스 나갈때     

	applyShortcut();
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 /**
  * 콤보 초기설정값
  * @param {IBMultiCombo} comboObj  comboObj
  */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.UseCode = true;
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
 
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		//with (sheetObj) {
			// 높이 설정
		sheetObj.style.height = 0;
			// 전체 너비 설정
			sheetObj.SheetWidth = 0;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 15, 100);

//			var HeadTitle1 = "||||||||||||||||||||||||||||||||||||||||||||||||||||||";
			var HeadTitle1 = "|";
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
			// var prefix="sheet1_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, true,	"ibflag");
			sheetObj.InitDataProperty(0, cnt++ , dtData,			35,     daCenter,   false,  "chk");
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_seq", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_nm", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_addr_prn_flg", 			false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_lgl_eng_nm", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_cty_nm", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_ste_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cstms_decl_cnt_cd", 	false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_zip_id", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"kr_cstms_cust_tp_cd", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_seq",				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_nm", 				false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_addr_prn_flg", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_lgl_eng_nm", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_cty_nm", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_ste_cd", 			false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cstms_decl_cnt_cd",		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_zip_id", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_fax_no", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cn_cust_eml", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"cust_to_ord_flg", 			false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_seq", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_nm", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_addr_prn_flg", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_lgl_eng_nm", 		false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_cty_nm", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_ste_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cstms_decl_cnt_cd", 	false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_zip_id", 			false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_fax_no", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"nf_cust_eml",				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_cust_seq", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_cust_nm", 				false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_addr_prn_flg", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_cust_lgl_eng_nm", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ff_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_cust_seq", 				false, "", dfNone, 0, true, true);
//
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_cust_nm", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_addr_prn_flg",			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_cust_lgl_eng_nm", 		false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"an_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ex_cust_nm", 				false, "", dfNone, 0, true, true);
//			
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"ex_addr_prn_flg", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"br_cust_cnt_cd", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"br_cust_nm", 				false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"br_cust_addr", 			false, "", dfNone, 0, true, true);
//			InitDataProperty(0, cnt++, dtData, 			50, daCenter, true,	"sh_cust_tp", 				false, "", dfNone, 0, true, true);
			
/*			HeadTitle1 = "";
			for (var i = 0; i < LastCol + 1; i++) {
				if (i > 0) HeadTitle1 += "|";
				HeadTitle1 += ColSaveName(i);
			}
			InitHeadRow(0, HeadTitle1, true);*/

			sheetObj.CountPosition = 0;
		//}
		break;

	}
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = 1;

	switch (sAction) {
	case IBSAVE: // 저장 for test
		if (!validateForUpload()) return false;
		var params = getSaveStringForUpload();
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_02GS.do", params);
		ComOpenWait(false);

		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
			sheetObj.LoadSaveXml(sXml);
			return false;
		}
		
		formObj.f_cmd.value = SEARCH;
		var aXml = formObj.sXml.value;
		formObj.sXml.value = "";
		
		ComOpenWait(true);
		sXml = sheetObj.GetSearchXml("ESM_BKG_0229_02GS.do", FormQueryString(formObj));
		ComOpenWait(false);

		formObj.sXml.value = aXml;
		arrXml = sXml.split("|$$|");

		// Combo 셋팅
		if (arrXml.length > 0){			
			ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
			sheetObj.LoadSearchXml(arrXml[0]);
		}   			
		BkgEtcDataXmlToForm(arrXml[0], formObj);
		customerSearchEnd(formObj);
		customerDataDiffCheck(formObj);
		break;
		
	case IBSEARCH: // 조회
		parent.tabObjects[0].TabBackColor(1) = "#96c792";
		resetAlpsCustomer(formObj);
		// IBCLEAR 이어서 실행
	case IBCLEAR: // 초기 setting	
		var sXml = formObj.sXml.value;
		var arrXml = sXml.split("|$$|"); 
		// Combo 셋팅
		if (arrXml.length > 0){	
			ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
			sheetObjects[0].LoadSearchXml(arrXml[0]);
			formObj.cust_nis.value = "Y";
		}
		BkgEtcDataXmlToForm(arrXml[0], formObj);
		// Tab1(Booking)에서 조회한  Individual Person Flag를 Tab2(Customer)로 세팅한다.
		formObj.indiv_pson_flg.value = parent.document.frames("t1frame").form.indiv_pson_flg.value;

		if(formObj.sh_cust_seq2.value=="0") formObj.sh_cust_seq2.value = "";
		if(formObj.cn_cust_seq2.value=="0") formObj.cn_cust_seq2.value = "";
		if(formObj.nf_cust_seq2.value=="0") formObj.nf_cust_seq2.value = "";
		if(formObj.ff_cust_seq2.value=="0") formObj.ff_cust_seq2.value = "";
		if(formObj.an_cust_seq2.value=="0") formObj.an_cust_seq2.value = "";
		if(formObj.ex_cust_seq2.value=="0") formObj.ex_cust_seq2.value = ""; //jsy
		
		/* [2018.04.18] 중국 해관 56호령 추가로 인한 컬럼명 분리 */
		var cnTsXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH04+"&bkg_no="+formObj.bkg_no.value);
		isCNTsRoute = ComGetEtcData(cnTsXml, "isCNTsRoute");
		var podCd = ComGetObjValue(parent.frames("t1frame").document.form.bkg_pod_cd2);
		
		if (isCNTsRoute == "Y" && podCd != "CNHKG") {
			// 중국 경유
			if (podCd != null && podCd.substring(0, 2) == "IN") {
				// 인도 향
				document.getElementById("sh_jpt_gst_man").innerHTML = "Enterprise Code";
				document.getElementById("cn_jpt_gst_man").innerHTML = "GST (E.CODE)";
				document.getElementById("nf_jpt_gst_man").innerHTML = "GST (E.CODE)";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
			} else if (podCd != null && podCd.substring(0, 2) == "ID") {
				// 인도네시아 향
				document.getElementById("sh_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("cn_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("nf_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
			} else {
				// 인도 및 인도네시아 외 향
				document.getElementById("sh_jpt_gst_man").innerHTML = "Enterprise Code";
				document.getElementById("cn_jpt_gst_man").innerHTML = "Enterprise Code";
				document.getElementById("nf_jpt_gst_man").innerHTML = "Enterprise Code";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
			}
			isCNTsValidation = "Y";
		} else {
			// 중국 경유하지 않고
			if (podCd != null && podCd.substring(0, 2) == "CN" && podCd != "CNHKG") {
				// 중국 향 홍콩 제외
				document.getElementById("sh_jpt_gst_man").innerHTML = "Enterprise Code";
				document.getElementById("cn_jpt_gst_man").innerHTML = "USCI/ORG/<br/>B.Lic";
				document.getElementById("nf_jpt_gst_man").innerHTML = "USCI/ORG/<br/>B.Lic";
				document.getElementById("cn_co_chn_tp_cd").style.display = "block";
				document.getElementById("nf_co_chn_tp_cd").style.display = "block";
				isCNTsValidation = "Y";
			} else if (podCd != null && podCd.substring(0, 2) == "JP") {
				document.getElementById("sh_jpt_gst_man").innerHTML = "JAPAN Tel#";
				document.getElementById("cn_jpt_gst_man").innerHTML = "JAPAN Tel#";
				document.getElementById("nf_jpt_gst_man").innerHTML = "JAPAN Tel#";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
				isCNTsValidation = "N";
			} else if (podCd != null && podCd.substring(0, 2) == "IN") {
				document.getElementById("sh_jpt_gst_man").innerHTML = "GST No";
				document.getElementById("cn_jpt_gst_man").innerHTML = "GST No";
				document.getElementById("nf_jpt_gst_man").innerHTML = "GST No";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
				isCNTsValidation = "N";
			} else if (podCd != null && podCd.substring(0, 2) == "ID") {
				document.getElementById("sh_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("cn_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("nf_jpt_gst_man").innerHTML = "NPWP No";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
				isCNTsValidation = "N";
			} else {
				document.getElementById("sh_jpt_gst_man").innerHTML = "JAPAN Tel#/GST No";
				document.getElementById("cn_jpt_gst_man").innerHTML = "JAPAN Tel#/GST No";
				document.getElementById("nf_jpt_gst_man").innerHTML = "JAPAN Tel#/GST No";
				document.getElementById("cn_co_chn_tp_cd").style.display = "none";
				document.getElementById("nf_co_chn_tp_cd").style.display = "none";
				document.getElementById("cn_co_chn_tp_cd").value = "";
				document.getElementById("nf_co_chn_tp_cd").value = "";
				isCNTsValidation = "N";
			}
		}
		/* [2018.04.18] 중국 해관 56호령 추가로 인한 컬럼명 분리 */
		
		ComSetObjValue(formObj.bl_tp_cd, ComGetEtcData(arrXml[0], "cust_to_ord_flg"));

		if(top.document.form.tabload2.value == "COPY"){
			dataCopy();
		}
		top.document.form.tabload2.value = "LOAD";

		customerSearchEnd(formObj);
		customerDataDiffCheck(formObj);
		//Shipper : 구주 24 신고 대상이고, Shipper Country code가 'KR'인 경우 상세 주소란의 Country를 'KR'로 Default Setting 
		checkEu24ForKr(formObj);
		break;

	case IBSEARCH_ASYNC02: // Data Copy
		parent.tabObjects[0].TabBackColor(1) = "#fff270";

		var eSvc = 0;
		var alps = 1;
		var tbl = new Array(
				// Shipper
				new Array ("sh_cust_cnt_cd2",		"sh_cust_cnt_cd"),
				new Array ("sh_cust_seq2", 			"sh_cust_seq"),
				new Array ("sh_cust_lgl_eng_nm2", 	"sh_cust_lgl_eng_nm"),
				new Array ("sh_cust_nm2", 			"sh_cust_nm"),
				new Array ("sh_cust_addr2", 		"sh_cust_addr"),
				new Array ("sh_cust_cty_nm2", 		"sh_cust_cty_nm"),
				new Array ("sh_cust_ste_cd2", 		"sh_cust_ste_cd"),
				new Array ("sh_cstms_decl_cnt_cd2", "sh_cstms_decl_cnt_cd"),
				new Array ("sh_cust_zip_id2", 		"sh_cust_zip_id"),
				new Array ("sh_cust_fax_no2", 		"sh_cust_fax_no"),
				new Array ("sh_cust_eml2", 			"sh_cust_eml"),
				new Array ("sh_cust_phn_no2", 		"sh_cust_phn_no"),
				new Array ("sh_eur_cstms_st_nm2", 	"sh_eur_cstms_st_nm"),
//				new Array ("sh_eur_cstms_pst_id2", 	"sh_eur_cstms_pst_id"),
				new Array ("sh_eori_no2", 			"sh_eori_no"),
				// Consignee
				new Array ("cn_cust_cnt_cd2", 		"cn_cust_cnt_cd"),
				new Array ("cn_cust_seq2", 			"cn_cust_seq"),
				new Array ("cn_cust_lgl_eng_nm2",	"cn_cust_lgl_eng_nm"),
				new Array ("cn_cust_nm2", 			"cn_cust_nm"),
				new Array ("cn_cust_addr2", 		"cn_cust_addr"),
				new Array ("cn_cust_cty_nm2", 		"cn_cust_cty_nm"),
				new Array ("cn_cust_ste_cd2", 		"cn_cust_ste_cd"),
				new Array ("cn_cstms_decl_cnt_cd2", "cn_cstms_decl_cnt_cd"),
				new Array ("cn_cust_zip_id2", 		"cn_cust_zip_id"),
				new Array ("cn_cust_fax_no2", 		"cn_cust_fax_no"),
				new Array ("cn_cust_eml2", 			"cn_cust_eml"),
				new Array ("cn_cust_phn_no2", 		"cn_cust_phn_no"),
				new Array ("cn_eur_cstms_st_nm2", 	"cn_eur_cstms_st_nm"),
//				new Array ("cn_eur_cstms_pst_id2", 	"cn_eur_cstms_pst_id"),
				new Array ("cn_co_chn_tp_cd2",		"cn_co_chn_tp_cd"),
				new Array ("cn_eori_no2", 			"cn_eori_no"),
				// Notify
				new Array ("nf_cust_cnt_cd2", 		"nf_cust_cnt_cd"),
				new Array ("nf_cust_seq2", 			"nf_cust_seq"),
				new Array ("nf_cust_lgl_eng_nm2", 	"nf_cust_lgl_eng_nm"),
				new Array ("nf_cust_nm2", 			"nf_cust_nm"),
				new Array ("nf_cust_addr2", 		"nf_cust_addr"),
				new Array ("nf_cust_cty_nm2", 		"nf_cust_cty_nm"),
				new Array ("nf_cust_ste_cd2", 		"nf_cust_ste_cd"),
				new Array ("nf_cstms_decl_cnt_cd2", "nf_cstms_decl_cnt_cd"),
				new Array ("nf_cust_zip_id2", 		"nf_cust_zip_id"),
				new Array ("nf_cust_fax_no2", 		"nf_cust_fax_no"),
				new Array ("nf_cust_eml2", 			"nf_cust_eml"),
				new Array ("nf_cust_phn_no2", 		"nf_cust_phn_no"),
				new Array ("nf_eur_cstms_st_nm2", 	"nf_eur_cstms_st_nm"),
//				new Array ("nf_eur_cstms_pst_id2", 	"nf_eur_cstms_pst_id"),
				new Array ("nf_co_chn_tp_cd2", 		"nf_co_chn_tp_cd"),
				new Array ("nf_eori_no2", 			"nf_eori_no"),
				// Freight Forwarder
				new Array ("ff_cust_cnt_cd2", 		"ff_cust_cnt_cd"),
				new Array ("ff_cust_seq2", 			"ff_cust_seq"),
				new Array ("ff_cust_lgl_eng_nm2", 	"ff_cust_lgl_eng_nm"),
				new Array ("ff_cust_nm2", 			"ff_cust_nm"),
				// Also Notify
				new Array ("an_cust_cnt_cd2", 		"an_cust_cnt_cd"),
				new Array ("an_cust_seq2",			"an_cust_seq"),
				new Array ("an_cust_lgl_eng_nm2", 	"an_cust_lgl_eng_nm"),
				new Array ("an_cust_nm2", 			"an_cust_nm"),
				// Export Ref No jsy
				new Array ("ex_cust_cnt_cd2", 		"ex_cust_cnt_cd"),
				new Array ("ex_cust_seq2", 			"ex_cust_seq"),				
				new Array ("ex_cust_nm2", 			"ex_cust_nm"),
				new Array ("ex_cust_lgl_eng_nm2", 	"ex_cust_lgl_eng_nm"),
				// Broker
				new Array ("br_cust_cnt_cd2", 		"br_cust_cnt_cd"),
				new Array ("br_cust_nm2", 			"br_cust_nm"),
				new Array ("br_cust_addr2", 		"br_cust_addr"),			

				new Array ("org_cnt_nm2", 			"org_cnt_nm"),
				
				new Array ("agmt_act_cnt_cd2", 		"agmt_act_cnt_cd"),
				new Array ("agmt_act_cust_seq2", 	"agmt_act_cust_seq")
				);

		// eSVC로 받은 값을 ALPS로 Copy 함
		
		var tblLen = tbl.length;
		
		for (i= 0; i < tblLen; i++) {
			var eSvcElem = document.getElementsByName(tbl[i][eSvc])[0];
			var alpsElem = document.getElementsByName(tbl[i][alps])[0];
			
//			if (eSvcElem.value != null && eSvcElem.value != "") {
				// 필드명에 _seq가 들어간 경우, 0보다 큰 경우만 복사
				if (eSvcElem.name.indexOf("_cust_seq") >= 0) {
					if (parseFloat(eSvcElem.value) > 0) {
						alpsElem.value = ComTrim(eSvcElem.value);
					}
				} else if(eSvcElem.name.indexOf("_cnt_cd") >= 0) {
					if (eSvcElem.value != null && eSvcElem.value != "") {
						alpsElem.value = ComTrim(eSvcElem.value);
					}
				} else {
					alpsElem.value = ComTrim(eSvcElem.value);
				}
//			}
		}

		//print flag는 default로 켜줌
		ComSetObjValue(formObj.sh_addr_prn_flg, "Y");
		ComSetObjValue(formObj.cn_addr_prn_flg, "Y");
		ComSetObjValue(formObj.nf_addr_prn_flg, "Y");
		ComSetObjValue(formObj.ff_addr_prn_flg, "Y");
		ComSetObjValue(formObj.an_addr_prn_flg, "Y");
		ComSetObjValue(formObj.ex_addr_prn_flg, "Y");
		
		if (formObj.sh_kr_cstms_cust_tp_cd2.value != null && formObj.sh_kr_cstms_cust_tp_cd2.value != ''){
			formObj.kr_cstms_cust_tp_cd.value = formObj.sh_kr_cstms_cust_tp_cd2.value;
			ComSetObjValue(formObj.kr_cstms_cust_tp_cd, formObj.sh_kr_cstms_cust_tp_cd2.value);
		}
		if(ComGetObjValue(formObj.sh_cust_cnt_cd) == "KR"
				&& (Number(ComGetObjValue(formObj.sh_cust_seq)) == 695 || Number(ComGetObjValue(formObj.sh_cust_seq)) == 37635)){
			formObj.kr_cstms_cust_tp_cd.Code = "C";
		}
		
		if (formObj.cn_cust_to_ord_flg2.value != null && formObj.cn_cust_to_ord_flg2.value != ''){			
			ComSetObjValue(formObj.bl_tp_cd, formObj.cn_cust_to_ord_flg2.value);
		}

		// alps의 데이터가 없고 Copy인 경우 shKrCstmsCustTpCd를 rvis_cntr_cust_tp_cd2로 바꾼다.
		if(formObj.sender_id.value != "WEB"){
			//if (formObj.cust_nis.value == "N") {
				if (formObj.rvis_cntr_cust_tp_cd2.value != null && formObj.rvis_cntr_cust_tp_cd2.value != ''){
					formObj.kr_cstms_cust_tp_cd.value = formObj.rvis_cntr_cust_tp_cd2.value;
				}
			//}
		}
		// Shipper Code 값이 없는 경우에는 F/F Code 값을 Copy 하여줌. 
		if (formObj.sh_cust_cnt_cd.value == "" || formObj.sh_cust_cnt_cd.value == null) {
			if (formObj.sh_cust_seq.value == null || formObj.sh_cust_seq.value.length == 0) {
				formObj.sh_cust_cnt_cd.value = formObj.ff_cust_cnt_cd.value;
				formObj.sh_cust_seq.value = formObj.ff_cust_seq.value;
			}
		}

		customerSearchEnd(formObj);
		customerDataDiffCheck(formObj);
		//Shipper : 구주 24 신고 대상이고, Shipper Country code가 'KR'인 경우 상세 주소란의 Country를 'KR'로 Default Setting 
		checkEu24ForKr(formObj);
		isCopy = "true";
		
		displayDeleteButtonOfAcualCustomer(); 
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj,sAction){
    switch(sAction) {
			case IBSAVE:      // Save
 				// Check 된 CNEE CD 와 Individual Person 같이 존재 하는 경우, 둘 중 하나만 선택가능하도록 제어.
 				if(formObj.indiv_pson_flg.value == "Y" && formObj.cn_cust_seq.value != "" && formObj.cn_cust_lgl_eng_nm.value != ""){
 					ComShowCodeMessage("BKG08199");
 					return false;
 				}
 				
				// s/i일때만 validation
				if(!ComIsNull(formObj.sh_cust_zip_id) && formObj.sh_cust_zip_id.value.length>10){ 						 		
					ComShowCodeMessage("BKG06065", "Zip CD");
					ComSetFocus(formObj.sh_cust_zip_id); 						
					return false; 	 	 						
				}
				if(!ComIsNull(formObj.cn_cust_zip_id) && formObj.cn_cust_zip_id.value.length>10){ 						 		
					ComShowCodeMessage("BKG06065", "Zip CD");
					ComSetFocus(formObj.cn_cust_zip_id); 						
					return false; 	 	 						
				}
				if(!ComIsNull(formObj.nf_cust_zip_id) && formObj.nf_cust_zip_id.value.length>10){ 					 		
					ComShowCodeMessage("BKG06065", "Zip CD");
					ComSetFocus(formObj.nf_cust_zip_id); 						
					return false; 	 	 						
				}
 
 				if(formObj.sh_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Shipper", formObj.sh_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.sh_cstms_decl_cnt_cd); 
					return false;
 				}		
 				if(formObj.org_cnt_nm.value.length > 32){
// 					ComShowCodeMessage("BKG06065","Country of Origin");
 					ComShowCodeMessage("BKG40106","Country of Origin","32");
 					ComSetFocus(formObj.org_cnt_nm); 						
					return false;
 				}
 				
 				if(!ComIsNull(formObj.sh_cstms_decl_cnt_cd) && formObj.sh_cstms_decl_cnt_cd.value.length > 2){
 					ComShowCodeMessage("BKG40106","Shipper Country","2");
 					ComSetFocus(formObj.sh_cstms_decl_cnt_cd); 						
					return false;
 				}
 				if(!ComIsNull(formObj.cn_cstms_decl_cnt_cd) && formObj.cn_cstms_decl_cnt_cd.value.length > 2){
 					ComShowCodeMessage("BKG40106","Consignee Country","2");
 					ComSetFocus(formObj.cn_cstms_decl_cnt_cd); 						
					return false;
 				}
 				if(!ComIsNull(formObj.nf_cstms_decl_cnt_cd) && formObj.nf_cstms_decl_cnt_cd.value.length > 2){
 					ComShowCodeMessage("BKG40106","Notify Country","2");
 					ComSetFocus(formObj.nf_cstms_decl_cnt_cd); 						
					return false;
 				} 		
 				if(!ComIsNull(formObj.sh_eur_cstms_st_nm) && ComGetLenByByte(formObj.sh_eur_cstms_st_nm.value) > 50){
 					ComShowCodeMessage("BKG40106","Shipper Street/P.O.Box","50");
 					ComSetFocus(formObj.sh_eur_cstms_st_nm); 						
					return false;
 				} 
 				if(!ComIsNull(formObj.cn_eur_cstms_st_nm) && ComGetLenByByte(formObj.cn_eur_cstms_st_nm.value) > 50){
 					ComShowCodeMessage("BKG40106","Consignee Street/P.O.Box","50");
 					ComSetFocus(formObj.cn_eur_cstms_st_nm); 						
					return false;
 				} 	
 				if(!ComIsNull(formObj.nf_eur_cstms_st_nm) && ComGetLenByByte(formObj.nf_eur_cstms_st_nm.value) > 50){
 					ComShowCodeMessage("BKG40106","Notify Street/P.O.Box","50");
 					ComSetFocus(formObj.nf_eur_cstms_st_nm); 						
					return false;
 				} 	 				
 				
 				if(formObj.cn_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Consignee", formObj.cn_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.cn_cstms_decl_cnt_cd); 
					return false;
 				}		
 				if(formObj.nf_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Notify", formObj.nf_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.nf_cstms_decl_cnt_cd); 
					return false;
 				}				
 					
				if (parent.frames("t1frame").document.form.doc_tp_cd.value=="S") {
					// Country가 'US','CA'인 경우 ZipCode는 필수

					if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
		 				if(ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "CA"){
		 					if(ComIsNull(formObj.sh_cust_zip_id||ComChkLen(formObj.sh_cust_zip_id)>10)){ 						 		
		 						ComShowCodeMessage("BKG00344");
		 						ComSetFocus(formObj.sh_cust_zip_id); 						
		 						return false; 	 	 						
		 					}
		 				}

		 				if(ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "CA"){
		 					
		 					if(ComIsNull(formObj.cn_cust_zip_id)||ComChkLen(formObj.cn_cust_zip_id)>10){ 						 		
		 						ComShowCodeMessage("BKG00344");
		 						ComSetFocus(formObj.cn_cust_zip_id); 						
		 						return false; 	 	 						
		 					}
		 				}

		 				if(ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "CA"){
		 					
		 					if(ComIsNull(formObj.nf_cust_zip_id)||ComChkLen(formObj.nf_cust_zip_id)>10){ 						 		
		 						ComShowCodeMessage("BKG00344");
		 						ComSetFocus(formObj.nf_cust_zip_id); 						
		 						return false; 	 	 						
		 					}
		 				} 			
					}
	
					// B/L Type = 'Order' And Notify Code,Seq가 없다면 Notify Popup 호출
					if(formObj.cust_to_ord_flg.value == "Y"){
						if(ComIsNull(formObj.nf_cust_cnt_cd.value) || ComIsNull(formObj.nf_cust_seq.value)){
		  					if(ComChkLen(formObj.nf_cust_nm) != 1){
		  						custNm = ComGetObjValue(formObj.nf_cust_nm).substring(0,10);
		  					}else{
		  						custNm = ComGetObjValue(formObj.nf_cust_nm);
		  					}
		  					if(ComChkLen(formObj.nf_cust_addr) != 1){
		  						custAddr = ComGetObjValue(formObj.nf_cust_addr).substring(0,10);
		  					}else{
		  						custAddr = ComGetObjValue(formObj.nf_cust_addr);
		  					}    					
							ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.nf_cust_cnt_cd.value+"&cust_seq="+formObj.nf_cust_seq.value+"&cust_nm="+custNm+"&cust_addr="+"",970, 640, "callBackNf0192","0,0,1,1,1", true);
							//return false;
						}
					}
					// B/L Type = 'Straight' And Consignee Code,Seq가 없다면 Consignee Popup 호출 	
					if(formObj.cust_to_ord_flg.value == "N" && formObj.indiv_pson_flg.value == "N"){
						if(ComIsNull(formObj.cn_cust_cnt_cd.value) || ComIsNull(formObj.cn_cust_seq.value)){
		  					if(ComChkLen(formObj.cn_cust_nm) != 1){
		  						custNm = ComGetObjValue(formObj.cn_cust_nm).substring(0,10);
		  					}else{
		  						custNm = ComGetObjValue(formObj.cn_cust_nm);
		  					}
		  					if(ComChkLen(formObj.cn_cust_addr) != 1){
		  						custAddr = ComGetObjValue(formObj.cn_cust_addr).substring(0,10);
		  					}else{
		  						custAddr = ComGetObjValue(formObj.cn_cust_addr);
		  					}    					
							ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.cn_cust_cnt_cd.value+"&cust_seq="+formObj.cn_cust_seq.value+"&cust_nm="+custNm+"&cust_addr="+"",970, 640, "callBackCn0192","0,0,1,1,1", true);
							//return false;
						}
					} 			
					// caManifestFlag = 'Y' 이면 city,state/country, zip 필수(B/L Type이 'Y' -> Notify, 'N' -> Consignee)
					// pol이 'US' 인 경우는 제외
					if(formObj.ca_manifest_flag.value == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
						
						//20141125 주석처리 Start
						//shipper에 대해서도 validation함
	 					if(ComIsNull(formObj.sh_cust_cty_nm.value) || ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
							ComShowCodeMessage("BKG00346");
							return false;
						} 
									
						//To order인 경우에는 Consignee는 validation 하지 않음
						if(formObj.cust_to_ord_flg.value == "N"){
							if(formObj.cn_cstms_decl_cnt_cd.value == "US" || formObj.cn_cstms_decl_cnt_cd.value == "CA") {
		 	 					if(ComIsNull(formObj.cn_cust_cty_nm.value) || ComIsNull(formObj.cn_cust_ste_cd.value) || ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
			 						ComShowCodeMessage("BKG00346");
			 						return false;
			 					} 	
							}
						}
						
						if(formObj.nf_cstms_decl_cnt_cd.value == "US" || formObj.nf_cstms_decl_cnt_cd.value == "CA") {
							if(ComIsNull(formObj.nf_cust_cty_nm.value) || ComIsNull(formObj.nf_cust_ste_cd.value) || ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
								ComShowCodeMessage("BKG00346");
								return false;
							}
						}
						//20141125 주석처리 End
						
						// Same As Consignee 가 체크되어 있거나 Notify Name에 'Same As' 가 포함되어 있으면 에러.
						// 20090908 Same As Consignee 체크와 상관없이 Notify의 'Same As' 가 포함되어 있는지만 체크.
						//if(formObj.sam_cnee_ntfy_flg.checked || BkgIsContainsChars(formObj.nf_cust_nm,"same as")){
		 				if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
		 					BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
		 					BkgIsContainsChars(formObj.nf_cust_nm,"as per con")){
		 					ComShowCodeMessage("BKG00345");
		 					return false; 	 						
						}
					}
					

					var delCd = parent.document.frames("t1frame").form.bkg_del_cd.value;
					var podCd = parent.document.frames("t1frame").form.bkg_pod_cd.value;

					if(formObj.nl_flag.value == "Y" || podCd.substring(0,2)=="NL"){
						if(ComIsNull(formObj.sh_eori_no.value)){
							if(ComIsNull(formObj.sh_eur_cstms_st_nm.value) 
									|| ComIsNull(formObj.sh_cust_cty_nm.value)
									|| ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)
									|| ComIsNull(formObj.sh_cust_zip_id.value)){
								ComShowCodeMessage("BKG02063", "Shipper");
								if(ComIsNull(formObj.sh_eur_cstms_st_nm.value)){
									ComSetFocus(formObj.sh_eur_cstms_st_nm);
									return false;
								}
								if(ComIsNull(formObj.sh_cust_cty_nm.value)){
									ComSetFocus(formObj.sh_cust_cty_nm);
									return false;
								}
								if(ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
									ComSetFocus(formObj.sh_cstms_decl_cnt_cd);
									return false;
								}
								if(ComIsNull(formObj.sh_cust_zip_id.value)){
									ComSetFocus(formObj.sh_cust_zip_id);
									return false;
								}
							}
						}

		 				if(formObj.bl_tp_cd.value == "N"){
		 					if(ComIsNull(formObj.cn_eori_no.value)){
			 					if(ComIsNull(formObj.cn_eur_cstms_st_nm.value) 
											|| ComIsNull(formObj.cn_cust_cty_nm.value)
											|| ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)
											|| ComIsNull(formObj.cn_cust_zip_id.value)){
				 						ComShowCodeMessage("BKG02063", "Consignee");
										if(ComIsNull(formObj.cn_eur_cstms_st_nm.value)){
											ComSetFocus(formObj.cn_eur_cstms_st_nm);
											return false;
										}
										if(ComIsNull(formObj.cn_cust_cty_nm.value)){
											ComSetFocus(formObj.cn_cust_cty_nm);
											return false;
										}
										if(ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
											ComSetFocus(formObj.cn_cstms_decl_cnt_cd);
											return false;
										}
										if(ComIsNull(formObj.cn_cust_zip_id.value)){
											ComSetFocus(formObj.cn_cust_zip_id);
											return false;
										}
								}
							}
		 				} else {
		 					if(ComIsNull(formObj.nf_eori_no.value)){
		 						if(ComIsNull(formObj.nf_eur_cstms_st_nm.value) 
										|| ComIsNull(formObj.nf_cust_cty_nm.value)
										|| ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)
										|| ComIsNull(formObj.nf_cust_zip_id.value)){
			 						ComShowCodeMessage("BKG02063", "Notify");
									if(ComIsNull(formObj.nf_eur_cstms_st_nm.value)){
										ComSetFocus(formObj.nf_eur_cstms_st_nm);
										return false;
									}
									if(ComIsNull(formObj.nf_cust_cty_nm.value)){
										ComSetFocus(formObj.nf_cust_cty_nm);
										return false;
									}
									if(ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
										ComSetFocus(formObj.nf_cstms_decl_cnt_cd);
										return false;
									}
									if(ComIsNull(formObj.nf_cust_zip_id.value)){
										ComSetFocus(formObj.nf_cust_zip_id);
										return false;
									}
								}
							}
		 				}
					}
				}

				//EORI no 확인 시작 - 2010.12.31///////// - 반영예정
				var custCnts = [formObj.sh_cust_cnt_cd, formObj.cn_cust_cnt_cd, formObj.nf_cust_cnt_cd];
				var declCnts = [formObj.sh_cstms_decl_cnt_cd, formObj.cn_cstms_decl_cnt_cd, formObj.nf_cstms_decl_cnt_cd];
				var eoris = [formObj.sh_eori_no, formObj.cn_eori_no, formObj.nf_eori_no];
				var eMails = ["", formObj.cn_cust_eml, formObj.nf_cust_eml];
				var eurCstmsStNm = [formObj.sh_eur_cstms_st_nm, formObj.cn_eur_cstms_st_nm, formObj.nf_eur_cstms_st_nm];
				
				var custLen = custCnts.length;
				var eorisLen = eoris.length;
				
				var podCd = parent.document.frames("t1frame").form.bkg_pod_cd.value;
				var docTpCd = parent.document.frames("t1frame").form.doc_tp_cd.value;
				
				//Japan Tel# check : Doc type : S, U & POD Country : JP --2017.08.18
				if (podCd.substring(0,2)=="JP" && (docTpCd == "S" || docTpCd == "U")) {
					for (var ii=0; ii<eorisLen; ii++) {
	 					if (ComIsNull(eoris[ii])) {
	 						ComShowCodeMessage("BKG95129");
 							ComSetFocus(eoris[ii]);
 							return false;
	 					}
					}
				} else if ((podCd.substring(0,2)=="IN" || podCd.substring(0,2)=="ID") && (docTpCd == "S" || docTpCd == "U")) {
					if(formObj.bl_tp_cd.value == "N"){ //Straight
						if (podCd.substring(0,2)=="IN") {
							if (ComIsNull(eoris[1]) || ComIsNull(eoris[2]) || ComIsNull(eMails[1]) || ComIsNull(eMails[2])) { //Consignee
								ComShowCodeMessage("BKG95135");
		 						return false;
		 					}
						} else if (podCd.substring(0,2)=="ID") {
							if (ComIsNull(eoris[1]) || ComIsNull(eoris[2]) || ComIsNull(eMails[1]) || ComIsNull(eMails[2])) {
								ComShowCodeMessage("BKG95144");
								return false;
							}
							if (eoris[1].value.length != 15 || eoris[2].value.length != 15) {
								ComShowCodeMessage("BKG95137", "NPWP No", "15");
								return false;
							}
						}
					} else if (formObj.bl_tp_cd.value == "Y"){ //Order
						if (podCd.substring(0,2)=="IN") {
							if (ComIsNull(eoris[2]) || ComIsNull(eMails[2])) { //Notify
								ComShowCodeMessage("BKG95135");
								return false;
		 					}
						} else if (podCd.substring(0,2)=="ID") {
							if (ComIsNull(eoris[2]) || ComIsNull(eMails[2])) { //Notify
								ComShowCodeMessage("BKG95144");
								return false;
		 					}
							if (eoris[2].value.length != 15) {
								ComShowCodeMessage("BKG95137", "NPWP No", "15");
								return false;
							}
						}
					}
				} else if (podCd.substring(0,2)=="CN" && (docTpCd == "S" || docTpCd == "U")) {
					// 아래 isCNTsValidation == "Y" 일 때로 대신 체크
				} /*else { // 구주 오픈시 validation 추가 해야하는지... 검토...
					for (var ii=0; ii<custLen; ii++) {
						if (!ComIsNull(custCnts[ii]) && !ComIsNull(declCnts[ii]) && ComGetObjValue(custCnts[ii])!=ComGetObjValue(declCnts[ii])) {
							if (!ComShowCodeConfirm("BKG01151")) {
								ComSetFocus(declCnts[ii]);
								return false;
							}
						}
					}
	 				for (var ii=0; ii<eorisLen; ii++) {
	 					if (!ComIsNull(eoris[ii])) {
	 						if ("TEST"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							"NONE"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							/[^A-Za-z0-9]/g.test(ComGetObjValue(eoris[ii]))) {
	 							ComShowCodeMessage("BKG01152");
	 							ComSetFocus(eoris[ii]);
	 							return false;
	 						} else if (3>eoris[ii].value.length || 17<eoris[ii].value.length) {  //길이 check
	 							ComShowCodeMessage("BKG01152");
								ComSetFocus(eoris[ii]);
								return false;
	 						} else if (1<ComGetLenByByte(eoris[ii])) {
	 							if (!ComIsAlphabet(ComGetObjValue(eoris[ii]).substring(0,2),"u")) {  //앞 두자가 알파벳 대문자인지 확인
	 	 							ComShowCodeMessage("BKG01152");
	 								ComSetFocus(eoris[ii]);
	 								return false;
	 							}
	 						}
	 					}
	 				}
					//EORI no 확인 끝 - 2010.12.31/////////
				}*/
				
				if (isCNTsValidation == "Y" && (docTpCd == "S" || docTpCd == "U")) {
					/* ★★★★★ Live 올릴때 Validation 막고, 추후 적용 ★★★★★ */
					/* 중국 해관 56호령 Validation Check (S) */
					// Shipper.
					if (ComIsNull(formObj.sh_eori_no.value)) {
						ComShowCodeMessage("BKG95138", "SHPR", "");
						ComSetFocus(formObj.sh_eori_no);
						return false;
					}
					if (ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)) {
						ComShowCodeMessage("BKG95140", "SHPR", "");
						ComSetFocus(formObj.sh_cstms_decl_cnt_cd);
						return false;
					}
					if (ComIsNull(formObj.sh_eur_cstms_st_nm.value)) {
						ComShowCodeMessage("BKG95141", "SHPR", "");
						ComSetFocus(formObj.sh_eur_cstms_st_nm);
						return false;
					}
					if (ComIsNull(formObj.sh_cust_fax_no.value) && ComIsNull(formObj.sh_cust_eml.value) && ComIsNull(formObj.sh_cust_phn_no.value)) {
						ComShowCodeMessage("BKG95143", "SHPR", "");
						ComSetFocus(formObj.sh_cust_phn_no);
						return false;
					}
					if (formObj.cn_cust_nm.value.indexOf("TO ORDER") != -1) {
						// Notify.
						if (ComIsNull(formObj.nf_eori_no.value)) {
							if (isCNTsRoute == "Y")
								ComShowCodeMessage("BKG95138", "NOTIFY", "(when CNEE is 'TO ORDER')");
							else if (isCNTsRoute == "N")
								ComShowCodeMessage("BKG95139", "NOTIFY", "(when CNEE is 'TO ORDER')");
							ComSetFocus(formObj.nf_eori_no);
							return false;
						}
						if (ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)) {
							ComShowCodeMessage("BKG95140", "NOTIFY", "(when CNEE is 'TO ORDER')");
							ComSetFocus(formObj.nf_cstms_decl_cnt_cd);
							return false;
						}
						if (ComIsNull(formObj.nf_eur_cstms_st_nm.value)) {
							ComShowCodeMessage("BKG95141", "NOTIFY", "(when CNEE is 'TO ORDER')");
							ComSetFocus(formObj.nf_eur_cstms_st_nm);
							return false;
						}
						if (ComIsNull(formObj.nf_cust_fax_no.value) && ComIsNull(formObj.nf_cust_eml.value) && ComIsNull(formObj.nf_cust_phn_no.value)) {
							ComShowCodeMessage("BKG95143", "NOTIFY", "(when CNEE is 'TO ORDER')");
							ComSetFocus(formObj.nf_cust_phn_no);
							return false;
						}
					} else {
						// Consignee.
						if (ComIsNull(formObj.cn_eori_no.value)) {
							if (isCNTsRoute == "Y")
								ComShowCodeMessage("BKG95138", "CNEE", "");
							else if (isCNTsRoute == "N")
								ComShowCodeMessage("BKG95139", "CNEE", "");
							ComSetFocus(formObj.cn_eori_no);
							return false;
						}
						if (ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)) {
							ComShowCodeMessage("BKG95140", "CNEE", "");
							ComSetFocus(formObj.cn_cstms_decl_cnt_cd);
							return false;
						}
						if (ComIsNull(formObj.cn_eur_cstms_st_nm.value)) {
							ComShowCodeMessage("BKG95141", "CNEE", "");
							ComSetFocus(formObj.cn_eur_cstms_st_nm);
							return false;
						}
						if (ComIsNull(formObj.cn_cust_fax_no.value) && ComIsNull(formObj.cn_cust_eml.value) && ComIsNull(formObj.cn_cust_phn_no.value)) {
							ComShowCodeMessage("BKG95143", "CNEE", "");
							ComSetFocus(formObj.cn_cust_phn_no);
							return false;
						}
					}
					/* 중국 해관 56호령 Validation Check (E) */
				//EORI no check
				//GST No check : Doc type : S, U & POD Country : IN --2017.11.13
				}

				// Consignee Seq Check 주석처리 (정민정 과장 요청 20091013)
//				if(ComIsNull(formObj.cn_cust_seq.value)){
//					ComShowCodeMessage("BKG00009");
//					ComSetFocus(formObj.cn_cust_seq);
//	 				return false; 					
//				} 				 				

				// B/L Type = 'O'
				if(formObj.cust_to_ord_flg.value == "Y"){					
					// Same As Consignee 가 체크되어 있으면 에러.
					if(formObj.sam_cnee_ntfy_flg.checked){
	 					ComShowCodeMessage("BKG00438");
	 					return false; 	 				 						
					}
					
					//  Consignee Name에 'order' 가 포함되지 않는 경우
					if(!BkgIsContainsChars(formObj.cn_cust_nm,"order")){
						if(ComShowCodeConfirm("BKG00348")){
							formObj.cust_to_ord_flg.value = "N";
						}  						
					}
					// Notify Name에 'same','consignee','as above' 가 포함되어 있을 경우
	 				if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
	 					BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
	 					BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
	 					BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
	 					BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
	 					BkgIsContainsChars(formObj.nf_cust_nm,"as per con")){
						
	 					if(ComShowCodeConfirm("BKG10001")){
							formObj.cust_to_ord_flg.value = "N";
						}  						

	 				}	

				}
				// B/L Type = 'S'
				if(formObj.cust_to_ord_flg.value == "N"){
					//  Consignee Name에 'order' 가 포함되어 있는 경우
					if(BkgIsContainsChars(formObj.cn_cust_nm,"order")){
						if(ComShowCodeConfirm("BKG00347")){
							formObj.cust_to_ord_flg.value = "Y";
						}  						
					}				
				}		

				// Same As CNEE 자동 Flagging
				// cnee, ntfy 이름이 같은 경우 추가
				var isSame = false;
				if(BkgIsContainsChars(formObj.nf_cust_nm,"same as") || 
					BkgIsContainsChars(formObj.nf_cust_nm,"sameas") ||
					BkgIsContainsChars(formObj.nf_cust_nm,"consignee") || 
					BkgIsContainsChars(formObj.nf_cust_nm,"as above") || 
					BkgIsContainsChars(formObj.nf_cust_nm,"as per above") ||
					BkgIsContainsChars(formObj.nf_cust_nm,"as per con") ||
 					// consignee 있는데 notify 없는 경우 same as로 판단
 					(!ComIsNull(formObj.cn_cust_nm) && !ComIsNull(formObj.cn_cust_addr) &&
 					ComIsNull(formObj.nf_cust_nm) && ComIsNull(formObj.nf_cust_addr))){
					
					isSame = true;
				} else if(!ComIsNull(formObj.nf_cust_nm) && !ComIsNull(formObj.cn_cust_nm)){
					if(BkgGetCharsLen(formObj.nf_cust_nm, 0, 10, 10) == BkgGetCharsLen(formObj.cn_cust_nm, 0, 10, 10)){
						if(BkgGetCharsLen(formObj.nf_cust_addr, 0, 3, 3) == BkgGetCharsLen(formObj.cn_cust_addr, 0, 3, 3)){
							isSame = true;
						}
					}
					if(BkgIsContainsChars(formObj.nf_cust_nm,BkgGetCharsLen(formObj.cn_cust_nm, 0, 10, 10))){
						if(BkgGetCharsLen(formObj.nf_cust_addr, 0, 3, 3) == BkgGetCharsLen(formObj.cn_cust_addr, 0, 3, 3)){
							isSame = true;
						}
					}
				} 				

				if(isSame){
					ComSetObjValue(formObj.sam_cnee_ntfy_flg, "Y");
				}else{
					ComSetObjValue(formObj.sam_cnee_ntfy_flg, "N");
				} 				
				
				if (formObj.ex_addr_prn_flg.checked && !ComIsNull(formObj.agmt_act_cnt_cd) && !ComIsNull(formObj.agmt_act_cust_seq)){
					var param = "&f_cmd=" + COMMAND07 + "&agmt_act_cnt_cd=" + formObj.agmt_act_cnt_cd.value
					                                  + "&agmt_act_cust_seq=" + formObj.agmt_act_cust_seq.value 
        		 	                                  + "&ex_cust_nm=" + formObj.ex_cust_nm.value;

					var sXml07 = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do", param);
					var agmt_cust_flag = ComGetEtcData(sXml07, "agmt_cust_flag");
					var agmt_cust_nm = ComGetEtcData(sXml07, "agmt_cust_nm");
					if(agmt_cust_flag == "Y"){
						if(ComShowCodeConfirm("BKG08310")){
							if(ComIsNull(formObj.ex_cust_nm)){
								formObj.ex_cust_nm.value = formObj.ex_cust_nm.value + agmt_cust_nm;
							}else{
								formObj.ex_cust_nm.value = formObj.ex_cust_nm.value + "\n" + agmt_cust_nm;
							}
							
						}
					}
				}

				// 각 Text 정보 Size Validation
				if(!validateCols(2, 35, formObj.sh_cust_nm, "Shipper")){
					return false;
				}
				if(!validateCols(3, 35, formObj.sh_cust_addr, "Shipper")){
					return false;
				}
				if(!validateCols(2, 35, formObj.cn_cust_nm, "Consignee")){
					return false;
				}
				if(!validateCols(3, 35, formObj.cn_cust_addr, "Consignee")){
					return false;
				} 				
				if(!validateCols(2, 35, formObj.nf_cust_nm, "Notify")){
					return false;
				}
				if(!validateCols(3, 35, formObj.nf_cust_addr, "Notify")){
					return false;
				} 				
				if(!validateCols(5, 35, formObj.ff_cust_nm, " F/Forwarder")){
					return false;
				}
				if(!validateCols(5, 35, formObj.an_cust_nm, "A/Notify")){
					return false;
				} 		
				if(!validateCols(3, 35, formObj.ex_cust_nm, "Export Ref.")){
					return false;
				} 	 			

		 		// Consignee Fax No가 maxlength를 초과한 경우
		 		if (ComChkLen(formObj.cn_cust_fax_no) == 0) {
		 			ComShowCodeMessage("BKG06065", "Consignee's Fax No");
		 			ComSetFocus(formObj.cn_cust_fax_no);
		 			return false;
		 		}
		 		// Notify Fax No가 maxlength를 초과한 경우
		 		if (ComChkLen(formObj.nf_cust_fax_no) == 0) {
		 			ComShowCodeMessage("BKG06065", "Notify's Fax No");
		 			ComSetFocus(formObj.nf_cust_fax_no);
		 			return false;
		 		}
		 		
		 		if(parent.frames("t1frame").document.form.doc_tp_cd.value !="B" && parent.frames("t1frame").document.form.non_rt_sts_cd.value != "R") {
			 		// Broker Code가 없는 경우
			 		if(ComGetObjValue(formObj.sh_cust_cnt_cd) == "IN" ){
				 		if(ComIsNull(formObj.br_cust_cnt_cd.value)){
				 			ComShowCodeMessage("BKG95001", "Pan Code in","Broker column");
				 			ComSetFocus(formObj.br_cust_cnt_cd);
				 			return false;
				 		}
			 		}
		 		}
		 		
		 			 		
				// Black Customer(Iran) Check
//				var sXml04 = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
//				var black_cust_flag = ComGetEtcData(sXml04, "black_cust_flag");
//				var black_cust_list = ComGetEtcData(sXml04, "black_cust_list");
//				if(black_cust_flag == "Y"){
//					if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
//						return false;
//					}
//				}
//				else{
					// Black Customer(US) Check
					var sXml04 = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do?f_cmd="+COMMAND09, FormQueryString(formObj));
					var black_cust_flag = ComGetEtcData(sXml04, "black_cust_flag");
					var black_cust_list = ComGetEtcData(sXml04, "black_cust_list");
					if(black_cust_flag == "Y"){
						if(!ComShowCodeConfirm("BKG08343", black_cust_list)){
							return false;
						}
					}
//				}
				
        		// Black Customer Check(EU)
				var sXml05 = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do?f_cmd="+COMMAND05, FormQueryString(formObj));
				if (ComGetEtcData(sXml05, "black_cust_flag") != "N"){
					sheetObjects[0].LoadSearchXml(sXml05);
					return false;
				}
				
				// IKEA Key Data Check 로직 추가 2013.02.01
				if( formObj.sender_id.value == "IKEA.EBCCNS1" && parent.frames("t1frame").document.form.doc_tp_cd.value=="B"){
					var sh_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_cnt_cd);
					var sh_cust_seq = ComGetObjValue(parent.document.frames("t2frame").form.sh_cust_seq);
					var cn_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_cnt_cd);
					var cn_cust_seq = ComGetObjValue(parent.document.frames("t2frame").form.cn_cust_seq);
					var nf_cust_cnt_cd = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_cnt_cd);
					var nf_cust_seq = ComGetObjValue(parent.document.frames("t2frame").form.nf_cust_seq);
					var sc_no  = ComGetObjValue(parent.document.frames("t1frame").form.sc_no);   
					var rfa_no = ComGetObjValue(parent.document.frames("t1frame").form.rfa_no); 

				    var param = "&f_cmd=" + COMMAND06 + "&sc_no=" + sc_no+ "&rfa_no=" + rfa_no 
						        		 	+ "&sh_cust_cnt_cd=" + sh_cust_cnt_cd+ "&sh_cust_seq=" + sh_cust_seq 
								         	+ "&cn_cust_cnt_cd=" + cn_cust_cnt_cd+ "&cn_cust_seq=" + cn_cust_seq 
								         	+ "&nf_cust_cnt_cd=" + nf_cust_cnt_cd+ "&nf_cust_seq=" + nf_cust_seq ;

				    var sXml06 = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do", param);
					var edi_cust_flag = ComGetEtcData(sXml06, "edi_cust_flag");
					if(edi_cust_flag == "N"){
						ComShowCodeMessage("BKG08252");
						return false;
					}
				}	
								
				if( BkgIsContainsChars(formObj.cn_cust_nm,"LG SOURCING") ||
						BkgIsContainsChars(formObj.cn_cust_nm,"LOWES COMPANIES") ){
					if (ComChkLen(ComGetObjValue(formObj.cn_cust_cnt_cd), 2) != "2" || ComIsNull(ComGetObjValue(formObj.cn_cust_seq))){
	 					ComShowCodeMessage("BKG00445","the Consignee Code");
		 				return false; 	 						
					}
				}
				
				//zip_cd check
				if( ComChkLen(formObj.cn_cust_cnt_cd.value,2 )==2 &&  formObj.cn_cust_cnt_cd.value =='DE' ) {
					if((!ComIsEmpty(formObj.cn_cust_zip_id.value) && !ComIsNumber(formObj.cn_cust_zip_id.value) ) || 
							(!ComIsEmpty(formObj.cn_cust_zip_id.value) &&  formObj.cn_cust_zip_id.value.length  < 5) ) {
						ComShowCodeMessage("BKG02077");
						ComSetFocus(formObj.cn_cust_zip_id);
						return false; 	
					}
				}			
				if( ComChkLen(formObj.nf_cust_cnt_cd.value,2 )==2 &&  formObj.nf_cust_cnt_cd.value =='DE' ) {
					if((!ComIsEmpty(formObj.nf_cust_zip_id.value) && !ComIsNumber(formObj.nf_cust_zip_id.value)) ||
							(!ComIsEmpty(formObj.nf_cust_zip_id.value) &&  formObj.nf_cust_zip_id.value.length < 5)) {
						ComShowCodeMessage("BKG02077");
						ComSetFocus(formObj.nf_cust_zip_id);
						return false; 						
					}
				}
				
				// Individual Flag Save MSG
				if(formObj.indiv_pson_flg.value == "Y"){
					if(!ComShowCodeConfirm("BKG08197"))
						return false;
				}
				
				if(ComGetObjValue(formObj.cn_cust_eml) != ""
	                && !ComIsEmailAddr(ComGetObjValue(formObj.cn_cust_eml))){
	                ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.cn_cust_eml));
	                ComSetFocus(formObj.cn_cust_eml);
	                return false;
	            }
    			if(ComGetObjValue(formObj.nf_cust_eml) != ""
	                && !ComIsEmailAddr(ComGetObjValue(formObj.nf_cust_eml))){
	                ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.nf_cust_eml));
	                ComSetFocus(formObj.nf_cust_eml);
	                return false;
	            }
    			if(ComGetObjValue(formObj.an_cust_eml) != ""
	                && !ComIsEmailAddr(ComGetObjValue(formObj.an_cust_eml))){
	                ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.an_cust_eml));
	                ComSetFocus(formObj.an_cust_eml);
	                return false;
	            }

    			if (parent.frames("t1frame").document.form.bkg_sts_cd.value=="") {
    				if ( parent.frames("t1frame").document.form.bkg_pod_cd.value.substring(0,2) == 'JP' ){
    					if ( formObj.kr_cstms_cust_tp_cd.Code == 'S'){
    						ComShowCodeMessage("BKG08282");
//	    					if(!ComShowCodeConfirm("BKG08282"))
//	    						return false;
    					} else if ( formObj.kr_cstms_cust_tp_cd.Code == 'C'){
    						ComShowCodeMessage("BKG08283");
//	    					if(!ComShowCodeConfirm("BKG08283"))
//	    						return false;    						
    					}
    				}
    			}
    			
    			//최도순[CHM-201431914] Split 01-e-bkg & si process, BKG creation 화면에 “CN 404 EDI 주소city, state, zip missing”  
    			if(parent.frames("t1frame").document.form.doc_tp_cd.value !="B" && parent.frames("t1frame").document.form.non_rt_sts_cd.value != "R") {
	    			if (parent.frames("t1frame").document.form.bkg_pol_cd.value.substring(0,2) == 'CA') {
	    				
	    				if(ComIsNull(formObj.sh_cust_cty_nm)){ 						 		
	    					ComShowCodeMessage("BKG00554","Shipper City");
	 						ComSetFocus(formObj.sh_cust_cty_nm); 						
	 						return false; 	 	 						
	 					}
	    				
	    				if(ComIsNull(formObj.sh_cust_ste_cd)){ 						 		
	    					ComShowCodeMessage("BKG00554","Shipper State");
	 						ComSetFocus(formObj.sh_cust_ste_cd); 						
	 						return false; 	 	 						
	 					}
	    				
	    				if(ComIsNull(formObj.sh_cstms_decl_cnt_cd)){ 						 		
	    					ComShowCodeMessage("BKG00554","Shipper Country");
	 						ComSetFocus(formObj.sh_cstms_decl_cnt_cd); 						
	 						return false; 	 	 						
	 					}
	    				
	    				if(ComIsNull(formObj.sh_cust_zip_id)){ 						 		
	    					ComShowCodeMessage("BKG00554","Shipper Zip CD");
	 						ComSetFocus(formObj.sh_cust_zip_id); 						
	 						return false; 	 	 						
	 					}
	    			}
    			}
    			
    			var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" 
					+ComGetObjValue(formObj.sh_cust_lgl_eng_nm)+" | "+ ComGetObjValue(formObj.sh_cust_nm);
				var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
				var output_text = ComGetEtcData(sXml, "output_text");
				if(output_text!=null && output_text.length>0){
					ComShowCodeMessage("BKG95101",output_text);
				}
				
				var param = "&f_cmd=" + SEARCH22 + "&input_text=" 
					+ComGetObjValue(formObj.sh_cust_lgl_eng_nm)+" | "+ ComGetObjValue(formObj.sh_cust_nm);
				var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
				var output_text = ComGetEtcData(sXml, "output_text");
				if(output_text!=null && output_text.length>0){
					ComShowCodeMessage("BKG95110",output_text);
				}
				var _tmp_f_cmd = formObj.f_cmd.value;
				formObj.f_cmd.value = COMMAND08;
				var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_02GS.do", FormQueryString(formObj));
    			var output_text = ComGetEtcData(sXml, "edi_cust_flag");
    			if(output_text!=null && output_text.length>0 && output_text == "N"){
					alert("Customer not verified for Portal service : please check with sale PIC."); // FIXME
				}
    			formObj.f_cmd.value = _tmp_f_cmd;
			break;              		
     } 		

    return true;
}

/**
 * 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 Validate 실패
 * 후 Focus 이동이 필요하면 (ex) Mandatory 항목 누락 후 Mandatory 필드에 Focus 이동 Focus 이동까지 한 후
 * return false
 */
function validateForUpload() {
	var formObj = document.form;
	
	if (parent.frames("t1frame").document.form) {
		formObj.bkg_no.value = parent.frames("t1frame").document.form.bkg_no.value;
	}
	
	return validateForm(formObj, IBSAVE);
}

/**
* 전체 Upload 버튼 CLICK시 호출 됨 TAB에 상관 없이 동일 이름의 함수를 가짐 내용은 TAB에 맞게 구현 각 화면에서
* Upload 버튼이 눌렸을 때 SC에 parameter 로 던지는 QueryString을 만들어 return
*/
function getSaveStringForUpload() {
	var formObj = document.form;
	
	formObj.f_cmd.value = MULTI;	
	// 조회해온 data처리(이중 전달 방지)
	var sXml = formObj.sXml.value;
	formObj.sXml.value = "";
	
	var params = FormQueryString(formObj);
	formObj.sXml.value = sXml;
//	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_");

//	var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_05GS.do?f_cmd="+MULTI, FormQueryString(formObj));
//	alert(params);
	return (params);
}

function customerDataDiffCheck(formObj){
	// 각 field가 다르면 파란 글씨
	// SHIPPER
	setDiffCheckColor(formObj.sh_cust_cnt_cd.value,     	formObj.sh_cust_cnt_cd2.value, 		'sh_cust_cnt_cd2');
	setDiffCheckColor(formObj.sh_cust_seq.value,        	formObj.sh_cust_seq2.value, 		'sh_cust_seq2');
	setDiffCheckColor(formObj.sh_cust_nm.value,         	formObj.sh_cust_nm2.value, 			'sh_cust_nm2');
	setDiffCheckColor(formObj.sh_cust_lgl_eng_nm.value, 	formObj.sh_cust_lgl_eng_nm2.value, 	'sh_cust_lgl_eng_nm2');
	setDiffCheckColor(formObj.sh_cust_addr.value,			formObj.sh_cust_addr2.value, 		'sh_cust_addr2');
	setDiffCheckColor(formObj.sh_cust_cty_nm.value, 		formObj.sh_cust_cty_nm2.value, 		'sh_cust_cty_nm2');
	setDiffCheckColor(formObj.sh_cust_ste_cd.value, 		formObj.sh_cust_ste_cd2.value, 		'sh_cust_ste_cd2');
	setDiffCheckColor(formObj.sh_cstms_decl_cnt_cd.value, 	formObj.sh_cstms_decl_cnt_cd2.value,'sh_cstms_decl_cnt_cd2');
	setDiffCheckColor(formObj.sh_cust_zip_id.value, 		formObj.sh_cust_zip_id2.value, 		'sh_cust_zip_id2');
	setDiffCheckColor(formObj.sh_cust_fax_no.value, 		formObj.sh_cust_fax_no2.value, 		'sh_cust_fax_no2');	
	setDiffCheckColor(formObj.sh_cust_eml.value, 			formObj.sh_cust_eml2.value,			'sh_cust_eml2');
	setDiffCheckColor(formObj.sh_cust_phn_no.value, 		formObj.sh_cust_phn_no2.value,		'sh_cust_phn_no2');
	setDiffCheckColor(formObj.sh_eur_cstms_st_nm.value, 	formObj.sh_eur_cstms_st_nm2.value, 	'sh_eur_cstms_st_nm2');
	setDiffCheckColor(formObj.sh_eori_no.value, 			formObj.sh_eori_no2.value, 			'sh_eori_no2');
	
	//CONSIGNEE
	setDiffCheckColor(formObj.cn_cust_cnt_cd.value, 		formObj.cn_cust_cnt_cd2.value, 		'cn_cust_cnt_cd2');	
	setDiffCheckColor(formObj.cn_cust_seq.value, 			formObj.cn_cust_seq2.value, 		'cn_cust_seq2');	
	setDiffCheckColor(formObj.cn_cust_nm.value, 			formObj.cn_cust_nm2.value, 			'cn_cust_nm2');	
	setDiffCheckColor(formObj.cn_cust_lgl_eng_nm.value, 	formObj.cn_cust_lgl_eng_nm2.value, 	'cn_cust_lgl_eng_nm2');	
	setDiffCheckColor(formObj.cn_cust_addr.value, 			formObj.cn_cust_addr2.value, 		'cn_cust_addr2');	
	setDiffCheckColor(formObj.cn_cust_cty_nm.value, 		formObj.cn_cust_cty_nm2.value, 		'cn_cust_cty_nm2');	
	setDiffCheckColor(formObj.cn_cust_ste_cd.value, 		formObj.cn_cust_ste_cd2.value, 		'cn_cust_ste_cd2');	
	setDiffCheckColor(formObj.cn_cstms_decl_cnt_cd.value, 	formObj.cn_cstms_decl_cnt_cd2.value,'cn_cstms_decl_cnt_cd2');	
	setDiffCheckColor(formObj.cn_cust_zip_id.value, 		formObj.cn_cust_zip_id2.value, 		'cn_cust_zip_id2');	
	setDiffCheckColor(formObj.cn_cust_fax_no.value, 		formObj.cn_cust_fax_no2.value, 		'cn_cust_fax_no2');	
	setDiffCheckColor(formObj.cn_cust_eml.value, 			formObj.cn_cust_eml2.value,			'cn_cust_eml2');
	setDiffCheckColor(formObj.cn_cust_phn_no.value, 		formObj.cn_cust_phn_no2.value,		'cn_cust_phn_no2');
	setDiffCheckColor(formObj.cn_eur_cstms_st_nm.value, 	formObj.cn_eur_cstms_st_nm2.value, 	'cn_eur_cstms_st_nm2');
	setDiffCheckColor(formObj.cn_co_chn_tp_cd.value, 		formObj.cn_co_chn_tp_cd2.value, 	'cn_co_chn_tp_cd2');	
	setDiffCheckColor(formObj.cn_eori_no.value, 			formObj.cn_eori_no2.value, 			'cn_eori_no2');
	
	//NOTIFY
	setDiffCheckColor(formObj.nf_cust_cnt_cd.value, 		formObj.nf_cust_cnt_cd2.value,		'nf_cust_cnt_cd2');	
	setDiffCheckColor(formObj.nf_cust_seq.value, 			formObj.nf_cust_seq2.value, 		'nf_cust_seq2');	
	setDiffCheckColor(formObj.nf_cust_nm.value, 			formObj.nf_cust_nm2.value, 			'nf_cust_nm2');
	setDiffCheckColor(formObj.nf_cust_lgl_eng_nm.value, 	formObj.nf_cust_lgl_eng_nm2.value, 	'nf_cust_lgl_eng_nm2');	
	setDiffCheckColor(formObj.nf_cust_addr.value, 			formObj.nf_cust_addr2.value, 		'nf_cust_addr2');	
	setDiffCheckColor(formObj.nf_cust_cty_nm.value, 		formObj.nf_cust_cty_nm2.value, 		'nf_cust_cty_nm2');	
	setDiffCheckColor(formObj.nf_cust_ste_cd.value, 		formObj.nf_cust_ste_cd2.value, 		'nf_cust_ste_cd2');	
	setDiffCheckColor(formObj.nf_cstms_decl_cnt_cd.value, 	formObj.nf_cstms_decl_cnt_cd2.value,'nf_cstms_decl_cnt_cd2');	
	setDiffCheckColor(formObj.nf_cust_zip_id.value, 		formObj.nf_cust_zip_id2.value, 		'nf_cust_zip_id2');	
	setDiffCheckColor(formObj.nf_cust_fax_no.value, 		formObj.nf_cust_fax_no2.value, 		'nf_cust_fax_no2');	
	setDiffCheckColor(formObj.nf_cust_eml.value, 			formObj.nf_cust_eml2.value, 		'nf_cust_eml2');
	setDiffCheckColor(formObj.nf_cust_phn_no.value, 		formObj.nf_cust_phn_no2.value, 		'nf_cust_phn_no2');
	setDiffCheckColor(formObj.nf_eur_cstms_st_nm.value, 	formObj.nf_eur_cstms_st_nm2.value, 	'nf_eur_cstms_st_nm2');
	setDiffCheckColor(formObj.nf_co_chn_tp_cd.value, 		formObj.nf_co_chn_tp_cd2.value, 	'nf_co_chn_tp_cd2');
	setDiffCheckColor(formObj.nf_eori_no.value, 			formObj.nf_eori_no2.value, 			'nf_eori_no2');

	//FORWARDER
	setDiffCheckColor(formObj.ff_cust_cnt_cd.value, 		formObj.ff_cust_cnt_cd2.value, 		'ff_cust_cnt_cd2');	
	setDiffCheckColor(formObj.ff_cust_seq.value, 			formObj.ff_cust_seq2.value, 		'ff_cust_seq2');	
	setDiffCheckColor(formObj.ff_cust_nm.value, 			formObj.ff_cust_nm2.value, 			'ff_cust_nm2');	
	setDiffCheckColor(formObj.ff_cust_lgl_eng_nm.value, 	formObj.ff_cust_lgl_eng_nm2.value, 	'ff_cust_lgl_eng_nm2');
	setDiffCheckColor(formObj.an_cust_cnt_cd.value, 		formObj.an_cust_cnt_cd2.value, 		'an_cust_cnt_cd2');	
	setDiffCheckColor(formObj.an_cust_seq.value, 			formObj.an_cust_seq2.value, 		'an_cust_seq2');	
	setDiffCheckColor(formObj.an_cust_nm.value, 			formObj.an_cust_nm2.value,			'an_cust_nm2');	
	setDiffCheckColor(formObj.an_cust_lgl_eng_nm.value, 	formObj.an_cust_lgl_eng_nm2.value, 	'an_cust_lgl_eng_nm2');	
	
	//EXPORT
	setDiffCheckColor(formObj.ex_cust_nm.value, 			formObj.ex_cust_nm2.value,			'ex_cust_nm2');
	setDiffCheckColor(formObj.ex_cust_cnt_cd.value, 		formObj.ex_cust_cnt_cd2.value, 		'ex_cust_cnt_cd2'); //jsy	
	setDiffCheckColor(formObj.ex_cust_seq.value, 			formObj.ex_cust_seq2.value, 		'ex_cust_seq2');
	
	//broker
	setDiffCheckColor(formObj.br_cust_cnt_cd.value, 		formObj.br_cust_cnt_cd2.value, 		'br_cust_cnt_cd2');	
	setDiffCheckColor(formObj.br_cust_nm.value, 			formObj.br_cust_nm2.value, 			'br_cust_nm2');	
	setDiffCheckColor(formObj.br_cust_addr.value, 			formObj.br_cust_addr2.value, 		'br_cust_addr2');
	
	// Country of Origin
	setDiffCheckColor(formObj.org_cnt_nm.value, 			formObj.org_cnt_nm2.value, 			'org_cnt_nm2');
	
	setDiffCheckColor(formObj.agmt_act_cnt_cd.value, 		formObj.agmt_act_cnt_cd2.value, 	'agmt_act_cnt_cd2');
	setDiffCheckColor(formObj.agmt_act_cust_seq.value, 		formObj.agmt_act_cust_seq2.value, 	'agmt_act_cust_seq2');
}

function dataCopy() {
	ComBtnColor("btn_cancelcopydata", "#737373");
	ComBtnColor("btn_datacopytoalps", "blue");	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function setCopyFlag(flag){
	isCopy = flag;
}

function resetAlpsCustomer(formObj){
	var eSvc = 0;
	var alps = 1;
	var tbl = new Array(
			// Shipper
			new Array ("sh_cust_cnt_cd2",		"sh_cust_cnt_cd"),
			new Array ("sh_cust_seq2", 			"sh_cust_seq"),
			new Array ("sh_cust_lgl_eng_nm2", 	"sh_cust_lgl_eng_nm"),
			new Array ("sh_cust_nm2", 			"sh_cust_nm"),
			new Array ("sh_cust_addr2", 		"sh_cust_addr"),
			new Array ("sh_cust_cty_nm2", 		"sh_cust_cty_nm"),
			new Array ("sh_cust_ste_cd2", 		"sh_cust_ste_cd"),
			new Array ("sh_cstms_decl_cnt_cd2", "sh_cstms_decl_cnt_cd"),
			new Array ("sh_cust_zip_id2", 		"sh_cust_zip_id"),
			new Array ("sh_cust_fax_no2", 		"sh_cust_fax_no"),
			new Array ("sh_cust_eml2", 			"sh_cust_eml"),
			new Array ("sh_cust_phn_no2", 		"sh_cust_phn_no"),
			// Consignee
			new Array ("cn_cust_cnt_cd2", 		"cn_cust_cnt_cd"),
			new Array ("cn_cust_seq2", 			"cn_cust_seq"),
			new Array ("cn_cust_lgl_eng_nm2",	"cn_cust_lgl_eng_nm"),
			new Array ("cn_cust_nm2", 			"cn_cust_nm"),
			new Array ("cn_cust_addr2", 		"cn_cust_addr"),
			new Array ("cn_cust_cty_nm2", 		"cn_cust_cty_nm"),
			new Array ("cn_cust_ste_cd2", 		"cn_cust_ste_cd"),
			new Array ("cn_cstms_decl_cnt_cd2", "cn_cstms_decl_cnt_cd"),
			new Array ("cn_cust_zip_id2", 		"cn_cust_zip_id"),
			new Array ("cn_cust_fax_no2", 		"cn_cust_fax_no"),
			new Array ("cn_cust_eml2", 			"cn_cust_eml"),
			new Array ("cn_cust_phn_no2", 		"cn_cust_phn_no"),
			// Notify
			new Array ("nf_cust_cnt_cd2", 		"nf_cust_cnt_cd"),
			new Array ("nf_cust_seq2", 			"nf_cust_seq"),
			new Array ("nf_cust_lgl_eng_nm2", 	"nf_cust_lgl_eng_nm"),
			new Array ("nf_cust_nm2", 			"nf_cust_nm"),
			new Array ("nf_cust_addr2", 		"nf_cust_addr"),
			new Array ("nf_cust_cty_nm2", 		"nf_cust_cty_nm"),
			new Array ("nf_cust_ste_cd2", 		"nf_cust_ste_cd"),
			new Array ("nf_cstms_decl_cnt_cd2", "nf_cstms_decl_cnt_cd"),
			new Array ("nf_cust_zip_id2", 		"nf_cust_zip_id"),
			new Array ("nf_cust_fax_no2", 		"nf_cust_fax_no"),
			new Array ("nf_cust_eml2", 			"nf_cust_eml"),
			new Array ("nf_cust_phn_no2", 		"nf_cust_phn_no"),
			// Freight Forwarder
			new Array ("ff_cust_cnt_cd2", 		"ff_cust_cnt_cd"),
			new Array ("ff_cust_seq2", 			"ff_cust_seq"),
			new Array ("ff_cust_lgl_eng_nm2", 	"ff_cust_lgl_eng_nm"),
			new Array ("ff_cust_nm2", 			"ff_cust_nm"),
			// Also Notify
			new Array ("an_cust_cnt_cd2", 		"an_cust_cnt_cd"),
			new Array ("an_cust_seq2",			"an_cust_seq"),
			new Array ("an_cust_lgl_eng_nm2", 	"an_cust_lgl_eng_nm"),
			new Array ("an_cust_nm2", 			"an_cust_nm"),
			// Export Ref No
			new Array ("ex_cust_nm2", 			"ex_cust_nm"),
			// Broker
			new Array ("br_cust_cnt_cd2", 		"br_cust_cnt_cd"),
			new Array ("br_cust_nm2", 			"br_cust_nm"),
			new Array ("br_cust_addr2", 		"br_cust_addr"),
			
			new Array ("agmt_act_cnt_cd2", 		"agmt_act_cnt_cd"),
			new Array ("agmt_act_cust_seq2", 	"agmt_act_cust_seq")
			);

	// alps쪽 data를 지움 
	
	var tblLen =  tbl.length;
	for (i= 0; i < tblLen; i++) {
		var alpsElem = document.getElementsByName(tbl[i][alps])[0];
		alpsElem.value = "";
	}
	
	//print flag는 default로 켜줌
	ComSetObjValue(formObj.sh_addr_prn_flg, "Y");
	ComSetObjValue(formObj.cn_addr_prn_flg, "Y");
	ComSetObjValue(formObj.nf_addr_prn_flg, "Y");
	ComSetObjValue(formObj.ff_addr_prn_flg, "Y");
	ComSetObjValue(formObj.an_addr_prn_flg, "Y");
	ComSetObjValue(formObj.ex_addr_prn_flg, "Y");
	
	formObj.kr_cstms_cust_tp_cd.value = "";
	formObj.bl_tp_cd.value = "";
	formObj.kr_cstms_cust_tp_cd.value = "";
}

/*
 * Shipper : 구주 24 신고 대상이고, Shipper Country code가 'KR'인 경우 상세 주소란의 Country를 'KR'로 Default Setting 
 */
function checkEu24ForKr(formObj) {
	if(formObj.sh_cust_cnt_cd.value == 'KR') {
		formObj.sh_cstms_decl_cnt_cd.value = 'KR';
	}
}

function customerSearchEnd(formObj){	
	/*Booking DEL 이 있고, Consignee 가 없으면, Consingnee 와 Notify 국가코드에 DEL 2자리값을 넣어줌. 2010.1.15 전창현 */
	var delCd = parent.document.frames("t1frame").form.bkg_del_cd.value;
	var podCd = parent.document.frames("t1frame").form.bkg_pod_cd.value;
	var polCd = parent.document.frames("t1frame").form.bkg_pol_cd.value;
	
	if(ComIsNull(formObj.cn_cust_cnt_cd.value) && !ComIsNull(delCd)){
		ComSetObjValue(formObj.cn_cust_cnt_cd, delCd.substring(0,2));
	}	

	if(ComIsNull(formObj.nf_cust_cnt_cd.value) && !ComIsNull(delCd)){
		ComSetObjValue(formObj.nf_cust_cnt_cd, delCd.substring(0,2));
	}
	
	if(formObj.sender_id.value != "WEB"){
		if( ComIsNull(formObj.kr_cstms_cust_tp_cd) ){
			if(formObj.sh_cust_tp.value == "B"){
				formObj.kr_cstms_cust_tp_cd.value = "S";
			}else{
				formObj.kr_cstms_cust_tp_cd.value = "C";
			}
		}
	}

	// CA Manifest Flag 셋팅
	var frobFlag = ComGetObjValue(formObj.frob_flag);
	//var polCd = ComGetObjValue(formObj.pol_cd);
	//var podCd = ComGetObjValue(formObj.pod_cd);
	//var delCd = ComGetObjValue(formObj.del_cd);
	
	if(polCd.substring(0,2) != "CA"){
		if(podCd.substring(0,2) == "CA" || delCd.substring(0,2) == "CA" || frobFlag == "Y"){
			formObj.ca_manifest_flag.value = "Y";
		}else{
			formObj.ca_manifest_flag.value = "N";
		}		
	}
	
	// Canada향인 경우 City/State/Country 파란색 처리
//	if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && podCd.substring(0,2) != "US"){
	if(ComGetObjValue(formObj.ca_manifest_flag) == "Y"){
		document.getElementById("sh_cust_cty_nm").className = "input1";
		document.getElementById("sh_cust_ste_cd").className = "input1";
		document.getElementById("sh_cstms_decl_cnt_cd").className = "input1";					
		document.getElementById("cn_cust_cty_nm").className = "input1";
		document.getElementById("cn_cust_ste_cd").className = "input1";
		document.getElementById("cn_cstms_decl_cnt_cd").className = "input1";
		document.getElementById("nf_cust_cty_nm").className = "input1";
		document.getElementById("nf_cust_ste_cd").className = "input1";
		document.getElementById("nf_cstms_decl_cnt_cd").className = "input1";
		//ca 향 default setting
		if(ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
			formObj.sh_cstms_decl_cnt_cd.value = polCd.substring(0, 2);
		}
		if(ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
			formObj.cn_cstms_decl_cnt_cd.value = delCd.substring(0, 2);
		}
		if(ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
			formObj.nf_cstms_decl_cnt_cd.value = delCd.substring(0, 2);
		}
	}else{
		document.getElementById("sh_cust_cty_nm").className = "input";
		document.getElementById("sh_cust_ste_cd").className = "input";
		document.getElementById("sh_cstms_decl_cnt_cd").className = "input";							
		document.getElementById("cn_cust_cty_nm").className = "input";
		document.getElementById("cn_cust_ste_cd").className = "input";
		document.getElementById("cn_cstms_decl_cnt_cd").className = "input";
		document.getElementById("nf_cust_cty_nm").className = "input";
		document.getElementById("nf_cust_ste_cd").className = "input";
		document.getElementById("nf_cstms_decl_cnt_cd").className = "input";					
	}
	
////	 NL Manifest Flag 셋팅
//	if(formObj.nl_flag.value == "Y"){
//		document.getElementById("sh_eur_cstms_st_nm").className = "input1";
//		document.getElementById("sh_eori_no").className = "input1";
//		document.getElementById("sh_cust_cty_nm").className = "input1";
//		document.getElementById("sh_cstms_decl_cnt_cd").className = "input1";		
//		document.getElementById("sh_cust_zip_id").className = "input1";
//		
//		document.getElementById("cn_eur_cstms_st_nm").className = "input1";
//		document.getElementById("cn_eori_no").className = "input1";
//		document.getElementById("cn_cust_cty_nm").className = "input1";
//		document.getElementById("cn_cstms_decl_cnt_cd").className = "input1";		
//		document.getElementById("cn_cust_zip_id").className = "input1";
//		
//		document.getElementById("nf_eur_cstms_st_nm").className = "input1";
//		document.getElementById("nf_eori_no").className = "input1";
//		document.getElementById("nf_cust_cty_nm").className = "input1";
//		document.getElementById("nf_cstms_decl_cnt_cd").className = "input1";		
//		document.getElementById("nf_cust_zip_id").className = "input1";
//	} else {
//			document.getElementById("sh_eur_cstms_st_nm").className = "input";
//			document.getElementById("sh_eori_no").className = "input";
//			document.getElementById("sh_cust_cty_nm").className = "input";
//			document.getElementById("sh_cstms_decl_cnt_cd").className = "input";		
//			document.getElementById("sh_cust_zip_id").className = "input";
//			
//			document.getElementById("cn_eur_cstms_st_nm").className = "input";
//			document.getElementById("cn_eori_no").className = "input";
//			document.getElementById("cn_cust_cty_nm").className = "input";
//			document.getElementById("cn_cstms_decl_cnt_cd").className = "input";		
//			document.getElementById("cn_cust_zip_id").className = "input";
//			
//			document.getElementById("nf_eur_cstms_st_nm").className = "input";
//			document.getElementById("nf_eori_no").className = "input";
//			document.getElementById("nf_cust_cty_nm").className = "input";
//			document.getElementById("nf_cstms_decl_cnt_cd").className = "input";		
//			document.getElementById("nf_cust_zip_id").className = "input";		
//	}
	
	formObj.same_as_flag.value = "N";
	// uncheck로 표시
	formObj.sam_cnee_ntfy_flg.value = 'N';
	
//	//shipper, forwarder code가 없을 경우 booking tab에서 가져옴
//	if(ComIsNull(formObj.sh_cust_cnt_cd.value) && ComIsNull(formObj.sh_cust_seq.value) && formObj.sh_cust_seq.value != "0"){
//		if(!ComIsNull(formObj.sh_cust_cnt_cd2.value) && !ComIsNull(formObj.sh_cust_seq2.value) && formObj.sh_cust_seq2.value != "0"){
//			formObj.sh_cust_cnt_cd.value = formObj.sh_cust_cnt_cd2.value;
//			formObj.sh_cust_seq.value = formObj.sh_cust_seq2.value;
//		}
//	}
//	if(ComIsNull(formObj.ff_cust_cnt_cd.value) && ComIsNull(formObj.ff_cust_seq.value) && formObj.ff_cust_seq.value != "0"){
//		if(!ComIsNull(formObj.ff_cust_cnt_cd2.value) && !ComIsNull(formObj.ff_cust_seq2.value) && formObj.ff_cust_seq2.value != "0"){
//			formObj.ff_cust_cnt_cd.value = formObj.ff_cust_cnt_cd2.value;
//			formObj.ff_cust_seq.value = formObj.ff_cust_seq2.value;
//		}
//	}
}


/**
 * CustCntCd와 CustSeq로 MdmCustomer의 CustNm을 조회하여 화면에 출력한다.
 */
function searchMdmCustNm(sheetObject, formObj, custTp, custCntCd, custSeq){
	ComSetObjValue(formObj.f_cmd,SEARCHLIST11);
	var sXml = sheetObject.GetSearchXml("ESM_BKG_0079_05GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq, FormQueryString(formObj));
	var custNm = ComGetEtcData(sXml,"cust_nm");
	var custAddr = ComGetEtcData(sXml,"cust_addr");
	var custTpCd = ComGetEtcData(sXml,"rvis_cntr_cust_tp_cd");
	var fmcNo = ComGetEtcData(sXml,"frt_fwrd_fmc_no");
	var idaGstRgstNo = ComGetEtcData(sXml,"ida_gst_rgst_no");
	var coChnNo = ComGetEtcData(sXml,"co_chn_no");
	
	if ("SH"==custTp) {
		ComSetObjValue(formObj.sh_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.sh_mdm_address, custAddr ? custAddr : "");
		ComSetObjValue(formObj.sh_ida_gst_rgst_no, idaGstRgstNo ? idaGstRgstNo : "");
		ComSetObjValue(formObj.sh_co_chn_no, coChnNo ? coChnNo : "");
		formObj.kr_cstms_cust_tp_cd.Code = "B"==custTpCd ? "S" : "C";
		
		if(ComGetObjValue(formObj.sh_cust_cnt_cd) == "KR"
				&& (Number(ComGetObjValue(formObj.sh_cust_seq)) == 695 || Number(ComGetObjValue(formObj.sh_cust_seq)) == 37635)){
			formObj.kr_cstms_cust_tp_cd.Code = "C";
		}
	} else if ("CN"==custTp) {
		ComSetObjValue(formObj.cn_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.cn_mdm_address, custAddr ? custAddr : "");
		ComSetObjValue(formObj.cn_ida_gst_rgst_no, idaGstRgstNo ? idaGstRgstNo : "");
		ComSetObjValue(formObj.cn_co_chn_no, coChnNo ? coChnNo : "");
	} else if ("NF"==custTp) {
		ComSetObjValue(formObj.nf_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.nf_mdm_address, custAddr ? custAddr : "");
		ComSetObjValue(formObj.nf_ida_gst_rgst_no, idaGstRgstNo ? idaGstRgstNo : "");
		ComSetObjValue(formObj.nf_co_chn_no, coChnNo ? coChnNo : "");
	} else if ("EX"==custTp) {
		ComSetObjValue(formObj.ex_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.ex_mdm_address, custAddr ? custAddr : "");
	} else if ("FF"==custTp) {
		ComSetObjValue(formObj.ff_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.ff_mdm_address, custAddr ? custAddr : "");
		ComSetObjValue(formObj.fmc_cd, fmcNo ? fmcNo : "");
	} else if ("AN"==custTp) {
		ComSetObjValue(formObj.an_cust_lgl_eng_nm, custNm ? custNm : "");
		ComSetObjValue(formObj.an_mdm_address, custAddr ? custAddr : "");
	}
	//2013508 최문환 추가
	if(ComGetEtcData(sXml,"cust_nm")!=""){
		if(ComGetEtcData(sXml,"blk_lst_flg")=="YES"){
			var rlse_ctrl_rsn = ComGetEtcData(sXml, "rlse_ctrl_rsn");
			var ar_ofc        = ComGetEtcData(sXml, "ar_ofc");
			var srep_nm       = ComGetEtcData(sXml, "srep_nm");
			ComShowCodeMessage("BKG00055", rlse_ctrl_rsn, ar_ofc, srep_nm);
		}
	}
}

/**
 * 대소분자 구분없이 특정 문자열 포함여부 확인하는 함수
 *
 * @param 	obj, chars  <br>
 * @returns 	boolean <br>
 * @author	KimByungKyu
 */     
function BkgIsContainsChars(obj,chars) {
	try {
        //첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
        var sVal = getArgValue(obj);
        sVal = sVal.toUpperCase();
         
        chars = chars.toUpperCase();
         
        if(sVal.indexOf(chars) != -1){
        	return true;
        }
        return false;
    } catch(err) { ComFuncErrMsg(err.message); }
}     

 /**
 * 대소분자 구분없이 특정 문자열만큼 데이터 추출
 *
 * @param 	obj, startIdx, endIdx  <br>
 * @returns 	boolean <br>
 * @author	KimByungKyu
 */        
function BkgGetCharsLen(obj, startIdx, endIdx, chkLen){
	try {        
    	var sVal = getArgValue(obj);
        sVal = sVal.toUpperCase();
        
        if(sVal.length > chkLen){
        	sVal = sVal.substring(startIdx, endIdx);
        }
        return sVal;
    } catch(err) { ComFuncErrMsg(err.message); }
}     
 
function getMakeBrData(dataNm, dataValue){
 	var rtnValue = "";
 	if(dataValue != null && dataValue.length > 0){
 		if(dataNm == "NAME"){
 			if(dataValue.length > 35){
 				rtnValue = dataValue.substring(0,35) + "\n" + dataValue.substring(35);
 			}else{
 				rtnValue = dataValue;
 			}			 
 		}else if(dataNm == "ADDR"){
 			if(dataValue.length > 70){
 				rtnValue = dataValue.substring(0,35) + "\n" + dataValue.substring(35,70) + "\n" + dataValue.substring(70);
 			}else if(dataValue.length > 35){
 				rtnValue = dataValue.substring(0,35) + "\n" + dataValue.substring(35);
 			}else{
 				rtnValue = dataValue;
 			}				
 		}			 
 	}else{
 		rtnValue = "";
 	}
 	return rtnValue.toUpperCase();		 
}

function replaceAll(str, orgStr, repStr){
	return str.split(orgStr).join(repStr); 
}

function form_keypress() {
	var srcName = window.event.srcElement.getAttribute("name");
	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    switch(event.srcElement.dataformat){
    	case "engup":
    		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
    		ComKeyOnlyAlphabet('uppernum');
    		break;
    	case "int":
    	  	//숫자 입력하기
    	  	ComKeyOnlyNumber(event.srcElement);
        break;	      
     	case "zipcode":
     		//숫자 입력하기
     		ComKeyOnlyAlphabet('uppernum','45|32');
        break;	            
     	case "etc": //모든 문자 가능하지만 영문은 대문자로
     		if(keyValue >= 97 && keyValue <= 122) {//소문자
     			event.keyCode = keyValue + 65 - 97;
     		}
    	break;	        
     	default:
    }
}

/**
* 마우스 아웃일때 
*/
function form_deactivate() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	
	var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
	if (srcName == "sh_eori_no") {
		var str = formObj.sh_eori_no.value;
		if (regExp.test(str)) {
			var t = str.replace(regExp, "");
			formObj.sh_eori_no.value = t;
		}
	} else if (srcName == "cn_eori_no") {
		var str = formObj.cn_eori_no.value;
		if (regExp.test(str)) {
			var t = str.replace(regExp, "");
			formObj.cn_eori_no.value = t;
		}
	} else if (srcName == "nf_eori_no") {
		var str = formObj.nf_eori_no.value;
		if (regExp.test(str)) {
			var t = str.replace(regExp, "");
			formObj.nf_eori_no.value = t;
		}
	}

//	if(srcName == "agmt_act_cust_seq"){
//		formObj.agmt_act_cust_seq.value = ComLpad(srcValue,6,"0");   
//	}else if(srcName == "sh_cust_cnt_cd"){		
//		if(ComIsNull(srcValue)){
//			formObj.sh_cust_lgl_eng_nm.value = "";			
//		} else {
//			if(ComChkLen(srcValue, srcMaxLength) == "2" && srcValue == "KR"){
//				if(rArray2[1] == "KR"){
//					document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled=false;
//				}else{
//					document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled=false;
//				} 	
//			}
//		}
//	}else if(srcName == "sh_cust_seq"){    		
//		if(ComIsNull(srcValue)){
//			formObj.sh_cust_lgl_eng_nm.value = "";
//		}else{
//			formObj.sh_cust_seq.value = ComLpad(srcValue,6,"0");   
//		}
//	}else if(srcName == "cn_cust_cnt_cd"){		
//		if(ComIsNull(srcValue)){
//			formObj.cn_cust_lgl_eng_nm.value = "";			
//		}
//	}else if(srcName == "cn_cust_seq"){    		
//		if(ComIsNull(srcValue)){
//			formObj.cn_cust_lgl_eng_nm.value = "";
//		}else{
//			formObj.cn_cust_seq.value = ComLpad(srcValue,6,"0");    
//		}   		
//	}else if(srcName == "nf_cust_cnt_cd"){		
//		if(ComIsNull(srcValue)){
//			formObj.nf_cust_lgl_eng_nm.value = "";			
//		}
//	}else if(srcName == "nf_cust_seq"){
//		if(ComIsNull(srcValue)){
//			formObj.nf_cust_lgl_eng_nm.value = "";
//		}else{
//			formObj.nf_cust_seq.value = ComLpad(srcValue,6,"0");   
//		}      			
//	}else if(srcName == "ff_cust_cnt_cd"){		
//		if(ComIsNull(srcValue)){
//			formObj.ff_cust_lgl_eng_nm.value = "";			
//		}
//	}else if(srcName == "ff_cust_seq"){
//		if(ComIsNull(srcValue)){
//			formObj.ff_cust_lgl_eng_nm.value = "";
//		}else{
//			formObj.ff_cust_seq.value = ComLpad(srcValue,6,"0");    
//		}      				}
//	else if(srcName == "an_cust_cnt_cd"){		
//		if(ComIsNull(srcValue)){
//			formObj.an_cust_lgl_eng_nm.value = "";			
//		}
//	}else if(srcName == "an_cust_seq"){
//		if(ComIsNull(srcValue)){
//			formObj.an_cust_lgl_eng_nm.value = "";
//		}else{
//			formObj.an_cust_seq.value = ComLpad(srcValue,6,"0");   
//		}       			
//	}
}	

function form_click(){
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");

	if(srcName == "sam_cnee_copy_flg"){
		if(formObj.sam_cnee_copy_flg.checked){
			if(!ComIsNull(formObj.nf_cust_nm.value) || !ComIsNull(formObj.nf_cust_addr.value)){
				if(ComShowCodeConfirm("BKG00343")){
					ComSetObjValue(formObj.nf_cust_nm,ComGetObjValue(formObj.cn_cust_nm));
					ComSetObjValue(formObj.nf_cust_addr,ComGetObjValue(formObj.cn_cust_addr));
					ComSetObjValue(formObj.nf_cust_cty_nm,ComGetObjValue(formObj.cn_cust_cty_nm));
					ComSetObjValue(formObj.nf_cust_ste_cd,ComGetObjValue(formObj.cn_cust_ste_cd));
					ComSetObjValue(formObj.nf_cstms_decl_cnt_cd,ComGetObjValue(formObj.cn_cstms_decl_cnt_cd));
					ComSetObjValue(formObj.nf_cust_zip_id,ComGetObjValue(formObj.cn_cust_zip_id));
					ComSetObjValue(formObj.nf_cust_fax_no,ComGetObjValue(formObj.cn_cust_fax_no));
					ComSetObjValue(formObj.nf_cust_eml,ComGetObjValue(formObj.cn_cust_eml));						
				}  			    				
			}else{
				ComSetObjValue(formObj.nf_cust_nm,ComGetObjValue(formObj.cn_cust_nm));
				ComSetObjValue(formObj.nf_cust_addr,ComGetObjValue(formObj.cn_cust_addr));
				ComSetObjValue(formObj.nf_cust_cty_nm,ComGetObjValue(formObj.cn_cust_cty_nm));
				ComSetObjValue(formObj.nf_cust_ste_cd,ComGetObjValue(formObj.cn_cust_ste_cd));
				ComSetObjValue(formObj.nf_cstms_decl_cnt_cd,ComGetObjValue(formObj.cn_cstms_decl_cnt_cd));
				ComSetObjValue(formObj.nf_cust_zip_id,ComGetObjValue(formObj.cn_cust_zip_id));
				ComSetObjValue(formObj.nf_cust_fax_no,ComGetObjValue(formObj.cn_cust_fax_no));
				ComSetObjValue(formObj.nf_cust_eml,ComGetObjValue(formObj.cn_cust_eml));					
			}
		}   		
	}
}

function form_onChange() {
	var srcName = window.event.srcElement.getAttribute("name");
	var formObj = document.form;
	
	// 2018.05.25 iylee Form Change 일때 소문자 -> 대문자로 바꾸어줌.
	ComSetUpperChange(srcName, event.srcElement.value);
	
	switch (srcName) {
		case "agmt_act_cust_seq" :
			formObj.agmt_act_cust_seq.value = ComLpad(formObj.agmt_act_cust_seq.value,6,"0");   
		break;
		case "sh_cust_cnt_cd" :
			if (ComChkLen(formObj.sh_cust_cnt_cd.value, 2) == "2"  && formObj.sh_cust_cnt_cd.value=='KR') {
				formObj.sh_cstms_decl_cnt_cd.value = formObj.sh_cust_cnt_cd.value;
			}
			if(ComGetObjValue(formObj.sh_cust_cnt_cd) == "KR"
					&& (Number(ComGetObjValue(formObj.sh_cust_seq)) == 695 || Number(ComGetObjValue(formObj.sh_cust_seq)) == 37635)){
				formObj.kr_cstms_cust_tp_cd.Code = "C";
			}
		case "sh_cust_seq" :
			if (ComChkLen(formObj.sh_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.sh_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "SH", formObj.sh_cust_cnt_cd.value, formObj.sh_cust_seq.value);
				formObj.sh_cust_seq.value = ComLpad(formObj.sh_cust_seq.value,6,"0");  
			}
		break;
		case "ff_cust_cnt_cd" :
		case "ff_cust_seq" :
			if (ComChkLen(formObj.ff_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.ff_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "FF", formObj.ff_cust_cnt_cd.value, formObj.ff_cust_seq.value);
				formObj.ff_cust_seq.value = ComLpad(formObj.ff_cust_seq.value,6,"0");  
			}
		break;
		case "cn_cust_cnt_cd" :
		case "cn_cust_seq" :
			if (ComChkLen(formObj.cn_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.cn_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "CN", formObj.cn_cust_cnt_cd.value, formObj.cn_cust_seq.value);
				formObj.cn_cust_seq.value = ComLpad(formObj.cn_cust_seq.value,6,"0");  
			}
		break;
		case "nf_cust_cnt_cd" :
		case "nf_cust_seq" :
			if (ComChkLen(formObj.nf_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.nf_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "NF", formObj.nf_cust_cnt_cd.value, formObj.nf_cust_seq.value);
				formObj.nf_cust_seq.value = ComLpad(formObj.nf_cust_seq.value,6,"0");  
			}
		break;
		case "an_cust_cnt_cd" :
		case "an_cust_seq" :
			if (ComChkLen(formObj.an_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.an_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "AN", formObj.an_cust_cnt_cd.value, formObj.an_cust_seq.value);
				formObj.an_cust_seq.value = ComLpad(formObj.an_cust_seq.value,6,"0");  
			}
		break;
		case "ex_cust_cnt_cd" :
		case "ex_cust_seq" :
			if (ComChkLen(formObj.ex_cust_cnt_cd.value, 2) == "2" && parseInt(formObj.ex_cust_seq.value) > 0) {
				searchMdmCustNm(sheetObjects[0], formObj, "EX", formObj.ex_cust_cnt_cd.value, formObj.ex_cust_seq.value);
				formObj.ex_cust_seq.value = ComLpad(formObj.ex_cust_seq.value,6,"0");  
			}
		break;		
		case "cn_cust_zip_id":
			if( ComChkLen(formObj.cn_cust_cnt_cd.value,2 )==2 &&  formObj.cn_cust_cnt_cd.value =='DE' ) {
				if((!ComIsEmpty(formObj.cn_cust_zip_id.value) && !ComIsNumber(formObj.cn_cust_zip_id.value) ) || 
						(!ComIsEmpty(formObj.cn_cust_zip_id.value) &&  formObj.cn_cust_zip_id.value.length  < 5) ) {
					ComShowCodeMessage("BKG02077");
				}
			}
				
		break;
		case "nf_cust_zip_id":
			if( ComChkLen(formObj.nf_cust_cnt_cd.value,2 )==2 &&  formObj.nf_cust_cnt_cd.value =='DE' ) {
				if((!ComIsEmpty(formObj.nf_cust_zip_id.value) && !ComIsNumber(formObj.nf_cust_zip_id.value)) ||
						(!ComIsEmpty(formObj.nf_cust_zip_id.value) &&  formObj.nf_cust_zip_id.value.length < 5)) {
					ComShowCodeMessage("BKG02077");
				}
			}
				
		break;
		
	}
	isCopy="false";
	customerDataDiffCheck(formObj);
	return true;
}

/**
 * Actual Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackSa0190(rArray);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
 
function callBackSa0190(rArray){    	
	var formObj = document.form;
	if(rArray != null){
		ComSetObjValue(formObj.agmt_act_cnt_cd, rArray[0][0]);
		ComSetObjValue(formObj.agmt_act_cust_seq, ComLpad(rArray[0][1],6,"0"));
	}
	displayDeleteButtonOfAcualCustomer();  // Actual Customer Delete Button ... 2011.05.19
} 

/**
 * B/L Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackSh0192(rArray, rArray2);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 전창현
 * @version 2010.01.15
 */
function callBackSh0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
  		if (!ComIsNull(formObj.sh_cust_nm) || !ComIsNull(formObj.sh_cust_addr)) {
  			if (!ComShowCodeConfirm("BKG00343")) return;
  		}
		document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled = false;
  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray2[1]);
  		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray2[2],6,"0"));
  		if (!ComIsEmpty(rArray2[6]) && ComIsEmpty(formObj.sh_cust_nm)) {
			ComSetObjValue(formObj.sh_cust_nm          , getMakeBrData("NAME",rArray2[6]) + "\n");
  		}
  		if (!ComIsEmpty(rArray2[7]) && ComIsEmpty(formObj.sh_cust_addr)) {
			ComSetObjValue(formObj.sh_cust_addr        , replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  		}
  		ComSetObjValue(formObj.sh_cust_cty_nm      , rArray2[11]);  //City
  		ComSetObjValue(formObj.sh_cust_ste_cd      , rArray2[13]);  //State
  		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray2[14]);  //Country
  		ComSetObjValue(formObj.sh_cust_zip_id      , rArray2[15]);  //ZIP Code
  		ComSetObjValue(formObj.sh_eur_cstms_st_nm  , rArray2[17]);  //Street / P.O.Box
  		ComSetObjValue(formObj.sh_eori_no          , rArray2[18]);  //EORI#
		searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray2[1],rArray2[2]);
	} else {
		document.getElementsByName("kr_cstms_cust_tp_cd")[0].disabled = false;
  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray[0]);
		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray[0],rArray[1]);
		var arr = [formObj.sh_cust_cty_nm,
		           formObj.sh_cust_ste_cd,
		           formObj.sh_cstms_decl_cnt_cd,
		           formObj.sh_cust_zip_id,
		           formObj.sh_eur_cstms_st_nm,
		           formObj.sh_eori_no];
		if (isCustUpdate(arr)) {
  			ComSetObjValue(formObj.sh_cust_cty_nm, rArray[10]);  //City
  			ComSetObjValue(formObj.sh_cust_ste_cd, rArray[12]);  //State
  			ComSetObjValue(formObj.sh_cust_zip_id, rArray[14]);  //ZIP Code
		}
	}
}

/**
 * B/L Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackCn0192(rArray, rArray2);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 전창현
 * @version 2010.01.15
 */
function callBackCn0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
  		if (!ComIsNull(formObj.cn_cust_nm) || !ComIsNull(formObj.cn_cust_addr)) {
  			if (!ComShowCodeConfirm("BKG00343")) return;
  		}
  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray2[1]);
  		ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray2[2],6,"0"));
  		if (!ComIsEmpty(rArray2[6]) && ComIsEmpty(formObj.cn_cust_nm)) {
  			ComSetObjValue(formObj.cn_cust_nm          , getMakeBrData("NAME",rArray2[6]) + "\n");
  		}
  		if (!ComIsEmpty(rArray2[7]) && ComIsEmpty(formObj.cn_cust_addr)) {
  			ComSetObjValue(formObj.cn_cust_addr        , replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  		}
  		ComSetObjValue(formObj.cn_cust_cty_nm      , rArray2[11]);  //City
  		ComSetObjValue(formObj.cn_cust_ste_cd      , rArray2[13]);  //State
  		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray2[14]);  //Country
  		ComSetObjValue(formObj.cn_cust_zip_id      , rArray2[15]);  //ZIP Code
  		ComSetObjValue(formObj.cn_eur_cstms_st_nm  , rArray2[17]);  //Street / P.O.Box
  		ComSetObjValue(formObj.cn_eori_no          , rArray2[18]);  //EORI#
  		ComSetObjValue(formObj.cn_cust_fax_no      , rArray2[9]);   //Fax
  		ComSetObjValue(formObj.cn_cust_eml         , rArray2[16]);  //E-mail
		searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray2[1],rArray2[2]);
	} else {
  		ComSetObjValue(formObj.cn_cust_cnt_cd      , rArray[0]);
		ComSetObjValue(formObj.cn_cust_seq         , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"CN",rArray[0],rArray[1]);
		var arr = [formObj.cn_cust_cty_nm,
		  		   formObj.cn_cust_ste_cd,
		  		   formObj.cn_cstms_decl_cnt_cd,
		  		   formObj.cn_cust_zip_id,
		  		   formObj.cn_eur_cstms_st_nm,
		  		   formObj.cn_eori_no,
		  		   formObj.cn_cust_fax_no,
		  		   formObj.cn_cust_eml];
		if (isCustUpdate(arr)) {
  			ComSetObjValue(formObj.cn_cust_cty_nm, rArray[10]);  //City
  			ComSetObjValue(formObj.cn_cust_ste_cd, rArray[12]);  //State
  			ComSetObjValue(formObj.cn_cust_zip_id, rArray[14]);  //ZIP Code
		}
	}
}

/**
* B/L Customer 에서 전달받은 값 저장 <br>
* <br><b>Example :</b>
* <pre>
*     callBackNf0192(rArray, rArray2);
* </pre>
* @param Popup에서 전달받은 값
* @return 없음
* @author 전창현
* @version 2010.01.15
*/
function callBackNf0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
		if (!ComIsNull(formObj.nf_cust_nm) || !ComIsNull(formObj.nf_cust_addr)) {
			if (!ComShowCodeConfirm("BKG00343")) return;
		}
		ComSetObjValue(formObj.nf_cust_cnt_cd      , rArray2[1]);
		ComSetObjValue(formObj.nf_cust_seq         , ComLpad(rArray2[2],6,"0"));
  		if (!ComIsEmpty(rArray2[6]) && ComIsEmpty(formObj.nf_cust_nm)) {
  			ComSetObjValue(formObj.nf_cust_nm          , getMakeBrData("NAME",rArray2[6]) + "\n");
  		}
  		if (!ComIsEmpty(rArray2[7]) && ComIsEmpty(formObj.nf_cust_addr)) {
  			ComSetObjValue(formObj.nf_cust_addr        , replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  		}
		ComSetObjValue(formObj.nf_cust_cty_nm      , rArray2[11]);  //City
		ComSetObjValue(formObj.nf_cust_ste_cd      , rArray2[13]);  //State
		ComSetObjValue(formObj.nf_cstms_decl_cnt_cd, rArray2[14]);  //Country
		ComSetObjValue(formObj.nf_cust_zip_id      , rArray2[15]);  //ZIP Code
		ComSetObjValue(formObj.nf_eur_cstms_st_nm  , rArray2[17]);  //Street / P.O.Box
		ComSetObjValue(formObj.nf_eori_no          , rArray2[18]);  //EORI#
		ComSetObjValue(formObj.nf_cust_fax_no      , rArray2[9]);   //Fax
		ComSetObjValue(formObj.nf_cust_eml         , rArray2[16]);  //E-mail
		searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray2[1],rArray2[2]);
	} else {
		ComSetObjValue(formObj.nf_cust_cnt_cd      , rArray[0]);
		ComSetObjValue(formObj.nf_cust_seq         , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"NF",rArray[0],rArray[1]);
		var arr = [formObj.nf_cust_cty_nm,
		           formObj.nf_cust_ste_cd,
		           formObj.nf_cstms_decl_cnt_cd,
		           formObj.nf_cust_zip_id,
		           formObj.nf_eur_cstms_st_nm,
		           formObj.nf_eori_no,
		           formObj.nf_cust_fax_no,
		           formObj.nf_cust_eml];
		if (isCustUpdate(arr)) {
  			ComSetObjValue(formObj.nf_cust_cty_nm, rArray[10]);  //City
  			ComSetObjValue(formObj.nf_cust_ste_cd, rArray[12]);  //State
  			ComSetObjValue(formObj.nf_cust_zip_id, rArray[14]);  //ZIP Code
		}
	}
}

/**
 * B/L Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackFf0192(rArray, rArray2);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 전창현
 * @version 2010.01.15
 */
function callBackFf0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
		if (!ComIsNull(formObj.ff_cust_nm)) {
			if (!ComShowCodeConfirm("BKG00343")) return;
		}
		ComSetObjValue(formObj.ff_cust_cnt_cd, rArray2[1]);
		ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray2[2],6,"0"));
  		if ((!ComIsEmpty(rArray2[6]) || !ComIsEmpty(rArray2[7])) && ComIsEmpty(formObj.ff_cust_nm)) {
			ComSetObjValue(formObj.ff_cust_nm    , getMakeBrData("NAME",rArray2[6]) + "\n" 
												 + replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  		}
		searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray2[1],rArray2[2]);
	} else {
		ComSetObjValue(formObj.ff_cust_cnt_cd, rArray[0]);
		ComSetObjValue(formObj.ff_cust_seq   , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"FF",rArray[0],rArray[1]);
	}
}

/**
 * B/L Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackAn0192(rArray, rArray2);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 전창현
 * @version 2010.01.15
 */
function callBackAn0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
		if (!ComIsNull(formObj.an_cust_nm)) {
			if (!ComShowCodeConfirm("BKG00343")) return;
		}
		ComSetObjValue(formObj.an_cust_cnt_cd, rArray2[1]);
		ComSetObjValue(formObj.an_cust_seq   , ComLpad(rArray2[2],6,"0"));
  		if ((!ComIsEmpty(rArray2[6]) || !ComIsEmpty(rArray2[7])) && ComIsEmpty(formObj.an_cust_nm)) {
			ComSetObjValue(formObj.an_cust_nm    , getMakeBrData("NAME",rArray2[6]) + "\n" 
												 + replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  		}
		searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray2[1],rArray2[2]);
	} else {
		ComSetObjValue(formObj.an_cust_cnt_cd, rArray[0]);
		ComSetObjValue(formObj.an_cust_seq   , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray[0],rArray[1]);
	}
}

 /**
  * Zip Code 에서 전달받은 값 저장 (Shipper)<br>
  * <br><b>Example :</b>
  * <pre>
  *     callBackShZipCode(rArray);
  * </pre>
  * @param Popup에서 전달받은 값
  * @return 없음
  * @author 이인영
  * @version 2010.12.27
  */
  
 function callBackShZipCode(rArray){
 	var formObj = document.form;

 	if(rArray != null){
 		ComSetObjValue(formObj.sh_cust_cty_nm, rArray[0]);
 		ComSetObjValue(formObj.sh_cust_ste_cd, rArray[1]);
 		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray[2]);
 		ComSetObjValue(formObj.sh_cust_zip_id, rArray[3]);
 		ComSetObjValue(formObj.sh_eur_cstms_st_nm, rArray[4]); 		
 	}
 } 
 
 /**
  * Zip Code 에서 전달받은 값 저장 (Consignee)<br>
  * <br><b>Example :</b>
  * <pre>
  *     callBackShZipCode(rArray);
  * </pre>
  * @param Popup에서 전달받은 값
  * @return 없음
  * @author 이인영
  * @version 2010.12.27
  */
  
 function callBackCnZipCode(rArray){
 	var formObj = document.form;

 	if(rArray != null){
 		ComSetObjValue(formObj.cn_cust_cty_nm, rArray[0]);
 		ComSetObjValue(formObj.cn_cust_ste_cd, rArray[1]);
 		ComSetObjValue(formObj.cn_cstms_decl_cnt_cd, rArray[2]);
 		ComSetObjValue(formObj.cn_cust_zip_id, rArray[3]);
 		ComSetObjValue(formObj.cn_eur_cstms_st_nm, rArray[4]); 		
 	}
 } 
 
 /**
  * Zip Code 에서 전달받은 값 저장 (Notify)<br>
  * <br><b>Example :</b>
  * <pre>
  *     callBackShZipCode(rArray);
  * </pre>
  * @param Popup에서 전달받은 값
  * @return 없음
  * @author 이인영
  * @version 2010.12.27
  */
  
 function callBackNfZipCode(rArray){
 	var formObj = document.form;

 	if(rArray != null){
 		ComSetObjValue(formObj.nf_cust_cty_nm, rArray[0]);
 		ComSetObjValue(formObj.nf_cust_ste_cd, rArray[1]);
 		ComSetObjValue(formObj.nf_cstms_decl_cnt_cd, rArray[2]);
 		ComSetObjValue(formObj.nf_cust_zip_id, rArray[3]);
 		ComSetObjValue(formObj.nf_eur_cstms_st_nm, rArray[4]);
 	}
 } 

function isCustUpdate(arr) {
	for (var i=0; i<arr.length; i++) {
		if (!ComIsEmpty(arr[i])) return false;
	}
	return true;
}

/**
 * displayDeleteButtonOfAcualCustomer()
 * ( bdr flag, ca flag과 같은 booking 상태와 관계가 있는가? )
 * @return 
 * @author 김진승
 * @since 2011.05.19 
 */
function displayDeleteButtonOfAcualCustomer(){
	var agmtActCntCd = document.form.agmt_act_cnt_cd.value;
	var agmtActCustSeq = document.form.agmt_act_cust_seq.value;
	if(!ComIsNull(agmtActCntCd)){
		//document.getElementById("btn_t7Delete").className = "btn2";
		document.getElementById("td_t7Delete").style.display = "block";
	} else {
		//document.getElementById("btn_t7Delete").className = "btn2_3";
		document.getElementById("td_t7Delete").style.display = "none";
	}
}

/**
 * B/L Customer 에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBackEx0192(rArray, rArray2);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBackEx0192(rArray, rArray2) {
	var formObj = document.form;
	if (rArray2) {
//		if (!ComIsNull(formObj.ex_cust_nm) ) {
//			if (!ComShowCodeConfirm("BKG00343")) return;
//		}
		ComSetObjValue(formObj.ex_cust_cnt_cd      , rArray2[1]);
		ComSetObjValue(formObj.ex_cust_seq         , ComLpad(rArray2[2],6,"0"));
//  		if (!ComIsEmpty(rArray2[6]) && ComIsEmpty(formObj.nf_cust_nm)) {
//  			ComSetObjValue(formObj.nf_cust_nm          , getMakeBrData("NAME",rArray2[6]) + "\n");
//  		}
//  		if (!ComIsEmpty(rArray2[7]) && ComIsEmpty(formObj.nf_cust_addr)) {
//  			ComSetObjValue(formObj.nf_cust_addr        , replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
//  		}
//		ComSetObjValue(formObj.nf_cust_cty_nm      , rArray2[11]);  //City
//		ComSetObjValue(formObj.nf_cust_ste_cd      , rArray2[12]);  //State
//		ComSetObjValue(formObj.nf_cstms_decl_cnt_cd, rArray2[13]);  //Country
//		ComSetObjValue(formObj.nf_cust_zip_id      , rArray2[14]);  //ZIP Code
//		ComSetObjValue(formObj.nf_eur_cstms_st_nm  , rArray2[16]);  //Street / P.O.Box
//		ComSetObjValue(formObj.nf_eori_no          , rArray2[17]);  //EORI#
//		ComSetObjValue(formObj.nf_cust_fax_no      , rArray2[9]);   //Fax
//		ComSetObjValue(formObj.nf_cust_eml         , rArray2[15]);  //E-mail
		searchMdmCustNm(sheetObjects[0],formObj,"EX",rArray2[1],rArray2[2]);
	} else {
		ComSetObjValue(formObj.ex_cust_cnt_cd      , rArray[0]);
		ComSetObjValue(formObj.ex_cust_seq         , ComLpad(rArray[1],6,"0"));
		searchMdmCustNm(sheetObjects[0],formObj,"EX",rArray[0],rArray[1]);
//		var arr = [formObj.nf_cust_cty_nm,
//		           formObj.nf_cust_ste_cd,
//		           formObj.nf_cstms_decl_cnt_cd,
//		           formObj.nf_cust_zip_id,
//		           formObj.nf_eur_cstms_st_nm,
//		           formObj.nf_eori_no,
//		           formObj.nf_cust_fax_no,
//		           formObj.nf_cust_eml];
//		if (isCustUpdate(arr)) {
//  			ComSetObjValue(formObj.nf_cust_cty_nm, rArray[10]);  //City
//  			ComSetObjValue(formObj.nf_cust_ste_cd, rArray[11]);  //State
//  			ComSetObjValue(formObj.nf_cust_zip_id, rArray[12]);  //ZIP Code
//		}
	}
}
/* 개발자 작업  끝 */
