﻿﻿/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_01.js
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation 
 * --------------------------------------------------------
 * History
 * 2010.09.06 이일민 [CHM-201005387] [ESM-BKG] Reefer / Dry Validation 체크 로직 추가
 * 2010.10.04 전성진 [CHM-201006302] [ESM-BKG] Nigeria commodity입력시 웹사이트 Pop-up기능
 * 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
 * 2010.10.13 경종윤 [CHM-201006332] [긴급] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가) - 오류 수정
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
 * 2010.11.23 이일민 [xxx] pol,por,pod,del를 팝업으로 변경시 저장기능 문제 수정
 * 2010.11.24 이일민 [xxx] pol,por,pod,del를 팝업으로 변경시 저장기능 문제 수정 - form_onChange 파라미터 수정
 * 2011.01.21 이일민 [] R/D Term 일시적 Blank화로 인한 Autorating 불가 발생
 * 2011.01.31 이일민 [SRM-201112705] setPolPodClptIndSeq 함수 추가
 * 2011.03.21 이일민 [] ca상태에서시트편집가능버그수정
 * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
 * 2011.06.09 손은주 [CHM-201111296-01] BKG 화면의 SHPR CODE 변경시 popup 요청
 * 2011.06.20 김진승 [CHM-201111528] R9 CNTR의 BKG UPDATE 요청 - R4, R5부분 변경
 * 2011.07.20 김봉균 [CHM-201112282-01] 중국향 Solid Waste 수출화물 관련해서 bkg commodity validation 처리
 * 2011.07.21 김봉균 [CHM-201112385-01] 중국 상해 I/B DG화물 관련 MSDS 경고팝업 추가
 * 2011.10.10 전성진 [CHM-201111889] T.VVD 변경시, Post VVD 변경 및 관련 Alert Message 처리 요청.
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2011.11.09 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완
 * 2011.11.14 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완 추가 요청. sc_no 변경시 c.ofc/rep 값 초기화
 * 2011.11.24 금병주 [CHM-201114707-01] CFS Term Warning Pop-up message 보완 (문구 수정 및 조건 수정)
 * 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
 * 2012.02.27 정선용 [CHM-201216098-01] BKG Inquiry 메뉴의 SAVE 버튼 기능 오류
 * 2012.03.19 나상보 [CHM-201216514] BKG Commodity Code 변경시, P/C 호출로직 추가 요청
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2012.07.12 조정민 [CHM-201218715] [DG Cargo] Port "또는" Vssl operator - Prohibition/ restriction 존재시 재요청 처리
 * 2012.08.21 조정민 [CHM-201219603] BKG에서 Mixed Term으로 변경시 Pop-up msg 요청건
 * 2012.09.24 조정민 [CHM-201220114] [ALPS] BKG Creation - EQ Sub QTY 로직 수정
 * 2012.09.26 조정민 [CHM-201220436] 특정RFA Term Validation예외 (RFA:BUD12A0115)
 * 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가
 * 2012.10.23 조정민 [CHM-201220667] [BKG] Hanger와 EQ SUB 동시 진행 시 문제점 해결 요청
 * 2012.10.29 조정민 [CHM-201220826] [BKG] BKG CRAETION 화면에 기존 부킹 조회및 편집 후 신규 부킹 생성 가능토록 Copy버튼 추가 (버튼명 사후결정)
 * 2012.11.06 조정민 [CHM-201220857] Charge의 RFA information 화면에 Scope 정보 추가 요청 (S/C information과 동일)
 * 2012.11.26 조정민 [CHM-201220939] 2008년, 2009년 Purged BKG을 원복 [Uncollected DMT관련]
 * 2012.02.08 류대영 [CHM-201322260] T/S 화물에 대한 CLL 마감 이후 CLOSING 기능 의뢰 (2)
 * 2012.02.08 류대영 [CHM-201322635] RAW/WET HIDE COMMODITY에 대하여 AUTO HIDE FLAGGING 구현
 * 2013.04.04 류대영 [CHM-201323757] T/S 화물에 대한  CLL 마감 이후 CLOSING 기능 로직 변경
 * 2013.04.19 최문환 [CHM-201323915] Blacklisted Customer 사용 시 Alert 강화 요청
 * 2014.03.31 문동선 [CHM-201429499] T2와 Q2가 모두 AK 로 자동 지정되도록 로직 정정 요청
 * 2014.07.02 문동선 [CHM-201430625] Pre-Caution 체크 시 STWG_CD 를 PC 로 연동
 * 2014.07.18 문동선 [CHM-201431092] SOC by Shipping Lines flag 추가 및 CCAM 전송 block
 * 2014.07.25 문동선 [CHM-201430707] FumigationHide liner 버튼 및 팝업창 구현, BST 조회 로직
 * 2014.08.08 문동선 [CHM-201431477] GDSM CODE관련 BKG 저장 제한 및 AUTORATING 로직 보완 요청 - FAK와 동일
 * 2014.08.11 문동선 [CHM-201431490] Outbound B/L issue 화면에서 KR 화주 대상 DEM/DET OTS 보여주기 기능 요청
 * 2014.09.02 문동선 [CHM-201431739] Revenue Empty 자동 입력 품목 Code 추가 요청 (730900)
 * 2014.10.15 문동선 [CHM-201432116] SPOT GUIDE RFA, BKG 적용 관련 요청 
 * 2014.12.02 문동선 [CHM-201432440] BKG main 화면의 S/C No. 빨간색 표기 요청 (customer code 불일치시)
 * 2014.12.02 문동선 [CHM-201432782] DG/RF/AWK Cargo VVD ETD 10일 초과 시 팝업 메세지 요청
 * 2014.12.02 문동선 [CHM-201432739] MSDS 필수 제출 팝업 문구 변경 및 CNTAO 대상 신규 추가
 * 2015.03.31 양동훈 Estimated CMPB 팝업창 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends 
     * @class esm_bkg_0079_01 : esm_bkg_0079_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079_01() {
    	this.processButtonClick	    = tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/        
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var beforetab_sub = 1;
    var beforetab_trob = 1;

    var comboObjects = new Array();
    var comboCnt = 0; 
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var isShowOrgBlNo = true;
	var befQty = "";
	
	var oldPolYdCd = "";
	var oldPodYdCd = "";
	
	var ctrt_ofc_cd_old = "";
	var ctrt_srep_cd_old = "";	
	var ctrt_amdt_seq = '';
	var route_detail_modify_flag = "";
	
	var success_flag = false;
	var agmtActCustModifyFlag = false;
	
	var change_firstvvd_flag = false;
	
	//자동 Cargo Release 처리
	//POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크하는 변수
	var do_hld_flg = null; 
	var cr_chk_flg = null;
	var old_pod_cd = null; 
	var new_pod_cd = null;
	var old_pod_yd_cd = null;
	var new_pod_yd_cd = null;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

         /*******************************************************/
        var formObj = document.form;

		var bkgNo = ComGetObjValue(formObj.bkg_no);
		var blNo  = ComGetObjValue(formObj.bl_no);
		var caFlg = ComGetObjValue(formObj.ca_flg);
		var bdrFlag = "";
		if(formObj.bdr_flg.checked){
			bdrFlag = ComGetObjValue(formObj.bdr_flg);
		}else{
			bdrFlag = "N";
		}
		var bkgTrunkVvd = ComGetObjValue(formObj.bkg_trunk_vvd);
		var porCd 		= ComGetObjValue(formObj.bkg_por_cd);
		var porYdCd 	= ComGetObjValue(formObj.bkg_por_yd_cd);
		var polCd 		= ComGetObjValue(formObj.bkg_pol_cd);
		var polYdCd 	= ComGetObjValue(formObj.bkg_pol_yd_cd);
		var podCd 		= ComGetObjValue(formObj.bkg_pod_cd);
		var podYdCd 	= ComGetObjValue(formObj.bkg_pod_yd_cd);
		var delCd 		= ComGetObjValue(formObj.bkg_del_cd);
		var delYdCd 	= ComGetObjValue(formObj.bkg_del_yd_cd);
		var oldBkgNo 	= ComGetObjValue(formObj.old_bkg_no);
		var sCustCntCd 	= ComGetObjValue(formObj.s_cust_cnt_cd);
		var sCustSeq 	= ComGetObjValue(formObj.s_cust_seq);
		var fCustCntCd 	= ComGetObjValue(formObj.f_cust_cnt_cd);
		var fCustSeq 	= ComGetObjValue(formObj.f_cust_seq);		
		var cCustCntCd 	= ComGetObjValue(formObj.c_cust_cnt_cd);
		var cCustSeq 	= ComGetObjValue(formObj.c_cust_seq);				

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}	
    		
            switch(srcName) {
/** tab BKG Creation (S) **/
				case "btn_t1InlandRouteInformation":
					break;
				case "btn_splitPop":			
					doActionIBSheet(sheetObject3,formObj,COMMAND03);					
					break;
				case "btn_OrgBlPop":
					if(isShowOrgBlNo){
						blNoSet();
						isShowOrgBlNo = false;
					}else{
						blNoHide();
						isShowOrgBlNo = true;
					}					
					break;
				case "btn_t1RouteDetail":
					if(polCd != ""){
	    				if(sheetObjects[1].RowCount < 2){
	    					if(sheetObjects[1].RowCount < 1){
	    						sheetObjects[1].DataInsert(-1);
	    					}
	    					sheetObjects[1].CellValue(1, "vsl_pre_pst_cd") = "T";
	    					sheetObjects[1].CellValue(1, "vsl_seq") = "0";
	    					sheetObjects[1].CellValue(1, "pol_cd") 		= ComGetObjValue(formObj.bkg_pol_cd);
	    					sheetObjects[1].CellValue(1, "pol_yd_cd") 	= ComGetObjValue(formObj.bkg_pol_yd_cd);
	    					sheetObjects[1].CellValue(1, "pod_cd") 		= ComGetObjValue(formObj.bkg_pod_cd);
	    					sheetObjects[1].CellValue(1, "pod_yd_cd") 	= ComGetObjValue(formObj.bkg_pod_yd_cd);
	    					sheetObjects[1].CellValue(1, "bkg_vvd_cd") 	= ComGetObjValue(formObj.bkg_trunk_vvd);
//	    					sheetObjects[1].CellValue(1, "poL_clpt_ind_seq") = "1";
//	    					sheetObjects[1].CellValue(1, "pod_clpt_ind_seq") = "1";
	    				}

						comBkgCallPop0092("callBack0092",bkgNo,bkgTrunkVvd,caFlg,"1");
					}else{
						ComShowCodeMessage("BKG00136");
						ComSetFocus(form.pol_cd);
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
	       				ComShowCodeMessage("BKG00104", "L.OFC");		//VVD 9자리 체크	
						return;
					}
					var param = "?pgmNo=ESM_SPC_0044";
					param = param + "&vvd="+bkgTrunkVvd + "&office=" + usr_ofc_cd;
		       		ComOpenWindowCenter("/hanjin/ESM_SPC_0044.do"+param, "ESM_SPC_0028", 1024, 660, true, "yes");
					break;
					
				case "btn_t1RowAdd":
					sheetObjects[0].DataInsert(-1);
	    			sheetObjects[0].SelectCell(sheetObjects[0].Rows, "cntr_tpsz_cd", true);
					ComSetObjValue(formObj.qty_modify_flag, "Y");
					ComSetObjValue(formObj.modify_flag, "Y");	    			
					break;

				case "btn_t1Delete":
					var delTpSz = sheetObject1.CellValue(sheetObject1.SelectRow, "cntr_tpsz_cd");					
					for(var i=sheetObject4.HeaderRows;i<sheetObject4.Rows;i++){
						if(delTpSz==sheetObject4.CellValue(i, "cntr_tpsz_cd")){
							sheetObject4.RowDelete(i,false);
						}
					}
					sheetObject1.RowDelete(sheetObject1.SelectRow,false);	
					
					disabledFH(sheetObject1, formObj);
					ComSetObjValue(formObj.cntr_del, "Y");
					ComSetObjValue(formObj.qty_modify_flag, "Y");
					ComSetObjValue(formObj.modify_flag, "Y");					
					manageHaveRouteFlag("N");
					break;

				case "btn_t1TPSZ":
					comBkgCallPop0080("callBack0080","");
					break;
					
				case "btn_EqDetail":
					if(chkCntrTpSz()){
						comBkgCallPop0890("callBack0890","N");						
					}
					break;    					
					
				case "btn_t1Danger":
					if(ComGetObjValue(formObj.dcgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length > 10){
						comBkgCallPop0200(bkgNo, caFlg);
//						ComOpenWindowCenter("ESM_BKG_0200.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1010, 570, true);
//						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    	
					break;

				case "btn_t1Reefer":
					if(ComGetObjValue(formObj.rc_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length >= 11){
						if(bkgNo != "" && bkgNo.length > 10){
							ComOpenWindowCenter("ESM_BKG_0498.do?pgmNo=ESM_BKG_0498&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1020, 570, true);
							doActionIBSheet(sheetObjects[2],formObj,SEARCH);
						}else{
							ComShowCodeMessage("BKG00255");
							ComSetFocus(formObj.bkg_no);
						}    							
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    					
					break;
				case "btn_t1Awkward":
					if(ComGetObjValue(formObj.awk_cgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length > 10){
						ComOpenWindowCenter("ESM_BKG_0055.do?pgmNo=ESM_BKG_0055&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1020, 580, true);
						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    		
					break;

				case "btn_t1BreakBulk":
					if(ComGetObjValue(formObj.bb_cgo_flg_old)!="Y"){
						ComShowCodeMessage("BKG02048");						
						break;
					}
					if(bkgNo != "" && bkgNo.length >= 11){						
						// bkgNo, caFlg
						ComOpenWindowCenter("ESM_BKG_0106.do?pgmNo=ESM_BKG_0106&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0106", 1020, 635, true);
						doActionIBSheet(sheetObjects[2],formObj,SEARCH);
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}    	    					
					break;

				case "btn_t1Stowage":
					comBkgCallPop0090("callBack0090", ComGetObjValue(formObj.stwg_cd), 
							ComGetObjValue(formObj.stwg_rmk), bkgNo, caFlg, podCd);
					break;
					
				case "btn_t1Hanger":
					if(bkgNo != "" && bkgNo.length > 10){
						comBkgCallPop0081("callBack0081","0");
					}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);
					}      					
					break;

				case "btn_t1StopOffCargo":
					comBkgCallPop0658("callBack0658");
					break;
					
				case "btn_t1Fumigation":
					comBkgCallPop1181("callBack1181");
					break;	

				case "btn_t1Constraints":
					comBkgCallPop0998("",bkgNo);
					break;

				case "btn_t1SVCModeRoute":
					comBkgCallPop0972("",bkgNo);
					break;

				case "btn_t1ReferenceNo":    		
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01010");
					}else{    					
    					if(bkgNo != "" && bkgNo.length >= 11){
    						comBkgCallPop0097("callBack0097",bkgNo, caFlg);
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}    	      
					}
					break;

				case "btn_t1CargoClosingTime":
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01009");
					}else{
    					if(bkgNo != "" && bkgNo.length >= 11){
    						comBkgCallPop0721("",bkgNo);
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}    
					}
					break;

				case "btn_t1RollOverInformation":
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG01011");
					}else{    					
    					if(bkgNo != "" && bkgNo.length >= 11){
    						ComOpenPopup("ESM_BKG_0724.do?pgmNo=ESM_BKG_0724&bkg_no="+bkgNo, 1000, 450, "","0,1,1,1,1", true);
    					}else{
    						ComShowCodeMessage("BKG00255");
    						ComSetFocus(formObj.bkg_no);
    					}
					}
					break;

            	case "btn_t1Retrieve":
            		if(bkgNo != null && bkgNo.length > 0){
            			ComSetObjValue(formObj.bkg_no,bkgNo);
            			doActionIBSheet(sheetObjects[2], formObj, SEARCH);            			
            		}else if(blNo != null && blNo.length > 0){
            			ComSetObjValue(formObj.bl_no,blNo);
            			doActionIBSheet(sheetObjects[2], formObj, SEARCH);               			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);            			
            		}
                	break;

            	case "btn_t1New":
            		if(ComGetObjValue(formObj.modify_flag) == "Y"){
            			if(ComShowCodeConfirm("BKG00350")){
            				// 저장을 선택하면 저장만 실행
                            window.event.srcElement.setAttribute("name","btn_t1Save");
                            processButtonClick();  
            			}
    	    		}

            		if(ComGetObjValue(formObj.isInquiry) == "Y"){
            			location.href = "ESM_BKG_0079_01_Q.do";
            		}else if(formObj.ca_new_creation_flag.value=="Y"){
            			location.href = "ESM_BKG_0079_01_C.do";
            		} else {
            			location.href = "ESM_BKG_0079_01.do";
            		}

            		if(parent.t1frame != undefined && typeof(parent.t1frame) == "object") {
            			parent.podChangeTabColor("N");
            		}
                	break;
                	
            	case "btn_t1Save":            		
            		saveFunction(formObj, sheetObjects[2], formObj.bkg_no.value);
                	break;

            	case "btn_t1GoIBCS":
            		if(bkgNo != null && bkgNo.length > 0){
            			var sUrl = "";
            			if(podCd.substring(0,2)=="US"){
            				sUrl = "ESM_BKG_0668_01.do?pgmNo=ESM_BKG_0668-01&bkg_no="+bkgNo;
            			} else {
            				sUrl = "ESM_BKG_0292.do?pgmNo=ESM_BKG_0292&bkg_no="+bkgNo;
            			}
            			ComOpenPopup(sUrl, 1024, 760, "","1,0,1,1,1", true);            			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObj.bkg_no);                     			
            		}
                	break;                	
                	
              case "btn_t1BKGCancel":
					if(validateForm(formObj, MODIFY06)){
						doActionIBSheet(sheetObject3, formObj, MODIFY06);
					}        	  
                	break;

        	case "btn_t1EasyCopy":
  				if(formObj.bkg_no.value != ""){
  				ComShowCodeMessage("BKG02207");
  					break;
  				}
  				if(ComShowCodeConfirm("BKG02208")){
  					//앞배와 뒷배 간격이 30일 넘으면 신규생성(0092에서)과 Easy Copy 막음
					var befEta = "";
					var befVvd = "";
					for (var i=0; i<=sheetObjects[1].RowCount; i++) {
						if(befEta!="" && sheetObjects[1].CellValue(i,"etd_day")!=""){
							if(ComGetDaysBetween(befEta, sheetObjects[1].CellValue(i,"etd_day")) > 40){
								ComShowCodeMessage('BKG08338',sheetObjects[1].CellValue(i,"bkg_vvd_cd"),befVvd);
					   			return false;
							}
						}
						befEta = sheetObjects[1].CellValue(i,"eta_day");
						befVvd = sheetObjects[1].CellValue(i,"bkg_vvd_cd");
					}
  					
  					// 초기화
  					formObj.xter_bkg_rqst_cd.value = "OFF"; 
  					formObj.xter_si_cd.value = "";
  					formObj.aloc_sts_cd.value = "";
  						
  					// 저장을 선택하면 저장만 실행
  					formObj.data_yn.value = "N";

  					// 2017.11.09 iylee Copy 시에는 Stowage Code를 Copy 하지 않는다.
  					formObj.stwg_cd.value = "";
  					window.event.srcElement.setAttribute("name","btn_t1Save");
  					
  					processButtonClick();

//					with (formObj){
//						if(rfa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(rfa_no.value) ){
//							doActionIBSheet(sheetObject3, formObj, SEARCH05);
//						}else if(sc_no.value.substring(0,3) != "DUM" && !ComIsEmpty(sc_no.value) ){
//							doActionIBSheet(sheetObject3, formObj, SEARCH04);
//						}else if(taa_no.value.substring(0,3) != "DUM" && !ComIsEmpty(taa_no.value) ){
//							doActionIBSheet(sheetObject3, formObj, SEARCH06);
//						}
//        			}
  					window.event.srcElement.setAttribute("name","btn_t1EasyCopy");
  				}
        		break;                	

            	case "btn_t1Copy":
            		//UI_BKG_0077
            		if(validateForm(formObj, COMMAND02)){            			
            			if(formObj.data_yn.value == "Y" && formObj.bkg_no.value == ""){
    						ComShowCodeMessage("BKG06126");
    						ComSetFocus(formObj.bkg_no);
    						break;
            			}

    	            	var sUrl = "ESM_BKG_0077.do?pgmNo=ESM_BKG_0077&bkg_no="+bkgNo;
    	            	sUrl += "&bdr_flg="+bdrFlag;
    	            	sUrl += "&bkg_sts_cd="+ComGetObjValue(formObj.bkg_sts_cd);
            			ComOpenPopup(sUrl, 720, 730, "","1,0,1,1,1", true);
            		}
                	break;

            	case "btn_t1FaxEDI":
            	  	// UI_BKG_0095
					if(bkgNo != "" && bkgNo.length >= 11){
						ComOpenPopup("ESM_BKG_0095.do?pgmNo=ESM_BKG_0095&bkg_no="+bkgNo+"&pol_cd="+polCd+"&opener_pgm=ESM_BKG_0079_01", 950, 680, "","0,1,1,1,1", true);
					}else{					
						ComSetFocus(formObj.bkg_no);
					}
                	break;

            	case "btn_t1Holding":
					if(validateForm(formObj, MODIFY04)){
						doActionIBSheet(sheetObject3, formObj, MODIFY04);
					}            	  
                	break;
            	case "btn_t1Waiting":
					if(validateForm(formObj, MODIFY05)){
						doActionIBSheet(sheetObject3, formObj, MODIFY05);
					}                   	  
					break;

            	case "btn_t1Split":
	            	var params = "?bkg_no="+bkgNo+"&popUpFlag=Y";
	            	params += "&pgmNo=ESM_BKG_0099";	  	            								
	            	ComOpenPopup("/hanjin/ESM_BKG_0099.do" + params, 1024, 700, "", "0,1,1,1,1", true);
                	break;

	        	case "btn_0019Pop":
	        		if(sheetObjects[1].Rows>2){
	        			var trunkRow = sheetObjects[1].FindText("vsl_pre_pst_cd","T");
	        			polCd = sheetObjects[1].CellValue(trunkRow, "pol_cd");
	        			podCd = sheetObjects[1].CellValue(trunkRow, "pod_cd");
	        		}
	        		comBkgCallPop0019('callBack0019', bkgTrunkVvd, polCd, podCd);
					break;    				
	        	case "btn_0083PorPop": //node search
	        		comBkgCallPop0083('callBack0083','POR',porCd,porYdCd,ComGetObjValue(formObj.rcv_term_cd));
	        		break;    		
	        	case "btn_0083PolPop": //node search
	        		comBkgCallPop0083('callBack0083','POL',polCd,polYdCd,ComGetObjValue(formObj.rcv_term_cd));
	        		break;    		
	        	case "btn_0083PodPop": //node search
	        		comBkgCallPop0083('callBack0083','POD',podCd,podYdCd,ComGetObjValue(formObj.de_term_cd));
	        		break;    		
	        	case "btn_0083DelPop": //node search
	        		comBkgCallPop0083('callBack0083','DEL',delCd,delYdCd,ComGetObjValue(formObj.de_term_cd));                    		
					break;    	
	        	case "btn_0744Pop": // ams filer no
					if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG00255");
					} else {
						comBkgCallPop0744('',bkgNo, caFlg, bdrFlag);
					}
					break;    		    					
	        	case "btn_0652ShprPop": //customer inquiry
	        		comBkgCallPop0652('callBack0652','S',sCustCntCd,sCustSeq, "",ComGetObjValue(formObj.ob_sls_ofc_cd),ComGetObjValue(formObj.ob_srep_cd));
	        		break;    		
	        	case "btn_0652FwdrPop": //customer inquiry
	        		comBkgCallPop0652('callBack0652','F',fCustCntCd,fCustSeq, "");
	        		break;    		
	        	case "btn_EsmBkg1159Pop": // com customer pop-up
	        		var custCd = cCustCntCd+cCustSeq;
	        		ComOpenPopup("/hanjin/ESM_BKG_1159.do?pgmNo=ESM_BKG_1159&cust_cd="+ cCustCntCd+cCustSeq, 870, 440, "callBackEsmBkg1159", '0,1,1,1,1,1,1', true);
					break;    			  
	        	case "btn_RfaNo":
	        		comBkgCallPop0654('callBack0654',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
					break;    	
	        	case "btn_ScNo":
	        		comBkgCallPop0655('callBack0655',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
					break;    	  
	        	case "btn_TaaNo":
	        		comBkgCallPop1062('callBack1062',bkgNo,bkgTrunkVvd,porCd,delCd,sCustCntCd,sCustSeq,cCustCntCd,cCustSeq);
					break;    					
	        	case "btn_CmdtPop":
	        		var rfaNo = ComGetObjValue(formObj.rfa_no);
	        		var scNo = ComGetObjValue(formObj.sc_no);
	        		var taaNo = ComGetObjValue(formObj.taa_no);
	        		var cmdtCd = ComGetObjValue(formObj.cmdt_cd);
	        		var repCmdtCd = ComGetObjValue(formObj.rep_cmdt_cd);
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
	        		if(formObj.chkTaaRfaNo[1].checked){
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
	        		//3   730900    Fuel Empty container [CHM-201431739]

	        		if( ComGetObjValue(formObj.cmdt_cd) =='960151' || ComGetObjValue(formObj.cmdt_cd) =='960316' || ComGetObjValue(formObj.cmdt_cd) =='730900' ) {
	        			ComSetObjValue(formObj.bkg_cgo_tp_cd, "Y");
	        		} else {
	        			//soc_flg 가 'Y'아니면 초기화, 그외에는 그대로 둠 (즉  위 두 코가 아니더라고 체크 될수 있음)
	        			if(ComGetObjValue(formObj.soc_flg) != "Y" ) {
	        				
	        				ComSetObjValue(formObj.bkg_cgo_tp_cd, "");
	        			}
	        		}
	        		
					break;    		    		
	        	case "btns_MtDorArrCalendar":
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
		        		if(!formObj.mty_dor_arr_dt.disabled){
		    	            var cal = new ComCalendar();
		    	            cal.select(formObj.mty_dor_arr_dt, 'yyyy-MM-dd');    
		        		}       
	        		}
					break;        					
	        	case "btns_LodgDueCalendar":
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
			            var cal = new ComCalendar();
			            cal.select(formObj.lodg_due_dt, 'yyyy-MM-dd');         
	        		}
					break;        		
	        	case "btns_DeDueCalendar":
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
			            var cal = new ComCalendar();
			            cal.select(formObj.de_due_dt, 'yyyy-MM-dd');    
	        		}
					break;    
	        	case "btns_MtPickUpCalendar":
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
			            var cal = new ComCalendar();
			            cal.select(formObj.mty_pkup_dt, 'yyyy-MM-dd'); 
	        		}
					break;        			
	        	case "btn_0082Pop": //mty pkup inquiry
	        		var mtyPkupYdCd;
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
		        		if(ComChkLen(formObj.mty_pkup_yd_cd.value, 7) == "2"){                			
		        			mtyPkupYdCd = formObj.mty_pkup_yd_cd.value;
		        		}else{
		        			mtyPkupYdCd = porCd+porYdCd;
		        		}
		        		comBkgCallPop0082('callBack0082','0',mtyPkupYdCd);
	        		}
	        		break;    	    		
	        	case "btn_0088Pop": //full rtn inquiry
	        		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){        		
		        		var r0088;
		        		if(ComChkLen(formObj.full_rtn_yd_cd.value, 7) == "2"){                			
		        			r0088 = ComGetObjValue(formObj.full_rtn_yd_cd);
		        		}else{
		        			r0088 = porCd+porYdCd;
		        		}                		
		        		comBkgCallPop0088('callBack0088',r0088);
	        		}
	        		break;    	       
	        	case "btn_0976Pop": // remark template
	        		comBkgCallPop0976('callBack0976');
					break;
	    		case "btn_CRep":
	    			//por(pol)이 CA나 US인 경우만 하단의 로직을 실행 2011.11.10 kbj
	    			if(validateCRep(formObj)){
	    					ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132?f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+
	    							formObj.sc_no.value+"&ctrt_rep_cd="+formObj.ctrt_ofc_cd.value+formObj.ctrt_srep_cd.value+"&func=callBack1132", 500, 290, "callBack1132",	"1,0,1,1,1", true);
	    			}
	        		break;
	    		case "btn_AlocReason":
	    			if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG00255");
					} else {
		    			ComOpenPopup("ESM_BKG_1507.do?bkg_no=" + formObj.bkg_no.value + "&popup_msg_flg=Y", 760, 550, "","1,0,1,1,1", true);
		    			doActionIBSheet(sheetObject3, formObj, SEARCH);
					}
	    			break;    		
	    			
	    		case "btn_t1Dmdt": // ESM_BKG_0682.js 참조
	    			if(formObj.bkg_no.value != ""){
		    	        var paramVal = "?call_flag=P&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value + "&dmdt_trf_cd=DMOF&bkg_flg=Y&pgmNo=EES_DMT_3002P";
		    	        paramVal += "&pgmNo=EES_DMT_3002P";
		    	        ComOpenWindowCenter('/hanjin/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 670, true);
	    			}
	    			break;
	    			
	    		case "btn_t1Sa0190":   
					if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
						break;
					}
					if(ComGetObjValue(formObj.isInquiry) == "Y"){
						break;
					}
					var scNo = formObj.sc_no.value;
					var rfaNo =formObj.rfa_no.value;
					var svcScpCd = formObj.svc_scp_cd.value;
					ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObj.bkg_no.value+"&sc_no="
							+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ ""//formObj.appl_dt.value
							,800, 390, "callBackSa0190","1,0,1,1,1", true);					
					break;  	
	    		case "btn_CMPB_popup": //2015/03/30 양동훈
	    			if(ComIsNull(oldBkgNo)){
						ComShowCodeMessage("BKG08262","BKG NO");
					}else{
						ComOpenPopup("ESM_BKG_1183.do?bkg_no="+formObj.bkg_no.value,750,330,"","1,0,1,1,1",true);
					}
	    			break;
	    		case "btn_t1SalesApproval": 
	    			showSalesApproval();
	    			break;	
	    		case "btn_0422Pop":
	    			ComOpenWindowCenter2("/hanjin/ESM_BKG_0422.do?bkg_no="+formObj.bkg_no.value+"&ui_id=ESM_BKG_0079", "Queue Detail", 1020,630,false,"scrollbars=no,resizable=yes")
					break;  	
/** tab BKG Creation (E) **/
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
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
     * 콤보 초기설정값
     * @param {IBMultiCombo} comboObj  comboObj
     */
     function initCombo(comboObj) {
     	comboObj.MultiSelect = false;
//     	comboObj.UseCode = true;
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
                      InsertTab( cnt++ , "BKG contact" , -1 );
                      InsertTab( cnt++ , "S/I contact" , -1 );                       
                      BaseColor = "243,242,248";                        
                  }
               break;     
           }
      }
       
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

   	    // IBMultiCombo초기화
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }

        formObj.rcv_term_cd.DropHeight = 250;
        formObj.rcv_term_cd.SetColWidth("20|80");
        formObj.de_term_cd.DropHeight = 250; 
        formObj.de_term_cd.SetColWidth("20|80");
        formObj.rail_blk_cd.SetColWidth("20|150");
        formObj.ida_hlg_tp_cd.SetColWidth("20|150");
        
        for(k=0;k<tabObjects.length;k++){            	
            initTab(tabObjects[k],k+1);                
        }
        
		ComSetObjValue(formObj.act_wgt, makeComma("0"));
        if(formObj.old_bkg_no.value == ""){            	
        	doActionIBSheet(sheetObjects[2],formObj,INIT);
        }else{
        	doActionIBSheet(sheetObjects[2],formObj,SEARCH);
        } 
        initControl();

		if(ComGetObjValue(formObj.rhq_ofc_cd) != "NYCRA" 
			&& ComGetObjValue(formObj.usr_ofc_cd) != "SELCMQ" 
			&& ComGetObjValue(formObj.usr_ofc_cd) != "SELCTY"
			&& ComGetObjValue(formObj.usr_ofc_cd) != "CLTCO"){

			ComSetDisplay("btn_AlocReason", false);
			document.getElementById("bottom_space").style.width = "165";
		}else {
			ComSetDisplay("btn_AlocReason", true);
			document.getElementById("bottom_space").style.width = "20";
		}
		
		document.getElementById("btn_CMPB_popup").style.visibility = "hidden";

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
    	axon_event.addListenerForm  ("change", 			"form_onChange", 		formObj);
        axon_event.addListenerFormat('keypress', 		'bkg007901_keypress',   formObj); //- 키보드 입력할때
        axon_event.addListenerFormat('keyup',			'bkg007901_keyup',    	formObj); //- 키보드 입력후
        axon_event.addListenerForm('beforedeactivate', 	'bkg007901_deactivate', formObj); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 	'bkg007901_activate',   formObj); //- 포커스 들어갈때
        axon_event.addListenerForm('click', 			'bkg007901_click',    	formObj); //- 클릭시
        axon_event.addListenerForm('keyup','obj_keyup', formObj);
        
        applyShortcut();
    }
      /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
    function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetID = sheetObj.id;
		
		switch(sheetID) {
			case "t1sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 82;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false)
					
					var HeadTitle = "|TP/SZ||Vol.|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|EQ Sub(Incl. R/D)|S.O.C";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++ , dtData,				45,		daCenter,	false,		"cntr_tpsz_cd",				false,		"",	dfNone,			0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtHidden,			45,		daCenter,	false,		"cntr_tpsz_cd_old",			false,		"",	dfNone,			0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	false,		"op_cntr_qty",				false,		"",	dfNullFloat,	2,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtData,				30,		daCenter,	false,		"eq_subst_cntr_tpsz_cd",	false,		"",	dfNone,			0,		true,		true, 2);
					InitDataProperty(0, cnt++ , dtData,				70,		daRight,	false,		"eq_subst_cgo_qty",			false,		"",	dfNullFloat,	2,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtData,				35,		daCenter,	false,		"rd_cgo_flg",				false,		"",	dfNone,			0,		false,		false);    					
					InitDataProperty(0, cnt++ , dtData,				40,		daRight,	false,		"soc_qty",					false,		"",	dfNullFloat,	2,		true,		true, 5);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	false,		"crr_hngr_sgl_bar_qty",		false,		"",	dfNullFloat,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	false,		"crr_hngr_dbl_bar_qty",		false,		"",	dfNullFloat,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	false,		"crr_hngr_tpl_bar_qty",		false,		"",	dfNullFloat,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	false,		"crr_hngr_qty",				false,		"",	dfNullFloat,	2,		true,		true);
					InitDataProperty(0, cnt++ , dtHidden,			50,		daRight,	false,		"mer_hngr_qty",				false,		"",	dfNullFloat,	2,		true,		true);
					
					InitDataValid(0,  "cntr_tpsz_cd",			vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
					InitDataValid(0,  "eq_subst_cntr_tpsz_cd",	vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
										
					CountPosition = 0;					
				}
				break;
				case "t1sheet2":
					with (sheetObj) {
						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 1, 1, 3, 100);
						
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(12, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(false, true, false, true, false,false)
						
						var HeadTitle = "|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq|eta_day|etd_day";
						
						HeadRowHeight = 24;
						DataRowHeight = 24;
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);						
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,		false,		"ibflag");
						InitDataProperty(0, cnt++ , dtData,			55,		daCenter,		false,		"vsl_pre_pst_cd",		false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			false,		"vsl_seq",				false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			false,		"pol_cd",				false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			30,		daLeft,			false,		"pol_yd_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			50,		daLeft,			false,		"pod_cd",				false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			30,		daLeft,			false,		"pod_yd_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			false,		"bkg_vvd_cd",			false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		30,    	daCenter,  		false,     	"pol_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		30,    	daCenter,  		false,     	"pod_clpt_ind_seq",		false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		50,    	daCenter,  		false,     	"eta_day",				false,		"",	dfNone,		0,		true,		true);
						InitDataProperty(0, cnt++ , dtData,   		50,    	daCenter,  		false,     	"etd_day",				false,		"",	dfNone,		0,		true,		true);
						
						SetSortDialog(false);			// 소트 다이얼로그를 표시하지 않는다.
						CountPosition = 0;
					}
					break;
				case "t1sheet3":
					with (sheetObj) {
						// 높이 설정
						style.height = 0;
						//전체 너비 설정
						SheetWidth = mainTable.clientWidth;
						
						//Host정보 설정[필수][HostIp, Port, PagePath]
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						
						//전체Merge 종류 [선택, Default msNone]
						MergeSheet = msHeaderOnly;
						
						//전체Edit 허용 여부 [선택, Default false]
						Editable = true;
						
						//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
						InitRowInfo( 1, 1, 3, 100);
						
						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(2, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(false, true, false, true, false,false)
						
						var HeadTitle = "|";
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
						InitHeadRow(0, HeadTitle, true);						
						
						//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	false,		"ibflag");
						InitDataProperty(0, cnt++ , dtRadioCheck,	35,     daCenter,   false,     	"chk");

					}
					break;
	             case "t1sheet4":
	                 with (sheetObj) { //cargo detail
	                     // 높이 설정
	                     style.height = 0;
	                     // 전체 너비 설정
	                     SheetWidth = mainTable.clientWidth;

	                     //Host정보 설정[필수][HostIp, Port, PagePath]
	                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                     //전체Merge 종류 [선택, Default msNone]
	                     MergeSheet = msHeaderOnly;

	                    //전체Edit 허용 여부 [선택, Default false]
	                     Editable = true;

	                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                     InitRowInfo(1, 1, 7, 100);

	 					 var HeadTitle1 = "|TP/SZ|DR|DG|RF|AK|BB|S/HGR|D/HGR|T/HGR|M/HGR|EQ SUB TP/SZ|SOC|R|D|VOL";
	 					 var headCount = ComCountHeadTitle(HeadTitle1);
	 										
	                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                     InitColumnInfo(16, 0, 0, true);

	                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                     InitHeadMode(true, true, false, true, false,false);

	                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                     InitHeadRow(0, HeadTitle1, true);

	                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                     InitDataProperty(0, cnt++ , dtHiddenStatus,	40,			daCenter,		false,			"ibflag");
	 					 InitDataProperty(0, cnt++ , dtData,			50,     	daCenter,    	false,			"cntr_tpsz_cd",          			false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,    	false,			"dry_cgo_flg",         			false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox,		40,     	daCenter,    	false,     		"dcgo_flg",           				false,    	"",      				dfNone, 			0,     	true,		true);                                                                                                                                            																																	 
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,    	false,     		"rc_flg",      						false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,  	 	false,     		"awk_cgo_flg",       				false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,  	 	false,     		"bb_cgo_flg",       				false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,  	 	false,     		"crr_hngr_sgl_bar_use_flg",	false,    	"",      				dfNone, 			0,     	true,		true); 
	 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,    	false,     		"crr_hngr_dbl_bar_use_flg", 	false,    	"",      				dfNone,		  	0,     	true,		true);                                                                                                                                            																												 
	 					 InitDataProperty(0, cnt++ , dtCheckBox,		80,     	daCenter,	 	false,     		"crr_hngr_tpl_bar_use_flg", 	false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox,		80,     	daCenter,	 	false,     		"mer_hngr_flg",   	  			false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtData,			60,     	daCenter,    	false,     		"eq_subst_cntr_tpsz_cd",    	false,    	"",      				dfNone,      	0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtCheckBox,		40,     	daCenter,	 	false,     		"soc_flg",   	  					false,    	"",      				dfNone, 			0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtData,			30,     	daCenter, 	 	false,     		"rcv_term_cd",           			false,    	"",      				dfNone, 		  	0,     	true,		true);
	 					 InitDataProperty(0, cnt++ , dtData,			30,     	daCenter, 	 	false,     		"de_term_cd",          			false,    	"",      				dfNone,      	0,     	true,		true); 
	 					 InitDataProperty(0, cnt++ , dtData,      		55,     	daRight,     	false,     		"op_cntr_qty",          			false,    	"",      				dfNullFloat,		2,     	true,		true);

	 					 CountPosition = 0;		// Total 없음.    	 										
	 				}
	 				break;
	            case "bkgChgOfcSheet":
					with (sheetObj) {
						style.height = 0;
						if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
						MergeSheet = msHeaderOnly;
						Editable = false;
						InitRowInfo(1, 1, 1, 100);
						InitColumnInfo(13, 0, 0, false);
						InitHeadMode(false, true, false, true, false,false);
						var HeadTitle = "bkg_no|ppd_rcv_ofc_cd|ppd_payr_cnt_cd|ppd_payr_cust_seq|clt_ofc_cd|clt_payr_cnt_cd|clt_payr_cust_seq|"
							          + "bf_ppd_rcv_ofc_cd|bf_ppd_payr_cnt_cd|bf_ppd_payr_cust_seq|bf_clt_ofc_cd|bf_clt_payr_cnt_cd|bf_clt_payr_cust_seq";
						InitHeadRow(0, HeadTitle, false, false);
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bkg_no"              );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "ppd_rcv_ofc_cd"      );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "ppd_payr_cnt_cd"     );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "ppd_payr_cust_seq"   );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "clt_ofc_cd"          );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "clt_payr_cnt_cd"     );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "clt_payr_cust_seq"   );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_ppd_rcv_ofc_cd"   );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_ppd_payr_cnt_cd"  );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_ppd_payr_cust_seq");
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_clt_ofc_cd"       );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_clt_payr_cnt_cd"  );
						InitDataProperty(0, cnt++, dtData, 40, daLeft, false, "bf_clt_payr_cust_seq");
					}
	            	break;
    	}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	case INIT:      //Default7
        		var sXml = ComGetObjValue(formObj.sXml);
        		formObj.sXml.value = null;
        		var arrXml = sXml.split("|$$|");    
        		// Combo 셋팅
				if (arrXml.length > 0){//r term
    				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
				}     	        		
				if (arrXml.length > 1){//d term
    				ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");			
				}  				
				if (arrXml.length > 2){//usa filer
					ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");
					comboObjects[2].InsertItem(0,"","");
				}				
				if (arrXml.length > 3){//canada filer
					ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");
					comboObjects[3].InsertItem(0,"","");
				}   			
				if (arrXml.length > 4){//weight
					ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "val");
				}    				
				if (arrXml.length > 5){//rail bulk
					ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
				}       
				if (arrXml.length > 6){//ida hlg tp 
					ComBkgXml2ComboItem(arrXml[6], comboObjects[6], "val", "name");
				}       
				// Default 값 셋팅
				// Rcv/De Term 이 없으면 'Y'로 셋팅
				var rcvTermCd = ComGetEtcData(arrXml[0],"rcv_term_cd");
				if(rcvTermCd != ""){
					comboObjects[0].Code2 = rcvTermCd;
				}else{
					comboObjects[0].Code2 = "Y";
				}
				if(rcvTermCd != "D"){					
					document.form.mty_dor_arr_dt.disabled = true;
				}								
				var deTermCd = ComGetEtcData(arrXml[0],"de_term_cd");
				if(deTermCd != ""){
					comboObjects[1].Code2 = deTermCd;
				}else{
					comboObjects[1].Code2 = "Y";
				}
				formObj.mty_pkup_yd_cd.value = ComGetEtcData(arrXml[0],"mty_pkup_yd_cd");
				if("Y"==ComGetEtcData(arrXml[0],"auto_edi_hld_flg")){
					formObj.edi_hld_flg.checked = true;
				} else {
					formObj.edi_hld_flg.checked = false;					
				}
				
				// Qty 셋팅
				sheetObjects[0].DataInsert(-1);				
				sheetObjects[0].ColBackColor("cntr_tpsz_cd") = sheetObjects[0].RgbColor(204, 255, 253);
				sheetObjects[0].ColBackColor("op_cntr_qty")  = sheetObjects[0].RgbColor(204, 255, 253);				
				if(ComGetEtcData(arrXml[0],"cntr_tpsz_cd") != ""){					
					sheetObjects[0].CellValue(1,"cntr_tpsz_cd") = ComGetEtcData(arrXml[0],"cntr_tpsz_cd");
				}
				
				if(ComGetEtcData(arrXml[0],"wgt_ut_cd") != ""){
					comboObjects[4].Code2 = ComGetEtcData(arrXml[0],"wgt_ut_cd");
				}else{
					comboObjects[4].Code2 = "KGS";
				}				

				// 기본적으로 rfa 선택
				formObj.chkTaaRfaNo[1].checked = true;				
				document.all.item("taaNoDiv").style.display = "none";
				document.all.item("rfaNoDiv").style.display = "block";
				
				//btn007901Control(false, "btn_t1Save");
				btn007901Control(false, "btn_t1GoIBCS");
//				btn007901Control(false, "btn_t1BKGCancel");
				btn007901Control(false, "btn_t1FaxEDI");
				btn007901Control(false, "btn_t1Holding");
				btn007901Control(false, "btn_t1Waiting");

	    	    ComSetObjValue(formObj.modify_flag, 		"N");
	        	ComSetObjValue(formObj.customer_modify_flag,"N");
	        	ComSetObjValue(formObj.contact_modify_flag, "N");
	    	    ComSetObjValue(formObj.qty_modify_flag, 	"N");
	    	    ComSetObjValue(formObj.close_bkg_flag, 		"N");
	    	    ComSetObjValue(formObj.ts_close_bkg_flag, 	"N");
	    	    ComSetObjValue(formObj.check_ts_close_flag, "N");
	    	    ComSetObjValue(formObj.closed_ts_vvd,		"");
	    	    ComSetObjValue(formObj.cbf_bkg_flag, 		"N");
				manageHaveRouteFlag("Y");
				route_detail_modify_flag = "";
				agmtActCustModifyFlag = false;
				
				if(ComGetObjValue(formObj.isInquiry) == "Y"){
					setInquiryDisableButton();
				} else if(ComGetObjValue(formObj.ca_new_creation_flag) == "Y"){
					btn007901Control(false, "btn_t1Retrieve");
					btn007901Control(false, "btn_t1Split");
					document.getElementById("bkg_no").className = "input2";
					document.getElementById("bl_no").className  = "input2";
					document.getElementById("bkg_trunk_vvd").className = "input1";
				}
				ComSetFocus(document.form.bkg_no);

		    	formObj.sXml.value = null;
//        		ComOpenWait(false);				
                break;
        	case SEARCH:        //조회
				if(ComIsNull(formObj.bkg_no.value) && ComIsNull(formObj.bl_no.value)){
					ComShowCodeMessage("BKG00426");
					return false; 					
				}    		
	    		
        		if(ComGetObjValue(formObj.modify_flag) == "Y" && !ComIsNull(formObj.old_bkg_no)){
        			if(ComShowCodeConfirm("BKG00350")){
        				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));

        				saveFunction(formObj, sheetObjects[2], formObj.bkg_no.value);
        			}
        		}	
        		var bkgNo = ComGetObjValue(formObj.bkg_no);
        		var blNo = ComGetObjValue(formObj.bl_no);
        		var caNewCreationFlag = ComGetObjValue(formObj.ca_new_creation_flag);
        		if(bkgNo != null && bkgNo.length > 0){
        			ComResetAll();
        			ComSetObjValue(formObj.bkg_no,bkgNo);
        		}else if(blNo != null && blNo.length > 0){
        			ComResetAll();
        			ComSetObjValue(formObj.bl_no,blNo);
        		}
				
	    		if(parent.t1frame != undefined && typeof(parent.t1frame) == "object") {
	    			parent.podChangeTabColor("N");
	    		}
	    		
        		formObj.f_cmd.value = SEARCH;
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
        		var param = "f_cmd="+SEARCH + "&bkg_no=" + formObj.bkg_no.value + "&bl_no=" + formObj.bl_no.value;
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
        		ComOpenWait(false);

        		var arrXml = sXml.split("|$$|");  
        		// Combo 셋팅
				if (arrXml.length > 0){	// RD Term
    				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");    				
    				sheetObjects[2].LoadSearchXml(arrXml[0]);
				}             		
				if (arrXml.length > 1){	// RD Term
    				ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");		
				}             						
				if (arrXml.length > 2){	// Filer US		
					ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");
					comboObjects[2].InsertItem(0,"","");
				}				
				if (arrXml.length > 3){	// Filer CA
					ComBkgXml2ComboItem(arrXml[3], comboObjects[3], "val", "name");
					comboObjects[3].InsertItem(0,"","");
				}     				
				if (arrXml.length > 4){	// Weight Unit
					ComBkgXml2ComboItem(arrXml[4], comboObjects[4], "val", "val");
				}     				
				if (arrXml.length > 5){	// Rail Bulk
					ComBkgXml2ComboItem(arrXml[5], comboObjects[5], "val", "name");
				}					
				if (arrXml.length > 6){//ida hlg tp 
					ComBkgXml2ComboItem(arrXml[6], comboObjects[6], "val", "name");
				}       
				if (arrXml.length > 7){	// VSK 정보
					sheetObjects[1].LoadSearchXml(arrXml[7]);
				}       
				if (arrXml.length > 8){	// Quantity 정보
					sheetObjects[0].LoadSearchXml(arrXml[8]);
				}       				
				if (arrXml.length > 9){	// QtyDtl 정보
					sheetObjects[3].LoadSearchXml(arrXml[9], false, -1, false);
				}
				
				BkgEtcDataXmlToForm(arrXml[0], formObj);		// Booking 기본 정보

				// searchVslSkdAvailable 결과값에 따라 Route Detail 버튼색 변경
				changeObjectColor(ComGetEtcData(arrXml[0], "vvd_flag"), "N", "btn_t1RouteDetail", "red", "btn2");
				
				// 2012.01.05 btn_route의 색이 red가 아닌경우에만 port_skp_flg가 'Y'면 green으로 표시 kbj
				if(ComGetEtcData(arrXml[0], "vvd_flag") != 'N'){
					changeObjectColor(formObj.port_skp_flg.value, "Y", "btn_t1RouteDetail", "00cc00", "btn2");
				}
				
				// searchRfaAvailable 결과에 따라 RFA NO 색 변경
				changeObjectColor(ComGetEtcData(arrXml[0], "rfa_available"), "N", "rfa_no", "red", "input");
				
				// searchScAvailable 결과에 따라 SC NO 색 변경
				changeObjectColor(ComGetEtcData(arrXml[0], "sc_available"), "N", "sc_no", "red", "input");
				
				// searchTaaAvailable 결과에 따라 SC NO 색 변경
				changeObjectColor(ComGetEtcData(arrXml[0], "taa_available"), "N", "taa_no", "red", "input");

				// Split Flag 출력				
				if(formObj.adv_shtg_cd.value=="A"){
					formObj.split_info.value = "Adv.";
				} else if(formObj.adv_shtg_cd.value=="S"){
					formObj.split_info.value = "Sh.";
				} else if(formObj.split_rsn_cd.value=="M"){
					formObj.split_info.value = "Memo";
				} else if(ComGetEtcData(arrXml[0], "split_flg")== "Y"){
					formObj.split_info.value = "Split";
				} else {
					formObj.split_info.value = "";
				}
				if(formObj.split_info.value.length>0){
					document.getElementById("split_flg").style.display = "block"
					formObj.split_info.style.color = "blue";					
					formObj.split_info.style.background = "#F3F2F8";					
				} else {
					document.getElementById("split_flg").style.display = "none";
				}

				if(ComGetEtcData(arrXml[0], "prg_flg") == "Y"){
					document.getElementById("wait_rsn").innerHTML = "Purged Booking";
				}else {
					// Wait Reason 출력
					var waitRsn = ComGetEtcData(arrXml[0], "wait_rsn");
					if(waitRsn != undefined){
						document.getElementById("wait_rsn").innerHTML = waitRsn;
					}
				}

				// Booking 담당자 정보
				var userInfo = "ID : "     + ComGetEtcData(arrXml[0], "doc_usr_id") + "<br>" + 
							   "Name : "   + ComGetEtcData(arrXml[0], "usr_nm") + "<br>" + 
							   "TEL : "    + ComGetEtcData(arrXml[0], "xtn_phn_no") + "<br>" + 
							   "E-mail : " + ComGetEtcData(arrXml[0], "usr_eml");
				formObj.userInfo.value = userInfo;

				// spcl 정보 존재시 approve 상태에 따라 색 변경 처리
	            document.getElementById("btn_t1Danger").style.color    = getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "dg_flg"));
	            document.getElementById("btn_t1Reefer").style.color    = getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "rf_flg"));
	            document.getElementById("btn_t1Awkward").style.color   = getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "awk_flg"));
	            document.getElementById("btn_t1BreakBulk").style.color = getSpclCgoBtnColor(ComGetEtcData(arrXml[0], "bb_flg"));

				// Stowage 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "stwg_flg"), "Y", "btn_t1Stowage", "blue", "btn2");	
				// Hanger 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "hngr_flg"), "Y", "btn_t1Hanger", "blue", "btn2");	
				// Stop Off Cargo 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "stop_off_flg"), "Y", "btn_t1StopOffCargo", "blue", "btn2");	
				// Fumigation 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "fumg_flg"), "Y", "btn_t1Fumigation", "blue", "btn2");	
				// Constraint 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "constraint_flag"), "Y", "btn_t1Constraints", "red", "btn2");
				// Reference 정보 존재시 붉은색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "ref_flg"), "Y", "btn_t1ReferenceNo", "blue", "btn2");
				// Manual CCT 정보 존재시 파란색 표시
				changeObjectColor(ComGetEtcData(arrXml[0], "mnl_cct_flg"), "Y", "btn_t1CargoClosingTime", "blue", "btn2");
				// Awkward Container Weight 와 Container Weight 가 20% 이상 차이나면, 빨간색으로 표시.
				changeObjectColor(ComGetEtcData(arrXml[0], "awk_over_wgt_flg"), "Y", "btn_t1Awkward", "red", "btn2");
				
				
				// Firm,Waiting 버튼 처리
				var bkgStsCd = ComGetEtcData(arrXml[0], "bkg_sts_cd");
				// Status 'X','W' 이면 붉은색으로 표시
				changeObjectColor(bkgStsCd, "X", "bkg_sts_cd", "red", "input2");
				changeObjectColor(bkgStsCd, "W", "bkg_sts_cd", "red", "input2");

				if(bkgStsCd == "F"){
					document.getElementById("FirmToWait").style.display = "block";
					document.getElementById("WaitToFirm").style.display = "none";
				}else if(bkgStsCd == "W"){
					document.getElementById("WaitToFirm").style.display = "block";
					document.getElementById("FirmToWait").style.display = "none";
				}
				
				// RollOvr수 체크해서 버튼색깔 변경.(20091125) 
				if(BkgParseInt(ComGetEtcData(arrXml[0], "roll_ovr_cnt")) > 1){
					changeObjectColor("Y", "Y", "btn_t1RollOverInformation", "blue", "btn1");
				}else{
					changeObjectColor("N", "Y", "btn_t1RollOverInformation", "#c0c0c0", "btn1");
				}
				// RCV Term 이 Door Term이 아닌경우 MT DOOR ARRIVAL DATE 비활성화
				if(ComGetEtcData(arrXml[0], "rcv_term_cd") != "D"){					
					formObj.mty_dor_arr_dt.disabled = true;
				}	
				
				// A/Cust 
				if(formObj.agmt_act_cnt_cd.value ==""){
	  	    		document.getElementById("btn_t1Sa0190").style.border = "2 solid #F3F2F8";
	  			}else{	
	  				document.getElementById("btn_t1Sa0190").style.border = "2 solid blue";
	  			}
				
				// Sales Approval
				if(ComGetEtcData(arrXml[0], "new_cust_apro_mark_flg") == "X"){
					btn007901Control(false, "btn_t1SalesApproval");
					document.all.showSalesApproval.style.display = "none";
		    		document.all.showSalesApproval.style.visibility = 'hidden';
				}else{
					changeObjectColor(ComGetEtcData(arrXml[0], "new_cust_apro_mark_flg"), "Y", "btn_t1SalesApproval", "blue", "btn2");
				}

				
				// Original Bl No 저장
				var orgBlNo = ComGetEtcData(arrXml[0], "OrgBlNo");				
				if(orgBlNo != undefined && orgBlNo != ""){
					formObj.orgBlNo.value = orgBlNo;
					document.getElementById("org_bl").style.display = "block";
				}else{
					document.getElementById("org_bl").style.display = "none";
				}
				if(ComGetEtcData(arrXml[0], "act_wgt") != undefined){
					formObj.act_wgt.value = makeComma(ComGetEtcData(arrXml[0], "act_wgt"));
				}
				// 조회 후 BKG Contact 가 보여지도록 한다.
				tabObjects[0].SelectedIndex = 0;		
				
				//ca new creation의 경우 save버튼비활성화
				if(caNewCreationFlag == "Y"){					
					ComBtnDisable("btn_t1Save");	
				} else {
					// Button Enable/Disable
					if(ComGetEtcData(arrXml[0], "DataYn") == "Y"){
						formObj.data_yn.value = "Y";
						btn007901Control(true, "btn_t1Save");
						btn007901Control(true, "btn_t1GoIBCS");
						btn007901Control(true, "btn_t1BKGCancel");
						btn007901Control(true, "btn_t1FaxEDI");
						btn007901Control(true, "btn_t1Holding");
						btn007901Control(true, "btn_t1Waiting");
						btn007901Control(true, "btn_t1EasyCopy");
					}else{
						btn007901Control(false, "btn_t1Save");
						btn007901Control(false, "btn_t1GoIBCS");
						btn007901Control(false, "btn_t1BKGCancel");
						btn007901Control(false, "btn_t1FaxEDI");
						btn007901Control(false, "btn_t1Holding");
						btn007901Control(false, "btn_t1Waiting");
						btn007901Control(false, "btn_t1Split");
						btn007901Control(false, "btn_t1EasyCopy");
						changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");
						parent.initCAControl("", "N", "N", "N", "");
						break;
					}
					
					// BDR 인 경우 비활성화
					if(ComGetEtcData(arrXml[0], "bdr_flg") == "Y"){
						btn007901Control(false, "btn_t1BKGCancel");
						btn007901Control(false, "btn_t1Holding");
						btn007901Control(false, "btn_t1Waiting");	
						btn007901Control(false, "btn_t1EasyCopy");					
					} else {
						btn007901Control(true, "btn_t1BKGCancel");//임시로 활성화
					}
				}
//				if(ComGetEtcData(arrXml[0], "bdr_flg")!="Y"){
//					if(ComGetEtcData(arrXml[0], "is_vl_flg")=="Y"){
//						formObj.bkg_pol_cd.disabled    = true;
//						formObj.bkg_pol_yd_cd.disabled = true;
//						formObj.bkg_pod_cd.disabled    = true;
//						formObj.bkg_pod_yd_cd.disabled = true;
//						if(sheetObjects[1].Rows == 2){
//							formObj.bkg_trunk_vvd.disabled = true;
//						} else {
//							formObj.bkg_trunk_vvd.disabled = false;						
//						}
//					} else {
//						formObj.bkg_pol_cd.disabled    = false;
//						formObj.bkg_pol_yd_cd.disabled = false;
//						formObj.bkg_pod_cd.disabled    = false;
//						formObj.bkg_pod_yd_cd.disabled = false;
//						formObj.bkg_trunk_vvd.disabled = false;			
//					}
//				}
				// BDR='Y'이고 CA='N'이면 일부항목 비활성화처리 (091112)
				if(ComGetEtcData(arrXml[0], "bdr_flg") == "Y" && ComGetEtcData(arrXml[0], "ca_flg") == "N"){
					setBookingEditable(false);
				}else{
					setBookingEditable(true);
				}
				
				if(formObj.split_rsn_cd.value=="M"){
					btn007901Control(false, "btn_t1Split");
					btn007901Control(false, "btn_t1BKGCancel");
				}
				
				if(formObj.bkg_no.value.length > 11 
						&& formObj.bkg_no.value.substring(10, 11) == "9"){
					btn007901Control(false, "btn_t1Split");					
				}
				
				// TAA 존재, RFA 미존재시 TAA 선택
				if(ComIsNull(formObj.taa_no) && !ComIsNull(formObj.rfa_no)){//rfa 활성화
					formObj.chkTaaRfaNo[1].checked = true;				
					document.all.item("taaNoDiv").style.display = "none";
					document.all.item("rfaNoDiv").style.display = "block";		
				}else if(!ComIsNull(formObj.taa_no) && ComIsNull(formObj.rfa_no)){//taa 활성화
					formObj.chkTaaRfaNo[0].checked = true;					
					document.all.item("taaNoDiv").style.display = "block";
					document.all.item("rfaNoDiv").style.display = "none";						
				}else if(ComIsNull(formObj.taa_no) && ComIsNull(formObj.rfa_no)){ //둘다 없을 때 us가 있으면 taa
					if(ComGetObjValue(formObj.bkg_por_cd).substring(0,2)=="US" || 
					   ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US" ||
						(!ComIsNull(formObj.bkg_pod_cd) && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="US") ||
						ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US" ){
						formObj.chkTaaRfaNo[0].checked = true;					
						document.all.item("taaNoDiv").style.display = "block";
						document.all.item("rfaNoDiv").style.display = "none";											
					} else {//이도 저도 아니면 rfa
						formObj.chkTaaRfaNo[1].checked = true;				
						document.all.item("taaNoDiv").style.display = "none";
						document.all.item("rfaNoDiv").style.display = "block";								
					}
				}
				if("Y"==ComGetEtcData(arrXml[0],"mnl_bkg_no_flg")){
					formObj.mnl_bkg_no_flg.checked = true;
				} else {
					formObj.mnl_bkg_no_flg.checked = false;					
				}
				if(ComGetObjValue(formObj.crr_soc_flg)=="Y"){
					formObj.chk_crr_soc_flg.checked = true;
				}else{
					formObj.chk_crr_soc_flg.checked = false;
				}
				if(ComGetObjValue(formObj.veh_cmdt_flg)=="Y"){
					formObj.chk_veh_cmdt_flg.checked = true;
				}else{
					formObj.chk_veh_cmdt_flg.checked = false;
				}
				if(ComGetObjValue(formObj.non_dg_chem_flg)=="Y"){
					formObj.chk_non_dg_chem_flg.checked = true;
				}else{
					formObj.chk_non_dg_chem_flg.checked = false;
				}
				
				oldPolYdCd = formObj.bkg_pol_cd.value + formObj.bkg_pol_yd_cd.value;
				oldPodYdCd = formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
				
				ComSetObjValue(formObj.modify_flag, 			"N");
				ComSetObjValue(formObj.cgo_dtl_auto_flg, 		"Y");
				ComSetObjValue(formObj.carge_detail_pop, 		"Y");				
				ComSetObjValue(formObj.partial_vvd_opened_flg, 	"N");
	        	ComSetObjValue(formObj.route_modify_flag, 		"N");
	        	ComSetObjValue(formObj.customer_modify_flag, 	"N");
	        	ComSetObjValue(formObj.contact_modify_flag, 	"N");
	    	    ComSetObjValue(formObj.qty_modify_flag, 		"N");
	    	    ComSetObjValue(formObj.close_bkg_flag,			"N");
	    	    ComSetObjValue(formObj.ts_close_bkg_flag,		"N");
	    	    ComSetObjValue(formObj.check_ts_close_flag,     "N");
	    	    ComSetObjValue(formObj.closed_ts_vvd,			"");
	    	    ComSetObjValue(formObj.cbf_bkg_flag,			"N");
	    	    ComSetObjValue(formObj.aloc_chk_flg,			"N");
				manageHaveRouteFlag("Y");
	    	    route_detail_modify_flag = "";
	    	    agmtActCustModifyFlag = false;
				
				if(ComGetObjValue(formObj.isInquiry) == "Y"){
					setInquiryDisableButton();
				}
				
				// C/A 버튼 Control
				if(formObj.ca_new_creation_flag.value != "Y" && parent && parent.initCAControl){
					parent.initCAControl(ComGetEtcData(arrXml[0], "bkg_no"), ComGetEtcData(arrXml[0], "ca_flg"), ComGetEtcData(arrXml[0], "bdr_flg"), ComGetEtcData(arrXml[0], "ca_exist_flg"), ComGetEtcData(arrXml[0], "bl_no"));
				}
				if(ComGetObjValue(formObj.ca_flg)=="Y"){
					document.getElementById("bkg_no").className = "input2";
					document.getElementById("bl_no").className = "input2";		
				}
//				if(ComGetObjValue(formObj.isInquiry) == "Y"){
//					setInquiryDisableButton();
//				}				
		    	formObj.sXml.value = null;
		    	ComSetObjValue(formObj.tvvd_modify_flg, "N");
		    	
		    	var eurTro = ComGetEtcData(arrXml[0], "eur_tro");
		    	
				if(eurTro != undefined){
					document.all.item("tro_flg").style.display = "block";
					document.all.item("tro_flg").innerText = eurTro;
				}else{
					document.all.item("tro_flg").style.display = "none";
					document.all.item("tro_flg").innerText = "";
				}
				ctrt_ofc_cd_old = formObj.ctrt_ofc_cd.value;
				ctrt_srep_cd_old = formObj.ctrt_srep_cd.value;
				formObj.old_cmdt_cd.value = formObj.cmdt_cd_old.value;
				
				// POL_CD 가 미주 아니면 Stanby Detail 버튼 비활성화
				if((ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="US"
					||ComGetObjValue(formObj.bkg_pol_cd).substring(0,2)=="CA"
					||ComGetObjValue(formObj.svc_scp_cd)=="SAW"
					||ComGetObjValue(formObj.svc_scp_cd)=="BRE")
					&& ComGetObjValue(formObj.aloc_sts_cd)!=""){
					btn007901Control(true, "btn_AlocReason");		
				}else{
					btn007901Control(false, "btn_AlocReason");		
				}
				
				// Outbound DEM DET 표시
				if(ComGetEtcData(arrXml[0], "ob_dmt")!=""){
					var ob_dmt_str  = ComGetEtcData(arrXml[0], "ob_dmt");
					var ob_dmt_num  = ComGetEtcData(arrXml[0], "ob_dmt").split(" ")[0];
					var ob_dmt_curr = ComGetEtcData(arrXml[0], "ob_dmt").split(" ")[1];
					if(ob_dmt_num != undefined && ob_dmt_curr != undefined){
						ob_dmt_str = ComAddComma(ob_dmt_num) + " " + ob_dmt_curr;
					}
					ComSetObjValue(formObj.ob_dmt, ob_dmt_str);
				}else{
					ComSetObjValue(formObj.ob_dmt, "");
				}
				// Origin,Dest 장비 상황 표시
				//alert(ComGetEtcData(arrXml[0], "por_cost_sts")+"|"+ComGetEtcData(arrXml[0], "del_cost_sts"));
				
				break;
                
        	case COMMAND01:        //저장
        		if(ComGetObjValue(formObj.isInquiry) == "Y"){
        			return;
        		}
        		var bkgTrunkVvd = ComGetObjValue(formObj.bkg_trunk_vvd);
        		if((sheetObjects[1].Rows - sheetObjects[1].HeaderRows) <= 1) {
        			ComSetObjValue(formObj.tvvd_modify_flg, "N");
        		}
        		var tvvdModifyFlg = ComGetObjValue(formObj.tvvd_modify_flg);
        		if(!ComIsNull(tvvdModifyFlg) && "Y" == tvvdModifyFlg){
					ComShowCodeMessage("BKG02092");
				}       		
        		var bkgPorCd   = ComGetObjValue(formObj.bkg_por_cd);
        		var bkgPorYdCd = ComGetObjValue(formObj.bkg_por_yd_cd);
        		var bkgPolCd   = ComGetObjValue(formObj.bkg_pol_cd);
        		var bkgPolYdCd = ComGetObjValue(formObj.bkg_pol_yd_cd);
        		var bkgPodCd   = ComGetObjValue(formObj.bkg_pod_cd);
        		var bkgPodYdCd = ComGetObjValue(formObj.bkg_pod_yd_cd);
        		var bkgDelCd   = ComGetObjValue(formObj.bkg_del_cd);
        		var bkgDelYdCd = ComGetObjValue(formObj.bkg_del_yd_cd);
        		var pre_rly_port_cd = ComGetObjValue(formObj.pre_rly_port_cd);
        		var pst_rly_port_cd = ComGetObjValue(formObj.pst_rly_port_cd);     
        		var pre_rly_port_yd_cd = ComGetObjValue(formObj.pre_rly_port_yd_cd);
        		var pst_rly_port_yd_cd = ComGetObjValue(formObj.pst_rly_port_yd_cd);

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
        			
//        			// 2014.12.09 []
//        			// 1. ESPSD Y2 – DG Cargo에 대해 POL, T/S Port, POD/DEL이 ESPSD Y2인 경우
//        			if( ( bkgPolCd == "ESPSD" && bkgPolYdCd == "Y2" ) || ( bkgPodCd == "ESPSD" && bkgPodYdCd == "Y2" ) || ( bkgDelCd == "ESPSD" && bkgDelYdCd == "Y2" )
//        					|| ( pre_rly_port_cd == "ESPSD" && pre_rly_port_yd_cd == "Y2" ) || ( pst_rly_port_cd == "ESPSD" && pst_rly_port_yd_cd == "Y2" ) ){
//        				if( formObj.dcgo_flg.checked){
//        					ComShowCodeMessage("BKG08340"); 
//        				}
//        			}
//        			// 2. INMAA – DG Cargo에 대해 POD/DEL이 INMAA인 경우.
//        			if( bkgPodCd == "INMAA" || bkgDelCd == "INMAA" ){
//        				if( formObj.dcgo_flg.checked){
//        					ComShowCodeMessage("BKG08341"); 
//        				}
//        			}		
//        			// 3. BHBAH – DG cargo에 대해 T/S Port 혹은 POD/DEL이 BHBAH
//        			if( bkgPodCd == "BHBAH" || bkgDelCd == "BHBAH" || pre_rly_port_cd == "BHBAH" || pst_rly_port_cd == "BHBAH"){
//        				if( formObj.dcgo_flg.checked){
//        					ComShowCodeMessage("BKG08342"); 
//        				}
//        			}
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

        		// 2014.11.21 미주발 막기
        		// 2011.08.02 중국 Solid Waste 관련 bkg commodity validation 추가
        		bkgDelCd = ComGetObjValue(formObj.bkg_del_cd).substring(0,2);
        		var bkgPolCdSub = ComGetObjValue(formObj.bkg_pol_cd).substring(0,2);
        		if((bkgDelCd == "CN" || bkgDelCd == "MO" || bkgDelCd == "TW")
    					&& bkgPolCdSub!="US"){ //중국, 마카오, 타이완
            		var chnWasteXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND05, FormQueryString(formObj));
    				var chn_waste_flag = ComGetEtcData(chnWasteXml, "chn_waste_flag");
    				if(chn_waste_flag == "Y"){
    					ComShowCodeMessage("BKG01169"); //"[Warning] Please double-check the certificates for this solid waste cargo to China, Hong Kong, Macao and Taiwan."
    				}	    				
    			}
   
//        		// Black List Check (Iran)
//				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
//				var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
//				var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
//				if(black_cust_flag == "Y"){
//					if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
//						return false;
//					}
//				}
//				else{
				// Black List Check (US)
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND09, FormQueryString(formObj));
				var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
				var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
				var black_rmk_flag = ComGetEtcData(sXml, "black_rmk_flag");
				var black_rmk_list = ComGetEtcData(sXml, "black_rmk_list");
				if(black_cust_flag == "Y"){
					if(!ComShowCodeConfirm("BKG02070", 'Customer Name' ,black_cust_list)){
						return false;
					}else{
						var bkg_no = formObj.bkg_no.value;
			 			var blckTpCd = "SAN_CUST";
			 			var blckKwNm = black_cust_list;
			 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
						var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
					}
				}else if(black_rmk_flag == "Y"){
					if(!ComShowCodeConfirm("BKG02070", 'Int/Ext Remark' ,black_rmk_list)){
						return false;
					}else{
						var bkg_no = formObj.bkg_no.value;
			 			var blckTpCd = "SAN_RMK";
			 			var blckKwNm = black_rmk_list;
			 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
						var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
					}
				}
//				}
				
				// Remark 에 BKG_BLACK_LIST 금지어 포함 되었는지 CHECK	
				var bkgBlackListStr = "";
				if(ComGetObjValue(formObj.xter_rmk)!=""){
					var param = "&f_cmd=" + SEARCH17 + "&input_text=" + ComGetObjValue(formObj.xter_rmk);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			bkgBlackListStr = output_text;
			 		}
			 	}
			 	if(bkgBlackListStr=="" && ComGetObjValue(formObj.inter_rmk)!=""){
			 		var param = "&f_cmd=" + SEARCH17 + "&input_text=" + ComGetObjValue(formObj.inter_rmk);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			bkgBlackListStr = output_text;
			 		}
				}
			 	if(bkgBlackListStr!=""){
			 		//bkg blck list mntr 테이블로 인터페이스
		 			ComShowCodeMessage("BKG95093",bkgBlackListStr);
		 			var bkg_no = formObj.bkg_no.value;
		 			var blckTpCd = "BLA_RMK";
		 			var blckKwNm = bkgBlackListStr;
		 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
					var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
		 		}
			 // Remark 에 Yellow 금지어 포함 되었는지 CHECK	
				var yellowBlackListStr = "";
				if(ComGetObjValue(formObj.xter_rmk)!=""){
					var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" + ComGetObjValue(formObj.xter_rmk);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			yellowBlackListStr = output_text;
			 		}
			 	}
			 	if(yellowBlackListStr=="" && ComGetObjValue(formObj.inter_rmk)!=""){
			 		var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" + ComGetObjValue(formObj.inter_rmk);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			yellowBlackListStr = output_text;
			 		}
				}
			 	if(yellowBlackListStr!=""){
		 			ComShowCodeMessage("BKG95101",yellowBlackListStr);
		 			var bkg_no = formObj.bkg_no.value;
		 			var blckTpCd = "YEL_RMK";
		 			var blckKwNm = yellowBlackListStr;
		 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
					var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
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
		 			var bkg_no = formObj.bkg_no.value;
		 			var blckTpCd = "CAL_RMK";
		 			var blckKwNm = chaCalHypoBlockList;
		 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
					var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
		 		}
				
      	
        		// VVD 변경시 사전신고 된 VVD가 변경된 경우 저장 Click시 warning 메시지 표시
				var params = FormQueryString(formObj);				
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true),"t1sheet2_");

				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND06, params);
				var vvd_change = ComGetEtcData(sXml, "vvd_change");
				
				if(null != vvd_change && ""!=vvd_change ){
					ComShowCodeMessage("BKG02088", vvd_change);
				}
		      	
				//por(pol)이 CA나 US인 경우만 하단의 로직을 실행 2011.11.10 kbj
				if(validateCRep(formObj)){
	        		// c.ofc & c.rep 를 체크 2011.10.11 jsy
					var sXml = sheetObj.GetSearchXml("ESM_BKG_1132GS.do?f_cmd="+SEARCH, "&bkg_no="+formObj.bkg_no.value+"&sc_no="+
							                          formObj.sc_no.value+"&ctrt_rep_cd="+formObj.ctrt_ofc_cd.value+formObj.ctrt_srep_cd.value );
					var CtrtRepCnt = ComGetEtcData(sXml, "CtrtRepCnt");
					var compare_cd = ComGetEtcData(sXml, "compare_cd");
					if( CtrtRepCnt > 1 && compare_cd == 'N') {
						ComOpenPopup("ESM_BKG_1132.do?pgmNo=ESM_BKG_1132&sXml="+encodeURIComponent(sXml)+"&func=callBack1132", 500, 290, "callBack1132",	"1,0,1,1,1", true);
					}
					if( CtrtRepCnt == 1 && compare_cd == 'N') {
						var cust_sls_ofc_cd = ComGetEtcData(sXml, "cust_sls_ofc_cd");
						var cust_srep_cd = ComGetEtcData(sXml, "cust_srep_cd");
						ComSetObjValue(formObj.ctrt_ofc_cd, cust_sls_ofc_cd);
						ComSetObjValue(formObj.ctrt_srep_cd, cust_srep_cd);
					}
				}
				
				// ROUTE DETAIL 에 POL 이 KR 이 있는 경우만 하단의 로직을 실행 2014.05.20 
				if(sheetObjects[1].RowCount > 0 && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
					var krRow = sheetObjects[1].FindText("pod_cd", "KR", 0, 0);
					if(krRow != -1){
						var krVvdCd  = sheetObjects[1].CellValue(krRow,"bkg_vvd_cd");
						var krPodLoc = sheetObjects[1].CellValue(krRow,"pod_cd");

						if(krVvdCd.length > 0 && krPodLoc.length > 0){
							var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH15+"&vvd_cd="+krVvdCd+"&pod_loc="+krPodLoc);
							var krDlCnt = ComGetEtcData(sXml, "kr_cstms_dl_cnt");
							if(krDlCnt!="" && krDlCnt.length>0 && krDlCnt>0){
								ComShowCodeMessage("BKG08312", krVvdCd);
							}
						}
					}
				}
		      	
				if(ctrt_ofc_cd_old !=  ComGetObjValue(formObj.ctrt_ofc_cd) 
						|| ctrt_srep_cd_old !=  ComGetObjValue(formObj.ctrt_srep_cd)) {
					ComSetObjValue(formObj.modify_flag, "Y");
				}
				
        		var oldBkgNo = ComGetObjValue(formObj.old_bkg_no);
        		var haveRouteFlag = ComGetObjValue(formObj.have_route_flag);
        		var qtyModifyFlag = ComGetObjValue(formObj.qty_modify_flag);
        		var precheckFlag = "";
    			if(ComIsNull(oldBkgNo)){
    				if(haveRouteFlag == "N"){
        				ComSetObjValue(formObj.f_cmd, MULTI01);	// Create Without Route
        			}else{
        				ComSetObjValue(formObj.f_cmd, MULTI02);	// Create With Route
        			}
        		}else{
    				if(haveRouteFlag == "N"){
        				ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify Without Route
        			}else{
        				ComSetObjValue(formObj.f_cmd, MULTI04);	// Modify With Route
        			}        			
        		}      
    	       	  		
//    			//C/A 이면서 vvd 5개 이상 타면 p/c 실행하지 않음
        		if(ComGetObjValue(formObj.ca_flg) == "Y" && sheetObjects[1].Rows>5){
    				ComSetObjValue(formObj.f_cmd, MULTI03);	// Modify With Route        			
        		}
        		
        		setBookingEditable(true);
     		
        		var isFlexHgtFlg = false;
        		if(formObj.flex_hgt_flg.disabled){
        			formObj.flex_hgt_flg.disabled = false;
        			isFlexHgtFlg = true;
        		}
        		
        		formObj.act_wgt.value = formObj.act_wgt.value.replace(/,/g, "");
        		
				var params = FormQueryString(formObj);				
				
				if(isFlexHgtFlg){
					formObj.flex_hgt_flg.disabled = true;
				}
				ComSetObjValue(formObj.act_wgt, makeComma(ComGetObjValue(formObj.act_wgt)));
				params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true),"t1sheet4_");	
				params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true),"t1sheet1_");
				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true),"t1sheet2_");
    				    	
				var sXml = "";
				var IsPctlNoPop = "";
				if(formObj.inter_rmk.value == "PRD POP"){
					IsPctlNoPop = "YC";
					formObj.inter_rmk.value = "";
				} else {
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					//최초 저장 시작
					sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do", params);
					if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
						setBookingEditable(false);
					}else{
						setBookingEditable(true);
					}			
				
					ComOpenWait(false);	 
					var arrXml = sXml.split("|$$|");
			
					/** Allocation Firm -> Standby 메세지 */
					if(ComGetEtcData(sXml, "aloc_stand_by_msg_flg") == 'Y') {
						ComShowCodeMessage("BKG95142");
					}
					
					IsPctlNoPop = ComGetEtcData(sXml, "IsPctlNoPop");			
				}

				if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){					
					var firstVvd = ComGetEtcData(sXml, "first_vvd");
					if(ComShowCodeConfirm("BKG00312",firstVvd)){
						ComSetObjValue(formObj.close_bkg_flag, "Y");
						
						doActionIBSheet(sheetObj, formObj, COMMAND01);

        				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        					//bkg close mail open
        					//=========================================================================================
        					var subject = ComIsNull(oldBkgNo)?"BKG Creation Notice":"BKG Change Notice";
        					var closeBkgMsg = ComGetEtcData(sXml, "closeBkgMsg");
        					if(ComIsNull(oldBkgNo)){ //bkg 생성시에 new bkg_no를 넣는다.
        						closeBkgMsg = "BKG No : " + formObj.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
        					}
        					//=========================================================================================
                    		ComBkgGroupMailset(sheetObjects[2], formObj, subject, closeBkgMsg);        					
        				}        				
					} else {
						ComSetObjValue(formObj.close_bkg_flag, "N");	
						break;
					}
				} else if(ComGetEtcData(sXml, "tsCloseBkgFlag") == "Y"){
					// for t/s bkg close by bayplan
					var closedVvds = ComGetEtcData(sXml, "closedVvds");
					if(closedVvds != null && closedVvds.length > 0){
						ComShowCodeMessage("BKG08253",closedVvds);
					}
					ComSetObjValue(formObj.ts_close_bkg_flag, "Y");
					ComSetObjValue(formObj.closed_ts_vvd, closedVvds);					
					
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
				} else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
					if(ComShowCodeConfirm("BKG02069")){
						ComSetObjValue(formObj.cbf_bkg_flag, "Y");
						doActionIBSheet(sheetObj, formObj, COMMAND01); 
        				
        				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        					//bkg close mail open
        					//=========================================================================================
        					var subject = ComIsNull(oldBkgNo)?"BKG Creation Notice":"BKG Change Notice";
        					var closeBkgMsg = ComGetEtcData(sXml, "closeBkgMsg");
        					if(ComIsNull(oldBkgNo)){ //bkg 생성시에 new bkg_no를 넣는다.
        						closeBkgMsg = "BKG No : " + formObj.bkg_no.value + "<BR>" + closeBkgMsg.substring(13);
        					}
        					//=========================================================================================
                    		ComBkgGroupMailset(sheetObjects[2], formObj, subject, closeBkgMsg);        					
        				}        				
					} else {
						ComSetObjValue(formObj.cbf_bkg_flag, "N");	
						break;
					}
				} else if(IsPctlNoPop == "YC" || IsPctlNoPop == "YM"){
					var url = "";
					// ESD_PRD_018 화면 호출
//					var url = "http://localhost:7001/hanjin/ESD_PRD_0080.do?f_cmd=3&pc_mode=B"
					if(IsPctlNoPop == "YC"){
						url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";
					}else if(IsPctlNoPop == "YM"){
						url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=R";
						url = url + "&bkg_no=" +	ComGetObjValue(formObj.bkg_no);
					} else {
						url = "ESD_PRD_0080.do?pgmNo=ESD_PRD_0080&f_cmd=3&pc_mode=B";						
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
					for(i = 1 ; i < sheetObjects[1].Rows; i++){
						url = url + "&pol" + i + "="   + sheetObjects[1].CellValue(i, "pol_cd");
						if(sheetObjects[1].CellValue(i, "pol_yd_cd")!= null && sheetObjects[1].CellValue(i, "pol_yd_cd").length > 1)
						url = url + "&pol" + i + "_n=" + sheetObjects[1].CellValue(i, "pol_cd") + sheetObjects[1].CellValue(i, "pol_yd_cd");
						url = url + "&pol" + i + "_c=" + sheetObjects[1].CellValue(i, "pol_clpt_ind_seq");
						url = url + "&pod" + i + "="   + sheetObjects[1].CellValue(i, "pod_cd");
						if(sheetObjects[1].CellValue(i, "pod_yd_cd")!= null  && sheetObjects[1].CellValue(i, "pod_yd_cd").length > 1)
						url = url + "&pod" + i + "_n=" + sheetObjects[1].CellValue(i, "pod_cd") + sheetObjects[1].CellValue(i, "pod_yd_cd");
						url = url + "&pod" + i + "_c=" + sheetObjects[1].CellValue(i, "pod_clpt_ind_seq");
						url = url + "&vvd" + i + "="   + sheetObjects[1].CellValue(i, "bkg_vvd_cd");
					}
					url = url + "&rcv_t=" + ComGetObjValue(formObj.rcv_term_cd);
					url = url + "&del_t=" + ComGetObjValue(formObj.de_term_cd);
					url = url + "&shpr="  + ComGetObjValue(formObj.s_cust_cnt_cd)+ComGetObjValue(formObj.s_cust_seq);
					url = url + "&cngn="  + ComGetObjValue(formObj.c_cust_cnt_cd)+ComGetObjValue(formObj.c_cust_seq);

					url = url + "&com="     + ComGetObjValue(formObj.cmdt_cd);
					url = url + "&rep_com=" + ComGetObjValue(formObj.rep_cmdt_cd);
					url = url + "&wgt="     + ComGetObjValue(formObj.act_wgt).replace(/,/g, "");
					url = url + "&wgt_un="  + ComGetObjValue(formObj.wgt_ut_cd);
					url = url + "&bkg_ofc=" + ComGetObjValue(formObj.bkg_ofc_cd);
					url = url + "&org_sal_ofc=" + ComGetObjValue(formObj.ob_sls_ofc_cd);
					url = url + "&m_pu="        + ComGetObjValue(formObj.mty_pkup_yd_cd);
					url = url + "&mt_pkup_dt="  + changeDateFormat(ComGetObjValue(formObj.mty_pkup_dt));
					//최초 생성 이후에 m_pu, f_rt, mt_pkup_dt 적용 없음(20091217 신은영차장님 요청)
//					if(IsPctlNoPop == "YC"){
						url = url + "&f_rt="  + ComGetObjValue(formObj.full_rtn_yd_cd);						
//					}
					url = url + "&ld_dt=" + changeDateFormat(ComGetObjValue(formObj.lodg_due_dt));
					url = url + "&dr_dt=" + changeDateFormat(ComGetObjValue(formObj.de_due_dt));
					
					url = url + "&org_trns_mode="  + changeTransMode((formObj.de_term_cd_old != formObj.de_term_cd)?"AL":ComGetObjValue(formObj.org_trns_mod_cd));
 	                url = url + "&dest_trns_mode=" + changeTransMode((formObj.rcv_term_cd_old != formObj.rcv_term_cd)?"AL":ComGetObjValue(formObj.dest_trns_mod_cd));

					
					if(!ComIsNull(ComGetObjValue(formObj.rfa_no))){
						url = url + "&rfa=" + ComGetObjValue(formObj.rfa_no);
//						url = url + "&rfa_ofc=" + ComGetEtcData(sXml, "RfaOfc");
					}
					if(!ComIsNull(ComGetObjValue(formObj.sc_no))){
						url = url + "&sc=" + ComGetObjValue(formObj.sc_no);						
//						url = url + "&sc_ofc=" + ComGetEtcData(sXml, "ScOfc");
					}
	    			for(i = 1 ; i < sheetObjects[0].Rows ; i++){
	    				url = url + "&c_tpsz="+sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
	    				url = url + "&c_qty="+sheetObjects[0].CellValue(i, "op_cntr_qty");  
	    			}					
					if(formObj.bkg_cgo_tp_cd.checked){
						url = url + "&cgo_tp=R";
					}else{
						url = url + "&cgo_tp=F";
					}
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
					url = url + "&pm_f=N";
					if(formObj.flex_hgt_flg.checked){
						url = url + "&flex_hgt_flg=Y";
					}else{
						url = url + "&flex_hgt_flg=N";
					}						
					url = url + "&rd_f="  + ComGetObjValue(formObj.rd_cgo_flg);
					url = url + "&hg_f="  + ComGetObjValue(formObj.hngr_flg);
					url = url + "&soc_f=" + ComGetObjValue(formObj.soc_flg);
					url = url + "&sub_f=" + ComGetObjValue(formObj.eq_subst_flg);
					url = url + "&ida_hlg_tp_cd=" + ComGetObjValue(formObj.ida_hlg_tp_cd);
//					alert(url);	
					ComSetObjValue(formObj.pctl_no, "");
		 	    	manageHaveRouteFlag("N");
					ComOpenPopup(url, 1024, 730, "callBackEsdPrd0080",	"1,0,1,1,1", true);

					if(ComIsNull(formObj.pctl_no.value)){
//						ComShowCodeMessage("BKG00309");	
					} else {
						precheckFlag = ComGetEtcData(sXml, "pre_checking");
						doActionIBSheet(sheetObj, formObj, COMMAND01); 
					}
					ComSetObjValue(formObj.tvvd_modify_flg, "N");
				}else{
					// p/c를 실행하지 않는 저장 이후
					if (arrXml.length > 0){
						sheetObjects[2].LoadSearchXml(arrXml[0]);
					}
				
					if(ComGetEtcData(sXml, "psaValCode") != "Y" && ComGetEtcData(sXml, "psaValCode") != undefined){
						var errMsg01 = ComGetEtcData(sXml,"psaValCode");

						/*
						 * 2010.10.13 경종윤 추가 
						 * null 문제
						 * if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") { }
						 */
						if(errMsg01 != undefined && errMsg01 != null && errMsg01 != "") {							
					    	var rmsg = errMsg01.split("<||>");
					    	if(rmsg[1] != undefined && rmsg[1].length > 0 && rmsg[1] == "BKG95027" ) {
					    		ComShowCodeMessage("BKG06125");
					    	}else if ( rmsg[1] != "BKG95025" ){
					    		ComShowMessage(rmsg[3]);
					    	}					    	
						}
					}	
					if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
						if (ComGetEtcData(sXml, "dg_key_flg2") != undefined) {
							if(ComGetEtcData(sXml, "dg_key_flg2") == "Y"){
								ComShowCodeMessage("BKG95100");
							}
						}
						// 최종 save 성공
						if (ComGetEtcData(sXml, "bkg_no") != undefined) {
							formObj.bkg_no.value = ComGetEtcData(sXml, "bkg_no");
						}
						if(ComGetObjValue(formObj.tvvd_modify_flg) == "Y" ){
							ComShowCodeMessage("BKG02091");
							ComSetObjValue(formObj.tvvd_modify_flg, "N");
						} else {
							ComBkgSaveCompleted();
						}
						precheckFlag = ComGetEtcData(sXml, "pre_checking");
						if(precheckFlag == "Y"){
							comBkgCallPop0200(formObj.bkg_no.value, formObj.ca_flg.value);
//							ComOpenWindowCenter("ESM_BKG_0200.do?pgmNo=ESM_BKG_0200&bkg_no="+formObj.bkg_no.value+"&ca_flg="+formObj.ca_flg.value, "ESM_BKG_0055", 1010, 570, true);
//							doActionIBSheet(sheetObj, formObj, SEARCH);
						}
						else if(precheckFlag == "A"){
							ComShowCodeMessage("BKG95052");
						}

						ComSetObjValue(formObj.modify_flag, "N");

						// office change 확인
						if (ComGetEtcData(sXml, "ofcChgFlag") == "Y"){
							doActionIBSheet(sheetObj, formObj, SEARCH02);
						}
						if (ComGetEtcData(sXml, "codFlg") == "Y"){
							bkg0156PopUp(formObj.bkg_no.value,"");
						}
						if(ComGetEtcData(sXml, "non_rate_msg_flg") == "Y"){
							ComShowCodeMessage("BKG08336");
						}
						if(ComGetEtcData(sXml, "firm_msg_flg") == "Y"){
							ComShowCodeMessage("BKG08300");
						}
						//alert(ComGetEtcData(sXml, "aloc_pop_flg"));
						if(ComGetEtcData(sXml, "aloc_pop_flg") == "Y"){
							var param = "bkg_no=" + formObj.bkg_no.value + "&aloc_pop_flg=Y"
							          + "&before_aloc_sts_cd=" + ComGetObjValue(formObj.aloc_sts_cd);
							ComOpenPopup("ESM_BKG_1507.do?"+param, 760, 550, "","1,0,1,1,1", true);
						}
						
						success_flag = true;
						change_firstvvd_flag = ComGetEtcData(sXml, "change_first_vvd");
					}											
				}			
        		break;
        		
			case COMMAND03:      //booking split no조회 
				ComSetObjValue(formObj.f_cmd, COMMAND03);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value);
				var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
				bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,-15);         	
				break;

			case MODIFY04:      //Waiting -> Firm
				ComSetObjValue(formObj.f_cmd, MODIFY04);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do?newStsCd=R", "f_cmd="+MODIFY04+"&bkg_no="+formObj.bkg_no.value);
				ComOpenWait(false); 
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					document.all.item("FirmToWait").style.display = "block";
					document.all.item("WaitToFirm").style.display = "none";		
					
					ComBkgSaveCompleted();
					
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				break;			

			case MODIFY05:      //Firm -> Waiting
				ComSetObjValue(formObj.f_cmd, MODIFY05);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do?newStsCd=P", "f_cmd="+MODIFY05+"&bkg_no="+formObj.bkg_no.value);
				ComOpenWait(false); 
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					document.all.item("FirmToWait").style.display = "none";
					document.all.item("WaitToFirm").style.display = "block";		
					
					ComBkgSaveCompleted();
					
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				break;
			case MODIFY06:      //Cancel
				var saveSuccessFlag = true;
				if(ComGetObjValue(formObj.modify_flag) == "Y" && ComGetObjValue(formObj.bkg_sts_cd) != "X"){
        			if(ComShowCodeConfirm("BKG00350")){
        				window.event.srcElement.setAttribute("name","btn_t1Save");
        				saveSuccessFlag = processButtonClick();  
        			}
        		}	
				
				ComSetObjValue(formObj.f_cmd, MODIFY06);
				sheetObj.WaitImageVisible=false;
				ComOpenWait(true);			  
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do", "f_cmd="+MODIFY06+
																	   "&bkg_no="+formObj.bkg_no.value+
																	   "&ca_flg="+formObj.ca_flg.value+
																	   "&close_bkg_flag="+formObj.close_bkg_flag.value+
																	   "&cbf_bkg_flag="+formObj.cbf_bkg_flag.value);
				ComOpenWait(false); 
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "closeBkgFlag") =="Y"){
					var firstVvd = ComGetEtcData(sXml, "first_vvd");
					if(ComShowCodeConfirm("BKG00312",firstVvd)){

						ComSetObjValue(formObj.close_bkg_flag, "Y");
        				doActionIBSheet(sheetObjects[2], formObj, MODIFY06);

        				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
                    		var subject = "BKG Change Notice";            		
                    		ComBkgGroupMailset(sheetObjects[2], formObj, subject, ComGetEtcData(sXml, "closeBkgMsg"));        					
        				}
					} else {
						ComSetObjValue(formObj.close_bkg_flag, "N");	
						break;
					}		
				}else if(ComGetEtcData(sXml, "cbfBkgFlag") =="Y"){
//					var firstVvd = ComGetEtcData(sXml, "first_vvd");
					if(ComShowCodeConfirm("BKG02069")){
						ComSetObjValue(formObj.cbf_bkg_flag, "Y");
        				doActionIBSheet(sheetObjects[2], formObj, MODIFY06);
        				
        				if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
                    		var subject = "BKG Change Notice";            		
                    		ComBkgGroupMailset(sheetObjects[2], formObj, subject, ComGetEtcData(sXml, "cbfBkgMsg"));        					
        				}
					} else {
						ComSetObjValue(formObj.cbf_bkg_flag, "N");	
						break;
					}	
				}else{
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
						ComShowCodeMessage("BKG00590");
						ComSetObjValue(formObj.modify_flag,"N");
						doActionIBSheet(sheetObj, formObj, SEARCH);
					}									
				} 
				break;
			case SEARCH02:
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", param);
        		var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
    				sheetObjects[4].LoadSearchXml(arrXml[0]);
				}
        		ComOpenWait(false);
				break;

			case MODIFY07:
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do", param);
        		sheetObjects[2].LoadSearchXml(sXml);
        		ComOpenWait(false);
//        		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
//        			ComBkgSaveCompleted();
//        			doActionIBSheet(sheetObjects[2], document.form, SEARCH);
//        		}
				break;	
				
			case SEARCH04:
        		if(ComGetObjValue(formObj.ca_flg) == "")
        			formObj.ca_flg.value = 'N';
        		var param = "f_cmd=" + sAction + "&bl_no=" + ComGetObjValue(formObj.bkg_no) + "&sc_no=" + ComGetObjValue(formObj.sc_no)
        		 + "&ca_flg=" + ComGetObjValue(formObj.ca_flg);
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_0269GS.do", param);
        		formObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
        		formObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

        		if (formObj.chk_oft.value == "N" ){
        			var param = 
        				'bkg_no=' + formObj.bkg_no.value + 
        				'&application_date=' + formObj.application_dt.value + 
        				'&sc_no=' + formObj.sc_no.value + 
        				'&ca_flg=' + formObj.ca_flg.value +
        				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
        				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
        				'&is_bkg=' + "Y";

					var pgmNo = "&pgmNo=ESM_BKG_0269";
					var url = "ESM_BKG_0269.do?" + param + pgmNo;
					ComOpenPopup(url, 1050, 650, "", "0,0", true);					
        		}
				break;		
				
			case SEARCH05:
        		if(ComGetObjValue(formObj.ca_flg) == "")
        			formObj.ca_flg.value = 'N';
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&rfa_no=" + ComGetObjValue(formObj.rfa_no)
        		 		+ "&ca_flg=" + ComGetObjValue(formObj.ca_flg);
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_0739GS.do", param);
        		formObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
        		formObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

        		if (formObj.chk_oft.value == "N" ){
        			var param = 
        				'bkg_no=' + formObj.bkg_no.value + 
        				'&application_date=' + formObj.application_dt.value + 
        				'&rfa_no=' + formObj.rfa_no.value + 
        				'&frm_cmdt_cd=' + formObj.cmdt_cd.value + 
        				'&ca_flg=' + formObj.ca_flg.value +
        				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
        				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
        				'&is_bkg=' + "Y";

					var pgmNo = "&pgmNo=ESM_BKG_0739";
					var url = "ESM_BKG_0739.do?" + param + pgmNo;
					ComOpenPopup(url, 1050, 650, "", "0,0", true);					
        		}
				break;		
			case SEARCH06:
        		if(ComGetObjValue(formObj.ca_flg) == "")
        			formObj.ca_flg.value = 'N';
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&taa_no=" + ComGetObjValue(formObj.taa_no)
    					+ "&ca_flg=" + ComGetObjValue(formObj.ca_flg);
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_1076GS.do", param);
        		formObj.chk_oft.value = ComGetEtcData(sXml,"chk_oft");	
        		formObj.application_dt.value =  ComGetEtcData(sXml,"application_dt");

        		if (formObj.chk_oft.value == "N" ){
        			var param = 
        				'bkg_no=' + formObj.bkg_no.value + 
        				'&application_date=' + formObj.application_dt.value + 
        				'&taa_no=' + formObj.taa_no.value + 
        				'&frm_cmdt_cd=' + formObj.cmdt_cd.value + 
        				'&ca_flg=' + formObj.ca_flg.value +
        				'&frt_term_cd=' + ComGetEtcData(sXml,"frt_term_cd") +
        				'&svc_scp_cd=' + ComGetEtcData(sXml,"svc_scp_cd") +
        				'&is_bkg=' + "Y";
        		
					var pgmNo = "&pgmNo=ESM_BKG_1076";
					var url = "ESM_BKG_1076.do?" + param + pgmNo;
					ComOpenPopup(url, 1050, 650, "", "0,0", true);					
        		}
				break;						
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리(Save) 
     */
    function validateForm(formObj, sAction){
    	var bkgNo = formObj.bkg_no.value;
        switch(sAction) {
    		case COMMAND01:      // Save   
	    		if(ComGetObjValue(formObj.modify_flag) == "N"){
	    			ComShowCodeMessage("BKG00233");
	    			return false;
	    		}
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 시
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}

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

    			//mnl bkg 생성시 10자리, 12자리가 정상bkg_no 
    			if(formObj.mnl_bkg_no_flg.value == "Y" && ComIsNull(formObj.old_bkg_no.value)){
    				var mnlBkgNo = ComGetObjValue(formObj.bkg_no);
    				if(mnlBkgNo.length != 10 && mnlBkgNo.length != 12){
    					if((formObj.bkg_ofc_cd.value.substring(0,3)=="SHA")
    							||(formObj.bkg_ofc_cd.value.substring(0,3)=="DLC")
    							||(formObj.bkg_ofc_cd.value.substring(0,3)=="NBO")
    							||(formObj.bkg_ofc_cd.value.substring(0,3)=="TSN")
    							||(formObj.bkg_ofc_cd.value.substring(0,3)=="TAO")
    							||(formObj.bkg_ofc_cd.value.substring(0,3)=="NKG")){
    						// 한시적으로 허용
    					} else {
	        				ComShowCodeMessage("BKG00255");
	    					ComSetFocus(formObj.bkg_no);
	        				return false;
    					} 					
    				}
    			}  			
    			if(ComGetObjValue(formObj.mnl_bkg_no_flg) != "Y"||ComIsNull(formObj.mnl_bkg_no_flg)){
//    				if(!ComIsNull(formObj.bkg_no) || ComGetObjValue(formObj.old_bkg_no) != bkgNo)	// 조회없이 Booking 번호만 변경시
	    			if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
	    				ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
						ComSetFocus(formObj.bkg_no);
	    				return false;    				
	    			}
				}
    			if(parseFloat(ComGetObjValue(formObj.act_wgt),10) <= 0){	// Weight에 '0' 입력
    				ComShowCodeMessage("BKG00014");
					ComSetFocus(formObj.act_wgt);
    				return false;
    			}
    			var wgtUtCd = comboObjects[4].Code;
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
    				ComSetFocus(formObj.cmdt_cd);
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
					ComSetFocus(formObj.sc_no);
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
		    	if(scNo.substring(0,3) == "DUM0000001" || rfaNo.substring(0,3) == "DUM000001" || taaNo.substring(0,3) == "DUM000001"){
		    		ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
		    		ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
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
    				if(!ComIsNumber(formObj.s_cust_seq)){
    		 			ComShowCodeMessage("BKG00340");
    					formObj.s_cust_seq.focus();
    					return false;
    		 		}
    			}
    			if(ComIsNull(formObj.f_cust_cnt_cd)){		// FWDR 입력값 체크
    				if(!ComIsNull(formObj.f_cust_seq)){
        				ComSetFocus(formObj.f_cust_cnt_cd);	
        				ComShowCodeMessage("BKG00293");	// 국가코드 없이 Customer코드만 있는 경우	
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
    				if(!ComIsNumber(formObj.f_cust_seq)){
    		 			ComShowCodeMessage("BKG00340");
    					formObj.f_cust_seq.focus();
    					return false;
    		 		}			
    			}    		
    			
    			//if(ComIsNull(formObj.s_cust_nm) && ComIsNull(formObj.f_cust_nm))	// Custome Inquiry를 이용하여 SREP 및 Contact Person을 선택하지 않은 경우
    				
    			if(ComIsNull(formObj.c_cust_cnt_cd)){		// CNEE 입력값 체크
    				if(!ComIsNull(formObj.c_cust_seq)){
        				ComShowCodeMessage("BKG00009");	// 국가코드 없이 Customer코드만 있는 경우	
    					ComSetFocus(formObj.c_cust_seq);	
        				return false;    	    					
    				}
    			}else{
    				if(ComChkLen(formObj.c_cust_cnt_cd, 2) != 2){	// 국가코드가 2자리 아닌 경우
    					ComShowCodeMessage("BKG00009");		
						ComSetFocus(formObj.c_cust_cnt_cd);	
        				return false;    	      					
    				}
    				if(!ComIsNull(formObj.c_cust_seq)){	
        				if(!ComIsNumber(formObj.c_cust_seq)){
        		 			ComShowCodeMessage("BKG00340");
        					formObj.c_cust_seq.focus();
        					return false;
        		 		}			    					
    				}
    			}
//    				if(ComIsNull(formObj.c_cust_seq) || ComGetObjValue(formObj.c_cust_seq) == "0"){	// Customer 코드가 없거나 '0' 인 경우
//        				ComShowCodeMessage("BKG00009");		
//        				return false;    	        					
//    				}
//    				if(ComIsNull(formObj.c_cust_nm)){	// Custome Inquiry를 이용하여 SREP 및 Contact Person을 선택하지 않은 경우
//        				ComShowCodeMessage("BKG00337");		
//        				return false;       					
//    				}
    			
    			if(ComIsNull(formObj.s_cust_cnt_cd) && ComIsNull(formObj.f_cust_cnt_cd)){		// SHPR,FWDR 모두 미입력
    				ComShowCodeMessage("BKG01012");		
    				ComSetFocus(formObj.s_cust_cnt_cd);	
    				return false;    	        	    				
    			}
    			
    			// TP/SZ 입력여부 확인 및 동일한 CntrTpSz 입력여부 판단    			
    			if(!chkCntrTpSz()){
    				return false;
    			}
/*    			
//    			// TP/SZ 입력여부 확인
//    			if(sheetObjects[0].FindText("cntr_tpsz_cd","",-1) > 0){
//    				ComShowCodeMessage("BKG01013");		
//    				return false;    				
//    			}
//    			
//    			var dupCntrTp = sheetObjects[0].ColValueDupRows("cntr_tpsz_cd", false, true);
//    			if (dupCntrTp != null && dupCntrTp != "") {	// 동일한 TP/SZ가 두번 이상 입력된 경우
//    				ComShowCodeMessage("BKG00038",sheetObjects[0].CellValue(dupCntrTp.split("|")[0],"cntr_tpsz_cd"));		
//    				return false;    	        	  
//    			}
*/    			
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
    			
    			if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="US"){
    				if(ComGetObjValue(formObj.befUsaCstmsFileCd)==null||ComGetObjValue(formObj.befUsaCstmsFileCd).length<1){
        				ComShowCodeMessage("BKG00283");		// 미주로 가는데  ams 안넣은 경우 선 validation
        				return false; 
    				}   	    				
    			}   
    			
    			if(ComIsNull(formObj.pre_rly_port_cd) && ComIsNull(formObj.pst_rly_port_cd)){
    				if(ComGetObjValue(formObj.bkg_pol_cd) == ComGetObjValue(formObj.bkg_pod_cd)){
        				ComShowCodeMessage("BKG00053");		// PRE/POST 미입력인데 POL,POD가 동일
        				return false;    	    				    					
    				}
    			}
    			
    			if(!checkEgyptDeTerm(ComGetObjValue(formObj.bkg_del_cd))){
					ComSetFocus(formObj.bkg_del_cd);	
    				return false;		// DEL이 'EGALY','EGPSD'인데 DLV Term이 'O'가 아닌경우
    			}    			
    			if(!checkTanzaniaDeTerm(ComGetObjValue(formObj.bkg_pod_cd), ComGetObjValue(formObj.bkg_del_cd), "check")){
					ComSetFocus(formObj.bkg_del_cd);	
    				return false;
    			}  
//    			if(!checkThailandDeTerm(ComGetObjValue(formObj.bkg_pod_cd), ComGetObjValue(formObj.bkg_del_cd), "check")){
//    				ComSetFocus(formObj.dlv_term);	
//    				return false;
//    			} 
    			if(!checkMaltaTerm(ComGetObjValue(formObj.bkg_pol_cd), ComGetObjValue(formObj.bkg_pod_cd))){
    				return false;
    			} 
    			
    			var rcvTerm = ComGetObjValue(formObj.rcv_term_cd);
    			var delTerm = ComGetObjValue(formObj.de_term_cd);
    			
    			// TPSZ는 한가지, MIXED Term 선택시 Vol이 1이하이면 에러
    			// 하지 않음 -> 20100407 임종한 과장 요청
//    			if(sheetObjects[0].RowCount == 1){
//    				if(parseFloat(sheetObjects[0].CellValue(1,"op_cntr_qty")) <= 1){
//        				if(rcvTerm == "M" || delTerm == "M"){
//            				ComShowCodeMessage("BKG00298");		// TPSZ는 한가지, MIXED Term 선택시
//            				return false;    	     					
//        				}    	    					
//    				}			
//    			}    			
    			if (""==rcvTerm || ""==delTerm) {
    				ComShowCodeMessage("BKG02071");  //Please check R/D Term. It is mandatory item
    				return false;      					
    			}
    			
    			if(rcvTerm == "T" || rcvTerm == "I"){
    				if(ComGetObjValue(formObj.bkg_por_cd) != ComGetObjValue(formObj.bkg_pol_cd)){
        				ComShowCodeMessage("BKG00270");		// RCV가 Trackle,Free In이면 POR,POL은 동일
    					ComSetFocus(formObj.bkg_por_cd);	
        				return false;      					
    				}
    			}
    			
    			if(delTerm == "T" || delTerm == "O"){
    				if(ComGetObjValue(formObj.bkg_pod_cd) != ComGetObjValue(formObj.bkg_del_cd)){
        				ComShowCodeMessage("BKG00271");		// DLV가 Trackle,Free In이면 POD,DEL은 동일
    					ComSetFocus(formObj.bkg_pod_cd);	
        				return false;      					
    				}
    			}
    			// 20090812 추가 (류대영수석 요청) - T/S Route 는 없지만 T/VVD,POL,POD 가 입력되어 있으면 direct 구간으로 T/S Route 정보 자동 생성. 
//    			if(!ComIsNull(formObj.bkg_trunk_vvd.value) && !ComIsNull(formObj.bkg_pol_cd.value))
    			//vvd 조건 제외(20091108 류대영)
    			//임시 보류(20091109 조용인 수석님 요청)
//    			if(!ComIsNull(formObj.bkg_pol_cd.value)){
//    				
//    				if(sheetObjects[1].RowCount < 2 && ComGetObjValue(formObj.have_route_flag) == 'N'){
//    					if(sheetObjects[1].RowCount < 1){
//    						sheetObjects[1].DataInsert(-1);
//    					}
//    					sheetObjects[1].CellValue(1, "vsl_pre_pst_cd") = "T";
//    					sheetObjects[1].CellValue(1, "vsl_seq") = "0";
//    					sheetObjects[1].CellValue(1, "pol_cd") = ComGetObjValue(formObj.bkg_pol_cd);
//    					sheetObjects[1].CellValue(1, "pol_yd_cd") = ComGetObjValue(formObj.bkg_pol_yd_cd);
//    					sheetObjects[1].CellValue(1, "pod_cd") = ComGetObjValue(formObj.bkg_pod_cd);
//    					sheetObjects[1].CellValue(1, "pod_yd_cd") = ComGetObjValue(formObj.bkg_pod_yd_cd);
//    					sheetObjects[1].CellValue(1, "bkg_vvd_cd") = ComGetObjValue(formObj.bkg_trunk_vvd);
//    					sheetObjects[1].CellValue(1, "pol_clpt_ind_seq") = "1";
//    					sheetObjects[1].CellValue(1, "pod_clpt_ind_seq") = "1";    	
//
//    		 	    	manageHaveRouteFlag("N");
//    				}
//    			}    			
    			// T.VVD와 T/S Route의 T.VVD와 다른경우
    			if(sheetObjects[1].RowCount > 0){ // t/s route 입력된 경우에만 확인
	    			if(!ComIsNull(formObj.bkg_trunk_vvd.value) && formObj.bkg_trunk_vvd.value != sheetObjects[1].CellValue(sheetObjects[1].FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd")){
	    				ComShowCodeMessage("BKG00022", ComGetObjValue(formObj.bkg_trunk_vvd));	
						ComSetFocus(formObj.bkg_trunk_vvd);		
	    				return false;      		    				
	    			}    			
    			}
    			for(i = 1 ; i < sheetObjects[1].Rows ; i++){
    				if(!ComIsNull(sheetObjects[1].CellValue(i, "bkg_vvd_cd")) && ComChkLen(sheetObjects[1].CellValue(i, "bkg_vvd_cd"), 9) != 2){
        				ComShowCodeMessage("BKG00051", sheetObjects[1].CellValue(i, "bkg_vvd_cd"));		//VVD 9자리 체크	
						ComSetFocus(formObj.bkg_trunk_vvd);
        				return false;       					
    				}
    			}    			

    			// VVD 미입력 이거나 Pseudo VVD 인데 MT DOOR ARRIVAL DATE,Sailing DUE DATE가 없는경우
    			if(ComIsNull(formObj.bkg_trunk_vvd)){
    				//ca_new_creation시에는 trunk vvd가 필수
        			if(formObj.ca_new_creation_flag == "Y"){
    					ComShowCodeMessage("BKG00051");
    					return false;        				
        			}
    				//partial case 일때는 vvd가 있어야함
    				if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y"){
    					ComShowCodeMessage("BKG00051");
    					return false;
    				}
    				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
    					ComShowCodeMessage("BKG00017");	
						ComSetFocus(formObj.lodg_due_dt);
        				return false;
    				}
    			}else{
    				if(ComChkLen(formObj.bkg_trunk_vvd, 9) != 2){
        				ComShowCodeMessage("BKG00051", ComGetObjValue(formObj.bkg_trunk_vvd));		//VVD 9자리 체크	
						ComSetFocus(formObj.bkg_trunk_vvd);
        				return false;      					
    				}
    				var pseudoVvd = ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
    				if(pseudoVvd == "HJXX" || pseudoVvd == "HJYY" || pseudoVvd == "HJZZ"){
        				if(ComIsNull(formObj.mty_dor_arr_dt) && ComIsNull(formObj.lodg_due_dt)){
        					if(formObj.psdo_bkg_flg.value == "Y"){
        						//PSEUDO BKG 일 때 현재 날짜 + 15
        						ComSetObjValue(formObj.lodg_due_dt, ComGetDateAdd(ComGetNowInfo(),"D", +15))
        					} else {
	            				ComShowCodeMessage("BKG00017");
	    						ComSetFocus(formObj.mty_dor_arr_dt);
	            				return false;
        					}
        				}    					
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
    			
    			//2011.06.09 Booking Creation 화면에서 SH 의 Cnt나 Seq가 변경된 경우 저장시 팝업화면을 보여줘서 L.REP 변경되게 처리  - chkCustomer(formObj)으로 분리
    			chkCustomer(formObj);
/*
    			// 20091130 Customer Inquiry Popup 조건 변경 (L.OFC,L.REP 둘다 미존재시 팝업)
    			if(ComIsNull(formObj.ob_sls_ofc_cd) || ComIsNull(formObj.ob_srep_cd)){
//    				ComShowCodeMessage("BKG00337");
    				if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
    					comBkgCallPop0652('callBack0652','F', ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "");
    				} else {
    					comBkgCallPop0652('callBack0652','S', ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "");
    				}
    				
    				if(ComIsNull(formObj.s_cust_nm)){
        				return false;
    				}       					
				}
*/    				   					
    			if(ComChkLen(formObj.ob_srep_cd, 5) != 2){
    				ComShowCodeMessage("BKG08317");		// L.Rep 5자리 미만으로 입력
    				return false;    				
    			}
//=============================================== vol detail 계산 시작    			
    			// CntrTpSz가 변경되면 QtyDtl에 반영한다.
    			//checkAutoCaluate() : 자동 계산 여부 확인
    			//resetQtyDetail() : 자동 계산    			
    			//carge_detail_pop = 'Y' : pop-up이 실행된 이후 다시 save임
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
    							sumSingle = parseFloat(sumSingle.toFixed(2));
    						}
    						if(sheetObjects[3].CellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
    							sumDouble = sumDouble + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
    							sumDouble = parseFloat(sumDouble.toFixed(2));
    						}
    						if(sheetObjects[3].CellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
    							sumTriple = sumTriple + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
    							sumTriple = parseFloat(sumTriple.toFixed(2));
    						}
    						if(sheetObjects[3].CellValue(j, "mer_hngr_flg") == 1){
    							sumMer = sumMer + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
    							sumMer = parseFloat(sumMer.toFixed(2));
    						}				
    						
    						if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
    							if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[3].CellValue(j, "eq_subst_cntr_tpsz_cd")){
    								eqSubVol = eqSubVol + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
    								eqSubVol = parseFloat(eqSubVol.toFixed(2));
    							}    							
    						}	
    						sumEqDtlVol = sumEqDtlVol + BkgParseFloat(sheetObjects[3].CellValue(j, "op_cntr_qty"));
    						sumEqDtlVol = parseFloat(sumEqDtlVol.toFixed(2));
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
//=============================================== vol detail 계산 시작    			
    			// Partial VVD 변경 PopUp 호출
				// 임시 skip
				formObj.partial_vvd_assign_flg.value = "N";
    			if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
    				comBkgCallPop1024("callBack1024", bkgNo);
    				
    				if(ComGetObjValue(formObj.partial_vvd_assign_flg) == "Y" && ComGetObjValue(formObj.partial_vvd_opened_flg) != "Y" && ComGetObjValue(formObj.route_modify_flag) == 'Y'){
    					return false;    					
    				}
    			}
    			// 2014.08.26 [CHM-201431517]  
//    			if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
//    				if( ComGetObjValue(formObj.cmdt_cd)=="000004" || ComGetObjValue(formObj.cmdt_cd)=="000010" || ComGetObjValue(formObj.cmdt_cd)=="000017"
//    					|| ComGetObjValue(formObj.rep_cmdt_cd)=="2800" || ComGetObjValue(formObj.rep_cmdt_cd)=="2900" || ComGetObjValue(formObj.rep_cmdt_cd)=="3800"){
//			    		if(ComIsNull(formObj.stwg_cd.value)){ 
//			    			var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+COMMAND08+"&ob_srep_cd="+formObj.ob_srep_cd.value);
//			    			var tmpObSlsOfcCd = ComGetEtcData(sXml,"prnt_ofc_cd");
//			    			if( tmpObSlsOfcCd == "SHAAS" ){ 
//				    			if(ComShowCodeConfirm("BKG08326")){
//				    				formObj.prct_flg.checked = true;
//					    			//ComSetObjValue(formObj.stwg_cd, "PC");
//					    			//ComSetObjValue(formObj.stwg_flg, "Y");
//					    			//changeObjectColor(formObj.stwg_cd.value, "Y", "btn_t1Stowage", "blue", "btn2");
//					    		}
//			    			}
//        				}
//    				}
//    			}

    			if(agmtActCustModifyFlag){
    				if((ComGetObjValue(formObj.agmt_act_cnt_cd) == "" && ComGetObjValue(formObj.agmt_act_cust_seq) != "")
    						||(ComGetObjValue(formObj.agmt_act_cnt_cd) != "" && ComGetObjValue(formObj.agmt_act_cust_seq) == "")){
    					ComShowCodeMessage("BKG00651","A/Customer "+ComGetObjValue(formObj.agmt_act_cnt_cd)+ComGetObjValue(formObj.agmt_act_cust_seq));
    					return false;
    				}
    			}
    			
    			// 여기서부터는 그냥 Message
    			if(tpSzA){
    				ComShowCodeMessage("BKG00304");		// A2,A4,A5가 존재하는 경우   	        	     				
    			}    	
    			if(delTerm == "S"){
    			//2011.11.24 하단의 if 조건 제거 kbj
    				//if(rcvTerm == "Y" || rcvTerm == "D" || rcvTerm == "H"){
    							// RCV이 'Y','D','H' 이면서 DLV이 'S' 인 경우
    				//}
    				/* 박유숙 부장님 요청 제거 2017.4.27 */
//					if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)!="TH" && ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)!="TH" ){
						ComShowCodeMessage("BKG00302"); // Thailand Console 일 때는 메시지가 따로 있음
//					}
    			}
    			if(formObj.rc_flg.checked){
    				if(rcvTerm != "Y" && delTerm != "Y"){
    					ComShowCodeMessage("BKG00303");		// Reefer 선택시 RCV,DLV 중 하나는 'Y'
    				}
    			}

    			// 2012.04.24 BKG/DOC System 보완 요청 START
    			if (!checkBkgIssStatus(formObj)) {
    				return false;
    				break;
    			}
    			// 2012.04.24 BKG/DOC System 보완 요청 END
    			// 2013.06.26 email address 형식 validation
    			var emlArr = null;
    			if(ComGetObjValue(formObj.bkg_cntc_pson_eml) != ""){
    				emlArr = ComGetObjValue(formObj.bkg_cntc_pson_eml).split(";");
    				for(var i = 0; i < emlArr.length; i++){
    					if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
	    					ComShowCodeMessage("BKG40021" , emlArr[i]);
	    					ComSetFocus(formObj.bkg_cntc_pson_eml);
	    					return false;
    					}
    				}
	            }
    			if(ComGetObjValue(formObj.si_cntc_pson_eml) != ""){
    				emlArr = ComGetObjValue(formObj.si_cntc_pson_eml).split(";");
    				for(var i = 0; i < emlArr.length; i++){
    					if(emlArr[i].trim().length > 1 && !ComIsEmailAddr(emlArr[i])){
	    					ComShowCodeMessage("BKG40021" , emlArr[i]);
	    					ComSetFocus(formObj.si_cntc_pson_eml);
	    					return false;
    					}
    				}
	            }
    			
    			// Manual Full Return CY 인 경우 보완 
    			if(ComGetObjValue(formObj.full_rtn_yd_cd) == ""){
	    			ComSetObjValue(formObj.route_modify_flag, "Y");
	    	 		ComSetObjValue(formObj.modify_flag, "Y");
	    	     	manageHaveRouteFlag("N");
    			}
    			
    			// DG/RF/AWK Cargo, Route Detail 이 수정되거나 신규생성 일 때, 앞배와 뒷배 간격이 10일 넘으면 메시지
    			if((route_detail_modify_flag == "Y" || ComGetObjValue(formObj.bkg_no)=="")
    				&& ( ComGetObjValue(formObj.dcgo_flg)=="Y" || ComGetObjValue(formObj.rc_flg)=="Y" || ComGetObjValue(formObj.awk_cgo_flg)=="Y") ){
					var befEta = "";
					var befVvd = "";
					for (var i=0; i<=sheetObjects[1].RowCount; i++) {
						if(befEta!="" && sheetObjects[1].CellValue(i,"etd_day")!=""){
							if(ComGetDaysBetween(befEta, sheetObjects[1].CellValue(i,"etd_day")) > 10){
								ComShowCodeMessage('BKG08339');
							}
						}
						befEta = sheetObjects[1].CellValue(i,"eta_day");
						befVvd = sheetObjects[1].CellValue(i,"bkg_vvd_cd");
					}
	        	}
    			
    			// [CHM-201534418] SYRIA SANCTION관련 ALERT POPUP 요청
    			if(ComGetObjValue(formObj.bkg_del_cd).substring(0,2)=="SY" || ComGetObjValue(formObj.bkg_pod_cd).substring(0,2)=="SY"
    				|| (ComGetObjValue(formObj.f_cust_cnt_cd)=="SY" && !ComIsNull(formObj.f_cust_seq)) 
    				|| (ComGetObjValue(formObj.c_cust_cnt_cd)=="SY" && !ComIsNull(formObj.c_cust_seq)) ){
    				if(ComGetObjValue(formObj.rep_cmdt_cd)=='2700' || ComGetObjValue(formObj.rep_cmdt_cd)=='2800' || ComGetObjValue(formObj.rep_cmdt_cd)=='2900'
    					|| ComGetObjValue(formObj.rep_cmdt_cd)=='3300' || ComGetObjValue(formObj.rep_cmdt_cd)=='3800' ){
	    				if(ComShowCodeConfirm("BKG08345")){
	                		window.open("https://compliance.hanjin.com/Compliance/indexTop.jsp");
	    				}
    				}
				}
    			
    			return true;
				break;
				
        	case COMMAND02:      // Copy        		
//    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking Copy 시
//    				ComShowCodeMessage("BKG00090");
//    				return false;
//    			}
//				if(ComGetObjValue(formObj.bdr_flg) == "Y"){		// BDR 시
//					ComShowCodeMessage("BKG00091");
//					return false;
//				}        	
    			return true;        		
        		break;
        		
        	case MODIFY04:      // Waiting -> Firm        
    			if(ComIsNull(formObj.old_bkg_no)||ComIsNull(formObj.bkg_no)){
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    	    				
    			}        		
    			if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}
    			return true;        		
        		break;
        		
        	case MODIFY05:      // Waiting -> Firm        
    			if(ComIsNull(formObj.old_bkg_no)||ComIsNull(formObj.bkg_no)){
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    	    				
    			}        		
    			if(formObj.old_bkg_no.value != bkgNo){	// 조회없이 Booking 번호만 변경시
    				ComShowCodeMessage("BKG00835");
					ComSetFocus(formObj.bkg_no);
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
    				return false;
    			}
    			return true;        		
        		break;
        		
        	case MODIFY06:      // cancel        
    			if(ComIsNull(formObj.old_bkg_no)){
    				ComShowCodeMessage("BKG00255");
    				return false;    	    				
    			}        		
    			if(formObj.old_bkg_no.value != bkgNo){	// 조회없이 Booking 번호만 변경시
    				ComShowCodeMessage("BKG00048");
    				return false;    				
    			}        		
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		
    				ComShowCodeMessage("BKG00005");
//    				return false;
    			}        		
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

	//0079에서 실행
    function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
			if(ComShowCodeConfirm("BKG00350")){
				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
                window.event.srcElement.setAttribute("name","btn_t1Save");
                processButtonClick();  
			}
		}	
    }
    
    // 0079에서 실행
    function searchData(bkgNo){
    	if(ComIsNull(bkgNo)) return;
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no,bkgNo);
		doActionIBSheet(sheetObjects[2], formObj, SEARCH);        
    }
    
     /**
      * Tab 클릭시 이벤트 관련
      * 선택한 탭의 요소가 활성화 된다.
      */
     function tab1_OnChange(tabObj , nItem){
         var objs = document.all.item("tabLayer");
         
     	 objs[nItem].style.display = "Inline";
     	 objs[beforetab].style.display = "none";
     	
     	 //--------------- 요기가 중요 ------------------------------//
     	 objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
     	 //--------------------------------------------------------//
     	 beforetab= nItem;
     }

	 // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){		
		 var formObj = document.form;
		 if(ErrMsg == ""){
			 setTotalVol(sheetObj);
			 disabledFH(sheetObj, formObj);
		 }
		 for(var i = 1 ; i < sheetObjects[0].Rows ; i++){
			 sheetObjects[0].CellValue(i, "cntr_tpsz_cd_old") = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");   
		 }
			
		 sheetObj.ColBackColor("cntr_tpsz_cd") = sheetObj.RgbColor(204, 255, 253);
		 sheetObj.ColBackColor("op_cntr_qty") = sheetObj.RgbColor(204, 255, 253);
	}

	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function t1sheet1_OnAfterEdit(sheetObj, Row, Col){
		var formObj = document.form;
		setTotalVol(sheetObj);

		if(sheetObj.CellValue(Row, "ibflag") != "R"){
			ComSetObjValue(formObj.modify_flag, "Y");
			ComSetObjValue(formObj.carge_detail_pop, "N");// cargo detail이 수정되었음	
			ComSetObjValue(formObj.qty_modify_flag, "Y");
		}
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"||sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			manageHaveRouteFlag("N");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
		}
	}	
	
	function t1sheet1_OnBeforeEdit(sheetObj, Row, Col, Value){		
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			befQty = sheetObj.CellValue(Row, Col); 
		}
	}
	
	function t1sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		if(KeyCode==9){
			if(Row==sheetObj.Rows-1){
				if(sheetObj.ColSaveName(Col) == "soc_qty"){
					ComSetFocus(document.form.act_wgt);
				}			
			}
		}
	}
	
	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
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
//		if(tpVol < eqSub+soc){
//			ComShowCodeMessage("BKG02001");
//			sheetObj.CellValue2(Row, Col) = "";
//			return;
//		}
		
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
		if(!dupChkCntrTpSz()){
			//여기는 재check를 위해 CellValue를 사용하였음
			sheetObj.CellValue(Row, Col) = "";	
			return false;
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "eq_subst_cntr_tpsz_cd" || sheetObj.ColSaveName(Col) == "op_cntr_qty" || sheetObj.ColSaveName(Col) == "eq_subst_cgo_qty" || sheetObj.ColSaveName(Col) == "soc_qty"){
			if(sheetObj.CellValue(Row, Col) != sheetObj.CellSearchValue(Row, Col)){
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
			}else{
				ComSetObjValue(formObj.cgo_dtl_auto_flg, "Y");		// Cargo Detail 화면을 Save시 띄우지 않는다.
			}			
		}
	}		
	
	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	function t1sheet3_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg != ""){
			ComBkgSaveCompleted();
		}
	}	

	// RD Term 변경시
	function rcv_term_cd_OnChange(Code, Text){
		var formObj = document.form;
		
		if(ComGetObjValue(formObj.rcv_term_cd) != "D"){
			formObj.mty_dor_arr_dt.disabled = true;
			ComSetObjValue(formObj.mty_dor_arr_dt, "");
		}else{
			formObj.mty_dor_arr_dt.disabled = false;
		}		
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
		
		ComSetObjValue(formObj.bkg_por_yd_cd, "");
		
		if(ComGetObjValue(formObj.rcv_term_cd) == "M"){
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.	
			if(ComGetObjValue(formObj.rcv_term_cd_old) != "M" && !ComIsEmpty(ComGetObjValue(formObj.rcv_term_cd_old))
					&& ComGetObjValue(formObj.bkg_pod_cd)!="TZDAR" && ComGetObjValue(formObj.bkg_del_cd)!="TZDAR") {// TZDAR 는 다른 메시지 나옴
				ComShowCodeMessage("BKG02200");
			}
		}
		ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.	
	}
	
	// RD Term 변경시
	function de_term_cd_OnChange(Code, Text){
		var formObj = document.form;
		
		ComSetObjValue(formObj.route_modify_flag, "Y");
		ComSetObjValue(formObj.modify_flag, "Y");
	    manageHaveRouteFlag("N");
		
		ComSetObjValue(formObj.bkg_del_yd_cd, "");
		
		if(ComGetObjValue(formObj.de_term_cd) == "M"){
			ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.	
			if(ComGetObjValue(formObj.de_term_cd_old) != "M" && !ComIsEmpty(ComGetObjValue(formObj.de_term_cd_old))
					&& ComGetObjValue(formObj.bkg_pod_cd)!="TZDAR" && ComGetObjValue(formObj.bkg_del_cd)!="TZDAR") {// TZDAR 는 다른 메시지 나옴
				ComShowCodeMessage("BKG02200");	
			}		
		}		
		ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.	
	}
	
	// Filer USA 변경시
	function usa_cstms_file_cd_OnChange(Code, Text){
		var formObj = document.form;
		if(Text == "1"){
			var befUsaCstmsFileCd = ComGetObjValue(formObj.befUsaCstmsFileCd);
			if(befUsaCstmsFileCd == "2" || befUsaCstmsFileCd == "3"){
				ComShowCodeMessage("BKG00286");
			}
		}
		ComSetObjValue(formObj.modify_flag, "Y");
		ComSetObjValue(formObj.befUsaCstmsFileCd, Text);
	}	
	
	function usa_cstms_file_cd_OnKeyUp(comboObj,keycode,shift){
		if(keycode == 9) ComSetFocus(document.getElementById("s_cust_cnt_cd"));
	}

	// Filer CA 변경시
	function cnd_cstms_file_cd_OnChange(Code, Text){
		var formObj = document.form;
		ComSetObjValue(formObj.modify_flag, "Y");
	}
	
	function cnd_cstms_file_cd_OnKeyDown(comboObj,keycode,shift){
		if(keycode == 9) ComSetFocus(document.getElementById("c_cust_seq"));
	}
	
	// Weight 단위 변경시 (단위계산 삭제 - 20080820)
	function wgt_ut_cd_OnChange(Code, Text){	
		var formObj = document.form;
		ComSetObjValue(formObj.modify_flag, "Y");
	}	
 
	// Rail Bulk 변경시
	function rail_blk_cd_OnChange(Code, Text){
		var formObj = document.form;		
		ComSetObjValue(formObj.modify_flag, "Y");		
	}
	
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
			}
		}			
		oldPodYdCd = formObj.bkg_pod_cd.value + formObj.bkg_pod_yd_cd.value;
	}
    
	 /**
	 * Key 입력일때 
	 */
    function bkg007901_keypress(){
		var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if(srcName == "bkg_no"){
    		if(event.keyCode == 13){
	    		if(!ComIsNull(document.form.bkg_no.value)){
	    			formObj.elements[srcName].value = srcValue.toUpperCase();
	    			ComKeyEnter();
	    			return;
		    	} else {
					ComShowCodeMessage("BKG00255");
		    	}	    
    		}
    	} 
    	if(srcName == "bl_no"){
    		if(event.keyCode == 13){
	    		if(!ComIsNull(document.form.bl_no.value)){
	    			formObj.elements[srcName].value = srcValue.toUpperCase();
	    			ComKeyEnter();
	    			return;
		    	} else {
					ComShowCodeMessage("BKG00068", "B/L No");
		    	}
    		}
    	} 
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	    		ComKeyOnlyNumber(event.srcElement);
	        	break;
	    	case "ym":
	    	case "yw":
	    	case "jumin":
	    	case "saupja":	//숫자 + "-"
	    		ComKeyOnlyNumber(event.srcElement, "-"); break;
	    	case "hms":
	    	case "hm":		//숫자 + ":"
	    		ComKeyOnlyNumber(event.srcElement, ":"); break;
	        case "int":		//숫자
	            ComKeyOnlyNumber(event.srcElement); break;
	        case "float":	//숫자+"."	            
	            ComKeyOnlyNumber(event.srcElement, "."); 
	            break;	    
	    	case "engup":
		        //영문대문자
	    		ComKeyOnlyAlphabet('upper');
		        break;
	        case "engupnum":
	            //숫자+"영문대분자"입력하기
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        default:
	    }
	}      

	 /**
	 * Key 입력일때 
	 */
    function bkg007901_keyup(){
    	var srcName = window.event.srcElement.getAttribute("name");
    	var formObj = document.form;
    	
		if(event.keyCode == 9){
			if(srcName == "s_cust_cnt_cd"){
				ComSetFocus(document.getElementById("rcv_term_cd"));
			} else if(srcName == "act_wgt"){
				goFocusQty();			
			} else if(srcName == "scac_cd"){
				ComSetFocus(document.getElementById("usa_cstms_file_cd"));
			}
		}
	}              

	 /**
	 * 마우스 아웃일때 
	 */
    function bkg007901_deactivate() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");

    	if(srcName == "bkg_no"){
    		// bkg no가 지워졌거나 바뀐 경우
			if((!ComIsNull(formObj.old_bkg_no.value)&&ComIsNull(srcValue))// 있었는데 지워진 경우 
				||(!ComIsNull(formObj.old_bkg_no.value)&&ComGetObjValue(formObj.old_bkg_no) != srcValue)//있었는데 바뀐 경우
				){
        		ComSetObjValue(formObj.old_bkg_no,"");
        		ComSetObjValue(formObj.bl_no,     "");
        		ComSetObjValue(formObj.old_bl_no, "");
        		ComSetObjValue(formObj.pctl_no,   "");
        		ComSetObjValue(formObj.si_flg,    "");
        		document.getElementById("split_flg").style.display = "none";
        		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
        		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
        		ComSetObjValue(formObj.route_modify_flag,"Y");
        		ComSetObjValue(formObj.modify_flag,"Y");
     	    	manageHaveRouteFlag("N");
     	    	ComSetObjValue(formObj.tvvd_modify_flg, "N");
    		} 
			formObj.elements[srcName].value = srcValue.toUpperCase();
    	} else if(srcName == "bl_no"){
    		// bkg no가 지워졌거나 바뀐 경우
			if((!ComIsNull(formObj.old_bl_no.value)&&ComIsNull(srcValue))// 있었는데 지워진 경우 
				||(!ComIsNull(formObj.old_bl_no.value)&&ComGetObjValue(formObj.old_bl_no) != srcValue)//있었는데 바뀐 경우
				){
				ComSetObjValue(formObj.bkg_no,    "");
        		ComSetObjValue(formObj.old_bkg_no,"");
        		ComSetObjValue(formObj.old_bl_no, "");
        		ComSetObjValue(formObj.pctl_no,   "");
        		ComSetObjValue(formObj.si_flg,    "");
        		document.getElementById("split_flg").style.display = "none";
        		ComSetObjValue(formObj.partial_vvd_opened_flg, "N");
        		ComSetObjValue(formObj.partial_vvd_assign_flg, "N");
        		ComSetObjValue(formObj.route_modify_flag,"Y");
        		ComSetObjValue(formObj.modify_flag,"Y");
     	    	manageHaveRouteFlag("N");
     	    	ComSetObjValue(formObj.tvvd_modify_flg, "N");
    		} 
			formObj.elements[srcName].value = srcValue.toUpperCase();
    	}else if(srcName == "s_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");		
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
			}
    	}else if(srcName == "s_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.s_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.s_cust_cnt_cd))){
					ComSetObjValue(formObj.s_cust_nm,"");
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.s_cust_seq,ComLpad(srcValue,6,"0"));
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
    	}else if(srcName == "f_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
					ComSetObjValue(formObj.f_cust_nm,"");
				}
			}
    	}else if(srcName == "f_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){
					ComSetObjValue(formObj.f_cust_nm,"");
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.f_cust_seq,ComLpad(srcValue,6,"0"));
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
		    		if(ComIsNull(formObj.s_cust_nm)){
			    		ComSetObjValue(formObj.s_cust_cnt_cd, ComGetObjValue(formObj.f_cust_cnt_cd));
			    		ComSetObjValue(formObj.s_cust_seq,    ComGetObjValue(formObj.f_cust_seq));
			    		ComSetObjValue(formObj.s_cust_nm,     ComGetObjValue(formObj.f_cust_nm));	    			
		    		}
				}
			}
    	}else if(srcName == "c_cust_cnt_cd"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.f_cust_cnt_cd_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");	
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
			}
    	}else if(srcName == "c_cust_seq"){
			if (ComIsNull(srcValue)||ComGetObjValue(formObj.c_cust_seq_old) != srcValue){
				ComSetObjValue(formObj.customer_modify_flag, "Y");
				ComSetObjValue(formObj.modify_flag, "Y");	
				if(ComIsNull(srcValue)&&ComIsNull(ComGetObjValue(formObj.c_cust_cnt_cd))){
					ComSetObjValue(formObj.c_cust_nm,"");
				}
				if(!ComIsNull(srcValue)){
					ComSetObjValue(formObj.c_cust_seq,ComLpad(srcValue,6,"0"));
					// 20091131 추가
					if(ComChkLen(formObj.c_cust_cnt_cd, 2) == "2"){
						if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
							searchCustNm(formObj, ComGetObjValue(formObj.c_cust_cnt_cd), ComGetObjValue(formObj.c_cust_seq), "C");
						}
					}
					// 20100113 추가
					if(ComGetObjValue(formObj.c_cust_exist_flg) == "Y"){
						if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) 
							|| ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
							if(ComShowCodeConfirm("BKG00343")){
								ComSetObjValue(formObj.c_cust_subst_flg, "Y");
							}else{
								ComSetObjValue(formObj.c_cust_subst_flg, "N");
							}
						}
					}
				}
			}		
    	}else if(srcName == "cmdt_cd"){
			if(ComGetObjValue(formObj.cmdt_cd_old) != srcValue){
	    		if(!ComIsNull(srcValue)){
	    			ComSetObjValue(formObj.cmdt_cd, ComLpad(srcValue,6,"0"));
		    		checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
					validatePrecaution(formObj);     
		    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
		    		ComSetObjValue(formObj.modify_flag,"Y");  
	    		} else {
	    			ComSetObjValue(formObj.cmdt_desc,"");
	    			ComSetObjValue(formObj.rep_cmdt_cd,"");
    			}    			
	    		ComSetObjValue(formObj.cmdt_cd_old,ComGetObjValue(formObj.cmdt_cd));

	    		goFocusQty();
	    		ComSetObjValue(formObj.route_modify_flag, "Y"); 
				manageHaveRouteFlag("N");
    		}
    	}else if(srcName == "mty_dor_arr_dt"){
	    	ComAddSeparator(event.srcElement);
    		if(ComGetObjValue(formObj.mty_dor_arr_dt_old) != ComGetObjValue(formObj.mty_dor_arr_dt)){
    			ComSetObjValue(formObj.modify_flag, "Y");
     	    	formObj.mty_dor_arr_dt_old.value = srcValue;
    		}       
    	}else if(srcName == "lodg_due_dt"){
	    	ComAddSeparator(event.srcElement);
    		if(ComGetObjValue(formObj.lodg_due_dt_old) != ComGetObjValue(formObj.lodg_due_dt)){
    			ComSetObjValue(formObj.route_modify_flag, "Y");
    			ComSetObjValue(formObj.modify_flag, "Y");
     	    	manageHaveRouteFlag("N");
     	    	formObj.lodg_due_dt_old.value = srcValue;
    		}
    	}else if(srcName == "de_due_dt"){
    		ComAddSeparator(event.srcElement);
			if(ComGetObjValue(formObj.de_due_dt_old) != ComGetObjValue(formObj.de_due_dt)){
				ComSetObjValue(formObj.modify_flag, "Y");
     	    	formObj.de_due_dt_old.value = srcValue;
			}
    		if(srcValue.length > 0 && ComChkPeriod(formObj.lodg_due_dt.value, srcValue) < 1){
    			ComShowCodeMessage("BKG00176");
    			ComSetObjValue(formObj.de_due_dt, "");
    			ComSetFocus(formObj.de_due_dt);
    		}
    	}else if(srcName == "mty_pkup_dt"){
    		if(ComGetObjValue(formObj.mty_pkup_dt_old) != ComGetObjValue(formObj.mty_pkup_dt)){
				//최초 생성 이후에 m_pu, f_rt, mt_pkup_dt 적용 없음(20091217 신은영차장님 요청)
				//원래대로 적용함(20100120 임종한 과장 확인)
				ComAddSeparator(event.srcElement);
				ComSetObjValue(formObj.route_modify_flag, "Y");
    			ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
    		}
    	}else if(srcName == "act_wgt"){
    		var actWgt = formObj.act_wgt.value.replace(",", "");
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
			ComSetObjValue(formObj.aloc_chk_flg, "Y");	  
    	}else if(srcName == "agmt_act_cnt_cd"){
			ComSetObjValue(formObj.customer_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
			agmtActCustModifyFlag = true;
    	}else if(srcName == "agmt_act_cust_seq"){
			ComSetObjValue(formObj.customer_modify_flag, "Y");
			ComSetObjValue(formObj.modify_flag, "Y");
			agmtActCustModifyFlag = true;
    	}
    }	
    
	 /**
	 * 마우스 IN일때 
	 */
	function bkg007901_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
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
	 * Click 일때 
	 */    
	function bkg007901_click(){
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");

    	if(srcName == "dcgo_flg"||srcName == "rc_flg"||srcName == "awk_cgo_flg"||srcName == "bb_cgo_flg"){
    		ComSetObjValue(formObj.modify_flag,      "Y");
			ComSetObjValue(formObj.carge_detail_pop, "N");// cargo detail이 수정되었음		    		
//    		ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
    	}else if(srcName == "prct_flg"){
    		if(formObj.prct_flg.checked){
    			ComShowCodeMessage("BKG00256");
	    		//if(ComIsNull(formObj.stwg_cd.value)){ 
	    			//ComSetObjValue(formObj.stwg_cd, "PC");
	    			//ComSetObjValue(formObj.stwg_flg, "Y");
	    		//}
    		}else{
    			// BKG00256
    			validatePrecaution(formObj);
    			validateUncheck(formObj, srcName);
    			if(ComGetObjValue(formObj.validPrecaution) != "P"){
    				ComSetObjValue(formObj.modify_flag, "Y");
    			}    			    	
    		}      		
    	}else if(srcName == "si_flg"){
    		if(ComIsNull(formObj.xter_si_cd.value)){
    			formObj.xter_si_cd.value = "OFF";
    		}
    		ComSetObjValue(formObj.modify_flag, "Y");    	
	 	}else if(srcName == "fd_grd_flg" || srcName == "bkg_cgo_tp_cd"
    			||srcName == "edi_hld_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    		
    		if(srcName == "bkg_cgo_tp_cd"){
    			if(!formObj.bkg_cgo_tp_cd.checked) {
    				ComShowCodeMessage("BKG08311");
    				//alert("Please don't deselect this check box in case of the revenue empty");
    			} 
    		}
    	}else if(srcName == "spcl_hide_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    		if(formObj.spcl_hide_flg.checked){
	    		if(ComIsNull(formObj.stwg_cd.value)){ 
	    			ComSetObjValue(formObj.stwg_cd, "ODHD");
	    			ComSetObjValue(formObj.stwg_flg, "Y");
	    		}
	    		ComShowCodeMessage("BKG08351");
    		}else{
    			if(formObj.stwg_cd.value == "ODHD"){
	    			formObj.stwg_cd.value = "";
	    			formObj.stwg_rmk.value = "";
	    			ComSetObjValue(formObj.stwg_flg, "N");
    			}
    			validateUncheck(formObj, srcName);
    		}
    	}else if(srcName == "spcl_hide_lnr_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    	}else if(srcName == "chk_crr_soc_flg"){
    		if(formObj.chk_crr_soc_flg.checked){
    			ComSetObjValue(formObj.crr_soc_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.crr_soc_flg,"N");
    		}
    		ComSetObjValue(formObj.modify_flag, "Y");
    	}else if(srcName == "chk_veh_cmdt_flg"){
    		if(formObj.chk_veh_cmdt_flg.checked){
    			ComSetObjValue(formObj.veh_cmdt_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.veh_cmdt_flg,"N");
    		}
    		ComSetObjValue(formObj.modify_flag, "Y");
    	}else if(srcName == "chk_non_dg_chem_flg"){
    		if(formObj.chk_non_dg_chem_flg.checked){
    			ComSetObjValue(formObj.non_dg_chem_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.non_dg_chem_flg,"N");
    		}
    		ComSetObjValue(formObj.modify_flag, "Y");	
    	}else if(srcName == "mnl_bkg_no_flg"){
    		ComSetObjValue(formObj.modify_flag, "Y");
    		if(ComIsNull(formObj.mnl_bkg_no_flg.value)||formObj.mnl_bkg_no_flg.value=="N"){
    			formObj.mnl_bkg_no_flg.value = "Y";
    		} else {
    			formObj.mnl_bkg_no_flg.value = "N";
    		}
    	}
    	changeObjectColor(formObj.stwg_flg.value, "Y", "btn_t1Stowage", "blue", "btn2");
	}

	function form_onChange(evt,el) {
	  	var formObj = document.form;
	  	var xml = "";
	  	var srcName;
	  	var srcValue;
		var srcObj;
	  	if (el) {
	  		srcObj = el;
	  		srcName = el.getAttribute("name");
	  		srcValue = el.getAttribute("value");
	  	} else {
	  		srcObj = window.event.srcElement;
	  		srcName = srcObj.getAttribute("name");
	  		srcValue = srcObj.getAttribute("value");
	  	}
		ComSetObjValue(formObj.modify_flag, "Y");
	 	if(srcName == "rfa_no"){
	 		if(srcValue == "DUM"){
	 			ComSetObjValue(formObj.rfa_no,"DUM0000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
	 		}else{
	 			if(srcValue.length>=10){
         			// validateRfaAvailable() 호출
         			formObj.f_cmd.value = SEARCHLIST12;
         			sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+srcValue, "f_cmd="+SEARCHLIST12+"&bkg_no="+formObj.bkg_no.value+"&ca_flg="+formObj.ca_flg.value+"&rfa_no="+formObj.rfa_no.value);
     				changeObjectColor(ComGetEtcData(sXml,"rfa_available"), "N", "rfa_no", "red", "input");
     				
     				//다른 dummy 계약을 지운다
     				if(!ComIsNull(formObj.sc_no)  && ComGetObjValue(formObj.sc_no).substring(0,3)  == "DUM") ComSetObjValue(formObj.sc_no, "");
     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.taa_no, "");	     	
	 			} else {
     				changeObjectColor("N", "N", "rfa_no", "red", "input");	 				
	 			}
	 		}
			ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
//	 		ComSetObjValue(formObj.rfa_no_old,ComGetObjValue(formObj.rfa_no));
	 	}else if(srcName == "sc_no"){	 		
	 		//sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.14 kbj
	 		ComSetObjValue(formObj.ctrt_ofc_cd,"");
	 		ComSetObjValue(formObj.ctrt_srep_cd,"");
	 		
	 		if(srcValue == "DUM"){
	 			ComSetObjValue(formObj.sc_no,"DUM000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
	 		}else{
	 			if(srcValue.length>=8){
//         			// validateScAvailable() 호출
//         			formObj.f_cmd.value = SEARCHLIST13;
//         			sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+srcValue, "f_cmd="+SEARCHLIST13+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value);
//     				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");     				
//     				//다른 dummy 계약을 지운다
//     				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.rfa_no, "");
//     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.taa_no, "");	     			     				
	 			
	 			
         			// validateScAvailable() 호출
//         			formObj.f_cmd.value = SEARCHLIST13;
//         			sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+srcValue, "f_cmd="+SEARCHLIST13+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value);
	 				//[CHM-201432440] BKG main 화면의 S/C No. 빨간색 표기 요청 (customer code 불일치시)
	 				formObj.f_cmd.value = COMMAND10;
	 				var param = "f_cmd="+COMMAND10+"&bkg_no="+ComGetObjValue(formObj.bkg_no)+"&ca_flg="+ComGetObjValue(formObj.ca_flg)+"&sc_no="+ComGetObjValue(formObj.sc_no)
	 							+"&bkg_trunk_vvd="+ComGetObjValue(formObj.bkg_trunk_vvd)+"&bkg_por_cd="+ComGetObjValue(formObj.bkg_por_cd)+"&bkg_del_cd="+ComGetObjValue(formObj.bkg_del_cd)
				 				+"&s_cust_cnt_cd="+ ComGetObjValue(formObj.s_cust_cnt_cd)+"&s_cust_seq="+ComGetObjValue(formObj.s_cust_seq)
				 				+"&c_cust_cnt_cd="+ComGetObjValue(formObj.c_cust_cnt_cd)+"&c_cust_seq="+ComGetObjValue(formObj.c_cust_seq);
	 				sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", param);
	 				
	 				changeObjectColor(ComGetEtcData(sXml,"sc_available"), "N", "sc_no", "red", "input");     				
     				//다른 dummy 계약을 지운다
     				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.rfa_no, "");
     				if(!ComIsNull(formObj.taa_no) && ComGetObjValue(formObj.taa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.taa_no, "");	     			     				
	 			} else {
     				changeObjectColor("N", "N", "sc_no", "red", "input");	 
	 			}
	 		}
			ComSetObjValue(formObj.ctrt_modify_flag,"Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "taa_no"){
    		if(srcValue == "DUM"){
    			ComSetObjValue(formObj.taa_no,"DUM0000001");
	 			ComSetObjValue(formObj.ctrt_ofc_cd,ComGetObjValue(formObj.ob_sls_ofc_cd));
	 			ComSetObjValue(formObj.ctrt_srep_cd,ComGetObjValue(formObj.ob_srep_cd));
    		}else if(srcValue.length>=10){
     			// validatetTaaAvailable() 호출
     			formObj.f_cmd.value = SEARCH06;
     			sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?taa_no="+srcValue, "f_cmd="+SEARCH06+"&bkg_no="+formObj.bkg_no.value+"&ca_flg="+formObj.ca_flg.value+"&taa_no="+formObj.taa_no.value);
 				changeObjectColor(ComGetEtcData(sXml,"taa_available"), "N", "taa_no", "red", "input"); 				
 				//다른 dummy 계약을 지운다
 				if(!ComIsNull(formObj.rfa_no) && ComGetObjValue(formObj.rfa_no).substring(0,3) == "DUM") ComSetObjValue(formObj.rfa_no, "");
 				if(!ComIsNull(formObj.sc_no) && ComGetObjValue(formObj.sc_no).substring(0,3) == "DUM") ComSetObjValue(formObj.sc_no, "");
 			} else {
 				changeObjectColor("N", "N", "taa_no", "red", "input");	 
 			}
    		ComSetObjValue(formObj.ctrt_modify_flag,"Y"); 
	 	} else if(srcName == "bkg_cntc_pson_nm"||srcName == "bkg_cntc_pson_phn_no"||srcName == "bkg_cntc_pson_eml"||
	 			srcName == "bkg_cntc_pson_mphn_no"||srcName == "bkg_cntc_pson_fax_no"){
	     	ComSetObjValue(formObj.contact_modify_flag, "Y");
	 	}else if(srcName == "si_cntc_pson_nm"||srcName == "si_cntc_pson_phn_no"||srcName == "si_cntc_pson_eml"||
	 			srcName == "si_cntc_pson_mphn_no"||srcName == "si_cntc_pson_fax_no"){
	     	ComSetObjValue(formObj.contact_modify_flag, "Y");
    	// TrunkVvd 체크
	 	} else if(srcName == "bkg_trunk_vvd"){
			ComSetObjValue(formObj.route_modify_flag,"Y");
			manageHaveRouteFlag("N");            		
    		
    		if(srcValue.substring(0,4) == "HJXX" || srcValue.substring(0,4) == "HJYY" || srcValue.substring(0,4) == "HJZZ"){
    			ComSetObjValue(formObj.psdo_bkg_flg,"Y");
    		}else{
    			ComSetObjValue(formObj.psdo_bkg_flg,"N");
    		}  
    		for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
    			if(ComGetObjValue(formObj.bkg_trunk_vvd_old)== sheetObjects[1].CellValue(i, "bkg_vvd_cd")){
    				sheetObjects[1].CellValue(i, "bkg_vvd_cd") = srcValue;
    			}
    		}
        	if(ComIsNull(srcValue)){
        		for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
    	   			sheetObjects[1].RowDelete(i,false);	
    	   		}	
        	}
			ComSetObjValue(formObj.bkg_pol_yd_cd,"");
			ComSetObjValue(formObj.bkg_pod_yd_cd,"");

	    	por_pol_change(formObj);
 	    	pod_del_change(formObj);
 	    	ComSetObjValue(formObj.tvvd_modify_flg, "Y");
 	    	ComSetObjValue(formObj.check_ts_close_flag, "Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_por_cd"){        		
    		ComSetObjValue(formObj.route_modify_flag,"Y");
    		ComSetObjValue(formObj.bkg_por_yd_cd,"");
 	    	manageHaveRouteFlag("N");
			if(ComIsNull(srcValue)){
				for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
					sheetObjects[1].RowDelete(i,false);	
				}	
				clearPrePostRelay(formObj);
			}		        		
			ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			ComSetObjValue(formObj.org_trns_mod_cd, "");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_por_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "bkg_pol_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
 	    	manageHaveRouteFlag("N");
 	    	checkMaltaTerm(srcValue,"");

			ComSetObjValue(formObj.bkg_pol_yd_cd,"");
 	    	sheetObjects[1].CellValue(sheetObjects[1].HeaderRows,"pol_cd") = srcValue;
 	    	sheetObjects[1].CellValue(sheetObjects[1].HeaderRows,"pol_yd_cd") = "";

			pod_del_change(formObj);
			
			if(ComIsNull(srcValue)){
				for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
					sheetObjects[1].RowDelete(i,false);	
				}	
				clearPrePostRelay(formObj);
			}			
			ComSetObjValue(formObj.mty_pkup_yd_cd,"");
			ComSetObjValue(formObj.mty_pkup_dt,   "");
			ComSetObjValue(formObj.full_rtn_yd_cd,"");
			ComSetObjValue(formObj.org_trns_mod_cd, "");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
 	    	setPolPodClptIndSeq();
 	    	checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
    	}else if(srcName == "bkg_pol_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
 	    	if(sheetObjects[1].Rows>1){
 	    		sheetObjects[1].CellValue(1,"pol_yd_cd") = srcValue;
 	    	}
 	    	por_pol_change(formObj);
 	    	setPolPodClptIndSeq();
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_pod_cd"){
    		// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
    		checkEgyptDeTerm(srcValue);
    		checkTanzaniaDeTerm(srcValue, "", "");
    		//checkThailandDeTerm(srcValue, "", "");
    		checkMaltaTerm("", srcValue);
    		
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");

			ComSetObjValue(formObj.bkg_pod_yd_cd,"");
 	    	sheetObjects[1].CellValue(sheetObjects[1].Rows-1,"pod_cd") = srcValue;
 	    	sheetObjects[1].CellValue(sheetObjects[1].Rows-1,"pod_yd_cd") = ""; 

			pod_del_change(formObj);
 	    	
			if(ComIsNull(srcValue)){
				for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
					sheetObjects[1].RowDelete(i,false);	
				}	
				clearPrePostRelay(formObj);
			}	        			        		
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
 	    	setPolPodClptIndSeq();
 	    	ComSetObjValue(formObj.check_ts_close_flag, "Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_pod_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N"); 	    	
 	    	sheetObjects[1].CellValue(sheetObjects[1].Rows-1,"pod_yd_cd") = srcValue;  
 	    	pod_del_change(formObj);
 	    	setPolPodClptIndSeq();
 	    	ComSetObjValue(formObj.check_ts_close_flag, "Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_del_cd"){
    		checkTanzaniaDeTerm("", srcValue, "");
    		//checkThailandDeTerm("", srcValue, "");
    		
    		ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.bkg_del_yd_cd,"");
 	    	manageHaveRouteFlag("N");	
        	if(ComIsNull(srcValue)){
        		for(var i = sheetObjects[1].Rows  ; i >= sheetObjects[1].HeaderRows ; i-- ){
    	   			sheetObjects[1].RowDelete(i,false);	
    	   		}	
				clearPrePostRelay(formObj);
        	}
			ComSetObjValue(formObj.dest_trns_mod_cd, "");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "bkg_del_yd_cd"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "cmdt_cd"){
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "rep_cmdt_cd"){
    		if(ComIsNull(srcValue)){
    			ComSetObjValue(formObj.cmdt_desc,"");
    		}    		
    	}else if(srcName == "mty_pkup_yd_cd"){
			ComSetObjValue(formObj.route_modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "full_rtn_yd_cd"){	
			ComSetObjValue(formObj.route_modify_flag, "Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "flex_hgt_flg"){
    		ComSetObjValue(formObj.route_modify_flag,"Y");
 	    	manageHaveRouteFlag("N");
    	}else if(srcName == "s_cust_cnt_cd"){
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
    	}else if(srcName == "s_cust_seq"){
			ComSetObjValue(formObj.aloc_chk_flg,"Y");
//    	}
//	 	}else if(srcName == "xter_rmk"||srcName == "inter_rmk"){
//		}else if(srcName == "scac_cd"){
//		}else if(srcName == "ob_srep_cd"||srcName == "twn_so_no"||srcName == "ocp_cd"){
//		}else if(srcName == "act_wgt"){
	 	}
	}

    function makeComma(srcValue){
    	var arrVal = srcValue.split(".");
    	
    	if(arrVal.length > 1){
	    	if(arrVal[1].length > 3){
	    		arrVal[1] = arrVal[1].substring(0,3);
	    	}			
			srcValue = makeCommaRun(arrVal[0])+"."+ComRpad(arrVal[1], 3, "0");    		
    	}else{
    		srcValue = makeCommaRun(arrVal[0]) + ".000";
    	}
		return  srcValue;
    }

    function makeCommaUp(srcValue){
    	var arrVal = srcValue.split(".");
    	
    	if(arrVal.length > 1){
	    	if(arrVal[1].length > 3){
	    		arrVal[1] = arrVal[1].substring(0,3);
	    	}			
			srcValue = makeCommaRun(arrVal[0])+"."+arrVal[1];    		
    	}else{
    		srcValue = makeCommaRun(arrVal[0]);
    	}
		return  srcValue;
    }    
    
    function makeCommaRun(srcValue){    	
    	srcValue=srcValue.replace(/\D/g,"");
    	if(srcValue.length > 9){
    		srcValue = srcValue.substring(0,9);
    	}
		l=srcValue.length-3;
		while(l > 0) {
			srcValue=srcValue.substr(0,l)+","+srcValue.substr(l);
			l-=3;
		}    		
    	return srcValue;
    }
    
	// Staff Information 풍선도움말 관련
	function msgmove(){
		var obj = document.form.usr_nm;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight+250;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+540; 
		msg.style.left=sleft;
		msg.style.top=stop;
	}

	function msgset(strmsg){
		text ='<table  width=240  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		msg.innerHTML=text;
	}

	function msghide(){
		msg.innerHTML='';
	}	
	
	// allocation reason 풍선도움말 관련
	function alocmsgmove(){
		var obj = document.form.aloc_sts_cd;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight-40;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft-772;  
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
		if(ComGetObjValue(formObj.non_rt_sts_cd)=="R"){
			text ='<table width=60 bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
			nonRateStsMsg.innerHTML=text;
		}
	}

	function noratemsghide(){
		nonRateStsMsg.innerHTML='';
	}	
	
	// A/Customer 풍선도움말 관련
	function agmtcustmsgmove(){
		var obj = document.form.agmt_act_cnt_cd;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight+15;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+5;  
		agmtCustMsg.style.left=sleft;
		agmtCustMsg.style.top=stop;
	}

	function agmtcustmsgset(strmsg){
		var formObj = document.form;
		text ='<table width=60 bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		agmtCustMsg.innerHTML=text;
	}

	function agmtcustmsghide(){
		agmtCustMsg.innerHTML='';
	}
	
	// BlNo Information 풍선도움말 관련
	function blNoSet(){
		var obj = document.form.bl_no;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+5	;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetLeft+7; 
		orgBlNo.style.left=sleft;
		orgBlNo.style.top=stop;	
		
		var strMsg = document.form.orgBlNo.value;
		if(strMsg != ""){
			text ='<table  width=115  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strMsg + '</td></tr></table>';
			orgBlNo.innerHTML=text;
		}
	}

	function blNoHide(){
		orgBlNo.innerHTML='';
	}		
	
	// O/B DEM/DET TTL OUTSTANDING 풍선도움말 관련
	function obdmtmsgmove(){
		var obj = document.form.ob_dmt;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+obj.offsetHeight+155;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+367;  
		obDmt.style.left=sleft;
		obDmt.style.top=stop;
	}

	function obdmtmsgset(strmsg){
		var formObj = document.form;
		text ='<table width=200 bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strmsg + '</td></tr></table>';
		obDmt.innerHTML=text;
	}
	
	function obdmtmsghide(){
		obDmt.innerHTML='';
	}	

    /**
     * cmdt_cd 입력시 precaution 정보 조회
     */       
    function validatePrecaution(formObj){
    	formObj.f_cmd.value = SEARCHLIST11;
		//var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11+"&cmdt_cd="+formObj.cmdt_cd.value);
		var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+SEARCHLIST11+"&cmdt_cd="+formObj.cmdt_cd.value+"&bkg_no="+formObj.bkg_no.value); //2011.07.29 bkgNo추가
		sheetObjects[2].LoadSearchXml(sXml);
		
		ComSetObjValue(formObj.rep_cmdt_cd, ComGetEtcData(sXml,"rep_cmdt_cd"));		
		ComSetObjValue(formObj.cmdt_desc, ComGetEtcData(sXml,"cmdt_nm"));
		ComSetObjValue(formObj.validPrecaution, ComGetEtcData(sXml,"rep_imdg_lvl_cd"));

		setPrecaution(formObj, formObj.validPrecaution.value);
		changeObjectColor(formObj.stwg_flg.value, "Y", "btn_t1Stowage", "blue", "btn2");		
//		ComSetObjValue(formObj.validPrecaution, "Y");

//		bkg0156PopUp(formObj.bkg_no.value,"");
		//CHM-201429948 BKG Creation 화면에서 Revenue empty cntr flag 자동 처리 20140424
		//Seq	Code	Brief Description	REP
		//1	  960151	EMPTY CONTAINER, NOS	9600
		//2	  960316	EMPTY SHIPPER OWNED TANK CONTAINER	9600
		//3   730900    Fuel Empty container [CHM-201431739]
        
		if( ComGetObjValue(formObj.cmdt_cd) =='960151' || ComGetObjValue(formObj.cmdt_cd) =='960316' || ComGetObjValue(formObj.cmdt_cd) =='730900' ) {
			ComSetObjValue(formObj.bkg_cgo_tp_cd, "Y");
		} else {
			//soc_flg 가 'Y'아니면 초기화, 그외에는 그대로 둠 (즉  위 두 코가 아니더라고 체크 될수 있음)
			if(ComGetObjValue(formObj.soc_flg) != "Y" ) {
				
				ComSetObjValue(formObj.bkg_cgo_tp_cd, "");
			}
		}
    }    
    
    function setPrecaution(formObj, precaution){		
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
			//if(ComIsNull(formObj.stwg_cd.value)){
				//ComSetObjValue(formObj.stwg_cd, "PC");
				//ComSetObjValue(formObj.stwg_flg, "Y");
			//}
			formObj.prct_flg.checked = true;				
		} else if(precaution == "H"){
			formObj.spcl_hide_flg.checked = true;
			ComSetObjValue(formObj.stwg_flg, "Y");
			ComSetObjValue(formObj.stwg_cd, "ODHD");
			ComShowCodeMessage("BKG08351");
			formObj.prct_flg.checked = false;
		} else {
			if(formObj.validPrecaution.value != "P" && !formObj.prct_flg.checked){
				if(formObj.stwg_cd.value == "PC"){
	    			formObj.stwg_cd.value = "";
	    			formObj.stwg_rmk.value = "";
	    			ComSetObjValue(formObj.stwg_flg, "N");
				}
				//formObj.prct_flg.checked = false;
			}
			if(formObj.spcl_hide_flg.checked){
				formObj.spcl_hide_flg.checked = false;
				if(ComGetObjValue(formObj.stwg_cd) == "ODHD"){
					ComSetObjValue(formObj.stwg_flg, "");
					ComSetObjValue(formObj.stwg_cd, "");				
				}
			}
			formObj.prct_flg.checked = false;
		}
  		changeObjectColor(formObj.stwg_cd.value, "Y", "btn_t1Stowage", "blue", "btn2");  
    }
    
    // POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.	
	function checkEgyptDeTerm(srcValue){
		if((srcValue == "EGALY" || srcValue == "EGPSD") 
			&& ComGetObjValue(document.form.rfa_no) != "BUD12A0115"
			&& ComGetObjValue(document.form.rfa_no) != "BUD13A0167"
			&& ComGetObjValue(document.form.rfa_no) != "BUD14A0062"
			&& ComGetObjValue(document.form.rfa_no) != "BUD15A0078"
			&& ComGetObjValue(document.form.rfa_no) != "NKG15A1235"
			&& ComGetObjValue(document.form.rfa_no) != "NKG16A0165"
			&& ComGetObjValue(document.form.rfa_no) != "BUD16A0057"
			&& ComGetObjValue(document.form.rfa_no) != "NKG16C0407"
			){
			if(comboObjects[1].Code != "O"){
				ComShowCodeMessage("BKG00020");
				comboObjects[1].Code = "O";
				return false;
			}
		}		
		return true;
	}
	
	// POD, DEL에 'TZDAR' 입력시 DEL Term 체크
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
		if(pod_cd.substring(0,2) == "TH" || del_cd.substring(0,2) == "TH") {
			if(mode == "check"){
				if(comboObjects[1].Code == "S" && ComGetObjValue(formObj.kr_cstms_cust_tp_cd) == 'C'){
					return true;
				}else if (comboObjects[1].Code != "S" && ComGetObjValue(formObj.kr_cstms_cust_tp_cd) == 'C'){
					if(ComShowConfirm(ComGetMsg("BKG08309"))){
						return true;
					}else{
						return false;
					}
				}else if (comboObjects[1].Code != "S"){
					if ( BkgIsContainsChars(formObj.xter_rmk,"consol") || (ComGetObjValue(formObj.cmdt_cd) == '000004' || ComGetObjValue(formObj.cmdt_cd) == '000010' || ComGetObjValue(formObj.cmdt_cd) == '000017')) {
						if(ComShowConfirm(ComGetMsg("BKG08309"))){
							return true;
						}else{
							return false;
						}
					}
				}
			}else{
				//comboObjects[1].Code = "S";
				return true;
			}
		}		
		return true;
	}

    // POL, POD가 TR, DZ, MA, MT, TN, GR 인 경우 R/D Term CY 불가
	function checkMaltaTerm(polCd, podCd){
		if((polCd.substring(0, 2)=="TR"||polCd.substring(0, 2)=="DZ"||polCd.substring(0, 2)=="MA"||polCd.substring(0, 2)=="MT"||polCd.substring(0, 2)=="TN"||polCd.substring(0, 2)=="GR") 
			&& ComGetObjValue(document.form.rfa_no) != "TYO15A0725"){
			if(comboObjects[0].Code == "Y"){
				ComShowCodeMessage("BKG95120",polCd.substring(0, 2));//"For export cargoes from {?msg1}, CY term is prohibited. Please change R term."
				return false;
			}		
		}
		if((podCd.substring(0, 2)=="TR"||podCd.substring(0, 2)=="DZ"||podCd.substring(0, 2)=="MA"||podCd.substring(0, 2)=="MT"||podCd.substring(0, 2)=="TN"||podCd.substring(0, 2)=="GR") 
			&& (ComGetObjValue(document.form.rfa_no) != "TYO15A0725")
			&& !(ComGetObjValue(document.form.rfa_no) == "PKG16C0371" && podCd.substring(0, 2)=="TR")){
			if(comboObjects[1].Code == "Y"){
				ComShowCodeMessage("BKG95121",podCd.substring(0, 2));//"For import cargoes to {?msg1}, CY term is prohibited. Please change D term."
				return false;
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
//  			ComShowCodeMessage("BKG02051");
  			//url을 붙여넣기 할 수 있게 함
//  			window.clipboardData.setData("URL","http://www.customs.gov.ng/ProhibitionList/import.php");
  		}
  	}
	
    //미주 outbound 화물 Vehicle Flag 
  	function checkUsVehicleCmdt(polCd){
  		var formObj = document.form;
  		if(polCd.substring(0, 2)=="US"){
  			var vehXml = sheetObjects[2].GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+COMMAND07, FormQueryString(formObj));
  			var vehicle_flag = ComGetEtcData(vehXml, "vehicle_flag");
  			if(vehicle_flag == "Y"){
  				formObj.chk_veh_cmdt_flg.checked = true;
  				ComSetObjValue(formObj.veh_cmdt_flg,"Y");  				
  			} else {
  				formObj.chk_veh_cmdt_flg.checked = false;
  				ComSetObjValue(formObj.veh_cmdt_flg,"N");
  			}
  		} else {
  				formObj.chk_veh_cmdt_flg.checked = false;
  				ComSetObjValue(formObj.veh_cmdt_flg,"N");  			
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
	
    // CntrTpSz 입력여부 확인 및 중복정보 입력여부 확인
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
			ComShowCodeMessage("BKG00038",sheetObjects[0].CellValue(dupCntrTp.split("|")[0],"cntr_tpsz_cd"));		
			return false;    	        	  
		}     
		return true;
    }
    
	// RD,SOC,EQ SUB Flag Setting //저장될 flag setting
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
			// 20140403 [CHM-201429476] Revenue MT Bkg flag 관련 로직 수정 요청
			if(formObj.bkg_cgo_tp_cd.disabled == false){
				formObj.bkg_cgo_tp_cd.checked = false; 
			}
		}
		if(eqCnt > 0){
			ComSetObjValue(formObj.eq_subst_flg, "Y");    				
		}else{
			ComSetObjValue(formObj.eq_subst_flg, "N");
		}    	    	 
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
		if(isDisAble==true){
			formObj.flex_hgt_flg.checked = false;
		}
	}
	
	// 자동 계산 여부 확인 (true이면 자동 계산)
	function checkAutoCaluate(formObj){
		var autoCalCnt = 0;
		var rfCnt = 0;
		var sheetObj = sheetObjects[0];
		var awkCnt = 0;
		
		// detail sheet에 한개의 Container가 DR,DG 나누어져 있는 경우 PopUp
		if(ComGetObjValue(formObj.dcgo_flg) == "Y" && sheetObjects[3].RowCount > 1){
			for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){		
				cntrTpSz = sheetObj.CellValue(i, "cntr_tpsz_cd");
				drdgCnt = 0;
				for(var k = sheetObjects[3].HeaderRows ; k < sheetObjects[3].Rows ; k++){
					// 같은 container가 아니더라도 섞여있으면 자동계산하지 않음
//					if(cntrTpSz == sheetObjects[3].CellValue(k, "cntr_tpsz_cd")){
						if(sheetObjects[3].CellValue(k, "dry_cgo_flg") == 1){
							drdgCnt = drdgCnt+1;
						}
						if(sheetObjects[3].CellValue(k, "dcgo_flg") == 1){
							drdgCnt = drdgCnt+1;
						}						
//					}
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
		
		// Special Cargo 체크 (autoCalCnt > 1면 자동 계산이 아님) 
		if(ComGetObjValue(formObj.dcgo_flg) == "Y"){
			autoCalCnt++;
		}
		if(ComGetObjValue(formObj.rc_flg) == "Y"){
			rfCnt++;//RD + RF 때문에 따로 계산
		}
		if(ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
			autoCalCnt++;
			awkCnt++;
		}
		if(ComGetObjValue(formObj.bb_cgo_flg) == "Y"){
			autoCalCnt++;
		}	
		//awkward 존재시
		if(awkCnt>0){
			var dryCnt=0;
			for(var i = sheetObj.HeaderRows ; i < sheetObjects[0].Rows ; i++){
				if(sheetObj.CellValue(i, "cntr_tpsz_cd").substring(0,1)=="D"){
					dryCnt++;
				}
			}			
			if(dryCnt>0){
				autoCalCnt++;
			}
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
			autoCalCnt = autoCalCnt + 2;
		}
		//true이면 자동 계산
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
			   
			   if(existEqSub
					   && sheetObjects[0].CellValue(i, "crr_hngr_sgl_bar_qty") <= 0
					   && sheetObjects[0].CellValue(i, "crr_hngr_dbl_bar_qty") <= 0
					   && sheetObjects[0].CellValue(i, "crr_hngr_tpl_bar_qty") <= 0
					   && sheetObjects[0].CellValue(i, "mer_hngr_qty") <= 0){				   
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
					   if(eqSubSameQty){
						   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, sheetObjects[0].CellValue(i, "rd_cgo_flg"), sheetObjects[0], "N");
					   } else {
						   setDefaultCheckCgTp(sheetObjects[3], formObj, qtyDtlRow, "", sheetObjects[0], "N");
					   }
				   }
			   }
		   }   
		   
			// 20140328 - Awkward 만 선택시 T2 와 Q2 뿐이면 모두 AK 자동 체크 (박소현 대리 요청)
			if(ComGetObjValue(formObj.dcgo_flg) != "Y" && ComGetObjValue(formObj.rc_flg) != "Y" 
				&& ComGetObjValue(formObj.bb_cgo_flg) != "Y" && ComGetObjValue(formObj.awk_cgo_flg) == "Y"){
	           	
				var cntT2  = 0;
	           	var cntQ2  = 0;
	           	var cntOth = 0;
	           	for(var j=sheetObjects[3].HeaderRows; j<sheetObjects[3].HeaderRows + sheetObjects[3].RowCount; j++){
	           		var cntrTpSz = sheetObjects[3].CellValue(j, "cntr_tpsz_cd");
	           		if(cntrTpSz == "T2"){
	           			cntT2++;
	           		}else if(cntrTpSz == "Q2"){
	           			cntQ2++;
	           		}else{
	           			cntOth++;
	           		}
	           	}
	           	if(cntT2>0 && cntQ2>0 && cntOth==0){
	           		for(var j=sheetObjects[3].HeaderRows; j<sheetObjects[3].HeaderRows + sheetObjects[3].RowCount; j++){
	           			sheetObjects[3].CellValue(j, "awk_cgo_flg") = 1;
	           			sheetObjects[3].CellValue(j, "dry_cgo_flg") = 0;
	           		}
	           	}
			}
			
	   }else{
		   // 자동계산이 아닌 경우 PopUp에서 계산한다. 0890.js 참조
	   }
   }   
    
    /**
     * 0079 에서, CA상태변경후 재조회 call<br>
     */ 
    function CARefresh() {
     	// 조회 불필요함
//    	var formObj = document.form;
//        if(formObj.old_bkg_no.value == ""){            	
//        	doActionIBSheet(sheetObjects[2],formObj,INIT);
//        }else{
        	// 조회 불필요함
//        	doActionIBSheet(sheetObjects[2],formObj,SEARCH);
//        }
    }
     
     /**
      * p/c 호출 되는 경우 save 버튼을 빨간색으로 표시<br>
      */      
    function manageHaveRouteFlag(haveRouteFlg){
    	 var formObj = document.form;    	 
    	 ComSetObjValue(formObj.have_route_flag, haveRouteFlg);
    	 
    	 if (haveRouteFlg == "N"){
    		 ComSetObjValue(formObj.pctl_no, "");
     		changeObjectColor("Y", "Y", "btn_t1Save", "red", "btn2");    			
 		 } else {		 
     		changeObjectColor("Y", "Y", "btn_t1Save", "black", "btn2");
    	 }
     }
      
   // Booking Creation 화면 Button Control
	function btn007901Control(isEnable, btnName){
      	if(isEnable){
      		ComBtnEnable(btnName);
      	}else{
      		ComBtnDisable(btnName);
      	}
	}
      
	function setInquiryDisableButton(){
    	btn007901Control(false, "btn_t1Save");    	 
    	changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");		
    	btn007901Control(false, "btn_t1BKGCancel");
    	btn007901Control(false, "btn_t1Copy");
    	btn007901Control(false, "btn_t1Split");
		btn007901Control(false, "btn_t1Holding");						
		btn007901Control(false, "btn_t1Waiting");	    	 
		document.getElementById("btn_t1Sa0190").src = "img/btns_search_off.gif";
	}
      
    function clearPrePostRelay(formObj){
 		ComSetObjValue(formObj.pre_rly_port_cd,		"");
		ComSetObjValue(formObj.pre_rly_port_yd_cd,	"");
		ComSetObjValue(formObj.pre_vvd_cd, 			"");
		ComSetObjValue(formObj.pst_rly_port_cd,		"");
		ComSetObjValue(formObj.pst_rly_port_yd_cd,	"");
		ComSetObjValue(formObj.pst_vvd_cd, 			"");    	 
    }
     
     // BDR,C/A에 따라 항목 활성화/비활성화 설정 
    function setBookingEditable(isEnable){
    	 var formObj = document.form;
    	 
    	 BkgEnableObject(formObj.mnl_bkg_no_flg, isEnable);
//    	 BkgEnableObject(formObj.edi_hld_flg, isEnable);
    	 BkgEnableObject(formObj.bkg_trunk_vvd, isEnable);
    	 BkgEnableObject(formObj.bkg_por_cd, 	isEnable);
    	 BkgEnableObject(formObj.bkg_por_yd_cd, isEnable);
    	 // BDR = 'Y' && C/A = 'Y'인 경우 POL,POD 수정불가(20091118 추가)
    	 if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "Y"){
        	 BkgEnableObject(formObj.bkg_pol_cd,	false);
        	 BkgEnableObject(formObj.bkg_pol_yd_cd, false);
 			 document.getElementById("bkg_pol_cd").className = "input2";
        	 //dest 국가의 usr인 경우 pod 수정 가능 
//        	 if(formObj.bkg_pod_cd.value.substring(0, 2)==formObj.usr_cnt_cd.value){
//	        	 BkgEnableObject(formObj.bkg_pod_cd, 	true);
//	        	 BkgEnableObject(formObj.bkg_pod_yd_cd, true);
//        	 } else {
//	        	 BkgEnableObject(formObj.bkg_pod_cd, 	false);
//	        	 BkgEnableObject(formObj.bkg_pod_yd_cd, false);        		 
//        	 }
    	 }else{
        	 BkgEnableObject(formObj.bkg_pol_cd, 	isEnable);
 			 document.getElementById("bkg_pol_cd").className = (isEnable)?"input1":"input2";
        	 BkgEnableObject(formObj.bkg_pol_yd_cd, isEnable);
        	 BkgEnableObject(formObj.bkg_pod_cd, 	isEnable);
        	 BkgEnableObject(formObj.bkg_pod_yd_cd, isEnable);    		 
    	 }
    	 BkgEnableObject(formObj.bkg_del_cd, 	isEnable);
    	 BkgEnableObject(formObj.bkg_del_yd_cd, isEnable);	 
    	 BkgEnableObject(formObj.s_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.s_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.scac_cd, 		isEnable);
    	 BkgEnableObject(formObj.f_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.f_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.rfa_no, 		isEnable);
    	 BkgEnableObject(formObj.taa_no, 		isEnable);
    	 BkgEnableObject(formObj.c_cust_cnt_cd, isEnable);
    	 BkgEnableObject(formObj.c_cust_seq, 	isEnable);
    	 BkgEnableObject(formObj.sc_no, 		isEnable);
    	 BkgEnableObject(formObj.cmdt_cd, 		isEnable);
//    	 BkgEnableObject(formObj.agmt_act_cnt_cd,   isEnable);
//    	 BkgEnableObject(formObj.agmt_act_cust_seq, isEnable);

    	 //sheetObjects[0].Enable = isEnable;
    	 sheetObjects[0].Editable = isEnable; 
    	 sheetObjects[0].ColBackColor("rd_cgo_flg") = sheetObjects[0].RgbColor(239,240,243);

    	 if(!isEnable){
    		 BkgEnableObject(formObj.flex_hgt_flg, 	isEnable);
    	 } else {
    		 disabledFH(sheetObjects[0], formObj);
    	 }
    	 BkgEnableObject(formObj.act_wgt, 		isEnable);    	 
    	 //BkgEnableObject(formObj.prct_flg, 		isEnable);
    	 BkgEnableObject(formObj.twn_so_no, 	isEnable);
    	 BkgEnableObject(formObj.ocp_cd, 		isEnable);    	 
    	 BkgEnableObject(formObj.spcl_hide_flg, isEnable);  
    	 BkgEnableObject(formObj.spcl_hide_lnr_flg, isEnable);  
    	 BkgEnableObject(formObj.chk_crr_soc_flg, isEnable);  
    	 BkgEnableObject(formObj.chk_veh_cmdt_flg, isEnable);
    	 BkgEnableObject(formObj.chk_non_dg_chem_flg, isEnable);
    	 if(!isEnable){  	 
        	 BkgEnableObject(formObj.mty_dor_arr_dt, isEnable); 
    	 }   
    	 BkgEnableObject(formObj.fd_grd_flg, 	isEnable);    	 

    	 // 20140403 [CHM-201429476] Revenue MT Bkg flag 관련 로직 수정 요청
		 if(ComGetObjValue(formObj.soc_flg) == "Y" || formObj.bkg_cgo_tp_cd.checked){
			 BkgEnableObject(formObj.bkg_cgo_tp_cd, isEnable);
		 }else{
			 BkgEnableObject(formObj.bkg_cgo_tp_cd, false);
		 }
		 
    	 BkgEnableObject(formObj.lodg_due_dt, 	isEnable);    	
    	 BkgEnableObject(formObj.de_due_dt, 	isEnable);    	 
    	 BkgEnableObject(formObj.mty_pkup_yd_cd,isEnable);    	 
    	 BkgEnableObject(formObj.mty_pkup_dt,	isEnable);    	 
    	 BkgEnableObject(formObj.full_rtn_yd_cd,isEnable);    
    	 
    	 formObj.rcv_term_cd.Enable = isEnable;
    	 formObj.de_term_cd.Enable  = isEnable;
    	 formObj.usa_cstms_file_cd.Enable = isEnable;
    	 formObj.cnd_cstms_file_cd.Enable = isEnable;
    	 formObj.wgt_ut_cd.Enable   = isEnable;
    	 formObj.rail_blk_cd.Enable = isEnable;
    	 formObj.ida_hlg_tp_cd.Enable = isEnable;
    	 
//    	 btn007901Control(isEnable, "btn_EqDetail");
    	 btn007901Control(isEnable, "btn_t1RowAdd");
    	 
    	 btn007901Control(isEnable, "btn_t1Delete");
    	 btn007901Control(isEnable, "btn_t1BKGCancel");
    	 btn007901Control(isEnable, "btn_t1Holding");
    	 btn007901Control(isEnable, "btn_t1Waiting");
    	 //btn007901Control(isEnable, "btn_t1Split");

		 // c/a 경우 Split 버튼 Disable
		 if(ComGetObjValue(formObj.ca_flg) == "Y"){
			 btn007901Control(false, "btn_t1Split");
		 }else{
			 btn007901Control(true, "btn_t1Split");
		 }

		 if(ComGetObjValue(formObj.isInquiry) != "Y"){
			if(isEnable){
				document.getElementById("btn_t1Sa0190").src = "img/btns_search.gif";
			}else{
				document.getElementById("btn_t1Sa0190").src = "img/btns_search_off.gif";
			}
		}
		 
    	 // SpecialCargo Flag는 값이 존재시 무조건 Disable(20091117 추가)
    	 if(!isEnable){
        	 BkgEnableObject(formObj.dcgo_flg,    isEnable);
        	 BkgEnableObject(formObj.rc_flg,      isEnable);
        	 BkgEnableObject(formObj.awk_cgo_flg, isEnable);   
        	 BkgEnableObject(formObj.bb_cgo_flg,  isEnable);     		 
    	 }else{
    		 //Y:해당 special cargo가 입력만 되어 있거나 bkg_booking의 flag만 켜져 있는 상태
 			if(ComGetObjValue(formObj.dg_flg) == "Y"||ComIsNull(ComGetObjValue(formObj.dcgo_flg))){
				BkgEnableObject(formObj.dcgo_flg, true);
			}else{
				BkgEnableObject(formObj.dcgo_flg, false);
			}
			if(ComGetObjValue(formObj.rf_flg) == "Y"||ComIsNull(ComGetObjValue(formObj.rc_flg))){
				BkgEnableObject(formObj.rc_flg, true);
			}else{
				BkgEnableObject(formObj.rc_flg, false);
			}		
			if(ComGetObjValue(formObj.awk_flg) == "Y"||ComIsNull(ComGetObjValue(formObj.awk_cgo_flg))){
				BkgEnableObject(formObj.awk_cgo_flg, true);
			}else{
				BkgEnableObject(formObj.awk_cgo_flg, false);
			}	
			if(ComGetObjValue(formObj.bb_flg) == "Y"||ComIsNull(ComGetObjValue(formObj.bb_cgo_flg))){
				BkgEnableObject(formObj.bb_cgo_flg, true);
			}else{
				BkgEnableObject(formObj.bb_cgo_flg, false);
			}		
			
			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){
				btn007901Control(false, "btn_t1Save");
				changeObjectColor("Y", "Y", "btn_t1Save", "#c0c0c0", "btn1");	
				btn007901Control(false, "btn_t1Holding");						
				btn007901Control(false, "btn_t1Waiting");	
			}else if(ComGetObjValue(formObj.bkg_sts_cd) == "S"){
//				btn007901Control(false, "btn_t1BKGCancel");
				btn007901Control(false, "btn_t1Holding");						
				btn007901Control(false, "btn_t1Waiting");		
			}else if(ComGetObjValue(formObj.bkg_sts_cd) != "F" && ComGetObjValue(formObj.bkg_sts_cd) != "W"){
				btn007901Control(false, "btn_t1Holding");
				btn007901Control(false, "btn_t1Waiting");							
			}else{
				btn007901Control(true, "btn_t1Save");
				if(ComGetObjValue(formObj.have_route_flag)=="Y"){
					changeObjectColor("Y", "Y", "btn_t1Save", "black", "btn1");
				}
				btn007901Control(true, "btn_t1BKGCancel");
				btn007901Control(true, "btn_t1Holding");						
				btn007901Control(true, "btn_t1Waiting");		
			}
			
			btn007901Control(true, "btn_t1Copy"); //copy 항상 활성화
			// Enable인 경우 Default 색 처리.(20091120 김병규 추가)
			document.getElementById("bkg_por_cd").className = "input1";
			document.getElementById("bkg_del_cd").className = "input1";
			document.getElementById("s_cust_cnt_cd").className = "input1";
			document.getElementById("s_cust_seq").className = "input1";
			document.getElementById("f_cust_cnt_cd").className = "input1";
			document.getElementById("f_cust_seq").className = "input1";
			document.getElementById("rfa_no").className = "input1";
			document.getElementById("sc_no").className = "input1";
			document.getElementById("taa_no").className = "input1";
			document.getElementById("cmdt_cd").className = "input1";			
			document.getElementById("act_wgt").className = "input1";
			document.getElementById("lodg_due_dt").className = "input1";
    	} 
	}
    
    // TAA No, RFA No 선택여부에 따라 Display
	function chkTaaRfa(val){
		if(val == 'T'){
			document.all.item("taaNoDiv").style.display = "block";
			document.all.item("rfaNoDiv").style.display = "none";
		}else{
			document.all.item("taaNoDiv").style.display = "none";
			document.all.item("rfaNoDiv").style.display = "block";			
		}
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
				}else if(ComGetEtcData(sXml,"pb")=="Exceeding Credit Limit"){
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
    
    function goFocusQty(){
    	var formObj = document.form;
    	var have_route_flag = formObj.have_route_flag.value;
    	
    	ComSetFocus(sheetObjects[0]);    	
		if(sheetObjects[0].Rows==1){
	    	var nRow = sheetObjects[0].DataInsert(-1);
			sheetObjects[0].SelectCell(nRow, "cntr_tpsz_cd");
		} else {
			sheetObjects[0].SelectCell(sheetObjects[0].SelectRow, "cntr_tpsz_cd");
		}    	
		formObj.have_route_flag.value = have_route_flag;
    }
    
    /**
     * MT PickUp CY Inquiry 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0019(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function callBack0019(rArray){    	
    	var formObj = document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	    	if(rArray != null){
	    		ComSetObjValue(formObj.bkg_trunk_vvd,rArray[0][3]);
	    		ComSetObjValue(formObj.bkg_pol_yd_cd,"");
	    		ComSetObjValue(formObj.bkg_pod_yd_cd,"");
	    		por_pol_change(formObj);
	    		pod_del_change(formObj);
	    		
	    		ComSetObjValue(formObj.route_modify_flag, "Y");
	    		ComSetObjValue(formObj.modify_flag, "Y");
	    		manageHaveRouteFlag("N");
	    		if(rArray[0][3].substring(0,4) == "HJXX" || rArray[0][3].substring(0,4) == "HJYY" || rArray[0][3].substring(0,4) == "HJZZ"){
	    			ComSetObjValue(formObj.psdo_bkg_flg, "Y");
	    		}else{
	    			ComSetObjValue(formObj.psdo_bkg_flg, "N");
	    		}    		
	    		ComSetObjValue(formObj.check_ts_close_flag, "Y");
	    		
				if(sheetObjects[1].RowCount == 1){
					sheetObjects[1].CellValue(1, "vsl_pre_pst_cd") = "T";
					sheetObjects[1].CellValue(1, "vsl_seq") = "0";
					sheetObjects[1].CellValue(1, "bkg_vvd_cd") = rArray[0][3];
//					sheetObjects[1].CellValue(1, "poL_clpt_ind_seq") = "1";
//					sheetObjects[1].CellValue(1, "pod_clpt_ind_seq") = "1";
				}
	    	}
    	}
    }
	
    /**
     * Container Type/Size 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0080(rArray);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function callBack0080(rArray){    
    	 var formObj = document.form;
    	 if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){ 
    		 if(rArray != null){
    			 sheetObjects[0].CellValue(sheetObjects[0].SelectRow , "cntr_tpsz_cd") = rArray[0][2];
    		 }
    	 }
    }          
    
    /**
     * Hanger Installation Order 선택 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0081(callback_func,callSheetIdx);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0081(callback_func,callSheetIdx){
    	ComOpenPopup("ESM_BKG_0081.do?pgmNo=ESM_BKG_0081&callSheetIdx="+callSheetIdx, 500, 290, callback_func,	"1,0,1,1,1", true);
    }        
         
     /**
      * Hanger Installation Order 수행후 처리 <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0081();
      * </pre>
      * @param Popup에서 전달받은 값
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
	function callBack0081(hngrFlg){    	
     	var formObj = document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){ 
	     	ComSetObjValue(formObj.modify_flag, "Y");    
	  		ComSetObjValue(formObj.carge_detail_pop, "Y"); // cargo_detail_pop에서 ok 되었음  	
	  		ComSetObjValue(formObj.qty_modify_flag, "Y");
	     	
	     	ComSetObjValue(formObj.hngr_flg, hngrFlg);
	     	ComSetObjValue(formObj.cgo_dtl_auto_flg, "N");		// Cargo Detail 화면을 Save시 띄운다.
	     	changeObjectColor(hngrFlg, "Y", "btn_t1Hanger", "blue", "btn2");	    
     	}
    }   
     
     /**
      * MT PickUp CY Inquiry 에서 전달받은 값 저장 <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0082(rArray);
      * </pre>
      * @param Popup에서 전달받은 값
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
    function callBack0082(rArray){    	
     	var formObj = document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){      	
	     	if(rArray != null){
	     		ComSetObjValue(formObj.mty_pkup_yd_cd, rArray[0][2]);
	
	     		ComSetObjValue(formObj.route_modify_flag, "Y");
	     		ComSetObjValue(formObj.modify_flag, "Y");
	     		manageHaveRouteFlag("N");
	     	}
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
		 	    		form_onChange(null,formObj.bkg_por_cd);
		 	    		ComSetObjValue(formObj.bkg_por_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_por_yd_cd);
		 	    	}else if(locTp == "POL"){
		 	    		ComSetObjValue(formObj.bkg_pol_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_pol_cd);
		 	    		ComSetObjValue(formObj.bkg_pol_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		checkMaltaTerm(rArray[0][2],"");
		 	    		por_pol_change(formObj);
		 	    	}else if(locTp == "POD"){
		 	    		ComSetObjValue(formObj.bkg_pod_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_pod_cd);
		 	    		ComSetObjValue(formObj.bkg_pod_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
		 	    		checkEgyptDeTerm(rArray[0][2]);
		 	    		checkTanzaniaDeTerm(rArray[0][2], "", "");
		 	    		//checkThailandDeTerm(rArray[0][2], "", "");
		 	    		checkMaltaTerm("",rArray[0][2]);
		 	    		pod_del_change(formObj);
		 	    	}else{
		 	    		ComSetObjValue(formObj.bkg_del_cd, rArray[0][2]);
		 	    		form_onChange(null,formObj.bkg_del_cd);
		 	    		ComSetObjValue(formObj.bkg_del_yd_cd, "");
		 	    		form_onChange(null,formObj.bkg_del_yd_cd);
		 	    		checkTanzaniaDeTerm("", rArray[0][2], "");
		 	    		//checkThailandDeTerm("", rArray[0][2], "");
		 	    	}		  
	     		}else{
		 	    	if(locTp == "POR"){
		 	    		ComSetObjValue(formObj.bkg_por_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_por_cd);
		 	    		ComSetObjValue(formObj.bkg_por_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_por_yd_cd);
		 	    	}else if(locTp == "POL"){
		 	    		ComSetObjValue(formObj.bkg_pol_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_pol_cd);
		 	    		ComSetObjValue(formObj.bkg_pol_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_pol_yd_cd);
		 	    		checkMaltaTerm(rArray[0][4].substring(0,5),"");
		 	    		por_pol_change(formObj);
		 	    	}else if(locTp == "POD"){
		 	    		ComSetObjValue(formObj.bkg_pod_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_pod_cd);
		 	    		ComSetObjValue(formObj.bkg_pod_yd_cd, rArray[0][4].substring(5,7));
		 	    		form_onChange(null,formObj.bkg_pod_yd_cd);
		 	    		// POD에 'EGALY','EGPSD' 입력시 DEL Term이 'O'가 아닌경우 메시지.
		 	    		checkEgyptDeTerm(rArray[0][4].substring(0,5));
		 	    		checkTanzaniaDeTerm(rArray[0][4].substring(0,5), "", "");
		 	    		//checkThailandDeTerm(rArray[0][4].substring(0,5), "", "");
		 	    		checkMaltaTerm("",rArray[0][4].substring(0,5));
		 	    		pod_del_change(formObj)
		 	    	}else{
		 	    		ComSetObjValue(formObj.bkg_del_cd, rArray[0][4].substring(0,5));
		 	    		form_onChange(null,formObj.bkg_del_cd);
		 	    		ComSetObjValue(formObj.bkg_del_yd_cd, rArray[0][4].substring(5,7));	
		 	    		form_onChange(null,formObj.bkg_del_yd_cd);
		 	    		checkTanzaniaDeTerm("", rArray[0][4].substring(0,5), "");
		 	    		//checkThailandDeTerm("", rArray[0][4].substring(0,5), "");
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
      * <br><b>Example :</b>
      * <pre>
      *     callBack0088(rArray);
      * </pre>
      * @param Popup에서 전달받은 값
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
    function callBack0088(rArray){    	
     	var formObj = document.form;
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	     	if(rArray != null){
	     		ComSetObjValue(formObj.full_rtn_yd_cd, rArray[0][2]);
	
	     		ComSetObjValue(formObj.route_modify_flag, "Y");
	     		ComSetObjValue(formObj.modify_flag, "Y");
	 	    	manageHaveRouteFlag("N");
	     	}
     	}
	} 

      /**
       * Special Stowage Request 선택 팝업 호출. <br>
       * <br><b>Example :</b>
       * <pre>
       *     comBkgCallPop0090(callback_func);
       * </pre>
       * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
       * @return 없음
       * @author 김병규
       * @version 2009.05.14
       */

	function comBkgCallPop0090(callback_func, stwgCd, stwgRmk, bkgNo, caFlg, podCd){
		ComOpenPopup("ESM_BKG_0090.do?pgmNo=ESM_BKG_0090&stwg_cd=" + stwgCd + "&stwg_rmk=" + stwgRmk
				+ "&bkg_no=" + bkgNo + "&ca_flg=" + caFlg + "&pod_cd=" + podCd, 
				420, 625, callback_func,"1,0,1,1,1", true);
    }            

      /**
       * Special Stowage Request 팝업에서 전달받은 값 저장 <br>
       * <br><b>Example :</b>
       * <pre>
       *     callBack0090(rArray);
       * </pre>
       * @param Popup에서 전달받은 값
       * @return 없음
       * @author 김병규
       * @version 2009.05.14
       */
    function callBack0090(rArray){    	
      	var formObj = document.form;
      	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){         	
  	    	if(rArray != null){
  	    		ComSetObjValue(formObj.stwg_cd, rArray[0]);
  	    		ComSetObjValue(formObj.stwg_rmk, rArray[1]);  	    		
  	    		ComSetObjValue(formObj.modify_flag, "Y");
  	    		
  	    		if(ComGetObjValue(formObj.stwg_cd) != ""){
  	        		ComSetObjValue(formObj.stwg_flg, "Y");   			
  	    		}else{
  	        		ComSetObjValue(formObj.stwg_flg, "N"); 			
  	    		}  		    		
  	    	}
  	    	changeObjectColor(formObj.stwg_flg.value, "Y", "btn_t1Stowage", "blue", "btn2"); 
      	}
    }           
       
    /**
     * route detail 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0092(callback_func,bkgNo);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */

    function comBkgCallPop0092(callback_func, bkgNo, bkgTrunkVvd, caFlg, callSheetIdx){	
    	var formObj = document.form;
    	//2012.01.05 portSkpFlg parameter 추가 kbj
    	var url = "ESM_BKG_0092.do?pgmNo=ESM_BKG_0092&bkg_no="+bkgNo+"&bkgTrunkVvd="+bkgTrunkVvd+"&ca_flg="+caFlg+"&callSheetIdx="+callSheetIdx+"&portSkpFlg="+formObj.port_skp_flg.value;
    	if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
    		url = url + "&displayOnly=Y";
    	} else if(ComGetObjValue(formObj.is_vl_flg) == "Y"){
    		url = url + "&displayOnly=1";
    	}
    	ComOpenPopup(url, 700, 490, callback_func,"1,0,1,1,1", true);
    	ComSetObjValue(formObj.tvvd_modify_flg, "N");
    }        

     /**
      * Route Detail 처리 후 작업 <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0092();
      * </pre>
      * @param Popup에서 전달받은 값
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
     function callBack0092(){
     	var formObj = document.form;
     	var sheetObj = sheetObjects[1];

     	clearPrePostRelay(formObj);
     	if(sheetObj.RowCount > 0){
         	// 01. PrePostCd가 'T' 인 Vvd를 Main에 넣는다.
         	ComSetObjValue(formObj.bkg_trunk_vvd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T"),"bkg_vvd_cd"));
         	
         	// 01-01. PRE RELAY 입력
         	if(sheetObj.FindText("vsl_pre_pst_cd","T") > 1){
         		ComSetObjValue(formObj.pre_rly_port_cd,    sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_cd"));
         		ComSetObjValue(formObj.pre_rly_port_yd_cd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"pod_yd_cd"));
         		ComSetObjValue(formObj.pre_vvd_cd,         sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")-1,"bkg_vvd_cd"));
         	}
         	// 01-02. POST REPAY 입력
         	if(sheetObj.FindText("vsl_pre_pst_cd","T")+1 < sheetObj.Rows){
         		ComSetObjValue(formObj.pst_rly_port_cd,    sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_cd"));
         		ComSetObjValue(formObj.pst_rly_port_yd_cd, sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"pol_yd_cd"));
         		ComSetObjValue(formObj.pst_vvd_cd,         sheetObj.CellValue(sheetObj.FindText("vsl_pre_pst_cd","T")+1,"bkg_vvd_cd"));
         	}
         	
         	// 02. 첫번째데이터의 POL을 BKG POL에 넣는다.(20100119 추가)
        	ComSetObjValue(formObj.bkg_pol_cd,    sheetObj.CellValue(1,"pol_cd"));
        	ComSetObjValue(formObj.bkg_pol_yd_cd, sheetObj.CellValue(1,"pol_yd_cd"));        	
         	// 02. 마지막데이터의 POD를 BKG POD에 넣는다.(20100119 추가)
        	ComSetObjValue(formObj.bkg_pod_cd,    sheetObj.CellValue(sheetObj.RowCount,"pod_cd"));
        	ComSetObjValue(formObj.bkg_pod_yd_cd, sheetObj.CellValue(sheetObj.RowCount,"pod_yd_cd"));  		
     	}
     	
 		ComSetObjValue(formObj.route_modify_flag, "Y");
 		ComSetObjValue(formObj.modify_flag, "Y");
     	manageHaveRouteFlag("N");
 		
 		if(formObj.bkg_trunk_vvd.value.length > 4){
 			var pseudoVvd = ComGetObjValue(formObj.bkg_trunk_vvd).substring(0,4);
 			if(pseudoVvd == "HJXX" || pseudoVvd == "HJYY" || pseudoVvd == "HJZZ"){
 				ComSetObjValue(formObj.psdo_bkg_flg, "Y");
 			}else{
 				ComSetObjValue(formObj.psdo_bkg_flg, "N");
 			}
 		}
 		
 		// 2012.01.05 btn_route의 색이 red가 아닌경우에만 port_skp_flg가 'Y'면 green으로 표시 kbj
		changeObjectColor(formObj.port_skp_flg.value, "Y", "btn_t1RouteDetail", "00cc00", "btn2");

 		por_pol_change(formObj);
 		pod_del_change(formObj);
 		
 		route_detail_modify_flag = "Y";
     }         
            
    /**
     * Reference 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0097(callback_func,bkgNo,caFlg);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0097(callback_func, bkgNo,  caFlg){
    	ComOpenPopup("ESM_BKG_0097.do?pgmNo=ESM_BKG_0097&bkg_no="+bkgNo+"&ca_flg="+caFlg, 500, 390, callback_func,"1,0,1,1,1", true);
    }     

    /**
     * Reference 팝업에서 Copy To Memo시 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0097(memo);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function callBack0097(memo){    	
    	var formObj = document.form;
    	
    	if(memo != null && memo.length > 0){
    		if(ComIsNull(formObj.xter_rmk)){
    			ComSetObjValue(formObj.xter_rmk,memo);
    		}else{
    			ComSetObjValue(formObj.xter_rmk,ComGetObjValue(formObj.xter_rmk)+"\n"+memo);
    		}
	    	ComSetObjValue(formObj.modify_flag, "Y");
    	}
    }                
    
     /**
      * danger 팝업 open  <br>
      * <br><b>Example :</b>
      * <pre>
      *     comBkgCallPop0200(bkgNo, caFlg);
      * </pre>
      * @param bkgNo, caFlg
      * @return 없음
      * @author 류대영
      * @version 2010.05.27
      */
    function comBkgCallPop0200(bkgNo, caFlg){	
    	var formObj = document.form;
		ComOpenWindowCenter("ESM_BKG_0200.do?pgmNo=ESM_BKG_0200&bkg_no="+bkgNo+"&ca_flg="+caFlg, "ESM_BKG_0055", 1010, 570, true);
		doActionIBSheet(sheetObjects[2],formObj,SEARCH);
    }
    
	 /**
     * Customer Popup에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBack0652(bkgCustTpCd, rArray1, rArray2);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
    	var formObj = document.form;
    	//alert(rArray1);
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	    	// SHPR,FWDR,CNEE 입력
	    	if(rArray1 != null){
		    	if(bkgCustTpCd == "S"){
		    		ComSetObjValue(formObj.s_cust_cnt_cd, rArray1[0][14].substring(0,2));
		    		//alert(rArray1[0][14]);
		    		ComSetObjValue(formObj.s_cust_seq,    ComLpad(rArray1[0][15],6,"0"));
		    		ComSetObjValue(formObj.s_cust_nm,     rArray1[0][5]);
		    		
		    		// 20100113 추가
		    		if(ComGetObjValue(formObj.s_cust_exist_flg) == "Y"){
		    			if(ComGetObjValue(formObj.s_cust_cnt_cd) != ComGetObjValue(formObj.s_cust_cnt_cd_old) || ComGetObjValue(formObj.s_cust_seq) != ComLpad(ComGetObjValue(formObj.s_cust_seq_old),6,"0")){
		    				ComSetObjValue(formObj.s_cust_subst_flg, "Y");
/*						20100120 Shipper는 질문없이 항상 변경
		    				if(ComShowCodeConfirm("BKG00343")){
		    					ComSetObjValue(formObj.s_cust_subst_flg, "Y");
		    				}else{
		    					ComSetObjValue(formObj.s_cust_subst_flg, "N");
		    				}
*/		    				
		    			}
		    		}
		    		// 20100118 추가 - FW Code
		    		if(rArray2 != null){
	    				if(rArray2[0][8] != ""){
	    		    		ComSetObjValue(formObj.f_cust_cnt_cd, rArray2[0][8].substring(0,2));
	    		    		ComSetObjValue(formObj.f_cust_seq,    ComLpad(rArray2[0][8].substring(2),6,"0"));				    					
	    				}else{
//	    		    		ComSetObjValue(formObj.f_cust_cnt_cd, "");
//	    		    		ComSetObjValue(formObj.f_cust_seq,    "");				    					
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
		    		ComSetObjValue(formObj.f_cust_cnt_cd, rArray1[0][14].substring(0,2));
		    		ComSetObjValue(formObj.f_cust_seq,    ComLpad(rArray1[0][15],6,"0"));
		    		ComSetObjValue(formObj.f_cust_nm,     rArray1[0][5]);    
		    		ComSetObjValue(formObj.fmc_no,        rArray1[0][13]);	

		    		// SHPR 입력없이 FWDR입력시 SHPR에 자동 입력
		    		if(ComGetObjValue(formObj.s_cust_exist_flg) != "Y" && ComIsNull(formObj.s_cust_nm)){
		    			ComSetObjValue(formObj.s_cust_cnt_cd, rArray1[0][14].substring(0,2));
			    		ComSetObjValue(formObj.s_cust_seq,    ComLpad(rArray1[0][15],6,"0"));
			    		ComSetObjValue(formObj.s_cust_nm,     rArray1[0][5]);	
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
		    			ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
						ComSetObjValue(formObj.ob_srep_cd,    lRep);
		    		}
		    	}
		    	ComSetObjValue(formObj.modify_flag,          "Y");
		    	ComSetObjValue(formObj.customer_modify_flag, "Y");
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
				}
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
     	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){         	 
 			if(arrVal != null){				
 				ComSetObjValue(formObj.cmdt_cd,     arrVal[0][3]);
 				ComSetObjValue(formObj.rep_cmdt_cd, arrVal[0][5]);
 				ComSetObjValue(formObj.cmdt_desc,   arrVal[0][4]);		
 				
 				if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){	
    	    		checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
 					var precaution = arrVal[0][7];
 					
 					setPrecaution(formObj, precaution);
 					
    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);    
// 					ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
 					ComSetObjValue(formObj.modify_flag, "Y");   	
 					
 					ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][3]);				
 				}
 				ComSetObjValue(formObj.route_modify_flag, "Y");
 				manageHaveRouteFlag("N");
 			}
     	}
 	}
 	
      /**
       * RFA Search후 Return받는 함수. <br>
       * <br><b>Example :</b>
       * <pre>
       *     callBack0654(arrBal);
       * </pre>
       * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
       * @return 없음
       * @author 김병규
       * @version 2009.05.14
       */    
  	function callBack0654(arrVal){
    	var formObj = document.form;   
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){   
	  		if(arrVal != null){	  			
	  			ComSetObjValue(formObj.rfa_no,     arrVal[0][5]);
//	  			ComSetObjValue(formObj.rfa_no_old, arrVal[0][5]);
	  			
	  			ComSetObjValue(formObj.modify_flag,      "Y");   	
	  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
				changeObjectColor("Y", "N", "rfa_no", "red", "input");
	  		}
    	}
  	}              

     /**
      * S/C Search후 Return받는 함수. <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0655(arrBal);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */    
 	function callBack0655(arrVal){
        var formObj = document.form;
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     
	 		if(arrVal != null){		 			
	 			//sc_no변경시 C.OFC/Rep. 값 초기화 2011.11.14 kbj
	 			if(ComGetObjValue(formObj.sc_no) != arrVal[0][5]){
			 		ComSetObjValue(formObj.ctrt_ofc_cd,"");
			 		ComSetObjValue(formObj.ctrt_srep_cd,"");
	 			}
	 			ComSetObjValue(formObj.sc_no,     arrVal[0][5]);
//	  			ComSetObjValue(formObj.sc_no_old, arrVal[0][5]);
	 			
	 			ComSetObjValue(formObj.modify_flag,      "Y");   	
	 			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
	  			changeObjectColor("Y", "N", "sc_no", "red", "input");
	 		}
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
      	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){  
      		if(arrVal != null){		
   		    	var scpCd = arrVal[0][5];
   		    	//rfa에는 적용하지 않음
//   				if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
//   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
//   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
//   						validatePrecaution(formObj);
//   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//   						
//   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
//   						ComSetObjValue(formObj.modify_flag,     "Y");   	
//   						
//   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
//   					}		
//   				} else
   				if(arrVal[0][1]=="000004"){
  					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
  	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);		
					ComSetObjValue(formObj.modify_flag,     "Y");
  					
  					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
  	    	    		checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
  						validatePrecaution(formObj);
  	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//  						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.  						
  						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);
  					}
  				} else if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"){
  					comBkgCallPop0653('callBack0653',"","");
  				} else if(arrVal[0][6] == "9901"){
  					comBkgCallPop0653('callBack0653',"","");
  				} else if(arrVal[0][3] == "REP"){
  					comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
  				} else {			
  					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
  	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);		
					ComSetObjValue(formObj.modify_flag, "Y");   	
  		
  					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
  						checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
  						validatePrecaution(formObj);
  	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//  						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.  						
  						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);
  					}
  				}	
   				
   				if( !(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N")
   					&& !(ComGetObjValue(formObj.isInquiry) == "Y")	){					

   					if(arrVal[0][8]!="" && arrVal[0][8].length > 2 ){
   						ComSetObjValue(formObj.agmt_act_cnt_cd, arrVal[0][8].substring(0,2));
   						ComSetObjValue(formObj.agmt_act_cust_seq, arrVal[0][8].substring(2));
   					}else{
   						ComSetObjValue(formObj.agmt_act_cnt_cd, "");
   						ComSetObjValue(formObj.agmt_act_cust_seq, "");
   					}
   		  		
   		  			if(formObj.agmt_act_cnt_cd.value ==""){
   		  	    		document.getElementById("btn_t1Sa0190").style.border = "2 solid #F3F2F8";
   		  			}else{	
   		  				document.getElementById("btn_t1Sa0190").style.border = "2 solid blue";
   		  			}  			
   		  			ComSetObjValue(formObj.modify_flag, "Y");
   		  			ComSetObjValue(formObj.customer_modify_flag, "Y");
   				}
   				ComSetObjValue(formObj.route_modify_flag, "Y");
   				manageHaveRouteFlag("N");
  			}
      	}
  	}             
  	
   /**
   * S/C Commodity Popup후 Return받는 함수. <br>
   * <br><b>Example :</b>
   * <pre>
   *     callBack0657(arrBal);
   * </pre>
   * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
   * @return 없음
   * @author 김병규
   * @version 2009.05.14
   */    
   	function callBack0657(arrVal){
       	var formObj = document.form;
       	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
   			if(arrVal != null){		
   		    	var scpCd = arrVal[0][6];   		    	
   				if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
   	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][6]);		
	    	    	ComSetObjValue(formObj.modify_flag,     "Y");
   	   				
   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
   						checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
   						validatePrecaution(formObj);
   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.   	
   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
   					}		
   				} else if(arrVal[0][5]=="0000"&&arrVal[0][4]!="000004"){
   					comBkgCallPop0653('callBack0653',"","");
   				} else if(arrVal[0][5]=="9901"){
   					comBkgCallPop0653('callBack0653',"","");
   				} else if(arrVal[0][4]=="000000"){
   					comBkgCallPop0653('callBack0653',"","");
   				} else {					
   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
   	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][6]);		
					ComSetObjValue(formObj.modify_flag,     "Y");   	
   	   				
   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
   						checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
   						validatePrecaution(formObj);
   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.   						
   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
   					}		
   				}
   				ComSetObjValue(formObj.route_modify_flag, "Y");
   				manageHaveRouteFlag("N");
   			}
       	}
   	}          
   	
   	function callBack1132(arrVal){
       	var formObj = document.form;
		if(arrVal != null){		
			ComSetObjValue(formObj.ctrt_ofc_cd, arrVal[0][1]);
			ComSetObjValue(formObj.ctrt_srep_cd, arrVal[0][2]);
			if(ctrt_ofc_cd_old !=  ComGetObjValue(formObj.ctrt_ofc_cd) 
					|| ctrt_srep_cd_old !=  ComGetObjValue(formObj.ctrt_srep_cd)) {
				ComSetObjValue(formObj.modify_flag, "Y");
			}
		}
   	}
   	
    /**
     * Stop Off Cargo Order 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0658(callback_func);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0658(callback_func){
    	ComOpenPopup("ESM_BKG_0658.do?pgmNo=ESM_BKG_0658",540, 300, callback_func,"1,0,1,1,1", true);
    }               

     /**
      * Stop Off Cargo 화면 호출후 Return받는 함수. <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0658(arrBal);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */    
 	function callBack0658(arrVal){
 		var formObj = document.form;    	 
 		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     		
 			if(arrVal != null){
 				ComSetObjValue(formObj.stop_off_loc_cd, arrVal[0]);
 				ComSetObjValue(formObj.stop_off_cntc_phn_no, arrVal[1]);
 				ComSetObjValue(formObj.stop_off_cntc_pson_nm, arrVal[2]);
 				ComSetObjValue(formObj.stop_off_diff_rmk, arrVal[3]);
 				
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.stop_off_flg, "Y");
 				
 				changeObjectColor("Y", "Y", "btn_t1StopOffCargo", "blue", "btn2");	    	
 				
 			}else{
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.stop_off_flg, "N");
 				
 				changeObjectColor("N", "Y", "btn_t1StopOffCargo", "blue", "btn2");			
 			}
 		}
 	}   
 	
    /**
     * Fumigation 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop1181(callback_func);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 
     * @version 2014.07.15
     */
    function comBkgCallPop1181(callback_func){
    	ComOpenPopup("ESM_BKG_1181.do?pgmNo=ESM_BKG_1181",540, 300, callback_func,"1,0,1,1,1", true);
    }               

     /**
      * Fumigation 화면 호출후 Return받는 함수. <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack1181(arrBal);
      * </pre>
      * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
      * @return 없음
      * @author 
      * @version 2014.07.15
      */    
 	function callBack1181(arrVal){
 		var formObj = document.form;    	 
 		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){     		
 			if(arrVal != null){
 				ComSetObjValue(formObj.fumg_loc_cd, arrVal[0]);
 				ComSetObjValue(formObj.fumg_cntc_phn_no, arrVal[1]);
 				ComSetObjValue(formObj.fumg_cntc_pson_nm, arrVal[2]);
 				ComSetObjValue(formObj.fumg_diff_rmk, arrVal[3]);
 				
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.fumg_flg, "Y");
 				
 				changeObjectColor("Y", "Y", "btn_t1Fumigation", "blue", "btn2");	    	
 				
 			}else{
 				ComSetObjValue(formObj.modify_flag, "Y");   	
 				ComSetObjValue(formObj.fumg_flg, "N");
 				
 				changeObjectColor("N", "Y", "btn_t1Fumigation", "blue", "btn2");			
 			}
 		}
 	} 	
     
    /**
     * Direct NVO-AMS File No 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0744(callback_func,bkgNo,caFlg,bdrFlg);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0744(callback_func, bkgNo,  caFlg, bdrFlg){
    	ComOpenPopup("ESM_BKG_0744.do?pgmNo=ESM_BKG_0744&bkg_no="+bkgNo+"&ca_flg="+caFlg + "&bdr_flg="+bdrFlg, 415, 375, callback_func,"1,0,1,1,1", true);
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
    	 if(ComGetObjValue(formObj.isInquiry) == "Y"){
    		 rtnValue = ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=A&bkg_no="+ComGetObjValue(formObj.bkg_no), 800, 445, callback_func,"1,0,1,1,1", true);
    	 }else{
    		 rtnValue = ComOpenPopup("ESM_BKG_0890.do?pgmNo=ESM_BKG_0890&callTp=B&auto_flg="+autoFlag+"&callSheetIdx1=3&callSheetIdx2=0"+url, 800, 445, callback_func,"1,0,1,1,1", true);
    	 }   	 
    	 
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
	            window.event.srcElement.setAttribute("name","btn_t1Save");
	            processButtonClick();  
	  		}
  		}
  	}   
  	
    /**
     * Service Mode & Route 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0972(callback_func,bkg_no);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0972(callback_func, bkgNo){
    	ComOpenPopup("ESM_BKG_0972.do?pgmNo=ESM_BKG_0972&bkg_no="+bkgNo,800, 210, callback_func,"1,0,1,1,1", true);
    }       

    /**
     * Constraint 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0998(callback_func,bkgNo);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0998(callback_func, bkgNo){
   		var formObj = document.form;
// 2012.03.20 이수진 [CHM-201216170] Network Constraint 기능보완
//		var url = "ESD_PRD_0082.do?f_cmd="+SEARCHLIST+"&pctl_no="+ComGetObjValue(formObj.pctl_no);
//		ComOpenPopup(url, 755, 480, "",	"1,0,1,1,1", true);
   		fnPopConstraintDetail(ComGetObjValue(formObj.pctl_no));
//break;	
//    	ComOpenPopup("ESM_BKG_0998.do?pgmNo=ESM_BKG_0998&bkg_no="+bkgNo, 930, 270, callback_func,"1,0,1,1,1", true);
    }        

    /**
     * Remark Template 팝업 호출. <br>
     * <br><b>Example :</b>
     * <pre>
     *     comBkgCallPop0976(callback_func);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function comBkgCallPop0976(callback_func){
    	ComOpenPopup("ESM_BKG_0976.do?pgmNo=ESM_BKG_0976", 800, 340, callback_func,"0,1,1,1,1", true);
    }        
   	
     /**
      * Remark Template 팝업에서 전달받은 값 저장 <br>
      * <br><b>Example :</b>
      * <pre>
      *     callBack0976(rArray);
      * </pre>
      * @param Popup에서 전달받은 값
      * @return 없음
      * @author 김병규
      * @version 2009.05.14
      */
     function callBack0976(rArray){    	
     	var formObj = document.form;
     	var interRmk = ComGetObjValue(formObj.inter_rmk);
     	var xterRmk = ComGetObjValue(formObj.xter_rmk);
     	if(rArray != null){
//     		Internal,External 구분 : rArray[0][2];
//     		값 : rArray[0][4];
     		for(i = 0 ; i < rArray.length ; i++){
     			if(rArray[i][2] == "I"){
     				if(ComIsNull(interRmk)){
     					interRmk = rArray[i][4];
     				}else{
     					interRmk = interRmk + "\n" + rArray[i][4];
     				}     				
     			}else{
     				if(ComIsNull(xterRmk)){
     					xterRmk = rArray[i][4];
     				}else{
     					xterRmk = xterRmk + "\n" + rArray[i][4];
     				}
     			}
     		}     		
     		ComSetObjValue(formObj.inter_rmk, interRmk);
     		ComSetObjValue(formObj.xter_rmk, xterRmk);    		
     		
     		ComSetObjValue(formObj.modify_flag, "Y");
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
//	  			ComSetObjValue(formObj.taa_no_old, arrVal[0][5]);
	  			
	  			ComSetObjValue(formObj.modify_flag,      "Y");   	
	  			ComSetObjValue(formObj.ctrt_modify_flag, "Y");
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
   		    	var scpCd = arrVal[0][5];
   		    	//taa에는 적용하지 않음
//   				if(scpCd =="TPE"|| scpCd =="ACE"|| scpCd =="MXE"){
//   					ComSetObjValue(formObj.cmdt_cd, arrVal[0][4]);
//   					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
//   						validatePrecaution(formObj);
//   	    	    		checkNigeriaCmdt(formObj.bkg_pod_cd.value, formObj.bkg_del_cd.value);
//   						
//   						ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.		
//   						ComSetObjValue(formObj.modify_flag,     "Y");   	
//   						
//   						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][4]);	
//   					}		
//   				} else 
   				if(arrVal[0][1]=="000004"){
					ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);		
					ComSetObjValue(formObj.modify_flag,     "Y");   
					
					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
						checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
						validatePrecaution(formObj);
//							ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.						
						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
					}
				} else if(arrVal[0][6] == "0000"||arrVal[0][1]=="000000"){
					comBkgCallPop0653('callBack0653',"","");
				} else if(arrVal[0][6] == "9901"){
					comBkgCallPop0653('callBack0653',"","");
				} else if(arrVal[0][3] == "REP"){
					comBkgCallPop0653('callBack0653',"",arrVal[0][1]);					
				} else {			
					ComSetObjValue(formObj.cmdt_cd, arrVal[0][1]);
	   				ComSetObjValue(formObj.scp_from_ctrt, arrVal[0][5]);		
					ComSetObjValue(formObj.modify_flag,     "Y");   
		
					if(ComGetObjValue(formObj.cmdt_cd) != ComGetObjValue(formObj.cmdt_cd_old)){
						checkUsVehicleCmdt(formObj.bkg_pol_cd.value);
						validatePrecaution(formObj);
//							ComSetObjValue(formObj.validPrecaution, "Y");	// Precaution Uncheck시 Validation용.
						ComSetObjValue(formObj.cmdt_cd_old, arrVal[0][1]);
					}
				}	
   				ComSetObjValue(formObj.route_modify_flag, "Y");
   				manageHaveRouteFlag("N");
			}
    	}
	}    
	
    /**
     * Customer Inquiry(공통Popup) 호출후 Return받는 함수. <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackEsmBkg1159(arrBal);
     * </pre>
     * @param {string} 팝업 값 select시 호출되어져야 할 self func,ref sheet index 입력 
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */    	
    function callBackEsmBkg1159(rArray){
   		var formObj = document.form;
   		if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	   		if(rArray != null){
		    	ComSetObjValue(formObj.c_cust_cnt_cd, rArray[0][5].substring(0,2));
	   			ComSetObjValue(formObj.c_cust_seq, ComLpad(rArray[0][5].substring(2),6,"0"));
	   			ComSetObjValue(formObj.c_cust_nm, rArray[0][6]);
	   			
	   			ComSetObjValue(formObj.modify_flag, "Y");   	
		    	ComSetObjValue(formObj.customer_modify_flag, "Y");		
	   			
	    		// 20100113 추가
	    		if(ComGetObjValue(formObj.c_cust_exist_flg) == "Y"){
	    			if(ComGetObjValue(formObj.c_cust_cnt_cd) != ComGetObjValue(formObj.c_cust_cnt_cd_old) || ComGetObjValue(formObj.c_cust_seq) != ComLpad(ComGetObjValue(formObj.c_cust_seq_old),6,"0")){
	    				if(ComShowCodeConfirm("BKG00343")){
	    					ComSetObjValue(formObj.c_cust_subst_flg, "Y");
	    				}else{
	    					ComSetObjValue(formObj.c_cust_subst_flg, "N");
	    				}
	    			}
	    		}    			   			
	   		}  		    	 
   		}
	}	

 	/**
     * CA Reason 후속 처리 : CaReasonModify
     */ 
     function setCAReasonCallBack(arrPopupData) {
         var formObj = document.form;
           
     	//01. CA ReasonCd, Remark 입력정보 받아서,
     	var strRsnCd  = nullToBlank(arrPopupData[0][2]);
     	var strRemark = nullToBlank(arrPopupData[0][3]);
         
     	//02. modifyCaReason(e) call
         formObj.ca_rsn_cd.value = strRsnCd;
         formObj.ca_remark.value = strRemark;
    }
     
 	// ESD_PRD_018 호출후 Return 받는값.(PCTL_NO)
 	function callBackEsdPrd0080(pctlNo){
 		var formObj = document.form;
 		if(ComIsNull(pctlNo)){
 			pctlNo = ""; 			
 		    manageHaveRouteFlag("N");
 		} else {
 			ComSetObjValue(formObj.pctl_no,pctlNo);
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

	    if(ComGetObjValue(formObj.isInquiry) == "N"){
		    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?sc_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&sc_no="+formObj.sc_no.value+"&ctrtType=" + ctrtType);
		    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
		    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){
		        ComOpenWindowCenter("ESM_PRI_0087.do?sc_no="+ctrtNo+"&amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
		    }    
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
	   
	    if(ComGetObjValue(formObj.isInquiry) == "N"){
		    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?rfa_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&rfa_no="+formObj.rfa_no.value+"&ctrtType=" + ctrtType);
		    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
		    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){
		        if(ctrtNo.substring(5,6)=="G" || ctrtNo.substring(5,6)=="M" ){
		        	ComOpenWindowCenter("ESM_PRI_2120.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
		        }else{ // 일반, Basic
		        	ComOpenWindowCenter("ESM_PRI_2020.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
		        }
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

	    if(ComGetObjValue(formObj.isInquiry) == "N"){
		    var sXml = sheetObjects[2].GetSearchXml("ESM_BKG_0000GS.do?taa_no="+ctrtNo, "f_cmd="+SEARCH10+"&bkg_no="+formObj.bkg_no.value+"&taa_no="+formObj.taa_no.value+"&ctrtType=" + ctrtType);
		    var amdtSeq = ComGetEtcData(sXml,"amdt_seq");
		    if(validatePriPopUp(ctrtType, ctrtNo, amdtSeq)){	
		        ComOpenWindowCenter("ESM_PRI_3019.do?taa_no="+ctrtNo+"&amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
			} 
	    }
	}    

	// POD/POL 편집시
	function setPolPodClptIndSeq() {
		var sheetObj = sheetObjects[1];
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

	function bkgChgOfcSheet_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			var formObj = document.form;
			var isSearch = true;
			if (1 < sheetObj.Rows && ComGetObjValue(formObj.is_rated_flg)=="Y") {
				var afOfc1 = sheetObj.CellValue(1,"ppd_rcv_ofc_cd");
				var afOfc2 = sheetObj.CellValue(1,"clt_ofc_cd");
				var bfOfc1 = sheetObj.CellValue(1,"bf_ppd_rcv_ofc_cd");
				var bfOfc2 = sheetObj.CellValue(1,"bf_clt_ofc_cd");
				if (afOfc1!=bfOfc1 || afOfc2!=bfOfc2) {
					var callFlg = false;
					callFlg = ""==bfOfc1 && ""==bfOfc2;  //OLD OFC CD 가 없는 경우 true
					if (!callFlg) {
						if (ComShowCodeConfirm2("BKG02080",[bfOfc1,bfOfc2,afOfc1,afOfc2])) {  // OFC CD 변경 confirm
							callFlg = true;
						}
					}
					if (callFlg) {
						isSearch = false;
						doActionIBSheet(sheetObj, document.form, MODIFY07);
					}
				}
			}else if (1 < sheetObj.Rows && ComGetObjValue(formObj.is_rated_flg)=="N"){ // BKG_CHG_RT 에 값 없으면 물어보지 않고 바로 새걸로 저장
                isSearch = false;
				doActionIBSheet(sheetObj, document.form, MODIFY07);
            }
	
//			if (isSearch) {
//				doActionIBSheet(sheetObjects[2], document.form, SEARCH);
//			}
		}
	}

	/**
	* Remark 글자 수 제한. 
	* 4000 자 이상 입력될 시에 자르고 코드 메시지 호출
	*/
	function  obj_keyup(){   
		var xterRmk = document.form.xter_rmk.value.length;
		var interRmk = document.form.inter_rmk.value.length;
		var newCustAproRmk = document.form.new_cust_apro_rmk.value.length;
		
		if(xterRmk > 4000){
			ComShowCodeMessage("BKG01137","4000");
			document.form.xter_rmk.value = document.form.xter_rmk.value.substring(0, 4000);    		
		}
		if(interRmk > 4000){
			ComShowCodeMessage("BKG01137","4000");
			document.form.inter_rmk.value = document.form.inter_rmk.value.substring(0, 4000);    		
		}
		if(newCustAproRmk > 500){
			ComShowCodeMessage("BKG01137","500");
			document.form.new_cust_apro_rmk.value = document.form.new_cust_apro_rmk.value.substring(0, 500);    		
		}
	}

	function chkCustomer(formObj){
		// 20091130 Customer Inquiry Popup 조건 변경 (L.OFC,L.REP 둘다 미존재시 팝업)	
		if(ComIsNull(formObj.ob_sls_ofc_cd) || ComIsNull(formObj.ob_srep_cd)){
	//		ComShowCodeMessage("BKG00337");
			if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))){			
				comBkgCallPop0652('callBack0652','F', ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "");
			} else {
				comBkgCallPop0652('callBack0652','S', ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "");
			}  
			if(ComIsNull(formObj.s_cust_nm)){
				return false;
			} 	
		}else{		
			/* 20110609  
			 * 이전 커스터머 정보와 비교하여  변경 됐을경우 저장시 팝업화면을 보여줘서 L.REP 변경
			 * s_cust_cnt_cd_old, s_cust_seq_old를 각각 s_cust_cnt_cd, s_cust_seq와 비교
			 * f_cust_cnt_cd_old, f_cust_seq_old를 각각 f_cust_cnt_cd, f_cust_seq와 비교하여
			 * 네개 중에 하나라도 다를 경우 
			 */
			 
			//check FWDR OLD	
	        if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd_old))) {
	        	//check FWDR NULL
	        	if(ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))) {
	        		//check FWDR NEW	
                	if((ComGetObjValue(formObj.f_cust_cnt_cd_old) != ComGetObjValue(formObj.s_cust_cnt_cd) || ComGetObjValue(formObj.f_cust_seq_old) != ComGetObjValue(formObj.s_cust_seq)))  {
	                	comBkgCallPop0652('callBack0652','S', ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "");
	                }	 
	        	} else {
	                 //check FWDR DIFF	
	                if((ComGetObjValue(formObj.f_cust_cnt_cd_old) != ComGetObjValue(formObj.f_cust_cnt_cd) || ComGetObjValue(formObj.f_cust_seq_old) != ComGetObjValue(formObj.f_cust_seq)) ) {
	                	comBkgCallPop0652('callBack0652','F', ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "");
	                }	        		 
	        	}
	        }else if(!ComIsNull(ComGetObjValue(formObj.s_cust_cnt_cd_old))){	
                //check FWDR NEW	
                if(!ComIsNull(ComGetObjValue(formObj.f_cust_cnt_cd))) {	
                	if((ComGetObjValue(formObj.s_cust_cnt_cd_old) != ComGetObjValue(formObj.f_cust_cnt_cd) || ComGetObjValue(formObj.s_cust_seq_old) != ComGetObjValue(formObj.f_cust_seq)))  {
                       comBkgCallPop0652('callBack0652','F', ComGetObjValue(formObj.f_cust_cnt_cd), ComGetObjValue(formObj.f_cust_seq), "");
                	}    
                }
                //check SHPR DIFF	
	            else if (ComGetObjValue(formObj.s_cust_cnt_cd_old) != ComGetObjValue(formObj.s_cust_cnt_cd) || ComGetObjValue(formObj.s_cust_seq_old) != ComGetObjValue(formObj.s_cust_seq)) {
	            	comBkgCallPop0652('callBack0652','S', ComGetObjValue(formObj.s_cust_cnt_cd), ComGetObjValue(formObj.s_cust_seq), "");
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
	* @version 2011.11.09
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
	 * constraint 팝업 호출
	 * 2012.03.20 이수진 [CHM-201216170] Network Constraint 기능보완
	 * @param formObj
	 * @return
	 */
	function fnPopConstraintDetail(pctlNo){
		var newForm  = "<form name='form_prd_pop' method='post'>" ;
	   	newForm += "  <input type='hidden' name='pctl_no'       value='" + pctlNo + "'>" ;	
	   	newForm += "  <input type='hidden' name='pgmNo' value='ESD_PRD_0082'>" ;	
	   	newForm += "</form>";
	   	var prdFormObj = parent.document.getElementById("prd_form");
	   	prdFormObj.innerHTML = newForm;
	   	var formObj = document.all.form_prd_pop ;
	   	var paramUrl = "pgmNo=ESD_PRD_0082&pctl_no="+pctlNo;
	    var newWin = window.showModalDialog("ESD_PRD_0082.do?"+paramUrl, "detail", "scroll:no;status:no;resizable:yes;help:no;dialogWidth:800px;dialogHeight:450px");
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
	   * Precaution, Hide uncheck 시 stowage check
	   * 2013.01.01 조정민 
	   * @param formObj
	   * @param srcName
	   * @return
	   */
	function validateUncheck(formObj, srcName) {
		if( srcName == "prct_flg"){
			if(formObj.spcl_hide_flg.checked && formObj.validPrecaution.value != "P"){
				ComSetObjValue(formObj.stwg_cd, "ODHD");
				ComSetObjValue(formObj.stwg_flg, "Y");
			}			
//		} else if( srcName == "spcl_hide_flg") {
//			if(formObj.prct_flg.checked){
//				ComSetObjValue(formObj.stwg_cd, "PC");
//				ComSetObjValue(formObj.stwg_flg, "Y");
//			}
		}
		changeObjectColor(formObj.stwg_cd.value, "Y", "btn_t1Stowage", "blue", "btn2"); 
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
	
    /*
	    * 자동 Cargo Release 처리
	   	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
	   	*/
	   	function chagnePodCondition(){
	   	   	
		    var formObj = document.form;
		    var sheetObjCgoRlse = sheetObjects[0];
		    
		    formObj.f_cmd.value = SEARCH05;
		    var params = FormQueryString(formObj);
		    var sXml = sheetObjCgoRlse.GetSearchXml("ESM_BKG_0909GS.do", params);
		    
		    //Hold B/L 인가    
		    do_hld_flg = ComGetEtcData(sXml, "do_hld_flg");
		    
		    //CR 전송한 적이 있는가  
		    cr_chk_flg = ComGetEtcData(sXml, "cr_chk_flg");
		}
		 
	    /*
	    * 자동 Cargo Release 처리
	   	* POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
	   	*/
	   	function podChange(old_pod_cd,new_pod_cd,old_pod_yd_cd,new_pod_yd_cd){
	   	
		    var formObj = document.form;
		    var sheetObjCgoRlse = sheetObjects[0];
		    var bl_no = formObj.bl_no.value;
		       		
		    //HOLD되지 않고, CR발송된 적이 있음. CR처리 가능한 조건
			if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) {
				
				formObj.f_cmd.value = MULTI02;
				var params = "?bl_no="+bl_no+"&new_pod_cd="+new_pod_cd+"&old_pod_cd="+old_pod_cd+"&new_pod_yd_cd="+new_pod_yd_cd+"&old_pod_yd_cd="+old_pod_yd_cd+"&event_id=K&"+FormQueryString(formObj);
				ComOpenWait(true);
				var sXml = sheetObjCgoRlse.GetSaveXml("ESM_BKG_0909GS.do", params) ;
				ComOpenWait(false);
					
				if ("ERROR"==sXml.substring(1,6)){
					ComShowMessage(ComResultMessage(sXml).split('<||>').join('\n'));
				} else {
					if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
						ComShowCodeMessage("BKG00166");
						return;
					}
				}
			}	
						    
	   	}					

   	/**
      * Actual Customer 에서 전달받은 값 저장 <br>
      */         	
    function callBackSa0190(rArray){    	
  		var formObj = document.form;
  		if(rArray != null){
  			ComSetObjValue(formObj.agmt_act_cnt_cd, rArray[0][0]);
  			ComSetObjValue(formObj.agmt_act_cust_seq, ComLpad(rArray[0][1],6,"0"));
  			
  			if(formObj.agmt_act_cnt_cd.value ==""){
  	    		document.getElementById("btn_t1Sa0190").style.border = "2 solid #F3F2F8";
  			}else{	
  				document.getElementById("btn_t1Sa0190").style.border = "2 solid blue";
  			}  			
  			ComSetObjValue(formObj.modify_flag, "Y");
  			ComSetObjValue(formObj.customer_modify_flag, "Y");
  			ComSetObjValue(formObj.aloc_chk_flg,"Y");
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
    
    function saveFunction(formObj, sheetObject3, bkgNo){
    	if(validateForm(formObj, COMMAND01)){    
    		
			if(formObj.data_yn.value == "Y" && formObj.bkg_no.value == ""){
				ComShowCodeMessage("BKG06126");
				ComSetFocus(formObj.bkg_no);
				return false;
			}
			
			if(formObj.ca_new_creation_flag.value == "Y"){
				formObj.ca_rsn_cd.value=null;
				comBkgCallPop0708('setCAReasonCallBack', ComGetObjValue(formObj.bkg_no), "C");
				if(ComIsNull(formObj.ca_rsn_cd.value)){
					return false;
				}
			}
			
			// save
			doActionIBSheet(sheetObject3, formObj, COMMAND01);   
			
			if(success_flag) {
				var flag = false; 
			    new_pod_cd = formObj.bkg_pod_cd.value;
			    old_pod_cd = formObj.pod_cd_old.value;
			    new_pod_yd_cd = formObj.bkg_pod_yd_cd.value;
			    old_pod_yd_cd = formObj.pod_yd_cd_old.value;

                //자동 Cargo Release 처리							
				//BOOKING CA 아닐 경우에만 실행
				if(ComGetObjValue(formObj.bdr_flg) != "Y" && ComGetObjValue(formObj.ca_flg) != "Y"){ 
					
	            	//POD가 변경되었을 경우, 기존POD로 CA가 전송가능한 지 체크
            		//Booking Creation 인경우에만
            		if(ComGetObjValue(formObj.isInquiry) == "N"){

            		    //Hold B/L 인가 , CR 전송한 적이 있는가  
    			    	chagnePodCondition();

					    //POD=US 인 경우에만 처리							
    			    	if ( ( old_pod_cd != new_pod_cd || ( old_pod_cd == new_pod_cd && new_pod_yd_cd != old_pod_yd_cd)) && ( old_pod_cd.substring(0,2) == "US" && new_pod_cd.substring(0,2) == "US")  ) {
					    	if ( do_hld_flg == "N"  && cr_chk_flg == "Y" ) {
						    	podChange(old_pod_cd,new_pod_cd,old_pod_yd_cd,new_pod_yd_cd);
					    	}
					    }
            		}
				}
				
				if(bkgNo != "" && bkgNo.length >= 11 && change_firstvvd_flag != "" && change_firstvvd_flag == "Y"){
					ComOpenPopup("ESM_BKG_0724.do?pgmNo=ESM_BKG_0724&bkg_no="+bkgNo, 1000, 450, "","0,1,1,1,1", true);
				}
				
				doActionIBSheet(sheetObject3, formObj, SEARCH);

				if(parent.t1frame != undefined && typeof(parent.t1frame) == "object") {
					if((new_pod_cd != old_pod_cd) && formObj.cntr_flg.value == 'Y'){
						parent.podChangeTabColor("Y");
					} 
				}
			}            			
			
			success_flag = false;
		}
    	
    }
	/* 개발자 작업  끝 */

