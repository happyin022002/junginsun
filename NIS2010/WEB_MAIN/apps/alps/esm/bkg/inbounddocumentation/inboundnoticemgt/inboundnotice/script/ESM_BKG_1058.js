/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1058.js
*@FileTitle : MT Return Yard for Pickup Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.08.10 박미옥
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
     * @class ESM_BKG_1058 : ESM_BKG_1058 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1058() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var isRetrieve = false;
    
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
        var sheetObject2 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");
 
            switch(srcName) {
            
            case "img_dt":
    	        var cal = new ComCalendarFromTo();
    		    cal.select(formObject.rtn_yd_sav_dt_s, formObject.rtn_yd_sav_dt_e, 'yyyy-MM-dd');
                break;
                
            case "btn_Retrieve":
              	doActionIBSheet(sheetObjects[tabObjects[0].selectedIndex], formObject, IBSEARCH);
                break;
 
            case "btn_RowAdd":
                doActionIBSheet(sheetObject1, formObject, IBINSERT);
                break;
                    
            case "btn_Delete":
            	doActionIBSheet(sheetObject1, formObject, IBDELETE);
                break;
                    
            case "btn_Save":
                doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
                        
			case "btn_DownExcel":
              	sheetObjects[tabObjects[0].selectedIndex].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "del_chk");
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
     * IBTab Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {object} tab_obj 필수, Tab 컨트롤
     * @return 없슴
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Tab 기본 설정 <br>
     * 탭의 항목을 설정한다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    tabNo  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function initTab(tabObj , tabNo) {
        with (tabObj) {
            var cnt  = 0 ;
            InsertTab( cnt++ , "Live" , -1 );
            InsertTab( cnt++ , "Delete" , -1 );
        }
    }

    
    /**
     * Tab 클릭시 이벤트 관련 <br>
     * 선택한 탭의 요소가 활성화 된다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    nItem  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        beforetab= nItem;

        if (isRetrieve == true) {
           	doActionIBSheet(sheetObjects[nItem], document.form, IBSEARCH);
        }
        
        if (nItem == 0) {
        	ComBtnEnable("btn_Save");
        } else {
        	ComBtnDisable("btn_Save");
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
        //IBTab 초기화
        for (var k=0; k<tabObjects.length; k++) {
            initTab(tabObjects[k],k+1);
        }

        //IBSheet 초기화
        for(var i=0;i<sheetObjects.length;i++) {

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }              
        
        initControl();

        
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
     

    /**
    * HTML 태그 이벤트를 등록한다. <br>
    * 
    * @return 없슴
    */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
       	axon_event.addListener("keydown","ComKeyEnter", "pod_cd", "rtn_yd_sav_dt_s", "rtn_yd_sav_dt_e", "pkup_yd_id",  
       			"fnl_dest_cd", "mcntr_rtn_yd_cd", "rtn_yd_sav_ofc_cd");
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
        // Live
        case "t1sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 380;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);
                
                var HeadTitle = " |Check|Seq.|YD Seq.|POD|PICK YD|DEL|Type|Return YD|Office|Saved ID|Saved Date";
                var headCount = ComCountHeadTitle(HeadTitle);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                                        
                //데이터속성            [ROW,    COL,     DATATYPE,           WIDTH,   DATAALIGN,    COLMERGE,   SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0,     cnt++,  dtHiddenStatus,         20,     daCenter,       false,  "ibflag");
                InitDataProperty(0,     cnt++,  dtDummyCheck,           50,     daCenter,       false,  "del_chk");
                InitDataProperty(0,     cnt++,  dtSeq,                  40,     daCenter,       false,  "seq");
                InitDataProperty(0,     cnt++,  dtHidden,               40,     daCenter,       false,  "rtn_yd_seq");
                InitDataProperty(0,     cnt++,  dtData,                 120,    daCenter,       false,  "pod_cd",             true,  "",         dfEngUpKey,     0,    false,        true,           5, true);
                InitDataProperty(0,     cnt++,  dtData,                 120,    daCenter,       false,  "pkup_yd_id",         true,  "",         dfEngUpKey,     0,    false,        true,           8);
                InitDataProperty(0,     cnt++,  dtData,                 110,    daCenter,       false,  "fnl_dest_cd",        true,  "",         dfEngUpKey,     0,    false,        true,           5, true);
                InitDataProperty(0,     cnt++,  dtCombo,                80,     daCenter,       false,  "pkup_cntr_tp_id",    true,  "",         dfNone,         0,    false,        true);
                InitDataProperty(0,     cnt++,  dtData,                 110,    daCenter,       false,  "mcntr_rtn_yd_cd",    true,  "",         dfEngUpKey,     0,     true,        true,           7, true);
                InitDataProperty(0,     cnt++,  dtData,                 110,    daCenter,       false,  "rtn_yd_sav_ofc_cd",  true,  "",         dfEngUpKey,     0,    false,        false);
                InitDataProperty(0,     cnt++,  dtData,                 110,    daCenter,       false,  "rtn_yd_sav_usr_id",  true,  "",         dfNone,         0,    false,        false);
                InitDataProperty(0,     cnt++,  dtData,                 110,    daCenter,       false,  "rtn_yd_sav_dt",      false, "",         dfUserFormat2,  0,    false,        false);
                        
                InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "pkup_yd_id", vtEngUpOther, "0123456789");
                InitDataValid(0, "fnl_dest_cd", vtEngUpOther, "0123456789");
                InitDataValid(0, "mcntr_rtn_yd_cd", vtEngUpOther, "0123456789");
                
                InitUserFormat2(0, "rtn_yd_sav_dt", "####-##-## ##:##:##", "-|:" );
                
                InitDataCombo(0, "pkup_cntr_tp_id", "*|RF", "ALL|RF", "ALL");
            }
            
            break;

        // Delete
        case "t2sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 380;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 5, 100);
                
                var HeadTitle = "Seq.|POD|PICK YD|DEL|Type|Return YD|Office|Deleted ID|Deleted Date";
                var headCount = ComCountHeadTitle(HeadTitle);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);
                
                //데이터속성   [ROW, COL,  DATATYPE,     WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++,  dtSeq,      40,    daCenter,  false,  "seq",               false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "pod_cd",            false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "pkup_yd_id",        false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "fnl_dest_cd",       false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtCombo,    80,    daCenter,  false,  "pkup_cntr_tp_id",   false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "mcntr_rtn_yd_cd",   false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "rtn_yd_sav_ofc_cd", false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "delt_usr_id",       false,  "",   dfNone,        0,    false);
                InitDataProperty(0, cnt++,  dtData,    120,    daCenter,  false,  "delt_dt",           false,  "",   dfUserFormat2, 0,    false);
                
                InitUserFormat2(0, "delt_dt", "####-##-## ##:##:##", "-|:" );
                
                InitDataCombo(0, "pkup_cntr_tp_id", "*|RF", "ALL|RF");
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

        // Search
        case IBSEARCH:  
            if(validateForm(sheetObj,formObj,sAction) == false) break;
        
            isRetrieve = true;
            
            if (sheetObj.id=="t1sheet1") {
            	formObj.delt_flg.value = "N";
            } else if (sheetObj.id=="t2sheet1") {
            	formObj.delt_flg.value = "Y";
            }

            ComOpenWait(true);
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESM_BKG_1058GS.do", FormQueryString(formObj));
            
            ComOpenWait(false);
            
            break;
            
            

        //저장
        case IBSAVE:        
        	if (sheetObj.id == "t2sheet1") break;
        	
            if(!validateForm(sheetObj,formObj,sAction)) break;
            
    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}
            
            var sParamSheet = sheetObj.GetSaveString();
            if (sParamSheet == "") return;
            var sParam = ComSetPrifix(sParamSheet, "sheet1_");

            ComOpenWait(true);
            
            formObj.f_cmd.value = MULTI;
			sParam += "&" + FormQueryString(formObj);
			var sXml = sheetObj.GetSaveXml("ESM_BKG_1058GS.do", sParam);
			sheetObj.LoadSaveXml(sXml);
            
			ComOpenWait(false);
			
    		break;
    		
    		

        // 입력
        case IBINSERT:      
        	if (sheetObj.id == "t2sheet1") break;
        	
            var vRow = sheetObj.DataInsert(-1);
            
            sheetObj.CellValue2(vRow, "rtn_yd_sav_usr_id") = formObj.usr_id.value;
            sheetObj.CellValue2(vRow, "rtn_yd_sav_ofc_cd") = formObj.usr_ofc_cd.value;
                
            break;
            
            
            
        // 삭제
        case IBDELETE:
        	if (sheetObj.id == "t2sheet1") break;

        	ComRowHideDelete(sheetObj, "del_chk");
        	
        	break;
        }
    }
    

    /**
     * Tab1 Sheet1 변경 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     */
    function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		if (ColSaveName(Col) == "pod_cd" ||
				ColSaveName(Col) == "pkup_yd_id" ||
				ColSaveName(Col) == "fnl_dest_cd" || 
				ColSaveName(Col) == "mcntr_rtn_yd_cd") 
    		{
    			
    			if (ColSaveName(Col) == "pod_cd" ||
					ColSaveName(Col) == "fnl_dest_cd") 
    			{
    				if (Value.length < 5) return;
    			} else if (ColSaveName(Col) == "mcntr_rtn_yd_cd") {
    				if (Value.length < 7) return;
    			} else if (ColSaveName(Col) == "pkup_yd_id") {
    				if (Value.length < 5) {
    					ComShowCodeMessage("BKG40105", ColSaveName(Col));
    					return;
    				}
    			}

    			var formObj = document.form;
    			
            	formObj.f_cmd.value = SEARCH01;
            	
            	if (ColSaveName(Col) == "pod_cd") formObj.chk_tp.value = "P";
            	else if (ColSaveName(Col) == "pkup_yd_id") formObj.chk_tp.value = "YL";
            	else if (ColSaveName(Col) == "mcntr_rtn_yd_cd") formObj.chk_tp.value = "Y";
            	else formObj.chk_tp.value = "L";
            	            	
            	formObj.loc_cd.value = Value;

		        var sXml = GetSearchXml("ESM_BKG_1058GS.do", FormQueryString(formObj));
		        if(ComBkgErrMessage(sheetObj, sXml) == false) {
		        	CellValue2(Row, Col) = "";
		        	SelectCell(Row, Col);
		        }
    		}
    	}
    }

    
    /**
     * Tab1 Sheet1 저장 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function t1sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
      	}
    } 

    /**
     * Tab1 Sheet1 조회 완료 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
            ColFontColor("pod_cd")            = RgbColor(255,0,0);
            ColFontColor("pkup_yd_id")        = RgbColor(255,0,0);
            ColFontColor("fnl_dest_cd")       = RgbColor(255,0,0);
            ColFontColor("rtn_yd_sav_ofc_cd") = RgbColor(255,0,0);
    	}
    }

    /**
     * Tab2 Sheet1 조회 완료 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     */
    function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
            ColFontColor("pod_cd")            = RgbColor(255,0,0);
            ColFontColor("pkup_yd_id")        = RgbColor(255,0,0);
            ColFontColor("fnl_dest_cd")       = RgbColor(255,0,0);
            ColFontColor("rtn_yd_sav_ofc_cd") = RgbColor(255,0,0);
    	}
    }
    
    /**
     * Tab1 Sheet1 클릭 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     */
    function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		if (CellValue(Row, "del_chk") == 0) CellValue2(Row, "del_chk") = 1;
    		else CellValue2(Row, "del_chk") = 0;
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
        with(sheetObj) {
         	switch(sAction) {
        	case IBSEARCH:
    	    	// 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크    	    	
    	    	if (!ComChkValid(formObj)) return false;

    	    	break;
    	    	
        	case IBSAVE:
                if (ComIsModifiedSheets(sheetObj) == false) {
                	ComShowCodeMessage("BKG00743");
                	return false;
            	}
        		
        		// 중복 체크        		
        		var dupStr = "pod_cd|pkup_yd_id|fnl_dest_cd|pkup_cntr_tp_id";
	    	    
		        var dupRow = sheetObj.ColValueDup(dupStr, false);	
		        if (dupRow > 0) {
		        	ComShowCodeMessage("BKG04008");
		        	return false;
		        }
		        
		        for (var i=0; i<RowCount; i++) {
		        	if (RowStatus(i+1) == "U" || RowStatus(i+1) == "I") {
		        		if (CellValue(i+1,"pkup_yd_id").length < 5) {
	    					ComShowCodeMessage("BKG40105", "pkup_yd_id");
	    					SelectCell(i+1,"pkup_yd_id");
	    					return false;
		        		}
		    				
		                CellValue2(i+1, "rtn_yd_sav_usr_id") = formObj.usr_id.value;
		                CellValue2(i+1, "rtn_yd_sav_ofc_cd") = formObj.usr_ofc_cd.value;
		        	}
		        }
		        
        		break;
         	}
        }

        return true;
    }
        
	/* 개발자 작업  끝 */