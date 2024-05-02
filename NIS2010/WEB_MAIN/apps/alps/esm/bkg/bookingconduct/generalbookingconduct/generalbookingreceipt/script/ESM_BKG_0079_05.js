/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_05.js
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.31 김병규
* 1.0 Creation
===============================================================================
* History
* 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
* 2010.10.12 전성진 [CHM-201006335] Consignee (Notify) 에 zip code와 state code 필수 로직 변경
* 2010.11.09 전성진 [CHM-201004161] EORI Validation 로직 적용
* 2010.11.22 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
* 2011.01.04 이일민 [CHM-201008007-01] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정)
* 2011.01.10 이일민 [CHM-201108147] EU24 관련 Country Code 및 EORI Code Validation 체크 로직
* 2011.01.31 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - callback시 name, address항목 추가
* 2011.02.08 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - callback시 name, address항목 제거(상단시트에서 선택시)
* 2011.02.09 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - 항목조정
* 2011.02.24 이일민 [CHM-201108576] (MDM)기능 보완요청(B/L Customer 팝업 편집 기능, 선택기능 수정) - name & address 조건 수정
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
* 2012.05.31 조정민 [CHM-201218066] [BKG] FMC No 수동 입력 불가능토록 기능 보완 요청
* 2012.07.11 조정민 [CHM-201218970] [BKG] Customer Column내 # 2개 이상 입력시 #을 공백 처리하여 Customer Name 인식하도록 보완 요청
* 2012.07.23 조정민 [CHM-201219089] [BKG] CANADA customs validatoion logic 보완 요청
* 2013.04.18 김태경 [CHM-201323821] 통합 SQL ERROR 로그 결과 복구
* 2013.04.19 최문환 [CHM-201323915] Blacklisted Customer 사용 시 Alert 강화 요청 
* 2014.11.05 문동선 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
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
     * @class ESM_BKG_0079_05 : ESM_BKG_0079_05 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0079_05() {
    	this.processButtonClick		= tprocessButtonClick;
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
    var comboObjects = new Array();
    var comboCnt = 0;     

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var isShowOrgBlNo = true;
    var isSanctionFLG = false;
    var isCNTsRoute = "";		// 중국 해관 : 중국 T/S 여부
    var isCNTsValidation = "";	// 중국 해관 : 중국 해관 관련 validation 수행 여부
    var isSISubmit = "";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/  
        var formObject = document.form;
        
 		var bkgNo = formObject.bkg_no.value;
		var blNo = formObject.bl_no.value;
		var modifyFlag = formObject.modify_flag.value;
		
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(srcName != "btn_splitPop"){
        		if(layList.style.display == ""){
        			layList.style.display="none";
        		}    	    			
    		}
            switch(srcName) {
				case "btn_splitPop":
					doActionIBSheet(sheetObject1,formObject,COMMAND03);					
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
					
				case "btn_t7Retrieve":
            		if(bkgNo != null && bkgNo.length > 0){
            			ComResetAll();
            			formObject.bkg_no.value = bkgNo;
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);            			
            		}else if(blNo != null && blNo.length > 0){
            			ComResetAll();
            			formObject.bl_no.value = blNo;
            			doActionIBSheet(sheetObject1, formObject, IBSEARCH);               			
            		}else{
						ComShowCodeMessage("BKG00255");
						ComSetFocus(formObject.bkg_no);            			
            		}
					break;

				case "btn_t7New":					
					ComResetAll();
					setCustomerEditable(true);
					break;

				case "btn_t7Save":    					
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;

				case "btn_t7CustomerCodeRqst":
					var url = "ESM_BKG_0957.do?pgmNo=ESM_BKG_0957&bkg_no="+formObject.bkg_no.value;
					url = url + "&bl_no="+formObject.bl_no.value;
					url = url + "&bl_no_tp="+formObject.bl_no_tp.value;
					url = url + "&bl_tp_cd="+formObject.bl_tp_cd.value;
					url = url + "&sh_cust_cnt_cd="+formObject.sh_cust_cnt_cd.value;
					url = url + "&sh_cust_seq="+formObject.sh_cust_seq.value;
					//url = url + "&sh_cust_tp_cd="+formObject.sh_cust_tp_cd.value;
					url = url + "&sh_cust_nm="+formObject.sh_cust_nm.value;
					url = url + "&sh_cust_addr="+formObject.sh_cust_addr.value;
					url = url + "&sh_cust_cty_nm="+formObject.sh_cust_cty_nm.value;
					url = url + "&sh_cust_ste_cd="+formObject.sh_cust_ste_cd.value;
					url = url + "&sh_cstms_decl_cnt_cd="+formObject.sh_cstms_decl_cnt_cd.value;
					url = url + "&sh_cust_zip_id="+formObject.sh_cust_zip_id.value;
					url = url + "&cn_cust_cnt_cd="+formObject.cn_cust_cnt_cd.value;
					url = url + "&cn_cust_seq="+formObject.cn_cust_seq.value;
					//url = url + "&cn_cust_tp_cd="+formObject.cn_cust_tp_cd.value;
					url = url + "&cn_cust_nm="+formObject.cn_cust_nm.value;
					url = url + "&cn_cust_addr="+formObject.cn_cust_addr.value;
					url = url + "&cn_cust_cty_nm="+formObject.cn_cust_cty_nm.value;
					url = url + "&cn_cust_ste_cd="+formObject.cn_cust_ste_cd.value;
					url = url + "&cn_cstms_decl_cnt_cd="+formObject.cn_cstms_decl_cnt_cd.value;
					url = url + "&cn_cust_zip_id="+formObject.cn_cust_zip_id.value;    					
					url = url + "&cn_cust_fax_no="+formObject.cn_cust_fax_no.value;
					url = url + "&cn_cust_eml="+formObject.cn_cust_eml.value;					
					url = url + "&nf_cust_cnt_cd="+formObject.nf_cust_cnt_cd.value;
					url = url + "&nf_cust_seq="+formObject.nf_cust_seq.value;
					//url = url + "&nf_cust_tp_cd="+formObject.nf_cust_tp_cd.value;
					url = url + "&nf_cust_nm="+formObject.nf_cust_nm.value;
					url = url + "&nf_cust_addr="+formObject.nf_cust_addr.value;
					url = url + "&nf_cust_cty_nm="+formObject.nf_cust_cty_nm.value;
					url = url + "&nf_cust_ste_cd="+formObject.nf_cust_ste_cd.value;
					url = url + "&nf_cstms_decl_cnt_cd="+formObject.nf_cstms_decl_cnt_cd.value;
					url = url + "&nf_cust_zip_id="+formObject.nf_cust_zip_id.value;    					
					url = url + "&nf_cust_fax_no="+formObject.nf_cust_fax_no.value;
					url = url + "&nf_cust_eml="+formObject.nf_cust_eml.value;

					ComOpenPopup(url,300, 260, "","1,0,1,1,1", true);
					break;

				case "btn_t7EDIRemark":
					break;
					
				case "btn_t7Sa0190":   
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}
					var scNo = formObject.sc_no.value;
					var rfaNo =formObject.rfa_no.value;
					var svcScpCd = formObject.svc_scp_cd.value;
					ComOpenPopup("ESM_BKG_0190.do?pgmNo=ESM_BKG_0190&bkg_no="+formObject.bkg_no.value+"&sc_no="
							+scNo+"&rfa_no="+rfaNo+"&svc_scp_cd="+svcScpCd+"&app_dt="+ formObject.appl_dt.value
							,800, 390, "callBackSa0190","1,0,1,1,1", true);					
					break;        
					
				case "btn_t7Sh0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = ComGetObjValue(formObject.sh_cust_cnt_cd);
					var custSeq = ComGetObjValue(formObject.sh_cust_seq);
					var custNm = "";
					var custAddr = "";
					if(ComChkLen(formObject.sh_cust_nm) != 1){
						custNm = ComGetObjValue(formObject.sh_cust_nm).substring(0,10);
					}else{
						custNm = ComGetObjValue(formObject.sh_cust_nm);
					}
					if(ComChkLen(formObject.sh_cust_addr) != 1){
						custAddr = ComGetObjValue(formObject.sh_cust_addr).substring(0,10);
					}else{
						custAddr = ComGetObjValue(formObject.sh_cust_addr);
					}    					
					var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";
					url = url.replace(/#/g,' ');
					ComOpenPopup(url,970, 655, "callBackSh0192","0,0,1,1,1", false);
					break;    	
					
				case "btn_t7Cn0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.cn_cust_cnt_cd.value;
					var custSeq = formObject.cn_cust_seq.value;
					var custNm = "";
					var custAddr = "";
					if(ComChkLen(formObject.cn_cust_nm) != 1){
						custNm = ComGetObjValue(formObject.cn_cust_nm).substring(0,10);
					}else{
						custNm = ComGetObjValue(formObject.cn_cust_nm);
					}
					if(ComChkLen(formObject.cn_cust_addr) != 1){
						custAddr = ComGetObjValue(formObject.cn_cust_addr).substring(0,10);
					}else{
						custAddr = ComGetObjValue(formObject.cn_cust_addr);
					}    					
					var url = ""; 					   					
					if(ComGetObjValue(formObject.cust_to_ord_flg) != "Y"){
						url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&indiv_dp_flg=Y&indiv_pson_flg="+ComGetObjValue(formObject.indiv_pson_flg)+"&cust_addr=";   
					}else{
						url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
					}
					url = url.replace(/#/g,' ');
					ComOpenPopup(url,970, 655, "callBackCn0192","0,0,1,1,1", false);
					break;    	
					
				case "btn_t7Nf0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}
					var custCntCd = formObject.nf_cust_cnt_cd.value;
					var custSeq = formObject.nf_cust_seq.value;
					var custNm = "";
					var custAddr = "";
					if(ComChkLen(formObject.nf_cust_nm) != 1){
						custNm = ComGetObjValue(formObject.nf_cust_nm).substring(0,10);
					}else{
						custNm = ComGetObjValue(formObject.nf_cust_nm);
					}
					if(ComChkLen(formObject.nf_cust_addr) != 1){
						custAddr = ComGetObjValue(formObject.nf_cust_addr).substring(0,10);
					}else{
						custAddr = ComGetObjValue(formObject.nf_cust_addr);
					}    			 	
					var url = ""; 
					if(ComGetObjValue(formObject.cust_to_ord_flg) == "Y"){
						url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&indiv_dp_flg=Y&indiv_pson_flg="+ComGetObjValue(formObject.indiv_pson_flg)+"&cust_addr=";   
					}else{
						url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm+"&cust_addr=";    					
					}
					
					url = url.replace(/#/g,' ');
					ComOpenPopup(url,970, 655, "callBackNf0192","0,0,1,1,1", true);
					break;  
					
				case "btn_t7Ff0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.ff_cust_cnt_cd.value;
					var custSeq = formObject.ff_cust_seq.value;
   					var custNm = "";
					if(ComChkLen(formObject.ff_cust_nm) != 1){
						custNm = ComGetObjValue(formObject.ff_cust_nm).substring(0,10);
					}else{
						custNm = ComGetObjValue(formObject.ff_cust_nm);
					}
					var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    					
					url = url.replace(/#/g,' ');
					ComOpenPopup(url,970, 655, "callBackFf0192","0,0,1,1,1", true);
					break;   
					
				case "btn_t7An0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.an_cust_cnt_cd.value;
					var custSeq = formObject.an_cust_seq.value;
   					var custNm = "";
					if(ComChkLen(formObject.an_cust_nm) != 1){
						custNm = ComGetObjValue(formObject.an_cust_nm).substring(0,10);
					}else{
						custNm = ComGetObjValue(formObject.an_cust_nm);
					}
					var url = "ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&cust_nm="+custNm;    		    					
					url = url.replace(/#/g,' ');
					ComOpenPopup(url,970, 655, "callBackAn0192","0,0,1,1,1", true);
					break;   
					
				case "btn_t7Ex0192":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.ex_cust_cnt_cd.value;
					var custSeq = formObject.ex_cust_seq.value;
					ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq,970, 655, "callBackEx0192","0,0,1,1,1", true);
					break; 
					
				case "btn_t7ShMdmCustNm":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.sh_cust_cnt_cd.value;
					var custSeq = formObject.sh_cust_seq.value;
					var custNm = formObject.sh_cust_nm.value;
					var custAddress = formObject.sh_cust_addr.value;
					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
							if(ComShowCodeConfirm("BKG00343")){
								formObject.sh_cust_nm.value = getMakeBrData("NAME",formObject.sh_cust_lgl_eng_nm.value);
								formObject.sh_cust_addr.value = getMakeBrData("ADDR",formObject.sh_mdm_address.value); 
							}
						}else{
							formObject.sh_cust_nm.value = getMakeBrData("NAME",formObject.sh_cust_lgl_eng_nm.value);
							formObject.sh_cust_addr.value = getMakeBrData("ADDR",formObject.sh_mdm_address.value); 
						}
						if (formObject.pod_cd.value.substring(0,2)=="IN") {
							formObject.sh_eori_no.value = formObject.sh_ida_gst_rgst_no.value;
						} else if (formObject.pod_cd.value.substring(0,2)=="CN") {
							formObject.sh_eori_no.value = formObject.sh_co_chn_no.value;
						}
					}else{
						ComShowCodeMessage("BKG00340");
					}
					break;   
					
				case "btn_t7CnMdmCustNm":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.cn_cust_cnt_cd.value;
					var custSeq = formObject.cn_cust_seq.value;
					var custNm = formObject.cn_cust_nm.value;
					var custAddress = formObject.cn_cust_addr.value;
					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
							if(ComShowCodeConfirm("BKG00343")){
								formObject.cn_cust_nm.value = getMakeBrData("NAME",formObject.cn_cust_lgl_eng_nm.value);
								formObject.cn_cust_addr.value = getMakeBrData("ADDR",formObject.cn_mdm_address.value); 
							}
						}else{
							formObject.cn_cust_nm.value = getMakeBrData("NAME",formObject.cn_cust_lgl_eng_nm.value);
							formObject.cn_cust_addr.value = getMakeBrData("ADDR",formObject.cn_mdm_address.value); 
						}
						if (formObject.pod_cd.value.substring(0,2)=="IN") {
							formObject.cn_eori_no.value = formObject.cn_ida_gst_rgst_no.value;
						} else if (formObject.pod_cd.value.substring(0,2)=="CN") {
							formObject.cn_eori_no.value = formObject.cn_co_chn_no.value;
						}
					}else{
						ComShowCodeMessage("BKG00340");
					}
					break;   
					
				case "btn_t7NfMdmCustNm":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.nf_cust_cnt_cd.value;
					var custSeq = formObject.nf_cust_seq.value;
					var custNm = formObject.nf_cust_nm.value;
					var custAddress = formObject.nf_cust_addr.value;
					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
						if(!ComIsNull(custNm) || !ComIsNull(custAddress)){
							if(ComShowCodeConfirm("BKG00343")){
								formObject.nf_cust_nm.value = getMakeBrData("NAME",formObject.nf_cust_lgl_eng_nm.value);
								formObject.nf_cust_addr.value = getMakeBrData("ADDR",formObject.nf_mdm_address.value); 
							}
						}else{
							formObject.nf_cust_nm.value = getMakeBrData("NAME",formObject.nf_cust_lgl_eng_nm.value);
							formObject.nf_cust_addr.value = getMakeBrData("ADDR",formObject.nf_mdm_address.value); 
						}
						if (formObject.pod_cd.value.substring(0,2)=="IN") {
							formObject.nf_eori_no.value = formObject.nf_ida_gst_rgst_no.value;
						} else if (formObject.pod_cd.value.substring(0,2)=="CN") {
							formObject.nf_eori_no.value = formObject.nf_co_chn_no.value;
						}
					}else{
						ComShowCodeMessage("BKG00340");
					}
					break;   
					
				case "btn_t7FfMdmCustNm":
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.ff_cust_cnt_cd.value;
					var custSeq = formObject.ff_cust_seq.value;
					var custNm = formObject.ff_cust_nm.value;
					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
						if(!ComIsNull(custNm)){
							if(ComShowCodeConfirm("BKG00343")){    								
								if(ComIsNull(formObject.ff_cust_lgl_eng_nm.value)){
									formObject.ff_cust_nm.value = getMakeBrData("ADDR",formObject.ff_mdm_address.value);
								}else{
									if(!ComIsNull(formObject.ff_mdm_address.value)){
										formObject.ff_cust_nm.value = getMakeBrData("NAME",formObject.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.ff_mdm_address.value); 
									}
								}
							}
						}else{
							if(ComIsNull(formObject.ff_cust_lgl_eng_nm.value)){
								formObject.ff_cust_nm.value = getMakeBrData("ADDR",formObject.ff_mdm_address.value);
							}else{
								if(!ComIsNull(formObject.ff_mdm_address.value)){
									formObject.ff_cust_nm.value = getMakeBrData("NAME",formObject.ff_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.ff_mdm_address.value); 
								}
							}
						}
					}else{
						ComShowCodeMessage("BKG00340");
					}
					break; 
					
				case "btn_t7AnMdmCustNm":    		
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var custCntCd = formObject.an_cust_cnt_cd.value;
					var custSeq = formObject.an_cust_seq.value;
					var custNm = formObject.an_cust_nm.value;
					if (ComChkLen(custCntCd, 2) == "2" && !ComIsNull(custSeq)){
						if(!ComIsNull(custNm)){
							if(ComShowCodeConfirm("BKG00343")){
								if(ComIsNull(formObject.an_cust_lgl_eng_nm.value)){
									formObject.an_cust_nm.value = getMakeBrData("ADDR",formObject.an_mdm_address.value);
								}else{
									if(!ComIsNull(formObject.an_mdm_address.value)){
										formObject.an_cust_nm.value = getMakeBrData("NAME",formObject.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.an_mdm_address.value); 
									}
								}
							}
						}else{
							if(ComIsNull(formObject.an_cust_lgl_eng_nm.value)){
								formObject.an_cust_nm.value = getMakeBrData("ADDR",formObject.an_mdm_address.value);
							}else{
								if(!ComIsNull(formObject.an_mdm_address.value)){										
									formObject.an_cust_nm.value = getMakeBrData("NAME",formObject.an_cust_lgl_eng_nm.value) + "\n" + getMakeBrData("ADDR",formObject.an_mdm_address.value); 
								}
							}
						}
					}else{
						ComShowCodeMessage("BKG00340");
					}
					break;  
					
				case "btn_t7FwRefNo":    	
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var ffRefNo = formObject.ff_ref_no.value;
					if(!ComIsNull(ffRefNo)){
						var exCustNm = formObject.ex_cust_nm.value;
						if(ComIsNull(exCustNm)){
							formObject.ex_cust_nm.value = ffRefNo;
						}else{
							if(countLineBreaks(exCustNm) >= 2){
								ComShowCodeMessage("BKG00381");
							}else{
								formObject.ex_cust_nm.value = exCustNm + "\n" + ffRefNo;
							}
						}
					}
					break;    
					
				case "btn_t7Delete":    	
					if(ComGetObjValue(formObject.bdr_flg) == "Y" && ComGetObjValue(formObject.ca_flg) == "N"){
						break;
					}    					
					var agmtActCustCntCd = formObject.agmt_act_cnt_cd.value;
					if(!ComIsNull(agmtActCustCntCd)){
						formObject.agmt_act_cnt_cd.value = "";
						formObject.agmt_act_cust_seq.value = "";
					}
					break;    

				case "btn_t7ShZipCode":
					var zip_cd = formObject.sh_cust_zip_id.value;
					var cnt_cd = formObject.sh_cust_cnt_cd.value;
					ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
							,800, 600, "callBackShZipCode","1,0,1,1,1", true);			
					break;
					
				case "btn_t7CnZipCode":
					var zip_cd = formObject.cn_cust_zip_id.value;
					var cnt_cd = formObject.cn_cust_cnt_cd.value;
					ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
							,800, 600, "callBackCnZipCode","1,0,1,1,1", true);			
					break;
					
				case "btn_t7NfZipCode":
					var zip_cd = formObject.nf_cust_zip_id.value;
					var cnt_cd = formObject.nf_cust_cnt_cd.value;
					ComOpenPopup("/hanjin/ESM_BKG_1114_Q.do?mainPage=false&zip_cd="+zip_cd+"&cnt_cd="+cnt_cd
							,800, 600, "callBackNfZipCode","1,0,1,1,1", true);			
					break;				
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        
   	    // IBMultiCombo초기화
   	    for(var j=0; j<comboObjects.length; j++){
   	        initCombo(comboObjects[j]);
   	    }     
   	    
        var formObj = document.form;
        if(formObj.old_bkg_no.value != ""){ 
        	formObj.bkg_no.value = formObj.old_bkg_no.value;
        	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH)
        } else {
			ComSetFocus(formObj.bkg_no);
        }
		if(ComGetObjValue(formObj.isInquiry) == "Y"){
			ComBtnDisable("btn_t7Save");
			ComBtnDisable("btn_t7CustomerCodeRqst");
		}				
        initControl();
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
   
	function initControl() {
		var formObject = document.form;
		
		axon_event.addListenerFormat('keypress','bkg007905_keypress',formObject); //- 키보드 입력할때
		axon_event.addListenerForm  ('beforedeactivate', 'bkg007905_deactivate',  formObject); //- 포커스 나갈때     
		axon_event.addListenerForm('click', 'bkg007905_click',    formObject); //- 클릭시
		axon_event.addListenerForm('change', 'bkg007905_change',    formObject); //- 클릭시

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
			case "t7sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
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
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					var HeadTitle = "|";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtData,			35,     daCenter,   false,  "chk");	
					CountPosition = 0;	
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
		//sheetObj.ShowDebugMsg = 1;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(ComIsNull(formObj.bkg_no.value) && ComIsNull(formObj.bl_no.value)){
					ComShowCodeMessage("BKG00426");
					return false; 					
				}
				formObj.f_cmd.value = SEARCH;
				sheetObj.WaitImageVisible=false;
				
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH+"&bkg_no="+formObj.bkg_no.value+"&bl_no="+formObj.bl_no.value);
				ComOpenWait(false); //대기창 사라짐 
				
				var arrXml = sXml.split("|$$|");
        		// Combo 셋팅
				if (arrXml.length > 0){	
    				//ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
    				ComXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
    				sheetObj.LoadSearchXml(arrXml[0]);
				}   				
				BkgEtcDataXmlToForm(arrXml[0], formObj);		// Booking Customer 정보
				formObj.indiv_pson_flg.value = ComGetEtcData(arrXml[0],"indiv_pson_flg");
								
				formObj.old_bkg_no.value = ComGetEtcData(arrXml[0],"bkg_no");
				formObj.old_bl_no.value = ComGetEtcData(arrXml[0],"bl_no");
				formObj.act_cust_list_exist_flg.value = ComGetEtcData(arrXml[0],"act_cust_list_exist_flg");

				var orgBlNo = ComGetEtcData(arrXml[0], "OrgBlNo");
				var frobFlag = ComGetEtcData(arrXml[0], "frob_flag");
				var polCd = ComGetEtcData(arrXml[0], "pol_cd");
				var podCd = ComGetEtcData(arrXml[0], "pod_cd");
				var delCd = ComGetEtcData(arrXml[0], "del_cd");				
				var agmtActCntCd = ComGetEtcData(arrXml[0],"agmt_act_cnt_cd");
				var agmtActCustSeq = ComGetEtcData(arrXml[0],"agmt_act_cust_seq")!=""?ComLpad(ComGetEtcData(arrXml[0],"agmt_act_cust_seq"),6,0):""
				
				formObj.old_act_cust_cd.value = agmtActCntCd + agmtActCustSeq;
				
				if(ComIsNull(formObj.cn_cust_cnt_cd.value)){
					ComSetObjValue(formObj.cn_cust_cnt_cd, delCd.substring(0,2));
				}
				if(ComIsNull(formObj.nf_cust_cnt_cd.value)){
					ComSetObjValue(formObj.nf_cust_cnt_cd, delCd.substring(0,2));
				}
				
				ComSetObjValue(formObj.sh_cust_cnt_cd_old, 	ComGetObjValue(formObj.sh_cust_cnt_cd));
				ComSetObjValue(formObj.sh_cust_seq_old, 	ComGetObjValue(formObj.sh_cust_seq));
				ComSetObjValue(formObj.ff_cust_cnt_cd_old, 	ComGetObjValue(formObj.ff_cust_cnt_cd));
				ComSetObjValue(formObj.ff_cust_seq_old, 	ComGetObjValue(formObj.ff_cust_seq));
				
//				2014.07.22 [CHM-201431224] - 남기황 차장님 테스트 전
				if(ComGetEtcData(arrXml[0],"kr_cstms_cust_tp_cd") == ""){
					if(ComGetEtcData(sXml,"sh_cust_tp") == "B"){
						formObj.kr_cstms_cust_tp_cd.Code = "S";
					}else{
						formObj.kr_cstms_cust_tp_cd.Code = "C";
					}							
				}
				
				ComSetObjValue(formObj.old_kr_cstms_cust_tp_cd, formObj.kr_cstms_cust_tp_cd.Code);
				
				if((polCd != null && polCd.substring(0,2) == "KR") 
						|| (podCd != null && podCd.substring(0,2) == "JP")
						|| ComGetObjValue(formObj.kr_cstms_cust_tp_cd_use_flg)=="Y" ){
					if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
						comboEnable(false);	
					} else {
						comboEnable(true);
					}
				}else{	
					comboEnable(false);
				}

				// Original Bl No 저장
				if(orgBlNo != undefined && orgBlNo != ""){
					formObj.org_bl_no.value = orgBlNo;
					document.getElementById("org_bl").style.display = "block";
				}else{
					document.getElementById("org_bl").style.display = "none";
				}				
				// CA Manifest Flag 셋팅
				if(polCd.substring(0,2) != "CA"){
					if(podCd.substring(0,2) == "CA" || delCd.substring(0,2) == "CA" || frobFlag == "Y"){
						formObj.ca_manifest_flag.value = "Y";
					}else{
						formObj.ca_manifest_flag.value = "N";
					}
				}
				
				if(ComGetEtcData(arrXml[0], "bkg_sts_cd") == "X"
					|| ComGetEtcData(sXml, "DataYn") == "N" 
					|| ComGetObjValue(formObj.isInquiry) == "Y"){
					ComBtnDisable("btn_t7Save");
				}else{
					ComBtnEnable("btn_t7Save");					
				}	
				
				// BDR인 경우 Print Flag만 활성화.fax/email도 활성화
				if(ComGetEtcData(sXml, "bdr_flg") == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
					setCustomerEditable(false);
				}else{
					setCustomerEditable(true);
					
					if(ComGetObjValue(formObj.ca_manifest_flag) == "Y"){
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
					}
				}				
				
				// uncheck로 표시
				formObj.sam_cnee_ntfy_flg.value = 'N';
				formObj.modify_flag.value = "N";
				formObj.same_as_flag.value = "N";
				
				// C/A 버튼 Control
				if(parent.t1frame != undefined && typeof(parent.t1frame) == "object") {
					parent.initCAControl(ComGetObjValue(formObj.bkg_no), ComGetObjValue(formObj.ca_flg), ComGetObjValue(formObj.bdr_flg), ComGetObjValue(formObj.ca_exist_flg), ComGetObjValue(formObj.bl_no));
				}
				
				/* [2018.04.18] 중국 해관 56호령 추가로 인한 컬럼명 분리 (S) */
				ComOpenWait(true);
				var cnTsXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH04+"&bkg_no="+formObj.bkg_no.value);
				var docTpXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH05+"&bkg_no="+formObj.bkg_no.value);
				ComOpenWait(false);
				isCNTsRoute = ComGetEtcData(cnTsXml, "isCNTsRoute");
				isSISubmit = ComGetEtcData(docTpXml, "isSISubmit");
				
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
						// 인도 외 향
						document.getElementById("sh_jpt_gst_man").innerHTML = "Enterprise Code";
						document.getElementById("cn_jpt_gst_man").innerHTML = "Enterprise Code";
						document.getElementById("nf_jpt_gst_man").innerHTML = "Enterprise Code";
						document.getElementById("cn_co_chn_tp_cd").style.display = "none";
						document.getElementById("nf_co_chn_tp_cd").style.display = "none";
						document.getElementById("cn_co_chn_tp_cd").value = "";
						document.getElementById("nf_co_chn_tp_cd").value = "";
					}
					if (isSISubmit == "Y") isCNTsValidation = "Y";
					else isCNTsValidation = "N";
				} else {
					// 중국 경유하지 않고
					if (podCd != null && podCd.substring(0, 2) == "CN" && podCd != "CNHKG") {
						// 중국 향 홍콩 제외
						document.getElementById("sh_jpt_gst_man").innerHTML = "Enterprise Code";
						document.getElementById("cn_jpt_gst_man").innerHTML = "USCI/ORG/<br/>B.Lic";
						document.getElementById("nf_jpt_gst_man").innerHTML = "USCI/ORG/<br/>B.Lic";
						document.getElementById("cn_co_chn_tp_cd").style.display = "block";
						document.getElementById("nf_co_chn_tp_cd").style.display = "block";
						if (isSISubmit == "Y") isCNTsValidation = "Y";
						else isCNTsValidation = "N";
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
				/* [2018.04.18] 중국 해관 56호령 추가로 인한 컬럼명 분리 (E) */
				
				/* [2018005.11] 중국 해관 56호령 2차 추가 (S) */
				if (podCd.substring(0, 2) == "CN" && podCd != "CNHKG") {
					// Shipper. BKG_CUSTOMER의 fax, e-mail, tel이 모두 없을 경우 1순위 MDM_CUST_CNTC_PNT, 2순위 BKG Contact 정보
					if (ComIsNull(formObj.sh_cust_phn_no.value) && ComIsNull(formObj.sh_cust_fax_no.value) && ComIsNull(formObj.sh_cust_eml.value)) {
						// Shipper. sh_cust_cnt_cd와 sh_cust_seq 둘 다 있으면
						var sXml = "";
						if (!ComIsNull(formObj.sh_cust_cnt_cd.value) && !ComIsNull(formObj.sh_cust_seq.value)) {
							ComOpenWait(true);
							sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH03+"&cust_cnt_cd="+formObj.sh_cust_cnt_cd.value+"&cust_seq="+formObj.sh_cust_seq.value);
							ComOpenWait(false);
						}
						
						ComSetObjValue(formObj.sh_cust_phn_no, ComGetEtcData(sXml, "phn_no") ? ComGetEtcData(sXml, "phn_no") : "");
						ComSetObjValue(formObj.sh_cust_fax_no, ComGetEtcData(sXml, "fax_no") ? ComGetEtcData(sXml, "fax_no") : "");
						ComSetObjValue(formObj.sh_cust_eml, ComGetEtcData(sXml, "cust_eml") ? ComGetEtcData(sXml, "cust_eml") : "");
						
						// Shipper. MDM_CUST_CNTC_PNT의 fax, e-mail, tel이 모두 없을 경우 BKG Contact 정보
						if (ComIsNull(ComGetEtcData(sXml, "phn_no")) && ComIsNull(ComGetEtcData(sXml, "fax_no")) && ComIsNull(ComGetEtcData(sXml, "cust_eml"))) {
							ComSetObjValue(formObj.sh_cust_phn_no, parent.frames("t1frame").document.form.bkg_cntc_pson_phn_no.value);
							ComSetObjValue(formObj.sh_cust_eml, parent.frames("t1frame").document.form.bkg_cntc_pson_eml.value);
						}
					}
					
					if (formObj.cn_cust_nm.value.indexOf("TO ORDER") != -1) {
						// Notify. Consignee의 Name에 "TO ORDER"가 있으면
						if (ComIsNull(formObj.nf_cust_phn_no.value) && ComIsNull(formObj.nf_cust_fax_no.value) && ComIsNull(formObj.nf_cust_eml.value)) {
							var nXml = "";
							if (!ComIsNull(formObj.nf_cust_cnt_cd.value) && !ComIsNull(formObj.nf_cust_seq.value)) {
								ComOpenWait(true);
								nXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH03+"&cust_cnt_cd="+formObj.nf_cust_cnt_cd.value+"&cust_seq="+formObj.nf_cust_seq.value);
								ComOpenWait(false);
							}
							
							// Notify. BKG_CUSTOMER의 fax, e-mail, tel이 모두 없을 경우 MDM_CUST_CNTC_PNT 정보
							ComSetObjValue(formObj.nf_cust_phn_no, ComGetEtcData(nXml, "phn_no") ? ComGetEtcData(nXml, "phn_no") : "");
							ComSetObjValue(formObj.nf_cust_fax_no, ComGetEtcData(nXml, "fax_no") ? ComGetEtcData(nXml, "fax_no") : "");
							ComSetObjValue(formObj.nf_cust_eml, ComGetEtcData(nXml, "cust_eml") ? ComGetEtcData(nXml, "cust_eml") : "");
						}
					} else {
						// Consignee. Consignee의 Name에 "TO ORDER"가 없으면
						if (ComIsNull(formObj.cn_cust_phn_no.value) && ComIsNull(formObj.cn_cust_fax_no.value) && ComIsNull(formObj.cn_cust_eml.value)) {
							var cXml = "";
							if (!ComIsNull(formObj.cn_cust_cnt_cd.value) && !ComIsNull(formObj.cn_cust_seq.value)) {
								ComOpenWait(true);
								var cXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do","f_cmd="+SEARCH03+"&cust_cnt_cd="+formObj.cn_cust_cnt_cd.value+"&cust_seq="+formObj.cn_cust_seq.value);
								ComOpenWait(false);
							}
							
							// Consignee. BKG_CUSTOMER의 fax, e-mail, tel이 모두 없을 경우 MDM_CUST_CNTC_PNT 정보
							ComSetObjValue(formObj.cn_cust_phn_no, ComGetEtcData(cXml, "phn_no") ? ComGetEtcData(cXml, "phn_no") : "");
							ComSetObjValue(formObj.cn_cust_fax_no, ComGetEtcData(cXml, "fax_no") ? ComGetEtcData(cXml, "fax_no") : "");
							ComSetObjValue(formObj.cn_cust_eml, ComGetEtcData(cXml, "cust_eml") ? ComGetEtcData(cXml, "cust_eml") : "");
						}
					}
				}
				/* [2018005.11] 중국 해관 56호령 2차 추가 (E) */
				
				break;
				
			case COMMAND03:      //booking split no조회 
				formObj.f_cmd.value = COMMAND03;				
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", "f_cmd="+COMMAND03+"&bkg_no="+formObj.bkg_no.value);				 	
			 	var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
			 	bkgSplitNoListPop(formObj.bkg_no,bkg_split_no_list,-15);         	
			 	break;	
			 	
			case IBSAVE:        //저장
				if(validateForm(formObj,sAction)){
					// [CHM-201322354] ALPS Bkg 입력(or Upload)시 Country Code 체크 Pop-Up 메세지 요청
        			if(ComGetObjValue(formObj.pod_cd).substring(0,2) != ComGetObjValue(formObj.nf_cust_cnt_cd)){
        				if(ComGetObjValue(formObj.pod_cd).substring(0,2) != "US"
        						&& ComGetObjValue(formObj.pod_cd).substring(0,2) != "CA"
            					&& ComGetObjValue(formObj.pod_cd).substring(0,2) != "IN"){
	        				if(!(ComGetObjValue(formObj.cn_cust_cnt_cd) == "KR" 
	        					&& (ComGetObjValue(formObj.cn_cust_seq) == "002073" || ComGetObjValue(formObj.cn_cust_seq) == "2073"))){
	        					ComShowCodeMessage("BKG08248");
	        				}
        				}
        			}
        			
        			// [CHM-201534418] SYRIA SANCTION관련 ALERT POPUP 요청
        			if((ComGetObjValue(formObj.ff_cust_cnt_cd)=="SY" && !ComIsNull(formObj.ff_cust_seq)) 
        				|| (ComGetObjValue(formObj.cn_cust_cnt_cd)=="SY" && !ComIsNull(formObj.cn_cust_seq)) ){
	    				if(ComShowCodeConfirm("BKG08345")){
	                		window.open("https://compliance.hanjin.com/Compliance/indexTop.jsp");
	    				}
    				}
        			
//	        		// Black List Check(Iran)
//					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do?f_cmd="+COMMAND04, FormQueryString(formObj));
//					var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
//					var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
//					if(black_cust_flag == "Y"){
//						if(!ComShowCodeConfirm("BKG02070", black_cust_list)){
//							return false;
//						}
//					}
//					else{
//					// Black List Check(US)
						var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do?f_cmd="+COMMAND09, FormQueryString(formObj));
						var black_cust_flag = ComGetEtcData(sXml, "black_cust_flag");
						var black_cust_list = ComGetEtcData(sXml, "black_cust_list");
						if(black_cust_flag == "Y"){
							if(!ComShowCodeConfirm("BKG08343", black_cust_list)){
								return false;
							}
							else{
								//이란 sanction list 경고 문구에 확인 눌렀을 때, 해당 데이터 저장을 위한 flg 바꿔줌
								isSanctionFLG = true;
							}
						}
//					}
					
//	        		// Black List Check(EU)
//					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do?f_cmd="+COMMAND05, FormQueryString(formObj));
//					if (ComGetEtcData(sXml, "black_cust_flag") != "N"){
//						sheetObj.LoadSearchXml(sXml);
//						return false;
//					}
						
			 		var param = "&f_cmd=" + SEARCH18 + "&input_text1=YELLOW&input_text=" 
			 					+ComGetObjValue(formObj.sh_cust_lgl_eng_nm)+" | "+ ComGetObjValue(formObj.sh_cust_nm);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			ComShowCodeMessage("BKG95101",output_text);
			 			var bkg_no = formObj.bkg_no.value;
			 			var blckTpCd = "YEL_CUST";
			 			var blckKwNm = output_text;
			 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
						var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
			 		}
	
			 		//Charcoal, Calcium Hypochlorite Manufacturer 금지어 포함 되었는지 CHECK	
			 		var param = "&f_cmd=" + SEARCH22 + "&input_text=" 
 								+ComGetObjValue(formObj.sh_cust_lgl_eng_nm)+" | "+ ComGetObjValue(formObj.sh_cust_nm);
			 		var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
			 		var output_text = ComGetEtcData(sXml, "output_text");
			 		if(output_text!=null && output_text.length>0){
			 			ComShowCodeMessage("BKG95110",output_text);
			 			var bkg_no = formObj.bkg_no.value;
			 			var blckTpCd = "CAL_CUST";
			 			var blckKwNm = output_text;
			 			var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
						var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
			 		}
			 		
					
					// Individual Flag Save MSG
					var savedMsg = "";
					if(formObj.indiv_pson_flg.value == "Y"){
						savedMsg = ComShowCodeConfirm("BKG08197");
					} else {
						savedMsg = ComShowCodeConfirm("BKG00254");
					}
										
					if(savedMsg){
						//formObj.f_cmd.value = MULTI;
						sheetObj.WaitImageVisible=false;
						setCustomerEditable(true);
						
						ComOpenWait(true);
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_05GS.do?f_cmd="+MULTI, FormQueryString(formObj));
						if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
							setCustomerEditable(false);
						}else{
							setCustomerEditable(true);
						}						
						ComOpenWait(false); //대기창 사라짐 		
						
						sheetObj.LoadSearchXml(sXml);

						if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
							ComBkgSaveCompleted();
							ComSetObjValue(formObj.modify_flag, "N");	
							
							var agmtActCntCd = formObj.agmt_act_cnt_cd.value;
							var agmtActCustSeq = formObj.agmt_act_cust_seq.value!=""?ComLpad(formObj.agmt_act_cust_seq.value,6,0):""
							
							formObj.old_act_cust_cd.value = agmtActCntCd +agmtActCustSeq;
							
							if(ComGetEtcData(sXml, "firm_msg_flg") == "Y"){
								ComShowCodeMessage("BKG08300");
							}
							if(ComGetEtcData(sXml, "non_rate_msg_flg") == "Y"){
								ComShowCodeMessage("BKG08336");
							}
							if(ComGetEtcData(sXml, "aloc_pop_flg") == "Y"){
								var param = "bkg_no=" + formObj.bkg_no.value + "&aloc_pop_flg=Y"
						          + "&before_aloc_sts_cd=" + ComGetObjValue(formObj.aloc_sts_cd);
								ComOpenPopup("ESM_BKG_1507.do?"+param, 760, 550, "","1,0,1,1,1", true);
							}
							
							if (ComGetEtcData(sXml, "ofcChgFlag") == "Y"){
                                doActionIBSheet(sheetObj, formObj, SEARCH02);
							} else {
                                doActionIBSheet(sheetObj, formObj, IBSEARCH);
							}
							
							//저장 성공 후, sanction list alert가 떴었다면 데이터 저장
							if(isSanctionFLG){
								var bkg_no = formObj.bkg_no.value;
								var blckTpCd = "SAN_CUST";
								var blckKwNm = black_cust_list;
								var param = "&f_cmd="+COMMAND18+"&blckKwNm="+blckKwNm+"&blckTpCd="+blckTpCd+"&bkg_no="+bkg_no;
								var rXml = sheetObj.GetSaveXml("ESM_Booking_UtilGS.do", param);
								isSanctionFLG = false;
							}
						}						
					}
				}			
				break;
			
			case SEARCH02: // ppd, clt office가 바뀌는지 조회
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
        		var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_05GS.do", param);
        		var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
    				sheetObjects[1].LoadSearchXml(arrXml[0]);
				}
        		ComOpenWait(false);
				break;

			case MODIFY07: // ppd, clt office를 update함
        		sheetObj.WaitImageVisible=false;
        		ComOpenWait(true);
        		var param = "f_cmd=" + sAction + "&bkg_no=" + ComGetObjValue(formObj.bkg_no) + "&bl_no=" + ComGetObjValue(formObj.bl_no);
        		var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_05GS.do", param);
        		sheetObjects[0].LoadSearchXml(sXml);
        		ComOpenWait(false);
        		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
        			ComBkgSaveCompleted();
        			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        		}
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
				// BkgNo 변경 후 저장하면 에러
				if(formObj.bkg_no.value != formObj.old_bkg_no.value){
					ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,formObj.bkg_no.value);
 					return false; 					
				}
				// BlNo 변경 후 저장하면 에러
				if(formObj.bl_no.value != formObj.old_bl_no.value){
					ComShowCodeMessage("BKG00439",formObj.old_bl_no.value,formObj.bl_no.value);					
 					return false; 					
				} 						
 				if(ComIsNull(formObj.bkg_no)){ 					
					ComShowCodeMessage("BKG00255");
					ComSetFocus(formObj.bkg_no);
					return false; 					
 				}
    			if(ComGetObjValue(formObj.bkg_sts_cd) == "X"){		// Cancel Booking 시
    				ComShowCodeMessage("BKG00005");
    				return false;
    			} 				
 				if(formObj.sh_cstms_decl_cnt_cd.value.length == 1){
 					ComShowCodeMessage("BKG00464", "Shipper", formObj.sh_cstms_decl_cnt_cd.value);
					ComSetFocus(formObj.sh_cstms_decl_cnt_cd); 
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
 				// for usa, canada
 				// Country가 'US','CA'인 경우 ZipCode는 필수
 				if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US" && ComGetObjValue(formObj.non_rt_sts_cd)!="R"){
	 				if(ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.sh_cstms_decl_cnt_cd) == "CA"){
	 					if(ComIsNull(formObj.sh_cust_zip_id)){ 						 		
	 						ComShowCodeMessage("BKG08239", "Zip code is", "US/CA");
	 						ComSetFocus(formObj.sh_cust_zip_id); 						
	 						return false; 	 	 						
	 					}
	 				}
//	 				if(ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.cn_cstms_decl_cnt_cd) == "CA"){
//	 					if(ComIsNull(formObj.cn_cust_zip_id)){ 						 		
//	 						ComShowCodeMessage("BKG08239");
//	 						ComSetFocus(formObj.cn_cust_zip_id); 						
//	 						return false; 	 	 						
//	 					}
//	 				}	 				
					// POL_CD가 CA인 경우   City / State, Country, ZIP Code 항목이 모두 필수
					if(ComGetObjValue(formObj.pod_cd).substring(0,2) == "CA"){						
						if(ComGetObjValue(formObj.cust_to_ord_flg) == "N"){							
							var paramCnt = 0;
							var paramStr = "";
							
							if(ComIsNull(formObj.cn_cust_cty_nm)){
								paramStr += "City,";
								paramCnt++;
							}
							if(ComIsNull(formObj.cn_cust_ste_cd)){
								paramStr += "State,";
								paramCnt++;
							}
							if(ComIsNull(formObj.cn_cstms_decl_cnt_cd)){
								paramStr += "Country,";
								paramCnt++;
							}
							if(ComIsNull(formObj.cn_cust_zip_id)){
								paramStr += "Zip code,";
								paramCnt++;
							}
							
							if(paramCnt > 0){
								if(paramCnt == 1){
			 						ComShowCodeMessage("BKG08239",paramStr.replace(",","") + " is","CA");
			 						ComSetFocus(formObj.cn_cust_zip_id);
			 						return false;
								} else {
									ComShowCodeMessage("BKG08239",paramStr.substring(0,paramStr.length-1) + " are", "CA");
									ComSetFocus(formObj.cn_cust_cty_nm);
									return false;
								}
							}
						}
					}
					
	 				if(ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "US" || ComGetObjValue(formObj.nf_cstms_decl_cnt_cd) == "CA"){
	 					if(ComIsNull(formObj.nf_cust_zip_id)){ 						 		
	 						ComShowCodeMessage("BKG08239", "Zip code is", "US/CA");
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
 						ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.nf_cust_cnt_cd.value+"&cust_seq="+formObj.nf_cust_seq.value+"&cust_nm="+custNm, 970, 640, "callBackNf0192","0,0,1,1,1", true);
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
 						ComOpenPopup("ESM_BKG_0192.do?pgmNo=ESM_BKG_0192&cust_cnt_cd="+formObj.cn_cust_cnt_cd.value+"&cust_seq="+formObj.cn_cust_seq.value+"&cust_nm="+custNm, 970, 640, "callBackCn0192","0,0,1,1,1", true);
 						//return false;
 					}
 				} 			

 				// caManifestFlag = 'Y' 이면 city,state/country, zip 필수(B/L Type이 'Y' -> Notify, 'N' -> Consignee)
 				// pol이 'US' 인 경우는 제외
 				// 2014.11.25 여기도 R 일땐 풀어달라고함
 				if(formObj.ca_manifest_flag.value == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){ 			
 					if(formObj.non_rt_sts_cd.value!="R"){
	 					//shipper에 대해서도 validation함
	 					if(ComIsNull(formObj.sh_cust_cty_nm.value) || ComIsNull(formObj.sh_cstms_decl_cnt_cd.value)){
	 						ComShowCodeMessage("BKG00346");
	 						ComSetFocus(formObj.sh_cust_cty_nm);
	 						return false;
	 					} 
	 								
	 					//To order인 경우에는 Consignee는 validation 하지 않음
	 					if(formObj.cust_to_ord_flg.value == "N"){
	 						if(formObj.cn_cstms_decl_cnt_cd.value == "US" || formObj.cn_cstms_decl_cnt_cd.value == "CA") {
		 	 					if(ComIsNull(formObj.cn_cust_cty_nm.value) || ComIsNull(formObj.cn_cust_ste_cd.value) || ComIsNull(formObj.cn_cstms_decl_cnt_cd.value)){
		 	 						ComShowCodeMessage("BKG00346");
		 	 						ComSetFocus(formObj.cn_cust_cty_nm);
		 	 						return false;
		 	 					} 	
	 						}
	 					}
	 					
	 					if(formObj.nf_cstms_decl_cnt_cd.value == "US" || formObj.nf_cstms_decl_cnt_cd.value == "CA") {
							if(ComIsNull(formObj.nf_cust_cty_nm.value) || ComIsNull(formObj.nf_cust_ste_cd.value) || ComIsNull(formObj.nf_cstms_decl_cnt_cd.value)){
								ComShowCodeMessage("BKG00346");
								ComSetFocus(formObj.nf_cust_cty_nm);
								return false;
							} 		
	 					}
 					}
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

				//EORI no 확인 시작 - 2010.12.31/////////
				var custCnts = [formObj.sh_cust_cnt_cd, formObj.cn_cust_cnt_cd, formObj.nf_cust_cnt_cd];
				var declCnts = [formObj.sh_cstms_decl_cnt_cd, formObj.cn_cstms_decl_cnt_cd, formObj.nf_cstms_decl_cnt_cd];
				var eoris = [formObj.sh_eori_no, formObj.cn_eori_no, formObj.nf_eori_no];
				//Japan Tel# check : Doc type : S, U & POD Country : JP --2017.08.18
				if (formObj.pod_cd.value.substring(0,2)=="JP") {
					for (var ii=0; ii<eoris.length; ii++) {
	 					if (ComIsNull(eoris[ii])) {
	 						ComShowCodeMessage("BKG95129");
 							ComSetFocus(eoris[ii]);
 							return false;
	 					}
					}
				} else if (formObj.pod_cd.value.substring(0,2)=="IN" || formObj.pod_cd.value.substring(0,2)=="ID") {
					
				} else if (formObj.pod_cd.value.substring(0,2)=="CN") {
					// 아래 isCNTsValidation == "Y" 일 때로 대신 체크
				} /*else {
					for (var ii=0; ii<custCnts.length; ii++) {
						if (!ComIsNull(custCnts[ii]) && !ComIsNull(declCnts[ii]) && ComGetObjValue(custCnts[ii])!=ComGetObjValue(declCnts[ii])) {
							if (!ComShowCodeConfirm("BKG01151")) {
								ComSetFocus(declCnts[ii]);
								return false;
							}
						}
					}
					for (var ii=0; ii<eoris.length; ii++) {
	 					if (!ComIsNull(eoris[ii])) {
	 						if ("TEST"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							"NONE"==ComGetObjValue(eoris[ii]).toUpperCase() ||
	 							/[^A-Za-z0-9-]/g.test(ComGetObjValue(eoris[ii]))) {
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
				}*/
				
				if (isCNTsValidation == "Y") {
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
				}
				//EORI no 확인 끝 - 2010.12.31/////////
				
 				// for roterdam
 				// pod가 NL 지역일 때 street, p.o.box, eori# mandatory 추가 				
				if(formObj.nl_flag.value == "Y" && formObj.non_rt_sts_cd.value!="R"){
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
					
	 				if(formObj.cust_to_ord_flg.value == "N"){
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
				
				/* 2byte 문자로 인한 Street / P.O.Box 의 자릿수 체크 */
				if(!ComIsNull(formObj.sh_eur_cstms_st_nm.value) && 0==ComChkLenByByte(formObj.sh_eur_cstms_st_nm.value,50)){
					ComShowCodeMessage("BKG00107","50");
					ComSetFocus(formObj.sh_eur_cstms_st_nm);
					return false;
				}
				if(!ComIsNull(formObj.cn_eur_cstms_st_nm.value) && 0==ComChkLenByByte(formObj.cn_eur_cstms_st_nm.value,50)){
					ComShowCodeMessage("BKG00107","50");
					ComSetFocus(formObj.cn_eur_cstms_st_nm);
					return false;
				}
				if(!ComIsNull(formObj.nf_eur_cstms_st_nm.value) && 0==ComChkLenByByte(formObj.nf_eur_cstms_st_nm.value,50)){
					ComShowCodeMessage("BKG00107","50");
					ComSetFocus(formObj.nf_eur_cstms_st_nm);
					return false;
				}
				
 				// Shipper Code Check
 				if(ComChkLen(formObj.sh_cust_cnt_cd.value, 2) != "2"){
 					ComShowCodeMessage("BKG00300");
 					ComSetFocus(formObj.sh_cust_cnt_cd);
	 				return false; 					
 				}
 				// Shipper Seq Check
 				if(ComIsNull(formObj.sh_cust_seq.value)){
 					ComShowCodeMessage("BKG00008");
 					ComSetFocus(formObj.sh_cust_seq);
	 				return false; 					
 				} 				
 				if(!ComIsNull(formObj.sh_cust_seq)){
 					if(!ComIsNumber(formObj.sh_cust_seq)){
 			 			ComShowCodeMessage("BKG00340");
 						formObj.sh_cust_seq.focus();
 						return false;
 					}
 				}
 				// Shipper Name Check
 				if(ComIsNull(formObj.sh_cust_nm.value)){
 					ComShowCodeMessage("BKG00351");
 					ComSetFocus(formObj.sh_cust_nm);
	 				return false; 					
 				} 		 				
 				// Shipper Address Check
 				if(ComIsNull(formObj.sh_cust_addr.value)){
 					ComShowCodeMessage("BKG00352");
 					ComSetFocus(formObj.sh_cust_addr);
	 				return false; 					
 				}
 				// Consignee Code Check
 				if(ComChkLen(formObj.cn_cust_cnt_cd.value, 2) != "2"){
 					ComShowCodeMessage("BKG00291");
 					ComSetFocus(formObj.cn_cust_cnt_cd);
	 				return false; 					
 				}
 				// Consignee Seq Check 주석처리 (정민정 과장 요청 20091013)
// 				if(ComIsNull(formObj.cn_cust_seq.value)){
// 					ComShowCodeMessage("BKG00009");
// 					ComSetFocus(formObj.cn_cust_seq);
//	 				return false; 					
// 				} 				 		
 				if(!ComIsNull(formObj.cn_cust_seq)){
 					if(!ComIsNumber(formObj.cn_cust_seq)){
 			 			ComShowCodeMessage("BKG00340");
 						formObj.cn_cust_seq.focus();
 						return false;
 					}
 				} 				
 				if(!ComIsNull(formObj.nf_cust_seq)){
 					if(!ComIsNumber(formObj.nf_cust_seq)){
 			 			ComShowCodeMessage("BKG00340");
 						formObj.nf_cust_seq.focus();
 						return false;
 					}
 				}			
 				if(!ComIsNull(formObj.ff_cust_seq)){
 					if(!ComIsNumber(formObj.ff_cust_seq)){
 			 			ComShowCodeMessage("BKG00340");
 						formObj.ff_cust_seq.focus();
 						return false;
 					}
 				}			
 				if(!ComIsNull(formObj.an_cust_seq)){
 					if(!ComIsNumber(formObj.an_cust_seq)){
 			 			ComShowCodeMessage("BKG00340");
 						formObj.an_cust_seq.focus();
 						return false;
 					}
 				}	
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
 					/** 20180417 정인선 [박준훈과장님] 특정 화주는 제외 한다. US040383 */ 
 					var cnCustInfo = ComGetObjValue(formObj.cn_cust_cnt_cd) + ComGetObjValue(formObj.cn_cust_seq);
 					if(BkgIsContainsChars(formObj.cn_cust_nm,"order") && cnCustInfo != 'US040383'){
						if(ComShowCodeConfirm("BKG00347")){
							formObj.cust_to_ord_flg.value = "Y";
						}  						
 					}	
 					
 					//	B/L Type: Straight B/L 이고
 					//	POD: US 이며
 					//	N/ Box 에 대한 정보가 입력되어 있고 
 					//	N/ Code 가 입력되지 않았을 때
 					//      Please select N/ customer code for smooth U.S. I/B service. 메세지 표시
 					//[추가요청] Notify Code 미 입력된 Straight BL 대상 Pop Up 메세지 삽입 요청 (POD/DEL: ES, FR, PT 경우)
 					var chk_pod ="";
 					var chk_del ="";
 					chk_pod = ComGetObjValue(formObj.pod_cd).substring(0,2);
 					chk_del = ComGetObjValue(formObj.del_cd).substring(0,2);
 					
 					if( (chk_pod=='US' ||
 							chk_pod=='ES' ||chk_pod=='FR' || chk_pod=='PT' ||
 							chk_del=='ES' ||chk_del=='FR' || chk_del=='PT' )
 						&& !ComIsNull(formObj.nf_cust_addr) && !ComIsNull(formObj.nf_cust_nm ) &&  ComIsNull(formObj.nf_cust_seq.value) ) {
// 						alert("Please select N/ customer code for smooth U.S. I/B service." );
 						ComShowCodeMessage("BKG08313");
 						ComSetFocus(formObj.nf_cust_seq);
// 						return false;
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
 				if(ComGetObjValue(formObj.sh_cust_eml) != ""
	                && !ComIsEmailAddr(ComGetObjValue(formObj.sh_cust_eml))){
	                ComShowCodeMessage("BKG40021" , ComGetObjValue(formObj.sh_cust_eml));
	                ComSetFocus(formObj.sh_cust_eml);
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
    			    			
    			// 2012.04.24 BKG/DOC System 보완 요청 START
    			if (!checkBkgIssStatus(formObj)) {
    				return false;
    			}
    			// 2012.04.24 BKG/DOC System 보완 요청 END   
    			//check FWDR OLD	
    	        if(!ComIsNull(ComGetObjValue(formObj.ff_cust_cnt_cd_old))) {
    	        	//check FWDR NULL
    	        	if(ComIsNull(ComGetObjValue(formObj.ff_cust_cnt_cd))) {
    	        		//check FWDR NEW	
                    	if((ComGetObjValue(formObj.ff_cust_cnt_cd_old) != ComGetObjValue(formObj.sh_cust_cnt_cd) || ComGetObjValue(formObj.ff_cust_seq_old) != ComGetObjValue(formObj.sh_cust_seq)))  {
    	                	comCallPop0652('callBack0652','S', ComGetObjValue(formObj.sh_cust_cnt_cd), ComGetObjValue(formObj.sh_cust_seq), "");
    	                }	 
    	        	} else {
    	                 //check FWDR DIFF	
    	                if((ComGetObjValue(formObj.ff_cust_cnt_cd_old) != ComGetObjValue(formObj.ff_cust_cnt_cd) || ComGetObjValue(formObj.ff_cust_seq_old) != ComGetObjValue(formObj.ff_cust_seq)) ) {
    	                	comCallPop0652('callBack0652','F', ComGetObjValue(formObj.ff_cust_cnt_cd), ComGetObjValue(formObj.ff_cust_seq), "");
    	                }	        		 
    	        	}
    	        }else if(!ComIsNull(ComGetObjValue(formObj.sh_cust_cnt_cd_old))){
                    //check FWDR NEW	
                    if(!ComIsNull(ComGetObjValue(formObj.ff_cust_cnt_cd))) {
                    	if((ComGetObjValue(formObj.sh_cust_cnt_cd_old) != ComGetObjValue(formObj.ff_cust_cnt_cd) || ComGetObjValue(formObj.sh_cust_seq_old) != ComGetObjValue(formObj.ff_cust_seq)))  {
                           comCallPop0652('callBack0652','F', ComGetObjValue(formObj.ff_cust_cnt_cd), ComGetObjValue(formObj.ff_cust_seq), "");
                    	}    
                    }
                    //check SHPR DIFF	
    	            else if (ComGetObjValue(formObj.sh_cust_cnt_cd_old) != ComGetObjValue(formObj.sh_cust_cnt_cd) || ComGetObjValue(formObj.sh_cust_seq_old) != ComGetObjValue(formObj.sh_cust_seq)) {
    	            	comCallPop0652('callBack0652','S', ComGetObjValue(formObj.sh_cust_cnt_cd), ComGetObjValue(formObj.sh_cust_seq), "");
    	            }	
    	        }
    			var podCd = ComGetObjValue(formObj.pod_cd);
    	        if(podCd != null && podCd.substring(0,2) == "JP" && ComGetObjValue(formObj.jp24_alert_flg) == "N"){
    	        	if(ComGetObjValue(formObj.kr_cstms_cust_tp_cd) == "S"){
    	        		ComShowCodeMessage("BKG08282");
    	        	} else {
    	        		ComShowCodeMessage("BKG08283");
    	        	}
    	        }
    	        //
    	        if(ComGetObjValue(formObj.pod_cd).substring(0,2) == "TH" || ComGetObjValue(formObj.del_cd).substring(0,2) == "TH") {
					if (ComGetObjValue(formObj.de_term_cd) != "S" && ComGetObjValue(formObj.old_kr_cstms_cust_tp_cd) != 'C' && ComGetObjValue(formObj.kr_cstms_cust_tp_cd) == 'C'){
						if(ComShowConfirm(ComGetMsg("BKG08309"))){
							
						}else{
							return false;
						}
					}
    			}	
    	        
    	        //[CHM-201431856] e-bkg & si process, BKG creation 화면에 “CN 404 EDI 주소city, state, zip missing”    			
    			if (ComGetObjValue(formObj.pol_cd).substring(0,2) == 'CA') {
    				
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
    			
    			
    	        
 			break;              		
        } 		
        return true;
    }

	function comCallPop0652(callback_func, bkgCustTpCd, custCntCd, custSeq, custNm){
     	ComOpenPopup("ESM_BKG_0652.do?pgmNo=ESM_BKG_0652" 
     			+"&bkg_cust_tp_cd="+bkgCustTpCd+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq
     			+"&cust_nm="+custNm+"&ui_id=ESM_BKG_0079_05", 980, 380, callback_func,"1,0,1,1,1", true);
    }
 				
    // Print Flag를 제외한 항목 활성화, 비활성화 처리  
    function setCustomerEditable(isEnable){
    	var formObj = document.form;
    	//BkgEnableObject(formObj.agmt_act_cnt_cd, isEnable);
    	//BkgEnableObject(formObj.agmt_act_cust_seq, isEnable);  
    	
    	BkgEnableObject(formObj.agmt_act_cnt_cd, false);
    	BkgEnableObject(formObj.agmt_act_cust_seq, false);  
    	
    	if(formObj.agmt_act_cnt_cd.value ==""){
    		document.getElementById("del_btn").style.display = "none";
		}else{	
			document.getElementById("del_btn").style.display = "block";
			
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("btn_t7Delete").className = "btn2";
			}else{
				document.getElementById("btn_t7Delete").className = "btn2_3";
			}
		}		
    	
    	// bdr 지나도 customer code는 그냥 저장 가능하도록 처리(20091216 정민정과장님 요청)
//    	BkgEnableObject(formObj.sh_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.sh_cust_seq, isEnable);
    	if(isEnable){
        	formObj.sh_cust_nm.readOnly = false;
        	formObj.sh_cust_addr.readOnly = false;    		
    	}else{
        	formObj.sh_cust_nm.readOnly = true;
        	formObj.sh_cust_addr.readOnly = true;    		
    	}    	
    	
    	BkgEnableObject(formObj.sh_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.sh_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.sh_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.sh_cust_zip_id, isEnable);
    	BkgEnableObject(formObj.sh_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.sh_eori_no, isEnable);    	

//    	BkgEnableObject(formObj.cn_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.cn_cust_seq, isEnable);
    	if(isEnable){
        	formObj.cn_cust_nm.readOnly = false;
        	formObj.cn_cust_addr.readOnly = false;    	
    	}else{
        	formObj.cn_cust_nm.readOnly = true;
        	formObj.cn_cust_addr.readOnly = true;    			
    	}    	

    	BkgEnableObject(formObj.cn_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.cn_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.cn_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.cn_cust_zip_id, isEnable);   	
//    	BkgEnableObject(formObj.cn_cust_fax_no, isEnable); 	// bdr 지나도 수정 가능   	
//    	BkgEnableObject(formObj.cn_cust_eml, isEnable); 	// bdr 지나도 수정 가능
    	BkgEnableObject(formObj.cn_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.cn_eori_no, isEnable);   	       	
    	BkgEnableObject(formObj.cust_to_ord_flg, isEnable);
    	
//    	BkgEnableObject(formObj.nf_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.nf_cust_seq, isEnable);
    	if(isEnable){
        	formObj.nf_cust_nm.readOnly = false;
        	formObj.nf_cust_addr.readOnly = false;   	
    	}else{
        	formObj.nf_cust_nm.readOnly = true;
        	formObj.nf_cust_addr.readOnly = true;    			
    	}    	    	
  	
    	BkgEnableObject(formObj.nf_cust_cty_nm, isEnable);
    	BkgEnableObject(formObj.nf_cust_ste_cd, isEnable);
    	BkgEnableObject(formObj.nf_cstms_decl_cnt_cd, isEnable);
    	BkgEnableObject(formObj.nf_cust_zip_id, isEnable);    	    	
//    	BkgEnableObject(formObj.nf_cust_fax_no, isEnable);  // bdr 지나도 수정 가능   	  	
//    	BkgEnableObject(formObj.nf_cust_eml, isEnable); 	// bdr 지나도 수정 가능
    	BkgEnableObject(formObj.nf_eur_cstms_st_nm, isEnable);
    	BkgEnableObject(formObj.nf_eori_no, isEnable);   	
    	BkgEnableObject(formObj.sam_cnee_copy_flg, isEnable);    	    	
    	
//    	BkgEnableObject(formObj.ff_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.ff_cust_seq, isEnable);
    	if(isEnable){
    		formObj.ff_cust_nm.readOnly = false;	
    	}else{
    		formObj.ff_cust_nm.readOnly = true;  			
    	}        	
//    	BkgEnableObject(formObj.fmc_cd, isEnable);    
    	
//    	BkgEnableObject(formObj.an_cust_cnt_cd, isEnable);
//    	BkgEnableObject(formObj.an_cust_seq, isEnable);
    	    	
    	if(isEnable){
    		formObj.an_cust_nm.readOnly = false;	
    	}else{
    		formObj.an_cust_nm.readOnly = true;	
    	}           	
//    	BkgEnableObject(formObj.an_cust_fax_no, isEnable);   // bdr 지나도 수정 가능   
//    	BkgEnableObject(formObj.an_cust_eml, isEnable);    	 // bdr 지나도 수정 가능      	

    	if(isEnable){
    		formObj.ex_cust_nm.readOnly = false;	
    	}else{
    		formObj.ex_cust_nm.readOnly = true; 			
    	}    	
    	BkgEnableObject(formObj.ff_ref_no, isEnable); 
    	BkgEnableObject(formObj.ex_cust_cnt_cd, isEnable); 
    	BkgEnableObject(formObj.ex_cust_seq, isEnable); 
    	BkgEnableObject(formObj.org_cnt_nm, isEnable);
    	
    	if(isEnable){
    		formObj.sh_cust_cnt_cd.style.background = "#CCFFFD";
    		formObj.sh_cust_seq.style.background = "#CCFFFD";    		
    		formObj.cn_cust_cnt_cd.style.background = "#CCFFFD";
    		formObj.cn_cust_seq.style.background = "#CCFFFD";
    		
    		formObj.sh_cust_nm.style.background = "#FFFFFF";
    		formObj.sh_cust_addr.style.background = "#FFFFFF";    		
    		formObj.cn_cust_nm.style.background = "#FFFFFF";
    		formObj.cn_cust_addr.style.background = "#FFFFFF";    	
    		formObj.nf_cust_nm.style.background = "#FFFFFF";
    		formObj.nf_cust_addr.style.background = "#FFFFFF";    	
    		formObj.ff_cust_nm.style.background = "#FFFFFF";
    		formObj.an_cust_nm.style.background = "#FFFFFF";    	    		
    		formObj.ex_cust_nm.style.background = "#FFFFFF";    		
    	}else{
    		formObj.sh_cust_nm.style.background = "#E8E7EC";
    		formObj.sh_cust_addr.style.background = "#E8E7EC";    		
    		formObj.cn_cust_nm.style.background = "#E8E7EC";
    		formObj.cn_cust_addr.style.background = "#E8E7EC";    	
    		formObj.nf_cust_nm.style.background = "#E8E7EC";
    		formObj.nf_cust_addr.style.background = "#E8E7EC";    	
    		formObj.ff_cust_nm.style.background = "#E8E7EC";
    		formObj.an_cust_nm.style.background = "#E8E7EC";    	    		
    		formObj.ex_cust_nm.style.background = "#E8E7EC";
    		if(comboObjects[0].Enable){
    			comboEnable(isEnable);
    		}
    	}    	
    	if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
    		return;
    	}
    		
		document.getElementById("sh_eur_cstms_st_nm").className = "input";
		document.getElementById("sh_eori_no").className = "input";
		document.getElementById("sh_cust_ste_cd").className = "input";
		document.getElementById("sh_cust_cty_nm").className = "input";
		document.getElementById("sh_cstms_decl_cnt_cd").className = "input";		
		document.getElementById("sh_cust_zip_id").className = "input";
		document.getElementById("cn_eur_cstms_st_nm").className = "input";
		document.getElementById("cn_eori_no").className = "input";
		document.getElementById("cn_cust_ste_cd").className = "input";
		document.getElementById("cn_cust_cty_nm").className = "input";
		document.getElementById("cn_cstms_decl_cnt_cd").className = "input";		
		document.getElementById("cn_cust_zip_id").className = "input";
		document.getElementById("nf_eur_cstms_st_nm").className = "input";
		document.getElementById("nf_eori_no").className = "input";			
		document.getElementById("nf_cust_ste_cd").className = "input";
		document.getElementById("nf_cust_cty_nm").className = "input";
		document.getElementById("nf_cstms_decl_cnt_cd").className = "input";		
		document.getElementById("nf_cust_zip_id").className = "input";	

		// Canada향인 경우 City/State/Country 파란색 처리
//		if(ComGetObjValue(formObj.ca_manifest_flag) == "Y" && ComGetObjValue(formObj.pol_cd).substring(0,2) != "US"){
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
		}else{
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("sh_cust_cty_nm").className = "input2";
				document.getElementById("sh_cust_ste_cd").className = "input2";
				document.getElementById("sh_cstms_decl_cnt_cd").className = "input2";		
				document.getElementById("sh_cust_zip_id").className = "input2";
				
				document.getElementById("cn_cust_cty_nm").className = "input2";
				document.getElementById("cn_cust_ste_cd").className = "input2";
				document.getElementById("cn_cstms_decl_cnt_cd").className = "input2";	
				document.getElementById("cn_cust_zip_id").className = "input2";
				
				document.getElementById("nf_cust_cty_nm").className = "input2";
				document.getElementById("nf_cust_ste_cd").className = "input2";						
				document.getElementById("nf_cstms_decl_cnt_cd").className = "input2";	
				document.getElementById("cn_cust_zip_id").className = "input2";
			}
		}				
				// NL Manifest Flag 셋팅
		if(formObj.nl_flag.value == "Y"){
			document.getElementById("sh_eur_cstms_st_nm").className = "input1";
			document.getElementById("sh_eori_no").className = "input1";
			document.getElementById("sh_cust_cty_nm").className = "input1";
			document.getElementById("sh_cstms_decl_cnt_cd").className = "input1";		
			document.getElementById("sh_cust_zip_id").className = "input1";
			
			document.getElementById("cn_eur_cstms_st_nm").className = "input1";
			document.getElementById("cn_eori_no").className = "input1";
			document.getElementById("cn_cust_cty_nm").className = "input1";
			document.getElementById("cn_cstms_decl_cnt_cd").className = "input1";		
			document.getElementById("cn_cust_zip_id").className = "input1";
			
			document.getElementById("nf_eur_cstms_st_nm").className = "input1";
			document.getElementById("nf_eori_no").className = "input1";
			document.getElementById("nf_cust_cty_nm").className = "input1";
			document.getElementById("nf_cstms_decl_cnt_cd").className = "input1";		
			document.getElementById("nf_cust_zip_id").className = "input1";
		} else {
			if(ComGetObjValue(formObj.bdr_flg) == "Y" && ComGetObjValue(formObj.ca_flg) == "N"){
				document.getElementById("sh_eur_cstms_st_nm").className = "input2";
				document.getElementById("sh_eori_no").className = "input2";
				document.getElementById("sh_cust_cty_nm").className = "input2";
				document.getElementById("sh_cstms_decl_cnt_cd").className = "input2";		
				document.getElementById("sh_cust_zip_id").className = "input2";
				
				document.getElementById("cn_eur_cstms_st_nm").className = "input2";
				document.getElementById("cn_eori_no").className = "input2";
				document.getElementById("cn_cust_cty_nm").className = "input2";
				document.getElementById("cn_cstms_decl_cnt_cd").className = "input2";		
				document.getElementById("cn_cust_zip_id").className = "input2";
				
				document.getElementById("nf_eur_cstms_st_nm").className = "input2";
				document.getElementById("nf_eori_no").className = "input2";
				document.getElementById("nf_cust_cty_nm").className = "input2";
				document.getElementById("nf_cstms_decl_cnt_cd").className = "input2";		
				document.getElementById("nf_cust_zip_id").className = "input2";		
			}						
		}
    }

    /**
     * CustCntCd와 CustSeq로 MdmCustomer의 CustNm을 조회하여 화면에 출력한다.
     */
    function searchMdmCustNm(sheetObject,formObj,custTp,custCntCd,custSeq){
    	ComSetObjValue(formObj.f_cmd,SEARCHLIST11);
		var sXml = sheetObject.GetSearchXml("ESM_BKG_0079_05GS.do", "f_cmd="+SEARCHLIST11+"&cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq);
		var custNm = ComGetEtcData(sXml,"cust_nm");
		var custAddr = ComGetEtcData(sXml,"cust_addr");
		var custTpCd = ComGetEtcData(sXml,"rvis_cntr_cust_tp_cd")
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
	    } catch(err) { 
	    	ComFuncErrMsg(err.message); 
	    }
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
	    } catch(err) { 
	    	ComFuncErrMsg(err.message); 
	    }
    }     
     
//	// 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
//	function t7sheet1_OnSearchEnd(sheetObj, ErrMsg){
//		with(sheetObj){
//		}
//	}
	
	// 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	function t7sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg != ""){
			ComBkgSaveCompleted();
		}
	}		

    //0079에서 실행
    function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.modify_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[0], formObj, IBSAVE);				
//			}
		}	
    }
    
    // 0079에서 실행
    function searchData(bkgNo){
    	if(ComIsNull(bkgNo)) return;
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no,bkgNo);
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);        
    }
    
	function bkg007905_keypress(){
    	var srcName = window.event.srcElement.getAttribute("name");
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    switch(event.srcElement.dataformat){
	    	case "engup":
	    		//영문대문자
    			ComKeyOnlyAlphabet('upper');
    			break;	      
	    	case "eoriengupnum":
            	ComKeyOnlyAlphabet('uppernum','45');
	    		break;
	    	case "engupnum":
	    		//숫자+"영문대분자"입력하기
	    		ComKeyOnlyAlphabet('uppernum');
	    		break;	    		
            case "engupspace": //영문대문자 + Space
	          	if(event.keyCode != 32) {
	          		ComKeyOnlyAlphabet('uppernum');
	          	}	        
            case "custname":
            	//숫자+"영문대분자"입력하기
            	ComKeyOnlyAlphabet('uppernum','32');
            	break;
            case "engdnnum":
            	//숫자+"영문대분자"입력하기
	      	  	ComKeyOnlyAlphabet('lowernum');
	      	  	break;
            case "int":
            	//숫자 입력하기
            	ComKeyOnlyNumber(event.srcElement);
            	break;	            
            case "address":
            	//숫자+"영문대분자"입력하기
            	ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
            	break;
            case "num":
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
	    
    	if(srcName == "bkg_no" || srcName == "bl_no"){
    		if(event.keyCode == 13){
    			var formObj = document.form;
    	    	var srcName = window.event.srcElement.getAttribute("name");
    	    	var srcValue = window.event.srcElement.getAttribute("value");
    			formObj.elements[srcName].value = srcValue.toUpperCase();
    			ComKeyEnter();
    		}
    	} 
	}           
	
	function bkg007905_click(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	if(srcName == "sam_cnee_copy_flg"){
    		if(formObject.sam_cnee_copy_flg.checked){
    			if(!ComIsNull(formObject.nf_cust_nm.value) || !ComIsNull(formObject.nf_cust_addr.value)){
					if(ComShowCodeConfirm("BKG00343")){
						ComSetObjValue(formObject.nf_cust_nm,ComGetObjValue(formObject.cn_cust_nm));
						ComSetObjValue(formObject.nf_cust_addr,ComGetObjValue(formObject.cn_cust_addr));
						ComSetObjValue(formObject.nf_cust_cty_nm,ComGetObjValue(formObject.cn_cust_cty_nm));
						ComSetObjValue(formObject.nf_cust_ste_cd,ComGetObjValue(formObject.cn_cust_ste_cd));
						ComSetObjValue(formObject.nf_cstms_decl_cnt_cd,ComGetObjValue(formObject.cn_cstms_decl_cnt_cd));
						ComSetObjValue(formObject.nf_cust_zip_id,ComGetObjValue(formObject.cn_cust_zip_id));
						ComSetObjValue(formObject.nf_cust_fax_no,ComGetObjValue(formObject.cn_cust_fax_no));
						ComSetObjValue(formObject.nf_cust_eml,ComGetObjValue(formObject.cn_cust_eml));						
					}  			    				
    			}else{
					ComSetObjValue(formObject.nf_cust_nm,ComGetObjValue(formObject.cn_cust_nm));
					ComSetObjValue(formObject.nf_cust_addr,ComGetObjValue(formObject.cn_cust_addr));
					ComSetObjValue(formObject.nf_cust_cty_nm,ComGetObjValue(formObject.cn_cust_cty_nm));
					ComSetObjValue(formObject.nf_cust_ste_cd,ComGetObjValue(formObject.cn_cust_ste_cd));
					ComSetObjValue(formObject.nf_cstms_decl_cnt_cd,ComGetObjValue(formObject.cn_cstms_decl_cnt_cd));
					ComSetObjValue(formObject.nf_cust_zip_id,ComGetObjValue(formObject.cn_cust_zip_id));
					ComSetObjValue(formObject.nf_cust_fax_no,ComGetObjValue(formObject.cn_cust_fax_no));
					ComSetObjValue(formObject.nf_cust_eml,ComGetObjValue(formObject.cn_cust_eml));					
    			}
    		}
    		formObject.modify_flag.value = "Y"; 
    	}else if(srcName == "sh_addr_prn_flg"||srcName == "cn_addr_prn_flg"||srcName == "nf_addr_prn_flg"
    		||srcName == "ff_addr_prn_flg"||srcName == "an_addr_prn_flg"||srcName == "ex_addr_prn_flg"){
    		formObject.modify_flag.value = "Y";   		
    	}
	}

	function bkg007905_change(){
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");

    	if(srcName == "sh_cust_cnt_cd"||srcName == "sh_cust_seq"||srcName == "sh_cust_nm"||srcName == "sh_cust_addr"
    		||srcName == "sh_cust_cty_nm"||srcName == "sh_cust_ste_cd"||srcName == "sh_cstms_decl_cnt_cd"||srcName == "sh_cust_zip_id"){    		
   			formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "cn_cust_cnt_cd"||srcName == "cn_cust_seq"||srcName == "cn_cust_nm"||srcName == "cn_cust_addr"
    		||srcName == "cn_cust_cty_nm"||srcName == "cn_cust_ste_cd"||srcName == "cn_cstms_decl_cnt_cd"||srcName == "cn_cust_zip_id"
    		||srcName == "cn_cust_fax_no"||srcName == "cn_cust_eml"){    		
   			formObject.modify_flag.value = "Y";      
    	} else if(srcName == "nf_cust_cnt_cd"||srcName == "nf_cust_seq"||srcName == "nf_cust_nm"||srcName == "nf_cust_addr"
    		||srcName == "nf_cust_cty_nm"||srcName == "nf_cust_ste_cd"||srcName == "nf_cstms_decl_cnt_cd"||srcName == "nf_cust_zip_id"
    		||srcName == "nf_cust_fax_no"||srcName == "nf_cust_eml"){    		
   			formObject.modify_flag.value = "Y";      
    	} else if(srcName == "ff_cust_cnt_cd"||srcName == "ff_cust_seq"||srcName == "ff_cust_nm"){    		
   			formObject.modify_flag.value = "Y";   
		}else if(srcName == "an_cust_cnt_cd"||srcName == "an_cust_seq"||srcName == "an_cust_nm"
			||srcName == "an_cust_fax_no"||srcName == "an_cust_eml"){    		
			formObject.modify_flag.value = "Y";   	  
    	} else if(srcName == "ex_cust_cnt_cd"||srcName == "ex_cust_seq"){    	
   			formObject.modify_flag.value = "Y";       
    	}
    	
    	if(srcName == "agmt_act_cnt_cd"){
   			formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "cust_to_ord_flg"){
    		formObject.modify_flag.value = "Y";  
    	} else if(srcName == "ff_ref_no"){    		
   			formObject.modify_flag.value = "Y"; 
    	} else if(srcName == "org_cnt_nm"){    	
   			formObject.modify_flag.value = "Y";   
    	}else if(srcName == "fmc_cd"){    		
			formObject.modify_flag.value = "Y";     
		} else if(srcName == "end_usr_nm"){    		
			formObject.modify_flag.value = "Y";     
		}
	}
	
	 /**
	 * 마우스 아웃일때 
	 */
    function bkg007905_deactivate() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
    	
    	if(srcName == "sh_cust_cnt_cd"){
    		if(ComChkLen(srcValue, srcMaxLength) == "2" && srcValue == "KR"){
    			if("Y"!=ComGetObjValue(formObject.bdr_flg) || "N"!=ComGetObjValue(formObject.ca_flg)){
					comboEnable(true);
				}
    		}
    		if(ComGetObjValue(formObject.sh_cust_cnt_cd) == "KR"
					&& (Number(ComGetObjValue(formObject.sh_cust_seq)) == 695 || Number(ComGetObjValue(formObject.sh_cust_seq)) == 37635)){
    			formObj.kr_cstms_cust_tp_cd.Code = "C";
			}
    	}else if(srcName == "sh_cust_seq"){  
    		if(ComIsNull(srcValue)){
    			formObject.sh_cust_lgl_eng_nm.value = "";
    		}else{
    			formObject.sh_cust_seq.value = ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.sh_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"SH",formObject.sh_cust_cnt_cd.value,formObject.sh_cust_seq.value);
    			}    			
    		} 
    	}else if(srcName == "cn_cust_seq"){    		
    		if(ComIsNull(srcValue)){
    			formObject.cn_cust_lgl_eng_nm.value = "";
    		}else{
    			formObject.cn_cust_seq.value = ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.cn_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"CN",formObject.cn_cust_cnt_cd.value,formObject.cn_cust_seq.value);        					
    			}		
    		}   		
    	}else if(srcName == "nf_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.nf_cust_lgl_eng_nm.value = "";
    		}else{
    			formObject.nf_cust_seq.value = ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.nf_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"NF",formObject.nf_cust_cnt_cd.value,formObject.nf_cust_seq.value);
    			}
    		}   			
    	}else if(srcName == "ff_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.ff_cust_lgl_eng_nm.value = "";
    		}else{
    			formObject.ff_cust_seq.value = ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.ff_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"FF",formObject.ff_cust_cnt_cd.value,formObject.ff_cust_seq.value);  				
    			}
    		}       			
    	}else if(srcName == "an_cust_seq"){
    		if(ComIsNull(srcValue)){
    			formObject.an_cust_lgl_eng_nm.value = "";
    		}else{
    			formObject.an_cust_seq.value = ComLpad(srcValue,6,"0");    			
    			if(ComChkLen(formObject.an_cust_cnt_cd.value, 2) == "2"){
        			searchMdmCustNm(sheetObjects[0],formObject,"AN",formObject.an_cust_cnt_cd.value,formObject.an_cust_seq.value);	
    			}    			
    		}       			
    	} else if (srcName == "bkg_no" || srcName == "bl_no") {
    		formObject.elements[srcName].value = srcValue.toUpperCase();
    	} else if (srcName == "sh_eori_no") {
    		var str = formObject.sh_eori_no.value;
    		if (regExp.test(str)) {
    			var t = str.replace(regExp, "");
    			formObject.sh_eori_no.value = t;
    		}
    	} else if (srcName == "cn_eori_no") {
    		var str = formObject.cn_eori_no.value;
    		if (regExp.test(str)) {
    			var t = str.replace(regExp, "");
    			formObject.cn_eori_no.value = t;
    		}
    	} else if (srcName == "nf_eori_no") {
    		var str = formObject.nf_eori_no.value;
    		if (regExp.test(str)) {
    			var t = str.replace(regExp, "");
    			formObject.nf_eori_no.value = t;
    		}
    	}
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
	
	// BlNo Information 풍선도움말 관련
	function blNoSet(){
		var obj = document.form.bl_no;
		var stop=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight+5;
		var sleft = document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft+obj.offsetLeft+7; 
		orgBlNo.style.left=sleft;
		orgBlNo.style.top=stop;	
		
		var strMsg = document.form.org_bl_no.value;
		if(strMsg != ""){
			text ='<table  width=115  bgcolor=#FFFFCC style="border:1 black solid;font-family: Tahoma,Arial,dotum,gulim; font-size: 12px;"><tr><td>' + strMsg + '</td></tr></table>';
			orgBlNo.innerHTML=text;
		}
	}

	function blNoHide(){
		orgBlNo.innerHTML='';
	}		

    function kr_cstms_cust_tp_cd_OnChange(Code, Text){
    	//alert(comboObjects[0].Code);
	}      
      
	/**
	 * Manifest Type을 설정한다.
	 */	 
	function comboEnable(val){
		comboObjects[0].Enable = val;
	}
	 
    function replaceAll(str, orgStr, repStr){
    	return str.split(orgStr).join(repStr); 
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
  			
  			if(formObj.agmt_act_cnt_cd.value ==""){
  	    		document.getElementById("del_btn").style.display = "none";
  			}else{	
  				document.getElementById("del_btn").style.display = "block";
  			}  			
  			formObj.modify_flag.value = "Y";
  		}
    }       

	/**
     * B/L Customer 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackSh0192(rArray, rArray2);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
     */
    function callBackSh0192(rArray, rArray2) {
    
    	
  		var formObj = document.form;  		
  		if (rArray2) {
  			
  			if (!ComIsNull(formObj.sh_cust_nm) || !ComIsNull(formObj.sh_cust_addr)) {
  	  			if (!ComShowCodeConfirm("BKG00343")) return;
  	  		}
  			if("KR"==rArray2[1] && ("Y"!=ComGetObjValue(formObj.bdr_flg) || "N"!=ComGetObjValue(formObj.ca_flg)) ){
  				comboEnable(true);
  			}
  			

  	  		ComSetObjValue(formObj.sh_cust_cnt_cd      , rArray2[1]);
  	  		ComSetObjValue(formObj.sh_cust_seq         , ComLpad(rArray2[2],6,"0"));

  	  		
  	  		if (!ComIsEmpty(rArray2[6]) && ComIsEmpty(formObj.sh_cust_nm)) {
  	  			ComSetObjValue(formObj.sh_cust_nm      , getMakeBrData("NAME",rArray2[6]) + "\n");
  	  		}
  	
  	  		if (!ComIsEmpty(rArray2[7]) && ComIsEmpty(formObj.sh_cust_addr)) {

  	  	
  	  			
  	  			ComSetObjValue(formObj.sh_cust_addr    , replaceAll(getMakeBrData("ADDR",rArray2[7]), "@*", "\n"));
  	  		}
  	  		ComSetObjValue(formObj.sh_cust_cty_nm      , rArray2[11]);  //City
  	  		ComSetObjValue(formObj.sh_cust_ste_cd      , rArray2[13]);  //State
  	  		ComSetObjValue(formObj.sh_cstms_decl_cnt_cd, rArray2[14]);  //Country
  	  		ComSetObjValue(formObj.sh_cust_zip_id      , rArray2[15]);  //ZIP Code
  	  		ComSetObjValue(formObj.sh_eur_cstms_st_nm  , rArray2[17]);  //Street / P.O.Box
  	  		ComSetObjValue(formObj.sh_eori_no          , rArray2[18]);  //EORI#
  			searchMdmCustNm(sheetObjects[0],formObj,"SH",rArray2[1],rArray2[2]);
  		} else {
  			
  			if(rArray != null && "KR"==rArray[1] && ("Y"!=ComGetObjValue(formObj.bdr_flg) || "N"!=ComGetObjValue(formObj.ca_flg)) ){
  				comboEnable(true);
  			}
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
  		ComSetObjValue(formObj.modify_flag, "Y");
    }

	/**
     * B/L Customer 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackCn0192(rArray, rArray2);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
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
//	  			ComSetObjValue(formObj.cn_cust_cty_nm, rArray[10]);  //City
//	  			ComSetObjValue(formObj.cn_cust_ste_cd, rArray[11]);  //State
//	  			ComSetObjValue(formObj.cn_cust_zip_id, rArray[12]);  //ZIP Code
	  			ComSetObjValue(formObj.cn_cust_cty_nm, rArray[10]);  //City
	  			ComSetObjValue(formObj.cn_cust_ste_cd, rArray[12]);  //State
	  			ComSetObjValue(formObj.cn_cust_zip_id, rArray[14]);  //ZIP Code
			}
  		}
  		ComSetObjValue(formObj.modify_flag, "Y");
	}

	/**
	 * B/L Customer 에서 전달받은 값 저장 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     callBackNf0192(rArray, rArray2);
	 * </pre>
	 * @param Popup에서 전달받은 값
	 * @return 없음
	 * @author 김병규
	 * @version 2009.05.14
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
  		ComSetObjValue(formObj.modify_flag, "Y");
	}

    /**
     * B/L Customer 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackFf0192(rArray, rArray2);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
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
  		ComSetObjValue(formObj.modify_flag, "Y");
	}

	/**
     * B/L Customer 에서 전달받은 값 저장 <br>
     * <br><b>Example :</b>
     * <pre>
     *     callBackAn0192(rArray, rArray2);
     * </pre>
     * @param Popup에서 전달받은 값
     * @return 없음
     * @author 김병규
     * @version 2009.05.14
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
			ComSetObjValue(formObj.an_cust_fax_no, rArray2[9]);
			ComSetObjValue(formObj.an_cust_eml   , rArray2[16]);
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray2[1],rArray2[2]);
		} else {
			formObj.an_cust_cnt_cd.value = rArray[0];
			formObj.an_cust_seq.value = ComLpad(rArray[1],6,"0");
			searchMdmCustNm(sheetObjects[0],formObj,"AN",rArray[0],rArray[1]);
		}   		    		
  		ComSetObjValue(formObj.modify_flag, "Y");
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
			ComSetObjValue(formObj.ex_cust_cnt_cd, rArray2[1]);
			ComSetObjValue(formObj.ex_cust_seq   , ComLpad(rArray2[2],6,"0"));
		} else {
			ComSetObjValue(formObj.ex_cust_cnt_cd, rArray[0]);
			ComSetObjValue(formObj.ex_cust_seq   , ComLpad(rArray[1],6,"0"));
		}   		    		
  		ComSetObjValue(formObj.modify_flag, "Y");
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

    function bkgChgOfcSheet_OnSearchEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {
    		var formObj = document.form;
    		var isSearch = true;
    		if (1 < sheetObj.Rows) {
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
    		
    		if (isSearch) {
    			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    		}
    	}
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
	
    function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
    	var formObj = document.form;

    	if(lOfc == null || lRep == null){
    		
    	}
    	if(ComGetObjValue(formObj.bdr_flg) != "Y" || ComGetObjValue(formObj.ca_flg) != "N"){
	    	// SHPR,FWDR,CNEE 입력
	    	if(rArray1 != null){
				ComSetObjValue(formObj.ob_sls_ofc_cd, lOfc);
				ComSetObjValue(formObj.ob_srep_cd,    lRep);
	    	}
    	}
    }       	

/* 개발자 작업  끝 */