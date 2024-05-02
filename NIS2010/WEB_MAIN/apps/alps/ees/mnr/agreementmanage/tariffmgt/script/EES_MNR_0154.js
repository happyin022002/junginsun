/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0154.js
*@FileTitle : Disposal Tariff Input by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.11
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2010.09.15 장준우
* 1.0 Creation
* 2012.09.11 조경완 [CHM-201220025-01] Location By 조회조건 추가
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
     * @class EES_MNR_0154 : EES_MNR_0154 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0154() {
    	this.processButtonClick	 = processButtonClick;
    	this.setSheetObject 	 = setSheetObject;
    	this.loadPage 			 = loadPage;
    	this.initSheet 			 = initSheet;
    	this.initControl         = initControl;

    	this.obj_blur 			 = obj_blur;
    	this.obj_focus 			 = obj_focus;
    	this.obj_change 		 = obj_change;
    	this.obj_keypress 		 = obj_keypress;
    	this.obj_keyup 			 = obj_keyup;
    	this.obj_keydown 		 = obj_keydown;
    	this.obj_click			 = obj_click;

    	this.doActionIBSheet 	 = doActionIBSheet;
    	this.sheet1_OnChange 	 = sheet1_OnChange;
    	this.sheet1_OnPopupClick = sheet1_OnPopupClick;
    	this.sheet1_OnSaveEnd 	 = sheet1_OnSaveEnd;
    	this.sheet1_OnSearchEnd  = sheet1_OnSearchEnd;
    	this.sheet1_OnLoadExcel	 = sheet1_OnLoadExcel;

    	this.openPopup 		     = openPopup;
    	this.setPopData_Location = setPopData_Location;
    	this.setPopData_Currency = setPopData_Currency;
    	this.validateForm 		 = validateForm;
    	this.clearForm 			 = clearForm;

    }

   	/* 개발자 작업	*/

   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR = 10092543;

	var cntrTpSz = new Array();
	var chssTpSz = new Array();
	var gsetTpSz = new Array();

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;	
	var beforetab = 1;
	
	var comboObjects = new Array();
	var comboCnt = 0; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

     	try {
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

 				case "btn_New":
					ComResetAll();
					setDynamicEqTpszCombo(sheetObjects[0], "U");
					// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
					ComBtnDisable("btn_RowAdd");
					ComBtnDisable("btn_Delete");

					ComSetFocus(formObj.p_trf_eff_yr);
 					break;

 				case "btn_Save":
 					//doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					doActionIBSheet(sheetObjects[0], formObj, IBBATCH);
 					break;

 				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.p_trf_eff_yr);
 					}
 					break;

 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 					} else {
 						ComSetFocus(formObj.p_trf_eff_yr);
 					}
 					break;

 				case "btns_calendar1":
 					var cal = new ComCalendar();
					cal.setDisplayType('year');
					cal.select(formObj.p_trf_eff_yr, 'yyyy');
             	 	break;

				case "btn_LoadExcel":
					doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
				break;

             	case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,"del_chk|last_chk");
					break;
				case "btns_search":	//Form Location. 조회 팝업
 					openPopup("1");
 					break;
 					
 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;

		for(i = 0; i < sheetObjects.length; i++) {
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i], i + 1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		var formObj = document.form;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR); 
		
		initControl();
    }

	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject = document.form
		 		    
	    switch(comboNo) {      
			   default :   
		           with (comboObj) { 
				       SetColAlign("left");	         
					   DropHeight = 200;	 	     
			       }    	   
	           break;	 	
	     } 		
	} 

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;

		switch(sheetid) {
			case "sheet1":
				with(sheetObj) {
					// 높이 설정
					style.height = 420;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel.|Seq.|Year|Quarter||EQ Type|Location|TP/SZ|Currency|Tariff Amount|Remark||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	50,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	"seq_no");

					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"trf_eff_yr",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	"trf_eff_qtr_no",	false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	"mnr_disp_trf_seq",	false,	"",	dfNone,        0,		false,		false);

					InitDataProperty(0, cnt++ , dtCombo,		120,	daCenter,	true,	"eq_knd_cd",		true,	"",	dfNone,        0,		false,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	120,	daCenter,	true,	"loc_cd",			true,	"",	dfEngUpKey,    0,		true,		true, 	5);
					InitDataProperty(0, cnt++ , dtCombo,		120,	daCenter,	true,	"eq_tpsz_cd",		true,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	120,	daCenter,	true,	"curr_cd",			true,	"",	dfEngUpKey,    0,		true,		true, 	3);

					InitDataProperty(0, cnt++ , dtData,			150,	daRight,	false,	"mnr_disp_trf_amt",	true,	"",	dfFloat, 	   2,		true,		true,	13);
					InitDataProperty(0, cnt++ , dtHidden,		350,	daLeft,		false,	"mnr_trf_rmk",		false,	"",	dfEngUpKey,	   0,		true,		true, 	1000);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"complex_pk",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"last_chk",			false,	"",	dfNone,        0,		false,		false);


					InitDataValid(0, "loc_cd",		 vtEngUpOnly);
					InitDataValid(0, "curr_cd",		 vtEngUpOnly);
					InitDataValid(0, "mnr_trf_rmk",	 vtEngOther,   "0123456789-,.() ");

					InitDataCombo(0, "trf_eff_qtr_no", "1/4 QTA|2/4 QTA|3/4 QTA|4/4 QTA", "1|2|3|4");
					InitDataCombo(0, "eq_knd_cd",      "Container|Chassis|M.G.Set", "U|Z|G");

					ShowButtonImage = 0;
					SelectBackColor = MNR_SELECT_BACK_COLOR;

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					//CountPosition = 0;
				}
				break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_MNR_0154GS.do",FormQueryString(formObj));
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
			case IBINSERT:			// 입력
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var Row = sheetObj.DataInsert(-1);
						sheetObj.CellValue2(Row,"trf_eff_yr") = ComGetObjValue(formObj.p_trf_eff_yr);
						sheetObj.CellValue2(Row,"trf_eff_qtr_no") = ComGetObjValue(formObj.p_trf_eff_qtr_no);
						sheetObj.CellValue2(Row,"eq_knd_cd") = ComGetObjValue(formObj.p_eq_knd_cd);
						sheetObj.SelectCell(Row,"eq_tpsz_cd");
					}
				}
				break;
			case IBLOADEXCEL://EXCEL UPLOAD
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true, "mainTable");

				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						sheetObj.LoadExcel(-1);
					}
				}

				ComOpenWait(false, "mainTable");
				sheetObj.WaitImageVisible = true;
				break;
			case IBSAVE:			//저장
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true, "mainTable");

				if(sheetObj.IsDataModified == false) {
					ComShowMessage(sheetObj.MessageText("UserMsg13"));
				} else {
					var saveXml = sheetObj.GetSaveString(false, true);

					if(saveXml != "") {
						if(checkSaveValidation(sheetObj)) {
							if(validateForm(sheetObj, formObj, sAction)) {
								formObj.f_cmd.value = MULTI;
								sheetObj.DoSave("EES_MNR_0154GS.do", FormQueryString(formObj));

								//----------------------------------------------------------------
								// 클라이언트 성능문제로 DoSave 에서 GetSaveXml 방식으로 변경한다.
								//----------------------------------------------------------------
								//var sParam = "f_cmd=" + MULTI +"&"+ saveXml;
								//var sXml = sheetObj.GetSaveXml("EES_MNR_0154GS.do", sParam);
								//sheetObj.LoadSaveXml(sXml);
							}
						}
					}
				}

				ComOpenWait(false, "mainTable");
				sheetObj.WaitImageVisible = true;
				break;
			case IBBATCH:      //저장-BackEndJob
				if(sheetObj.IsDataModified == false) {
					ComShowMessage(sheetObj.MessageText("UserMsg13"));
				} else {
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					var saveXml = sheetObj.GetSaveString(false, true);
					if(saveXml != "") {
						if(checkSaveValidation(sheetObj)) {
							if(validateForm(sheetObj, formObj, sAction)) {
								var sParam = "f_cmd=" + COMMAND01 +"&"+ saveXml;
								var sXml = sheetObj.GetSaveXml("EES_MNR_0154GS.do", sParam);
								var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");

								if (backendJobKey.length > 0) {
									ComSetObjValue(formObj.backendjob_key, backendJobKey);
									sheetObj.RequestTimeOut = 10000;
									timer1 = setInterval(getBackEndJobStatus, 3000);
								}
							} else {
								ComOpenWait(false);
								sheetObj.WaitImageVisible = true;
							}
						} else {
							ComOpenWait(false);
							sheetObj.WaitImageVisible = true;
						}
					} else {
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
				
			case IBCLEAR:      // 초기화 
				MnrWaitControl(true);
				sheetObj.WaitImageVisible=false;	
					
				//Equipment Type/Size Grid Combo Item Setting
				initDynamicEqTpszCd(sheetObj);	
								
				//START 		
				formObj.reset(); 
						
				//콤보 초기화	  
				for(var i = 0; i < comboObjects.length;i++){ 
					comboObjects[i].Code = "-1"; 
					comboObjects[i].RemoveAll();	 	       
				}		 
							
				var sCondition = new Array (		 		 
					//MultiCombo  
					new Array("MnrGenCd","CD00094", "COMMON"),		//QTA
					new Array("MnrGenCd","","CUSTOM9")				//eq_knd_cd
				)				 			
				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
										
				//*** W/O Type		
				var comboDefValue = ""; 	
				if(comboList[0] != null){ 	       
					for(var j = 0; j < comboList[0].length;j++){ 
						var tempText = comboList[0][j].split("|");  
						formObj.p_trf_eff_qtr_no.InsertItem(j, tempText[1] ,tempText[0]);
						if(j == 0){	 	
							comboDefValue = tempText[0];
						}	  	 		 
					}     			  	    
				}  		
				formObj.p_trf_eff_qtr_no.Code = comboDefValue; 
								
				//*** EQ_TYPE	
				if(comboList[1] != null){	
					for(var j = 0; j < comboList[1].length;j++){ 
						var tempText = comboList[1][j].split("|");	  
						formObj.p_eq_knd_cd.InsertItem(j, tempText[1] ,tempText[0]);
							
						if(j == 0){	 	
							comboDefValue = tempText[0];  
						}	 
					}				    
				}	 	
				formObj.p_eq_knd_cd.Code = comboDefValue; 
				
				/* 조회 전 데이터 가공 방지를 위한 버튼 콘트롤 */
    			ComBtnDisable("btn_RowAdd");	
				ComBtnDisable("btn_Delete");	
				
				/* 초기 Focus Setting */
    			ComSetFocus(formObj.p_trf_eff_yr);
																
				//END 
				sheetObj.WaitImageVisible = true; 
				MnrWaitControl(false);  
                break;	
           
           case IBSEARCH_ASYNC01: // 2012.09.11 조경완  Location 조회
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet1") {
						var vLocType = formObj.p_loc_tp.value;
						var vLocCode = formObj.p_loc_cd.value;
						var param = "f_cmd=" + SEARCH + "&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";
					if (vLocType == "RCC") {
						param += "&loc_cd=&rcc_cd=" + vLocCode + "&lcc_cd=";
					} else if (vLocType == "LCC") {
						param += "&loc_cd=&rcc_cd=&lcc_cd=" + vLocCode;
					} else if (vLocType == "SCC") {// SCC는 LOC의 부분집합이다.
						param += "&loc_cd=" + vLocCode + "&rcc_cd=&lcc_cd=";
					}
					
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("COM_ENS_051GS.do", param);
					sheetObj.WaitImageVisible = true;
					
					if (ComGetTotalRows(sXml) < 1) {
						ComShowCodeMessage("MNR00117");
						formObj.p_loc_cd.value = "";
						ComSetFocus(formObj.p_loc_cd);
					} else if (vLocType == "SCC") {
						var aryData = MnrXmlToArray(sXml);
						if (vLocCode != aryData[0][14]) {
							ComShowCodeMessage("MNR00117");
							formObj.p_loc_cd.value = "";
							ComSetFocus(formObj.p_loc_cd);
						}
					}
				}
			}
			break;            
		}
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      // 조회
    			case IBINSERT:		// 추가
    			case IBLOADEXCEL:	// 업로드
					if(formObj.p_trf_eff_yr.value == "") {
						ComShowCodeMessage("MNR00172", "Effective Year");
						ComSetFocus(formObj.p_trf_eff_yr);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
				default :	// do nothing
    		}
    	}

	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		// 저장
	    		case IBBATCH:		// 저장-BackEndJob
	    			// 특정 컬럼 내에 중복된 값이 존재하는지 여부를 확인
	    			// SpaceDupCheck = false;
					// var dupRow =
					// ColValueDup("trf_eff_yr|trf_eff_qtr_no|eq_knd_cd|loc_cd|eq_tpsz_cd",
					// false);
					var dupRow = ColValueDup("complex_pk", false);

					// 중복행이 발견되면 하일라이트 처리하고 메세지 알린후 해당 행을 삭제처리
					if(dupRow != -1) {
						ComShowCodeMessage("MNR00006", "Effective Quarter, EQ Type, TP/SZ, Location");
						SelectCell(dupRow, 0);
						ValidateFail = true;
						return false;
					}

	    			return true;
	    			break;
	    		default : 	// do nothing
    		}
    	}

        return true;
	}
	
	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "eq_knd_cd":
					setDynamicEqTpszCombo(sheetObj, Value, Row);
					break;
				case "loc_cd":		// Grid LOC Code Check
					if(CellValue(Row,Col) != "") {
 						var param = "f_cmd="+SEARCH+"&loc_cd="+CellValue(Row,Col)
 								  + "&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&rcc_cd=&lcc_cd=&loc_state=";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_051GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) != 1 ) {
							SelectCell(Row,Col);
							ComShowCodeMessage("MNR00117");
 							CellValue2(Row,Col) = "";
 							return false;
						}
					}
					break;
				case "curr_cd":		// Grid Currency Code Check
					if(CellValue(Row,Col) != "") {
 						var param = "f_cmd="+SEARCH+"&curr_cd="+CellValue(Row,Col);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_N13GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) != 1 ) {
							SelectCell(Row,Col);
							ComShowCodeMessage("MNR00118");
 							CellValue2(Row,Col) = "";
 							return false;
						}
					}
					break;
			}
 		}

 		return true;
 	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "loc_cd":	// Location Pop-up
					openPopup("1", Row, Col);
					break;
				case "curr_cd":	//Currency Pop-up
					openPopup("2", Row, Col);
					break;
			}
 		}
    }

    /**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("MNR00023");
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	// 조회 후 데이터 가공을 위한 버튼 콘트롤
    	ComBtnEnable("btn_RowAdd");
		ComBtnEnable("btn_Delete");
    }

    /**
	 * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event
	 * @param sheetObj
	 */
	function sheet1_OnLoadExcel(sheetObj) {
		var formObj = document.form;

    	with(sheetObj) {
    		var vTrfEffYr  = ComGetObjValue(formObj.p_trf_eff_yr);
    		var vTrfEffQtr = ComGetObjValue(formObj.p_trf_eff_qtr_no);
    		var vEqKndCd   = ComGetObjValue(formObj.p_eq_knd_cd);

    		for(var i = HeaderRows; i <= RowCount; i++) {
    			if(RowStatus(i) == "I") {
					CellValue2(i,"trf_eff_yr") = vTrfEffYr;
					CellValue2(i,"trf_eff_qtr_no") = vTrfEffQtr;
					CellValue2(i,"eq_knd_cd") = vEqKndCd;
    			}
    		}
    	}
	}
			
	/**
	* EQ_TYPE 콤보 이벤트
	*/				
	function p_eq_knd_cd_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;	
		setDynamicEqTpszCombo(sheetObjects[0], Index_Code);			
	}	
	
	/**
	 * 저장처리 전에 입력항목에 대한 유효성을 검사한다.
	 */
    function checkSaveValidation(sheetObj) {
		with(sheetObj) {
			for(var i = HeaderRows; i <= LastRow; i++) {
				if(RowStatus(i) == "I" && CellValue(i, "last_chk") != "OK") {
					for(var j = 0; j <= LastCol; j++) {
						var saveName = ColSaveName(j);

						if(/loc_cd|curr_cd/.test(saveName)) {
							var index = FindText(j, CellText(i, j));
							if(index == -1 || index == i) {
								if(!sheet1_OnChange(sheetObj, i, j, CellValue(i, j))) {
									CellValue2(i, "last_chk") = "Fail";
									return false;
								} else if(saveName == "curr_cd") {
									CellValue2(i, "last_chk") = "OK";
								} else {
									CellValue2(i, "last_chk") = "Hold";
								}
							} else {
								if(saveName == "curr_cd") {
									CellValue2(i, "last_chk") = "OK";
								} else {
									CellValue2(i, "last_chk") = "Hold";
								}
							}
						}
					}
				}

				if(RowStatus(i) != "R") {
					CellValue2(i, "complex_pk") = CellValue(i, "trf_eff_yr") + CellValue(i, "trf_eff_qtr_no")
												+ CellValue(i, "eq_knd_cd")  + CellValue(i, "loc_cd")
												+ CellValue(i, "eq_tpsz_cd");
				}
			}

			if(sheetObj.IsDataModified == false) {
				ComShowMessage(sheetObj.MessageText("UserMsg13"));
				return false;
			}
		}

		return true;
    }

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;
    	
    	if ( type == "1" ) { //
    		 switch(formObj.p_loc_tp.value) {
    		 	case "RCC" :    //RCC
    		 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    		 		break;
    		 	
    		 	case "LCC" :     //LCC
    		 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    		 		break;
    		 	
    		 	case "SCC" :     //SCC
    		 		ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    		 		break;
    		 	default :          //do nothing

            }
            
            if(Row != undefined && Col != undefined){
            	ComOpenPopup('/hanjin/COM_ENS_051.do', 700, 460, 'setPopData_Location', '1,0,1,1,0,0,0,0', true, false, Row, Col, 0);
            }
    	} else if ( type == "2" ) {
			ComOpenPopup('/hanjin/COM_ENS_N13.do', 500, 420, 'setPopData_Currency', '1,0,1', true, false, Row, Col, 0);
    	}

    	return;
    }

  	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Location(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);

				switch(sName) {
					case "loc_cd":
						CellValue2(Row, sName) = aryPopupData[0][3]; //LOC
						break;
					default :	//do nothing
				}
			}
		}
	}

	/**
	 * Currency Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);
				switch(sName) {
					case "curr_cd":
						CellValue2(Row, sName) = aryPopupData[0][2]; //Currency
						break;
					default :	//do nothing
				}
			}
		}	
	}

	/**
	 * EQ_TYPE별 타입사이즈를 조회해서 각 배열에 담는다.
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind","");

		if(arrXml != null) {
			for(var i = 0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}

	/**
	 * Equipment Type/Size Grid Combo Item Setting
	 */
	function setDynamicEqTpszCombo(sheetObj, eqKndCd, rowIdx) {
		var eqTpSzAry = new Array();

		if(eqKndCd == "U") {
			eqTpSzAry = cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry = chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry = gsetTpSz;
		}

		if(eqTpSzAry.length > 0) {
			var eqTpSzStr = eqTpSzAry.toString().replace(/,/g, "|");

			if(rowIdx) {
				sheetObj.CellComboItem(rowIdx, "eq_tpsz_cd", eqTpSzStr, eqTpSzStr);
			} else {
				sheetObj.InitDataCombo(0, "eq_tpsz_cd", eqTpSzStr, eqTpSzStr);
			}
		}
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		formObj.f_cmd.value = COMMAND02;
		var sXml = sheetObj.GetSearchXml("EES_MNR_0154GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");

		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer1);
		} else if (jobState == "4") {
			ComShowCodeMessage("MNR00344");
			ComOpenWait(false);
			sheetObj.WaitImageVisible = true;
			clearInterval(timer1);
		} else if (jobState == "5") {
			ComShowCodeMessage("MNR00345");
			clearInterval(timer1);
		}
	}

	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		ComShowCodeMessage("MNR00023");
    	formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("EES_MNR_0154GS.do",FormQueryString(formObj));
		ComOpenWait(false);
		sheetObj.WaitImageVisible = true;
	}

  	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 * @deprecated 2009.06.22 현재 사용되지 않는다.
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	
	    // Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',   		'obj_change',  	formObj); //- 변경될때.
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 클릭하였을 때
  	}
  	
  	function obj_change() {
  		var obj = event.srcElement;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		switch (obj.name) {
			case "p_loc_tp": // Location Type
				formObj.p_loc_cd.value = "";
				var tabObj = tabObjects[0];
				
				sheetObj.RemoveAll();
					
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_Delete");

				if (obj.value == "") {
					formObj.p_loc_cd.readOnly = true;
					formObj.p_loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
				} else {
					formObj.p_loc_cd.readOnly = false;
					formObj.p_loc_cd.className = "input";
					ComEnableObject(formObj.btns_search, true);
		
					ComSetNextFocus(obj);
				}
				break;
		
			case "p_loc_cd": // Location Code
				if (ComTrim(obj.value) != "") {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
				}
				break;
	
		}

	}

  	

	// 이벤트 중복방지 변수
	var preEventType = null;

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur() {
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name) {
	    	case "p_trf_eff_yr":
  				// Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        default: // do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
	    } else {
	    	// 마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}
	
	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
  		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
  	}

  	/**
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "p_trf_eff_yr":
  				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}

   	/**
     * Key-Down Event 처리
     */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if(vKeyCode == 13) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

   	/**
     * Click Event 처리
     */
   	function obj_click() {
   		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "p_cre_usr_id":
  				if(obj.value != "") {
  					//사용자정보 화면을 팝업한다.
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	//2. 이벤트처리함수 -- End

	/* 개발자 작업  끝 */