/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0106.js
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*2008-03-04 김원섭
*   - Summarize 기능 개선
* 2008-09-10 임옥영 CSR:N200809090009
* 각 지역그룹팀에 대한 권한부여 
* 2008-10-10 임옥영 CSR:N200810070001
*   -SINRS에 SELCDO와 동일한 권한 부여
* 2009-03-27 최윤성 CSR:R200903190002
* - SPC_SREP_CUST_MAPG 테이블의 SREP_USR_ID -> SREP_CD 컬럼명 수정
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.11.22 최윤성 [CHM-201221575-01] [SPC] 한국지점 Forecast Input 화면 Header 부분 로직 보완 - alert 메시지 내용 수정
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
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
     * @class ESM_SPC_0106 : ESM_SPC_0103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0106() {
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
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var searchParams = "";
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

    	    case "btn_retrieve":
            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
	            
    	    case "btn_save":
    	    	doActionIBSheet(sheetObject,formObject, IBSAVE);
    	        break;
    	        
    	    case "btn_close":
    	    	window.returnValue = "CLOSE";
    	    	self.close();
    	        break;

		} // end switch
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        tab_retrives = new Array(sheetObjects.length);
        var tdisp = "block";
        
        for(i=0;i<sheetObjects.length;i++){

	        //khlee-시작 환경 설정 함수 이름 변경
	        ComConfigSheet(sheetObjects[i]);
	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
	        ComEndConfigSheet(sheetObjects[i]);
        }
   
        var sheetResizeFull = true;
		document_onresize();
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
	    

		//  화면 로드시 자동조회하되록함.
		//-----------------------------------------------------
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//-----------------------------------------------------
	    
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
	    			//style.height = 100 ;
	    			style.height = getSheetHeight(10) ;
	    			//전체 너비 설정
	    			SheetWidth = mainTable.clientWidth;
	    			
	    			//Host정보 설정[필수][HostIp, Port, PagePath]
	    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    			
	    			//전체Merge 종류 [선택, Default msNone]
	    			MergeSheet = msHeaderOnly;
	    			
	    			Editable = true;
	    			
	    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    			InitRowInfo( 2, 1, 9, 100);
	    			
	    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    			InitColumnInfo(10, 0, 0, false);
	    			
	    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    			InitHeadMode(false, true, true, true, false,false) ;
	    			
	    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    			InitHeadRow(0, "|Account|Account|Account|S.Rep|S.Rep Code|S.Rep Name|Week||", true);
	    			InitHeadRow(1, "|Code|Name|Type|S.Rep|S.Rep Code|S.Rep Name|Week||", true);
	    			
	    			var cnt = 0;
	    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    			InitDataProperty(0, cnt++ , dtHiddenStatus	,    50,    daCenter,   true,    "ibflag",     		false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtData 			,    80,    daCenter,   true,    "cust_cd",     	false,         	"",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtData 			,    230,   daLeft,   	true,    "cust_nm",     	false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtCombo			,    50,    daCenter,   true,    "cust_tp_cd",      false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtCombo 		,    90,    daCenter,   true,    "srep_cd",    		false,          "",       dfNone,       0,     true,       true);
	    			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "srep_usr_id",    	false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "srep_nm",    		false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtData          ,    70,    daCenter,   true,    "cost_wk",      	false,          "",       dfUserFormat, 0,     true,       true);
	    			InitDataProperty(0, cnt++ , dtHidden 		,    70,    daCenter,   true,    "cust_cnt_cd",		false,          "",       dfNone,       0,     false,      false);
	    			InitDataProperty(0, cnt++ , dtHidden        ,    70,    daCenter,   true,    "cust_seq",      	false,          "",       dfUserFormat, 0,     true,       true);
	
	    			HeadRowHeight  = 10;
	    			
	    			InitDataCombo (0, "cust_tp_cd", "BCO|NVO", "B|N");
	    			InitUserFormat(0, "cost_wk", "####-##", "-" );
	
	    		}
                break;
        }
    }
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
			
           case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.ReDraw=false;
				sheetObj.RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,salesRep");
				var rtn = sheetObj.DoSearch4Post("ESM_SPC_0110GS.do", param);
				sheetObj.ReDraw=true;
				break;


            case IBSAVE:  
				formObj.f_cmd.value = MULTI01;
				
				var param = SpcFormString(formObj,"f_cmd,salesRep,trd_cd,sub_trd_cd,rlane_cd,dir_cd,ioc_ts_cd,ofc_cd,sub_ofc_cd");
                var rtn = doSaveSheet(sheetObj, "ESM_SPC_0110GS.do",param,null);
                break;
        }
    }
    
    function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "engup":
	            if(obj.name=="srep_cd") ComKeyOnlyAlphabet('uppernum')
	            else ComKeyOnlyAlphabet('upper');
	            break;
	    }
	}
    
    function sheet1_OnSearchEnd(sheetObj, errMsg){
    	var srep_cd = "";
    	var srep_nm = "";
    	
    	for(i = sheetObj.HeaderRows; i < sheetObj.RowCount + sheetObj.HeaderRows; i++){
    		srep_cd = sheetObj.CellValue(i, "srep_usr_id");
    		srep_nm = sheetObj.CellValue(i, "srep_nm");
    		sheetObj.CellComboItem(i, "srep_cd", srep_nm, srep_cd);
    		
    		sheetObj.CellValue2(i, "cust_cnt_cd") = (sheetObj.CellValue(i, "cust_cd")).substr(0, 2);
    		sheetObj.CellValue2(i, "cust_seq") = (sheetObj.CellValue(i, "cust_cd")).substr(2);
    		
    		//sheetObj.CellValue(i, "ibflag") = "R";
    	}

    }
    
    function sheet1_OnSaveEnd(sheetObj, errMsg){
    	if (sheetObj.EtcData("status") == "OK") {
    		ComShowMessage("saved successfully.");
    		
    		window.returnValue = "OK";
    		self.close();
    	} else if (sheetObj.EtcData("status") != "OK") {
    		ComShowMessage(errMsg);
    	}
    }
	
	/* 개발자 작업  끝 */
