/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2103.js
*@FileTitle : Spot Guide RFA Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.08 공백진
* 1.0 Creation
=========================================================
* History
* 2011.05.25 이행지 [CHM-201111048-01] ALPS Error 처리- SVC Scope Combo에 없는 값이 넘어가는 에러 -> Validation 추가
* 2011.10.07 이석준 [CHM-201113808]    RFA 자동 Pop-Up 기능 삭제 요청 
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나 조회 가능토록 수정            
* 2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
* 2012.02.08 이석준 [CHM-201216074] RFA 조회시 HAMRU 산하의 BA OFFICE들이 상대방 BA RFA 조회 못하게 했던 부분을 다시 원래대로 조회 할 수 있도록 수정           
* 2012.05.22 이은섭 - 구주 Hinterland 프로젝트에 따른 변경 (구주 Hinterland 프로젝트 오픈전에 발생한 AEW, AEE이 포함된 경우 Amend 불가.                                                                                                                                       
* 2012.09.17 이은섭 [CHM-201220395] - Add-On T/F에 따른 변경 (특정 Scope를 제외한 모든 Scope에 대해 Guide Line 제공)  
* 2013.03.19 전윤주 [CHM-201323647] ALPS 통합로그 SQL 오류 제거 - customer 검색 시 customer seq. 자리에 숫자가 들어오지 않는 경우 validation 처리
* 2013.03.19 전윤주 [CHM-201323648] Contract S.rep code validation logic 수정 - space를 강제 선택했을 경우 validatoin 되도록 추가                                                                                                                                
* 2013.06.27 송호진 [CHM-201325462] 본사 조직 변경에 따른 PRICING MODULE 내에 기존 조직코드 삭제 요청 - CHM-201325245 변경시 남겨놓은 기존 코드 삭제 
* 2013.07.08 전윤주 [CHM-201324601] RFA Request 시 Port 운임에 속한 Route (Origin, Dest) 를 체크하여 call_port_flag가 'N' 인 경우 validation 처리
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
* 2014.07.14 최성환 [CHM-201430984] Contract RFA copy 시 logic 변경 요청 (AMD No.: 0 + Status : initial 을 충족하면 Target MVC의 단위를 변경 가능하게 처리)
* 2014.09.15 최성환 [CHM-201431899] Guideline RFA 생성 요청
* 2014.11.05 최성환  [CHM-201432701] Spot guide RFA logic 변경 요청
* 2015.05.06 전지예 [CHM-201535708] Duration 화면의 문구 변경
* 2015.07.14 전지예 [CHM-201536753]Spot Guide RFA Artitrary Tab 추가 (BOMSC Only)
* 2015.08.13 [CHM-201537109] Split19-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
* 2015.11.10 SELCMU/김현경 [CHM-201538112] Tariff 변경시 현 RFA 상 Arbitiary 탭 미반영 로직수정
=========================================================*/
/**************************************************************************************** 
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*
콤보 위치
comboObjects[0] - Sales Rep.(prop_srep_cd)
comboObjects[1] - RFA Type(rfa_ctrt_tp_cd)
comboObjects[2] - Customer Sale Rep Office(respb_srep_cd)
comboObjects[3] - Target MVC (cntr_lod_ut_cd)(prop_mvc_tp)
comboObjects[4] - Sales Lead(sls_ld_no)
comboObjects[5] - Free Time(dmdt_ft_tp_cd)
*/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 한진해운
     */

    /**
     * @extends
     * @class ESM_PRI_2003 : ESM_PRI_2003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2103() {
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
  //각 Terms의 상태를 보여주기위한 아이콘 주소 변수
    var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
    var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";
    var ICON_URL_AMEND = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon4.gif";
    var ICON_URL_ACCEPT = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon3.gif";
    
    /**
     * Copy Date 여부체크
     */
    var cpPriMnFlag = false;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var tabDivCount = 9;
    
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
        var formObj = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
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
                
            case "btn_save":    
                var effDt = ComGetUnMaskedValue(formObj.ctrt_eff_dt.value,"ymd");
                var sEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
                if (effDt != sEffDt){
                	com_change_sheet( sheetObjects[0], "ctrt_eff_dt" );
                }
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
                
            case "btn_rowadd":
                doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
                break;
                
            case "btn_delete":
                doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
                break;      
                
            case "btns_calendar1": //달력버튼
                var cal = new ComCalendarFromTo();                
                cal.select(document.form.ctrt_eff_dt, document.form.ctrt_exp_dt, 'yyyy-MM-dd');                
                break;  
            case "btn_ctrt_cust":
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?nmd_cust_flg=N&is_popup=true&cust_cnt_cd="+formObj.ctrt_cust_cnt_cd.value+"&cust_seq="+formObj.ctrt_cust_seq.value, "ESM_PRI_4014", 640, 455, true);
                if (rtnVal != null){                    
                    formObj.ctrt_cust_cnt_cd.value = rtnVal.custCntCd;         
                    formObj.ctrt_cust_seq.value = rtnVal.custSeq;
                    formObj.ctrt_pty_nm.value = rtnVal.custNm;  
                    custNameFind("ctrt_cust_cnt_cd");
                    // sale rep
                    setCustSaleRep();
                    comboObjects[2].Code2 = sheetObjects[0].CellValue(1,"respb_srep_cd");   
                    com_change_sheet( sheetObjects[0], "ctrt_cust_seq");          
                }
                break;   
            case "btn_amend":   
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                } 
                //이행 된 데이터의 경우 AMEND 금지
                if (sheetObjects[0].CellValue(1, "cre_tp") == "I"){
                	ComShowCodeMessage('PRI01130');
                	return;
                }
    	        /////////////////////////////////////////////////////////////////////
    	        // update date 검사
    	        var checkSheetObj = sheetObjects[0];
    	        var checkTpCd = "CHECK1";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        checkTpCd = "CHECK2";
    	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
    	        	return false;
    	        }
    	        /////////////////////////////////////////////////////////////////////

                var sParam = getParameters("btn_amend");
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2140.do?"+sParam, "ESM_PRI_2140", 700, 225, true);

                if (rtnVal != null && rtnVal =="Y"){
                	// Request 시 Arbitrary Guide Line을 최신으로 갱신
                	updateArbitraryGuideValue(sheetObjects[0]);
                	
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                }
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
            case "btn_cancel":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }   
                doActionIBSheet(sheetObjects[0],document.form,COMMAND05);
                //승인권자 Request Cancel시 공통쪽지 연결
                var aproUsrFlg = sheetObjects[0].CellValue(1, "apro_usr_flg");

                if (sheetObjects[0].CellValue(1,"prop_sts_cd") =="I" && aproUsrFlg == "Y"){
//                    ComOpenWait(true); //->waiting->start
//                    openMessagePopup(sheetObjects[0].CellValue(1,"prop_sts_cd"), sheetObjects[0].CellValue(1,"prop_srep_cd"));
//                    ComOpenWait(false); //->waiting->End
                }
                break;  
            case "btn_dur_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }

                var sParam = getParameters(srcName,"");                
                var rtnVal = ComPriOpenWindowCenter ("/hanjin/ESM_PRI_2010.do?"+sParam, "ESM_PRI_2010", 635, 295, true);

                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }
            
                break;                    
    
            case "btn_dem_pop":            
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sUrl = "/hanjin/EES_DMT_2103.do?" + "prop_no="+formObj.prop_no.value 
                		 + "&amdt_seq=" + formObj.amdt_seq.value + "&caller=2003";
                var rtnVal = ComPriOpenWindowCenter(sUrl, "EES_DMT_2103", 1010, 700, true);

                break;       
            case "btn_free_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }         

                var sParam = getParameters(srcName, "");                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2058.do?"+sParam, "ESM_PRI_2058", 800, 240, true);    
                if (rtnVal != null && rtnVal =="Y" ){                   
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH); 
                }
                break;                  
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }     

                var sParam = getParameters(srcName, "");                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2103_06.do?"+sParam, "ESM_PRI_2103_06", 1020, 315, true);
            
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
                }
                break;
            case "btn_copy":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var sheetObj = sheetObjects[0];
                var sRfa_No = sheetObj.CellValue(1,"rfa_no");
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var ctrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt");
                var sParam = "rfa_no="+sRfa_No+"&prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq + "&ctrt_eff_dt=" + ctrtEffDt + "&endExpDt=" + endExpDt+"&addOnEndExpDt=" + addOnEndExpDt;
                var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2044.do?"+sParam, "ESM_PRI_2044", 650, 285, true);
                if(str != null){
                    formObj.prop_no.value = str;
                    formObj.rfa_no.value ="";
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
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sParam = "prop_no="+sPropNo+"&amdt_seq="+sAmdtSeq;
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2039.do?"+sParam, "ESM_PRI_2039", 1024, 790, true);                
                break;
                
            	
            	
            case "btn_mqc_estimate":   
            	var sheetObj = sheetObjects[0];
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
	
	 			var pgmNo = "ESM_PRI_6091";
	 			var pgmUrl = "/hanjin/ESM_PRI_6091.do"
	     
	 			
                
                var sPropNo = sheetObj.CellValue(1,"prop_no");
                var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
                var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg");
                var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg");
                var prc_prop_sts_cd = sheetObj.CellValue(1, "prop_sts_cd");
                
                var tgt_mvc_qty = formObj.tgt_mvc_qty.value;
                var cntr_lod_ut_cd = formObj.cntr_lod_ut_cd.Code;
                var cntr_lod_ut_text = formObj.cntr_lod_ut_cd.Text;
                
                var sParam = "frm_prop_no="+sPropNo
                	+"&frm_amdt_seq="+sAmdtSeq
                	+"&frm_tgt_mvc_qty="+tgt_mvc_qty
                	+"&frm_cntr_lod_ut_cd="+cntr_lod_ut_cd
                	+"&frm_cntr_lod_ut_text="+cntr_lod_ut_text
                	+"&is_req_usr="+sIsReqUsr
                	+"&is_apro_usr="+sIsAproUsr
                	+"&prc_prop_sts_cd="+prc_prop_sts_cd;
                var rtnVal = ComOpenWindowCenter(pgmUrl+"?"+sParam, pgmNo, 500, 390, true);
                break;                         
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
           	if (srcName == "btn_coffer" || srcName == "btn_approve") {
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

        // 로딩시 Arbitrary 탭 Disable
        setTabEnable(2, false);

        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }

        initControl();
        
        doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
        
        //ESM_PRI_2043, ESM_PRI_2042 에서 메인 pop => 김대호 2009-10-06 : jsp 에도  파라미터 받고 박아주는것 추가합니다.
        
   	 	var form = document.form;
        if("null" != form.rfa_no_2043.value && null != form.rfa_no_2043.value && "" != form.rfa_no_2043.value) {
        	form.rfa_no.value = form.rfa_no_2043.value;
        	doActionIBSheet(sheetObjects[0],form,IBSEARCH);
        } else if (form.cond_prop_no.value != "") {
            // ESM_PRI_2049 에서 Open 버튼 클릭시 RFA Proposal 메인화면 조회
          //ESM_PRI_2019 추가 
            form.prop_no.value = form.cond_prop_no.value;
            doActionIBSheet(sheetObjects[0],form,IBSEARCH);
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
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
     }
     
     /**
     * OnKeyPress event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
     * @param 없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */      
     function obj_keypress() {
         switch (event.srcElement.dataformat) {
             case "engup":
                 if (event.srcElement.name == "rfa_no" || event.srcElement.name =="prop_no") {
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
       //enter key조회
       var eleName = event.srcElement.name;
       if (eleName == "prop_no" || eleName == "rfa_no"){
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
            case "rfa_no":     
                break;
            case "prop_no":      
                break;
            case "ctrt_cust_cnt_cd":
                //cust name find
                if (sheetObj.CellValue(1, "ctrt_cust_cnt_cd") != formObj.ctrt_cust_cnt_cd.value){
                	if (formObj.ctrt_cust_cnt_cd.value == ""){
                		clearCustName();
                	}else{
                    	custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        // COMBO를 채워 준 후 조회해온 코드를 채운다.                        
                        //sale lead
                        setSaleLeadCombo(true); 
                        sheetObj.CellValue(1, "sls_ld_no")= "";                        
                        comboObjects[2].Code2 = sheetObj1.CellValue(1,"respb_srep_cd"); 
                	}
                }
                ComChkObjValid(event.srcElement);
              
                break;          
            case "ctrt_cust_seq":
                var custSeq = formObj.ctrt_cust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.ctrt_cust_seq.value = ComLpad(custSeq, 6, "0");
                }
                //cust name find
                if (ComParseInt(sheetObj.CellValue(1, "ctrt_cust_seq")) != ComParseInt(formObj.ctrt_cust_seq.value)){                    
                    if (formObj.ctrt_cust_seq.value =="" || !ComIsNumber(formObj.ctrt_cust_seq.value)){  //[CHM-201323647] 숫자가 아닌 경우 clear   
                    	clearCustName();
                    }else{	
                        custNameFind(eleName);
                        // sale rep
                        setCustSaleRep();
                        comboObjects[2].Code2 = sheetObj1.CellValue(1,"respb_srep_cd");
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
            case "tgt_mvc_qty":
                com_change_sheet( sheetObj, eleName );
                ComChkObjValid(event.srcElement);   
                break;       
            case "prop_mvc":
                ComChkObjValid(event.srcElement);   
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
            	cpPriMnFlag = false;
                sheetObj = sheetObjects[0];
                if (validateForm(sheetObj,document.form,sAction)) {
                	//
                	formObj.f_cmd.value = SEARCH39; //변경- 이전 : SEARCH01
                    if(formObj.rfa_no.value!=""){
                    	formObj.prop_no.value = "";
                    }                    
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , FormQueryString(formObj));   
                    
                    var arrXml = sXml.split("|$$|");
                    if (arrXml.length > 4){
                    	ComPriXml2ComboItem(arrXml[4], formObj.sls_ld_no, "sls_ld_no", "sls_ld_no|sls_ld_nm");
                    }
                    if (arrXml.length > 0) {
                    	sheetObjects[0].LoadSearchXml(arrXml[0]);
                    	formObj.ori_prop_no.value = sheetObj.CellValue(1, "prop_no");
                        formObj.ori_rfa_no.value = sheetObj.CellValue(1, "rfa_no");
                        
                        if(!ComIsNull(sheetObj.CellValue(1, "prop_no")) && ComIsNull(sheetObj.CellValue(1, "eff_dt")) &&  ComIsNull(sheetObj.CellValue(1, "exp_dt"))) {
                        	cpPriMnFlag = true;
                        }
                    }
                    if (arrXml.length > 2){
                    	ComPriXml2ComboItem(arrXml[2], formObj.respb_srep_cd, "cd", "cd|nm|etc1");      
                    }
                    if (arrXml.length > 3){
                    	ComPriXml2ComboItem(arrXml[3], formObj.prop_srep_cd, "cd", "cd|nm");
                    }                
                    if (arrXml.length > 1){
                    	sheetObjects[1].LoadSearchXml(arrXml[1]);
                    }
                } else {
                    ComShowCodeMessage('PRI08001');
                }
                //calcMVC();
                ComOpenWait(false); //->waiting->End
                buttonControl();
                if (ComPriGetRowCountFromXML(arrXml[0]) == -1){
                	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
                }
                formObj.prop_no.focus();
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
                sheetObjects[2].RemoveAll();
                // ex) MDM_SLS_REP 에  OFC_CD = 'ATLSC'  AND SREP_STS_CD = 'N' 조회 
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);           
                
                sheetObjects[0].DataInsert();
                var sheetObj = sheetObjects[0];
                var formObj = document.form;
                sheetObj.CellValue2(1,"prop_sts_cd")= "I";
                sheetObj.CellValue2(1,"prc_prog_sts_cd")= "I";          
                sheetObj.CellValue2(1,"src_info_cd")= "NW";
                sheetObj.CellValue2(1,"prop_ofc_cd")= formObj.in_usr_ofc_cd.value;
                sheetObj.CellValue2(1,"cntr_lod_ut_cd")= "T";   
                sheetObj.CellValue2(1,"dmdt_ft_tp_cd")= "T";
                sheetObj.CellValue2(1, "prc_prop_cre_tp_cd") = "G";
                sheetObj.CellValue2(1, "rfa_ctrt_tp_cd") = "G";  // G: Spot Guide RFA - 기존 "S" - Spot;
                sheet1_OnSearchEnd(sheetObj); 
                
                sheetObj.CellValue2(1,"amdt_seq")= "0";
                formObj.amdt_seq.value = "0";
                formObj.cntr_lod_ut_cd.Code2 = "T";
                comboObjects[5].Index = -1; 
                setRequestOfficeSaleRep();
                formObj.prop_srep_cd.Code = formObj.in_usr_srep_cd.value;            
                prop_srep_cd_OnBlur(comboObjects[0]);

                ComOpenWait(false); //->waiting->End
                formObj.ctrt_eff_dt.focus();
                buttonControl();            
                setNewDataControl();
                
                break;
            case IBSEARCH_ASYNC01: // Approval Office Code, customer type 설정
            	comboObjects[1].RemoveAll();
            	comboObjects[3].RemoveAll();
            	comboObjects[5].RemoveAll();
            	//scope cd
    	        sheetObjects[1].InitDataCombo(0,"svc_scp_cd", scopeCdText, scopeCdValue);	        
    	        sheetObjects[1].InitDataCombo(0,"cntr_lod_ut_cd", lodUtCdText, lodUtCdValue);        
    	        //scope status
    	        sheetObjects[1].InitDataCombo(0,"prop_scp_sts_cd", scpStsCdText, scpStsCdValue);
    	        ComPriTextCode2ComboItem(lodUtCdValue, lodUtCdText, getComboObject(comboObjects, 'cntr_lod_ut_cd') ,"|","\t" );
    	        //dmdt
    	        ComPriTextCode2ComboItem(dmdtCdValue, dmdtCdText, getComboObject(comboObjects, 'dmdt_ft_tp_cd'),"|","\t", 1);
    	        //RFA Contract Type
    	        //ComPriTextCode2ComboItem(rfaCtrtTpCdValue, rfaCtrtTpCdText, getComboObject(comboObjects, 'rfa_ctrt_tp_cd'),"|","\t" );
    	        //하드코딩으로 Spot Guide 추가 
    	        comboObjects[1].InsertItem(-1, "Spot Guide", "G");
    	        
                break;      
            case IBSEARCH_ASYNC02: // Sale Rep 설정
                setRequestOfficeSaleRep();
                setCustSaleRep();
                break;   
                
            case IBINSERT: // Row Add

                if (formObj.amdt_seq.value == "0"){
                    sheetObj.InitDataProperty(0, 6, dtData, 85, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, true, true);
                    sheetObj.InitDataProperty(0, 7, dtData, 85, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, true, true);  
                    sheetObj.InitDataProperty(0, 9, dtData, 120, daCenter, false, "tgt_mvc_qty", false, "", dfInteger, 0, true, true);
                    sheetObj.InitDataProperty(0,10, dtCombo, 60, daCenter, false, "cntr_lod_ut_cd",  false, "", dfNone,  0, true, true);
                }else{
                    sheetObj.InitDataProperty(0, 6, dtData, 85, daCenter, false, "ctrt_eff_dt", true, "", dfDateYmd, 0, false, false);
                    sheetObj.InitDataProperty(0, 7, dtData, 85, daCenter, false, "ctrt_exp_dt", true, "", dfDateYmd, 0, false, true);
                    sheetObj.InitDataProperty(0, 9, dtData, 120, daCenter, false, "tgt_mvc_qty", false, "", dfInteger, 0, false, true);
                    sheetObj.InitDataProperty(0,10, dtCombo, 60, daCenter, false, "cntr_lod_ut_cd",  false, "", dfNone,  0, false, true);
                }
                var idx = sheetObj.DataInsert();
                sheetObj.CellValue2(idx, "prop_no") = formObj.prop_no.value;
                sheetObj.CellValue2(idx, "amdt_seq") = formObj.amdt_seq.value;      
                sheetObj.CellValue2(idx, "prop_scp_ofc_cd") = formObj.in_usr_ofc_cd.value;          
                sheetObj.CellValue2(idx, "tgt_mvc_qty") = "0";               
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

                // MAIN의 SALE REP와 동일한 SALE REP으로 DEFAULT
                sheetObj.CellValue2(idx, "prop_scp_srep_cd") = formObj.prop_srep_cd.Text;
                
                sheetButtonImageChange(sheetObj,idx, 0);// 비활성
//                sheetObj.PopupButtonImage(idx, "gline_cp_flg_lnk") = 0;

                if(formObj.amdt_seq.value!=0){
                    sheetObj.CellFont("FontColor", idx, "chk", idx, "prop_scp_sts_cd")= sheetObj.RgbColor(255,0,0);
                }

                var preIbflag = sheetObjects[0].RowStatus(1);
                if (preIbflag == "R"){
                    sheetObjects[0].RowStatus(1) = "U";
                }
                sheetObj.SelectCell(idx, "svc_scp_cd");
                break;  
                
            case IBSAVE: // Save
            	ComOpenWait(true); //->waiting->start
                var sheetObj = sheetObjects[1];
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }      

                // proposal 여부를 포함하여 parameter 에 보내준다. main 관련 이외의 것들은 
                // proposal 이 아닌 경우는 건너뜀
                var mstAmdtSeq = formObj.amdt_seq.value;
        
                formObj.f_cmd.value = MULTI11; //변경- 이전 : MULTI01 
                var sParam = "";
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
                sParam += "&cpPriMnFlag=" + cpPriMnFlag;
                sParam += "&arbiExecSvcScpCd=" + guideExcepSvcScpCd.toString();
    			sParam += "&arbiAddOnType=" +  (Number(sheetObj.CellValue(1, "ctrt_eff_dt")) >= Number(addOnEndExpDt) ? 'Y' : 'N');
                var sXml = sheetObj.GetSaveXml("ESM_PRI_2003GS.do", sParam);                
                sheetObjects[0].LoadSaveXml(sXml);   
                sXml = ComDeleteMsg(sXml);//메세지를 하나만 보여주기 위하여
                sheetObjects[1].LoadSaveXml(sXml);    
                var formObj = document.form;
                if(formObj.rfa_no.value=="" && formObj.prop_no.value==""){           
                    formObj.prop_no.value = ComGetEtcData(sXml,"prop_no");          
                }
                //                if(cpPriMnFlag) {
//                	updateArbitraryGuideValue(sheetObjects[0]);
//                }  
        		saveSvcScpCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "svc_scp_cd");
        		doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);          
        		ComOpenWait(false); //->waiting->End
                break;         
            case IBDELETE: // Delete
                if (validateForm(sheetObj,document.form,sAction)) {         
                    deleteRowCheck(sheetObj, "chk" ,true);  
                }       
                break;    
                
            case COMMAND02: //REQUEST
            	ComOpenWait(true); //->waiting->start
    	        if (!validateForm(sheetObj,document.form,sAction)) {  
    	        	return false;
    	        }

    	        // Request Popup
    	        var sParam = "prop_no="+sheetObjects[0].CellValue(1,"prop_no")+"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");
    	        var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2007.do?"+sParam, "ESM_PRI_2007", 820, 405, true);
    	        if(str == null){
    	            return false;
    	        }
    	        
    	        formObj.f_cmd.value = MULTI02;
    	        sheetObjects[0].CellValue2(1,"prop_sts_cd") = "Q";
    	
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
    	        sParam += "&arbiExecSvcScpCd=" + guideExcepSvcScpCd.toString();

    	        var sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2003GS.do", sParam);
    	        sheetObjects[0].LoadSaveXml(sXml);	
    	        
    	        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	        ComOpenWait(false); //->waiting->End
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
                var sXml = sheetObj.GetSaveXml("ESM_PRI_2003GS.do", sParam);
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
            
                formObj.f_cmd.value = MULTI13;   //변경- 이전 : MULTI03;
                sheetObj.CellValue2(1,"prop_sts_cd") = "A";
                var sParam = "prop_no=" + sheetObjects[0].CellValue(1, "prop_no") +"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq");            
                sParam += "&"+ sheetObjects[0].GetSaveString(true);
                sParam += "&"+FormQueryString(formObj);
                var sXml = sheetObj.GetSaveXml("ESM_PRI_2003GS.do", sParam);
                sheetObjects[0].LoadSaveXml(sXml);
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComOpenWait(false); //->waiting->End
                break;    
                
            case COMMAND05: // Cancel
            	ComOpenWait(true); //->waiting->start
                var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            	var amdtSeq = formObj.amdt_seq.value;
            	var sXml = "";

            	if (amdtSeq =="0"){
        	        if (prop_sts_cd !="I" && !ComShowCodeConfirm("PRI01046")) {	//msgs['PRI01046'] = 'Do you want to cancel and return to previous status?';
        	            return false;
        	        }   
            	}else{
        	        if (!ComShowCodeConfirm("PRI01046")) {	//msgs['PRI01046'] = 'Do you want to cancel and return to previous status?';
        	            return false;
        	        }   
            	}            
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }    
                
                formObj.f_cmd.value = MULTI04;            
            
                switch(prop_sts_cd) {
                case 'I':   // Initial 모든 데이터 삭제
    	        	if (amdtSeq == "0"){
    	                if (!ComShowCodeConfirm("PRI01124")) {	//msgs['PRI01124'] = 'Do you want to delete this proposal?';
    	                    return false;
    	                }    
    	        	}else{
    	                if (!ComShowCodeConfirm("PRI01050")) {	//msgs['PRI01050'] = 'Do you want to delet all data in current Amend Sequence?';
    	                    return false;
    	                }    
    	        	}

                    sheetObj.CellValue2(1,"prop_sts_cd") = "D";     
                
                    var sParam = "";
                    
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }else{
                    	sheetObj.CellValue2(1,"prop_sts_cd") = "I";
                    	return false
                    }
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);// scope의모든 데이터를 넘긴다.
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }else{
                    	sheetObj.CellValue2(1,"prop_sts_cd") = "I";
                    	return false
                    }
                    sParam += "&" + FormQueryString(formObj);
                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2003GS.do", sParam);
                    
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
	            		if (checkRequestCancel() != "Y"){	            			
	            			return false;
	            		}
	            	}
	            	formObj.f_cmd.value = MULTI04; 
                    sheetObj.CellValue2(1,"prop_sts_cd") = "I";             
                         
                	var sParam = "";
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);             
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }               
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }       
                    sParam += "&" + FormQueryString(formObj);
                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2003GS.do", sParam);             
        
                    break;
                case 'R':   // Returned
                    sheetObj.CellValue2(1,"prop_sts_cd") = "Q";
                       
                	var sParam = "";
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                    var sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }            
                    sParam += "&" + FormQueryString(formObj);
                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2003GS.do", sParam);

                    break;
                case 'A':   // Approved
    	            var sParamSheet2 = sheetObjects[1].GetSaveString(true);// scope의모든 데이터를 넘긴다.
    	            if (sParamSheet2 == "") {
    	            	return;
    	            }
                
                    sheetObj.CellValue2(1,"prop_sts_cd") = "Q";
                        
                    var sParam = "";
                    var sParamSheet1 = sheetObjects[0].GetSaveString(true);
                    if (sParamSheet1 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
                    }
                     sParamSheet2 = sheetObjects[1].GetSaveString(true);             
                    if (sParamSheet2 != "") {
                        sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
                    }
                    sParam += "&" + FormQueryString(formObj);
                    sXml = sheetObjects[0].GetSaveXml("ESM_PRI_2003GS.do", sParam);
               
                    break;
        
                }   
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
        	if (sAction == IBSEARCH_ASYNC02 || sAction == IBDELETE || sAction == IBINSERT
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
//SPOT 주석 시킴
// 높이 설정
//style.height = 100;
            
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;         

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
                
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                
                var HeadTitle  = "|rfa_no|prop_no|amdt_seq|pre_amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|n1st_cmnc_dt|prc_prog_sts_cd"                 
                HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
                HeadTitle += "|ctrt_cust_cnt_cd|ctrt_cust_seq|ctrt_pty_nm|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|respb_sls_ofc_cd|respb_srep_cd|ctrt_cust_srep_nm|tgt_mvc_qty";
                HeadTitle += "|cntr_lod_ut_cd|unit|sls_ld_no|request user flag|approval user flag|all user flg|ctrt_eff_dt_ori|ctrt_exp_dt_ori"
                HeadTitle += "|prc_ctrt_cust_tp_nm|file_dt|prop_prpr_flg|createtype|prop_apro_staff|dur_dup_flg" 
                HeadTitle += "|dmdt_ft_tp_cd|so_kup|dmdt_ft_tp_cd_ori|apro_usr_flg_ori|act_cm|est_cm|cre_tp|copy_auth|upd_dt|rfa_ctrt_tp_cd"
                var headCount = ComCountHeadTitle(HeadTitle);               
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)    
   
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);    
                
                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_no", false, "", dfNone, 0, false, false);
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
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false); 
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_cnt_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_seq", false, "", dfNone, 0, false, false);
               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_val_sgm", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "respb_sls_ofc_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "respb_srep_cd", false, "", dfNone, 0, false, false);             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_cust_srep_nm", false, "", dfNone, 0, false, false);   
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "tgt_mvc_qty", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false);                                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "unit", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sls_ld_no", false, "", dfNone, 0, false, false);                 
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "req_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "apro_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "all_usr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt_ori", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_nm", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "file_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dur_dup_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dmdt_ft_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "so_kup", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dmdt_ft_tp_cd_ori", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "apro_usr_flg_ori", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);  
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "cre_tp", false, "", dfNone, 0, false, false);//이행데이터확인
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "copy_auth", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "upd_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, false);
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
    
                var HeadTitle =  "|Sel.|Seq.|Prop No.|Amendment Seq|SVC Scope|Duration|Duration|Duration|Target MQC|Unit";
                    HeadTitle += "|G/L Copy|Request Office|Sales Rep|Status|eff_dt|exp_dt|n1st_cmnc_dt|pre_exp_dt";
                    HeadTitle += "|Status|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|DUR_DUP_FLG|pre_ext_scp";
                var headCount = ComCountHeadTitle(HeadTitle);
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDummyCheck,  	40,  daCenter, false, "chk");
                InitDataProperty(0, cnt++, dtDataSeq, 		30,  daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "prop_no", 		  true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		90,  daLeft,   false, "amdt_seq", 		  true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtComboEdit, 	150, daCenter, false, "svc_scp_cd", 	  true,  "", dfNone, 	0, false, true, 3);                
                InitDataProperty(0, cnt++, dtData, 			130, daCenter, false, "ctrt_eff_dt", 	  true,  "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 			130, daCenter, false, "ctrt_exp_dt", 	  true,  "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, dtPopupEdit, 	20,  daCenter, false, "scp_dur_pop", 	  false, "", dfNone, 	0, true,  false);
                InitDataProperty(0, cnt++, dtHidden, 			110, daCenter, false, "tgt_mvc_qty", 	  false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  		60,  daCenter, false, "cntr_lod_ut_cd",   false, "", dfNone,    0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		60,  daCenter, false, "gline_cp_flg_lnk", false, "", dfNone, 	0, true,  false); //dtPopup
                InitDataProperty(0, cnt++, dtData, 			180, daCenter, false, "prop_scp_ofc_cd",  true,  "", dfNone, 	0, false, false); 
                InitDataProperty(0, cnt++, dtData,   		180, daCenter, false, "prop_scp_srep_cd", true,  "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtCombo,  		100, daCenter, false, "prop_scp_sts_cd",  false, "", dfNone, 	0, false, false, 100);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "eff_dt", 		  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "exp_dt", 		  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "n1st_cmnc_dt", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		95,  daCenter, false, "pre_exp_dt", 	  false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prop_scp_sts", 	  false, "", dfNone, 	0, false, false);                               
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "req_usr_flg", 	  false, "", dfNone, 	0, false, false);                
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "apro_usr_flg", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "prc_prog_sts_cd",  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "src_info_cd", 	  false, "", dfNone, 	0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		100, daCenter, false, "tgt_mvc_qty_ori",  false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		90,  daCenter, false, "dur_dup_flg", 	  false, "", dfNone, 	0, false, false);
                //이전 AMEND SEQ에 추가된 SCOPE확인
                InitDataProperty(0, cnt++, dtHidden, 		90,  daCenter, false, "pre_ext_scp", 	  false, "", dfNone, 	0, false, false);
                
                InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
                ShowButtonImage = 2;
                ImageList(0) = "img/btns_search_off.gif";
                ImageList(1) = "img/btns_search.gif";
                WaitImageVisible = false;
            }
            break;  
            
        case "sheet3": // Request 클릭시, Route 중에 term이 빠진 Location check
            with (sheetObj) {
//SPOT 주석 시킴        	
// 높이 설정
//style.height = 100;
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);    
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false, false)    
                var HeadTitle = "|SVC_SCP_CD|ORG_DEST_TP_CD|ROUT_PNT_LOC_DEF_CD";
                var headCount = ComCountHeadTitle(HeadTitle);
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                InitDataProperty(0, cnt++, dtHiddenStatus, 30,   daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "svc_scp_cd", 	  	 false,  "", dfNone,	0, false, false);                
                InitDataProperty(0, cnt++, dtData, 			200, daCenter, false, "org_dest_tp_cd",   	 false,  "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 			100, daCenter, false, "rout_pnt_loc_def_cd", false,  "", dfNone, 0, false, false); 
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
                InsertTab(-1, "Location Group",			cnt++);	//0
                InsertTab(-1, "Commodity Group",		cnt++);  //1
                InsertTab(-1, "Arbitrary",				cnt++);	//2
                InsertTab(-1, "Rate",					cnt++);	//3
                InsertTab(-1, "Special Note",			cnt++);	//4
                
                ShowIcon = true;
                UseLargeIcon = false;
                
                ImageUrl(0) = ICON_URL_NOT_EXIST;
                ImageUrl(1) = ICON_URL_NOT_EXIST;
                ImageUrl(2) = ICON_URL_NOT_EXIST;
                ImageUrl(3) = ICON_URL_NOT_EXIST;
                ImageUrl(4) = ICON_URL_NOT_EXIST;    
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
                }
                break;     
            case "respb_srep_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
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
//                    UseEdit = false;
                    // BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
//                    Style = 1;
                }
                break;   
            case "sls_ld_no":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                }     
                break; 
            case "dmdt_ft_tp_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
                }    
                break; 
            case "rfa_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    // BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    IMEMode = 0;
                    UseAutoComplete = true;
                    ValidChar(2, 0);
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

        var rfa_no = formObj.rfa_no.value;
        var prop_no = formObj.prop_no.value;
        var amdt_seq = formObj.amdt_seq.value;
        
        switch (sAction) {
        case IBSEARCH: // 조회    
            if (rfa_no == null && prop_no == null) {
                return false;
            }
            break;
            
        case IBCREATE: // New
            if(sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified){
                return ComPriClearChange;
            }
            break;
            
        case COMMAND02://REQUEST 
        	//Proposal number 확인
	    	if (formObj.prop_no.value ==""){
	            ComShowCodeMessage('PRI01021');		//msgs['PRI01021'] = 'Proposal number does not exist';
	            return;
	        } 
	    	
	    	//SPOT 한달내에 범위에서 유효함을 초과하면  메시지를 보여줌 (시작년도와 종료년도가 동일해야함)
    	    if(!spotDurationCheck()){
    	    	return false;
    	    }
    	    
	        /*
	    	1. Individual SVC Scope’s duration cannot exceed the main duraion';
	    	2. 예외 Service Scope가 포함되어 있는지 확인(Add-On Tariff 프로젝트에서 Guide Line 예외 Service Scope.)
	    	   예외 대상:'TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS'
	    	*/
	        if(!addOnTariffDurationCheck(amdt_seq, formObj)) {
	        	return false;
	        }
	        
	        //Port CY 운임에 입력한 Origin, Dest Location 을 체크하여  MDM에 call_port_flg가 'N' 인 location 이 있을 경우 메시지를 보여줌 
	        //Request Check : Rquest 처리 시 Port CY 운임에 Port 가 아닌 Route가 존재하는지 체크
	        if(!addOnTariffPortLocationCheck()) {
	        	return false;
	        } 
	        
            if(sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified){
            	ComShowCodeMessage('PRI01057');		//msgs['PRI01057'] = 'Updated data exists, Please save it first.';
            	return false;
            }
	         
	        /////////////////////////////////////////////////////////////////////
	        // update date 검사
            // 화면에서 계약번호로 조회 후 amend, request등의 이벤트를 일으키기전에 같은 계약번호로 다른 사용자가 먼저 데이타를 변경시켰는지 확인
	        var checkSheetObj = sheetObjects[0];
	        var checkTpCd = "CHECK1";
	        if( checkChangingUpdateDate(checkSheetObj, checkTpCd ) ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
	        var rValue = "";
	        if (formObj.rfa_no.value == "" && formObj.prop_no.value == "") {
	            return false;
	        }            
	        if (sheetObjects[1].RowCount == 0){
	            return false;
	        }  
	        
	        //RFA type 별로 actual customer check
/*	        if(sheetObjects[0].CellValue(1, "rfa_ctrt_tp_cd") == "C"){
		    	formObj.f_cmd.value = SEARCH22;
		        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", FormQueryString(formObj));
		        var check_rfa_act_cust = ComGetEtcData(sXml, "check_rfa_act_cust");
	        	if(check_rfa_act_cust != 0){
	        		ComShowCodeMessage("COM130201","the same Actual Customer at Commodity Group"); 
	        		// Rate tab focus
	        		tabObjects[0].SelectedIndex = 3;
	        		tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex);
	        		return false;
	        	}      	
	        }*/

	        //Route 중에 term이 빠진 Location check
	        formObj.f_cmd.value = SEARCH15;
	        var termCheckMsg = '';
	        var sXml = sheetObjects[2].GetSearchXml("ESM_PRI_2003GS.do", FormQueryString(formObj));
	        sheetObjects[2].LoadSearchXml(sXml);		        
	        if(sheetObjects[2].RowCount > 0){
	        	for(var i=sheetObjects[2].HeaderRows; i <= sheetObjects[2].LastRow; i++){
	        		termCheckMsg = termCheckMsg + '\n['
	        		             + sheetObjects[2].CellValue(i,'svc_scp_cd')+'-'
	        		             + sheetObjects[2].CellValue(i,'org_dest_tp_cd')+'-'
	        		             + sheetObjects[2].CellValue(i,'rout_pnt_loc_def_cd')+']';
	        	}
	        	if(termCheckMsg != ''){
	        		ComShowCodeMessage("PRI07054", termCheckMsg);	//msgs['PRI07054'] = 'Please input the Location term.\n[Scope-Origin or Destination-Location or Location Group]{?msg1}';
	        		// Rate tab focus
	        		tabObjects[0].SelectedIndex = 3;
	        		tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex);
	        		return false;
	        	}	        	
	        }
	        
	        if (!ComShowCodeConfirm("PRI01032","Request")){	//msgs['PRI01032'] = 'Do you want to proceed {?msg1}?';
	            return false;
	        }
	        
	        //Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
	        if(checkIHCRateAmt() != 'Y') {
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
	        //MAIN과 일치하는 SCOPE이 하나도 없을 경우
	        if (!ctrtDateMatch){
	             ComShowCodeMessage("PRI01096");	//msgs['PRI01096'] = 'Please check duration of each service scope.';
	        }                
	        
	        //####################
	        // calculate - Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다.
/*	        rValue = checkRequest();
	        if (rValue !="Y"){
	            return false;
	        }*/

	        /*
	            [DEM/DET CHECK]
	        	Request Dem/Det이 입력되어 있는지 확인한다.
	         	Exception : Dar Data가 없는 경우와 Dar Data가 있을 시 생성 된 Dar 중에   
	            				Request, C.offer, Approve, Reject 의 Status 가 하나도 없을 때는 Request금지  
	         	Tariff    : Dar Data가 있을때 생성 된 Dar 중에  
	            			 Request, C.offer, Approve의 Status 가 하나라도 있다면 Request 금지    
	        */               
/*	        if ( checkDmdtData() !="Y"){
	            return false;
	        }     */                      

	        //duration + DEM/DET check
	        // Duration(01) + Scope Duration(11) + DEM/DET Tariff Exception(08) - (조회시##CHECK) 
/*	        if ( checkDuration() =="Y"){
	            ComShowCodeMessage('PRI01092');	// msgs['PRI01092'] = 'RFA Duration is amended. Please amend related DAR Duration as well.';
	        } */
        	break;
        	
        case COMMAND03: // Counter Offer
            var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            var req_usr_flg = sheetObjects[0].CellValue(1, "req_usr_flg");
            var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
            
            if (apro_usr_flg!="Y"){
                ComShowCodeMessage('PRI01033','C/Offer');
                return false;
            }
                     
            // 모든 terms가 accept or return 인지 확인         
            var initCheck = checkCountOffer();
            if (initCheck !="Y"){
                ComShowCodeMessage('PRI01039');		//msgs['PRI01039'] = 'There is initial data.';
                return false;
            }       
            
            if (!ComShowCodeConfirm("PRI01032","C/Offer")){
                return false;
            }

          //status Request 일 경우에만 Approve 가능
            if (prop_sts_cd !="Q" ){
                ComShowCodeMessage('PRI01034');		//msgs['PRI01034'] = 'Please check status.';
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
    
            // 승인권한
            if (apro_usr_flg=="N"){
                ComShowCodeMessage('PRI01033','Approve');
                return false;
            }           
            
            if (!ComShowCodeConfirm("PRI01032","Approve")){
                return false;
            }
            //status Request 일 경우에만 Approve 가능
            if (prop_sts_cd !="Q" ){
                ComShowCodeMessage('PRI01034');
                return false;
            }
            
            var rValue = checkAccept();         
            // all accept일 경우 approve 활성화 C/offer 비활성화
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
            var prop_sts_cd = sheetObjects[0].CellValue(1, "prop_sts_cd");
            var amdtSeq = sheetObjects[0].CellValue(1, "amdt_seq");
                       
            switch(prop_sts_cd) {
                case 'I':   // Initial                
                	if (amdtSeq == "0"){
                		if (checkInitCancelDmdtData() == "Y"){
                			ComShowCodeMessage('PRI01116');
                			return false;
                		}                		
                	}                	
                    break;
                case 'A':   // Approved
                	if (checkApproveCancel() != "Y"){
                		return false;
                	}
                    break;
                    
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
            
            // 현재 amdt_seq에서 추가한 scope만 삭제할 수 있다.
            if (amdtSeq != "0"){        
                for (var i = 0; i < arrCheckedRows.length; i++){                    
                    if (effDt != sheetObj.CellValue(arrCheckedRows[i], "eff_dt")){
                        ComShowCodeMessage('PRI01036');
                        sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");// PRI01036
                        return false;
                    }
                    
                }
            }

            var rValue = "";
            for (var i = 0; i< arrCheckedRows.length; i++){ 
                rValue = checkScopeDelete(arrCheckedRows[i]);
                // Scope의 하부데이터가 없어야 삭제 할 수 있다.
                if (rValue != "Y"){
                    ComShowCodeMessage('PRI01051');
                    sheetObj.SelectCell(arrCheckedRows[i],"svc_scp_cd");
                    return false;
                }
            }

            break;          
        case IBSEARCH_ASYNC01: // 
            return true;
            if (comboObjects[0].Code == "" || comboObjects[2].Code == "") {
                return false;
            }
            if (formObj.cfm_flg.value != "No") {
                return false;
            }
            break;              
        case IBSAVE: // Save
            var formObj = document.form;
            if(!ComChkRequired(document.form)){
                return false;
            }
            
/*            if (comboObjects[0].Code == "") {
                ComShowCodeMessage('PRI00316','Sale Rep.'); 
                comboObjects[0].focus();
                return false;
            }*/
            
            //respb_sls_ofc_cd
/*            if (formObj.respb_sls_ofc_cd.value ==""){
            	ComShowCodeMessage('PRI00316','Customer Sale Rep Office');
            	comboObjects[2].focus();
            	return false;
            }*/
            
/*            if (comboObjects[2].Code == "" || comboObjects[2].Code == " ") { //[CHM-201323648] 빈 칸을 선택해도 validation 처리 되도록 함
                ComShowCodeMessage('PRI00316','Customer Sale Rep.'); 
                comboObjects[2].focus();
                return false;
            }*/  
            
/*            if (comboObjects[5].Code == "") {
                ComShowCodeMessage('PRI00316','Free Time'); 
                comboObjects[5].focus();
                return false;
            }*/
           
        	//SPOT 한달내에 범위에서 유효함을 초과하면  메시지를 보여줌 (시작년도와 종료년도가 동일해야함) 
    	    if(!spotDurationCheck()){
    	    	return false;
    	    }
			
	        /*
	    	1. Individual SVC Scope’s duration cannot exceed the main duraion';
	    	2. 예외 Service Scope가 포함되어 있는지 확인(Add-On Tariff 프로젝트에서 Guide Line 예외 Service Scope.)
	    	   예외 대상:'TPE','TPW','ACE','ACW','TAE','TAW','ASE','ASW','MMW','MME','SAN','SAS','CAN','CAS','CSE','CME','MWS','MWN','CCS','CCN','CLN','CLS'
	    	*/
    	    if(!addOnTariffDurationCheck(amdt_seq, formObj)) {
            	 return false;
            }
        
            if(!sheetObjects[0].IsDataModified &&!sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI00301');  //msgs['PRI00301'] = 'There is no data to save.';
                return false;
            }   
            var rowM = sheetObjects[1].ColValueDup("svc_scp_cd", false);             
            if (rowM >= 0) {
                 ComShowCodeMessage("PRI00303", "Sheet", rowM); // msgs['PRI00303'] = 'Duplicate data found in seq. no. {?msg2} in [{?msg1}].';
                 return false;
            }
             
            //MQC chk 
            /*
             var mainMqc = sheetObjects[0].CellValue(1, "tgt_mvc_qty");
            
            var subMqc = 0;
            var sheetObj = sheetObjects[1];
            for (var i = 1; i <= sheetObj.RowCount; i++){
                subMqc += ComParseInt(sheetObj.CellValue(i, "tgt_mvc_qty_ori")); //sheet2 - Service Scope
                if (sheetObj.CellValue(i,"tgt_mvc_qty") != sheetObj.CellValue(i,"tgt_mvc_qty_ori") ){
                    subMqc += ComParseInt(sheetObj.CellValue(i, "tgt_mvc_qty")) - ComParseInt(sheetObj.CellValue(i, "tgt_mvc_qty_ori"));
                }           
            }
	        //RFA type : Contract 일때
	        if(sheetObjects[0].CellValue(1, "rfa_ctrt_tp_cd") == "C"){            	
	        	// 1. target MVC != 0
	        	if(sheetObjects[0].CellValue(1, "tgt_mvc_qty") == "" || sheetObjects[0].CellValue(1, "tgt_mvc_qty") == "0"){
	        		ComShowCodeMessage("COM130201","the target MVC");                 
	        		return false;
	        	}
	        	// 2. target MQC != 0
	        	for (var i = sheetObjects[1].HeaderRows ; i <= getValidRowCount(sheetObjects[1]); i++){
		        	if(sheetObjects[1].CellValue(i, "tgt_mvc_qty") == "0"){
		        		ComShowCodeMessage("COM130201","the target MQC"); 
		        		return false;
		        	}
	        	}
	        }
            // Duration 이 한달 이상일 경우 
        	if (sheetObjects[0].CellValue(1,"amdt_seq") == "0"){
             	if(sheetObjects[0].CellValue(1,"ctrt_eff_dt") != "" && sheetObjects[0].CellValue(1,"ctrt_exp_dt") != "" && parseInt(sheetObjects[0].CellValue(1, "ctrt_exp_dt")) - parseInt(sheetObjects[0].CellValue(1, "ctrt_eff_dt")) >= 30){
             		if(sheetObjects[0].CellValue(1, "rfa_ctrt_tp_cd") == "C"){
	                    if (!ComShowCodeConfirm("PRI07048")) {	//msgs['PRI07048'] = 'Are the RATEs confirmed by HO?';
	                        return false;
	                    }
             		}else{
	                    if (!ComShowCodeConfirm("PRI07049")) {	//msgs['PRI07049'] = 'Are you sure that spot rate?';
	                        return false;
	                    }
             		}
             	}
        	}      
        	
        	//Contract Type 이고 amend가 1회차 이상일 경우에는 새로운 scope이 추가되어 MQC가 늘어날 경우 그대로 통과하도록 함 by. 정석환
            if ( sheetObjects[0].CellValue(1,"amdt_seq") == "0" || sheetObjects[0].CellValue(1, "rfa_ctrt_tp_cd") != "C" ){
            	 if ((subMqc - mainMqc) > 0){
                 ComShowCodeMessage("PRI01008"); // msgs['PRI01008'] = 'MQC sum of SVC Scope(s) should be less than main MQC.';               
                 return false;
            	 }
            }
            */
            if (!ComPriConfirmSave()) {	//msgs['PRI00001'] = 'Do you want to save?';
                return false;
            } 
            if (!saveChangeDuration("false")){
                return false;
            }
            break;
            
        }
        return true;
    } 
    
    /** 
     * SPOT 시 start date 와 end date가 같은 년도를 초과하면  메시지를 보여줌 
     *
     **/    
    function spotDurationCheck(){
        var ctrtEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
        var ctrtExpDt = sheetObjects[0].CellValue(1, "ctrt_exp_dt");
        
        var tmpInterval = ComGetDaysBetween(ctrtEffDt,ctrtExpDt);
    	if(!ComIsDate(ctrtEffDt)||!ComIsDate(ctrtExpDt)){                              
    	    ComShowCodeMessage('COM12132');                            
    	    return false;                                                     
    	} else {                                                             
    	    if(tmpInterval<0){                                               
    	    	ComShowMessage('End date must be greater than start date.'); 
    	    	return false;                                                    
    	    }                               
    	}

    	if(ComIsDate(ctrtEffDt) && ctrtEffDt.length == 8){
        	var tmpEffYear = ctrtEffDt.substring(0,4);
        	var tmpExpYear = ctrtExpDt.substring(0,4);
//        	alert("tmpEffYear:"+tmpEffYear + " , tmpExpYear:"+tmpExpYear );
        	
        	if(tmpEffYear != tmpExpYear){
        		ComShowMessage('Effective date and expiration date should be within the same year.'); 
       		 	return false;
        	}     	
        	
        }
        
    	return true;
    }

    
    function addOnTariffDurationCheck(amdt_seq, formObj) {
	    var rowCnt = getValidRowCount(sheetObjects[1]);
	    var ctrtEffDt = sheetObjects[0].CellValue(1, "ctrt_eff_dt");
	    var ctrtExpDt = sheetObjects[0].CellValue(1, "ctrt_exp_dt");
	    var ctrtEffDtTo = ComGetUnMaskedValue(sheetObjects[0].CellValue(1, "ctrt_eff_dt"),"ymd");
	    var ctrtEffDtOri = ComGetUnMaskedValue(sheetObjects[0].CellValue(1, "ctrt_eff_dt_ori"),"ymd");
	    var sheet2 = sheetObjects[1];
	    
	    var excepSvcScpCd_Cnt = 0;
	    for (var i = 1; i <= rowCnt; i++){
	    	var effDt = ComGetUnMaskedValue(sheet2.CellValue(i, "ctrt_eff_dt"),"ymd");
	    	var expDt = ComGetUnMaskedValue(sheet2.CellValue(i, "ctrt_exp_dt"),"ymd");
	    	var svcScpCd = sheet2.CellValue(i, "svc_scp_cd");
	    	//msgs['PRI01003'] = 'The duration of this {?msg3} is {?msg1} ~ {?msg2}.\nIndividual SVC Scope’s duration cannot exceed the main duraion';
	    	if (effDt != "" && expDt != ""){
	        	if (effDt < ctrtEffDt){            		
	        		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"RFA");		
	        		sheet2.SelectCell(i, "ctrt_eff_dt");
	        		return false;
	        	}
	        	if (expDt > ctrtExpDt){            		
	        		ComShowCodeMessage("PRI01003",ComGetMaskedValue(ctrtEffDt,"ymd","-"),ComGetMaskedValue(ctrtExpDt,"ymd","-"),"RFA");
	        		sheet2.SelectCell(i, "ctrt_exp_dt");
	        		return false;
	        	}
	    	}
	    	//예외 Service Scope가 포함되어 있는지 확인
	    	if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
	    		excepSvcScpCd_Cnt ++;
	    	}
	    }   
	    
	    
	    
	    /**
	     * 202.05.25일 추가
	     * AMD No. == 0 이고 Status가 Initial 인 경우 저장 안되게...
	     * START
	     */
	    var propStsCd = sheetObjects[0].CellValue(1, "prop_sts_cd");
	    var mnStatus = sheetObjects[0].RowStatus(1);         // 최초 insert시에는 해당 로직을 skip한다.   
	    if(amdt_seq == 0 && propStsCd == 'I'  ) {
	    	//예외 Service Scope만 가진 경우는 Duration Check 제외.
	    	if(excepSvcScpCd_Cnt != rowCnt ) {
		    	if(!saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, addOnEndExpDt, 'PRI07039')) {
		    		return false;
		    	}
		    	if(sheet2.FindText("svc_scp_cd", 'AEE') > -1 || sheet2.FindText("svc_scp_cd", 'AEW') > -1) {
		    		if(!saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, endExpDt, 'PRI07009')) {
		        		return false;
		        	}
		    	}
		    	if(!checkDurationBeforeData()) {
	    			return false;
	    		}
	    	} 
	    }	             
	    
	    if (rowCnt <= 0){
	        ComShowCodeMessage('PRI01029'); 
	        return false;
	    }  
	    return true;     	
    }  
    
    
     /** Port CY 운임에 입력한 Origin, Dest Location 을 체크하여 
     * MDM에 call_port_flg가 'N' 인 location 이 있을 경우 메시지를 보여줌 
     *
     **/
    function addOnTariffPortLocationCheck(){    	
    	 var formObj = document.form;
         var sheetObj = sheetObjects[0]        
         formObj.f_cmd.value = SEARCH21;         
         var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq")+ "&" + FormQueryString(formObj) ; 
         var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);    
         var arrData = ComPriXml2Array(sXml, "etc1");
  
         //SELECT A1.SVC_SCP_CD ||'-'|| 'Bullet No.'||A2.BLET_DP_SEQ || '-'|| DECODE(A1.ORG_DEST_TP_CD, 'O', 'Origin', 'Dest.')|| '-' || A1.ROUT_PNT_LOC_DEF_CD AS ETC1
         
         if (arrData != null && arrData.length > 0) {  
        	 for(i=0; i < arrData.length;i++){
        		 if(i==0){
        			 arrData[i] = arrData[i];
        		 }else{
        			 arrData[i] = "\n " + arrData[i];
        		 }
        	 }        	 
        	 ComShowCodeMessage('PRI00308','input at "Rate of including IHC".\n', arrData );  //msgs['PRI00308'] = 'Please {?msg1} {?msg2}.';
        	 return false;
         } else {
     		return true; 
         } 
         return true;
    }      
    
         /**
    	 * Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
    	 */
    	function checkIHCRateAmt() {
            var formObj = document.form;
            var sheetObj = sheetObjects[0]
            var rValue = 'N';                          
            formObj.f_cmd.value = SEARCH20;
            var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ; 
            var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);        
            rValue = ComGetEtcData(sXml, "RSLT");
            if(rValue != '') {
            	ComShowCodeMessage('PRI07024', rValue);	//msgs['PRI07024'] = 'Please input the IHC amount on Door term.\n[Scope-CMDT bullet-Origin or Destination]\n[{?msg1}].';
            	rValue = 'N';
            }  else {
            	rValue = 'Y';
            }
            return rValue;
    	}

    /**
     * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다. <br>
     * <br>
     * <b>Example :</b>
     * 
     * <pre>
     * tab1_OnChange(tabObj, tabIndex)
     * </pre>
     * 
     * @param {tabObj} tabObj 필수 IBTab Object
     * @param {int} tabIndex 필수 프로세스 플래그 상수
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */
    function tab1_OnChange(tabObj, tabIndex) {
    	if (beforetab != tabIndex) {
    		var toIndex = getFrameTabId(tabIndex);
    		for ( var i = 1; i <= tabDivCount; i++) {
    			document.getElementById("tabLayer" + i).style.display = 'none';
    		}
    		document.getElementById(toIndex.divIndex).style.display = 'inline';
    	}

    	beforetab = tabIndex;
    	loadTabPage(tabIndex);
    }

    /**
     * 2012.09.20일 추가 Tab에 따른 Tab Lay 밑 URL 설정
     *  Spot Guide
     * @param tabIndex
     */
    function getFrameTabId(tabIndex) {
    	var frameId = "";
    	var sUrl = "";
    	var divIndex = "";

		switch (tabIndex) {
    	case 0: {
    		frameId = "t1frame";
    		sUrl = "ESM_PRI_2103_02.do";	//Location
    		divIndex = "tabLayer1";
    		break;
    	}
    	case 1: {
    		frameId = "t2frame";
    		sUrl = "ESM_PRI_2103_03.do";	//Commodity
    		divIndex = "tabLayer2";
    		break;
    	}
    	case 2: {
    		/*var index = checkArbiRate();
    		if (index == 0) {
    			frameId = "t3frame";
    			sUrl = "ESM_PRI_2103_04.do";	//Arbitrary Charge
    			divIndex = "tabLayer3";
    		} else if (index == 1) {
    			frameId = "t4frame";
    			sUrl = "ESM_PRI_2103_05.do";	//Arbitrary(AEW/AEE)
    			divIndex = "tabLayer4";
    		} else if (index == 2) {
    			frameId = "t8frame";
    			sUrl = "ESM_PRI_2103_12.do";	//Arbitrary(AddOn)
    			divIndex = "tabLayer8";
    		}*/
    		// SPOT ONLY
			frameId = "t8frame";
			sUrl = "ESM_PRI_2103_12.do";	// Arbitrary
			divIndex = "tabLayer8";
    		break;
    	}
    	case 3: {
    		/*var index = checkArbiRate();
    		if (index == 0) {
    			frameId = "t5frame";
    			sUrl = "ESM_PRI_2103_07.do";	//Rate
    			divIndex = "tabLayer5";
    		} else if (index == 1) {					//if (addOnEndExpDt > expDt  && expDt > endExpDt && ("AEW" == svcScpCd || "AEE" == svcScpCd)) {
    			frameId = "t6frame";
    			sUrl = "ESM_PRI_2103_08.do";	//Rate(AEW/AEE)
    			divIndex = "tabLayer6";
    		} else if (index == 2) {					// if(addOnEndExpDt <= expDt) {
    			frameId = "t9frame";
    			sUrl = "ESM_PRI_2103_13.do";	//Rate(AddOn)
    			divIndex = "tabLayer9";			
    		}*/
    		//SPOT ONLY
    		frameId = "t5frame";
			sUrl = "ESM_PRI_2103_07.do";	//Rate
			divIndex = "tabLayer5";
			
    		break;
    	}
    	case 4: {
    		frameId = "t7frame";
    		sUrl = "ESM_PRI_2103_01.do";	//Special Note
    		divIndex = "tabLayer7";
    		break;
    	}
    	}
    	var obj = new Object({
    		'frame' : frameId,
    		'url' : sUrl,
    		'divIndex' : divIndex
    	});
    	return obj;
    }

//    /**
//     * Tab Text변경
//     */
//    function setTabText() {
//    	var index = checkArbiRate();
//    	if (index == 0 || index == 2) {
//    		tabObjects[0].TabText(2) = "Arbitrary";
//    		tabObjects[0].TabText(3) = "Rate";
//    	} else if (index == 1) {
//    		tabObjects[0].TabText(2) = "Arbitrary For AEE/AEW";
//    		tabObjects[0].TabText(3) = "Rate For AEE/AEW";
//    	} 
//    }

    /**
     * Hinterland Project에 따른 Arbitrary/Rate 구분
     */
    /*
    function checkArbiRate() {
    	var rsltIndex = 0;
    	var sheetObj2 = sheetObjects[1];
    	var sRow = sheetObj2.SelectRow;
    	var svcScpCd = sheetObj2.CellValue(sRow, 'svc_scp_cd');
    	var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
    	
    	if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
    		rsltIndex = 0;
    	} else {
	     	if (addOnEndExpDt > expDt  && expDt > endExpDt && ("AEW" == svcScpCd || "AEE" == svcScpCd)) {
	    		rsltIndex = 1;
	    	} else if(addOnEndExpDt <= expDt) {
	    		rsltIndex = 2;
	    	} else {
	    		rsltIndex = 0;
	    	}
    	}
    	return rsltIndex;
    }
    */
    
    /**
     * TabPage 설정
     * 
     * @param tabIndex
     * @param selRow
     * @returns {Boolean}
     */
    function loadTabPage(tabIndex, selRow) {
    	if (tabIndex == null || tabIndex == "") {
    		tabIndex = tabObjects[0].SelectedIndex;
    	}

    	//javascript error 발생으로 아래 추가
		if(tabIndex < 0 ){
			return false;
		}

		var obj = getFrameTabId(tabIndex);
    	var objTabWindow = document.getElementById(obj.frame).contentWindow;
    	
    	if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
    		objTabWindow.location.href = obj.url;
    		return true;
    	}

    	var sheetObj1 = sheetObjects[0];
    	var sheetObj2 = sheetObjects[1];
    	var sRow = sheetObj2.SelectRow;
    	if (selRow != null && selRow != undefined) {
    		sRow = selRow;
    	}
    	var sPropNo = sheetObj2.CellValue(sRow, "prop_no");
    	var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
    	var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");
    	var sPreAmdtSeq = sheetObj1.CellValue(1, "pre_amdt_seq");
    	var sPropStsCd = sheetObj1.CellValue(1, "prop_sts_cd");
    	var sEffDt = sheetObj2.CellValue(sRow, "eff_dt");
    	var sExpDt = sheetObj2.CellValue(sRow, "exp_dt");
    	var sPreExpDt = sheetObj2.CellValue(sRow, "pre_exp_dt");
    	var sIsReqUsr = sheetObj1.CellValue(1, "req_usr_flg") == "Y" ? true : false;
    	var sIsAproUsr = sheetObj1.CellValue(1, "apro_usr_flg") == "Y" ? true : false;
    	var sDurDupFlg = sheetObj2.CellValue(sRow, "dur_dup_flg");
    	var sCtrtEffDt = sheetObj1.CellValue(1, "ctrt_eff_dt");
    	var sCtrtExpDt = sheetObj1.CellValue(1, "ctrt_exp_dt");
    	if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sPreAmdtSeq != null && sPreAmdtSeq != "" && sPropStsCd != null
    			&& sPropStsCd != "" && sEffDt != null && sEffDt != "" && sPreExpDt != null && sPreExpDt != "" && sheetObj2.CellValue(sRow, "ibflag") != "I") {
    		document.getElementById(obj.frame).contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sCtrtEffDt, sCtrtExpDt);
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
    	for ( var i = 0; i < tabObjects[0].GetCount(); i++) {
    		tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
    	}

    	for ( var i = 1; i <= tabDivCount; i++) {
    		if (document.getElementById("t" + i + "frame").contentWindow.tabClearSheet) {
    			document.getElementById("t" + i + "frame").contentWindow.tabClearSheet();
    		}
    	}
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
        document.images("img_affil").src = ICON_URL_NOT_EXIST;
        document.images("img_dmdt").src = ICON_URL_NOT_EXIST;
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
        formObj.rfa_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        comboObjects[0].Index = -1;
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";        
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";   
        formObj.ctrt_cust_val_sgm.value="";
        formObj.respb_sls_ofc_cd.value="";
        comboObjects[2].Index = -1;         
        formObj.ctrt_cust_srep_nm.value="";
        formObj.tgt_mvc_qty.value="";
        comboObjects[3].Index = -1; 
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";        
        formObj.prs_crnt_cm_amt.value = "";
        formObj.prs_estm_cm_amt.value = "";
        formObj.prs_sum_cm_amt.value = "";        
        formObj.sale_lead_ori.value = "";
        
        // 로딩시 Arbitrary 탭 Disable
        setTabEnable(2, false);
    }
    
    /**
     * sheet의 팝업버튼이미지를 변경한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     clearAllForms()
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
    }

    /**
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
        var req_usr_flg  = sheetObjects[0].CellValue(1, "req_usr_flg");
        var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
        var all_usr_flg = sheetObjects[0].CellValue(1, "all_usr_flg");
        //Retor active일 경우 원래가지고 있던 권한
        var aproUsrFlgOri = sheetObjects[0].CellValue(1, "apro_usr_flg_ori");

        //aproUsrFlgOri
        var scp_req_usr_flg = "";
        var scp_apro_usr_flg = "";
        var amdt_seq = sheetObjects[0].CellValue(1, "amdt_seq");        
        var sheetObj = sheetObjects[1];
 
        scp_req_usr_flg = req_usr_flg;
        scp_apro_usr_flg = apro_usr_flg;     

        try{
            ComBtnEnable("btn_retrieve");
            ComBtnEnable("btn_new");
            ComBtnEnable("btn_save");
            ComBtnDisable("btn_amend");
            btnImgEnable(formObj.btns_calendar1, false);            
            ComBtnDisable("btn_request");             
            ComBtnDisable("btn_coffer");  
            ComBtnDisable("btn_approve");            
            ComBtnDisable("btn_cancel");            
            ComBtnEnable("btn_copy");     
            ComBtnEnable("btn_print"); 
            ComBtnDisable("btn_rowadd");            
            ComBtnDisable("btn_delete");                        
            ComBtnDisable("btn_dem_pop"); 
            document.getElementById("btn_dem").style.color = "";
            ComBtnEnable("btn_free_pop"); 
            document.getElementById("btn_free").style.color = "black";
            ComBtnEnable("btn_afil_pop"); 
            document.getElementById("btn_afil").style.color = "black";

            ComBtnEnable("btn_dur_pop");            
            document.getElementById("btn_dur").style.color = "black";
            
            btnImgEnable("btn_mqc_estimate",false);
            
      
            formObj.ctrt_eff_dt.readOnly = false;
            formObj.ctrt_exp_dt.readOnly = false;            
            formObj.dmdt_ft_tp_cd.enable = false;
            
            //작성자  Initial, Request Cancel 할수있다.
            //Retro Active aproUsrFlgOri
            if ((req_usr_flg =="Y" && sts=="Q") || apro_usr_flg =="Y" || aproUsrFlgOri=="Y"){
            	ComBtnEnable("btn_cancel");           	
            }  

            formObj.prop_ofc_cd.readOnly = true; //Proposal Requect Office        
            formObj.prop_srep_cd.enable = false; //Proposal Sales Rep
            formObj.ctrt_cust_cnt_cd.readOnly = true; //Customer Code
            formObj.ctrt_cust_seq.readOnly = true;
            btnImgEnable(formObj.btn_ctrt_cust, false);
            formObj.respb_srep_cd.enable = false;//Customer Sales Rep
            formObj.tgt_mvc_qty.readOnly = true;
            // 변경가능 조건 : Amend 0, initial 상태            
			if( formObj.prop_sts.value == "Initial" && formObj.amdt_seq.value == 0 ) { 
			    formObj.cntr_lod_ut_cd.enable = true;
			} else {
				formObj.cntr_lod_ut_cd.enable = false;
			}
			 
            formObj.sls_ld_no.enable = false;
            formObj.rfa_ctrt_tp_cd.enable = false;
            changeDmdtBtnStatus();
            if(req_usr_flg !="Y" && apro_usr_flg !="Y"){
                //모든권한 없음...
                btnImgEnable(formObj.btns_calendar1, false);
                formObj.ctrt_eff_dt.readOnly = true;
                formObj.ctrt_exp_dt.readOnly = true;    
                formObj.prop_srep_cd.enable = false;
                if (formObj.prop_sts.value == "") {
                	ComBtnEnable("btn_save");
                }else{
                	ComBtnDisable("btn_save");
                }
                if (sheetObj.CellValue(1, "copy_auth") == "N" ){
                	ComBtnDisable("btn_copy");	
                	ComBtnDisable("btn_print");
                }
                 
        		for (var i = 1; i <= sheetObj.RowCount;i++){    
        			//sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
        		   // sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
        		    if (amdt_seq == "0"){
        		    	sheetObj.CellEditable(i, "scp_dur_pop") = false;
        		    	sheetButtonImageChange(sheetObj,i, 0);// 비활성
        		    }else{
        		    	sheetObj.CellEditable(i, "scp_dur_pop") = true;
        		    	sheetButtonImageChange(sheetObj,i, 1);// 활성
        		    }
        		}                     
                
                return;
            }           
            for (var i = 1; i <= sheetObj.RowCount; i++){
                sheetButtonImageChange(sheetObj,i, 1);// 활성
            }
            switch(sts) {
                case 'I':   // Initial                    
                    if(req_usr_flg=="Y"||apro_usr_flg=="Y"){                 
                        if (formObj.prop_no.value !=""){
                            ComBtnEnable("btn_request");
                            ComBtnEnable("btn_cancel");
                            btnImgEnable("btn_mqc_estimate",true);
                        }               
                        ComBtnEnable("btn_rowadd");         
                        ComBtnEnable("btn_delete");
                        
                        if(amdt_seq == "0"){
                            btnImgEnable(formObj.btns_calendar1, true);                             
                            ComBtnDisable("btn_free_pop"); 
                            ComBtnDisable("btn_dur_pop");
                        } else {
                            //duration
                            ComBtnEnable("btn_dur_pop");                            
                            document.getElementById("btn_dur").style.color = "black";   
                        }
                    }
                    break;
                    
                case 'Q':   // Requested               
                    if (amdt_seq =="0"){            
                        ComBtnDisable("btn_dur_pop");
                        ComBtnDisable("btn_free_pop");
                        ComBtnDisable("btn_dur_pop");                           
                    }           
                    if(apro_usr_flg=="Y"){                    
                        var rValue = checkAccept(); 
                        // all accept일 경우 approve 활성화 C/offer 비활성화
                        if (rValue == "Y"){
                            ComBtnEnable("btn_approve"); 
                            ComBtnDisable("btn_coffer");    
                        }else{
                            ComBtnDisable("btn_approve");
                            ComBtnEnable("btn_coffer"); 
                        }                                            
                    }              

                    formObj.ctrt_eff_dt.readOnly = true;    // duration
                    formObj.ctrt_exp_dt.readOnly = true;
                    formObj.dmdt_ft_tp_cd.enable = false;
                    break;                    
                    
                case 'A':   // Approved
                    ComBtnEnable("btn_amend");	                  
                    if (amdt_seq =="0"){            
                        ComBtnDisable("btn_free_pop");
                        ComBtnDisable("btn_dur_pop");
                    }

                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;
                    formObj.dmdt_ft_tp_cd.enable = false;      
                    break;    
                    
                case 'R':   // Returned                
                    if (amdt_seq =="0"){
                        ComBtnDisable("btn_dur_pop");
                        ComBtnDisable("btn_free_pop");
                    }                
	                if(req_usr_flg=="Y" ){   
	                	btnImgEnable("btn_mqc_estimate",true);
	                }
                	ComBtnEnable("btn_request");
                    formObj.ctrt_eff_dt.readOnly = true;    // duration
                    formObj.ctrt_exp_dt.readOnly = true;                             
                    formObj.dmdt_ft_tp_cd.enable = false;   
                    break;
           
            }   
            otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
            sheetControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);

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
    *    otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
    * </pre>
    * @param   {string} sts 필수          메인의 상태코드
    * @param   {string} amdt_seq 필수     amend seq Number
    * @param   {string} req_usr_flg 필수  화면에대한 작성자권한 <br>
    *                   Y : 작성자 권한 있음
    *                   N : 작성자 권한 없음
    * @param   {string} apro_usr_flg 필수 화면에대한 승인권한 <br>
    * 					Y : 승인권한 있음
    * 					N : 승인권한 없음
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function otherFormControl(sts,amdtSeq,reqUsrFlg,aproUsrFlg){
        var formObj = document.form;

    	switch (sts){
	    	case "I":
	    		if (amdtSeq =="0"){
	    			formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
	    			
	    	        formObj.ctrt_cust_cnt_cd.readOnly = false; //Customer Code
	    	        formObj.ctrt_cust_seq.readOnly = false;
	    	        
	    	        btnImgEnable(formObj.btn_ctrt_cust, true);
	    	        formObj.respb_srep_cd.enable = true;//Customer Sales Rep
	    	        formObj.sls_ld_no.enable = true;
	    	        
                    formObj.ctrt_eff_dt.readOnly = false;
                    formObj.ctrt_exp_dt.readOnly = false;
                    formObj.dmdt_ft_tp_cd.enable = true;
                    formObj.rfa_ctrt_tp_cd.enable = true;
    	            formObj.tgt_mvc_qty.readOnly = false;
    	            formObj.tgt_mvc_qty.setAttribute("className","input");
	    		}else{
	    			if (aproUsrFlg == "Y" || reqUsrFlg =="Y" ){ //Request User도 S.rep 변경 가능 [CHM-201323523]
	    				formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
	    				formObj.respb_srep_cd.enable = true;//Customer Sales Rep
	    			}
                    formObj.ctrt_eff_dt.readOnly = true;
                    formObj.ctrt_exp_dt.readOnly = true;   
                    formObj.dmdt_ft_tp_cd.enable = false;
                    if (comboObjects[1].Code =="C"){
	                    formObj.tgt_mvc_qty.readOnly = true; 
	                    formObj.tgt_mvc_qty.setAttribute("className","input2");
                    }else{
        	            formObj.tgt_mvc_qty.readOnly = false;
        	            formObj.tgt_mvc_qty.setAttribute("className","input");
        	            formObj.cntr_lod_ut_cd.enable = true;
                    }
	    		} 		
	    		break;
	    	case "Q":	
				if (aproUsrFlg == "Y"){ 
					formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
					formObj.respb_srep_cd.enable = true;//Customer Sales Rep
				}
	    		break;
	    	case "R":  	
				if (aproUsrFlg == "Y" ){ 
					formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
					formObj.respb_srep_cd.enable = true;//Customer Sales Rep
				}
	    		break;
	    	case "A":
				if (aproUsrFlg == "Y" ){ 
					formObj.prop_srep_cd.enable = true; //Proposal Sales Rep
					formObj.respb_srep_cd.enable = true;//Customer Sales Rep
				}
	    		break;

    	}
    	
    }
    
    
    /**
    * IBSheet의 Cell을  메인의 상태에 따라 활성,비활성화 한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    otherFormControl(sts,amdt_seq,req_usr_flg,apro_usr_flg);
    * </pre>
    * @param   {string} sts 필수          메인의 상태코드
    * @param   {string} amdtSeq 필수     amend seq Number
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
    	
    	/** 2012.05.22 추가 -START */
    	var expDt =  ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
    	/** 2012.05.22 추가 -END */
    	
    	if (stsCd == "I"){
            if (amdtSeq == "0"){
                for (var i = 1; i <= sheetObj.RowCount;i++){ 
                    sheetObj.CellEditable(i, "scp_dur_pop") = false;                                    
                    sheetObj.CellEditable(i,"tgt_mvc_qty") = true;
                    sheetObj.CellEditable(i,"cntr_lod_ut_cd") = true;
                    sheetObj.CellEditable(i,"ctrt_eff_dt") = true;
                    sheetObj.CellEditable(i,"ctrt_exp_dt") = true;
					
	                var svcScpCd = sheetObj.CellValue(i, 'svc_scp_cd');
	                /**
					 * 2012.11.22일 수정 
					 * 예외 Service Scope을 제외한 나머지 Scope은 G/L Copy 비활성화.
					 */
/*	                if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
	                	sheetObj.CellEditable(i, "gline_cp_flg_lnk") = true;
		                sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 1;
	                } else {
	                	sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
			            sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
	                }*/
					
	                sheetButtonImageChange(sheetObj,i, 0);// 비활성
	                /** 2012.05.22 추가 -END */
                }
            } else {
                for (var i = 1; i <= sheetObj.RowCount;i++){                                    
                    sheetObj.CellEditable(i, "ctrt_eff_dt") = false;
                    if(sheetObjects[0].CellValue(1, "rfa_ctrt_tp_cd")=="C"){
                        sheetObj.CellEditable(i, "tgt_mvc_qty") = false; 
                        sheetObj.CellEditable(i, "cntr_lod_ut_cd") = false;
                    }else{
                        sheetObj.CellEditable(i, "tgt_mvc_qty") = true; 
                        sheetObj.CellEditable(i, "cntr_lod_ut_cd") = true;
                    }
                    if(sheetObj.CellValue(i,"ctrt_eff_dt") == sheetObjects[0].CellValue(1,"eff_dt")){
                        sheetObj.CellEditable(i, "ctrt_exp_dt") = true;
                    } else{
                        sheetObj.CellEditable(i, "ctrt_exp_dt") = false;
                    }      
	                /**
					 * 2012.11.22일 수정 
					 * 예외 Service Scope을 제외한 나머지 Scope은 G/L Copy 비활성화.
					 */                        
/*					var svcScpCd = sheetObj.CellValue(i, 'svc_scp_cd');
					if(ComCheckGuideExcepSvcScpCd(svcScpCd)) {
						sheetObj.CellEditable(i, "gline_cp_flg_lnk") = true;
	                	sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 1;
					} else {
						sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;
		                sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
					}*/
                }
            }    	
    	} else {
            for (var i = 1; i <= sheetObj.RowCount;i++){                                
                if (amdtSeq == "0"){
                    sheetObj.CellEditable(i, "scp_dur_pop") = false;
                    sheetButtonImageChange(sheetObj,i, 0);// 비활성
                }

                sheetObj.CellEditable(i, "ctrt_eff_dt") = false;
                sheetObj.CellEditable(i, "ctrt_exp_dt") = false;
                sheetObj.CellEditable(i, "tgt_mvc_qty") = false;
                sheetObj.CellEditable(i,"cntr_lod_ut_cd") = false;

/*                sheetObj.CellEditable(i, "gline_cp_flg_lnk") = false;
                sheetObj.PopupButtonImage(i, "gline_cp_flg_lnk") = 0;*/
            }
    	}
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
     * @param   {string} text 화면에 표시된 문자 
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
        var sheetScp = sheetObjects[1];        
        var arrText = text.split("|");
        
    	if (arrText != null && arrText.length > 1) {
    		formObj.prop_srep_nm.value = comboObj.GetText(code, 1);
    	}          
        com_change_sheet( sheetObj, "prop_srep_cd" )
        // Proposal의 sale rep이 변경 되었다면
        for (i = 1; i <= sheetScp.LastRow; i++){
            sheetScp.CellValue(i, "prop_scp_srep_cd")= arrText[0];
        }        
    }    
    
    
    /**
    * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
    * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *    respb_srep_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */     
    function respb_srep_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var arrText = text.split("|");

        if (arrText[1] != null && arrText[1] != undefined){
            formObj.ctrt_cust_srep_nm.value = arrText[1];
            formObj.respb_sls_ofc_cd.value = arrText[2];
        }else{
        	formObj.ctrt_cust_srep_nm.value = "";
        	formObj.respb_sls_ofc_cd.value = "";
        }
   
//        if (code != ""){
//            formObj.respb_sls_ofc_cd.value = getOfficeCd(code); 
//        }
            
        com_change_sheet( sheetObj, "respb_srep_cd" );
        com_change_sheet( sheetObj, "respb_sls_ofc_cd" );

        //sale lead
        setSaleLeadCombo(true);   
        sheetObj.CellValue(1, "sls_ld_no")= "";

    }    
    
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
   function respb_srep_cd_OnBlur(comboObj) {
 		var formObj = document.form;		
 		var code = comboObj.FindIndex(comboObj.Code, 0);
 		var sheetObj = sheetObjects[0];
 		var ofc = comboObj.GetText(comboObj.Code,2); 		
 		if (code != null && code != "") {
 			var text = comboObj.GetText(code, 1);
 			if (text != null && text != "" && text != formObj.ctrt_cust_srep_nm.value) {
 				formObj.ctrt_cust_srep_nm.value = comboObj.GetText(code, 1);
 				formObj.respb_sls_ofc_cd.value = ofc;
 			}
 		}
		if (code == -1){
			formObj.ctrt_cust_srep_nm.value = "";
		}
        com_change_sheet( sheetObj, "respb_srep_cd" );
        com_change_sheet( sheetObj, "respb_sls_ofc_cd" );

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
    *    dmdt_ft_tp_cd_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} code 필수 코드
    * @param   {string} text 필수 화면에 표시된 문자 
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function dmdt_ft_tp_cd_OnChange(comboObj, code, text) {
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        com_change_sheet( sheetObj, "dmdt_ft_tp_cd" )
        
        changeDmdtBtnStatus();
        
    }     
    
    
    /**
     * Free Time조건에 따라 Dem/Det버튼을 활성,비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    changeDmdtBtnStatus();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     
    function changeDmdtBtnStatus(){
        var req_usr_flg  = sheetObjects[0].CellValue(1, "req_usr_flg");
        var apro_usr_flg = sheetObjects[0].CellValue(1, "apro_usr_flg");
        var soKup = sheetObjects[0].CellValue(1, "so_kup");
        var aproUsrFlgOri = sheetObjects[0].CellValue(1, "apro_usr_flg_ori");//소급전권한
        var formObj = document.form;
        var sw = false;

        if (document.form.dmdt_ft_tp_cd.Code =="E"){
            sw = true;
        }
        if (sw ==true){
        	if (soKup == "Y"){
        		if (req_usr_flg =="Y" || aproUsrFlgOri == "Y"){
                    ComBtnEnable("btn_dem_pop"); 
                    document.getElementById("btn_dem").style.color = "black";
        		}else{
                    ComBtnDisable("btn_dem_pop"); 
                    document.getElementById("btn_dem").style.color = "";
        		}        		
        	}else{
        		if (req_usr_flg =="Y" || apro_usr_flg == "Y"){
                    ComBtnEnable("btn_dem_pop"); 
                    document.getElementById("btn_dem").style.color = "black";
        		}else{
                    ComBtnDisable("btn_dem_pop"); 
                    document.getElementById("btn_dem").style.color = "";
        		}
        	}        
        }else{
            ComBtnDisable("btn_dem_pop"); 
            document.getElementById("btn_dem").style.color = "";
        }
    }
     
   

//    combo 관련  (E)   -----
// form 관련 (S) -----
    
    
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

                case "n1st_cmnc_dt":
                    eleValue = ComGetUnMaskedValue(document.getElementById(colNm).value,"ymd");                     
                    break;                  
                case "ctrt_cust_seq":
                    eleValue = ComParseInt(document.getElementById(colNm).value);
                    break;

                default:
                    eleValue = document.getElementById(colNm).value;    
                    break;                  
            }           
            sheetObj.CellValue(1,colNm) = eleValue;     

        }else{
            sheetObj.CellValue(1,colNm) = document.getElementById(colNm).Code;          
        }
    }
    
//    form  관련   (E)   -----

// sheet 관련 (S) -----

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
    * Scope Duration을 변경할 경우 Validation 을 처리한다. <br>
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
                } else {
                    sheetObj.CellValue2(Row, "eff_dt") = sheetObj.CellValue(Row, "ctrt_eff_dt");
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
            case "tgt_mvc_qty":
            	if (sheetObj.CellValue(Row,Col) < 0){
            		sheetObj.CellValue2(Row, Col) = 0;
            	}
            	break;
            case "svc_scp_cd":
            	var checkVal = false;
            	var svcScpCd = sheetObj.CellValue(Row, "svc_scp_cd");
            	var arrScpCd = scopeCdValue.split("|");
            	
            	for(var i=1; i < arrScpCd.length; i++){
            		if(svcScpCd == arrScpCd[i]){
            			checkVal = true;
            			break;
            		}
            	}
            	if(checkVal == false && svcScpCd != ""){
            		sheetObj.CellValue(Row, "svc_scp_cd") = "";
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
    	var formObj = document.form;
        formObj.rfa_no.value = sheetObj.CellValue(1,"rfa_no");
        formObj.prop_no.value = sheetObj.CellValue(1,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_eff_dt"),"ymd");
        formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"ctrt_exp_dt"),"ymd");

        formObj.prop_sts.value = sheetObj.CellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value = sheetObj.CellValue(1,"prop_ofc_cd");   
        // Request Office가 BOMSC일 경우 Arbitrary Tab 추가
        setTabEnable(2, (sheetObj.CellValue(1,"prop_ofc_cd") == "BOMSC") ? true : false);
        
        formObj.prop_srep_nm.value = sheetObj.CellValue(1,"prop_srep_nm");      
        formObj.prop_apro_ofc_cd.value = sheetObj.CellValue(1,"prop_apro_ofc_cd");   
        formObj.prop_apro_staff.value = sheetObj.CellValue(1,"prop_apro_staff");
        
        formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"cre_dt"),"ymd");        
        formObj.prop_apro_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"prop_apro_dt"),"ymd");

        formObj.ctrt_cust_cnt_cd.value = sheetObj.CellValue(1,"ctrt_cust_cnt_cd");
        if (sheetObj.CellValue(1, "ctrt_cust_seq") !="" ){
            formObj.ctrt_cust_seq.value = ComLpad(sheetObj.CellValue(1,"ctrt_cust_seq"), 6, "0");
        }else{
            formObj.ctrt_cust_seq.value = "";
        }        
        
        //PRS
        formObj.prs_crnt_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_crnt_cm_amt"));        
        formObj.prs_estm_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_estm_cm_amt"));
        formObj.prs_sum_cm_amt.value = ComAddComma(parseInt(sheetObj.CellValue(1,"prs_crnt_cm_amt")) 
        							 + parseInt(sheetObj.CellValue(1,"prs_estm_cm_amt")));
     
        comboObjects[4].Code2 = sheetObj.CellValue(1,"sls_ld_no");
        formObj.sale_lead_ori.value  = sheetObj.CellValue(1,"sls_ld_no");//조회후 값변경 확인하기위해(저장시 SC에서)
        
        formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"ctrt_pty_nm");        
        formObj.prc_ctrt_cust_tp_nm.value = sheetObj.CellValue(1,"prc_ctrt_cust_tp_nm");        
        formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1,"ctrt_cust_val_sgm");
        formObj.respb_sls_ofc_cd.value = sheetObj.CellValue(1,"respb_sls_ofc_cd");         
        formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1,"ctrt_cust_srep_nm");
                    
        formObj.tgt_mvc_qty.value = ComAddComma(sheetObj.CellValue(1,"tgt_mvc_qty"));
        comboObjects[3].Code2 = sheetObj.CellValue(1,"cntr_lod_ut_cd");
        comboObjects[5].Code2 = sheetObj.CellValue(1,"dmdt_ft_tp_cd");
        comboObjects[1].Code2 = sheetObj.CellValue(1,"rfa_ctrt_tp_cd");
        // 저장시 duration을 scope과 비교하기 위하여 원본 duration을 가지고 있다.
//        var preIbflag = sheetObj.CellValue(1,"ibflag");
        var preIbflag = sheetObj.RowStatus(1);
        sheetObj.CellValue(1,"ctrt_eff_dt_ori") = sheetObj.CellValue(1,"ctrt_eff_dt");
        sheetObj.CellValue(1,"ctrt_exp_dt_ori") = sheetObj.CellValue(1,"ctrt_exp_dt");      
        sheetObj.CellValue(1, "dmdt_ft_tp_cd_ori") = sheetObj.CellValue(1, "dmdt_ft_tp_cd");
        // prop_prpr_flg 는 항상 Y
        sheetObj.CellValue2(1, "prop_prpr_flg") = "Y";
        sheetObj.RowStatus(1) = preIbflag;
        setCancelText();
        //소급메세지
        popSokupMessage();
    }   
    
    
    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * MQC를 계산하기 위하여 추가한 컬럼에 값을 채워 넣는다.
     * <br><b>Example :</b>
     * <pre>
     * 
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
            sheetObj.CellValue2(i,"tgt_mvc_qty_ori") = sheetObj.CellValue(i,"tgt_mvc_qty");
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
        if (srepCd !="" && cboObj.FindIndex(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.prop_srep_nm.value,srepCd);
        }
        cboObj = comboObjects[2];
        srepCd = sheetObj1.CellValue(1,"respb_srep_cd");
        if (srepCd !="" && cboObj.FindIndex(srepCd, 0) == -1 ){
        	cboObj.InsertItem(0,srepCd + "|" +formObj.ctrt_cust_srep_nm.value,srepCd);
        }
        //sale rep        
        comboObjects[0].Code2 = sheetObj1.CellValue(1,"prop_srep_cd");
        comboObjects[2].Code2 = sheetObj1.CellValue(1,"respb_srep_cd");         
        //첫줄 빈칸 추가
        comboObjects[2].InsertItem(0, " | | "," ");
        // font
        var amdtSeq = document.form.amdt_seq.value;
        if(amdtSeq==0){                        
            return;
        }   
        for(var i = 1 ; i < sheetObj.Rows; i++){
            if(sheetObj.CellValue(i,"pre_ext_scp") == "N"){
                sheetObj.CellFont("FontColor", i, 1, i, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);          
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
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	try {
    		ComOpenWait(true); // ->waiting->start
    		if (saveSvcScpCd != "" && saveSvcScpCd != sheetObj.CellValue(NewRow, "svc_scp_cd")) {
    			return;
    		}
    		if (OldRow != NewRow) {
    			changeSelectBackColor4Main(sheetObj);
    		}
    		saveSvcScpCd = "";
    		if (sheetObj.CellValue(NewRow, "svc_scp_cd") != "" && OldRow != NewRow && sheetObj.CellValue(NewRow, "ibflag") != "I") {

    			comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow, "svc_scp_cd"));
    			// 0728
    			if (tabObjects[0].SelectedIndex == 0) {
    				tab1_OnChange(tabObjects[0], 0);
    			} else {
    				tabObjects[0].SelectedIndex = 0;
    			}
    			loadTabPage(beforetab, NewRow);
    			
    			//Tab의 타이틀 변경
    			//setTabText();
    		} else if (sheetObj.CellValue(NewRow, "ibflag") == "I") {
    			if (NewRow != OldRow) {
    				clearAllTabPages();
    			}
    		}
    		ComOpenWait(false); // ->waiting->End
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	} finally {
    		ComOpenWait(false); // ->waiting->End
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
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                 
                var sSvcScpCd ="&sSvcScpCd=" + sheetObj.CellValue(Row, "svc_scp_cd");
                var sParam = getParameters(colName, sSvcScpCd);                
                var rtnVal = ComPriOpenWindowCenter ("/hanjin/ESM_PRI_2010.do?"+sParam, "ESM_PRI_2010", 635, 295, true);
               
                if (rtnVal != null && rtnVal =="Y"){
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);    
                }                   

                break;
                
            case "gline_cp_flg_lnk":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }  
                
                var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+"&amdt_seq="+sheetObjects[0].CellValue(1, "amdt_seq")+"&rfa_no="+sheetObjects[0].CellValue(1, "rfa_no")
                +"&svc_scp_cd="+sheetObjects[1].CellValue(Row, "svc_scp_cd")+"&eff_dt="+sheetObjects[1].CellValue(Row, "ctrt_eff_dt")+"&exp_dt="+sheetObjects[1].CellValue(Row, "ctrt_exp_dt")
                +"&endExpDt=" + endExpDt + "&addOnEndExpDt=" + addOnEndExpDt;

                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2080.do?"+sParam, "ESM_PRI_2080", 522, 270, true);
                if (rtnVal != null && rtnVal =="OK"){
                    clearAllTabPages();
                    //하부 terms조회
                    comApplyStyleProposalStatusSummary(sheetObjects[1].CellValue(Row,"svc_scp_cd"));
                    if (tabObjects[0].SelectedIndex == 0) {
                        tab1_OnChange(tabObjects[0], 0);
                    } else {
                        tabObjects[0].SelectedIndex = 0;
                    }
                    loadTabPage(beforetab);
                }
                break;
        }
    }           
    

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
        var mqcQty = sheetObjects[0].CellValue(1, "tgt_mvc_qty");

        var sDay = formObj.ctrt_eff_dt.value;
        var eDay = formObj.ctrt_exp_dt.value;
        
        var mvcQty = 0;     
        var durDay = ComGetDaysBetween(sDay, eDay);
        if (mqcQty != "" && mqcQty != "0"){
            if (durDay !=0){
            	mvcQty = ComRound((mqcQty / durDay * 7),0);
            }
        }   
        formObj.prop_mvc.value = ComAddComma(mvcQty);        
        formObj.prop_mvc_tp.value = comboObjects[3].Text;        
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
        var sheetObj1 = sheetObjects[1];
        var scpCd = sheetObj1.CellValue(Row, "svc_scp_cd");
        var rValue = "N";// 데이터 있음 (삭제불가능)
        formObj.f_cmd.value = SEARCH09;
        var sParam = "prop_no="+ sheetObjects[0].CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) +"&svc_scp_cd="+scpCd ;
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do" , sParam);
                
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
    * Terms의 상태가 모두 Accept일 경우 Scope의 상태를 Accept로 변경 하고 Approve버튼을 활성화하고<br> 
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
        var apro_usr_flg = sheetObj.CellValue(1, "apro_usr_flg")
        var sts = sheetObjects[0].CellValue(1, "prop_sts_cd");
        
        formObj.f_cmd.value = SEARCH08;     
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , FormQueryString(formObj)+"&svc_scp_cd="+scpCd);
    
        var arrData = ComPriXml2Array(sXml, "prop_scp_sts_cd","");
        if (arrData !=null && arrData.length > 0){  

            // svc_scp_cd를 change 한다.            
            for (var i = 1; i <= sheetObj1.RowCount; i++ ){
                if (sheetObj1.CellValue(i, "svc_scp_cd") == scpCd ){
                    sheetObj1.CellValue(i, "prop_scp_sts_cd") = arrData[0];                      
                    break;
                }
            }    
            if (arrData[0] == "A"){       
                // 모두 accept가 되었는지 확인
                if (checkAccept() == "Y"){
                    if(apro_usr_flg == "Y"){            
                        ComBtnEnable("btn_approve"); // (terms가 all accept경우)-클릭시 check
                        ComBtnDisable("btn_coffer");
                    }            
                }else{          
                    ComBtnDisable("btn_approve"); // (terms가 all accept// 경우)-클릭시 check
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }       
                }           
            }else if (arrData[0] =="I") {
   
                if (sheetObj.CellValue(1,"prop_sts_cd") == "Q" || apro_usr_flg=="Y" ){      
                    ComBtnDisable("btn_approve");   
                    if (sts == "Q"){
                        ComBtnEnable("btn_coffer"); 
                    }
                }
            }
        }
    }        
    
    
    
    
    /**
     * Request Dem/Det이 입력되어 있는지 확인한다.<br>
     * Exception : Dar Data가 없는 경우와 Dar Data가 있을 시 생성 된 Dar 중에  <br> 
     *             Request, C.offer, Approve, Reject 의 Status 가 하나도 없을 때는 Request금지 <br> 
     * Tariff    : Dar Data가 있을때 생성 된 Dar 중에  <br> 
     *             Request, C.offer, Approve의 Status 가 하나라도 있다면 Request 금지 <br>      
     * <br><b>Example :</b>
     * <pre>
     *		checkDmdtData();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Request 할 수 있다.<br>
     *          N : Request 할 수 없다.<br>
     * @author 공백진
     * @version 2009.05.07
     */  
    function checkDmdtData(){
    	//DMT_RFA_EXPT_TRF 테이블에 해당 Proposal Number 가 없을시
    	var formObj = document.form;
        var sheetObj = sheetObjects[0]
        var rValue = "N";            

        var dmdtSts = sheetObj.CellValue(1, "dmdt_ft_tp_cd_ori");       

        formObj.f_cmd.value = SEARCH10;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);        
        var arrData = ComPriXml2Array(sXml, "ex_cnt|ta_cnt|all_cnt");
        if (arrData != null && arrData.length > 0) {
            if (dmdtSts == "E"){
            	if (arrData[0][2] == 0){
            		ComShowCodeMessage('PRI01091');		//msgs['PRI01091'] = 'Free Time term is Exception. Please create Before BKG DAR.';        		
            	}else{
            		if (arrData[0][0] == 0){
            			ComShowCodeMessage('PRI01114');		//msgs['PRI01114'] = 'There is no valid DAR. Please change the free time term or update DAR again.';     
            		}else{
            			rValue = "Y";	
            		}            		
            	}
            }else{
            	if (arrData[0][1] > 0){
            		ComShowCodeMessage('PRI01115');		//msgs['PRI01115'] = 'There is valid DAR, Pleaes change the free time term again.';          		
            	}else{
            		rValue = "Y";
            	}
            }        	
        }else{
        	if (dmdtSts == "E"){
            	ComShowCodeMessage('PRI01091');            	
        	}else{
        		rValue = "Y";
        	}
        }
        return rValue;        
    }   
    

    /**
     * Init Cancel 시 DMT_RFA_EXPT_TRF 테이블에 해당 Proposal Number 가 있다면 <br>
     * Cancel을 금지한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkInitCancelDmdtData();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Init Cancel 할 수 없다.<br>
     *          N : Init Cancel 할 수 있다.<br>
     * @author 공백진
     * @version 2009.05.07
     */      
    function checkInitCancelDmdtData(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0]
        var rValue = "N";            

        formObj.f_cmd.value = SEARCH10;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);        
        var arrData = ComPriXml2Array(sXml, "all_cnt");
        if (arrData != null && arrData.length > 0) {
            if (arrData[0][0] > 0){
            	rValue = "Y";
            }        	
        }
        return rValue;        
    }    
    
    
    /**
     * Request  시 Duration,DEM/DET 이 변경되었는지 확인한다. <br>
     * 변경되었다면 확인 메세지를 보여준다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkDuration();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : Duration이 변경됨<br>
     *          N : Duration 변경 안되었음<br>
     * @author 공백진
     * @version 2009.05.07
     */ 
    function checkDuration(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0]
        var rValue = "N";                          
        formObj.f_cmd.value = SEARCH11;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;        
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);    
        var arrData = ComPriXml2Array(sXml, "cd");
        if (arrData != null && arrData.length > 0) {
            if (arrData[0][0] == "3"){
                rValue = "Y";   
            }           
        }
        return rValue;        
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
        var sheetObj = sheetObjects[0]
        var rValue = "Y";// 모두 accept 되었다.
        formObj.f_cmd.value = SEARCH05;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;                     
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);
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
        var sheetObj = sheetObjects[0]
        var rValue = "N";// C/Offer를 할 수 없다.
        formObj.f_cmd.value = SEARCH06;
        
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);

        var arrData = ComPriXml2ComboString(sXml, "status","cnt");
        
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue ="Y"
            }
        }
        return rValue;
        
    }
    
    //BKG에 유효한 데이터가 있는지 조회한다.
    //BKG_Booking ,BKG_RATE 를 조회한다.
    
    /**
    * Approve Cancel시 BKG에 데이터가 있는지 조회한다.<br>
    * return 값이 N 일 경우 Approve Cancel 할 수 없다.<br> 
    * <br><b>Example :</b>
    * <pre>
    *		checkApproveCancel();
    * </pre>
    * @param  없음
    * @return {string} <br>
    *          Y : BKG에 데이터가 없다.<br>
    *          N : BKG에 데이터가 있다.<br>
    * @author 공백진
    * @version 2009.05.07
    */     
    function checkApproveCancel(){
        var formObj = document.form;
        var sheetObj = sheetObjects[0]
        var rValue = "N";//  Approve Cancel 을 할 수 없다.
                
        formObj.f_cmd.value = SEARCH14;
        var sParam = "rfa_no="+sheetObj.CellValue(1, "rfa_no")+"&eff_dt="
        +sheetObj.CellValue(1, "eff_dt")+"&exp_dt="+sheetObj.CellValue(1, "exp_dt")+"&"+FormQueryString(formObj);
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);

        var arrData = ComPriXml2Array(sXml, "cd|etc1");
        var strMsg = "";
        var chkData = "";
        if (arrData !=null && arrData.length > 0){
        	chkData = arrData[0][0];
        	for (var i = 1; i < arrData.length; i++){
        		if (i == 6){
        			strMsg += " ..."
        			break;
        		}else if (i !=1){
        			strMsg += ", "
        		}
        		strMsg+=arrData[i][0]
        	}        	
        }

        if (strMsg == "" && chkData == "OK"){
        	rValue ="Y";
        }else{
        	ComShowCodeMessage('PRI01107',strMsg);
        }
        return rValue;
        
    }    
    
    /**
     * Terms에 returned가 있는지 조회한다.<br>
     * return 값이 Y 일 경우 Scope의 상태를 Returned로 변경한다.<br> 
     * <br><b>Example :</b>
     * <pre>
     *		checkCountOffer();
     * </pre>
     * @param  없음
     * @return {string} <br>
     *          Y : 상태가 Returned인 데이터가 있다.<br>
     *          N : 상태가 Returned인 데이터가 없다.<br>
     * @author 공백진
     * @version 2009.05.07
     */  
    function checkReturned(svcScpCd){
        var formObj = document.form;
        var sheetObj = sheetObjects[0]
        formObj.f_cmd.value = SEARCH06;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);
        var arrData = ComPriXml2ComboString(sXml, "status","cnt");        
        if (arrData !=null && arrData.length > 0){
            if (arrData[1] == 0){
                rValue ="Y"
            }
        }
        return rValue;        
    }    
    
     /**
      * Request버튼 클릭시 Request를 진행 할 수 없는 경우를 확인한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *         checkRequest
      * </pre>
      * @param  없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */    
     function checkRequest(){
        document.form.f_cmd.value = SEARCH07;
        var rMsg = "";
        var rValue = "N"; // Request 금지
        var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+ "&" + FormQueryString(document.form) ;        
        var errMsg ="";
        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", sParam);
        var chkType = "";
        var arrData = ComPriXml2Array(sXml, "terms|cnt");
        var amendChk = false;
        if (arrData != null && arrData.length > 0) {
            for (var i = 0; i < arrData.length; i++){
                if (arrData[i][0] == "CALC_CHK"){// RATE CALCULATE
                	chkType = "1";
                	if (arrData[i][1] != ""){
                		rValue = "N";
                		errMsg = arrData[i][1];
                		break;
                	}else{
                		rValue = "Y";
                	}
                }else{
                	chkType = "2";
                	if (arrData[i][1] != "0"){
                        rValue = "Y";
                    }else{
                        rMsg += " "+arrData[i][0]+" "                    
                        rValue = "N";
                    	if (arrData[i][0] == "AMEND"){
                    		amendChk = true;
                    	}
                        break;
                    }                	
                }
            }            
            if (rValue == "N" && amendChk == false && chkType == "2"){//RATE필수입력
                ComShowCodeMessage("PRI01042",rMsg);		//msgs['PRI01042'] = 'Please input {?msg1}.';
            }else if (rValue == "N" && amendChk == true && chkType == "2"){//AMEND DATA없음
            	ComShowCodeMessage("PRI01105"); 	//msgs['PRI01105'] = 'There is no amended data.';
            }else if (rValue == "N" && chkType == "1"){//RATE CALCULATE
            	ComShowCodeMessage("PRI03027",errMsg,"Request");	//msgs['PRI03027'] = '** Subject to calculation ** {?msg1}\n\nPlease click [Calculate] under [Rate] tab in advance to check estimated CMPB(OPB)/CM(OP).\nThen, [{?msg2}] will be active.';
            }
        }else{
        	ComShowMessage(OBJECT_ERROR);
        }
        
        return rValue;
     }
      
  /**
   * 작성자가 Request Cancel시 해당 데이터중 Accept,Returned인 데이터가 있는지 조회하여<br>
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
      formObj.f_cmd.value = SEARCH19;
      
      try{
          var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");
          sParam += "&" + FormQueryString(formObj);
          var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);            
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
            formObj.f_cmd.value = SEARCH12; 
        }else{//sls_ld_no main에 저장후 조회
            formObj.f_cmd.value = SEARCH13;
        }
        
        var sParam = FormQueryString(formObj);

        sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do", sParam);
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
        if (formObj.ctrt_cust_cnt_cd.value != "" && formObj.ctrt_cust_seq.value != "") {
            formObj.f_cmd.value = SEARCHLIST;
            var sParam = FormQueryString(formObj) + "&etc2=" + formObj.ctrt_cust_cnt_cd.value
                       + "&etc3=" + ComParseInt(formObj.ctrt_cust_seq.value);
            sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
            ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm|etc1");
            //첫줄 빈칸 추가
            comboObjects[2].InsertItem(0, " | | "," ");
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
        ComPriXml2ComboItem(sXml, formObj.prop_srep_cd, "cd", "cd|nm");

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
        
        sheetObj.CellValue(1, "ctrt_cust_cnt_cd")= "";
        sheetObj.CellValue(1, "ctrt_cust_seq") = "";
        sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd") = "";
        sheetObj.CellValue(1,"ctrt_pty_nm") = "";

        sheetObj.CellValue(1,"ctrt_cust_val_sgm_cd") = "";
        sheetObj.CellValue(1,"ctrt_cust_val_sgm") = "";
        sheetObj.CellValue(1,"respb_srep_cd") = "";
        sheetObj.CellValue(1,"respb_sls_ofc_cd") = "";
        sheetObj.CellValue(1,"prc_ctrt_cust_tp_nm") = "";

        formObj.ctrt_cust_cnt_cd.value = "";
        formObj.ctrt_cust_seq.value = "";
        formObj.ctrt_pty_nm.value = "";
        comboObjects[2].Code = "";
        formObj.ctrt_cust_val_sgm.value = "";
        formObj.respb_sls_ofc_cd.value = "";
        formObj.ctrt_cust_srep_nm.value = "";
        formObj.prc_ctrt_cust_tp_nm.value ="";
        
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
        var ctrt_cust_cnt_cd = formObj.ctrt_cust_cnt_cd.value;        
        var ctrt_cust_seq = formObj.ctrt_cust_seq.value;        
        
        if(ctrt_cust_cnt_cd != "" && ctrt_cust_seq !=""){
            var sParam = "f_cmd="+SEARCH02+"&cust_cnt_cd="+ctrt_cust_cnt_cd+"&cust_seq="+ctrt_cust_seq;
            var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do", sParam);
            var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_cust_val_sgm|respb_srep_cd|respb_sls_ofc_cd|ctrt_cust_srep_nm|prc_ctrt_cust_tp_nm|ctrt_cust_val_sgm_cd");

            if(arrText==undefined){
                clearCustName();
                formObj.ctrt_cust_cnt_cd.focus();
            }else{           
                comboObjects[2].Code = "";             
                sheetObj.CellValue2(1,"prc_ctrt_cust_tp_cd") = arrText[0][0];

                sheetObj.CellValue2(1,"ctrt_pty_nm") = arrText[0][1];
                sheetObj.CellValue2(1,"ctrt_cust_val_sgm") = arrText[0][6];
                sheetObj.CellValue2(1,"ctrt_cust_val_sgm_cd") = arrText[0][7];
                sheetObj.CellValue2(1,"respb_srep_cd") = arrText[0][3];
                sheetObj.CellValue2(1,"respb_sls_ofc_cd") = arrText[0][4];
           
                formObj.ctrt_pty_nm.value = arrText[0][1];
                formObj.ctrt_cust_val_sgm.value = arrText[0][2];
                formObj.respb_sls_ofc_cd.value = arrText[0][4];           
                comboObjects[2].Code = arrText[0][5];
                formObj.ctrt_cust_srep_nm.value = arrText[0][5];
                formObj.prc_ctrt_cust_tp_nm.value = arrText[0][6];                
            }

        }
        var sheetObj = sheetObjects[0];         
        com_change_sheet( sheetObj, eleName);      
 
    }   


    
    /**
     * 메인 duration이 변경되었을 경우 조건에 따라 Scope의 duration을 변경한다. <br>
     * 저장 전에 scope duration을 변경한다.
     * <br><b>Example :</b>
     * <pre>
     *      saveDurationChange();
     * </pre>
     * @param {msgPass} 필수 메세지 박스를 보이지 않고 scope의 duration만 변경할 경우 false,메세지박스를 보여주려면 true
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */ 
    function saveChangeDuration(msgPass){
        var sheetObj = sheetObjects[0];
        var sheetObj1 = sheetObjects[1];
        var oriCtrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt_ori");//변경전 duration
        var oriCtrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt_ori");//변경전 duration
        var ctrtEffDt = sheetObj.CellValue(1, "ctrt_eff_dt");		//변경후 duration
        var ctrtExpDt = sheetObj.CellValue(1, "ctrt_exp_dt");
        var effChk = 0;
        var expChk = 0;
        var msgChk = 0;
        var amdtSeq = sheetObj.CellValue(1,"amdt_seq");
                
        if (sheetObj.CellValue(1, "ibflag")=="I"){
            for( var i = 1; i <= sheetObj1.RowCount; i++){
            	sheetObj1.CellValue(i, "ctrt_eff_dt")= ctrtEffDt;
            	sheetObj1.CellValue(i, "ctrt_exp_dt")= ctrtExpDt;
            }
        	return true;
        }
        if (oriCtrtEffDt > ctrtEffDt ){
            effChk = 1; // 일자 앞으로 늘림 Duration Eff 늘이기
             //  아니오를 선택 할 경우 Proposal Duration Eff 만 늘임
            for ( var i = 1 ; i <=sheetObj1.RowCount; i++){
                if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 1;
                    break;
                }
            }
        }else if (oriCtrtEffDt < ctrtEffDt){ 
            effChk = 2; // 일자 줄임 Duration Eff 줄이기
            //  아니오를 선택 할 경우 모든 수행을 취소하고 Return
            for (var i = 1; i <= sheetObj1.RowCount; i++){
                if (ctrtEffDt >= sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    msgChk = 2;
                    break;
                }
            }
        }
        if (oriCtrtExpDt > ctrtExpDt ){ //일자 줄임 Duration Eff 줄이기
            expChk = 1; // 일자 줄임 Duration Eff 줄이기
            // 아니오를 선택 할 경우 모든 수행을 취소하고 Return
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    msgChk += 3; 
                    break;
                }
            }
        }else if (oriCtrtExpDt < ctrtExpDt){ 
            expChk = 2; // 일자 뒤로 늘림 Duration Exp 늘이기
            // 아니오를 선택 할 경우 Proposal Duration Exp 만 늘임
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

        switch (msgChk){
            case 1:
                if (!ComShowCodeConfirm("PRI01025")){	//msgs['PRI01025'] = 'Do you also want to change the main duration?';
                    return true;
                }
                break;
            case 2:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }               
                break;
            case 3:         
            case 4:
            case 5:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }                       
                break;
            case 6:
                if (!ComShowCodeConfirm("PRI01025")){
                    return true;
                }               
                break;
            case 7:
                if (!ComShowCodeConfirm("PRI01025")){
                    return true;
                }               
                break;
            case 8:
                if (!ComShowCodeConfirm("PRI01025")){
                    return false;
                }                   
                break;
        
        }
        
        if (effChk == 1){           
            //effChk = 1; // 일자 앞으로 늘림 Duration Eff 늘이기
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (oriCtrtEffDt == sheetObj1.CellValue(i, "ctrt_eff_dt")){
                    sheetObj1.CellValue2(i,"ctrt_eff_dt") = ctrtEffDt;
                    sheetObj1.CellValue2(i,"eff_dt") = ctrtEffDt;
                    if (amdtSeq =="0"){
                        sheetObj1.CellValue2(i, "n1st_cmnc_dt") = ctrtEffDt;
                    }
                }
            }
        }else if (effChk == 2){
            //effChk = 2; // 일자 줄임 Duration Eff 줄이기
            // 단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
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
            //expChk = 1; // 일자 줄임 Duration Eff 줄이기
            // 단, 아니요를 선택 할 경우 모든 수행을 취소하고 Return
            for ( var i = 1 ; i <= sheetObj1.RowCount; i++){
                if (ctrtExpDt <= sheetObj1.CellValue(i, "ctrt_exp_dt")){
                    sheetObj1.CellValue2(i,"ctrt_exp_dt") = ctrtExpDt;
                    sheetObj1.CellValue2(i,"exp_dt") = ctrtExpDt;
                }
            }
        }else if (expChk == 2){
            //expChk = 2; // 일자 뒤로 늘림 Duration Exp 늘이기
            // 단, 아니요를 선택 할 경우 Proposal Duration Exp 만 늘임
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
      * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 
      * 화면상의 Main,Scope의 상태를 변경한다.<br>
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
                 scopeStatusChange(svcScpCd) // scope 상태변경
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

          var sParam = "prop_no=" + sheetObj.CellValue(1, "prop_no") + "&amdt_seq="+sheetObj.CellValue(1, "amdt_seq");    
          sParam += "&f_cmd="+SEARCH18;
          var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);
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
      * 메인,Scope에 속해 있는 각 Terms의 상태변경,데이터 추가 에 따라 해당 Tab의 아이콘을 변경한다.<br>
      * <br><b>Example :</b>
      * <pre>
      *    comApplyStyleProposalStatusSummary(termTpCd, svcScpCd);
      * </pre>
      * @param   {string} svcScpCd 선택   Scope 코드
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */ 
     function comApplyStyleProposalStatusSummary(svcScpCd){
    	 
         var formObj = document.form;
         formObj.f_cmd.value = SEARCH04;
         var sParam = "prop_no="+sheetObjects[0].CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) +"&svc_scp_cd="+svcScpCd ;
         var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", sParam);
         var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
         var icon = "";
         var tabIdx = "";
         var imgName = "";
         var sheetObj2 = sheetObjects[1];
         var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
         
         for (i = 0; i < arrText.length; i++){
             tabIdx ="";
             imgName="";
             switch(arrText[i][0]){
                case '01':  //Duration,Scope Duration
                    imgName = "img_dur";
                     break;
                 case '05':
                     imgName = "img_affil";
                     break;
                 case '08':
                     imgName = "img_dmdt";
                     break;                  
                 case '13':  //Group Location
                     tabIdx = "0";
                     break;                  
                 case '14':  //Group Commodity
                     tabIdx = "1";                 
                     break;     
                 case '32':  //Special Note
                     tabIdx = "4";
                     break;
                 case '52':  //Arbitrary
                	 tabIdx = "2";    
                	 break;
                 case '71':  //Rate                  
                    tabIdx = "3";
                    break;  
             }
             icon = ICON_URL_NOT_EXIST;
             switch(arrText[i][1]){
                 case "1":
                     icon = ICON_URL_EXIST;
                     break;
                 case "2":
                     icon = ICON_URL_AMEND;
                     break;
                 case "3":
                     icon = ICON_URL_ACCEPT;
                     break;
             }
             
             // 기본 : Black , Amend시 : Red, All Accept시 : Blue
             if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "05"||arrText[i][0] == "08" ){
                 if (imgName !="") document.images(imgName).src = icon;

             }else{
                 if (tabIdx !="") tabObjects[0].ImageUrl(tabIdx) = icon;  
             }   
         }        
         
     }
     
  
    
     /**
     * Pop화면 호출시 공통적으로 넘겨주는 Parameter를 생성한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    getParameters(srcName, param);
     * </pre>
     * @param   {string} srcName 필수  Html Object Name
     * @param   {string} param   선택  화면별로 넘겨주는 Parameter
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     
     function getParameters(srcName, param){        
         var sheetObj = sheetObjects[0];
         var sheetScp = sheetObjects[1];
         var sRfaNo = sheetObj.CellValue(1,"rfa_no");
         var sPropNo = sheetObj.CellValue(1,"prop_no");
         var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
         var sPreAmdtSeq = sheetObj.CellValue(1, "pre_amdt_seq");    
         var sPropStsCd = sheetObj.CellValue(1, "prop_sts_cd");        
         var sSrepCd = sheetObj.CellValue(1, "prop_srep_cd");
         var sSvcScpCd = "";
         var aParam = "";

         var sEffDt = ComGetMaskedValue(sheetObj.CellValue(1, "eff_dt"),"ymd");
         var sExpDt = ComGetMaskedValue(sheetObj.CellValue(1, "exp_dt"),"ymd");       
         var sPreExpDt = ComGetMaskedValue(sheetObj.CellValue(1, "pre_exp_dt"),"ymd");    
         var sIsReqUsr = sheetObj.CellValue(1, "req_usr_flg") == "Y" ? true: false;
         var sIsAproUsr = sheetObj.CellValue(1, "apro_usr_flg") == "Y" ? true: false;
         var sCtrtEffDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
         var sCtrtExpDt = ComGetUnMaskedValue(document.form.ctrt_exp_dt.value, "ymd");
         var sDurDupFlg = sheetObj.CellValue(1, "dur_dup_flg");
         var sRfaCtrtTpCd = sheetObj.CellValue(1, "rfa_ctrt_tp_cd");
         
         var sParam = "sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&sPreAmdtSeq="+sPreAmdtSeq
                    +"&sPropStsCd="+sPropStsCd+"&sSrepCd="+sSrepCd+"&sDurDupFlg="+sDurDupFlg
                    +"&sIsReqUsr="+sIsReqUsr+"&sIsAproUsr="+sIsAproUsr+"&endExpDt=" + endExpDt + "&addOnEndExpDt=" + addOnEndExpDt
                    +"&sRfaCtrtTpCd="+sRfaCtrtTpCd;
         switch (srcName) {        
            case "scp_dur_pop":
                sParam += param;
                break;
            case "btn_dem_pop":
                break;
            case "btn_free_pop": 
            case "btn_afil_pop":
                aParam = "&sEffDt="+sEffDt+"&sExpDt="+sExpDt+"&sPreExpDt="+sPreExpDt                        
                        +"&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;               
                sParam += aParam;
                break;
            case "btn_amend":
                var sDurDt = sheetObj.CellValue(1,"ctrt_eff_dt");
                var eDurDt = sheetObj.CellValue(1,"ctrt_exp_dt");
                var effDt = ComGetDateAdd(sheetObj.CellValue(1,"eff_dt"), "D", 1);
                aParam = "&sSdurDt=" + sDurDt + "&sEdurDt=" + eDurDt+ "&sEffDt=" + effDt ;
                sParam += aParam;
                break;
            } 
         
         return sParam;
     }
     
     /**
      * Customer Type을 Return한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *     getCustTpCd()
      * </pre>
      * @param 없음
      * @return 없음
      * @author 공백진
      * @version 2009.04.17
      */        
    function getCustTpCd(){
        var custTpCd = "";
        var sheetObj = sheetObjects[0];
        custTpCd = sheetObj.CellValue(1, "prc_ctrt_cust_tp_cd");
        
        return custTpCd;
    }
    
    /**
     * RFA Type을 Return한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     getRfaCtrtTpCd()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 서미진
     * @version 2013.12.03
     */        
   function getRfaCtrtTpCd(){
       var rfaCtrtTpCd = "";
       var sheetObj = sheetObjects[0];
       rfaCtrtTpCd = sheetObj.CellValue(1, "rfa_ctrt_tp_cd");  
       return rfaCtrtTpCd;
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
        formObj.tgt_mvc_qty.readOnly = false;            
        formObj.ctrt_eff_dt.readOnly = false;
        formObj.ctrt_exp_dt.readOnly = false; 

        formObj.ctrt_cust_cnt_cd.readOnly = false;
        formObj.ctrt_cust_seq.readOnly = false;
        formObj.respb_srep_cd.enable = true;
        formObj.cntr_lod_ut_cd.enable = true;
        formObj.dmdt_ft_tp_cd.enable = true;
        formObj.prop_srep_cd.enable = true;
        formObj.sls_ld_no.enable = true;       
        formObj.rfa_ctrt_tp_cd.enable = true;

        btnImgEnable(formObj.btn_ctrt_cust, true);
        btnImgEnable(formObj.btns_calendar1, true);     
        
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
        
        if (code != null && code != "") {
            var text = comboObj.GetText(code, 1);
            if (text != null && text != "" && text != formObj.prop_srep_nm.value) {
                formObj.prop_srep_nm.value = comboObj.GetText(code, 1);

            }
        }
    }     
    
    
    
    /**
     * 메인의 상태에 따라 Cancel 버튼의 text를 변경한다.<br>
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
    

    /**
     * 소급권한 적용되는 경우  메세지를 보여준다.<br>
     * 소급권한이란 지정된 OFFICE소속이 아닐 경우 승인권한이 있어도  승인권한을 빼앗는 것을 말함.<br>
     * Request 상태일 경우에만 메세지를 보여준다(조회시).<br>
     * Main의 Eff_dt보다 Main의  creation_dt가 미래일 경우 소급권한이 적용된다.<br>
     * 소급 권한 OFFICE CODE : SINRSS,SHARCS, NYCRAS, HMAUSG,SELCGM,SINRS,SELCMA,SELCMU
     * <br><b>Example :</b>
     * <pre>
     *    popSokupMessage();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */         
    function popSokupMessage(){
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	//so_kup
    	var stsCd = sheetObj.CellValue(1, "prop_sts_cd");
    	var sokup = sheetObj.CellValue(1, "so_kup");
    	var aproveFlg = sheetObj.CellValue(1, "apro_usr_flg");
    	var aproOri = sheetObj.CellValue(1, "apro_usr_flg_ori");

    	if (stsCd == "Q" && formObj.prop_no.value !=""){
    		if (sokup == "Y" && aproveFlg != "Y" && aproOri == "Y"){
    			//PRI01103
    			 ComShowCodeMessage('PRI01103');
    		}
    	}
    	
    }
/////////////////////////////////////////////////////////////////////////   
// ///////////////////// ONCHANGE (E)/////////////////////////////////////
// ///////////////////////////////////////////////////////////////////////
    

    
    /**
     * 이미지로 된 버튼을 활성, 비활성화 한다.<br>
     * 이미지만 비활성 시키므로 processButtonClick()에서 클릭시 처리한다.
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
     * Message Popup을 호출하는 function <br>
     * Status에 따라 다른 Message를 넘긴다. Sales Rep Code 가 Parameter로 넘어오면 해당 User를 To. 로 지정한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     openMessagePopup('A');
     * </pre>
     * @param {string} stsCd 필수 Stauts
     * @param {string} srepCd 옵션 Sales Rep Code
     * @return 없음
     * @author 문동규
     * @version 2009.09.23
     */
    function openMessagePopup(stsCd, srepCd){
        var msg = "";
        var formObj = document.form;
        var usrId = "";
        var usrNm = "";
        
        if (srepCd != null) {
            formObj.f_cmd.value = SEARCHLIST11;
            var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj)+"&srep_cd="+srepCd);
            usrId = ComGetEtcData(sXml,"usr_id");
            usrNm = ComGetEtcData(sXml,"usr_nm");
        }
        if (stsCd == 'R') { // Counter Offer
            if (formObj.amdt_seq.value == '0') {
                msg = "<Returned> Proposal no. "+formObj.prop_no.value+"\\nRemark :";
            } else {
                msg = "<Returned> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value+"\\nRemark :";
            }
            parent.message(usrId,usrNm,msg);
        } else if (stsCd == 'A') {  // Approve
            msg = "<Approved> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value;
            parent.message(usrId,usrNm,msg);
        } else if (stsCd == 'I'){//Request Cancel
            if (formObj.amdt_seq.value == '0') {
                msg = "<Request Cancel> Proposal no. "+formObj.prop_no.value+"\\nRemark :";
            } else {
                msg = "<Request Cancel> RFA no. "+formObj.rfa_no.value+" / Proposal no. "+formObj.prop_no.value+"\\nRemark :";
            }        	
        	parent.message(usrId,usrNm,msg);
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
      var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ;
      var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);
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
	        var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+checkSheetObj.CellValue(1, "amdt_seq")+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
	       var checkParam = "f_cmd="+SEARCHLIST08+"&table_name=PRI_RP_MN&page_name=RFA&key1=" + checkSheetObj.CellValue(1, "prop_no") + "&key2="+amdt_seq+"&upd_dt="+checkSheetObj.CellValue(1, "upd_dt");
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
    
	
	/**
	 * Hinterland 관련<BR>
	 * Scope에 따라 적절한 Arbitrary, Rate Tab을 활성화한다.<BR>
	 * <br><b>Example :</b>
	 * <pre>
	 * 	getTabIndex(tabInfo, tabName)
	 * </pre>
	 * @param {String} tabInfo Tab Information
	 * @param {String} tabName Tab header name want to find.
	 * @return Number tab index.
	 * @author Hyuk Ryu
	 * @version 2012.05.08
	 */
	function getTabIndex(tabInfo, tabName){
		var index = -1;
		var tabs = tabInfo.split("|");
		for(var i=0; i<tabs.length; i++){
			if(tabName == tabs[i].split(",")[1]){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * Hinterland 관련<BR>
	 * 지정한 탭의 enable/disable을 설정한다.<BR>
	 * <br><b>Example :</b>
	 * <pre>
	 * 	setTabEnable(tabObj, enable)
	 * </pre>
	 * @param {Number} tabIdx Target Tab Index
	 * @param {boolean} enable Flag for enable/disable.
	 * @return Number tab index.
	 * @author Hyuk Ryu
	 * @version 2012.05.08
	 */
	function setTabEnable(tabIdx, enable){
		if(tabObjects[0].TabEnable(tabIdx) != enable){
			tabObjects[0].TabEnable(tabIdx) = enable;
		}
	}
	
	/**
	 * Rate (For AEE/AEW)==> Proposal의 IHC금액이 0인 Rate 조회.
	 */
	function checkIHCRateAmt() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0]
        var rValue = 'N';                          
        formObj.f_cmd.value = SEARCH20;
        var sParam = "prop_no="+sheetObj.CellValue(1, "prop_no")+ "&" + FormQueryString(formObj) ; 
        var sXml = sheetObj.GetSearchXml("ESM_PRI_2003GS.do" , sParam);        
        rValue = ComGetEtcData(sXml, "RSLT");
        if(rValue != '') {
        	ComShowCodeMessage('PRI07024', rValue);
        	rValue = 'N';
        }  else {
        	rValue = 'Y';
        }
        return rValue;
	}	
	
	/**
	 * Save시 Duration 체크
	 * @returns {Boolean}
	 */
    function saveDurationCheck(formObj, mnStatus, rowCnt, ctrtEffDt, ctrtExpDt, ctrtEffDtTo, ctrtEffDtOri, sheet2, expiredDate, messageCode) {
    	if((ctrtEffDt < expiredDate && ctrtExpDt >= expiredDate) || (ctrtEffDt > expiredDate && ctrtExpDt <= expiredDate)) {
     		ComShowCodeMessage(messageCode); 		
    		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
    		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
    		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	  	            		
    		return false;
    	}            	
    	//2012-06-16 서미진
    	//DURATION EFF. DATE 7/01일 이전인 경우 7/1 이후로 변경 불가
    	
     	if(ctrtEffDtOri != '' && ctrtEffDtOri < expiredDate && ctrtEffDtTo >= expiredDate && mnStatus != 'I' ){
     		ComShowCodeMessage(messageCode); 		
    		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
    		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
    		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	            		
    		return false;
    	}
    	
    	//DURATION EFF. DATE 7/01일 이후인 경우 7/1 이전로 변경 불가
    	if(ctrtEffDtOri != '' && ctrtEffDtOri >= expiredDate && ctrtEffDtTo < expiredDate && mnStatus != 'I'){
     		ComShowCodeMessage(messageCode); 	
    		formObj.ctrt_eff_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori"),"ymd");
    		formObj.ctrt_exp_dt.value = ComGetMaskedValue(sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori"),"ymd");	
    		sheetObjects[0].CellValue2(1,"ctrt_eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"ctrt_exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"eff_dt") = sheetObjects[0].CellValue(1,"ctrt_eff_dt_ori") ;
    		sheetObjects[0].CellValue2(1,"exp_dt") = sheetObjects[0].CellValue(1,"ctrt_exp_dt_ori") ;	  	            		
    		return false;
    	}
    	return true;
    }
    
    /**
     * Copy 통해 RFA 생성시 Duration 날짜를 기존 데이터의 Duration 날짜보다 이전으로 변경하려고 하는지 체크.
     */
    function checkDurationBeforeData() {
    	var ctrtEffDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt,"ymd");
		document.form.f_cmd.value = SEARCH29;
        var sParam = FormQueryString(document.form);
        var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", sParam);
        var arrData = ComPriXml2Array(sXml, "etc1|etc2");
        if (arrData != null && arrData.length > 0) {
        	var arrDt = ComGetUnMaskedValue(arrData[0][0],"ymd");
        	if(!(arrDt >= addOnEndExpDt && ctrtEffDt >= addOnEndExpDt)) {
        		if(ctrtEffDt < arrDt && arrDt >= addOnEndExpDt) {
	        		ComShowCodeMessage("PRI07039"); 
	        		return false;
	        	}
        	}
            return true;
        }                                   
        return true;	
    }
    
    /**
 * SheetID를 통한 Sheet Object 구함.
 */
function getSheetObject(sheetArray, sheetID) {
	var obj;
	for ( var i = 0; i < sheetArray.length; i++) {
		if (sheetArray[i].id == sheetID) {
			obj = sheetArray[i];
			break;
		}
	}
	return obj;
}

/**
 * Copy를 하였을 경우 Arbitrary의 Prop_rate_amt 값을 Guide 금액으로 변경.
 */
function updateArbitraryGuideValue(sheetObj) {
    var sParam = "f_cmd=" + MULTI07;
    	sParam += "&prop_no="+ sheetObj.CellValue(1, 'prop_no');
    	sParam += "&amdt_seq=" + Number(sheetObj.CellValue(1, 'amdt_seq')) +1;
    	sParam += "&exce_svc_scp_cd=" + guideExcepSvcScpCd.toString();
    	sParam += "&add_on_flag=" +  (Number(sheetObj.CellValue(1, "ctrt_eff_dt")) >= Number(addOnEndExpDt) ? 'Y' : 'N');
    sheetObjects[0].GetSearchXml("ESM_PRI_2003GS.do", sParam);
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
 function rfa_ctrt_tp_cd_OnChange(comboObj, code, text) {
     var formObj = document.form;
     var sheetObj = sheetObjects[0];
     if(code == "C"){
     	ComShowCodeMessage('PRI07051');
     	com_change_sheet( sheetObj, "rfa_ctrt_tp_cd" );
    	return;
     }else{
     	ComShowCodeMessage('PRI07052');
     	com_change_sheet( sheetObj, "rfa_ctrt_tp_cd" );
    	return;
     }
     
 }     