/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7026.js
*@FileTitle : Add-On Tariff Amendment History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History                                      
* 2012.10.30 서미진 [CHM-201220395] Add-on management T/F Project
* 2013.07.31 전윤주 [CHM-201326002] DG service flag가 'Y' 인 경우 버튼 파란색으로 표시                                                  
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
     * @class ESM_PRI_7026 : ESM_PRI_7026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7026() {
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
            
            case "btn_spcl_cgo_trf": 
            	if(sheetObjects[0].RowCount("R") > 0){
					var sParam = "svcScpCd="    	+	sheetObjects[0].cellValue(sheetObjects[0].SelectRow, "svc_scp_cd")
			           	 	       + "&fdrTrfNo=" 		+	sheetObjects[0].cellValue(sheetObjects[0].SelectRow, "fdr_trf_no")
			           	 	       + "&org_dest_tp_cd=" 	+ sheetObjects[0].cellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd")
			           	 	       + "&rhq_cd="		+ formObj.rhq_cd.value;
	            	var rtnVal = ComOpenPopup("/hanjin/ESM_PRI_7028.do?"+ sParam,	900, 500, '', "1,0,1,1,1,1,1", true);
            	}
                break;  

            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
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
		}finally {
			 ComOpenWait(false);
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
    	// loading 시 In bound 선택하도록 셋팅
    	comboObjects[0].Code = 'D' ;
    	initControl();         
        formObj.svc_scp_cd.focus();
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
      * OnClick 이벤트 발생시 호출되는 function <br>
      * radi type 에 맞는 화면을 조회한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *	
      * </pre>
      * @return 없음
      * @author 김재연
      * @version 2009.04.29
      */
 	function obj_click(){
 		var formObj = document.form;
 		if (event.srcElement.name == "detail_tp") {
 			if(sheetObjects[0].RowCount("R") > 0){
 				sheet1_OnSelectCell(sheetObjects[0], sheetObjects[0].SelectRow-1, sheetObjects[0].SelectCol, sheetObjects[0].SelectRow, sheetObjects[0].SelectCol);
 			}
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
             case SEARCH01:   // main       //             case SEARCH03:   // main  
                 if (!validateForm(sheetObjects[0],document.form,sAction)) {
                     return false;
                 }   
              	ComOpenWait(true); //->waiting->start
             	sheetObjects[0].RemoveAll();      
             	sheetObjects[1].RemoveAll();      
 	 			formObj.f_cmd.value = SEARCH01;	 
 	 			var sXml = sheetObj.GetSearchXml("ESM_PRI_7026GS.do", FormQueryString(formObj));	 	 
 	 			sheetObj.LoadSearchXml(sXml);				
 	 			ComOpenWait(false); //->waiting->End
                break; 
                
            case IBCREATE: 	// New
            	formObj.reset();        
				comboObjects[0].Index = 0;
                comboObjects[1].Index = -1;
                sheetObjects[0].RemoveAll();   
                sheetObjects[1].RemoveAll();  
                formObj.detail_tp[0].checked = true;
                formObj.svc_scp_cd.focus();
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
                InitRowInfo(1, 1, 7, 100);

				var HeadTitle1 = "|Seq.|Tariff No.|Tariff No.|AMD No.|Effective Date|Expiry Date|Creation Date|Creation Staff/Team|Confirm Date|Confirm Staff/Team|ORG_DEST_TP_CD|SVC_SCP_CD";  

                var headCount = ComCountHeadTitle(HeadTitle1);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
                // KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
                // INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
                // SAVESTATUS, FORMATFIX]                        
                InitDataProperty(0, cnt++, dtHiddenStatus,  	40,   daCenter, true,  "ibflag");
                InitDataProperty(0, cnt++, dtDataSeq,			40,   daCenter, true,  "seq");
                InitDataProperty(0, cnt++, dtData,		    	150, daCenter, false, "fdr_trf_no_format", 	false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtHidden,		    	100, daCenter, false, "fdr_trf_no", 	false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData,		    	60,	  daCenter, true,  "amdt_seq",  			false, "", dfNone,	  0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	100, daCenter, false, "eff_dt",	    	false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	100, daCenter, false, "exp_dt",	    false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	100, daCenter, false, "cre_dt",	    	false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	150, daCenter, false, "cre_usr",	    false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	100, daCenter, false, "cfm_dt",		false, "", dfDateYmd, 0, false, false);
				InitDataProperty(0, cnt++, dtData,		    	150, daCenter, false, "cfm_usr",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtHidden,		    	150, daCenter, false, "org_dest_tp_cd",		false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, 	dtHidden, 			100, daCenter, false, 	"svc_scp_cd", false, "", dfNone, 0, false, false); 
				WaitImageVisible = false;
			}
            break;
        
        case "sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 300;
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
    
				var HeadTitle1 = "ibflag|Seq|RTSeq|Origin|Base Port|Term|Dry Tariff|Dry Tariff|Dry Tariff|RF\nSVC|RF Tariff|RF Tariff|" +
									 "EFF Date|EXP Date|Source|Manual\nInput|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|DCGO_SVC_FLG";  
				var HeadTitle2 = "ibflag|Seq|RTSeq|Origin|Base Port|Term|USD|USD|USD|RF\nSVC|USD|USD|" +
									 "EFF Date|EXP Date|Source|Manual\nInput|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|DCGO_SVC_FLG";  		
				var HeadTitle3 = "ibflag|Seq|RTSeq|Origin|Base Port|Term|20'|40'|45'|RF\nSVC|20'|40'|" +
									 "EFF Date|EXP Date|Source|Manual\nInput|FDR_TRF_NO|AMDT_SEQ|N1ST_CMNC_AMDT_SEQ|SVC_SCP_CD|DCGO_SVC_FLG";   

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
                InitDataProperty(0, cnt++, 	dtHidden,    		40,    		daCenter,  	true,  	"rt_seq",                   false, "", dfNone, 0, false, false);        
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daCenter, 	true, 	"pnt_loc_cd",               false, "", dfNone, 0, false, false);                                                                     ;                                
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daCenter, 	true, 	"bse_port_loc_cd",          false, "", dfNone, 0, false, false);                                       
                InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	true, 	"rcv_de_term_cd",           false, "", dfNone, 0, false, false);                                 
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	true, 	"gline_20ft_frt_rt_amt",    false, "", dfFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	true, 	"gline_40ft_frt_rt_amt",    false, "", dfFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	true, 	"gline_45ft_frt_rt_amt",    false, "", dfFloat, 2, false, false, 9);  //45'
                InitDataProperty(0, cnt++, 	dtData, 			40, 		daCenter, 	true, 	"rc_svc_flg",               false, "", dfNone, 0, false, false);          
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	true, 	"gline_rf_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
                InitDataProperty(0, cnt++, 	dtData, 			80, 		daRight,	true, 	"gline_rf_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                
                InitDataProperty(0, cnt++, 	dtData, 			90, 		daCenter, 	true, 	"eff_dt",                   false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			90, 		daCenter, 	true, 	"exp_dt",                   false, "", dfDateYmd, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtCombo, 			80, 		daCenter, 	true, 	"src_info_cd",              false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtData, 			0, 			daCenter, 	true, 	"add_flg",                  false, "", dfNone, 0, false, false);          

                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"fdr_trf_no",               false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"amdt_seq",                 false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"n1st_cmnc_amdt_seq",       false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"svc_scp_cd",               false, "", dfNone, 0, false, false); 
                InitDataProperty(0, cnt++,  dtHidden, 			60,			daCenter,  	true,   "dcgo_svc_flg", 			false, "", dfNone, 0, false, false);
                                   
                InitDataCombo(0, "rcv_de_term_cd", termCdText, termCdValue);     
                InitDataCombo(0, "src_info_cd", srcInfoCdText, srcInfoCdValue);   
                HeadRowHeight = DataRowHeight;
                WaitImageVisible = false;  
                Ellipsis = true;
                ScrollBar=2;
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
        case SEARCH01: // 조회            
            if (comboObjects[1].Index =="-1") {
            	ComShowCodeMessage('PRI00308',"input","Service Scope"); 
            	formObj.svc_scp_cd.focus();
                return false;
            }    
            break;
        }
        return true;
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
    	sheetObjects[1].Redraw = false;
        if (OldRow != NewRow) {
        	var formObj = document.form;
        	sheetObjects[1].RemoveAll();     
        	if(formObj.detail_tp[0].checked){
        		formObj.detail_tp.value = "1";
        		sheetObjects[1].ColHidden('eff_dt') = true;
            	sheetObjects[1].ColHidden('exp_dt') = true;
        	}else{
        		formObj.detail_tp.value = "2";
        		sheetObjects[1].ColHidden('eff_dt') = false;
            	sheetObjects[1].ColHidden('exp_dt') = false;
        	}    	
        	if(formObj.detail_tp.value != "2" || sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq") != "0"){			
				formObj.f_cmd.value = SEARCH02;
				var param = "f_cmd="          + formObj.f_cmd.value
						  + "&fdr_trf_no="       + sheetObj.cellValue(NewRow, "fdr_trf_no")
						  + "&amdt_seq="       + sheetObj.cellValue(NewRow, "amdt_seq")
				          + "&svc_scp_cd="      + sheetObj.cellValue(NewRow, "svc_scp_cd")
					      + "&org_dest_tp_cd=" + sheetObj.cellValue(NewRow, "org_dest_tp_cd")
					      + "&detail_tp="		  + formObj.detail_tp.value;	      
				var sXml = sheetObjects[1].GetSearchXml("ESM_PRI_7026GS.do", param);
				sheetObjects[1].LoadSearchXml(sXml);	
				setSheet3Style(sheetObjects[1], -1);			
        	}
			// Header setting
 	        if(sheetObj.cellValue(NewRow, "org_dest_tp_cd") == "D"){
 	        	sheetObjects[1].CellValue( 0 , "pnt_loc_cd") = "Destination" ;
 	        	sheetObjects[1].CellValue( 1 , "pnt_loc_cd") = "Destination" ;
 	        	sheetObjects[1].CellValue( 2 , "pnt_loc_cd") = "Destination" ;
 	        }else{
 	        	sheetObjects[1].CellValue( 0 , "pnt_loc_cd") = "Origin" ;
 	        	sheetObjects[1].CellValue( 1 , "pnt_loc_cd") = "Origin" ;
 	        	sheetObjects[1].CellValue( 2 , "pnt_loc_cd") = "Origin" ;
 	        }
        }
        sheetObjects[1].FitColWidth();
        sheetObjects[1].Redraw = true;
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
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
            changeSelectBackColor(sheetObj, sheetObj.CellValue(NewRow, "n1st_cmnc_amdt_seq"), sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "amdt_seq"));
            
          //버튼 색 변경
            if(sheetObj.CellValue(sheetObj.SelectRow , "fdr_trf_no") != ""){ //Feeder 구간이 있는 조회 결과일 경우   
            	if(sheetObj.CellValue(sheetObj.SelectRow , "dcgo_svc_flg") == ""){ // 한번 조회해서 값이 있는 경우는 다시 조회하지 않는다.
            		//Add-on DG service Flag를 찾아오기 위하여 조회
    				var formObj = document.form;
    				var sheetObj = sheetObjects[1]    				
    				formObj.f_cmd.value = SEARCH02;
    				
    				var sParam = "fdr_trf_no="+sheetObj.CellValue(sheetObj.SelectRow,"fdr_trf_no")
    				+ "&svc_scp_cd="+sheetObj.CellValue(sheetObj.SelectRow,"svc_scp_cd")
		            + "&org_dest_tp_cd="+sheetObjects[0].cellValue(sheetObjects[0].SelectRow, "org_dest_tp_cd")
		            + "&rhq_cd="+ formObj.rhq_cd.value
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
						document.getElementById("btn_spcl_cgo_trf").style.color = "blue";
					}
				} else {
					document.getElementById("btn_spcl_cgo_trf").style.color = "";	
				}    				
 			}else{
 				document.getElementById("btn_spcl_cgo_trf").style.color = "";	
 			}    				
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
    	var formObj = document.form;
    	if (idx <= 0) {
    		return false;
    	}
    	
    	if (sheetObj.RowStatus(idx) == "D") {
    		sheetObj.RowHidden(idx) = true;
    	}
    	
    	// Proposal단계 일 경우 색상처리를 하지 않는다.
    	if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq") == "0") {
    		return true;
    	}  	
    	
    	// 이전Seq의 데이터는 Amend된 데이터로 간주하고, 취소선을 긋고, Row를 수정불가로 한다.
    	// 다만 RFA는 RowEditable메쏘드를 이용해 전체 Row를 Uneditable로 처리하고,
    	// S/C의 경우는 Note쪽에서 Conversion화면을 띠워야 하므로 루프를 돌면서 컬럼단위로 Uneditable 처리한다.
    	if (sheetObj.CellValue(idx, "amdt_seq") != sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq")) {
    		if(!formObj.detail_tp[0].checked){
				sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = true;
				return true;
    		}
		} else {
			sheetObj.CellFont("FontStrikethru", idx, 1, idx, sheetObj.LastCol) = false;
    	}
    	
    	// 이번 회차의 데이타(Insert or Amend)는 font-color를 red로 표시.
    	if (sheetObj.CellValue(idx, "n1st_cmnc_amdt_seq") == sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "amdt_seq")) {
    		if(!formObj.detail_tp[0].checked){
    			sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(255,0,0);
    		}
    	} else {
    		sheetObj.CellFont("FontColor", idx, 1, idx, sheetObj.LastCol) = sheetObj.RgbColor(0,0,0);
    	}
    	
    	// 선택된 행의 font-color가 black이 아닌 경우, SelectBackColor를 변경해줌.
    	changeSelectBackColor4Rate(sheetObj);
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
		formObj.etc1.value = comboObjects[0].Code;	//	ORG_DEST_TP_CD
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
		ComPriXml2ComboItem(sXml, formObj.svc_scp_cd, "cd", "cd|nm"); 
		formObj.svc_scp_cd.focus();
	}