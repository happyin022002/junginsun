/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0229_01.js
 *@FileTitle : e-Booking & SI Process Detail(BOOKING)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.02
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.07.02 전용진
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.06 이일민 [CHM-201005387] [ESM-BKG] Reefer / Dry Validation 체크 로직 추가
 * 2010.09.07 전성진 [SRM-201008669] [ESM-BKG] E-BOOKING 접수시에 CUSTOMER CODE COPY 오류, parseInt 파라미터 추가
 * 2010.09.10 전성진 [SRM-201008713] [ESM-BKG] E-BOOKING중에 SOC 관련 고객 DATA 가 COPY되지 않는 오류, 항목 누락 수정
 * 2010.09.29 전성진 [CHM-201006154] [ESM-BKG] draft B/L auto 전송관련- Upload 시 최신 값으로 업데이트 처리
 * 2010.10.04 전성진 [CHM-201006302] [ESM-BKG] Nigeria commodity입력시 웹사이트 Pop-up기능
 * 2010.10.06 이일민 [CHM-201005263] [ESM-BKG] SR 신청 화면 내 고객정보 입력란 추가 요청
 * 2010.10.07 이일민 F/H (flex_hgt_flg) 여부 저장 불가 수정
 * 2010.10.08 이일민 신규생성시 vsl_eng_nm, Contact Info 에 undefined 들어가는 문제 수정
 * 2010.10.12 이일민 upload 시 발생하는 스크립트 오류 수정
 * 2010.10.12 이일민 callBack0656 함수 arrVal[0][1] => arrVal[0][6] : BKG 와 같게.
 * 2010.10.13 이일민 [CHM-201005263] [ESM-BKG] SR 신청 화면 내 고객정보 입력란 추가 요청 : upload 시 contact 값 copy 조건 변경
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2010.12.03 전성진 [] BKG POL(POD) 변경시 POR(DEL) Name 찾아오는 로직 호출 추가
 * 2010.11.08 김영철 [CHM-201006978-01] AK 화면의 Commodity 입력 포맷을 RF와 동일하게 수정하고 BKG 메인의 Commoidty 코드가 자동 I/F 
 * 2010.12.17 이일민 [] callBack0092() 스크립트오류수정 - ESM_BKG_0079_01 의 함수를 카피해오면서 잘못된 것으로 보임
 * 2011.01.24 이일민 [] validateTurkey 추가
 * 2011.01.31 이일민 [SRM-201112705] setPolPodClptIndSeq 함수 추가
 * 2011.02.09 김영철 [CHM-201108366-01,CHM-201108632-01] E-SVC 화면 PICKUP DATE 항목 추가요청, E-BKG & SI Route 데이타 입력 Max값 조정 (25자까지)
 * 2011.02.17 김영철 [] PICKUP DATE 항목 Copy 시 값이 없으면 Copy 하지 않도록 하며, Qty 입력시 Tab 기능이 비정상적인 부분을 수정
 * 2011.03.02 김영철 [CHM-201108896-01] ebooking Detail 화면에서 Upload시에 Rote 값이 SVC와 틀리면 Alert를 보내주도록 함.
 * 2011.04.14 김영철 [] eBooking Upload 시에 Validation 추가 ( Pick Up Date )
 * 2011.05.25~06.03 김진승 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청; Split Status 표시, BKG contact, S/I contact 초기 로딩 처리;
 * 2011.06.13 김진승 [CHM-201110982-01] SI process 화면상에서 Doc requirement 관련된 “(Copy from e-service)” 버튼에 “체크”된 것을 “default”값으로 지정 처리 
 * 2011.06.20 김진승 [CHM-201111528] R9 CNTR의 BKG UPDATE 요청 - R4, R5부분 변경
 * 2011.06.27 손은주 [CHM-201111759-01	](ALPS) e-SI upload 기능
 * 2011.07.11 김진승 [CHM-201111968-01] [ALPS] Freight Term Copy 보완 (e-S/I)
 * 2011.07.18 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2011.11.11 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완
 * 2011.11.14 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완 추가 요청. sc_no 변경시 c.ofc/rep 값 초기화
 * 2011.11.24 금병주 [CHM-201114707-01] CFS Term Warning Pop-up message 보완 (문구 수정 및 조건 수정) 
 * 2011.11.28 정선용 [CHM-201114552-01] [Simple S/I] 파일 보완 작업 요청
 * 2011.12.06 정선용 [CHM-201114657-01] [ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청
 * 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
 * 2012.03.14 김현화 [CHM-201216660-01] E-bkg&SI - Contact Info Copy 기능 수정 요청 (Copy from E-service 기준 추가 맟 SI copy로직 수정) 
 * 2012.09.26 이재위 [CHM-201220330] [BKG] FREIGHT TERM 반영 문제 
 * 2012.09.26 조정민 [CHM-201220436] 특정RFA Term Validation예외 (RFA:BUD12A0115)
 * 2012.12.17 조정민 [CHM-201221684] RFA,TAA 계약에 운임 존재 여부 및 GW 메일 연계 테스트
 * 2013.02.18 임재관 [CHM-201322708] RAW/WET HIDE COMMODITY에 대하여 AUTO HIDE FLAGGING 구현
 * 2013.04.19 최문환 [CHM-201323915] Blacklisted Customer 사용 시 Alert 강화 요청
 * 2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
 * 2014.10.27 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
 * 2014.10.27 최도순[CHM-201432431] METAL SCRAP<-> RAIL BULK 연동 로직 
 * 2014.11.24 최도순  [CHM-201432767] Split 01-발 중국향 waste paper에 대해서 뜨는 팝업 삭제 처리 요청
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
 * @class ESM_BKG_0229_01 : ESM_BKG_0229_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0229_01() {
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

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var comboObjects = new Array();
var comboCnt = 0;

var sheetObjects = new Array();
var sheetCnt = 0;

//var isPctlNoPop = "";

var oldPolYdCd = "";
var oldPodYdCd = "";

var route_detail_modify_flag = "";
 
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */ 
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	/** **************************************************** */
	var formObj = document.form;
	var bkgNo = formObj.bkg_no.value;
	var blNo  = formObj.bl_no.value;
	var caFlg = formObj.ca_flg.value;
//	var bdrFlag;
 
	var bkgTrunkVvd = formObj.bkg_trunk_vvd.value;
	var porCd       = formObj.bkg_por_cd.value;
	var porYdCd     = formObj.bkg_por_yd_cd.value;
	var polCd       = formObj.bkg_pol_cd.value;
	var polYdCd     = formObj.bkg_pol_yd_cd.value;
	var podCd       = formObj.bkg_pod_cd.value;
	var podYdCd     = formObj.bkg_pod_yd_cd.value;
	var delCd       = formObj.bkg_del_cd.value;
	var delYdCd     = formObj.bkg_del_yd_cd.value;
	var oldBkgNo    = formObj.old_bkg_no.value;
	var sCustCntCd  = formObj.s_cust_cnt_cd.value;
	var sCustSeq    = formObj.s_cust_seq.value;
	var fCustCntCd  = formObj.f_cust_cnt_cd.value;
	var fCustSeq    = formObj.f_cust_seq.value;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		/** * Tab Main (S) ** */			
		case "btn_find_bkg":
			if(bkgNo == null){
				break;
			}
			doActionIBSheet(sheetObjects[0], document.form, SEARCH04);
			break;			

		case "btn_0019Pop": //vvd select
			if(sheetObjects[1].Rows>2){
				var trunkRow = sheetObjects[2].FindText("vsl_pre_pst_cd","T");
				polCd = sheetObjects[2].CellValue(trunkRow, "pol_cd");
				podCd = sheetObjects[2].CellValue(trunkRow, "pod_cd");
			}
			comBkgCallPop0019('callBack0019', bkgTrunkVvd, polCd, podCd);
			break;
			
		case "btn_gotobkg":
			ComBkgCall0079(bkgNo);
			break;
			
		case "btn_0652ShprPop": 
			comBkgCallPop0652('callBack0652', 'S', sCustCntCd, sCustSeq, (ComIsNull(sCustSeq)?(formObj.s_cust_nm.value.substring(0,10)):""),ComGetObjValue(formObj.ob_sls_ofc_cd),ComGetObjValue(formObj.ob_srep_cd));
			break;
			
		case "btn_0652FwdrPop":
			comBkgCallPop0652('callBack0652', 'F', fCustCntCd, fCustSeq, (ComIsNull(fCustSeq)?(formObj.f_cust_nm.value.substring(0,10)):""));
			break;

		case "btn_t1RouteDetail": // route detail
			if (polCd != "") {
				if(sheetObjects[2].RowCount < 2){
					if(sheetObjects[2].RowCount < 1){
						sheetObjects[2].DataInsert(-1);
					}
					sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") = "T";
					sheetObjects[1].CellValue(1, "vsl_seq")		= "0";
					sheetObjects[2].CellValue(1, "pol_cd") 		= polCd;
					sheetObjects[2].CellValue(1, "pol_yd_cd") 	= polYdCd;
					sheetObjects[2].CellValue(1, "pod_cd") 		= podCd;
					sheetObjects[2].CellValue(1, "pod_yd_cd") 	= podYdCd;
					if(bkgTrunkVvd.length==9){
						sheetObjects[2].CellValue(1, "bkg_vvd_cd") 	= bkgTrunkVvd;
					}
				}
				comBkgCallPop0092("callBack0092", bkgNo, bkgTrunkVvd, caFlg, "2");
			} else {
				ComShowCodeMessage("BKG00136");
				ComSetFocus(formObj.bkg_pol_cd);
			}
			break;
		case "btn_allocation":
			if(bkgTrunkVvd==null||bkgTrunkVvd.length<9){
   				ComShowCodeMessage("BKG00051", bkgTrunkVvd);		//VVD 9자리 체크	
				ComSetFocus(formObj.bkg_trunk_vvd);
				return;
			}
			var usr_ofc_cd = formObj.usr_ofc_cd.value;					
			if(usr_ofc_cd==null||usr_ofc_cd.length<5){
				return;
			}
			var param = "?pgmNo=ESM_SPC_0044";
			param = param + "&vvd="+bkgTrunkVvd + "&office=" + usr_ofc_cd;
       		ComOpenWindowCenter("/hanjin/ESM_SPC_0044.do"+param, "ESM_SPC_0044", 1024, 660, true, "yes");
			break;
		case "btn_0083PorPop":
//			comBkgCallPop0083('callBack0083', 'POR', porCd, porYdCd, comboObjects[0].Code);
			comBkgCallPop0083('callBack0083', 'POR', "", "", comboObjects[0].Code);
			break;
		case "btn_0083PolPop":
//			comBkgCallPop0083('callBack0083', 'POL', polCd, polYdCd, comboObjects[0].Code);
			comBkgCallPop0083('callBack0083', 'POL', "", "", comboObjects[0].Code);
			break;
		case "btn_0083PodPop":
//			comBkgCallPop0083('callBack0083', 'POD', podCd, podYdCd, comboObjects[1].Code);
			comBkgCallPop0083('callBack0083', 'POD', "", "", comboObjects[1].Code);
			break;
		case "btn_0083DelPop":
//			comBkgCallPop0083('callBack0083', 'DEL', delCd, delYdCd, comboObjects[1].Code);
			comBkgCallPop0083('callBack0083', 'DEL', "", "", comboObjects[1].Code);
			break;

		case "btn_RfaNo":
			if(bkgTrunkVvd.length==9){
				comBkgCallPop0654('callBack0654', bkgNo, bkgTrunkVvd, porCd, delCd, sCustCntCd, sCustSeq, '', '');
			} else {
				comBkgCallPop0654('callBack0654', bkgNo, "", porCd, delCd, sCustCntCd, sCustSeq, '', '');
			}
			break;
		case "btn_ScNo":
			if(bkgTrunkVvd.length==9){
				comBkgCallPop0655('callBack0655', bkgNo, bkgTrunkVvd, porCd, delCd, sCustCntCd, sCustSeq, '', '');
			} else {
	    		comBkgCallPop0655('callBack0655', bkgNo, "", porCd, delCd, sCustCntCd, sCustSeq, '', '');
			}
    		break;
    	case "btn_TaaNo":
			if(bkgTrunkVvd.length==9){
				comBkgCallPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,'','');
			} else {
				comBkgCallPop1062('callBack1062',bkgNo,"", porCd,delCd,sCustCntCd,sCustSeq,'','');
			}
    		break;
		case "btn_0656CmdtPop":
    		var rfaNo = ComGetObjValue(formObj.rfa_no);
    		var scNo = ComGetObjValue(formObj.sc_no);
    		var taaNo = ComGetObjValue(formObj.taa_no);
    		var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
    		var repCmdtCd = ComGetObjValue(formObj.rep_cmdt_cd);
    		if(bkgTrunkVvd.length!=9) bkgTrunkVvd = ""; 
    		
    		var rfaNo1 = "";
    		if(!ComIsNull(rfaNo) && rfaNo.length > 2){
    			rfaNo1 = rfaNo.substring(0,3);
    		}
    		var scNo1 = "";
    		if(!ComIsNull(scNo) && scNo.length > 2){
    			scNo1 = scNo.substring(0,3);
    		}        		
    		var taaNo1 = "";
    		if(!ComIsNull(taaNo) && taaNo.length > 2){
    			taaNo1 = taaNo.substring(0,3);
    		}          
    		if(formObj.ctrt_type[1].checked){
        		if(scNo1 == "DUM" || rfaNo1 == "DUM"){
        			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
        		}else{
        			if(rfaNo.length > 9){
        				comBkgCallPop0656('callBack0656',rfaNo,bkgNo,bkgTrunkVvd,porCd,delCd);        			
        			}else if(scNo.length > 7){
            			comBkgCallPop0657('callBack0657',scNo,bkgNo,bkgTrunkVvd,porCd,delCd);
            		}else{
            			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
            		}        			
        		}        			
    		}else{
        		if(scNo1 == "DUM" || taaNo1 == "DUM"){
        			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
        		}else{
        			if(taaNo.length > 9){
        				comBkgCallPop1078('callBack1078',taaNo,bkgNo,bkgTrunkVvd,porCd,delCd);        			
        			}else if(scNo.length > 7){
            			comBkgCallPop0657('callBack0657',scNo,bkgNo,bkgTrunkVvd,porCd,delCd);
            		}else{
            			comBkgCallPop0653('callBack0653',cmdtCd,repCmdtCd);
            		}        			
        		}        			
    		}
    		validatePrecaution(formObj);
    		
    		//CHM-201429948 BKG Creation 화면에서 Revenue empty cntr flag 자동 처리 20140424
    		//Seq	Code	Brief Description	REP
    		//1	  960151	EMPTY CONTAINER, NOS	9600
    		//2	  960316	EMPTY SHIPPER OWNED TANK CONTAINER	9600

    		if( ComGetObjValue(formObj.cmdt_cd) =='960151' || ComGetObjValue(formObj.cmdt_cd) =='960316' ) {
    			ComSetObjValue(formObj.bkg_cgo_tp_cd, "R");
    		}
			break;
			
		case "btns_DoorDate":
			var cal = new ComCalendar();
			cal.select(formObj.mty_dor_arr_dt, 'yyyy-MM-dd');
			break;

		case "btns_LoadingDate":
			var cal = new ComCalendar();
			cal.select(formObj.lodg_due_dt, 'yyyy-MM-dd');
			break;

		case "btns_DeliveryDate":
			var cal = new ComCalendar();
			cal.select(formObj.de_due_dt, 'yyyy-MM-dd');
			break;

		case "btns_PkupDate":
			var cal = new ComCalendar();
			cal.select(formObj.mty_pkup_dt, 'yyyy-MM-dd');
			break;

		case "btn_0082MtyPkupYdCd":
			var mtyPkupYdCd;
			if (ComChkLen(formObj.mty_pkup_yd_cd.value, 7) == "2") {
				mtyPkupYdCd = formObj.mty_pkup_yd_cd.value;
			} else {
				mtyPkupYdCd = porCd + porYdCd;
			}
			comBkgCallPop0082('callBack0082', '0', mtyPkupYdCd);
			break;

		case "btn_0088FullRtnYdCd":
			var r0088;
			if (ComChkLen(formObj.full_rtn_yd_cd.value, 7) == "2") {
				r0088 = formObj.full_rtn_yd_cd.value;
			} else {
				r0088 = porCd + porYdCd;
			}
			comBkgCallPop0088('callBack0088', r0088);
			break;

		// UI에서 버튼 삭제 요청 --신은영 차장님 20090914
		// case "btn_AutoNotiPop":
		// if (formObj.doc_tp_cd.value == "B") {
		// } else if (formObj.doc_tp_cd.value == "S") {
		// }
		// break;

		case "btn_CctPop":
			comBkgCallPop0721();
			break;

		case "btn_copyloc":
			document.all.chk.style.display = "";
			document.all.unchk.style.display = "none";
			copyCopyLocation("Y");
			break;

		case "btn_canceloc":
			document.all.chk.style.display = "none";
			document.all.unchk.style.display = "";
			copyCopyLocation("N");
			break;

		case "btn_contact":
			showBkCntc();
			break;

		case "btn_docRequirement":
			showBkgDocReq();
			break;

		case "btn_docRequirement2":
			showXterDocReq();
			break;
			
		case "btn_ref_bkg":
			showBkgRef();
			break;
			
		case "btn_ref_xter":
			showXterRef();
			break;
			
		/** * Tab Main (E) ** */
		case "btn_add":
			var Row = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].RowStatus(Row) = "I";
			ComSetObjValue(formObj.modify_flag, "Y");					
			manageHaveRouteFlag("N");
			break;

		case "btn_del":
//			ComRowHideDelete(sheetObjects[0], "del_chk");

			sheetObjects[0].RowDelete(sheetObjects[0].SelectRow,false);					
			disabledFH(sheetObjects[0], formObj);
			ComSetObjValue(formObj.qty_modify_flag, "Y");
			ComSetObjValue(formObj.cntr_del, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");					
			manageHaveRouteFlag("N");
			break;
			
		case "btn_EqDetail":
			if(chkCntrTpSz()){
				//2011.11.24
				comBkgCallPop0890("callBack0890","N");						
			}
			break; 
		case "btn_CRep":
			if(validateCRep(formObj)){
				ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132?f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+
						formObj.sc_no.value+"&ctrt_rep_cd="+formObj.ctrt_ofc_cd.value+formObj.ctrt_srep_cd.value+"&func=callBack1132", 500, 290, "callBack1132",	"1,0,1,1,1", true);
			}
    		break;			
		case "btn_t1SalesApproval": 
			showSalesApproval();
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
   	var formObj = document.form;
	if(arrVal != null){		
		ComSetObjValue(formObj.ctrt_ofc_cd, arrVal[0][1]);
		ComSetObjValue(formObj.ctrt_srep_cd, arrVal[0][2]);
	}
}
/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	
	var sheetLen = sheetObjects.length;
	
	for (i = 0; i < sheetLen; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
    // IBMultiCombo초기화
	
	var comboLen = comboObjects.length;
	
    for(var j=0; j<comboLen; j++){
        initCombo(comboObjects[j]);
    }

	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();	
	
	///2011.05.25
	if (document.form.doc_tp_cd.value == "B" ) {
		changeCntcLayer(0);
	} else {
		changeCntcLayer(1); 
	}

	/*if(ComGetObjValue(document.form.rhq_ofc_cd) == "NYCNA" || ComGetObjValue(document.form.usr_ofc_cd) == "PKGSC" 
		  || ComGetObjValue(document.form.usr_ofc_cd) == "SELCCS" || ComGetObjValue(document.form.usr_ofc_cd) == "SELCTY"){
		document.getElementById("aloc_sts_cd").style.visibility = "visible";
		document.getElementById("aloc_sts_cd").className = "input2";
	} else {
		document.getElementById("aloc_sts_cd").style.visibility = "hidden";
		document.getElementById("aloc_sts_cd").className = "transgray";
	}*/
	
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	axon_event.addListenerForm  ('click', 'bkg0229_01_click', formObj); // - 클릭시
	axon_event.addListener      ("click", "ctrtType_OnClick", "ctrt_type");
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //키보드 입력할때
	axon_event.addListener      ('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm  ("change", "form_onChange", formObj);
	axon_event.addListenerForm  ('beforedeactivate', 'bkg0229_01_deactivate', formObj); // - 포커스 나갈때
	axon_event.addListenerFormat('beforeactivate', 'bkg0229_01_activate', formObj); // - 포커스 들어갈때

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
 * 
 * @param {IBMultiCombo}
 *            comboObj comboObj
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = false;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = "|";
	if (comboObj.id=="rcv_term_cd" ) {
		comboObj.DropHeight = 250;
		comboObj.SetColWidth("20|80");
	} else if (comboObj.id=="de_term_cd" ) {
		comboObj.DropHeight = 250; 
		comboObj.SetColWidth("20|80");
	} else if (comboObj.id=="rail_blk_cd" ) {
		comboObj.SetColWidth("20|150");
	} else if (comboObj.id=="ida_hlg_tp_cd" ) {
		comboObj.SetColWidth("20|150");
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
  * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
  * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj, sheetNo) {

 	var cnt = 0;

 	switch (sheetNo) {
 	case 1: // t1sheet1 init // bkg쪽 qty
 		//with (sheetObj) { 
 			// 높이 설정
 		sheetObj.style.height = 82;
 			// 전체 너비 설정
 		sheetObj.SheetWidth = mainTable.clientWidth;

 			// Host정보 설정[필수][HostIp, Port, PagePath]
 			if (location.hostname != "")
 				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

 			// 전체Merge 종류 [선택, Default msNone]
 			sheetObj.MergeSheet = msAll;

 			// 전체Edit 허용 여부 [선택, Default false]
 			sheetObj.Editable = true;

 			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			sheetObj.InitRowInfo(1, 1, 4, 100);

 			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			sheetObj.InitColumnInfo(14, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
 			sheetObj.InitHeadMode(true, true, false, true, false, false)

 			var HeadTitle = "|Del.|TP/SZ|Vol.|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|SOC|";

 			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			sheetObj.InitHeadRow(0, HeadTitle, true);

 			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 			// SAVESTATUS, FORMATFIX]
 			var prefix = "sheet1_";
 			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
 			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		30, daCenter, false, "del_chk");
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daCenter, false, "cntr_tpsz_cd", 			false, "", dfNone, 		0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daRight,  false, "op_cntr_qty", 			false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daRight,  false, "eq_subst_cntr_tpsz_cd", 	false, "", dfNone, 		2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daRight,  false, "eq_subst_cgo_qty", 		false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daRight,  false, "rd_cgo_flg", 				false, "", dfNone, 		2, false,false);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daRight,  false, "soc_qty", 				false, "", dfNullFloat, 2, true, true);
 			
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daRight,  false, "crr_hngr_sgl_bar_qty", 	false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daRight,  false, "crr_hngr_dbl_bar_qty", 	false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daRight,  false, "crr_hngr_tpl_bar_qty", 	false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daRight,  false, "crr_hngr_qty", 			false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		50, daRight,  false, "mer_hngr_qty", 			false, "", dfNullFloat, 2, true, true);
 			
 			sheetObj.InitDataProperty(0, cnt++, dtHidden, 		40, daCenter, false, "cntr_tpsz_cd_old", 		false, "", dfNone, 		2, true, true);
 			
 			sheetObj.InitDataValid(0, 2, vtEngUpOther, "0123456789");
 			sheetObj.InitDataValid(0, 4, vtEngUpOther, "0123456789");
 			sheetObj.CountPosition = 0;
 		//}
 		break;

 	case 2: // t1sheet2 init //eBkg qty
 		//with (sheetObj) {
 			// 높이 설정
 		sheetObj.style.height = 82;
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
 			sheetObj.InitRowInfo(1, 1, 3, 100);

 			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			sheetObj.InitColumnInfo(7, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
 			sheetObj.InitHeadMode(true, true, false, true, false, false)

 			var HeadTitle = "|TP/SZ|Vol.|EQ Sub|EQ Sub|EQ Sub|SOC";
// 			var HeadTitle = "|TP/SZ|Q'ty|S.O.C|RD";

 			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			sheetObj.InitHeadRow(0, HeadTitle, true);

 			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 			// SAVESTATUS, FORMATFIX]
 			var prefix = "sheet2_";
 			
 			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "cntr_tpsz_cd", 			false, "", dfNone, 		0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daRight,  false, "cntr_qty", 				false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daRight,  false, "eq_subst_cntr_tpsz_cd", 	false, "", dfNone, 		2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daRight,  false, "eq_subst_cgo_qty", 		false, "", dfNullFloat, 2, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			20, daRight,  false, "rd", 						false, "", dfNone, 		2, false,false);
 			sheetObj.InitDataProperty(0, cnt++, dtData, 			40, daRight,  false, "soc_qty", 				false, "", dfNullFloat, 2, true, true);
 			
// 			InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter, false, "ibflag");
// 			InitDataProperty(0, cnt++, dtData, 			30, daCenter, false, "cntr_tpsz_cd", false, "", dfNone,      0, true, true, 4);
// 			InitDataProperty(0, cnt++, dtData, 			45, daRight,  false, "cntr_qty",	 false, "", dfNullFloat, 2, true, true, 5);
// 			InitDataProperty(0, cnt++, dtData, 			45, daRight,  false, "soc_qty",		 false, "", dfNullFloat, 2, true, true, 5);
// 			InitDataProperty(0, cnt++, dtData, 			45, daRight,  false, "rd", 			 false,	"", dfNullFloat, 2, true, true);
 			CountPosition = 0;
 		//}
 		break;

 	case 3: // t1sheet3 init //bkg vvd
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
 			sheetObj.InitRowInfo(1, 1, 3, 100);

 			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
 			sheetObj.InitColumnInfo(12, 0, 0, true);

 			// 해더에서 처리할 수 있는 각종 기능을 설정한다
 			sheetObj.InitHeadMode(true, true, false, true, false, false)

 			var HeadTitle = "ibflag|vsl_pre_pst_cd|vsl_seq|pol_cd|pol_yd_cd|pod_cd|pod_yd_cd|bkg_vvd_cd|pol_clpt_ind_seq|pod_clpt_ind_seq|eta_day|etd_day";

 			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 			sheetObj.InitHeadRow(0, HeadTitle, true);

 			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
 			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
 			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
 			// SAVESTATUS, FORMATFIX]
 			var prefix = "sheet3_";
 			sheetObj.InitDataProperty(0, cnt++, dtStatus, 40,  daCenter, false,	"ibflag");
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daCenter, false,	"vsl_pre_pst_cd", 	false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daLeft,   false,  "vsl_seq",			false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   100, daLeft,   false,  "pol_cd",			false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   100, daLeft,   false,  "pol_yd_cd",		false, "", dfNone, 0, true, true);
 			
 			sheetObj.InitDataProperty(0, cnt++, dtData,   100, daLeft,   false,  "pod_cd",			false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   100, daLeft,   false,  "pod_yd_cd",		false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   200, daLeft,   false,	"bkg_vvd_cd", 		false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daCenter, false,	"pol_clpt_ind_seq", false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daCenter, false,	"pod_clpt_ind_seq", false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daCenter, false,  "eta_day",         false, "", dfNone, 0, true, true);
 			sheetObj.InitDataProperty(0, cnt++, dtData,   50,  daCenter, false,  "etd_day",         false, "", dfNone, 0, true, true);


 			sheetObj.CountPosition = 0;
 		//}
 		break;

 	case 4: // t1sheet4  (BKG_QTY_DTL)
		//with (sheetObj) {
			// 높이 설정
 		sheetObj.style.height = 0;
			// 전체 너비 설정
 		sheetObj.SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				sheetObj.InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			sheetObj.MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			sheetObj.Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			sheetObj.InitRowInfo(1, 1, 7, 100);

			var HeadTitle1 = "|TP/SZ|DR|DG|RF|AK|BB|S/HGR|D/HGR|T/HGR|M/HGR|EQ SUB TP/SZ|SOC|R|D|VOL";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(16, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet5_";
			
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus, 	40, daCenter, false,	"ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false,	"cntr_tpsz_cd", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"dry_cgo_flg", 				false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40,	daCenter, false,	"dcgo_flg", 				false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"rc_flg", 					false, "", dfNone, 0, true, true);
			
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"awk_cgo_flg", 				false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"bb_cgo_flg", 				false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"crr_hngr_sgl_bar_use_flg", false, "", dfNone, 0, true,	true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"crr_hngr_dbl_bar_use_flg", false, "", dfNone, 0, true,	true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		80, daCenter, false,	"crr_hngr_tpl_bar_use_flg", false, "", dfNone, 0, true,	true);
			
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		80, daCenter, false,	"mer_hngr_flg", 			false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			60, daCenter, false,	"eq_subst_cntr_tpsz_cd", 	false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter, false,	"soc_flg", 					false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daCenter, false,	"rcv_term_cd", 				false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			30, daCenter, false,	"de_term_cd", 				false, "", dfNone, 0, true, true);
			
			sheetObj.InitDataProperty(0, cnt++, dtData, 			55, daRight,  false,	"op_cntr_qty", 				false, "", dfNullFloat, 2, true, true);

			CountPosition = 0; // Total 없음.
		//}
		break;
 	case 5: // t1sheet5 init
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
			sheetObj.InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			sheetObj.InitColumnInfo(4, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			sheetObj.InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "ibflag|rqst_no|rqst_seq|sender_id";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			sheetObj.InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet4_";
			sheetObj.InitDataProperty(0, cnt++, dtHiddenStatus,  30, daCenter, false, "ibflag");
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "rqst_no",		false, "", dfNone, 0, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "rqst_seq",	false, "", dfNone, 2, true, true);
			sheetObj.InitDataProperty(0, cnt++, dtData, 			50, daCenter, false, "sender_id", 	false, "", dfNone, 2, true, true);
			
			sheetObj.CountPosition = 0;
		//}
		break;
 	}
 }

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = 1;
	switch (sAction) {

	case IBSEARCH: // 조회
		// 조회시 validation 할 거 없음
//		if (validateForm(sheetObj, formObj, sAction))
		var sXml = formObj.sXml.value;
		
		var arrXml = sXml.split("|$$|");

		// RCV Term
		if (arrXml.length > 0) ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");		
		// DE Term
		if (arrXml.length > 1) ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");		
		// FRT Term
//		if (arrXml.length > 2) ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");		
		// AMS Filer
		if (arrXml.length > 2) ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");	
		comboObjects[3].InsertItem(0,"","");	
		// CA Filer
		if (arrXml.length > 3) ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");	
		comboObjects[4].InsertItem(0,"","");	
		// Weight Unit
		if (arrXml.length > 4) ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "name");
		// RailBulk
		if (arrXml.length > 5) ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
		// India C/M
		if (arrXml.length > 6) ComBkgXml2ComboItem(arrXml[6], comboObjects[6], "val", "name");
		
		// XTER QTY
		if (arrXml.length > 7) {
			sheetObjects[1].Redraw = false;
			sheetObjects[1].LoadSearchXml(arrXml[7]);
			sheetObjects[1].Redraw = true;
		}

		// ALPS VSL SKD
		if (arrXml.length > 8) {
			sheetObjects[2].Redraw = false;
			sheetObjects[2].LoadSearchXml(arrXml[8]);
			sheetObjects[2].Redraw = true;
		}
		
		// ALPS QTY
		if (arrXml.length > 9) {
			sheetObjects[0].Redraw = false;
			sheetObjects[0].LoadSearchXml(arrXml[9]);
			sheetObjects[0].Redraw = true;
		}	
		
		// ALPS QTY DTL
		if (arrXml.length > 10) {
			sheetObjects[3].Redraw = false;
			sheetObjects[3].LoadSearchXml(arrXml[10]);
			sheetObjects[3].Redraw = true;
		}
		
		
		var rcvTermCd = (ComGetEtcData(arrXml[0], "rcv_term")!=null)?ComGetEtcData(arrXml[0], "rcv_term"):ComGetEtcData(arrXml[0], "rcv_term_cd");
		var deTermCd  = (ComGetEtcData(arrXml[0], "de_term") !=null)?ComGetEtcData(arrXml[0], "de_term") :ComGetEtcData(arrXml[0], "de_term_cd");
		if (ComIsNull(rcvTermCd)) rcvTermCd = formObj.dflt_rcv_term_cd.value;
		if (ComIsNull(deTermCd)) deTermCd  = formObj.dflt_de_term_cd.value;
		
		comboObjects[0].Code2 = rcvTermCd;
		comboObjects[1].Code2 = deTermCd;
//		comboObjects[2].Code2 = ComGetEtcData(arrXml[0], "frt_term_cd");

		formObj.frt_term_cd.value = ComGetEtcData(arrXml[0], "frt_term_cd");  //2011.11.28 jsy
		if(formObj.frt_term_cd.value == "C"){
			formObj.tmp_frt_term_cd.value = "COLLECT";
		} else if(formObj.frt_term_cd.value == "P"){
			formObj.tmp_frt_term_cd.value = "PREPAID";
		}	
		
		comboObjects[2].Code2 = ComGetEtcData(arrXml[0], "usa_cstms_file_cd");
		comboObjects[3].Code2 = ComGetEtcData(arrXml[0], "cnd_cstms_file_cd");
		comboObjects[4].Code2 = ComGetEtcData(arrXml[0], "wgt_ut_cd");

		if (formObj.wgt_ut_cd.value   == null) formObj.wgt_ut_cd.value   = formObj.dflt_wgt_ut_cd.value;
		
		BkgEtcDataXmlToForm(arrXml[0], formObj);		// Booking 기본 정보
		formObj.is_alps_null.value == ComGetEtcData(arrXml[0],"DataYn")=="Y"?"N":"Y";
		formObj.xter_rate_yn.value = ComGetEtcData(arrXml[0],"xterRateYn");

		// qty 없을 경우 default
		if(sheetObjects[0].Rows == 1){
			sheetObjects[0].DataInsert(-1);
			sheetObjects[0].CellValue2(1, "op_cntr_qty") = ComGetEtcData(arrXml[0], "cntr_tpsz_cd");
		}
				
		if(ComGetEtcData(arrXml[0], "rcv_term") != "D") {
			formObj.mty_dor_arr_dt.disabled = true;
		}

		if(ComGetEtcData(arrXml[0], "is_vl_flg")=="Y"&&ComGetEtcData(arrXml[0], "bdr_flg")!="Y"){
			formObj.bkg_pol_cd.disabled    = true;
//			formObj.bkg_pol_yd_cd.disabled = true;
			formObj.bkg_pod_cd.disabled    = true;
//			formObj.bkg_pod_yd_cd.disabled = true;
			if(sheetObjects[1].Rows == 2){
				formObj.bkg_trunk_vvd.disabled = true;
			} else {
				formObj.bkg_trunk_vvd.disabled = false;						
			}
		} else {
			formObj.bkg_pol_cd.disabled    = false;
//			formObj.bkg_pol_yd_cd.disabled = false;
			formObj.bkg_pod_cd.disabled    = false;
//			formObj.bkg_pod_yd_cd.disabled = false;
			formObj.bkg_trunk_vvd.disabled = false;
		}

		if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_nm")) {
			document.all.bkg_cntc_pson_nm.value = document.all.tmp_bkg_cntc_pson_nm.value = ComGetEtcData(arrXml[0], "bkg_cntc_pson_nm");
		}
		if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_phn_no")) {
			document.all.bkg_cntc_pson_phn_no.value = document.all.tmp_bkg_cntc_pson_phn_no.value = ComGetEtcData(arrXml[0], "bkg_cntc_pson_phn_no");	
		}
		if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_mphn_no")) {
			document.all.bkg_cntc_pson_mphn_no.value = document.all.tmp_bkg_cntc_pson_mphn_no.value = ComGetEtcData(arrXml[0], "bkg_cntc_pson_mphn_no");
		}
		if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_fax_no")) {
			document.all.bkg_cntc_pson_fax_no.value = document.all.tmp_bkg_cntc_pson_fax_no.value = ComGetEtcData(arrXml[0], "bkg_cntc_pson_fax_no");
		}
		if (ComGetEtcData(arrXml[0], "bkg_cntc_pson_eml")) {
			document.all.bkg_cntc_pson_eml.value = document.all.tmp_bkg_cntc_pson_eml.value = ComGetEtcData(arrXml[0], "bkg_cntc_pson_eml");
		}
		if (ComGetEtcData(arrXml[0], "si_cntc_pson_nm")) {
			document.all.si_cntc_pson_nm.value = document.all.tmp_si_cntc_pson_nm.value = ComGetEtcData(arrXml[0], "si_cntc_pson_nm");
		}
		if (ComGetEtcData(arrXml[0], "si_cntc_pson_phn_no")) {
			document.all.si_cntc_pson_phn_no.value = document.all.tmp_si_cntc_pson_phn_no.value = ComGetEtcData(arrXml[0], "si_cntc_pson_phn_no");	
		}
		if (ComGetEtcData(arrXml[0], "si_cntc_pson_mphn_no")) {
			document.all.si_cntc_pson_mphn_no.value = document.all.tmp_si_cntc_pson_mphn_no.value = ComGetEtcData(arrXml[0], "si_cntc_pson_mphn_no");
		}
		if (ComGetEtcData(arrXml[0], "si_cntc_pson_fax_no")) {
			document.all.si_cntc_pson_fax_no.value = document.all.tmp_si_cntc_pson_fax_no.value = ComGetEtcData(arrXml[0], "si_cntc_pson_fax_no");
		}
		if (ComGetEtcData(arrXml[0], "si_cntc_pson_eml")) {
			document.all.si_cntc_pson_eml.value = document.all.tmp_si_cntc_pson_eml.value = ComGetEtcData(arrXml[0], "si_cntc_pson_eml");
		}

		if(formObj.bdr_flg.value=="Y"){
			formObj.bkg_no.style.color = "blue"
		} else {
			formObj.bkg_no.style.color = "#606060";
		}	
		// searchVslSkdAvailable 결과값에 따라 Route Detail 버튼색 변경
		changeObjectColor(formObj.vvd_flg, "N", "btn_t1RouteDetail", "red", "btn2");
		
		// 2012.01.05 btn_route의 색이 red가 아닌경우에만 port_skp_flg가 'Y'면 green으로 표시 kbj
		if(formObj.vvd_flg.value != 'N'){
			changeObjectColor(formObj.port_skp_flg.value, "Y", "btn_t1RouteDetail", "00cc00", "btn2");
		}
		
		// searchRfaAvailable 결과에 따라 RFA NO 색 변경
		changeObjectColor(ComGetEtcData(arrXml[0], "rfa_available"), "N", "rfa_no", "red", "input");
		
		// searchScAvailable 결과에 따라 SC NO 색 변경
		changeObjectColor(ComGetEtcData(arrXml[0], "sc_available"), "N", "sc_no", "red", "input");
		
		// searchTaaAvailable 결과에 따라 SC NO 색 변경
		changeObjectColor(ComGetEtcData(arrXml[0], "taa_available"), "N", "taa_no", "red", "input");
		if("Y"==ComGetEtcData(arrXml[0], "xter_rqst_auto_ntc_flg")){
			formObj.auto_notification.checked = true;
			formObj.auto_notification.value = "Y";
		} else {
			formObj.auto_notification.checked = false;
			formObj.auto_notification.value = "N";
		}
		
		changeObjectColor(formObj.bkg_sts_cd.value, "X", "bkg_sts_cd", "red", "input");
		changeObjectColor(formObj.xter_bkg_rqst_sts_cd.value, "X", "xter_bkg_rqst_sts_cd", "red", "input");
		
		// Manual CCT 정보 존재시 파란색 표시
		changeObjectColor(ComGetEtcData(arrXml[0], "mnl_cct_flg"), "Y", "cct_txt", "blue", "btn2");

		if (formObj.alps2.value != "Yes") { //bkg 에 data 없음
//			doDataCopy();			
		} else {
			if (ComTrim(formObj.fnl_dest_nm2.value) != null && ComTrim(formObj.fnl_dest_nm2.value).length > 0) {
				formObj.fnl_dest_nm.value = formObj.fnl_dest_nm2.value.toUpperCase();
			}
			updateRoutStyle(formObj.fnl_dest_nm); 
		}

		formObj.act_wgt.value   = makeComma(formObj.act_wgt.value);
		formObj.estm_wgt2.value = makeComma(formObj.estm_wgt2.value);
		formObj.act_wgt_old.value   = formObj.act_wgt.value;
		
		if ( formObj.doc_tp_cd.value == "S") {
			// Weight QTY
			// Weight 등이 업데이트 되면 M&D TAB 존재 시 Update 하기 위해 method로 뺌
			formObj.act_wgt.value = formObj.estm_wgt2.value;
			form_setEstWgtQty(formObj.estm_wgt2.value);
		}

	    /// 2011.07.05 & 2011.07.11 (C1T0W C1T0M FSELC C1T0S C1S0)
	    if ( formObj.bkg_upld_sts_cd.value == "F" 
	    	&& ( ( formObj.sender_id.value=="C1T0W" )
	    		  || ( formObj.sender_id.value=="C1T0M" ) 
	    		  || ( formObj.sender_id.value=="FSELC" ) 
	    		  || ( formObj.sender_id.value=="C1T0S" )
  	    		  || ( formObj.sender_id.value=="C1T0P" )
	    		  || ( formObj.sender_id.value=="C1S0" )
	    		  || ( formObj.sender_id.value=="T612" )
	    		  || ( formObj.sender_id.value=="T613" )
	    		  || ( formObj.sender_id.value=="T614" )
	    		  || ( formObj.sender_id.value=="T615" )
	    		  || ( formObj.sender_id.value=="T621" )
	    		  || ( formObj.sender_id.value=="T514" )
	    		  || ( formObj.sender_id.value=="T515" )
	    		  || ( formObj.sender_id.value=="T516" )
	    		  || ( formObj.sender_id.value=="T517" )
	    		  || ( formObj.sender_id.value=="T518" )
	    		)
	    	) {
	    	if ( 
//	    			( formObj.frt_term_cd2.value == "" && comboObjects[2].Code != "P" )
//	    			|| ( formObj.frt_term_cd2.value != "" && comboObjects[2].Code != formObj.frt_term_cd2.value )
	    			( formObj.frt_term_cd2.value == "" && formObj.frt_term_cd.value != "P" )
	    			|| ( formObj.frt_term_cd2.value != "" && formObj.frt_term_cd.value != formObj.frt_term_cd2.value )
	    		){
	    		ComShowMessage(ComGetMsg('BKG02085')); ///
	    	}

	    } else {

	    	// Freight Term: PREPAID OR COLLECT
			if (formObj.frt_term_cd2.value == "P" ||
				formObj.frt_term_cd2.value == "PREPAID") {
				formObj.frt_term_cd.value = "P";
			    formObj.tmp_frt_term_cd.value = "PREPAID";
			    
			} else if (formObj.frt_term_cd2.value == "C" ||
				formObj.frt_term_cd2.value == "COLLECT") {
				formObj.frt_term_cd.value = "C";
				formObj.tmp_frt_term_cd.value = "COLLECT";
			// 문제가 있는 것같아서 변경함(2010.06.29 dyryu, CHM-201004295)
			} else if(ComIsNull(ComGetObjValue(formObj.frt_term_cd))){
				formObj.frt_term_cd.value = "P";
			    formObj.tmp_frt_term_cd.value = "PREPAID";		
			} 
//			else {
//				formObj.frt_term_cd.value = "P";
//			    formObj.tmp_frt_term_cd.value = "PREPAID";		
//			}
	    }
	    	
	    if (formObj.bkg_upld_sts_cd.value == "N" || formObj.bkg_upld_sts_cd.value == "H"){
			if (formObj.auto_notification2.value == "Yes") {
				formObj.auto_notification.checked = true;
				formObj.auto_notification.value = "Y";
			} else {
				formObj.auto_notification.checked = false;
				formObj.auto_notification.value = "N";
			}
	    }

		if (formObj.bkg_upld_sts_cd.value == "F"){
			formObj.bkg_sts_nm.style.color = "blue";
		} else if (formObj.bkg_upld_sts_cd.value == "R"){
			formObj.bkg_sts_nm.style.color = "red";
		}

		// Button Enable/Disable Control
		// Upload Status를 Check하고 Booking Status를 Check해야 함
		// Booking Status가 Cancel이더라도, Upload Status에 의해 Enable 될 수 있음	
		top.setBtnEnableSts("btn_alpsupload", true);
		if (formObj.bkg_sts_cd.value == "X" ) {
			top.setBtnEnableSts("btn_alpsupload", false);
		} else if(formObj.bkg_sts_cd.value == "S"
				&& formObj.xter_bkg_rqst_sts_cd.value == "X"){
			top.setBtnEnableSts("btn_alpsupload", false);
		} else {
			if (formObj.bkg_upld_sts_cd.value == "N" ||
				formObj.bkg_upld_sts_cd.value == "P" ||
				formObj.bkg_upld_sts_cd.value == "H" ||				
				ComIsNull(formObj.bkg_upld_sts_cd.value)) {
				top.setBtnEnableSts("btn_alpsupload", true);
			} else {
				top.setBtnEnableSts("btn_alpsupload", false);
			}
		}	
		
		if (    (formObj.aloc_sts_cd.value == "S" || formObj.non_rt_sts_cd.value == "R") && 
				(formObj.doc_tp_cd.value == "S" || formObj.doc_tp_cd.value == "U") &&
				(ComGetObjValue(formObj.bkg_pol_cd).substring(0,2) =="US" || ComGetObjValue(formObj.bkg_pol_cd).substring(0,2) =="CA")){
			top.setBtnColor("btn_alpsupload", "red");
			top.setBtnEnableSts("btn_alpsupload", false);
			//getBtnObject("btn_alpsupload").style.color = "white";
		}
		
		if (formObj.bkg_upld_sts_cd.value == "F" ||
			formObj.bkg_upld_sts_cd.value == "R" ||
			formObj.bkg_upld_sts_cd.value == "D" ||
			formObj.bkg_upld_sts_cd.value == "U") {
			top.setBtnEnableSts("btn_reinstate", true);
		} else {
			top.setBtnEnableSts("btn_reinstate", false);
		}
		
		formObj.dcgo_flg.checked       = "Y"==ComGetEtcData(arrXml[0],"dcgo_flg");
		formObj.dcgo_flg.value         = ComGetEtcData(arrXml[0],"dcgo_flg") ? "Y": "N";
		formObj.rc_flg.checked         = "Y"==ComGetEtcData(arrXml[0],"rc_flg");
		formObj.rc_flg.value           = ComGetEtcData(arrXml[0],"rc_flg") ? "Y": "N";
		formObj.awk_cgo_flg.checked    = "Y"==ComGetEtcData(arrXml[0],"awk_cgo_flg");
		formObj.awk_cgo_flg.value      = ComGetEtcData(arrXml[0],"awk_cgo_flg") ? "Y": "N";
		formObj.bb_cgo_flg.checked     = "Y"==ComGetEtcData(arrXml[0],"bb_cgo_flg");
		formObj.bb_cgo_flg.value       = ComGetEtcData(arrXml[0],"bb_cgo_flg") ? "Y": "N";
		formObj.awk_cgo_flg.checked    = "Y"==ComGetEtcData(arrXml[0],"awk_cgo_flg");
		formObj.awk_cgo_flg.value      = ComGetEtcData(arrXml[0],"awk_cgo_flg") ? "Y": "N";
		formObj.soc_flg.value          = ComGetEtcData(arrXml[0],"soc_flg") ? "Y": "N";
		formObj.spcl_hide_flg.checked  = "Y"==ComGetEtcData(arrXml[0],"spcl_hide_flg");
		formObj.spcl_hide_flg.value    = ComGetEtcData(arrXml[0],"spcl_hide_flg") ? "Y": "N";
		formObj.prct_flg.checked       = "Y"==ComGetEtcData(arrXml[0],"prct_flg");
		formObj.prct_flg.value         = ComGetEtcData(arrXml[0],"prct_flg") ? "Y": "N";
		formObj.fd_grd_flg.checked     = "Y"==ComGetEtcData(arrXml[0],"fd_grd_flg");
		formObj.fd_grd_flg.value       = ComGetEtcData(arrXml[0],"fd_grd_flg") ? "Y": "N";
		formObj.flex_hgt_flg.checked   = "Y"==ComGetEtcData(arrXml[0],"flex_hgt_flg");
		formObj.flex_hgt_flg.value     = ComGetEtcData(arrXml[0],"flex_hgt_flg") ? "Y": "N";
		formObj.edi_hld_flg.checked    = "Y"==ComGetEtcData(arrXml[0],"edi_hld_flg");
		formObj.edi_hld_flg.value      = ComGetEtcData(arrXml[0],"edi_hld_flg") ? "Y": "N";
		formObj.mnl_bkg_no_flg.checked = "Y"==ComGetEtcData(arrXml[0],"mnl_bkg_no_flg");

		ctrtType_OnClick();

		if("WEB"==formObj.xter_rqst_via_cd.value
			|| "EDI"==formObj.xter_rqst_via_cd.value
			|| "GTN"==formObj.xter_rqst_via_cd.value
			|| "INT"==formObj.xter_rqst_via_cd.value
			|| "CSM"==formObj.xter_rqst_via_cd.value ) {
			formObj.copy_esvc.checked = true;
		}
		
		if( formObj.si_cntc_eml2.value != "" && formObj.si_cntc_eml2.value != null){
			formObj.copy_esvc.checked = true;
		}
		doCopyEsvc();
		
		doCopyRefNo();
		
		if(formObj.sh_cust_seq2.value!=null) ComSetObjValue(formObj.sh_cust_seq2, ComLpad(formObj.sh_cust_seq2,6,"0"));
		if(formObj.ff_cust_seq2.value!=null) ComSetObjValue(formObj.ff_cust_seq2, ComLpad(formObj.ff_cust_seq2,6,"0"));
		if(formObj.sh_cust_seq2.value=="000000") ComSetObjValue(formObj.sh_cust_seq2, "");
		if(formObj.ff_cust_seq2.value=="000000") ComSetObjValue(formObj.ff_cust_seq2, "");

		if(formObj.save_rf_flag.value  == "Y") formObj.rc_flg.value = "Y";
		if(formObj.save_dg_flag.value  == "Y") formObj.dcgo_flg.value = "Y";
		if(formObj.save_ak_flag.value  == "Y") formObj.awk_cgo_flg.value = "Y";
		
		if(formObj.tro_pkup_dt.value!=null && formObj.tro_pkup_dt.value!= ""){
			ComSetObjValue(formObj.mty_pkup_dt, formObj.tro_pkup_dt.value);
		}else if(formObj.mty_pkup_dt2.value!=null && formObj.mty_pkup_dt2.value!= ""){
			ComSetObjValue(formObj.mty_pkup_dt, formObj.mty_pkup_dt2.value);
		}

		ComSetObjValue(formObj.modify_flag, 			"N");
		ComSetObjValue(formObj.cgo_dtl_auto_flg, 		"Y");
		ComSetObjValue(formObj.carge_detail_pop, 		"Y");
		ComSetObjValue(formObj.partial_vvd_opened_flg, 	"N");
	  	ComSetObjValue(formObj.route_modify_flag, 		"N");
	  	ComSetObjValue(formObj.customer_modify_flag, 	"N");
	  	ComSetObjValue(formObj.contact_modify_flag, 	"N");
	    ComSetObjValue(formObj.qty_modify_flag, 		"N");
	    ComSetObjValue(formObj.ts_close_bkg_flag, 		"N");
	    ComSetObjValue(formObj.close_bkg_flag,			"N");
	    ComSetObjValue(formObj.check_ts_close_flag, 	"N");
	    ComSetObjValue(formObj.closed_ts_vvd, 			"N");
	    ComSetObjValue(formObj.cbf_bkg_flag,			"N");
	    // 조회 성공이면 route 있는 것으로 판단
	    if(!ComIsNull(formObj.old_bkg_no.value)){
	    	manageHaveRouteFlag("Y");
	    } else {
		  	ComSetObjValue(formObj.route_modify_flag, "Y");
	    	manageHaveRouteFlag("N");	    	
	    }

		top.document.form.tabload1.value = "LOAD";
		
		//양쪽 값 비교하여 색 처리
		compareItem();
		compareQty();		

		sheetObjects[0].SelectCell(0,1);
		
		var xter_doc = "N";
		if (!ComIsNull(document.all.wy_bl_flg.innerHTML) ) {
			xter_doc = "Y";
		} else if (!ComIsNull(document.all.incl_rt_bl_knt.innerHTML)) {
			xter_doc = "Y";
		} else if (!ComIsNull(document.all.xcld_rt_bl_knt.innerHTML)) {
			xter_doc = "Y";
		} else if (!ComIsNull(document.all.bl_iss_loc_cd.innerHTML)) {
			xter_doc = "Y";
		} else if (!ComIsNull(document.all.bl_iss_dt.innerHTML)) {
			xter_doc = "Y";
		}

		oldPolYdCd = formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
		oldPodYdCd = formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
		
		getBtnObject("btn_docRequirement2").style.color = (xter_doc=="Y")?"blue":"#737373";
		
		// Sales Approval
		changeObjectColor(ComGetEtcData(arrXml[0], "new_cust_apro_mark_flg"), "Y", "btn_t1SalesApproval", "blue", "btn2");
		
		var vslNm = ComGetEtcData(arrXml[0], "vsl_nm");
		if (vslNm) {
			formObj.vsl_eng_nm.value = vslNm;
		}
		// BKG_BOOKING에 저장된 stwg_cd  
		formObj.stwg_cd_tmp.value = formObj.stwg_cd.value;
        // Allocation Flag		
		formObj.aloc_chk_flg.value =  "N";
		
		route_detail_modify_flag = "";
		
		
		//if(formObj.cuYn.value=='Y'||formObj.cnYn.value=='Y'||formObj.mdYn.value=='Y'||formObj.cmYn.value=='Y'){
		//	top.setBtnColor("btn_Chk_Point", "red");
		//}
		
		var bkgPorCd   = ComGetObjValue(formObj.bkg_por_cd);
		var bkgPolCd   = ComGetObjValue(formObj.bkg_pol_cd);
		var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
		var railBlkCd = ComGetObjValue(formObj.rail_blk_cd);
				
		if(railBlkCd==""){
			if( bkgPolCd.substring(0,2)=="US" && bkgPolCd!=bkgPorCd){
				if(cmdtCd =="740302" ||cmdtCd =="810001"||cmdtCd =="720400"||cmdtCd =="760300"){				
					comboObjects[5].Code2 = "S";
				} else if(cmdtCd =="980035" ||cmdtCd =="230330"||cmdtCd =="980034"||cmdtCd =="070002"||cmdtCd =="100100"||cmdtCd =="980031"){			
					comboObjects[5].Code2 = "G";
				} else {
					comboObjects[5].Code2 = "";
				}
			}
		}

		var hndlOfcCd = ComGetObjValue(formObj.hndl_ofc_cd);
		//CHM-201538473 e-Booking & S/I Process 메뉴 보완 : POR US/CA 이고 NYCSC Handling office일 경우에 한해 RFA No. 저장허용
		if(bkgPorCd.substring(0,2)=="US"||bkgPorCd.substring(0,2)=="CA"){
			if(hndlOfcCd != "NYCSC"){
				formObj.rfa_no.readOnly =true;
			}			
		}
		
		break;
		
	case SEARCH04://btn_find_bkg		
		var sXml = formObj.sXml.value;
		var params = "";
		formObj.f_cmd.value = SEARCH04;
		
		sheetObj.WaitImageVisible = false
		var param = "f_cmd="+SEARCH04+"&bkg_no="+formObj.bkg_no.value;
		sXml = sheetObj.GetSaveXml("ESM_BKG_0229_01GS.do", param, false);

		var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
		
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			return false;
		}		
		
		top.document.form.bkg_no.value = formObj.bkg_no.value;
		top.reloadPage();
		
		break;
			
		// 전체 한 번에 저장으로 변경됨
//	case COMMAND01: // BKG 탭만 저장 - 개발 중간에 손쉬운 DEBUG를 위해 DIVIDE AND QUONQUER
//		if (validateForUpload() == false) return;
//		var params = getSaveStringForUpload();
//		
//		ComOpenWait(true);
//		var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0229_01GS.do", params);
//		ComOpenWait(false);
//		
//		var arrXml = sXml.split("|$$|");
//		if (arrXml.length > 0){	
//			sheetObjects[2].LoadSearchXml(arrXml[0]);
//		}      			
//		if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
//			ComBkgSaveCompleted();
//			
//			if(ComGetEtcData(sXml, "bkg_no") != undefined){
//				ComResetAll();
//				formObj.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
//				top.document.form.bkg_no.value = formObj.bkg_no.value;
//				top.reloadPage();
//			}
//		}
//
//		break;
		
		//0229.js로 옮겨짐
//	case COMMAND02: // 전체 탭 저장
//		// 전체 탭의 정보를 Array로 관리 함
//		// save flag 이름, frame 이름, tab별 prefix, savestring이 담길 자리
//		var tabs = new Array (
//				new Array ("save_bkg_flag",		"t1frame", "t1_", ""), // ESM_BKG_0229_01
//				new Array ("save_cust_flag",	"t2frame", "t2_", ""), // ESM_BKG_0229_02
//				new Array ("save_cntr_flag",	"t3frame", "t3_", ""), // ESM_BKG_0229_03
//				new Array ("save_mnd_flag",		"t4frame", "t4_", ""), // ESM_BKG_0229_04
//				new Array ("save_cm_flag",		"t5frame", "t5_", ""), // ESM_BKG_0229_05
//				new Array ("save_tro_flag",		"t6frame", "t6_", ""), // ESM_BKG_0229_06
//				new Array ("save_rf_flag",		"t7frame", "t7_", ""), // ESM_BKG_0229_07
//				new Array ("save_dg_flag",		"t8frame", "t8_", ""), // ESM_BKG_0229_08
//				new Array ("save_ak_flag",		"t9frame", "t9_", ""), // ESM_BKG_0229_09
//				new Array ("save_hbl_flag",		"t10frame", "t10_", ""), // ESM_BKG_0229_10
//				new Array ("save_hbl2_flag",	"t11frame", "t11_", "") // ESM_BKG_0229_11
//				);
//
//		// SI이고 TRO, RF, DG, AK 중 하나라도 포함되어 있으면,
//		// 사용자에게 해당 TAB도 업로드 시킬 것인지 확인 메시지를 보여 줌
//		var includeTroRfDgAk = true;
//		if (formObj.doc_tp_cd.value == "S" &&
//				(formObj.save_tro_flag.value == "Y" ||
//				 formObj.save_rf_flag.value  == "Y" ||
//				 formObj.save_dg_flag.value  == "Y" ||
//				 formObj.save_ak_flag.value  == "Y")
//			) {
//			if (ComShowCodeConfirm("BKG02037") == false) {
//				includeTroRfDgAk = false;
//			}
//		}
//		
//		// 전체 탭 수 만큼  반복하며 SAVE가 요구되는 경우, validation 함수와 SC에 올릴 parameter 를 받음
//		for (var i = 0; i < tabs.length; i++) {
//			if (document.getElementsByName(tabs[i][0])[0].value == "Y") {
//				// TRO, RF, DG, AK를 같이 안 올리겠다고 사용자가 확인한 경우
//				// Upload 하지 않는다.
//				if (includeTroRfDgAk == false && (tabs[i][0] == "save_tro_flag" ||
//												  tabs[i][0] == "save_rf_flag" ||
//												  tabs[i][0] == "save_dg_flag" ||
//												  tabs[i][0] == "save_ak_flag")) {
//					continue;
//				}
//				
//				if (parent.document.frames(tabs[i][1]).validateForUpload() == false) {
//					return false;
//				}
//				tabs[i][3] = parent.document.frames(tabs[i][1]).getSaveStringForUpload();
//			}
//		}
//		
//		// 각 탭에서 받은 parameter 를 합침
//		formObj.f_cmd.value = COMMAND02;
//
//		var params = "";
//		for (var i = 0; i < tabs.length; i ++) {
//			// getSaveStringForUpload로 SaveString이 있는 경우
//			if (tabs[i][3] != "") {
//				// 각 탭의 parameter를 구분하기 위해 Prefix를 덧 붙여 paramter를 합한다
//				params = params + "&" + ComSetPrifix(tabs[i][3], tabs[i][2]);
//			}
//		}
//		// 각 탭에서 SaveString을 받을 때 이미 encoding 된 data를 받으므로 이중으로 encoding하지 않기 위해
//		// 마지막에 false를 argument로 넘김
//		ComOpenWait(true);
//		var sXml = sheetObjects[2].GetSaveXml("ESM_BKG_0229_01GS.do", params, false);
//		ComOpenWait(false);
//		
//		
//		// 성공했으면 성공 메시지를 보여 줌
//		if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
//			ComShowCodeMessage("BKG00166");
//			top.document.form.bkg_no.value = formObj.bkg_no.value;
//			top.reloadPage();
///*			if(ComGetEtcData(sXml, "bkg_no") != undefined){
//				ComResetAll();
//				formObj.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
//				top.document.form.bkg_no.value = formObj.bkg_no.value;
//				top.reloadPage();
//			}*/
//		}
//		// 실패했으면 실패 메시지를 보여 줌
//		// 실패 탭으로 자동으로 옮겨줬으면 좋겠는데 방법을 찾아봐야 할 듯
//		else {
//			sheetObjects[2].LoadSaveXml(sXml);
//		}
//		
//		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch(sAction) {
	case IBSEARCH_ASYNC02://Reinstate
//		if(!ComIsNull(formObj.xter_rqst_acpt_cd.value)){
//			if("R" == formObj.xter_rqst_acpt_cd.value){//rejected
//				ComShowCodeMessage("BKG02056",formObj.xter_rqst_acpt_usr_nm.value);
//				return false;
//			}
//		}
		return true;
		break;
	case COMMAND03://cancel
		if(ComGetObjValue(formObj.cntr_flg) == "Y"){		
			if(ComShowCodeConfirm("BKG02054")){
				return true;
			}
		} else {
			if(ComShowCodeConfirm("BKG00670")){
				return true
			}
		}
		return false;  
		break;		
	case COMMAND01: // 저장
		// Save를 하기 위해 화면 상에 값들을 정리한다.
		acceptText();	
		var bkgNo = formObj.bkg_no.value;
		
		if (!ComChkObjValid(formObj.mty_pkup_dt)){
			ComSetFocus(formObj.mty_pkup_dt);
			return false;
		}
		
		if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 시
			ComShowCodeMessage("BKG00005");
			return false;
		}
		if(ComGetObjValue(formObj.bkg_sts_nm) == "Confirm"){
			ComShowCodeMessage("BKG02049");
			return false;
		}
		
		if(!ComIsNull(formObj.xter_rqst_acpt_cd.value)){
			if("R" == formObj.xter_rqst_acpt_cd.value){//rejected
				ComShowCodeMessage("BKG02056",formObj.xter_rqst_acpt_usr_nm.value);
				return false;
			}
		}
		
		//마지막 두 자리가 숫자가 아닌 경우
		var mnlBkgNoChk = ComGetObjValue(formObj.bkg_no);
		if(!ComIsNull(mnlBkgNoChk) && !ComIsNumber(mnlBkgNoChk.substr(mnlBkgNoChk.length-2 ))) {
			ComShowCodeMessage("BKG02096");
			return false;
		}
		//I,O 가 사용된 경우
		if(!ComIsNull(mnlBkgNoChk) && ComIsContainsChars(mnlBkgNoChk.substr(4).toUpperCase(),"IO" ) ) {
			ComShowCodeMessage("BKG02096");
			return false;
		}
		//mnl bkg 생성시 4자리 이상, 10자리 입력으로 변경 
		//if(formObj.mnl_bkg_no_flg.value == "Y" && ComIsNull(formObj.old_bkg_no.value)){
		if(formObj.mnl_bkg_no_flg.checked == true && ComIsNull(formObj.old_bkg_no.value)){			
			var mnlBkgNo = ComGetObjValue(formObj.bkg_no);
			if(mnlBkgNo.length != 10 && mnlBkgNo.length != 12){
				ComShowCodeMessage("BKG00255");
				ComSetFocus(formObj.bkg_no);
				return false; 
//			} else if(mnlBkgNo < 5){
//				ComShowCodeMessage("BKG00255");
//				ComSetFocus(formObj.bkg_no);
//				return false;   					
			}
			
		}  			

		if(!ComIsNull(formObj.old_bkg_no) && ComGetObjValue(formObj.old_bkg_no) != ComGetObjValue(formObj.bkg_no)){	// 조회없이 Booking 번호만 변경시
			ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
			return false;    				
		}
		if(ComIsNull(formObj.act_wgt.value)){
			ComShowCodeMessage("BKG00014");
			ComSetFocus(formObj.act_wgt);
			return false;			
		}
		if(parseFloat(ComGetObjValue(formObj.act_wgt),10) <= 0){	// Weight에 '0' 입력
			ComShowCodeMessage("BKG00014");
			ComSetFocus(formObj.act_wgt);
			return false;
		}

		if(ComIsNull(formObj.wgt_ut_cd.value)){
			ComShowCodeMessage("BKG00015");
			return false;			
		}
		var wgtUtCd = ComGetObjValue(formObj.wgt_ut_cd)
		if(ComTrim(wgtUtCd) == ""){							// Weight Unit 미입력
			ComShowCodeMessage("BKG00015");
			return false;    				
		}
		
		if (ComChkLen(formObj.cmdt_cd, 6) != 2){	// Commodity Code 6자리 아닌경우
			ComShowCodeMessage("BKG00010");		
			ComSetFocus(formObj.cmdt_cd);
			return false;
		}
		if (ComIsNull(formObj.cmdt_desc)){	// Commodity Name이 조회되지 않은 경우
			ComShowCodeMessage("BKG00010");		
			ComSetFocus(formObj.cmdt_desc);
			return false;    			    				
		}

		if(!ComIsNull(formObj.rep_cmdt_cd) && ComChkLen(formObj.rep_cmdt_cd, 4) != 2){	// Rep Commodity Code 4자리 아닌경우
			ComShowCodeMessage("BKG00011");		
			return false;    			    				    				
		}    			

		var rfaNo = ComGetObjValue(formObj.rfa_no);
		var scNo = ComGetObjValue(formObj.sc_no);
		var taaNo = ComGetObjValue(formObj.taa_no);
		if(rfaNo.length < 1 && scNo.length < 1 && taaNo.length<1){
			ComShowCodeMessage("BKG00016");		
			return false;    		    				
		}
		
		//실제 계약이 입력된 경우, dummy 계약이 입력되어 있으면
		if((scNo.length>0&&scNo.substring(0,3)!="DUM")||
			(rfaNo.length>0&&rfaNo.substring(0,3)!="DUM")||
			(taaNo.length>0&&taaNo.substring(0,3)!="DUM")){
			if((scNo.length>0&&scNo.substring(0,3)=="DUM")||
				(rfaNo.length>0&&rfaNo.substring(0,3)=="DUM")||
				(taaNo.length>0&&taaNo.substring(0,3)=="DUM")){
				ComShowCodeMessage("BKG02050");
				return false;
			}
		}
		
		if(!ComIsNull(formObj.rfaNo)&&!ComIsNull(formObj.taaNo)){
			ComShowCodeMessage("BKG00016");    				
			return false;
		}
		
		if(ComIsNull(formObj.s_cust_cnt_cd)){		// SHPR 입력값 체크
			if(!ComIsNull(formObj.s_cust_seq)){
				ComShowCodeMessage("BKG00008");	// 국가코드 없이 Customer코드만 있는 경우	
				ComSetFocus(formObj.s_cust_cnt_cd);	
				return false;    	    					
			}
		}else{
			if(ComChkLen(formObj.s_cust_cnt_cd, 2) != 2){	// 국가코드가 2자리 아닌 경우
				ComShowCodeMessage("BKG00008");		
				ComSetFocus(formObj.s_cust_cnt_cd);
				return false;    	      					
			}
			if(ComIsNull(formObj.s_cust_seq) || ComGetObjValue(formObj.s_cust_seq) == "0"){	// Customer 코드가 없거나 '0' 인 경우
				ComShowCodeMessage("BKG00008");	
				ComSetFocus(formObj.s_cust_seq);	
				return false;    	        					
			}    					
		}
		if(ComIsNull(formObj.f_cust_cnt_cd)){		// FWDR 입력값 체크
			if(!ComIsNull(formObj.f_cust_seq)){
				ComShowCodeMessage("BKG00293");	// 국가코드 없이 Customer코드만 있는 경우
				ComSetFocus(formObj.f_cust_seq);		
				return false;    	    					
			}
		}else{
			if(ComChkLen(formObj.f_cust_cnt_cd, 2) != 2){	// 국가코드가 2자리 아닌 경우
				ComShowCodeMessage("BKG00293");		
				ComSetFocus(formObj.f_cust_cnt_cd);
				return false;    	      					
			}
			if(ComIsNull(formObj.f_cust_seq) || ComGetObjValue(formObj.f_cust_seq) == "0"){	// Customer 코드가 없거나 '0' 인 경우
				ComShowCodeMessage("BKG00293");		
				ComSetFocus(formObj.f_cust_seq);
				return false;    	        					
			}   				
		}    

		if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.f_cust_cnt_cd)){		// SHPR,FWDR 모두 미입력
			ComShowCodeMessage("BKG01012");		
			ComSetFocus(formObj.s_cust_cnt_cd);
			return false;
		}
		// TP/SZ 입력여부 확인 및 동일한 CntrTpSz 입력여부 판단    			
		if(!chkCntrTpSz()){
			return false;
		}

		var tpSzA = false;
		var tpSzQ = true;
		for(i = 1 ; i < sheetObjects[0].Rows ; i++){
			tpSz = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");   
			if("D"==sheetObjects[0].RowStatus(i)){
				continue;
			}   				
			if(tpSz != "Q2" && tpSz != "Q4"){
				tpSzQ = false;
			}
			if(tpSz == "A2" || tpSz == "A4" || tpSz == "A5"){
				tpSzA = true;
			}
			
			if(sheetObjects[0].CellValue(i, "op_cntr_qty") == 0){
				ComShowCodeMessage("BKG00013");		// VOL에 0 입력한 경우
				return false;    	            					
			}
			
			if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") != "" && BkgParseFloat(sheetObjects[0].CellValue(i, "eq_subst_cgo_qty")) <= 0 ){
				ComShowCodeMessage("BKG02010");		
				return false;
			}
		}

		
		if(tpSzQ){
			ComShowCodeMessage("BKG01013");		// Q2,Q4 만 입력된 경우
			return false;    	        	     				
		}

		if(ComChkLen(formObj.bkg_por_cd, 5) != 2){
			ComShowCodeMessage("BKG00006");		// POR 5자리 미만으로 입력
			ComSetFocus(formObj.bkg_por_cd);
			return false;    	    				
		}
		
		if(ComChkLen(formObj.bkg_pol_cd, 5) != 2){
			ComShowCodeMessage("BKG00288");		// POL 5자리 미만으로 입력
			ComSetFocus(formObj.bkg_pol_cd);
			return false;    	    				
		}
		
		if(ComChkLen(formObj.bkg_del_cd, 5) != 2){
			ComShowCodeMessage("BKG00290");		// DEL 5자리 미만으로 입력
			ComSetFocus(formObj.bkg_del_cd);
			return false;    	    				
		}    
    			
		/*미주향일때 AMS Validation 로직 추가 2010.1.14 전창현*/
		if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US"){
			var usaFile = ComGetObjValue(formObj.usa_cstms_file_cd)
			if(ComIsNull(usaFile) && ComChkLen(usaFile, 1) !=2 ){
				ComShowCodeMessage("BKG00283");		// 미주로 가는데  ams 안넣은 경우 선 validation
				return false; 
			}   	    				
		}   

		if(ComIsNull(formObj.pre_rly_port_cd) || ComIsNull(formObj.pst_rly_port_cd)){
			if(ComGetObjValue(formObj.bkg_pol_cd) == ComGetObjValue(formObj.bkg_pod_cd)){
				ComShowCodeMessage("BKG00053");		// PRE/POST 미입력인데 POL,POD가 동일
				ComSetFocus(formObj.bkg_pol_cd);
				return false;    	    				    					
			}
		}
		
		var rcvTerm = ComGetObjValue(formObj.rcv_term_cd);
		if(rcvTerm.length < 1){ // RCVTERM 미입력한 경우
			ComShowCodeMessage("BKG00908");		
			return false;    		    		
		}
		var delTerm = ComGetObjValue(formObj.de_term_cd);
		if(delTerm.length < 1){ // DELTERM 미입력한 경우
			ComShowCodeMessage("BKG00909");		
			return false;    		    		
		}

		if(!checkEgyptDeTerm(ComGetObjValue(formObj.bkg_del_cd))){
			ComSetFocus(formObj.bkg_del_cd);
			return false;		// DEL이 'EGALY','EGPSD'인데 DLV Term이 'O'가 아닌경우
		}    
		
		if(!checkTanzaniaDeTerm(ComGetObjValue(formObj.bkg_pod_cd), ComGetObjValue(formObj.bkg_del_cd), "check")){
			ComSetFocus(formObj.bkg_del_cd);	
			return false;
		}  
		
		/* 박유숙 부장님 요청 주석 2017.04.27 IS.Jung
		if(!checkThailandDeTerm(ComGetObjValue(formObj.bkg_pod_cd), ComGetObjValue(formObj.bkg_del_cd), "check")){
			ComSetFocus(formObj.dlv_term);	
			return false;
		} 
		*/
		if(!checkMaltaTerm(ComGetObjValue(formObj.bkg_pol_cd), ComGetObjValue(formObj.bkg_pod_cd))){
			return false;
		}
		
		rcvTerm = ComGetObjValue(formObj.rcv_term_cd);
		delTerm = ComGetObjValue(formObj.de_term_cd);
		
		// TPSZ는 한가지, MIXED Term 선택시 Vol이 1이하이면 에러
		if(sheetObjects[0].RowCount == 1){
			if(parseFloat(sheetObjects[0].CellValue(1,"op_cntr_qty")) <= 1){
				if(rcvTerm == "M" || delTerm == "M"){
					ComShowCodeMessage("BKG00298");		// TPSZ는 한가지, MIXED Term 선택시
					return false;    	     					
				}    	    					
			}			
		}    			
		
		if(rcvTerm == "T" || rcvTerm == "I"){
			if(ComGetObjValue(formObj.bkg_por_cd) != ComGetObjValue(formObj.bkg_pol_cd)){
				ComShowCodeMessage("BKG00270");		// RCV가 Trackle,Free In이면 POR,POL은 동일
				return false;      					
			}
		}
		
		if(delTerm == "T" || delTerm == "O"){
			if(ComGetObjValue(formObj.bkg_pod_cd) != ComGetObjValue(formObj.bkg_del_cd)){
				ComShowCodeMessage("BKG00271");		// DLV가 Trackle,Free In이면 POD,DEL은 동일
				return false;      					
			}
		}
		
		// T.VVD와 T/S Route의 T.VVD와 다른경우
		if(sheetObjects[2].RowCount > 0){ // t/s route 입력된 경우에만 확인
			if(!ComIsNull(formObj.bkg_trunk_vvd.value) && formObj.bkg_trunk_vvd.value != sheetObjects[2].CellValue(sheetObjects[2].FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd")){
				ComShowCodeMessage("BKG00022", ComGetObjValue(formObj.bkg_trunk_vvd));		
				ComSetFocus(formObj.bkg_trunk_vvd);
				return false;      		    				
			}    			
		}
		for(i = 1 ; i < sheetObjects[1].Rows ; i++){
			if(!ComIsNull(sheetObjects[2].CellValue(i, "bkg_vvd_cd")) && ComChkLen(sheetObjects[2].CellValue(i, "bkg_vvd_cd"), 9) != 2){
				ComShowCodeMessage("BKG00051", sheetObjects[2].CellValue(i, "bkg_vvd_cd"));		//VVD 9자리 체크
				ComSetFocus(formObj.bkg_trunk_vvd);
				return false;       					
			}
		}

		// VVD 미입력 이거나 Pseudo VVD 인데 MT DOOR ARRIVAL DATE,Sailing DUE DATE가 없는경우
		if(ComIsNull(formObj.bkg_trunk_vvd)){
			if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
				ComShowCodeMessage("BKG00017");
				ComSetFocus(formObj.lodg_due_dt);
				return false;      		    					
			}
		}
		else {
			if(ComChkLen(formObj.bkg_trunk_vvd, 9) != 2){
				ComShowCodeMessage("BKG00051", ComGetObjValue(formObj.bkg_trunk_vvd));		//VVD 9자리 체크
				ComSetFocus(formObj.bkg_trunk_vvd);
				return false;      					
			}
			var pseudoVvd = ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
			if(pseudoVvd == "HJXX" || pseudoVvd == "HJYY" || pseudoVvd == "HJZZ"){
				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
    				ComShowCodeMessage("BKG00017");
					ComSetFocus(formObj.logd_due_dt);
    				return false;      		    					
				}    					
			}    				
		}
		if(rfaNo.length < 1 && scNo.length < 1&& taaNo.length < 1){
			ComSetFocus(formObj.scNo);
			ComShowCodeMessage("BKG00016");		
			return false;    		    				
		}
		
		//실제 계약이 입력된 경우, dummy 계약이 입력되어 있으면
		if((scNo.length>0   && scNo.substring(0,3) !="DUM")||
			(rfaNo.length>0 && rfaNo.substring(0,3)!="DUM")||
			(taaNo.length>0 && taaNo.substring(0,3)!="DUM")){
			if((scNo.length>0   && scNo.substring(0,3) =="DUM")||
				(rfaNo.length>0 && rfaNo.substring(0,3)=="DUM")||
				(taaNo.length>0 && taaNo.substring(0,3)=="DUM")){
				ComShowCodeMessage("BKG02050");
				return false;
			}
		}

		if(formObj.rc_flg.checked){	// Reefer 인 경우 'R2',;R4','R5' 존재해야함.
			if(sheetObjects[0].FindText("cntr_tpsz_cd","R",0,false) < 0){
				ComShowCodeMessage("BKG00054");
				return false;      	    					
			}
		}

		for(i = 1 ; i < sheetObjects[0].Rows ; i++){
			// 'R2',;R4','R5' 존재하고 RD_CGO_FLG가 'RD'가 아니면 Reefer 체크해야함. (20090819 수정)    				
			if(sheetObjects[0].CellValue(i, "cntr_tpsz_cd").substring(0,1) == "R" && (sheetObjects[0].CellValue(i, "rd_cgo_flg") != "RD" || sheetObjects[0].CellValue(i, "op_cntr_qty") != sheetObjects[0].CellValue(i, "eq_subst_cgo_qty"))){
				if(!formObj.rc_flg.checked){
					ComShowCodeMessage("BKG01015");
					return false;      	    					
				}    			    					
			}    
		}

		if (!chkReeferDry()) {
			ComShowCodeMessage("BKG02066");
			return false;
		}

		// 20091130 Customer Inquiry Popup 조건 변경 (L.OFC,L.REP 둘다 미존재시 팝업) -> S.rep만으로 변경
		if(ComIsNull(formObj.ob_srep_cd)){
//			ComShowCodeMessage("BKG00337");
			if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
				comBkgCallPop0652('callBack0652', 'F', formObj.f_cust_cnt_cd.value, formObj.f_cust_seq.value, (ComIsNull(formObj.f_cust_seq.value)?(formObj.f_cust_nm.value.substring(0,10)):""));
			} else {
				comBkgCallPop0652('callBack0652', 'S', formObj.s_cust_cnt_cd.value, formObj.s_cust_seq.value, (ComIsNull(formObj.s_cust_seq.value)?(formObj.s_cust_nm.value.substring(0,10)):""));
			}

			if(ComIsNull(formObj.ob_sls_ofc_cd)){
				return false;
			}
		}

		if(ComChkLen(formObj.ob_srep_cd, 5) != 2){
			ComShowCodeMessage("BKG00044");		// L.Rep 5자리 미만으로 입력
			return false;    				
		}
		
		//vol detail 관련 logic
		// CntrTpSz가 변경되면 QtyDtl에 반영한다.
		if(ComGetObjValue(formObj.carge_detail_pop)!="Y" || checkAutoCaluate(formObj)){
			resetQtyDetail();
		}
		// RD,SOC,EQ SUB Flag Setting
		setRdSocEqSubFlg(formObj);
		
		if(ComGetObjValue(formObj.carge_detail_pop) != "Y"){
			if(ComGetObjValue(formObj.rcv_term_cd_old) != "M" && ComGetObjValue(formObj.rcv_term_cd) == "M"){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.	
			}
			if(ComGetObjValue(formObj.de_term_cd_old) != "M" && ComGetObjValue(formObj.de_term_cd) == "M"){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}    			
			if(ComGetObjValue(formObj.dcgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.dcgo_flg),"N")){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}        	
			if(ComGetObjValue(formObj.rc_flg_old) != BkgNullToString(ComGetObjValue(formObj.rc_flg),"N")){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}        	
			if(ComGetObjValue(formObj.awk_cgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.awk_cgo_flg),"N")){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}        	
			if(ComGetObjValue(formObj.bb_cgo_flg_old) != BkgNullToString(ComGetObjValue(formObj.bb_cgo_flg),"N")){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}        	    
		}

		// Carge Detail Information 자동 PopUp
		if(ComGetObjValue(formObj.cgo_dtl_auto_flg) != "Y"){
			if(!checkAutoCaluate(formObj)){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");
				comBkgCallPop0890("callBack0890","Y");
				return false;
			}    				
		}

		// 20090909 추가 - Hanger에서 지정된 hanger TP 별 개수와 차이가 있는 경우 SAVE 금지.(BKG02007)    			
		// 20090909 추가 - 지정된 TP/SZ별 EQ-Sub와 volume이 맞지 않는 경우 SAVE 금지.(BKG02008)    			
		// 20090909 추가 - Booking의 TP/SZ 별 합과 EQ Detail에서의 TP/SZ별 합이 다른 경우 SAVE 금지.(BKG03009)        			
		for(var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++){
			var sumSingle = 0;
			var sumDouble = 0;
			var sumTriple = 0;
			var sumMer = 0;
			var eqSubVol = 0;
			var sumEqDtlVol = 0;
			for(var j = sheetObjects[3].HeaderRows ; j < sheetObjects[3].Rows ; j++){
				if(sheetObjects[0].CellValue(i, "cntr_tpsz_cd") == sheetObjects[3].CellValue(j, "cntr_tpsz_cd")){
					if(sheetObjects[3].CellValue(j, "crr_hngr_sgl_bar_use_flg") == 1){
						sumSingle = sumSingle + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));	
					}
					if(sheetObjects[3].CellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
						sumDouble = sumDouble + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
					}
					if(sheetObjects[3].CellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
						sumTriple = sumTriple + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
					}
					if(sheetObjects[3].CellValue(j, "mer_hngr_flg") == 1){
						sumMer = sumMer + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
					}				
					
					if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
						if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[3].CellValue(j, "eq_subst_cntr_tpsz_cd")){
							eqSubVol = eqSubVol + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
						}    							
					}	
					sumEqDtlVol = sumEqDtlVol + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
				}				
			}    				
			if(BkgParseFloat(sheetObjects[0].CellValue(i, "crr_hngr_sgl_bar_qty")) != sumSingle){
				ComShowCodeMessage("BKG02007");
				return false;
			}

			if(BkgParseFloat(sheetObjects[0].CellValue(i, "crr_hngr_dbl_bar_qty")) != sumDouble){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[0].CellValue(i, "crr_hngr_tpl_bar_qty")) != sumTriple){
				ComShowCodeMessage("BKG02007");
				return false;
			} 
			if(BkgParseFloat(sheetObjects[0].CellValue(i, "mer_hngr_qty")) != sumMer){
				ComShowCodeMessage("BKG02007");
				return false;
			}    			
			if(BkgParseFloat(sheetObjects[0].CellValue(i, "eq_subst_cgo_qty")) != eqSubVol){
				ComShowCodeMessage("BKG02008", sheetObjects[0].CellValue(i, "cntr_tpsz_cd"));
				return false;    					
			}
			if(BkgParseFloat(sheetObjects[0].CellValue(i, "op_cntr_qty")) != sumEqDtlVol){
				ComShowCodeMessage("BKG03009", sheetObjects[0].CellValue(i, "cntr_tpsz_cd"), sheetObjects[0].CellValue(i, "cntr_tpsz_cd"));
				comBkgCallPop0890("callBack0890","Y");
				return false;    					
			}    				
		}		    
		// Partial VVD 변경 PopUp 호출
//		if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
//			comBkgCallPop1024("callBack1024", bkgNo);
//			
//			if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
//				return false;
//				
//			}
//		}

		// 2013.06.26 email address 형식 validation
		var emlArr = null;
		if(ComGetObjValue(formObj.bkg_cntc_pson_eml) != ""){
			emlArr = ComGetObjValue(formObj.bkg_cntc_pson_eml).split(";");
			for(var i = 0; i < emlArr.length; i++){
				if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
					ComShowCodeMessage("BKG40021" , emlArr[i]);
					return false;
				}
			}
        }
		if(ComGetObjValue(formObj.si_cntc_pson_eml) != ""){
			emlArr = ComGetObjValue(formObj.si_cntc_pson_eml).split(";");
			for(var i = 0; i < emlArr.length; i++){
				if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
					ComShowCodeMessage("BKG40021" , emlArr[i]);
					return false;
				}
			}
        }
		// 여기서부터는 그냥 Message
		if(tpSzA){
			ComShowCodeMessage("BKG00304");		// A2,A4,A5가 존재하는 경우   	        	     				
		}    	
		if(delTerm == "S"){
			//2011.11.24 하단의 if 조건 제거 kbj
			//if(rcvTerm == "Y" || rcvTerm == "D" || rcvTerm == "H"){
			
			/* 박유숙 부장님 요청 제거 2017.4.27 */
//			if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)!="TH" && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)!="TH" ){
				ComShowCodeMessage("BKG00302");		// RCV이 'Y','D','H' 이면서 DLV이 'S' 인 경우
				//Thailand Console 일 때는 메시지가 따로 있음
//			}
			//}
		}
		if(formObj.rc_flg.checked){
			if(rcvTerm != "Y" && delTerm != "Y"){
				ComShowCodeMessage("BKG00303");		// Reefer 선택시 RCV,DLV 중 하나는 'Y'
			}
		}
		
		// Black Customer(Iran) Check
//		var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
//		var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
//		var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
//		if(black_cust_flag == "Y"){
//			if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
//				return false;
//			}
//		}
//		else{
			// Black Customer(US) Check
			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND09, FormQueryString(formObj));
			var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
			var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
			var black_rmk_flag = ComGetEtcData(sXml, "black_rmk_flag");
			var black_rmk_list = ComGetEtcData(sXml, "black_rmk_list");
			if(black_cust_flag == "Y"){
				if(!ComShowCodeConfirm("BKG02070", 'Customer Name' ,black_cust_list)){
					return false;
				}
			}else if(black_rmk_flag == "Y"){
				if(!ComShowCodeConfirm("BKG02070", 'Int/Ext Remark' ,black_rmk_list)){
					return false;
				}
			}
//		}
		
		var objs = [formObj.bkg_pod_cd,
		            formObj.bkg_pod_yd_cd,
		            formObj.bkg_del_cd,
		            formObj.bkg_del_yd_cd];
		var vals = [ComGetObjValue(objs[0]),
		            ComGetObjValue(objs[1]),
		            ComGetObjValue(objs[2]),
		            ComGetObjValue(objs[3])];
		if ("TRIST"==vals[0] && ComIsEmpty(objs[1])) {
			ComShowCodeMessage("BKG02074");
			ComSetFocus(objs[1]);
			return false;
		}
		if ("TRIST"==vals[2] && ComIsEmpty(objs[3])) {
			ComShowCodeMessage("BKG02074");
			ComSetFocus(objs[3]);
			return false;
		}
		
		if( ( ComTrim(formObj.bkg_por_cd2.value) != '' && ComTrim(formObj.bkg_por_cd2.value) != ComTrim(formObj.bkg_por_cd.value)) ||
			( ComTrim(formObj.por_nm2.value) != '' && ComTrim(formObj.por_nm2.value) != ComTrim(formObj.por_nm.value)) ||
			( ComTrim(formObj.bkg_pol_cd2.value) != '' && ComTrim(formObj.bkg_pol_cd2.value) != ComTrim(formObj.bkg_pol_cd.value)) ||
			( ComTrim(formObj.pol_nm2.value) != '' && ComTrim(formObj.pol_nm2.value) != ComTrim(formObj.pol_nm.value)) ||
			( ComTrim(formObj.bkg_pod_cd2.value) != '' && ComTrim(formObj.bkg_pod_cd2.value) != ComTrim(formObj.bkg_pod_cd.value)) ||
			( ComTrim(formObj.pod_nm2.value) != '' && ComTrim(formObj.pod_nm2.value) != ComTrim(formObj.pod_nm.value)) ||
			( ComTrim(formObj.bkg_del_cd2.value) != '' && ComTrim(formObj.bkg_del_cd2.value) != ComTrim(formObj.bkg_del_cd.value)) ||
			( ComTrim(formObj.del_nm2.value) != '' && ComTrim(formObj.del_nm2.value) != ComTrim(formObj.del_nm.value)) ){
			if(!ComShowCodeConfirm("BKG02075")){
				return false;
			}
		}
		
		var bkgPorCd   = ComGetObjValue(formObj.bkg_por_cd);
		var bkgPorYdCd = ComGetObjValue(formObj.bkg_por_yd_cd);
		var bkgPolCd   = ComGetObjValue(formObj.bkg_pol_cd);
		var bkgPodCd   = ComGetObjValue(formObj.bkg_pod_cd);
		var bkgDelCd   = ComGetObjValue(formObj.bkg_del_cd);
		var bkgDelYdCd = ComGetObjValue(formObj.bkg_del_yd_cd);
		var pre_rly_port_cd = ComGetObjValue(formObj.pre_rly_port_cd);
		var pst_rly_port_cd = ComGetObjValue(formObj.pst_rly_port_cd);        	

		// 2011.07.21 중국 상해 I/B DG화물 관련 MSDS 경고팝업 추가 
		if(!ComIsNull(bkgPodCd)){
			if( bkgPodCd == "CNSHA" || pre_rly_port_cd == "CNSHA" || pst_rly_port_cd == "CNSHA"){
				if( formObj.dcgo_flg.checked){
					ComShowCodeMessage("BKG01170"); //"For cargo to POD CNSHA(I/B and T/S), Material Safety Data Sheet(MSDS) and IMO Dangerous Goods Declaration are mandatory.\nPlease check the compulsory papers again."
				}
			}
			
			// 2014.11.27 [CHM-201432739] MSDS 필수 제출 팝업 문구 변경 및 CNTAO 대상 신규 추가
			if( bkgPodCd == "CNTAO" || pre_rly_port_cd == "CNTAO" || pst_rly_port_cd == "CNTAO"){
				if( formObj.dcgo_flg.checked){
					ComShowCodeMessage("BKG08337"); 
				}
			} 
		}	
				
		if(bkgPorCd == "USCHI" && bkgPolCd == "CAPRR" && ComGetObjValue(formObj.rcv_term_cd) == "Y"){
			if(bkgPorYdCd == "" || bkgPorYdCd == null || bkgPorYdCd == "RN"){
				ComShowCodeMessage("BKG08263");
			}
			if(bkgPorYdCd == "RF"){
				ComShowCodeMessage("BKG08264");
			}
		}

		if(bkgPodCd == "CAPRR" && bkgDelCd == "USCHI" && ComGetObjValue(formObj.de_term_cd) == "Y"){
			if(bkgDelYdCd == "" || bkgDelYdCd == "RN"){
				ComShowCodeMessage("BKG08263");
			}
			if(bkgDelYdCd == "RF"){
				ComShowCodeMessage("BKG08264");
			}
		}
		//2011.07.18 추가(중국 Solid Waste 관련 bkg commodity validation 추가) Start
		// [CHM-201432767] Split 01-발 중국향 waste paper에 대해서 뜨는 팝업 삭제 처리 요청
		/*
		bkgDelCd = ComGetObjValue(formObj.bkg_del_cd).substring(0,2);
		if(bkgDelCd == "CN" || bkgDelCd == "MO" || bkgDelCd == "TW"){ //중국, 마카오, 타이완
			var cwXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND05, FormQueryString(formObj));
			var chn_waste_flag = ComGetEtcData(cwXml, "chn_waste_flag");
			if(chn_waste_flag == "Y"){
				ComShowCodeMessage("BKG01169");
			}
		}
		*/
		
        bkgDelCd = ComGetObjValue(formObj.bkg_del_cd).substring(0,2);
        bkgPolCdSub = ComGetObjValue(formObj.bkg_pol_cd).substring(0,2);
        if((bkgDelCd == "CN" || bkgDelCd == "MO" || bkgDelCd == "TW")
                     && bkgPolCdSub!="US" && bkgPolCdSub!="CA" ){ //중국, 마카오, 타이완
        	var cwXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND05, FormQueryString(formObj));
            var chn_waste_flag = ComGetEtcData(cwXml, "chn_waste_flag");
            if(chn_waste_flag == "Y"){
            	ComShowCodeMessage("BKG01169"); 
            }
        }
		//2011.07.18 추가(중국 Solid Waste 관련 bkg commodity validation 추가) End	
		
		
		//2014.10.27 최도순[CHM-201432431] METAL SCRAP<-> RAIL BULK 연동 로직 Start
		//1.COMMODITY CODE: 810001 (METAL SCRAP) 2.RECEIVING TERM: YARD 3.POL이 미국 LOCATION CODE인 경우 (캐나다 제외) 4.POR!=POL인 경우 rail bulk의 S
		var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
		
	/*	if(cmdtCd =="810001" && rcvTerm =="Y" && bkgPolCd.substring(0,2)=="US" && bkgPolCd!=bkgPorCd){
			//ComSetObjValue(formObj.rail_blk_cd,"S");
			
			comboObjects[5].Code2 = "S";
		}		
		*/
		
		//2014.10.27 최도순[CHM-201432431] METAL SCRAP<-> RAIL BULK 연동 로직 End
		
		// [CHM-201432843] Split 01-DG/RF/AWK Cargo VVD ETD 10일 초과 시 팝업 메세지 요청
		if((route_detail_modify_flag == "Y" || ComGetObjValue(formObj.bkg_no)=="")
			&& ( ComGetObjValue(formObj.dcgo_flg)=="Y" || ComGetObjValue(formObj.rc_flg)=="Y" || ComGetObjValue(formObj.awk_cgo_flg)=="Y") ){
			var befEta = "";
			var befVvd = "";
			for (var i=0; i<=sheetObjects[2].RowCount; i++) {
				if(befEta!="" && sheetObjects[2].CellValue(i,"etd_day")!=""){
					if(ComGetDaysBetween(befEta, sheetObjects[2].CellValue(i,"etd_day")) > 10){
						ComShowCodeMessage('BKG08339');
					}
				}
				befEta = sheetObjects[2].CellValue(i,"eta_day");
				befVvd = sheetObjects[2].CellValue(i,"bkg_vvd_cd");
			}
    	}
		
		//CHM-201538247 Split01-US/Canada  모든 전 POL(Prefix가 US/CA인 건)  현재일보다  +60(일)보다 크면 Block으로 수정 요청 
		//var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0229_01GS.do?f_cmd="+COMMAND06, "loc_cd="+ComGetObjValue(formObj.bkg_por_cd));
		//var us_west_flag = ComGetEtcData(sXml, "us_west_flag");	
		var etdDay =  ComGetObjValue(formObj.chk_etd_dt);
		var sailDate = ComGetObjValue(formObj.lodg_due_dt);
		//if(us_west_flag == "Y"){
		if(ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US"||ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="CA"){
			if(ComGetDaysToToday(etdDay) < -60 || ComGetDaysToToday(sailDate) < -60) {
				ComShowCodeMessage("BKG95089");
				return false;
			}			
		}
		
        // [CHM-201534418] SYRIA SANCTION관련 ALERT POPUP 요청
        if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="SY" || ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="SY"
               || (ComGetObjValue(formObj.f_cust_cnt_cd)=="SY" && !ComIsNull(formObj.f_cust_seq))){
        	if(ComGetObjValue(formObj.rep_cmdt_cd)=='2700' || ComGetObjValue(formObj.rep_cmdt_cd)=='2800' || ComGetObjValue(formObj.rep_cmdt_cd)=='2900'
                     || ComGetObjValue(formObj.rep_cmdt_cd)=='3300' || ComGetObjValue(formObj.rep_cmdt_cd)=='3800' ){
        		if(ComShowCodeConfirm("BKG08345")){
        			window.open("https://compliance.hanjin.com/Compliance/indexTop.jsp");
                }
        	}
        }
        
        
        if (parent.frames("t2frame").document.form) {
    		if(ComGetObjValue(formObj.s_cust_cnt_cd) == "KR"
				&& (Number(ComGetObjValue(formObj.s_cust_seq)) == 695 || Number(ComGetObjValue(formObj.s_cust_seq)) == 37635)){
    			parent.frames("t2frame").document.form.kr_cstms_cust_tp_cd.Code = "C";
    		}
        }
        
        
     // Remark 에 BKG_BLACK_LIST 금지어 포함 되었는지 CHECK	
		var bkgBlackListStr = "";
		if(ComGetObjValue(formObj.xter_rmk)!=""){
			var param = "&f_cmd=" + SEARCH17 + "&input_text=" + ComGetObjValue(formObj.xter_rmk);
	 		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			bkgBlackListStr = output_text;
	 		}
	 	}
	 	if(bkgBlackListStr=="" && ComGetObjValue(formObj.inter_rmk)!=""){
	 		var param = "&f_cmd=" + SEARCH17 + "&input_text=" + ComGetObjValue(formObj.inter_rmk);
	 		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			bkgBlackListStr = output_text;
	 		}
		}
	 	if(bkgBlackListStr!=""){
 			ComShowCodeMessage("BKG95093",bkgBlackListStr);
 		}
	 // Remark 에 Yellow 금지어 포함 되었는지 CHECK	
		var yellowBlackListStr = "";
		if(ComGetObjValue(formObj.xter_rmk)!=""){
			var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" + ComGetObjValue(formObj.xter_rmk);
	 		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			yellowBlackListStr = output_text;
	 		}
	 	}
	 	if(yellowBlackListStr=="" && ComGetObjValue(formObj.inter_rmk)!=""){
	 		var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" + ComGetObjValue(formObj.inter_rmk);
	 		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			yellowBlackListStr = output_text;
	 		}
		}
	 	if(yellowBlackListStr!=""){
 			ComShowCodeMessage("BKG95101",yellowBlackListStr);
 		}
	 	
	 // Remark 에 Charcoal, Calcium Hypochlorite Manufacturer 금지어 포함 되었는지 CHECK	
		var chaCalHypoBlockList = "";
		if(ComGetObjValue(formObj.xter_rmk)!=""){
			var param = "&f_cmd=" + SEARCH22 + "&input_text=" + ComGetObjValue(formObj.xter_rmk);
	 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			chaCalHypoBlockList = output_text;
	 		}
	 	}
	 	if(chaCalHypoBlockList=="" && ComGetObjValue(formObj.inter_rmk)!=""){
	 		var param = "&f_cmd=" + SEARCH22 + "&input_text=" + ComGetObjValue(formObj.inter_rmk);
	 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	 		var output_text = ComGetEtcData(sXml, "output_text");
	 		if(output_text!=null && output_text.length>0){
	 			chaCalHypoBlockList = output_text;
	 		}
		}
	 	if(chaCalHypoBlockList!=""){
 			ComShowCodeMessage("BKG95110",chaCalHypoBlockList);
 		}

		break;
	}
	return true;
}

 function validateForUpload() {
 	// Save Validation을 수행 한다.
 	if (validateForm(sheetObjects[0], document.form, COMMAND01) == false){
 		return false;	
 	} else {
 		return true;
 	}
 }

 function getSaveStringForUpload() {
 	var formObj = document.form;
 	var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);
 	var haveRouteFlag = ComGetObjValue(formObj.have_route_flag);
 	var qtyModifyFlag = ComGetObjValue(formObj.qty_modify_flag);
 	
 	if(ComIsNull(oldBkgNo)){
 		if(haveRouteFlag == "N"){
 			ComSetObjValue(formObj.f_cmd, MULTI01);	// Create Without Route
 			formObj.route_modify_flag.value = "Y";
 		}else{
 			ComSetObjValue(formObj.f_cmd, MULTI02);	// Create With Route
 			formObj.route_modify_flag.value = "Y";
 		}
 	}else{
 		if(haveRouteFlag == "N"){
 			ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify Without Route
 			formObj.route_modify_flag.value = "Y";
 		}else{
 			ComSetObjValue(formObj.f_cmd, MULTI04);	// Modify With Route
 		}        			
 	}		

 	doCopyUpdateEsvc();
 	
 	doCopySoc();
	
 	// 조회해온 data처리(이중 전달 방지)
 	var sXml = formObj.sXml.value;
 	formObj.sXml.value = "";
 	
 	var params = FormQueryString(formObj);
 	formObj.sXml.value = sXml;
 	
 	params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true), "sheet1_"); // Bkg qty
 	params = params + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), "sheet3_"); // VVD
 	params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true), "sheet5_"); // QTY dtl
 	return params;
 }

/**
* 화면 상에 값들을 Save를 태울 수 있도록 정리 한다.
* (ex) form에 있는 값들을 그리드로 옮김
*/     
function acceptText() {
	var formObj = document.form;
	var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);
	
	// Booking 이 eBKG을 통해 생성되었음을 표시
	if (formObj.doc_tp_cd.value == "B" || ComIsNull(oldBkgNo)) {
		formObj.xter_bkg_rqst_cd.value = formObj.xter_rqst_via_cd.value;
		formObj.xter_bkg_rqst_ref_no.value = formObj.rqst_no2.value;
	}
	// SI가 eSI를 통해 Upload 되었음을 표시
	if (formObj.doc_tp_cd.value == "S") {
		formObj.si_flg.value = "Y";
		formObj.xter_si_cd.value = formObj.xter_rqst_via_cd.value;
		formObj.xter_si_ref_no.value = formObj.rqst_no2.value;	
	}
	
	// Weight 값을  서버로 전송하기 전 콤마(,)를 제거
	ComSetObjValue(formObj.act_wgt, ComGetObjValue(formObj.act_wgt).replace(/,/g, ""));
}
	
	// 최초 call은 0229에서 하고 여기서는 바로 pop-up 처리함
function createPctlNo() {
	var formObj = document.form;
	var isPctlNoPop = "";

	var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);		
	if(ComIsNull(oldBkgNo)){
		isPctlNoPop = "YC";
	} else {
		isPctlNoPop = "YM";
	}
	
	if(isPctlNoPop == "YC" || isPctlNoPop == "YM") {
		// ESD_PRD_018 화면 호출 하기 위한 url 생성
		var url;

		if(isPctlNoPop == "YC"){
			url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";
		}
		else if(isPctlNoPop == "YM"){
			url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=R";
			url = url + "&bkg_no=" + ComGetObjValue(formObj.bkg_no);
		}
		url = url + "&por="   + ComGetObjValue(formObj.bkg_por_cd);
		if(ComGetObjValue(formObj.bkg_por_yd_cd) != null && ComGetObjValue(formObj.bkg_por_yd_cd).length > 1)
			url = url + "&por_n=" + ComGetObjValue(formObj.bkg_por_cd) + ComGetObjValue(formObj.bkg_por_yd_cd);
		url = url + "&pol="   + ComGetObjValue(formObj.bkg_pol_cd);
		if(ComGetObjValue(formObj.bkg_pol_yd_cd)!= null && ComGetObjValue(formObj.bkg_pol_yd_cd).length > 1)
			url = url + "&pol_n=" + ComGetObjValue(formObj.bkg_pol_cd) + ComGetObjValue(formObj.bkg_pol_yd_cd);
		url = url + "&pod="   + ComGetObjValue(formObj.bkg_pod_cd);
		if(ComGetObjValue(formObj.bkg_pod_yd_cd)!= null && ComGetObjValue(formObj.bkg_pod_yd_cd).length > 1)
		url = url + "&pod_n=" + ComGetObjValue(formObj.bkg_pod_cd) + ComGetObjValue(formObj.bkg_pod_yd_cd);
		url = url + "&del="   + ComGetObjValue(formObj.bkg_del_cd);
		if(ComGetObjValue(formObj.bkg_del_yd_cd)!= null && ComGetObjValue(formObj.bkg_del_yd_cd).length > 1)
		url = url + "&del_n=" + ComGetObjValue(formObj.bkg_del_cd) + ComGetObjValue(formObj.bkg_del_yd_cd);		
		
		url = url + "&t_vvd=" + ComGetObjValue(formObj.bkg_trunk_vvd);
		if (sheetObjects[2].RowCount > 1) {
			for(i = 1 ; i < sheetObjects[2].Rows; i++){
				url = url + "&pol" + i + "="   + sheetObjects[2].CellValue(i, "pol_cd");
				if(sheetObjects[2].CellValue(i, "pol_yd_cd")!= null && sheetObjects[2].CellValue(i, "pol_yd_cd").length > 1)
				url = url + "&pol" + i + "_n=" + sheetObjects[2].CellValue(i, "pol_cd") + sheetObjects[2].CellValue(i, "pol_yd_cd");
				url = url + "&pod" + i + "="   + sheetObjects[2].CellValue(i, "pod_cd");
				if(sheetObjects[2].CellValue(i, "pod_yd_cd")!= null  && sheetObjects[2].CellValue(i, "pod_yd_cd").length > 1)
				url = url + "&pod" + i + "_n=" + sheetObjects[2].CellValue(i, "pod_cd") + sheetObjects[2].CellValue(i, "pod_yd_cd");
				url = url + "&vvd" + i + "="   + sheetObjects[2].CellValue(i, "bkg_vvd_cd");
			}
		}
		
		url = url + "&rcv_t=" + ComGetObjValue(formObj.rcv_term_cd);
		url = url + "&del_t=" + ComGetObjValue(formObj.de_term_cd);
		url = url + "&shpr="  + ComGetObjValue(formObj.s_cust_cnt_cd)+ComGetObjValue(formObj.s_cust_seq);
		
		// eBKG에는 없음
		//url = url + "&cngn="  + ComGetObjValue(formObj.c_cust_cnt_cd)+ComGetObjValue(formObj.c_cust_seq);
		url = url + "&com="     + ComGetObjValue(formObj.cmdt_cd);
		url = url + "&rep_com=" + ComGetObjValue(formObj.rep_cmdt_cd);
		url = url + "&wgt="     + ComGetObjValue(formObj.act_wgt).replace(/,/g, "");
		url = url + "&wgt_un="  + ComGetObjValue(formObj.wgt_ut_cd);
		
		url = url + "&bkg_ofc=" + ComGetObjValue(formObj.bkg_ofc_cd);
		url = url + "&org_sal_ofc=" + ComGetObjValue(formObj.ob_sls_ofc_cd);
		
		url = url + "&m_pu="  + ComGetObjValue(formObj.mty_pkup_yd_cd);
		url = url + "&f_rt="  + ComGetObjValue(formObj.full_rtn_yd_cd);
		url = url + "&ld_dt=" + changeDateFormat(ComGetObjValue(formObj.lodg_due_dt));
		url = url + "&dr_dt=" + changeDateFormat(ComGetObjValue(formObj.de_due_dt));
//		url = url + "&mt_pkup_dt="  + changeDateFormat(ComGetObjValue(formObj.mty_pkup_dt));
		
		url = url + "&org_trns_mode="  + changeTransMode((formObj.de_term_cd_old != formObj.de_term_cd)?"AL":ComGetObjValue(formObj.org_trns_mod_cd));
        url = url + "&dest_trns_mode=" + changeTransMode((formObj.rcv_term_cd_old != formObj.rcv_term_cd)?"AL":ComGetObjValue(formObj.dest_trns_mod_cd));


		if(!ComIsNull(ComGetObjValue(formObj.rfa_no))){
			url = url + "&rfa=" + ComGetObjValue(formObj.rfa_no);//ComGetObjValue(formObj.rfa_no1)+ComGetObjValue(formObj.rfa_no2);
//				url = url + "&rfa_ofc=" + ComGetEtcData(sXml, "RfaOfc");
		}
		
		if(!ComIsNull(ComGetObjValue(formObj.sc_no))){
			url = url + "&sc=" + ComGetObjValue(formObj.sc_no);//ComGetObjValue(formObj.sc_no1)+ComGetObjValue(formObj.sc_no2);
//				url = url + "&sc_ofc=" + ComGetEtcData(sXml, "ScOfc");
		}
		for(i = 1 ; i < sheetObjects[0].Rows ; i++){
			url = url + "&c_tpsz="+sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			url = url + "&c_qty="+sheetObjects[0].CellValue(i, "op_cntr_qty");  
		}
		//eBKG은 무조건 Full Booking
		url = url + "&cgo_tp=F";

		if(formObj.dcgo_flg.checked){
			url = url + "&dg_f=Y";
		}else{
			url = url + "&dg_f=N";
		}

		if(formObj.rc_flg.checked){
			url = url + "&rf_f=Y";
		}else{
			url = url + "&rf_f=N";
		}

		if(formObj.awk_cgo_flg.checked){
			url = url + "&ak_f=Y";
		}else{
			url = url + "&ak_f=N";
		}

		if(formObj.bb_cgo_flg.checked){
			url = url + "&bb_f=Y";
		}else{
			url = url + "&bb_f=N";
		}

		url = url + "&rd_f="  + ComGetObjValue(formObj.rd_cgo_flg);
		url = url + "&hg_f="  + ComGetObjValue(formObj.hngr_flg);
		url = url + "&soc_f=" + ComGetObjValue(formObj.soc_flg);
		url = url + "&sub_f=" + ComGetObjValue(formObj.eq_subst_flg);
		url = url + "&ida_hlg_tp_cd=" + ComGetObjValue(formObj.ida_hlg_tp_cd);
		url = url + "&pm_f=N";
																
//			alert("P/C Call : " + url);
		formObj.prd_params.value = url;
		ComSetObjValue(formObj.pctl_no, "");
		ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080",	"1,0,1,1,1", true);

		if(ComIsNull(formObj.pctl_no.value)){
//			ComShowCodeMessage("BKG00309");
		} else {
 	    	manageHaveRouteFlag("Y");
			return true;
		}			 		
	}
}

/**
 * p/c 호출 되는 경우 save 버튼을 빨간색으로 표시<br>
 */      
function manageHaveRouteFlag(haveRouteFlg){
	var formObj = document.form;
	ComSetObjValue(formObj.have_route_flag, haveRouteFlg);
	if(!(formObj.bkg_sts_cd.value == "S"
			&& formObj.xter_bkg_rqst_sts_cd.value == "X")){
		if (haveRouteFlg == "N"){
			ComSetObjValue(formObj.pctl_no, "");
			top.setBtnColor("btn_alpsupload", "red");
		} else {
			top.setBtnColor("btn_alpsupload", "black");
		}	
	}
	if (    (formObj.aloc_sts_cd.value == "S" || formObj.non_rt_sts_cd.value == "R") && 
			(formObj.doc_tp_cd.value == "S" || formObj.doc_tp_cd.value == "U") &&
			(ComGetObjValue(formObj.bkg_pol_cd).substring(0,2) =="US" || ComGetObjValue(formObj.bkg_pol_cd).substring(0,2) =="CA")){
		top.setBtnColor("btn_alpsupload", "gray");
		top.setBtnEnableSts("btn_alpsupload", false);
		//getBtnObject("btn_alpsupload").style.color = "white";
	}
}

/**
 * Alps에 Booking정보가 없는 경우 디폴트로 e-svc 데이터를 Alps로 Copy <br>
 */
function doDataCopy() {
	var formObj = document.form;
	if (formObj.rqst_no2.value != '') {
		formObj.bkg_no.value = top.document.form.bkg_no.value;
//		formObj.bkg_no2.value = top.document.form.bkg_no.value;
		if(formObj.bl_no_ctnt2.value.length>4 && formObj.bl_no_ctnt2.value.substring(0,4)=="SMLM"){
			formObj.bl_no.value = formObj.bl_no_ctnt2.value.substring(4);
		} else {
			formObj.bl_no.value = formObj.bl_no_ctnt2.value;
		}

		if ( formObj.sh_cnt_cd2.value.length > 0 )
			form_setShprCustCntCd(formObj.sh_cnt_cd2.value);
		if (parseInt(formObj.sh_cust_seq2.value, 10) > 0)
			form_setShprCustSeq(formObj.sh_cust_seq2.value);
		formObj.s_cust_nm.value = formObj.sh_cust_nm2.value.toUpperCase();
		
		if ( formObj.ff_cnt_cd2.value.length > 0 )
			form_setFwdrCustCntCd(formObj.ff_cnt_cd2.value);
		if (parseInt(formObj.ff_cust_seq2.value, 10) > 0)
			form_setFwdrCustSeq(formObj.ff_cust_seq2.value);
		formObj.f_cust_nm.value = formObj.ff_cust_nm2.value.toUpperCase();

		// shipper가 없을 경우 forwarder로 update -> forwarder가 있을 때만 
		if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.s_cust_seq)){
			if(formObj.ff_cnt_cd2.value.length != "" && formObj.ff_cnt_cd2.value.length != null && formObj.ff_cnt_cd2.value.length > 0 
				&& parseInt(formObj.ff_cust_seq2.value, 10) > 0){
				form_setShprCustCntCd(ComGetObjValue(formObj.f_cust_cnt_cd));
	    		form_setShprCustSeq(ComGetObjValue(formObj.f_cust_seq));
	    		ComSetObjValue(formObj.s_cust_nm, ComGetObjValue(formObj.f_cust_nm));
			}
		}
		
		//제외 20100413 이정희 차장님 요청
//		formObj.ob_srep_cd.value    = formObj.srep_cd2.value;
		formObj.bkg_trunk_vvd.value = formObj.vvd2.value;
		formObj.vsl_eng_nm.value    = formObj.vsl_nm2.value.toUpperCase();
		
		// Route 정보 (POR, POL, POD, DEL) 복사
		formObj.bkg_por_cd.value = ComTrim(formObj.bkg_por_cd2.value);
		formObj.bkg_por_yd_cd.value = ComTrim(formObj.bkg_por_yd_cd2.value);
		formObj.por_nm.value = ComTrim(formObj.por_nm2.value).substring(0,25);
		formObj.bkg_pod_cd.value = ComTrim(formObj.bkg_pod_cd2.value);
		formObj.pod_nm.value = ComTrim(formObj.pod_nm2.value).substring(0,25);
		formObj.bkg_pol_cd.value = ComTrim(formObj.bkg_pol_cd2.value);
		formObj.bkg_pol_yd_cd.value = ComTrim(formObj.bkg_pol_yd_cd2.value);
		formObj.pol_nm.value = ComTrim(formObj.pol_nm2.value).substring(0,25);
		formObj.bkg_del_cd.value = ComTrim(formObj.bkg_del_cd2.value);
		formObj.del_nm.value = ComTrim(formObj.del_nm2.value).substring(0,25);
		formObj.fnl_dest_nm.value = formObj.fnl_dest_nm2.value.toUpperCase();
		
		// location name을 한 번에 조회해옴
//		searchNupdateRoutNmAll();
				
		// Receiving Term
		// 하드 코딩을 나중에 바꾸어야  함
		if (formObj.rcv_term2.value == "Door") 
			comboObjects[0].Code2 = "D";
		else if (formObj.rcv_term2.value == "CY")
			comboObjects[0].Code2 = "Y";
		else if (formObj.rcv_term2.value == "CFS")
			comboObjects[0].Code2 = "S";
		else if (formObj.rcv_term2.value == "Tackle")
			comboObjects[0].Code2 = "T";
		else if (formObj.rcv_term2.value == "Free In")
			comboObjects[0].Code2 = "I";
		else if (formObj.rcv_term2.value == "Mixed")
			comboObjects[0].Code2 = "M";
		
		// Delivery Term
		// 하드 코딩을 나중에 바꾸어야  함
		if (formObj.dlv_term2.value == "Door") 
			comboObjects[1].Code2 = "D";
		else if (formObj.dlv_term2.value == "CY")
			comboObjects[1].Code2 = "Y";
		else if (formObj.dlv_term2.value == "CFS")
			comboObjects[1].Code2 = "S";
		else if (formObj.dlv_term2.value == "Tackle")
			comboObjects[1].Code2 = "T";
		else if (formObj.dlv_term2.value == "Free Out")
			comboObjects[1].Code2 = "O";
		else if (formObj.dlv_term2.value == "Mixed")
			comboObjects[1].Code2 = "M";
		
//		// Freight Term: PREPAID OR COLLECT
//		if (formObj.frt_term_cd2.value == "P" ||
//			formObj.frt_term_cd2.value == "PREPAID") {
//			comboObjects[2].Code = "P";
//		}
//		else if (formObj.frt_term_cd2.value == "C" ||
//			formObj.frt_term_cd2.value == "COLLECT") {
//			comboObjects[2].Code = "C";
//		}
		
		if(formObj.sc_rfa.value=="SC"){
			formObj.sc_no.value  = formObj.ctrt_no2.value;
		} else {
			formObj.rfa_no.value = formObj.ctrt_no2.value;
		}
		
		ctrtType_OnClick();

		formObj.twn_so_no.value = formObj.twn_so_no2.value;
		formObj.cmdt_cd.value   = formObj.cmdt_cd2.value;
		formObj.cmdt_desc.value = formObj.cmdt_desc2.value;
		
		var bkgPorCd   = ComGetObjValue(formObj.bkg_por_cd);
		var bkgPolCd   = ComGetObjValue(formObj.bkg_pol_cd);
		var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
		
		if( bkgPolCd.substring(0,2)=="US" && bkgPolCd!=bkgPorCd){
			if(cmdtCd =="740302" ||cmdtCd =="810001"||cmdtCd =="720400"||cmdtCd =="760300"){			
				comboObjects[5].Code2 = "S";
			} else if (cmdtCd =="980035" ||cmdtCd =="230330"||cmdtCd =="980034"||cmdtCd =="070002"||cmdtCd =="100100"||cmdtCd =="980031"){			
				comboObjects[5].Code2 = "G";
			} else {
				comboObjects[5].Code2 = "";
			}
		}		
		
		var hndlOfcCd = ComGetObjValue(formObj.hndl_ofc_cd);
		//CHM-201538473 e-Booking & S/I Process 메뉴 보완 : POR US/CA 이고 NYCSC Handling office일 경우에 한해 RFA No. 저장허용
		if(bkgPorCd.substring(0,2)=="US"||bkgPorCd.substring(0,2)=="CA"){
			if(hndlOfcCd != "NYCSC"){
				formObj.rfa_no.value ="";
				formObj.rfa_no.readOnly =true;
			}			
		}
		
		validatePrecaution(formObj);
		
		// AMS Filer (US Customs)
		if (formObj.usa_cstms_file_ctnt2.value == "Carrier Filing NVOCC") {
			comboObjects[2].Code2 = "1";
		}
		else if (formObj.usa_cstms_file_ctnt2.value == "Self Filing NVO") {
			comboObjects[2].Code2 = "2";
		}
		else if (formObj.usa_cstms_file_ctnt2.value == "Not Applicable") {
			comboObjects[2].Code2 = "3";
		}
		else {
//			formObj.usa_cstms_file_cd.value = formObj.usa_cstms_file_ctnt2.value;
			comboObjects[2].Code2 = formObj.usa_cstms_file_ctnt2.value;
		}
		
		// ACI Filer (Canada Customs)
		if (formObj.cnd_cstms_file_cd2.value == "Carrier Filing NVOCC") {
			comboObjects[3].Code2 = "1";
		}
		else if (formObj.cnd_cstms_file_cd2.value == "Self Filing NVO") {
			comboObjects[3].Code2 = "2";
		}
		else if (formObj.cnd_cstms_file_cd2.value == "Not Applicable") {
			comboObjects[3].Code2 = "3";
		}
		else {
//			formObj.cnd_cstms_file_cd.value = formObj.cnd_cstms_file_cd2.value;			
			comboObjects[3].Code2 = formObj.cnd_cstms_file_cd2.value;		
		}
		
		// SCAC No를 Copy 하도록 함. 2010.04.27
		formObj.scac_cd.value = ComTrim(formObj.scac_cd2.value);
		
		// Weight QTY
		// Weight 등이 업데이트 되면 M&D TAB 존재 시 Update 하기 위해 method로 뺌
		formObj.act_wgt.value = formObj.estm_wgt2.value;
		form_setEstWgtQty(formObj.estm_wgt2.value);
		
		// Weight Unit
		if (formObj.estm_wgt_ut_cd2.value == null ||
			formObj.estm_wgt_ut_cd2.value == "" ||
			formObj.estm_wgt2.value == null ||
			formObj.estm_wgt2.value == "" ||
			parseFloat(formObj.estm_wgt2.value) == .0) {
			comboObjects[4].Code2 = formObj.dflt_wgt_ut_cd.value;
		}
		else {
			comboObjects[4].Code2 = formObj.estm_wgt_ut_cd2.value;
		}

		if (formObj.dcgo_flg2.checked) 		formObj.dcgo_flg.checked = 1;
		if (formObj.dcgo_flg2.checked) 		formObj.dcgo_flg.value = formObj.dcgo_flg2.value;

		if (formObj.rc_flg2.checked)    	formObj.rc_flg.checked = 1;
		if (formObj.rc_flg2.checked)    	formObj.rc_flg.value = formObj.rc_flg2.value;

		if (formObj.awk_cgo_flg2.checked) 	formObj.awk_cgo_flg.checked = 1;
		if (formObj.awk_cgo_flg2.checked) 	formObj.awk_cgo_flg.value = formObj.awk_cgo_flg2.value;
		
		if (formObj.bb_cgo_flg2.checked) 	formObj.bb_cgo_flg.checked = 1;
		if (formObj.bb_cgo_flg2.checked) 	formObj.bb_cgo_flg.value = formObj.bb_cgo_flg2.value;
		
		if (formObj.soc_flg2.checked) 		formObj.soc_flg.checked = 1;
		if (formObj.soc_flg2.checked) 		formObj.soc_flg.value = formObj.soc_flg2.value;
		
		if (formObj.flex_hgt_flg2.checked) 		formObj.flex_hgt_flg.checked = 1;
		if (formObj.flex_hgt_flg2.checked) 		formObj.flex_hgt_flg.value = formObj.flex_hgt_flg2.value;
		
		formObj.mty_dor_arr_dt.value 	= formObj.return_dt2.value;
		formObj.lodg_due_dt.value 		= formObj.departure_dt2.value;
		
		if(formObj.tro_pkup_dt.value!=null && formObj.tro_pkup_dt.value!= ""){
			ComSetObjValue(formObj.mty_pkup_dt, formObj.tro_pkup_dt.value);
		}else{
			ComSetObjValue(formObj.mty_pkup_dt, formObj.mty_pkup_dt2.value);
		}
		
		formObj.de_due_dt.value 		= formObj.arrival_dt2.value;
		formObj.xter_rmk.value 			= formObj.rmk2.value;		
//		formObj.inter_rmk.value = formObj.rmk2.value;
		
//		if (formObj.auto_notification2.checked) {
//			formObj.auto_notification.checked = 1;
//			formObj.auto_notification.value = "Y";
//		}

		document.all.bkg_cntc_pson_nm_span.innerHTML		= document.all.bkg_cntc_pson_nm.value 		= formObj.cntc_nm2.value;
		document.all.bkg_cntc_pson_phn_no_span.innerHTML	= document.all.bkg_cntc_pson_phn_no.value	= SetNumHyp(formObj.tel2.value);
		document.all.bkg_cntc_pson_mphn_no_span.innerHTML	= document.all.bkg_cntc_pson_mphn_no.value	= SetNumHyp(formObj.mobile2.value);
		document.all.bkg_cntc_pson_fax_no_span.innerHTML	= document.all.bkg_cntc_pson_fax_no.value 	= SetNumHyp(formObj.fax2.value);
		document.all.bkg_cntc_pson_eml_span.value		= document.all.bkg_cntc_pson_eml.value 		= formObj.cntc_eml2.value;

		if (formObj.auto_notification2.value == "Yes") {
			formObj.auto_notification.checked = true;
			formObj.auto_notification.value = "Y";
		} 
		if (sheetObjects[1].TotalRows > 0) {
			sheetObjects[0].RemoveAll();
			
			var totRow = sheetObjects[1].TotalRows;
			
			for ( var i = 1; i <= totRow; i++) {
				sheetObjects[0].DataInsert(-1);
				sheetObjects[0].CellValue(i, 0) = sheetObjects[1].CellValue(i, 0);
				sheetObjects[0].CellValue(i, 2) = sheetObjects[1].CellValue(i, 1);
				sheetObjects[0].CellValue(i, 3) = sheetObjects[1].CellValue(i, 2);
				sheetObjects[0].CellValue(i, 4) = sheetObjects[1].CellValue(i, 3);
				sheetObjects[0].CellValue(i, 5) = sheetObjects[1].CellValue(i, 4);
				sheetObjects[0].CellValue(i, 7) = sheetObjects[1].CellValue(i, 6);
			}
		}
		if(  "WEB"==formObj.xter_rqst_via_cd.value
		  || "EDI"==formObj.xter_rqst_via_cd.value
		  || "GTN"==formObj.xter_rqst_via_cd.value
		  || "INT"==formObj.xter_rqst_via_cd.value
		  || "CSM"==formObj.xter_rqst_via_cd.value	) {
			formObj.copy_esvc.checked = true;
		}
		doCopyEsvc();
		
		// Ref No Copy
		doCopyRefNo();
		
		ComSetObjValue(formObj.modify_flag, 			"Y");
    	ComSetObjValue(formObj.route_modify_flag, 		"Y");
    	ComSetObjValue(formObj.customer_modify_flag, 	"Y");
    	ComSetObjValue(formObj.contact_modify_flag, 	"Y");
	    ComSetObjValue(formObj.qty_modify_flag, 		"Y");
	    manageHaveRouteFlag("N");
	}
	

 	var oldBkgNo = ComGetObjValue(formObj.old_bkg_no); 	
 	if(ComIsNull(oldBkgNo)){
 		checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
 	}
}

function SetNumHyp(val){
	re=/[^0-9\-]/gi;	
	
	return val.replace(re,"");
}

// eSVC 쪽의 location을 가져옴
function copyCopyLocation(copyOpt) {
	var formObj = document.form;
	var formObj2 = document.form2;

//	ComSetObjValue(formObj.route_modify_flag, "Y");
//    manageHaveRouteFlag("N");
	if (copyOpt == "Y") {
		formObj2.bkg_por_cd.value = formObj.bkg_por_cd.value;
		formObj2.bkg_por_yd_cd.value = formObj.bkg_por_yd_cd.value;
		formObj2.por_nm.value = formObj.por_nm.value;
		formObj2.bkg_pol_cd.value = formObj.bkg_pol_cd.value;
		formObj2.bkg_pol_yd_cd.value = formObj.bkg_pol_yd_cd.value;
		formObj2.pol_nm.value = formObj.pol_nm.value;
		formObj2.bkg_pod_cd.value = formObj.bkg_pod_cd.value;
		formObj2.pod_nm.value = formObj.pod_nm.value;
		formObj2.bkg_del_cd.value = formObj.bkg_del_cd.value;
		formObj2.del_nm.value = formObj.del_nm.value;

		formObj2.mty_pkup_yd_cd.value = formObj.mty_pkup_yd_cd.value;
		formObj2.full_rtn_yd_cd.value = formObj.full_rtn_yd_cd.value;
		formObj2.mty_pkup_dt.value = formObj.mty_pkup_dt.value;

		if (formObj.incl_code.checked) {

			
			formObj.bkg_por_cd.value = formObj.bkg_por_cd2.value;
			formObj.bkg_por_yd_cd.value = formObj.bkg_por_yd_cd2.value;
			formObj.por_nm.value = formObj.por_nm2.value.substring(0, 25);
			formObj.bkg_pol_cd.value = formObj.bkg_pol_cd2.value;
			formObj.bkg_pol_yd_cd.value = formObj.bkg_pol_yd_cd2.value;
			formObj.pol_nm.value = formObj.pol_nm2.value.substring(0, 25);
			formObj.bkg_pod_cd.value = formObj.bkg_pod_cd2.value;
			formObj.pod_nm.value = formObj.pod_nm2.value.substring(0, 25);
			formObj.bkg_del_cd.value = formObj.bkg_del_cd2.value;
			formObj.del_nm.value = formObj.del_nm2.value.substring(0, 25);
			
			if(ComGetObjValue(formObj.pol_yd_cd_old) != ComGetObjValue(formObj.bkg_pol_yd_cd2)){
	    		ComSetObjValue(formObj.route_modify_flag,"Y");
	    		ComSetObjValue(formObj.modify_flag,"Y");
	 	    	manageHaveRouteFlag("N");
	 	    	sheetObjects[2].CellValue(sheetObjects[2].HeaderRows,"pol_yd_cd") = ComGetObjValue(formObj.bkg_pol_yd_cd2);
	 	    	por_pol_change(formObj);
			}
			if(ComGetObjValue(formObj.bkg_por_cd) != ComGetObjValue(formObj2.bkg_por_cd) || ComGetObjValue(formObj.bkg_pol_cd) != ComGetObjValue(formObj2.bkg_pol_cd)){
				ComSetObjValue(formObj.mty_pkup_yd_cd,"");
				ComSetObjValue(formObj.mty_pkup_dt,   "");
				ComSetObjValue(formObj.full_rtn_yd_cd,"");
			}
		} else {
			formObj.por_nm.value = formObj.por_nm2.value.substring(0, 25);
			formObj.pol_nm.value = formObj.pol_nm2.value.substring(0, 25);
			formObj.pod_nm.value = formObj.pod_nm2.value.substring(0, 25);
			formObj.del_nm.value = formObj.del_nm2.value.substring(0, 25);
		}
	} else {
		formObj.bkg_por_cd.value = formObj2.bkg_por_cd.value;
		formObj.bkg_por_yd_cd.value = formObj2.bkg_por_yd_cd.value;
		formObj.por_nm.value 	 = formObj2.por_nm.value;
		formObj.bkg_pol_cd.value = formObj2.bkg_pol_cd.value;
		formObj.bkg_pol_yd_cd.value = formObj2.bkg_pol_yd_cd.value;
		formObj.pol_nm.value 	 = formObj2.pol_nm.value;
		formObj.bkg_pod_cd.value = formObj2.bkg_pod_cd.value;
		formObj.pod_nm.value 	 = formObj2.pod_nm.value;
		formObj.bkg_del_cd.value = formObj2.bkg_del_cd.value;
		formObj.del_nm.value 	 = formObj2.del_nm.value;
		
		formObj.mty_pkup_yd_cd.value = formObj2.mty_pkup_yd_cd.value;
		formObj.full_rtn_yd_cd.value = formObj2.full_rtn_yd_cd.value;
		formObj.mty_pkup_dt.value = formObj2.mty_pkup_dt.value;
	}
}

//contact person 값 가져옴
function doCopyEsvc() {
    var formObj = document.form;
    if (formObj.copy_esvc.checked) {
        document.all.bkg_cntc_pson_nm_span.innerHTML      = formObj.bkg_cntc_pson_nm.value      = ""==formObj.cntc_nm2.value     ? formObj.bkg_cntc_pson_nm.value      : formObj.cntc_nm2.value    ;
        document.all.bkg_cntc_pson_phn_no_span.innerHTML  = formObj.bkg_cntc_pson_phn_no.value  = ""==formObj.tel2.value         ? SetNumHyp(formObj.bkg_cntc_pson_phn_no.value)  : SetNumHyp(formObj.tel2.value)        ;
        document.all.bkg_cntc_pson_mphn_no_span.innerHTML = formObj.bkg_cntc_pson_mphn_no.value = ""==formObj.mobile2.value      ? SetNumHyp(formObj.bkg_cntc_pson_mphn_no.value) : SetNumHyp(formObj.mobile2.value)     ;
        document.all.bkg_cntc_pson_fax_no_span.innerHTML  = formObj.bkg_cntc_pson_fax_no.value  = ""==formObj.fax2.value         ? SetNumHyp(formObj.bkg_cntc_pson_fax_no.value)  : SetNumHyp(formObj.fax2.value)        ;
        document.all.bkg_cntc_pson_eml_span.value     = formObj.bkg_cntc_pson_eml.value     = ""==formObj.cntc_eml2.value    ? formObj.bkg_cntc_pson_eml.value     : formObj.cntc_eml2.value   ;
        document.all.si_cntc_pson_nm_span.innerHTML       = formObj.si_cntc_pson_nm.value       = ""==formObj.si_cntc_nm2.value  ? formObj.si_cntc_pson_nm.value       : formObj.si_cntc_nm2.value ;
        document.all.si_cntc_pson_phn_no_span.innerHTML   = formObj.si_cntc_pson_phn_no.value   = ""==formObj.si_tel2.value      ? SetNumHyp(formObj.si_cntc_pson_phn_no.value)   : SetNumHyp(formObj.si_tel2.value)     ;
        document.all.si_cntc_pson_mphn_no_span.innerHTML  = formObj.si_cntc_pson_mphn_no.value  = ""==formObj.si_mobile2.value   ? SetNumHyp(formObj.si_cntc_pson_mphn_no.value)  : SetNumHyp(formObj.si_mobile2.value)  ;
        document.all.si_cntc_pson_fax_no_span.innerHTML   = formObj.si_cntc_pson_fax_no.value   = ""==formObj.si_fax2.value      ? SetNumHyp(formObj.si_cntc_pson_fax_no.value)   : SetNumHyp(formObj.si_fax2.value)     ;
        document.all.si_cntc_pson_eml_span.value      = formObj.si_cntc_pson_eml.value      = ""==formObj.si_cntc_eml2.value ? formObj.si_cntc_pson_eml.value      : formObj.si_cntc_eml2.value;
        ComSetObjValue(formObj.contact_modify_flag, "Y");
    } else {
        document.all.bkg_cntc_pson_nm_span.innerHTML      = formObj.bkg_cntc_pson_nm.value      = formObj.tmp_bkg_cntc_pson_nm.value     ;
        document.all.bkg_cntc_pson_phn_no_span.innerHTML  = formObj.bkg_cntc_pson_phn_no.value  = formObj.tmp_bkg_cntc_pson_phn_no.value ;
        document.all.bkg_cntc_pson_mphn_no_span.innerHTML = formObj.bkg_cntc_pson_mphn_no.value = formObj.tmp_bkg_cntc_pson_mphn_no.value;
        document.all.bkg_cntc_pson_fax_no_span.innerHTML  = formObj.bkg_cntc_pson_fax_no.value  = formObj.tmp_bkg_cntc_pson_fax_no.value ;
        document.all.bkg_cntc_pson_eml_span.value     = formObj.bkg_cntc_pson_eml.value     = formObj.tmp_bkg_cntc_pson_eml.value    ;
        document.all.si_cntc_pson_nm_span.innerHTML       = formObj.si_cntc_pson_nm.value       = formObj.tmp_si_cntc_pson_nm.value      ;
        document.all.si_cntc_pson_phn_no_span.innerHTML   = formObj.si_cntc_pson_phn_no.value   = formObj.tmp_si_cntc_pson_phn_no.value  ;
        document.all.si_cntc_pson_mphn_no_span.innerHTML  = formObj.si_cntc_pson_mphn_no.value  = formObj.tmp_si_cntc_pson_mphn_no.value ;
        document.all.si_cntc_pson_fax_no_span.innerHTML   = formObj.si_cntc_pson_fax_no.value   = formObj.tmp_si_cntc_pson_fax_no.value  ;
        document.all.si_cntc_pson_eml_span.value      = formObj.si_cntc_pson_eml.value      = formObj.tmp_si_cntc_pson_eml.value     ;
        ComSetObjValue(formObj.contact_modify_flag, "N");
    }
}


// Ref No. Copy 값 가져옴
function doCopyRefNo() {
	
	var bkg_doc = "N";	
	var formObj = document.form;
		
	if (formObj.xter_inv_ref_no.value != "") {
		formObj.inv_ref_no.value = formObj.xter_inv_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.inv_ref_no.value = formObj.bkg_inv_ref_no.value;
	}
	
	if (formObj.xter_bkg_ref_no.value != "") {
		formObj.bkg_ref_no.value = formObj.xter_bkg_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.bkg_ref_no.value = formObj.bkg_bkg_ref_no.value;
	}
	
	if (formObj.xter_bkg_sh_ref_no.value != "") {
		formObj.bkg_sh_ref_no.value = formObj.xter_bkg_sh_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.bkg_sh_ref_no.value = formObj.bkg_bkg_sh_ref_no.value;
	}
	
	if (formObj.xter_bkg_ff_ref_no.value != "") {
		formObj.bkg_ff_ref_no.value = formObj.xter_bkg_ff_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.bkg_ff_ref_no.value = formObj.bkg_bkg_ff_ref_no.value;
	}
	
	if (formObj.xter_si_reference_no.value != "") {
		formObj.si_ref_no.value = formObj.xter_si_reference_no.value;
		bkg_doc = "Y";
	} else {
		formObj.si_ref_no.value =  formObj.bkg_si_ref_no.value;
	}
	
	if (formObj.xter_si_sh_ref_no.value != "") {
		formObj.si_sh_ref_no.value = formObj.xter_si_sh_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.si_sh_ref_no.value = formObj.bkg_si_sh_ref_no.value;
	}
	
	if (formObj.xter_si_ff_ref_no.value != "") {
		formObj.si_ff_ref_no.value = formObj.xter_si_ff_ref_no.value;
		bkg_doc = "Y";
	} else {
		formObj.si_ff_ref_no.value = formObj.bkg_si_ff_ref_no.value;
	}
	
	if (formObj.xter_reg_bkg_no.value != "") {
		formObj.reg_bkg_no.value = formObj.xter_reg_bkg_no.value;
		bkg_doc = "Y";
	} else {
		formObj.reg_bkg_no.value = formObj.bkg_reg_bkg_no.value;
	}
	
	if (formObj.xter_ext_mrn_no.value != "") {
		formObj.ext_mrn_no.value = formObj.xter_ext_mrn_no.value;
		bkg_doc = "Y";
	} else {
		formObj.ext_mrn_no.value = formObj.bkg_ext_mrn_no.value;
	}

	getBtnObject("btn_ref_xter").style.color = (bkg_doc=="Y")?"blue":"#737373";
	getBtnObject("btn_ref_bkg").style.color = (bkg_doc=="Y")?"blue":"#737373";
}

//Soc Flg 값 가져옴
function doCopySoc() {
 	var formObj = document.form;
	var socCnt = 0;
	for(i = 1 ; i < sheetObjects[0].Rows ; i++){
		if( sheetObjects[0].CellValue(i, "soc_qty" ) != null && sheetObjects[0].CellValue(i, "soc_qty" ) != "" && sheetObjects[0].CellValue(i, "soc_qty" ) > 0 ){
			socCnt++;
		}
	}
	if(socCnt > 0){
		formObj.soc_flg.value = "Y";	
		formObj.soc_flg.checked = 1;
	}else{
		formObj.soc_flg.value = "N";
		formObj.soc_flg.checked = 0;
	}
}

//contact person 값 저장하는 곳으로 Copy 함.
function doCopyUpdateEsvc() {
	var formObj = document.form;
	formObj.bkg_cntc_pson_nm.value = document.all.bkg_cntc_pson_nm_span.innerHTML;
	formObj.bkg_cntc_pson_phn_no.value = document.all.bkg_cntc_pson_phn_no_span.innerHTML;
	formObj.bkg_cntc_pson_mphn_no.value = document.all.bkg_cntc_pson_mphn_no_span.innerHTML;
	formObj.bkg_cntc_pson_fax_no.value = document.all.bkg_cntc_pson_fax_no_span.innerHTML;
	formObj.bkg_cntc_pson_eml.value = document.all.bkg_cntc_pson_eml_span.value;
	formObj.si_cntc_pson_nm.value = document.all.si_cntc_pson_nm_span.innerHTML;
	formObj.si_cntc_pson_phn_no.value = document.all.si_cntc_pson_phn_no_span.innerHTML;
	formObj.si_cntc_pson_mphn_no.value = document.all.si_cntc_pson_mphn_no_span.innerHTML;
	formObj.si_cntc_pson_fax_no.value = document.all.si_cntc_pson_fax_no_span.innerHTML;
	formObj.si_cntc_pson_eml.value = document.all.si_cntc_pson_eml_span.value;
}

//contact person 값 가져옴
function autoNotification() {
	var formObj = document.form;
	if (formObj.auto_notification.checked) {
		formObj.auto_notification.value = "Y";
	} else {
		formObj.auto_notification.value = "N";
	}
}

//Doc Requirement 값 가져옴
function docReqCopyEsvc() {  

	var bkg_doc = "N";
	var formObj = document.form;

	if (formObj.copy_esvc_doc.checked) {
		
		if (!ComIsNull(document.all.wy_bl_flg.innerHTML) ) {
			handelRqstBlTpCdRadio(document.all.rqst_bl_tp_cd, document.all.wy_bl_flg.innerHTML); /// 2011.06.02
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.incl_rt_bl_knt.innerHTML)) {
			document.all.obl_rt_incl_knt.value = document.all.incl_rt_bl_knt.innerHTML;
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.xcld_rt_bl_knt.innerHTML)) {
			document.all.obl_rt_xcld_knt.value = document.all.xcld_rt_bl_knt.innerHTML;
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.bl_iss_loc_cd.innerHTML)) {
			document.all.rqst_iss_plc_nm.value = document.all.bl_iss_loc_cd.innerHTML;
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.bl_iss_dt.innerHTML)) {
			document.all.rqst_iss_dt.value = document.all.bl_iss_dt.innerHTML;
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.non_nego_rt_incl_knt2.innerHTML)) {
			document.all.non_nego_rt_incl_knt.value = document.all.non_nego_rt_incl_knt2.innerHTML;
			bkg_doc = "Y";
		}
		if (!ComIsNull(document.all.non_nego_rt_xcld_knt2.innerHTML)) {
			document.all.non_nego_rt_xcld_knt.value = document.all.non_nego_rt_xcld_knt2.innerHTML;
			bkg_doc = "Y";
		}		
	} else {
		handelRqstBlTpCdRadio(document.all.rqst_bl_tp_cd, formObj.rqst_bl_tp_cd_old.value);  /// 2011.06.02
		document.all.obl_rt_incl_knt.value = formObj.obl_rt_incl_knt_old.value;
		document.all.obl_rt_xcld_knt.value = formObj.obl_rt_xcld_knt_old.value;
		document.all.rqst_iss_plc_nm.value = formObj.rqst_iss_plc_nm_old.value;
		document.all.rqst_iss_dt.value = formObj.rqst_iss_dt_old.value;
		
		document.all.non_nego_rt_incl_knt.value = formObj.non_nego_rt_incl_knt_old.value;
		document.all.non_nego_rt_xcld_knt.value = formObj.non_nego_rt_xcld_knt_old.value;
		
	}
	getBtnObject("btn_docRequirement").style.color = (bkg_doc=="Y")?"blue":"#737373";
}

/**
 * handelRqstBlTpCdRadio 
 * @param radioObj - radio button 개체(들)
 * @param val - 선택할 값
 * @return
 * @since 2011.06.02
 * @author 김진승
 */
function handelRqstBlTpCdRadio(radioObj, val){
  if ( radioObj == undefined || radioObj == null || radioObj.length == 0 || val == undefined || val == null ){
    reutrn; 
  }
  for(var i=0; i<radioObj.length; i++){
    if ( radioObj[i].value == val ){
		radioObj[i].checked = true;
    } else {
		radioObj[i].checked = false;
    }
  }
  radioObj.value = val;
}


//색 비교 처리
function compareItem() {
	var formObj = document.form;
	
	if (!ComIsEmpty(formObj.act_wgt) && formObj.act_wgt.value!=formObj.estm_wgt2.value){
		formObj.act_wgt.style.color= "Red"; 
		formObj.estm_wgt2.style.color = "Red";
	} else {
		formObj.act_wgt.style.color= "#606060";
		formObj.estm_wgt2.style.color = "#606060";
	}	
	if (!ComIsEmpty(formObj.rcv_term_cd.Text) && formObj.rcv_term_cd.Text != formObj.rcv_term2.value){
		formObj.rcv_term_cd.FontColor = "Red";
		formObj.rcv_term2.style.color = "Red";
	} else {
		formObj.rcv_term_cd.FontColor = "#606060";
		formObj.rcv_term2.style.color = "#606060";
	}
	if (!ComIsEmpty(formObj.de_term_cd.Text) && formObj.de_term_cd.Text != formObj.dlv_term2.value){
		formObj.de_term_cd.FontColor = "Red";
		formObj.dlv_term2.style.color = "Red";
	} else {
		formObj.de_term_cd.FontColor = "#606060";
		formObj.dlv_term2.style.color = "#606060";
	}
	//if (!ComIsEmpty(formObj.frt_term_cd.Text) && formObj.frt_term_cd.Text.substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){  //2011.11.28 jsy
	if (!ComIsEmpty(formObj.frt_term_cd.value) && formObj.frt_term_cd.value.substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){
		//formObj.frt_term_cd.FontColor="Red";  //2011.11.28 jsy
		formObj.tmp_frt_term_cd.style.color = "Red";
		formObj.frt_term_cd2.style.color = "Red";
	} else {
		//formObj.frt_term_cd.FontColor= "#606060"; //2011.11.28 jsy
		formObj.tmp_frt_term_cd.style.color = "#606060";
		formObj.frt_term_cd2.style.color = "#606060";		
	}
	setDiffCheckColor(formObj.s_cust_cnt_cd.value, 	formObj.sh_cnt_cd2.value, 		("sh_cnt_cd2"));
	setDiffCheckColor(formObj.s_cust_seq.value, 	formObj.sh_cust_seq2.value, 	("sh_cust_seq2"));
	setDiffCheckColor(formObj.s_cust_nm.value, 		formObj.sh_cust_nm2.value, 		("sh_cust_nm2"));
	setDiffCheckColor(formObj.f_cust_cnt_cd.value, 	formObj.ff_cnt_cd2.value, 		("ff_cnt_cd2"));
	setDiffCheckColor(formObj.f_cust_seq.value, 	formObj.ff_cust_seq2.value, 	("ff_cust_seq2"));
	setDiffCheckColor(formObj.f_cust_nm.value, 		formObj.ff_cust_nm2.value, 		("ff_cust_nm2"));
	setDiffCheckColor(formObj.ob_srep_cd.value,		formObj.srep_cd2.value,			("srep_cd2"));
	setDiffCheckColor(formObj.bkg_trunk_vvd.value, 	formObj.vvd2.value, 			("vvd2"));
	setDiffCheckColor(formObj.vsl_eng_nm.value, 	formObj.vsl_nm2.value, 			("vsl_nm2"));
	setDiffCheckColor(formObj.bkg_por_cd.value, 	formObj.bkg_por_cd2.value, 		("bkg_por_cd2"));
	setDiffCheckColor(formObj.bkg_pol_cd.value, 	formObj.bkg_pol_cd2.value, 		("bkg_pol_cd2"));
	setDiffCheckColor(formObj.bkg_pod_cd.value, 	formObj.bkg_pod_cd2.value, 		("bkg_pod_cd2"));
	setDiffCheckColor(formObj.bkg_del_cd.value, 	formObj.bkg_del_cd2.value, 		("bkg_del_cd2"));
	setDiffCheckColor(formObj.bkg_por_yd_cd.value, 	formObj.bkg_por_yd_cd2.value, 		("bkg_por_yd_cd2"));
	setDiffCheckColor(formObj.bkg_pol_yd_cd.value, 	formObj.bkg_pol_yd_cd2.value, 		("bkg_pol_yd_cd2"));
	setDiffCheckColor(formObj.bkg_pod_yd_cd.value, 	formObj.bkg_pod_yd_cd2.value, 		("bkg_pod_yd_cd2"));
	setDiffCheckColor(formObj.bkg_del_yd_cd.value, 	formObj.bkg_del_yd_cd2.value, 		("bkg_del_yd_cd2"));
	setDiffCheckColor(formObj.por_nm.value, 		formObj.por_nm2.value, 			("por_nm2"));
	setDiffCheckColor(formObj.pol_nm.value, 		formObj.pol_nm2.value, 			("pol_nm2"));
	setDiffCheckColor(formObj.pod_nm.value, 		formObj.pod_nm2.value, 			("pod_nm2"));
	setDiffCheckColor(formObj.del_nm.value, 		formObj.del_nm2.value, 			("del_nm2"));
	setDiffCheckColor(formObj.fnl_dest_nm.value, 	formObj.fnl_dest_nm2.value, 	("fnl_dest_nm2"));
	setDiffCheckColor(formObj.twn_so_no.value, 		formObj.twn_so_no2.value, 		("twn_so_no2"));
	setDiffCheckColor(formObj.wgt_ut_cd.value, 		formObj.estm_wgt_ut_cd2.value, 	("estm_wgt_ut_cd2"));
	
	if(formObj.sc_no.value!=null){
		setDiffCheckColor(formObj.sc_no.value, 		formObj.ctrt_no2.value, 		("ctrt_no2"));
	}
	if(formObj.rfa_no.value!=null){
		setDiffCheckColor(formObj.rfa_no.value, 	formObj.ctrt_no2.value, 		("ctrt_no2"));
	}
	
	if (!ComIsEmpty(formObj.usa_cstms_file_cd.Text) && formObj.usa_cstms_file_cd.Text != formObj.usa_cstms_file_ctnt2.value){
		formObj.usa_cstms_file_cd.FontColor = "Red";
		formObj.usa_cstms_file_ctnt2.style.color = "Red";
	} else {
		formObj.usa_cstms_file_cd.FontColor = "#606060";
		formObj.usa_cstms_file_ctnt2.style.color = "#606060";
	}
	
	if (!ComIsEmpty(formObj.cnd_cstms_file_cd.Text) && formObj.cnd_cstms_file_cd.Text != formObj.cnd_cstms_file_cd2.value){
		formObj.cnd_cstms_file_cd.FontColor = "Red";
		formObj.cnd_cstms_file_cd2.style.color = "Red";
	} else {
		formObj.cnd_cstms_file_cd.FontColor = "#606060";
		formObj.cnd_cstms_file_cd2.style.color = "#606060";
	}
}

function compareQty(){
	var formObj = document.form;
	var alpsQtySheet = sheetObjects[0];
	var esvcQtySheet = sheetObjects[1];
	var sameTypeSize = false;
	for(var i = 1; i < alpsQtySheet.Rows; i++){
		sameTypeSize = false;
		for(var j = 1; j < esvcQtySheet.Rows; j++){
			if(alpsQtySheet.CellValue(i, "cntr_tpsz_cd") == esvcQtySheet.CellValue(j, "cntr_tpsz_cd")){
				sameTypeSize = true;
				if(alpsQtySheet.CellValue(i, "op_cntr_qty") != esvcQtySheet.CellValue(j, "cntr_qty")){
					alpsQtySheet.CellFontColor(i, "op_cntr_qty") = alpsQtySheet.RgbColor(255, 0, 0);		
					esvcQtySheet.CellFontColor(j, "cntr_qty") = esvcQtySheet.RgbColor(255, 0, 0);					
				}
			}
			if(sameTypeSize == false){
				alpsQtySheet.CellFontColor(i, 2) = alpsQtySheet.RgbColor(255, 0, 0);					
				alpsQtySheet.CellFontColor(i, 3) = alpsQtySheet.RgbColor(255, 0, 0);			
			}
		}			
	}	
	esvcQtySheet.SelectCell(0,1);
//	alpsQtySheet.SelectCell(0,1);
}

/**
 * 마우스 IN일때
 */
function bkg0229_01_activate() {
	// 입력Validation 확인하기
	switch (event.srcElement.name) {
	case "mty_dor_arr_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "lodg_due_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "de_due_dt":
		ComClearSeparator(event.srcElement);
		break;
	case "mty_pkup_dt":
		ComClearSeparator(event.srcElement);
		break;
	default:
		event.srcElement.onfocus = new Function("this.select()");
		break;
	}
}

/**
 * 마우스 아웃일때
 */
function bkg0229_01_deactivate() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	// TrunkVvd 체크

	if(srcName == "bkg_no"){
		if(ComIsNull(srcValue)||ComGetObjValue(formObj.old_bkg_no) != srcValue){
			if(ComIsNull(srcValue)){
		    	ComSetObjValue(formObj.old_bkg_no,"");
			}
    		ComSetObjValue(formObj.bl_no,"");
    		ComSetObjValue(formObj.pctl_no,"");
    		ComSetObjValue(formObj.si_flg,"");
    		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
    		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
		} 
	}else if (srcName == "bkg_trunk_vvd") {
		if(ComGetObjValue(formObj.bkg_trunk_vvd_old) != srcValue){
			ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.modify_flag,"Y");
	     	manageHaveRouteFlag("N");
    		if(srcValue.substring(0,4) == "HJXX" || srcValue.substring(0,4) == "HJYY" || srcValue.substring(0,4) == "HJZZ"){
    			ComSetObjValue(formObj.psdo_bkg_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.psdo_bkg_flg,"N");
    		}  
    		for(var i = sheetObjects[2].Rows  ; i >= sheetObjects[2].HeaderRows ; i-- ){
    			if(ComGetObjValue(formObj.bkg_trunk_vvd_old)== sheetObjects[1].CellValue(i, "bkg_vvd_cd")){
    				sheetObjects[2].CellValue(i, "bkg_vvd_cd") = srcValue;
    			}
    		}
		}		        		
    	por_pol_change(formObj);
	    pod_del_change(formObj);
	    	ComSetObjValue(formObj.check_ts_close_flag, "Y");
	} else if (srcName == "bkg_por_cd") {
		if(ComGetObjValue(formObj.por_yd_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
		}  
    	if(ComIsNull(srcValue)){
    		for(var i = sheetObjects[2].Rows  ; i >= sheetObjects[2].HeaderRows ; i-- ){
	   			sheetObjects[2].RowDelete(i,false);	
	   		}	
    		ComSetObjValue(formObj.pre_rly_port_cd,		"");
    		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
    		ComSetObjValue(formObj.pst_rly_port_cd,		"");
    		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
    	}
		ComSetObjValue(formObj.org_trns_mod_cd, "");
	} else if (srcName == "bkg_por_yd_cd") {
		if(ComGetObjValue(formObj.por_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
    		ComSetObjValue(formObj.bkg_por_yd_cd,"");
 	    	manageHaveRouteFlag("N");
		} 		        		
	} else if (srcName == "bkg_pol_cd") {
		if(ComGetObjValue(formObj.pol_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N");

			ComSetObjValue(formObj.bkg_pol_yd_cd,"");
 	    	sheetObjects[2].CellValue(sheetObjects[2].HeaderRows,"pol_cd")    = srcValue;
 	    	sheetObjects[2].CellValue(sheetObjects[2].HeaderRows,"pol_yd_cd") = "";

			por_pol_change(formObj);			
		}
		if(ComIsNull(srcValue)){
			for(var i = sheetObjects[2].Rows  ; i >= sheetObjects[2].HeaderRows ; i-- ){
				sheetObjects[2].RowDelete(i,false);	
			}	
    		ComSetObjValue(formObj.pre_rly_port_cd,		"");
    		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
    		ComSetObjValue(formObj.pst_rly_port_cd,		"");
    		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
		}	
		ComSetObjValue(formObj.org_trns_mod_cd, "");
	} else if (srcName == "bkg_pol_yd_cd") {
		if(ComGetObjValue(formObj.pol_yd_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N"); 	
 	    	// Bkg Vvd Sheet에도 변경한다.    	
 	    	sheetObjects[2].CellValue(sheetObjects[2].HeaderRows,"pol_yd_cd") = srcValue;
	    	por_pol_change(formObj);
		}
	} else if (srcName == "bkg_pod_cd") {
		if(ComGetObjValue(formObj.pod_cd_old) != srcValue){
    		// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
    		checkEgyptDeTerm(srcValue);
    		checkTanzaniaDeTerm(srcValue, "", "");
    		checkThailandDeTerm(srcValue, "", "");

    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");		

			ComSetObjValue(formObj.bkg_pod_yd_cd,"");
 	    	sheetObjects[2].CellValue(sheetObjects[2].Rows-1,"pod_cd")    = srcValue;
 	    	sheetObjects[2].CellValue(sheetObjects[2].Rows-1,"pod_yd_cd") = ""; 
 	    	
 	    	pod_del_change(formObj);
		}       			
		if(ComIsNull(srcValue)){
			for(var i = sheetObjects[2].Rows  ; i >= sheetObjects[2].HeaderRows ; i-- ){
				sheetObjects[2].RowDelete(i,false);	
			}	
			ComSetObjValue(formObj.pre_rly_port_cd,		"");
			ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
			ComSetObjValue(formObj.pst_rly_port_cd,		"");
			ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
		}
		ComSetObjValue(formObj.dest_trns_mod_cd, "");
	    ComSetObjValue(formObj.check_ts_close_flag, "Y");
	} else if (srcName == "bkg_pod_yd_cd") {
		if(ComGetObjValue(formObj.pod_yd_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
 	    	
 	    	sheetObjects[2].CellValue(sheetObjects[2].Rows-1,"pod_yd_cd") = srcValue;
 	    	pod_del_change(formObj);
		}
	    ComSetObjValue(formObj.check_ts_close_flag, "Y");
	} else if (srcName == "bkg_del_cd") {
		checkTanzaniaDeTerm("", srcValue, "");
		checkThailandDeTerm("", srcValue, "");
		
		if(ComGetObjValue(formObj.del_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
			ComSetObjValue(formObj.bkg_del_yd_cd,"");
 	    	manageHaveRouteFlag("N");
 	    	if(formObj.alps2.value == "No"){
	 	    	var t2formObj = parent.frames("t2frame").document.form;
	 	    	if (t2formObj) {
		 			if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(srcValue)){
		 				ComSetObjValue(t2formObj.cn_cust_cnt_cd, srcValue.substring(0,2));
		 			}	
		
		 			if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(srcValue)){
		 				ComSetObjValue(t2formObj.nf_cust_cnt_cd, srcValue.substring(0,2));
		 			}
	 	    	}
			}
		}
		if(ComIsNull(srcValue)){
			for(var i = sheetObjects[2].Rows  ; i >= sheetObjects[2].HeaderRows ; i-- ){
	   			sheetObjects[2].RowDelete(i,false);	
	   		}	
			ComSetObjValue(formObj.pre_rly_port_cd,		"");
			ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
			ComSetObjValue(formObj.pst_rly_port_cd,		"");
			ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
		}
		ComSetObjValue(formObj.dest_trns_mod_cd, "");
	} else if (srcName == "bkg_del_yd_cd") {
		if(ComGetObjValue(formObj.del_yd_cd_old) != srcValue){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
		}  
	} else if (srcName == "s_cust_cnt_cd") {
		if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_cnt_cd_old) != srcValue){
			formObj.customer_modify_flag.value = "Y";
			formObj.modify_flag.value = "Y";		
			//eBkg에서는 지우지 않음
//			ComSetObjValue(formObj.s_cust_nm,"");	
			ComSetObjValue(formObj.aloc_chk_flg, "Y");	
		}
		form_setShprCustCntCd(srcValue);
	} else if (srcName == "s_cust_seq") {
		if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_seq_old) != srcValue){
			formObj.customer_modify_flag.value = "Y";
			formObj.modify_flag.value = "Y";	
			ComSetObjValue(formObj.aloc_chk_flg, "Y");	
//			ComSetObjValue(formObj.s_cust_nm,"");	
			if(!ComIsNull(srcValue)){
				// 20091131 추가
				if(ComChkLen(formObj.s_cust_cnt_cd, 2) == "2"){
					if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) 
						|| ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
		    			searchCustNm(formObj, ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "S");
					}
				}
				// 20100113 추가
				if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
					if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) 
						|| ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
						if(ComShowCodeConfirm("BKG00343")){
							ComSetObjValue(formObj.s_cust_subst_flg, "Y");
						}else{
							ComSetObjValue(formObj.s_cust_subst_flg, "N");
						}
					}
				}
			}
		}
		form_setShprCustSeq(srcValue);
	} else if (srcName == "f_cust_cnt_cd") {
		if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
			formObj.customer_modify_flag.value = "Y";
			formObj.modify_flag.value = "Y";		
//			ComSetObjValue(formObj.f_cust_nm,"");	
		}
		form_setFwdrCustCntCd(srcValue);
	} else if (srcName == "f_cust_seq") {
		if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_seq_old) != srcValue){
			formObj.customer_modify_flag.value = "Y";
			formObj.modify_flag.value = "Y";		
//			ComSetObjValue(formObj.f_cust_nm,"");	
			if(!ComIsNull(srcValue)){
				// 20091131 추가
				if(ComChkLen(formObj.f_cust_cnt_cd, 2) == "2"){
					if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) 
						|| ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
		    			searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");
					}
				}
				// 20100113 추가
				if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
					if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) 
						|| ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
						if(ComShowCodeConfirm("BKG00343")){
							ComSetObjValue(formObj.f_cust_subst_flg, "Y");
						}else{
							ComSetObjValue(formObj.f_cust_subst_flg, "N");
						}
					}
				}
	    		if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.s_cust_seq)){
	    			form_setShprCustCntCd(ComGetObjValue(formObj.f_cust_cnt_cd));
		    		form_setShprCustSeq(ComGetObjValue(formObj.f_cust_seq));
		    		ComSetObjValue(formObj.s_cust_nm, ComGetObjValue(formObj.f_cust_nm));	    			
	    		}
			}
		}
		form_setFwdrCustSeq(srcValue);
	} else if (srcName == "rfa_no") {
		if(srcValue == "DUM"){
			ComSetObjValue(formObj.rfa_no,"DUM0000001");
		}else{
 			if(srcValue.length>=10){
    			if(srcValue != ComGetObjValue(formObj.rfa_no_old)){
        			// validateRfaAvailable() 호출
        			formObj.f_cmd.value = SEARCHLIST12;
        			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+srcValue, "f_cmd="+SEARCHLIST12+"&bkg_no="+formObj.bkg_no.value+"&rfa_no="+formObj.rfa_no.value);
     				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input");
    				
     				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM"){
     					ComSetObjValue(formObj.sc_no, "");
     				}
     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM"){
     					ComSetObjValue(formObj.taa_no, "");
     				}	     				
     				ComSetObjValue(formObj.modify_flag,"Y");
     				ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
     				ComSetObjValue(formObj.aloc_chk_flg,"Y");
    			}   				
			}else{
				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input1");
			}
		}  
		
		if(formObj.rfa_no_old.value!=formObj.rfa_no.value){
			compareItem();
		}
		ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));
	} else if (srcName == "sc_no") {
		if(srcValue == "DUM"){
			ComSetObjValue(formObj.sc_no,"DUM000001");
		}else{
 			if(srcValue.length>=8){
    			if(srcValue != ComGetObjValue(formObj.sc_no_old)){
        			// validateScAvailable() 호출
        			formObj.f_cmd.value = SEARCHLIST13;
        			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+srcValue, "f_cmd="+SEARCHLIST13+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value);
     				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");
    				
     				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM"){
     					ComSetObjValue(formObj.rfa_no, "");
     				}
     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM"){
     					ComSetObjValue(formObj.taa_no, "");
     				}	     			     		
     				ComSetObjValue(formObj.modify_flag,"Y");
     				ComSetObjValue(formObj.ctrt_modify_flag,"Y");  	
     				ComSetObjValue(formObj.aloc_chk_flg,"Y");
    			}   		  			
			}else{
				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");
			}
		}    
		
		if(formObj.sc_no_old.value!=formObj.sc_no.value){
			compareItem();
		}
		ComSetObjValue(formObj.sc_no_old,ComGetObjValue(formObj.sc_no));    
	}else if(srcName == "taa_no"){
		if(srcValue == "DUM"){
			ComSetObjValue(formObj.taa_no,"DUM0000001");
		}else if(srcValue.length>=10){
 			if(srcValue != ComGetObjValue(formObj.taa_no_old)){
     			// validatetTaavailable() 호출
     			formObj.f_cmd.value = SEARCH06;
     			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?taa_no="+srcValue, "f_cmd="+SEARCH06+"&bkg_no="+formObj.bkg_no.value+"&taa_no="+formObj.taa_no.value);
 				changeObjectColor(ComGetEtcData(sXml,"taa_available"), "N", "taa_no", "red", "input");
 				
 				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM"){
 					ComSetObjValue(formObj.rfa_no, "");
 				}
 				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM"){
 					ComSetObjValue(formObj.sc_no, "");
 				}
 			}   		
			ComSetObjValue(formObj.modify_flag,"Y");
			ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
 		}
		if(formObj.taa_no_old.value!=formObj.taa_no.value){
			compareItem();
		}
 		ComSetObjValue(formObj.taa_no_old,ComGetObjValue(formObj.taa_no));  
	} else if (srcName == "act_wgt") {
		var actWgt = formObj.act_wgt.value;
		for(var i=0;actWgt.length;i++){
			if(actWgt.length==0){
				break;
			} else if(actWgt.substring(0, 1)=="0"){
				actWgt = actWgt.substring(1, actWgt.length);
			} else {
				break;
			}
		}
		ComSetObjValue(formObj.act_wgt, makeComma(actWgt));
		ComSetObjValue(formObj.modify_flag, "Y");
		ComSetObjValue(formObj.aloc_chk_flg,"Y");
		form_setEstWgtQty(formObj.act_wgt.value);
	} else if (srcName == "twn_so_no") {
		if (!ComIsNull(srcValue)) {
			formObj.modify_flag.value = "Y";
		}
	} else if (srcName == "mty_dor_arr_dt") {
		ComAddSeparator(event.srcElement);
		if(ComGetObjValue(formObj.mty_dor_arr_dt_old) != srcValue){
			ComSetObjValue(formObj.modify_flag, "Y");
		}       
	} else if (srcName == "lodg_due_dt") {
		ComAddSeparator(event.srcElement);
		if(ComGetObjValue(formObj.lodg_due_dt_old) != srcValue){
			ComSetObjValue(formObj.route_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
		}
	} else if (srcName == "de_due_dt") {
		ComAddSeparator(event.srcElement);
		if(srcValue.length > 0 && ComChkPeriod(formObj.lodg_due_dt.value, srcValue) < 1){
			ComShowCodeMessage("BKG00176");
			ComSetObjValue(formObj.de_due_dt, "");
//			ComSetFocus(formObj.de_due_dt);
		}
		if(ComGetObjValue(formObj.de_due_dt_old) != srcValue){
			ComSetObjValue(formObj.modify_flag, "Y");
		}
	} else if (srcName == "mty_pkup_dt") {
		//최초 생성 이후에 m_pu, f_rt, mt_pkup_dt 적용 없음(20091217 신은영차장님 요청)
		//원래대로 적용함(20100120 임종한 과장 확인)
		ComAddSeparator(event.srcElement);
		if(ComGetObjValue(formObj.mty_pkup_dt_old) != srcValue){
			ComSetObjValue(formObj.route_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
		}
	} else if (srcName == "mty_pkup_yd_cd") {
		if(ComGetObjValue(formObj.mty_pkup_yd_cd_old) != srcValue){
			ComSetObjValue(formObj.route_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
		}
	} else if (srcName == "full_rtn_yd_cd") {
    	if(ComGetObjValue(formObj.full_rtn_yd_cd_old) != srcValue){
//    		ComSetObjValue(formObj.route_modify_flag, "Y");
    		ComSetObjValue(formObj.modify_flag, "Y");
//     	   	manageHaveRouteFlag("N");
    	}
	}
	return true;
}

/**
 * Click 일때
 */
function bkg0229_01_click() {
	var formObj = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var stwgCd = formObj.stwg_cd.value;
	var stwgTmp = formObj.stwg_tmp.value; //화면에서 edit 시 어떤 check box로 생성된 Code인지를 구분.

	if (srcName == "prct_flg") {
		
		if (formObj.prct_flg.checked) {
			ComShowCodeMessage("BKG00274");
			setPrecaution(formObj, "Y")
			formObj.prct_flg.value = "Y";
			formObj.prct_tmp.value = "Y" //화면 Edit 여부
		} else {
			// BKG00256
			if (formObj.validPrecaution.value == "Y") {
				ComShowCodeMessage("BKG00274");
				formObj.prct_flg.checked = true;
				formObj.prct_flg.value = "Y";
			} else {
				formObj.modify_flag.value = "Y";
				formObj.prct_flg.value = "N";
			}
		}
		
		var prct_flg = formObj.prct_flg.value;
		//if (stwgCd == "" && prct_flg == "Y"){
		//	formObj.stwg_cd.value = "PC";
		//	formObj.stwg_tmp.value = "PC";
		//}
		//if (stwgTmp == "PC" && prct_flg == "N"){
		//	if (formObj.hide_tmp.value == "Y" && formObj.spcl_hide_flg.value== "Y"){
		//		formObj.stwg_cd.value = "ODHD";
		//		formObj.stwg_tmp.value = "HD";
		//	}else{
		//	   formObj.stwg_cd.value = formObj.stwg_cd_tmp.value; //수정 전 원래 DATA.
		//	   formObj.stwg_tmp.value = "";
		//	}   
		//}
		
		
	} else if ("dcgo_flg"==srcName) {
		formObj.dcgo_flg.value = formObj.dcgo_flg.checked ? "Y" : "N";
	} else if ("rc_flg"==srcName) {
		formObj.rc_flg.value = formObj.rc_flg.checked ? "Y" : "N";
	} else if ("awk_cgo_flg"==srcName) {
		formObj.awk_cgo_flg.value = formObj.awk_cgo_flg.checked ? "Y" : "N";
	} else if ("bb_cgo_flg"==srcName) {
		formObj.bb_cgo_flg.value = formObj.bb_cgo_flg.checked ? "Y" : "N";
	} else if ("spcl_hide_flg"==srcName) {
		formObj.spcl_hide_flg.value = formObj.spcl_hide_flg.checked ? "Y" : "N";
		var spcl_hide_flg = formObj.spcl_hide_flg.value;
		if (formObj.spcl_hide_flg.checked){
			formObj.hide_tmp.value = "Y"; //화면 Edit 여부
			ComShowCodeMessage("BKG08351");
		}
		if (stwgCd == "" && spcl_hide_flg == "Y"){
			formObj.stwg_cd.value = "ODHD";	
			formObj.stwg_tmp.value = "HD";
		}
		if (stwgTmp == "HD" && spcl_hide_flg == "N"){
			//if (formObj.prct_tmp.value == "Y" && formObj.prct_flg.value == "Y"){
			//	formObj.stwg_cd.value = "PC";
			//	formObj.stwg_tmp.value = "PC";
			//	
			//}else{
			   formObj.stwg_cd.value = formObj.stwg_cd_tmp.value;
			   formObj.stwg_tmp.value = "";
			   
			//}   
		}
		
	} else if ("prct_flg"==srcName) {
		formObj.prct_flg.value = formObj.prct_flg.checked ? "Y" : "N";
	} else if ("fd_grd_flg"==srcName) {
		formObj.fd_grd_flg.value = formObj.fd_grd_flg.checked ? "Y" : "N";
	} else if ("flex_hgt_flg"==srcName) {
		formObj.flex_hgt_flg.value = formObj.flex_hgt_flg.checked ? "Y" : "N";
	} else if ("edi_hld_flg"==srcName) {
		formObj.edi_hld_flg.value = formObj.edi_hld_flg.checked ? "Y" : "N";
	} 
}

function form_onChange() {
	var srcObj = window.event.srcElement;
 	var srcName = srcObj.getAttribute("name");
 	var srcValue = srcObj.getAttribute("value");
 	var formObj = document.form;
	// 2018.05.25 iylee Form Change 일때 소문자 -> 대문자로 바꾸어줌.
	ComSetUpperChange(srcName, event.srcElement.value);
	
 	switch (srcName) {
	 	case "bkg_trunk_vvd" :
	 		bkgVvdChanged();
	 		searchVslNm(srcValue);
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 		manageHaveRouteFlag("N");
	 		break;	 		
	 	case "bkg_por_cd" :
	 		searchNupdateRoutNm(srcValue, formObj.por_nm);
	 		
	 		ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 		manageHaveRouteFlag("N");
	 		break;	 		
	 	case "bkg_pol_cd" :
	 		searchNupdateRoutNm(srcValue, formObj.pol_nm);
	 		
	 		ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 		manageHaveRouteFlag("N");
 	    	checkMaltaTerm(srcValue,"");
	 		setPolPodClptIndSeq();
	 		checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
	 		break;	 		
	 	case "bkg_pod_cd" :
	 		searchNupdateRoutNm(srcValue, formObj.pod_nm);
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 		manageHaveRouteFlag("N");
	 		checkMaltaTerm("", srcValue);
	 		setPolPodClptIndSeq();
	 		break;
	 	case "bkg_pol_yd_cd" :
	 	case "bkg_pod_yd_cd" :
	 		setPolPodClptIndSeq();
	 		break;
	 	case "bkg_del_cd" :
	 		searchNupdateRoutNm(srcValue, formObj.del_nm);
			ComSetObjValue(formObj.route_modify_flag, "Y");
	 		manageHaveRouteFlag("N");
	 		break;
	 	case "cmdt_cd":
			if(!ComIsNull(srcValue)){
				ComSetObjValue(formObj.cmdt_cd, ComLpad(srcValue,6,"0"));
				if(ComGetObjValue(formObj.cmdt_cd_old) != srcValue){
					checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
					validatePrecaution(formObj);			
	  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);	
				}    			
			}else{
				ComSetObjValue(formObj.cmdt_desc,"");
				ComSetObjValue(formObj.rep_cmdt_cd,"");
			}
//			ComSetObjValue(formObj.cmdt_cd_old,ComGetObjValue(formObj.cmdt_cd));    	
			ComSetObjValue(formObj.modify_flag,"Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
			cmdtChange(srcValue);
	 		break;
	 	case "rep_cmdt_cd":
    		if(ComIsNull(srcValue)){
    			ComSetObjValue(formObj.cmdt_desc,"");
    		}
	 		break;
	 	//sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.14 kbj
	 	case "sc_no":
	 		ComSetObjValue(formObj.ctrt_ofc_cd,"");
	 		ComSetObjValue(formObj.ctrt_srep_cd,"");
	 		break;
 	}
 	validateTurkey(srcObj);
	compareItem();
 }
// Sc, Rfa Display
function ctrtType_OnClick() {
	var formObj = document.form;
	
	if(formObj.rfa_no.value!=null) {
		formObj.ctrt_type.value = "RFA";
	} else if(formObj.taa_no.value!=null) {
		formObj.ctrt_type.value = "TAA";
	} else if(ComGetObjValue(formObj.bkg_por_cd).substring(0,2)=="US" || 
		ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US" ||
		(!ComIsNull(formObj.bkg_pod_cd) && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="US") ||
		ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" ){
		formObj.ctrt_type.value = "TAA";
	} else {
		formObj.ctrt_type.value = "RFA";
	}	

	var ctrtType = formObj.ctrt_type.value;
	if (ComGetObjValue(formObj.ctrt_type) == "RFA") {
		document.all.item("rfa_no").style.display = "";
		document.all.item("taa_no").style.display =  "none";
		document.all.item("btn_RfaNo").style.display = "";
		document.all.item("btn_TaaNo").style.display = "none";	
		formObj.ctrt_type[1].checked = true;
		formObj.taa_no.value = "";
	} else if (ComGetObjValue(formObj.ctrt_type) == "TAA") {
		document.all.item("rfa_no").style.display = "none";
		document.all.item("taa_no").style.display =  "";
		document.all.item("btn_RfaNo").style.display = "none";
		document.all.item("btn_TaaNo").style.display = "";
		formObj.ctrt_type[0].checked = true;
		formObj.rfa_no.value = "";
	} else {
		document.all.item("rfa_no").style.display = "";
		document.all.item("taa_no").style.display =  "none";
		document.all.item("btn_RfaNo").style.display = "";
		document.all.item("btn_TaaNo").style.display = "none";	
		formObj.ctrt_type[1].checked = true;		
	}
}

function changeBkgNoManual(obj) {
	var formObj = document.form;
	if (obj.checked) {
		formObj.bkg_no.style.background = "#FFFFFF";
		formObj.bkg_no.readOnly = false;
	} else {
		formObj.bkg_no.style.background = "#E8E7EC";
		formObj.bkg_no.readOnly = true;
	}
}


function usa_cstms_file_cd_OnChange(comboObj, value, text) {
	compareItem();
}
function cnd_cstms_file_cd_OnChange(comboObj, value, text) {
	compareItem();
}
function rcv_term_cd_OnChange(comboObj, value, text) {	
	var formObj = document.form;
	if(value!="M"){
		if (parent.frames("t3frame").document.form) {
			if ( parent.frames("t3frame").document.form.fnl_cfm_flg.value != "Y" ) {
				var cntrSheet = parent.frames("t3frame").sheetObjects[0];
				for(i=cntrSheet.HeaderRows;i<=cntrSheet.Rows;i++){
					cntrSheet.CellValue2(i, "rcv_term_cd") = value;
				}
				parent.frames("t3frame").setCopyFlag("false");
				for ( var i = 0; i < parent.frames("t3frame").document.form.elements.length; i++) {
					if (parent.frames("t3frame").document.form.elements[i].name.indexOf("rcv_term_cd") == 0) {
						parent.frames("t3frame").document.form.elements[i].value = value;
						parent.frames("t3frame").document.form.elements[i].disabled = true;
					}
				}
			}
		}		
	} else {
		if (parent.frames("t3frame").document.form) {
			if ( parent.frames("t3frame").document.form.fnl_cfm_flg.value != "Y" ) {
				for ( var i = 0; i < parent.frames("t3frame").document.form.elements.length; i++) {
					if (parent.frames("t3frame").document.form.elements[i].name.indexOf("rcv_term_cd") == 0) {
						parent.frames("t3frame").document.form.elements[i].disabled = false;
					}
				}
			}
		}
	}		
	
	document.form.bkg_por_yd_cd.value = "";
	compareItem();

	ComSetObjValue(formObj.route_modify_flag, "Y");
	ComSetObjValue(formObj.modify_flag, "Y");
    manageHaveRouteFlag("N");
}

function de_term_cd_OnChange(comboObj, value, text) {	
	var formObj = document.form;
	if(value!="M"){
		if (parent.frames("t3frame").document.form) {
			if ( parent.frames("t3frame").document.form.fnl_cfm_flg.value != "Y" ) {
				var cntrSheet = parent.frames("t3frame").sheetObjects[0];
				for(i=cntrSheet.HeaderRows;i<=cntrSheet.Rows;i++){
					cntrSheet.CellValue2(i, "de_term_cd") = value;
				}
				parent.frames("t3frame").setCopyFlag("false");
				for ( var i = 0; i < parent.frames("t3frame").document.form.elements.length; i++) {
					if (parent.frames("t3frame").document.form.elements[i].name.indexOf("de_term_cd") == 0) {
						parent.frames("t3frame").document.form.elements[i].value = value;
						parent.frames("t3frame").document.form.elements[i].disabled = true;
					}
				}
			}
		}		
	} else {
		if (parent.frames("t3frame").document.form) {
			if ( parent.frames("t3frame").document.form.fnl_cfm_flg.value != "Y" ) {
				for ( var i = 0; i < parent.frames("t3frame").document.form.elements.length; i++) {
					if (parent.frames("t3frame").document.form.elements[i].name.indexOf("de_term_cd") == 0) {
						parent.frames("t3frame").document.form.elements[i].disabled = false;
					}
				}
			}
		}
	}	
	
	document.form.bkg_del_yd_cd.value = "";
	compareItem();

	ComSetObjValue(formObj.route_modify_flag, "Y");
	ComSetObjValue(formObj.modify_flag, "Y");
    manageHaveRouteFlag("N");
}

function wgt_ut_cd_OnChange(comboObj, value, text) {
	var formObj = document.form;
	if (parent.frames("t4frame").document.form) {
		ComSetObjValue(parent.frames("t4frame").document.form.wgt_ut_cd, value);
//		parent.frames("t4frame").setCopyFlag("false");
	}
	
	setDiffCheckColor(text, formObj.estm_wgt_ut_cd2.value, ("estm_wgt_ut_cd2"));
}

//2011.11.28 jsy 
//function frt_term_cd_OnChange(comboObj, value, text) {
//	if (parent.tabObjects[0].SelectedIndex == 0) {
//		if (document.form.is_rated_flg.value == "Y") {
//			ComShowCodeMessage("BKG02065");
//		}
//	}
//	if (parent.frames("t4frame").document.form) {
//		ComSetObjValue(parent.frames("t4frame").document.form.frt_term_cd, value);
////		parent.frames("t4frame").setCopyFlag("false");
//	}
//	compareItem();
//}

function ida_hlg_tp_cd_OnChange(Code, Text){
	var formObj = document.form;		
	ComSetObjValue(formObj.modify_flag, "Y");		
	ComSetObjValue(formObj.route_modify_flag, "Y");
	manageHaveRouteFlag("N");
}

function por_pol_change(formObj){
	if(oldPolYdCd == formObj.bkg_por_cd.value + formObj.bkg_por_yd_cd.value){
		if(!ComIsNull(oldPolYdCd) && !ComIsNull(formObj.bkg_por_yd_cd.value)
				&& oldPolYdCd.trim() != "" && formObj.bkg_por_yd_cd.value.trim() != ""){
			formObj.bkg_por_cd.value    = formObj.bkg_pol_cd.value;
			formObj.bkg_por_yd_cd.value = formObj.bkg_pol_yd_cd.value;
			searchNupdateRoutNm(formObj.bkg_pol_cd.value, formObj.por_nm);
		}
	}			
	oldPolYdCd = formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
}
    
function pod_del_change(formObj){
	if(oldPodYdCd == formObj.bkg_del_cd.value + formObj.bkg_del_yd_cd.value){
		if(!ComIsNull(oldPodYdCd) && !ComIsNull(formObj.bkg_del_yd_cd.value)
				&& oldPodYdCd.trim() != "" && formObj.bkg_del_yd_cd.value.trim() != ""){
			formObj.bkg_del_cd.value    = formObj.bkg_pod_cd.value;
			formObj.bkg_del_yd_cd.value = formObj.bkg_pod_yd_cd.value;
			searchNupdateRoutNm(formObj.bkg_pod_cd.value, formObj.del_nm);
		}
	}			
	oldPodYdCd = formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
}

function cmdtChange(cmdtCd){
	var formObj = document.form;
	var chang = "N";
	if (parent.frames("t7frame").document.form) {
		var t7formObj = parent.frames("t7frame").document.form;
		var obj = null;
		for ( var i = 0; i < t7formObj.elements.length; i++) {
			if ((t7formObj.elements[i].name).indexOf("__") > 0) {
				obj = (t7formObj.elements[i].name).split("__");
				if(obj[0] == "cmdt_cd"){
					if ( ComIsNull(t7formObj.elements[i].value) ) {
						t7formObj.elements[i].value = ComLpad(cmdtCd,6,"0");
						chang = "Y";
					}
					// Cmdt Code가 변경이 되면 RF에는 Cmdt Desc도 변경해줌. 임종한 과장요청. 2010.05.14
				} else if(obj[0] == "cmdt_desc"){
					if ( ComIsNull(t7formObj.elements[i].value) || chang == "Y" ) {
						t7formObj.elements[i].value = formObj.cmdt_desc.value;
						chang = "N";
					}
				}
			}
		}		
	}
	chang = "N";
	if (parent.frames("t9frame").document.form) {
		var t9formObj = parent.frames("t9frame").document.form;
		var obj = null;
		for ( var i = 0; i < t9formObj.elements.length; i++) {
			if ((t9formObj.elements[i].name).indexOf("__") > 0) {
				obj = (t9formObj.elements[i].name).split("__");
				if(obj[0] == "cmdt_cd"){
					if ( ComIsNull(t9formObj.elements[i].value) ) {
						t9formObj.elements[i].value = ComLpad(cmdtCd,6,"0");
						chang = "Y";
					}
				// Cmdt Code가 변경이 되면 RF에는 Cmdt Desc도 변경해줌. 임종한 과장요청. 2010.05.14
				} else if(obj[0] == "cmdt_desc"){
					if ( ComIsNull(t9formObj.elements[i].value) || chang == "Y" ) {
						t9formObj.elements[i].value = formObj.cmdt_desc.value;
						chang = "N";
					}
				}
			}
		}		
	}	
	
	 
	var bkgPorCd   = ComGetObjValue(formObj.bkg_por_cd);
	var bkgPolCd   = ComGetObjValue(formObj.bkg_pol_cd);
	var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
	
	if( bkgPolCd.substring(0,2)=="US" && bkgPolCd!=bkgPorCd){
		if(cmdtCd =="740302" ||cmdtCd =="810001"||cmdtCd =="720400"||cmdtCd =="760300"){			
			comboObjects[5].Code2 = "S";
		} else if (cmdtCd =="980035" ||cmdtCd =="230330"||cmdtCd =="980034"||cmdtCd =="070002"||cmdtCd =="100100"||cmdtCd =="980031"){			
			comboObjects[5].Code2 = "G";
		} else {
			comboObjects[5].Code2 = "";
		}
	}		
	
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnSearchEnd(sheetObj, ErrMsg){	
	var formObj = document.form;
	if(ErrMsg == ""){
		setTotalVol(sheetObj);
		disabledFH(sheetObj, formObj);
        formObj.copy_esvc_doc.checked = true; /// 2011.06.13
        docReqCopyEsvc(); /// 2011.06.13
	}
	for(var i = 1 ; i < sheetObjects[0].Rows ; i++){
		sheetObjects[0].CellValue(i, "cntr_tpsz_cd_old") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");    
	}
	sheetObj.ColBackColor("cntr_tpsz_cd") = sheetObj.RgbColor(204, 255, 253);
	sheetObj.ColBackColor("op_cntr_qty") = sheetObj.RgbColor(204, 255, 253);
}

// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
function sheet1_OnAfterEdit(sheetObj, Row, Col){
	var formObj = document.form;
	setTotalVol(sheetObj);

	if(sheetObj.CellValue(Row, "ibflag") != "R"){
		ComSetObjValue(formObj.modify_flag, "Y");
		ComSetObjValue(formObj.carge_detail_pop, "N");// cargo detail이 수정되었음	
	}
	if(sheetObj.ColSaveName(Col) == "op_cntr_qty"||sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
		ComSetObjValue(formObj.qty_modify_flag, "Y");
		manageHaveRouteFlag("N");
		ComSetObjValue(formObj.aloc_chk_flg,"Y"); // Allocation 
	}
	compareQty();
}	

var befQty = "";
function sheet1_OnBeforeEdit(sheetObj, Row, Col, Value){		
	if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
		befQty = sheetObj.CellValue(Row, Col); 
	}
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	var srcName = sheetObj.ColSaveName(Col);
	setTotalVol(sheetObj);
	disabledFH(sheetObj, formObj);

	var tpVol = 0;
	var eqSub = 0;
	var soc = 0;
	if(ComIsNumber(sheetObj.CellValue(Row,"op_cntr_qty"), ".")){
		tpVol = parseFloat(sheetObj.CellValue(Row,"op_cntr_qty"));
	}
	if(ComIsNumber(sheetObj.CellValue(Row,"eq_subst_cgo_qty"), ".")){
		eqSub = parseFloat(sheetObj.CellValue(Row,"eq_subst_cgo_qty"));
	}
	if(ComIsNumber(sheetObj.CellValue(Row,"soc_qty"), ".")){
		soc = parseFloat(sheetObj.CellValue(Row,"soc_qty"));
	}			
	if(tpVol < eqSub){
		ComShowCodeMessage("BKG01007");
		sheetObj.CellValue2(Row, Col) = "";
		return;
	}
	if(tpVol < soc){
		ComShowCodeMessage("BKG01008");
		sheetObj.CellValue2(Row, Col) = "";
		return;
	}
	
//2010.07.06 류대영 주석처리	
//	if(tpVol < eqSub+soc){
//		ComShowCodeMessage("BKG02001");
//		sheetObj.CellValue2(Row, Col) = "";
//		return;
//	}
	
	// HangerVol보다 Qty를 적게 수정한 경우 
	if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
		if(parseFloat(sheetObj.CellValue(Row,"op_cntr_qty")) < parseFloat(sheetObj.CellValue(Row,"crr_hngr_qty"))+parseFloat(sheetObj.CellValue(Row,"mer_hngr_qty"))){
			ComShowCodeMessage("BKG00258");
			//sheetObj.CellValue2(Row, Col) = sheetObj.CellSearchValue(Row, "op_cntr_qty");	
			sheetObj.CellValue2(Row, Col) = befQty;
			return;
		}			
	}
	
	if(sheetObj.CellValue(Row,"eq_subst_cntr_tpsz_cd") != "" && (sheetObj.CellValue(Row,"cntr_tpsz_cd") == sheetObj.CellValue(Row,"eq_subst_cntr_tpsz_cd"))){
		ComShowCodeMessage("BKG02002");
		sheetObj.CellValue2(Row, Col) = "";	
		return false;
	}
	if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd"){
		if(!dupChkCntrTpSz()){
			sheetObj.CellValue2(Row, Col) = "";	
			return false;
		}
	}
	if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "op_cntr_qty" || sheetObj.ColSaveName(Col) == "eq_subst_cgo_qty" || sheetObj.ColSaveName(Col) == "soc_qty"){
		if(sheetObj.CellValue(Row, Col) != sheetObj.CellSearchValue(Row, Col)){
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
		}else{
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");		// Cargo Detail 화면을 Save시 띄우지 않는다.
		}			
	}	
}		

// Flexible Height 표기 여부
function disabledFH(sheetObj, formObj){
	var isDisAble = true;
	for(i = 1 ; i < sheetObj.Rows ; i++){
		if(sheetObj.CellValue(i, "cntr_tpsz_cd") == "D4" || sheetObj.CellValue(i, "cntr_tpsz_cd") == "D5"){
			isDisAble = false;
			break;
		}
	}		
	formObj.flex_hgt_flg.disabled = isDisAble;
	if (isDisAble) {
		formObj.flex_hgt_flg.checked = false;
		formObj.flex_hgt_flg.value = "N";
	} 
	else {
		if (formObj.flex_hgt_flg2.checked) 		formObj.flex_hgt_flg.checked = 1;
		if (formObj.flex_hgt_flg2.checked) 		formObj.flex_hgt_flg.value = formObj.flex_hgt_flg2.value;
	}
}

// Total Volumen 출력
function setTotalVol(sheetObj){
	var totalVol;
	for(i = 1 ; i < sheetObj.Rows ; i++){
		// RD 셋팅
		setRdCgoFlg(sheetObj, i);
		
		// Total Volumn
		if(i > 1){
			totalVol = totalVol + "," + sheetObj.CellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, "op_cntr_qty");
		}else{
			totalVol = sheetObj.CellValue(i, "cntr_tpsz_cd") + "X" + sheetObj.CellValue(i, "op_cntr_qty");
		}
	}
	// Total Vol 입력
	ComSetObjValue(document.form.total_vol, totalVol);		
}

// RD Cgo 출력
function setRdCgoFlg(sheetObj, Row){
	var isChange = false;
	if(sheetObj.CellValue(Row, "cntr_tpsz_cd") != "" && sheetObj.CellValue(Row, "eq_subst_cntr_tpsz_cd") != ""){
        var cntrTpszCd = sheetObj.CellValue(Row, "cntr_tpsz_cd").substring(0,1); /// 2011.06.20
        var eqTpszCd = sheetObj.CellValue(Row, "eq_subst_cntr_tpsz_cd").substring(0,1);
        
        if(cntrTpszCd == "R" && eqTpszCd == "D") {
               isChange = true;                                     
        }
	}
	
	if(isChange){
		sheetObj.CellValue2(Row, "rd_cgo_flg") = "RD";
		sheetObj.ColFontColor("rd_cgo_flg") = sheetObj.RgbColor(255,0,255);						
	}else{
		sheetObj.CellValue2(Row, "rd_cgo_flg") = "";
		//sheetObj.ColFontColor("rd_cgo_flg") = sheetObj.RgbColor(255,255,255);				
	}
}

function showBkCntc() {
	if (document.all.showBkCntc.style.display == "none") {
		document.all.showBkCntc.style.display = "block";
		document.all.showBkCntc.style.visibility = 'visible';
	} else {
		document.all.showBkCntc.style.display = "none";
		document.all.showBkCntc.style.visibility = 'hidden';
	}
}

function showXterDocReq() {
	if (document.all.showXterDocReq.style.display == "none") {
		document.all.showXterDocReq.style.display = "block";
		document.all.showXterDocReq.style.visibility = 'visible';
	} else {
		document.all.showXterDocReq.style.display = "none";
		document.all.showXterDocReq.style.visibility = 'hidden';
	}
}

function showXterRef() {
	if (document.all.showXterRef.style.display == "none") {
		document.all.showXterRef.style.display = "block";
		document.all.showXterRef.style.visibility = 'visible';
	} else {
		document.all.showXterRef.style.display = "none";
		document.all.showXterRef.style.visibility = 'hidden';
	}
}

function showBkgDocReq() {
	if (document.all.showBkgDocReq.style.display == "none") {
		document.all.showBkgDocReq.style.display = "block";
		document.all.showBkgDocReq.style.visibility = 'visible';
	} else {
		document.all.showBkgDocReq.style.display = "none";
		document.all.showBkgDocReq.style.visibility = 'hidden';
	}
}

function showBkgRef() {
	if (document.all.showBkgRef.style.display == "none") {
		document.all.showBkgRef.style.display = "block";
		document.all.showBkgRef.style.visibility = 'visible';
	} else {
		document.all.showBkgRef.style.display = "none";
		document.all.showBkgRef.style.visibility = 'hidden';
	}
}

function showSalesApproval() {
	if (document.all.showSalesApproval.style.display == "none") {
		document.all.showSalesApproval.style.display = "block";
		document.all.showSalesApproval.style.visibility = 'visible';
	} else {
		document.all.showSalesApproval.style.display = "none";
		document.all.showSalesApproval.style.visibility = 'hidden';
	}
}

//function makeComma2(obj) {
//	var val = makeComma(obj.value);
//	obj.value = val;
//}

function makeComma(srcValue) {
	var arrVal = srcValue.split(".");

	if (arrVal.length > 1) {
		if (arrVal[1].length > 2) {
			arrVal[1] = arrVal[1].substring(0, 2);
		}
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


function form_setEstWgtQty(value) {
	if (parent.frames("t4frame").document.form) {
		parent.frames("t4frame").document.form.act_wgt.value = makeComma(value);
//		parent.frames("t4frame").setCopyFlag("false");
	}
	compareItem();
}

function form_setShprCustCntCd(value) {
	var formObj = document.form;
	formObj.s_cust_cnt_cd.value = value;
	if (parent.frames("t2frame").document.form) {
		parent.frames("t2frame").document.form.sh_cust_cnt_cd.value = value;
//		parent.frames("t2frame").setCopyFlag("false");
//		parent.frames("t2frame").document.getElementById("sh_cust_cnt_cd").fireEvent("onchange");
	}
	compareItem();
}

function form_setShprCustSeq(value) {
	var formObj = document.form;
	if(ComLpad(value,6,"0")!="000000"){
		ComSetObjValue(formObj.s_cust_seq,ComLpad(value,6,"0"));
	}

	if (parent.frames("t2frame").document.form) {
		parent.frames("t2frame").document.form.sh_cust_seq.value = formObj.s_cust_seq.value;
//		parent.frames("t2frame").setCopyFlag("false");
//		parent.frames("t2frame").document.getElementById("sh_cust_seq").fireEvent("onchange");
	}
	compareItem();
}

function form_setFwdrCustCntCd(value) {
	var formObj = document.form;
	formObj.f_cust_cnt_cd.value = value;
	if (parent.frames("t2frame").document.form) {
		parent.frames("t2frame").document.form.ff_cust_cnt_cd.value = value;
		parent.frames("t2frame").setCopyFlag("false");
	}
	compareItem();
}

function form_setFwdrCustSeq(value) {
	var formObj = document.form;
	if(ComLpad(value,6,"0")!="000000"){
		ComSetObjValue(formObj.f_cust_seq,ComLpad(value,6,"0"));
	}
	if (parent.frames("t2frame").document.form) {
		parent.frames("t2frame").document.form.ff_cust_seq.value = formObj.f_cust_seq.value;
		parent.frames("t2frame").setCopyFlag("false");
	}
	compareItem();
}

// bkg route를 t/s route에 반영함
function bkgVvdChanged() {
	var formObj = document.form;
	var sheet3 = sheetObjects[2];	
	var row = 0;
	
	if (sheet3.RowCount > 0) {
		row = sheet3.FindText("vsl_pre_pst_cd", "T");
	} else {
		row = sheet3.DataInsert(-1);
		sheet3.CellValue2(row, "vsl_pre_pst_cd") = "T";
		sheet3.CellValue2(row, "vsl_seq") = "0";
	}
	sheet3.CellValue2(row, "bkg_vvd_cd") = formObj.bkg_trunk_vvd.value;
	sheet3.CellValue2(row, "pol_cd")     = formObj.bkg_pol_cd.value;
	sheet3.CellValue2(row, "pol_yd_cd")  = formObj.bkg_pol_yd_cd.value;
	sheet3.CellValue2(row, "pod_cd")     = formObj.bkg_pod_cd.value;
	sheet3.CellValue2(row, "pod_yd_cd")  = formObj.bkg_pod_yd_cd.value;
	compareItem();
}

function searchCustNm(formObj, custCntCd, custSeq, custTp){
	formObj.f_cmd.value = SEARCHLIST14;
	var param = "f_cmd="+ SEARCHLIST14 + "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq;
	var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq, param);

	if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
		if(custTp == "S"){
			ComSetObjValue(formObj.s_cust_nm,ComGetEtcData(sXml,"cust_nm"));
		}else if(custTp == "C"){
			ComSetObjValue(formObj.c_cust_nm,ComGetEtcData(sXml,"cust_nm"));
		}else{
			ComSetObjValue(formObj.f_cust_nm,ComGetEtcData(sXml,"cust_nm"));
		}
		//2013508 최문환 추가
		if(ComGetEtcData(sXml,"cust_nm")!=""){
			if(ComGetEtcData(sXml,"pb")=="Financial Risk"){
				var cust_rlse_ctrl_rmk = ComGetEtcData(sXml, "cust_rlse_ctrl_rmk");
				var ar_ofc             = ComGetEtcData(sXml, "ar_ofc");
				var srep_nm            = ComGetEtcData(sXml, "srep_nm");
				ComShowCodeMessage("BKG00055", cust_rlse_ctrl_rmk, ar_ofc, srep_nm);
			} else if(ComGetEtcData(sXml,"pb")=="Exceeding Credit Limit"){
                var cust_rlse_ctrl_rmk = "Exceeding Credit Limit";
                var ar_ofc             = ComGetEtcData(sXml, "ar_ofc");
                var srep_nm            = ComGetEtcData(sXml, "srep_nm");
                ComShowCodeMessage("BKG08344", cust_rlse_ctrl_rmk, ar_ofc, srep_nm);
			}

		}
	}else{
		if(custTp == "S"){
			ComSetObjValue(formObj.s_cust_nm,"");
		}else if(custTp == "C"){
			ComSetObjValue(formObj.c_cust_nm,"");
		}else{
			ComSetObjValue(formObj.f_cust_nm,"");
		}
	}				    			    	
}

function searchNupdateRoutNmAll(){
	var formObj = document.form;
	formObj.f_cmd.value = SEARCHLIST17;
	var locCd = formObj.bkg_por_cd2.value + "|" +
				formObj.bkg_pol_cd2.value + "|" +
				formObj.bkg_pod_cd2.value + "|" +
				formObj.bkg_del_cd2.value;

	var sXml = sheetObjects[2].GetSearchXml("ESM_Booking_UtilGS.do?input_text=" + escape(locCd), "f_cmd="+SEARCHLIST17);

	if (sXml != "") {
		var locNm = ComGetEtcData(sXml, "output_text").split("|");

		formObj.por_nm.value = locNm[0]==undefined?"":locNm[0];
		formObj.pol_nm.value = locNm[1]==undefined?"":locNm[1];
		formObj.pod_nm.value = locNm[2]==undefined?"":locNm[2];
		formObj.del_nm.value = locNm[3]==undefined?"":locNm[3];
		
		updateRoutStyle(formObj.por_nm);
		updateRoutStyle(formObj.pol_nm);
		updateRoutStyle(formObj.pod_nm);
		updateRoutStyle(formObj.del_nm);
	}
}

// location 별로 이름을 조회함
function searchNupdateRoutNm(locCd,elem) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCHLIST17;
	
	var sXml = sheetObjects[2].GetSearchXml("ESM_Booking_UtilGS.do?input_text=" + escape(locCd), "f_cmd="+SEARCHLIST17);

	if (sXml != "") {
		elem.value = ComGetEtcData(sXml, "output_text").substring(0, 25);		
		updateRoutStyle(elem);
	}
	validateTurkey();
}
 
// bkg의 location name을 eSvc쪽과 비교하여 색 변경 처리함
function updateRoutStyle(elem) {
	var elemList = new Array(
			//        ALPS    	vs  eSVC
		new Array("por_nm", 	"por_nm2"),
		new Array("pol_nm", 	"pol_nm2"),
		new Array("pod_nm", 	"pod_nm2"),
		new Array("del_nm", 	"del_nm2"),  
		new Array("fnl_dest_nm","fnl_dest_nm2"));
	
	// parameter로 받은 elem에 대응하는 eSVC 쪽 elem name을 찾음
	for (var i = 0; i < elemList.length; i++) {
		if (elemList[i][0] == elem.name) break;
	}
	if (i >= elemList.length) return;
	
	// eSVC 쪽 element를 가져 옴
	var orgElem = document.getElementsByName(elemList[i][1]);
	
	// ALPS와 BKG 쪽 양쪽 값을 비교하여 글자 색 변경
	if (orgElem[0].value != elem.value) {
		orgElem[0].style.color = "Red";
		elem.style.color = "Blue";
	} else {
		orgElem[0].style.color = "#606060";
		elem.style.color = "#606060";
	}
}

function searchVslNm(bkgTrunkVvd) {
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH02;

	try {
		var sXml = sheetObjects[4].GetSearchXml("ESM_BKG_0229_01GS.do", "f_cmd="+SEARCH02+"&bkg_trunk_vvd="+bkgTrunkVvd);
		var vslNm = ComGetEtcData(sXml, "vsl_nm");
		var etdDt = ComGetEtcData(sXml, "etd_dt");
		if (vslNm == 'null' || vslNm == '') {
			vslNm = "";
		}
		if (etdDt == 'null' || etdDt == '') {
			etdDt = "";
		}
		formObj.vsl_eng_nm.value = vslNm;
		formObj.chk_etd_dt.value = etdDt;
	} catch (err) {
		ComShowCodeMessage("BKG00094");
	}
}

/**
 * cmdt_cd 입력시 precaution 정보 조회
 */       
function validatePrecaution(formObj){
	formObj.f_cmd.value = SEARCHLIST11;
	var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11 + "&cmdt_cd="+formObj.cmdt_cd.value);
	if (sXml != "") {
		ComSetObjValue(formObj.rep_cmdt_cd, ComGetEtcData(sXml,"rep_cmdt_cd"));		
		ComSetObjValue(formObj.cmdt_desc, ComGetEtcData(sXml,"cmdt_nm"));

		setPrecaution(formObj, ComGetEtcData(sXml,"rep_imdg_lvl_cd"));
		ComSetObjValue(formObj.validPrecaution, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	}
	if( ComGetObjValue(formObj.cmdt_cd) =='960151' || ComGetObjValue(formObj.cmdt_cd) =='960316' ) {
		ComSetObjValue(formObj.bkg_cgo_tp_cd, "R");
	}
} 

 function setPrecaution(formObj, precaution){
	var stwgCd = formObj.stwg_cd.value;
 	if(precaution == "P"){
 		// 나중에 공통함수 만들어 사용(callBack0657 과 공통으로 사용못하는 경우)
 		// 01. DANGER,REFFER,AWKWARD,B/B 가 아닌경우
 		var isChecked = true;
 		if(formObj.dcgo_flg.checked || formObj.rc_flg.checked || formObj.awk_cgo_flg.checked || formObj.bb_cgo_flg.checked){
 			isChecked = false;
 		}
 		var isSoc = true;
 		// 02. SOC가 아닌경우			
 		for ( i = 1 ; i < sheetObjects[0].Rows ; i++ ){				
 			if(sheetObjects[0].CellValue(i, "soc_qty" ) != "" && sheetObjects[0].CellValue(i, "soc_qty" ) > 0){
 				isSoc = false;
 				break;
 			}
 		}				
 		if(isChecked && isSoc){
 			ComShowCodeMessage("BKG00256");
 		}				
 		
 		formObj.prct_flg.checked = true;
 		formObj.prct_flg.value = "Y";
 		formObj.prct_tmp.value = "Y" //화면 Edit 여부
 		
		//formObj.stwg_cd.value = "PC";
		//formObj.stwg_tmp.value = "PC";
 		
 	} else if(precaution == "H"){
 		// RAW/WET HIDE COMMODITY에 대하여 AUTO HIDE FLAGGING 구현
 		formObj.spcl_hide_flg.checked = true;
 		formObj.spcl_hide_flg.value = "Y";
 		formObj.hide_tmp.value = "Y";      //화면 Edit 여부
		ComShowCodeMessage("BKG08351");
 		formObj.stwg_cd.value = "ODHD";
		formObj.stwg_tmp.value = "HD"; 
	} else {
    	formObj.prct_flg.checked = false;
 		formObj.prct_flg.value = "N";
 		formObj.prct_tmp.value = "N" 
    }
   	
 }
 
 function sendBkgCloseMail(subject, closeBkgMsg){
	 ComBkgGroupMailset(sheetObjects[2], document.form, subject, closeBkgMsg);
 }

// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
function checkEgyptDeTerm(srcValue) {
	if((srcValue == "EGALY" || srcValue == "EGPSD") 
			&& ComGetObjValue(document.form.rfa_no) != "BUD12A0115"
			&& ComGetObjValue(document.form.rfa_no) != "BUD13A0167"
			&& ComGetObjValue(document.form.rfa_no) != "BUD14A0062"
			&& ComGetObjValue(document.form.rfa_no) != "BUD15A0078"   
			&& ComGetObjValue(document.form.rfa_no) != "NKG16A0165" // 2016-04-18
			&& ComGetObjValue(document.form.rfa_no) != "BUD16A0057" // 2016-05-12
			&& ComGetObjValue(document.form.rfa_no) != "NKG16C0407" // 2016-07-18
			&& ComGetObjValue(document.form.rfa_no) != "NKG15A1235") {
		if (comboObjects[1].Code != "O") {
			ComShowCodeMessage("BKG00020");
			comboObjects[1].Code = "O";
			return false;
		}
	}
	return true;
}

// POD, POL에 'TZDAR' 입력시 DEL Term 체크
function checkTanzaniaDeTerm(pod_cd, del_cd, mode){
	var formObj = document.form;
	// 1. 자동적으로 제일 먼저 CY로 선택되도록 auto-reflect 처리 
	// 2. Door와 CFS는 User가 선택할 경우 저장 되도록 허용 : 선택 후 Save 누를 시 팝업 보여주고 Yes 누르면 저장 허용
	// 3. Mixed, Tackle 그리고 Free Out은 아예 저장 되지 않도록 Block : 선택 후 Save 누를 시 팝업 보여주고 저장 진행 하지 않음
	if(pod_cd == "TZDAR" || del_cd == "TZDAR") {
		if(mode == "check"){
			if(ComGetObjValue(formObj.route_modify_flag) == "Y"){
				if(comboObjects[1].Code == "Y"){
					return true;
				}else if(comboObjects[1].Code == "D" || comboObjects[1].Code == "S"){
					if(ComShowConfirm(ComGetMsg("BKG08301"))){
						return true;
					}else{
						return false;
					}
				}else{
					ComShowCodeMessage("BKG08302");		
					return false;
				}
			}
		}else{
			comboObjects[1].Code = "Y";
			return true;
		}
	}		
	return true;
}

//POD, DEL에 Thailand 향 Consol Booking 입력시 DEL Term 체크
function checkThailandDeTerm(pod_cd, del_cd, mode){
	var formObj = document.form;
	// 1. Consol 인 경우 자동적으로 제일 먼저 CFS로 선택되도록 auto-reflect 처리 
	// 2. External Remark에 적힌 “Consol” 내용을 확인 후 Commodity Code를 (000004, 000010, 000017)로 저장한 경우
	
	/* 박유숙 부장님 요청으로 주석 2017-04-27 IS.Jung
	if(pod_cd.substring(0,2) == "TH" || del_cd.substring(0,2) == "TH") {
		if(mode == "check"){
			if(comboObjects[1].Code == "S" && parent.frames("t2frame").document.form.kr_cstms_cust_tp_cd.Code == 'C'){
				return true;
			}else if (comboObjects[1].Code != "S" && parent.frames("t2frame").document.form.kr_cstms_cust_tp_cd.Code == 'C'){
				if(ComShowConfirm(ComGetMsg("BKG08309"))){
					return true;
				}else{
					return false;
				}
			}else if (comboObjects[1].Code != "S" ){
				if (BkgIsContainsChars(formObj.xter_rmk,"consol") || ComGetObjValue(formObj.cmdt_cd) == '000004' || ComGetObjValue(formObj.cmdt_cd) == '000010' || ComGetObjValue(formObj.cmdt_cd) == '000017') {
					if(ComShowConfirm(ComGetMsg("BKG08309"))){
						return true;
					}else{
						return false;
					}
				}
			}
		}else{
			return true;
		}
	}		*/
	
	return true;
}
// POL, POD가 TR, DZ, MA, MT, TN 인 경우 R/D Term CY 불가
function checkMaltaTerm(polCd, podCd){
	if(polCd.substring(0, 2)=="TR"||polCd.substring(0, 2)=="DZ"||polCd.substring(0, 2)=="MA"
		||polCd.substring(0, 2)=="MT"||polCd.substring(0, 2)=="TN"|| polCd.substring(0, 2)=="GR"){
		if(comboObjects[0].Code == "Y"){
			if (ComGetObjValue(document.form.rfa_no) == "TYO15A0725"){
				 // pass
			} else {
				ComShowCodeMessage("BKG95120",polCd.substring(0, 2));//"For export cargoes from {?msg1}, CY term is prohibited. Please change R term."
				return false;
			}
			
		}		
	}
	if(podCd.substring(0, 2)=="TR"||podCd.substring(0, 2)=="DZ"||podCd.substring(0, 2)=="MA"
		||podCd.substring(0, 2)=="MT"||podCd.substring(0, 2)=="TN" || podCd.substring(0, 2)=="GR"){
		if(comboObjects[1].Code == "Y"){
			if (ComGetObjValue(document.form.rfa_no) == "TYO15A0725"|| (podCd.substring(0, 2)=="TR" && ComGetObjValue(document.form.rfa_no) == "PKG16C0371") ){
				 // pass
			} else {
				ComShowCodeMessage("BKG95121",podCd.substring(0, 2));//"For import cargoes to {?msg1}, CY term is prohibited. Please change D term."
				return false;
			}
		}		
	}
	return true;
}

//나이지리아가 dest인 경우 cmdt 변경시마다 message
function checkNigeriaCmdt(podCd, delCd){
	if(podCd.substring(0, 2)=="NG"||delCd.substring(0, 2)=="NG"){
		if(ComShowConfirm(ComGetMsg("BKG02051"))) {
			ComOpenWindow("http://www.customs.gov.ng/ProhibitionList/import.php", "", "", false);
		}
//		ComShowCodeMessage("BKG02051");
		//url을 붙여넣기 할 수 있게 함
//		window.clipboardData.setData("URL","http://www.customs.gov.ng/ProhibitionList/import.php");
	}
}

//CntrTpSz 입력여부 확인 및 중복정보 입력여부 확인
function chkCntrTpSz(){
	// TP/SZ 입력여부 확인
	if(sheetObjects[0].FindText("cntr_tpsz_cd","",-1) > 0){
		ComShowCodeMessage("BKG01013");		
		return false;    				
	}
	
	return dupChkCntrTpSz();
}

function dupChkCntrTpSz(){
	var dupCntrTp = sheetObjects[0].ColValueDupRows("cntr_tpsz_cd", false, true);
	if (dupCntrTp != null && dupCntrTp != "") {	// 동일한 TP/SZ가 두번 이상 입력된 경우
		if((dupCntrTp.split("|")[0],"cntr_tpsz_cd")!=null && (dupCntrTp.split("|")[0],"cntr_tpsz_cd")!=""){
			ComShowCodeMessage("BKG00038",sheetObjects[0].CellValue(dupCntrTp.split("|")[0],"cntr_tpsz_cd"));				
			return false;
		}
	}     
	return true;
}    

// 자동 계산 여부 확인
function checkAutoCaluate(formObj){
	var autoCalCnt = 0;
	var rfCnt = 0;
	var sheetObj = sheetObjects[0];
	
	// 한개의 Container가 DR,DG 나누어져 있는 경우 PopUp
	if(ComGetObjValue(formObj.dcgo_flg) == "Y" && sheetObjects[3].RowCount > 1){
		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){		
			cntrTpSz = sheetObj.CellValue(i, "cntr_tpsz_cd");
			drdgCnt = 0;
			for(var k = sheetObjects[3].HeaderRows ; k < sheetObjects[3].Rows ; k++){	
				// 같은 container가 아니더라도 섞여있으면 자동계산하지 않음
//				if(cntrTpSz == sheetObjects[3].CellValue(k, "cntr_tpsz_cd")){
					if(sheetObjects[3].CellValue(k, "dry_cgo_flg") == 1){
						drdgCnt = drdgCnt+1;
					}
					if(sheetObjects[3].CellValue(k, "dcgo_flg") == 1){
						drdgCnt = drdgCnt+1;
					}						
//				}
			}
		
			if(drdgCnt > 1){
				return false;
			}							
		}
	}
	
	// Hanger 값 존재시
	if(ComGetObjValue(formObj.hngr_flg) == "Y"){
		// EqSub,SOC와 TotalVol과 전체 Vol이 같은경우만 자동계산
		for(var i = sheetObj.HeaderRows ; i < sheetObjects[0].Rows ; i++){
			if(ComIsNumber(sheetObj.CellValue(i,"eq_subst_cgo_qty"), ".") && parseFloat(sheetObj.CellValue(i,"eq_subst_cgo_qty")) > 0){
				if(parseFloat(sheetObj.CellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.CellValue(i,"eq_subst_cgo_qty"))){
					return false;
				}
			}				
			if(ComIsNumber(sheetObj.CellValue(i,"soc_qty"), ".") && parseFloat(sheetObj.CellValue(i,"soc_qty")) > 0){
				if(parseFloat(sheetObj.CellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.CellValue(i,"soc_qty"))){
					return false;
				}
			}		
			if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
				if(parseFloat(sheetObj.CellValue(i,"op_cntr_qty")) == (parseFloat(sheetObj.CellValue(i,"crr_hngr_qty"))+parseFloat(sheetObj.CellValue(i,"mer_hngr_qty")))){
					return false;
				}
			}				
		}

	}
	
	// Special Cargo 체크
	if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
		autoCalCnt++;
	}
	if(ComGetObjValue(formObj.rc_flg) == "Y"){
		rfCnt++;
	}
	if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
		autoCalCnt++;
	}
	if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
		autoCalCnt++;
	}		
	// EQ Sub, SOC, RD 체크
	// EQ Sub, SOC Vol이 전체 Vol과 동일하면 자동계산
	var eqSubCnt = 0;	// 20090908 임종환 과장님 요청으로 EQ Sub까지는 자동 계산		               
	var socCnt = 0;		
	var rdCnt = 0;
	for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
		if(eqSubCnt < 1){
			if(sheetObj.CellValue(i,"eq_subst_cntr_tpsz_cd") != "" && sheetObj.CellValue(i,"rd_cgo_flg") == ""){
				if(ComIsNumber(sheetObj.CellValue(i,"eq_subst_cgo_qty"), ".") && parseFloat(sheetObj.CellValue(i,"eq_subst_cgo_qty")) > 0){
					if(parseFloat(sheetObj.CellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.CellValue(i,"eq_subst_cgo_qty"))){
						eqSubCnt++;
					}
				}					
			}				
		}			
		if(socCnt < 1){
			if(ComIsNumber(sheetObj.CellValue(i,"soc_qty"), ".") && parseFloat(sheetObj.CellValue(i,"soc_qty")) > 0){
				if(parseFloat(sheetObj.CellValue(i,"op_cntr_qty")) !=  parseFloat(sheetObj.CellValue(i,"soc_qty"))){
					socCnt++;
				}
			}			
		}	
		if(rdCnt < 1){
			if(sheetObj.CellValue(i,"rd_cgo_flg") != ""){
				rdCnt++;
			}				
		}					
	}		
	// R/D Term Validation
	// 01. Other Term -> 'M'으로 변경시 PopUp
	// 20100107 수정 - R/D 'M' 이면 자동계산 안함.
	if(ComGetObjValue(formObj.rcv_term_cd) == "M" || ComGetObjValue(formObj.de_term_cd) == "M"){
		autoCalCnt = autoCalCnt + 2;;
	}
	
	if(autoCalCnt+eqSubCnt+socCnt+rfCnt+rdCnt > 1){
		if(autoCalCnt+eqSubCnt+socCnt < 1){
			return true;
		}else{
			if(autoCalCnt+rfCnt+rdCnt == 0 && eqSubCnt+socCnt == 2){
				return true;
			}else{
				return false;
			}
		}			
	}else{
		return true;
	}
}

// 0079에서는 sheetObjects[4]이 여기서는 sheetObjects[3]임
function resetQtyDetail(){
   var formObj = document.form;
   //if(checkAutoCaluate(formObj) || sheetObjects[3].RowCount < 1){		   
   if(checkAutoCaluate(formObj)){
	   // 자동계산해서 정보 저장 및 Popup
	   // PopUp Open없이 자동 계산인 경우 지우고 다시 계산한다.
	   var qtyDtlRow;
	   for(var i = sheetObjects[3].Rows  ; i >= sheetObjects[3].HeaderRows ; i-- ){
		   sheetObjects[3].RowDelete(i,false);	
	   }					  

	   for(var i = sheetObjects[0].HeaderRows  ; i < sheetObjects[0].Rows ; i++ ){		
		   cntrQty = sheetObjects[0].CellValue(i, "op_cntr_qty");
		   // EQ Sub가 있으면 Total Qty에서 Eq Sub를 뺀다.			   
		   eqSubSameQty = false;
		   socSameQty = false;
		   if(sheetObjects[0].CellValue(i, "eq_subst_cgo_qty") > 0){
			   if(sheetObjects[0].CellValue(i, "op_cntr_qty") == sheetObjects[0].CellValue(i, "eq_subst_cgo_qty")){
				   eqSubSameQty = true;
				   existEqSub = false;
			   }else{
				   existEqSub = true;
			   }
			   
		   }else{
			   existEqSub = false;
		   }
		   if(sheetObjects[0].CellValue(i, "soc_qty") > 0){
			   if(sheetObjects[0].CellValue(i, "op_cntr_qty") == sheetObjects[0].CellValue(i, "soc_qty")){
				   socSameQty = true;
			   }
		   }
		   if(existEqSub){				   
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "eq_subst_cgo_qty");
			   
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");				   
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "eq_subst_cgo_qty");
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, sheetObjects[0].CellValue(i, "rd_cgo_flg"), sheetObjects[0], "N");
			   }
		   }
		   // SOC가 존재하면 Total Qty에서 SOC를 뺀다.
		   if(sheetObjects[0].CellValue(i, "soc_qty") > 0 && sheetObjects[0].CellValue(i, "op_cntr_qty") != sheetObjects[0].CellValue(i, "soc_qty")){
			   existSocQty = true;
		   }else{
			   existSocQty = false;
		   }			   
		   if(existSocQty){
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "soc_qty");

			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   
			   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			   
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "soc_qty");				   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "N");
			   }
		   }			   
		   // Hanger가 존재하는 경우 Row 추가 후 자동 계산
		   if( sheetObjects[0].CellValue(i, "crr_hngr_sgl_bar_qty") > 0){
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "crr_hngr_sgl_bar_qty");
		 
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg") = 1;
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "crr_hngr_sgl_bar_qty");
			   if(eqSubSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");
			   }				
			   if(socSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			 
			   }						   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
			   }
		   }
		   if( sheetObjects[0].CellValue(i, "crr_hngr_dbl_bar_qty") > 0){
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "crr_hngr_dbl_bar_qty");
		 
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg") = 1;
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "crr_hngr_dbl_bar_qty");	
			   if(eqSubSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");
			   }						  
			   if(socSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			 
			   }					   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
			   }
		   }				
		   if( sheetObjects[0].CellValue(i, "crr_hngr_tpl_bar_qty") > 0){
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "crr_hngr_tpl_bar_qty");
		 
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg") = 1;
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "crr_hngr_tpl_bar_qty");		
			   if(eqSubSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");
			   }				
			   if(socSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			 
			   }					   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
			   }
		   }			
		   if( sheetObjects[0].CellValue(i, "mer_hngr_qty") > 0){
			   cntrQty = cntrQty-sheetObjects[0].CellValue(i, "mer_hngr_qty");
		 
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "mer_hngr_flg") = 1;
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[0].CellValue(i, "mer_hngr_qty");		
			   if(eqSubSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");
			   }						   
			   if(socSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			 
			   }					   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "Y");
			   }
		   }	
		   
		   if(cntrQty > 0){		
			   qtyDtlRow = sheetObjects[3].DataInsert(-1);
			   sheetObjects[3].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
			   sheetObjects[3].CellValue(qtyDtlRow, "op_cntr_qty") = cntrQty;
			   if(eqSubSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd");
			   }			
			   if(socSameQty){
				   sheetObjects[3].CellValue(qtyDtlRow, "soc_flg") = 1;			 
			   }					   
			   sheetObjects[3].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
			   sheetObjects[3].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
			   
			   if(isVolDetailAutoChk()){
				   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "N");
			   }
		   }
	   }
   }else{
	   // 자동계산이 아닌 경우 PopUp에서 계산한다.
   }
}   


// RD,SOC,EQ SUB Flag Setting
 function setRdSocEqSubFlg(formObj){
	 var rdCnt = 0;
	 var socCnt = 0;
	 var eqCnt = 0;
	 for(i = 1 ; i < sheetObjects[0].Rows ; i++){
		if(sheetObjects[0].CellValue(i, "rd_cgo_flg") == "RD"){
			rdCnt++;
		}
		if(sheetObjects[0].CellValue(i, "soc_qty") != "" && sheetObjects[0].CellValue(i, "soc_qty" ) > 0){
			socCnt++;
		}    		
		if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
			eqCnt++;
		}    	    				
	 }    			
	 
	 if(rdCnt > 0){
		ComSetObjValue(formObj.rd_cgo_flg, "Y");    				
	 }else{
		ComSetObjValue(formObj.rd_cgo_flg, "N");
	 }
	 if(socCnt > 0){
		ComSetObjValue(formObj.soc_flg, "Y");    				
	 }else{
		ComSetObjValue(formObj.soc_flg, "N");
	 }
	 if(eqCnt > 0){
		ComSetObjValue(formObj.eq_subst_flg, "Y");    				
	 }else{
		ComSetObjValue(formObj.eq_subst_flg, "N");
	 }    	    	 
 }

/**
 * MT PickUp CY Inquiry 에서 전달받은 값 저장 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0019(rArray);
 * </pre>
 * 
 * @param Popup에서
 *            전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0019(rArray) {
	var formObj = document.form;
	if (rArray != null) {
		formObj.bkg_trunk_vvd.value = rArray[0][3];
		formObj.vsl_eng_nm.value    = rArray[0][4];

		formObj.route_modify_flag.value = "Y";
		//formObj.modify_flag.value = "Y";
		manageHaveRouteFlag("N");

		if (rArray[0][3].substring(0, 4) == "HJXX"
				|| rArray[0][3].substring(0, 4) == "HJYY"
				|| rArray[0][3].substring(0, 4) == "HJZZ") {
			formObj.psdo_bkg_flg.value = "Y";
		} else {
			formObj.psdo_bkg_flg.value = "N";
		}

		if(sheetObjects[2].RowCount == 1){
			sheetObjects[2].CellValue(1, "vsl_pre_pst_cd") = "T";
			sheetObjects[2].CellValue(1, "vsl_seq") = "0";
			sheetObjects[2].CellValue(1, "bkg_vvd_cd") = rArray[0][3];
			sheetObjects[2].CellValue(1, "pol_clpt_ind_seq") = "1";
			sheetObjects[2].CellValue(1, "pod_clpt_ind_seq") = "1";
			sheetObjects[2].CellValue(1, "bkg_vvd_cd") = rArray[0][3];
			sheetObjects[2].CellValue(1, "etd_day") = rArray[0][10];
			sheetObjects[2].CellValue(1, "eta_day") = rArray[0][14];
			
			formObj.chk_etd_dt.value =  rArray[0][10];
		}
		searchVslNm(formObj.bkg_trunk_vvd.value);
		ComSetObjValue(formObj.check_ts_close_flag, "Y");
		bkgVvdChanged();
	}	
}
/**
 * MT PickUp CY Inquiry 에서 전달받은 값 저장 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0082(rArray);
 * </pre>
 * 
 * @param Popup에서
 *            전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0082(rArray) {
	var formObj = document.form;
	if (rArray != null) {
		formObj.mty_pkup_yd_cd.value = rArray[0][2];

		formObj.route_modify_flag.value = "Y";
		formObj.modify_flag.value = "Y";
 		manageHaveRouteFlag("N");
	}
}

/**
 * Node Search 팝업에서 전달받은 값 저장 <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBack0083(bkgCustTpCd, custCntCd, custSeq, custNm);
 * </pre>
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0083(locTp, tab, rArray){
	var formObj = document.form;
	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
		if(rArray != null){
			if(tab == 1){
				if(locTp == "POR"){
					ComSetObjValue(formObj.bkg_por_cd, rArray[0][2]);
					ComSetObjValue(formObj.por_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_por_yd_cd, "");
				}else if(locTp == "POL"){
					ComSetObjValue(formObj.bkg_pol_cd, rArray[0][2]);
					ComSetObjValue(formObj.pol_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_pol_yd_cd, "");
					checkMaltaTerm(rArray[0][2],"");
					por_pol_change(formObj);
				}else if(locTp == "POD"){
					ComSetObjValue(formObj.bkg_pod_cd, rArray[0][2]);
					ComSetObjValue(formObj.pod_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_pod_yd_cd, "");
					// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
					checkEgyptDeTerm(rArray[0][2]);
					checkTanzaniaDeTerm(rArray[0][2], "", "");
					checkThailandDeTerm(rArray[0][2], "", "");
					checkMaltaTerm("",rArray[0][2]);
					pod_del_change(formObj);
				}else{
					ComSetObjValue(formObj.bkg_del_cd, rArray[0][2]);
					ComSetObjValue(formObj.del_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_del_yd_cd, "");
					checkTanzaniaDeTerm("", rArray[0][2], "");
					checkThailandDeTerm("", rArray[0][2], "");
					if(formObj.alps2.value == "No"){
						var t2formObj = parent.document.frames("t2frame").form;
						if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(rArray[0][2])){
							ComSetObjValue(t2formObj.cn_cust_cnt_cd, rArray[0][2].substring(0,2));
						}
 						if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(rArray[0][2])){
							ComSetObjValue(t2formObj.nf_cust_cnt_cd, rArray[0][2].substring(0,2));
						}
					}
				}
			} else {
				if(locTp == "POR"){
					ComSetObjValue(formObj.bkg_por_cd, rArray[0][4].substring(0,5));
					ComSetObjValue(formObj.por_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_por_yd_cd, rArray[0][4].substring(5,7));
				}else if(locTp == "POL"){
					ComSetObjValue(formObj.bkg_pol_cd, rArray[0][4].substring(0,5));
					ComSetObjValue(formObj.pol_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_pol_yd_cd, rArray[0][4].substring(5,7));
					por_pol_change(formObj);
				}else if(locTp == "POD"){
					ComSetObjValue(formObj.bkg_pod_cd, rArray[0][4].substring(0,5));
					ComSetObjValue(formObj.pod_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_pod_yd_cd, rArray[0][4].substring(5,7));
					// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
					checkEgyptDeTerm(rArray[0][4].substring(0,5));
					checkTanzaniaDeTerm(rArray[0][4].substring(0,5), "", "");
					checkThailandDeTerm(rArray[0][4].substring(0,5), "", "");
					pod_del_change(formObj);
				}else{
					ComSetObjValue(formObj.bkg_del_cd, rArray[0][4].substring(0,5));
					ComSetObjValue(formObj.del_nm, rArray[0][3].substring(0,25));
					ComSetObjValue(formObj.bkg_del_yd_cd, rArray[0][4].substring(5,7));
	 				if(formObj.alps2.value == "No"){
						var t2formObj = parent.document.frames("t2frame").form;
						if(ComIsNull(t2formObj.cn_cust_seq.value) && !ComIsNull(rArray[0][4])){
							ComSetObjValue(t2formObj.cn_cust_cnt_cd, rArray[0][4].substring(0,2));
						}
 						if(ComIsNull(t2formObj.nf_cust_seq.value) && !ComIsNull(rArray[0][4])){
							ComSetObjValue(t2formObj.nf_cust_cnt_cd, rArray[0][4].substring(0,2));
						}
					}
	 				checkTanzaniaDeTerm("", rArray[0][4].substring(0,5), "");
	 				checkThailandDeTerm("", rArray[0][4].substring(0,5), "");
				}
				if ("POD"==locTp) {
					validateTurkey(formObj.bkg_pod_cd);
				} else if ("DEL"==locTp) {
					validateTurkey(formObj.bkg_del_cd);
				}
			}
			ComSetObjValue(formObj.route_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
			manageHaveRouteFlag("N");
		}
	}
}

/**
 * Full Return CY 팝업에서 전달받은 값 저장 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0088(rArray);
 * </pre>
 * 
 * @param Popup에서 전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0088(rArray) {
	var formObj = document.form;
	if (rArray != null) {
		formObj.full_rtn_yd_cd.value = rArray[0][2];

		formObj.route_modify_flag.value = "Y";
		formObj.modify_flag.value = "Y";
 		manageHaveRouteFlag("N");
	}
}

/**
 * Route Detail 팝업 호출. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * comBkgCallPop0092(callback_func, bkgNo);
 * </pre>
 * 
 * @param {string}
 *            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function comBkgCallPop0092(callback_func, bkgNo, bkgTrunkVvd, caFlg, callSheetIdx) {
	var formObj = document.form;    
	//2012.01.05 portSkpFlg parameter 추가 kbj
	var url = "ESM_BKG_0092.do?pgmNo=ESM_BKG_0092&bkg_no="+bkgNo+"&bkgTrunkVvd="+bkgTrunkVvd+"&ca_flg="+caFlg+"&callSheetIdx="+callSheetIdx+"&portSkpFlg="+formObj.port_skp_flg.value;
	if(ComGetObjValue(formObj.is_vl_flg) == "Y"){
		url = url + "&displayOnly=1";
	}
	ComOpenPopup(url, 700, 490, callback_func,"1,0,1,1,1", true);
}

/**
 * Route Detail 처리 후 작업 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0092();
 * </pre>
 * 
 * @param Popup에서
 *            전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0092() {
	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	if(sheetObj.RowCount>0){
		// 01. PrePostCd가 'T' 인 Vvd를 Main에 넣는다.
		ComSetObjValue(formObj.bkg_trunk_vvd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd"));
         	
		// 01-01. PRE RELAY 입력
		if (sheetObj.FindText("vsl_pre_pst_cd", "T") > 1) {
			ComSetObjValue(formObj.pre_rly_port_cd,    sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_cd"));
         	ComSetObjValue(formObj.pre_rly_port_yd_cd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_yd_cd"));
		}
	
		// 01-02. POST REPAY 입력
		if (sheetObj.FindText("vsl_pre_pst_cd", "T") + 1 < sheetObj.Rows) {
			ComSetObjValue(formObj.pst_rly_port_cd,    sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd"));
        	ComSetObjValue(formObj.pst_rly_port_yd_cd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd"));
		}
		// 02. 첫번째데이터의 POL을 BKG POL에 넣는다.(20100119 추가)
        ComSetObjValue(formObj.bkg_pol_cd,    sheetObj.CellValue(1,"pol_cd"));
        ComSetObjValue(formObj.bkg_pol_yd_cd, sheetObj.CellValue(1,"pol_yd_cd"));        	
        // 02. 마지막데이터의 POD를 BKG POD에 넣는다.(20100119 추가)
        ComSetObjValue(formObj.bkg_pod_cd,    sheetObj.CellValue(sheetObj.RowCount,"pod_cd"));
        ComSetObjValue(formObj.bkg_pod_yd_cd, sheetObj.CellValue(sheetObj.RowCount,"pod_yd_cd"));
	} else {     		
	  	ComSetObjValue(formObj.pre_rly_port_cd, "");
     	ComSetObjValue(formObj.pre_rly_port_yd_cd, "");
     		
     	ComSetObjValue(formObj.pst_rly_port_cd, "");
     	ComSetObjValue(formObj.pst_rly_port_yd_cd, "");
	}

	formObj.route_modify_flag.value = "Y";
	formObj.modify_flag.value = "Y";
	formObj.have_route_flag.value = "N";

	if (formObj.bkg_trunk_vvd.value.length > 4) {
		var pseudoVvd = formObj.bkg_trunk_vvd.value.substring(0, 4);
		if (pseudoVvd == "HJXX" || pseudoVvd == "HJYY" || pseudoVvd == "HJZZ") {
			formObj.psdo_bkg_flg.value = "Y";
		} else {
			formObj.psdo_bkg_flg.value = "N";
			searchVslNm(formObj.bkg_trunk_vvd.value);
		}
	}
	
	// 2012.01.05 btn_route의 색이 red가 아닌경우에만 port_skp_flg가 'Y'면 green으로 표시 kbj
	if(formObj.vvd_flg.value != 'N'){
		changeObjectColor(formObj.port_skp_flg.value, "Y", "btn_t1RouteDetail", "00cc00", "btn2");
	}
	
	por_pol_change(formObj);
 	pod_del_change(formObj);
 	
 	route_detail_modify_flag = "Y";
}

/**
 * Customer Popup에서 전달받은 값 저장 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0652(bkgCustTpCd, rArray1, rArray2);
 * </pre>
 * 
 * @param Popup에서
 *            전달받은 값
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
	var formObj = document.form;
	// SHPR,FWDR 입력
	if(rArray1 != null){
		if(bkgCustTpCd == "S"){		
			form_setShprCustCntCd(rArray1[0][14].substring(0,2));
			form_setShprCustSeq(ComLpad(rArray1[0][15],6,"0"));
			ComSetObjValue(formObj.s_cust_nm, rArray1[0][5]);

    		// 20100113 추가
    		if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
    			if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) || ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
    				ComSetObjValue(formObj.s_cust_subst_flg, "Y");
    			}
    		}
    		// 20100118 추가 - FW Code
    		if(rArray2 != null){
    			
				if(rArray2[0][8] != ""){
					form_setFwdrCustCntCd(rArray2[0][8].substring(0,2));
					form_setFwdrCustSeq(ComLpad(rArray2[0][8].substring(2),6,"0"));				    					
				}else{
//					form_setFwdrCustCntCd("");
//					form_setFwdrCustSeq("");				    					
				}

    			if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
	    			if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) || ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
	    				if(ComShowCodeConfirm("BKG00343")){
	    					ComSetObjValue(formObj.f_cust_subst_flg, "Y");
	    				}else{
	    					ComSetObjValue(formObj.f_cust_subst_flg, "N");
	    				}
	    			}		    		    		
	    			searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");		    				
    			} else {
    				if(rArray2[0][8] != ""){
    					searchCustNm(formObj, ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "F");
    				}
    			}
    		}
    		ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
    		ComSetObjValue(formObj.ob_srep_cd,    lRep);
		}else if(bkgCustTpCd == "F"){
			form_setFwdrCustCntCd(rArray1[0][14].substring(0,2));
			form_setFwdrCustSeq(ComLpad(rArray1[0][15],6,"0"));
			ComSetObjValue(formObj.f_cust_nm, rArray1[0][5]);
    		ComSetObjValue(formObj.fmc_no,    rArray1[0][13]);  

    		if (parent.frames("t2frame").document.form) {
    			parent.frames("t2frame").document.form.fmc_cd.value = rArray1[0][13];
    		}
			// SHPR 입력없이 FWDR입력시 SHPR에 자동 입력
			if(ComIsNull(formObj.s_cust_nm)){
				form_setShprCustCntCd(rArray1[0][14].substring(0,2));
				form_setShprCustSeq(ComLpad(rArray1[0][15],6,"0"));
				ComSetObjValue(formObj.s_cust_nm, rArray1[0][5]);	  			
			}
    		// 20100113 추가
    		if(ComGetObjValue(formObj.f_cust_exist_flg) == "Y"){
    			if(ComGetObjValue(formObj.f_cust_cnt_cd) != ComGetObjValue(formObj.f_cust_cnt_cd_old) || ComGetObjValue(formObj.f_cust_seq) != ComLpad(ComGetObjValue(formObj.f_cust_seq_old),6,"0")){
    				if(ComShowCodeConfirm("BKG00343")){
    					ComSetObjValue(formObj.f_cust_subst_flg, "Y");
    				}else{
    					ComSetObjValue(formObj.f_cust_subst_flg, "N");
    				}
    			}
    		}   
    		//2015.10.21 [CHM-201538481] FWDR US 일 경우는 F/F code 변경/추가시 L.REP 변경 안되도록
    		if(ComGetObjValue(formObj.f_cust_cnt_cd) != "US"){
	    		if(ComIsNull(formObj.ob_srep_cd)){
		        	ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
		        	ComSetObjValue(formObj.ob_srep_cd,    lRep);
	    		}
    		}
		}
		ComSetObjValue(formObj.modify_flag, "Y");
    	ComSetObjValue(formObj.customer_modify_flag, "Y"); 
    	ComSetObjValue(formObj.aloc_chk_flg,"Y");
    }
	// BKG,S/I Contact 입력
	if(rArray2 != null){
		for(i = 0 ; i < rArray2.length ; i++){
			 if(rArray2[i][2] == "AL"){
				 // BKG Contact,S/I Contact 모두 입력
				ComSetObjValue(formObj.bkg_cntc_pson_nm,     rArray2[i][3]);
				ComSetObjValue(formObj.bkg_cntc_pson_phn_no, rArray2[i][4]);
				ComSetObjValue(formObj.bkg_cntc_pson_eml,    rArray2[i][7]);
				ComSetObjValue(formObj.bkg_cntc_pson_mphn_no,rArray2[i][5]);
				ComSetObjValue(formObj.bkg_cntc_pson_fax_no, rArray2[i][6]);			

				ComSetObjValue(formObj.si_cntc_pson_nm,      rArray2[i][3]);
				ComSetObjValue(formObj.si_cntc_pson_phn_no,  rArray2[i][4]);
				ComSetObjValue(formObj.si_cntc_pson_eml,     rArray2[i][7]);
				ComSetObjValue(formObj.si_cntc_pson_mphn_no, rArray2[i][5]);
				ComSetObjValue(formObj.si_cntc_pson_fax_no,  rArray2[i][6]);		
			}else if(rArray2[i][2] == "SI"){
				// S/I Contact 입력
				ComSetObjValue(formObj.si_cntc_pson_nm,      rArray2[i][3]);
				ComSetObjValue(formObj.si_cntc_pson_phn_no,  rArray2[i][4]);
				ComSetObjValue(formObj.si_cntc_pson_eml,     rArray2[i][7]);
				ComSetObjValue(formObj.si_cntc_pson_mphn_no, rArray2[i][5]);
				ComSetObjValue(formObj.si_cntc_pson_fax_no,  rArray2[i][6]);
			}else{
				// BKG Contact 입력
				ComSetObjValue(formObj.bkg_cntc_pson_nm,     rArray2[i][3]);
				ComSetObjValue(formObj.bkg_cntc_pson_phn_no, rArray2[i][4]);
				ComSetObjValue(formObj.bkg_cntc_pson_eml,    rArray2[i][7]);
				ComSetObjValue(formObj.bkg_cntc_pson_mphn_no,rArray2[i][5]);
				ComSetObjValue(formObj.bkg_cntc_pson_fax_no, rArray2[i][6]);							
			}
			document.all.bkg_cntc_pson_nm_span.innerHTML      = ComGetObjValue(formObj.bkg_cntc_pson_nm);
			document.all.bkg_cntc_pson_phn_no_span.innerHTML  = ComGetObjValue(formObj.bkg_cntc_pson_phn_no);
			document.all.bkg_cntc_pson_mphn_no_span.innerHTML = ComGetObjValue(formObj.bkg_cntc_pson_mphn_no);
			document.all.bkg_cntc_pson_fax_no_span.innerHTML  = ComGetObjValue(formObj.bkg_cntc_pson_fax_no);
			document.all.bkg_cntc_pson_eml_span.value     = ComGetObjValue(formObj.bkg_cntc_pson_eml);
			document.all.si_cntc_pson_nm_span.innerHTML       = ComGetObjValue(formObj.si_cntc_pson_nm);
			document.all.si_cntc_pson_phn_no_span.innerHTML   = ComGetObjValue(formObj.si_cntc_pson_phn_no);
			document.all.si_cntc_pson_mphn_no_span.innerHTML  = ComGetObjValue(formObj.si_cntc_pson_mphn_no);
			document.all.si_cntc_pson_fax_no_span.innerHTML   = ComGetObjValue(formObj.si_cntc_pson_fax_no);
			document.all.si_cntc_pson_eml_span.value      = ComGetObjValue(formObj.si_cntc_pson_eml);
			ComSetObjValue(formObj.contact_modify_flag, "Y");
			
		}		
	}
}  
/**
* CMDT 화면 호출후 Return받는 함수. <br>
* <br><b>Example :</b>
* <pre>
*     callBack00653(arrBal);
* </pre>
* @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
* @return 없음
* @author 김병규
* @version 2009.05.14
*/    
function callBack0653(arrVal){
	 var formObj = document.form;
 	 if(arrVal != null){				
 		 ComSetObjValue(formObj.cmdt_cd,     arrVal[0][3]);
 		 ComSetObjValue(formObj.rep_cmdt_cd, arrVal[0][5]);
 		 ComSetObjValue(formObj.cmdt_desc,   arrVal[0][4]);		
		
 		 if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
 			 checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
 			 var precaution = arrVal[0][7];
			
 			 setPrecaution(formObj, precaution);

 			 checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);

 			 ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
 			 ComSetObjValue(formObj.modify_flag,     "Y");   	
 			 ComSetObjValue(formObj.aloc_chk_flg,"Y");
 			 ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);
 		 }
//2012.03.14 나상보 		 
// 		 ComSetObjValue(formObj.route_modify_flag, "Y");
 		 cmdtChange(formObj.cmdt_cd.value); 		
	}
}   
/**
* RFA Search후 Return받는 함수. <br>
* <br>
* <b>Example :</b>
* 
* <pre>
* callBack0654(arrBal);
* </pre>
* 
* @param {string}
*            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
* @return 없음
* @author 김병규
* @version 2009.05.14
*/
function callBack0654(arrVal) {
	if (arrVal != null) {
		var formObj = document.form;
  		if(arrVal != null){	  	
  			ComSetObjValue(formObj.rfa_no,     arrVal[0][5]);
  			ComSetObjValue(formObj.rfa_no_old, arrVal[0][5]);
  			
  			ComSetObjValue(formObj.modify_flag,      "Y");   	
  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
			changeObjectColor("Y", "N", "rfa_no", "red", "input");
  		}
	}
}
/**
* S/C Search후 Return받는 함수. <br>
* <br>
* <b>Example :</b>
* 
* <pre>
* callBack0655(arrBal);
* </pre>
* 
* @param {string}
*            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
* @return 없음
* @author 김병규
* @version 2009.05.14
*/
function callBack0655(arrVal) {
	if (arrVal != null) {
		var formObj = document.form;
		
		//sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.14 kbj
		if(ComGetObjValue(formObj.sc_no) != arrVal[0][5]){
	 		ComSetObjValue(formObj.ctrt_ofc_cd,"");
	 		ComSetObjValue(formObj.ctrt_srep_cd,"");
		}
		//formObj.sc_no1.value = arrVal[0][5].substring(0, 3);
		//formObj.sc_no2.value = arrVal[0][5].substring(3);
		formObj.sc_no.value = arrVal[0][5];
		
		formObj.modify_flag.value      = "Y";
		formObj.ctrt_modify_flag.value = "Y";
			changeObjectColor("Y", "N", "sc_no", "red", "input");
	}
}

/**
 * RFA Commodity Popup후 Return받는 함수. <br>
 * <br><b>Example :</b>
 * <pre>
 *     callBack0656(arrBal);
 * </pre>
 * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */    
function callBack0656(arrVal){
	var formObj = document.form;

	if(arrVal != null){		
		if(arrVal[0][1]=="000004"){
			ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
 			ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);

			if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
				checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
				validatePrecaution(formObj);
  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);

				ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
				ComSetObjValue(formObj.modify_flag,     "Y");   	
				ComSetObjValue(formObj.aloc_chk_flg,"Y");
				ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);
			}
		} else if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"){
			comBkgCallPop0653('callBack0653',"","");
		} else if(arrVal[0][3] == "REP"){
			comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
		} else {	
			ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
 			ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);
			
			if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
				checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
				validatePrecaution(formObj);
				
  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
  	    		
				ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.	
				ComSetObjValue(formObj.modify_flag,     "Y");   	
				ComSetObjValue(formObj.aloc_chk_flg,"Y");
				ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);
			}
		}
// 2012.03.14 나상보		
//		ComSetObjValue(formObj.route_modify_flag, "Y");	   				
		ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);
		cmdtChange(formObj.cmdt_cd.value);
	}
}  
 
/**
 * S/C Commodity Popup후 Return받는 함수. <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * callBack0657(arrBal);
 * </pre>
 * 
 * @param {string}
 *            팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */
function callBack0657(arrVal) {
	var formObj = document.form;
	if(arrVal != null){		
    	var scpCd = arrVal[0][6];
		if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
			ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
  			ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][6]);
			if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
				checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
				validatePrecaution(formObj);
  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
				
				ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
				ComSetObjValue(formObj.modify_flag,     "Y");   	
				ComSetObjValue(formObj.aloc_chk_flg,"Y");
//				ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
			}		
		} else if(arrVal[0][5] == "0000"&&arrVal[0][4]!="000004"){
			comBkgCallPop0653('callBack0653',"","");
		} else if(arrVal[0][4]=="000000"){
			comBkgCallPop0653('callBack0653',"","");
		} else {					
			ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
  			ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][6]);
			if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
				checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
				validatePrecaution(formObj);
  	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
				
				ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
				ComSetObjValue(formObj.modify_flag,     "Y");   	
				ComSetObjValue(formObj.aloc_chk_flg,"Y");
//				ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
			}		
		}
	// 2012.03.14 나상보	
	//	ComSetObjValue(formObj.route_modify_flag, "Y");
		cmdtChange(formObj.cmdt_cd.value);
	}
}

 /**
  * Cargo Detail Information 팝업 호출. <br>
  * <br><b>Example :</b>
  * <pre>
  *     comBkgCallPop0890(callback_func);
  * </pre>
  * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
  * @return 없음
  * @author 김병규
  * @version 2009.05.14
  */

 function comBkgCallPop0890(callback_func, autoFlag){
	 // CntrTpSz 변경정보를 QtyDtl에 적용한다.
 	 // CntrTpSz가 변경되면 QtyDtl에 반영한다.
	 var formObj = document.form;
	 if(ComGetObjValue(formObj.carge_detail_pop)!="Y" || checkAutoCaluate(formObj)){ // 변경사항이 있었을 경우 재계산
		 resetQtyDetail();
	 }
	 // RD,SOC,EQ SUB Flag Setting
	 setRdSocEqSubFlg(formObj);    	 
	 var url = "&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ComGetObjValue(formObj.ca_flg);
	 url = url+"&dcgo_flg="+BkgNullToString(ComGetObjValue(formObj.dcgo_flg),"N");
	 url = url+"&rc_flg="+BkgNullToString(ComGetObjValue(formObj.rc_flg),"N");
	 url = url+"&awk_cgo_flg="+BkgNullToString(ComGetObjValue(formObj.awk_cgo_flg),"N");
	 url = url+"&bb_cgo_flg="+BkgNullToString(ComGetObjValue(formObj.bb_cgo_flg),"N");
	 url = url+"&hngr_flg="+BkgNullToString(ComGetObjValue(formObj.hngr_flg),"N");
	 url = url+"&eq_subst_flg="+BkgNullToString(ComGetObjValue(formObj.eq_subst_flg),"N");
	 url = url+"&soc_flg="+BkgNullToString(ComGetObjValue(formObj.soc_flg),"N");
	 url = url+"&rcv_term_cd="+BkgNullToString(ComGetObjValue(formObj.rcv_term_cd),"");    
	 url = url+"&de_term_cd="+BkgNullToString(ComGetObjValue(formObj.de_term_cd),"");
	 url = url+"&bdr_flg="+BkgNullToString(ComGetObjValue(formObj.bdr_flg),"");
	 if(ComGetObjValue(formObj.rcv_term_cd) == "M" || ComGetObjValue(formObj.de_term_cd) == "M"){
		 url = url+"&mixed_flg=Y";	 
	 }else{
		 url = url+"&mixed_flg=N";
	 }
	 rtnValue = ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=B&auto_flg="+autoFlag+"&callSheetIdx1=3&callSheetIdx2=0"+url, 800, 445, callback_func,"1,0,1,1,1", true);
	 callBack0890(rtnValue);
 }       

  /**
  * Carge Detail Information 후 Return 받는 함수. <br>
  * <br><b>Example :</b>
  * <pre>
  *     callBack0890(autoFlg);
  * </pre>
  * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
  * @return 없음
  * @author 김병규
  * @version 2009.05.14
  */    
	function callBack0890(autoFlg){
		var formObj = document.form;
		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     
	  		ComSetObjValue(formObj.modify_flag,      "Y");
	  		ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");
	  		ComSetObjValue(formObj.carge_detail_pop, "Y"); // cargo_detail_pop에서 ok 되었음  	
	  		ComSetObjValue(formObj.qty_modify_flag,  "Y");  	
	
	  		//pop0890.close();
	  		if(autoFlg == "Y"){
	      		if(validateForm(formObj, COMMAND01)){
	     			doActionIBSheet(sheetObjects[2], formObj, COMMAND01);
	      		}			
	  		}
		}
	}   
  /**
   * VVD Change for partial container booking 팝업 호출. <br>
   * <br><b>Example :</b>
   * <pre>
   *     comBkgCallPop1024(bkgNo);
   * </pre>
   * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
   * @return 없음
   * @author 김병규
   * @version 2009.05.14
   */

  function comBkgCallPop1024(callback_func, bkgNo){
  	ComOpenPopup("ESM_BKG_1024.do?pgmNo=ESM_BKG_1024&bkg_no="+bkgNo, 800, 540, callback_func,"0,1,1,1,1", true);
  }
  
 /**
  * VVD Change for partial container booking 팝업 호출 <br>
  * <br><b>Example :</b>
  * <pre>
  *     callBack1024(rArray);
  * </pre>
  * @param Popup에서 전달받은 값
  * @return 없음
  * @author 김병규
  * @version 2009.05.14
  */
 function callBack1024(){    	
	var formObj = document.form;
	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){           	
		ComSetObjValue(formObj.modify_flag, "Y");
		ComSetObjValue(formObj.partial_vvd_opened_flg, "Y");
	}
 }
  /**
   * TAA Search후 Return받는 함수. <br>
   * <br><b>Example :</b>
   * <pre>
   *     callBack1062(arrBal);
   * </pre>
   * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
   * @return 없음
   * @author 김병규
   * @version 2009.05.14
   */    
	function callBack1062(arrVal){
	  	var formObj = document.form;   
	  	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.taa_no,     arrVal[0][5]);
	  			ComSetObjValue(formObj.taa_no_old, arrVal[0][5]);
	  			
	  			ComSetObjValue(formObj.modify_flag,      "Y");   	
	  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
	  			ComSetObjValue(formObj.aloc_chk_flg,"Y");
	  			changeObjectColor("Y", "N", "taa_no", "red", "input");
	  		}
	  	}
	}    

  /**
   * TAA Commodity Popup후 Return받는 함수. <br>
   * <br><b>Example :</b>
   * <pre>
   *     callBack1078(arrBal);
   * </pre>
   * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
   * @return 없음
   * @author 김병규
   * @version 2009.05.14
   */    
 function callBack1078(arrVal){
  	 var formObj = document.form;
  	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){  
		if(arrVal != null){		
			if(arrVal[0][1]=="000004"){
				ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);
				
				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
					checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
					validatePrecaution(formObj);
    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
					
					ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
					ComSetObjValue(formObj.modify_flag,     "Y");   	
					ComSetObjValue(formObj.aloc_chk_flg,"Y");
					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
				}
			} else if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"){
				comBkgCallPop0653('callBack0653',"","");
			} else if(arrVal[0][3] == "REP"){
				comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
			} else {			
				ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);
	
				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
					checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
					validatePrecaution(formObj);
    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
					
					ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
					ComSetObjValue(formObj.modify_flag, "Y");   	
					ComSetObjValue(formObj.aloc_chk_flg,"Y");
					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
				}
			}	
		}
	//2012.03.14 나상보	
	//	ComSetObjValue(formObj.route_modify_flag, "Y");
		cmdtChange(formObj.cmdt_cd.value);
  	 }
 }       
//ESD_PRD_018 호출후 Return 받는값.(PCTL_NO)
 function callBackEsdPrd0080(pctlNo){
 	var formObj = document.form;
 	if(ComIsNull(pctlNo)){
 		pctlNo = "";
		manageHaveRouteFlag("N");		
		ComSetObjValue(formObj.route_modify_flag, "Y");
 	} else {
 		ComSetObjValue(formObj.pctl_no, pctlNo);
		manageHaveRouteFlag("Y"); 		
 	}
} 

 /**
 *SC Inquiry  호출. <br>
 * <br><b>Example :</b>
 * <pre>
 *     comBkgCallPopEsmPri0087();
 * </pre>
 * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */

function comBkgCallPopEsmPri0087(){   	
	   var formObj = document.form;
	   var ctrtType = "sc";
	   var ctrtNo = ComGetObjValue(formObj.sc_no);
     
	    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value+"&ctrtType=" + ctrtType);
	    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
	    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){
	        ComOpenWindowCenter("ESM_PRI_0087.do?sc_no="+ctrtNo+"&amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
	    }
}        	
	
 /**
 *RFA Inquiry  호출. <br>
 * <br><b>Example :</b>
 * <pre>
 *     comBkgCallPopEsmPri2020();
 * </pre>
 * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
 * @return 없음
 * @author 김병규
 * @version 2009.05.14
 */

function comBkgCallPopEsmPri2020(){   	
	   var formObj = document.form;
	   var ctrtType = "rfa";
	   var ctrtNo = ComGetObjValue(formObj.rfa_no);
     
	    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&rfa_no="+formObj.rfa_no.value+"&ctrtType=" + ctrtType);
	    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
	    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){
	    	if(ctrtNo.substring(5,6)=="G" || ctrtNo.substring(5,6)=="M" ){//Spot Guide, Master
	    		ComOpenWindowCenter("ESM_PRI_2120.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
	    	}else{// 일반 RFA, Basic
	    		ComOpenWindowCenter("ESM_PRI_2020.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");	
	    	}
	    }
}         
	
 /**
     *TAA  Inquiry  호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPopEsmPri3019();
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */

    function comBkgCallPopEsmPri3019(){   	
 	   var formObj = document.form;
 	  var ctrtType = "taa";
	   var ctrtNo = ComGetObjValue(formObj.taa_no);
    
	    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?taa_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&taa_no="+formObj.taa_no.value+"&ctrtType=" + ctrtType);
	    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
	    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){
	
	        ComOpenWindowCenter("ESM_PRI_3019.do?taa_no="+ctrtNo+"&amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
	    }
    }    

	function chkReeferDry() {
		var isReturn = true;
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		if (sheetObj) {
			with (sheetObj) {
				for (var i=HeaderRows; i<=RowCount; i++) {
					if (0==CellValue(i,"cntr_tpsz_cd").indexOf("R") && formObj.rc_flg.checked) {
						if (Number(CellValue(i,"op_cntr_qty")) > Number(CellValue(i,"eq_subst_cgo_qty"))) {
							isReturn = true;
							break;
						} else if (Number(CellValue(i,"op_cntr_qty")) == Number(CellValue(i,"eq_subst_cgo_qty"))) {
							if("RD"==CellValue(i,"rd_cgo_flg")) {
								isReturn = false;  //error
								continue;
							} else {
								isReturn = true;
								break;
							}
						}
					}
				}
			}
		}
		return isReturn;
	}

	function changeCntcLayer(no) {
		document.getElementById("cntcLayer1").style.display = 0==no ? "inline":"none";
		document.getElementById("cntcLayer2").style.display = 1==no ? "inline":"none";
	}

	function validateTurkey(srcObj) {
	 	var formObj = document.form;
	 	var objs = [formObj.bkg_pod_cd,
		            formObj.bkg_pod_yd_cd,
		            formObj.bkg_del_cd,
		            formObj.bkg_del_yd_cd,
		            formObj.pod_nm,
		            formObj.del_nm];
		var vals = [ComGetObjValue(objs[0]),
		            ComGetObjValue(objs[1]),
		            ComGetObjValue(objs[2]),
		            ComGetObjValue(objs[3])];
		if (!srcObj || objs[0]==srcObj || objs[1]==srcObj) {
			if ("TRIST"==vals[0]) {
				if ("01"==vals[1]) {
					ComSetObjValue(objs[4],"HAYDARPASA,ISTANBUL,TURKEY");
				} else if ("03"==vals[1]) {
					ComSetObjValue(objs[4],"AMBARLI,ISTANBUL,TURKEY");
				}
			}
		}
		if (!srcObj || objs[2]==srcObj || objs[3]==srcObj) {
			if ("TRIST"==vals[2]) {
				if ("01"==vals[3]) {
					ComSetObjValue(objs[5],"HAYDARPASA,ISTANBUL,TURKEY");
				} else if ("03"==vals[3]) {
					ComSetObjValue(objs[5],"AMBARLI,ISTANBUL,TURKEY");
				}
			}
		}
		objs = vals = null;
	}

	// POD/POL 편집시
	function setPolPodClptIndSeq() {
		var sheetObj = sheetObjects[2];
		with (sheetObj) {
			if (1 < Rows) {
				var formObj = document.form;
		    	if (ComGetObjValue(formObj.bkg_pol_cd) != CellSearchValue(1,"pol_cd") ||
		    		ComGetObjValue(formObj.bkg_pol_yd_cd) != CellSearchValue(1,"pol_yd_cd")) {
		    		CellValue2(1, "pol_clpt_ind_seq") = "";
		    		searchLaneEtaEtd(sheetObj, formObj, 1);
		    	}
		    	if (ComGetObjValue(formObj.bkg_pod_cd) != CellSearchValue(LastRow,"pod_cd") ||
		    		ComGetObjValue(formObj.bkg_pod_yd_cd) != CellSearchValue(LastRow,"pod_yd_cd")) {
		    		CellValue2(LastRow, "pod_clpt_ind_seq") = "";
		    		searchLaneEtaEtd(sheetObj, formObj, LastRow);
		    	}
			}
	    }
	}

	// POD/POL 편집시
	function searchLaneEtaEtd(sheetObj, formObj, Row) {
		if(	sheetObj.CellValue(Row, "pol_cd").length > 0 
			&& sheetObj.CellValue(Row, "pod_cd").length > 0 
			&& sheetObj.CellValue(Row, "bkg_vvd_cd").length > 0){
	   		formObj.f_cmd.value = SEARCH01;
	   		var params = FormQueryString(formObj);
	   		params = params + "&edit_row=" + Row + "&" + ComGetSaveString(sheetObj,true,true);
	   		var sXml = sheetObj.GetSearchXml("ESM_BKG_0092GS.do", params);
	   		if(!ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq_list")) && !ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq_list"))){
				// 1st POL과 Last POD만 yard를 제공함
				var lstRow = 0;
	    		for ( j = 1 ; j < sheetObj.Rows ; j++ ){
	    			if(sheetObj.CellValue(j, "pod_cd").length > 0){
	    				lstRow = j;
	    			}
	    		}
				if(Row == 1){
			   		sheetObj.CellValue2(Row, "pol_yd_cd") 	= (ComIsNull(ComGetEtcData(sXml,"pol_yd_cd")))	?"":ComGetEtcData(sXml,"pol_yd_cd");
					sheetObj.CellValue2(Row, "pol_clpt_ind_seq") = (ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq")))?"":ComGetEtcData(sXml,"pol_clpt_ind_seq");
		   		}
		   		if(Row == lstRow){
			   		sheetObj.CellValue2(Row, "pod_yd_cd") 	= (ComIsNull(ComGetEtcData(sXml,"pod_yd_cd")))	?"":ComGetEtcData(sXml,"pod_yd_cd");
					sheetObj.CellValue2(Row, "pod_clpt_ind_seq") = (ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq")))?"":ComGetEtcData(sXml,"pod_clpt_ind_seq");
		   		}
	   		}
		}
	}
	
	/**
	* 계약넘버 연결시 팝업 창 validation <br>
	* 
	* @param {string} bkg Main & e-Booking화면에서 Pricing 계약 조회시 Popup 수정 요청
	* @return 없음
	* @author 
	* @version 2011.10.28
	*/
	function validatePriPopUp(ctrtType, ctrtNo, amdtSeq){
		var formObj = document.form;
		
		// 1. 계약 넘버 && application date 둘다 없을 시 팝업 연결 안함
		if(ctrtNo == ''){
			return false;
		}
		// 2. 계약 넘버 있을시 
		if(ctrtNo !=''){
			// 2-1.Dummy Check
			if(ctrtNo.indexOf("DUM") != -1){
				ComShowCodeMessage("BKG08205");//"There is no contract no. please check it again."
				return false;
			}

			// 2-2. 계약 넘버 && application date 둘다 있지만 amdt_seq 없는 경우
		        
		        if(amdtSeq == '' || amdtSeq == null || amdtSeq == 'null' || amdtSeq == undefined || amdtSeq == 'undefined'){
					ComShowCodeMessage("BKG08204");//"The duration in contract does not matched with booking. please check application date.";
					return false;
				}
		    return true;
		}
		return false;
	}
	
	
	/**
	*  C.OFC/Rep. 팝업 창 validation <br>
	* @param formObj
	* @return boolean 
	* @author 금병주
	* @version 2011.11.11
	*/
	function validateCRep(formObj){
		var falg = false; 
		var porCd 		= ComGetObjValue(formObj.bkg_por_cd);
		var polCd 		= ComGetObjValue(formObj.bkg_pol_cd);
		flag = ( porCd.substring(0,2) == 'CA' || porCd.substring(0,2) == 'US' ||
				polCd.substring(0,2) == 'CA' || polCd.substring(0,2) == 'US' );
		return flag;
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
	
	// allocation reason 풍선도움말 관련
	function alocmsgmove(){
		var obj = document.form.aloc_sts_cd;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight-40;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft-750;  
		alocRsn.style.left=sleft;
		alocRsn.style.top=stop;
	}

	function alocmsgset(strmsg){
		var formObj = document.form;
		if(ComGetObjValue(formObj.aloc_sts_cd) == "S"){
			if(ComGetObjValue(formObj.bkg_aloc_tp_cd) != null && ComGetObjValue(formObj.bkg_aloc_tp_cd).length > 0){
				text ='<table width=100 bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
				alocRsn.innerHTML=text;
			}
		}
	}

	function alocmsghide(){
		alocRsn.innerHTML='';
	}
	
	// non_rt_sts_cd 풍선도움말 관련
	function noratemsgmove(){
		var obj = document.form.non_rt_sts_cd;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight-40;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft-750;  
		nonRateStsMsg.style.left=sleft;
		nonRateStsMsg.style.top=stop;
	}

	function noratemsgset(strmsg){
		var formObj = document.form;
		text ='<table width=100 bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		nonRateStsMsg.innerHTML=text;
	}

	function noratemsghide(){
		nonRateStsMsg.innerHTML='';
	}	

    //미주 outbound 화물 Vehicle Flag 
  	function checkUsVehicleCmdt(polCd){
  		var formObj = document.form;
  		if(polCd.substring(0, 2)=="US"){
  			var vehXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND07, FormQueryString(formObj));
  			var vehicle_flag = ComGetEtcData(vehXml, "vehicle_flag");
  			if(vehicle_flag == "Y"){
  				ComSetObjValue(formObj.veh_cmdt_flg,"Y");  				
  			} else {
  				ComSetObjValue(formObj.veh_cmdt_flg,"N");
  			}
  		} else {
  				ComSetObjValue(formObj.veh_cmdt_flg,"N");  			
  		}
  	}