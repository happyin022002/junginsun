
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_PRI_0087.js
*@FileTitle : S/C Proposal & Amendment View
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2011.08.09 김민아
* 1.0 Creation
===========================================================
* History
* 2011.08.09 김민아 [CHM-201112688-01] Contract별 Inquiry 화면을 요청 : 특정 S/C 한건에 대한 조회  View Popup 신규 개발
* 2012.04.18 [CHM-201216522-01] BKG 화면에서 S/C 조회시 REAL CUSTOMER POPUP 추가
* 2013.09.05 전윤주 [CHM-201326372] Autorating 결과 계약 조회시 편의 기능 구현
                                - Autorating 에서 사용된 commodity, Route 일 경우 색 변경해줌
===========================================================*/
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
     * @class ESM_PRI_0087 : ESM_PRI_0087 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0087() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
//        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    //수정 후 수정한 scope으로 focus를 이동 하기 위한 변수
    var preSvcScpCd = "";
    var preScustCntCd = "";
    var prePropOfcCd  = "";
    var preScustSeq = "";
    
    var controlHidden = false;
    var timer =0;
    var backEndJobCnt = 0;
    
    //IHC Tab  을 enable,disable시킨다. 
    var ihcTabSts = true;
    
    var ICON_URL_NOT_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon1.gif"; 
    var ICON_URL_EXIST = "http://" + location.hostname + ":" + location.port + "/hanjin/img/tab_icon2.gif";

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
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }

            switch (srcName) {

            case "btn_hidden":            	
            	setControlHidden();
            	break;
            	
            case "btn_blpl_pop":
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0047.do?"+getParameters("btn_blpl_pop"), "", 900, 390, true);
                break;
                
            case "btn_ctrt_pty_pop":
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0078.do?"+getParameters("btn_ctrt_pty_pop"), "", 900, 350, true);     
                break;
                
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0048.do?"+getParameters("btn_afil_pop"), "", 1020, 295, true);
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
           
            case "btn_real_cust_pop":
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0041.do?"+getParameters("btn_real_cust_pop"), "", 980, 350, true);     
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
     function getParameters(srcName){        
         var sheetObj = sheetObjects[0];
         var sheetScp = sheetObjects[1];
         var formObj = document.form;
         
         var sSc_No1 = sheetObj.CellValue(1,"sc_no1");   
         var sSc_No2 = sheetObj.CellValue(1,"sc_no2");
         var sPropNo = sheetObj.CellValue(1,"prop_no");
         var sAmdtSeq = sheetObj.CellValue(1, "amdt_seq");
         var sParam = "";

         var sParam = "sSc_No1="+sSc_No1+ "&sSc_No2="+sSc_No2+"&sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq

         switch (srcName) {        
            case "btn_blpl_pop":
                var sCtrtEffDt = formObj.ctrt_eff_dt.value;
                var sCtrtExpDt = formObj.ctrt_exp_dt.value;
                var sBlplHdrSeq = sheetObj.CellValue(1, "blpl_hdr_seq"); 
                sParam += "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt +"&sBlplHdrSeq="+sBlplHdrSeq;;
                break;
            case "btn_ctrt_pty_pop":
                var sCustCntCd = sheetObj.CellValue(1, "cust_cnt_cd");
                var sCustSeq = ComLpad(sheetObj.CellValue(1, "cust_seq"), 6, "0");                        
                var sCustNm = ComReplaceStr(sheetObj.CellValue(1, "ctrt_pty_nm"),"'"," ");//확인요
                sParam += "&sCustCntCd="+sCustCntCd+"&sCustSeq="+sCustSeq+"&sCustNm="+sCustNm;
                break;

            case "btn_afil_pop":
                var sCtrtEffDt = formObj.ctrt_eff_dt.value;
                var sCtrtExpDt = formObj.ctrt_exp_dt.value;         
                sParam += "&sCtrtEffDt="+sCtrtEffDt+"&sCtrtExpDt="+sCtrtExpDt;
                break;
            } 
         return sParam;
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
            sheetObjects[i].XmlHttpVer = 2;
        }
    
        for (var k = 0; k < tabObjects.length; k++) {
            initTab(tabObjects[k], k + 1);
        }
        
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
    	 axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
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
        case "oti_no":
        	if (formObj.oti_eff_dt.value != "" && formObj.oti_exp_dt.value != ""){
            	var title = "Effective:"+ ComGetMaskedValue(formObj.oti_eff_dt,"ymd") +" ~ Expiry Date:" + ComGetMaskedValue(formObj.oti_exp_dt,"ymd") + "  AMT:"+ ComAddComma(formObj.oti_amt.value);
            	document.getElementById("oti_no").title = title;
        	}else{
        		document.getElementById("oti_no").title = "...............";
        	}
            break;
        default:
 
        }    	
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
            	
            	formObj.sc_no.value = formObj.in_sc_no.value;
        		formObj.prop_no.value = formObj.in_prop_no.value;
        		formObj.amdt_seq.value = formObj.in_amdt_seq.value;
            	
            	preSvcScpCd = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "svc_scp_cd");
            	
            	sheetObj = sheetObjects[0];
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0087GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);    // sheet1. hidden sheet - main 데이터
                clearAllTabPages();
                if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);            
                loadTabPage(beforetab);
                calcMVC();                     
                doActionIBSheet(sheetObjects[0], document.form, COMMAND10);
                ComOpenWait(false); //->waiting->End
                tabObjects[0].TabEnable(8) = ihcTabSts; //IHC Tab
                break;
                
            case COMMAND10: //backendjob 조회    	 
            	formObj.prop_pfmc.value="";
            	formObj.prop_atmt.value="";
            	backEndJobCnt = 0;
    	        if (validateForm(sheetObj,document.form,sAction)) {		
    	        	formObj.f_cmd.value = SEARCH14;	
    				var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0087GS.do", FormQueryString(formObj));			
    				var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
    				if (backendJobKey != null && backendJobKey.length > 0) {
    					formObj.backendjob_key.value = backendJobKey;
    					window.setTimeout(getBackEndJobStatus, 5000);
    				}
    	        }	
    			break; 	            
                      
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	if (sAction == COMMAND10) {
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
                
                
                var HeadTitle  = "|sc_no1|sc_no2|prop_no|amdt_seq|ctrt_eff_dt|ctrt_exp_dt|rf_flg|gamt_flg|prop_sts_cd|prop_sts|prop_ofc_cd|prop_srep_cd|prop_srep_nm|prop_apro_ofc_cd|prop_apro_dt|prop_apro_staff";
                HeadTitle += "|cre_dt|file_dt|cust_cnt_cd|cust_seq|ctrt_pty_nm|prc_ctrt_pty_tp_cd|prc_ctrt_cust_tp_cd|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_sls_ofc_cd";
                HeadTitle += "|ctrt_cust_srep_cd|ctrt_cust_srep_nm|real_cust_cnt_cd|real_cust_seq|real_cust_nm|real_cust_tp_cd|real_cust_val_sgm_cd|real_cust_val_sgm";
                HeadTitle += "|real_cust_sls_ofc_cd|real_cust_srep_cd|real_cust_srep_nm|prop_mqc_qty|cntr_lod_ut_cd|unit|sls_ld_no|blpl_hdr_seq";
                HeadTitle += "|ctrt_pty_addr|ctrt_pty_sgn_nm|ctrt_pty_sgn_tit_nm|oti_no";
                HeadTitle += "|oti_eff_dt|oti_exp_dt|oti_amt|act_cm|est_cm"
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
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sc_no1", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "sc_no2", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "amdt_seq", false, "", dfNone, 0, false, false);                          
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_eff_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_exp_dt", false, "", dfNone, 0, false, false);          
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "rf_flg", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "gamt_flg", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_sts", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_cd", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_srep_nm", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_ofc_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_dt", false, "", dfNone, 0, false, false);   
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prop_apro_staff", false, "", dfNone, 0, false, false); 
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
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_addr", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_nm", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "ctrt_pty_sgn_tit_nm", false, "", dfNone, 0, false, false);
                
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_exp_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "oti_amt", false, "", dfNullFloat, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_crnt_cm_amt", false, "", dfInteger, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 90, daLeft, false, "prs_estm_cm_amt", false, "", dfInteger, 0, false, false);     
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
    
                var HeadTitle =  "|Seq.|Prop No|Amendment Seq|SVC Scope|Approval Office|Request Office|MQC|MQC|MQC|Sales Rep|Duration|Duration|eff_dt"; //14
                    HeadTitle += "|exp_dt|n1st_cmnc_dt|pre_exp_dt|Status|Status|Note Header Seq|Status";
                    HeadTitle += "|req_usr_flg|apro_usr_flg|prc_prog_sts_cd|src_info_cd|submqcori|PRE_EXT_SCP|dur_dup_flg";                 
                var headCount = ComCountHeadTitle(HeadTitle);
                
                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
    
                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq, 50,  daCenter, false, "seq");
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "prop_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "amdt_seq", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtData,    90,  daCenter, false, "svc_scp_cd", false, "", dfNone, 0, false, false, 3);
                InitDataProperty(0, cnt++, dtData,    120, daCenter, false, "prop_scp_apro_ofc_cd", false, "", dfNone, 0, false, false, 6);                
                InitDataProperty(0, cnt++, dtData,    120, daCenter, false, "prop_scp_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData,    90,  daRight,  false, "prop_scp_mqc_qty", false, "", dfInteger, 0, false, false);             
                InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtData,    50,  daCenter, false, "unit_nm", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtData,    100, daCenter, false, "prop_scp_srep_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData,    85,  daCenter, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData,    85,  daCenter, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, true);               
                InitDataProperty(0, cnt++, dtHidden,  95,  daCenter, false, "eff_dt", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,  95,  daCenter, false, "exp_dt", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtHidden,  95,  daCenter, false, "n1st_cmnc_dt", false, "", dfNone, 0, false, false);                
                InitDataProperty(0, cnt++, dtHidden,  95,  daCenter, false, "pre_exp_dt", false, "", dfDateYmd, 0, true, true);             
                InitDataProperty(0, cnt++, dtHidden,  60,  daCenter, false, "prop_scp_sts_cd", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtData,    60,  daCenter, false, "prop_scp_sts", false, "", dfNone, 0, false, false, 100);                
                InitDataProperty(0, cnt++, dtHidden,  200, daCenter, false, "note_hdr_seq", false, "", dfNone, 0, true, true, 100);               
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "prop_scp_sts", false, "", dfNone, 0, true, true, 100);                            
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "req_usr_flg", false, "", dfNone, 0, true, true, 100);                
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "apro_usr_flg", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "prc_prog_sts_cd", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "src_info_cd", false, "", dfNone, 0, true, true, 100);                
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "prop_scp_mqc_qty_ori", false, "", dfInteger, 0, true, true);
                InitDataProperty(0, cnt++, dtHidden,  100, daCenter, false, "pre_ext_scp", false, "", dfNone, 0, true, true, 100);
                InitDataProperty(0, cnt++, dtHidden,  90,  daLeft,   false, "dur_dup_flg", false, "", dfNone, 0, false, false);

                ShowButtonImage = 2;
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
        switch (sAction) {
        case COMMAND10: // backendjob   	        
	        if (formObj.sc_no.value == "" || formObj.prop_no.value == "") {
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
        if (beforetab != tabIndex) {
            var objs = document.all.item("tabLayer");
            objs[tabIndex].style.display = "inline";
            objs[beforetab].style.display = "none";            
        }

        beforetab = tabIndex;
        loadTabPage(tabIndex);
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
    function loadTabPage(tabIndex) {

        if (tabIndex == null || tabIndex == "") {
            tabIndex = tabObjects[0].SelectedIndex;
        }
        
        var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
        
        if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
            var sUrl = "";
            switch (tabIndex) {
            case 0:
                sUrl = "ESM_PRI_0004_01.do"; 
                break;
            case 1:
                sUrl = "ESM_PRI_0004_02.do"; 
                break;
            case 2:
                sUrl = "ESM_PRI_0004_03.do"; 
                break;
            case 3:
                sUrl = "ESM_PRI_0004_04.do"; 
                break;
            case 4:
                sUrl = "ESM_PRI_0004_09.do"; 
                break;
            case 5:
                sUrl = "ESM_PRI_0004_08.do"; 
                break;
            case 6:
                sUrl = "ESM_PRI_0004_10.do"; 
                break;
            case 7:
                sUrl = "ESM_PRI_0004_07.do"; 
                break;
            case 8:
                sUrl = "ESM_PRI_0004_05.do"; 
                break;
            case 9:
                sUrl = "ESM_PRI_0004_06.do"; 
                break;              
            }
            objTabWindow.location.href = sUrl;
            return true;
        }
        
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var sRow = sheetObj2.SelectRow;
        var sPropNo = sheetObj2.CellValue(sRow,"prop_no");
        var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
        var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");
        
        //하위 Rate 탭 색 변경을 위한 파라미터
        var sSvcScpCdClr = document.form.s_svc_scp_cd_clr.value;
        var sCmdtHdrSeqClr = document.form.s_cmdt_hdr_seq_clr.value;
        var sRoutSeqClr = document.form.s_rout_seq_clr.value;
        var sGenSpclRtTpCdClr = document.form.s_gen_spcl_rt_tp_cd_clr.value;
        
//        alert("0087의 load sheet");
//        alert(sSvcScpCdClr);
//        alert(sCmdtHdrSeqClr);
//        alert(sRoutSeqClr);
        
        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sheetObj2.CellValue(sRow, "ibflag")!="I") {
        	try{
        		document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sSvcScpCdClr, sGenSpclRtTpCdClr, sCmdtHdrSeqClr, sRoutSeqClr);
        	}catch(eee){}
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
     var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0087GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd);
     var arrText = ComPriXml2Array(sXml, "prop_scp_term_tp_cd|dat_flg");
     var icon = "";
     var tabIdx = "";
     var imgName = "";

     for (i = 0; arrText!= null && i < arrText.length; i++){
    	 imgName = "";
    	 tabIdx = "";
    	 switch(arrText[i][0]){
	     	case '01':  //Duration,Scope Duration
	         	imgName = "";
	             break;
	         case '02':  //MQC,Scope MQC
		         	imgName = "";
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
    	 }

         // 기본 : Black 
         if (arrText[i][0] == "01" || arrText[i][0] =="02"||arrText[i][0] == "04"||arrText[i][0] == "05"||arrText[i][0] == "06" ){
        	 if (imgName !="") document.images(imgName).src = icon;
         }else{
             if (tabIdx != ""){
            	 tabObjects[0].ImageUrl(tabIdx) = icon;	 
             }
        	  
         	}   
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
        formObj.sc_no.value = sheetObj.CellValue(1,"sc_no1") +  sheetObj.CellValue(1,"sc_no2");
        formObj.prop_no.value = sheetObj.CellValue(1,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(1,"amdt_seq");
        formObj.ctrt_eff_dt.value = sheetObj.CellValue(1,"ctrt_eff_dt");
        formObj.ctrt_exp_dt.value = sheetObj.CellValue(1,"ctrt_exp_dt");
        formObj.rf_flg.checked = sheetObj.CellValue(1,"rf_flg")=="Y"?true:false;
        formObj.gamt_flg.checked = sheetObj.CellValue(1,"gamt_flg")=="Y"?true:false;
        formObj.prop_sts.value = sheetObj.CellValue(1,"prop_sts");
        formObj.prop_ofc_cd.value = sheetObj.CellValue(1,"prop_ofc_cd"); 
        formObj.prop_srep_cd.value = sheetObj.CellValue(1,"prop_srep_cd");    
        formObj.prop_srep_nm.value = sheetObj.CellValue(1,"prop_srep_nm");  
        
        formObj.prop_apro_ofc_cd.value = sheetObj.CellValue(1,"prop_apro_ofc_cd");
        formObj.prop_apro_staff.value =  sheetObj.CellValue(1,"prop_apro_staff");
        formObj.cre_dt.value = sheetObj.CellValue(1,"cre_dt");
        formObj.file_dt.value = sheetObj.CellValue(1,"file_dt");
        formObj.cust_cnt_cd.value = sheetObj.CellValue(1,"cust_cnt_cd");
        if (sheetObj.CellValue(1, "cust_seq") !="" ){
            formObj.cust_seq.value = ComLpad(sheetObj.CellValue(1,"cust_seq"), 6, "0");
        }else{
            formObj.cust_seq.value = "";
        }
        
        formObj.ctrt_pty_nm.value = sheetObj.CellValue(1,"ctrt_pty_nm");
        formObj.prc_ctrt_cust_tp_cd.value = sheetObj.CellValue(1,"prc_ctrt_cust_tp_cd");         
        formObj.ctrt_cust_val_sgm.value = sheetObj.CellValue(1,"ctrt_cust_val_sgm");
        formObj.ctrt_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"ctrt_cust_sls_ofc_cd");
        formObj.ctrt_cust_srep_cd.value = sheetObj.CellValue(1,"ctrt_cust_srep_cd");    
        formObj.ctrt_cust_srep_nm.value = sheetObj.CellValue(1,"ctrt_cust_srep_nm");        
        formObj.real_cust_cnt_cd.value = sheetObj.CellValue(1,"real_cust_cnt_cd");
        if (sheetObj.CellValue(1, "real_cust_seq") !="" ){
            formObj.real_cust_seq.value = ComLpad(sheetObj.CellValue(1,"real_cust_seq"), 6, "0");
        }else{
            formObj.real_cust_seq.value = "";
        }
        
        formObj.real_cust_nm.value = sheetObj.CellValue(1,"real_cust_nm");
        formObj.real_cust_tp_cd.value = sheetObj.CellValue(1,"real_cust_tp_cd");           
        formObj.real_cust_val_sgm.value = sheetObj.CellValue(1,"real_cust_val_sgm");
        formObj.real_cust_sls_ofc_cd.value = sheetObj.CellValue(1,"real_cust_sls_ofc_cd");
        formObj.real_cust_srep_cd.value = sheetObj.CellValue(1,"real_cust_srep_cd");
        formObj.real_cust_srep_nm.value = sheetObj.CellValue(1,"real_cust_srep_nm");         
        formObj.prop_mqc_qty.value = ComAddComma(sheetObj.CellValue(1,"prop_mqc_qty"));
        formObj.cntr_lod_ut_cd.value = sheetObj.CellValue(1,"unit");

        //OTI
        formObj.oti_no.value = sheetObj.CellValue(1, "oti_no");
        formObj.oti_eff_dt.value = sheetObj.CellValue(1, "oti_eff_dt");
        formObj.oti_exp_dt.value = sheetObj.CellValue(1, "oti_exp_dt");
        formObj.oti_amt.value = sheetObj.CellValue(1, "oti_amt");        
        //sale lead
        formObj.sls_ld_no.value  = sheetObj.CellValue(1,"sls_ld_no");
        
        //PRS
        formObj.prs_crnt_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_crnt_cm_amt"));        
        formObj.prs_estm_cm_amt.value = ComAddComma(sheetObj.CellValue(1,"prs_estm_cm_amt"));
        formObj.prs_sum_cm_amt.value = ComAddComma(parseInt(sheetObj.CellValue(1,"prs_crnt_cm_amt")) 
        							 + parseInt(sheetObj.CellValue(1,"prs_estm_cm_amt")));

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
        		var ihcScope ="AEE, AEW, TAW, TAE, ASW, ASE"
                if (ihcScope.indexOf(sheetObj.CellValue(NewRow,"svc_scp_cd")) != -1){
                	ihcTabSts = true;
                }else{
                	ihcTabSts = false;
                }        	
            	comApplyStyleProposalStatusSummary(sheetObj.CellValue(NewRow,"svc_scp_cd"));
            	//0728
        		if (tabObjects[0].SelectedIndex == 0) {
        			tab1_OnChange(tabObjects[0], 0);
        		} else {
        			tabObjects[0].SelectedIndex = 0;
        		}    		
                loadTabPage(beforetab); 
            }
        } catch (e) {
          	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	ComOpenWait(false); //->waiting->End
        	tabObjects[0].TabEnable(8) = ihcTabSts;//IHC Tab 
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
        formObj.prop_mvc.value = ComAddComma(mvcQty);
        formObj.prop_mvc_tp.value = formObj.cntr_lod_ut_cd.value;
        
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
		document.images("img_blpl").src = ICON_URL_NOT_EXIST;
		document.images("img_ctrt").src = ICON_URL_NOT_EXIST;
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
	    document.getElementById("btn_blpl").style.color = "black";
	    document.getElementById("btn_afil").style.color = "black";
	    document.getElementById("btn_ctrt_pty").style.color = "black";
	    document.form.rf_flg.disabled = true;         //reefer                    
	    document.form.gamt_flg.disabled = true;       //garment
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
	 * Customer Type 코드를 return 하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *	getCustTypeCode();
	 * </pre>
	 * @return String form value
	 * @author 최성민
	 * @version 2009.06.18
	 */ 
	function getCustTypeCode() {
		var formObj = document.form;
		var custTpCd = formObj.prc_ctrt_cust_tp_cd.value;
		return custTpCd;
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
	
	if (backEndJobCnt == 5){
		backEndJobCnt = 0;
		return;
	}
	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0087GS.do", FormQueryString(form));
	var jobState = ComGetEtcData(sXml, "jb_sts_flg");
	if (jobState == undefined){
		backEndJobCnt = 0;
		return;
	}
	form.job_status.value = jobState;
		if (jobState == "3") {
			getBackEndJobSearch();
			backEndJobCnt = 5;
		} else if (jobState == "4") { // BackEndJob을 실패 하였습니다.
			backEndJobCnt = 5;
		} else if (jobState == "5") {
			backEndJobCnt = 5;
		} else {
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
	 	var sXml = sheetObjects[0].GetSearchXml("ESM_PRI_0087GS.do", FormQueryString(form));
	    
	 	var arrData = ComPriXml2Array(sXml, "op_cntr_qty|pro_rt_mqc_perf");
	    if (arrData != null && arrData.length > 0) {
	    	form.prop_pfmc.value = ComAddComma(arrData[0][0]);
	    	form.prop_atmt.value = ComAddComma(arrData[0][1]);
	    }        
	    
	}
    
    /* 개발자 작업  끝 */

