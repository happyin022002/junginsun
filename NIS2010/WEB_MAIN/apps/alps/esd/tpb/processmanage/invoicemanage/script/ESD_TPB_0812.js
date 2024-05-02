/*=========================================================
*Copyright(c) Since 2009 CyberLogitec
*@FileName : ESD_TPB_0812.js
*@FileTitle : Taxation Control
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : Park Sung-Jin
*@LastVersion : 1.2
* 2009-06-01 O Wan-Ki 1.0 최초 생성 - [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-08-12 O Wan-Ki 1.1 ALPS 최초생성
* 2009-09-28 Park Sung-Jin 1.2 ALPS Migration
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
     * @class ESD_TPB_0812 : ESD_TPB_0812 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0812() {
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
    var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var rowForCorrection = 0;
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
  		if( document.form.s_cnt_cd.value != 'IN' ){
  			document.getElementById("btn_save_t").style.display = "none";
  			document.getElementById("btn_add_t").style.display = "none";
  		}
  	
  		getTPBGenCombo("s_ofc_cd","searchHierarchyOfficeByCountry","F","","1", new Array("s_ofc_grd","s_cnt_cd"));
  		document.form.s_calendar_date1.value = ComGetDateAdd(null, "D", 0, "-");
  		
  		for(i=0;i<sheetObjects.length;i++){
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        window.onunload = InitWinTopPendingTPBWin; 
  	}

  	 function InitWinTopPendingTPBWin(){
          try {
              Set_Cookie( "PendingTPBWin", "N", 1, "", "", "" )
          } catch(e){}
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
  					style.height = 390;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;//msAll;

  				   //전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(19, 0, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)

  					var HeadTitle = "Status|Del.|Seq.|ida_tax_seq|Office|Effective Date|Service\nTax(%)|Edu. Cess\n of S.Tax(%)|Higher Edu. Cess\n of S.Tax(%)|Swachh\nBharat Cess(%)|Krishi\nKalyan Cess(%)|Registration No.|Service Category|PAN No.|cre_usr_id|cre_dt|Create ID|Create Date"; 

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//              [ROW ,COL	  ,DATATYPE      ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME                 ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
					//InitDataProperty(0,  ,cnt++   ,dtHiddenStatus,100   ,daCenter  ,false    ,"ib_flag"                ,false    ,""         ,dfNone     ,0          ,false      ,true);
					InitDataProperty(0   ,cnt++   ,dtStatus      ,50    ,daCenter  ,true     ,"ibflag" );
					InitDataProperty(0   ,cnt++   ,dtDelCheck    ,30    ,daCenter  ,true     ,"upd_chk"                ,false    ,""         ,dfNone     ,0          ,true       ,true       ,1       ,false     ,false      ,""      ,false );
					InitDataProperty(0   ,cnt++   ,dtSeq         ,40    ,daCenter  ,true     ,"" );
					InitDataProperty(0   ,cnt++   ,dtHidden      ,50    ,daLeft    ,true     ,"ida_tax_seq"            ,true     ,""         ,dfNone     ,0          ,false     ,false     );
					InitDataProperty(0   ,cnt++   ,dtHidden      ,70    ,daCenter  ,true     ,"ofc_cd"                 ,false    ,""         ,dfNone     ,0          ,false     ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,100   ,daCenter  ,true     ,"eff_dt"                 ,true     ,""         ,dfDateYmd  ,0          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,80    ,daRight   ,true     ,"expn_tax"               ,true     ,""         ,dfInteger  ,0          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,90    ,daRight   ,true     ,"edu_tax"                ,true     ,""         ,dfInteger  ,0          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,120   ,daRight   ,true     ,"high_edu_tax"           ,true     ,""         ,dfInteger  ,0          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,120   ,daRight   ,true     ,"locl_tax_rt"            ,true     ,""         ,dfFloat    ,2          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,120   ,daRight   ,true     ,"n2nd_locl_tax_rt"            ,true     ,""         ,dfFloat    ,2          ,true      ,true      );
					InitDataProperty(0   ,cnt++   ,dtData        ,130   ,daLeft    ,true     ,"tax_rgst_no"            ,false    ,""         ,dfNone     ,0          ,true      ,true      ,25);
					InitDataProperty(0   ,cnt++   ,dtData        ,130   ,daLeft    ,true     ,"svc_cate_rmk"           ,false    ,""         ,dfNone     ,0          ,true      ,true      ,50);
					InitDataProperty(0   ,cnt++   ,dtData        ,130   ,daLeft    ,true     ,"pmnt_acct_no"           ,false    ,""         ,dfNone     ,0          ,true      ,true      ,50);
					InitDataProperty(0   ,cnt++   ,dtData        ,90    ,daCenter  ,true     ,"cre_usr_id"             ,false    ,""         ,dfNone     ,0          ,false     ,false     );
					InitDataProperty(0   ,cnt++   ,dtData        ,100   ,daCenter  ,true     ,"cre_dt"                 ,false    ,""         ,dfNone     ,0          ,false     ,false     );
					InitDataProperty(0   ,cnt++   ,dtData        ,90    ,daCenter  ,true     ,"upd_usr_id"             ,false    ,""         ,dfNone     ,0          ,false     ,false     );
					InitDataProperty(0   ,cnt++   ,dtData        ,100   ,daCenter  ,true     ,"upd_dt"                 ,false    ,""         ,dfNone     ,0          ,false     ,false     );
					InitDataProperty(0   ,cnt++   ,dtHidden      ,100   ,daCenter  ,true     ,"editable"               ,false    ,""         ,dfNone     ,0          ,false     ,false     );
					
  					ColHidden("cre_usr_id") = true;
  					ColHidden("cre_dt") = true;
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
  				case "btn_add":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;
  				case "btn_save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,COMMAND01);
  					break;
  				case "btn_reset":
  					//formObject.Reset();
  					document.form.s_ofc_cd.value = '';
  					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  					break;
  				case "btns_calendar1": 
  					var cal = new ComCalendar();
  					cal.select(formObject.s_calendar_date1, 'yyyy-MM-dd');
  					break;
  				case "btn_close":
      				InitWinTopPendingTPBWin();
  					window.close();
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
  				sheetObj.DoSearch4Post("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj));
  				break;

  			case COMMAND01:	  //Effective Date에 의한 조회.
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				formObj.f_cmd.value = SEARCH01;
  				sheetObj.DoSearch4Post("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj));
  				break;

  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;

  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;

  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert(-1);
  				break;
  				
  			case IBSAVE:	  //입력
  				if( document.form.s_cnt_cd.value != 'IN') return;
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0812GS.do", tpbFrmQryStr(formObj));
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  			if(sheetObj.CellValue(i,"editable")>0){
  				sheetObj.RowEditable(i) = false;
  			}
  		}
  	}
  	
  	function sheet1_OnChange(sheetObj,Row,Col,Value){
		if( sheetObj.ColSaveName(Col) != "svc_cate_rmk" && sheetObj.ColSaveName(Col) != "upd_chk" ){
			if ( sheetObj.CellValue(Row,Col).value != null && sheetObj.CellValue(Row,Col) != 'undefind' ) {
				sheetObj.CellValue(Row,Col) = ComTrim(sheetObj.CellValue(Row,Col).value.toUpperCase());
			}
		}
		
		if( sheetObj.ColSaveName(Col) == "expn_tax" || sheetObj.ColSaveName(Col) == "edu_tax" || sheetObj.ColSaveName(Col) == "high_edu_tax" ){
			if(sheetObj.CellValue(Row,Col) > 100){
				var headText = sheetObj.CellText(0, Col)
				headText = ComReplaceStr(headText, "\n", " ");        
				ComShowCodeMessage('TPB90032',headText,"100");
				sheetObj.ReturnCellData(Row,Col);
			}
		}
		for ( var i = 1; i <= sheetObj.RowCount; i++ ){
			if( Row != i ){
				if(sheetObj.CellValue(Row,"eff_dt") == sheetObj.CellValue(i,"eff_dt") && sheetObj.CellValue(Row,"eff_dt") != ''){
					ComShowCodeMessage('TPB90099')
					sheetObj.CellValue2(Row,"eff_dt") = '';
				}
			}
		}
	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		
  	}
	/* 개발자 작업  끝 */