/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0411.js
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.06.12 박미옥
* 1.0 Creation
* 
* 2012.02.23 민정호 [CHM-201216237] Pick up notice 전송시 NF (Event date) 추가 요청
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
     * @class esm_bkg_0411 : esm_bkg_0411 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0411() {
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
    
    var SH_STUP    = 0;
    var SH_PRE_FOM = 1;
    var SH_PRE_HRS = 2;
    var SH_ARR_FOM = 3;
    var SH_ARR_HRS = 4;
    
    var org_del_cd = "";
    var orgDelList;
    var orgObj = new Object();
    var isRetrieved = false;
    var isAutoSelect = false;
    var isNew        = true;

    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function processButtonClick(){
        
        var shtCnt = 0;

        var sheet1Obj = sheetObjects[shtCnt++];
        var sheet2Obj = sheetObjects[shtCnt++];
        var sheet3Obj = sheetObjects[shtCnt++];
        var sheet4Obj = sheetObjects[shtCnt++];
        var sheet5Obj = sheetObjects[shtCnt++];

        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Retrieve":
                    doActionIBSheet(sheet1Obj,formObject,IBSEARCH);
                    break;

                case "btn_Copy":
                	doActionIBSheet(sheet1Obj,formObject,IBSEARCH_ASYNC02);
                    break; 

                case "btn_Save":
                	doActionIBSheet(sheet1Obj,formObject,IBSAVE);
                    break; 
                    
                case "btn_Delete":
                	doActionIBSheet(sheet1Obj,formObject,IBDELETE);
                	break;
                 
            } // end switch
        } catch(e) {
            if(e == "[object Error]") {
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
    * @author 박미옥
    * @version 2009.07.09
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
    * @author 박미옥
    * @version 2009.07.09
    */
    function loadPage() {

        for (var i=0;i<sheetObjects.length;i++) {
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i]);
            
            initSheet(sheetObjects[i],i+1);
            
            //khlee-마지막 환경 설정 함수 추가
           	ComEndConfigSheet(sheetObjects[i]);
        }

        for(var k=0;k<tabObjects.length;k++) {
            initTab(tabObjects[k],k+1);
        }
        
        initControl();
        initForm();
     }
     
     
    /**
      * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
      * 
      * @return 없슴
      * @author 박미옥
      * @version 2009.07.09
      */
    function initForm() {   	 

        isRetrieved  = false;
        isAutoSelect = false;
        isNew        = true;

        // DEL 코드 원본 값 초기화
        org_del_cd = "";

    	// Form 데이터 Space 및 디폴트 값으로 초기화
 		with(document.form){
 			ofc_cd.value               = p_ofc_cd.value;
            del_cd.value               = "ALL";
            ntc_snd_tp_cd.value        = "A"; // Auto

            frm_pkup_ntc_seq.value         = "";
            frm_pkup_ntc_snd_tp_cd.value   = "";
            frm_ofc_cd.value               = "";
            frm_del_cd.value               = "";
            frm_eclz_obl_cpy_flg.value     = "";
            frm_foc_clr_rmk_stup_flg.value = "";
            frm_auto_ntc_flg.value         = "Y"; // Auto
            frm_each_foc_ntc_flg.value     = "Y"; // Each Y Send(3times)
            frm_trkr_ntc_flg.value         = "N"; // No
            frm_hd_tit_ctnt.value          = "";
                    
            frm_t1_pkup_ntc_seq.value      = "";
            frm_t1_pkup_ntc_fom_cd.value   = "";
            frm_t1_eclz_obl_cpy_flg.value  = "N";
            frm_t1_btm_rmk.value           = "";
            
            frm_t2_pkup_ntc_seq.value      = "";
            frm_t2_pkup_ntc_fom_cd.value   = "";
            frm_t2_eclz_obl_cpy_flg.value  = "N";
            frm_t2_btm_rmk.value           = "";
 		}

 		// Sheet 데이터 모두 삭제로 초기화
        for (var i=0;i<sheetObjects.length;i++) {
        	sheetObjects[i].RemoveAll();
        }

        resetSetupFlag();

        // EQ Office 에 등록된 DEL 코드를 모두 가져온다.(DEL 콤보 생성)
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
        
        document.form.ofc_cd.focus();
     }
    
    

    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
     	axon_event.addListener("keydown","ComKeyEnter", "ofc_cd", "del_cd");
     	axon_event.addListener("keydown","obj_keydown", "frm_hd_tit_ctnt", "frm_t1_btm_rmk", "frm_t2_btm_rmk");
     	axon_event.addListener("keyup","obj_keyup", "ofc_cd", "del_cd", "frm_t1_btm_rmk", "frm_t2_btm_rmk");
     	axon_event.addListener("change","obj_change", "frm_auto_ntc_flg"); 
    }    
     

    /**
     * Key Down 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function obj_keydown() {
        switch(event.srcElement.name) {
        case "frm_hd_tit_ctnt":
       	    if (checkMaxLine(event.srcElement, 2) == false) {
       	   	    if(event.keyCode == 13) { 	  
       	   		    event.returnValue = false;
       	   	    }
       	    }
        	break;
        case "frm_t1_btm_rmk":
        case "frm_t2_btm_rmk":
       	    if (checkMaxLine(event.srcElement, 18) == false) {
       	   	    if(event.keyCode == 13) { 	  
       	   		    event.returnValue = false;
       	   	    }
       	    }
       	    break;
        }
    }

    
    /**
     * Key Up 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function obj_keyup() {
        var sheetObject1 = sheetObjects[SH_STUP];
     	var formObject = document.form;
     	
     	switch(event.srcElement.name) {
        case "ofc_cd":
        	if (event.srcElement.value.length == 5) {
        	    doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
        	}
        	break;
     	case "del_cd":
     		fncFindDelComboCode(event.srcElement, formObject.del_cd_list);
     		break;
	    }
    }     
     

    /**
     * Change 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function obj_change() {    	 
   	    
    	var formObject = document.form;

   	    switch(event.srcElement.name) {
    	case "frm_auto_ntc_flg":
			if (formObject.frm_auto_ntc_flg.value == "Y" ) { // Auto
			    formObject.frm_each_foc_ntc_flg.disabled = false;
			    formObject.frm_trkr_ntc_flg.disabled     = false;
			    formObject.frm_each_foc_ntc_flg.value    = "N";
			} else { // Manual
			    formObject.frm_each_foc_ntc_flg.disabled = true;
			    formObject.frm_trkr_ntc_flg.disabled     = true;
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
    * @author 박미옥
    * @version 2009.07.09
    */
    function initSheet(sheetObj,sheetNo) {

        var sheetID = sheetObj.id;        
        var cnt = 0;
        
        switch(sheetID) {
        
        // Setup Information
        case "sheet1":
        	with (sheetObj) {
        		// 높이 설정
                style.height = 0;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 1, 1);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 0);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                InitHeadMode(false, false, false, false, false, false);
                
                var HeadTitle1 = "|Seq|Send Type Code|Office Code|DEL|Auto|FOC|Trucker|OBL Copy|Remart Setup|Content";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,       60,   daLeft,    false,    "ibflag");
                InitDataProperty(0, cnt++ , dtData,         60,   daLeft,    false,    "pkup_ntc_seq",        false);
                InitDataProperty(0, cnt++ , dtData,         40,   daLeft,    false,    "pkup_ntc_snd_tp_cd",  true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "ofc_cd",              true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "del_cd",              true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "auto_ntc_flg",        true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "each_foc_ntc_flg",    true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "trkr_ntc_flg",        true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "eclz_obl_cpy_flg",    true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "foc_clr_rmk_stup_flg",true);
                InitDataProperty(0, cnt++ , dtData,        100,   daLeft,    false,    "hd_tit_ctnt",         false,     "",       dfNone,         0,      false,       false,     500);               
                
                CountPosition = 0;
        	}
        	
        	break;
        	
        // Word Information
        case "t1sheet1":
        case "t2sheet1":
            with (sheetObj) {
                // 높이 설정
                style.height = 0;
                
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 1, 1);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(8, 0, 0, false);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, false, false, false, false, false)
                
                var HeadTitle1 = "||||Seq|Form Code|Enclose O_B/L Copy|Bottom Remark";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,        WIDTH, DATAALIGN,  COLMERGE, SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtStatus,        60,   daCenter,   false,  "ibflag");

                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "pkup_ntc_snd_tp_cd", true);
                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "ofc_cd",             true);
                InitDataProperty(0, cnt++ , dtData,          50,   daCenter,   false,  "del_cd",             true);
                
                InitDataProperty(0, cnt++ , dtData,          40,   daCenter,   false,  "pkup_ntc_seq",       false,     "",       dfNone,         0,      false,       false);
                InitDataProperty(0, cnt++ , dtData,         150,   daLeft,     false,  "pkup_ntc_fom_cd",    true,      "",       dfNone,         0,      false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   false,  "eclz_obl_cpy_flg",   true,      "",       dfNone,         0,      false,       false);
                InitDataProperty(0, cnt++ , dtData,           0,   daLeft,     false,  "btm_rmk",            false,     "",       dfNone,         0,      false,       false,     500);
                
                CountPosition = 0;
            }
            break;
                    	
        // Hour Information
        case "t1sheet2":
        case "t2sheet2":
            with (sheetObj) {
                // 높이 설정
                style.height = 88;
                //전체 너비 설정
                SheetWidth = 760;
                
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msAll;
                
                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 3, 3);
                
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(11, 0, 1);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                // [SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]
                InitHeadMode(false, false, false, false, false, false);
                
                var HeadTitle1 = "||||||||322 Movement Status|Condition|Time";
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
                //데이터속성    [ROW, COL,  DATATYPE,         WIDTH, DATAALIGN, COLMERGE,  SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtNull,         100,   daCenter,  false,    "head");
                InitDataProperty(0, cnt++ , dtHiddenStatus,   0,   daCenter,  false,    "ibflag");

                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "pkup_ntc_snd_tp_cd", true);
                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "ofc_cd",             true);
                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "del_cd",             true);
                
                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "pkup_ntc_seq",       false);
                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "pkup_ntc_fom_cd",    true);
                InitDataProperty(0, cnt++ , dtHidden,         0,   daCenter,  false,    "ntc_seq",            false);
                InitDataProperty(0, cnt++ , dtCombo,        260,   daCenter,  false,    "mvmt_sts_cd",        false);
                InitDataProperty(0, cnt++ , dtCombo,        200,   daCenter,  false,    "ntc_cond_cd",        false);
                InitDataProperty(0, cnt++ , dtCombo,        200,   daCenter,  false,    "ntc_bse_hrs",        false);
                
                //해더 컬럼에 정보 설정하기
                InitHeadColumn(0, "1st|2nd|3rd");

                InitDataCombo(0, "ntc_bse_hrs", "0 Hours|6 Hours|12  Hours|24 Hours|36 Hours|48 Hours|60 Hours|120 Hours", 
                		                        "0|6|12|24|36|48|60|120");
                InitDataCombo(0, "ntc_cond_cd", "At|After", "AT|AF");
                InitDataCombo(0, "mvmt_sts_cd", "N/A|RL (Rail Departed)|AR (Arrival @ Rail Destination)|NT (Notification)|NF (Last Free Date)|NE (NF event date)", 
                		                        "NA|RL|AR|NT|NF|NE");
                                                        
                CountPosition = 0;
                
    			for (var i=1; i<Rows; i++) {
    				CellValue(i, "mvmt_sts_cd") = "NA";
    				CellEditable(i, "ntc_cond_cd") = false;
    				CellEditable(i, "ntc_bse_hrs") = false;    				
    			}
                
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
    * @author 박미옥
    * @version 2009.07.09
    */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
        
        // DEL 목록 조회 및 콤보 생성
        case IBSEARCH_ASYNC01:        
        	if (validateForm(sheetObj,formObj,sAction) == false) return; 

        	formObj.f_cmd.value = SEARCH01;
        	var sXml = sheetObj.GetSearchXml("ESM_BKG_0411GS.do", FormQueryString(formObj));
        	orgDelList = sXml;
        	
        	ComXml2ComboItem(sXml, formObj.del_cd_list, "val", "name");
        	if (org_del_cd == "") {
            	formObj.del_cd_list.Code = "ALL";
        	} else {
            	formObj.del_cd_list.Code = org_del_cd;
        	}
        	
        	org_del_cd = "";
        	
        	break;
        	
        	
        	
        // 조회
        case IBSEARCH:
            if (validateForm(sheetObj,formObj,sAction) == false) break; 

            
            ComOpenWait(true);
        	
            formObj.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchXml("ESM_BKG_0411GS.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|");

            if (ComGetTotalRows(arrXml[0]) == 0)  isNew = true;
            else isNew = false;
            
            if (arrXml.length > 0) sheetObjects[SH_STUP].LoadSearchXml(arrXml[0]); // Setup
            if (arrXml.length > 1) sheetObjects[SH_PRE_FOM].LoadSearchXml(arrXml[1]); // Pre-Arrival Word
            if (arrXml.length > 2) sheetObjects[SH_PRE_HRS].LoadSearchXml(arrXml[2], true, -1); // Pre-Arrival Hour
            if (arrXml.length > 3) sheetObjects[SH_ARR_FOM].LoadSearchXml(arrXml[3]); // Arrival Word
            if (arrXml.length > 4) sheetObjects[SH_ARR_HRS].LoadSearchXml(arrXml[4], true, -1); // Arrival Hour

            copyRowToForm();

           	ComOpenWait(false); 
           	
            
            if (isNew == true) {
            	ComBtnDisable("btn_Copy");
            	ComShowCodeMessage("BKG00889");
            } else {
            	ComBtnEnable("btn_Copy");
            }            
            
            break;
            
            
            
        // 저장
        case IBSAVE:

        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	
        	if(validateForm(sheetObj,formObj,sAction) == false) {
        		break;
        	}

        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG01072"); 
	    	    resetSearchKeyword();
	    	    break;
        	}
        	
            copyFormToRow();

            if (ComIsModifiedSheets(sheetObjects) == false) {
            	ComShowCodeMessage("BKG00743");
            	break;
        	}

    		if (ComShowCodeConfirm("BKG00824") == false) {
    			break;
    		}

            ComOpenWait(true);

        	setStatusFlag(sheetObjects);
       	
        	
            formObj.f_cmd.value = MULTI;
            var sParam = FormQueryString(formObj);
            var sParamSheet1 = sheetObjects[SH_STUP].GetSaveString();
            if (sParamSheet1 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
            }
            var sParamSheet2 = sheetObjects[SH_PRE_FOM].GetSaveString();
            if (sParamSheet2 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
            }
            var sParamSheet3 = sheetObjects[SH_PRE_HRS].GetSaveString();
            if (sParamSheet3 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet3, "sheet3_");
            }
            var sParamSheet4 = sheetObjects[SH_ARR_FOM].GetSaveString();
            if (sParamSheet4 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet4, "sheet2_");
            }
            var sParamSheet5 = sheetObjects[SH_ARR_HRS].GetSaveString();
            if (sParamSheet5 != "") {
                sParam += "&" + ComSetPrifix(sParamSheet5, "sheet3_");
            }

            var sXml = sheetObj.GetSaveXml("ESM_BKG_0411GS.do", sParam);
			sheetObjects[SH_STUP].LoadSaveXml(sXml);
            
			sXml = ComDeleteMsg(sXml);   /// 넘어온 메시지는 한번만 보이고 싶을 때 사용.
			sheetObjects[SH_PRE_FOM].LoadSaveXml(sXml);
			sheetObjects[SH_PRE_HRS].LoadSaveXml(sXml);
			sheetObjects[SH_ARR_FOM].LoadSaveXml(sXml);
			sheetObjects[SH_ARR_HRS].LoadSaveXml(sXml);
			
            ComOpenWait(false);

			
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgSaveCompleted();
	    		
	    		org_del_cd = document.form.del_cd.value;
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
	    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}

            break;
            
            
            
            // Copy
        case IBSEARCH_ASYNC02:
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}
        	
        	if(validateForm(sheetObj,formObj,sAction) == false) break;

        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}

        	var param = "from_ofc_cd=" + formObj.ofc_cd.value + "&from_del_cd=" + formObj.del_cd.value;
        	var resultObj = ComOpenPopupWithTarget('/hanjin/ESM_BKG_0992.do?' + param, 306, 172, "", "none", true);
        	if (resultObj != null) {
        		formObj.ofc_cd.value = resultObj.ofc_cd;
        		formObj.del_cd.value = resultObj.del_cd;
        		
        		org_del_cd = formObj.del_cd.value;

        		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
        		doActionIBSheet(sheetObj, formObj, IBSEARCH);
        	}
        	
        	break;
        	
        	
        	
        case IBDELETE:
        	
        	if (isRetrieved == false) {
        		ComShowCodeMessage("BKG00448"); 
        		break;
        	}

        	if (isChangedSearchKeyword() == true) {
        		ComShowCodeMessage("BKG40029");
	    	    resetSearchKeyword();
	    	    break;
        	}

    		if (ComShowCodeConfirm("BKG00535") == false) {
    			break;
    		}

        	ComOpenWait(true);

        	formObj.f_cmd.value = MULTI01;
        	var sParam = FormQueryString(formObj) +        	
        	             "&pkup_ntc_seq=" + sheetObjects[SH_PRE_FOM].CellValue(1, "pkup_ntc_seq");
        	
        	var sXml = sheetObj.GetSaveXml("ESM_BKG_0411GS.do", sParam);
			sheetObjects[SH_STUP].LoadSaveXml(sXml);
			
			ComOpenWait(false);
			
			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
	    		ComBkgDeleteCompleted();
				initForm();
			}
        	
        	break;
         }
    }


    /**
     * IBTab Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {object} tab_obj 필수, Tab 컨트롤
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
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
     * @author 박미옥
     * @version 2009.07.09
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {                
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Pre-Arrival Notice" , -1 );
                    InsertTab( cnt++ , "Arrival Notice" , -1 );                    
                }
            break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련 <br>
     * 선택한 탭의 요소가 활성화 된다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    nItem  필수, Tab 오브젝트 일련번호
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function tab1_OnChange(tabObj , nItem) {
    
        var objs = document.all.item("tabLayer");

        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        /*
        if(nItem==0 &&tabLoad[0]!=1)
            frameLayer0.document.location = 'tab1.jsp?frame=Tab1';
        else if(nItem==1 &&tabLoad[1]!=1)
            frameLayer1.document.location = 'tab3.jsp?frame=Tab2';          
        */
        
        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= nItem;                
    }
      

    /**
     * Sheet 데이터를 Form 으로 복사한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function copyRowToForm() {
   	
    	var formObj = document.form;
		var idx    = 0;
		var prefix = "";
		var fom_cd = "";
    	
    	with (formObj) {

    		// Setup Information
  			prefix = "frm_";
			if (sheetObjects[SH_STUP].RowCount == 0) 
			{
    			sheetObjects[SH_STUP].DataInsert(0);
    			
    			sheetObjects[SH_STUP].CellValue(1,"pkup_ntc_seq")         = "";
    			sheetObjects[SH_STUP].CellValue(1,"pkup_ntc_snd_tp_cd")   = ntc_snd_tp_cd.value;
    			sheetObjects[SH_STUP].CellValue(1,"ofc_cd")               = ofc_cd.value;
    			sheetObjects[SH_STUP].CellValue(1,"del_cd")               = del_cd.value.trim() == "" ? "ALL" : del_cd.value;
    			sheetObjects[SH_STUP].CellValue(1,"auto_ntc_flg")         = "Y";
    			sheetObjects[SH_STUP].CellValue(1,"each_foc_ntc_flg")     = "Y";
    			sheetObjects[SH_STUP].CellValue(1,"trkr_ntc_flg")         = "N";
    			sheetObjects[SH_STUP].CellValue(1,"eclz_obl_cpy_flg")     = "N";
    			sheetObjects[SH_STUP].CellValue(1,"foc_clr_rmk_stup_flg") = "N";
    			sheetObjects[SH_STUP].CellValue(1,"hd_tit_ctnt")          = "";
    		}

			IBS_CopyRowToForm(sheetObjects[SH_STUP], formObj, 1, prefix);


			for (var j=0; j<2; j++)
			{								
				if (j == 0) idx = SH_PRE_FOM;
				else idx = SH_ARR_FOM;
								
				// Pre-Arrival Word Information & Hour Information
				if (idx == SH_PRE_FOM) {
					prefix = "frm_t1_";
					fom_cd = "PRE";
				}
				// Arrival Word Information & Hour Information
				else {
					prefix = "frm_t2_";
					fom_cd = "ARR";
				}
				
				
				// Sheet Init
				if (sheetObjects[idx].RowCount == 0) 
				{
	    			with (sheetObjects[idx]) 
	    			{
	        			DataInsert(0);
	            		
	        			CellValue(1, "pkup_ntc_snd_tp_cd") = ntc_snd_tp_cd.value;
	        			CellValue(1, "ofc_cd")             = ofc_cd.value;
	        			CellValue(1, "del_cd")             = del_cd.value.trim() == "" ? "ALL" : del_cd.value;;        			
	        			CellValue(1, "pkup_ntc_seq")       = sheetObjects[SH_STUP].CellValue(1, "pkup_ntc_seq");
	        			CellValue(1, "pkup_ntc_fom_cd")    = fom_cd;
	        			CellValue(1, "eclz_obl_cpy_flg")   = "N";
	        			CellValue(1, "btm_rmk")            = "";
	    			}

	    			with (sheetObjects[idx+1]) 
	    			{
	        			for (var i=0; i<RowCount; i++) {
	            			CellValue(i+1, "pkup_ntc_snd_tp_cd") = ntc_snd_tp_cd.value;
	            			CellValue(i+1, "ofc_cd")             = ofc_cd.value;
	            			CellValue(i+1, "del_cd")             = del_cd.value.trim() == "" ? "ALL" : del_cd.value;;
	        				CellValue(i+1, "pkup_ntc_seq")       = "";
	        				CellValue(i+1, "pkup_ntc_fom_cd")    = fom_cd;
	        				CellValue(i+1, "ntc_seq")            = "";
	        				CellValue(i+1, "mvmt_sts_cd")        = "NA";
	        				CellValue(i+1, "ntc_cond_cd")        = "";
	        				CellValue(i+1, "ntc_bse_hrs")        = "";
	        			}
	    			}
				}
				
				// Hour Init
	    		with (sheetObjects[idx+1]) 
	    		{
	    			for (var i=0; i<RowCount; i++) {
	    				if (CellValue(i+1, "mvmt_sts_cd") == "NA") {
	    					CellEditable(i+1, "ntc_cond_cd") = false;
	    					CellEditable(i+1, "ntc_bse_hrs") = false;    				
	    				} else {
	    					CellEditable(i+1, "ntc_cond_cd") = true;
	    					if (CellValue(i+1, "ntc_cond_cd") == "AT") 
	    						CellEditable(i+1, "ntc_bse_hrs") = false;
	    					else CellEditable(i+1, "ntc_bse_hrs") = true;
	    				}
	    			}
	    		}
	    		
	    		
	        	IBS_CopyRowToForm(sheetObjects[idx], formObj, 1, prefix);
			}
			
    		resetSetupFlag();
    	}
    }
    
    
    /**
     * Form 데이터를 Sheet 로 복사한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function copyFormToRow() {
    	var formObj = document.form;
    
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_STUP], 1, "frm_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_PRE_FOM], 1, "frm_t1_");
    	IBS_CopyFormToRow(formObj, sheetObjects[SH_ARR_FOM], 1, "frm_t2_");    
    }
    
 
    /**
     * Sheet 의 Status를 U로 변경 <br>
     * 
     * @param {array} sheets 쉬트 배열 필수
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function setStatusFlag(sheets){
        for (var i=0;i<sheets.length;i++) {
        	for (var j=0;j<sheets[i].RowCount;j++) {
        		if(sheets[i].RowStatus(j+1) == "R") {
        			sheets[i].RowStatus(j+1) = "U";
        		}
        	}
        }
    }      
	

    /**
     * 조회 조건 변경 여부를 반환한다.<br>
     * 
     * @return boolean true: 조회조건 변경 됨, false:조회조건 변경 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function isChangedSearchKeyword() {
    	var formObj = document.form;

    	if (orgObj.ofc_cd  != formObj.ofc_cd.value) {
    		return true;
    	}
    	
    	if (orgObj.del_cd  != formObj.del_cd.value) {
    		return true;
    	}
    	
    	return false;
    }

    
    /**
     * 조회조건 변경여부를 체크하기 위하여 조회 조건 값을 저장해 둔다.<br>
     *
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function setSearchKeyword() {
    	var formObj = document.form;
    	
    	orgObj.ofc_cd = formObj.ofc_cd.value;
    	orgObj.del_cd = formObj.del_cd.value;
    	orgObj.del_cd_list = orgDelList;
    	
    	isRetrieved = true;
    }
    
    
    /**
     * 데이터 저장없이 임의로 변경된 조회 조건 값을 원상 복귀한다.<br>
     *
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function resetSearchKeyword() {
    	var formObj = document.form;
    	
    	formObj.ofc_cd.value  = orgObj.ofc_cd;
    	formObj.del_cd.value  = orgObj.del_cd;
    	
    	ComXml2ComboItem(orgObj.del_cd_list, formObj.del_cd_list, "val", "name");    	
    	
    	formObj.del_cd_list.Code = orgObj.del_cd;
    }
    
    /**
     * Flag 변경 발생 시, Flag 변경값에 따라 다른 Flag 들을 재설정한다.<br>
     *
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function resetSetupFlag() {
   	    var formObject = document.form;
   	 
		 if (formObject.frm_auto_ntc_flg.value == "Y" ) { // Auto
			 if (isNew == true) formObject.frm_each_foc_ntc_flg.value = "N";
			 formObject.frm_each_foc_ntc_flg.disabled = false;
			 formObject.frm_trkr_ntc_flg.disabled = false;
		 } else { // Manual
			 formObject.frm_each_foc_ntc_flg.disabled = true;
			 formObject.frm_trkr_ntc_flg.disabled = true;
		 }
    }

    
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
      * 
      * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
      * @param {object}  formObj  필수,HTML Form 오브젝트
      * @param {string}  sAction  필수,Action 명 
      * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
      * @author 박미옥
      * @version 2009.07.09
      */
    function validateForm(sheetObj,formObj,sAction) {
    	
        with(formObj) {
        	switch(sAction) {
        	case IBSEARCH_ASYNC01:
        		if (!ComChkObjValid(formObj.ofc_cd)) return false;
        		break;
        	case IBSEARCH:
    	    	// 기본체크-maxlength,필수입력 등 폼 전체 필드의 Validation 체크
  	    	    if (!ComChkObjValid(formObj.ofc_cd)) return false;
  	    	    if (!ComChkObjValid(formObj.del_cd)) return false;

    	    	break;
        	case IBSAVE:
    	    	if (!ComChkValid(formObj)) return false;
    	    	    	    	
    	    	if (checkMaxLine(formObj.frm_hd_tit_ctnt, 2) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_hd_tit_ctnt.getAttribute("caption"), "2");
    	    		formObj.frm_hd_tit_ctnt.focus();
    	    		return false;
    	    	}
    	    	
    	    	if (checkMaxLine(formObj.frm_t1_btm_rmk, 18) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_t1_btm_rmk.getAttribute("caption"), "18");
    	    		tabObjects[0].selectedIndex = 0;    	  
    	    		formObj.frm_t1_btm_rmk.focus();
    	    		return false;
    	    	}

    	    	if (checkMaxLine(formObj.frm_t2_btm_rmk, 18) == false) {
    	    		ComShowCodeMessage("BKG04012", formObj.frm_t2_btm_rmk.getAttribute("caption"), "18");
    	    		tabObjects[0].selectedIndex = 1;    
    	    		formObj.frm_t2_btm_rmk.focus();
    	    		return false;
    	    	}

    	    	for (var i=0; i<sheetObjects.length; i++) {
        			if (i == SH_PRE_HRS || i == SH_ARR_HRS) {
        				var sObj = sheetObjects[i];
        				
        				var dupRow = checkHourDupValue(sObj);
        				if (dupRow > 0) {
        		        	ComShowCodeMessage("BKG00488");
        		        	if (i == SH_PRE_HRS) tabObjects[0].selectedIndex = 0;
            				else tabObjects[0].selectedIndex = 1;
        		        	sObj.SelectCell(dupRow, "mvmt_sts_cd");
        		        	return false;
        		        }
        				
            			for(var j=0; j<sObj.RowCount; j++) {
                			if (sObj.CellValue(j+1, "mvmt_sts_cd") != "NA" && sObj.CellValue(j+1, "mvmt_sts_cd") != "") {
                				
                    			if (sObj.CellValue(j+1, "ntc_cond_cd") == "") {
                    				if (i == SH_PRE_HRS) tabObjects[0].selectedIndex = 0;
                    				else tabObjects[0].selectedIndex = 1;
                    				
                    				ComShowCodeMessage("BKG01101", "Condition");
                    				sObj.SelectCell(j+1, "ntc_cond_cd");
                    				return false;
                    			}
                    			
                    			if (sObj.CellValue(j+1, "ntc_bse_hrs") == "") {
                    				if (i == SH_PRE_HRS) tabObjects[0].selectedIndex = 0;
                    				else tabObjects[0].selectedIndex = 1;

                    				ComShowCodeMessage("BKG01101", "Time");
                    				sObj.SelectCell(j+1, "ntc_bse_hrs");
                    				return false;
                    			}
                			}
            			}
        			}
        		}
        		break;
        	}
        }

        return true;
    }
    
      
      
    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {string}  ErrMsg   선택,에러 메시지
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     	var formObject = document.form;

      	// 조회조건 저장
     	setSearchKeyword();
    }      

    
    /**
     * Hour 쉬트에 변경 발생 시, 변경값에 따라 Flag 셋팅한다.<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function changeHoursSetup(sheetObj, Row, Col, Value) {
    	with (sheetObj) {
    		if (ColSaveName(Col) == "mvmt_sts_cd") {
    			if (Value == "NA") {
    				CellValue(Row, "ntc_cond_cd") = "";
    				CellValue(Row, "ntc_bse_hrs") = "";
    				
    				CellEditable(Row, "ntc_cond_cd") = false;
					CellEditable(Row, "ntc_bse_hrs") = false; 
    			} else {
    				CellEditable(Row, "ntc_cond_cd") = true;
    				CellEditable(Row, "ntc_bse_hrs") = true;
    			}
    		} else if (ColSaveName(Col) == "ntc_cond_cd") {
    			if (Value == "AT") {
    				CellValue(Row, "ntc_bse_hrs")    = "0";
    				CellEditable(Row, "ntc_bse_hrs") = false;
    			} else {
    				CellEditable(Row, "ntc_bse_hrs") = true;
    			}
    		}
    	}
    }
       

    /**
     * Tab1 Sheet2 변경 이벤트 발생 처리<br>
     * 
     * @param {ibsheet} sheetObj 필수. Sheet ID
     * @param {int}     Row      필수. Sheet Row
     * @param {int}     Col      필수. Sheet Col
     * @param {string}  Value    필수. Sheet 셀값
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function t1sheet2_OnChange(sheetObj, Row, Col, Value) {
    	changeHoursSetup(sheetObj, Row, Col, Value);
    }

    
    /**
    * Tab2 Sheet2 변경 이벤트 발생 처리<br>
    * 
    * @param {ibsheet} sheetObj 필수. Sheet ID
    * @param {int}     Row      필수. Sheet Row
    * @param {int}     Col      필수. Sheet Col
    * @param {string}  Value    필수. Sheet 셀값
    * @return 없슴
    * @author 박미옥
    * @version 2009.07.09
    */
    function t2sheet2_OnChange(sheetObj,Row, Col, Value) {
    	changeHoursSetup(sheetObj, Row, Col, Value);
    }

    
    /**
     * DEL 콤보 Change 이벤트 발생 처리<br>
     * DEL CD 를 DEL 선택한 코드값으로 변경한다.<br>
     * 
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function del_cd_list_OnChange() {
    	var formObj = document.form;
    	if (!isAutoSelect) {
        	formObj.del_cd.value = formObj.del_cd_list.Code;
    	}
    }
    
    /**
     * DEL 콤보 Focus 이벤트 발생 처리<br>
     * 자동 선택여부를 false 로 셋팅한다.
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */
    function del_cd_list_OnFocus() {
    	isAutoSelect = false;
    }
    
    
    /**
     * Movement 쉬트에 중복값여부를 체크한다.
     * 
     * @param {ibsheet} sheetObj 필수. Sheet Object
     * @return int. 중복값이 발생한 Row
     * @author 박미옥
     * @version 2009.07.09
     */
    function checkHourDupValue(sheetObj) {
    	var str = "";
    	var dupRow = -1;

    	for(var i=0; i<sheetObj.RowCount; i++) {    		
    		if (sheetObj.CellValue(i+1, "mvmt_sts_cd") == "NA") continue;    		
    		for (var j=i+1; j<sheetObj.RowCount; j++) {
    			if (sheetObj.CellValue(i+1, "mvmt_sts_cd") == sheetObj.CellValue(j+1, "mvmt_sts_cd")) {
    				dupRow = j+1;
    				break;
    			}
    		}
    		
    		if (dupRow > 0) break;
    		
    	}
    	
    	return dupRow;
    }
    
    	
    /**
     * DEL 코드가 변경되면 DEL 콤보에 동일한 코드를 선택해준다.<br>
     * 
     * @param {object} obj      필수. DEL 객체 
     * @param {object} comboObj 필수. DEL Combo 객체
     * @return 없슴
     * @author 박미옥
     * @version 2009.07.09
     */	
	function fncFindDelComboCode(obj, comboObj) {
		var idx = -1;
		
		isAutoSelect = true;
		document.form.del_cd_list.UseCode = false;
		for(var i=0;i<comboObj.GetCount();i++){
			if(obj.value.trim() == comboObj.GetText(i,0).substring(0,obj.value.length)){
				idx = i;
				break;
			}
		}	
		document.form.del_cd_list.UseCode = true;
		
		if (idx > -1) comboObj.Index = idx;
	}
	
    /**
     * TextArea 라인 수를 제한한다.<br>
     * HTML태그(Object)의 onKeyPress 이벤트에서 이 함수를 호출할수 있으며, 라인수를 제어한다. <br>
     * 
     * <br><b>Example :</b>
     * <pre>
     *     &lt;input type="textarea" name="txtRmk" onKeyPress="checkMaxLine(this, 5)"&gt;
     * </pre>
     *  
     * @param {object} obj      필수,대상 HTML태그(Object)
     * @param {number} maxLine  필수,최대 Line 수
     * @return 없음 <br>
     * @author 박미옥
     * @version 2009.07.09
     */
    function checkMaxLine(obj, maxLine) {
        var ln = getLine(obj);

        if (event.keyCode == 13) {
            if (ln >= maxLine) {
            	return false;
            }
        } else {
            if (ln > maxLine) {
            	return false;
            }
        }
        
        return true;
    }
     
    /**
     * obj 객체값의 라인 개수를 반환한다.<br>
     * 객체의 최대 라인수를 제한하기 위해 이용된다.<br>
     * 
     * @param {object} obj 필수,대상 HTML태그(Object)
     * @return int. 라인 개수
     * @author 박미옥
     * @version 2009.07.09
     */
    function getLine(obj) {
//    	var borderH = (obj.offsetHeight - obj.clientHeight) / 2;
//    	var lineC = (obj.scrollHeight - borderH) / ((obj.clientHeight - borderH) / obj.rows);
//    	 
//    	return Math.round(lineC);

        var str_len = obj.value;
        line = str_len.split("\r\n");
        return line.length;
    }
         
	/* 개발자 작업  끝 */