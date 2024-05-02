/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0149.js
*@FileTitle : Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.09.11 송호진
* 1.0 Creation
* 2009.02.12 박상희 N200902050040 팝업(Inquiry by BKG) 스크롤바, Resize 활성화
* 2009.05.08 박상희 N200904170011 Report Item 추가(2) : 헤더명 변경 - Amount 
* 2009.09.15 송호진  ALPS F/W 적용
* 2009.10.27 송호진 ESM_MAS_0061 호출 Argument 수정
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
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
     * @class ESM_MAS_0149 : ESM_MAS_0149 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0149() {
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
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

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

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btn_close":
    					window.close();
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
    	* Sheet 기본 설정 및 초기화
    	* body 태그의 onLoad 이벤트핸들러 구현
    	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	*/
    	function loadPage() {
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
                setRetrieveAction();		
    	}
    	
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
            var formObj = document.form;		
    		switch(sheetNo) {
    		    case 1:	//sheet1 init
    				with (sheetObj) {
    					
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    					MergeSheet = msPrevColumnMerge;//msHeaderOnly; //msAll;
    					Editable = false;
    					InitRowInfo(2, 1, 15, 100);
    					InitColumnInfo(6, 0, 0, true);
    					InitHeadMode(false, false, false, true, false,false);

    					var HeadTitle = "Node Link|Activity Group|Cost Group/Cost Element|Feeder Term|Feeder Term|Amount" ;
    					var HeadTitle1 = "Node Link|Activity Group|Cost Group/Cost Element|Rev_Term|Del_Term|Amount" ;
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, false);

    					InitDataProperty(0, cnt++, dtData,		200,	daCenter,	true,	"nod_cd");
    					//InitDataProperty(0, cnt++, dtHidden,	30,		daCenter,	true,	"cost_act_grp_seq");
    					InitDataProperty(0, cnt++, dtData,		130,	daCenter,	true,	"grp");

    					InitDataProperty(0, cnt++, dtData,		220,	daLeft,		true,	"tree_col");
    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_rcv_term_cd");
    					InitDataProperty(0, cnt++ ,dtData,		70,		daCenter,	true,	"wtr_de_term_cd");
    					InitDataProperty(0, cnt++ ,dtAutoSum,	80,		daRight,	true,	"amt",		false,	"",		dfNullFloatOrg,	2);

    					RangeBackColor(1, 3, 1, 4) = RgbColor(222, 251, 248);

    					InitTreeInfo("tree_col", "", RgbColor(0,0,255), false);
    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(15) ;
    				}
    				break;			
    		}
    	}
    	
    	/*화면이 로드 되면서 바로 retrieve 되도록 */
    	function setRetrieveAction(){
    		sheetObject = sheetObjects[0];
    		formObject = document.form;

    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	
    	}    

        /**
    	* IBSheet Object를 배열로 등록
    	* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	* 배열은 소스 상단에 정의
    	*/
    	function setSheetObject(sheet_obj){
    		sheetObjects[sheetCnt++] = sheet_obj;
    	}
    	
    	// Inquiry by BKG 팝업열기
    	function openBKGinquiry(sheetObj,formObj,sAction) {	    
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		strUrl = "ESM_MAS_0061POP.do";
    		strUrl += "?f_s_bkg_no="+formObj.f_bkg_no.value;
    		strUrl += "&f_pro_vw="+formObj.f_pro_vw.value;
    		strUrl += "&f_pro_lvl="+formObj.f_pro_lvl.value;
    		strUrl += "&pgmNo=ESM_MAS_0061";
    		
    		ComOpenWindow2(strUrl,'Inquiry by BKG','width=1020,height=800,menubar=0,status=1,scrollbars=1,resizable=1');
    		
    	}
    	
    	/**
    	트리 접기
    	*/
    	function sheet1_OnSearchEnd(sheetObj, errMessge) {
    		//sheetObj.ShowSubSum( "grp", "cost", 0);
    		sheetObj.ShowTreeLevel(0, 1);
    	}
    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH:		//조회
    				if(!validateForm(sheetObj,formObj,sAction)) return false;
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCHLIST01;
        		    //20100414 이중환, FormQueryString -> masFormQueryString 변경
    				sheetObj.DoSearch4Post("ESM_MAS_0149GS.do", masFormQueryString(formObj));
    				ComOpenWait(false);
    				break;

    			case IBDOWNEXCEL:	//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;

    		}
    	}
    	    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    		}
    		return true;
    	}

	/* 개발자 작업  끝 */