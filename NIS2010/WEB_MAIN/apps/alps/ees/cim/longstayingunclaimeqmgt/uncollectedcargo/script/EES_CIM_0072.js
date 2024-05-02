/*=========================================================
* *Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0072.js
*@FileTitle : UC Authorizer
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.15
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.15 백형인
* 1.0 Creation
* 
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
    * @class Owner list : Owner list 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
    */
    function ees_cim_0072() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl          	= initControl;
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

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
       /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];

       /*******************************************************/
       var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
          	switch(srcName) {

            	case "btn_retrieve":
	             	doActionIBSheet(sheetObject, document.form, IBSEARCH);
                break;

				case "btn_new":
					ComResetAll();
                break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
                break;

				case "btn_add":
					
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert(-1);
					sheetObject.SelectCell(row, "uc_auth_usr_id");
					
                break;
	
				case "btn_ins":
					if(!validateForm(sheetObject,formObject)) return;
					
					var row = sheetObject.DataInsert();
					sheetObject.SelectCell(row, "uc_auth_usr_id");
					
					break;

				case "btn_del":
//					if(checkBoxCheckYn(sheetObject, "DelChk")) { 
						ComRowHideDelete(sheetObject, "DelChk"); 
//					}
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
           ComConfigSheet (sheetObjects[i] );

           initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
           ComEndConfigSheet(sheetObjects[i]);
        }

        //Grid 마지막 컬럼의 크기가 그리드 사이즈에 맞게 늘어나지 않게 함.
        sheetObjects[0].ExtendLastCol = false;
        
        //html컨트롤 이벤트초기화
        initControl();
    }
    
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj, document.form, IBSEARCH);
		
		sheetObj.WaitImageVisible = true;   
    }

	
	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "/";
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리

    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
           case 1:     //sheet1 init
              with (sheetObj) {

                 // 높이 설정
                 style.height = 420;
                 //전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 1, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(6, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다 
                 InitHeadMode(true, true, false, true, false,false)

                 var HeadTitle = "|Sel|Seq|Office|ID|NAME";

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle, true);
//dtHiddenStatus
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    daCenter,  false,   "DelChk");
				InitDataProperty(0, cnt++ , dtSeq,        	40,    daCenter,  false,   "Seq");
                InitDataProperty(0, cnt++ , dtCombo,  	    110,   daCenter,  false,   "uc_auth_ofc_cd",   false,        "",     dfNone,    0,    true,      true);
				InitDataProperty(0, cnt++ , dtData,   	    110,   daCenter,  false,   "uc_auth_usr_id",   false,        "",     dfNone,    0,    true,      true,   20);
				InitDataProperty(0, cnt++ , dtData,   	    200,   daLeft,    false,   "usr_nm",	       false,        "",     dfNone,    0,    true,      true);
					
				SelectBackColor = RgbColor(219,245,219);
				
				SelectionMode = smSelectionRow;
				//InitDataCombo(0, "uc_auth_ofc_cd", "HAMUR|NYCNA|SINWA|SHAAS|SELIB|TYOIB|SELCOE", "HAMUR|NYCNA|SINWA|SHAAS|SELIB|TYOIB|SELCOE");
				//InitDataCombo(0, "uc_auth_ofc_cd", "HAMRU|NYCRA|SINRS|SHARC|SELIB|TYOIB|SELOPE", "HAMRU|NYCRA|SINRS|SHARC|SELIB|TYOIB|SELOPE");
				InitDataCombo(0, "uc_auth_ofc_cd", "HAMRU|NYCRA|SINRS|SHARC|SELIB|TYOIB|SELCTY", "HAMRU|NYCRA|SINRS|SHARC|SELIB|TYOIB|SELCTY");
             }
              break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

         	case IBSEARCH:      //조회
        		formObj.f_cmd.value = SEARCH01;
        	   	sheetObj.DoSearch("EES_CIM_0072GS.do", FormQueryString(formObj));
        	   
                break;

           	case IBSAVE:        //저장
	 			if(!validateForm(sheetObj,formObj,sAction))return;
	 			
	 			formObj.f_cmd.value = MULTI;
	 			for(var i=0;i<=sheetObj.RowCount;i++){
	 				if(sheetObj.RowStatus(i)!="D"){
	 					sheetObj.RowStatus(i) = "I";
	 				}
	 			}
	 			sheetObj.DoAllSave("EES_CIM_0072GS.do", FormQueryString(formObj)); 
	 			
                break;



        }
    }




    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//           if (!isNumber(formObj.iPage)) {
//              return false;
//           }
        }

        return true;
    }

    /**
     * sheet1 편집처리후 이벤트
     * @param {long}   row 해당 셀의 Row Index
     * @param {long}   col 해당 셀의 Column Index
     * @param {string} col 해당 셀의 value 
     * 
     */
    function sheet1_OnChange(sheet, row, col ,value) {
    	
    	// 사번을 입력 할경우
    	if (col == sheet.SaveNameCol("uc_auth_usr_id") ) {
           
    		if(sheet.CellValue(row, "uc_auth_usr_id")==""||sheet.CellValue(row, "uc_auth_usr_id")==null){
    			sheet.CellValue2(row, "uc_auth_usr_id")=""
    			sheet.CellValue2(row, "usr_nm")=""
    			return;
    		}
    		
    		// 해당 오피스 에 입력가능한 사번인지 유무 체크
    		var ofcCd  = sheet.CellValue(row, "uc_auth_ofc_cd");
    		var param = "f_cmd=" + SEARCH02;
    		    param    += "&uc_auth_ofc_cd=" + ofcCd + "&uc_auth_usr_id=" + value;
    		var sXml = sheet.GetSearchXml("EES_CIM_0072GS.do", param);

    		var sCnt = ComGetEtcData(sXml,"cnt");
    		var sUsrNm = ComGetEtcData(sXml,"usr_nm"); 
    		var isFalg = ComGetEtcData(sXml,"isfalg"); 
    		
    		if(isFalg==1){
    			//이미 선택하신 오피스코드에 등록된 사용자입니다.
    		   alert("The user has already been registered."); 
    		   sheet.CellValue2(row, "uc_auth_usr_id") = "";
    		   return;
    		 }
  		
    		if (sCnt == 0) {
    			//잘못된 사번이거나 선택하신 오피스코드에 등록할수 없는 사번입니다.
    			alert("Invalid or not authorized ID! ")
   		       //msgs["CIM01039"] = "잘못된 사번이거나 선택하신 오피스코드에 등록할수 없는 사번입니다.";
               //ComShowCodeMessage("CIM01039");
			   sheet.CellValue2(row, "uc_auth_usr_id") = "";
		    }else if((sCnt == 1)){ // SELCOE 제외한 offcd
			   sheet.CellValue2(row , "usr_nm") =  sUsrNm;
		    }else if((sCnt == 2)){// SELCOE 인경우
	    	   sheet.CellValue2(row , "usr_nm") =  sUsrNm;
		    }
    	}
    }    
    
    function sheet1_OnSaveEnd(ErrMsg){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }



	/* 개발자 작업  끝 */