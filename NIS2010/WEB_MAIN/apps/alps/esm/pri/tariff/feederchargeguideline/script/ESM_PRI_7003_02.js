/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7003_02.js
*@FileTitle : Feeder/IHC Tariff Inquiry - Reefer Tab 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation 
=========================================================
* History                       
* 2013.02.13 [CHM-201322993] 전윤주 ADD ON TARIFF Feeder Remark 컬럼 추가                              
* 2013.07.30 [CHM-201326002] 전윤주 Over weight, DG service flag가 'Y' 인 경우 버튼 파란색으로 표시        
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
     * @class ESM_PRI_7003_02 : ESM_PRI_7003_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7003_02() {
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
            	open_dg_cgo_scg();
                break; 
                
            case "btn_ihc_ovr_cgo": 			
            	open_ihc_ovr_cgo();
                break; 
               
    		case "btn_down_excel":
    			doActionIBSheet(sheetObjects[0], document.form, IBDOWNEXCEL);
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
        initControl();    
        formObj.ihc_cgo_tp_cd.value = "RF";
    	parent.loadTabPage(); 
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
            case SEARCH01:   // retrieve sheet 
//            	ComOpenWait(true); //->waiting->start
	 			formObj.f_cmd.value = SEARCH01;	 		
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7003_02GS.do", FormQueryString(formObj));	 	 	 
	 			sheetObj.LoadSearchXml(sXml);	
//	 			ComOpenWait(false); //->waiting->End
                break; 
                
    		case IBDOWNEXCEL :
    			sheetObj.Down2Excel(-1, true, true);
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
                 style.height = 400;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;              

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]  
                 InitRowInfo( 3, 1, 20, 100);
     
                 var HeadTitle1 = "|Seq.|Point|LOC\nGroup|Description|Hub|VIA|Base\nPort|Trans\nMode|Term|Tariff(USD)|Tariff(USD)|SVC Type|IHC\nEFF Date|Add-on\nEFF Date|Remarks|SVC_SCP_CD|FDR_TRF_NO|IHC_TRF_NO|ORG_DEST_TP_CD|RHQ_CD|OVR_WGT_CGO_SVC_FLG|DCGO_SVC_FLG";
     			 var HeadTitle2 = "|Seq.|Point|LOC\nGroup|Description|Hub|VIA|Base\nPort|Trans\nMode|Term|RF|RF|SVC Type|IHC\nEFF Date|Add-on\nEFF Date|Remarks|SVC_SCP_CD|FDR_TRF_NO|IHC_TRF_NO|ORG_DEST_TP_CD|RHQ_CD|OVR_WGT_CGO_SVC_FLG|DCGO_SVC_FLG";
     			 var HeadTitle3 = "|Seq.|Point|LOC\nGroup|Description|Hub|VIA|Base\nPort|Trans\nMode|Term|20'|40'|SVC Type|IHC\nEFF Date|Add-on\nEFF Date|Remarks|SVC_SCP_CD|FDR_TRF_NO|IHC_TRF_NO|ORG_DEST_TP_CD|RHQ_CD|OVR_WGT_CGO_SVC_FLG|DCGO_SVC_FLG";

                 var headCount = ComCountHeadTitle(HeadTitle1);
 			
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0 , 0, true);
 		
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false, false);           
 	
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  
                 InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
 				 InitHeadRow(1, HeadTitle2, true);  
                 InitHeadRow(2, HeadTitle3, false);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter,	true, "ibflag");
     			InitDataProperty(0, cnt++, dtSeq, 			40, daCenter, 	true);
     			InitDataProperty(0, cnt++, dtData, 			55, daCenter, 	true, "pnt_loc_cd", 				false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "ihc_cost_loc_grp_no", 		false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			145, daLeft, 	true, "pnt_loc_cd_nm", 				false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			55, daCenter, 	true, "hub_loc_cd", 				false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			55, daCenter, 	true, "via", 						false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			55, daCenter, 	true, "bse_port_loc_cd", 			false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	true, "prc_trsp_mod_cd_nm", 		false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			60, daCenter, 	true, "rcv_de_term_cd_nm", 			false, "", dfNone, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_rf_20ft_frt_rt_amt", 	false, "", dfNone, 2, false, false);
     			InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_rf_40ft_frt_rt_amt", 	false, "", dfNone, 2, false, false);
     			InitDataProperty(0, cnt++, dtCombo, 		65, daCenter, 	true, "svc_tp_cd",	 				false, "", dfNone, 0, false, false);
    			InitDataProperty(0, cnt++, dtData, 		    70, daCenter, 	true, "ihc_eff_dt",	 				false, "", dfDateYmd, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 		    70, daCenter, 	true, "fdr_eff_dt",	 				false, "", dfDateYmd, 0, false, false);
     			InitDataProperty(0, cnt++, dtData, 			100,daLeft,		true, "fdr_rt_rmk",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, 	true, "svc_scp_cd",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, 	true, "fdr_trf_no",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, 	true, "ihc_trf_no",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, 	true, "org_dest_tp_cd",             false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 	   100, daCenter, 	true, "rhq_cd",                     false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, dtHidden, 		70, daCenter, 	true, "ovr_wgt_cgo_svc_flg",        false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden, 		70, daCenter, 	true, "dcgo_svc_flg",        false, "", dfNone, 0, false, false);
                
     			InitDataCombo(0, "svc_tp_cd", 'Add-on|IHC|Combined'    , '1|2|3');
     			sheetObjects[0].HeadRowHeight = 20;
     		}
             break;
            
        case "sheet2":
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
    
				var HeadTitle1 = "ibflag|Seq|SVC_SCP_CD|IHC_TRF_NO|AMDT_SEQ|EFF_DT|COST_TRF_NO|SPCL_COUNT";

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
                InitDataProperty(0, cnt++, 	dtData, 				100, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"cost_trf_no", false, "", dfNone, 0, false, false);       
                InitDataProperty(0, cnt++, 	dtData, 				70, 		daCenter, 	true, 	"spcl_count", false, "", dfNone, 0, false, false);       
                WaitImageVisible = false;  
                Ellipsis = true;
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
            if (comboObjects[0].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"input","Service Scope"); 
            	formObj.svc_scp_combo.focus();
                return false;
            }         
            break;
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
        var formObject = document.form;     
		formObject.svc_scp_cd.value = "";
		formObject.org_dest_tp_cd.value = "";
		formObject.acc_dt.value = "";
		formObject.pnt_loc_cd.value = "";
		formObject.bse_port_loc_cd.value = "";
		formObject.svc_tp_cd.value = "";
        sheetObjects[0].RemoveAll();      
        ComBtnEnable("btn_dg_cgo_scg");
        ComBtnEnable("btn_ihc_ovr_cgo");
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
    	sheetObj.WaitImageVisible = false;  
        if (OldRow != NewRow) {
    			if(sheetObj.CellValue( sheetObj.SelectRow , "fdr_trf_no") != ""){//Feeder 구간이 있는 조회 결과일 경우 
    				if(sheetObj.CellValue(sheetObj.SelectRow , "dcgo_svc_flg") == ""){ // 한번 조회해서 값이 있는 경우는 다시 조회하지 않는다.
    					//Add-on DG service Flag를 찾아오기 위하여 조회
	    				var formObj = document.form;
	    				var sheetObj = sheetObjects[0]    				
	    				formObj.f_cmd.value = SEARCH02;	    				
//	    				document.getElementById("btn_dg_cgo_scg").style.color = ""; 
	    				
	    				if(sheetObj.CellValue(sheetObj.SelectRow , "svc_tp_cd") == "1"){ // Add-on 만 있는 경우
		    				var sParam = "fdr_trf_no="+sheetObj.CellValue(sheetObj.SelectRow,"fdr_trf_no")
		    				            + "&org_dest_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow,"org_dest_tp_cd")
		    				            + "&rhq_cd="+sheetObj.CellValue(sheetObj.SelectRow,"rhq_cd") 
		    				            + "&pnt_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"pnt_loc_cd") 
		    				            + "&bse_port_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"bse_port_loc_cd") 
		    				            + "&" + FormQueryString(formObj) ; 
	    				} else if (sheetObj.CellValue(sheetObj.SelectRow , "svc_tp_cd") == "3") {//combine 이면 VIA가 Add on의 Point Location 이다.
	    					var sParam = "fdr_trf_no="+sheetObj.CellValue(sheetObj.SelectRow,"fdr_trf_no")
							            + "&org_dest_tp_cd="+sheetObj.CellValue(sheetObj.SelectRow,"org_dest_tp_cd")
							            + "&rhq_cd="+sheetObj.CellValue(sheetObj.SelectRow,"rhq_cd") 
							            + "&pnt_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"via") 
							            + "&bse_port_loc_cd="+sheetObj.CellValue(sheetObj.SelectRow,"bse_port_loc_cd") 
							            + "&" + FormQueryString(formObj) ; 
    					}
	    				
	    				var sXml = sheetObj.GetSearchXml("ESM_PRI_7003_01GS.do", sParam);	    					
	    				var dcgoSvcFlg = ComPriXml2Array(sXml, "dcgo_svc_flg"); 
	    				sheetObj.CellValue(sheetObj.SelectRow,"dcgo_svc_flg") = dcgoSvcFlg;
    				}    					
    				//버튼 enable
    				ComBtnEnable("btn_dg_cgo_scg");    				
    				//버튼 색 변경
    				if(sheetObj.CellValue(sheetObj.SelectRow , "dcgo_svc_flg") == "Y" ){
    					if(sheetObj.CellValue(OldRow , "dcgo_svc_flg") != "Y"){
    						document.getElementById("btn_dg_cgo_scg").style.color = "blue";
    					}
    				} else {
    					document.getElementById("btn_dg_cgo_scg").style.color = "";	
    				}   
     			}else{
     				ComBtnDisable("btn_dg_cgo_scg"); 
     				document.getElementById("btn_dg_cgo_scg").style.color = "";
     			}
    			
    			if(sheetObj.CellValue( sheetObj.SelectRow , "ihc_trf_no") != ""){   
    				//버튼 enable
    				ComBtnEnable("btn_ihc_ovr_cgo");
    				//버튼 색 변경
    				if(sheetObj.CellValue(sheetObj.SelectRow , "ovr_wgt_cgo_svc_flg") == "Y" ){
    					document.getElementById("btn_ihc_ovr_cgo").style.color = "blue";
    				} else {
    					document.getElementById("btn_ihc_ovr_cgo").style.color = "";	
    				}  				
     			}else{
     				ComBtnDisable("btn_ihc_ovr_cgo"); 
     				document.getElementById("btn_ihc_ovr_cgo").style.color = "";
     			}
        }
        sheetObj.WaitImageVisible = true;  
    }
	
 	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo 필수 prop_no 값
     * @param {string} sAmdtSeq 필수 amdt_seq 값
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sPreAmdtSeq 필수 pre_amdt_seq 값
     * @param {string} sPropStsCd 필수 pro_sts_cd 값
     * @param {string} sEffDt 필수 eff_dt 값
     * @param {string} sExpDt 필수 exp_dt 값
     * @param {string} sPreExpDt 필수 pre_exp_dt 값
     * @return 없음
     * @author 최성민
     * @version 2009.05.21
     */ 
	function tabLoadSheet(sSvcScpCd, sOrgDestTpCd, sAccDt, sPntLocCd, sBsePortLocCd, sSvcTpCd) {
		var formObject = document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.org_dest_tp_cd.value != sOrgDestTpCd || formObject.acc_dt.value != sAccDt 
		  || formObject.pnt_loc_cd.value != sPntLocCd || formObject.bse_port_loc_cd.value != sBsePortLocCd || formObject.svc_tp_cd.value != sSvcTpCd ) {
			formObject.svc_scp_cd.value = sSvcScpCd ;
			formObject.org_dest_tp_cd.value = sOrgDestTpCd ;
			formObject.acc_dt.value = sAccDt ; 
			formObject.pnt_loc_cd.value = sPntLocCd ;
			formObject.bse_port_loc_cd.value = sBsePortLocCd ;
			formObject.svc_tp_cd.value = sSvcTpCd;
			sheetObjects[0].RemoveAll();      
			doActionIBSheet(sheetObjects[0], document.form,SEARCH01);
		}
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
     			ComShowMemoPad(sheetObj, Row, Col, true);
     			
		break;
     	}    	 

    }

	/*
	 * dg_cgo_scg POP-UP OPEN
	 */
	function open_dg_cgo_scg(){
		if(sheetObjects[0].RowCount("R") > 0){
			var sParam = "svcScpCd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd")
				 	       + "&fdrTrfNo=" 		+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "fdr_trf_no")
				 	       + "&org_dest_tp_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd")
						   + "&rhq_cd="        + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "rhq_cd");
			var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7028.do?"+ sParam,	900, 500, '', "1,0,1,1,1,1,1", true);
		}
	}
	
	/* 
	 * ihc_ovr_cgo POP-UP OPEN
	 */
	function open_ihc_ovr_cgo(){
		if(sheetObjects[0].RowCount("R") > 0){
			var sParam = "svcScpCd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd")
						+ "&ihcTrfNo=" 		+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ihc_trf_no")
						+ "&org_dest_tp_cd=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd")
						+ "&opn="	            +  "7003";
			var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7024.do?"+ sParam,	500, 500, '', "1,0,1,1,1,1,1", true);
		}
	}