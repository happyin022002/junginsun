/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0011.js
*@FileTitle : CSR Creation for Rev.VVD Change
*Open Issues :
*Change history : 2007.05 Kim Jung Jae 최초생성
*@LastModifyDate : 2009.10.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.10.28 전재홍
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
     * @class ESD_LEA_0011 : ESD_LEA_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0011() {
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
  var ipageNo =1 ;

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
  	 * comSheetObject(id)에서 호출한다
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
  		 var sheetObj = sheetObjects[0];
           var formObj = document.form;

          for(i=0;i<sheetObjects.length;i++){
          
          //khlee-시작 환경 설정 함수 이름 변경
              ComConfigSheet(sheetObjects[i]);

              initSheet(sheetObjects[i],i+1);
          //khlee-마지막 환경 설정 함수 추가
              ComEndConfigSheet(sheetObjects[i]);            
          }
  	}

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					style.height = GetSheetHeight(13) ;
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9, 50);
  					
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(23, 3, 0, true);
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, false, true, false,false);

                      var HeadTitle  = "Seq|SEL|SEL|CSR No.|Source|BKG #|Rev.VVD(old)|Rev.VVD(old)|Rev.Month|Rev.Month|New\nCSR Creation|I/F Status|I/F Status|New CSR No.|||||||||" ;
                      var HeadTitle1 = "Seq|SEL|SEL|CSR No.|Source|BKG #|Old|New|Old|New|New\nCSR Creation|ERP|LEA|New CSR No.|||||||||" ;
                      
                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);
                      InitHeadRow(1, HeadTitle1, true);
                      
  					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0,	cnt++,		   dtDataSeq,	30,	daRight,    true);
  					InitDataProperty(0,	cnt++,		  dtCheckBox,	30,	daCenter,	true,     "",        			false,       "",     dfNone,     	 0,    true,      true);
  					InitDataProperty(0,	cnt++,	  dtHiddenStatus,	40,	daCenter,	false,	  "ibflg",   			false,       "",     dfNone,         0,    true,      true);
  					InitDataProperty(0,	cnt++,			  dtData,  130,	daCenter,	true,	  "csr_no",	   			false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	60,	daCenter,	true,	  "inv_sys_id",	   		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData, 100,daCenter,	true,	  "bkg_no",	  			false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	80,	daCenter,	true,	  "old_vvd_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	80,	daCenter,	true,	  "new_vvd_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,			  dtData,	60,	daCenter,	true,	  "old_rev_yrmon",		false,		 "",	 dfDateYmd,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	60,	daCenter,	true,	  "new_rev_yrmon",		false,		 "",	 dfDateYmd,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);
  					InitDataProperty(0,	cnt++,   		  dtData,	90,	daCenter,	true,	  "modi_csr_cre_flg",	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,	30,	daCenter,	true,	  "erp_if_flg",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,	30,	daCenter,	true,	  "lea_if_flg",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtData,  130,	daCenter,	true,	  "modi_csr_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);					
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "exe_yrmon",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);						
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_vsl_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_skd_voy_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_skd_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "old_rev_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_vsl_cd",	  		false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_skd_voy_no",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_skd_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					InitDataProperty(0,	cnt++,   		  dtHidden,	5,	daCenter,	true,	  "new_rev_dir_cd",	  	false,		 "",	 dfNone,		 0,	   false,	  true,	  400,	 false,	 true,	   "",	  false);	
  					
  					style.height = 260 ;
  					
  					CountFormat = "[BOTTOMDATA / TOTALROWS]"
  				}
  				break;
  				
  			case 2:      //IBSheet1 init
                  with (sheetObj) {
                      //전체 너비 설정
                      SheetWidth = mainTable.clientWidth;

                      //Host정보 설정[필수][HostIp, Port, PagePath]
                      if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                      //전체Merge 종류 [선택, Default msNone]
                      MergeSheet = msHeaderOnly;

                      //전체Edit 허용 여부 [선택, Default false]
                      Editable = true;

                      //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                      InitRowInfo( 1, 1, 9, 100);

                      //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                      InitColumnInfo(3, 0, 0, true);

                      //해더에서 처리할 수 있는 각종 기능을 설정한다
                      InitHeadMode(true, true, true, true, false,false)

                      var HeadTitle  = "Exe.Month|CSR No.|BKG No.|";

                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                      InitHeadRow(0, HeadTitle, true);

                      //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "exe_yrmon"         ,        false,          "",       dfDateYm,     	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "csr_no"         ,        false,          "",       dfNone,     	0,     false,       false);
                      InitDataProperty(0, cnt++ , dtData   ,      100,    daCenter,  true,    "bkg_no"           ,        false,          "",       dfNone ,     	0,     false,       false);
                     
                      
                      style.height = GetSheetHeight(13) ;
                 }
                  break;
               
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[0];
  		 var sheetObject1 = sheetObjects[1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			/***********************************************************************************************************
  				이미지 클릭 이벤트 처리, popup도 역시 이곳에서 함
  				공통코드: CoFormControl.js 에 정의 되어있습니다. 이 변수를 통하여 ServiceCommand에서 분기 합니다.		
  			 **********************************************************************************************************/
  			/*
  				이곳에 document.form 혹은 document.form[0]식으로 코딩하시는 것을 삼가해 주십시오.
  				메뉴가 적용되면 left_menu.jsp에 form 이 존재할 것이기 때문에 더이상 form[0]이 아닙니다.
  				(순서상도 form[1]이 되겠죠?) 
  				그리고 위에서 with(document.form)라고 했기때문에 (브라우저의 DOM 객체중 특정부분만 잡는다는 의미니깐!)
  				document.form.f_cmd.value = INSERT;   이런식의 코딩은 지양해주십시오.
  			*/
  			switch(srcName) {
  				case "btn_retrieve":
  					sheetObject.RemoveAll();
  					doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  						break;
  				case "btng_newcsrcreation":
  					doActionIBSheet(sheetObject,formObject,IBBATCH);
  						break;
  				case "btng_downexcel":
//  						lea_form2sheet(formObject,sheetObject1);
//              		sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//  					sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
  					sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
  						break;				
  			} // end switch
  		}catch(e) {			
  			/*
  				자바 스크립트 에러가 발생할시 오동작이 납니다. 고객에게 이 경우 아래의 메세지가 뿌려지게 해야합니다.
  				물론 화면에서 다음의 메세지를 보시면 무조건 '자바스크립트 에러구나'라고 확인하실수 가 있습니다.
  			*/
  			if( e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction,isAppend,PageNo) {
  	var formObject = document.form;
  	
  	var sheetObj = sheetObjects[0];
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  		   case IBSEARCH:	  //조회
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				if(PageNo != null){
                      formObject.iPage.value= PageNo;
                  }
  				formObject.f_cmd.value = SEARCH;
				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0011GS.do", FormQueryString(formObject));
			   // ComShowMessage(searchXml);
			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
			    //sheetObj.DoSearch4Post("ESD_LEA_0011GS.do", FormQueryString(formObject),"iPage=" + PageNo, isAppend);
  				break;
  			case IBSAVE:		//저장
  				
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  				
  				formObj.f_cmd.value = MULTI;
  				sheetObj.DoSave("com.hanjin.apps.prototype.prototype1Search.do", FormQueryString(formObj));
  				break;
  			case IBINSERT:	  //입력
  				var Row = sheetObj.DataInsert();
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBBATCH: 
  				var sRow = sheetObj.FindCheckedRow(1);
  				var arrRow = sRow.split("|");
  				
    				for (idx=0; idx<arrRow.length-1; idx++){ 
//    					ComShowMessage(arrRow[idx]); 
    					formObj.f_cmd.value = MULTI01;
    					formObj.Row.value = arrRow[idx];
  //ComShowMessage(sheetObj.RowSaveStr(arrRow[idx])+"&Row="+arrRow[idx]+"&"+FormQueryString(formObj));  					
//  					sheetObj.DoRowSearch("ESD_LEA_0011GS.do", sheetObj.RowSaveStr(arrRow[idx])+"&Row="+arrRow[idx]+"&"+FormQueryString(formObj), false);	
  					var sXml = sheetObj.GetSearchXml("ESD_LEA_0011GS.do", sheetObj.RowSaveStr(arrRow[idx])+"&Row="+arrRow[idx]+"&"+FormQueryString(formObj));
  					//ComShowMessage(sXml); 
  					sheetObj.LoadSearchXml(sXml,true, arrRow[idx], true);
    				}
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
  			//if (!isNumber(formObj.iPage)) {
  			//	return false;
  		   // }
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 이벤트
  	 */
  	 
  	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows){
          var formObj = document.form ;
          formObj.f_cmd.value = SEARCH;
          doActionIBSheet(sheetObjects[0], FormQueryString(formObj), IBSEARCH, true, PageNo);
      }
      
   
  	/**
       * EnterKey Event 조회 프로세스 처리
       */
  	function lea_enterRetrieve(){
      	var sheetObject = sheetObjects[0];
          var formObject = document.form;
  		sheetObject.RemoveAll();
   		doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  	}
  	
  	/**
       * Page Loading Event 조회 프로세스 처리
       */
  	function lea_load_page(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH,false,1);
  	}
  		
  	/**
       * Form Data를Sheet로 Copy 프로세스 처리
       */
  	function lea_form2sheet(formObj,sheetObj){
  		sheetObj.RemoveAll();
  		var Row = sheetObj.DataInsert();
  		
  		sheetObj.CellValue2(Row , "exe_yrmon" ) = formObj.frm_exe_yrmon.value;
  		sheetObj.CellValue2(Row , "csr_no" ) = formObj.frm_csr_no.value;
  		sheetObj.CellValue2(Row , "bkg_no"   ) = formObj.frm_bkg_no.value;

  		}
  		
  	/**
       * New CSR 생성시에는 체크 안되게 처리
       */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){
  	var sheetObj = sheetObjects[0];
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  		var formObject = document.form;
  		var row = formObject.Row.value;
  		
  		sheetObj.CheckAll(1) = 0;
  		var e = window.event;
  		
  		if(e != null){
  			var src_em = window.event.srcElement;
  			if(src_em != null){
  				var srcName = window.event.srcElement.getAttribute("name");
  			}
  			
  		}
  			for(i=0; i<=sheetObj.RowCount; i++){
  				var modi_csr_cre_flg = sheetObj.CellValue(i,'modi_csr_cre_flg');
  				var erp_if_flg = sheetObj.CellValue(i,'erp_if_flg');
  				var lea_if_flg = sheetObj.CellValue(i,'lea_if_flg');
  				if(modi_csr_cre_flg == "Y" && erp_if_flg == "Y" && lea_if_flg =="Y"){					
  					sheetObj.RowEditable(i)=false;
  					if(e != null && srcName == "btng_newcsrcreation" && i==row){
  						sheetObj.RowBackColor(i)=sheetObj.RgbColor(189,228,245);
  					}
  				}
  			}
  	}
  	
  		
  	/**
       * New CSR No.를 Double Click 시 해당 시스템의 CSR 조회 화면을 호출함(TRS, TES)
       */		
  	function sheet1_OnDblClick(sheet1, row, col){
  		if(col==3 || col==13){ //CSR No, New CSR No Column
  			var csr_no = sheet1.cellValue(row, col);
  			var inv_sys_id = sheet1.cellValue(row, 4); //TRS, TES
  		
  			if (inv_sys_id == "TRS") {
  				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
  			} else if (inv_sys_id == "TES"){
     				window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:800px; help:no; status:no; resizable:yes;");
     				//window.open("http://"+host+"/hanjin/ESD_TES_100.do?READONLY_YN=Y&CSR_NO=" + csr_no);   				
  			}
  		}
  	}
  	
  	


	/* 개발자 작업  끝 */