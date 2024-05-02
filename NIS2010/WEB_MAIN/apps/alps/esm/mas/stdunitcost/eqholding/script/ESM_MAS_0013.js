/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0013.js
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
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
     * @class ESM_MAS_0013 : ESM_MAS_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0013() {
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
  var tabObjects = new Array();
  var tabCnt = 0;
  var tab_no = 0;
  var tab_no2 = 0;
  var beforetab = 1;
  var tabItem = 0;
    
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var comboObjects = new Array(); // IB Combo 쓰기 위해서 변수 선언 
  var comboCnt = 0;
  var loadingMode = false;
  
  /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  	function processButtonClick(){
  		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		var sheetObject = sheetObjects[0];
  		var sheetObject1 = sheetObjects[1];
  		var sheetObject2 = sheetObjects[2];

  		var formObject = document.form;

  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {

  			case "btn_retrieve":
                if (tabItem == 0) {   
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    			} else if (tabItem == 1){        				
  					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);
  				}
  				break;

  			case "btn_downexcel":
                if (tabItem == 0) {   
                	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                	doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);
    			} else if (tabItem == 1){        				
                	doActionIBSheet3(sheetObject2,formObject,IBDOWNEXCEL);
    			}      
  				break;

  			case "btn_save":	
  			  if (tabItem == 0) {  
  			      //doActionIBSheet(sheetObject,formObject,IBSAVE);
              } else if (tabItem == 1){
                  doActionIBSheet3(sheetObject2,formObject,IBSAVE);
              }   
  				
  			break;
			case "btn_Month_Copy":		//팝업창(Month Copy)
     	       var display = "0,1";
     	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0013", 250, 200, "AverageUcCopy", display, true, false);
     	    break;	
 			} // end switch
  		} catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(ComGetMsg(OBJECT_ERROR));
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
  		var formObj = document.form;
		if( formObj.v_ofc_cd.value != "SELCSG" && formObj.v_ofc_cd.value != "SELAPM" && formObj.v_ofc_cd.value != "SELOPB"
		    && formObj.v_ofc_cd.value != "SELCON"){
			ComSetDisplay("btn_Savecon",false);		    			
		}
		
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// 멀티콤보 처리
		// ---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
		loadingMode = false;

		for (k = 0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
		}
  	}
  	
  	/**
   	 * IBTab Object를 배열로 등록
   	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
   	 * 배열은 소스 상단에 정의
   	 */
   	function setTabObject(tab_obj) {
   		tabObjects[tabCnt++] = tab_obj;

   	}
   	 
   	/**
   	 * Tab 기본 설정
   	 * 탭의 항목을 설정한다.
   	 */
   	function initTab(tabObj, tabNo) {
   		switch (tabNo) {
   		case 1:
   			with (tabObj) {
   	            var cnt  = 0 ;
   	            InsertTab( cnt++ , "EQ Using Days" , -1 );
   	            InsertTab( cnt++ , "Unit Cost Summary" , -1 );
   			}   			
   			break;

   		}
   	}
   	
   	/**
   	 * Tab 변경시 이벤트 관련
   	 * 선택한 탭의 정보를 조회.
   	 */
   	function tab1_OnChange(tabObj, nItem) {
   		var objs = document.all.item("tabLayer");
   		
   		objs[nItem].style.display = "Inline";
   		objs[beforetab].style.display = "none";

   		tabItem = nItem;

   		document.form.tab_item.value = tabItem;   		

   		// --------------- 요기가 중요 --------------------------//
   		objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
   		// ------------------------------------------------------//
   		beforetab = nItem;   		
   	}

  	/**
  	* 시트 초기설정값, 헤더 정의
  	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	*/
  	function initSheet(sheetObj,sheetNo) {
  		var cnt = 0;

  		switch(sheetNo) {
  			case 1:		//sheet2 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(13, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "|Cost Yrmon|TPSZ|Full Total|Full Sea|Origin Rail|Dest Rail|Full DMT|MT Land|Sub Total|Box|Avg Days|MT SeaDay"
  					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//  					InitDataProperty(0, cnt++ , dtDelCheck,	30,		daCenter,	false,	"");
  					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	false,	"cost_yrmon",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	false,	"tpsz_cd",					false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,	daRight,		false,	"ttl_dys",				false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,	"sea_dys",				false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,	daRight,		false,	"org_rail_dys",	false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,	false,	"dest_rail_dys",			false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		false,	"full_dmt",		false,	"",		dfInteger,	3,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		false,	"mt_land",					false,	"",		dfInteger,	0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		false,	"sub_tot",					false,	"",		dfInteger,	0,	false,		false);
  					InitDataProperty(0, cnt++ , dtAutoSum,		80,		daRight,		false,	"box_cnt",					false,	"",		dfInteger,	0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,		false,	"avg_dys",				false,	"",	 	dfFloat,	2,	false,	 	false);
  					InitDataProperty(0, cnt++ , dtData,		50,		daRight,	false,	"mt_sea_dys",			false,	"",		dfInteger,		2,	false,		false);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(10) ;
  				}
  				break;
  			case 2:	//sheet2 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(16, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "|||TPSZ|Full Total|Full Sea|Origin Rail|Dest Rail|Full DMT|MT Land|Sub Total|Avg Days|MT SeaDay|DAY a\n(Full Land)|DAY b\n(Full Sea/Rail\n+ MT Sea/Land)|DAY c\n(Full Sea/Rail\n+ MT Land)"
  					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

  					//데이터속성	    [ROW, COL,	DATATYPE,	WIDTH,      DATAALIGN, COLMERGE, SAVENAME,	          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"cost_yrmon",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	false,	"",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"tpsz_cd",					false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,		false,	"ttl_dys",				false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"sea_dys",				false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,		false,	"org_rail_dys",	false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,	false,	"dest_rail_dys",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,		false,	"full_dmt",		false,	"",		dfFloat,	2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,		false,	"mt_land",					false,	"",		dfFloat,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,		false,	"sub_tot",					false,	"",		dfFloat,	2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daRight,		false,	"avg_dys",				false,	"",	 	dfFloat,	2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,	"mt_sea_dys",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,	"day_a",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		110,		daRight,	false,	"day_b",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"day_c",			false,	"",		dfFloat,		2,	false,		false);
  					

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(10) ;
  					
  					MessageText("Avg") =""; 
  					MessageText("Sum") =""; 
  					SumText(0,1) = "";

  				}
  				break;
  			case 3:	//sheet2 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(16, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "STS|Cost Yrmon|TPSZ|Account Code|Account Code|Box|Cost|Day-a\n(Full Land)|Day-b\n(Full Sea/Rail\n+ MT Sea/Land)|Day-c\n(Full Sea/Rail\n+ MT Land)|Day-a(%)\n(Full Land)" +
  							"|Day-b(%)\n(Full Sea/Rail\n+ MT Sea/Land)|Day-a Cost\n(Full Land)|Day-b Cost\n(Full Sea/Rail\n+ MT Sea/Land)|PDM\n(Full Land)|PDM\n(Full Sea/Rail\n+ MT Land)"
  					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

  					//데이터속성	    [ROW, COL,	DATATYPE,	WIDTH,      DATAALIGN, COLMERGE, SAVENAME,	          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtStatus,		30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   false,  "cost_yrmon",               false,  "",     dfNone,     0,  false,      false);
  					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"tpsz_cd",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,	false,	"acct_nm",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"acct_cd",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,	"box_cnt",				false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,	"ttl_cost_amt",				false,	"",		dfInteger,		0,	true,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,		false,	"day_a",	false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		100,		daRight,	false,	"day_b",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"day_c",			false,	"",		dfFloat,		2,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,		false,	"day_a_pct",	false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		100,		daRight,		false,	"day_b_pct",					false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,		false,	"day_a_cost",					false,	"",		dfInteger,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		100,		daRight,		false,	"day_b_cost",				false,	"",	 	dfInteger,		0,	false,	 	false);
  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,	"pdm_a",			false,	"",		dfFloat,		3,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"pdm_c",			false,	"",		dfFloat,		3,	false,		false);
  					

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(18) ;
  					
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
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 500;
	    	 comboObj.InsertItem(0, 'All' ,'');
	    	 Index = 0;
    	 }
     }

  	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
  		sheetObj.ShowSubSum( "tpsz_cd", "ttl_dys|sea_dys|org_rail_dys|dest_rail_dys|full_dmt|mt_land|sub_tot|box_cnt", -1, true, false, 2, "tpsz_cd=S.TOTAL;avg_dys=|sub_tot|/|box_cnt|;mt_sea_dys=90-(|sub_tot|/|box_cnt|)" );		
  		
  		sheetObj.SumValue(0, "avg_dys") = sheetObj.SumValue(0,"sub_tot") / sheetObj.SumValue(0,"box_cnt");
  		sheetObj.SumValue(0, "mt_sea_dys") = 90 - (sheetObj.SumValue(0,"sub_tot") / sheetObj.SumValue(0,"box_cnt"));
  	}

  	function sheet2_OnSearchEnd(sheetObj,ErrMsg){
  		sheetObj.SumText(0,1) = "";
  		sheetObj.SumText(0,3) = "Total" ;
  	}

  	function sheet3_OnSearchEnd(sheetObj,ErrMsg){
  		sheetObj.ShowSubSum( "tpsz_cd", "ttl_cost_amt|day_a_cost|day_b_cost|pdm_a|pdm_c", -1, true, false, 2, "acct_nm=S.TOTAL" );
  	}

  	function sheet1_OnChange(sheetObj, Row,Col,Value) {
  	    /*
  		var sName = sheetObj.ColSaveName(Col);
  		if(sName == "eq_bx_knt") {
  			//cntr_tpsz_cd별로 같은값을 setting해준다.
  			var sValue = sheetObj.CellValue(Row,"eq_bx_knt");
  			var row1 = 0;
  			for(var k=0; k<sheetObj.RowCount; k++){
  				row1 = sheetObj.FindText("eq_tpsz_cd", sheetObj.CellValue(Row,"eq_tpsz_cd"), k);
  				sheetObj.CellValue2(row1, "eq_bx_knt") = sValue;
  				if(row1>k) k = row1;
  			}
  			//해당 row의 PDM값을 다시 계산해서 setting
  			sheetObj.CellValue2(Row, "chss_hld_uc_amt") =
  				sheetObj.CellValue(Row,"ttl_hld_amt")/(sheetObj.CellValue(Row,"eq_bx_knt")*sheetObj.CellValue(Row,"eq_hld_dys"));
  		} else if(sName == 'ttl_hld_amt' || sName == 'eq_hld_dys'){
  			//해당 row의 PDM값을 다시 계산해서 setting
  			sheetObj.CellValue2(Row, "chss_hld_uc_amt") =
  			sheetObj.CellValue(Row,"ttl_hld_amt")/(sheetObj.CellValue(Row,"eq_bx_knt")*sheetObj.CellValue(Row,"eq_hld_dys"));
  		}

  		sheetObj.SumText(0,1) = "";
  		*/

  	}

  	function sheet2_OnChange(sheetObj, Row,Col,Value) {
  	    /*
  		var sName = sheetObj.ColSaveName(Col);
  		if ( sName == "chss_usa_qty") {
  			sheetObj.CellValue2(Row, "chss_hld_uc_amt") = sheetObj.CellValue(Row,"ttl_hld_amt")/Value;
  		} else if( sName== "ttl_hld_amt"){
  			sheetObj.CellValue2(Row, "chss_hld_uc_amt") = Value/sheetObj.CellValue(Row,"chss_usa_qty");
  		}

  		sheetObjects[1].SumText(0,1) = "";
  		*/

  	}

  	function sheet3_OnChange(sheetObj, Row,Col,Value) {
        var sName = sheetObj.ColSaveName(Col);
        if(sName == "ttl_cost_amt") {
            //해당 row의 PDM값 등을 다시 계산해서 setting
            var day_a_cost = Math.round(parseInt(sheetObj.CellValue(Row, "ttl_cost_amt")) * parseFloat(sheetObj.CellValue(Row, "day_a")) 
                                 / (parseFloat(sheetObj.CellValue(Row, "day_a")) + parseFloat(sheetObj.CellValue(Row, "day_b"))));
            var day_b_cost = Math.round(parseInt(sheetObj.CellValue(Row, "ttl_cost_amt")) * parseFloat(sheetObj.CellValue(Row, "day_b"))
                    / (parseFloat(sheetObj.CellValue(Row, "day_a")) + parseFloat(sheetObj.CellValue(Row, "day_b"))));
            
            sheetObj.CellValue2(Row, "day_a_cost") = day_a_cost;
            sheetObj.CellValue2(Row, "day_b_cost") = day_b_cost;
            sheetObj.CellValue2(Row, "pdm_a") =
                Math.round(day_a_cost / parseInt(sheetObj.CellValue(Row, "box_cnt")) / parseFloat(sheetObj.CellValue(Row, "day_a")) * 1000.0) / 1000.0;
            sheetObj.CellValue2(Row, "pdm_c") =
                Math.round(day_b_cost / parseInt(sheetObj.CellValue(Row, "box_cnt")) / parseFloat(sheetObj.CellValue(Row, "day_c")) * 1000.0) / 1000.0;
        }
        sheetObj.ShowSubSum( "tpsz_cd", "ttl_cost_amt|day_a_cost|day_b_cost|pdm_a|pdm_c", -1, true, false, 2, "acct_nm=S.TOTAL" );
  	}
  	
  	function sheet3_OnSearchEnd(sheetObj,ErrMsg){
        sheetObj.ShowSubSum( "tpsz_cd", "ttl_cost_amt|day_a_cost|day_b_cost|pdm_a|pdm_c", -1, true, false, 2, "acct_nm=S.TOTAL" );
    }
  	
  	
 	// radio 버튼 클릭 시 화면 display
  	function LayerView( kind ){
  		if ( kind == "1" ){
  			document.getElementById("RadioLayer").style.display= "inline";
  			document.getElementById("RadioLayer1").style.display= "none";
  		} else if ( kind == "2") {
  			document.getElementById("RadioLayer1").style.display= "inline";
  			document.getElementById("RadioLayer").style.display= "none";
  		}
  		ComSetFocus(document.form.f_cost_yrmon);
  	}

  	// Sheet관련 프로세스 처리
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0013GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_cntr_tpsz_cd, "code", "code");
				
				ComOpenWait(false);
				break;
  			case IBSEARCH://조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCH;
  					sheetObj.DoSearch4Post("ESM_MAS_0013GS.do", masFormQueryString(formObj));
  					ComOpenWait(false);
  				} else {
  					return;
  				}
				doActionIBSheet2(sheetObjects[1],formObj,IBSEARCH);
  				break;

  			case IBSAVE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI;
  					sheetObj.DoSave("ESM_MAS_0013GS.do", masFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  			    
  				break;

  			case IBCOPYROW:	//행 복사
  				sheetObj.DataCopy();
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
  			case IBINSERT:			// 입력
  				sheetObj.DataInsert();
  				break;
 		}
  	}
  	
  	// Sheet관련 프로세스 처리
  	function doActionIBSheet2(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBSEARCH://조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCH01;
  					sheetObj.DoSearch4Post("ESM_MAS_0013GS.do", masFormQueryString(formObj));
  					ComOpenWait(false);
  				}
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
 		}
  	}
  	
  	// Sheet관련 프로세스 처리
  	function doActionIBSheet3(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBSEARCH://조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCH02;
  					sheetObj.DoSearch4Post("ESM_MAS_0013GS.do", masFormQueryString(formObj));
  					ComOpenWait(false);
  				}
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
                
            case IBSAVE://저장
                sheetObj.WaitImageVisible = false;
                ComOpenWait(true);
                formObj.f_cmd.value = MULTI02;
                sheetObj.DoSave("ESM_MAS_0013GS.do", masFormQueryString(formObj));
                ComOpenWait(false);

                break;
 		}
  	}

  	/**
  	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	*/
  	function validateForm(sheetObj,formObj,sAction){
  		var rt = false;
  		if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
  		//} else if(isNull(formObj.f_cntr_tpsz_cd)) {
  		//	ComShowMessage(getMsg('COM12113', 'TP/SZ'));
  		//	setFocus(formObj.f_cntr_tpsz_cd);
  		//	rt = false;
  		} else {
  			rt = true;
  		}
  		return rt;
  	}


	/* 개발자 작업  끝 */