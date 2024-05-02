/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TPB_0133.js
*@FileTitle : S/O Cancelation Notice
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-16
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2009-07-30 O Wan-Ki 			1.0	 최초 생성
* 2009-09-16 Jong-Geon Byeon	1.1 ALPS Migration
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
     * @class ESD_TPB_0133 : ESD_TPB_0133 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0133() {
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
  		
  		/**
  		 * Heirarchy 구조를 위한 기본 설정.<br>
  		 * 접속한 유저의 권한을 판단하여 Hierachy 구조를 변경하는 부분.<br> 
  		 */
  		document.form.s_office_level.value = "H"; //Head Office - Heirarchy 권한부여 

  		func_rhq_ctrl_ofc_list('1');
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
  					
  					//ShowMsgMode = false;
  					
  					// 높이 설정
  					style.height = 450;
  										
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;

  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;

  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;

  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 10);

  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(15, 2, 0, true);

  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, true, true, false, false)

  					//--- 1. Status 
  					var HeadTitle1 = "DEL|STS|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|Canceled S/O Details|TPB Details|TPB Details|TPB Details|TPB Details|org_seq|cxl_seq|TPB No.|Removable";
  					var HeadTitle2 = "DEL|STS|Office|S/O Number|Amount(USD)|Initial I/F Date|Canceled Date|Status|Confirm(USD)|Invoice(USD)|Group|org_seq|cxl_seq|TPB No.|Removable";

  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle1, true);
  					InitHeadRow(1, HeadTitle2, true);
  					
  				
  					//              [ROW ,COL	  ,DATATYPE     ,WIDTH ,DATAALIGN ,COLMERGE ,SAVENAME                 ,KEYFIELD ,CALCULOGIC ,DATAFORMAT ,POINTCOUNT ,UPDATEEDIT ,INSERTEDIT ,EDITLEN ,FULLINPUT ,SORTENABLE ,TOOLTIP ,ALLCHECK ,SAVESTATUS ,FORMATFIX]
  					InitDataProperty(0   ,cnt++   ,dtCheckBox   ,30    ,daCenter  ,true     ,"chk_del"                ,false    ,""         ,dfNone     ,0          ,false      ,false      ,1       ,false     ,false      ,""      ,false );
  					InitDataProperty(0   ,cnt++   ,dtStatus     ,50    ,daCenter  ,true     ,"ibflag" );
  					InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"ofc_cd"                 ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daCenter  ,true     ,"so_no"                  ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daRight   ,true     ,"if_amt_usd"             ,false    ,""         ,dfFloat    ,2          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,110   ,daCenter  ,true     ,"org_if_dt"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,110   ,daCenter  ,true     ,"cxl_if_dt"              ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,120   ,daCenter  ,true     ,"ots_sts"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daRight   ,true     ,"ots_amt_usd"            ,false    ,""         ,dfFloat    ,2          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,90    ,daRight   ,true     ,"inv_amt_usd"            ,false    ,""         ,dfFloat    ,2          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,60    ,daCenter  ,true     ,"grp_flg"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"org_seq"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,70    ,daCenter  ,true     ,"cxl_seq"                ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,100   ,daCenter  ,true     ,"n3pty_no"               ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					InitDataProperty(0   ,cnt++   ,dtData       ,30    ,daCenter  ,true     ,"editable"               ,false    ,""         ,dfNone     ,0          ,false      ,true       );
  					
  					ColHidden("ibflag") = true;
  					ColHidden("org_seq") = true;
  					ColHidden("cxl_seq") = true;
  					//ColHidden("n3pty_no") = true;
  					ColHidden("editable") = true;
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
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;
  				case "btn_downexcel": 
  					sheetObject.ExcelPrint = "";
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;
  				case "btn_tonontpb":
  					document.form.s_isNoticeOnly.value = 0;
  					accessAfterConfirmMsg(0,COMMAND01);
  					break;
  				case "btn_eliminate":
  					document.form.s_isNoticeOnly.value = 1;
  					accessAfterConfirmMsg(1,COMMAND01);
  					break;	
  				
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('TPB90014'));
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
  				sheetObj.DoSearch4Post("ESD_TPB_0133GS.do", tpbFrmQryStr(formObj));
  				break;
  				
  				
  			case COMMAND01: //cancelation
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				for( var i=2 ; i<sheetObj.RowCount+2 ; i++ ){
  					if( sheetObj.CellValue(i,"chk_del") == "1" ){
  						if( document.form.s_isNoticeOnly.value == "0" ){ // Delete All
  							if( sheetObj.CellValue(i,"org_seq") == "" || sheetObj.CellValue(i,"cxl_seq") == "" ){ 
  								ComShowCodeMessage('TPB90083',i-1);
  								return;
  							}
  						}else if(document.form.s_isNoticeOnly.value == "1" ){ // Delete Cancel Flag Only
  							if( sheetObj.CellValue(i,"cxl_seq") == "" ){
  								ComShowCodeMessage('TPB90084');
  							}					
  						}
  					}
  				}

  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("ESD_TPB_0133GS.do", tpbFrmQryStr(formObj));
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
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  		
  		for( var i=2 ; i<sheetObj.RowCount+2 ; i++ ){
  			if( sheetObj.CellValue(i,"editable") == "Y" 
  				&& sheetObj.CellValue(i,"grp_flg") == "N" 
  				&& sheetObj.CellValue(i,"ofc_cd") == document.form.s_ofc_cd_for_rhq.value){
  				sheetObj.CellEditable(i,"chk_del") = true;
  			}
  		}
  	}

  	
  	/**
  	 * accessAfterConfrimMsg <br> 
  	 * 
  	 */
  	function accessAfterConfirmMsg(flg,cmd){
  		
  		var k=0;
  		for( var i=2 ; i<sheetObjects[0].RowCount+2 ; i++ ){
  			if( sheetObjects[0].CellValue(i,"chk_del") == "1" ) k++; 
  		}
  		if( k == 0 ) return;
  		
  		
  		
  		var result = '';
  				
  		if( flg == 0 ){
  			result = ComShowConfirm(msgs['TPB90066']);
  		}else if( flg == 1){
  			result = ComShowConfirm(msgs['TPB90067']);
  		}
  		 
  		if(result) {
  			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
  		}
  		
  		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  	}
	/* 개발자 작업  끝 */