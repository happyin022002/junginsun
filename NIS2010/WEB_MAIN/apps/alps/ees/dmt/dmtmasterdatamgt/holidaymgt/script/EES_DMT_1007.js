/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1007.js
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
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
    function EES_DMT_1007() {
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

	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;

	var comboObjects 	= new Array();
	var comboCnt 		= 0;
	
	var COUNTRY 		= "CNT";
	var REGION 			= "RGN";
	var STATE 			= "STE";
	var LOCATION 		= "LOC";
	
	//Action 정의
	IBSEARCH_WKND 		= 101;
	
	//Field 컬럼순서 정의
	var HOL_DT_IN 		= 3;
	var HOL_DESC 		= 4;
	var HOL_YR 			= 5;
	var CNT_CD 			= 6;
	var RGN_CD 			= 7;
	var STE_CD 			= 8;
	var LOC_CD 			= 9;
	var HOL_DT 			= 10;
	var UPD_DT 			= 11;
	var UPD_OFC_CD 		= 12;
	var UPD_USR_NM 		= 13;
	
	//DATA 구분자 정의
	var ROWMARK 		= "|";
	var FIELDMARK 		= "=";
		
	//월을 영문으로 자동변환하기 위한 변수
	var MonthOfYear 	= new Array();
	MonthOfYear[1] 		= 'JAN';
	MonthOfYear[2] 		= 'FEB';
	MonthOfYear[3] 		= 'MAR';
	MonthOfYear[4] 		= 'APR';
	MonthOfYear[5] 		= 'MAY';
	MonthOfYear[6] 		= 'JUN';
	MonthOfYear[7] 		= 'JUL';
	MonthOfYear[8] 		= 'AUG';
	MonthOfYear[9] 		= 'SEP';
	MonthOfYear[10] 	= 'OCT';
	MonthOfYear[11] 	= 'NOV';
	MonthOfYear[12] 	= 'DEC';
	
	//Location 조회시 의도적이지 않게 Location 정보가 지워지는 것을 막기 위함
	var isClearLocation = true;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick 	= processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_Retrieve":
					ComSetObjValue(formObject.retry, "");
					doActionIBSheet(sheetObject3, formObject, IBSEARCH);
					break;
					
				case "btn_New":
					initControl();
					break;
					
				case "btn_Save":
					doActionIBSheet(sheetObject3, formObject, IBSAVE);
					break;
					
				case "btn_DownExcel":
					doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL);
					break;
					
				case "btn_RowAdd":
					if (ComIsBtnEnable("btn_RowAdd")) 
						doActionIBSheet(sheetObject3, formObject, IBINSERT);
					break;
					
				case "btn_RowCopy":
					if (ComIsBtnEnable("btn_RowCopy")) 
						doActionIBSheet(sheetObject3, formObject, IBCOPYROW);
					break;
					
				case "btn_Delete":
					if (ComIsBtnEnable("btn_Delete")) 
						doActionIBSheet(sheetObject3, formObject, IBDELETE);
					break;
					
				case "btn_LoadExcel":
					if (ComIsBtnEnable("btn_LoadExcel")) 
						doActionIBSheet(sheetObject3, formObject, IBLOADEXCEL);
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
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
       		//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
		
	 	// IBMultiCombo초기화 
	    for(var k=0 ; k < comboObjects.length ; k++){
	        initCombo(comboObjects[k],k+1);
	    }
	 	
		//Axon 이벤트 처리
		initAxonControl();
		
		//Update Date/OFC/Name 상태초기화
		with(formObj) {
			ComEnableManyObjects(false, upd_dt, upd_ofc_cd, upd_usr_nm);
			upd_dt.className 		= 'input2';
			upd_ofc_cd.className 	= 'input2';
			upd_usr_nm.className 	= 'input2';
		}
					
		//Year 조회필드 초기화
		initYearControl();

		//Country 조회필드에 포커스를 준다.
		comboObjects[0].focus();
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
            case "sheet1":      // sheet1 init
                with (sheetObj) {
					// 높이 설정
					style.height = 382;
					// 길이설정
					SheetWidth = mainTable.clientWidth;
					
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
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

            case "sheet2":      // sheet2 init
                with (sheetObj) {
					// 높이 설정
					style.height = 382;
					// 길이설정
					SheetWidth = mainTable.clientWidth;
					
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(2, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)
					
					var HeadTitle = "|SUN";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"Status");
					InitDataProperty(0, cnt++ , dtData,      		80,		daCenter,	false,		"secondholiday",		false,		"",		dfNone,		0,		false,		false, 		-1, 	false, 		false);
					
					CountPosition = 0;		// 건수 정보를 표시하지 않음.

               }
                break;


            case "sheet3":      // sheet4 init
                with (sheetObj) {
					// 높이 설정
					style.height = 382;
					// 길이설정
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
					InitColumnInfo(14, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false);
					
					var HeadTitle = "||Seq.|DATE|HOLIDAY";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,			30,		daCenter,		false,		"del_chk");
					InitDataProperty(0, cnt++ , dtSeq,    			45,		daCenter,		false,		"Seq");
					InitDataProperty(0, cnt++ , dtData,      		85,		daCenter,		false,		"hol_dt_in",		true,		"",		dfEngUpKey,			0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,      		120,	daLeft,			false,		"hol_desc",			true,		"",		dfEngUpKey,			0,			false,		true,	30);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"hol_yr",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"cnt_cd",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"rgn_cd",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"ste_cd",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"loc_cd",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"hol_dt",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"upd_dt",			false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"upd_ofc_cd",		false,		"",		dfNone,				0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,      		120,	daLeft,			false,		"upd_usr_nm",		false,		"",		dfNone,				0,			false,		true);
					
					//데이터 Validation(영문 대문자만 입력되도록 설정함)
					InitDataValid(0,  "hol_desc", vtEngUpOther, " ");
					
					CountPosition = 0;		// 건수 정보를 표시하지 않음.
			  	}
                break;;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
		
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

           case IBSEARCH:      // 조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet3") {
						
						//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						setParameters(SEARCH);
											
						//2.조회전 결과필드들을 Empty 시킨다.
						clearResultControls();
						
						//3.조회전 Update User 정보필드들을 Empty 시킨다.
						clearUpdateUserControls();
												
						//4.조회조건으로 조회실행
			            var sXml = sheetObj.GetSearchXml("EES_DMT_1007GS.do" , FormQueryString(formObj));
						
						//5.조회후 결과처리(조회된 결과를 각 결과 그리드에 매핑시킨다.)
			            var arrXml = sXml.split("|$$|");
			            
			            if (arrXml.length > 0) sheetObjects[0].LoadSearchXml(arrXml[0]);	//휴일날짜1
						if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);	//휴일날짜2
						if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);	//조회된 휴일정보
						
						//조회된 결과가 실패하면 종료시킨다.
						if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F") return;
						
						//조회 후에는 Grid 내 버튼을 모두 활성화 시킨다.
						changeBtnInGrid(true);
						
						//Save, Down Excel 버튼을 활성화 시킨다. =============
						ComBtnEnable("btn_Save");
						ComBtnEnable("btn_DownExcel");
						//==================================================
						
						//조회필드를 비활성화시킨다.
						disableSearchControls();
												
						//5-1.조회된 결과가 있다면
						if (sheetObj.RowCount > 0) {
							//재조회요청일 경우 조회된 모든 결과를 입력상태로 변경한다.
							if (ComGetObjValue(formObj.retry) == "Y") {
								for (var row = sheetObj.HeaderRows ; row <= sheetObj.LastRow ; row++) {
									sheetObj.RowStatus(row) = "I";
								}
								//최종으로 갱신한 사용자의 정보를 보여준다.
								ComClearObject(formObj.upd_dt);
								ComClearObject(formObj.upd_ofc_cd);
								ComClearObject(formObj.upd_usr_nm);
								
								ComShowCodeMessage('DMT00111');
							} 
							else {
								//최종으로 갱신한 사용자의 정보를 보여준다.
								ComSetObjValue(formObj.upd_dt, 		sheetObj.CellValue(1, UPD_DT));
								ComSetObjValue(formObj.upd_ofc_cd, 	sheetObj.CellValue(1, UPD_OFC_CD));
								ComSetObjValue(formObj.upd_usr_nm, 	sheetObj.CellValue(1, UPD_USR_NM));
							}
						} 
						//5-2.조회된 결과가 없고, 재조회 요청이 아닐 경우 재조회를 한다.
						else {
							if (ComGetObjValue(formObj.retry) == "") {
								if (ComShowCodeConfirm("DMT06015")) {
									ComSetObjValue(formObj.retry, "Y");	//재조회 플래그를 활성화 시킨다.
									doActionIBSheet(sheetObj, formObj, sAction);
								}
							}
						}
					}
				};						
                break;
				
           case IBSEARCH_WKND:      // 선택한 COUNTRY 에 대한 WEEKEND 타입 조회

				if (sheetObj.id == "sheet3") {
					var wkndTpCd = "";
					
					//1.선택된 COUNTRY 정보가 있다면 WEEKEND TYPE 을 조회한다.
					//  그렇지 않을 경우, 조회하지 않고 기본값으로 SAT/SUN 를 설정한다.
					if (ComTrim(comboObjects[0].Text) != "") {
						//2.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						setParameters(SEARCH02);
						
						//3.조회조건으로 조회실행
			            var sXml = sheetObj.GetSearchXml("EES_DMT_1007GS.do", FormQueryString(formObj));
						
						//4.조회후 결과처리
						//4-1.휴일 타입을  변경해준다
						wkndTpCd = ComGetEtcData(sXml, "wknd_tp_cd");
					}
					ComSetObjValue(formObj.wknd_tp_cd, wkndTpCd);
					
					//4-2.휴일 그리드제목을  변경해준다.
					setHolidayTitle();									
				}

				break;

			case IBSAVE:        // 저장
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet3") {

						//1.데이터 저장전 필수항목을 채운다.
						fillMandatory();
						
						//2.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
						setParameters(MULTI);
						
						//3.입력받은 정보로 저장실행
						sheetObj.DoSave("EES_DMT_1007GS.do", FormQueryString(formObj));
					}
				};				
				break;

			case IBINSERT:      // 입력
				if (sheetObj.id == "sheet3") { 
					sheetObj.DataInsert(-1);
				};
				break;
				
			case IBDELETE:		// 삭제
				if (sheetObj.id == "sheet3") { 
			        var delrows = sheetObj.FindCheckedRow("del_chk");
					
			        //맨 상위 체크박스의 선택부분을 해제시킨다. =========================
			        sheetObj.CheckAll("del_chk") = 0
			        //==============================================================
			        
			        if (ComTrim(delrows).length == 0) return;
					
					delrows = delrows.substring(0, delrows.length-1);
			        var arrRow = delrows.split(ROWMARK);
			        for (var i = arrRow.length-1 ; i >= 0 ; i--) {
						if (sheetObj.RowStatus(arrRow[i]) == 'I') {
							sheetObj.RowDelete(arrRow[i], false);
						}
						else {
							sheetObj.RowStatus(arrRow[i]) = 'D';
							sheetObj.RowHidden(arrRow[i]) = true;
						}
			        }
				};
				break;
				
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet3") {
					sheetObj.SpeedDown2Excel(-1, false, false, '', '', false, false, '', false, 'del_chk');
				}; 
				break;
				
			case IBLOADEXCEL:	// EXCEL UPLOAD
				if (sheetObj.id == "sheet3") {
					sheetObj.LoadExcel();
					setAllFormatDate();
				}; 
				break;

			case IBCOPYROW:	// EXCEL UPLOAD
				if (sheetObj.id == "sheet3") {
					var row = sheetObj.DataCopy();
					sheetObj.RowStatus(row) = "I";
				}; 
				break;			
        }
    }

	// 조회조건필드인 Country, Region Combo 데이터 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboAction) {
        sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
        switch(sAction) {
			case IBSEARCH:      // 조회

				if (sheetObj.id == "sheet1") {

					//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
					setParameters(sComboAction);
					
					//2.조회조건으로 조회실행
					var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
					
					//3.조회후 결과처리
					var comboDatas;
					var comboItems;
					var comboItem;
					switch(sComboAction) {
						
						//3-1.Region 조회(모든 Region 목록)
						case SEARCH01:
    						comboItems = ComGetEtcData(sXml, REGION).split(ROWMARK);
							comboObjects[1].RemoveAll();
							addComboItem(comboObjects[1],comboItems);						
							break;
						
						//3-2.Country 조회(모든 Country 목록)
						case SEARCH02:
    						comboItems = ComGetEtcData(sXml, COUNTRY).split(ROWMARK);
							comboObjects[0].RemoveAll();
							addComboItem(comboObjects[0],comboItems);						
							break;
													
						//3-3.Country 항목 선택에 따른 해당 Region 조회
						case SEARCH03:
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							if (comboObjects[0].Text == "CA" || comboObjects[0].Text == "US") {
								comboDatas = ComGetEtcData(sXml, STATE);
							} else {
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								//Region 콤보 Empty 상태로 초기화
								comboObjects[1].RemoveAll();									
								comboItems = comboDatas.split(ROWMARK);
								addComboItem(comboObjects[1],comboItems);	
							}			
							break;
													
						//3-4.Location 항목 입력에 따른 상위 Country, Region 조회
						case SEARCH04:
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
							}
							//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
							var locCd = ComTrim(ComGetObjValue(formObj.location)).substring(0, 2);
							if (locCd == "CA" || locCd == "US") {
								comboDatas = ComGetEtcData(sXml, STATE);
							} else {
								comboDatas = ComGetEtcData(sXml, REGION);
							}
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[1],comboItems);
							} else {
								ComShowCodeMessage("DMT00110", "Location");
								ComClearObject(formObj.location);
								ComSetFocus(formObj.location);
							}
							break;
													
						//3-5.Region 항목코드로 상위(Country) 정보를 조회한다.
						case SEARCH13:						
						//3-6.State 항목코드로 상위(Country) 정보를 조회한다.
						case SEARCH17:
							//응답 XML 에서 Country 정보를 추출해서 목록에서 선택해준다.
							comboDatas = ComGetEtcData(sXml, COUNTRY);
							if (comboDatas != undefined) {
								comboItems = comboDatas.split(ROWMARK);
								setComboItem(comboObjects[0],comboItems);
								
								//응답 XML 에서 Region or State 정보를 추출해서 목록에서 선택해준다.
								if (comboObjects[0].Text == "US" || comboObjects[0].Text == "CA") {
									comboDatas = ComGetEtcData(sXml, STATE);
								}
								else {
									comboDatas = ComGetEtcData(sXml, REGION);
								}
								if (comboDatas != undefined) {
									comboItems = comboDatas.split(ROWMARK);
									setComboItem(comboObjects[1],comboItems);
								}							
							}
							else {
								ComShowCodeMessage("DMT00110", "Region");
								comboObjects[1].Text = "";
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
    function validateForm(sheetObj,formObj,sAction) {

		//필수항목에 데이터가 입력되었는지 확인한다.
		if (sheetObj.id == 'sheet3') {
			switch(sAction) {
				
				//DATE 필드는 중복되어서는 안된다.
				case IBSAVE:
	        		var dupRows = sheetObj.ColValueDupRows(HOL_DT_IN);
	        		if(dupRows != "") {
		        		var arrRow 	= dupRows.split(",");
						var dupDt 	= sheetObj.CellValue(arrRow[0],HOL_DT_IN);
			        	ComShowCodeMessage('DMT00109',dupDt);
						sheetObj.SelectRow = arrRow[0];
			        	return false;
	        		}
					break;

				//조회시 Country 는 반드시 선택되어야 한다.					
				case IBSEARCH:
					if (comboObjects[0].Text == "") {
						ComShowCodeMessage("COM12113", "Country");
						return false;
					};
					break;
			}
		}
		
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
	    var formObject = document.form
		
		switch(comboNo) {
			//Country 콤보  초기화
			case 1:
				with (comboObj) { 
					MultiSelect = false; 
					SetColAlign("left|left");
					SetColWidth("30|200");
					FontName 	= "Tahoma";					
					DropHeight 	= 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
		    	}
				break;
			
			//Region 콤보 초기화
			case 2: 
				with (comboObj) { 		
					MultiSelect = false; 
					SetColAlign("left|left");        
					SetColWidth("50|190");
					FontName 	= "Tahoma";
					DropHeight 	= 160;
					
					ValidChar(2, 2);	// 영어대문자 사용
				}
				break;			
	     } 
	}
	 
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;
		
		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
		}
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
		
		//Country 에 소속된 하위 Regino or State 정보를 조회한다.
		doActionIBCombo(sheetObj, formObj, IBSEARCH, SEARCH03);
		
		//Country 정보가 변경될 경우 Country 에 대한 WEEKEND TYPE 을 조회후 재설정한다.
		doActionIBSheet(sheetObjects[2], formObj, IBSEARCH_WKND);
	}

	/*
	 * Region or State 조회필드가 변경될 경우 Location 조회필드를 초기화 해주는 함수
	 */	
	function cboRegion_OnChange(comboObj, Index_Code, Text) {
		var formObj 	= document.form;
		var sheetObj 	= sheetObjects[0];
		var rgnCd 		= comboObj.Text;
		
		switch(rgnCd.length) {
			case 2: //State Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.ste_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH17);
				break;
				
			case 3:	//Region Code 로 상위 코드를 찾는다.
				ComSetObjValue(formObj.rgn_cd, rgnCd);
				doActionIBCombo(sheetObj,formObj,IBSEARCH,SEARCH13);
				break;
		}
		
		//Region 이 변경될 경우 Location 정보를 지운다.
		if (isClearLocation) clearLocation();
	}
	
	/*
	 * Location 조회필드에서 Enter Key 가 입력될 경우 Location 을 포함하는 Country 와 Region or State 정보를 조회하는 함수
	 */		
	function checkLocation() {
		var formObj = document.form;
    	if (ComTrim(ComGetObjValue(formObj.location)).length == 5) {
			var locCd = ComTrim(ComGetObjValue(formObj.location));
    		if (locCd.length == 5) {
				isClearLocation = false;
				//Location 상위(Country, Region or State) 정보를 조회한다.
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH,SEARCH04);
				//Location 조회로 인해서 Country 정보가 변경될 경우 Country 에 대한 WEEKEND TYPE 을 조회후 재설정한다.
				doActionIBSheet(sheetObjects[2],formObj,IBSEARCH_WKND);
				isClearLocation = true;
			}
    	}		
	}
			
	/**
	 * 휴일조회결과 그리드에서 DATE 필드에 입력된 정보 중 월(MM : 숫자) 부분을 영문으로 변환하여주는 함수
	 */		 
	function sheet3_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		if (sheetObj.ColSaveName(Col) == "hol_dt_in") {
			setFormatDate(Row);
		}
	}
	
	/**
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
		
		sheetObjects[0].InitHeadRow(0, sheet1Title, false);
		sheetObjects[1].InitHeadRow(0, sheet2Title, false);
	}
						
	/*
	 * 조회필드정보를 입력화면의 조회필드값으로 저장한다.
	 */		
	function setParameters(sAction) {
		var formObj = document.form;
		
		ComSetObjValue(formObj.hol_yr, ComGetObjValue(formObj.year));		//Year
		ComSetObjValue(formObj.cnt_cd, comboObjects[0].Text);				//Country
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));	//Location	
		ComSetObjValue(formObj.loc_cd, ComGetObjValue(formObj.location));	//Weekend Type
		ComSetObjValue(formObj.f_cmd, sAction);								//Command
	}
	
	/*
	 * 휴일정보 입력시 사용자로부터 입력받지 않는 필수항목의 값을 조회시 사용자로부터 입력받은 값으로 채운다.
	 */	
	function fillMandatory() {
		var formObj = document.form;
		var sheetObj = sheetObjects[2];
		for (var row = 1 ; row <= sheetObj.RowCount ; row++) {
			if (sheetObj.RowStatus(row) == 'I') {
				sheetObj.CellValue(row, HOL_YR) = ComGetObjValue(formObj.hol_yr);
				sheetObj.CellValue(row, CNT_CD) = ComGetObjValue(formObj.cnt_cd);
				sheetObj.CellValue(row, RGN_CD) = ComGetObjValue(formObj.rgn_cd);
				sheetObj.CellValue(row, STE_CD) = ComGetObjValue(formObj.ste_cd);
				sheetObj.CellValue(row, LOC_CD) = ComGetObjValue(formObj.loc_cd);
				
				var hol_dt = sheetObj.CellValue(row, HOL_DT_IN);
				var day = hol_dt.substring(0, 2);
				var month = ComTrim(hol_dt.substring(2));
				
				for (var i = 1 ; i < MonthOfYear.length ; i++) {
					if (MonthOfYear[i] == month) {
						if (i < 10) month = "0" + month;
						break;
					}
				}
				sheetObj.CellValue(row, HOL_DT) = sheetObj.CellValue(row, HOL_YR) + "-" + month + "-" + day;
			}
		}
	}
	
	function initAxonControl() {  
	    //Axon 이벤트 처리1. 이벤트catch 
		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListener('beforedeactivate', 	'obj_deactivate', 	'location');
		axon_event.addListener('keydown', 			'ComKeyEnter', 		document.form);
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	document.form); //- 키보드 입력할때
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
	 * 조회필드 비활성화 
	 */		
	function disableSearchControls() {
		var formObj = document.form;
		comboObjects[0].Enable = false;
		comboObjects[1].Enable = false;
		with (formObj) {
			ComEnableManyObjects(false, location, year);
			location.className 	= 'input2';
			year.className 		= 'input2';
		}	
	}
	
	/*
	 * 조회필드 활성화 
	 */		
	function enableSearchControls() {
		var formObj 		= document.form;
		var cboCountryObj 	= comboObjects[0];
		var cboRegionObj 	= comboObjects[1];
		
		cboCountryObj.Enable = true;
		cboRegionObj.Enable  = true;
		
		with (formObj) {
			ComEnableManyObjects(true, location, year);
			location.className 	= 'input';
			year.className 		= 'input';
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
		var formObj 		= document.form;
		var cboCountryObj 	= comboObjects[0];
		var cboRegionObj 	= comboObjects[1];
		
		cboCountryObj.Text 	= "";		//Country ComboBox
		cboRegionObj.RemoveAll();		//Region or State ComboBox
		Region.innerHTML 	= "Region";	//Region Caption
		ComSetObjValue(formObj.hol_yr, 		new Date().getFullYear());	//Year ComboBox
		ComSetObjValue(formObj.year, 		new Date().getFullYear());	//Year ComboBox
		ComSetObjValue(formObj.cnt_cd, 		"");
		ComSetObjValue(formObj.rgn_cd, 		"");
		ComSetObjValue(formObj.ste_cd, 		"");
		ComSetObjValue(formObj.loc_cd, 		"");
		ComSetObjValue(formObj.location, 	"");
		ComSetObjValue(formObj.wknd_tp_cd, 	"");
	}
	
	/*
	 * 휴일조회결과필드 초기화
	 */		
	function clearResultControls() {
		sheetObjects[0].RemoveAll();//첫번째 휴일정보 초기화
		sheetObjects[1].RemoveAll();//두번째 휴일정보 초기화
		sheetObjects[2].RemoveAll();//조회된 휴일정보 초기화
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
	 * Update Date/OFC/Name 필드정보 초기화
	 */		
	function clearUpdateUserControls() {
		var formObj = document.form;
		ComSetObjValue(formObj.upd_dt, "");
		ComSetObjValue(formObj.upd_ofc_cd, "");
		ComSetObjValue(formObj.upd_usr_nm, "");
	}
	
	/*
	 * Weekend 그리드 제목 초기화
	 */		
	function initWeekendType() {
		var formObj = document.form;
		ComSetObjValue(formObj.wknd_tp_cd, "");
		setHolidayTitle();
	}	
	
	/*
	 * html컨트롤 이벤트 초기화 
	 */	
	function initControl() {
		var formObj = document.form;
		
		//조회필드 초기화
		initSearchControls();
		
		//조회필드 활성화
		enableSearchControls();		
		
		//조회결과 정보 초기화
		clearResultControls();
		
		//휴일그리드 제목 초기화
		initWeekendType();
		
		//Update User 정보 초기화
		clearUpdateUserControls();
		
		//Region 콤보를 초기화 시켜준다.(모든 Region 정보 조회)
		doActionIBCombo(sheetObjects[0], formObj, IBSEARCH, SEARCH01);
		
		//Grid 내 버튼을 모두 비활성화 시킨다.
		changeBtnInGrid(false);
		
		//Save, Down Excel 버튼을 비활성화 시킨다. ==================
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_DownExcel");
		//=========================================================
	}	
	 
    /**
     * Grid 내에 있는 버튼의 상태를 변경해주는 함수
     */	
	function changeBtnInGrid(flag) {

		if (flag) {
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowCopy");
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_LoadExcel");			
		} else {
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowCopy");
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_LoadExcel");			
		}
	}
      
   /**
 	* 사용자의 Holiday Date 컬럼의 입력을 DDMON 으로 변환시켜주는 함수
 	*/
 	function setAllFormatDate() {
		var sheetObj 	= sheetObjects[2];
		
		with(sheetObj) {
			for (var row = HeaderRows ; row <= LastRow ; row++) {
				setFormatDate(row);
			}
		}
 	}
 	
   /**
	* 사용자의 Holiday Date 컬럼의 입력을 DDMON 으로 변환시켜주는 함수
	*/
	function setFormatDate(selectedRow) {
		var formObj		= document.form;
		var sheetObj 	= sheetObjects[2];
		
		var inDate		= sheetObj.CellValue(selectedRow, "hol_dt_in");
		
		//1.입력된 값은 DDMM 일 수도 있고, DDMON 형식일 수도 있다. 그에 맞는 자리수가 입력되었는지 체크한다.
		if (inDate.length < 4 || inDate.length > 5) {
			ComShowCodeMessage("DMT00165", "DATE");
			sheetObj.CellValue2(selectedRow, "hol_dt_in") = "";
			sheetObj.SelectCell(selectedRow, "hol_dt_in");
			return false;
		}
	
		var orgYear 		= ComGetObjValue(formObj.hol_yr);
		var orgDay	 		= inDate.substring(0, 2);
		var orgMonth 		= inDate.substring(2);
		var tmpMonth		= "";
		var displayDate		= "";
		
		//입력된 월의 형식이 MM 일 경우
		if (ComIsNumber(orgMonth) && ComIsMonth(orgMonth)) {
			tmpMonth 	= orgMonth;
			//입력된 DATE의 MM 을 JAN,FEB,... 로 변환한다.
			displayDate = orgDay + MonthOfYear[ComParseInt(orgMonth)];
		}
		else if (ComIsAlphabet(orgMonth)) {
			for (var i = 1 ; i <= MonthOfYear.length ; i++) {
				if (MonthOfYear[i] == orgMonth) {
					tmpMonth = i + "";
					tmpMonth = tmpMonth.length == 1 ? "0" + tmpMonth : tmpMonth;
					break;
				}
			}
		}
		
		//2.입력된 DATE 필드의 값이 유효한 DATE 값인지 체크한다.
		if (!ComIsDate(orgYear + tmpMonth + orgDay)) {
			ComShowCodeMessage("DMT00165", "DATE");
			sheetObj.CellValue2(selectedRow, "hol_dt_in") = "";
			sheetObj.SelectCell(selectedRow, "hol_dt_in");
			return false;			
		}
		
		//4.변환된 DATE 값으로 해당 그리드의 셀을 변경한다.
		if (displayDate != "")
			sheetObj.CellValue2(selectedRow, "hol_dt_in") = displayDate;
		
		return true;
	}
		
	/* 개발자 작업  끝 */