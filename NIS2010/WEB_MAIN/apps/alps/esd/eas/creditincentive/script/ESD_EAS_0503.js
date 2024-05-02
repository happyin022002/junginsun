//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;
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

                case "btn_close":
        			errMsg = ComGetMsg("TRS90703");
        			ComShowMessage(errMsg);
    	            self.close();
        	    break;
                case "btn_downexcel":
                	sheetObject.Down2Excel(-1, false, false, true);
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
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        
        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
      	initControl();
     	
        doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }
    
   
    /**
     * 
     */
     function initControl() {
      	var formObject = document.form;
          axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);
          axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
      }

      //업무 자바스크립트 OnKeyPress 이벤트 처리
      function keypressFormat() {
      	obj = event.srcElement;
    	    if(obj.dataformat == null) return;
    	    window.defaultStatus = obj.dataformat;
    	    switch(obj.dataformat) {
    	        case "engup":
    	        	ComKeyOnlyAlphabet('upper');
    	        break;
    	            
    	        case "number":
    	        	ComKeyOnlyNumber(obj);
    	        break;
    	    }
      }
    
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = 100;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 5000);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true); // 맨 앞에 번호 row

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    var HeadTitle0 = "Sel|Maker|Maker|Issued|Used|Balance|" ;
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
    				//데이터속성    [ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtDataSeq,    	40,   	daCenter,  	true,    "seq");
                    InitDataProperty(0, cnt++ , dtHidden,     	60,    	daCenter,   false,   "mkr_cd",  		false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	100,  	daLeft,  	false,   "mkr_nm",      	false,          "",       dfNone,       0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	90,  	daRight,  	false,   "cr_iss_amt",      false,          "",       dfNullFloat,       2,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	90,  	daRight,  	false,   "cr_usd_amt",      false,          "",       dfNullFloat,       2,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,     	90,  	daRight,  	false,   "cr_bal_amt",      false,          "",       dfNullFloat,       2,     false,       true);
    				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   	daCenter,  	true,    "ibflag");

               }
               break;
        }
    }
    
  
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
           case IBSEARCH:         // 조회
        	   formObj.f_cmd.value = SEARCHLIST07;   
	           sheetObj.DoSearch4Post("ESD_EAS_0501GS.do",FormQueryString(formObj));
           break;
        }
    }

	/**
	 * sheet1 Search End Event
	 * Total 
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.SubSumBackColor = sheetObj.RgbColor(247,231,236);
		sheetObj.ShowSubSum("ibflag","cr_iss_amt|cr_usd_amt|cr_bal_amt",-1,true,false,0,"0=Total");
	}
