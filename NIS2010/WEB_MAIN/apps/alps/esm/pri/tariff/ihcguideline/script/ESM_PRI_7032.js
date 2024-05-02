/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7032.js
*@FileTitle : Inland add-on amendment history
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.16
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.16 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
* History                                                 
* 2013.04.29 전윤주 [CHM-201324375] Inland Tariff 기능 병합 (amend type 추가)                                                    
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
     * @class ESM_PRI_7032 : ESM_PRI_7032 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7032() {
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
    
    var first_eff_dt ="";
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
            	var parameter = FormQueryString(document.form);
            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7027.do?"+ parameter,565, 400, 'getCountry', "1,0,1,1,1,1,1", true);        
                break;  

            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
                break;
                
            case "btn_new":
                doActionIBSheet(sheetObjects[0],document.form,IBCREATE);                
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
    	// Country code 조회 
    	doActionIBSheet(sheetObjects[0],document.form,SEARCH04);
    	initControl();    
        formObj.cost_cnt_cd.focus();
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
//        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
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
	function cost_cnt_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
		if(comboObjects[1].Code != ""){
 			comboObjects[2].RemoveAll();   
 			comboObjects[3].RemoveAll(); 		
 			formObj.amdt_seq.value = "";
    		formObj.f_cmd.value = SEARCH25;
    		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
    		formObj.etc2.value = comboObjects[1].Code;	//	CNT_CD
    		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");     
    	    formObj.svc_scp_cd.focus();  
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
            case SEARCH01:   // tariff no combo
            	ComOpenWait(true); //->waiting->start
	 			formObj.f_cmd.value = SEARCH01;	 			
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7032GS.do", FormQueryString(formObj));	 	 	
	 			sheetObjects[1].LoadSearchXml(sXml);	
 				ComPriXml2ComboItem(sXml, formObj.ihc_trf_no, "cd", "nm");
	 			ComOpenWait(false); //->waiting->End
 				if(comboObjects[3].GetCount() == 0){
	 				ComShowCodeMessage('PRI07003'); 
	 				formObj.svc_scp_cd.focus();
	 			}else{
	 				formObj.ihc_trf_no.focus();
	 			}
                break;   
                
            case SEARCH02:   // amend seq.
                if (!validateForm(sheetObjects[0],document.form,sAction)) {
                    return false;
                }     
            	ComOpenWait(true); //->waiting->start
	 			formObj.f_cmd.value = SEARCH02;	 		
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7032GS.do", FormQueryString(formObj));	 
	 			sheetObjects[1].LoadSearchXml(sXml);	
	 			
 		 		if (ComGetEtcData(sXml,"ihc_trf_no")  != undefined){
 		 			formObj.amdt_seq.value = ComGetEtcData(sXml,"amdt_seq");
 		 		}
 		 		
 		 		if(formObj.amdt_seq.value != ""){
 		 			 doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
 		 		}		 		
	 			ComOpenWait(false); //->waiting->End
                break;  
                
            case SEARCH03:   // main
            	ComOpenWait(true); //->waiting->start
            	sheetObjects[0].RemoveAll();      
            	sheetObjects[1].RemoveAll();      
	 			formObj.f_cmd.value = SEARCH03;	 		
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7032GS.do", FormQueryString(formObj));	 	 
	 			sheetObj.LoadSearchXml(sXml);	
	 			ComOpenWait(false); //->waiting->End
                break;  
                
            case SEARCH04:  // Country combo    
        		var formObj = document.form;
        		formObj.f_cmd.value = SEARCH28;
        		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
        		ComPriXml2ComboItem(sXml, formObj.cost_cnt_cd, "cd", "cd|nm");
        		break;
                
            case IBCREATE: 	// New
            	ComOpenWait(true); //->waiting->start
            	document.form.cost_cnt_cd.value = "";
                sheetObjects[0].RemoveAll();      
            	formObj.reset();
     			comboObjects[0].Index = 0;
     			comboObjects[1].Index = -1;
     			comboObjects[2].RemoveAll();    
     			comboObjects[3].RemoveAll();    
     			clearAllTabPages();         
                ComOpenWait(false); //->waiting->End
                document.form.cost_cnt_cd.focus();
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
                InitRowInfo(2, 1, 7, 100);

				var HeadTitle1 = "|Seq.|AMD|AMD|Tariff No.|Tariff No.|Effective Date|Expiry Date|Creation Date|Creation Staff/Team|Confirm Date|Confirm Staff/Team|Publish Date|Publish Staff/Team|SVC_SCP_CD|ORG_DEST_TP_CD";
				var HeadTitle2 = "|Seq.|No.|Type|Tariff No.|Tariff No.|Effective Date|Expiry Date|Creation Date|Creation Staff/Team|Confirm Date|Confirm Staff/Team|Publish Date|Publish Staff/Team|SVC_SCP_CD|ORG_DEST_TP_CD";
                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]                        
                InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true, "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq,	   40, daCenter, true, "seq");
                InitDataProperty(0, cnt++, dtData,		   40, daCenter, true, "amdt_seq",  		   false, "", dfNone,	 0, false, false);
                InitDataProperty(0, cnt++, dtData,		   40, daCenter, true, "ihc_trf_amdt_tp_cd",   false, "", dfNone,	 0, false, false);
                InitDataProperty(0, cnt++, dtData,		  150, daCenter, true, "ihc_trf_no_format",    false, "", dfNone,    0, false, false);
                InitDataProperty(0, cnt++, dtHidden,	  100, daCenter, true, "ihc_trf_no", 	       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,		  100, daCenter, true, "eff_dt",	    	   false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		  100, daCenter, true, "exp_dt",	           false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		  100, daCenter, true, "cre_dt",	    	   false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		  150, daCenter, true, "cre_usr",	           false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtData,		  100, daCenter, true, "cfm_dt",		       false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		  150, daCenter, true, "cfm_usr",		       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden,      100, daCenter, true, "pub_dt",		       false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,      150, daCenter, true, "pub_usr",		       false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	  100, daCenter, true, "svc_scp_cd",           false, "", dfNone,    0, false, false); 
				InitDataProperty(0, cnt++, dtHidden,	   50, daCenter, true, "org_dest_tp_cd",	   false, "", dfNone,    0, false, false);
				CountPosition = 0;		// Total 없음.
				WaitImageVisible = false;
			}
            break;
            
        case "sheet3":     // for session !!! 
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
                InitRowInfo(1, 1, 7, 100);

				var HeadTitle1 = "|Seq.|AMD|AMD|Tariff No.|Tariff No.|Effective Date|Expiry Date|Creation Date|Creation Staff/Team|Confirm Date|Confirm Staff/Team|Publish Date|Publish Staff/Team|SVC_SCP_CD";
				var HeadTitle2 = "|Seq.|No.|Type|Tariff No.|Tariff No.|Effective Date|Expiry Date|Creation Date|Creation Staff/Team|Confirm Date|Confirm Staff/Team|Publish Date|Publish Staff/Team|SVC_SCP_CD";

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]                        
                InitDataProperty(0, cnt++, dtHiddenStatus,  40, daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq,		40, daCenter, true,  "seq");
                InitDataProperty(0, cnt++, dtData,		    80,	daCenter, true,  "amdt_seq",  			false, "", dfNone,	  0, false, false);
                InitDataProperty(0, cnt++, dtData,		    50, daCenter, true,  "ihc_trf_amdt_tp_cd",  false, "", dfNone,	  0, false, false);
                InitDataProperty(0, cnt++, dtData,		   150, daCenter, true, "ihc_trf_no_format", 	false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,	   100, daCenter, true, "ihc_trf_no", 	        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   100, daCenter, true, "eff_dt",	    	    false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   100, daCenter, true, "exp_dt",	            false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   100, daCenter, true, "cre_dt",	    	    false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   150, daCenter, true, "cre_usr",	            false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   100, daCenter, true, "cfm_dt",		        false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		   150, daCenter, true, "cfm_usr",		        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,       100, daCenter, true,  "pub_dt",		        false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,       150, daCenter, true,  "pub_usr",		        false, "", dfNone,    0, false, false);
				InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, true,  "svc_scp_cd",          false, "", dfNone, 0, false, false); 
				WaitImageVisible = false;
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
	 		case "svc_scp_cd":                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
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
	 			
	 		case "ihc_trf_no":                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;     
	 				MaxLength = 3;
	 				UseAutoComplete = true;           
//	 				ValidChar(2,0);
	 			}                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	 			break; 
	 			
	 		case "cost_cnt_cd":                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	 			with (comboObj) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
	 				DropHeight = 200;                                                                                                                                                                                                                                                                                                                                                                                                                           
	 				MultiSelect = false;                                                                                                                                                                                                                                                                                                                                                                                                                        
	 				MaxSelect = 1;     
	 				MaxLength = 3;
	 				UseAutoComplete = true;           
	 				ValidChar(2,0);
	 				SetColWidth("50|150");
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
        case SEARCH02: // 조회    
            if (comboObjects[2].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"input","Service Scope"); 
            	formObj.svc_scp_cd.focus();
                return false;
            }
        	
            if (comboObjects[1].Code == "") {
            	ComShowCodeMessage('PRI00308',"input","Country");            
            	formObj.cost_cnt_cd.focus();
                return false;
            }   
            
            if (comboObjects[3].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"select","Tariff No"); 
            	formObj.ihc_trf_no.focus();
                return false;
            }
            break;
        }
        return true;
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
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
     * Amend Row의 Highlight 색상을 다르게 표시한다. <br>
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
    	 if (OldRow != NewRow) {	
		       clearAllTabPages();         
		       loadTabPage(tabObjects[0].SelectedIndex);
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
	function svc_scp_cd_OnChange(comboObj, code, text) {
		var formObj = document.form;
        var arrText = text.split("|");
        if (arrText != null && arrText.length > 1) {   
			formObj.ihc_trf_no.focus();	
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
				sUrl = "ESM_PRI_7032_01.do";
				break;
			case 1:
				sUrl = "ESM_PRI_7032_02.do";
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
        var sOrgDestTpCd = sheetObj1.CellValue( sRow ,"org_dest_tp_cd");

        if (sRow != -1 && sSvcScpCd != null && sSvcScpCd != "" && sIhcTrfNo != null && sIhcTrfNo != "" && sAmdtSeq != null && sAmdtSeq != ""  
        	&& sOrgDestTpCd != null && sOrgDestTpCd != "") {	
        		document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow.tabLoadSheet(sIhcTrfNo, sAmdtSeq, sSvcScpCd, sOrgDestTpCd);
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
             if (document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms) {
                 document.getElementById("t" + (i + 1) + "frame").contentWindow.clearAllForms();
             }
         }
     }
     
	/**
	 * 포커스를 잃을 때 이벤트가 발생하는 이벤트이다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *  
	 * </pre>
	 * @param   {IBMultiCombo} comboObj 필수 IBMultiCombo Object
	 * @return 없음
	 * @author 서미진
	 * @version 2010.10.13
	 */   	
	function svc_scp_cd_OnBlur(comboObj) {
		var formObj = document.form; 		
		var code = comboObj.FindIndex(comboObj.Code, 0);
		
		if (code != null && code != "") {
			formObj.amdt_seq.value = "";
			var text = comboObj.GetText(code, 1);
			comboObjects[3].RemoveAll();
			if (text != null && text != "") {
				doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
			}
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
		if(comboObjects[1].Code != ""){
 			formObj.amdt_seq.value = "";
 			comboObjects[3].RemoveAll();   
    		formObj.f_cmd.value = SEARCH25;
    		formObj.cd.value = comboObjects[3].Code;     // RHQ_CD
    		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
    		formObj.etc2.value = comboObjects[1].Code;	//	CNT_CD
    		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
    		ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm");     
    		formObj.svc_scp_cd.focus(); 	
		}else{
    	    formObj.cost_cnt_cd.focus(); 	
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
   	var svc_scp_cd = comboObjects[2].Code;
   	if (svc_scp_cd == "TAW" || svc_scp_cd == "TAE" || svc_scp_cd == "ASW" || svc_scp_cd == "ASE"){
       	sheetObjects[0].ColHidden("cfm_dt") = true;
       	sheetObjects[0].ColHidden("cfm_usr")= true;
       	sheetObjects[0].ColHidden("pub_dt") = false;
       	sheetObjects[0].ColHidden("pub_usr")= false;
   	} else {
   		sheetObjects[0].ColHidden("cfm_dt") = false;
       	sheetObjects[0].ColHidden("cfm_usr")= false;
       	sheetObjects[0].ColHidden("pub_dt") = true;
       	sheetObjects[0].ColHidden("pub_usr")= true;
   	}
   }