/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0100.js
*@FileTitle : ESM_SPC_0100
*Open Issues :
*Change history :
*2008-02-20 - 서관영
* [csr]N200801154873 : Split 02-주간 대상항차 기준 변경 관련 요청
* - coa_mon_vvd table의 sls_yrmon 컬럼을 sls_yrmon으로 변경
* 2008-04-22 서관영  
* Office title => RGN OFC로 변경
* vvd항목 9자리 체크 영문과 숫자만 edit가능하게 수정
* 2008-04-30 서관영
* CSR : N200804280004 -   - 대상 항차가 등록되어 있지 않으면 Background : Yellow , Text : Blue Color로 표시
* - 저장시 OFC 가 RGN Office 가 아니거나 , Lane 과 Port 가  Mismatch 이면 Error 처리
* 2011.03.14 이석준[CHM-201109280-01] sheet1,2에 POL1~10 field에 숫자+영대문자 입력 가능토록 수정 
*@LastModifyDate : 2009.07.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.22 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
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
     * @class ESM_SPC_0100 : ESM_SPC_0100 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0100() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = '';
    var init_week = '';

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
       			case "btn_retrieve":
					for(var i = 0 ; i < tab_retrives.length ; i++){
					    tab_retrives[i] = false;
					}
					doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
					break;
        	            
				case "btn_new":
					if(checkModifiedSheet(sheetObject)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
					resetAll(); 
					for(var i = 0 ; i < tab_retrives.length ; i++){
				        tab_retrives[i] = false;
				    }
				    check_retrive = false;
					formObject.year.value = init_year;
					formObject.week.value = init_week;
					SpcSearchOptionWeek("week",false,document.form.year.value);
					
					SpcSearchOptionTrade("trade", true, true, '', true);
					SpcSearchOptionSubTrade("subtrade", true, true);
					SpcSearchOptionLane("lane", true, false); // 0207 SHKIM    	
					break;
					
			   case "btn_save":
			        doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
	            	break;
	            	
	   	       case "btn_rowadd":
	   	    	    for(var i = 0 ; i < tab_retrives.length ; i++){
				        tab_retrives[i] = false;
				    }
	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBINSERT);
	   	        	break; 			
        	    
	   	       case "btn_downexcel":
   	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBDOWNEXCEL);
   	            	break;
        	   
	   	       case "btn_popup_pol_cd":
        	        var pol_cd = formObject.pol.value;
        	        spcPopup("POL", "tt_pol_cd="+pol_cd, 770, 470, "getPOL", "1,0,1,1,1,1,1,1");
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
        
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
    }
        
    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
        
    /**
     * tab1_OnChange 
     * 
     */
    function tab1_OnChange(tabObj , nItem)
    {
	    var formObj = document.form;
	   
        var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 여기가 중요--------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
		if(!check_retrive) return;
        if(beforetab==0){
        	searchByWeek(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
        }else if(beforetab==1){
        	searchByVvd(sheetObjects[beforetab], formObj, (SEARCHLIST01 + beforetab));
        }
   
    }
        
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	SpcSearchOptionYear("year");
    	SpcSearchOptionWeek("week",false);
    	SpcSearchOptionRhq("rhq",'','','',true);
    	SpcSearchOptionTrade("trade", true, true, '', true);
    	SpcSearchOptionSubTrade("subtrade", true, true);
    	SpcSearchOptionLane("lane", true, false);
    	SpcSearchOptionBound("bound",false,true,false,true);
    	SpcSearchOptionOcnipc("ocnipc",true);
    	
        tab_retrives = new Array(sheetObjects.length);
        for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        var formObject = document.form;
    	formObject.year.focus();
    	
    	initSheetCombo();
    	init_year = formObject.year.value; // 년 초기화용
    	init_week = formObject.week.value; // 주차 초기화용
    	
//    	
//    	formObject.rhq.Code = "SHARC";
//    	formObject.trade.Code = "TPS";
//    	formObject.lane.Code = "CAXTP";
//    	formObject.ocnipc.value = "OCN";
    }
        
	function initSheetCombo() {
		initSheetCombo_trade();
		initSheetCombo_subtrade();
		initSheetCombo_lane();
		initSheetCombo_bound();
		initSheetCombo_ocnipc();
		initSheetCombo_year();
		initSheetCombo_week();
	}
    	
	function initSheetCombo_trade() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
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
        
        sheetObject.InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
        sheetObject1.InitDataCombo(0, "rep_trd_cd", arrData[1], arrData[0]);
	}
    	
	function initSheetCombo_subtrade() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        var rtn = getCodeXmlList("SubTradeCombo", "isRepTrade=false&del=&isAll=true");
        
        var arrData = SpcXml2ComboItem(rtn, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t|" + arrData[1];
        
        sheetObject.InitDataCombo(0, "rep_sub_trd_cd", arrData[1], arrData[0], "", "", 1);
        sheetObject1.InitDataCombo(0, "rep_sub_trd_cd", arrData[1], arrData[0], "", "", 1);
	}
    	
	function initSheetCombo_lane() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        var rtn = getCodeXmlList("RLaneCombo", "del=&ipc=");
        
        var arrData = SpcXml2ComboItem(rtn, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
        
        arrData[0] = " |" + arrData[0];
        arrData[1] = "\t\t\t|" + arrData[1];
        
        sheetObject.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
        sheetObject1.InitDataCombo(0, "rlane_cd", arrData[1], arrData[0], '', '', 2);
	}
    	
	function initSheetCombo_bound() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        var bound = " |E|W|S|N";
        
        sheetObject.InitDataCombo(0, "dir_cd", bound, bound);
        sheetObject1.InitDataCombo(0, "dir_cd", bound, bound);
	}
    	
	function initSheetCombo_ocnipc() {
		var sheetObject  = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        
        var ocnipc = " |OCN|IPC|T/S";
        
        sheetObject.InitDataCombo(0, "ioc_ts_cd", ocnipc, ocnipc);
        sheetObject1.InitDataCombo(0, "ioc_ts_cd", ocnipc, ocnipc);
	}
    	
	function initSheetCombo_year() {
		var sheetObject  = sheetObjects[0];
        
		var today = new	Date();
		var year  = today.getFullYear();
		
		var pre  = 1;
		var post = 5;
		
		var code = " ";
		
		for (var i = year + pre; i > year - pre - post; i--) {
			code = code + "|" + i;
		}
        
        sheetObject.InitDataCombo(0, "bse_yr", code, code);
	}
    	
	function initSheetCombo_week() {
		var sheetObject  = sheetObjects[0];
        
		var today = new	Date();
		var year  = today.getFullYear();
		
		var pre  = 1;
		var post = 5;
		
		var code = " ";
		
		for (var i = 0; 54 > i ; i++) {
			code = code + "|" + (i < 10 ? "0" : "") + i;
		}
        
        sheetObject.InitDataCombo(0, "bse_wk", code, code);
	}
	
    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "By Week" , -1 );
                    InsertTab( cnt++ , "By VVD" , -1 );

                }
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

            case 1:      
				initSheet1(sheetObj);//sheet1 init
                break;
            case 2:      
				initSheet2(sheetObj);//sheet2 init
                break;

        }
    }
        
    /**
     * TabSheet1에서 조회후 타이틀 변경
     */
	function initSheet1(sheetObj){       	 
    	 with (sheetObj) {
	            // 높이 설정
	            //style.height = 300 ;
	    	    style.height = getSheetHeight(19) ;
	            
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
				CountPosition = 0;

	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
 
    	        //전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				FocusEditMode = default_edit_mode;

	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo( 2, 1, 10, 3000);
			
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(22, 0 , 0, true);
	
	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false,false) ;
	
	            //var txtHead1 = "F'Cast|Diff/Shortfall|Ratio";
	            var HeadTitle1 = "DEL.|STS|SEQ|REP Trade|Sub-Trade|Lane|BD|O/I/T|Start|Start|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
	            var HeadTitle2 = "DEL.|STS|SEQ|REP Trade|Sub-Trade|Lane|BD|O/I/T|Year|WK|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";

	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
                InitHeadRow(1, HeadTitle2, true);
                var cnt = 0;
				
	            //데이터속성    [ROW,   COL,    DATATYPE,     WIDTH,    DATAALIGN,  COLMERGE, SAVENAME,     KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,      UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,	"",       dfNone,   	0,     true,       true);
	            InitDataProperty(0, cnt++ , dtStatus,     	30,    daCenter,   true,    "ibflag",   	false,	"",       dfNone,   	0,     false,      true);
	            InitDataProperty(0, cnt++ , dtDataSeq,    	30,    daCenter,   true,    "tmp_seq",    	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   80,    daCenter,   true,    "rep_trd_cd", 	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   80,    daCenter,   true,    "rep_sub_trd_cd",false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   50,    daCenter,   true,    "rlane_cd",     false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   50,    daCenter,   true,    "dir_cd",     	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   50,    daCenter,   true,    "ioc_ts_cd",    false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   50,    daCenter,   true,    "bse_yr",     	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtComboEdit ,   50,    daCenter,   true,    "bse_wk",     	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtData ,    	50,    daCenter,   true,    "sls_aq_cd",    false,	"",       dfNone,       0,     false,      false);
	            InitDataProperty(0, cnt++ , dtData ,    	70,    daCenter,   true,    "sls_ofc_cd",	false,	"",       dfNone,       0,     false,      true);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd1",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd2",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd3",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd4",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd5",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd6",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd7",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd8",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd9",     	false,	"",       dfNone,       0,     true,       true,5);
	            InitDataProperty(0, cnt++ , dtPopupEdit ,   50,    daCenter,   true,    "pol_cd10",    	false,	"",       dfNone,       0,     true,       true,5);

	            //콤보항목설정[ROW, COL, COMBO-TEXT, COMBO-CODE, DEFAULT-TEXT]
  
	            for(var i = 0 ; i < 19 ; i++){
	            	InitDataValid(0, 3+i, vtEngUpOther,"0123456789");
	            }
    	 }   	       
     }
        
	 /**
     * TabSheet2에서 조회후 타이틀 변경
     */
	function initSheet2(sheetObj){
    	 with (sheetObj) {
    		 // 높이 설정
    		 //style.height = 300 ;
    		 style.height = getSheetHeight(19) ;

    		 //전체 너비 설정
             SheetWidth = mainTable.clientWidth;
			 CountPosition = 0;

			 //Host정보 설정[필수][HostIp, Port, PagePath]
			 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			 //전체Merge 종류 [선택, Default msNone]
			 MergeSheet = msHeaderOnly;

			 //전체Edit 허용 여부 [선택, Default false]
			 Editable = true;
			 FocusEditMode = default_edit_mode;

			 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			 InitRowInfo( 2, 1, 10, 1000);

			 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			 InitColumnInfo(23, 0 , 0, true);

			 // 해더에서 처리할 수 있는 각종 기능을 설정한다
			 InitHeadMode(true, true, false, true, false,false) ;
	
			 //var txtHead1 = "F'Cast|Diff/Shortfall|Ratio";
			 var HeadTitle1 = "DEL|STS|SEQ|REP Trade|Sub-Trade|Lane|BD|O/I/T|VVD|Year|WK|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";
			 var HeadTitle2 = "DEL|STS|SEQ|REP Trade|Sub-Trade|Lane|BD|O/I/T|VVD|Year|WK|Area|RGN OFC|Port1|Port2|Port3|Port4|Port5|Port6|Port7|Port8|Port9|Port10";

			 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			 InitHeadRow(0, HeadTitle1, true);
			 InitHeadRow(1, HeadTitle2, true);
			 var cnt = 0;
				
			 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			 InitDataProperty(0, cnt++, dtDelCheck,   	30,    daCenter,   true,    "",     	 	false,      "",       dfNone,   	   0,       true,       true);
			 InitDataProperty(0, cnt++, dtStatus,     	30,    daCenter,   true,    "ibflag",   	false,      "",       dfNone,   	   0,  	    false,      true);
			 InitDataProperty(0, cnt++ , dtDataSeq,   	30,    daCenter,   true,    "tmp_seq",   	false,      "",       dfNone,          0,     false,       true);
			 InitDataProperty(0, cnt++ , dtComboEdit ,  80,    daCenter,   true,    "rep_trd_cd",   false,      "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtComboEdit ,  80,    daCenter,   true,    "rep_sub_trd_cd", false,    "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtComboEdit ,  50,    daCenter,   true,    "rlane_cd",     false,      "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtComboEdit ,  50,    daCenter,   true,    "dir_cd",     	false,      "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtComboEdit ,  50,    daCenter,   true,    "ioc_ts_cd",    false,      "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtData ,    	100,   daCenter,   true,    "vvd",     		false,      "",       dfNone,       0,     false,       true,   9);
			 InitDataProperty(0, cnt++ , dtData ,    	50,    daCenter,   true,    "sls_yrmon",    false,      "",       dfNone,       0,     false,       false);
			 InitDataProperty(0, cnt++ , dtData ,    	50,    daCenter,   true,    "cost_wk",      false,      "",       dfNone,       0,     false,       false);
			 InitDataProperty(0, cnt++ , dtData ,    	50,    daCenter,   true,    "sls_aq_cd",    false,      "",       dfNone,       0,     false,       false);
			 InitDataProperty(0, cnt++ , dtData ,    	70,    daCenter,   true,    "sls_ofc_cd",   false,      "",       dfNone,       0,     false,       true);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd1",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd2",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd3",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd4",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd5",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd6",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd7",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd8",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd9",      false,      "",       dfNone,       0,     true,       true,5);
			 InitDataProperty(0, cnt++ , dtPopupEdit ,  50,    daCenter,   true,    "pol_cd10",		false,      "",       dfNone,       0,     true,       true,5);
            
			 for(var i = 0 ; i < 20 ; i++){
				 InitDataValid(0, 3+i, vtEngUpOther,"0123456789");
	         }
    	 }
     }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
           case IBSEARCH:      //조회
                var sheetObj = sheetObjects[beforetab];
                
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }

				check_retrive = true;
				
                if(beforetab==0){
                	searchByWeek(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                }else if(beforetab==1){
                                	
                	searchByVvd(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                }
			break;

			case IBSAVE:        //저장	
                var tran_rows = sheetObj.FindStatusRow("I|U");
	            
				if(!retouchPort(sheetObj,tran_rows)){ //port 중복 및 port1부터 채우도록 수정
					return false;
				}
	            if(!checkFormat(sheetObj,tran_rows)) {
	           	    return false;   
	            }
	            if(!checkDupRow(sheetObj)){		//rgn ofc 기준으로 yrwk까지 동일한 row가 있는지 체크
	            	return false;
	            }
	            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0100GS.do", "f_cmd="+(MULTI01 + beforetab));
           	break;           

         	case IBINSERT:      // 입력
         	    var sheetObj = sheetObjects[beforetab];
             	var Row = sheetObj.DataInsert();
             	if(beforetab==0){
	             	var text = sheetObj.CellValue(Row, "ibflag")
	             	for ( var k = 0; k < 10; k++ ) {
	             		sheetObj.CellValue2( Row, 22 + ( k * 9 ) ) = text;
	             	}
             	}else if(beforetab==1){
             		var text =  sheetObj.CellValue(Row, "ibflag");
            	 	for ( var j = 0; j < 10; j++ ) {
            	 		sheetObj.CellValue2 ( Row, 23 + ( j * 8 ) ) = text;
            	 	}
             	}
             	break;

           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
    	
	function searchByWeek(sheetObj, formObj, command){
		if(tab_retrives[beforetab]) return;
		
		var param = "year=" + formObj.year.value;
		param = param + "&week="     + formObj.week.value;
		param = param + "&rhq="      + comObjects[0].Code;
		param = param + "&vvd="      + formObj.vvd.value;
		param = param + "&trade="    + comObjects[1].Code;
		param = param + "&subtrade=" + comObjects[2].Code;
		param = param + "&lane="     + comObjects[3].Code;
		param = param + "&bound="    + formObj.bound.value;
		param = param + "&ocnipc="   + formObj.ocnipc.value;
		
		var rtn = sheetObj.DoSearch("ESM_SPC_0100GS.do","f_cmd="+command+"&"+param + "&" + ComGetPrefixParam(""));
        tab_retrives[beforetab] = true;
	}

	function searchByVvd(sheetObj, formObj, command){
		if(tab_retrives[beforetab]) return;
		
		var param = "year=" + formObj.year.value;
		param = param + "&week="     + formObj.week.value;
		param = param + "&rhq="      + comObjects[0].Code;
		param = param + "&vvd="      + formObj.vvd.value;
		param = param + "&trade="    + comObjects[1].Code;
		param = param + "&subtrade=" + comObjects[2].Code;
		param = param + "&lane="     + comObjects[3].Code;
		param = param + "&bound="    + formObj.bound.value;
		param = param + "&ocnipc="   + formObj.ocnipc.value;
		
		var rtn = sheetObj.DoSearch("ESM_SPC_0100GS2.do","f_cmd="+command+"&"+param + "&" + ComGetPrefixParam(""));
        tab_retrives[beforetab] = true;
	}
    	
	function t1sheet1_OnPopupClick(sheetObj, row, col){   
    	if ( sheetObj.ColSaveName(col).substring(0,6) == "pol_cd" ){
    		var pol_cd = sheetObj.CellValue(row, col);
    	    spcPopup("POL", "tt_pol_cd="+pol_cd+"", 770, 470, "setSheet1PopUpValue", "1,0,1,1,1,1,1,1", row, col);
    	}
    }
	
    function t2sheet2_OnPopupClick(sheetObj, row, col){   
		if ( sheetObj.ColSaveName(col).substring(0,6) == "pol_cd" ){
			var pol_cd = sheetObj.CellValue(row, col);
			spcPopup("POL", "tt_pol_cd="+pol_cd+"", 770, 470, "setSheet2PopUpValue", "1,0,1,1,1,1,1,1", row, col);
        }
    }
        
    function setSheet1PopUpValue(rowArray, row, col) {
		var sheetObj = sheetObjects[0];
		var colArray = rowArray[0];
	
		sheetObj.CellValue(row, col) = colArray[3];
	}
	
	function setSheet2PopUpValue(rowArray, row, col) {
		var sheetObj = sheetObjects[1];
		var colArray = rowArray[0];
		
		sheetObj.CellValue(row, col) = colArray[3];
	}

	function checkFormat(sheetObj,trans_rows){
		var arrRow = trans_rows.split(";");
		var sheetObj = sheetObjects[beforetab];
		for (var idx = 0; idx < arrRow.length-1; idx++) {
			var trade = sheetObj.CellValue(arrRow[idx], 3);
			var subtrade = sheetObj.CellValue(arrRow[idx], 4);
			var lane = sheetObj.CellValue(arrRow[idx], 5);
			var dir_cd = sheetObj.CellValue(arrRow[idx], 6);
			var ioc_ts_cd = sheetObj.CellValue(arrRow[idx], 7);
			var bse_yr = sheetObj.CellValue(arrRow[idx], 8);
			var bse_wk = sheetObj.CellValue(arrRow[idx], 9);
			var sls_ofc_cd = sheetObj.CellValue(arrRow[idx], 11);
			var pol_cd = sheetObj.CellValue(arrRow[idx], 12);
			
			if(trade == "") {              	
				ComShowMessage(getMsg("SPC90117", "Trade"));            
				sheetObj.SelectCell(arrRow[idx], 3, true);
				return false;   
			} else if(subtrade == "") {
	 			ComShowMessage(getMsg("SPC90117", "Sub_Trade"));
	    		sheetObj.SelectCell(arrRow[idx], 4, true);
	    		return false;   
	 		} else if(lane == "") {
	 			ComShowMessage(getMsg("SPC90117", "Lane"));
	    		sheetObj.SelectCell(arrRow[idx], 5, true);
	    		return false; 
	 		} else if(dir_cd == ""){
	 			ComShowMessage(getMsg("SPC90117", "Bound"));
	 			sheetObj.SelectCell(arrRow[idx], 6, true);
	    		return false; 	
	 		} else if(ioc_ts_cd == ""){
	 		    ComShowMessage(getMsg("SPC90117", "O/I/T"));
	    	    sheetObj.SelectCell(arrRow[idx], 7, true);
	    		return false; 	
	 		}
	     	
	     	if(beforetab==0){
	     		if(bse_yr == ""){
	     			ComShowMessage(getMsg("SPC90117", "Year"));
	     			sheetObj.SelectCell(arrRow[idx], 8, true);
    	    		return false; 	
    	 		} else if(bse_wk == ""){
    	 		    ComShowMessage(getMsg("SPC90117", "Week"));
    	    	    sheetObj.SelectCell(arrRow[idx], 9, true);
    	    		return false; 	
    	 		} else if(sls_ofc_cd == ""){
    	 		    ComShowMessage(getMsg("SPC90117", "Office"));
    	    	    sheetObj.SelectCell(arrRow[idx], 11, true);
    	    		return false; 	
    	 		} else if(pol_cd == ""){
    	 		    ComShowMessage(getMsg("SPC90117", "Port"));
    	    	    sheetObj.SelectCell(arrRow[idx], 12, true);
    	    		return false; 	
    	 		}
	     	} else if(beforetab==1){
	     		var vvd = sheetObj.CellValue(arrRow[idx], 8);
	     		var sls_ofc_cd = sheetObj.CellValue(arrRow[idx], 12);
	     		var pol_cd = sheetObj.CellValue(arrRow[idx], 13);
	     		if(vvd == ""){
	     			ComShowMessage(getMsg("SPC90117", "Vvd"));
	     			sheetObj.SelectCell(arrRow[idx], 8, true);
	     			return false; 	
	     		}else if(sls_ofc_cd == ""){
	     			ComShowMessage(getMsg("SPC90117", "Office"));
	     			sheetObj.SelectCell(arrRow[idx], 12, true);
	     			return false; 	
	     		} else if(pol_cd == ""){
	     			ComShowMessage(getMsg("SPC90117", "Port"));
	     			sheetObj.SelectCell(arrRow[idx], 13, true);
	     			return false; 	
	     		}
	     	}
		}
		return true;
	}
               
	/*
	 *  trade변경시
	 */
    function trade_OnChange(comObj,value,text ){
    	//sub_trade의 초기화
    	comObjects[2].index2 = 0; 
    	//lane의 초기화
    	comObjects[3].Index2 = 0;   
    	SpcSearchOptionSubTrade("subtrade",true,true,"","",value);			// 0207 SHKIM
		SpcSearchOptionLane("lane",true,false,'',value,'',true);			// 0207 SHKIM
    }   

    function subtrade_OnChange(comObj,value,text ){
    	SpcSearchOptionLane("lane",true,false,'',document.form.trade.Code,value,true);	// 0207 SHKIM    	
    	if(value == "") return;

    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[1].Code2 = arrTrade[0];
    		comObjects[3].Code2 = '';
    	} else {
    		comObjects[1].Code2 = comObj.GetText(value,0);  
    		comObjects[3].Code2 = '';
    	}  
    }
    
    function lane_OnChange(comObj,value,text ){
    	if(value == "" ) return;

    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[1].Code2 = arrLane[0];
    		comObjects[2].Code2 = arrLane[1];
    	} else {
    		comObjects[1].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = comObj.GetText(value,1);  
    	}	
    }
    
    function t1sheet1_OnChange(sheetObj,row, col, value) {
        with(sheetObj){
        	switch(ColSaveName(col)){
        		case "rlane_cd":
//        			if(value!="" && sheetObj.CellValue(row, "pol_cd1")!=""){
//        				if(!checkValidPort(sheetObj, row, "pol_cd1", sheetObj.CellValue(row, "pol_cd1"))){
//        					//valid하지 않은 경우, pol_cd2~pol_cd10 모두 삭제
//        					sheetObj.CellValue(row, "pol_cd2")
//        					break;
//        				}
//        			}
        			//pol 중 하나라도 있는 상태에서 change시, port validation을 수행하고,  
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "rep_sub_trd_cd") = text; 
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                    
                case "rep_sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "rep_sub_trd_cd") = text; 
                    CellValue2(row, "rlane_cd") = "";
                    break;  
                  
                case "rep_trd_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text; 
            		CellValue2(row, "rep_sub_trd_cd") = "";
            		CellValue2(row, "rlane_cd") = "";
            		break;   
                  
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text; 
                	break;
               	 
                case "ioc_ts_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "ocnipc", value);
                	CellValue2(row, "ioc_ts_cd") = text; 
                	break;
                 
                case "bse_yr":
                	var text = getSheetComboText(sheetObj, row, col, 0, "year", value);
                	CellValue2(row, "bse_yr") = text; 
                	break;
               	  
                case "bse_wk":
                	var text = getSheetComboText(sheetObj, row, col, 0, "week", value);
                	CellValue2(row, "bse_wk") = text; 
                	break;
                	
                case "pol_cd1":
                case "pol_cd2":
                case "pol_cd3":
                case "pol_cd4":
                case "pol_cd5":
                case "pol_cd6":
                case "pol_cd7":
                case "pol_cd8":
                case "pol_cd9":
                case "pol_cd10":
                	if(value!=""){
                		if(sheetObj.CellValue(row,"rlane_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "Lane first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "rlane_cd");
                		}else if(sheetObj.CellValue(row,"dir_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "Bound first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "dir_cd");
                		}else if(sheetObj.CellValue(row,"ioc_ts_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "ioc_ts_cd");
                		}else{
                			checkValidPort(sheetObj, row, col, value);
                		}
                	}
                	break;
                	
                case "sls_ofc_cd":
                	if(value!=""){
                		checkValidOfc(sheetObj, row, col, value);
                	}
                	break;
                      
            }
        }
  	}
    
   	function t2sheet2_OnChange(sheetObj,row, col, value) {
   		with(sheetObj){
   			switch(ColSaveName(col)){
   				case "rlane_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "lane", value);
                    CellValue2(row, "rep_trd_cd") = text;
                   
                    text = getSheetComboText(sheetObj, row, col, 1, "lane", value);
                    CellValue2(row, "rep_sub_trd_cd") = text; 
                      
                    text = getSheetComboText(sheetObj, row, col, 2, "lane", value);
                    CellValue2(row, "rlane_cd") = text; 
                    break;
                
                case "rep_sub_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "subtrade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    text = getSheetComboText(sheetObj, row, col, 1, "subtrade", value);
                    CellValue2(row, "rep_sub_trd_cd") = text;
                    CellValue2(row, "rlane_cd") = "";
                    break;
                    
                case "rep_trd_cd":
                    var text = getSheetComboText(sheetObj, row, col, 0, "trade", value);
                    CellValue2(row, "rep_trd_cd") = text;
                    CellValue2(row, "rep_sub_trd_cd") = "";
                    CellValue2(row, "rlane_cd") = "";
                    break;
                    
                case "dir_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "bound", value);
                	CellValue2(row, "dir_cd") = text;
                	break;
                	
                case "ioc_ts_cd":
                	var text = getSheetComboText(sheetObj, row, col, 0, "ocnipc", value);
                	CellValue2(row, "ioc_ts_cd") = text;
                	break;
                	
                	
                case "pol_cd1":
                case "pol_cd2":
                case "pol_cd3":
                case "pol_cd4":
                case "pol_cd5":
                case "pol_cd6":
                case "pol_cd7":
                case "pol_cd8":
                case "pol_cd9":
                case "pol_cd10":
                	if(value!=""){
                		if(sheetObj.CellValue(row,"rlane_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "Lane first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "rlane_cd");
                		}else if(sheetObj.CellValue(row,"dir_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "Bound first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "dir_cd");
                		}else if(sheetObj.CellValue(row,"ioc_ts_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "ioc_ts_cd");
                		}else{
                			checkValidPort(sheetObj, row, col, value);
                		}
                	}
                	break;
                	
                case "sls_ofc_cd":
                	if(value!=""){
                		checkValidOfc(sheetObj, row, col, value);
                	}
                	break;
                	
                case "vvd":
                	if(value!=""){
                		if(sheetObj.CellValue(row,"ioc_ts_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "OCN/IPC/TS first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "ioc_ts_cd");
                		}else if(sheetObj.CellValue(row,"rlane_cd")==""){
                			ComShowMessage(getMsg("SPC90117", "Lane first"));
                    		sheetObj.CellValue2(row,col)="";
                    		sheetObj.SelectCell(row, "rlane_cd");
                		}else if(sheetObj.CellValue(row,"dir_cd")!=value.substring(value.length-1, value.length)){
                			ComShowMessage("Please check a direction.");
                			sheetObj.CellValue2(row,col)="";
                		}else{
                			checkValidVvd(sheetObj, row, col, value);
                		}
                	}
                	break;
            }
        }            
  	}    
        
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		var year = formObj.year.value;
		var week = formObj.week.value;
		var rhq = comObjects[0].Code;
		var vvd = formObj.vvd.value;
		var trade = comObjects[1].Code;;
		
		if(year == "" && week == ""){
			ComShowCodeMessage("COM12139", "Year", "Week");
			formObj.year.focus();
			return false;
		}
		if(rhq == ""){
			ComShowMessage(getMsg("SPC90114", "RHQ"));
			comObjects[0].focus();
			return false;
		}
		if(trade == ""){
			ComShowMessage(getMsg("SPC90114", "Trade"));
		    formObj.trade.focus();
			return false;
		}
		if(vvd != "" && vvd.length < 9){
			ComShowCodeMessage("COM12174", "VVD", "9");
			formObj.vvd.focus();
			return false;
		}
		
        return true;
    }
    
    function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
//    	}else{
//    		ComShowMessage(errMsg);
    	}
    }
    
    function t2sheet2_OnSaveEnd(sheetObj, errMsg) {
    	if(sheetObj.EtcData("status") == "OK"){
    		ComShowMessage("saved successfully.");  
//    	}else{
//    		ComShowMessage(errMsg);
    	}
    }

    function initDataValue_rhq(){
    	var sheetObj = document.getElementById("rhq");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subtrade(){
    	var sheetObj = document.getElementById("subtrade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week",false,document.form.year.value);
    	
    }

    function checkValidPort(sheetObj, row, col, value){
    	var param = "f_cmd=" + SEARCH01;
    	param = param + "&rlane_cd="	+ sheetObj.CellValue(row, "rlane_cd");
		param = param + "&dir_cd="		+ sheetObj.CellValue(row, "dir_cd");
		param = param + "&ioc_ts_cd="	+ sheetObj.CellValue(row, "ioc_ts_cd");
		param = param + "&pol_yd_cd="	+ value;
		
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0100GS.do", param);
		var flg = ComGetEtcData(sXml, "valid_flg");
		if(flg!="Y"){
			ComShowMessage("Lane, Bound, O/I/T and Port do not match. Please check again.");
			sheetObj.CellValue2(row, col) = "";
			sheetObj.SelectCell(row, col);
			return false;
		}
		return true;
    }
    
    function checkValidOfc(sheetObj, row, col, value){
    	var param = "f_cmd=" + SEARCH02;
    	param = param + "&sls_ofc_cd="	+ value;
    	
    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0100GS.do", param);
    	var flg = ComGetEtcData(sXml, "valid_flg");
    	if(flg!="Y"){
    		ComShowMessage("Office is not level 4. Please check again.");
    		sheetObj.CellValue2(row, col) = "";
    	}
    }
    
    function checkValidVvd(sheetObj, row, col, value){
    	var param = "f_cmd=" + SEARCH03;
    	param = param + "&vvd="	+ sheetObj.CellValue(row, "vvd");
    	param = param + "&rlane_cd="+ sheetObj.CellValue(row, "rlane_cd");
    	param = param + "&ioc_ts_cd="+ sheetObj.CellValue(row, "ioc_ts_cd");
    	
    	var sXml = sheetObj.GetSearchXml("ESM_SPC_0100GS.do", param);
    	var flg = ComGetEtcData(sXml, "valid_flg");
    	if(flg!="Y"){
    		ComShowMessage(value + " is not a target VVD. Please check again.");
    		sheetObj.CellValue2(row, col) = "";
    	}
    }
    
	function retouchPort(sheetObj,trans_rows){
		var baseIdx;
		if(beforetab==0){
			baseIdx = 11;
		}else{
			baseIdx = 12;
		}

	
    	var arrRow = trans_rows.split(";");
		for (var idx = 0; idx < arrRow.length-1; idx++) {
			if(!removeDupPort(sheetObj, arrRow[idx], baseIdx)){
				return false;
			}
			for(var portIdx = 10; portIdx>1; portIdx--){
				var polCd = sheetObj.CellValue(arrRow[idx], Number(baseIdx) + portIdx);
				
				if(polCd!=""){
					movingPort(sheetObj, arrRow[idx], portIdx, baseIdx);
				}
			}
		}
		return true;
	}
	
	function movingPort(sheetObj, row, portIdx, baseIdx){
		var movePort = sheetObj.CellValue(row, Number(baseIdx) + portIdx);
		for(var i = 1; i<portIdx; i++){
			var pCd = sheetObj.CellValue(row, Number(baseIdx) + i);
			if(pCd == ""){
				sheetObj.CellValue2(row, Number(baseIdx) + i) = movePort;
				sheetObj.CellValue2(row, Number(baseIdx) + portIdx) = "";
				return;
			}
		}
	}
	
	function removeDupPort(sheetObj, row, baseIdx){

		for(var portIdx = 10; portIdx>1; portIdx--){ /* portIdx>2 => portIdx>1 로 수정 20130521 smk */
			var portCd = sheetObj.CellValue(row, Number(baseIdx) + portIdx);
					
			if(sheetObj.CellValue(row, Number(baseIdx) + portIdx)!=""){
				for(var cprIdx = portIdx-1; cprIdx>=1; cprIdx--){
					var cprPortCd = sheetObj.CellValue(row, Number(baseIdx) + cprIdx);
					
					if(portCd == cprPortCd){
						ComShowMessage(getMsg("SPC90135"));
						sheetObj.SelectCell(row, Number(baseIdx) + portIdx);
						return false;
					}
				}
			}
		}
		return true;
	}
	
	function checkDupRow(sheetObj){
		sheetObj.SpaceDupCheck = true;
		var cmprCol;
		if(beforetab==0){
			cmprCol = "3|4|5|6|7|8|9|11";	//trade,sub trade,lane,bd,oit,yr,wk,rgn ofc
		}else{
			cmprCol = "3|4|5|6|7|8|12";		//trade,sub trade,lane,bd,oit,vvd,rgn ofc
		}
		var rtn = sheetObj.ColValueDup(cmprCol, false);
		
		if(rtn!="-1"){
			ComShowMessage("There are duplicated rows. Please check again.");
			sheetObj.SelectCell(rtn, "tmp_seq");
			return false;
		}
		return true;
	}
    
	/* 개발자 작업  끝 */
