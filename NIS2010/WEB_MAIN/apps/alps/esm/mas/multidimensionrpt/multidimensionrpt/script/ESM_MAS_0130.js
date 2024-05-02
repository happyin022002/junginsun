/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0130.js
*@FileTitle : ReportViewManagement
*Open Issues :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.07.23 박수훈
* 1.0 Creation
*Change history :
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정 
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
     * @class ESM_MAS_0130 : ESM_MAS_0130 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0130() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.sheet1_OnChange    	= sheet1_OnChange;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
 // 공통전역변수


    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

        /**
         * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
         */
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var formObject = document.form;
            
            try {
                var srcName = window.event.srcElement.getAttribute("name");
                
                switch(srcName) {
                    case "btn_Retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    
                    case "btn_Save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
                    
                    case "btn_Close":
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
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	
            for(i=0;i<sheetObjects.length;i++){
                //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }

        /**
         * 시트 초기설정값, 헤더 정의
         * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
         * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
         */
        function initSheet(sheetObj,sheetNo) {
            var cnt = 0;
            
            switch(sheetNo) {
                case 1:      //sheet1 init
                    with (sheetObj) {
                        SheetWidth = mainTable.clientWidth;                 //전체 너비 설정
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                        MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                        Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                        InitRowInfo( 2, 1, 9, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(13, 0, 0, true);                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(true, false, false, true, false,false); // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        var HeadTitle0 = "status|rpt_seq|Office\nLevel|Office Desc|Profit View|Profit View|Profit View|Office View|Office View|Office View|Profit Level|Profit Level|Profit Level";
                        var HeadTitle1 = "status|rpt_seq|Office\nLevel|Office Desc|PA|RA|defalut|Contract|Loading|defalut|CM|OP|defalut";
                        InitHeadRow(0, HeadTitle0, true);                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(1, HeadTitle1, true);                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        
                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++,	dtHiddenStatus,30,	 daCenter,	true,	 "ibflag");
                        InitDataProperty(0, cnt++ , dtHidden,      30,   daCenter,  true,    "rpt_seq",    false,          "",       dfNone,   	  0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,    "ofc_lvl",      false,          "",       dfNone,   	  0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,       90,    daLeft,    true,    "ofc_lvl_desc", false,          "",       dfNone,        0,     false,      false);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "pfit_cd1",     false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "pfit_cd2",     false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,    "pfit_dflt",     false,          "",       dfNone,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "ofc_cd1",      false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,    "ofc_cd2",      false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtCombo,      70,    daCenter,  true,    "ofc_dflt",     false,          "",       dfNone,        0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "lvl_cd1",      false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,    "lvl_cd2",      false,          "",       dfEngUpKey,    0,     true,       true, 1, true);
                        InitDataProperty(0, cnt++ , dtCombo,      50,    daCenter,  true,    "lvl_dflt",     false,          "",       dfNone,        0,     true,       true);
                        
                        InitDataValid(0, "pfit_cd1", vtCharOnly, "YN");
                        InitDataValid(0, "pfit_cd2", vtCharOnly, "YN");
                        InitDataValid(0, "ofc_cd1", vtCharOnly, "YN");
                        InitDataValid(0, "ofc_cd2", vtCharOnly, "YN");
                        InitDataValid(0, "lvl_cd1", vtCharOnly, "YN");
                        InitDataValid(0, "lvl_cd2", vtCharOnly, "YN");                        
                       
                        CountPosition  = 0 ;
                        style.height = GetSheetHeight(12) ;
                    }
                    break;
            }
        }

        
        /**
         * IBSheet Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setSheetObject(sheet_obj){
        
        	sheetObjects[sheetCnt++] = sheet_obj;
        }
        
        /**
         * Sheet_1 조회한 후 조건에 따라 색깔을 넣어줌
         */
        function sheet1_OnSearchEnd(sheetObj, errMsg){        	
        	for(i=2; i<=sheetObj.LastRow; i++){        		
        		 if(sheetObj.CellValue(i, "pfit_dflt") == "P"){        			 
                     sheetObj.CellBackColor(i, "pfit_cd1") = sheetObj.RgbColor(247,231,236);
                     sheetObj.CellBackColor(i, "pfit_cd2") = sheetObj.RgbColor(255,255,255);
                 }else{
                     sheetObj.CellBackColor(i, "pfit_cd1") = sheetObj.RgbColor(255,255,255);
                     sheetObj.CellBackColor(i, "pfit_cd2") = sheetObj.RgbColor(247,231,236);
                 }
                 if(sheetObj.CellValue(i, "ofc_dflt") == "C"){
                     sheetObj.CellBackColor(i, "ofc_cd1") = sheetObj.RgbColor(247,231,236);
                     sheetObj.CellBackColor(i, "ofc_cd2") = sheetObj.RgbColor(255,255,255);
                 }else{
                     sheetObj.CellBackColor(i, "ofc_cd1") = sheetObj.RgbColor(255,255,255);
                     sheetObj.CellBackColor(i, "ofc_cd2") = sheetObj.RgbColor(247,231,236);
                 }
                 if(sheetObj.CellValue(i, "lvl_dflt") == "C"){
                     sheetObj.CellBackColor(i, "lvl_cd1") = sheetObj.RgbColor(247,231,236);
                     sheetObj.CellBackColor(i, "lvl_cd2") = sheetObj.RgbColor(255,255,255);
                 }else{
                     sheetObj.CellBackColor(i, "lvl_cd1") = sheetObj.RgbColor(255,255,255);
                     sheetObj.CellBackColor(i, "lvl_cd2") = sheetObj.RgbColor(247,231,236);
                 }        		
        	}            
        }
        
        /**
         * Sheet_1이 저장 되고 난 후 색깔을 바꿔줌
         */
        function sheet1_OnChange(sheetObj, row, col, value){            
            if(sheetObj.CellValue(row, "pfit_dflt") == "P"){
                sheetObj.CellBackColor(row, "pfit_cd1") = sheetObj.RgbColor(247,231,236);
                sheetObj.CellBackColor(row, "pfit_cd2") = sheetObj.RgbColor(255,255,255);
            }else{
                sheetObj.CellBackColor(row, "pfit_cd1") = sheetObj.RgbColor(255,255,255);
                sheetObj.CellBackColor(row, "pfit_cd2") = sheetObj.RgbColor(247,231,236);
            }
            if(sheetObj.CellValue(row, "ofc_dflt") == "C"){
                sheetObj.CellBackColor(row, "ofc_cd1") = sheetObj.RgbColor(247,231,236);
                sheetObj.CellBackColor(row, "ofc_cd2") = sheetObj.RgbColor(255,255,255);
            }else{
                sheetObj.CellBackColor(row, "ofc_cd1") = sheetObj.RgbColor(255,255,255);
                sheetObj.CellBackColor(row, "ofc_cd2") = sheetObj.RgbColor(247,231,236);
            }
            if(sheetObj.CellValue(row, "lvl_dflt") == "C"){
                sheetObj.CellBackColor(row, "lvl_cd1") = sheetObj.RgbColor(247,231,236);
                sheetObj.CellBackColor(row, "lvl_cd2") = sheetObj.RgbColor(255,255,255);
            }else{
                sheetObj.CellBackColor(row, "lvl_cd1") = sheetObj.RgbColor(255,255,255);
                sheetObj.CellBackColor(row, "lvl_cd2") = sheetObj.RgbColor(247,231,236);
            }
            
        } 
        
        /**
         * Sheet관련 프로세스 처리
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {
            	case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0130GS.do", masFormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComMasSetIBCombo(sheetObj, arrXml[0], "pfit_dflt", false, 0);
					if (arrXml.length > 1)
						ComMasSetIBCombo(sheetObj, arrXml[1], "ofc_dflt", false, 0);
					if (arrXml.length > 2)
						ComMasSetIBCombo(sheetObj, arrXml[2], "lvl_dflt", false, 0);
					
					ComOpenWait(false);
					break	
                case IBSEARCH:      //조회
                    if(validateForm(sheetObj,formObj,sAction))
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = SEARCH;
                    sheetObj.DoSearch4Post("ESM_MAS_0130GS.do", masFormQueryString(formObj));
                    ComOpenWait(false);
                    break;
                    
                case IBSAVE:       //저장
                    if(validateForm(sheetObj,formObj,sAction))
                	// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
                    formObj.f_cmd.value = MULTI;
                    sheetObj.DoSave("ESM_MAS_0130GS.do", masFormQueryString(formObj));
                    ComOpenWait(false);
                    break;
            }
        }
        

        
        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){      
            }   
            return true;
        }
