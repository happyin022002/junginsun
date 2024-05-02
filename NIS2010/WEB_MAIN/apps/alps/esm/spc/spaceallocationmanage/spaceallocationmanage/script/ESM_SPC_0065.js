/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0065.js
*@FileTitle : Temporary Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.21 최윤성
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
     * @class ESM_SPC_0065 : ESM_SPC_0065 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0065() {
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

            	    case "btn_add":
        	            doActionIBSheet(sheetObject,formObject,IBINSERT);
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
        	sheetObjects[sheetCnt++] = sheet_obj;}

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
            var formObject = document.form;
            //doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
                        InitColumnInfo(12, 0 , 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, true, false, true, false,false) ;


                        var HeadTitle = "SEQ|Del|Sales Office|POL|POD|T/S Flag|R.Lane|Dir|V|V|D|Status";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0, cnt++ , dtDataSeq ,    50,    daCenter,   true,    "",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtDelCheck,   50,    daLeft  ,   true,    "",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , dtPopupEdit,   100,    daCenter  ,   true,    "sls_ofc_cd",     true,          "",       dfNone,       0,     true,       true, 6);
                        InitDataProperty(0, cnt++ , dtPopupEdit,   100,    daCenter  ,   true,    "pol_cd",     true,          "",       dfNone,       0,     true,       true, 7);
                        InitDataProperty(0, cnt++ , dtPopupEdit,   100,    daCenter  ,   true,    "pod_cd",     true,          "",       dfNone,       0,     true,       true, 7);
                        InitDataProperty(0, cnt++ , dtCheckBox,   100,    daCenter  ,   true,    "ts_flg",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "rlane_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "dir_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "vsl_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "skd_voy_no",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,   50,    daCenter  ,   true,    "skd_dir_cd",     false,          "",       dfNone,       0,     true,       true);
                        InitDataProperty(0, cnt++ , isDevMode?dtStatus:dtHiddenStatus,   50,    daLeft  ,   true,    "ibflag",     false,          "",       dfNone,       0,     true,       true);
                   		InitDataValid(0, "sls_ofc_cd", vtEngUpOnly, "");
//                   		InitDataValid(0, "pol_cd", vtEngUpOnly, "");
//                   		InitDataValid(0, "pod_cd", vtEngUpOnly, "");
                   }
                    break;

            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

                case IBSAVE:        //저장
                  if(validateForm(sheetObj,formObj,sAction))
                     
                    formObj.f_cmd.value = MULTI;
                    var rtn = doSaveSheet(sheetObj, "ESM_SPC_0065GS.do", "f_cmd="+MULTI);
                    if(rtn == "OK"){
                    	window.returnValue = "OK";
                    	self.close();
                    }
                    break;

               case IBINSERT:      // 입력
                    var row = sheetObj.DataInsert();
                    if(row > 0){
                    	sheetObj.CellValue(row, "rlane_cd")   = formObj.rlane_cd.value;
                    	sheetObj.CellValue(row, "dir_cd")     = formObj.dir_cd.value;
                    	sheetObj.CellValue(row, "vsl_cd")     = formObj.vsl_cd.value;
                    	sheetObj.CellValue(row, "skd_voy_no") = formObj.skd_voy_no.value;
                    	sheetObj.CellValue(row, "skd_dir_cd") = formObj.skd_dir_cd.value;
                    }
                    break;

            }
        }
        
        function sheet1_OnChange(sheetObj, row, col, value){
        	//getCodeList
        	var colName = sheetObj.ColSaveName(col);
        	
        	switch(colName){
        		case "sls_ofc_cd":
    				var rtn   = getCodeList("Office", "ofc_cd="+value+"%");
    				var codes = rtn[0].split("|");
    				var size  = codes.length - 1;
    				if(size == 0){
    					sheetObj.CellValue2(row, col) = "";
    				} else if(size == 1){
    					sheetObj.CellValue2(row, col) = codes[0];
    				} else if(size > 1){
    					sheetObj.CellValue2(row, col) = "";
    					spcPopup("SalesOffice", "ofc_cd="+value, 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    				}
        			break;
        		case "pol_cd":
    				var rtn   = getCodeList("Yard", "yard_cd="+value);
    				var codes = rtn[0].split("|");
    				var size = codes.length - 1;
    				if(size == 0){
    					sheetObj.CellValue2(row, col) = "";
    				} else if(size == 1){
    					sheetObj.CellValue2(row, col) = codes[0];
    				} else if(size > 1){
    					sheetObj.CellValue2(row, col) = "";
    					//spcPopup("POL", "loc_port_ind=Y&loc_cd="+value, 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    					spcPopup("Yard", "mode_only=Y&node_cd="+value.toUpperCase(), 770, 425, "getLeg", "1,0,1,1,1,1,1,1,1,1,1,1", row, col);
    				}
        			break;
        		case "pod_cd":
    				var rtn   = getCodeList("Yard", "yard_cd="+value);
    				var codes = rtn[0].split("|");
    				var size  = codes.length - 1;
    				if(size == 0){
    					sheetObj.CellValue2(row, col) = "";
    				} else if(size == 1){
    					sheetObj.CellValue2(row, col) = codes[0];
    				} else if(size > 1){
    					sheetObj.CellValue2(row, col) = "";
    					//spcPopup("POD", "loc_port_ind=Y&loc_cd="+value, 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    					spcPopup("Yard", "mode_only=Y&node_cd="+value.toUpperCase(), 770, 425, "getLeg", "1,0,1,1,1,1,1,1,1,1,1,1", row, col);
    				}
        			break;
        	}
        }
        
        function sheet1_OnPopupClick(sheetObj, row, col) {
        	var colName = sheetObj.ColSaveName(col);
        	switch(colName){
        		case "sls_ofc_cd":
    				var ofc_cd = sheetObj.CellValue(row, col);
    				spcPopup("SalesOffice", "", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
        			break;
        		case "pol_cd":
    				var port_cd = sheetObj.CellValue(row, col);
    				//spcPopup("POL", "loc_port_ind=Y", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    				spcPopup("Yard", "mode_only=Y&node_cd="+port_cd, 770, 425, "getLeg", "1,0,1,1,1,1,1,1,1,1,1,1", row, col);
        			break;
        		case "pod_cd":
    				var port_cd = sheetObj.CellValue(row, col);
    				//spcPopup("POD", "loc_port_ind=Y", 770, 470, "getLeg", "1,0,1,1,1,1,1,1", row, col);
    				spcPopup("Yard", "mode_only=Y&node_cd="+port_cd, 770, 425, "getLeg", "1,0,1,1,1,1,1,1,1,1,1,1", row, col);
        			break;
        	}
        }

    	function getLeg(rowArray, row, col){
    	    var colArray = rowArray[0];
    		sheetObjects[0].CellValue2(row, col) = colArray[3];
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