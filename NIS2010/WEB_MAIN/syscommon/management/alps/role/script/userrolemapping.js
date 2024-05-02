var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	            self.close();
        	        break;

            case "btn_close":
                self.close();
                break;
            
            case "btn_DownExcel":
            	sheetObject.SpeedDown2Excel(-1, true, true);
            	break;
            	
            case "btn_viewflg":
            	doActionIBSheet(sheetObject, formObject, MULTI04);
            	break;
					
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(getMsg('COM12111'));
    		} else {
    			ComFuncErrMsg(e);
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
          ComConfigSheet(sheetObjects[i]);
          initSheet(sheetObjects[i],i+1);
          ComEndConfigSheet(sheetObjects[i]);
      }
      
      doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        sheetObj.WaitImageVisible = false;

        switch(sheetNo) {
             case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240 ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false) ;

                    var HeadTitle = "|Level|Role Code|Role Name|admin|STS";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    if(document.form.admin_page.value == "N") {	// 일반 사용자
	                    InitDataProperty(0, cnt++ , dtCheckBox,     20,   daCenter,   false,    "check_val",   false,        "",       dfNone,        0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "Level",       false,        "",       dfNone,        0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "usr_role_cd", false,         "",       dfNone,        0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtData,        200,   daLeft,     false,    "usr_role_nm", false,         "",       dfNone,	      0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtHidden, 		50,   daCenter,   false,    "admin_chk");
	                    InitDataProperty(0, cnt++ , dtHiddenStatus, 50,   daCenter,   false,    "ibflag");                    
                    } else {                    	
                    	InitDataProperty(0, cnt++ , dtCheckBox,     20,   daCenter,   false,    "check_val");
	                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "Level",       false,        "",       dfNone,        0,     false,       true);
	                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "usr_role_cd", true,         "",       dfNone,        0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtData,        200,   daLeft,     false,    "usr_role_nm", true,         "",       dfNone,	      0,     false,       false);
	                    InitDataProperty(0, cnt++ , dtHidden, 		50,   daCenter,   false,    "admin_chk");
	                    InitDataProperty(0, cnt++ , dtHiddenStatus, 50,   daCenter,   false,    "ibflag");
                    }

                    InitTreeInfo(1, "Level");
               }
             break;
        }
    }

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
           case IBSEARCH:      //조회
              //sheetObj.CheckAll("checkbox")='0';
              formObj.f_cmd.value = SEARCH01;
              var sXml = sheetObj.GetSearchXml("searchRoleMapping.do", FormQueryString(formObj));
              formObj.view_flg.value = ComGetEtcData(sXml, "view_flg");
              sheetObj.LoadSearchXml(sXml);
              break;
                
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction)){
                  formObj.f_cmd.value = MULTI;
                  sheetObj.DoSave("searchRoleMapping.do", FormQueryString(formObj),"ibflag",false,true);
              }
              break;
            case MULTI04:		//저장
				formObj.f_cmd.value = MULTI04;
				sheetObj.DoSearch("searchUserProgramMapping.do", FormQueryString(formObj));
				alert('Data was saved successfully.');
				break;
        }
    }
    
    /**
     * 데이타를 저장한 후에 처리하는 함수
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
    function sheet1_OnSaveEnd(sheetObj,errMsg){
      if(errMsg == null || errMsg == ""){
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      }else{
        //alert(errMsg);
      }
    }

     /**
      * 데이타를 조회한 후에 처리하는 함수
      * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
      */
     function sheet1_OnSearchEnd(sheetObj,errMsg){
       // Super User가 일반사용자에게 Role 부여하는 경우, 관리할 수 있는 Role 만 체크할 수 있도록 처리함
       var login_usr_auth_tp_cd = document.form.login_usr_auth_tp_cd.value;	// 로긴 사용자의 User Auth Type (A, S...)      
       var firstRow = 1;
       if(login_usr_auth_tp_cd == "S") {
 		  // 관리 대상 User가 Almighty 또는 System Admin 인 경우	  
 		  var usr_auth_tp_cd = document.form.usr_auth_tp_cd.value;
 		  if(usr_auth_tp_cd == "A" || usr_auth_tp_cd == "E") {
 			  	for(var i=1; i<sheetObj.rowCount+1; i++) {   	      		
 			   		sheetObj.CellEditable(i, "check_val") = false;
 			  	} 
 		  } else {	// Super User 또는 Regular User 인 경우
 		      	for(var i=1; i<sheetObj.rowCount+1; i++) {   	      		
 			   		if(sheetObj.CellValue(i, "admin_chk") == "Y") {
 			   			sheetObj.CellEditable(i, "check_val") = true;
 			   			sheetObj.CellFontColor(i, "usr_role_cd") = sheetObj.WebColor("#0000FF");
 			   			sheetObj.CellFontColor(i, "usr_role_nm") = sheetObj.WebColor("#0000FF");
 			   			if ( firstRow == 1 ) firstRow = i;
 			  		} else {
 			  			sheetObj.CellEditable(i, "check_val") = false;
 			  		}
 			  	} 
 		  }
       }
       sheetObj.TopRow = firstRow;
     }
     
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }
