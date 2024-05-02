/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0948.js
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.05.06 박미옥
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
     * @class esm_bkg_0948 : esm_bkg_0948 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0948() {
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
    
    var isRetrieved = false;
    var sOldLocCd  = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick() {
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
            
            switch(srcName) {
                case "btn2_Add":
                	doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn2_Delete":
                	doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;
                case "btn1_Retrieve":
                	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn1_Save":
                	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
                
            } // end switch
        } catch(e) {
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
    function setSheetObject(sheet_obj){
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }       

        initControl();
        

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)
    	document.form.loc_cd.focus();
    }
     

     
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
    	axon_event.addListenerFormat("keypress","obj_KeyPress", form);
    	axon_event.addListener("keydown","obj_keydown", "loc_cd");
    }

    
    /**
     * Key Down 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_keydown() {
    	var sheetObject1 = sheetObjects[0];
    	var formObject = document.form;
    	
        var evt_code = (window.netscape) ? ev.which : event.keyCode;
    	
    	switch(event.srcElement.name) {
	        case "loc_cd":
	        	// Location Enter 이벤트 시, Search
	        	if (evt_code == 13) {
	        		doActionIBSheet(sheetObject1, formObject, IBSEARCH);	        		
	        	}
	        	break;
   	    }
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

            case "sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 442;
                    
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

                    var HeadTitle1 = "|Sel.|SEQ|Customs Location|Code|Mail/Alert|Enable Flag|Staff ID|E-mail";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                    InitHeadMode(false, true, true, true, true, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                   
                    var prefix = sheetObj.id + "_";
                    //데이터속성    [ROW, COL,  DATATYPE,    WIDTH, DATAALIGN,   COLMERGE, SAVENAME,                 KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus,50,   daCenter, false,   prefix + "ibflag");                    
                    InitDataProperty(0, cnt++ , dtDummyCheck,  50,   daCenter, true,    prefix + "del_chk");                  
                    InitDataProperty(0, cnt++ , dtHidden,      30,   daCenter, true,    prefix + "hld_seq",         true,     "",         dfNone,     0,          false,      false);
                    InitDataProperty(0, cnt++ , dtData,        130,  daCenter, true,    prefix + "cstms_loc_cd",    true,     "",         dfEngUpKey, 0,          false,      false,     5,       true);
                    InitDataProperty(0, cnt++ , dtCombo,       110,  daCenter, true,    prefix + "cstms_dspo_cd",   false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,       120,  daCenter, true,    prefix + "ntc_mzd_cd",      false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,       120,  daCenter, true,    prefix + "ntc_enbl_flg",    false,    "",         dfNone,     0,          true,       true);
                    InitDataProperty(0, cnt++ , dtData,        120,  daCenter, true,    prefix + "ntc_usr_id",      true,     "",         dfNone,     0,          false,      true,      20);
                    InitDataProperty(0, cnt++ , dtData,        0,    daLeft,   true,    prefix + "ntc_eml",         false,    "",         dfEngKey,   0,          true,       true,      40);
                    
                    InitDataCombo(0, prefix + "ntc_mzd_cd", "All|Mail|Alert", "M|E|A", "All");
                    InitDataCombo(0, prefix + "ntc_enbl_flg", "No|Yes", "N|Y", "No");
                    
                    CountPosition = 0;
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
    	var prefix = sheetObj.id + "_";
        
        switch(sAction) {
		    
            // Customs 코드 가져오기
            case IBSEARCH_ASYNC02:
            	formObj.f_cmd.value = SEARCH02;
            	var sXml = sheetObj.GetSearchXml("ESM_BKG_0948GS.do", FormQueryString(formObj));                
                var arrData = ComXml2ComboString(sXml, "val", "name");
                if (arrData != null && arrData.length == 2) {
				    arrData[1] ="All|"+ arrData[1];
				    arrData[0] ="*|"+ arrData[0];
    			    sheetObj.InitDataCombo(0, prefix + "cstms_dspo_cd", arrData[1], arrData[0]);
                }
            	
                break;
        	    
            	
            	
            case IBSEARCH:      // 조회
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
                // Location 유효성 체크
                ComOpenWait(true);
                
            	formObj.f_cmd.value = SEARCH01;
		        var sXml = sheetObj.GetSearchXml("ESM_BKG_0948GS.do", FormQueryString(formObj));  
		        if (ComGetEtcData(sXml, "loc_validate") == "false") {
		        	ComShowCodeMessage("BKG00461");
		        	
		        	formObj.loc_cd.value = "";
		        	formObj.loc_cd.focus();
		        	
		        	ComOpenWait(false);		        	
		        	break;
		        	
		        } 		        
		        
		        // 조회하기
        		formObj.f_cmd.value = SEARCH; 
                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])
                sheetObj.DoSearch("ESM_BKG_0948GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));

                ComOpenWait(false);
                
                break;

                
                
            case IBINSERT:      // 입력
                if(!validateForm(sheetObj,formObj,sAction)) return;
            	
            	var vRow = sheetObj.DataInsert(-1);    
            	
            	// 초기값 셋팅
				sheetObj.CellValue2(vRow, prefix + "cstms_loc_cd")     = formObj.loc_cd.value;
            	sheetObj.CellValue2(vRow, prefix + "ntc_usr_id") = formObj.user_id.value;
            	sheetObj.CellValue2(vRow, prefix + "ntc_eml")    = formObj.user_eml.value;
            	
            	break;

            	
            	
            case IBDELETE:
            	ComRowHideDelete(sheetObj, prefix + "del_chk");
            	break;
            	
            	
            	
            case IBSAVE:        //저장
                if (!validateForm(sheetObj,formObj,sAction)) return;

                ComOpenWait(true);
            
        		formObj.f_cmd.value = MULTI;
        		sheetObj.DoSave("ESM_BKG_0948GS.do", FormQueryString(formObj), -1, false);
        		
        		ComOpenWait(false);

                break;
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
    function validateForm(sheetObj,formObj,sAction){

    	var prefix = sheetObj.id + "_";
    	
    	switch(sAction) {
    	    case IBSEARCH:
    	    	// 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
    	    	if (!ComChkValid(formObj)) return false;

            	if (ComIsModifiedSheets(sheetObj)) {
            		if (ComShowCodeConfirm("BKG00824")) {
            			doActionIBSheet(sheetObj,formObj,IBSAVE);
            			return false;
            		}
            	}

    	    	break;
    	    	
    	    case IBINSERT:   // 입력
    	    	
            	if (isRetrieved == false) {
            		ComShowCodeMessage("BKG00448"); 
            		return false;
            	}
            	
            	if (isChangedSearchKeyword() == false) {
            		ComShowCodeMessage("BKG01072"); 
    	    	    resetSearchKeyword();
    	    	    return false;
            	}

            	break;

            	
    	    case IBSAVE:    //저장
    	   
		        //삭제된 행을 제외하고 중복된 행을 찾는다.
    	        var i=0, j=0;
    	        for (i=0; i<sheetObj.RowCount; i++) 
    	        {    	        	
    	        	if (sheetObj.RowStatus(i+1) == "D") continue; // 삭제 제외
    	        	
    	        	if (sheetObj.CellValue(i+1, prefix + "ntc_enbl_flg") == "Y") 
    	        	{
    	        		for (j=i+1; j<sheetObj.RowCount; j++) 
    	        		{
    	        			if (sheetObj.RowStatus(j+1) == "D") continue; // 삭제 제외
    	        			
    	        			if (sheetObj.CellValue(j+1, prefix + "ntc_enbl_flg") == "Y") 
    	        			{
    	        				if (sheetObj.CellValue(i+1, prefix + "cstms_dspo_cd") == "*") // ALL
    	        				{
    	        					if (sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == "M") // ALL
    	        					{
                	        			if ( (sheetObj.CellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.CellValue(j+1, prefix + "cstms_loc_cd")) && 
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_usr_id") == sheetObj.CellValue(j+1, prefix + "ntc_usr_id")) ) 
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					} else 
    	        					{
                	        			if ( (sheetObj.CellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.CellValue(j+1, prefix + "cstms_loc_cd")) && 
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == sheetObj.CellValue(j+1, prefix + "ntc_mzd_cd")) &&
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_usr_id") == sheetObj.CellValue(j+1, prefix + "ntc_usr_id")) ) 
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					}
    	        				} else {
    	        					if (sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == "M") // ALL
    	        					{
                	        			if ( (sheetObj.CellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.CellValue(j+1, prefix + "cstms_loc_cd")) && 
                	        					(sheetObj.CellValue(i+1, prefix + "cstms_dspo_cd") == sheetObj.CellValue(j+1, prefix + "cstms_dspo_cd")) &&
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_usr_id") == sheetObj.CellValue(j+1, prefix + "ntc_usr_id")) ) 
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					} else 
    	        					{
                	        			if ( (sheetObj.CellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.CellValue(j+1, prefix + "cstms_loc_cd")) && 
                	        					(sheetObj.CellValue(i+1, prefix + "cstms_dspo_cd") == sheetObj.CellValue(j+1, prefix + "cstms_dspo_cd")) &&
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == sheetObj.CellValue(j+1, prefix + "ntc_mzd_cd")) &&
                	        					(sheetObj.CellValue(i+1, prefix + "ntc_usr_id") == sheetObj.CellValue(j+1, prefix + "ntc_usr_id")) ) 
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					}
    	        				}
    	        			}
    	        		}
    	        	}
    	        	
        	    	// E-mail 형식 체크
    		    	if  ((sheetObj.RowStatus(i+1) != "R") && (sheetObj.RowStatus(i+1) != "D") && 
       		    		 (sheetObj.CellValue(i+1, prefix + "ntc_enbl_flg") == "Y") &&
       		    		  (sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == "M" || sheetObj.CellValue(i+1, prefix + "ntc_mzd_cd") == "E")) 
    		    	{
       		    		if (ComIsEmailAddr(sheetObj.CellValue(i+1, prefix + "ntc_eml")) == false) 
       		    		{
       		    			ComShowCodeMessage("BKG00366");
       		    			sheetObj.SelectCell(i+1, prefix + "ntc_eml");
       		    			return false;
       		    		}  
       		    	}    	        	
    	        }    	    
    		    
	    	    break;
    	}

        return true;
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
    	var prefix = sheetObj.id + "_";

    	// 조회조건 저장
    	sOldLocCd  = formObject.loc_cd.value;
   		
    	isRetrieved = true;
    }
    
    
    /**
     * Save 왼료 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }

    
    /**
     * 조회 조건 변경 여부를 반환한다.<br>
     * 
     * @return boolean true: 조회조건 변경 됨, false:조회조건 변경 없슴
     */
    function isChangedSearchKeyword() {
    	var formObject = document.form;
    	
    	if (sOldLocCd  != formObject.loc_cd.value) {
    		return false;
    	}
    	
    	return true;
    }

    
    /**
     * 데이터 저장없이 임의로 변경된 조회 조건 값을 원상 복귀한다.<br>
     *
     * @return 없슴
     */
    function resetSearchKeyword() {
    	var formObject = document.form;
    	
    	formObject.loc_cd.value  = sOldLocCd;
    }

    
	/* 개발자 작업  끝 */