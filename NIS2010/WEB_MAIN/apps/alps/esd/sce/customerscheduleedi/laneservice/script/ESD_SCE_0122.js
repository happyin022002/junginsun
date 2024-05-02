/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0122.js
*@FileTitle : Bottleneck Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.12.18 함대성
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
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0122 : ESD_SCE_0122 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SCE_0122() {
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
    var btnEnable = "X";	//버튼비활성
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
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

		initControl();
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
	   	var formObj = document.form; 
       
       axon_event.addListenerForm  ('keypress', 'fnObjKeyPress',  formObj );
       axon_event.addListenerFormat('change',	'obj_change',	formObj); //- 변경될때
    }

    /**
     * <pre>
     *    form Element의 KeyPress Event 발생시 처리.
     * </pre>
     * @return
     */ 
    function fnObjKeyPress(){
        var obj = event.srcElement;
        var formObj = document.form;
        var attr    = obj.getAttribute("dataformat");
        
        switch (attr){
	    	case  '':
	    		break;
            case  'ymd':
                  ComKeyOnlyNumber( obj );
                  break;
            case  'engup':
                  ComKeyOnlyAlphabet( 'upper' );
                  break;     
            case  'engupnum':
                  ComKeyOnlyAlphabet( 'uppernum' );
                  break;   
 
        }
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
    		
    		case "btn_retrieve":
    			if(btnEnable == "S"){
    				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
    			}
    			break;

    		case "btn_new":
    			if(btnEnable == "S"){
    				sheetObject1.RemoveAll();
    				formObject.cust_trd_prnr_id.value = "";
    				formObject.partnerName.value = "";
    			}
    			//formObject.cust_trd_prnr_id.focus();
    			break;

    		case "btn_save":
    			if(btnEnable == "S"){
    				doActionIBSheet(sheetObject1, formObject, IBSAVE);
    			}
    			break;

    		case "btn_downExcel":
    			if(btnEnable == "S"){
    				sheetObject1.SpeedDown2Excel();
    			}
    			break;
    			
			case "btn_RowAdd":
				if(btnEnable == "S"){
					doRowAdd(sheetObject1, formObject);
				}
				break;
			
			case "btn_RowDelete":
				if(btnEnable == "S"){
					ComRowHideDelete(sheetObject1,prefix+"del_chk");
				}
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo, rlaneSheetList) {
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
            InitColumnInfo(9, 0, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, false, true, false,false)

            var HeadTitle = "STS|Del.|SEQ|Lane|Lane Name|rout_rcv_dt|rout_seq|cust_trd_prnr_id|Update Date";

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성          [ROW, COL,    DATATYPE,    WIDTH,   DATAALIGN, COLMERGE,                SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++,  dtStatus,         30,    daCenter,   false,       prefix+"ibflag"       	 , false,      "",       dfNone    	  ,   	0,       false,      true);
            InitDataProperty(0, cnt++,  dtDelCheck,       30,    daCenter,   false,       prefix+"del_chk"           , false,      "",       dfNone    	  ,   	0,       true ,      true);
			InitDataProperty(0, cnt++,  dtDataSeq,        60,    daCenter,   false,       prefix+"Seq"               , false,      "",       dfNone    	  ,     0,       false,      false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	 200,	 daCenter,   false,		  prefix+"vsl_slan_cd"		 , false,	   "",		 dfEngUpKey	  ,		0,		 true,		 true, 3, 3);
			InitDataProperty(0, cnt++ , dtData,    	  	 520,    daLeft,     false,       prefix+"vsl_slan_nm"  	 , false,      "",       dfNone		  ,     0,       false,      false);
			InitDataProperty(0, cnt++ , dtHidden,    	 140,    daCenter,   false,       prefix+"rout_rcv_dt"       , false,      "",       dfNone,     0,       false,      true);
			InitDataProperty(0, cnt++ , dtHidden,    	 140,    daCenter,   false,       prefix+"rout_seq"          , false,      "",       dfNone		  , 	0,       false,      true);
			InitDataProperty(0, cnt++ , dtHidden,    	 140,    daCenter,   false,       prefix+"cust_trd_prnr_id"  , false,      "",       dfNone		  , 	0,       true,       true);
			InitDataProperty(0, cnt++ , dtData,    	 	  80,    daCenter,   false,       prefix+"upd_dt"          , false,      "",       dfNone		  , 	0,       false,      true);
			
    		} 
    		break;

    	}
    }
     
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	switch (sAction) { 
    	case IBSEARCH: //조회
    		if (validateForm(sheetObj, formObj, sAction)){
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("ESD_SCE_0122GS.do", SceFrmQryString(formObj) + "&" + ComGetPrefixParam(prefix));
    		}
    	break;

    	case IBSAVE: //저장 
    		if (validateForm(sheetObj, formObj, sAction)){ 
    	    	//var sName = sheetObj.ColSaveName(Col);
    			
    			var SaveStr = ComGetSaveString(sheetObj);
    			if (SaveStr == ""){
    				ComShowCodeMessage("SCE01222");
    				return;
    			}
    			formObj.f_cmd.value = MULTI;
    			var aryPrefix = new Array("sheet1_");	//prefix 문자열 배열	
    			var sXml = sheetObj.GetSaveXml("ESD_SCE_0122GS.do", SaveStr + "&" + SceFrmQryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
    			sheetObj.LoadSearchXml(sXml);
    			
    			//저장후 조회 
    	 		doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	 		//document.form.cust_trd_prnr_id.focus();
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
    		case IBSEARCH: //조회
				if (formObj.cust_trd_prnr_id.value.length < 1){
					ComShowMessage(ComGetMsg('SCE01221', "TP_ID"));
					return false;
				}
    		break;
    			
    		case IBSAVE:   //저장
    			//
    		break;
    		
    		case SEARCH01: 
    			//
    		break;
    	}
    	return true;
    }
 
   	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "cust_trd_prnr_id":
	    		    form.f_cmd.value = SEARCH01;
	    			sheetObjects[0].WaitImageVisible = false;
	    			 var formObj = document.form;
	    			
	    		    var sXml = sheetObj.GetSearchXml("ESD_SCE_0122GS.do" , SceFrmQryString(form));
	    		    
	    		    if(document.form.cust_trd_prnr_id.value == "" ){
	    		           //showErrMessage(getMsg("COM12114" ,"TP ID",'',''));
	    		           return false;
	    			}
	    		    
	    		    //텍스트 가져오기[partnerName]
	    		    var partnerName   = ComGetEtcData(sXml,"partnerName") == "" ? "" : ComGetEtcData(sXml,"partnerName");
	    		    var ediSvcTpNm 	  = ComGetEtcData(sXml,"ediSvcTpNm");
	    		    formObj.partnerName.value  = partnerName;
	    		    
	    		    if(ediSvcTpNm.substring(0,4) == "LANE"){	//CRUD버튼 활성
	    		    	//버튼 활성
	    		    	doActionBtnEnable('S');
	    		    }else{	//LANE타입이 아닌경우 partnerName조회할 수 있지만 CRUD 버튼 막는다
	    		    	//버튼 비활성
	    		    	doActionBtnEnable('X');
	    		    }
				   	break;
			}
	    } else {
			switch(obj.name) {
	    		case "cust_trd_prnr_id":
	        		formObj.vndr_nm.value = "";
				   	break;
			}
		}
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
      
      /**
      * 셀의 값이 바뀌었을 때 발생하는 Event
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet1_OnChange(sheetObj, row, col, value) { 
     	// Key Setting(필수)
     	//initKeySetting();
     	var rows = sheetObj.Rows;
     	
     	 switch (sheetObj.ColSaveName(col)) {
     	 //1 
			case prefix+"vsl_slan_cd":
		        // Duplication(중복) 체크
				var dup = 0;
				
				if(value == ""){
					return;
				}
				
		        for(var i=0; i<sheetObj.RowCount; i++) {
		            if(sheetObj.CellValue(i + 1, prefix+"vsl_slan_cd") == value) {
		            	dup++;
		            }
		            if(dup > 1){
		                ComShowMessage(value + " is already added");
		                sheetObj.CellValue(i + 1, prefix+"vsl_slan_cd") = "";
		                return;
		            }
		        }
     		break; 
     	 }
     }
  	
    /**
     * row add버튼이 클릭될경우 발생되는 이벤트 처리
     * @param sheetObj
     * @param formObj
     * @return
     */
	 function doRowAdd(sheetObj, formObj){
		    var iRow = sheetObj.DataInsert(-1);
		    sheetObj.CellValue2(iRow,  sheetObj.SaveNameCol(prefix+"rout_rcv_dt")) = formObj.yyyyMM.value;
		    sheetObj.CellValue2(iRow,  sheetObj.SaveNameCol(prefix+"cust_trd_prnr_id")) = formObj.cust_trd_prnr_id.value;
	 }
     
     /**
      * sheet1에서 이미지버튼을 클릭한 경우 를 처리한다.
      * @param sheetObj
      * @param Row
      * @param Col
      * @return
      */
     function sheet1_OnPopupClick(sheetObj, Row, Col){
		var formObj = document.form;
		var sUrl = "/hanjin/VOP_VSK_0202.do";
		ComOpenPopupWithTarget(sUrl, 428, 430, "sheet1_vsl_slan_cd:tmp_vsl_slan_cd|sheet1_vsl_slan_nm:tmp_vsl_slan_nm", "0,0", true);
		//ComOpenPopupWithTarget(sUrl, 428, 430, "sheet1_vsl_slan_cd:tmp_vsl_slan_cd", "0,0", true);
		if(formObj.tmp_vsl_slan_cd.value != ""){
			sheetObj.CellValue(Row, Col) = formObj.tmp_vsl_slan_cd.value;
			sheetObj.CellValue(Row, Col+1) = formObj.tmp_vsl_slan_nm.value;
			
			if(sheetObj.CellValue(Row, Col) == ""){
				sheetObj.CellValue(Row, Col+1) = "";
			}
		}
    }
      
      /**
       * Action 버튼의 활성/비활성을 설정한다. <br>
       * @param  invStatus String
       * @param  statusCd String
       * @return 없음
       * @author 김창식
       * @version 2009.10.12
       */	
      function doActionBtnEnable (invStatus){
      	// Invoice Confirm 버튼 활성/비활성
      	if(invStatus == 'S'){
      		//ComBtnEnable("btn_save");
      		//ComBtnEnable("btn_RowAdd");
      		//ComBtnEnable("btn_RowDelete");
      		//ComBtnEnable("btn_new");
      		//ComBtnEnable("btn_retrieve");
      		
      		//전역 변수
      		btnEnable = "S";
      	} else {
      		//ComBtnDisable("btn_save");
      		//ComBtnDisable("btn_RowAdd");
      		//ComBtnDisable("btn_RowDelete");
      		//ComBtnDisable("btn_new");
      		//ComBtnDisable("btn_retrieve");
      		
      		//전역 변수
      		btnEnable = "X";
      		
      		sheetObjects[0].RemoveAll();
			//document.form.cust_trd_prnr_id.focus();
      	}
      }
      
	/* 개발자 작업  끝 */