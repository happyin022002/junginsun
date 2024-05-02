
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_9123.js
*@FileTitle : Change Session
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.08.05 송민석
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
     * @extends Pri
     * @class ESM_PRI_9123 : ESM_PRI_9123 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_9123 () {
        this.processButtonClick = tprocessButtonClick;
        this.setSheetObject = setSheetObject;
        this.loadPage = loadPage;
        this.initSheet = initSheet;
        this.initControl = initControl;
        this.doActionIBSheet = doActionIBSheet;
        this.setTabObject = setTabObject;
        this.validateForm = validateForm;
    }

    /* 개발자 작업   */


    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

 
        /*******************************************************/
        var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_change":
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                    break;

            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
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
     * @param {ibsheet} sheet_obj 필수, IBSheet Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * IBMultiCombo Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setComboObject(combo_Obj);
     * </pre>
     * @param {ibcombo} combo_obj 필수, IBMultiCombo Object
     * @return 없음
     * @author 문동규
     * @version 2009.08.17
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
     * @author 문동규
     * @version 2009.08.17
     */
    function loadPage() {
        try {
            for(i=0;i<sheetObjects.length;i++){
                // khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet (sheetObjects[i] );
                initSheet(sheetObjects[i],i+1);
                // khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
    
            var formObj = document.form;
            initGridData();
            
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }

    /**
     * Grid의 값을 초기화 한다..<br>
     * <br><b>Example :</b>
     * <pre>
     *     initGridData ();
     * </pre>
     * @return 없음
     * @author 송민석
     * @version 2011.08.08
     */
    function initGridData () {
    	 var row = sheetObjects[0].DataInsert(0);
    	 sheetObjects[0].CellValue2(row,"curr_usr_id") = strUsr_id;
    	 sheetObjects[0].CellValue2(row,"curr_usr_nm") = strUsr_nm;
    	 sheetObjects[0].CellValue2(row,"curr_ofc_cd") = strOfc_cd;
    	 sheetObjects[0].RowStatus(row) = "R";
    }
   
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수, IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 송민석
     * @version 2011.08.08
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
 
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 100;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Status|From\nUser ID|From\nUser Name|From\nUser Office Code|To\nUser ID|To\nUser PWD|To\nUser Name|To\nUser Office Code|To\nSales Rep.";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,  0,    daCenter,    false,   "ibflag");
                    InitDataProperty(0, cnt++ , dtData,          90,   daLeft,      true,    "curr_usr_id",      false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          110,  daLeft,      true,    "curr_usr_nm",      false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          110,  daLeft,      true,    "curr_ofc_cd",  false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          90,   daCenter,    false,   "usr_id",  true,  "",  dfNone,     0, true,  true);
                    InitDataProperty(0, cnt++ , dtData,          110,   daCenter,    false,   "usr_pwd",  true,  "",  dfNone,     0, true,  true);                    
                    InitDataProperty(0, cnt++ , dtData,          110,   daCenter,    false,   "usr_nm",      false,  "",  dfNone,  0, false,  false);                    
                    InitDataProperty(0, cnt++ , dtData,          110,   daLeft,      false,   "ofc_cd",  false,  "",  dfNone,     0, false,  false);
                    InitDataProperty(0, cnt++ , dtData,          110,   daLeft,      false,   "srep_cd",  false,  "",  dfNone,     0, false,  false);
                    
                    WaitImageVisible = false;
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
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @return 없음
     * @author 송민석
     * @version 2011.08.08
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH_ASYNC01:  
            	if (validateForm(sheetObj,formObj,sAction)) {
	                formObj.f_cmd.value = SEARCH02;
	                var iframe = document.getElementById("changeIframe");
	                
	                var SaveStr = sheetObj.GetSaveString(false);
	
	                iframe.contentWindow.location.href= "ESM_PRI_9123.do?"+FormQueryString(formObj)+"&"+SaveStr;
	//                sheetObj.DoSave("ESM_PRI_9123GS.do", FormQueryString(formObj), -1, false);
	                
	//                var SaveStr = sheetObj.GetSaveString(false);
	//                if (validateForm(sheetObj,formObj,sAction)) {
	//	                var sXml = sheetObj.GetSearchXml("ESM_PRI_9123GS.do", FormQueryString(formObj)+"&"+SaveStr);
	//	                alert(sXml);
	//                }
            	}
                break;
            case IBSEARCH:      //조회
                ComOpenWait(true);
                //if (validateForm(sheetObj,formObj,sAction)) {
                      formObj.f_cmd.value = SEARCH01;
                     var SaveStr = "usr_id="+sheetObj.CellValue(1,"usr_id");
                     var xmlStr = sheetObj.GetSearchXml("ESM_PRI_9123GS.do",FormQueryString(formObj)+"&"+SaveStr);
                     var arr = ComPriXml2Array(xmlStr, "usr_id|usr_nm|ofc_cd|srep_cd"); 
                      if( arr != undefined){
                    	 sheetObj.CellValue2(1,"usr_id") =arr[0][0];
                    	 sheetObj.CellValue2(1,"usr_nm") = arr[0][1];
                    	 sheetObj.CellValue2(1,"ofc_cd") = arr[0][2];
                    	 sheetObj.CellValue2(1,"srep_cd") = arr[0][3];
                     	
                     }else{
                    	 ComShowMessage("There is no user.");
                    	 sheetObj.CellValue2(1,"usr_id") = "";
                    	 sheetObj.CellValue2(1,"usr_nm") = "";
                    	 sheetObj.CellValue2(1,"ofc_cd") = "";
                    	 sheetObj.CellValue2(1,"srep_cd") = "";
                     }

                     
                     //sheetObj.DoSearch("ESM_PRI_9123GS.do", FormQueryString(formObj)+"&"+SaveStr);
 
              //  }
                ComOpenWait(false);
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
     * @param {ibsheet} sheetObj 필수, IBSheet Object
     * @param {form} formObj 필수, html form object
     * @param {int} sAction 필수, 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author  송민석
     * @version 2011.08.08
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction){

            case IBSEARCH_ASYNC01:
                 if (sheetObj.CellValue(1,"usr_id") == "") {
                    ComShowCodeMessage('PRI01001');
                    sheetObj.SelectCell(1, "usr_id");
                    return false;
                }
                 if (sheetObj.CellValue(1,"usr_pwd") == "") {
                     ComShowCodeMessage('PRI01001');
                     sheetObj.SelectCell(1, "usr_pwd");
                     return false;
                 }                 
                break;
        }

        return true;
    }
  

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
     * 입력된 ID의 정보를 조회함 <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj 필수, HTML태그(Object) 오브젝트
     * @param {int} Row 필수, Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param {int} Col 필수, Onclick 이벤트가 발생한 해당 셀의 Column Index
     * @param {string} Value 필수, 이벤트가 발생한 해당 셀의 Value
     * @returns 없음
     * @author 송민석
     * @version 2011.08.08
     */
    function sheet1_OnChange (sheetObj, Row, Col, Value) {
        try {
            var colname = sheetObj.ColSaveName(Col);
    
            switch(colname) {
                case "usr_id":
                    var formObj = document.form;
                    
//                    formObj.ofc_cd.value = sheetObj.CellValue(Row, "ofc_cd");
//                    doActionIBSheet(sheetObjects[2],formObj,IBSEARCH_ASYNC01);
                    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
                    break;
    
            }
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
            ComOpenWait(false);
        }
    }
     
     function callbackFunction(flg,msg){
    	 if( flg == "Y"){
	    	 var sheetObj = sheetObjects[0];
	    	 sheetObj.CellValue2(1,"curr_usr_id") = sheetObj.CellValue(1,"usr_id") ;
	    	 sheetObj.CellValue2(1,"curr_usr_nm") = sheetObj.CellValue(1,"usr_nm") ;
	    	 sheetObj.CellValue2(1,"curr_ofc_cd") = sheetObj.CellValue(1,"ofc_cd") ;
	
	    	 sheetObj.CellValue2(1,"usr_id") = "";
	    	 sheetObj.CellValue2(1,"usr_pwd") = "";	    	 
	    	 sheetObj.CellValue2(1,"usr_nm") = "";
	    	 sheetObj.CellValue2(1,"ofc_cd") = "";
	    	 sheetObj.CellValue2(1,"srep_cd") = "";    
	    	 sheetObj.RowStatus(1) = "R";
    	 }

    	 ComShowMessage(msg);
     }

   
    /* 개발자 작업  끝 */