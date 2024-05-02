/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_COA_0152.js
*@FileTitle      : MRI 운임수입 단가관리
*Open Issues     :
*Change history  :
*@LastModifyDate : 2010.02.22
*@LastModifier   : 이연각
*@LastVersion    : 1.0
* 2008-04-30 PEJ
* 1.0 최초 생성
* =========================================================
* History 
* 2008.05.26 PEJ N200805260007 COA_Misc OP Rev 반영 관련
*                Rlane/Bound 별로 가지고 있던 단가를 Trade/Bound 레벨까지 관리하면서 화면단도 수정
* 2009.09.14 장영석 New frame work 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 CSR No. CHM-201004982-01 COA Architecture 위배사항 수정 (CommonSC)
* 2010.12.15 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
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
     * @class ESM_COA_0152 : ESM_COA_0152 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0152() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.f_trd_cd_OnChange 	    = f_trd_cd_OnChange;
    	this.chgItem        	    = chgItem;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var comboObjects = new Array();
  var comboCnt = 0;
  var loadingMode = false;
  var sRow = 0;                // 현재 선택된 Row(Trade 변경시 사용)

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
      			case "btn_Retrieve":
      				doActionIBSheet(sheetObject,formObject,IBSEARCH);
      				break;
      
      			case "btn_DownExcel":
      				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
      				break;
      
      			case "btng_Save":
      				doActionIBSheet(sheetObject,formObject,IBSAVE);
      			    break;

      			case "btng_RowAdd":
      				doActionIBSheet(sheetObject,formObject,IBINSERT);
      			    break;

  			} // end switch
  		} catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg(OBJECT_ERROR));
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
  	/**
  	* Sheet 기본 설정 및 초기화
  	* body 태그의 onLoad 이벤트핸들러 구현
  	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	*/
  	function loadPage() {
  		var formObj = document.form;
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
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode = false;
        
  		formObj.f_rev_yrmon.value = ComGetNowInfo("yy")+"-"+ fillZero(ComGetNowInfo("mm"), 2, "0", "left") ;       
        addDash(formObj.f_rev_yrmon , 4);                       
        ComSetFocus(formObj.f_rev_yrmon);   
  	}
  	
  	/**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
    	 with (comboObj) {
	    	 DropHeight = 300;
	    	 comboObj.InsertItem(0, 'All' ,''); 
	    	 Index = 0;
	    	 
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
  			case 1:		//sheet2 init
  				with (sheetObj) {
  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(10, 5, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "STS|YYYY-MM|Trade|Lane|Bound|AMT|Vol|Per Unit ORG|Per Unit|save per unit" ;
  					InitHeadRow(0, HeadTitle,true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtStatus,		 30,	daCenter,	false,	"ibflag");
  					InitDataProperty(0, cnt++ , dtData,			 80,	daCenter,	false,	"rev_yrmon",	 false,	"",		dfNone,		0,	false,		false);
  					InitDataProperty(0, cnt++ , dtCombo,		 80,	daCenter,	false,	"trd_cd",		 false,	"",		dfNone,		0,	false,		true);
  					InitDataProperty(0, cnt++ , dtCombo,		 80,	daCenter,	false,	"rlane_cd",		 false,	"",		dfNone,		0,	false,		true);
  					InitDataProperty(0, cnt++ , dtCombo,		 80,	daCenter,	false,	"dir_cd",	     false,	"",		dfNone,		0,	false,		true);
  					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	false,	"trd_ttl_amt",	 false,	"",		dfFloatOrg,	2,	true,		true);
  					InitDataProperty(0, cnt++ , dtData,	        100,	daRight,	false,	"trd_ttl_qty",	 false,	"",		dfFloatOrg,	2,	true,		true);
  					InitDataProperty(0, cnt++ , dtHidden,       100,	daRight,	false,	"ut_rev_amt_org",false,	"",	    dfFloatOrg,	4,	true,		true);
  					InitDataProperty(0, cnt++ , dtData,	        100,	daRight,	false,	"etc_ut_rev_amt",false,	"|trd_ttl_amt|/|trd_ttl_qty|",		dfFloatOrg,	4,	false,		false);
  					InitDataProperty(0, cnt++ , dtHidden,	    100,	daRight,	false,	"etc_ut_rev_amt",false,	"|trd_ttl_amt|/|trd_ttl_qty|",		dfNone,	0,	false,		false);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(18) ;
  				}
  				break;

  		}
  	}
  	
  	function sheet1_OnChange(sheetObj, Row, Col, value){
  	    var formObj = document.form;
  	    var param = "";
  	    // Trade 변경시 Rlane을 변경한다.
  	    if(sheetObj.ColSaveName(Col) == "trd_cd"){
  	    	param = param+"&f_cmd="+SEARCHLIST11;
			param = param+"&f_trd_cd="+sheetObj.CellValue(Row,Col);
			
			var sXml = sheetObj.GetSearchXml("ESM_COA_0152GS.do", param);
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComCoaSetIBCombo(sheetObj, arrXml[0], "rlane_cd",true,0,Row);
  	    }
  	}

  	// Sheet관련 프로세스 처리
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = document.form.sXml.value; 
				
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				if(State == "S"){ 
					ComShowMessage(OBJECT_ERROR);
					ComOpenWait(false);
					return;
				}	
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_trd_cd, "code", "code");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_rlane_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_dir_cd, "code", "code");
				
				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "trd_cd", true, 0);
				if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "rlane_cd",true,0);
				if (arrXml.length > 2)
					ComCoaSetIBCombo(sheetObj, arrXml[2], "dir_cd",true,0);
				document.form.sXml.value = "";
				ComOpenWait(false);
				break;
				
  			case IBSEARCH://조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
              	    sheetObj.Redraw = false;
              		if (formObj.istrade[0].checked){
                  		sheetObj.ColHidden("rlane_cd") = true;
              		} else {
                  		sheetObj.ColHidden("rlane_cd") = false;
              		}  
      	    		formObj.f_cmd.value = SEARCH;
      	    		sheetObj.DoSearch4Post("ESM_COA_0152GS.do", coaFormQueryString(formObj));
      	            sheetObj.Redraw = true;
      	            ComOpenWait(false);
  				}
  				break;

  			case IBSAVE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					sheetObj.WaitImageVisible = false;
  					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI;
  					sheetObj.DoSave("ESM_COA_0152GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;

  			case IBINSERT:	//행 추가
  				var row = sheetObj.DataInsert(-1);
  				if(row > 1) {
  				    sheetObj.CellValue2(row, "rev_yrmon") = sheetObj.CellValue(row-1, "rev_yrmon");
  				} else {
  				    sheetObj.CellValue2(row, "rev_yrmon") = formObj.f_rev_yrmon.value.replace("-","");
  				}
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
//				sheetObj.Down2Excel(-1, false, false, true);
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
  		}
  	}
  	

	 /**
	 * ifram을 이용하여 R.Lane 표시
	 */
	function f_trd_cd_OnChange(obj) {
		if (loadingMode == true)
			return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (formObj.istrade[1].checked){
			if (obj.Text != "") {
				formObj.f_cmd.value = SEARCHLIST10;
				var sXml = sheetObj.GetSearchXml("ESM_COA_0152GS.do", FormQueryString(formObj));
		
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
				formObj.f_rlane_cd.Index = 0;
			}
		}
	}
		      
	 function chgItem(param) {
		var formObj = document.form;
		formObj.f_trd_cd.Index = 0;
		// RLANE을 초기화 시켜준다
		if (param == "YES") {
			var formObj = document.form;
			var sheetObj = sheetObjects[0];
			formObj.f_cmd.value = SEARCHLIST10;
			var sXml = sheetObj.GetSearchXml("ESM_COA_0152GS.do", FormQueryString(formObj));

			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
			formObj.f_rlane_cd.Index = 0;
	
		}
	}
	      
  	/**
  	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	*/
  	function validateForm(sheetObj,formObj,sAction){
  		var rt = false;
  		if(!isValidYYYYMM(formObj.f_rev_yrmon , false, '-', false)){

  		} else {
  			rt = true;
  		}
  		return rt;
  	}


	/* 개발자 작업  끝 */