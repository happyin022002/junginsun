/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_2120.js
*@FileTitle : Proposal & Amendment Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.08.05 이관샨
* 1.0 Creation
=========================================================
* History
* 2012.06.25 서미진[CHM-201217633] 구주 Hinterland Operation 개선 Project : Rate (For AEE/AEW), Arbitrary (For AEE/AEW) 화면 추가 
* 2013.02.06 이은섭[CHM-201322936] Add On Tariff 개선 프로젝트 : Rate, Arbitrary 탭 추가
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
                                  - BKG으로부터 parameter 넘겨받아 하위 탭으로 넘겨줌
                                  - Autorating 에서 사용된 scope일 경우 색 변경해줌
* 2014.05.26 최성환 [CHM-201430277] 표시 정보 추가 요청 at RFA View screen 화면 추가  
* 2014.09.15 최성환  [CHM-201431899] Guideline RFA 생성 요청                                     
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
     * @class ESM_PRI_2120 : ESM_PRI_2120 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2120() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업   */
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
	var beforetab = 0;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
    var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";
    
//    var sheetLastCol = 11;
    //수정 후 수정한 scope으로 focus를 이동 하기 위한 변수
    var preSvcScpCd = "";
    var preScustSeq = "";
    var preScustCntCd = "";
    var controlHidden = false;
    
    // T/F 전환을 위한 기준 EXP_DT
	var tabDivCount = 9;
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
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {              
                if (getButtonTable(srcName).disabled || window.event.srcElement.disabled) {
                    return false;
                }
            }

            switch (srcName) {
            case "btn_dem_pop":            
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sUrl = "/hanjin/EES_DMT_2003.do?" + "prop_no="+formObj.prop_no.value+"&amdt_seq="+formObj.amdt_seq.value + "&caller=2007";
                var rtnVal = ComPriOpenWindowCenter(sUrl, "", 1010, 700, 'findCustomer', '1,0,1,1,1,1,1', true);
                break; 
                
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }               
                var sParam = getParameters(srcName, "");                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2019_06.do?"+sParam, "", 1020, 295, true);            
                break;
                
            case "btn_close":   
           	 	window.close();
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
        }
        
        for (var k = 0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
        }

        initControl();
        initFormControl();
        sheetObjects[0].DataInsert();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

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
    	 
    	 /*
        var formObj = document.form;
        var sheetObj = sheetObjects[0]; 
        var sheetObj1 = sheetObjects[0];    
        var eleName = event.srcElement.name;

        switch(eleName){
            case "prop_mvc":
                ComChkObjValid(event.srcElement);   
                break;                     
            default:
                ComChkObjValid(event.srcElement);       
        }
        */
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
    	    	preSvcScpCd = sheetObjects[0].CellValue(sheetObjects[1].SelectRow, "svc_scp_cd");
    	    	sheetObj = sheetObjects[0]; 	
    	        formObj.f_cmd.value = SEARCH11; //변경 : SEARCH01
    	      
        		var rfa_no = formObj.rfa_no.value;
    	        var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2020GS.do" , FormQueryString(formObj));
    	        var arrXml = sXml.split("|$$|");
    	    
    	        if (arrXml.length > 0) {
    	        	sheetObjects[0].LoadSearchXml(arrXml[0]);	
    	        }
    	        clearAllTabPages();
    	        if (arrXml.length > 1){
    	        	sheetObjects[1].LoadSearchXml(arrXml[1]);
    	        }
    	        //calcMVC();
    	        ComOpenWait(false); //->waiting->End
    	       // setTabText();
				tab1_OnChange(tabObjects[0], beforetab);    	        
                break;      
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
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
                */
                // 전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                // 전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
    
                // 전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                // Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "")
                    InitHostInfo(location.hostname, location.port, page_path);
                
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
                
                
                var HeadTitle  = "|rfa_no|prop_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|eff_dt|exp_dt|prc_prog_sts_cd"                 
                HeadTitle += "|src_info_cd|pre_exp_dt|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|cre_dt";
                HeadTitle += "|ctrt_cust_cnt_cd|ctrt_cust_seq|ctrt_pty_nm|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|respb_sls_ofc_cd|respb_srep_cd|ctrt_cust_srep_nm|tgt_mvc_qty";
                HeadTitle += "|cntr_lod_ut_cd|unit|sls_ld_no"
                HeadTitle += "|prc_ctrt_cust_tp_nm|prop_prpr_flg|createtype|prop_apro_staff|dmdt_ft_tp_cd|act_cm|est_cm|rfa_ctrt_tp_cd"; //ADD
                var headCount = ComCountHeadTitle(HeadTitle);               
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false, false)    
   
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
                // SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
                // ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);                           
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "eff_dt", false, "", dfDateYmd, 0, false, false);                             
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "exp_dt", false, "", dfDateYmd, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prog_sts_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "src_info_cd", false, "", dfNone, 0, false, false);                               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "pre_exp_dt", false, "", dfDateYmd, 0, false, false); // eff_dt
                                                                                                                            // - 1
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
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_ctrt_cust_tp_nm", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_prpr_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prc_prop_cre_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "dmdt_ft_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rfa_ctrt_tp_cd", false, "", dfNone, 0, false, false); //ADD
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
                Editable = false;
    
                // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 100);
    

    
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false, false)
    
                var HeadTitle =  "|Sel.|Prop No|Amendment Seq|SVC Scope|Duration|Duration|Target MQC|Unit";
                    HeadTitle += "|Request Office|Sales Rep|Status Code|eff_dt|exp_dt|n1st_cmnc_dt";
                    HeadTitle += "|Status|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP";
                var headCount = ComCountHeadTitle(HeadTitle);
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE,
                // SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP,
                // ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden,  90, daLeft,   false, "prop_no", 		   false, "", dfNone, 	 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90, daLeft,   false, "amdt_seq", 		   false, "", dfNone, 	 0, false, false);
                InitDataProperty(0, cnt++, dtData,   120, daCenter, false, "svc_scp_cd", 	   false, "", dfNone, 	 0, false, true);                
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "ctrt_eff_dt", 	   false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "ctrt_exp_dt", 	   false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden,   110, daRight,  false, "tgt_mvc_qty", 	   false, "", dfInteger, 0, false, false);	//SPOT
                InitDataProperty(0, cnt++, dtHidden,    60, daCenter, false, "cntr_lod_ut_cd",   false, "", dfNone,    0, false, false);	//SPOT
                InitDataProperty(0, cnt++, dtData,   130, daCenter, false, "prop_scp_ofc_cd",  false, "", dfNone, 	 0, false, false); 
                InitDataProperty(0, cnt++, dtData,   130, daCenter, false, "prop_scp_srep_cd", false, "", dfNone, 	 0, false, false);
                InitDataProperty(0, cnt++, dtData,   100, daCenter, false, "prop_scp_sts_cd",  false, "", dfNone, 	 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "eff_dt", 		   false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "exp_dt", 		   false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  95, daCenter, false, "n1st_cmnc_dt", 	   false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prop_scp_sts", 	   false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "prc_prog_sts_cd",  false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "src_info_cd", 	   false, "", dfNone, 	 0, true, true);
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "tgt_mvc_qty_ori",  false, "", dfInteger, 0, true, true);                // PRE_EXT_SCP
                InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "pre_ext_scp", 	   false, "", dfNone, 	 0, true, true);

                InitDataValid(0, "svc_scp_cd", vtEngUpOnly);
                ShowButtonImage = 2;
                ImageList(0) = "img/btns_search_off.gif";
                ImageList(1) = "img/btns_search.gif";
                WaitImageVisible = false;
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
		            InsertTab(-1, "Rate", cnt++);
		            InsertTab(-1, "Location Group ", cnt++);
		            InsertTab(-1, "Commodity Group ", cnt++);
		            //SPOT
		            cnt++;
//		            InsertTab(-1, "Arbitrary", cnt++);
		            InsertTab(-1, "Special Note", cnt++);               
		            //SPOT
		            //기존		            
//		            InsertTab(cnt++, "Rate", 0);
//		            InsertTab(cnt++, "Location Group ", 1);
//		            InsertTab(cnt++, "Commodity Group ", 2);
//		            InsertTab(cnt++, "Arbitrary", 3);
//		            InsertTab(cnt++, "Special Note", 4);               
		            
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
		if (beforetab != tabIndex || tabIndex == 0) {
			var toIndex = getFrameTabId(tabIndex);
			for ( var i = 1; i <= tabDivCount; i++) {
				document.getElementById("tabLayer" + i).style.display = 'none';
			}
			document.getElementById(toIndex.divIndex).style.display = 'inline';
		}
		beforetab = tabIndex;
		//지연처리 : socket error
		setTimeout(function(){
			loadTabPage(tabIndex); 
		}, 2000);
    }
    
    /**
    * Tab변경시 화면을 Frame에 로드한다.  <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadTabPage(tabIndex)
    * </pre>
    * @param {tabIndex} tabIndex 필수 tab의 일련번호
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */      
    function loadTabPage(tabIndex,wh) {
        if (tabIndex == null || tabIndex == "") {
            tabIndex = tabObjects[0].SelectedIndex;
        }
         
    	//SPOT
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
        var sPropNo = sheetObj2.CellValue(sRow,"prop_no");
        var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");
        var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
        
        //하위 Rate 탭 색 변경을 위한 파라미터
        var sSvcScpCdClr = document.form.s_svc_scp_cd_clr.value;
        var sCmdtHdrSeqClr = document.form.s_cmdt_hdr_seq_clr.value;
        var sRoutSeqClr = document.form.s_rout_seq_clr.value;
        
//        alert("2020의 load sheet");
//        alert(sSvcScpCdClr);
//        alert(sCmdtHdrSeqClr);
//        alert(sRoutSeqClr);

        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sheetObj2.CellValue(sRow, "ibflag")!="I") {
        	var chide_loadFlag = eval(document.getElementById(obj.frame).contentWindow.loadFlag);
	    	if(chide_loadFlag == undefined || chide_loadFlag) {
	    		document.getElementById(obj.frame).contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sSvcScpCdClr, sCmdtHdrSeqClr, sRoutSeqClr);
	    	}
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
        document.images("img_affil").src = ICON_URL_NOT_EXIST;
    }
    
    /**
     * 버튼의 색을 지정하고 Check Box를 비활성화 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		clearButtonImages();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2009.05.07
     */      
    function initFormControl(){
        document.getElementById("btn_afil").style.color = "black";
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
        for (var i = 0; i < 2; i++){
        	comboObjects[i].Index = -1;	
        }
        formObj.rfa_no.value = "";
        formObj.prop_no.value = "";
        formObj.rfa_no.value="";        
        formObj.amdt_seq.value="";        
        formObj.prop_no.value="";        
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";        
        formObj.prop_srep_cd.value = "";        
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.ctrt_cust_cnt_cd.value="";
        formObj.ctrt_cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_nm.value="";
        formObj.ctrt_cust_val_sgm.value="";        
        formObj.respb_srep_cd.value = "";        
        formObj.respb_sls_ofc_cd.value="";     
        formObj.ctrt_cust_srep_nm.value="";
        formObj.tgt_mvc_qty.value="";
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
        formObj.prs_crnt_cm_amt.value = "";
        formObj.prs_estm_cm_amt.value = "";
        formObj.prs_sum_cm_amt.value = "";    
        formObj.dmdt_ft_tp_cd.value = "";
        formObj.rfa_ctrt_tp_cd.value=""; //ADD
    }
    
    /**
    * sheet의 팝업버튼이미지를 변경한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheetButtonImageChange(sheetObj, Row, sw)
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
        formObj.prop_srep_cd.value = sheetObj.CellValue(1, "prop_srep_cd");        
        formObj.prop_srep_nm.value = sheetObj.CellValue(1,"prop_srep_nm");      
        formObj.prop_apro_ofc_cd.value = sheetObj.CellValue(1,"prop_apro_ofc_cd");   
        formObj.prop_apro_staff.value = sheetObj.CellValue(1,"prop_apro_staff");        
        formObj.cre_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"cre_dt"), "ymd");        
        formObj.prop_apro_dt.value = ComGetMaskedValue(sheetObj.CellValue(1,"prop_apro_dt"),"ymd");
        formObj.ctrt_cust_cnt_cd.value = sheetObj.CellValue(1,"ctrt_cust_cnt_cd");
        if (sheetObj.CellValue(1, "ctrt_cust_seq") !="" ){
            formObj.ctrt_cust_seq.value = ComLpad(sheetObj.CellValue(1,"ctrt_cust_seq"), 6, "0");
        }else{
            formObj.ctrt_cust_seq.value = "";
        }        
        
        formObj.sls_ld_no.value = sheetObj.CellValue(1,"sls_ld_no");        
        formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"ctrt_pty_nm");        
        formObj.prc_ctrt_cust_tp_nm.value = sheetObj.CellValue(1,"prc_ctrt_cust_tp_nm");        
        formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1,"ctrt_cust_val_sgm");
        formObj.respb_sls_ofc_cd.value = sheetObj.CellValue(1,"respb_sls_ofc_cd");     
        formObj.respb_srep_cd.value = sheetObj.CellValue(1, "respb_srep_cd");
        formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1,"ctrt_cust_srep_nm");
                    
        formObj.tgt_mvc_qty.value = ComAddComma(sheetObj.CellValue(1,"tgt_mvc_qty"));
        formObj.cntr_lod_ut_cd.value = sheetObj.CellValue(1, "unit");
        formObj.dmdt_ft_tp_cd.value = sheetObj.CellValue(1,"dmdt_ft_tp_cd");

        if (formObj.dmdt_ft_tp_cd.value !="Exception"){
        	ComBtnDisable("btn_dem_pop"); 
        	document.getElementById("btn_dem").style.color = "";
        }else{
        	ComBtnEnable("btn_dem_pop"); 
        	document.getElementById("btn_dem").style.color = "black";
        }
        
        //PRS
        formObj.prs_crnt_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_crnt_cm_amt"));        
        formObj.prs_estm_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_estm_cm_amt"));
        formObj.prs_sum_cm_amt.value = ComAddComma(parseInt(sheetObj.CellValue(1,"prs_crnt_cm_amt")) 
        							 + parseInt(sheetObj.CellValue(1,"prs_estm_cm_amt")));
        formObj.rfa_ctrt_tp_cd.value = sheetObj.CellValue(1, "rfa_ctrt_tp_cd"); //ADD   
    }   
    
    /**
     * sheet2_OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br>Autorating 에서 넘어온 인자가 있는 경우 색으로 표시해준다.
     * <b>Example :</b>
     * 
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 전윤주
     * @version 2013.08.19
     */
    function sheet2_OnSearchEnd(sheetObj) {	
    	
    	var m = sheetObj.LastCol;
    	var j = 0;
    	var formObj = document.form;
    	
    	for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {    		
    		if (sheetObj.CellValue(i, "svc_scp_cd") == formObj.s_svc_scp_cd_clr.value) {
    			for (j = 0; j < m; j++) {
    				sheetObj.CellBackColor(i, j) = sheetObj.RgbColor(255,192,203);
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
        	 if(sheetObj.CellValue(NewRow,"svc_scp_cd")!="" 
        		 && OldRow!=NewRow&&sheetObj.CellValue(NewRow,"ibflag")!="I"){                 
                 comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow,"svc_scp_cd"));
                 
                 tab1_OnChange(tabObjects[0], tabObjects[0].SelectedIndex); 
                 //setTabText();
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
            if (durDay != 0){
            	mvcQty = ComRound((mqcQty / durDay * 7),0);
            }        	
        }   
        formObj.prop_mvc.value = ComAddComma(mvcQty);        
        formObj.prop_mvc_tp.value = formObj.cntr_lod_ut_cd.value;
        
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
        if (formObj.ctrt_cust_cnt_cd.value !="" && formObj.ctrt_cust_seq.value !=""){         
            formObj.f_cmd.value = COMMAND20;       
           
            sParam = FormQueryString(formObj) +"&etc1="+formObj.respb_sls_ofc_cd.value;
            sXml = sheetObj.GetSearchXml("PRICommonGS.do",sParam);
            ComPriXml2ComboItem(sXml, formObj.respb_srep_cd, "cd", "cd|nm");
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
    * SaleRep.의 Office Code를 조회한다.<br>
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
        formObj.respb_srep_cd.value = "";
        formObj.ctrt_cust_val_sgm.value = "";
        formObj.respb_sls_ofc_cd.value = "";
        formObj.ctrt_cust_srep_nm.value = "";
        formObj.prc_ctrt_cust_tp_nm.value ="";
        
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
	function comApplyStyleProposalStatusSummary(svcScpCd) {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_2019GS.do", FormQueryString(formObj) + "&svc_scp_cd=" + svcScpCd);
		var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
		var icon = "";
		var tabIdx = "";
		var imgName = "";
		var expDt = ComGetUnMaskedValue(document.form.ctrt_eff_dt.value, "ymd");
		for (i = 0; i < arrText.length; i++) {
			tabIdx = "";
			imgName = "";
			switch (arrText[i][0]) {
			case '01': //Duration,Scope Duration
				imgName = "";
				break;
			case '02': //MQC,Scope MQC
				imgName = "";
				break;
			case '05':
				imgName = "img_affil";
				break;
			case '08':
				imgName = "";
				break;
			case '13': //Group Location
				tabIdx = "1";
				break;
			case '14': //Group Commodity
				tabIdx = "2";
				break;
			case '32': //Special Note
				tabIdx = "4";
				break;
			case '52': //Arbitrary                 
				tabIdx = "3";
				break;
			case '71': //Rate   
				tabIdx = "0";
				break;
			}
			icon = ICON_URL_NOT_EXIST;
			switch (arrText[i][1]) {
			case "1":
			case "2":
			case "3":
				icon = ICON_URL_EXIST;
				break;
			}
			// 기본 : Black , Amend시 : Red, All Accept시 : Blue
			if (arrText[i][0] == "01" || arrText[i][0] == "02" || arrText[i][0] == "05" || arrText[i][0] == "08") {
				if (imgName != "")
					document.images(imgName).src = icon;
			} else {
				if (tabIdx != "")
					tabObjects[0].ImageUrl(tabIdx) = icon;
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
         var sRfaNo = sheetObj.CellValue(1,"rfa_no");
         var sPropNo = sheetObj.CellValue(1,"prop_no");
         var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
         var sSvcScpCd = "";
         var aParam = "";
         var sCtrtEffDt = document.form.ctrt_eff_dt.value;
         var sCtrtExpDt = document.form.ctrt_exp_dt.value;  
         
         var sParam = "sRfaNo="+sRfaNo+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq;

         switch (srcName) {        
            case "btn_afil_pop":
                aParam = "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;               
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
	 * 2012.09.20일 추가 Tab에 따른 Tab Lay 밑 URL 설정
	 * 
	 * @param tabIndex
	 */
	function getFrameTabId(tabIndex) {
		var frameId = "";
		var sUrl = "";
		var divIndex = "";
		
		//SPOT
		//case 2를 적용하지 못하도록 상단에 tabIndex 가 1 이상일 경우 tabIndex를 +1 로 
		if(tabIndex > 2){
			tabIndex = tabIndex + 1;
		} else {
			tabIndex = tabIndex;
		}
		
		switch (tabIndex) {
	    	case 0: {
	    		var index = checkArbiRate();
	    		if (index == 0) {
	    			frameId = "t1frame";
	    			sUrl = "ESM_PRI_2119_07.do";	//Rate
	    			divIndex = "tabLayer1";
	    		} else if (index == 1) {
	    			frameId = "t2frame";
	    			sUrl = "ESM_PRI_2119_08.do";	//Rate (For AEE/AEW)
	    			divIndex = "tabLayer2";
	    		} else if (index == 2) {
	    			frameId = "t3frame";
	    			sUrl = "ESM_PRI_2119_13.do";	//Rate (For Add On Tariff)
	    			divIndex = "tabLayer3";
	    		}
	    		break;
	    	}
	    	case 1: {
	    		frameId = "t4frame";
	    		sUrl = "ESM_PRI_2119_02.do";	//Location Group
	    		divIndex = "tabLayer4";
	    		break;
	    	}
	    	case 2: {
	    		frameId = "t5frame";
	    		sUrl = "ESM_PRI_2119_03.do";	//Commodity Group
	    		divIndex = "tabLayer5";
	    		break;
	    	}
	    	case 3: {
	    		var index = checkArbiRate();
	    		if (index == 0) {
	    			frameId = "t6frame";
	    			sUrl = "ESM_PRI_2119_04.do";	//Arbitrary
	    			divIndex = "tabLayer6";
	    		} else if (index == 1) {
	    			frameId = "t7frame";
	    			sUrl = "ESM_PRI_2119_09.do";	//Arbitrary (For AEE/AEW)
	    			divIndex = "tabLayer7";
	    		} else if (index == 2) {
	    			frameId = "t8frame";
	    			sUrl = "ESM_PRI_2119_12.do";	//Arbitrary (For Add On Tariff)
	    			divIndex = "tabLayer8";
	    		}
	    		break;
	    	}
	    	case 4: {
	    		frameId = "t9frame";
	    		sUrl = "ESM_PRI_2119_01.do";	//Special Note
	    		divIndex = "tabLayer9";
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


	/**
	 * Tab Text변경
	 */
	function setTabText() {
		var index = checkArbiRate();
		if (index == 0 || index == 2) {
			tabObjects[0].TabText(0) = "Rate";
			tabObjects[0].TabText(3) = "Arbitrary";
		} else if (index == 1) {
			tabObjects[0].TabText(0) = "Rate For AEE/AEW";
			tabObjects[0].TabText(3) = "Arbitrary For AEE/AEW";
		}
	}
	
	 /**
	 * Hinterland Project에 따른 Arbitrary/Rate 구분
	 */
	function checkArbiRate() {
		var formObj = document.form;
		var rsltIndex = 0;
		var svcScpCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "svc_scp_cd");
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
    
    /* 개발자 작업 끝 */    