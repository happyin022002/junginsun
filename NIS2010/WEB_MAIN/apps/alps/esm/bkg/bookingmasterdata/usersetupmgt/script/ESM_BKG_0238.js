/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0238.js
 *@FileTitle : Queue Summary
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.05.30
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.05.30 김상수
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
     * @extends
     * @class esm_bkg_0238  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0238() {
        this.processButtonClick = trocessButtonClick;
        this.setSheetObject     = setSheetObject;
        this.loadPage           = loadPage;
        this.initSheet          = initSheet;
        this.doActionIBSheet    = doActionIBSheet;
        this.setTabObject       = setTabObject;
        this.validateForm       = validateForm;
        this.setComboObject     = setComboObject;
    }


/* 개발자 작업  */


// 공통전역변수
var comboCnt = 0;
var comboObjects = new Array();

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick  = processButtonClick;


    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
        var frmObj = document.form;
        var srcName = window.event.srcElement.getAttribute("name");

        try {
            switch (srcName) {
            	
                case "btn_Retrieve":
                    sheetObjects[0].RemoveEtcData();
                    sheetObjects[1].RemoveEtcData();
                    sheetObjects[2].RemoveEtcData();
                    sheetObjects[3].RemoveEtcData();
                    sheetObjects[4].RemoveEtcData();
                    sheetObjects[5].RemoveEtcData();
                    sheetObjects[6].RemoveEtcData();
                    sheetObjects[7].RemoveEtcData();
                    sheetObjects[8].RemoveEtcData();
                    sheetObjects[9].RemoveEtcData();
                    doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
                    break;

                case "btn_New":
                    sheetObjects[0].RemoveEtcData();
                    sheetObjects[1].RemoveEtcData();
                    sheetObjects[2].RemoveEtcData();
                    sheetObjects[3].RemoveEtcData();
                    sheetObjects[4].RemoveEtcData();
                    sheetObjects[5].RemoveEtcData();
                    sheetObjects[6].RemoveEtcData();
                    sheetObjects[7].RemoveEtcData();
                    sheetObjects[8].RemoveEtcData();
                    sheetObjects[9].RemoveEtcData();
                    ComResetAll();
                    break;                    
                    
                case "btn_RowAdd_sheet1":
    				var newRow = sheetObjects[0].DataInsert(-1);
    				sheetObjects[0].CellValue(newRow, "chk_pnt_tp_cd") = "CU";
    				break;   
    				
                case "btn_RowAdd_sheet11":
                	if(!ComIsEmpty(sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"chk_pnt_itm_seq"))){
	    				var newRow = sheetObjects[1].DataInsert(-1);
	    				sheetObjects[1].CellValue(newRow, "chk_pnt_tp_cd") = "CU";
	    				sheetObjects[1].CellValue(newRow, "chk_pnt_itm_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow ,"chk_pnt_itm_seq");
                	} else {
                		ComShowMessage("Please save first "); return;
                	}
    				break; 
    				
                case "btn_RowAdd_sheet2":
     				var newRow = sheetObjects[2].DataInsert(-1);
     				sheetObjects[2].CellValue(newRow, "chk_pnt_tp_cd") = "CN";
     				break; 
     			
                case "btn_RowAdd_sheet21":
                	if(!ComIsEmpty(sheetObjects[2].CellValue(sheetObjects[2].SelectRow ,"chk_pnt_itm_seq"))){
	    				var newRow = sheetObjects[3].DataInsert(-1);
	    				sheetObjects[3].CellValue(newRow, "chk_pnt_tp_cd") = "CN";
	    				sheetObjects[3].CellValue(newRow, "chk_pnt_itm_seq") = sheetObjects[2].CellValue(sheetObjects[2].SelectRow ,"chk_pnt_itm_seq");
                	} else {
                		ComShowMessage("Please save first "); return;
                	}
    				break; 
     				
     			case "btn_RowAdd_sheet3":
     				var newRow = sheetObjects[4].DataInsert(-1);
     				sheetObjects[4].CellValue(newRow, "chk_pnt_tp_cd") = "MD";
     				break;   
     				
     			case "btn_RowAdd_sheet31":
                  	if(!ComIsEmpty(sheetObjects[4].CellValue(sheetObjects[4].SelectRow ,"chk_pnt_itm_seq"))){
  	    				var newRow = sheetObjects[5].DataInsert(-1);
  	    				sheetObjects[5].CellValue(newRow, "chk_pnt_tp_cd") = "MD";
  	    				sheetObjects[5].CellValue(newRow, "chk_pnt_itm_seq") = sheetObjects[4].CellValue(sheetObjects[4].SelectRow ,"chk_pnt_itm_seq");
                  	} else {
                  		ComShowMessage("Please save first "); return;
                  	}
      				break; 
     				
     			case "btn_RowAdd_sheet4":
     				var newRow = sheetObjects[6].DataInsert(-1);
     				sheetObjects[6].CellValue(newRow, "chk_pnt_tp_cd") = "CM";
     				break;  
     				
     			case "btn_RowAdd_sheet41":
                  	if(!ComIsEmpty(sheetObjects[6].CellValue(sheetObjects[6].SelectRow ,"chk_pnt_itm_seq"))){
  	    				var newRow = sheetObjects[7].DataInsert(-1);
  	    				sheetObjects[7].CellValue(newRow, "chk_pnt_tp_cd") = "CM";
  	    				sheetObjects[7].CellValue(newRow, "chk_pnt_itm_seq") = sheetObjects[6].CellValue(sheetObjects[6].SelectRow ,"chk_pnt_itm_seq");
                  	} else {
                  		ComShowMessage("Please save first "); return;
                  	}
      				break; 
      				
     			case "btn_RowAdd_sheet5":
     				var newRow = sheetObjects[8].DataInsert(-1);
     				sheetObjects[8].CellValue(newRow, "chk_pnt_tp_cd") = "EM";
     				break;  
     				
     			case "btn_RowAdd_sheet51":
                  	if(!ComIsEmpty(sheetObjects[8].CellValue(sheetObjects[8].SelectRow ,"chk_pnt_itm_seq"))){
  	    				var newRow = sheetObjects[9].DataInsert(-1);
  	    				sheetObjects[9].CellValue(newRow, "chk_pnt_tp_cd") = "EM";
  	    				sheetObjects[9].CellValue(newRow, "chk_pnt_itm_seq") = sheetObjects[8].CellValue(sheetObjects[8].SelectRow ,"chk_pnt_itm_seq");
                  	} else {
                  		ComShowMessage("Please save first "); return;
                  	}
      				break; 
     			
    			case "btn_RowDel_sheet1":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[0].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[0].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[0], "chk");
    				break;    	
    				
    			case "btn_RowDel_sheet11":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[1].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[1].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[1], "chk");
    				break;    		
     			
     			
     			case "btn_RowDel_sheet2":
     				if (!ComShowCodeConfirm("COM12188")) return;
     				var rCnt = sheetObjects[2].Rowcount+1;
     			    var chkCnt=0
     				for(i=1;i<rCnt;i++){
     					if(sheetObjects[2].CellValue(i, "chk") == 1){
     						chkCnt++	
     					}
     				}
     			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
     				ComRowHideDelete(sheetObjects[2], "chk");
     				break;    
     				
     			case "btn_RowDel_sheet21":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[3].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[3].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[3], "chk");
    				break;    
     				
     			case "btn_RowDel_sheet3":
     				if (!ComShowCodeConfirm("COM12188")) return;
     				var rCnt = sheetObjects[4].Rowcount+1;
     			    var chkCnt=0
     				for(i=1;i<rCnt;i++){
     					if(sheetObjects[4].CellValue(i, "chk") == 1){
     						chkCnt++	
     					}
     				}
     			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
     				ComRowHideDelete(sheetObjects[4], "chk");
     				break;
     				
     			case "btn_RowDel_sheet31":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[5].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[5].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[5], "chk");
    				break;    
     				
     			case "btn_RowDel_sheet4":
     				if (!ComShowCodeConfirm("COM12188")) return;
     				var rCnt = sheetObjects[6].Rowcount+1;
     			    var chkCnt=0
     				for(i=1;i<rCnt;i++){
     					if(sheetObjects[6].CellValue(i, "chk") == 1){
     						chkCnt++	
     					}
     				}
     			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
     				ComRowHideDelete(sheetObjects[6], "chk");
     				break;
     				
     			case "btn_RowDel_sheet41":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[7].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[7].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[7], "chk");
    				break;    
    				
     			case "btn_RowDel_sheet5":
     				if (!ComShowCodeConfirm("COM12188")) return;
     				var rCnt = sheetObjects[8].Rowcount+1;
     			    var chkCnt=0
     				for(i=1;i<rCnt;i++){
     					if(sheetObjects[8].CellValue(i, "chk") == 1){
     						chkCnt++	
     					}
     				}
     			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
     				ComRowHideDelete(sheetObjects[8], "chk");
     				break;
     				
     			case "btn_RowDel_sheet51":
    				if (!ComShowCodeConfirm("COM12188")) return;
    				var rCnt = sheetObjects[9].Rowcount+1;
    			    var chkCnt=0
    				for(i=1;i<rCnt;i++){
    					if(sheetObjects[9].CellValue(i, "chk") == 1){
    						chkCnt++	
    					}
    				}
    			    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
    				ComRowHideDelete(sheetObjects[9], "chk");
    				break;    
    				
    			case "btn_Save_sheet1":
    				doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);
    				break; 
    				
    			case "btn_Save_sheet11":
    				doActionIBSheet(sheetObjects[1], frmObj, IBSEARCH_ASYNC02);
    				break; 
     				
     			case "btn_Save_sheet2":
     				doActionIBSheet(sheetObjects[2], frmObj, IBSAVE);
     				break;   
     				
     			case "btn_Save_sheet21":
    				doActionIBSheet(sheetObjects[3], frmObj, IBSEARCH_ASYNC02);
    				break; 
     				
     			case "btn_Save_sheet3":
     				doActionIBSheet(sheetObjects[4], frmObj, IBSAVE);
     				break; 
     				
     			case "btn_Save_sheet31":
    				doActionIBSheet(sheetObjects[5], frmObj, IBSEARCH_ASYNC02);
    				break; 
     				
     			case "btn_Save_sheet4":
     				doActionIBSheet(sheetObjects[6], frmObj, IBSAVE);
     				break; 
     				
     			case "btn_Save_sheet41":
    				doActionIBSheet(sheetObjects[7], frmObj, IBSEARCH_ASYNC02);
    				break; 
    				
     			case "btn_Save_sheet5":
     				doActionIBSheet(sheetObjects[8], frmObj, IBSAVE);
     				break; 
     			
     			case "btn_Save_sheet51":
    				doActionIBSheet(sheetObjects[9], frmObj, IBSEARCH_ASYNC02);
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


/*********************** EDTITABLE MULIT COMBO START ********************/

    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    //ComComboObject생성자 메소드에서 호출됨
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++] = combo_obj;
    }


    /**
     * Combo 기본 설정
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
        	if(comboId == "bkg_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
        	}
        }
    }


    /*############################# combo event start ########################*/
    /**
     * MultiCombo에 입력된 값이 추가된 값인지 확인하여 처리한다.
     * 입력값을 upper로 변경하여 재등록 한다.
     * @param comboObj
     * @return
     */
  

    function combo_Change(comboObj, multiComboDataAddedFlag) {
        var frmObj = document.form;
        // 사용자 입력값을 uppercase로 변경
        var comboText =  comboObj.Text.toUpperCase();
        // 이전에 등록되었으면 삭제
        if (multiComboDataAddedFlag) {
            comboObj.DeleteItem(0);
            multiComboDataAddedFlag = false;
        }
        // 선택 또는 입력한  값이 콤보에 있으면 리턴
        if (comboObj.FindIndex(comboText, 0) != -1) {
            return;
        }
        comboObj.InsertItem(0, comboText, comboText);
        multiComboDataAddedFlag = true; // 콤보에 입력한것을 등록했다고 기록한다.(전역변수)
        comboObj.Text2 = comboText;  // 입력값이 선택되게 한다.
     }

  
    /*############################# combo event end ########################*/

/*********************** EDTITABLE MULIT COMBO END********************/


   /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tabObj){
        tabObjects[tabCnt++] = tabObj;
    }


    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj, tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt = 0 ;
                    InsertTab(cnt++, " Customer", -1);
                    InsertTab(cnt++, " Container", -1);
                    InsertTab(cnt++, " M&D", -1);
                    InsertTab(cnt++, " C/M", -1);
                    InsertTab(cnt++, " e-mail", -1);
                }
                break;
        }
    }


    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj, nItem) {
        var objs = document.all.item("tabLayer");
        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";
        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1;
        //------------------------------------------------------//
        beforetab = nItem;
    }


    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        //MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k], comboObjects[k].id);
        }

        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i], i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

        var frmObj = document.form;
        
        doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH_ASYNC01);
        
        axon_event.addListenerFormat('keypress', 'bkg_keypress', frmObj); //- 키보드 입력할때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm('beforedeactivate', 'bkg_deactivate', frmObj);     
        
    }


    /*********************** KEY EVENT START ********************/
    function bkg_keypress() {
        switch (event.srcElement.dataformat) {
            case "ymd":
                //number
                ComKeyOnlyNumber(event.srcElement, "-");
            break;
            case "engup":
                //영문대문자
                ComKeyOnlyAlphabet('upper');
            break;
            case "engupnum":
                //숫자+"영문대분자"입력하기
                ComKeyOnlyAlphabet('uppernum');
            break;
            case "num":
                //숫자 입력하기
                ComKeyOnlyNumber(event.srcElement);
            break;
            case "custname":
                //숫자 입력하기
                ComKeyOnlyAlphabet("uppernum", "40|41|46|44|32|42|38|35|45");
            break;
            default:
            break;
        }
    }
    
    function bkg_deactivate() {
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
    	if (srcName == "cust_seq") {
			if(!ComIsNull(srcValue)){
				if(ComChkLen(formObj.cust_cnt_cd, 2) == "2"){
					ComSetObjValue(formObj.cust_seq,ComLpad(formObj.cust_seq.value,6,"0"));
					searchCustNm2(formObj, ComGetObjValue(formObj.cust_cnt_cd), ComGetObjValue(formObj.cust_seq));
				}
			}
    	} 
    }
    /*********************** KEY EVENT END ********************/


    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, frmObj, sAction, Row, Col, PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch (sAction) {
            case IBSEARCH:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = SEARCH01;

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                sheetObjects[0].LoadSearchXml(arrXml[0]);              
                sheetObjects[2].LoadSearchXml(arrXml[1]);
                sheetObjects[4].LoadSearchXml(arrXml[2]);
                sheetObjects[6].LoadSearchXml(arrXml[3]);
                sheetObjects[8].LoadSearchXml(arrXml[4]);

                ComOpenWait(false); //대기이미지 숨김

                break;        
                
                
            case IBSEARCH_ASYNC01:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = SEARCH01;

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                sheetObjects[0].LoadSearchXml(arrXml[0]);
                sheetObjects[2].LoadSearchXml(arrXml[1]);
                sheetObjects[4].LoadSearchXml(arrXml[2]);
                sheetObjects[6].LoadSearchXml(arrXml[3]);
                sheetObjects[8].LoadSearchXml(arrXml[4]);                
                

                ComOpenWait(false); //대기이미지 숨김

                break;   
                
            case IBSAVE:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = MULTI;
				
                var params = FormQueryString(frmObj);
				params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(false),"sheet1_");	
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0238GS.do", params);
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComBkgSaveCompleted();
				}
                ComOpenWait(false); //대기이미지 숨김
                doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
                break;   
                
            case IBSEARCH_ASYNC02:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = MULTI01;
				
                var params = FormQueryString(frmObj);
				params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(false),"sheet2_");	
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0238GS.do", params);
				sheetObj.LoadSearchXml(sXml);
				if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
					ComBkgSaveCompleted();
				}
                ComOpenWait(false); //대기이미지 숨김
                break;       

            case IBDOWNEXCEL:      // 엑셀다운
                sheetObj.SpeedDown2Excel(-1);
                break;
        }
    }


    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, frmObj, sAction) {
        switch(sAction) {
            case IBSEARCH:
                if (!ComChkValid(frmObj)) return false;
            break;
        }
        return true;
    }


    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {

        var cnt = 0;
        with(sheetObj) {

            // 높이 설정
            style.height = 350;

            // 전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = false;

            CountPosition = 0;
            WaitImageVisible = false;


            switch (sheetNo) {
                // Status by SI Event
                case 1:    // sheet1 init
                    cnt = 0;
                    
                    style.height = 200;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Seq.|Item|Date|User Id|delete|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                    
                case 2:    // sheet6 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Type Seq.|Item Type|Date|User Id|delete||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_tp_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_tp_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                // By SI Kind
                case 3:    // sheet2 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Seq.|Item|Date|User Id|delete|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                    
                case 4:    // sheet6 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Type Seq.|Item Type|Date|User Id|delete||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_tp_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_tp_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;

                // Just in Time(JIT) Completion
                case 5:    // sheet3 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Seq.|Item|Date|User Id|delete|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                
                case 6:    // sheet6 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Type Seq.|Item Type|Date|User Id|delete||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_tp_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_tp_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                // By Urgency
                case 7:    // sheet4 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Seq.|Item|Date|User Id|delete|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                    
                case 8:    // sheet6 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Type Seq.|Item Type|Date|User Id|delete||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_tp_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_tp_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;

                // By Return Feedback Status
                case 9:    // sheet5 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Seq.|Item|Date|User Id|delete|";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;
                    
                case 10:    // sheet6 init
                	cnt = 0;
                	
                	style.height = 200;
                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Item Type Seq.|Item Type|Date|User Id|delete||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle);

                    // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    // 헤더에서 처리할 수 있는 각종 기능을 설정한다
                    // ([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
                    InitHeadMode(true, true, true, true, false, false);

                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 50,  daCenter, true,  "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_tp_seq",  false);
                    InitDataProperty(0, cnt++, dtData,         600,  daLeft,  false, "chk_pnt_itm_tp_nm",  	false, "", dfNone, 		0, true, true, 200, false, false);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_itm_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    
                    break;

                // Aging Status(P.F)
               

            }
        }
    }    
    
    
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	var frmObj = document.form;
    	
        frmObj.f_cmd.value = SEARCH02;
        
        var chkPntTp = sheetObj.CellValue(NewRow,"chk_pnt_tp_cd");
        var chkPntItmSeq = sheetObj.CellValue(NewRow,"chk_pnt_itm_seq");
       

        var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+chkPntItmSeq);
        var arrXml = sXml.split("|$$|");

        sheetObjects[1].LoadSearchXml(arrXml[0]);        
	}
    
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	var frmObj = document.form;
    	
        frmObj.f_cmd.value = SEARCH02;
        
        var chkPntTp = sheetObj.CellValue(NewRow,"chk_pnt_tp_cd");
        var chkPntItmSeq = sheetObj.CellValue(NewRow,"chk_pnt_itm_seq");
       

        var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+chkPntItmSeq);
        var arrXml = sXml.split("|$$|");

        sheetObjects[3].LoadSearchXml(arrXml[0]);        
	}
    
    function sheet3_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	var frmObj = document.form;
    	
        frmObj.f_cmd.value = SEARCH02;
        
        var chkPntTp = sheetObj.CellValue(NewRow,"chk_pnt_tp_cd");
        var chkPntItmSeq = sheetObj.CellValue(NewRow,"chk_pnt_itm_seq");
       

        var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+chkPntItmSeq);
        var arrXml = sXml.split("|$$|");

        sheetObjects[5].LoadSearchXml(arrXml[0]);        
	}
    
    function sheet4_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	var frmObj = document.form;
    	
        frmObj.f_cmd.value = SEARCH02;
        
        var chkPntTp = sheetObj.CellValue(NewRow,"chk_pnt_tp_cd");
        var chkPntItmSeq = sheetObj.CellValue(NewRow,"chk_pnt_itm_seq");
       

        var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+chkPntItmSeq);
        var arrXml = sXml.split("|$$|");

        sheetObjects[7].LoadSearchXml(arrXml[0]);        
	}
    
    function sheet5_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
    	var frmObj = document.form;
    	
        frmObj.f_cmd.value = SEARCH02;
        
        var chkPntTp = sheetObj.CellValue(NewRow,"chk_pnt_tp_cd");
        var chkPntItmSeq = sheetObj.CellValue(NewRow,"chk_pnt_itm_seq");
       

        var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+chkPntItmSeq);
        var arrXml = sXml.split("|$$|");

        sheetObjects[9].LoadSearchXml(arrXml[0]);        
	}

/* 개발자 작업  끝 */
