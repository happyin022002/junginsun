/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0066.js
*@FileTitle : Temporary Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.25 최윤성
* 1.0 Creation
* 2011.01.05 최윤성 [CHM-201008093-01] Office Level Table 생성
 - 쿼리에 사용하기위해 파라메타로 TRD_CD 넘김
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
     * @class ESM_SPC_0066 : ESM_SPC_0066 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0066() {
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

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
             var sheetObject = sheetObjects[0];
             /*******************************************************/
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
            	    case "btn_retrieve":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
            	        break;

            	    case "btn_new":
        	            sheetObject.RemoveAll();
            	        break;

            	    case "btn_save":
        	            doActionIBSheet(sheetObject,formObject,IBSAVE);
            	        break;

            	    case "btn_close":
                    	window.returnValue = "CANCEL";
                    	self.close();
            	        break;

                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
        		} else {
        			ComShowMessage(e);
        		}
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
        	var sheetObject = sheetObjects[0];
        	var formObject  = document.form;
        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                        // 높이 설정
                        style.height = GetSheetHeight(10) ;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msNone;
                        
                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 1, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(14, 0 , 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false) ;
                        
                        var HeadTitle = "Status|flag|Check|Sales Office|POL|POD|T/S Flag|R.Lane|Dir|V|V|D|IOC";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , isDevMode?dtStatus:dtHiddenStatus,   50,    daLeft  ,   true,    "ibflag",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "mode",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtCheckBox,   100,    daCenter  ,   true,    "chk",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtData    ,   100,    daCenter  ,   true,    "sls_ofc_cd",     false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "pol_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "pod_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "ts_flg",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "rlane_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "dir_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "vsl_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "skd_voy_no",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "skd_dir_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "ioc_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "sls_rgn_ofc_cd",     false,          "",       dfNone,       0,     true,       true);
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				formObj.f_cmd.value = SEARCHLIST;
    				sheetObj.ReDraw=false;
    				
    				var param = SpcFormString(formObj,"f_cmd,trd_cd,rlane_cd,dir_cd,vsl_cd,skd_voy_no,skd_dir_cd,ioc_cd,pol_cd,pod_cd,ofc_cd");
    				
    				//sheetObj.DoSearch4Post("ESM_SPC_0066GS.do", FormQueryString(formObj));
    				sheetObj.DoSearch4Post("ESM_SPC_0066GS.do", param);
    				
    				sheetObj.ReDraw=true;
                    break;
                case IBSAVE:        //저장
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
                     
                    var rows = sheetObj.GetTransColText("U", "ibflag");
                    var rowArr = rows.split(";");
                    var rowCnt = rowArr.length;
                    for(var i = 0 ; i < rowCnt ; i++){
                    	var rowInfo = rowArr[i].split("=");
                    	var row = rowInfo[0]*1;
                    	if(sheetObj.CellValue(row, "mode") == "I"){
                    		sheetObj.RowStatus(row) = "I";
                    	}
                    	else{
                    		sheetObj.RowStatus(row) = "D";
                    	}
                    }
                    formObj.f_cmd.value = MULTI;
                    
                    var param = SpcFormString(formObj,"f_cmd");
                    
                    //var rtn = doSaveSheet(sheetObj, "ESM_SPC_0066GS.do", FormQueryString(formObj));
                    var rtn = doSaveSheet(sheetObj, "ESM_SPC_0066GS.do", param);
                    if(rtn == "OK"){
                    	window.returnValue = "OK";
                    	self.close();
                    }
                    break;
            }
        }
        
        function sheet11_OnChange(sheetObj, row, col, val)
        {
        	var colName = sheetObj.ColSaveName(col);
        	ComShowMessage(colName);
        	//switch(colName){
        		//case "chk":
        			if(sheetObj.CellValue(row, col) == "Y"){
       					sheetObj.CellValue2(row) = sheetObj.CellValue(row, "mode");
        			}
        			else{
        				if(sheetObj.CellValue(row, "mode") == "I"){
        					sheetObj.RowStatus(row) = "R";
        				}
        				else{
        					sheetObj.RowStatus(row) = "D";
        				}
        			}
        			//break;
        	//}
        }

       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
//                    return false;
//                }
            }
            return true;
        }


	/* 개발자 작업  끝 */