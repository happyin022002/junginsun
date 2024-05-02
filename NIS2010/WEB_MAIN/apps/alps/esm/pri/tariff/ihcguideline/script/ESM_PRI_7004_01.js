/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7004_01.js
*@FileTitle : IHC inquiry in local currency (TRO) - Dry Tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.05
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation 
=========================================================
* History                          
* 2013.02.05 서미진 [CHM-201322859] AOC weight 정보 추가 - 현재 hidden 처리하여 반영    
* 2013.03.11 [CHM-201323465] 기존 개발했던 weight 컬럼 hidden 처리 제거 (다른 CSR에 live 반영만 함)          
* 2013.07.26 전윤주 [CHM-201326002] grid 위치 변경 Max weight 제일 앞으로 이동  
*                                 Over weight service flag가 'Y' 인 경우 버튼 파란색으로 표시 
* 2013.08.06 전윤주 [CHM-201326196] TRO 화면에서 Over weight팝업 호출 시 Local curr.로 조회되도록 변경   
* 2015.03.05 [CHM-201534279] 최성환  Pricing FeederIHC tariff 45 칼럼 추가                               
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
     * @class ESM_PRI_7004_01 : ESM_PRI_7004_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7004_01() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
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
    	parent.loadTabPage(); 
    	sheet1Allclear();
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
	 			formObj.f_cmd.value = SEARCH01;	 		
	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7004_01GS.do", FormQueryString(formObj));	 	 	 
	 			sheetObj.LoadSearchXml(sXml);	
                break;  
                
    		case IBDOWNEXCEL :
    			//sheetObj.Down2Excel();
    			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
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
                 InitRowInfo(3, 1, 3, 100);
     
                 var HeadTitle1 = "|Seq.|Point|Postal\nCode|LOC\nGroup|Description|Hub|Base\nPort|Trans\nMode|Term|Max Cargo Weight\nW/O Surcharge (Ton)|Max Cargo Weight\nW/O Surcharge (Ton)|Max Cargo Weight\nW/O Surcharge (Ton)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(Local Currency)|Tariff(USD)|Tariff(USD)|Tariff(USD)|Tariff(USD)|Tariff(USD)|Tariff(USD)|IHC_TRF_NO|ORG_DEST_TP_CD|SVC_SCP_CD|OVR_WGT_CGO_SVC_FLG";
     			 var HeadTitle2 = "|Seq.|Point|Postal\nCode|LOC\nGroup|Description|Hub|Base\nPort|Trans\nMode|Term|Max Cargo Weight\nW/O Surcharge (Ton)|Max Cargo Weight\nW/O Surcharge (Ton)|Max Cargo Weight\nW/O Surcharge (Ton)|Curr.|Dry|Dry|Dry|DG|DG|DG|Dry|Dry|Dry|DG|DG|DG|IHC_TRF_NO|ORG_DEST_TP_CD|SVC_SCP_CD|OVR_WGT_CGO_SVC_FLG";
     			 var HeadTitle3 = "|Seq.|Point|Postal\nCode|LOC\nGroup|Description|Hub|Base\nPort|Trans\nMode|Term|20'|40'|45'|Curr.|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|IHC_TRF_NO|ORG_DEST_TP_CD|SVC_SCP_CD|OVR_WGT_CGO_SVC_FLG";

                 var headCount = ComCountHeadTitle(HeadTitle1);
 			
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0 , 0, true);
 		
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(true, true, true, true, false, false)
 	
                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]  dtHiddenStatus
                 InitHeadRow(0, HeadTitle1, true);                                                                                                                                                                                                                                                                                                                                                                                                                               
 				 InitHeadRow(1, HeadTitle2, true);  
                 InitHeadRow(2, HeadTitle3, false);

                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                 InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter,	true, "ibflag");
     	 		 InitDataProperty(0, cnt++, dtSeq, 				40, daCenter,  true);
     	 		 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "pnt_loc_cd", 							false, "", dfNone, 0, false, false);
     		 	 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "zip_cd", 								false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "ihc_cost_loc_grp_no", 				false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 		   200, daLeft, 	true, "pnt_loc_cd_nm", 					false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "hub_loc_cd", 							false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "bse_port_loc_cd", 					false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daCenter, 	true, "prc_trsp_mod_cd_nm", 			false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			50, daCenter, 	true, "rcv_de_term_cd_nm", 				false, "", dfNone, 0, false, false);
     			 
     			 InitDataProperty(0, cnt++, dtData, 			70, daRight, 	true, "trsp_20ft_agmt_wgt", 	        	false, "", dfNullFloat, 2, false, false,9);
    			 InitDataProperty(0, cnt++, dtData, 			70, daRight, 	true, "trsp_40ft_agmt_wgt", 	        	false, "", dfNullFloat, 2, false, false,9);
    			 InitDataProperty(0, cnt++, dtData, 			70, daRight, 	true, "trsp_45ft_agmt_wgt", 	        	false, "", dfNullFloat, 2, false, false,9); 		// 45'
     			
     			 InitDataProperty(0, cnt++, dtData, 			40, daCenter, 	true, "locl_curr_cd", 						false, "", dfNone, 0, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_20ft_amt", 		false, "", dfNullFloat, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_40ft_amt", 		false, "", dfNullFloat, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_45ft_amt", 		false, "", dfNullFloat, 2, false, false); 			// 45'
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_dg_20ft_amt", 	false, "", dfNone, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_dg_40ft_amt", 	false, "", dfNone, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_locl_curr_dg_45ft_amt", 	false, "", dfNone, 2, false, false);  			// 45'
     			 
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_20ft_frt_rt_amt", 			false, "", dfNullFloat, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_40ft_frt_rt_amt", 			false, "", dfNullFloat, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_45ft_frt_rt_amt", 			false, "", dfNullFloat, 2, false, false); 			// 45'
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_dg_20ft_frt_rt_amt", 		false, "", dfNone, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_dg_40ft_frt_rt_amt", 		false, "", dfNone, 2, false, false);
     			 InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true, "gline_dg_45ft_frt_rt_amt", 		false, "", dfNone, 2, false, false); 				// 45'
     			 
     			 InitDataProperty(0, cnt++, dtHidden, 		   100, daCenter, 	true, "ihc_trf_no",                     		false, "", dfNone, 0, false, false); 
     			 InitDataProperty(0, cnt++, dtHidden, 		   100, daCenter, 	true, "org_dest_tp_cd",                 	false, "", dfNone, 0, false, false); 
     			 InitDataProperty(0, cnt++, dtHidden, 		   100, daCenter, 	true, "svc_scp_cd",                     		false, "", dfNone, 0, false, false); 
     			 InitDataProperty(0, cnt++, dtHidden, 			70, daCenter, 	true, "ovr_wgt_cgo_svc_flg",             false, "", dfNone, 0, false, false);
     			 
                 sheetObj.SetMergeCell (0, 10, 2, 3);  
/*
 				mySheet.SetMergeCell(Row, Col, Rows, Cols); 
				Parameter Type 필수여부 Remark 
				Row Long 필수  강제머지할 셀의 Row Index 
				Col Long 필수  강제머지할 셀의 Column Index  
				Rows Long 필수  강제머지할 셀의 Row 개수 
				Cols Long 필수  강제머지할 셀의 Col 개수  
*/
                 HeadRowHeight = DataRowHeight;
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
        var formObj = document.form;     
        formObj.svc_scp_cd.value="";
        formObj.org_dest_tp_cd.value="";
        formObj.acc_dt.value="";      
        formObj.pnt_loc_cd.value = "";      
        formObj.bse_port_loc_cd.value="";
        formObj.cnt_cd.value="";
        formObj.zip_cd.value="";      
        sheetObjects[0].RemoveAll();      
        sheet1Allclear();
        formObj.cgoTpcd[1].checked=false; 
    }
	
 	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * @return 없음
     * @author 서미진
     * @version 2012.11.05
     */ 
	function tabLoadSheet(sSvcScpCd, sOrgDestTpCd, sAccDt, sPntLocCd, sBsePortLocCd, sCntCd, sZipCd ) {
		var formObject = document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.org_dest_tp_cd.value != sOrgDestTpCd || formObject.acc_dt.value != sAccDt 
		  || formObject.pnt_loc_cd.value != sPntLocCd || formObject.bse_port_loc_cd.value != sBsePortLocCd || formObject.cnt_cd.value != sCntCd || formObject.zip_cd.value != sZipCd ) {
			formObject.svc_scp_cd.value = sSvcScpCd ;
			formObject.org_dest_tp_cd.value = sOrgDestTpCd ;
			formObject.acc_dt.value = sAccDt ; 
			formObject.pnt_loc_cd.value = sPntLocCd ;
			formObject.bse_port_loc_cd.value = sBsePortLocCd ;
			formObject.cnt_cd.value = sCntCd ;
			formObject.zip_cd.value = sZipCd ;
			sheetObjects[0].RemoveAll();      
			doActionIBSheet(sheetObjects[0], document.form,SEARCH01);
		}
	}

	/**
	 * detail sheet (sheetObjects[1]) clear 하는 function <br> 
	 *  
	 * @return 없음
	 * @author 서미진
	 * @version 2012.07.05
	 */
    function sheet1Allclear() {
        sheetObjects[0].RemoveAll();      
    	sheetObjects[0].ColHidden('gline_dg_20ft_frt_rt_amt') = true;
    	sheetObjects[0].ColHidden('gline_dg_40ft_frt_rt_amt') = true;
    	sheetObjects[0].ColHidden('gline_dg_45ft_frt_rt_amt') = true;			// 45'    	
    	sheetObjects[0].ColHidden('gline_locl_curr_dg_20ft_amt') = true;
    	sheetObjects[0].ColHidden('gline_locl_curr_dg_40ft_amt') = true;
    	sheetObjects[0].ColHidden('gline_locl_curr_dg_45ft_amt') = true;		// 45'
    }
    
	
	function showColumn(sheetObj, obj) {
		var checked = !obj.checked;
		switch(obj.value) {
			case 'D' :
				sheetObj.ColHidden('gline_20ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_40ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_45ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_20ft_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_40ft_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_45ft_amt') = checked;
				break;
			case 'G' :
				sheetObj.ColHidden('gline_dg_20ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_dg_40ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_dg_45ft_frt_rt_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_dg_20ft_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_dg_40ft_amt') = checked;
				sheetObj.ColHidden('gline_locl_curr_dg_45ft_amt') = checked;
				break;	
		}
	}
	
	
	/**
	 * OnSelectCell 이벤트 발생시 호출되는 function <br>
	 * Main 화면에 있는 Over Weight Cgo 버튼의 색을 변경한다.
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} OldRow 필수 이전에 선택된 셀의 Row Index
	 * @param {int} OldCol 필수 이전에 선택된 셀의 Column Index
	 * @param {int} NewRow 필수 현재 선택된 셀의 Row Index
	 * @param {int} NewCol 필수 현재 선택된 셀의 Column Index
	 * @return 없음
	 * @author 전윤주
	 * @version 2013.07.30
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	var sOvrWgtCgoSvcFlg = sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "ovr_wgt_cgo_svc_flg")    	
    	parent.changeBtnOverWeightCgoColor(sOvrWgtCgoSvcFlg);
    }
	
	
	/* 
	 * ihc_ovr_cgo POP-UP OPEN
	 */
	function open_ihc_ovr_cgo(){
		if(sheetObjects[0].RowCount("R") > 0){
			var sParam = "svcScpCd="    	+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "svc_scp_cd")
						+ "&ihcTrfNo=" 		+	sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "ihc_trf_no")
						+ "&org_dest_tp_cd=" +  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd")
						+ "&opn="	            +  "7004";
			var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7024.do?"+ sParam,	550, 500, '', "1,0,1,1,1,1,1", true);
		}
	}