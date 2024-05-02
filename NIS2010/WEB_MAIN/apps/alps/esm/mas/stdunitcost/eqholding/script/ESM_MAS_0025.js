/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0025.js
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
     * @class ESM_MAS_0025 : ESM_MAS_0025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0025() {
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
     
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var NEW_YRMON =  "201707" ;


  var loadingMode = false;
  
  /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  	function processButtonClick(){
  		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  		var sheetObject = sheetObjects[0];
 

  		var formObject = document.form;

  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {

  			case "btn_retrieve": 				
  				doActionIBSheet(sheetObject,formObject,IBSEARCH);
  				break;

  			case "btn_downexcel":
 				
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    		     
  				break;

  			case "btn_save":	
 
               doActionIBSheet(sheetObject,formObject,IBSAVE);
           
  				
  			break;
			case "btn_Month_Copy":		//팝업창(Month Copy)
     	       var display = "0,1";
     	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0025", 250, 200, "AverageUcCopy", display, true, false);
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
//		if( formObj.v_ofc_cd.value != "SELCSG" && formObj.v_ofc_cd.value != "SELAPM" && formObj.v_ofc_cd.value != "SELOPB"){
//			ComSetDisplay("btn_Savecon",false);		    			
//		}
		
  		for(i=0;i<sheetObjects.length;i++){
  			//khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//khlee-마지막 환경 설정 함수 추가
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		loadingMode = true;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
 
		loadingMode = false;
		showHideCols(1);
 
  	}
 

  	/**
  	* 시트 초기설정값, 헤더 정의
  	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	*/
  	function initSheet(sheetObj,sheetNo) {
  		var cnt = 0;
  		switch(sheetNo) {
  
  			case 1:	//sheet1 init
  			  
  				with (sheetObj) {
  			  

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(19, 0, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
                    var HeadTitle = "STS|Cost Yrmon|TPSZ|Account Code|Account Code|Box|EQ Days|Cost|PDM|PDM ADJ"
                            +"|Day-a\n(Full Land)|Day-b\n(Full Sea/Rail\n+ MT Sea/Land)|Day-c\n(Full Sea/Rail\n+ MT Land)|Day-a(%)\n(Full Land)" +
                            "|Day-b(%)\n(Full Sea/Rail\n+ MT Sea/Land)|Day-a Cost\n(Full Land)|Day-b Cost\n(Full Sea/Rail\n+ MT Sea/Land)|PDM\n(Full Land)|PDM\n(Full Sea/Rail\n+ MT Land)";

  					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

  					//데이터속성	    [ROW, COL,	DATATYPE,	WIDTH,      DATAALIGN, COLMERGE, SAVENAME,	          KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtStatus,		30,		daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtData,     80,     daCenter,   false,  "cost_yrmon",               false,  "",     dfNone,     0,  false,      false);
  					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	false,	"tpsz_cd",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		150,	daLeft,	false,	"acct_nm",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	false,	"acct_cd",				false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,		false,	"box_cnt",				false,	"",		dfInteger,		0,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     80,     daRight,        false,  "dys_norm",    false,  "",     dfFloat,        2,  false,      false);

  					InitDataProperty(0, cnt++ , dtData,		80,		daRight,	false,	"ttl_cost_amt",				false,	"",		dfInteger,		0,	true,		false);
  					InitDataProperty(0, cnt++ , dtData,		90,		daRight,	false,	"hld_uc_amt_norm",			false,	"",		dfFloat,		3,	false,		false);
                    InitDataProperty(0, cnt++ , dtData,     90,     daRight,    false,  "hld_uc_amt_norm_adj",          false,  "",     dfFloat,        3,  true,      false);

                    //기존 데이터 조회
                    InitDataProperty(0, cnt++ , dtData,     80,     daRight,        false,  "day_a",    false,  "",     dfFloat,        2,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     100,        daRight,    false,  "day_b",            false,  "",     dfFloat,        2,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     90,     daRight,    false,  "day_c",            false,  "",     dfFloat,        2,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     80,     daRight,        false,  "day_a_pct",    false,  "",     dfInteger,      0,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     100,        daRight,        false,  "day_b_pct",                    false,  "",     dfInteger,      0,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     80,     daRight,        false,  "day_a_cost",                   false,  "",     dfInteger,      0,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     100,        daRight,        false,  "day_b_cost",               false,  "",     dfInteger,      0,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     80,     daRight,    false,  "pdm_a",            false,  "",     dfFloat,        3,  false,      false);
                    InitDataProperty(0, cnt++ , dtData,     90,     daRight,    false,  "pdm_c",            false,  "",     dfFloat,        3,  false,      false);


  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(18) ;
  					
  				}
  				break;
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
  	
    function enalbleCols(param){
        if( param == 1){
            sheetObjects[0].Editable = true;
            ComBtnEnable("btn_save");  
        }else{
            sheetObjects[0].Editable = false;
            ComBtnDisable("btn_save");     
        }
    }
  	function showHideCols(param){
  	    if( param == 1){
  	        sheetObjects[0].ColHidden("day_a") = true;
      	    sheetObjects[0].ColHidden("day_b") = true;
      	    sheetObjects[0].ColHidden("day_c") = true;
      	    sheetObjects[0].ColHidden("day_a_pct") = true;
      	    sheetObjects[0].ColHidden("day_b_pct") = true;
      	    sheetObjects[0].ColHidden("day_a_cost") = true;
      	    sheetObjects[0].ColHidden("day_b_cost") = true;
            sheetObjects[0].ColHidden("pdm_a") = true;
            sheetObjects[0].ColHidden("pdm_c") = true;
            sheetObjects[0].ColHidden("hld_uc_amt_norm") = false;
            sheetObjects[0].ColHidden("hld_uc_amt_norm_adj") = false;
            sheetObjects[0].ColHidden("dys_norm") = false;

  	    }else{
            sheetObjects[0].ColHidden("day_a") = false;
            sheetObjects[0].ColHidden("day_b") = false;
            sheetObjects[0].ColHidden("day_c") = false;
            sheetObjects[0].ColHidden("day_a_pct") = false;
            sheetObjects[0].ColHidden("day_b_pct") = false;
            sheetObjects[0].ColHidden("day_a_cost") = false;
            sheetObjects[0].ColHidden("day_b_cost") = false;
            sheetObjects[0].ColHidden("pdm_a") = false;
            sheetObjects[0].ColHidden("pdm_c") = false;
            sheetObjects[0].ColHidden("hld_uc_amt_norm") = true;
            sheetObjects[0].ColHidden("hld_uc_amt_norm_adj") = true;
            sheetObjects[0].ColHidden("dys_norm") = true;

  	    }
  	}
  	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
  	  vCostYrMon = vCostYrMon.replace("-","");
  	    if( vCostYrMon >= NEW_YRMON){
  	      showHideCols(1);
  	      enalbleCols(1);
  	    }else{
  	        showHideCols(2);
  	        enalbleCols(2);
  	    }
  		sheetObj.ShowSubSum( "tpsz_cd", "box_cnt|dys_norm|ttl_cost_amt|hld_uc_amt_norm|hld_uc_amt_norm_adj", -1, true, false, 2, "acct_nm=S.TOTAL" );
  	}
  
  	function sheet1_OnChange(sheetObj, Row,Col,Value) {
        var sName = sheetObj.ColSaveName(Col);
        if(sName == "ttl_cost_amt") {
            //해당 row의 PDM값 등을 다시 계산해서 setting
            var day_a_cost = parseInt(sheetObj.CellValue(Row, "ttl_cost_amt")) ;
            if( sheetObj.CellValue(Row, "hld_uc_amt_norm") == sheetObj.CellValue(Row, "hld_uc_amt_norm_adj")){
                sheetObj.CellValue2(Row, "hld_uc_amt_norm_adj") =
                    Math.round(day_a_cost /   parseFloat(sheetObj.CellValue(Row, "dys_norm")) * 1000.0) / 1000.0;
            }
             sheetObj.CellValue2(Row, "hld_uc_amt_norm") =
                Math.round(day_a_cost / parseInt(sheetObj.CellValue(Row, "box_cnt")) / parseFloat(sheetObj.CellValue(Row, "dys_norm")) * 1000.0) / 1000.0;
 
        }
        sheetObj.ShowSubSum( "tpsz_cd", "ttl_cost_amt|day_a_cost|day_b_cost|pdm_a|pdm_c", -1, true, false, 2, "acct_nm=S.TOTAL" );
  	}
  	
 
  	 var vCostYrMon = "";
  	// Sheet관련 프로세스 처리
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBSEARCH://조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCH02;
  					vCostYrMon = formObj.f_cost_yrmon.value;
  					sheetObj.DoSearch4Post("ESM_MAS_0025GS.do", masFormQueryString(formObj));
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
                sheetObj.DoSave("ESM_MAS_0025GS.do", masFormQueryString(formObj));
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
 
  		} else {
  			rt = true;
  		}
  		return rt;
  	}


	/* 개발자 작업  끝 */