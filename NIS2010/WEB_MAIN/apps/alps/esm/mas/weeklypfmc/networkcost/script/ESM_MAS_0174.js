 /*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0174.js
*@FileTitle : Average U/C(OP fixed/variable cost, SPC CHT Rev/Charterage) 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
=========================================================
* History
* 2009.12.24 최인경 ALPS 적용
* 2010.02.11 이행지 Ticket ID:CHM-201002397 Vessel Pool 및 OP4 logic 보완 요청
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.15 이행지 FormQueryString => masFormQueryString 변경
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.12.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
* 2011.12.23 최성민 [CHM-201114896-01] [MAS] CM2 추가 개발 요청
=========================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends 
 * @class ESM_MAS_0174 : ESM_MAS_0174 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0174() {
    this.processButtonClick		= processButtonClick;
    this.chgTrade               = chgTrade;
    this.popVvdCheck            = popVvdCheck;
    this.chgViewColumn          = chgViewColumn;
    this.setPeriod              = setPeriod;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.setSheetObject 		= setSheetObject;
    this.sheet1_OnChange 		= sheet1_OnChange;
    this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
    this.doActionIBSheet 		= doActionIBSheet;
    this.validateForm           = validateForm;
    this.validateForm2          = validateForm2;
    this.chkValidSearch         = chkValidSearch;
    this.validateCreation       = validateCreation;
    this.validateBatch          = validateBatch;
    this.setFmToDate            = setFmToDate;
}

//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

/* 공통전역변수 */
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var comboObjects = new Array();
var comboCnt = 0;
var costCdArr;

var loadingMode = false;
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
        var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":		//조회
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;

				case "btn_Save":			//저장
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
					
				case "btn_Create":			//Creation
					doActionIBSheet(sheetObject,formObject,IBCREATE);
					break;

				case "btn_Downexcel":		//엑셀다운로드
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_Month_Copy":		//팝업창(Month Copy)
	        	       var display = "0,1";
	        	       ComOpenPopup("ESM_MAS_0173.do", 250, 200, "AverageUcCopy", display, true, false);
	        	       break;	
				case "btn_rowadd":
					doActionIBSheet(sheetObject, formObject, IBINSERT);
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
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
		
        // 텝 처리
        //---------------------------------------------
    	for(k=0;k<tabObjects.length;k++){
  	  		initTab(tabObjects[k],k+1);
  		}
    		
		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
		loadingMode = false;
		// 월/주 입력 창에 금월 셋팅
		setYrMon();	
		setPeriod(document.form.f_cost_yrmon);
		document.form.f_cost_yrmon.focus();
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
                    InsertTab( cnt++, "  Average U/C  " , -1 );
                    InsertTab( cnt++, "  Raw Data  " , -1 );
                }
             break;
        }
    }


     /**
      * IBCOMBO를 초기화하는 function <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} comboObj 필수 IBMultiCombo Object
      * @param {int} comboNo 필수 IBMultiCombo의 순번
      * @return 없음
      * @author 최성민
      * @version 2012.10.13
      */ 
     function initCombo(comboObj, comboNo) {
	   	 with (comboObj) {
	   		 switch(id) {
	  	        case "f_rlane_cd":  	            
	            	DropHeight = 300;
	            	MaxLength = 5;
	            	ValidChar(2, 3);	//영어 대문자, 숫자+특수문자 포함
	 	    	 	InsertItem(0, 'All' ,'');
	 	    	 	Index = 0;           
	  	            break;	
	  	        case "f_trd_cd":	          
	            	DropHeight = 300;
	 	    	 	InsertItem(0, 'All' ,'');
	 	    	 	Index = 0;    
		            break;	 
	  	        case "f_dir_cd":	           
	            	DropHeight = 300;
	 	    	 	InsertItem(0, 'All' ,'');
	 	    	 	Index = 0;
		            break;	 
	   		 }
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
	    	case 1:      //sheet1 init
	    		with (sheetObj) {
	            	
	            	// 높이 설정
  					style.height = GetSheetHeight(16) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 3, 100);
					
					var HeadTitle1 = "|Seq|Del|R.Month|Trade|Lane|BD|Trade Dir.|S.C.Rev|Port Expense|Canal Transit Fee|Bunker|Crew Expense|Insurance|Lubricant Expense" +
									"|Store Supply Expense|Vessel MR|Depreciations|Telecom Expense|Other Operation Fixed Exp|Time Charterage|Space Charterage" +
									"|Lane Type|U/C Source|U/C Source|U/C Source|Fixed Vessel Type|Fixed Vessel Type|Fixed Vessel Type";
					var HeadTitle2 = "|Seq|Del|R.Month|Trade|Lane|BD|Trade Dir.|S.C.Rev|Port Expense|Canal Transit Fee|Bunker|Crew Expense|Insurance|Lubricant Expense" +
									"|Store Supply Expense|Vessel MR|Depreciations|Telecom Expense|Other Operation Fixed Exp|Time Charterage|Space Charterage" +
									"|Lane Type|OWN|CHT|OTH|OWN|CHT|OTH";
    
			        var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 8, 0, false);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
			        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus,	0,		daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,  	40,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtDelCheck,  	40,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"cost_yrmon"		,false,"",dfDateYm,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"trd_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	"rlane_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtCombo,		40,		daCenter,	true,	"dir_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtCombo,		75,		daCenter,	true,	"hul_bnd_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_01"			,false,"",dfInteger,	0,  true,   true, 5);				
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_02"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	"amt_03"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_04"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_05"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_06"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		 	100,	daRight,	true,	"amt_07"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,    true,	"amt_08"	 	   	,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		 	100,	daRight,	true,	"amt_09"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_10"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		  	110,	daRight,    true,	"amt_11"	        ,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,	   	 	110,	daRight,	true,	"amt_12"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	"amt_13"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	"amt_14"			,false,"",dfInteger,	0,  true,   true, 5);

					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"op_lane_tp_cd"		,false,"",dfNone,		0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"uc_own_freq_no"	,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"uc_cht_freq_no"	,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"uc_oth_freq_no"	,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"fix_own_freq_no"	,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"fix_cht_freq_no"	,false,"",dfInteger,	0,  false,   false);
					InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	"fix_oth_freq_no"	,false,"",dfInteger,	0,  false,   false);
					
					WaitImageVisible = false;
					CountPosition = 0;
					//SelectHighLight= true;
					// 문장이 길경우 ...으로 표시함
					Ellipsis = true;					
	        	}
	        	break;
			case 2:		//sheet1 init
				with (sheetObj) {
	            	
	            	// 높이 설정
						style.height = GetSheetHeight(16) ;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|Seq|Trade|Lane|BD|Trade Dir.|OPR2|BSA|Number of Vessels|S.C.Rev|Port Expense|Canal Transit Fee|Bunker|Crew Expense|Insurance|Lubricant Expense" +
									"|Store Supply Expense|Vessel MR|Depreciations|Telecom Expense|Other Operation Fixed Exp|Time Charterage|Space Charterage|YYYY_MM";
			        
			        var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, false);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
					InitHeadMode(true, false, false, true, false,false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
			        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++,  dtHiddenStatus,	0,		daCenter,  false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,  	40,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"trd_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"rlane_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"dir_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,	"hul_bnd_cd"			,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"vsl_oshp_cd"		,false,"",dfNone,		0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	"hjs_bsa_capa"		,false,"",dfInteger,	0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"freq_no"			,false,"",dfInteger,	0,  false,   true);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_01"			,false,"",dfInteger,	0,  true,   true, 5);				
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_02"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_03"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_04"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_05"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_06"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		 	100,	daRight,	true,	"amt_07"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,    true,	"amt_08"	 	   	,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		 	100,	daRight,	true,	"amt_09"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_10"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,		  	100,	daRight,    true,	"amt_11"	        ,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,	   	 	100,	daRight,	true,	"amt_12"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_13"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"amt_14"			,false,"",dfInteger,	0,  true,   true, 5);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cost_yrmon");
					
					WaitImageVisible = false;
					CountPosition = 0;
					SelectHighLight= true;
					// 문장이 길경우 ...으로 표시함
					Ellipsis = true;					
	        	}
	        	break;
		}
	}
	
	/**
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }
    
 	/**
 	 * Tab 클릭시 이벤트 관련
 	 * 선택한 탭의 요소가 활성화 된다.
 	 */
	function tab1_OnChange(tabObj , tabIndex){
		var formObject = document.form;		
				
		if(beforetab==tabIndex) return;
	    var objs = document.all.item("tabLayer");

	    objs[tabIndex].style.display = "inline";
	    objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[tabIndex].style.zIndex -1 ;
		//------------------------------------------------------//
		
	    beforetab= tabIndex;	    
	}


	/**
     * trade code 변경시 해당Row의 subTrade, service Lane, Revenue Lane code List를 변경한다.
     */
    function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;

        if(sheetObj.ColSaveName(col) == "trd_cd"){
        	var formObj = document.form;
     		var sheetObj = sheetObjects[0];
    		formObj.f_cmd.value = SEARCHLIST10;
    		
    		var param = "f_cmd="+SEARCHLIST10 +"&f_trd_cd=" + value;
    		var sXml = sheetObj.GetSearchXml("ESM_MAS_0174GS.do", param);
    		var arrXml = sXml.split("|$$|");
    		if (arrXml.length > 0)
    			ComMasSetIBCombo(sheetObj, arrXml[0], "rlane_cd", true, 0, row);
    		
        }
    }
    
    
     /**
 	 * trade코드 변경시 rLane 리스트를 리플래쉬 한다.
 	 */
 	function f_trd_cd_OnChange(obj,value,text) {
 		if (loadingMode == true) return; 
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
		formObj.f_cmd.value = SEARCHLIST10;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0174GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "name");
		formObj.f_rlane_cd.InsertItem(0, "All", "All");
		formObj.f_rlane_cd.Index = 0;
 		
 	}
    
     
    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */        
    function setYrMon(){
    	var formObj = document.form;
    	with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm").lpad(2, "0"); 	            
    		var nowYrMon = nowYear + nowMon;
    		
    		f_cost_yrmon.value = ComGetMaskedValue(nowYrMon,'ym');
    	}
    }	
    
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch(sAction) {
			case IBCLEAR:          //조회
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;				
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0174GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "code");
					ComMasSetIBCombo(sheetObj, arrXml[0], "trd_cd", true, 0);
				}
				if (arrXml.length > 1) {
					ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
					ComMasSetIBCombo(sheetObj, arrXml[1], "rlane_cd", true, 0);
				}
				if (arrXml.length > 2) {
					ComXml2ComboItem(arrXml[2], formObj.f_dir_cd, "code", "name");
					ComMasSetIBCombo(sheetObj, arrXml[2], "dir_cd", true, 0);
				}
						
				ComOpenWait(false);
				break;	
			case IBSEARCH:		//조회			
				if(!validateForm(sheetObj,formObj,sAction)){
					return false;
				}
				
				//생성후를 고려하여 재조회
				if(formObj.f_fm_yrwk.value == "") {
					setPeriod(formObj.f_cost_yrmon);
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				//sheetObj.DoSearch4Post("ESM_MAS_0174GS.do", masFormQueryString(formObj));

				var sXml = sheetObj.GetSearchXml("ESM_MAS_0174GS.do", masFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
								
  				sheetObjects[0].Redraw = false;
  				sheetObjects[1].Redraw = false;  				
  				sheetObjects[0].LoadSearchXml(arrXml[0]);
  				sheetObjects[1].LoadSearchXml(arrXml[1]);
  				sheetObjects[1].Redraw = true;
  				sheetObjects[0].Redraw = true;
  				
				ComOpenWait(false);
				
				break;

			case IBSAVE:        // 저장
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
        		
				if (!ComShowCodeConfirm("MAS00006")) {
					return false;
				}
				
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				sheetObj.DoSave("ESM_MAS_0174GS.do", masFormQueryString(formObj), -1, false);
				ComOpenWait(false);
				break;
				
			case IBCREATE:		//CREATE
				var strUrl = "ESM_MAS_0184.do" + "?f_rpb_yrmon="+formObj.f_cost_yrmon.value+"&classId=ESM_MAS_0174";
				ComOpenWindow(strUrl,'temp','width=300,height=210,menubar=0,status=0,scrollbars=0,resizable=0,top=200,left=400');
				break;				

			case IBDOWNEXCEL:        //엑셀 다운로드
				
				if(beforetab == 0) {
					sheetObj = sheetObjects[0];
				} else if(beforetab == 1) {
					sheetObj = sheetObjects[1];
				}
				
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
			
			case IBINSERT:				
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
        		
				var Rows = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(Rows, "cost_yrmon") = ComGetUnMaskedValue(formObj.f_cost_yrmon.value, "ym");
				break;	
		}
	}
    
	/**
	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
	*/
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (f_cost_yrmon.value == "") {
				ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
				f_cost_yrmon.focus();
				return false;
			} 
            if(f_cost_yrmon.value.replace("-","").length != 6) {
			    // [COM12114] : YYYY-MM 를(을) 확인하세요.
            	ComShowMessage(ComGetMsg("COM12114","YYYY-MM",""));
            	f_cost_yrmon.focus();
                return false;
            }
            //if(!isValidYYYYWW(f_cost_yrmon, false, '-', false)) return false;
            if(!ComChkObjValid(f_cost_yrmon, null, null, "yw")) return false;
            
            
            switch (sAction) {
				case IBSEARCH: // 조회
					if(formObj.f_cost_yrmon.value == "") {
						ComShowCodeMessage("MAS10015","YYYY-MM"); 
					}
					break;
		
		  		case IBSAVE:
					break;

		  		case IBINSERT:		  			
					if(formObj.f_cost_yrmon.value == "") {
						ComShowCodeMessage("MAS10015","YYYY-MM");
						return false;
					}
					break;					
			}
            
		}
		return true;
	}

	
    /**
    * ESM_MAS_177 화면을 오픈한다.
    * 
    * @return
    */
   function openLaneDetail(){
	    var formObj = document.form;
	    
	    //ComOpenWindow('ESM_MAS_0177.do?cost_yrmon='+formObj.f_cost_yrmon.value,'Lane_Detail', 'width=550, height=650,menubar=0,status=0,scrollbars=0,resizable=1');
	    ComOpenPopup('ESM_MAS_0177.do?cost_yrmon='+formObj.f_cost_yrmon.value, 550, 650, 'setPeriod', '1,0,1,1,1,1,1,1');
	  //  ComOpenWindow('ESM_MAS_0177.do?cost_use_tp_cd=A','Lane_Detail', 'width=330, height=350,menubar=0,status=0,scrollbars=0,resizable=1');
   }
   
   /**
    * Average U/C 생성 Status 정보<br>
    * 
    */   
	function setPeriod(obj){
		
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];

  		if(obj == null){
            obj = formObj.f_cost_yrmon;
        }
  		
  		if(obj.value == ""){
            if(obj.name == "f_cost_yrmon" ){
                formObj.f_cost_yrmon.value = "";
                formObj.f_fm_yrwk.value = "";
                formObj.f_to_yrwk.value = "";
                formObj.f_upd_dt.value = "";
            } 
            return false;
        } else {
            if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
            	formObj.f_cost_yrmon.value = "";
                formObj.f_fm_yrwk.value = "";
                formObj.f_to_yrwk.value = "";
                formObj.f_upd_dt.value = "";
            	return false;	
            }
        }
  		
  		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0174GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		
		formObj.f_fm_yrwk.value = ComGetMaskedValue(ComGetEtcData(arrXml[0], "FM_WEEK"),"yw");
        formObj.f_to_yrwk.value = ComGetMaskedValue(ComGetEtcData(arrXml[0], "TO_WEEK"),"yw");
        formObj.f_upd_dt.value = ComGetEtcData(arrXml[0], "UPD_DT");		
	}
 
