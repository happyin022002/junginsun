var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  */
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

		    	case "btn_DownExcel":
		    		doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
		    		break;

        	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
    	    		self.close();
        	        break;

                case "btn_close":
                    self.close();
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
                    
                    var HeadTitle = "|Level|Role Code|Role Name|Mapped Program|Program NO|STS"; 
                	var headCount = ComCountHeadTitle(HeadTitle);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                 

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false) ;

                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,      WIDTH,  DATAALIGN,  COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,     20,   daCenter,   false,    "check_val");
                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "level",       false,        "",       dfNone,        0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,   false,    "usr_role_cd", true,         "",       dfNone,        0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,        200,   daLeft,     false,    "usr_role_nm", true,         "",       dfNone,	      0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopup,       5,  	daCenter,  		false,    	"roles",          	false,      "",       	dfNone,     0,     		true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,        100,   daLeft,     false,    "pgm_no");
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 50,   daCenter,   false,    "ibflag");
                    
                  
                    
                	CountPosition = 0;
					
					ImageList(0) = "/hanjin/img/btns_search.gif";
                  
                    PopupButtonImage(0,"roles") = 0;
                    ShowButtonImage = 2;
                    
                    InitTreeInfo(1, "Level");
               }
             break;
        }
    }
    
    
    function sheet1_OnPopupClick(sheetObj,Row,Col){
    	var prefix = "sheet1_";
        switch (sheetObj.ColSaveName(Col)) {
       	
       		
       		case "roles" :
       			ComOpenPopup('/hanjin/programMapping.do?role_cd='+sheetObj.CellValue(Row,"usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,"usr_role_nm")), 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
            	//doActionIBSheet(sheetObj,document.form,IBSEARCH);
       				//var url = '/hanjin/progRoleMapping.do?pgm_no='+sheetObj.CellValue(Row,"pgm_no")+"&pgm_nm="+escape(sheetObj.CellValue(Row,"pgm_nm"));
       				//ComOpenPopup(url,700,474, '','1,0',true,false,Row,Col,0);
//    		     ComOpenPopup('/hanjin/programMapping.do?role_cd='+sheetObj.CellValue(Row,prefix + "usr_role_cd")+"&role_nm="+escape(sheetObj.CellValue(Row,prefix + "usr_role_nm")), 800, 474, 'setPrntUsrRoleCd', '1,0,1,1,1,1,1,1,1,0', true, false, Row, Col, 0);
       			
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
              sheetObj.DoSearch4Post("searchProgRoleMapping.do", FormQueryString(formObj));
              break;
                
            case IBSAVE:        //저장
              if(validateForm(sheetObj,formObj,sAction)){
                  formObj.f_cmd.value = MULTI;
                  sheetObj.XmlHttpVer = 1;
                  sheetObj.DoSave("searchProgRoleMapping.do", FormQueryString(formObj));
              }
              break;

            case IBDOWNEXCEL:	//엑셀다운로드
				sheetObj.SpeedDown2Excel(1);
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

    function chkBox(checked) {
    	
       //alert(1);
        		
        		if(checked==true)
        		{
        		    for ( var idx = 1; idx <= sheetObjects[0].RowCount; idx++) {     
        	        	 	if(sheetObjects[0].CellValue(idx,'check_val') == 1 )
        	        	 	{
        	        		 	
        	        		 	sheetObjects[0].RowHidden(idx) = false;
        	        	 	}
        	        	 	else
        	        		 {
        	        	 		sheetObjects[0].RowHidden(idx) = true;
        	        		 }
        	        	  
        	   			}
        		}
        		else
        		{
        			for ( var idx = 1; idx <= sheetObjects[0].RowCount; idx++) {     
             			sheetObjects[0].RowHidden(idx) = false;
             		}
        		}
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
