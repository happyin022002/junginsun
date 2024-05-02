/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0019.js
*@FileTitle : Maximum L/F Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.27 이현주
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
     * @class ESM_SPC_0019 : ESM_SPC_0019 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0019() {
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

    //sheetResizeFull = true;
    var REPEAT_DATA_CNT = 0;                    
    //반복이 시작 되는 Col 위치(index 0부터 시작 )
    var REPEAT_START_COL = 0;
    //저장된 row의 index(;로 구분된 index)
    var saveRepeatDataRows ;        
                        
                        
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    
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

            	    case "btn_save":
        	           doActionIBSheet(sheetObject,formObject,IBSAVE);
            	        break;

            	    case "btn_new":
        	            sheetObject.RemoveAll();
        	            formObject.reset();
        	            
        	            formObject.year.value = init_year;
        	            
						SpcSearchOptionTrade("rep_trade");
						SpcSearchOptionSubTrade("sub_trade", true, true);
						SpcSearchOptionLane("lane");; // 0207 SHKIM  
            	        break;

            	    case "btng_rowadd":
        	            doActionIBSheet(sheetObject,formObject,IBINSERT);
            	        break;

            	    case "btng_save":
        	            doActionIBSheet(sheetObject,formObject,IBSAVE);
            	        break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage ("COM12111");
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
                        Editable = true;
                        FocusEditMode = default_edit_mode;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 9, 100);

                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(11, 0 , 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(false, false, false, false, false,false) ;


                        var HeadTitle0 = "STS|SEQ|Trade|Sub Trade|Lane|Bound|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)|Maximum L/F(%)";
                        var HeadTitle1 = "STS|SEQ|Trade|Sub Trade|Lane|Bound|W5|W4|W3|W2|W1";

                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle0, true);
                        InitHeadRow(1, HeadTitle1, false);

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                        InitDataProperty(0, cnt++ , dtStatus,   30,    daCenter,   true,    "FLG");
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

//                        //data의 반복 횟수
//                        REPEAT_DATA_CNT = 5;
//                        //반복이 시작 되는 Col 위치(index 0부터 시작 )
//                        REPEAT_START_COL = 6;
//                        for(var i = 0 ; i < REPEAT_DATA_CNT ; i++){
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,   true,    "hidden_max_ldf_rto",     false);
//                        }
//                        for(var i = 0 ; i < REPEAT_DATA_CNT ; i++){
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "ibflag",       false);  
//                        }                                                 
//                         
//                        for(var i = 0 ; i < REPEAT_DATA_CNT ; i++){
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "bse_yr",        false);
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "voy_diff_wk",   false);
//                        }
//                                     
//                        for(var i = 0 ; i < REPEAT_DATA_CNT-1 ; i++){
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "trd_cd",       false);
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "sub_trd_cd",   false);
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "rlane_cd",     false);
//                           InitDataProperty(0, cnt++ , dtHidden,      0,    daCenter,  true,    "dir_cd",       false);
//                        }  

                        CellBackColor(1,6) = RgbColor(222, 251, 248);
                        for(var i = 6 ; i <12 ; i ++)
                        {
                            CellBackColor(1,i) = CellBackColor(1,6);
                        }
                        
                        for(var j = 0 ; j < REPEAT_DATA_CNT ; j++){
                            MaximumValue(0,6+j) = 100;
                            MinimumValue(0,6+j) = 0.1;                           
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

                   if(validateForm(sheetObj,formObj,sAction));
                     
                   if(checkModifiedSheet(sheetObj)){
                      if(ComShowConfirm (getMsg("SPC90001")) != 1){
                          return;
                      }
                   }                   
                   formObj.f_cmd.value = SEARCHLIST;
                   
                   var param = "year=" + formObj.year.value;
                   param = param + "&rep_trade=" + comObjects[0].Code;
                   param = param + "&sub_trade=" + comObjects[1].Code;
                   param = param + "&lane="      + comObjects[2].Code;
                   param = param + "&bound="     + formObj.bound.value;
                   
                   sheetObj.ReDraw=false;
                   //sheetObj.DoSearch("ESM_SPC_0019GS.do",FormQueryString(formObj));
                   //sheetObj.DoSearch4Post("ESM_SPC_0019GS.do", "f_cmd="+(SEARCHLIST) + "&" + FormQueryString(formObj));
                   sheetObj.DoSearch4Post("ESM_SPC_0019GS.do", "f_cmd="+(SEARCHLIST) + "&" + param);
                    
                   sheetObj.ReDraw=true;                
                   //sheetObj.DoSearch4Post("com.hanjin.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", FormQueryString(formObj));
                   break;

                case IBSAVE:        //저장
                   var tran_rows = sheetObj.FindStatusRow("U");
                   if(!validateLimit(sheetObj,tran_rows)) return false;
                   
                   formObj.f_cmd.value = MULTI;
                   //저장하기전 저장하는 row의 index를 저장 해 놓는다.
                   saveRepeatDataRows = tran_rows;
                   
                   var param = "year=" + formObj.year.value;
                   
                   //sheetObj.DoSave("ESM_SPC_0019GS.do",  FormQueryString(formObj));
                   //doSaveSheet(sheetObj, "ESM_SPC_0019GS.do","f_cmd="+(MULTI) + "&" + FormQueryString(formObj));
                   doSaveSheet(sheetObj, "ESM_SPC_0019GS.do","f_cmd="+(MULTI) + "&" + param);
     	           
                   break;
              case IBCLEAR:        //초기화
    	           if(checkModifiedSheet(sheetObject)){
    			        if(ComShowConfirm (getMsg("SPC90001")) != 1){
    			            return;
    			        }
    			   }
    	           //공통함수사용: 화면을 초기화
    			   resetAll(); 
                   break;               
              case IBDOWNEXCEL:        //엑셀 다운로드
                   sheetObj.Down2Excel(-1, false, false, true);
                   break;

            }
        }


       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
            with(formObj){
//                if (!isNumber(iPage)) {
//
//                    return false;
//                }
            }

            return true;
        }
       
        function validateLimit(sheetObj,trans_rows){
            var arrRow = trans_rows.split(";");
            for (var idx=0; idx<arrRow.length-1; idx++){
                for(var lCnt = 0 ; lCnt < REPEAT_DATA_CNT ; lCnt++  ){
                   var oridata_col =REPEAT_START_COL+lCnt ;
                   var oridata = sheetObj.CellValue(arrRow[idx], oridata_col);
                   if(oridata<0 || oridata > 100){
                      sheetObj.SelectCell( arrRow[idx] ,oridata_col,true);
                      ComShowMessage(getMsg("SPC90118"));
                      return false;   
                   } 
                }
            }     
            return true;
        }    
        
        function sheet_OnChange(sheetObj, row, col, val){
//            cellChange(sheetObj, row, col, val);
//            complateRepeatSave(sheetObj);
        }
        
        function cellChange(sheetObj, row, col, val){
            var flg ;
            var flg_col_ =col+(REPEAT_DATA_CNT*2) ;
            if(sheetObj.CellValue(row, flg_col_) == "I"){
                return;
            }else{
                flg = (val==sheetObj.CellValue(row, col+REPEAT_DATA_CNT))?"R":"U";
            }
            var pstat = sheetObj.CellValue(row, flg_col_);
            sheetObj.CellValue2(row, flg_col_) = flg;
        }
        
        function complateRepeatSave(sheetObj){
            // ComShowMessage(saveRepeatDataRows); 
            var arrRow = saveRepeatDataRows.split(";");
            for (var idx=0; idx<arrRow.length-1; idx++){
                //ComShowMessage(arrRow[idx]);
                for(var lCnt = 0 ; lCnt < REPEAT_DATA_CNT ; lCnt++  ){
                    var flg_col =REPEAT_START_COL+(REPEAT_DATA_CNT*2)+lCnt ;
                    var flg = sheetObj.CellValue(arrRow[idx], flg_col);
                    //ComShowMessage(flg);                   
                    if( flg != "R"){
                        var hidden_col =REPEAT_START_COL+REPEAT_DATA_CNT+lCnt ;
                        var oridata_col =REPEAT_START_COL+lCnt ;
                        var oridata = sheetObj.CellValue(arrRow[idx], oridata_col);       
                        //ComShowMessage("oridata"+oridata);  
                        sheetObj.CellValue2(arrRow[idx], flg_col) = "R";
                        sheetObj.CellValue2(arrRow[idx], hidden_col ) = oridata;
                   }
                }
                sheetObj.RowStatus(arrRow[idx]) = "R";
            }
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
          }else{
        	  ComShowMessage("saved successfully.");
              complateRepeatSave(sheetObj);
          }
          //ComShowMessage(saveRepeatDataRows)
          saveRepeatDataRows = "";
      	   
      	}
	/* 개발자 작업  끝 */