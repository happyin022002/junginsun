/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4005.js
*@FileTitle : Note Conversion Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.05.06 전윤주
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
     * @class ESM_PRI_4005 : ESM_PRI_4005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4005() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    
    /* 개발자 작업   */
    // 공통전역변수
   
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        
        /*******************************************************/
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");            
            switch(srcName) {              
                case "btn_add":
                    doActionIBSheet(sheetObjects[1], formObject, IBINSERT);
                    break;
                    
                case "btn_del":
                    doActionIBSheet(sheetObjects[1], formObject, IBDELETE);
                    break;                    
                    
                case "btn_add2":
                    doActionIBSheet(sheetObjects[2], formObject, IBINSERT);
                    break;
                    
                case "btn_del2":
                    doActionIBSheet(sheetObjects[2], formObject, IBDELETE);
                    break;      
    
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
                    break;
    
                case "btn_new":
                	doActionIBSheet(sheetObjects[1], formObject, IBCLEAR);
                    break;

                case "btn_save":
                    doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
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
    
    function initControl() {
    	formObj = document.form;
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
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
     * @author 이승준
     * @version 2009.04.17
     */ 
    function setSheetObject(sheet_obj){
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
     * @author 이승준
     * @version 2009.04.17
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
     * @author 이승준
     * @version 2009.04.17
     */
    function loadPage() {
    	 for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);            
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);   
        }

        //IBMultiCombo초기화
        for(var k = 0; k < comboObjects.length; k++){
            initCombo(comboObjects[k], k + 1);
        }
        initIBComboItem();
        comboObjects[0].focus();
     }
    
    /**
     * IBSHEET COMBO를 LOAD하는 함수<br>
     * <br><b>Example :</b>
     * <pre>
     * 		initCombo(comboObj, comboNo)
     * </pre>
     * @return 없음
     * @author 이승준
     * @version 2009.06.10
     */ 
    function initCombo(comboObj, comboNo) {
        switch(comboObj.id) {
            case "prc_ctrt_tp_cd":
                var i=0;
                with(comboObj) {
                	DropHeight = 100;
                    UseAutoComplete = true;
                    ValidChar(2, 0);    // 영문대문자만 입력
                    MaxLength = 1;      // 1자리만 입력
                }
                break;               
        }
    }  
    
    /**
     * comboObjects[0]의 code값을 리턴<br>
     * <br><b>Example :</b>
     * <pre>
     * 		var code = getPrcCtrtTpCd();
     * </pre>
     * @return String <br>
     * @author 이승준
     * @version 2009.06.10
     */ 
    function getPrcCtrtTpCd() {
        return comboObjects[0].Code;
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
     * @author 이승준
     * @version 2009.04.17
     */ 
     function initSheet(sheetObj,sheetNo) {
         var cnt = 0;
         var sheetID = sheetObj.id;
         switch(sheetID) {
         
            case "sheet0":      //hidden 
                 with (sheetObj) {
                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "")
                        InitHostInfo(location.hostname, location.port, page_path);                                            
                 }
                 break; 
         
            case "sheet1":      //sheet1 init
                 with (sheetObj) {

                    // 높이 설정
                     style.height = 438;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Seq.|Group Code|Description|Creation Date|prc_ctrt_tp_cd";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,      "ibflag");
                     InitDataProperty(0, cnt++,  dtDummyCheck,   40,    daCenter,   false,      "chk");
                     InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,      "Seq");
                     InitDataProperty(0, cnt++ , dtData,         100,   daCenter,   false,     "note_conv_grp_loc_cd",   true,   "",  dfNone,  0, false, true,4,true);
                     InitDataProperty(0, cnt++ , dtData,         200,   daLeft,     false,      "note_conv_grp_loc_desc", true,   "",  dfNone,  0, true, true,100);
                     InitDataProperty(0, cnt++ , dtData,         50,    daCenter,   false,      "cre_dt",                 false,  "",  dfNone,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,      "prc_ctrt_tp_cd",         false,  "",  dfNone,  0, false, false);

                     //2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
	 				 InitDataValid(0, "note_conv_grp_loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 

                }
                 break;

            case "sheet2":      //sheet2 init
                 with (sheetObj) {

                    // 높이 설정
                     style.height = 438;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel.|Seq.|Location Code|Description|Update Date|prc_ctrt_tp_cd|note_conv_grp_loc_cd";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,   false,     "ibflag");
                     InitDataProperty(0, cnt++,  dtDummyCheck,   40,    daCenter,   false,     "chk");
                     InitDataProperty(0, cnt++ , dtSeq,          30,    daCenter,   false,     "Seq");
                     InitDataProperty(0, cnt++ , dtPopupEdit,    100,   daCenter,   false,     "loc_cd",                true,    "",  dfNone,     0,  false,  true, 5);
                     InitDataProperty(0, cnt++ , dtData,         200,   daLeft,     false,     "loc_des",              false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++ , dtData,         70,    daCenter,   false,     "upd_dt",               false,   "",  dfDateYmd,  0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "prc_ctrt_tp_cd",       false,   "",  dfNone,     0, false, false);
                     InitDataProperty(0, cnt++,  dtHidden,       90,    daLeft,     false,     "note_conv_grp_loc_cd", false,   "",  dfNone,     0, false, false);

                     InitDataValid(0, "loc_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
                     ShowButtonImage = 2;
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
      * @author 이승준
      * @version 2009.04.17
      */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
         
            case IBCLEAR:
            	if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
            		if (ComShowCodeConfirm("PRI00006")) {
                    supressConfirm = true;
                    doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
                    supressConfirm = false;
	                } else {
	                    comboObjects[0].Index = "-1";
	                    
	                    formObj.reset();
	                    sheetObjects[1].RemoveAll();
	                    sheetObjects[2].RemoveAll();
	                    comboObjects[0].focus();
	                }
	            } else {  
	                comboObjects[0].Index = "-1";
	 	                
	                formObj.reset();
	                sheetObjects[1].RemoveAll();
	                sheetObjects[2].RemoveAll();
	                comboObjects[0].focus();              
	            }
                break;       
            
            case IBSEARCH:      //조회            	
            	try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
                    if (validateForm(sheetObj,document.form,sAction)) {
                    	ComOpenWait(true);
                        if (sheetObj.id == "sheet1") {                            
                            for (var i = 0; i < sheetObjects.length; i++) {
                                sheetObjects[i].RemoveAll();
                            }    
                            
                            formObj.f_cmd.value = SEARCH01;
                            sheetObj.DoSearch("ESM_PRI_4005GS.do", FormQueryString(formObj));
                        }       
                        else if ( sheetObj.id == "sheet2") {
                            formObj.f_cmd.value = SEARCH02;
                            sheetObj.DoSearch("ESM_PRI_4005GS.do", FormQueryString(formObj));
                        }
                    }
		            ComOpenWait(false);					
				 } catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e);
     	            }
     	       } finally {
     	    	   ComOpenWait(false);
     	       }	
     	       
                break;

            case IBSAVE:        //저장            
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }                    
                eventStatus = "IBSAVE";                
                formObj.f_cmd.value = MULTI01;
                        
                var sParam = FormQueryString(formObj);
                var sParamSheet1 = sheetObjects[1].GetSaveString();                     
                if (sheetObjects[1].IsDataModified && sParamSheet1 == "") {
                    return;
                }                    
                sParam += "&" + ComPriSetPrifix(sheetObjects[1].GetSaveString(), "sheet1_");
                    
                var sParamSheet2 = sheetObjects[2].GetSaveString();                 
                if (sheetObjects[2].IsDataModified && sParamSheet2 == "") {
                    return;
                }                    
                sParam += "&" + ComPriSetPrifix(sheetObjects[2].GetSaveString(), "sheet2_");                                
                if (!supressConfirm && !ComPriConfirmSave()) {
                    return false;
                }                   
                
                try {
     			    for (var i = 0; i < sheetObjects.length; i++) {
					 	sheetObjects[i].WaitImageVisible = false;
				    }
				    ComOpenWait(true);
               
	                var sXml = "";
                    sXml = sheetObj.GetSaveXml("ESM_PRI_4005GS.do", sParam);
	                sheetObjects[2].LoadSaveXml(sXml);
	                sheetObjects[1].LoadSaveXml(sXml);                    
	                ComOpenWait(false);
					
				} catch (e) {
     	            if (e == "[object Error]") {
     	                ComShowMessage(OBJECT_ERROR);
     	            } else {
     	                ComShowMessage(e);
     	            }
     	        } finally {
     	    	    ComOpenWait(false);
     	        }	
                    
                if (sheetObjects[1].IsDataModified || sheetObjects[2].IsDataModified) {
                    return false;
                } else {
                    ComPriSaveCompleted();
                    if (getValidRowCount(sheetObjects[1]) >= 1 && getValidRowCount(sheetObjects[2]) <= 0) {
                        doRowChange(sheetObjects[1], sheetObjects[2], -1, sheetObjects[1].SelectRow, sheetObjects[1].SelectCol, sheetObjects[1].SelectCol, false);
                    }
                    return true;
                }
                
                eventStatus = "";
                doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
                break;                 
        
            case IBINSERT: // Row Add
                if (validateForm(sheetObj,document.form,sAction)) {
                    if (sheetObj.id == "sheet1") {          
                        var idx = doRowChange(sheetObj, sheetObjects[2], sheetObj.SelectRow, sheetObj.SelectRow + 1, sheetObj.SelectCol, sheetObj.SelectCol, true);
                        if (idx < 0) {
                            return false;
                        }
                        //contract type
                        sheetObj.CellValue(idx, "prc_ctrt_tp_cd")     = getPrcCtrtTpCd();                       
                        sheetObjects[2].RemoveAll();                        
                        sheetObj.SelectCell(idx,"note_conv_grp_loc_cd");
                    }
                    if (sheetObj.id == "sheet2") {
                        var idx = sheetObj.DataInsert(-1);
                        sheetObj.CellValue(idx, "prc_ctrt_tp_cd")        = getPrcCtrtTpCd();  
                        sheetObj.CellValue(idx, "note_conv_grp_loc_cd")  = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_grp_loc_cd");
                        sheetObj.SelectCell(idx,"loc_cd");
                    }
                }
                break;
                
            case IBDELETE: // Delete                
                if (!validateForm(sheetObj,document.form,sAction)) {
                    return false;
                }                
                if (sheetObj.CheckedRows("chk") <= 0) {
                    sheetObj.CellValue(sheetObj.SelectRow, "chk") = "1";
                }
                var delCnt = deleteRowCheck(sheetObj, "chk");
                if (delCnt > 0 && sheetObj.id == "sheet1") {
                    for (var i = sheetObjects[2].HeaderRows; sheetObjects[2].RowCount > 0 && i <= sheetObjects[2].LastRow; i++) {
                        sheetObjects[2].CellValue(i, "chk") = "1";
                    }
                    deleteRowCheck(sheetObjects[2], "chk");
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
     * @author 이승준
     * @version 2009.04.17
     */
     function validateForm(sheetObj,formObj,sAction){
          switch (sAction) {          
            case IBSEARCH: // 조회                
                if (comboObjects[0].Code == "") {
                	ComShowCodeMessage("PRI00308", "select", "contract type");
                	comboObjects[0].focus();
                    return false;                
                }
                return true;
                break;
        
            case IBSAVE: // 저장
                if (comboObjects[0].Code == "") {
                	ComShowCodeMessage("PRI00308", "select", "contract type");
                	comboObjects[0].focus();
                    return false;
                }
                
                if (!sheetObjects[1].IsDataModified && !sheetObjects[2].IsDataModified) {
                    ComShowCodeMessage("PRI00301");
                    return false;
                }         
                
                if (sheetObjects[1].IsDataModified && sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_grp_loc_cd") == "") {
                   	ComPriInputValueFailed("input","Group Code","");
   					return false;
    			} 
                
                if (sheetObjects[1].IsDataModified ) {
                     var rowM = sheetObjects[1].ColValueDup("prc_ctrt_tp_cd|note_conv_grp_loc_cd",false);
                     if (rowM >= 0) {
                         ComShowCodeMessage("PRI00303", "Sheet", rowM);
                         return false;
                    }               
                }               
                
                if (sheetObjects[2].IsDataModified ) {
                     var rowD = sheetObjects[2].ColValueDup("prc_ctrt_tp_cd|note_conv_grp_loc_cd|loc_cd",false);
                     if (rowD >= 0) {
                         ComShowCodeMessage("PRI00303", "Sheet", rowD);
                         return false;
                    }               
                }
            
                //sheet1에서 하나라도 저장했는지 체크
                if (sheetObjects[1].RowCount <= 0 || sheetObjects[1].SelectRow <= 0) {
                    ComPriInputValueFailed("input","Group Code","");
                    doActionIBSheet(sheetObjects[1], document.form, IBINSERT);
                    return false;
                }
                
                //sheet2에서 하나라도 저장했는지 체크
//                if (getValidRowCount(sheetObjects[1]) >= 1 && (sheetObjects[2].RowCount <= 0 || sheetObjects[2].SelectRow <= 0)) {
//                    ComShowCodeMessage("PRI00319", "Location Type");
//                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
//                    return false;
//                }
                
                if (!isDeleted(sheetObjects[1]) && getValidRowCount(sheetObjects[2]) <= 0 
                	&& sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_grp_loc_cd") != "") {
                	ComShowCodeMessage("PRI00319", "Location Group");
                    doActionIBSheet(sheetObjects[2], document.form, IBINSERT);
					return false;
				}                
                return true;
                break;
                
            case IBINSERT: // Row Add
            	if (comboObjects[0].Code == "") {
                	ComShowCodeMessage("PRI00308", "select", "contract type");
                	comboObjects[0].focus();
                    return false;
                } 
            	
            	 if (sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "note_conv_grp_loc_cd") == "") {
                     ComPriInputValueFailed("input","Group Code","");
                     return false;
                 }
            	
                return true;
                break;
                
            
            case IBDELETE: // Delete
            	if (comboObjects[0].Code == "") {
                	ComShowCodeMessage("PRI00303", "select", "contract type");
                    return false;
                }               
                return true;
                break;
            }

         return true;
     }
     
    /**
      * Open 시에 조회한 Combo Item 을 IBMultiCombo 에 셋팅한다.<br>
    */
    function initIBComboItem() {    	
        ComPriTextCode2ComboItem(ctrtTpCdComboValue,   ctrtTpCdComboText,   getComboObject(comboObjects, 'prc_ctrt_tp_cd'), "|", "\t" );
    }   
    
    
    /**
     * IBCombo에서 OnChange 이벤트 발생시 호출되는 function <br>
     * chg_cd 콤보에서 값을 변경하면 선택한 값에 대한 description을 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {object} comboObj 필수 IBMultiCombo Object
     * @param {string} code 필수 선택된 항목의 value
     * @param {string} text 필수 선택된 항목의 text
     * @returns 없음
     * @author 이승준
     * @version 2009.07.20
     */
    function prc_ctrt_tp_cd_OnChange (comboObj, code, text) {
        var formObj = document.form;
        if (text != null && !ComIsEmpty(text)) {         
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
        }
    }


       /**
        * OnPopupClick 이벤트 발생시 호출되는 function <br>
        * Location PopUp을 호출한다. <br>
        * <br><b>Example :</b>
        * <pre>
        *
        * </pre>
        * @param {ibsheet} sheetObj 필수 IBSheet Object
        * @param {int} Row 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Row Index
        * @param {int} Col 필수 OnPopupClick 이벤트가 발생한 해당 셀의 Column Index
        * @return 없음
        * @author 공백진
        * @version 2009.04.17
        */               
        function sheet2_OnPopupClick(sheetObj, Row, Col){
            var colName = sheetObj.ColSaveName(Col);
            var formObj = document.form;
            
            switch(colName){
                case "loc_cd":
                    var sUrl = "/hanjin/ESM_PRI_4026.do";
                    var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
                    if (rtnVal != null){
                        sheetObj.CellValue2(Row, Col) = rtnVal.cd;
                        sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;        
                    }
                    break;
            }
        }   
        
        /**
         * sheet에서 데이터가 변경시 호출된다. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function sheet1_OnChange(sheetObj, Row, Col, Value) {
    		var formObj = document.form;
    		var sName = sheetObj.ColSaveName(Col);    		
    		if (sName == "note_conv_grp_loc_cd") {
    			if (Value != "" && Value.length != 4) {
    				sheetObj.CellValue2(Row, "note_conv_grp_loc_cd") = "";
    				sheetObj.SelectCell(Row, "note_conv_grp_loc_cd", true);
    			}
    		}
    	}

        /**
         * sheet에서 데이터가 변경시 호출된다. <br>
         * <br><b>Example :</b>
         * <pre>
         *    
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 
         * @param {int} Col 
         * @param {String} Value 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function sheet2_OnChange(sheetObj, Row, Col, Value){
            var colname = sheetObj.ColSaveName(Col);  
            var formObj = document.form
            switch(colname)
            {
                case "loc_cd":
                    if(Value.length==5){
                        formObj.f_cmd.value = SEARCH05;
                        formObj.cd.value=sheetObj.Cellvalue(Row,Col);   
                        //sheetObj.WaitImageVisible = false; // 처리 중 대기 이미지를 표시하지 않도록 설정한다.
                        var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj)); 
                        var arrData = ComPriXml2ComboString(sXml, "cd", "nm");                  
                        if (arrData != null && arrData.length > 0 && !ComIsEmpty(arrData[1])) {
                            sheetObj.CellValue2(Row,"loc_des") = arrData[1];
                        }else{      
                            locationCellClear(sheetObj,Row);
                        }           
                    }
                    else{
                        locationCellClear(sheetObj,Row);
                    }
                    break;                   
            }
        }  
        
        
        /**
         * sheet의 특정 cell의 값을 빈칸으로 초기화하는 function <br>
         * <br><b>Example :</b>
         * <pre>
         *      locationCellClear(sheetObj,Row)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} Row 필수 값을 초기화할 해당 셀의 Row Index  
         * @return 없음
         * @author 공백진
         * @version 2009.04.17
         */         
        function locationCellClear(sheetObj,Row){
            sheetObj.CellValue2(Row,"loc_cd")= "";
            sheetObj.CellValue2(Row,"loc_des")= "";
            sheetObj.SelectCell(Row,"loc_cd");
        }
        
        /**
         * sheet에서 cell을 클릭한 경우 발생. <br>
         * <br><b>Example :</b>
         * <pre>
         *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
            doRowChange(sheetObjects[1], sheetObjects[2], OldRow, NewRow, OldCol, NewCol, false);
        }
        
        var isFiredNested = false;
        var supressConfirm = false;
    
        /**
         * sheet1_OnSelectCell 이벤트 발생시 호출됨. <br>
         * 데이타를 변경한 경우 새로운 셀 선택 시 저장 메세지 호출 <br>
         * 저장을 하지 않으면 변경한 셀로 포커스를 강제 이동시킴.<br>
         * 
         * <br><b>Example :</b>
         * <pre>
         *     doRowChange(OldRow, NewRow, OldCol, NewCol, sAction)
         * </pre>
         * @param {ibsheet} sheetObj 필수 IBSheet Object
         * @param {int} OldRow 
         * @param {int} OldCol 
         * @param {int} NewRow 
         * @param {int} NewCol 
         * @param {String} sAction
         * @return 없음
         * @author 이승준
         * @version 2009.04.17
         */
        function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
            var formObj = document.form;
            var adjNewRow = NewRow;
            if (!isFiredNested && (OldRow != NewRow)) {
                if (sheetM.IsDataModified) {
                    isFiredNested = true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    if (validateForm(sheetM,document.form,IBSAVE)) {
                        isFiredNested = true;
                        sheetM.SelectCell(NewRow, NewCol, false);
                        isFiredNested = false;
                    } else {
                        isFiredNested = true;
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested = false;
                        return -1;
                    }
                }
                if (sheetD.IsDataModified) {
                    isFiredNested = true;
                    sheetM.SelectCell(OldRow, OldCol, false);
                    isFiredNested = false;
                    
                    var rslt = false;
                    if (ComShowCodeConfirm("PRI00006")) {
                        supressConfirm = true;
                        adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows);
                        var rslt = doActionIBSheet(sheetM,document.form,IBSAVE);
                        supressConfirm = false;
                    }
                    if (rslt) {
                        isFiredNested = true;
                        sheetM.SelectCell(adjNewRow, NewCol, false);
                        isFiredNested = false;
                    } else {
                        isFiredNested = true;
                        sheetM.SelectCell(OldRow, OldCol, false);
                        isFiredNested = false;
                        return -1;
                    }
                }
                if (appendRow) {
                    isFiredNested = true;
                    var idx = sheetM.DataInsert(-1);
                    isFiredNested = false;
                    return idx;
                } else {                    
                    formObj.f_cmd.value = SEARCH02;
                    formObj.note_conv_grp_loc_cd.value = sheetM.CellValue(NewRow,"note_conv_grp_loc_cd");
                    if(formObj.note_conv_grp_loc_cd.value == "undefined" || ComIsEmpty(formObj.note_conv_grp_loc_cd.value)) {
                        formObj.note_conv_grp_loc_cd.value = sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"note_conv_grp_loc_cd");
                    }
                    
                    try {
         			  	ComOpenWait(true);
	                    sheetD.DoSearch("ESM_PRI_4005GS.do", FormQueryString(formObj));	                    
	                    ComOpenWait(false);
						
   				   } catch (e) {
         	            if (e == "[object Error]") {
         	                ComShowMessage(OBJECT_ERROR);
         	            } else {
         	                ComShowMessage(e);
         	            }
         	       } finally {
         	    	   ComOpenWait(false);
         	       }	
                } 
            }
        }
        
        /**
	     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
	     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {String} Row 
	     * @param {String} Col 
	     * @return 없음
	     * @author 이승준
	     * @version 2009.04.17
	     */
        function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
            var colName = sheetObj.ColSaveName(Col);

            if (colName == "chk") {
                ComPriCheckWithPnS(sheetObjects.slice(1, 3), 0, Row, Col);
            }
        }
        /**
	     * sheet에서 체크 버튼을 클릭하기 전에 발생한다. <br>
	     * CheckBox를 선택했을때, 하위 sheet를 모두 check하고, 전체에서 1개가 해제된 상태라면 상위 check를 풀어준다. <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *     
	     * </pre>
	     * @param {ibsheet} sheetObj 필수 IBSheet Object
	     * @param {String} Row 
	     * @param {String} Col 
	     * @return 없음
	     * @author 이승준
	     * @version 2009.04.17
	     */
        function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
            var colName = sheetObj.ColSaveName(Col);

            if (colName == "chk") {
                ComPriCheckWithPnS(sheetObjects.slice(1, 3), 1, Row, Col);
            }
        } 
        

    /* 개발자 작업  끝 */