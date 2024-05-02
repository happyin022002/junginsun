/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7011.js
*@FileTitle : Add-on Tariff Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation 
=========================================================
* History                                      
* 2012.10.30 서미진 [CHM-201220395] Add-on management T/F Project            
* 2013.07.31 전윤주 [CHM-201326002] DG service flag가 'Y' 인 경우 버튼 파란색으로 표시                                                    
* 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
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
     * @class ESM_PRI_7011 : ESM_PRI_7011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7011() {
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
            
            case "btn_dg_cgo_scg": 
				var sParam = "svcScpCd="    	+	formObj.svc_scp_cd.value
		           	 	       + "&fdrTrfNo=" 		+	formObj.fdr_trf_no.value
		           	 	       + "&org_dest_tp_cd=" + comboObjects[0].Code
							   + "&rhq_cd="        + formObj.menu_rhq_cd.value;
            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7028.do?"+ sParam,	900, 500, '', "1,0,1,1,1,1,1", true);
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
                
            case "btn_amend_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI04);
                break;
                
            case "btn_cancel_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI05);
                break;
                
            case "btn_delete_down":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI06);
                break;              
                
            case "btn_apply":    
                doActionIBSheet(sheetObjects[0],document.form,MULTI07);
                break;
                
            case "btn_gl_tuning":    
                doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
                break;
                
            case "btn_down_excel":    
            	doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
                break;
                
            case "btn_calendar": 
            	if(!document.getElementById(srcName).disabled){
	                var cal = new ComCalendar();                
	                cal.select(document.form.eff_dt, 'yyyy-MM-dd');
            	}
                break; 
                
            case "btn_load_excel": 
				var sParam = "svc_scp_cd="    	+  formObj.svc_scp_cd.value
		           	 	       + "&fdr_trf_no=" 	+	formObj.fdr_trf_no.value
		           	 	       + "&amdt_seq=" 	+	formObj.amdt_seq.value
		           	 	       + "&rhq_cd=" 		+	comboObjects[5].Code
		           	 	       + "&org_dest_tp_cd=" 	+  comboObjects[0].Code; 
            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7013.do?"+ sParam,	950, 600, '', "1,0,1,1,1,1,1", true);
	            if (rtnVal == true) {            	
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	            }	
                break;  
                
            case "btn_add_down":    
            	doActionIBSheet(sheetObjects[0],document.form,MULTI09);
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
    	if(document.form.menu_rhq_cd.value != ""){
    		comboObjects[5].Code = document.form.menu_rhq_cd.value;
    	}
    	// loading 시 In bound 선택하도록 셋팅
    	comboObjects[0].Code = 'D' ;
        initControl();    
        buttonControl("LOAD");
        if(formObj.in_svc_scp_cd.value != ""){
        	comboObjects[0].Code = formObj.in_org_dest_tp_cd.value ;
        	comboObjects[1].Code = formObj.in_svc_scp_cd.value ;
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
        // HAMRU 경우만 45' Cost 수정 가능
		if(formObj.menu_rhq_cd.value == "HAMRU") {
			formObj.fix_percent_45.enable = true;
			formObj.flat_percent_45_app.readOnly = false;
			formObj.flat_percent_45_app.setAttribute("className","input");
		} else {
			formObj.fix_percent_45.enable = false;
			formObj.flat_percent_45_app.readOnly = true;
			formObj.flat_percent_45_app.setAttribute("className","input2");
		}
        formObj.svc_scp_combo.focus();
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
	//    axon_event.addListenerFormat('mousemove', 'obj_onmousemove', document.form);
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
	              if(document.form.eff_dt.value != sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt") ){
	            		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "eff_dt") = document.form.eff_dt.value;
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
                clearAllForms();
	 			formObj.f_cmd.value = SEARCH; 			
	 			formObj.svc_scp_cd.value = comboObjects[1].Code;
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7011GS.do", FormQueryString(formObj));	 	
	 			sheetObjects[1].LoadSearchXml(sXml);	

	 			// checking tariff no.
 		 		if (ComGetEtcData(sXml,"fdr_trf_no")  != undefined){
 		 			formObj.fdr_trf_no.value = ComGetEtcData(sXml,"fdr_trf_no");
 		 			formObj.amdt_seq.value = ComGetEtcData(sXml,"amdt_seq");
 		 			formObj.cre_dt.value = ComGetMaskedValue( ComGetEtcData(sXml,"cre_dt"), "ymd");	
 		 			formObj.eff_dt.value = ComGetMaskedValue( ComGetEtcData(sXml,"eff_dt"), "ymd");	
 		 			formObj.cfm_dt.value = ComGetMaskedValue( ComGetEtcData(sXml,"cfm_dt"), "ymd");	
 		 			formObj.cfm_usr.value = ComGetEtcData(sXml,"cfm_usr");
 		 			formObj.cre_usr.value = ComGetEtcData(sXml,"cre_usr");
 		 			formObj.fic_prop_sts_cd.value = ComGetEtcData(sXml,"fic_prop_sts_cd");
 		 			formObj.fic_prop_sts_nm.value = ComGetEtcData(sXml,"fic_prop_sts_nm");
 		 			formObj.exp_dt.value =  ComGetMaskedValue( ComGetEtcData(sXml,"exp_dt"), "ymd");	
 		 			
 		 			var trf = formObj.fdr_trf_no.value;
 		 			formObj.fdr_trf_no_view.value = trf.substr(0,3)+"-"+trf.substr(3,1)+"-"+trf.substr(4,3)+"-"+trf.substr(7,4);
 		 			
 		 			if(formObj.amdt_seq.value == "0" && formObj.fic_prop_sts_cd.value == "I" ){
 		 				formObj.eff_dt.readOnly =  false;
 		 				formObj.eff_dt.setAttribute("className","input1");
 		 			}else{
 		 				formObj.eff_dt.readOnly =  true;
 		 				formObj.eff_dt.setAttribute("className","input2");
 		 			}
 		 			
// 		 			//DG cargo 데이터가 있을경우 버튼을 파란색으로
// 		 			if(sheetObjects[1].CellValue( sheetObjects[1].SelectRow , "dg_count")  != "0" ){
// 		 				document.getElementById("btn_dg_cgo_scg").style.color = "blue";
// 		 			}
 		 			
 		 			doActionIBSheet(sheetObjects[0],document.form,SEARCH01);          
 		 		}else {
 		 			ComShowCodeMessage('PRI07005'); 
 		 			clearAllForms();
 		 			sheetObjects[0].RemoveAll();     
 		 			buttonControl("LOAD");
 		 			comboObjects[1].Index = -1;
 		 			document.form.svc_scp_combo.focus();	 			
 		 		}
                break;
                
            case SEARCH01:   // retrieve sheet 
            	ComOpenWait(true); //->waiting->start
            	clearAllgridForms();
	 			formObj.f_cmd.value = SEARCH01;	 			
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7011GS.do", FormQueryString(formObj));	 	 	 
	 			sheetObj.LoadSearchXml(sXml);	
	 			
	 	        formObj.flat_percent_20_app.value="";   
	 	        formObj.flat_percent_40_app.value="";   
	 	        formObj.flat_percent_45_app.value="";	// 45' Cost 추가
	 	        comboObjects[2].Index = -1;
	 	        comboObjects[3].Index = -1;
	 	        comboObjects[4].Index = -1;	// 45' Cost 추가
	 	        
	 	        if(comboObjects[0].Code == "D"){
	 	        	sheetObjects[0].CellValue( 0 , "pnt_loc_cd") = "Destination" ;
	 	        	sheetObjects[0].CellValue( 1 , "pnt_loc_cd") = "Destination" ;
	 	        	sheetObjects[0].CellValue( 2 , "pnt_loc_cd") = "Destination" ;
	 	        }else{
	 	        	sheetObjects[0].CellValue( 0 , "pnt_loc_cd") = "Origin" ;
	 	        	sheetObjects[0].CellValue( 1 , "pnt_loc_cd") = "Origin" ;
	 	        	sheetObjects[0].CellValue( 2 , "pnt_loc_cd") = "Origin" ;	
	 	        }
	 			
	 			if(formObj.amdt_seq.value == "0" && formObj.fic_prop_sts_cd.value == "I" ){
	 		    	buttonControl("INIT");	
	 			}else{
	 				buttonControl(formObj.fic_prop_sts_cd.value);	 
	 			}
	 			setSheet3Style(sheetObj, -1);
	 			ComOpenWait(false); //->waiting->End
                break;   
                
            case IBCREATE: 	// New
            	ComOpenWait(true); //->waiting->start
            	comboObjects[0].Index = 0;
                comboObjects[1].Index = -1;
                clearAllForms();                
                sheetObjects[0].RemoveAll();      
                ComOpenWait(false); //->waiting->End
                buttonControl("LOAD");
                document.form.svc_scp_combo.focus();
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
		 		var sParam = FormQueryString(formObj); 
		 		var sParamSheet1 = sheetObjects[0].GetSaveString(false, true);
		 		var sParamSheet2 = sheetObjects[1].GetSaveString(false, true);

		 		if(sParamSheet2 != ""){
		 			sParam2 = sParam + "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
		 			var sXml = sheetObjects[1].DoSave("ESM_PRI_7011GS.do", sParam2, -1, false );  
		 		}

		 		if(sParamSheet1 != ""){
		 			sParam1 = sParam + "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
		 			var sXml = sheetObjects[0].DoSave("ESM_PRI_7011GS.do", sParam1, -1, false );  
		 		}
     
		 		var save_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        		ComOpenWait(false); //->waiting->End
		     	if(save_result != "F" ){
		     		ComPriSaveCompleted();
		            //Apply data clear
		            formObj.flat_percent_20_app.value="";   
		            formObj.flat_percent_40_app.value="";   
		            formObj.flat_percent_45_app.value="";	// 45' Cost 추가
		            formObj.cgoTpcd[0].checked=false; 
		            formObj.cgoTpcd[1].checked=false; 
		            comboObjects[2].Index ="-1" ;   
		            comboObjects[3].Index ="-1" ;
		            comboObjects[4].Index ="-1" ;	// 45' Cost 추가
		     	}                   
                break;  
            
                
            case MULTI01: // Amend
                formObj.f_cmd.value = MULTI05;
		 		var sParam = FormQueryString(formObj); 		
                var sXml = sheetObj.GetSearchXml("ESM_PRI_7011GS.do", sParam);    
                sheetObjects[1].LoadSearchXml(sXml);	
                
        		if(sheetObjects[1].CellValue( sheetObj.SelectRow , "check_cost_trf_no")  == "1" ){
        			ComShowCodeMessage('PRI07006'); 
                	return false;
                }
    	
	            var rtnVal = ComPriOpenWindowCenter("/hanjin/ESM_PRI_7012.do?"+sParam, "", 750, 300, true);   
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
		 		var sParam = FormQueryString(formObj); 	 		
                var sXml = sheetObj.GetSaveXml("ESM_PRI_7011GS.do", sParam);                
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
    		 		var sParam = FormQueryString(formObj); 		
                    var sXml = sheetObj.GetSearchXml("ESM_PRI_7011GS.do", sParam);      
                    
            		if(ComGetMaskedValue( ComGetEtcData(sXml,"eff_dt"), "ymd") >= formObj.eff_dt.value ){
	            		ComShowCodeMessage('PRI05006', ComGetMaskedValue( ComGetEtcData(sXml,"eff_dt"), "ymd"));
	            		formObj.eff_dt.focus();
                    	return false;
                    }
                }
                
                ComOpenWait(true); //->waiting->start           
                if (!ComPriConfirmConfirm()) {
                	ComOpenWait(false); //->waiting->End
                    return false;
                }
            	             
                formObj.f_cmd.value = MULTI03;
                formObj.fic_prop_sts_cd.value = "C";	
                
		 		var sParam = FormQueryString(formObj); 		
                var sXml = sheetObj.GetSaveXml("ESM_PRI_7011GS.do", sParam);  
                ComOpenWait(false); //->waiting->End
                
		 		var confirm_result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	if(confirm_result != "F" ){
		     		ComPriConfirmCompleted();
		     		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		     		buttonControl(formObj.fic_prop_sts_cd.value);	 			
		     	}            
        		
                break;  
                
			case MULTI04: // Row Amend
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                
	            var checkedCnt = sheetObjects[0].CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObjects[0].FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObjects[0].SelectRow = curRow;
	        		sheetObjects[0].CellValue2(curRow, "chk") = "0";
	        	}
	        	
	        	var idx = doRowAmend(sheetObj, "AM");
				setSheet3Style(sheetObj, idx - 1);
				setSheet3Style(sheetObj, idx);
				break;	
				
			case MULTI05: // Amend Cancel
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
                
	            var checkedCnt = sheetObjects[0].CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow = parseInt(sheetObjects[0].FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObjects[0].SelectRow = curRow;
	        		sheetObjects[0].CellValue2(curRow, "chk") = "0";
	        	}
	        	
	        	var prevIdx = doRowAmendCancel(sheetObj);
	        	setSheet3Style(sheetObj, prevIdx);
				break;
				
			case MULTI06: // Delete
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
	        	}
	        	
	    		var sCheckedRows = sheetObj.FindCheckedRow("chk");
	    		var arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
	    		
            	for (var i = arrCheckedRows.length - 1; i >= 0; i--) {
	            	if (sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SelectRow = arrCheckedRows[i];
	               		sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "0";
	                	
	               		var idx = doRowAmend(sheetObj, "AD");
	        			setSheet3Style(sheetObj, idx - 1);
	        			setSheet3Style(sheetObj, idx);
	            	}
	        	}
	        	deleteRowCheck(sheetObj, "chk");
				break;	
				
            case MULTI07: // Apply          
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                } 
                
                ComOpenWait(true); //->waiting->start
	            if (!ComShowCodeConfirm("PRI00014")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }
				
            	var amdt_seq = formObj.amdt_seq.value;
            	var eff_dt = formObj.eff_dt.value;
            	var star_idex = 3 ;
            	var all_row = sheetObj.RowCount + star_idex ;
            	var sheetObj = sheetObjects[0] ;
            	var dry_apply = formObj.cgoTpcd[0].checked ;
            	var rf_apply = formObj.cgoTpcd[1].checked ;
            	
            	for (var i = 3 ; i < all_row ; i++ ){
            		if(sheetObjects[0].CellValue( i, "amdt_seq") != sheetObjects[0].CellValue( i, "n1st_cmnc_amdt_seq") ){
        				// DataCopy/ Insert 기준 row 를 잡기 위해 Row 설정
        		        sheetObj.SelectRow = i ;
        		        var idx = sheetObj.DataCopy();     // new row
        		        var idx2 = idx-1;                 //origin row
        		        
        		        // new row
        		        sheetObj.CellEditable(idx,"gline_20ft_frt_rt_amt") = true ;
        		        sheetObj.CellEditable(idx,"gline_40ft_frt_rt_amt") = true ;        	
        		        
        		        // HAMRU 경우만 45' Cost 수정 가능
        		        if(formObj.menu_rhq_cd.value == "HAMRU"){
        		        	sheetObj.CellEditable(idx,"gline_45ft_frt_rt_amt") = true ;	// 45' Cost 추가
        		        }
        		        
        		        sheetObj.CellEditable(idx,"gline_rf_20ft_frt_rt_amt") = true ;
        		        sheetObj.CellEditable(idx,"gline_rf_40ft_frt_rt_amt") = true ;      
        		        sheetObj.CellEditable(idx,"rc_svc_flg") = true ;      
        		        sheetObj.CellValue2(idx,"n1st_cmnc_amdt_seq")= amdt_seq;
        		        sheetObj.CellValue2(idx,"eff_dt")= eff_dt;
        		        sheetObj.CellValue2(idx, "src_info_cd")  = "AM" ;			
        		        sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol)= sheetObj.RgbColor(255,0,0);
        		        sheetObj.RowStatus(idx) = "U";	

        		        //origin row
        		        sheetObj.CellValue2(idx2,"amdt_seq")=amdt_seq-1;
        		        sheetObj.CellFont("FontStrikethru", idx2, 1, idx2, sheetObj.LastCol)=true;
        		        sheetObj.CellValue2(idx2,"exp_dt") = ComGetDateAdd(sheetObj.CellValue(idx,"eff_dt"), "D", -1);  
        		        sheetObj.RowStatus(idx2) = "R"; 
        		        sheetObj.RowEditable(idx2) = false;
        		        
    		        	if(dry_apply == true){
	        				if(comboObjects[2].Code == "F"){
	        					sheetObj.CellValue( idx , "gline_20ft_frt_rt_amt") 
		            			= parseFloat(sheetObj.CellValue( idx , "gline_20ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_20_app.value);
	            			}
		            		
		            		if(comboObjects[2].Code == "P"){
		            			sheetObjects[0].CellValue( idx , "gline_20ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( idx , "gline_20ft_frt_rt_amt")) * (1  + (formObj.flat_percent_20_app.value)/100);
		            		}
		            		
		            		if(comboObjects[3].Code == "F"){
		            			sheetObjects[0].CellValue( idx , "gline_40ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_40_app.value);
		            		}
		            		
		            		if(comboObjects[3].Code == "P"){
		            			sheetObjects[0].CellValue( idx , "gline_40ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) * (1  + (formObj.flat_percent_40_app.value)/100);
		            		}
		            		
        		        	// 45' Cost 추가
        		        	if(comboObjects[4].Code == "F"){
        		        		sheetObjects[0].CellValue( idx , "gline_45ft_frt_rt_amt") 
        		        		= parseFloat(sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_45_app.value);
        		        	}
        		        	
        		        	if(comboObjects[4].Code == "P"){
        		        		sheetObjects[0].CellValue( idx , "gline_45ft_frt_rt_amt") 
        		        		= parseFloat(sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt")) * (1  + (formObj.flat_percent_45_app.value)/100);
        		        	}
    		        	}
        		        	
    		        	if(rf_apply == true){
	        				if(comboObjects[2].Code == "F"){
	        					sheetObj.CellValue( idx , "gline_rf_20ft_frt_rt_amt") 
		            			= parseFloat(sheetObj.CellValue( idx , "gline_rf_20ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_20_app.value);
	            			}
		            		
		            		if(comboObjects[2].Code == "P"){
		            			sheetObjects[0].CellValue( idx , "gline_rf_20ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( idx , "gline_rf_20ft_frt_rt_amt")) * (1  + (formObj.flat_percent_20_app.value)/100);
		            		}
		            		
		            		if(comboObjects[3].Code == "F"){
		            			sheetObjects[0].CellValue( idx , "gline_rf_40ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_40_app.value);
		            		}
		            		
		            		if(comboObjects[3].Code == "P"){
		            			sheetObjects[0].CellValue( idx , "gline_rf_40ft_frt_rt_amt") 
		            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt")) * (1  + (formObj.flat_percent_40_app.value)/100);
		            		}
    		        	}
    		        	
	            		i++;
	            		all_row++;	     			
            		}else{
                		if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){
                			if(dry_apply == true){
		        				if(comboObjects[2].Code == "F"){
			            			sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_20_app.value);
		            			}
			            		
			            		if(comboObjects[2].Code == "P"){
			            			sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt")) * (1  + (formObj.flat_percent_20_app.value)/100);
			            		}
	
			            		if(comboObjects[3].Code == "F"){
			            			sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_40_app.value);
			            		}
			            		
			            		if(comboObjects[3].Code == "P"){
			            			sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt")) * (1  + (formObj.flat_percent_40_app.value)/100);
			            		}
			            		
		            			// 45' Cost 추가
		            			if(comboObjects[4].Code == "F"){
		            				sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") 
		            				= parseFloat(sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_45_app.value);
		            			}
		            			
		            			if(comboObjects[4].Code == "P"){
		            				sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") 
		            				= parseFloat(sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt")) * (1  + (formObj.flat_percent_45_app.value)/100);
		            			}
                			}
                		}
                		
                		if(sheetObj.CellEditable(i, "gline_rf_20ft_frt_rt_amt")){
                			if(rf_apply == true){
		        				if(comboObjects[2].Code == "F"){
			            			sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_20_app.value);
		            			}
			            		
			            		if(comboObjects[2].Code == "P"){
			            			sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt")) * (1  + (formObj.flat_percent_20_app.value)/100);
			            		}
	
			            		if(comboObjects[3].Code == "F"){
			            			sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt")) + parseFloat(formObj.flat_percent_40_app.value);
			            		}
			            		
			            		if(comboObjects[3].Code == "P"){
			            			sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") 
			            			= parseFloat(sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt")) * (1  + (formObj.flat_percent_40_app.value)/100);
			            		}
                			}
                		}
            		}
            	}
            	ComOpenWait(false); //->waiting->End
                break;  
				
				
            case MODIFY01: // g/l tuning
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                } 
                
	            if (!ComShowCodeConfirm("PRI07016")) {
	            	ComOpenWait(false); //->waiting->End
	            	return false;
	            }         		
            	
	            var last_row_count = sheetObjects[0].LastRow ;
            	var dry_apply = formObj.cgoTpcd[0].checked ;
            	var rf_apply = formObj.cgoTpcd[1].checked ;
	            
            	for (var i = sheetObjects[0].HeaderRows; i <= last_row_count; i++) {
            		// DRY            		
            		if(dry_apply == true){
            			if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){	
	            			var gl20 = sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt");
	                		var gl40 = sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt");               			
	                		var gl45 = sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt");	// 45' Cost 추가
	            			
	            			var gl20int =  ""+gl20 * 100 ;
	            			var gl40int =  ""+gl40 * 100 ;
	            			var gl45int =  ""+gl45 * 100 ;
	            			
	            			var gl20trunc = ""+Math.floor(gl20);
	            			var gl40trunc = ""+Math.floor(gl40);
	            			var gl45trunc = ""+Math.floor(gl45);
	            			
	        				if(gl20int.substring(gl20int.length, gl20int.length-3) != "000" || gl20int.substring(gl20int.length, gl20int.length-3) != "500" ){
	        					if(gl20trunc.charAt(gl20trunc.length-1) == "0" || gl20trunc.charAt(gl20trunc.length-1) == "5" ){
	        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = parseInt(gl20);
	        					}else if(gl20trunc.charAt(gl20trunc.length-1) < 5){						
	        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = gl20trunc.substr(0, gl20trunc.length -1) + "5" ; 
	        					}else if(gl20trunc.charAt(gl20trunc.length-1) > 5){				
	        						sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") = Math.ceil(gl20 * 0.1) * 10 ;     
	        					}        						
	            			}
	
	        				if(gl40int.substring(gl40int.length, gl40int.length-3) != "000" || gl40int.substring(gl40int.length, gl40int.length-3) != "500" ){
	        					if(gl40trunc.charAt(gl40trunc.length-1) == "0" || gl40trunc.charAt(gl40trunc.length-1) == "5" ){
	        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = parseInt(gl40);
	        					}else if(gl40trunc.charAt(gl40trunc.length-1) < 5){
	        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = gl40trunc.substr(0, gl40trunc.length -1) + "5" ;       					
	        					}else if(gl40trunc.charAt(gl40trunc.length-1) > 5){		
	        						sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") = Math.ceil(gl40 * 0.1) * 10 ;     		
	        					}
		            		}
	        				
	        				// 45' Cost 추가
        					if(gl45int.substring(gl45int.length, gl45int.length-3) != "000" || gl45int.substring(gl45int.length, gl45int.length-3) != "500" ){
        						if(gl45trunc.charAt(gl45trunc.length-1) == "0" || gl45trunc.charAt(gl45trunc.length-1) == "5" ){
        							sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") = parseInt(gl45);
        						}else if(gl45trunc.charAt(gl45trunc.length-1) < 5){
        							sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") = gl45trunc.substr(0, gl45trunc.length -1) + "5" ;       					
        						}else if(gl45trunc.charAt(gl45trunc.length-1) > 5){		
        							sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") = Math.ceil(gl45 * 0.1) * 10 ;     		
        						}
        					}
            			}
            		}
            		// RF 
            		if(rf_apply == true){
            			if(sheetObj.CellEditable(i, "gline_rf_20ft_frt_rt_amt")){
	            			var glrf20 = sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt");
	                		var glrf40 = sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt");               			
	            			
	            			var glrf20int =  ""+glrf20 * 100 ;
	            			var glrf40int =  ""+glrf40 * 100 ;
	            			
	            			var glrf20trunc = ""+Math.floor(glrf20);
	            			var glrf40trunc = ""+Math.floor(glrf40);
	            			
	        				if(glrf20int.substring(glrf20int.length, glrf20int.length-3) != "000" || glrf20int.substring(glrf20int.length, glrf20int.length-3) != "500" ){
	        					if(glrf20trunc.charAt(glrf20trunc.length-1) == "0" || glrf20trunc.charAt(glrf20trunc.length-1) == "5" ){
	        						sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") = parseInt(glrf20);
	        					}else if(glrf20trunc.charAt(glrf20trunc.length-1) < 5){						
	        						sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") = glrf20trunc.substr(0, glrf20trunc.length -1) + "5" ; 
	        					}else if(glrf20trunc.charAt(glrf20trunc.length-1) > 5){				
	        						sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") = Math.ceil(glrf20 * 0.1) * 10 ;     
	        					}        						
	            			}
	
	        				if(glrf40int.substring(glrf40int.length, glrf40int.length-3) != "000" || glrf40int.substring(glrf40int.length, glrf40int.length-3) != "500" ){
	        					if(glrf40trunc.charAt(glrf40trunc.length-1) == "0" || glrf40trunc.charAt(glrf40trunc.length-1) == "5" ){
	        						sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") = parseInt(glrf40);
	        					}else if(glrf40trunc.charAt(glrf40trunc.length-1) < 5){
	        						sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") = glrf40trunc.substr(0, glrf40trunc.length -1) + "5" ;       					
	        					}else if(glrf40trunc.charAt(glrf40trunc.length-1) > 5){		
	        						sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") = Math.ceil(glrf40 * 0.1) * 10 ;     		
	        					}
		            		}
	        				
	            		}
            		}
            	}
            	ComOpenWait(false); //->waiting->End
                break;                
                
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				break;
				
			case MULTI09: // Add
                var amdt_seq = formObj.amdt_seq.value;       
                var iRow = sheetObjects[0].DataInsert(-1);
            	// AMD seq. > 0 일경우 폰트 컬러를 red로 
                if(amdt_seq > 0){
                	sheetObjects[0].RowFontColor(iRow) = sheetObjects[0].RgbColor(255,0,0);
                }
                sheetObjects[0].CellEditable(iRow, 'gline_20ft_frt_rt_amt') = true;
                sheetObjects[0].CellEditable(iRow, 'gline_40ft_frt_rt_amt') = true;
                
                // HAMRU 경우만 45' Cost 수정 가능
		        if(document.form.menu_rhq_cd.value == "HAMRU"){
					sheetObjects[0].CellEditable(iRow, 'gline_45ft_frt_rt_amt') = true;	// 45' Cost 추가
				}
                sheetObjects[0].CellEditable(iRow, 'rc_svc_flg') = true;
                sheetObjects[0].CellValue2(iRow, 'src_info_cd') = 'NW';
                sheetObjects[0].CellValue2(iRow, 'amdt_seq') = amdt_seq;
                sheetObjects[0].CellValue2(iRow, 'n1st_cmnc_amdt_seq') = amdt_seq;
                sheetObjects[0].CellValue2(iRow, 'eff_dt') = formObj.eff_dt.value;
                sheetObjects[0].CellValue2(iRow, 'svc_scp_cd') = formObj.svc_scp_cd.value;
                sheetObjects[0].CellValue2(iRow, 'fdr_trf_no') = formObj.fdr_trf_no.value;
                sheetObjects[0].CellValue2(iRow, 'org_dest_tp_cd') = comboObjects[0].Code;
                sheetObjects[0].CellValue2(iRow, 'rhq_cd') = formObj.menu_rhq_cd.value;     
                sheetObjects[0].CellValue2(iRow, 'rc_svc_flg') = 'N';
                sheetObjects[0].SelectCell(iRow, "pnt_loc_cd");
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
                style.height = 360;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;              

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                InitRowInfo( 3, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|Sel.|Seq|RTSeq|Destination|Base Port|Contract\nTerm|Dry Tariff (USD)|Dry Tariff (USD)|Dry Tariff (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|" +
									 "Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|" +
									 "RF SVC|RF Tariff (USD)|RF Tariff (USD)|RF Diff. (USD)|RF Diff. (USD)|RF Total Cost|RF Total Cost|RF Total Cost|RF Total Cost|RF Total Cost|" +
									 "RF Full trans cost (USD)|RF Full trans cost (USD)|RF MTY trans cost (USD)|RF MTY trans cost (USD)|RF TMNL cost (USD)|RF TMNL cost (USD)|RF M/B Ratio (%, in SCC)|RF M/B Ratio (%, in SCC)|" +
									 "EFF Date|EXP Date|Source|Remarks|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD|RHQ_CD|DCGO_SVC_FLG";  
				var HeadTitle2 = "ibflag|Sel.|Seq|RTSeq|Destination|Base Port|Contract\nTerm|Dry Tariff (USD)|Dry Tariff (USD)|Dry Tariff (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Diff. (USD)|USD|USD|USD|Local Currency|Local Currency|Local Currency|Local Currency|" +
									 "Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|" +
									 "RF SVC|RF Tariff (USD)|RF Tariff (USD)|RF Diff. (USD)|RF Diff. (USD)|USD|USD|Local Currency|Local Currency|Local Currency|" +
									 "RF Full trans cost (USD)|RF Full trans cost (USD)|RF MTY trans cost (USD)|RF MTY trans cost (USD)|RF TMNL cost (USD)|RF TMNL cost (USD)|RF M/B Ratio (%, in SCC)|RF M/B Ratio (%, in SCC)|" +
									 "EFF Date|EXP Date|Source|Remarks|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD|RHQ_CD|DCGO_SVC_FLG";  		
				var HeadTitle3 = "ibflag|Sel.|Seq|RTSeq|Destination|Base Port|Contract\nTerm|20'|40'|45'|20'|40'|45'|20'|40'|45'|Cur.|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|" +
				                     "RF SVC|20'|40'|20'|40'|20'|40'|Cur.|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|" +
									 "EFF Date|EXP Date|Source|Remarks|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|ORG_DEST_TP_CD|RHQ_CD|DCGO_SVC_FLG";   

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]        
                InitColumnInfo(headCount, 7 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus       
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
				InitHeadRow(1, HeadTitle2, true);  
                InitHeadRow(2, HeadTitle3, true); 

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 		daCenter, 	    true, 	"ibflag"); 
                InitDataProperty(0, cnt++,  dtCheckBox, 		40, 		daCenter, 	    true, 	"chk");         
                InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	    true,  	"Seq");       
                InitDataProperty(0, cnt++, 	dtHidden,    		40,    		daCenter,  	    true,  	"rt_seq",                         false, "", dfNone,  0, false, false);        
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daCenter, 	    true, 	"pnt_loc_cd",                      true, "", dfNone,  0, false, true, 5);                                
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daCenter, 	    true, 	"bse_port_loc_cd",                 true, "", dfNone,  0, false, true, 5);                                       
                InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	    true, 	"rcv_de_term_cd",                  true, "", dfNone,  0, false, true);                                 
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"gline_20ft_frt_rt_amt",          false, "", dfFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_40ft_frt_rt_amt",          false, "", dfFloat, 2, false, false, 9);   
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"gline_45ft_frt_rt_amt",          false, "", dfFloat, 2, false, false, 9);		// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight, 		true, 	"diff_20ft",	                  false, "|gline_20ft_frt_rt_amt|-|cost_20ft_frt_rt_amt|", dfFloat, 2);                                
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight, 		true, 	"diff_40ft",	                  false, "|gline_40ft_frt_rt_amt|-|cost_40ft_frt_rt_amt|", dfFloat, 2);
                // HAMRU 경우만 45' Cost 수정 가능
		        if(document.form.menu_rhq_cd.value == "HAMRU"){
                	InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight, 		true, 	"diff_45ft",	                  false, "|gline_45ft_frt_rt_amt|-|cost_45ft_frt_rt_amt|", dfFloat, 2);
                } else {
                	InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight, 		true, 	"diff_45ft",	                  false, "|gline_40ft_frt_rt_amt|-|cost_40ft_frt_rt_amt|", dfFloat, 2);
                }
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"cost_20ft_frt_rt_amt",           false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"cost_40ft_frt_rt_amt",           false, "", dfNullFloat, 2, false, false, 9);           
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"cost_45ft_frt_rt_amt",           false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			40, 		daCenter, 	    true, 	"locl_curr_cd",                   false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"locl_curr_cost_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                       
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"locl_curr_cost_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"locl_curr_cost_45ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"trsp_20ft_cost_amt",             false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"trsp_40ft_cost_amt",             false, "", dfNullFloat, 2, false, false, 9);         
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"trsp_45ft_cost_amt",             false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mty_trsp_20ft_cost_amt",         false, "", dfNullFloat, 2, false, false, 9);    
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mty_trsp_40ft_cost_amt",         false, "", dfNullFloat, 2, false, false, 9);    
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mty_trsp_45ft_cost_amt",         false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"tml_20ft_cost_amt",              false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"tml_40ft_cost_amt",              false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"tml_45ft_cost_amt",              false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mb_20ft_rto",                    false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_40ft_rto",                    false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_45ft_rto",                    false, "", dfNullFloat, 2, false, false, 9);	// 45' Cost 추가
                
                InitDataProperty(0, cnt++, 	dtCombo, 			50, 		daCenter,		true, 	"rc_svc_flg",                     false, "", dfNone, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"gline_rf_20ft_frt_rt_amt",       false, "", dfNullFloat, 2, false, false, 9);                                           
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"gline_rf_40ft_frt_rt_amt",       false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"diff_rf_20ft",                   false, "|gline_rf_20ft_frt_rt_amt|-|cost_rf_20ft_frt_rt_amt|", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"diff_rf_40ft",                   false, "|gline_rf_40ft_frt_rt_amt|-|cost_rf_40ft_frt_rt_amt|", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"cost_rf_20ft_frt_rt_amt",        false, "", dfNullFloat, 2, false, false, 9);                                           
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"cost_rf_40ft_frt_rt_amt",        false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			40, 		daCenter, 	    true, 	"locl_curr_cd_rf",                false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"locl_curr_cost_rf_20ft_rt_amt",  false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"locl_curr_cost_rf_40ft_rt_amt",  false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"trsp_rf_20ft_cost_amt",          false, "", dfNullFloat, 2, false, false, 9);                                           
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"trsp_rf_40ft_cost_amt",          false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mty_trsp_rf_20ft_cost_amt",      false, "", dfNullFloat, 2, false, false, 9);                                           
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	 	true, 	"mty_trsp_rf_40ft_cost_amt",      false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"tml_rf_20ft_cost_amt",           false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"tml_rf_40ft_cost_amt",           false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_rf_20ft_rto",                 false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,		true, 	"mb_rf_40ft_rto",                 false, "", dfNullFloat, 2, false, false, 9);
                
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	    true, 	"eff_dt",                         false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	    true, 	"exp_dt",                         false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	    true, 	"src_info_cd",                    false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daLeft,		 	true, 	"fdr_rt_rmk",                     false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	    true, 	"fdr_trf_no",                     false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	    true, 	"amdt_seq",                       false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	    true, 	"n1st_cmnc_amdt_seq",             false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	    true, 	"svc_scp_cd",                     false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	    true, 	"org_dest_tp_cd",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++,  dtHidden, 			60,			daCenter,  	    true,   "rhq_cd", 			              false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++,  dtHidden, 			60,			daCenter,  	    true,   "dcgo_svc_flg", 			      false, "", dfNone, 0, false, false);	
                                   
                InitDataCombo(0, "rcv_de_term_cd", termCdText, termCdValue);     
                InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);   
                InitDataCombo(0, "rc_svc_flg", "YES|NO",    "Y|N");
                sheetObj.CellBackColor(0,"gline_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(0,"gline_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(0,"gline_45ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);		// 45' Cost 추가
                sheetObj.CellBackColor(1,"gline_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(1,"gline_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(1,"gline_45ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);		// 45' Cost 추가
                sheetObj.CellBackColor(0,"gline_rf_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(0,"gline_rf_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(1,"gline_rf_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.CellBackColor(1,"gline_rf_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
                sheetObj.SetMergeCell (0, 7, 2, 3);  
                sheetObj.SetMergeCell (0, 10, 2, 3);  
                sheetObj.SetMergeCell (0, 20, 2, 3);  
                sheetObj.SetMergeCell (0, 23, 2, 3);  
                sheetObj.SetMergeCell (0, 26, 2, 3);  
                sheetObj.SetMergeCell (0, 29, 2, 3);  
                //RF
                sheetObj.SetMergeCell (0, 33, 2, 2); 
                sheetObj.SetMergeCell (0, 35, 2, 2); 
                sheetObj.SetMergeCell (0, 42, 2, 2);  
                sheetObj.SetMergeCell (0, 44, 2, 2);  
                sheetObj.SetMergeCell (0, 46, 2, 2);  
                sheetObj.SetMergeCell (0, 48, 2, 2);  

                InitDataValid(0, "pnt_loc_cd", vtEngUpOnly);
                InitDataValid(0, "bse_port_loc_cd", vtEngUpOnly);     
                WaitImageVisible = false;  
                Ellipsis = true;
    		}
            break;
            
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 330;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;              

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                InitRowInfo(1, 1, 20, 100);
    
				var HeadTitle1 = "ibflag|FDR_TRF_NO|AMDT_SEQ|SVC_SCP_CD|EFF_DT|CHECK_COST_TRF_NO|DG_COUNT|ORG_DEST_TP_CD";

                var headCount = ComCountHeadTitle(HeadTitle1);
			
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0 , 0, true);
		
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, true, true, false, false);           
	
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++, 	dtStatus,		30, 		daCenter, 	true, 	"ibflag");      
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"fdr_trf_no", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"check_cost_trf_no", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"dg_count", false, "", dfNone, 0, false, false);    
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"org_dest_tp_cd", false, "", dfNone, 0, false, false);  
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
	 			
	 		case "fix_percent_20" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	                InsertItem(i++, "Flat", "F");
	                InsertItem(i++, "%", "P");
	            }
	            break;
    
	 		case "fix_percent_40" :	
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;                                                                                                                                                                                                                                                                                                                                                                                                                              
	 				UseAutoComplete = true;  
	                InsertItem(i++, "Flat", "F");
	                InsertItem(i++, "%", "P");
	            }
	            break;  
    		// 45' Cost 추가
	 		case "fix_percent_45" :
	            var i = 0;
	            with (comboObj) {
	 				DropHeight = 200;
	 				MultiSelect = false;
	 				MaxSelect = 1;
	 				UseAutoComplete = true; 
	                InsertItem(i++, "Flat", "F");
	                InsertItem(i++, "%", "P");
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
            break;

        case IBSAVE: // Save    
            clearTooltip();
            if(!sheetObjects[0].IsDataModified && !sheetObjects[1].IsDataModified ){
                ComShowCodeMessage('PRI00301'); 
                return false;
            }
            
            if (formObj.eff_dt.value == "" && formObj.fic_prop_sts_cd.value == "I" && formObj.amdt_seq.value == "0") {
            	ComShowCodeMessage('PRI00308',"input","Effective Date"); 
            	formObj.eff_dt.focus();
                return false;
            }
            // row add 의 필수 입력 체크
            for (var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
	            if (sheetObjects[0].CellValue( i, "ibflag") =="I") {
	            	if(sheetObjects[0].CellValue( i, "pnt_loc_cd") ==""){
	            		ComShowCodeMessage('COM130201', sheetObjects[0].CellValue( 0 , "pnt_loc_cd")); 
	            		sheetObjects[0].SelectCell( i, "pnt_loc_cd");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "bse_port_loc_cd") ==""){
	            		ComShowCodeMessage('COM130201', "Base Port"); 
	            		sheetObjects[0].SelectCell( i, "bse_port_loc_cd");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "rcv_de_term_cd") ==""){
	            		ComShowCodeMessage('COM130201', "Term"); 
	            		sheetObjects[0].SelectCell( i, "rcv_de_term_cd");
	            		 return false;
	            	}
	            }
            }     
    		//Point,Base Port 의 중복 체크
            var duprows = ComPriAmendDupCheckAllRow(sheetObjects[0], "pnt_loc_cd|bse_port_loc_cd", formObj.amdt_seq.value );      
    		if(duprows != '-1') {
				var duprows2 = duprows.split(",");	
				for (var x=0; x < duprows2.length-1; x++) {						
					add2Tooltip(duprows2[x], 'pnt_loc_cd', msgs['PRI00302']);
					add2Tooltip(duprows2[x], 'bse_port_loc_cd', msgs['PRI00302']);
				}
				
				ComShowCodeMessage('PRI00302'); 
    			sheetObjects[0].SelectCell( duprows2[0], "pnt_loc_cd");
				return false;
    		}
            break;
            
        case MULTI03: // Confirm
            if(sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified){
                ComShowCodeMessage('PRI01057'); 
                return false;
            }

            for (var i = sheetObjects[0].HeaderRows; i <= sheetObjects[0].LastRow; i++) {
            	//Dry
            	if(sheetObj.CellEditable(i, "gline_20ft_frt_rt_amt")){
	            	if(sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") =="0" || sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt") ==""){
	            		ComShowCodeMessage('PRI07008', sheetObjects[0].CellValue( i, "pnt_loc_cd")); 
	            		sheetObjects[0].SelectCell( i, "gline_20ft_frt_rt_amt");
	            		 return false;
	            	}
	            	
	            	if(sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") =="0" || sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt") ==""){
	            		ComShowCodeMessage('PRI07008', sheetObjects[0].CellValue( i, "pnt_loc_cd")); 
	            		sheetObjects[0].SelectCell( i, "gline_40ft_frt_rt_amt");
	            		 return false;
	            	}
	            	
	            	//  45' Cost 추가
	            	// 확인 후 적용
//    		        if(document.form.menu_rhq_cd.value == "HAMRU"){
//	            		if(sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") =="0" || sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt") ==""){
//	            			ComShowCodeMessage('PRI07008', sheetObjects[0].CellValue( i, "pnt_loc_cd")); 
//	            			sheetObjects[0].SelectCell( i, "gline_45ft_frt_rt_amt");
//	            			return false;
//	            		}
//	            	}
	            	
	                var gl20 = sheetObjects[0].CellValue( i, "gline_20ft_frt_rt_amt");
	        		var gl40 = sheetObjects[0].CellValue( i, "gline_40ft_frt_rt_amt");               			
	        		var gl45 = sheetObjects[0].CellValue( i, "gline_45ft_frt_rt_amt");		// 45' Cost 추가
	    			
	    			var gl20int =  ""+gl20 * 100 ;
	    			var gl40int =  ""+gl40 * 100 ;
	    			var gl45int =  ""+gl45 * 100 ;
	
	    			
	    			if(gl20int.substring(gl20int.length, gl20int.length-3) != "000" && gl20int.substring(gl20int.length, gl20int.length-3) != "500" ){
	    				ComShowCodeMessage('PRI07015'); 
	           		 	return false;				
	    			}
	
	    			if(gl40int.substring(gl40int.length, gl40int.length-3) != "000" && gl40int.substring(gl40int.length, gl40int.length-3) != "500" ){
	    				ComShowCodeMessage('PRI07015');
	           		 	return false;		
	    			}
	
	            	//  45' Cost 추가
	            	// 확인 후 적용
//    		        if(document.form.menu_rhq_cd.value == "HAMRU"){
//	    				if(gl45int.substring(gl45int.length, gl45int.length-3) != "000" && gl45int.substring(gl45int.length, gl45int.length-3) != "500" ){
//	    					ComShowCodeMessage('PRI07015');
//	    					return false;		
//	    				}
//	    			}
            	}     
            	//RF
            	if(sheetObj.CellEditable(i, "gline_rf_20ft_frt_rt_amt")){
            		// RF 는 NULL 값도 있기 때문에 20, 40 각각 체크 
            		if(sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") !="" && sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt") !="0"){	            	
		                var glrf20 = sheetObjects[0].CellValue( i, "gline_rf_20ft_frt_rt_amt");			    			
		    			var glrf20int =  ""+glrf20 * 100 ;	
		    			
		    			if(glrf20int.substring(glrf20int.length, glrf20int.length-3) != "000" && glrf20int.substring(glrf20int.length, glrf20int.length-3) != "500" ){
		    				ComShowCodeMessage('PRI07015'); 
		           		 	return false;				
		    			}
            		}
            		
            		if(sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") !="" && sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt") !="0"){
		        		var glrf40 = sheetObjects[0].CellValue( i, "gline_rf_40ft_frt_rt_amt");               			
		    			var glrf40int =  ""+glrf40 * 100 ;		

		    			if(glrf40int.substring(glrf40int.length, glrf40int.length-3) != "000" && glrf40int.substring(glrf40int.length, glrf40int.length-3) != "500" ){
		    				ComShowCodeMessage('PRI07015');
		           		 	return false;		
		    			}
            		}         		
            	
            	}   
            	// RF SVC 가 YES 인데 값이 없을 경우
                if (sheetObj.CellValue(i, "rc_svc_flg") == "Y") {
                	if(sheetObj.CellValue(i, "gline_rf_20ft_frt_rt_amt") == "" && sheetObj.CellValue(i, "gline_rf_40ft_frt_rt_amt") == ""){
	    				ComShowCodeMessage('PRI01042','RF Tariff');    
	    				sheetObj.SelectCell( i, "gline_rf_20ft_frt_rt_amt");
	           		 	return false;		
                	}
                }
                // RF SVC 를 선택 안했을 경우
                if (sheetObj.CellValue(i, "rc_svc_flg") == "") {
    				ComShowCodeMessage('PRI01042','RF SVC');    
    				sheetObj.SelectCell( i, "rc_svc_flg");
           		 	return false;		
                }
            }            
            break;
            
        case MULTI04: // Amend
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
            break;
            
        case MULTI05: // Amend Cancel
        	var checkedCnt = sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow = -1;
        	if (checkedCnt == 1) {
        		 curRow = parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow = sheetObj.SelectRow;
        	}
        	
        	// Amend된 행이 아닌경우
        	if (sheetObj.CellValue(curRow, "src_info_cd") != "AM" && sheetObj.CellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.CellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
            break;
            
        case MULTI06: // Delete
        	var sCheckedRows = sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows = new Array();
        	if (sCheckedRows == "") {
        		arrCheckedRows.push(sheetObj.SelectRow);
        	} else { 
        		arrCheckedRows = sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i = 0; i < arrCheckedRows.length; i++) {
            	if (sheetObj.CellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
				if (sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "NW"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "GM"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PC"
					&& sheetObj.CellValue(arrCheckedRows[i], "src_info_cd") != "PM"
					&& sheetObj.CellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}  
            break;
            
        case MULTI07: // Apply
        	// DR, RF  둘중에 하나는 체크 해야한다. 
        	if( formObj.cgoTpcd[0].checked == false && formObj.cgoTpcd[1].checked == false){
               	ComShowCodeMessage('COM12113',"Apply type"); 
                return false;
        	}
        	
            if (comboObjects[2].Code != "" && formObj.flat_percent_20_app.value == "") {
               	ComShowCodeMessage('PRI00308',"input","the ‘20 amount"); 
               	formObj.flat_percent_20_app.focus();
                return false;
            }        	   
         	
             if (comboObjects[2].Code =="" && formObj.flat_percent_20_app.value != "") {
             	ComShowCodeMessage('PRI00308',"select","the ’20 apply condition"); 
             	formObj.fix_percent_20.focus();
                 return false;
             }
             
             if (comboObjects[3].Code != "" && formObj.flat_percent_40_app.value == "") {
               	ComShowCodeMessage('PRI00308',"input","the ‘40 amount"); 
               	formObj.flat_percent_40_app.focus();
                return false;
            }        	   
         	
             if (comboObjects[3].Code =="" && formObj.flat_percent_40_app.value != "") {
             	ComShowCodeMessage('PRI00308',"select","the ’40 apply condition"); 
             	formObj.fix_percent_40.focus();
                 return false;
             } 
             
        	var dry_apply = formObj.cgoTpcd[0].checked;
        	
             // 45' Cost 추가
             if(dry_apply == true && formObj.menu_rhq_cd.value == "HAMRU") {
            	 if (comboObjects[4].Code != "" && formObj.flat_percent_45_app.value == "") {
            		 ComShowCodeMessage('PRI00308',"input","the ‘45 amount");
            		 formObj.flat_percent_45_app.focus();
            		 return false;
            	 }
            	 
            	 if (comboObjects[4].Code =="" && formObj.flat_percent_45_app.value != "") {
            		 ComShowCodeMessage('PRI00308',"select","the ’45 apply condition");
            		 formObj.fix_percent_45.focus();
            		 return false;
            	 }
             }
             
            // 45' Cost 추가
            if(dry_apply == true && formObj.menu_rhq_cd.value == "HAMRU") {
            	if(comboObjects[2].Code =="" && formObj.flat_percent_20_app.value == "" && comboObjects[3].Code =="" & formObj.flat_percent_40_app.value == "" && comboObjects[4].Code =="" & formObj.flat_percent_45_app.value == "") {
            		ComShowCodeMessage('PRI00351');
            		return false;
            	}
            } else {
            	if (comboObjects[2].Code =="" && formObj.flat_percent_20_app.value == "" && comboObjects[3].Code =="" & formObj.flat_percent_40_app.value == "") {
            		ComShowCodeMessage('PRI00351');
            		return false;
            	}
            }
             
             var dot_count_20 = 0;
 	    	 var f20 = formObj.flat_percent_20_app.value ; 

 	    	  for(var i = 0 ; i < f20.length ; i ++){
 	    		  if(f20.charAt(i) == "-"){
 	    			  if( i != 0){
 	        			  ComShowCodeMessage('PRI07018',f20); 
 	        			  document.form.flat_percent_20_app.focus();	 	
 	        			  return false;
 	    			  }
 	    		  }
 	    		  
 	    		  if(f20.charAt(i) == "."){
 	    			  dot_count_20++
 	    		  }
 	    	  }
 	
 			  if(dot_count_20 > 1 ){
 				  ComShowCodeMessage('PRI07018',f20); 
 				  document.form.flat_percent_20_app.focus();	 	
 				  return false;
 			  }        
     		  
 	    	  var dot_count_40 = 0;
 	    	  var f40 = formObj.flat_percent_40_app.value ; 

 	    	  for(var i = 0 ; i < f40.length ; i ++){
 	    		  if(f40.charAt(i) == "-"){
 	    			  if( i != 0){
 	        			  ComShowCodeMessage('PRI07018',f40); 
 	        			  document.form.flat_percent_40_app.focus();	 	
 	        			  return false;
 	    			  }
 	    		  }else if(f40.charAt(i) == "."){
 	    			  dot_count_40++
 	    		  }
 	    	  }

     		  if(dot_count_40 > 1 ){
     			  ComShowCodeMessage('PRI07018',f40); 
     			  document.form.flat_percent_40_app.focus();	 	
     			  return false;
     		  }
     		  
     		  // 45' Cost 추가
   			var dot_count_45 = 0;
   			var f45 = formObj.flat_percent_45_app.value;
   			
 	    	if(dry_apply == true && document.form.menu_rhq_cd.value == "HAMRU") {
 	    		for(var i = 0 ; i < f45.length ; i ++){
 	    			if(f45.charAt(i) == "-"){
 	    				if( i != 0){
 	    					ComShowCodeMessage('PRI07018',f45);
 	    					document.form.flat_percent_45_app.focus();
 	    					return false;
 	    				}
 	    			}else if(f45.charAt(i) == "."){
 	    				dot_count_45++
 	    			}
 	    		}
 	    		
 	    		if(dot_count_45 > 1 ){
 	    			ComShowCodeMessage('PRI07018',f45);
 	    			document.form.flat_percent_45_app.focus();
 	    			return false;
 	    		}
 	    	}
            break;      
             
        case MODIFY01: // Tariff Tuning
        	// DR, RF  둘중에 하나는 체크 해야한다. 
        	if( formObj.cgoTpcd[0].checked == false && formObj.cgoTpcd[1].checked == false){
               	ComShowCodeMessage('COM12113'," Tariff Tuning type"); 
                return false;
        	}
        }
        return true;
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
        formObj.fdr_trf_no.value="";
        formObj.fdr_trf_no_view.value="";
        formObj.amdt_seq.value="";
        formObj.cre_dt.value="";
        formObj.eff_dt.value="";
        formObj.cfm_dt.value="";
        formObj.cfm_usr.value="";
        formObj.cre_usr.value="";
        formObj.fic_prop_sts_cd.value="";   
        formObj.fic_prop_sts_nm.value="";   
        formObj.svc_scp_cd.value = "";
		formObj.eff_dt.readOnly =  true;
		formObj.eff_dt.setAttribute("className","input2");
		document.getElementById("btn_dg_cgo_scg").style.color = "";
        sheetObjects[0].headCheck(0, "chk") = false;
        sheetObjects[0].headCheck(1, "chk") = false;
        sheetObjects[0].headCheck(2, "chk") = false;
        sheetObjects[1].RemoveAll();     
        //Apply data clear
        formObj.flat_percent_20_app.value="";   
        formObj.flat_percent_40_app.value="";   
        formObj.flat_percent_45_app.value="";	// 45' Cost 추가
        formObj.cgoTpcd[0].checked=false; 
        formObj.cgoTpcd[1].checked=false; 
        comboObjects[2].Index ="-1" ;   
        comboObjects[3].Index ="-1" ;
        comboObjects[4].Index ="-1" ;	// 45' Cost 추가
        //header setting	
     	sheetObjects[0].CellValue( 0 , "pnt_loc_cd") = "Destination" ;
     	sheetObjects[0].CellValue( 1 , "pnt_loc_cd") = "Destination" ;
     	sheetObjects[0].CellValue( 2 , "pnt_loc_cd") = "Destination" ;
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
     function clearAllgridForms(){   
         var formObj = document.form;        
         sheetObjects[0].headCheck(0, "chk") = false;
         sheetObjects[0].headCheck(1, "chk") = false;
         sheetObjects[0].headCheck(2, "chk") = false;
         sheetObjects[0].RemoveAll();     
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
 			ComBtnDisable("btn_dg_cgo_scg"); 
 			
 			ComBtnDisable("btn_apply"); 
 			ComBtnDisable("btn_gl_tuning"); 
 			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnDisable("btn_delete_down"); 
 			ComBtnDisable("btn_down_excel"); 	
 			ComBtnDisable("btn_load_excel"); 	
 			ComBtnDisable("btn_add_down"); 
 			break;
 			
 		case "INIT":	// Initial  & amdt seq = 0
 			ComBtnDisable("btn_amend"); 
 			ComBtnEnable("btn_cancel"); 
 			ComBtnEnable("btn_confirm"); 
 			ComBtnEnable("btn_dg_cgo_scg"); 
 			
 			ComBtnEnable("btn_apply"); 		
 			ComBtnEnable("btn_gl_tuning"); 
 			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnEnable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			ComBtnEnable("btn_load_excel"); 
 			ComBtnEnable("btn_add_down"); 
 			btnImgEnable(formObj.btn_calendar, true);
 			break;
 			
 		case "I":	// Initial  & amdt seq != 0    
 			ComBtnDisable("btn_amend"); 
 			ComBtnEnable("btn_cancel"); 
 			ComBtnEnable("btn_confirm"); 
 			ComBtnEnable("btn_dg_cgo_scg"); 
 			
 			ComBtnEnable("btn_apply"); 
 			ComBtnEnable("btn_gl_tuning"); 
 			ComBtnEnable("btn_amend_down");
 			ComBtnEnable("btn_cancel_down"); 
 			ComBtnEnable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			ComBtnDisable("btn_load_excel"); 	
 			ComBtnEnable("btn_add_down"); 
 			break;
 			
 		case "C":	// Initial  & amdt seq = 0
 			ComBtnDisable("btn_save");
 			ComBtnEnable("btn_amend"); 
 			ComBtnDisable("btn_cancel"); 
 			ComBtnDisable("btn_confirm"); 
 			ComBtnEnable("btn_dg_cgo_scg"); 
 			
 			ComBtnDisable("btn_apply"); 
 			ComBtnDisable("btn_gl_tuning"); 
			ComBtnDisable("btn_amend_down"); 
 			ComBtnDisable("btn_cancel_down"); 
 			ComBtnDisable("btn_delete_down"); 
 			ComBtnEnable("btn_down_excel"); 
 			ComBtnDisable("btn_load_excel"); 	
 			ComBtnDisable("btn_add_down"); 
 			break;
 		}
 	}
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
     * Add on DG 팝업 버튼의 색을 표시한다.
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} OldRow 필수, 이전에 선택된 셀의 Row Index
     * @param {int} OldCol 필수, 이전에 선택된 셀의 Column Index
     * @param {int} NewRow 필수, 현재 선택된 셀의 Row Index
     * @param {int} NewCol 필수, 현재 선택된 셀의 Column Index
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */         
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
    	sheetObj.WaitImageVisible = false; 
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
            
            //버튼 색 변경
            if(sheetObj.CellValue(sheetObj.SelectRow , "fdr_trf_no") != ""){ //Feeder 구간이 있는 조회 결과일 경우   
            	if(sheetObj.CellValue(sheetObj.SelectRow , "dcgo_svc_flg") == ""){ // 한번 조회해서 값이 있는 경우는 다시 조회하지 않는다.
            		//Add-on DG service Flag를 찾아오기 위하여 조회
    				var formObj = document.form;
    				var sheetObj = sheetObjects[0]    				
    				formObj.f_cmd.value = SEARCH02;	
    				
    				var sParam = "fdr_trf_no="+sheetObj.CellValue(sheetObj.SelectRow,"fdr_trf_no")
    				+ "&svc_scp_cd="+sheetObj.CellValue(sheetObj.SelectRow,"svc_scp_cd")
		            + "&org_dest_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow,"org_dest_tp_cd")
		            + "&rhq_cd="+ formObj.menu_rhq_cd.value
		            + "&pnt_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"pnt_loc_cd") 
		            + "&bse_port_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"bse_port_loc_cd") 
		            + "&" + FormQueryString(formObj) ; 
    				
    				var sXml = sheetObj.GetSearchXml("ESM_PRI_7003_01GS.do", sParam);//ESM_PRI_7003_01 이벤트를 공통으로 사용    					
    				var dcgoSvcFlg = ComPriXml2Array(sXml, "dcgo_svc_flg"); 
    				sheetObj.CellValue(sheetObj.SelectRow,"dcgo_svc_flg") = dcgoSvcFlg;
    				
            	} 				
				//버튼 색 변경
				if(sheetObj.CellValue(sheetObj.SelectRow , "dcgo_svc_flg") == "Y" ){
					if(sheetObj.CellValue(OldRow , "dcgo_svc_flg") != "Y"){
						document.getElementById("btn_dg_cgo_scg").style.color = "blue";
					}
				} else {
					document.getElementById("btn_dg_cgo_scg").style.color = "";	
				}    				
 			}else{
 				document.getElementById("btn_dg_cgo_scg").style.color = "";	
 			}    			
        }
        sheetObj.WaitImageVisible = true; 
    }

    /**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * Sheet의 해당 Sel을 클릭 시 메모장을 화면에 표시한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
     * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
     * @return 없음
     * @author 김대호
     * @version 2010.01.12
     */  	           
     function sheet1_OnClick(sheetObj, Row, Col, Value) {

       var colname = sheetObj.ColSaveName(Col);  	 
     	switch(colname) {
     		case "fdr_rt_rmk": 	
     			if(sheetObj.CellEditable( sheetObj.SelectRow , "gline_20ft_frt_rt_amt")){   
		       		ComShowMemoPad(sheetObj);
     			}else{
     				ComShowMemoPad(sheetObj, Row, Col, true);
     			}
		       	break;
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
	 * 선택된 Row에 대해 Amend or Amend Delete 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowAmend(sheetObj, sAction) {
		var idx = sheetObj.DataCopy();
		var prevIdx = idx - 1;
		
		sheetObj.CellValue2(idx, "eff_dt") = document.form.eff_dt.value;
		sheetObj.CellValue2(idx, "n1st_cmnc_amdt_seq") = document.form.amdt_seq.value;
		sheetObj.CellValue2(idx, "src_info_cd") = sAction;
		if (sAction == "AM") {
			sheetObj.CellValue2(idx, "src_info_cd") = "AM";
		} else if (sAction == "AD") {
			sheetObj.CellValue2(idx, "src_info_cd") = "AD";
		}

		sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value-1;
		
		sheetObj.CellValue2(prevIdx, "exp_dt") = ComGetDateAdd(sheetObj.CellValue(idx,"eff_dt"), "D", -1);  
		sheetObj.RowStatus(prevIdx) = "R";
		sheetObj.RowStatus(idx) = "U";
		return idx;
    }
    
	/**
	 * 선택된 Row에 대해 Amend Cancel 실행.
	 * 팝업화면에서도 이 함수를 호출하여 사용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function doRowAmendCancel(sheetObj) {
    	var idx  = sheetObj.SelectRow;
		var prevIdx = idx - 1;
		
		if (sheetObj.CellValue(idx, "ibflag") != "I") {
			sheetObj.CellValue2(prevIdx, "exp_dt") = sheetObj.CellValue(idx, "exp_dt");
			sheetObj.CellValue2(prevIdx, "amdt_seq") = document.form.amdt_seq.value;
			// 이 부분은 Amend와 Amend Cancel을 반복할 경우, 저장이 안되는 경우를 위한 코드.
			// 이는 IBSheet에서 Amend Cancel시  다시 원복된 값이 조회당시 값과 같다고 인식해서 row의 status를 R로 인식하는 문제. 
			if (sheetObj.CellSearchValue(idx, "amdt_seq") != unescape("%00")) {
				sheetObj.RowStatus(prevIdx) = "U";
			}
		}
		sheetObj.RowDelete(idx, false);		
		return prevIdx;
    }
    
	/**
	 * 특정 row, 또는 Sheet전체에 대해 setLineStyle, setLineEnable함수를 호출하여
	 * 라인의 스타일(폰트색상, 취소선 등)을 만들어준다.
	 * setLineStyle은 메인화면의 함수를 팝업들이 공통적으로 같이 이용하며,
	 * setLineEnable은 각 화면이나 팝업별로 따로 구현되어 있다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setSheet3Style(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
            	setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
    
	/**
	 * 주어진 로우에 대해 스타일(색상, 취소선 등)을 적용한다.
	 *  
	 * @return 없음
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineStyle(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.RowStatus(idx) == "D") {
    		sheetObj.RowHidden(idx) = true;
    	}
    	
    	// Proposal단계 일 경우 색상처리를 하지 않는다.
    	if (document.form.amdt_seq.value == "0") {
    		return true;
    	}
    	
    	// 이전Seq의 데이터는 Amend된 데이터로 간주하고, 취소선을 긋고, Row를 수정불가로 한다.
    	// 다만 RFA는 RowEditable메쏘드를 이용해 전체 Row를 Uneditable로 처리하고,
    	// S/C의 경우는 Note쪽에서 Conversion화면을 띠워야 하므로 루프를 돌면서 컬럼단위로 Uneditable 처리한다.
    	if (sheetObj.CellValue(idx, "amdt_seq") != document.form.amdt_seq.value) {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
			sheetObj.RowEditable(idx) = false;
			
			return true;
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
			sheetObj.RowEditable(idx) = true;
    	}
    	
    	// 이번 회차의 데이타(Insert or Amend)는 font-color를 red로 표시.
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value) {
			sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
    	} else {
    		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
    	}
    	
    	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
    	changeSelectBackColor4Rate(sheetObj);
    }
    
	/**
	 * Sheet에서 조회 후, Row별 각 컬럼이나 전체 Row의 Enable/Disable을 처리.
	 * 이 함수는 Sheet3(Rate)를 위한 것이고, 각 팝업마다 같은 이름의 함수들이 각 sheet에 맞게 정의되어 있다.
	 * 
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} idx 선택 지정하면 해당 Row 만 처리, 지정하지 않으면 모든 데이터 처리.
	 * @author 박성수
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.fic_prop_sts_cd.value == "I"
    		&& sheetObj.CellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.CellEditable(idx, "gline_20ft_frt_rt_amt") = true;
	        	sheetObj.CellEditable(idx, "gline_40ft_frt_rt_amt") = true;
	        	
	        	// EUR일 경우만 45' Cost 수정 가능
				if(document.form.menu_rhq_cd.value == "HAMRU"){
					sheetObj.CellEditable(idx, "gline_45ft_frt_rt_amt") = true;	// 45' Cost 추가
				}
	        	sheetObj.CellEditable(idx, "rc_svc_flg") = true;
	        	
				if(sheetObj.CellValue(idx, "rc_svc_flg" )== "N"){
					sheetObj.CellEditable(idx, "gline_rf_20ft_frt_rt_amt") = false;   
					sheetObj.CellEditable(idx, "gline_rf_40ft_frt_rt_amt") = false;   
				}else{
					sheetObj.CellEditable(idx, "gline_rf_20ft_frt_rt_amt") = true;   
					sheetObj.CellEditable(idx, "gline_rf_40ft_frt_rt_amt") = true;   
				}
		} else {
        	sheetObj.CellEditable(idx, "gline_20ft_frt_rt_amt") = false;
        	sheetObj.CellEditable(idx, "gline_40ft_frt_rt_amt") = false;
        	sheetObj.CellEditable(idx, "gline_45ft_frt_rt_amt") = false;	// 45' Cost 추가
        	sheetObj.CellEditable(idx, "gline_rf_20ft_frt_rt_amt") = false;
        	sheetObj.CellEditable(idx, "gline_rf_40ft_frt_rt_amt") = false;
        	sheetObj.CellEditable(idx, "rc_svc_flg") = false;
		}
    	
    	if(document.form.fic_prop_sts_cd.value == "C"){
    		sheetObj.RowEditable(idx) = false;
    	}else{
    		sheetObj.RowEditable(idx) = true;
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
	function svc_scp_combo_OnChange(comboObj, code, text) {
		var formObj = document.form;
			
		if (sheetObjects[0].IsDataModified || sheetObjects[1].IsDataModified) {
			if (ComShowCodeConfirm("PRI00006")) { 
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
			}
		}
	}
	
	   /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {int} Row 필수, OnChange 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, OnChange 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 서미진
     * @version 2012.07.11
     */
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {
    	var formObj = document.form;
        var colname = sheetObj.ColSaveName(Col);
        var etc4 = comboObjects[0].Code;	//	ORG_DEST_TP_CD
        switch(colname)
        {
            case "rc_svc_flg":
                if (Value == "N") {
                    sheetObj.CellValue(Row, "gline_rf_20ft_frt_rt_amt") = "";
                    sheetObj.CellValue(Row, "gline_rf_40ft_frt_rt_amt") = "";
					sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = false;   
					sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = false;   
                } else {
					sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = true;   
					sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = true;                   	
                }
                break;
                
            case "gline_rf_20ft_frt_rt_amt":
                if (Value == "" && sheetObj.CellValue(Row, "gline_rf_40ft_frt_rt_amt") == "" ) {
					sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = false;   
					sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = false;        
					sheetObj.CellValue(Row, "rc_svc_flg") = 'N';                	
                }
                break;
                
            case "gline_rf_40ft_frt_rt_amt":
                if (Value == "" && sheetObj.CellValue(Row, "gline_rf_20ft_frt_rt_amt") == "" ) {
					sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = false;   
					sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = false;        
					sheetObj.CellValue(Row, "rc_svc_flg") = 'N';                	
                }
                break;
                
            case "pnt_loc_cd":
            	if(Value != '') {
    				formObj.f_cmd.value = SEARCH05;                   
    				var param = "&f_cmd=" + formObj.f_cmd.value + "&cd=" + Value + "&nm=rpscp&etc4=" + etc4 
    				             + "&svc_scp_cd=" + formObj.svc_scp_cd.value;
    				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", param);
			        var arrData = ComPriXml2Array(sXml, "cd");   
			        if(arrData == undefined){
			        	sheetObj.CellValue2(Row, Col) = '';
			        }    							
    			}
                break;
                
            case "bse_port_loc_cd":
            	if(Value != '') {
    				formObj.f_cmd.value = SEARCH05;
    				var param = "&f_cmd=" + formObj.f_cmd.value + "&cd=" + Value + "&nm=rpscp&etc4=" + etc4 
    					 	 	 + "&svc_scp_cd=" + formObj.svc_scp_cd.value;
    				var sXml = sheetObj.GetSearchXml("PRICommonGS.do", param);
			        var arrData = ComPriXml2Array(sXml, "cd");   
			        if(arrData == undefined){
			        	sheetObj.CellValue2(Row, Col) = '';
			        }    	
            	}
                break;
                
            // EUR이 아닐 경우 40'와 45'는 동일하게 조회 된다 
            case "gline_40ft_frt_rt_amt" :
            	if(Value != '' && document.form.menu_rhq_cd.value != "HAMRU") {
            		sheetObj.CellValue(Row, "gline_45ft_frt_rt_amt") = sheetObj.CellValue(Row, "gline_40ft_frt_rt_amt");
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
		formObj.f_cmd.value = SEARCH25;
		formObj.cd.value = comboObjects[5].Code;  // RHQ_CD
		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.svc_scp_combo, "cd", "cd|nm");    
		formObj.svc_scp_combo.focus();
	}

    /**
     * OnKeyDown event를 처리한다. <br>
     * @author 서미진
     * @version 2012.10.18
     */  
 	function obj_keydown(){
 	 	var eleName = event.srcElement.name;
 	 	
 	 	if (eleName == "svc_scp_combo"){
 		 	var keyValue = null;
 			if(event == undefined || event == null) {
 		    	keyValue = 13;
 			}else{
 		    	keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 		  	}
 		   	if (keyValue == 13){
 		   		if(comboObjects[1].Code !="" ){	    		 
 		   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		   		}
 		  	}
 		}
 	}

	function clearTooltip() {
        var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows + sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                	// Dry tariff 의 상태로 back color 조정 
                	if(!sheetObjects[0].CellEditable(i, "gline_20ft_frt_rt_amt")){ 
                		sheetObj.CellBackColor(i, j) = sheetObj.UnEditableColor;
                	}else{
                		sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                	}
                	// 처음 load 시의 컬러로 font color 셋팅 ( 기준 컬러 ; dry tariff )
                    sheetObj.CellFontColor(i, j) = sheetObj.RgbColor(sheetObj.CellFontColor(i, "gline_20ft_frt_rt_amt"),0,0);
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }
	
	function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];
        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        sheetObj.ToolTipText(row, col) +="\n- " +  msg;
        // amnd 상태에서 add 한 row 인 경우 font color = black 으로 셋팅
        sheetObj.CellFontColor(row, col) = sheetObj.RgbColor(0,0,0);
    }