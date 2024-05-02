/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0020.js
*@FileTitle : Maximun L/F Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.28 이현주
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업  
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
     * @class ESM_SPC_0020 : ESM_SPC_0020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0020() {
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
         
    var init_year = '';
    //sheetResizeFull = true;
                        
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

            	    case "btn_downexcel":
            	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	        break;

            	   
            	    case "btn_new":
        	            sheetObject.RemoveAll();
        	            formObject.reset();
        	            formObject.year.value = init_year;
        	            
						SpcSearchOptionTrade("rep_trade");
						SpcSearchOptionSubTrade("sub_trade", true, true);
						SpcSearchOptionLane("lane"); // 0207 SHKIM  	    		
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
        function setComboObject(combo_obj){
           comObjects[comboCnt++] = combo_obj;
        }    

        /**
         * Sheet 기본 설정 및 초기화
         * body 태그의 onLoad 이벤트핸들러 구현
         * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
         */
        function loadPage() {
        	SpcSearchOptionYear("year");
         	SpcSearchOptionTrade("rep_trade");
         	SpcSearchOptionSubTrade("sub_trade", true, true);
         	SpcSearchOptionLane("lane");
         	SpcSearchOptionBound("bound",false,true,false,false);
         	
            for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
                ComConfigSheet(sheetObjects[i]);

                initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            var sheetResizeFull = true;
            
    		document_onresize();
    		
            document.form.year.focus();
            
            init_year = document.form.year.value; // 년 초기화용
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
                        style.height = getSheetHeight(22) ;
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                        Editable = false;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(10, 0 , 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, false, false, false,false) ;


                        var HeadTitle0 = "SEQ|Trade|Sub Trade|Lane|Bound|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)";
                        var HeadTitle1 = "SEQ|Trade|Sub Trade|Lane|Bound|W5|W4|W3|W2|W1";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                        InitDataProperty(0, cnt++ , dtSeq ,     30,    daCenter,   true,    "",            false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    85,    daCenter,   true,    "trd_cd",      false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   true,    "sub_trd_cd",  false,          "",       dfNone,       0,     false,       false);

                        InitDataProperty(0, cnt++ , dtData ,    85,    daCenter,   true,    "rlane_cd",    false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   true,    "dir_cd",      false,          "",       dfNone,       0,     false,       false);
                        
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   false,    "ldf_05",     false,          "",       dfFloat,       0,     true,       true,4);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   false,    "ldf_04",     false,          "",       dfFloat,       0,     true,       true,4);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   false,    "ldf_03",     false,          "",       dfFloat,       0,     true,       true,4);
                        InitDataProperty(0, cnt++ , dtData ,    60,    daCenter,   false,    "ldf_02",     false,          "",       dfFloat,       0,     true,       true,4);
                        InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   false,    "ldf_01",     false,          "",       dfFloat,       0,     true,       true,4);
     
                        CellBackColor(1,5) = RgbColor(222, 251, 248);
                        for(var i = 5 ; i <12 ; i ++)
                        {
                            CellBackColor(1,i) = CellBackColor(1,5);
                        }

                   }
                    break;

            }
        }
          // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;

            switch(sAction) {

               case IBSEARCH:      //조회
                     
                    formObj.f_cmd.value = SEARCHLIST;   
                    
                    sheetObj.ReDraw=false;
                    
                    var param = "f_cmd=" + formObj.f_cmd.value;
                    param = param + "&year="      + formObj.year.value;
                    param = param + "&rep_trade=" + comObjects[0].Code;
                    param = param + "&sub_trade=" + comObjects[1].Code;
                    param = param + "&lane="      + comObjects[2].Code;
                    param = param + "&bound="     + formObj.bound.value;
                    
                    //sheetObj.DoSearch("ESM_SPC_0020GS.do",FormQueryString(formObj));                    
                    sheetObj.DoSearch("ESM_SPC_0020GS.do",param);
                    sheetObj.ReDraw=true;                
                    break;
              case IBCLEAR:        //초기화
                  //공통함수사용: 화면을 초기화
    													 resetAll(); 
                  break;               
              case IBDOWNEXCEL:        //엑셀 다운로드
                  sheetObj.Down2Excel(-1, false, false, true);
                  break;

            }
        }

     
        function sheet_OnChange(sheetObj, row, col, val){
     
        }

        
        function rep_trade_OnBlur(comObj){
           var finded = comObj.FindIndex(comObj.Text() , 0);
            comObj.Code = finded;
       }  
       
       function rep_trade_OnChange(comObj,value,text ){
    	    if(text == '|ALL'){	optionAllReset3("rep_trade",value,"true");   return;} // 0207 SHKIM
       		//sub_trade의 초기화
            comObjects[1].Index2 = 0;     
            //lane의 초기화
            comObjects[2].Index2 = 0;        
            SpcSearchOptionSubTrade("sub_trade",true,true,"","",value);			// 0207 SHKIM
        	//SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
			SpcSearchOptionLane("lane",true,false,'',value,'',true);	// 0207 SHKIM
       }   
        function sub_trade_OnBlur(comObj){
           var finded = comObj.FindIndex(comObj.Text() , 1);
            //comObj.Code = finded;
            if( finded == -1){
                comObj.Code =0;
            }else{
                comObj.Code =finded;
            }
           
           //document.getElementById("message").innerHTML += "onBlur<BR>";
       } 

        function sub_trade_OnChange(comObj,value,text ){
        	if(text == '||ALL'){   optionAllReset3("sub_trade",document.form.rep_trade.Code,"true"); return; } // 0207 SHKIM
            if(value != "" ){  
              comObjects[0].Code2 = comObj.GetText(value,0);  
            }
            //lane의 초기화
            comObjects[2].Index2 = 0;     
            SpcSearchOptionLane("lane",true,false,'',document.form.rep_trade.Code,value,true);	// 0207 SHKIM
       } 
       
        function lane_OnChange(comObj,value,text ){
        	var repTrade = comObj.GetText(value,0);  
           var subTrade = comObj.GetText(value,1);
           if(value != "" ){  
               comObjects[0].Code2 = repTrade;
               comObjects[1].Code2 = subTrade;
           }
       }    
        function lane_OnBlur(comObj){
           var finded = comObj.FindIndex(comObj.Text() , 2);
            comObj.Code = finded;
       }        
     
       
        /*
         * 조회 데이타를 FORM 에 넣을 때.
         */
        function sheet_OnSearchEnd(sheetObj, errMsg) {
          if(sheetObj.EtcData("status") != "OK"){	   
        	    ComShowMessage(errMsg);
          }
      	  //IBS_EtcDataToForm2(document.form, sheetObj);
      	}
    	
    	    /*
         * 저장후 호출
         */
        function sheet_OnSaveEnd(sheetObj, errMsg) {
            
      	  if(sheetObj.EtcData("status") != "OK"){	   
      		   ComShowMessage(errMsg);
          }
      	   
      	}
    
	/* 개발자 작업  끝 */