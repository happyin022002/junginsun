﻿﻿﻿﻿﻿/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0229.js
 *@FileTitle : e-Booking & SI Process Top
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.15
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.06.15 전용진
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.06 이일민 [CHM-201005387] [ESM-BKG] Reefer / Dry Validation 체크 로직 추가
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
 * 2011.08.10 정선용 [CHM-201112747-01] Doc requirement상 Issue place 오류 관련 수정 요청
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2011.11.11 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완
 * 2011.11.24 정선용 [CHM-201114656-01] BL Issue Place 입력 자릿수 Validation을 기존 50자 이하 에서 100자 이하로 변경
 * 2011.12.06 정선용 [CHM-201114657-01] [ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.11.21 조정민 [CHM-201220708] BOOKNG 생성시나 변경시 S/C 운임 조회 및 G/W 메일 송부 기능 추가 (E-BKG & SI PROCESS)
 * 2012.12.17 조정민 [CHM-201221684] RFA,TAA 계약에 운임 존재 여부 및 GW 메일 연계 테스트
 * 2013.01.02 김현화 [CHM-201322360] POD의 Country Code가 Notify의 Country Code 와 다른 경우 메세지 Display(BKG08248) 단, Consignee Code가 KR002073  제외 
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
 * @class ESM_BKG_0229 : ESM_BKG_0229 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

// 0229.jsp load -> jsp에서 frame1_OnLoad()실행 -> 1 mili sec 대기(1st Tab이 load 된 후에 실행하기 위해)
// ->setTabSrc() 실행  -> alps vs esvc data 확인하여 data copy confirm msg or copy option pop-up
// -> 해당 tab의 data 유무를 확인하여  frame_Onload() 실행하여 각 Tab load한다
// 0229.jsp의 tabload1~tabload12에 초기값 NOT_LOAD로 넣어둔 값을 copy 대상 tab에 대해서 COPY로 넣어두고 각 tab load 종료시
// 해당 값을 보고 COPY이면 각 tab 자체의 copy to alps를 실행함
function ESM_BKG_0229() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var iterator = "|$$|";

var isFirstOnLoad = "false";
var isCopyAllRequested = false;
var saveFail = false;
var saveSuccess = true;
var ofcChgFlag = "N"; 
var arrWindow = new Array(null, null); //   몇개가 떠있는지 확인함.
var winIdx = "";

var descFlag = false;	// Mark & Description 의 저장여부를 Control 하는 Flag.

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_copyoption":
			isFirstOnLoad = "false";
			comBkgCallPop0231();
			break;

		case "btn_preview":
			rdOpen(rdObjects[0], "preview");
			break;

		case "btn_previewprint":
			rdOpen(rdObjects[0], "print");
			break;

		case "btn_alpsupload":
			saveFail == false;
			saveSuccess = true;
			if(formObject.loadFinish.value=="N"){
				ComShowCodeMessage("Screen", "");
				break;
			}
			var t1frame_form = document.frames("t1frame").form;
			
			// BDR 이후에는 C/A Reason을 선택할 수 있는 창을 띄움

			if(t1frame_form.rqst_iss_plc_nm.value.length > 100 ){
				ComShowCodeMessage("BKG02087");
				return false;
			}
			
			// Doc Type이 “S”인 경우 Freight term 이 ''이거나 , (P,C)가 아닌 경우 메세지 표시 2011.12.06 jsy 
			if( 'S' == ComGetObjValue(t1frame_form.doc_tp_cd) &&
				( '' == ComGetObjValue(t1frame_form.frt_term_cd2) ||
				  ('C' != ComGetObjValue(t1frame_form.frt_term_cd2) && 'P' != ComGetObjValue(t1frame_form.frt_term_cd2) )
				)
			   ) {
				ComShowCodeMessage("BKG08217");
			}

			// porCd polCd가 'CA' 'US'인 경우만 해당 로직을 타게 수정 2011.11.11 kbj
			var cRepfalg = false; 
			var porCd 		= ComGetObjValue(t1frame_form.bkg_por_cd);
			var polCd 		= ComGetObjValue(t1frame_form.bkg_pol_cd);
			cRepfalg = ( porCd.substring(0,2) == 'CA' || porCd.substring(0,2) == 'US' ||
					polCd.substring(0,2) == 'CA' || polCd.substring(0,2) == 'US' );
			if(cRepfalg){
				// c.ofc & c.rep 를 체크 2011.10.11 jsy------------------
				var sXml = sheetObject.GetSearchXml("ESM_BKG_1132GS.do?f_cmd="+SEARCH, "&bkg_no="+t1frame_form.bkg_no.value+"&sc_no="+
						t1frame_form.sc_no.value+"&ctrt_rep_cd="+t1frame_form.ctrt_ofc_cd.value+t1frame_form.ctrt_srep_cd.value );
				var CtrtRepCnt = ComGetEtcData(sXml, "CtrtRepCnt");
				var compare_cd = ComGetEtcData(sXml, "compare_cd");
				if( CtrtRepCnt > 1 && compare_cd == 'N') {
					ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132&sXml="+encodeURIComponent(sXml)+"&func=callBack1132", 500, 290, "callBack1132",	"1,0,1,1,1", true);
				}
				if( CtrtRepCnt == 1  && compare_cd == 'N') {
					var cust_sls_ofc_cd = ComGetEtcData(sXml, "cust_sls_ofc_cd");
					var cust_srep_cd = ComGetEtcData(sXml, "cust_srep_cd");
					ComSetObjValue(t1frame_form.ctrt_ofc_cd, cust_sls_ofc_cd);
					ComSetObjValue(t1frame_form.ctrt_srep_cd, cust_srep_cd);
				}
				// c.ofc & c.rep 를 체크 2011.10.11 jsy end ------------------
			}

		   	// 2012.04.24 BKG/DOC System 보완 요청 START
			if (!checkBkgIssStatus(formObject)) {
				return false;
			}
			// 2012.04.24 BKG/DOC System 보완 요청 END
			
			if (t1frame_form.xter_bkg_rqst_sts_cd.value == "X") {
				doActionIBSheet(sheetObject, formObject, COMMAND03);
			} else if (t1frame_form.bdr_flg.value == "Y") {
				var bkgNo = nullToBlank(t1frame_form.bkg_no.value); 
				if (bkgNo == "") {
					ComShowCodeMessage("BKG00255");
					return false;
				}
				// Mark & Description form submit
				if(!descFlag && t1frame_form.save_mnd_flag.value == "Y"){
					doSaveMnD();
				}
				doActionIBSheet(sheetObject, formObject, COMMAND02);
			} else {
				// Mark & Description form submit
				if(!descFlag && t1frame_form.save_mnd_flag.value == "Y"){
					doSaveMnD();
				}
				doActionIBSheet(sheetObject, formObject, COMMAND02);
			}

			
			if(saveFail==false && saveSuccess==true){
				/* 2013-01-07 [CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청 성공 메시지 */
				if("N" != t1frame_form.save_cm_flag.value && "NOT LOAD" != document.form.tabload5.value){
					if( document.frames("t5frame").form.stwg_cd.value == "MUPG" ){
						ComShowMessage(ComGetMsg("BKG08249"));
					}
				}
				if (ofcChgFlag == "Y"){
                    doActionIBSheet(sheetObject, formObject, SEARCH02);//여기안에도
                    ofcChgFlag = "N";
				} 
				else {
					
//					var flag = false; 
//					var t1FormObj = document.frames("t1frame").form;
//					//OFT charge 유무 확인
//					with (t1FormObj)
//					{
//
//						if(rfa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(rfa_no.value) ){
//							if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//									ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//									ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//									ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//									ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//									ComGetObjValue(rfa_no_old) != ComGetObjValue(rfa_no) ||
//									ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//									ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//									ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//									ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//									ComGetObjValue(cntr_del) != "N"){
//								
//								flag = true;									
//							}
//							
//							var sheet1Row = t1FormObj.sheet1.Rows;
//							
//							for(var i = 1 ; i < sheet1Row; i++){
//								if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//									flag = true;
//							}
//							if(flag == true)
//								doActionIBSheet(sheetObject, formObject, SEARCH05);
//							
//						}else if(sc_no.value.substring(0,3) != "DUM" && !ComIsEmpty(sc_no.value) ){
//							if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//									ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//									ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//									ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//									ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//									ComGetObjValue(sc_no_old) != ComGetObjValue(sc_no) ||
//									ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//									ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//									ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//									ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//									ComGetObjValue(cntr_del) != "N"){
//		
//								flag = true;									
//							}
//							
//							var sheet1Row = t1FormObj.sheet1.Rows;
//							
//							for(var i = 1 ; i < sheet1Row ; i++){
//		
//								if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//									flag = true;
//							}
//							if(flag == true)
//								doActionIBSheet(sheetObject, formObject, SEARCH04);
//							
//						}else if(taa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(taa_no.value) ){
//							if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//									ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//									ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//									ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//									ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//									ComGetObjValue(taa_no_old) != ComGetObjValue(taa_no) ||
//									ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//									ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//									ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//									ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//									ComGetObjValue(cntr_del) != "N"){
//		
//								flag = true;									
//							}
//							
//							var sheet1Row = t1FormObj.sheet1.Rows;
//							
//							for(var i = 1 ; i < sheet1Row ; i++){
//								if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//									flag = true;
//							}
//							if(flag == true)
//								doActionIBSheet(sheetObject, formObject, SEARCH06);
//						}
//
//					}	
//
                    reloadPage();
				}
				
				
				// 2013.01.02 POD의 Country Code가 Notify의 Country Code 와 다른 경우 메세지 Display 
				//           Consignee Code가 KR002073 (SM Line Corporation)이면 제외
				if(t1frame_form.save_cust_flag.value == "Y"){
				
					var t2FormObj = document.frames("t2frame").form;
					var t1FormObj = document.frames("t1frame").form;
	
					var podCd = t1FormObj.bkg_pod_cd.value;
					var podCntCd = podCd.substring(0,2);
		
					var nfCntCd  =  t2FormObj.nf_cust_cnt_cd.value;
					var cnCntCd  =  t2FormObj.cn_cust_cnt_cd.value;
					var cnCntSeq =  t2FormObj.cn_cust_seq.value;
	                
					if (podCntCd.length>0 && nfCntCd.length>0 && podCntCd != nfCntCd){
	    				if(podCntCd != "US" && podCntCd != "CA" && podCntCd != "IN"){
						    if (!(cnCntCd == "KR" && cnCntSeq == "002073")){
							   ComShowCodeMessage("BKG08248"); 
						   }
	    				}
					}
				}
				
				
				
			} else if(saveFail==true){//save file로 종료된 경우 -> 초기화 시킴
				saveFail = false; 
				saveSuccess = true;
				setBtnEnableSts("btn_alpsupload", true);
			}
			break;

		case "btn_reject":
			comBkgCallPop0902("R");
			break;

		case "btn_pending":
//			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
			comBkgCallPop0902("P");
			break;

		case "btn_reinstate":
			doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
			break;
		case "btn_retrieve":
			reloadPage();
			break;
		case "btn_Si_Image":
			var sParam = "";
			var sr_knd_cd = formObject.sr_knd_cd.value;
			var sr_no = formObject.rqst_no.value;
			var fax_log_ref_no = formObject.fax_log_ref_no.value;
			var bkg_no = formObject.bkg_no.value;
			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+sr_no +"&fax_log_ref_no="+fax_log_ref_no+"&bkg_no="+bkg_no;
//			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+'PHX103220002' +"&fax_log_ref_no="+'4d88199a3fcfbbaf45d58e28'+"&bkg_no="+'PHX113523201';
			
			var date = new Date();
			var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
					+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
					+ "" + date.getSeconds();
			winIdx = openUploadWindowCheck();
			arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447"+toDay, 750, 480, false);

			break;	
		case "btn_Si_Text":
			var sParam = "";
			var sr_knd_cd = formObject.sr_knd_cd.value;
			var sr_no = formObject.rqst_no.value;
			var fax_log_ref_no = formObject.fax_log_ref_no.value;
			var bkg_no = formObject.bkg_no.value;
			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+sr_no +"&fax_log_ref_no="+fax_log_ref_no+"&bkg_no="+bkg_no+"&conv_pdf_flg=Y";
//			sParam = "?&sr_knd_cd=" +sr_knd_cd + "&sr_no="+'PHX103220002' +"&fax_log_ref_no="+'4d88199a3fcfbbaf45d58e28'+"&bkg_no="+'PHX113523201';
			var date = new Date();
			var toDay = date.getYear() + "" + (date.getMonth() + 1) + ""
					+ date.getDate() + "" + date.getHours() + "" + date.getMinutes()
					+ "" + date.getSeconds();
			winIdx = openUploadWindowCheck();
			arrWindow[winIdx] = ComOpenWindowCenter("/hanjin/ESM_BKG_0447.do" + sParam, "ESM_BKG_0447"+toDay, 750, 480, false);

			
//			var downloadLocation = "";
//			var downloadFileName = "";
////			downloadLocation = '/a_dpcs/mail/module/BKG/SELBB/EML/0000000000/Email/Receive/2011/07/';
//			downloadLocation = formObject.conv_atch_file_path_ctnt.value;
////			downloadFileName='conv_sitrans_test@hanjin.com_3(4e2f5c503fe4c0c7e33860d4)_@PKG102612100PKG103190010.pdf';
//			downloadFileName= formObject.conv_eml_atch_file_nm.value;
//			var url = "hanjin/FileDownload?downloadLocation="+downloadLocation+downloadFileName + "&downloadFileName="+downloadFileName;
//			var host = "http://" + location.host+"/";
//			
//			if (host.indexOf("localhost") > -1 || host.indexOf("127.0.0.1") > -1) {
//				url = "http://alpsdev.hanjin.com:9400/"+url;
//			}else{
//				url = host +url;
//			}
//			
//			//url = "/hanjin/FileDownload?downloadLocation=c://@DUS105842700ANR107140001.tif&downloadFileName=/@DUS105842700ANR107140001.tif";
//			hiddenFrame.location.href = url;
			break;
			
		case "btn_Chk_Point":
			var t1FormObj = document.frames("t1frame").form;
			var cntCd  =  t1FormObj.s_cust_cnt_cd.value;
			var cntSeq =  t1FormObj.s_cust_seq.value;
			var bkgOfcCd =  t1FormObj.bkg_ofc_cd.value;
			var tabIdx = tabObjects[0].SelectedIndex;
			var sParam = "?cust_cnt_cd="+cntCd+"&cust_seq="+cntSeq+"&bkg_ofc_cd="+bkgOfcCd+"&tab_idx="+tabIdx+"&open_mode=R";
			ComOpenWindowCenter("/hanjin/ESM_BKG_0237_P.do" + sParam, "ESM_BKG_0237_P", 1024, 550, false);
			break;
			
		case "btn_websiaudit":
			if (ComShowCodeConfirm("BKG00614")) {
				doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC03);
			}
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

	function callBack1132(arrVal){
       	var formObj = document.frames("t1frame").form;
		if(arrVal != null){		
			ComSetObjValue(formObj.ctrt_ofc_cd, arrVal[0][1]);
			ComSetObjValue(formObj.ctrt_srep_cd, arrVal[0][2]);
				
		}
   	}
	
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	var tabLen = tabObjects.length;
	
	for ( var k = 0; k < tabLen; k++) {
		initTab(tabObjects[k], k + 1);
	}
	tabObjects.SelectedIndex = 1;
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	initRdConfig(rdObjects[0]);
	initControl();
	var formObject = document.form;

	if (ComIsNull(formObject.fax_log_ref_no.value)) {
		
		ComBtnDisable("btn_Si_Image");
		ComBtnDisable("btn_Si_Text");
	}
	
	var t1FormObj = document.frames("t1frame").form;
	
	ComBtnDisable("btn_websiaudit");
	
	if(ComGetObjValue(t1FormObj.doc_tp_cd)=="S"||ComGetObjValue(t1FormObj.doc_tp_cd)=="U"){
		if(ComGetObjValue(t1FormObj.si_sys_upld_flg)=="Y"&&ComGetObjValue(t1FormObj.bkg_upld_sts_cd)=="F"){
			if(ComGetObjValue(t1FormObj.si_aud_flg)=="Y"){
				ComBtnDisable("btn_websiaudit");
			} else{
				 setBtnColor("btn_websiaudit", "red");
				 ComBtnEnable("btn_websiaudit");
				 
				 var param = "?pgmNo=ESM_BKG_0250&bkg_no="+ ComGetObjValue(t1FormObj.bkg_no)+ "&xter_sndr_id=" + ComGetObjValue(t1FormObj.sender_id) +  "&xter_rqst_no=" + ComGetObjValue(t1FormObj.rqst_no) + "&xter_rqst_seq=" + ComGetObjValue(t1FormObj.rqst_seq);
			     var sUrl  = "ESM_BKG_0250.do"+param;
			        //ComOpenPopup('ESM_BKG_0250.do'+param, 900, 550, callback_func, '1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1', true);  //false
			     ComOpenWindow(sUrl, "ESM_BKG_0250", "width=900,height=700", false);
			}			
		}		

		// 2017.08.14 iylee Customer's Initial Rate 을 비표시/
		/*
		if(ComGetObjValue(t1FormObj.bkg_upld_sts_cd)=="N"){
			if(ComGetObjValue(t1FormObj.xter_rate_yn)=="Y"||ComGetObjValue(t1FormObj.cmpb_rt_flg)=="Y"){
				var param = "?pgmNo=ESM_BKG_0241&bkg_no="+ ComGetObjValue(t1FormObj.bkg_no)+ "&xter_sndr_id=" + ComGetObjValue(t1FormObj.sender_id) +  "&xter_rqst_no=" + ComGetObjValue(t1FormObj.rqst_no) + "&xter_rqst_seq=" + ComGetObjValue(t1FormObj.rqst_seq)+ "&cmpb_rt_flg="+ComGetObjValue(t1FormObj.cmpb_rt_flg);
			    var sUrl  = "ESM_BKG_0241.do"+param;
			    
			    var x=window.screenLeft;
			    var y=window.screenTop;
			    
			    if(ComGetObjValue(t1FormObj.cmpb_rt_flg)=="Y"){
			    	ComOpenWindow(sUrl, "ESM_BKG_0241", "width=600,height=400,top="+y+",left="+x, false);
			    } else {
			    	ComOpenWindow(sUrl, "ESM_BKG_0241", "width=600,height=670,top="+y+",left="+x, false);
			    }
			}
		}
		*/
	}
}

function reloadPage() {
	window.name = "dialogPopup";
	
	var formObj = document.form
	formObj.f_cmd.value = SEARCH;
	formObj.method = "get";
	formObj.target = "dialogPopup";
	formObj.action = "/hanjin/ESM_BKG_0229.do" + formObj.param_data.value;
	formObj.submit();
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	 

	var cnt = 0;

	switch (sheetNo) {
	case 1: 
		with (sheetObj) {
			// 높이 설정
			style.height = 0;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msNone;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 5, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(5, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "ibflag|rqst_no|rqst_seq|sender_id|bkg_no";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "rqst_no");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "rqst_seq");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "sender_id");
			InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "bkg_no");
			

		}
		break;
	}
}

function initControl() {
	applyShortcut();
}

/**
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			tabObj.InsertTab(-1, eBkgTabName[0], true);	//Booking
			tabObj.InsertTab(-1, eBkgTabName[1], true);	//Customer
			tabObj.InsertTab(-1, eBkgTabName[2], true);	//Container
			tabObj.InsertTab(-1, eBkgTabName[3], true);	//M&D
			tabObj.InsertTab(-1, eBkgTabName[4], true);	//C/M
			tabObj.InsertTab(-1, eBkgTabName[5], true);	//TRO/O
			tabObj.InsertTab(-1, eBkgTabName[6], true);	//Reefer
			tabObj.InsertTab(-1, eBkgTabName[7], true);	//Danger
			tabObj.InsertTab(-1, eBkgTabName[8], true);	//Awkward
			tabObj.InsertTab(-1, eBkgTabName[11], true);//Break Bulk
			tabObj.InsertTab(-1, eBkgTabName[9], true);	//House B/L 1
			tabObj.InsertTab(-1, eBkgTabName[10], true);//House B/L 2
		}
		break;
	}
	tabObj.TabMouseOverEffect = true;
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, tabIndex) {
	
	if (beforetab != tabIndex) {
		var objs = document.all.item("tabLayer");

		objs[tabIndex].style.display = "inline";
		objs[beforetab].style.display = "none";
		// objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;		
	}
	beforetab = tabIndex;
	// loadTabPage(tabIndex);
}

function loadTabPage(tabIndex) {
	var formObj = document.form;
	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet();
}

function clearAllTabPages() {
	
	var tabCnt =  tabObjects[0].GetCount();
	
	for ( var i = 0; i < tabCnt; i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
		}
	}
}

function enableAllTabPages(flag) {
	
	if (flag == null || flag == "") {
		if (document.form.cfm_flg.value.toUpperCase() != "YES") {
			flag = true;
		} else {
			flag = false;
		}
	}
	
	var tabCnt =  tabObjects[0].GetCount();

	for ( var i = 0; i < tabCnt; i++) {
		if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
			document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
		}
	}
}

//jsp에서 호출하여 가장 처음 실행됨
function frame1_OnLoad() {
	if (isFirstOnLoad == "false") {
//		var timer;
//		timer = setTimeout("setTabSrc()", 500, "Javascript");
		// 일단 첫 tab이 load된 후 실행하도록 처리
		setTimeout("setTabSrc()", 1);
	}
}

function frame_OnLoad() {
	var srcName = window.event.srcElement.getAttribute("name");
	
	if (isCopyAllRequested && frames(srcName).form) {
		if("t10frame"==srcName){
//			if("1"==ComGetObjValue(document.frames("t1frame").form.usa_cstms_file_cd)){
				frames(srcName).dataCopy();				
//			}		
		} else {
			frames(srcName).dataCopy();
		}
		
		
	}
}


// booking tab 이후 각 tab load
function setTabSrc() {
	var formObj = document.form; 
	var t1frame_form = document.frames("t1frame").form;
	
//	//0228 list에는 bkg_no가 없는데 bkg tab 조회한 결과 bkg_no가 찾아진 경우(list를 그대로 두고 재open한 경우 등)
//	-> 적용했을 경우 hbl 조회에 문제가 생김	
//	if((ComIsNull(formObj.bkg_no.value)&&!ComIsNull(t1frame_form.bkg_no.value))
//			||formObj.bkg_no.value!=t1frame_form.bkg_no.value){		
//		formObj.bkg_no.value=t1frame_form.bkg_no.value;
//		formObj.param_data.value = "?bkg_no="+formObj.bkg_no.value+
//		                      	   "&rqst_no="+encodeURIComponent(formObj.rqst_no.value)+"&rqst_seq="+formObj.rqst_seq.value+"&sender_id="+formObj.sender_id.value;				
//	}

	var param = formObj.param_data.value;
	
	/* e-Booking Upload 시 SI Automation 정확도를 pop-up으로 보여 줌
	 * SI Automation 정확도가 80% 이하인 경우 경고를 표시함.(VIA_CD가 EDI인 경우에만)
	 */
	if (t1frame_form.xter_rqst_via_cd.value =="EML" && formObj.tmplt_par_rto.value <= 80) {
		ComShowCodeMessage("BKG08225");
	}
	
	/* t1frame에 bdr_flg가 Y이면 BDR 된 것이므로 사용자에게
	 *  업로드 하면 Auto C/A로 진행될 것이라고 사전 경고를 줌
	 */
	isFirstOnLoad = "true";
	if (!ComIsNull(t1frame_form.bdr_flg.value) && t1frame_form.bdr_flg.value == "Y") {
		ComShowCodeMessage("BKG02047");
	}

	/*Data Copy화면 오픈(ESM_BKG_0231)
	e-Booking & SI 업로드 시,  Booking 정보가 없는 경우에는 아래와 같은 메세지를 띄우고
    Booking 및 기타 데이타가 접수된 항목을 자동으로 Copy를 하고, 
	Booking 정보가 없는 경우에만 Copy 옵션을 띄워서 Copy 항목을 선택하도록 함*/
	isCopyAllRequested = false;
	if (t1frame_form.save_bkg_flag.value == "Y") {
		if (ComShowCodeConfirm("BKG02018")) {
			isCopyAllRequested = true;
			document.frames("t1frame").doDataCopy();
		}
		else {
			isCopyAllRequested = false;
			//여기서 return하면 나머지 tab이 load되지 않음
//			return;
		}
	}
	if (t1frame_form.save_bkg_flag.value != "Y") {
		if (t1frame_form.bkg_upld_sts_cd.value == "N") {
			/*활성화 대상 탭이 1개 이상 있는 경우에만 Copy Option 팝업화면을 열어줌*/
			if(t1frame_form.save_cust_flag.value == "Y" || t1frame_form.save_cntr_flag.value == "Y"
				|| t1frame_form.save_mnd_flag.value == "Y" || t1frame_form.save_cm_flag.value == "Y"
				|| t1frame_form.save_tro_flag.value == "Y" || t1frame_form.save_rf_flag.value == "Y"
				|| t1frame_form.save_dg_flag.value == "Y" || t1frame_form.save_ak_flag.value == "Y"
				|| t1frame_form.save_bb_flag.value == "Y" || t1frame_form.save_hbl_flag.value == "Y"
				|| t1frame_form.save_hbl2_flag.value == "Y" ){
				
				comBkgCallPop0231();
				
			}
		}
	}
	allTabEnable(true);
	document.form.loadFinish.value = "Y";	
}


//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case COMMAND02: // 전체 탭 저장
		if(saveFail == true) return;// booking close에서 다시 실행된 경우에 무한 loop를 방지를 하기 위해 return 시킴
			
		var t1FormObj = document.frames("t1frame").form;
		var t1DocObj = document.frames("t1frame").document;

		// 전체 탭의 정보를 Array로 관리 함
		// save flag 이름, frame 이름, tab별 prefix, savestring이 담길 자리
		var tabs = new Array (
				new Array ("save_bkg_flag",		"t1frame",  "t1_",  ""), // ESM_BKG_0229_01
				new Array ("save_cust_flag",	"t2frame",  "t2_",  ""), // ESM_BKG_0229_02
				new Array ("save_cntr_flag",	"t3frame",  "t3_",  ""), // ESM_BKG_0229_03
				new Array ("save_mnd_flag",		"t4frame",  "t4_",  ""), // ESM_BKG_0229_04
				new Array ("save_cm_flag",		"t5frame",  "t5_",  ""), // ESM_BKG_0229_05
				new Array ("save_tro_flag",		"t6frame",  "t6_",  ""), // ESM_BKG_0229_06
				new Array ("save_rf_flag",		"t7frame",  "t7_",  ""), // ESM_BKG_0229_07
				new Array ("save_dg_flag",		"t8frame",  "t8_",  ""), // ESM_BKG_0229_08
				new Array ("save_ak_flag",		"t9frame",  "t9_",  ""), // ESM_BKG_0229_09
				new Array ("save_bb_flag",	    "t12frame", "t12_", ""), // ESM_BKG_0229_12
				new Array ("save_hbl_flag",		"t10frame", "t10_", ""), // ESM_BKG_0229_10
				new Array ("save_hbl2_flag",	"t11frame", "t11_", "") // ESM_BKG_0229_11
				 
		);
		
		checkAllTabLoad(t1FormObj, formObj);
		
		//저장전 저장대상 tab 정보를 보관한다.(저장 실패시 tab을 다시 활성화하기 위함(N인 tab들은 SC단에서 html action에서부터 제외한다)
		var saveFlagBackupStr = "Y";
		
		var tabLen = tabs.length;
		
		for (var i = 1; i < tabLen; i ++) {
			saveFlagBackupStr = saveFlagBackupStr + "|" + t1DocObj.getElementsByName(tabs[i][0])[0].value;
		}	
		
		// BKG Allocation 
		//alert(t1FormObj.aloc_chk_flg.value);
		if(ComGetObjValue(t1FormObj.por_cd_old) != ComGetObjValue(t1FormObj.bkg_por_cd) ||
				ComGetObjValue(t1FormObj.pol_cd_old) != ComGetObjValue(t1FormObj.bkg_pol_cd) ||
				ComGetObjValue(t1FormObj.pod_cd_old) != ComGetObjValue(t1FormObj.bkg_pod_cd) ||
				ComGetObjValue(t1FormObj.del_cd_old) != ComGetObjValue(t1FormObj.bkg_del_cd) ||
				ComGetObjValue(t1FormObj.cmdt_cd_old) != ComGetObjValue(t1FormObj.cmdt_cd) ||
				ComGetObjValue(t1FormObj.sc_no_old) != ComGetObjValue(t1FormObj.sc_no) ||
				ComGetObjValue(t1FormObj.rfa_no_old) != ComGetObjValue(t1FormObj.rfa_no) ||
				ComGetObjValue(t1FormObj.s_cust_cnt_cd_old) != ComGetObjValue(t1FormObj.s_cust_cnt_cd) ||
				ComGetObjValue(t1FormObj.s_cust_seq_old) != ComGetObjValue(t1FormObj.s_cust_seq) ||
				ComGetObjValue(t1FormObj.bkg_trunk_vvd_old) != ComGetObjValue(t1FormObj.bkg_trunk_vvd) 
				// cntr type size 0229_01
				// cntr qty 0229_01
				// 
				) {
			t1FormObj.aloc_chk_flg.value = "Y";
		}
		//alert(t1FormObj.aloc_chk_flg.value);
		
		// SI이고 TRO, RF, DG, AK 중 하나라도 포함되어 있으면, 사용자에게 해당 TAB도 업로드 시킬 것인지 확인 메시지를 보여 줌
		// 제외(기본 copy에서만 제외) 20100222 requested by ey shin
//		var includeTroRfDgAk = true;
//		if (t1FormObj.doc_tp_cd.value == "S" && (t1FormObj.save_tro_flag.value == "Y" || t1FormObj.save_rf_flag.value  == "Y" || t1FormObj.save_dg_flag.value  == "Y" || t1FormObj.save_ak_flag.value  == "Y")) {
//			if (ComShowCodeConfirm("BKG02037") == false) {
//				includeTroRfDgAk = false;
//			}
//		}

		// 전체 탭 수 만큼  반복하며 SAVE가 요구되는 경우, validation 함수와 SC에 올릴 parameter 를 받음
		for (var i = 0; i < tabLen; i++) {
			// Booking Tab은 무조건 포함 시킴 i가 0인 경우
			if (i == 0 || t1DocObj.getElementsByName(tabs[i][0])[0].value == "Y") {
				// TRO, RF, DG, AK를 같이 안 올리겠다고 사용자가 확인한 경우
				// Upload 하지 않는다. -> 제외(기본 copy에서만 제외) 20100222 requested by ey shin
//				if (includeTroRfDgAk == false && (tabs[i][0] == "save_tro_flag" || tabs[i][0] == "save_rf_flag" || tabs[i][0] == "save_dg_flag" || tabs[i][0] == "save_ak_flag")) {
//					continue;
//				}
				// 각 탭에 Validation 함수를 호출하여 각 탭에 Client단에 Validation 통과 여부를 확인 함
				tabObjects[0].SelectedIndex = i;
				if (document.frames(tabs[i][1]).validateForUpload() == false) {
					saveSuccess = false;//reload 안하도록
					return false;
				}
				
//				 각 탭에 Validation 이 통과한 경우, 각 탭에 저장할 문자열을 구해 옴
//				tabs[i][3] = document.frames(tabs[i][1]).getSaveStringForUpload();
			}
		}
		
		for (var i = 0; i < tabLen; i++) {
			if (i == 0 || t1DocObj.getElementsByName(tabs[i][0])[0].value == "Y") {
				tabs[i][3] = document.frames(tabs[i][1]).getSaveStringForUpload();
			}
		}
		
		// 첫tab으로 와서 upload
		tabObjects[0].SelectedIndex = 0;
		
		// c/a reason pop-up
		t1FormObj.ca_rsn_cd.value = null;
		if(t1FormObj.bdr_flg.value == "Y") {
			//pop-up이 뜬 경우 0708 화면에서 tmp table에 넣고  setCaReasonCallBack()실행된 후에 아래 이어서 실행됨
			comBkgCallPop0708("setCAReasonCallBack", t1FormObj.bkg_no.value, "S");
			
			if(t1FormObj.ca_rsn_cd.value == null || t1FormObj.ca_rsn_cd.value == "null" || ComIsNull(t1FormObj.ca_rsn_cd.value)){
				saveSuccess = false;//reload 안하도록
				return false;
			}			
		}		

		// Save Flag를 정리 함.
        // (1) Booking 탭은 무조건 올리기 위해 Save Flag를  Y로 켜줌
		// (2) GetSaveString에서 넘어온 값이 없으면 N으로 업데이트 함
		for (var i = 0; i < tabLen; i ++) {
			t1DocObj.getElementsByName(tabs[i][0])[0].value = (tabs[i][3] == "")?"N":"Y";
		}

		// 각 탭에서 받은 parameter 를 합침, save에 사용되는 f_cmd는 COMMAND02		
		t1FormObj.f_cmd.value = COMMAND02;
		var params = FormQueryString(t1FormObj);
		for (var i = 0; i < tabLen; i ++) {
			// getSaveStringForUpload로 SaveString이 있는 경우
			if (tabs[i][3] != "") {
				// 각 탭의 parameter를 구분하기 위해 Prefix를 덧 붙여 paramter를 합한다
				params = params + "&" + ComSetPrifix(tabs[i][3], tabs[i][2]);
			}
		}
		
		// save flag를 원래 상태로 돌림
		var saveFlags = saveFlagBackupStr.split("|");
		var saveFlagsLen = saveFlags.length;
		for(var i = 0; i < saveFlagsLen; i++) {
			t1DocObj.getElementsByName(tabs[i][0])[0].value = saveFlags[i];
		}
		
		// 2011.08.30 EML 에 대한 bkg_sr_fax의 SR_PROC_TP_CD 에 대한 업데이트시
		params = params + "&rqst_no=" +formObj.rqst_no.value+"&fax_log_ref_no="+formObj.fax_log_ref_no.value
		                +"&sender_id="+formObj.sender_id.value;
		
		// 각 탭에서 SaveString을 받을 때 이미 encoding 된 data를 받으므로 이중으로 encoding하지 않기 위해 마지막에 false를 argument로 넘김
        sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229GS.do", params, false);
		ComOpenWait(false);

		allTabEnable(false);

		var t1frame_form = document.frames("t1frame").form;
		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
			saveFail = true;//실패시 bkg close mail 안띄우도록
			saveSuccess = false;//reload 안하도록
						
			sheetObj.LoadSaveXml(sXml);// 실패했으면 실패 메시지를 보여 줌(실패 탭으로 자동으로 옮겨줬으면 좋겠는데 방법을 찾아봐야 할 듯)

			//c/a 진행중 실패시
			if (t1frame_form.bdr_flg.value == "Y") {
        		formObj.f_cmd.value = MULTI01;  //cancel CA  	 
                sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);   
          		var sXml2 = sheetObj.GetSaveXml("ESM_BKG_0079GS.do", FormQueryString(formObj));
        		ComOpenWait(false);
        		allTabEnable(false);
        		
          		if (ComGetEtcData(sXml2, "TRANS_RESULT_KEY") != "S") {
          			sheetObj.LoadSaveXml(sXml2);
          		}
			}
		} else {
			saveSuccess = true;
			var rtnBkgNo = ComGetEtcData(sXml, "bkg_no"); 
				ofcChgFlag = ComGetEtcData(sXml, "ofcChgFlag");
			if(rtnBkgNo != undefined && rtnBkgNo.length>10) t1frame_form.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
			
			if(ComGetEtcData(sXml, "closeBkgFlag") == "Y"){
				var firstVvd = ComGetEtcData(sXml, "first_vvd");
				if(ComShowCodeConfirm("BKG00312",firstVvd)){ //"booking close인 상태지만 그대로 저장하겠음"을 선택한 경우
					t1frame_form.close_bkg_flag.value = "Y"; // booking close를 다시 validation하지 않게 함
					doActionIBSheet(sheetObj, formObj, COMMAND02);// 저장
						
    				if(saveFail==false && ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
    					//bkg close mail open
    					//============================================================================================
    					var subject = (t1frame_form.alps2.value != "Yes")?"BKG Creation Notice":"BKG Change Notice";

    					var closeBkgMsg = ComGetEtcData(sXml, "closeBkgMsg");
    					if(closeBkgMsg.indexOf("BKG No : <BR>")){
    						closeBkgMsg = "BKG No : " + t1frame_form.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
    					}
						document.frames("t1frame").sendBkgCloseMail(subject, closeBkgMsg);
						t1frame_form.close_bkg_flag.value = "N";	
    					//============================================================================================
    				}
				} else { //"booking close이므로 중지"을 선택한 경우
					t1frame_form.close_bkg_flag.value = "N";	
					saveSuccess = false;// -> reload 안하도록
					break;
				}
			} else if(ComGetEtcData(sXml, "tsCloseBkgFlag") == "Y"){
				// for t/s bkg close by bayplan
				var closedVvds = ComGetEtcData(sXml, "closedVvds");
				if(closedVvds != null && closedVvds.length > 0){
					ComShowCodeMessage("BKG08253",closedVvds);
				}
				ComSetObjValue(t1frame_form.ts_close_bkg_flag, "Y");
				ComSetObjValue(t1frame_form.closed_ts_vvd, closedVvds);					

				doActionIBSheet(sheetObj, formObj, COMMAND02);// 저장
				break;
			} else if (ComGetEtcData(sXml, "cbfBkgFlag") == "Y") {
				if(ComShowCodeConfirm("BKG02069")){ //"booking cbf 상태지만 그대로 저장하겠음"을 선택한 경우
					t1frame_form.cbf_bkg_flag.value = "Y"; // booking cbf 다시 validation하지 않게 함
					doActionIBSheet(sheetObj, formObj, COMMAND02);// 저장
						
    				if(saveFail==false && ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
    					//bkg close mail open
    					//============================================================================================
    					var subject = (t1frame_form.alps2.value != "Yes")?"BKG Creation Notice":"BKG Change Notice";

    					var closeBkgMsg = ComGetEtcData(sXml, "closeBkgMsg");
    					if(closeBkgMsg.indexOf("BKG No : <BR>")){
    						closeBkgMsg = "BKG No : " + t1frame_form.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
    					}
						document.frames("t1frame").sendBkgCloseMail(subject, closeBkgMsg);
						t1frame_form.cbf_bkg_flag.value = "N";	
    					//============================================================================================
    				}
				} else { //"booking close이므로 중지"을 선택한 경우
					t1frame_form.cbf_bkg_flag.value = "N";	
					saveSuccess = false;// -> reload 안하도록
					break;
				}				
			} 
			// pctl 내부 생성 실패
			else if(ComGetEtcData(sXml, "IsPctlNoPop") == "YC" || ComGetEtcData(sXml, "IsPctlNoPop") == "YM"){
				if(document.frames(tabs[0][1]).createPctlNo()){
					// pop-up에서 pctlNo 잘 받아왔으면 저장 다시 시작
					doActionIBSheet(sheetObj, formObj, COMMAND02);
				} else {
					saveSuccess = false;// -> reload 안하도록
					return false;
				}
			} else if(ComGetEtcData(sXml, "xterBkgSts") == "Y"){
					ComShowCodeMessage("BKG02049");
					reloadPage();
			} else  {
				// pctl 내부 생성 성공, 성공 메시지를 보여 줌
				if(ComGetEtcData(sXml, "dgKeyFlg") == "Y"){
					ComShowCodeMessage("BKG08314");
				}
				if(ComGetEtcData(sXml, "dgKeyFlg2") == "Y"){
					ComShowCodeMessage("BKG95100");
				}
				
				var bccExistFlg= 'N';
				var chgExpRqst = 'N';
				
				if (t1frame_form.bdr_flg.value == "Y"){					
					
					// BCC Auto-Interface 기능 구현 요청
		       		//var sXml = sheetObj.GetSearchXml("ESM_BKG_0079GS.do", 
		       		//			"f_cmd="+SEARCHLIST01+"&bkg_no="+t1FormObj.bkg_no.value); 
		       		var currCd = ComGetEtcData(sXml,"curr_cd");
		       		var scgAmt = ComGetEtcData(sXml,"scg_amt");
		       		formObj.ca_no.value= ComGetEtcData(sXml,"ca_no");
		            if(currCd != null && scgAmt != null){
		    			if(confirm(ComGetMsg("BKG02217", currCd, scgAmt))){		    				
		    				bccExistFlg= "Y";
		            	} else {
		            		// No 를 선택하더라도 우선 I/F하고, Exemption Request 화면을 통해 면제요청을 하도록 한다.
							// 저장 이후  BCC(OBS, LBP) Exemption Request 팝업을 열어줌.
		            		// 단, -	POR/POL country가 US 이거나, POD/DEL Country가 US인 경우 제외
		            		var input_text = ComGetObjValue(t1FormObj.bkg_no);
		    			 	var param = param + "&f_cmd=" + COMMAND17 + "&input_text=" + input_text;
		    			 	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
		    			 	var por_cnt_cd = ComGetEtcData(sXml, "por_cnt_cd");
		    			 	var pol_cnt_cd = ComGetEtcData(sXml, "pol_cnt_cd");
		    			 	var pod_cnt_cd = ComGetEtcData(sXml, "pod_cnt_cd");
		    			 	var del_cnt_cd = ComGetEtcData(sXml, "del_cnt_cd");
		    				
		    				if(por_cnt_cd != 'US' && pol_cnt_cd != 'US' && pod_cnt_cd != 'US' && del_cnt_cd != 'US' ){
		    					bccExistFlg= "Y";
								chgExpRqst = 'Y';
		    				}else {
		    					bccExistFlg = "N";
		    				}
		            			
		            	}
		            } else {
		            	bccExistFlg = "N";
		            }
		         		
				} 
				
				if(bccExistFlg=="Y"){
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC04);
					
					// BCC Charge 면제요청을 위한 팝업 오픈
		     		if(chgExpRqst == 'Y'){
		     			var _Width = '449';
		     			var _Height = '460';
		     			var pgmNo = "&pgmNo=ESM_BKG_1600";
		     			var param = "bkg_no="+ComGetObjValue(t1FormObj.bkg_no)+"&chg_cd=BCC" ;
		     			var url = "ESM_BKG_1600.do?" + param + pgmNo;
		     			ComOpenWindowCenter(url, "BKG_Win", _Width , _Height, true,true);
		     			chgExpRqst = 'N'
		     		}		     
		     		
				} else {				
					ComShowCodeMessage("BKG00166");
				}
				
				if (ComGetEtcData(sXml, "codFlg") == "Y"){
					bkg0156PopUp(formObj.bkg_no.value,"");
				}
				
				//alert(t1FormObj.aloc_sts_cd.value);
				if(ComGetEtcData(sXml, "firm_msg_flg") == "Y" && t1FormObj.auto_notification.value == "N" ){
					ComShowCodeMessage("BKG08300");
				}
				//alert("Noti:"+t1FormObj.auto_notification.value+" ,doc:"+t1FormObj.doc_tp_cd.value+" ,bkg:"+t1FormObj.bkg_cntc_pson_eml.value+" ,si:"+t1FormObj.si_cntc_pson_eml.value);
				if(ComGetEtcData(sXml, "alocPopFlg") == "Y"){
					ComOpenPopup("ESM_BKG_1507.do?bkg_no=" + formObj.bkg_no.value
							                      + "&aloc_pop_flg=Y&popup_msg_flg=N&before_aloc_sts_cd="+t1FormObj.aloc_sts_cd.value
							                      + "&auto_notification="+t1FormObj.auto_notification.value
							                      + "&doc_tp_cd="+t1FormObj.doc_tp_cd.value
							                      + "&bkg_cntc_pson_eml="+t1FormObj.bkg_cntc_pson_eml.value
							                      + "&si_cntc_pson_eml="+t1FormObj.si_cntc_pson_eml.value
							                      , 760, 550, "","1,0,1,1,1", true);
				}

				saveFail = false;
				saveSuccess = true; // -> reload 되도록
				formObj.bkg_no.value = t1frame_form.bkg_no.value;
			}
		}		
		break;

	case IBSEARCH_ASYNC01: // Pending
		var t1FormObj = document.frames("t1frame").form;
		if (!document.frames("t1frame").validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}
		if (t1FormObj.bkg_upld_sts_cd.value == "D") {
			ComShowMessage(msgs['BKG00471']);
			return false;
		}
		if (t1FormObj.bkg_upld_sts_cd.value == "R") {
			ComShowMessage(msgs['BKG00473']);
			return false;
		}
		
		sheetObj.RemoveAll();
		var Row = sheetObj.DataInsert(-1);
		sheetObj.RowStatus(Row) = "U";
		sheetObj.CellValue(Row, "rqst_no") = t1FormObj.rqst_no.value;
		sheetObj.CellValue(Row, "rqst_seq") = t1FormObj.rqst_seq.value;
		sheetObj.CellValue(Row, "sender_id") = t1FormObj.sender_id.value;
		sheetObj.CellValue(Row, "bkg_no") = t1FormObj.bkg_no.value;
		t1FormObj.f_cmd.value = MODIFY01;
//		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", FormQueryString(t1FormObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", "f_cmd=" + MODIFY01 + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));

		if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
			ComBkgSaveCompleted();
			// doActionIBSheet(sheetObj, formObj, IBSEARCH);
			reloadPage();
		} else {
			sheetObj.LoadSaveXml(sXml);
		}
		break;

	case IBSEARCH_ASYNC02: // Reinstate
		var t1FormObj = document.frames("t1frame").form;
		if (!document.frames("t1frame").validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}

		if(!ComShowConfirm("Are you sure?")){
			return false;			
		}
		
		sheetObj.RemoveAll();
		var Row = sheetObj.DataInsert(-1);
		sheetObj.RowStatus(Row) = "U";
		sheetObj.CellValue(Row, "rqst_no") = t1FormObj.rqst_no.value;
		sheetObj.CellValue(Row, "rqst_seq") = t1FormObj.rqst_seq.value;
		sheetObj.CellValue(Row, "sender_id") = t1FormObj.sender_id.value;		

		t1FormObj.f_cmd.value = MODIFY02;
//		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", FormQueryString(t1FormObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", "f_cmd=" + MODIFY02 + "&" + ComSetPrifix(sheetObj.GetSaveString(true), "sheet4_"));

		if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
//			ComBkgSaveCompleted();
			reloadPage();
		} else {
			sheetObj.LoadSaveXml(sXml);
		}
		break;
	case COMMAND03: //Cancel
		if(saveFail == true){
			return;
		}
		var t1FormObj = document.frames("t1frame").form;
		if (!document.frames("t1frame").validateForm(sheetObj, t1FormObj, sAction)) {
			return false;
		}	

		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);			  
		t1FormObj.f_cmd.value = COMMAND03;
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229GS.do", FormQueryString(t1FormObj));
		ComOpenWait(false);
		allTabEnable(false); 

		if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
			var firstVvd = ComGetEtcData(sXml, "first_vvd");
			if(ComShowCodeConfirm("BKG00312",firstVvd)){
				ComSetObjValue(t1FormObj.close_bkg_flag, "Y");
				doActionIBSheet(sheetObj, formObj, COMMAND03);
				
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
            		var subject = "BKG Change Notice";            		
					document.frames("t1frame").sendBkgCloseMail(subject, ComGetEtcData(sXml, "closeBkgMsg"));
					ComSetObjValue(t1FormObj.close_bkg_flag, "N");	      					
				}
			} else {
				ComSetObjValue(t1FormObj.close_bkg_flag, "N");	
				saveFail == true;
				saveSuccess = false;	
				break;
			}
		} else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
			if(ComShowCodeConfirm("BKG02069")){
				ComSetObjValue(t1FormObj.cbf_bkg_flag, "Y");
				doActionIBSheet(sheetObj, formObj, COMMAND03);
				
				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
            		var subject = "BKG Change Notice";            		
					document.frames("t1frame").sendBkgCloseMail(subject, ComGetEtcData(sXml, "closeBkgMsg"));
					ComSetObjValue(t1FormObj.cbf_bkg_flag, "N");	      					
				}
			} else {
				ComSetObjValue(t1FormObj.cbf_bkg_flag, "N");	
				saveFail == true;
				saveSuccess = false;
				break;
			}
		} else if (ComGetEtcData(sXml, "SuccessYn") == "Y") {
			ComBkgSaveCompleted();
		} else { //cancel 실패
			ComShowMessage(ComResultMessage(sXml));
			saveFail == true;
			saveSuccess = false;
		}		
		break;

	case SEARCH02:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		var t1FormObj = document.frames("t1frame").form;
		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&bl_no=" + ComGetObjValue(t1FormObj.bl_no);
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0229GS.do", param);
		var isSearch = true;
		var afOfc1 = ComGetEtcData(sXml, "ppdRcvOfcCd");
		var afOfc2 = ComGetEtcData(sXml, "cltOfcCd");
		var bfOfc1 = ComGetEtcData(sXml, "bfPpdRcvOfcCd");
		var bfOfc2 = ComGetEtcData(sXml, "bfCltOfcCd");
		var isRated = t1FormObj.is_rated_flg.value
		if (afOfc1!=bfOfc1 || afOfc2!=bfOfc2) {
			var callFlg = false;
			callFlg = ""==bfOfc1 && ""==bfOfc2;  //OLD OFC CD 가 없는 경우 true
			
			if(isRated == ""  || isRated == "N"){
				callFlg = true;
			}

			if (!callFlg) {
				if (ComShowCodeConfirm2("BKG02080",[bfOfc1,bfOfc2,afOfc1,afOfc2])) {  // OFC CD 변경 confirm
					callFlg = true;
				}
			}
			if (callFlg) {
//				isSearch = false;
				doActionIBSheet(sheetObj, t1FormObj, MODIFY07);
			}
		}

//		var flag = false; 
		//OFT charge 유무 확인
//		with (t1FormObj)
//		{
//			if(rfa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(rfa_no.value) ){
//				if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//						ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//						ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//						ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//						ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//						ComGetObjValue(rfa_no_old) != ComGetObjValue(rfa_no) ||
//						ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//						ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//						ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//						ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//						ComGetObjValue(cntr_del) != "N"){
//				
//					flag = true;									
//				}
//			
//				var  sheet1Row = t1FormObj.sheet1.Rows;
//				
//				for(var i = 1 ; i < sheet1Row; i++){
//					if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//					flag = true;
//				}	
//				if(flag == true)
//					doActionIBSheet(sheetObj, document.form, SEARCH05);
//		
//			}else if(sc_no.value.substring(0,3) != "DUM" && !ComIsEmpty(sc_no.value) ){
//				if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//						ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//						ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//						ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//						ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//						ComGetObjValue(sc_no_old) != ComGetObjValue(sc_no) ||
//						ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//						ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//						ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//						ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//						ComGetObjValue(cntr_del) != "N"){
//
//					flag = true;									
//				}
//				
//				var  sheet1Row = t1FormObj.sheet1.Rows;
//
//				for(var i = 1 ; i < sheet1Row; i++){
//
//					if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//						flag = true;
//				}
//				if(flag == true)
//					doActionIBSheet(sheetObj, document.form, SEARCH04);
//				
//			}else if(taa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(taa_no.value) ){
//				if(ComGetObjValue(por_cd_old) != ComGetObjValue(bkg_por_cd) ||
//						ComGetObjValue(pol_cd_old) != ComGetObjValue(bkg_pol_cd) ||
//						ComGetObjValue(pod_cd_old) != ComGetObjValue(bkg_pod_cd) ||
//						ComGetObjValue(del_cd_old) != ComGetObjValue(bkg_del_cd) ||
//						ComGetObjValue(cmdt_cd_old) != ComGetObjValue(cmdt_cd) ||
//						ComGetObjValue(taa_no_old) != ComGetObjValue(taa_no) ||
//						ComGetObjValue(dcgo_flg_old) != BkgNullToString(ComGetObjValue(dcgo_flg),"N") ||
//						ComGetObjValue(rc_flg_old) != BkgNullToString(ComGetObjValue(rc_flg),"N") ||
//						ComGetObjValue(awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(awk_cgo_flg),"N") ||
//						ComGetObjValue(bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(bb_cgo_flg),"N") ||
//						ComGetObjValue(cntr_del) != "N"){
//
//					flag = true;									
//				}
//				
//				var  sheet1Row = t1FormObj.sheet1.Rows;
//				
//				for(var i = 1 ; i < sheet1Row; i++){
//					if(t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd_old") != t1FormObj.sheet1.CellValue(i, "cntr_tpsz_cd"))
//						flag = true;
//				}
//				if(flag == true)
//					doActionIBSheet(sheetObj, document.form, SEARCH06);
//			}
//
//		}					
//		
		ComOpenWait(false);
		if (isSearch) {
			reloadPage();
		}
		break;

	case MODIFY07:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		var t1FormObj = document.frames("t1frame").form;
		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&bl_no=" + ComGetObjValue(t1FormObj.bl_no);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229GS.do", param);
		ComOpenWait(false);
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			ComBkgSaveCompleted();
//			reloadPage();
		}
		break;
		
	case SEARCH04:
		var t1FormObj = document.frames("t1frame").form;
		if(ComGetObjValue(t1FormObj.ca_flg) == "")
			t1FormObj.ca_flg.value = 'N';

		var param = "f_cmd=" + sAction + "&bl_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&sc_no=" + ComGetObjValue(t1FormObj.sc_no)
		 + "&ca_flg=" + ComGetObjValue(t1FormObj.ca_flg);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0269GS.do", param); 
		t1FormObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
		t1FormObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

		if (t1FormObj.chk_oft.value == "N" ){

			var param = 
				'bkg_no=' + t1FormObj.bkg_no.value + 
				'&application_date=' + t1FormObj.application_dt.value + 
				'&sc_no=' + t1FormObj.sc_no.value + 
				'&ca_flg=' + t1FormObj.ca_flg.value +
				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
				'&is_bkg=' + "Y";

			var pgmNo = "&pgmNo=ESM_BKG_0269";
			var url = "ESM_BKG_0269.do?" + param + pgmNo;
			ComOpenPopup(url, 1050, 650, "", "0,0", true);
			
		}

		break;	
		
		
	case SEARCH05:
	
		var t1FormObj = document.frames("t1frame").form;
		if(ComGetObjValue(t1FormObj.ca_flg) == "")
			t1FormObj.ca_flg.value = "N";
		
		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&rfa_no=" + ComGetObjValue(t1FormObj.rfa_no)
		 + "&ca_flg=" + ComGetObjValue(t1FormObj.ca_flg);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", param);
		t1FormObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
		t1FormObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

		if (t1FormObj.chk_oft.value == "N" ){

			var param = 
				'bkg_no=' + t1FormObj.bkg_no.value + 
				'&application_date=' + t1FormObj.application_dt.value + 
				'&rfa_no=' + t1FormObj.rfa_no.value + 
				'&frm_cmdt_cd=' + t1FormObj.cmdt_cd.value + 
				'&ca_flg=' + t1FormObj.ca_flg.value +
				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
				'&is_bkg=' + "Y";

			var pgmNo = "&pgmNo=ESM_BKG_0739";
			var url = "ESM_BKG_0739.do?" + param + pgmNo;
			ComOpenPopup(url, 1050, 650, "", "0,0", true);
			
		}
		break;		
	case SEARCH06:
		
		var t1FormObj = document.frames("t1frame").form;
		if(ComGetObjValue(t1FormObj.ca_flg) == "")
			t1FormObj.ca_flg.value = "N";
		
		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&taa_no=" + ComGetObjValue(t1FormObj.taa_no)
		 + "&ca_flg=" + ComGetObjValue(t1FormObj.ca_flg);
		var sXml = sheetObj.GetSaveXml("ESM_BKG_1076GS.do", param);
		t1FormObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
		t1FormObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

		if (t1FormObj.chk_oft.value == "N" ){

			var param = 
				'bkg_no=' + t1FormObj.bkg_no.value + 
				'&application_date=' + t1FormObj.application_dt.value + 
				'&taa_no=' + t1FormObj.taa_no.value + 
				'&frm_cmdt_cd=' + t1FormObj.cmdt_cd.value + 
				'&ca_flg=' + t1FormObj.ca_flg.value +
				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
				'&is_bkg=' + "Y";
		
			var pgmNo = "&pgmNo=ESM_BKG_1076";
			var url = "ESM_BKG_1076.do?" + param + pgmNo;
			ComOpenPopup(url, 1050, 650, "", "0,0", true);
			
		}
		break;
		
	case IBSEARCH_ASYNC03:
		sheetObj.WaitImageVisible=false;
		ComOpenWait(true);
		var t1FormObj = document.frames("t1frame").form;
		var param = "f_cmd=" + MULTI01 + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&bl_no=" + ComGetObjValue(t1FormObj.bl_no)
					   +  "&xter_sndr_id=" + ComGetObjValue(t1FormObj.sender_id) +  "&xter_rqst_no=" + ComGetObjValue(t1FormObj.rqst_no) + "&xter_rqst_seq=" + ComGetObjValue(t1FormObj.rqst_seq)
					   +  "&si_cntc_pson_eml=" + ComGetObjValue(t1FormObj.si_cntc_pson_eml) + "&si_aud_flg=Y";
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229GS.do", param);
		ComOpenWait(false);
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){			
			reloadPage();
		}
		break;
		
	case IBSEARCH_ASYNC04:
		var t1FormObj = document.frames("t1frame").form;
		var param = "f_cmd=" + MULTI02 + "&bkg_no=" + ComGetObjValue(t1FormObj.bkg_no) + "&bl_no=" + ComGetObjValue(t1FormObj.bl_no)+ "&ca_no=" + ComGetObjValue(formObj.ca_no)+ "&ca_flg=Y";
		var sXml = sheetObj.GetSaveXml("ESM_BKG_0229GS.do", param);
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){			
			ComShowCodeMessage("BKG00166");
		}
		break;
	}	
}

function initRdConfig(rdObject) {
	var Rdviewer = rdObject;
	Rdviewer.style.height = 0;

	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.AutoAdjust = 0;
	Rdviewer.ZoomRatio = 160;
}

function rdOpen(rdObject, viewType) {
	var Rdviewer = rdObject;
	var t1FormObj = document.frames("t1frame").form;
	var formObj = document.form;
	
	Rdviewer.SetAppendReport(1);	
//	if (t1FormObj.doc_tp_cd.value == "B" ||
//		t1FormObj.doc_tp_cd.value == "S") {
		var rdParam = "/rv " + "frm1_sender_id[" + formObj.sender_id.value + "]" +
					" frm1_rqst_no[" + formObj.rqst_no.value + "]" +
					" frm1_rqst_seq[" + formObj.rqst_seq.value + "]" +
					" frm1_bkg_no[" + formObj.bkg_no.value + "]";
		
		var rdUrl = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/";
		var rdFile = null;
		if (t1FormObj.doc_tp_cd.value == "B")
			rdFile = "ESM_BKG_0230B.mrd";
		else
			rdFile = "ESM_BKG_0230S.mrd";

		if (viewType == "print") {
			Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + " /riprnmargin /rwait");
			Rdviewer.CMPrint();
		} else {
			formObj.com_mrdPath.value = "apps/alps/esm/bkg/bookingconduct/ebookingconduct/ebookingreceipt/report/" + rdFile;
			formObj.com_mrdArguments.value = rdParam + " /riprnmargin /rwait";
			ComOpenRDPopup("resizable=yes");
		}

		Rdviewer.SetAppendReport(0);
//	}
}

function setBtnEnableSts(name, enableSts) {
	if (enableSts == true) {
		ComBtnEnable(name);
	}
	else {
		ComBtnDisable(name);
	}
}

function setBtnColor(name, color) {
	changeObjectColor("Y", "Y", name, color, "btn1");
}

function hideLoadingImg() {
	document.getElementById('loadingBar').style.display = "none";
	document.getElementById('divBody').style.display = "";
}

/**
 * CA Reason 후속 처리 : CaReasonModify
 */ 
function setCAReasonCallBack(arrPopupData) {
	var t1FormObj = document.frames("t1frame").form;

	//01. CA ReasonCd, Remark 입력정보 받아서,
	var strRsnCd  = nullToBlank(arrPopupData[0][2]);
	var strRemark = nullToBlank(arrPopupData[0][3]);

	//02. modifyCaReason(e) call
	t1FormObj.ca_rsn_cd.value = strRsnCd;
	t1FormObj.bkg_corr_rmk.value = strRemark;
}

function comBkgCallPop0902(bkgUpldStsCd) {
	var formObj = document.frames("t1frame").form;
	var param = "?bkg_no=" + formObj.bkg_no.value 
			+ "&rqst_no=" + encodeURIComponent(formObj.rqst_no.value) 
			+ "&rqst_seq=" + formObj.rqst_seq.value 
			+ "&sender_id=" + formObj.sender_id.value 
			+ "&cntc_eml=" + formObj.cntc_eml2.value
			+ "&doc_tp_cd=" + formObj.doc_tp_cd.value
			+ "&bkg_upld_sts_cd=" + bkgUpldStsCd;
	ComOpenWindowCenter("/hanjin/ESM_BKG_0902.do" + param, "PopupEsmBkg0902", 500, 500, true);
}

function comBkgCallPop0231() {
	ComOpenPopup("ESM_BKG_0231.do", 390, 420,"callBack0231", "1,0,1,1,1", true);
}
/**
* e-Booking & SI Process - Copy Option 팝업에서 전달받은 값 처리 <br>
* <br>
* <b>Example :</b>
* 
* <pre>
* callBack0231(copyTabStr);
* </pre>
* 
* @param Popup에서 전달받은 값
* @return 없음
* @author 류대영
* @version 2010.01.27
*/
function callBack0231(copyTabStr) {
	var formObj = document.form;
	
	if(isFirstOnLoad !="false"){	
		// 각 tab이 load된 후 data를 copy하도록 setting한다.
		if(copyTabStr[0]=="COPY") ComSetObjValue(formObj.tabload2,  "COPY");
		if(copyTabStr[1]=="COPY") ComSetObjValue(formObj.tabload3,  "COPY");
		if(copyTabStr[2]=="COPY") ComSetObjValue(formObj.tabload4,  "COPY");
		if(copyTabStr[3]=="COPY") ComSetObjValue(formObj.tabload5,  "COPY");
		if(copyTabStr[4]=="COPY") ComSetObjValue(formObj.tabload6,  "COPY");
		if(copyTabStr[5]=="COPY") ComSetObjValue(formObj.tabload7,  "COPY");
		if(copyTabStr[6]=="COPY") ComSetObjValue(formObj.tabload8,  "COPY");
		if(copyTabStr[7]=="COPY") ComSetObjValue(formObj.tabload9,  "COPY");
		if(copyTabStr[8]=="COPY") ComSetObjValue(formObj.tabload10, "COPY");
		if(copyTabStr[9]=="COPY") ComSetObjValue(formObj.tabload11, "COPY");
		if(copyTabStr[10]=="COPY") ComSetObjValue(formObj.tabload12, "COPY");
	} else {
		// load 완료 이후 open한 경우 선택된 tab을 copy한다.
		if(copyTabStr[0]=="COPY") document.frames("t2frame").dataCopy();
		if(copyTabStr[1]=="COPY") document.frames("t3frame").dataCopy();
		if(copyTabStr[2]=="COPY") document.frames("t4frame").dataCopy();
		if(copyTabStr[3]=="COPY") document.frames("t5frame").dataCopy();
		if(copyTabStr[4]=="COPY") document.frames("t6frame").dataCopy();
		if(copyTabStr[5]=="COPY") document.frames("t7frame").dataCopy();
		if(copyTabStr[6]=="COPY") document.frames("t8frame").dataCopy();
		if(copyTabStr[7]=="COPY") document.frames("t9frame").dataCopy();
//		if("1"==ComGetObjValue(document.frames("t1frame").form.usa_cstms_file_cd) ||
//		   "1"==ComGetObjValue(document.frames("t1frame").form.cnd_cstms_file_cd) ){
			if(copyTabStr[8]=="COPY") document.frames("t10frame").dataCopy();
//		}
			
		if(copyTabStr[9]=="COPY") document.frames("t11frame").dataCopy();
		
		if(copyTabStr[10]=="COPY") document.frames("t12frame").dataCopy();
	}
}

function allTabEnable(reload){
	var t1frame_form = document.frames("t1frame").form;
	var formObj = document.form;
	var param = formObj.param_data.value;

	// 각 tab load
	if (t1frame_form.save_cust_flag.value == "Y") {
		if(reload) document.all.t2frame.src = "ESM_BKG_0229_02.do" + param;
		tabObjects[0].TabEnable(1) = true;
	} else {
		if(reload) document.all.t2frame.src = "";
		tabObjects[0].TabEnable(1) = false;
	}
	if (t1frame_form.save_cntr_flag.value == "Y") {
		if(reload) document.all.t3frame.src = "ESM_BKG_0229_03.do" + param;
		tabObjects[0].TabEnable(2) = true;
	} else {
		if(reload) document.all.t3frame.src = "";
		tabObjects[0].TabEnable(2) = false;
	}
	if (t1frame_form.save_mnd_flag.value == "Y") {
		if(reload) document.all.t4frame.src = "ESM_BKG_0229_04.do" + param;
		tabObjects[0].TabEnable(3) = true;
	} else {
		if(reload) document.all.t4frame.src = "";
		tabObjects[0].TabEnable(3) = false;
	}
	if (t1frame_form.save_cm_flag.value == "Y") {
		if(reload) document.all.t5frame.src = "ESM_BKG_0229_05.do" + param;
		tabObjects[0].TabEnable(4) = true;
	} else {
		if(reload) document.all.t5frame.src = "";
		tabObjects[0].TabEnable(4) = false;
	}
	if (t1frame_form.save_tro_flag.value == "Y") {
		if(reload) document.all.t6frame.src = "ESM_BKG_0229_06.do" + param;
		tabObjects[0].TabEnable(5) = true;
	} else {
		if(reload) document.all.t6frame.src = "";
		tabObjects[0].TabEnable(5) = false;
	}
	if (t1frame_form.save_rf_flag.value == "Y") {
		if(reload) document.all.t7frame.src = "ESM_BKG_0229_07.do" + param;
		tabObjects[0].TabEnable(6) = true;
	} else {
		if(reload) document.all.t7frame.src = "";
		tabObjects[0].TabEnable(6) = false;
	}
	if (t1frame_form.save_dg_flag.value == "Y") {
		if(reload) document.all.t8frame.src = "ESM_BKG_0229_08.do" + param;
		tabObjects[0].TabEnable(7) = true;
	} else {
		if(reload) document.all.t8frame.src = "";
		tabObjects[0].TabEnable(7) = false;
	}
	if (t1frame_form.save_ak_flag.value == "Y") {
		if(reload) document.all.t9frame.src = "ESM_BKG_0229_09.do" + param;
		tabObjects[0].TabEnable(8) = true;
	} else {
		if(reload) document.all.t9frame.src = "";
		tabObjects[0].TabEnable(8) = false;
	}

	/*
	 * Break Bulk Tab 추가
	 */
	if (t1frame_form.save_bb_flag.value == "Y") {
		if(reload) document.all.t12frame.src = "ESM_BKG_0229_12.do" + param;
		tabObjects[0].TabEnable(9) = true;
	} else {
		if(reload) document.all.t12frame.src = "";
		tabObjects[0].TabEnable(9) = false;
	}
	
	if (t1frame_form.save_hbl_flag.value == "Y") {
		if(reload) document.all.t10frame.src = "ESM_BKG_0229_10.do" + param;
		tabObjects[0].TabEnable(10) = true;
	} else {
		if(reload) document.all.t10frame.src = "";
		tabObjects[0].TabEnable(10) = false;
	}
	if (t1frame_form.save_hbl2_flag.value == "Y") {
		if(reload) document.all.t11frame.src = "ESM_BKG_0229_11.do" + param;
		tabObjects[0].TabEnable(11) = true;
	} else {
		if(reload) document.all.t11frame.src = "";
		tabObjects[0].TabEnable(11) = false;
	}
	
}

//저장해야하는 tab이 아직 loading이 끝나지 않았는지 확인함
function checkAllTabLoad(t1FormObj, formObj){
	if(t1FormObj.save_cust_flag.value =="Y" && formObj.tabload2.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[1]);
		return false;
	}
	if(t1FormObj.save_cntr_flag.value =="Y" && formObj.tabload3.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[2]);
		return false;
	}
	if(t1FormObj.save_mnd_flag.value  =="Y" && formObj.tabload4.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[3]);
		return false;
	}
	if(t1FormObj.save_cm_flag.value   =="Y" && formObj.tabload5.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[4]);
		return false;
	}
	if(t1FormObj.save_tro_flag.value  =="Y" && formObj.tabload6.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[5]);
		return false;
	}
	if(t1FormObj.save_rf_flag.value   =="Y" && formObj.tabload7.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[6]);
		return false;
	}
	if(t1FormObj.save_dg_flag.value   =="Y" && formObj.tabload8.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[7]);
		return false;
	}
	if(t1FormObj.save_ak_flag.value   =="Y" && formObj.tabload9.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[8]);
		return false;
	}
	if(t1FormObj.save_hbl_flag.value  =="Y" && formObj.tabload10.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[9]);
		return false;
	}
	if(t1FormObj.save_hbl2_flag.value =="Y" && formObj.tabload11.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[10]);
		return false;
	}
	if(t1FormObj.save_bb_flag.value =="Y" && formObj.tabload12.value == "NOT LOAD"){
		ComShowCodeMessage("BKG02053", eBkgTabName[11]);
		return false;
	}
	return true;
}

function openUploadWindowCheck() {
	
	var arrWindowLen =  arrWindow.length;
	
	for ( var idx = 0; idx < arrWindowLen; idx++) {
		if (arrWindow[idx] == null || arrWindow[idx].closed)
			return idx;
	}

	return 99;
}

/**
 * BKG B/L Confirm, B/L Issued 여부 판단
 * 2012.04.24 오요한 BKG/DOC System 보완 요청
 * @param formObj
 * @return
 */
function checkBkgIssStatus(formObj) {
	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH12+"&bkg_no="+formObj.bkg_no.value);
	var bkgIssStatus = ComGetEtcData(sXml, "BKG_ISS_STATUS");
	if ("C" == bkgIssStatus) {
		if(ComShowConfirm(ComGetMsg("BKG08234"))) {//"B/L was already confirmed by shipper, do you want to still change?";
			return true;
		} else {
			return false;
		}
	} else if ("I" == bkgIssStatus) {
		if (ComShowConfirm(ComGetMsg("BKG08235"))) { //"B/L was already issued, do you want to still change?";
			return true;
		} else {
			return false;
		}
	} else {
		// C / I 가 아닌경우엔 체크를 하지 않는다.
		return true;
	}
} 

/**
 * Upload 버튼 클릭시 Mark & Description 내용을 hard wrap 형태로 submit
 * 
 */
function doSaveMnD() {	
	descFlag = true;	
	var t4FormObj = document.frames("t4frame").form;
//	var oldValue = descRequest.document.getElementById("mk_desc_old");
//	if(oldValue != undefined && oldValue != null){
//		t4FormObj.mk_desc.value =  oldValue.value;
//	}
	//document.getElementById("descRequest").innerHTML = "";
	t4FormObj.action = "/hanjin/apps/alps/esm/bkg/bookingcommon/bookingutil/jsp/ESM_BKG_WordWrap.jsp";
	t4FormObj.method = "post";
	t4FormObj.target = "descRequest";
	t4FormObj.submit();
}

/**
 * hard wrap 형태로 저장된 Mark & Description 내용을 MnD Tab(tab4)에 덮어씀.
 * doSaveMnD 실행 직후, 수행되는 메소드.
 * 
 */
function descSend() {
	if (descFlag) {
		var t4FormObj = document.frames("t4frame").form;
		t4FormObj.mk_desc.value = descRequest.document.getElementById("mk_desc").value;
//		descRequest.document.getElementById("mk_desc").value="";
		t4FormObj.dg_cmdt_desc.value = descRequest.document.getElementById("dg_cmdt_desc").value;
		
		// 호출
		window.event.srcElement.setAttribute("name","btn_alpsupload");
		descFlag = false;
	}
}

	/*
	* ESM_BKG_156 화면 호출
	*/
	function bkg0156PopUp(bkgNo,codRqstSeq){ 	
		var param="?mainPage=false&bkg_no="+bkgNo;
		param+="&cod_rqst_seq="+codRqstSeq;
		param+="&popFlg=C";
		param+="&pgmNo=ESM_BKG_0156";
		ComOpenWindowCenter("/hanjin/ESM_BKG_0156.do"+param, "ESM_BKG_0156", 1024, 730, true, "yes");
	}
	/* 개발자 작업  끝 */