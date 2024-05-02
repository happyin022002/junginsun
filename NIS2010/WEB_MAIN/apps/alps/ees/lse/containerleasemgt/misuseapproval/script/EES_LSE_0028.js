/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0028.js
*@FileTitle : Mis Use In & Out Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
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
     * @class EES_LSE_0028 : EES_LSE_0028 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0028() {
    	this.processButtonClick 	= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
		this.loadPage 				= loadPage;
		this.initControl 			= initControl;
		this.obj_keydown 			= obj_keydown;
		this.obj_mouseover			= obj_mouseover;
		this.obj_click				= obj_click;
		this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnChange 		= sheet1_OnChange;
		this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;
		this.sheet1_OnValidation 	= sheet1_OnValidation;
		this.sheet1_OnMouseMove     = sheet1_OnMouseMove;
		this.sheet1_OnClick 		= sheet1_OnClick;
		this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
		this.combo1_OnBlur 			= combo1_OnBlur;
		this.combo1_OnChange 		= combo1_OnChange;
		this.openPopup 				= openPopup;
		this.setPopData_Agreement 	= setPopData_Agreement;
		this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
    }

   	/* 개발자 작업	*/
	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	//파일업로드를 사용하기 위한
	var uploadObjects = new Array();
	var uploadCnt = 0;

	//파일Seq저장변수 (추가될때 )
	var uploadFileSeq  = "";
	var fileUploadFlag = false;
	var fileSaveFlag = false;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var comboObject = comboObjects[0];

         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

				case "btn_retrive":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

				case "btn_new":
					ComResetAll();
					sheetObject.ColHidden("sheet1_agmt_no") = false;
					/* Approval Number 조회 */
    				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
					ComSetFocus(comboObject);
				break;

				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
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
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * IBUpload Object를 uploadObjects 배열에 등록
	 * 배열은 소스 상단에 정의
	 */
	function setUploadObject(uploadObj){
		uploadObjects[uploadCnt++] = uploadObj;
	}

	function initUpload(uploadObj, uploadNo) {
		uploadObj.Files = "";
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

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }

	    ComConfigUpload(uploadObjects[0], "/hanjin/LSE_INTGS.do");
    }

    /**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

        /* Axon Control Setting*/
    	initControl();

    	/* Approval Number 조회 */
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.combo1);
    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
		axon_event.addListenerForm('keydown',		'obj_keydown',		formObj); 	//- 키 눌렸을때
		axon_event.addListenerForm('mouseover',		'obj_mouseover',	formObj); 	//- 마우스가 객체위로 갈때
		axon_event.addListenerForm('click',			'obj_click',		formObj); 	//- 클릭하였을 때
  	}

   	/**
     * Key-Down Event 처리
     */
   	function obj_keydown() {
   		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "agmt_seq":
		  		if ( vKeyCode == 13 ) {
		  			//do nothing
		  		}
		  		break;

  			case "apro_rmk":
				if (vKeyCode != 8 && ComGetLenByByte(obj) > 200) {
  					ComShowCodeMessage("LSE01024");
  					//ComShowMessage("입력한 Remarks의 길이가 200자를 초과하였습니다.");
  					return false;
  				}
  		}
   	}

   	/**
     * Mouse-Over Event 처리
     */
   	function obj_mouseover() {
		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		if(obj.name == "rqst_usr_id") {
  			obj.style.cursor = obj.value != "" ? "Hand" : "Arrow";
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
  			case "apro_usr_id":
  			case "rqst_usr_id":
  				if(obj.value != "") {
  					//사용자정보 화면을 팝업한다.
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	//2. 이벤트처리함수 -- End

  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetId = sheetObj.id;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
                	var prefix = sheetId +"_";
                    // 높이 설정
                    style.height = 210;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

                    var HeadTitle = "|* APP Mode |Approval No.|* APP AGMT No. |* APP AGMT No. |APP\nLease Term||CNTR No.|AGMT No.|TP/SZ|Lease\nTerm|MVMT|POD|POL|MU O/I Date|MU By / From|Yard|Per Diem|Lift On\nCharge|Liable Party|Request Reason|Request File Attachment||APP/REJ Reason|APP/REJ File Attachment|";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	prefix +"ibflag");
                    InitDataProperty(0, cnt++ , dtCombo,     	80,    	daCenter,  	true,   prefix +"mss_usd_apro_mod_cd",	false,		"",      dfNone,		0, true, 	false);
                    InitDataProperty(0, cnt++ , dtData,     	150,    daLeft,  	true,   prefix +"apro_no",    			false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	40,    	daCenter,  	true,   prefix +"apro_agmt_cty_cd",     false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtPopupEdit,   	80,   	daCenter,  	true,   prefix +"apro_agmt_seq",     	false,      "",      dfNone,		0, false, 	false, 6);
                    InitDataProperty(0, cnt++ , dtData,      	80,   	daCenter,  	true,   prefix +"apro_lstm_cd",     	false,      "",      dfNone,		0, false, 	false);

                    InitDataProperty(0, cnt++ , dtHidden,      	80,    	daCenter,  	true,   prefix +"rqst_no",     			false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   prefix +"cntr_no",     			false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	100,   	daCenter,  	true,   prefix +"agmt_no",     			false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,   prefix +"cntr_tpsz_cd",     	false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,   prefix +"lstm_cd",     			false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  	true,   prefix +"mvmt_sts_cd", 			false,      "",     dfEngUpKey,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  	true,   prefix +"pod_cd", 				false,      "",     dfEngUpKey,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    daCenter,  	true,   prefix +"pol_cd", 				false,      "",     dfEngUpKey,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	80,    	daCenter,  	true,   prefix +"mss_usd_dt",  			false,      "",      dfDateYmd,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	240,   	daLeft,  	true,   prefix +"mss_usd_fm_nm",     	false,      "",      dfNone,		0, false, 	false);
		    		InitDataProperty(0, cnt++ , dtData,      	60,    	daCenter,  	true,   prefix +"mss_use_plc_nm", 		false,      "",      dfNone,		0, false, 	false);
                    InitDataProperty(0, cnt++ , dtData,      	70,    	daRight,  	true,   prefix +"pd_chg_rt_amt",      	false,      "",      dfNullFloat,	2, false, 	false, 8);
                    InitDataProperty(0, cnt++ , dtData,      	70,   	daRight,  	true,   prefix +"lft_chg_rt_amt",     	false,      "",      dfNullFloat,	2, false, 	false, 8);
                    InitDataProperty(0, cnt++ , dtData,      	240,   	daLeft,  	true,   prefix +"libor_pty_nm",   		false,      "",      dfNone,		0, false, 	false);

					InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		false,	prefix +"rqst_rsn_desc",		false,		"",		dfNone,			0, false,	false);
                    InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		false,	prefix +"rqst_file_sav_nm",		false,		"",		dfNone,			0, false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daLeft,		false,	prefix +"rqst_file_sav_id",		false,		"",		dfNone,			0, false,	false);
					InitDataProperty(0, cnt++ , dtData,			300,	daLeft,		false,	prefix +"apro_rsn_desc",		false,		"",		dfEngUpKey,		0, true,	false, 	100);
					InitDataProperty(0, cnt++ , dtPopup,		200,	daLeft,		false,	prefix +"apro_file_sav_nm",		false,		"",		dfNone,			0, true,	false);
					InitDataProperty(0, cnt++ , dtHidden,		200,	daLeft,		false,	prefix +"apro_file_sav_id",		false,		"",		dfNone,			0, false,	false);

                    InitDataCombo(0, prefix +"mss_usd_apro_mod_cd", "APP|REJ", "A|R");
                    InitDataValid(0, prefix +"apro_agmt_seq",	vtNumericOnly);
                    InitDataValid(0, prefix +"apro_rsn_desc",	vtEngOther,   "0123456789 ");

					CellFontColor(0, prefix +"mss_usd_apro_mod_cd") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0, prefix +"apro_agmt_cty_cd") = LSE_MANDATORY_FONT_COLOR;
					CellFontColor(0, prefix +"apro_agmt_seq") = LSE_MANDATORY_FONT_COLOR;

                    ShowButtonImage = 1;
                    SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";

               }
                break;

        }
    }

    /**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "combo1":
	        	with(comboObj) {
	            	DropHeight = 130;
	            	MultiSelect = false;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	SelectBackColor = "#eeeeee";
	            	SelectFontColor = "#000000";
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
			case IBCREATE:
				//Request Number Combo Item Setting
	        	sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH02;
				var sXml = sheetObj.GetSearchXml("EES_LSE_0028GS.do",FormQueryString(formObj));
		        sheetObj.WaitImageVisible = true;

				if(sXml != "") {
					if ( ComGetEtcData(sXml, "rqst_no") != "" ) {
						comboObjects[0].RemoveAll();
						comboObjects[0].InsertItem(0, '');
						LseComXml2ComboItem(sXml, comboObjects[0], "rqst_no", "rqst_no", "|");
					} else {
						comboObjects[0].RemoveAll();
						comboObjects[0].InsertItem(0, '');
					}
				}

	            break;

			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.DoSearch4Post("EES_LSE_0028GS.do",FormQueryString(formObj)+ "&IBPREFIX=sheet1_");
					}
				}
				break;

			case IBSEARCH_ASYNC01:
				//Approval No Setting
				sheetObj.WaitImageVisible = false;
				var param = "f_cmd="+SEARCH01+"&ofc_cd="+ComGetObjValue(formObj.apro_ofc_cd);
				var sXml = sheetObj.GetSearchXml("EES_LSE_0028GS.do",param);
				sheetObj.WaitImageVisible = true;

				if(sXml != "") {
					if ( ComGetEtcData(sXml, "apro_no") != undefined ) {
						if ( ComGetEtcData(sXml, "apro_no") != "" ) {
							var vAproNo = ComGetEtcData(sXml, "apro_no");
							ComSetObjValue(formObj.apro_no,  vAproNo);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.apro_no.value = "";
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						formObj.apro_no.value = "";
					}
				}
				break;

			case IBSAVE:			//저장
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = MULTI;
						sheetObj.DoAllSave("EES_LSE_0028GS.do", FormQueryString(formObj));
					}
				}
				break;
        }
    }

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var prefix = sheetObj.id +"_";
			var sName = ColSaveName(Col);

			switch(sName) {
				case prefix +"mss_usd_apro_mod_cd":
					if(Value == "A") {
						CellValue2(Row, prefix +"apro_no") = formObj.apro_no.value;
						CellValue2(Row, prefix +"apro_agmt_cty_cd") = "HHO";
						CellEditable(Row, prefix +"apro_agmt_seq") = true;
					} else {
						CellValue2(Row, prefix +"apro_no") = "";
						CellValue2(Row, prefix +"apro_agmt_cty_cd") = "";
						CellValue2(Row, prefix +"apro_agmt_seq") = "";
		 				CellValue2(Row, prefix +"apro_lstm_cd") = "";
						CellEditable(Row, prefix +"apro_agmt_seq") = false;
					}
					break;
				case prefix +"apro_agmt_seq":
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH03
 								 + "&agmt_cty_cd=HHO"
 								 + "&agmt_seq="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
				 				if (ComGetEtcData(sXml, "agmt_seq") != "") {
				 					CellValue2(Row,Col) = ComGetEtcData(sXml, "agmt_seq");
				 					CellValue(Row, prefix +"apro_lstm_cd") = ComGetEtcData(sXml, "lstm_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01039");
		 							CellValue2(Row,Col) 	  = "";
		 							CellValue2(Row, prefix +"apro_lstm_cd") = "";
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								CellValue2(Row,Col) = "";
 								CellValue2(Row, prefix +"apro_lstm_cd") = "";
 								SelectCell(Row,Col);
 							}
 						}
					} else {
						CellValue2(Row, prefix +"apro_lstm_cd") = "";
					}
					break;
				case prefix +"apro_lstm_cd":
					var vIoModCode = ComGetObjValue(formObj.mss_rqst_io_mod_cd);

					if(CellValue(Row,Col) != "") {
						if(vIoModCode == "O" && Value != "MO") {//MUO
							ComShowCodeMessage("LSE10007", "MO");
							CellValue2(Row,prefix +"apro_agmt_seq") = "";
 							CellValue2(Row,Col) = "";
						} else if(vIoModCode == "I" && Value != "MI") {//MUI
							ComShowCodeMessage("LSE10007", "MI");
							CellValue2(Row,prefix +"apro_agmt_seq") = "";
 							CellValue2(Row,Col) = "";
						} else {
							//do nothing
						}
					}
					break;
			}
 		}
 	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
 			var prefix = sheetObj.id +"_";
			var sName = ColSaveName(Col);

			switch(sName) {
				case prefix +"apro_agmt_seq":	//Agreement No Pop-up
					openPopup("1", Row, Col);
					break;
				case prefix +"apro_file_sav_nm":
					if ( fileUploadFlag ) {
			    		return;
			    	}

			    	var upObj = uploadObjects[0];
				    var fileName = sheetObj.OpenFileDialog("");
				 	//var fileName = sheetObj.OpenFileDialog("", "", "", "Excel|*.xls|Excel|*.XLS|Text|*.txt|Text|*.TXT");
				 	var relativePath = "";
				 	var fileType     = "";
					var badFile = false;

					if ( fileName.indexOf("\\") == -1 ) {
						badFile = true;
					} else {
						relativePath = fileName.substr(fileName.lastIndexOf("\\") + 1);         // File Name
						fileType     = relativePath.substr(relativePath.lastIndexOf(".") + 1);  // File Type

						//TXT, XLS
						//if ( fileType.toUpperCase() != "TXT" && fileType.toUpperCase() != "CSV" ) {
						//	badFile = true;
						//}
					}

				 	if ( !badFile ) {
				 		ComOpenWait(true);
				 		fileUploadFlag = true;
				 		sheetObj.CellValue2(Row, prefix +"apro_file_sav_nm")   = relativePath;

				 		// 기존파일을 모두 지운후 추가함
				 		upObj.Files = "";
				 		var ret  = upObj.AddFile(fileName);
						var sXml = upObj.DoUpload(true);
						uploadFileName = ComGetEtcData(sXml,"filename");
						sheetObj.CellValue2(Row, prefix +"apro_file_sav_id") = uploadFileName;

						fileUploadFlag = false;
						ComOpenWait(false);
				 	} else {
				 		if ( fileName != "<USER_CANCEL>" ) {
				 			ComShowCodeMessage("LSE01097");
				 		}
					}
				 	break;
			}
 		}
    }

    /**
     * 저장처리 전에 유효성 검사를 할수 있도록 발생하는 Event
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
    		var prefix = sheetObj.id +"_";
    		//필수입력 항목 체크처리
			if(CellValue(Row, prefix +"mss_usd_apro_mod_cd") == "") {
				ComShowCodeMessage("LSE01042");
				ValidateFail = true;
		        SelectCell(Row, prefix +"mss_usd_apro_mod_cd");
				return;
			}

			if(CellEditable(Row, prefix +"apro_agmt_seq") && CellValue(Row, prefix +"apro_agmt_seq") == "") {
				ComShowCodeMessage("LSE01006");
				ValidateFail = true;
		        SelectCell(Row, prefix +"apro_agmt_seq");
				return;
			}
    	}
    }

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var prefix = sheetObj.id +"_";
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse(prefix +"rqst_file_sav_nm") = linkFlag;
		}
	}

	/**
	 * sheet1_OnClick
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		var prefix = sheetObj.id +"_";

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case prefix +"rqst_file_sav_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, prefix +"rqst_file_sav_id");
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
    	var formObj = document.form;

    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		// 저장 후 화면 초기화
    		ComResetAll();
    		/* IBMulti Combo Item Setting */
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			/* Approval Number 조회 */
			doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
			ComSetFocus(formObj.combo1);
    	}
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObj = document.form;

    	with(sheetObj) {
			var prefix = sheetObj.id +"_";
	    	ComSetObjValue(formObj.cntr_cnt, SearchRows);
	    	ColFontColor(prefix +"rqst_file_sav_nm") = RgbColor(0, 0, 255);
    	}
    }

	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.rqst_no.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if(Index_Code != "") {
				var param = "f_cmd="  + SEARCH03
						 + "&rqst_no="+ Index_Code;
				WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_0028GS.do",param);
				WaitImageVisible = true;

				if (sXml != "") {
 					if (ComGetEtcData(sXml, "rqst_no") != undefined) {
		 				if (ComGetEtcData(sXml, "rqst_no") != "") {
							doActionIBSheet(sheetObj, formObj, IBSEARCH);

		 					ComSetObjValue(formObj.rqst_no, ComGetEtcData(sXml, "rqst_no"));
							ComSetObjValue(formObj.ref_ofc_cd, ComGetEtcData(sXml, "ref_ofc_cd"));
							ComSetObjValue(formObj.n1st_ref_ofc_cd, ComGetEtcData(sXml, "n1st_ref_ofc_cd"));
							ComSetObjValue(formObj.n2nd_ref_ofc_cd, ComGetEtcData(sXml, "n2nd_ref_ofc_cd"));
							ComSetObjValue(formObj.n3rd_ref_ofc_cd, ComGetEtcData(sXml, "n3rd_ref_ofc_cd"));
							ComSetObjValue(formObj.n4th_ref_ofc_cd, ComGetEtcData(sXml, "n4th_ref_ofc_cd"));
							ComSetObjValue(formObj.rqst_ofc_cd, ComGetEtcData(sXml, "rqst_ofc_cd"));
							ComSetObjValue(formObj.rqst_usr_id, ComGetEtcData(sXml, "rqst_usr_id"));
							ComSetObjValue(formObj.rqst_dt, ComGetEtcData(sXml, "rqst_dt"));
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetObjValue(formObj.mss_rqst_io_mod_cd, ComGetEtcData(sXml, "mss_rqst_io_mod_cd"));
							ComSetObjValue(formObj.diff_rmk, ComGetEtcData(sXml, "diff_rmk"));
							ComSetObjValue(formObj.apro_rmk, "");
 						} else {
 							ComShowCodeMessage("LSE01048");
 							ComResetAll();
 						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
 						ComResetAll();
					}
				}
			} else {
				ComResetAll();
				/* Approval Number 조회 */
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
				ComSetFocus(comboObj);
			}
			sheetObj.ColHidden("sheet1_agmt_no") = ComGetObjValue(formObj.mss_rqst_io_mod_cd) == "I";
		}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
    	}

    	return;
    }

  	/**
     * Agreement Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
    	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var formObj = document.form;
				var prefix = sheetObjects[sheetIdx].id +"_";
				var vLeaseTerm = aryPopupData[0][6];
				var vIoModCode = ComGetObjValue(formObj.mss_rqst_io_mod_cd);

				if(vIoModCode == "O" && vLeaseTerm != "MO") {//MUO
					ComShowCodeMessage("LSE10007", "MO");
					CellValue2(Row,prefix +"apro_agmt_seq") = "";
					CellValue2(Row,prefix +"apro_lstm_cd") = "";
				} else if(vIoModCode == "I" && vLeaseTerm != "MI") {//MUI
					ComShowCodeMessage("LSE10007", "MI");
					CellValue2(Row,prefix +"apro_agmt_seq") = "";
					CellValue2(Row,prefix +"apro_lstm_cd") = "";
				} else {
					CellValue2(Row, prefix +"apro_agmt_seq") = aryPopupData[0][4];
					CellValue2(Row, prefix +"apro_lstm_cd")  = aryPopupData[0][6];
				}
			}
		}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    			case IBSEARCH:      //조회
	    			if ( formObj.rqst_no.value == "" ) {
						ComShowCodeMessage("LSE01077");
						ComSetFocus(formObj.combo1);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
    		}
        }

        with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			return true;
	    			break;
	    		default : 	//do nothing
    		}
    	}

        return true;
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

	/* 개발자 작업  끝 */