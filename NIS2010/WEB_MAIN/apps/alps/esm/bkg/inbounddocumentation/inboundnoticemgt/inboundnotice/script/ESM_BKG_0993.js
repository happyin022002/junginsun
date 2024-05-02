/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0993.js
*@FileTitle : Pick up No Notice Manual Setup Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.24 박미옥
* 1.0 Creation
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
     * @class esm_bkg_0993 : esm_bkg_0993 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0993() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/


    // 공통전역변수
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var isLoaded    = false;
    var isRetrieved = false;
    var isSetup     = false;
    
    var jobId = "";
    var timeId = "";
    
    var monCnt = 0; // 10분 으로 제한(600sec/3sec=200번)
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

            case "btn2_Retrieve":
            	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
                                    
            case "btn2_Setup":
            	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                break; 
            
            case "btn2_UploadExcel":
            	doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
                break; 
                
            case "btn2_ExcelTemplate":
            	sheetObjects[1].SpeedDown2Excel(-1);
            	break;

            case "btn1_Close":
            	window.close();
                break; 

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }


    /**
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;                        
    }



    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {

        for(var i=0; i<sheetObjects.length; i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        setButtonEnableDisable();
    }


    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetObj.id) {
        case 'sheet1':      //sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 250;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 15, 100);
                    
                var HeadTitle1 = "|Error|B/L No.|Booking No.|CNTR No.|Ofc cd|Pick up No|AVL DT|FRE DT|PICK YD|RTN YD||||VVD|RL|NT|F|O|C|POD|DEL|Delivery\nTerm";

                var headCount = ComCountHeadTitle(HeadTitle1);
                    
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성        [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE,   SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus, 0,  daCenter,     true,    "ibflag",        false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,     true,    "err_flag",      false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        85,  daCenter,     true,    "bl_no",         true,       "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,     true,    "bkg_no",        false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        85,  daCenter,     true,    "cntr_no",       false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,     true,    "eq_ctrl_ofc_cd",false,      "",      dfNone,         0,        false,      false);

                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,    false,    "pkup_no",       false,      "",      dfEngUpKey,     0,        false,      false,    20);
                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,    false,    "pkup_aval_dt",  false,      "",      dfUserFormat2,  0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,    false,    "lst_free_dt",   false,      "",      dfUserFormat2,  0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        70,  daCenter,    false,    "pkup_yd_cd",    false,      "",      dfEngUpKey,     0,        false,      false,    7);
                InitDataProperty(0, cnt++ , dtData,        70,  daCenter,    false,    "rtn_yd_cd",     false,      "",      dfEngUpKey,     0,        false,      false,    7);                                                                                                                                            

                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,     true,    "vsl_cd",        false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,     true,    "skd_voy_no",    false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,      40,  daCenter,     true,    "skd_dir_cd",    false,      "",      dfNone,         0,        false,      false);
                
                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,     true,    "vvd",           false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtHidden,      75,  daCenter,     true,    "rail_lod_dt",   false,      "",      dfDateYmd,      0,        false,      false);                  
                InitDataProperty(0, cnt++ , dtHidden,      75,  daCenter,     true,    "ntfc_dt",       false,      "",      dfDateYmd,      0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        25,  daCenter,     true,    "frt_clt_flg",   false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        25,  daCenter,     true,    "obl_clt_flg",   false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        25,  daCenter,     true,    "cstms_clr_flg", false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        50,  daCenter,     true,    "pod_cd",        false,      "",      dfNone,         0,        false,      false);
                InitDataProperty(0, cnt++ , dtData,        50,  daCenter,     true,    "del_cd",        false,      "",      dfNone,         0,        false,      false);                                                                                                                                  
                InitDataProperty(0, cnt++ , dtData,        60,  daCenter,     true,    "de_term_cd",    false,      "",      dfNone,         0,        false,      false);
//                InitDataProperty(0, cnt++ , dtHidden,      20,  daCenter,     true,    "bkg_cust_tp_cd",false,      "",      dfNone,         0,        false,      false);
//                InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,     true,    "cust_cnt_cd",   false,      "",      dfNone,         0,        false,      false);
//                InitDataProperty(0, cnt++ , dtHidden,       0,  daCenter,     true,    "cust_seq",      false,      "",      dfNone,         0,        false,      false);
//                InitDataProperty(0, cnt++ , dtData,        80,  daCenter,     true,    "cust_cd",       false,      "",      dfNone,         0,        false,      false);
//                InitDataProperty(0, cnt++ , dtData,         0,  daLeft,       true,    "cust_nm",       false,      "",      dfNone,         0,        false,      false);
                
                InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );
                
                CountPosition = 0;
            }
        
            break;
            
        case "template":
            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = false;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 1, 100);
                    
                var HeadTitle1 = "B/L No";

                var headCount = ComCountHeadTitle(HeadTitle1);
                    
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false, false);

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);

                //데이터속성        [ROW, COL,  DATATYPE,      WIDTH, DATAALIGN, COLMERGE,   SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,        85,  daCenter,     true,    "bl_no",         true,       "",      dfNone,         0,        false,      false);
                
                CountPosition = 0;

                DataInsert();
                CellValue2(1, "bl_no") = "SHAXXXXXXXXX";
            }
        	
            break;

        }
    }

    
    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return 없슴
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {

        case IBLOADEXCEL:
        	sheetObj.LoadExcel(1, 1, "", "-1", "-1", "", false, false, "1=>bl_no");
        	break;
        
        	
        	
        case IBSEARCH:
   		    if (!isLoaded || (sheetObj.RowCount == 0)) {
			    ComShowCodeMessage("BKG01079", "Upload Excel");
			    break;
		    }

        	if (validateForm(sheetObj,formObj,sAction) == false) break;
        
        	ComOpenWait(true);
        	
            formObj.f_cmd.value = SEARCH;
            
            var sParam = FormQueryString(formObj);
            var sParamSheet1 = sheetObj.GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
  
            sheetObj.DoSearch("ESM_BKG_0993GS.do", sParam);
            
            ComOpenWait(false);
            
            break;
        
            
            
        case IBSAVE:
        	
   		    if (!isRetrieved) {
			    ComShowCodeMessage("BKG01079", "Retrieve");
			    break;
		    }

            if(validateForm(sheetObj,formObj,sAction) == false) break;

            var sParamSheet1 = sheetObj.GetSaveString();
            if (sParamSheet1 == "") {
             	ComShowCodeMessage("BKG00743");
             	break;
            }

            if (ComShowCodeConfirm("BKG00824") == false) break;

            
            ComOpenWait(true);
            
            formObj.f_cmd.value = MULTI;
            var sParam = FormQueryString(formObj);
            
            sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");            
            
       	    var sXml = sheetObj.GetSaveXml("ESM_BKG_0993GS.do", sParam);
       	    sheetObj.LoadSaveXml(sXml);

    		ComOpenWait(false);

        	doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC06);

            break;
            
            
            
            // Execute Batch 
        case IBSEARCH_ASYNC06:
        	
        	ComOpenWait(true);

        	// 1. ESM_BKG_B019 체크
            var sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B019";
       	    var sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComOpenWait(false);
       	    	break;
       	    }
        	
        	// 2. ESM_BKG_B012 체크
            sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B012";
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComOpenWait(false);
       	    	break;
       	    }

       	    
       	    // 3. ESM_BKG_B015 체크
            sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B015";
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComOpenWait(false);
       	    	break;
       	    }
        	
       	    
        	formObj.f_cmd.value = SEARCH03;
            sParam = FormQueryString(formObj);
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);
       	           	    
       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	monCnt = 1;
       	    	jobId = ComGetEtcData(sXml,"JOB_ID");
                timeId = setTimeout("monitoringBatchJob()", 1000*3);
       	    } else {
       	    	ComOpenWait(false);
       	    }
       	     
        	break;
        	
        	
        	
        	// Monitor Batch Status
        case IBSEARCH_ASYNC07:
        	
            var sParam = "&f_cmd=" + SEARCH04 + "&job_id=" + jobId;
        	var sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);
       	    
        	if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
        	{
            	var jobStatus = ComGetEtcData(sXml,"BATCH_STATUS");
       	    	if (jobStatus == "0" || jobStatus == "1" || jobStatus == "3" || jobStatus == "10") // None. Running or Starting or Restart 
       	    	{ 
       	    		if (monCnt < 200) { // 모니터링 10분으로 제한.(3sec*200=10min)
           	    		monCnt++;
           	    		// 계속 모니터링
           	    		timeId = setTimeout("monitoringBatchJob()", 1000*3);
       	    		} else {
       	    			ComOpenWait(false);
       	    		}
       	    	} else {
       	    		ComOpenWait(false);
       	    	}
       	    } else {
       	    	ComOpenWait(false);
       	    }

        	break;

        }
    }

    
    /**
     * 유효한 BL인 경우 Sheet 의 Status를 I로 변경 <br>
     * 
     * @param {array} sheets 쉬트 배열 필수
     * @return 없슴
     */
    function setStatusFlag(sheetObj) {
    	with(sheetObj) {
        	for (var j=0;j<RowCount;j++) {
        		if(CellValue(j+1, "err_flag") == "Y") {
        			RowFontColor(j+1) = RgbColor(255, 0, 0); 
        		} else {
        			RowStatus(j+1) = "I";
        			
        			CellEditable(j+1,"pkup_no")      = true;
        			CellEditable(j+1,"pkup_aval_dt") = true;
        			CellEditable(j+1,"lst_free_dt")  = true;
        			CellEditable(j+1,"pkup_yd_cd")   = true;
        			CellEditable(j+1,"rtn_yd_cd")    = true;
        		}
        	}
    	}
    } 
    

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj, formObj, sAction) {
        switch(sAction) {
        
    	case IBSEARCH:
	        var dupStr = "bl_no";
	         
	        var dupRow = sheetObj.ColValueDup(dupStr, false);	
	        if (dupRow > 0) {
	        	ComShowCodeMessage("BKG00488");
	        	return false;
	        }
    		 
    		 break;
    	
    		 
    		 
    	 case IBSAVE:
    		 with(sheetObj) {
        		 for(var i=0; i<RowCount; i++) {
        			 if (RowStatus(i+1) == "I") {
        				 if (CellValue(i+1,"pkup_no") == "") {
        					 ComShowCodeMessage("BKG01101", "Pick up No");
        					 SelectCell(i+1,"pkup_no")
        					 return false;
        				 }

        				 if (CellValue(i+1,"pkup_aval_dt") == "") {
        					 ComShowCodeMessage("BKG01101", "AVL DT");
        					 SelectCell(i+1,"pkup_aval_dt")
        					 return false;
        				 }

        				 if (CellValue(i+1,"lst_free_dt") == "") {
        					 ComShowCodeMessage("BKG01101", "FRE DT");
        					 SelectCell(i+1,"lst_free_dt")
        					 return false;
        				 }

        				 if (CellValue(i+1,"pkup_yd_cd") == "") {
        					 ComShowCodeMessage("BKG01101", "PICK YD");
        					 SelectCell(i+1,"pkup_yd_cd")
        					 return false;
        				 }
        			 }
        		 }
    		 }
    		 
    		 break;
    	 }
    	 
    	 return true;
    }


    /**
     * 버튼 Enable 상태 변경 <br>
     * 
     * @return 없슴
     */
    function setButtonEnableDisable() {
    	
    	ComBtnDisable("btn2_Retrieve");
    	ComBtnDisable("btn2_Setup");
    	    	
    	if (isLoaded & !isRetrieved) {
    		ComBtnEnable("btn2_Retrieve");
    	}

    	if (isRetrieved & !isSetup) {
    		ComBtnEnable("btn2_Setup");
    	}
    }
    
    
    /**
     * 엑셀 업로드 이벤트 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @return 없슴 
     */
    function sheet1_OnLoadExcel(sheetObj) {
    	isLoaded    = true;
    	isRetrieved = false;
    	isSetup     = false;
    	
    	setButtonEnableDisable();    	
    }
    
    
    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject = document.form;
    	
    	if (ErrMsg == "") {
            setStatusFlag(sheetObjects[0]);
        	
        	isRetrieved = true;
    	}

    	setButtonEnableDisable();
    }
    
    
    /**
     * Save 왼료 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
    	if (ErrMsg == "") {
    		ComShowCodeMessage("BKG00102");
    	
        	isSetup     = true;
        	
        	setButtonEnableDisable();
    	}
    }
        
     
     /**
      * 배치 상태를 모니터링한다.
      * @return 없슴
      */
     function monitoringBatchJob() {
     	var sheetObj = sheetObjects[0];

     	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC07);
     }
     
     
     /**
      * 배치 상태 Description 을 가져온다
      * @param {string} status 필수 배치 상태 코드
      * @return {string} 배치 상태 Description
      */
     function getBatchStatusDesc(status) {
     	/*
    		상태코드
 		status	1	RUNNING	
 		status	3	STARTING	
 		status	4	SUCCESS	
 		status	5	FAILURE	
 		status	6	TERMINATED	
 		status	7	ON_ICE	
 		status	8	INACTIVE	
 		status	9	ACTIVATED	
 		status	10	RESTART	
 		status	11	ON_HOLD	
 		status	12	QUE_WAIT
 	    */
     	
 	    var desc = "";
    
     	if (status == "1") {
     		desc = "Running";
     	} else if (status == "3") {
     		desc = "Starting";
     	} else if (status == "4") {
     		desc = "Success";
     	} else if (status == "5") {
     		desc = "Fail";
     	} else if (status == "6") {
     		desc = "Terminated";
     	} else if (status == "7") {
     		desc = "On Ice";
     	} else if (status == "8") {
     		desc = "Inactive";
     	} else if (status == "9") {
     		desc = "Activated";
     	} else if (status == "10") {
     		desc = "Restart";
     	} else if (status == "11") {
     		desc = "On Hold";
     	} else if (status == "12") {
     		desc = "Que Wait";
     	} else {
     		desc = "Undefined status:" + status + "";
     	}
     	
     	return desc;
     }
     
	/* 개발자 작업  끝 */