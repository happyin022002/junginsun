/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0016.js
*@FileTitle : No-Show Ratio Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.09.04 이현주
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
     * @class ESM_SPC_0016 : ESM_SPC_0016 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0016() {
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


    var	sheetObjects = new Array();
    var	sheetCnt = 0;

    //sheetResizeFull = true;
    /* 버튼클릭이벤트를	받아 처리하는	이벤트핸들러 정의 */
    document.onclick = processButtonClick;	

    	/* 버튼 네임으로 구분하여	프로세스를 분기처리하는 이벤트핸들러	*/
    	function processButtonClick() {
    		/*****	탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	
    		var sheetObject = sheetObjects[0];
    	
    		/*******************************************************/
    		var formObject	= document.form;
    	
    		try	{
    			var	srcName	= window.event.srcElement.getAttribute("name");
    	
    			switch(srcName)	{
    				case "btn_retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;
    			} // end switch
    		} catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("COM12111");
        		} else {
        			ComShowMessage(e);
        		}
    		}
    	}

    	/**
    	 * IBSheet Object를 배열로 등록
    	 * 향후 다른 항목들을 일괄처리할	필요가	있을 때 배열로 담는	프로세스를 추가할 수	있다
    	 * 배열은 소스 상단에 정의
    	 */
    	function setSheetObject(sheet_obj){
    	   sheetObjects[sheetCnt++] =	sheet_obj;
    	}



    	/**
    	 * Sheet 기본	설정 및 초기화
    	 * body	태그의	onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage()	{

    		for(i = 0; i < sheetObjects.length; i++){
    		//khlee-시작 환경 설정 함수	이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i], i+1);
    		//khlee-마지막	환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		var sheetResizeFull = true;
    		document_onresize();
    		
    		initSheetCombo();	//시트 콤보 초기 세팅
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	}

    	/* Sheet Combo Setting Start */
    	function initSheetCombo() {
    		initSheetCombo_trade();
    		initSheetCombo_subtrade();
    		initSheetCombo_lane();
    		initSheetCombo_bound();
			initSheetCombo_ddct("aloc_ddct_bse_cd");
			initSheetCombo_ddct("aloc_ddct_cs_cd");
			initSheetCombo_ddct("aloc_ddct_tgt_cd");
			initSheetCombo_ddct("aloc_ddct_mod_cd");
    	}     
    	

       	
        var tradeData0;
        var tradeData1;
        
    	function initSheetCombo_trade() {
    		var sheetObject  = sheetObjects[0];
            var rtn = getCodeXmlList("TradeCombo", "isRepTrade=false&del=");
            
            var arrData = ComXml2ComboString(rtn, "trd_cd", "trd_nm");
            
            if (arrData != null){
                var arrCode = arrData[0].split("|");
                var arrName = arrData[1].split("|");
                var conData = "";
                for(i=0; i < arrName.length;i++){
                    if(i==0){
                        arrName[i] = arrCode[i]+"\t"+arrName[i];
                    }else{
                        arrName[i] = "|"+arrCode[i]+"\t"+arrName[i];
                    }
                    conData = conData.concat(arrName[i]);
                }
                arrData[1] = conData;
            }
            arrData[0] = " |" + arrData[0];
            arrData[1] = " |" + arrData[1];
            tradeData0 =arrData[0];
            tradeData1 =arrData[1];
            sheetObject.InitDataCombo(0, "trd_cd", arrData[1], arrData[0]);
    	}
    	
        var subTradeData0;
        var subTradeData1;
    	function initSheetCombo_subtrade() {
    		var sheetObject  = sheetObjects[0];
            
            var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true");
            
            var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
            
            arrData[0] = " |" + arrData[0];
            arrData[1] = "\t\t|" + arrData[1];
            subTradeData0 =arrData[0];
            subTradeData1 =arrData[1];
            sheetObject.InitDataCombo(0, "sub_trd_cd", arrData[1], arrData[0], "", "", 1);
    	}
        var rlaneCdData0;
        var rlaneCdData1;
    	function initSheetCombo_lane() {
    		var sheetObject  = sheetObjects[0];
            
            var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
            
            var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
            arrData[0] = "00000|" + arrData[0];
            arrData[1] = "\t\tALL\t|" + arrData[1];
            rlaneCdData0 =arrData[0];
            rlaneCdData1 =arrData[1];
            sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
    	}
        var boundData0;
        var boundData1;   	
    	function initSheetCombo_bound() {
    		var sheetObject  = sheetObjects[0];
            
            var bound = " |E|W|S|N";
            boundData0 =bound;
            boundData1 =bound;
            sheetObject.InitDataCombo(0, "dir_cd", bound, bound);
    	}
    	
       	function initSheetCombo_ddct(strAlocDdct) {
    		var sheetObject  = sheetObjects[0];
    		var code = "";
    		if ( strAlocDdct == 'aloc_ddct_bse_cd' ) {
    			code = "CD00886";
    		} else if ( strAlocDdct == 'aloc_ddct_cs_cd' ) {
    			code = "CD00226";
    		} else if ( strAlocDdct == 'aloc_ddct_tgt_cd' ) {
    			code = "CD00225";
    		} else if ( strAlocDdct == 'aloc_ddct_mod_cd' ) {
    			code = "CD00224";
    		}
            var rtn = getCodeXmlList("CommonCode", "codeNo="+code+"&del=");
            
            var arrData = ComXml2ComboString(rtn, "code", "text");
            
            if (arrData != null){
                arrData[0] = " |" + arrData[0];
                arrData[1] = " |" + arrData[1];
            }
            
            sheetObject.InitDataCombo(0, strAlocDdct, arrData[1], arrData[0], "", "", "0");
    	}

       	function getSheetCombo_trade(){
    		var data = new Array();
    		data[0] = tradeData0;
    		data[1] = tradeData1;
    		return data
    	}
    	function getSheetCombo_sub_trade(){
    		var data = new Array();
    		data[0] = subTradeData0;
    		data[1] = subTradeData1;
    		return data
    	}
    	function getSheetCombo_bound(){
    		var data = new Array();
    		data[0] = boundData0;
    		data[1] = boundData1;
    		return data
    	}
    	function getSheetCombo_lane(){
    		var data = new Array();
    		data[0] = rlaneCdData0;
    		data[1] = rlaneCdData1;
    		return data
    	}
    	function getSheetCombo_ddct_cs(){
    		var data = new Array();
    		data[0] = data0;
    		data[1] = data1;
    		return data
    	}
    	function getSheetCombo_ddct_tgt(){
    		var data = new Array();
    		data[0] = data0;
    		data[1] = data1;
    		return data
    	}
    	function getSheetCombo_ddct_mod(){
    		var data = new Array();
    		data[0] = data0;
    		data[1] = data1;
    		return data
    	}
    	function getSheetCombo_ddct_type(){
    		var data = new Array();
    		data[0] = data0;
    		data[1] = data1;
    		return data
    	}
    	
    	/**
    	 * 시트 초기설정값, 헤더	정의
    	 * param : sheetObj	==>	시트오브젝트,	sheetNo	==>	시트오브젝트 태그의 아이디에	붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여	시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		var	cnt	= 0;

    		switch(sheetNo)	{
    			case 1:		 //sheet1 init
    				with (sheetObj)	{
    					// 높이 설정
    					style.height = GetSheetHeight(24);

    					//전체 너비	설정
    					SheetWidth = mainTable.clientWidth;

    					//Host정보 설정[필수][HostIp,	Port, PagePath]
    					if (location.hostname != "") {
    					    InitHostInfo(location.hostname, location.port,	page_path);
    					}
    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    					//전체Edit 허용	여부 [선택,	Default	false]
    					Editable = false;
                        FocusEditMode = default_edit_mode;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(1,	1, 9, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(10, 0, 0, true);

    					// 해더에서	처리할	수 있는 각종	기능을	설정한다
    					InitHeadMode(true, true, false,	true, false, false);

    					var	HeadTitle =	"SEQ|Trade|Sub Trade|Bound|Lane|Deduct Type|Deduct Case|Deduct Office|Deduct Amount|Deduct Ratio";

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성	   [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  					KEYFIELD,	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN, FULLINPUT,	SORTENABLE,	TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++, dtDataSeq,		30,	daCenter,  false,		"");
    					InitDataProperty(0,	cnt++, dtComboEdit,		60,	daCenter,  false,		"trd_cd",		   		 true,		   "",		dfNone,			0,		false,	   		false,		3,     true,       false);
    					InitDataProperty(0,	cnt++, dtComboEdit,		80,	daCenter,  false,		"sub_trd_cd",		     true,		   "",		dfNone,			0,		false,	   		false,		2,     true,       false);
    					InitDataProperty(0,	cnt++, dtComboEdit,		60,	daCenter,  false,		"dir_cd",		         true,		   "",		dfNone,			0,		false,	   		false,		1,     true,       false);
    					InitDataProperty(0,	cnt++, dtCombo,			80,	daCenter,  false,		"rlane_cd",		         true,		   "",		dfNone,			0,		false,	   		false,		5,     true,       false);
    					InitDataProperty(0,	cnt++, dtCombo,		   120,	daLeft,    false,		"aloc_ddct_bse_cd",	 	 true,		   "",		dfNone,	        0,	   	false,	   		false,      1,     true,       false);
    					InitDataProperty(0,	cnt++, dtCombo,			280,daLeft,    false,		"aloc_ddct_cs_cd",	  	 true,		  "",		dfNone,			0,		false,	   		false,      1,     true,       false);
    					InitDataProperty(0,	cnt++, dtCombo,			260,daLeft,    false,		"aloc_ddct_tgt_cd",	 	 true,		  "",		dfNone,			0,		false,	   		false,      1,     true,       false);
    					InitDataProperty(0,	cnt++, dtHidden,		70,	daCenter,  false,		"aloc_ddct_mod_cd",	     true,		  "",		dfNone,			0,	    false,	   		false,      1,     true,       false);
    					InitDataProperty(0,	cnt++, dtData ,			60,	daRight,   true,	 	"aloc_ddct_mod_val",	 true,		  "",		dfInteger,   	0,	   	false,	   		false,      8,     false,      false);
    								
    					//콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
//    					initSheetCombo_trade(sheetObj, 0, 1);
//    			     	initSheetCombo_sub_trade(sheetObj, 0, 2);
//    					initSheetCombo_bound(sheetObj, 0, 3);
//    					initSheetCombo_lane(sheetObj, 0, 4);			
    								
    					//common combo 
//    					initSheetCombo_ddct_type(sheetObj, 0, "aloc_ddct_bse_cd");
//    					initSheetCombo_ddct_cs(sheetObj, 0, "aloc_ddct_cs_cd");
//    					initSheetCombo_ddct_tgt(sheetObj, 0, "aloc_ddct_tgt_cd");
//    					initSheetCombo_ddct_mod(sheetObj, 0, "aloc_ddct_mod_cd");
    				}
    				break;
    		}
    	}


    	// Sheet관련 프로세스	처리
    	function doActionIBSheet(sheetObj, formObj, sAction) {
    		sheetObj.ShowDebugMsg =	false;

    		switch(sAction)	{

    			case IBSEARCH:		//조회
    			if(checkModifiedSheet(sheetObj)) {
    			//두개 이상의 Sheet를 동시에 체크해야 하여 하나라도 수정된 Sheet가 존재하는 경우를 체크하고자 하는경우 사용
    	        	if(ComShowConfirm (getMsg("SPC90001")) != 1) {
    	            	return;
    	         	}
    	      	}
    			formObj.f_cmd.value = SEARCHLIST;
    			
    			var param = "f_cmd=" + formObj.f_cmd.value;
    			
    			//sheetObj.DoSearch4Post("ESM_SPC_0016GS.do", FormQueryString(formObj));
    			sheetObj.DoSearch4Post("ESM_SPC_0016GS.do", param);
    			break;	
    		case IBDOWNEXCEL:		 //엑셀 다운로드
    			sheetObj.Down2Excel();					
    		}			
    	}


    	/**
    	 * 화면 폼입력값에	대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction) {
    		with(formObj){
    	//			if (!isNumber(iPage)) {
    	//
    	//				return false;
    	//			}
    		}
    	
    		return true;
    	}


	/* 개발자 작업  끝 */