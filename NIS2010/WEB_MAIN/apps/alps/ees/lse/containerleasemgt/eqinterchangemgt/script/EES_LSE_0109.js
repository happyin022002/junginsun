/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EES_LSE_0109.js
 *@FileTitle : EQ interchange Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.12
 *@LastModifier : 채창호
 *@LastVersion : 1.0
 * 2015.05.12 채창호
 * 1.0 Creation
 * 
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
     * @class EES_LSE_0109 : EES_LSE_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0109() {
    	this.processButtonClick = processButtonClick;
    	this.setSheetObject     = setSheetObject;
    	this.setComboObject     = setComboObject;
    	this.loadPage           = loadPage;
    	this.initSheet          = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet    = doActionIBSheet;
    	this.setTabObject       = setTabObject;
    	this.validateForm       = validateForm;
    	this.obj_change         = obj_change;
    	this.obj_keypress       = obj_keypress;
    	this.validateForm       = validateForm;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnBlur 			= combo1_OnBlur;
    	this.combo1_OnKeyDown 		= combo1_OnKeyDown;
    }

    /* 개발자 작업	*/
  //공통전역변수
  var sheetObjects = new Array();
  var sheetCnt = 0;

  //Combo Object Array
  var comboObjects = new Array();
  var comboCnt = 0;

  var arrTpSz  = new Array();
  var arrTpSz2 = new Array();

  //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  document.onclick = processButtonClick;

  function initControl() {
  	var formObj = document.form;
  	axon_event.addListenerForm('click','obj_click',formObj);         //- 변경될때.
  	axon_event.addListenerForm('change','obj_change',formObj);       //- 변경될때.
  	axon_event.addListenerFormat('keypress','obj_keypress',formObj); //- 키 눌렸을때
  	axon_event.addListenerFormat('blur','obj_blur',formObj);         //- 포커스 나갈때
  	axon_event.addListenerFormat('focus','obj_focus',formObj);       //- 포커스 들어갈때
  	axon_event.addListenerForm('keydown', 'obj_keydown',  formObj);   //- 키 눌렸을때
  }

  // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
  function processButtonClick(){
  	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
  	var sheetObject1 = sheetObjects[0];
  	/*******************************************************/
  	var formObject = document.form;

  	try {
  		var srcObj  = window.event.srcElement;
  		var srcName = window.event.srcElement.getAttribute("name");

  		switch(srcName) {

  		case "btn_Retrieve":
  			if ( srcObj.style.filter == "" ) {
  				sheetObject1.RemoveAll();
  				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			}
  			break;
  		case "btn_Save":
  			if ( srcObj.style.filter == "" ) {
  			    doActionIBSheet(sheetObjects[0], document.form,IBSAVE);
  			}
  			break;
  		case "Cancel":
  			if ( srcObj.style.filter == "" ) {
  			    doActionIBSheet(sheetObjects[0], document.form,IBDELETE);
  			}
  			break;
  		case "btn_New":
  			sheetObject1.RemoveAll();
  			formObject.lstm_cd[0].selected = true;
  			formObject.loc_tp[2].selected = true;
  			comboObjects[0].RemoveAll();
  			formObject.loc_fm.value       = "";
  			formObject.loc_to.value       = "";
  			formObject.vndr_seq.value = "";
			formObject.vndr_nm.value  = "";
            for(var i = 1 ; i < comboObjects[1].GetCount(); i++ ){
		        comboObjects[1].CheckIndex(i)=false;
			}
			comboObjects[1].Text ="";
	    	ComBtnDisable("btn_Save");
			ComBtnDisable("Cancel");

  			break;
  		case "btns_search2":     // lessor
  			if ( srcObj.style.filter == "" ) {
  				openPopup("3");
  			}
  			break;
  		case "btns_search3":     // loc_fm
  			if ( srcObj.style.filter == "" ) {
  				openPopup("1");
  			}
  			break;
  		case "btns_search4":     // loc_to
  			if ( srcObj.style.filter == "" ) {
  				openPopup("2");
  			}
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
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
  function loadPage() {

  	for(i=0;i<sheetObjects.length;i++){

  		//khlee-시작 환경 설정 함수 이름 변경
  		ComConfigSheet (sheetObjects[i] );

  		initSheet(sheetObjects[i],i+1);
  		//khlee-마지막 환경 설정 함수 추가
  		ComEndConfigSheet(sheetObjects[i]);
  	}

  	initControl();

  	/* IBMultiCombo 초기화 */
  	for ( var k = 0 ; k < comboObjects.length ; k++ ) {
  		initCombo(comboObjects[k], k+1);
  	}
  }

  function sheet1_OnLoadFinish(){
  	/* IBMulti Combo Item Setting */
  	doActionIBSheet(sheetObjects[0], document.form,IBSEARCH_ASYNC03);

	ComBtnDisable("btn_Save");
	ComBtnDisable("Cancel");

  ///	comboObjects[1].CheckIndex(0) = true;

  }
  /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
  function initSheet(sheetObj,sheetNo) {

  	var cnt = 0;
  	var sheetid = sheetObj.id;

  	switch(sheetid) {
  	case "sheet1":
  		with (sheetObj) {

  			// 높이 설정
  			style.height = 398;
  			//전체 너비 설정
  			SheetWidth = 984;//mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
		    MergeSheet = msPrevColumnMerge + msHeaderOnly;
 			//MergeSheet = msHeaderOnly;
 			//전체Edit 허용 여부 [선택, Default false]
  			Editable = true;
 			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
 			InitRowInfo( 1, 1, 15, 100);
			var HeadTitle = "|Sel.|Req No|SML is|AGMT NO|SP Code|Lessor|From|To|T/Size|Auth Vol|Free Days|PUC|PCR|Auth No|Auth seq|req_seq}";
  			
  			var headCount   = ComCountHeadTitle(HeadTitle);
  			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  			InitColumnInfo(headCount, 0, 0, true);

  			// 해더에서 처리할 수 있는 각종 기능을 설정한다
  			InitHeadMode(true, true, true, true, false,false)

  			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  			InitHeadRow(0, HeadTitle , true);

  			
  			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtCheckBox,		50,	daCenter,	true,	"chk");
			InitDataProperty(0, cnt++ , dtData,		   100,	daCenter,	true,	"lse_itchg_rqst_no",    false,	"",	dfNone,	    0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"lstm_cd",			    false,	"",	dfNone,  	0,	false,		false);
			InitDataProperty(0, cnt++ , dtPopupEdit,	80,	daCenter,	true,	"agmt_seq",			    false,	"",	dfNone,	    0,	true,		true ,6);
			InitDataProperty(0, cnt++ , dtData,			60,	daCenter,	true,	"lr_vndr_seq",			false,	"",	dfNone,	    0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,daLeft,		true,	"vndr_abbr_nm",		    false,	"",	dfNone,	    0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			75,	daCenter,	true,	"fm_loc_cd",			false,	"",	dfNone,	    0,	false,		false);					
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"to_loc_cd",			false,	"",	dfNone,	    0,	false,		false);					
	    	InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,	    0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,			70,	daRight,	true,	"lse_itchg_auth_qty",	false,	"",	dfInteger,	0,	true,		true, 6);
			InitDataProperty(0, cnt++ , dtData,			70,	daCenter,	true,	"lse_free_dys",			false,	"",	dfInteger, 	0,	true,		true, 3);
     		InitDataProperty(0, cnt++ , dtData,			75,	daCenter,	true,	"pkup_ut_amt",			false,	"",	dfInteger,	2,	true,		true ,18);
			InitDataProperty(0, cnt++ , dtData,			75,	daRight,	true,	"pkup_cr_amt",			false,	"",	dfInteger,	2,	true,		true),18;
			
			InitDataProperty(0, cnt++ , dtHidden,		75,	daRight,	true,	"lse_itchg_auth_no",	false,	"",	dfNone,	    0,	true,		true);					
			InitDataProperty(0, cnt++ , dtHidden,		65,	daRight,	true,	"lse_itchg_auth_seq",	false,	"",	dfInteger,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtHidden,		65,	daRight,	true,	"lse_itchg_rqst_seq",	false,	"",	dfInteger,	0,	false,		false);
		
			InitDataValid(0, "agmt_seq", vtNumericOnly);
  			SelectBackColor = LSE_SELECT_BACK_COLOR;
 			//FrozenCols = 5;

  		}
  		break;

  	}
  }

  //Sheet관련 프로세스 처리
  function doActionIBSheet(sheetObj,formObj,sAction) {

  	switch(sAction) {
	  	case IBSEARCH:      //조회
		  	if(validateForm(sheetObj,formObj,sAction)){
		  		if (sheetObj.id == "sheet1"){
		  			formObj.f_cmd.value = SEARCH;

		  			sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
		  			sheetObj.DoSearch("EES_LSE_0109GS.do",FormQueryString(formObj));

//		  			for(var i = 0 ; i <= sheetObjects[0].lastRow; i++){
//		  				/*if(sheetObjects[0].CellValue( i , "inv_sts_cd") == "C" ){
//		  					sheetObjects[0].CellEditable(i, "cancel_flag") = true;
//		  				}else{
//		  					sheetObjects[0].CellEditable(i, "cancel_flag") = false;
//		  				}*/
//						
//		  			}
		  			ComBtnEnable("btn_Save");
					ComBtnEnable("Cancel");
		  			ComOpenWait(false);
		  		}
		  	}
		  	break;

	  	case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					formObj.current_auth.value = comboObjects[0].Text;
					formObj.f_cmd.value = MULTI;
					var sParam = sheetObj.GetSaveString();
					sParam += "&" + FormQueryString(formObj);
					ComOpenWait(true);
					var sXml   = sheetObj.GetSaveXml("EES_LSE_0109GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}
			}
			break;
		case IBDELETE:        //저장
			if(validateForm(sheetObj,formObj,sAction)) {
				if ( sheetObj.id == "sheet1") {
					formObj.current_auth.value = comboObjects[0].Text;
					formObj.f_cmd.value = MULTI01;
					var sParam = sheetObj.GetSaveString();
					sParam += "&" + FormQueryString(formObj);
					ComOpenWait(true);
					var sXml   = sheetObj.GetSaveXml("EES_LSE_0109GS.do", sParam);
					ComOpenWait(false);
					sheetObj.LoadSaveXml(sXml);
				}
			}
			break;
			
		case IBSEARCH_ASYNC01:	// Location 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var vLocTp = "LCC";
						var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp +"&loc_cd="+ComGetObjValue(formObj.loc_fm);
						sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
								var vLocCd = "";
								switch (vLocTp) {
									case "RCC":
										vLocCd = ComGetEtcData(sXml, "rcc_cd");
										break;

									case "LCC":
										vLocCd = ComGetEtcData(sXml, "lcc_cd");
										break;

									case "SCC":
										vLocCd = ComGetEtcData(sXml, "scc_cd");
										break;
									case "ECC":
										vLocCd = ComGetEtcData(sXml, "ecc_cd");
										break;
								}

								formObj.loc_fm.value = vLocCd;
								if(formObj.loc_fm.className == "input1") {
									ComSetNextFocus(formObj.loc_fm);
								} else {
									ComSetFocus(comboObjects[1]);
								}
							} else {
								ComShowCodeMessage("LSE01037");
								formObj.loc_fm.value = "";
								ComSetFocus(formObj.loc_fm);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.loc_fm.value = "";
							ComSetFocus(formObj.loc_fm);
						}
					}
				}
			}
		break;
		
		case IBSEARCH_ASYNC02:	// Location 조회
			if(validateForm(sheetObj,formObj,sAction)) {}
				if ( sheetObj.id == "sheet1") {
					var vLocTp = formObj.loc_tp.value == "RCC" ? "RCC" : formObj.loc_tp.value == "LCC" ? "LCC" : formObj.loc_tp.value == "SCC" ? "SCC" :formObj.loc_tp.value == "ECC" ? "ECC" : "CN";
					if(vLocTp != 'CN'){
					var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
							  +"&loc_cd="+ComGetObjValue(formObj.loc_to);
					}else {
						var param = "f_cmd="+SEARCH10+"&loc_tp="+ vLocTp
						  +"&loc_cd="+ComGetObjValue(formObj.loc_to);	
					}
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
				sheetObj.WaitImageVisible = true;

				if ( sXml != "" ) {
					if(vLocTp != 'CN'){
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "RCC":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;
		
										case "LCC":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;
		
										case "SCC":
											vLocCd = ComGetEtcData(sXml, "scc_cd");
											break;
										case "ECC":
											vLocCd = ComGetEtcData(sXml, "ecc_cd");
											break;
									}
		
									formObj.loc_to.value = vLocCd;
									if(formObj.loc_to.className == "input1") {
										ComSetNextFocus(formObj.loc_to);
									} else {
										ComSetFocus(comboObjects[1]);
									}
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_to.value = "";
									ComSetFocus(formObj.loc_to);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_to.value = "";
								ComSetFocus(formObj.loc_to);
							}
				}else {
					 if ( ComGetEtcData(sXml, "loc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "loc_cd") != "" ) {
									var vLocCd = "";
									switch (vLocTp) {
										case "CN":
											vLocCd = ComGetEtcData(sXml, "loc_cd");
											break;
									}
		
									formObj.loc_to.value = vLocCd;
									if(formObj.loc_to.className == "input1") {
										ComSetNextFocus(formObj.loc_to);
									} else {
										ComSetFocus(comboObjects[1]);
									}
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_to.value = "";
									ComSetFocus(formObj.loc_to);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_to.value = "";
								ComSetFocus(formObj.loc_to);
							}
						}
					
					}
		}
	break;
		case IBSEARCH_ASYNC03:
	  		/* Lease Term Form Combo Item Setting */
	  		//ComSetObjValue(formObj.f_cmd, SEARCH01);
	  		ComSetObjValue(formObj.f_cmd, SEARCH02);
	  		sheetObj.WaitImageVisible = false;
	  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	  		if ( sXml != "" ) {
	  			//comboObjects[0].InsertItem(0 , 'ALL','ALL');
	  			comboObjects[1].InsertItem(0 , '','');
	  			LseComXml2ComboItem(sXml, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	  		}
	  		//vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
        	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");

	  		break;

	  	case IBSEARCH_ASYNC04:	//조회(Form Lessor No. 입력시)
		  	if ( validateForm(sheetObj, formObj, sAction) ) {
		  		var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
		  		sheetObj.WaitImageVisible = false;
		  		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);

		  		if ( sXml != "" ) {
		  			if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
		  				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
		  				//ComSetObjValue(formObj.abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
		  				ComSetFocus(formObj.vndr_nm);
		  			} else {
		  				ComShowCodeMessage("LSE01019");
		  				formObj.vndr_seq.value = "";
		  				formObj.vndr_nm.value  = "";
		  				ComSetFocus(formObj.vndr_seq);
		  			}
		  		} else {
		  			ComShowCodeMessage("LSE01019");
		  			formObj.vndr_seq.value = "";
		  			formObj.vndr_nm.value  = "";
		  			ComSetFocus(formObj.vndr_seq);
		  		}
		  	}
		  	break;
	 
	  	case IBSEARCH_ASYNC05:      //auth_no list 조회
	  		var vLstmCd  = formObj.lstm_cd.value;
			var vVndrSeq = formObj.vndr_seq.value;
			var vLocfm   = formObj.loc_fm.value;
		//	comboObjects[0].RemoveAll();
	       if(vLstmCd != "" && vVndrSeq != "" && vLocfm != ""){
	  			formObj.f_cmd.value = SEARCH01;
	  			sheetObj.WaitImageVisible = false;
	  			var sXml = sheetObj.GetSearchXml("EES_LSE_0109GS2.do", FormQueryString(formObj));
	  			sheetObj.WaitImageVisible = true;
	  			if ( sXml != "" ) {
	  				ComXml2ComboItem(sXml, comboObjects[0], "auth_no", "auth_no");
	  			}
	  		}
	  		break;
	  		
	  	case IBSEARCH_ASYNC06:      //조회
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH03;
					formObj.agmt_seq.value    = sheetObj.CellValue(curRow , "agmt_seq");
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
					sheetObj.WaitImageVisible = true;
					if ( ComGetEtcData(sXml, "vndr_seq") != undefined ) {
					//if ( ComGetEtcData(sXml, "vndr_abbr_nm") != undefined ) {
						if(curRow != 0){
							//sheetObj.CellValue2(curRow , "lstm")    = ComGetEtcData(sXml, "lstm_cd");
							sheetObj.CellValue2(curRow , "lr_vndr_seq")    = ComGetEtcData(sXml, "vndr_seq");
							sheetObj.CellValue2(curRow , "vndr_abbr_nm") = ComGetEtcData(sXml, "vndr_nm");
							sheetObj.CellValue2(curRow , "lse_free_dys") = Number(ComGetEtcData(sXml, "lse_free_dys"));
							curRow = 0;
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						if(curRow != 0){
							sheetObj.CellValue2(curRow , "agmt_seq") = "";
							sheetObj.CellValue2(curRow , "lr_vndr_seq")    = "";
							sheetObj.CellValue2(curRow , "vndr_abbr_nm") = "";
							sheetObj.CellValue2(curRow , "lse_free_dys") = "";
							sheetObj.SelectCell(curRow , "agmt_seq" , false);
							curRow = 0;
						}
					}
				}
			}
			break;			

  	}
  }

  /**
  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  */
  function validateForm(sheetObj,formObj,sAction){
  	with(sheetObj){
  		with(formObj){
  			switch(sAction) {
  			case IBSEARCH:
  			if(document.form.lstm_cd.value != ""){
  				var vndrseq = formObj.vndr_seq.value;
  				var locfm = formObj.loc_fm.value;
  				if ( vndrseq == ""  || locfm == "" ) {
  					ComShowCodeMessage("LSE01070");
  					ComSetFocus(formObj.vndr_seq);
  					return false;
  				}
  			}
  			
  			if ( comboObjects[0].text == "" ) {
				ComShowCodeMessage("LSE01050");
				ComSetFocus(comboObjects[0]);
				return false;
				break;
			}
  			break;
  			
  			case IBSAVE:
  				var count = 0;
  			    if(sheetObjects[0].RowCount <= 0){
  			    	ComShowCodeMessage("LSE01048");
  			    	return false;
  			    }else{
  			    	for(var i = 1; i <= sheetObjects[0].RowCount ; i++){
  			    		if(sheetObjects[0].CellValue(i, "ibflag") == "U"){
							count++;
					
						}
  			    	}
  			    	
  			    	if(count == 0 ){
  			    		ComShowCodeMessage("LSE10010");
  			    		return false;
  			    	}
  			    }
  			    break;
  			    
  			case IBDELETE:
  				var count = 0;
  			    if(sheetObjects[0].RowCount <= 0){
  			    	ComShowCodeMessage("LSE01048");
  			    	return false;
  			    }else{
  			    	for(var i = 1; i <= sheetObjects[0].RowCount ; i++){
  			    		if(sheetObjects[0].CellValue(i, "ibflag") == "U"){
							count++;
						}
  			    	}
  			    	
  			    	if(count == 0 ){
  			    		ComShowCodeMessage("LSE10010");
  			    		return false;
  			    	}
  			    }
  			    break; 

  			}
  		}
  	}
  	return true;
  }


  /**
  * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
  */
  function obj_blur(){
  	var obj = event.srcElement;
  	switch(obj.name){

  	case "vndr_seq":
  		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
  			document.form.vndr_nm.value = "";
  			//document.form.abbr_nm.value = "";
  		}
		ComSetFocus(formObj.loc_fm);
		//formObj.loc_fm.focus();
  		break;
  	default:
  		//Validation 전체 체크(길이,format,최대,최소 등등)
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
  			DropHeight = 200;
  			MultiSelect = true;
  			//MaxSelect = 1;
  			MultiSeparator = ",";
  			Style = 0;
  			UseAutoComplete = true;
  			//영문(대)+특수문자,숫자 - TP/SZ
  			ValidChar(2,3);
  		}
  		break;
  	}
  }

  /**
   * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
   * @return
   */
  function combo1_OnCheckClick(comboObj, index, code) {
  	if(index==0) {
  		var bChk = comboObj.CheckIndex(index);
  		if(bChk){
  			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
  				comboObj.CheckIndex(i) = false;
  			}
  		}
  	} else {
  		comboObj.CheckIndex(0) = false;
  	}
  }


  /**
   * combo1_OnBlur
   */
  function combo1_OnBlur(comboObj, Index_Code, Text) {
  	var formObj = document.form;
  	if( comboObj.CheckIndex(0)){
  		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
  			comboObj.CheckIndex(i) = false;
  		}
  		formObj.tpsz_cd.value = "";
  	}else if(comboObj.Text == ""){
  		comboObj.CheckIndex(0) = true;
  		formObj.tpsz_cd.value = "";
  	}else{
  	    formObj.tpsz_cd.value = ComGetObjValue(comboObj);
  	}
  }


  /**
   * combo1_OnKeyDown
   */
  function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
      with(comboObj) {
          if ( KeyCode == 188 &&  comboObj.CheckIndex(0)){
              comboObj.Text = "";
  		  }else if(KeyCode == 13){
 		      sheetObjects[0].RemoveAll();
 			  doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		  }
  	  }
  }


  /**
  * Pop-up Open 부분<br>
  * @param type 1:Agreement(include Ver.) for FORM, 2:Lessor for FORM, 3:Currency for FORM
  * @param object 대상 Object
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  */
  function openPopup(type, Row, Col) {
  	var formObj = document.form;
  	if ( type == "1" ) {
//		switch(formObj.loc_tp.value) {
//			case "0" :	//RCC
//				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
//				break;
//			case "1" :	//LCC
//				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
//				break;
//			case "2" :	//SCC
//				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
//				break;
//			case "3" :	//Yard
//				ComOpenPopup("/hanjin/COM_ENS_061.do",755, 610, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
//			default:	//do nothing
				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_fm", "1,0,1,1,1,1,1", true);
//			break;
	
	
	}else if (type == "2"){
		switch(formObj.loc_tp.value) {
		case "RCC" :	//RCC
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_to", "1,0,1,1,1,1,1", true);
			break;
		case "LCC" :	//LCC
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_to", "1,0,1,1,1,1,1", true);
			break;
		case "SCC" :	//SCC
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_to", "1,0,1,1,1,1,1", true);
			break;
		case "ECC" :	//SCC
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"ecc_cd:loc_to", "1,0,1,1,1,1,1", true);
			break;
		case "CN" :	//contury
			ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"cnt_cd:loc_to", "1,0,1,1,1,1,1", true);
			break
		default:	//do nothing
		}
	}else if (type == "3") {
  		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
  	}else if ( type == "4"){
		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
  	}
 
  }
  /**
  * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
  * @param {arry} returnedValues Pop-up 화면의 Return value array
  * @param Row 대상Object가 IBSheet일 경우 해당 Row index
  * @param Col 대상Object가 IBSheet일 경우 해당 Col index
  * @param 대상IBSheet의 Sheet Array index
  */
  function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
  	var sheetObj = sheetObjects[SheetIdx];
  	var formObj  = document.form;
  	if ( aryPopupData.length > 0 ) {
  		formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
  		formObj.vndr_nm.value  = aryPopupData[0][4];
  		//formObj.abbr_nm.value  = aryPopupData[0][5];
  	}
  }

  /**
  * HTML Control의 Value가 변경되었을 경우 처리한다.
  */
  function obj_change(){
  	var obj      = event.srcElement;
  	var formObj  = document.form;

  	switch(obj.name) {
  	case "vndr_seq":
  		if ( formObj.vndr_seq.value != null && formObj.vndr_seq.value != "" ) {
  			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
  		}
  		break;
	case "loc_fm":		//Location Code
		// if ( ComTrim(obj.value) != "" ) {
			 var strLocFm = formObj.loc_fm.value;
			  if(strLocFm.length == 5) {
				  	doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
				  	doActionIBSheet(sheetObjects[0], formObj ,IBSEARCH_ASYNC05);
				}
	 //	 }
		 break;
		
	case "loc_to":		//Location Code
			 if ( ComTrim(obj.value) != "" ) {
				  if(obj.maxLength == 5) {
					  	doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
			    	}
				}
	    break;		 
	case "loc_tp":  //Location group
		formObj.loc_to.value = "";
  	    break;
 	 }
  }
  /**
  * HTML Control의 키보드 이벤트 방 포멧처리 한다.
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
//  		if(obj.name == "loc_fm") {
//    		ComKeyOnlyAlphabet('uppernum');
//    	} 
//  		
//  		if(obj.name == "loc_to") {
//    		ComKeyOnlyAlphabet('uppernum');
//    	} 
  		ComKeyOnlyAlphabet('upper');
   		//ComKeyOnlyAlphabet('uppernum');
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
* HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){
	case "lstm_cd":
		break;
	case "vndr_seq":
		if ( document.form.vndr_seq.value == null || document.form.vndr_seq.value == "" ) {
			document.form.vndr_nm.value = "";
			//document.form.abbr_nm.value = "";
		}
		break;
	case "loc_fm":		//Location Code
		// if ( ComTrim(obj.value) != "" ) {
			 var strLocFm = formObj.loc_fm.value;
			  if(strLocFm.length == 5) {
				  	doActionIBSheet(sheetObjects[0], formObj ,IBSEARCH_ASYNC05);
				}
	 	// }
		 break;
	default:
		//Validation 전체 체크(길이,format,최대,최소 등등)
		break;
	}
}

/**
* sheet1_OnSaveEnd
* 그리드 저장후 이벤트 처리
* 그리드 agmt no 변경시 정합성 체크 및 Lessro ABBR 조회
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var formObj  = document.form;
	if ( ErrMsg == "" ) {
		ComShowCodeMessage("LSE10001");
	} else {
		ComShowMessage(ErrMsg);
	}
	ComBtnDisable("btn_Save");
	ComBtnDisable("Cancel");
	
	doActionIBSheet(sheetObjects[0], formObj ,IBSEARCH);
    doActionIBSheet(sheetObjects[0], formObj ,IBSEARCH_ASYNC05);
    comboObjects[0].Text = formObj.current_auth.value;
}

  /**
  * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
  */
  function obj_focus(){
  	var obj  = event.srcElement;
  	if( obj.readOnly ) {
  		ComSetNextFocus(obj);
  	} else {
  		//마스크구분자 없애기
  		ComClearSeparator(event.srcElement);
  	}
  }
  /**
  * Key-Down Event 처리
  */
  function obj_keydown() {
  	var obj      = event.srcElement;
  	var vKeyCode = event.keyCode;
  	var formObj  = document.form;
  	var srcObj  = window.event.srcElement;
  	if ( vKeyCode == 13 ) {
  		switch(obj.name) {
  		    case "loc_fm":
  		    default :
  			    if ( srcObj.style.filter == "" ) {
  				    sheetObjects[0].RemoveAll();
  				    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  			    }
  	    }
  	}
  }
  
   /**
   * sheet2_OnChange
   * 그리드 변경시 이벤트 처리
   */
  function sheet1_OnChange(sheetObj,Row, Col, Value){
  	var formObj  = document.form;
  	var sName = sheetObj.ColSaveName(Col);
  	
  	switch(sName){
  		case "agmt_seq":
			if( sheetObj.CellValue(Row , "agmt_seq") != "" ){
				curRow = Row;
				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC06);
				//ComBtnDisable("btn_Creation");
			}
  			break;
 		default:
  			break;
  	
  	}

  }  
  
  function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {	
				sheetObjects[0].CellValue2(Row, "agmt_seq") = Number(aryPopupData[0][4]);
				sheetObjects[0].CellValue2(Row, "lr_vndr_seq") = Number(aryPopupData[0][7]);
				sheetObjects[0].CellValue2(Row, "vndr_abbr_nm") = aryPopupData[0][8];
				sheetObjects[0].CellValue2(Row, "lse_free_dys") = Number(aryPopupData[0][11]);
				//CellValue(Row, "ref_no") = aryPopupData[0][5];
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
  		var sName = ColSaveName(Col);

  		switch(sName) {			
	  		case "agmt_seq":	//Agreement No Pop-up
	  		openPopup("4", Row, Col);
	  		break;			
  		}
  	}
  }  
   /* 개발자 작업  끝 */