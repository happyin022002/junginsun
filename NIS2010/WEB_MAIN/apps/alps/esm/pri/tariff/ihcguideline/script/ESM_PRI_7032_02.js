/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7025_02.js
*@FileTitle : IHC Tariff Amendment History - Reefer Tab 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.30
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.07 SEO MI JIN
* 1.0 Creation 
=========================================================
* History                                                   
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
     * @class ESM_PRI_7025_02 : ESM_PRI_7025_02 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7025_02() {
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

            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
                break;         
                
    		case "cgoTpcd" :
    			showColumn(sheetObjects[0], window.event.srcElement);
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
            	ComOpenWait(true); //->waiting->start
	 			formObj.f_cmd.value = SEARCH01;	 		
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7025_02GS.do", FormQueryString(formObj));	 	 	 
	 			sheetObj.LoadSearchXml(sXml);	
				setSheet3Style(sheetObj, -1);
	 			ComOpenWait(false); //->waiting->End
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
                 style.height = 230;
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
     
 				var HeadTitle1 = "ibflag|Seq|RTSeq|Point|Description|Hub|Base\nPort|Term|Trans\nMode|Tariff (USD)|Tariff (USD)|" +
 									 "Diff.|Diff.|Total Cost|Total Cost|EFF Date|EXP Date|Source|" +
 									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD";  
 				var HeadTitle2 = "ibflag|Seq|RTSeq|Point|Description|Hub|Base\nPort|Term|Trans\nMode|RF|RF|" +
 									 "USD |USD |USD|USD|EFF Date|EXP Date|Source|" +
 									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD";  		
 				var HeadTitle3 = "ibflag|Seq|RTSeq|Point|Description|Hub|Base\nPort|Term|Trans\nMode|20'|40'|" +
 									 "20'|40'|20'|40'|EFF Date|EXP Date|Source|" +
 									 "IHC_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD";   

                 var headCount = ComCountHeadTitle(HeadTitle1);
 			
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0 , 0, true);
 		
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, true, true, false, false);           
 	
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                 InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
 				 InitHeadRow(1, HeadTitle2, true);  
                 InitHeadRow(2, HeadTitle3, true);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 		daCenter, 	true, 	"ibflag");     
                 InitDataProperty(0, cnt++, 	dtDataSeq,     		40,    		daCenter,  	true,  	"Seq");       
                 InitDataProperty(0, cnt++, 	dtHidden,    			40,    		daCenter,  	true,  	"rt_seq", false, "", dfNone, 0, false, false);        
                 InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"pnt_loc_cd", false, "", dfNone, 0, false, false);                              
                 InitDataProperty(0, cnt++, 	dtData, 				120, 		daLeft,	 		true, 	"pnt_loc_nm", false, "", dfNone, 0, false, false);                                 
                 InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"hub_loc_cd", false, "", dfNone, 0, false, false);                                       
                 InitDataProperty(0, cnt++, 	dtData, 				50, 		daCenter, 	true, 	"bse_port_loc_cd", false, "", dfNone, 0, false, false);                            
                 InitDataProperty(0, cnt++, 	dtCombo, 			70, 		daCenter, 	true, 	"rcv_de_term_cd", false, "", dfNone, 0, false, false);   
                 InitDataProperty(0, cnt++, 	dtCombo,				80, 		daCenter, 	true, 	"prc_trsp_mod_cd", false, "", dfNone, 0, false, false);                                   
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"gline_20ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"gline_40ft_frt_rt_amt", false, "", dfFloat, 2, false, false, 9);   
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"diff_20ft",	false,		"", dfNone, 0, false, false);                              
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight, 		true, 	"diff_40ft",	false,		"", dfNone, 0, false, false);                  
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"cost_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                 InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"cost_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                                                
                 InitDataProperty(0, cnt++, 	dtData, 				90, 		daCenter, 	true, 	"eff_dt", false, "", dfDateYmd, 0, false, false); 
                 InitDataProperty(0, cnt++, 	dtData, 				90, 		daCenter, 	true, 	"exp_dt", false, "", dfDateYmd, 0, false, false); 
                 InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	true, 	"src_info_cd", false, "", dfNone, 0, false, false); 
                 
                 InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"ihc_trf_no", false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"amdt_seq", false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"n1st_cmnc_amdt_seq", false, "", dfNone, 0, false, false); 
                 InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
                 
                 InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);                       
                 InitDataCombo(0, "rcv_de_term_cd", termCdText, termCdValue);     
                 InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);   
                 WaitImageVisible = false;  
                 Ellipsis = true;
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
        	
//            if (formObj.cost_cnt_cd.value == "") {
//            	ComShowCodeMessage('PRI00308',"input","Country"); 
//                clearAllForms();                
//                sheetObjects[0].RemoveAll();      
//            	formObj.cost_cnt_cd.focus();
//                return false;
//            }            
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
        var formObj = document.form;     
        formObj.ihc_trf_no.value="";
        formObj.amdt_seq.value="";
        formObj.org_dest_tp_cd.value="";      
        formObj.svc_scp_cd.value = "";
        sheetObjects[0].RemoveAll();      
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
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq"));
        }
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
	function tabLoadSheet(sIhcTrfNo, sAmdtSeq, sSvcScpCd, sOrgDestTpCd) {
		var formObject = document.form;
		if (formObject.ihc_trf_no.value != sIhcTrfNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd 
		  || formObject.org_dest_tp_cd.value != sOrgDestTpCd) {
			formObject.ihc_trf_no.value = sIhcTrfNo;
			formObject.amdt_seq.value = sAmdtSeq;
			formObject.svc_scp_cd.value = sSvcScpCd;		
			formObject.org_dest_tp_cd.value = sOrgDestTpCd ; 
			sheetObjects[0].RemoveAll();      
			doActionIBSheet(sheetObjects[0], document.form,SEARCH01);
		}
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
            }
        } else {
        	setLineStyle(sheetObj, idx);
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
			return true;
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
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
