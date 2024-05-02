/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7001.js
*@FileTitle : IHC Tariff Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation 
=========================================================
* History   
* 1.1 Add Row 버튼 추가
*     - PRI_TRF_IHC_RT 테이블에 컬럼 추가(PRC_TRF_CRE_TP_CD) 
*     	==> I: Interface(Cost 테이블에서 인터페이스) , G:General(Add Row 버튼을 통해 신규 생성)        
* 2012.10.30 서미진 [CHM-201220395] Add-on management T/F Project   
* 2013.02.04 전윤주 [CHM-201322884] confirm staff-team, Creation staff-team 보이도록 변경                  
* 2013.04.17 전윤주 [CHM-201324375] Inland Tariff 기능 병합 (버튼 이름 동적으로 변경 confirm -> publish, Amend Type 추가)       
* 2013.07.08 서미진 [CHM-201325626] HAMRU 산하 TAE, TAW, ASE, ASW 인 경우 Local Currency 가 기준이 되도록 변경                                    
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
     * @class ESM_PRI_7001 : ESM_PRI_7001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7001() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    var tabObjects = new Array();
    var tabCnt = 0;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
	var rslt = false;

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
     * @version 2012.04.17
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
            
            case "btn_country": 
            	var old_country = "";
            	var new_country = "";
            	
            	old_country = formObj.cost_cnt_cd.value ;
            	var parameter = FormQueryString(document.form);
            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7027.do?"+ parameter,565, 400, 'getCountry', "1,0,1,1,1,1,1", true);
            	new_country = formObj.cost_cnt_cd.value ;             
                break;  
                
            case "btn_spcl_cgo_trf": 
				var sParam = "svcScpCd="    +	comboObjects[1].Code
		           	 	       + "&ihcTrfNo=" 	+	formObj.ihc_trf_no.value 
		           	 	       + "&org_dest_tp_cd=" + comboObjects[0].Code; 
            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7024.do?"+ sParam,	650, 500, '', "1,0,1,1,1,1,1", true);
                break;  

            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                break;
                
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);                
                break;              
                
            case "btn_save":    
                doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                break;
                
            case "btn_amend":   
            	doActionIBSheet(sheetObjects[0],document.form,MULTI01);
                break;    
                
            case "btn_cancel":
                doActionIBSheet(sheetObjects[0],document.form,MULTI02);
                break;                
                
            case "btn_confirm":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI03);
                break;      
                
            case "btn_calendar": 
            	if(!document.getElementById(srcName).disabled){
	                var cal = new ComCalendar();                
	                cal.select(document.form.eff_dt, 'yyyy-MM-dd');
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
    * @version 2012.04.17
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
    * @version 2012.04.17
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
    * @version 2012.04.17
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
    * @version 2012.04.17
    */
    function loadPage() {
    	 var formObj = document.form;
         for (var i = 0; i < sheetObjects.length; i++) { 
            // khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);   
            initSheet(sheetObjects[i], i + 1);          
            // khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화    ,"|","\t" );
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }       
        // tab 
    	for ( var k = 0; k < tabObjects.length; k++) {
    		initTab(tabObjects[k], k + 1);
    	} 
    	// loading 시 In bound 선택하도록 셋팅
    	comboObjects[0].Code = 'D' ;
        initControl();    
        buttonControl("LOAD");
    	if(document.form.menu_rhq_cd.value != ""){
    		comboObjects[2].Code = document.form.menu_rhq_cd.value;
    	}
        if(formObj.in_svc_scp_cd.value != ""){
        	comboObjects[2].Code = formObj.in_rhq_cd.value ;       	
        	comboObjects[0].Code = formObj.in_org_dest_tp_cd.value ;
        	formObj.cost_cnt_cd.value = formObj.in_cnt_cd.value ;  	
        	formObj.cost_cnt_cd.fireEvent("onchange");	  
        	comboObjects[1].Code = formObj.in_svc_scp_cd.value ;
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        document.form.cost_cnt_cd.focus();	
        
        ComPriTextCode2ComboItem(ihcTrfAmdtTpCdValue, ihcTrfAmdtTpCdText, getComboObject(comboObjects, 'ihc_trf_amdt_tp_cd'));

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
    * @version 2012.04.17
    */    
     function initControl() {
            //Axon 이벤트 처리1. 이벤트catch(개발자변경)            
        axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);               
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
//        axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
        axon_event.addListenerForm('click', 'obj_click', document.form);   
        axon_event.addListenerForm('change', 'obj_change', document.form);
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
     * @version 2012.04.17
     */      
     function obj_keypress() {
         var srcValue = event.srcElement.getAttribute("value");
         var srcName = event.srcElement.getAttribute("name");
         
         switch (event.srcElement.dataformat) {
             case "engup":
                     ComKeyOnlyAlphabet('upper');  
                 break;
                 
             case "engupnum":
            	 ComKeyOnlyAlphabet('uppernum');
            	 break;      
            	 
             case "int":
                 ComKeyOnlyNumber(event.srcElement);
                 break;
                 
             case "float":
                 ComKeyOnlyNumber(event.srcElement, ".");
                 break;
                 
             case "ymd":
              	  ComKeyOnlyNumber(event.srcElement);
                 break;
                 
             case "apply":
            	 ComKeyOnlyNumber(event.srcElement, "-.");
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
      * @version 2012.04.17
      */        
    function obj_deactivate() {
        var formObj = document.form;
        var sheetObj = sheetObjects[0]; 
        var eleName = event.srcElement.name;

        switch(eleName){
		      case "eff_dt":
			      ComChkObjValid(event.srcElement);   
	              if(document.form.eff_dt.value != sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eff_dt") ){
	            		sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "eff_dt") = document.form.eff_dt.value;
	              }
			      break;
			      
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
    * @author 서미진
    * @version 2012.05.14
    */   
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        try{
            switch (sAction) {            
            case IBSEARCH: 		//retrieve form   	               
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }            
	 			formObj.f_cmd.value = SEARCH; 			
	 			formObj.svc_scp_cd.value = comboObjects[1].Code; 		
	 			document.getElementById("btn_spcl_cgo_trf").style.color = "";
	 			sheetObjects[0].RemoveAll();     
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7001GS.do", FormQueryString(formObj));	 	
	 			sheetObjects[0].LoadSearchXml(sXml);	
	 			// checking tariff no.						
 		 		if ( sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "ihc_trf_no")  != ""){		
 		 			formObj.ihc_trf_no.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"ihc_trf_no");
 		 			formObj.amdt_seq.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"amdt_seq");
 		 			comboObjects[2].Code2 = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"ihc_trf_amdt_tp_cd");
 		 			formObj.cre_dt.value = ComGetMaskedValue( sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"cre_dt"), "ymd");            
 		 			formObj.eff_dt.value = ComGetMaskedValue( sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"eff_dt"), "ymd");              						
 		 			formObj.cfm_dt.value = ComGetMaskedValue( sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"cfm_dt"), "ymd");             
 		 			formObj.exp_dt.value = ComGetMaskedValue( sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"exp_dt"), "ymd");    
 		 			formObj.cfm_usr.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"cfm_usr");
 		 			formObj.cre_usr.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"cre_usr");
 		 			formObj.fic_prop_sts_cd.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"fic_prop_sts_cd");
 		 			formObj.fic_prop_sts_nm.value = sheetObjects[0].CellValue( sheetObjects[0].SelectRow,"fic_prop_sts_nm");
 		 			
 		 			var trf = formObj.ihc_trf_no.value;
 		 			formObj.ihc_trf_no_view.value = trf.substr(0,3)+"-"+trf.substr(3,1)+"-"+trf.substr(4,2)+"-"+trf.substr(6,4);
 		 			
 		 			if(formObj.amdt_seq.value == "0" && formObj.fic_prop_sts_cd.value == "I" ){
 		 				formObj.eff_dt.readOnly =  false;
 		 				formObj.eff_dt.setAttribute("className","input1");
 		 				buttonControl("INIT");	
 		 			}else{
 		 				formObj.eff_dt.readOnly =  true;
 		 				formObj.eff_dt.setAttribute("className","input2");
 		 				buttonControl(formObj.fic_prop_sts_cd.value);	 
 		 			}
 		 			
 		 			//confirm 상태에서는 변경 불가
 		 			if(formObj.fic_prop_sts_cd.value == "C" ){
 		 				comboObjects[2].Enable = false;
 		 			}else{
 		 				comboObjects[2].Enable = true;
 		 			}
 		 			
 		 			//special cargo 데이터가 있을경우 버튼을 파란색으로
 		 			if(sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "spcl_count")  != "0" ){
 		 				document.getElementById("btn_spcl_cgo_trf").style.color = "blue";
 		 			}

 		 	        var sRow = sheetObjects[0].SelectRow;
 		 	        var sSvcScpCd = sheetObjects[0].CellValue(sRow, "svc_scp_cd");
 		 	        var sIhcTrfNo = sheetObjects[0].CellValue( sRow ,"ihc_ltrf_no");
 		 	        var sAmdtSeq = sheetObjects[0].CellValue( sRow ,"amdt_seq");
 		 	        var sFicPropStsCd = sheetObjects[0].CellValue( sRow ,"fic_prop_sts_cd");
 		 	        var sEffDt = sheetObjects[0].CellValue(sRow, "eff_dt");    
 		 	        var sCostCntCd = formObj.cost_cnt_cd.value ;
 		 	        
//                    if (tabObjects[0].SelectedIndex == 0) {
//                        tab1_OnChange(tabObjects[0], 0);
//                    } else {
//                        tabObjects[0].SelectedIndex = 0;
//                    }
 		 	       clearAllTabPages();                    
 		        	for(var i = 0 ; i <= tabObjects.length ; i++){		
 		        		loadTabPage(i);
 		        	}
 		        	tabObjects[0].SelectedIndex = 0;

 		 		}else {
 		 			clearAllForms();
 	                clearAllTabPages();
 		 			ComShowCodeMessage('PRI00018'); 
 		 			buttonControl("LOAD");
 		 			comboObjects[1].Index = -1;
 		 			document.form.svc_scp_combo.focus();	 			
 		 		}
                break;
                
            case IBCREATE: 	// New
            	ComOpenWait(true); //->waiting->start
            	
            	//신규입력시 Tab위치를 처음으로 
        		if (tabObjects[0].SelectedIndex == 0) {
        			tab1_OnChange(tabObjects[0] , 0);
        		} else {
        			tabObjects[0].SelectedIndex = 0;
        		}
            	
                clearAllForms();     
                document.form.cost_cnt_cd.value = "";
                clearAllTabPages();
                sheetObjects[0].RemoveAll();      
                ComOpenWait(false); //->waiting->End
                buttonControl("LOAD");
     			comboObjects[0].Index = 0;
     			comboObjects[1].RemoveAll();    
                document.form.cost_cnt_cd.focus();
                break;
                
            case IBSAVE: // Save                  
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                ComOpenWait(true); //->waiting->start    
	            if (!ComShowCodeConfirm("PRI00001")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }
                formObj.f_cmd.value = MULTI;
		 		var sParamSheet = sheetObjects[0].GetSaveString(true);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + sParamSheet;
		 		
	 			var sXml = sheetObjects[0].DoSave("ESM_PRI_7001GS.do", sParam, -1, false );  		 		
        		ComOpenWait(false); //->waiting->End
		     	if(sXml){
		     		ComPriSaveCompleted();
		     	}   
                break;             
                
            case MULTI01: // Amend
                formObj.f_cmd.value = MULTI05;
		 		var sParamSheet = sheetObjects[0].GetSaveString(true);
                var sParam = "&f_cmd=" + formObj.f_cmd.value + "&ihc_trf_no_view=" + formObj.ihc_trf_no_view.value ; 
                sParam = sParam + "&" + sParamSheet;
                var sXml = sheetObj.GetSearchXml("ESM_PRI_7001GS.do", sParam);    
//                sheetObj.LoadSearchXml(sXml);	
//        		if(sheetObj.CellValue( sheetObj.SelectRow , "cost_trf_no")  == "" ){    ComGetEtcData(sXml,"cost_trf_no")
                if( ComGetEtcData(sXml,"cost_trf_no")  == "" ){   
        			ComShowCodeMessage('PRI07006'); 
                	return false;
                }             

	            var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_7002.do?"+sParam, "", 750, 300, true);   
	            if (rtnVal == true) {            	
					doActionIBSheet(sheetObj,document.form,IBSEARCH);
	            }	
                break;                
                
            case MULTI02: // Cancel
	            if (!ComShowCodeConfirm("PRI00015")) {
	            	return false;
	            }
            	ComOpenWait(true); //->waiting->start                       
                formObj.f_cmd.value = MULTI02;
		 		var sParamSheet = sheetObjects[0].GetSaveString(true);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + sParamSheet;
                var sXml = sheetObj.GetSaveXml("ESM_PRI_7001GS.do", sParam);                
		 		var cancel_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		 		ComOpenWait(false); //->waiting->End
		     	if(cancel_result != "F" ){
		     		ComShowCodeMessage('PRI01073');
	     			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		     	}                     		
                break;   
                
                
            case MULTI03: // Confirm
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                
                if(formObj.amdt_seq.value == "0"){
                    formObj.f_cmd.value = MULTI04;
    		 		var sParamSheet = sheetObjects[0].GetSaveString(true);
                    var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                    sParam = sParam + "&" + sParamSheet;
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_7001GS.do", sParam);      
                    
            		if(ComGetMaskedValue( ComGetEtcData(sXml,"eff_dt"), "ymd") >= formObj.eff_dt.value ){
	            		ComShowCodeMessage('PRI05006', ComGetMaskedValue( ComGetEtcData(sXml,"eff_dt"), "ymd"));
	            		formObj.eff_dt.focus();
                    	return false;
                    }
                }
                
                //Amend Type이 A나 I 일 경우에는 Effective date 30일 이전에 Publish가 되어야 한다.
                var effDt = formObj.eff_dt.value;
			 	var pubDt = ComGetNowInfo();	
	   			var amdTpCd = comboObjects[2].Code;
	   			var ret = ComGetDaysBetween(effDt, pubDt);
	   			
	   			if(amdTpCd == "A" || amdTpCd == "I") {
	   				if(ret > -30) {
	   					ComShowCodeMessage("PRI06006");
	   					return false;   					
	   				}
	   			}
	   			
	   			//TAW, TAE, ASW, ASE Scope일 경우에는 버튼이 Publish 로 변경되므로 확인 메시지를 변경해준다.
	   			
	   			var SvcScpCd = formObj.svc_scp_cd.value;
                if (SvcScpCd == "TAW" || SvcScpCd == "TAE" || SvcScpCd == "ASW" || SvcScpCd == "ASE"){
                	if(!ComShowCodeConfirm("PRI06005", "IHC tariff")) {
	 			 		return false;
	 			 	}
                } else {
                	if (!ComPriConfirmConfirm()) {
                        return false;
                    }                	
                }        	
                
            	ComOpenWait(true); //->waiting->start                        
                formObj.f_cmd.value = MULTI03;
                sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "fic_prop_sts_cd") = "C";	
		 		var sParamSheet = sheetObjects[0].GetSaveString(true);
                var sParam = "&f_cmd=" + formObj.f_cmd.value; 
                sParam = sParam + "&" + sParamSheet;           
                var sXml = sheetObj.GetSaveXml("ESM_PRI_7001GS.do", sParam);  
                ComOpenWait(false); //->waiting->End
                
		 		var confirm_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	if(confirm_result != "F" ){
		     		//TAW, TAE, ASW, ASE Scope일 경우에는 버튼이 Publish 로 변경되므로 확인 메시지를 변경해준다.
		     		if (SvcScpCd == "TAW" || SvcScpCd == "TAE" || SvcScpCd == "ASW" || SvcScpCd == "ASE"){
		     			ComPriProcessSuccess("Publish")
	                } else {
	                	ComPriConfirmCompleted();
	                }
		     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		     		buttonControl(formObj.fic_prop_sts_cd.value);	 			
		     	}            
        		
                break;  
				
            case MULTI08: // cost_cnt_cd focus out save         
            	ComOpenWait(true); //->waiting->start    
                formObj.f_cmd.value = MULTI;
		 		var sParam = FormQueryString(formObj); 
		 		sParam += "&" + sheetObj.GetSaveString(false, true);

                var sXml = sheetObj.GetSaveXml("ESM_PRI_7001GS.do", sParam);                
		 		var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        		ComOpenWait(false); //->waiting->End
		     	if(save_result != "F" ){
		     		ComPriSaveCompleted();
		     		rslt = true;
		     	}       
                break;				
                
            }        	
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
		}finally {
			 ComOpenWait(false);
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
    * @version 2012.04.17
    */
    function initSheet(sheetObj, sheetNo) {
    
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch (sheetID) {

        case "sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 100;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;              

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                InitRowInfo( 1, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|Seq|SVC_SCP_CD|IHC_TRF_NO|AMDT_SEQ|IHC_TRF_AMDT_TP_CD|EFF_DT|CRE_DT|CFM_DT|EXP_DT|COST_TRF_NO|SPCL_COUNT|ORG_DEST_TP_CD|CFM_USR|" +
									 "CRE_USR|FIC_PROP_STS_CD|FIC_PROP_STS_NM|LOCL_CURR_CD|COST_CNT_CD|RHQ_CD";

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtStatus,		30, 		daCenter, 	true, 	"ibflag");   
                InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	true,  	"Seq");    
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"ihc_trf_amdt_tp_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"cre_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"cfm_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"exp_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cost_trf_no", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"spcl_count", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false);                 
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cfm_usr", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cre_usr", false, "", dfNone, 0, false, false);   
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"fic_prop_sts_cd", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"fic_prop_sts_nm", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"locl_curr_cd", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cost_cnt_cd", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"rhq_cd", false, "", dfNone, 0, false, false); 
                WaitImageVisible = false;  
                Ellipsis = true;
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
    * @version 2012.04.17
    */         
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
	 		case "svc_scp_combo":                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;     
	 				MaxLength = 3;
	 				UseAutoComplete = true;           
	 				ValidChar(2,0);
	 				SetColWidth("50|350");
	 			}                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 			break;   
	            
	 		case "org_dest_tp_cd" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	 	            InsertItem(i++, "In bound", "D");
	 				InsertItem(i++, "Out bound", "O");
	            }
	            break;  
	            
	 		case "rhq_cd" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	                InsertItem(i++, "HAMRU", "HAMRU");
	                InsertItem(i++, "NYCRA", "NYCRA");
	                InsertItem(i++, "SHARC", "SHARC");
	                InsertItem(i++, "SINRS", "SINRS");
	            }
	            break;  
	         
	 		case "ihc_trf_amdt_tp_cd" :
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;     
	 				MaxLength = 1;
	 				UseAutoComplete = true;           
	 				ValidChar(2,0);
	 				SetColWidth("30|120");
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
    * @version 2012.04.17
    */
    function validateForm(sheetObj, formObj, sAction) {
    	var formObj = document.form;
        
        switch (sAction) {
        case IBSEARCH: // 조회    
            if (comboObjects[1].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"input","Service Scope"); 
            	formObj.svc_scp_combo.focus();
                return false;
            }
        	
            if (formObj.cost_cnt_cd.value == "") {
            	ComShowCodeMessage('PRI00308',"input","Country"); 
                clearAllForms();                
                sheetObjects[0].RemoveAll();      
            	formObj.cost_cnt_cd.focus();
                return false;
            }
            break;

        case IBSAVE: // Save                
            if(!sheetObjects[0].IsDataModified){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }
            
            if (formObj.eff_dt.value == "" && formObj.fic_prop_sts_cd.value == "I" && formObj.amdt_seq.value == "0") {
            	ComShowCodeMessage('PRI00308',"input","Effective Date"); 
            	formObj.eff_dt.focus();
                return false;
            }
            break;
            
        case MULTI03: // Confirm
            if(sheetObjects[0].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }
            
            for (var i = 0; i <= tabObjects.length; i++) {
                var re = document.getElementById("t" + (i + 1) + "frame").contentWindow.doActionIBSheet(sheetObjects[0],document.form,MULTI03);
                if(!re && re != undefined){
                	return false;
                }
            }  
            break;
        }
        return true;
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
    	setConfirmText();   	 
    }
    
    /**
     * 메인의 Service Scope 상태에 따라 Confrim 버튼의 text를 변경한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *    setConfirmText();
     * </pre>
     * @param  없음
     * @return 없음
     * @author 공백진
     * @version 2013.04.17
     */ 
    
  	function setConfirmText(){
  		var formObj = document.form;
  		var confirmTxt = formObj.svc_scp_cd.value;

  		if (confirmTxt == "TAW" || confirmTxt == "TAE" || confirmTxt == "ASW" || confirmTxt == "ASE"){
  			confirmTxt = "Publish "; 
  		}else{
  			confirmTxt = "Confirm";
  		}
  		document.getElementById("btn_confirm_txt").innerText = confirmTxt;
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
    * @version 2012.04.17
    */      
    function clearAllForms(){   
        var formObj = document.form;        
        formObj.ihc_trf_no.value="";
        formObj.ihc_trf_no_view.value="";
        formObj.amdt_seq.value="";
        formObj.cre_dt.value="";
        formObj.eff_dt.value="";
		formObj.eff_dt.readOnly =  true;
		formObj.eff_dt.setAttribute("className","input2");
        formObj.cfm_dt.value="";
        formObj.cfm_usr.value="";
        formObj.cre_usr.value="";
        formObj.fic_prop_sts_cd.value="";   
        formObj.fic_prop_sts_nm.value="";   
        formObj.svc_scp_cd.value = "";
        formObj.org_dest_tp_cd.value = "";
        comboObjects[2].Code =""
        comboObjects[2].Enable = false;
        
		  	
        document.getElementById("btn_spcl_cgo_trf").style.color = "";	       	
        sheetObjects[0].RemoveAll();    
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
//             tabObjects[0].ImageUrl(i) = ICON_URL_NOT_EXIST;
             if (document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms) {
                 document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms();
             }
         }
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
    * @version 2012.04.17
    */ 
 	function buttonControl(mode) {
 		var formObj    = document.form;
		var amdt_seq = formObj.amdt_seq.value;
		
			ComBtnEnable("btn_retrieve");
 			ComBtnEnable("btn_new");
 			ComBtnEnable("btn_save");
 			btnImgEnable(formObj.btn_calendar, false);
 			
 		switch (mode) {
 		case "LOAD":	// LOAD screen			 			
 			ComBtnDisable("btn_amend"); 
 			ComBtnDisable("btn_cancel"); 
 			ComBtnDisable("btn_confirm"); 
 			ComBtnDisable("btn_spcl_cgo_trf"); 
 			break;
 			
 		case "INIT":	// Initial  & amdt seq = 0
 			ComBtnDisable("btn_amend"); 
 			ComBtnEnable("btn_cancel"); 
 			ComBtnEnable("btn_confirm"); 
 			ComBtnEnable("btn_spcl_cgo_trf"); 
 			btnImgEnable(formObj.btn_calendar, true);
 			break;
 			
 		case "I":	// Initial  & amdt seq != 0    
 			ComBtnDisable("btn_amend"); 
 			ComBtnEnable("btn_cancel"); 
 			ComBtnEnable("btn_confirm"); 
 			ComBtnEnable("btn_spcl_cgo_trf"); 
 			break;
 			
 		case "C":	// Initial  & amdt seq = 0
 			ComBtnDisable("btn_save");
 			ComBtnEnable("btn_amend"); 
 			ComBtnDisable("btn_cancel"); 
 			ComBtnDisable("btn_confirm"); 
 			ComBtnEnable("btn_spcl_cgo_trf"); 
 			break;
 		}
 	}

   function getCountry(aryPopupData, Row, Col, SheetIdx) {
           var sheetObj = sheetObjects[SheetIdx];
           var formObj  = document.form;
           if ( aryPopupData.length > 0 ) {
                  var cntCdVal = "";
                  for(var i =0; i < aryPopupData.length; i++) {
                          cntCdVal += aryPopupData[i][3];
                          if( i < aryPopupData.length-1) {
                                 cntCdVal += ",";
                          }
                  }
                  formObj.cost_cnt_cd.value = cntCdVal;
                  formObj.cost_cnt_cd.fireEvent("onchange");	  
           }
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
	 * 탭 화면
	 *  
	 * @return 없음
	 * @author 서미진
	 * @version 2012.10.04
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt = 0;
				InsertTab(cnt++, "Dry", 0);
				InsertTab(cnt++, "Reefer", 1);
				ShowIcon = false;
			}
			break;
		}
	}
	
	function tab1_OnChange(tabObj, tabIndex) {
		if (beforetab != tabIndex) {
			var objs = document.all.item("tabLayer");
			objs[tabIndex].style.display = "inline";
			objs[beforetab].style.display = "none";
		}
		beforetab = tabIndex;
		loadTabPage(tabIndex);
	}

	function loadTabPage(tabIndex) {
		var formObj = document.form;
		if (tabIndex == null || tabIndex == "" || tabIndex == undefined) {
			tabIndex = tabObjects[0].SelectedIndex;
		}

		var objTabWindow = document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;	
		if (objTabWindow.location.href == "" || objTabWindow.location.href == "about:blank") {
			var sUrl = "";	
			switch (tabIndex) {
			case 0:
				sUrl = "ESM_PRI_7001_01.do";
				break;
			case 1:
				sUrl = "ESM_PRI_7001_02.do";
				break;
			}
			objTabWindow.location.href = sUrl;		
			return true;
		}

        var sheetObj1 = sheetObjects[0];
        var sRow = sheetObj1.SelectRow;
        var sSvcScpCd = sheetObj1.CellValue(sRow, "svc_scp_cd");
        var sIhcTrfNo = sheetObj1.CellValue( sRow ,"ihc_trf_no");
        var sAmdtSeq = sheetObj1.CellValue( sRow ,"amdt_seq");
        var sFicPropStsCd = sheetObj1.CellValue( sRow ,"fic_prop_sts_cd");   
        var sOrgDestTpCd = sheetObj1.CellValue( sRow ,"org_dest_tp_cd");
        var sLoclCurrCd = sheetObj1.CellValue( sRow ,"locl_curr_cd");
        var sEffDt = sheetObj1.CellValue(sRow, "eff_dt");    
        var sCostCntCd = formObj.cost_cnt_cd.value ;
        var sRhqCd = formObj.menu_rhq_cd.value ;
 
        if (sRow != -1 && sSvcScpCd != null && sSvcScpCd != "" && sAmdtSeq != null && sAmdtSeq != "" && sSvcScpCd != null && sSvcScpCd != "" 
        	&& sFicPropStsCd != null && sFicPropStsCd != "" && sEffDt != null && sEffDt != "" && sCostCntCd != null && sCostCntCd != ""
        	&& sOrgDestTpCd != null && sOrgDestTpCd != "" && sLoclCurrCd != null && sLoclCurrCd != "" && sRhqCd != null && sRhqCd != "") {	
        		document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sIhcTrfNo, sAmdtSeq, sSvcScpCd, sFicPropStsCd, sEffDt, sCostCntCd, sOrgDestTpCd, sLoclCurrCd, sRhqCd);
        	}       
	}
	
    /**
     * OnChange event를 처리한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param 없음
     * @return 없음
     * @author 문동규
     * @version 2009.11.20
     */
    function obj_change () {
    	var srcValue = event.srcElement.getAttribute("value");
        switch (event.srcElement.name) {
            case "cost_cnt_cd":      
            	comboObjects[1].RemoveAll();   
            	if(srcValue !=""){
	        		var formObj = document.form;
	        		formObj.f_cmd.value = SEARCH25;
	        		formObj.cd.value = comboObjects[2].Code;  // RHQ_CD
	        		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
	        		formObj.etc2.value = formObj.cost_cnt_cd.value;	//	CNT_CD
	        		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
	        		ComPriXml2ComboItem(sXml, formObj.svc_scp_combo, "cd", "cd|nm");
	        	    formObj.svc_scp_combo.focus(); 	  
            	}
        	    break; 
        }
    }   
	
	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 서미진
	 * @version 2010.11.01
	 */
	function org_dest_tp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		if(formObj.cost_cnt_cd.value != ""){
    		formObj.f_cmd.value = SEARCH25;
    		formObj.cd.value = comboObjects[2].Code;     // RHQ_CD
    		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
    		formObj.etc2.value = formObj.cost_cnt_cd.value;	//	CNT_CD
    		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		ComPriXml2ComboItem(sXml, formObj.svc_scp_combo, "cd", "cd|nm");     
    	    formObj.svc_scp_combo.focus(); 	
		}
	}
	
	/**
   	 * OnChange 이벤트 발생시 호출되는 function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 *
   	 * </pre>
   	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
   	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
   	 * @param {int} text 필수 화면에 표시된 글자
   	 * @return 없음
   	 * @author 최성민
   	 * @version 2010.10.13
   	 */
   	function ihc_trf_amdt_tp_cd_OnChange(comboObj, code, text) {	   		
   		if (text != null) { 
   			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ihc_trf_amdt_tp_cd") = comboObjects[2].Code;
   		}
   	}