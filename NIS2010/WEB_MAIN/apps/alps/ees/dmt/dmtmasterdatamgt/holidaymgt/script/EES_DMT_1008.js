/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1008.js
*@FileTitle : Holiday by Country Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.04 이성훈
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
     * @class Holiday by Country Creation : Holiday by Country Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_1008() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
		this.initCombo				= initCombo;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
  	/* 개발자 작업	*/
	
	// 공통전역변수
	
	var sheetObjects = new Array();
	var sheetCnt 	 = 0;

	var comboObjects = new Array();
	var comboCnt 	 = 0;
	
	var RHQ 		= "RHQ";
	var COUNTRY 	= "CNT";
	var REGION 		= "RGN";
	var STATE 		= "STE";
	var LOCATION 	= "LOC";
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";

	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;
		
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	//Sort 시 선택되어진 Row 의 선택상태를 계속 유지하기 위해서 사용되는 변수
	var currHolYr 	= "";
	var currCntCd 	= "";
	var currRgnCd 	= "";
	var currLocCd 	= "";
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
		 var sheetObject3 = sheetObjects[2];
		 var sheetObject4 = sheetObjects[3]; 
			 	 
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
					
				case "btn_New":
					initControl();
					break;
					
				case "btn_DownExcel":
					doActionIBSheet(sheetObject4, formObj, IBDOWNEXCEL);
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
		var formObj = document.form;
		
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		
	 	// IBMultiCombo초기화 
	    for(var k = 0 ; k < comboObjects.length ; k++){
	        initCombo(comboObjects[k],k+1);
	    }
		//Axon 이벤트 처리
		initAxonControl();
				
		// Year 조회필드 초기화
		initYearControl();

		//RHQ 조회필드에 포커스를 준다.
		formObj.rhq.focus();
    }

   	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
   	function sheet1_OnLoadFinish() {
   		var formObj 	= document.form
   		var sheetObj 	= sheetObjects[0];
      	
   		//전체 Country 정보 조회 후 콤보에 설정
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
   		
   		//전체 Region 정보 조회 후 콤보에 설정
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
   	}

  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetID = sheetObj.id;
				
        switch(sheetID) {

            case "sheet1":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
					style.height = 242;
					SheetWidth = mainTable.clientWidth;

				 	// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 2, 100);

					var HeadTitle 	= "|Seq.|Country|Coverage|Coverage|Coverage|Year|Weekend|Days of Holiday|Update|Update|Update";
					var HeadTitle2 	= "|Seq.|Country|CN|RGN|LOC|Year|Weekend|Days of Holiday|Date|Office|Name";					
                    var headCount 	= ComCountHeadTitle(HeadTitle) + 4;
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle,  true);
					InitHeadRow(1, HeadTitle2, true);					

					//데이터속성    [	ROW, COL,  DATATYPE,   			WIDTH, 	DATAALIGN, 		COLMERGE, SAVENAME,  	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,    			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"cnt_cd",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,		true,		"cvrg_cnt_cd",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,		true,		"cvrg_rgn_cd",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,		true,		"cvrg_loc_cd",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"hol_yr",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"hol_wknd_tp",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"hol_days",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"upd_dt",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daCenter,		true,		"upd_ofc_cd",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,      		100,	daLeft,			true,		"upd_usr_nm",	false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      		  0,	daCenter,		true,		"rgn_cd",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      		  0,	daCenter,		true,		"ste_cd",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      		  0,	daCenter,		true,		"loc_cd",		false,		"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,      		  0,	daCenter,		true,		"wknd_tp_cd",	false,		"",		dfNone,		0,			false,		false);

					CountPosition = 0;		// 건수 정보를 표시하지 않음.
			  	}
				break;         	
         	
            case "sheet2":      // sheet2 init
                with (sheetObj) {
					// 높이 설정
					style.height = 202;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle = "|SAT";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"Status");
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,	false,		"firstholiday",		false,		"",		dfNone,		0,	false,		false, 		-1, 	false, 		false);

					CountPosition = 0;		// 건수 정보를 표시하지 않음.

               }
                break;

            case "sheet3":      // sheet3 init
                with (sheetObj) {
					// 높이 설정
					style.height = 202;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					var HeadTitle = "|SUN";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);


					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"Status");
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,	false,		"secondholiday",		false,		"",		dfNone,		0,	false,		false, 		-1, 	false, 		false);

					CountPosition = 0;		// 건수 정보를 표시하지 않음.

				}
                break;

            case "sheet4":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
					style.height = 202;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
	
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
	
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
	
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 2, 100);
	
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(4, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);
	
					var HeadTitle = "|Seq.|DATE|HOLIDAY";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,    			65,		daCenter,		false,		"Seq");
					InitDataProperty(0, cnt++ , dtData,      		135,	daCenter,		false,		"hol_dt_in",	false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,      		120,	daLeft,			false,		"hol_desc",		false,		"",		dfNone,				0,			false,		true);
	
					CountPosition = 0;		// 건수 정보를 표시하지 않음.

				}
                break;

        }
    }
	
  	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        var cboCountryObj		= comboObjects[0];
        var cboRegionObj		= comboObjects[1];

        sheetObj.ShowDebugMsg 	= false;
        
        switch(sAction) {

           case IBSEARCH:      //조회
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet1") {
						
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						ComSetObjValue(formObj.svr_id, 	ComGetObjValue(formObj.rhq));		//RHQ
						ComSetObjValue(formObj.hol_yr, 	ComGetObjValue(formObj.year));		//Year
						ComSetObjValue(formObj.cnt_cd, 	cboCountryObj.Text);				//Country
						
						if (cboCountryObj.Text == "CA" || cboCountryObj.Text == "US") {
							ComSetObjValue(formObj.rgn_cd, 	"");							//Region
							ComSetObjValue(formObj.ste_cd, 	cboRegionObj.Text)				//State
						}
						else {
							ComSetObjValue(formObj.rgn_cd, 	cboRegionObj.Text)				//Region
							ComSetObjValue(formObj.ste_cd, 	"");							//State
						}
							
						ComSetObjValue(formObj.loc_cd, 	ComGetObjValue(formObj.location));	//Location		
						ComSetObjValue(formObj.f_cmd, 	SEARCH);							//Command
											
						//2.조회전 결과필드들을 Empty 시킨다.
						initResultControls();
						
						//3.조회조건으로 조회실행
						sheetObj.DoSearch("EES_DMT_1008GS.do", FormQueryString(formObj));
												
						//4.조회후 결과내용이 있다면 상세조회를 실행한다.
						if (sheetObj.RowCount > 0) {
							doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
							
							with(sheetObj) {
								currCntCd = CellValue(SelectRow, "cvrg_cnt_cd");
								currRgnCd = CellValue(SelectRow, "cvrg_rgn_cd");
								currLocCd = CellValue(SelectRow, "cvrg_loc_cd");
								currHolYr = CellValue(SelectRow, "hol_yr");
							}
						}
					}
				}
				break;	

			case IBROWSEARCH:
				if (validateForm(sheetObj,formObj,sAction)) {
					if (sheetObj.id == "sheet1") {
						
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						var row = sheetObj.SelectRow;
						ComSetObjValue(formObj.hol_yr, 		sheetObj.CellValue(row, "hol_yr"));		//Hol_yr
						ComSetObjValue(formObj.cnt_cd, 		sheetObj.CellValue(row, "cnt_cd"));		//Country
						ComSetObjValue(formObj.rgn_cd, 		sheetObj.CellValue(row, "rgn_cd"));		//Region
						ComSetObjValue(formObj.ste_cd, 		sheetObj.CellValue(row, "ste_cd"));		//State
						ComSetObjValue(formObj.loc_cd, 		sheetObj.CellValue(row, "loc_cd"));		//Location
						ComSetObjValue(formObj.wknd_tp_cd, 	sheetObj.CellValue(row, "wknd_tp_cd"));	//휴일 구분						
						ComSetObjValue(formObj.f_cmd, 		SEARCH01);								//Command

						//2.선택한 항목에 대한 상세조회실행
			            var sXml = sheetObj.GetSearchXml("EES_DMT_1008GS.do" , FormQueryString(formObj));
						
						//3.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
			            var arrXml = sXml.split("|$$|");
		            	if (arrXml.length > 0) sheetObjects[1].LoadSearchXml(arrXml[0]);	//휴일날짜1
						if (arrXml.length > 1) sheetObjects[2].LoadSearchXml(arrXml[1]);	//휴일날짜2		
			            if (arrXml.length > 2) sheetObjects[3].LoadSearchXml(arrXml[2]);	//조회된 휴일정보
						
						//3-1.휴일 그리드제목을  변경해준다.
						setHolidayTitle();				
					}
					
				}
				break;
				
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				sheetObj.Down2Excel(-1);
				break;				
        }
    }
	
 
	// 조회조건필드인 Country, Region Combo 데이터 조회
    function doActionIBCombo(sheetObj, formObj, sAction, sComboAction) {
		var cboCountryObj			= comboObjects[0];
		var cboRegionObj			= comboObjects[1];

		var regionList;
		var countryList;

        sheetObj.ShowDebugMsg 		= false;
		sheetObj.WaitImageVisible 	= false;

        switch(sAction) {
			case IBSEARCH:      // 조회
			
				if (sheetObj.id == "sheet1") {
					//1.조회를 하기 위해 필요한 매개변수 설정
					ComSetObjValue(formObj.f_cmd, 	sComboAction);
					
					//2.조회조건으로 조회실행
					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					
					//3.조회후 결과처리
					switch(sComboAction) {

						//3-1.Region 조회(모든 Region 목록)
						case SEARCH01:
    						regionList = handleNullString(ComGetEtcData(sXml, REGION));
    						
    						cboRegionObj.RemoveAll();
    						if (regionList != "") {
    							addComboItem(cboRegionObj, regionList.split(ROWMARK));
    						}
							break;
						
						//3-2.Country 조회(모든 Country 목록)
						case SEARCH02:
    						countryList = handleNullString(ComGetEtcData(sXml, COUNTRY));
    						
    						cboCountryObj.RemoveAll();
    						if (regionList != "") {
    							addComboItem(cboCountryObj, countryList.split(ROWMARK));
    						}
							break;
							
						//3-3.RHQ 항목 선택에 따른 해당 Country 조회
						case SEARCH05:
							//응답 XML 에서 Country 정보를 추출해서 목록에 입력해준다.
							countryList = handleNullString(ComGetEtcData(sXml, COUNTRY));
							
							cboCountryObj.RemoveAll();							
							if (countryList != "") {
								addComboItem(cboCountryObj, countryList.split(ROWMARK));
							}							
							break;
														
						//3-4.Country 항목 선택에 따른 해당 Region 조회
						case SEARCH03:
							//응답 XML 에서 Region or State 정보를 추출해서 목록에 입력해준다.											
							if (cboCountryObj.Text == "CA" || cboCountryObj.Text == "US") {
								regionList = handleNullString(ComGetEtcData(sXml, STATE));
							} 
							else {
								regionList = handleNullString(ComGetEtcData(sXml, REGION));
							}
							
							cboRegionObj.RemoveAll();
							if (regionList != "") {
								addComboItem(cboRegionObj, regionList.split(ROWMARK));
							}							
							break;
													
						//3-5.Location 항목 입력에 따른 상위 RHQ, Country, Region 조회
						case SEARCH04:
							//응답 XML 에서 RHQ 정보를 추출해서 목록에서 선택해준다.
							rhqList = handleNullString(ComGetEtcData(sXml, RHQ));
							
							if (rhqList != "") {
								arrRHQList = rhqList.split(ROWMARK);
								fieldRHQList = arrRHQList[0].split(FIELDMARK);
								ComSetObjValue(formObj.rhq, fieldRHQList[0]);
							}
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							countryList = handleNullString(ComGetEtcData(sXml, COUNTRY));
							
							if (countryList != "") {
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							locCd = ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
							if (locCd == "CA" || locCd == "US") {
								regionList = handleNullString(ComGetEtcData(sXml, STATE));
							} 
							else {
								regionList = handleNullString(ComGetEtcData(sXml, REGION));
							}
							
							if (regionList != "") {
								setComboItem(cboRegionObj, regionList.split(ROWMARK));
							} 
							else {
								ComShowCodeMessage("DMT00110", "Location");
								ComClearObject(formObj.location);
								ComSetFocus(formObj.location);
							}
							break;
							
						//3-6.Region 항목 선택에 따른 상위 RHQ, Country 조회
						case SEARCH07:
							//응답 XML 에서 RHQ 정보를 추출해서 목록에서 선택해준다.
							rhqList = handleNullString(ComGetEtcData(sXml, RHQ));
							
							if (rhqList != "") {
								fieldRHQList = rhqList.split(FIELDMARK);
								ComSetObjValue(formObj.rhq, fieldRHQList[0]);
							}
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							countryList = handleNullString(ComGetEtcData(sXml, COUNTRY));
							
							if (countryList != "") {
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}
							
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							regionList = handleNullString(ComGetEtcData(sXml, REGION));
							
							if (regionList != "") {
								setComboItem(cboRegionObj, regionList.split(ROWMARK));
							}
							break;
							
						case SEARCH16:
							//응답 XML 에서 RHQ 정보를 추출해서 목록에서 선택해준다.
							rhqList = handleNullString(ComGetEtcData(sXml, RHQ));
							
							if (rhqList != "") {
								fieldRHQList = rhqList.split(FIELDMARK);
								ComSetObjValue(formObj.rhq, fieldRHQList[0]);
							}
							
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							countryList = handleNullString(ComGetEtcData(sXml, COUNTRY));
							
							if (countryList != "") {
								setComboItem(cboCountryObj, countryList.split(ROWMARK));
							}							
							break;												
					}						
				};
				break;
        }
		sheetObj.WaitImageVisible = true;
    }
	
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj,comboItems,checked) {
		var checkedItem = "";
    	for (var i = 0 ; i < comboItems.length ; i++) {
			if (ComTrim(comboItems[i]) != "") {
    			var comboItem = comboItems[i].split(FIELDMARK);
				if (i == 0) checkedItem = comboItem[0];
				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);
			}
    	}
		if (checked) comboObj.Text = checkedItem;
	}
	
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
	function setComboItem(comboObj,comboItems) {
		var checkedItem = comboItems[0].split(FIELDMARK);
		comboObj.Text = checkedItem[0];
	}
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		//필수항목에 데이터가 입력되었는지 확인한다.
        return true;
    }

	/** 
	 * IBCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++] = combo_obj;  
	} 
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject = document.form;

		switch(comboNo) {
			//Country 콤보  초기화
			case 1:
				with (comboObj) { 
  					MultiSelect = false; 
  					SetColAlign("left|left");        
  					SetColWidth("50|190");
  					DropHeight = 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
					MaxLength = 2;     		
		    	}
				break;
			
			//Region 콤보 초기화
			case 2: 
				with (comboObj) { 		
  					MultiSelect = false; 
  					SetColAlign("left|left");        
  					SetColWidth("50|190");
  					DropHeight = 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
					MaxLength = 3;
				}
				break;			
	     }  
	} 	
	
	/*
	 * RHQ 조회필드가 변경될 경우  그 소속의 Country 정보를 조회해주는 함수
	 */		
	function searchCountryByRHQ() {
		var formObj 	= document.form;
		var sheetObj	= sheetObjects[0];
		
		//1.RHQ 가 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
		
		//2.RHQ 가 존재할 경우
		if (ComTrim(ComGetObjValue(formObj.rhq)).length > 0) {
			//2-1.조회를 위해 필요한 매개변수를 설정한다.
			ComSetObjValue(formObj.svr_id, 	ComGetObjValue(formObj.rhq));	//RHQ
			
			//2-2.RHQ 에 해당되는 Country 정보만 모두 조회한다.
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH05);
		}
		//3.RHQ 가 없을 경우
		else {
			//3-1.RHQ 가 ALL 일 경우에는 Country 정보를 모두 조회한다.
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
		}
		
		//Country 정보는 Add 되어지고 Empty 로 선택되어지기 때문에 Region 정보는 모두 보여준다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);		
		formObj.year.focus();
	}
		
	/*
	 * Country 조회필드가 변경될 경우 그 소속의 Region or State 정보를 조회해주는 함수
	 */		
	function cboCountry_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj	= sheetObjects[0];
		
		var cntCd 		= comboObj.Text;
		
		//Country 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
				
		//Country 가 Empty 라면 모든 Region 정보를 조회한다.
		if (cntCd.length == 0) {
			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
			return;	
		}			
		
		//Region Caption 을 Country Code 에 따라서 변경해 준다.
		switch(cntCd) {
			case "CA":
			case "US":
				Region.innerHTML = "State";
				break;
				
			default:
				Region.innerHTML = "Region";
		}
		
		//조회를 위해서 필요한 매개변수를 설정한다.
		ComSetObjValue(formObj.cnt_cd, 	cntCd);
		
		//Country 에 소속된 상위 RHQ 정보를 조회한다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH16);		
		//Country 에 소속된 하위 Region or State 정보를 조회한다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
	}	

	/**
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj	= sheetObjects[0];
		
		var rgnCd 		= comboObj.Text;
		
		//Region 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();

		//Region 이 Empty 라면 상위필드조회는 하지 않는다.
		if (rgnCd.length == 0) return;
		
		//조회를 위해 필요한 매개변수를 설정한다.
		ComSetObjValue(formObj.rgn_cd, rgnCd);
		
		//조회를 실행한다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH07);
	}
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation() {
		var formObj		= document.form;
		var sheetObj	= sheetObjects[0];
		
    	if (ComTrim(ComGetObjValue(formObj.location)).length == 5) {
			var locCd = ComTrim(ComGetObjValue(formObj.location));
    		if (locCd.length == 5) {
				isClearLocation = false;
				
				//조회를 위해서 필요한 매개변수를 설정한다.
				ComSetObjValue(formObj.loc_cd, locCd);
				
				//Location 상위(RHQ, Country, Region or State) 정보를 조회한다.
    			doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH04);
    			
				isClearLocation = true;
			}
    	}
	}

   /**
	* 정렬시 현재 선택되어진 ROW 의 선택상태를 계속 유지하도록 처리해주는 함수
	*/	
	function sheet1_OnSort(sheetObj, Col, SortArrow) {
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				if (	currCntCd == CellValue(row, "cvrg_cnt_cd")
					&&	currRgnCd == CellValue(row, "cvrg_rgn_cd")
					&&	currLocCd == CellValue(row, "cvrg_loc_cd")
					&&	currHolYr == CellValue(row, "hol_yr")) {
					SelectRow = row;
					break;
				}
			}
		}
	}
	 
	/**
	 * 휴일정보 상세조회
	 */		
	function sheet1_OnClick(sheetObj, Row, Col, value) {
		 
		with(sheetObj) {
			currCntCd = CellValue(SelectRow, "cvrg_cnt_cd");
			currRgnCd = CellValue(SelectRow, "cvrg_rgn_cd");
			currLocCd = CellValue(SelectRow, "cvrg_loc_cd");
			currHolYr = CellValue(SelectRow, "hol_yr");
		}
		 
		doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
	}
	
	/*
	 * 휴일 그리드의 제목을 입력화면의 조회조건에 맞도록 변경한다.
	 */		
	function setHolidayTitle() {
		var formObj = document.form;
		var sheet1Title = "";
		var sheet2Title = "";
		
		var wkndTpCd = ComGetObjValue(formObj.wknd_tp_cd);
		switch(wkndTpCd) {
			case "TF": 
				sheet1Title = "|THU";
				sheet2Title = "|FRI";
				break;
				
			case "FS": 
				sheet1Title = "|FRI";
				sheet2Title = "|SAT";
				break;
				
			default:
				sheet1Title = "|SAT";
				sheet2Title = "|SUN";							
		}

		sheetObjects[1].InitHeadRow(0, sheet1Title, false);
		sheetObjects[2].InitHeadRow(0, sheet2Title, false);
	}

	function initAxonControl() {  
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress',    'obj_keypress', 	document.form);  
		axon_event.addListener('beforedeactivate', 	'obj_deactivate', 	'location');
		axon_event.addListener('keydown', 			'ComKeyEnter', 		'form'); 		
	}           
		   
	//Axon 이벤트 처리2. 이벤트처리함수  
	/*
	 * Location 필드 입력문자 대문자로 변환 
	 */		
	function obj_keypress(){ 
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	         
	    switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');          
	            break;   
	    }   
	}
	
	/*
	 * Location FocusOut시 입력값 자리수에 대한 Validation Check
	 */
	function obj_deactivate() {
		obj = event.srcElement;
		if(obj.value.length > 0 && obj.value.length < 5) {
			ComShowCodeMessage("DMT00110", "Location");
			ComClearObject(obj);
		}
	}	
		
	/*
	 * Year 조회필드 초기화 
	 */		
	function initYearControl() {
		var formObj = document.form;
		var date 	= new Date();
		var optVal 	= "";
		
		for (var i = -1 ; i < 6 ; i++) {
			optVal = date.getFullYear() - i;
			formObj.year.add(new Option(optVal, optVal));
		}
		
		//올 해를 기본값으로 설정한다.
		ComSetObjValue(formObj.year, date.getFullYear());
	}
			
	/*
	 * 휴일조회필드 초기화 
	 */		
	function initSearchControls() {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		
		ComSetObjValue(formObj.hol_yr, 		"");	//Year ComboBox
		ComSetObjValue(formObj.year, 		"");	//Year ComboBox
		ComSetObjValue(formObj.svr_id, 		"");
		ComSetObjValue(formObj.cnt_cd, 		"");
		ComSetObjValue(formObj.rgn_cd, 		"");
		ComSetObjValue(formObj.ste_cd, 		"");
		ComSetObjValue(formObj.loc_cd, 		"");
		ComSetObjValue(formObj.location, 	"");
		ComSetObjValue(formObj.wknd_tp_cd, 	"");
		
		//Year 조회필드 초기화
		initYearControl();
		
		formObj.rhq.selectedIndex = 0;
		
		//Region Caption
		Region.innerHTML = "Region";				
		
   		//전체 Country 정보 조회 후 콤보에 설정
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH02);
   		
   		//전체 Region 정보 조회 후 콤보에 설정
   		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH01);
	}		
		
	/*
	 * 휴일조회결과필드 초기화
	 */					
	function initResultControls() {
		sheetObjects[0].RemoveAll();//국가/Region/Location 별 등록된 Holiday 총 일 수 조회된 정보 초기화
		sheetObjects[1].RemoveAll();//첫번째 휴일정보 초기화
		sheetObjects[2].RemoveAll();//두번째 휴일정보 초기화
		sheetObjects[3].RemoveAll();//조회된 휴일정보 초기화
		sheetObjects[1].InitHeadRow(0, "|SAT", false);
		sheetObjects[2].InitHeadRow(0, "|SUN", false);
	}
	
	/*
	 * Location 조회필드정보 초기화
	 */		
	function clearLocation() {
		var formObj = document.form;
		ComSetObjValue(formObj.loc_cd, "");
		ComSetObjValue(formObj.location, "");
	}
		
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		//조회필드 초기화
		initSearchControls();
		//조회결과 정보 초기화
		//initResultControls();
	}
	 
    /**
     * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
     */
    function handleNullString(sVal) {
    	
         if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

         return ComTrim(sVal);
    }	 
