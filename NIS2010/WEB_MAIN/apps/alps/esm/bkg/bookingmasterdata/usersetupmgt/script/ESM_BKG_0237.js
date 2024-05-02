/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0237.js
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
     * @class esm_bkg_0237  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0237() {
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
            	case "btn_custPop": 
            		comBkgCallPop0652('callBack0652', 'S', frmObj.cust_cnt_cd.value, frmObj.cust_seq.value, (ComIsNull(frmObj.cust_seq.value)?(frmObj.cust_nm.value.substring(0,10)):""));
    				break;
                case "btn_Retrieve":                    
                    doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);                   
                    break;

                case "btn_New":
                    ComResetAll();
                    break;                    
                    
                case "btn_RowAdd_sheet1":
    				var newRow = sheetObjects[0].DataInsert(-1);
    				sheetObjects[0].CellValue(newRow, "chk_pnt_tp_cd") = "CU";
    				sheetObjects[0].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
    				sheetObjects[0].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
    				sheetObjects[0].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
    				break;   
    				
                case "btn_RowAdd_sheet2":
     				var newRow = sheetObjects[1].DataInsert(-1);
     				sheetObjects[1].CellValue(newRow, "chk_pnt_tp_cd") = "CN";
     				sheetObjects[1].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[1].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[1].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
     				break; 
     				
     			case "btn_RowAdd_sheet3":
     				var newRow = sheetObjects[2].DataInsert(-1);
     				sheetObjects[2].CellValue(newRow, "chk_pnt_tp_cd") = "MD";
     				sheetObjects[2].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[2].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[2].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
     				break;   
     				
     			case "btn_RowAdd_sheet4":
     				var newRow = sheetObjects[3].DataInsert(-1);
     				sheetObjects[3].CellValue(newRow, "chk_pnt_tp_cd") = "CM";
     				sheetObjects[3].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[3].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[3].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
     				break;  
     				
     			case "btn_RowAdd_sheet5":
     				var newRow = sheetObjects[4].DataInsert(-1);
     				sheetObjects[4].CellValue(newRow, "chk_pnt_tp_cd") = "EM";
     				sheetObjects[4].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[4].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[4].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
     				break;     
     				
     			case "btn_RowAdd_sheet6":
     				var newRow = sheetObjects[5].DataInsert(-1);
     				sheetObjects[5].CellValue(newRow, "chk_pnt_tp_cd") = "RA";
     				sheetObjects[5].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[5].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[5].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
     				break;     
     				
     			case "btn_RowAdd_sheet7":
     				var newRow = sheetObjects[6].DataInsert(-1);
     				sheetObjects[6].CellValue(newRow, "chk_pnt_tp_cd") = "CO";
     				sheetObjects[6].CellValue(newRow, "cust_cnt_cd") =frmObj.cust_cnt_cd.value;
     				sheetObjects[6].CellValue(newRow, "cust_seq") = frmObj.cust_seq.value;
     				sheetObjects[6].CellValue(newRow, "cust_lgl_eng_nm") = frmObj.cust_nm.value;
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

     			case "btn_RowDel_sheet2":
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
     				
     			case "btn_RowDel_sheet3":
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
     				
     			case "btn_RowDel_sheet4":
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
     				
     			case "btn_RowDel_sheet5":
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
     				
     			case "btn_RowDel_sheet6":
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
     				
     			case "btn_RowDel_sheet7":
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
    				
    			case "btn_Save_sheet1":
    				doActionIBSheet(sheetObjects[0], frmObj, IBSAVE);
    				break; 
     				
     			case "btn_Save_sheet2":
     				doActionIBSheet(sheetObjects[1], frmObj, IBSAVE);
     				break;   
     				
     			case "btn_Save_sheet3":
     				doActionIBSheet(sheetObjects[2], frmObj, IBSAVE);
     				break;  	     			
     				
     			case "btn_Save_sheet4":
     				doActionIBSheet(sheetObjects[3], frmObj, IBSAVE);
     				break; 
     				
     			case "btn_Save_sheet5":
     				doActionIBSheet(sheetObjects[4], frmObj, IBSAVE);
     				break; 
     				
     			case "btn_Save_sheet6":
     				doActionIBSheet(sheetObjects[5], frmObj, IBSAVE);
     				break; 
     				
     			case "btn_Save_sheet7":
     				doActionIBSheet(sheetObjects[6], frmObj, IBSAVE);
     				break; 

                case "btn_DownExcel_sheet1":
                    doActionIBSheet(sheetObjects[0], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet2":
                    doActionIBSheet(sheetObjects[1], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet3":
                    doActionIBSheet(sheetObjects[2], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet4":
                    doActionIBSheet(sheetObjects[3], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet5":
                    doActionIBSheet(sheetObjects[4], frmObj, IBDOWNEXCEL);
                    break;

                case "btn_DownExcel_sheet6":
                    doActionIBSheet(sheetObjects[5], frmObj, IBDOWNEXCEL);
                    break;
                    
                case "btn_DownExcel_sheet7":
                    doActionIBSheet(sheetObjects[6], frmObj, IBDOWNEXCEL);
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
                    InsertTab(cnt++, " C/M",-1);
                    InsertTab(cnt++, " e-mail",-1);
                    InsertTab(cnt++, " Rating", -1);
                    InsertTab(cnt++, " Common", -1);
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
        
        if(!ComIsNull(ComGetObjValue(frmObj.cust_cnt_cd))&&!ComIsNull(ComGetObjValue(frmObj.cust_seq))){
        	doActionIBSheet(sheetObjects[0], frmObj, IBSEARCH);
        	
        	if(!ComIsNull(ComGetObjValue(frmObj.tab_idx))){
        		if(ComGetObjValue(frmObj.tab_idx)==1){
        			tabObjects[0].SelectedIndex = 0;
        		} else if(ComGetObjValue(frmObj.tab_idx)==2){
        			tabObjects[0].SelectedIndex = 1;
        		} else if(ComGetObjValue(frmObj.tab_idx)==3){
        			tabObjects[0].SelectedIndex = 2;
        		} else if(ComGetObjValue(frmObj.tab_idx)==4){
        			tabObjects[0].SelectedIndex = 3;
        		}
        	}
        }
        
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
                
                tabObjects[0].TabBackColor(0)="206,220,246";
            	tabObjects[0].TabBackColor(1)="206,220,246";
            	tabObjects[0].TabBackColor(2)="206,220,246";
            	tabObjects[0].TabBackColor(3)="206,220,246";
            	tabObjects[0].TabBackColor(4)="206,220,246";
            	tabObjects[0].TabBackColor(5)="206,220,246";
            	tabObjects[0].TabBackColor(6)="206,220,246";
            	
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = SEARCH;
                var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");
                                
                sheetObjects[0].LoadSearchXml(arrXml[0]);              
                sheetObjects[1].LoadSearchXml(arrXml[1]);
                sheetObjects[2].LoadSearchXml(arrXml[2]);
                sheetObjects[3].LoadSearchXml(arrXml[3]);
                sheetObjects[4].LoadSearchXml(arrXml[4]);
                sheetObjects[5].LoadSearchXml(arrXml[5]);
                sheetObjects[6].LoadSearchXml(arrXml[6]);  
                
                for(var i=1;i<= sheetObjects[0].RowCount;i++){
                	setChkPntItmTp(sheetObjects[0], i, sheetObjects[0].CellText(i,"chk_pnt_itm_tp_seq"),"CU");
                }               
               
                ComOpenWait(false); //대기이미지 숨김
                
                if(sheetObjects[0].RowCount>0){
            		tabObjects[0].TabBackColor(0)="#fff270";
                } 
                if(sheetObjects[1].RowCount>0){
            		tabObjects[0].TabBackColor(1)="#fff270";
                } 
                if(sheetObjects[2].RowCount>0){
            		tabObjects[0].TabBackColor(2)="#fff270";
                } 
                if(sheetObjects[3].RowCount>0){
            		tabObjects[0].TabBackColor(3)="#fff270";
                } 
                if(sheetObjects[4].RowCount>0){
            		tabObjects[0].TabBackColor(4)="#fff270";
                } 
                if(sheetObjects[5].RowCount>0){
            		tabObjects[0].TabBackColor(5)="#fff270";
                } 
                if(sheetObjects[6].RowCount>0){
            		tabObjects[0].TabBackColor(6)="#fff270";
                } 
                
                break;        
                
                
            case IBSEARCH_ASYNC01:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = SEARCH01;

                var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj));
                var arrXml = sXml.split("|$$|");

                sheetObjects[7].LoadSearchXml(arrXml[0]);
                sheetObjects[8].LoadSearchXml(arrXml[1]);
                sheetObjects[9].LoadSearchXml(arrXml[2]);
                sheetObjects[10].LoadSearchXml(arrXml[3]);
                sheetObjects[11].LoadSearchXml(arrXml[4]);
                sheetObjects[12].LoadSearchXml(arrXml[5]);
                sheetObjects[13].LoadSearchXml(arrXml[6]);
                
                var combo7List = '';
        		var combo7value = '';
        		combo7List = combo7List + " |";
        		combo7value = combo7value + " |";
        		for(var i=sheetObjects[7].HeaderRows;i<sheetObjects[7].Rows;i++){
        			combo7List = combo7List + sheetObjects[7].CellValue(i, "chk_pnt_itm_nm")+"|";
        			combo7value =combo7value + sheetObjects[7].CellValue(i, "chk_pnt_itm_seq") + "|";
        		}
        		sheetObjects[0].InitDataCombo(0,	"chk_pnt_itm_seq",	combo7List, combo7value);
        		
        		
        		var combo8List = '';
         		var combo8value = '';
         		combo8List = combo8List + " |";
         		combo8value = combo8value + " |";
         		for(var i=sheetObjects[8].HeaderRows;i<sheetObjects[8].Rows;i++){
         			combo8List = combo8List + sheetObjects[8].CellValue(i, "chk_pnt_itm_nm")+"|";
         			combo8value =combo8value + sheetObjects[8].CellValue(i, "chk_pnt_itm_seq") + "|";
         		}
         		sheetObjects[1].InitDataCombo(0,	"chk_pnt_itm_seq",	combo8List, combo8value);
         		
         		
         		var combo9List = '';
         		var combo9value = '';
         		combo9List = combo9List + " |";
         		combo9value = combo9value + " |";
         		for(var i=sheetObjects[9].HeaderRows;i<sheetObjects[9].Rows;i++){
         			combo9List = combo9List + sheetObjects[9].CellValue(i, "chk_pnt_itm_nm")+"|";
         			combo9value =combo9value + sheetObjects[9].CellValue(i, "chk_pnt_itm_seq") + "|";
         		}
         		sheetObjects[2].InitDataCombo(0,	"chk_pnt_itm_seq",	combo9List, combo9value);
         		
         		var combo10List = '';
         		var combo10value = '';
         		combo10List = combo10List + " |";
         		combo10value = combo10value + " |";
         		for(var i=sheetObjects[10].HeaderRows;i<sheetObjects[10].Rows;i++){
         			combo10List = combo10List + sheetObjects[10].CellValue(i, "chk_pnt_itm_nm")+"|";
         			combo10value =combo10value + sheetObjects[10].CellValue(i, "chk_pnt_itm_seq") + "|";
         		}
         		sheetObjects[3].InitDataCombo(0,	"chk_pnt_itm_seq",	combo10List, combo10value);
         		
         		var combo11List = '';
         		var combo11value = '';
         		combo11List = combo11List + " |";
         		combo11value = combo11value + " |";
         		for(var i=sheetObjects[11].HeaderRows;i<sheetObjects[11].Rows;i++){
         			combo11List = combo11List + sheetObjects[11].CellValue(i, "chk_pnt_itm_nm")+"|";
         			combo11value =combo11value + sheetObjects[11].CellValue(i, "chk_pnt_itm_seq") + "|";
         		}
         		sheetObjects[4].InitDataCombo(0,	"chk_pnt_itm_seq",	combo11List, combo11value);

                ComOpenWait(false); //대기이미지 숨김     
                
                break;   
                
            case IBSAVE:      //조회
                if (!validateForm(sheetObj, frmObj, sAction)) return;
                ComOpenWait(true);  //대기이미지 표시
                frmObj.f_cmd.value = MULTI;
				
                var params = FormQueryString(frmObj);
				params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(false),"sheet_");	
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0237GS.do", params);
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

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|Items|Type|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  true,  "chk_pnt_itm_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  false, "chk_pnt_itm_tp_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "Y|N", "Y|N");
                    break;

                // By SI Kind
                case 2:    // sheet2 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|Items|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  true,  "chk_pnt_itm_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;

                // Just in Time(JIT) Completion
                case 3:    // sheet3 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|Items|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  true,  "chk_pnt_itm_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;

                // By Urgency
                case 4:    // sheet4 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|Items|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  true,  "chk_pnt_itm_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;

                // By Return Feedback Status
                case 5:    // sheet5 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|Items|e-mail|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtCombo,      100,  daCenter,  true,  "chk_pnt_itm_seq",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,      100,  daCenter,  false, "pic_eml",			false, "", dfNone, 		0, false, false, 200, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;

                // Aging Status(P.F)
                case 6:    // sheet6 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;
                    
                case 7:    // sheet6 init
                	cnt = 0;

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;  //msNone; msHeaderOnly; msPrevColumnMerge;
                    
                    Editable = true;

                    // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 9, 100);

                    var HeadTitle = "||Seq.|Customer|Customer|Name|Bkg Ofc.|CHK Point|Date|User Id|Ofc|Attach|delete|||";
                    
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
                    InitDataProperty(0, cnt++, dtCheckBox, 	40, daCenter, true,"chk",			false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtSeq,    30,  daCenter, true,  "Seq");
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter, true,  "cust_cnt_cd",			false, "", dfNone, 		0, false, true, 2, false, true);
                    InitDataProperty(0, cnt++, dtPopupEdit,         60,  daCenter, true,  "cust_seq",			false, "", dfNone, 		0, false, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daLeft, true,  "cust_lgl_eng_nm",			false, "", dfNone, 		0, false, false, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true,  "bkg_ofc_cd",			false, "", dfNone, 		0, true, true, 6, false, true);
                    InitDataProperty(0, cnt++, dtData,         200,  daLeft,  false, "chk_pnt_rmk",  	false, "", dfNone, 		0, false, false, 4000, false, true);
                    InitDataProperty(0, cnt++, dtData,         120,  daCenter,  false, "upd_dt",     false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter,  false, "upd_usr_id",      false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtData,         40,  daCenter,  false, "ofc_cd",  false, "", dfNone, 		0, false, false, 10, false, true);
                    InitDataProperty(0, cnt++, dtPopup,         60,  daLeft,  false, "atch_file_knt",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtCombo,         40,  daCenter,  false, "delt_flg",      false, "", dfNone, 		0, true, true, 10, false, true);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "cust_chk_pnt_seq",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "chk_pnt_tp_cd",  false);
                    InitDataProperty(0, cnt++, dtHidden,      40,  daRight,  false, "atch_file_lnk_id",  false);
                    
                    
                    InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
                    InitDataValid(0, "bkg_ofc_cd", vtEngUpOnly);
					InitDataValid(0,"cust_seq", vtNumericOnly);
					InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
                    break;
                    
                case 8:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 9:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 10:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 11:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 12:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 13:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            		
                case 14:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(3, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
            	
                case 15:
            		//with (sheetObj) {
            			// 높이 설정
            		sheetObj.style.height = 0;
            			//전체 너비 설정
            		sheetObj.SheetWidth = mainTable.clientWidth;

            			//Host정보 설정[필수][HostIp, Port, PagePath]
            			if (location.hostname != "") sheetObj.InitHostInfo(location.hostname, location.port, page_path);

            			//전체Merge 종류 [선택, Default msNone]
            			sheetObj.MergeSheet = msHeaderOnly;

            			//전체Edit 허용 여부 [선택, Default false]
            			sheetObj.Editable = true;

            			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            			sheetObj.InitRowInfo(1, 1, 3, 100);

            			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            			sheetObj.InitColumnInfo(4, 0, 0, true);

            			// 해더에서 처리할 수 있는 각종 기능을 설정한다
            			sheetObj.InitHeadMode(false, true, false, true, false, false);

            			var HeadTitle = "chk_pnt_tp_cd|chk_pnt_itm_seq|chk_pnt_itm_tp_seq|chk_pnt_itm_tp_nm";

            			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=faLse, HIDDEN=false]
            			sheetObj.InitHeadRow(0, HeadTitle, true);

                        //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,           KEYFIELD,  CALCULOGIC,  DATAFORMAT,  POINTCOUNT,  UPDATEEDIT,  INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_tp_cd",          false,     "",          dfNone,   0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,   false,     "chk_pnt_itm_seq",        false,     "",          dfNone,      0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_tp_seq",      false,     "",          dfNone,     0,           true,        true);
                        sheetObj.InitDataProperty(0, cnt++ , dtData,         80,     daCenter,    false,     "chk_pnt_itm_tp_nm",      false,     "",          dfNone,     0,           true,        true);
                        
                        sheetObj.CountPosition = 0;

                        sheetObj.AutoRowHeight = false;
            		//}
            		break;
                

            }
        }
    }
    
    function sheet1_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if(sheetObj.ColSaveName(Col) == "chk_pnt_itm_seq"){
    		ComOpenWait(true);  //대기이미지 표시
            frmObj.f_cmd.value = SEARCH02;

            var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd=CU&chk_pnt_itm_seq="+sheetObj.CellValue(Row,Col));
            var arrXml = sXml.split("|$$|");

            sheetObjects[14].LoadSearchXml(arrXml[0]);
            
            var combo14List = '';
    		var combo14value = '';
    		combo14List = combo14List + " |";
    		combo14value = combo14value + " |";
    		for(var i=sheetObjects[14].HeaderRows;i<sheetObjects[14].Rows;i++){
    			combo14List = combo14List + sheetObjects[14].CellValue(i, "chk_pnt_itm_tp_nm")+"|";
    			combo14value =combo14value + sheetObjects[14].CellValue(i, "chk_pnt_itm_tp_seq") + "|";
    		}
    		
    		sheetObj.CellComboItem(Row,	"chk_pnt_itm_tp_seq",	combo14List, combo14value);

            ComOpenWait(false); //대기이미지 숨김
    	} else if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet2_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet3_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet4_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet5_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet6_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function sheet7_OnChange(sheetObj, Row, Col, Value){
    	var frmObj = document.form;
    	
    	if (sheetObj.ColSaveName(Col) == "cust_seq") {
			if(Value != "") {
			    ComOpenWait(true);
			    sheetObj.WaitImageVisible = false;
			    				
			    sheetObj.CellValue2(Row,Col) =ComLpad(Value,6,"0");
			    var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    
			    searchCustNm(sheetObj, custCntCd, custSeq, Row);
				
			}
		}
    }
    
    function searchCustNm(sheetObj, custCntCd, custSeq, row){
    	ComOpenWait(true);
	    sheetObj.WaitImageVisible = false;
	    
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+SEARCHLIST14+ "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq);
		ComOpenWait(false);
		
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			if(!ComIsEmpty(ComGetEtcData(sXml,"cust_nm"))){
				sheetObj.CellValue2(row,"cust_lgl_eng_nm") = ComGetEtcData(sXml,"cust_nm");
			} else {
				ComShowMessage(ComGetMsg("COM12114", "customer code")); //Please check {?msg1}
				sheetObj.CellValue2(row, "cust_seq") = "";
				sheetObj.SelectCell(row, "cust_seq");
			}
		}else{
			ComShowMessage(ComGetMsg("COM12114", "customer code")); //Please check {?msg1}
			sheetObj.CellValue2(row, "cust_seq") = "";
			sheetObj.SelectCell(row, "cust_seq");
		}	    
    }
    
    function searchCustNm2(frmObj, custCntCd, custSeq){
    	//ComOpenWait(true);
	    
    	var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_01GS.do?f_cmd="+SEARCHLIST14+ "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq);
		//ComOpenWait(false);
		
		if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
			if(!ComIsEmpty(ComGetEtcData(sXml,"cust_nm"))){
				ComSetObjValue(frmObj.cust_nm,ComGetEtcData(sXml,"cust_nm"));
			} else {
				ComSetObjValue(frmObj.cust_seq,"");
			}
		}else{
			ComShowMessage(ComGetMsg("COM12114", "customer code")); //Please check {?msg1}
			ComSetObjValue(frmObj.cust_seq,"");
		}	    
    }
    
    function setChkPntItmTp(sheetObj, Row, Val, chkPntTp){
    	var frmObj = document.form;
    	
            frmObj.f_cmd.value = SEARCH02;

            var sXml = sheetObj.GetSearchXml("ESM_BKG_0237GS.do", FormQueryString(frmObj)+"&chk_pnt_tp_cd="+chkPntTp+"&chk_pnt_itm_seq="+sheetObj.CellValue(Row,"chk_pnt_itm_seq"));
            var arrXml = sXml.split("|$$|");

            sheetObjects[14].LoadSearchXml(arrXml[0]);
            
            var combo14List = '';
    		var combo14value = '';
    		combo14List = combo14List + " |";
    		combo14value = combo14value + " |";
    		for(var i=sheetObjects[14].HeaderRows;i<sheetObjects[14].Rows;i++){
    			combo14List = combo14List + sheetObjects[14].CellValue(i, "chk_pnt_itm_tp_nm")+"|";
    			combo14value =combo14value + sheetObjects[14].CellValue(i, "chk_pnt_itm_tp_seq") + "|";
    		}
    		
    		sheetObj.CellComboItem(Row,	"chk_pnt_itm_tp_seq",	combo14List, combo14value);
    		sheetObj.CellValue2(Row,"chk_pnt_itm_tp_seq") = Val;
    }
  
    function callBack0652(bkgCustTpCd, rArray1, rArray2, lOfc, lRep){    	
    	var formObj = document.form;
    	// SHPR,FWDR 입력
    	if(rArray1 != null){
    		if(bkgCustTpCd == "S"){		
    			formObj.cust_cnt_cd.value = rArray1[0][14].substring(0,2);
    			
    			if(ComLpad(rArray1[0][15],6,"0")!="000000"){
    	    		ComSetObjValue(formObj.cust_seq,ComLpad(rArray1[0][15],6,"0"));
    	    	}
    			
    			ComSetObjValue(formObj.cust_nm, rArray1[0][5]);        		
    		}
        }
    	
    }  
    
    function callBack0652_sheet1(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[0];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet2(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[1];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet3(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[2];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet4(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[3];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet5(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[4];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet6(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[5];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function callBack0652_sheet7(rowcol, rArray1, rArray2, lOfc, lRep) {   
    	var sheetObj = sheetObjects[6];    	
    	var sp = rowcol.split("|"); //팝업 호출시 보내준 그리드 셀 위치 데이터  
    	sheetObj.CellValue2(sp[0], "cust_cnt_cd") =rArray1[0][14].substring(0,2);
    	sheetObj.CellValue2(sp[0], "cust_seq") =ComLpad(rArray1[0][15],6,"0");
    	sheetObj.CellValue2(sp[0], "cust_lgl_eng_nm") = rArray1[0][5];    
    }
    
    function  sheet1_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    function  sheet2_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    function  sheet3_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    function  sheet4_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    function  sheet5_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} else if (col_save_name == "pic_eml"){
    			ComShowMemoPad(sheetObj, row, "pic_eml", false, 250, 200);
    		}
    	}
    } 
    function  sheet6_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    
    function  sheet7_OnClick(sheetObj, row, col) {
    	if (col != 1) {		
    		var col_save_name = sheetObj.ColSaveName(col);
    		if (col_save_name == "chk_pnt_rmk") {
    			ComShowMemoPad(sheetObj, row, "chk_pnt_rmk", false, 250, 300);
    		} 
    	}
    } 
    
    
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet1',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }

    function sheet2_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet2',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }
    
    function sheet3_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet3',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }
    
    function sheet4_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet4',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }

    
    function sheet5_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet5',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }

    
    function sheet6_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet6',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }

    
    function sheet7_OnPopupClick(sheetObj, Row, Col) {
    	var form = document.form;
    	var colName  = sheetObj.ColSaveName(Col);
     	switch(colName) {        			
    		case "atch_file_knt":
    			var custCntCd =  sheetObj.CellValue(Row, "cust_cnt_cd");
			    var custSeq = sheetObj.CellValue(Row, "cust_seq");
			    var chkPntTpCd = sheetObj.CellValue(Row, "chk_pnt_tp_cd");
			    var custChkPntSeq = sheetObj.CellValue(Row, "cust_chk_pnt_seq");
			    var edit_flg = "Y";
    			var url = "ESM_BKG_0239.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq+"&chk_pnt_tp_cd="+chkPntTpCd+"&cust_chk_pnt_seq="+custChkPntSeq+"&edit_flg="+edit_flg;
    			ComOpenWindowCenter(url, "ESM_BKG_0239", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
    			break;
    			
    		case "cust_seq" :
				//Customer Code 선택팝업 열기					
				comBkgCallPop0652('callBack0652_sheet7',Row + "|" + Col,"","", "");
	        	break;
    			
     	}    	 
    }

    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
    		tabObjects[0].TabBackColor(0)="#fff270";
        }          
    }
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(1)="#fff270";
         }    	
    }
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(2)="#fff270";
         }    	
    }
    function sheet4_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(3)="#fff270";
         }    	
    }
    function sheet5_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(4)="#fff270";
         }    	
    }
    function sheet6_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(5)="#fff270";
         }    	
    }
    function sheet7_OnSearchEnd(sheetObj, ErrMsg){	
    	if(sheetObj.RowCount>0){
   		  	tabObjects[0].TabBackColor(6)="#fff270";
         }    	
    }

/* 개발자 작업  끝 */
