
 function ESM_BKG_1221() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

//공통전역변수

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
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					
					
					case "btn_calendar":
		                var cal = new ComCalendarFromTo();
		                cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
						break;

						
					case "btn_new":
						doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
						break;
						
						
					case "btn_exceldown":
						doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
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
      
		//화면에서 필요한 이벤트
 	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
 	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
 	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 	axon_event.addListenerForm('click', 'obj_click', document.form); // click

 	//초기셋팅
// 	initPage();
 	
      
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
                  style.height = 440;
                  //전체 너비 설정
                  SheetWidth = mainTable.clientWidth;

                  //Host정보 설정[필수][HostIp, Port, PagePath]
                  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                  //전체Merge 종류 [선택, Default msNone]
                  MergeSheet = msHeaderOnly;

                 //전체Edit 허용 여부 [선택, Default false]
                  Editable = true;

                  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                  InitRowInfo( 1, 1, 15, 100);


                  // 해더에서 처리할 수 있는 각종 기능을 설정한다
                  InitHeadMode(true, true, false, true, false,false)

                  var HeadTitle1 = "|Seq.|CTR|Bay\nLocation|Cntr No|Cntr\nWeight|Type|CNTR\nStatus|IMO|POL|POD|Category|Departure\nmode|Cntr\nOperator|Reefer\nflag|Temperature|Unit";

					 var headCount = ComCountHeadTitle(HeadTitle1);

					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					 InitColumnInfo(headCount, 0, 0, true);
                  
                  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                  InitHeadRow(0, HeadTitle1, true);

                  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		 daCenter,		 true,		"ibflag");
	                 InitDataProperty(0, cnt++ , dtSeq,  				30,     daCenterTop, 	 true,      "seq");
	                 InitDataProperty(0, cnt++ , dtData, 				60,    daCenterTop, 	 true,      "ctr",      		false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				60,    daCenterTop, 	 true,      "bay_loc",  		false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				125,    daCenterTop, 	 true,      "cntr_no",		false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				100,    daCenterTop, 	 true,      "meas_qty",   	false,       "",      dfNone,   		0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				70,    daCenterTop, 	 true,      "iso_cd",   		false,       "",      dfNone,			0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				80,    daCenterTop, 	 true,      "sts",      		false,       "",      dfNone,			0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				50,    daCenterTop, 	 true,      "imo",  			false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				50,    daCenterTop, 	 true,      "pol",				false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				50,	 	 daCenterTop,	 true,	    "pod",				false,		 "",	  	  dfNone,			0,	   true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				65,    daCenterTop, 	 true,      "cate",			false,       "",      dfNone,      	0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				80,    daCenterTop, 	 true,      "kind",   			false,       "",      dfNone,   		0,     true,		false);
	 		         InitDataProperty(0, cnt++ , dtData, 				95,    daCenterTop, 	 true,      "line",    			false,       "",      dfNone,   		0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData,				75,    daCenterTop, 	 true,      "rf_flg",    		false,       "",      dfNone,   		0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				90,    daCenterTop, 	 true,      "temp",    		false,       "",      dfNone,   		0,     true,		false);
	                 InitDataProperty(0, cnt++ , dtData, 				40,    daCenterTop, 	 true,      "unit",    			false,       "",      dfNone,   		0,     true,		false);
										
//	                 InitUserFormat2(0, "ack_dt", "####-##-## ##:##", "-|:" );
//	                 InitUserFormat2(0, "apro_dt", "####-##-## ##:##", "-|:" );
//	                 
//	                 WaitImageVisible=false;
//
	                 // 자동 행 높이 지정
	                 AutoRowHeight = false;
	                 // 행 높이 설정
	                 DataRowHeight = 22;
	                 
             }
              
             break;

      }
  }
  
//Sheet관련 프로세스 처리
  function doActionIBSheet(sheetObj,formObj,sAction) {
		//alert(1);
	     sheetObj.ShowDebugMsg = false;
	     
	     switch(sAction) {

	     	case IBSEARCH:      //조회
	     	
	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
					
	     		
					//ComOpenWait(true);
					formObj.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(formObj);
				
					//ComShowMessage("sParam : " + sParam);
					sheetObj.DoSearch("ESM_BKG_1222GS.do",sParam);
					//ComOpenWait(false);
					
	
					
					break;

			case "btn_exceldown":
			
				sheetObj.SpeedDown2Excel(1);
				
				
			//	alert("엑셀다운 눌렀을때2");
				break;
				
				
			case IBCLEAR: //조회조건 초기화
				
				formObj.reset();
				//comboObjects[0].Code = 'AL';
				sheetObj.RemoveAll();
				
				//alert("초기화 버튼 눌렀을때");
				break;
	     }
	 }
  
  
  
  /**
   * 화면 폼입력값에 대한 유효성검증 프로세스 처리
   */
  function validateForm(sheetObj,formObj,sAction){
  	
	    switch(sAction) {
	    
	    	case IBSEARCH: { // Retrieve
	    		if (!ComChkRequired(formObj))
					return false;
				
				break;
	    	}

	    }
      return true;

  }
  
