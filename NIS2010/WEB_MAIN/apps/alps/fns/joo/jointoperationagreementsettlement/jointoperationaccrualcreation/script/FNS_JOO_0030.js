/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_joo_0030.js
*@FileTitle : 공동운항추정 산출
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.04 함대성
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
     * @class ui_joo_0030 : ui_joo_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_joo_0030() {
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
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var prefix = "sheet1_";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    
  	function setDate(){
 		var today=new Date();
 		var y = today.getFullYear().toString();
 		document.form.estm_clz_yr.value = y;
 	}
    /*
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     */
    function initControl() {
    	//** Date 구분자 **/
    	DATE_SEPARATOR = "/";
    	var formObject = document.form; 

    	setDate();
    	
    	//Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListener  ('keypress', 'estm_clz_yr_keypress' , 'estm_clz_yr');
        axon_event.addListener  ('blur'  ,  'estm_clz_yr_onblur', 'estm_clz_yr');
     }

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];

    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch (srcName) { 
			 case "btns_back_yr":
                 if(document.form.estm_clz_yr.value == null || document.form.estm_clz_yr.value == ""){
                	 ComShowCodeMessage('JOO00116', 'Estimated Closing Year'); 
                	 return;
                 }
                 document.form.estm_clz_yr.value = parseInt(document.form.estm_clz_yr.value)-1;
                 
                 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                 break;
			
			 case "btns_next_yr":
                 if(document.form.estm_clz_yr.value == null || document.form.estm_clz_yr.value == ""){
                	 ComShowCodeMessage('JOO00116', 'Estimated Closing Year'); 
                	 return;
                 }
                 document.form.estm_clz_yr.value = parseInt(document.form.estm_clz_yr.value)+1;
                 
                 doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                 break;

    		case "btn_retrieve":
    			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			break;

    		case "btn_new":
    			sheetObject1.RemoveAll();
    			formObject.estm_clz_yr.focus();
    			break;

    		case "btn_save":
    			doActionIBSheet(sheetObject1, formObject, IBSAVE);
    			break;

    		case "btn_downExcel":
    			sheetObject1.SpeedDown2Excel();
    			break;
    		} // end switch
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowCodeMessage('JOO00001');
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
 		
 		document.form.estm_clz_yr.focus();
 		
 		initControl();
     }

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
    	var cnt = 0;

    	switch (sheetNo) {
    	case 1: 
    		with (sheetObj) {
            // 높이 설정
            style.height = 382;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msNone;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 3, 100);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(7, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "|Month|Closing|Closing Date|Closing User ID|Remark";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,0,    daCenter,  true,    prefix+"ibflag");
            InitDataProperty(0, cnt++ , dtData,    	   80,   daCenter,  true,    prefix+"estm_clz_mon",    false,    "",      dfNone, 0,    false );
            InitDataProperty(0, cnt++ , dtCheckBox,    80,   daCenter,  true,    prefix+"estm_clz_flg",    false,    "",      dfNone);
            InitDataProperty(0, cnt++ , dtData,    	   140,  daCenter,  true,    prefix+"estm_clz_dt",     false,    "",      dfUserFormat2, 0,    false       );

            InitDataProperty(0, cnt++ , dtData,    	   120,  daCenter,  true,    prefix+"upd_usr_id",      false,    "",      dfNone,        0,     false,      true,          7 );
            InitDataProperty(0, cnt++ , dtData,        160,  daLeft,    true,    prefix+"estm_rmk",        false,    "",      dfNone,		 99);
            
            InitDataProperty(0, cnt++, dtHidden      , 0,    daLeft  ,  true,    prefix+"estm_clz_yr"   ,  false,    "",      dfNone,        0,     false, false);

            InitUserFormat2(0, prefix+"estm_clz_dt", "####-##-## ##:##:##", "-|:" );

            
    		} 
    		break;

    	}
    }
     
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) { 
    	
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("FNS_JOO_0030GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
    		}
    		break;

    	case IBSAVE: //저장 
    		if (validateForm(sheetObj, formObj, sAction)){ 
    		    
    		    
    			var SaveStr = ComGetSaveString(sheetObjects);    			 
    			if (SaveStr == ""){
    				ComShowCodeMessage("JOO00036");
    				return;
    			}
                sheetObj.WaitImageVisible=false;
                ComOpenWait(true); 
    			formObj.f_cmd.value = MULTI;
    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
    			var sXml = sheetObj.GetSaveXml("FNS_JOO_0030GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    			sheetObj.LoadSearchXml(sXml);
                ComOpenWait(false);    			
    			//저장후 조회 
    	 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	 		document.form.estm_clz_yr.focus();
    		}
    		break;
  
    	}
    }
   
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj, formObj, sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch (sAction) {
    		case IBCREATE: //저장용 조회
    		case IBSEARCH: //조회
    			if (formObj.estm_clz_yr.value.length != 4 ){
    				return false;
    			}
				if (!checkNumber(formObj.estm_clz_yr.value)){
					return false;
				}
    		
    			break;
    			
    		case IBSAVE:   //저장
    			var cnt = 0;
    			for (var inx=1; inx <= sheetObj.LastRow; inx++){
    				if (sheetObj.CellValue(inx, prefix+"ibflag") == "R")
    					continue;
    				
    				cnt++; 
    			}
    			
    			if (cnt==0){
    				ComShowCodeMessage("JOO00036");
    				return false;
    			}
    			break;
    	}
    	return true;
    }
 
    
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /*
    * 숫자체크 
    */
      function checkNumber(sValue){
   	  try{
   		var value = sValue.search(/^\d*(\.?\d*)$/gi);
   	    if(value !=-1){
   	    	return true;
   	    }else{
   	        return false;
   	    }
   	  }catch(errorObject){
   	    showErrorDig("checkNumber()", errorObject);
   	  }
   	}
   
      function ComGetDateAdd2(sDate, sFlag, iVal, sDelim){
          try {
              if (sDelim==null || sDelim==undefined) sDelim = "-";

              if (sDate==null || sDate==undefined) {
                  sDate = new Date();
              } else {
                  //문자열 또는 HTML태그(Object)인 경우 처리
                  sDate = getArgValue(sDate); 
              }

              var yy = eval(sDate); 
              iVal = ComParseInt(iVal);	//인자가 문자열로 들어온 경우 에러 발생함

              switch(sFlag.toLowerCase()) {
                  case "y":   yy += eval(iVal);    break;
              }

              return yy ;
          } catch(err) { ComFuncErrMsg(err.message); }
      }
       
      function estm_clz_yr_keypress(){
      	ComKeyOnlyNumber(event.srcElement);
      }
      
      //estm_clz_yr 변경시 조회 
      function estm_clz_yr_onblur(){
      	
      	var formObject = document.form;

  		if (formObject.estm_clz_yr.value ==null || formObject.estm_clz_yr.value ==""){
  			
  			ComShowCodeMessage('JOO00116', 'Estimated Closing Year'); 
  			ComSetFocus(formObject.estm_clz_yr);
  			
  			return false;
  		} 
              
      }
      
      /**
      * 셀의 값이 바뀌었을 때 발생하는 Event
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet1_OnChange(sheetObj, row, col) { 
     	// Key Setting(필수)
     	//initKeySetting();
     	var rows = sheetObj.Rows;
     	
     	/*1. Attention을 클릭시 Attn:E-Mail 도 함께 클릭된다 (역으로도 가능하도록 처리)
         *2. Copy를 클릭시 CC:E-Mail도 함께 클릭되도록 한다(역으로도 가능)
         *3. Attention을 클릭시 클릭한 행 이외의 모든 행은 disabled처리한다
         *4. 클릭된 데이타를 찾아서 부모창에 전달할 데이타를 정의한다 
     	 */
     	 switch (sheetObj.ColSaveName(col)) {
     	 //1 
     		case prefix+"estm_clz_flg" :
     		//전체 row를 for문 돌려서 체크한 row의 월값보다 작은 월값에서 체크된것이 없다면 Msg와 함께 unCheck로 돌려놓는다 
     			if(row > 0) { 
        			for(var i=0; i < rows; i++ ){
        				if(i!=row){
    						if(i < row){
    							if(sheetObj.CellValue(i,prefix+"estm_clz_flg") == 0){
	     							sheetObj.CellValue(row,prefix+"estm_clz_flg") = 0;
	     							return;
    							}
    						}
    						if(i > row){
    							if(sheetObj.CellValue(i,prefix+"estm_clz_flg") == 1){
	     							sheetObj.CellValue(row,prefix+"estm_clz_flg") = 1;
	     							return;
    							}
    						}
        				}
        			} 
     			}
     		break; 
     	 }
     }
	/* 개발자 작업  끝 */