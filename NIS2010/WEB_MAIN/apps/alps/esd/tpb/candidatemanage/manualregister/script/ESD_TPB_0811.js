/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0811.js
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.13 박성진
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
     * @class ESD_TPB_0811 : ESD_TPB_0811 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0811() {
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
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
		
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
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
  		initControl();
  		
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  					style.height = 200;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msNone;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 10);
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(3, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)
  		
  					var HeadTitle = "|Container No.|TP/SZ";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  		
  					//데이터속성	  [ROW,	COL,   DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtCheckBox, 30,    daCenter,  true,     "chk",          false,    "",         dfNone,     0,          true,       true,       1,       false,     false,      "",      true);					
  					InitDataProperty(0, cnt++, dtData,     160,   daCenter,  true,     "cntr_no",      false,    "",         dfNone,     0,          false,      true);
      				InitDataProperty(0, cnt++, dtData,     50,    daCenter,  true,     "cntr_tpsz_cd", false,    "",         dfNone,     0,          false,      true);
  					
  					ColHidden("ibflag") = true;
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
	  			case "btn_save": /// on save button click
		      		var resultArr = new Array();
		      		var k = 0;
		      		for( i=0 ; i<sheetObject.RowCount ; i++ ){
		      			if( sheetObject.CellValue(i+1,'chk') == 1 ){
		      				resultArr[k++] = sheetObject.CellValue(i+1,'cntr_no')
		      							+ "|$|" + sheetObject.CellValue(i+1,'cntr_tpsz_cd');
		      			}
		      		}
		      		window.returnValue = resultArr;
		      		window.close();
		      		break;
//  				case "btn_downexcel":
//  					sheetObject.ExcelPrint = "";
//  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//  					break;
//  				case "bttn_print":
//  					sheetObject.ExcelPrint = "PrintOnly";
//  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//  					break;
//  				case "btn_retrieve":
//  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
//  					break;
  				case "btn_close":
  				    window.returnValue = false;
  				    window.close();
  				    break;
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
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
  				
//  				if(!validateForm(sheetObj,formObj,sAction)) {
//  					return false;
//  				}
  				
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0811GS.do", tpbFrmQryStr(formObj));
  				break;
  		   case IBINSERT:
				var add_row_cnt = document.form.s_add_cnt.value;
				
				// [CSR #2261] Row Add 숫자 입력 칸만큼 loop. null이면 1 (2017.10.19)
				if ( add_row_cnt == "") add_row_cnt = 1;
				for ( var i = 0; i < add_row_cnt; i++) {
					sheetObj.DataInsert(-1);
				}
  			   	break;
  		}
  	}
  	
//  	/**
//  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//  	 */
//  	function validateForm(sheetObj,formObj,sAction){
//  		with(formObj){
//  		   if(!ComChkValid(formObj)) return false;
//  		}
//  		
//  		return true;
//  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		// [CSR #2261] Row Add 버튼 생성으로 기능이 겹쳐서 삭제 (2017.10.19)
  		//sheetObj.DataInsert(-1);
  		//if(errMsg!=null){
  			//ComShowMessage(errMsg);
  		//}
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowCodeMessage('COM12149','Data','','');
  		}

  	}
  	 
  	/**
   	 * IBSheet 가 변경되었을 경우 활성화.
   	 * 
   	 */
   	function sheet1_OnChange(sheetObj, Row, Col, Value){

   		var colNm = sheetObj.ColSaveName(Col);
   		// [CSR #2261] Row Add 버튼 생성으로 기능이 겹쳐서 삭제 (2017.10.19)
   		/*
   		if( colNm == 'chk' ){
   			if( sheetObj.CellValue(Row,'cntr_no').length == 0 
   				&& sheetObj.CellValue(Row,'cntr_tpsz_cd').length == 0 ){
   				if( sheetObj.CellValue(Row,'chk') != '' ){
   					sheetObj.DataInsert();
   				}else{
   					sheetObj.RowDelete(Row, false);
   				}
   			}
   		}
   		 */
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
		}
	}
	/* 개발자 작업  끝 */