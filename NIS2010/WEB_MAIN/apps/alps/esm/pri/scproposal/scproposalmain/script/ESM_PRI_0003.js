/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0003.js
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.08 공백진
* 1.0 Creation 
=========================================================
* History 
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - Ori/Dest , LOC Group, CMDT Group, Arbitrary, GOH 5개 Terms 를 Scope별로 한번에 Accept All 가능하도록 기능 추가.
* 2011.03.30 이행지 [CHM-201109659-01] OTI Bond / Tariff Title page / OTI License Attach / Signing POA 기능 개발(Customer section) 및 Loading Agent POA Attach(L/Agent section) 기능 개발요청
*                                    - POA Attach File 첨부기능 추가
* 2011.04.06 김민아 [CHM-201109786-01] DEM/DET(DAR) 승인 관련 기능 개선 - 미승인 DEM/DET이 존재할 경우 해당하는 General Rate, Special Rate, Special Note의  Scope 별 bullet 정보를 알림.
* 2011.04.22 이행지 [선조치] TPE가 들어있는 SC일 경우만 Customer, Affiliate 팝업에 Attach File 첨부기능 활성화 및 저장 Validation 체크하도록 Parameter 넘겨줌.
* 2011.05.11 김민아 [CHM-201110738-01] Quick Accept시 ARB Update 오류 - 파라미터 prop_sts_cd 추가
* 2011.05.13 김민아 [CHM-201110785-01] ANW03588 에 대해서 S/C Copy 요청 -  NVOCC Customer의 경우 G.Rate, OAR, DAR Copy를 막아 놨는데 급하게 오늘 구주의 특정 S/C를 copy 하고 싶다는 요청 수용을 위해 임시 코드 작성.
* 2011.05.24 서미진 [CHM-201110931-01] Amend No. 0 이고 Initial일때, Request상태에서 Accept 된 Customer는 Request cancel 후 Customer변경 할 수 없도록 수정
* 2012.02.03 이석준 [CHM-201215685] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 추가 컬럼 조회 반영
* 2012.02.13 서미진 [CHM-201216154] E-mail 버튼을 click 할 경우 자동으로 메일 창이 연결이 되어서 담당 sales rep 한테 메일 보낼 수 있는 환경 조성
* 2012.02.23 서미진 [CHM-201216399] 일반 메일이 아닌 GW 메일창 팝업으로 변경
* 2012.04.18 이석준 [CHM-201217045-01] S/C Filed Cancel 기능및 조회 기능 추가
* 2012.04.20 서미진 [CHM-201217458] Approved 상태에서만 활성화 되던 버튼을 Request 단계에서부터 활성화로 변경
* 2012.04.26 이석준 [CHM-201217481] Amend일때 Reefer, Garment 체크 기능 활성화
* 2012.07.20 송호진 [CHM-201218988] PRS ROUTE CASE 비용 산출 배치 작업 요청 7월 관련 수정
* 2013.01.21 이은섭 [CHM-201322418-01] S/C 의 "Flied Cancel" 기능 관련 변경
* 2013.03.19 전윤주 [CHM-201323647] ALPS 통합로그 SQL 오류 제거 - customer 검색 시 customer seq. 자리에 숫자가 들어오지 않는 경우 validation 처리
* 2013.03.19 전윤주 [CHM-201323648] Contract S.rep code validation logic 수정 - space를 강제 선택했을 경우 validatoin 되도록 추가
* 2013.05.14 전윤주 [CHM-201324672] S/C Real Customer multi 허용 Customer type 추가 ('A' Type 추가)
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2013.07.01 송호진 [CHM-201325493] S/C Filed stats cancel 기능 사용 유저 추가 요청 - 안혜인 과장님 (0660082) 추가  
* 2013.10.21 전윤주 [CHM-201327107] S/C Note 하 Chassis 항목 추가
* 2014.01.27 전윤주 [CHM-201428663] S/C Filed cancel 버튼 권한 부여 요청 (cancel user 추가)
* 2014.04.01 전윤주 [CHM-201429648] S/C Note 하 Chassis Item 입력 시 체크하는 validation 로직 주석 해제
* 2014.04.17 전윤주 [CHM-201429927] 미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block 기능 개발
* 2014.05.28 전윤주 [CHM-201430580] FMC 자동 filing 기능 추가
* 2014.09.02 송호진 [CHM-201431827] Filed Cancel 권한 부여 요청 추가
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.09.24 송호진 [CHM-201432052] Filed Cancel 권한 부여 요청 추가
* 2014.11.20 송호진 [CHM-201432557] S/C scope duration 로직 수정 - 신규 Svc Scp 의 경우 Delete Button Enable
* 2014.12.22 송호진 [CHM-201432563] S/C Standard Note Validation 로직 보완
* 2015.03.30 송호진 [CHM-201534006] Scope 영역 (Amd 색상 처리 표시 규칙) & NO GRI 및 No New SCHG 프로세스 변경
* 2015.04.22 송호진 [CHM-201535019] Customer Type = A 에 Actual Customer 란 활성화 요청
* 2015.05.15 최성환 [CHM-201535632] Affiliate 내 Type 란 생성 및 Type 간 혼재 불가 로직 
* 2015.08.23 최성환 [CHM-201537109] Split19-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.09.25 최성환 [CHM-201537788] SC 다운로드 보안 강화_2차 개발
* 2015.11.09 최성환 [CHM-201538667] ALPS S/C Autofiling 관련 보완 요청
* 
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
     * @class ESM_PRI_0003 : ESM_PRI_0003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0003() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    //탭이동시 이전탭의 위치를 기억하기 위한 변수
    var beforetab = 1;    
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    var comboObjects = new Array();
    var comboCnt = 0;

    //수정 후 수정한 scope으로 focus를 이동 하기 위한 변수
    var saveSvcScpCd = "";
    //New 버튼 클릭시 탭이외 control이 Hidden일 경우 Hidden부분을 Display 하기위한 변수 
    var controlHidden = false;
    //Back End Job 수행 횟수 (지정된 횟수 이상 실행 방지)
    var backEndJobCnt = 0;
    
    //IHC Tab  을 enable,disable시킨다. 
    var ihcTabSts = true;
    //Special Note Dem/Det  저장여부확인(수정 후 저장이 안되어 있다면 탭이동금지)
    var returnValue = "Y";
    
    //각 Terms의 상태를 보여주기위한 아이콘 주소 변수
    var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
    var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";
    var ICON_URL_AMEND = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon4.gif";
    var ICON_URL_ACCEPT = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon3.gif";
    
    //tab을 활성,비활성 상태로 보이게 하기위하여 지정하는 tab color
//    var TAB_SELECT_COLOR = "131,133,217"; 
    var TAB_TRUE_COLOR = "206,220,246";
    var TAB_FALSE_COLOR = "192,192,192";    
    
	 /*
	  *  숨겨진 기능인 super user 권한을 가졌는지 여부 
	  */
	 var IS_SUPER_USER = false;
	 var superUserRoute = "";
	 var STANDARD_SUPER_USER_ROUTE = "btn_new|no_btn_amend|no_btn_request|no_btn_coffer|no_btn_approve|no_btn_scnoassign|no_btn_file|no_btn_cancel|no_btn_copy|no_btn_print|no_btn_prop_mqc_pop|no_btn_ctrt_pty_pop";
	 
//	 var FILE_CANCEL_ID  = "0010244";
//	 var FILE_CANCEL_ID2 = "0010593";
//	 var FILE_CANCEL_ID3 = "0660082";
//	 var FILE_CANCEL_ID4 = "0810022";
//	 var FILE_CANCEL_ID5 = "0810071";
//	 var FILE_CANCEL_ID6 = "0810273";
//	 var FILE_CANCEL_ID7 = "Clairelee";
//	 var FILE_CANCEL_ID8 = "0260062"; // CHM-201431827 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID9 = "1110071"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID10 = "1110093"; // CHM-201432052 - Filed Cancel 권한 부여 요청 추가
//	 var FILE_CANCEL_ID11 = "0310064"; // CHM-201537788 Filed Cancel 권한 부여 요청 추가
	 
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function processButtonClick() {
        /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
    
        /** **************************************************** */
        var formObj = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
        	/*
        	 * 숨겨진 기능인 super user 검증을 위한 로직
        	 */
        	verifySuperUser(srcName);
        	
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {     
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }

            switch (srcName) {
            case "btn_hidden":            	
            	setControlHidden();
            	break;
            	
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
    
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                break;
                
            case "btn_amend":   
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }   
    	        /////////////////////////////////////////////////////////////////////
    	        // update date 검사
    	        var checkSheetObj = sheetObjects[0];
    	        var checkTpCd = "CHECK2";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        /////////////////////////////////////////////////////////////////////
                
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");                
                var sParam = "sc_no="+sSc_No+"&sEffDt="+sheetObjects[0].CellValue(1,"eff_dt") 
                		   + "&sExpDt="+sheetObjects[0].CellValue(1,"exp_dt");
            
                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0036.do?"+sParam, "", 500, 250, true);               
                if(str){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }
                break;              
                
            case "btn_dur_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");
                var sSvcScpCd = "";
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg"); 
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq
                		  + "&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd 
                		  + "&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr
                		  + "&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg +"&sLgcyIfFlg="+sLgcyIfFlg;
                var rtnVal = ComPriOpenWindowCenter ("/hanjin/ESM_PRI_0019.do?"+sParam, "", 640, 315, true);
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }
            
                break;          

            case "btn_ctrt_pty_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }                   
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sEffDt = sheetObj.CellValue(1, "eff_dt");
                var sExpDt = sheetObj.CellValue(1, "exp_dt");       
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");
                var sCustCntCd = sheetObj.CellValue(1, "cust_cnt_cd");
                var sCustSeq = ComLpad(sheetObj.CellValue(1, "cust_seq"), 6, "0");                        
                var sCustNm = encodeURIComponent(sheetObj.CellValue(1, "ctrt_pty_nm"));
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg");
                var sCtrtEffDt = document.form.ctrt_eff_dt.value;

                var sCtrtCustTpCd = formObj.prc_ctrt_cust_tp_cd.Code;
                
                var isTpe = checkOtiSvcScp();
                
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="
                             +sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt+"&sCustCntCd="+sCustCntCd+"&sCustSeq="+sCustSeq+"&sCustNm="+sCustNm
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg+"&sCtrtCustTpCd="+sCtrtCustTpCd+"&sCtrtEffDt="+sCtrtEffDt+"&isTpe="+isTpe;
            
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0022.do?"+sParam, "", 1000, 350, true);
  
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }                   
                break;      
                
            case "btn_ctrt_cust_tp_pop":            
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");             
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sEffDt = sheetObj.CellValue(1, "eff_dt");
                var sExpDt = sheetObj.CellValue(1, "exp_dt");       
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");                
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg");
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+"&sPropStsCd="
                             +sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt+"&sSrepCd="+sSrepCd
                             +"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0017.do?"+sParam, "", 600, 215, true);

                
                if(rtnVal != null && rtnVal !=""){
//                    var flag = sheetObj.RowStatus(1);
//                	comboObjects[2].Text(rtnVal);
//                	sheetObj.RowStatus(1) = flag;
                	
                	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }
                break;  
                
            case "btn_ctrt_cust":
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.cust_cnt_cd.value+"&cust_seq="+formObj.cust_seq.value, "", 640, 465, true);
            	var rSC_no = formObj.sc_no.value;
            	
            	if (rtnVal != null){
                    formObj.cust_cnt_cd.value = rtnVal.custCntCd;
                    formObj.cust_seq.value = rtnVal.custSeq;
                    formObj.ctrt_pty_nm.value = rtnVal.custNm;                    
                    custNameFind("cust_cnt_cd");
                    //sale rep
                    setCustSaleRep();
                    comboObjects[3].Code2 = sheetObjects[0].CellValue(1,"ctrt_cust_srep_cd");   
                    com_change_sheet( sheetObjects[0], "cust_seq");
                }

                break;  
            case "btn_eff_dt":
                var sheetObj = sheetObjects[0];
                var sScNo = sheetObj.CellValue(1,"sc_no");             

                var prop_no = sheetObj.CellValue(1,"prop_no");       
                var amdt_seq = sheetObj.CellValue(1,"amdt_seq");       

                var sParam = "sScNo="+sScNo+"&sPropNo="+prop_no+"&sAmdtSeq="+amdt_seq+"&sEffDt="+sheetObjects[0].CellValue(1,"eff_dt") 
                           + "&sExpDt="+sheetObjects[0].CellValue(1,"exp_dt");
              
                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0037.do?"+sParam, "", 500, 250, true);               
                if(str){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }
                break;
            case "btn_real_cust":          
            	if(sheetObjects[0].RowCount("U|D|I") !=0  
            	 || sheetObjects[1].RowCount("U|D|I") !=0  ){
            		ComShowCodeMessage('PRI01057');
            		return false;
            	}
            	var svcScpCnt = sheetObjects[1].RowCount("U|R|I");
            	var sSvcScpCd = "";
            	for(var i=sheetObjects[1].HeaderRows ; i <= svcScpCnt ; i++ ){
            		if( sSvcScpCd == "" ){
            			sSvcScpCd =  sheetObjects[1].CellValue(i, "svc_scp_cd");	
            		}else{
            			sSvcScpCd = sSvcScpCd + "|"+ sheetObjects[1].CellValue(i, "svc_scp_cd");
            		}
            	}
            	var rSC_no = formObj.sc_no.value;
            	var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0040.do?is_popup=true&amdt_seq="+formObj.amdt_seq.value+"&prop_no="+formObj.prop_no.value+"&cust_tp="+formObj.prc_ctrt_cust_tp_cd.Code+"&Sc_No1="+rSC_no.substring(0,3)+"&Sc_No2="+rSC_no.substring(3,rSC_no.length)+"&svc_scp_cd="+sSvcScpCd, "", 980, 350, true);

            	if (rtnVal != null){
                    formObj.real_cust_cnt_cd.value = rtnVal.custCntCd;
                    formObj.real_cust_seq.value = rtnVal.custSeq;
                    formObj.real_cust_nm.value = rtnVal.custNm; 
                    formObj.real_cust_srep_cd.value = rtnVal.custSrepCd;
                    realCustNameFind("real_cust_cnt_cd");
                    //sale rep
                    setRealCustSaleRep();
                    comboObjects[5].Code2 = sheetObjects[0].CellValue(1,"real_cust_srep_cd");
                    com_change_sheet( sheetObjects[0], "real_cust_seq");

                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }           
                break;

            case "btn_prop_mqc_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");             
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");   
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sSvcScpCd = "";
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg");
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sDurDupFlg="+sDurDupFlg
                			+"&sPreExpDt="+sPreExpDt+"&sLgcyIfFlg="+sLgcyIfFlg;
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0020.do?"+sParam, "", 640, 330, true);

                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }                   
                break;      
                
            case "btn_prop_pfmc_pop":                
                if (formObj.sc_no.value ==""){
                    ComShowCodeMessage('PRI01061');
                    return;
                }
	
	 			var pgmNo = "ESM_PRI_0108";
	 			var pgmUrl = "/hanjin/ESM_PRI_0108.do"
	    		var params = "&cond_sc_no=" + formObj.sc_no.value;
				var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
				var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);              	
            	                
                break;                
                
            case "btn_save":             	
                var effDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
                var sEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
                if (effDt != sEffDt){
                	com_change_sheet( sheetObjects[0], "ctrt_eff_dt" );
                }

                 doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
                
            case "btn_request": 
            	doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
                break; 
            	
            case "btn_coffer":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                doActionIBSheet(sheetObjects[0],document.form,COMMAND03);

                break;
                
            case "btn_approve":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
                break;
                
            case "btn_scnoassign":
                
                var sheetObj = sheetObjects[0];
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var ctrtEffDt = formObj.ctrt_eff_dt.value;
                var ctrtExpDt = formObj.ctrt_exp_dt.value;
                var svcScpCd = sheetObjects[1].CellValue(1,"svc_scp_cd");
                var svcCnt = sheetObjects[1].RowCount;
                var ofcCd = sheetObj.CellValue(1,"prop_ofc_cd");
                var sParam =  "sPropNo="+sPropNo+"&amdt_seq="+sAmdtSeq+"&sCtrtEffDt="+ctrtEffDt
                            +"&sCtrtExpDt="+ctrtExpDt+"&svcScpCd="+svcScpCd+"&svcCnt="+svcCnt+"&sOfcCd="+ofcCd  ;
                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0056.do?"+sParam, "", 550, 180, true);

                if(rtnVal !=null && rtnVal[0] =="Y"){
                    document.form.sc_no.value = rtnVal[1];
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//                    if (sAmdtSeq == 0) {
//                        // Groupware Mail
//                        ComOpenWait(true); //->waiting->start 
//                        openGroupWareMailPopup(sheetObjects[0], formObj, sheetObjects[0].CellValue(1, "prop_sts_cd"));
//                        ComOpenWait(false); //->waiting->End
//                    }
                }
                break;
                
            case "btn_file":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
    	        /////////////////////////////////////////////////////////////////////
    	        // update date 검사
    	        var checkSheetObj = sheetObjects[0];
    	        var checkTpCd = "CHECK1";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        /////////////////////////////////////////////////////////////////////
                
                var sheetObj = sheetObjects[0];
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var ctrtEffDt = formObj.ctrt_eff_dt.value;
                var ctrtExpDt = formObj.ctrt_exp_dt.value;
                var sSc_No = sheetObj.CellValue(1,"sc_no"); 
                var sEffDt = sheetObj.CellValue(1, "eff_dt");
                var sSlsLdNo = sheetObj.CellValue(1, "sls_ld_no");
                var sParam =  "sPropNo="+sPropNo+"&amdt_seq="+sAmdtSeq+"&sCtrtEffDt="+ctrtEffDt
                			 +"&sCtrtExpDt="+ctrtExpDt+"&sSc_No="+sSc_No+"&sEffDt="+sEffDt+"&sSlsLdNo="+sSlsLdNo;
                
//              var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0058.do?"+sParam, "", 420, 215, true);             
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0058.do?"+sParam, "", 1024, 230, true); // FMC Auto filing 반영 제외. FMC Auto filing 반영할 때 추가해야 함.
                if(rtnVal != null && rtnVal == "Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                    
                }
                break;                   
            case "btn_cancel":            	
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }   
                doActionIBSheet(sheetObjects[0],document.form,COMMAND05);                
                break;              

            case "btn_copy":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");             
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sCustTp = document.form.prc_ctrt_cust_tp_cd.Code;
                
                var sParam = "sc_no="+sSc_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                sParam = sParam + "&cust_tp=" + sCustTp + "&is_super=" + (IS_SUPER_USER == true ? "Y":"N");
                                
                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0096.do?"+sParam, "", 910, 300, true);                
                if(str != null){
                    formObj.prop_no.value = str;
                    formObj.sc_no.value ="";
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }
                break;  
                
            case "btn_print":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                var sheetObj = sheetObjects[0];
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sScNo = sheetObj.CellValue(1,"sc_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sParam = "";    
                var prop_sts_cd = sheetObj.CellValue(1, "prop_sts_cd");  
                var rtnVal = "";
                
                //현재 화면에서 RD 호출 하는 화면으로 화면ID 전달 
                var sSpScrnEvntPgmCd = "ESM_PRI_0003"; 
                
                var isPrintFull = "";
                if(sAmdtSeq != "0"&&sheetObjects[0].CellValue(1,"n1st_if_flg")=="Y"){
                	execScript("rtn = msgbox(\"" + "Do you want to download full version for filing new format?\"+Chr(13)+\"                 [Yes = Full S/C ,  No = Amend Draft]" + "\", 3, \"S/C Print\")", "vbscript");
                	isPrintFull = rtn;
                }

                if (sAmdtSeq == "0"||isPrintFull == 6){
                	sParam = "prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                    rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0061.do?"+sParam  +"&sp_scrn_evnt_pgm_cd=" + sSpScrnEvntPgmCd  , "", 1024, 768, true);
//                    rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0061.do?"+sParam, "", 1024, 768, true); //적용전
                }else if (isPrintFull != 2){
                	sParam = sPropNo + ":" + sScNo + ":" + sAmdtSeq + ";"
                	rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+sParam   +"&sp_scrn_evnt_pgm_cd=" + sSpScrnEvntPgmCd   , "", 1024, 768, true);
//                		rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+sParam, "", 1024, 768, true);  //적용전
                }

                break;            	
//                if (formObj.prop_no.value ==""){
//                    ComShowCodeMessage('PRI01021');                    
//                    return;
//                }
//                var sheetObj = sheetObjects[0];
//                var sPropNo = sheetObj.CellValue(1,"prop_no");
//                var sScNo = sheetObj.CellValue(1,"sc_no");
//                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
//                var sParam = "";    
//                var prop_sts_cd = sheetObj.CellValue(1, "prop_sts_cd");   
//                var rtnVal = "";
//                var isPrintFull ="";
//
//                if(sAmdtSeq != "0"&&sheetObjects[0].CellValue(1,"n1st_if_flg")=="Y"){
//                	execScript("isPrintFull = msgbox(\"" + "Do you want to download full version for filing new format?                                                                                                                       " +
//                			"[Yes = Full S/C ,  No = Amend Draft]" + "\", 3, \"Load Excel\")", "vbscript");
//                }
//
//                if (sAmdtSeq == "0"||isPrintFull==6){
//                	sParam = "prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
//                    rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0061.do?"+sParam, "", 1024, 768, true);
//                }else if(isPrintFull==7){
//                	sParam = sPropNo + ":" + sScNo + ":" + sAmdtSeq + ";"
//                	rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0079.do?sParam="+sParam, "", 1024, 768, true);
//                }
//
//                break;
                
            case "btn_blpl_pop":
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }

                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");             
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sEffDt = sheetObj.CellValue(1, "eff_dt");
                var sExpDt = sheetObj.CellValue(1, "exp_dt");       
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");                
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sCtrtEffDt = document.form.ctrt_eff_dt.value;
                var sCtrtExpDt = document.form.ctrt_exp_dt.value;
                var sBlplHdrSeq = sheetObj.CellValue(1, "blpl_hdr_seq"); 
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg");
                
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+
                             "&sPropStsCd="+sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sCtrtEffDt="+sCtrtEffDt
                             +"&sCtrtExpDt="+sCtrtExpDt +"&sBlplHdrSeq="+sBlplHdrSeq+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg;                     
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0023.do?"+sParam, "", 930, 420, true);                
                
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }
                
                break;  
                
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }               
                var sheetObj = sheetObjects[0];
                var sSc_No = sheetObj.CellValue(1,"sc_no");             
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
                var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");
                var sEffDt = sheetObj.CellValue(1, "eff_dt");
                var sExpDt = sheetObj.CellValue(1, "exp_dt");       
                var sPreExpDt = sheetObj.CellValue(1, "pre_exp_dt");    
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");                
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
                var sCtrtEffDt = document.form.ctrt_eff_dt.value;
                var sCtrtExpDt = document.form.ctrt_exp_dt.value;   
                var sLgcyIfFlg = sheetObj.CellValue(1, "lgcy_if_flg");
                var custTpCd = formObj.prc_ctrt_cust_tp_cd.Code;
                
                var isTpe = checkOtiSvcScp();
                
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq+
                             "&sPropStsCd="+sPropStsCd+"&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt
                             +"&sSrepCd="+sSrepCd+"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sCtrtEffDt="+sCtrtEffDt
                             +"&sCtrtExpDt="+sCtrtExpDt+"&sDurDupFlg="+sDurDupFlg+"&sLgcyIfFlg="+sLgcyIfFlg+"&custTpCd="+custTpCd+"&isTpe="+isTpe;                                 
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0025.do?"+sParam, "", 1020, 515, true);

                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }
                break;                  
            
            case "btn_rowadd":
            	/*
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }
                */
                doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
                break;
                
            case "btn_delete":
                doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
                break;      
                
            case "btns_calendar1": //달력버튼
            case "btns_calendar2":
                var cal = new ComCalendarFromTo();                
                cal.select(document.form.ctrt_eff_dt, document.form.ctrt_exp_dt, 'yyyy-MM-dd');

                break;  
            case "conv_cfm_flg":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    formObj.conv_cfm_flg.checked = false;                    
                    return;
                } 
            	conversionConfirm();
            	break;
            	
            	
            case "btn_mqc_estimate":   
            	var sheetObj = sheetObjects[0];
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
	
	 			var pgmNo = "ESM_PRI_6090";
	 			var pgmUrl = "/hanjin/ESM_PRI_6090.do"
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg");
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg");
                var prc_prop_sts_cd = sheetObj.CellValue(1, "prop_sts_cd");
                
                var prop_mqc_qty = formObj.prop_mqc_qty.value;
                var cntr_lod_ut_cd = formObj.cntr_lod_ut_cd.Code;
                var cntr_lod_ut_text = formObj.cntr_lod_ut_cd.Text;
                
                var sParam = "frm_prop_no="+sPropNo
                	+"&frm_amdt_seq="+sAmdtSeq
                	+"&frm_prop_mqc_qty="+prop_mqc_qty
                	+"&frm_cntr_lod_ut_cd="+cntr_lod_ut_cd
                	+"&frm_cntr_lod_ut_text="+cntr_lod_ut_text
                	+"&is_req_usr="+sIsReqUsr
                	+"&is_apro_usr="+sIsAproUsr
                	+"&prc_prop_sts_cd="+prc_prop_sts_cd;
                
 
                var rtnVal = ComOpenWindowCenter("/hanjin/ESM_PRI_6090.do?"+sParam, "ESM_PRI_6090", 500, 380, true);

            	                
                break;                 	
            	
            case "btn_cancel_file": // Superuser만 사용가능한 Cancel filing
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');                    
                    return;
                }   
                doActionIBSheet(sheetObjects[0],document.form,COMMAND06);                
                break;                     
   
        		//Sales Rep에게 e-mail 전송
    		case "btn_srep_mail":
    			if (formObj.prop_srep_cd.Code != "") {
    				sendMail();
    			}
    			break;                
            	
            } // end switch

        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
           	if (srcName == "btn_scnoassign") {
           		ComOpenWait(false); //->waiting->End
           	}
           	
       }
    }

    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */    
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * IBTab Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setTabObject(tab_obj);
     * </pre>
     * @param {ibtab} tab_obj 필수 IBTab Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */    
    function setTabObject(tab_obj) {
        tabObjects[tabCnt++] = tab_obj;
    }
    
    /**
    * IBMulti Combo Object를 배열로 등록 <br>
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
    * 배열은 소스 상단에 정의 <br>
    * <br><b>Example :</b>
    * <pre>
    *     setComboObject(combo_obj);
    * </pre>
    * @param {ibCombo} combo_obj 필수 IBMulti Combo Object
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function loadPage() {
        for (var i = 0; i < sheetObjects.length; i++) { 
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);    
            initSheet(sheetObjects[i], i + 1);   
            
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
            sheetObjects[i].XmlHttpVer = 2;
        }
    
        for (var k = 0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
        }
        
        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        
        initControl();        
        
   	 	var form = document.form;
         if (form.cond_prop_no.value != "") {//다른 화면에서 호출,S/C Proposal & Amendment Inquiry에서 조회
            form.prop_no.value = form.cond_prop_no.value;
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
            doActionIBSheet(sheetObjects[0],form,IBSEARCH);
        }else{
        	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        }
    }
   
     
    /**
     * Axon 이벤트를 처리하기 위하여 EVENT를 Catch한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     initControl()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 	    
     function initControl() {
        //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
        axon_event.addListener ('keyup', "ComKeyEnter('LengthNextFocus')", document.form);        
        axon_event.addListener('change', 'rf_flg_OnChange', 'rf_flg');
        axon_event.addListener('change', 'gamt_flg_OnChange', 'gamt_flg');
        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
	    axon_event.addListener('mouseover', 'btn_delete_OnMouseOver', 'btn_delete');  
        axon_event.addListener('mouseout', 'btn_delete_OnMouseOut', 'btn_delete');
        
     }
     
     /**
     * OnKeyDown event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       
   function obj_keydown(){
       //Proposal No,S/C No. 에서 Enter key조회
       var eleName = event.srcElement.name;
       if (eleName == "prop_no" || eleName == "sc_no"){
	       var keyValue = null;
	       if(event == undefined || event == null) {
	    	   keyValue = 13;
	       }else{
	    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	       }
	       if (keyValue == 13){
	    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	       }
       }
   }
    
     /**
      * OnKeyPress event를 처리한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     obj_keypress()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     
    function obj_keypress() {
        switch (event.srcElement.dataformat) {
            case "engup":
                if (event.srcElement.name == "sc_no" ||event.srcElement.name == "prop_no") {
                    ComKeyOnlyAlphabet('uppernum');
                } else {
                    ComKeyOnlyAlphabet('upper');
                }    
                break;
            case "int":
                ComKeyOnlyNumber(event.srcElement);
                break;
            case "float":
                ComKeyOnlyNumber(event.srcElement, ".");
                break;
            case "ymd":
            	ComKeyOnlyNumber(event.srcElement, "-");
                break;
            default:
        }

    }    
    

    /**
     * OnMouseMove event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_onmousemove()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       
    function obj_onmousemove(){
    	var formObj = document.form;
    	var eleName = event.srcElement.name;
    	
        switch(eleName){
        case "oti_no"://OTI Bond No 표시
        	var title ="";
        	if (formObj.oti_eff_dt.value == "" && formObj.oti_exp_dt.value == "" 
        		&& formObj.oti_lic_no.value == "" && formObj.oti_amt.value == ""){        		
        		document.getElementById("oti_no").title = "...............";
        	}else{
        		title = "License No : "+ formObj.oti_lic_no.value +"\n";
        		title +="Effective      : "+ ComGetMaskedValue(formObj.oti_eff_dt,"ymd")+"\n";  
        		title +="Expires       : " + ComGetMaskedValue(formObj.oti_exp_dt,"ymd")+"\n"; 
        		title +="AMT           : "+ ComAddComma(formObj.oti_amt.value);
            	document.getElementById("oti_no").title = title;        		
        	}
            break;
        default:
 
        }    	
    }
    
    /**
    * Onbeforedeactivate  event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0]; 
        var sheetObj1 = sheetObjects[0];    
        var eleName = event.srcElement.name;

        switch(eleName){
            case "sc_no":    
//                com_change_sheet( sheetObj, eleName );
                break;
            case "prop_no":
//                formObj.prop_no.value = comKeyUpChangeCapital(formObj.prop_no.value);       
                break;
            case "cust_cnt_cd":
                //cust name find
                if (sheetObj.CellValue(1, "cust_cnt_cd") != formObj.cust_cnt_cd.value){
                	if (formObj.cust_cnt_cd.value == ""){
                		clearCustName();
                	}else{
                    	custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        //COMBO를 채워 준 후 조회해온 코드를 채운다.
                        comboObjects[3].Code2 = sheetObj1.CellValue(1,"ctrt_cust_srep_cd"); 
                        //sale lead
                        setSaleLeadCombo(true); 
                        sheetObj.CellValue(1, "sls_ld_no")= ""; 
                	}
                }
                ComChkObjValid(event.srcElement);
                break;          
            case "cust_seq":
                var custSeq = formObj.cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.cust_seq.value = ComLpad(custSeq, 6, "0");
                }
                //cust name find                
                if (ComParseInt(sheetObj.CellValue(1, "cust_seq")) != ComParseInt(formObj.cust_seq.value)){                    
                    if (formObj.cust_seq.value =="" || !ComIsNumber(formObj.cust_seq.value)){  //[CHM-201323647] 숫자가 아닌 경우 clear
                    	clearCustName();
                    }else{
                        custNameFind(eleName);
                        //sale rep
                        setCustSaleRep();
                        comboObjects[3].Code2 = sheetObj1.CellValue(1,"ctrt_cust_srep_cd");                        
                        //sale lead
                        setSaleLeadCombo(true); 
                        sheetObj.CellValue(1, "sls_ld_no")= "";
                    }
                }

                break;
            case "real_cust_cnt_cd":
                //real cust name find
                if (sheetObj.CellValue(1, "real_cust_cnt_cd") != formObj.real_cust_cnt_cd.value){
                    if (formObj.real_cust_cnt_cd.value == "" ){
                    	clearRealCustName();
                    }else{
                        realCustNameFind(eleName);
                        //sale rep
                        setRealCustSaleRep();
                        comboObjects[5].Code2 = sheetObj1.CellValue(1,"real_cust_srep_cd");
                        //sale lead
                        setSaleLeadCombo(true); 
                        sheetObj.CellValue(1, "sls_ld_no")= ""; 
                    }
                }               
                ComChkObjValid(event.srcElement);
                break;          
            case "real_cust_seq":
                var realCustSeq = formObj.real_cust_seq.value; 
                if (realCustSeq.length < 6 && realCustSeq.length != 0 ){
                    formObj.real_cust_seq.value = ComLpad(realCustSeq, 6, "0");
                }            
                //real cust name find               
                if (ComParseInt(sheetObj.CellValue(1, "real_cust_seq")) != ComParseInt(formObj.real_cust_seq.value)){         
                	if ( formObj.real_cust_seq.value == "" ){           
                    	clearRealCustName();
                    }else{
                    	realCustNameFind(eleName);
                        //sale rep
                        setRealCustSaleRep();
                        comboObjects[5].Code2 = sheetObj1.CellValue(1,"real_cust_srep_cd");
                        //sale lead
                        setSaleLeadCombo(true); 
                        sheetObj.CellValue(1, "sls_ld_no")= ""; 
                    }
                }               

                break;      
            case "ctrt_exp_dt":
                com_change_sheet( sheetObj, eleName );
                ComChkObjValid(event.srcElement);   
                break;
            case "ctrt_eff_dt":
                com_change_sheet( sheetObj, "ctrt_eff_dt" );
                ComChkObjValid(event.srcElement);   
                break;

            case "prop_mqc_qty":
                com_change_sheet( sheetObj, eleName );  
                break;              
            case "prop_ofc_cd"://Request Office 변경 시 Sales Rep.콤보 변경
                if (sheetObj.CellValue(1,"prop_ofc_cd") != formObj.prop_ofc_cd.value){
                    var sheetObj = sheetObjects[0];                                                 
                    var cd = formObj.prop_ofc_cd.value;         
                    formObj.f_cmd.value = COMMAND22;
                    var sParam = FormQueryString(formObj)+"&cd="+cd;
                    var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                    var arrData = ComPriXml2Array(sXml, "cd|nm");

                    if (arrData != null && arrData.length > 0) {
                    	setRequestOfficeSaleRep();
                    }else{  
                    	formObj.prop_ofc_cd.value = "";
                        formObj.prop_srep_cd.RemoveAll();
                        formObj.prop_srep_nm.value = "";                        
                        formObj.prop_ofc_cd.focus();
                    }                           
                    com_change_sheet( sheetObj, "prop_ofc_cd" );                    
                }
                break;
            	
            default:
                ComChkObjValid(event.srcElement);       
        }
        
    }    
    /**
    * OnBeforeActivate   event를 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function obj_activate() {
        var formObj = document.form;
        var srcName = event.srcElement.getAttribute("name");
        ComClearSeparator (event.srcElement);
    }
    
    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */    
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        try{
            switch (sAction) {            
            case IBSEARCH: // 조회
            	ComOpenWait(true); //->waiting->start
            	clearAllTabPages();
            	sheetObj = sheetObjects[0];
            	
            	var params = "";
            	var arrXml = "";            	
            	var researchXml = "";//
            	
                if (validateForm(sheetObj,document.form,sAction)) {
                	formObj.f_cmd.value = SEARCH01;
                    if(formObj.sc_no.value!="")
                        formObj.prop_no.value = "";
                    params = FormQueryString(formObj);
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , params);
                    arrXml = sXml.split("|$$|");
                    if (arrXml.length > 0) {
                    	sheetObjects[0].LoadSearchXml(arrXml[0]);
                    	//빈값이라면 재조회
                    	researchXml = arrXml[0];                    	
                    	//조회될 당시의 Proposal No,Amend Seq. S/C no. Setting
                    	formObj.ori_prop_no.value = sheetObj.CellValue(1, "prop_no");
                    	formObj.amdt_seq.value = sheetObj.CellValue(1, "amdt_seq");
                    	formObj.ori_sc_no.value = sheetObj.CellValue(1, "sc_no");
                    	
                        if (arrXml.length > 2){
                        	ComPriXml2ComboItem(arrXml[2], formObj.prop_srep_cd, "cd", "cd|nm|etc2");      
                        }
                        if (arrXml.length > 3){
                        	ComPriXml2ComboItem(arrXml[3], formObj.ctrt_cust_srep_cd, "cd", "cd|nm|etc1");      
                        }
                        if (arrXml.length > 4){
                        	ComPriXml2ComboItem(arrXml[4], formObj.real_cust_srep_cd, "cd", "cd|nm|etc1");
                        }
                        if (arrXml.length > 1){
                        	sheetObjects[1].LoadSearchXml(arrXml[1]); 
                        	for (var i = 5;i < arrXml.length; i++){                		
                                var arrData = ComPriXml2ComboString(arrXml[i], "cd", "nm");
                                //콤보에 없는 sales rep코드를 입력하기 위해
                                var srepCd = sheetObjects[1].CellValue(i-4, "prop_scp_srep_cd");
                                //Row edit 상태 변경을 막기 위해 이전 Row Status를 가지고 있다.
                                var scpFlg = sheetObjects[1].RowStatus(i - 4);
                                if (arrData !=null && arrData.length > 0){
                                    var arrCode = arrData[0].split("|");
                                    var arrText = arrData[1].split("|");        
                                    var aText = "";
                                    if (arrCode != null && arrCode.length > 0){         
                                        for (var j = 0; j < arrCode.length; j++){
                                            aText += arrCode[j]+"\t"+arrText[j]+"|";
                                        }
                                    }
                                    sheetObjects[1].CellComboItem(i - 4, "prop_scp_srep_cd",aText,arrData[0],0);
                                }else{
                                	sheetObjects[1].CellComboItem(i - 4, "prop_scp_srep_cd", " ", " ");
                                }  
                                sheetObjects[1].CellValue(i - 4, "prop_scp_srep_cd") = srepCd;
                                sheetObjects[1].RowStatus(i - 4)= scpFlg;
                        	}
                        }    
                    	
                    }
                    
                    
                	formObj.f_cmd.value = SEARCH26;
                    params = FormQueryString(formObj);
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , params);
                     //File C/T가 가능 할때까지 남은 시간을 표시한다.
                     	//alert(arrXml[5]);
                    var arrData = ComPriXml2ComboString(sXml, "etc1", "etc2");
                    if( arrData[0] == "" || arrData[1] == ""){
                     	formObj.ct_available_time.value = "--H --M";
                    }else if( parseInt(arrData[0]) < 0 || parseInt(arrData[1]) < 0){
                     	formObj.ct_available_time.value = "00H 00M";
                    }else  {
                     	formObj.ct_available_time.value = arrData[0]+"H "+arrData[1]+"M";
                    }
                    
                    //backendjob
                    doActionIBSheet(sheetObjects[0], document.form, COMMAND10);
                }

                calcMVC();
                ComOpenWait(false); //->waiting->End
                
                // Search Xml이 빈값이 온다면 재조회한다.
                if (arrXml[0] != null && ComPriGetRowCountFromXML(arrXml[0]) == -1){                	
                	if (researchXml != ""){
                		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                	}else if (researchXml==""){
                		//backendJob과의 간섭때문에 조회결과가 빈값이 오는 경우가 있다.
                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                	}
                }
                buttonControl();
                formObj.prop_no.focus();
              //지정된 Scope만 IHC Tab을 활성화 한다.	 
//                tabObjects[0].TabEnable(8) = ihcTabSts; //IHC Tab
                break;
            case IBCREATE: // New
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
            	if (controlHidden) setControlHidden();

            	//신규입력시 Tab위치를 처음으로 
        		if (tabObjects[0].SelectedIndex == 0) {
        			tab1_OnChange(tabObjects[0], 0);
        		} else {
        			tabObjects[0].SelectedIndex = 0;
        		}            	
                clearAllForms();
                clearAllTabPages();
                clearButtonImages();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();                
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);                 
                sheetObjects[0].DataInsert();
                var sheetObj = sheetObjects[0];
                var formObj = document.form;
                sheetObj.CellValue2(1,"prop_sts_cd")= "I";
                sheetObj.CellValue2(1,"prc_prog_sts_cd")= "I";          
                sheetObj.CellValue2(1,"src_info_cd")= "NW";
                sheetObj.CellValue2(1,"rf_flg")= "N";
                sheetObj.CellValue2(1,"gamt_flg")= "N";
                sheetObj.CellValue2(1,"prc_ctrt_pty_tp_cd") = "C";
                sheetObj.CellValue2(1, "prc_prop_cre_tp_cd") = "G";
                sheetObj.CellValue2(1,"prop_ofc_cd")= formObj.in_usr_ofc_cd.value;
                sheetObj.CellValue2(1,"cntr_lod_ut_cd")= "F";
                sheet1_OnSearchEnd(sheetObj);
                setRequestOfficeSaleRep();
                sheetObj.CellValue2(1,"amdt_seq")= "0";
                formObj.amdt_seq.value = "0";
                document.form.cntr_lod_ut_cd.Text = "F";                
                formObj.prop_srep_cd.Code = formObj.in_usr_srep_cd.value;
                prop_srep_cd_OnBlur(comboObjects[0])
                ComOpenWait(false); //->waiting->End
                if (formObj.mst_prop_no.value != "") {  // S/C Master에서 넘어오는 경우 해당 Proposal No로 조회함.
                    formObj.prop_no.value = formObj.mst_prop_no.value;
                    sheetObj.CellValue2(1, "prop_no") = formObj.mst_prop_no.value;
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
                    formObj.mst_prop_no.value = "";
                }else{
                    formObj.ctrt_eff_dt.focus();
                    buttonControl();
                    setNewDataControl();
                }
                
                break;
        
            case IBSAVE: // Save
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                //저장 확인 메세지
                if (!ComPriConfirmSave()) {
                    return false;
                }
                //duration change 
                if (!saveChangeDuration("false")){
                    return false;
                }

                // proposal 여부를 포함하여 parameter 에 보내준다. main 관련 이외의 것들은 
                // proposal 이 아닌 경우는 건너뜀
                var mstAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
                formObj.f_cmd.value = MULTI01;
                var sParam = "";
                
                //서버로 넘길 값을 변수에 담는다(Html Objects), 
                var sParamSheet1 = sheetObjects[0].GetSaveString(true);

                if (sheetObjects[0].IsDataModified && sParamSheet1 == "") { 
                    return;
                }                
                if (sParamSheet1 != "") {         	
                	sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2 = sheetObjects[1].GetSaveString(true);
                
                if (sheetObjects[1].IsDataModified && sParamSheet2 == "") {
                    return;
                }                
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj)+"&mstAmdtSeq="+mstAmdtSeq;
                
                var sXml = sheetObjects[1].GetSaveXml("ESM_PRI_0003GS.do", sParam);                 
                sheetObjects[0].LoadSaveXml(sXml);  
                sXml = ComDeleteMsg(sXml);//저장완료 메세지 삭제 
                sheetObjects[1].LoadSaveXml(sXml);        
                var formObj = document.form;
                //신규 입력시 Proposal No. setting
                if(formObj.sc_no.value=="" && formObj.prop_no.value==""){           
                    formObj.prop_no.value = ComGetEtcData(sXml,"prop_no");          
                }
                //저장전위치로 하일라이트 이동을 위한 변수
                saveSvcScpCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "svc_scp_cd");
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                ComOpenWait(false); //->waiting->End
                break;

            case IBSEARCH_ASYNC01: // Approval Office Code, customer type 설정
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }            
    	        comboObjects[1].RemoveAll();
    	        comboObjects[2].RemoveAll();
    	        comboObjects[4].RemoveAll();
    	        comboObjects[6].RemoveAll();
    	        //apvl ofc
    	       
    	        sheetObjects[1].InitDataCombo(0,"prop_scp_apro_ofc_cd", appAllCdText, appAllCdValue,"","",0,"","",appCdText);  

    	        ComPriTextCode2ComboItem(appCdValue, appCdText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
    			//scope cd
    	        sheetObjects[1].InitDataCombo(0,"svc_scp_cd", scopeCdText, scopeCdValue);
    	        //cust type cd
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'prc_ctrt_cust_tp_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'real_cust_tp_cd') ,"|","\t" );    	        
    	        //lodUtCd
    	        ComPriTextCode2ComboItem(lodUtCdValue, lodUtCdText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    	        sheetObjects[1].InitDataCombo(0,"cntr_lod_ut_cd", lodUtCdText, lodUtCdValue);
    	        //scope status
    	        sheetObjects[1].InitDataCombo(0,"prop_scp_sts_cd", scpStsCdText, scpStsCdValue);
            	
                break;
            case COMMAND02:// REQUEST
            	ComOpenWait(true); //->waiting->start
    	        if (!validateForm(sheetObjects[0],document.form,sAction)) {
    	            return false;
    	        }     

    	        //이전에 Request 했는지 조회
    	        //이전에 Request를 했다면 GW main Popup을 호출하지 않는다.
	   	         formObj.f_cmd.value = SEARCH;
		         sPara = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
		         sPara += "&" + FormQueryString(formObj);
		         
		         cXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sPara);
		         var arrData = ComPriXml2Array(cXml, "etc1");   
		         var chkReq = "";
		         if (arrData !=null && arrData.length > 0){
		        	 if (arrData[0][0] == 0){
		        		 chkReq ="Y";
		             }
		         }
    	        

    	        formObj.f_cmd.value = MULTI02;
    	        sheetObjects[0].CellValue2(1,"prop_sts_cd") = "Q";
    	        
    	        var rDate = new Date();
    	        var yy = rDate.getFullYear();
    	        var mm = rDate.getMonth() + 1 +"";
    	        var dd = rDate.getDate() +"";
    	        if (mm.length == 1) mm = "0" + mm;
    	        if (dd.length == 1) dd = "0" + dd;              
    	        sheetObjects[0].CellValue2(1,"cre_dt") = yy+mm+dd;
    	        
    	        var sParam = "";   	
    	        var sParamSheet1 = sheetObjects[0].GetSaveString(true);
    	        if (sParamSheet1 != "") {
    	            sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
    	        }
    	        var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
    	        if (sParamSheet2 != "") {
    	            sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
    	        }else{
    	        	return;
    	        }
    	        sParam += "&" + FormQueryString(formObj); 
    	        
    	        var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);
    	        sheetObjects[0].LoadSaveXml(sXml);  
       
    	        doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    	        ComOpenWait(false); //->waiting->End
    	        // Groupware Mail//REQUEST CANCEL후 다시 REQUEST하면 실행안함

    	        if (chkReq == "Y"){
    	            //김경욱 대리님 요청 20170502 불필요해졌다고 함
    	        	//openGroupWareMailPopup(sheetObjects[0], formObj, sheetObjects[0].CellValue(1, "prop_sts_cd"));		
    	        }
    	                
            	break;
            case COMMAND03: // Counter Offer       
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }       
                formObj.f_cmd.value = MULTI02;                
                sheetObj.CellValue2(1,"prop_sts_cd") = "R";                

                var sParam = "";
                var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                if (sParamSheet1 != "") {
                    sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                }
                var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                if (sParamSheet2 != "") {
                    sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                }
                sParam += "&" + FormQueryString(formObj);

                var sXml = sheetObj.GetSaveXml("ESM_PRI_0003GS.do", sParam);               
                sheetObjects[0].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveXml(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;
                
            case COMMAND04: // Approve     
            	ComOpenWait(true); //->waiting->start
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                formObj.f_cmd.value = MULTI03;
                sheetObj.CellValue2(1,"prop_sts_cd") = "A";
                var sParam = sheetObjects[0].GetSaveString(true);
                sParam += "&" + FormQueryString(formObj);

                var sXml = sheetObj.GetSaveXml("ESM_PRI_0003GS.do", sParam); 
                
                sheetObjects[0].LoadSaveXml(sXml);
                sXml = ComDeleteMsg(sXml);
                sheetObjects[1].LoadSaveXml(sXml);
                
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                ComOpenWait(false); //->waiting->End
//                // Groupware Mail 20100507 USER 요청으로 제거함
//                if (formObj.amdt_seq.value != 0) {
//                    openGroupWareMailPopup(sheetObjects[0], formObj, sheetObjects[0].CellValue(1, "prop_sts_cd"));
//                }
                break;            
            case COMMAND05: // Cancel
            	ComOpenWait(true); //->waiting->start
	            if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
	                ComShowCodeMessage('PRI01057'); 
	                return false;
	            }         
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
            	
                var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            	var amdtSeq = formObj.amdt_seq.value;            	
            	if (amdtSeq =="0"){
        	        if (prop_sts_cd !="I" && !ComShowCodeConfirm("PRI01046")) {
        	            return false;
        	        }   
            	}else{
            		//Filed Cancel시 confirm message창 없앰
            		//Initial 단계에서 Cancel 시 에도 Previous Status 로 변경된다는 Message 창 없앰.
            		if ( prop_sts_cd != "F" &&  prop_sts_cd != "I" ){
	        	        if (!ComShowCodeConfirm("PRI01046")) {
	        	            return false;
	        	        }   
            		}
            	}
            	
                formObj.f_cmd.value = MULTI04;
            
                switch(prop_sts_cd){
                case 'I':
                case 'Q':
                case 'R':
                case 'A':
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);// scope의모든 데이터를 넘긴다.
                    if (sParamSheet2 == "") {
                    	return;
                    }
                	break;
                }

                switch(prop_sts_cd) {
                case 'I':   // Initial 모든 데이터 삭제 
                	if (amdtSeq == "0"){
                		var rValue = checkDemDetCancel(); //DEM/DET Exception이 남아 있으면 cancel 못함
                		if (rValue !="Y"){
                			ComShowCodeMessage("PRI01123");
                			return false;
                		} 
                		var rValue2 = checkChassisCancel(); // CHSS Exception이 남아 있으면 cancel 못함
                		if (rValue2 !="Y"){
                			ComShowCodeMessage("PRI01147");
                			return false;
                		}            		
                		if (!ComShowCodeConfirm("PRI01124")) {
                            return false;
                        }    
                	}else{
                		var rValue3 = checkEffDtChassisCancel(); // 이번 회차에 새로 생성된 CHSS Exception이 남아 있으면 cancel 못함
                		if (rValue3 !="Y"){
                			ComShowCodeMessage("PRI01147");
                			return false;
                		}
                		
                		
                        if (!ComShowCodeConfirm("PRI01050")) {
                            return false;
                        }    
                	}
                	
                	formObj.f_cmd.value = MULTI04;
                    sheetObj.CellValue2(1,"prop_sts_cd") = "D";     
                    
                    var sParam = "";           
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);//scope의 모든 데이터를 넘긴다.
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }          
                    sParam += "&" + FormQueryString(formObj);
                    
                    var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);                    
                    sheetObjects[0].LoadSaveXml(sXml);
                    var amdtSeq = formObj.amdt_seq.value;
                    if (amdtSeq != "0"){
                    	formObj.amdt_seq.value = ComParseInt(amdtSeq) - 1;
                    }else{
                    	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                    }
                    
                    break;
                case 'Q':   // Requested  
	            	var reqUsrFlg  = sheetObjects[0].CellValue(1, "req_usr_flg");
                	var aproUsrFlg = sheetObjects[0].CellValue(1, "apro_usr_flg");

	            	if (reqUsrFlg == "Y" && aproUsrFlg !="Y"){
	            		if (checkRequestCancel() == "N"){	            			
	            			return false;
	            		}
	            	}
                	                
                	formObj.f_cmd.value = MULTI04;
                    sheetObj.CellValue2(1,"prop_sts_cd") = "I";             
                    var sParam = "";           
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);             
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }               
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }            
                    sParam += "&" + FormQueryString(formObj);
                    var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);                    
                    sheetObjects[0].LoadSaveXml(sXml);
                    break;
                case 'R':   // Returned
                    sheetObj.CellValue2(1,"prop_sts_cd") = "Q";
	                var sParam = "";              
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }        
                    sParam += "&" + FormQueryString(formObj);
                    var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);                    
                    sheetObjects[0].LoadSaveXml(sXml);
                    break;
                case 'A':   // Approved
                    sheetObj.CellValue2(1,"prop_sts_cd") = "Q";
	                var sParam = "";
	            	//              var sParam = FormQueryString(formObj);            
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }       
                    sParam += "&" + FormQueryString(formObj);
                    var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);                    
                    sheetObjects[0].LoadSaveXml(sXml);
                   
                    if (formObj.amdt_seq.value=="0"){
                    	formObj.sc_no.value = "";
                    }
                    break; 
                case 'F': //Filed
                	//0122 UI를 호출한다.
                    var sPropNo         = sheetObj.CellValue(1, "prop_no");
                    var sAmdtSeq        = sheetObj.CellValue(1, "amdt_seq");
                    var sScNo           = sheetObj.CellValue(1, "sc_no");
                    var sUpdDt           = sheetObj.CellValue(1, "upd_dt");
                    var lstProgAproOfcCd    = sheetObj.CellValue(1, "lst_prog_apro_ofc_cd");
                    var propAproStaffId  = sheetObj.CellValue(1, "prop_apro_staff_id");
                   
                    var sParam = "frm_prop_no="+sPropNo
                	            +"&frm_amdt_seq="+sAmdtSeq
                	            +"&frm_sc_no="+sScNo
                	            +"&upd_dt="+sUpdDt
                	            +"&prop_apro_ofc_cd="+lstProgAproOfcCd
                	            +"&prop_apro_staff_id="+propAproStaffId;

                	var rtnVal = ComOpenWindowCenter("/hanjin/ESM_PRI_0122.do?"+sParam, "ESM_PRI_0122", 1100, 500, true);
                	if (rtnVal !="SUCCESS") {
                		ComOpenWait(false);
                		return false;
                	}
                	break;
                }   

                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;      
            
            case IBINSERT: // Row Add

            	if (formObj.amdt_seq.value == "0"){
                    sheetObj.InitDataProperty(0, 12, dtData, 70, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, true, true);
                    sheetObj.InitDataProperty(0, 13, dtData, 70, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, true, true);   
                }else{
                    sheetObj.InitDataProperty(0, 12, dtData, 70, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
                    sheetObj.InitDataProperty(0, 13, dtData, 70, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, true); 
                }

            	sheetObj.Redraw = false;
                var idx = sheetObj.DataInsert();

                sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
                sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;                
                sheetObj.CellValue2(idx, "prop_scp_ofc_cd") = formObj.prop_ofc_cd.value;                
                setSheetRequestOfficeSaleRep(sheetObj, idx, sheetObj.CellValue(idx, "prop_scp_ofc_cd"));          
                sheetObj.CellValue2(idx, "prop_scp_apro_ofc_cd") ="";
                sheetObj.CellValue2(idx, "prop_scp_apro_ofc_cd") = comboObjects[1].Code;                            
                sheetObj.CellValue2(idx, "prop_scp_apro_ofc_cd") = "";
                sheetObj.CellValue2(idx, "prop_scp_apro_ofc_cd") = comboObjects[1].Code;
                
                sheetObj.CellValue2(idx, "cntr_lod_ut_cd") = formObj.cntr_lod_ut_cd.Code;                
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.CellValue2(idx, "ctrt_eff_dt") = formObj.ctrt_eff_dt.value;
                }else{
                    sheetObj.CellValue2(idx, "ctrt_eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
                }
                sheetObj.CellValue2(idx, "ctrt_exp_dt") = formObj.ctrt_exp_dt.value;
                if (formObj.amdt_seq.value == "0"){
                    sheetObj.CellValue2(idx, "eff_dt") = formObj.ctrt_eff_dt.value;
                }else{
                    sheetObj.CellValue2(idx, "eff_dt") = sheetObjects[0].CellValue(1,"eff_dt");
                }
                sheetObj.CellValue2(idx, "exp_dt") = formObj.ctrt_exp_dt.value;                
                sheetObj.CellValue2(idx, "pre_exp_dt") = sheetObjects[0].CellValue(1, "pre_exp_dt");
                sheetObj.CellValue2(idx, "prop_scp_sts_cd") = "I";
                sheetObj.CellValue2(idx, "prc_prog_sts_cd") = "I";
                sheetObj.CellValue2(idx, "src_info_cd") = "NW";
                sheetObj.CellValue2(idx, "n1st_cmnc_dt") = sheetObjects[0].CellValue(1,"eff_dt");                
                //MAIN의 SALE REP와 동일한 SALE REP으로 DUFAULT            
                sheetObj.CellValue2(idx, "prop_scp_srep_cd") = formObj.prop_srep_cd.Text;
                sheetObj.CellValue2(idx, "new_ins_flg") = "0";
                svcScpDeleteEnable();
                sheetButtonImageChange(sheetObj,idx, 0);//비활성
                sheetObj.PopupButtonImage(idx, "gline_cp_flg_lnk") = 0;
                quickAcceptAllControl("0", false);

                //첫번째Row는 Main Mqc의 값을 가져온다.
                if ( getAmendValidRowCount(sheetObj, formObj.amdt_seq.value) == 1){                	             	
                	sheetObj.CellValue2(idx, "prop_scp_mqc_qty") = formObj.prop_mqc_qty.value;                		
                }
                                
                if(formObj.amdt_seq.value!=0){
                    sheetObj.CellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd")= sheetObj.RgbColor(255,0,0);
                }                 
                var preIbflag = sheetObjects[0].RowStatus(1);
                if (preIbflag == "R"){
                	sheetObjects[0].RowStatus(1) = "U";
                }
                sheetObj.SelectCell(idx, "svc_scp_cd");                
            	sheetObj.Redraw = true;
            	
                break;
            
            case IBDELETE: // Delete
                if (validateForm(sheetObj,document.form,sAction)) {         
                    deleteRowCheck(sheetObj, "chk" ,true);  
                }       
                break;      
            case COMMAND10: //backendjob 조회
    	        formObj.prop_pfmc.value="";
    	        formObj.prop_atmt.value="";
    	        backEndJobCnt = 0;
    	        if (validateForm(sheetObj,document.form,sAction)) {
    	        	formObj.f_cmd.value = SEARCH14;	
    	        	var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no") +"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");
    	        	sParam += "&"+ FormQueryString(formObj);
    				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", sParam);
    				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    				
    				if (backendJobKey != null && backendJobKey.length > 0 ) {
    					formObj.backendjob_key.value = backendJobKey;    					
    					window.setTimeout(getBackEndJobStatus, 5000);
    				}
    	        }

    			break; 
    			
            case COMMAND06: // btn_cancel_file
		        if (!ComShowCodeConfirm("PRI01046")) {
		            return false;
		        }   
	        	ComOpenWait(true); //->waiting->start
	        	
	            var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
	        	var amdtSeq = formObj.amdt_seq.value;            	
	        	
	            formObj.f_cmd.value = MULTI08;
	 
	            sheetObj.CellValue2(1,"prop_sts_cd") = "A";             
	            var sParam = ""; 
	            var sParamSheet1 = sheetObjects[0].GetSaveString(true);             
	            if (sParamSheet1 != "") {
	                sParam +=  ComPriSetPrifix(sParamSheet1, "sheet1_");
	            }                        
	            sParam += "&" + FormQueryString(formObj);
	            var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);                    
	            sheetObjects[0].LoadSaveXml(sXml);
	            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	            ComOpenWait(false); //->waiting->End
	            break;      
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == COMMAND10 || sAction == IBDELETE || sAction == IBINSERT
        			|| sAction == IBSEARCH_ASYNC01) {
        		return;
        	}
        	ComOpenWait(false); //->waiting->End
        }
    }    
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function initSheet(sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {
        
        case "sheet1":
            with (sheetObj) {
            	/*
                // 높이 설정
                style.height = 120;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;                
				*/
        
                

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
                
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                
                var HeadTitle  = "|sc_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_dt|prc_prog_sts_cd|src_info_cd|pre_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt";
                HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
                HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm_cd|real_cust_val_sgm";
                HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|sls_ld_no|blpl_hdr_seq";
                HeadTitle += "|request user flag|approval user flag|all usr flag|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|ctrt_eff_dt_ori|ctrt_exp_dt_ori|oti_no";
                HeadTitle += "|oti_eff_dt|oti_exp_dt|oti_amt|prop_prpr_flg|cretype|dur_dup_flg|cust_tp_ori"
                HeadTitle += "|prop_apro_staff|prop_apro_staff_id|lst_prog_apro_ofc_cd|act_cm|est_cm|ori_real_cust_cd|ori_real_cust_seq|conv_cfm_flg|n_conv_cfm_flg|lgcy_if_flg|oti_lic_no|oti_map|n1st_if_flg|upd_dt|pty_prog_sts_cd|fmc_cfm_flg"
                var headCount = ComCountHeadTitle(HeadTitle);               
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)
    
   
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                
                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sc_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_amdt_seq", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);                             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "n1st_cmnc_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);                               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false); //eff_dt - 1            
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_flg", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "gamt_flg", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "file_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cust_cnt_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cust_seq", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_pty_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_sls_ofc_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_cd", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_nm", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_cnt_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_nm", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_tp_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_val_sgm", false, "", dfNone, 0, false, false);                             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_sls_ofc_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_srep_cd", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "real_cust_srep_nm", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_mqc_qty", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false);                                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "unit", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sls_ld_no", false, "", dfNone, 0, false, false);                             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "blpl_hdr_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "apro_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "all_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_addr", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_tit_nm", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_amt", false, "", dfNullFloat, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dur_dup_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cust_tp_ori", false, "", dfNone, 0, false, false);//저장시 cust type cd가 변경되었는지 비교하기 위하여 원본을 가지고 있는다.
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff_id", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "lst_prog_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);    
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ori_real_cust_cd", false, "", dfNone, 0, false, false);//0017에서 Real Customer check
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ori_real_cust_seq", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "conv_cfm_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "n_conv_cfm_flg", false, "", dfNone, 0, false, false);//이전 CONV_CFM_FLG가 체크되어 있어야 현재 AMEND SEQ에서 CONV_CFM_FLG를 체크할 수 있다.
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "lgcy_if_flg", false, "", dfNone, 0, false, false);    
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_lic_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_map", false, "", dfNone, 0, false, false);//OTI 정보확인 -  REQUEST 시 체크
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "n1st_if_flg", false, "", dfNone, 0, false, false); //PRINT시 사용
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "upd_dt", false, "", dfNone, 0, false, false); //Update date로 amend,request,file,cancel과 같이 상태를 바꾸는 이벤트시 
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pty_prog_sts_cd", false, "", dfNone, 0, false, false); //PRC_PROG_STS_CD 확인용
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "fmc_cfm_flg", false, "", dfNone, 0, false, false); //FMC_CFM_FLG 확인용 [CHM-201538667] ALPS S/C Autofiling 관련 보완 요청
                WaitImageVisible = false;
            }
            break;
            
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 120;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
    
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = true;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
        
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false, false)
    
                var HeadTitle =  "|Sel.|Seq.|Prop No.|Amendment Seq|SVC Scope|APVL OFC|Req. OFC|MQC|MQC|MQC|S.Rep|Duration|Duration|Duration|eff_dt"; //14
                    HeadTitle += "|exp_dt|n1st_cmnc_dt|pre_exp_dt|G/L Copy|Quick Accept|CHSS|NO GRI|No New SCHG|Status|Note Header Seq|Status";
                    HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|dur_dup_flg|scpnm|PRE_EXT_SCP|new_ins_flg|amdt_cnt|acpt_cnt";                 
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus,  30,  daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck,    40,  daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 	    30,  daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no", 				true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 				true, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtComboEdit, 	80,  daCenter, false, "svc_scp_cd", 			true, "", dfNone, 0, false, true, 3);
                InitDataProperty(0, cnt++, dtComboEdit, 	70 , daCenter, false, "prop_scp_apro_ofc_cd", 	true, "", dfNone, 0, true, true, 6);
                InitDataProperty(0, cnt++, dtData, 			70,  daCenter, false, "prop_scp_ofc_cd", 		true, "", dfNone, 0, true, true);               
                InitDataProperty(0, cnt++, dtData, 			50,  daRight,  false, "prop_scp_mqc_qty", 		true, "", dfNullInteger, 0, false, true);
                InitDataProperty(0, cnt++, dtPopup, 		20,  daCenter, false, "prop_scp_mqc_pop", 		false, "", dfNone, 0, true, false);             
                InitDataProperty(0, cnt++, dtCombo, 		30,  daCenter, false, "cntr_lod_ut_cd", 		true, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtComboEdit, 	60, daCenter, false, "prop_scp_srep_cd", 		true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtData, 			70,  daCenter, false, "ctrt_eff_dt", 			true, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 			70,  daCenter, false, "ctrt_exp_dt", 			true, "", dfDateYmd, 0, false, true);               
                InitDataProperty(0, cnt++, dtPopupEdit, 	20,  daCenter, false, "scp_dur_pop", 			false, "", dfNone, 0, true, false);                
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "eff_dt", 				true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "exp_dt", 				true, "", dfNone, 0, true, true);                
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "n1st_cmnc_dt", 			false, "", dfNone, 0, true, true);                
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "pre_exp_dt", 			true, "", dfDateYmd, 0, true, true);
                InitDataProperty(0, cnt++, dtPopup, 		60,  daCenter, false, "gline_cp_flg_lnk", 		false, "", dfNone, 0, true, false, 4, true);                           
                InitDataProperty(0, cnt++, dtPopup, 		85,  daCenter, false, "quick_accept", 			false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		35,  daCenter, false, "chss_expt_flg", 			false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCheckBox, 		50,  daCenter, false, "gri_appl_flg", 			false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCheckBox, 		80,  daCenter, false, "new_scg_flg", 			false, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtCombo, 		60,  daCenter, false, "prop_scp_sts_cd", 		false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtHidden, 		200, daCenter, false, "note_hdr_seq", 			true, "", dfNone, 0, true, true, 100);               
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prop_scp_sts", 			true, "", dfNone, 0, true, true, 100);                      
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "req_usr_flg", 			true, "", dfNone, 0, true, true, 100);                
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "apro_usr_flg", 			true, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prc_prog_sts_cd", 		true, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "src_info_cd", 			true, "", dfNone, 0, true, true, 100);                
                InitDataProperty(0, cnt++, dtHidden,		100, daCenter, false, "prop_scp_mqc_qty_ori", 	false, "", dfInteger, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,		90,  daLeft,   false, "dur_dup_flg", 			false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "scp_nm", 				true, "", dfNone, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "pre_ext_scp", 			true, "", dfNone, 0, true, true);          
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "new_ins_flg", 			true, "", dfNone, 0, true, true);          
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "amdt_cnt", 				false, "", dfNone, 0, true, true);          
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "acpt_cnt", 				false, "", dfNone, 0, true, true);
                
                InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
                InitDataValid(0, "prop_scp_apro_ofc_cd", vtEngUpOnly);
                InitDataValid(0, "prop_scp_ofc_cd", vtEngUpOnly);
                InitDataValid(0, "prop_scp_srep_cd", vtEngUpOnly);
                WaitImageVisible = false;
                ShowButtonImage = 2;
                ImageList(0) = "img/btns_search_off.gif";
                ImageList(1) = "img/btns_search.gif";
//                InitComboNoMatchText(true);
            }
            break;      
        }
    }
    

     /**
      * Tab 기본 설정 탭의 항목을 설정한다.  <br>
      * Tab이 다수일 경우 Tab 수만큼 case를 추가하여 Tab의 초기화모듈을 구성한다 <br>
      * <br><b>Example :</b>
      * <pre>
      *     initTab(tabObj,1);
      * </pre>
      * @param {tabObj} tabObj 필수 IBTab Object
      * @param {int} tabNo 필수 IBTab Object 태그의 아이디에 붙인 일련번호
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     
    function initTab(tabObj, tabNo) {
        switch (tabNo) {
        case 1:
            with (tabObj) {
    
                var cnt = 0;
                InsertTab(cnt++, "Ori/Dest", 0);                
                InsertTab(cnt++, "LOC Group ", 1);
                InsertTab(cnt++, "CMDT Group ", 2);
                InsertTab(cnt++, "Arbitrary", 3);
                InsertTab(cnt++, "Rate", 4);
                InsertTab(cnt++, "Standard Note", 5);
                InsertTab(cnt++, "Special Note", 6);
                InsertTab(cnt++, "L/Agent", 7);
                InsertTab(cnt++, "IHC", 8);
                InsertTab(cnt++, "GOH", 9);
                
                ShowIcon = true;
                UseLargeIcon = false;
                
                ImageUrl(0) = ICON_URL_NOT_EXIST;
                ImageUrl(1) = ICON_URL_NOT_EXIST;
                ImageUrl(2) = ICON_URL_NOT_EXIST;
                ImageUrl(3) = ICON_URL_NOT_EXIST;
                ImageUrl(4) = ICON_URL_NOT_EXIST;
                ImageUrl(5) = ICON_URL_NOT_EXIST;
                ImageUrl(6) = ICON_URL_NOT_EXIST;
                ImageUrl(7) = ICON_URL_NOT_EXIST;
                ImageUrl(8) = ICON_URL_NOT_EXIST;
                ImageUrl(9) = ICON_URL_NOT_EXIST;
    
            }
            break;
    
        }
    }
    
    /**
     * Combo 기본 설정, Combo의 항목을 설정한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */        
    function initCombo(comboObj, comboNo) {

    	switch(comboObj.id) {
            case "prop_srep_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
                    SetColWidth("50|150|0");
                }
                break;

            case "prc_ctrt_cust_tp_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    SetColWidth("20|170");
                }
                break;     
                //real_cust_tp_cd
            case "real_cust_tp_cd":
                var i=0;
                with(comboObj) {
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                }
                break;                     
            case "prop_apro_ofc_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                    MaxLength = 6;
                }
                break;
            case "ctrt_cust_srep_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
                }
                break;
            case "real_cust_srep_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 1);
                    MaxLength = 5;
                }
                break;       
            case "cntr_lod_ut_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                }
                break;   
            case "sls_ld_no":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                }
                break;                  
        }
    }


    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 공백진
     * @version 2009.04.17
     */
    function validateForm(sheetObj, formObj, sAction) {
        var sc_no = formObj.sc_no.value;
        var prop_no = formObj.prop_no.value;
        var amdt_seq = formObj.amdt_seq.value;

        switch (sAction) {
        case IBSEARCH: // 조회
//            if (sc_no == "" && prop_no == "") {
//            	return false;
//            }
            break;
            
        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified){
                return ComPriClearChange;
            }
            break;
        case COMMAND02: // Request
        	if (formObj.prop_no.value ==""){
	            ComShowCodeMessage('PRI01021');                    
	            return false;
	        }               
	        var rValue = "";
	        if (formObj.sc_no.value == "" && formObj.prop_no.value == "") {                	
	        	return false;
	        }               
	        if (sheetObjects[1].RowCount == 0){                	
	        	return false;
	        }               
	        
            if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }
            
          //[CHM-201535632] Affiliate 내 Type 코드 혼재 불가 로직
	        //Affiliate 내 Type 코드 혼재시 메세지로만 경고 처리만함
            /*
            S/C Type	Master Type	Alert
            I -> BCO	≠ BCO	Attention :  Affiliate type not match to S/C type!!
            A -> Association	혼재 시	Attention :  Mixed type of Affiliate!!!
            N -> NVO	≠ NVO	Attention :  Affiliate type not match to S/C type!!
            O-> Others	혼재 시	Attention :  Mixed type of Affiliate!!!
            */
            var checkValue = checkAffilTypeDup();
        	if ( checkValue =="I" || checkValue =="N" ) {
	        	//단일 type 이지만 main cust type 가 다를 경우
	        	ComShowCodeMessage('PRI01162');
	        } else if ( checkValue =="A" || checkValue =="O" ) {
	        	//혼재 시 = MIXED
	        	ComShowCodeMessage('PRI01161');
	        } 
	        
			
           //미주 지역 4개 ECC 폐쇄 관련 S/C 해당 운임 Block (TPE Scope만 해당)           
            var formObj = document.form; 
	        formObj.f_cmd.value = SEARCH24;
	        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", FormQueryString(formObj));
	        sheetObjects[0].GetSearchXml(sXml);	        
	        var arrData = ComPriXml2Array(sXml, "etc1");
	        
	         if (arrData != null && arrData.length > 0) {	        	       	 
	        	 ComShowCodeMessage('PRI01153', arrData );
	        	 return false;
	        }
	        
	        if (!ComShowCodeConfirm("PRI01032","Request")){                	
	        	return false;
	        }
	        
	        //Main,Scope Duration Eff_dt,Exp_dt 일치 체크
	        var mainCtrtEffDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
	        var mainCtrtExpDt = ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd");
	        var scpCtrtEffDt = "";
	        var scpCtrtExpDt = "";
	        var ctrtDateMatch = false;  
	
	        for (var i = 1; i <= getValidRowCount(sheetObjects[1]); i++){
	        	scpCtrtEffDt = sheetObjects[1].CellValue(i, "ctrt_eff_dt");
	        	scpCtrtExpDt = sheetObjects[1].CellValue(i, "ctrt_exp_dt");
	        	if (mainCtrtEffDt == scpCtrtEffDt && mainCtrtExpDt == scpCtrtExpDt ){
	        		ctrtDateMatch = true;
	        		continue;
	        	}
	        }
	        //duration이 메인과 일치하는 Scope 이 없을 경우 message를 보여준다.
	        if (!ctrtDateMatch){
	        	 ComShowCodeMessage("PRI01096");
	        }

	        if (comboObjects[2].Code == "N" 
	        	&& formObj.oti_no.value == ""
	        	&& formObj.oti_lic_no.value == ""
	        	&& formObj.amdt_seq.value == "0"
	        	&& sheetObjects[0].CellValue(1, "oti_map") =="Y"){
	        	ComShowCodeMessage('PRI01076');
	        	return false;
	        }
	        	
	        rValue = checkRequest();
	        if (rValue !="Y"){                	
	        	return false;
	        }        
	        
            /////////////////////////////////////////////////////////////////////
            // update date 검사
            var checkSheetObj = sheetObjects[0];
            var checkTpCd = "CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
        
        	break;
        case COMMAND03: // Counter Offer

            var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            var req_usr_flg = sheetObjects[0].CellValue(1, "req_usr_flg");
            var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
            //승인권한
            if (apro_usr_flg!="Y"){
                ComShowCodeMessage('PRI01033','C/Offer');
                return false;
            }
            
            // 모든 terms가 accept or return 인지 확인         
            var initCheck = checkCountOffer();
            if (initCheck !="Y"){
                ComShowCodeMessage('PRI01039');
                return false;
            }           
            
            
            if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }            
            
    	      //status Request 일 경우에만 Counter Offer 가능
	        if (prop_sts_cd !="Q" ){
	            ComShowCodeMessage('PRI01034');
	            return false;
	        }             
            
            if (!ComShowCodeConfirm("PRI01032","C/Offer")){
                return false;
            }
            /////////////////////////////////////////////////////////////////////
            // update date 검사
            var checkSheetObj = sheetObjects[0];
            var checkTpCd = "CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
  	      
            break;        
        case COMMAND04: // Approve
        
            var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            var req_usr_flg = sheetObjects[0].CellValue(1, "req_usr_flg");
            var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");

            //승인권한
            if (apro_usr_flg=="N"){
                ComShowCodeMessage('PRI01033','Approve');
                return false;
            }           
            
            if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }            
            
           //[CHM-201535632] Affiliate 내 Type 코드 혼재 불가 로직
	        //Affiliate 내 Type 코드 혼재시 메세지로만 경고 처리만함
            /*
            S/C Type	Master Type	Alert
            I -> BCO	≠ BCO	Attention :  Affiliate type not match to S/C type!!
            A -> Association	혼재 시	Attention :  Mixed type of Affiliate!!!
            N -> NVO	≠ NVO	Attention :  Affiliate type not match to S/C type!!
            O-> Others	혼재 시	Attention :  Mixed type of Affiliate!!!
            */
            var checkValue = checkAffilTypeDup();
        	if ( checkValue =="I" || checkValue =="N" ) {
	        	//단일 type 이지만 main cust type 가 다를 경우
	        	ComShowCodeMessage('PRI01162');
	        } else if ( checkValue =="A" || checkValue =="O" ) {
	        	//혼재 시 = MIXED
	        	ComShowCodeMessage('PRI01161');
	        } 
			
            //status Request 일 경우에만 Approve 가능
            if (prop_sts_cd !="Q"){
                ComShowCodeMessage('PRI01034');
                return false;
            }    
            
            if (!ComShowCodeConfirm("PRI01032","Approve")){
                return false;
            }
            
            //DEM/DET CHECK
	        if ( checkDmdtData() !="Y"){
	        	return false;
	        }	
	        
	       //CHSS CHECK
	        if ( checkChassisData() !="Y"){
	        	return false;
	        }	//Approve 시 check 하는 로직도 일단 막아둠

            var rValue = checkAccept();            
            //all accept일 경우 approve 활성화 C/offer  비활성화
            if (rValue != "Y"){
                ComShowCodeMessage('PRI01031');
                return false;
            } 
            /////////////////////////////////////////////////////////////////////
            // update date 검사
            var checkSheetObj = sheetObjects[0];
            var checkTpCd = "CHECK1";
            if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
            	return false;
            }
            /////////////////////////////////////////////////////////////////////
            break;        
        case COMMAND05: // Cancel
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            break;
        case IBSAVE: // Save
            var formObj = document.form;        
        	//Html 필수입력 체크
            if(!ComChkRequired(document.form)){
                return false;
            }
            //콤보 필수입력 체크
            if (comboObjects[0].Code == "") {
                ComShowCodeMessage('PRI00316','Sale Rep.'); 
                comboObjects[0].focus();
                return false;
            }

            if (comboObjects[1].Code == "") {
                ComShowCodeMessage('PRI00316','Approval Office');   
                comboObjects[1].focus();
                return false;
            }
            if (comboObjects[2].Code == "") {
                ComShowCodeMessage('PRI00316','Customer Type'); 
                comboObjects[2].focus();
                return false;
            }
            if (comboObjects[3].Code == "" || formObj.ctrt_cust_srep_nm.value == "" || comboObjects[3].Code == " " ) { //[CHM-201323648] 빈 칸을 선택해도 validation 처리 되도록 함
                ComShowCodeMessage('PRI00316','Customer S.Rep.');   
                comboObjects[3].focus();
                return false;
            }           
            
            if (comboObjects[5].Code == "" && formObj.real_cust_srep_nm.value != "") {
                ComShowCodeMessage('PRI00316','Real Customer S.Rep.');   
                comboObjects[5].focus();
                return false;
            }

            if (comboObjects[6].Code == "") {
                ComShowCodeMessage('PRI00316','UNIT'); 
                comboObjects[6].focus();
                return false;
            }
            
            //duration check
            var rowCnt = getValidRowCount(sheetObjects[1]); //삭제된 Row를 제외한 Row수를 구하는 PRI 공통함수         
            var ctrtEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");//Main Duration
            var ctrtExpDt = sheetObjects[0].CellValue(1, "ctrt_exp_dt");

            var sheet2 = sheetObjects[1];
            for (var i = 1; i <= rowCnt; i++){
            	var effDt = ComGetUnMaskedValue(sheet2.CellValue(i, "ctrt_eff_dt"),"ymd");//Scope Duration
            	var expDt = ComGetUnMaskedValue(sheet2.CellValue(i, "ctrt_exp_dt"),"ymd");
            	if (effDt != "" && expDt != ""){
                	if (effDt < ctrtEffDt){
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"S/C");
                		sheet2.SelectCell(i, "ctrt_eff_dt");
                		return false;
                	}
                	if (expDt > ctrtExpDt){            		
                		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"S/C");
                		sheet2.SelectCell(i, "ctrt_exp_dt");
                		return false;
                	}
            	}
            }
            
            //Scope이 입력 안됨
            if (rowCnt <= 0){
                ComShowCodeMessage('PRI01029'); 
                return false;
            }
            //수정된자료가 없다.
            if(!sheetObjects[0].IsDataModified &&!sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }
            // dup check
             var rowM = sheetObjects[1].ColValueDup("svc_scp_cd", false);
             if (rowM >= 0) {
                 ComShowCodeMessage("PRI00303", "Sheet", rowM);
                 return false;
            }
             
            //MQC chk : scope Mqc <= Main Mqc
            var mainMqc = document.form.prop_mqc_qty.value;
            var subMqc = 0;//scope
            var sheetObj = sheetObjects[1];//scope
            for (var i = 1; i <= sheetObj.RowCount; i++){
                subMqc += ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty_ori"));//변경전 Scope Mqc를 합산한다.
                //scope Mqc가 변경되었다면 변경된 값을 subMqc에 더하거나 뺀다.
                if (sheetObj.CellValue(i,"prop_scp_mqc_qty") != sheetObj.CellValue(i,"prop_scp_mqc_qty_ori")){
                    subMqc += ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty")) - ComParseInt(sheetObj.CellValue(i, "prop_scp_mqc_qty_ori"));
                }
            }
            if ((subMqc - mainMqc) > 0){
                 ComShowCodeMessage("PRI01008");                 
                 return false;
            }
            
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
            
            break;
    
        case IBSEARCH_ASYNC01: 
            return true;
            if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
                return false;
            }

            break;           
        
        case IBDELETE: // Delete
            var sCheckedRows = sheetObj.FindCheckedRow("chk");
            var arrCheckedRows = new Array();
            if (sCheckedRows == "") {
                arrCheckedRows.push(sheetObj.SelectRow);
            } else { 
                arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
            }       

            var effDt = sheetObjects[0].CellValue(1,"eff_dt");
            var amdtSeq = sheetObjects[0].CellValue(1,"amdt_seq");
            
            //현재 amdt_seq에서 추가한 scope만 삭제할 수 있다.
            if (amdtSeq != "0"){        
                for (var i = 0; i < arrCheckedRows.length; i++){                    
                    if (effDt != sheetObj.CellValue(arrCheckedRows[i], "eff_dt")){
                        ComShowCodeMessage('PRI01036');
                        sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");//PRI01036
                        return false;
                    }                    
                }
            }
            
            var rValue = "";
            for (var i = 0; i< arrCheckedRows.length; i++){
                rValue = checkScopeDelete(arrCheckedRows[i]);
                //Scope의 하부데이터가 없어야 삭제 할 수 있다.
                if (rValue != "Y"){
                    ComShowCodeMessage('PRI01051');
                    sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");
                    return false;
                }
            }

            break;
            
        case IBCOPYROW: // Copy
            if (comboObjects[0].Code == "" || comboObjects[1].Code == "") {
                return false;
            }
//            if (formObj.cfm_flg.value != "No") {
//                return false;
//            }

            break;
        case COMMAND10: // backendjob        
	        if (sc_no =="" || prop_no == "") {
	        	return false;
	        }
	        break;            
            
        }
		return true;
    }           
    

     /**
      * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     tab1_OnChange(tabObj, tabIndex)
      * </pre>
      * @param {tabObj} tabObj 필수 IBTab Object
      * @param {int} tabIndex 필수 프로세스 플래그 상수
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */     


    function tab1_OnChange(tabObj, tabIndex) {
    	  if (!ihcTabSts && tabIndex ==8){//IHC tab 비활성화 일경우 return
    		  if (beforetab !=tabIndex){
    			  tabObj.SelectedIndex = beforetab;  
    		  }    		  
    		  return;
    	  }
    	  var sNoteIdx = 6;//Standard Note(Dem/Det가 저장이 안되었다면 Tab 이동 금지)
          if (beforetab == sNoteIdx ){        	  
    		  if (tabIndex !=sNoteIdx){
    			  returnValue = document.getElementById("t7frame").contentWindow.getDemDetSaveCheck();
    			  if (returnValue == "N"){
    				  tabObj.SelectedIndex = sNoteIdx;
            		  beforetab = sNoteIdx;
            		  return;
    			  }
    		  }        	 
          }    	  

    	  if (beforetab != tabIndex) {	  
    		  var objs = document.all.item("tabLayer");
    		  objs[tabIndex].style.display = "inline";
    		  objs[beforetab].style.display = "none";
        }
        
        beforetab = tabIndex;
        loadTabPage(tabIndex);
        
//        tabObjects[0].TabEnable(8) = ihcTabSts;//IHC Tab
    }
      
     
      /**
       * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
       * <br><b>Example :</b>
       * <pre>
       *     tab1_OnClick(tabObj, tabIndex)
       * </pre>
       * @param {tabObj} tabObj 필수 IBTab Object
       * @param {int} tabIndex 필수 프로세스 플래그 상수
       * @return 없음
       * @author 공백진
       * @version 2009.04.17
       */           
      function tab1_OnClick(tabObj,  tabIndex) {
     	  if (!ihcTabSts && tabIndex ==8){//IHC tab 비활성화 일경우 return
     		  tabObj.SelectedIndex = beforetab;
     		  return;
    	  }    	
    	   //Standard Note(Dem/Det가 저장이 안되었다면 Tab 이동 금지)
    	  if (beforetab == 6 && returnValue =="N"){
    		  tabObj.SelectedIndex = 6;    		  
    	  }
      }
      
     /**
     * Tab변경시 화면을 Frame에 로드한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadTabPage(tabIndex)
     * </pre>
     * @param {tabIndex} tabIndex 필수 tab의 일련번호
     * @param {selRow} 선택된  Row
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */          
    function loadTabPage(tabIndex, selRow) {
        if (tabIndex == null || tabIndex == "") {
            tabIndex = tabObjects[0].SelectedIndex;
        }
        
        var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;        
        if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
            var sUrl = "";
            switch (tabIndex) {
            case 0:
                sUrl = "ESM_PRI_0003_01.do"; 
                break;
            case 1:
                sUrl = "ESM_PRI_0003_02.do"; 
                break;
            case 2:
                sUrl = "ESM_PRI_0003_03.do"; 
                break;
            case 3:
                sUrl = "ESM_PRI_0003_04.do"; 
                break;
            case 4:
                sUrl = "ESM_PRI_0003_08.do"; 
                break;
            case 5:
                sUrl = "ESM_PRI_0003_09.do"; 
                break;
            case 6:
                sUrl = "ESM_PRI_0003_10.do"; 
                break;
            case 7:
                sUrl = "ESM_PRI_0003_07.do"; 
                break;
            case 8:
                sUrl = "ESM_PRI_0003_05.do"; 
                break;
            case 9:
                sUrl = "ESM_PRI_0003_06.do"; 
                break;              
            }
            objTabWindow.location.href = sUrl;
            return true;
        }
        
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var sRow = sheetObj2.SelectRow;
        if (selRow != null && selRow != undefined){
        	sRow = selRow;
        }
        var sPropNo = sheetObj2.CellValue(sRow,"prop_no");
        var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
        var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");
        var sPreAmdtSeq = sheetObj1.CellValue(1, "pre_amdt_seq");   //Amend시 사용
        var sPropStsCd = sheetObj1.CellValue(1, "prop_sts_cd");
        var sEffDt = sheetObj2.CellValue(sRow, "eff_dt");
        var sExpDt = sheetObj2.CellValue(sRow, "exp_dt");       
        var sPreExpDt = sheetObj2.CellValue(sRow, "pre_exp_dt");
        var sIsReqUsr = sheetObj1.CellValue(1, "req_usr_flg") == "Y" ? true: false;
        var sIsAproUsr = sheetObj1.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
        var sDurDupFlg = sheetObj2.CellValue(sRow, "dur_dup_flg");
        var sLgcyIfFlg = sheetObj1.CellValue(1, "lgcy_if_flg");
        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sPreAmdtSeq != null && sPreAmdtSeq != ""
                       && sPropStsCd != null && sPropStsCd != "" && sEffDt != null && sEffDt != "" && sPreExpDt != null && sPreExpDt != "" && sheetObj2.CellValue(sRow, "ibflag")!="I") {
        	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg);
        }

    }
    
    /**
     * Tab에 로드된 모든 Sheet의 데이터를 Clear한다.  <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllTabPages()
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
    function clearAllTabPages() {
        for (var i = 0; i < tabObjects[0].GetCount(); i++) {
            tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
            if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
                document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
            }
        }
    }
    
    /**
    * 화면상의 입력 필드와 IBMulti Combo Object의 값을 Clear한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     clearAllForms()
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  
    function clearAllForms(){
        
        var formObj = document.form;        
        formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.rf_flg.value="";
        formObj.gamt_flg.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        comboObjects[0].Index = -1;
        formObj.prop_srep_nm.value="";
        comboObjects[1].Index = -1;
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.file_dt.value="";
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        comboObjects[2].Index = -1;     
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        comboObjects[3].Index = -1;         
        formObj.ctrt_cust_srep_nm.value="";
        formObj.oti_no.value="";
        formObj.oti_eff_dt.value = "";
        formObj.oti_exp_dt.value = "";
        formObj.oti_amt.value = "";
        formObj.oti_lic_no.value = "";
        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        comboObjects[4].Index = -1;             
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        comboObjects[5].Index = -1;             
        formObj.real_cust_srep_nm.value="";
        formObj.prop_mqc_qty.value="";
        comboObjects[6].Index = -1;         
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
        formObj.prop_pfmc.value="";
        formObj.prop_atmt.value="";
        formObj.prs_crnt_cm_amt.value = "";
        formObj.prs_estm_cm_amt.value = "";
        formObj.prs_sum_cm_amt.value = "";
        formObj.sale_lead_ori.value = "";
    }
    


   /**
    * sheet의 팝업버튼이미지를 변경한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheetButtonImageChange()
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 이미지를 변경하고자하는 해당 셀의 Row Index    
    * @return {int} <br>
    *          0 : 비활성 이미지<br>
    *          1 : 활성 이미지
    * @author 공백진
    * @version 2009.04.17
    */  
    function sheetButtonImageChange(sheetObj, Row, sw){
    	sheetObj.PopupButtonImage(Row, "scp_dur_pop") = sw;
        sheetObj.PopupButtonImage(Row, "prop_scp_mqc_pop") = sw;
    }    
   
    /**
     * 버튼 권한을 제어하는 컨트롤 function <br>
     * 화면의 버튼을 상태에 따라 활성,비활성화 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     buttonControl();
     * </pre>
     * @param   없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
    function buttonControl(){
        
        var formObj = document.form;
        var sts = sheetObjects[0].CellValue(1, "prop_sts_cd");
        var reqUsrFlg  = sheetObjects[0].CellValue(1, "req_usr_flg");
        var aproUsrFlg = sheetObjects[0].CellValue(1, "apro_usr_flg");
        var allUsrFlg = sheetObjects[0].CellValue(1, "all_usr_flg");
        var amdt_seq = sheetObjects[0].CellValue(1, "amdt_seq");    
        var lgcyIfFlg = sheetObjects[0].CellValue(1, "lgcy_if_flg");
        var ptyProgStsCd = sheetObjects[0].CellValue(1, "pty_prog_sts_cd");
        // [CHM-201538667] ALPS S/C Autofiling 관련 보완 요청 
        var fmcCfmFlg = sheetObjects[0].CellValue(1, "fmc_cfm_flg"); 
        
        var sheetObj = sheetObjects[1];        
        var scp_req_usr_flg = reqUsrFlg;
        var scp_apro_usr_flg = aproUsrFlg;
        var conAuth = false;

        
//        aproUsrFlg="Y"
        
        //conversion 권한
        //if ( formObj.in_usr_ofc_cd.value == "PKGSA" || formObj.in_usr_ofc_cd.value == "SELCMQ" ){
        // 2017.02.23 (송민석) Log in Office: SELCMA or NYCRA 이고 PRI04(Note Conversion Staff) 권한 보유         
        if ( formObj.in_usr_ofc_cd.value == "PHXSA" || formObj.in_usr_ofc_cd.value == "NYCRA" || formObj.in_usr_ofc_cd.value == "SELCMA" || formObj.in_usr_ofc_cd.value == "SELCMD" ){
        	conAuth = true;
        }
        
        //승인권자에게만 C/T Availible을 보여준다.
        if(  aproUsrFlg !="Y"){
            ComShowObject(document.getElementById("ct_available_time_td1"), false);
            ComShowObject(document.getElementById("ct_available_time_td2"), false);
        }else{
            ComShowObject(document.getElementById("ct_available_time_td1"), true);
            ComShowObject(document.getElementById("ct_available_time_td2"), true);
        }


        try{
            btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);
            ComBtnDisable("btn_ctrt_pty_pop");
            ComBtnDisable("btn_dur_pop");
            ComBtnDisable("btn_prop_mqc_pop"); 
            document.getElementById("btn_ctrt_pty").style.color = "black";
            document.getElementById("btn_mqc").style.color = "black";
            document.getElementById("btn_dur").style.color = "black";
            document.getElementById("btn_blpl").style.color = "black";
            document.getElementById("btn_afil").style.color = "black";            
            
            btnImgEnable(formObj.btn_ctrt_cust, false);
            btnImgEnable(formObj.btn_real_cust, false);            
            btnImgEnable(formObj.btns_calendar1, false);
            btnImgEnable(formObj.btns_calendar2, false);    
            btnImgEnable(formObj.btn_eff_dt, false);

            
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_save");  
            ComBtnDisable("btn_amend");         
            ComBtnDisable("btn_request");           
            ComBtnDisable("btn_coffer");            
            ComBtnDisable("btn_approve");           
            ComBtnDisable("btn_scnoassign");            
            ComBtnDisable("btn_file");            
            ComBtnDisable("btn_cancel");            
            ComBtnEnable("btn_copy");          
            ComBtnDisable("btn_print");    
            ComBtnDisable("btn_cancel_file"); 
            
            btnImgEnable("btn_mqc_estimate",false);

            formObj.conv_cfm_flg.disabled = true;
            if (sts == "I" && formObj.prop_no.value == ""){
            	formObj.conv_cfm_flg.disabled = true;
            }else{

            	if (sheetObjects[0].CellValue(1, "n_conv_cfm_flg") == "Y" ||formObj.amdt_seq.value == "0" ){
                    if (sheetObjects[0].CellValue(1, "conv_cfm_flg") == "Y"){
                    	formObj.conv_cfm_flg.disabled = true
                    }else{    
                    	if (conAuth  || reqUsrFlg){
                    		formObj.conv_cfm_flg.disabled = false;
                    	}
                    }            
                }else{        	
                	formObj.conv_cfm_flg.disabled = true;
                }
            }
            //작성자  Initial, Request Cancel 할수있다.
            if ((reqUsrFlg =="Y" && sts=="Q") || aproUsrFlg =="Y"){
            	ComBtnEnable("btn_cancel");           	
            }
                 
            ComBtnDisable("btn_rowadd");            
            ComBtnDisable("btn_delete");            
            
            formObj.prop_mqc_qty.readOnly = false;          
            formObj.ctrt_eff_dt.readOnly = false;
            formObj.ctrt_exp_dt.readOnly = false;           
            formObj.prop_ofc_cd.readOnly = true;
            formObj.cust_cnt_cd.readOnly = false;
            formObj.cust_seq.readOnly = false;            
            
            //real customer
            changeRealCustomerEditable(false);

            formObj.rf_flg.disabled = true;//reefer            
            formObj.gamt_flg.disabled = true;//garment            	
            formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
            formObj.prop_apro_ofc_cd.enable = false;//Approval Office
            formObj.ctrt_cust_srep_cd.enable = false; //Contract Customer Sales Rep
            formObj.sls_ld_no.enable = false;//Sales Lead
            
            
//            if (sts =="F" && formObj.in_usr_id.value == FILE_CANCEL_USER_ID){// Filed이고 허가된 유저이면 아래 로직을 건너뛰기 위해서 YY로 강제 setting
//            	reqUsrFlg  = "Y";
//            	aproUsrFlg = "N";
//            }
            
            var fileCancelAuth = checkFileCancelUser();
            
            if (!(sts =="F" && (fileCancelAuth == "Y"))) { //Filed이고 허가된 유저이면 로직 적용 안함. 위 로직 변형
	            if(reqUsrFlg !="Y" && aproUsrFlg !="Y"){
	                //모든권한 없음...
	                formObj.prop_mqc_qty.readOnly = true;          
	                formObj.ctrt_eff_dt.readOnly = true;
	                formObj.ctrt_exp_dt.readOnly = true;           
	                formObj.cust_cnt_cd.readOnly = true;
	                formObj.cust_seq.readOnly = true;
	              	formObj.prc_ctrt_cust_tp_cd.enable = false;
	              	formObj.cntr_lod_ut_cd.enable = false;                
	                btnImgEnable(formObj.btn_ctrt_cust, false);
	                btnImgEnable(formObj.btns_calendar1, false);
	                btnImgEnable(formObj.btns_calendar2, false); 
	                ComBtnDisable("btn_save");
	                ComBtnDisable("btn_copy");
	                if(amdt_seq != "0"){
	                	 ComBtnEnable("btn_dur_pop");
	                	 ComBtnEnable("btn_prop_mqc_pop");
	                	 ComBtnEnable("btn_ctrt_pty_pop");
	                	btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
	                }
	        		
	        		for (var i = 1; i <= sheetObj.RowCount;i++){    
	    		        for (var j = 2; j <= 23; j++){
	    		            sheetObj.CellEditable(i,j) = false;
	    		        }
	        			sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
	        		    sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
	        		    sheetObj.PopupButtonImage(i, "quick_accept") = 0;
	        		    sheetObj.CellEditable(i, "quick_accept") = false;
	        		    if (amdt_seq == "0"){
	        		    	sheetObj.CellEditable(i, "scp_dur_pop") = false;
	        		    	sheetObj.CellEditable(i, "prop_scp_mqc_pop") = false;
	        		    	sheetButtonImageChange(sheetObj,i, 0);// 비활성
	        		    }else{
	        		    	sheetObj.CellEditable(i, "scp_dur_pop") = true;
	        		    	sheetObj.CellEditable(i, "prop_scp_mqc_pop") = true;
	        		    	sheetButtonImageChange(sheetObj,i, 1);// 활성
	        		    }
	        		}         		
	                return;
	            }
            }

            for (var i = 1; i <= sheetObj.RowCount; i++){
                sheetButtonImageChange(sheetObj,i, 1);//활성
            }
            
            //mqc 활성화
            ComBtnEnable("btn_prop_mqc_pop");
            
            
          
            
            switch(sts) {
                case 'I':   // Initial              
                    if(reqUsrFlg=="Y"||aproUsrFlg=="Y"){                        
                        if (formObj.prop_no.value !=""){
                            ComBtnEnable("btn_request");   
                            ComBtnEnable("btn_blpl_pop");           
                            ComBtnEnable("btn_afil_pop");
                            ComBtnEnable("btn_ctrt_pty_pop");                            
                            ComBtnEnable("btn_cancel");
                            btnImgEnable("btn_mqc_estimate",true);
                        }
                        ComBtnEnable("btn_rowadd");         
//                        ComBtnDisable("btn_prop_mqc_pop");
                        btnImgEnable(formObj.btn_ctrt_cust, true);
                        ComBtnEnable("btn_print");
                        if(amdt_seq == "0"){
                            btnImgEnable(formObj.btns_calendar1, true);
                            btnImgEnable(formObj.btns_calendar2, true);   
                            formObj.prop_mqc_qty.readOnly = false;
                            formObj.ctrt_eff_dt.readOnly = false;
                            formObj.ctrt_exp_dt.readOnly = false;     
                            if(ptyProgStsCd =="A"){
                            	formObj.cust_cnt_cd.readOnly = true;        
                            	formObj.cust_seq.readOnly = true;
                            	btnImgEnable(formObj.btn_ctrt_cust, false);  
                            }else{
                            	formObj.cust_cnt_cd.readOnly = false;
                                formObj.cust_seq.readOnly = false;
                            }
                            formObj.prc_ctrt_cust_tp_cd.enable = true;  
                            formObj.cntr_lod_ut_cd.enable = true;

                        }else{           
                        	//duration
                            formObj.ctrt_eff_dt.readOnly = true;
                            formObj.ctrt_exp_dt.readOnly = true;
                            //customer
                            formObj.cust_cnt_cd.readOnly = true;
                            formObj.cust_seq.readOnly = true;
                            formObj.prc_ctrt_cust_tp_cd.enable = false;                            
                            btnImgEnable(formObj.btn_ctrt_cust, false);
                            btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
//                            ComBtnEnable("btn_prop_mqc_pop");
                            ComBtnEnable("btn_dur_pop");
                            formObj.prop_mqc_qty.readOnly = true;
                            formObj.cntr_lod_ut_cd.enable = false;  
                        }
                        svcScpDeleteEnable();
                        
    					// [CHM-201538667] ALPS S/C Autofiling 관련 보완 요청 
    					// FMC Filing 이후에는 이전 AMD 로 CANCEL 불가 기능 추가
                        // 조건 1: Request/Approval 권한이 존재하지 않으면 여기까지도 진행안됨.(그냥 비활성화됨.)
    					// 조건 2: CFM_NO 존재 = 'Y' && 상태 = 'I' && 권한 무시
                        //test case : prop_no : SEL140114, 1 이상 = Y , ATL150020, 0 = N , 
                        if(fmcCfmFlg=="Y"){
    						ComBtnDisable("btn_cancel");  
                        }
                    }
    
                    break;
                    
                case 'Q':   // Requested

                	ComBtnEnable("btn_print");                
                	
                	ComBtnEnable("btn_prop_mqc_pop");
                	
                	//Chloe mijin SEO [CHM-201217458] setting "S/C No. Assign" button enable after Request step
                	if(allUsrFlg=="Y" && amdt_seq == "0" ){
                    	ComBtnEnable("btn_scnoassign");                                                
                    }
                	
                    if (amdt_seq =="0"){
                    	ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);
                    }else{
                        ComBtnEnable("btn_dur_pop");
//                        ComBtnEnable("btn_prop_mqc_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                    }

                    if(aproUsrFlg=="Y"){    
                        if( amdt_seq != "0" ){
                            // EFF DT를 변경할수 있게 해준다.
                            //amend 0일때는 duration을 변경해야 한다.
                            btnImgEnable(formObj.btn_eff_dt, true);
                        }

                        var rValue = checkAccept();                        
                        //all accept일 경우 approve 활성화 C/offer  비활성화
                        if (rValue == "Y"){
                            ComBtnEnable("btn_approve"); //(terms가 all accept 경우)-클릭시 check 
                            ComBtnDisable("btn_coffer");    
                        }else{
                            ComBtnDisable("btn_approve");
                            ComBtnEnable("btn_coffer"); 
                        }                                             
                    }
                              
                    formObj.ctrt_eff_dt.readOnly = true;    //duration
                    formObj.ctrt_exp_dt.readOnly = true;                    
                    //customer
                    formObj.cust_cnt_cd.readOnly = true;
                    formObj.cust_seq.readOnly = true;
                    formObj.prc_ctrt_cust_tp_cd.enable = false;
                              
                    btnImgEnable(formObj.btn_ctrt_cust, false);
                    ComBtnEnable("btn_ctrt_pty_pop");
                    formObj.prop_mqc_qty.readOnly = true;
                    formObj.cntr_lod_ut_cd.enable = false;
                              
                    break;
                    
                case 'R':   // Returned
                	ComBtnEnable("btn_prop_mqc_pop");
                	//Chloe mijin SEO [CHM-201217458] setting "S/C No. Assign" button enable after Request step
                	if(allUsrFlg=="Y" && amdt_seq == "0" ){
                    	ComBtnEnable("btn_scnoassign");                                                
                    }
                	
                    if (amdt_seq =="0"){
                    	ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);

                    }else{ 
                        ComBtnEnable("btn_dur_pop");
                        
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                        ComBtnEnable("btn_print");
                    }
                    if(reqUsrFlg=="Y" ){   
                    	btnImgEnable("btn_mqc_estimate",true);
                    }

                    //duration
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;                    
                    //customer
                    formObj.cust_cnt_cd.readOnly = true;
                    formObj.cust_seq.readOnly = true;
                    formObj.prc_ctrt_cust_tp_cd.enable = false; 
                    btnImgEnable(formObj.btn_ctrt_cust, false);                     
                    ComBtnEnable("btn_ctrt_pty_pop");
                    formObj.prop_mqc_qty.readOnly = true;
                    formObj.cntr_lod_ut_cd.enable = false;
                    
                    break;
                    
                case 'A':   // Approved
                	ComBtnEnable("btn_print");
                	ComBtnEnable("btn_prop_mqc_pop");
                    if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);                    
                    }else{
                        ComBtnEnable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true);
                        
                    }

                    if(allUsrFlg=="Y"){
                        if (amdt_seq == "0"){ //assign할 경우 File버튼 활성화
                            if (formObj.sc_no.value ==""){
                                ComBtnDisable("btn_file");
                            }else{
                                ComBtnEnable("btn_file");
                            }                
                        	ComBtnEnable("btn_scnoassign");                        
                        }else{
                            ComBtnEnable("btn_file");   
                        }                         
                    }

                    //duration
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;
                    
                    //customer
                    formObj.cust_cnt_cd.readOnly = true;
                    formObj.cust_seq.readOnly = true;
                    formObj.prc_ctrt_cust_tp_cd.enable = false;                 
 
                    ComBtnEnable("btn_ctrt_pty_pop");
                    btnImgEnable(formObj.btn_ctrt_cust, false);     
                    formObj.prop_mqc_qty.readOnly = true;
                    formObj.cntr_lod_ut_cd.enable = false;
                        
                    break;
                case 'F':   // Filed
                	ComBtnDisable("btn_cancel");
                    ComBtnEnable("btn_amend");  
                    ComBtnEnable("btn_print");
                    ComBtnEnable("btn_prop_mqc_pop");
                	if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, false);     
                    }else{      
                        ComBtnEnable("btn_dur_pop");
                        btnImgEnable(formObj.btn_ctrt_cust_tp_pop, true); 
                    }
                	
                	// Superuser 권한을 가졌고 현재 조회된 데이터가 이행데이터가 아닐경우
                	if((IS_SUPER_USER == true && lgcyIfFlg == "N")||(fileCancelAuth == "Y") ){                		                		
                		ComBtnEnable("btn_cancel_file");   
                		ComBtnEnable("btn_cancel");
                	}

                    //duration
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;
                    
                    //customer
                    formObj.cust_cnt_cd.readOnly = true;
                    formObj.cust_seq.readOnly = true;
                    formObj.prc_ctrt_cust_tp_cd.enable = false;                 

                    ComBtnEnable("btn_ctrt_pty_pop");
                    btnImgEnable(formObj.btn_ctrt_cust, false);                     
                    
                    formObj.prop_mqc_qty.readOnly = true;
                    formObj.cntr_lod_ut_cd.enable = false;                        
                    break;                    
            }
            
            otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
            sheetControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);

        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    
    /**
    * Html 태그 오브젝트,IBMultiCombo를 메인의 상태에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
    * </pre>
    * @param   {string} sts 필수          메인의 상태코드
    * @param   {string} amdt_seq 필수     amend seq Number
    * @param   {string} reqUsrFlg 필수  화면에대한 작성자권한 <br>
    *                   Y : 작성자 권한 있음
    *                   N : 작성자 권한 없음
    * @param   {string} aproUsrFlg 필수 화면에대한 승인권한 <br>
    * 					Y : 승인권한 있음
    * 					N : 승인권한 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function otherFormControl(sts,amdtSeq,reqUsrFlg,aproUsrFlg){
        var formObj = document.form;
        var tpCd = formObj.prc_ctrt_cust_tp_cd.Code;

        if (aproUsrFlg == "Y"){
        	formObj.prop_ofc_cd.readOnly = false;
        }else{
        	formObj.prop_ofc_cd.readOnly = true;
        }
        	
    	switch (sts){
	    	case "I":
	    		if (amdtSeq =="0"){
				    formObj.rf_flg.disabled = false;//reefer            
				    formObj.gamt_flg.disabled = false;//garment
	    			formObj.prop_srep_cd.enable = true;    //sale rep 
	    			formObj.ctrt_cust_srep_cd.enable = true;
					if (tpCd =="N" || tpCd =="A"){ //customer type이 'N, 'A' 일 때 multi 팝업 창이 활성화됨 [CHM-201324672]
						changeRealCustomerEditable(true); //Real Customer
					}	
					formObj.sls_ld_no.enable = true;//Sales Lead
	    		}else{
	    			formObj.rf_flg.disabled = false;//reefer 
	    			formObj.gamt_flg.disabled = false;//garment
	    			if (aproUsrFlg == "Y" || reqUsrFlg=="Y"){
	    				formObj.prop_srep_cd.enable = true;    //sale rep
	    				if (aproUsrFlg =="Y"){
		    				formObj.ctrt_cust_srep_cd.enable = true; //Contract Customer Sales Rep
		    				if (tpCd =="N" || tpCd =="A"){ //customer type이 'N, 'A' 일 때 multi 팝업 창이 활성화됨 [CHM-201324672]
		    					changeRealCustomerEditable(true); //Real Customer
		    				}		    					
	    				}
	    			}
	    		}
	    		formObj.prop_apro_ofc_cd.enable = true; //Approval Office	    		
	    		
	    		break;
	    	case "Q":
	    	case "R":
	    	case "A":
	    		if (amdtSeq =="0"){
	    			formObj.rf_flg.disabled  = false;//reefer 
	    			formObj.gamt_flg.disabled = false;//garment
	    		}else{
	    			formObj.rf_flg.disabled = false;//reefer 
	    			formObj.gamt_flg.disabled = false;//garment
	    		}    		
				if (aproUsrFlg == "Y" || reqUsrFlg=="Y"){
					formObj.prop_srep_cd.enable = true;    //sale rep 
					if (aproUsrFlg =="Y"){
						formObj.ctrt_cust_srep_cd.enable = true; //Contract Customer Sales Rep
						if (tpCd =="N" || tpCd =="A"){ //customer type이 'N, 'A' 일 때 multi 팝업 창이 활성화됨 [CHM-201324672]
							changeRealCustomerEditable(true); //Real Customer
						}							
					}
				}
	    		break;
	    	case "F":
	    		if (amdtSeq =="0"){
	
	    		}else{
	    			formObj.rf_flg.disabled = true;//reefer 
	    			formObj.gamt_flg.disabled = true;//garment
	    		}   
	    		if (aproUsrFlg == "Y" || reqUsrFlg=="Y"){
					formObj.prop_srep_cd.enable = true;    //sale rep 
					if (aproUsrFlg =="Y"){
						formObj.ctrt_cust_srep_cd.enable = true; //Contract Customer Sales Rep
						if (tpCd =="N" || tpCd =="A"){ //customer type이 'N, 'A' 일 때 multi 팝업 창이 활성화됨 [CHM-201324672]
							changeRealCustomerEditable(true); //Real Customer
						}						
					}
						
				}
	    		break;
    	}
    	
    }
    
    /**
    * IBSheet의 Cell을  메인의 상태에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,reqUsrFlg,aproUsrFlg);
    * </pre>
    * @param   {string} sts 필수        메인의 상태코드
    * @param   {string} amdtSeq 필수    amend seq Number
    * @param   {string} reqUsrFlg 필수  화면에대한 작성자권한 <br>
    *                   Y : 작성자 권한 있음
    *                   N : 작성자 권한 없음
    * @param   {string} aproUsrFlg 필수 화면에대한 승인권한 <br>
    * 					Y : 승인권한 있음
    * 					N : 승인권한 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function sheetControl(stsCd,amdtSeq,reqUsrFlg,aproUsrFlg){
    	var sheetObj = sheetObjects[1];
    	
    	if (stsCd == "I"){
	        if (amdtSeq == "0"){
	    		for (var i = 1; i <= sheetObj.RowCount;i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){                                    
		                  sheetObj.CellEditable(i, "prop_scp_mqc_pop") = false;
		                  sheetObj.CellEditable(i, "scp_dur_pop") = false;
		                  sheetButtonImageChange(sheetObj,i, 0);//비활성		          
		                  sheetObj.CellEditable(i,"prop_scp_mqc_qty") = true;
		                  sheetObj.CellEditable(i,"cntr_lod_ut_cd") = true;
		                  sheetObj.CellEditable(i,"ctrt_eff_dt") = true;
		                  sheetObj.CellEditable(i,"ctrt_exp_dt") = true;
		                  sheetObj.CellEditable(i, "gline_cp_flg_lnk") = true;
		                  sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 1;
		                  
		                  sheetObj.CellEditable(i, "prop_scp_ofc_cd") = false;
		                  sheetObj.CellEditable(i, "prop_scp_srep_cd") = true;
		              }else{
		                  for (var j = 2; j <=sheetObj.LastCol; j++){
		                      sheetObj.CellEditable(i,j) = false;
		                  }
		                  sheetButtonImageChange(sheetObj,i, 0);//비활성
		                  sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
		              }
		              sheetObj.CellEditable(i,"gri_appl_flg") = false;
		              sheetObj.CellEditable(i,"new_scg_flg") = false;
		          }
	        }else{
		          for (var i = 1; i <= sheetObj.RowCount;i++){
		              if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
		                  if(sheetObj.CellValue(i,"ctrt_eff_dt") == sheetObjects[0].CellValue(1,"eff_dt")){
		                	  sheetObj.CellEditable(i, "gline_cp_flg_lnk") = true;
		                	  sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 1;
		                  	
		                  }else{
		                	  sheetObj.CellEditable(i, "ctrt_exp_dt") = false;
		                	  sheetObj.CellEditable(i, "prop_scp_mqc_qty") = false;
		                	  sheetObj.CellEditable(i, "cntr_lod_ut_cd") = false;
		                  }
		                  sheetObj.CellEditable(i, "prop_scp_ofc_cd") = false;
		                  sheetObj.CellEditable(i, "prop_scp_srep_cd") = false;
//		                  if (aproUsrFlg == "Y"){
		                	  sheetObj.CellEditable(i, "prop_scp_srep_cd") = true;
		                	  
//		                  }
		              }else{
		                  for (var j = 2; j <=sheetObj.LastCol; j++){
		                      sheetObj.CellEditable(i,j) = false;
		                  }
		                  sheetButtonImageChange(sheetObj,i, 0);//비활성
		                  sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
		              }
		              sheetObj.CellEditable(i,"gri_appl_flg") = false;
		              sheetObj.CellEditable(i,"new_scg_flg") = false;
		          }
	        }
    	}else if (stsCd == "F"){    
    		for (var i = 1; i <= sheetObj.RowCount;i++){ 
		        for (var j = 2; j <=sheetObj.LastCol; j++){	
		        	sheetObj.CellEditable(i,j) = false;
		        }
		        if (amdtSeq == "0"){
			        sheetObj.CellEditable(i,"scp_dur_pop") = false;
			        sheetObj.CellEditable(i,"prop_scp_mqc_pop") = false;
			        sheetButtonImageChange(sheetObj,i, 0);//비활성
		        }else{
			        sheetObj.CellEditable(i,"scp_dur_pop") = true;
			        sheetObj.CellEditable(i,"prop_scp_mqc_pop") = true;
		        }

    		    sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
    		    sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;    		    
    		}
    	}else{
    		for (var i = 1; i <= sheetObj.RowCount;i++){	           
    		    if (amdtSeq == "0"){
    		        sheetObj.CellEditable(i, "prop_scp_mqc_pop") = false;
    		        sheetObj.CellEditable(i, "scp_dur_pop") = false;
    		        sheetButtonImageChange(sheetObj,i, 0);//비활성
    		    }
    		    if (reqUsrFlg == "Y" || aproUsrFlg == "Y" ){
    		        sheetObj.CellEditable(i, "ctrt_eff_dt") = false;
    		        sheetObj.CellEditable(i, "ctrt_exp_dt") = false;
    		        sheetObj.CellEditable(i, "prop_scp_mqc_qty") = false;
    		        sheetObj.CellEditable(i, "cntr_lod_ut_cd") = false;
    		        sheetObj.CellEditable(i, "prop_scp_ofc_cd") = false;
    		        sheetObj.CellEditable(i, "prop_scp_srep_cd") = false;
//    		        if (aproUsrFlg == "Y"){
    		        	sheetObj.CellEditable(i, "prop_scp_srep_cd") = true;
//    		        }
    		        // 승인 권자 이면서 상태가 Requested, Approved 일 경우에만 NO GRI, NO New SCHG 
    		        // 컬럼을 Editable 상태로 바꿔준다. 2015.03.16 송호진
       		        if (aproUsrFlg == "Y" && ( stsCd == "Q" || stsCd =="A" ) ){
       		            sheetObj.CellEditable(i,"gri_appl_flg") = true;
       		            sheetObj.CellEditable(i,"new_scg_flg") = true;
       		        } else {
       		            sheetObj.CellEditable(i,"gri_appl_flg") = false;
       		            sheetObj.CellEditable(i,"new_scg_flg") = false;
       		        }
    		    }else{
    		        for (var j = 2; j <=sheetObj.LastCol; j++){
    		            sheetObj.CellEditable(i,j) = false;
    		        }
    		        sheetButtonImageChange(sheetObj,i, 0);//비활성                            
    		    }
    		    sheetObj.CellEditable(i, "prop_scp_apro_ofc_cd") = false;
    		    sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
    		    sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
    		}
    	}
        //Quick Accept
        if(stsCd == "Q" && aproUsrFlg =="Y"){
        	quickAcceptAllControl("1", true);
        }else{
        	quickAcceptAllControl("0", false);
        }
    }                            
    
    /**
     * 시트의 Quick Accept 필드 이미지를 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    quickAcceptAllControl("0", false);
     * </pre>
     * @param   {string} key 필수   Image Index 0 : 비활성, 1: 활성
     * @return 없음
     * @author 김민아
     * @version 2011.03.28
     */ 
    function quickAcceptAllControl(key, flag){
    	var sheetObj = sheetObjects[1];
    	var reKey = key;
    	var reFlag = flag;
    	
		for (var i = 1; i <= sheetObj.RowCount;i++){
			if(sheetObj.CellValue(i, "prop_scp_sts_cd") == "A"){
				key = 0;
				flag = false;
			}else{
				key = reKey;
				flag = reFlag;
			}
			sheetObj.PopupButtonImage(i, "quick_accept") = key;
			sheetObj.CellEditable(i, "quick_accept") = flag;
		}
    }
          

    /**
    * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 Summary Table을 수정한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    comUpdateProposalStatusSummary(termTpCd, svcScpCd);
    * </pre>
    * @param   {string} termTpCd 필수   Terms의 기 정의된 코드
    * @param   {string} svcScpCd 필수   Scope의 코드
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
    function comUpdateProposalStatusSummary(termTpCd, svcScpCd){
        var sParam = "";
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        try{
        	ComOpenWait(true); //->waiting->start 

            //--->Main의 상태를  변경한다.
            changeMainStatus();

            if(svcScpCd != undefined && svcScpCd != ""){
            	comApplyStyleProposalStatusSummary(svcScpCd);
                scopeStatusChange(svcScpCd) //scope 상태변경
            }
            ComOpenWait(false); //->waiting->End
            buttonControl();        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	ComOpenWait(false); //->waiting->End
        }        
    }
        

        
    
 /**
  * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 해당 Tab의 아이콘을 변경한다.<br>
  * <br><b>Example :</b>
  * <pre>
  *    comApplyStyleProposalStatusSummary( svcScpCd);
  * </pre>
  * @param   {string} svcScpCd 선택   Scope 코드
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */ 
 function comApplyStyleProposalStatusSummary(svcScpCd){
	 var formObj = document.form;
	 var sheetObj = sheetObjects[0];
     formObj.f_cmd.value = SEARCH04;
     
     var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
     sParam += "&" + FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd;     
     var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", sParam);
     var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");

     var icon = "";
     var tabIdx = "";
     var imgName = "";
     var lgcyIfFlg = sheetObjects[0].CellValue(1, "lgcy_if_flg");
     for (i = 0; arrText != null && i < arrText.length; i++){
    	 imgName = "";
    	 tabIdx = "";
    	 switch(arrText[i][0]){
	     	case '01':  //Duration,Scope Duration
	         	imgName = "img_dur";
	             break;
	        case '02':  //MQC,Scope MQC
		         imgName = "img_mqc";
	             break;  
	        case '04':  //contract party
	         	imgName = "img_ctrt";
	         	break;  	             
	        case '05':
	        	 imgName = "img_affil";
	        	 break;
	        case '06':
	        	 imgName = "img_blpl";
	        	 break;	           
	        case '07':
	        	 imgName = "img_ctrt_tpy";
	        	 break;	     	        	 
	        case '13':  //Group Location
	             tabIdx = "1";
	             break;	               
	        case '14':  //Group Commodity
	             tabIdx = "2";                 
	             break;	               
	        case '15':  //Loading Agent
	             tabIdx = "7";
	             break;	               
	        case '31':  //Standard Note
	             tabIdx = "5";                 
	             break;	           
	        case '32':  //Special Note
	             tabIdx = "6";
	             break;	               
	        case '42':                
	             tabIdx = "0";                     
	             break;	               
	        case '52':            
	             tabIdx = "3";
	             break;	               
	        case '62':                 
	             tabIdx = "8";
	             break;	               
	        case '16':  //GOH Charge
	             tabIdx = "9";
	             break;	               
	        case '72':
                 tabIdx = "4";
	             break;  
    	 }

    	 icon = ICON_URL_NOT_EXIST;
    	 switch(arrText[i][1]){
        	 case "1":
        		 icon = ICON_URL_EXIST;
        		 break;
        	 case "2":
        		 if (lgcyIfFlg == "Y"){
        			 icon = ICON_URL_EXIST;
        		 }else{
        			 icon = ICON_URL_AMEND;
        		 }        		 
        		 break;
        	 case "3":
        		 if (lgcyIfFlg == "Y"){
        			 icon = ICON_URL_EXIST;
        		 }else{
        			 icon = ICON_URL_ACCEPT;
        		 }        		 
        		 break;
    	 }
         // 기본 : Black , Amend시 : Red, All Accept시 : Blue
         if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "04"
        	 ||arrText[i][0] == "05"||arrText[i][0] == "06" ||arrText[i][0] == "07"){
        	 if (imgName !="") document.images(imgName).src = icon;
         }else{
             if (tabIdx != ""){
            	 tabObjects[0].ImageUrl(tabIdx) = icon;	 
             }        	  
         }
     }        
     
 }    
/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////   

//  combo 관련    (S)   -----   

 /**
  * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
  * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *    prop_apro_ofc_cd_OnChange(comboObj, code, text);
  * </pre>
  * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
  * @param   {string} code 필수 코드
  * @param   {string} text 화면에 표시된 문자 
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */ 
    function prop_apro_ofc_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "prop_apro_ofc_cd" )
    }   
    
    /**
     * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
     * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    prop_srep_cd_OnChange(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @param   {string} code 필수 코드
     * @param   {string} text 화면에 표시된 문자 
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     
    function prop_srep_cd_OnChange(comboObj, code, text) {	
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");
    	if (arrText != null && arrText.length > 1) {
    		formObj.prop_srep_nm.value = comboObj.GetText(code, 1);
    	}
        com_change_sheet( sheetObj, "prop_srep_cd" )
    }   

    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    ctrt_cust_srep_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */    
    function ctrt_cust_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");

        if (arrText[1] != null && arrText[1] != undefined){
            formObj.ctrt_cust_srep_nm.value = arrText[1];
            formObj.ctrt_cust_sls_ofc_cd.value = arrText[2];
            
        }else{
        	formObj.ctrt_cust_srep_nm.value = "";
        	formObj.ctrt_cust_sls_ofc_cd.value = "";    

        }
        
        //sale lead
        setSaleLeadCombo(true);   
        sheetObj.CellValue(1, "sls_ld_no")= "";     
        
        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
        com_change_sheet( sheetObj, "ctrt_cust_sls_ofc_cd" );
    }    
//    function ctrt_cust_srep_cd_OnChange(comboObj, code, text) {
//        var formObj = document.form;
//        var sheetObj = sheetObjects[0];
//        var arrText = text.split("|");
//        if (arrText[1] != null && arrText[1] != undefined){
//            formObj.ctrt_cust_srep_nm.value = arrText[1];
//        }
//        
//        if (code != ""){
//        	formObj.ctrt_cust_sls_ofc_cd.value = getOfficeCd(code); 
//        }else{
//        	formObj.ctrt_cust_srep_nm.value = "";
//        }        
//        //sale lead
//        setSaleLeadCombo(true);   
//        sheetObj.CellValue(1, "sls_ld_no")= "";     
//        
//        com_change_sheet( sheetObj, "ctrt_cust_srep_cd" )
//    }
    
    /**
     * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
     * Combo의 text값을 Html Object에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
     function ctrt_cust_srep_cd_OnBlur(comboObj) {
   		var formObj = document.form;		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   		var sheetObj = sheetObjects[0];
   		var ofc = comboObj.GetText(comboObj.Code,2);
   		
   		if (code != null && code != "") {
   			var text = comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
   				formObj.ctrt_cust_srep_nm.value = comboObj.GetText(code, 1);
   				formObj.ctrt_cust_sls_ofc_cd.value = ofc;
   			}
   		}  		
		if (code == -1){
			formObj.ctrt_cust_srep_nm.value = "";
		}   		
   	}      
//    function ctrt_cust_srep_cd_OnBlur(comboObj) {
//  		var formObj = document.form;		
//  		var code = comboObj.FindIndex(comboObj.Code, 0);
//  		if (code != null && code != "") {
//  			var text = comboObj.GetText(code, 1);
//  			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
//  				formObj.ctrt_cust_srep_nm.value = comboObj.GetText(code, 1);
//  			}
//  		}  		
//  	}     
    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_srep_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 
    function real_cust_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");  
        if (arrText[1] != null && arrText[1] != undefined){
            formObj.real_cust_srep_nm.value = arrText[1];
            formObj.real_cust_sls_ofc_cd.value = arrText[2];
        }else{
        	formObj.real_cust_srep_nm.value = "";
        	formObj.real_cust_sls_ofc_cd.value = ""; 
        }

        //sale lead
        setSaleLeadCombo(true); 
        sheetObj.CellValue(1, "sls_ld_no")= ""; 
        com_change_sheet( sheetObj, "real_cust_srep_cd" );
        com_change_sheet( sheetObj, "real_cust_sls_ofc_cd" );
    }
//    function real_cust_srep_cd_OnChange(comboObj, code, text) {
//        var formObj = document.form;
//        var sheetObj = sheetObjects[0];
//        var arrText = text.split("|");  
//        if (arrText[1] != null && arrText[1] != undefined){
//            formObj.real_cust_srep_nm.value = arrText[1];
//        }       
//        if (code != ""){
//            formObj.real_cust_sls_ofc_cd.value = getOfficeCd(code);
//        }else{
//        	formObj.real_cust_srep_nm.value = "";
//        }
//        //sale lead
//        setSaleLeadCombo(true); 
//        sheetObj.CellValue(1, "sls_ld_no")= ""; 
//        com_change_sheet( sheetObj, "real_cust_srep_cd" )       
//    }   
    
    /**
     * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
     * Combo의 text값을 Html Object에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *   
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
     function real_cust_srep_cd_OnBlur(comboObj) {
   		var formObj = document.form;		
   		var code = comboObj.FindIndex(comboObj.Code, 0);
   		var sheetObj = sheetObjects[0];
   		var ofc = comboObj.GetText(comboObj.Code,2);
   		
   		if (code != null && code != "") {
   			var text = comboObj.GetText(code, 1);
   			if (text != null && text != "" && text != formObj.real_cust_srep_nm.value) {
   				formObj.real_cust_srep_nm.value = comboObj.GetText(code, 1);
   				formObj.real_cust_sls_ofc_cd.value = ofc;
   			}
   		}
		if (code == -1){
			formObj.real_cust_srep_nm.value = "";
		}   		
   	}      
     
//    function real_cust_srep_cd_OnBlur(comboObj) {
//  		var formObj = document.form;		
//  		var code = comboObj.FindIndex(comboObj.Code, 0);
//  		var sheetObj = sheetObjects[0];
//  		if (code != null && code != "") {
//  			var text = comboObj.GetText(code, 1);
//  			if (text != null && text != "" && text != formObj.real_cust_srep_nm.value) {
//  				formObj.real_cust_srep_nm.value = comboObj.GetText(code, 1);
//
//  			}
//  		}
//  	}    
    
    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    prc_ctrt_cust_tp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 필수 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */     
    function prc_ctrt_cust_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var amdtSeq = sheetObj.CellValue(1, "amdt_seq");
        var aproUsrFlg = sheetObj.CellValue(1, "apro_usr_flg");
        var reqUsrFlg  = sheetObj.CellValue(1, "req_usr_flg");
        var sw = false;
        if (formObj.cust_cnt_cd.value =="" && formObj.cust_seq.value == ""){
        	return;
        }
        if (code == "N"){        	
        	if (sheetObj.CellValue(1, "prop_sts_cd") == "I"){
        		sw = true;
        		if (amdtSeq == "0"){
        			if (reqUsrFlg == "Y" || aproUsrFlg =="Y"){
        				sw = true;
        			}        			
        		}else{
        			if (aproUsrFlg =="Y"){
        				sw = true;	
        			}
        		}
        	}
        }else{
        	if (formObj.real_cust_cnt_cd.value !="" && formObj.real_cust_seq.value != "" 
        		&& formObj.prop_no.value != "" && amdtSeq !="0"){
        		ComShowCodeMessage("PRI01079");
        		comboObjects[2].Text2 = "N";
        		return;
        	}
        }
        changeRealCustomerEditable(sw);        
        com_change_sheet( sheetObj, "prc_ctrt_cust_tp_cd" )     

        //Customer Type 변경시
        if (amdtSeq =="0" && checkCustomerType() == 'Y'){
        	ComShowCodeMessage('PRI01111');
        }
    }

    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_tp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 필수 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */     
    function real_cust_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        com_change_sheet( sheetObj, "real_cust_tp_cd" )     
    }   
    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    cntr_lod_ut_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 필수 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 
    function cntr_lod_ut_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "cntr_lod_ut_cd" )      
    }       
    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    sls_ld_no_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 필수 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */ 
    function sls_ld_no_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "sls_ld_no" )      
    }          
    
    /**
    * IBMulti Combo에서 KeyBoard를 눌렀을 때 발생하는 이벤트이다.<br>
    * 지정된 길이가 넘어가면 focus()를 다음 Object로 넘긴다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    prc_ctrt_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */         
	function prc_ctrt_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var tpCd = comboObj.Text;
		if (tpCd.length > 1) {
			document.form.ctrt_cust_srep_cd.focus();
		}
	}
    
    /**
    * IBMulti Combo에서 KeyBoard를 눌렀을 때 발생하는 이벤트이다.<br>
    * 지정된 길이가 넘어가면 focus()를 다음 Object로 넘긴다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    real_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */   
	function real_cust_tp_cd_OnKeyUp(comboObj, KeyCode, Shift) {
		var tpCd = comboObj.Text;

		if (tpCd.length > 1) {
			document.form.real_cust_val_sgm.focus();
		}
	}
	
	


//    combo 관련  (E)   -----


    /**
    * Reefer Check Box Object의 Check 값을 변경할 때 발생하는  event이다.<br>
    * 값을 변경하면 숨겨진 sheet에 변경된 값을 반영한다.<br>
    * 값을 check하면 Y uncheck하면 N으로 변경한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    rf_flg_OnChange();
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  
    function rf_flg_OnChange(){
        var sheetObj = sheetObjects[0]; 
        sheetObj.CellValue2(1,"rf_flg") = document.form.rf_flg.checked == true ? "Y" : "N";     

    }
    
    /**
     * Garment Check Box Object의 Check 값을 변경할 때 발생하는  event이다.<br>
     * 값을 변경하면 숨겨진 sheet에 변경된 값을 반영한다.<br>
     * 값을 check하면 Y uncheck하면 N으로 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    rf_flg_OnChange();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */  
    function gamt_flg_OnChange(){
        var sheetObj = sheetObjects[0]; 
        sheetObj.CellValue2(1,"gamt_flg") = document.form.gamt_flg.checked == true ? "Y" : "N";     
    }
    
    
    /**
    * Html Object의 값을 변경할 때 숨겨진 Sheet에 변경된 값을 반영한다.<br>
    * 숨겨진 sheet를 이용하여 값을 저장한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *   com_change_sheet( sheetObj, colNm );
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {string} colNm 필수 Html Object의 name
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  
    function com_change_sheet( sheetObj, colNm ){
        var eleValue = "";

        if(document.getElementById(colNm).type=="text"){
            switch(colNm){
                case "ctrt_eff_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;
                case "ctrt_exp_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "cre_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;
                case "file_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");
                    break;  
                case "n1st_cmnc_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;                  
                case "cust_seq":
                    if (document.getElementById(colNm).value != ""){
                    	eleValue = ComParseInt(document.getElementById(colNm).value);
                    }else{
                    	eleValue = document.getElementById(colNm).value;
                    }                	
                    break;
                case "real_cust_seq":
                    if (document.getElementById(colNm).value != ""){
                    	eleValue = ComParseInt(document.getElementById(colNm).value);
                    }else{
                    	eleValue = document.getElementById(colNm).value;
                    } 
                    break;
                default:
                    eleValue = document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.CellValue(1,colNm) = eleValue;     

        }else{
            sheetObj.CellValue(1,colNm) = document.getElementById(colNm).Code;          
        }
//        alert("colnm="+colNm+"  elevalue="+eleValue+"  cheeto="+sheetObj.CellValue(1, colNm)+" ibflag="+sheetObj.RowStatus(1))
    }
    
//    form  관련   (E)   -----

//    sheet  관련   (S)   -----

    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Amend Seq.가 0일 경우 Main Duration을 변경할 경우 Main의 Effective,Expire Date도 변경한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  
    function sheet1_OnChange(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
          
        switch(colName)
        {
            case "ctrt_eff_dt":
                if (sheetObj.CellValue(Row,"amdt_seq") == "0"){
                    sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");              
                }                
                break;                
            case "ctrt_exp_dt":
                if (sheetObj.CellValue(Row,"amdt_seq") == "0"){
                    sheetObj.CellValue2(Row, "exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
                }                   
                break;
        }
    }  

    /**
    * OnChange 이벤트 발생시 호출되는 function <br>
    * Scope Duration,Request Office,Scope을 변경할 경우 Validation 을 처리한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */  
    function sheet2_OnChange(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
          
        switch(colName)
        {
            case "ctrt_eff_dt":                
                var mnEffDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd","-");
                if (mnEffDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.CellValue2(Row,"ctrt_eff_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                    return;
                }
                if (mnEffDt > sheetObj.CellValue(Row,"ctrt_eff_dt")){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_eff_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_eff_dt");
                }else{
                    sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                    //Proposal 일 경우 적용
                    sheetObj.CellValue2(Row, "n1st_cmnc_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
                }
                
                break;
                
            case "ctrt_exp_dt":
                var mnExpDt = ComGetUnMaskedValue(formObj.ctrt_exp_dt.value,"ymd","-");
                if (mnExpDt == ""){
                    ComShowCodeMessage("PRI01030");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");   
                    return;
                }
                if (mnExpDt < sheetObj.CellValue(Row,"ctrt_exp_dt")){                       
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") ="";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");                     
                    return;                     
                }
                
                if (sheetObj.CellValue(Row, "ctrt_eff_dt") > sheetObj.CellValue(Row, "ctrt_exp_dt") ){
                    ComShowCodeMessage("PRI01024");
                    sheetObj.CellValue2(Row,"ctrt_exp_dt") = "";
                    sheetObj.SelectCell(Row,"ctrt_exp_dt");   
                    return;
                }
                sheetObj.CellValue2(Row, "exp_dt") = sheetObj.CellValue(Row, "ctrt_exp_dt");
                break;                  
            case "prop_scp_ofc_cd":
                                                
                var cd = sheetObj.CellValue(Row,"prop_scp_ofc_cd");
                formObj.f_cmd.value = COMMAND22;
                var sParam = "prop_no="+sheetObjects[0].CellValue(1,"prop_no") + "&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");
                sParam += "&" + FormQueryString(formObj)+"&cd="+cd;
                var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                var arrData = ComPriXml2Array(sXml, "cd|nm");
                if (arrData != null && arrData.length > 0) {
                    //sales Rep
                    setSheetRequestOfficeSaleRep(sheetObj, Row, cd);
                    
                }else{  
                    sheetObj.CellValue2(Row,"prop_scp_ofc_cd") = "";
                    sheetObj.CellComboItem(Row,"prop_scp_srep_cd", " ", " ");
                }                           

                break;
            case "svc_scp_cd":
            	//mySheet.GetComboInfo(Row, Col, Flag) 
            	sheetObj.CellValue2(Row, "scp_nm") = "";          	
            	
        	  //콤보코드와 텍스트를 가져온다.
        	  var sText = sheetObj.GetComboInfo(Row, "svc_scp_cd", "Text");
        	  //각각 배열로 구성한다.
        	   var arrText = sText.split("|");
        	   var idx   = sheetObj.GetComboInfo(Row, "svc_scp_cd", "SelectedIndex");
        	   if (idx == -1){
        		   sheetObj.CellValue2(Row, "scp_nm") = "";
        		   sheetObj.CellValue2(Row, "svc_scp_cd") = "";
        	   }else{
        		   sheetObj.CellValue2(Row, "scp_nm") = arrText[idx];
        	   }
            	
            	break;
            case "prop_scp_mqc_qty":
            	if (sheetObj.CellValue(Row,Col) < 0){
            		sheetObj.CellValue2(Row, Col) = 0;
            	}
            	break;
        }
    }   

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet1_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */ 	
    function sheet1_OnSearchEnd(sheetObj, errMsg){
         //저장시 duration을 scope과 비교하기 위하여 원본 duration을 가지고 있다.
//         var preIbflag = sheetObj.CellValue(1,"ibflag");
         var preIbflag = sheetObj.RowStatus(1);
    	 var formObj = document.form;
    	 
    	 /*
    	  *  숨겨진 기능인 super user 권한이 활성화 돼 있다면 
    	  *  이 사용자는 모든 권한을 갖는다.
    	  */
    	 if( IS_SUPER_USER ){
	         sheetObj.CellValue(1, "req_usr_flg") = "Y";
	         sheetObj.CellValue(1, "apro_usr_flg") = "Y";
	         sheetObj.CellValue(1, "all_usr_flg") = "Y";    	 
    	 }
    	 
    	 // 이전에 조회 됐을때 Approval Office가 combo에 추가되었을수 있기 때문에 지우고 다시 만든다. 
    	 comboObjects[1].RemoveAll();
    	 ComPriTextCode2ComboItem(appCdValue, appCdText, getComboObject(comboObjects, 'prop_apro_ofc_cd') ,"|","\t" );
    	 
        formObj.sc_no.value = sheetObj.CellValue(1,"sc_no");       
        formObj.prop_no.value = sheetObj.CellValue(1,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"), "ymd");
        formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_exp_dt"), "ymd");

        formObj.rf_flg.checked = sheetObj.CellValue(1,"rf_flg")=="Y"?true:false;
        formObj.gamt_flg.checked = sheetObj.CellValue(1,"gamt_flg")=="Y"?true:false;
        formObj.prop_sts.value = sheetObj.CellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value = sheetObj.CellValue(1,"prop_ofc_cd");
      
        comboObjects[0].Code2 = sheetObj.CellValue(1,"prop_srep_cd");   
        formObj.prop_srep_nm.value = sheetObj.CellValue(1,"prop_srep_nm");      
        comboObjects[1].Code2 = sheetObj.CellValue(1,"prop_apro_ofc_cd");       
        formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"cre_dt"),"ymd");

        formObj.file_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"file_dt"),"ymd");
        formObj.cust_cnt_cd.value = sheetObj.CellValue(1,"cust_cnt_cd");
        if (sheetObj.CellValue(1, "cust_seq") !="" ){
            formObj.cust_seq.value = ComLpad(sheetObj.CellValue(1,"cust_seq"), 6, "0");
        }else{
            formObj.cust_seq.value = "";
        }        
        formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"ctrt_pty_nm");
        comboObjects[2].Code2 = sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd");        
        formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1,"ctrt_cust_val_sgm");
        formObj.ctrt_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd");
        comboObjects[3].Code2 = sheetObj.CellValue(1,"ctrt_cust_srep_cd");      
        formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1,"ctrt_cust_srep_nm");
        formObj.real_cust_cnt_cd.value = sheetObj.CellValue(1,"real_cust_cnt_cd");
        if (sheetObj.CellValue(1, "real_cust_seq") !="" ){
            formObj.real_cust_seq.value = ComLpad(sheetObj.CellValue(1,"real_cust_seq"), 6, "0");
        }else{
            formObj.real_cust_seq.value = "";
        }
        
        formObj.real_cust_nm.value = sheetObj.CellValue(1,"real_cust_nm");
        comboObjects[4].Code2 = sheetObj.CellValue(1,"real_cust_tp_cd");                
        formObj.real_cust_val_sgm.value = sheetObj.CellValue(1,"real_cust_val_sgm");
        formObj.real_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"real_cust_sls_ofc_cd");
                
        //0017에서 Real Customer check
        sheetObj.CellValue(1,"ori_real_cust_cd") = sheetObj.CellValue(1,"real_cust_cnt_cd");
        sheetObj.CellValue(1,"ori_real_cust_seq") = sheetObj.CellValue(1,"real_cust_seq");

        comboObjects[5].Code2 = sheetObj.CellValue(1,"real_cust_srep_cd");
        formObj.real_cust_srep_nm.value = sheetObj.CellValue(1,"real_cust_srep_nm");        
        formObj.prop_mqc_qty.value = sheetObj.CellValue(1,"prop_mqc_qty");
        comboObjects[6].Code2 = sheetObj.CellValue(1,"cntr_lod_ut_cd");
        //OTI
        formObj.oti_no.value = sheetObj.CellValue(1, "oti_no");
        formObj.oti_lic_no.value = sheetObj.CellValue(1, "oti_lic_no");
        formObj.oti_eff_dt.value = sheetObj.CellValue(1, "oti_eff_dt");
        formObj.oti_exp_dt.value = sheetObj.CellValue(1, "oti_exp_dt");
        formObj.oti_amt.value = sheetObj.CellValue(1, "oti_amt");
        
        formObj.prop_apro_staff.value = sheetObj.CellValue(1, "prop_apro_staff");
        
        //sale lead ==> contract sales rep code setting 이후로 자리 옮김(sheet2_onSearchEnd)
//        setSaleLeadCombo(false);        
//        comboObjects[7].Code2 = sheetObj.CellValue(1,"sls_ld_no");
//        formObj.sale_lead_ori.value  = sheetObj.CellValue(1,"sls_ld_no");//조회후 값변경 확인하기위해(저장시 SC에서)

        //PRS
        formObj.prs_crnt_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_crnt_cm_amt"));        
        formObj.prs_estm_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_estm_cm_amt"));
        formObj.prs_sum_cm_amt.value = ComAddComma(parseInt(sheetObj.CellValue(1,"prs_crnt_cm_amt")) 
        							 + parseInt(sheetObj.CellValue(1,"prs_estm_cm_amt")));

        //lgcy_if_flg
        if (sheetObj.CellValue(1, "lgcy_if_flg")== "Y"){
        	document.images("img_lgcy").src = ICON_URL_EXIST;	
        }else{
        	document.images("img_lgcy").src = ICON_URL_NOT_EXIST;
        }        

        sheetObj.CellValue(1,"ctrt_eff_dt_ori") = sheetObj.CellValue(1,"ctrt_eff_dt");
        sheetObj.CellValue(1,"ctrt_exp_dt_ori") = sheetObj.CellValue(1,"ctrt_exp_dt");      
        
        //저장시 cust type cd가 변경되었는지 비교하기 위하여 원본을 가지고 있는다.
        sheetObj.CellValue(1, "cust_tp_ori") = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");        
        
        //prop_prpr_flg 는 항상 Y
        sheetObj.CellValue2(1, "prop_prpr_flg") = "Y";
        sheetObj.RowStatus(1) = preIbflag;
        setCancelText();
        formObj.conv_cfm_flg.checked = sheetObj.CellValue(1,"conv_cfm_flg")=="Y"?true:false;
                     
    }   
    
    

    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * MQC를 계산하기 위하여 추가한 컬럼에 값을 채워 넣는다.<br>
     * Scope에 새로 추가된 데이터의 색을 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet2_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */         
    function sheet2_OnSearchEnd(sheetObj, errMsg){
    	var sheetObj = sheetObjects[1];
        var sheetObj1 = sheetObjects[0];
        var formObj = document.form;

        for ( var i = 1; i <= sheetObj.RowCount; i++ ){
            sheetObj.CellValue2(i,"prop_scp_mqc_qty_ori") = sheetObj.CellValue(i,"prop_scp_mqc_qty");
            sheetObj.CellValue2(i,"sale_rep_cd") = sheetObj.CellValue(i,"prop_scp_srep_cd");           
            sheetObj.RowStatus(i) = "R";
        }
        
        //저장 , 조회시 기존에 선택된 Scope의 위치에 focus()를 이동한다.
        for (var i = 1; i <= getValidRowCount(sheetObj); i++){        	
        	if (saveSvcScpCd == sheetObj.CellValue(i, "svc_scp_cd")){
        		sheetObj.SelectCell(i, 1);
        		break;
        	}
        }
        
        //조회한 Sale Rep.이 combo 에 없다면  Sale Rep.을 입력한다.
        var cboObj = comboObjects[0];
        var srepCd = sheetObj1.CellValue(1,"prop_srep_cd");
        
        var ofcCd =  sheetObj1.CellValue(1,"ctrt_cust_sls_ofc_cd");
        
        if (srepCd !="" && cboObj.FindIndex(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.prop_srep_nm.value,srepCd);
        }
        //조회한 Approval Office가 combo 에 없다면 Approval Office를 입력한다.
        var cboObj = comboObjects[1];
        var aproOfcCd = sheetObj1.CellValue(1,"prop_apro_ofc_cd");
        if (aproOfcCd !="" && cboObj.FindIndex(aproOfcCd, 0) == -1 ){
        	cboObj.InsertItem(0,aproOfcCd + "| "  ,aproOfcCd);
        	cboObj.Code2 = aproOfcCd;
        }
        
        cboObj = comboObjects[3];
        srepCd = sheetObj1.CellValue(1,"ctrt_cust_srep_cd");
        if (srepCd !="" && cboObj.FindIndex(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.ctrt_cust_srep_nm.value,srepCd);
        }
        cboObj = comboObjects[5];
        srepCd = sheetObj1.CellValue(1,"real_cust_srep_cd");
        if (srepCd !="" && cboObj.FindIndex(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.real_cust_srep_nm.value,srepCd);
        }
        //첫줄 빈칸 추가
        comboObjects[3].InsertItem(0, " | | "," ");
        comboObjects[5].InsertItem(0, " | | "," ");        
        //sale rep
        //조회 후 IBMulti Combo에 값을 setting한다.
        comboObjects[0].Code2 = sheetObj1.CellValue(1,"prop_srep_cd");
        comboObjects[3].Code2 = sheetObj1.CellValue(1,"ctrt_cust_srep_cd"); 
        comboObjects[5].Code2 = sheetObj1.CellValue(1,"real_cust_srep_cd");
        
//Sales Lead Setting
        setSaleLeadCombo(false);        
        comboObjects[7].Code2 = sheetObj1.CellValue(1,"sls_ld_no");
        formObj.sale_lead_ori.value  = sheetObj1.CellValue(1,"sls_ld_no");//조회후 값변경 확인하기위해(저장시 SC에서)
        
        //font
        var amdt_seq = document.form.amdt_seq.value;                
        if(amdt_seq==0 || sheetObjects[0].CellValue(1, "lgcy_if_flg") =="Y" ){                        
            return;
        }
        for(var i = 1 ; i < sheetObj.Rows; i++){
            if(sheetObj.CellValue(i,"pre_ext_scp") == "N"){
                sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);          
            }
            // Svc Scope 별 Amendment Count 와 Accept Count 를 가져와 비교하여 색상 표시
            // Amendment Count = Accept Count : Blue
            // Amentment Count > Accept Count : Red 2015.03.13 송호진
            var amdt_cnt = sheetObj.CellValue ( i, "amdt_cnt" );
            var acpt_cnt = sheetObj.CellValue ( i, "acpt_cnt" );
            if( amdt_cnt > 0 ) {
            	if ( amdt_cnt == acpt_cnt ){
            		sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(0,0,255);
            	} else if ( amdt_cnt > acpt_cnt ) {
            		sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
            	}
            }
        }        
    }   

     /**
      * OnSelectCell 이벤트 발생시 호출되는 function <br>
      * 선택한 Scope에 해당하는 Terms의 데이터를 Frame에 Load 하고 Tab의 아이콘을 변경한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *		sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
      * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
      * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
      * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */  
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {   
    	  try{
    		  ComOpenWait(true); //->waiting->start
    		  if (saveSvcScpCd != "" && saveSvcScpCd != sheetObj.CellValue(NewRow, "svc_scp_cd")){
	    		  return;
	    	  }    	  
	          if (OldRow != NewRow) {
	        	  svcScpDeleteEnable();
	              changeSelectBackColor4Main(sheetObj);
	          }
    	  	  saveSvcScpCd = "";

    	  	  if(sheetObj.CellValue(NewRow,"svc_scp_cd")!=""&&OldRow!=NewRow&&sheetObj.CellValue(NewRow,"ibflag")!="I"){	    		  
	    		  //지정된 Scope만 IHC Tab을 활성화 한다.	    		  
		    		var ihcScope ="AEE, AEW, TAW, TAE, ASW, ASE"
		            if (ihcScope.indexOf(sheetObj.CellValue(NewRow,"svc_scp_cd")) != -1){
		            	ihcTabSts = true;
		            }else{
//		            	tabObjects[0].TabEnable(8) = false;
		            	ihcTabSts = false;
		            }
		    		
		        	comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow,"svc_scp_cd"));
		        	//0728
		    		if (tabObjects[0].SelectedIndex == 0) {
		    			tab1_OnChange(tabObjects[0], 0);
		    		} else {
		    			tabObjects[0].SelectedIndex = 0;
		    		}        	
		            loadTabPage(beforetab, NewRow);            
	          }else if(sheetObj.CellValue(NewRow,"ibflag")=="I"){            
	        	  if (NewRow != OldRow){
	              	clearAllTabPages();	
	              }        	
	          }
    	  	ComOpenWait(false); //->waiting->End
          } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e);
              }
          }finally{
        	  ComOpenWait(false); //->waiting->End
        	  //ComOpenWait 후에 활성화 한다.

//              tabObjects[0].TabEnable(8) = ihcTabSts;//IHC Tab 
        	  if (ihcTabSts){
        		  tabObjects[0].TabBackColor(8) = TAB_TRUE_COLOR
        	  }else{
        		  tabObjects[0].TabBackColor(8) = TAB_FALSE_COLOR 
        	  }
          }

    	  
    }

    /**
    * OnPopupClick 이벤트 발생시 호출되는 function <br>
    * Scope Duration,Scope MQC, G/L Copy 를 호출한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj 필수 IBSheet Object
    * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
    * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */      
    function sheet2_OnPopupClick(sheetObj, Row, Col)
    {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
          
        switch(colName)
        {
            case "scp_dur_pop":

                var sPropNo = sheetObjects[0].CellValue(1,"prop_no");
                var sAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObjects[0].CellValue(1, "pre_amdt_seq"); 
                var sPropStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
                var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
                var sSc_No = sheetObjects[0].CellValue(1,"sc_no");
                var sPreExpDt = sheetObj.CellValue(Row, "pre_exp_dt");
               
                var sIsReqUsr = sheetObjects[0].CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObjects[0].CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(Row, "dur_dup_flg");                
                var sLgcyIfFlg = sheetObjects[0].CellValue(1, "lgcy_if_flg");
                var sParam = "sSc_No="+sSc_No+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+ "&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+ "&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg
                			+ "&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sLgcyIfFlg="+sLgcyIfFlg;
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0019.do?"+sParam, "", 640, 315, true);                 
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
                }                   

                break;
                
            case "prop_scp_mqc_pop":
                var sPropNo = sheetObjects[0].CellValue(1,"prop_no");
                var sAmdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
                var sPreAmdtSeq = sheetObjects[0].CellValue(1, "pre_amdt_seq"); 
                var sPropStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
                var sSvcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
                var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
                var sPreExpDt = sheetObj.CellValue(Row, "pre_exp_dt");
                
                var sIsReqUsr = sheetObjects[0].CellValue(1, "req_usr_flg") == "Y" ? true: false;
                var sIsAproUsr = sheetObjects[0].CellValue(1, "apro_usr_flg") == "Y" ? true: false;
                var sDurDupFlg = sheetObj.CellValue(Row, "dur_dup_flg");  
                var sLgcyIfFlg = sheetObjects[0].CellValue(1, "lgcy_if_flg");
                var sParam = "sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                			+"&sPropStsCd="+sPropStsCd+"&sSvcScpCd="+sSvcScpCd+"&sSrepCd="+sSrepCd
                			+"&sPreExpDt="+sPreExpDt+"&sDurDupFlg="+sDurDupFlg
                			+ "&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&sLgcyIfFlg="+sLgcyIfFlg;
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0020.do?"+sParam, "", 650, 330, true);
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
                }   

                break;
                
            case "gline_cp_flg_lnk":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }  

                var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq")+"&sc_no="+sheetObjects[0].CellValue(1, "sc_no")
                            +"&svc_scp_cd="+sheetObjects[1].CellValue(Row, "svc_scp_cd")+"&prc_cust_tp_cd="+getComboObject(comboObjects, "prc_ctrt_cust_tp_cd").Code
                            +"&eff_dt="+sheetObjects[1].CellValue(Row, "ctrt_eff_dt")+"&exp_dt="+sheetObjects[1].CellValue(Row, "ctrt_exp_dt");

                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0018.do?"+sParam, "", 522, 310, true);                 
                if (rtnVal != null && rtnVal =="OK"){
                    clearAllTabPages();
                    // 하부 terms조회
                	comApplyStyleProposalStatusSummary(sheetObjects[1].CellValue(Row,"svc_scp_cd"));
            		if (tabObjects[0].SelectedIndex == 0) {
            			tab1_OnChange(tabObjects[0], 0);
            		} else {
            			tabObjects[0].SelectedIndex = 0;
            		}        	
                    loadTabPage(beforetab);                  	
                	
                }
                break;                  
            case "quick_accept":
        		var formObj = document.form;
        	    
        		if (formObj.prop_no.value ==""){
        	        ComShowCodeMessage('PRI01021');
        	        return;
        	    }
        		
        		if(ComShowCodeConfirm("PRI01137")) {
        			ComOpenWait(true);          	
        			formObj.f_cmd.value = MULTI09;
        			var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq")+"&sc_no="+sheetObjects[0].CellValue(1, "sc_no")
        					   + "&svc_scp_cd="+sheetObjects[1].CellValue(Row, "svc_scp_cd")+ "&prop_sts_cd="+sheetObjects[0].CellValue(1, "prop_sts_cd");
        		    sParam += "&"+ FormQueryString(formObj);            
        		    
        		    var saveXml= sheetObjects[1].GetSaveXml("ESM_PRI_0003GS.do", sParam);
        		    if(ComGetEtcData(saveXml,"cnt") == "0"){
						ComShowCodeMessage("PRI00329");
						ComOpenWait(false); //->waiting->End
						return;
					}
        		    
        		    clearAllTabPages();
        		    loadTabPage(tabObjects[0].SelectedIndex, Row);
        		    comUpdateProposalStatusSummary("41", sheetObjects[1].CellValue(Row, "svc_scp_cd"));
					ComShowCodeMessage("PRI00108");
        		    ComOpenWait(false); //->waiting->End
        		}
            	break;
        }
    }           
    
//--> jin add (S)
	

    /**
    * MQC값으로 MVC 값을 계산한다.<br>
    * 계산식은 MVC = MQC / Duration 유효 일수 x 7 이다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		calcMVC();
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */  
    function calcMVC(){
        var formObj = document.form;
        var mqcQty = sheetObjects[0].CellValue(1, "prop_mqc_qty");

        var sDay = formObj.ctrt_eff_dt.value;
        var eDay = formObj.ctrt_exp_dt.value;
        var mvcQty = 0;     
        var durDay = ComGetDaysBetween(sDay, eDay);        
        if (mqcQty != "" && mqcQty != "0"){            
            if (durDay !=0){
            	mvcQty = ComRound((mqcQty / durDay * 7),0);
            }
        }   
        formObj.prop_mvc.value = mvcQty;
        formObj.prop_mvc_tp.value = comboObjects[6].Text;      //MQC의 것을 그대로  
    }   



   /**
    * Scope삭제 시 Scope에 속해 있는 각 Terms에 데이터가 있는지 조회하여<br>
    * 결과 값을 return한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		checkScopeDelete(Row)
    * </pre>
    * @param  {int}    Row 필수 선택한 Scope의 Row Index 
    * @return {string} <br>
    *                   Y : 삭제 불가능
    *                   N : 삭제가능
    * @author 공백진
    * @version 2009.05.07
    */  
    function checkScopeDelete(Row){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var scpCd = sheetObj1.CellValue(Row, "svc_scp_cd");
        var rValue = "N";// 데이터 있음      (삭제불가능)             
        formObj.f_cmd.value = SEARCH09;
        
        var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj)+"&svc_scp_cd="+scpCd;
        
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do" , sParam);
                
        var arrData = ComPriXml2Array(sXml, "delcnt");
        if (arrData !=null && arrData.length > 0){
            if (arrData[0] == 0){
                rValue = "Y";
            }
        }
        return rValue;
    }
    


    /**
     * Terms의 상태 데이터가 변경된 이후 해당 Scope Main의 상태,버튼의 활성,비활성을 변경한다.<br>
     * Terms의 상태가 모두 Accept일 경우 Scope의 상태를 Accept로 변경, Approve버튼을 활성화하고<br> 
     * Counter Offer 버튼을 비활성화 한다.<br>
     * Terms의 상태가 Accept에서 하나라도 Init으로 변경 되었다면 Scope의 상태를 Init로 변경하고 <br>
     * Approve 버튼 비활성,Counter Offer 버튼을 활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		scopeStatusChange(scpCd);
     * </pre>
     * @param  {string}  scpCd 필수 Scope 코드
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */      
    function scopeStatusChange(scpCd){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];      
        var aproUsrFlg = sheetObj.CellValue(1, "apro_usr_flg")
        var sts = sheetObjects[0].CellValue(1, "prop_sts_cd");
                
        formObj.f_cmd.value = SEARCH08;     
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no") +"&amdt_seq="+sheetObj.CellValue(1,"amdt_seq");
        sParam += "&svc_scp_cd=" + scpCd + "&" + FormQueryString(formObj);
        var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
    
        var arrData = ComPriXml2Array(sXml, "prop_scp_sts_cd","");
        if (arrData !=null && arrData.length > 0){  

            // svc_scp_cd를 change 한다.            
            for (var i = 1; i <= sheetObj1.RowCount; i++ ){
                if (sheetObj1.CellValue(i, "svc_scp_cd") == scpCd ){
                    var flag = sheetObj1.RowStatus(i);
                	sheetObj1.CellValue(i, "prop_scp_sts_cd") = arrData[0];
                	sheetObj1.RowStatus(i) = flag;
                    break;
                }
            }    
        	if (arrData[0] == "A"){       
                // 모두 accept가 되었는지 확인
                if (checkAccept() == "Y"){
                    if(aproUsrFlg == "Y"){            
                        ComBtnEnable("btn_approve"); //(terms가 all accept 경우)-클릭시 check 
                        ComBtnDisable("btn_coffer");
                    }             
                }else{          
                    ComBtnDisable("btn_approve"); //(terms가 all accept 경우)-클릭시 check
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }       
                }           
            }else if (arrData[0] =="I") {    
                if (sheetObj.CellValue(1,"prop_sts_cd") == "Q" || aproUsrFlg=="Y" ){      
                    ComBtnDisable("btn_approve");   
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }
                }
            }
        }
    }
    
    /**
     * Approve시 Dem/Det이 입력되어 있는지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkDmdtData();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Approve할 수 있다.<br>
     *          N : Approve할 수 없다.<br>
     * @author 공백진
     * @version 2009.05.07
     */  
    function checkDmdtData(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "N";                          
        formObj.f_cmd.value = SEARCH10;
        
        try{
            var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
            sParam += "&" + FormQueryString(formObj);            
            var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);            
            var arrData = ComPriXml2Array(sXml, "etc1|etc2");
            if (arrData != null && arrData.length > 0) {
                if (arrData[0][0] == "1" ){
                	rValue = "Y";	
                }  
            }        	
        	if (rValue == "N"){
        		var valText = "";
        		var valText1 = "";
        		var valText2 = "";
        		var valCheck = true;
        		var arrText = arrData[0][1].split("/");
        		for(i=0 ; i<arrText.length ; i++){
        			var arrText2 = arrText[i].split("|");
        			for(j=1 ; j<arrText2.length ; j++){
	        			if(arrText2[0] != 3){
	        				valText1 = valText1 + arrText2[j] + "\n";
	        			}else{
	        				valText2 = valText2 + arrText2[j];
	        			}
        			}
        		}
        		if(valText1 != ""){
        			valText1 = ComGetMsg("PRI01122", valText1);
        		}
        		if(valText2 != ""){
        			valText2 = ComGetMsg("PRI01139", valText2);
        		}
        		if(valText1 != "" && valText2 != ""){
        			valText = valText1 + "\n" + valText2;
        		}else{
        			valText = valText1 + valText2;
        		}
        		ComShowMessage(valText);
        	}
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        	rValue = "N";
        }finally{
        	return rValue;
        }       
                
    }     
    
    /**
     * Approve시 CHSS Exception이 입력되어 있는지 확인한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkChassisData();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Approve할 수 있다.<br>
     *          N : Approve할 수 없다.<br>
     * @author 전윤주
     * @version 2009.05.07
     */  
    function checkChassisData(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "N";                          
        formObj.f_cmd.value = SEARCH22;
        
        try{
            var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
            sParam += "&" + FormQueryString(formObj);            
            var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);            
            var arrData = ComPriXml2Array(sXml, "etc1|etc2");
            if (arrData != null && arrData.length > 0) {
                if (arrData[0][0] == "1" ){// 미승인 CHSS Exception이 없으면 1임 (CHSS Exception이 다 승인 되어 있으면)
                	rValue = "Y";	
                }  
            }        	
        	if (rValue == "N"){
        		var valText = "";
        		var valText1 = "";
        		var valText2 = "";
        		var valCheck = true;
        		var arrText = arrData[0][1].split("/");
        		for(i=0 ; i<arrText.length ; i++){
        			var arrText2 = arrText[i].split("|");
        			for(j=1 ; j<arrText2.length ; j++){
	        			if(arrText2[0] != 3){
	        				valText1 = valText1 + arrText2[j] + "\n";
	        			}else{
	        				valText2 = valText2 + arrText2[j];
	        			}
        			}
        		}
        		if(valText1 != ""){
        			valText1 = ComGetMsg("PRI01148", valText1);
        		}
        		if(valText2 != ""){
        			valText2 = ComGetMsg("PRI01149", valText2); 
        		}
        		if(valText1 != "" && valText2 != ""){
        			valText = valText1 + "\n" + valText2;
        		}else{
        			valText = valText1 + valText2;
        		}
        		ComShowMessage(valText);
        	}
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        	rValue = "N";
        }finally{
        	return rValue;
        }       
                
    } 
        

    /**
     * Terms가 모두 Accept 되었는지 확인한다.<br>
     * Approve 버튼 활성화와 Approve시 확인한다.<br> 
     * <br><b>Example :</b>
     * <pre>
     *		checkAccept();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : 모두 Accept되었다.<br>
     *          N : 하나이상 Accept 안된 데이터가 있다.<br>
     * @author 공백진
     * @version 2009.05.07
     */      
    function checkAccept(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "Y";// 모두 accept 되었다.                              
        formObj.f_cmd.value = SEARCH05;
        var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj);
                
        var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
        var arrData = ComPriXml2ComboString(sXml, "prop_no","prop_no");
        if (arrData !=null && arrData.length > 0){
            rValue ="N";
        }
        return rValue;
        
    }

    /**
    * 모든 terms가 accept or return 상태 인지 조회한다.<br>
    * return 값이 N 일 경우 Count Offer 할 수 없다.<br> 
    * <br><b>Example :</b>
    * <pre>
    *		checkCountOffer();
    * </pre>
    * @param  없음
    * @return {string} <br>
    *          Y : 모두 Accept이거나 Returned이다.<br>
    *          N : 하나이상 Init  데이터가 있다.<br>
    * @author 공백진
    * @version 2009.05.07
    */      
    function checkCountOffer(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "N";// C/Offer를 할 수 없다.
        formObj.f_cmd.value = SEARCH06;
        var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj);
        var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
        var arrData = ComPriXml2ComboString(sXml, "status","cnt");        
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue ="Y"
            }
        }
        return rValue;        
    }
    
 
    
    /**
     * Customer Type이 변경되었다면 메세지를 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkCustomerType();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Customer Type 변경 됨.<br>
     *          N : Customer Type 변경 안됨.<br>
     * @author 공백진
     * @version 2009.05.07
     */ 
    function checkCustomerType(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var rValue = "N";
        //sheetObj.CellValue(1, "cust_tp_ori") = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");
        var custTpOri = sheetObj.CellValue(1, "cust_tp_ori");
        
        var custSeq = ComParseInt(sheetObj.CellValue(1, "cust_seq"));
        var custCntCd = sheetObj.CellValue(1, "cust_cnt_cd")
       
        if (custTpOri != sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd") 
        		&& formObj.prop_no.value != "" && custTpOri !=""
        		&& custSeq == ComParseInt(formObj.cust_seq.value)
        		&& custCntCd == formObj.cust_cnt_cd.value){        	
        	rValue = "Y";
        }
        return rValue;
     
    }        
    
     
     /**
      * Init Cancel시 Dem/Det 데이터가 있는지 조회하여 데이터가 있다면 Init Cancel 할 수 없다.<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkDemDetCancel();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : Init Cancel 가능<br>
      *          N : Init Cancel 불가능.<br>
      * @author 공백진
      * @version 2009.05.07
      */ 
     function checkDemDetCancel(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH18;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] == 0){
            	 rValue ="Y";
             }
         }
         return rValue;  
      
     }
     
     /**
      * Init Cancel시 CHSS Exception 데이터가 있는지 조회하여 데이터가 있다면 Init Cancel 할 수 없다. [CHM-201327107]<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkChassisCancel();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : Init Cancel 가능<br>
      *          N : Init Cancel 불가능.<br>
      * @author 전윤주
      * @version 2013.10.21
      */ 
     function checkChassisCancel(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH21;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] == 0){
            	 rValue ="Y";
             }
         }
         return rValue;       
     }  
     
     
     /** 1번 회차 이상에서 Amend Init Cancel시 CHSS Exception 데이터가 있는지 조회하여 데이터가 있다면 Init Cancel 할 수 없다. [CHM-201327107]<br>
      * <br><b>Example :</b>
      * <pre>
      *		checkEffDtChassisCancel();
      * </pre>
      * @param  없음
      * @return {string} <br>
      *          Y : Init Cancel 가능<br>
      *          N : Init Cancel 불가능.<br>
      * @author 전윤주
      * @version 2013.11.14
      */ 
     function checkEffDtChassisCancel(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "N";
         formObj.f_cmd.value = SEARCH23;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 if (arrData[0][0] == 0){
            	 rValue ="Y";
             }
         }
         return rValue;       
     }  
     
     /**
      * Request시 affiliate type code 가 MIX가 되어 있는지 확인한다.<br>
      * @param  없음
      * @return {string} <br>
      *          MIXED : 서로 다른 타입이 존재<br>
      *          BCO, NBCO : TYPE 코드.<br>
      * @author 최성환
      * @version 2015.05.15
      */ 
     function checkAffilTypeDup(){
         var formObj = document.form;
         var sheetObj = sheetObjects[0];
         var rValue = "";
         formObj.f_cmd.value = SEARCH25;
         var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
         sParam += "&" + FormQueryString(formObj);
         
         var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
         var arrData = ComPriXml2Array(sXml, "etc1");         
         if (arrData !=null && arrData.length > 0){
        	 rValue = arrData[0][0];
         }
         return rValue;  
      
     }          
     
     /**
      * Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *         checkRequest    
      * </pre>
      * @return 없음
      * @author 공백진 
      * @version 2009.04.17
      */    
      function checkRequest(){
          document.form.f_cmd.value = SEARCH07;
          var rMsg = "";
          var msgParam = "";
          var rValue = "N"; //Request 금지 
          var sheetObj = sheetObjects[0];
          var formObj = document.form;

          var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          
          var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", sParam);
          var arrData = ComPriXml2Array(sXml, "terms|cnt|note");
          //checkType에 따라 메세지가 틀려진다.
          var checkType = 0;
          if (arrData != null && arrData.length > 0) {
              for (var i = 0; i < arrData.length; i++){
            	  if (arrData[i][0] == "DEMDET"){
                	  	checkType = 1;
                	// S/C: Y , DEM/DET : N
	                	if (arrData[i][1] == "1"){ //DEM/DET생성해야함
	                  		rValue = "N";
	                  		rMsg = "PRI01120";
	                  		break;
	                  	}else if (arrData[i][1] == "2"){ //S/C: N , DEM/DET : Y
	                  		rValue = "N";
	                  		rMsg = "PRI01121"; 
	                  		break;
	                  	}else if (arrData[i][1] == "3"){
	                  		rValue = "Y";
	                  	}
            	  }else if (arrData[i][0] == "CHSS") {//CHSS Exception 체크 
            		   checkType = 6;
                  	    // S/C: Y , CHSS : N
  	                	if (arrData[i][1] == "1"){ //S/C 에는 등록했는데 CHSS가 없을 때: CHSS Exeption을 생성해야함
  	                  		rValue = "N"; 
  	                  		rMsg = "PRI01150";
  	                  		break;
  	                  	}else if (arrData[i][1] == "2"){ //S/C: N , CHSS: Y CHSS Exception만 있을 때: S/C note를 등록해야 함
  	                  		rValue = "N"; 
  	                  		rMsg = "PRI01151"; 
  	                  		break;
  	                  	}else if (arrData[i][1] == "3"){
  	                  		rValue = "Y";
  	                  	}
            	  }else if (arrData[i][0] == "CALC_CHK") {// Rate Calculate check, 따로조회하여 SC에서 합침
            		  /* 2017.02.23  Calculate Button Click을 필수에서 Option으로 변경함  (송민석)
            		  checkType = 4;
            		  if (arrData[i][1] == "0"){
            			  rValue ="Y";
            		  }else{
            			  rValue ="N";
            			  msgParam = arrData[i][2];
            			  break;
            		  }
            		  */
            	  }else if (arrData[i][0] == "CTRT_CHK"){// CTRT PTY Please Input 이 있는지 CHECK
            		  checkType = 5;
            		  if (arrData[i][1] == "0"){
            			  rValue = "Y";
            		  }else{
            			  rValue = "N";
            			  break;
            		  }            	  
                  }else if (arrData[i][0] == "DIFF_CUST_TP_CHK"){// CTRT PTY Please Input 이 있는지 CHECK
            		  checkType = 7;
            		  rValue = "N";
            		  rMsg=arrData[i][2];
           			  break;
                  }else if (arrData[i][0] == "VALID_AFIL_CHK"){// Customer Type 이 Shipper's Association 일 경우 Actual Customer 의 Affiliate 등록 여부 체크
            		  checkType = 8;
            		  rValue = "N";
            		  var afil=arrData[i][2].split("|");
            		  rMsg=afil[0] + " Service scope, " + afil[1] + " Acutal Customer Code is not valid Affiliate";
           			  break;
                  }else{// 필수입력 체크
                      checkType = 2;
                  	if (arrData[i][1] != "0"){
                          rValue = "Y";
                    }else{                                   	
                      	rMsg += " "+arrData[i][0]+" " 
                        rValue = "N";
                      	if (arrData[i][0] == "AMEND"){
                      		checkType = 3;
                      	}
                        break;
                     }
                  }
              }
              
              if (rValue =="N" && checkType == 2){
                  ComShowCodeMessage("PRI01042",rMsg);
              }else if (rValue == "N" && checkType == 3){
            	  ComShowCodeMessage("PRI01105");
              }else if (rValue == "N" && checkType == 1){
            	  ComShowCodeMessage(rMsg); 
              }else if (rValue == "N" && checkType == 6){ //CHSS Exeption 체크
            	  ComShowCodeMessage(rMsg); 
              }else if (rValue =="N" && checkType == 4){
            	  ComShowCodeMessage("PRI03030", msgParam,"Request");
              }else if (rValue =="N" && checkType == 5){
            	  ComShowCodeMessage("PRI01128");
              }else if (rValue =="N" && checkType == 7){ // Standard Note 의 Copy 된 Guideline 의 Customer Type 과 계약의 Customer Type 불일치 
            	  ComShowCodeMessage("PRI01159",rMsg );
              }else if (rValue =="N" && checkType == 8){ // Standard Note 의 Copy 된 Guideline 의 Customer Type 과 계약의 Customer Type 불일치 
            	  ComShowMessage(rMsg );
              }
          }else{
          	ComShowMessage(OBJECT_ERROR);
          }
          return rValue;
       }      
      
  /**
   * Request Cancel시 해당 데이터중 Accept,Returned인 데이터가 있는지 조회하여<br>
   * 한건이라도 데이터가 있다면 Request Cancel을 금지한다.<br>
   * <br><b>Example :</b>
   * <pre>
   *		checkRequestCancel();
   * </pre>
   * @param  없음
   * @return {string} <br>
   *          Y : Request Cancel할 수 있다.<br>
   *          N : Request Cancel할 수 없다.<br>
   * @author 공백진
   * @version 2009.05.07
   */  
  function checkRequestCancel(){
      var formObj = document.form;
      var sheetObj = sheetObjects[0];
      var rValue = "N";                          
      formObj.f_cmd.value = SEARCH20;
      
      try{
          var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);            
          var arrData = ComPriXml2Array(sXml, "cnt");
          if (arrData != null && arrData.length > 0) {
        	  if (arrData[0][0] == "0" ){
        		  rValue = "Y";	
              }  
          }        	
      	  if (rValue == "N"){
      		  ComShowCodeMessage("PRI01129");
      	  }
      } catch (e) {
		  	if (e == "[object Error]") {
		          ComShowMessage(OBJECT_ERROR);
		      } else {
		          ComShowMessage(e);
		      }
		  	rValue = "N";
      }finally{
    	  return rValue;
      }       
              
  }             

/**
 * Terms가 summary 정보를 변경 후 메인의 status를 조회한다.<br>
 * Main의 Status가 Returned 일 경우 모든 Terms가 Accept되었다면 Status를 Request로 변경한다.<br>
 * <br><b>Example :</b>
 * <pre>
 *		changeMainStatus();
 * </pre>
 * @param  없음
 * @author 공백진
 * @version 2009.05.07
 */      
function changeMainStatus(){
    var formObj = document.form;
    var sheetObj = sheetObjects[0];                         
    formObj.f_cmd.value = SEARCH19;
    var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");    
    sParam += "&f_cmd="+SEARCH19;
    var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
    var arrData = ComPriXml2Array(sXml, "prop_sts_cd|prop_sts");
    if (arrData !=null && arrData.length > 0){
    	if (arrData[0][0] == "Q"){
          sheetObj.CellValue2(1,"prop_sts_cd") = arrData[0][0];
          formObj.prop_sts.value = arrData[0][1];
          sheetObj.CellValue2(1,"prop_sts") = arrData[0][1];
    	}
    }    
}

    

    /**
     * Sale Lead를 조회하여 IBMulti Combo에 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		setSaleLeadCombo(firstSw);
     * </pre>
     * @param  {bool} firstSw 필수 화면 로드 후 처음 조회시 true, 이후에는 false
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */     
    function setSaleLeadCombo(firstSw){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];

        if (firstSw == true){//처음조회
        	formObj.f_cmd.value = SEARCH11;	
        }else{//sls_ld_no main에 저장후 조회
        	formObj.f_cmd.value = SEARCH12;
        }
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
        sParam += "&" + FormQueryString(formObj);

        sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do", sParam);

        ComPriXml2ComboItem(sXml, formObj.sls_ld_no, "sls_ld_no", "sls_ld_no|sls_ld_nm");   
    }    

     

 /**
  * 입력한 Customer Sale Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다.<br>
  * <br><b>Example :</b>
  * <pre>
  *		setCustSaleRep();
  * </pre>
  * @param  없음
  * @return 없음
  * @author 공백진
  * @version 2009.05.07
  */       
    function setCustSaleRep(){              
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (formObj.cust_cnt_cd.value !="" && formObj.cust_seq.value !=""){         
			formObj.f_cmd.value = SEARCHLIST;
		    sParam = FormQueryString(formObj) +"&etc1="+formObj.ctrt_cust_sls_ofc_cd.value
		    	+"&etc2="+formObj.cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.cust_seq.value);
		    sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
		    
		    ComPriXml2ComboItem(sXml, formObj.ctrt_cust_srep_cd, "cd", "cd|nm|etc1");
	        //첫줄 빈칸 추가
	        comboObjects[3].InsertItem(0, " | | "," ");
	        
		}
    }
    
  /**
   * 입력한 Real Customer Sale Office 에 따른 Sales Rep을 조회하여 <br>
   * IBMulti Combo에 Setting한다.<br>
   * <br><b>Example :</b>
   * <pre>
   *		setRealCustSaleRep();
   * </pre>
   * @param  없음
   * @return 없음
   * @author 공백진
   * @version 2009.05.07
   */
    function setRealCustSaleRep(){
		  var formObj = document.form;
		  var sheetObj = sheetObjects[0];
		  if (formObj.real_cust_cnt_cd.value !="" && formObj.real_cust_seq.value !=""){
		      formObj.f_cmd.value = SEARCHLIST;            
		      sParam = FormQueryString(formObj) +"&etc1="+formObj.real_cust_sls_ofc_cd.value
		      +"&etc2="+formObj.real_cust_cnt_cd.value+"&etc3="+ ComParseInt(formObj.real_cust_seq.value);
		      sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
		      ComPriXml2ComboItem(sXml, formObj.real_cust_srep_cd, "cd", "cd|nm|etc1");    
		      
		        //첫줄 빈칸 추가		        
		        comboObjects[5].InsertItem(0, " | | "," ");
		  }
    }     
        
    /**
     * 입력한 Office 에 따른 Sales Rep을 조회하여 IBMulti Combo에 Setting한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		setRequestOfficeSaleRep();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */         
    function setRequestOfficeSaleRep(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        formObj.f_cmd.value = SEARCH15;     
        var sParam = FormQueryString(formObj) +"&etc1="+formObj.prop_ofc_cd.value;
        var sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
        ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm|etc2");  
        formObj.prop_srep_nm.value = "";
    }
    

    /**
     * Scope의 Request Office 에 따른 Sales Rep을 조회하여 sheet Combo에 Setting한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		setSheetRequestOfficeSaleRep(sheetObj, Row, offCd);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int}     Row      필수 선택한 Row Index
     * @param {string}  offCd    필수 Scope의 Request Office code
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */           
    function setSheetRequestOfficeSaleRep(sheetObj, Row, offCd){
        var formObj = document.form;        
        formObj.f_cmd.value = SEARCH15;        
        var sParam = FormQueryString(formObj) +"&etc1="+ offCd;        
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do",sParam);    
        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
        if (arrData !=null && arrData.length > 0){
            var arrCode = arrData[0].split("|");
            var arrText = arrData[1].split("|");        
            var aText = "";
            if (arrCode != null && arrCode.length > 0){         
                for (var i = 0; i < arrCode.length; i++){
                    aText += arrCode[i]+"\t"+arrText[i]+"|";
                }
            }
            sheetObj.CellComboItem(Row,"prop_scp_srep_cd",aText,arrData[0],0);
        }else{
        	sheetObj.CellComboItem(Row,"prop_scp_srep_cd", " ", " ");
        }
    }   
    
    /**
    * SaleRep.의 Office Code를 조회한다.(업무요건 변경하면서 사용안함 추후 확인 후 삭제)<br>
    * <br><b>Example :</b>
    * <pre>
    *		getOfficeCd(srepCd);
    * </pre>
    * @param  {string} srepCd 필수 sale rep. code
    * @return  string  Office Code
    * @author 공백진
    * @version 2009.05.07
    */      
    function getOfficeCd(srepCd){       
        document.form.f_cmd.value = COMMAND21;
        var sParam = FormQueryString(document.form)+"&etc1="+srepCd;
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", sParam);
        var arrData = ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            return arrData[0];
        }                                   
        return null;
    }
    
    /**
    * Customer에 관련된 Html Object의 값을 clear 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		clearCustName();
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */     
    function clearCustName(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        
        sheetObj.CellValue(1, "cust_cnt_cd") = "";
        sheetObj.CellValue(1, "cust_seq") = "";
        
        sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd") = "";
        sheetObj.CellValue(1,"ctrt_pty_nm") = "";
        sheetObj.CellValue(1,"ctrt_pty_addr") = "";
        sheetObj.CellValue(1,"ctrt_cust_val_sgm_cd") = "";
        sheetObj.CellValue(1,"ctrt_cust_val_sgm") = "";
        sheetObj.CellValue(1,"ctrt_cust_srep_cd") = "";
        sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd") = "";
        sheetObj.CellValue(1,"ctrt_pty_sgn_nm") = "";   //arrText[0][6];
        sheetObj.CellValue(1,"ctrt_pty_sgn_tit_nm") = "";   //arrText[0][7];
        
        sheetObj.CellValue(1,"oti_no") = "";
        sheetObj.CellValue(1,"oti_lic_no") = "";
        sheetObj.CellValue(1,"oti_eff_dt") = "";
        sheetObj.CellValue(1,"oti_exp_dt") = "";
        sheetObj.CellValue(1,"oti_amt") = "";       
        
        formObj.cust_cnt_cd.value = "";
        formObj.cust_seq.value = "";
        formObj.ctrt_pty_nm.value = "";
        comboObjects[2].Code = "";
        formObj.ctrt_cust_val_sgm.value = "";
        formObj.ctrt_cust_sls_ofc_cd.value = "";
        formObj.ctrt_cust_srep_nm.value = "";
        comboObjects[3].Code = "";
        formObj.oti_no.value = "";
        formObj.oti_lic_no.value ="";
        
    }
    
    /**
    * Customer에 관련된 정보를 조회한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		custNameFind(eleName);
    * </pre>
    * @param  {string} eleName 필수 Html Object Name
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */      
    function custNameFind(eleName){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var cust_cnt_cd = formObj.cust_cnt_cd.value;        
        var cust_seq = formObj.cust_seq.value;
        var propOfcCd = formObj.prop_ofc_cd.value;
        
        if(cust_cnt_cd != "" && cust_seq !=""){
            var sParam = "f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq+"&prop_ofc_cd="+propOfcCd;        
            var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do", sParam);
            var saveName = "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|"
            	+"ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|oti_no|"
            	+"oti_eff_dt|oti_exp_dt|oti_amt|oti_lic_no|ctrt_cust_srep_nm"

            	var arrText = ComPriXml2Array(sXml, saveName);
            if(arrText==undefined){
                clearCustName();
                formObj.cust_cnt_cd.focus();
            }else{
//                comboObjects[2]2.Code = "";              
                comboObjects[3].Code2 = "";              
                sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd") = arrText[0][0];
                sheetObj.CellValue(1,"ctrt_pty_nm") = arrText[0][1];
                sheetObj.CellValue(1,"ctrt_pty_addr") = arrText[0][2];
                sheetObj.CellValue(1,"ctrt_cust_val_sgm_cd") = arrText[0][3];
                sheetObj.CellValue(1,"ctrt_cust_val_sgm") = arrText[0][4];
                sheetObj.CellValue(1,"ctrt_cust_srep_cd") = arrText[0][5];
                
                sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd") = arrText[0][6];
                
                sheetObj.CellValue(1,"ctrt_pty_sgn_nm") = arrText[0][7];
                sheetObj.CellValue(1,"ctrt_pty_sgn_tit_nm") = arrText[0][8];
                sheetObj.CellValue(1,"oti_no") = arrText[0][9];  //arrText[0][7];
                sheetObj.CellValue(1,"oti_eff_dt") = arrText[0][10];
                sheetObj.CellValue(1,"oti_exp_dt") = arrText[0][11];
                sheetObj.CellValue(1,"oti_amt") = arrText[0][12];
                sheetObj.CellValue(1,"oti_lic_no") = arrText[0][13];
                formObj.ctrt_pty_nm.value = arrText[0][1];
                comboObjects[2].Code2 = arrText[0][0];
                formObj.ctrt_cust_val_sgm.value = arrText[0][4];
                formObj.ctrt_cust_sls_ofc_cd.value = arrText[0][6];
                comboObjects[3].Code2 = arrText[0][5];
                formObj.ctrt_cust_srep_nm.value = arrText[0][14];
                formObj.oti_no.value = arrText[0][9];
                formObj.oti_eff_dt.value = arrText[0][10];
                formObj.oti_exp_dt.value = arrText[0][11];
                formObj.oti_amt.value = arrText[0][12];  
                formObj.oti_lic_no.value = arrText[0][13];
                
            }
        }
        var sheetObj = sheetObjects[0]; 
        com_change_sheet( sheetObj, eleName);
//        alert(formObj.ctrt_cust_sls_ofc_cd.value)
    }   

    /**
     * duration,Mvc,afiliate 버튼의 이미지를 초기화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		clearButtonImages();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */
    function clearButtonImages(){
    	document.images("img_dur").src = ICON_URL_NOT_EXIST;
    	document.images("img_mqc").src = ICON_URL_NOT_EXIST;
    	document.images("img_affil").src = ICON_URL_NOT_EXIST;
    	document.images("img_blpl").src = ICON_URL_NOT_EXIST;
    	document.images("img_ctrt").src = ICON_URL_NOT_EXIST;
    	document.images("img_ctrt_tpy").src = ICON_URL_NOT_EXIST;
    }
    
    /**
    * Real Customer에 관련된 Html Object의 값을 clear 한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		clearRealCustName();
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */         
    function clearRealCustName(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
    	sheetObj.CellValue(1,"real_cust_seq") = "";	
    	sheetObj.CellValue(1,"real_cust_cnt_cd") = "";	
        sheetObj.CellValue(1,"real_cust_tp_cd") = "";
        sheetObj.CellValue(1,"real_cust_nm") = "";
        sheetObj.CellValue(1,"real_cust_val_sgm_cd") = "";
        sheetObj.CellValue(1,"real_cust_val_sgm") = "";         
        sheetObj.CellValue(1,"real_cust_srep_cd") = "";
        sheetObj.CellValue(1,"real_cust_sls_ofc_cd") = "";
        
        formObj.real_cust_cnt_cd.value = "";
        formObj.real_cust_seq.value = "";
        comboObjects[4].Code = "";
        formObj.real_cust_nm.value = "";
        formObj.real_cust_val_sgm.value = "";
        comboObjects[5].Code = "";
        formObj.real_cust_sls_ofc_cd.value = "";
        formObj.real_cust_srep_nm.value = "";        
    }   
    
    /**
    * Real Customer에 관련된 정보를 조회한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		realCustNameFind(eleName);
    * </pre>
    * @param  {string} eleName 필수 Html Object Name
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */      
    function realCustNameFind(eleName){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var real_cust_cnt_cd = formObj.real_cust_cnt_cd.value;
        var real_cust_seq = formObj.real_cust_seq.value;
        
        if(real_cust_cnt_cd != ""  && real_cust_seq !=""){
            var sParam = "f_cmd="+SEARCH02+"&cust_cnt_cd="+real_cust_cnt_cd+"&cust_seq="+real_cust_seq;
       
            var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do", sParam);
            var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm");
            
            if(arrText==undefined){
                clearRealCustName();
                formObj.real_cust_cnt_cd.focus();
            }else{
                comboObjects[4].Code = "";              
                comboObjects[5].Code = "";
                sheetObj.CellValue(1,"real_cust_tp_cd") = arrText[0][0];
                sheetObj.CellValue(1,"real_cust_nm") = arrText[0][1];
                sheetObj.CellValue(1,"real_cust_val_sgm_cd") = arrText[0][3];
                sheetObj.CellValue(1,"real_cust_val_sgm") = arrText[0][4];          
                sheetObj.CellValue(1,"real_cust_srep_cd") = arrText[0][5];
                sheetObj.CellValue(1,"real_cust_sls_ofc_cd") = arrText[0][6];
                
                comboObjects[4].Code2 = arrText[0][0];
                formObj.real_cust_nm.value = arrText[0][1];
                formObj.real_cust_val_sgm.value = arrText[0][4];
                comboObjects[5].Code2 = arrText[0][5];
                formObj.real_cust_sls_ofc_cd.value = arrText[0][6]; 
                formObj.real_cust_srep_nm.value = arrText[0][7];        
            }

        }else if (real_cust_cnt_cd == "" || real_cust_seq ==""){
//          clearRealCustName();

        }
        var sheetObj = sheetObjects[0]; 
        com_change_sheet( sheetObj, eleName);
    }   
    
    /**
     * 메인 duration이 변경되었을 경우 조건에 따라 Scope의 duration을 변경한다. <br>
     * 저장 전에 scope duration을 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      saveChangeDuration(true);
     * </pre>
     * @param {msgPass} 필수 메세지 박스를 보이지 않고 scope의 duration만 변경할 경우 true,메세지박스를 보여주려면 false
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     
    function saveChangeDuration(msgPass){
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var oriCtrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt_ori");//변경전  duration
        var oriCtrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt_ori");//변경전  duration
        var ctrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt");//변경후 duration
        var ctrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt");//변경후 duration
        var effChk = 0;// 1 : 일자 앞으로 늘림 Duration Eff 늘이기 , 2 : 일자 줄임 Duration Eff 줄이기
        var expChk = 0;// 1 : 일자 줄임 Duration Eff 줄이기               ,  2 : 일자 뒤로 늘림 Duration Exp 늘이기
        var msgChk = 0;
        var amdtSeq = sheetObj.CellValue(1,"amdt_seq");

        if (sheetObj.CellValue(1, "ibflag")=="I"){//신규입력
            for( var i = 1; i <= sheetObj1.RowCount; i++){
            	sheetObj1.CellValue(i, "ctrt_eff_dt")= ctrtEffDt;
            	sheetObj1.CellValue(i, "ctrt_exp_dt")= ctrtExpDt;
            }        	
        	return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk = 1; //일자 앞으로 늘림 Duration Eff 늘이기 
             //아니오를 선택 할 경우 Proposal Duration Eff 만 늘임
            for ( var i = 1 ; i <=sheetObj1.RowCount; i++){
                if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){ 
            effChk = 2; //일자 줄임 Duration Eff 줄이기
            //아니오를 선택 할 경우 모든 수행을 취소하고 Return
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (ctrtEffDt >= sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ //일자 줄임 Duration Eff 줄이기
            expChk = 1; //일자 줄임 Duration Eff 줄이기
            //아니오를 선택 할 경우 모든 수행을 취소하고 Return
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    msgChk += 3; 
                    break;
                }
            }
        }else if (oriCtrtExpDt < ctrtExpDt){ 
            expChk = 2; //일자 뒤로 늘림 Duration Exp 늘이기
            //아니오를 선택 할 경우 Proposal Duration Exp 만 늘임
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (oriCtrtExpDt == sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    msgChk += 6;
                    break;
                }               
            }
        }       

        // 메세지로 변경 확인 한 후
        if ((effChk + expChk) == 0){ //duration 만 변경된다.
            return true;
        }
        if (msgPass == "true"){
            msgChk = 0;
        }
      //SCOPE DURATION변경 확인 메세지출력
        switch (msgChk){
            case 1://NO 를 선택해도 MAIN DURATION은 변경
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }
                break;
            case 2:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }               
                break;
            case 3:         
            case 4:
            case 5:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }                       
                break;
            case 6://NO 를 선택해도 MAIN DURATION은 변경
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }               
                break;
            case 7://NO 를 선택해도 MAIN DURATION은 변경
                if (!ComShowCodeConfirm("PRI01109")){
                    return true;
                }               
                break;
            case 8:
                if (!ComShowCodeConfirm("PRI01109")){
                    return false;
                }                   
                break;
        
        }
        
        if (effChk == 1){           
            //effChk = 1; //일자 앞으로 늘림 Duration Eff 늘이기 
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                //변경전 Main duration 과 Scope Duration 이 같을 경우
            	if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    sheetObj1.CellValue2(i,"ctrt_eff_dt") = ctrtEffDt;
                    sheetObj1.CellValue2(i,"eff_dt") = ctrtEffDt;
                    if (amdtSeq =="0"){
                        sheetObj1.CellValue2(i, "n1st_cmnc_dt") = ctrtEffDt;//현재사용안함
                    }
                }
            }
        }else if (effChk == 2){
            //effChk = 2; //일자 줄임 Duration Eff 줄이기
            //단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
            for (var i = 1; i <= sheetObj1.RowCount; i++){
            	if (ctrtEffDt >= sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    sheetObj1.CellValue2(i, "ctrt_eff_dt") = ctrtEffDt; 
                    sheetObj1.CellValue2(i, "eff_dt") = ctrtEffDt;  
                    if (amdtSeq =="0"){
                        sheetObj1.CellValue2(i, "n1st_cmnc_dt") = ctrtEffDt;
                    }
                }
                
            }
        }
        
        if (expChk == 1){
            //expChk = 1; //일자 줄임 Duration Eff 줄이기
            //단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    sheetObj1.CellValue2(i,"ctrt_exp_dt") = ctrtExpDt;
                    sheetObj1.CellValue2(i,"exp_dt") = ctrtExpDt;
                }
            }
        }else if (expChk == 2){
            //expChk = 2; //일자 뒤로 늘림 Duration Exp 늘이기
            //단, 아니요를 선택 할 경우 Proposal Duration Exp 만 늘임
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (oriCtrtExpDt == sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    sheetObj1.CellValue2(i, "ctrt_exp_dt") = ctrtExpDt; 
                    sheetObj1.CellValue2(i, "exp_dt") = ctrtExpDt;  
                }               
            }
        }       
        return true;
    }
    
    
 
 /**
  * Customer Type 변경에 따라 Real Customer항목을 Enable/Disable처리한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *      changeRealCustomerEditable(true);
  * </pre>
  * @param {Boolean} 필수 true, false
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */     
 function changeRealCustomerEditable(sw){
     var formObj = document.form;
     btnImgEnable(formObj.btn_real_cust, sw);
     formObj.real_cust_cnt_cd.readOnly = true;
     formObj.real_cust_seq.readOnly = true;
     formObj.real_cust_tp_cd.enable = false
     formObj.real_cust_srep_cd.enable = false;
     
 }
 
  

 /**
  * 권한 없는 사용자가 new버튼을 클릭하여 처음 데이터를 입력할때 Control을 사용할 수 있게 한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *      setNewDataControl();
  * </pre>
  * @param  없음
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */      
  function setNewDataControl(){
	  var formObj = document.form;
        	
	  formObj.ctrt_eff_dt.readOnly = false;    
	  formObj.ctrt_exp_dt.readOnly = false;
	  btnImgEnable(formObj.btn_ctrt_cust, true);
	  ComBtnDisable("btn_ctrt_pty_pop");
	  btnImgEnable(formObj.btns_calendar1, true);
	  btnImgEnable(formObj.btns_calendar2, true);   	  	
	  formObj.prop_mqc_qty.readOnly = false;

	  formObj.ctrt_cust_srep_cd.enable = true;
	  formObj.prc_ctrt_cust_tp_cd.enable = true;  	
	  formObj.sls_ld_no.enable = true;

	  formObj.cust_cnt_cd.readOnly = false;
	  formObj.cust_seq.readOnly = false;    
	  formObj.rf_flg.disabled = false;//reefer            
	  formObj.gamt_flg.disabled = false;//garment
	  formObj.prop_srep_cd.enable = true;
	  formObj.prop_apro_ofc_cd.enable = true;

	  formObj.prc_ctrt_cust_tp_cd.enable = true;
	  formObj.cntr_lod_ut_cd.enable = true;
	  
	  document.images("img_lgcy").src = ICON_URL_NOT_EXIST;
	  
      ComBtnEnable("btn_save"); 
      ComBtnEnable("btn_rowadd");            
      ComBtnEnable("btn_delete");  
  	
  }  

  
  /**
   * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
   * Combo의 text값을 Html Object에 표시한다. <br>
   * <br><b>Example :</b>
   * <pre>
   *    prop_srep_cd_OnBlur(comboObj);
   * </pre>
   * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */  
  function prop_srep_cd_OnBlur(comboObj) {
		var formObj = document.form;		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		var sheetObj = sheetObjects[0];

		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.prop_srep_nm.value) {
				formObj.prop_srep_nm.value = comboObj.GetText(code, 1);		
			}
		}
		if (code == -1){
			formObj.prop_srep_nm.value = "";
		}
	}       
  
  
  /**
   * 메인의 Status 상태에 따라 Cancel 버튼의 text를 변경한다.<br>
   * <br><b>Example :</b>
   * <pre>
   *    setCancelText();
   * </pre>
   * @param  없음
   * @return 없음
   * @author 공백진
   * @version 2009.04.17
   */ 
  
	function setCancelText(){
		var formObj = document.form;
		var cancelTxt = formObj.prop_sts.value ;
		if (cancelTxt == "Requested"){
			cancelTxt = "Request ";
		}else if(cancelTxt == "Approved"){
			cancelTxt = "Approve ";
		}else if(cancelTxt == "Filed"){
			cancelTxt = "Filed ";
		}else{
			cancelTxt = "";
		}
		document.getElementById("btn_cancel_txt").innerText = cancelTxt +"Cancel";  	
	}  
  
  /**
  * 화면의 지정된 부분을 숨기거나 표시하여 화면을 넓게 쓸수 있게한다.<br>
  * <br><b>Example :</b>
  * <pre>
  *    setControlHidden();
  * </pre>
  * @param  없음
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */   
	function setControlHidden(){
		if (!controlHidden){
			document.all.subterms.style.display = "none";
			controlHidden = true;
		}else{
			document.all.subterms.style.display = "inline";
			controlHidden = false;
			sheet1_OnSearchEnd(sheetObjects[0], "");
		}
		try{
		    parent.syncHeight();  // 펼쳤을때 화면하단 안보이는 문제 해결
			}catch(e){}
	}
  
//--> jin add (E)

//    sheet  관련   (E)   -----

/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (E)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////
    
  /**
  * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
  * <br><b>Example :</b>
  * <pre>
  *    btnImgEnable(obj, gb);
  * </pre>
  * @param  {form} obj 필수 Html Object
  * @param  {bool} gb  필수 true : 활성화 false : 비활성화
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */ 
function btnImgEnable(obj, gb) {
    if(obj.constructor == String){
        obj = document.getElementsByName(obj)[0];        
    }
    var btnStyle = obj.style;
    
    if (gb){
        obj.Enable = true;
        btnStyle.cursor = "hand";
        btnStyle.filter="";
        obj.disabled = false;
    } else {
        obj.Enable = false;        
        btnStyle.cursor = "auto";
        btnStyle.filter="progid:DXImageTransform.Microsoft.BasicImage(grayScale=1)";
        obj.disabled = true;
    }

}

    /**
     * GroupWare Mail Popup을 호출한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *      openGroupWareMailPopup(sheetObjects[0]);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {object} formObj 필수 Form Object
     * @param {string} stsCd 필수 현재 Proposal 상태코드
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function openGroupWareMailPopup(sheetObj, formObj, stsCd){
        var param = "";
        var propNo = sheetObjects[0].CellValue(1, "prop_no");
        var amdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
        var scNo = sheetObjects[0].CellValue(1, "sc_no");
        formObj.gw_contents.value="";
        formObj.gw_subject.value = "";
        formObj.gw_template.value = "";
        formObj.gw_args.value = "";

        if (stsCd == 'Q') {
            if (amdtSeq == "0") {
                param = propNo;
            } else {
                param = scNo + ", AMD#" + ComLpad(amdtSeq, 2, "0");
            }
            formObj.gw_subject.value = "[S/C Approval Request] " + param;
            formObj.gw_template.value = "ESM_PRI_0003_01T.html";
            formObj.gw_args.value = "param;"+param;
        } else if (stsCd == 'A') {
            if (amdtSeq == "0") {
                param = propNo;
            } else {
                param = scNo + ", AMD#" + ComLpad(amdtSeq, 2, "0");
            }
            formObj.gw_subject.value = "[S/C Approval Result] " + param;
            formObj.gw_template.value = "ESM_PRI_0003_02T.html";
            formObj.gw_args.value = "param;"+param;
        }
        ComOpenGroupwareMail(sheetObj,formObj);
    }
     
         
     
     /**
      * BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *      getBackEndJobStatus();
      * </pre>
      * @return 없음
      * @author 공백진
      * @version 2009.08.17
      */     
     function getBackEndJobStatus() {
     	var form = document.form;	
     	form.f_cmd.value = SEARCH15;
     	backEndJobCnt++;
     	//최대 5번 실행
     	if (backEndJobCnt == 5){   		
     		backEndJobCnt = 0;
     		return;
     	}
     	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", FormQueryString(form));
     	var jobState = ComGetEtcData(sXml, "jb_sts_flg");     	
     	if (jobState == undefined){
     		backEndJobCnt = 0;
     		return;
     	}
     	form.job_status.value = jobState;

     	if (jobState == "3") {
     		getBackEndJobSearch();
     	} else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
     		backEndJobCnt = 5;
     	} else if (jobState == "5") {
     		backEndJobCnt = 5;
     	} else{
     		window.setTimeout(getBackEndJobStatus, 5000);
     	}
     }     
     

     /**
      * BackEndJob의 결과가 완료되면 결과를 조회하여 Performance,Attainment에 값을 입력한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *      getBackEndJobSearch();
      * </pre>
      * @return 없음
      * @author 공백진
      * @version 2009.08.17
      */       
     function getBackEndJobSearch() {
     	var form = document.form;
     	form.f_cmd.value = SEARCH16;
     	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0003GS.do", FormQueryString(form));
     	var arrData = ComPriXml2Array(sXml, "op_cntr_qty|pro_rt_mqc_perf");
        if (arrData != null && arrData.length > 0) {
        	form.prop_pfmc.value = ComAddComma(arrData[0][0]);
        	form.prop_atmt.value = ComAddComma(arrData[0][1]);
        }
     }     

  /**
   * Rate에서 호출 하여 PRS CM Data를 조회한다.<br>
   * <br><b>Example :</b>
   * <pre>
   *		getPRSCMData();
   * </pre>
   * @return 없음
   * @author 공백진
   * @version 2009.05.07
   */      
   function getPRSCMData(){
       var formObj = document.form;
       var sheetObj = sheetObjects[0];
       formObj.f_cmd.value = SEARCH17;
       var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no") +"&amdt_seq="+sheetObj.CellValue(1,"amdt_seq");
       sParam += "&" + FormQueryString(formObj);
       var sXml = sheetObj.GetSearchXml("ESM_PRI_0003GS.do" , sParam);
       var arrData = ComPriXml2Array(sXml, "prs_crnt_cm_amt|prs_estm_cm_amt");           
       if (arrData !=null && arrData.length > 0){
    	   formObj.prs_crnt_cm_amt.value = ComAddComma(arrData[0][0]);
    	   formObj.prs_estm_cm_amt.value = ComAddComma(arrData[0][1]);
    	   formObj.prs_sum_cm_amt.value =  ComAddComma(parseInt(arrData[0][0]) + parseInt(arrData[0][1]));
       }else{
    	   formObj.prs_crnt_cm_amt.value = 0;
    	   formObj.prs_estm_cm_amt.value = 0;
    	   formObj.prs_sum_cm_amt.value =  0;
       }
   }      
      
   
   /**
    * Conversion을 Confirm한다.<br>
    * 이전 amd_seq가 Confirm되어 있어야 활성화된다.<br>
    * Confirm 이후에는 check box 를 disable한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		conversionConfirm();
    * </pre>
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */      
    function conversionConfirm(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        try{
        	ComOpenWait(true); //->waiting->start
        	if (!ComShowCodeConfirm("PRI01118")){
                formObj.conv_cfm_flg.checked = false;            
            	return false;
            }
            formObj.f_cmd.value = MULTI07;   
            
            var sParam ="prop_no="+sheetObj.CellValue(1, "prop_no")+"&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
            sParam += "&"+ FormQueryString(formObj);            
            
            var saveXml= sheetObjects[0].GetSaveXml("ESM_PRI_0003GS.do", sParam);
            sheetObjects[0].LoadSaveXml(saveXml);
            ComOpenWait(false); //->waiting->End
            formObj.conv_cfm_flg.disabled = true;        	
        } catch (e) {
          	if (e == "[object Error]") {
                  ComShowMessage(OBJECT_ERROR);
              } else {
                  ComShowMessage(e);
              }
          }finally{
        	  ComOpenWait(false); //->waiting->End
          }
                  
    }     

    
    /**
    * 운영서버 테스트시 CLT에 제공되는 account는 제한되어 있는데 <BR>
    * SC 화면의 office별 권한 체크로 인해 원할한 테스트가 불가능 하다.<BR>
    * 이른 회피하기 위해 정해진 경로대로 화면 조작을 할 경우 현재 로긴된 사용자가<BR>
    * 작성권, 승인권, 대표승인권을 갖도록 해주는 함수 이다. <BR>
    * <br><b>Example :</b>
    * <pre>
    *     verifySuperUser(srcName);
    * </pre>
    * @param {String} srcName 화면에서 click한 object의 이름. 
    * @return 없음
    * @author 송민석
    * @version 2010.06.29
    */
   function verifySuperUser(srcName){
	   	//이미 권한을 획득했다면 더이상 권한 검증을 하지 않는다.
	   	if( IS_SUPER_USER ){
	   		return ;
	   	}
	   	if (srcName != null && srcName != "" ){
	    	if( srcName == "btn_new"){
	        	superUserRoute = srcName;
	    	}else{
	        	superUserRoute += "|" + srcName;
	        	if( STANDARD_SUPER_USER_ROUTE.indexOf(superUserRoute) == 0 ){
	        		if( STANDARD_SUPER_USER_ROUTE == superUserRoute ){
	        			//권한 획득
	        			ComShowMessage("You are a superuser from now on.\nPlease, operate carefully.")
	        			IS_SUPER_USER = true;
	        			//Superuser만 사용 할수 있는 button을 보여준다.
	        			showButtonsForSuperUser();
	        		}
	        	}else{ // 경로가 틀렸으므로 btn_new 버튼부터 다시 시작 해야만
	        			// super user의 권한 획득 가능
	        		superUserRoute = "";
	        	}
	    	}
	   	}
   	
   }
    /**
    * 운영서버 테스트시 CLT에 제공되는 account는 제한되어 있는데 <BR>
    * SC 화면의 office별 권한 체크로 인해 원할한 테스트가 불가능 하다.<BR>
    * 이른 회피하기 위해 정해진 경로대로 화면 조작을 할 경우 현재 로긴된 사용자가<BR>
    * 작성권, 승인권, 대표승인권을 갖도록 하는 숨은 로직이 있는데 <BR>
    * 이때 Superuser만이 사용 할수 있는 숨은 button을 보여준다.
    * <br><b>Example :</b>
    * <pre>
    *     showButtonsForSuperUser();
    * </pre>
    * @return 없음
    * @author 송민석
    * @version 2010.06.29
    */
   function showButtonsForSuperUser(){
		// filed 상태를 이전 상태로 되돌릴수 있는 버튼을 보여준다.
		var file_btn_obj = document.getElementById("span_cancel_filing");
		file_btn_obj.style.display = "inline";
   }
    
    /**
    * 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 <BR>
    * 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확은을 한다.<BR>
    * <br><b>Example :</b>
    * <pre>
    *     checkChangingUpdateDate(sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj update date와 key를 가진 sheet object
    * @param {String} checkTpCd update date를 check해야 하는 table이 다를 수 있다 이를 구분하는 code
    *  
    * @return boolean , true : 변경된 데이터 있음, false: 변경된 데이터 없음.
    * @author 송민석
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	
    	var returnValue = false;
        /////////////////////////////////////////////////////////////////////
        // update date 검사
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_SP_MN&page_name=S/C&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+checkSheetObj.CellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   case "CHECK2" : //amend
	   	    var amdt_seq = parseInt(checkSheetObj.CellValue(1, "amdt_seq"));
	   		//다음 seq가 이미 생성되었는지 확인한다.
	   		amdt_seq++;
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_SP_MN&page_name=S/C&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
	        var cXml = checkSheetObj.GetSearchXml("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchXml(cXml);
	        	ComOpenWait(false); //->waiting->End
	        	returnValue = true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
    
    function checkOtiSvcScp(){
    	var sheetObj2 = sheetObjects[1];
        var isTpe = "N";
        
        for(var i = sheetObj2.HeaderRows; sheetObj2.RowCount > 0 && i <= sheetObj2.LastRow; i++) {
        	if( (sheetObj2.CellValue(i,"svc_scp_cd") == "TPE" ) 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "TPW") 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "TAE") 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "MME") 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "ASE") 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "SAN") 
        			|| (sheetObj2.CellValue(i,"svc_scp_cd") == "SAS") )
        	{
        		isTpe = "Y";
        		break;
        	}
        }
        return isTpe;
    }
    
    /**
     * 선택한 Sales Rep 에게 메일 보내기
     * @author 서미진
     * @version 2012.02.13
     */    
    function sendMail() {
   		var date = new Date();
    	var content = "";
    	var formObj = document.form;
    	content = "<br>*	SC No.	: "
				+ formObj.sc_no.value
				+ " amd # "
				+ formObj.amdt_seq.value
				+ "<br>*	Scope	: " 
				+ sheetObjects[1].CellValue( sheetObjects[1].SelectRow , "svc_scp_cd") 
				+ "<br>*	Customer	: "  
    			+ formObj.ctrt_pty_nm.value
    			+ "<br>*	Sales Rep : "  
    			+ comboObjects[0].GetText(comboObjects[0].Code, 1)
    			+ "<br>*	Sales Rep E-mail : "
    			+ comboObjects[0].GetText(comboObjects[0].Code, 2)
    	formObj.gw_contents.value = content;
        ComOpenGroupwareMail(sheetObjects[0],formObj);
    }    

    /**
     * 선택한 Service Scope 별로 
     * 당 회차에서 신규 Insert 인 경우에만 Delete 버튼 Enable 되도록 함
     * @author 송호진
     * @version 2014.11.11
     */    
   function svcScpDeleteEnable() {
	   
	   var sheet1 = sheetObjects[0];
	   var sheet2 = sheetObjects[1];
	   
	   if ( sheet1.CellValue ( 1, "prop_no" ) == "" || 
			   ( sheet1.CellValue ( 1, "prop_no" ) != "" && ( sheet1.CellValue(1, "req_usr_flg") == "Y" || sheet1.CellValue(1, "apro_usr_flg") == "Y" ) ) 
			   ) {
		   if ( sheet1.CellValue ( 1, "prop_sts_cd" ) == "I" && sheet2.CellValue ( sheet2.SelectRow, "new_ins_flg" ) == "0" ) {
			   ComBtnEnable ( "btn_delete");
			   return;
		   }
	   }
	   ComBtnDisable ( "btn_delete" );
   }

   
	/**
	 * Service scope delete 버튼에 마우스가 over됐을때 상태 Text를 보여준다..<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {object} e 필수, Event Object
	 * @return 없음
	 * @author 송호진
	 * @version 2014.11.19
	 */
   function btn_delete_OnMouseOver(e){
   	var parentObj = document.getElementById("btn_delete");
   	openDynamicPopup(-12,parentObj.clientHeight*-1 - 62,240,80,parentObj);
   }
   
	/**
	 * Service Scope delete 버튼에 마우스가 over됐을때 상태 Text를 감춰준다..<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {object} e 필수, Event Object
	 * @return 없음
	 * @author 송호진
	 * @version 20134.11.19
	 */    
   function btn_delete_OnMouseOut(e){
   	if( oPopup != null){
   		oPopup.hide();
   	}
   }
   var oPopup = null;
   var calcStatusStr = " Delete button is available only for the<br>newly added SVC Scope.<br>If you want to delete the existing scope,<br>then you can proceed by scope duration<br>expiration.";
   var timeID = "";
   var PRE_STATUS = "";
	/**
	 * Service scope delete 버튼에 마우스가 over됐을때 보여줄 Text Div 생성 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {object} x 필수, x좌표
	 * @param {object} y 필수, y좌표
	 * @param {object} width 필수, 넓이
	 * @param {object} height 필수, 높이
	 * @param {object} parentObj 필수, parent Object
	 * @return object, div object
	 * @author 송호진
	 * @version 2014.11.19
	 */    
   function openDynamicPopup(x,y,width,height,parentObj){
       if( oPopup == null){
           oPopup = window.createPopup(); 
           var oPopBody = oPopup.document.body;
           oPopBody.style.backgroundColor = "lightyellow";
           oPopBody.style.border = "solid black 1px";
           oPopBody.style.padding= "2px"
          	oPopBody.style.fontFamily="Tahoma,verdana,arial,dotum,gulim";
           oPopBody.style.fontSize="12px"
           	 
       }
       oPopup.document.body.innerHTML =calcStatusStr;
       oPopup.show(x,y,width,height,parentObj);
       return oPopup;

   } 

   function checkFileCancelUser(){
	   var formObj = document.form;
	   var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCH33;                                                                                                                                                                                                                                                                                                                                                                                                        
		sXml = sheetObj.GetSearchXml("PRICommonGS.do",                                                                                                                                                                                                                                                                                                                                                                                   
				FormQueryString(formObj));                                                                                                                                                                                                                                                                                                                                                                        
		var fileCancelAuth = ComGetEtcData(sXml, "fileCancelAuth");      
		return fileCancelAuth;
   }
   
     /* 개발자 작업  끝 */