/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0004.js
*@FileTitle : Proposal & Amendment Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.09.25 공백진
* 1.0 Creation
=========================================================
* History
* 2011.05.25 이행지 [CHM-201111048-01] EFF Date 날짜 Validation Retreive 버튼 클릭시 추가
* 2011.10.18 서미진 [CHM-201113907] S/C 화면에서 복수의 Real customer 입력 가능토록 시스템 보완개발요청 [Inquiry 화면] (ESM_PRI_0041)
* 2011.11.18 서미진 [CHM-201114462] SC No. 를 한칸으로 변경하여 copy & paste 기능 이용 할 수 있도록 정정요청
* 2012.02.03 이석준[CHM-201215685] CHSS_EXPT_FLG, GRI_APPL_FLG, NEW_SCG_FLG 추가 컬럼 조회 반영
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
     * @class ESM_PRI_0004 : ESM_PRI_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_0004() {
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
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
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
            	
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
                break;    
            case "btn_new":
                doActionIBSheet(sheetObjects[1],document.form,IBCREATE);
                break;                
            case "btn_ctrt_cust":
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_4014.do?is_popup=true&nmd_cust_flg=N&cust_cnt_cd="+formObj.scust_cnt_cd.value+"&cust_seq="+formObj.scust_seq.value, "", 640, 460, true);
                if (rtnVal != null){
                    formObj.scust_cnt_cd.value = rtnVal.custCntCd;
                    formObj.scust_seq.value = rtnVal.custSeq;
                    formObj.sctrt_pty_nm.value = rtnVal.custNm;
                }
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
            case "btn_real_cust_pop":
                var formObj = document.form;                
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0041.do?"+getParameters("btn_real_cust_pop"), "", 980, 350, true);     
                break;    
            case "btn_afil_pop":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }                
                var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_0048.do?"+getParameters("btn_afil_pop"), "", 1020, 295, true);

                break;
            case "btns_calendar1": //달력버튼
            case "btns_calendar2":
                var cal = new ComCalendarFromTo();                
                cal.select(document.form.seff_dt1, document.form.seff_dt2, 'yyyy-MM-dd');

                break;  
            case "btn_proposal":
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }	
	 			var pgmNo = "ESM_PRI_0003";
	 			var pgmUrl = "/hanjin/ESM_PRI_0003.do"
	    		var params = "&cond_prop_no=" + formObj.prop_no.value;
				var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
				var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
            	            	
            	break;      
            case "btn_history":
                if (formObj.sc_no.value ==""){
                    ComShowCodeMessage('PRI02014');
                    return;
                }              	
                if (formObj.prop_no.value ==""){
                    ComShowCodeMessage('PRI01021');
                    return;
                }
       
	 			var pgmNo = "ESM_PRI_0057";
	 			var pgmUrl = "/hanjin/ESM_PRI_0057.do"
	    		var params = "&sc_no_0062=" + formObj.sc_no.value;
				var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
	 			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^") + "&pgmNo=" + pgmNo + params;
				var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
				var winObj = window.open("alpsMain.screen?parentPgmNo=" + parentPgmNo + src, "", sFeatures);  
            	            	
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
         var sheetObj = sheetObjects[1];
         var sheetScp = sheetObjects[2];
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
            case "btn_real_cust_pop":
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
        initFormControl();
        sheetObjects[1].DataInsert();
        doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01); 

        // esm_bkg_0427, esm_bkg_0151 에서 메인 pop => 김대호 2009-10-06 : jsp 에도  파라미터 받고 박아주는것 추가합니다.
        var chkSearch = false;
   	 	var form = document.form;
   	 	var sc_no_code = "";
   	 	var sc_no_seq = "";
   	 	
        if("null" != form.sc_no_p.value && null != form.sc_no_p.value && "" != form.sc_no_p.value) {
        	sc_no_code = form.sc_no_p.value;
        }
        if("null" != form.sc_no_s.value && null != form.sc_no_s.value && "" != form.sc_no_s.value) {
        	sc_no_seq = form.sc_no_s.value;
        }
        if(sc_no_code != "" && sc_no_seq !=""){
        	form.sc_no_input.value = sc_no_code+sc_no_seq ;
        }        
        if("null" != form.sc_no_input.value && null != form.sc_no_input.value && "" != form.sc_no_input.value) {
        	chkSearch = true;        	
        }
        if("null" != form.sprop_no.value && null != form.sprop_no.value && "" != form.sprop_no.value) {
        	chkSearch = true;
        }
        if("null" != form.eff_dt.value && null != form.eff_dt.value && "" != form.eff_dt.value) {
        	form.seff_dt1.value = form.eff_dt.value;
        	chkSearch = true;
        }
        if("null" != form.exp_dt.value && null != form.exp_dt.value && "" != form.exp_dt.value) {
        	form.seff_dt2.value = form.exp_dt.value;
        	chkSearch = true;
        }
        if(chkSearch) {
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        }else{
//        	form.sprop_ofc_cd.value = form.in_usr_ofc_cd.value;
        	
        	ComPriTextCode2ComboItem(saleListValue, saleListText, getComboObject(comboObjects, 'sprop_srep_cd') ,"|","\t" );
            var rDate = new Date();
            var yy = rDate.getFullYear();
            var mm = rDate.getMonth() + 1 +"";
            var dd = rDate.getDate() +"";
            if (mm.length == 1) mm = "0" + mm;
            if (dd.length == 1) dd = "0" + dd;              
        	
        	form.seff_dt1.value = ComGetMaskedValue(yy+mm+dd,"ymd","-");
        	form.seff_dt2.value = form.seff_dt1.value;
        }
        
        form.sc_no_input.focus();
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
        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);        
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
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
       var keyValue = null;
       if(event == undefined || event == null) {
    	   keyValue = 13;
       }else{
    	   keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
           switch (eleName){
//           case "ssc_no2":
           case "sprop_no":
           case "seff_dt1":
           case "seff_dt2":
           case "sprop_ofc_cd":
           case "scust_cnt_cd":
           case "scust_seq":
           case "sprop_mqc_qty":
        	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
        	   break;
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
                if (event.srcElement.name == "sc_no_input" || event.srcElement.name == "sprop_no") {
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
        var sheetObj = sheetObjects[1]; 
        var sheetObj1 = sheetObjects[1]; 
        var sheetObj0 = sheetObjects[0];
        var eleName = event.srcElement.name;

        switch(eleName){
	        case "sprop_no":
	        	break; 	        	
        	case "prop_mqc_qty":
        		ComChkObjValid(event.srcElement);
                break;
            case "prop_mvc":
            	ComChkObjValid(event.srcElement);
                break;
            case "scust_cnt_cd":
                //cust name find
                if (preScustCntCd != formObj.scust_cnt_cd.value){
                	if (formObj.scust_cnt_cd.value == ""){
                		sClearCustName();
                		preScustCntCd = "";
                	}else{
                    	sCustNameFind(eleName);
                    	preScustCntCd = formObj.scust_cnt_cd.value;
                	}
                }
                ComChkObjValid(event.srcElement);
                break;          
            case "scust_seq":
                var custSeq = formObj.scust_seq.value;
                if (custSeq.length < 6 && custSeq.length != 0 ){
                    formObj.scust_seq.value = ComLpad(custSeq, 6, "0");
                }
                if (ComParseInt(preScustSeq) != ComParseInt(formObj.scust_seq.value)){
                    if (formObj.scust_seq.value == ""){
                    	sClearCustName();
                    }else{
                    	sCustNameFind(eleName);
                    }
                    preScustSeq = ComParseInt(formObj.scust_seq.value);
                }

                break;
                         
            case "sprop_ofc_cd":            	
            	if (formObj.sprop_ofc_cd.value == ""){
                	formObj.sprop_srep_nm.value = "";
                	comboObjects[2].RemoveAll();
                	prePropOfcCd = "";
            	}else if (prePropOfcCd != formObj.sprop_ofc_cd.value){
                    var sheetObj = sheetObjects[1];                                                 
                    var cd = formObj.sprop_ofc_cd.value;         
                    formObj.f_cmd.value = COMMAND22;
                    var sParam = FormQueryString(formObj)+"&cd="+cd;
                    var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
                    var arrData = ComPriXml2Array(sXml, "cd|nm");
                    if (arrData != null && arrData.length > 0) {
                    	setRequestOffice();
                    }else{  
                        formObj.sprop_ofc_cd.value = "";
                    	formObj.sprop_srep_nm.value = "";
                    	comboObjects[2].RemoveAll();
                        formObj.sprop_ofc_cd.focus();
                    }
                    prePropOfcCd = formObj.sprop_ofc_cd.value;                    
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
            	preSvcScpCd = sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "svc_scp_cd");
            	
            	sheetObj = sheetObjects[1];
                formObj.f_cmd.value = SEARCH01;
                var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0004GS.do" , FormQueryString(formObj));
                var arrXml = sXml.split("|$$|");
                if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);    // sheet1. hidden sheet - main 데이터
                clearAllTabPages();
                if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);            
                loadTabPage(beforetab);
                calcMVC();                     
                doActionIBSheet(sheetObjects[1], document.form, COMMAND10);
                ComOpenWait(false); //->waiting->End
                tabObjects[0].TabEnable(8) = ihcTabSts; //IHC Tab
                break;
            case IBSEARCH_ASYNC03: // 
            	ComOpenWait(true); //->waiting->start
              if (!validateForm(sheetObjects[0],document.form,sAction)) {
            	  return false;
              }	        
            	formObj.f_cmd.value = SEARCH;
            	formObj.ssc_no.value = formObj.sc_no_input.value;
              	formObj.smqc_sign_nm.value = getComboObject(comboObjects, 'smqc_sign_cd').Text;

    	        sheetObj.doSearch("ESM_PRI_0004GS.do", FormQueryString(formObj));
    	        ComOpenWait(false); //->waiting->End
    	        break;            
            case IBCREATE: // New

                clearAllForms();
                clearAllTabPages();
                clearButtonImages();
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();            
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01); 
                formObj.sc_no_input.focus();
                break;        

            case IBSEARCH_ASYNC01: // Approval Office Code, customer type 설정
            	
            	comboObjects[0].RemoveAll();
    	        comboObjects[1].RemoveAll();
    	        comboObjects[2].RemoveAll();
    	        comboObjects[3].RemoveAll();
    	    	comboObjects[4].RemoveAll();
    	        comboObjects[5].RemoveAll();
    	        
    	        ComPriTextCode2ComboItem(appListValue, appListText, getComboObject(comboObjects, 'sprop_apro_ofc_cd') ,"|","\t" );           
    	        ComPriTextCode2ComboItem(mqcSignListValue, mqcSignListText, getComboObject(comboObjects, 'smqc_sign_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(scTypeListValue, scTypeListText, getComboObject(comboObjects, 'ssc_type_cd') ,"|","\t" );
    	        ComPriTextCode2ComboItem(stsTypeListValue, stsTypeListText, getComboObject(comboObjects, 'sprop_sts_cd') ,"|","\t" );                       
    	        //cust type cd
    	        ComPriTextCode2ComboItem(custTpCdValue, custTpCdText, getComboObject(comboObjects, 'sprc_ctrt_cust_tp_cd') ,"|","\t" );
                break;     
            case COMMAND10: //backendjob 조회    	 
            	formObj.prop_pfmc.value="";
            	formObj.prop_atmt.value="";
            	backEndJobCnt = 0;
    	        if (validateForm(sheetObj,document.form,sAction)) {		
    	        	formObj.f_cmd.value = SEARCH14;	
    				var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0004GS.do", FormQueryString(formObj));			
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
        	if (sAction == IBCREATE || sAction == IBSEARCH_ASYNC01 ||sAction == COMMAND10) {
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
	        case "sheet0":
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 150;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                var HeadTitle = "|Seq.|S/C No.|AMD\nNo.|Proposal No.|Customer Name|MQC|UNIT|Request\nOffice|S.Rep|Creation \nDate|EFF Date|EXP Date|Filed Date|Status";
	                var headCount = ComCountHeadTitle(HeadTitle);
	                
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter, false, "ibflag");
	                InitDataProperty(0, cnt++ , dtSeq,    		30,   daCenter, true,  "seq");
	                InitDataProperty(0, cnt++ , dtData,     	77,   daCenter, false, "sc_no",         false, "", dfNone, 	  0, false, false);
	                InitDataProperty(0, cnt++ , dtData,     	30,   daCenter, false, "amdt_seq",      false, "", dfNone, 	  0, false, false);
					InitDataProperty(0, cnt++ , dtData,      	80,   daCenter, false, "prop_no",  		false, "", dfNone, 	  0, false, false);										
					InitDataProperty(0, cnt++ , dtData,        205,   daLeft,   false, "ctrt_pty_nm",   false, "", dfNone, 	  0, false, false);
	                InitDataProperty(0, cnt++ , dtData,      	53,   daRight,  false, "prop_mqc_qty",  false, "", dfInteger, 0, false, false);
	                InitDataProperty(0, cnt++ , dtData, 		35,   daCenter, false, "unit_nm", 		false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++ , dtData,      	55,   daCenter, false, "prop_ofc_cd",   false, "", dfNone, 	  0, false, false);
	                InitDataProperty(0, cnt++ , dtData,      	45,   daCenter, false, "srep_nm",       false, "", dfNone, 	  0, false, false);
					InitDataProperty(0, cnt++ , dtData,  		72,   daCenter, false, "cre_dt",  		false, "", dfDateYmd, 0, false, false);										
					InitDataProperty(0, cnt++ , dtData,     	72,   daCenter, false, "eff_dt",     	false, "", dfDateYmd, 0, false, false);
	                InitDataProperty(0, cnt++ , dtData,      	72,   daCenter, false, "exp_dt",        false, "", dfDateYmd, 0, false, false);
					InitDataProperty(0, cnt++ , dtData,     	72,   daCenter, false, "file_dt",     	false, "", dfDateYmd, 0, false, false);
	                InitDataProperty(0, cnt++ , dtData,      	55,   daCenter, false, "prop_sts_nm",   false, "", dfNone, 	  0, false, false);
	                WaitImageVisible = false;
	           }
	            break;         	
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
    
                var HeadTitle =  "|Seq.|Prop No|Amendment Seq|SVC Scope|APVL OFC|Req. OFC|MQC|MQC|MQC|Sales Rep|Duration|Duration|CHSS|NO GRI|No New SCHG|eff_dt"; //14
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
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "prop_scp_apro_ofc_cd", false, "", dfNone, 0, false, false, 6);                
                InitDataProperty(0, cnt++, dtData,    80, daCenter, false, "prop_scp_ofc_cd", false, "", dfNone, 0, false, false);               
                InitDataProperty(0, cnt++, dtData,    90,  daRight,  false, "prop_scp_mqc_qty", false, "", dfInteger, 0, false, false);             
                InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, false, "cntr_lod_ut_cd", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtData,    50,  daCenter, false, "unit_nm", false, "", dfNone, 0, false, false, 100);
                InitDataProperty(0, cnt++, dtData,    100, daCenter, false, "prop_scp_srep_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData,    85,  daCenter, false, "ctrt_eff_dt", false, "", dfDateYmd, 0, false, false);
                InitDataProperty(0, cnt++, dtData,    85,  daCenter, false, "ctrt_exp_dt", false, "", dfDateYmd, 0, false, true);   
                
                InitDataProperty(0, cnt++, dtCheckBox,    40,  daCenter, false, "chss_expt_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCheckBox,    55,  daCenter, false, "gri_appl_flg", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtCheckBox,    85,  daCenter, false, "new_scg_flg", false, "", dfNone, 0, false, false);
                
                
                
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
//	        case "ssc_no1":
//	        	var i = 0;
//	            with(comboObj) {
//	                //BackColor = "cyan";
//	                DropHeight = 200;
//	                MultiSelect = false;
//	                MaxSelect = 1;
//	                UseAutoComplete = true;
//	            	IMEMode = 0;
//	            	ValidChar(2, 0);
//	            	MaxLength = 3;
//	            }
//	        	break;
        	case "sprop_srep_cd":
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
            
            case "sprop_apro_ofc_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
	            	IMEMode = 0;
	            	ValidChar(2, 0);
	            	MaxLength = 6;
                }
                break;
            case "smqc_sign_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                }
                break;
            case "ssc_type_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;
            case "sprop_sts_cd":
                var i=0;
                with(comboObj) {
                    //UseEdit = true;
                    //BackColor = "cyan";
                    DropHeight = 200;
                    MultiSelect = false;
                    MaxSelect = 1;
                    UseAutoComplete = true;
                }
                break;       
            case "sprc_ctrt_cust_tp_cd":
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
        case IBSEARCH_ASYNC03: // 조회
   			// 2011.05.25 이행지 [CHM-201111048-01] EFF Date 날짜 Validation Retreive 버튼 클릭시 추가
	       	if ((!ComIsDate(formObj.seff_dt1.value) && formObj.seff_dt1.value !="")  
	       		||(!ComIsDate(formObj.seff_dt2.value) && formObj.seff_dt2.value !="") ){
	       		ComShowCodeMessage("PRI00322","S/C EFF Date");
	       		return false;
	       	}
        	
        	var k = 0;
//        	var scNo2 = formObj.ssc_no2.value;
        	if (formObj.sc_no_input.value != ""){
        		k++;
        	}
        	if (formObj.sprop_no.value != ""){
        		k++;
        	}
        	if (formObj.seff_dt1.value != "" && formObj.seff_dt2.value != ""){
        		k++;
        	}
        	if (k < 1){
        		ComShowCodeMessage("PRI01100");
        		return false;
        	}
        	
            break;
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
        
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];
        var sRow = sheetObj2.SelectRow;
        var sPropNo = sheetObj2.CellValue(sRow,"prop_no");
        var sAmdtSeq = sheetObj2.CellValue(sRow, "amdt_seq");
        var sSvcScpCd = sheetObj2.CellValue(sRow, "svc_scp_cd");

        if (sRow != -1 && sPropNo != null && sPropNo != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" && sheetObj2.CellValue(sRow, "ibflag")!="I") {
        	document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd);
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
        //search-- start
        for (var i = 0; i < 6; i++){
        	comboObjects[i].Index = -1;	
        }
        
 		formObj.sc_no_input.value = "";
        formObj.sprop_no.value = "";
        formObj.seff_dt1.value = "";
        formObj.seff_dt2.value = "";
        formObj.sprop_ofc_cd.value = "";
        formObj.sprop_srep_nm.value = "";

        formObj.sprop_mqc_qty.value = "";
        formObj.scust_cnt_cd.value = "";
        formObj.scust_seq.value = "";
        formObj.sctrt_pty_nm.value = "";
        //search-- end
        formObj.sc_no.value="";
        formObj.amdt_seq.value="";
        formObj.prop_no.value="";
        formObj.ctrt_eff_dt.value="";
        formObj.ctrt_exp_dt.value="";

        formObj.rf_flg.value="";
        formObj.gamt_flg.value="";
        formObj.prop_sts.value="";
        formObj.prop_ofc_cd.value="";
        formObj.prop_srep_cd.value = "";
        formObj.prop_srep_nm.value="";
        formObj.prop_apro_ofc_cd.value = "";
        formObj.prop_apro_staff.value="";
        formObj.cre_dt.value="";
        formObj.file_dt.value="";
        formObj.cust_cnt_cd.value="";
        formObj.cust_seq.value="";
        formObj.ctrt_pty_nm.value="";
        formObj.prc_ctrt_cust_tp_cd.value = "";        
        formObj.ctrt_cust_val_sgm.value="";
        formObj.ctrt_cust_sls_ofc_cd.value="";
        formObj.ctrt_cust_srep_cd.value = "";        
        formObj.ctrt_cust_srep_nm.value="";
        formObj.oti_no.value="";

        formObj.real_cust_cnt_cd.value="";
        formObj.real_cust_nm.value="";
        formObj.real_cust_seq.value="";
        formObj.real_cust_tp_cd.value = "";          
        formObj.real_cust_val_sgm.value="";
        formObj.real_cust_sls_ofc_cd.value="";
        formObj.real_cust_srep_cd.value = "";             
        formObj.real_cust_srep_nm.value="";  

        formObj.prop_mqc_qty.value="";
        formObj.cntr_lod_ut_cd.value = "";    
        formObj.prop_mvc.value="";
        formObj.prop_mvc_tp.value="";
        formObj.prop_pfmc.value="";
        
        formObj.sls_ld_no.value = "";

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
     var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0004GS.do", FormQueryString(formObj)+"&svc_scp_cd="+svcScpCd);
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
/////////////////////////////////////////////////////////////////////////   
/////////////////////// ONCHANGE (S)/////////////////////////////////////
/////////////////////////////////////////////////////////////////////////   

 /**
  * IBMulti Combo의 선택된 Item이 변경되었을 때 발생하는 이벤트이다.<br>
  * 변경된 사항은 com_change_sheet() 함수로 Sheet에 반영한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *    sprop_srep_cd_OnChange(comboObj, code, text);
  * </pre>
  * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
  * @param   {string} code 필수 코드
  * @param   {string} text 화면에 표시된 문자 
  * @return 없음
  * @author 공백진
  * @version 2009.04.17
  */    
    function sprop_srep_cd_OnChange(comboObj, code, text) {      
		var formObj = document.form;		
		var arrText = text.split("|");
		if (arrText != null && arrText.length > 1) {
			formObj.sprop_srep_nm.value = comboObj.GetText(code, 1);
		}
		if (code == -1){
			formObj.sprop_srep_nm.value = "";
		}
    }   
    
    /**
     * IBMulti Combo가 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
     * Combo의 text값을 Html Object에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *    sprop_srep_cd_OnBlur(comboObj, code, text);
     * </pre>
     * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */     
	function sprop_srep_cd_OnBlur(comboObj) {
		var formObj = document.form;		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			var text = comboObj.GetText(code, 1);
			if (text != null && text != "" && text != formObj.sprop_srep_nm.value) {
				formObj.sprop_srep_nm.value = comboObj.GetText(code, 1);
			}
			if (code == -1){
				formObj.sprop_srep_nm.value = "";
			}
		}
	}	
    
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
//	function ssc_no1_OnKeyUp(comboObj, KeyCode, Shift) {
//		var scNo = comboObj.Text;
//
//		if (scNo.length > 3) {
//			document.form.ssc_no2.focus();
//		}
//	}
    
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
//	function ssc_no1_OnKeyDown(comboObj, KeyCode, Shift) {
//		var scNo = comboObj.Text;
//		if (scNo.length = 3 && KeyCode == 13) {
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
//		}
//	}     
    
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
	function sprop_sts_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}       
	
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
	function sprop_srep_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
	
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
	function sprop_apro_ofc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
	
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
	function smqc_sign_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  
	
    /**
    * 키보드의 모든 키를 눌렀을 경우 발생한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *    
    * </pre>
    * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
    * @param   {string} KeyCode 필수 아스키 코드값
    * @param   {string} Shift   필수 shift가 눌려졌는지를 표시한다.
    * @return 없음
    * @author 공백진
    * @version 2009.04.17
    */
	function ssc_type_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		if (KeyCode == 13) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
		}
	}  	



    /**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * sheet조회 후 sheet의 값을 Html Object의 값으로 setting 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 	sheet0_OnSearchEnd(sheetObj, errMsg)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 공백진
     * @version 2009.05.20
     */ 
    function sheet0_OnSearchEnd(sheetObj, errMsg){
        var formObj = document.form;
        formObj.prop_no.value = sheetObj.CellValue(sheetObj.SelectRow,"prop_no");
        formObj.amdt_seq.value = sheetObj.CellValue(sheetObj.SelectRow,"amdt_seq");
        
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
     * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Proposal No 와 Amdt Seq No로 조회한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
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
     function sheet0_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {   
         
     	if(OldRow!=NewRow){
            var formObj = document.form;
            formObj.prop_no.value = sheetObj.CellValue(NewRow,"prop_no");
            formObj.amdt_seq.value = sheetObj.CellValue(NewRow,"amdt_seq");
     		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
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
     * OnSort 이벤트 발생시 호출되는 function <br>
     * 해당 컬럼 Sort후 데이터를 다시 조회한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int}     Col 소트가 처리된 Column Index
     * @return 없음
     * @author 공백진
     * @version 2009.04.17
     */       
     function sheet0_OnSort(sheet, Col) {  
    	 var row = sheet.SelectRow;
    	 sheet0_OnSelectCell(sheet, -1, -1, row, 1);    	 
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
        var mqcQty = sheetObjects[1].CellValue(1, "prop_mqc_qty");

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
    * Request Office를 조회하여 IBMulti Combo에 Setting한다. <br>
    * <br><b>Example :</b>
    * <pre>
    *		setRequestOffice();
    * </pre>
    * @param  없음
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */ 
    function setRequestOffice(){
        var formObj = document.form;
        var cd = formObj.sprop_ofc_cd.value;
        var sheetObj = sheetObjects[1];
        formObj.f_cmd.value = SEARCH15;
        var sParam = FormQueryString(formObj)+"&etc1="+cd;
    
        sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
        ComPriXml2ComboItem(sXml, formObj.sprop_srep_cd, "cd", "cd|nm");   
        getComboObject(comboObjects, 'sprop_srep_cd').InsertItem(0, "", "");
        formObj.sprop_srep_nm.value = "";
    }
    
    /**
    * Customer에 관련된 정보를 조회한다.<br>
    * <br><b>Example :</b>
    * <pre>
    *		sCustNameFind(eleName);
    * </pre>
    * @param  {string} eleName 필수 Html Object Name
    * @return 없음
    * @author 공백진
    * @version 2009.05.07
    */ 
  function sCustNameFind(eleName){
      var formObj = document.form;
      var sheetObj = sheetObjects[1];
      var cust_cnt_cd = formObj.scust_cnt_cd.value;        
      var cust_seq = formObj.scust_seq.value;      
      
      if(cust_cnt_cd != "" && cust_seq !=""){
          var sParam = "f_cmd="+SEARCH02+"&cust_cnt_cd="+cust_cnt_cd+"&cust_seq="+cust_seq;
      
          var sXml = sheetObj.GetSearchXml("ESM_PRI_0004GS.do", sParam);
          var arrText = ComPriXml2Array(sXml, "prc_ctrt_cust_tp_cd|ctrt_pty_nm|ctrt_pty_addr|ctrt_cust_val_sgm_cd|ctrt_cust_val_sgm|ctrt_cust_srep_cd|ctrt_cust_sls_ofc_cd|ctrt_cust_srep_nm|oti_no");
          if(arrText==undefined){
        	  sClearCustName();
              formObj.scust_cnt_cd.focus();
          }else{
              formObj.sctrt_pty_nm.value = arrText[0][1];              
          }
      }

  }    
  
  /**
   * Customer에 관련된 Html Object의 값을 clear 한다.<br>
   * <br><b>Example :</b>
   * <pre>
   *		sClearCustName();
   * </pre>
   * @param  없음
   * @return 없음
   * @author 공백진
   * @version 2009.05.07
   */     
  function sClearCustName(){
      var formObj = document.form;
      formObj.scust_cnt_cd.value = "";
      formObj.scust_seq.value = "";
      formObj.sctrt_pty_nm.value = "";
      
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
 			sheet1_OnSearchEnd(sheetObjects[1], "");
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
 	var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0004GS.do", FormQueryString(form));
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
 	var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_0004GS.do", FormQueryString(form));
    
 	var arrData = ComPriXml2Array(sXml, "op_cntr_qty|pro_rt_mqc_perf");
    if (arrData != null && arrData.length > 0) {
    	form.prop_pfmc.value = ComAddComma(arrData[0][0]);
    	form.prop_atmt.value = ComAddComma(arrData[0][1]);
    }        
    
 }     
    
    /* 개발자 작업  끝 */

