/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_119.js
*@FileTitle : UOM 설정 팝업화면
*Open Issues :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2007-02-14 IM OKYOUNG
* 2009.10.09 박수훈 New FrameWork 적용[0119]
* 1.0 최초 생성
*Change history :
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
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
     * @class ESM_COA_0119 : ESM_COA_0119 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0119() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  //SrcTxt를 setting하기위한 변수
  var srcTxtArr;
  var srcCdArr;

  var comboObjects = new Array();
  var comboCnt = 0;
  var loadingMode = false;

  /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

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

  				case "btn_Retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  					break;

  				case "btng_Save":
  					doActionIBSheet(sheetObject,formObject,IBSAVE);
  					break;

  				case "btng_RowAdd":
  					doActionIBSheet(sheetObject,formObject,IBINSERT);
  					break;

  				case "btn_DownExcel":
  					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
  					break;

  				case "btn_Close":
  					window.close();
  					break;

  			} // end switch
  		}catch(e) {
  			if( e == "[object Error]") {
  				ComShowMessage(OBJECT_ERROR);
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
  	* Sheet 기본 설정 및 초기화
  	* body 태그의 onLoad 이벤트핸들러 구현
  	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  	*/
  	function loadPage() {
  		loadingMode = true;
  	    for(i=0;i<sheetObjects.length;i++){
  	        ComConfigSheet(sheetObjects[i]);
  	        initSheet(sheetObjects[i],i+1);
  	        ComEndConfigSheet(sheetObjects[i]);
  	    }
  	    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k],comboObjects[k].id);
  	    }
  		loadingMode = false;
		btn_Retrieve.focus();
  	}

  	/**
  	 * 멀티콤보 항목을 설정한다.
  	 */
  	function initCombo(comboObj, comboId) {
  		with (comboObj) {
  			DropHeight = 300;
  			Index = 0;
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
  	* 시트 초기설정값, 헤더 정의
  	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	*/
  	function initSheet(sheetObj,sheetNo) {
  		var cnt = 0;
  		switch(sheetNo) {
  			case 1:		//sheet2 init
  				with (sheetObj) {
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
  					Editable = true;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(9, 1, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "StS|Terminal|TML Expense Account|TML Expense Account|Tariff Item|Tariff Item|Tariff Detail|Tariff Detail|UOM\nSrc Code" ;
  					var HeadTitle2 = "StS|Terminal|Acct Code|Acct_Desc|Code|Desc|Code|Desc|UOM\nSrc Code" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle,true);
  					InitHeadRow(1, HeadTitle2,true);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtStatus,	25,	daLeft,	true,	"ibflag");
  					InitDataProperty(0, cnt++, dtData,	70,		daCenter,	true,	"tml_cd",				true,	"",	dfEngUpKey,	0,	false,	true, 7);
  					InitDataProperty(0, cnt++, dtCombo,	75,		daCenter,	true,	"coa_cost_src_cd",		true,	"",	dfNone,		0,	false,	true, 8);
  					InitDataProperty(0, cnt++, dtData,	150,	daLeft,		true,	"coa_cost_src_cd_nm",	false,	"",	dfNone,		0,	false,	false);
  					InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"tml_trf_itm_cd",		true,	"",	dfEngUpKey,	0,	false,	true, 4);
  					InitDataProperty(0, cnt++, dtData,	120,	daLeft,		true,	"tml_trf_itm_desc",		false,	"",	dfNone,		0,	true,	true);
  					InitDataProperty(0, cnt++, dtData,	60,		daCenter,	true,	"tml_trf_dtl_cd",		true,	"",	dfEngUpKey,	0,	false,	true, 2);
  					InitDataProperty(0, cnt++, dtData,	120,	daLeft,		true,	"tml_trf_dtl_desc",		false,	"",	dfNone,		0,	true,	true);
  					InitDataProperty(0, cnt++, dtData,	115,    daCenter,	true,	"tml_ut_cd",			true,	"",	dfNone,		0,	true,	true, 23);
  					//COA_INTER_TML_IF_MGMT table 삭제에 의한 처리
  					//InitDataProperty(0, cnt++, dtComboEdit,	115,daCenter,	true,	"tml_ut_cd",			true,	"",	dfNone,		0,	true,	true, 23);
  					//tml_desc

  					RangeBackColor(1, 2, 1, 7) = RgbColor(222, 251, 248);  // ENIS

  					HeadRowHeight = 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(15) ;
  					//
  					InitDataValid(0, "tml_cd", vtEngUpOther, "0123456789");
  					InitDataValid(0, "tml_trf_itm_cd", vtEngUpOther, "0123456789");
  					InitDataValid(0, "tml_trf_dtl_cd", vtEngUpOther, "0123456789");

  				}
  				break;
  		}
  	}

  	/**
  	* 쉬트 값이 변경 되었을 경우 coa_cost_src_cd_nm 값 셋팅
  	* tml_ut_cd 값 유효성 체크
  	*/
  	function sheet1_OnChange(sheetObj, row, col, value){
  		var tmpSN = sheetObj.ColSaveName(col);
  		if(tmpSN == "coa_cost_src_cd")	{
  			//sheetObj.CellValue2(row,"coa_cost_src_cd_nm") = srcTxtArr[sheetObj.GetComboInfo(row,col, "SelectedIndex")];
  			sheetObj.CellValue2(row,"coa_cost_src_cd_nm") = ComGetComboText(sheetObj, row, col,1);
  			//coa_cost_src_cd_nm을 setting 
  		} else 	if(tmpSN == "tml_ut_cd"){
  			if(value.substring(0, 7) != sheetObj.CellValue(row, "tml_cd"))	{
  				ComShowCodeMessage('COA10035');
  					sheetObj.CellValue2(row,col) = '';
  					sheetObj.SelectCell(row, col);
  			}
  		}

  	}

  	/**
  	* Sheet관련 프로세스 처리
  	*/
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
	    	case IBCLEAR:          //조회
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
		
				var sXml = sheetObj.GetSearchXml("ESM_COA_0119GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");

				if (arrXml.length > 0)
					ComCoaSetIBCombo(sheetObj, arrXml[0], "coa_cost_src_cd", true, 0, 0, "","", true);
				
				/*if (arrXml.length > 1)
					ComCoaSetIBCombo(sheetObj, arrXml[1], "tml_ut_cd", false,0);*/

				ComOpenWait(false);
				break;

  			case IBSEARCH:	//조회
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
  					formObj.f_cmd.value = SEARCH;
  					sheetObj.DoSearch4Post("ESM_COA_0119GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;

  			case IBSAVE:		//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
  					formObj.f_cmd.value = MULTI;
  					sheetObj.DoSave("ESM_COA_0119GS.do", coaFormQueryString(formObj));
  					ComOpenWait(false);
  				}
  				break;

  			case IBINSERT:	// 입력
  				sheetObj.DataInsert(-1); // 마지막행에 행삽입
  				break;

  			case IBCOPYROW:	//행 복사
  				sheetObj.DataCopy();
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
  				//sheetObj.SpeedDown2Excel(-1, true, true);
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
  	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	*/
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  
  		}
  		return true;
  	}
  	
  	/**
  	* 화면 로드시 즉시 Retrieve 
  	*/
  	function setRetrieveAction(){
  		sheetObject = sheetObjects[0];
  		formObject = document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}

