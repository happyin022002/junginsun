/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0120.js
*@FileTitle : Non-TPB Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-26
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.1
* 2008-09-16 O Wan-Ki 1.0 최초 생성
* 2009-10-26 Park Sung-Jin 1.2 ALPS Migration 작업
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
* 2015.08.05 Kim Hyun Hwa[CHM-201537151]그룹사 표준 코드 시행 프로그램 수정. SELCON --> SELOPB
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
     * @class ESD_TPB_0120 : ESD_TPB_0120 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0120() {
    	this.processButtonClick     = processButtonClick;
        this.setSheetObject         = setSheetObject;
        this.setComboObject         = setComboObject;
        this.setTabObject           = setTabObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;        
        this.initControl            = initControl;
        this.initTab                = initTab;
        this.doActionIBSheet        = doActionIBSheet;
        this.validateForm           = validateForm;
    } 
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- 요기가 중요 --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
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
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  		document.form.s_ofc_cd_for_rhq.value = "SELCON" ;
  		document.form.s_office_level.value = "H";  		
  		func_rhq_ctrl_ofc_list();
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
  					// 높이 설정
  					style.height = 430;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msAll;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = false;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(12, 2, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)
  		
  					var HeadTitle1 = "Office|Type|Total|Total|TES|TES|TRS|TRS|MNR|MNR|PSO|PSO";
  					var HeadTitle2 = "Office|Type|No.|Ratio(%)|No.|Ratio(%)|No.|Ratio(%)|No.|Ratio(%)|No.|Ratio(%)";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);

  					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0,	cnt++,		   dtData,		80,daCenterTop,   true, "if_ofc_cd", false, "", dfNone,		  0,	  false,	  true,	  400,	 false,	 false);
  					InitDataProperty(0,	cnt++,		   dtData,		100,daCenter,   true, "cd_type", false, "", dfNone,		  0,	  false,	  true,	  400,	 false,	 false);
  					InitDataProperty(0,	cnt++,		   dtData,		70,	daRight,	false,	 "total_cnt", false, "", dfInteger,		  0,	  false,	  true,	  400,	 false,	 false);
  					InitDataProperty(0,	cnt++,		   dtData,		80,	daRight,	false,	  "total_ratio", false, "", dfFloat, 1,		  0,	  false,	  true,	  400,	 false,	 false);
  					InitDataProperty(0,	cnt++,		   dtData,		70,	daRight,	false,	  "tes_cnt",	   false,		 "",	 dfInteger,		  0,	  false,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		80,	daRight,	false,	  "tes_ratio",	   false,		 "",	   dfFloat,		  1,	  false,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		70,	daRight,	false,	  "trs_cnt",	  false,		 "",	 	dfInteger,		 0,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,         dtData,		80,	daRight,	false,	  "trs_ratio",	  false,		 "",	 	dfFloat,		 1,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		70,	daRight,	false,	  "mnr_cnt",	  false,		 "",		dfInteger,		 0,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		80,	daRight,	false,	  "mnr_ratio",	  false,		 "",		dfFloat,		 1,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		70,	daRight,	false,	  "pso_cnt",	  false,		 "",		dfInteger,		 0,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					InitDataProperty(0,	cnt++,		   dtData,		80,	daRight,	false,	  "pso_ratio",	  false,		 "",		dfFloat,		 1,	   true,	  true,	  400,	 false,	 false,	   "",	  false);
  					
  				}
  				break;
  			
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
  				case "bttn_add":
  					   doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "bttn_cancel":
  					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "bttn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "bttn_remove":
  					break;
  				case "bttn_preview":
  					sheetObject.ExcelPrint = "PreView";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEsL);
  					break;
  				case "btn_downexcel":
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "bttn_print":
  					sheetObject.ExcelPrint = "PrintOnly";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_new":
  					sheetObject.RemoveAll();
  					formObject.reset();
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendarFromTo();
  					cal.displayType = "date";
  					cal.select(formObject.s_sdate, formObject.s_edate, 'yyyy-MM-dd');
  					break;
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowCodeMessage('COM12111');
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case IBSEARCH:	  //조회
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0120GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBSAVE:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0120GS.do", tpbFrmQryStr(formObj));
  				break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			/**
  			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
  			 */
  			if(s_if_rhq_cd.options[s_if_rhq_cd.selectedIndex].text == "ALL"){
  				s_if_rhq_cd.options[s_if_rhq_cd.selectedIndex].value = "all";
  			}
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		if(sheetObj.searchRows <= 0) return;

  		var row_cnt = sheetObj.RowCount;
  		for(var i=0;i<4;i++){
  			sheetObj.RowBackColor(row_cnt-i+1) = sheetObj.RgbColor(236,231,247);
  		}

  		var subSumArr = new Array();
  		for(var i = 2; i < sheetObj.Rows ; i++){
  			if(i%4 == 1) {
  				subSumArr[subSumArr.length] = new Array(tpb_change_zero(sheetObj.CellValue(i, "total_cnt"))
  													,tpb_change_zero(sheetObj.CellValue(i, "tes_cnt"))
  													,tpb_change_zero(sheetObj.CellValue(i, "trs_cnt"))
  													,tpb_change_zero(sheetObj.CellValue(i, "mnr_cnt"))
  													,tpb_change_zero(sheetObj.CellValue(i, "pso_cnt")));
  			}
  		}

  		for(var i = 2,j=0; i < sheetObj.Rows ; i++){

  			sheetObj.CellValue(i, "total_ratio") = (sheetObj.CellValue(i, "total_cnt")/subSumArr[j][0])*100;
  			sheetObj.CellValue(i, "tes_ratio") = (sheetObj.CellValue(i, "tes_cnt")/subSumArr[j][1])*100;
  			sheetObj.CellValue(i, "trs_ratio") = (sheetObj.CellValue(i, "trs_cnt")/subSumArr[j][2])*100;
  			sheetObj.CellValue(i, "mnr_ratio") = (sheetObj.CellValue(i, "mnr_cnt")/subSumArr[j][3])*100;
  			sheetObj.CellValue(i, "pso_ratio") = (sheetObj.CellValue(i, "pso_cnt")/subSumArr[j][4])*100;

  			if(i%4 == 1) j++;

  		}
  	}

  	function tpb_change_zero(val){
  		var rtn;
  		if(val == 0 || val == "") rtn = 1;
  		else rtn = val;
  		return rtn;
  	}

  	function s_office_level_OnChange(){
  		var f = document.form;
  		ComClearCombo(f.s_if_rhq_cd);
  		ComAddComboItem(f.s_if_rhq_cd, "<<Select>>", "");
  		f.s_if_ofc_cd.disabled = false;
  		ComClearCombo(f.s_if_ofc_cd);
  		ComAddComboItem(f.s_if_ofc_cd, "<<Select>>", "");

  		if ( f.s_office_level.value=="H" ) {
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','4');
  		} else if ( f.s_office_level.value=="R" ){
  			getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','2');
  		} 

  	}
